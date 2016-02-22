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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JH6JV2P/B9CO91E0JwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jpXjmQanWsdQ++BDiBACpLesm+V+g5i12Z7qmcYsatsSMhEcaWL1eq6xGcId" +
       "TDNmA2oNQX61rdbSxE07htMfYEbZ6RoZ1GBcCmNlguMlrSKRfG9m+hMnMdOw" +
       "Z/eb9nwmesK0Pc6WjXFTry02kBYSwmYKUepqNNHUsg5t1BYylmpuqzrphkFP" +
       "Jar2yjOXUmOootWon0LTYJKYcIVtB7rbXuoCPu6SbJn3m5yNRlyEQrE7EYbD" +
       "bQgjdm8uQuMEW7fr627aY+OogzWzJjVq9taCO6r25i5GLCaDGryI26MtraI8" +
       "o1bEBS3JNX8ZCA3RDc2GsKhl9qocmNO03ky0fmKXFxpOjzY9fjBTVUtZUv4c" +
       "D7eksxUCMOtVTcyMlh3A1a6S1JPlaIiPAOVU4AErujrbJ/s2zLVjBRrTvXq5" +
       "wVt4XDcJ2YvTWQim3obsGNYaJtedJlmpUlGymoc+z0w5WCN5pyd2Bt26vAqz" +
       "gA1g3VmaS5Wb02kfxCItktLdvj7O6LAVd+2WtZbDpAuv8TCmauWss9TgWkg4" +
       "OsE2s5UhV8TWBKHAK6QdVJdLyNUa9WYPtbkmUx2nWyqJfDULTWbRhChqm4wz" +
       "Blkam3lG+3o6GWfyzNJW/c22P6xiRGh1dEoTlRR2hmXGW26WKszrY2uMNNNG" +
       "1mqDMSE10cKcLmOJoKeAcRfqLIPGoS1pmsYO2KTfWGnWhEEkeDZDlUoztDvE" +
       "sOYH42CytZYzOphiWx3CYWRadri5PaiyYuRqVoJQsuFNG8ky3GxT10iCpqC2" +
       "MwhGhotuJo+2M8ZyOkobTRYU1mh5sjgvAx4Qq22jxSOM4k49qB/Q9GpaN7l6" +
       "aDf1IMRcgtPatrm2R6w9HyBjfdjxaWsqo6u1GCAZiCcb860rTPA61Wi3Gm4/" +
       "CIIWNKQ5fQiveqqT1Wr2KN4gYAwslZr10qW5rhJTpwrXelIQ82Zi12pTbC6H" +
       "TjZZM/2VHZuVapte17lNaBKYs7BrzqLXGq+rm4yp40SCAPdAwfV2BRpoWJOy" +
       "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" +
       "WB3/7i2oo9hUhkCXtw7UcevNquMHL1LH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Mdwjxdx9ugn1bC8oWvlPF0ySr+fJH0ala6EWjfNNxjNa+Opb0EJhuu8GgF48" +
       "0MKLb48W9o8N6sSg/+kFKP8sT/4bQGmcQPlHxyj/+1tAWXDR40Bg6AAl9Pag" +
       "PCn/ty949+d58sYOm3i0HXSM7X+9VWxPADFrB9hqbzu2vf0L3l3OH/4FoGeA" +
       "rX+8r3QM7i/fqpG+AORsHoBrvj3gTrBNQdJ7D16A8Gae3H9A0qdtb+/6WyVk" +
       "YG973QNw3TcL7nxCvgvckxeAeypPADtdzcGN6d4ZfI+9HfjoA3z0XxO+912A" +
       "L3fne88e4DvYYTyB77m3A592gE/7a8JXvQBfPU9++ADftNc5g+/2mzp1FJWu" +
       "7A7c5qcHn7jrYP7uMLny+VdvXHv8Vf4Pd6dQDg9830+VrumxbZ88fnMif8UP" +
       "NN0q8N6/O4zjF/K/BCLSuxxjvh2cX3MJ9/7mruAHotI7ThTMEe9yJwt1otIl" +
       "UCjPdv1Dx3tiZ3V3sCjdOx2MHlHVw99NWyfi1+dPndwo/tfh8JRFvPtvhzvK" +
       "F14l6Q+/0fjF3SlXxZazLG/lGlW6ujtwWzSan9R49p6tHbZ1pf/idx78tftf" +
       "OIyIH9wJfDzFTsj2nvOPlOKOHxWHQLPfePyf/8gvvfrHxdby/wdAy1NkhDIA" +
       "AA==");
}
