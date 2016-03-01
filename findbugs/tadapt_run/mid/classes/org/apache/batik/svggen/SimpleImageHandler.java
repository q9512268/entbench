package org.apache.batik.svggen;
public class SimpleImageHandler implements org.apache.batik.svggen.GenericImageHandler, org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    static final java.lang.String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    protected org.apache.batik.svggen.ImageHandler imageHandler;
    public SimpleImageHandler(org.apache.batik.svggen.ImageHandler imageHandler) {
        super(
          );
        if (imageHandler ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          imageHandler =
          imageHandler;
    }
    public void setDOMTreeManager(org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_IMAGE_TAG);
        return imageElement;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.Image image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            null);
        int imageHeight =
          image.
          getHeight(
            null);
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.RenderedImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            );
        int imageHeight =
          image.
          getHeight(
            );
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.renderable.RenderableImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     double x,
                                                     double y,
                                                     double width,
                                                     double height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        double imageWidth =
          image.
          getWidth(
            );
        double imageHeight =
          image.
          getHeight(
            );
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    protected void setImageAttributes(org.w3c.dom.Element imageElement,
                                      double x,
                                      double y,
                                      double width,
                                      double height,
                                      org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            generatorContext.
              doubleString(
                x));
        imageElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            generatorContext.
              doubleString(
                y));
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            generatorContext.
              doubleString(
                width));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            generatorContext.
              doubleString(
                height));
        imageElement.
          setAttributeNS(
            null,
            SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
            SVG_NONE_VALUE);
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            "");
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            "0");
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            "0");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HHnDwF0YqeNR439sBo771B8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "02VWqCmsMj2NhEDNUqwGr9WVJ6ItUXIZ3ctcDhoGVCvs1j0ikPglTxPD9Wqp" +
       "LLEuImIQp5rMmk+6/U1TcRjfBvk/BfctmTOzTT03jW0dWy8hl8Jo8JVR1Zsi" +
       "ocd9foewDko5ap9s8HinreVapvbhiZZqEG42MGxS7ewypG6QakxQ1TocC3g2" +
       "1EHwWS/dVB0qcrBrTA3M7tEzGm03LLHXBOuMCdh1m1KjSjV4l+U0itKDxsJd" +
       "RgmlG8shsCGvyrijVB3gUOBR7QXo2h03G6nJN9glG3TNRgfxNw1iMyOiRGDo" +
       "FpY2/Qm2zlhtyk1Qc6eJO6pVxTUNq0Vd3LQ7vDd11rPaAiKVBOmao6Fjzxsj" +
       "bWEkJGyklM2sPMXqufq4aeBYK8YGVeA6ukRg3YHQDGpQjDZ2orpgx/bCzAw0" +
       "5b1Ju4N1F/KgyzG0Lo/0pZkozFgbUu5ymGOdaJsYSVPoIH0bQpEhuZ41MWw5" +
       "whq8yewUVYGgVGnYfXG2FXG+XdeImJ4hw2qr34Rtbw03NVmsR91GA9VQaSWi" +
       "27oxdtCum/B9HElnlrmMycEuRWSG9iI0XOh5ri14bT2ccymdj/qI1dt0OKXO" +
       "wUa82vhMd4kb3Iy1O0TYakPUYBeo6MiVcRzr+BYXQM2ewdbmtN7v5bCmxbuZ" +
       "u810jcIHkj+yho7gREMqMVqoFGizqSqPw9yKQBrrq/IOGwkWj9g8EevkyCR2" +
       "wSyQZ6wiStIUw9ZgWqSWPcHtvr9YxtBypwhEXWgnDN+cm3Gu9JzxBo7bQWs2" +
       "XSyVjWtVt7tuFyzKNLzcqqNJA8HDtoeitTYGPuDf/vbi0957ZbsrD5abRseH" +
       "tv+I7aL9q6eK4s3H22zl36XzB32njwNOtn3vOtrmq95uK73cKDTk0zvqR32e" +
       "uu3R2IyZ5m4kZUeUb7kdZScIvOD4/L/Ytnn8dgfD5ZbNx979wosK99O1i4d7" +
       "92ZUuS/y/O+01US1T+l1GXB65vbbU8PyXPxkT/m33v3njwrfpb/rFRyrveGc" +
       "nOdZ/tvhS59l3iL/5MXKXcc7zDed2J/t9OzZfeUrgRrFgSuc2V1+/OzRVmET" +
       "xOE0E+d3U08M6eat1NIk94Z47mjk3BnLbaeOAutEoKpDyQWWsT9lee8dTll+" +
       "vCh+FBh9qEZnu5bk6ilTN6LK3YlnKCc+8J6vt7N2erSy4V8e4/Rw0fgkeHqH" +
       "OPW+JTjd1oGAMxxutpeWXlwyKfl9+A5g/Zui+Kmo8mo5UKVILS7dqIf3Y8BQ" +
       "DxdDgRB7oHjOwel3JVYf+gaw+rai8S3gEQ+xEr85WF0+dMpDBfab2lIa7Q/q" +
       "itaP3soK7jLc8vzxE2eLj5RjvHQH/H6xKD4eVV6llxGrHOVo8MePB9+oAD9C" +
       "0wxXFQLJDYvT5RMcf+abgaN7iKP7LcHxsWNVykOQg4nqKmqgKieo3gK9UxD+" +
       "xztA+OtF8ctnISyaPnWC0K98MxB6/hCh578lCD19DqGgRKg4rD4Eq6je2Qgv" +
       "KV683l+w+dzZYg/i794BxM8XxWfuCOJnvwEQywO1AXg+fgjiR18piNNbgnip" +
       "JLh0bEGfu63yX7iD8l8qij+KKg8Vt5YKzYkoAp+JcbR3xZ84weCPv1EMcPB8" +
       "+hCDT39zMLhwQvDRkuDP76DqXxbFf48q1/bz3HH8KD+e7FOK/skrUTQD0N18" +
       "yai4MfH6m6447q/lyT//4tV7H3lR/E/lPZvjq3P3sZV7tdi2T59Zn6pf8gNV" +
       "M0o97tufYPvlz/+KKo/cZlErjp7LSin0/9zTfxXof54+qtxT/p6m+z9R5coJ" +
       "HWC1r5wm+VsQ+wFJUf07/xYn0fuj++zCqYzv0DBKmB/6ejAfdzl9DafIEssr" +
       "pkcZXby/ZHpD/sSL/dH3faX10/trQLIt7XYFl3vZyuX9jaTjrPCp23I74nWp" +
       "+/TXHvjkfW8+ymAf2At8YqSnZHvDre/clOZV3JLZ/dIj/+5tH3/xC+Ux7/8H" +
       "AvEoCvsrAAA=");
}
