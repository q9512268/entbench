package org.apache.batik.svggen;
public class SVGTexturePaint extends org.apache.batik.svggen.AbstractSVGConverter {
    public SVGTexturePaint(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 (java.awt.TexturePaint)
                   gc.
                   getPaint(
                     ));
    }
    public org.apache.batik.svggen.SVGPaintDescriptor toSVG(java.awt.TexturePaint texture) {
        org.apache.batik.svggen.SVGPaintDescriptor patternDesc =
          (org.apache.batik.svggen.SVGPaintDescriptor)
            descMap.
            get(
              texture);
        org.w3c.dom.Document domFactory =
          generatorContext.
            domFactory;
        if (patternDesc ==
              null) {
            java.awt.geom.Rectangle2D anchorRect =
              texture.
              getAnchorRect(
                );
            org.w3c.dom.Element patternDef =
              domFactory.
              createElementNS(
                SVG_NAMESPACE_URI,
                SVG_PATTERN_TAG);
            patternDef.
              setAttributeNS(
                null,
                SVG_PATTERN_UNITS_ATTRIBUTE,
                SVG_USER_SPACE_ON_USE_VALUE);
            patternDef.
              setAttributeNS(
                null,
                SVG_X_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getX(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_Y_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getY(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_WIDTH_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getWidth(
                      )));
            patternDef.
              setAttributeNS(
                null,
                SVG_HEIGHT_ATTRIBUTE,
                doubleString(
                  anchorRect.
                    getHeight(
                      )));
            java.awt.image.BufferedImage textureImage =
              texture.
              getImage(
                );
            if (textureImage.
                  getWidth(
                    ) >
                  0 &&
                  textureImage.
                  getHeight(
                    ) >
                  0) {
                if (textureImage.
                      getWidth(
                        ) !=
                      anchorRect.
                      getWidth(
                        ) ||
                      textureImage.
                      getHeight(
                        ) !=
                      anchorRect.
                      getHeight(
                        )) {
                    if (anchorRect.
                          getWidth(
                            ) >
                          0 &&
                          anchorRect.
                          getHeight(
                            ) >
                          0) {
                        double scaleX =
                          anchorRect.
                          getWidth(
                            ) /
                          textureImage.
                          getWidth(
                            );
                        double scaleY =
                          anchorRect.
                          getHeight(
                            ) /
                          textureImage.
                          getHeight(
                            );
                        java.awt.image.BufferedImage newImage =
                          new java.awt.image.BufferedImage(
                          (int)
                            (scaleX *
                               textureImage.
                               getWidth(
                                 )),
                          (int)
                            (scaleY *
                               textureImage.
                               getHeight(
                                 )),
                          java.awt.image.BufferedImage.
                            TYPE_INT_ARGB);
                        java.awt.Graphics2D g =
                          newImage.
                          createGraphics(
                            );
                        g.
                          scale(
                            scaleX,
                            scaleY);
                        g.
                          drawImage(
                            textureImage,
                            0,
                            0,
                            null);
                        g.
                          dispose(
                            );
                        textureImage =
                          newImage;
                    }
                }
            }
            org.w3c.dom.Element patternContent =
              generatorContext.
                genericImageHandler.
              createElement(
                generatorContext);
            generatorContext.
              genericImageHandler.
              handleImage(
                (java.awt.image.RenderedImage)
                  textureImage,
                patternContent,
                0,
                0,
                textureImage.
                  getWidth(
                    ),
                textureImage.
                  getHeight(
                    ),
                generatorContext);
            patternDef.
              appendChild(
                patternContent);
            patternDef.
              setAttributeNS(
                null,
                SVG_ID_ATTRIBUTE,
                generatorContext.
                  idGenerator.
                  generateID(
                    ID_PREFIX_PATTERN));
            java.lang.String patternAttrBuf =
              URL_PREFIX +
            SIGN_POUND +
            patternDef.
              getAttributeNS(
                null,
                SVG_ID_ATTRIBUTE) +
            URL_SUFFIX;
            patternDesc =
              new org.apache.batik.svggen.SVGPaintDescriptor(
                patternAttrBuf,
                SVG_OPAQUE_VALUE,
                patternDef);
            descMap.
              put(
                texture,
                patternDesc);
            defSet.
              add(
                patternDef);
        }
        return patternDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1Zeczs1lX3+17emjTvJW2WhmZ/aUncfp7FnkWvLfXYHs9m" +
       "z3g8nsVAX73bM97Gy4zHJdBW6gKVSilJCCLNX62AKl2EqECCoiAEbdUKqahi" +
       "k2grhEShVGr+oCAKlGvPt78lihCMNHfu3Hvuufece87vnnvuS9+HzoQBBPue" +
       "vTFsL9rVkmh3bmO70cbXwt1ODxtIQaiphC2F4Qi0XVMe+8KlH/7o4+blHeis" +
       "CL1ecl0vkiLLc8OhFnr2SlN70KXDVsrWnDCCLvfm0kpC4siykZ4VRld70O1H" +
       "hkbQld7+EhCwBAQsAcmXgOCHVGDQ6zQ3dohshORG4RL6eehUDzrrK9nyIujR" +
       "40x8KZCcPTaDXALA4Xz2fwyEygcnAfTIgexbma8T+FkYeebX3n35d05Dl0To" +
       "kuXy2XIUsIgITCJCdziaI2tBiKuqporQXa6mqbwWWJJtpfm6Reju0DJcKYoD" +
       "7UBJWWPsa0E+56Hm7lAy2YJYibzgQDzd0mx1/98Z3ZYMIOu9h7JuJWxm7UDA" +
       "ixZYWKBLirY/5LaF5aoR9PDJEQcyXukCAjD0nKNFpncw1W2uBBqgu7d7Z0uu" +
       "gfBRYLkGID3jxWCWCHrgpkwzXfuSspAM7VoE3X+SbrDtAlQXckVkQyLonpNk" +
       "OSewSw+c2KUj+/N99u0fe6/bcnfyNauaYmfrPw8GPXRi0FDTtUBzFW078I6n" +
       "es9J937pIzsQBIjvOUG8pfm9n3vlXW996OWvbGl+4gY0fXmuKdE15VPynd94" +
       "E/Fk/XS2jPO+F1rZ5h+TPDf/wV7P1cQHnnfvAcesc3e/8+Xhn83e9xntezvQ" +
       "xTZ0VvHs2AF2dJfiOb5lawGtuVogRZrahi5orkrk/W3oHKj3LFfbtvZ1PdSi" +
       "NnSbnTed9fL/QEU6YJGp6ByoW67u7dd9KTLzeuJDEHQOfKE7wPfN0PaT/0aQ" +
       "iZieoyGSIrmW6yGDwMvkzzbUVSUk0kJQV0Gv7yEysP/F24q7VST04gAYJOIF" +
       "BiIBqzC1bScSrgxDcxF+TI+ANwEPGUjAfnczi/P/H+dKMrkvr0+dAlvyppOA" +
       "YANfanm2qgXXlGfiBvXK5659befAQfY0FkFvARPubifczSfc3U64e2JC6NSp" +
       "fJ43ZBNvtx1s2gK4PwDGO57kf7bzno88dhrYm7++DWg8I0Vujs/EIWC0c1hU" +
       "gNVCLz+/fv/4Fwo70M5xoM0WC5ouZsMHGTwewOCVkw52I76XPvzdH37+uae9" +
       "Q1c7htx7CHD9yMyDHzup1sBTNBUo5ZD9U49IX7z2paev7EC3AVgAUBgBfWUo" +
       "89DJOY558tV9VMxkOQME1r3Akeysax/KLkZm4K0PW/L9vjOv3wV0fHtm2g+A" +
       "71N7tp7/Zr2v97PyDVv7yDbthBQ56r6D9z/513/+T+Vc3fsAfenIkcdr0dUj" +
       "oJAxu5S7/12HNjAKNA3Q/d3zg1999vsf/uncAADF4zea8EpWEgAMwBYCNX/w" +
       "K8u/+fa3PvXNnUOjicCpGMu2pSQHQmbt0MVbCAlme/PhegCo2MDZMqu5IriO" +
       "p1q6Jcm2llnpf156ovjFf/nY5a0d2KBl34ze+uoMDtvf2IDe97V3/9tDOZtT" +
       "SnaoHerskGyLlK8/5IwHgbTJ1pG8/y8e/PUvS58EmAtwLrRSLYeuU3uOky3q" +
       "ngiCb+GYe0jqBXvneb7RSD7yqbzczZSU84PyvnJWPBwedZjjPnkkYLmmfPyb" +
       "P3jd+Ad/9Eou4fGI56h9MJJ/dWuSWfFIAtjfdxIdWlJoAjr0ZfZnLtsv/whw" +
       "FAFHBSBd2A8ANiXHrGmP+sy5v/3jP7n3Pd84De00oYu2J6lNKXdM6ALwCC00" +
       "Aawl/k+9a2sQ6/OguJyLCl0n/NaQ7s//nQYLfPLmmNTMApZDt77/P/q2/IG/" +
       "//frlJCj0Q3O6RPjReSlFx4g3vm9fPwhLGSjH0qux2sQ3B2OLX3G+dedx87+" +
       "6Q50ToQuK3uR41iy48zZRBAthfvhJIguj/Ufj3y2x/zVA9h700lIOjLtSUA6" +
       "PCdAPaPO6hePYtCPwecU+P539s3UnTVsz9u7ib1D/5GDU9/3k1PAw8+Udqu7" +
       "hWw8nnN5NC+vZMVbttuUVX8SQEGYh6xghG65kp1P3IiAidnKlX3uYxDCgj25" +
       "Mrer+35zOTenTPrdbdy3BcGsRHMWW5Oo3tR83r6lyk+7Ow+Z9TwQQn70Hz7+" +
       "9V9+/NtgTzvQmVWmb7CVR2Zk4yyq/tBLzz54+zPf+WiObMClB89Rl9+VcWVv" +
       "JXFW0FnR2hf1gUxUPg8MelIYMTkYaWou7S1NeRBYDsDs1V7IiDx997cXL3z3" +
       "s9tw8KTdniDWPvLML/1492PP7BwJwh+/Lg4+OmYbiOeLft2ehgPo0VvNko9o" +
       "/uPnn/6D33r6w9tV3X08pKTAjemzf/lfX999/jtfvUHUcpvt/S82Nrr9D1to" +
       "2Mb3P73iTCqthWIygeMyumrM4bY86RL4pO8xNO+ylE2KbECrrjULBq2uajeC" +
       "0jJdpVGqtkRLjZVUCVXN6fJNnrZ5Xxp22py1MqeF4biN+dRYGpRGGBHwi5LF" +
       "UiVTEOOWE8hLt1rh1j7CWUG1v9IHSmlcHCEub2vapo5hWJrCYRWrVZvLyrzB" +
       "2BSSyEtiUdo0KCsWsbjuy02fotXJWhTKpETJcGIifbeXwktMHCkqhxr1mRCS" +
       "QjxDV6GAOs6EZD2j4stkP9yEHDr0VvhYEtlZ0knJETkt0CpvTxy2uVw6m004" +
       "Y80pQazrJuNxVcbp2o4syPQUnzGysOmUBdNi6521TeOeOfZtY4NSRDnoNb0N" +
       "jc3NiBEbLgNulH0vcEOaS8ciyy/DCc1bssRxxagt1cQeZXd7LVuIa0oxYVrC" +
       "YDh2Ki3YroqMPEqmkjl0JzO7UHaa5NCx+ImnFIad2VQyIrpOW7aU1FtToVno" +
       "Bpw3ZFKeq3nDbrvJEZ5YgfHhNNTn02FV63ptdWi2lirdXTEsI/OYi7vNjlWp" +
       "yGzHSmuE6chOxapNjCov6pMaolLDiV7maVXXq2bdRARPnonFrrwUymugiA1h" +
       "iLjIEIYverZP8mFXmIicuUb77qbrWPNxsaCPS35l6qggjCHw1qDXSjk/5ATG" +
       "YGWDVxtsvT9xJq1KJR5TQs9FaLctpV4/Ls/oeO7JVZg0PKfZMGelWZ+DNxgP" +
       "LwdL2bPQpVkzJWS+brM4TsWy5XFjslkXVjPMxFtCpS11zAFfZzmd9DW+ETEE" +
       "To2GzYAVzc2kyIStGostnKY3Fbm4Kqwb41m4bjQRQmhqwqiFEz1kTK8ao01a" +
       "H5MahgJ1Ihy6MWitKLWB3dcDtNPUxWZzsRm2RngHQ4kkbAnAQqqR3k+KLaJt" +
       "Vdsh109nMKzFZdidlntyahQqlRU3ovkB5ds2hq9EVtRXNFuEp0lZH86ZYq8j" +
       "VFeFJF1Mxr5akrwh3vRjt9TXyZ4/4rEBEie9eRVrI6bfskYtoduIpemMQys+" +
       "wbZtoTiLUbc/p5J2zZtJFl1hrMBJivho1VUFd2TNqaqjDFVjtox0SugyJuL1" +
       "O0pIEM7GaFQrS42pJmXLthurjuJxS6PTi7huMZUXCMOPvFlHYNo+tZ73JmO1" +
       "xBWWcqOuKf2maJK9ljmddWaSYMoWUgc4gPXKvC+aTkJwC6fldLhkKPBk36dH" +
       "LKYDFKnM+lUMpuV2m+En/XZ5ww/6Ax+xm1NLW8LqvDbFO1OVwgWanJK+IeFe" +
       "wiAdUSuNVpGobOTUbSTmgIqGJumuuw1eUA3BMJm+0R1RM8prmuxGjvtES9bI" +
       "Aoo1YGMAR05Fh8OgUVIHdXXYWKk9VOsxWCcqTgWvTuGdNFmnNWPaK9Q1Hdaj" +
       "pB0lTVzxNkK7ToD4kmvaQ4VeSiAMpYxJedw1atqQWhaJQm+sS6StAMghfaQW" +
       "sWaL7ivYei3h3R5ay5CxmVJcqtWXOhtrMMsAaELKVqO50GzXrPV9NRG8fntQ" +
       "HAYFaZzWLNJBiAA4jUbPrLm2wG2ObtPVuG0UE20scLMFl6CeUixJnEYrs6GU" +
       "JEul1qFKa8NxmcaGscpkQMGlsoHaQi0sBybtDkejUYrJpG7XE9QdtFxm2OM4" +
       "bwBj3WkAr8ZIDeYxU17W4KgtdOFkaHKbJoOG60pD9wsNgkLlYZtQe7W6nVbT" +
       "Kiu4c2+O4qgXFTmuXxuE3qxBoxST1uDGqlVGEHWY6NqcU5JNBfdKRdeTC0t4" +
       "4a6VzljkFqGKhQ0EZ/HixhV0dk0xlWF3Ignl5qSdJh0kckoqiIn1crwpzxYk" +
       "KUg1hvUxZS034H5hXmHpciuoap36nBKb2AjHwqaIY1ywLqAkFjrTmKx2O6VK" +
       "GLfkAB6k+GCBh5hU4fHhJok2NUyMAGYS/eaUbDSmPVJlww6qWdVE8DvlPmIN" +
       "zV5t0ZnL6aRGjuemuXGZTZGo21hX15DpvIjOaqvpkJHsuaqgujFLyqM2Idhw" +
       "qegR9XlxqJBLPOB6XFku1irMKiqt2ixKGmSLFvCJsyIatBHawmTE18tcnWkO" +
       "9Mira9VFH6jMNGnREIe1iTWzpTbRb4+5htBTqVW5X6OS1jots0twLpmEplXI" +
       "uTqpx1W17ehkC/XqVT2Yu3Eh1C2hUWg7cD0uprWSIq6MMkZZdn0eMd1mu9pl" +
       "DHRRKtI+McTZIirTKV8LKKIaK+Mlna565MqUq0W4isDFGjzCylVE9KdSQWkz" +
       "Gjg7MM+YLMxFayGGwaJVV+q00ZCiYhWbBqpZg0OpUqB0peIHa2lB1iW63rXw" +
       "YoJUeRgpYOs4jVDSoTd92gp6tfJq3mQRdbXAYHAAySNc73brwbBWGJMzkSCF" +
       "TrPBqRI6aRUX0TrQdRUuR2V6XFf6xdJUjqv9ZWdicZ7ul7xoPhm5I7mv0sl8" +
       "EJZGMFPwNyvU9tejWs2iikyAkdEU5svEbCY5eNNAZ+4sNrrGgMLD0pj31fIG" +
       "ndcRfrQarWAV2czxGmPBVEsXozVfaUdKu4SypoOp08FkEiw3fTmiNu4gNceh" +
       "1xYwcT0lrHmtSJEjDTViiiqXgolTLRYrmIBPLZZtodpKHQIY1tRCpwcXiqys" +
       "hMiIkwujOSrWjcmyucBKCUsUxvU+zkhLwd4sI6JU5Jqrrllt0drS93hVEDW1" +
       "We2ElXp7Y9Yto05TaG1dHqUkIRB9h7RX7WGnaTpLPOnBmtepDKO6uIHn5ESb" +
       "j7zGBvd5XMeW5NCwPH5ZGEbobBI75YXZYFl5EzRYHZ+uFcYsrQx2gXW0KWmi" +
       "FUUrpb3UqC8qqZkI4wScTGTI9mF4bJViflaeF/W5oRXKxSDlw/k0bthwK4Qp" +
       "o6NKrbbLzAx/tZH6QAmN0cRg69NVq26mlQlYtaoZQidpMMKaK8UDk6kaqUeN" +
       "YrMtGwOx3bXXBhfB/LBbS+3BfF4lIwTZkJMu71mKgY50Po42jOn23NIstVsV" +
       "d2QuaYFhBVZtS9zMHvdj4N8lftNiuRiLoumoGC9SqmnMQdzaC5D1BGfJYplZ" +
       "JXh7UzXoqVYa1PyK7OmV7mjdHKdWi+sx65GCDtMmYmjcFJYLq0ZoDeHFsmQ0" +
       "V5FdRMyau0KqWqM7nJQUmSx3vLAPh9PFiixbXWITkREKYic00cgKW4VRHlng" +
       "etoT+tpSS0c6ZpYHbcLR4p4P7vt13pb1pU3gbBcEJbXe0EQWdaBmrS0o5Frx" +
       "BzwyNOMQnxkCiNbfkYXx117bTequ/NJ48HIALlBZR+c13CC2XY9mxRMHyan8" +
       "c/Zktvlocuow+wBlt6IHb/YgkN+IPvWBZ15U+58u7uxlbcQIuhB5/ttsbaXZ" +
       "R1jtAE5P3fz2x+TvIYfZhC9/4J8fGL3TfM9ryKs+fGKdJ1n+NvPSV+k3K5/Y" +
       "gU4f5Baue6k5Pujq8YzCxUCL4sAdHcsrPHig2TdmGnsIfGt7mq3dOLd5Qys4" +
       "lVvBdu9PJMVeNcmWaVNaR7tGSd2lA8k3Dx7Ncn7xLZJsm6wAl9MzkceP6f0p" +
       "nrhFHo/UQiWw/P1ns9wIl692jT06bd7gHGgtUxj0OPg29rTW+D/R2j15wiPT" +
       "0tEXgnzkB2+hn1/Mived1M9Tt9BPzvdGSnr/a1FSEkGXTrxmZKnZ+697Qt0+" +
       "+ymfe/HS+fteFP4qT+gfPM1d6EHn9di2j2bFjtTP+oGmW7mcF7Y5Mj//+UQE" +
       "3XcTCbMUV17JV/wrW/pnI+jySXqgsvz3KN3zEXTxkA6w2laOkvxGBJ0GJFn1" +
       "BX9f3W+9mbpxOYwCSYmApoDBr7Qg0oLk1HEAO9D/3a+m/yOY9/gxpMqft/dR" +
       "Jd4+cF9TPv9ih33vK5VPb98iFFtK04zL+R50bvsscoBMj96U2z6vs60nf3Tn" +
       "Fy48sY+id24XfGj5R9b28I0T/5TjR3mqPv39+3737b/54rfyTN7/AN1qxxV3" +
       "IAAA");
}
