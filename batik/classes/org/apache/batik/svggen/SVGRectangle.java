package org.apache.batik.svggen;
public class SVGRectangle extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    private org.apache.batik.svggen.SVGLine svgLine;
    public SVGRectangle(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        svgLine =
          new org.apache.batik.svggen.SVGLine(
            generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Rectangle2D rect) {
        return toSVG(
                 (java.awt.geom.RectangularShape)
                   rect);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.RoundRectangle2D rect) {
        org.w3c.dom.Element svgRect =
          toSVG(
            (java.awt.geom.RectangularShape)
              rect);
        if (svgRect !=
              null &&
              svgRect.
              getTagName(
                ) ==
              SVG_RECT_TAG) {
            svgRect.
              setAttributeNS(
                null,
                SVG_RX_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcWidth(
                          ) /
                        2)));
            svgRect.
              setAttributeNS(
                null,
                SVG_RY_ATTRIBUTE,
                doubleString(
                  java.lang.Math.
                    abs(
                      rect.
                        getArcHeight(
                          ) /
                        2)));
        }
        return svgRect;
    }
    private org.w3c.dom.Element toSVG(java.awt.geom.RectangularShape rect) {
        if (rect.
              getWidth(
                ) >
              0 &&
              rect.
              getHeight(
                ) >
              0) {
            org.w3c.dom.Element svgRect =
              generatorContext.
                domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_RECT_TAG);
            svgRect.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  rect.
                    getX(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  rect.
                    getY(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  rect.
                    getWidth(
                      )));
            svgRect.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  rect.
                    getHeight(
                      )));
            return svgRect;
        }
        else {
            if (rect.
                  getWidth(
                    ) ==
                  0 &&
                  rect.
                  getHeight(
                    ) >
                  0) {
                java.awt.geom.Line2D line =
                  new java.awt.geom.Line2D.Double(
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ),
                  rect.
                    getX(
                      ),
                  rect.
                    getY(
                      ) +
                    rect.
                    getHeight(
                      ));
                return svgLine.
                  toSVG(
                    line);
            }
            else
                if (rect.
                      getWidth(
                        ) >
                      0 &&
                      rect.
                      getHeight(
                        ) ==
                      0) {
                    java.awt.geom.Line2D line =
                      new java.awt.geom.Line2D.Double(
                      rect.
                        getX(
                          ),
                      rect.
                        getY(
                          ),
                      rect.
                        getX(
                          ) +
                        rect.
                        getWidth(
                          ),
                      rect.
                        getY(
                          ));
                    return svgLine.
                      toSVG(
                        line);
                }
            return null;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYa4wUxxHu3ePed9yDxx2vA44DxMO7xoZE5DAYlgMO7z3E" +
                                                              "YaIsMUvvbO/uwOzMMNNzt3e2ExsrgiiSRTDG2DL8wkJGxDiJnYcUW0RWYltO" +
                                                              "ItkmDycyef1x4qAYRXGikFdVz8zO7OzuEaR4pemZ7a6q7qqu+qq6L10ntaZB" +
                                                              "epjKI3xSZ2ZkQOWj1DBZOqZQ09wLfUnpqRr6lwMfDG8Mk7oEmZmj5pBETbZD" +
                                                              "ZkraTJBFsmpyqkrMHGYsjRyjBjOZMU65rKkJMkc2B/O6IksyH9LSDAn2USNO" +
                                                              "OijnhpyyOBt0BHCyKA4riYqVRLcGh/vjpEXS9EmPvNtHHvONIGXem8vkpD1+" +
                                                              "iI7TqMVlJRqXTd5fMMgaXVMms4rGI6zAI4eUDY4Jdsc3lJmg98W2j2+eyLUL" +
                                                              "E8yiqqpxoZ65h5maMs7ScdLm9Q4oLG8eIV8gNXHS7CPmpC/uThqFSaMwqaut" +
                                                              "RwWrb2WqlY9pQh3uSqrTJVwQJ0tLhejUoHlHzKhYM0ho4I7ughm0XVLU1tay" +
                                                              "TMUn10RPPXWg/Rs1pC1B2mR1DJcjwSI4TJIAg7J8ihnm1nSapROkQ4XNHmOG" +
                                                              "TBV5ytnpTlPOqpRbsP2uWbDT0pkh5vRsBfsIuhmWxDWjqF5GOJTzrzaj0Czo" +
                                                              "OtfT1dZwB/aDgk0yLMzIUPA7h2XGYVlNc7I4yFHUse8+IADW+jzjOa041QyV" +
                                                              "QgfptF1EoWo2Ogaup2aBtFYDBzQ4mV9VKNpap9JhmmVJ9MgA3ag9BFSNwhDI" +
                                                              "wsmcIJmQBLs0P7BLvv25Przp8QfVXWqYhGDNaSYpuP5mYOoJMO1hGWYwiAOb" +
                                                              "sWV1/DSd+8rxMCFAPCdAbNN8+6Eb967tufKGTbOgAs1I6hCTeFI6n5r59sLY" +
                                                              "qo01uIwGXTNl3PwSzUWUjToj/QUdEGZuUSIORtzBK3t++LlHLrIPw6RpkNRJ" +
                                                              "mmLlwY86JC2vywozdjKVGZSz9CBpZGo6JsYHST18x2WV2b0jmYzJ+CCZoYiu" +
                                                              "Ok38BxNlQASaqAm+ZTWjud865TnxXdAJIfXwkBZ4lhH7J96cfDaa0/IsSiWq" +
                                                              "yqoWHTU01N+MAuKkwLa5aAq8/nDU1CwDXDCqGdkoBT/IMXdgPJtlanRs3849" +
                                                              "wAdOpbAIOpj+yYkuoFazJkIhMPjCYLgrECm7NCXNjKR0yto2cOOF5Fu2K6H7" +
                                                              "O/YAgILZIvZsETFbxJ4t4p+NhEJiktk4q72jsB+HIbIBWltWjT2w++Dx3hpw" +
                                                              "JX1iBhgTSXtLUkzMC38Xs5PS5c7WqaXX1r0WJjPipJNK3KIKZoytRhawSDrs" +
                                                              "hGtLCpKPlwOW+HIAJi9Dk1gaIKhaLnCkNGjjzMB+Tmb7JLgZCmMxWj0/VFw/" +
                                                              "uXJm4tF9X7wzTMKlsI9T1gJiIfsognURlPuC4V5JbtuxDz6+fPphzQv8kjzi" +
                                                              "pr8yTtShN+gGQfMkpdVL6MvJVx7uE2ZvBGDmFAIJMK8nOEcJrvS7GI26NIDC" +
                                                              "Gc3IUwWHXBs38ZyhTXg9wj87xPdscItmDLQueNY6kSfeODpXx7bL9mf0s4AW" +
                                                              "IgfcM6af/cVP/nC3MLebLtp8eX6M8X4fRKGwTgFGHZ7b7jUYA7r3z4w+8eT1" +
                                                              "Y/uFzwLFskoT9mEbA2iCLQQzf+mNI+/9+tr5q2HPzznkaCsFpU6hqCT2k6Zp" +
                                                              "lITZVnjrAYhTIMrQa/ruV8E/5YxMUwrDwPpn2/J1L//p8XbbDxTocd1o7a0F" +
                                                              "eP3ztpFH3jrwtx4hJiRhivVs5pHZuD3Lk7zVMOgkrqPw6DuLnn6dnoUMAKhr" +
                                                              "ylNMAGnIiXVcVDcna6YBEgfXNcOpLsRGbxCcd4p2PRpJyCNibCM2y01/wJTG" +
                                                              "pK98Skonrn7Uuu+jV28IDUvrL79/DFG933ZJbFYUQHxXENB2UTMHdOuvDH++" +
                                                              "XblyEyQmQKIEsGyOGIClhRJvcqhr63/5/dfmHny7hoR3kCZFo+kdVAQmaYSI" +
                                                              "YGYOYLigb7nXdoiJBmjahaqkTPmyDtyUxZW3eyCvc7FBU9/pemnThXPXhGfq" +
                                                              "towFRSReWILEoor3wODiu5/+6YWvnp6w64BV1REwwNf9jxEldfR3fy8zucC+" +
                                                              "CjVKgD8RvfTs/NjmDwW/B0LI3Vcoz2YA5B7vXRfzfw331v0gTOoTpF1yquZ9" +
                                                              "VLEwtBNQKZpuKQ2Vdcl4adVnlzj9RZBdGARA37RB+POyKHwjNX63BhAPywyy" +
                                                              "EJ6VDhisDCJeiIiP+wTLStGuxuYOF2DqdUOGkxULIEzzNEKBCUIPCyY3NhdP" +
                                                              "E5tIZ+Mutp/BJm5Pdk8lj7WHVmKzprgk8asL1lR+0PNckmDcLapW9oqS/fzR" +
                                                              "U+fSI8+ts52ys7SUHICT0td+9q8fRc785s0K9Uwj1/Q7FDbOFN+cNThlSRgM" +
                                                              "iROB51Pvzzz5++/2ZbfdTi2CfT23qDbw/2JQYnX1yAou5fWjf5y/d3Pu4G2U" +
                                                              "FYsD5gyKfH7o0ps7V0gnw+L4Yzt72bGplKm/1MWbDAbnPHVviaMvKzrALNzY" +
                                                              "bnjWOw6wvnJqr+A7xYRZjTWQJgJpZ57ARjrBI1mm5SPFkvWu7WLK7DRJRmxq" +
                                                              "ipNarkEcuAJnYaxM3C1F0iAOD/bMOZGL0JCmCY3/AcyxI6aL/gPlxtviWGDL" +
                                                              "7RuvGuv0xusJGE+z1HTQgoVpLPgQNqZrQfyT90zFPwFTCbCZB8+Io+/ILUw1" +
                                                              "XA6b1Vhvz1S2lSyFGmM5qjMx77FpTPUVbI5WMdVj/w9TFThp8R/asHLoLrsE" +
                                                              "si8upBfOtTV0nbv/5wLvipcLLYBcGUtR/LnN912nGywjC3Va7Eyni9cTnHRV" +
                                                              "yTBQIdsfYtUnbfrTnLQH6cEy4u2ne5qTJo8ORNkffpJnOakBEvw8q7t7tW66" +
                                                              "UtSgek6W7NQPZQLgNIeyLlSaoYo7M+dWO+NLastKMF7c0rl4bNn3dHDmPbd7" +
                                                              "+MEbn3rOPsRICp2aQinNcVJvn6eKmL60qjRXVt2uVTdnvti4POy4WIe9YC8C" +
                                                              "Fvj8Lwa+rKNLzA9U+GZfsdB/7/ymV398vO4dSKv7SYgCFu4vr5YKugXJdH/c" +
                                                              "S6e+W15x9Ohf9czk5rWZP/9K1KOkrAoN0ielqxceePdk93k4ojQPklqoAFhB" +
                                                              "lHHbJ1Vw53EjQVplc6AASwQpMlUGSYOlykcsNpiOk5novRTv74RdHHO2Fnvx" +
                                                              "CMxJb9lFXYWLA6jdJ5ixDWFQZDnIv15PyfWhmxYtXQ8weD3FrZxdrntS2v7l" +
                                                              "tu+d6KzZARFYoo5ffL1ppYop13+j6OXgdhvg/gO/EDz/xgc3HTvwDRVvzLld" +
                                                              "W1K8XoNDgj1Wk4wP6bpL2/Rb3Y6hy9h8vYD9nIRWO70+VMS/L4n5vyk+sfnW" +
                                                              "fwEhPo95XRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w3t//zWffPbb+bHv/wJ53BbSPCMAAA==");
}
