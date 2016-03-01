package org.apache.batik.dom.svg;
public class SVGOMAnimatedEnumeration extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedEnumeration {
    protected java.lang.String[] values;
    protected short defaultValue;
    protected boolean valid;
    protected short baseVal;
    protected short animVal;
    protected boolean changing;
    public SVGOMAnimatedEnumeration(org.apache.batik.dom.svg.AbstractElement elt,
                                    java.lang.String ns,
                                    java.lang.String ln,
                                    java.lang.String[] val,
                                    short def) { super(elt, ns, ln);
                                                 values = val;
                                                 defaultValue = def;
    }
    public short getBaseVal() { if (!valid) { update(); }
                                return baseVal; }
    public java.lang.String getBaseValAsString() { if (!valid) { update(
                                                                   );
                                                   }
                                                   return values[baseVal];
    }
    protected void update() { java.lang.String val = element.getAttributeNS(
                                                               namespaceURI,
                                                               localName);
                              if (val.length() == 0) { baseVal = defaultValue;
                              }
                              else {
                                  baseVal =
                                    getEnumerationNumber(
                                      val);
                              }
                              valid = true; }
    protected short getEnumerationNumber(java.lang.String s) { for (short i =
                                                                      0;
                                                                    i <
                                                                      values.
                                                                        length;
                                                                    i++) {
                                                                   if (s.
                                                                         equals(
                                                                           values[i])) {
                                                                       return i;
                                                                   }
                                                               }
                                                               return 0;
    }
    public void setBaseVal(short baseVal) throws org.w3c.dom.DOMException {
        if (baseVal >=
              0 &&
              baseVal <
              values.
                length) {
            try {
                this.
                  baseVal =
                  baseVal;
                valid =
                  true;
                changing =
                  true;
                element.
                  setAttributeNS(
                    namespaceURI,
                    localName,
                    values[baseVal]);
            }
            finally {
                changing =
                  false;
            }
        }
    }
    public short getAnimVal() { if (hasAnimVal) { return animVal;
                                }
                                if (!valid) { update(); }
                                return baseVal; }
    public short getCheckedVal() { if (hasAnimVal) { return animVal;
                                   }
                                   if (!valid) { update();
                                   }
                                   if (baseVal == 0) { throw new org.apache.batik.dom.svg.LiveAttributeException(
                                                         element,
                                                         localName,
                                                         org.apache.batik.dom.svg.LiveAttributeException.
                                                           ERR_ATTRIBUTE_MALFORMED,
                                                         getBaseValAsString(
                                                           ));
                                   }
                                   return baseVal;
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableStringValue(
          target,
          getBaseValAsString(
            ));
    }
    public void attrAdded(org.w3c.dom.Attr node,
                          java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    protected void updateAnimatedValue(org.apache.batik.anim.values.AnimatableValue val) {
        if (val ==
              null) {
            hasAnimVal =
              false;
        }
        else {
            hasAnimVal =
              true;
            this.
              animVal =
              getEnumerationNumber(
                ((org.apache.batik.anim.values.AnimatableStringValue)
                   val).
                  getString(
                    ));
            fireAnimatedAttributeListeners(
              );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public void attrModified(org.w3c.dom.Attr node,
                             java.lang.String oldv,
                             java.lang.String newv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public void attrRemoved(org.w3c.dom.Attr node,
                            java.lang.String oldv) {
        if (!changing) {
            valid =
              false;
        }
        fireBaseAttributeListeners(
          );
        if (!hasAnimVal) {
            fireAnimatedAttributeListeners(
              );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "y+EDy/xzqbDb73PwfeyB5bGn/nsHb7De");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("k71EX5Wl49tbTtnckr3GePSsnVz5W7jPfeyll+XBryAXdi9X+nHhztjz32cr" +
       "S8U+NvP2NTZ7KHUu+Y+CQ9hJLZx8zHqkl9OfsT691es5L3r+xTl1v58V/ywu" +
       "3KUpcePY0+wjQ7z6Wo8Gjw95At2DB3aQd+jktx7dvzqn7mtZ8eW48OAROjw6" +
       "vvnhEOVX3gTK+w5s6O5Qum8UZfCaKP/dOXXfyIo/jQuXEl8GjnvqM9+lt3ul" +
       "kqP9szeBNt9+8TQ4nt+hff6tQbt31KCUN/jOOZC/mxX/KS68DRj22DrdPlc/" +
       "4cB//ibA5luongHHizuwL741DnwM7HN5g786vcEBTz18nKeaA7qVSoqfM1PW" +
       "4H9mxX8Fizi6aRF/60gH/+1N6OCQoj6708Fn3/JFvHfxnLrLWVHYUhR+7N3W" +
       "Ibq9vTeLLnvh+/kdus+/9egeOKfuoay4Jy7cC9ARuiJZinwrwHvfBMDMcoX3" +
       "geN3dgB/5y114QMPfebU7WjZu8j9bUAFzsqKIUCZw370HJVkgX3v4S1rc66s" +
       "hPYaEPb08B06mO29t8yWz7R9z76bMNuMctQp1+OPvFkqQMDxpZ0ev/TW6PHE" +
       "fpsrx1c6HsfhISHuve8cnSFZ8TRIOkTQJd/SfzMD7D3zZgPcdXB8dQf9q28U" +
       "+mtR/t6TOYrr5yDMUs29alx4aBvlDrK0w/0Lx7DW3qyZcXB8fYf162+NmW87" +
       "zIn39nOTHtm1fQ7qblY04sI9mV0P3uyegPuaL29fC24ZHN/ewf32W+rVR3Bz" +
       "NJNzkHJZwcSFuzOkY8XxlrcAHbwRoCmImmdtVs923j58y/9ntv/5kL7w8v13" +
       "vPNl7k+3m1YP/pdxJ1W4Q01s+/j2xWPnl/xQUY1cFXdu9z/lu0X3PryL3adt" +
       "1I0Lt4EyE3zvQ9vWN0BGc1pr0BKUx1sudkxxvGVcuJh/H2+ngLh51A7kiNuT" +
       "4010MDpokp0a/gENnf0HgIPdxcfulPI1mG5DwcPH/SzXzoOvZbXDLsf3hWdb" +
       "0fI/Qh1s6ku2f4W6IX3x5R7z/Perv7Ldly7Z4maTjXIHVbi83SKfD5ptDHzi" +
       "zNEOxrrUeeYH9/36nU8d3LbdtxX4yOePyfb46ZvAW44f59u2N7/9zt/48c+/" +
       "/I18O8f/AzEgbrWhNgAA");
}
