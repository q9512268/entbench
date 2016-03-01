package org.apache.batik.bridge;
public class SVGFeMorphologyElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeMorphologyElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_MORPHOLOGY_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float[] radii =
          convertRadius(
            filterElement,
            ctx);
        if (radii[0] ==
              0 ||
              radii[1] ==
              0) {
            return null;
        }
        boolean isDilate =
          convertOperator(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        org.apache.batik.ext.awt.image.renderable.Filter morphology =
          new org.apache.batik.ext.awt.image.renderable.MorphologyRable8Bit(
          pad,
          radii[0],
          radii[1],
          isDilate);
        handleColorInterpolationFilters(
          morphology,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          morphology,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float[] convertRadius(org.w3c.dom.Element filterElement,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_RADIUS_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return new float[] { 0,
            0 };
        }
        float[] radii =
          new float[2];
        java.util.StringTokenizer tokens =
          new java.util.StringTokenizer(
          s,
          " ,");
        try {
            radii[0] =
              org.apache.batik.bridge.SVGUtilities.
                convertSVGNumber(
                  tokens.
                    nextToken(
                      ));
            if (tokens.
                  hasMoreTokens(
                    )) {
                radii[1] =
                  org.apache.batik.bridge.SVGUtilities.
                    convertSVGNumber(
                      tokens.
                        nextToken(
                          ));
            }
            else {
                radii[1] =
                  radii[0];
            }
        }
        catch (java.lang.NumberFormatException nfEx) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              nfEx,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_RADIUS_ATTRIBUTE,
              s,
              nfEx });
        }
        if (tokens.
              hasMoreTokens(
                ) ||
              radii[0] <
              0 ||
              radii[1] <
              0) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              filterElement,
              ERR_ATTRIBUTE_VALUE_MALFORMED,
              new java.lang.Object[] { SVG_RADIUS_ATTRIBUTE,
              s });
        }
        return radii;
    }
    protected static boolean convertOperator(org.w3c.dom.Element filterElement,
                                             org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_OPERATOR_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return false;
        }
        if (SVG_ERODE_VALUE.
              equals(
                s)) {
            return false;
        }
        if (SVG_DILATE_VALUE.
              equals(
                s)) {
            return true;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { SVG_OPERATOR_ATTRIBUTE,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe3BU1Rk/uwnZJATyAAKCBAgBh4e7IgpTY0WIBKKbRxNk" +
       "2qAuZ++e3Vy4e+/l3rPJEkwRZhRGHcZRtGol07FoLUXitHVabaU4bX2Mr4E6" +
       "rWhVlM6oRWfkD42tbe13zrmvvftQpo7dmXv27jnf+c75Huf3fefbwx+hCaaB" +
       "mnWsJnCYbteJGe5h7z3YMEmiTcGmuQF6Y9Kt79y1c/xPVbuCqKIfTR7AZqeE" +
       "TdIuEyVh9qPZsmpSrErE7CIkwWb0GMQkxiCmsqb2o2my2ZHWFVmSaaeWIIxg" +
       "IzaiqB5TasjxDCUdFgOK5kT5biJ8N5HVfoLWKKqRNH27O2FmzoQ2zxijTbvr" +
       "mRTVRbfgQRzJUFmJRGWTtmYNtETXlO0pRaNhkqXhLcqlliKujl6ap4bmx2o/" +
       "/fyOgTquhilYVTXKRTR7iakpgyQRRbVu71qFpM1t6PuoLIomeogpaonai0Zg" +
       "0QgsasvrUsHuJxE1k27TuDjU5lShS2xDFM3LZaJjA6ctNj18z8Chklqy88kg" +
       "7VxHWtvcPhHvXhLZ/4Mb6n5ehmr7Ua2s9rHtSLAJCov0g0JJOk4Mc3UiQRL9" +
       "qF4Fg/cRQ8aKPGxZu8GUUyqmGXABWy2sM6MTg6/p6gosCbIZGYlqhiNekjuV" +
       "9WtCUsEpkLXRlVVI2M76QcBqGTZmJDH4njWlfKusJrgf5c5wZGy5BghgaihN" +
       "6IDmLFWuYuhADcJFFKymIn3gfGoKSCdo4IIG97UiTJmudSxtxSkSo2iGn65H" +
       "DAFVFVcEm0LRND8Z5wRWmumzksc+H3Vdvm+Hul4NogDsOUEkhe1/Ikxq8k3q" +
       "JUliEDgHYmLN4ug9uPGpvUGEgHiaj1jQ/OrGs1cubTr2nKCZVYCmO76FSDQm" +
       "HYxPPn5+26JvlbFtVOqaKTPj50jOT1mPNdKa1QFpGh2ObDBsDx7rfeZ7Nx0i" +
       "Z4KougNVSJqSSYMf1UtaWpcVYqwjKjEwJYkOVEXURBsf70AheI/KKhG93cmk" +
       "SWgHKld4V4XGf4OKksCCqaga3mU1qdnvOqYD/D2rI4RC8KAaeC5A4sO/KcpE" +
       "BrQ0iWAJq7KqRXoMjcnPDMoxh5jwnoBRXYvEwf+3XrgsvDJiahkDHDKiGakI" +
       "Bq8YIGIwEjfkRIpE+jauayedmqEPaIqW2s5wgqh0DR8MM/fT/18LZ5lGpgwF" +
       "AmCs8/1QocApW68pCWLEpP2ZNWvPHom9INyQHR1LlxRdAquHxephvnpYrB4u" +
       "tToKBPiiU9kuhHeAbbcCSgBM1yzqu/7qzXuby8At9aFyMAwjXZgXttpcOLFj" +
       "QEw6fLx3/JWXqg8FURAQJw5hy40dLTmxQ4Q+Q5NIAsCrWBSxkTRSPG4U3Ac6" +
       "du/Qro07L+L78IYDxnACIBmb3sNA3FmixQ8DhfjW7nn/07F7RjQXEHLiix0W" +
       "82YynGn2m9gvfExaPBc/HntqpCWIygG8ALAphgMGWNjkXyMHb1pt7GayVILA" +
       "Sc1IY4UN2YBbTQcMbcjt4b5Xz9+ngokn2qcwbJ1I/s1GG3XWThe+ynzGJwWP" +
       "Dd/u0w+89vIHy7m67TBS64n/fYS2eqCLMWvgIFXvuuAGgxCge/Penrvu/mjP" +
       "Ju5/QDG/0IItrG0DyAITgppvfm7bybffOvhq0PVZCrE7E4c0KOsIyfpRdQkh" +
       "mZ+7+wHoUwAFmNe0XKuCV8pJGccVwg7Jv2oXLHv8w311wg8U6LHdaOmXM3D7" +
       "z1uDbnrhhvEmziYgsdDr6swlE3g+xeW82jDwdraP7K4Ts+97Fh+AyABobMrD" +
       "hAMs4jpA3GiXcPkjvF3uG1vBmhbT6/y558uTIsWkO179eNLGj4+e5bvNzbG8" +
       "tu7EeqtwL9YsyAL76X6gWY/NAaC75FjXdXXKsc+BYz9wlABOzW4DMC+b4xkW" +
       "9YTQ60//vnHz8TIUbEfVioYT7ZgfMlQF3k1MQLpEVl91pTDuUCU0dVxUlCc8" +
       "0+ecwpZam9Yp1+3wr6f/8vKfjL7FnUp40SxrOv+xkDWLHe/inwp/UPN6Vw4H" +
       "A80ulnfwnOng7v2jie6HlonsoCE3lq+FVPXRP//7xfC9p54vEBSqqKZfqJBB" +
       "onjWLIcl5+WheCdPy1wEWnlivOyNO2fU5AM449RUBJ4XF4dn/wLP7v77zA1X" +
       "DGw+B2Se41OUn+VPOw8/v26hdGeQZ5YClPMy0txJrV6VwaIGgRRaZWKxnknc" +
       "fZsd0zYwkzXBs9wy7fLC6FjAKxzMKTa1xOnsLTG2gTWdFNWkIO/SJKx0gTSc" +
       "cgbcvLhns6w6LLJqPrCSNV3Cdy/7aqeEdazi3R35yuiwJOo4d2UUm+oTOMT3" +
       "EbLFWlAs1xFZjXVtsqmnMOqh5VI4oaXDVvrDhiSbYF4eu9QgDa8zsD4gS2YX" +
       "uLlNeVEeJXNzPETDchouGmEIxIBZDNrD7bIClxd74nncEIwwRWAXvYAxYBSF" +
       "XHwVwx/vYWRX9b5M3KS9eIgDQUy6vfnmXReEzq4QCDC3ILXnrrJ8fEXt3EOP" +
       "qIK8pTDz3FvKuzteeFD765mgfQMpNEVQXmN2vvLk+vdi/NRWMlhwzooHElYb" +
       "KU92UefYfTIzcz08pyy782+KtnytaTcwgSu5nAZ/j2yQ0yRhGd1O8r/B1Ri8" +
       "z8rDWte0jz/58Mq9S7/7oFD8vCLo6dI/8Z1Txw8Mjx0WWM/UT9GSYmWN/FoK" +
       "yz4XlMigXSf6ZN1lxz44vfH6oAUzk1ljBT/w50luyIR4zDqzzmENOHeFRr8j" +
       "Cd4Vyw78Y+ctr3VDctuBKjOqvC1DOhK5QBwyM3GPZ7n3dxeWLbf6Aj4BeP7D" +
       "HuZOrEO4VUObdZed61xmdT3LxikKLIZXzmdzCXTdxZpNgK6SQWC6ONSsz4Ok" +
       "1/3PSDqbDS2G53brWNxeAkl5u4g1SznPIIR53dAouDBJQLJr8tKRL9mdWoK5" +
       "T/yg4MoRkjXidrqvhJLuYM0t4BRwTxmES0ovTsgZ0ywGVTxnFZ7wxJQPfvH8" +
       "5tBJ28vSzq5nMu5zUF5lgHz9ZxdyPs1YDW88/bBB4ptZiOFDiQPpUdXow/Nf" +
       "3jk6/x2eIVfKJmRdgLIFqlaeOR8ffvvMiUmzj/BbJEcL6zjllvvyq3k5RTpu" +
       "mVrW7M+axQJKjwEISOVB64iPNY5v+0No+CrbsPyiN8KmLypR+M3lERlpeHvr" +
       "A+8/KrDRX2fzEZO9+2/9IrxvvwBGUYycn1cP9M4RBUmBJM7u5pVahc9of29s" +
       "5DePjOyxJVtL2T1Xw9SPf+znjYVQcW5ePOAVfTeN/fCNH57+3fiPQ0LwEgrz" +
       "zZvxz24lvvvdz/KuZTyjLqBD3/z+yOEHZrZdcYbPd4sObPb8bH5lCjzQnXvx" +
       "ofQnweaKPwZRqB/VSVb1fCNWMuwq3w8+Ztol9SgHCnc8t/orSp2tTv5+vt+I" +
       "nmX95Q5vACmnOcGiXvhvAHHM+1kRKGWvFzKDyipW+LwRQFSFqCk6wIkfsDyF" +
       "ff2IojJZpJL36Vk/fjrZp5uCtymaSlhyaI+JspushZ1aPgzmuwwPFmL/fDFP" +
       "Rs23UwKaf1ti7ChrngBpJbYvIUYJ8qdF6PLEtHxH5/Fwz9cTD5fCM2aB/9i5" +
       "xEP2eitrbisQBItx/EpB8MUS6nmZNc9QVGsFwW6d8IoUJ77f4zY+FwrFNU0h" +
       "WP0yrT577lrNwukpVf1ltY8Zef9MiX9TpCOjtZXTR6/9i4gd9j8eNZD0JzOK" +
       "4j1onvcK3SBJmeujRhw7nX+9TtH0Inc2OF/ihQtxUtC/CVdXPz04Kv/20p2i" +
       "qNqlA1bixUtyGk4pkLDXv+n2wVtV7AK5GkKZgSXK1MZzPScA5GguG8ivAnEr" +
       "TfsyK3nKPvNzgJ3/kWhH1UyPle+PjV7dtePsiodEPVVS8PAw4zIRQrQo7Tq1" +
       "kXlFudm8KtYv+nzyY1UL7MhVLzbsHqVZHndeBS6oMweZ6Ss2mi1OzfHkwcuP" +
       "vrS34gTEi00ogAHrNuUDeVbPwA13U7TQVQCgnNdBW6tPb37ls9cDDbzCZoXJ" +
       "plIzYtJdR9/oSer6/UFU1YEmQGAmWR5lrtquwu160Mi5WVTEtYzq5DuTmTdj" +
       "Vg7hmrEUOsnpZfV4iprzs4f8/yiqFW2IGGsYdyu1yqkmZXTdO8o1u0Ocf5HO" +
       "lsWinbpu3VgC73DN6zo/vuMcAf4LJO2zTy0gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6e+z71nWffj/bP9u/2P797DSPerEdv9rFSr8UJVKU6rYJ" +
       "xYdEiZIoiqIkbqnDtyjxJb7JzEsaYE2wFmnQOWmGNu4fS/fo3LgYVqxDkcHD" +
       "1rVBigIpsq3bsDh7AGuXBUj+aDcs27pL6vv+PQIjxSaAV9S95557zj3nfO7R" +
       "vfe1b9XuC4Na3ffs3LS96EjPoqOtjR5Fua+HR0MW5eQg1DXClsNQAHUvqc/8" +
       "+o0//e6nNzev1q5JtbfLrutFcmR5bsjroWcnusbWbpzVUrbuhFHtJruVExmK" +
       "I8uGWCuMXmRrbzvXNao9x56IAAERICACVIkA4WdUoNPDuhs7RNlDdqNwX/ur" +
       "tSts7ZqvluJFtacvMvHlQHaO2XCVBoDDA+VvEShVdc6C2ntPdT/ofIvCn6lD" +
       "r/zCT978B/fUbki1G5Y7L8VRgRARGESqPeTojqIHIa5puibVHnV1XZvrgSXb" +
       "VlHJLdUeCy3TlaM40E8nqayMfT2oxjybuYfUUrcgViMvOFXPsHRbO/l1n2HL" +
       "JtD1nWe6HjSky3qg4HULCBYYsqqfdLl3Z7laVHvqco9THZ8bAQLQ9X5Hjzbe" +
       "6VD3ujKoqD12sJ0tuyY0jwLLNQHpfV4MRolqj9+RaTnXvqzuZFN/Kaq9+zId" +
       "d2gCVA9WE1F2iWrvuExWcQJWevySlc7Z51uTH/vUR9yBe7WSWdNVu5T/AdDp" +
       "yUudeN3QA91V9UPHh15gPyu/80ufvFqrAeJ3XCI+0Pyjv/KdD77/yTd+90Dz" +
       "F25DM1W2uhq9pH5BeeSr7yHe172nFOMB3wut0vgXNK/cnztueTHzQeS985Rj" +
       "2Xh00vgG/y/WH/tV/ZtXa9eZ2jXVs2MH+NGjquf4lq0Hfd3VAznSNab2oO5q" +
       "RNXO1O4H76zl6ofaqWGEesTU7rWrqmte9RtMkQFYlFN0P3i3XMM7efflaFO9" +
       "Z36tVrsfPLWHwPPDtcOn+o5qMbTxHB2SVdm1XA/iAq/UvzSoq8lQpIfgXQOt" +
       "vgcpwP93PwIfYVDoxQFwSMgLTEgGXrHRD42QEliaqUNzsU/rYy/wN57tmXmJ" +
       "Grob9arGo9L9/P9fA2fljNxMr1wBxnrPZaiwQZQNPFvTg5fUV+Ie9Z0vvvSV" +
       "q6ehczyXUQ0Box8dRj+qRj86jH50t9FrV65Ug/5AKcXBO4BtdwAlAH4+9L75" +
       "h4Yf/uQz9wC39NN7gWFKUujOME6c4QpToacKnLv2xufSnxI/2rhau3oRj0vJ" +
       "QdX1sjtXougpWj53OQ5vx/fGJ/7oT1//7MveWUReAPhjoLi1Zxnoz1ye48BT" +
       "dQ1A5xn7F94r/8ZLX3r5uau1ewF6AMSMZODhAIyevDzGhYB/8QQ8S13uAwob" +
       "XuDIdtl0gnjXo03gpWc1lfEfqd4fBXP8tpMwODoOieq7bH27X5Y/cHCW0miX" +
       "tKjA+cfn/uf/8Pf/uFVN9wmO3zi3Ms716MVz2FEyu1GhxKNnPiAEug7o/v3n" +
       "uL/xmW994i9VDgAonr3dgM+VJQEwA5gQTPNf+939v3nz61/42tUzp4nA4hkr" +
       "tqVmp0qW9bXrd1ESjPZDZ/IA7LFBGJZe89zCdTzNMixZsfXSS//Xjefh3/hv" +
       "n7p58AMb1Jy40fu/N4Oz+h/s1T72lZ/8709WbK6o5dp3NmdnZAdAffsZZzwI" +
       "5LyUI/upP3jib/6O/HkAzQAOQ6vQK4SrVXNQq4wGVfq/UJVHl9rgsngqPO/8" +
       "F+PrXI7ykvrpr337YfHb/+Q7lbQXk5zzth7L/osH9yqL92aA/bsuR/pADjeA" +
       "Dnlj8pdv2m98F3CUAEcV4Fk4DQDoZBc845j6vvv/7T/9Z+/88FfvqV2la9dt" +
       "T9ZouQqy2oPAu/UQQI2W+R/44MG46QOguFmpWrtF+YNTvLv6dQ8Q8H13xhe6" +
       "zFHOQvTd/3NqKx//j//jlkmokOU2S/Ol/hL02i89TvzEN6v+ZyFe9n4yuxWI" +
       "QT531rf5q86fXH3m2m9frd0v1W6qx8miKNtxGTgSSJDCkwwSJJQX2i8mO4eV" +
       "/cVTCHvPZXg5N+xlcDlbAMB7SV2+Xz+PJ38GPlfA83/Kp5zusuKwxD5GHK/z" +
       "7z1d6H0/uwKi9b7mEXbUKPt/oOLydFU+VxY/fDBT+foXQViHVZYKehiWK9vV" +
       "wB+MgIvZ6nMn3EWQtQKbPLe1sYrNO0CeXrlTqf3RIdU7AFpZNisWB5dA7+g+" +
       "P3qgqlauR86YsR7IGn/mP3/6937u2TeBTYe1+5JyvoEpz404ictE+qdf+8wT" +
       "b3vlGz9ToRSAKO6z1M0PllzZu2lcFlRZ0CeqPl6qOq+Wf1YOo3EFLLpWaXtX" +
       "V+YCywH4mxxnidDLj725+6U/+rVDBnjZby8R65985a//2dGnXrl6Lu9+9pbU" +
       "93yfQ+5dCf3w8QwHtafvNkrVg/4vr7/8W3/35U8cpHrsYhZJgT9Jv/av/vfv" +
       "HX3uG1++TTpyr+19H4aNbgoDJGTwk89YlPRWbwHzOyhOXWmICzmOj4gebvY2" +
       "iI4xpi+sG0umNxopfDbZNfd4LNXrekvMEb0O2a2AG1K7lJc2fH+gSnzU9+wG" +
       "RnvsYmVFA1FW5AWirJrjAKHawXIj2uO2xy+NHYk0I0WHW0XgJIkRzXwP05xV" +
       "0sS2rlFXMXQQGy1DN5Q0q28IWe457jIcusRaifRhX0c3WNFajynHEtS+E8/o" +
       "9ro7irBuDqtQxolKTOxHjCHwGC7tdUrQmJjKxU13z0mh488DKqAwgtmlS6XR" +
       "H892mUWADElpek0nb0qDJS06c1nWlwyTmUwhW/seKsjhNiOJhUab0xG6E1DF" +
       "GnYm6EA0PHY5Gu35yaCJTZu0U3izZpFZW0FJAocXRF4xzBlfDBe0M+T7SyFy" +
       "1pOIElb2tOHz8mSz2682rLq3bWsUb+02WC0UJ2t6EGTkU1PYxxvLXovCasQD" +
       "ZSx555v5jOcVMcbgPe2P4ajNxR7LgMTaM33Zc2WrIZmNmRnKYRIswkE8zCh4" +
       "18SEmNwuUHu+mTczkh63WEkebvG2Gk22cKfoEJudvc87nZ2JidlgGSUqtxkk" +
       "QDIJQsZK20X1jRNgC7kZdoNBNGfxIeElDbMxHE53yFhtLawZz3b3NEKbkMrP" +
       "OvKI62dS3OkvFvne6a/w3jJvhuP2WDDbkN82vZBQGKm/tvcba6LvtrHYXUbE" +
       "IqT8HbvibVFkmmOsPVN7+74gOUNygLjbpW2M4nAYmAaqoqnUz9GeuTFlazNp" +
       "M6TD0st4HW9wUh3S9Ch3GLdlGn1vNCc0D2GYfhdbWMLQibV5FmXz3dxrWn23" +
       "jQ5InBZpUaWcBstPyI6EpvzSiZ1iF6r1QUvUEqc+iG1k4plkOF1Qu40OQ8wu" +
       "23d2rf1wYVsUaQ7WDjtBYrMbc30/WfQpc2DJW3g7g6ZBP4TVWBGCpjsiJHFN" +
       "OFOsTc/JmTNYZxznovVme5jYCh2J0708Ergt2thOBdjhJtpIhme03980pwrZ" +
       "C8kMCwxdwiZZw5KQkRebE3E+3M/n67EBLyJ56aviep9uR1sqHa53U5FaLfhe" +
       "aGANfKMz0Gi06XdbqrObL83ByNYQEVn1DWQ62oUEsZdNueUs4L3mJtP9moTI" +
       "ZsAgPNEZ4bJOoDgSTqGR6lO9YNawlvhwjwGHX3njrepy5NjLNug2db0ev1on" +
       "VGrUW6vADBNyaMmbHTkgR1Zf3jG9fWfN9JmU2ho7nvGp+laO5VzXnD3Fycx+" +
       "2QzR1NxvGiTfGY8hQ4DgDiuhdt83Uxp3iLADwTNPxf1lu+MTS5byuaY0WSbc" +
       "wHO6zCSfDXiYtTNew/fxINP9TeL666CHxJHgjXqcZS26u3gz0HFFUYm52RvD" +
       "ebGPIWxfrGIl7+BRV6bzMZ5uV5K5iiJfnbL0dkalbYPNWtBwudqbHXrB47Nh" +
       "im5ypKGxgpPNkFl9hk4YPCSCZW+e7QR+zvWRRQtX21oMzQKvgbF1FuswazJz" +
       "cYLpOUornOAt2rGyWYfcGNsl5roQwEuM385W1IC1rKyx7DTXudt3m07XTAwq" +
       "k7meCg3caA8UZ3Kz38FZ3N+Y4/5yst2t8vFAgf0I68u5yLD4XIWZNbKYNNc9" +
       "RZipY0XdRoiCropu3TW9ndvcq6kyhBkohPv91mopbPR67hb9YbrkSA2KG2m9" +
       "002YQY45bUzozduICxnreVPfE+x4mZgMvUriGO+bGQH+fnO6GyQx5Gy5YYxC" +
       "M7IPNRgmCvoNMscZwfT9xHAwJVcMY5ps9g1OlAgAvRSiNkbTkMkNn9dmu40j" +
       "1bF6OvAWKU47E72xGsWE2PGHfVUVUxMbJk1vxQ6STtqC4dTsLNrsQJOnzmrc" +
       "IrECjknFDTabhHIKa22GGhm0w9SmWmY908FUbslUC2QOGyFCWO9i9KaO53jP" +
       "U8YBucHHIbL18VbfWqncbpvQrbgPJz1nowhtKEfRTiww4XI3hbGuPmH7W6Su" +
       "o0oyKZR+J4oxSt9HKdtdhznOYu1V21yuoQkuExhKb1faajUCENJbF93UxnvT" +
       "YomQY6KuINlu2V0Ls3YDghJ3UHQEZqFQhmh5awGTTGNsz+jWDh7PWJ8S7S7s" +
       "C2S8IBYNTcwWNqF2GnVdTX1JdrprH6630qBtQJ1kZGxZjHYXPtKYZ8E0qWc7" +
       "cskOdMhyUx9acJO2mCIDvNOIbddI3alrYklza+ntAcglQo+gWva+Tovciucg" +
       "CMsMouujSEL15vv9SDL2w17PAwDMMqqN1pcbndC4HE6ppWtbyTSfTJvGAsXH" +
       "CNLlF70hsqIRzYVSlsMSDCtweEX203qvOdcReLpw6yI3TTtQ0mxvtL4+k9A1" +
       "YXPjvBFlw0AEYspM3+R5WVqOMnfnqoYUao1ine6KVS/spjlmsESb3uKjrBiP" +
       "BBnOpm7ICv2mKSw1erLcMVNoPhxlDVOYq6qpqAm7ccN22mbZ4Z4LiPlEbBFa" +
       "DmEyyAs0ubBafAvNYysdTj1Eay4WTt0TpmOhRSlgRbHxEM5oabsSo3DvuOPp" +
       "foOKDOLJK1JMgP9Yc2VNI3rcnZmk3ClCEjHnzfUqZu2JLlL6cDUpOEog1Y0X" +
       "9x2KyZieRE4CElMYws40DHFdlWJSsOLgq2SNZ+venF4NUjHNoGS95FddBR23" +
       "RvOuzpjkbJG3E8N1VrxOFXtkRpBEi2FXbhAMOwa1ilrUlNszow7wl6JFJ6O4" +
       "iHSdJrE26pjGbOxPKHG2cibNJGF39USzoAm/HNubtPC8AWWvldGi21zoxtoQ" +
       "mEItGh0/z7FOsz6K3DySBTU15zHq4hK0beazRs5v+ho87QRQD+YtkD8E5DLS" +
       "G9sCQjvjfXeOQZhHk52EYL22xkAdCRaytDPeAmxbjqGF0O3P185yAtHeKC+Q" +
       "lT22zNXcaEsT2M4KBEmMQdvDF8UOtrc9AUrRhh3nDI8U5L4oHGoyHeg0H3S2" +
       "BFjG8hTrrOtqFLREUo3i3mg73ScETE43I3TWS/Nxq89JmNvSABiwitHGt0hP" +
       "5zByEEvTgJoi4mKqaJKuteHM0YQWm1m7EctIq8LRCmIlaJnkT8xRez5bEu3p" +
       "ZB4WyHQHQy1uTu4Vct7soy0lWE4yHd/ZaIyY8LxwOYbh0ZaGezHZG87YYdCJ" +
       "RiA7crSlN0IFKDeRscfvtitLC/bJZsjG63EjQnp8KmQONW94iRCaUiNP+6KQ" +
       "ubSEpdlwxhnJoINGvWGzk8yLPeqOY7RY0KhtDoqulGk5F8JrctnpQEqvh/iR" +
       "ZE1p0ppx/kJbeSk0MVrbXRvKmjojGqOhw2smy9B7W9anfMcwkmRsLZxiC/WU" +
       "IaWy7WJr20mS71s7lBf82BGDJTauy9lsONqmFDOfir02YnGTNZrUGxOvTgRK" +
       "yOXWpDNy2Nzn6+OWTfG2rw+SAK93oFFA8qumUVDStFtvQl0myJIk7fUX61x1" +
       "YZXrjhG+t3B6wzEWo74ob9SuZzS7IUrq3HaaZ0MxYpsCvEq7c86oF+52Lc7U" +
       "JapzU1w0BH0CGcRkgGL1lmFxswabUmZQFFKSFU0EqJFoBTSKJSHfsvse2YKK" +
       "ej6lBlIgaepa4TSQ3Cic0lEGqE1si5m7SjLPmLmpDnLYVOL3PUiciwoMhliO" +
       "43TfSjt1KfLs7twcEK7aiSAvmPvNSEjQehLVGRChXXSGJjjhuFMVLCzJJsEH" +
       "g3Ed3vGj/jKhixGZW/6yzqb8jJ7Te2LXTpmdEZI5bRhNxtsOJX/IttriDjK2" +
       "geSjMRHljjy3N7nM1IehH4cbCZY5s3DiNOVoh4UMkub4sNlapCPZgCMLIzaB" +
       "a/b8obJOmMV62NlrdJtjqWiQDVCITouuKpCoQYybcg/qWmhGcU3digLFCmc9" +
       "Jsogyu91xot523Wkidqdif2QTpdtrcN4iyGGGUixrtNpQE8Wjc2Sa+SBgGKY" +
       "HUzSeOeLBmxH646kG92xteoKPjHdRtJK4NtgJMTUutuOPpHIxrCYjpAt7LmJ" +
       "OmrNe0NHj7f8JsXcVb0rRIMG46rNKQ1Zm1mULSICIkRtxRUNZJRAzYbftPaT" +
       "vY3DigUa8/4OAf8byFVSd5upGIkYPkL7u5FkzlcjeCwV3FzF0b4Z9ztWgrtU" +
       "IBhhPmq5Iw4s5eawBe2WmwG8yDlbr3NbEdMinQstT6M4UZx3ODxFCoafBTMP" +
       "E/bwbmXTseZ0RtEaDFfka3jBYuONyBZKONiL0sDVdJA1eeNUl9rzsOlY8LQw" +
       "BrtUjbkkmLcQU6CsRsMz8UEwiRekLipcisOtBSbMxBlhuhOtt2xHnNLC7LCr" +
       "kqRSEJK3Gvo2U6yjocZ3IW+uB21oQS/gNeXM+riz5FE7iPZxGsPtxthCl6JA" +
       "RWuAEmQsOIK2FU0M/H2jFtPQ9SVDRCw/KELE6EC5taeXTabfD9daHsP5fucA" +
       "U2nTjgfHjalqoIOpHS4tV/HjlmgSWIuctAsPSuKxihsIO5w2CyFvmDiO/3i5" +
       "vfCht7bD82i1mXV6iLm1sbJh8BZ2Ng5NT5fF86cb4NXn2uWDr/Mb4Ge7orVy" +
       "t+aJO51NVjs1X/j4K69q01+Brx7vJq+i2oOR5/+IrSe6fY7VvYDTC3felRpX" +
       "R7Nnu5y/8/H/+rjwE5sPv4Wzm6cuyXmZ5d8bv/bl/g+pP3+1ds/pnucth8YX" +
       "O714cafzeqBHceAKF/Y7nzid2cfKGXsSPK3jmW3d/vzktl5wpfKCg+3vslkf" +
       "3qUtLgs3qj1k6hHrqbI9ORZ9cOYu3vfaCDvPtKrY3aofc6wf8+ej3/0Vwf0n" +
       "m7TP3+k48XBweHwz4YT67SV12lKPNM85Oj5hLJs+fkLw9C3szCQ66geyv7HU" +
       "cOJp+gll4xbK0k3lNDqyHBmMH+gAvILy8OaItuxID046/mC1yVsSmjqQgtdV" +
       "4D2mrTfJC5udF52el9Mqkl5S//HsG1/9fPH6a4e9TEUO9ahWv9OFkVvvrJTH" +
       "is/f5Wj07CrBn/R/9I0//k/ih05i9W2npn2qtOQz4Jkem3Z62bQnuj58diIz" +
       "lqu2n6t4ffQujvnzZVEAx1QDXY70w+SVdT995pgf+T4c84my8gXw/Oyx9D/7" +
       "FhzzKgAsP/AiYDRdq1D4tk569UBcuVZZfKyi+vxdtP7lsviFqDqDSfQg4mXN" +
       "isPwrsaqzvQOxnr1bz/7+x999dn/UB2LPWCFohzggXmbuyLn+nz7tTe/+QcP" +
       "P/HF6ui48qQKpy5fsrn1Ds2FqzGV9A+dzu7jtWMHuXRTQv9zvbAAmDjlaacX" +
       "4OCtwvqTmxH/bwY6ONX83Jq6LI+XbE+OTs175fguwumJwReyK7XKxf7+HZzr" +
       "dG0/Xdav2bprRpvbjXaPdcCuv+Vnl/3uFO7OzpMI23P1Eo1O2g5XKSzv6PR+" +
       "FmjMbiv87iB8Ndi5JOF7rT6/dZe2L5XFb4IpU0u5DmrchfyN47Cugv9z32/w" +
       "vx88rx+75+tvJfjL1198q1H/5bvo9ZWy+OdR7cZx1E99vbqdcDt73694nq3L" +
       "7tlE/PZbmYgsqr3nbldsyvsC777l+t/hypr6xVdvPPCuVxf/+gAVJ9fKHmRr" +
       "DxixbZ8/3j33fs0PdMOq9HzwcNjrV1//Mqq96w6rNnD4w0sl/tcO9H8Y1W5e" +
       "pgeeU32fp/t3Ue36GR1gdXg5T/J1EDaApHx90z+JhA/cKYXAlTAKZDUqp61a" +
       "hU6PHi/MXHblYhJ8ap/Hvpd9zuXNz16A+eq25klmGnPHS//rrw4nH/lO+1cO" +
       "d2ZUWy6KkssDAJEP13dOs9un78jthNe1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("wfu++8ivP/j8yer+yEHgM+8/J9tTt7+gQjl+VF0pKX7zXf/wx/7Oq1+vTqn/" +
       "LwY7BJpGKwAA");
}
