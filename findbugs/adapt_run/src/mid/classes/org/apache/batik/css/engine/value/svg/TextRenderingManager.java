package org.apache.batik.css.engine.value.svg;
public class TextRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_GEOMETRICPRECISION_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          GEOMETRICPRECISION_VALUE);
             values.put(org.apache.batik.util.CSSConstants.
                          CSS_OPTIMIZELEGIBILITY_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                          OPTIMIZELEGIBILITY_VALUE);
    }
    public boolean isInheritedProperty() {
        return true;
    }
    public boolean isAnimatableProperty() {
        return true;
    }
    public boolean isAdditiveProperty() {
        return false;
    }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT;
    }
    public java.lang.String getPropertyName() {
        return org.apache.batik.util.CSSConstants.
                 CSS_TEXT_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextRenderingManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "QUqsNarGQUOgJ8sK0nZ103ecWiFpx066Zqx5WZoxujGkI3hKzsqGQDbLhahe" +
       "suqpj4shxzemTLcgCoUZijZYMIMiCQub9RhtFmoNdqZ4IWha0qhym53BiTYj" +
       "YCYlx4TWmDmFjjqJ3HJiT5Z8uJoMJ+RwmrLLplrBUc5tWQOvz08ZSgns2rBV" +
       "I1Wb4/BOrwZ7JstVys2iUfODgSYXkTlCi6ql2nGpXuK9mqMjMNP3dZVH+lqE" +
       "j13BDPy+YdZHVnkdloZr4DWcIrVxIy01JaMkoUO109sELZFZ9mtsb8ghE7DE" +
       "G426Zc8GpmYEUzowcVKwigY51boW2RmNQrs0Go3WhKC70zIIv0YTm6QXhjBY" +
       "IM6qIJCmOEnSgj/HRI9psS0tHpcXs1VtvhDUotJEYoGtlGG9USsGoxId2jI9" +
       "F1d6McSDWn0sO06IUN1lIxhNWqkUJuu4yrBUUuqV4jUnjGdMi6JV3U78ZncK" +
       "3kTLcnE1VNCkwKI0RRjTutT0BG3kCTGhFmpTlVGDqGp2aEaNSxEgnFQVE4sk" +
       "QBBGqBSxKOuiY5oUseZ0tcf5iw49rbNe3O0p1AgBMWEfGRuNSaOBFMJRPJ8R" +
       "BYzx2iFJz6sFsEwxZroSxwZYL5VSk22vWvOaglTlJaKE1WljZpcaKUfJjqG0" +
       "gwJfjKcNkmyaXo0oZvzN8xo7UpBI58teuzrkkjE9GLSMSTfuqhKCtCYUp4xl" +
       "8NoGHqdEQ3vYq48bpj+dNOa2Jy0XFoJU5smovG7EU3I4a/vKMuIELVX9lY8g" +
       "uCV2MUlRJrw7RYflyA4Tw6t5IVKfDFg5Vp0Oas29iCNnm3xsKhhh8Uofc+VN" +
       "By+SXGU07TOgR1EhbFOTh7BsDmTgYtwgHTENp96qVLqFmC+X7XInrFQkeVar" +
       "oWLDLFALruqVK70gEGwqFEe0Ia02DYuZ923OKc0HzZQVI1hXCMddwPNGr+a0" +
       "or4GXpN8KY4lXq+JHaOSLlce7lErOCDsblNSK+nK0mkUleNOLyXtJjt0TFce" +
       "TInRbN6zFg2k6CIgBl97VhHhp6EwY2VLFzvT8kSXangtSSdiBcSoY7i4qZdb" +
       "otH29HAy1pQVXYoCxh5VhQoTi07owlhMrZPxwKub8WJEjhijSw/o9rKG2RNF" +
       "jKQBqrRH3YlTpO0yP0yTHmeIXqNrskS6EqeLEV4tDXir6ooYiXbVhYEi6oxH" +
       "DGPqVuDUmGhMRcPcGh6UxwpKNKPiRPdGaB2sYHfBJzMnFW0ilc1ldV4fob5S" +
       "HAllvy2jgtmjW/3hZixVAovpo1W9LtWC2sJszLE158w7a3roF7SotZo2Vm2b" +
       "IHl5ZBHjWchsFhtBbQf1cdXSB0hFKdbaA24uxA0FoE036+4i6aTySuwHDmKp" +
       "5a4b+l46nLsyL1XX62J90u2niuc1x5uBOFcjL0DofrduoPMFbaE2KVQEtBUp" +
       "BltPizr4cn1j9klrvrBdhZvyDZT9k7+pW88qei/ga3pbdW+WPLC/WZX/nbrK" +
       "RvihzUIo2yF49ZUO9PLdgY+/48mn9O4nSid3N1nVBDqTBOHrXWNhuIe6Og16" +
       "eu2Vd0K4/DzzYPPvy+/41zsHb7IfewHHG3cf0/N4l3/APf0V4jXa+05C1+xv" +
       "BV5y0npU6OGjG4BnIyNJI39wZBvw1fuWvSWz2GvAU9+1bP3yRwyX9YITuRds" +
       "5/4qe9hvvUrdr2XJMoFucWIKfINFTmLoQhTkZ9e5wKOHHOaxBDo9CQLXUP0D" +
       "Z1o939bM4SHzguQo+gd3N0L3NkRfYvTvvkrdb2XJOxPoFU7c9B1PTbLDhz34" +
       "Wd3bDnA+8WJxPgAefBcn/tLj/NBV6j6SJe9LoJud7CJDvlV3BZTvfxEoz2WF" +
       "d4GH3UXJvvQof/cqdZ/IkqcS6JxlJHvw9s/2jvnxNc7uDZMc9e+8CNQ3Z4X3" +
       "gmewi3rw0qP+3FXqPp8lnzqKmt/ln94BxE+/CIj5K+Ae8Dy6C/HRlx7il65S" +
       "90yW/PEWYtsw1dTdHtnsHQs8+PzHGgftc2v8yYuwxq1Z4f3g0Xatob301vja" +
       "Veq+niVfTqAbgTUo3fCT7OBge5+IPED47AtBuAIUeLk7Cdmh6h2X3KDa3vrR" +
       "Pv3Uuetvf0r62/xYfv9mzhkWut5MXffwGdih/KkwMkwnx3FmeyIW5v/+OoEe" +
       "+LnuToClC9IcwTe3ot9KoHufVzTZPdI5LPgPCfTKqwgm0Klt5rDMt4GlLicD" +
       "1ALp4Zb/lEDnj7cEWuT/D7f7XgKdPWgHBt1mDjf5PugdNMmyPwj3nL78/OY6" +
       "8I7d+VydOBqo7XvLzc/nLYdiu/uPRGT5Nby96CndXsS7qH3mKZp/y3O1T2yv" +
       "PmiuutlkvVzPQqe3tzD2I7B7r9jbXl+nyId+euNnzzywFy3euFX4YJEd0u3u" +
       "y98twD3w7ZvdBtj80e2ff8PvPfXt/PTu/wAfvLTlHykAAA==");
}
