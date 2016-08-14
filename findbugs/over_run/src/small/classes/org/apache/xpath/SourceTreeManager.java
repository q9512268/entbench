package org.apache.xpath;
public class SourceTreeManager {
    private java.util.Vector m_sourceTree = new java.util.Vector();
    public void reset() { m_sourceTree = new java.util.Vector(); }
    javax.xml.transform.URIResolver m_uriResolver;
    public void setURIResolver(javax.xml.transform.URIResolver resolver) {
        m_uriResolver =
          resolver;
    }
    public javax.xml.transform.URIResolver getURIResolver() { return m_uriResolver;
    }
    public java.lang.String findURIFromDoc(int owner) { int n = m_sourceTree.
                                                          size(
                                                            );
                                                        for (int i =
                                                               0;
                                                             i <
                                                               n;
                                                             i++) {
                                                            org.apache.xpath.SourceTree sTree =
                                                              (org.apache.xpath.SourceTree)
                                                                m_sourceTree.
                                                                elementAt(
                                                                  i);
                                                            if (owner ==
                                                                  sTree.
                                                                    m_root)
                                                                return sTree.
                                                                         m_url;
                                                        }
                                                        return null;
    }
    public javax.xml.transform.Source resolveURI(java.lang.String base,
                                                 java.lang.String urlString,
                                                 javax.xml.transform.SourceLocator locator)
          throws javax.xml.transform.TransformerException,
        java.io.IOException { javax.xml.transform.Source source =
                                null;
                              if (null !=
                                    m_uriResolver) {
                                  source =
                                    m_uriResolver.
                                      resolve(
                                        urlString,
                                        base);
                              }
                              if (null ==
                                    source) {
                                  java.lang.String uri =
                                    org.apache.xml.utils.SystemIDResolver.
                                    getAbsoluteURI(
                                      urlString,
                                      base);
                                  source =
                                    new javax.xml.transform.stream.StreamSource(
                                      uri);
                              }
                              return source;
    }
    public void removeDocumentFromCache(int n) {
        if (org.apache.xml.dtm.DTM.
              NULL ==
              n)
            return;
        for (int i =
               m_sourceTree.
               size(
                 ) -
               1;
             i >=
               0;
             --i) {
            org.apache.xpath.SourceTree st =
              (org.apache.xpath.SourceTree)
                m_sourceTree.
                elementAt(
                  i);
            if (st !=
                  null &&
                  st.
                    m_root ==
                  n) {
                m_sourceTree.
                  removeElementAt(
                    i);
                return;
            }
        }
    }
    public void putDocumentInCache(int n,
                                   javax.xml.transform.Source source) {
        int cachedNode =
          getNode(
            source);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              cachedNode) {
            if (!(cachedNode ==
                    n))
                throw new java.lang.RuntimeException(
                  "Programmer\'s Error!  " +
                  "putDocumentInCache found reparse of doc: " +
                  source.
                    getSystemId(
                      ));
            return;
        }
        if (null !=
              source.
              getSystemId(
                )) {
            m_sourceTree.
              addElement(
                new org.apache.xpath.SourceTree(
                  n,
                  source.
                    getSystemId(
                      )));
        }
    }
    public int getNode(javax.xml.transform.Source source) {
        java.lang.String url =
          source.
          getSystemId(
            );
        if (null ==
              url)
            return org.apache.xml.dtm.DTM.
                     NULL;
        int n =
          m_sourceTree.
          size(
            );
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xpath.SourceTree sTree =
              (org.apache.xpath.SourceTree)
                m_sourceTree.
                elementAt(
                  i);
            if (url.
                  equals(
                    sTree.
                      m_url))
                return sTree.
                         m_root;
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    public int getSourceTree(java.lang.String base,
                             java.lang.String urlString,
                             javax.xml.transform.SourceLocator locator,
                             org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        try {
            javax.xml.transform.Source source =
              this.
              resolveURI(
                base,
                urlString,
                locator);
            return getSourceTree(
                     source,
                     locator,
                     xctxt);
        }
        catch (java.io.IOException ioe) {
            throw new javax.xml.transform.TransformerException(
              ioe.
                getMessage(
                  ),
              locator,
              ioe);
        }
    }
    public int getSourceTree(javax.xml.transform.Source source,
                             javax.xml.transform.SourceLocator locator,
                             org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        int n =
          getNode(
            source);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              n)
            return n;
        n =
          parseToNode(
            source,
            locator,
            xctxt);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              n)
            putDocumentInCache(
              n,
              source);
        return n;
    }
    public int parseToNode(javax.xml.transform.Source source,
                           javax.xml.transform.SourceLocator locator,
                           org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        try {
            java.lang.Object xowner =
              xctxt.
              getOwnerObject(
                );
            org.apache.xml.dtm.DTM dtm;
            if (null !=
                  xowner &&
                  xowner instanceof org.apache.xml.dtm.DTMWSFilter) {
                dtm =
                  xctxt.
                    getDTM(
                      source,
                      false,
                      (org.apache.xml.dtm.DTMWSFilter)
                        xowner,
                      false,
                      true);
            }
            else {
                dtm =
                  xctxt.
                    getDTM(
                      source,
                      false,
                      null,
                      false,
                      true);
            }
            return dtm.
              getDocument(
                );
        }
        catch (java.lang.Exception e) {
            throw new javax.xml.transform.TransformerException(
              e.
                getMessage(
                  ),
              locator,
              e);
        }
    }
    public static org.xml.sax.XMLReader getXMLReader(javax.xml.transform.Source inputSource,
                                                     javax.xml.transform.SourceLocator locator)
          throws javax.xml.transform.TransformerException {
        try {
            org.xml.sax.XMLReader reader =
              inputSource instanceof javax.xml.transform.sax.SAXSource
              ? ((javax.xml.transform.sax.SAXSource)
                   inputSource).
              getXMLReader(
                )
              : null;
            if (null ==
                  reader) {
                try {
                    javax.xml.parsers.SAXParserFactory factory =
                      javax.xml.parsers.SAXParserFactory.
                      newInstance(
                        );
                    factory.
                      setNamespaceAware(
                        true);
                    javax.xml.parsers.SAXParser jaxpParser =
                      factory.
                      newSAXParser(
                        );
                    reader =
                      jaxpParser.
                        getXMLReader(
                          );
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
                if (null ==
                      reader)
                    reader =
                      org.xml.sax.helpers.XMLReaderFactory.
                        createXMLReader(
                          );
            }
            try {
                reader.
                  setFeature(
                    "http://xml.org/sax/features/namespace-prefixes",
                    true);
            }
            catch (org.xml.sax.SAXException se) {
                
            }
            return reader;
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se.
                getMessage(
                  ),
              locator,
              se);
        }
    }
    public SourceTreeManager() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ixiHua0lAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16Cazr2Hke352ZN4tneTP2eCZTzz52Pab9SEqiSHWc1JRE" +
       "UqREbaQokY3zTHETxVVcREnptImBxEZSuE4zThwkHrSAjdTBOE6NZinSBBPE" +
       "aVa0dWGke2ykBeI0mSJGmzSt06aH1L1P9963TAfvoRfgudQ5/znn//7z/99Z" +
       "eF57A7oriSE4Cr2t7YXpZXOTXl56+OV0G5nJZb6HD7U4MY2WpyWJBPKu6M/9" +
       "zEN/9q1PLi4dQRdV6O1aEISpljphkIzNJPTWptGDHjrk0p7pJyl0qbfU1hqS" +
       "pY6H9JwkfakHve1U1RR6oXeiAgJUQIAKSKkCQh2kQKUHzCDzW0UNLUiTFfS3" +
       "oAs96GKkF+ql0LNnG4m0WPOPmxmWCEAL9xS/ZQCqrLyJoWeuYt9jvgbwp2Dk" +
       "lR/9rktfugN6SIUecgKxUEcHSqSgExW63zf9uRknlGGYhgo9HJimIZqxo3nO" +
       "rtRbhR5JHDvQ0iw2rxqpyMwiMy77PFjufr3AFmd6GsZX4VmO6Rknv+6yPM0G" +
       "WN95wLpHyBT5AOB9DlAstjTdPKlyp+sERgo9fb7GVYwvdIEAqHq3b6aL8GpX" +
       "dwYayIAe2Y+dpwU2IqaxE9hA9K4wA72k0BM3bLSwdaTprmabV1Lo8fNyw30R" +
       "kLq3NERRJYUePS9WtgRG6Ylzo3RqfN7of/AT3x10gqNSZ8PUvUL/e0Clp85V" +
       "GpuWGZuBbu4r3v++3o9o7/yljx9BEBB+9JzwXubn/+Y3P/T+p17/jb3MX7mO" +
       "zGC+NPX0iv7Z+YNfeVfrxcYdhRr3RGHiFIN/Bnnp/sPjkpc2EYi8d15tsSi8" +
       "fFL4+vifKd/zU+YfHUH3cdBFPfQyH/jRw3roR45nxqwZmLGWmgYH3WsGRqss" +
       "56C7wXvPCcx97sCyEjPloDu9MutiWP4GJrJAE4WJ7gbvTmCFJ++Rli7K900E" +
       "QdDd4IHuB8/7of1f+T+FdGQR+iai6VrgBCEyjMMCfzGggaEhqZmAdwOURiGy" +
       "0YDTfGB5pXKFuFJBklhHwthGNOAVCxPZFN0hYpjFYDxi0xS0APhDfLlwtuj/" +
       "TzebAu2l/MIFMBDvOk8DHoigTugZZnxFfyVr0t/86Su/fXQ1LI7tlELPgb4u" +
       "7/u6XPZ1+Zq+oAsXyi7eUfS5H2cwSi6Id8CE978ofpj/yMefuwM4WJTfCUxc" +
       "iCI3JuTWgSG4kgd14KbQ65/Ov1f+2+gRdHSWWQs9QdZ9RfVhwYdXee+F8xF1" +
       "vXYf+tg3/uyLP/JyeIitM1R9HPLX1ixC9rnzFo1D3TQACR6af98z2s9e+aWX" +
       "XziC7gQ8ALgv1YCvAlp56nwfZ0L3pRMaLLDcBQBbYexrXlF0wl33pYs4zA85" +
       "5VA/WL4/DJ36+8Dp/0Xp26MifcfeNYpBO4eipNlvF6PP/Jt//ofV0twnjPzQ" +
       "qTlONNOXTrFA0dhDZbw/fPCBwkOA3H/89PCHP/XGx/5G6QBA4vnrdfhCkbZA" +
       "9IMhBGb+vt9Y/duv/d5nv3p0cJoUTIPZ3HP0zR7kX4K/C+D5P8VTgCsy9hH8" +
       "SOuYRp65yiNR0fN7DroBRvFAuBUe9MIk8EPDsRxt7pmFx/7FQ+/GfvaPP3Fp" +
       "7xMeyDlxqfe/eQOH/G9rQt/z29/1P54qm7mgFzPawX4HsT1Nvv3QMhXH2rbQ" +
       "Y/O9/+rJH/t17TOAcAHJJc7OLHkLKu0BlQOIlraAyxQ5V1YpkqeT04FwNtZO" +
       "rTyu6J/86p88IP/JL3+z1Pbs0uX0uAta9NLe1YrkmQ1o/rHzUd/RkgWQq73e" +
       "/85L3uvfAi2qoEUdzNfJIAZ0sznjJcfSd939737lV9/5ka/cAR0x0H1eqBmM" +
       "VgYcdC/wdDNZAKbaRH/9Q3tvzu8ByaUSKnQN+L2DPF7+KhZ/L96Ya5hi5XEI" +
       "18f/18Cbf/T3//waI5Qsc50J91x9FXntJ55ofccflfUP4V7UfmpzLQWDVdqh" +
       "buWn/D89eu7irx1Bd6vQJf14CShrXlYEkQqWPcnJuhAsE8+Un13C7Ofrl67S" +
       "2bvOU82pbs8TzYH6wXshXbzfd45b7jvhE/SYW9Dz3HIBKl8+VFZ5tkxfKJK/" +
       "ehLKd0exswZxWbb8YgrWmFeSq7MKGLJnbzBkYy0vF0ZX9H8y+vpXPrP74mv7" +
       "IJ1rYOaH4Butsa9d5hf8/e6bzEGH1defsn/t9T/8T/KHj47D6m1n7XDpZnYo" +
       "RR8Fu4ODu8tm4dVFfnfPwEVaLRJqL16/oY+/dLXnoyL3XeD54HHPH7zBCAyu" +
       "PwLQid0f8K9ksXO8PI9P1H26XDtc3vje5TTWgqSYfS5PxtyJ3DnFh2+qeNnb" +
       "5gIY+Lsql4nLaPF7dn3V7ihe3wvIPil3IaCG5QSad6LwY0tPf+GE3mWgMojO" +
       "F5YecdbSRRxc3i/lz+n64v+zrsALHzw01gvBruAH//Mnf+fvPv814HI8dNe6" +
       "iDzgRad67GfFRun7X/vUk2975es/WM5dwNuHGvrjv1C0qt8McZF8Z5F8+ATq" +
       "EwXU/VqrpyWpUE4xplGivSmpDWPHB7Py+ngXgLz8yNfcn/jGF/Yr/PMMdk7Y" +
       "/PgrP/CXlz/xytGpfdXz12xtTtfZ761KpR84tvDp+L1OL2UN5g+++PIv/sOX" +
       "P7bX6pGzuwQabIK/8Lv/+3cuf/rrv3mdJemdXngLA5s+/N5OLeGok78eprVn" +
       "lIyNpzABTxC+NaJhqbNl8668RnSK0ZT+XJnQ/DBqoc7YnTOU5VerVX60JozI" +
       "MmCc64jNqc8k82jSnKJyKA96Fj5munqKYmonEgep4Ckq1lNW8ZzcycpaENuJ" +
       "Nm3Emg4T2XqN4fNNw1eEnVD1d5VqMMyGBok3iHVQjbJ2hPp8qAqsJFPiKByn" +
       "6Moe1/V2te3SVa3Lq4y9XbIEwW7ktVWZVSWylcgVsuumvCl0Fi2h79F5nV7x" +
       "W9tfeuh2ynAC77hOH1NH/qTLt6N8Ljfzib+ahGtW1NVY9PqeK/Kp5vKOjdWb" +
       "bYzd2I5Ql3nLT5mpmNPLSaVP9hka9jN7a9UGPtt1RXlakTisvaaniwo27cy9" +
       "/sDKJ4t03kPzLi1JEt9dCrpnS2Pf2PXliSkPkLjHcbt5mzPXbrdVc2IFs9y8" +
       "385NoRKoFXK+GkzyZXMyGU9n+rg7kNhVSIpNYTPJ+uRM7Ehejx1bnD7Z6HYo" +
       "V/os6/crEdYJ+9TKqKyVejxto5g85iM8kud2fddX5RVn1znX9ExeXdmtrdeT" +
       "RrolVOxQxefprOkkgaphWKBVd+SIwNF5FRm22EpEzlw1MieOEM0kW6dH82bI" +
       "902KF314tch6dOJq3e5syXSomoxNvHysVvwNnpH1EbyYNiORpufMMlew1XKQ" +
       "IVI+CsnWfB5pKhuZqUbyFLmq12Exau1Qu15dduS038Isx9i18knYbdYnblNJ" +
       "SLFr1OzuyDXHWJ2PuUofQ6k23cJ6E0mzVUDfsi3VRoNYoHmaiSREa+ps0KCH" +
       "Er2QW5OBuWFW1CQxFFpXhiMJHgjSUKzWd604ZCZMM+cZthkEc1LBbNVaWTK+" +
       "hU0Lra+mROo4sdem+Fy1JZkfb5Bun9K4aLjiBeA3+KITOS151neMPFgGjVDl" +
       "7ZG2RASsn67JeqLsZLI+17MxnpCoZxortFGvBFyY9WAkZQN8ORkOs3gsOYLu" +
       "ohjfEeFNlYO3u1XirzSh6ea74SoZd7f9Cq52BtUqQuD2EJX5xSSNeHGizqSu" +
       "4iwFrauhjqjWPWO8MMNWWPOmE5eVx+3Ber6VPbJZlxg2gucT0m/rkSbOO8IQ" +
       "n64QFqa6lLuiu3zX5M1JxK4QLefmtQGpLsdNsWnDke3rpjBDanN0Tte5lhZ6" +
       "TJNpjvmJJhhZGFdCVMBxjGpXF/3Rqh6Ml1SzKVQbDYthSHG2GWP9NrPqxtVx" +
       "PuUcm9Z202YVFWtYrAiIQcfzJjVzRkrDTljPkpa6mnbmyaRl08to6UY5raop" +
       "tZIn+GgoEpkoNizd1DYwlfrOgEWTTtOJqE7diRaN8WxhueoWFltLOiNsDt5J" +
       "jTZDaNRQMFo9Y2WkFibXkXlFpmgK8BozGtKVzni6s3sTotlq70x1Q5otfpd1" +
       "lj1MAW9CrtO61aPbg27aDqejmTCebGZjNaRYO9Lalc1gSWlrqhN0RgqhD+di" +
       "itcVxmpuMsU1GV5v8t1+vWnwuzRMaSS0hlFsBJtcMztEuloNvOE8AcTYwrYD" +
       "vs2zdgNeWNlwWYvAri/r1CZYMs/rI0WjnNDL3VxW2nK0XhJku9lxyWpLoxOc" +
       "5TeThjqyFVzuB6qcjBizE7RIEk1UW9BrwsDOO9Wcwu0Z3BAba6LiJtYs0cZp" +
       "z4c3scwZWGeKD7iZzMw7/lQUaAxVzEY7i6tGlegRuwZXx4Y90d4oG7IjqU5l" +
       "tCWptNZssg0c6BrPiQqONKY5XasJTLpAO/BoxU6J3lhF2lLumAjMtgOOsiS2" +
       "HmqEwmneahpKUmKqyq6fUStWVLZN11qy9rQloVF3FDUEXSTIqDL380SwCC3E" +
       "qmK1zexSDY+wuW0NG7Vs5uILI2N5ooUpY3rWSgyE3/i8zQ4NabRGq/IC6LNM" +
       "4Kq3lRp1KbV7MkWg2sSZd6cGna9pu8qxM327dda9nSATuuKg83bHHJqaKXU1" +
       "sA+eaw141gc0aPQDmHUaotoBUCstzB+zrukytfVKJZB6PzUFrNcyXIXKJaQr" +
       "7sQlxY76gTfGVEveJtZgtDYabrfKrUa9cZwM5ry1WfA9OVtJydIg4UGVMByR" +
       "E2euu1JlmYubUg1MWzI9CCYs1XJ27NJa9zl9g1E405vobbzbpjkO7s9JQq6P" +
       "0M2iksOGLllxgIYzbE06NprDNbG3qFUEtrPTt4BdIixCjA5vNhqEunYC1dS0" +
       "oZQp2+pmSyOI0VuDyEDMXYdu5EySSRKydM260CHq6RpJlKiXIaPWJB5uB2Im" +
       "0K3aMts6VN0b5nbFW+eZlHi42MVCdR6SdlSl/QbKT9XGIupVJMCo0Xrhaz4H" +
       "FgNZtHOjHT9LqzVHx5SKKVhTmAH0SkTdQYObThm2mjcbGKfzlhywY3++JRku" +
       "w/sRPNHmIT3YstpWDPthrQ4oK1R7zHjDEdlWsbd4nlPViVyNhmEfa7kC2Ve2" +
       "vWoFrqlGOtsmtaS/6tvTlJjGzm6bZB2mbwiDYXer7MbrXRex/CXcyEyTAUEC" +
       "B3mgZj6N0CAi+uhsTjrybL3Z+bEHC/XqtLKsY6umBweNOJ06mJ0MpJXrt/Dc" +
       "dyvVaDFZjScBh+ZgoghEbdkzsFQNCSvUVttASRuDMbqYYhVRIHRjscHhWkJ7" +
       "A9gwTILkG4hIaWYFRchKtbqsbwxksLBhMFGvqJ2wNEIf94mUnOiKrzWHgs0H" +
       "EziD09W43UDiTALTi9UIe724X+Nr3LSy7RCdMHQdFV5viZ5TZxJ0aZkdlPXh" +
       "tMuYSANDEcPUanoSqdNJtJEjBV9V+Hi7S/UN1yC81jb1xIE0qDHhGmeBM7Oj" +
       "oI9Ko5jWmW1rrKV46MwpzyMzSXd4kt1hXMxFI1p3heWQ0kdVkhQYuc2IgbIK" +
       "DD3Q+EFSiTt5fzsZ2ZHDC8xm1HaJNucn+DTDq8OBF1OZm1MTuBOvuU11LaLe" +
       "elEZa3UnWyiR3afJQSWWtm3LgonZusIboTVll6yOY1WOWLRETTcRo48gmxYO" +
       "w9jSnCkGM9nJeJKirrDKwDwqBM053DIktoFIAzEeurjJOm7VEGIhNoR6y++O" +
       "aMJeBk2B7Fj5bDhHMMJClErTEIdKm95hlCnP4Mlynk/7s924t24N+8vWrL/Y" +
       "7oIBSYWYKRpcNMHVqWeSkzq3qGORbiZ2zWyq89irJu2KHQSs6oSmttXxZmhP" +
       "dhvc5rEK0VFy1+Y7i3wbVigHrTO9rmEPwMwp0AamNRoaC+/wGsblidWYOxq6" +
       "qRJxgJGkkw2n2sSfGIxQ5QdaI9/iRexgI6G/QYK6Ivfizg5B+0rQadTreV3l" +
       "xU6r18QmUU3fjVkSYUZ8jaSXDX0rkUPTqtRafG263bgphxhLt7scylu2wzXU" +
       "XTxPeoNhf9DrKBthEel1cxB2FKIx3C3W8I6lt6NNreKgy4prZBbARll9eNZt" +
       "Zzy21Kn6vIrjDgxWd43qGixwJdOkXHjdtwjTVROT52OrMVFHQebMFcVi2xWS" +
       "nMYavhkRpOSvxVoXWWcpXhU8zp3qlra2F3MPZsXhNqPILZybzWYuJTzopzmr" +
       "+6vVeDxtTEeLjBZ5v5rJNtJoMfm8ZgYu3csFdgymM7e+HOAOBy9bQ5LcUet5" +
       "Pghw0u7seq267wROJR9ZmyXdsCr9aDb1wmynmV6lWl/C4UoQe2AWtZUWvvab" +
       "Ea1qFaKPrbv9IJk5rZoet7kNrivJetLMEZnUVxJTUwRhYuJVpVdpRAzBT2zU" +
       "p3ILlyOrO25FFik5/ETx623Ra3schwZit2vn7XQRVFsSPh128IUtANoZd3q+" +
       "a7BtVxxpQzyvuU1bV7axtUooNmvY5EhNavEETepMKFtcU7e6pK0t2W6Q45rn" +
       "7YzBmGpyLjuuiXyuuS2W37E1HxY8gdaScaR4wjBghwS8kGi9Za7QvhVL3E4n" +
       "xf44kHe0NSaY9oSx9USzYJzfxbafEGFvnNGIGy7CwXgohPNAmDkdglpTsahv" +
       "c8VS1zCp8A6juWgfbArGylgJWXe32uwW+hRsNWFX8HCUWsqcwnSVDdvtjBco" +
       "b3NDOZuv8SZCIjqDUraImHy4bLsz1h9sVizvepwWsAa2InywWVXJKrN0xtvW" +
       "LjRqmIfyYWs6bIuptvarbWfoyt12tT4kJJtftXy7H3mhxNsEhXWERb+J9nzO" +
       "k+kWMkuTSX2lNvP2YsbWLIk2DJ9qGN58S7CEOZAUdWyrLvBCh7NsujqESb1F" +
       "9oCVK5ghDf0OmEiQnVYPksVMlZf8KECJXjJcAd9QjdXAxbqdob0iSXHaQVo0" +
       "7rZXOKzrFUbaVndLB2W3u+psx8n8plJrEruNgbmUKQYoNbaYSoSTbryrt12p" +
       "5s1UBacSroYSTFXLXFxQgxjNEFQfDEhvYGDLwKyB7fAcqwMyYNo40Ebjknm/" +
       "LkzBDl7kPZzTTZnJpjozX2GVedSVSRQGO9KNE3kVJ6vjq2AwXIJleC30LK0x" +
       "I4iwLmyyXEazNeHtiEYtIUSvwszWqkY3BVvCYMVEfRNN6bofh1VvgFgxPRvD" +
       "sSFPYKNer+Fwg9bipbHt0NWOKnTF0Zip6og155araVBd0B7T3fpNYtTuk82M" +
       "9oCtwNK2Y+jkRvF9y/e0LYIIGzbp9/Mh2hyTSittxwQzbYzZacANxwi3lv3M" +
       "608WK6fRITTHrwS67TYU1NhinX5IMAiVO+05PV0ScuQHU5ztx23X0NGAERfM" +
       "erOsWmTT2TidTEM9iqK+vTgySd/aqdXD5QHd1Q/vS48oCq68hdOafdGzRfLu" +
       "s9+zLkLnPtaeOvE8deYPFSdQT97oe3p5+vTZj77yqjH4HHZyqBum0L1pGH3A" +
       "M9emd6qp+0FL77vxSZtQXic4nOH/+kf/yxPSdyw+8ha+Uj59Ts/zTX5eeO03" +
       "2ffof+8IuuPqif41Fx3OVnrp7Dn+fbGZZnEgnTnNf/KqZe8tLPYoeOrHlq2f" +
       "P0s+jN21R/mlF+zH/iafon7gJmV/p0i+L4Xuis3E3Dvb8pSLBCl05zp0jIPv" +
       "fP+bnfSd7qHM+OhZsBXwtI/Btm8P2AsHAakU+LGbIP7xInklhR4EeM+dqn/i" +
       "APNTtwCzGE7oefAMjmEObv+Yfu4mZT9ZJH8fILSvQSgdEP6DW0BYij0FHvUY" +
       "oXpbB/J6bniHE6RlnX90E+Q/VySvAeQWYBkAnYlDvx3qJQcekH/hVpE/AZ71" +
       "MfL17UF+x4HWrxzUfTSFnr3e16Dj7xKhXnytL9t7/Vx7R2V7RyetvPd6rUgn" +
       "b2ZMb3QzusqVoML+i7gTXuYGV8vKjr5cJL+YFrxWuhWw8kmdJ26s6sH4//RW" +
       "+aOYen7o2Pg/dNv540ulwFdv4mO/WyT/IoUei00/XJvAvTLfDNLC1VrFNZ1z" +
       "RPIvbxVvMSF8/hjv528P3mPnKPEWyW+VUl+/CejfL5J/n0KPRFl6gpgLrof3" +
       "P9wC3geKzHeA58vHeL9828d3D/WPbwL1vxbJH6TQ3YA9+6FR4vvSAd83bhVf" +
       "QR5vHON74/bgu7MUuPNAHkXyKydh+eQ1V8hmQ5Ae3zAtG/zzGxvs10qBvyiS" +
       "/5ZCDwCjHC6gnTPNf78NprlwaV93//+2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8upvlVYpkv9ZiF64+CagL9xTJBduDvrC0a2Cfhz0ebysvnB+WX37QT/yZqDf" +
       "USQPpNDbouLKhhReGwIXHrwFyIX3Q+8BPU6OIU/eAuSSsfa7njfjtT3uEtFT" +
       "bwb5mSL5thS6H4zzTOiNTc043MZ4tIieYkpLwNR2trQ0xhNvxRgbsEO75v5m" +
       "cQHt8Wtuie9vNus//epD9zz26uRfl1cYr94+vrcH3WNlnnf6vtCp94tRbFpO" +
       "aaJ797eHohIo2CBeOk8GYOlf/i90vfDevdz7wfR+kEuhi/uX0yIIWJEBkeIV" +
       "jU5sdeoyxv4a1Ga/lHv8tC+UVPHIm1nt1F7y+TM7wPLW/cluLRse30f64qt8" +
       "/7u/Wf/c/sak7mm7XdHKPT3o7v3lzbLRYsf37A1bO2nrYufFbz34M/e++2R3" +
       "+uBe4YNfntLt6etfSaT9KC0vEe5+4bF//MGffPX3ytso/xei+DSaDjEAAA==");
}
