package org.apache.batik.dom.svg;
public class SVGOMFESpotLightElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGFESpotLightElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_Z_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_X_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Y_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_POINTS_AT_Z_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_SPECULAR_EXPONENT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             t.put(null, SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_NUMBER));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      z;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtX;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtY;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      pointsAtZ;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      specularExponent;
    protected org.apache.batik.dom.svg.SVGOMAnimatedNumber
      limitingConeAngle;
    protected SVGOMFESpotLightElement() {
        super(
          );
    }
    public SVGOMFESpotLightElement(java.lang.String prefix,
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
        x =
          createLiveAnimatedNumber(
            null,
            SVG_X_ATTRIBUTE,
            0.0F);
        y =
          createLiveAnimatedNumber(
            null,
            SVG_Y_ATTRIBUTE,
            0.0F);
        z =
          createLiveAnimatedNumber(
            null,
            SVG_Z_ATTRIBUTE,
            0.0F);
        pointsAtX =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_X_ATTRIBUTE,
            0.0F);
        pointsAtY =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Y_ATTRIBUTE,
            0.0F);
        pointsAtZ =
          createLiveAnimatedNumber(
            null,
            SVG_POINTS_AT_Z_ATTRIBUTE,
            0.0F);
        specularExponent =
          createLiveAnimatedNumber(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE,
            1.0F);
        limitingConeAngle =
          createLiveAnimatedNumber(
            null,
            SVG_LIMITING_CONE_ANGLE_ATTRIBUTE,
            0.0F);
    }
    public java.lang.String getLocalName() {
        return SVG_FE_SPOT_LIGHT_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getZ() {
        return z;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtX() {
        return pointsAtX;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtY() {
        return pointsAtY;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getPointsAtZ() {
        return pointsAtZ;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getSpecularExponent() {
        return specularExponent;
    }
    public org.w3c.dom.svg.SVGAnimatedNumber getLimitingConeAngle() {
        return limitingConeAngle;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMFESpotLightElement(
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
       "/MHWhz960vQ3b93pYaa7dt/5deSu3abvmeepiwqONN0y5pkqV73RNM7X8BeC" +
       "6z94IS58gL9QXfZYB3sX5E72NC3L/TdALT7E6r8+Nfmrn07eEbbs9Bgj5WOq" +
       "lHTCwP7S9wP88b7cnNYhaQlct1tzenuAOxTZUVVpujQGoDyF6LSAHgM84ZUA" +
       "2mvYHGKk1fGSfBdB+rOObV46Z9s0I2k+XA9ZSB46w1LpyTdCbYBoANAjAbTf" +
       "Y/MGI3UjlMVUUZD7rYW/1gH+5jkDn4ekhXA9amn/aOnA/UQDwH0QQDuOzVFY" +
       "AAB8k52fFhbJT/m1vWOVY1NnlX0WtH2lW8VPNAD5iQDa37H5yLQKLxo/dAB/" +
       "PHWAD1haHygdsJ9oAKivAminsfmHCXjYA/jzqQHcAddBS+uDpQP2E/UHFaoI" +
       "oFVhQ8wFP+jeyDjAQ6GpA/68pf3zpQP3Ew0A1xRAa8GmLh+4x8VD9VMH/GVL" +
       "+5dLB+4nGgBuXgBtATat+cA9rh46b2qAYxl42NL+cOnA/UQDwHUE0JZg085I" +
       "CwAfKrJrc+FfPDX4l8N1xAJxpHT8fqIBGC8NoHFkyxiZgbm92CbQZYDl52yA" +
       "FiTNgeuoheLoGQxQZB/gJxoAsjuA1oPNCqgpFTreDzszO803utN8jsDtcOU5" +
       "2wHzG7kCruMWmOOl28FPNADrQADt29isg0oXHMF7Xps7g407RrjuLN4KMDLb" +
       "50U1vqNpLfhwxvzYQzywp6F69p7r/8hfluY+yKiLkepURpbdB+Cu+0pNpymJ" +
       "27HOPA7XOM5NANHvoJaRMmhR+9B3TO7NsDKKcQMntG7OmyyXcXMyUsF/3XwC" +
       "I7UOHyOV5o2bBfaCZcCCt1Sz/bH4y53c6bJ9LGIeo8y17O7UKTPPNF05EfeL" +
       "WNzz8q+e7IODjPndU1x8as+6/ltOXva4+SJYlIXt/Ex2WoxUme+kead4+LDQ" +
       "tze7r8q1HaenP12z2N5yNpkKO0tgrqsYuxp2gBq6yxzPK1KjPfem9L29K158" +
       "fVfl27C73kzQ4i2bC1+3ZLWMThZsjrlPdFzfzvG3t121H25588ujoWb+XpDg" +
       "KRVu7QMk4uK9Lx4bTGnaj8OkppdUSPgWg78LWjmhrKfimN5LqjOKtC1De5Pg" +
       "pQk1o+Q+kJqOvi3gKz1uGcug9bmn+CEBI22F5wSFH1fUyuo41a/F3rGbes9x" +
       "TUbT3NQsfjhUBBXMzfJHvrr1B+8OwNrLU9zdW5WRSeROftzfX5l9Y9uIzXNZ" +
       "nEVw7nisT9Os04ryX/BZ1TSMEaEJvg7GTW7kYCTUqWn/BXYSp35HKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yLE3JLtd2UeLX/eAwX3mxuaZzt26Iwv36P/uO+rH/v1fXqdAhWE+w5s5VX+G" +
       "fOUXHqN+4vtF/SMLmdd+Ir1+DQMu8FHd8pfd/3HxqUv/8iJ05wy6ou3965Hi" +
       "JLndmQGfMjpwuoEPfiL/pH+4c4aeO1wB3nnaOh/r9rRtPlo7wXNeOn+++5Q5" +
       "fjiX8gdAeHavO8+eVsYLUPEgnK2PF/PH9wKljAovfq+UPwKfCyD83zzkDeYJ" +
       "O818kNr7XO8+dLoCsLQ/lLqOFCqLmPWKJeVwpIAevvc6PSwmatMH82DLerqR" +
       "GrqU27qjeVMomvh6itY9uSrlzllzL4bmDcTwUzeYloUYCtnKwOtID6C/73yP" +
       "hfAWbi4BPslfeU7B/9CbgM/u4bM3gG+8Ifjb/EE5Bcd8E3D4PRz+BnCcNwQn" +
       "OwuOe5Nw3gfCcA9neAM40RuBcznwwRthRMSTs2DFbwLWZA9rcgNY2U3Bmp4F" +
       "6yNvAtaH9rA+dANYH70pWLOzYH3sJmFVQFD3sNQbwPrkG4F1JQoMLXGUsJUG" +
       "vgdWsbPQ/d2bRFcFwdqjs26A7uffCLoHnIULvFcP+J2eQXjWzrKdhvfp14VX" +
       "NJdeAD7DHeVr+LVS/vuzZwO4LX/8YB5JoLS58BTnAM0jtqNdPbDaIyOMgGm+" +
       "ajt4nk2cwiS/YUxgLb/vyPHgfM967uf+46d/9+ef/h5YcDvQHet8MQTr7DHv" +
       "ZGcl/85XPvP42176458rPHAgOeGzrSvP562+/LrM8ugfHdB6LKc1LF5pOSWK" +
       "e4XHbOg5s/P9DCEsRme93/VAXnzwe8tf+NNf2e1onHYqThU2PvnS3/vRtU+9" +
       "dPHYPtLT123lHK+z20sqQN+7l3AIPXleL0UN+j9/7cXf+McvfmKH6sGTuyIt" +
       "L3F/5d/81e9e+9wff+uM1+zbHTAab3pg4wcebVcjljj49EaKUt5o6GAMJ5Uq" +
       "rq+z7mYrLtlprakszKiTyE5tTWyyKJ4jY0srJYTMh/1Mh0vzKOtLrrou9+Mh" +
       "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" +
       "BP73I17/61bw+uqe11dvOa8Ll8/Je1se");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("3b7jNTvJ68Idb5XXMyB8fc/r67ee18Pn5D2SR1d2k1E4frB8jN8Dt4Lfb+75" +
       "/eat5/fkOXlP59E7T/I7pZcXHr8V/L6x5/eNW8/v/efkIXn03pP8TuvnM2+V" +
       "X+4gvLrn9+qt59c4J++5PKrG0EOA3/CMM/NjNLG3ShMF4ff3NH//1tNsnZPH" +
       "5NHzMfT2fE086/D9GE/iLfB8KE98DITv7Hl+52Z5vq6/d0E8J2+YRxxwmjxj" +
       "w/u6cbA8Xjm+PB5mFHR7b4FuvmBADRD+ZE/3T2493RfOycuvTFyYAbcODOvp" +
       "22WHN8YmR1x/8qauJsbQIze4d57foH30uv/B7P67oX315fvveuRl+Q+Lq9eH" +
       "/6+4zEF3mYnjHL+0d+z5UhAa5qIQxuXdFb6gYDgH5G50xyyGbgNxjvuCtSu9" +
       "BBp+VmlQEsTHS3p7nTheMobuKL6Pl1vF0N1H5WLo0u7heJEYtA6K5I9JcKBw" +
       "Z98tPbwYd/AuuXv3fPS4dhWuzIOvN1CHVY5f685fIYs/MR287iW7vzG9oH3t" +
       "5Q7/kddqX9xdK9ccJSsund3FQXfubrgXjeavjE/esLWDti61n/nhfb96+T0H" +
       "r7f37QAfafoxbO86+wJ3yw3i4sp19k8f+fUPfOnl7xaXXf4f7QHEn102AAA=");
}
