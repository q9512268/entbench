package org.apache.batik.apps.rasterizer;
public class SVGConverterFileSource implements org.apache.batik.apps.rasterizer.SVGConverterSource {
    java.io.File file;
    java.lang.String ref;
    public SVGConverterFileSource(java.io.File file) { super();
                                                       this.file = file; }
    public SVGConverterFileSource(java.io.File file, java.lang.String ref) {
        super(
          );
        this.
          file =
          file;
        this.
          ref =
          ref;
    }
    public java.lang.String getName() { java.lang.String name = file.getName(
                                                                       );
                                        if (ref != null && !"".equals(ref)) {
                                            name +=
                                              '#' +
                                              ref;
                                        }
                                        return name; }
    public java.io.File getFile() { return file; }
    public java.lang.String toString() { return getName(); }
    public java.lang.String getURI() { try { java.lang.String uri = file.
                                               toURL(
                                                 ).
                                               toString(
                                                 );
                                             if (ref != null && !"".equals(
                                                                      ref)) {
                                                 uri +=
                                                   '#' +
                                                   ref;
                                             }
                                             return uri; }
                                       catch (java.net.MalformedURLException e) {
                                           throw new java.lang.Error(
                                             e.
                                               getMessage(
                                                 ));
                                       } }
    public boolean equals(java.lang.Object o) { if (o == null || !(o instanceof org.apache.batik.apps.rasterizer.SVGConverterFileSource)) {
                                                    return false;
                                                }
                                                return file.
                                                  equals(
                                                    ((org.apache.batik.apps.rasterizer.SVGConverterFileSource)
                                                       o).
                                                      file);
    }
    public int hashCode() { return file.hashCode(
                                          ); }
    public java.io.InputStream openStream() throws java.io.FileNotFoundException {
        return new java.io.FileInputStream(
          file);
    }
    public boolean isSameAs(java.lang.String srcStr) {
        if (file.
              toString(
                ).
              equals(
                srcStr)) {
            return true;
        }
        return false;
    }
    public boolean isReadable() { return file.
                                    canRead(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4VCnYaQqtwe45g0DQ9g3mafK/wAxKagT3yAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "btkU/+TJX/zg33/9d6oT2v8Hc8q+iWIsAAA=");
}
