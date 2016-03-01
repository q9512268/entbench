package org.apache.batik.svggen;
public class SVGLine extends org.apache.batik.svggen.SVGGraphicObjectConverter {
    public SVGLine(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.w3c.dom.Element toSVG(java.awt.geom.Line2D line) {
        org.w3c.dom.Element svgLine =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_LINE_TAG);
        svgLine.
          setAttributeNS(
            null,
            SVG_X1_ATTRIBUTE,
            doubleString(
              line.
                getX1(
                  )));
        svgLine.
          setAttributeNS(
            null,
            SVG_Y1_ATTRIBUTE,
            doubleString(
              line.
                getY1(
                  )));
        svgLine.
          setAttributeNS(
            null,
            SVG_X2_ATTRIBUTE,
            doubleString(
              line.
                getX2(
                  )));
        svgLine.
          setAttributeNS(
            null,
            SVG_Y2_ATTRIBUTE,
            doubleString(
              line.
                getY2(
                  )));
        return svgLine;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wc1RW+u35vnPhFbDchTmI2kWLDTt1AKXLa4pg8HNbx" +
                                                              "yg4RdVrWd2fu7k48O3Mzc9dem6YhSIWoPxAigaaV4l9BqCgFVBW1f4iMqAoI" +
                                                              "KEqKWh4qbdU/fUUif0ir9HXuvTM7s7O7pv3TlXZ2fO+559xzzne+c68vXUNN" +
                                                              "jo0GKTY1nGBLlDiJFH9PYdsh2riBHecIjKbV7/z+7Kkbv2w7HUXNs2hDHjuT" +
                                                              "KnbIfp0YmjOLtuimw7CpEucwIRpfkbKJQ+wFzHTLnEUbdWeiQA1d1dmkpREu" +
                                                              "cBTbSdSFGbP1TJGRCVcBQ1uTYjeK2I0yFhYYTaJ21aJL/oJNFQvGA3NctuDb" +
                                                              "cxjqTB7HC1gpMt1QkrrDRks2GqaWsZQzLJYgJZY4btzlBuJQ8q6qMAy+1PHp" +
                                                              "zSfznSIMPdg0LSZcdKaJYxkLREuiDn90n0EKzgn0LdSQROsCwgzFk55RBYwq" +
                                                              "YNTz15eC3a8nZrEwbgl3mKepmap8Qwxtr1RCsY0LrpqU2DNoaGWu72IxeLut" +
                                                              "7K2X7pCLTw8r5777UOePGlDHLOrQzRm+HRU2wcDILASUFDLEdsY0jWizqMuE" +
                                                              "hM8QW8eGvuxmu9vRcyZmRYCAFxY+WKTEFjb9WEEmwTe7qDLLLruXFaBy/2rK" +
                                                              "GjgHvvb6vkoP9/NxcDCmw8bsLAbsuUsa53VTEziqXFH2MX4/CMDSlgJheats" +
                                                              "qtHEMIC6JUQMbOaUGQCfmQPRJgsgaAus1VHKY02xOo9zJM1Qf1guJadAqk0E" +
                                                              "gi9haGNYTGiCLG0KZSmQn2uH9zzxsHnQjKII7FkjqsH3vw4WDYQWTZMssQnU" +
                                                              "gVzYPpR8Bve+ciaKEAhvDAlLmZ988/q9tw+sviFlNteQmcocJypLqxczG67c" +
                                                              "Or7rnga+jVZqOTpPfoXnospS7sxoiQLT9JY18smEN7k6/fOvPfI8+UsUxSZQ" +
                                                              "s2oZxQLgqEu1ClQ3iH2AmMTGjGgTqI2Y2riYn0At8J7UTSJHp7JZh7AJ1GiI" +
                                                              "oWZL/A0hyoIKHqIYvOtm1vLeKWZ58V6iCKEW+KJ2+G5D8iN+GZpT8laBKFjF" +
                                                              "pm5aSsq2uP88oYJziAPvGsxSS8kA/ufvGEncrThW0QZAKpadUzCgIk/kpOIs" +
                                                              "5HLEVGaOHuAbT3Ck0f+DjRL3s2cxEoEU3BomAANq56BlaMROq+eKe/ddfyH9" +
                                                              "lgQXLwg3QlBPYCghDSWEoYQ0lHANoUhE6L+FG5TpheF5KHPg2fZdM984NHdm" +
                                                              "sAFwRRcbIbJcdGdV3xn3+cAj8bR66cr0jXffiT0fRVGgjAz0HZ/84xXkL3uX" +
                                                              "balEA/ap1wY8KlTqE3/NfaDV84unj576vNhHkM+5wiagIr48xVm4bCIeruNa" +
                                                              "ejse/+OnLz5z0vIruqJBeH2taiUnisFwNsPOp9Whbfjl9Csn41HUCOwDjMsw" +
                                                              "pAvIbCBso4IwRj3y5b60gsNZyy5gg095jBljedta9EcEzLrE+y2Q4nW8grrh" +
                                                              "G3dLSvzy2V7Kn30SlhwzIS8EuX95hl54/xd/2i3C7fWBjkADnyFsNMA9XFm3" +
                                                              "YJkuH4JHbEJA7jfnU2efvvb4MYE/kLitlsE4f44D50AKIczffuPEB7/9+OJ7" +
                                                              "UR+zDJpvMQPnmFLZST6OYms4yXHu7we4y4Da5qiJP2ACKvWsjjMG4UXyj44d" +
                                                              "Iy//9YlOiQMDRjwY3f7ZCvzxz+1Fj7z10I0BoSai8t7px8wXk4Tc42ses228" +
                                                              "xPdROn11y/dexxeA2oFOHX2ZCIaMuHXLN9XP0PAafOAStmW7xwaR6DvFSkU8" +
                                                              "d/MgCX1IzH2JP+JOsGAqazJwLkqrT773yfqjn1y+LjysPFgF8TGJ6aiEJH/s" +
                                                              "KIH6vjA5HcROHuTuXD389U5j9SZonAWNKhCrM2UDJZYq0ORKN7V8+OprvXNX" +
                                                              "GlB0P4oZFtb2Y1GYqA0qgjh5YNMS/eq9EhCLrfDoFK6iKud5DrbWzu6+AmUi" +
                                                              "H8s/7fvxnudWPhZAlMjb7C4Xf+zkj6EyIsWnOdzJgois0GCjLfUOG+KgdPHR" +
                                                              "cyva1LMj8kjQXdnA98H59Ie/+ufbifO/e7NGz2hjFr3DIAvECNjkzL+9ivkn" +
                                                              "xVnMZ627r95o+Oip/vZq0ueaBupQ+lB9Sg8beP3RP2868pX83P/A5ltDgQqr" +
                                                              "/MHkpTcP7FSfiorjpCTyqmNo5aLRYMjAqE3g3Gxyt/jIegHfwXJqe3jK+uE7" +
                                                              "7KZ2uDaj1kBFmafqLQ1VZ6jaZVfHiyyRI1aBFw/5wn3C2pE1yvpB/phiqIlZ" +
                                                              "wAqerh7OHIu71YQGmvgdibiXm3v4IyVBvee/Kx8+MFZiqMU9hfB66q+64shj" +
                                                              "ufrCSkdr38oDvxadsHx0boceki0aRiANwZQ0U5tkdeFOu2QTKn4wQ311KBDa" +
                                                              "hHwR+52T8nAl6QzLQ2TEb1Aux1DMlwNV8iUocpyhBhDhr/PUi+rIWnxsY5rX" +
                                                              "VXl2B05egPYP3Bap5hKRgo2flYIAedxWUXHiDupVR1HeQtPqiyuHDj98/YvP" +
                                                              "yk4Ot9flZXFngSuYPFSUK2x7XW2eruaDu25ueKltR9SFWJfcsI/7zQH8jQGC" +
                                                              "KYfEplCbc+LlbvfBxT2X3znTfBXo6xiKQFZ7jgVugDJk0CuLUP7HkkHaCvwn" +
                                                              "Q3Tg0dgf5t7924eRbsHTLtENrLUirZ69/FEqS+n3o6htAjUB25LSLFxpnfuW" +
                                                              "zGmiLkBHaS2a+okimYDbcnPGKprl6+oGjl/M76ciMm5A15dH+UmQocGqi2iN" +
                                                              "0zG0sEVi7+XaBeuEOKlIaXC2xK9xNbyC3Ixc+Pupx96fgvqq2HhQW4tTzJTp" +
                                                              "LXgb9vmuU5LWv+ETge+/+JenlA/IS1n3uHsz3Fa+GlJaknMN6eQkpa5sy88E" +
                                                              "DCgVRHFaKD7JH6dKXIKhyBCl/wGJqyydBhMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OroeAAA=");
}
