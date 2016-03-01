package org.apache.batik.ext.awt.image.codec.jpeg;
public class JPEGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.awt.image.BufferedImage bi;
                                       if (image instanceof java.awt.image.BufferedImage) {
                                           bi =
                                             (java.awt.image.BufferedImage)
                                               image;
                                       }
                                       else {
                                           bi =
                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                               makeLinearBufferedImage(
                                                 image.
                                                   getWidth(
                                                     ),
                                                 image.
                                                   getHeight(
                                                     ),
                                                 false);
                                       }
                                       com.sun.image.codec.jpeg.JPEGImageEncoder encoder =
                                         com.sun.image.codec.jpeg.JPEGCodec.
                                         createJPEGEncoder(
                                           out);
                                       if (params !=
                                             null) {
                                           com.sun.image.codec.jpeg.JPEGEncodeParam param =
                                             encoder.
                                             getDefaultJPEGEncodeParam(
                                               bi);
                                           if (params.
                                                 getJPEGQuality(
                                                   ) !=
                                                 null) {
                                               param.
                                                 setQuality(
                                                   params.
                                                     getJPEGQuality(
                                                       ).
                                                     floatValue(
                                                       ),
                                                   params.
                                                     getJPEGForceBaseline(
                                                       ).
                                                     booleanValue(
                                                       ));
                                           }
                                           encoder.
                                             encode(
                                               bi,
                                               param);
                                       }
                                       else {
                                           encoder.
                                             encode(
                                               bi);
                                       } }
    public java.lang.String getMIMEType() {
        return "image/jpeg";
    }
    public JPEGImageWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OU8P+cne01+mXqW8bw85e3QKc9UN10mmKyfPXi6EIE5CVzxxAnPv0YLcktof" +
       "h8+jBwvy6LVPd6/pPGcy59m6zKnjw72MYO9wCV+RnYrsloyHEAtgGpYt2yHR" +
       "9tDf9PbZJPaTWIhDIDvZ6PGp0c+cdJA7Dxk7LLFSgJ8aPePbpIUXIxeWqWfs" +
       "JuOPOe8oRm5YeKa682r/hc4Ojh8RZg32SXs+DJ/KgT3LPxl7nt1Fa5IWy0Pd" +
       "Sy8uOLbul03xq9c2avrzLRnBr6fFL5+wXtryiztLvePHsNQdaeO98BkcWGrw" +
       "k7HU8YPrDz1P30fS4n0xcosO4l6nRxxGCLVT7/0vRr1VjFw8dZuVHsfffdXF" +
       "+/ayWPnMUxdvevlTw7/JLnSOLnRvZpCbtMS2j5+eHquf90OgmZn8N2/PUv3s" +
       "67di5JEf+dINOnz6lWnwm1v+346Ryz8Kf4ycy76P8/5OjNz3/LyQyzyKvQOu" +
       "T8bI3dfjipGzsDxO/TREh2tRQ0pYHqd8JkYunaaE82ffx+k+B/16Rxcj57eV" +
       "4ySfh6NDkrT6B/41TpS3x+OrM8d2jAMvz7znjhfyniOW4zdZqQmyv3Qc7gjJ" +
       "9k8djyvPPEX33/Jc5RPbmzTFljcZvN3EIDduL/WOdpUHrzva4Vjn24/84LbP" +
       "3vzw4Q5421bgXcQdk+3+a19VEY4fZ5dLmz96+e+/7nef+kZ2wP1/QezYOmsj" +
       "AAA=");
}
