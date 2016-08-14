package org.apache.batik.dom.svg;
public class SVGOMAnimatedBoolean extends org.apache.batik.dom.svg.AbstractSVGAnimatedValue implements org.w3c.dom.svg.SVGAnimatedBoolean {
    protected boolean defaultValue;
    protected boolean valid;
    protected boolean baseVal;
    protected boolean animVal;
    protected boolean changing;
    public SVGOMAnimatedBoolean(org.apache.batik.dom.svg.AbstractElement elt,
                                java.lang.String ns,
                                java.lang.String ln,
                                boolean val) { super(elt, ns, ln);
                                               defaultValue = val; }
    public boolean getBaseVal() { if (!valid) { update(); }
                                  return baseVal; }
    protected void update() { org.w3c.dom.Attr attr = element.getAttributeNodeNS(
                                                                namespaceURI,
                                                                localName);
                              if (attr == null) { baseVal = defaultValue;
                              }
                              else {
                                  baseVal =
                                    attr.
                                      getValue(
                                        ).
                                      equals(
                                        "true");
                              }
                              valid = true; }
    public void setBaseVal(boolean baseVal) throws org.w3c.dom.DOMException {
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
                java.lang.String.
                  valueOf(
                    baseVal));
        }
        finally {
            changing =
              false;
        }
    }
    public boolean getAnimVal() { if (hasAnimVal) { return animVal;
                                  }
                                  if (!valid) { update(); }
                                  return baseVal; }
    public void setAnimatedValue(boolean animVal) { hasAnimVal = true;
                                                    this.animVal =
                                                      animVal;
                                                    fireAnimatedAttributeListeners(
                                                      ); }
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
              ((org.apache.batik.anim.values.AnimatableBooleanValue)
                 val).
                getValue(
                  );
        }
        fireAnimatedAttributeListeners(
          );
    }
    public org.apache.batik.anim.values.AnimatableValue getUnderlyingValue(org.apache.batik.dom.anim.AnimationTarget target) {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          getBaseVal(
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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae2wcxRmfOz/j2PEjT/JwEscB4iR3BEJL5CTgOE5ieo4t" +
       "O1itA7ns7c35NtnbXXZn7XMgLSAh0qqNAg0JLZA/UCgUAUEI1FYNKAi1QKGo" +
       "PAqlFKj6pFBaohZKoZR+38ze7d7e7Vmu6lra8Xr2+2a+7zffa2Z8/3ukyjJJ" +
       "K9VYhE0Y1Ir0aGxAMi2a7FYly9oFfXH5eIX0tz1v79wQJtUjZFZasvpkyaLb" +
       "FKomrRGyRNEsJmkytXZSmkSOAZNa1ByTmKJrI2SuYvVmDFWRFdanJykSDEtm" +
       "jDRLjJlKwma01xmAkSUxkCTKJYl2+T93xki9rBsTLvkCD3m35wtSZty5LEaa" +
       "YvukMSlqM0WNxhSLdWZNstrQ1YlRVWcRmmWRferFDgSXxy4ugqDtocYPPzmS" +
       "buIQzJY0TWdcPWuQWro6RpMx0uj29qg0Y11NvkwqYmSmh5iR9lhu0ihMGoVJ" +
       "c9q6VCB9A9XsTLfO1WG5kaoNGQViZHnhIIZkShlnmAEuM4xQyxzdOTNouyyv" +
       "rdCySMVbV0ePHt/T9HAFaRwhjYo2hOLIIASDSUYAUJpJUNPqSiZpcoQ0a7DY" +
       "Q9RUJFU54Kx0i6WMahKzYflzsGCnbVCTz+liBesIupm2zHQzr16KG5TzV1VK" +
       "lUZB13murkLDbdgPCtYpIJiZksDuHJbK/YqWZGSpnyOvY/sXgABYazKUpfX8" +
       "VJWaBB2kRZiIKmmj0SEwPW0USKt0MECTkYWBgyLWhiTvl0ZpHC3SRzcgPgHV" +
       "DA4EsjAy10/GR4JVWuhbJc/6vLdz4+FrtB1amIRA5iSVVZR/JjC1+pgGaYqa" +
       "FPxAMNZ3xI5J8x47FCYEiOf6iAXN9649e9ma1jNPC5pFJWj6E/uozOLyycSs" +
       "FxZ3r9pQgWLUGrql4OIXaM69bMD50pk1IMLMy4+IHyO5j2cGf/yl6+6j74ZJ" +
       "XS+plnXVzoAdNct6xlBUam6nGjUlRpO9ZAbVkt38ey+pgfeYolHR259KWZT1" +
       "kkqVd1Xr/G+AKAVDIER18K5oKT33bkgszd+zBiGkBh6y0nnwZwU2jOyNpvUM" +
       "jUqypCmaHh0wddTfikLESQC26WgCrH5/1NJtE0wwqpujUQnsIE2dD0k9E7XG" +
       "wJSGt/f3dWlKBvXYousqlbQIWprxf5gji3rOHg+FYAkW+wOACr6zQ1eT1IzL" +
       "R+0tPWcfjD8rjAsdwkGIkbUwbURMG+HTRmDaCEwbKTUtCYX4bHNwerHYsFT7" +
       "wekh6tavGrrq8r2H2irAyozxSsAZSdsKsk+3Gxly4Twun2ppOLD8zXVPhkll" +
       "jLRIMrMlFZNJlzkKYUre73hyfQLykpselnnSA+Y1U5dpEqJTUJpwRqnVx6iJ" +
       "/YzM8YyQS17optHg1FFSfnLmtvHrh79yQZiECzMCTlkFwQzZBzCO5+N1uz8S" +
       "lBq38aa3Pzx17KDuxoSCFJPLjEWcqEOb3x788MTljmXSo/HHDrZz2GdAzGYS" +
       "+BiEw1b/HAUhpzMXvlGXWlA4pZsZScVPOYzrWNrUx90ebqjN/H0OmMVM9MGl" +
       "8Gx3nJL/xq/zDGznC8NGO/NpwdPDpiHjzl88/6eLONy5TNLoKQGGKOv0RC8c" +
       "rIXHqWbXbHeZlALdG7cNfPPW927azW0WKFaUmrAd226IWrCEAPONT1/92ltv" +
       "nnw57No5g/RtJ6AKyuaVxH5SV0ZJmO1cVx6IfipEB7Sa9is0sE8lpUgJlaJj" +
       "/atx5bpH/3y4SdiBCj05M1oz+QBu/zlbyHXP7vlHKx8mJGP2dTFzyURIn+2O" +
       "3GWa0gTKkb3+xSXfekq6E5IDBGRLOUB5jK3kGFRyzRcwcn5gROlKgKWCe2MB" +
       "RZ3KBxia+FSYmSMiM2P/JYWhA91zyAb+AVPJwKqOOdnvwoG98qH2gd+JzHZO" +
       "CQZBN/fe6DeGX933HLeZWgwk2I8TNXjCBAQcj8E2ibX8DH5C8PwbH1xD7BBZ" +
       "pKXbSWXL8rnMMLIg+aoyxWehAtGDLW/tv+PtB4QC/lzvI6aHjn7ts8jho8IQ" +
       "REG0oqgm8fKIokiog80mlG55uVk4x7Y/njr4w3sP3iSkailM7z1QvT7wyqfP" +
       "RW779TMlMkpNQuQKjt569I58LphTuD5Cqa1fbTx9pKViG4ShXlJra8rVNu1N" +
       "ekeFms6yE54Fc4st3uFVDxeHkVAHrAPvvpiLcUFeGMKFIfxbDJuVljcaFy6X" +
       "p2yPy0defr9h+P3Hz3KVC+t+b/DpkwyBdzM25yLe8/3ZcodkpYFu/ZmdVzap" +
       "Zz6BEUdgRBmqAKvfhIydLQhVDnVVzS+feHLe3hcqSHgbqVN1KblN4lGfzIBw" +
       "S600JPuscellItqM10LTxFUlRcoXdaDHLy0dS3oyBuPef+D78x/ZeM+JN3nY" +
       "M8QYizg/bjIXF6R5vnt0M819L33+5/fcfGxcmFMZ5/DxLfi4X03c8JuPiiDn" +
       "ibWEv/j4R6L337Gwe/O7nN/NcMjdni2umaBKcHkvvC/zQbit+kdhUjNCmmRn" +
       "tzYsqTbmjRHYoVi5LRzs6Aq+F+42RGndmc/gi/0O65nWn1u9PlDJCuzdTaez" +
       "cnVth5NpOvzpNET4yx7Och5vO7BZm8teMwxTZyAlTfoSWEOZYRmpT9KUZKtC" +
       "a+zbKBI3tn3YxMVwA4FW+cVCLRbDE3WmiwZoIcA5DxupWNggbkaqxmAzmywl" +
       "ZXqKUrbCs96ZZ32AlFpZKYO4MXpCbgI8S8mp/xdybnBm2hAgp11WziBukBM2" +
       "NZkAOcemKCeWgpudmTYHyHltWTmDuBmpldPghE5R4Rf0YBlBs+6Eq/MT8p9q" +
       "4mwjc7+9RZ0bFUO5+qYNC6Lxi2Tvzsq3r8IssSTocIBn5JM3HD2R7L97XdjJ" +
       "XVvBaZlurFXpGFU9s9bhSAWxuI8fh7iB7Y1Zt/z2B+2jW6ay28K+1kn2U/j3" +
       "UoiqHcHh3S/KUze8s3DX5vTeKWyclvpQ8g/53b77n9l+rnxLmJ/9iIhbdGZU" +
       "yNRZGGfrTMpsUyusLlbkTWA2rvgSeAYdExj0W6xrZD7ryW8JgljL1Cq3lvl2" +
       "HJsjjNSNUrbFEz5cQ795Mo8sXx1gx7DB+79e6LqL4LnS0ebKSYAo4bdBrGWU" +
       "vavMt5PY3AmbMdtIgndxmkux2SSU6makckxXki4wJ6YBGL69XQ2P4minTN1C" +
       "glh9yjulNV9tPurDpQlyoWiBNxRt7e/rycrUQI/jzI9g8wDYkVVgR99x4Xpw" +
       "GuDKO1TW0Tk7dbiCWMvYyhNlvj2JzWnhUF2ePOcC8dh02c06eG50tLlx6kAE" +
       "sU5mN8+XQeNn2DwD+3RLoIF5K1/xeYzjJ9MVZDrhOewodngSTEoEmSDW8q6y" +
       "pugYAyueyBgqjjtDxAHPVzgSXIrXy2D4FjavMDJbRKZyML46DTBimCZr4bnd" +
       "weL2qZtWEGt5GFeVPA3iUAoQIPjskkxwNC7CO2Uw/As2v4fNFRBfocE2WZ2A" +
       "ui4P4a9cCP8wnd55l4PDXVOHMIjVp3SYCxLOQdjkDdp4b4r9l/Dp/lkGrk+x" +
       "+TuUiXgTy+/1fIb2wXSh1AXPKUfVU1NHKYjVp2sFF6QC//yYI5KHJVQbDEuo" +
       "DpsK2LsiLH38mNSPTKhyupC5CJ7Tjnqnp45MEGtp+3GR4YrPLQPKfGyaGNTg" +
       "AMogzUBN78ek+X+BSZaROaXulfD8aUHRFba4dpUfPNFYO//EFa/yDUv+arQe" +
       "th4pW1W9JySe92rDpCmFY1ovzksMrulSpwgqdUDNSAW0KHuoVVC3gbylqIES" +
       "Wi/lSsdPvZSMVPHfXrrzoapw6aBUFS9ektUwOpDg6xojFwTWTXqq7tlVipwk" +
       "YvAi75Jwv5872UrmWbz3IbiZ4/+LkNt42eK/EeLyqROX77zm7OfuFvcxsiod" +
       "OICjzIyRGnE1xAfFzdvywNFyY1XvWPXJrIdmrMxtc5uFwK5rLPJEuGHIMwaa" +
       "zkLfZYXVnr+zeO3kxsd/eqj6xTAJ7SYhCTLw7uKzuaxhw655d6z4eBo2uvwW" +
       "pXPVtyc2r0n99XV++knEcfbiYPq4/PI9V710y4KTrWEys5dUwQ6eZvmh4dYJ" +
       "bZDKY+YIaVCsniyICKMoklpw9j0LrVzCuxCOiwNnQ74Xb/MYaSs++i++A61T" +
       "9XFqbtFtjXt0A2y03R6xMr79r20YPga3x1lKbHdgs4lX3GCw8VifYeRuRio+" +
       "MrjD95YqOHu5kfNtWS++XfYfbhVaDKckAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VQm/RPT4Yfy+3R2pqHIPKAumzz22p34S");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("8Hs7akAJytOUNw4t5zRlVLlQ/j9N930gdp7QgdRp/3Ka5BnQOyApXiH/yCxr" +
       "r3ux69RKYe/Pz51K9Q91rLTEB19vxo6bnL6SVywPyrvlR6l8vL9d/pz6yktj" +
       "5kdea35+fyVQteU8L3q5TFUu7W8nHi8Hnrxjb0d9XRw+/a37f+nK+46WLvfv" +
       "GT7R91O8PXH7+3d9x4/KG3P5rz38K9//91/64/I4/f8C9aGE+PQvAAA=");
}
