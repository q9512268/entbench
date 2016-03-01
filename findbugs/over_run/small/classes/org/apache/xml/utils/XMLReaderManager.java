package org.apache.xml.utils;
public class XMLReaderManager {
    private static final java.lang.String NAMESPACES_FEATURE = "http://xml.org/sax/features/namespaces";
    private static final java.lang.String NAMESPACE_PREFIXES_FEATURE = "http://xml.org/sax/features/namespace-prefixes";
    private static final org.apache.xml.utils.XMLReaderManager m_singletonManager =
      new org.apache.xml.utils.XMLReaderManager(
      );
    private static javax.xml.parsers.SAXParserFactory m_parserFactory;
    private java.lang.ThreadLocal m_readers;
    private java.util.Hashtable m_inUse;
    private XMLReaderManager() { super(); }
    public static org.apache.xml.utils.XMLReaderManager getInstance() {
        return m_singletonManager;
    }
    public synchronized org.xml.sax.XMLReader getXMLReader() throws org.xml.sax.SAXException {
        org.xml.sax.XMLReader reader;
        boolean readerInUse;
        if (m_readers ==
              null) {
            m_readers =
              new java.lang.ThreadLocal(
                );
        }
        if (m_inUse ==
              null) {
            m_inUse =
              new java.util.Hashtable(
                );
        }
        reader =
          (org.xml.sax.XMLReader)
            m_readers.
            get(
              );
        boolean threadHasReader =
          reader !=
          null;
        if (!threadHasReader ||
              m_inUse.
              get(
                reader) ==
              java.lang.Boolean.
                TRUE) {
            try {
                try {
                    reader =
                      org.xml.sax.helpers.XMLReaderFactory.
                        createXMLReader(
                          );
                }
                catch (java.lang.Exception e) {
                    try {
                        if (m_parserFactory ==
                              null) {
                            m_parserFactory =
                              javax.xml.parsers.SAXParserFactory.
                                newInstance(
                                  );
                            m_parserFactory.
                              setNamespaceAware(
                                true);
                        }
                        reader =
                          m_parserFactory.
                            newSAXParser(
                              ).
                            getXMLReader(
                              );
                    }
                    catch (javax.xml.parsers.ParserConfigurationException pce) {
                        throw pce;
                    }
                }
                try {
                    reader.
                      setFeature(
                        NAMESPACES_FEATURE,
                        true);
                    reader.
                      setFeature(
                        NAMESPACE_PREFIXES_FEATURE,
                        false);
                }
                catch (org.xml.sax.SAXException se) {
                    
                }
            }
            catch (javax.xml.parsers.ParserConfigurationException ex) {
                throw new org.xml.sax.SAXException(
                  ex);
            }
            catch (javax.xml.parsers.FactoryConfigurationError ex1) {
                throw new org.xml.sax.SAXException(
                  ex1.
                    toString(
                      ));
            }
            catch (java.lang.NoSuchMethodError ex2) {
                
            }
            catch (java.lang.AbstractMethodError ame) {
                
            }
            if (!threadHasReader) {
                m_readers.
                  set(
                    reader);
                m_inUse.
                  put(
                    reader,
                    java.lang.Boolean.
                      TRUE);
            }
        }
        else {
            m_inUse.
              put(
                reader,
                java.lang.Boolean.
                  TRUE);
        }
        return reader;
    }
    public synchronized void releaseXMLReader(org.xml.sax.XMLReader reader) {
        if (m_readers.
              get(
                ) ==
              reader &&
              reader !=
              null) {
            m_inUse.
              remove(
                reader);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfZAUxRXv3YP74rgvBE7EE48Dc3zsBkWoeEY9L3dwugeb" +
       "u4MiR3SZm+29HZidGWZ67/ZAolhBKWNZRsAYI1TKYKIUipUKSTSRkKQStYyh" +
       "MFbit0aqokatkj8Uo0nMe90zOx/7IRjLq5revun3Xvf76N973XPwXTLZMkmb" +
       "IWlJKcImDGpF4tiPS6ZFk92qZFlD8DYh3/L3Xdef+kvN9jCpHCb1acnqlyWL" +
       "9ipUTVrD5FxFs5ikydRaRWkSOeImtag5JjFF14bJdMXqyxiqIiusX09SJFgr" +
       "mTHSJDFmKiNZRvtsAYycF+OrifLVRLuCBJ0xUifrxoTLMMvH0O0ZQ9qMO5/F" +
       "SGNsozQmRbNMUaMxxWKdOZMsNHR1YlTVWYTmWGSjerFtiKtiFxeYoe3hhg8+" +
       "vj3dyM0wTdI0nXEVrQFq6eoYTcZIg/u2R6UZazP5FqmIkSkeYkbaY86kUZg0" +
       "CpM6+rpUsPqpVMtmunWuDnMkVRoyLoiR8/1CDMmUMraYOF8zSKhmtu6cGbSd" +
       "k9fWcXdAxT0Lo7u/d23jTytIwzBpULRBXI4Mi2AwyTAYlGZGqGl1JZM0OUya" +
       "NHD4IDUVSVW22N5utpRRTWJZCAHHLPgya1CTz+naCjwJuplZmelmXr0UDyr7" +
       "v8kpVRoFXWe4ugoNe/E9KFirwMLMlASxZ7NM2qRoSR5Hfo68ju1XAwGwVmUo" +
       "S+v5qSZpErwgzSJEVEkbjQ5C8GmjQDpZhxA0eayVEIq2NiR5kzRKE4y0BOni" +
       "YgioarghkIWR6UEyLgm8NCvgJY9/3l116W1btZVamIRgzUkqq7j+KcDUGmAa" +
       "oClqUtgHgrFuQexOacZjO8OEAPH0ALGg+cV1J69Y1Hr0CUFzThGa1SMbqcwS" +
       "8v6R+uOzuzu+UoHLqDZ0S0Hn+zTnuyxuj3TmDECaGXmJOBhxBo8O/PEbNxyg" +
       "b4dJbR+plHU1m4E4apL1jKGo1FxBNWpKjCb7SA3Vkt18vI9UQT+maFS8XZ1K" +
       "WZT1kUkqf1Wp8//BRCkQgSaqhb6ipXSnb0gszfs5gxBSBQ+pg2ceEX/8l5FU" +
       "NK1naFSSJU3R9Gjc1FF/dCjHHGpBPwmjhh7NSRA0izcmLkwsT1wYtUw5qpuj" +
       "UQmiIk2juYzKDWJF1/XHBqiUpGa/pEFImBGMN+MLmymHOk8bD4XAHbODYKDC" +
       "Plqpq8CSkHdnr+w5+VDiKRFouDlsazEyD6aLiOkiMB13phUJTkdCIT7LWTit" +
       "cDi4axNsfEDeuo7Ba67asLOtAiLNGJ8EtkbS+QWZqNtFCAfWE/LB4wOnjj1d" +
       "eyBMwgAiI5CJ3HTQ7ksHIpuZukyTgEelEoMDjtHSqaDoOsjRu8a3r73+y3wd" +
       "XoRHgZMBnJA9jricn6I9uLOLyW24+c0PDt25TXf3uC9lOJmugBOhoy3o06Dy" +
       "CXnBHOlw4rFt7WEyCfAIMJhJsGcA3lqDc/ggpNOBY9SlGhRO6WZGUnHIwdBa" +
       "ljb1cfcND7Ym3j/L3l9kNjxX2JuM/+LoDAPbmSI4MWYCWnC4/+qgsfe5P791" +
       "ETe3kxkaPCl9kLJODxqhsGaOO01uCA6ZlALdy3fFd+159+b1PP6AYm6xCdux" +
       "7QYUAheCmXc8sfn5V1/Z/2zYjVlGqgxTgTqH5vJa4gCZUkZLDHR3QQBnKmx0" +
       "DJv2NRqEpZJSpBGV4i75d8O8JYffua1RBIIKb5w4WvTpAtz3Z19Jbnjq2lOt" +
       "XExIxnTqGs0lExg9zZXcZZrSBK4jt/2Zc7//uLQX0B4Q1lK2UA6ahBuBcK8t" +
       "5fpHeXtRYGwZNu2WN/r9G8xT9iTk2599b+ra946c5Kv1101eZ/dLRqeIL2zm" +
       "5UD8zCDSrJSsNNAtPbrqm43q0Y9B4jBIlKFYsFabgFQ5X2jY1JOrXvjt72ds" +
       "OF5Bwr2kVtWlZK/EdxmpgfCmVhoAMmdcbnt3vBqaRq4qKVAe7XlecU/1ZAzG" +
       "bbvllzN/dulP9r3Co0pE0TmcvdLCci0IiLzmdvfyOy/+4MRvTv2oSmTsjtIA" +
       "FuBr+Wi1OnLj6x8WGJlDV5FqIsA/HD14z6zuy97m/C6GIPfcXGFmAZR1eS88" +
       "kHk/3Fb5hzCpGiaNsl3frpXULO7MYajpLKfohRrYN+6vz0Qx0pnHyNlB/PJM" +
       "G0QvN6NBH6mxPzUAWGejF3vh+ZK9lS8IAlYIIGB+mjHjkihm3ggmYkvKRVNU" +
       "VMBRnMYynPp0BW/n87YDm0Xc1RXYXczA5bzaZrBURZPUAKa0OAsoshAwzKqu" +
       "/p7BeFd3z2Cit6draM1AD2dvgWMPD0E0WUSUtAJmsV2OzUox0SUlY7rLb5FV" +
       "8CywF9JRzCKR07LIYsOkKSUnLDNUzjLYxLDpL2KSjhIrgXI9b5JEfKCnt2+d" +
       "axqkiAfMsOYMzRCDZ5E9+cICMxDeueYzq7WwhGTwdCZhgRNVynTNrrUcT59e" +
       "ZRbQ+9rT13savl0KzxJ7dUtK6D1aXO+wq3dA5eYyQgH4MwkDT6qmgOIJR982" +
       "XtJyVcW4FRnsWhf3kgaUTZ++srxcaYNnmb2uZSWU3SyUxWZBYRlQipuRmkzC" +
       "5H6xME94oR6vSQazIxYbkMb54S8h39q2Y/sFVSeXCaSfU5Tac0686NSyhjkH" +
       "7tcEeXtx4f4T4utbn7pXf+ntsHP6K8YiKK+2+o89uvKNBK/EqrEAH3IQ1FNa" +
       "d5mjnjKw0W/XmeXsagWm55nPNcXhR3+8fOeidfeKhZ5fIum59I98/bXje7cc" +
       "OijKKFwuIwtLXcEU3vtgWT2vzNHANfr7Ky45+taJtdeE7cKnHputOSdap7s4" +
       "PJRGz8d0WeLn9+350iGUPwzNCDpAzFG5ZO+/rr/pudVQvfeR6qymbM7SvqQ/" +
       "oVVZ2RGPR9w7BzfJ2e74BP5C8PwXH3QDvsBfgJlu+/w9J38AN4wcjjMSWgDd" +
       "wM4yz3BntcLTaUdAZ4md9Z2yO6sUN1TlmYSirbFEahnLc9Y7kbfU5lwqVE1/" +
       "jmfvJMtEIa9Fu7MW0zMi38Z1XXXO+V/YXMId12Hz3XwITvOXuwwPCji0JxiA" +
       "+O+OoItvLePiXHHEh2qg0siOqIrsAj7/qySByxaPAz1VMEEwOLfUfRi/y9t/" +
       "4+59ydX3LRFw0Oy/Y+rRspkH//qfP0Xueu3JIlcZNUw3Fqt0jKqeOSssRJUg" +
       "/vTz60K3jF3+zKmKF+9oqSu8hUBJrSXuGBaUBpLgBI/f+M9ZQ5elN5zB9cJ5" +
       "AUMFRT7Qf/DJFfPlO8L8xlNUzQU3pX6mTj+01JoUyjjNDyZtedfORZdFiKia" +
       "ifPr3dluSBWvDu4pVh00lZFY5uD5UJmxh7G5n5Epo5R5HSe74f7ApyGa76yH" +
       "Ly7nr/fnF9/mmCNuLz5+xuZgpM6a0OS0qWtw7k4GDDOzjOwyyv86MOZkHRsl" +
       "WrCMxKIKCncsqHpyMjUw9DjzEWwOw7rAcvnSMp/jvKz+UW7Tn//fNsXimFwO" +
       "z9223nd/phB7pIglS0ksbi3893d8sqfLmPoYNo/DIcykKgWQcG1S9rweN5WM" +
       "wpQxO+tHtzW/uumeNx8UGBc8nAeI6c7dt3wSuW23wDvxPWRuwScJL4/4JiIK" +
       "A2xuylnewqrILJyj941D2351/7abnXrnh4xMGtOVpOvuJ87c3TmwVfDEghcp" +
       "LQWfrsTnFvmhfQ3VM/et+Ru/z8x/EqmDyjSVVVXvOd/TrxSHT04pTv2ioHmZ" +
       "kbOKHaLgTM5/+aJfErSvMVLvp2WAwhnVS3OCkVqXBpKh6HhJ/gFcQILdN4wi" +
       "Z3ZxzZEL+bNi3sTTP83EnkQ61xdw/JOhkymycbtaPrTvqlVbTy67T1yzyqq0" +
       "ZQtKmQJlpbjxzWeb80tKc2RVruz4uP7hmnlOgDSJBbsb9BzPToE9HTLQ07MC" +
       "V5BWe/4m8vn9lx55emflMxDa60lIgoJmfeGFUM7IQipcHytWQEMu5rejnbUn" +
       "Nhz78IVQM793I6Lkbi3HkZB3HXkxnjKMu8Okpo9MhvinOX5b9bUJbYDKY6av" +
       "Hq8c0bNa/utiPYalhPUZt4xt0Kn5t3hND8fZwk1a+OmiVtXHqXklSucZOJCf" +
       "s4bhHeWW/bbY02hpiLVErN8wnDr/WW55w+B77yNsdvwPd77lTxcgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ozrzmzDc5jubyUpQtutlw/TngrtEVmFuhNgqbQvtScVf1VS9N4ebNkZKo2HV" +
       "Be0ItITyrb6lVkkS1jrWYND32+PEsdZrfCTwBGLmqsNsklCsJotISrCtH1vS" +
       "xDGpTc2KF/mwO6PJKjwftLem5PcV2AcBstPus6MKyziZM+A2zWW3PicGS667" +
       "GHY7Y3vrb5sdYTPQ3KCSYJVp1xzypBd37VDJe1m3oTAmtzHZdhX11xItbrQO" +
       "JeLMTDQjtWvWlXQUGr2uHnt4W2ngSshwEWEyoz7d7EWbpVCZzOTtKCI7hDHr" +
       "wUy7nnCuZVU1PWuzyYowKaxDowNxgm/CAeXHcrzJxFVPt3se27WigbBVuh4X" +
       "WnzcVNAARysZmmhzjx+sZLbt0kTLCkzVbVCtmOGYbFarV1Rk3I1qmDg30LjT" +
       "sjnaiVdtbu1lqIc0ulln7rYHnJ3UAS7gs17WMQiKpdd02FcJ1N52VXi18kdc" +
       "e9ES7P6a5xozuS+5AyrR2optLauqoY66+MJBLQCKdmszstJ5jY5ZuMJ4XWK8" +
       "dATgxLNFZ+Z26nBluwoNHRvjrWpP1NFNulHGHVCJoTkQdq/DvsJxSDXuEA3Z" +
       "JhgtQw1Sq1SxVmVZHY8bxMJppB0tTvHJQiLWeseZq83QcLFpFZbhWr6wpnZ/" +
       "u0rFlbgdYDtaqa86srSRme6ARyeTtjt0UqRL72ojftvzZVrw2/1p3cQxrck1" +
       "6YVhxEqVb1PUcIkl9dlO9IkoR+Vqi1661rZmc9G8l1KpK277IWL30lUrl+eq" +
       "LAdCe1i3IrgmqzgMx8xkjrTrk6o9rElEQ1m347Y6bEaY4Q/0ecQv+ok8imuz" +
       "ERy0+s1UbJnipoa1WstKoLTqDRUb7qpVpKrLsMbwW51iarmDSd1m3ukKAS2E" +
       "oxERjZfB1qmjW2TRatetNmUPyUVIKssVOcHmNWtRpblgvrMivKaFHIm1k6C2" +
       "mUYzWx7CPS11/JXRcaZrj2AdTV26EbprbxV+W98Op4SOz21dleCqTOT95XJn" +
       "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");
}
