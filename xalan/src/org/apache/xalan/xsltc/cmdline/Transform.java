/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the  "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
/*
 * $Id: Transform.java 468647 2006-10-28 06:59:33Z minchau $
 */

package org.apache.xalan.xsltc.cmdline;

import java.io.FileNotFoundException;
import java.net.MalformedURLException;
import java.net.UnknownHostException;
import java.util.Vector;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.transform.sax.SAXSource;

import org.apache.xalan.xsltc.TransletException;
import org.apache.xalan.xsltc.compiler.util.ErrorMsg;
import org.apache.xalan.xsltc.DOMEnhancedForDTM;
import org.apache.xalan.xsltc.dom.XSLTCDTMManager;
import org.apache.xalan.xsltc.runtime.AbstractTranslet;
import org.apache.xalan.xsltc.runtime.Constants;
import org.apache.xalan.xsltc.runtime.Parameter;
import org.apache.xalan.xsltc.runtime.output.TransletOutputHandlerFactory;
import org.apache.xml.serializer.SerializationHandler;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import org.apache.xalan.xsltc.StripFilter;
import org.apache.xml.dtm.DTMWSFilter;
import org.apache.xalan.xsltc.dom.DOMWSFilter;

import jrapl.EnergyCheckUtils;

modes {low <: mid; mid <: high; } 

/**
 * @author Jacek Ambroziak
 * @author Santiago Pericas-Geertsen
 * @author G. Todd Miller
 * @author Morten Jorgensen
 */
final public class Transform {

    private SerializationHandler _handler;

    private String[]  _fileNames;
    private String  _className;
    private String  _jarFileSrc;
    private boolean _isJarFileSpecified = false;
    private Vector  _params = null;
    private boolean _uri, _debug;
    private int     _iterations;

    public Transform(String className, String[] fileNames,
		     boolean uri, boolean debug, int iterations) {
	_fileNames = fileNames;
	_className = className;
	_uri = uri;
	_debug = debug;
	_iterations = iterations;

  String tadaptstr = System.getenv("PANDA_TADAPT");
  if (tadaptstr != null && tadaptstr.equals("true")) {
    this.tadapt = true;
  } else {
    this.tadapt = false;
  }

  }

  private boolean tadapt;
  
   public String[] getFileNames(){return _fileNames;}
   public String getClassName(){return _className;}

    public void setParameters(Vector params) {
	_params = params;
    }

    private void setJarFileInputSrc(boolean flag,  String jarFile) {
	// TODO: at this time we do not do anything with this
	// information, attempts to add the jarfile to the CLASSPATH
	// were successful via System.setProperty, but the effects
	// were not visible to the running JVM. For now we add jarfile
	// to CLASSPATH in the wrapper script that calls this program. 
	_isJarFileSpecified = flag;
	// TODO verify jarFile exists...
	_jarFileSrc = jarFile;	
    }

