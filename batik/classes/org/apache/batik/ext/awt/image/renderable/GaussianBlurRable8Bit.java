package org.apache.batik.ext.awt.image.renderable;
public class GaussianBlurRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.GaussianBlurRable {
    private double stdDeviationX;
    private double stdDeviationY;
    public GaussianBlurRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                 double stdevX,
                                 double stdevY) { super(src, null);
                                                  setStdDeviationX(
                                                    stdevX);
                                                  setStdDeviationY(
                                                    stdevY); }
    public void setStdDeviationX(double stdDeviationX) { if (stdDeviationX <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationX =
                                                           stdDeviationX;
    }
    public void setStdDeviationY(double stdDeviationY) { if (stdDeviationY <
                                                               0) {
                                                             throw new java.lang.IllegalArgumentException(
                                                               );
                                                         }
                                                         touch(
                                                           );
                                                         this.
                                                           stdDeviationY =
                                                           stdDeviationY;
    }
    public double getStdDeviationX() { return stdDeviationX;
    }
    public double getStdDeviationY() { return stdDeviationY;
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    static final double DSQRT2PI = java.lang.Math.
      sqrt(
        2 *
          java.lang.Math.
            PI) *
      3.0 /
      4.0;
    public java.awt.geom.Rectangle2D getBounds2D() {
        java.awt.geom.Rectangle2D src =
          getSource(
            ).
          getBounds2D(
            );
        float dX =
          (float)
            (stdDeviationX *
               DSQRT2PI);
        float dY =
          (float)
            (stdDeviationY *
               DSQRT2PI);
        float radX =
          3 *
          dX /
          2;
        float radY =
          3 *
          dY /
          2;
        return new java.awt.geom.Rectangle2D.Float(
          (float)
            (src.
               getMinX(
                 ) -
               radX),
          (float)
            (src.
               getMinY(
                 ) -
               radY),
          (float)
            (src.
               getWidth(
                 ) +
               2 *
               radX),
          (float)
            (src.
               getHeight(
                 ) +
               2 *
               radY));
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public static final double eps = 1.0E-4;
    public static boolean eps_eq(double f1,
                                 double f2) {
        return f1 >=
          f2 -
          eps &&
          f1 <=
          f2 +
          eps;
    }
    public static boolean eps_abs_eq(double f1,
                                     double f2) {
        if (f1 <
              0)
            f1 =
              -f1;
        if (f2 <
              0)
            f2 =
              -f2;
        return eps_eq(
                 f1,
                 f2);
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.RenderingHints rh =
          rc.
          getRenderingHints(
            );
        if (rh ==
              null)
            rh =
              new java.awt.RenderingHints(
                null);
        java.awt.geom.AffineTransform at =
          rc.
          getTransform(
            );
        double sx =
          at.
          getScaleX(
            );
        double sy =
          at.
          getScaleY(
            );
        double shx =
          at.
          getShearX(
            );
        double shy =
          at.
          getShearY(
            );
        double tx =
          at.
          getTranslateX(
            );
        double ty =
          at.
          getTranslateY(
            );
        double scaleX =
          java.lang.Math.
          sqrt(
            sx *
              sx +
              shy *
              shy);
        double scaleY =
          java.lang.Math.
          sqrt(
            sy *
              sy +
              shx *
              shx);
        double sdx =
          stdDeviationX *
          scaleX;
        double sdy =
          stdDeviationY *
          scaleY;
        java.awt.geom.AffineTransform srcAt;
        java.awt.geom.AffineTransform resAt;
        int outsetX;
        int outsetY;
        if (sdx <
              10 &&
              sdy <
              10 &&
              eps_eq(
                sdx,
                sdy) &&
              eps_abs_eq(
                sx /
                  scaleX,
                sy /
                  scaleY)) {
            srcAt =
              at;
            resAt =
              null;
            outsetX =
              0;
            outsetY =
              0;
        }
        else {
            if (sdx >
                  10) {
                scaleX =
                  scaleX *
                    10 /
                    sdx;
                sdx =
                  10;
            }
            if (sdy >
                  10) {
                scaleY =
                  scaleY *
                    10 /
                    sdy;
                sdy =
                  10;
            }
            srcAt =
              java.awt.geom.AffineTransform.
                getScaleInstance(
                  scaleX,
                  scaleY);
            resAt =
              new java.awt.geom.AffineTransform(
                sx /
                  scaleX,
                shy /
                  scaleX,
                shx /
                  scaleY,
                sy /
                  scaleY,
                tx,
                ty);
            outsetX =
              1;
            outsetY =
              1;
        }
        java.awt.Shape aoi =
          rc.
          getAreaOfInterest(
            );
        if (aoi ==
              null)
            aoi =
              getBounds2D(
                );
        java.awt.Shape devShape =
          srcAt.
          createTransformedShape(
            aoi);
        java.awt.Rectangle devRect =
          devShape.
          getBounds(
            );
        outsetX +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdx,
              rh);
        outsetY +=
          org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit.
            surroundPixels(
              sdy,
              rh);
        devRect.
          x -=
          outsetX;
        devRect.
          y -=
          outsetY;
        devRect.
          width +=
          2 *
            outsetX;
        devRect.
          height +=
          2 *
            outsetY;
        java.awt.geom.Rectangle2D r;
        try {
            java.awt.geom.AffineTransform invSrcAt =
              srcAt.
              createInverse(
                );
            r =
              invSrcAt.
                createTransformedShape(
                  devRect).
                getBounds2D(
                  );
        }
        catch (java.awt.geom.NoninvertibleTransformException nte) {
            r =
              aoi.
                getBounds2D(
                  );
            r =
              new java.awt.geom.Rectangle2D.Double(
                r.
                  getX(
                    ) -
                  outsetX /
                  scaleX,
                r.
                  getY(
                    ) -
                  outsetY /
                  scaleY,
                r.
                  getWidth(
                    ) +
                  2 *
                  outsetX /
                  scaleX,
                r.
                  getHeight(
                    ) +
                  2 *
                  outsetY /
                  scaleY);
        }
        java.awt.image.RenderedImage ri;
        ri =
          getSource(
            ).
            createRendering(
              new java.awt.image.renderable.RenderContext(
                srcAt,
                r,
                rh));
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr =
          convertSourceCS(
            ri);
        if (!devRect.
              equals(
                cr.
                  getBounds(
                    ))) {
            cr =
              new org.apache.batik.ext.awt.image.rendered.PadRed(
                cr,
                devRect,
                org.apache.batik.ext.awt.image.PadMode.
                  ZERO_PAD,
                rh);
        }
        cr =
          new org.apache.batik.ext.awt.image.rendered.GaussianBlurRed8Bit(
            cr,
            sdx,
            sdy,
            rh);
        if (resAt !=
              null &&
              !resAt.
              isIdentity(
                ))
            cr =
              new org.apache.batik.ext.awt.image.rendered.AffineRed(
                cr,
                resAt,
                rh);
        return cr;
    }
    public java.awt.Shape getDependencyRegion(int srcIndex,
                                              java.awt.geom.Rectangle2D outputRgn) {
        if (srcIndex !=
              0)
            outputRgn =
              null;
        else {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            outputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (outputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (outputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (outputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (outputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!outputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            outputRgn =
              outputRgn.
                createIntersection(
                  bounds);
        }
        return outputRgn;
    }
    public java.awt.Shape getDirtyRegion(int srcIndex,
                                         java.awt.geom.Rectangle2D inputRgn) {
        java.awt.geom.Rectangle2D dirtyRegion =
          null;
        if (srcIndex ==
              0) {
            float dX =
              (float)
                (stdDeviationX *
                   DSQRT2PI);
            float dY =
              (float)
                (stdDeviationY *
                   DSQRT2PI);
            float radX =
              3 *
              dX /
              2;
            float radY =
              3 *
              dY /
              2;
            inputRgn =
              new java.awt.geom.Rectangle2D.Float(
                (float)
                  (inputRgn.
                     getMinX(
                       ) -
                     radX),
                (float)
                  (inputRgn.
                     getMinY(
                       ) -
                     radY),
                (float)
                  (inputRgn.
                     getWidth(
                       ) +
                     2 *
                     radX),
                (float)
                  (inputRgn.
                     getHeight(
                       ) +
                     2 *
                     radY));
            java.awt.geom.Rectangle2D bounds =
              getBounds2D(
                );
            if (!inputRgn.
                  intersects(
                    bounds))
                return new java.awt.geom.Rectangle2D.Float(
                  );
            dirtyRegion =
              inputRgn.
                createIntersection(
                  bounds);
        }
        return dirtyRegion;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gprFPccsmkx1sOlG6Vb4rcJn9P3h6L4f3LfvBlOq5vz0vwmq2wd++e8XQne+" +
       "/VyRbFKZUMHoTR8/F90gF/Tn52+PqVPvjQ0/vKW5rA/iTT+pzijS7gztT7iZ" +
       "QslnZOKu/XJqMd7h1g73BvLRatgG7Pgsb9dzWc7JSUS4RISPDWCz0nDH3vwt" +
       "c5X2MfGWVz6oH/3giRNc7fyzgTvUbBU0E/MmbFYh5ou8uXGLYIwD3bnHBq9o" +
       "lI+dBI5jwFGEusDYpoMrZPMCk0VdUfXrHz+5cOeLZSTYR2pkVUj0CTzGkzkQ" +
       "XKkxDsk+q118iRlbpqqhaeSqkgLlCzrQv5cXjxyb0hrjvr730UXfu+DeQ2/y" +
       "IKeZPJbw+eVYf+QldX7CdPLK/S9/5hf3fu32KdOkfBzEM6/ln9vk+HXvfFQA" +
       "OU+jRXzGM38sfOSu1shF7/L5Tj7D2Z3ZwpoJagJn7rr7038PdlQ+FSRVY6RR" +
       "tE50o4KcwSwxBqcYwz7mwakvbzz/RGKW3925fL3U67SuZb2Z1O0I5SzP6J3k" +
       "WYdbuAKetVZeWetNngHCX67gU87k7WpszrZzVZWmS3Dqp55kVevDlJF6gyV6" +
       "6aTEt+Tz3OXMLI3tpdhcafIbLGmUo4VKbLDW21BCCTO4nIlNrFDaUrM90l5e" +
       "TNrk6UvbhL098GjWeloJaeXikAchVBr8lM5gwyVFkD3IN/rwZqS6d+Rzw9vX" +
       "DfUXUyN9+mq0YC+enm60lrqxQA2M3Y08MqAxh3p5fL/muz8Z6Jo4WQ5+1Usq" +
       "JtHms3lkgxm8cfjykYPLaqffvplHjItbN7zz7tLI2ch3sjgqZfgawoavvtuD" +
       "ySIfQRkpo5pRDI4pHziyji2dlVuL/1QS6zhp/3aXaU7kC9glTvf/cIzCFLGs" +
       "1O0BT8mHr5s+lNh2z9qglbh6GMR8VTtbppNUdolTh5zyAvFWfl/iRLU35t76" +
       "28c6Uz0zOVhhX9spjk7493KwgdWlY7tXlGeu+1Pr9ovGd87gjLTcg5KX5be3" +
       "Hnlu8yrx1iC/HDLDbcGlUv6k7vwgW6NTltGV/PrijPxzCsaWiGUbEa/DONbn" +
       "Matc9V9qqqdQsUonp5K5zaeSOYjNAQZlK2Uj7qjMqS+0qj/8tZGR8klVSjgO" +
       "8tVTxQv/ygE7tpuud1MhTkOWskMzx6nU1FPh9C0fnO7B5lAhTjwf3OFg8s1Z" +
       "wKQZxzrg2WEptmPmmJSa6qPyQz5jD2PzHYAj5TEbjqYDx5HZhCNu6RSfORyl" +
       "pvqo/LjP2I+webQQjss9cDw2Wx6zEh7J0kmaORylppb2mA2c6099MHkBm6cg" +
       "36DH8LtLj6s8PQtgLLJtI2NplJk5GKWm+uj6qs/Ya9i8xEgt2EaPmlESxrpe" +
       "O/kv5oUPJvsUVdOhYSj3oQiSqUXBYXp5tlxoCTzXW7peP3OYSk31geL3PmPH" +
       "sfkNmEvKbS4bHBzemQUcWnGsHZ6bLWVu9sGhoBTHV7Po9NSbTT4cPRAEHVa8" +
       "/jQz0d98gPoQm7/AMQDK1hjdzWnOw8bK056cXRVXVZkKSjEn3px14H1/tuDt" +
       "hOeABcaBTwzeUhxPB95AVWl4A3OwgYNtDcIrxBFiJPsoh1QgOAtILcaxT8Ez" +
       "bek17YNUCYcsNbV4ELdD0Jm5EFRw3hjmr9bXYA7OfB/gWrBpYKRB1KnAqDlZ" +
       "UlL2Qks9C5kENNGPfznoNs4Cuk2WHQZWmTzN3zNCt+TU4gZ3Kq8sk6xv/AUe" +
       "ie3rHNCVPmCvwaadkXkQLXuphlAq4p5hmrKPQQD43BzgI+OC5oJ4xWxBvBy0" +
       "GLBwGpg5xKWmlvTpwCoHrfN90OrG5lxABNGSdGYBhb0hB5b1nwQsWUYWFP3c" +
       "iRelLQX/j2H+D4H44KGG6kWHLnuVH65z3/nr4JiczMiy+yrP9V6p6TQpcVzr" +
       "zIs9fn0diDDSddqXCgwPrvYfqFSgx+TSx0ibPxdGKiTbd+1Z/Yy0lJoFVg+t" +
       "mzrKyPxi1Hgnk82j3Aa1tZcS1ue/3XTDoI9DB0nSfHGTXAbcgQRfRzXbV/pP" +
       "/xZmY9xguiCyiCrjZ1JGddhVXu2bdzJmZF3ithOeYBecyrxyU9yfDlEM/s8+" +
       "9sVFxvx3n5h49NDA4NUnNtxjfroUZWHvXuRSGyVV5ldUzhQvP1aU5GbzqtzS" +
       "dXLuQ3NW2tdETabAjssucRUg28FFNTTnVs93PaMz93nvtcMXPPGz/ZUvBUlg" +
       "BwkIEKh2FF5sZ7WMTpbtiBZ+4BkVdP7BsbvrG3suWpN8/3V+EUjMD0JLS9PH" +
       "xFfuvfLlW1sOtwVJbT/YJ+xalt+49+5RoLqe1MdIvWRsyoKIwEUS5LyvR3PR" +
       "8wRMWhwXC876XC9++Gako/DbWeG/C9TI6hTVeb2PbOqjpNbpMXfGc3+U0TTP" +
       "BKfH2kps+8xEgrsBhhyLbtU0+9NixQmNR6HNJTNLQOKv+Lbrv8JjmU4IKAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Z5F8L6pcVP3wuro9y9FckjzPVkX3GP9/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("v1v8V8Hz8gH+l/+s8Z87d3v858og8I+jygMFflEqZFDk/OAY7J/cBdh3FJnv" +
       "Ac+NA7A33hhNPndzlPjjRxPylqiQKV8PLiaXiN98B2k8XCT3RZXLcqCKkbqv" +
       "bLr6YUdPnOpoT6AqZPF1JLJz99+FyB4+0I9z797X3f/evcgOVOMsBb9guuX9" +
       "s39XyuDJO8jnuSJ5LKq8BViGruoX6F15x6j6YXQLZPTQkYwWhuifkMo77lYq" +
       "T1eKw/G9VEZvqFQK9p46FsG1O4iguFhw7nkAsxCBGUQH6Ivcq8dYX3g9WLOo" +
       "8rYzb7oW1/Yeu+Uq/v76uPzLr1y+79FXuH9TXvY8uuJ9P1W5T4tt++SFnxPv" +
       "F/1A1cxSFPfvr//4JapmVHn+NS+1omIxcfhRoDmH7Vv5c1HlqTu3ElXuNQ/n" +
       "ymGt90WVx25XCygnSE9SfzCqvPUs6uLuSHYTJQFisNOUoP/y9yRdH+A5pgOu" +
       "YP9ykoQErQOS4nXkHyo6+drXph0pjAJRjgjPLi71RmoARrWMCvcr1b0le+yk" +
       "7pe295EfpUZHVU5edC3YKP/P43AxGe//0+O6/JVXRtOf+j72C/uLtrIt5nnR" +
       "yn1U5dL+zm/ZaLEgffa2rR22dXH4/A8f+ur97zpcPD+0Z/h4Hp7g7emzb7X2" +
       "HD8q76Hm/+jRX/nJv/3K75fXh/4fPB5Gw4AzAAA=");
}
