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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae2wcxRmfO8eO4/gVJ3ackDgPnEh53ZEA5eE0xTF24nBO" +
       "XNtYxClxxntz5433dpfdOftsGiCRqqRFRSmER3n4r6AABYIQiD4ApUUtIOgD" +
       "SAu0IlSlVWkBlbQqpaWUft/s3u3e3u2mV9WNtJP1zHwz3/ebb37fN7P38Aek" +
       "3DRIC1N5hE/qzIx0qryXGiaLdyjUNAegbli6s4z+Ze+7Oy8Lk4ohUjtKzR6J" +
       "mqxLZkrcHCJLZdXkVJWYuZOxOEr0GsxkxjjlsqYOkUbZ7E7piizJvEeLM+ww" +
       "SI0YmUc5N+SRNGfd9gCcLI2BJlGhSbTd29wWI9WSpk863Ztd3TtcLdgz5cxl" +
       "clIf20/HaTTNZSUak03eljHIOl1TJpOKxiMswyP7lYttCHbELi6AYOVjdR99" +
       "cnS0XkAwn6qqxoV5Zh8zNWWcxWOkzqntVFjKvI7cQMpiZK6rMyetseykUZg0" +
       "CpNmrXV6gfY1TE2nOjRhDs+OVKFLqBAnK/IH0alBU/YwvUJnGKGS27YLYbB2" +
       "ec5ay8oCE29fFz125976x8tI3RCpk9V+VEcCJThMMgSAstQIM8z2eJzFh8g8" +
       "FRa7nxkyVeQpe6UbTDmpUp6G5c/CgpVpnRliTgcrWEewzUhLXDNy5iWEQ9l/" +
       "lScUmgRbmxxbLQu7sB4MrJJBMSNBwe9skVljshrnZJlXImdj61XQAURnpxgf" +
       "1XJTzVIpVJAGy0UUqiaj/eB6ahK6lmvggAYni30HRax1Ko3RJBtGj/T067Wa" +
       "oNccAQSKcNLo7SZGglVa7Fkl1/p8sHPzLder29UwCYHOcSYpqP9cEGrxCPWx" +
       "BDMY7ANLsHpt7A7a9MyRMCHQudHT2erz1JfPXrG+5dQLVp/zivTZNbKfSXxY" +
       "Oj5S+8qSjjWXlaEalbpmyrj4eZaLXdZrt7RldGCYptyI2BjJNp7q+9Humx5i" +
       "74VJVTepkDQlnQI/midpKV1WmLGNqcygnMW7yRymxjtEezeZDe8xWWVW7a5E" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "79whRG+BsJVX1SNlLrWE3wOI3AmAXzoC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+KW/IYDELQB28uq5U4DCHsDvfzMA07j09hvdl80v/D3yuqv5u+vkys+9fPXy" +
       "O16e/0FxZfTkyvcVqnRZXzvO2ftZZ57vDkJN34XKK7vbWkEBh4pLj9zsKm9c" +
       "ugjqnOkLwx31CPB7I2pACeqzlNO4dG2fMi5dKn6fpZvHpXtP6fJEqng4S8KD" +
       "0QFJ/igEhQjPX/LYXWdLdxvhR86aTrHgPfhGCjnpcvbmab6xLf6F4ngTut79" +
       "E8ULyhdeHjA//Frjp3Y3XxVHyrJ8lMtU6Z7dJdxi0Hwj+9RNRzse6+7eM9++" +
       "/4tX3nu86b5/x/CpGZ/h7YkbXy3tuEFcXAbN/tU7fuF7P//yV4s7J/8XdPiX" +
       "ctsyAAA=");
}
