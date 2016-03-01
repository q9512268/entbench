package org.apache.batik.ext.awt.image.spi;
public class ImageWriterRegistry {
    private static volatile org.apache.batik.ext.awt.image.spi.ImageWriterRegistry
      instance;
    private final java.util.Map imageWriterMap = new java.util.HashMap(
      );
    private ImageWriterRegistry() { super();
                                    setup(); }
    public static org.apache.batik.ext.awt.image.spi.ImageWriterRegistry getInstance() {
        if (instance ==
              null) {
            synchronized (org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.class)  {
                if (instance ==
                      null) {
                    instance =
                      new org.apache.batik.ext.awt.image.spi.ImageWriterRegistry(
                        );
                }
            }
        }
        return instance;
    }
    private void setup() { java.util.Iterator iter =
                             org.apache.batik.util.Service.
                             providers(
                               org.apache.batik.ext.awt.image.spi.ImageWriter.class);
                           while (iter.hasNext(
                                         )) {
                               org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                                 (org.apache.batik.ext.awt.image.spi.ImageWriter)
                                   iter.
                                   next(
                                     );
                               register(
                                 writer);
                           } }
    public void register(org.apache.batik.ext.awt.image.spi.ImageWriter writer) {
        imageWriterMap.
          put(
            writer.
              getMIMEType(
                ),
            writer);
    }
    public org.apache.batik.ext.awt.image.spi.ImageWriter getWriterFor(java.lang.String mime) {
        return (org.apache.batik.ext.awt.image.spi.ImageWriter)
                 imageWriterMap.
                 get(
                   mime);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "LLR99zPLaxoDh2u0GfwPRrZUIr0dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
