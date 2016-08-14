package org.apache.batik.gvt;
public class CanvasGraphicsNode extends org.apache.batik.gvt.CompositeGraphicsNode {
    protected java.awt.geom.AffineTransform positionTransform;
    protected java.awt.geom.AffineTransform viewingTransform;
    protected java.awt.Paint backgroundPaint;
    public CanvasGraphicsNode() { super(); }
    public void setBackgroundPaint(java.awt.Paint newBackgroundPaint) { this.
                                                                          backgroundPaint =
                                                                          newBackgroundPaint;
    }
    public java.awt.Paint getBackgroundPaint() { return backgroundPaint;
    }
    public void setPositionTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          positionTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getPositionTransform() {
        return positionTransform;
    }
    public void setViewingTransform(java.awt.geom.AffineTransform at) {
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          viewingTransform =
          at;
        if (positionTransform !=
              null) {
            transform =
              new java.awt.geom.AffineTransform(
                positionTransform);
            if (viewingTransform !=
                  null)
                transform.
                  concatenate(
                    viewingTransform);
        }
        else
            if (viewingTransform !=
                  null)
                transform =
                  new java.awt.geom.AffineTransform(
                    viewingTransform);
            else
                transform =
                  new java.awt.geom.AffineTransform(
                    );
        if (transform.
              getDeterminant(
                ) !=
              0) {
            try {
                inverseTransform =
                  transform.
                    createInverse(
                      );
            }
            catch (java.awt.geom.NoninvertibleTransformException e) {
                throw new java.lang.Error(
                  e.
                    getMessage(
                      ));
            }
        }
        else {
            inverseTransform =
              transform;
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public java.awt.geom.AffineTransform getViewingTransform() {
        return viewingTransform;
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (backgroundPaint !=
              null) {
            g2d.
              setPaint(
                backgroundPaint);
            g2d.
              fill(
                g2d.
                  getClip(
                    ));
        }
        super.
          primitivePaint(
            g2d);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e/ArV1l7b9vb9lLuvW2hxUJLHxdoG/xtsptkE8trk80m" +
       "+8hjk90kuyi3+0qyyb7fCVaBGQRkeKgFKgP9xzIiUyg6oMwgTtVRYGCYQRlF" +
       "R4FBR0Fghv4hMqLi2c3vfR+l05KZPTl7zne+873Pt+ecx38AXRP4UMF1zPXc" +
       "dMIdPQ13lmZlJ1y7erBDs5WB7Ae61jTlIOBB2wX17k+e/dFP3rs4dxI6JUE3" +
       "y7bthHJoOHYw1APHjHWNhc4etLZM3QpC6By7lGMZjkLDhFkjCB9goecdGhpC" +
       "59k9EmBAAgxIgHMSYPwACgx6vm5HVjMbIdth4EG/Bp1goVOumpEXQncdReLK" +
       "vmztohnkHAAM12XvY8BUPjj1oTv3ed/yfBHD7yvAD3/gDef+6CrorASdNexR" +
       "Ro4KiAjBJBJ0g6Vbiu4HuKbpmgTdaOu6NtJ9QzaNTU63BN0UGHNbDiNf3xdS" +
       "1hi5up/PeSC5G9SMNz9SQ8ffZ29m6Ka293bNzJTngNdbDnjdckhm7YDB0wYg" +
       "zJ/Jqr435OqVYWsh9NLjI/Z5PM8AADD0WksPF87+VFfbMmiAbtrqzpTtOTwK" +
       "fcOeA9BrnAjMEkK3XRZpJmtXVlfyXL8QQi86DjfYdgGo63NBZENC6IXHwXJM" +
       "QEu3HdPSIf38oPeqd7/R7tgnc5o1XTUz+q8Dg+44Nmioz3Rft1V9O/CG+9n3" +
       "y7d87u0nIQgAv/AY8BbmT371qde98o4nv7CFefElYPrKUlfDC+pjypmvvqR5" +
       "X/2qjIzrXCcwMuUf4Tw3/8FuzwOpCzzvln2MWefOXueTw78W3/Qx/XsnodMU" +
       "dEp1zMgCdnSj6liuYep+W7d1Xw51jYKu122tmfdT0LWgzhq2vm3tz2aBHlLQ" +
       "1WbedMrJ34GIZgBFJqJrQd2wZ85e3ZXDRV5PXQiCrgUPdAN47oS2v/w/hCR4" +
       "4Vg6LKuybdgOPPCdjP8A1u1QAbJdwAqw+hUcOJEPTBB2/DksAztY6Lsd8ziE" +
       "m7Idy0Hbl92FoQY9R9N3Mhtzf67Y04y3c8mJE0DsLznu9Cbwl45jarp/QX04" +
       "arSe+sSFL53cd4JdqYTQK8CEO9sJd/IJd8CEOxdPCJ04kc/zgmzirWqBYlbA" +
       "xUHwu+G+0a/QD7797quATbnJ1UCqGSh8+RjcPAgKVB76VGCZ0JOPJG8e/3rx" +
       "JHTyaDDNiAVNp7PhgywE7oe688ed6FJ4z77tOz964v0POQfudCQ673r5xSMz" +
       "L737uFh9R9U1EPcO0N9/p/zpC5976PxJ6Grg+iDchTIwTxBJ7jg+xxFvfWAv" +
       "8mW8XAMYnjm+JZtZ1164Oh0ufCc5aMn1fSav3whk/LzMfG8HT33XnvP/rPdm" +
       "NytfsLWPTGnHuMgj66tH7oe//pXvorm494Lw2UPL2kgPHzjk+Bmys7mL33hg" +
       "A7yv6wDunx8Z/M77fvC21+cGACDuudSE57OyCRweqBCI+a1f8P7hm9947Gsn" +
       "D4wmBCtfpJiGmu4zmbVDp6/AJJjt5Qf0gMBhAvfKrOa8YFuOZswMWTH1zEr/" +
       "5+zLSp/+/rvPbe3ABC17ZvTKp0dw0P4LDehNX3rDf92RozmhZgvXgcwOwLbR" +
       "8OYDzLjvy+uMjvTNf3P7735e/jCIqyCWBcZGz8MTlMsAypUG5/zfn5c7x/pK" +
       "WfHS4LDxH/WvQwnGBfW9X/vh88c//LOncmqPZiiHdd2V3Qe25pUVd6YA/a3H" +
       "Pb0jBwsAV36y98vnzCd/AjBKAKMKolbQ90GcSY9Yxi70Ndf+45//5S0PfvUq" +
       "6CQJnTYdWSPl3Mmg64F168EChKjUfe3rtspNrgPFuZxV6CLmt0bxovztFCDw" +
       "vsvHFzJLMA5c9EX/3TeVt3z7xxcJIY8sl1hXj42X4Mc/dFvzNd/Lxx+4eDb6" +
       "jvTi2AuSsYOxyMes/zx596m/OgldK0Hn1N1MbyybUeY4Eshugr30D2SDR/qP" +
       "ZirbZfmB/RD2kuPh5dC0x4PLQcwH9Qw6q58+Fk/OZFIugufeXVe793g8OQHl" +
       "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");
}
