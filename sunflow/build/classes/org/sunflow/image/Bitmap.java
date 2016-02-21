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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MpkU69olAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "uFCo7rsBoBcPuPDi28OF/WOFOjHpf3IB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("yj/Nk/8GUFonUP7hMcr//hZQFrbocUAwfIASfntQnqT/2xeU/VmevLHDJh8d" +
       "5Rxj+19vFdsTgEz0ABv6tmPb27+g7HL+8c+BeQbYyOMzoWNwf/FWlfQFQGf9" +
       "AFz97QF3wtoURnrvwQsQ3syT+w+M9Gnd27v+Vg0y0Le99gG49psFd75Bvgvc" +
       "kxeAeypPgHW6moPjhsQZfI+9HfiGB/iG3yd877sAX+7O9549wHdwOngC33Nv" +
       "Bz7jAJ/xfcKHXICvmic/dIBPJFpn8N1+U7eIYujK7gJtfhvwibsu3+8ujGtf" +
       "ePXGtcdfHf/+7lbJ4aXu+xnompk4zsnrNCfyV4LQMO0C7/27yzVBQf9LICK9" +
       "yzHmR7n5M6dw76/vKn4wht5xomKOeJc7WakVQ5dApTzbDg4d74lT0d1FoWzv" +
       "dDB6ZKoe/m7cOhG/Pn/q1kXx/wyHNySS3X803NG++Co9/MgbtZ/f3VrVHHW7" +
       "zXu5xkBXdxdoi07zWxbP3rO3w76ukC9+58Ffvv+Fw4j4wR3BxyJ2grb3nH9F" +
       "tOcGcXGpc/trj/+zH/7FV/+oOBb+/2HUoG1oMgAA");
}
