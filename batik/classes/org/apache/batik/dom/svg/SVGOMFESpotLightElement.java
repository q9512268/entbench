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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "42Dv+tm8n6w5fPBNbmga76Ipa1zV2E0Lj2rmHyu8iLD8Ki/bsLg0Y7BlWioK" +
       "+bvLWqt8OnTNa9By8fj/fEjGuTKYaIXMRCvTsKxgkOmIgtcCNLtUMYWRhUvb" +
       "62M6A1is403fwKLTlLz9AuHHig7NbFjIKysxkOYEK74Zsv3lkdNX/u7w9x6Y" +
       "MNOp5d5BwsU3/z8DcvT2P/07z4x5eCiQ6rn4h8NPPLKgc+0HnN/208jdms4P" +
       "/hDrbN6vHUn+M9hS9nyQlA+TetHafGwW5BR6v2FIuI3MjgQ2KDntucmzmSm2" +
       "Z+PQRe4Y4RjWHSHspAPekRrfa11BYQ7Oyxp42izza3Pbc4Dwl62FTTqIryGw" +
       "a4NvcVx2PdunY0ZmpZPyJl2QWK/Cg1l2dsB8L8kzX75gu1RYPrA3jdE07I/R" +
       "y9rLjdvnjeezz+tz4yFmq12WhF0eqsdN1bFYkR9lvLgha0tntFnpn/F1KFIS" +
       "U/P+FG4LXRolLkCjXkumXg+NVF+NvLhBo0l8GXNJqF2AhP3WGP0eEo77SujF" +
       "DRLuKiThRJESroRnyBpjyEPCKV8JvbgxZVFhu210sC2FJL3lAiTdYo21xUPS" +
       "O3wl9eJ2SHpDIUl3X4Ck26yxtnlI+l1fSb24HZIOF5L07iIlvQyeqDVW1EPS" +
       "fb6SenFDvDY0KqZkQe9Oa6oCca+QwPcVKTCG2IQ1ZMJD4AO+AntxM9IgS0nI" +
       "5xXIxBXaoSRMj+uW+GEfidP2yN3ZkflfGbGOCDK/jpEdKUIgJ6eZuEx0es/8" +
       "3TJmok1eZz/83OrQ7fsPxgYeX22mFI255yndSir55O8//03oobdfKrB5r2Sq" +
       "dqlMx6nskLAWh8xJYvr4sZidEbwxc9+ff96aWFfMZhvrms+zncb/F4ESbd55" +
       "kVuUF27/64JNa0d3FLFvXuSC093lD/ueeOnai8V9QX4GaKYqeWeHuUztuQlK" +
       "lU5ZSlc25aQpS3PNfBU8U5a5TLnN3DZILxv3YvXJfn/s03Yci6OMLJQUWB94" +
       "dEs7ZDkijdPsabth+CasgzpfWuPW2WJ4qvGtsUfee9K0Snd26iKme/ff9UXo" +
       "nv2mhZqntUvzDkydPOaJLRe93gTnC/gLwPNffFAvrMBfyEE7rWPDxdlzQ03D" +
       "hbXETyw+RM+7x6ae/sHUnqCF0/cZmTGuSjHbWRz7MvYQvP5IdpZrsG0FPLut" +
       "Wd7tYyAF9mXlmi6Ng5quBLbap0cf2zjl0/YyFr9iZL5tN7lGg+2/sNF6fhrQ" +
       "asS2ZngOWLodOM9y6s6FpcqH1Uf113zazmJxmpGaBGURVRTkfss5bLChODMN" +
       "UDRh2xJ4HrP0eax4KLxYfdT9i0/bu1i8DcsGoNiSiX1LCsS+3H2DjdM704nT" +
       "YUvZw8Xj5MXqg8U/fNo+weIjEyeeor5vQ/DxdEJw1NLjaPEQeLF6qxkI+LSV" +
       "YOVnJgTDLgg+ny4IlsNz3NLjePEQeLH6qDnTp60ei0rTcQw6t1Y2FIGq6YTi" +
       "GUufZ4qHwovVR92FPm1NWMzNhcK1MALzphOKk5Y+J4uHwovVR91LfNowugeW" +
       "5kLhWiCB1umCAhPVU5Y+p4qHwovVR12f0/8Anv4HVjEyC6AYKrD7dCCyeroQ" +
       "WQ3PaUut08Uj4sXqo/U6n7YuLK5mZDbmGoW2tw5I1k4DJLOwbQE8Zy29zp4H" +
       "kgK7GS9WH7UHfNq+hcUGyIMVOtEP+8pM2lHvTDuyDRyZ66YBGYyu5Cp43rHU" +
       "e6d4ZLxYfbTf7tO2A4sbIF8HY3GfVmdPoKM2LMNfyg0JI/M8PgbAK6z5eR8g" +
       "mR/NiEcP1lXMO3j9H/gxQ/bDlpoIqYinZNl5IeB4L9N0Gpc4sjXm9YDGNR8F" +
       "pb0OrhkpgRLFDyRM6jFYT4WogRJKJ6VimZWTkpFS/uuk28lIlU3HSJn54iRh" +
       "0DuQ4GtKy9hs4auv7Gl75pjIzKsWOmeC501zzjeBWRbnxTXu7vnXY5kjkpT5" +
       "/diIeOzghv6bz339cfPiXJSFXfyMujpCys07fN4pHrMs8ewt01fZ+uWfznyq" +
       "cllmc91gCmwvioW25ZIO2NlqaC4LXFfKRmv2Zvn1Q2uee3lv2atBEthKAgJE" +
       "ia35109pLaWTpq0R+4TL8fUhv+tuX/7w5NqV8Y/+yC9NCZ7Z5VzruelHxDOH" +
       "t53eN/9Qc5BU95JSCW90+L1Y16SykYrj+jCplYzuNIgIvcA2uZdUpBRpZ4r2" +
       "xiJkJlq2gNedHBcLztpsLX52wUhL/nlI/scqVbI6QfV1akqJYTe1EVJt15gz" +
       "4zqpSmmai8GuyU7l7HzdR8SuO+ueubexpAdWZ446zu7LjVQ0ewrm/NKNV5jH" +
       "N1g8ncZ5BvMfifRpWubkpqLUvLEO7DFpsJ6RQJt1j42eJmAeeSDRXXwN3clf" +
       "sbj7f6oAPd7EKgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r3vA4D5zY/dM56HbkYd79H8PHOUj//6vrjOgwjGfEbGcqi9BX/qlx6gf/15R" +
       "/8hD5rWfyK5fw0CYe1QX/aL7Py4+del3L5bulEpX1H0MPZWdNPc7Eogb44PA" +
       "GsTZJ8pPxoC7gOe5wxXg7ae987FuT/vmo7UT3OfS+f3dp9zxw7mW3wuuZ/e2" +
       "8+xpY7xQKm6GZ9vjxfz23cAo4yJS3xvlD8HnArj+b37lDeYZO8t8kNrHVe88" +
       "DKwCsLQ/lLnOJJKthPGKJeVwpIAdvvs6OywmatMH82DDeJqe6dok93VH86Yw" +
       "tNFrGVrv5KqUB2DNvRqaN1DDT95gWhZqKHQrgKgjO4D+nvMjlrpnubkGuDR/" +
       "rDkF/wNvAD6zh8/cAL7+uuBv8hv5FBzjDcDh9nC4G8BxXhec7Vlw3JuE8x5w" +
       "8Xs4/A3gxK8HzuXAB099cT2ZnwUreQOw5ntY8xvA2t4ULPEsWB96A7A+sIf1" +
       "gRvA+vBNwZLOgvWRm4RVAZeyh6XcANbHXw+sK3Ggq6kjR60s8D2wip2F7mdv" +
       "Eh0GLnOPzrwBup9/PegecCwXRK8eiDs9ve6ZO892Gt4nXxNe0Vx2AcQMd6DX" +
       "qtfg/PenzwZwW377vjyZAGnD8mTnAM0jS0e9euC1p3oUA9d8delU8+L6KUzC" +
       "68YE1vL7jgIP1vfM537uP37y93/+6e+ABbdbumOVL4ZgnT0Wney85N/70qce" +
       "f8uL3/25IgIHmpv+7D+ufjdv9aXXZJYn//CA1mM5Lb54pGXlOOkXEbOu5czO" +
       "jzOGUTE6q/3OBvTCg9+xf+nPfm23a3E6qDglrH/8xb//w2ufePHisb2ip6/b" +
       "rjleZ7dfVIC+d6/hqPTkeb0UNej//JUX/tk/euFjO1QPntz5aHmp+2v/5q9/" +
       "/9pnvvuNMx6zb3fAaLzhgU0eWHSwmKkffFhENmZrNRvPjEHNMLTVZrzdKCI/" +
       "3nRalqF2R9OeLQx62Bqy1CHud3qsaTcXVb0y9LJ5WnVJGC9nWUj5pm/y3dYI" +
       "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" +
       "sFHAb37gu548w3edfJt7RP57t4L8F/bk");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("v3Dryf/1OWU/zJO/2pEv3iz+9yNe/+tW8PrynteXbzmvC5fPKXtLnty+4yWd" +
       "5HXhjjfL6xlwfXXP66u3ntfD55Q9kidXdpNxePxF9TF+D9wKfr+15/dbt57f" +
       "k+eUPZ0nbz/J75RdXnj8VvD72p7f1249vx87pwzKk3ef5HfaPp95s/zyAOGV" +
       "Pb9Xbj0/8pyy5/IES0oPAX78Ge/gj9HE3yxNBFx/uKf5h7eeZuucsnaevD8p" +
       "vTVfE896mX+MZ/1N8Hwoz3wMXN/a8/zWzfJ8zXjvwuicMj5PWBA0efqa8zX9" +
       "YHm8cnx5PCwo6PbfBN18wSiR4PrTPd0/vfV0nz+nLD+CcUECYR0Y1tOn1Q5P" +
       "oM2PuP7ETR11TEqP3OAce34i99Hr/juz+7+H+uWX7r/rkZeEPy6Och/+J+My" +
       "W7rLSB3n+CHAY/eXgkg3rEIZl3dHAoOC4QKQu9GZtaR0G0hz3BfMnbQNLPws" +
       "aSAJ0uOS3t4mjksmpTuK7+NyYVK6+0guKV3a3RwXSUDrQCS/TYMDgzv7rOrh" +
       "QbuDZ8nds+ejx62rCGUefK2BOqxy/Jh4/ghZ/PHp4HEv3f316Xn1Ky91uQ+9" +
       "Snx+d0xddeRtcYjtLrZ05+7EfNFo/sj45A1bO2jrUueZH9z365ffdfB4e98O" +
       "8JGlH8P2jrMPhLfcICmOcG9/85F/+t4vvPTt4vDM/wPMBO3QkTYAAA==");
}
