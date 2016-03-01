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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "les92RcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aeawsWVmvd2d785iZ9+bBLIzMygOZabxV1V3d1ZXHMr3W" +
           "0tVrdVUvIo9au6pr37qqG0YBo4wSgeiAqDCJyRCQDEuMRBODGWMUCMQEQ3Ah" +
           "AjEmoEjC/OFoRMVT1ffevve+9wYmGm/Sp0+f853vfNv5nXO+c5/9PnRTGEAF" +
           "z7XWC8uN9tU02l9a5f1o7anhPsOWB2IQqkrDEsNwDNquyI989vwLP/yAfmEP" +
           "unkOvVx0HDcSI8N1wpEautZKVVjo/K61Zal2GEEX2KW4EuE4MiyYNcLoMgu9" +
           "7NjQCLrEHooAAxFgIAKciwDXdlRg0O2qE9uNbIToRKEP/Tx0hoVu9uRMvAh6" +
           "+CQTTwxE+4DNINcAcDib/RaAUvngNIAeOtJ9q/NVCn+wAD/1m2+98Ps3QOfn" +
           "0HnD4TJxZCBEBCaZQ7fZqi2pQVhTFFWZQ3c6qqpwamCIlrHJ5Z5DF0Nj4YhR" +
           "HKhHRsoaY08N8jl3lrtNznQLYjlygyP1NEO1lMNfN2mWuAC63r3TdathO2sH" +
           "Cp4zgGCBJsrq4ZAbTcNRIujB0yOOdLzUAQRg6C22Gunu0VQ3OiJogC5ufWeJ" +
           "zgLmosBwFoD0JjcGs0TQfddlmtnaE2VTXKhXIuje03SDbRegujU3RDYkgu46" +
           "TZZzAl6675SXjvnn+703vO/tDuXs5TIrqmxl8p8Fgx44NWikamqgOrK6HXjb" +
           "Y+yHxLs//+QeBAHiu04Rb2n+8B3PP/76B5774pbmp65B05eWqhxdkZ+R7vjq" +
           "qxqPEjdkYpz13NDInH9C8zz8Bwc9l1MPrLy7jzhmnfuHnc+N/mL2zk+q39uD" +
           "ztHQzbJrxTaIoztl1/YMSw1I1VEDMVIVGrpVdZRG3k9Dt4A6azjqtrWvaaEa" +
           "0dCNVt50s5v/BibSAIvMRLeAuuFo7mHdEyM9r6ceBEF3gA+EQdCZr0P53/Y7" +
           "ghaw7toqLMqiYzguPAjcTP/MoY4iwpEagroCej0XlkD8mz+D7uNw6MYBCEjY" +
           "DRawCKJCV7edsBwCateGGxzX73ICCVRxg/0s4Lz/v6nSTOsLyZkzwCGvOg0H" +
           "FlhJlGspanBFfiqut57/9JUv7x0tjwN7RVARzLe/nW8/n28fzLcP5ts/Md+l" +
           "vOzFGWRAZ87kU74ik2Hrf+A9E+AAQMjbHuV+jnnbk4/cAALPS27MHABI4esD" +
           "dWOHHHSOjzIIX+i5DyfvEn4B2YP2TiJuJjdoOpcNH2Q4eYSHl06vtGvxPf+e" +
           "777wmQ894e7W3AkIP4CCq0dmS/mR0xYOXFlVADju2D/2kPi5K59/4tIedCPA" +
           "B4CJkQhiGMDNA6fnOLGkLx/CY6bLTUBhzQ1s0cq6DjHtXKQHbrJryV1/R16/" +
           "E9j4fBbj9wFbf/sg6PPvrPflXla+YhsqmdNOaZHD7xs576N/85f/VMrNfYjU" +
           "54/tfZwaXT6GDhmz8zkO3LmLgXGgqoDu7z88+I0Pfv89P5sHAKB49bUmvJSV" +
           "DYAKwIXAzL/0Rf9vv/XNZ762twuaCGyPsWQZcnqk5Flou7yvqySY7bU7eUDE" +
           "WmDZZVFziXdsVzE0Q5QsNYvS/zz/GvRz//K+C9s4sEDLYRi9/scz2LW/sg69" +
           "88tv/bcHcjZn5Gx329lsR7aFzJfvONeCQFxncqTv+qv7f+sL4kcB+ALAC42N" +
           "mmPYmaOF8+iLnHACwwbeWB3sCvATF79lfuS7n9oi/ukt5BSx+uRTv/qj/fc9" +
           "tXdsn331VVvd8THbvTYPo9u3HvkR+DsDPv+dfTJPZA1brL3YOAD8h44Q3/NS" +
           "oM7DLyZWPkX7O5954o8/8cR7tmpcPLnNtMAp6lNf/6+v7H/421+6BpaByHXF" +
           "KJcRzmV8LC/3M6Fyi0J53+WseDA8DhknjXvs7HZF/sDXfnC78IM/eT6f7+Th" +
           "7/gK6Yre1jp3ZMVDmbL3nMZHSgx1QIc913vLBeu5HwKOc8BRBqgf9gMA1OmJ" +
           "9XRAfdMtf/enf3b32756A7TXhs4BBZW2mEMTdCvABDXUAcan3psf366JJFsk" +
           "F3JVoauU3y6le/NfN754cLWzs9sO2O79j74lvfsf/v0qI+R4fI14OzV+Dj/7" +
           "kfsab/pePn4HjNnoB9KrNy9wzt2NLX7S/te9R27+8z3oljl0QT44RAuiFWdw" +
           "MwcHx/DwZA0O2if6Tx4Ctyeey0fA/6rTAX9s2tOQvAs0UM+os/q5Uyh8MbPy" +
           "A2DhfuMAoL5xGoXPQHmFzoc8nJeXsuKnD0HvVi9wIyClquS8MRDUq0yT7Edp" +
           "i+FZ+YasYLb+fPN1fd/MWaRnAN+bivv4PpL9Hl577huy6usA6ob5NSFbTIYj" +
           "WodS3LO05EuHq1oA1wbg/EtLC8/Z3AUuSnncZmbe3561T8mK/cSygri8Y8eM" +
           "dcGx/b3/+IGvvP/V3wLBwxyYA8TMsRm3x5JffvaD97/sqW+/N99EgDEHH2pd" +
           "eDzj+pYX0zgr+KwQDlW9L1OVy09jrBhG3Rz3VeVIW+SYPpUI7B7u/0Lb6Had" +
           "wkK6dvjHojMVS8ZpamoFAqeScbGGldhababUF1YDr7dZkTL4ehVfNKmiktab" +
           "AkVueuqyhLAVArUUWOpTHb7l1Wd8NDTaI8QUCw2lJY7Ilk8GvG/xrjAiGKsz" +
           "o0lfYHimjxRmfaQhsJiLpmLRl7RNP61Q+GxVnhNi1VkQ1SpSKsGDkiYNHKlC" +
           "iwjSVPrWbNNvBaVKl+sykbVp6aG9loeCxHjSbDyzBprkzOAVBRP1hKZTXyca" +
           "/GyyKXLEwqwUJ8a8m+i9djQZzzzBmBtSQ7YTirebdnc4S4TxBG20kOlYwquB" +
           "a3AbNkI3nVZrsmmOFh10Zrq9/gQdIba8cUm9vzDDMUawLWEhM6recTmFRQZq" +
           "hRxHBTIm1R6iSkoVWXcmOo1Xh0Z/Iowms4Uz95pIu0YUA7Hqq06HHXUazrDS" +
           "wi0tCodkOihZZUMvwI5dLKn9ZqAkXWTT9n1vFPidsj43xK5JrxvKONz45THX" +
           "w+WlVGF8nXFNV5255rLRHw9JvSot+JaiWYlvOkjKd1J4GjcDHhO4gEOShRFL" +
           "ZVtdzhLKlsZzlm3WN74vIngp2YgbA/Ur+AJ3+x1GLQ6oFazQa6zg84PuUPQk" +
           "YciJ/XqLGfbJId1sBWtx0pn5m+7c1K1GwLmYxtRmXUsyu8pKkkRR5jckSteG" +
           "cojXGW4tkwOij7anC05pdkNj4pG8hITNdYBPEXSSjJ1hpJQEYWJgTlhsLlxk" +
           "3SDnZlfm1JUoVKxKaqv1TVlJR+iSTBq1SBettYJMGqEqiKhht+oRbQ75oD83" +
           "Fmm9Ki7KtLgZ0sPZgJosJvamN6tYjqRTLWuE1kmTw8D1ggwWul2XOoyrMv2+" +
           "nLRipcYRZZjqbapVcIUiBLU3Sxs01Se5mj/WUiasLLywaHbWaaMxrBeZJVJg" +
           "W5yyKWBxKxmateqAr4Uiha+XQjhgY7sCs52FLdjk3GgQJrJAmDnaG+NmpYPj" +
           "LocK3SXlKd3i1NYY2B50Y44wvcFwqJoiR6zndDSaw9TaiqoFuL8oV+3WrKeJ" +
           "+sS0xkFz0+LF2CxPhTktz0hXp5t8mfWGCdrayOOyqhf8RUFtBXU67ZebPdsd" +
           "F92J3x4Tgg83C7NOLQxt2hQxwZqE5WATkN3KhqmyfZNxG85mJLujhrRuFlpS" +
           "lS9P2ObEw1shPRImimBwfG9ZWPYpOUx0Zpk6s/Z0OrNtGkaL2iT1lNa4i66x" +
           "Rm1JWiTrzsAKEZkJnTKMVQ8Kgl6VqcZCKzWlulVvdyt0iA3GcAlttb3VlEeE" +
           "Gk016aBRkzvzdmfl2Rxtzjv9SXE1KU3dmBBdujefqVGAuDHYYQ0s2LirdbXD" +
           "JFNd6xurVdfQemnYlfWaO6rBsu6Ph9pCW7EyK9catZh0RlhPLuHLpTwdTuoe" +
           "Rky6iVyryB0u0UelmtyrF+YjBI79SZWLV705xrqb+oLT3Y6Jhgod4D5N+5LL" +
           "m2YNrvM+j2GTuh1M605n7bZiJ3WJkCzBZdyUp2HdaZJhzSeWRYYeeJhOjmad" +
           "zhQjomqFHkhtMAtCrHkC5Yce3BBwckQjOorI7WbZYkcY62A6oXYKXF0Xapuk" +
           "zrS73c5wBGCTryaY7A6GWKWLlvyhSobzmEsTbyZzZNFMsFmxEuLJmlxZG2JQ" +
           "S2UkTMdBHVXheV9W4OLExzfhbE5bzHxT4xCsv4QtniIIJobhQriW7IrDN0d4" +
           "Z5Us3DGiyiTbLS4X3Uhy9bjHL+r9ZUFpeGW8O+4NiagM16g2TNHUKFrM6mit" +
           "0cY68xU8XeOBBi6dWlgptkpzw+Ln67C35Cu6Tw6JVqxzPG9OyhWsajZrnXmz" +
           "yNqh3uyYnOUwQjoxWiGn4cKKbHqNtKqIo3bqdhvdFjJnB15c74MNglyNXR8r" +
           "dJVSq0jPTEEgFJv1rBreMeMyMSEXmpz0hy4VhGgBM4QqGdS0ak/k08SgABKn" +
           "0nqgrkheKVUaQs92OHMwWBh1EqcsNKQImKjgfhrxlagjKW2exNaFClwNBgpp" +
           "LOOKE/Mlu6hWxvDcxG13WcbsdTsma+NCa7yICbjIyHPHROg5WWCLBcGSArJQ" +
           "ody6164iQ37gCmuyGBRKypQnCLlFuq3OGq5NmHVhoC8dRBxQdU1tIaUOzNCF" +
           "RIqoXsNrUON51eTNEoD9cYHG0d4ajwuwOSB0hOODaZkrYJVKY7FaAeguIcJg" +
           "pSkdUlhTvV4nEZuTaUHYiNSKG/Adr1hRLRgfwEU76deoadEtWaxVGkneumSU" +
           "hx5hTWx7kBAJabQIDJ0M+i5nIORgU/PKymY4YdryqDatwyTanKxpu43RhLRi" +
           "EcR3vE5/pW3ScrGqTiWHFGCpiLU3VCXk8LAk+2Rd3qhdjLV8XZUSpAG8yNoB" +
           "zrtWoVpL19QC7Lqj3kLu+kzYpnB8hjYFVILhtVBA8MAS9SoV8I2m1A+6suxb" +
           "reasMUz1CmW2V0OK0oezruzVXGwSGKbPz1Gz7JXWhaC6CixSc4stwoGppRUW" +
           "NRVTamZI6jYyFzZcxfVXVbVcV8llhSBgONWWY0Jlaoy7oIYs3l9hZbczHMDx" +
           "ZNwyBpuCJdvDhMX1Ius4Bb8bwP4QL8lsSwmJFdoUfaThKStNVdY4TJTqJXwC" +
           "N3wSoyN+WXQmpiQYCYkjvWS8aShGOpb90iaAvbLWYxdEytN4p2wYjt1vMkpN" +
           "IkCEtAvtGJ1Ey2mcNAR0XWpUwaGtx7O0hieCVLboUXUaTkiGLw5FpdVf0o0p" +
           "U+973UoyCmnJomw2CDeJN5r0nNkaE6n6nOiVh8yQbaBmAkuGOE54JtGk+YQQ" +
           "qtWZrBYqi0odn/RoLDZLhibSuOlGNXBvrgwZJQg5cF1p2p7TTDHYTC1sbjuz" +
           "8apKub2xKKBUyWs2qbRYRwi4Fzh66HcqlZ6AovCq0/eiNmo6rOv36D7bqSj1" +
           "KhC2uapEciH2sRFaQoZav8EttPnAacKr/kpqL9zBCLd7KD+yOb40HRRsyqlW" +
           "e7rbCmLOp0oqbiQVZbNKSmQ5RZOS5C61DjFptiZtTyn2mUlx7DaN8mIUtPXV" +
           "grNsjV4zI1XlKkMx6rVYzvK7pm06acXDq/XpsMaV8Jm1KpVKnKWJpNXsBv5I" +
           "rstlFE44kSo2mySpx0XP2/gGLA2GTXzCgxPubGHP0TTAWRQX06Frx1zZbVpe" +
           "vKrDMRHVA2fCr1oJxyINs1zFELRaxapETSvMJ0aB6RgNyS8FHd6demNk0NP8" +
           "euh0SrV6r7bsAcP1FGPp+gY/GrVnqVyNq3TF7/JjLqKa82GiGvaAV4acV+OG" +
           "ZZZQY6/L9yQPWTRXRsKv1nWqRrVWEub18Vk446eiMOddv+O2W7QasEwKDqBx" +
           "wdbKQbBsq5ue3u+OtMLSns1mzlSL6qJD2JiqFiJ2kywlcDJZhBpJMgqD0DHD" +
           "oe5IKcyFcl9K/BhVFFLrVBOEpfr1qD3s4MaYGrdwnWlQpNLjDGUxiZsk56hU" +
           "hFVimOVETAkChBRKWLlhdwAwIStWQkigOldiqh7qzJoduCWNERgcOYxYW9VR" +
           "H0OL/ZKSImNpuGRGRVxpFueoxjtJxdCbhFCbcq12SY/DktiLaaVDY5PIEIm+" +
           "6I0krYmU9dlsM28gAK2VeGFi8QYn5z1+qngjFK5Ei5aYtNtGQFJyfzSjzF7A" +
           "KWrVj4qpzDQLm153JHYiclWB5wLjrBsTFJ+qAqPNugMRThjSUkOiOJLBxeqN" +
           "b8yuXPpLuwremd96j56bwA0w65i+hNteep2bflbt7lKbeX7m9tOPFsdTm7vM" +
           "zZnDO/crs9R9UpLzbH24AjdvgdxehbPs0/3Xe3nK02zPvPupp5X+x9C9g5wY" +
           "Dm7+Bw+Cu5n2AJvHrp8j6uavbrtEzRfe/c/3jd+kv+0lJO0fPCXkaZa/1332" +
           "S+Rr5V/fg244Sttc9R54ctDlk8mac4EaxYEzPpGyuf/I8Hdldr4fGPU7B4b/" +
           "zrUT59f34uu2wfIi+cZ3vUjfL2bFOyLo7ELdpqzyRM8utp74cZmE4wzzhvXJ" +
           "R4HXADFfONDthf8b3c7sCEo5wa+9iILvz4ongYLhgYLXzKGsXEPZKf0rL0Xp" +
           "NIJeduxx6nBxvPYne9cCEX7vVQ/p28df+dNPnz97z9P8X+evOUcPtLey0Fkt" +
           "tqzjCcFj9Zu9QNWMXPVbt+lBL//6nQi693oiRdANoMwl/+0t9dMR9IprUQNK" +
           "UB6n/N0IunCaMoJuyr+P0z0TQed2dGC1byvHST4OuAOSrPoJ7xqJvW3+ND1z" +
           "DCEOYi732sUf57WjIccfhTJUyf/h4RAB4u2/PFyRP/M003v785WPbR+lZEvc" +
           "bDIuZ1nolu372BGKPHxdboe8bqYe/eEdn731NYdwd8dW4F38H5PtwWu/ALVs" +
           "L8rfbDZ/dM8fvOHjT38zzzP+D+aCRL6JIgAA");
    }
    public static interface ValueProvider {
        org.apache.batik.css.engine.value.Value getValue();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "1TAQGnwX8dS+UHAjByO+WYbxf2I8gPDpIQAA");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL16e7Ak11lf37sP7a5k7WplS0JYsh4rB7vt29Pz6pmIgGd6" +
           "pqd7Hj09093zSvC639Pvnn7ONMgFriJ2hcK4EplHlVH+iA3EGNtQcSCVOKWE" +
           "SmxhIGWKApsqZJJQFT9wxU6KQHDAOd1z33t3JXsFt+p+t2+f73znO7/vcU5/" +
           "53zs69CFwIdgz7U2muWGe8o63DOsyl648ZRgr9uvMIIfKDJuCUHAgXc3pac+" +
           "efX/fOsDy2u70MUF9KDgOG4ohLrrBGMlcK1YkfvQ1aO3bUuxgxC61jeEWECi" +
           "ULeQvh6Ez/ahe491DaEb/QMVEKACAlRAchWQxhEX6PQ6xYlsPOshOGGwgt4N" +
           "7fShi56UqRdCT54U4gm+YO+LYfIZAAmXsv8nYFJ557UPPXE49+2cb5nwB2Hk" +
           "+Z9557VfOwddXUBXdYfN1JGAEiEYZAHdZyu2qPhBQ5YVeQE94CiKzCq+Llh6" +
           "muu9gK4HuuYIYeQrhyBlLyNP8fMxj5C7T8rm5kdS6PqH01N1xZIP/rugWoIG" +
           "5vrQ0Vy3MySy92CCV3SgmK8KknLQ5bypO3IIvel0j8M53ugBBtD1HlsJl+7h" +
           "UOcdAbyArm9tZwmOhrChrzsaYL3gRmCUEHr0tkIzrD1BMgVNuRlCj5zmY7ZN" +
           "gOtyDkTWJYTecJotlwSs9OgpKx2zz9fp73//Dzuks5vrLCuSlel/CXR6/FSn" +
           "saIqvuJIyrbjfW/t/7Tw0KfftwtBgPkNp5i3PL/+I998x9sef/GzW57vPYNn" +
           "KBqKFN6UPize//k34m+pn8vUuOS5gZ4Z/8TMc/dn9lueXXsg8h46lJg17h00" +
           "vjj+z/Mf/ajytV3oCgVdlFwrsoEfPSC5tqdbit9RHMUXQkWmoMuKI+N5OwXd" +
           "A577uqNs3w5VNVBCCjpv5a8uuvn/ACIViMggugc8647qHjx7QrjMn9ceBEH3" +
           "gl/oAgTtPgDlP7v5ixDSkKVrK4ggCY7uuAjju9n8M4M6soCESgCeZdDquYgI" +
           "/N98O7qHIYEb+cAhEdfXEAF4xVLZNiJSALhdG8FZdjhgJx0wFdffyxzO+7sb" +
           "ap3N+lqyswMM8sbT6cACkUS6lqz4N6Xno2b7mx+/+bndw/DYxyuEymC8ve14" +
           "e/l4e2C8PTDe3onxbkwEK1LATGIdSIR2dvJBX59psfUAYD8TZAKQI+97C/tD" +
           "3Xe976lzwPW85HyG/joPzUfyf86Bfm+5fd4msqRB5YlSAn78yF8NLfE9/+0v" +
           "c82Pp95M4O4ZsXKq/wL52IcexX/ga3n/yyBLhQLwKpAAHj8dsSeCLAvd04iC" +
           "5Hskt/hR+893n7r4n3ahexbQNWk/s+cgsQrIrlf04CDdg+x/ov1kZtqG4bP7" +
           "GSCE3nhar2PDPnuQRrPJXzhuSfCccWfPV3KvuD/neeDb4GcH/P5N9ptZInux" +
           "jYfr+H5QPnEYlZ633tkJoQvFPWyvkPV/MrPxaYAzBf4B6/38F373K6VdaPco" +
           "tV89tlgCEJ49lk4yYVfzxPHAkctwvpKB9cc/y/yzD379vf8w9xfA8fRZA97I" +
           "aKYxWBvBGvPjn1198Usvf/j3dw997FwI1tNItHQJPAT5UgdmouqOYOWAPBVC" +
           "DxuWdONg1hOw9AHFbhgWlkP1BrDY56plVtnbrhd5eAGNbtzGXY+t8TelD/z+" +
           "N143+ca//+YtnnoSmIHgPbu1UK7VGoh/+HQUkUKwBHzlF+l/dM168VtA4gJI" +
           "lEB2CIY+CL/1CRj3uS/c80f/4Tcfetfnz0G7BHTFcgWZELLlGCTVcAlW8CXI" +
           "BWvvB9+xzYrJJUCu5bEJ5fP/3q06eVjffwRE3wXL5k/86Qd++6ee/hLQowtd" +
           "iDMfBhocQ4uOsp3EP/7YBx+79/k/+YncJhC0w/x0+9o7Mqm1fIBncvp9GYG3" +
           "Fsse35aRt2dk78BMj2ZmYvNs2BeCcODKOthJyLml7pg6GF+3gbfF+8sk8tz1" +
           "L5kf+vKvbJfA03niFLPyvuf/ybf33v/87rGNx9O3rP3H+2w3H7nSrzs05ZN3" +
           "GiXvQfyPTzz3b3/pufdutbp+chltg13ir/zBX//23s/+yUtn5OrzlnvglBkt" +
           "7g+b/am8smHDq18gywHVOPjpowu8NOLRsQ1HJZuMKaIxkgZ+ocGssICsrhpo" +
           "iHNEQ2rTLGFStC/FAUaj5pxc2HbfFvu4tlKWLHBIblOj2ysPW5TDXhFfF3yV" +
           "d7xgInDzuVNsoKbMzDDM1WR6GhKGh9RrWJQOsKJc1BozeoiYqY3ECoLAIYyU" +
           "kJghdd4iNNueetTUTHpBn++Eo74M00lojwU6FGx2wRaJcE1WLKMexwrWJjdB" +
           "EW5bXr/qeFZ1PZyKfVelpquBEM2cXugS3qBgT1b93ry0NDpVbhqOJLOr6wKG" +
           "mn6ni3Yb64k5nk1XkuQO4jG1cA2eLW8WrMF1BUoKtS7RpYQKbXYCTmT4TUiN" +
           "KUtIRKFS6LYxyg77TsdsqUu/I635pSx0RyiVsGMO7TSpYLLsb3TO6Yiramgi" +
           "k+kct6cdHOQfMtTb06VeVspzxW+FCqzEvSJi+OEy7I29YTSwp2bkekLQoptz" +
           "PZQwUfZ422/NzKlF8dSKllIqKSzrvX7TJscUvhHCUF02oqK/WiwG4dCRyK4w" +
           "nXR8atVsGDzWIzpdyutOk3VpsnZMojUU6biy6DeLUiAKcl+rd+0y0seM0FjF" +
           "K1I39VAsmpOQxFdUecAazbnXlCR2SY8FaxUGY52uL7rV1ohSvNVcX0ludVh3" +
           "aSvsOSybdHuLZhHHKoNOyJlCuoI1U8fF6YJdAO0GLDI0az7sb9iIdVBNqNLG" +
           "CmsmjF8mG5tgwg82A7bSxOoep6Nzd1ou2TzD0sYcGUySRpPbrHt8XYkW3txF" +
           "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" +
           "pnUIve7ExcWDaHnzq7v1CHatj9xyzXp7");
        java.lang.String jlc$ClassType$jl5$1 =
          ("NVj6+AtXLz38Av+Hecnl8Pru5T50SY0s6/jNvGPPFz1fUfUci8vbKkuO384z" +
           "IfTI7VQCmytAM813bmy5vy+EXn8WN+AE9DgnDD6iT3OG0IX873G+vRC6csQH" +
           "1pntw3EWFEgHLNljMbsomEN56375+iuZ71jJ7+nbfiUOou3F95vSJ17o0j/8" +
           "zepHtjcNwaY9TTMp4DPsnm0hKxeaFYWevK20A1kXybd86/5PXn7moIh4/1bh" +
           "o6g5ptubzi4xtW0vzItC6W88/K++/xdfeDm/7fb/AWgxMuSPMAAA");
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
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "Azdz5k0TJ3GgEn/Y/wMxm+jB0TIAAA==");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "2b62Y/zcWSG/Gkif24Wcu/GOkf78iZS8");
        java.lang.String jlc$ClassType$jl5$1 =
          ("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" +
           "LDfMzmasf+v+33z1rz315ezS5/8DpE6IqZxDAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Xg58mOdNOhsFYwyMXXNi83c65BNfQrOj0KwIqdUY0CEb5gqoZEk3THvvhV/P" +
           "3XqyjgT7SIusCsk+gQ840gxMp8YYJNKc9u01piMTTVB0cDxIEUII+qLS3bkh" +
           "ozHeAZO/mPfMDT89/CFnoUm7hZY6/3IZL6/AYgWvD+LjlYw0CVYazuVR4mqz" +
           "7HnO/nSh5DIf4M/zGfnmBWb9EtkeQb/Eb1XDV2RH7j54ODnw6Epz7dFZuFLY" +
           "AAvho2//5/XQoT++WmI6arRWpY7PM6G9xUXTRT9f8TmpbvWp83Xv3zN/RvFM" +
           "gZa6fOaB5f7zgLeBl+/+YsEt3xrbWsUUsMiDktfkz/qfePWmpeI9Qb5oNbN/" +
           "0WK3UKnXjRc0qlNYnSsYFta08gHUnafGYmTCMqDEnRY17vQOIDNXl6YcI82a" +
           "rjIgL01i9XqHc8h/sqCM4TLZ47Yy77ZgMQQ0T1M2IshZavP18pJ8pUoa5rPQ" +
           "OEqGHPnVWAyb3vZe2JjFijW8enM+yHZ8FYbgdltB7q4CvQAfsB7E2soY86AS" +
           "KByvHTyh4FYmZG5leNtj5ZXmI2gTq0Q+rtcP9G/IiVRDznJlvttIMNKmw0Yf" +
           "6B8ZA+s0CaNtWZl9tC5lYF4et3Yi4anOj7Y/9NlRc6R7ty0eYbr34L6vQ/sP" +
           "mqPe3NstKdpeuXXM/R33tgOLq3I8F5RphWv0fXps6lePTe0JWqzaxEj9uCol" +
           "HXKItSHHOujHR6z+fKQMObCgxVTwU/X0atAcjny+daVBPH8ZzsJ04IH52Nzz" +
           "O34zbXK9vfMrpWJK3mz0v/ncxk/jPKU1Yc7MJxJXvlyrp11rPLsf8ENzPTNG" +
           "GmCW1FkRGXGv6PHBbL5x5cP/2vWDdwZgdRolTVlF2pGl0WRhgptmZBMup5wt" +
           "t5PuLI9wkcZIYLlmzad3lXE0BRN8kaP4dW+Om9xVelzh1wwXOIDFJCOzYez0" +
           "oTGefKwRhO8Mh2t31IZrK4ECL1iEeaF6rvmp+kcqcasPVoLiISzugwyVhkW5" +
           "4kokHhjurw0M6yGGj61YPq4eBj/V0kMOv96NxT5u+ieVsHgMix/BepxjUYkY" +
           "P64NIlcTUhc0LZifVSHiq1qJGE9XAuMZLI7CIj8BCPjz4snaoBCBELqtULqr" +
           "R8FP9YJ4cbwSFCew+CUjcxCKSrR4rna0iFhRRaoHxE+1Ei1+WwmL17F4EWih" +
           "pxN8j1EahZdqR4sRK5SR6lHwU/WnheRA8XYlKN7B4iQj82woopFIGUhO1SyD" +
           "1qWsuFLVQ+Kn6gm2jvtRlx8pLlz+VAmXv2DxAcNLBV8wPqwNGN8AH6esiKaq" +
           "B8NPtdIo+XslCM5g8TkjszgEg7qKZ9+lkfiiNkgsgTAesMJ5oHok/FQ9gbo3" +
           "e/+uBMJXWPyDkVYOghGRqaAXhX+uNuGHwPejVgxHqw/fT9U/RD51BBorYBBo" +
           "wiLA8AoFMYgqsNLHGzovDoFgbXC4HoJ40Qrmxepx8FP1T5j7Kq3W6ySlzFo9" +
           "0FkJwYuwaLWHUlQxqM5och1NqTr1YNhWGwxBqu4TC4hPqsfQT7UMhuj8LB7t" +
           "kkpwYKuBLntQDVEN74m8ZFpUGyCWEVLfYFowP6sCwlfVN0QLg3AlDFZisdye" +
           "YIZoRh0vgmBFbSC4AvxfYsWxpHoI/FQr5ZXeShDciMV1jEznEKzVNKp4EVhd" +
           "PQI5RhaWuSjkWvMZWXphp8+GTuYX/cjBvJgXnzzc3jTv8K1/4Fdb+cvzGTHS" +
           "lMrKsusEwX2a0KjpNGXOwDPMuwaNg9FnnZWVcgkSEJToeWCDKR2FfX8paZCE" +
           "0i0Zg22xV5KRBv7plhtgpMWRY6TRfHCLDIF1EMHHYc3G0XUqaN7m58yzv4K7" +
           "BD5LzqnUl3kV9zUaHv/xH6PYZzdZ8+cocfHY4U2b7zh73aPmNZ4oC5OTaGV6" +
           "jEwzLwu5UTwEX+xrzbbVuHHZl21PNV9mH9cVXCO6feMUAxbzK7cFnnstoyd/" +
           "vfXukRuOv7G38VSQBLaQgACpf4vrpyAmUr05LauTRVtipc6mRgSdX7n1tvx5" +
           "65v/fC/Qye9piHma1VVOIy7ee/z9wZSmPRgkzVHSIClJmhslLZKxfqcyRMVx" +
           "veCoqzGhZpX871bakMYCnu5yZCxAW/O1eMPLSHfxkWnxrXeLrE5QfR1aRzOt" +
           "nmuDLIx311uO7B5z2kWkgWvxWL+mWRefwUMceU3DQR5I8cn3f+yLw5hxJgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Ztix50tBpOlWobsHd/fEgkIN/MHG/DSR");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("QGQANJf83GjHPQE7ztO4ASegxznnYKd2khNscYvv43w/lkBXjvgS6NLu4TjL" +
           "B0HvgCV/vBkc6vHYTbDdRbp0d9DwxHG/K5bZR86y4q0mx++85qdjxf93HJ5k" +
           "rXb/4XFT+dIrffYnvt/4+d2dW8WRsyzv5TINPbC7/lt0mp+GPXPX3g77ukQ+" +
           "/4OHvvzguw+P7R7aCXw0B47J9q7TL7XibpAU11CzX3vbr/zwv3jlD4qrcP8P" +
           "KZ04/HgzAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "wZ2frOvqbEvI1MB9mCtPYPE0IxUAUTska669ZMwOcvwZdz3vYXjgANFsJj3m" +
           "iqmjt2dfQdoctrEZnjqsuVTzxM2p3JD/kAv8DIsTjMwA1MRmwWHDWtXx/6e3" +
           "7D+/eVkMxlu2E9bU/c+lmsf/Vybz/zQWv7T3Dj2O14xpOUh9Rk4shBxsXr5l" +
           "bPDLc45dtoO7po5NLtU82JybDJvzWLzKSDlg0wPHlTRgZnmBQQkHld/dMioN" +
           "2HQnuPSI7dojU0cll2oeVN6eDJXLWFwSVNyzfi2/AUtDpiEDGVvKQefNW0Zn" +
           "JjbNAdeetF18curo5FLNg85f87RdweJDRkoBmBBk6WxoMvItULRJqfej2xNI" +
           "CNUR298jU4cql2ruYPmE93o9D16fYXGNkUKF2W+QsgUPnME9h5x/Th2RBCPV" +
           "GZe0ySEXf7FbXkjqGjJeK4lXIfILE5Ul9RP3v82vFVOvK8ohR47GVdWV27nz" +
           "vGLDpFGFQ1EuLnkM/PEV2ChkMwliBkq03OcX0sU2FXmlQRJKt2QprFmvJCQA" +
           "/NctVw6HKkcOjnTiwS1SCb2DCD5WGVmOXeL9SUJkLmmXOHwGayebwZSK+woT" +
           "Dw389V8yq46LF4BwgJnYuHnXtXufE1eosiqN8UU3HXJpcVFrH0fcSb63t2Rf" +
           "xRuW3JzxYumiZJKfdoXrto0HFgQ7v+uc7blQtJpT94qXj68+88a+4ktwPOkj" +
           "PjixzuxzvXwTSLUkjLhJ5vWFsp0atkomv+tsKfvLtgufveur4RdkRJwzGvNp" +
           "9MuHzrzXHTWMH/hJaQcpgjMMTfSSMsVat1OD/WrETDuEFA/A3p56UzgDw1jC" +
           "jIgjYwNakarF23VGmjIPWplvHMpUfZSaa7F37KbCc5ETNwx3K0f2UcGUiDTE" +
           "Wn+o0zDsG2f/Mxx5w8Cl7VvI+fJ/uCp0DOMfAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "5vXfKQ/3/y836lykQCwAAA==");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "lynbprHO0EuVRMD6VDOilhuMZjHMk+sbBBvKNIDrkinhVLnb6hNEtt1454+2" +
           "47sn39weXUqAjV420P4RdjrprSfci6GLfujFYHOvgQ3dBUmO4lBS4vTo0C8/" +
           "/rjvNQ79jh2MQNkO7+Hb3Ufku7uPPXvjJbX38eLewYHSGGzoD66JdnKyLfZb" +
           "b7+NZfO7mN0px+ef/ZcHh+8w3v0jnOM+ekrJ0yJ/l335i+23KL++B509OvO4" +
           "6ZboJNO1kycdl0ItTkJ3eOK84+Ejt17O3EUBd370wK0fvfVZ6i2jdiZPk21y" +
           "nDqs29uGNf8/OJYUYgydjwwvzI8d2zlrcor1zIHvDw5MHsiO7VclJT+pb/ZY" +
           "MlU0P3NrzrzJGrDjvjvS4u15Sn5qdKt5zy09U91lafCD9uMnjt3ADCfvBQ7V" +
           "e8sPd6sAMumBm64xt1dvyqdeunzh/pdGf50fpB9dj11koAt6YtvHT62O9e/w" +
           "Q003cx9c3J5h+fnP8wceu5VKMXQWtLnmz22p3x9Db7wVNaAE7XHKF2LoymlK" +
           "EMv89zjdr8XQpR0dqKpt5zjJDSAdkGTdF/1DP2I/5O0McYAMR4FIz5ys/KMA" +
           "3/uDAnwMLJ48UeX5tfRhRSbbi+nryqdforn3vFr9+PbeQLGlTZ58Fxjozu0V" +
           "xlFVP35baYey7qCe+t7dn7n45kP4uXur8K7Wjun26K0P5knHj/Oj9M0f3v/7" +
           "b//tl76WH+f9L0blbhAvIAAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "oGHYV7zwk9zzhsFL/wKHn/8CV9Mkr08XAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "LOsEX+klqxHPlFKyWjLl2F02GHq+7DgaNgSj8yW+8rwl4lixiVqWGxhzHveb" +
           "XkoMQk238bg4tZgpl7hiTLgDZCiG/QFiWcwYcRrzSVJyFAkhPMJM/GW5hlQM" +
           "bMQ163IV6VVlveUPta4/1VEfHrVbSmI3Jc8rrrW+2DM8ttcZ416qKG1lVO5P" +
           "+mzXE2Uen6NNCR8Fqd8D+k24dGTJqIVTNKev00nSkJqYVBeHJOmsN2rCDTcy" +
           "gyoTdFAPCsuo7W3kVkwr1XgdMjBvIFSpaZmOP6cXblC21aBgpVLahYmQ5VfT" +
           "ECStLFgaV+VMnaRGvjwx8aDPUEM2sT1L6M0or9Vno2KfbElo3QslxlkR/U0E" +
           "crzvs8amz6i9frExTJNKI7KJAW1Jc7fZYJtrRqyFklsIEZ5Zo34Z662bHi10" +
           "fGrgr+pqme8Ny4TYKYa9xQDXLBmusIWGgCCF8VyW+3hMlHCuZRZgocnPlRjj" +
           "gqKlCMiyJwmD8kJdOL4k+OZyVTFL09pswfoLhfeGIdvEsK5qo3ZzHNt8uYYX" +
           "3d5A4DjK4nhEmZnjcQXzRjO20mG9aY8f9YNYSRekGi18pEQxI3mE2C2JTJlu" +
           "u7G0+lO60PVwx+h21cFgLruy507lNj1oDlm/sCytbFilSGVE4OOS2tp4y2EJ" +
           "rbu4xqxhdF0mB02+NhCjJqixejBizqw5J6pSifPsedNZcn5R7vsdOJr0CNch" +
           "8VifDI1SvWWwNReGu6PQqlaFkTvvmG1FqDqybaVtP2mbynxhjAf6XFZayWLS" +
           "MteTSm/pVFsKyUw2CZwIw0lJqUjypEkyTcyoNI2eNYyKpdHEIW1fCHQUq003" +
           "qaaRy4BOw26JKg6XPSqh07ad6A1BpHoURjLVutvicMpbmkGDbs8poZ2iG9IW" +
           "cQYvdGWCxPF+qVqT9RGBVeKuRk0aaOL07AJTFTmrVnVG7VieG2sXlYSxWC7o" +
           "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" +
           "8huezR+++vff/MlnvpmfMv8vNtzfKcQiAAA=");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HzAM+5IXfop73jB48V/kAPRfuQm+VVMXAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "eJI/fvkfvuFjT389u2f+X7TXQ5nIIgAA");
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
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "HS98kXveMHjtX+X4818bd9eFURcAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+cNX//6bP/XsN/Mr5v8FFq9XR8IiAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xx83/Q8+tpXiljcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pIOKDVV7DqrSBEW6k7BGd+XAH6PDPqUl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "w/bzuz7pr9736Tf8/FN/nF9k+b+qX4tM50QAAA==");
}
