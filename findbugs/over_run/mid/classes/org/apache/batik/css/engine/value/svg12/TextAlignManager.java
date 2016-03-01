package org.apache.batik.css.engine.value.svg12;
public class TextAlignManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.SVG12CSSConstants.CSS_START_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          START_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.CSS_MIDDLE_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          MIDDLE_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_END_VALUE, org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                                           END_VALUE);
             values.put(org.apache.batik.util.SVG12CSSConstants.
                          CSS_FULL_VALUE,
                        org.apache.batik.css.engine.value.svg12.SVG12ValueConstants.
                          FULL_VALUE); }
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
        return org.apache.batik.util.SVG12CSSConstants.
                 CSS_TEXT_ALIGN_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 INHERIT_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public TextAlignManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5x0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VXCj4aixcdsTcR+FHHB7Sl90zRDDFpJGTcK6P+S3ea1A8zjeRoyiiyOv2Ik7" +
       "2hu1mVo/x3208DrgxeWwDJ0yA4HckrBJFiTprXpDjnc7XYwRa52+libTViuk" +
       "N7MRCJJSl0z5WbER1HY24lxcRZROZ75P13G93YtWyFzQolbMRlqC0xHHba2G" +
       "EMz8/cba7oRc266wXl92V6M2r1rktD6ApxbJDJryAGbrSEAunGU3jzcRv7DE" +
       "np4laRA2tXYT7o8bBrXujbilnCKCTRA7QmV9tj3tdCLwPeb0LDSykkgIZz6T" +
       "G6GlzxN+4AirlrABnjPdtdOa3QGvEEmW2Gwi0Ga9S20nYjMsuIbcNlbIwiAx" +
       "mdjxFN9Y4xKyXyxmy3nmRkmbX6fugGiq+3lOq0RtnAmL5RaTEkTtZSCc6nk4" +
       "TNOw1eMxQZ61izr4eP3gB8vPWuO17Sw8Vm2inJ77OW63rOBewxf1oeqZMnnv" +
       "6YZV9XftHpvh5zYMoXKX4F13O86rdgg+/7EXX9LYLzSuHm+0Kin0EJikH3D1" +
       "re6e6+o66OkDd98NoavTzLMNwK9+7L8+ufiQ9ZHXcMTx7kt6Xu7yn9Nf/K3J" +
       "+9Sfvgrdd7od+Ipz1otCz1/cBHw41tMs9hcXtgLfdWrZJ0qLvQ88P3hs2R+8" +
       "8zHDHb3gSuUFh7m/xz72j9+j7ifKJE+hJ+yE8C09tlNdm8VBdXJdCfzwOYf5" +
       "SApdXweBC2jxzJmKV9ueOT9kVZBeRP9+8KDH6NE3Hv0n71H3j8vkp1LozXaC" +
       "+ranpOUBxAn8su6jZzg//npxvhc8+DFO/I3H+bP3qPu5MvnpFHrcLq8xVNt1" +
       "d0H5M68D5Y2y8CnwsMco2Tce5S/do+4LZfJSCt0wQXB9DO/0fO+SH99nH98v" +
       "qVD/4utA/XhZ+Ax4xGPU4huP+lfvUfdrZfKli6iZY/7hziB++XVArF4BT4Pn" +
       "9jHE2288xN+8R93LZfKvDhBHuqFk7uHY5uRo4P2vfrRx1r6yxr9+HdZ4S1n4" +
       "LHiMY2sYb7w1vn6Put8pk6+m0KPAGoSm+2l5eHC4TYSfIfzaa0FYpNDNy3cS" +
       "ykPVt7/i7tThvo/65ZduPPi2l5b/sTqWP72T8xAFPWhkrnv+DOxc/loY64Zd" +
       "YXjocCIWVv9+/281g9XNiRR6oPpfIfjGQfwPU+iZVxVPj491zgv+lxR6xz0E" +
       "U+jaIXNe5pvgZXEnGcAoID3f8k+ATS+3BFpU/8+3+7MUevisHRj0kDnf5M9B" +
       "76BJmf12eOL0zVc32Zl3HM9pceVioHbqLY+/mreci+2evRCRVZfwTqKn7HAN" +
       "77b6lZemzI99t/OFw/UH1VX2+7KXByno+uEmxmkE9sxdezvp6xr+3Pce/ZWH" +
       "3nsSLT56UPhskZ3T7d13vl8w9sK0uhGw/5dv+7Uf+qcvfbM6wft/da5iZx0p" +
       "AAA=");
}
