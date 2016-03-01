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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "fefqT8e/V8Sz+6Lc+OXhq/t3hxzd+ZdbGUZmyJWl8vDw94SOvTij5eFrjN+G" +
       "EMo9P5WZZwBkbd7PH0185G8I/MqPinpQpWjWwhsFOUk3Zg/Uf4ZVIEO97Bp3" +
       "13K8cGlKQ+QsL3w5lvWCl53f4J1S0/fJHryixQOaA89scyvP9uKVD7GXtYxl" +
       "IWsX0WaJBQ9Fmi7BmQl78KEsz6QEleq0nk6mHVJHzDilagfDUB73c1vXsOHl" +
       "tGnjK3wxZ2A2u9WqNx/rPZtaXVwt2qzLlD8XN0FlmzXc/+UkHCDIsKVAha1A" +
       "K2wq4hG/e4LiLzQ9Y3kom/i9ecXPxU1tDeK3qlB2rYLSghafWbywSlVlLCge" +
       "NZ6YoBo0N8w1BZmbQ41YXjVycRNebEMkGRBG7fa5CNSotNXg5yGPFjiPFilb" +
       "msVpadgngDyltjPn2biGKFTPznUaYie5IzsPjMY6XlrKUa3afcJYAwfoV37/" +
       "398ED/3pTJZStYSo2v0yHsSyY80iWHJeBpZyo9jAtPzCeMGlfXXlmWUlnak+" +
       "R9G4ODfoehd4a+ffZ2x4eGDTBOrFOR5Dead8uf3YmbULxX1+dt7lOJhxTnYz" +
       "NbnRD8AGDvbKBhcGNqRdW2MF1xLTtUu8YWoHjycq0pVQLtY8NcPTecZ20GaY" +
       "oMn9mHSlkZJ2rrdjeORuO9GVqGnHStadTItfZaHDMlP8ZRPXPBdrHu325Bn7" +
       "Om2eJWgKaL6uc81aE2Np7+O26s/ds+rM6Z+FZ4Up/4qJq56LNY96B/OMHaLN" +
       "Nwiaaqruwmc6tsk2wL57NkA1HaI5ptnUonniBsjFmkfJ7+YZO0Kbw9wALV5k" +
       "p2OSbYDRezZAmWWAsKlFeOIGyMXqUdKXPv43OiGaXit3J6MG6dSlBJznBs1L" +
       "rxO141t/WTSy2rrQysbCKR812s/9qO39Pga3xRTP0yDnwPJmvd9xWK3katyB" +
       "jw+eT+hDxacd9Bsq0BbzDmtu+hJL02hOy1N9e1QIbau+suXFD17hKnhLbQ8x" +
       "3n1gz53g3gM81/Gb0PkZl5FOHn4bytWhzWsplv7yrMI4Wt8/se3HP9i2y28G" +
       "3FaCCiTzktrtp1qv0bmkgaWH/7X9uXc7/KgwjIqTirQ1icMxd7YpMpJRhxfs" +
       "q1M795gyU4sT5FsMxmXdx/PsjTHavAwZwXBmBEb6umkB+vUmQYWDqhSzN8rR" +
       "T2ejrIany4z2rolvlFysHo39TA4/+33CoZZHRTjnQH3tdRv9eTJ1N96iKC9r" +
       "s3MzVc7m8cNF2pyG/GRk5Kef20Y/8+kYnVL1mpbrnbjRc7FmRycGsGzWq3n0" +
       "/yttLgNGGzkw2mGFKxO3QgqK+oxrVnrJUJfxFxD/20I8PlpRPH30sT+wq770" +
       "XwvlAIfxpCw7z8CO9wDIHefKlvMTsca+rhPUcPeLYEANaJkG1zjfPwiqz88H" +
       "Qcu+nVz/JKguFxesAa2T+iMwejZqoITWSXkLzj9eSliffTvpbsM53KYjKMBf" +
       "nCSfwOxAQl/vaFkOV/yCIuVzn37SETDtbhHgODDNdyUX9seghb9J/tcgZMbR" +
       "deufuvnQS/x+VJSFkRE6SxmgLr+qTZ8q5uWczZor0Lbo9pRXSxZYyaCKC2xv" +
       "q5mOsF8JG0SjcTjDc3loNKbvEC8eWXHq7O7ABUhjvcgnEFTTm3mVk9KScOTp" +
       "jWTLL3DmYveaTaVXN5279Z6vmt2YmRmpPh9Hn7j/1KXOuKZ9249KwhBqSgyn" +
       "2D3T6mGlC4uDuitdBaJqUkn/hziFbhqBHpKZZUyDTk730vt12BeZCTnzP4dS" +
       "WR3C+io6u5n+XOewpKY5R5llf8LhmVceBX2Rdk0zK5FAL7O8plFo8FUzgP4f" +
       "ueJFmf0fAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9iv7C2cu7F2X3cu5YS87l8MCAPIFdZG/fsmfFKsr9Ax4njoxtacu+5MrUJn5" +
       "qbLJc2V6q0h+9NR8r4WxswGRwIn9/gD8roDn/xRP0VlRsF+3H0dPgodnz6KH" +
       "EKxN1+Mi+FyfTc7b0xOdKkRwTIFY0trL/WZZXS+SD+1Ha91Vif70RYhPnzyn" +
       "+TtBpO8CsciipdywFHp4GZrWZA1C63R3yu2NA7c40Pb0Eq/M6+T1vSdTcjo1" +
       "d+JV+GF4fazgFQ9A9NFXE7OIwe4g334QuKbqX+JZfJ08Fx762ROen70Lzz/9" +
       "Q/FcBJhAIRKgDexhLwB4vnngeb8HuMTyR16T5XKI7ArQ2Qfqx53javG+uDNT" +
       "9xXZHwNrU1JutUCLheOr7imX71y6+q1TbZbA1gtwe2vpdopq7RJf2A/NF/Bv" +
       "jx5AMgHY5vzsv//Mb//cu78FnNAQemBTOAjge85JYrQudn5/8cufferhl7/9" +
       "s+WyCiQ6/tzg5oeKXoN7oSuSZZGsTmE9WcDiy3iVUZOULVdC0yiQ3dv3jmPH" +
       "AwHD5mRbA7/0+LdWv/j7v7Lfslx2tJeIzU+9/Jd+cPzpl4/ObRTffdte7Xyb" +
       "/WaxZPotJxKOoefuNUrZAv9PX33p7/+Nlz655+rxi9ueAdjV/8q//N+/ffz5" +
       "b//WHeLn+93gNoX74Sc2vUGSzYRCTn+spJj1rZhl3oJrbfIBvEWbMLWdI1vJ" +
       "Hu0k2+JroUMSczJfLfG6NhhJ3BzW6q31Dt8YNdfoNivcTpyECD+gwwkaaJMR" +
       "HLGuGrDUFCecqVe3O0vOctFhUKNUa+Km4pCvW/YqGqqyi21avrKZNXSk5g7a" +
       "q1UnzRf5Qhgv1EZnMWqMSS3qD+2gqY4GxBAVB7uYGCzrA3/BbWfGlhnIsoCy" +
       "mIFpw0qn1YU7abPTjU1dHSPLWrAL+lZKrVFLSlyGNVlyOdVEa+vQKFWveawe" +
       "ZDuDW6rbsWNNeElqVzFhiKJ6VZ5SbjXqECw6m9OcNZVQcRKsNtMhi9v6lkZb" +
       "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" +
       "Wqc/53stCz59BvCx06Pd5gnA5psP8K/do+6LRfKFFHoUAByOB8TJeXZROj4g" +
       "fOUNICyn8EfB88EThB988xF+5R51XyuSX06ht50gvHAKXtTNDzi/9AZwPl4U" +
       "Fgf2yAlO5M3H+ffuUfcPiuTre5zo5ZPz0s0dcP7tN4Dz4VOc1AlO6s3BeeXk" +
       "y4HifXPODecpdJ/jp2WbX78H/m8Uya8BU03Om+qdurt/EzjGQRj/6I0KAwPP" +
       "9EQY0zdHGEclwdGduH9gUVws3anmmra/wCl7/N17iOrbRfIvgNEntxn9Pz3I" +
       "5ZtvVC4N8Hz4RC4fflOVpFTnkuAP7gHzj4rkPwCLSO5iEefA/sfXAzYDkcRt" +
       "n8gU9/1P3Pb53v6TM/0rr9x48J2viP+q/Erk7LOwhxjowcXadc9fz57LXwUc" +
       "L5wSykP7y9qw/PuvKfT8a3/EA8wGpCXv/2Xf7nsp9PS92wHtKv/Pt/qfKfTE" +
       "3VqBMUB6nvpPgLjvRA0oQXqe8gcpdPMyJRi//D9Hd+Uoha4f6FLo6j5znuQB" +
       "0DsgKbJXwztcEu7vzrMrF8Ows7l//LXm/lzk9u4L8Vb5UedpbLTef9b5ov7V" +
       "V4ajj323/Uv7T2t0V83zopcHGeja/iufs/jqubv2dtrXVfJ933/0aw+95zQW" +
       "fHTP8MF6zvH2zJ2/Yxl4YVp+eZL/3Xf+rQ/+9Vd+r7wb/L/KsIrVbSsAAA==");
}
