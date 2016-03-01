package org.apache.batik.svggen;
public class SVGTransformDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String transform;
    public SVGTransformDescriptor(java.lang.String transform) { super();
                                                                this.transform =
                                                                  transform;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) { if (attrMap ==
                                                                        null)
                                                                      attrMap =
                                                                        new java.util.HashMap(
                                                                          );
                                                                  attrMap.
                                                                    put(
                                                                      SVG_TRANSFORM_ATTRIBUTE,
                                                                      transform);
                                                                  return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sXD569zyus498QXOBf8DEFxBu7MZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Dcem66hxdzLiODoO1NZACkOj7M9QOdbJQqyPNhXCDOVJ1WVFvuV1FnyhppX6" +
       "1LKtcVx3LdSN3ljplhZlwiDZpWeq2jqOCIKnOj2fiqJql+M2ntWdN+viSOQt" +
       "udtfyzIishza5KWU1IbTFi1jYxbzKjg8don+RKIW3Vol1bVGOGeSzXrsCFSX" +
       "M8jSkLYmlOF6a4t2autFqpktGSPrk2aRaaeeQXMhxQH3cerzRpvlfY9bqst2" +
       "jVryutvQ6ghNCYNBly8V/S7SrsjEatBfqL6hkEAbprxmxbrbIeFEnzUYCbFS" +
       "dTizo3LN46k5HE1XigvI6sxYIdxhqzbBpv2JWO7H41G/Ve8XiOaCH2KYkjhI" +
       "jLNVvUESqUr2m2VPVmMUnyGemEyxCWnXiQ2qtuXRgEgqM71aDobSypii5rAR" +
       "TmldGIjMME2Ncg0nFKHCht6amVAtRyjxrXlPS2NYKs56qdb3l4vRdCx5Rsqa" +
       "xnouFblQ4F1pOrfWxmDVXvfnJj1t29yoLqk4MjERAh8MtG4NlSxjzC9tyxuu" +
       "/dWAgtdVa+wQg4VHeAIZepzPiLS3aMV9dNrmhmZ10KSqQ3ZZlWR4IBM6W/SE" +
       "0bDZnk7tKbEqdZMAZ4buKG2tupo9b4xm87hdV6u4WAyUmYYk4XzdWBKJM9K9" +
       "Zn00bY3qSTelO5zu6aPY6VIwu+BTYWS5lDTi0r7Rm6yXKdG0VdgdLlxj6jrV" +
       "dt1uNCQYRRyiYYvygGu0Ojri9chSPJvZWCS3a40Vbg0Xqwqx9hsBX8HEcmR1" +
       "E9FfrSN9yWJkLK/D+YwnmiJat6T6YCTFwipGA1Ss4Qpfr6+Kxthct7gEmU8r" +
       "bMVu9dclsWr1Jh4bwe2CrHgToO82szRbRm+wAhhnt5da3S1p4zHbmHa4YBHq" +
       "1e7YUPqsH9UxRO3KBh50pQWKKTO4bze5qB5SfqnHiUI6IldxjZghxRWOhFiN" +
       "7uFlRqohcL/sz9lJI+5b9HQaw2ZhWVWNZI5iKZ2YBWzYkNuc0/SWC8xv2PNW" +
       "2YoTvzxsDK0qyuHN9VTqNkroVNPYVKhNw7bGJmGipCuvYtt4x1/pnigy2jiF" +
       "MbwWhJ2OjZeNpsuu09hk1mOm1WFi1LHwGi6uOTRMEERYocBGMEstayOS5yi7" +
       "P/RmLDA6Nq6j/QJdayRVmHJbfGoXWHrIs8uoWxoGrWbdi9pkWsWaEY7GfkpX" +
       "VbU59ObuqOmSaIdQ/CFNTA3Yc33DqKc2blfqlcZkrRKCgLQQz+n06c1Kj9r0" +
       "3IArrhwwKVnAYL45WjtIl2kJtGEP0BbO4CTPzBpRCWEn04Rm+UGjKCrCoKkK" +
       "Cm65EbVeVzexMEJnYYLaspIYktZatlArJubYjBUCZsOLvMOXO8Vq34nc+agz" +
       "KfCokjrSCh6Wmvy8z7B2GlQLAIb9omIoIWYba7evFTEMo9x6UpBiqcIYi9BT" +
       "uB6rqVxpOYlLvFvv1CZMrTVkAfCSSxmOMdODpwOFRFmaXAr9cZ2vFqN6abm2" +
       "1uRijHsITBdVoJCkgHHjDrWpexpL9dPFErdLTttqMGkTnHGDtOCKcduf17j1" +
       "IKJ7yczsLbCFYuPaoLhRi7qBFsIVs/Ar67Kj9tCo47ThpoAlDVNKyqPqaiLX" +
       "QPMQRdGNXrVisxot442OBRMLwJ1v14oDlSrgvYK0sKaUsGQnbQqtrqXIc0uj" +
       "IjqLZumML2tBCabKjqTMOzUUj2TaXVXJ0BVrtLMCFujKi8GsXS+u+iRRlbXW" +
       "hA0Zyhj3wzSxqQntduGwZUu0rDJCuWzCQmppq8QhSzYPTvRVYLklHWaWgjit" +
       "xtSUWdR77W65WN0Yw8IsGCnjEqoMKAmcB46N6TSAKtJxWYDt1c1m5fLNoWzj" +
       "rVgUhr1xOGBHDVIcs/Fojg/gAUza1UJ5wHkddNooVZHZpE90IrKnmlZlMRq6" +
       "cYdqjhYsVvGLSy+lGAyDA7rHhQiDh9J8aGgUXpRatdlkhcIwXit0V8WkEHIt" +
       "mjOMIjwROq0GaZY3664Q2KnTLCsDUVvPesXEiSbjOU57VXC0u57ljuuVJBrq" +
       "fmEkY4oMqwtYVWlxUuuHg15hUm4VprxSafnFSiB0EItqzKI1UaOl6Vi0JiWb" +
       "SGYljvVon4O11AhTj/V4jhDmfdti+cViPm0p9S5Cz7tJqTNS3foSE1uqqhTV" +
       "AENAAGfh49kqbUqjwaRnmTWJrtmbSiFuLxvuUF+FnlDmJ4ONJ07wMlHkCW3t" +
       "+Gml5KNhsYZrdrgqKi05KHIC4bExFQd0DOuuD3cLgylPUizmxuzSDYuEMhkY" +
       "dCB3KWlt1NSGFFoJwk9Zh4YrcZklnDGnODYxn/cUa4ZsJg3GIlhT9jsbQcG6" +
       "MVOgZ1ZU6eChNZLhoOfDiFetEutU5YJxecZYqgrbG02gVi5S7Q+sFvAarR+w" +
       "1aQwrcF8XajN+4S3rs9GWhLBJIMr5ryDL4vziKtSSkVIKaXGSAB13HohJjv1" +
       "RslJagRrq4uqx8Alhg4pPNBYpdbujMwp6nLgbDMlZoOgJNpmgnAdtzx8xvut" +
       "yhBedzDGYJREl3hCqU85ujedISgNgMS31AXd5huJ3DIUczBxey00KEoS6dc5" +
       "RyqjDB23dS0S3LbZ5NByKWn5gqJKpSSlMalFVoUNyvC9OE06VCBoPX2uVpmy" +
       "6Fr1dG0Pm4gtNhGvWBn0CQBW6zVGC/7GdasrtQe344TB5I4gKgxmuS28NaM2" +
       "LaZh0jGBmIsyiPQWbSGAa1Hki7UyOK1p1iiyEaHZ4B0jiMlCH9PoeY3aJCXH" +
       "WyQFvFzfVA1bqnFFqYFv5htdaZDuBA9JqtRK4fZkSnjouCBVJx0SCQw9qZtj" +
       "TlCZqKepm8m8bsFMmzdhSvLl8lgfmBI9JazutDBydcOtay0edhPJWSBswWKL" +
       "GLdc+o5CdG2402/YiqXQITnS8apUwUPYNRS9StG9WlRdqGpxKhUGtCmPq9Ry" +
       "jqTE1O5UOLSNVZBOn7OA34oUrXfTGTPdVNaC4CoitSqaE0PRhlyr25uWMJyq" +
       "jYT6QrL8RohVYlqNBdgfDNlhQ+TYxoTqFX01EuTihGRDUe42a22x346qjFXy" +
       "I39Yg0k5biQutuTJ0TyksiB1vBbpmeIOKrDFstOZoHPGkgIx/qyhhN3iFNNb" +
       "o6Asdgy+mA68KvATLWhPAnzA8dX5ptIa2yaK2I6wLOLlMFrytR7HRFS7S4ZI" +
       "qZKICNY05U4R3+josFegFuzMN4OxPhPdKJi1ypVauokCrFZlZ3RDrbbanaQR" +
       "4eQCvOW9MXv9U364N/C78ouFg5zXj3ClsO26nBWPHtze5J+zJ/MkR29QD2/P" +
       "dvZvHx+9SXbgMCmwT335JtTjjR0KSfaW/sCNUmT5G/pH3/nsczL9seLO3m3m" +
       "k9mdj+O+3lRixTzGog89fuPbCDLPEB7esn3unf98/+SntSd/iKTCQyf4PDnl" +
       "x8nnv9B9rfTLO9Dpgzu3a3KXxwc9cfym7YKvhJFvT47dtz1wYLGLmYEeBA+y" +
       "ZzHk+hf7179sy71r61MnLotPHaRmLt9AgSNhnVvlqvQH7Ne//JH0hee39yGi" +
       "ECghVLhRDvzaNHyWO3n0Jvmfw+zod7s/9eI3/2H65n2733aghof2rxpvqIZ9" +
       "/7vj8HaZFPK+d+Vzve0mt+VPZ0UaQheXSlgPQ18Xo1ABo3Pitx9Pstz5crZ4" +
       "V14cbtK3vtz10FFu8ob1wYo52cPgaeyt2Pi/tf5x+XIwePRmq+0r+c6j1/7b" +
       "3MkH84WevYmWfy0r3hdCl4CWW4qq23kqaayE11PzxZcT+oN5cajmZ34YNSch" +
       "dM/1c5tZoua+a/5lsf1ngPSp5y7eeu9z3F/l6b2D7P35IXSrGpnm0evzI/Wz" +
       "rg+EzXk+v71Md/Ov3wihe2+Aldl9c17JGf/1Lf1vAs2dpA+hM/n3UbqPh9CF" +
       "Qzow1bZylOT5EDoNSLLqJ93rJJm2WYTk1BGo3XPNXNV3v5yqD4Yczf5lGz//" +
       "l8s+lEbMHr688FyfeutLlY9ts4+SKaRpNsutQ+jcNhF6AMeXbzjb/lxne499" +
       "/85Pn390H0Lu3DJ8uE2O8PbQ9VN9bcsN8+Rc+vv3/u4bfuu5r+bX6f8DPaeS" +
       "xn4kAAA=");
}
