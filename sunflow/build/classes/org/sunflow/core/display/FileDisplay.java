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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "d2/9Ny/+YXGe9/8BIGH4llYrAAA=");
}
