package org.apache.batik.svggen;
public class CachedImageHandlerPNGEncoder extends org.apache.batik.svggen.DefaultCachedImageHandler {
    public static final java.lang.String CACHED_PNG_PREFIX = "pngImage";
    public static final java.lang.String CACHED_PNG_SUFFIX = ".png";
    protected java.lang.String refPrefix = "";
    public CachedImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          );
        refPrefix =
          urlRoot +
          "/";
        setImageCacher(
          new org.apache.batik.svggen.ImageCacher.External(
            imageDir,
            CACHED_PNG_PREFIX,
            CACHED_PNG_SUFFIX));
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.OutputStream os)
          throws java.io.IOException { org.apache.batik.ext.awt.image.spi.ImageWriter writer =
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
    public int getBufferedImageType() { return java.awt.image.BufferedImage.
                                                 TYPE_INT_ARGB;
    }
    public java.lang.String getRefPrefix() {
        return refPrefix;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwcxRUfnx3Hn/FHPgmJkzgmKCHcEQpU1GkgduzE9Gyf" +
       "7CQCp+Qytzd33mRvd9mdtS+haQEJJVAV0RASqCB/tEFAFBJUlUJFQaGoBQSt" +
       "xHdpBVRtpdJSVKKqtCpt6Xszu7cf57s0UttIOzeeefPx3vzm996bnPyIzLIt" +
       "0sV0Hud7TWbHB3SeopbNsv0ate2t0JZWjtbSP+/8YOTqGKmfIHMmqT2sUJsN" +
       "qkzL2hNkqarbnOoKs0cYy+KIlMVsZk1Rrhr6BJmv2kMFU1MVlQ8bWYYC26mV" +
       "JB2Uc0vNOJwNuRNwsjQJO0mInSQ2Rrt7k6RFMcy9vviigHh/oAclC/5aNift" +
       "yd10iiYcrmqJpGrz3qJFLjENbW9eM3icFXl8t3ala4LrkleWmaD78bZPPr17" +
       "sl2YYC7VdYML9ewxZhvaFMsmSZvfOqCxgn0T+SqpTZLmgDAnPUlv0QQsmoBF" +
       "PW19Kdh9K9OdQr8h1OHeTPWmghviZEV4EpNatOBOkxJ7hhkauKu7GAzaLi9p" +
       "K7UsU/HeSxKHj+5s/24taZsgbao+jttRYBMcFpkAg7JChln2xmyWZSdIhw6H" +
       "Pc4slWrqPvekO201r1PuwPF7ZsFGx2SWWNO3FZwj6GY5Cjeskno5ASj3r1k5" +
       "jeZB1wW+rlLDQWwHBZtU2JiVo4A7d0jdHlXPcrIsOqKkY8+XQACGzi4wPmmU" +
       "lqrTKTSQTgkRjer5xDhAT8+D6CwDAGhxsrjipGhrkyp7aJ6lEZERuZTsAqlG" +
       "YQgcwsn8qJiYCU5pceSUAufz0cj6u27Wt+gxUgN7zjJFw/03w6CuyKAxlmMW" +
       "g3sgB7asSR6hC545GCMEhOdHhKXMk185e+3arjMvSpkLZ5AZzexmCk8rxzNz" +
       "Xl3Sv/rqWtxGg2nYKh5+SHNxy1JuT2/RBIZZUJoRO+Ne55mxn9xwywn2YYw0" +
       "DZF6xdCcAuCoQzEKpqoxazPTmUU5yw6RRqZn+0X/EJkN9aSqM9k6msvZjA+R" +
       "Ok001RvibzBRDqZAEzVBXdVzhlc3KZ8U9aJJCJkNH2mBr5vIf+KXk3xi0iiw" +
       "BFWorupGImUZqL+dAMbJgG0nExlA/Z6EbTgWQDBhWPkEBRxMMq9jKp9neqIf" +
       "m7JDBcDAFqpnQanUyOYBXQF2suIIOPP/t1QRtZ47XVMDB7IkSgca3KQthgay" +
       "aeWw0zdw9lT6ZQk1vB6uvTi5AlaPy9XjYvW4XD1ebXVSUyMWnYe7kAiA89sD" +
       "TABU3LJ6/Mbrdh3srgXomdN1YHwU7Q65pH6fLjyOTyunO1v3rXhv3fMxUpck" +
       "nVThDtXQw2y08sBdyh73erdkwFn5PmN5wGegs7MMhWWBsir5DneWBmOKWdjO" +
       "ybzADJ5Hw7ubqOxPZtw/OXPf9K3bv3ZZjMTCbgKXnAUMh8NTSO4lEu+J0sNM" +
       "87Yd+OCT00f2Gz5RhPyO5y7LRqIO3VFYRM2TVtYsp0+kn9nfI8zeCETOKVw8" +
       "4Miu6BohHur1OB11aQCFc4ZVoBp2eTZu4pOWMe23CLx2iPo8gEUzXsyL4Uu4" +
       "N1X8Yu8CE8uFEt+Is4gWwmd8cdx88Oc/+/3nhLk999IWiAvGGe8NUBpO1inI" +
       "q8OH7VaLMZB7977UPfd+dGCHwCxIrJxpwR4s+4HK4AjBzLe/eNM77793/I2Y" +
       "j3MOPt3JQGhULCmJ7aSpipKw2ip/P0CJGnAFoqZnmw74VHMqzWgML9Y/2i5a" +
       "98Qf72qXONCgxYPR2nNP4Ldf0EdueXnnX7vENDUKumTfZr6Y5Pm5/swbLYvu" +
       "xX0Ub31t6f0v0AfBYwBL2+o+Jog3JmwQE5ovgghNjETvG5feF9uvEkd6pZC5" +
       "TJRXoN1clnBHXlaJksa3b95sUXNSVezLNw2NDhQVZuJWxaRXY3GRHbxT4Wsb" +
       "iMjSyt1vfNy6/eNnzwojhEO6IISGqdkrUYvFqiJMvzDKeVuoPQlyV5wZ+XK7" +
       "duZTmHECZlSA2e1RC8iyGAKcKz1r9i+ee37BrldrSWyQNGkGzQ5ScXdJI1wa" +
       "Zk8CcxfNa66VmJlugKIda0VSshoRViPFsgY8t2UzI2KgYHJxhvueWvi99Q8f" +
       "e0+A15RzXCjG16IzCZG1SAx8vjjx+ufffPibR6ZlaLG6MklGxi36+6iWue3X" +
       "fyszuaDHGcKeyPiJxMkHFvdv+FCM93kKR/cUyx0gcL0/9vIThb/Euut/HCOz" +
       "J0i74gbi26nm4O2fgODT9qJzCNZD/eFAUkZNvSUeXhLlyMCyUYb0HS/UURrr" +
       "rRFSXIRHuAG+lS5frIySYg3QTIOp54VrxqZhMfhiUa7B4lJ5kFiNAyXZIvDn" +
       "sBlVp1qEmhZWWYqTjv6N/VsGNqXB9adTYwODQ9eLWyx5Gcv1WIzIOa+pCNfN" +
       "YfW+AF+Pu2bPTOrVxU3JF9dXUw2LMSzGZ9Cp0vxhnca3DVbQ6Yb/XKc53jqr" +
       "3DVXlelERIXOrA0o3GhaBgdgsWxEldYq08Iwi+UgOc+pxZlUyFRRQXZdjMUl" +
       "pRXFv3oSCZ2DvsqnCYJcuLRSdiMys+O3HT6WHX1onSSKznDGMAAJ8WNv/fOV" +
       "+H2/emmGsLSRG+alGptiWoSaloaoaVgkfv49f3fOod/8oCffdz4hJLZ1nSNI" +
       "xL+XgRJrKrNddCsv3PaHxVs3TO46j2hwWcSc0SkfHT750uZVyqGYyHIlAZVl" +
       "x+FBvWHaabIYpPP61hD5rAxHZNfA1+sCoDeKZB9iEeyU4pxKQyM+PxItLBH+" +
       "ik7zuIq0Fu9zchhryvzDE5LphmrERx1uOhzCCkYLYks3V48o5noDo0HDrVhM" +
       "cdLMRGIjV6vq1FKWWoBwcsrNxRP7O9/f88AHj0mMRz1YRJgdPHznZ/G7Dku8" +
       "y9eNlWUPDMEx8oVDbLVdmvoz+FcD37/wQxNjA/6Cn+p30+zlpTwbXbtFVlTb" +
       "llhi8Hen9z/9yP4DqAYuA/l/3ZShZn0ymT4XH1YPSbBhwBTtVgkzbdiHTqfP" +
       "xUzf+cOt0tAIILyN4N9Hq/Tdj8UhgFqe8RAGRRYTSmORV8adjM0jp3x5apdy" +
       "sCf1WwmJC2YYIOXmP5L4xva3d78iCKIBGal0LQNsBMwVSJ7asbhD2vf2QP3r" +
       "nNSq7stiEP+QOoXXl0tvuqPth3d31g4CTQ6RBkdXb3LYUDZMFbNtJxPYkP/a" +
       "5ROHuxtEICc1a7w4UuDlnv8BXjqxrwu+QffQB88fL5WGVsHEqSp9j2PxKCct" +
       "gJexkDP2TXHiv2GKInBktScZDPoXlT0Jy2dM5dSxtoaFx7a9Ldxi6amxBWCX" +
       "czQtGJYG6vVmSZkWGaSa4ucpThZWyNAw2BQVocWTUv5pyAWj8hCMit+g3LOc" +
       "NPlyMJWsBEWeA5iDCFZ/ZHrkvq5SuriJ5aij8XKrFWvCgUzppOaf66QCsc/K" +
       "kI8Qb/bePXPkq31aOX3supGbz171kHyiUDS6bx/O0gy3S76WlFz/ioqzeXPV" +
       "b1n96ZzHGy/yKLpDbthH/IUBWA7A5TcREosj+bvdU0rj3zm+/tmfHqx/DbzR" +
       "DlJDwUvuKE90iqYDMdeOZDmLQJgkHhZ6V39r74a1uT/9UqSSLussqSyfVt54" +
       "+MbXDy063hUjzUNkFngfVhQZ2Ka9+hhTpqwJ0qraA0XYIsyiUi1EUXMQvRTf" +
       "E4RdXHO2llrxgYuT7nKvWv4sCGn3NLP6DEfPuiTX7LeE/jPBi54c04wM8FsC" +
       "LP1tyYvSK9emk8Om6Xnppu+b4kJ/J0rVolGMflNUsXjr31dIf/7PGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bzz71fzC/n8BZqDni3gmAAA=");
}
