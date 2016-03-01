package org.apache.batik.anim.values;
public class AnimatableLengthValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static final java.lang.String[] UNITS = { "", "%", "em", "ex",
    "px",
    "cm",
    "mm",
    "in",
    "pt",
    "pc" };
    protected short lengthType;
    protected float lengthValue;
    protected short percentageInterpretation;
    protected AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableLengthValue(org.apache.batik.dom.anim.AnimationTarget target,
                                 short type,
                                 float v,
                                 short pcInterp) { super(
                                                     target);
                                                   lengthType =
                                                     type;
                                                   lengthValue =
                                                     v;
                                                   percentageInterpretation =
                                                     pcInterp;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableLengthValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableLengthValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                result;
        }
        short oldLengthType =
          res.
            lengthType;
        float oldLengthValue =
          res.
            lengthValue;
        short oldPercentageInterpretation =
          res.
            percentageInterpretation;
        res.
          lengthType =
          lengthType;
        res.
          lengthValue =
          lengthValue;
        res.
          percentageInterpretation =
          percentageInterpretation;
        if (to !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue toLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                to;
            float toValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   toLength.
                     lengthType,
                   toLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                toValue =
                  toLength.
                    target.
                    svgToUserSpace(
                      toLength.
                        lengthValue,
                      toLength.
                        lengthType,
                      toLength.
                        percentageInterpretation);
            }
            else {
                toValue =
                  toLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              interpolation *
                (toValue -
                   res.
                     lengthValue);
        }
        if (accumulation !=
              null) {
            org.apache.batik.anim.values.AnimatableLengthValue accLength =
              (org.apache.batik.anim.values.AnimatableLengthValue)
                accumulation;
            float accValue;
            if (!compatibleTypes(
                   res.
                     lengthType,
                   res.
                     percentageInterpretation,
                   accLength.
                     lengthType,
                   accLength.
                     percentageInterpretation)) {
                res.
                  lengthValue =
                  target.
                    svgToUserSpace(
                      res.
                        lengthValue,
                      res.
                        lengthType,
                      res.
                        percentageInterpretation);
                res.
                  lengthType =
                  org.w3c.dom.svg.SVGLength.
                    SVG_LENGTHTYPE_NUMBER;
                accValue =
                  accLength.
                    target.
                    svgToUserSpace(
                      accLength.
                        lengthValue,
                      accLength.
                        lengthType,
                      accLength.
                        percentageInterpretation);
            }
            else {
                accValue =
                  accLength.
                    lengthValue;
            }
            res.
              lengthValue +=
              multiplier *
                accValue;
        }
        if (oldPercentageInterpretation !=
              res.
                percentageInterpretation ||
              oldLengthType !=
              res.
                lengthType ||
              oldLengthValue !=
              res.
                lengthValue) {
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public static boolean compatibleTypes(short t1,
                                          short pi1,
                                          short t2,
                                          short pi2) {
        return t1 ==
          t2 &&
          (t1 !=
             org.w3c.dom.svg.SVGLength.
               SVG_LENGTHTYPE_PERCENTAGE ||
             pi1 ==
             pi2) ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX ||
          t1 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX &&
          t2 ==
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER;
    }
    public int getLengthType() { return lengthType;
    }
    public float getLengthValue() { return lengthValue;
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableLengthValue o =
          (org.apache.batik.anim.values.AnimatableLengthValue)
            other;
        float v1 =
          target.
          svgToUserSpace(
            lengthValue,
            lengthType,
            percentageInterpretation);
        float v2 =
          target.
          svgToUserSpace(
            o.
              lengthValue,
            o.
              lengthType,
            o.
              percentageInterpretation);
        return java.lang.Math.
          abs(
            v1 -
              v2);
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableLengthValue(
          target,
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER,
          0.0F,
          percentageInterpretation);
    }
    public java.lang.String getCssText() {
        return formatNumber(
                 lengthValue) +
        UNITS[lengthType -
                1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZaWwc1fnt+nbs+CJOyI3tpHKO3YajKXJKSZaEOKwPxSYq" +
       "Tosznn1rD5mdmcy8dTahaQCpJEJqhEigaQG3auPSIkMQh0op0FSFkigFmkDL" +
       "DQV+AA1RiVQING3p9703s3PsEdxUqqV5O37vfd/77uPNxElSZpmkxZC0hBRh" +
       "2wxqRXrxvVcyLZqIqZJl9cPsoHzL23t3nn6h6sYwKR8gU0ckq0uWLLpGoWrC" +
       "GiBzFM1ikiZTq5vSBEL0mtSi5qjEFF0bINMUqzNlqIqssC49QXHDBsmMkwaJ" +
       "MVMZSjPaaSNgZF6cUxPl1ERXBjd0xEmNrBvbXICZPoCYZw33ptzzLEbq49dJ" +
       "o1I0zRQ1Glcs1pExyWJDV7cNqzqL0AyLXKdeYgtiXfySHDG0PFD3yZlbR+q5" +
       "GJokTdMZZ9FaTy1dHaWJOKlzZ1erNGVtId8hJXEyxbOZkba4c2gUDo3CoQ6/" +
       "7i6gvpZq6VRM5+wwB1O5ISNBjFzgR2JIppSy0fRymgFDJbN558DA7fwst466" +
       "Ayzevji67/vX1j9YQuoGSJ2i9SE5MhDB4JABEChNDVHTWplI0MQAadBA4X3U" +
       "VCRV2W5ru9FShjWJpcEEHLHgZNqgJj/TlRVoEngz0zLTzSx7SW5U9n9lSVUa" +
       "Bl6bXV4Fh2twHhisVoAwMymB7dkgpZsVLcHtyA+R5bHtKtgAoBUpykb07FGl" +
       "mgQTpFGYiCppw9E+MD5tGLaW6WCCJre1AkhR1oYkb5aG6SAjM4L7esUS7Kri" +
       "gkAQRqYFt3FMoKWZAS159HOye8We67W1WpiEgOYElVWkfwoAzQ0AradJalLw" +
       "AwFYsyh+h9T8xO4wIbB5WmCz2PPLb5+6fMncQ4fFnll59vQMXUdlNigfGJp6" +
       "bHas/dISJKPS0C0Fle/jnHtZr73SkTEg0jRnMeJixFk8tP7319xwLz0RJtWd" +
       "pFzW1XQK7KhB1lOGolLzSqpRU2I00UmqqJaI8fVOUgHvcUWjYrYnmbQo6ySl" +
       "Kp8q1/n/IKIkoEARVcO7oiV1592Q2Ah/zxiEkAp4SA0884j447+MWNERPUWj" +
       "kixpiqZHe00d+UeF8phDLXhPwKqhR4fA/jcvXRZZHrX0tAkGGdXN4agEVjFC" +
       "xWIUkKSio5Ka5q6upCQmDak0TrVhNrIBpyNofMb/59gMSqNpaygEipodDBMq" +
       "eNhaXU1Qc1Del161+tT9g0eFCaLb2HJk5EI4OyLOjvCzI3h2RJwdyXs2CYX4" +
       "kechDcIuQKubIT5AgK5p7/vWuk27W0rAII2tpaCSMGxdmJOwYm4gcaL/oDxx" +
       "bP3p55+tvjdMwhBrhiBhuVmjzZc1RNIzdZkmIGwVyh9ODI0Wzhh56SCH9m+9" +
       "ccPOL3M6vIkAEZZBDEPwXgzf2SPaggEgH966Xe9/cvCOHbobCnyZxUmIOZAY" +
       "YVqCCg4yPygvmi89MvjEjrYwKYWwBaGaSeBaEAXnBs/wRZoOJ2ojL5XAcFI3" +
       "U5KKS06orWYjpr7VneGW18DfzwMVT0XXa4Vnhe2L/BdXmw0cpwtLRZsJcMGz" +
       "wtf6jLtffu6Di7i4nQRS58n8fZR1eIIWImvk4anBNcF+k1LY98b+3r23n9y1" +
       "kdsf7GjNd2AbjjEIVqBCEPN3D2955a03D7wYztpsiJEqw9QZuDBNZLJ84hKp" +
       "LcInmrpLEsQ9FTCg4bRdrYFhKkmF+xL4yT/rFix75MM99cIUVJhxLGnJ2RG4" +
       "8+evIjccvfb0XI4mJGPedcXmbhPBvMnFvNI0pW1IR+bG43N+8Ix0N6QFCMWW" +
       "sp3y6BoSYuCcz2CkPSdKJPSUiBQiRMAZ/ZI5TBnX9MUcLsrHi1BEHBvha1/F" +
       "oc3yeozfKT0V1aB864sf1W746MlTnD9/SeY1kC7J6BA2icOCDKCfHoxOayVr" +
       "BPZdfKj7m/XqoTOAcQAwyhB/rR4TwmTGZ0727rKKV3/7u+ZNx0pIeA2pVnUp" +
       "sUbinkmqwCWoNQIRNmN8/XJhDlsrYajnrJIc5lED8/LrdnXKYFwb2x+d/vCK" +
       "e8be5JbIMczJGt8UxDIfnphtfLH8TobjQj6247DEMehyIz0EFX3AmquLIAxo" +
       "sZRjKsV/L+H688R07BL60kMW6zWVFDjpqF3DHGw+veWpiu1XOPVJPhCx8yqr" +
       "6/nH1r43yINAJcZ+nMfDaj1RfaU57IlA9YKXz+EvBM+/8UEecEJUA40xuySZ" +
       "n61JDAPNo71IE+FnIbqj8a3Nd71/n2AhWLMFNtPd+275PLJnn3BrUdi25tSW" +
       "XhhR3Ap2cOhC6i4odgqHWPPewR2//vmOXYKqRn+Zthq6kPv+/K8/RPb/5Uie" +
       "nF8GZmuyrF4dX8dqL6AfwVT5srs/23nzyz2QVzpJZVpTtqRpZ8KLFWpzKz3k" +
       "UZhbNPMJL3uoHEZCi1APOLPO5hp/ejzvfQxzgS7lEIr/XsMxxvnYWSTaSDis" +
       "4kuX4hATuFd8MY/FiZUCYpYwfgsbsmAtw7tqNw1/+Nqd7/7m9E8rhGqKGFoA" +
       "bsY/etShm975NCfW8aojj+0F4AeiE3fNjF12gsO76R+hWzO5FSIUSC7shfem" +
       "Pg63lD8dJhUDpF62O1he7kFSHYCuzXLaWuhyfev+Dky0Gx3Z8mZ20Pg9xwYL" +
       "D689lTKf7bi1xixUTTk8C+2o1RYMgyHCX9T8kbAEX5dCOLR4n4xGpmiSGgiL" +
       "Mx3EeQ4AkKu7O/v7graQDWg8uQrX+VXTBw8d2VTxirCF/CEz0Pa9c/3Rn+iv" +
       "nwiHbRO+iserBYXNyHPc2M9an9s51vo2T26VigXChoiZpz/1wHw08daJ47Vz" +
       "7udVYykGXtuH/Y19bt/ua8c5qXW2S0PFUM8zHZpERDTlhmGQwp7c5Lpo6mwu" +
       "mvTXndj3LbZVtbiALewUtoDDotxqrhA0g4zP2x4njsUDpN4wSVIxey+zD1tW" +
       "gNSbi5JaCJqRKarboeHUxgCtuyZJ61J4ltunLS9A6/eK0loImpEZkBtkCvFp" +
       "GLoXsCrDpCLU5RPyniKEZ1wCVmcJIE6E8N0MBOuaWXaQB9+aU+jyhmfaAzft" +
       "G0v0jC9z/LEfegOmG0tVOkpVD6pKnreDuaGL+4gbaJcfP13y2m0zanJbXMQ0" +
       "t0ADu6iw9wcPeOamv87sv2xk0yR613kB/oMof9E1ceTKhfJtYX7rJuJ6zm2d" +
       "H6jDH82rQcFpU/PXAy3+mI7xvNvWWHfQ4FybCCg7W8QWAg0UB2VcV2VOmFry" +
       "Ba8/sm41nvWt8bNVLyWKVqB24ewcKFK23IfDj8CpedAFSUPh6p7J3eLHk69k" +
       "+PSdWdFhjiPt8Oy3Rbe/iNSDaTSMr2twMAKps6EIxsIdRTww8LMfLSKix3B4" +
       "ENpAvHQEzYGS+P3E2bRSMaTrKpW0/Jpx5fvQOcu3DpdmwzNuS2N88lZdCLSI" +
       "YI4UWTuKw1OM1EKnHveltntczp8+Z87RBHjUnbDJn5g854VAi3D3pyJrL+Hw" +
       "R0amZjl3M6XL+rFzZr0Jl9CzHrbpf3jyrBcCLcLe20XW3sXhdbB8WdJ6JZFo" +
       "Hnd5fuN/o26M4Y/bhD8+eZ4LgQb48jjrOMd6sgjjf8PhfajiEorISv16QN8f" +
       "nDPvPHV9CZ7DNgOHJ897IdAirH1WZO0MDn9npAZMfYCaupu7XMY/PmfGG3EJ" +
       "o9sLNvUvTJ7xQqCFmQuVFVmrwIGAvoHxGFRwUCsVbEeyogiF/osrAUam5f00" +
       "gnd8M3I+2IqPjPL9Y3WV08eufkk0Ws6HwJo4qUymVdXb+3rey6E2TipcljWi" +
       "EzY4r/XQWherXaDBFS/IQqhOADUB3XmBGCnFH+/eZhBacC90vvzXu+98kLe7" +
       "D44VL94ts6EWgi34OscQrhvy1+BZu5x2NmV4yvZWX1HMv6Y7BWxafE8flA+O" +
       "reu+/tRXxsWnBVmVtm9HLFOgexVfObJF8AUFsTm4yte2n5n6QNUCpxFoEAS7" +
       "Zj7L44QrIUoZaA4zA5fuVlv27v2VAyuefHZ3+XHo1jeSkMRI08bcm5SMkYYK" +
       "fWM839UctAj8e0BH9bubnv/01VAjvzcm4jJvbjGIQXnvk6/1Jg3jh2FS1UnK" +
       "oM+hGX7Nc8U2bT2VR03fTV/5kJ7WslcBU9F2JfQiLhlboLXZWfw0xUhL7rVn" +
       "7ue6alXfSs1ViB3R1AbahrRheFe5ZL+BQ1cGJQ12NRjvMgznvncBl7xhoJGF" +
       "IvjPNf8BAIihwDIjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hhPvmLrazX3Qk4woBsTcnLp4Vm2dIKjxugkC3v/AIYTwgW/d+rk/+dxv/4Nn" +
       "XwXIz0EX8o0xcOIjGNheZAdsP/Py55+494U//rl8DwOk1/0Cff0j2aj/+I2x" +
       "9VjGlpgfDPBKnAj5nsPQM85Og8TzwPP+9twm13+iicUsuf8nDGVltNJQ008K" +
       "vhoXKK6zZktJ2Gx1ShNl2hpzLVFW6E5r1U3FyXwQxBvfR6N62dM9bU3oA8VW" +
       "elTI0dzcph1L6TVKyqIrsjOhZyNBiDAiM3MsxpvV+XpPKpAk2nekHttulMIq" +
       "jpTiUjem9XQ4n0vlTglfmjqM44tuO6VdUQ69WSpTiF3r28VVOu+Po3QpaWte" +
       "nrNzmXOrWjcOmhu+WEpKvl+xK/Fk1eoT1hDRZnNkMeL5sBGMIqrh1DaMgDoz" +
       "Rx7My0uxRvOIl4hOeT6lGQZR2bYwnG/aLhg1jims2hs367XYE2YrhRMkQRan" +
       "XUUR25bMVLRh2nVRuj+uTXUkpb12VFuqY5aSuwE1kVelUphsNjytzrGqzgUo" +
       "i2z6PbThajEa0ul6xNUlXGvPN3MeIdf8uKUbEytxxuZabNYbSJepl9ayq/YL" +
       "83KDC2YDXZDlKqMM1ijYSY24TsvdyKgRtRtSwuqEzY3pdap25JmqYFrRGtaD" +
       "EhX0KjDuVKxlKM8rUl8oF1arGtops2K7NmU2Vr/IsWEorhGzv/Ysps6p7XKZ" +
       "qJO4uYoTrFIh1xtjOXUqOLwco9PqpLcIGiJXdKoiXRbseg3jyBpN2e261ByM" +
       "QpdFhB6p6DUSG5eGEtWXiqNytKgyoj0dcaFG002+acntucVN4YHblwLatzbI" +
       "hh9sxBQXR+Vh1a+6ojRUam5FHUsYYxeTVdMGwVZAroS1V8P1mRXKscRrzWRN" +
       "FvpltZm0EosMasNwPVMRnGm4ntUbhExj4lBhuKrSBaFeThq8MqqMKIqLDJSc" +
       "2X00mMzUstKoiORUwHjciIci3ooca0b2+vMJk5QYIWiNZFJEy9VmZ20QI6OC" +
       "j9BR6NBWZ0K70mhmrgJy00PISNE5xeVX5IqZxGu7YFcHRNrBVqxaK488alPs" +
       "dnm1XKiYgq/1MJPxXbdcXfaE8VB3245lNriwooLNLqyzItfqigiFMK4BT/1m" +
       "Ikd4SZwNaAuZ9n3B4JyUmRFJFy+h1XTFb5A+l4z0kNmM0HGvhbfsGup2GoHL" +
       "b8R52B8WWQQZevM5p7CEKXWGVnOpDUfTSTTxPbUXVNai2wqJOQr7MNtiZwFN" +
       "9iWtgweOBJgu9oqkDW9Sh56RISaSCEFgUwzDC8KoTfe7YJyZk4bOXG4aCKIX" +
       "hgZDhHadH9vdVWtu9zGThKfactyX5WY0RhJy1mjo4zamWLQ0Zah0xA5nLdEJ" +
       "yi2lPK8sQqrn1ZUZMogkux2xtXDdDkxBhctVSxDn7VBZW7QTBnq9JsyNtq2M" +
       "h2hPQ+uGi1bQQjKoWojBUAqvFpvcrEyzWGfNd6ZLasOW7GKfW+nrcVykJmNs" +
       "Zmh2XWMXvdZCZQdl0mqVQ2Dbo8WsiI+QiGTZYhIqlCg0Ut3jOquJh1mawsNB" +
       "PU3VbikslwvJcqoLK7sW2U7NXkjedCNraL/NbnR55rGNlbS2q506i4w2tl2u" +
       "iFSz6hWqmtbt8CWhsmRnJC3LtTrdXY2tjVkUu4pl0VazWqmMjSqsLalOUw1U" +
       "yl/L6dBjOzI5mUhzirKwdXdtLT2HqArLKT2NALZNRqua0lBEo6bQ5NivxfCq" +
       "LwcdrhhM+fKY1Bi2NCy3WiJSCaLRZBpGuOQbjRFK1M3NSpAGyHisYJJvG0Ue" +
       "ruljb4Vo4Srh+3LMaUJjs0rMypRPTHNRqTu4g/m9vlgmfMKU+6jBsiPWW84w" +
       "xa+1NaYwQ/lJlVALpahY8qtrdKbHJt6YtvUiqU6nNCvNaxTdbZfqxWq5rCCl" +
       "Or6abJIwdjh6vqr25EW91pZ5jsDsVshrrO9FIU/HvSozAJyrfT2aMHZr5jGF" +
       "lMfWAzhinBQvC0K1qrFDibNTvuFzxX4DIwrGkp1q2tJUkTGLeVyja+ja2FPt" +
       "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" +
       "m1Vehm5f32Pt628NazuHDb6RNdjZuTt/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("O/ma8lcJdFV3ttdmg+CE9v76TbCYY/ePgu+beyx+8y3X3s79Z9Rdy5LLCXQf" +
       "sE/ZiIJD8D7gb+fKm+DvoawwA5jf3ePvd996/n7kjLp3ZsnbgPYAfxRYa400" +
       "vwu2Drl75A0930igR0593pg91Hr0jkfX24fC2ldeunb5HS8N//P2Sn//Me8V" +
       "HrpsLlz36LOGI/mLYWSYTs78le0jhzDn6JkEevyslTiBLm4zGfE7T287vQvQ" +
       "fWqnBDqf/Tva9j0JdP1k2wS6kP8/2q4ApHrYDky7zRxtsptA94AmWRYOt+62" +
       "czwmOnCih36YGo6EUc8eu2nPX8Tv34ovtm/ib2tffYlrf+K1ype2rxM1V9ls" +
       "slEu89Cl7UPJfNDsZv3pu462P9bF5nM/eOBXr7xrPzB7YEvwoeUeoe2p098B" +
       "0l6Y5C/3Nv/qHV/7wD996Y/yG7//B4h6DlmqMAAA");
}
