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
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "s2fd+x4AAA==");
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
           "x9vcghS7W6Q/Ch4jz+7a7n7fghndOQ8p");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("kxMigt5WIMV9X3NPAyXvFugLUJ7n2AG9R1uJ00+kPfEOEXyck14EXY4D88xn" +
           "0F7/biE2ALTRIUTx3kC8WDBczG9PLDSOEb94B8RyTiTgv36eSjsb80+9Gcxp" +
           "BL3rDue4C/7HI+gDf7MMXxhAT97yH5Td/yaUX3/1ygPvfHX8n4uDzzf+2/Ag" +
           "Bz2wjG375CnDE9f3+YG2NAs1Prg7c+gXelgd5lvOEgkEfEBzyffMHTcoeuws" +
           "bsAJ6ElOH2zAT3NG0KXi9yQfaHr5mC+C7ttdnGTZgN4BS36Z+Ed6PHGqcHco" +
           "M93lj5486YLF6umR86x4o8nJ89N50rP4r9BRgjLe/VvoReXLr7K9n/1+/Zd3" +
           "57cVW86yvJcHOOj+3VHyotM8yfncbXs76us++vkfPvSVB99/lI19aCfw8XQ4" +
           "Idt7zj4gTTl+VBxpzv71O3/jx/7Zq39UHKv8f7tRL8bENQAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kK5bFab/+9zzus6P72XWTP8P7VezrRAaAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XHnmJQAA");
}
