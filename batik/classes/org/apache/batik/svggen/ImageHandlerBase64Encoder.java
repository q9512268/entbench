package org.apache.batik.svggen;
public class ImageHandlerBase64Encoder extends org.apache.batik.svggen.DefaultImageHandler {
    public ImageHandlerBase64Encoder() { super(); }
    public void handleHREF(java.awt.Image image, org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        int width =
          image.
          getWidth(
            null);
        int height =
          image.
          getHeight(
            null);
        if (width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            if (image instanceof java.awt.image.RenderedImage) {
                handleHREF(
                  (java.awt.image.RenderedImage)
                    image,
                  imageElement,
                  generatorContext);
            }
            else {
                java.awt.image.BufferedImage buf =
                  new java.awt.image.BufferedImage(
                  width,
                  height,
                  java.awt.image.BufferedImage.
                    TYPE_INT_ARGB);
                java.awt.Graphics2D g =
                  buf.
                  createGraphics(
                    );
                g.
                  drawImage(
                    image,
                    0,
                    0,
                    null);
                g.
                  dispose(
                    );
                handleHREF(
                  (java.awt.image.RenderedImage)
                    buf,
                  imageElement,
                  generatorContext);
            }
        }
    }
    public void handleHREF(java.awt.image.renderable.RenderableImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        if (image ==
              null) {
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_IMAGE_NULL);
        }
        java.awt.image.RenderedImage r =
          image.
          createDefaultRendering(
            );
        if (r ==
              null) {
            handleEmptyImage(
              imageElement);
        }
        else {
            handleHREF(
              r,
              imageElement,
              generatorContext);
        }
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX);
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
    public void handleHREF(java.awt.image.RenderedImage image,
                           org.w3c.dom.Element imageElement,
                           org.apache.batik.svggen.SVGGeneratorContext generatorContext)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        java.io.ByteArrayOutputStream os =
          new java.io.ByteArrayOutputStream(
          );
        org.apache.batik.util.Base64EncoderStream b64Encoder =
          new org.apache.batik.util.Base64EncoderStream(
          os);
        try {
            encodeImage(
              image,
              b64Encoder);
            b64Encoder.
              close(
                );
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED,
              e);
        }
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            DATA_PROTOCOL_PNG_PREFIX +
            os.
              toString(
                ));
    }
    public void encodeImage(java.awt.image.RenderedImage buf,
                            java.io.OutputStream os)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            org.apache.batik.ext.awt.image.spi.ImageWriter writer =
              org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
              getInstance(
                ).
              getWriterFor(
                "image/png");
            writer.
              writeImage(
                buf,
                os);
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_UNEXPECTED);
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ze2wUxxkfn9/vB++XeRkqA7mDAmmRaRJjbGxyxhYmRDGP" +
       "Y2537m7x3u6yO2ufnbjNQxH0IUSpk9C0oX+UKCRKIIoatVUepY2ah9KHkqI2" +
       "D0Eq9Y/SB2pQpfSPtE2/mdm93dvzneWq1NLO7c588833ffOb7zF+9joqt0zU" +
       "SjQapuMGscLdGh3EpkXkLhVb1j7oi0mPleK/H762Z1sIVQyjhhS2+iVskR6F" +
       "qLI1jJYpmkWxJhFrDyEymzFoEouYo5gqujaM5ilWX9pQFUmh/bpMGMF+bEZR" +
       "M6bUVOI2JX0OA4qWRUGSCJck0hkc7oiiOkk3xj3yhT7yLt8Io0x7a1kUNUWP" +
       "4lEcsamiRqKKRTsyJlpv6Op4UtVpmGRo+Ki61THB7ujWPBOser7xk09PpZq4" +
       "CeZgTdMpV8/aSyxdHSVyFDV6vd0qSVvH0JdRaRTV+ogpaou6i0Zg0Qgs6mrr" +
       "UYH09USz0106V4e6nCoMiQlE0cpcJgY2cdphM8hlBg5V1NGdTwZtV2S1FVrm" +
       "qfjI+sjUY4ebXihFjcOoUdGGmDgSCEFhkWEwKEnHiWl1yjKRh1GzBps9REwF" +
       "q8qEs9MtlpLUMLVh+12zsE7bICZf07MV7CPoZtoS1c2segkOKOerPKHiJOg6" +
       "39NVaNjD+kHBGgUEMxMYcOdMKRtRNJmi5cEZWR3b7gQCmFqZJjSlZ5cq0zB0" +
       "oBYBERVrycgQQE9LAmm5DgA0KVpckCmztYGlEZwkMYbIAN2gGAKqam4INoWi" +
       "eUEyzgl2aXFgl3z7c33P9pP3ar1aCJWAzDKRVCZ/LUxqDUzaSxLEJHAOxMS6" +
       "ddFH8fxXToQQAuJ5AWJB88P7btyxofXSm4JmyTQ0A/GjRKIx6Vy84Z2lXe3b" +
       "SpkYVYZuKWzzczTnp2zQGenIGOBh5mc5ssGwO3hp7+v33P8M+UsI1fShCklX" +
       "7TTgqFnS04aiEnMX0YiJKZH7UDXR5C4+3ocq4T2qaET0DiQSFqF9qEzlXRU6" +
       "/wYTJYAFM1ENvCtaQnffDUxT/D1jIIQq4UF18ESQ+OO/FMmRlJ4mESxhTdH0" +
       "yKCpM/2tCHicONg2FYkD6kcilm6bAMGIbiYjGHCQIu7AaDJJtEhfGna/F2sy" +
       "qLMDvOatW7o1CVyTGWZoM/5P62SYvnPGSkpgK5YGHYEKZ6hXV4E2Jk3ZO7pv" +
       "XIi9LUDGDoZjKYo2wdJhsXSYLx0WS4cLLo1KSviKc5kIYuNh20bAAYAHrmsf" +
       "OrT7yIlVpYA4Y6wMbM5IV+VEoi7PS7iuPSZdbKmfWHl102shVBZFLViiNlZZ" +
       "YOk0k+CypBHnVNfFQRQvVKzwhQoW40xdIjJ4qkIhw+FSpY8Sk/VTNNfHwQ1k" +
       "7MhGCoeRaeVHl86MPbD/KxtDKJQbHdiS5eDY2PRB5tOzvrst6BWm49t4/Non" +
       "Fx+d1D3/kBNu3CiZN5PpsCqIiaB5YtK6FfjF2CuTbdzs1eC/KYbzBq6xNbhG" +
       "jvvpcF0506UKFE7oZhqrbMi1cQ1NmfqY18PB2szf5wIsatl5bINns3NA+S8b" +
       "nW+wdoEAN8NZQAseKr40ZDzx3q/+tJmb240qjb50YIjQDp8nY8xauM9q9mC7" +
       "zyQE6K6cGfzWI9ePH+CYBYrV0y3Yxtou8GCwhWDmh9889v5HV89dDnk4pxDK" +
       "7ThkRJmskqwf1RRRElZb68kDnlAFL8FQ03aXBvhUEgqOq4QdrH82rtn04l9P" +
       "NgkcqNDjwmjDzAy8/kU70P1vH/5HK2dTIrFI7NnMIxPufY7HudM08TiTI/PA" +
       "u8u+/QZ+AgIFOGdLmSDc3yJuA8Q3bSvXfyNvtwTGvsCaNZYf/Lnny5cxxaRT" +
       "lz+u3//xqze4tLkpl3+v+7HRIeDFmrUZYL8g6Jx6sZUCui2X9hxsUi99ChyH" +
       "gaMEztcaMMGrZXKQ4VCXV37w09fmH3mnFIV6UI2qY7kH80OGqgHdxEqBf80Y" +
       "t98hNnesCpomrirKUz6vgxl4+fRb1502KDf2xI8W/GD7U2evcpQZgscSP8PP" +
       "sWZ9Fm/8ryIY9fx4y+FgomWFEhOeVJ17cOqsPPDkJpE+tOQG+27IZZ/77b9+" +
       "ET7z+7emiSvVVDduUckoUX1rVrAlc2JBP8/ZPH90peH0H37cltwxmzDA+lpn" +
       "cPTsezkosa6wWw+K8saDf16877bUkVl49OUBcwZZPt3/7Fu71kqnQzxBFc48" +
       "L7HNndThNywsahLIxDWmJuup57BfnetVu+DZ7gCgY3qvOg12sr6qo8DUwKku" +
       "5Ttayr8XUtTAoYzHqEgc3O45LL0Y2yyFZT0dZgUUcSofGFtfKPUY2r/LyRF1" +
       "06lUuNz7AiKUOAmGw29jMX4mNlKKZH1+Z99Ad0YiBttJzvQgawYoqknxXKd3" +
       "b3cPoLS9SBVpKmmIKaNOHh6ZbPlo5LvXnhOHJJi0B4jJiamvfRY+OSUOjKhs" +
       "VucVF/45orrhkjaJvfoM/krg+Td72B6xDpHdtnQ5KfaKbI7N3IaJVhYTiy/R" +
       "88eLky+dnzwechz1LorKRnVFlFNfZM2gcDkd/6W7Yx2dBu+/Mx+vhxzQHZw9" +
       "Xg8WmFocr+1ZvCoMr2FIbSAKsGAJhZb7yqHMJtzNmnu4MOb0IGSfhzjBKGvS" +
       "OYBiPZJnSe0mWLKBjW2DZ8Qxx0gRS/J2HWtucXOXasPUKQQgIgfSl/oiPAub" +
       "4m6+3ENFMoGHWXMfRU3CTDzmZe3tM9bkzYTduKNYZvawyxSYWhx2SwOwE1iD" +
       "UngapJ2aCWlTrPl6MaR942YZ73Z4zjgWODN74xWaGtA4xAUJsc9vuhYUZaei" +
       "hwdsath0iJoEp/mS35vJXt9nzeMU1RJeyU6Htu/cBIMtYmPr4TnvaH1+9gYr" +
       "NLV4RGzJom2nApHXcmPehSLn8gXWPA1z47aiyjvsRCKLz0Igzifitnzmf2HL" +
       "DEWLCl5FsBx6Yd4NqLi1ky6cbaxacPau3/FUMnuzVgdJYcJWVV9O5c+vKgyT" +
       "JBRuiDpRUhj852WKFhRIL6DuEy9chZcE/U/AsQXpKSrnv366n8Hp9eiAlXjx" +
       "k/ycolIgYa+vGzPmTjtJAtsq9ZssU5JfOPANmjfTBvkqhdU5CRG/nHaTXFtc" +
       "T8eki2d377n3xq1PiqJcUvHEBONSG0WV4n4gmyivLMjN5VXR2/5pw/PVa9x8" +
       "pFkI7J2UJT7MdgLmDQaGxYGK1WrLFq7vn9v+6i9PVLwLqdcBVIIhNT3guxoW" +
       "96BQ9tpQoRyIejWK758bvJTuaH98/LYNib99yGsyJO63lhamj0mXnzr0m9ML" +
       "z0HJXduHyiHVIplhVKNYO8e1vUQaNYdRvWJ1Z0BE4KJgtQ9V2ZpyzCZ9chQ1" +
       "MNxidm3N7eKYsz7by650KFqVn0LmX4RB/ToG50e3NZmxqYeixuvJuTV3zkKN" +
       "bRiBCV5Pdivn5usek3Z+tfHlUy2lPXD2ctTxs6+07Hi2jvFfpPMOkfGyRuYR" +
       "Fg5BLNpvGG6yW/NrQxyG9wQN66eoZJ3TG/D/H3J2H/BX1lz5Dyf6T7IjGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zNnXRuUmAAA=");
}
