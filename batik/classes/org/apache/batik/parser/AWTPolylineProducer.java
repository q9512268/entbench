package org.apache.batik.parser;
public class AWTPolylineProducer implements org.apache.batik.parser.PointsHandler, org.apache.batik.parser.ShapeProducer {
    protected java.awt.geom.GeneralPath path;
    protected boolean newPath;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PointsParser p =
                                                   new org.apache.batik.parser.PointsParser(
                                                   );
                                                 org.apache.batik.parser.AWTPolylineProducer ph =
                                                   new org.apache.batik.parser.AWTPolylineProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPointsHandler(
                                                     ph);
                                                 p.
                                                   parse(
                                                     r);
                                                 return ph.
                                                   getShape(
                                                     );
    }
    public void setWindingRule(int i) { windingRule =
                                          i;
    }
    public int getWindingRule() { return windingRule;
    }
    public java.awt.Shape getShape() { return path;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        path =
          new java.awt.geom.GeneralPath(
            windingRule);
        newPath =
          true;
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        if (newPath) {
            newPath =
              false;
            path.
              moveTo(
                x,
                y);
        }
        else {
            path.
              lineTo(
                x,
                y);
        }
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        
    }
    public AWTPolylineProducer() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6eezsxnkY30/SezpsvSc5tmTFuuwnJ/KmPy734O5CSeol" +
       "ubskl1zuzSXrWuYx3OXyXJ5LpmoTA63dJnCMVE5dNNE/ddDUUOI0bZAWRVIV" +
       "QZqkDlq4CJKesVH0SJMYiFvUPZw0HXJ/t96TokpdgLPDme+b+e75ODOvfh25" +
       "LwyQiu/Z2dr2omOwj463dvM4ynwQHrNcc6wEIdBJWwnDOWx7Ufvgz9z85rc+" +
       "u7l1hFyXkfcorutFSmR6bjgFoWcnQOeQm+etPRs4YYTc4rZKoqBxZNooZ4bR" +
       "Cxzy0AXUCLnNnZKAQhJQSAJakoB2z6Eg0ruBGztkgaG4UbhD/jxyjUOu+1pB" +
       "XoQ8e3kQXwkU52SYcckBHOH+4n0JmSqR9wHyzBnvB55fx/DnKujLf+3jt372" +
       "HuSmjNw03VlBjgaJiOAkMvIuBzgqCMKurgNdRh5xAdBnIDAV28xLumXk0dBc" +
       "u0oUB+BMSEVj7IOgnPNccu/SCt6CWIu84Iw9wwS2fvp2n2Era8jr+855PXDY" +
       "L9ohgw+akLDAUDRwinKvZbp6hDx9FeOMx9tDCABRbzgg2nhnU93rKrABefSg" +
       "O1tx1+gsCkx3DUHv82I4S4Q8cddBC1n7imYpa/BihDx+FW586IJQD5SCKFAi" +
       "5L1XwcqRoJaeuKKlC/r5+ui7P/N9Lu0elTTrQLML+u+HSE9dQZoCAwTA1cAB" +
       "8V0f4X5Ued8vfPoIQSDwe68AH2B+/s9946Pf9dRrv3qA+fY7wAjqFmjRi9oX" +
       "1Ie/8gHy+c49BRn3+15oFsq/xHlp/uOTnhf2PvS8952NWHQen3a+Nv0n0vd/" +
       "EfzeEfIgg1zXPDt2oB09onmOb9ogGAAXBEoEdAZ5ALg6WfYzyA1Y50wXHFoF" +
       "wwhBxCD32mXTda98hyIy4BCFiG7Auuka3mndV6JNWd/7CILcgA9Cw+cZ5PAr" +
       "/yPk4+jGcwCqaIpruh46DryC/xAFbqRC2W5QFVq9hYZeHEATRL1gjSrQDjbg" +
       "pMMv/CtAu+J8DFkvaIND6LEGguPCzvz/7zPsCx5vpdeuQfF/4Krz29BvaM/W" +
       "QfCi9nJM9L7x0y9++ejMGU6kEyEVOOnxYdLjctLjw6THd5gUuXatnOvbiskP" +
       "aoZKsqC7w0D4rudnf5b9xKc/eA+0Lz+9F0q4AEXvHo/J8wDBlGFQg1aKvPb5" +
       "9AeWf6F6hBxdDqwFwbDpwQJ9XITDs7B3+6pD3Wncm5/6nW9+6Udf8s5d61Kk" +
       "PvH412MWHvvBq6INPA3oMAaeD/+RZ5Sfe/EXXrp9hNwLwwAMfZEC5QajylNX" +
       "57jkuS+cRsGCl/sgw4YXOIpddJ2GrgejTeCl5y2lzh8u649AGTPISXHJtove" +
       "9/hF+W0HGymUdoWLMsp+z8z/8X/5z/5LvRT3aUC+eWGJm4HohQtBoBjsZunu" +
       "j5zbwDwAAML9u8+P/+rnvv6pP1MaAIT40J0mvF2UJHR+qEIo5r/4q7t/9dXf" +
       "/sJvHJ0bTQRXwVi1TW1/YPKP4e8afP5P8RTMFQ0HB36UPIkiz5yFEb+Y+cPn" +
       "tMGAYkOXKyzo9sJ1PN00TEW1QWGxf3jzOeznfv8ztw42YcOWU5P6rjcf4Lz9" +
       "/QTy/V/++P94qhzmmlYsaOfyOwc7RMn3nI/cDQIlK+jY/8C/ePKv/4ry4zDe" +
       "whgXmjkowxZSygMpFVgtZVEpS/RKX60ong4vOsJlX7uQeLyoffY3/uDdyz/4" +
       "xW+U1F7OXC7qnVf8Fw6mVhTP7OHwj131eloJNxCu8droY7fs174FR5ThiBqM" +
       "ZKEQwLizv2QlJ9D33fjX//iX3veJr9yDHPWRB21P0ftK6XDIA9DSQbiBIWvv" +
       "/+mPHqw5vR8Wt0pWkdcxfzCQx8u365DA5+8ea/pF4nHuro//b8FWP/nv/+fr" +
       "hFBGmTust1fwZfTVH3uC/N7fK/HP3b3Afmr/+lgMk7Rz3NoXnf9+9MHrv3yE" +
       "3JCRW9pJBrhU7LhwIhlmPeFpWgizxEv9lzOYw3L9wlk4+8DVUHNh2quB5nwN" +
       "gPUCuqg/eCW2PFxI+Wn43D6JLbevxpZrSFn5aInybFneLorvOHXlB/zAiyCV" +
       "QC/Hfj46rM0l5Hsj5P2leShpdLwGnnN88GJ7fLJ63yrB6kXRPegav6tdvHCZ" +
       "6qfg8/wJ1c/fhWr2LlQXVeqU3BsuSAt63ti8xoHpwPiYnKRj6EuPftX6sd/5" +
       "qUOqddWWrgCDT7/8V/74+DMvH11IcD/0uhzzIs4hyS0pfHdJZuGdz77RLCVG" +
       "/z9/6aV/+JMvfepA1aOX07Ue/Br5qd/8o18//vzXfu0OWcIN1fNsoLhX1DL8" +
       "f1DL8Ylaju+iFulPopaHUsgQzN+nsX1YF4UTQRR/swi5B346XKFVflNaD0Nc" +
       "g2Z7X+24dVwt3rU7U3NPUf1OuFSF5ScUxDBMV7FPyXtsa2u3TxenJfykgrHl" +
       "9tZundr9rdLuCy8+PnyHXKH1+T8xrVDzD58Pxnnwk+YH/8Nnf/2HP/RVqEUW" +
       "uS8p4gZU94UZR3HxlfeXXv3ckw+9/LUfLFdeKN7lX/47ra8Vo7pvxHFRlMRu" +
       "Tll9omB1ViawnBJGfLlAAv2M2yuKudf23ga30c0N3QiZ7umPW8qGmGr7qWgI" +
       "GahJbc0IjdGo4abN3TQn6SUxM/39rBdqGyo2rD6pE/qMEupCSwNA6NTFZT0P" +
       "8J6/FndDx7Gn28mIUaowCR8R3mxt7UhsN8zxRT8Qu+u+3O7vqQnXcKqTXrSY" +
       "zDvkrFNRa2rSEYSOHPi7ue40k2ZQrbdaWLNdj5KmhXfmuISPYntNWGiaTOW8" +
       "F1QHc2ysSuJuPN9g7gCdjIYrY1Xl0EgIjKazNX16Nh+lnbm/xLfUyNnwyyZG" +
       "hHY3p3uN0WbuqIOlMGVq1XzTcbb2IHb4xcZRFk2jHjHYFIw7fribSF2ALWqT" +
       "QVPPRX69Eip2Srjknl/PZNZb2Jm6MhtCVXSGuIJhmWDg2ThpS9W1rONqVhlY" +
       "I1WktxFrrcUI53eLZsJFnlUNowXkuVqtAakngtpQSHS7lg5VEU/XS46uBU2c" +
       "H+opXicJUF/wvTTOaaHGh8Zi2nQUxsSAiqNCO2xEzV5ssdZCMbSZpg/loZXJ" +
       "m6o55cWAE72Ui5zmZpqNgZRu9sCyp8FQWU/YakxOzP2u2koD1sSqxNrF6txS" +
       "5xkBM9uJODPDYM7lQTWeTeM6wNAdOYi62awfVqUJvVgsGI5imfF6wapjfhTJ" +
       "O9zn6dkkp/rbsCvKwXJk1OJZojeddXONMiRHoyynb+SQXUfNZNomQMhEkdXf" +
       "yFGtpmYhSW7rWGcWzt3RGq/l46Xjbog4peFqVV3wubDw1i27thqaA8VzyXSo" +
       "NadRi0sJkiExLkQbYd8BiucTniRUsyk13cl9jrIobzC31q7ok93RTsuZ9sIM" +
       "8NqOYkmtljJMzvbspkxNqOVI6LKywFpLdiPMJHblbDCVjfJWomLNHO/LW2/f" +
       "c3mdkGVpJ1S2GrmoAkaZJRzvJ8TYJ/kqBpxtxMnbfQ2qiuuFVa5nxSq9yvdo" +
       "XdkJYbXDOlYy8HRnVtP4xXg30zJqgiY46eJNT1kOx4DfVEf9vLOO9Y2trIAV" +
       "19ZEGqbxrD0npgM3bY1kw4gHNaJjtjSdm0xr3nKRoRYjNZ3hQAVVd+qs2m1e" +
       "tscCRjWy7dTebffbhKmvUjdieNaN6zLHC406ZpkmjitWfT/AsgUxpT1vLTew" +
       "RhaKq119SLTFVlXken2GpjoWk9cYc1wZqhZWZ6X5eGzZsw30EilTp5GXYEJv" +
       "03W7rYY+d6Q1boHZ1nZSZjKb+z7GLTyTkoAkiJyJtoS5MmgBO13NF9Ri5hHS" +
       "SialNMdxbrzoTdRaWzf5FYWuE8rBarShUlPM1m0q82kyjlq53wDAkgZ9p01j" +
       "lAlW6W7CCqJNztndxMrUgSPPe5IzjJ252VwNZMknaKnlkfVqKxyoEV6tVKjZ" +
       "wFsnCnQzQGxYO1WzuVehydliTWOcEFGrSEQ5sb9Ae5k8WSgKP+Swrl5tbxQh" +
       "1bq+lDVAfYMT2+HM3q/Fyp6h5O1cXbLrYUzMlkw/9TtA8sLWwLCaVoVUxOpm" +
       "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" +
       "kf/9x/7ed/+tV367PEz7v+oQO5WKKgAA");
}
