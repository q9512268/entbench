package org.sunflow.core.shader;
public class MirrorShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color color;
    public MirrorShader() { super();
                            this.color = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        color =
          pl.
            getColor(
              "color",
              color);
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (!state.
              includeSpecular(
                ))
            return org.sunflow.image.Color.
                     BLACK;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 refDir =
          new org.sunflow.math.Vector3(
          );
        refDir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        refDir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        refDir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        org.sunflow.core.Ray refRay =
          new org.sunflow.core.Ray(
          state.
            getPoint(
              ),
          refDir);
        cos =
          1 -
            cos;
        float cos2 =
          cos *
          cos;
        float cos5 =
          cos2 *
          cos2 *
          cos;
        org.sunflow.image.Color ret =
          org.sunflow.image.Color.
          white(
            );
        ret.
          sub(
            color);
        ret.
          mul(
            cos5);
        ret.
          add(
            color);
        return ret.
          mul(
            state.
              traceReflection(
                refRay,
                0));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        float avg =
          color.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd >=
              avg)
            return;
        state.
          faceforward(
            );
        float cos =
          state.
          getCosND(
            );
        power.
          mul(
            color).
          mul(
            1.0F /
              avg);
        float dn =
          2 *
          cos;
        org.sunflow.math.Vector3 dir =
          new org.sunflow.math.Vector3(
          );
        dir.
          x =
          dn *
            state.
              getNormal(
                ).
              x +
            state.
              getRay(
                ).
              getDirection(
                ).
              x;
        dir.
          y =
          dn *
            state.
              getNormal(
                ).
              y +
            state.
              getRay(
                ).
              getDirection(
                ).
              y;
        dir.
          z =
          dn *
            state.
              getNormal(
                ).
              z +
            state.
              getRay(
                ).
              getDirection(
                ).
              z;
        state.
          traceReflectionPhoton(
            new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              dir),
            power);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfYxUVxW/M/v9/QHs8rnAstDw0ZlSi7VZxC5btizOwoSl" +
       "JA7K8ubNnZ3Hvnnv8d6d3dltVynWsDVKEChQ0/KPNFTCV4yNGm1DbbRtWk1a" +
       "q201pUZNRCuxxNgaUes5976veTO7SGIneffdufecc+8595zfOfedu0YqLJN0" +
       "UI1F2LhBrcgmjcUl06KpXlWyrB0wNiSfKJP+tvvq1nvCpDJBGjOSNSBLFu1T" +
       "qJqyEmSRollM0mRqbaU0hRxxk1rUHJWYomsJMkex+rOGqsgKG9BTFAl2SmaM" +
       "tEiMmUoyx2i/LYCRRTHYSZTvJNoTnO6OkXpZN8Y98rk+8l7fDFJmvbUsRppj" +
       "e6VRKZpjihqNKRbrzptktaGr48OqziI0zyJ71XW2CbbE1hWZoPNS0wc3Dmea" +
       "uQlmSZqmM66etZ1aujpKUzHS5I1uUmnW2ke+SMpipM5HzEhXzFk0CotGYVFH" +
       "W48Kdt9AtVy2V+fqMEdSpSHjhhhZWijEkEwpa4uJ8z2DhGpm686ZQdslrrZC" +
       "yyIVH1sdPXZid/N3ykhTgjQp2iBuR4ZNMFgkAQal2SQ1rZ5UiqYSpEWDwx6k" +
       "piKpyoR90q2WMqxJLAfH75gFB3MGNfmanq3gHEE3Mycz3XTVS3OHsv9VpFVp" +
       "GHRt83QVGvbhOChYq8DGzLQEfmezlI8oWoqRxUEOV8euzwIBsFZlKcvo7lLl" +
       "mgQDpFW4iCppw9FBcD1tGEgrdHBAk5H50wpFWxuSPCIN0yH0yABdXEwBVQ03" +
       "BLIwMidIxiXBKc0PnJLvfK5tXX/oQW2zFiYh2HOKyiruvw6YOgJM22mamhTi" +
       "QDDWr4odl9qenQoTAsRzAsSC5nsPXb93TcfllwTNghI025J7qcyG5NPJxtcW" +
       "9q68pwy3UW3oloKHX6A5j7K4PdOdNwBh2lyJOBlxJi9v/+nn9p+l74VJbT+p" +
       "lHU1lwU/apH1rKGo1LyfatSUGE31kxqqpXr5fD+pgn5M0agY3ZZOW5T1k3KV" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7/nvD8DvFLj+O7syYtnAdne9TO1t8Y8c7PEe2IvOghRgLyN8ZQjde3RnMm2Q" +
       "RmX+6frbuJa1hax5cjsdcVMr+qmsqSenAIdnC7vkLpo9t28sxems+xMgEgV5" +
       "+gswdNORrFxXdcDSwlKu7PMugHQYmNGVhUXus3wp94BswXa3OeQJXuv/a16B" +
       "hd95SKzjgnT0ff/w/q/80qu/AcywBZ2NMhMB1ndkxt46y9Df/dyHHrztmW++" +
       "Lw+sYFn4J9/lvj2jKryUxFnTz5rBvqj3Z6Ly7tpXtI4UhN08FmpqLu1Let/A" +
       "N22wZUR76Sfy1OVvLD/6rU9tU8uTrnYCWHvvM7/wg92nn9k5ktC/+rqc+ijO" +
       "NqnPmb5jT8M+9OhLzZJjMP/4/FN/8JtPvWfL1eXj6SkNvr4+9Zf/9ZXdj3zz" +
       "SzfImM5Y7o+wsOEdf84Wg2Z1/9cRZvosGQvJBOkiUQUZskHZd6pBWI9R0eJN" +
       "UhATipBDM+3HLm+1qmS7vJZ7joizkeNEZbWk4qoVChtnEtSFNk3NhyjSHvSY" +
       "ESUUN72GjdVlmQsnS0xaFVDMG4s9jlonSc+QxlpAVMgSUEuf5BtNR9N1da1r" +
       "igKXiQqR6n0dJDvobNVp9dBxE2MKnXnNVwx7oYwttNT2ptZk49fQuGfyers1" +
       "gMMoWmFORHn1Vq2x6PM9vtZh1tho1VptaJvnwO7YRW1uJUtjdM4lyRLzx2xr" +
       "MnPtoNVdagns9xurwGg3KrURU7UKvC11Q9rs2mN3kxRMpDOjOG7EznhxFLV6" +
       "7sjpl/rLqSf2yrNK2V/CZYvU60zLjuRxwHneQisJXFv0FuZ81Wtzsp964TKU" +
       "Gn6x3F+lZhNNNy0Sm04KlCzT2HwiuoMej8YKXrc1aT20bF5c2d1SCcRpTFov" +
       "vPY4ZXmiia3HtjMpLDWY73qm1yXYlJ5PU2aJUm7YmAkMOymW22pYqYJFKQiw" +
       "vurSKu/x7GI+n4sTc0Ev6diTiutWOS3U5w3PLpVL4lANLN8Xqc2mKbBYoA6m" +
       "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" +
       "jba9MD8fS3//3t95/W88+/W8fv0/m0ctPrkjAAA=");
}
