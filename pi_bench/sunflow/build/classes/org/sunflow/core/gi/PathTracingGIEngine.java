package org.sunflow.core.gi;
public class PathTracingGIEngine implements org.sunflow.core.GIEngine {
    private int samples;
    public PathTracingGIEngine(org.sunflow.core.Options options) { super(
                                                                     );
                                                                   samples =
                                                                     options.
                                                                       getInt(
                                                                         "gi.path.samples",
                                                                         16);
    }
    public boolean requiresPhotons() { return false; }
    public boolean init(org.sunflow.core.Scene scene) { samples =
                                                          java.lang.Math.
                                                            max(
                                                              0,
                                                              samples);
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "Path tracer settings:");
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "  * Samples: %d",
                                                            samples);
                                                        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        if (samples <=
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.image.Color irr =
          org.sunflow.image.Color.
          black(
            );
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        int n =
          state.
          getDiffuseDepth(
            ) ==
          0
          ? samples
          : 1;
        for (int i =
               0;
             i <
               n;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  n);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  n);
            float phi =
              (float)
                (xi *
                   2 *
                   java.lang.Math.
                     PI);
            float cosPhi =
              (float)
                java.lang.Math.
                cos(
                  phi);
            float sinPhi =
              (float)
                java.lang.Math.
                sin(
                  phi);
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            onb.
              transform(
                w);
            org.sunflow.core.ShadingState temp =
              state.
              traceFinalGather(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                i);
            if (temp !=
                  null) {
                temp.
                  getInstance(
                    ).
                  prepareShadingState(
                    temp);
                if (temp.
                      getShader(
                        ) !=
                      null)
                    irr.
                      add(
                        temp.
                          getShader(
                            ).
                          getRadiance(
                            temp));
            }
        }
        irr.
          mul(
            (float)
              java.lang.Math.
                PI /
              n);
        return irr;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zZ97cfy5eMXh0n8BoaHZEsMaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6a8zrSHW+3929d/fusvfuLvss++QC3Q39HDtxnGh5JU4c" +
       "J3GcOI7zcFsuftuJX/EjdkyXwqo8VFpK211KW9hWFagtXVhaFYGEQEurFhCo" +
       "EhXqSyqgqlJpKRL7o7QqbenY+d7320tX0EiejGfOOXPOmXPOnJnxM9+Grg98" +
       "qOC51ka33HBXTcLdhYXthhtPDXa7NDYU/UBVCEsMgjFouyI//PGL3/3ee41L" +
       "O9A5AbpddBw3FEPTdYKRGrjWWlVo6OJha8tS7SCELtELcS3CUWhaMG0G4WM0" +
       "dNMR1BC6TO+zAAMWYMACnLMA1w+hANJLVCeyiQxDdMJgBb0FOkND5zw5Yy+E" +
       "HjpOxBN90d4jM8wlABRuyN4nQKgcOfGhBw9k38p8lcBPFeAnf+2Nl/7oLHRR" +
       "gC6aDpexIwMmQjCIAN1sq7ak+kFdUVRFgG51VFXhVN8ULTPN+Rag2wJTd8Qw" +
       "8tUDJWWNkaf6+ZiHmrtZzmTzIzl0/QPxNFO1lP236zVL1IGsdx7KupWQzNqB" +
       "gBdMwJivibK6j3Ld0nSUEHrgJMaBjJd7AACgnrfV0HAPhrrOEUEDdNt27izR" +
       "0WEu9E1HB6DXuxEYJYTufUGima49UV6KunolhO4+CTfcdgGoG3NFZCghdMdJ" +
       "sJwSmKV7T8zSkfn5NvOa97zZoZydnGdFla2M/xsA0v0nkEaqpvqqI6tbxJsf" +
       "pd8n3vmZd+1AEAC+4wTwFuaTP/P8G159/3Nf2ML82CkwA2mhyuEV+UPSLV95" +
       "GfFI7WzGxg2eG5jZ5B+TPDf/4V7PY4kHPO/OA4pZ5+5+53OjP5+/9SPqt3ag" +
       "Cx3onOxakQ3s6FbZtT3TUv226qi+GKpKB7pRdRQi7+9A50GdNh112zrQtEAN" +
       "O9B1Vt50zs3fgYo0QCJT0XlQNx3N3a97Ymjk9cSDIOg8eKAyeG6Btr/8P4Q4" +
       "2HBtFfZMeOi7megBrDqhBNRqwEHkaJYbw4Evw66vH7zLrq/COsAAI4x9UQY2" +
       "1O60HB0wtpsZl/f/QzbJpLkUnzkDFP2yk25uAQ+hXEtR/Svyk1Gj9fzHrnxp" +
       "58Ds9/QQQq8CA+7uDbibDbirm7unDAidOZOP89Js4O1kgqlYAqcG4e7mR7if" +
       "7r7pXQ+fBVbkxdcBPWag8AtHXeIwDHTyYCcDW4See3/8tsnPFnegnePhM2MW" +
       "NF3I0IdZ0DsIbpdPus1pdC++85vfffZ9j7uHDnQsHu/59dWYmV8+fFKtviur" +
       "Coh0h+QffVD8xJXPPH55B7oOODsIcKEI9AVix/0nxzjmn4/tx7pMluuBwJrr" +
       "26KVde0HqAuh4bvxYUs+37fk9VuBjm/KDPZ+8Ny6Z8H5f9Z7u5eVL93aRzZp" +
       "J6TIY+lrOe+Df/MX/1zK1b0fdi8eWcg4NXzsiKtnxC7mTn3roQ2MfVUFcH//" +
       "/uGvPvXtd/5kbgAA4uWnDXg5Kwng4mAKgZrf/oXV3379ax/66s6h0YRgrYsk" +
       "y5STAyGzdujCNYQEo73ykB8QKizgXJnVXOYd21VMzRQlS82s9L8uvgL5xL++" +
       "59LWDizQsm9Gr/7BBA7b72lAb/3SG//9/pzMGTlbqg51dgi2jX+3H1Ku+764" +
       "yfhI3vaX9/3658UPgkgKoldgpmoekM7sOU7G1B0grl7lmAMvZyufVTgHezQv" +
       "dzON5MhQ3lfKigeCo95x3AGP5BxX5Pd+9TsvmXzns8/n4hxPWo4aQ1/0Htva" +
       "X1Y8mADyd50MBZQYGACu/BzzU5es574HKAqAogxW6mDgg0CUHDOdPejrz//d" +
       "5/70zjd95Sy0Q0IXLFdUSDH3QuhGYP5qYIAYlnivf8N29uMbQHEpFxW6Svit" +
       "1dydv10HGHzkhQMQmeUchz58938OLOmJf/iPq5SQh55TltoT+AL8zAfuJV73" +
       "rRz/MAZk2PcnVwdnkJ8d4qIfsf9t5+Fzf7YDnRegS/Je8jcRrSjzLAEkPMF+" +
       "RggSxGP9x5OX7Ur92EGMe9nJ+HNk2JPR53BRAPUMOqtfOBFwbs60fDd4Lu75" +
       "4sWTAecMlFfqOcpDeXk5K16179/nPd9cg5V9z8G/D35nwPM/2ZMRyxq26/Bt" +
       "xF4y8OBBNuCB9ep8INqeBSzqmtM79E0bBK31XiYEP37b15cf+OZHt1nOybk8" +
       "Aay+68mf//7ue57cOZJbvvyq9O4ozja/zJX1kqwgM+946Fqj5BjkPz37+Kd/" +
       "7/F3brm67Xim1AIbgY/+1X9/eff93/jiKcv2WZAFb6N7VpazorHVKf6CrvKa" +
       "LW9nwDRcj+7iu8XsnTt9qs5m1R8H8TjIdwMAQzMd0cplJEPg+pZ8eX+CJmB3" +
       "AHzl8sLC94PXpdzNM6vc3abUJ3gl/8+8Ak3eckiMdkF2/u5/fO+Xf+nlXwda" +
       "6ULXrzM/AOo7MiITZRuWdzzz1H03PfmNd+fLC7A97g1vd9+aUX3jtSTOimlW" +
       "zPZFvTcTlXMjX1ZpMQj7+YqgKgfSdo7I0w/BuuL+ENKGt7yaKged+v6Pnsy1" +
       "acwjCQkPHdj08T4TrpfFxNBZCl/SPYkzu06MMZ4pB1O+OeHRnippJdxPylJJ" +
       "E7Spqo2n9njVaC95o840TTIs+7U6x+ndXrskjvTiaKKwNq/0Vl7bHoedLi+J" +
       "M85bGY2JMFiFLcQpRbiKR6gyFto9b1ZS1TRI8SpatRW4v6aHM44mvSUh2lWj" +
       "rhWxpVCxGhidTvqkHc5WbScyaKtR0Uii4Ku1SUkNCIzg6pNObdRHIlNYBTwq" +
       "9NJGrBPoeIKR3MSm7WYwMja1ht8X+vMOJvXspteooGrSq7husJESyUxbS7SF" +
       "MkTPtpxGuGH6E8HaoPVlzI/QljXHCa6KagWM5jurLl/U5KrlqNWFNJwU2H5k" +
       "R8Ksy7Vq1nCE6uVkyltUl2RK3hzdtDyFr845MxCadB9pFrApEuo2OqpJtt1r" +
       "WtqwuWhX1bbosl3B6k4QyWDTQrLwVmI/IM1WgykJTZe3Una47FXYmDXdatLd" +
       "FEdeQsZ4w203BCSkpt58qEzGraKFplOj6chLS9U5yTXHI8UilLbPegRqTwqx" +
       "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" +
       "8oPv/wXeuCjBASUAAA==");
}
