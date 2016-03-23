package org.sunflow.image;
public class Bitmap {
    private int[] pixels;
    private int width;
    private int height;
    private boolean isHDR;
    public Bitmap(java.lang.String filename, boolean isLinear) throws java.io.IOException {
        super(
          );
        if (filename.
              endsWith(
                ".hdr")) {
            isHDR =
              true;
            java.io.FileInputStream f =
              new java.io.FileInputStream(
              filename);
            boolean parseWidth =
              false;
            boolean parseHeight =
              false;
            width =
              (height =
                 0);
            int last =
              0;
            while (width ==
                     0 ||
                     height ==
                     0 ||
                     last !=
                     '\n') {
                int n =
                  f.
                  read(
                    );
                switch (n) {
                    case 'Y':
                        parseHeight =
                          last ==
                            '-';
                        parseWidth =
                          false;
                        break;
                    case 'X':
                        parseHeight =
                          false;
                        parseWidth =
                          last ==
                            '+';
                        break;
                    case ' ':
                        parseWidth &=
                          width ==
                            0;
                        parseHeight &=
                          height ==
                            0;
                        break;
                    case '0':
                    case '1':
                    case '2':
                    case '3':
                    case '4':
                    case '5':
                    case '6':
                    case '7':
                    case '8':
                    case '9':
                        if (parseHeight)
                            height =
                              10 *
                                height +
                                (n -
                                   '0');
                        else
                            if (parseWidth)
                                width =
                                  10 *
                                    width +
                                    (n -
                                       '0');
                        break;
                    default:
                        parseWidth =
                          (parseHeight =
                             false);
                        break;
                }
                last =
                  n;
            }
            pixels =
              (new int[width *
                         height]);
            if (width <
                  8 ||
                  width >
                  32767) {
                readFlatRGBE(
                  f,
                  0,
                  width *
                    height);
                return;
            }
            int rasterPos =
              0;
            int numScanlines =
              height;
            int[] scanlineBuffer =
              new int[4 *
                        width];
            while (numScanlines >
                     0) {
                int r =
                  f.
                  read(
                    );
                int g =
                  f.
                  read(
                    );
                int b =
                  f.
                  read(
                    );
                int e =
                  f.
                  read(
                    );
                if (r !=
                      2 ||
                      g !=
                      2 ||
                      (b &
                         128) !=
                      0) {
                    pixels[rasterPos] =
                      r <<
                        24 |
                        g <<
                        16 |
                        b <<
                        8 |
                        e;
                    readFlatRGBE(
                      f,
                      rasterPos +
                        1,
                      width *
                        numScanlines -
                        1);
                    return;
                }
                if ((b <<
                       8 |
                       e) !=
                      width) {
                    java.lang.System.
                      out.
                      println(
                        "Invalid scanline width");
                    return;
                }
                int p =
                  0;
                for (int i =
                       0;
                     i <
                       4;
                     i++) {
                    if (p %
                          width !=
                          0)
                        java.lang.System.
                          out.
                          println(
                            "Unaligned access to scanline data");
                    int end =
                      (i +
                         1) *
                      width;
                    while (p <
                             end) {
                        int b0 =
                          f.
                          read(
                            );
                        int b1 =
                          f.
                          read(
                            );
                        if (b0 >
                              128) {
                            int count =
                              b0 -
                              128;
                            if (count ==
                                  0 ||
                                  count >
                                  end -
                                  p) {
                                java.lang.System.
                                  out.
                                  println(
                                    "Bad scanline data - invalid RLE run");
                                return;
                            }
                            while (count-- >
                                     0) {
                                scanlineBuffer[p] =
                                  b1;
                                p++;
                            }
                        }
                        else {
                            int count =
                              b0;
                            if (count ==
                                  0 ||
                                  count >
                                  end -
                                  p) {
                                java.lang.System.
                                  out.
                                  println(
                                    "Bad scanline data - invalid count");
                                return;
                            }
                            scanlineBuffer[p] =
                              b1;
                            p++;
                            if (--count >
                                  0) {
                                for (int x =
                                       0;
                                     x <
                                       count;
                                     x++)
                                    scanlineBuffer[p +
                                                     x] =
                                      f.
                                        read(
                                          );
                                p +=
                                  count;
                            }
                        }
                    }
                }
                for (int i =
                       0;
                     i <
                       width;
                     i++) {
                    r =
                      scanlineBuffer[i];
                    g =
                      scanlineBuffer[i +
                                       width];
                    b =
                      scanlineBuffer[i +
                                       2 *
                                       width];
                    e =
                      scanlineBuffer[i +
                                       3 *
                                       width];
                    pixels[rasterPos] =
                      r <<
                        24 |
                        g <<
                        16 |
                        b <<
                        8 |
                        e;
                    rasterPos++;
                }
                numScanlines--;
            }
            for (int y =
                   0,
                   i =
                     0,
                   ir =
                     (height -
                        1) *
                     width;
                 y <
                   height /
                   2;
                 y++,
                   ir -=
                     width) {
                for (int x =
                       0,
                       i2 =
                         ir;
                     x <
                       width;
                     x++,
                       i++,
                       i2++) {
                    int t =
                      pixels[i];
                    pixels[i] =
                      pixels[i2];
                    pixels[i2] =
                      t;
                }
            }
        }
        else
            if (filename.
                  endsWith(
                    ".tga")) {
                isHDR =
                  false;
                java.io.FileInputStream f =
                  new java.io.FileInputStream(
                  filename);
                int pix_ptr =
                  0;
                int pix =
                  0;
                int r;
                int j;
                byte[] read =
                  new byte[4];
                int idsize =
                  f.
                  read(
                    ) &
                  255;
                f.
                  read(
                    );
                int datatype =
                  f.
                  read(
                    ) &
                  255;
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                f.
                  read(
                    );
                width =
                  f.
                    read(
                      ) &
                    255;
                width |=
                  (f.
                     read(
                       ) &
                     255) <<
                    8;
                height =
                  f.
                    read(
                      ) &
                    255;
                height |=
                  (f.
                     read(
                       ) &
                     255) <<
                    8;
                pixels =
                  (new int[width *
                             height]);
                int bpp =
                  (f.
                     read(
                       ) &
                     255) /
                  8;
                int imgdscr =
                  f.
                  read(
                    ) &
                  255;
                if (idsize !=
                      0)
                    f.
                      skip(
                        idsize);
                switch (datatype) {
                    case 10:
                        while (pix_ptr <
                                 width *
                                 height) {
                            r =
                              f.
                                read(
                                  ) &
                                255;
                            if ((r &
                                   128) ==
                                  128) {
                                r &=
                                  127;
                                f.
                                  read(
                                    read,
                                    0,
                                    bpp);
                                pix =
                                  (read[2] &
                                     255) <<
                                    16;
                                pix |=
                                  (read[1] &
                                     255) <<
                                    8;
                                pix |=
                                  read[0] &
                                    255;
                                pix =
                                  isLinear
                                    ? pix
                                    : org.sunflow.image.RGBSpace.
                                        SRGB.
                                    rgbToLinear(
                                      pix);
                                for (j =
                                       0;
                                     j <=
                                       r;
                                     j++,
                                       pix_ptr++)
                                    pixels[pix_ptr] =
                                      pix;
                            }
                            else {
                                r &=
                                  127;
                                for (j =
                                       0;
                                     j <=
                                       r;
                                     j++,
                                       pix_ptr++) {
                                    f.
                                      read(
                                        read,
                                        0,
                                        bpp);
                                    pix =
                                      (read[2] &
                                         255) <<
                                        16;
                                    pix |=
                                      (read[1] &
                                         255) <<
                                        8;
                                    pix |=
                                      read[0] &
                                        255;
                                    pixels[pix_ptr] =
                                      isLinear
                                        ? pix
                                        : org.sunflow.image.RGBSpace.
                                            SRGB.
                                        rgbToLinear(
                                          pix);
                                }
                            }
                        }
                        break;
                    case 2:
                        for (pix_ptr =
                               0;
                             pix_ptr <
                               width *
                               height;
                             pix_ptr++) {
                            f.
                              read(
                                read,
                                0,
                                bpp);
                            pix =
                              (read[2] &
                                 255) <<
                                16;
                            pix |=
                              (read[1] &
                                 255) <<
                                8;
                            pix |=
                              read[0] &
                                255;
                            pixels[pix_ptr] =
                              isLinear
                                ? pix
                                : org.sunflow.image.RGBSpace.
                                    SRGB.
                                rgbToLinear(
                                  pix);
                        }
                        break;
                    default:
                        org.sunflow.system.UI.
                          printWarning(
                            org.sunflow.system.UI.Module.
                              IMG,
                            "Unsupported TGA datatype: %s",
                            datatype);
                        break;
                }
                if ((imgdscr &
                       32) ==
                      32) {
                    pix_ptr =
                      0;
                    for (int y =
                           0;
                         y <
                           height /
                           2;
                         y++)
                        for (int x =
                               0;
                             x <
                               width;
                             x++) {
                            int t =
                              pixels[pix_ptr];
                            pixels[pix_ptr] =
                              pixels[(height -
                                        y -
                                        1) *
                                       width +
                                       x];
                            pixels[(height -
                                      y -
                                      1) *
                                     width +
                                     x] =
                              t;
                            pix_ptr++;
                        }
                }
                f.
                  close(
                    );
            }
            else {
                java.awt.image.BufferedImage bi =
                  javax.imageio.ImageIO.
                  read(
                    new java.io.File(
                      filename));
                width =
                  bi.
                    getWidth(
                      );
                height =
                  bi.
                    getHeight(
                      );
                isHDR =
                  false;
                pixels =
                  (new int[width *
                             height]);
                for (int y =
                       0,
                       index =
                         0;
                     y <
                       height;
                     y++) {
                    for (int x =
                           0;
                         x <
                           width;
                         x++,
                           index++) {
                        int rgb =
                          bi.
                          getRGB(
                            x,
                            height -
                              1 -
                              y);
                        pixels[index] =
                          isLinear
                            ? rgb
                            : org.sunflow.image.RGBSpace.
                                SRGB.
                            rgbToLinear(
                              rgb);
                    }
                }
            }
    }
    public static void save(java.awt.image.BufferedImage image, java.lang.String filename) {
        org.sunflow.image.Bitmap b =
          new org.sunflow.image.Bitmap(
          image.
            getWidth(
              ),
          image.
            getHeight(
              ),
          false);
        for (int y =
               0;
             y <
               b.
                 height;
             y++)
            for (int x =
                   0;
                 x <
                   b.
                     width;
                 x++)
                b.
                  pixels[(b.
                            height -
                            1 -
                            y) *
                           b.
                             width +
                           x] =
                  image.
                    getRGB(
                      x,
                      y);
        if (filename.
              endsWith(
                ".tga"))
            b.
              saveTGA(
                filename);
        else
            b.
              savePNG(
                filename);
    }
    private void readFlatRGBE(java.io.FileInputStream f, int rasterPos,
                              int numPixels) throws java.io.IOException {
        while (numPixels-- >
                 0) {
            int r =
              f.
              read(
                );
            int g =
              f.
              read(
                );
            int b =
              f.
              read(
                );
            int e =
              f.
              read(
                );
            pixels[rasterPos] =
              r <<
                24 |
                g <<
                16 |
                b <<
                8 |
                e;
            rasterPos++;
        }
    }
    public Bitmap(int w, int h, boolean isHDR) { super();
                                                 width = w;
                                                 height =
                                                   h;
                                                 this.isHDR =
                                                   isHDR;
                                                 pixels =
                                                   (new int[w *
                                                              h]);
    }
    public void setPixel(int x, int y, org.sunflow.image.Color c) {
        if (x >=
              0 &&
              x <
              width &&
              y >=
              0 &&
              y <
              height)
            pixels[y *
                     width +
                     x] =
              isHDR
                ? c.
                toRGBE(
                  )
                : c.
                copy1(
                  ).
                toNonLinear(
                  ).
                toRGB(
                  );
    }
    public org.sunflow.image.Color getPixel(int x, int y) {
        if (x >=
              0 &&
              x <
              width &&
              y >=
              0 &&
              y <
              height)
            return isHDR
              ? new org.sunflow.image.Color(
              ).
              setRGBE(
                pixels[y *
                         width +
                         x])
              : new org.sunflow.image.Color(
              pixels[y *
                       width +
                       x]);
        return org.sunflow.image.Color.
                 BLACK;
    }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public void save(java.lang.String filename) { if (filename.
                                                        endsWith(
                                                          ".hdr"))
                                                      saveHDR(
                                                        filename);
                                                  else
                                                      if (filename.
                                                            endsWith(
                                                              ".png"))
                                                          savePNG(
                                                            filename);
                                                      else
                                                          if (filename.
                                                                endsWith(
                                                                  ".tga"))
                                                              saveTGA(
                                                                filename);
                                                          else
                                                              saveHDR(
                                                                filename +
                                                                ".hdr");
    }
    private void savePNG(java.lang.String filename) { java.awt.image.BufferedImage bi =
                                                        new java.awt.image.BufferedImage(
                                                        width,
                                                        height,
                                                        java.awt.image.BufferedImage.
                                                          TYPE_INT_RGB);
                                                      for (int y =
                                                             0;
                                                           y <
                                                             height;
                                                           y++)
                                                          for (int x =
                                                                 0;
                                                               x <
                                                                 width;
                                                               x++)
                                                              bi.
                                                                setRGB(
                                                                  x,
                                                                  height -
                                                                    1 -
                                                                    y,
                                                                  isHDR
                                                                    ? getPixel(
                                                                        x,
                                                                        y).
                                                                    toRGB(
                                                                      )
                                                                    : pixels[y *
                                                                               width +
                                                                               x]);
                                                      try {
                                                          javax.imageio.ImageIO.
                                                            write(
                                                              bi,
                                                              "png",
                                                              new java.io.File(
                                                                filename));
                                                      }
                                                      catch (java.io.IOException e) {
                                                          e.
                                                            printStackTrace(
                                                              );
                                                      }
    }
    private void saveHDR(java.lang.String filename) {
        try {
            java.io.FileOutputStream f =
              new java.io.FileOutputStream(
              filename);
            f.
              write(
                "#?RGBE\n".
                  getBytes(
                    ));
            f.
              write(
                "FORMAT=32-bit_rle_rgbe\n\n".
                  getBytes(
                    ));
            f.
              write(
                ("-Y " +
                 height +
                 " +X " +
                 width +
                 "\n").
                  getBytes(
                    ));
            for (int y =
                   height -
                   1;
                 y >=
                   0;
                 y--) {
                for (int x =
                       0;
                     x <
                       width;
                     x++) {
                    int rgbe =
                      isHDR
                      ? pixels[y *
                                 width +
                                 x]
                      : new org.sunflow.image.Color(
                      pixels[y *
                               width +
                               x]).
                      toRGBE(
                        );
                    f.
                      write(
                        rgbe >>
                          24);
                    f.
                      write(
                        rgbe >>
                          16);
                    f.
                      write(
                        rgbe >>
                          8);
                    f.
                      write(
                        rgbe);
                }
            }
            f.
              close(
                );
        }
        catch (java.io.FileNotFoundException e) {
            e.
              printStackTrace(
                );
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    private void saveTGA(java.lang.String filename) {
        try {
            java.io.FileOutputStream f =
              new java.io.FileOutputStream(
              filename);
            byte[] tgaHeader =
              { 0,
            0,
            2,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0,
            0 };
            f.
              write(
                tgaHeader);
            f.
              write(
                width &
                  255);
            f.
              write(
                width >>
                  8 &
                  255);
            f.
              write(
                height &
                  255);
            f.
              write(
                height >>
                  8 &
                  255);
            f.
              write(
                32);
            f.
              write(
                0);
            for (int y =
                   0;
                 y <
                   height;
                 y++) {
                for (int x =
                       0;
                     x <
                       width;
                     x++) {
                    int pix =
                      isHDR
                      ? getPixel(
                          x,
                          y).
                      toRGB(
                        )
                      : pixels[y *
                                 width +
                                 x];
                    f.
                      write(
                        pix &
                          255);
                    f.
                      write(
                        pix >>
                          8 &
                          255);
                    f.
                      write(
                        pix >>
                          16 &
                          255);
                    f.
                      write(
                        255);
                }
            }
            f.
              close(
                );
        }
        catch (java.io.IOException e) {
            e.
              printStackTrace(
                );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "r8b+D5qhtKYgJwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "b1YdP3SZOk7hnijm1vNMfd/xw7KV/3TJ");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JPlGkfxeXLkn0mOu2Fa8oIXffwtaKE333QDQi0daePHt0cLhqUGdGfQ/vgTl" +
       "nxTJfwMozTMo/+AU5X9/CyhLLnocCAwfoYTfHpRn5f/OJe/+tEje2GObnWwF" +
       "nWL7X28V2xNATOQIG/K2Yzs4vOTdXcXDPwP0DLARp3tKp+D+/K0a6QtAzvYR" +
       "uPbbA+4M25QkffDAJQgfLJJ7j0j6vO0d3PdWCRnY20HvCFzvzYK7PSHfAu7J" +
       "S8A9VSSAna4V4LgxfgHfY28HvvERvvFfEr73XYKvcOcHzx7hO9pdPIPvubcD" +
       "n36ET/9Lwle/BF+jSH7kCJ+Ioxfw3XxT54ziytX9EdvivOATtxzA3x8aV7/4" +
       "6vV7Hn9V+r39uZPjg9330pV7jK3jnD1wcyZ/NQh1wy7x3rs/fhOU8r8EItJb" +
       "HGOxFVxcCwkP/tq+4AfiyjvOFCwQ73NnC6Fx5QooVGR7wbHjPbOruj9KlB6c" +
       "D0ZPqOrh76WtM/Hr8+dObZT/03B8wmK7/6+Gl9UvvToaf/iN1i/uz7WqjpLn" +
       "RSv30JVr+yO2ZaPFKY1n79jacVtXiRe/+8Av3/vCcUT8wF7g0yl2Rrb33P4Q" +
       "6cAN4vLYZ/6rj//zH/3Hr/5hua38/wEACyxlbDIAAA==");
}
