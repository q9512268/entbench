package org.apache.batik.dom.svg;
public class SVGOMFETurbulenceElement extends org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes implements org.w3c.dom.svg.SVGFETurbulenceElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMFilterPrimitiveStandardAttributes.
                 xmlTraitInformation);
             t.put(null, SVG_BASE_FREQUENCY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER_OPTIONAL_NUMBER));
             t.put(null, SVG_NUM_OCTAVES_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_INTEGER));
             t.put(null, SVG_SEED_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_STITCH_TILES_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_TYPE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      STITCH_TILES_VALUES =
      { "",
    SVG_STITCH_VALUE,
    SVG_NO_STITCH_VALUE };
    protected static final java.lang.String[]
      TYPE_VALUES =
      { "",
    SVG_FRACTAL_NOISE_VALUE,
    SVG_TURBULENCE_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedInteger
      numOctaves;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      seed;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      stitchTiles;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      type;
    protected SVGOMFETurbulenceElement() {
        super(
          );
    }
    public SVGOMFETurbulenceElement(java.lang.String prefix,
                                    org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        numOctaves =
          createLiveAnimatedInteger(
            null,
            SVG_NUM_OCTAVES_ATTRIBUTE,
            1);
        seed =
          createLiveAnimatedNumber(
            null,
            SVG_SEED_ATTRIBUTE,
            0.0F);
        stitchTiles =
          createLiveAnimatedEnumeration(
            null,
            SVG_STITCH_TILES_ATTRIBUTE,
            STITCH_TILES_VALUES,
            (short)
              2);
        type =
          createLiveAnimatedEnumeration(
            null,
            SVG_TYPE_ATTRIBUTE,
            TYPE_VALUES,
            (short)
              2);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_TURBULENCE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyX() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyX is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getBaseFrequencyY() {
        throw new java.lang.UnsupportedOperationException(
          "SVGFETurbulenceElement.getBaseFrequencyY is not implemented");
    }
    public org.w3c.dom.svg.SVGAnimatedInteger getNumOctaves() {
        return numOctaves;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSeed() {
        return seed;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getStitchTiles() {
        return stitchTiles;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getType() {
        return type;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFETurbulenceElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Q9OslwATHuGS1zTc4qFd+GPv/wGlwhb7DSoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7e6zk1nnf3JW0klaPXUm2pMqWvJJWjuWRL2c4Dw4jyxaH" +
       "5HCGQ857OMOxlTXf5PA5fAw5dFU7BlK7DWAbjfwIkAhJ4aSuq1hp0aQBChcq" +
       "6jYJHARI4D7SInHaBmhS14D9R5KiTpoecuY+d/eu1hLQC/Bcznl+v+/7zu98" +
       "hzx87XuFOwK/UPRca6NZbrivJOH+0qrthxtPCfZppjYQ/ECRcUsIggnIuyo9" +
       "9asX/+KHn9cvnSucXxQeEhzHDYXQcJ1gpASutVZkpnDxKJe0FDsIC5eYpbAW" +
       "oCg0LIgxgvB5pnDPsaZh4QpzIAIERICACFAuAoQd1QKN7lOcyMazFoITBqvC" +
       "3ynsMYXznpSJFxaePNmJJ/iCvetmkCMAPdyV/eYAqLxx4hcuH2LfYr4G8BeK" +
       "0Ctf+olL/+y2wsVF4aLhjDNxJCBECAZZFO61FVtU/ACTZUVeFB5wFEUeK74h" +
       "WEaay70oPBgYmiOEka8cKinLjDzFz8c80ty9UobNj6TQ9Q/hqYZiyQe/7lAt" +
       "QQNYHz7CukXYyvIBwAsGEMxXBUk5aHK7aThyWHjP6RaHGK90QQXQ9E5bCXX3" +
       "cKjbHQFkFB7c2s4SHA0ah77haKDqHW4ERgkLj92w00zXniCZgqZcDQuPnq43" +
       "2BaBWnfnisiahIV3nq6W9wSs9NgpKx2zz/d6H/zsx522cy6XWVYkK5P/LtDo" +
       "iVONRoqq+IojKduG976f+aLw8Dc+c65QAJXfearyts6/+Ns/ePG5J974rW2d" +
       "d12nTl9cKlJ4VfqKeP/vvRt/Fr0tE+Muzw2MzPgnkOfuP9iVPJ94YOY9fNhj" +
       "Vrh/UPjG6N/xn/ya8t1zhQudwnnJtSIb+NEDkmt7hqX4lOIovhAqcqdwt+LI" +
       "eF7eKdwJ7hnDUba5fVUNlLBTuN3Ks867+W+gIhV0kanoTnBvOKp7cO8JoZ7f" +
       "J16hULgTXIVnwPVjhe1fdl8ICz6ku7YCCZLgGI4LDXw3w58Z1JEFKFQCcC+D" +
       "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" +
       "WsU0WHp2lLSxmoWTAhV22HQTWu6mjSzW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NgdJAQiBAkRaJuxQD2jYZORknc6niRn6C7ZGFfutSTSZ4akHwWhZggLE5pMi" +
       "RK18CylTtMLzlX5VW3bkWr3IzKPhtIJIC2MaLnoGLkP1Rlt2VgjvDbihVJqz" +
       "/SLeIQTLp9fahtdb/LrKkEWrGlsl1g+mUBpjTleEiEEMddDRxubKVt/1pflQ" +
       "8kI6FTx/1iMUbgwtYJHk0y5lxul03Bii/QDQ4KQdUeNyOpGqq5ZcpAZrKKas" +
       "WBcRYuxiGPZC/sTrm7f2SOyB/Enf4SHDH+EZX3LsPcXhw9D8L3sR8Mzu/plT" +
       "D0OPvX/fO3ha+97saW1ckY4/pL3O6avsFdbjNzpqmL+++sqnXnlV7v9S+dzu" +
       "ncYqLNwdut4HLGWtWMdGvie/T08+wi1l+HZSx6cf4R7p5cznt2e8X/mDM8r+" +
       "S5Z8Oyy8y3CMMH/5pWCWxRhrBQtD3xCjcPdo+/SDyrVryEfW+ve3chLilAru" +
       "zTKL4PrETgWfuBUVhIU7Pd9YC6FyUz382Rll382S/x4WHj3Sw0klZOV/eAT4" +
       "T94C4AezzCfA9bkd4M/dqs1fuCnWPz+j7C+z5Pth4V5NCRlXEqze7hUhdoTv" +
       "B28B3+NZZlb+pR2+L73t+Pb2zijLieevANEAfE0hUFq+sorAbN7MD6b9k9eZ" +
       "9idfMR1p4q/fDk38wk4Tv/D2a+LiGWUPZMmF62iCzwruOAS5d89bAJl5cj5/" +
       "v7oD+dW3H+S7zijLXmDvPRwW7gMge9e8G33qDFPvXogeqeGRt2rrK+B6faeG" +
       "199+NTx7RlkxS64AOgRqGCuKfMrCz7wFaE9lmdki9es7aL/+9kOrnVGWBQh7" +
       "pbBwfwbt2leu11vEr/Oe9UgX5beqi2fB9Y2dLr7x9usCP6OMzJIPbc28O8ix" +
       "d3Qkce/DbwHaQ1lmdjLqmzto37xVaDeNRfb6Z5QNs4QG0Bwl7rny4fmcS8ft" +
       "e1iQw+2+BbhPZpkouL61g/uttx/uS2eUXc2SOQg5MkueOjB4eAhwfoSVv6XT" +
       "pqDfG31LkJ2KfvSaz5u2n+RIX3/14l2PvDr9j9szdwefzdzNFO5SI8s6fhDz" +
       "2P15z1dUI9fG3dtjmflhtz0VSHGj8xBh4TaQZoLvKdvaRlh4x/Vqg5ogPV7T" +
       "2jnF8Zph4Y78//F6bli4cFQvLJzf3hyv4oPeQZXsNvAOPO7DN/k+w7BCxT88" +
       "wzYOs69NfPkoWEy24cmjxx0vDyYevJkND5scP8SfnTbLv1o7OBkWbb9buyq9" +
       "/ird+/gP6r+0/YhAsoQ0zXq5iyncuf2eIe80O1325A17O+jrfPvZH97/q3c/" +
       "c7CFuX8r8NEkOCbbe65/XJ+0vTA/YJ/+xiP//IP/6NU/yo9P/D+QyEfXTjgA" +
       "AA==");
}
