package org.apache.batik.dom;
public abstract class AbstractDOMImplementation implements org.w3c.dom.DOMImplementation, java.io.Serializable {
    protected final org.apache.batik.dom.util.HashTable features = new org.apache.batik.dom.util.HashTable(
      );
    { registerFeature("Core", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("XML", new java.lang.String[] { "1.0", "2.0",
                      "3.0" });
      registerFeature("Events", new java.lang.String[] { "2.0", "3.0" });
      registerFeature("UIEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MouseEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("TextEvents", "3.0");
      registerFeature("KeyboardEvents", "3.0");
      registerFeature("MutationEvents", new java.lang.String[] { "2.0",
                      "3.0" });
      registerFeature("MutationNameEvents", "3.0");
      registerFeature("Traversal", "2.0");
      registerFeature("XPath", "3.0"); }
    protected void registerFeature(java.lang.String name, java.lang.Object value) {
        features.
          put(
            name.
              toLowerCase(
                ),
            value);
    }
    protected AbstractDOMImplementation() { super(); }
    public boolean hasFeature(java.lang.String feature, java.lang.String version) {
        if (feature ==
              null ||
              feature.
              length(
                ) ==
              0) {
            return false;
        }
        if (feature.
              charAt(
                0) ==
              '+') {
            feature =
              feature.
                substring(
                  1);
        }
        java.lang.Object v =
          features.
          get(
            feature.
              toLowerCase(
                ));
        if (v ==
              null) {
            return false;
        }
        if (version ==
              null ||
              version.
              length(
                ) ==
              0) {
            return true;
        }
        if (v instanceof java.lang.String) {
            return version.
              equals(
                v);
        }
        else {
            java.lang.String[] va =
              (java.lang.String[])
                v;
            for (int i =
                   0;
                 i <
                   va.
                     length;
                 i++) {
                if (version.
                      equals(
                        va[i])) {
                    return true;
                }
            }
            return false;
        }
    }
    public java.lang.Object getFeature(java.lang.String feature,
                                       java.lang.String version) {
        if (hasFeature(
              feature,
              version)) {
            return this;
        }
        return null;
    }
    public org.apache.batik.dom.events.DocumentEventSupport createDocumentEventSupport() {
        return new org.apache.batik.dom.events.DocumentEventSupport(
          );
    }
    public org.apache.batik.dom.events.EventSupport createEventSupport(org.apache.batik.dom.AbstractNode n) {
        return new org.apache.batik.dom.events.EventSupport(
          n);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "W9uYmSPL/qrD0OR2FcRNkCBKNLDtJdwxKTNrxLEozjDULZk+RfaIZq2m69Yi" +
       "aDd6nJI1DG8VlXpcawHOhUa6cANcDOjAJLMsaXWZcrNmcplUXw4GQqth1gZc" +
       "W1k6k3gUx0N/jbLhSMPHW3FORbPVMBw1EQfvZCNUjaaCG9U2aZlAjaZcWhol" +
       "rFMaiy13RCtGy5NX1qapqhOG0so1nKtTa95oe7lnefKSUmKWVqb0fOaW9YVB" +
       "SzXOIXF2QXca1cDFbCIYM7w73bSqtBhspbnBZA266oyzuJMu3Qo3pgKRZFkP" +
       "GJWlK01CWsfLmjGtVcZxb1lLkFoqkC2cmBqUAPSN9+vlzcqfm4IgW9OlFG/W" +
       "TiPsu6nZoSs4Vo9XcE8KcLJl9nDwipq/umrP7vbgtuKi5Kh2Z1qtfGL2LN6a" +
       "02vcPNEhdE48qGAc3x8Xn/OHRaDD75P3x8eXinuHNzZ35zdOSU0uLpouq4Yc" +
       "Qu2qIYa7f1Q0lSw1v2m4+2olv+KW4UNvf/Iphf5wZe/gPlcKoZtC1/txS41V" +
       "6wQ3eXn7oavfqJBFxfP4nvFzb//nu+av1d/0LAoo957i8zTJ3yCf/sLgpfIv" +
       "7EHXHd06XlaLvRTp4UvvGm/21TDynfklN453X1rEeA14DrZ69315EeOKm36m" +
       "uG7c2dap6/K9Y6uYXeEWbneTWmD+9DUu2h/Pm7eE0Hlf1YwgVH3s4GIyH3/D" +
       "CVMVQ+j62DWUYxt+6w+6+Tm5VjHw5iOl3JEP3g0e6kAp1LNVCv0DlVI0BdST" +
       "11DA+/LmPSF0sy4G15D9Rsl1LVV0jsV/4ocQ//Z88MXg8Q7E9/4vxf/Va4j/" +
       "4bx5CoivqeGB+PnIO47l/JUfQs778sFXgSc7kDP70ch5UoKPX2Puk3nzkRC6" +
       "S/aBbCrqylEe4foxaJjI81w/PHSd8hUv4NUcMti/KmKhod/8ITR0Zz74EHge" +
       "O9DQYz8aDZ05KFIfSHf/NWvhlKuoBZXPXEOXn82bT4fQ7TtdXkmHL7+WDq+s" +
       "u999NrpLQ+hFV63f55XIOy/7t9DuHy7yx546f+6FTy3+qihhH/0L5SYCOreK" +
       "LOtk4ehE/6znqyujEP6mXRnJK77+GByLV5I0hK4DbcH1F3aQfwJC8mnIELqh" +
       "+D4J92fAAY/hQujsrnMS5C8AdQCSd79SWMY70jMnDtIDwyp0evsP0ukRysk6" +
       "dn74Fv/JOjwoo92/sh6RP/7UiHrzd5of3tXRZUvMspzKOQK6cVfSPzps778q" +
       "tUNaZ/FXfO/WT9z0ksPE4NYdw8dGfoK3e69cse7bXljUmLNPv/C3X/1rT321" +
       "KPj8DwAh3IIsJwAA");
}
