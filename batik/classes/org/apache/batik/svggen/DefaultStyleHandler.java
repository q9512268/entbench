package org.apache.batik.svggen;
public class DefaultStyleHandler implements org.apache.batik.svggen.StyleHandler, org.apache.batik.util.SVGConstants {
    static java.util.Map ignoreAttributes = new java.util.HashMap();
    static { java.util.Set textAttributes = new java.util.HashSet();
             textAttributes.add(SVG_FONT_SIZE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_FAMILY_ATTRIBUTE);
             textAttributes.add(SVG_FONT_STYLE_ATTRIBUTE);
             textAttributes.add(SVG_FONT_WEIGHT_ATTRIBUTE);
             ignoreAttributes.put(SVG_RECT_TAG, textAttributes);
             ignoreAttributes.put(SVG_CIRCLE_TAG, textAttributes);
             ignoreAttributes.put(SVG_ELLIPSE_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_POLYGON_TAG, textAttributes);
             ignoreAttributes.put(SVG_LINE_TAG, textAttributes);
             ignoreAttributes.put(SVG_PATH_TAG, textAttributes); }
    public void setStyle(org.w3c.dom.Element element, java.util.Map styleMap,
                         org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        java.lang.String tagName =
          element.
          getTagName(
            );
        java.util.Iterator iter =
          styleMap.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String styleName =
              (java.lang.String)
                iter.
                next(
                  );
            if (element.
                  getAttributeNS(
                    null,
                    styleName).
                  length(
                    ) ==
                  0) {
                if (appliesTo(
                      styleName,
                      tagName)) {
                    element.
                      setAttributeNS(
                        null,
                        styleName,
                        (java.lang.String)
                          styleMap.
                          get(
                            styleName));
                }
            }
        }
    }
    protected boolean appliesTo(java.lang.String styleName, java.lang.String tagName) {
        java.util.Set s =
          (java.util.Set)
            ignoreAttributes.
            get(
              tagName);
        if (s ==
              null) {
            return true;
        }
        else {
            return !s.
              contains(
                styleName);
        }
    }
    public DefaultStyleHandler() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lzgsdaHj5jTDzvYwLE/ZnUN++o07f3fyh4dHRdBvyc1svnEz/7FJie79098z" +
       "/MI5LUtC4hsfCZ15ZFbbqg/5eIdc2OjmVGawAoJ2xt52OvFpoKnohQAqjqAa" +
       "yUqR+7GSZOc6AmmhaefNkEZ7+r0pnshnWtPkOdtPbK5p/bTmBEmoM2lWr/Rh" +
       "sJy5cBl8IQuDIT8G8xCvdPEhi3jZwoqlaXYxeQ6eSuvksCibQifcdCAH1wyS" +
       "vj2ZgII5DgpYLOtNRk26GY/y5HJA2nZLTUPz3Z80CRg0ZpF1ZaH7n/lVJHJL" +
       "jSSEm7Ip9mafp06WSG8nzr8vBtyUZYCQqz8V+n7/m7te5fRewsJ5n21YV7CG" +
       "sO8KGzVpw1QxO9TCd9kyzGVBu9v+xxwLhsHVSk7AbSDUJydIjF3t2B6sHO5L" +
       "1c9JynOAHac9Nqys/uiun9wjzDo/x9l15J/++uULx8bPnREBhJkXsrtcl9HM" +
       "GzBLGxZOkfo4APl03VcnP3ivf3vAovwqVvQLCM+kqNKhMyBP1rgjTXt5adqa" +
       "7oWJ0Lz2u9W/PlCX3wE5SScqSary7iTpjHlPY7GZjLpw49y5nBNaw4pgioVm" +
       "ivIWA2eKtIOVd7Fig1jsymycncpxVln1Vuec8r+iKeKPi6YDtmmacyXb7izb" +
       "Fm7KEOY27e1fl342YPCZk+s+ye/CJ/YeOh7b9OhyAaI67x2tXU0mHv/9v14N" +
       "Hr38cparQSnV9FsVMkIUz148ZAOI7eZXbYe/36k6+N7TzYNrvkg+z9oab5Cx" +
       "s99zYROLc4PUv5QX9/5lVt+qoZ1fIDWf6zOnX+VPu8+8vG6RdDDA3xVEYMl4" +
       "j/AOavUCuMwgNGmoXsgu8AaVVfBtsIDV5Q8qDpgXsWIwM3Z05Rjqy9vyuUfz" +
       "bcBNY4AbvV0KxrRE0GIp1rXFFsh5VwRMWjmvZljPSXyV90+RKO5lxShFJcBT" +
       "HP7mlAlKjwEUSuURiylCe+reHX7kyuNWRMu47niEycSh730e3H9IYFy8IS3I" +
       "eMZxjxHvSG4yMd0UnGUWPqLjz+f2PHNqzz6bGTWKCkY0OeYwT2oK5vkvskXW" +
       "sEbn7Wba7Q2sby582y23b58CMVlykFLd0CjENBLzpSGVU+j0eTbgJboaHgNY" +
       "FhYUD22s/Qhfx+EpMPEwK34AK8K6rsjE7NPM7BmIz8G39eyUJpp73rft3mf5" +
       "jP37tqs+QVFxVNMUglV/SGI/oynHUQf+H45KwaHK8o7Ckv6ZGY+14oFROnu8" +
       "umTG8S1vcvpMPwJWABHGk4riTktd9SLdIHGZ771CJKki5p2iaEaOQ8tyT17h" +
       "iz8p5B8D1/nlKSrk/91yZykqc+RAlai4RX5GUT6IsOqTehZciOw8leeKLchl" +
       "//ob2T89xH23Z7TBH8ttwCR7rOzo3PGujfdd+8qj4m1BUvD4ONNSDgmFeMFI" +
       "R4D5ObXZuorWt1yveqJ0oQ03z9uGe20cBQAu/g4wy3fZNpvTd+63Tqx87rWJ" +
       "oteBoLaiPAyo2Zp5j0npSQi9W8OZiRNES/4K0Nry8NiqpfGP3uY3RZRxP/TL" +
       "D0gXT25/4+DME40BVN6JCoHBSIpfsNaOqZuJNGJEUKVstqdgiaBFxoonK6ti" +
       "4MTsdHO7WOasTLeyRydIYzKJNvOpDm7Vo8RYoyXVmJXXlTstnld8O4gmdd03" +
       "wGlx3R+wOP3MG4DHgXC3rtsvNmWv6fyYRrNTAStf4FVWnP8PxYmVfEgbAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UTb/HzUCWgf5JAAA");
}
