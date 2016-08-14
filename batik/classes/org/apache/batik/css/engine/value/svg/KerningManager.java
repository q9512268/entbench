package org.apache.batik.css.engine.value.svg;
public class KerningManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_KERNING_PROPERTY;
    }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_KERNING_VALUE; }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException { switch (lu.
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
                                                              CSS_AUTO_VALUE)) {
                                                        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                                                                 AUTO_VALUE;
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
                  CSS_AUTO_VALUE)) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     AUTO_VALUE;
        }
        throw createInvalidIdentifierDOMException(
                value);
    }
    protected int getOrientation() { return HORIZONTAL_ORIENTATION;
    }
    public KerningManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TRFikgVzR0mDeMW3xv8Anoi/z04fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "s4HmeDGA9Qw6q990POH3J+egI15X2sf3sez91TniPXl5KStettN6Vv1p6LFB" +
       "nmRCDM2wZTOncz+AFmMqlw59VIJJJ1TxpbWJ52SeC9Ps3DoyYfZ3mdouVmVl" +
       "ecdFXq9d0RoeOOQVzv4tx8QoByZ9b//Wu778zpd8A07RALkuX9HgzJwYkQmz" +
       "PPhXH333i5718DffngcgGH2kt/0+/s2M6vBqEmdFOyvIQ1HvzEQV8pWdkgNA" +
       "53FCXebSXtUyOd+wYGiNDpI89KHbvrF5/7c/tkvgzprhGWD1rQ//2k/23/Hw" +
       "3om0+SVPyFxP4uxS55zpZx9o2EfuudooOUbnnx976I9/76G37Li67XQSSMJv" +
       "nI/9zf98ef+93/ziZTKNa03naUwsuOVbvUrQJw5/VHGuTeJxkow1G+8m61kJ" +
       "LRCO1nRivWIw5f6sW9q2R0y3Ceg0WHRm1Nia0XNcKSuUikcU7iaNDUNYG9kb" +
       "CV63T3gdPjYbJNZ3CM/1LIl3ya63GYi84w4nJdk1OlK3ZrqbraFLS2YIhr0o" +
       "VVNVA3rZ9MLaoFBWykGCLxo4ns6jcjUoLQsVY1zi5+5s7XH1CLOCGgfYsKCb" +
       "ASYseK+IT8ojpkbUpY2PgjBq4OsxPwZVzvVktyxLI6s8cUQymqETQfVAqNRW" +
       "XhomJtUnVS6ZJFZb6oZdmF9aMi7bvCmOk4m0TDYDfcU3in1PhIlC1R1VLVYF" +
       "WLNHbKm4Jif9kRVMp3plOat40oxW8EaPC0CvHM4WI8WjmarGCFKx3k5KRiAk" +
       "UyDpCpiafmpQlDjmFnajT/escbUHSmt/OluVmonGjYatqhMW7UalsvEqItnm" +
       "hamoVmgaVbdW0u6WhgN2aBdVEBRNv1feyAUeWxvzisFZbmsairrXFiZ07E1C" +
       "wMdTuZgSDau0SfW2rZgSHw691WgQh+3RJvGwWbx2N5rTbva9sMviM2LudwoC" +
       "MCWZpblepQ6MJCkvJG1RGBc5WZyY04ifjsfjPtUecBgxpAOaDoBqYkbMtwtu" +
       "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" +
       "1BsDuc53ZpjK9puCu2nxfaPu26LPTdNSx11Y2+1aAZHYK85CyQBlZzjtcrUl" +
       "T6vtARCnnM20QckvCeVqDX4IiV6h0eiDdnXSIMoLtW2SzZHcSPVCnRmi60i0" +
       "1mzaca1yP61tu2y4Nv11LBfLtQJXwyVjhGomUFp6Zx7RGBDbhdW0XUrr1WVv" +
       "Xi2Ghku4tjyiWxt2UtsuJc8v6hFek4ZjZsLVTB7XZopH6II0dDpDv+SGVODo" +
       "G6NpxIwtLipTvKpUZb46jyq1uimjwrrbsXxR3aorqjMaYpVEDflhwtZKgSHP" +
       "nXWzVu5OSDOwNvEkbPprf0SlFMOUYRJpUSLfMeCiDoOU1VbpSTmJ6oTtGGiK" +
       "VTT4Vfuq7HP3NU9tx+HWfHPl6ExsbeJZR/cpfGnvuu7JivuONpTz3/mrbCif" +
       "2HRDst2DF13pqCvfOfjgmx9+ZMl+qLh3sFk5AciNwHF/xlQj1TxB6kZI6eVX" +
       "3iWh85O+4020z7/5X+8Uf1Z/3VM4JnjxGT7PkvwI/egXuy9VfmMPueZoS+0J" +
       "Z5CnkR44vZF2k6+CELrCqe20Fx1p9vZDbRYONFu4/Fb9Za3gXG4Fu7m/yl6w" +
       "f5W+fHfbAsjtRtC3ddU3gLrkfCc/1c0R+BMGIwHk+oXjmKpsHxuT/WTbNieH" +
       "zBvWR9LfljXec3hicfj/zEr/pqv0/XJWvAEgF1YqOJSaOZi77rGIDz0NEfMJ" +
       "fhl8GgciNp55EX/9Kn3vzIq3AuQ5RkDYhiWD7JziUNasLzqW821PV8774HOA" +
       "u/t/ZuV831X6fjsrHgbIbUZ2iyHfqbyClO9+GlJeyBrvgk/3QMruMy/lh67S" +
       "9+Gs+J3TBnt0DHjGVa8xDq6X5FL/7tOQOl8C7oYPcyA188xL/cmr9P1hVjy2" +
       "k7qtanJo7o4+Do8MXvbk59bH8Lk2PvF0tfFC+IwPtDF+ZrSxlwPsHQr1gkyo" +
       "uKzksgSysk+piaHI5tg2wCHMfVcTvCUIZF7LR/vTM6OdOziNP6B0x+FoS8fa" +
       "b7M0mSiqmy2eOfIXsuIzAHmW4qsyUHNlZk2fPtboZ5+uRu+Fj3GgUeOZ0eg1" +
       "B6eAl3GO6wLd8fPFL0+OPpfjf/XyOspev5gDfC0r/hKmWTs97M6nLqeNv3q6" +
       "i+LdOejulzwVbcBUyvUdoCpwIX9Sp/vWVfr+KSu+DpBboNOxvqHau2Qqa/3I" +
       "saDfeCqCJpDa6csj2en3HU+4vLa7cKV8/JELNzz/kfHf5vcnji5F3UghN2ih" +
       "aZ48rDxRP+/6qmbkEty4O7p087/vPYm3HF1vgYETljnv392hfh8g9zwpKjg4" +
       "TzyJ+G8HXnwFRICc31VO4vwQLtWXw4FswfIk5H8B5OJZSMhF/n8S7scAuekY" +
       "Dg66q5wE+QmkDkFg9RziHoYE9MnVRcE3oB/MZXLu9FfAkY3c9mQ2cuLD4SWn" +
       "0v389uNhah7u7j8+qDz2yIB5/Q9qH9rdT1FMOU0zKjdQyPW7qzI50Sy9v+eK" +
       "1A5pne/d/6NbPnHjfYefIrfsGD72sBO8vfjyF0BIywX5lY3008//5Cs//MjX" +
       "82Pj/wNPRBMrlioAAA==");
}
