package org.apache.batik.css.engine.value.svg;
public class WritingModeManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LR_VALUE, org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                           LR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_LR_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          LR_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RL_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          RL_TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_TB_RL_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          TB_RL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_WRITING_MODE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 LR_TB_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public WritingModeManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TTXDt93UevvEDVaItYhRThWZO82ak06DbYIYk6mSanjtzWpFsxqy7PHDW7ZH" +
       "LZuaBx82lcITt0ch1iI6P1Nk7lnW/Mywx3oSwynJKJsz9rjt5lWjRc/N9NQt" +
       "m6meTbH6MGHqmpi4mQqxFjHFC0XmzrPmeYqmgpmCUSJTuFYTo8LbbKn+q4mr" +
       "nobQlfsmxm6BM3Pe7o33ZuGJ49XlM47f8yf+LpN9E66C0iOWkiT7JcXW96ka" +
       "iYlclyrjyqLyXxcoavuvXu4gZkDLtXjVYL1EUfNNWeHmMpjFh8n4B4pmFWGE" +
       "m4vRsfNchhyXjwfEgtZOeQUOsZsSpOC/7XRXKaq06GBTo2MneQtWBxLWfVvN" +
       "nIgVNzeXhRDTn2mP83qTRUz9zRBjuxHNdxSK/B9AmToqZfwLCIrW4xs33Xv9" +
       "zpPGA5kg4ZERtspkqJ6MZ7jstaG54GqZtXxdi25MfbKiLVPYOR7o7LJxIEMC" +
       "4Y9Zja4XI701+3D0+olVZ1856LsEJekO5MFQnu/IvZqn1RTcaXaE8tWJcKni" +
       "j1ntle/suvDJG546/gKCjMqyqRhHWDh89kpvTFW/70UVQVQKdStJ83eD9cPy" +
       "FiIMao6y0xdRUnL2f0VT2RnDLBlwy5gGnZIdZW+nFLXkFte578mVkjJEtHVs" +
       "dbbMFNdFK6Wq9llu2UEjczNLAxzDoW5VNZ8USzq55VWVh5KPeP7+D4sylkTl" +
       "HQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
