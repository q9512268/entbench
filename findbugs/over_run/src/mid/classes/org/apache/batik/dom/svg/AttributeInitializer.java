package org.apache.batik.dom.svg;
public class AttributeInitializer {
    protected java.lang.String[] keys;
    protected int length;
    protected org.apache.batik.util.DoublyIndexedTable values = new org.apache.batik.util.DoublyIndexedTable(
      );
    public AttributeInitializer(int capacity) { super();
                                                keys = (new java.lang.String[capacity *
                                                                               3]);
    }
    public void addAttribute(java.lang.String ns,
                             java.lang.String prefix,
                             java.lang.String ln,
                             java.lang.String val) {
        int len =
          keys.
            length;
        if (length ==
              len) {
            java.lang.String[] t =
              new java.lang.String[len *
                                     2];
            java.lang.System.
              arraycopy(
                keys,
                0,
                t,
                0,
                len);
            keys =
              t;
        }
        keys[length++] =
          ns;
        keys[length++] =
          prefix;
        keys[length++] =
          ln;
        values.
          put(
            ns,
            ln,
            val);
    }
    public void initializeAttributes(org.apache.batik.dom.svg.AbstractElement elt) {
        for (int i =
               length -
               1;
             i >=
               2;
             i -=
               3) {
            resetAttribute(
              elt,
              keys[i -
                     2],
              keys[i -
                     1],
              keys[i]);
        }
    }
    public boolean resetAttribute(org.apache.batik.dom.svg.AbstractElement elt,
                                  java.lang.String ns,
                                  java.lang.String prefix,
                                  java.lang.String ln) {
        java.lang.String val =
          (java.lang.String)
            values.
            get(
              ns,
              ln);
        if (val ==
              null) {
            return false;
        }
        if (prefix !=
              null) {
            ln =
              prefix +
              ':' +
              ln;
        }
        elt.
          setUnspecifiedAttribute(
            ns,
            ln,
            val);
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "E7eFcqkd+BNxq0h+RZBltFZzK5JQ3zbQ0RhNWxxBsZgglOFL8gc/mL8+v/bN" +
       "vdY/XuxWHH/Y8FfYp0hP7ZodbwEVv6vIucPwU1tAp44CkPyw4pl7fa9QnMl8" +
       "/uOvva6NfgS7fLhl1oiQRyLX+4AFtsA6NdQDRX159lRyCK+XD9l4+fxO1Img" +
       "F29DvTe9aCfwwYLgwWNVnSoK+h+7z3bfT+TFP4iQRxVNOz7cvnALZeua2okN" +
       "/uE32j05PdFFemjBiz3UA/vXo4fTG9kX7s0dn+IvwyhQ1Cj/vAkcnpH9/H2U" +
       "9E/z4h9HyNvM41P/s7r6RyeK+Zn/B8U8mT98Hl6vHCrmlb92B/mFixzkl+8j" +
       "+6/mxb+IkMcCEILovi7y0NJ1LaA4J8p485tRRgoVfNH3Fflh8VN3fea1/zRJ" +
       "/cLr1x9+5+uTf70/rjn6fOgRFnlYjy3r9DnVqfpVLwC6WYj3yP7Uyiv+fjdC" +
       "nrqX00QwnLf7Q5Pf2VP/K8jvRdSQEpanKf8wQm6cp4yQK8X/abo/ipBrJ3QR" +
       "cnVfOU3y7+DokCSv/rF3wdnO/lgvvXQW0Y4N8sQ3MsgpEHzxzAFL8Tne0WFI" +
       "vP8g7476xdf73Ee/Vv+R/ZcSqqVkWT7Kwyzy0P6jjeMDlefvOdrRWFfpl77+" +
       "2E8/8u4jWH1sz/CJy5/i7bmLP0ugbC8qPiTI/sk7f/blH3v9T4p95v8LNJOO" +
       "AScpAAA=");
}
