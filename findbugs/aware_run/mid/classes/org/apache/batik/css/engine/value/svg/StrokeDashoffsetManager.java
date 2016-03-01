package org.apache.batik.css.engine.value.svg;
public class StrokeDashoffsetManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHOFFSET_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_0;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDashoffsetManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AOqcGh9qacPUKZwWiJzO9kFVAZkFwvFSgbHLrBmjaBqEao+pEE2Uxqz3iIvJ" +
       "m5PHJE3RrDw3RexsNDvngltcykrnT1eXzTq9/Xf8tiJzcVoJNWAipaqeysVb" +
       "xZQYJkko3KBKcXw0+NdvJ4iszKUWJG9ouSlXBOu7FDVOyEpR8XBmodqM79sR" +
       "n4eRohLx4uW5DsXGeDygFrReyt9DNvVTghb820t3g6IKlw4mFS9ekj+DdCBh" +
       "r58YzvIJTwxXBH7RQduX6UDuuZWHzMyJQsZzLF2UVa3zf0icYjYl/iOBk8Pp" +
       "zVsfv/XwWXFlJKl4dJRJmQolrLiYypzdGvNKc2SVbFp6d9pr5Yud6jrrysqr" +
       "G49kWJP8emeO7w7Fas5cpVw/s/riO4dLrsG5YCcKYDgj7fT8PyEu49vSRgoO" +
       "ljsj4xXrcLLl1zttFZ/suvKPDwN1/E4AifK+oRBHTDp+8aNowjC+HUTlXagY" +
       "Dg8k3Y8qFGvDXm0bkYbNrNq/JK6ntMyfKdPY+sJsR+bI2IBWZXrZbSJFTbkn" +
       "nNwb1gpVHyHmeiadianynXZThuEd5chKrFmRZkhDKMYi3YZhX7IVreHIGwbP" +
       "JbdZI/8XL3VI4gYdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/h8JcbMYRCkAAA==");
}
