package org.apache.batik.css.dom;
public class CSSOMSVGColor implements org.w3c.dom.svg.SVGColor, org.w3c.dom.css.RGBColor, org.w3c.dom.svg.SVGICCColor, org.w3c.dom.svg.SVGNumberList {
    protected org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider valueProvider;
    protected org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler handler;
    protected org.apache.batik.css.dom.CSSOMSVGColor.RedComponent redComponent;
    protected org.apache.batik.css.dom.CSSOMSVGColor.GreenComponent greenComponent;
    protected org.apache.batik.css.dom.CSSOMSVGColor.BlueComponent blueComponent;
    protected java.util.ArrayList iccColors;
    public CSSOMSVGColor(org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider vp) {
        super(
          );
        valueProvider =
          vp;
    }
    public void setModificationHandler(org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler h) {
        handler =
          h;
    }
    public java.lang.String getCssText() { return valueProvider.
                                             getValue(
                                               ).
                                             getCssText(
                                               ); }
    public void setCssText(java.lang.String cssText) throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              textChanged(
                cssText);
        }
    }
    public short getCssValueType() { return CSS_CUSTOM;
    }
    public short getColorType() { org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      );
                                  int cssValueType =
                                    value.
                                    getCssValueType(
                                      );
                                  switch (cssValueType) {
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_PRIMITIVE_VALUE:
                                          int primitiveType =
                                            value.
                                            getPrimitiveType(
                                              );
                                          switch (primitiveType) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  {
                                                      if (value.
                                                            getStringValue(
                                                              ).
                                                            equalsIgnoreCase(
                                                              org.apache.batik.util.CSSConstants.
                                                                CSS_CURRENTCOLOR_VALUE))
                                                          return SVG_COLORTYPE_CURRENTCOLOR;
                                                      return SVG_COLORTYPE_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_COLORTYPE_RGBCOLOR;
                                          }
                                          throw new java.lang.IllegalStateException(
                                            "Found unexpected PrimitiveType:" +
                                            primitiveType);
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_VALUE_LIST:
                                          return SVG_COLORTYPE_RGBCOLOR_ICCCOLOR;
                                  }
                                  throw new java.lang.IllegalStateException(
                                    "Found unexpected CssValueType:" +
                                    cssValueType);
    }
    public org.w3c.dom.css.RGBColor getRGBColor() {
        return this;
    }
    public org.w3c.dom.css.RGBColor getRgbColor() {
        return this;
    }
    public void setRGBColor(java.lang.String color) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            handler.
              rgbColorChanged(
                color);
        }
    }
    public org.w3c.dom.svg.SVGICCColor getICCColor() {
        return this;
    }
    public org.w3c.dom.svg.SVGICCColor getIccColor() {
        return this;
    }
    public void setRGBColorICCColor(java.lang.String rgb,
                                    java.lang.String icc) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              rgbColorICCColorChanged(
                rgb,
                icc);
        }
    }
    public void setColor(short type, java.lang.String rgb,
                         java.lang.String icc) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              colorChanged(
                type,
                rgb,
                icc);
        }
    }
    public org.w3c.dom.css.CSSPrimitiveValue getRed() {
        valueProvider.
          getValue(
            ).
          getRed(
            );
        if (redComponent ==
              null) {
            redComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.RedComponent(
                );
        }
        return redComponent;
    }
    public org.w3c.dom.css.CSSPrimitiveValue getGreen() {
        valueProvider.
          getValue(
            ).
          getGreen(
            );
        if (greenComponent ==
              null) {
            greenComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.GreenComponent(
                );
        }
        return greenComponent;
    }
    public org.w3c.dom.css.CSSPrimitiveValue getBlue() {
        valueProvider.
          getValue(
            ).
          getBlue(
            );
        if (blueComponent ==
              null) {
            blueComponent =
              new org.apache.batik.css.dom.CSSOMSVGColor.BlueComponent(
                );
        }
        return blueComponent;
    }
    public java.lang.String getColorProfile() {
        if (getColorType(
              ) !=
              SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                SYNTAX_ERR,
              "");
        }
        org.apache.batik.css.engine.value.Value value =
          valueProvider.
          getValue(
            );
        return ((org.apache.batik.css.engine.value.svg.ICCColor)
                  value.
                  item(
                    1)).
          getColorProfile(
            );
    }
    public void setColorProfile(java.lang.String colorProfile)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            handler.
              colorProfileChanged(
                colorProfile);
        }
    }
    public org.w3c.dom.svg.SVGNumberList getColors() {
        return this;
    }
    public int getNumberOfItems() { if (getColorType(
                                          ) !=
                                          SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
                                        throw new org.w3c.dom.DOMException(
                                          org.w3c.dom.DOMException.
                                            SYNTAX_ERR,
                                          "");
                                    }
                                    org.apache.batik.css.engine.value.Value value =
                                      valueProvider.
                                      getValue(
                                        );
                                    return ((org.apache.batik.css.engine.value.svg.ICCColor)
                                              value.
                                              item(
                                                1)).
                                      getNumberOfColors(
                                        );
    }
    public void clear() throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            iccColors =
              null;
            handler.
              colorsCleared(
                );
        }
    }
    public org.w3c.dom.svg.SVGNumber initialize(org.w3c.dom.svg.SVGNumber newItem)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            float f =
              newItem.
              getValue(
                );
            iccColors =
              new java.util.ArrayList(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                result);
            handler.
              colorsInitialized(
                f);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber getItem(int index)
          throws org.w3c.dom.DOMException {
        if (getColorType(
              ) !=
              SVG_COLORTYPE_RGBCOLOR_ICCCOLOR) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INDEX_SIZE_ERR,
              "");
        }
        int n =
          getNumberOfItems(
            );
        if (index <
              0 ||
              index >=
              n) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INDEX_SIZE_ERR,
              "");
        }
        if (iccColors ==
              null) {
            iccColors =
              new java.util.ArrayList(
                n);
            for (int i =
                   iccColors.
                   size(
                     );
                 i <
                   n;
                 i++) {
                iccColors.
                  add(
                    null);
            }
        }
        org.apache.batik.css.engine.value.Value value =
          valueProvider.
          getValue(
            ).
          item(
            1);
        float f =
          ((org.apache.batik.css.engine.value.svg.ICCColor)
             value).
          getColor(
            index);
        org.w3c.dom.svg.SVGNumber result =
          new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
          f);
        iccColors.
          set(
            index,
            result);
        return result;
    }
    public org.w3c.dom.svg.SVGNumber insertItemBefore(org.w3c.dom.svg.SVGNumber newItem,
                                                      int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            if (iccColors ==
                  null) {
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       iccColors.
                       size(
                         );
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                index,
                result);
            handler.
              colorInsertedBefore(
                f,
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber replaceItem(org.w3c.dom.svg.SVGNumber newItem,
                                                 int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >=
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            if (iccColors ==
                  null) {
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       iccColors.
                       size(
                         );
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              set(
                index,
                result);
            handler.
              colorReplaced(
                f,
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber removeItem(int index)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            int n =
              getNumberOfItems(
                );
            if (index <
                  0 ||
                  index >=
                  n) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    INDEX_SIZE_ERR,
                  "");
            }
            org.w3c.dom.svg.SVGNumber result =
              null;
            if (iccColors !=
                  null) {
                result =
                  (org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber)
                    iccColors.
                    get(
                      index);
            }
            if (result ==
                  null) {
                org.apache.batik.css.engine.value.Value value =
                  valueProvider.
                  getValue(
                    ).
                  item(
                    1);
                result =
                  new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
                    ((org.apache.batik.css.engine.value.svg.ICCColor)
                       value).
                      getColor(
                        index));
            }
            handler.
              colorRemoved(
                index);
            return result;
        }
    }
    public org.w3c.dom.svg.SVGNumber appendItem(org.w3c.dom.svg.SVGNumber newItem)
          throws org.w3c.dom.DOMException {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            if (iccColors ==
                  null) {
                int n =
                  getNumberOfItems(
                    );
                iccColors =
                  new java.util.ArrayList(
                    n);
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    iccColors.
                      add(
                        null);
                }
            }
            float f =
              newItem.
              getValue(
                );
            org.w3c.dom.svg.SVGNumber result =
              new org.apache.batik.css.dom.CSSOMSVGColor.ColorNumber(
              f);
            iccColors.
              add(
                result);
            handler.
              colorAppend(
                f);
            return result;
        }
    }
    protected class ColorNumber implements org.w3c.dom.svg.SVGNumber {
        protected float value;
        public ColorNumber(float f) { super(
                                        );
                                      value =
                                        f;
        }
        public float getValue() { if (iccColors ==
                                        null) {
                                      return value;
                                  }
                                  int idx =
                                    iccColors.
                                    indexOf(
                                      this);
                                  if (idx ==
                                        -1) {
                                      return value;
                                  }
                                  org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      ).
                                    item(
                                      1);
                                  return ((org.apache.batik.css.engine.value.svg.ICCColor)
                                            value).
                                    getColor(
                                      idx);
        }
        public void setValue(float f) { value =
                                          f;
                                        if (iccColors ==
                                              null) {
                                            return;
                                        }
                                        int idx =
                                          iccColors.
                                          indexOf(
                                            this);
                                        if (idx ==
                                              -1) {
                                            return;
                                        }
                                        if (handler ==
                                              null) {
                                            throw new org.w3c.dom.DOMException(
                                              org.w3c.dom.DOMException.
                                                NO_MODIFICATION_ALLOWED_ERR,
                                              "");
                                        }
                                        else {
                                            handler.
                                              colorReplaced(
                                                f,
                                                idx);
                                        }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/gsKVPUfehgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static interface ValueProvider {
        org.apache.batik.css.engine.value.Value getValue();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471188908000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471188908000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "QQ+cVtCVHNz/3TS1/d2M8Bz8RsH24ZdS");
        java.lang.String jlc$ClassType$jl5$1 =
          ("1ffdqUntPZSDR3Lw6HdRX0+c1tdjOXhdHACvOnX78ch5Xv/yrk5m27BHbriP" +
           "vb1DLP3yC1fufviF8X8q6izH93wv9YG71dA0T17vO/F80fEU1Sh0cWlbWimU" +
           "uPdMADxyK5GyjUMGc8n3rm2x3xAAr74ZdoaZwZOYYPbCfRYzAC4UvyfxDgLg" +
           "8g4vy8Tbh5Mo5Yx6hpI/VvLbhrfYAT7wUst3os739C1fe+hwe0P+uvTxF7rM" +
           "j36z/pHtdcVsG5qmOZXsveKubfWqIJpXgp68JbUjWhc7b/zWfZ+49MxR5fC+" +
           "rcA7Tzoh2+tuXldqrZ2gqASlv/bwr/zgP33hC8WVuf8PmhZ0TbgwAAA=");
    }
    public static interface ModificationHandler {
        void textChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void redFloatValueChanged(short unit,
                                  float value)
              throws org.w3c.dom.DOMException;
        void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void greenFloatValueChanged(short unit,
                                    float value)
              throws org.w3c.dom.DOMException;
        void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void blueFloatValueChanged(short unit,
                                   float value)
              throws org.w3c.dom.DOMException;
        void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException;
        void rgbColorICCColorChanged(java.lang.String rgb,
                                     java.lang.String icc)
              throws org.w3c.dom.DOMException;
        void colorChanged(short type, java.lang.String rgb,
                          java.lang.String icc)
              throws org.w3c.dom.DOMException;
        void colorProfileChanged(java.lang.String cp)
              throws org.w3c.dom.DOMException;
        void colorsCleared() throws org.w3c.dom.DOMException;
        void colorsInitialized(float f) throws org.w3c.dom.DOMException;
        void colorInsertedBefore(float f,
                                 int idx)
              throws org.w3c.dom.DOMException;
        void colorReplaced(float f, int idx)
              throws org.w3c.dom.DOMException;
        void colorRemoved(int idx) throws org.w3c.dom.DOMException;
        void colorAppend(float f) throws org.w3c.dom.DOMException;
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1471188908000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471188908000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "n6aft6fkDSH0XKCfblosWxU+WUs/dVYt");
        java.lang.String jlc$ClassType$jl5$1 =
          ("vQxAye1qKXcz3eLdp8H+xZS8K4Tunvuq6lzbMX7urJBfAaQv7EIu3HjHSG/f" +
           "kpK3Zly/ehruX0vJe0G2ynCfZvD3nRX9S4GItV30tZtp8I+cBvxjKfmNELoo" +
           "AbTXtvcHz4r4MhD+8i7iyzfd3r97GuzfS8lvh9DzUtinmfsTN8LcrV3wrZtp" +
           "7j88DfenU/I0MLc/l7KNQycj/tSNCO/uLuLuzTF34QD2F06D/R9T8rkQun8P" +
           "NtpuXwf+588K/0ehdEi7gY/fQPjnDr4y3nJMB395mg6+kpIvhul+z2sC/9JZ" +
           "gYPea5vdBc7eTE//2mlwv5GSvwqhezO4YBSfbkE8GfVfnxX1CwAAfhc1fwNR" +
           "77WZ3n/7NMDfScm3wnQfGwActC1V9K+C+sxZof5jIPWrdqG+6uYYOEvhW1un" +
           "4N3KouDvwnSHaooXdfQw2wB9Fea/PyvmEhBf3MUs3kDMh5LZW08ar54DH/EZ" +
           "1Gefpot7UnLbnrODL1XVD9V05tj11aPa2Lr9rNp4Aog829XG7CZpIxX0rgzZ" +
           "C06D/lBK7t9ze1b10o21x1xg64Gzgn4USGbugjZvitvv4n3JaXhflpLH9tI4" +
           "q9ru8iq4l84K9xEgubcL17uZUV45DW4tJXnwpZ7BbXme6hxHW/hh0WbbbE/e" +
           "d3vf8b2/O9l5D8+7Aeiz+6M7WTdtZIBb1+4Dtjob6dPLV2QP4JMFyfT3xEaG" +
           "lO2VKUFS0g2hW9RFJFrBSQnnVsl1QbfhHOj2Fafp9mRB6ZSgKcFSQqSEOib8" +
           "DegUt0bXecd/n8o6aG/nQGPDlIxTMgmh2+ZqmE2QXn/Gk4ukIDx0SORn9ac+" +
           "/8ffvvimzSbSo1tis3NCu0WPl/vSF8+V7gwvvTObKT0viUGWwm/DoQtByhlC" +
           "D1/7zFFW12a/652nOvnzDpw8a37fx/c89OKBh2YMqT6kIxtoT1bCFRm1r3Cf" +
           "+NJba9k04MWlHuigPxruHoM6Oil4cCbh8pGjUSeq6Yr8Nx/72c888vXxvdmZ" +
           "l41GUmnLKy+TurbrqVuZp25n8eZDj19D4F2JsjnMK/Lr3vsPn//a67/82XPQ" +
           "LTh0RzqfnI6gUCeEdq51VOxwBZeG4AoBpS7j0F2b0roz31NcasB79p/uzyqH" +
           "0I9cq+5ss/Sxyef0sJXlxqoPu9EmEb7w2Ix2BFLkobeZKzzrh3eFN/jQE9+H" +
           "8vaxQ7s/92ROf2iPerpr+vBLD4xW2niL464MBbpzZdxi0RaMdzIX88DLTQjC" +
           "q+tYj9ctpS36yiZsPvC92x975f2ffXkWNlcr6YdUzLU7Am8j3+FTM7vdy1ky" +
           "5+tS8hMpuZKSdJp267U3IXO+6TrvfvqH7GbemJI3p+QtIGlqYqC1XSV1zK27" +
           "zqyXdD52azMuTMnbUvIz36deDlblWND9OWK61f9UBf3cdd79wvepoIOGd1Ku" +
           "dx6o6l0p+fmUPJmK5Ib6LJuRt86sqH+RkmwaNz2TuPWelPzyD66oQ/Jep7Ff" +
           "uc67f3VmJf3LlPxqSn4thG7fKKllWTdGTx9Kyb/e19Ovp+SDNyHQPnadd7/5" +
           "QwbaR1Py8ZT8Fgi00D04CFU4s15+NyWfyOpKr/5NSn7nZvnP719/hPzQQfeB" +
           "puvZfuSBYcSRpbytp8/sZp9Myb9LyR+E0PlY1MMb42F/nJI/2vewdOp167M3" +
           "yMMOfSfBWWP//poMW5/KGL5wluHwn6bkP6Tkzw5AnVlBXzyqoP+Ukr+4ka52" +
           "aEoBTrk2n9jXnindVdVXzuxS/zUlX07JV2+gvv7HUX3995T89QqMo044/LsX" +
           "Qi/+/s4Pg1HWA1f9U4LNQXr5o09dvO3+p0Z/kW132D/sfjsO3TaLLOvw6dZD" +
           "17d4vjrbTEzentG7sk/nrW/sLs2fJFIInQM0+8r4+ob7f4fQc0/iBpyAHuZ8" +
           "BnxPH+cMoQvZ38N8/yeE7jjgA33v5uIwy3dA7YAlvfzb9LDtyQM86J7TjHho" +
           "u81j1/yqIaLNv4m4In/sKYx87TO1D2xO64JRZpKktYDPhls3m0iyStMNGY9c" +
           "s7a9um7pv/S7d3389sf3NvDctRH4IJ4Oyfaik7d3dGwvzDZkJL9z/2+/4tef" +
           "+nJ2YvT/AzsZmyC9QwAA");
    }
    public abstract class AbstractModificationHandler implements org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void redFloatValueChanged(short unit,
                                         float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void greenFloatValueChanged(short unit,
                                           float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getBlue(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        text);
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void blueFloatValueChanged(short unit,
                                          float fValue)
              throws org.w3c.dom.DOMException {
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              40);
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ')');
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    sb.
                      append(
                        "rgb(");
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getRed(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        value.
                          item(
                            0).
                          getGreen(
                            ).
                          getCssText(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        org.apache.batik.css.engine.value.FloatValue.
                          getCssText(
                            unit,
                            fValue));
                    sb.
                      append(
                        ')');
                    sb.
                      append(
                        value.
                          item(
                            1).
                          getCssText(
                            ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              sb.
                toString(
                  ));
        }
        public void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR:
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    text +=
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
            textChanged(
              text);
        }
        public void rgbColorICCColorChanged(java.lang.String rgb,
                                            java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorChanged(short type,
                                 java.lang.String rgb,
                                 java.lang.String icc)
              throws org.w3c.dom.DOMException {
            switch (type) {
                case SVG_COLORTYPE_CURRENTCOLOR:
                    textChanged(
                      org.apache.batik.util.CSSConstants.
                        CSS_CURRENTCOLOR_VALUE);
                    break;
                case SVG_COLORTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NOT_SUPPORTED_ERR,
                      "");
            }
        }
        public void colorProfileChanged(java.lang.String cp)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsCleared() throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorsInitialized(float f)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorInsertedBefore(float f,
                                        int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorReplaced(float f,
                                  int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorRemoved(int idx)
              throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           idx;
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    for (int i =
                           idx +
                           1;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public void colorAppend(float f) throws org.w3c.dom.DOMException {
            org.apache.batik.css.engine.value.Value value =
              getValue(
                );
            switch (getColorType(
                      )) {
                case SVG_COLORTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      value.
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        value.
                        item(
                          1);
                    sb.
                      append(
                        iccc.
                          getColorProfile(
                            ));
                    for (int i =
                           0;
                         i <
                           iccc.
                           getLength(
                             );
                         i++) {
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            iccc.
                              getColor(
                                i));
                    }
                    sb.
                      append(
                        ',');
                    sb.
                      append(
                        f);
                    sb.
                      append(
                        ')');
                    textChanged(
                      sb.
                        toString(
                          ));
                    break;
                default:
                    throw new org.w3c.dom.DOMException(
                      org.w3c.dom.DOMException.
                        NO_MODIFICATION_ALLOWED_ERR,
                      "");
            }
        }
        public AbstractModificationHandler() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "xbwkKAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4Cn4PX+7XaAwgJ644/8Ldmfi1V955erl");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("t73C/+fiwOutc+sP0tDlRWzbx0+XHbu+5Af6wix09+DurJlfqIE9eDA/TSSQ" +
           "GQDNJT832XHz4InzNG7ACehxzhl4UjvJCR5xi+/jfD8aQVeO+CLo0u7iOMsH" +
           "wOiAJb+86R/q8dhpst1hvGy30fDEcb8rltlHzrLirS7Hz83mu2PF/4Ec7mTF" +
           "u/8Eual+8ZX+6Me/1/il3bld1Za323yUyzT0wO4IcTFovhv2zF1HOxzrEvX8" +
           "9x/60oPvPty2e2gn8FEMHJPtXacfjO06flQcZd3+q7f9+g/9s1f+sDhO9/8B" +
           "tae9i6AzAAA=");
    }
    protected abstract class AbstractComponent implements org.w3c.dom.css.CSSPrimitiveValue {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public java.lang.String getCssText() {
            return getValue(
                     ).
              getCssText(
                );
        }
        public short getCssValueType() { return getValue(
                                                  ).
                                           getCssValueType(
                                             );
        }
        public short getPrimitiveType() {
            return getValue(
                     ).
              getPrimitiveType(
                );
        }
        public float getFloatValue(short unitType)
              throws org.w3c.dom.DOMException {
            return org.apache.batik.css.dom.CSSOMValue.
              convertFloatValue(
                unitType,
                getValue(
                  ));
        }
        public java.lang.String getStringValue()
              throws org.w3c.dom.DOMException {
            return valueProvider.
              getValue(
                ).
              getStringValue(
                );
        }
        public org.w3c.dom.css.Counter getCounterValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public org.w3c.dom.css.Rect getRectValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public org.w3c.dom.css.RGBColor getRGBColorValue()
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public int getLength() { throw new org.w3c.dom.DOMException(
                                   org.w3c.dom.DOMException.
                                     INVALID_ACCESS_ERR,
                                   ""); }
        public org.w3c.dom.css.CSSValue item(int index) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public AbstractComponent() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALV6Dazs2H2X39u3n9nse7tJdh/bzWZ385J2M9G1x+PxzGib" +
           "khl7vj32eDxjj53Sjb/G9vhz/DH2OCwkqdoESkKguyWIdIVQqpZqmxRERREK" +
           "LILSRqmQWipKkWgCArVQAo1QW0Roy7Hn3jv33vexrN7jSnOufc7//M/5/b/O" +
           "3+ecN74N3R+FUCXwnZ3h+PGRnsVHa6d+FO8CPToaUfWpHEa6RjhyFM1B3cvq" +
           "Cz9/9Q+/+wXz2mXoAQl6l+x5fizHlu9FMz3yna2uUdDVQ23X0d0ohq5Ra3kr" +
           "w0lsOTBlRfFLFPSOM11j6AZ1MgUYTAEGU4DLKcDtAxXo9E7dS1yi6CF7cbSB" +
           "/gJ0iYIeCNRiejH0/HkmgRzK7jGbaYkAcHioeOcBqLJzFkLPnWLfY74J8GsV" +
           "+NW/8UPX/v590FUJump5XDEdFUwiBoNI0KOu7ip6GLU1Tdck6HFP1zVODy3Z" +
           "sfJy3hL0RGQZnhwnoX4qpKIyCfSwHPMguUfVAluYqLEfnsJbWbqjnbzdv3Jk" +
           "A2B98oB1j7BX1AOAj1hgYuFKVvWTLldsy9Ni6H0Xe5xivDEGBKDrg64em/7p" +
           "UFc8GVRAT+x158ieAXNxaHkGIL3fT8AoMfT0bZkWsg5k1ZYN/eUYun6Rbrpv" +
           "AlQPl4IousTQey6SlZyAlp6+oKUz+vk2/f2f/4Q38C6Xc9Z01Snm/xDo9OyF" +
           "TjN9pYe6p+r7jo9+iPoJ+cmvffYyBAHi91wg3tP8wz//nY9++Nk3f2VP8z23" +
           "oGGUta7GL6tfVh77tWeIF1v3FdN4KPAjq1D+OeSl+U+PW17KAuB5T55yLBqP" +
           "ThrfnP1L8ZM/q//eZeiRIfSA6juJC+zocdV3A8vRw77u6aEc69oQelj3NKJs" +
           "H0IPgmfK8vR9LbNaRXo8hK44ZdUDfvkORLQCLAoRPQieLW/lnzwHcmyWz1kA" +
           "QdBT4AeNIejKR6Hyb/8/hkTY9F0dllXZszwfnoZ+gT+CdS9WgGxNWAFWb8OR" +
           "n4TABGE/NGAZ2IGpHzeoUQRrvgsTHMdMOL4PJu+HR4WJBf8/mWcFsmvppUtA" +
           "6M9cdHkHeMvAdzQ9fFl9Nel0v/OVl79x+dQFjmUSQ00w3tF+vKNyvCMw3hEY" +
           "7+jceDfaCvBhWY0JoC7fA3OHLl0qB353MZO9poGebODxIBY++iL350Yf/+wL" +
           "9wETC9IrQMgFKXz7kEwcYsSwjIQqMFTozS+mn+L/InIZunw+thazB1WPFN2n" +
           "RUQ8jXw3LvrUrfhe/czv/uFXf+IV/+Bd54L1sdPf3LNw2hcuyjn0VV0DYfDA" +
           "/kPPyb/w8tdeuXEZugIiAYh+sQysFQSWZy+Occ55XzoJhAWW+wHglR+6slM0" +
           "nUSvR2Iz9NNDTWkAj5XPjwMZU9C+OG/eReu7gqJ8995gCqVdQFEG2o9wwU/+" +
           "23/1X2qluE9i8tUzqxynxy+diQMFs6ulxz9+sIF5qOuA7t9/cfrjr337Mx8r" +
           "DQBQvP9WA94oysKggAqBmH/kVza/9c3f/vJvXD4YTQwWwkRxLDXbg/xT8HcJ" +
           "/P6k+BXgioq9Dz9BHAeS504jSVCM/MHD3IAlO8D1Cgu6sfBcX7NWlqw4emGx" +
           "/+fqB6q/8N8+f21vEw6oOTGpD781g0P9n+lAn/zGD/3RsyWbS2qxph3kdyDb" +
           "B8p3HTi3w1DeFfPIPvXr7/2bvyz/JAi5IMxFVq6XkQsq5QGVCkRKWVTKEr7Q" +
           "hhbF+6KzjnDe187kHi+rX/iN338n//v/5DvlbM8nL2f1PpGDl/amVhTPZYD9" +
           "Uxe9fiBHJqDD3qR/8Jrz5ncBRwlwVEFEi5gQBKHsnJUcU9//4L/7Z//8yY//" +
           "2n3Q5R70iOPLWk8uHQ56GFi6HpkgfmXBnz025/QhUFwroUI3gd8byPXy7T4w" +
           "wRdvH2t6Re5xcNfr/5txlE//x/91kxDKKHOLJfdCfwl+40tPEz/we2X/g7sX" +
           "vZ/Nbg7MIE879EV/1v2Dyy888EuXoQcl6Jp6nATyspMUTiSBxCc6yQxBoniu" +
           "/XwSs1+xXzoNZ89cDDVnhr0YaA4LAnguqIvnRw4KfzG7BBzxfvSocYQU7x8t" +
           "Oz5fljeK4nv3Ui8evw94bFQmk6DHyvJkp+TzYgwsxlFvnPgoD5JLIOIba6dR" +
           "snkPSKdL6yjAHO0zsn2sKsrafhblM35ba3jpZK5A+48dmFE+SO5+7D994Vf/" +
           "6vu/CVQ0gu7fFuIDmjkzIp0U+e6PvvHae9/x6rd+rAxAIPrwf+nvNb5VcB3f" +
           "CXFRkEXRPYH6dAGVK9dzSo7iSRkndK1Ee0fLnIaWC0Lr9jiZg1954pv2l373" +
           "5/aJ2kUzvECsf/bVv/ynR59/9fKZ9Pj9N2WoZ/vsU+Ry0u88lnAIPX+nUcoe" +
           "vd/56iv/+Gde+cx+Vk+cT/a64Fvm5/7NH//q0Re/9fVbZBtXHP8uFBtf/fAA" +
           "i4btkz+Kl1ZCusgyYcXUWka/1jIjstvNR7pJa+2G3B0rO5Kl+51oIjXaGDsM" +
           "RhMmaTHLbVZL8B2DqqvRhmPHw6FhcFaPHW+t6W6zDnoLDtmYwaIhmPzYpH0v" +
           "G/qyGaD2SA74UdCtzvwNzE7dzXyb67m2incDHPcruK6gUow3db1ZU1qNQYOa" +
           "1DjRcWxL3kQzUpGq7bA6xjMlchF5nNEOl4V9eF7dufo4GMBREg7qW6sdNLgB" +
           "365T/GgRCQ2e8Pshje96WS+qW/ZOm8vzvj2RapxSHVOuPWEXSxAoW2LIu/PO" +
           "YsZLopPha47qkBOLtt2IEzcr1unrKNKft3d0OuZMyrax+bKCaeJwI82qYr1F" +
           "1hLDUmoMPewvCQEsUQEp72bZhktt190w/aEYDgSn6wp9ZYOHVZgXRAu8WNMk" +
           "2vTFPm3zM7FLVCt+ZbVmLLEnk1EP4TQayWIhj50RxWOaT3VHG4+uow4nR1t9" +
           "NluYrLmo1rprcjZA/KQvat2UGoVCddMlcDnxHXuH4HyqOYm0kCPD7xITattN" +
           "JzuJ5eggTqg1QNNn0IaX7sCAsI/X2Im97SHNLRE0QWDx0Myi54jdCXoWPsQm" +
           "xrojjrp6e8S6FaDfUPR68ng3mNO0EeHTBU/M+L7SqyVRnaushdFIGDSQRseQ" +
           "WmNj5MDzlA3R7pLN7Zya52KGq0KdbYUVLiHCqoFj9HpTJ9K0EXXSRdgD4l93" +
           "Y0OD5QVm93pW3t3leXPto9N8ZBHtDT/hnHbNd2VhTLM2zo2QtMsvuUpEzyYk" +
           "Gg8Qk9LITtuuDyRdsq2qL9okErbijhoj9mpJiXJ7E6SkwU+AfvW5usBTrkG3" +
           "kspc9uqJwmfwKkRrrGGx7Umk++GYai7QHmejMMebG2/k8/mQkATKR5qjudBU" +
           "rdmQ6JDAKIxeLjb1ZFVrNzcSFaaunNQoVmE8hUWXwhiDq7zSzAO85myt4cJv" +
           "5izFLmo1fFKfokutZZvhzmhPkTppWkPGbDGEEyqtZpMha/hQ6yzi3ohzeW3O" +
           "Ke31Rhnp0Yjl+5skyPzqaCGtPZlT5bCLTuP6KIg6+Yzu+ziNcOtqstCkkeUs" +
           "dR7fpjDbYQc9w5x15mkoONl0mkVcv0JOx+KEnZhMRepMzIxtsrDZh9dkKg7i" +
           "9pwm8pG9kXw9XCvVXg8ep6kepJV0wK5rhraYmhbSksXhyPSEfLrbdQZsxuoI" +
           "gYaDzmSOzRU/7sZLravhSA+rsTvTmrnz3XzXc21kRRpsu0V6lSEOE7LmGpu8" +
           "t2kBC7TdraLk8KqCiekoTwnakie19jY01Rk+VOo6QYtUuvTNvBbSMhwaZDfa" +
           "ydg0RtYC67EssWK60njoibJmeex8nWGDYSjgw6nSylpSvztzR0a2bKfGsOIQ" +
           "84oZqK2MQINVbWeuNhtbFJa9Vp1ZWOMhzjJVOx6PbZmjBRGuEGYdIRt9Z4mw" +
           "zigXJ3ST7+dgeVaCiVgh5Ga0GLpIIk3tGd3oa7bpxyTjUWafrXnrLKrXOX2Z" +
           "G9gK3farvUWXaw1FckkNu9OOwzQQ0fO8gZAvsZo9jEGM7CqDagvDfTJh2rPp" +
           "qusOMnknbSY0sUU9DNNd3mniy2UStOqLdm42EHVAynMMWCSF5ruwMshovBrU" +
           "MBR3hgNC1aoTjvCZYN5PxDbjTpMcUUeJZtpoa9JrIkOp0q4xVXgkbNQKCMWr" +
           "hqsM6y7TJYUE6eBOSC8dR+pIg5UKI9mOqvUljvDmy9yTYAye02me1BmW6vlO" +
           "StEuQ9UNtAFEXGlqod5q4fDUE6v4yEiHFaG/mU+w7ZwTsCScVNpppb0yK5bT" +
           "QkaxYXrdQHMrNanuaqqL9SmqNugaOOO01zqyrihx37GsrqPb02BpdVdBLdfH" +
           "PFWrItueEiVtH9giLU3XGBnUYEHwqHTN12A5GUXt9bAvsBphIhnWSGymngvu" +
           "WK+SDD8ehFHeqm+2HCMaHWygxpI42/GIj42G8y3GbZiMDfVaMlEq+RC1dmjN" +
           "XcZT24okPOCnS6rKx/pUyLRYFdwmWtcaOBU5fk8Ubc3oClZGzvQe0livRRGd" +
           "1CcGm+awUt8YKEu3KbpBudXKpie3tLYuNMSeI61IsmqK82V/NRYRBAVSWNTg" +
           "RlONpomGBcNoSC82lL/A6yTmclNHZPJF3yC2bj6ugOx0t2xLNKXqpET0F1Wx" +
           "35gQcA0GQZsEq5/EzB133hLh1dzXBFwyk07m1LdmN8ZRkWLUVrrKmmwyAWsW" +
           "2kNajspM530jNOrucIVNKrQ9mllIx6oIFSlrJ5NeNgySBeK12VlKdPDIHcvD" +
           "Fl1tVdIak0eqxqxVGfV6zSAK2rjSbLCk5WVqA67UJzUWnVeankWDb5WwvuGm" +
           "Mt/Lp90qjut0w0soM6xyKlwZ9HK4tRnNOkokZ76nJSSsy2QH2e5mqQWPNxjc" +
           "0lYyWkk1dL7rDPMpbeLCql6T696yWoFnJCbVu25itVvSDqxRi02k8Px6EYxI" +
           "WsYNt+XMs2Zj4Ys7lUKITE7JhqzMY+BQzS2mIhTaaaIDseFgim1EaZxSTIfX" +
           "jc1kKoLVb02iq2iDUbIct7xJfZGhm9aC8YkUMSXVMreZrjQWlFxdwWtBlZmY" +
           "VbaNJu7XxM66iQy0uaLI7k5sj4acsbCmUicVULK52rSNlBJJXhSJXYfUZmIP" +
           "0PezTJ0wEWKHS5VFB9Veh+LtdCKB4DbEvX7Un3MUagZ9AiH682UTZaau2zM6" +
           "RjAhxWHLsIecP1KptdYk5gO7IlgrzHZTXXO9MeOnVEPc8lEFifPWqDJoSIkg" +
           "Dpn1xkvtFQoPEm+t1/2dSeZ1tu5Z+LbTaUwcfsuLJk3ArZjDJg1yjMAYS9ca" +
           "RqtSaUo7Nqu2rIq/DmyeHkzTSJvuls1osyZ7qMCnCVb3TQVkYrqBgIxjFukr" +
           "Ksux3XwyIA0tzgkG2F8npXnHnaVjCXHH/R4yMXHF9+RaHfc3uN+uZpXRzgGf" +
           "CaE+YtCJrtX0HrGV6inFj7VUG6Fraj2yNZ6sUsiuv3ThLSuNvIYYkrynKHQj" +
           "2GGJritCRNjzTBUZbEoT8zUmMri+VqmKkWLqst6MmI5MUOE4tvMsY6YjuiU7" +
           "EZrRS8ubtuYuTsSdVqQxWgdvSEgsa7bsgtSjPh1EpDfgOkK7avQC34rkqeCv" +
           "2nBarw+CiuH2gTdw9RkZbqJwO9uJwQTviwNFYfujtI5sN3ZPYZJBZb4yp4SG" +
           "9aXtdlId0swwSFNs0F3G1U59wo/Y4XzV2yEdjcsUSthaFsMpgkHMdpWJ2TTi" +
           "iIrD2QyBrbpseEjdlRypSQ0NPfYQhBC2a8dVq8CPl60uooa1FkvIPUQicTRE" +
           "qbzHEYIRz4TNmG0tJnDGDkWBRFrJ3OhN1msP0Z1BrvJbJbN0ZqGgfsebYtjA" +
           "xlbilG5gOlcLHZhqwEhTIHlXFPg5szQ1N+WaQTIVBz0Sdcc1JBK9tSO0Nm0l" +
           "S3qzdYPJxdXEGTKLrmAYbpvEGl51aC+UKu7AdM/rmwmhxWYXmy4HadOu0UqV" +
           "hGdjvCMOsG67uRQrrL3O2E1eq8POJCRQmZ4tba+Gw822n6kWEra3cdzpUHAY" +
           "KerCwPsNWo8wZ8nCVO7nvDNB9Nq2ud321+OtsvNNE2t6vCbwK8XPEZ4ig0G/" +
           "pwDoCZ3umN64Slt4fdYeNwxTdMgWO8QTF+VgGnwtCIgS+X2GcSqcbcCVcUVR" +
           "THlhtDGtNyatdIHsOg2DJOYNhtaGWOIH3eYcC0aroZtXF3ytNcWbKxGZNPmW" +
           "JsY9ctnU3KjRsCtjkHe3muJyvq5v0dq2NtOXnRq1WbPgS3LnsqG4BS+xGjma" +
           "ObXqwdLlFdeqL+AqUdFHSFcf1xNPoTILofIRvGqqDXQpz+Rc8hrV6arPO60m" +
           "joDPOM5aacG4nU3WiCfjS5sdB9WAm9ETT/WkQbRx5YE0HSq1WBaUCtpY1bym" +
           "0oDXMdbp8t1e3oyntZ2jr1ZbcznKtgPXH9mypQbGajMOvGBoCuMYxbVO3ol2" +
           "OmLxYih4bHdu+La1CVBuM7MYYTJdWQltprzL400JIYZpku+aZETnXX6zrk9y" +
           "RWBtlWPJ2Uxb1BE9mjMVF3dtcWW4IGVGeZdqBFMCSzqxsW6gMyqih7WmvKTI" +
           "KYbMKzKaCmtMbhhr2EKa66akeuPZ2OqCj+OPfKT4bP7Bt7dz8Xi5SXN6hrZ2" +
           "GkVD/218sWe3HvByDD0chH6sq7GuxdBD8vFxQna6eV1u4z15h83rMxt8l042" +
           "jZ4vTi/SmloeWBQHFwTHne5YlNtkxZ7Ge2930FbuZ3z506++rjE/Vb18vIUq" +
           "xNADx+efhxHfAdh86PYbN5PykPGwr/fLn/6vT89/wPz42zi5eN+FSV5k+Xcn" +
           "b3y9/0H1r1+G7jvd5bvp+PN8p5fO7+09EupxEnrzczt87z1VwPOFvF8Egu8e" +
           "K6B769ODW+u3eCzZrva2dIc96vQObbuiCIGBgPhe6u9E0997y3Mq3TMsTz8q" +
           "d/SODvSllUZvta90duyywj+VxZNF5XNABuNjWYzfhiwulc71lmL4kTu0faYo" +
           "PhlDjwAxEMBWgcGVjnhA96m7QPeeovIGQMUdo+PuPbq/doe2Hy+KvxJDV/fo" +
           "Sr2dHmrNzkQYPobuj0w/jA+4P3e3uD8A8H7sGPfH7j3uv32Htr9TFH8rhq4B" +
           "3Of2VYv61w4Yv3S3GF8A2NRjjOq9wXjpQPBaSfDGrQlO/PX62chMMpNupupB" +
           "EQLLzl8pip+OoXcCSfQcXz7j6xf1vyqaD7L5mbv16sLu7WPZ2Pde/1+7vdy+" +
           "WhL806L4xRh6DEDfH3SU2C+49z+6C5jlLYcPAnjRMczo3sP8+lvB/EZR/Itj" +
           "H/eT4v7OuXj+1E0r957oIIJfugsRvLuofA5A/8SxCD5x70Xwm28lgt8qil+P" +
           "oUeBCGYg8TmH/90X8RcUB/D/+i7AXy8qvw+A/uFj8D9878H/57cC/ztF8a19" +
           "rJv1O+UlknMCuH6TAI6pDkL4D3chhHcVlc8A8J87FsLn7r0Q/ucd2v6gKP47" +
           "yHoBfgqkKbF5q+h2n+WdUfr/uFulF3hfO8b72r3Be0axf1QQXLp8e9CXrhSV" +
           "fxxDV6xYd2+raJCjX0jV/uTtAM/AZ8pNt5FOBvvg/9t1JpDNX7/pjuT+Xp/6" +
           "ldevPvTU64vfLK/vnN69e5iCHloljnP2rPzM8wNBqK+sUoIP70/Og1IiV4/x" +
           "32pKQP2gLGZ+6Zj6ieO4cJEaUILyLGVxYH6REiyW5f+zdNdBDnmgA182+4ez" +
           "JN8DuAOS4vGZ4ESOZ87G91cLsv3Kfv2s9ZW6e+KtdHfa5ewtoOILqrzLevK1" +
           "k+xvs76sfvX1Ef2J7+A/tb+FpDpynhdcHqKgB/cXokqmxRfT87fldsLrgcGL" +
           "333s5x/+wMmn3WP7CR884czc3nfraz5dN4jLizn5Lz71D77/p1//7fJywP8F" +
           "9fv0/2QsAAA=");
    }
    protected abstract class FloatComponent extends org.apache.batik.css.dom.CSSOMSVGColor.AbstractComponent {
        public void setStringValue(short stringType,
                                   java.lang.String stringValue)
              throws org.w3c.dom.DOMException {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                INVALID_ACCESS_ERR,
              "");
        }
        public FloatComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "IAAA");
    }
    protected class RedComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getRed(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  redTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  redFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public RedComponent() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m5W3mwIapkvjF44/EY84vPhf0/XimAYYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "m/kN9f8CJprAYeQiAAA=");
    }
    protected class GreenComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getGreen(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  greenTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  greenFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public GreenComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "aDirw6YAh+nyCIbjz8QjDs/9F+hJWN4KGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9Omv53fU/wuk9/WV6CIAAA==");
    }
    protected class BlueComponent extends org.apache.batik.css.dom.CSSOMSVGColor.FloatComponent {
        protected org.apache.batik.css.engine.value.Value getValue() {
            return valueProvider.
              getValue(
                ).
              getBlue(
                );
        }
        public void setCssText(java.lang.String cssText)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  blueTextChanged(
                    cssText);
            }
        }
        public void setFloatValue(short unitType,
                                  float floatValue)
              throws org.w3c.dom.DOMException {
            if (handler ==
                  null) {
                throw new org.w3c.dom.DOMException(
                  org.w3c.dom.DOMException.
                    NO_MODIFICATION_ALLOWED_ERR,
                  "");
            }
            else {
                getValue(
                  );
                handler.
                  blueFloatValueChanged(
                    unitType,
                    floatValue);
            }
        }
        public BlueComponent() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "k2PDbGUAY+NP+CMbnv8vgWMJLggYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/82ffPab+fX0/wJHtzcr4iIAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "5B35Q3pUXH5Xdwe+nf0fkDs2O8E5AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Jg43CRGnh24clEajiY0g7qCMbPw2XR2P");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
