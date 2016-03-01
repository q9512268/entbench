package org.apache.batik.svggen;
public class SVGClip extends org.apache.batik.svggen.AbstractSVGConverter {
    public static final java.awt.Shape ORIGIN = new java.awt.geom.Line2D.Float(
      0,
      0,
      0,
      0);
    public static final org.apache.batik.svggen.SVGClipDescriptor NO_CLIP =
      new org.apache.batik.svggen.SVGClipDescriptor(
      SVG_NONE_VALUE,
      null);
    private org.apache.batik.svggen.SVGShape shapeConverter;
    public SVGClip(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          shapeConverter =
          new org.apache.batik.svggen.SVGShape(
            generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        java.awt.Shape clip =
          gc.
          getClip(
            );
        org.apache.batik.svggen.SVGClipDescriptor clipDesc =
          null;
        if (clip !=
              null) {
            java.lang.StringBuffer clipPathAttrBuf =
              new java.lang.StringBuffer(
              URL_PREFIX);
            java.awt.geom.GeneralPath clipPath =
              new java.awt.geom.GeneralPath(
              clip);
            org.apache.batik.svggen.ClipKey clipKey =
              new org.apache.batik.svggen.ClipKey(
              clipPath,
              generatorContext);
            clipDesc =
              (org.apache.batik.svggen.SVGClipDescriptor)
                descMap.
                get(
                  clipKey);
            if (clipDesc ==
                  null) {
                org.w3c.dom.Element clipDef =
                  clipToSVG(
                    clip);
                if (clipDef ==
                      null)
                    clipDesc =
                      NO_CLIP;
                else {
                    clipPathAttrBuf.
                      append(
                        SIGN_POUND);
                    clipPathAttrBuf.
                      append(
                        clipDef.
                          getAttributeNS(
                            null,
                            SVG_ID_ATTRIBUTE));
                    clipPathAttrBuf.
                      append(
                        URL_SUFFIX);
                    clipDesc =
                      new org.apache.batik.svggen.SVGClipDescriptor(
                        clipPathAttrBuf.
                          toString(
                            ),
                        clipDef);
                    descMap.
                      put(
                        clipKey,
                        clipDesc);
                    defSet.
                      add(
                        clipDef);
                }
            }
        }
        else
            clipDesc =
              NO_CLIP;
        return clipDesc;
    }
    private org.w3c.dom.Element clipToSVG(java.awt.Shape clip) {
        org.w3c.dom.Element clipDef =
          generatorContext.
            domFactory.
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_CLIP_PATH_TAG);
        clipDef.
          setAttributeNS(
            null,
            SVG_CLIP_PATH_UNITS_ATTRIBUTE,
            SVG_USER_SPACE_ON_USE_VALUE);
        clipDef.
          setAttributeNS(
            null,
            SVG_ID_ATTRIBUTE,
            generatorContext.
              idGenerator.
              generateID(
                ID_PREFIX_CLIP_PATH));
        org.w3c.dom.Element clipPath =
          shapeConverter.
          toSVG(
            clip);
        if (clipPath !=
              null) {
            clipDef.
              appendChild(
                clipPath);
            return clipDef;
        }
        else {
            clipDef.
              appendChild(
                shapeConverter.
                  toSVG(
                    ORIGIN));
            return clipDef;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12f+2vvk7b3toW2VPq+rbZTfrPvnc1FZHZ2Zl+z" +
       "s7OzO/tCuZ2d9+y83ztYBRIFRRG1RUygiRGiYqGEiJoYTI1RIBATDPGVCMSY" +
       "iCIJ/UM0ouKZ2d/7Pkpj4iZz9sw53/M93+/3fL+f85oXvw2d9j0Idmxjoxh2" +
       "sCslwa5uVHeDjSP5uz2qyvCeL4m4wfv+BJRdFR799MXvfu+D6qUd6MwSupu3" +
       "LDvgA822fFbybSOSRAq6eFhKGJLpB9AlSucjHgkDzUAozQ+uUNDrjjQNoMvU" +
       "vggIEAEBIiC5CAh2SAUa3S5ZoYlnLXgr8F3op6BTFHTGETLxAuiR40wc3uPN" +
       "PTZMrgHgcC57nwKl8saJBz18oPtW52sUfh5Gnvu1d1z6zC3QxSV0UbPGmTgC" +
       "ECIAnSyh20zJXEmej4miJC6hOy1JEseSp/GGluZyL6G7fE2x+CD0pAMjZYWh" +
       "I3l5n4eWu03IdPNCIbC9A/VkTTLE/bfTssErQNd7DnXdakhm5UDBCxoQzJN5" +
       "Qdpvcutas8QAeuhkiwMdL/cBAWh61pQC1T7o6laLBwXQXduxM3hLQcaBp1kK" +
       "ID1th6CXALr/hkwzWzu8sOYV6WoA3XeSjtlWAarzuSGyJgH0hpNkOScwSvef" +
       "GKUj4/Nt+i0feKfVsXZymUVJMDL5z4FGD55oxEqy5EmWIG0b3vYU9SH+ns+9" +
       "bweCAPEbThBvaf7gJ19529MPvvyFLc0PXYdmuNIlIbgqfGx1x1fehD/ZuCUT" +
       "45xj+1o2+Mc0z92f2au5kjgg8u454JhV7u5Xvsz++eJdn5C+tQNd6EJnBNsI" +
       "TeBHdwq26WiG5LUlS/L4QBK70HnJEvG8vgudBXlKs6Rt6VCWfSnoQrcaedEZ" +
       "O38HJpIBi8xEZ0Fes2R7P+/wgZrnEweCoLPggW4Dz6PQ9pf/B9AziGqbEsIL" +
       "vKVZNsJ4dqZ/NqCWyCOB5IO8CGodG1kB/1+/ubhbR3w79IBDIranIDzwClXa" +
       "ViJ+pCiShYynbdzQnN3M05z/hz6STM9L8alTYAjedBIADBA7HdsQJe+q8FzY" +
       "JF751NUv7RwExJ6FQDyBjna3He3mHe1uO9rd6wg6dSrn//qsw+3wgsFZgzAH" +
       "AHjbk+Of6D3zvkdvAX7lxLcCy2akyI1xGD8Ehm4OfwLwTujlD8fvnv50YQfa" +
       "OQ6omZCg6ELWnMlg8ADuLp8MpOvxvfjeb373pQ89ax+G1DGE3ov0a1tmkfro" +
       "SXN6tiCJAPsO2T/1MP/Zq5979vIOdCsIfwB5AQ9cFKDJgyf7OBaxV/bRL9Pl" +
       "NFBYtj2TN7Kqfci6EKieHR+W5ON8R56/E9j4dZkL3wWe2p5P5/9Z7d1Olr5+" +
       "6xfZoJ3QIkfXHx07H/2bv/jncm7ufSC+eGRqG0vBlSPBnzG7mIf5nYc+MPEk" +
       "CdD9/YeZX33+2+99e+4AgOKx63V4OUtxEPRgCIGZf+YL7t9+/Wsf++rOodME" +
       "YPYLV4YmJAdKZuXQhZsoCXp74lAeAB4GCK7May5zlmmLmqzxK0PKvPS/Lj5e" +
       "/Oy/fuDS1g8MULLvRk+/OoPD8jc2oXd96R3//mDO5pSQTV6HNjsk2yLi3Yec" +
       "Mc/jN5kcybv/8oFf/zz/UYCtAM98LZVyiDq1FziZUG8IIPgmAbmHmLa3N2/n" +
       "A43kLZ/K093MSDk/KK8rZ8lD/tGAOR6TRxYmV4UPfvU7t0+/88ev5BoeX9kc" +
       "9Y8B71zZumSWPJwA9veeRIcO76uArvIy/eOXjJe/BzguAUcBIJs/9AAmJce8" +
       "aY/69Nm/+5M/veeZr9wC7ZDQBcPmRZLPAxM6DyJC8lUAZ4nzY2/bOkR8DiSX" +
       "clWha5TfOtJ9+dsZIOCTN8YkMluYHIb1ff85NFbv+Yf/uMYIORpdZz4+0X6J" +
       "vPiR+/G3fitvfwgLWesHk2txGiziDtuWPmH+286jZ/5sBzq7hC4JeyvEKW+E" +
       "WbAtwarI3182glXksfrjK5ztdH7lAPbedBKSjnR7EpAO5weQz6iz/IUTGHRf" +
       "ZmUMPE/shecTJzHoFJRnsLzJI3l6OUt+OB+TW7Lsj4C49/N1aABE0Cze2Iv/" +
       "74PfKfD8T/ZkjLOC7cR9F763enj4YPnggGnszJDttrv0fhDdkfsWHwe7Y5Xf" +
       "anApr6tkSXPbTf2GnvSW43pWwPP0np7wDfSkb6ZnlhBZQuZmbAfQWXp4Fae6" +
       "zL7AT77KNNySfMHTHBAMJ3QZ/uC6ZMsg6DJ4inu6FG+gy+z6ugCYPut4WgRs" +
       "vq/GHX5mXuCTEZj4JG9fm4dvos31BmT+qkrk/SWngAinS7v13UL2zr82k9+r" +
       "G8Llfe+ZAmFBUF/Wjfq+0Jdyn8nCZ3e7QTghZPsHFhLgzR2HzCgb7DXe/48f" +
       "/PIvPfZ1AAo96HSUBSzAgiM90mG2/frZF59/4HXPfeP9+dQIDM58iLj0toyr" +
       "/tpUvT9TdZyvJCneDwb5bCaJubY3xULG00ww6Ud7ewvk2bu+vv7INz+53Tec" +
       "BL4TxNL7nvv57+9+4LmdI7u1x67ZMB1ts92x5ULfvmdhD3rkZr3kLch/eunZ" +
       "P/rtZ9+7lequ43sPAmytP/lX//3l3Q9/44vXWe7eatj/h4ENbn+mU/G72P6P" +
       "Ki74UsIlyUyaz4bRapTARHvTUWNSp2gLW6nFbsFXCvrUkMYNuVTU+RkfuP4S" +
       "RoaShgjRXKqIjaVk4+umO2oXeXVMsoX1iu9z44DjChrfX9eXjZHrOrStj2mb" +
       "bK+arWmjSiCrJm6hPKFS85JsMpEcxmhJnnluWqkaaeonVXlOm1RQxIIFPww1" +
       "Y1ZI9UHL6Glqc4haKF4biT22yUbtZjcGCzMERaUxO6s3wmHTIcQpbQvsYhUn" +
       "3dIGqy37bUPH3RI3XdDqdEy1cZx0Uqcz0rhOYSYk68myiI9LnG64wz41MPwZ" +
       "4U8mOt5rTFQ3WaSOoHnMeBCPYxp3Q1ql2WFsDsKR1e5u9N7a1JvFUnvJcQNO" +
       "QAUHLVVryXoQCJNyZboWNhN6qQmsocSFmUiNJd73mm1uqi+mPaUyL/fLy4Uq" +
       "+nJE6WSrUWfoTqMKUzRYXFEY4da8ttr12u0WUVgu+XWlpi87Yilc95IE6xR6" +
       "RWHCjhQ0GaXFRGoQXarpNtlZsTEfewtk3NeqFs1OeL21IozidNhdLUyV9lm8" +
       "Ly43aYJPCGtN4syKLpDoRqnPnM6sEYmMOmW8CizAkduiBGRqDxdOEd94lXJc" +
       "J8wNHo97kwWJj8dJR2wTrjWe2/2A9xS009Y2RY1tFS1ppTPrNjtLme4YW7EL" +
       "2OyLBFkKa4HSYxSzWpubfb7uanOCIw1kKq04GRvUaC+smY4bdoeMUunTAzMZ" +
       "pCW8yywCI55Xl5OFX+mHy1gcptVWE8P4jdqZkcvUMFxloarYasZ3+6Qmaouk" +
       "hfbX6Yh0vdFId7vBwsWHs5Jj6LxeErtrlxwyxTJuYX23aRLd1KdGnA4v1xgr" +
       "zcJVuvYFhC7wJabjLMo81+ZGrZKF8+M4khCip9VkItF7BF3ALEMZ6KtigiJK" +
       "QxWZZpPAKy4HLxzGZIswCgt429P8yEwn1KaBD5xowWrjmYHXLHJaFAkYrnkV" +
       "MbSdqq0KsDDnx7UN1e7QrebC7hKlerdKMmpY7vVLQwSm0xaJGvWROFqMyrOx" +
       "E7IpQUjB2uF1f00VLG5kDM3FusMNaJYodpJ5PFB5TAajrul21RwoS3WwYjGC" +
       "o4tmpMiT3qhJiAmhi/i8uEjMxsYwZyIRcV12hLfqXJNEy4MIIagCM1nzm1k3" +
       "IfzFdDoLOBUv1nW43CdwoaI0kclkwGmlsRLpclQmFLmNEAWmW2u2WaJQErR2" +
       "v6uN0bSntYj6oMBwG0Zfp66iFVKcoRkHmfUZrDGNN2SsYXhxVcE4vFmmTaM/" +
       "M7VebTqB+fJqldZEmeYGlFMZGTanWCVc9SljNMNjjlaF/iwO1RHR6kaVQcRT" +
       "9tyiBnJBTeLANSIEC+tOoVEoFppCYbUmF6QxLBnBpr5mRYZqNhncEEPdKdWQ" +
       "+bytoW2OxZRuPLd0JYIZbq6sqlUx1HiW7jcZZ8Zgqt/rLiUsCuNGoSqlQkFY" +
       "61bSqqNDMFpFheIGkyWRbEhrPK0hHUOYmPUUnTQQeLBZqumobFf8Ic4EQh/u" +
       "rEd0J2jUljLMT7gocZF1J03sZUWZKS0bq+jUoD3qKqQ5lysFLW5qhXgpe5yC" +
       "9pfpqKEmHLwc02YXjdySE9e7ft+fypMIawpRtWlxzQBtTNdub57WVxPLWi0W" +
       "C0NPTJlUKIFJp8O0Xq669YZPhHwprZBmGhPwJNCUZjms+C2+OXCLIU7UbRVr" +
       "iXW0Yk6cGvDQTaS1YGVGBmHM1iVWIdO4O1WqGozIQzwo1xtpZVFS2vXBoBU0" +
       "UDx0F4o7WHcKEj1dTtaCVA+b9SaliKnJgSBmKzPbaA02E80keugaMRsCHTEt" +
       "2N4UzQ6uxAtbZtVoTYZDurxac0yEeIo3rqjAmRK/MSyaXGBiUXc8RfojLxy2" +
       "5CZM2g1xxkTEmFHkUctqupuu1B0NNMxYiShXLQw8HsabyVLh686UVtTOKuEF" +
       "QiTDynoxRh18AW/YSFKSKFYnltMXwvHaBVNTp2n7a4YKUK6tLubToF5pD5aF" +
       "Apb0ym7sKYwyZFI9iNeLWa21lNuygWplyqDXmoDZ6zHW9xNXGaxJ29U2fD9s" +
       "rcrAeeDipAgHI9C7S3ZYoWN3SNvstTVM13oESePl0SRtKE2fFZjJKBgZU87W" +
       "03LMe5tyUJLsQlqpNHBmWK3LaFBO6xUVo3E6Cmd4NJgrjSoqjrjluF6TEbgx" +
       "g2G4Sq/Ksblky468FNIUnc/hRZHtdeRowm6mbdJU506QxijXICm9VKU6HiJV" +
       "KFlly2BRsBxJStwcUCEqFssDZFxezGU57WJgTmdXvb6NWf6SsjaTmGSXDXWK" +
       "Tke9pkyTiRgvPW5TG7RcXEfW0nJVxKrVOkK0ZQ5h4K6KtMV5N2r5nTlfmyJe" +
       "gujYWi0s7L4xrbONiDaU0AFwEPfDNpiVlx5GzoRZv1VEa64WY1Gf1v1lKSEm" +
       "fkJWgji2Bj7Tq5NVtzbXKKsuUcyKpErGwmLbWnm+atFom4etIjmfrLhCoVxW" +
       "0nTpjgdc6Hvj9sKmW31eHyx1fBp6kWX19VKZWHfGy5G6qpG9OlpO5maVRVxl" +
       "hmClYIk1F7NJlZ210Q1JiKwRRsLYqqFdd+STetMSOJYZ+Z1BQATFqTTn5obg" +
       "1kTP7TtDcU6Z5arFw/2oFRnuPESW1VmXrkR41Q/6RZbcOJQa18VJpQEHY0yb" +
       "sEHCz2HR03tIiJURxDHgYSzPNWMynyxifVblNnjCMm2/vRDWxZ6slKh2NaAM" +
       "XZDg4iyV551hNehvCoPQ5QMcFUW5PdIbeD0p1PsI1QvrzMSCB6EJT9NiE16L" +
       "qBxFk35q1B2UxytSz1tMOz2Vmi14iuDXrFPGWtNQ7A/6xsqXimK5PxeFdjmd" +
       "UwFtoXaIdnQtdi3btYiaHnWqtQIVdolqZ1AWjFE9KrY69NBHewt12HEbI5IF" +
       "A4HX9C6NqTWpAmYslmolI6I8kFamUsE1orpmWl1DLa/avU2Pn6Jkh+pZI0kA" +
       "yzq0jo75spGCBSHSr7FwsHAakc+v2E2z0eu2MJyHaQMsY9NZaRyb64CEFwwn" +
       "sLUR250N5XpCTbuYQA1jQxUCsJCJxsPVSkUmBVhaAdHpuqyFYRut19nmgKs5" +
       "JmpbOjMlYEQP7XU3DqemH08M25UHcVKcdrASk9IkC6flgLCQJjEIZMvtdqKO" +
       "58zDsc3x89Z6vOyMkV6QaC7GUhIy4YveylW5cEQ7UrPUXHNKUMXpSmWKDeaV" +
       "WtFAaxbCNdZUWML7MtGuwnR/bqUGQCtmTsMNVFdNRECXYo3rYZw89McGBdak" +
       "647hCOWmM+GmTuBuavN5qUymyMrHqzY71bxwRpSjnliPwXxiVfCuas5gvjJh" +
       "K43YLHtuXJV7Xg92Q0zSI3ZEDNYrE+iEeYXWBqsGtQoJxw0KnWuqzizgYb1Q" +
       "S+BGZ6ZMxAm2sRK8BoZ+7SyHc28jbIxORdeajuY2V8M+2R0VpWFJge3Fesar" +
       "CxdhXARMrl3T6I7UycyoFi1lMEcbLRJhisxssNjU8J5l0HChLdmhJCkeitjY" +
       "tDKq2iZiFJTpDK5i6KRmlAMflzeCYzdXleWQkcvdCowOR64zXbGJVx+P1hxa" +
       "VStUORCJRm/qDFaMzSDYXIFTGQmJqIoxMEnojhutNoHo1KU+XloI6bwHt3CD" +
       "NMu2tOkO+k1ugXIDFW5ZEkMiConFJKxZDSrhxaREm22wpcq2Wu98bbvdO/ON" +
       "/cE1INjkZhXya9jlbaseyZLHD45L8t8Z6MTV0dET6MMjRijbuT5wo9u9fNf6" +
       "sfc894I4/HhxZ+9oNgqg84HtvNmQIsk4wmoHcHrqxjv0QX65eXhk+Pn3/Mv9" +
       "k7eqz7yGy5OHTsh5kuXvDF78YvsJ4Vd2oFsODhCvuXY93ujK8WPDC54UhJ41" +
       "OXZ4+MCBZd+YWexB8LT2LNs6eRB1OHbXnkLlXrAd+xMn3696kp5ZMzsUVEri" +
       "btvjHfXgBjzn98s3OUl/Pkt+IYBOB/Z42t7v4vGbHHQdHtkdOuEvvtpRw9Fu" +
       "84KfO7Da67PCB8Dj7FnNea1We/vNrJa99nKC37iJGX4zSz4CXFcwNGdy1BR3" +
       "Z6aIy8KuaJu72QcT0t63DbniH30tiicBdHbv3DO7S7nvmm8btvfxwqdeuHju" +
       "3he4v85v4A7uzM9T0Dk5NIyjx9hH8mccT5K1XJnz20NtJ/97MYDuvcFoZsfU" +
       "eSaX9He39C8F0KWT9MA98v+jdJ8JoAuHdIDVNnOU5LMBdAsgybK/7+zb8+kb" +
       "uRa28gOPF4LMQvsHr8mp42B0YPe7Xs3uR/DrsWOok393so8Q4fbLk6vCSy/0" +
       "6He+Uvv49vJQMPg0zbico6Cz23vMA5R55Ibc9nmd6Tz5vTs+ff7xfUS8Yyvw" +
       "oRcfke2h69/UEaYT5Hdr6R/e+3tv+a0XvpafnP4vE+WcyxAkAAA=");
}
class ClipKey {
    int hashCodeValue = 0;
    public ClipKey(java.awt.geom.GeneralPath proxiedPath,
                   org.apache.batik.svggen.SVGGeneratorContext gc) {
        super(
          );
        java.lang.String pathData =
          org.apache.batik.svggen.SVGPath.
          toSVGPathData(
            proxiedPath,
            gc);
        hashCodeValue =
          pathData.
            hashCode(
              );
    }
    public int hashCode() { return hashCodeValue; }
    public boolean equals(java.lang.Object clipKey) { return clipKey instanceof org.apache.batik.svggen.ClipKey &&
                                                        hashCodeValue ==
                                                        ((org.apache.batik.svggen.ClipKey)
                                                           clipKey).
                                                          hashCodeValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wUxxmfO7+NwQ+CDQYMGIOEIXelSRq1pjRw4WE44ysm" +
       "lnq0Oc/tzd0t3ttddufsswnloaag/EERECAp8E8dtUEmRFWjVq1CqfpIojRF" +
       "0KhNgpq0zR9JmyCFPxqnpW36zczu7eN8jvinJ+3s3Mz3fTPfY37fNzt5C1WZ" +
       "BurUsZrCITqmEzMUY/0YNkySiijYNHfBaEJ64i8nD0z9vu5QEFXH0ZwsNvsk" +
       "bJLNMlFSZhwtllWTYlUi5g5CUowjZhCTGCOYypoaR/NkszenK7Ik0z4tRRjB" +
       "IDaiqBlTasjJPCW9lgCKlkT5bsJ8N+ENfoKeKGqQNH3MYWj3MERcc4w256xn" +
       "UtQU3YNHcDhPZSUclU3aUzDQal1TxjKKRkOkQEN7lAcsQ2yLPlBihs7nGz++" +
       "czzbxM0wF6uqRrmK5k5iasoISUVRozO6SSE5cy/6JqqIolkuYoq6ovaiYVg0" +
       "DIva+jpUsPvZRM3nIhpXh9qSqnWJbYiiZV4hOjZwzhIT43sGCbXU0p0zg7ZL" +
       "i9ra7vap+OTq8Kkzjzb9sAI1xlGjrA6w7UiwCQqLxMGgJJckhrkhlSKpOGpW" +
       "weEDxJCxIo9b3m4x5YyKaR5CwDYLG8zrxOBrOrYCT4JuRl6imlFUL82DyvpX" +
       "lVZwBnRtdXQVGm5m46BgvQwbM9IYYs9iqRyW1RSPIy9HUceu7UAArDU5QrNa" +
       "calKFcMAahEhomA1Ex6A4FMzQFqlQQgaPNbKCGW21rE0jDMkQdF8P11MTAFV" +
       "HTcEY6Fonp+MSwIvtfu85PLPrR3rju1Tt6pBFIA9p4iksP3PAqYOH9NOkiYG" +
       "gXMgGBu6o6dx64tHgwgB8TwfsaD58WO3H1rTcfVlQbNwGpr+5B4i0YQ0kZxz" +
       "fVFk1Rcr2DZqdc2UmfM9mvNTFrNmego6IE1rUSKbDNmTV3f+5msHL5IPgqi+" +
       "F1VLmpLPQRw1S1pOlxVibCEqMTAlqV5UR9RUhM/3ohroR2WViNH+dNoktBdV" +
       "KnyoWuP/wURpEMFMVA99WU1rdl/HNMv7BR1Zvyp4Tlh9/qZoKJzVciSMJazK" +
       "qhaOGRrTnzmUYw4xoZ+CWV0LJyH+h+9dG3owbGp5AwIyrBmZMIaoyBIxGTZH" +
       "MhmihgcGt0QUWQ+xSNP/D2sUmJ5zRwMBcMEiPwAocHa2akqKGAnpVH7jptvP" +
       "JV4VwcUOhGUhOE+wUEgsFOILhcRCIbbKdjKGAgEu/x62oHAvOGcYjjngbMOq" +
       "gW9sGzraWQFxpY9WgmUZ6cqSvBNx8MAG8YQ0eX3n1LXX6i8GURAgIwl5xwH/" +
       "Lg/4i9xlaBJJAfqUSwM2FIbLA/+0+0BXz44eGjzwOb4PN54zgVUARYw9xlC4" +
       "uESX/xxPJ7fxyPsfXz69X3NOtCdB2HmthJMBRaffm37lE1L3UvxC4sX9XUFU" +
       "CegDiEsxnBAAsw7/Gh7A6LHBl+lSCwqnNSOHFTZlI2Y9zRraqDPCw6yZ9+8B" +
       "F89iJ6gFnnPWkeJvNtuqs7ZNhCWLGZ8WHNy/PKCff+N3f7uPm9vOA42uBD5A" +
       "aI8Le5iwFo4yzU4I7jIIAbo/nY2dfPLWkd08/oBi+XQLdrE2ApgDLgQzP/7y" +
       "3jffeXvi9aATsxSSbz4JdUyhqCQbR/UzKMni3NkPYJcCZ5tFTdcjKkSlnJZx" +
       "UiHskPy7ccXaFz481iTiQIERO4zWfLYAZ3zBRnTw1UenOriYgMRyp2Mzh0wA" +
       "8lxH8gbDwGNsH4VDNxY/9RI+D9AOcGrK44QjZJDbIMg1n0/RAs6JR2koQ7Rc" +
       "SGC0EgNQtSlWl0MMgCYL0jXDKix4KNzPOcO8vY+Zka+I+NyXWNNluo+U99S6" +
       "KqeEdPz1j2YPfnTlNreBt/RyR1Af1ntE0LJmRQHEt/nhays2s0B3/9UdX29S" +
       "rt4BiXGQKAH0mv0GgGbBE28WdVXNW7/4ZevQ9QoU3IzqFQ2nNmN+dFEdnBli" +
       "ZgFvC/pXHhIhM1oLTRNXFZUoz7y0ZHr/b8rplHts/CdtP1r3/Qtv81AVsbmw" +
       "iLJLS1CWl+0OQHx487vv/nzqezUi6a8qj4o+vvn/6leSh//6SYmROR5OU5D4" +
       "+OPhyXPtkfUfcH4HmBj38kJpogLodng/fzH3j2Bn9a+DqCaOmiSrRB7ESp4d" +
       "9ziUhaZdN0MZ7Zn3lniinukpAu8iPyi6lvVDopMgoc+oWX+2DwW5F9vhOWMB" +
       "xBk/CgYQ72znLCt5u4o1a6wI8IqqnEEURbPhapaNQLLjqvLj4vI+u3wN5JMm" +
       "jRlyDkBzxCoNL7dO7f1VzfjDdtk3HYug3G72Xfvp1vcSHJRrWS7eZevtyrIb" +
       "jIwrIzQJBT6FXwCe/7KHbZwNiCKrJWJVekuLpZ6us9M4QzD6VAjvb3ln+Nz7" +
       "l4QK/sjzEZOjp574NHTslEBacV9YXlKyu3nEnUGow5pdbHfLZlqFc2x+7/L+" +
       "n/1g/xGxqxZv9bsJLneX/vCf34bO/vmVaQquCtm68zE0CBSPc6vfO0Kl6rXn" +
       "/3ng22/0Q5bvRbV5Vd6bJ70pb4zWmPmky13OTcSJW0s55hqKAt3gBZGjWdvD" +
       "mqgIx/XTYZeYWsmaHcWgLf48hbU7QTpwhZhVF5e7+3CLThw+dSHV/8zaoJUX" +
       "dlOAVE2/VyEjRHGJCnL/+JGvj9/4HBh58MZUxc0T8xtKS0smqaNM4dhdPir9" +
       "C7x0+O/tu9Znh+6iZlzi098v8tm+yVe2rJROBPmlVaBWyWXXy9TjjYN6g8Dt" +
       "XPV6vrPosUbmiTZ4JiyPTUxftxWd3V1aDZVjnSHD0xnmRlijUVRrwxv7P+BE" +
       "pT5DVJZmVDYQ4cPDxZ3PZVML4Jm0dj5590qXY/UpZp9lq0xq4smdJaOQSEZ8" +
       "pYMzWONbrNkHxSjZm8eKyWm+aqESew26+nGKapKaphCs+jfA/g4VHCM+dvdG" +
       "LIB06/7H6pT5JR+XxAcR6bkLjbVtFx75I7+DFD9aNEAKSecVxZ1GXf1q3SBp" +
       "mWvcIJKqQKPjFLWVKS3BJqLD9/sdQX8SbOynp6iKv910pymqd+hAlOi4SZ4C" +
       "WAYS1n1aL+/AgBfTihae91kWdsHgcg/I8I97NiDkxec9yNsXtu3Yd/sLz4gr" +
       "kqTg8XEmZRZAvbitFUFlWVlptqzqravuzHm+boUNrM1iw07UL3RFYATCR2ce" +
       "b/fdH8yu4jXizYl1V147Wn0DUttuFMAUzd1dWncV9Dwg3u7odEkNIJdfbXrq" +
       "3x269slbgRZe3lppsGMmjoR08srNWFrXnw6iul5UBXmDFHhR+PCYupNII4Yn" +
       "R1Yntbxa/A44h4UnZh/+uGUsg84ujrIrNkWdpeVC6WcHqPxHibGRSbdyrgeG" +
       "87runuWWTYizyywNsZaI9um6VSfVPMstr+v86F3ip/d/YKnbAMEXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "B9pu+FcOAuPrTgatI9OeDFmHOwjoZ9BZ/8KJKJVr+X7wfHzPgT9+MkqdgvIO" +
       "lqM8kreXs+Yn91ZoS+pH4HMKPP+VPdl4NrDdxO/C9jKJhw9SCQ9sabcbwFgw" +
       "V1FzsW++tHRg2iDKrfeSKeSpu761fO47n9kmSifX8QSw+v5nP/Cj3Wee3TmS" +
       "nj52TYZ4FGebouaKuj1ruplnPHKzWXKMzj987qk/+K2n3rfl6q7jyRYOzhKf" +
       "+Yv//NruJ779levs76dBIr3dDrK2mjXtrWYbN3STt255OwXi8pnSbm23kP2e" +
       "XH+ZTmfdnwIBPMwPFABDMx3RymXsRsDtLfny/jLx4IAB/OTywqrtx7JLuYtn" +
       "Frm7zcpP8Nr9H/MKNHnHITHSBQn+B//+w1/70GPfAlrpQ2fWmTEA9R2ZkVpl" +
       "Z55ffPGjD7zq2W9/MN+PwGZEfwy/9LaM6tWbSZw1s6yZ74t6fyYqm6dvpBhG" +
       "w3wLUZUDaftH5KEisBG5/wtpo9tnPTQkmvsfsjhXSzGXJLY2qsFUPIax9ng+" +
       "7BIjnJipFsv4RW/BxOgUR9FNaFuOXxjJSJQqhagcRYqy0sIwdkBAFXUExxkc" +
       "a3p1vK5EHG4znemC94uYr3mEu2A6hYFB6Z5fSJlG395gHTrxHW9arqZyuqqp" +
       "VH2xNp0+XA7Lw7SsTWhtXq5pVBpVsOJUaK0CLhQCjJj4Np4OuTlSmFPLDWua" +
       "iznV01oi3q+iZt1pF9LGelUZ451ZryDEIbUOl1KfpIZWhxWMOLKs6WRucWZF" +
       "r2CcGy8EA5t0sdF847kig1DLMFWdQY1YFlI0YphFi2iLpt+yJmK46NPYtGHp" +
       "2MBaTipS2K9TME5p7kAddP0x1SsP59NFeYgzsozGpUo1cbhozJUBd3LboAWW" +
       "ky2uLHJpeyxaxUmyGAyY5Wg5xqma1ZTDcWlD0lbLNMKa001hWE5TKRkW4k51" +
       "5TOBPagsK6YYugTL8Yybjqosi1fkDVLt+z7hWsvV3PWr7lo057xeaBNrEV54" +
       "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");
}
