package org.apache.batik.dom.svg;
public class SVGOMForeignObjectElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGForeignObjectElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
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
    protected SVGOMForeignObjectElement() {
        super(
          );
    }
    public SVGOMForeignObjectElement(java.lang.String prefix,
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
            SVG_FOREIGN_OBJECT_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_FOREIGN_OBJECT_Y_DEFAULT_VALUE,
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
        return SVG_FOREIGN_OBJECT_TAG;
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
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMForeignObjectElement(
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
       "adUkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e8wrx3Xf3k/Sle61rHsl2ZaiWLJlX9mW6H7L95KVnZpc" +
       "csldLrnkPkjuNo683Df3yX3vumoSFa3tGHCEVH4UcPSXjbaBErtBkgYokiho" +
       "mwdsFE0QNGnR2kbRR5rEQFSgblA3SWdJfs977yddS+gHzHzDmTNnzu/MmTNn" +
       "Z+aV70L3BD5U8lwr0yw3PFTS8HBtNQ7DzFOCQ4JsTEU/UGTUEoOABXXPSe/7" +
       "+rXvff9F/foBdFmAHhYdxw3F0HCdgFYC14oVmYSundT2LcUOQug6uRZjEY5C" +
       "w4JJIwifJaG3neoaQjfIIxFgIAIMRIC3IsCdEyrQ6e2KE9lo0UN0wmAD/V3o" +
       "Egld9qRCvBB68iwTT/RFe89mukUAONxX/J4DUNvOqQ+99xj7DvNNgD9fgl/6" +
       "4o9d/8W7oGsCdM1wmEIcCQgRgkEE6H5bsVeKH3RkWZEF6EFHUWRG8Q3RMvKt" +
       "3AL0UGBojhhGvnKspKIy8hR/O+aJ5u6XCmx+JIWufwxPNRRLPvp1j2qJGsD6" +
       "rhOsO4RYUQ8AXjWAYL4qSspRl7tNw5FD6D3nexxjvDECBKDrvbYS6u7xUHc7" +
       "IqiAHtrNnSU6GsyEvuFogPQeNwKjhNBjt2Va6NoTJVPUlOdC6NHzdNNdE6C6" +
       "slVE0SWE3nmebMsJzNJj52bp1Px8d/KRz33SGToHW5llRbIK+e8DnZ4414lW" +
       "VMVXHEnZdbz/GfIL4rt+7dMHEASI33mOeEfzz//Oax/78BOv/s6O5odvQUOt" +
       "1ooUPid9ZfXA770bfbp9VyHGfZ4bGMXkn0G+Nf/pvuXZ1AMr713HHIvGw6PG" +
       "V+nf4n/i55Q/PYCu4tBlybUiG9jRg5Jre4al+APFUXwxVGQcuqI4Mrptx6F7" +
       "QZk0HGVXS6lqoIQ4dLe1rbrsbn8DFamARaGie0HZcFT3qOyJob4tpx4EQfeC" +
       "BH0ApKeg3d/7iyyEFFh3bQUWJdExHBee+m6BP4AVJ1wB3erwCli9CQdu5AMT" +
       "hF1fg0VgB7qyb5BdGw5iYErzATXGXF8Ba2Onw8JXAC6Hhbl5/78GSgvE15NL" +
       "l8BkvPu8K7DAKhq6lqz4z0kvRd3+a7/w3DcOjpfGXlchVAVjH+7GPtyOfQjG" +
       "PgRjH952bOjSpe2Q7yhk2M09mDkT+ADgHe9/mvk48YlPv+8uYHRecjdQ+wEg" +
       "hW/vpNETr4FvfaMETBd69UvJT85/vHwAHZz1toXcoOpq0X1a+MhjX3jj/Cq7" +
       "Fd9rn/rj733tC8+7J+vtjPveu4GbexbL+H3nNey7kiIDx3jC/pn3ir/83K89" +
       "f+MAuhv4BuAPQxHYL3A1T5wf48xyfvbINRZY7gGAVde3RatoOvJnV0Pdd5OT" +
       "mu3UP7AtPwh0/EBh3x8Eidsb/PZ/0fqwV+Tv2JlKMWnnUGxd70cZ72f/6N/8" +
       "j9pW3Ude+tqpfY9RwmdPeYaC2bWtD3jwxAZYX1EA3X/60vQffv67n/rbWwMA" +
       "FO+/1YA3ihwFHgFMIVDz3/+dzb//9re+8gcHx0ZzKYSueL4bAqtT5PQYZ9EE" +
       "vf0CnGDAD5yIBJyLBTgUhnODc2xXNlRDXFlKYaj/99pTlV/+s89d35mCBWqO" +
       "LOnDr8/gpP6HutBPfOPH/vcTWzaXpGJzO1HbCdnOYz58wrnj+2JWyJH+5O8/" +
       "/o9+W/xZ4HuBvwuMXNm6MGirBmg7b/AW/zPb/PBcW6XI3hOctv+zS+xUEPKc" +
       "9OIf/Pnb53/+669tpT0bxZye7rHoPbuzsCJ7bwrYP3J+sQ/FQAd09VcnP3rd" +
       "evX7gKMAOErAnQWUD7xOesY49tT33PsffvNfvusTv3cXdIBBVy1XlDFxu86g" +
       "K8DAlUAHDiv1/tbHdpOb3Aey61uo0E3gtxWPHVvG24rKGyB9fG8ZH7/1Cijy" +
       "J7f5jSL74JG1XfailWVI50zt6gUMz03Kwd7ZFb/fCaLGLfYi8DjcBR5HDU/d" +
       "0uF2VsDlAFX0XCkqfOxW2o9dMO9YkbW3TdUi+5s7yRtvSHc72ke3v66AyX36" +
       "9u4ZKwK4Ew/36P+hrNUL//kvbjKgrWO+Rdxyrr8Av/Llx9Af+dNt/xMPWfR+" +
       "Ir15FwPB7knf6s/Z/+vgfZf/9QF0rwBdl/aR9Fy0osLvCCB6DI7CaxBtn2k/" +
       "GwnudrNnj3eAd5/3zqeGPe+bT3ZPUC6oi/LVc+74nYWWPwLSM3vbeea8MV6C" +
       "toXpre3xoCh+CBhlsI3X90b51+DvEkh/VaSCYVGxC2weQvfR1XuPwysPbO4P" +
       "p7bF+qIR4s52SzmeKWCHH7rJDrcLteeCdZDhjqykiswWvu5k3WwNbfZ6hjY6" +
       "uyvd2KviSCW3UsOP3mZZbtWw1S0Hoo70SPQPXxyzdBzDLjRAKo62iwpPif/x" +
       "H0D8zl78zm3EV96Q+FlREM+Jo96hOB8CCduLg91GHOuNiHNPYsg75ZwXyb5D" +
       "kZ4GabQXaXQbkYI3ItJlHYSaengrmcI7lAkFabqXaXobmfI3ItPDHtiVFD9W" +
       "OoEHfAZdLKEjM2y/MTOc3szhHLpPvi66rTTpJbBP3VM9RA7Lxe+/d2v57yqK" +
       "Hy0yFlCrhiNaR2AeWVvSjSNPMQff/cAd3FhbSNHcOScT94ZlAvvHAyebHemC" +
       "b+zP/pcXv/nT7/82cPIEdE9cOGDg20/tiJOoOHb4B698/vG3vfSdz26jPqD4" +
       "+Wf+GfKdgutnXxdZkX3qCNZjBSxm+ylFikE43kZpilwgu3hvm/qGDeLZeP9N" +
       "DT//0LfNL//xz+++l89vZOeIlU+/9FN/ffi5lw5OnVK8/6aDgtN9dicVW6Hf" +
       "vtewDz150SjbHth//9rz/+KfPP+pnVQPnf3m7juR/fP/7i+/efil7/zuLT7u" +
       "7rbAbPzAExte94b1AO8c/ZFlcVFNpIq6jEpRjQ+UcYvhNZYoN1CH7JFBTmdM" +
       "NK7L0ShRDSPGXCXJx4jSnjUVh7ZsJPT9MobihrZuz1C7Twxq3c3G67uMNjNc" +
       "bzRsdjS6g9EmjnKWL3QWOTJyEbo/F7ENE5kNuSpUh36Qb+hB5K1MpVaLqUhR" +
       "JKXRqKlTvMfZS9cjuA055u3JwO8r+qxKUNqAXaqkZg8DjbRNZUSjpWlcQZIs" +
       "MBrkhmfxfJSu267dmy1dZyQuKJ4keE5L7BGDl7tMSOFjkWa1krfueBNOENZj" +
       "i89KDiqQbsA2KyyNaVgVdQw0746F8kiYO+G4ZSTjtdEddphGI+9HcE46M4fB" +
       "R76od6hS0lkqyNzrZkSWWy0Ml0rEgOcyvNEwzTSlmIR1Scqy1xuV7BujLBug" +
       "1aSK1zJL4EehIUYkNuwGpiJO115tPInHc7a74rrMXFIH45VMzxrsQGS9ji0g" +
       "wtBbO2vCwckNZ8wGTEOjQ5dtb4S02ptRdttnKKvXUZnJvOVbkcXHvVXfn9uu" +
       "Nh7LpE2IOBF5aJ510tRxMZRcTcxGS9MQeWSEI5EjGFKJMqHUHK8rOd9emCNB" +
       "Lxszr9roy31B14KxmYwI1uasWS0KCc/W63aQzuoIVeGshBaqdiTLeKCvGQ3N" +
       "WtO0WvW72SodyKum42ZBnW50J3k9HFf42BBWenexbM+FBa13B4zcaOkbJjTI" +
       "VtbV4hkzbtJmFxk30A2dza3ebM3ACU/TzspP+p3ZqEaAiZsblXA+0oix2V2x" +
       "9IDuDngr7rYnLK2hZUbjepWuJQz6GieLZaK+0ZKZN3FNtlnHl2PCpTZ1XEcx" +
       "c2WVxv06QGXrSIOWGvC0m0w3yMoSqyOsz3QEhJ0TDA2ndqdCeb2qyefzkap1" +
       "M8GYlVUj6PViYzahZ1q37mswr0+dtNJqRItJ2CytTVaw+oI9HnLrOW0yKsaL" +
       "0YrEamK8tJTuakJvNsZQry8Ds1GpV4VRpYytGXw8pUbYsJ8KRkmpxSIpVttt" +
       "k6yrhDpve5jHNZYJhQyMxYbiy4y4agobb7ZcdMo1Tt1sCDJqRGHb66yUfoNA" +
       "c9npsmNR8/E2lznZZhHNYa3uZrMOMZ934Nj0CBpZyhMec0rLsIPj7DIxiWXi" +
       "oz07r+HSYDRMfWKzlrg+h/Utul6mmkaMryReq4/kbjjx6ugmLU0GVU/pptR4" +
       "A3v4stNBMozwcbFm1wMeLN5RlPPTdix6VMLK4+GCKCc4SjY2q3ac8xt3zORp" +
       "NqYpPCFhEet0DVh0A8/bGCo2g+3JdCGprN/QbN1u6hvOp41mL15M7dp6UJKT" +
       "vLoOhkogoW2GYdGwkfWmhO70MqmGrvsdzen1mlEFCcNGwmMmNiDK1aVmbdYJ" +
       "6Y7NVtZ0eFSna7JZGnlWILZXi7ZSchhujgq4kaFZjHbXq8hh6Ky7MURqweeK" +
       "iffLjepi5I0qoWaHk7kp8vqiA8yUD0c+6w1kIXUEvElqXo0sD+J1ItgmOYXN" +
       "9mSYVmtCGxZw11i6bHfQELqr/qTMS4nfVXsyEsBjgllXa+yQSksy5adTmRv1" +
       "idKUN1Z4v1+d8421NIprG4YPZKa+Gpp9OBYj2fdxfJZ35gnl2pSvJu1pl9qU" +
       "3dwZcVqACpVZm2gZdYGK6o49r8hyJtRlvmkg8LSzoniDaTZQrylbLpzVEK3J" +
       "tiZpbDuyOJBKo6VRLU2IKqIiajxlo8Y8l2Wb8CSL61czx5c7XE5MVmjS5oO0" +
       "mtaaxAytdcOhXmo22vUxIjvUqsuDTZoVghTprzRdk3Bx3WhHcqTE1XBSL8kG" +
       "vQqnYwJ3RNHvdTPM00KMWg6ICb7CUTqKZMxAFVTrdVlGanvlkT0yOJNnOHYy" +
       "qMFhtVwPySHsEMugao7GQc5bPluFO4xUmoEaK1SjKbKem3Ubt/GSHLK2Rlhd" +
       "1Rd6ERcv9ZljurXealSPYFhMk2lzRqKTwSAk1GzTj+oDTQNbf9SACTVpzXy1" +
       "anF1v9eT2lG7Mp6rstWdTZ3YTiRZGbINxKoNXZKE5bSdhKJXtXRqlASdqdOA" +
       "Y6NMs2jWGapYkx/6drRkG/WeMcY6HD7DV1ru9jOXHFJo7m48X53Gy3LcDRXf" +
       "6NFLC4835VFzXuqW6MjvJCOb1ml9VSabrYTNpdbc5W3fdr0+Wzc1i2sRZEa3" +
       "Fbac6st2iAwbcNuFeYeYILYuCnm/viHSnOtkiNoLAj712ZrpJE5/PszDJJpo" +
       "1erADZ06vqnZSthm+n1VkcSQw1uwX+4wDh71CGE1Xk2lQJcXVr+cLxkbX2x6" +
       "E1bc8GkrRyOlTI6FSnfYW2UeAxvlQSWrxaZQ4VvsUtg0Alyfzu3xps3M/JqO" +
       "N1oq2Z034WYF+O8hXa8ZTX+ecA6qI6q2rE8yMS6psGUZ6TppW6hTV6frXkuY" +
       "1kglK5WcKoW0aC8d1GNrJMDZkKMQm5s24jq9nK/aLMFyPWJilxdeV9asbLiZ" +
       "qmOClfWwupwRsbFQlUV5wAtlzBnPUrUp1Wl/USsNpLFLKX3ZVQdwmeAXDQVF" +
       "/LpiJ/kI7q1aLTqx2lUrV70RiQySUX1Si9Z1ZOhR6AAbCLqctbSGbGKGmngT" +
       "obVkOyra2ozncBQQISd1YZebUOUOVs5oyxnWVnp76UilUjv3cl4NrdioDoIN" +
       "4awxLK1iE1HgicQVN/6iC2IyEewuIeN1k0UT6/BrQZ+HXGSYUkvjBBXjKkqH" +
       "Hmxcuj/k8Um/H7t5k5owdkZhWGtKiwo8G0g9bZHZ/dnEmMzrFVKcjwZqBvc9" +
       "yTdFx44CVawT9SGhjgi5W6U64UJcp0EzkWxEHptSJVJwMVjzPFqdpoMREQIa" +
       "VLMdc0ivgnFPImeTmJ5Vm+wSXrTs6ZweJYyaIEwfxdJ8oNQ341ajveHjBd+2" +
       "23C6ZnKmRdtyusioWrPRpMRsOYowQcoNlwp6ajxPV9OSnqms1uLiiTphjZVk" +
       "IdYwj1wZ6GyxDJrdkkK2p0iFxeZRxbD5Cl1tzY3houZmfK8EL5ZDJqODHKkh" +
       "CFEqrwdNldkomNSsWc2xmiLobE33hZSDxaQVwaW2zkZRHtYTsFh8gyvJqofD" +
       "zR7cgClxXg8rtOpWzIZvM81MirmNVIvaS9+i5hWBl5w0q9VKgQnCwB7Jj9Yq" +
       "m2ZsbwhCzwkzK0cWgi9iNS0NkDWaMRjYw1tTcSoHVjbTiGHAtIMeQ5WrusN4" +
       "dKatLWfJwVibXJQmtVilZk1hXjKD1TDvtCXKWDmtVUTZtLgZOnqI5GYeVCd8" +
       "BWlKsrhilXkLXbdoZdrs9VobrA9rK9TTo2ZJ8ER1uGHk6SyQfbRKESugukaF" +
       "bKrTVS9ebwzLqwX8hk5ZbzVjyQhBph0POLmSqYzdSUTyA8dLK5lvzjqZxVYm" +
       "shutZwM+3myc1NSx/iSow4NZKMBGqz8ZYGu9Ws85cdmDdZGKaVHuLtBms5L4" +
       "U9W0a7AiZ17ajBYlvccBchWdWwjmquy6x4w5QpjRXF8JcLI3N6U5W672Rvpq" +
       "vdCDllzxs1rPqsxnjK67a4QJ1uKATpUuKXXny3yeO41QWI3UsKSX21OWAZup" +
       "56LLIBEdfzTTKnRXhnuYhQzqqmrXNk0sbKtShU1SoPrOAB6uK3o2JOwm6hKz" +
       "WYttia21qOdGKytr4Ybq+HLoBFwwQcpNbgBjnUSUzIxacpXuaDAwhm4kUGV2" +
       "2GuidS3ngtGct5C43Jr2y81Bv+ob1X4D0ax8OsybI2zM0qP+wEh9ryeYPt0c" +
       "ooFuo3pZ1Sh/1tORCRJ16WW/N6HRjTNjxzwRaE0Q3Il1rypFtohyfcrsVSKk" +
       "g0uLjPQ0XK2TRgm36DGwolI+bQijsTkL0DhZ61NFRE0bphuxzLaUIeGFfsPM" +
       "QziXI6y+VqmusW6Na5Ygh61RJDd9V1ZJBgOqVnjZlARrlVCpVnHbtOGBb7u+" +
       "wZRrrmyubAsfD5juWjZHQZDUiN4sjikViXVKNzy5hGoyK6g1tLPs1LhOIiu8" +
       "YMWh7fdKMjmORMwiJlRmkyVikzYTti7U4XYtGS44OlVb087Cq8FUfSi3KHai" +
       "ZjpubCQ7TBBJnfJk2qrEoxEeIJMqOR/wJoPXGpSo8hOSwzh/4s0XbUFdIDZe" +
       "43wEIxpWYCf1NCOXvUGEljyux1dsV4F9EHIo8HidlPxhhUUadXfqzpsdr2rW" +
       "tQ6iwlHZi3HNE4crZ15LImu5VEtUsm6DTyeklAfsXMwncCmtwtNM5bVaGCnT" +
       "GnB7w7HBVuOaX9MWg4jLKQ18BhAKEvf9sllmszW/WUdOz8P6maL5HdxCu66v" +
       "TCsUP2+KfAvhAifrZ+VVgsWxbynkkKtitpqiabLOyhvEbpOxFQO/aSKV9cJT" +
       "GIYSaFtPHNpGFHVVdpbWpJX16+PWYu1g441SISV5oLJ5UqrOpwy6rvl9SaDi" +
       "sTryeBP24VAaTu1+lc+Bqx13864h40TsVnIF6YlePF6nCt1j+HG+HjPNVack" +
       "Lnp9Q9AmvQ5RkcqwmGHttDk1Y6nvSKLMmZ1OZ3u48+U7O/15cHuodfwc5Ac4" +
       "zto1PVlkHzk+Rtz+XYb2TweO/p86Rjx1hXLp6ETwg8WJYFKTTh8E3uoGvTj5" +
       "efx2r0K2pz5feeGll2Xqq5WD/XXPF0PoSuh6f8NSYsU6d3vzzO1PuMbbRzEn" +
       "Vyi//cKfPMb+iP6JO7hXf885Oc+z/KfjV3538AHpZw6gu44vVG56rnO207Nn" +
       "r1Gu+koY+Q575jLl8bMHumWQlP1MKOcPdE/m+sLT3Atu037pgrZfKbKvhdAP" +
       "G44Rbp9GKR3LIo1Y6YShb6yiUNkdb//MKUP7QgjdHbuGfGKBX7+TC7ptxSvH" +
       "Kri/qCyBZO9VYN+JCkLoXs83YjFUXlcP/+qCtt8qsl8PoUdP9HBWCUX7r54A" +
       "/o03AfihovIJkF7YA37hTuf8o6+L9d9e0Pb7RfaNELpfU0LSlURrsjfXzgm+" +
       "b74JfI8XlU+C9Jk9vs+89fj+4wVt3yqyPwQ2CvAtj7zXk7fwXmfv0k7A/9Fb" +
       "Af7FPfgX33rwf3JB258V2X/dgeeL8ndOcP23N4ureHH2xT2uL771uL53Qdtf" +
       "FNlrIXQfwLU4ut07he1/vllsxYu6l/fYXn7LsV06uKDt7qLyL8EmCLANj68J" +
       "T4H7qzcB7uGi8jGQvroH99U7Bfe6O8ylBy5ou15kV4CbdpRk4srK0YK8fnpB" +
       "HjcUcC9dfRNwi6UHtUF6ZQ/3lbce7rsvaHuiyB4BGwmYy/OvE45fHCxPsD56" +
       "R09bQuiHbvtysXiD9ehNb6Z373ylX3j52n2PvMz94fbx3vFb3CskdJ8aWdbp" +
       "Zx+nypc9X1GNrTqu7B6BeFuMTwF4t7se");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("DqG7QF5IfunGjvpDIfSOW1EDSpCfpiztreI0ZQjds/1/mu4whK6e0IXQ5V3h" +
       "NEkFcAckRbHqHZlc6aI77YEverohBUdR7KVTgejeyrZr8aHXm7DjLqefBxbB" +
       "6/bZ+1GgGe0evj8nfe1lYvLJ15pf3T1PlCwxzwsu95HQvbuXksfB6pO35XbE" +
       "6/Lw6e8/8PUrTx0F1g/sBD6x+FOyvefWDwH7thdun+7lv/rIL33kH7/8re0F" +
       "9v8DEvFsZo8wAAA=");
}
