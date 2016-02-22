package org.sunflow.core.shader;
public class WireframeShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color lineColor;
    private org.sunflow.image.Color fillColor;
    private float width;
    private float cosWidth;
    public WireframeShader() { super();
                               lineColor = org.sunflow.image.Color.BLACK;
                               fillColor = org.sunflow.image.Color.WHITE;
                               width = (float) (java.lang.Math.PI * 0.5 /
                                                  4096);
                               cosWidth = (float) java.lang.Math.cos(width);
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        lineColor =
          pl.
            getColor(
              "line",
              lineColor);
        fillColor =
          pl.
            getColor(
              "fill",
              fillColor);
        width =
          pl.
            getFloat(
              "width",
              width);
        cosWidth =
          (float)
            java.lang.Math.
            cos(
              width);
        return true;
    }
    public org.sunflow.image.Color getFillColor(org.sunflow.core.ShadingState state) {
        return fillColor;
    }
    public org.sunflow.image.Color getLineColor(org.sunflow.core.ShadingState state) {
        return lineColor;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Point3[] p =
          new org.sunflow.math.Point3[3];
        if (!state.
              getTrianglePoints(
                p))
            return getFillColor(
                     state);
        org.sunflow.math.Point3 center =
          state.
          getPoint(
            );
        org.sunflow.math.Matrix4 w2c =
          state.
          getWorldToCamera(
            );
        center =
          w2c.
            transformP(
              center);
        for (int i =
               0;
             i <
               3;
             i++)
            p[i] =
              w2c.
                transformP(
                  state.
                    getInstance(
                      ).
                    transformObjectToWorld(
                      p[i]));
        float cn =
          1.0F /
          (float)
            java.lang.Math.
            sqrt(
              center.
                x *
                center.
                  x +
                center.
                  y *
                center.
                  y +
                center.
                  z *
                center.
                  z);
        for (int i =
               0,
               i2 =
                 2;
             i <
               3;
             i2 =
               i,
               i++) {
            float t =
              (center.
                 x -
                 p[i].
                   x) *
              (p[i2].
                 x -
                 p[i].
                   x);
            t +=
              (center.
                 y -
                 p[i].
                   y) *
                (p[i2].
                   y -
                   p[i].
                     y);
            t +=
              (center.
                 z -
                 p[i].
                   z) *
                (p[i2].
                   z -
                   p[i].
                     z);
            t /=
              p[i].
                distanceToSquared(
                  p[i2]);
            float projx =
              (1 -
                 t) *
              p[i].
                x +
              t *
              p[i2].
                x;
            float projy =
              (1 -
                 t) *
              p[i].
                y +
              t *
              p[i2].
                y;
            float projz =
              (1 -
                 t) *
              p[i].
                z +
              t *
              p[i2].
                z;
            float n =
              1.0F /
              (float)
                java.lang.Math.
                sqrt(
                  projx *
                    projx +
                    projy *
                    projy +
                    projz *
                    projz);
            float dot =
              projx *
              center.
                x +
              projy *
              center.
                y +
              projz *
              center.
                z;
            if (dot *
                  n *
                  cn >=
                  cosWidth)
                return getLineColor(
                         state);
        }
        return getFillColor(
                 state);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZfZAURxXv3fvkvu/4/rgDjoMUB9kNMRhTh8hx4cLiAlsc" +
       "ED0ix+xs7+3A7Mww03u3ENGElMVpKYWEELQCfygxkYKAHymNGopUypAUiVWJ" +
       "UYipEI1WiUbKUFaIJWp8r3tmZ3b2g7oq2arpmel5r/u91+/j170nr5IqyyQd" +
       "VGMhtsugVmiVxmKSadFEnypZ1kboG5Ifr5D+sfXKunuCpHqQNKUka60sWbRf" +
       "oWrCGiTtimYxSZOptY7SBHLETGpRc0Riiq4NksmKFUkbqiIrbK2eoEiwWTKj" +
       "pFVizFTiGUYj9gCMtEdBkjCXJNzr/9wTJQ2ybuxyyad5yPs8X5Ay7c5lMdIS" +
       "3S6NSOEMU9RwVLFYT9Ykiwxd3TWs6ixEsyy0XV1qm2BNdGmBCTrPNF+/cSDV" +
       "wk0wUdI0nXH1rA3U0tURmoiSZrd3lUrT1k7yJVIRJfUeYka6os6kYZg0DJM6" +
       "2rpUIH0j1TLpPp2rw5yRqg0ZBWJkbv4ghmRKaXuYGJcZRqhltu6cGbSdk9NW" +
       "aFmg4mOLwoce39rywwrSPEiaFW0AxZFBCAaTDIJBaTpOTas3kaCJQdKqwWIP" +
       "UFORVGW3vdJtljKsSSwDy++YBTszBjX5nK6tYB1BNzMjM93MqZfkDmW/VSVV" +
       "aRh0neLqKjTsx35QsE4BwcykBH5ns1TuULQEI7P9HDkduz4LBMBak6Yspeem" +
       "qtQk6CBtwkVUSRsOD4DracNAWqWDA5qMzCg5KNrakOQd0jAdQo/00cXEJ6Ca" +
       "wA2BLIxM9pPxkWCVZvhWybM+V9ct2/+gtloLkgDInKCyivLXA1OHj2kDTVKT" +
       "QhwIxobu6GFpyvNjQUKAeLKPWND85IvXVizuOPeyoJlZhGZ9fDuV2ZB8PN70" +
       "+qy+hfdUoBi1hm4puPh5mvMoi9lferIGZJgpuRHxY8j5eG7DS59/6AR9P0jq" +
       "IqRa1tVMGvyoVdbThqJS8z6qUVNiNBEhE6iW6OPfI6QGnqOKRkXv+mTSoixC" +
       "KlXeVa3zdzBREoZAE9XBs6IldefZkFiKP2cNQkgNXCQEVz0RP35n5HPhlJ6m" +
       "YUmWNEXTwzFTR/2tMGScONg2FbYyWlLVR8OWKYd1czj3LusmDVspKUHN8P2K" +
       "SZMQnXSAv4fQw4xbOHYW9Zo4GgiAyWf5A16FWFmtq0A7JB/KrFx17ZmhC8KZ" +
       "MABsizByG0wYsicM4YQhMWHINyEJBPg8k3BisaywKDsgvCG/Niwc+MKabWOd" +
       "FeBPxmglWBRJO/PqTJ+bA5zEPSSfbmvcPffykheDpDJK2iSZZSQVy0avOQwJ" +
       "Sd5hx2xDHCqQWwjmeAoBVjBTl2kC8lCpgmCPUquPUBP7GZnkGcEpUxiQ4dJF" +
       "oqj85NyR0Yc3f/mOIAnm536csgrSFrLHMGPnMnOXP+aLjdu878r104f36G70" +
       "5xUTpwYWcKIOnX5P8JtnSO6eIz079PyeLm72CZCdmQTRBImvwz9HXnLpcRI1" +
       "6lILCid1My2p+MmxcR1Lmfqo28NdtJU/T3KibQZcrXb48Tt+nWJgO1W4NPqZ" +
       "TwteCD49YBy99Ku/fIKb26kZzZ5iP0BZjydP4WBtPCO1um670aQU6N45Env0" +
       "sav7tnCfBYp5xSbswrYP8hMsIZj5Ky/vfOvdy8ffDLp+zqBQZ+KAd7I5JbGf" +
       "1JVREmZb4MoDeU6FfIBe07VJA/9UkooUVykG1r+b5y959m/7W4QfqNDjuNHi" +
       "mw/g9k9fSR66sPWjDj5MQMY669rMJRPJe6I7cq9pSrtQjuzDb7R/67x0FMoA" +
       "pF5L2U15NiXcBoQv2lKu/x28vcv37W5s5lte58+PLw8eGpIPvPlB4+YPzl7j" +
       "0uYDKu9ar5WMHuFe2CzIwvBT/clptWSlgO6uc+seaFHP3YARB2FEGVCEtd6E" +
       "rJbN8wybuqrmdy+8OGXb6xUk2E/qVF1K9Es8yMgE8G5qpSCrZo3PrBCLO1oL" +
       "TQtXlRQoX9CBBp5dfOlWpQ3Gjb37p1N/vOypY5e5lxlijJmcvxITfV5W5bDc" +
       "DewTv777N0998/CoKOwLS2czH9+0f61X43vf+2eByXkeKwI6fPyD4ZNPzOhb" +
       "/j7ndxMKcndlC4sTJGWX984T6Q+DndW/DJKaQdIi2zB4s6RmMEwHAfpZDjYG" +
       "qJz3PR/GCczSk0uYs/zJzDOtP5W5RRGekRqfG33ZqwGXcJbz4Ny92StA+EOE" +
       "s9zG225sbneSRY1hKrBVor5sUV9mUEYmINYBV7HR8zRGpnqrtpIGyBni30X2" +
       "xPZT2KwR0/SU9NW+Qt0abTEaS+i2UeiGTbRQiVLcoAQANDUnZMwn6aZxSjoN" +
       "riZ7rqYSkm4pK2kpbkaqRpUES+UDGAQJA5m4BWBDSUNtGbHR9p2xbfJYV+xP" +
       "IuCmF2EQdJOfDn9j88Xtr/LKVYtwZqPjZB6wArDHUzZbhNAfwy8A13/xQmGx" +
       "A+/g/X02dJ6Tw86YMMpGvk+B8J62d3c8ceWUUMAf5j5iOnboax+H9h8S5Uhs" +
       "wOYV7IG8PGITJtTBRkbp5pabhXP0//n0np8/vWefkKotfzuxCnbLp377n1dD" +
       "R37/ShFEC3GtSyyXeQM5PDopf3WESvd+tfkXB9oq+gEKRUhtRlN2ZmgkkZ8Q" +
       "aqxM3LNc7tbOTRK2crg0jAS6YRV8Dv7AOB18JlzNtos2l3Bwq6yDl+JmpFbW" +
       "rfvRx/E97hOUlRE06064KDch/1UT35bKC3fcAhYomsD4tkNsM9A92kvtirlr" +
       "HN976Fhi/ZNLgja22A6phenG7SodoapnKjzpas+rlWv5OYBbeN5pOvjH57qG" +
       "V45n84F9HTfZXuD7bHDb7tJB6Bfl/N6/zti4PLVtHPuI2T4r+Yf8/tqTr9y3" +
       "QD4Y5IceoiIWHJbkM/Xku32dSVnG1PIdfV5u3SfiMk8nAs8T516I5Yu4TA4h" +
       "l2L1YckgX9Gg4zwdBc7DTUMZNRE/OWRTvGQD4t4bi3Cxvl4GrR7EZh8A+4yR" +
       "gJTKabbZyQtv1POsQEmP67pKJc2fcfBVz7qBNXazDFAeOGJHr8H7H8kZku8s" +
       "2uHqtA3ZOf41KMXqs1AgP4DbiwawomHoALxBqu+UsfH3sDnKSMMwBQzrBQau" +
       "wY7dSoMtsLVeMH6DlWItbjB8/S4f9Qdl7PEjbE4Ke0QdtOezx6lbZQ+Efd22" +
       "Ut3jt0cp1pvZ42wZe5zD5jlG6sEeG8CvnNzrMcfPboE5eOlaDlfE1ikyfnOU" +
       "Yi2e07g5uGZ86AtlbPIaNi8x0mjJEoNcF0vpzC4RvpRUOaIrCddS5/8flsrC" +
       "7tt3Joib2WkFfzSIw3H5mWPNtVOPbbrIq2vuALsB6mQyo6re7ZbnudqACRSu" +
       "bYPYfAkgdakYYhAHlZCnxQMX/KKgf5uRFj89mAVvXrLL4GAeMoZIjz95if7A" +
       "SAUQ4eN7hpP+WvgeHredIbHtzAY82IN40v7kmxk/x+I9g0LEwP/pcap7RvzX" +
       "MySfPrZm3YPXPvmkOAOTVWn3bhylHmCqOI7LIYS5JUdzxqpevfBG05kJ8x0s" +
       "1SoEdn18psf9eiF4DVzyGb4DIqsrd0701vFlZ18bq34DYPkWEpAYmbilcIOe" +
       "NTIAzbZEC+E4oCl+ctWz8Nu7li9O/v1tfgRCBHyfVZp+SB589FLkzI6PVvC/" +
       "FqoAJtIsPzm4d5e2gcojZh62b0JvlPA/H24H23yNuV48MWWks3BjU3jOXAfO" +
       "Qs2VekZL4DCwO6h3exxkmAeqMobhY3B7PJs/TUQ0Wh/8byi61jCcfd8LBg9J" +
       "vTjgwPZD/ojN9f8BAejTv/QdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "7MTi/wEDM13JgigAAA==");
}
