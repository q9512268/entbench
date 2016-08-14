package org.apache.batik.bridge;
public class SVGFontElementBridge extends org.apache.batik.bridge.AbstractSVGBridge {
    public SVGFontElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FONT_TAG; }
    public org.apache.batik.bridge.SVGGVTFont createFont(org.apache.batik.bridge.BridgeContext ctx,
                                                         org.w3c.dom.Element fontElement,
                                                         org.w3c.dom.Element textElement,
                                                         float size,
                                                         org.apache.batik.gvt.font.GVTFontFace fontFace) {
        org.w3c.dom.NodeList glyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_GLYPH_TAG);
        int numGlyphs =
          glyphElements.
          getLength(
            );
        java.lang.String[] glyphCodes =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphNames =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphLangs =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphOrientations =
          new java.lang.String[numGlyphs];
        java.lang.String[] glyphForms =
          new java.lang.String[numGlyphs];
        org.w3c.dom.Element[] glyphElementArray =
          new org.w3c.dom.Element[numGlyphs];
        for (int i =
               0;
             i <
               numGlyphs;
             i++) {
            org.w3c.dom.Element glyphElement =
              (org.w3c.dom.Element)
                glyphElements.
                item(
                  i);
            glyphCodes[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_UNICODE_ATTRIBUTE);
            if (glyphCodes[i].
                  length(
                    ) >
                  1) {
                if (org.apache.batik.gvt.text.ArabicTextHandler.
                      arabicChar(
                        glyphCodes[i].
                          charAt(
                            0))) {
                    glyphCodes[i] =
                      new java.lang.StringBuffer(
                        glyphCodes[i]).
                        reverse(
                          ).
                        toString(
                          );
                }
            }
            glyphNames[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_GLYPH_NAME_ATTRIBUTE);
            glyphLangs[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_LANG_ATTRIBUTE);
            glyphOrientations[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ORIENTATION_ATTRIBUTE);
            glyphForms[i] =
              glyphElement.
                getAttributeNS(
                  null,
                  SVG_ARABIC_FORM_ATTRIBUTE);
            glyphElementArray[i] =
              glyphElement;
        }
        org.w3c.dom.NodeList missingGlyphElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_MISSING_GLYPH_TAG);
        org.w3c.dom.Element missingGlyphElement =
          null;
        if (missingGlyphElements.
              getLength(
                ) >
              0) {
            missingGlyphElement =
              (org.w3c.dom.Element)
                missingGlyphElements.
                item(
                  0);
        }
        org.w3c.dom.NodeList hkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_HKERN_TAG);
        org.w3c.dom.Element[] hkernElementArray =
          new org.w3c.dom.Element[hkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               hkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element hkernElement =
              (org.w3c.dom.Element)
                hkernElements.
                item(
                  i);
            hkernElementArray[i] =
              hkernElement;
        }
        org.w3c.dom.NodeList vkernElements =
          fontElement.
          getElementsByTagNameNS(
            SVG_NAMESPACE_URI,
            SVG_VKERN_TAG);
        org.w3c.dom.Element[] vkernElementArray =
          new org.w3c.dom.Element[vkernElements.
                                    getLength(
                                      )];
        for (int i =
               0;
             i <
               vkernElementArray.
                 length;
             i++) {
            org.w3c.dom.Element vkernElement =
              (org.w3c.dom.Element)
                vkernElements.
                item(
                  i);
            vkernElementArray[i] =
              vkernElement;
        }
        return new org.apache.batik.bridge.SVGGVTFont(
          size,
          fontFace,
          glyphCodes,
          glyphNames,
          glyphLangs,
          glyphOrientations,
          glyphForms,
          ctx,
          glyphElementArray,
          missingGlyphElement,
          hkernElementArray,
          vkernElementArray,
          textElement);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DcPm9MBN7nnD4Am6xB7WfwFC5LXE/hUAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ZecwrV3Wf9728lZD38gJJmpL9hTYxfDNjezx2H0vGy4zH" +
       "ns32eJsWHrN6xp59scemKRCJgkCiEYQUJMhfoLYoLKqKWqmiSlW1gECVqFA3" +
       "qYCqSqWlSOSP0qq0pXfG3/4WFLWqJV9f33vOuWe7v7u99EPoTBRCBd+z1zPb" +
       "i3f1NN6d29huvPb1aLfDYIIcRrrWsOUoEkHbdfWxL1368U+eMy/vQGcl6B7Z" +
       "db1Yji3Pjfp65NlLXWOgS4etLVt3ohi6zMzlpQwnsWXDjBXF1xjoNUdYY+gq" +
       "s68CDFSAgQpwrgJMHFIBptfqbuI0Mg7ZjaMA+jXoFAOd9dVMvRh69LgQXw5l" +
       "Z0+MkFsAJJzP/o+AUTlzGkKPHNi+tfkGgz9egJ//zXde/t3T0CUJumS5g0wd" +
       "FSgRg0Ek6E5HdxQ9jAhN0zUJutvVdW2gh5ZsW5tcbwm6ElkzV46TUD9wUtaY" +
       "+HqYj3nouTvVzLYwUWMvPDDPsHRb2/93xrDlGbD13kNbtxaSWTsw8KIFFAsN" +
       "WdX3We5YWK4WQw+f5Diw8WoXEADWc44em97BUHe4MmiArmxjZ8vuDB7EoeXO" +
       "AOkZLwGjxNADtxSa+dqX1YU806/H0P0n6YRtF6C6kDsiY4mh158kyyWBKD1w" +
       "IkpH4vND7i0febfbdndynTVdtTP9zwOmh04w9XVDD3VX1beMdz7FvCDf+5UP" +
       "7kAQIH79CeItze//6itPv+mhl7+2pfn5m9DwylxX4+vqZ5S7vvWGxpO105ka" +
       "530vsrLgH7M8T39hr+da6oOZd++BxKxzd7/z5f6fTd/7Of0HO9BFGjqrenbi" +
       "gDy6W/Uc37L1kNJdPZRjXaOhC7qrNfJ+GjoH6ozl6ttW3jAiPaahO+y86ayX" +
       "/wcuMoCIzEXnQN1yDW+/7suxmddTH4Kgc+AL3Qm+j0DbT/4bQw5seo4Oy6rs" +
       "Wq4HC6GX2Z8F1NVkONYjUNdAr+/BCsj/xZvRXRyOvCQECQl74QyWQVaY+rYT" +
       "VkJLm+nwYESRwFkZWuhuXM8bd7O08/+/B0wzD1xenToFgvOGk9Bgg1nV9mxN" +
       "D6+rzyf11itfuP6NnYOpsue7GHoTGHV3O+puPurudtTdm40KnTqVD/a6bPRt" +
       "FoAYLgAaAJy888nBOzrv+uBjp0H6+as7QAAyUvjWcN04xA86R0kVJDH08idW" +
       "7xu9B9mBdo7jbqYxaLqYsQsZWh6g4tWT8+1mci994Ps//uILz3iHM+8YkO8B" +
       "wo2c2YR+7KRvQ0/VNQCRh+KfekT+8vWvPHN1B7oDoARAxlgGmQxA56GTYxyb" +
       "2Nf2QTKz5Qww2PBCR7azrn1kuxibobc6bMmDfldevxv4+DVZpj8Mvk/spX7+" +
       "m/Xe42fl67ZJkgXthBU5CL914H/6r//8n0q5u/fx+tKRFXCgx9eOYEQm7FKO" +
       "Bncf5oAY6jqg+7tPCB/7+A8/8Mt5AgCKx2824NWsbABsACEEbn7/14K/+e53" +
       "PvPtncOkicEimSi2paYHRmbt0MXbGAlGe+OhPgBjbDDtsqy5OnQdT7MMS1Zs" +
       "PcvS/7z0BPrlf/nI5W0e2KBlP43e9LMFHLb/XB167zfe+W8P5WJOqdkad+iz" +
       "Q7ItcN5zKJkIQ3md6ZG+7y8e/ORX5U8DCAawF1kbPUcyKPcBlAcNzu1/Ki93" +
       "T/ShWfFwdDT5j8+vI3uR6+pz3/7Ra0c/+qNXcm2Pb2aOxpqV/Wvb9MqKR1Ig" +
       "/r6TM70tRyagK7/M/cpl++WfAIkSkKgC/Ir4EIBNeiwz9qjPnPvbP/6Te9/1" +
       "rdPQDgldtD1ZI+V8kkEXQHbrkQlwKvXf/vQ2uKvzoLicmwrdYPw2Ke7P/50G" +
       "Cj55a3whs73I4RS9/z94W3n27//9BifkyHKTJfgEvwS/9KkHGm/7Qc5/OMUz" +
       "7ofSGwEY7NsOeYufc/5157Gzf7oDnZOgy+repnAk20k2cSSwEYr2d4pg43is" +
       "//imZruCXzuAsDechJcjw54El0PgB/WMOqtfPIonPwWfU+D739k3c3fWsF1K" +
       "rzT21vNHDhZ0309Pgdl6priL7yIZ/9tzKY/m5dWs+IVtmLLqL4JpHeW7UcBh" +
       "WK5s5wM/HYMUs9Wr+9JHYHcKYnJ1buO5mNeD/XieTpn1u9st3RbQsrKYi9im" +
       "BHbL9PmlLVW+ct11KIzxwO7ww//w3Dd/4/Hvgph2oDPLzN8glEdG5JJsw/zr" +
       "L338wdc8/70P5ygFIEp4oXX56UwqczuLs6KVFeS+qQ9kpg7y5Z6Ro5jNgUXX" +
       "cmtvm8pCaDkAf5d7u0H4mSvfXXzq+5/f7vRO5u0JYv2Dz3/op7sfeX7nyP76" +
       "8Ru2uEd5tnvsXOnX7nk4hB693Sg5B/mPX3zmD3/7mQ9stbpyfLfYAoehz//l" +
       "f31z9xPf+/pNtiF32N7/IrDxnc+1yxFN7H8YdGqMV8M0HRt8qarMNlXCQejV" +
       "lFotqFJn0q8zQ7AAEdMiL0al4ro9TFAE27haYiRkAsdMGG9qseM3kH7cG/Ub" +
       "w0l9MJ5N4L7UK9IWFVDhKCD1QTCSWE/stxB5yZudoFSpFxbt4XLmKouJUmNL" +
       "LJ6U9JKPinDg2EV0KSzbiw2Ol4wCjpQ0eDEOwjqLUtJMVKcm76i9btq3cZSM" +
       "xgsxGSqkPVdJT2yGuA+z7sjFFHUd0F3L6CXmoFi3RtFCrJABQ6MzZRo4i3Ha" +
       "McnQqjekcGrJaYNxml25Gy6Ks/nUQxdNadgfMZ7XKIudeYPf9Mwg7QzkwTxt" +
       "rqeNeNbtxK1JRWabNa7QqRteM2lULFFz2uxEYTEF4Xlpind8bVMAQhSaFdfN" +
       "VeoEAU/R07idhLRdpHCvYqN9lLI6EjUPnJJTxcvOfAHP6FLMoCpcdbQOynIl" +
       "ohRGsuLbndibg2CMijrdbrVR3LGWg5gZq0YfHdWlurzZNEhm1HZbpWZELaac" +
       "O4k0eTKrUUnHXrilCrdSK44VcI1+kab9ItaI0oh2xdj3PGHDeUFXLuKTVTpm" +
       "oppUQUTFL3TEQpVnSrgbTaeGHbQrjdFgKXeFiK/T6iyinVah3lt4ZRHZeIs1" +
       "MtB7NCLX2+uhQ/hje7LAi4vieBH3Vpse0Woz+mo1TesiU3Er64TucKYjWYPA" +
       "2biblpkOa2511OgP3ZUmOSgqmdN+VamvuJAUramjNghhEncKysBa99N2YRCv" +
       "uXAKN4nuKm74nNwKBWU0TqZ9kxB7tNWN5UF51CJcbNpCep5GU+Y67Ix6azeN" +
       "p9RC7iAO6y3QQiJbUyJYyPjMKprdLmfMqaQhd5FiX7XFUpo0+0i5hs/H4WrU" +
       "J9hy1EJsG0OrTQv1axYi0TN/1qouiCjkk65A88pkg4h9wmpxcNAy1bWwLCn4" +
       "SizG60qVcQYoKdHKPC2brWmtaxeYMKzBfcQIKLYtCzLSKJJ1ERZUH7OHk8Th" +
       "ixGBbESXY5jOosljgtANQyytzoxVbFFee9gdLwJsgZS7Zh+JecozmU2Do2hr" +
       "4PTrKMEhek8X5gUiSIia55itOVF2W6ZsEhVTxYb8iF9WjUmnR5BqSsZGI5EJ" +
       "V9NFdSUa7VJIt3qBRwuBJwiaJRYKTY2sTOpdEWNXdthw5LZXlpOQNUypt5m7" +
       "rZmrStIMqbUJoyrWCjiH92CFX0itFSGhEbqgCDYYLvqsmfAObWkdvS1WB/Vq" +
       "2YJbTUQ3TcE0ragpFEpp7Dg9Y7xZTRutTorD3GDWsxW0UvHZTcdCnCZYqeHE" +
       "LnaihmalI4Wr9WNCKzanttYrbSYLboaOqHRCEvPVRpRXpd6wS9OKCNQg0tJY" +
       "89BqjXfHTtjbzKTqetxbNaaVbqVRjcU54inNmtj2q8tx3x7HS1Qp9/otcmbP" +
       "rWEH16iYN0YNsm2JJGKxfn0YjEOTpeSy1kY8fVZBDKpdRAWrs4G5jU45Rlde" +
       "EanDMF55HaloghRqfM3h8AqS1mpqMpbqGsrBzKpS9gfwzB+zYi2sesZQaWN8" +
       "JU64yTSoJsC2Pi8Rw1ZTIBcggrpcKghGp+xrS1OmJIbrWyrCIsgodoa9yhrl" +
       "qEkQFcp0iq7mRq1K0CO82XIQxWiG0YYXDIVRpClbHc9GFEVJ1dGSkKqyNigX" +
       "WGwJh10hqUU+CY91fl7rygw4EfvWurPAqPmg3EqRtNHjywJZYVwXx1DdZ+bN" +
       "db9IxsnKFVF81vFmJt90FBwrwBwiCPgc0eImydBD2Z3azQQTOEp1qaGOBP15" +
       "V00Kat2yWbOS2kHRhPtEZ9TtRWRqK8SiMNJqaQ2bwG4l6el1wuy32n03KozL" +
       "LRwO3WaFHyjzShFR58O6JY2maFEHE6YZ12Tc6VXkDlabYVGgJYpQSmR4Zo2I" +
       "+mwyTKQOltItQ62XFxQ+r0UGFtVqy3DRLnYFrerRsIBXq+GozupLJp7XdN4o" +
       "bVBuXosNC7bnxnDGhR655Kw5vVoGYzhtIeVCTLJzLd5sEJnmKwahIqJXpxr6" +
       "XKTmcr2Cd7A107C7lVAvwIulE+iJXSFn7Yo/0gab0lTCFgGh9ECqDhFKHPOC" +
       "NWvwWMSJKznpOt6qPXc2xRJJ18YKGLaEG6kwdjGkLDh2c2N5dTooFtklJuDL" +
       "qbdO2swSm1QGNX3iirYsNvuozdTqeoFj5sU0afRATLSJRpBcQRzjJBoOyBJc" +
       "wtEC4Nuk8wFDerQSpCESOAMqkKrVmcI48xk7bOvG0mbjZoFaxza+KaCBXOmt" +
       "Oo6DmgxSIseyu0SUpaC0JhtdMMQFqvUNdsmW3C4Dd9urVDcSgWYSx6f56qw+" +
       "WEy0Do5ZeFBjPI4Te904ihR2anEhP9koakDGU4sMTbWW8PgAt3Bu3hqJC75r" +
       "DBF7vFaLg1EitotUd+AxM7dmDzBT61lRWeoqZVohF2qxgmFNz126LWM5nbZA" +
       "JMvLwrgz3szoelVfk+4Qpxp4EZe9QqGiDceBvykQXcMrd9PKmh/Oi3yFCqMK" +
       "1povJayzKVTEXtjVm7EbN7FkwHMoVvWamrlQN+o0psTBkMPGLoXH4yXXrapw" +
       "cTKCWxzfRrHIkurVYj2o1mKh4GwovjIOxlxzsdD7jLPouAjKlamyNBLKgyrh" +
       "woVVE2Ypqtg0VMINotFyiSuuXtwQU3UySFTb5bk1VUUE0awxrLEcmGyVq3EG" +
       "yyw2PCOJiOCSs7FpEUt149G43da5hO111NpsbutDNap6idGaGJtBxAjwsrBK" +
       "nNlcH+lr16PaGqeWCR5bhoKEl6QUjYIaCdewsr1cNlv8nKMbAYv5a6HFUpiw" +
       "XoQhvVaHVbXUTAynwBQDyRW6PR+ksMKR1ZGsejLVmjVSpNNOWU3q9wqIOWHd" +
       "Yddxu22MHaJDz5n1GmtNLfOKHCO4MB0rsVfQl5rvVEZeD287LjYuiL0h3KNN" +
       "JoKBl10UXdfo+bKgcjKPWeOV7olOf4jqnBpW2LApsQuSwgJ3MK/Wl9VKf0Qy" +
       "jQFv8im7hAXCNY1Vaca4IKsJDk6KI35VKmj8iLAn89Ty13ZApK0in5SaqjF3" +
       "5WHVmM3WxWl/TMQr2+j0OLIj4W1P59x02BZLJcORdAfuqGa9qkpVLeqp7GaA" +
       "yO22soFXLmWpnf5EAGuBAfxQ8zxDINWW1lGGWGKFOF8oRDruOCvECfsgana5" +
       "WNLpOtYCi/2UbE5xPgpCQ1JV2E38HjcpbXxR77H0tE+TLNkMfF4rUUZrXmcG" +
       "DiXPe4vs+N7zYsKplZMiMLc9iduFKum4s1Aaa8VK0QunMYMFhVq7VVbS5aAR" +
       "UENitKp7C75Mgv15YvLjYmvQ5JxJ7E/S5Zi1l1Ff7peazFhC56UlpSVzudSw" +
       "cL3VLpCjjlIeD4dJlEpTE3OKDiKvx2ASe4rp6mOd643dBlFeWsiQaqqCU2Pr" +
       "HO66zTLhVNI6PjZWZANjJi3YHIIDyFvfmh1N3vHqTod35wfhg4cOcCjMOtqv" +
       "4lS07Xo0K544uDzLP2dPXo4fvTw7vFGBspPeg7d6v8hPeZ959vkXNf6z6M7e" +
       "TdQkhi7Env9mW1/q9hFRO0DSU7c+0bL5883hDclXn/3nB8S3me96Ffe+D5/Q" +
       "86TI32Ff+jr1RvWjO9Dpg/uSGx6WjjNdO35LcjHU4yR0xWN3JQ8eePZK5rGH" +
       "wLew59nCze9eb5oFp/Is2Mb+Nhd90W36kqxwY+jOmR4znirb3J7q7cN08X7W" +
       "Ifqo0LxhcWDfvfvZcm3Pvmv/N/adyQnO7F/wPHGrJ4jto8Pe6+U+9T0Z9aqk" +
       "7mqes7v3OpF1PZsTDI5MkXF202R7cnzrgWbLeNcA8nepkZi9dpCyqucqv+c2" +
       "bv9QVmxi6KIa6nKsZ3z7Izx2m9eUvSEOQ/PuVxOaNIZed7Mnmex++f4bnoW3" +
       "T5nqF168dP6+F4d/lb9KHDw3XmCg80Zi20evA4/Uz/qhbli5pRe2l4N+/vOx" +
       "GLrvFubF0NltJVf7o1v6F2Lo8kl6EJH89yjdJ4EnD+mAqG3lKMmnYug0IMmq" +
       "n/b3ff3krXxNKFEcymoM3LX1UXrqOMQdRODKz4rAEVR8/BiW5e/1+7iTbF/s" +
       "r6tffLHDvfuVyme3rymqLW82mZTzDHRu+7BzgF2P3lLavqyz7Sd/cteXLjyx" +
       "j7N3bRU+nHFHdHv45k8XLceP88eGzR/c93tv+a0Xv5PfX/4PgJasjEghAAA=");
}
