package org.apache.batik.svggen;
public class SVGCustomPaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGCustomPaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.Paint paint) {
        org.apache.batik.svggen.SVGPaintDescriptor paintDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              paint);
        if (paintDesc ==
              null) {
            paintDesc =
              generatorContext.
                extensionHandler.
                handlePaint(
                  paint,
                  generatorContext);
            if (paintDesc !=
                  null) {
                org.w3c.dom.Element def =
                  paintDesc.
                  getDef(
                    );
                if (def !=
                      null)
                    defSet.
                      add(
                        def);
                descMap.
                  put(
                    paint,
                    paintDesc);
            }
        }
        return paintDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JhUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVZe8wrx1Xf+93cZ9Lcm7RN0tC8bwKJy7d+rL1r3TbU3vXa" +
       "Xq/tfXntXaC3633Ya+/L+/CutwTSSn1RqZSSlCDa/NUKqNIHiAokVBSEoK1a" +
       "IRVVvCTaCiFRKJWaPyiIFsrs+nvfRxShWvJ4PHPOmTlnzvnNmZmXvgedCXyo" +
       "4LnWZma54a6ehLsLq7obbjw92KXoKqP4ga7hlhIEAmi7pj76+Us/+OFH5pd3" +
       "oLMy9HrFcdxQCU3XCTg9cK21rtHQpcPWlqXbQQhdphfKWoGj0LRg2gzCqzR0" +
       "+xHWELpC708BBlOAwRTgfApw45AKML1OdyIbzzgUJwxW0C9Dp2jorKdm0wuh" +
       "R44L8RRfsffEMLkGQML57L8IlMqZEx96+ED3rc7XKfx8AX7uN99x+Q9OQ5dk" +
       "6JLp8Nl0VDCJEAwiQ3fYuj3V/aChabomQ3c5uq7xum8qlpnm85ahuwNz5ihh" +
       "5OsHRsoaI0/38zEPLXeHmunmR2ro+gfqGaZuafv/zhiWMgO63nOo61ZDMmsH" +
       "Cl40wcR8Q1H1fZbblqajhdBDJzkOdLzSAwSA9Zyth3P3YKjbHAU0QHdv185S" +
       "nBnMh77pzADpGTcCo4TQ/TcVmtnaU9SlMtOvhdB9J+mYbRegupAbImMJoTee" +
       "JMslgVW6/8QqHVmf7w3e+uF3OR1nJ5+zpqtWNv/zgOnBE0ycbui+7qj6lvGO" +
       "p+iPKfd88QM7EASI33iCeEvzR7/0ytvf8uDLX97S/NQNaIbTha6G19RPTu/8" +
       "+pvxJ+uns2mc99zAzBb/mOa5+zN7PVcTD0TePQcSs87d/c6Xub+Unv20/t0d" +
       "6GIXOqu6VmQDP7pLdW3PtHS/rTu6r4S61oUu6I6G5/1d6Byo06ajb1uHhhHo" +
       "YRe6zcqbzrr5f2AiA4jITHQO1E3HcPfrnhLO83riQRB0DnyhO8D3UWj7yX9D" +
       "SILnrq3Diqo4puPCjO9m+gew7oRTYNs5PAVev4QDN/KBC8KuP4MV4Adzfb9j" +
       "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" +
       "N8mYIxgcpBkrVyK8iW7MO768kGCfHi3SRkEn+9isUrHbtlMstNpjuEkudUmZ" +
       "tcfMwncRBcUr0QpVqbjpuDBLVKIeWSTQbk9QUpJfrENzXJ8aihjgLF1YNBmj" +
       "VY2libtJ0Vk8LKKjdYfCUKMQ0qk2x+zVZJ6MuIRBplwYIqye2uV1LyiL4qQe" +
       "lArlcqnqlTmv5KI0O0Fxo+MtcZcyiT7BIYN2cTAwQ2dd512DntcxrKBOaotC" +
       "Y+T0e5zQJJQiRhLrdXnDSbUOG/TSnr2clLu4Uwtb9ZQv1tKAnsPyEoZddCT2" +
       "OEMR5AlVhGmxBCMKaUzCVUyQlbG9IEdNkG2Q5NAdC22Gbs8Fjlotehq/svEB" +
       "Ocap7mjaqM3nbigIlrMUWlVT8xCkTRe6IxpJJqSzKhrWREgIYywaHXylGgpR" +
       "t3GjGLSrXrBsFlatZcHTWdQkgxXd73cFo+FVLCXqoWqd5krV1brSIdFwxZmd" +
       "Kh/ElGljsS8lk7nbM7j1plZqk4sKCs9JpOMDDAbdCAX3LVbE6KpAE4NCEWkY" +
       "ElIXvcFwMY/am/oaC8ZtJ0UNBJWXpocxiabh8+YMF2C0uKqTGOfDSRkVsJI6" +
       "HdWo+Qgk+297W3YMuPbaTmJ35YfOg6cFcADLOqjXcALZdj2SFY8fXG7ln7Mn" +
       "r6OPXm4d3l5A2anqgZu9GOQnqk++57kXteGnSjt7tz5yCF0IXe9nLX2tW0dE" +
       "7QBJT9389NjPH0wObyO+9J5/u194ev7O13Av+9CJeZ4U+Xv9l77SfkL96A50" +
       "+uBu4rqnnONMV4/fSFz09TDyHeHYvcQDB5bNrkWhB8EX2bMscuO70Rt6wanc" +
       "C7Zrf+JS7VUv6TJrKnG4Oytru21f8eYHr2q5vOgWl3SbrACH2zOhy4vt/SEe" +
       "v8U9IKEHqm96++9quROuXu0YfHTYvME+sFpmMOgx8H16z2pP/0Sstr1VyayU" +
       "Py3kLO+9hWE+mBXPnjTMU7cwTC73RtZ592uxTgKmevwVJLvSve+6t9Xte6D6" +
       "2Rcvnb/3xdHf5g8BB292F2jovBFZ1tHbtCP1s56vG2au5oXt3ZqX/3w0hO69" +
       "iYLZ1VheySf861v650Po8kl6YLH89yjdCyF08ZAOiNpWjpL8dgidBiRZ9ePe" +
       "vrXfcjNrN6ZB6CtqmBnKdda6H+p+cuo4cB2Y/+5XM/8RrHvsGELl7977aBJt" +
       "X76vqZ97kRq865Xap7ZvGKqlpGkm5TwNnds+pxwg0iM3lbYv62znyR/e+fkL" +
       "j++j553bCR96/JG5PXTjB4OW7YX5FX/6x/f+4Vt/58Vv5jeA/wd799F8kCAA" +
       "AA==");
}
