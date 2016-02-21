package org.sunflow.math;
public class PerlinVector {
    private static final float P1x = 0.34F;
    private static final float P1y = 0.66F;
    private static final float P1z = 0.237F;
    private static final float P2x = 0.011F;
    private static final float P2y = 0.845F;
    private static final float P2z = 0.037F;
    private static final float P3x = 0.34F;
    private static final float P3y = 0.12F;
    private static final float P3z = 0.9F;
    public static final org.sunflow.math.Vector3 snoise(float x) { return new org.sunflow.math.Vector3(
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P1x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P2x),
                                                                     org.sunflow.math.PerlinScalar.
                                                                       snoise(
                                                                         x +
                                                                           P3x));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 snoise(float x,
                                                        float y,
                                                        float z,
                                                        float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            snoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point2 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 snoise(org.sunflow.math.Point3 p,
                                                        float t) {
        return snoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 noise(float x) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z));
    }
    public static final org.sunflow.math.Vector3 noise(float x,
                                                       float y,
                                                       float z,
                                                       float t) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t),
          org.sunflow.math.PerlinScalar.
            noise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t));
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point2 p) {
        return noise(
                 p.
                   x,
                 p.
                   y);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z);
    }
    public static final org.sunflow.math.Vector3 noise(org.sunflow.math.Point3 p,
                                                       float t) {
        return noise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t);
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float w,
                                                        float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float w,
                                                        float h,
                                                        float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 pnoise(float x,
                                                        float y,
                                                        float z,
                                                        float t,
                                                        float w,
                                                        float h,
                                                        float d,
                                                        float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            pnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point2 p,
                                                        float periodx,
                                                        float periody) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        org.sunflow.math.Vector3 period) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 pnoise(org.sunflow.math.Point3 p,
                                                        float t,
                                                        org.sunflow.math.Vector3 pperiod,
                                                        float tperiod) {
        return pnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float period) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              period),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              period));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float w,
                                                         float h) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              w,
              h),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              w,
              h));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float w,
                                                         float h,
                                                         float d) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              w,
              h,
              d),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              w,
              h,
              d));
    }
    public static final org.sunflow.math.Vector3 spnoise(float x,
                                                         float y,
                                                         float z,
                                                         float t,
                                                         float w,
                                                         float h,
                                                         float d,
                                                         float p) {
        return new org.sunflow.math.Vector3(
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P1x,
              y +
                P1y,
              z +
                P1z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P2x,
              y +
                P2y,
              z +
                P2z,
              t,
              w,
              h,
              d,
              p),
          org.sunflow.math.PerlinScalar.
            spnoise(
              x +
                P3x,
              y +
                P3y,
              z +
                P3z,
              t,
              w,
              h,
              d,
              p));
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point2 p,
                                                         float periodx,
                                                         float periody) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 periodx,
                 periody);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         org.sunflow.math.Vector3 period) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 period.
                   x,
                 period.
                   y,
                 period.
                   z);
    }
    public static final org.sunflow.math.Vector3 spnoise(org.sunflow.math.Point3 p,
                                                         float t,
                                                         org.sunflow.math.Vector3 pperiod,
                                                         float tperiod) {
        return spnoise(
                 p.
                   x,
                 p.
                   y,
                 p.
                   z,
                 t,
                 pperiod.
                   x,
                 pperiod.
                   y,
                 pperiod.
                   z,
                 tperiod);
    }
    public PerlinVector() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5rL1iX9sEQsW8Zctnlofkv83HrydBfEFl7cv/eMtaQFM+ssbT+15Z/9gKZ+e" +
       "YBmIfB49wQL/6LnRwnGjv/Tw1J5P+g+6ezmZGQ+iistMtX/MbLMgbPOXGZ7a" +
       "oeX/YL0HRzNATOZyNGXoHCUJKnO+lAHHkWuy3u8y30kSH9lfUTxu/3VvsBcE" +
       "0u8NlYVRcSwhy84Ts452oabjmMS4LTPPz7IjhcG5BFW6/4VDUD78grkGG8xu" +
       "8wga4egG2M2Ws9N8gvJoJ2gu0BjSGuI8UGueBE6a/ztKnwdJ8YbGnIs3xxGS" +
       "aRmHNNgLc6kDFQnzlbke8fD+5Su3nLr0fvOtBVEWNrMTMCPCqMh8N4IphUMZ" +
       "U7naUroK22Z9PfLRkumpQykZb00458aWE6EAe8NggusYv1GfPs3/1oHmp/66" +
       "s/DlIAqsRQGBoFFrs89MJ7WEjiatDWcfNO0SdPZ+QdOsn21a2BD77B12PBmZ" +
       "B1Mn8vv3iCVf7do81Qg0BlFJOyqQlChOssPcSzYpq7E4oGecWi3sVRNK+r26" +
       "keBrArxIx1ixyCxPX4WXWQiqyz7Am/2CTyl1HawvBu2gptx1hCWhac67jNX1" +
       "IOayfED9rCe8QtNS73i8yljXNNhMwWXwh/A/u8/Mtgk7AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMWcC4wr13mYuSvpPvS6V9eSJSuSLNlXtuVR7vA9JCQ/OA/O" +
       "DDkcDjkcDjm1LQ3nTc77wSFpK5UNODaa2nEbOXGCWAUKG61Tx3aLGi6aupFr" +
       "tLGRtEUK95EEjd2iRdJGAqwUTtOoqTsz5N3du3e58pUoZAGePZw5j//7//P/" +
       "5+w5M/vll3K3BH4OcB1zqZlOeEVZhFemZuVKuHSV4EqLqjCiHygyYopBMEiu" +
       "PSW97WsX/uyVz+gX93NnhNybRNt2QjE0HDvoK4FjzhWZyl04vIqZihWEuYvU" +
       "VJyLYBQaJkgZQfgElbvtSNUwd5m6KgKYiAAmIoCZCGDjsFRS6Q7FjiwkrSHa" +
       "YeDlfia3R+XOuFIqXph75NpGXNEXrU0zTEaQtHAu/T5MoLLKCz/38AH7mvk6" +
       "4M8C4HO/9KGL/+im3AUhd8Gw2VQcKREiTDoRcrdbijVR/KAhy4os5O6yFUVm" +
       "Fd8QTWOVyS3kLgWGZoth5CsHSkovRq7iZ30eau52KWXzIyl0/AM81VBM+eq3" +
       "W1RT1BLWNx+yrgmb6fUE8FYjEcxXRUm5WuXmmWHLYe6tx2scMF5uJwWSqmct" +
       "JdSdg65utsXkQu7S2namaGsgG/qGrSVFb3GipJcwd//WRlNdu6I0EzXlqTB3" +
       "3/FyzPpWUup8poi0Spi753ixrKXESvcfs9IR+7xEP/npD9uEvZ/JLCuSmcp/" +
       "Lqn00LFKfUVVfMWWlHXF299N/aL45m9+cj+XSwrfc6zwusw3PvLy+x9/6IXv" +
       "rMv81AllupOpIoVPSV+Y3Pm7DyCP1W9KxTjnOoGRGv8a8mz4M5s7TyzcxPPe" +
       "fNBievPK1Zsv9P/V+NlfU/5kP3crmTsjOWZkJePoLsmxXMNUfFyxFV8MFZnM" +
       "nVdsGcnuk7mzSZ4ybGV9tauqgRKSuZvN7NIZJ/ueqEhNmkhVdDbJG7bqXM27" +
       "Yqhn+YWby+XOJp/c7cnnfG79k/0OcyNQdywFFCXRNmwHZHwn5U8NassiGCpB" +
       "kpeTu64DBpGtmk4MBr4EOr528N1KOgIZxU8EGyrpUL+SjjD3DWx7kXJdjPf2" +
       "EpU/cNzhzcRXCMeUFf8p6bkIxl7+ylO/vX/gABuNhLkHk26ubLq5knZz5Wg3" +
       "ub29rPW70+7WxkxMMUucOgl3tz/GfrD19CffdlMyitz45kSPaVFwe9RFDsMA" +
       "mQU7KRmLuRc+F390+Nfz+7n9a8NnKmJy6da0OpMGvYPgdvm425zU7oVP/PGf" +
       "ffUXn3EOHeiaeLzx6+trpn75tuPK9B1JkZNId9j8ux8Wv/7UN5+5vJ+7OXH2" +
       "JMCFYjIgk9jx0PE+rvHPJ67GupTllgRYdXxLNNNbVwPUraHuO/HhlczKd2b5" +
       "uxId35/bJNeM4PTum9w0vXs9KlKjHaPIYul7WPfz/+nf/I9Spu6rYffCkYmM" +
       "VcInjrh62tiFzKnvOhwDA19RknL/+XPML3z2pU/8tWwAJCXeflKHl9MUSVw8" +
       "MWGi5o9/x/u97//hF763fzhowmSuiyamIS3WkD9OfvaSz/9LPylcemHtppeQ" +
       "Tax4+CBYuGnP7ziULQkbZjJ20xF0mbMtRzZUQ5yYSjpi/++FRwtff/HTF9dj" +
       "wkyuXB1Sj796A4fX3wLnnv3tD/3vh7Jm9qR02jrU32GxdSx802HLDd8Xl6kc" +
       "i4/+uwd/+bfEzydRNYlkgbFSsuCUy/SRywyYz3QBZCl47F4xTd4aHHWEa33t" +
       "yPLiKekz3/vhHcMf/vOXM2mvXZ8ctXtHdJ9YD7U0eXiRNH/vca8nxEBPypVf" +
       "oD9w0XzhlaRFIWlRSibloOsnkWZxzSjZlL7l7O9/69tvfvp3b8rtN3O3mo4o" +
       "N8XM4XLnk5GuBHoSpBbu+96/Hs3xuSS5mKHmroNfD5D7sm+3JwI+tj3WNNPl" +
       "xaG73vcXXXPysf/659cpIYsyJ8yqx+oL4Jd/9X7kvX+S1T9097T2Q4vro2+y" +
       "FDusW/w160f7bzvzL/dzZ4XcRWmzzhuKZpQ6kZCsbYKri79kLXjN/WvXKetJ" +
       "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" +
       "TP3Gq+2oHu0qu/CN65Vw30YJ9+1aCftZ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0f2DLfi1Jv71KZr4t2nynQNNpN++fUj73V3QPrChfWDXtDcdFqWPIf/eKch/" +
       "kCbf24b873eB/PAG+eFdI9+cFb35GPIh938/hfuP0uQH27j/yy64L2+4L79B" +
       "3n3VUe+9/hE6x7DD9YHty6fo4Edp8uI2Hby0Cx28a6ODd/3V6GB9kPnj7TrY" +
       "yzr7i206eGUXOnh8o4PHd62DwwC3lzsY9Xt3nEJ7IU3ObaHdO/96aR9NPvkN" +
       "bf4Nsvgh6FtOAf2pNLk7zN1yEuc9u+AsbzjLb5xVj8SyvUdPgX1nmjy8BfaR" +
       "XcDWNrC1XcNun7X2CqcQZ2SPbyH+6V0QP7khfnLXxK8yae295xTs96VJbQt2" +
       "fRfYm7rr32+Q9/5pxkKewpke5u+hWzixXXCiG070jePcW7Nwp3DyacJs4ezt" +
       "gpPYcBK75jx57hFPgZXS5ANbYD+4i4mW2sBSbxzsUU+1ToFNX//Y09Mny0+i" +
       "NXZBy2xomV3TvlqEWp7CnT5vthdu4452wT3YcA92zX0mK3rmJO5jGvj4KRr4" +
       "RJo8u00DH92FBkYbDYx2rYFzWdFzp2vgmC7+1im6+IU0+ZvbdPGpXejiAxtd" +
       "fGDXujiyMvnTY8ifPwX576TJ57Yh//IukJ/eID+9a+TjMf3bGdGXTqH9B2ny" +
       "hW20X9wFrbyhlXdNexjmNjNYJv2hlb9+Cvc30uRr27j/4evlfmfy0Tfc+htn" +
       "5aNj+lun0KZK2ftnYe5scCLuN3eBa25wzTfOzCfHr1P2A/fS/cC972wFf90b" +
       "gim4uwF3dw3+k09np+wP7qX7g3vf26qC171BmKog3Kgg3LUKXst8dsqm4V66" +
       "abj3g63KeN27hu/Miq5/FrtWxikT2imbhHv/K01e3Mr8uncJU+aPbJg/smvm" +
       "k2e0vzwF98dp8udbcf/PLnCf3eA+u2vcV5nS9s9vB9+/LU1u3ga+f8uNgC/C" +
       "3O1HX+NO30O977r/CLH+LwbSV56/cO7e57n/mL3JfPCfBs5TuXNqZJpHXxs8" +
       "kj/j+opqZEo4n6V3uhnFpTB38fhWcJi7Of2VSrl/17rYPWHutiPFUup17mih" +
       "+8LcTUmhNPsWN2O89r2J9euQi/Ue9H1HbZ5qLHfp1TR25Oj07dcceGb/YuPq" +
       "4WS0/icbT0lffb5Ff/jl6hfXb05LprjK3i45R+XOrl/izhpNDzgf2dra1bbO" +
       "EI+9cufXzj969TD2zrXAh+PviGxvPfnVZMxyw+xl4tU/ufcfP/n3nv/D7LXK" +
       "/w9sxO7k+0QAAA==");
}
