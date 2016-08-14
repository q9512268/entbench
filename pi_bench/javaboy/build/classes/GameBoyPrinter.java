class GameBoyPrinter extends GameLink {
    final int BUFFER_SIZE = 32768;
    final int IMAGE_WIDTH = 160;
    final int IMAGE_HEIGHT = 320;
    final int[] palette = { -1, -8355712, -12566464, -16777216 };
    GameBoyPrinter.GameBoyPrinterWindow window;
    Dmgcpu cpu;
    short[] buffer = new short[BUFFER_SIZE];
    int bufferFillPos;
    int bufferEmptyPos;
    int tileX;
    int tileY;
    int dataSize;
    java.awt.image.MemoryImageSource source;
    java.awt.Image image;
    int[] imageData = new int[IMAGE_WIDTH * IMAGE_HEIGHT];
    class GameBoyPrinterWindow extends java.awt.Frame {
        java.awt.Image i;
        int scale = 2;
        GameBoyPrinterWindow(java.lang.String title) { super(title);
                                                       setSize(IMAGE_WIDTH *
                                                                 2,
                                                               IMAGE_HEIGHT *
                                                                 2);
                                                       setResizable(false);
        }
        public void setImage(java.awt.Image i) { this.i = i; }
        public void update(java.awt.Graphics g) { paint(g); }
        public void paint(java.awt.Graphics g) { g.setColor(new java.awt.Color(
                                                              255,
                                                              0,
                                                              255));
                                                 g.drawImage(i, 0, 0, IMAGE_WIDTH *
                                                               2,
                                                             IMAGE_HEIGHT *
                                                               2,
                                                             null);
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1457212322000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39gG/wJGMKHAXNQ8VFfCUlbakqDjY1NzvbJ" +
                                                                  "pq56FI65vTnfwt7usjtnn526CUgRTqUgQgnQivAXEQkiIaoatWmbiCpqkyhp" +
                                                                  "pST0I61CqrZSaVPUoKppVdqm783u3t7u3RkhpZZ2vDvz3pt5X7/35i7dIFWm" +
                                                                  "QdqYyjv4pM7Mjh6VR6lhsmS3Qk1zN8zFpdMV9G/7rg9uCZLqGGlIU3NAoibr" +
                                                                  "lZmSNGNkuayanKoSMwcZSyJH1GAmM8YplzU1RhbKZn9GV2RJ5gNakiHBKDUi" +
                                                                  "pJlybsiJLGf9tgBOlkfgJGFxkvB2/3JnhMyTNH3SJV9cQN5dsIKUGXcvk5Om" +
                                                                  "yAE6TsNZLivhiGzyzpxBNuiaMjmmaLyD5XjHAeVe2wS7IvcWmaD9ucYPbx1P" +
                                                                  "NwkTzKeqqnGhnjnMTE0ZZ8kIaXRnexSWMQ+Rr5GKCJlbQMxJKOJsGoZNw7Cp" +
                                                                  "o61LBaevZ2o2060JdbgjqVqX8ECcrPIK0alBM7aYqDgzSKjhtu6CGbRdmdfW" +
                                                                  "0rJIxcc3hE+e3tf07QrSGCONsjqCx5HgEBw2iYFBWSbBDHN7MsmSMdKsgrNH" +
                                                                  "mCFTRZ6yPd1iymMq5Vlwv2MWnMzqzBB7urYCP4JuRlbimpFXLyUCyv6qSil0" +
                                                                  "DHRtdXW1NOzFeVCwToaDGSkKcWezVB6U1SQnK/wceR1D9wMBsM7JMJ7W8ltV" +
                                                                  "qhQmSIsVIgpVx8IjEHrqGJBWaRCABidLygpFW+tUOkjHWBwj0kcXtZaAqlYY" +
                                                                  "Alk4WegnE5LAS0t8Xirwz43BrcceUPvUIAnAmZNMUvD8c4Gpzcc0zFLMYJAH" +
                                                                  "FuO89ZFTtPXFmSAhQLzQR2zRfPerN+/b2HblVYtmaQmaocQBJvG4dD7R8Oay" +
                                                                  "7nVbKvAYNbpmyuh8j+Yiy6L2SmdOB4RpzUvExQ5n8crwT7780EX2fpDU9ZNq" +
                                                                  "SVOyGYijZknL6LLCjJ1MZQblLNlPapma7Bbr/WQOvEdklVmzQ6mUyXg/qVTE" +
                                                                  "VLUmvsFEKRCBJqqDd1lNac67TnlavOd0QkgAHlINzw5i/Yn/nPSF01qGhalE" +
                                                                  "VVnVwlFDQ/3NMCBOAmybDuty3HrBsElok2HTkMI7IZS6tMmoIaKzA5f0j1FW" +
                                                                  "Ds89fyIQAJMu8ye0ArnQpylJZsSlk9munpvPxl+3ggUD3NaYk9VeuSHv55cg" +
                                                                  "RbQJEgiIPRbgppbLwOAHIXUBO+etG9m7a/9MewXEij5RiTYE0nZPDel289sB" +
                                                                  "5bh0uaV+atW1TS8HSWWEtFCJZ6mCJWG7MQZgIx2083FeAqqLC/IrC0Aeq5Oh" +
                                                                  "SSwJGFMO7G0pNdo4M3CekwUFEpwShMkWLl8ASp6fXDkzcXj0wU8FSdCL67hl" +
                                                                  "FUASskcRjfOoG/Lncym5jUevf3j51LTmZranUDj1rYgTdWj3R4HfPHFp/Ur6" +
                                                                  "fPzF6ZAwey0gL6eQKQBqbf49PMDR6YAw6lIDCqc0I0MVXHJsXMfThjbhzojw" +
                                                                  "bBbvCyAsgphJrfD02akl/uNqq47jIiucMc58WgiQ//yI/sSvfvanzcLcTj1o" +
                                                                  "LCjkI4x3FmAQCmsRaNPshu1ugzGge/dM9BuP3zi6R8QsUKwutWEIx27AHnAh" +
                                                                  "mPnhVw+9896181eD+TgnOa9uwVl0g03WuscA6FIg5TFYQl9UISzllEwTCsN8" +
                                                                  "+nfjmk3P/+VYk+V+BWac6Nl4ewHu/F1d5KHX9/2jTYgJSFg6XVO5ZBYez3cl" +
                                                                  "bzcMOonnyB1+a/k3X6FPALIDmpryFLMA0k5xPNRi6KQEJ1bJDqtKCifeI5bD" +
                                                                  "YtyMlrDthd+fxWGNWZgM3nwr6H3i0vGrH9SPfvDSTaGGt3kq9P0A1TutcMNh" +
                                                                  "bQ7EL/KDVR8100B3z5XBrzQpV26BxBhIlKBjMIcMgMmcJ1Js6qo5v/7Ry637" +
                                                                  "36wgwV5Sp2g02UtF0pFaiHZmpgFhc/oX7rO8PlEDQ5NQlRQpXzSBll9R2qc9" +
                                                                  "GZ0LL0x9b9F3tl44d01EnW7JWCr4gwj6HpQVLbib6Bff/szPLzx2asIq4uvK" +
                                                                  "o5uPb/G/hpTEkd/9s8jkAtdKNBg+/lj40tkl3dveF/wuwCB3KFdcqACkXd67" +
                                                                  "L2b+Hmyv/nGQzImRJslueUepksW0jUGbZzp9MLTFnnVvy2b1J515AF3mB7eC" +
                                                                  "bf3Q5hZIeEdqfK8vhWZ18PTYGd/jR7MAES+7BMsncNhQjBfluDkJyE6ONYgY" +
                                                                  "oRO8oz8DzaOFkjhuweF+Kyi2lo3BHd5dcanX3rW3zJlHZj1zOW4Ot0eJKsxb" +
                                                                  "/rHEjmQTJpRqOQPIPG73oXdH90szoegfrPC8qwSDRbfwqfCjo7888IbA/Rps" +
                                                                  "BnY7Liko9dA0FBSdJuvQH8FfAJ7/4oOHxQmrn2vptpvKlfmuEtNr1jzxKRCe" +
                                                                  "bnnv4Nnrz1gK+JPCR8xmTn79o45jJy1Ut64mq4tuB4U81vXEUgeHPXi6VbPt" +
                                                                  "Ijh6/3h5+gdPTR+1TtXibbR74B75zC/+80bHmd++VqIXrJDt6+XmAqCHcuz1" +
                                                                  "jaXQjkcaf3i8paIX2oh+UpNV5UNZ1p/0Js8cM5socJZ75XETylYNHQMhvx58" +
                                                                  "4Avv3bOEd65UmIoOPuDv4AtLsYuhBG26vNwlS9jz/JGT55JDT24K2uUrwUm1" +
                                                                  "ffd15VSgGA8WD4g7pQts7zac+P0LobGuO2l2ca7tNu0sfq8AR68vH7b+o7xy" +
                                                                  "5M9Ldm9L77+DvnWFz0R+kU8PXHpt51rpRFBcoC3ELbp4e5k6vaFSZzCeNVRv" +
                                                                  "cKzOO7UWnbUCnkHbqYOle0cRD2Jcj8MnrRgGl+nZhCJLvoatZhaBvg7Gzgb8" +
                                                                  "HBJ7Tc/S4jyIwzgnNXgTRcgWVHvtLMZ/lJPKcU1OunE+cTsYn72VwIkuXcwb" +
                                                                  "XquthGfYVnJ4FqvhMFlsn3Kspe3jlKzmfMnaaVA9LUum2OrRWYz2GA4z4Kqs" +
                                                                  "ngQ4xq/Drnke+X+ZB4Nq1NZx9M7NU461fPgcE1LPzmKJczichmqqQ+PEfYY4" +
                                                                  "83EYIge34FIX/XzH4V3UizuRXoAHlgt4sTR/yIW3O2QB/K72IJf49dJBmaz1" +
                                                                  "+2Vcunxu1+ADNz/9pHX3kxQ6NYVS5kKJsa6heaRaVVaaI6u6b92thudq1ziA" +
                                                                  "3mwd2HX10gJXdIHTdOzTl/huSGYof1F65/zWl346U/0WFNQ9JACZPX9PcSOa" +
                                                                  "07NQIvZEikspoLq4unWu+9bkto2pv/5GtPrEKr3LytPHpasX9r59YvF5uOLN" +
                                                                  "7SdV4ECWEx3yjkl1mEnjRozUy2ZPDo4IUmSqeOp0A6I0xRubsIttzvr8LP5y" +
                                                                  "wEl7cYtS/HsLXIsmmNGlZdWkXennujOen1UdsM/quo/BnSlo41IWYqI3oDmJ" +
                                                                  "RwZ03engyOd0EctjpVLMuoS+IF5x+P7/AEs254jZGAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457212322000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    GameBoyPrinter() { super();
                       window = new GameBoyPrinter.GameBoyPrinterWindow(
                                  "Game Boy Printer");
                       window.show();
                       bufferFillPos = 0;
                       bufferEmptyPos = 0;
                       dataSize = 640;
                       for (int r = 0; r <
                                         IMAGE_WIDTH *
                                         IMAGE_HEIGHT;
                            r++) { imageData[r] =
                                     -16777216;
                       }
                       source = new java.awt.image.MemoryImageSource(
                                  IMAGE_WIDTH,
                                  IMAGE_HEIGHT,
                                  new java.awt.image.DirectColorModel(
                                    32,
                                    16711680,
                                    65280,
                                    255,
                                    -16777216),
                                  imageData,
                                  0,
                                  IMAGE_WIDTH);
                       source.setAnimated(
                                true);
                       source.newPixels();
                       image = window.createImage(
                                        source);
                       window.setImage(image);
                       tileX = 0;
                       tileY = 1; }
    void setDmgcpu(Dmgcpu d) { cpu = d; }
    void send(byte b) { java.lang.System.
                          out.print(b + " ");
                        cpu.ioHandler.registers[1] =
                          0;
                        cpu.ioHandler.registers[2] &=
                          127;
                        cpu.triggerInterruptIfEnabled(
                              cpu.
                                INT_SER);
                        buffer[bufferFillPos++] =
                          JavaBoy.
                            unsign(
                              b);
                        if (bufferFillPos ==
                              BUFFER_SIZE) {
                            bufferFillPos =
                              0;
                        }
                        checkPackets(); }
    int bytesAvailable() { if (bufferFillPos >
                                 bufferEmptyPos) {
                               return bufferFillPos -
                                 bufferEmptyPos;
                           }
                           else {
                               return BUFFER_SIZE -
                                 bufferEmptyPos +
                                 bufferFillPos;
                           } }
    short getByte(int pos) { return buffer[(bufferEmptyPos +
                                              pos) %
                                             BUFFER_SIZE];
    }
    void consumeByte(int num) { java.lang.System.
                                  out.println(
                                        "Bytes consumed: " +
                                        num);
                                bufferEmptyPos =
                                  (bufferEmptyPos +
                                     num) %
                                    BUFFER_SIZE;
    }
    void scrollImage() { for (int y = 0; y <
                                           IMAGE_HEIGHT -
                                           8;
                              y++) { for (int x =
                                            0;
                                          x <
                                            IMAGE_WIDTH;
                                          x++) {
                                         imageData[y *
                                                     IMAGE_WIDTH +
                                                     x] =
                                           imageData[(y +
                                                        8) *
                                                       IMAGE_WIDTH +
                                                       x];
                                     } } }
    void checkPackets() { if (getByte(0) ==
                                136) { if (bytesAvailable(
                                             ) >=
                                             3 &&
                                             getByte(
                                               1) ==
                                             51) {
                                           switch (getByte(
                                                     2)) {
                                               case 1:
                                               case 2:
                                               case 15:
                                                   {
                                                       if (bytesAvailable(
                                                             ) ==
                                                             10) {
                                                           consumeByte(
                                                             10);
                                                       }
                                                       break;
                                                   }
                                               case 4:
                                                   {
                                                       if (bytesAvailable(
                                                             ) ==
                                                             6) {
                                                           dataSize =
                                                             (getByte(
                                                                5) <<
                                                                8) +
                                                               getByte(
                                                                 4);
                                                           java.lang.System.
                                                             out.
                                                             println(
                                                               "Data size set to " +
                                                               dataSize);
                                                           consumeByte(
                                                             6);
                                                       }
                                                       break;
                                                   }
                                           }
                                       } }
                          else {
                              if (bytesAvailable(
                                    ) ==
                                    16 &&
                                    dataSize >
                                    0) {
                                  for (int offs =
                                         0;
                                       offs <
                                         8;
                                       offs++) {
                                      int b1 =
                                        getByte(
                                          offs *
                                            2);
                                      int b2 =
                                        getByte(
                                          offs *
                                            2 +
                                            1);
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  0] =
                                        palette[((b1 &
                                                    128) >>
                                                   6) +
                                                  ((b2 &
                                                      128) >>
                                                     7)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  1] =
                                        palette[((b1 &
                                                    64) >>
                                                   5) +
                                                  ((b2 &
                                                      64) >>
                                                     6)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  2] =
                                        palette[((b1 &
                                                    32) >>
                                                   4) +
                                                  ((b2 &
                                                      32) >>
                                                     5)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  3] =
                                        palette[((b1 &
                                                    16) >>
                                                   3) +
                                                  ((b2 &
                                                      16) >>
                                                     4)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  4] =
                                        palette[((b1 &
                                                    8) >>
                                                   2) +
                                                  ((b2 &
                                                      8) >>
                                                     3)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  5] =
                                        palette[((b1 &
                                                    4) >>
                                                   1) +
                                                  ((b2 &
                                                      4) >>
                                                     2)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  6] =
                                        palette[((b1 &
                                                    2) >>
                                                   0) +
                                                  ((b2 &
                                                      2) >>
                                                     1)];
                                      imageData[(tileY *
                                                   8 +
                                                   offs) *
                                                  IMAGE_WIDTH +
                                                  tileX *
                                                  8 +
                                                  7] =
                                        palette[((b1 &
                                                    1) <<
                                                   1) +
                                                  ((b2 &
                                                      1) >>
                                                     0)];
                                  }
                                  dataSize -=
                                    16;
                                  tileX++;
                                  if (tileX ==
                                        IMAGE_WIDTH >>
                                        3) {
                                      tileX =
                                        0;
                                      tileY++;
                                      if (tileY *
                                            8 ==
                                            IMAGE_HEIGHT -
                                            8) {
                                          scrollImage(
                                            );
                                          tileY--;
                                      }
                                  }
                                  consumeByte(
                                    16);
                                  source.
                                    newPixels(
                                      );
                                  window.
                                    repaint(
                                      );
                              }
                              else
                                  if (dataSize ==
                                        0) {
                                      consumeByte(
                                        1);
                                  }
                          } }
    void shutDown() { window.hide(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+FILxrrcEA6Kjs4/xOInqw2J/wMxQqkMUikAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457212322000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "c11PnMJ5WuTfp1/73e4PKH/9YumOw4MR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NxzoPNnpuZPHIe4LtCgOHP7EoYjHTu67fh9IyX5kk9P7rkdzd96m6/by0WGe" +
       "C0dvdH9i2+C7pxocP+3zZ0X2Bhj/UIt2b9LO3EpMXEM90p//catdxON32V74" +
       "7ze+2sj3hPO3i/CZwOVNtN14vXDX+YNw4b4iK4HWoeaoRYM/P+R64cJb4Foc" +
       "49y+gXtxz/XFt8z1OOx33aTukSK7XLwlAwMQ4olkWMUxs6Lp8IjclbdAbvuq" +
       "vXgr9NKe3Etvp+YOtyyevAnDp4vs+6PSJV2LCECyaPPTR9Te91Z1tHi/9PKe" +
       "2stvP7UP3oTatSL7waj0juK4VmxrB/SOqeVfeqv0CrX8wp7eF95WtcRuUveh" +
       "IkMAs1AJXMs6fGl1jFntrTIrXi7//J7Zz7+tzNo3qSOL7KNR6X5lpSlmccxe" +
       "2/1T4hi1j71VakXbb+6pffNtpcbepG5SZIMIuONVHLXd1DlFa3g7tLIbTnx7" +
       "3sELuXuKiuIwaHbhZEBxcKvSw7e61bEY5JkTkcP2XykHXj7e/S/luvKVV/qj" +
       "H38D/YXd2WTFkvK8kHLPsHRpd0z6MFJ46lxpB7Lu7j37vQd/+d73H0Q1D+4A" +
       "H03LMWxPnH0ieHuYoTjDm/+j9/zah//uK3+0Pcv4fwEC5tAeLjQAAA==");
}
