package org.apache.batik.ext.awt.image.codec.util;
public final class FileCacheSeekableStream extends org.apache.batik.ext.awt.image.codec.util.SeekableStream {
    private java.io.InputStream stream;
    private java.io.File cacheFile;
    private java.io.RandomAccessFile cache;
    private int bufLen = 1024;
    private byte[] buf = new byte[bufLen];
    private long length = 0;
    private long pointer = 0;
    private boolean foundEOF = false;
    public FileCacheSeekableStream(java.io.InputStream stream) throws java.io.IOException {
        super(
          );
        this.
          stream =
          stream;
        this.
          cacheFile =
          java.io.File.
            createTempFile(
              "jai-FCSS-",
              ".tmp");
        cacheFile.
          deleteOnExit(
            );
        this.
          cache =
          new java.io.RandomAccessFile(
            cacheFile,
            "rw");
    }
    private long readUntil(long pos) throws java.io.IOException {
        if (pos <
              length) {
            return pos;
        }
        if (foundEOF) {
            return length;
        }
        long len =
          pos -
          length;
        cache.
          seek(
            length);
        while (len >
                 0) {
            int nbytes =
              stream.
              read(
                buf,
                0,
                (int)
                  java.lang.Math.
                  min(
                    len,
                    bufLen));
            if (nbytes ==
                  -1) {
                foundEOF =
                  true;
                return length;
            }
            cache.
              setLength(
                cache.
                  length(
                    ) +
                  nbytes);
            cache.
              write(
                buf,
                0,
                nbytes);
            len -=
              nbytes;
            length +=
              nbytes;
        }
        return pos;
    }
    public boolean canSeekBackwards() { return true; }
    public long getFilePointer() { return pointer; }
    public void seek(long pos) throws java.io.IOException { if (pos <
                                                                  0) {
                                                                throw new java.io.IOException(
                                                                  org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                                    getString(
                                                                      "FileCacheSeekableStream0"));
                                                            }
                                                            pointer =
                                                              pos;
    }
    public int read() throws java.io.IOException {
        long next =
          pointer +
          1;
        long pos =
          readUntil(
            next);
        if (pos >=
              next) {
            cache.
              seek(
                pointer++);
            return cache.
              read(
                );
        }
        else {
            return -1;
        }
    }
    public int read(byte[] b, int off, int len)
          throws java.io.IOException { if (b ==
                                             null) {
                                           throw new java.lang.NullPointerException(
                                             );
                                       }
                                       if (off <
                                             0 ||
                                             len <
                                             0 ||
                                             off +
                                             len >
                                             b.
                                               length) {
                                           throw new java.lang.IndexOutOfBoundsException(
                                             );
                                       }
                                       if (len ==
                                             0) {
                                           return 0;
                                       }
                                       long pos =
                                         readUntil(
                                           pointer +
                                             len);
                                       len =
                                         (int)
                                           java.lang.Math.
                                           min(
                                             len,
                                             pos -
                                               pointer);
                                       if (len >
                                             0) {
                                           cache.
                                             seek(
                                               pointer);
                                           cache.
                                             readFully(
                                               b,
                                               off,
                                               len);
                                           pointer +=
                                             len;
                                           return len;
                                       }
                                       else {
                                           return -1;
                                       } }
    public void close() throws java.io.IOException {
        super.
          close(
            );
        cache.
          close(
            );
        cacheFile.
          delete(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zi1vGAhGoa34Y+y/zIfZKtsmAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "SruqhwZNtT/gQnOFA3abY35TW2McHFh2t5sQ005bXUoCjpE7hbHMaledJhWh" +
       "3jA9TUkmyHaopQ4VE5PO2JlSvUk+lQlZEVvBnPNmhgRPs56MIJzhomSqo5G/" +
       "YhabDj5cJ7Jr4bV8wi8QQl/z/pxPUTyuDsMWy88bfjPIkDVr8qSv0lSeMHYm" +
       "0JOKvlvW146ahTO6k0ebih81OlWkb8f8qjlqNeusGFpuf0VSuTJkcBxe4zVU" +
       "pMhw2MaalSjpi5HiZ3kdJ7aaxvZcrK6YKZqb2YQdOwtPWSbT6TSYyNGWng80" +
       "zhp5bWukLyoj2qzu+ssFGQ0lXDLoQYxpxMLN1rPahOI0ezaedUCFBBrTk1wz" +
       "PK4XEzC5NToNrx7B22lvPHBTvRLzGaK6NFOVYCOhq43mCsWrSAVG5kme1N01" +
       "NpvOm1SWd+U13O4qY7HTaSzgncGkbFDt6c3KNDGydiVoD5BuNJEazYXSIjuT" +
       "FomsUKYZdxBpyyXVvNHn6iKlLxAwdNQX7VpU9XxSk6vT9nxteWN4lvtKtVUR" +
       "R67f9fEFHWynSDhR+JqKtDv6hsqr+jhHFhVnFGH0rk0IHXOMSgky6Uk6PCGE" +
       "3BlqYktWw+6uZ61pfDlCTTdvSfaSNxcMquu7bhserKhZnwpXHZLSN0SMN3ew" +
       "YeVeq0vWUq/lshu8CqKlWidzpp9PhnZzsGWWDgpG0Z6KuQPUCKLeGDUqPE/N" +
       "oyZT23mdjrXomRYiLqdDVTT5UazMJ7XpalKjIlVTbA9hUxWztbQxn9WEIRtE" +
       "8wbeVtGxaS5q2GREEkMwQuSkLy3x2gadrypOw4uZZRuMYH27ogzXG1Vy1uM4" +
       "q8OjrN2q6m6G0UN6R/pJx5pLjQTfouOKNMoZsz5pJ7hZr0fjVEJs4BfmNKUr" +
       "aNJD2Ep3QVJddS1vorhWX4uEu6qpm55N1QnJ2PksKjugcbqDRjLdUYvuZMIZ" +
       "LSNurLdiv0V0ENeUl7W5k6/NvuvJg+VIwwartGpN2tgmGKdG2GkYbgduhoNs" +
       "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" +
       "CEYJ5Qlw8Acw+LOrmcf233Ip8+bbIMq1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("s1Lgd88XaJYCv1cU/w7ADhRBXjiRXm7o+6njlv/6u625nVwjP2Pmo8XN4hvt" +
       "KwdmvnKnZv7gTc08uST/h7d49l+L4u0IuiYJTrGTqydIZioE+29hbx7b+I3v" +
       "wcZSrPiw++qBja++9zZ++xbP/mdRfDOCHlKVqPhEPT2x3H5s4R9/Dxbef2jh" +
       "6wcWvv7eWPgOZ/3zd3PWvyiKP42gu0LQmTf98pG4unxs9Z99D1ZfhQ4c+MsH" +
       "Vn/5Pe/XC/e/i8EXii/pFy4Du4roLG6rR8ZduPJeGPcHB8b9wXtj3KVjqo9L" +
       "uGVRmvLYu9n6fUXxyM1tffR7dd/HwKsu7nX35/e2I597N+OKj5QXntp/Zyy/" +
       "3F+Ajq17+k6syyLosXO2pxZ77R5/xw77/a5w6StvXL3nsTcW/2G/f+Bw5/a9" +
       "NHTPNrask1ucTlxf9gJlq5fm37vf8OSV5nw4gl647d20oEuLU2HJhcpeH46g" +
       "67ejXzRYcT6pW4+gp26tC7TK80mtVgQ9fp5WBF0C5UnpbgS972bSQBKUJyVf" +
       "AqPLWUnw/vJ8Uu5jEXTfsVwEXd5fnBRBQe1ApLjseYcf+7q3v2n5tDNkF06n" +
       "Mkek+Mi7eduJ7Oe5U9sIyv/xOPzkH+//y+Nl6atvUOMf+U77Z/dbaCVLyPOi" +
       "lnto6Mp+N29ZabFt4EPn1nZY1+XBC9996Bfvff4wn3poD/g4QE9ge/rm+1UJ" +
       "24vKHab5P3vsn3705974/fIb5f8F/QcxJXwzAAA=");
}
