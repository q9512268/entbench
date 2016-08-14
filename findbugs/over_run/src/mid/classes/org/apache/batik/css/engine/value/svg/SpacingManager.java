package org.apache.batik.css.engine.value.svg;
public class SpacingManager extends org.apache.batik.css.engine.value.LengthManager {
    protected java.lang.String property;
    public SpacingManager(java.lang.String prop) { super();
                                                   property = prop; }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_SPACING_VALUE; }
    public java.lang.String getPropertyName() { return property; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() { return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                                NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        switch (lu.
                  getLexicalUnitType(
                    )) {
            case org.w3c.css.sac.LexicalUnit.
                   SAC_INHERIT:
                return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                         INHERIT_VALUE;
            case org.w3c.css.sac.LexicalUnit.
                   SAC_IDENT:
                if (lu.
                      getStringValue(
                        ).
                      equalsIgnoreCase(
                        org.apache.batik.util.CSSConstants.
                          CSS_NORMAL_VALUE)) {
                    return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                             NORMAL_VALUE;
                }
                throw createInvalidIdentifierDOMException(
                        lu.
                          getStringValue(
                            ));
        }
        return super.
          createValue(
            lu,
            engine);
    }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (type !=
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_IDENT) {
            throw createInvalidStringTypeDOMException(
                    type);
        }
        if (value.
              equalsIgnoreCase(
                org.apache.batik.util.CSSConstants.
                  CSS_NORMAL_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     NORMAL_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mgghodkCz/8HmoJFXV8gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p+7R9+mi+NEEesQsblyUW453kfLHXoWUN4rGYgOePpKSfu2l/Ol79H22KD6T" +
       "QDd0NTkW7+RY8oId32ceXYUppX7hVUj9SNH4FHj4I6n5117qX7lH378rihfP" +
       "Sz05ij/VUxE/9ypELJeAJ8Hz/iMR3//ai/iFe/T9VlH8xl7EgaqJqbM/YDo+" +
       "hHznK18VOIUvtfGbr1YbbwGPdKQN6bXRxkEJcHAs1LcWQm3qcilLLMqHlJqb" +
       "sujMPTM5hnnmXoL3OW5Y1srRvnRhtAvnuI8dj6b47uGAoYc5+EArFs8S+ctF" +
       "8XsJ9Do5UsVELZVZNP32qUa/+Go1+jR4siONZq+NRu/b50p38v8HYsOPypP1" +
       "Mjn6oxL/L+6so+L1j0uAvy6KPwNp1l4P+xPvO2njz19tQCm87SNH2vjIN6uN" +
       "4St629/do++/F8XfJNBDwNuYyFS9fRZVtP7sqYRf/WYkzAG18xd1ilsHj73s" +
       "EuH+4pv8Sy/cuPrmF+b/qbyrcnI57RoFXdVSxzl7FnymfjmIVM0sJbi2PxkO" +
       "yr9/eAU3OblKBBYFUJa8/4896j8l0FOviJocHXqeRfzGkfveBTGBLu8rZ3H+" +
       "GaQhd8IBbIHyDGRxOHzzIiTgovw/C3d/Al0/hQOD7itnQa4A6gCkqF4NjmMB" +
       "/MrqosBbYhzNZX7pfPp/YiOPvJKNnPliePu5PL+8hXqck6f7e6i35c+/QE4+" +
       "+PXWz+zvAsmOuNsVVK5S0JX9taSTvP6pu1I7pnUZf9c3Hvrla88cf4M8tGf4" +
       "1LXO8Pa2O1+8GbpBUl6V2f3Gm//9e37uhb8sz7b/L4fY05oeLAAA");
}
