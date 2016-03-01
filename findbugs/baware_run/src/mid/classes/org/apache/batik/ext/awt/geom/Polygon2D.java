package org.apache.batik.ext.awt.geom;
public class Polygon2D implements java.awt.Shape, java.lang.Cloneable, java.io.Serializable {
    public int npoints;
    public float[] xpoints;
    public float[] ypoints;
    protected java.awt.geom.Rectangle2D bounds;
    private java.awt.geom.GeneralPath path;
    private java.awt.geom.GeneralPath closedPath;
    public Polygon2D() { super();
                         xpoints = (new float[4]);
                         ypoints = (new float[4]); }
    public Polygon2D(java.awt.geom.Rectangle2D rec) { super();
                                                      if (rec == null) { throw new java.lang.IndexOutOfBoundsException(
                                                                           "null Rectangle");
                                                      }
                                                      npoints =
                                                        4;
                                                      xpoints =
                                                        (new float[4]);
                                                      ypoints =
                                                        (new float[4]);
                                                      xpoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[0] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[1] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[1] =
                                                        (float)
                                                          rec.
                                                          getMinY(
                                                            );
                                                      xpoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxX(
                                                            );
                                                      ypoints[2] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      xpoints[3] =
                                                        (float)
                                                          rec.
                                                          getMinX(
                                                            );
                                                      ypoints[3] =
                                                        (float)
                                                          rec.
                                                          getMaxY(
                                                            );
                                                      calculatePath(
                                                        );
    }
    public Polygon2D(java.awt.Polygon pol) { super();
                                             if (pol == null) {
                                                 throw new java.lang.IndexOutOfBoundsException(
                                                   "null Polygon");
                                             }
                                             this.
                                               npoints =
                                               pol.
                                                 npoints;
                                             this.
                                               xpoints =
                                               (new float[pol.
                                                            npoints]);
                                             this.
                                               ypoints =
                                               (new float[pol.
                                                            npoints]);
                                             for (int i =
                                                    0;
                                                  i <
                                                    pol.
                                                      npoints;
                                                  i++) {
                                                 xpoints[i] =
                                                   pol.
                                                     xpoints[i];
                                                 ypoints[i] =
                                                   pol.
                                                     ypoints[i];
                                             }
                                             calculatePath(
                                               );
    }
    public Polygon2D(float[] xpoints, float[] ypoints,
                     int npoints) { super();
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
                                      ); }
    public Polygon2D(int[] xpoints, int[] ypoints,
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
                                      ); }
    public void reset() { npoints = 0;
                          bounds = null;
                          path = new java.awt.geom.GeneralPath(
                                   );
                          closedPath = null;
    }
    public java.lang.Object clone() { org.apache.batik.ext.awt.geom.Polygon2D pol =
                                        new org.apache.batik.ext.awt.geom.Polygon2D(
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
    public org.apache.batik.ext.awt.geom.Polyline2D getPolyline2D() {
        org.apache.batik.ext.awt.geom.Polyline2D pol =
          new org.apache.batik.ext.awt.geom.Polyline2D(
          xpoints,
          ypoints,
          npoints);
        pol.
          addPoint(
            xpoints[0],
            ypoints[0]);
        return pol;
    }
    public java.awt.Polygon getPolygon() {
        int[] _xpoints =
          new int[npoints];
        int[] _ypoints =
          new int[npoints];
        for (int i =
               0;
             i <
               npoints;
             i++) {
            _xpoints[i] =
              (int)
                xpoints[i];
            _ypoints[i] =
              (int)
                ypoints[i];
        }
        return new java.awt.Polygon(
          _xpoints,
          _ypoints,
          npoints);
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
    public boolean contains(java.awt.Point p) {
        return contains(
                 p.
                   x,
                 p.
                   y);
    }
    public boolean contains(int x, int y) {
        return contains(
                 (double)
                   x,
                 (double)
                   y);
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return bounds;
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
    public boolean contains(double x, double y) {
        if (npoints <=
              2 ||
              !bounds.
              contains(
                x,
                y)) {
            return false;
        }
        updateComputingPath(
          );
        return closedPath.
          contains(
            x,
            y);
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
    public boolean contains(java.awt.geom.Point2D p) {
        return contains(
                 p.
                   getX(
                     ),
                 p.
                   getY(
                     ));
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
                            double h) { if (npoints <=
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
                                          contains(
                                            x,
                                            y,
                                            w,
                                            h);
    }
    public boolean contains(java.awt.geom.Rectangle2D r) {
        return contains(
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
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at) {
        updateComputingPath(
          );
        if (closedPath ==
              null)
            return null;
        else
            return closedPath.
              getPathIterator(
                at);
    }
    public java.awt.geom.PathIterator getPathIterator(java.awt.geom.AffineTransform at,
                                                      double flatness) {
        return getPathIterator(
                 at);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "BbpunSgs2sI1r+sY2GF8WkpS/wPRLOgsMDkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18e9DsZnnffsfH98sxNsbGYGNjc1U42pv2UofArrS72otW" +
       "0mpXqxUQo9VlpdX9Lm3qBOgAHtIhlBhKZhI3w5i0SR3IBJi2ZNKadBpgcJkJ" +
       "zTSlM8EpaadpXCbwR0mnpHVfafe7nO+c77NPzhe+GT0rvdfn9zzP+7zPq/fV" +
       "9+z3C9f7XgFybCNdGXZwUU6Ci2sDuRikjuxfHIwQSvB8WUINwfenIO1x8Y2/" +
       "c+FHP/6Eeue5wg184W7BsuxACDTb8ieybxuRLI0KFw5TO4Zs+kHhztFaiAQ4" +
       "DDQDHml+8NiocOuRqkHh0dE+CzBgAQYswDkLcOuwFKh0u2yFJprVEKzAdws/" +
       "X9gbFW5wxIy9oPDwpY04gieYu2aoHAFo4absmQWg8sqJV3joAPsW82WAPwXB" +
       "T/3jn73zd68rXOALFzSLydgRARMB6IQv3GbK5lL2/JYkyRJfeJUlyxIje5pg" +
       "aJucb75wl6+tLCEIPflASFli6Mhe3ueh5G4TM2xeKAa2dwBP0WRD2n+6XjGE" +
       "FcD6mkOsW4TdLB0AvEUDjHmKIMr7Vc7rmiUFhTccr3GA8dEhKACq3mjKgWof" +
       "dHXeEkBC4a6t7gzBWsFM4GnWChS93g5BL0Hh/hMbzWTtCKIurOTHg8J9x8tR" +
       "2yxQ6uZcEFmVoHDP8WJ5S0BL9x/T0hH9fH/80x//OQu3zuU8S7JoZPzfBCo9" +
       "eKzSRFZkT7ZEeVvxtrePPi285vefPFcogML3HCu8LfMv/v4P3/1TDz739W2Z" +
       "112hDLlcy2LwuPjM8o4/ej36tuZ1GRs3ObavZcq/BHlu/tQu57HEASPvNQct" +
       "ZpkX9zOfm/zh4gO/Jb94rnBLv3CDaBuhCezoVaJtOpohez3Zkj0hkKV+4WbZ" +
       "ktA8v1+4EdyPNEveppKK4stBv3DeyJNusPNnICIFNJGJ6EZwr1mKvX/vCIGa" +
       "3ydOoVC4EVyFd4PrzYXtX/4bFFRYtU0ZFkTB0iwbpjw7w58p1JIEOJB9cC+B" +
       "XMeGl8D+9XeULtZh3w49YJCw7a1gAViFKm8z83EqxAG8km0TiAbIwrbK2MXM" +
       "4pyfYF9JhvvOeG8PqOT1xx2CAcYSbhuS7D0uPhW2Oz/8/OPfPHcwQHYSCwpv" +
       "AR1e3HZ4Me8wd6agw4tZhxcPOizs7eX9vDrreKt2oDQdDH/gGG97G/O+wfuf" +
       "fON1wN6c+DyQeOaf4ZP9M3roMPq5WxSB1Rae+0z8QfYXiucK5y51tBmzIOmW" +
       "rDqVuccDN/jo8QF2pXYvfPQvfvSFTz9hHw61Szz3zgNcXjMbwW88LlbPFmUJ" +
       "+MTD5t/+kPDlx3//iUfPFc4DtwBcYSAA0wVe5sHjfVwykh/b94oZlusBYMX2" +
       "TMHIsvZd2S2B6tnxYUqu7zvy+1cBGd+amfarwdXf2Xr+m+Xe7WT01Vv7yJR2" +
       "DEXudd/JOL/2n771Pyq5uPcd9IUjUx4jB48dcQpZYxfy4f+qQxuYerIMyv3p" +
       "Z6hf/tT3P/qe3ABAiUeu1OGjGUWBMwAqBGL+8Nfd77zw3Wf++NyB0ewFYFYM" +
       "l4YmJgcgs/TCLaeABL29+ZAf4FQMMNgyq3l0Zpm2pCmasDTkzEr/5sKbSl/+" +
       "nx+/c2sHBkjZN6OfevkGDtNf2y584Js/+9cP5s3sidmkdiizw2JbT3n3Ycst" +
       "zxPSjI/kg99+4Fe+Jvwa8LnAz/naRs5dVyGXQSFXGpzjf3tOLx7LK2XkDf5R" +
       "4790fB0JPh4XP/HHP7id/cG//mHO7aXRy1FdE4Lz2Na8MvJQApq/9/hIxwVf" +
       "BeWqz43fe6fx3I9BizxoUQReyyc94GeSSyxjV/r6G//zV//ta97/R9cVznUL" +
       "txi2IHWFfJAVbgbWLfsqcFGJ8653b5Ub3wTInTnUwmXg84T7Lzf/6c4yplc2" +
       "/4w+nJE3XW5UJ1U9Jv69rXnmz/cEhdfmKA985AQoHIQZhlzG8i5/5hTltTPS" +
       "zLPKGfl7W1TINQnA2KEwrl4AJ1U9XQB3HghgNz/kPQ1PwU1mpHuIu3cWuJ/c" +
       "Mf/k1eM+qeoxCNflHFwHRsObTp7M8oG9Dbye/o1HvvULTz/yX/KxcZPmg5C9" +
       "5a2uEAkeqfODZ1948du3P/D5fP44vxT8fHK+5XgIfXmEfEngm2O+7QDo/Rmu" +
       "N4DrLTug+W9QkM80NgGNmJnLs70WuMv9yn4Q9JPpKPNTbztlGehpJpi7ol3o" +
       "DD9x1wv6r/7Fb2/D4uNx9rHC8pNPfeylix9/6tyRxcgjl60HjtbZLkhyRdy+" +
       "VcRL4G8PXP8vuzIFZAlbRdyF7qLihw7CYsfJ4Dx8Glt5F93//oUnfu+fPfHR" +
       "LYy7Lo3FO2Cp+dv/8f8+f/Ezf/aNK4R7YJ63heCycX2qFLuZGR7GO/f9H9JY" +
       "fuh7//uyGSUP064g2GP1efjZX70f/ZkX8/qH8VJW+8Hk8kAWDKHDuuXfMv/X" +
       "uTfe8O/OFW7kC3eKuyU1KxhhFoXwYJD4++tssOy+JP/SJeF2/fPYQTz4+uOa" +
       "PdLt8UjtUKLgPiudj9fD2fO9yV4h9yb21gXl9NGMvCUX97ns9q2ZLjRLMPJ6" +
       "IIq4wZCtVaDmhR/P07Z+DzB+HRj62e17nORAc+e2Te175G2ckUEDi0zbkrOQ" +
       "ZT9vG7Jr9sWDBT7ITK5gA28/2QaI3NUcKuJrH/rL+6c/o77/KmL1NxxT7PEm" +
       "f5N49hu9N4ufPFe47kAtl63+L6302KXKuMWTg9Czppeo5IGtSnL5HZkScgmf" +
       "MmH9g1PyPpyRDwAFipmot5o5pfiTST7DvCcjQZ7CnVL6YxlhDmfK6VnMlJ/d" +
       "zQKfvfqZ8qSqJ8yU2fPioJXbskoXQGvjbSPb36Dgnu3s4Dg+7EerJVgt+bIH" +
       "j21JpjRRlz3QnmzsT0k/+U5z8V7ubbPndUY+te8pfuU0T5ERb+smMpIXyv3B" +
       "U5f7g+wxL7q5fIBnz09su81rZ+SDp1jir5+S99mMPJ2Rj2w5OaXsM1v7f+rQ" +
       "/n/5lNK/kZGPH9r/L12N/W/L3pc/3byV86WD4V5wvWNn0e84Phh2yvjnV1bG" +
       "Xq6MfXd9o+XY2u5tbnA4inKWn305lo8x9TpwVXdMVU9g6ndfEVPJIVPvOcbU" +
       "F/8WTD22Y+qxE5j6V6+IqfRkpr7yypm6I0t9GFytHVOtE5h67gSmgsLNjmcH" +
       "YMjL0sGku7RDaxtBv+sYa1995azlXu4BcKE71tATWPv6iazd6HhaBILAfcby" +
       "15onrDe3AaNB7V58HuH5G1fJ8yPgwnY8Yyfw/O1TdPz8Pru3gJnQl6V9lr51" +
       "jK//8LJ85e0ke0AS15cv1i8Ws+fvXLnn63LrArrz8y2N7Mnb5+PetSE+uh9Z" +
       "s7Lng5Dk0bVRv3ThmodJ202BY4yKr5hREC7dcdjYyLZWj/3if/3E87/0yAsg" +
       "rh0Uro+ymBNEPUd6HIfZlstHnv3UA7c+9We/mL/2AnKkPt25891Zq39+GtyM" +
       "/OklUO/PoDL57DQS/IDI31TJ0gHaYzHkeRCq/O3RBvecx6t+v7X/NyotMa41" +
       "K01KsATrJB5b6ixttWm93U6ZLjRdlFh61WdItI3pPQMbzzch5wy7kVQymkkR" +
       "oTtuwgrWdK4r9EKdm6uSxvbXKjtpzCYua8OaCrGkys0EnbUm446z8SYrrVZp" +
       "wk14GUmVZdgsxbrj8lATlqNIguswXFfqFbhcqfDwVHeIVYlxi4HLDR1LqEzc" +
       "kqdokhDoJjaVnY5mhvQ0lPxJCM2xjWqM4VHgLwY+F/A4SvForc8wgtQvEcbS" +
       "E6aCoZdMYdpzRyZdXKtp0PZmDsG7mmgKZb3WS8v8iDYU3STiuYD3hjjPDycO" +
       "TeiT1QYhqrqdVuatfkpolYHTN1KBGZIVukjOsH7iQKqLLzi6RyOkhym+aVEG" +
       "MdHc9bA2ZWfadMCjM8aYVeY6NupDS9f0SGM+7vLUrJZAKjccOAsVKc7CtNTF" +
       "6iLBDYp1pcTi/RI2YGfsnBBtz1yYjpuavrB2iCFClkIV5QgWYjqONui3Pb9G" +
       "lDpcwDBELNC0GSidWjTDajQ7GQ8cu4jZCt9POI+YMH2dNvkVpDF9Zu4vWBfZ" +
       "YG10uCRjscy3yE1tXFoLlTbUl5CiXIapYS0NGqzed8ozrectGZXE+pMV0dHr" +
       "wwFtkq6hjv3lejxGSNVVVw2Md9NBX/Pqc5+bc8OK4HX0sIUGhhfzxtBqO/C0" +
       "OGEXHa/Fp5P1dI0xjVGIzEoupI10zm278Rofxmh1kjawGBvxE4yoDUatZprO" +
       "Y2ee9kIJMghzkhirCr6xW0LRRH21GlDsXB36nfFMY8XJAJ/V9dWSHMACxpZH" +
       "Y7zdXsGhsKmhtlAqDz2eqQm0uLbrm+Zcn02bqLfW9NZ8YvP1EO5N4o67plg+" +
       "LcvKRmUVMdRrklvlB2iPIYuIhjZWjZaj2lSxPBImdHEoMq1Fu1gbVzRzLOPO" +
       "1GxjNjXeTOfKBIEpO+INhBahllGcS8R6XRuRhkL3yLBfl2MRJpYLR7OU4ayV" +
       "MBY3NsZ4tSeqiDFihRFddPDpaKxRTL/cVaNxgixgYlRR6swIX0HThsoz+Jic" +
       "8a1RQ+ioBANpKW2XPXdmjzWpW0VTcy146SCoy3TH08hUs1kpkUoSb84Cvo2q" +
       "UsMtRWo063Y4rN9xh7bkzeUKU+8F0mJdaZDubErr3oouL1F+058ocLrUeaS/" +
       "RoRVh9FNdzl0J6w9xpTemuYs0mZ4Mal12VI6lKpUw3NKpYVSsjqlQb9H9iYd" +
       "om6vO5baxZL5mOrUDE5dOo5ho2yLrBXHNL9ROFtU3ArZFYciDQfYgmsNemQT" +
       "nfXa84HrDbmuKxFMedBTxrA5oJIiri7bq5XhLxbkRDS9tjgtRcRAVtwOKgdJ" +
       "HHlFFaVn1Ygg4qrZLYtde5jijb7SIK3xoFxfbgyzbI/iMVys6COaHCK4Xqfm" +
       "drqwps31IGLIMlStdJ0SAgdcwpl9WjW4KSqHtI9aM16rDhbFOA4mIQncRjpv" +
       "b4LuJIo5dZCkemu8lDdiWJmiUgrhZGOjrjoCbfM9uFsfpLLtV5eVugUG1Bop" +
       "E2ZTqtU5q7Om5tjabzK1UScZ9z1JdrmoJfmCtXZEsWYZiNJNha4+mK06G2LQ" +
       "X8kM1y9V1nbSKZotixcnDGqj9TFKqENJ1fnmIC2ZYzsSq1LdRDCImsUE1Wmt" +
       "0bQhjLrommuua/FKqs3WqhWuNrhKN2ocVJlKzTI0YqlROHKDQMbRQEErOs+v" +
       "Ut+qztssRfmEyCaxNus4TSrySsFyLFUSqLEZhUqzvV641UENaZVppop2qkNh" +
       "WUmcEo9XKs0I4dfrwE87Pa0yTDuQu2Tbtl7RFKPFYJNNUkL6Q9HpkJE95jjO" +
       "JVFWdERfYuzZCmI8Tdc5KlryHs+hWMJUF/Vo0uaKVHUcw3yyRIoi7k0DLl7M" +
       "gKfrEpI1taTJsC/X7I0otNdMz6HXgdKlm2wxYgJ/hcxIYSzPS0ZPImOLbYXj" +
       "TohEq7XVrevC0p8xfMWRojoB4UAYajkpN6sNYr52NKWkiD19o6VyxZtIfdke" +
       "x6OUmc7WWIPpQZrJhDwlYVF1RYyUEurg2Grcry8xDev2zXChtZoDcegTG2+M" +
       "dAdzGIY9fZI2G3af7CBOdzNxqJWo0SI/pKnIMRcUT2gzJWCJhbSRZxrK4qg3" +
       "aNlwDR8oy5lHTMmQrHFK1Ek7chTicF1upg7UWrNlpZcm+NAYLK11Wzb0QZfc" +
       "RBJKleZkpFNtC7b8WR+SYjCoEGXa62Pz+YQ2xWIjNax2Sau3RYOoWDSv64tJ" +
       "z5EVU1zGicFCgtHyRx0PEqL2GmN5jAc+oOR6Pb5kiyu86uirGQnZXFOt1Kbt" +
       "eXcKh+vmHCu1UG8lthk+7BrxiJDrYtkZSoOQGNASM5rG9SYy6HEGIoodhdU4" +
       "sR5a61GxNnIxsj6prKtK0FkTnAatkEppE0NeDcErSjzpQsPaJpInqY6H7DKc" +
       "uNQyEJ2ZY/SoiYOtqzgZqrwDE8VRPRA1lJ4MFxQ2X3cEpKp6Qy+cN62+n1R1" +
       "OB51HTkIoqZZNf1loMONFSnDs8Ds6CupaJTJTVXuI74SNatVscfKsDqe9VXT" +
       "bzMKtAhHnD81vF6l6ggO3R5QJoeERdPro6wWsaUg9C2l47IcZdSSADP8SYnR" +
       "CWjDNVQZ23BwuqKVXo/oJaxeZ6XeAJZH0Kq2WYvGok8q5NzQFYmrD6EG0nSw" +
       "eCo3oTQg+WXgpGlTKQVlMFvWRwupUyfKkYzI4rQ3g1dOZzU3zKRVRCF50YBx" +
       "uTlrNH0KMfssyyIq7waOQ1AUw8H1hIlgNhpBsl10O1BRY+aGpMYDaJGsVm1W" +
       "IXtlpVyu1pSWRuCr0XBWdhuurS8XZn0Sc0vTN0g2pWu9kgPFcZFai+O+gHpC" +
       "nw07DdYwKAuSkS5jW/XSpllVKGvkViatFkUMSXzZZOBuakrjZNMkXICkxSKY" +
       "H9Sgsb8OoQZf4aaGKNYjllj2qWmPjeYkSuODKg8lQxgbi3M4xQnUcAbILKk1" +
       "rfFMNwYLr8Jjblcrr5pF25zQEysy/VhOinOkz8LIOhLqhhnwS70eBqy4SkfY" +
       "uKP2ev3GmIFnQgz8MNIWV73KVF1FTg2vpENXF0EoZXc1VVgrXpUvsWkFTtD6" +
       "gmjzrVajOyj3praven1uxnYnfW9aG+jsdDgRLMmJFr2GIyiKM+isp6bo6IM5" +
       "U9usSJGfwBCHTx22QdQDO+bNZewkQdtVRlJzpjThdBoBl8FDJGcNjA3cb0hW" +
       "tKZa9TWujNrtZaBElpPWqUWsxLGxGVRKEOpOXQafpuSsx88MbENv0LnZdZeq" +
       "xHFiK+iW0HqlbdGByg14CyV6A4eeY+kKapY1A8dZcrBwGnMZTN5W4qgcavGY" +
       "bIz8aAn5fZOMOGbsSjoQHIywIlmLhwtdgQY8mLGL8EBdQpxTFPl1J8E0fBVO" +
       "5CSahFO4WiE0TWE7Mr9e8mJaGSN6PMdkplIZsUs/4PVhY4oLMdG02nRbp9IO" +
       "0oP08aYP09HACuOGOm1GtDLc1AkGiyqwmo5meMovWlwlbthkaTDoN9RwFvQ7" +
       "AVZxl/U1n0hcd9RsED1Uh2dqmQy6CTDwSX+67jXwqBurQ96e9hkqIPwpUjGx" +
       "CTfiiEZ3YvvKOCUM160PSuuQXs7qC5HZUM0q1+1D4gLqJv6GY5I1ksDYYDpd" +
       "J5E+xYw0WScpHsU9cc0viA1XTSmjZw8SqIJiVs9qIBhSRiwswaaLNmVv2Kld" +
       "hUS1QuLCQpsQQYXu9ehZLxIbVNufEWg86yMlYaZydW2jy9ACEkMlxhrzakkZ" +
       "uL7GOw2EglssXGUqfJuLy0usD5dbq06Plylr1UAm3Xq3NmPDqKS2okVxmran" +
       "iwnlpyzmx1C8SWIc0lbL1aRR6UMs3eJXxaUeIBuUcpG4pznWCBmBuG3g1Cuj" +
       "WtXhJNOKx0uxOpqaZcvWKbZEKvaYKaYYq7iwCLURH4lLy8AXuQonq9GkWIq5" +
       "Hu/ozWmt57phh16OAmFYJ6ZVrcV5HaEh4QSHTJYdEOVBNSyZdQMQy6wYV0O7" +
       "8MQvbYCv6brTRc1aTvShIo6HadBFDaHcVSbCTFHAImLRKLVIM16NFiDY8Xwm" +
       "WJbXuoeLjSmUNrsowhpgllF0mVo1hGIXCVaNAGmpfaq5aDmjWXvJsX1XBQ4Y" +
       "nRmGQa/WrN7GGWejj5UiVhmIpS6UJHjDUKAJ5LWRomc64YARRb5SbmHuYm3S" +
       "fX4kWLiYBquaoXuLFl1eTG1IcDtV02q0oFGnR498YJvF4WAgt2pL34kbigCN" +
       "ncbEIySUVEowt+QSES1JpMGDhac9DrsuMD5UXifwSDGTtqlqSx1bUuhkXG2n" +
       "c8PzulCDLrcry81cJOQFFuHMLCrrsIU1TapEU2Sj3NbkOWcWF7puV8Jyx1jR" +
       "NsIF/e66ywx9bm0R4nQE1t02MnQalCXEYFaCNS9ZbMprddzhWxhEIl0HhsZK" +
       "CZhNC5o0apNqvIoiEq03fKHe7mGcANVabQt346XdUqGhak5pVZnPSiTT9AgR" +
       "CefuSNeR8aym6fKKa1k1c2Y3aBYWpE4tntMQgVAaV/Phdb0zrkkNKqkLvSFa" +
       "wVMSqbizCkyW3XEgKGMu9oPiKkixuhSvW00FViGvhbcUtU6rdpOmHX/Ro7GB" +
       "1F4qkV+yEwvZ4CAGpOaRGNd7TttmyuPQVD20BFXqIPZokXFlwtHSWmZGSxAI" +
       "kmQ5rhVdfF53JCgkR2HdjhJ0wdM9wVg2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("QrirbtRiW6myDbGEjMpLDUzUtQ3dQjYyXmuPFcqel8OOQkZKeVrXwbQM00or" +
       "qsNYHRhVOYS8fq+F+5rdKyq6Lq2ENByy+IY150xadsrruVUuws2NOV9FnUAx" +
       "6+tJ06uHMxxZ1nqtShGiW3rUx61eBe7jkFtEMdmcQ7gHpVRpQYmtYThJuxVS" +
       "bGZWPau2NEzrIOlwU6m7QmlamXtg5EKzBttDGzBYbXBqAnleu0eTCSyFLWoJ" +
       "ljoxq1KlGI65Vn0itMAiH6/7suAkPrBKrOsUwZTQh/A17FCdqR+MsWjDVmlF" +
       "KDXJRr/RQlB5Ao+LIOwxN5N1dWjWMB/dlFxNadqwD+SNE+ugHKI1PxnP52Ou" +
       "W06LRqLSRDgezJG4PKUStgMJoTRwJ2iQJnHo0bG2ggPTpqimu0HgcbmqeHU3" +
       "gov8plxBFa4ERgcOR8lCREQZxWozzElifoGSrtMi0vFiUtEQUkg7jUY7bAz6" +
       "hDuqVIo43YTWvldTkiih0mFCSb7H6FIYQYtAXE6H8BoiV2yXKTvsrEuJbSyQ" +
       "Sv68To8c01u6rerG7W5oUm6VYxry5z29M2rStahlx1NyrrNdiOrHsxbOVXBf" +
       "6fvdtGkzEi01msJEc5vURHeqARwqDrFSN1HTxuhZF6qGSAO3i61Z5EBauVUW" +
       "m3axPCi2jXWPGQTUZtgYwaExl2IrKnW6MA459TEhMAqusO1yEkmRNWI3lUTg" +
       "KhpPWcSMFcKEx3uTljGQ+zTVbsymlYRotCtj3A2qdWc6XSWN0CyDuKa90tq4" +
       "gC7szdqDaHeEKrRZ5Otrc76UZGtankllzsPh0qzSVRt9PeinnQG6Yo3yXBno" +
       "nsMsSGKegHWeonrufBp3IGKMTBqhAldGQXHMwmicdmgpEux+lTSHy2YdnpZd" +
       "zotid+qrPDMYBokZDnCL9zjQeTKfl3QLZTfR0va0wahdo2wGdhpsqZoaxQ7u" +
       "hLCmoNXNjFchP4WRaG0NurXarFcp4yrRJxp8mWHCEAkR3gsmwlCfjamVkFQm" +
       "7aUTWszKL/v9kgf5i3Kv25jrDgPH1GRErnwC01ut1jvfmb0O/aure037qvyN" +
       "9MGZ9bVRzzJeuIo3scmVtmfzvxsKx845H3l9f2Qj7Lr9t993HOwjMKqw3SPf" +
       "3yv0Cg+cdFY9P3PyzIeeeloiP1c6t9ulU4LCzYHtvMOQI9k40tc9213Gyzfd" +
       "vrjj84vHtxkOJXHqPtLJO4Z750/JuyFLfCkoXO/Jvhxc8cV4ZGvSgSb2Cle9" +
       "3X4I9q59sF/Zgf3K2YO9+5S8ezJyx/65hCvseWxPvRyCvXANYPMNpIfA9Qc7" +
       "sH9wtWCff1mwD5+S90hGXh8UbhcFQwwNIZB3u097Nx0CfOBaAWZ7xM/vAD5/" +
       "NgCP7NQvc5LDeccpUOGMvDUo3BI60pVxvu0acL4mS8x2Ar+3w/m9s7fa5il5" +
       "j2WkChS5koPsOGn24UcZ27fet7789wlHKuTCQK5BGHdnidlW7os7Ybx49sLo" +
       "nZLXz0gbqHonjNX23P3oEB16Dehu3Vf1j3bofnQ26I4dD77n0v1qKtv+356N" +
       "3mNOwT7PyDgo3CRIUl7nmJGT14r87eB6aYf8pbNBfuXBLJyCMtuw3nvvySjf" +
       "d63W+zrA8Gu3dbe/Z67fO44c/wYAcljmKZDdjKgA8u6wp3+lefjGpW0bsmAd" +
       "SkI7C0nszj9vf89U3/mpny34nz8F/Acykh4Bnz37hyg314AyizUKbwQMF3co" +
       "i2eD8ij/Hzsl7x9m5MNB4Vbgrdr5SZoylpV71yG8j1wDvHuyxAcBp7vDUXuX" +
       "HY66dnifPiXvMxn5RyDSPYC3PwLuOhgBBx9/HEL+5FnYbXsHuX2mdnulgXeD" +
       "ZIfL/NvKvc/lsJ85RSS/mZF/crI1//q1BlxgHbM33GEfXi32l48ov3hK3pcz" +
       "8vmgcPc2zMqOEYWBZq2uEG994SxU/L4dzPedjYr3DgrsTXM8/+YUrF/NyFdO" +
       "1uPvnUEMtefsADpnA/B8XuB8bqjHSI7pm6fg/fcZ+cNg9xWNv1sFHUX8tbNA" +
       "/MEd4g+etUoL78ph/MkpEL+TkW+fBvFlj+G9Eqv95A7iJ38ySv3zUxD/t4x8" +
       "92QjfuEs8D6zw/vM35FK/+oUgD/MyF+eDPDFawB4X5YIoqK9L+0AfulMAe7P" +
       "lA9cuhZoKQpYrU09EOdl3zvnKH98igReysiPgsKFbD0E/HA/kPOPh/ebv//Y" +
       "UuN4kVxMf30WYtq9Bdi76rcALxdI7v3NgbWfu/VkUZy7PSM3XC6KLHnvAOy5" +
       "G6/qvDwIbg4+8c++V77vsv8rsv1fGOLnn75w071Pz/5k+5Xi/v+ruHlUuEkJ" +
       "DePoF1FH7m9wPFnRcvw3b7+PcnIorwZ2ceq6Piicz34yfs/dva1zb1C476Q6" +
       "QeE6QI+Wvj8ovPpKpUFJQI+WfCAo3Hm8ZFC4Pv89Wu4h4FkPy4GwaXtztMgj" +
       "oHVQJLt9NDOOvXuTrWLuO2pb+Qvfu15OSwdVjn5Mn8HN/z/M/idU4fY/xDwu" +
       "fuHpwfjnflj73PZjftEQNpuslZtGhRu3/1cgbzT7DOvhE1vbb+sG/G0/vuN3" +
       "bn7T/rveO7YMH9r5Ed7ecOUv5zumE+Tfum/+5b1f+ul/+vR389PO/x9K7ExJ" +
       "uEcAAA==");
}
