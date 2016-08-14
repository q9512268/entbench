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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "8RuCkcquiyORfh8Vu71Eac6Eb7k91PIi0ozBzJ2jlsZvCEaquDS+enZXifKg" +
       "p15hD7aiiDwVmLl/1PL4DQFxSrQ50tbb21ZImMOjmJyV9kgriwgzFjMPj1oY" +
       "vyFgcrpbNvS3dPR2NkcLyfPIKOQ5yx7srCLyVGLmyKjl8RvClmdj2zoIjgvJ" +
       "82SJzhVd4ip7sFV58gjn+lxR5+pHzch427n2wDaTZoLes7900LuRyroZ58Qe" +
       "IX9d4qQhiufYbJ7jI+RLheeK+6XNEPJzLhWQpsBs+fXNSHVsI5XisF8BeTgd" +
       "37iERB9bXHkNll1M11Uqad54DX8ybxD1cokQnA/fapvN1T4QvFMMAkxeLSC7" +
       "X6cAWSyVgM0atY8MYe5n8XBG0UMtqQSexsFe20gx0cYj37tF5Ev7bMz4snJY" +
       "5H8VxP9wxXUGQTAUr/e7++Bh+MFr9x6Id9+5ImifEemoFLqxTKVDVHV1VYU9" +
       "5RxndPLbHuds4K0JN/3h0YaBllLOirFszklOg/H3XIgal/hveLysPHPtX2b2" +
       "XjB4ZQnHvnM9KHm7/EnnoefWLZZvCvKrLXFokXcllkvUlLvJqDIpS5la7rZi" +
       "YXZeZ+N8YYzdbM9rs1efHV3yM1p+pLylcyZYJux17g11dnPKTxvF3umy6qd/" +
       "ad3xxwfFHq3Q1tdzJ3bP3ZXym8mn389o02CuePNAnR8TLIr/jMj/4wVNzFTi" +
       "AzTcAkrVI5uKwcAqtWlDiqlrSeTXvgf6KobBxbbIX0lduB64a+GLVx9Y+C4/" +
       "46xULFB7WCUF7ildNB8dOnb8pZr6+/nyKsdFxLXIe8Gbf3+bcy3LZ6UWky/S" +
       "J7Pc5bERRgub7bzNN7fNolthdgPVRczuMhEg8OEYqVCpNiDuDtFeBsoNp/+g" +
       "IMqY2snOzrFV1TWK5+uZuikZM5y9PofKwpz+XXDKB3MW1HHOj2etuM7PAzOK" +
       "1M3EZCpszGTkS4hRpHl9XilfqS2G62A6z1HyqEjh2c+K9D0fCz+B7cgAZR1J" +
       "aSCL0GyOkDTMQgoWO/4q24g7qU9P5oSLn5oLOQTO+Ru0TttEdZZu3fxIPVC4" +
       "YPuc41FsSpdj0sjIpAxWaxVYz1bGVwBodVnQcqsQqsCSUwBV1hFcZst7WelQ" +
       "+ZGeDKrzi0D1NUzWuNQKfy90sDj3FGDBj7YugO+oLdDR0rHwI/VxijmWBqd9" +
       "nSkZg4psreT2rQeTKzggG4qAhbuYQBsYJQCrdVDCu3pqdjDK7zIzYyziY+A7" +
       "oFD2VVa8cGuOcPupRPh1G6bXS0fYj9SDTzlnBE9fAhc5UGZtWmBzETwvx2ST" +
       "D55YF3VguuQUwDQX63AbfsyW9VjpMPmRFlZED0wchcEiCKHzxjvlyYCQo03i" +
       "WimjcDMLKZyrCYcvfgrgq8Y6vI372Mbg45PAdzwXvqoipP427UUOzHAR0EYw" +
       "MRmZYFHm2pgXjIaGdCXuoGSdApRmYh2ek31ui/p56Sj5kRYBYVeRuuswuRYA" +
       "GsgBiKPrgPGtUwBGHdbNgpkMij7F/5JWnC+p74ojL3JzlFkvrosKcWHNMdlb" +
       "BK/9mHwP9tBSPC5InA45VHtOFVT1IGeFLW9F6VD5kfracBsqlGnftqwNv6MI" +
       "NndicoDBhjyDTbMXnR/9P9BJQ9CW/0AOX3PMyHusKx6YyvcfqK2cfuDi18Tm" +
       "KvMIdHyEVCZSqup+b+DKVxgmTYhwfLx4fcAvBQP3gWf/UseBsFvg/1GQwCFB" +
       "/AAjc09CzEBhkwk30U8ZmVWEiJEq54eb7ueg4l46YIr/d7d7FHpw2sGOTWTc" +
       "TR4DrqAJZh83/NeP2H/Ncs8g33NMPdnEuw60Fubssfkz7cyxREo81O6XDx/Y" +
       "0HXViXPuFM/VZFXavh17qYbtsHgUxzvFg5/5vr1l+qpY3/jZhAfGLcocauQ8" +
       "l3PzxtUP1hB/WjbT837Lasg+43rj4HlP/GZ3xUuw/d9MAhL47M35T2PSRsok" +
       "9Zsj+XfamySTPyxravzhyAVLE397M3ttmvvkyNu+X37l7stfvmnGwTlBUt1B" +
       "xihanKb5m521IxoY9yGzj9QoVlsaWIReYA+dc2E+AZeFhLECx8WGsyZbiu8Y" +
       "GVmQ/1Yg//VnlaoPU7NFT2lx7KYmQqqdEjEznrOzlGF4CJwSeyoxtYTPxtkA" +
       "feyPdBpG5hFg9VsGtw95Dwd4Idfh3/Is5o7+F+e4crTCMQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zz1nme/t/279+O41turhPHTmwncZR8lERJlOAmCymR" +
       "EiWSokSKktg0fyjexat4kUi2bi5A46wd0qB10hRI3WFL261Ik25d0QJdh2zF" +
       "1hYpCiQotmxA66wYsG5ZtgTBkmHZ0h1S+q7/93/2F3sVwKOjc+PzvOc973mP" +
       "+PLz3yzdEQalsu/ZqW570YGaRAcru3EQpb4aHgyoBisFoap0bCkMeVB2Q37r" +
       "b9333e9/0rj/aumaWHqN5LpeJEWm54YTNfTsjapQpfuOS3FbdcKodD+1kjYS" +
       "FEemDVFmGD1NlV51omtUeoI6hAABCBCAABUQIPS4Fej0atWNnU7eQ3KjcF36" +
       "qdIVqnTNl3N4UektpwfxpUBy9sOwBQMwwvX8twBIFZ2ToPTYEfcd55sIf6oM" +
       "PfeLH7j/n95Wuk8s3We6XA5HBiAicBOxdI+jOks1CFFFURWx9ICrqgqnBqZk" +
       "m1mBWyw9GJq6K0VxoB4JKS+MfTUo7nksuXvknFsQy5EXHNHTTNVWDn/dodmS" +
       "Dri+/pjrjiGRlwOCd5sAWKBJsnrY5XbLdJWo9OjZHkccnxiCBqDrnY4aGd7R" +
       "rW53JVBQenA3d7bk6hAXBaarg6Z3eDG4S1R6+JaD5rL2JdmSdPVGVHrobDt2" +
       "VwVa3VUIIu8SlV53tlkxEpilh8/M0on5+Sbzo5/4CbfvXi0wK6ps5/ivg05v" +
       "PtNpompqoLqyuut4zzupT0uv/4OPXy2VQOPXnWm8a/O7P/nt973rzV/6412b" +
       "N57TZrRcqXJ0Q/7c8t6vvKnzVPu2HMZ13wvNfPJPMS/Un93XPJ34YOW9/mjE" +
       "vPLgsPJLk3+z+PBvqN+4WrqbLF2TPTt2gB49IHuOb9pq0FNdNZAiVSFLd6mu" +
       "0inqydKdIE+ZrrorHWlaqEZk6Xa7KLrmFb+BiDQwRC6iO0HedDXvMO9LkVHk" +
       "E79UKt0JrtI94HqytPsU31HJggzPUSFJllzT9SA28HL+IaS60RLI1oCWQOst" +
       "KPTiAKgg5AU6JAE9MNR9RRRIbih7ihpAW0eDIi/c6BC6BFovydGMJlipUOCD" +
       "XOn8v93bJTn7+7dXroCJedNZs2CDFdX3bDDQDfm5GMO//YUbX756tEz2cotK" +
       "LYDgYIfgoEBwcIzgACA4KBAc3IygdOVKcePX5kh22gDm0gJWAdjLe57ifnzw" +
       "wY+/9Taghv72djAReVPo1ma7c2xHyMJaykCZS1/6zPYjwocqV0tXT9vfHD0o" +
       "ujvvzuZW88g6PnF23Z037n3P/vV3v/jpZ7zjFXjKoO8Nw80984X91rNyDjxZ" +
       "VYCpPB7+nY9Jv3PjD5554mrpdmAtgIWMgMRy4/Pms/c4tcCfPjSWOZc7AGHN" +
       "CxzJzqsOLdzdkRF42+OSQgHuLfIPABk/Vtonp5ZAXvsaP09fu1OYfNLOsCiM" +
       "8Xs4/5e/9mf/BS7EfWi37zuxE3Jq9PQJW5EPdl9hFR441gE+UFXQ7i8+w/7C" +
       "p7757I8VCgBaPH7eDZ/I0w6wEWAKgZh/+o/X//6Fv/zcn189VpoIbJbx0jbl" +
       "ZEfyb8DnCrh+kF85ubxgt84f7OyNzWNH1sbP7/y2Y2zA7thgMeYa9MTUdTzF" +
       "1Expaau5xv6f+56s/s5/+8T9O52wQcmhSr3rxQc4Lv8RrPThL3/ge28uhrki" +
       "5/vesfyOm+2M6WuOR0aDQEpzHMlHvvrIL/2R9MvALANTGJqZWli3UiGPUjGB" +
       "lUIW5SKFztTV8uTR8ORCOL3WTvgnN+RP/vm3Xi186198u0B72sE5Oe+05D+9" +
       "U7U8eSwBw7/h7KrvS6EB2tW/xLz/fvtL3wcjimBEGdi4cBQAW5Kc0pJ96zvu" +
       "/A//8g9f/8Gv3Fa6SpTutj1JIaRiwZXuApquhgawX4n/d9630+btdZDcX1At" +
       "3UR+pyAPFb8eBACfurWtIXL/5Hi5PvS/R/byo3/1v24SQmFlztmWz/QXoc9/" +
       "9uHOe79R9D9e7nnvNyc3G2bgyx33rf2G8z+vvvXav75aulMs3S/vHUVBsuN8" +
       "EYnAOQoPvUfgTJ6qP+3o7Hb1p4/M2ZvOmpoTtz1raI43BJDPW+f5u8/Ylody" +
       "KT8Nrrfvbcvbz9qWK2C13p5vGfnP9xUd31KkT+TJ24uZuS3PvgOs6rBwSiMA" +
       "xHQlu7jXU4AR2F5uECSF38DnPM5w5IgpRngd8MgL5cm5Huycup0py1M4T9Cd" +
       "AjRvqSxPH1G599A0vmNP5R03USkVGep8EoDnXX7gRUDgqnII/U5AnPD2Tj7A" +
       "++6Xtq8CwnmvM2ToS5LJCTy1J/PULcgItyCTZ9lDFg/IcQA2pKjvBWaG2uAY" +
       "cPFSYgPTAXvBZu+hQs88+IL12b/+zZ33eXbdnGmsfvy5n/mbg088d/WEz//4" +
       "TW73yT47v7/A+uoCcG6J3nLRXYoexH/+4jO//4+eeXaH6sHTHiwODmi/+W//" +
       "758efObrf3KOe3SbedPkzC45OflCeed+ct55i8lRX8rk3L+fHAH4EsXc5OUf" +
       "OINOe+noiiX9BLjetUf3rpuX9NHmXqw8Ejh+uho8+Fd//3Pf+8izrav5HnXH" +
       "JrdGQLAnVigT50fMj33+U4+86rmv/2yxnx+ysS8yDHmC5wlxyPk2FmfOo+lc" +
       "kubbwPXuPc13n0Mzz7ig+Gqe2VwO4x3YZMr1z0O5vSTK3Cgd7FEeXICyQPJT" +
       "l0N5OzFi+PNAfuiSIHMDA+1BQheAvD3PfOxyIK8zU4q6cYs5f/aSQMvgquyB" +
       "Vi4Aekee+cTlgN5dAL3lxP/cJaHmBry6h1q9AOq1PPPpy0G9k0UpnOfx83D+" +
       "4g8h0toeZ+0CnHfmmecvKdIRNriBkTyNsudB/ZUfAiq8hwpfAPV6nvm1HwLq" +
       "BO8B/+Q8qL9+yR0i3xUae6iNm6DudogvvJQd4p79DsEBH1o99ETqL9kTmaiy" +
       "FyhF5zOMvnhJ4ecCb+4ZNW/B6HfPZ1RYYBa4WAVKE7A5ZPeq5USVFOD6AahF" +
       "rx8rKnbQbgBFX3qerUruGey/d0ns7wEXsseO3AL7v7oIe578/iHou5axBhxW" +
       "df8fBZiPNxb7pOkdYLGWH//BUcKPo12bM9D/8EWh7ySQu9531A6Qg0r++8uX" +
       "U+Y3rGz5icPDM/AtQnD2eWJlI3l1/wygp14yIOA43HvsEFCeqz/9s//pk3/6" +
       "c4+/ALyGwaHXkLf2gBYLf/efIF/Pf3z1ctgfzrFzxX9plBRGdHEiV5Uc/nka" +
       "crvt3XRweOmUotc+16+HJHr4oapSd45Nq5NZOd5axoCcoGVsSm62OLM1m3oH" +
       "R6aON8Z1P7KMClcZL6obuN1g+kHSRqC+Cs+4rr9YK0TE+f7YH44qHkJCyHQ8" +
       "J8KA9wWzzE7d2loBx1Ft5PmSj8xsfi2MIoFZIrwLbyIYbse1cjKtUc7cgpVy" +
       "ud1oN7KNu4lHqlbus+vxiiJoIJQ1RU963d6aqK3GM3uaUokdCely0PSkRNsE" +
       "Al3emMMuEoy64nDIrgbGlCKbouyYyNgX6tWFthbkillxJH5YibmYIXF+5k/k" +
       "imFyTrNqqc7QFvsVGxVms56i+ompV2pcj+vxA1qkB6JoRjQb64N+s9NHuYaf" +
       "4g4CC/wET+eRxOCS1ugSWibYMhNZ2+ai6tA8mYTWQrJkEhBfmeZsuPWXIpl1" +
       "hYrSE7AqsR74RLQ2g4A0ahgm2mMN03VlzUJ2mJUxvBsSFqcwlSScZYw9oIS6" +
       "4rH4YO0qZM3mpGipcku/k3TWdo3pzRxSRBfMtokZve54FSj0MB6WjZkZiGuX" +
       "SWZDye1YTM8wTNFtxwNStLlKXHdS1+n1zbVI8aGLOa4rSlNhGkuDeATRLaax" +
       "DBqr+gJzfIQbVc1I6iL0CsVIBivr2Njxkkmlth4lNae1qmTcghog66FNrgNK" +
       "cWOrySXueDCQOk0ZQnVv6usNv8WjcuDg6jibZgO+q2Z1c1YfRw6UmJOpNMYs" +
       "V12SQ3MSJjA5DnEPS8IUx/q+azUmG2E5rpPwqE0QlthLmx3MQpuM5YreoK6s" +
       "7ZT3yO60MxEmg1lFh9HR2t9W0UqGN4fD7iDFM403iGDcGMKcPqr0szlXSevr" +
       "9borjNA6bq3QtKrEdHvLZQxDZ1wTaZSX3WCDxZtKJAbjCYm6MTMV/D4kmR2p" +
       "nvYlDmOnPoWOsFG/PhCJpd9zWGRb51Cv5qrGmmL0NlRvcQRXlmVVkCqOMNP5" +
       "uRJ2GoK4gbdbJu57CLPsya14vJr63SjhZAjLBmVuTdVWAiON6TCjJuGqqoup" +
       "PVZr2qpSbZYbdlJnrbU3mpr9QDK9gbqaDKr+qOfZg6yvzLwhj0tI2l2tMXHT" +
       "0KaK2Mkssu73JjMbJh1iUrX6Q0FoTD2N1VAC78RWh1ybnY2EWm0rky0mXGXS" +
       "gh7TxqJMG83yZMq3WlqZXqIVtmlZku1MBtNs3O53harNtIZ6azZAl1K3PjE8" +
       "SJG2vqTQU7q3XepNfKB0uuOZP6cJlqMwh7YwS+XNZYen1B4WUgytYE1uJs0V" +
       "SuwPJAQlhXGz3gwVyoM5PqmPsB4GFHbD6LoXSEEtHltauxU1phzQ4TIUa0S6" +
       "7qctvrcS8eoWJ0gZ65p9cix3LQodL4wMpwNXR8cdbYT6KemOMX9FBTNU2HZS" +
       "dllOGxo9EuJEneoTT9qWp1tcMYCNayCSK9CT1lJtt+J+s7auZXAbSQQGmxp1" +
       "Q+ExnbOpSS3jlmit2wcqVZsaLQ1taXaZbDeoTRlbhdBUnHj9VnnuTsqJOtxM" +
       "DckhG2SVkdkZ1+o1kVVItTdDOf/bawCpI9VZN+Q+x3fnotoZL1pdiZxb0+4c" +
       "nnldpc5PZ4bmRLCmdQd1Iao1SWSSsgQGLJU4qVspxXbWhqGqmusO2JFjQKEC" +
       "M/3uIqkTEzHrglUIuSqtkeHUZnpaPAptrrNFXYXHvbXgTLeBM+z6KyS0+x3F" +
       "XfADYdgrr3FSxQI7GFFQP2bhKgG1W4Qlp/WKsJ6rTchASMcuzztZvK6vxMCS" +
       "etyG45yKWoug9khs98uIlDHTyczchkwP7frrqh7OsBpKExsW2USrGbPpw1u7" +
       "OdS3aFtVTAvH7ZGU8qzVgXRqqy3q2swIQ5yQ3CCa1jRtlEYhhFoTGdmQuCDQ" +
       "eMXrk5X5MMV6YB1MFmufYDR2UwvnwXzlBZkyIphRNLbs3qwhqRt05ELUeCaH" +
       "cCbA26YBy7zF4NQI0hvZYuK75awC91Kpoq9SS0Ea002FdX0ixlIZMyKbi2wm" +
       "lrZuX4fQwZyeJTMa4cOsWl1nhChSdpXty2IsDW0wB+wwgYQlG3jmZCTX2sk2" +
       "zeCNK1KTATUhM5SkGQ9acAskStq+j62XfKXV7SqFvW6Lersr1qZqk/Jjr7+x" +
       "aCOudRez6TatSnBHXWxciRkqcZgsYAhqECwfrBJp4lGRjweCPzeRBJPl3liV" +
       "+HUVoynbrwN5dFbN3jDtiSmL6+p4ZRMqGmadSmtTqw50CBdrGkK2B2VFgVQs" +
       "Qmyptx6yMzEtE0EVXXlz21rWsnTUbqvafINskDIl0ybjrCpRbavGhgs1bXFV" +
       "RRA4Q5JGnZeiMZOZntqi+ogfiXFIJJnTXlTTcWz2FARx0XE3rgzLbQYyR3Vv" +
       "NJiP+WFtVUmnyNRogp3DkQkYHmsTT5QHgUmJWdOlV+NJP9/omEYt3SzmNNPM" +
       "hGAVqjhLLXsaWe1jNU0nuktMQdaR3lQQhUdRbD2WNS4owzQ6IKBRBRdHtoZR" +
       "FE2FdJeECQ9e9FYdU/KHUraFMcYRGlYPQ5dufwKpFdUKllBUiZq1wG+OELMx" +
       "YvVRja+mCD7ojDtkjejIYqXLLebmoj9qtedaJNi9gcPPahOrRtY0K51G9YZP" +
       "dSydXNS3CS9maMCMmpOgKZJRPaWx8WqpzEMIuFxRGSaN7rDTEbDmgEqrk4XD" +
       "uZWZFFWmmukM0IWFNFpbLfV6Mk8NJ8DwVuON0wpqojGtLZY2hm8XDss5ZDIc" +
       "OpbOuUxtsukSYi9oTGCmwmvEdoNEKIl7ETwFU6PBGi/ZhlrnmjCODz3Ya6Ux" +
       "itodSlQD1zMGnVHVxResUefUlldGFtUoLMc4tK0j05EbipV2Gwk225USE2p9" +
       "FPSrs4YJl2GKN0c1zUA2jWS6NIhRFRoF2YqAtLDWmdXX4UZJKR4Di7QsQFA2" +
       "dlbQqNUSzAFFEcRGqRDbfqj3I5tIPWOKBUEzai/xtjLjN/jUqFn0eurXqsMK" +
       "2WgEE1mU1qJOqTWFagr6bJaN6eFEH1AosUTahBxPeWYyHSUJI7UHfFNy0uY6" +
       "niPTBaGEmVLBaY6ZzzvJnEVTVus7vZgnIr1X9lmV57TeSFppXH2kxigrWyij" +
       "btQy1Md4WItnBlhEvTmNsx7m9NJ5TY2GddXtK1skWjchtdyqMzC5McXe0BUS" +
       "OUtFo7JIyGhBbtoxyhPmUqwSMmU6xjCZoZlGu/FUHM+2WzoZDdGG2dj4k06Z" +
       "hDHWNGyvMm83t5sB7TGDxbrDmoy1Sug1qftuuyxOzKLdSm/HzRi2hhzSqU7w" +
       "gNcX83ghY8QgXRFZranbrUncseR1bKajiWa0hBip4pLcxJeI1a6ypFnxMuB5" +
       "1FZ2KG46uLSOu1xZdcW5qQ11v9owuohkmt2t4FA2VGWpendMJBzwpirRclmr" +
       "iqRDj1bOIBXalh6YWz0jVjS7qnqLTUrocuAvmQ0HK+ykxlgylWosORyNG2mC" +
       "hEGHSoUe5aTDFcC46diOsqplHrnSN4NWjRtkhqDUTR8JCaHR0ldu2U4mjbLf" +
       "z2SjXkPc2rYr8aJHqSHSrlSoeJIGnthojVVy3lbq67FhxtpiOUBWZHlCge1x" +
       "WG7OGZwdZJQxG/shFpa1OcP1hZBszM2QaGEqryswYuITrL2c9y3Gtqt0tTpd" +
       "S0qj3p230mXSrcqeNXZRSJP8DVPl6+MNOJ6gVqJSXAeZN2V0xqWCTlekaNGi" +
       "F2rDbc2xXmVKR+sxpyYhodYqelKRFysYiYgGvkGWdFYP3cGi0W8JCdveJvNp" +
       "b8yj0wBSkXIZM8o0EbSTJqm0yw3SMTVcdTyCWif8UOgKfaEqLKbtxiRxFWAI" +
       "+7ES1oeVAQPBQOkkzLapkRkQYWbZIx3qw3NSl2zI2KhUGrJ9NprXlrX5CquL" +
       "Y7e/cen2sO8gEO66nqrNKBHowmYYUHPCs+aybVubqU1tBusu6XMNW0IC0VwA" +
       "b0UsM63FIlOWdDsIq6rWF+CUrvpln0ptORUXgzipInq1qoBtkU82BBznK1GB" +
       "JAVOkq1G9NfwuBop2QBesrA4T52W48KttlepdWKVZVB30uIpMoBW9AqqbwUm" +
       "I3gTzXgZtQKBbMTDrYyuo5ndNdd2wKn8fKNrzaG3xJLlkpxXbCXGmnWp3KOE" +
       "pL0od+pQvZlMKQJDZp0pgZi2wmAtZeQuW74YNMuQmw5DhUioOam2eksNLi/l" +
       "FKbE5nRmpRA3QFi5scQnEz1eIktwVEA0xrMjQ9FZYSJnMW3gemuEL9ZCx2fM" +
       "btyNCBULPcaHyjpJrxe10B1lASFU+dmwUY7F2LREupG2WU8Dp8OsPJ93hxhM" +
       "z6r9/mgFDEtMIyyajYZVGsbFjh9mPd7i6sbE79vtuWlra67Wa9bQZlbtp2t8" +
       "ZdTk8rDdrWgdcIBEZB0VJ9WBxHWoSi8dWV2eHuvebATV17W6jqynbbbhcZTb" +
       "8KjRmB+VJ3GFjyJcEcUY1hKSFTr1BRvL9SoRcr6yqoQr0keTmZQIi6y67Alb" +
       "zFMEdyyvw/E67HDTLSZUDUIWwwiZqfa4LPbU7jDIzEq3ykyzWcyMh1raroTd" +
       "FUz0utgKWcT6qOxRSndSCfpbEhISc+XMsLXSdjlL1Ot+GKh8LRir/DDT9V59" +
       "jRrLeDHGwsVg3AkUoduJYX+trLpDJCOzRZqZizKKeES3JghSS+7FI5mN/Qlr" +
       "VHvNJTjwaYtVm+vyme1ieFtDDbkx7YnRzMEynN9ukhrwvhuNBQELehyPp9vu" +
       "eN6E0aUWprO2sPJp1pkQtoh3K1vZkHGzM+xnyWpjp4vO2KvA5sx0VnKXpoZi" +
       "GnQW8kbTA33dWjQ3JIzU6KVeb7Cokm3nm7Vn+iwwX9PpKOujkwq+2NITR1wQ" +
       "fafm6/MVKfWUzjz2epyC+hNnYdRUC67GJuQ3mtyqYU0W2EJQJ3EcbuPJAu2F" +
       "OmYO2UBnexGYg15fWTK6b9HmCiGgxmDmdso+UvdWFDzIbMLaBF44lGd9cPay" +
       "l9gQajv9LduOMI7tNEgXrTeEfjQiBL5K");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("9lSCmrWJptBtWFogyVi4tnuuFq23zKZJk4yrmLLXxYxV2uWXNDjoQG22jQ3G" +
       "7c4MqqCjOczSaT8Oh0lzkW5kbT2syVrcNast3hluaFLpp7jQEbl17JeX5e5Q" +
       "SHSHXxhbjUrqmoxusDEL6zMNmoZgCREbHar2xtsOgUEoupIr7U6GY4a1teDK" +
       "tCWCszVuDvB1o64ukVjV63a9uQA2A3iBCNH3t7WwN+JnvMxP6t1gjQ5EowVD" +
       "jMrW+hAjhy0dhhmaVVw83jYrRLwMQ83KEDlNJrjXqo6a824CLSr9uWDO2Zig" +
       "IUEk5tLGqCLrxTIK+/o0yTaE3oAam6Bql9c+cM1XooFqPUr2ZCket2yYzZJo" +
       "ylYNDJqtlnwLRigp1Mt1OFjV+zYL9UQ4mcZbSGnTqEHVERpu8DWWm4Se1RbD" +
       "VXmuAf+F49k0CaRNZqSoQOHgTErDUeRsNlbKxOU5jNhIGGkbx+1teRubRlUs" +
       "MQ3JHS4bTqNWJRNv0U572ao99gQ7lGbkRF2gZUWu4WVUVAmDwjtJa9YLU3Fp" +
       "xq1FT3DGUHWhQ5Dg2pLHThGG4Gt2ggwXzni9VvAVnrnBKLN7RL0z2HJq6iXR" +
       "gmeTyEI1NWUVzO81DEJvC2Ev2rYb3a1SJxXNgCEybHhImSirdTngO/QYRfO/" +
       "J//icn+bPlD85XsUTvtD/Nm7q3pLnjx59Pd58blWunX8WdHyoX3EThiUHrlV" +
       "lGzx3P5zH33ueWX0q9Wr+9imD+YPBTz/3TZwKO0TQ90NRnrnrWMU6CJI+Djm" +
       "5o8++l8f5t9rfPASUYWPnsF5dsh/TH/+T3pvk3/+aum2owicm8KXT3d6+nTc" +
       "zd0B2LAClz8VffPIkWTflEssf1SP7iWLnn0wcTx3Fz4jKuqOQ8du26kJEOCT" +
       "txZgEZu2i9l4/tce/7MPPf/4fyzCu66boSAFaKCfE+98os+3Pv/CN7766ke+" +
       "UIRD3r6Uwh3Ds4HiN8eBnwrvLuDfc1ogjwFu/3wnj913VJJfZvjtMjAVXYUw" +
       "gJKTA9OPTFfH3Y0ZeK4DxjiM8v3buE1y7hOMZRqpR9N3ZR9ae/SY4nuHD6h+" +
       "cMEDqnecsgXXbNXVd4HUxXPM7/rJ0fhXd50On1y95viBTsf2XDUPfTyse+3h" +
       "U62jdwlAZXIu0m/skBY3y5PHzyjliXjGK3dfUHdPnlyPSnfIOZgd9gua35eU" +
       "jkh+oLj7dy5o/UBe+N+j0nVdjUhH0o+IvqkgKm2jAzMvPn6Kd9SoMJ7/48Ue" +
       "K5284U4sN4dZ0PvVTr8yq/3KcYPvFiQfuUAAj+bJQ2CvOBRA1wSqGR4aSiCJ" +
       "B48kcboq53/lR14G/yNr9/49//f/f+JfvoD/u/PkbScUIP/9mmOCb38ZBIsw" +
       "sPeC6yt7gl95Zc35qfWaT1AvkHzDlMNad3240U8KlsgFEsgtypUaWNpAAh1D" +
       "ysP/1YCM1CJY+/AeTxb3yF8tOkCjKDCXcaQq57cuxAa/EmL72l5sX3tlxHZ7" +
       "0SCPV7rSOpbPkZ240rtASGSeYLcQUl73nmPunZfB/dG8MA+5eWHP/YVXVGXO" +
       "cC+ocRfQnuYJA1QM0D6e911k7qFqPHyeapxoUshk9DJk8qq8MI9J/s5eJt+5" +
       "rEze8WJ24rcLttIFkpDz5P1R6d5QjU4E0Jy7eW88Uzmm/uMvg/rDeWEeNfaD" +
       "PfUfvDLUTzK7aDMtVNsCrPVTrAuRHTO0XwbDB/PCNwKwV3d9d9+vpMKXfrtY" +
       "4ofqeiJ+dRdNXxD9yQuE8OE82YJTiaQouy7HAxb8k5fL/xFA5dqe/7VXhv+x" +
       "sdvzz4E+c2zsfuYCwn8vT346AqemQ8LoWcofuwzlBDgRN79Zlr8a89BNb7nu" +
       "3syUv/D8fdff8Pz03+1OE4dvT95Fla5rsW2ffJPhRP6aH6iaWYjjrt17DX7B" +
       "5xfA/vWSouOAk1l85wyu/Pyu86fBGe9FOkdA2xztZKdfikpvvKBTBE6fRz9O" +
       "9vss0M+z/QCo4vtku18BIxy3A979LnOyyT8AqECTPPsP/WLyk51f/tBJRSyc" +
       "2AdfbDJPnOUfP3WALN5lPjwtx7u3mW/IX3x+wPzEt5u/unvDTLalLMtHuQ7O" +
       "eruX3YpB8xP3W2452uFY1/pPff/e37rrycN/B+7dAT5eFCewPXr+K1y440fF" +
       "S1fZ773hn/3orz//l0Wk+v8Dzemt4WQ+AAA=");
}