    private void doTransform() {
	try {
            final Class clazz = ObjectFactory.findProviderClass(
                _className, ObjectFactory.findClassLoader(), true);
	    final AbstractTranslet translet = (AbstractTranslet)clazz.newInstance();
            translet.postInitialization();

      // Pass global parameters
      int n = _params.size();
      for (int i = 0; i < n; i++) {
        Parameter param = (Parameter) _params.elementAt(i);
        translet.addParameter(param._name, param._value);
      } 

    for (int l = 0; l < _iterations; l++) {
      for (int k = 0; k < _fileNames.length; k++) {

	    // Create a SAX parser and get the XMLReader object it uses
	    final SAXParserFactory factory = SAXParserFactory.newInstance();
	    try {
		factory.setFeature(Constants.NAMESPACE_FEATURE,true);
	    }
	    catch (Exception e) {
		factory.setNamespaceAware(true);
	    }
	    final SAXParser parser = factory.newSAXParser();
	    final XMLReader reader = parser.getXMLReader();

	    // Set the DOM's DOM builder as the XMLReader's SAX2 content handler
            XSLTCDTMManager dtmManager =
                (XSLTCDTMManager)XSLTCDTMManager.getDTMManagerClass()
                                                .newInstance();

	    DTMWSFilter wsfilter;
	    if (translet != null && translet instanceof StripFilter) {
	        wsfilter = new DOMWSFilter(translet);
            } else {
	        wsfilter = null;
            }

      
        String fileName = _fileNames[k];
        final DOMEnhancedForDTM dom = 
          (DOMEnhancedForDTM) 
            dtmManager.getDTM(
              new SAXSource(
                reader, 
                new InputSource(fileName)
                ), 
                false, 
                wsfilter, 
                true, 
                false, 
                translet.hasIdCall()
                );

        dom.setDocumentURI(fileName);
        translet.prepassDocument(dom);

        // Transform the document
        TransletOutputHandlerFactory tohFactory = 
          TransletOutputHandlerFactory.newInstance();
        tohFactory.setOutputType(TransletOutputHandlerFactory.STREAM);
        tohFactory.setEncoding(translet._encoding);
        tohFactory.setOutputMethod(translet._method);

		    translet.transform(dom, tohFactory.getSerializationHandler());

		  }
    }
  }
  catch (Exception e) {
	    e.printStackTrace();
	    System.err.println(new ErrorMsg(ErrorMsg.RUNTIME_ERROR_KEY)+
			       e.getMessage());
	}
    }

    public static void printUsage() {
	System.err.println(new ErrorMsg(ErrorMsg.TRANSFORM_USAGE_STR));
    }

    public static void main(String[] args) {
	try {
	    if (args.length > 0) {
		int i;
		int iterations = 1;
		boolean uri = false, debug = false;
		boolean isJarFileSpecified = false;
		String  jarFile = null;

		// Parse options starting with '-'
		for (i = 0; i < args.length && args[i].charAt(0) == '-'; i++) {
		    if (args[i].equals("-u")) {
			uri = true;
		    }
		    else if (args[i].equals("-x")) {
			debug = true;
		    }
		    else if (args[i].equals("-j")) {
			isJarFileSpecified = true;	
			jarFile = args[++i];
		    }
		    else if (args[i].equals("-n")) {
			try {
			    iterations = Integer.parseInt(args[++i]);
			}
			catch (NumberFormatException e) {
			    // ignore
			}
		    }
		    else {
			printUsage();
		    }
		}

		// Enough arguments left ?
		if (args.length - i < 2) printUsage();

    String transletName = args[i];
    int numFiles = args.length - (i+1);
    String[] fileNames = new String[numFiles];
    for (int k = i+1; k < args.length; k++) {
      fileNames[k-(i+1)] = args[k]; 
    }

		// Get document file and class name
		Transform handler = new Transform(transletName, fileNames, uri,
		    debug, iterations);
		handler.setJarFileInputSrc(isJarFileSpecified,	jarFile);

		// Parse stylesheet parameters
		Vector params = new Vector();
		for (i += 2; i < args.length; i++) {
		    final int equal = args[i].indexOf('=');
		    if (equal > 0) {
			final String name  = args[i].substring(0, equal);
			final String value = args[i].substring(equal+1);
			params.addElement(new Parameter(name, value));
		    }
		    else {
			printUsage();
		    }
		}

    ENT_Util.initModeFile();
    double[] before = EnergyCheckUtils.getEnergyStats();

		if (i == args.length) {
		    handler.setParameters(params);
		    handler.doTransform();
		}

	  double[] after = EnergyCheckUtils.getEnergyStats();

    ENT_Util.writeModeFile(String.format("Energy: %f %f %f\n", after[0]-before[0], after[1]-before[1], after[2]-before[2]));
	  //ENT_Util.writeModeFile(String.format("Time: %s\n", ENT_Util.elapsedTime()));
	  ENT_Util.closeModeFile();
    EnergyCheckUtils.DeallocProfile();

	    } else {
		printUsage();
	    }

	}
	catch (Exception e) {
	    e.printStackTrace();
	}
    }
}
