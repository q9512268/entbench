package org.apache.xpath.objects;
public class XRTreeFrag extends org.apache.xpath.objects.XObject implements java.lang.Cloneable {
    static final long serialVersionUID = -3201553822254911567L;
    private org.apache.xpath.objects.DTMXRTreeFrag m_DTMXRTreeFrag;
    private int m_dtmRoot = org.apache.xml.dtm.DTM.NULL;
    protected boolean m_allowRelease = false;
    public XRTreeFrag(int root, org.apache.xpath.XPathContext xctxt, org.apache.xpath.ExpressionNode parent) {
        super(
          null);
        exprSetParent(
          parent);
        initDTM(
          root,
          xctxt);
    }
    public XRTreeFrag(int root, org.apache.xpath.XPathContext xctxt) {
        super(
          null);
        initDTM(
          root,
          xctxt);
    }
    private final void initDTM(int root, org.apache.xpath.XPathContext xctxt) {
        m_dtmRoot =
          root;
        final org.apache.xml.dtm.DTM dtm =
          xctxt.
          getDTM(
            root);
        if (dtm !=
              null) {
            m_DTMXRTreeFrag =
              xctxt.
                getDTMXRTreeFrag(
                  xctxt.
                    getDTMIdentity(
                      dtm));
        }
    }
    public java.lang.Object object() { if (m_DTMXRTreeFrag.getXPathContext(
                                                             ) !=
                                             null) return new org.apache.xml.dtm.ref.DTMNodeIterator(
                                                     (org.apache.xml.dtm.DTMIterator)
                                                       new org.apache.xpath.NodeSetDTM(
                                                       m_dtmRoot,
                                                       m_DTMXRTreeFrag.
                                                         getXPathContext(
                                                           ).
                                                         getDTMManager(
                                                           )));
                                       else
                                           return super.
                                             object(
                                               );
    }
    public XRTreeFrag(org.apache.xpath.Expression expr) {
        super(
          expr);
    }
    public void allowDetachToRelease(boolean allowRelease) {
        m_allowRelease =
          allowRelease;
    }
    public void detach() { if (m_allowRelease) {
                               m_DTMXRTreeFrag.
                                 destruct(
                                   );
                               setObject(
                                 null);
                           } }
    public int getType() { return CLASS_RTREEFRAG;
    }
    public java.lang.String getTypeString() {
        return "#RTREEFRAG";
    }
    public double num() throws javax.xml.transform.TransformerException {
        org.apache.xml.utils.XMLString s =
          xstr(
            );
        return s.
          toDouble(
            );
    }
    public boolean bool() { return true; }
    private org.apache.xml.utils.XMLString
      m_xmlStr =
      null;
    public org.apache.xml.utils.XMLString xstr() {
        if (null ==
              m_xmlStr)
            m_xmlStr =
              m_DTMXRTreeFrag.
                getDTM(
                  ).
                getStringValue(
                  m_dtmRoot);
        return m_xmlStr;
    }
    public void appendToFsb(org.apache.xml.utils.FastStringBuffer fsb) {
        org.apache.xpath.objects.XString xstring =
          (org.apache.xpath.objects.XString)
            xstr(
              );
        xstring.
          appendToFsb(
            fsb);
    }
    public java.lang.String str() { java.lang.String str =
                                      m_DTMXRTreeFrag.
                                      getDTM(
                                        ).
                                      getStringValue(
                                        m_dtmRoot).
                                      toString(
                                        );
                                    return null ==
                                      str
                                      ? ""
                                      : str;
    }
    public int rtf() { return m_dtmRoot; }
    public org.apache.xml.dtm.DTMIterator asNodeIterator() {
        return new org.apache.xpath.axes.RTFIterator(
          m_dtmRoot,
          m_DTMXRTreeFrag.
            getXPathContext(
              ).
            getDTMManager(
              ));
    }
    public org.w3c.dom.NodeList convertToNodeset() {
        if (m_obj instanceof org.w3c.dom.NodeList)
            return (org.w3c.dom.NodeList)
                     m_obj;
        else
            return new org.apache.xml.dtm.ref.DTMNodeList(
              asNodeIterator(
                ));
    }
    public boolean equals(org.apache.xpath.objects.XObject obj2) {
        try {
            if (org.apache.xpath.objects.XObject.
                  CLASS_NODESET ==
                  obj2.
                  getType(
                    )) {
                return obj2.
                  equals(
                    this);
            }
            else
                if (org.apache.xpath.objects.XObject.
                      CLASS_BOOLEAN ==
                      obj2.
                      getType(
                        )) {
                    return bool(
                             ) ==
                      obj2.
                      bool(
                        );
                }
                else
                    if (org.apache.xpath.objects.XObject.
                          CLASS_NUMBER ==
                          obj2.
                          getType(
                            )) {
                        return num(
                                 ) ==
                          obj2.
                          num(
                            );
                    }
                    else
                        if (org.apache.xpath.objects.XObject.
                              CLASS_NODESET ==
                              obj2.
                              getType(
                                )) {
                            return xstr(
                                     ).
                              equals(
                                obj2.
                                  xstr(
                                    ));
                        }
                        else
                            if (org.apache.xpath.objects.XObject.
                                  CLASS_STRING ==
                                  obj2.
                                  getType(
                                    )) {
                                return xstr(
                                         ).
                                  equals(
                                    obj2.
                                      xstr(
                                        ));
                            }
                            else
                                if (org.apache.xpath.objects.XObject.
                                      CLASS_RTREEFRAG ==
                                      obj2.
                                      getType(
                                        )) {
                                    return xstr(
                                             ).
                                      equals(
                                        obj2.
                                          xstr(
                                            ));
                                }
                                else {
                                    return super.
                                      equals(
                                        obj2);
                                }
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.apache.xml.utils.WrappedRuntimeException(
              te);
        }
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
       "uM7x1DE+j3f5c8znf6f9vPz3ThfOHB7M");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XHcp7NpGL197HHMhUKM4cLhrDmWeOJR6PiPfDRK+kzp+/GXzfl6vP0TJ3zQf" +
       "UY5v6wzz1084wPuNLPuXUeGc4RhRi2NuePaSuIayV7Qv3fIx5z+/Fv0jIA13" +
       "6Ie3gD5/z/7CDYEfhfTvTqj7vSx7Myqc3Z3JXP++m91X5Gi/fBto80PdOkiL" +
       "HdrFnUF7ak/w8ZzgqydA/nqW/UFUeDg/SGmpkSgvOHd3oJLV/eYe7B/eLths" +
       "apMd2OTOT+2fnFD3Z1n2X8HUKjnEY8j+220guy97+DBIr+6QvXrnkX3jhLq/" +
       "yLK3wRrVgT/emRVkD+1/3u56fAKkT+ygfeKOQzt1+oS6u7KHfxkV7ttB2582" +
       "vb4H+Fe3CzC7V/GZHcDP3HmA9994eR4YlxfyS5T50V8UiE6Y3cK7wh2U1IBI" +
       "ZdWLdrctTl3KsvNR4YwT2zcyxmcVNwY+91A6py7chnTyMOBdIP3sTjo/e+el" +
       "89QJdVlEcupx4GGyM9zcnO1xvfs2cGUTXngUpC/ucH3xzuMqnlD3vix7HuBK" +
       "wyi/VfLpPa7vvF0b2wLp13a4fu3O4Dqmse+94Yk1KYbRdn02Y01TgxwpeoIU" +
       "Xs4yOAKRmeepjsK5ZCj515jlU8idWNpv7oTx5p2fZOKEunaWfQis1N0c7y3W" +
       "Kex2vU1G+5UdrK/ceVjDE+rGWdYDsIJIy+r3nuYUcxuwMiuT31r5ox2sP7rz" +
       "sD58Qt3VLJtFhfvFMLuBSUdqfkX4QOWPX9JQIju7r3MNWS6D+W3I4MHs4bMg" +
       "vbWTwVt3XgbmCXV2lmlRfmstUYOIczNRhOphHPxwJoUVIl9RXPtKVpddJt5j" +
       "12/X1WQm+Vs77N+6M9iPma6nb/6hwTayzwWxPkFIr2RZBByt6sfidnN6xCu9" +
       "4z2tay44RoUL+xtf2WXtx677kGr78Y/8S69fvOfR1ydfya/4H36gc75XuEeL" +
       "Levobb8j5bNeoGpGLpbz27t/Xg7h70SFx24mBxBG7koZu6f+9rbFR4FSHG8R" +
       "Fe7O/x+l+zGAaE8HhLQtHCX5BDAdgCQrfjKb2VObdDs7jx1VjDywe/CdhHnY" +
       "5Oh9/+y1QP7Z2sEWPt5+uHZV/sLrnf73v137me33BrIlbjZZL/f0Cue2nz7k" +
       "nWavAZ65aW8HfZ2lXvzm/b98/r0Hryzu3zK8V9IjvD1148v9hO1F+XX8za8+" +
       "+k/f/49e/2p+V/L/AWJDfN5POAAA");
}
