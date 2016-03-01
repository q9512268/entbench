package org.apache.batik.transcoder.wmf.tosvg;
public class AbstractWMFPainter {
    public static final java.lang.String WMF_FILE_EXTENSION = ".wmf";
    protected org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont = null;
    protected int currentHorizAlign = 0;
    protected int currentVertAlign = 0;
    public static final int PEN = 1;
    public static final int BRUSH = 2;
    public static final int FONT = 3;
    public static final int NULL_PEN = 4;
    public static final int NULL_BRUSH = 5;
    public static final int PALETTE = 6;
    public static final int OBJ_BITMAP = 7;
    public static final int OBJ_REGION = 8;
    protected org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore;
    protected transient boolean bReadingWMF = true;
    protected transient java.io.BufferedInputStream bufStream = null;
    protected java.awt.image.BufferedImage getImage(byte[] bit, int width,
                                                    int height) { int _width =
                                                                    ((int)
                                                                       bit[7] &
                                                                       255) <<
                                                                    24 |
                                                                    ((int)
                                                                       bit[6] &
                                                                       255) <<
                                                                    16 |
                                                                    ((int)
                                                                       bit[5] &
                                                                       255) <<
                                                                    8 |
                                                                    (int)
                                                                      bit[4] &
                                                                    255;
                                                                  int _height =
                                                                    ((int)
                                                                       bit[11] &
                                                                       255) <<
                                                                    24 |
                                                                    ((int)
                                                                       bit[10] &
                                                                       255) <<
                                                                    16 |
                                                                    ((int)
                                                                       bit[9] &
                                                                       255) <<
                                                                    8 |
                                                                    (int)
                                                                      bit[8] &
                                                                    255;
                                                                  if (width !=
                                                                        _width ||
                                                                        height !=
                                                                        _height)
                                                                      return null;
                                                                  return getImage(
                                                                           bit);
    }
    protected java.awt.Dimension getImageDimension(byte[] bit) {
        int _width =
          ((int)
             bit[7] &
             255) <<
          24 |
          ((int)
             bit[6] &
             255) <<
          16 |
          ((int)
             bit[5] &
             255) <<
          8 |
          (int)
            bit[4] &
          255;
        int _height =
          ((int)
             bit[11] &
             255) <<
          24 |
          ((int)
             bit[10] &
             255) <<
          16 |
          ((int)
             bit[9] &
             255) <<
          8 |
          (int)
            bit[8] &
          255;
        return new java.awt.Dimension(
          _width,
          _height);
    }
    protected java.awt.image.BufferedImage getImage(byte[] bit) {
        int _width =
          ((int)
             bit[7] &
             255) <<
          24 |
          ((int)
             bit[6] &
             255) <<
          16 |
          ((int)
             bit[5] &
             255) <<
          8 |
          (int)
            bit[4] &
          255;
        int _height =
          ((int)
             bit[11] &
             255) <<
          24 |
          ((int)
             bit[10] &
             255) <<
          16 |
          ((int)
             bit[9] &
             255) <<
          8 |
          (int)
            bit[8] &
          255;
        int[] bitI =
          new int[_width *
                    _height];
        java.awt.image.BufferedImage img =
          new java.awt.image.BufferedImage(
          _width,
          _height,
          java.awt.image.BufferedImage.
            TYPE_INT_RGB);
        java.awt.image.WritableRaster raster =
          img.
          getRaster(
            );
        int _headerSize =
          ((int)
             bit[3] &
             255) <<
          24 |
          ((int)
             bit[2] &
             255) <<
          16 |
          ((int)
             bit[1] &
             255) <<
          8 |
          (int)
            bit[0] &
          255;
        int _planes =
          ((int)
             bit[13] &
             255) <<
          8 |
          (int)
            bit[12] &
          255;
        int _nbit =
          ((int)
             bit[15] &
             255) <<
          8 |
          (int)
            bit[14] &
          255;
        int _size =
          ((int)
             bit[23] &
             255) <<
          24 |
          ((int)
             bit[22] &
             255) <<
          16 |
          ((int)
             bit[21] &
             255) <<
          8 |
          (int)
            bit[20] &
          255;
        if (_size ==
              0)
            _size =
              ((_width *
                  _nbit +
                  31 &
                  ~31) >>
                 3) *
                _height;
        int _clrused =
          ((int)
             bit[35] &
             255) <<
          24 |
          ((int)
             bit[34] &
             255) <<
          16 |
          ((int)
             bit[33] &
             255) <<
          8 |
          (int)
            bit[32] &
          255;
        if (_nbit ==
              24) {
            int pad =
              _size /
              _height -
              _width *
              3;
            int offset =
              _headerSize;
            for (int j =
                   0;
                 j <
                   _height;
                 j++) {
                for (int i =
                       0;
                     i <
                       _width;
                     i++) {
                    bitI[_width *
                           (_height -
                              j -
                              1) +
                           i] =
                      (255 &
                         255) <<
                        24 |
                        ((int)
                           bit[offset +
                                 2] &
                           255) <<
                        16 |
                        ((int)
                           bit[offset +
                                 1] &
                           255) <<
                        8 |
                        (int)
                          bit[offset] &
                        255;
                    offset +=
                      3;
                }
                offset +=
                  pad;
            }
        }
        else
            if (_nbit ==
                  8) {
                int nbColors =
                  0;
                if (_clrused >
                      0)
                    nbColors =
                      _clrused;
                else
                    nbColors =
                      (1 &
                         255) <<
                        8;
                int offset =
                  _headerSize;
                int[] palette =
                  new int[nbColors];
                for (int i =
                       0;
                     i <
                       nbColors;
                     i++) {
                    palette[i] =
                      (255 &
                         255) <<
                        24 |
                        ((int)
                           bit[offset +
                                 2] &
                           255) <<
                        16 |
                        ((int)
                           bit[offset +
                                 1] &
                           255) <<
                        8 |
                        (int)
                          bit[offset] &
                        255;
                    offset +=
                      4;
                }
                _size =
                  bit.
                    length -
                    offset;
                int pad =
                  _size /
                  _height -
                  _width;
                for (int j =
                       0;
                     j <
                       _height;
                     j++) {
                    for (int i =
                           0;
                         i <
                           _width;
                         i++) {
                        bitI[_width *
                               (_height -
                                  j -
                                  1) +
                               i] =
                          palette[(int)
                                    bit[offset] &
                                    255];
                        offset++;
                    }
                    offset +=
                      pad;
                }
            }
            else
                if (_nbit ==
                      1) {
                    int nbColors =
                      2;
                    int offset =
                      _headerSize;
                    int[] palette =
                      new int[nbColors];
                    for (int i =
                           0;
                         i <
                           nbColors;
                         i++) {
                        palette[i] =
                          (255 &
                             255) <<
                            24 |
                            ((int)
                               bit[offset +
                                     2] &
                               255) <<
                            16 |
                            ((int)
                               bit[offset +
                                     1] &
                               255) <<
                            8 |
                            (int)
                              bit[offset] &
                            255;
                        offset +=
                          4;
                    }
                    int pos =
                      7;
                    byte currentByte =
                      bit[offset];
                    int pad =
                      _size /
                      _height -
                      _width /
                      8;
                    for (int j =
                           0;
                         j <
                           _height;
                         j++) {
                        for (int i =
                               0;
                             i <
                               _width;
                             i++) {
                            if ((currentByte &
                                   1 <<
                                   pos) !=
                                  0)
                                bitI[_width *
                                       (_height -
                                          j -
                                          1) +
                                       i] =
                                  palette[1];
                            else
                                bitI[_width *
                                       (_height -
                                          j -
                                          1) +
                                       i] =
                                  palette[0];
                            pos--;
                            if (pos ==
                                  -1) {
                                pos =
                                  7;
                                offset++;
                                currentByte =
                                  bit[offset];
                            }
                        }
                        offset +=
                          pad;
                        pos =
                          7;
                        if (offset <
                              bit.
                                length)
                            currentByte =
                              bit[offset];
                    }
                }
        raster.
          setDataElements(
            0,
            0,
            _width,
            _height,
            bitI);
        return img;
    }
    protected java.text.AttributedCharacterIterator getCharacterIterator(java.awt.Graphics2D g2d,
                                                                         java.lang.String sr,
                                                                         org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont) {
        return getAttributedString(
                 g2d,
                 sr,
                 wmffont).
          getIterator(
            );
    }
    protected java.text.AttributedCharacterIterator getCharacterIterator(java.awt.Graphics2D g2d,
                                                                         java.lang.String sr,
                                                                         org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont,
                                                                         int align) {
        java.text.AttributedString ats =
          getAttributedString(
            g2d,
            sr,
            wmffont);
        return ats.
          getIterator(
            );
    }
    protected java.text.AttributedString getAttributedString(java.awt.Graphics2D g2d,
                                                             java.lang.String sr,
                                                             org.apache.batik.transcoder.wmf.tosvg.WMFFont wmffont) {
        java.text.AttributedString ats =
          new java.text.AttributedString(
          sr);
        java.awt.Font font =
          g2d.
          getFont(
            );
        ats.
          addAttribute(
            java.awt.font.TextAttribute.
              SIZE,
            new java.lang.Float(
              font.
                getSize2D(
                  )));
        ats.
          addAttribute(
            java.awt.font.TextAttribute.
              FONT,
            font);
        if (wmfFont.
              underline !=
              0)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  UNDERLINE,
                java.awt.font.TextAttribute.
                  UNDERLINE_ON);
        if (wmfFont.
              italic !=
              0)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  POSTURE,
                java.awt.font.TextAttribute.
                  POSTURE_OBLIQUE);
        else
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  POSTURE,
                java.awt.font.TextAttribute.
                  POSTURE_REGULAR);
        if (wmfFont.
              weight >
              400)
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  WEIGHT,
                java.awt.font.TextAttribute.
                  WEIGHT_BOLD);
        else
            ats.
              addAttribute(
                java.awt.font.TextAttribute.
                  WEIGHT,
                java.awt.font.TextAttribute.
                  WEIGHT_REGULAR);
        return ats;
    }
    public void setRecordStore(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore) {
        if (currentStore ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          currentStore =
          currentStore;
    }
    public org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore getRecordStore() {
        return currentStore;
    }
    protected int addObject(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore store,
                            int type,
                            java.lang.Object obj) {
        return currentStore.
          addObject(
            type,
            obj);
    }
    protected int addObjectAt(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore store,
                              int type,
                              java.lang.Object obj,
                              int idx) { return currentStore.
                                           addObjectAt(
                                             type,
                                             obj,
                                             idx);
    }
    public AbstractWMFPainter() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xWMdhmF/DFfzT468YXA3/Aj+MP8LmcCAZp8wAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV7Cawr13ke39PT05Msa/WiyJIlWZJtmdYdksMVil2Ts5Cc" +
       "hRySs3Amjp9n5Qxn5SycIRPFCxDLSArHSGTFARylaJ2kDRQ7aBokQJpCbdAm" +
       "gYMANoLWLZAoDQo0revWhlG7qFunZ4Z3f/dd6VpqS2AOD8823/ef//znP5x/" +
       "Xvpm6dYoLJUD39ksHD/e07N4b+k09uJNoEd7BNVg5DDSNcSRo4gFZdfVd/3W" +
       "3d/9/mfNey6Xrkql+2XP82M5tnwvmuqR76x1jSrdfVSKObobxaV7qKW8lqEk" +
       "thyIsqL4Gar0pmNd49IT1AEECECAAASogAB1j1qBTm/WvcRF8h6yF0er0k+V" +
       "LlGlq4Gaw4tLj50cJJBD2d0fhikYgBGu5b95QKronIWlRw+57zjfQPhzZej5" +
       "X/zIPf/4ltLdUuluy5vlcFQAIgY3kUp3urqr6GHU1TRdk0r3erquzfTQkh1r" +
       "W+CWSvdF1sKT4yTUD4WUFyaBHhb3PJLcnWrOLUzU2A8P6RmW7mgHv241HHkB" +
       "uL7tiOuOIZ6XA4J3WABYaMiqftDlim15Wlx65HSPQ45PkKAB6Hqbq8emf3ir" +
       "K54MCkr37ebOkb0FNItDy1uAprf6CbhLXHrwpoPmsg5k1ZYX+vW49MDpdsyu" +
       "CrS6vRBE3iUuvfV0s2IkMEsPnpqlY/PzzdGPfuYnvIF3ucCs6aqT478GOr3z" +
       "VKepbuih7qn6ruOd76NekN/2B5++XCqBxm891XjX5nd/8tsfev87X/7jXZt3" +
       "nNFmrCx1Nb6uflG566sPIU91bslhXAv8yMon/wTzQv2Z/ZpnsgCsvLcdjphX" +
       "7h1Uvjz9V+LHf0P/xuXSHcPSVdV3Ehfo0b2q7waWo4d93dNDOda1Yel23dOQ" +
       "on5Yug3kKcvTd6Vjw4j0eFi64hRFV/3iNxCRAYbIRXQbyFue4R/kAzk2i3wW" +
       "lEql28BVuhNcT5Z2n+I7Lm0g03d1SFZlz/J8iAn9nH8+oZ4mQ7EegbwGagMf" +
       "UoD+209X91pQ5CchUEjIDxeQDLTC1HeVUBzKXqT6mh5CqWtAsR+tF1BXAWtA" +
       "VmOBxhm5UOe9XAWD/583z3LJ3JNeugQm7aHTJsMBq23gO2Cg6+rzSQ/79peu" +
       "f+Xy4RLal2lcagMEezsEewWCvSMEewDBXoFg70YEpUuXihu/JUey0xQwzzaw" +
       "GMCW3vnU7MeJj376XbcAFQ3SK2CS8qbQzU06cmRjhoUlVYGil17+fPoJ/mOV" +
       "y6XLJ21zjh4U3ZF3Z3KLemg5nzi9Js8a9+7n/ua7X37hWf9odZ4w9vtG48ae" +
       "+aJ/12k5h76qa8CMHg3/vkfl37n+B88+cbl0BVgSYD1jILHcML3z9D1OLP5n" +
       "DgxpzuVWQNjwQ1d28qoD63dHbIZ+elRSKMBdRf5eIONHS/vJieWR194f5Olb" +
       "dgqTT9opFoWh/sAs+OWv/9l/ggtxH9j0u4/tkjM9fuaYHckHu7uwGPce6QAb" +
       "6jpo9xefZ37hc9987scKBQAtHj/rhk/kKQLsB5hCIOaf/uPVv33lL7/455eP" +
       "lCYGG2miOJaa7Uj+LfhcAtcP8isnlxfsbMB9yL4hevTQEgX5nd99hA3YJAcs" +
       "zVyDnuA819csw5IVR8819n/d/WT1d/7LZ+7Z6YQDSg5U6v2vPsBR+Y/0Sh//" +
       "yke+985imEtqviceye+o2c7Q3n80cjcM5U2OI/vE1x7+pT+SfxmYbGAmI2ur" +
       "F5avVMijVExgpZBFuUihU3W1PHkkOr4QTq61Y77LdfWzf/6tN/Pf+mffLtCe" +
       "dH6OzzstB8/sVC1PHs3A8G8/veoHcmSCdvWXRx++x3n5+2BECYyoAhsXjUNg" +
       "S7ITWrLf+tbb/t0//8O3ffSrt5Qu46U7HF/WcLlYcKXbgabrkQnsVxb8nQ/t" +
       "tDm9BpJ7CqqlG8jvFOSB4td9AOBTN7c1eO67HC3XB/7n2FE++df/4wYhFFbm" +
       "jC37VH8JeukLDyIf/EbR/2i5573fmd1omIGfd9S39hvuf7/8rqv/8nLpNql0" +
       "j7rvRPKyk+SLSAKOU3TgWQJH80T9SSdot+M/c2jOHjptao7d9rShOdoQQD5v" +
       "nefvOGVbHsil/Ay43rNvW95z2rZcAqv1Sr5l5D8/VHR8rEifyJP3FDNzS559" +
       "L1jVUeGwxgCI5clOca+nACOwvVzHhxR2HZuz2Gg2HI+KEd4KvPVCeXKuezuH" +
       "b2fK8hTOk+5OAZo3VZZnDqncdWAa37tP5b03UCkVGepsEoDn7UHox0DgunYA" +
       "/TZAHPf3DwAA79OvbV8FhPNep8jQFySTE3hqn8xTNyHD34RMnmUOWNyrJiHY" +
       "kOKBH1rbrgOOCOcvJSa0XLAXrPe9V+jZ+16xv/A3v7nzTE+vm1ON9U8//zN/" +
       "u/eZ5y8fOw88foNLfrzP7kxQYH1zATi3RI+dd5eiB/4fv/zs7//DZ5/bobrv" +
       "pHeLgcPbb/7r//2ne5//qz85wz26xbphcoQLTk6+UN63Pznvu8nk6K9lcu7Z" +
       "nxwe+BLF3OTlHzmFznjt6Iol/QS43r+P7v03LunDzb1YeUPg+C308L6//ntf" +
       "/N4nnmtfzveoW9e5NQKCPbZCR0l+/PzUS597+E3P/9XPFvv5ARvnPMOQJ1ie" +
       "4Aecb2Gw0Vk03QvSfDe4nt6n+fQZNPOMB4ov55n1xTDe2ptys8FZKNMLosyN" +
       "0t4+yr1zUBZIfupiKK/g4xF7FsiPXRBkbmCgfZDQOSCv5JlPXQzktRFHUddv" +
       "MufPXRBoGVyVfaCVc4Demmc+czGgdxRAbzrxP3dBqLkBr+5DrZ4D9WqeeeFi" +
       "UG9juhTGsthZOH/xhxBpbR9n7Ryct+WZFy8o0nGPuN4bsnSXOQvqr/wQUOF9" +
       "qPA5UK/lmV/7IaBOsT7wT86C+usX3CHyXaGxD7VxA9TdDvGl17JD3Lm/Q8yA" +
       "D60feCL11+yJTHXVD7Wi8ylGX76g8HOBN/cZNW/C6HfPZlRYYAa4WAVKC7A5" +
       "YPcmZarLGnD9ANSi148VFTto14GiK77v6LJ3CvvvXRD7B8DV2sfeugn2f3Ee" +
       "9jz5/QPQtyuJARxWff8/CjAf7yj2Scvf6yVGfvwHR4kgiXdtTkH/w1eFvpNA" +
       "7nrfWttr7VXy31+5mDK/femoTxwcnoFvEYGzzxNLp5VXD04Beuo1AwKOw11H" +
       "DgHle4tnfvY/fPZPf+7xV4DXQBx4DXlrH2gx8wJ2z4fyH1+7GPYHc+yz4r80" +
       "So5iujiR61oO/ywNueL4NxwcXjul+C3MoB4NuwcfmpeRRpfLpl4Cs+tkmYwy" +
       "lV4s10MO7Qn4vEeztjGqaBpM1jupCWNobbgpZ1GrA3dbdJpW4AQWe0jmr8hA" +
       "wJQsVGekTJK4aHGZ0hC4mcZucHHD+4hiDav8qor4sV8z2w2j3JJgyZVgVei0" +
       "kNmqsSrDiVdOIAhqtiBoChmRXtfpCEs3WQOpBL2pKaTV1VRZZbBVk3C7VlsR" +
       "hNNRKSUZbB2yYyRjhpzb7BoNyBWz7NUmYbchRa6lTGLBrnKaSxIhTmA1lwdH" +
       "35nM+qOVg2+5PkEqoTDdiCveW8tcj5fEabVpu+RAk4bSsEw7mZ06ttCvwNNm" +
       "1+btbGvXODUbxW1P85fEYBq5jUibuG7D7Ff00SpVOittWyPseX/DjhATpyvZ" +
       "1N8OcNGvSnYjs5vjUDAc3sOkwLE5eKWaybCqDJwei9KJAiVppZwMzOVAlBYL" +
       "WQrHyXAp9N0waFq9UWZbGpAcHwhOiLTcIU+zQxLreFMzsLar6dRFJ6S9DTdJ" +
       "WOuWtzi3aU4VDamP1Yq8ot2pbRGDZTtVMwIfkbX2qKI2GqbZC9xNu0lMtFAa" +
       "C67WMGRCH1WJilaB5yiaBJlghz7EkbzPRBaNYmnqNiejrswGPVaOAldmCWZJ" +
       "6It0vvZl0Vqpfk1vzUNK5g27uujzNNLr8R0X7YebMV+LRITvjZb0ku7AtCUZ" +
       "1sydQ/0AnwXz5gTIPFw1kBTVyuiC4ki6L7vEqNtxm9NN1Bw6ybTlcOWpraCL" +
       "+XjRCzRptemyFZiXOTedxDOqOsUchS3L3bbvdURmzhm+Pxy61ZbQnUzxcNIY" +
       "wjOoUtlGC85odZLKZNaZesOFPZxNLaORGMhUDGS3zBtktN0mWlDtVH1FIpEG" +
       "PWkTGzvyw/YyJS2XbVojdoqzk7A16SHjuWm15kFYqZP1dKj1Gv6qvG0yDNVq" +
       "ZXBnRUq9rM4assg3NSABbOrggQETkah7o+amPo74DSaPfD4iKa+pNwabuaZF" +
       "8ZK3UYqu2fBwKfYHmIw2t40KZM/hCmMgASNrztBp1nwXnfuVeayw5oqYtbPN" +
       "iuNH1mjkjKfOMK6B9VGr2NVqf0xOo7kSOizprzYaT4ZtXpqPjXSEkdMFMpRX" +
       "eLIiHY3Ukll/06226P5QnsiD5VD2PAeDmAG07G9GaGIG/YC3ZzxdYbQgbloL" +
       "iLIseKzNEN0kZJStyV0GNtYDk5CwOVdZ0i7Zn3IjKFli7hLv9oQRJ0ikawno" +
       "jCWXk7LDOWNPEAflCjnBWxOCkuJtKCeWkGxNnJvoDDSe24It2SneDXu+DcNu" +
       "mvJaHK3motCrr6mEHTChDhm4l6ErC18Ps2A2rdQR1Bp3F+nSHSa9DFsM6WFj" +
       "05ttuhhhGkss22DexBktPFZHswnCMvOgt21pc6WTVoOU4Ko9a2VicyRc09Qc" +
       "tyi56qtGhsw7WVVVyzMpqIVrRKJTgWhjCYrOl1vWLk8HZs+uaoFtpxKG6ZnS" +
       "X1WErsEFE0ZN0L4vwaEWbOmygTR7Zpb28EWVGHf6i0ZT8SN8jfmrkQAbjX4G" +
       "JWu42WqZqwGDQ8uEXiAzoLkqtKVaPbVMWWWVYisTA+61Jg2TW1gYWm9XF6nW" +
       "TbZrlrEFrdU3K61lSHELuhvAXEaRS7GRhbqASsumzST9ZqdTpxCR5LlptY0O" +
       "hnO1KzGqFJuNRlndOIPKGhO0aR2GKyPJbwMLIqBVuCePtJYQVpsTrryGl1nS" +
       "CEN47bXXvBrL6ADuD9mRi0rdQCT4hTpZM7OMUtuG4XprtYbPB1O33sRSxA8q" +
       "kVMW6lS5u+7RkFcme3w6NRDgP8A1REq0qNXvs8utQahwNBBXyiDglr5c7VuW" +
       "YTukbWJBRsGZPKpBRLfWMUZcPYrTYD3oVyWNmfRgRjPkjThn4EHPlpy2SyA0" +
       "HCv4tlxxWWaBaeWJW2nMakMTkjwVGidjZ9pkpbTnIl1K4JQGK/Mqmg7n7Z4z" +
       "GEY+1TCaNbuF+9Fg0/SW5dGawKbzQaOZGPpAYcAGaOj1ztY1q3Nd08uTJSab" +
       "U2HIixQlZUhro6CbGrskU49I8YGltJZqfbWZrrqpJGrNUZqySzhFuK3S6zCk" +
       "2CdjyhzRAisxjr7Vh83AKDOVpb0V9RBBzZFDhk2H3LD6UFn6KcbKhtAllkw4" +
       "GAg1kWT8qe9nHtaedXEEYVZRPVpL7lIU5/VevG6E7XZnBK3HqhP6PNKSpay9" +
       "9KnJtgkp+jRLWkkMw63MiVWd8YhBbKBNpE7ErthJNl65WaUnTgg3uKhHqZYp" +
       "ELPBtmJoeCeuNOKxQcdsUpax5kx3N3BlXOulcy1gW7YDYUSD7ahqutLry3pt" +
       "0po6dW819dTNvDLBq8G43s0yDW+0DD/1ukHY9yhXbS01x3O9jhltq1oV6Jaz" +
       "MOqdcZNULHJpIKrYX2vIvBkj9QGxwmaMhXbmqko01mg6tRpMfeJIC23aF3F/" +
       "PainqcixU2ILfNO66m8SdVIZonK9NjAVvZlWYS/QlVrssXA8Jza60fXtKb8F" +
       "hgIhkbmLV4B17k2VRFyh+ERsxNvlMKtqsUyMLNrDI5PS+3yscnZvSfT7K3Yk" +
       "4lJYARPkZhRC890xpigrjRTxidXqqN0u6Q8Jnql7vDPztxFF9SQh6y7anGjS" +
       "U8XDJ74wpSsLLGqKdQyWyLjKxUshsPFGJpY9qRqYQqc2WdiJX3PYST2xsVZz" +
       "1IaaqiUw1elaKNtYh+aHU7qzDcWGZ4TMqsOacIByQGRcE0kqhB6EtOGX0YFv" +
       "4GI4kwlx0182Gb+zDlG3BgxDtdWztQ5SRkN2riRrCCE2VaFl1rGpNWqpixii" +
       "ZtaYHWcdOAsExcT7tXWrA5VrjU60rmYpL5WNIJwiuNdaz7edFu1Ry029Pbfm" +
       "dIjja6fSXw1UaxAQKCROVrMVoWid9Xi8mVQrk0lLYF1/4yq0N+m4szIluzV6" +
       "YTNlt0U2R/5c2C5oYrogKHZGh1gHCliqirdhfOJEKJ4qfqvWI6BJzeolsdUs" +
       "t4HLJDTKCdFa122pvB7SaoORu3Tb0tsBbs7EKl7GM78jjnWOg0Z6bKzn8NqW" +
       "anMPGO9Jf44NBz4q9JtMW1/T9bHXl4wkcbf4qtNeG/VynXMyegDzLeCnMNMF" +
       "B3w6MVIzRPBZDzhTWyyiLJ+1IC8FpsAT+BRDmsDzGGlmOE7BKbbX4+pdWHaa" +
       "29jVeJrvJyROc51eOtUbjSHCY/Vk2xZjy8zbeWAqVi2k4m7YXHeIGtMPGGxT" +
       "MWczHsxCs0ZgOEvjFJuwomClul9Dqs7Mo2cMYihco6pOAn8qUM6yNhpirIoP" +
       "KUl1ORqqORaQbxI5HXdKzSKTNSW+kzZET+6uhny4UsRVrbOWYdykHGDi4621" +
       "hFlyJmArVSG7bVog3AUpEJukEc+zxlrRlyuwWNZUWzSXG4riPKEaIJ65ihh0" +
       "Guki6UZjXqrA/tikl3hj4NbZsQ78nn6D0bxN13MxFa5VggE98l3JjsdVVd8g" +
       "nQBr+Uk5o8xWI1yRG2XGtSIMIjPaVEccu+WlNcN1kQE0H2ziBG83BykBbVcc" +
       "UjGnUigjWX/q8gI2doj+JB52y169OYxwl6b18WoCVzlPw2uOnchMjUG85qRs" +
       "oWAPS6deGlKoNO9h3ZRLnCGNWsmM3PTSCmkj3IbkltJqUOWQfgQtRXVrmY1g" +
       "u2KBn1LfKBZg2ysbxlCjNoQ6mtFQPfYIqTHo8ARjTrI5LU/YruhleCVuY2hb" +
       "qc1boybbooLtTFuU+5XVkkuWfTHgxlzMbXmkwjShyqCfwe1ppHYIfpm1iD6J" +
       "N8sSHYbpuqcNXNNJ3TBKx4SXsRDqE0ZZrnlrN6XFDeoRXllnYRR24KzVGmwb" +
       "9nqeMa5TpSyOpBa0lRgrFIMMeVEl1UQUvBZCIzosxqOMYHtNJSTmIe2uV3JT" +
       "6BHucohTemULOyug7LVBe+hwUQdsq9ZmGJcZfTDytrVyZAQNW8R4FhiGUXW1" +
       "nq+X2BKaQeuMr2mIwFNlIuJGioGwCm5U5JpBcnNy4bAzQ2FldOzzYiciFyKK" +
       "dGYrdLZyw9W8Z6IuPGag1mzeV7bgYCcuoJVebsplaDZm5iOjLuvySPTxWtqb" +
       "QcgQtntNWYNUzUjWEs0ySb2ldh3FChJCaYS1OnCOlS3lbBtWzJtt3qvJqNyi" +
       "wz5f0Yf9ZINmDUeSUCSiFde0EXHcmg0nfQMN+itntuqIsZKq1WGfVdS2OkY2" +
       "aH+DdTZqxM15gMFr2i1FFeu9rVOjJ7VRxsbgDgxFwF0YJhJjEDfUNlGWwfqd" +
       "y4Hbzbr8cNM37JkYsD7jV9cwRXd67TaOBviAgWrtstcnbEGxNnAHrcU4I8xj" +
       "uRlBJi3By+GklllDcj1XylyzPdMqE22gtqRGUCZVuY6bohbyopR44GAfCxkS" +
       "sHCXmREdcDzUhUlXrlLojLENbExbEV8jE6G+Ubv+2lenjDNCsMyHlhhqb5lG" +
       "v7YNRsCfZXtoUBG7jXAySeE2cJY5zWkzWsRDhJNtUrADp02s0URHa+A0AZ4W" +
       "ynZrOi8h+HamVrZEH+/ZzcaMrzHTEVhiaZvXhQU4UcKjniRiadcNxB4iQMOV" +
       "5o1JqlPVxrKYlY0uBY6Myazs2BHfUrdbBkrClOnPUHVltpnhaGgIJqcuW6mG" +
       "sFxzQc6jimDCJuWH6tgi025HwdfxIiY6WxKlU0uiwfFFsc1KMmhMFpWEIBuL" +
       "Mb5pbbJer05QIxnlFkM9XMnDVQYslSwK3EZi8LQlmC44mWaTWn0Oi+WWgrWy" +
       "Nh6ixjaV/XgyDSKr0bLp/sIZjslsEVFDYRht2CowBL26VCUE22q7rtiWbHKp" +
       "mJbGerGLGE69Q2B9m7AVfS6Pkt50qiyaNDgH15jACltVFxPWWVMKIiwwaZGq" +
       "zzuKjswmIxhd2zOh0R/QMDzvIsNmDRmnPc6pMHYZj8s4jE9JYiEQ40130IjJ" +
       "dS9YSEMcrD++ypfVLmZPJFkwI9EZ98hq");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("h9K5Lkm4LaRu2sDf3aDTBm1YtTWZdWkhpKA0RdEy7uJU2pXX9SZOlpVKR9vq" +
       "k44Mtd2KSXlpezmleZLdrKxVp6noQCE3LBHMxgS5zEDjdWVBwZNmucNFms/1" +
       "1a1RXg5IDBwAhq1hH4MQoGsSt/HW2BSmWTLu9bBlrNcZqgNrwBkvj12EhCCj" +
       "VkvVZcJUFtUM45WG0Ul7fCXVw850jeoY4VAtmx0IgrhpC0uqhdqYGyRzzyAY" +
       "p1G1mQ1dnvstqgzpUSvcpmueWeNEp7aRVxVlmozphT+bGVivP21zy+psjGbb" +
       "UV+OV1WRYLK4DqlBY8sTKCxL7nzUBI5PnwETa7KG1m4Kk1qDbTR1GF43JxUo" +
       "Xnm+gCVGlUBmPalaNco4TlQjS5RGSlOg+opIW5WyoIlLRVgr863rZxrSUTxq" +
       "ukjWGRdPsjEfDuBVNq5x4qhuEJuBuJnE/dmITiAddxv8ZMQywtKdz7I5Ycxo" +
       "JwKTVab69gjx1No0mtCGDSfE3KhvaVLJlmAOZ5Gj8GZzKS1JZkn3R22z2pVS" +
       "CKmp7gxG0DI5G46TTKA108UhFDe2bL3ZFuddGOouyzTTBh460pWCdtrtdj+Q" +
       "/7X4Fxf7y/Pe4u/awzDZH+KP2l3VY3ny5OFf38XnaunmsWNFywf2o22isPTw" +
       "zaJfi2fuX/zk8y9q41+tXt6PS/po/oe+Hzzt6GvdOTbUHWCk9908voAugn+P" +
       "4mX+6JP/+UH2g+ZHLxAR+MgpnKeH/Ef0S3/Sf7f685dLtxxGz9wQlnyy0zMn" +
       "Y2buCPU4CT32ROTMw4eSfSiXWP6Yvbsv2e7phwpHc3fu852i7ijs65admgAB" +
       "PnlzARZxZbt4ixd/7fE/+9iLj//7IjTrGtis5LAbLs6IYz7W51svvfKNr735" +
       "4S8VoYxXFDnaMTwdAH5jfPeJsO0C/p0nBfIo4PZPd/LYfcel1RsaSKuElrbQ" +
       "oR7APFNDK4gtb4F5ayv0PVf34oPo3f/3N83OfDKhbGL9cGov7YfMHj5++N7B" +
       "g6cfnPPg6b0n7MRVR/cWu+Dp4vnkd4PscPzLu04HT6TuP3pQgzi+p+chjQd1" +
       "bzl4WnX4/gCozM5E+o0d0uJmefL4KYU9Fqd46Y5z6u7Mk2tx6VY1B7PDfk7z" +
       "u7PSIcmPFHf/zjmt780L/2tcurbQ46ErLw6JPlQQldN4z8qLj57OHTYqDOt/" +
       "e7XHRcdvuBPLjeET9L4loN8YS3DpqMF3C5IPnyOAR/LkAbCPHAgAtYBqRgdG" +
       "FEjivkNJnKzK+V/6kdfB/9ASfnif/4f/L/Evn8P/6Tx59zEFyH/ff0TwPa+D" +
       "YBHe9UFwfXWf4FffWFN/Yr3mE9QP5cC01KiGrg6cgGnBsnWOBHKLcqkGljaQ" +
       "AGLKeVi/Hg5jvQjCPrjHk8U98teJ9rpxHFpKEuva2a0LscFvhNi+vi+2r78x" +
       "YrtSNMjjkC61j+RzaCcu9c8R0jBPejcRUl73gSPuyOvg/khemIfSvLLP/ZU3" +
       "VGVOcS+ozc6hzeXJCKgYoH0077uI2wPVePAs1TjWpJDJ+HXI5E15YR5r/J19" +
       "mXznojJ576vZid8u2MrnSELNkw/HpbsiPT4WGHPm5r32Le2I+o+/DuoP5oV5" +
       "NNgP9qn/4I2hfpzZeZtpodo2YL04wboQ2RFD53UwvC8vfAcAe3nXd/f9Rip8" +
       "6beLJX6grsfiUndR8gXRnzxHCB/PkxScWGRN23U5GrDgn71e/g8DKlf3+V99" +
       "Y/gfGbt9/jnQZ4+M3c+cQ/jv5slPx+BEdUC4e5rypy5COQNOxI1vjOWvvDxw" +
       "w5utu7cx1S+9ePe1t7/I/ZvdSePgjcnbqdI1I3Gc428oHMtfDULdsApx3L57" +
       "XyEo+PwC2L9eU9QbcDKL75zBpZ/fdX4BnP9epXMMtM01jnf6pbj0jnM6xeBk" +
       "evjjeL8vAP083Q+AKr6Pt/sVMMJRO+Dd7zLHm/x9gAo0ybP/ICgmP9v55Q8c" +
       "V8TCib3v1Sbz2Dn/8ROHy+L95YOTdLJ7g/m6+uUXidFPfLv5q7s3x1RH3m7z" +
       "Ua6Bc+DuJbZi0Pw0/thNRzsY6+rgqe/f9Vu3P3nwz8FdO8BHi+IYtkfOfjUL" +
       "c4O4eJlq+3tv/yc/+usv/mURgf5/AKhg/AxYPgAA");
}
