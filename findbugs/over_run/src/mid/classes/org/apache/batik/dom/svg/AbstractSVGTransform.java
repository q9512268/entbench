package org.apache.batik.dom.svg;
public abstract class AbstractSVGTransform implements org.w3c.dom.svg.SVGTransform {
    protected short type = SVG_TRANSFORM_UNKNOWN;
    protected java.awt.geom.AffineTransform affineTransform;
    protected float angle;
    protected float x;
    protected float y;
    protected abstract org.w3c.dom.svg.SVGMatrix createMatrix();
    protected void setType(short type) { this.type = type; }
    public float getX() { return x; }
    public float getY() { return y; }
    public void assign(org.apache.batik.dom.svg.AbstractSVGTransform t) {
        this.
          type =
          t.
            type;
        this.
          affineTransform =
          t.
            affineTransform;
        this.
          angle =
          t.
            angle;
        this.
          x =
          t.
            x;
        this.
          y =
          t.
            y;
    }
    public short getType() { return type; }
    public org.w3c.dom.svg.SVGMatrix getMatrix() { return createMatrix();
    }
    public float getAngle() { return angle; }
    public void setMatrix(org.w3c.dom.svg.SVGMatrix matrix) { type = SVG_TRANSFORM_MATRIX;
                                                              affineTransform =
                                                                new java.awt.geom.AffineTransform(
                                                                  matrix.
                                                                    getA(
                                                                      ),
                                                                  matrix.
                                                                    getB(
                                                                      ),
                                                                  matrix.
                                                                    getC(
                                                                      ),
                                                                  matrix.
                                                                    getD(
                                                                      ),
                                                                  matrix.
                                                                    getE(
                                                                      ),
                                                                  matrix.
                                                                    getF(
                                                                      ));
    }
    public void setTranslate(float tx, float ty) { type = SVG_TRANSFORM_TRANSLATE;
                                                   affineTransform =
                                                     java.awt.geom.AffineTransform.
                                                       getTranslateInstance(
                                                         tx,
                                                         ty);
    }
    public void setScale(float sx, float sy) { type = SVG_TRANSFORM_SCALE;
                                               affineTransform =
                                                 java.awt.geom.AffineTransform.
                                                   getScaleInstance(
                                                     sx,
                                                     sy);
    }
    public void setRotate(float angle, float cx, float cy) {
        type =
          SVG_TRANSFORM_ROTATE;
        affineTransform =
          java.awt.geom.AffineTransform.
            getRotateInstance(
              java.lang.Math.
                toRadians(
                  angle),
              cx,
              cy);
        this.
          angle =
          angle;
        this.
          x =
          cx;
        this.
          y =
          cy;
    }
    public void setSkewX(float angle) { type = SVG_TRANSFORM_SKEWX;
                                        affineTransform =
                                          java.awt.geom.AffineTransform.
                                            getShearInstance(
                                              java.lang.Math.
                                                tan(
                                                  java.lang.Math.
                                                    toRadians(
                                                      angle)),
                                              0.0);
                                        this.angle = angle;
    }
    public void setSkewY(float angle) { type = SVG_TRANSFORM_SKEWY;
                                        affineTransform =
                                          java.awt.geom.AffineTransform.
                                            getShearInstance(
                                              0.0,
                                              java.lang.Math.
                                                tan(
                                                  java.lang.Math.
                                                    toRadians(
                                                      angle)));
                                        this.angle = angle;
    }
    public AbstractSVGTransform() { super(); }
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
       "a7ZagX0uCCJpxav1JckZa6HZ5zsxoahxU5Oqomx6jUWkpMlS6I3aWrsDr2vx" +
       "OJiOdBTNtyk+/ta2Tx4odopOLgGsrVbekL6FHZL0xhMeHO1QXRaPDjvTk922" +
       "4udq6ebnamfOHi4cb1m9Jz9NBZHw5BD17OFpvq382M1uBxRbyl/86MuvKNRP" +
       "Vw+ODnaIqHQlcr1nLTVRrTPz3Q9G+sDNt8/HxeWI0wOHr330zx5ln199+C0c" +
       "qT6xx+f+kP9s/Oqv95+W/8FB6eLJ8cMbrm2c7/Tc+UOHewM1igOHPXf08NiJ" +
       "+J/Kpf0sKL0j8ff2NztPtX9jtXbz6id3JnSLw7N/cou2L+bVF6LSfXKgipE6" +
       "FqPASI91/e4b6PoMRWGSr7zZpt3ZGYsX//j8dm9+4DI6ksDoLUjg7F7vHsAL" +
       "pwTDguArt5DAV/Pqn0ele0IQJI+PoPd3KxPXUE4xv3obmAvHewgU5ggz81Yx" +
       "/8CbKvzf3KLtV/LqXwFIID9e5M8vnOL6pTuBSzjCJdx5XF+/Rdtv5tWv7nAt" +
       "93B97TZwvS1/mZ9DiUe4xDuD64yNXisIfu8W4H4/r34nKt0NQqmhFzcUfuEU" +
       "3r+/XbU9Aop1BM+682r741u0/ee8+gbwPn3nfYXPnkL75m1Ay42x9Dgo4RG0" +
       "8M5D+++3aHs9r/4MrG8A2i5q5i9+5hTct25Xb+8GJTsCl915cN+9Rdtf5tV3" +
       "QFoBwKH56eSey/3F7bpcftz7kSNsH7njLvczOcGFe24O8MKVvDoA2gvPau/U" +
       "6y5cvF2EFVA+cYTwE3cG4cFpblAce75QQHnHLWA+lFf3g/U/X/3yNM4CWcAe" +
       "0qu3i/SDoHz6COmn/zqRPnELpE/l1aPAYgHSmSxa+yi/73ZR/g1QfuoI5U/d" +
       "GZQXT78ZXtiDWr4F1Gfz6umd7TJ5JryP9ftvF+v7QfnSEdYv3XHv3CFs3QJh" +
       "O69qR8o01c1iD2D9TgD86hHAr/41AcRuAbCXV8+fAlzuAfyhtwIwjUrvvNFd" +
       "1/yy3iNvuHK/uyYu//wrVy+/6xXu94rr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nidXua+QpctabFln71adeb7bC1RtFyqv7G5aeQUcMio9crNruFHpIqhzpi8Q" +
       "O2oK8HsjakAJ6rOUTFS6tk8ZlS4Vv8/ScVHp3lO6PJEqHs6SLMDogCR/XHqF" +
       "CM9f0NhdRUt3H8KPnDWdYsF78M0UctLl7K3R/MO2+NeI44/QePfPES/KX35l" +
       "NPnR15s/vbu1KltiluWjXCZL9+wu0BaD5h+yT910tOOx7h488937v3Ll/ccf" +
       "3ffvGD414zO8PXHja6E924uKi5zZv3zXL/zgl175RnFf5P8CZYlnbLMyAAA=");
}
