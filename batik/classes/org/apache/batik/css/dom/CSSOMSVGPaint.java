package org.apache.batik.css.dom;
public class CSSOMSVGPaint extends org.apache.batik.css.dom.CSSOMSVGColor implements org.w3c.dom.svg.SVGPaint {
    public CSSOMSVGPaint(org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider vp) {
        super(
          vp);
    }
    public void setModificationHandler(org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler h) {
        if (!(h instanceof org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        super.
          setModificationHandler(
            h);
    }
    public short getColorType() { throw new org.w3c.dom.DOMException(
                                    org.w3c.dom.DOMException.
                                      INVALID_ACCESS_ERR,
                                    ""); }
    public short getPaintType() { org.apache.batik.css.engine.value.Value value =
                                    valueProvider.
                                    getValue(
                                      );
                                  switch (value.
                                            getCssValueType(
                                              )) {
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_PRIMITIVE_VALUE:
                                          switch (value.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  {
                                                      java.lang.String str =
                                                        value.
                                                        getStringValue(
                                                          );
                                                      if (str.
                                                            equalsIgnoreCase(
                                                              org.apache.batik.util.CSSConstants.
                                                                CSS_NONE_VALUE)) {
                                                          return SVG_PAINTTYPE_NONE;
                                                      }
                                                      else
                                                          if (str.
                                                                equalsIgnoreCase(
                                                                  org.apache.batik.util.CSSConstants.
                                                                    CSS_CURRENTCOLOR_VALUE)) {
                                                              return SVG_PAINTTYPE_CURRENTCOLOR;
                                                          }
                                                      return SVG_PAINTTYPE_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  return SVG_PAINTTYPE_URI;
                                          }
                                          break;
                                      case org.w3c.dom.css.CSSValue.
                                             CSS_VALUE_LIST:
                                          org.apache.batik.css.engine.value.Value v0 =
                                            value.
                                            item(
                                              0);
                                          org.apache.batik.css.engine.value.Value v1 =
                                            value.
                                            item(
                                              1);
                                          switch (v0.
                                                    getPrimitiveType(
                                                      )) {
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_IDENT:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_URI:
                                                  if (v1.
                                                        getCssValueType(
                                                          ) ==
                                                        org.w3c.dom.css.CSSValue.
                                                          CSS_VALUE_LIST)
                                                      return SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR;
                                                  switch (v1.
                                                            getPrimitiveType(
                                                              )) {
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_IDENT:
                                                          {
                                                              java.lang.String str =
                                                                v1.
                                                                getStringValue(
                                                                  );
                                                              if (str.
                                                                    equalsIgnoreCase(
                                                                      org.apache.batik.util.CSSConstants.
                                                                        CSS_NONE_VALUE)) {
                                                                  return SVG_PAINTTYPE_URI_NONE;
                                                              }
                                                              else
                                                                  if (str.
                                                                        equalsIgnoreCase(
                                                                          org.apache.batik.util.CSSConstants.
                                                                            CSS_CURRENTCOLOR_VALUE)) {
                                                                      return SVG_PAINTTYPE_URI_CURRENTCOLOR;
                                                                  }
                                                              return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                          }
                                                      case org.w3c.dom.css.CSSPrimitiveValue.
                                                             CSS_RGBCOLOR:
                                                          return SVG_PAINTTYPE_URI_RGBCOLOR;
                                                  }
                                              case org.w3c.dom.css.CSSPrimitiveValue.
                                                     CSS_RGBCOLOR:
                                                  return SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR;
                                          }
                                  }
                                  return SVG_PAINTTYPE_UNKNOWN;
    }
    public java.lang.String getUri() { switch (getPaintType(
                                                 )) {
                                           case SVG_PAINTTYPE_URI:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 getStringValue(
                                                   );
                                           case SVG_PAINTTYPE_URI_NONE:
                                           case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR:
                                           case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                                               return valueProvider.
                                                 getValue(
                                                   ).
                                                 item(
                                                   0).
                                                 getStringValue(
                                                   );
                                       }
                                       throw new java.lang.InternalError(
                                         );
    }
    public void setUri(java.lang.String uri) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              uriChanged(
                uri);
        }
    }
    public void setPaint(short paintType,
                         java.lang.String uri,
                         java.lang.String rgbColor,
                         java.lang.String iccColor) {
        if (handler ==
              null) {
            throw new org.w3c.dom.DOMException(
              org.w3c.dom.DOMException.
                NO_MODIFICATION_ALLOWED_ERR,
              "");
        }
        else {
            ((org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler)
               handler).
              paintChanged(
                paintType,
                uri,
                rgbColor,
                iccColor);
        }
    }
    public static interface PaintModificationHandler extends org.apache.batik.css.dom.CSSOMSVGColor.ModificationHandler {
        void uriChanged(java.lang.String uri);
        void paintChanged(short type, java.lang.String uri,
                          java.lang.String rgb,
                          java.lang.String icc);
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
           "7WSpROQ2FbopbNsVFrcYlq0ZgSkrm37gyGxvKq8WzWAYbb2tNEKH3HAolZbo" +
           "AhkYXr0WV7xlc4WsVL4erkZSeTwb08twRqzaq7I2GAb2jB7AWtflHRVVzXl5" +
           "aseOlQaLWt9vjD1fL/n0JOh2+Szs2NS6M5iJHkWxqOawcXlMY6v2psKnmDvw" +
           "qKk2ngmaYSp4r+6kJh+bDRqZ4BirNetoyIwEuOMta3V0Cber9AZvJr0sA3tv" +
           "Qnpch0nkqmkulNZwnMwGRNgs08JqWmWqSlgFvu8qvUBXtJ5Vq+LopLUaLvjN" +
           "UI2J/rRfJoOthcGJRIlSFWnM4VafJbKV0SYsjWsTTNmI+ms6rentLiF60iKt" +
           "ZQwymXlJb6OGlEqutgHcaDTwabUxxNRSUguRaFMCb3vlJtxiGdpFZKxMpEKI" +
           "dX2zxm/DroR0mnCUoYumXJlwacVnnTJBVLpTQnKmgdZo29lsY6STlqo15tO5" +
           "4y05jcBogZW0sIV1PLY7csdomg5wrh7DIixVTc2ojuTZXEo7bJvFVwO2Ta56" +
           "tFib9JdB6rYWS0GVjf5g0mTGG9yo1a1JaYPKNLyeT1S064+4MTgcvO1t+bGB" +
           "+sFObvcUB+yjZiw4sOUPyj/AiSW7NcNzBcMEuigrcRKBY23BO4EuHbWIdyKc" +
           "aDOdOTzV/+gr9rpw3/Gja7doc+Unuodu168tTnOfeN9zz2ujTyL5aS7n10mg" +
           "Cwdt9GNR9gCZt9z+2MoUverj1tIX3vdPDwpvN58qeis3tbxo6HKOyeafBI5a" +
           "/284JeRpkr/OvPAl8s3qh/egs0eNppu66DciPXlje+lypCdp5AlHTaYIevSm" +
           "s66v6loa6cd83/JG+cXrn3/62h507mT3Lafw0Kle1p2GH7mykzM4bNtfTszI" +
           "Xx+vnGxsAbPmYQM9Bq7PHfR1i//86auDfHxNdhx4N0XU3lEIcwehE0FvPu6p" +
           "gJBwdLWw+jXRc4vQkBVHz/ub/3nlTciL//zs1d0B3QErh2544pUJHK//UBv6" +
           "yS+/+98eLsicUfMPIcddomOwXXf91ceUsSiSN7kc2U/92UO/8gX542ehMxR0" +
           "LrbAES9vd5/ZhX+ReYVqZqG7WoyLIuF2Pdn8fpkP1xPochpZuCl7C3330eQd" +
           "JxIVT6BzK9/SjjP4qVfqOZxkUyy860avUeB68cBrL/6fvHajaud21eJWKpyP" +
           "TT9KjupR+dg+6+9jn/fmQ5RAdwV5J/zAQvmac2yN+AexRpZAD9yuq35Ysd78" +
           "v+vOg7B44KZPfrvPVOpnnr9y8f7nxb8oEu/oU9IlGrpopI5zsm18Yn4hiHTD" +
           "KvS+tMu1oPh7P5D5diIl0FkwFpL/9A76mQR6za2gASQYT0J+MIGunoYEjir+" +
           "T8I9C+LzGA5U2N3kJMgvAOoAJJ9+OO9in6i+BxFYuOreV3LVEcrJNnResYtP" +
           "sIfVNd19hL2ufvb5/vA9L9c/uWuDq4683eZULtLQHbtydlShH7kttUNaF3qP" +
           "f/fuz1160+FWcvdO4ONsOCHbG25daLpukBSlYft79//2W3/1+a8Xrdj/AT3a" +
           "qQ0bHwAA");
    }
    public abstract class AbstractModificationHandler implements org.apache.batik.css.dom.CSSOMSVGPaint.PaintModificationHandler {
        protected abstract org.apache.batik.css.engine.value.Value getValue();
        public void redTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void redFloatValueChanged(short unit,
                                         float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void greenTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void greenFloatValueChanged(short unit,
                                           float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getBlue(
                          ).
                        getCssText(
                          ) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void blueTextChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ")";
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      text +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void blueFloatValueChanged(short unit,
                                          float value)
              throws org.w3c.dom.DOMException {
            java.lang.String text;
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text =
                      "rgb(" +
                      getValue(
                        ).
                        item(
                          0).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          0).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ')';
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0) +
                      " rgb(" +
                      getValue(
                        ).
                        item(
                          1).
                        getRed(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      getValue(
                        ).
                        item(
                          1).
                        getGreen(
                          ).
                        getCssText(
                          ) +
                      ", " +
                      org.apache.batik.css.engine.value.FloatValue.
                        getCssText(
                          unit,
                          value) +
                      ") " +
                      getValue(
                        ).
                        item(
                          2).
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
        public void rgbColorChanged(java.lang.String text)
              throws org.w3c.dom.DOMException {
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR:
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    text +=
                      getValue(
                        ).
                        item(
                          1).
                        getCssText(
                          );
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text;
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    text =
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
                      text +
                      ' ' +
                      getValue(
                        ).
                        item(
                          2).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ) +
                      ' ' +
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
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
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
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    sb.
                      append(
                        cp);
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
            switch (getPaintType(
                      )) {
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    java.lang.StringBuffer sb =
                      new java.lang.StringBuffer(
                      getValue(
                        ).
                        item(
                          0).
                        getCssText(
                          ));
                    sb.
                      append(
                        " icc-color(");
                    org.apache.batik.css.engine.value.svg.ICCColor iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    sb =
                      new java.lang.StringBuffer(
                        getValue(
                          ).
                          item(
                            0).
                          getCssText(
                            ));
                    sb.
                      append(
                        ' ');
                    sb.
                      append(
                        getValue(
                          ).
                          item(
                            1).
                          getCssText(
                            ));
                    sb.
                      append(
                        " icc-color(");
                    iccc =
                      (org.apache.batik.css.engine.value.svg.ICCColor)
                        getValue(
                          ).
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
        public void uriChanged(java.lang.String uri) {
            textChanged(
              "url(" +
              uri +
              ") none");
        }
        public void paintChanged(short type,
                                 java.lang.String uri,
                                 java.lang.String rgb,
                                 java.lang.String icc) {
            switch (type) {
                case SVG_PAINTTYPE_NONE:
                    textChanged(
                      "none");
                    break;
                case SVG_PAINTTYPE_CURRENTCOLOR:
                    textChanged(
                      "currentcolor");
                    break;
                case SVG_PAINTTYPE_RGBCOLOR:
                    textChanged(
                      rgb);
                    break;
                case SVG_PAINTTYPE_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      rgb +
                      ' ' +
                      icc);
                    break;
                case SVG_PAINTTYPE_URI:
                    textChanged(
                      "url(" +
                      uri +
                      ')');
                    break;
                case SVG_PAINTTYPE_URI_NONE:
                    textChanged(
                      "url(" +
                      uri +
                      ") none");
                    break;
                case SVG_PAINTTYPE_URI_CURRENTCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") currentcolor");
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb);
                    break;
                case SVG_PAINTTYPE_URI_RGBCOLOR_ICCCOLOR:
                    textChanged(
                      "url(" +
                      uri +
                      ") " +
                      rgb +
                      ' ' +
                      icc);
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
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188908000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALV7e6zk1nkf791dabW2taunVVmWJXvtRBrjch7kcAbKwxzO" +
           "g+S8OMMhZ4ZJs+bw/X7PcJiqtQ2kVmvAdRL50SDRP3XS1HBit0jaAk4KuUVt" +
           "BzECpBXaNGhjowjatI4B2UCToE6THnLu3Xv37l3dCLsaYL4hz/nOOd/v+77z" +
           "nY+HZ774XehSFEIl37O3mu3FB0oaH5g2ehBvfSU6oAcoI4aRIhO2GEUzUHZD" +
           "eu+Xr/7ZDz6lX9uH7hOgR0TX9WIxNjw3miqRZ68VeQBdPS7t2IoTxdC1gSmu" +
           "RTiJDRseGFH8wgB624mmMXR9cCQCDESAgQhwIQKMH3OBRu9Q3MQh8haiG0cB" +
           "9HehvQF0ny/l4sXQs7d24ouh6Bx2wxQIQA+X83segCoapyH0zE3sO8y3Af50" +
           "CX75sz917V9cgK4K0FXDZXNxJCBEDAYRoLc7irNSwgiXZUUWoIdcRZFZJTRE" +
           "28gKuQXo4cjQXDFOQuWmkvLCxFfCYsxjzb1dyrGFiRR74U14qqHY8tHdJdUW" +
           "NYD18WOsO4TdvBwAvGIAwUJVlJSjJhctw5Vj6D2nW9zEeL0PGEDT+x0l1r2b" +
           "Q110RVAAPbyznS26GszGoeFqgPWSl4BRYujJO3aa69oXJUvUlBsx9MRpPmZX" +
           "BbgeKBSRN4mhx06zFT0BKz15ykon7PPd0Y988qdd0t0vZJYVyc7lvwwaPX2q" +
           "0VRRlVBxJWXX8O3PDz4jPv7bL+1DEGB+7BTzjudf/Z3vfeiDT7/6jR3Pu87g" +
           "Ga9MRYpvSJ9fPfj7TxHPNS/kYlz2vcjIjX8L8sL9mcOaF1IfzLzHb/aYVx4c" +
           "Vb46/dryI19QvrMPXaGg+yTPThzgRw9JnuMbthL2FFcJxViRKegBxZWJop6C" +
           "7gfXA8NVdqVjVY2UmIIu2kXRfV5xD1Skgi5yFd0Prg1X9Y6ufTHWi+vUhyDo" +
           "UfCFSuD7W9Du85WcxNAS1j1HgUVJdA3Xg5nQy/FHsOLGK6BbHV4Br7fgyEtC" +
           "4IKwF2qwCPxAVw4rpCiCZc+BCZYdD1m+x4jAYQ9yF/Pfys7THNm1zd4eUPpT" +
           "p6e8DWYL6dmyEt6QXk5ane/9+o3f3b85BQ51EkMtMN7BbryDYrwDMN4BGO/g" +
           "lvGu4yswh0UpHnqyoRpSEQVI0ZWB5aC9vUKER3OZdjYHFrPA3AdR8e3PsX+b" +
           "/vBL770AnM3fXATqzlnhOwdn4jhaUEVMlIDLQq9+bvNR/u+V96H9W6NsjgMU" +
           "XcmbM3lsvBkDr5+eXWf1e/Xjf/JnX/rMi97xPLslbB9O/9tb5tP3vac1HnqS" +
           "IoOAeNz988+Iv3njt1+8vg9dBDEBxMEY6DIPMU+fHuOWafzCUUjMsVwCgFUv" +
           "dEQ7rzqKY1diPfQ2xyWFKzxYXD8EdPxB6JAcOXrxm9c+4uf00Z3r5EY7haII" +
           "uT/K+r/0B7/3v2qFuo+i89UT6x2rxC+ciAh5Z1eLuf/QsQ/MQkUBfP/tc8zP" +
           "f/q7H/+JwgEAx/vOGvB6TgkQCYAJgZp/5hvBf/nWH33+tf1jp4nBkpisbENK" +
           "dyD/Gnz2wPev8m8OLi/YzeaHicOQ8szNmOLnI3/gWDYQXWwwCXMPus65TuHT" +
           "4spWco/9y6vvr/zmn37y2s4nbFBy5FIfPL+D4/K/1YI+8rs/9edPF93sSfnq" +
           "dqy/Y7ZdyHzkuGc8DMVtLkf60f/w7n/8dfGXQPAFAS8yMqWIYVChD6gwYLnQ" +
           "Ramg8Km6ak7eE52cCLfOtRNZyA3pU6+9/g7+9X/zvULaW9OYk3Yfiv4LO1fL" +
           "yTMp6P6dp2c9KUY64ENeHf3kNfvVH4AeBdCjBGJbNA5BOEpv8ZJD7kv3/+FX" +
           "/93jH/79C9B+F7pie6LcFYsJBz0APF2JdBDJUv/HP7Tz5s1lQK4VUKHbwO8c" +
           "5Ini7gIQ8Lk7x5punoUcT9cn/u/YXn3sv//FbUoooswZi++p9gL8xV98kvix" +
           "7xTtj6d73vrp9PYQDTK247bVLzj/Z/+99/37feh+AbomHaaDvGgn+SQSQAoU" +
           "HeWIIGW8pf7WdGa3dr9wM5w9dTrUnBj2dKA5XhrAdc6dX185Nvhz6R6YiJeq" +
           "B9hBOb//UNHw2YJez8kP7bSeX/4wmLFRkVaCFqrhinbRz3Mx8Bhbun40R3mQ" +
           "ZgIVXzdtrOjmMZBYF96RgznY5Wa7WJXT2k6K4rp+R2944UhWYP0HjzsbeCDN" +
           "+8Qff+qb/+h93wImoqFL61x9wDInRhwleeb797/46Xe/7eVvf6IIQCD68P/g" +
           "n2PfznvtvxHinLRz0jmC+mQOlS1W9oEYHS6eilygfUPPZELDAaF1fZjWwS8+" +
           "/C3rF//k13Yp22k3PMWsvPTyP/zrg0++vH8iUX7fbbnqyTa7ZLkQ+h2HGg6h" +
           "Z99olKJF939+6cWv/OqLH99J9fCtaV8HPNX82n/6f988+Ny3f+eMvOOi7d2F" +
           "YeNr/5VEIgo/+gx4sT3fSOl0roxhuCMnfXVMdthJkjWcKUs2KWRS9voSvl51" +
           "6WDlVilvxmYGHmFSTW6iyKqmCu6KYfR1e0E2t/OpZg5nVZvmWbcR432ibxOD" +
           "UrfL+jhBcFrX74uLRtCvceX20vDYgCeMSnNVW9VkB143vXqoGKqcYDWh2aw3" +
           "mo3qqlkVqk2/O/OHqwk7kfk5ZY7E0YRqsnY0H+GjngdTmkNGeiikDQEJEAVe" +
           "uKMUlYQ2Z/o9h5A6yy4+bzetmDP12PS7FbZNLD3K5Kuc7pPGvCf3bFbt+IbV" +
           "d8bWbEb1uHxxnlIrfjzketyyy3DenEAynzOyUZ0ibI0mq/2uxqK+2FGwbS2p" +
           "jyxL1IPhBsMIXcZSkiPH/Gi82CzNgUw2N/5kMjNHdNuSbK3GuzLZV/zIy1je" +
           "tinB1z21tuW1hOjX6VVj21o2a2aWorDExCRB8ZrRp8J+Qq57AyfwGjo7mpad" +
           "rNz03DI6TQcrp8V3FvRElzIKrUyT5nAjt4LezKmsSba+WfudoM5PO6iCbOaV" +
           "cUwHdMvsZyNepOjEJ7YVPM2ccrdNrkYNtDHQMCGI4rq4UFhMkXkUgX00nLuo" +
           "OBVCkh2MLbOPo5Rutjx6mOI06yztSU1J6LSnN0wj5ZZYqxewCBVlvGfW5j7F" +
           "crwmTvVSLxWiWS/m0Fq5Ph92EM1p1ucOG7gut95MmH7JVmYWxVmlQThsyIty" +
           "1IJXG6nTIybZrLMZdFyWZxnW8iVOmCvb+ZZxhVJ3quNyp9ePNKtSrcwrlIW3" +
           "xRnfnrZETiC1zsRq0riTjAit5w2xActvbSOcuIZPExaSGlMyRPVGKmwqi6HG" +
           "Uex0ZDRWlQ1rxiMqYwMsHa/4rNogQ7tV6Vv4DEdNjRdWU5ia6BWFmlbLkxnf" +
           "lzZtrtaepokpb0LaRZF+ByfHK73pWiXZrQhbbFUhyfJUYFwMpxoTjGzyvZmJ" +
           "JN1luZqElF1e8PWOIAt+wLZNZCxg2XwmRDXFHYt0S7cdroJE1YmqMl6YjBa1" +
           "9WRWiiWgU02LRSrwK8PJFIm7I5GnhzG39jch3+JWJl5nlf66Q62zJt6NWhW+" +
           "2/eqs4BjWwbXFlqBM1P5YL2BJ/QE7070KV5JB6zVr4TZvDVT26HZWVLzia9K" +
           "Otpwt6SDVi3L7G4E127NRsSW0gzKF119yTe7MLXZCPRmtZx5U7PDzGdLbjSq" +
           "pwSx5HlG1+aUtrGD2hQfUWm64EoktR2aE2Roeqg0JFq9DTUpb0OfoYZKKFhj" +
           "HcfLXRn1sc0wqs7JfqT4jIGN/doay8xNFQ4pYWZq3UFns6wvF6WJI8CUjKoE" +
           "4w0mi5LuMkhdqVIbfcNNy1jAWR1WaS2WFKunPVObEDWKtUV6iKJmy7Cydo1S" +
           "raSuB2jJ85tSKQmokQEcNMB7FXeBTlndoIca1t+UBjrqr4RULpUwB0XG1tjy" +
           "RU9RylQPYJV7M6tf67DzmBggfktZ9IO05S9sqb31g8gwuTHbCKK57S/r8jIM" +
           "qkOM4nyplyArfYXXMB4liKY/NptlTGXI0CxxHTYjysNqjxuh7QlHNoSya9VW" +
           "rlzvcB193aiXXSZDt80NybOTMmpLy8QiHbY+HNZXaAtBptZiVEemrp7CTQt3" +
           "dayscKbSRkAiWR2TMbVVM3kUCyRZ9XFEmgU+wgqD1F42M5x2p5Wq4+rlVbRk" +
           "hUjYtnSC1EYorpp9g1zBqwrcXOIxWQ4QPhMRgynTQrwFz94reu561nyc9tB5" +
           "XeJKozoqw+Y4KWNy4iskVSOiQXOq002KQgluSXLtTW/bVEpNAcNSpNRZTAmn" +
           "02vNIllzBbCcGFmz3UZaJQYh16g+i4bkcCCWp/1GL97Ol0h7sVaQkdZLuHrP" +
           "ptqt8somQRQX6GhqGWvGLZeEbGTCaIwMY9RtD8o9mtzWVyzhZ9WoFtIztqk2" +
           "Go1xaCy1ZVCpNEhmmeFsKR2RkldaE+1RME1Ut9JMSk1qtGH8SZsNt+SI89Ep" +
           "ISntBk5K27CDuM3hgFGVkjmeSJu0ZiYyQ8XsUuxWG7C08tMmM80EzKgkyyho" +
           "YhpDgKnQ4xZOv9NyHUTvYnjGqDCZDLWa39CyZTTargJySaXaxEvgtpcFsYj2" +
           "x+pkIJvlfpmqy9qybPTagksTW6WfzFUCWzYa6yosi92JW7U2gtBVBk3cB8tO" +
           "CzHcqTezyE1WDeYLZyEMK5uujyyMCUPNtj0X53hdUmpYnUvXBpUxaKM0ZVak" +
           "GZYHWnOQydM0ttd6y6pjVi8zMK7XgAnKlJd9PmuPhNrAXHZADloNG0mtmwU4" +
           "nNZb7HihRpi4mTutjdc1y0q9RoypQTIc17JWqd/Oqpsqvw3i8TIZML5WUzNv" +
           "BWNNNjGVZqURcCM7CLl5tMx0x2FEaWsyVBeRx003cetLBGbiuYARVbfea62m" +
           "iLPV1s2FtpFW8DKhKuhksVq7g21cXczGm9Cr1aOm0/Z51TU3nKwk7ratdJRJ" +
           "iMxGZb9X0yKEr7uiSfi1oAuWXiIM6MGy0mgGNWYad8U27SWlVj3zEmMpw6Jg" +
           "rNCN3KbZsGQFWplwpXmWyA1qRm+awpybppbMZnHDaAYoyEd0Z+r3Us4aMVw7" +
           "Ka+7eBoHBqv3KNGx2ozV6JY6AtX0sdUKliTanNThXhVRspWpmutZq2FW4oTc" +
           "NtrZhlCxKTJ0EM9rlHBuS9eiwWwjI0vEF8b1pTIqzdIlSIuobDYvs0p3sGTa" +
           "qmBP+77eJUf62gpImldms2SMLTm6Q1s4ZkrDCGOD7UJW7C49Q/vzdbuTYZNS" +
           "jFntMlISnSWFlTBqU85cNISbc8XU1rQVZ0TNKoWp7HbXvVpH2IqVZKK3W27I" +
           "1uYEqnowPJ7i5Qasjttzr8W7HCeC9WniY9504NkDvawxqlnfTOFApxKCELZ4" +
           "Y8xUSGaMq6O+kGD2UB6OhX6vmvRb8HKgqwotoTChZu1OPUAIfCurVQksBl4V" +
           "TlRk7q7b4TCS7Q7SCNYWFctEWcd4pk1K3QozrFBtmtddRezQQSOViEY2jmul" +
           "sASy1Xl9XadUjrEGQZmyqytfY9Iaw9Y2HZNcEEs0qW3cHh9WESZgLKnVS7IW" +
           "vF4aAsFrGEo7tFqFBxLNq/0sIxt9uNdTxGkNb626qE7CojH0t0I4SnrNPqsm" +
           "qyDlar1yz2qKy3FUU6NkMOabM1VG7RCed3yJrHfQNkYtyu4SZ41kNB620HXC" +
           "42C44ShZ1qzFoNUQmJghOukAVqdkfxLU6la3HTDUAqDWhpLLA5YaYQ/bnmrS" +
           "QYWkyzG5HcLlvBzoX6HRXkObRWOnjxsLOGK6lr8gw5ajSTGaIhGZSnBZavDj" +
           "hjzQ1KFhOeNhTHQQnxu4XZQbutPx3N2qfb2hM3F35q27nb7LN0xlyhPTMtxb" +
           "MiWn7vFpiefscgP1t5g7QxXGoEueOg6pdrZO7A1jta1QEubzenuYEnQXJ/0m" +
           "yhHibL1cOEwwIuEBHtmLynhU6s4Uq28m8KJjyH1vwellfTw0025juXC1ctiS" +
           "NiQSR+FW4hdoAwxj+/4K3nrdbSBTcERSHbBiR33MQGCYqAJw/Xk216rMajBR" +
           "ajZSGrl1k5Rl2RmtCK1FbFuKwW7MOWZFLW3qTIJ6F23hvMjhxLJTk6QkVBgH" +
           "L1FufdyoDfhey+/z7Jya244y6ncCfONFbaalNTYNoesFIA3vIiNRQmVUKkkm" +
           "YqiBi3jjRiQZilf2gYU3CO7Eg+XCSyx7UW210km772W9pGQT/Nwl7dmqjyyC" +
           "rtueK5G3ysh1f576PNPsGEGfwuqYCc/LXitu8fSWrveTutFLa6Si4fGC8L0k" +
           "GmkBMiS3IlZaB3141jWChc317W7ZqS2ktFoWJnV7ovZjK2hJRp1D2nNnth7X" +
           "Bt1WY8qtbb/RZT18o1clkppoaN+sC9N0uaYnfW5T5UAYXbX9OWNjXAWedjSu" +
           "NOyK1taudgW8Ybbntty3TRavj/lJMjSk3ryGyjRVmhvDEqXX3X7N0e2ZuWjK" +
           "QRnvuPPJRCI4a0j7RG+6DbrIlIRJuGX12g62pTtwt7JubakVI29oq96bdmtG" +
           "TKNOVEacMekkyZxshhltNrfbFQayLL1f12l/vlg2VXIIG/01L9PBpERr0dBq" +
           "4NnKtuZUSSJQq8NPGt5cxyYzBfGn/nKOaMLY62HjHieIa3o7rDAtddSEK52B" +
           "NCa34wrqzVcot5q0jRRRhJGDlPR60quXFHSYknXSdcdq2pynq0AmR0aoMTHc" +
           "8cdus5KRWOTMBJXUo4WZbuvLRK6AbKeskQ4yiEICI9IAPDDbRGNjqn2Em6Hq" +
           "vOQEmSwvkjoTWHWVrEulrVszHbJUxVYKlbamCU4ibNT0G5WeAK8mJbHWrqIY" +
           "hvJZXC932GonIvBgU2uGvlJr96f1CPVEoVrGkJrDNCdydzEttUcYcH94SAsR" +
           "S2LYyCwHdGnaQuwZDCekaXjiWk16TBesMdp8puOiMQFWG5l+p7ONo4aX1DXE" +
           "X5am08j1tghBezg/tzKbMeloY+Bcg0p6yJzEq4K9TsNJ3KuALGVcYuGgSWlB" +
           "c8RhlcVMsGzPpPsgmkTo0EfaiTnjzMqm5Tc4kQ1m6mQ66CM9HWcolGxli5Hq" +
           "zPWm6YxohFwRRmMyXLTXKC0jI7WpKs4WPKItAxzHfzTf5vjJN7fT9FCxqXbz" +
           "7adpY3lF703ssKRnD7h/uJl3WTx8A5TefMtQ7Lc+cvQa7ej3xFuGEzuxe0e7" +
           "ez/+N3zhVNAz3jblW1PvvtOb02Jb6vMfe/kVefzLlf3DnfB5DN13+EL7WJ5H" +
           "QDfP33n/bVi8NT7env36x/73k7Mf0z/8Jl5AveeUkKe7/GfDL/5O7wPSz+1D" +
           "F25u1t72PvvWRi/cukV7JVTiJHRnt2zUvvumeZ7NrfEc+H710DxfPfsl0Nlm" +
           "j6EH/NCLFSlW5LxY2XnaG7xx2LxB3TYnAfAiTdltWh+5ww+d6Q6KqxmuclDs" +
           "zx4c8xc+HJ63S3hy7KLAvamSq3lhXv+1Q5V87U2oZK+YCWeqYe+YoVcw/MzZ" +
           "DEeon8hRb2pS4fft8bCTSoqf+1PR+OM5+UgMPRgq8gy4JqGLrqbszjBMT0xj" +
           "PoYurj1DPtbNR+9WNzj4fv9QN9+/N7rZ3/nTWdJfinQvjM+sUW1PjIv+PnNn" +
           "Xb9UMLySk5+NoUeBurp5s8JhDpWW133iWEE/d7cKqoChn9m13f2+Bc7zq+ch" +
           "/kJO/kkMXdNCRXFPuMgptJ+/W7QElO/c79AO7qk75LefzckvFFy/cR7kf5mT" +
           "L8XQ4wXk88z85bsFXgaDZ4fAs7fIzK+eh/nf5uQrMXR1BYDe2cq/dbdgW2DU" +
           "XzkE+ytvpZW/eR7i38vJ12PosRzxeUb+xr0w8muHuF97i4z8B+dB/sOc/Edg" +
           "5FBbEZ7thWeDfe1eTOXXD8G+fs+N3DtG/MfnIf4fOflWDL3zCDFFEG+A/Nt3" +
           "i7wNZLy0a7v7vXvkF45z8c+egv/6efC/n5PvxPm5yDti/tO7xVwFWJ86xPzU" +
           "W+Taf3ke0r/KyZ/H0CMFUib08lN6ZwP+i7sF/D4AtH0IuH1vAJ/IX/cun4N1" +
           "70pOLsT50QyANSJsRQxPo9y7eLcoDwA6+RClfM/NWgTpvUfPg/p4Tq7G+dHN" +
           "HCrlGnFxMvg2uNfuFm4TwHzpEO5L9wbuiZj1C0XhqcTzAnjqLFA+c54a3p+T" +
           "dx15N3hEU0LwqNRSVC9UTiniqbtVRA2IfHiUb/8OR/nuRhG5jM8WoODzUFdy" +
           "8vyRn08VPz9netrwpbvFC55a9w8Xq/17");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("tFgdIzmE+sJ5UPNtmL36UaCeKo63vg0pdrdIfxgsI8/s2u5+34IZ3TsPKZWT" +
           "Vgy9rUCK+77ingZK3C3Q56F8n2MH9B49SpxekfbYN4jgXE5GMXQlCY0z16C9" +
           "8d1CbABos0OI7L2BeLFguJjfnkg0jhHfeAPEYk4E4L9+vpV2NuafeDOY0xh6" +
           "1xucAy/4H4uhD/zNdviiEHritv+p7P5bIf36K1cvv/MV7j8XB6dv/v/hgQF0" +
           "WU1s++QpxRPX9/mhohqFGh/YnVn0Cz2Yh/stZ4kEAj6gueR7xo4bFD16Fjfg" +
           "BPQkpw8ewE9zxtCl4vckH2h65Zgvhu7bXZxkWYPeAUt+ufGP9HjiVOLuUGe6" +
           "2z964qQLFtnTw+dZ8WaTk+ev803P4v9ERxuUye4fRTekL71Cj376e/Vf3p3/" +
           "lmwxy/JeLg+g+3dH0YtO803OZ+/Y21Ff95HP/eDBLz/w/qPd2Ad3Ah9PhxOy" +
           "vefsA9Ydx4+LI9HZv37nb/zIP33lj4pjmf8fyJW8iOg1AAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "a93yZl2E97F8jHxMzP5AvGLz4X8A9CqiJP0aAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "CiYAAA==");
}
