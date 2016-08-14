package org.apache.batik.dom.svg;
public class SVGOMImageElement extends org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement implements org.w3c.dom.svg.SVGImageElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGURIReferenceGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      5);
             attributeInitializer.addAttribute(
                                    null,
                                    null,
                                    SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
                                    "xMidYMid meet");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "embed");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedPreserveAspectRatio
      preserveAspectRatio;
    protected SVGOMImageElement() { super(
                                      ); }
    public SVGOMImageElement(java.lang.String prefix,
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
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_IMAGE_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_IMAGE_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        preserveAspectRatio =
          createLiveAnimatedPreserveAspectRatio(
            );
    }
    public java.lang.String getLocalName() {
        return SVG_IMAGE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    public org.w3c.dom.svg.SVGAnimatedPreserveAspectRatio getPreserveAspectRatio() {
        return preserveAspectRatio;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMImageElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MhLt5qtK4o9Yyf8HlzpBSRsoAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hiTBPc+XlWlK99TOaEuKMxa3/KkUTbpbS5wIPjtuw+KQcqae6yyziZPITdnV" +
       "XdnVyDwZ1rf1yI3bSBNuV5IFVl/UsSGfbGyaoJvIVBr3at6st65uuVSY9urK" +
       "kFb7y92axETW4o15d1DBYCeHnTXuk5mUj9P5erITRrFNWlpISbRVE6V1p9NT" +
       "3PGktulygowodqc9IbviFhAzl5mx05Y3ojyWXHS7FJkOUSW5jTDvjOwKJY9B" +
       "aIRLWXXX606GrLapxYsI87IxaQ9m9CrPYhHLVFvjp1tFD4Ud2XQ4bDXprRyH" +
       "FAcUQnfiZNR0xL4fepPhzLZ7sm9v9HoGpuvNa8NFf0oIbXetdyoav47kvEt7" +
       "vfGsJ7MtWBKXyGyw5WhyaOdzN9o4a7W2sSrjzcry9VUvr66aeadR73r9noQw" +
       "6twTmEgBk4kLI6h3do6YBZNxX6Q22gIV1uNOvz2cOz0yHlUtT6LVyO044UIW" +
       "cyQQs3QkYrOqwNcXURsej2yfbEpIzx32ht56uaJGndWGFMhNc+LO10OUXFrz" +
       "geiNOhsC6es9Z+xX/cAfb9jhUGCYlJ+oIdlZj7ej5qDNd7qxNFbZUU7ZPOIO" +
       "bBqziXnQHm6Y4QRHIocLFKVPYj2dGGaiQPTaQ4kw52Katzer4dIn+wuvqa0N" +
       "ZIGnZGpvNZ9EZrnQQoQOuVyuFYXJqKFoLZudZrbxqS4yS4U+Mo5VtLuZh+x0" +
       "oFHNidcdbDerGiZg+HArLhu9cI1nWTUhaa0X5iY/2jhRpR4jplEx2MyR7Elv" +
       "uNQaw+Eo9k1imkWDrRKxPRvpxgkuD3PfYqvrfIBlAr0UKICImsi+6RKTWInm" +
       "kY8261tRXjTGDsU0VcvZ9fjO0Kzowy4WzwLR7rLdTRWh6bzFjxJ0uIqrxnqb" +
       "kxtRqk0cutZxdly1HcGGg0T5rltPm5OtjYr01s/oJVJBut2tMq2JW7VJD21h" +
       "Qfbq1c1mu6UZHzWzlr+qGJLf7+a62JXZ7jqgJ+ymbotOK2rh0zHdo4CGtbqp" +
       "L+qzCrIUaplfyUmL3Axw318tqPFoAjMhSW9m9fF0onMehW+H/nA9FmZIv9Ko" +
       "emM6bUhEqKwlfoE1NoqykQb9RrY1gDNcdiqj6TZce4qy3q0s0Bpl8XqtrZh4" +
       "Z417ksIO2IjbGBQVzlmvNhCWRAWPYdGuDWZqX7U77Gyw63Fye1J3115NY6Pq" +
       "0G4M+4Q40kek2hsQfHfXyHGn05NGCJXSS6df6RMsx0joLu8QRq0bCVg3mk+a" +
       "VaUVsp22P0wZp9oab3B1t6Jq8FCcBNqkx6Ueb1GG2sz0BZ+Tza1JyD1lxOKe" +
       "laXLDPXxmBcWY1HfrRmjq3BDYU1nYag50/6ENJrDiOp1unMYIzv0dkYMthQW" +
       "rQkRo9kl2kV0FyHa6z47N13GT2BW0lmkpdHxoDWmOoS9oUYCLHcItoKO2HpM" +
       "CEQfZVXdTBSiAZvhFEWEDa3LGDWWUmpTiwaOngoJb7HWTiSWu1YsVvQlitHS" +
       "eEuHhLi01lJzVV0zbbpas3uqqmzwJcpt3ZW8wRhqFzjDdbwO4miAJ6pB8LmB" +
       "z0f1gc9IgjWvxWOzxicqXg84RV54aBsNuI7cMFmi5nEJnOx4u95tYMJYRFtB" +
       "S0DHSOxR866TbBqK29H0KOK2M7wN+22gmnClXVf1+tDsSJ69E+Rwh3nqcjUb" +
       "URrRQg2zniSqQ1Z1o2uYQPfHlK8oAdEBaj8f57pDLbZCLe2lsgZMcU+btsiu" +
       "sWxgejjT+j1/KNg7B0QGlQ2sV6OpWw+cvO4KfXLmhxPERyWhz1Wa5nyDRNwC" +
       "rvAzq+HQJGPo806ejXbLejwGUqIRSWCQjEWbfryooA1hQIkIPiSUjaht18NK" +
       "L+0RaGLXBxhTURFfblYyrA+oXLf5eoWOTXlAVZjOrN0M6ubAmFaMRpRsVIbX" +
       "q+3UVvyKvZp368wyWaL1xKrOJ8BKGZg4hesLRIvd3ON7kox7QiggHVegNuym" +
       "hWJdT2xFcAvlXLkNp9Plhlaz8QxEdRt26bdcuT/UBp3tukeH+dxfLJwZh7nL" +
       "/oxfaLM+vTR7PQIPsrTCAi4QCzKVsVZDzpMgR5oVvB4rHW9Rlek8cLxp2CDc" +
       "Ec8TltWyAgJmm2kznEUbbt6U7UbQUdv1VTCTOniOZWQw7vJJxewifqgu2/HW" +
       "YpwoXMfz/qaaLBYkNfcIp2MvRhKprmqJBBxLA5/FEYpUjLS5lhAMzqQWyRJ2" +
       "Ta7lnMGi8qrbQqkZD3uNljkc2xkMozqZ1CdsrPrNeSXTaKINa2YKUy0TgSuk" +
       "0SFhvjolx2u00jPXa6yZMnmsz9u5aekcVdeLRRcJTTQ3CDgX+aCt9RM5rPVF" +
       "fpNvx0bshVNOGO3W7ZXTx1R97RK5xaH8wlXRBWvO+y6zBFaRkygEIwyC64ds" +
       "BZe3Joki/mgqx2QroOZZ5g7h2QyFidWgEjJcQ2yYu5FAV1QTJ9aakTjpqDdq" +
       "D6cTLVH1Xt9KBJ+XA1fGTaO9HXXaFYnRvRGTLWXWWzrqiqV2Y8S24zpRSWK0" +
       "A6th2+c6bdVodjRlbjd8CfYzY+jYdWISSsO1OLfF6XIiS3CzhXNkStQpvSr2" +
       "1w2b5JuB2t7Wd/UVgvRjIl36RKPZHewmVRy1M5bOM9zoJaJEzYdVb8LMKnWm" +
       "g+RgaxMIudEaSP505fMUhmMT2h50ab1fCYHsOj7j16IWQ3ujaGTxZJYpKaXt" +
       "1g2pPrH7BN8hojBUJVThV4HUUyouSYwaKNMds90AVTG/CeJ4a7VT0KyxRqUB" +
       "HiyqjYYiAMcAHOgy8GNJnyJiTlaDIWmtba8iL/B20UYCgeRmoQYTptrF52pr" +
       "mspqUnU82Kl6XL+3TslBmqYcF3p1n524A3hoDebLKGjrVhCJ6mg11zNyy9Wb" +
       "dJNVRVPDevwsY+q7Kp20W2iYwEJDm+BpM2FlNpPMCix4tYm4huvbJGuTWJLo" +
       "3eqUS+jZCJmptE7lQyaqbTXNarVZeBA0KtqCD5o5k1QqQ76G8Ft/0Od2gTnt" +
       "dpBBKxl3R02eMKeL1cyYY7Bb0aN5rjfT3Zhz8bCtDfy+uTWT6lirMWM+6SYc" +
       "NlrzdL+d7dAJi6Bbszb0axkIsEIQm6QizCx2rZmgBpSGimpSAea2Om/vKkyP" +
       "xDoxTLaJOtlXTckRK/YoWi5UCgSo3U6NcdkRPqwbHte0cXU+MkKOCbZJS6u2" +
       "CXTXzvnxEMMwTqim/IAPhiu0hxHoxlAidMtYTmM+mOQOYagLftbsoSnfGHPd" +
       "1roVKh2t1iDMsB5soyY268dmiEw0rh9NVhQzwXq7wOAw4DAi2NQHgZxyYU6t" +
       "if5MXK9WjXjphmbiYDo8yhcU297WcM0PkQzT+lzPGveqNdTfRGtpKLsYMtIp" +
       "YoCzaINrDsL5FuVG+WDRoqO2H/ItutOsun5KRuM4J7qtOsboSZy0OlkzdAa+" +
       "uMVZjagu0knV1QZbtjtChppvba01Bc/ktMbReMugqgJLdk0pXvHkRG61ialn" +
       "dtbEhKi3pW6FxfrNviyxwoBkXXM677fsZkWO2E7TXPgrzvVQZTduGtxm1w7w" +
       "jpp0+Em7o8T1CZ3FO8M0uV1Xc8UGBfw8Kkf2TuU8oZCZwzvJksHyOV/TN8IW" +
       "b1BJTY82/RROJh2BjZEeKkV+JnHLXSXgm84q9LoVa5umXjRdkv1cXcNxo4MP" +
       "J+mIG+jWoLUBhPiZxi3RSoCTNXa5qOYavaUtLsclzarVp5i9EbqStzHJhrFT" +
       "V/5yQdHtWbWD7kIgaSHB5+Q4QFuagvdnqtBvYTOrNsrxngSLjW112dgGOoeL" +
       "K77W0OqMosXVKsIOdlILSXnaE4AUA8JfbpsTobVoNIxobcw4uObb6WBcU/ts" +
       "t0twkhUuFww5iuERQoOuaS01bQSvIzMJ2I5oYFpMO/NSHasu9FoXbaw41HSU" +
       "jWfg+hBryE4/SZkUy93UtEKNRfqLEafCLYRv8A68QgS8adIgbpvXTSMMYi2b" +
       "KDptzVlFajebSpQ7+bwb17Fqh8pmglcZriaiiiBSWu03R6S4Xes2X5sL2MYn" +
       "Rdeu15pNJu+IqI7vpo5UiXtObbkQlqlmRk5ci+xU13UnN2t+hC1Um+5j47E4" +
       "mYTzdAE2oGTFQOSG5SOIp7mjUF2bPY5ebfiWv8vRsdzKYFTKqF3aTpoqvKuT" +
       "mslGbcEKqJSTbHHrcJv6YCdn3sLaLrJdkI/VWeQ6qKG7vN1EEaLJsPJyyKXR" +
       "JnHCpCpMB5RQ1RUac+tyfey6cb/d3o6jKdzGeoRMTsBuxxJWS5l0XGlRh/ub" +
       "yEO5uTsZuEIRLWVYZRr088pEc5AtMoKTeR3mqtNUi/WE19xF4o1b8nwdgxBC" +
       "qTTHyLrrY9bc7tlNvbXTBDJTpsFM0KoNnQ7mk6rc6/c3OL2KfX0qd8a+2lBr" +
       "tENv6GTbXHKVGddtzF1mjs7cDM6nK7UBfGyr3+rMVLA7SxaIspFpj14rYK9b" +
       "m4eZ3JrtQpmYsGmlW0WHShbrRK23GBCDxRT4cGWuUhPEcQxuXs/QjeS6zKau" +
       "mRlhEYbsD5pJIi9IQ5qSox3vVfMJ5s1yUQ1SmRjKI7K2A9H1bJkQIGxfjdLJ" +
       "aMUAyxcNG15byszWwM79jjgOPRzHy0OqL9zcKdZ95eHc0d2cH+JYbl/1ZJG9" +
       "/+gstPxcgA7ucRx+nzgLPfGe69zhsebjxbFmWtdOnmaevN5QnFw9eqOrOeWp" +
       "1ec/+tLLOvcF5PzBu7jPRdCdkec/axuJYZ+Y8i4w0jM3PqEblTeTjt9vfe2j" +
       "//WRyY+tPnwTlx4eP0Xn6SH/9uhLv0m+W/ur56Fbjt52XXNn6upOz139juti" +
       "YERx4E6uetP16NWn0VWQPnIggY+cPo0+lvGZR9FnvOr86hl1/7jIfjWC3m4d" +
       "vdDBbZuxEuPoVU9YdvwbJxTsb0bQrYln6cea9w9u5u1pWfDKEQvuLgorIH3s" +
       "gAUfuxkWRNDtfmAlSmS8Jh/++Rl1/7LIvhZBDx/z4WomFPW/fgz4628A8P1F" +
       "YXGL6rMHgD97szL/wGti/Z0z6v59kX0rgu5eGhHjaYrNHqgrfozvX70BfI8W" +
       "hU+C9LkDfJ978/H9lzPqfq/IvgN0FOBbHFqtJ69jta5+EXgM/j++GeC/eAD+" +
       "i28++P95Rt0fF9l/34OXiuc/OMb1P94o");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("rqdA+vIBri+/+bh+cOO6c+UQfxpBdwBc88NXkyewff+NYitc3ysH2F5507Gd" +
       "u+uMuuKNz7kLwAkCbIOjd5zH4M7d/gbAPVMUFv1+7QDcr7354B46o+5Hiuz+" +
       "CHoQgLvOq87D9XnljPV5o24lbx54A7x5V1H4PpB+44A3v3GzvHlN73vuqTPq" +
       "frTInoighwBvbnS1Qj2G+uQbgPpAUfgISN84gPqNNx8qckZdvcjeC7y1a6Ss" +
       "pxuHcr/3pNyPKkq4z74BuIUFhtogffMA7jfffLgfPKOuCM3PvQ/EE0Cyp28Q" +
       "Hd0KWhxjfe6mrp+BDcE1t4qL+5EPX/O/hf1de+3LL1+646GXp/+mvFh7dB/+" +
       "Tga6w4xt++SVrBPPF/zAMK2SDXfuL2j5JbYBgHWjqw0RdAvIC4rPkfvWwwh6" +
       "6/Vag5YgP9mSPdCGky0j6Lby+2Q7IYIuHreLoAv7h5NNJmB00KR4nPqHqoad" +
       "dR9jOqaO7hSTgeKvLC083NDstz4Pn9S00ufc/1pCO+py8hpvsY8p/4ZyuOeI" +
       "939EeUH7yss0+5Pfa35hf41Ys5U8L0a5g4Fu399oLgct9i1P3nC0w7EuDJ7+" +
       "/j2/cudTh3use/YEH2v9Cdoev/6F3Z7jR+UV2/xXH/p77//iy79b3sX4/y5U" +
       "B8sfNAAA");
}
