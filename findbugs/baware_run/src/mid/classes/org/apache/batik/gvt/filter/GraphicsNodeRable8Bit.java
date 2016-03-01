package org.apache.batik.gvt.filter;
public class GraphicsNodeRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.GraphicsNodeRable, org.apache.batik.ext.awt.image.renderable.PaintRable {
    private java.awt.geom.AffineTransform cachedGn2dev = null;
    private java.awt.geom.AffineTransform cachedUsr2dev = null;
    private org.apache.batik.ext.awt.image.rendered.CachableRed cachedRed =
      null;
    private java.awt.geom.Rectangle2D cachedBounds = null;
    private boolean usePrimitivePaint = true;
    public boolean getUsePrimitivePaint() { return usePrimitivePaint; }
    public void setUsePrimitivePaint(boolean usePrimitivePaint) { this.usePrimitivePaint =
                                                                    usePrimitivePaint;
    }
    private org.apache.batik.gvt.GraphicsNode node;
    public org.apache.batik.gvt.GraphicsNode getGraphicsNode() {
        return node;
    }
    public void setGraphicsNode(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          node =
          node;
    }
    public void clearCache() { cachedRed = null;
                               cachedUsr2dev = null;
                               cachedGn2dev = null;
                               cachedBounds = null; }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 java.util.Map props) { super(
                                                          (org.apache.batik.ext.awt.image.renderable.Filter)
                                                            null,
                                                          props);
                                                        if (node ==
                                                              null)
                                                            throw new java.lang.IllegalArgumentException(
                                                              );
                                                        this.
                                                          node =
                                                          node;
                                                        this.
                                                          usePrimitivePaint =
                                                          true;
    }
    public GraphicsNodeRable8Bit(org.apache.batik.gvt.GraphicsNode node,
                                 boolean usePrimitivePaint) {
        super(
          );
        if (node ==
              null)
            throw new java.lang.IllegalArgumentException(
              );
        this.
          node =
          node;
        this.
          usePrimitivePaint =
          usePrimitivePaint;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        if (usePrimitivePaint) {
            java.awt.geom.Rectangle2D primitiveBounds =
              node.
              getPrimitiveBounds(
                );
            if (primitiveBounds ==
                  null)
                return new java.awt.geom.Rectangle2D.Double(
                  0,
                  0,
                  0,
                  0);
            return (java.awt.geom.Rectangle2D)
                     primitiveBounds.
                     clone(
                       );
        }
        java.awt.geom.Rectangle2D bounds =
          node.
          getBounds(
            );
        if (bounds ==
              null) {
            return new java.awt.geom.Rectangle2D.Double(
              0,
              0,
              0,
              0);
        }
        java.awt.geom.AffineTransform at =
          node.
          getTransform(
            );
        if (at !=
              null) {
            bounds =
              at.
                createTransformedShape(
                  bounds).
                getBounds2D(
                  );
        }
        return bounds;
    }
    public boolean isDynamic() { return false;
    }
    public boolean paintRable(java.awt.Graphics2D g2d) {
        java.awt.Composite c =
          g2d.
          getComposite(
            );
        if (!org.apache.batik.ext.awt.image.SVGComposite.
               OVER.
              equals(
                c))
            return false;
        java.awt.color.ColorSpace g2dCS =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          getDestinationColorSpace(
            g2d);
        if (g2dCS ==
              null ||
              g2dCS !=
              java.awt.color.ColorSpace.
              getInstance(
                java.awt.color.ColorSpace.
                  CS_sRGB)) {
            return false;
        }
        org.apache.batik.gvt.GraphicsNode gn =
          getGraphicsNode(
            );
        if (getUsePrimitivePaint(
              )) {
            gn.
              primitivePaint(
                g2d);
        }
        else {
            gn.
              paint(
                g2d);
        }
        return true;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext renderContext) {
        java.awt.geom.AffineTransform usr2dev =
          renderContext.
          getTransform(
            );
        java.awt.geom.AffineTransform gn2dev;
        if (usr2dev ==
              null) {
            usr2dev =
              new java.awt.geom.AffineTransform(
                );
            gn2dev =
              usr2dev;
        }
        else {
            gn2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
        }
        java.awt.geom.AffineTransform gn2usr =
          node.
          getTransform(
            );
        if (gn2usr !=
              null) {
            gn2dev.
              concatenate(
                gn2usr);
        }
        java.awt.geom.Rectangle2D bounds2D =
          getBounds2D(
            );
        if (cachedBounds !=
              null &&
              cachedGn2dev !=
              null &&
              cachedBounds.
              equals(
                bounds2D) &&
              gn2dev.
              getScaleX(
                ) ==
              cachedGn2dev.
              getScaleX(
                ) &&
              gn2dev.
              getScaleY(
                ) ==
              cachedGn2dev.
              getScaleY(
                ) &&
              gn2dev.
              getShearX(
                ) ==
              cachedGn2dev.
              getShearX(
                ) &&
              gn2dev.
              getShearY(
                ) ==
              cachedGn2dev.
              getShearY(
                )) {
            double deltaX =
              usr2dev.
              getTranslateX(
                ) -
              cachedUsr2dev.
              getTranslateX(
                );
            double deltaY =
              usr2dev.
              getTranslateY(
                ) -
              cachedUsr2dev.
              getTranslateY(
                );
            if (deltaX ==
                  0 &&
                  deltaY ==
                  0)
                return cachedRed;
            if (deltaX ==
                  (int)
                    deltaX &&
                  deltaY ==
                  (int)
                    deltaY) {
                return new org.apache.batik.ext.awt.image.rendered.TranslateRed(
                  cachedRed,
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinX(
                          ) +
                        deltaX),
                  (int)
                    java.lang.Math.
                    round(
                      cachedRed.
                        getMinY(
                          ) +
                        deltaY));
            }
        }
        if (false) {
            java.lang.System.
              out.
              println(
                "Not using Cached Red: " +
                usr2dev);
            java.lang.System.
              out.
              println(
                "Old:                  " +
                cachedUsr2dev);
        }
        if (bounds2D.
              getWidth(
                ) >
              0 &&
              bounds2D.
              getHeight(
                ) >
              0) {
            cachedUsr2dev =
              (java.awt.geom.AffineTransform)
                usr2dev.
                clone(
                  );
            cachedGn2dev =
              gn2dev;
            cachedBounds =
              bounds2D;
            cachedRed =
              new org.apache.batik.gvt.filter.GraphicsNodeRed8Bit(
                node,
                usr2dev,
                usePrimitivePaint,
                renderContext.
                  getRenderingHints(
                    ));
            return cachedRed;
        }
        cachedUsr2dev =
          null;
        cachedGn2dev =
          null;
        cachedBounds =
          null;
        cachedRed =
          null;
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NM16cVD6Mte8pqF1h76JP675LxLXHPYLKAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7eewrx30f39P5dL0nybJkRZIl+Sm2Rfu3B5fkrp8bm7s8" +
       "drkHl8vl8mhteS8u9755pbITB62NulCMRHacIBb6h4MmgRIbQYKmMFKoLXK4" +
       "MQo4CNI0QGP3QpImBiIYSdO6qTu7/F3v9w7rVSpKYIbDme/MfD/z/c53vnPw" +
       "1W9X7kiTSjUKva3lhdmBuckOHK9+kG0jMz3oc3VRTVLToDw1TWWQ94L+7Fcu" +
       "/vV3P7u8dL5y57zysBoEYaZmdhikkpmG3so0uMrFk9yOZ/ppVrnEOepKhfLM" +
       "9iDOTrMrXOXeU1WzymXuiAUIsAABFqCSBah1QgUq3W8GuU8VNdQgS+PKxyvn" +
       "uMqdkV6wl1WeubqRSE1U/7AZsUQAWri7+K0AUGXlTVJ5+hj7HvM1gD9XhV7+" +
       "qY9e+pXbKhfnlYt2MCrY0QETGehkXrnPN33NTNKWYZjGvPJgYJrGyExs1bN3" +
       "Jd/zykOpbQVqlifm8SAVmXlkJmWfJyN3n15gS3I9C5NjeAvb9IyjX3csPNUC" +
       "WN9+gnWPsFvkA4D32ICxZKHq5lGV2107MLLKO8/WOMZ4mQUEoOpdvpktw+Ou" +
       "bg9UkFF5aC87Tw0saJQldmAB0jvCHPSSVR6/YaPFWEeq7qqW+UJWeewsnbgv" +
       "AlQXyoEoqmSVR86SlS0BKT1+Rkqn5PNt4YMv/XBAB+dLng1T9wr+7waVnjpT" +
       "STIXZmIGurmveN/z3OfVt//Gp89XKoD4kTPEe5p/9vdf//D7nnrtd/Y0P3Ad" +
       "moHmmHr2gv4l7YFvPEG9l7itYOPuKEztQvhXIS/VXzwsubKJwMx7+3GLReHB" +
       "UeFr0m/NfuQXzT8/X7mHqdyph17uAz16UA/9yPbMpGcGZqJmpsFULpiBQZXl" +
       "TOUukObswNznDhaL1MyYyu1emXVnWP4GQ7QATRRDdBdI28EiPEpHarYs05uo" +
       "UqncBULlfSAglf0HKqKskkDL0DchVVcDOwghMQkL/IVAA0OFMjMFaQOURiGk" +
       "Af13348cNKE0zBOgkFCYWJAKtGJp7gsha5VBgB+gS1AvUaOlradCaJiSqnkm" +
       "TtrAGAHdi/6/9LopxuLS+tw5IKYnzhoJD8wvOvQMM3lBfzknO6//8gu/e/54" +
       "0hyOYlZBQNcH+64Pyq4PQNcH+64Prtt15dy5sse3FSzslQKI1AXGAZjN+947" +
       "+kj/Y59+9jagjdH6diCP2wApdGPrTZ2YE6Y0mjrQ6cprX1j/qPIJ+Hzl/NVm" +
       "uGAbZN1TVBcL43lsJC+fnX7Xa/fip/70r7/8+RfDk4l4lV0/tA/X1izm97Nn" +
       "BzgJddMAFvOk+eefVn/thd948fL5yu3AaABDmalAsYENeupsH1fN8ytHNrPA" +
       "cgcAvAgTX/WKoiNDd0+2TML1SU4p+QfK9INgjO8tFP9pEJLDmVB+F6UPR0X8" +
       "tr2mFEI7g6K0yX9nFH3xD//tn9XK4T4y3xdPLYgjM7tyymQUjV0sjcODJzog" +
       "J6YJ6P7DF8Sf/Ny3P/V3SwUAFO+6XoeXi5gCpgKIEAzzP/id+N9/84+/9Pvn" +
       "j5XmXAbWzFzzbH1zDLLIr9xzE5Cgtx884QeYHA9MwEJrLo8DPzTshV2ocKGl" +
       "/+vic8iv/cVLl/Z64IGcIzV63/dv4CT/HWTlR373o//9qbKZc3qx5J2M2QnZ" +
       "3o4+fNJyK0nUbcHH5kd/78mf/m31i8AiAyuY2juzNGzn9mNQIn8EOA3XnaKn" +
       "52YpXqikf76MD4qhKVuplGW1InpnenqaXD0TTzkxL+if/f2/vF/5y3/xeonr" +
       "ai/otFbwanRlr4hF9PQGNP/oWZtAq+kS0GGvCX/vkvfad0GLc9CiDmxeOkiA" +
       "bdpcpUOH1Hfc9Uf/8l+//WPfuK1yvlu5xwtVo6uW07FyAcwDM10Cs7aJPvTh" +
       "vRqs7wbRpRJq5RrwZcbj106Ujx/q0MevP1GK+Jkieu5a9btR1TPDf77k4Hzx" +
       "EwYj88wNBl5S16Wn8IL+z4ff+sYXd19+da+UmgqWwkr1Rk7ntX5vYaOeu4md" +
       "PXFH/qr3gdf+7D8rHzl/qBz3HmN8poB0GYRPHGL8xNnhOdLJ+0+EBgRWZHbL" +
       "tj58EyVkiuhKWYQV0Qf3rTXflCBfOuT0pVsX5I2q3lyQ773JTiSxfWAgV4fe" +
       "G/TiQ990f/ZPf2nvmZ119c4Qm59++R997+Cll8+f8offdY1LerrO3icucd6/" +
       "B/c98DkHwv8uQgGqyNj7RA9Rh47Z08eeWRRtrtLL67BVdtH9ky+/+NWff/FT" +
       "exgPXe0OdsBu55f+4G+/fvCFb33tOt7FXVoYeqYalFxKN9GNjxYRf6Ibwq3o" +
       "xp72sfLXhZuLqFvsVE5W7Mf+58DTPvmf/uYaS1c6GteR2pn6c+jVn32c+qE/" +
       "L+ufrPhF7ac21zplYFd3Uhf9Rf+vzj9752+er9w1r1zSD7eMiurlxTo6B9uk" +
       "9GgfCbaVV5VfveXZ+/dXjj2aJ86qzaluz/oaJ+IC6YK6SN9zxr24rxhlFITa" +
       "4YypnZ1s5yplYrmfb2V8uYjefbSa3xUl9gpoXdnyJAPbyGI5M3oBapirI6Py" +
       "ZGlU1HV2YJmhf9BaLMBgyokapIVHdDKhSw2xv5+G6Nfyjx3yj92A/+QG/BdJ" +
       "74j1+/esj9Ok4L3IDM6wlv5fsFY/ZK1+A9a2b4S1C3vWJNM4GtLaNb5DMSWK" +
       "IbZ9sLk9AE4oWIVN44ACJIV3A+qeQbO7RTQwCI1DNI0boPnkG0FzqCNkmAdG" +
       "egToHVfriAQ0H8wBz0TbZ9j+sVtk+/0gfOCQ7Q/cgO3PvBG2H8xT89iKisAe" +
       "lM6lcoa9f3yL7D0FwvCQveEN2PuJN8Le7QFwGMvF7AxHP/l9OSpb2JwD0/kO" +
       "9KB5UDbw09fv87Yi+R7gxaflWRSoAeayeszEo46nXz5akhQzSYHNvex4zSMp" +
       "XyqlXFi3g/2BzhleJ2+YV7AcPHDSGBcG1pXP/JfPfv3H3/VNYLP7lTtWhT0F" +
       "pvpUj0JeHJf9w1c/9+S9L3/rM+WmBAyi+PnOpQ8XrX7pZoiL6ItF9MoR1McL" +
       "qKNyn8+pacaX+wjTOEY7OoVnBsTjhW8Cbfbgr9NYyrSOPryiLmqtMSIhkIF1" +
       "3D5D40OqvR1hFknhrAF1VUqEOayrbVoyQ8YsoxKr6aK/zpp5ukrzwYSRZuO5" +
       "pzHmxgZLG0wGXcRjxhEyCBJlpkXNKRvTyhBtRLNoEdOTZOzMdsoEJZIVUa3l" +
       "TaNpNvWwD6OavzK3BNFsrhYatCCgoGr2oNqWMdyc7cmkiww7LtvRDDPsTAK6" +
       "XpuTAmrbkjTjZxsUNsK8BolTNBjzK8ewlH6sGPPuaDXjRn3L7U5HXWnQ6yKu" +
       "Gw9ncpfsqPF2KTCdcVMOkVjAAr7jKXlqzbaTpaBqjDuKN4KstPS0Qw9nDWky" +
       "62ynmO/1Jg2432u7q03i93W/Ye8MjJTl7qgP9qlGaFiLVp20G6m4aag6Mdz0" +
       "VL+vLdvY0vfVEc0gfdJfsY2BRMnzSY3ArdgmWryNbqUuYrMTEtFc1uwtQzMR" +
       "oZqNZJiahJpkxWzoMFlodMm2t8hCxlXjwNA83oXnKO4gESX1WA9t9yY+j86y" +
       "3szohFwv4RrYmmq6xqg/R+Kx5mK7fiNSyIHEjFW/7jZsSouHaTyP6rtduz2Y" +
       "8m4Ey1ZTktOMU9EqLOEzjAuhvLpAa8IOjhiwakReJA3mHb3TX1opbI3ZSHUx" +
       "ZFbzJYbxc9fOWsuVOZoqfZcdk2pzkbRZj+4olsr0qISUVnIvm9b9sJHPKIMU" +
       "HDjjvaloRws35PrV9hhihxbEDDJVQubSmtTUtkWORzw7C0idMiW5n8aNoTtg" +
       "6ltWY7aCh/VbGAVzHWWe1CNDjSx72BpE/LZjU3AkZqTYiiC5BQ868bDbDibi" +
       "YN6lJxll9ifhzEB5hFvRhpEbaS/sKGtpxHNMb4CvxaWYwoEjckmA1nEeGUFz" +
       "M2psRmt72BEpM2QpEfLGLRgdi+PhXBhHaIvu+7SyE2xjnTk0gQ37lt51REYU" +
       "eA3CiNhN5i5sLviZzjfols9NN5wiuTWTXVZZx+kgmT/tspTWl5LYppf13GB2" +
       "MZrWzCja+o6l6nN/jssDW4DrqEg3VRTDZAEXXSyajO041p2wO2BDBZkP/a0i" +
       "LUbSJKawtT9JXSa2JdWk8YSdiYHPSsO0pmS87w0RN+5ttW2kDCbQcKz0/VZf" +
       "UVq06Eb9cXNiCDOuhg9UHlSIwfTxhvVle8dhocLUYliBa1JMtVg7HoXwdG5I" +
       "C28zbAZiOJzh/QY5HTeEzVqEJuiUt+0G2/OzGel2u0oTc1mLiYCzP++ZUDTr" +
       "ihYJZDdthNyExYJeLyCH9LivR0t95eltoiWqMITncc+Quw2xPqS4eRRmRn/b" +
       "IxcxMqwPF0quK0SjsejL7doYUtfM0NG1EWMLu9nAZ/LpqMNtUDIaiT4c9ahR" +
       "XRjaLIG1k75lWSxqUClGQu2BIvMNoVEzV6y5JAUqJIbVNjSyydAQd6E34TBY" +
       "SRECz2gnMPmFTOGbCb3eDnnHng1gYLt6M7jO6APe5MIYtmSM4yBrJq+GMV3F" +
       "WN6ie9o2WRBmL5CMjZhtpBal620L47fGSjJQc6qKkrpodOsxSlQJYuAY1fqQ" +
       "lqvDDqKlan9J22bDW2s5NM17zc3ck5cds0ETkNSjtPa6Z5IBOqNQcoKt+cAU" +
       "ppwu98UsBaZKX7aw2AyjoT7LUZyYpN260Zwa6kAk4+qCr6f8RFFpQw4H9oRZ" +
       "cBDazibrWqxTitxxOjpLLxlgn4eDlcjSRHW+MQC/IREqhJNGaq1f5/rb1Fnl" +
       "/sQyqUZNYmfGZtH0YwiaYaJGNBl8qDs7uwrPKHHCmVQ0a2XkTtarabWmCASO" +
       "ETSD2YQ7tOqU4bgi6uIua5uoy7gks+GCdrtm4T1zvRgbA2xqdccj1+1zQ1uo" +
       "dyEFrs5wPKWBseRpPpFnfD9BEInHmqae92UdN6u14bxdF0b8iGlUHb43URu4" +
       "QQ92PNrg/A0tOmxzGu1gq2F2W5vWcN1yNdgC5tVR3EZIclMLr4/gjohNZ8KC" +
       "XgU41JWmKdFGFuScGlSbPTbrrVHYz+dauI17jY2SLSDfcZdh1RzwU2/r1qga" +
       "uww7zaHfwZYzWV+1iMEA53xfmYkylYt+W23WFWZNVFuygK5nazvvbpxk2Mj5" +
       "+aDNTFYwznHTYLXLUL5Gj+AlRqr+UBn1NsO87Y86aotWKKfb3MRSssKpJd+D" +
       "TGWITElpNG+uYzHYUTkU4ZHcq1IYD9Gcvqsv8OqgpdF0HV+6Qd0LJgSpJQmF" +
       "pBMkG2z8yBeVHTHa1RrdgZ4tIc5t5VO1CbSMNFjNIfN0WA08E94i1axK96aS" +
       "OQ6UKIyWiEyFdTQat3fL5Xwi7wLc6jEDbbvGzUlzixNzZEc0ktWqXkU79ZSK" +
       "ejOmgcOoV8cMYdysGVvS64n6mlbHc3aYMI6ciKPmSpkLCkI549EWHbt11Zaj" +
       "KNr01V0vI5ed1IEjaehGRBcZh6GPsxLpTXYNvE3o7RHiDb16x0g01B0bUNZz" +
       "xIRdrQRpDCG64QaLHpTniYsP+baEVWdNa6fscLu7iE0PonhVSoyoJdFqy+gE" +
       "7EYXV6sFunSR5baB8us4zGa7PHZnjaUlKQ4GhWnuo4vlyk9J2PFrrLJrrza7" +
       "OoyuEmZqoeOEhbEY5saI1qkC7GNsITlJPozmO27QEjRvSVBTfMmKEGkFbYpc" +
       "ChNjhExsZ+35WyGZWFqT0QYqNSPwIBqTtZWkJn1gUNx8rYKVIx3IsEgyqCDm" +
       "dV9DJ5S5zmppDXOHatPXWTPswnSjzUY7ItZCdEBnKzTXetR8ZRLTWTbp8n1M" +
       "0snecAAbsESg2qRK1Am4IyNCfeeh+rqmiSvPxh0TMud2eyZG1UUQDCFDGMxI" +
       "ZCa1vCSPhmq2tpfTFS3UNmiLb2qOWo/TlFBtZArHLg1B8qq+7dcCeTNhaH5l" +
       "N/JYbk27do3GzRnaDyOs1RV7OlNtWCNqbUojrUsK9Yka2HaL1mOI0/pbpQUN" +
       "aLqGNvF5HkN8t21Y+G4DE/PqyjMHzRqQA7cVLWrqk9BCHhrwRKy1B9W6xtUG" +
       "Gir3RiJSnQd4uhnotLRT85khB9hQG0U46zaZfGwLqrBLNbLtC9XJbBrPW3y1" +
       "GQaSq/nEYGHKfYfG2XladyCJ2jrTNGvotQHaXSYd3akOXEyZYMJ0sNxxAq/P" +
       "m1PbHXTE6hpuz4Mp36TU+cQk5vMwJ2ZdDo9HhDfsybzHeLNc6idd2e/79qI5" +
       "Wwf6RE8JTmDaiCK75tztOKOqbJkYtqIpfaTr5s7AuwsVra/Teq3aD1ZhdZjt" +
       "HLCmmlWBbo47HYVXjZk2COO2Ixv1XKwNkCqJWtrUbC2JfLVZMImEI60dudOc" +
       "LFx7Gr7iNjCtwpwA91lKhuHW0p30warXmfgkM7WtVjcWLU5XWJPsjsm5ylFN" +
       "uDMloZAhq0jXW3PKVB6l7Hour2tdZG3MugZY/1gjx9fO1kC6I4fRtj7Lefi4" +
       "6mbrKcu4C2E0QNSZ4DNwqzmg2rk1GosbzGTrtLX12DwVVGiLLZZrhjeqSGuL" +
       "ty3JpWOXkEUMtniPD0dbEqqPRw0sGUA5JHTSDdNJ5jVzOpcUhEeRxU5eO8RI" +
       "Ei1f77E8Eok4F5D1qN2ATQIiN0LSrBNW3W7F6AaRsszdNePBzl5YI7FKYBjK" +
       "q6tkjlpp7nTDOSNnhDKtGwSMjbfywmxs5quQlgc4JVehKgotEQ9Sci5n2MZu" +
       "K0ICFi2IPloXHLZh9rPZtLkDK/l6Ra7Aboj1a/xSCYHjhURT3eHcJVXnJJtx" +
       "ubAtaUwvQLHMJ0MFnzRcXXVbFtE12jWhq7ad/k4eEkHDyrWkx0/k6Y4XoJqS" +
       "9wKs7gmTSZfNOQVrLeKxwSgNLMQVXyRRZ9lXt2ZrC89ITW6x2txCJuN42KJp" +
       "WDVYaqzvdvXqZp5HmdrbrjdCNlz1NHzU4jviJhgSm/mkv7Ej0rexQKJrHtZM" +
       "kzpuKL3WINXdEXDiNukql6qxYLfmEGKtW12IRBMDbpFSglFQboWYgO5CjOqP" +
       "6TBjp3HJozoj8WA9hRezprLBNmObblHwrifjYUI4O35ibjaoMG7PNahXXdXs" +
       "DTR2COCMClTVSjb6bNVT3c6unwLH2NsAFz8xMFtPja3TNJHqrsdVU5PzCJsX" +
       "XBb2QxYfxHDMVPvsRmunHaETuE42kMAakI7acH/r9DhiInZHVQTsDoBjMJMi" +
       "o63OsxjBmg6TE/qw5Yx3JOVxHcpGtWHNG48DqMc67jRvYmR9InBJWAW43IWq" +
       "kSyX2nGfIgKg2CKS6MqUHO9axHC8noRqtbOUohqVCqHrRbphqmw/CIfNRBdU" +
       "drXZGPIKV43dgHeoAKsu54sRMFMLpQv0crwUg9E6D3b6eqFA9RgfpggeK7zC" +
       "mDKTbat1jhKMXaxqctT3ukrfm3aW4XSxBK7cuj8yGW3hmK32aEmqqsCkS3vr" +
       "dFqw01eopoQ02RGD1PqU2K5OoVpOpa2Ix7CJIOF6i4gsw1tSbSyHq9tsMpUb" +
       "dczxc74LA+s56Nj0VNXb26Wzth3Rj2V9O8q7hIbFHA72YU0WrtYmxCKX1tV8" +
       "GohGPJvW/AYhSIo76/HknPUH7o7etn28lkZQMpinhJL7Sa/b4E3aoQUxq419" +
       "a90knCnZXaytbF2PKBZoZmCyki+iiMkmyzrwBRdbE14u2n1uJC1b8ppfrnYJ" +
       "zoDtfDygpcxZTpouZuza05qOKtqWqM6m4tRaKbhhOBtu1w42mw48qplQOuoT" +
       "8chvDqtyR0XcAbkzVTB2MEavmjFpB/X6bq3gah3r8Y1t1JNs2idlSUqWHheO" +
       "Brtk4RTbmx7ErSyog0usP0KCagh2bwzM7JAg1EZ+Ps3r8xjqxTZw5Kw5Y6QL" +
       "VeCRhq60G3xm4lHcRZbNRl9sNOvchpvS4oxjW61WcYTzlVs7WnqwPEU7fiPl" +
       "eM2i4J/cwunR5noXZOXnzsrhe5qj71PnjaeuW84fndi9/5bekRzVwt7Q8XRR" +
       "46A8SS0rF9dWT97otVV5ZfWlT778ijH4OeTohnOeVS5kYfR+z1yZ3pnLoudv" +
       "fFnEl4/NTm5sfvuT/+1x+YeWH7uFZynvPMPn2SZ/gX/1a70f1H/ifOW24/ub" +
       "a57BXV3pytW3NvckZpYngXzV3c2Tx8J8uJDdu0FoHQqzdfbw+ERdrn9y/J69" +
       "ut3k8u7f3KTs60X0m1nlbZaZja97MH6i");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qb91yxfC/+rqC+EPgdA/xNl/a3CeOyFQSoI/uAnYPyyibwCw6XXAXve0dxXa" +
       "xskA/N6bGIDHjgStHA6A8tYL+r/epOxPiuhbWeUiEPTp+V5eNZxA/I9vVsbF" +
       "ZdlHDiF+5C2XMVwSvH4TnN8por8AONNrcf7RCc5vv1mcT4CwPMS5fOtF+bc3" +
       "KfteEf1NVrlH90w1KW4Gz6L7H28C3aNF5rMg/Mwhup95y9Gdu3CTsnuL6Pas" +
       "ci9Q1P3d4v7u8FPH8M7d8SbgPXwkvK8ewvvqWw/vkZuUPVpEl8CCZ6ftLVgn" +
       "7PJy6MTKnnvwzYJ7EoSvHYL72ls6A4/cgoePL3mPZhjaLsE9cxPgzxXRE0Br" +
       "o2NP4QzyJ98E8ncUme8B4TuHyL/z/wT5u4+RX+MASWXy8FV/ifgmL/7O1Yro" +
       "eWCm9MRUM3Nf2Q6so46eONORdPgQgCl+nQxZ9Zbe4WSVR677ZLh4//jYNf9i" +
       "2L+813/5lYt3P/rK+N+Vr2aPX8df4Cp3L3LPO/0+5VT6zigxF3Y5ohf2r1Wi" +
       "EvYHs8oP3MQTzYr/KhSJgvdzV/Z1PgQW7OvVySq3gfg0JZlVLp2lzCp3lN+n" +
       "6TpAC0/oQKf7xGkSGrQOSIokEx0JpfnG3eGWlmaJqh96xOdOObWHqlva6Ye+" +
       "n/iOq5x+qVt0Wv415chpzcXDN4pffqUv/PDrjZ/bvxTWPXW3K1q5m6vctX+0" +
       "fOz4PnPD1o7aupN+73cf+MqF546c9Af2DJ9Mo1O8vfP6z3I7fpSVD2l3v/7o" +
       "r37wn77yx+Vl/f8B6v+tAjM0AAA=");
}
