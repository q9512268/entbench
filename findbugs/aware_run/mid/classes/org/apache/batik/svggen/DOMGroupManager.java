package org.apache.batik.svggen;
public class DOMGroupManager implements org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    public static final short DRAW = 1;
    public static final short FILL = 16;
    protected org.apache.batik.ext.awt.g2d.GraphicContext gc;
    protected org.apache.batik.svggen.DOMTreeManager domTreeManager;
    protected org.apache.batik.svggen.SVGGraphicContext groupGC;
    protected org.w3c.dom.Element currentGroup;
    public DOMGroupManager(org.apache.batik.ext.awt.g2d.GraphicContext gc,
                           org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        super(
          );
        if (gc ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_GC_NULL);
        if (domTreeManager ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_DOMTREEMANAGER_NULL);
        this.
          gc =
          gc;
        this.
          domTreeManager =
          domTreeManager;
        recycleCurrentGroup(
          );
        groupGC =
          domTreeManager.
            gcConverter.
            toSVG(
              gc);
    }
    void recycleCurrentGroup() { currentGroup = domTreeManager.getDOMFactory(
                                                                 ).
                                                  createElementNS(
                                                    SVG_NAMESPACE_URI,
                                                    SVG_G_TAG); }
    public void addElement(org.w3c.dom.Element element) { addElement(
                                                            element,
                                                            (short)
                                                              (DRAW |
                                                                 FILL));
    }
    public void addElement(org.w3c.dom.Element element, short method) {
        if (!currentGroup.
              hasChildNodes(
                )) {
            currentGroup.
              appendChild(
                element);
            groupGC =
              domTreeManager.
                gcConverter.
                toSVG(
                  gc);
            org.apache.batik.svggen.SVGGraphicContext deltaGC;
            deltaGC =
              processDeltaGC(
                groupGC,
                domTreeManager.
                  defaultGC);
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                currentGroup,
                deltaGC.
                  getGroupContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            if ((method &
                   DRAW) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_STROKE_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            if ((method &
                   FILL) ==
                  0) {
                deltaGC.
                  getGraphicElementContext(
                    ).
                  put(
                    SVG_FILL_ATTRIBUTE,
                    SVG_NONE_VALUE);
            }
            domTreeManager.
              getStyleHandler(
                ).
              setStyle(
                element,
                deltaGC.
                  getGraphicElementContext(
                    ),
                domTreeManager.
                  getGeneratorContext(
                    ));
            setTransform(
              currentGroup,
              deltaGC.
                getTransformStack(
                  ));
            domTreeManager.
              appendGroup(
                currentGroup,
                this);
        }
        else {
            if (gc.
                  isTransformStackValid(
                    )) {
                org.apache.batik.svggen.SVGGraphicContext elementGC =
                  domTreeManager.
                    gcConverter.
                  toSVG(
                    gc);
                org.apache.batik.svggen.SVGGraphicContext deltaGC =
                  processDeltaGC(
                    elementGC,
                    groupGC);
                trimContextForElement(
                  deltaGC,
                  element);
                if (countOverrides(
                      deltaGC) <=
                      domTreeManager.
                        maxGCOverrides) {
                    currentGroup.
                      appendChild(
                        element);
                    if ((method &
                           DRAW) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_STROKE_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    if ((method &
                           FILL) ==
                          0) {
                        deltaGC.
                          getContext(
                            ).
                          put(
                            SVG_FILL_ATTRIBUTE,
                            SVG_NONE_VALUE);
                    }
                    domTreeManager.
                      getStyleHandler(
                        ).
                      setStyle(
                        element,
                        deltaGC.
                          getContext(
                            ),
                        domTreeManager.
                          getGeneratorContext(
                            ));
                    setTransform(
                      element,
                      deltaGC.
                        getTransformStack(
                          ));
                }
                else {
                    currentGroup =
                      domTreeManager.
                        getDOMFactory(
                          ).
                        createElementNS(
                          SVG_NAMESPACE_URI,
                          SVG_G_TAG);
                    addElement(
                      element,
                      method);
                }
            }
            else {
                currentGroup =
                  domTreeManager.
                    getDOMFactory(
                      ).
                    createElementNS(
                      SVG_NAMESPACE_URI,
                      SVG_G_TAG);
                gc.
                  validateTransformStack(
                    );
                addElement(
                  element,
                  method);
            }
        }
    }
    protected int countOverrides(org.apache.batik.svggen.SVGGraphicContext deltaGC) {
        return deltaGC.
          getGroupContext(
            ).
          size(
            );
    }
    protected void trimContextForElement(org.apache.batik.svggen.SVGGraphicContext svgGC,
                                         org.w3c.dom.Element element) {
        java.lang.String tag =
          element.
          getTagName(
            );
        java.util.Map groupAttrMap =
          svgGC.
          getGroupContext(
            );
        if (tag !=
              null) {
            java.util.Iterator iter =
              groupAttrMap.
              keySet(
                ).
              iterator(
                );
            while (iter.
                     hasNext(
                       )) {
                java.lang.String attrName =
                  (java.lang.String)
                    iter.
                    next(
                      );
                org.apache.batik.svggen.SVGAttribute attr =
                  org.apache.batik.svggen.SVGAttributeMap.
                  get(
                    attrName);
                if (attr !=
                      null &&
                      !attr.
                      appliesTo(
                        tag))
                    groupAttrMap.
                      remove(
                        attrName);
            }
        }
    }
    protected void setTransform(org.w3c.dom.Element element,
                                org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        java.lang.String transform =
          domTreeManager.
            gcConverter.
          toSVG(
            transformStack).
          trim(
            );
        if (transform.
              length(
                ) >
              0)
            element.
              setAttributeNS(
                null,
                SVG_TRANSFORM_ATTRIBUTE,
                transform);
    }
    static org.apache.batik.svggen.SVGGraphicContext processDeltaGC(org.apache.batik.svggen.SVGGraphicContext gc,
                                                                    org.apache.batik.svggen.SVGGraphicContext referenceGc) {
        java.util.Map groupDelta =
          processDeltaMap(
            gc.
              getGroupContext(
                ),
            referenceGc.
              getGroupContext(
                ));
        java.util.Map graphicElementDelta =
          gc.
          getGraphicElementContext(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] gcTransformStack =
          gc.
          getTransformStack(
            );
        org.apache.batik.ext.awt.g2d.TransformStackElement[] referenceStack =
          referenceGc.
          getTransformStack(
            );
        int deltaStackLength =
          gcTransformStack.
            length -
          referenceStack.
            length;
        org.apache.batik.ext.awt.g2d.TransformStackElement[] deltaTransformStack =
          new org.apache.batik.ext.awt.g2d.TransformStackElement[deltaStackLength];
        java.lang.System.
          arraycopy(
            gcTransformStack,
            referenceStack.
              length,
            deltaTransformStack,
            0,
            deltaStackLength);
        org.apache.batik.svggen.SVGGraphicContext deltaGC =
          new org.apache.batik.svggen.SVGGraphicContext(
          groupDelta,
          graphicElementDelta,
          deltaTransformStack);
        return deltaGC;
    }
    static java.util.Map processDeltaMap(java.util.Map map,
                                         java.util.Map referenceMap) {
        java.util.Map mapDelta =
          new java.util.HashMap(
          );
        java.util.Iterator iter =
          map.
          keySet(
            ).
          iterator(
            );
        while (iter.
                 hasNext(
                   )) {
            java.lang.String key =
              (java.lang.String)
                iter.
                next(
                  );
            java.lang.String value =
              (java.lang.String)
                map.
                get(
                  key);
            java.lang.String refValue =
              (java.lang.String)
                referenceMap.
                get(
                  key);
            if (!value.
                  equals(
                    refValue)) {
                mapDelta.
                  put(
                    key,
                    value);
            }
        }
        return mapDelta;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hqjB+PRtfGrcE4t+s/sw91vhqBM5eaGFaaEXcnlu76DFZ+/+6ujzQ/cXicyg" +
       "NjtEeujGf92q9mz76Ks0I3NwzJC1eOi7gvvumVC/+Dind1AKqafH01cvwHGH" +
       "dt7e6Bf+6sI/+0lRF6mU7Tx6paTGMPa7IHe0Esk15Nop7al5oEh66pIoPMmL" +
       "kK5hvfjorJpQx95YL/dA4nicxVnwLLbRYrEXEvkaKnwIRQo0QwBBSFR99Os9" +
       "Q1u3/9CPMVnQj6KDVSqdfitimK7fuO/OySN2HrmZzz0iFjK9gg8/k5e1WMzh" +
       "7pCH1fMB0iye+TNQR9Ek1QNt43IIy0j+0vYlV/E4dLkVbv06Yj0WazOVKEBz" +
       "v52Y7h87tP6Foo1LE0lnJhLR8wqr5Y1nln3SzaG/GFf8zoRBXWv5EjPiWncq" +
       "hdzfwscHz3/xQXnxhUjxqurtPHNqMtE0DAzzHF7uUSG4ueqDdfd8+ohQwevS" +
       "ns50x86bvg3culPguditTE/bMLhpxI5FqIPFKpRuWq5ROEXjJ/s3/+GhzduF" +
       "VFWpuXcDbC0f+ft/Xg3cfeSVDOldAcCPyZJA40smZ2O98yOUKpy7699bbnyr" +
       "FbKJZlIc05T1MdocTnX/IivW45owZyfkhIStHk4OI75ZMA8iF8CyDouQ8MPF" +
       "WWGxIT2oLrX99NIMQYWVFmSBFSVXRGDRjkVHhlDINgSEQmNzKIT1qz2arP3/" +
       "NRmJb6fC02AP05CmCeEVM7MCkKCUGKbOAMRo2CN9eQ62jPgjMtYu9MhuDVP2" +
       "OfAstwdZnkX2TUJ2LGLpImajZmRkWI+6kgR8u9Aj7k+GKe734Wm1B2zNIu62" +
       "nOJmo2akKIKbo6b6RO5Tmy336VjZlJoteZS6fphKTYen0xarM4tSN+dUKhs1" +
       "I2VyzIQdAuMbv4Rmo1GzgflyACYogGdh0MGjwy05dIg7ssxKysI/hcSzTXfJ" +
       "4sprkinptBwm7tgAGUX8tIlog2nqZvIkDuF3crYjGg69e7bt3B1ufWCu385M" +
       "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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e8wrx3Uf76fXvXrceyXFkqpab/khrfItyeUzih+75C65" +
       "Ly7JJZeP1pGX++Ducl/c964rJ3aQyqgB12hl1wVioX84rZsqthEk6CNIq6Bt" +
       "nMBpALtB07So7bhN69R1YRewU9Ru09nl9773ftKFhBDY4XDmzMw5M+f85szO" +
       "4avfLd3meyXIdcx0bTrBvpIE+4ZZ3w9SV/H3KaY+FD1fkTum6PsTUPaC9OSX" +
       "rvzwR5/Uru6Vbl+W7hdt2wnEQHdsf6z4jhkpMlO6clyKm4rlB6WrjCFGIhwG" +
       "ugkzuh88z5TuOtE0KD3NHLIAAxZgwAJcsACjx1Sg0T2KHVqdvIVoB/629OHS" +
       "BaZ0uyvl7AWlJ0534oqeaB10MywkAD1czH8LQKiiceKVHj+SfSfzNQJ/CoJf" +
       "/js/c/VXbyldWZau6DafsyMBJgIwyLJ0t6VYK8XzUVlW5GXpXltRZF7xdNHU" +
       "s4LvZek+X1/bYhB6ytEk5YWhq3jFmMczd7eUy+aFUuB4R+KpumLKh79uU01x" +
       "DWR94FjWnYREXg4EvFMHjHmqKCmHTW7d6LYclB472+JIxqdpQACa3mEpgeYc" +
       "DXWrLYKC0n27tTNFew3zgafba0B6mxOCUYLSwzfsNJ9rV5Q24lp5ISg9dJZu" +
       "uKsCVJeKicibBKW3nSUregKr9PCZVTqxPt8d/PQnPmT37b2CZ1mRzJz/i6DR" +
       "o2cajRVV8RRbUnYN736W+bT4wG9+bK9UAsRvO0O8o/nHf+3773/u0dd+Z0fz" +
       "l69Dw60MRQpekD63uvzVt3eead+Ss3HRdXw9X/xTkhfqPzyoeT5xgeU9cNRj" +
       "Xrl/WPna+LcXP/fLynf2SneSpdslxwwtoEf3So7l6qbi9RRb8cRAkcnSJcWW" +
       "O0U9WboD5BndVnalnKr6SkCWbjWLotud4jeYIhV0kU/RHSCv26pzmHfFQCvy" +
       "iVsqle4ATwkFz3tKu0/xHZQ0WHMsBRYl0dZtBx56Ti5/vqC2LMKB4oO8DGpd" +
       "B14B/d/8ZGW/CftO6AGFhB1vDYtAKzRlVwn70Xqt2HCXY3ueE7qsaAOl8PZz" +
       "jXP/AsdKcrmvxhcugCV5+1lAMIEt9R1TVrwXpJdDDP/+F174yt6RgRzMWFB6" +
       "FxhwfzfgfjHg/m7A/TMDli5cKMb5iXzg3bKDRdsA8wfAePcz/AeoD37syVuA" +
       "vrnxrWDGc1L4xvjcOQYMsoBFCWht6bXPxB8Rfra8V9o7DbQ5s6Dozrz5MIfH" +
       "Ixh8+qyBXa/fKy99+4df/PSLzrGpnULuAwS4tmVuwU+enVbPkRQZYOJx988+" +
       "Lv76C7/54tN7pVsBLAAoDESgugBlHj07xilLfv4QFXNZbgMCq45niWZedQhl" +
       "dwaa58THJcV6Xy7y94I5vitX7YfB84EDXS++89r73Tz9iZ1+5It2RooCdd/D" +
       "u5/997//p0gx3YcAfeXElscrwfMnQCHv7Eph/vce68DEUxRA958+M/zbn/ru" +
       "S3+lUABA8dT1Bnw6TzsADMASgmn+hd/Z/tE3vv65P9g7VpoA7IrhytSl5EjI" +
       "vLx05zlCgtHeecwPABUTGFuuNU9PbcuRdVUXV6aSa+mPr7yj8uv/4xNXd3pg" +
       "gpJDNXru9Ts4Lv9LWOnnvvIzf/Zo0c0FKd/UjufsmGyHlPcf94x6npjmfCQf" +
       "+dojf/fL4mcB5gKc8/VMKaBrr5iDvULytwUl6BrDzK1IjIP9dVXe73miqx3t" +
       "54dt3nmOMecrdWDLhV7ARaNni3Q/n9Ni+FJRV8+Tx/yT9nXahE/4Ny9In/yD" +
       "790jfO+ff7+YkNMO0kl1YkX3+Z0G58njCej+wbNg0hd9DdDVXhv81avmaz8C" +
       "PS5BjxIARp/zAJQlp5TvgPq2O/7Db/3LBz741VtKe0TpTtMRZUIs7Lh0CRiQ" +
       "4msABRP3fe/f6U98ESRXC1FL1wi/07uHil+XAIPP3BjCiNy/OUaBh/4PZ64+" +
       "+q3/fc0kFOB1nW39TPsl/OovPtx573eK9scokrd+NLkW3oEveNy2+svWD/ae" +
       "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" +
       "Lv8h++rv9t4p/a290i1HN33XhFmdbvT8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6fu9Oz0lCD17cuqW75HTd/aPFqu0+2zPvis/Vopr1Gs3e8w5t9NfOqfuV/Pk" +
       "HwWl+z1FSiVT6Zx9z372ZW/k6PKxdr76eu95T45XFHz+dDgGBJ4PHUj9oZuQ" +
       "urgeePd1Rb9wTPDhguBfnCP/b+XJPwtKd4qyfOIK4deORfyNNytiGzw/fyDi" +
       "z781Ih6EPhQi5sm4oPrKOXL+mzz57fPk/PKbkPO+vPBx8Hz9QM6v36ycyust" +
       "ZVgQ/OE5Iv5RnnwtKF2WnNAOuEjxPF1W/Otp8S36QVxpIfm/fROSF9dcY/D8" +
       "yYHkf/LWSH5ihcNjTf6v54j/7Tz54wBgtKdbB9d3hONdf7G/9WZFzq9wf3wg" +
       "8o/ecpE/DDD/HTfG/CIyaHfL/8rff+r3f/aVp/64iHy5qPuC6KHe+jqhpCfa" +
       "fO/Vb3zna/c88oUiAO3WlejvQPlsDO61IbanImcLGe4+berABPZe203K7jso" +
       "mW9pcGMe8CzGAbyuyvDpm9rDYMq/0PGOvILqucFXE0+0/Txcjw9EaXOgkWeN" +
       "/Pha8IeHV8M/vr4OFSpSOFRHvtTtpmKvd3Gt/zFPfuAmZ/Xq6Nb4+AK1Yzq2" +
       "kgerHdbtgjV1Z/8otBtUJtfl9PM7TovBTrhh11PsE1Z64dI5dXflye1B6TYp" +
       "52snxjnkl5Od4f+vc2iKkI/vBkBPleBoFc5gwf98E1jwSF4I9vALF3dtd983" +
       "gwXUG4K/Av0vPHyOpG/PE7CEl9084tT3u4oZiL1O0fhI1gsPvAlZr+SFwEu7" +
       "8PyBrM+/pbKeijU6DXljMS585xekfzr65lc/m33x1V0oUQ5dQQm60Z8qrv1f" +
       "Rx6hew6ungi3/0Hvp1770/8sfODQO7/raBoey6V+8rxpOLSme44jD1kxr7vw" +
       "XF514V1Hfb37UH3Om9ILzxVJkX3nORpQyZMngtKVkxoABj4zZgHUl9/YmMeK" +
       "8+TNKE4CmDgTDp7Htj50zX9Qdv+bkL7wypWLD74y/cPdhnT434ZLTOmiGprm" +
       "yTjBE/nbXU9R9WJxLu2iBt2C858KSg/e4IyWx+4VmWJK2jv69wSlq2fpAQYV" +
       "3yfp3g+cx2M60NUuc5KkAzwrQJJnu0dROieiX3bhksmFE6e7AysrgOi+15vj" +
       "oyYnA6ZzLS7+A3R4eguHB8byxVeowYe+3/ilXcC2ZIpZlvdyEWzku9jxoxPg" +
       "Ezfs7bCv2/vP/Ojyly6949AeLu8YPrb4E7w9dv3oaNxygyKeOfsnD/7aT/+D" +
       "V75eBF3+f+xSpGmcNQAA");
}
