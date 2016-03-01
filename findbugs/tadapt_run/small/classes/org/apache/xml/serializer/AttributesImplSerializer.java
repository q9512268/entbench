package org.apache.xml.serializer;
public final class AttributesImplSerializer extends org.xml.sax.helpers.AttributesImpl {
    private final java.util.Hashtable m_indexFromQName = new java.util.Hashtable(
      );
    private final java.lang.StringBuffer m_buff = new java.lang.StringBuffer(
      );
    private static final int MAX = 12;
    private static final int MAXMinus1 = MAX - 1;
    public final int getIndex(java.lang.String qname) { int index;
                                                        if (super.
                                                              getLength(
                                                                ) <
                                                              MAX) {
                                                            index =
                                                              super.
                                                                getIndex(
                                                                  qname);
                                                            return index;
                                                        }
                                                        java.lang.Integer i =
                                                          (java.lang.Integer)
                                                            m_indexFromQName.
                                                            get(
                                                              qname);
                                                        if (i == null)
                                                            index =
                                                              -1;
                                                        else
                                                            index =
                                                              i.
                                                                intValue(
                                                                  );
                                                        return index;
    }
    public final void addAttribute(java.lang.String uri, java.lang.String local,
                                   java.lang.String qname,
                                   java.lang.String type,
                                   java.lang.String val) { int index =
                                                             super.
                                                             getLength(
                                                               );
                                                           super.
                                                             addAttribute(
                                                               uri,
                                                               local,
                                                               qname,
                                                               type,
                                                               val);
                                                           if (index <
                                                                 MAXMinus1) {
                                                               return;
                                                           }
                                                           else
                                                               if (index ==
                                                                     MAXMinus1) {
                                                                   switchOverToHash(
                                                                     MAX);
                                                               }
                                                               else {
                                                                   java.lang.Integer i =
                                                                     new java.lang.Integer(
                                                                     index);
                                                                   m_indexFromQName.
                                                                     put(
                                                                       qname,
                                                                       i);
                                                                   m_buff.
                                                                     setLength(
                                                                       0);
                                                                   m_buff.
                                                                     append(
                                                                       '{').
                                                                     append(
                                                                       uri).
                                                                     append(
                                                                       '}').
                                                                     append(
                                                                       local);
                                                                   java.lang.String key =
                                                                     m_buff.
                                                                     toString(
                                                                       );
                                                                   m_indexFromQName.
                                                                     put(
                                                                       key,
                                                                       i);
                                                               }
                                                           return;
    }
    private void switchOverToHash(int numAtts) {
        for (int index =
               0;
             index <
               numAtts;
             index++) {
            java.lang.String qName =
              super.
              getQName(
                index);
            java.lang.Integer i =
              new java.lang.Integer(
              index);
            m_indexFromQName.
              put(
                qName,
                i);
            java.lang.String uri =
              super.
              getURI(
                index);
            java.lang.String local =
              super.
              getLocalName(
                index);
            m_buff.
              setLength(
                0);
            m_buff.
              append(
                '{').
              append(
                uri).
              append(
                '}').
              append(
                local);
            java.lang.String key =
              m_buff.
              toString(
                );
            m_indexFromQName.
              put(
                key,
                i);
        }
    }
    public final void clear() { int len =
                                  super.
                                  getLength(
                                    );
                                super.clear(
                                        );
                                if (MAX <=
                                      len) {
                                    m_indexFromQName.
                                      clear(
                                        );
                                } }
    public final void setAttributes(org.xml.sax.Attributes atts) {
        super.
          setAttributes(
            atts);
        int numAtts =
          atts.
          getLength(
            );
        if (MAX <=
              numAtts)
            switchOverToHash(
              numAtts);
    }
    public final int getIndex(java.lang.String uri,
                              java.lang.String localName) {
        int index;
        if (super.
              getLength(
                ) <
              MAX) {
            index =
              super.
                getIndex(
                  uri,
                  localName);
            return index;
        }
        m_buff.
          setLength(
            0);
        m_buff.
          append(
            '{').
          append(
            uri).
          append(
            '}').
          append(
            localName);
        java.lang.String key =
          m_buff.
          toString(
            );
        java.lang.Integer i =
          (java.lang.Integer)
            m_indexFromQName.
            get(
              key);
        if (i ==
              null)
            index =
              -1;
        else
            index =
              i.
                intValue(
                  );
        return index;
    }
    public AttributesImplSerializer() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vcLyuo7nM9SIP+h/ACbd6q6gIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AW8gfpsBLAAA");
}
