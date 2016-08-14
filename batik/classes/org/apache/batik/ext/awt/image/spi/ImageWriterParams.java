package org.apache.batik.ext.awt.image.spi;
public class ImageWriterParams {
    private java.lang.Integer resolution;
    private java.lang.Float jpegQuality;
    private java.lang.Boolean jpegForceBaseline;
    private java.lang.String compressionMethod;
    public ImageWriterParams() { super(); }
    public java.lang.Integer getResolution() { return this.resolution; }
    public java.lang.Float getJPEGQuality() { return this.jpegQuality; }
    public java.lang.Boolean getJPEGForceBaseline() { return this.jpegForceBaseline;
    }
    public java.lang.String getCompressionMethod() { return this.
                                                              compressionMethod;
    }
    public void setResolution(int dpi) { this.resolution = new java.lang.Integer(
                                                             dpi);
    }
    public void setJPEGQuality(float quality, boolean forceBaseline) {
        this.
          jpegQuality =
          new java.lang.Float(
            quality);
        this.
          jpegForceBaseline =
          forceBaseline
            ? java.lang.Boolean.
                TRUE
            : java.lang.Boolean.
                FALSE;
    }
    public void setCompressionMethod(java.lang.String method) {
        this.
          compressionMethod =
          method;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2pz/AnVT+nL4IAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MRCXXExU2LQy2fL6ouJhOzdvO9sZ1apnvEb7A7aaCYs6MVgkSHNS29VH+LSz" +
       "2IXx1h7FHVNHx4qCYRt7lInLBdeXGAHVOFtRd+vqVtCoqjcnkYhshi3d9yV1" +
       "OrTQjRyidJwstc5qKg1EmSPdIcml+CgY9OTRNhS5xGpMxRHKJtNdTagYIUvo" +
       "a2I9IkxhtWxgcH/d3wbytiI1cAbvkXMWCaq52VbyHurTzCKZbMikifImmiIh" +
       "PKtOZWztMr5ZMzmcoraznjiWun4ugl3cfOZN7DEijvzqjNtishWKYbrLp+1I" +
       "m9i0nJH0FqaayxgfeJMhz7c0n0ZWgypbZ3fVTq2nu1464WVYnDnTnd9Lqwii" +
       "rRZLtNZt0CPLNN2hO9tyaOykviBMYqBTMDXRellnm3S79A6ZqSGBqsMJsvT7" +
       "uCxoKWWG8tLzuwwIoUxSFCW/4bMeFTE07ofVkSi0BNYbU7w07DoZpo0Hcx5f" +
       "9GO7v2XWG0JYDKcuNlWGcd6Yj8JOJXVgxaemwx4hcJOpM6gIKRaKfBfpwxJC" +
       "i1t8K9jVNtPozbwWWzV6qy6eJd1e5vMgqhC0zTwZZKg5xdh23M+Xypq0wpwy" +
       "nIm6oSK1Hs7qjgjUYrxMw7nZ2MTVZjuOF4ZWbY6Rrsu5g77SzxueqLfncOr4" +
       "HF/lDTzoDQjZFbR8NsdsNFjzs9in7fl80qjJ/ZALCNr1ZmFIoh2NYjTJttbL" +
       "Qau5rNZCKhbCYArGtDswavr2uFDk0GRCKwDzqKxXsTsycswi1oNVW8RYNKa8" +
       "diefmC4XZp48FcXhpC6ghN1DBgOY3obUeisp+FqXGvzEnkw2vKv3ehOtzgq9" +
       "+dasDUKtgnMOu1xMWa/XWavJuOERMb9wJluCFNPeDBiur7IKrLT8jmwjDoOJ" +
       "PWy5llZddqolFDGfIIJaNSues1F0mMz8pd4PK2Qt5uqDXS9c8OLQtWF8yc3t" +
       "XhvrV/St4NqZNJLW1IpPnYnTHza6dG70el1sTJJS1Sc0oq4as6k5iFydnS74" +
       "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");
}
