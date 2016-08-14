package org.apache.batik.svggen;
public class SVGEllipse extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGEllipse(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) <
              0 ||
              ellipse.
              getHeight(
                ) <
              0) {
            return null;
        }
        if (ellipse.
              getWidth(
                ) ==
              ellipse.
              getHeight(
                ))
            return toSVGCircle(
                     ellipse);
        else
            return toSVGEllipse(
                     ellipse);
    }
    private org.w3c.dom.Element toSVGCircle(java.awt.geom.Ellipse2D ellipse) {
        org.w3c.dom.Element svgCircle =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CIRCLE_TAG);
        svgCircle.
          setAttributeNS(
            null,
            SVG_CX_ATTRIBUTE,
            doubleString(
              ellipse.
                getX(
                  ) +
                ellipse.
                getWidth(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_CY_ATTRIBUTE,
            doubleString(
              ellipse.
                getY(
                  ) +
                ellipse.
                getHeight(
                  ) /
                2));
        svgCircle.
          setAttributeNS(
            null,
            SVG_R_ATTRIBUTE,
            doubleString(
              ellipse.
                getWidth(
                  ) /
                2));
        return svgCircle;
    }
    private org.w3c.dom.Element toSVGEllipse(java.awt.geom.Ellipse2D ellipse) {
        if (ellipse.
              getWidth(
                ) >
              0 &&
              ellipse.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgCircle =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_ELLIPSE_TAG);
            svgCircle.
              setAttributeNS(
                null,
                SVG_CX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getX(
                      ) +
                    ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_CY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getWidth(
                      ) /
                    2));
            svgCircle.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  ellipse.
                    getHeight(
                      ) /
                    2));
            return svgCircle;
        }
        else
            if (ellipse.
                  getWidth(
                    ) ==
                  0 &&
                  ellipse.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ),
                  ellipse.
                    getX(
                      ),
                  ellipse.
                    getY(
                      ) +
                    ellipse.
                    getHeight(
                      ));
                if (svgLine ==
                      null)
                    svgLine =
                      new org.apache.batik.svggen.SVGLine(
                        generatorContext);
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (ellipse.
                      getWidth(
                        ) >
                      0 &&
                      ellipse.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      ellipse.
                        getX(
                          ),
                      ellipse.
                        getY(
                          ),
                      ellipse.
                        getX(
                          ) +
                        ellipse.
                        getWidth(
                          ),
                      ellipse.
                        getY(
                          ));
                    if (svgLine ==
                          null)
                        svgLine =
                          new org.apache.batik.svggen.SVGLine(
                            generatorContext);
                    return svgLine.
                      toSVG(
                        line);
                }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO+NvG3/w5fJhgzFENuQuTkIragKBw4DJ2TgY" +
                                                              "kHo0HHN7c3cLe7vL7px9dpoWkCLIP5RSIKRK/JcjFEoCihq1lZqIKmqTKG2l" +
                                                              "JKRtWoVW7T9pU9SgqmlV+vVmZr/vzhSpOWln52bevDfvzXu/92Yv30TVpoE6" +
                                                              "iUojdFInZmRQpaPYMEk6pmDT3ANjSenpKvyXAx+NrA+jmgSam8PmsIRNsk0m" +
                                                              "StpMoGWyalKsSsQcISTNVowaxCTGOKaypibQAtkcyuuKLMl0WEsTRrAPG3HU" +
                                                              "hik15FSBkiGLAUXL4rCTKN9JdHNweiCOmiRNn3TJOzzkMc8Mo8y7skyKWuOH" +
                                                              "8DiOFqisROOySQeKBlqja8pkVtFohBRp5JCyzjLBzvi6EhN0X2359PbpXCs3" +
                                                              "wTysqhrl6pm7iakp4yQdRy3u6KBC8uYR9FVUFUeNHmKKeuK20CgIjYJQW1uX" +
                                                              "CnbfTNRCPqZxdajNqUaX2IYoWuFnomMD5y02o3zPwKGOWrrzxaDtckdboWWJ" +
                                                              "iufWRM8+faD15SrUkkAtsjrGtiPBJigISYBBST5FDHNzOk3SCdSmwmGPEUPG" +
                                                              "ijxlnXS7KWdVTAtw/LZZ2GBBJwaX6doKzhF0MwoS1QxHvQx3KOtfdUbBWdB1" +
                                                              "oaur0HAbGwcFG2TYmJHB4HfWkjmHZTVNUVdwhaNjzyNAAEtr84TmNEfUHBXD" +
                                                              "AGoXLqJgNRsdA9dTs0BarYEDGhQtrsiU2VrH0mGcJUnmkQG6UTEFVPXcEGwJ" +
                                                              "RQuCZJwTnNLiwCl5zufmyIZTj6s71DAKwZ7TRFLY/hthUWdg0W6SIQaBOBAL" +
                                                              "m/ri5/HCV0+GEQLiBQFiQfPdr9x6eG3ntTcFzZIyNLtSh4hEk9JMau47S2O9" +
                                                              "66vYNup0zZTZ4fs051E2as0MFHVAmIUORzYZsSev7f7xl45eIh+HUcMQqpE0" +
                                                              "pZAHP2qTtLwuK8TYTlRiYErSQ6ieqOkYnx9CtdCPyyoRo7syGZPQITRH4UM1" +
                                                              "Gv8PJsoAC2aiBujLakaz+zqmOd4v6gihWnhQEzwrkPjxN0V7ozktT6JYwqqs" +
                                                              "atFRQ2P6m1FAnBTYNhdNgdcfjppawQAXjGpGNorBD3LEnhjPZokaHdu3fVBR" +
                                                              "ZN0kEeZe+mfFuMg0mjcRCoGxlwZDXYEo2aEpaWIkpbOFLYO3Xkq+LdyIub5l" +
                                                              "C4q6QVZEyIpwWREhK+LKQqEQFzGfyRRnCSdxGGIaQLWpd+yxnQdPdleBE+kT" +
                                                              "c8CMjLTbl1xibuDbaJ2UrrQ3T6240f96GM2Jo3Ys0QJWWK7YbGQBhaTDVqA2" +
                                                              "pSDtuOi/3IP+LG0ZmkTSAD6VsoDFpU4bJwYbp2i+h4Odm1gURitnhrL7R9cu" +
                                                              "TBzb97X7wijsB3wmshqwii0fZTDtwHFPMNDL8W058dGnV84/obkh78sgduIr" +
                                                              "Wcl06A46QdA8SalvOX4l+eoTPdzs9QDJFEMIAdp1BmX4EGXARmemSx0onNGM" +
                                                              "PFbYlG3jBpoztAl3hHtnG+/PB7doZCG2AJ4+K+b4m80u1Fm7SHgz87OAFhz9" +
                                                              "HxrTn/vlz/7wADe3nShaPBl+jNABDzgxZu0chtpct91jEAJ0H14Y/ea5myf2" +
                                                              "c58FipXlBPawNgagBEcIZn7yzSMf/ObGzPWw6+cUsnMhBUVO0VGSjaOGWZQE" +
                                                              "aavd/QC4KYADzGt69qrgn3JGximFsMD6Z8uq/lf+dKpV+IECI7Ybrb0zA3f8" +
                                                              "c1vQ0bcP/K2TswlJLLm6NnPJBGLPczlvNgw8yfZRPPbusmfewM8B9gPemvIU" +
                                                              "4RAasmKdbaqDojWzwIiF6Jph1RX8oNfxlffx9kFmJM4P8bn1rFllegPGH5Oe" +
                                                              "wikpnb7+SfO+T167xTX0V15e/xjG+oBwSdasLgL7RUFA24HNHNA9eG3ky63K" +
                                                              "tdvAMQEcJYBkc5cBSFr0eZNFXV37qx++vvDgO1UovA01KBpOb8M8MFE9RAQx" +
                                                              "cwDCRX3Tw8IhJuqgaeWqohLlSwbYoXSVP+7BvE75AU19b9F3NlycvsE9Uxc8" +
                                                              "ljhIvNSHxLx+d8Hg0ntfeP/iN85PiAqgtzICBtZ1/GOXkjr+u7+XmJxjX5nq" +
                                                              "JLA+Eb387OLYxo/5eheE2OqeYmkuAyB3195/Kf/XcHfNj8KoNoFaJate3oeV" +
                                                              "AgvtBNSIpl1EQ03tm/fXe6K4GXBAdmkQAD1ig/Dn5lDoM2rWbw4gHisw0FJ4" +
                                                              "VllgsCqIeCHEO4/wJffwto8199oAU6sbMtypSABhGmdhCosg9FipZMdm1yyx" +
                                                              "yegE7rL2i6yJC2EPlfNYMXUPa9Y4W+K/mmA15QU91yURi7tllQpeXqzPHD87" +
                                                              "nd71fL9wynZ/ETkId6QXf/6vn0Qu/PatMtVMPdX0exUyThSPzCom0hcGw/wu" +
                                                              "4PrUh3PP/P77Pdktd1OLsLHOO1Qb7H8XKNFXObKCW3nj+B8X79mYO3gXZUVX" +
                                                              "wJxBli8MX35r+2rpTJhffISzl1yY/IsG/C7eYBC44al7fI6+0nGAeexgO+Dp" +
                                                              "txygv3xqL+M7TsKstDSQJgJpRyA4nqCRLNHyEatgvX8rF5idJcXwI01RVE01" +
                                                              "iAKb3TwWKRMPSJE0Z0byxLqJ88CQZgmM/wHK2UBM5+MHHP15/HTBs8nSf9Md" +
                                                              "TDdSigSVlpY3Hfub41yLs9hnijWQQRu5fWKyIYl7Vd41B/2szLEcnkctnR69" +
                                                              "e3NUWnonczw5izlOsOYoRU3cHJabBexx7P9hjyJFDa4Elv47Sr7hiO8O0kvT" +
                                                              "LXWLpvf+goOW822gCeAnU1AUb4Ly9Gt0g2RkrlOTSFc6f30dYqlCmoAyV3T4" +
                                                              "nk8J+jMUtQbpIZr420t3DvRx6YCV6HhJLlBUBSSs+4xuR2L/bPWkgfWcLIn8" +
                                                              "DbkewJZCbRbypxnnXBbc6Vw8mWmlD6j5RzYbVAviMxtcXKd3jjx+6/PPi5uI" +
                                                              "pOApHiyNcVQrLkUOMK+oyM3mVbOj9/bcq/WrwpaftYkNu06+xOOEMXBXnbnE" +
                                                              "4kCZbvY41foHMxte++nJmnchN+5HIQyQtr+05CnqBciI++NuTvR8pOX3h4He" +
                                                              "b01uXJv58695UYlKSskgfVK6fvGx9850zMA9o3EIVUMaJ0Vei22dVHcTadxI" +
                                                              "oGbZHCzCFoGLjJUhVFdQ5SMFMpSOo7nMezH7/MbtYpmz2Rll91iKuku+s5W5" +
                                                              "/UMBPkGMLVpBTfNUBUnUHfF9/bNzW0HXAwvcEeco55fqnpS2PtXyg9PtVdsg" +
                                                              "An3qeNnXmoWUkze9HwTdRNoqMOw/8AvB82/2sENnA+wNZWvM+ji23Pk6BpW+" +
                                                              "mKtKxod13aZteF8XMfRt1rxYZOMUhfqs0QDwXeXyr/Aua17+L/sg3DQcGAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AA==");
}
