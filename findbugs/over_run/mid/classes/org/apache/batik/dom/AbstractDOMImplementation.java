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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "LRzq0XWrqhMZf42u8zC8wpr9/wVg0CM16hsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZXtRfk+cfu7Vv/3mX33mG/mlzf8AQU8ZYQwnAAA=");
}
