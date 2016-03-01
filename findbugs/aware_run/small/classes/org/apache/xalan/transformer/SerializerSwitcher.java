package org.apache.xalan.transformer;
public class SerializerSwitcher {
    public static void switchSerializerIfHTML(org.apache.xalan.transformer.TransformerImpl transformer,
                                              java.lang.String ns,
                                              java.lang.String localName)
          throws javax.xml.transform.TransformerException { if (null ==
                                                                  transformer)
                                                                return;
                                                            if ((null ==
                                                                   ns ||
                                                                   ns.
                                                                   length(
                                                                     ) ==
                                                                   0) &&
                                                                  localName.
                                                                  equalsIgnoreCase(
                                                                    "html")) {
                                                                if (null !=
                                                                      transformer.
                                                                      getOutputPropertyNoDefault(
                                                                        javax.xml.transform.OutputKeys.
                                                                          METHOD))
                                                                    return;
                                                                java.util.Properties prevProperties =
                                                                  transformer.
                                                                  getOutputFormat(
                                                                    ).
                                                                  getProperties(
                                                                    );
                                                                org.apache.xalan.templates.OutputProperties htmlOutputProperties =
                                                                  new org.apache.xalan.templates.OutputProperties(
                                                                  org.apache.xml.serializer.Method.
                                                                    HTML);
                                                                htmlOutputProperties.
                                                                  copyFrom(
                                                                    prevProperties,
                                                                    true);
                                                                java.util.Properties htmlProperties =
                                                                  htmlOutputProperties.
                                                                  getProperties(
                                                                    );
                                                                try {
                                                                    org.apache.xml.serializer.Serializer oldSerializer =
                                                                      null;
                                                                    if (null !=
                                                                          oldSerializer) {
                                                                        org.apache.xml.serializer.Serializer serializer =
                                                                          org.apache.xml.serializer.SerializerFactory.
                                                                          getSerializer(
                                                                            htmlProperties);
                                                                        java.io.Writer writer =
                                                                          oldSerializer.
                                                                          getWriter(
                                                                            );
                                                                        if (null !=
                                                                              writer)
                                                                            serializer.
                                                                              setWriter(
                                                                                writer);
                                                                        else {
                                                                            java.io.OutputStream os =
                                                                              oldSerializer.
                                                                              getOutputStream(
                                                                                );
                                                                            if (null !=
                                                                                  os)
                                                                                serializer.
                                                                                  setOutputStream(
                                                                                    os);
                                                                        }
                                                                        org.xml.sax.ContentHandler ch =
                                                                          serializer.
                                                                          asContentHandler(
                                                                            );
                                                                        transformer.
                                                                          setContentHandler(
                                                                            ch);
                                                                    }
                                                                }
                                                                catch (java.io.IOException e) {
                                                                    throw new javax.xml.transform.TransformerException(
                                                                      e);
                                                                }
                                                            }
    }
    private static java.lang.String getOutputPropertyNoDefault(java.lang.String qnameString,
                                                               java.util.Properties props)
          throws java.lang.IllegalArgumentException {
        java.lang.String value =
          (java.lang.String)
            props.
            get(
              qnameString);
        return value;
    }
    public static org.apache.xml.serializer.Serializer switchSerializerIfHTML(java.lang.String ns,
                                                                              java.lang.String localName,
                                                                              java.util.Properties props,
                                                                              org.apache.xml.serializer.Serializer oldSerializer)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.serializer.Serializer newSerializer =
          oldSerializer;
        if ((null ==
               ns ||
               ns.
               length(
                 ) ==
               0) &&
              localName.
              equalsIgnoreCase(
                "html")) {
            if (null !=
                  getOutputPropertyNoDefault(
                    javax.xml.transform.OutputKeys.
                      METHOD,
                    props))
                return newSerializer;
            java.util.Properties prevProperties =
              props;
            org.apache.xalan.templates.OutputProperties htmlOutputProperties =
              new org.apache.xalan.templates.OutputProperties(
              org.apache.xml.serializer.Method.
                HTML);
            htmlOutputProperties.
              copyFrom(
                prevProperties,
                true);
            java.util.Properties htmlProperties =
              htmlOutputProperties.
              getProperties(
                );
            {
                if (null !=
                      oldSerializer) {
                    org.apache.xml.serializer.Serializer serializer =
                      org.apache.xml.serializer.SerializerFactory.
                      getSerializer(
                        htmlProperties);
                    java.io.Writer writer =
                      oldSerializer.
                      getWriter(
                        );
                    if (null !=
                          writer)
                        serializer.
                          setWriter(
                            writer);
                    else {
                        java.io.OutputStream os =
                          serializer.
                          getOutputStream(
                            );
                        if (null !=
                              os)
                            serializer.
                              setOutputStream(
                                os);
                    }
                    newSerializer =
                      serializer;
                }
            }
        }
        return newSerializer;
    }
    public SerializerSwitcher() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "YqBFceD2j5VR7j/SbK71ZvpUDzRbuXmJ9qZWsLe1go0BnCgEnj7Q4kFF5XUv" +
       "WNHvb/ttx7eP7IbISQcnSJ86KOIfkH5tfuuwnzj2luYuRTxRNT/bi5zYImuc" +
       "CLg7zO8OtncJbZ1MP6hyosKOoQ4i4MzCsyZbC3Z/XI1gtxSYD0yPVH5PNoik" +
       "z7sPVP7uF6PyCDjvB9ZCibRb631vuzvEoYZ2rkW4wMuuTi0tzLHf88KqfWRb" +
       "lWrbtmYodiMw4jRLjI4r9X1Z844IuNfQIjaO/DSD2qyzYjxM05XYjrYM5Up8" +
       "50+gxFdlg4X0eepAiU/9H9rtmRzqzNYEs+aJQ4Vc2TXj1ODCI/PZuZXK6X74" +
       "5prNXpc5wK9nza/c0hCz2Y9s9fWhF6OvJALuuvGSLKvy33PDjf3mlln9zNOX" +
       "bnvl0+Jf5fdERzfBF2jgNj227d2i7E7/nB9oupVLc2FTovXzn9+KgPteyN8j" +
       "4CU7bzn7v7nBfCYCLp/EjICz+e8u3Ccj4OIWLgLObTq7IJ+KgNMpSNb9Xf8m" +
       "hd1NlTo5dfz4OFL4XT9O4TsnzqPHzon8fycOY3q8+e+J6+pnn6aYtz9f+cTm" +
       "Qku1lfU6o3IbDZzf3K0dnQsP35LaIa1z5NUf3vG5C68+PMPu2DC8tfod3h68" +
       "+Y0R7vhRfsez/sIrf/8Nn3z6m3md+X8BOmp4vtQiAAA=");
}
