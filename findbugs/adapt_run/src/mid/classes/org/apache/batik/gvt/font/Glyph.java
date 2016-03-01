package org.apache.batik.gvt.font;
public class Glyph {
    private java.lang.String unicode;
    private java.util.Vector names;
    private java.lang.String orientation;
    private java.lang.String arabicForm;
    private java.lang.String lang;
    private java.awt.geom.Point2D horizOrigin;
    private java.awt.geom.Point2D vertOrigin;
    private float horizAdvX;
    private float vertAdvY;
    private int glyphCode;
    private java.awt.geom.AffineTransform transform;
    private java.awt.geom.Point2D.Float position;
    private org.apache.batik.gvt.font.GVTGlyphMetrics metrics;
    private java.awt.Shape outline;
    private java.awt.geom.Rectangle2D bounds;
    private org.apache.batik.gvt.text.TextPaintInfo tpi;
    private org.apache.batik.gvt.text.TextPaintInfo cacheTPI;
    private java.awt.Shape dShape;
    private org.apache.batik.gvt.GraphicsNode glyphChildrenNode;
    public Glyph(java.lang.String unicode, java.util.List names, java.lang.String orientation,
                 java.lang.String arabicForm,
                 java.lang.String lang,
                 java.awt.geom.Point2D horizOrigin,
                 java.awt.geom.Point2D vertOrigin,
                 float horizAdvX,
                 float vertAdvY,
                 int glyphCode,
                 org.apache.batik.gvt.text.TextPaintInfo tpi,
                 java.awt.Shape dShape,
                 org.apache.batik.gvt.GraphicsNode glyphChildrenNode) {
        super(
          );
        if (unicode ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (horizOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        if (vertOrigin ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          unicode =
          unicode;
        this.
          names =
          new java.util.Vector(
            names);
        this.
          orientation =
          orientation;
        this.
          arabicForm =
          arabicForm;
        this.
          lang =
          lang;
        this.
          horizOrigin =
          horizOrigin;
        this.
          vertOrigin =
          vertOrigin;
        this.
          horizAdvX =
          horizAdvX;
        this.
          vertAdvY =
          vertAdvY;
        this.
          glyphCode =
          glyphCode;
        this.
          position =
          new java.awt.geom.Point2D.Float(
            0,
            0);
        this.
          outline =
          null;
        this.
          bounds =
          null;
        this.
          tpi =
          tpi;
        this.
          dShape =
          dShape;
        this.
          glyphChildrenNode =
          glyphChildrenNode;
    }
    public java.lang.String getUnicode() { return unicode; }
    public java.util.Vector getNames() { return names; }
    public java.lang.String getOrientation() { return orientation;
    }
    public java.lang.String getArabicForm() { return arabicForm; }
    public java.lang.String getLang() { return lang; }
    public java.awt.geom.Point2D getHorizOrigin() { return horizOrigin;
    }
    public java.awt.geom.Point2D getVertOrigin() { return vertOrigin;
    }
    public float getHorizAdvX() { return horizAdvX; }
    public float getVertAdvY() { return vertAdvY; }
    public int getGlyphCode() { return glyphCode; }
    public java.awt.geom.AffineTransform getTransform() { return transform;
    }
    public void setTransform(java.awt.geom.AffineTransform transform) {
        this.
          transform =
          transform;
        outline =
          null;
        bounds =
          null;
    }
    public java.awt.geom.Point2D getPosition() { return position;
    }
    public void setPosition(java.awt.geom.Point2D position) { this.
                                                                position.
                                                                x =
                                                                (float)
                                                                  position.
                                                                  getX(
                                                                    );
                                                              this.
                                                                position.
                                                                y =
                                                                (float)
                                                                  position.
                                                                  getY(
                                                                    );
                                                              outline =
                                                                null;
                                                              bounds =
                                                                null;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics() {
        if (metrics ==
              null) {
            java.awt.geom.Rectangle2D gb =
              getGeometryBounds(
                );
            metrics =
              new org.apache.batik.gvt.font.GVTGlyphMetrics(
                getHorizAdvX(
                  ),
                getVertAdvY(
                  ),
                new java.awt.geom.Rectangle2D.Double(
                  gb.
                    getX(
                      ) -
                    position.
                    getX(
                      ),
                  gb.
                    getY(
                      ) -
                    position.
                    getY(
                      ),
                  gb.
                    getWidth(
                      ),
                  gb.
                    getHeight(
                      )),
                java.awt.font.GlyphMetrics.
                  COMPONENT);
        }
        return metrics;
    }
    public org.apache.batik.gvt.font.GVTGlyphMetrics getGlyphMetrics(float hkern,
                                                                     float vkern) {
        return new org.apache.batik.gvt.font.GVTGlyphMetrics(
          getHorizAdvX(
            ) -
            hkern,
          getVertAdvY(
            ) -
            vkern,
          getGeometryBounds(
            ),
          java.awt.font.GlyphMetrics.
            COMPONENT);
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        return getOutline(
                 ).
          getBounds2D(
            );
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (bounds !=
              null &&
              org.apache.batik.gvt.text.TextPaintInfo.
              equivilent(
                tpi,
                cacheTPI))
            return bounds;
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        java.awt.geom.Rectangle2D bounds =
          null;
        if (dShape !=
              null &&
              tpi !=
              null) {
            if (tpi.
                  fillPaint !=
                  null)
                bounds =
                  tr.
                    createTransformedShape(
                      dShape).
                    getBounds2D(
                      );
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                java.awt.Shape s =
                  tpi.
                    strokeStroke.
                  createStrokedShape(
                    dShape);
                java.awt.geom.Rectangle2D r =
                  tr.
                  createTransformedShape(
                    s).
                  getBounds2D(
                    );
                if (bounds ==
                      null)
                    bounds =
                      r;
                else
                    bounds.
                      add(
                        r);
            }
        }
        if (glyphChildrenNode !=
              null) {
            java.awt.geom.Rectangle2D r =
              glyphChildrenNode.
              getTransformedBounds(
                tr);
            if (bounds ==
                  null)
                bounds =
                  r;
            else
                bounds.
                  add(
                    r);
        }
        if (bounds ==
              null)
            bounds =
              new java.awt.geom.Rectangle2D.Double(
                position.
                  getX(
                    ),
                position.
                  getY(
                    ),
                0,
                0);
        cacheTPI =
          new org.apache.batik.gvt.text.TextPaintInfo(
            tpi);
        return bounds;
    }
    public java.awt.Shape getOutline() { if (outline ==
                                               null) {
                                             java.awt.geom.AffineTransform tr =
                                               java.awt.geom.AffineTransform.
                                               getTranslateInstance(
                                                 position.
                                                   getX(
                                                     ),
                                                 position.
                                                   getY(
                                                     ));
                                             if (transform !=
                                                   null) {
                                                 tr.
                                                   concatenate(
                                                     transform);
                                             }
                                             java.awt.Shape glyphChildrenOutline =
                                               null;
                                             if (glyphChildrenNode !=
                                                   null) {
                                                 glyphChildrenOutline =
                                                   glyphChildrenNode.
                                                     getOutline(
                                                       );
                                             }
                                             java.awt.geom.GeneralPath glyphOutline =
                                               null;
                                             if (dShape !=
                                                   null &&
                                                   glyphChildrenOutline !=
                                                   null) {
                                                 glyphOutline =
                                                   new java.awt.geom.GeneralPath(
                                                     dShape);
                                                 glyphOutline.
                                                   append(
                                                     glyphChildrenOutline,
                                                     false);
                                             }
                                             else
                                                 if (dShape !=
                                                       null &&
                                                       glyphChildrenOutline ==
                                                       null) {
                                                     glyphOutline =
                                                       new java.awt.geom.GeneralPath(
                                                         dShape);
                                                 }
                                                 else
                                                     if (dShape ==
                                                           null &&
                                                           glyphChildrenOutline !=
                                                           null) {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             glyphChildrenOutline);
                                                     }
                                                     else {
                                                         glyphOutline =
                                                           new java.awt.geom.GeneralPath(
                                                             );
                                                     }
                                             outline =
                                               tr.
                                                 createTransformedShape(
                                                   glyphOutline);
                                         }
                                         return outline;
    }
    public void draw(java.awt.Graphics2D graphics2D) {
        java.awt.geom.AffineTransform tr =
          java.awt.geom.AffineTransform.
          getTranslateInstance(
            position.
              getX(
                ),
            position.
              getY(
                ));
        if (transform !=
              null) {
            tr.
              concatenate(
                transform);
        }
        if (dShape !=
              null &&
              tpi !=
              null) {
            java.awt.Shape tShape =
              tr.
              createTransformedShape(
                dShape);
            if (tpi.
                  fillPaint !=
                  null) {
                graphics2D.
                  setPaint(
                    tpi.
                      fillPaint);
                graphics2D.
                  fill(
                    tShape);
            }
            if (tpi.
                  strokeStroke !=
                  null &&
                  tpi.
                    strokePaint !=
                  null) {
                graphics2D.
                  setStroke(
                    tpi.
                      strokeStroke);
                graphics2D.
                  setPaint(
                    tpi.
                      strokePaint);
                graphics2D.
                  draw(
                    tShape);
            }
        }
        if (glyphChildrenNode !=
              null) {
            glyphChildrenNode.
              setTransform(
                tr);
            glyphChildrenNode.
              paint(
                graphics2D);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVbfZAcxXXv3ZPuTifdp76/T6cTRB/sIglJDifA4oR0h/d0" +
       "F+l0ZU42p7nZ2btBszOjmd67vSOKgLKC7KSAGIFlB6kKIxIjyxbBpoxtjOWy" +
       "AziKo0AoRxh/YPQHEETKimNLNknIe90zOx+7PcpKV85WTe/sdL/u36/79evX" +
       "b3pPvE8m2xZpMSU9LSXomKnYiR6875EsW0m3a5Jt98LTAfkzv3x4/8V/mXJv" +
       "nFT2k7phye6SJVvZoipa2u4nC1XdppIuK/Y2RUmjRI+l2Io1IlHV0PvJTNXu" +
       "zJqaKqu0y0grWKBPslKkUaLUUgdzVOl0KqBkcYqhSTI0yU3hAm0pMk02zDFP" +
       "YF5AoN2Xh2WzXns2JQ2pu6QRKZmjqpZMqTZty1tkpWloY0OaQRNKnibu0tY5" +
       "HXF7al1RN7Q8Xf/bDx4abmDdMF3SdYMyivZ2xTa0ESWdIvXe09s0JWvvJX9G" +
       "KlJkqq8wJa0pt9EkNJqERl2+XilAX6vouWy7wehQt6ZKU0ZAlCwJVmJKlpR1" +
       "qulhmKGGaupwZ8LAtrnA1h3uEMVHViYPfe7OhmcqSH0/qVf1HQhHBhAUGumH" +
       "DlWyg4plb0qnlXQ/adRhwHcolipp6rgz2k22OqRLNAcq4HYLPsyZisXa9PoK" +
       "RhK4WTmZGlaBXoYplfNrckaThoDrLI8rZ7gFnwPBGhWAWRkJdM8RmbRH1dNM" +
       "j4ISBY6tH4MCIFqVVeiwUWhqki7BA9LEVUST9KHkDlA+fQiKTjZABS2ma4JK" +
       "sa9NSd4jDSkDlMwJl+vhWVBqCusIFKFkZrgYqwlGaV5olHzj8/62jQ/crXfo" +
       "cRIDzGlF1hD/VBBaFBLarmQUS4F5wAWnrUg9Ks36zsE4IVB4ZqgwL/ONP73w" +
       "0VWLTr3My8wvUaZ78C5FpgPyscG6Vxa0L//jCoRRbRq2ioMfYM5mWY+T05Y3" +
       "wdLMKtSImQk389T2F++457jyXpzUdJJK2dByWdCjRtnImqqmWFsVXbEkqqQ7" +
       "yRRFT7ez/E5SBfcpVVf40+5MxlZoJ5mksUeVBvsNXZSBKrCLauBe1TOGe29K" +
       "dJjd501CSBVcZBpcKwj/sG9KdieHjaySlGRJV3Uj2WMZyB8HlNkcxYb7NOSa" +
       "RnIQ9H/PdasTG5K2kbNAIZOGNZSUQCuGFZ6ZHBqhyQx0U3KrNmYOJ1DTzD9A" +
       "G3nkOX00FoMhWBA2ABrMnQ5DSyvWgHwod+ttF746cJorF04Ip4dgPkFDCd5Q" +
       "gjWUgIYS2FCCNURiMVb/DGyQDy8Mzh6Y5mBnpy3f8cnbdx9sqQC9MkcnQc9i" +
       "0WuK1p12zx64RnxAPvHK9otnflRzPE7iYDIGYd3xjH9rwPjztcsyZCUN1ke0" +
       "DLimMCk2/CVxkFOHR+/t2389w+G351jhZDBFKN6DVrjQRGt4Hpeqt/7+d357" +
       "8tF9hjejAwuEu64VSaKhaAmPZpj8gLyiWXp24Dv7WuNkElgfsLhUghkCxmxR" +
       "uI2AwWhzjS9yqQbCGcPKShpmuRazhg5bxqj3hKlZI7ufAUM8FWdQA1xbnCnF" +
       "vjF3lonpbK6WqDMhFsy437TDPHL2n95dy7rbXQfqfQv4DoW2+WwPVtbErEyj" +
       "p4K9lqJAuZ8d7nn4kffv38X0D0osLdVgK6btYHNgCKGbD7y89/Vf/PzYa3FP" +
       "ZyksvrlB8GPyBZL4nNREkEQ99/CA7dJgbqPWtO7UQSvVjCoNagpOkv+qX7b6" +
       "2fMPNHA90OCJq0arLl+B93zureSe03deXMSqicm4dnp95hXjBnm6V/Mmy5LG" +
       "EEf+3lcXfv4l6QiYdjCntjquMAtZy/qgljGfA64Uk8RlMsGXSahtsX9Co6e3" +
       "Izdo0+3SKFu/BuS/bDlw77VVF9bz5aW5ZGnfUrf24vr65uNf0nnx1tKVBxe5" +
       "t+4+/UXjp+/F3QWslAgv+TG768y3Ot4eYOpVjVYFnyO5Wp+92GQN+XS7oTDs" +
       "dTjKTXA95Qz7U3y5uGtCTTlUAh6dmoXeTfaqWSWNHqUCFtdZOP6AreXtUHey" +
       "NryhffZbf7Ph4KqPf5F3/BKBafXKf/NP3nzlyPjJE1zZsfspWSnyiotdcbR9" +
       "yyLst6dEv9l646l3z/V9EoHh6NVhsjHvqnGdf7niM24zy1uLE76wVM0KaxKv" +
       "vHL1kd/t//Oz3WBbO0l1Tlf35pTOtH/pBDfTzg36VMvz/9gDv159CJ8YXP+D" +
       "F+oTPuB61dTu+ELNBWfINPOYT0lsBdxiBeu8xKU3k9GTRmliSDGy4HCBu7xm" +
       "M2ambNGU6rFAB6g64nA8Oevi3h9UjW92O/BGTDpRH5ZH7JyCdST3Nf1iz2Pv" +
       "fIVrR9hRDRVWDh76zIeJBw5x1eDe/NIih9ovwz163pUFdEuiWmESW94+ue/b" +
       "X9p3P0fVFPRNb4Ot11d+/N//mDj85g9LuEOwIBkSDWsK/uxgOLpZ1jYHDX71" +
       "+O57KalQdYG4O3bXlvS4cBuW6IWkB5Zx2gkObVCVcax3DEvOmgyPl5SsZqsl" +
       "mcOqbG+DUWeAb2DlkwVIhEHiQ85ot9p+fyY44r5t64D80Gu/qu371QsXWK8F" +
       "973+5btLMvmQNWKyDIdsdth37JDsYSh3w6ltn2jQTn0ANfZDjTKYL7vbAo81" +
       "H1jsndKTq37yve/P2v1KBYlvITUwTOktEvObyBRwWBR7GJzdvHnLR7nhHq12" +
       "vBSSJ0XkcYlcXHrxvS1rUrZcjj83++sb//boz5mfwAdvPhNHz6a5yGSymInn" +
       "nZ1/46/PfffiE1VcByNmVEhuzu+7tcH73rpU1MnMGS0xyULy/ckTj81rv/k9" +
       "Ju95hSi9NF+8SwC/2ZNdczz7m3hL5d/HSVU/aZCd+ESfpOXQ1+qHPbntBi1S" +
       "pDaQH9xf881kW8HrXRCe5b5mw/6o38ROogFz6rmguKEj8+Fa5SzTq8IuaIyw" +
       "mxEmcg1Ll2OyyvX4qkxLHQF7G3L5pkZUCkKwFMgwswoGeTqTzmAyymtShQpo" +
       "BuHPhes6p6XrBPD3c/iYjBXjFEmDFcNOtJnEhqBvgzcpRy7F16Dxifc2RlAn" +
       "MOqlZiWKbmyvJek27jRwZjGNcX2d/8fW+YDdgsmBgnVu8MxCn4LmBZ9/Wrwg" +
       "+DTgnjI1YDFcCWcsEgINeCBSA0TSlEw1LBV8PMndQYW19cEysS6CK+m0lhRg" +
       "fSQSq0iakhrYmA2q8hYYoFJQHy0T6hy4rncau14A9bFIqCJpCts3sG+lQB4p" +
       "E2QzXKudZlYLQD4RCVIkDWM/DIM/3m2pQyob+1QI67Er0NM1TmtrBFiPR2IV" +
       "ScPYjygWFUP9cplQF8C11mlsrQDq30VCFUlTMoV166b0yMfxQXcI6TNlIsXV" +
       "6wanrRsESJ+LRCqSpqQaOxWA3lEK6DfLBDoPrnVOU+sEQL8bCVQkDV06hCHG" +
       "dmdFvSOE9FSZSK+Ba73T1noB0hcjkYqkASl11xB3oVgY3IJtymTA0SqsNCEq" +
       "L5VJZSlcGxwwGwRUzkRSEUlTL7LmMplfcjPZugV3QiEe/1wmj1a4PuIg+YiA" +
       "x9lIHiJpyt7zWLDVcWksj4hk9/WyYHYXlwiRev0KZsSNDqwbBaR+GUlKJA2k" +
       "jBzFNx34c3cI51tXYLfbnJbaBDjficQpkqakctDI6elC388NqtB28JxgodQU" +
       "HpPwcXj3CvyOmxwUNwk4XIjkIJKGrTo1Vby9M4TxP65gst7stHKzAOOlSIwi" +
       "aZisMupzb09nKaC/u4Itxy1OU7cIgH4YCVQkDQqRZtGJEnobI2XCXAmXU5R/" +
       "F8OMVUbCFElT0shXnGFVS1uKvs1ZeQZDiKsiEOe9llcUWmafShJ6zehrmZWc" +
       "74QfbIssFL0JZhGsY/cdOprufnK1G5vbiQuQYV6nKSOK5qtqBouHhUMRXez9" +
       "t7ev3/DqxYo3PjtnWvGLNqxpkeA12gpxzCLcwEv3/du83puHd5fxBm1xiH+4" +
       "yqe6Tvxw6zXyZ+PsFT4PIxS9+g8KtQWDBzWWQnOWHozIthRGDIP8zF00nREz" +
       "w5rm6URosAvvhkSirGTJkFtsYUTeYkzAmNYMKXSnL9Dg6eXcy82kQJALH7Ax" +
       "iM0I0sYFbMzBPlY+bZFoBLXlEXkrMWkFUwe0t2HcAgt9yiO9bGJIN8N1wEF+" +
       "oHzSItEIYusi8jZgcj0ldUC6O7RV96ivnhjq6Ag86OB/sHzqItEIepsi8tox" +
       "2UhJLVDfFNz5e8xvmhjmuOIdduAfLp+5SDSCXVdEHm7FYh3g5AHzlBtI8Dh3" +
       "XjXn6Zi1BK7HHeCPl89ZJBrB646IvF2Y9HJF7wjFJTzqOyeGejNcxx38x8un" +
       "LhKNoKdE5OH4xnZzRe8Lhjk85tJVM2/ErIVwfc2B/7XymYtEI9jtjchjCGHF" +
       "nuYOeiFq4hHPTgxxXMKfd9A/Xz5xkWgEuX0RefsxyVMy1RnyQhDG4z121bzr" +
       "MQvjRy864F8sn7dINILbpyPy/gKTT/EB3xqI6XjED1w1ceRMroXrjIP+TPnE" +
       "RaIR5B6JyPscJg9x4oHgz2mP+F9dNXF25AojOWcd9GfLJy4SDZHzveA4zRg+" +
       "HsH+CUweA/a2jz0rGXorPmnEUNNej1w2Wv5/M/cYHDjn0DpXfo+IRCMIPx2R" +
       "9wwmX+Zzv8d3eM1n7E9MjCbgC7/zDvjz5fMWiYo1IcUIPh9B/gVMvgHk7QD5" +
       "2JMe+ecmZv7jzvqSw+BS+eRFohHcXo7I+wdMvk9JvWv4fCHGn3ncfzBh3GON" +
       "vAb+XRZ3oWiIX5zhiONP9vKgmzF9LaIXfozJmcv2wmWjx5fthdmY9UdAYa5D" +
       "ZW75vSASjeD3ZkTeW5i8gZEl4K4YGJQeu5UFR7H0+x77n04M+xaAvtChsLB8" +
       "9iLRCIbnI/L+HZO3udHjrHnI18f7nYlx9GACxJyTC/y7PN4i0QhulyLyfo/J" +
       "r3msptsXsvdo/+fE2PqVgFl3sOvl0xaJlrb17Pcc6hwfxnC+e55szWZsLD5J" +
       "3CXxakT/Iaz1aUsa3Ruw/fHLhoCLOwO86MnMluBhrTlFf2/if8mRv3q0vnr2" +
       "0Z3/yk7BF/42My1FqjM5TfOfJfLdV5qWklFZ703jJ4vYQct4PSVzhS+RgBh+" +
       "Idp4HS/fRMmMUuUpqYDUX3ImJQ3hksCPffvLYfTPK0dJJb/xF5kPtUMRvF1g" +
       "ugPmO7XND1/l+VgWIs7uSJCZlxsJX5B6aSAEzP6I5oZrcz3Ogd+TR2/fdveF" +
       "9U/y4/yyJo2PYy1TU6SK/7OAVVpRdHjYX5tbV2XH8g/qnp6yzA17N3LAnpbP" +
       "99SNgEbHTNSNeaGz7nZr4cj768c2vvCjg5WvxklsF4lJoNi7io+p5c2cRRbv" +
       "SpU6CtwnWewYflvNud1nLv0k1sROAxJ+eHhRlMSA/PALb/RkTPMLcTKlk0xW" +
       "9bSSZ2foNo/p2xV5xAqcLHbep7G+SpE6VGQJT9+znnE6tLbwFP8OQklL8eHZ" +
       "4r/I1GjGqGIx04zV1IaC5DnT9Oeynt2KSWceexp0bSDVZZrOieXKX7OeN02c" +
       "ovEk/uj4XwQqv6NtOgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xcyZA8CYFVmKYbW6FOnG85FmkuuaQbGT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZZqKg76uYjgk5vV0NVt2YrHCaXqYZsIggzk3Gxvtbi2Hq/AiDwbjxOKyZqNG" +
       "NkMXVekhzSz8jM2gZX8ygToEkq7phmh12vAGVjRuEHhiYNFsecK6HU6muTrR" +
       "6GVsqPSWWFrzKHBgdtgyialDkazWcc8azRQV6+pML6vxbYnKEw2v5dyyTIVU" +
       "uQWEiENy1corQVf0AtZxO9PhULPgTXWW1KEBpIANhuVW2j44uZZprjWg2bTK" +
       "YZuNI5alPGmqiDaAXbSDDazWYtlCobydWHldH8zMuQfTypRmDYyAlmCXtqRW" +
       "6Lhdr/YGWllTHClBrTxZ85sywZc1jvQMShE9lC5v1EECXG0yS2o6sI0u4ip6" +
       "ThhIdzRM8EVZ5CTEm5m0WM8NExyLsaS/dHISY2QaYMx7jpJUN87MSut6ZKjO" +
       "HJuq+Fyut6UZWk94nLe0NiKtJtqsbjaXUseu9Wvzbm+sxfUpyaFUpZyiqFup" +
       "DcqpjCdRywgZoomZwKTTC5eGmDIljZBYpayAcmm4CXavczvFungr7WWTFpSh" +
       "7LBmVsZGbGdMpntQL0Cc0AcngDBRPaisd6rsWliSNhKOEruSyj07WMAoqygN" +
       "Y6Onbqus1ethPpNCpl3vIS0xlVcTiJZzWJ6GMsLFG0inGMNrMaPNqNkA+xQ7" +
       "JoxgYpN6FTL1psMlyLqSuEG1IiFQtkIJEqpVgdaRa2tQn+gjvaeDk1V9PVvZ" +
       "pIRWEKtXS+ZjJaqxvJAbfJlbEkaZVv0axUM6N3AG03jqr+ftqYjQTm+MGKuw" +
       "BfZOCTPXJ2y/ovZ6Cygl6ys2ArYuIeFlvGSdESoO2zBkl4XljA7RmO+1JDsN" +
       "eyJQVpnHOznboOueFCg5Mlqq5QlXhXQ10UhsCmU1KMt6XpWdZ/Bk2uD7EDrC" +
       "BcHnwJTPxXq0EKoi1VxCa9dvZDkOo0OEwcHpk8UwfrjsLKjJkB9qcjdHXSmo" +
       "KRY4HynVJGlZy/osSVd2SNbsnjc0UdMr+3WlqnDcIuH9aaMVbdyZtpnrdjKM" +
       "VdhlksoKDrkRnvbKGmWAwxyPQyzOLCBuNWEHjDLp26tKOsMWPC9VdW/oQX41" +
       "FeopvlYYaqH5aLfM+52G0B33Jlg5d91OI2IWG5JtjsYrm2lqlFQLIBruWt11" +
       "l04rtVyAablVb7sTbKRlblTt8zNF01K/suDbgiQFI1MT+yI60oaVquIlnRUU" +
       "WzVxM14njWE0WuL4uvT2c9df2WPku7dPxy8G5j+L5+K7ooeK7OUXf1TY/t1Y" +
       "OhHMfeRHhW3N+/YRVGFQeuC0ePttMN3H3vHkR9TRL8IHoYxE8cOs57/O1hLN" +
       "PtJVEWr6mtPDrwbb1w0OY6A+/47/dv/kMeOtVxDO/NITOE92+cuDT3yh+wrl" +
       "b50vXXcxIuppL0Icb/To8TioWwMtigN3ciwa6oGLM1vEAm1DFPz9zPonf645" +
       "lN2lf6t51U7227JLhvKdu/+MshcX2b1R6dalFk2PRFFdVJZzz3+mnxWOdlnc" +
       "OHfPcXbFr7HZnl127dm94oyyYoWceygq3QzYDS8RjrUN6L77mfBto67swxl5" +
       "+Gpn5EGQ3rkf8Z3XfkZqZ5Q1igyKSneAGRmdiOE6ZFi5WobFj93v3TN877Vn" +
       "+KYzyogiezQq3Q4Y4seDwQ4JvuFqCRa/+n5wT/CD154gc0bZsMi6UekmQJA5" +
       "iCo7pEZdBbXnFjeLcPKP7ql99NpTE88ok4qM32kndSI87ZDh5GoZPgjSx/cM" +
       "P37tGapnlOlF9sROO4XjcW6HBN96FQS37voBkH5jT/A3rj1B/4yyIk713Coq" +
       "3XYgwosBc4f87KvlVzjM397z++1rz+/Hzyh7e5FtotJz9gK8GHl3SO8Zg0zP" +
       "oHdncbOIDfzcnt7nrj29d59R9jNF9td24useC+E75PfXr4JfQa30SpC+tOf3" +
       "pWvP78kzyj5QZO/d8TsW5ffJQ37vuwp+2x1FEer31T2/r14bfucOK3xyS+Tv" +
       "nUHyF4rs5wHJ8AjJbc2TYSSJZ6qHxD90tYa1CBn75p74N6+9YD91RtmvFdnH" +
       "d+uSPfIC3RGz+g+uVq5FsP539/S+e83lim15fPoMjp8psn8EOIbHOJ772CHH" +
       "37ratVmc7H6w5/iDay/Cz59R9oUi+5dR6c4D23MkGvSfH1L87DWgeG5/qt19" +
       "Xj3F89sK54uv2xDsx7aEfv8Msv+uyH7vGcl+6SrIvqC4+SqA+4V7si+89vL8" +
       "+hllf1hkXyuCCAFFzSuigTNiG7ta1P7SIclnDLl8JpIPA7wP7Ek+cO1JfueM" +
       "su8V2X/d2Z0duV3g7RF6f3y12x2gteeYPT3m2tP7izPK/leR/Y/d84HRkWDo" +
       "Q3Z/erVWtQyAunt27rVht7eq2+/3Rvt3gosQ6YNXIKvtot35605nfv6mAupf" +
       "Ah+pBvJmfdzK/uhKOKdR6YbtCi9eT77vaf8uZPcvLpRf+cidN7/gI9P/sH2p" +
       "/eK/obiFKd2sx7Z99MW6I9c3+oGmm9spuGX3mp2/xX5HVHrhqcH2gFLxUeA8" +
       "f/uu/t1R6XmXqh+VrgP50ZrPi0p3nawJ+G0/j9Z7AVCZw3pR6cbdxdEq94Pe" +
       "QZXi8kX+gaiOBNju3kRMd1K874gC7R5i3vNMMjjyOPJlxx4ibv+xy8EDv5jd" +
       "v8j9qY/0hj/2/cYv7t7OV2w5z4tebmZKN+3+UcC20+Kh4UOn9nbQ143Uq394" +
       "x6/e8vKDB5x37AAfKvMRbC+99KvwHcePti+v5//4Bf/wDX//I3+wjTD+f3L8" +
       "co9xRwAA");
}
