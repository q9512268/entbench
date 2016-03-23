package org.sunflow.core.display;
public class FileDisplay implements org.sunflow.core.Display {
    private org.sunflow.image.Bitmap bitmap;
    private java.lang.String filename;
    public FileDisplay(boolean saveImage) { super();
                                            bitmap = null;
                                            filename = saveImage ? "output.png"
                                                         : null; }
    public FileDisplay(java.lang.String filename) { super();
                                                    bitmap = null;
                                                    this.filename = filename ==
                                                                      null
                                                                      ? "output.png"
                                                                      : filename;
    }
    public void imageBegin(int w, int h, int bucketSize) {
        if (bitmap ==
              null ||
              bitmap.
              getWidth(
                ) !=
              w ||
              bitmap.
              getHeight(
                ) !=
              h)
            bitmap =
              new org.sunflow.image.Bitmap(
                w,
                h,
                filename ==
                  null ||
                  filename.
                  endsWith(
                    ".hdr"));
    }
    public void imagePrepare(int x, int y, int w, int h, int id) {
        
    }
    public void imageUpdate(int x, int y, int w, int h, org.sunflow.image.Color[] data) {
        for (int j =
               0,
               index =
                 0;
             j <
               h;
             j++)
            for (int i =
                   0;
                 i <
                   w;
                 i++,
                   index++)
                bitmap.
                  setPixel(
                    x +
                      i,
                    bitmap.
                      getHeight(
                        ) -
                      1 -
                      (y +
                         j),
                    data[index]);
    }
    public void imageFill(int x, int y, int w, int h,
                          org.sunflow.image.Color c) {
        org.sunflow.image.Color cg =
          c;
        for (int j =
               0;
             j <
               h;
             j++)
            for (int i =
                   0;
                 i <
                   w;
                 i++)
                bitmap.
                  setPixel(
                    x +
                      i,
                    bitmap.
                      getHeight(
                        ) -
                      1 -
                      (y +
                         j),
                    cg);
    }
    public void imageEnd() { if (filename != null)
                                 bitmap.
                                   save(
                                     filename); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "pHB+gD4rAAA=");
}
