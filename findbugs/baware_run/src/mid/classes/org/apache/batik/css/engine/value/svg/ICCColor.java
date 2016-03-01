package org.apache.batik.css.engine.value.svg;
public class ICCColor extends org.apache.batik.css.engine.value.AbstractValue {
    protected java.lang.String colorProfile;
    protected int count;
    protected float[] colors = new float[5];
    public ICCColor(java.lang.String name) { super();
                                             colorProfile = name; }
    public short getCssValueType() { return org.w3c.dom.css.CSSValue.CSS_CUSTOM;
    }
    public java.lang.String getColorProfile() throws org.w3c.dom.DOMException {
        return colorProfile;
    }
    public int getNumberOfColors() throws org.w3c.dom.DOMException { return count;
    }
    public float getColor(int i) throws org.w3c.dom.DOMException {
        return colors[i];
    }
    public java.lang.String getCssText() { java.lang.StringBuffer sb =
                                             new java.lang.StringBuffer(
                                             count *
                                               8);
                                           sb.append("icc-color(");
                                           sb.append(colorProfile);
                                           for (int i = 0; i < count;
                                                i++) { sb.append(
                                                            ", ");
                                                       sb.append(
                                                            colors[i]);
                                           }
                                           sb.append(')');
                                           return sb.toString(); }
    public void append(float c) { if (count == colors.length) { float[] t =
                                                                  new float[count *
                                                                              2];
                                                                java.lang.System.
                                                                  arraycopy(
                                                                    colors,
                                                                    0,
                                                                    t,
                                                                    0,
                                                                    count);
                                                                colors =
                                                                  t;
                                  }
                                  colors[count++] =
                                    c; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DzVEUdCIIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6B/7RuvT+2NYiiXleTHKVRJ6YH8i7OTj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("37N3He14rCujF7/18K9de+E4pXh4z/BplJ3h7ek7n3ka2F5UnlLKf/udv/m+" +
       "f/Lql8rvTP8fmXvvOoctAAA=");
}
