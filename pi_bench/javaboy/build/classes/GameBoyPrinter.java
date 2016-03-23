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
        public static final long jlc$SourceLastModified$jl7 = 1457157976000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwcRxWfO3/EdhJ/JXHSfDiJfQnKBz7StEDqEBI7duz0" +
                                                                  "bJ/sYIRDc5nbm/NtvLe72Z2zzy6mTSQUF6lR2qZJQGn+StUSpSRCVFCgVVAF" +
                                                                  "bdWC1FKgBTVFgESgRDRCtIgA5b3Z3dvbvY8oAizteHfmvTfzvn7vzV28TqpM" +
                                                                  "g7QylXfwaZ2ZHT0qj1LDZIluhZrmPpiLSacr6F8PXBvcFiTVY6Q+Rc0BiZqs" +
                                                                  "V2ZKwhwjq2TV5FSVmDnIWAI5ogYzmTFJuaypY2SJbPandUWWZD6gJRgSjFIj" +
                                                                  "Qpoo54Ycz3DWbwvgZFUEThIWJwnv8i93RsgCSdOnXfJleeTdeStImXb3Mjlp" +
                                                                  "jByikzSc4bISjsgm78waZJOuKdPjisY7WJZ3HFLutk2wN3J3gQnaLjd8cPNE" +
                                                                  "qlGYYBFVVY0L9cxhZmrKJEtESIM726OwtHmYfJlURMj8PGJOQhFn0zBsGoZN" +
                                                                  "HW1dKjj9QqZm0t2aUIc7kqp1CQ/EyVqvEJ0aNG2LiYozg4QabusumEHbNTlt" +
                                                                  "LS0LVHx8U/jk6QON36ogDWOkQVZH8DgSHILDJmNgUJaOM8PclUiwxBhpUsHZ" +
                                                                  "I8yQqSLP2J5uNuVxlfIMuN8xC05mdGaIPV1bgR9BNyMjcc3IqZcUAWV/VSUV" +
                                                                  "Og66tri6Whr24jwoWCfDwYwkhbizWSonZDXByWo/R07H0L1AAKzz0oyntNxW" +
                                                                  "lSqFCdJshYhC1fHwCISeOg6kVRoEoMHJ8pJC0dY6lSboOIthRProotYSUNUK" +
                                                                  "QyALJ0v8ZEISeGm5z0t5/rk+uP34/WqfGiQBOHOCSQqefz4wtfqYhlmSGQzy" +
                                                                  "wGJcsDFyirY8PxckBIiX+Igtmu986cbOza1XXrZoVhShGYofYhKPSefj9a+v" +
                                                                  "7N6wrQKPUaNrpozO92gusixqr3RmdUCYlpxEXOxwFq8M//gLD15g7wVJXT+p" +
                                                                  "ljQlk4Y4apK0tC4rzNjDVGZQzhL9pJapiW6x3k/mwXtEVpk1O5RMmoz3k0pF" +
                                                                  "TFVr4htMlAQRaKI6eJfVpOa865SnxHtWJ4QE4CHV8Owm1p/4z8k94ZSWZmFd" +
                                                                  "DkcNDVU3wwA2cTBrKoyBEtemw6YhhfdA8HRp01FDxGMHLun/FXcWz7ZoKhAA" +
                                                                  "s630J60C8d6nKQlmxKSTma6eG9+MvWoFBAaxrRUn7V65Ie/n5yENtCkSCIg9" +
                                                                  "FuOmllvAqBOQnoCPCzaM3Lf34FxbBcSDPlWJdgLSNk+d6HZz2AHemHSpeeHM" +
                                                                  "2qtbXgySyghpphLPUAVhf5cxDoAiTdg5tyAOFcQF8jV5QI4VyNAklgAcKQXo" +
                                                                  "tpQabZIZOM/J4jwJTpnBhAqXBvmi5ydXzkwdGX3gE0ES9GI3blkFsIPsUUTc" +
                                                                  "HLKG/DlbTG7DsWsfXDo1q7nZ6ykGTg0r4EQd2vxR4DdPTNq4hj4be342JMxe" +
                                                                  "C+jKKWQDAFerfw8POHQ6QIu61IDCSc1IUwWXHBvX8ZShTbkzIjybxPtiCIsg" +
                                                                  "ZksLPH12+oj/uNqi47jUCmeMM58WAsg/M6I/8dZP/7hVmNvB/Ia8Yj3CeGce" +
                                                                  "zqCwZoEoTW7Y7jMYA7p3zkQfe/z6sf0iZoGivdiGIRy7AV/AhWDmr7x8+O13" +
                                                                  "r55/M5iLc5L16hYsoxtsst49BsCTApmOwRL6nAphKSdlGlcY5tM/G9ZtefbP" +
                                                                  "xxst9ysw40TP5lsLcOfv6CIPvnrgw1YhJiBheXRN5ZJZmLvIlbzLMOg0niN7" +
                                                                  "5I1VX3uJPgHoDYhpyjPMAkE7xfFQy6BbEpxYCTusSiiceJdYDotxK1rCthd+" +
                                                                  "fxqHdWZ+MnjzLa+/iUkn3nx/4ej7L9wQangbpHzfD1C90wo3HNZnQfxSP1j1" +
                                                                  "UTMFdHddGfxio3LlJkgcA4kSdAXmkAEwmfVEik1dNe9XP3yx5eDrFSTYS+oU" +
                                                                  "jSZ6qUg6UgvRzswUIGxW/+xOy+tTNTA0ClVJgfIFE2j51cV92pPWufDCzHeX" +
                                                                  "fnv7U+euiqjTLRkrBH8QQd+DsqLNdhP9ws8+9fOnHjk1ZRXqDaXRzce37B9D" +
                                                                  "Svzob/9eYHKBa0WaCB//WPji2eXdO94T/C7AIHcoW1ioAKRd3jsvpP8WbKv+" +
                                                                  "UZDMGyONkt3WjlIlg2k7Bq2c6fS60Pp61r1tmdWDdOYAdKUf3PK29UObWyDh" +
                                                                  "HanxfWExNKuDp8fO+B4/mgWIeNkrWD6Gw6ZCvCjFzUlAdnKsXsQIneId/Wlo" +
                                                                  "EC2UxHEbDvdaQbG9ZAzu9u6KS732rr0lzjxS9syluDncECWqMG/5xxI7komb" +
                                                                  "UKrlNCDzpN1r3hk9KM2For+3wvOOIgwW3ZKnww+P/vLQawL3a7AZ2Oe4JK/U" +
                                                                  "Q9OQV3QarUN/BH8BeP6NDx4WJ6yerbnbbhzX5DpHTK+yeeJTIDzb/O7E2WvP" +
                                                                  "WAr4k8JHzOZOfvWjjuMnLVS3rh/tBTeAfB7rCmKpg8N+PN3acrsIjt4/XJr9" +
                                                                  "/tOzx6xTNXub6R64Kz7zi3+91nHmN68U6QUrZPsKuTUP6KEce31jKbT7oYYf" +
                                                                  "nGiu6IU2op/UZFT5cIb1J7zJM8/MxPOc5V5r3ISyVUPHQMhvBB/4wntfmfDO" +
                                                                  "FgtT0aUH/F16fil2MZSgTVeVukgJe54/evJcYujJLUG7fMU5qbbvt66cChTj" +
                                                                  "weIBcW90ge2d+kd/91xovOt2ml2ca71FO4vfq8HRG0uHrf8oLx390/J9O1IH" +
                                                                  "b6NvXe0zkV/kNwYuvrJnvfRoUFySLcQtuFx7mTq9oVJnMJ4xVG9wtOecWovO" +
                                                                  "Wg3PoO3UweK9o4gHMW7E4eNWDIPL9ExckSVfw1ZTRqCvg7GzAT+HxF6zZVqc" +
                                                                  "B3CY5KQGb5sI2YLqPjuL8R/lpHJSkxNunE/dCsbLtxI40aWLecNrtTXwDNtK" +
                                                                  "DpexGg7ThfYpxVrcPk7JasqVrD0G1VOyZIqtHi5jtEdwmANXZfQEwDF+HXHN" +
                                                                  "89D/yzwYVKO2jqO3b55SrKXD57iQeraMJc7hcBqqqQ6NE/cZ4sz/whBZuAUX" +
                                                                  "u+jnOg7vol7YifQCPLBswIuluUMuudUh8+C33YNc4hdKB2Uy1m+UMenSub2D" +
                                                                  "99/45JPW3U9S6MwMSpkPJca6huaQam1JaY6s6r4NN+sv165zAL3JOrDr6hV5" +
                                                                  "rugCp+nYpy/33ZDMUO6i9Pb57S/8ZK76DSio+0kAMnvR/sJGNKtnoETsjxSW" +
                                                                  "UkB1cXXr3PD16R2bk3/5tWj1iVV6V5amh0b7sbf6L098uFP8JFYFDmRZ0SHv" +
                                                                  "nlaHmTRpeOpyPaIyxRuasINtvoW5WfylgJO2wpak8PcVuAZNMaNLy6gJu7LP" +
                                                                  "d2c8P5U64J7RdR+DO5PXtiUthETrQzMSiwzoutOx3aOL0B0vllHWnfM58YrD" +
                                                                  "9/4DUxLbqKwYAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457157976000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
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
      1457157976000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaCXAcxRXtXd23LB+AseRDMpQNaG1jbGwZY53WOitZsWQD" +
       "4pBHsy3tWLMzw0yvtBI4MVQFO0mFOCDArgIXRUwwlMEuKgRSCcQJFY5AUcWR" +
       "hIRwhKQSHOIUzgGpECD/98zuHLuzZpNIVdPq7f7/9/u/f//+3TNHT5EiQycN" +
       "VGHNbFKjRnOnwvoE3aDRdlkwjAFoGxLvKhD+dt17veuCpHiQVMcEo0cUDNol" +
       "UTlqDJJ6STGYoIjU6KU0ihx9OjWoPi4wSVUGyVzJCMc1WRIl1qNGKRLsEPQI" +
       "mSUwpkvDCUbDlgBG6iOAJMSRhFq93S0RUimq2qRNfraDvN3Rg5RxeyyDkdrI" +
       "LmFcCCWYJIciksFakjq5QFPlyVFZZc00yZp3yZdYJtgSuSTDBEuO13z48f5Y" +
       "LTfBbEFRVMbVM7ZRQ5XHaTRCauzWTpnGjevJl0hBhFQ4iBlpiqQGDcGgIRg0" +
       "pa1NBeirqJKIt6tcHZaSVKyJCIiRxW4hmqALcUtMH8cMEkqZpTtnBm0XpbU1" +
       "tcxQ8Y4LQtN3XVf7aAGpGSQ1ktKPcEQAwWCQQTAojQ9T3WiNRml0kMxSYLL7" +
       "qS4JsjRlzXSdIY0qAkvA9KfMgo0Jjep8TNtWMI+gm54Qmaqn1RvhDmX9KhqR" +
       "hVHQdZ6tq6lhF7aDguUSANNHBPA7i6VwTFKijCz0cqR1bPoCEABrSZyymJoe" +
       "qlARoIHUmS4iC8poqB9cTxkF0iIVHFBnZL6vULS1JohjwigdQo/00PWZXUBV" +
       "xg2BLIzM9ZJxSTBL8z2z5JifU70bbr1B6VaCJACYo1SUEX8FMDV4mLbREapT" +
       "WAcmY+XyyJ3CvCf3BQkB4rkeYpPm8RtPb7qw4cRzJs25WWi2Du+iIhsSDw9X" +
       "v7ygfdm6AoRRqqmGhJPv0pyvsj6rpyWpQYSZl5aInc2pzhPbnrlqz0P0/SAp" +
       "D5NiUZUTcfCjWaIa1ySZ6pupQnWB0WiYlFEl2s77w6QE6hFJoWbr1pERg7Iw" +
       "KZR5U7HKf4OJRkAEmqgc6pIyoqbqmsBivJ7UiPVXBE/IqvP/jKwPxdQ4DWlS" +
       "qE9XUXUjBMFmGMwaC6GjDKuTIUMXQ5vBedrUyT6d+2Mzdmn/E3cSsc2eCATA" +
       "bAu8i1YGf+9W5SjVh8TpRFvn6UeGXjAdAp3Y0oqRardcEghwcXNQvjkDYL8x" +
       "WIkQCiuX9V+7Zee+JQUw9dpEISiPpEtcW0K7vVxTMXZIPFZXNbX4rZVPB0lh" +
       "hNQJIksIMkb4Vn0UYoc4Zi2vymHYLOyYvcgRs3Gz0VWRRiFk+MVuS0qpOk51" +
       "bGdkjkNCakfBtRPyj+dZ8ZMTByZu2vHlFUESdIdpHLIIIgyy92FwTQfRJu/y" +
       "zCa3Zu97Hx67c7dqL1RX3E9tVxmcqMMS74R7zTMkLl8kPDb05O4mbvYyCKRM" +
       "AMeHGNXgHcMVB1pSMRV1KQWFR1Q9LsjYlbJxOYvp6oTdwj1xFq/PQbfAhVED" +
       "z7XWSuH/sXeehuVZpuein3m04DH7sn7tntdfOnkxN3cqvNc49uV+ylocIQWF" +
       "1fHgMct22wGdUqB780Df7Xec2ns191mgaMw2YBOW7RBKYArBzF957vpfvf3W" +
       "4deCaT8nSbdugRy6wSDn2TAgEsmwqNFZmrYr4JbSiCQMyxTX079rlq587M+3" +
       "1prTL0NLynsuPLMAu/2cNrLnhes+auBiAiLuhLapbDIzvM62JbfqujCJOJI3" +
       "vVJ/8FnhHgjUEBwNaYqa8c5SHUGt5vqHeHmxp28NFksNp8+7l5UjYxkS97/2" +
       "QdWOD546zdG6Ux7nFPcIWovpVViclwTxZ3ljUrdgxIBu9Ynea2rlEx+DxEGQ" +
       "KMI+b2zVIfAlXQ5hUReV/PrHT8/b+XIBCXaRclkVol0CX1ukDJyaGjGImUnt" +
       "8k3m5E6UQlHLVSUZymc0oIEXZp+6zrjGuLGnnjjruxseOPQWdy7NlHEu56/B" +
       "MO4KpjxxttfzQ6+u/fkD37pzwtx6l/kHMQ/f2f/aKg/f/O4/M0zOw1eWtMDD" +
       "Pxg6evf89o3vc347jiB3UzJz64FYbPOueij+j+CS4p8GSckgqRWtRHWHICdw" +
       "dQ5CcmaksldIZl397kTLzCpa0nFygTeGOYb1RjB7y4M6UmO9yhO0SnAKF8Kz" +
       "wlrYK7xBi++MpkchpOYw7JijVK97997DH92099IgLp+icYQOVqm16XoTmA/f" +
       "cvSO+orpd77OJ56QPVx0Nx/+fF4ux+Iic19loICkCLIn7hTngMdIRdv2rq7O" +
       "bUP94cFO98aMm19/YtiATVSKQ8wctxK+VX07xX1Nfb83PeqcLAwm3dwjoW/s" +
       "+OWuF3lELsVteiBlRccmDNu5YzuoNaF/Bn8BeD7FByFjg5k41bVb2duidPqG" +
       "KyKna3sUCO2ue3vs7vceNhXw+rGHmO6b/tpnzbdOm/HWPAM0ZqThTh7zHGCq" +
       "g8V2RLc41yico+uPx3b/4MjuvSaqOndG2wkHtod/8cmLzQfeeT5LQlYgWec4" +
       "DCyBdJY1xz03pkIdX6354f66gi7Y4MOkNKFI1ydoOOr29xIjMeyYLPtsYa8B" +
       "SzWcGEYCy2EOzO0Zy7VYhE03XO8bFdvcq6genpWWm67MsoqwsgWa78WKmUKc" +
       "j0Vvprf7iQFvD/e0bu4cuiLcMdCNTQMe0CN5gm6AZ5U12ip/0IFNWInnBO0n" +
       "hpFKE3R3Z3hz90A21EqeqLvhWW0NtzoDNeGVRE6wftyMlGiCTBmj7nufdGjg" +
       "+YPpiNdUPPMj49t/eNR0+GyBx3PSPPJAqfhG/BkeeHC0frdW5fBYBjD/M3LJ" +
       "5zwntQs6HMmjozR1wPrvGHGhL/UPQw7dD32n8aUvH2r8LU8/SiUD9iEIhFlO" +
       "6A6eD46+/f4rVfWP8My8EOOptTzdVxuZNxeuCwluuRosdvPqgKZpxBs78Kfg" +
       "XdDjn9/LAqkFvcaajzU+XnaL7WUXZGbLftyMFE9AxFQnOMvZEJDdB9Im988r" +
       "OK1Hm715alMJz1oLz1ofbb6ZUxs/bgjfopZIqVLcER+Fnx60+/NEuwyeS63x" +
       "LvVBeyAnWj9uQDicGIF1yVmmMkOD77CcdA8Wh8z6Nmt3xH9XOOpXQyIDKbWe" +
       "saWZbvm5HfZgnkabDc86C/06H6MdyWk0P25GqkyjdUmy3Kca2YL4g3mixcp6" +
       "a7z1PmiP5UTrx81ItYmWnz984B7PE24dPBusATf4wP1eTrh+3OAtkCLRK7Oh" +
       "fHwGUD6JxRPWqFdlG/WpPEethmejNepGn1F/ktM2ftyMlEYFJvTD8Twb0Kfz" +
       "BDqfeLbYLECfzwnUjxvCiqEmdGvTgji4iB+FhAnWLMUF2F97aFzVJ8NY7+eE" +
       "HlV+lqcqVfC0WmBafVR5JacqftzgGRxySpPqtCYcvQf3q3nixt2jzRq5zQf3" +
       "Gzlx+3EzUsZxd4DDYMONHqS/yYE0mW3E9J/r7tsxouMeg2DuVO/3eoIfkA7f" +
       "PH0ouvX+lan07xoAzFTtIpmOU9khqhQlua5Eenj+Y98vvFl92+++3zTals/V" +
       "MrY1nOHyGH8vhCRuuX8O6IXy7M1/mj+wMbYzj1vihR4reUU+2HP0+c3nibcF" +
       "+dsn8+Ij462Vm6nFffwr1ylL6Ir7wNfo9qRz4Bm35nXc64e25/g5oR8rp7Sv" +
       "DB3b+zSX+lcPgfNO8e9YnAKvMCgzs6hsqUXhuCpFba/+y5nWX+7LO2zYpPH2" +
       "k5lbyZSl5VT+BvJjzW6gM+VThcOTjGZPmhBLIOhv1kAZNn4CMgyqRLH+oW29" +
       "T2fAevi2jOdi+ywT7Mvfen6sOdSck6NvHhY1mBehGVvHBUnG63QkHUgbI1A7" +
       "A8bgJ1vMD/ZbGu3P3xh+rP5rbYBrvTiHRRqxWADH/VHK2sAoSHOvbYr6mVpV" +
       "mIFMW/pM528KP9YzmaI5hylWYLGMkQq8iE7AwdMyh71MAstnyhy4TA5aOh3M" +
       "3xx+rDm0bcnRdxkWa8AShqirspxOdxyWWDtTlsDKfZY69+VvCT/WHNp25+jb" +
       "gkU7I5VijIpj+JUGNU+zDlN0zJQpUMZJS5+T+ZvCjzWHuttz9OFOFOiDg4gR" +
       "S7AOdULxmOGL/w8zJDM+StC0VP5dih348i8ZcCecKQhk7pkgOHLURlduxz+O" +
       "SuVhCfPzqCHx2KEtvTecXnO/+S5alIWpKZRSESEl5mvxdC632FdaSlZx97KP" +
       "q4+XLU1lvbNMwPY0nmvbmp+qLMXdbwIWZL4JgASWvxMeEgdvfz18fOyjTfwz" +
       "mSLItGmSv2PrmFS2UXFcd70mqMaEUsDvlzhAS6+qdCt+UsDIksw3JJkfYpTL" +
       "6gTV29SEmVZUQQJst6SSa1demtA0D4PdYtkUy51YbE+iWRgJXKmlP8ThEX22" +
       "aSAXUQEM7G0OQHNcinqbg5AJxaTRmKsd31PBUJdrpj+iX/Pvp/hBalPyP/CU" +
       "IQsJKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457157976000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HANfrvh+ZzOW5r7UUhoczg+iRuLjGm6nXrU1xtbh2GtBiNXgV/N0zbURuDpR" +
       "RbrXqDdzddDkU8TBGIUQ3cQTBFOxNtN0UbNWfKAuU6ITt+eOJlUDq59CvbQ/" +
       "mIyAIZOruUDoqAWU3+BZTYCZAJ+2YBmaEZ3uTGIVay24Vrk7q8Tr3jCTBqsB" +
       "YfNO1FrX7Ea/yU8snBQ4fpHZStkl+rOFBzXzYDWIyYHjrFZBnIYazUxENUPG" +
       "Ft6PG024Q9H1kbdK0yjS80kTAgvluldDvHwTpU0LXuPUBNarOiyNlmAJpesw" +
       "Vc7pTUUTI6rXY9JlU0v0VtutJUqtjqzMTo3Ph3mzjs1lhgaasoJWUJere60B" +
       "p6yXPitGLC7iRFfdqJNGV7GldWipxMKqtZH1lMy7nlR2sGw51Qb0XK6wqw6S" +
       "1akmb9PtzKDLnIOOsNYo31jBfISkHROCKG+tGB493yBDcyWM2ki7jfTwdrXc" +
       "bhNL0oNMZT6hBd+uNGfu1EZhXUk4GnIDT0UQethoThghLY9TGNKxepxChKlU" +
       "2pZLdNddknAQY+osKZVg1aQa+Agt80y7rmB0uyVRdqUNzyMTnQrcaNLaKFE6" +
       "ggSghemsMtblVo3RfIVEN3YNzChXhEOIFmOsZvXJUIg0sMCyimL3xnFjnsfu" +
       "WMLgjtPqaD0E62TYatlY1yuyIFfV2AQuzGCUjRypFvJduhprtSREEkUbG7MN" +
       "FAxwm27KcOQ5uazSNoyLDEqVF/7UmBpIjg+6/rIlVFlSqVcyU3GhmElrMlyn" +
       "VnHCST7tqIPqZo1Hrgq3FJvMJ7qmTRvkxJovRU2p97pZRx3OK2lernlrQp01" +
       "a4263mwuTWRep+j1eIQRlUx1aTqotlNiRWnZnGSicC61OlwuKoP+vJtV+3RO" +
       "lxcZIsyNfrk2o1sypiaK31xqjieKdhOhQtffhEtRQlriyOZHyqosJF6gI+YE" +
       "S3qwVpbjuhKbpEKp3fF0Qmnl7rixBEvdosFXqqYHlwlsLBKO06HLjuFho36N" +
       "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" +
       "eOLkueoPgJDsezY5fa56NHbnHapus48u");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5Fw4eiv7U1uB750SOH5j50+L6C3Q/6EW7d6UnXlUmLimeqQ//+NWp4THn7LN" +
       "+O83vrrI94Tzd4rwmcDlLNoerF645/xOuHCpiEpAOtQctRD4s0OuFy7cAdfi" +
       "uuX2DdvLe64v3zHX47Dfc5Oyx4rocvEWDHRAiCaSaRVXxQpR8ojclTsgt31d" +
       "Xrz1eWVP7pV3UnPJLYunb8Lw2SL6wah031KLOoBkIfNXj6h94E51tHh/9Oqe" +
       "2qvvPLUP34TatSL64aj0ruLKVWxrB/SOqeVfuFN6hVp+cU/vi++oWrZuUvaR" +
       "IqoBZqESuJZ1+FLqGLP6nTIrXh7/wp7ZL7yjzHo3KcOK6GNR6UHF0JR1cR1e" +
       "2/1HwzFqH79TaoXst/bUvvWOUmNuUsYW0SgCy7ERRz1345yiRd4OrfSGW9ue" +
       "d/DC7f6ioLjQmV446VAcPKr06K0edcwHee6E57D975GDVT7e/f/IdeWrrw3H" +
       "P/lW8xd394sVS8rzopX7ydJ9u6vOh57CM+e2dtDWvfjz33/4Vx744IFX8/AO" +
       "8NGwHMP21Nm3ereXFYp7uPk/ft8//Ojfee0Pt/cR/y/FUvbj1jMAAA==");
}
