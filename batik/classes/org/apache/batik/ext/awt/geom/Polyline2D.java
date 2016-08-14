package org.apache.batik.ext.awt.geom;
public class Polyline2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    private static final float ASSUME_ZERO = 0.001F;
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polyline2D() { super();
                          xpoints = (new float[4]);
                          ypoints = (new float[4]); }
    public Polyline2D(float[] xpoints, float[] ypoints, int npoints) { super(
                                                                         );
                                                                       if (npoints >
                                                                             xpoints.
                                                                               length ||
                                                                             npoints >
                                                                             ypoints.
                                                                               length) {
                                                                           throw new java.lang.IndexOutOfBoundsException(
                                                                             "npoints > xpoints.length || npoints > ypoints.length");
                                                                       }
                                                                       this.
                                                                         npoints =
                                                                         npoints;
                                                                       this.
                                                                         xpoints =
                                                                         (new float[npoints +
                                                                                      1]);
                                                                       this.
                                                                         ypoints =
                                                                         (new float[npoints +
                                                                                      1]);
                                                                       java.lang.System.
                                                                         arraycopy(
                                                                           xpoints,
                                                                           0,
                                                                           this.
                                                                             xpoints,
                                                                           0,
                                                                           npoints);
                                                                       java.lang.System.
                                                                         arraycopy(
                                                                           ypoints,
                                                                           0,
                                                                           this.
                                                                             ypoints,
                                                                           0,
                                                                           npoints);
                                                                       calculatePath(
                                                                         );
    }
    public Polyline2D(int[] xpoints, int[] ypoints,
                      int npoints) { super(
                                       );
                                     if (npoints >
                                           xpoints.
                                             length ||
                                           npoints >
                                           ypoints.
                                             length) {
                                         throw new java.lang.IndexOutOfBoundsException(
                                           "npoints > xpoints.length || npoints > ypoints.length");
                                     }
                                     this.
                                       npoints =
                                       npoints;
                                     this.
                                       xpoints =
                                       (new float[npoints]);
                                     this.
                                       ypoints =
                                       (new float[npoints]);
                                     for (int i =
                                            0;
                                          i <
                                            npoints;
                                          i++) {
                                         this.
                                           xpoints[i] =
                                           xpoints[i];
                                         this.
                                           ypoints[i] =
                                           ypoints[i];
                                     }
                                     calculatePath(
                                       );
    }
    public Polyline2D(java.awt.geom.Line2D line) {
        super(
          );
        npoints =
          2;
        xpoints =
          (new float[2]);
        ypoints =
          (new float[2]);
        xpoints[0] =
          (float)
            line.
            getX1(
              );
        xpoints[1] =
          (float)
            line.
            getX2(
              );
        ypoints[0] =
          (float)
            line.
            getY1(
              );
        ypoints[1] =
          (float)
            line.
            getY2(
              );
        calculatePath(
          );
    }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polyline2D pol =
                                        new org.apache.batik.ext.awt.geom.Polyline2D(
                                        );
                                      for (int i =
                                             0;
                                           i <
                                             npoints;
                                           i++) {
                                          pol.
                                            addPoint(
                                              xpoints[i],
                                              ypoints[i]);
                                      }
                                      return pol;
    }
    private void calculatePath() { path =
                                     new java.awt.geom.GeneralPath(
                                       );
                                   path.moveTo(
                                          xpoints[0],
                                          ypoints[0]);
                                   for (int i =
                                          1;
                                        i <
                                          npoints;
                                        i++) {
                                       path.
                                         lineTo(
                                           xpoints[i],
                                           ypoints[i]);
                                   }
                                   bounds =
                                     path.
                                       getBounds2D(
                                         );
                                   closedPath =
                                     null;
    }
    private void updatePath(float x, float y) {
        closedPath =
          null;
        if (path ==
              null) {
            path =
              new java.awt.geom.GeneralPath(
                java.awt.geom.GeneralPath.
                  WIND_EVEN_ODD);
            path.
              moveTo(
                x,
                y);
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                x,
                y,
                0,
                0);
        }
        else {
            path.
              lineTo(
                x,
                y);
            float _xmax =
              (float)
                bounds.
                getMaxX(
                  );
            float _ymax =
              (float)
                bounds.
                getMaxY(
                  );
            float _xmin =
              (float)
                bounds.
                getMinX(
                  );
            float _ymin =
              (float)
                bounds.
                getMinY(
                  );
            if (x <
                  _xmin)
                _xmin =
                  x;
            else
                if (x >
                      _xmax)
                    _xmax =
                      x;
            if (y <
                  _ymin)
                _ymin =
                  y;
            else
                if (y >
                      _ymax)
                    _ymax =
                      y;
            bounds =
              new java.awt.geom.Rectangle2D.Float(
                _xmin,
                _ymin,
                _xmax -
                  _xmin,
                _ymax -
                  _ymin);
        }
    }
    public void addPoint(java.awt.geom.Point2D p) {
        addPoint(
          (float)
            p.
            getX(
              ),
          (float)
            p.
            getY(
              ));
    }
    public void addPoint(float x, float y) {
        if (npoints ==
              xpoints.
                length) {
            float[] tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                xpoints,
                0,
                tmp,
                0,
                npoints);
            xpoints =
              tmp;
            tmp =
              (new float[npoints *
                           2]);
            java.lang.System.
              arraycopy(
                ypoints,
                0,
                tmp,
                0,
                npoints);
            ypoints =
              tmp;
        }
        xpoints[npoints] =
          x;
        ypoints[npoints] =
          y;
        npoints++;
        updatePath(
          x,
          y);
    }
    public java.awt.Rectangle getBounds() {
        if (bounds ==
              null)
            return null;
        else
            return bounds.
              getBounds(
                );
    }
    private void updateComputingPath() { if (npoints >=
                                               1) {
                                             if (closedPath ==
                                                   null) {
                                                 closedPath =
                                                   (java.awt.geom.GeneralPath)
                                                     path.
                                                     clone(
                                                       );
                                                 closedPath.
                                                   closePath(
                                                     );
                                             }
                                         }
    }
    public boolean contains(java.awt.Point p) {
        return false;
    }
    public boolean contains(double x, double y) {
        return false;
    }
    public boolean contains(int x, int y) {
        return false;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        return false;
    }
    public boolean intersects(double x, double y,
                              double w,
                              double h) {
        if (npoints <=
              0 ||
              !bounds.
              intersects(
                x,
                y,
                w,
                h)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          intersects(
            x,
            y,
            w,
            h);
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        return intersects(
                 r.
                   getX(
                     ),
                 r.
                   getY(
                     ),
                 r.
                   getWidth(
                     ),
                 r.
                   getHeight(
                     ));
    }
    public boolean contains(double x, double y,
                            double w,
                            double h) { return false;
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return false;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        if (path ==
              null)
            return null;
        else
            return path.
              getPathIterator(
                at);
    }
    public org.apache.batik.ext.awt.geom.Polygon2D getPolygon2D() {
        org.apache.batik.ext.awt.geom.Polygon2D pol =
          new org.apache.batik.ext.awt.geom.Polygon2D(
          );
        for (int i =
               0;
             i <
               npoints -
               1;
             i++) {
            pol.
              addPoint(
                xpoints[i],
                ypoints[i]);
        }
        java.awt.geom.Point2D.Double p0 =
          new java.awt.geom.Point2D.Double(
          xpoints[0],
          ypoints[0]);
        java.awt.geom.Point2D.Double p1 =
          new java.awt.geom.Point2D.Double(
          xpoints[npoints -
                    1],
          ypoints[npoints -
                    1]);
        if (p0.
              distance(
                p1) >
              ASSUME_ZERO)
            pol.
              addPoint(
                xpoints[npoints -
                          1],
                ypoints[npoints -
                          1]);
        return pol;
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return path.
          getPathIterator(
            at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbCZgcRRWumT2zR/bInbA5lyMh7EBMxLgxutlkkw2TZM2G" +
       "oBth09NTu9ukp7vprtmdXRLk0BD0M2IIGPggKAST8AUiop8HgvFTQUTw41A5" +
       "Pgh4AILRRAEFFHyvqme6p2e6l8HMfl+/7amqV/Xe/169elVTc+gYKbNMMp1q" +
       "rIUNG9RqWaGxLsm0aLxdlSxrA5T1yl8vkf550atrF4dJeQ8ZOyBZa2TJoh0K" +
       "VeNWD2lSNItJmkyttZTGkaPLpBY1ByWm6FoPmaBYnQlDVWSFrdHjFBtslMwo" +
       "aZAYM5VYktFOuwNGmqIgSYRLEmnzVrdGSY2sG8NO88mu5u2uGmyZcMayGKmP" +
       "XiwNSpEkU9RIVLFYa8okZxq6Otyv6qyFpljLxeoiG4LV0UU5EMz+dt1b7147" +
       "UM8hGCdpms64etZ6aunqII1HSZ1TukKlCesSchkpiZJqV2NGmqPpQSMwaAQG" +
       "TWvrtALpa6mWTLTrXB2W7qnckFEgRmZld2JIppSwu+niMkMPlczWnTODtjMz" +
       "2gotc1S8/szI7q9fVP+dElLXQ+oUrRvFkUEIBoP0AKA0EaOm1RaP03gPadDA" +
       "2N3UVCRVGbEt3Wgp/ZrEkmD+NCxYmDSoycd0sAI7gm5mUma6mVGvjzuU/ams" +
       "T5X6QdeJjq5Cww4sBwWrFBDM7JPA72yW0i2KFmdkhpcjo2PzedAAWCsSlA3o" +
       "maFKNQkKSKNwEVXS+iPd4HpaPzQt08EBTUam+naKWBuSvEXqp73okZ52XaIK" +
       "Wo3hQCALIxO8zXhPYKWpHiu57HNs7ZKdl2qrtDAJgcxxKqsofzUwTfcwrad9" +
       "1KQwDwRjzbzoDdLE+3eECYHGEzyNRZvvbz3xqfnTj/xStJmWp8262MVUZr3y" +
       "vtjYx09pn7u4BMWoNHRLQeNnac5nWZdd05oyIMJMzPSIlS3pyiPrH/zs5XfS" +
       "18OkqpOUy7qaTIAfNch6wlBUaq6kGjUlRuOdZAzV4u28vpNUwHtU0agoXdfX" +
       "Z1HWSUpVXlSu888AUR90gRBVwbui9enpd0NiA/w9ZRBCKuAhbfCcTsQf/8/I" +
       "psiAnqARSZY0RdMjXaaO+lsRiDgxwHYgEgOv3xKx9KQJLhjRzf6IBH4wQO0K" +
       "nJnSEIv0Uz0BYKjDKN6C5S3oZEZxu0+hduOGQiEA/hTvtFdhxqzS1Tg1e+Xd" +
       "yWUrTtzd+4hwKZwGNi6MnAEjtogRW/iIPEjCiC04YoszIgmF+EDjcWRhXbDN" +
       "FpjlEGZr5nZfuHrzjtkl4FbGUCkAWwpNZ2ctN+1OKEjH7175cGPtyKwXzvlZ" +
       "mJRGSaMks6Sk4urRZvZDXJK32FO3JgYLkbMezHStB7iQmbpM4xCO/NYFu5dK" +
       "fZCaWM7IeFcP6dUK52XEf63IKz85smfoio2fPztMwtlLAA5ZBtEL2bswcGcC" +
       "dLN36ufrt+7qV986fMM23QkCWWtKeinM4UQdZntdwQtPrzxvpvS93vu3NXPY" +
       "x0CQZhIYGeLfdO8YWTGmNR2vUZdKULhPNxOSilVpjKvYgKkPOSXcRxv4+3hw" +
       "i2qcdBPgidqzkP/H2okG0knCp9HPPFrw9eAT3cYtTz/2l49wuNNLR51rze+m" +
       "rNUVrrCzRh6YGhy33WBSCu2e39N13fXHrt7EfRZazMk3YDPSdghTYEKA+Yu/" +
       "vOSZoy/seyqc8fMQg/U6GYO0J5VREstJVYCSMNppjjwQ7lSICeg1zedr4J9K" +
       "nyLFVIoT6z91p57zvb/urBd+oEJJ2o3mj96BUz5lGbn8kYv+NZ13E5JxuXUw" +
       "c5qJGD7O6bnNNKVhlCN1xRNNNz4k3QKrAURgSxmhPKgSjgHhRlvE9T+b04We" +
       "unORnGq5nT97frnSol752qeO1248/sAJLm12XuW29RrJaBXuheS0FHQ/yRuc" +
       "VknWALRbeGTt5+rVI+9Cjz3Qowyh1lpnQmxMZXmG3bqs4tmf/mzi5sdLSLiD" +
       "VKm6FO+Q+CQjY8C7qTUAYTVlfPJTwrhDlUDquaokR/mcAgR4Rn7TrUgYjIM9" +
       "8oNJ312yf+8L3MsM3kVT7gzabDvX5vwzCOnpSM7M9Us/Vo8FS7jMJdkbB4yW" +
       "3cmYxbhviKzic9UP/sS6/eXviKxidp7GnlTlwP5K+bnEg38SDFPyMIh2Ew5E" +
       "vrLx9xf/ms/3SlwEsBzlq3WFeFgsXMGmPqPvVFRvRu6Sf8H/uSYDWwJnjW62" +
       "wRt3zfRyX6yu0blP9V+bXLbY+605j31+75yXuKtXKhasf4BPnpTTxXP80NHX" +
       "n6htupsvB6UIsw1xdq6em4pnZdgc/Tok0ZSV3w26TCUBgXnQdoMFXZvlHc1d" +
       "3A2Qb7Uw3fvwF4LnPXzQZFggTNfYbqeMMzM5o2HgaHMDNnnZg0a2NR7dcvOr" +
       "dwnf8+bUnsZ0x+4vvd+yc7eIv2LjMScn93fziM2H8EQkG1C6WUGjcI6OVw5v" +
       "u+/AtquFVI3ZafQK2CXe9bv//rplz4sP58nhYCHUJZaZtiGxMOEamm0CodLy" +
       "a+p+fG1jSQcYu5NUJjXlkiTtjLv7BLtayZhrpjlbGl7gVg5Nw0hoHlohV4BT" +
       "sjJAfpLgJCF3Pnnub/d/7YYhoXKAAT18k99Zp8au/MO/c5YHnnPlsamHvydy" +
       "6Oap7Utf5/xO8oPczancTBomkMO74M7Em+HZ5b8Ik4oeUi/bO/eNkprElKIH" +
       "poiV3s7D7j6rPnvnKbZZrZnk7hSvU7mG9aZdbkuVsiyrNIjpFyI8oCtiFeB0" +
       "HpKzuGXC+NqCfqNoksr5NkAao1Ktnw3wxhttz8V/PYyUwMTH10+7jBwWXfHP" +
       "k5mdNKBqsJfVNYr5R7pObBkUvSVzjgCV+dylKctd1vDY4mD//Nhdf/xhc/+y" +
       "QvYKWDZ9lN0Afp4Bhp/n74FeUR668rWpG5YObC4g7Z/hcStvlwfXHHp45Wny" +
       "rjA/qhBOkXPEkc3Umu0KVSZlSVPLnqZzhENw67lyAm7fgITtsoC6y5FcCu4j" +
       "o6GFXwQ0vyo3B8KCNsOVLtkugB83c6bzeNV64YZItfxted3KgNGvQbKMV30M" +
       "Sbvwu9YPmb0Jyf1SshE7zxgpPCXzY/VJyfDzqkwvY5GpAR5bKfH/ZB8+SGwg" +
       "ykNEcc42srsX2K9Dcj2Hb3tOvMDPsmhgx7ubguIdEjvYIUlwr0KyJzeq4Ue+" +
       "ILDcMIWfhxy59iDZGuCB3wyoux3JrUiuEJIEtL3jw8yj3Rw6/npdQN8Hkex0" +
       "ZslXizlLdthOuqPwWeLH6lHNbarM+pM504ry8yw+2r0BmHwfyd0OJodPBiai" +
       "YhovrBAenNFyCjZEnrm2lnO9APEDuDpnpe3AvO/ZYw/f9tyS43+FdKaDlA1i" +
       "qgHLTb3Tam0SD/S3H7q+qXr3i1/mm8qPX9XIj0nvzz9hShipMExlENJryAss" +
       "/gWBmD7ZJpkcICwj1W3d3eevWdHbs2I9n8fdjn05oA+MBqic7TuT4DnbHu3s" +
       "HGhEBPhVoPv4cYO6mqEr9lcw2z1yPlKgnNPgOdce6VwfOR8PlNOPG+RMOXKe" +
       "55HziQ8h51J7pKU+cj4dKKcfN8g57C/nMx9cTr6wzYJnuT3Sch85j+Z35BAj" +
       "YwxTZ7As0bjHeWsDugWvj+lJLW6lQ8iU7BCyHjqEqaVCHPEo9+IHV64GS5vg" +
       "6bCl6PBR7jUf5fD15x6tqgP6Y+I7ER+dxIZa7bK/NXHp9HqBOs2BZ6Utw0of" +
       "nd5wHOtYrgZ+3IxUQdJp0XhayuMeUd8MEDWVz5f5XznxnBG5hnQF7JI0cmMz" +
       "yHUPSEZmn/Mh9kCw5/H7JpAfC+y7cvfe+Lo7zkmfkGwCh2a6cZZKB6nqEm28" +
       "SEtyA+Zttlq3ee3gAOc3u/1Y/dfMUG1AHZ4MhSph24C3BkRk8GwzSwd1JZ6x" +
       "ZWjMSUtCHFwa07gctJU7WDgufqwBujcF1M1AMjm9nUr7i2v9FkcFDi5TioAL" +
       "n7cz4bnHVu6eUXDJM2n9WAN0nx9Qhwl76HRGamVJlZMq5CL2pA81OFicUSws" +
       "zoLnPluh+wrHwo/Vo69ru8Gzo26u+eIAVFqRLIQ4mDTi+SFZVARIeDjBsP4b" +
       "W6/fjAJJnmnjxxqcu0/IXqS6MKsQyXuoIwCm1UjaGKmU4nHO4wFpWbFAmgfP" +
       "UVvTo4WD5Mf6gfzm/ABALkDS5Q/Ip4sACG72yHR43ra1ertwQPxYA1SNBdTF" +
       "kVwIi2g/ZcuyMrzGjKNlkjsHnYuKFWZOg+c9W8X3RkEnT5jxYw1A4JKAOiwM" +
       "qZDIiOCC37UkmaL154kyiSIgMg7rYFcSqhV9iv8F+Ysva3CUcRI6Pjc4GAFH" +
       "oKErkQzDbLK/PRBeZB9X5kttKmK6rlLJ5xTTgXWkmLBOsrGZVDisfqz549Jo" +
       "aJTH9WQ6N853bBW6jtNdARa4EclXXBbAz19wgNxZTCBn2WjMKhxIP1b/AM+P" +
       "I/gRXmhfACDfQnKrPyDfKAIg3BtmgzbzbK3mFQ6IH2uAqvcE1N2L5BAj1ZkA" +
       "L7boLztI3FVM11hoq7OwcCT8WPOHLtRkJVf5gQA4jiD5ob9X/KhYWDSBiPYu" +
       "PpRzBjA6Fn6sHlVLxV1DHjI8hKv/SAA0jyJ5kNm3Gix7i+UG56FigvMZW8PP" +
       "FA6OH6uvo5CXucZPB6DxLJIng9B4qpjTJmarFCscDT/WAl3lzwHgvILkRf9Z" +
       "9FIxoVFt/dTCofFjHc1R/hGAxRtIjvlj8bciYIHfM+DBXGirrdDWwrHwY82P" +
       "Bf8MiWFT9vazra9P0egGExI5vPrKAXnfH6xwCTZ4h5E6WI0wie5klN8jTXc/" +
       "1bO79TbhiL5brK0Z5CCh7TYs2wtH1I81AI/6gLpGJNWM1CBWeCaqawuWp4E6" +
       "ffRr6k57RC1cU0w/PGCrfqBw1PxYfRPAMMkEqfCMAPxmIZma62tYXObgMu2k" +
       "fI0JC4Xz0wC80zo552dH4qcy8t176yon7T3/9+JuYfrnLDVRUtmXVFX3TSbX" +
       "e7lh0j6Fo1kj7jUZXMe5MCMDPYGRUvyHcofPEDzzGZnsx8NICVB36wgj4/O1" +
       "hpZA3S0XMFLvbclIGf/vbrcIsHLaweZHvLibfAx6hyb4uthIu3zOCXBKRKVp" +
       "btvwLz0mjGbSDIv7ljtCwH9Slr6QlBQ/KuuVD+9dvfbSEx+9Q9yyl1VpZAR7" +
       "qY6SCnHhn3eKl5pm+faW7qt81dx3x357zKnpLzAahMDOPJnmuDD+PCdkoDdN" +
       "9VxBt5ozN9Gf2bfkgUd3lD8RJqFNJCQxMm5T7rW6lJE0SdOmaO79x42Sye/G" +
       "t869aXjp/L6/P8e/Dyc51xW97Xvlp/Zf+OSuyfumh0l1JylTtDhN8ft+y4e1" +
       "9VQeNHtIrWKtSIGI0IsiqVmXK8ei40v4YzOOiw1nbaYUf6PByOzcm6W5v2yp" +
       "UvUhavK9DXZTGyXVTomwjOdeWNIwPAxOiW1KpL1INqTQGuCPvdE1hpG+eDum" +
       "2uAzf3O+nIFv2cNR/opva/4HbvJGQm46AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jfocWQVBz+qhntnvIsl4rM1nK6sPxNHr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "MVfDY0mO6VOn4P10lnw82H2B4+9C46OIX/TY4EtBPN8hnl/vKS18LofxmVMg" +
       "fjZL/vlpEH/rekituIMo/tVM6udPQfyFLPk3Jwvx71wPvOYOr/kjmtI/PAXg" +
       "v8+SL54M8EvXAPC+LPMNgJS37wC+/boC3I8oHrh0LYCrqmErYw9EA9knsznK" +
       "F07hwH/Nkq8EhQvAFmchFRUo+fen+93ff2ypcbxKzqY/udaQGrjZvXfv2PTu" +
       "68OmoyD/1yll38qSPw8Kt2YMyF7bOHaluY/+DS/+Afhh/ZwVX78eEvPRHSs+" +
       "en1YcRh97H3tUPG/dwpTfpAl375cKrLs/34I9jtXdWQfWM7DL+azz3/vu+y/" +
       "cWz/g4T0yecu3Hzvc5P/uP3ac/+/PNzSL9yshqZ59KuzI/c3up6iGjkDbtl+" +
       "g+ZmP2duBDpy6jQGhXPZT0bwmRu2bW4JCved1CYonAXp0dq3BoWXX6k2qAnS" +
       "ozUvBIU7jtcMCjfkv0fr3QV4dVgPBMjbm6NVgHSeBVWy21dk0rF3T7K1Cfcd" +
       "Fa78PdxdLzZNB02Ofpuewc3/q8r+Z2rh9v+qPCl96rku89PfQj+y/TZeMoU0" +
       "/9zl5n7hpu1n+nmn2aduD5/Y235fN5KPfff2X7/ldfsvQ2/fEnwo6Edoe+jK" +
       "H6K3LDfIPx1Pf/vef/amf/LcV/NPM/4/HbKAjO5GAAA=");
}
