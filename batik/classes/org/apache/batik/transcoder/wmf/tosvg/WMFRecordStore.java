package org.apache.batik.transcoder.wmf.tosvg;
public class WMFRecordStore extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFReader {
    private java.net.URL url;
    protected int numRecords;
    protected float vpX;
    protected float vpY;
    protected java.util.List records;
    private boolean _bext = true;
    public WMFRecordStore() { super();
                              reset(); }
    public void reset() { numRecords = 0;
                          vpX = 0;
                          vpY = 0;
                          vpW = 1000;
                          vpH = 1000;
                          scaleX = 1;
                          scaleY = 1;
                          scaleXY = 1.0F;
                          inch = 84;
                          records = new java.util.ArrayList(20); }
    protected boolean readRecords(java.io.DataInputStream is) throws java.io.IOException {
        short functionId =
          1;
        int recSize =
          0;
        short recData;
        numRecords =
          0;
        while (functionId >
                 0) {
            recSize =
              readInt(
                is);
            recSize -=
              3;
            functionId =
              readShort(
                is);
            if (functionId <=
                  0)
                break;
            org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr =
              new org.apache.batik.transcoder.wmf.tosvg.MetaRecord(
              );
            switch (functionId) {
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETMAPMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mapmode =
                          readShort(
                            is);
                        if (mapmode ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                MM_ANISOTROPIC)
                            isotropic =
                              false;
                        mr.
                          addElement(
                            mapmode);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DRAWTEXT:
                    {
                        for (int i =
                               0;
                             i <
                               recSize;
                             i++)
                            recData =
                              readShort(
                                is);
                        numRecords--;
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_EXTTEXTOUT:
                    {
                        int yVal =
                          readShort(
                            is) *
                          ySign;
                        int xVal =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int lenText =
                          readShort(
                            is);
                        int flag =
                          readShort(
                            is);
                        int read =
                          4;
                        boolean clipped =
                          false;
                        int x1 =
                          0;
                        int y1 =
                          0;
                        int x2 =
                          0;
                        int y2 =
                          0;
                        int len;
                        if ((flag &
                               org.apache.batik.transcoder.wmf.WMFConstants.
                                 ETO_CLIPPED) !=
                              0) {
                            x1 =
                              (int)
                                (readShort(
                                   is) *
                                   xSign *
                                   scaleXY);
                            y1 =
                              readShort(
                                is) *
                                ySign;
                            x2 =
                              (int)
                                (readShort(
                                   is) *
                                   xSign *
                                   scaleXY);
                            y2 =
                              readShort(
                                is) *
                                ySign;
                            read +=
                              4;
                            clipped =
                              true;
                        }
                        byte[] bstr =
                          new byte[lenText];
                        int i =
                          0;
                        for (;
                             i <
                               lenText;
                             i++) {
                            bstr[i] =
                              is.
                                readByte(
                                  );
                        }
                        read +=
                          (lenText +
                             1) /
                            2;
                        if (lenText %
                              2 !=
                              0)
                            is.
                              readByte(
                                );
                        if (read <
                              recSize)
                            for (int j =
                                   read;
                                 j <
                                   recSize;
                                 j++)
                                readShort(
                                  is);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bstr);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            xVal);
                        mr.
                          addElement(
                            yVal);
                        mr.
                          addElement(
                            flag);
                        if (clipped) {
                            mr.
                              addElement(
                                x1);
                            mr.
                              addElement(
                                y1);
                            mr.
                              addElement(
                                x2);
                            mr.
                              addElement(
                                y2);
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_TEXTOUT:
                    {
                        int len =
                          readShort(
                            is);
                        int read =
                          1;
                        byte[] bstr =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++) {
                            bstr[i] =
                              is.
                                readByte(
                                  );
                        }
                        if (len %
                              2 !=
                              0)
                            is.
                              readByte(
                                );
                        read +=
                          (len +
                             1) /
                            2;
                        int yVal =
                          readShort(
                            is) *
                          ySign;
                        int xVal =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        read +=
                          2;
                        if (read <
                              recSize)
                            for (int j =
                                   read;
                                 j <
                                   recSize;
                                 j++)
                                readShort(
                                  is);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bstr);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            xVal);
                        mr.
                          addElement(
                            yVal);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEFONTINDIRECT:
                    {
                        int lfHeight =
                          readShort(
                            is);
                        int lfWidth =
                          readShort(
                            is);
                        int lfEscapement =
                          readShort(
                            is);
                        int lfOrientation =
                          readShort(
                            is);
                        int lfWeight =
                          readShort(
                            is);
                        int lfItalic =
                          is.
                          readByte(
                            );
                        int lfUnderline =
                          is.
                          readByte(
                            );
                        int lfStrikeOut =
                          is.
                          readByte(
                            );
                        int lfCharSet =
                          is.
                          readByte(
                            ) &
                          255;
                        int lfOutPrecision =
                          is.
                          readByte(
                            );
                        int lfClipPrecision =
                          is.
                          readByte(
                            );
                        int lfQuality =
                          is.
                          readByte(
                            );
                        int lfPitchAndFamily =
                          is.
                          readByte(
                            );
                        int len =
                          2 *
                          (recSize -
                             9);
                        byte[] lfFaceName =
                          new byte[len];
                        byte ch;
                        for (int i =
                               0;
                             i <
                               len;
                             i++)
                            lfFaceName[i] =
                              is.
                                readByte(
                                  );
                        java.lang.String str =
                          new java.lang.String(
                          lfFaceName);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord(
                            str);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            lfHeight);
                        mr.
                          addElement(
                            lfItalic);
                        mr.
                          addElement(
                            lfWeight);
                        mr.
                          addElement(
                            lfCharSet);
                        mr.
                          addElement(
                            lfUnderline);
                        mr.
                          addElement(
                            lfStrikeOut);
                        mr.
                          addElement(
                            lfOrientation);
                        mr.
                          addElement(
                            lfEscapement);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETVIEWPORTORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETVIEWPORTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETWINDOWORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETWINDOWEXT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int height =
                          readShort(
                            is);
                        int width =
                          readShort(
                            is);
                        if (width <
                              0) {
                            width =
                              -width;
                            xSign =
                              -1;
                        }
                        if (height <
                              0) {
                            height =
                              -height;
                            ySign =
                              -1;
                        }
                        mr.
                          addElement(
                            (int)
                              (width *
                                 scaleXY));
                        mr.
                          addElement(
                            height);
                        records.
                          add(
                            mr);
                        if (_bext &&
                              functionId ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                META_SETWINDOWEXT) {
                            vpW =
                              width;
                            vpH =
                              height;
                            if (!isotropic)
                                scaleXY =
                                  (float)
                                    vpW /
                                    (float)
                                      vpH;
                            vpW =
                              (int)
                                (vpW *
                                   scaleXY);
                            _bext =
                              false;
                        }
                        if (!isAldus) {
                            this.
                              width =
                              vpW;
                            this.
                              height =
                              vpH;
                        }
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_OFFSETVIEWPORTORG:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_OFFSETWINDOWORG:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int y =
                          readShort(
                            is) *
                          ySign;
                        int x =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            x);
                        mr.
                          addElement(
                            y);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SCALEVIEWPORTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SCALEWINDOWEXT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int ydenom =
                          readShort(
                            is);
                        int ynum =
                          readShort(
                            is);
                        int xdenom =
                          readShort(
                            is);
                        int xnum =
                          readShort(
                            is);
                        mr.
                          addElement(
                            xdenom);
                        mr.
                          addElement(
                            ydenom);
                        mr.
                          addElement(
                            xnum);
                        mr.
                          addElement(
                            ynum);
                        records.
                          add(
                            mr);
                        scaleX =
                          scaleX *
                            (float)
                              xdenom /
                            (float)
                              xnum;
                        scaleY =
                          scaleY *
                            (float)
                              ydenom /
                            (float)
                              ynum;
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEBRUSHINDIRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            readShort(
                              is));
                        int colorref =
                          readInt(
                            is);
                        int red =
                          colorref &
                          255;
                        int green =
                          (colorref &
                             65280) >>
                          8;
                        int blue =
                          (colorref &
                             16711680) >>
                          16;
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        mr.
                          addElement(
                            readShort(
                              is));
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEPENINDIRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            readShort(
                              is));
                        int width =
                          readInt(
                            is);
                        int colorref =
                          readInt(
                            is);
                        if (recSize ==
                              6)
                            readShort(
                              is);
                        int red =
                          colorref &
                          255;
                        int green =
                          (colorref &
                             65280) >>
                          8;
                        int blue =
                          (colorref &
                             16711680) >>
                          16;
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        mr.
                          addElement(
                            width);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETTEXTALIGN:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int align =
                          readShort(
                            is);
                        if (recSize >
                              1)
                            for (int i =
                                   1;
                                 i <
                                   recSize;
                                 i++)
                                readShort(
                                  is);
                        mr.
                          addElement(
                            align);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETTEXTCOLOR:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETBKCOLOR:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int colorref =
                          readInt(
                            is);
                        int red =
                          colorref &
                          255;
                        int green =
                          (colorref &
                             65280) >>
                          8;
                        int blue =
                          (colorref &
                             16711680) >>
                          16;
                        int flags =
                          (colorref &
                             50331648) >>
                          24;
                        mr.
                          addElement(
                            red);
                        mr.
                          addElement(
                            green);
                        mr.
                          addElement(
                            blue);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_LINETO:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_MOVETO:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int y =
                          readShort(
                            is) *
                          ySign;
                        int x =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            x);
                        mr.
                          addElement(
                            y);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETPOLYFILLMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mode =
                          readShort(
                            is);
                        if (recSize >
                              1)
                            for (int i =
                                   1;
                                 i <
                                   recSize;
                                 i++)
                                readShort(
                                  is);
                        mr.
                          addElement(
                            mode);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYPOLYGON:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int count =
                          readShort(
                            is);
                        int[] pts =
                          new int[count];
                        int ptCount =
                          0;
                        for (int i =
                               0;
                             i <
                               count;
                             i++) {
                            pts[i] =
                              readShort(
                                is);
                            ptCount +=
                              pts[i];
                        }
                        mr.
                          addElement(
                            count);
                        for (int i =
                               0;
                             i <
                               count;
                             i++)
                            mr.
                              addElement(
                                pts[i]);
                        int offset =
                          count +
                          1;
                        for (int i =
                               0;
                             i <
                               count;
                             i++) {
                            int nPoints =
                              pts[i];
                            for (int j =
                                   0;
                                 j <
                                   nPoints;
                                 j++) {
                                mr.
                                  addElement(
                                    (int)
                                      (readShort(
                                         is) *
                                         xSign *
                                         scaleXY));
                                mr.
                                  addElement(
                                    readShort(
                                      is) *
                                      ySign);
                            }
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYLINE:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_POLYGON:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int count =
                          readShort(
                            is);
                        mr.
                          addElement(
                            count);
                        for (int i =
                               0;
                             i <
                               count;
                             i++) {
                            mr.
                              addElement(
                                (int)
                                  (readShort(
                                     is) *
                                     xSign *
                                     scaleXY));
                            mr.
                              addElement(
                                readShort(
                                  is) *
                                  ySign);
                        }
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ELLIPSE:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_INTERSECTCLIPRECT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_RECTANGLE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEREGION:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ROUNDRECT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int el_height =
                          readShort(
                            is) *
                          ySign;
                        int el_width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        mr.
                          addElement(
                            el_width);
                        mr.
                          addElement(
                            el_height);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_ARC:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_PIE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int yend =
                          readShort(
                            is) *
                          ySign;
                        int xend =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int ystart =
                          readShort(
                            is) *
                          ySign;
                        int xstart =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int bottom =
                          readShort(
                            is) *
                          ySign;
                        int right =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        mr.
                          addElement(
                            left);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            right);
                        mr.
                          addElement(
                            bottom);
                        mr.
                          addElement(
                            xstart);
                        mr.
                          addElement(
                            ystart);
                        mr.
                          addElement(
                            xend);
                        mr.
                          addElement(
                            yend);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_PATBLT:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int rop =
                          readInt(
                            is);
                        int height =
                          readShort(
                            is) *
                          ySign;
                        int width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int left =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int top =
                          readShort(
                            is) *
                          ySign;
                        mr.
                          addElement(
                            rop);
                        mr.
                          addElement(
                            height);
                        mr.
                          addElement(
                            width);
                        mr.
                          addElement(
                            top);
                        mr.
                          addElement(
                            left);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETBKMODE:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int mode =
                          readShort(
                            is);
                        mr.
                          addElement(
                            mode);
                        if (recSize >
                              1)
                            for (int i =
                                   1;
                                 i <
                                   recSize;
                                 i++)
                                readShort(
                                  is);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_SETROP2:
                    {
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        int rop;
                        if (recSize ==
                              1)
                            rop =
                              readShort(
                                is);
                        else
                            rop =
                              readInt(
                                is);
                        mr.
                          addElement(
                            rop);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBSTRETCHBLT:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int heightSrc =
                          readShort(
                            is) *
                          ySign;
                        int widthSrc =
                          readShort(
                            is) *
                          xSign;
                        int sy =
                          readShort(
                            is) *
                          ySign;
                        int sx =
                          readShort(
                            is) *
                          xSign;
                        int heightDst =
                          readShort(
                            is) *
                          ySign;
                        int widthDst =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is) *
                          ySign;
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int len =
                          2 *
                          recSize -
                          20;
                        byte[] bitmap =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++)
                            bitmap[i] =
                              is.
                                readByte(
                                  );
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            heightSrc);
                        mr.
                          addElement(
                            widthSrc);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            heightDst);
                        mr.
                          addElement(
                            widthDst);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_STRETCHDIB:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int usage =
                          readShort(
                            is);
                        int heightSrc =
                          readShort(
                            is) *
                          ySign;
                        int widthSrc =
                          readShort(
                            is) *
                          xSign;
                        int sy =
                          readShort(
                            is) *
                          ySign;
                        int sx =
                          readShort(
                            is) *
                          xSign;
                        int heightDst =
                          readShort(
                            is) *
                          ySign;
                        int widthDst =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is) *
                          ySign;
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int len =
                          2 *
                          recSize -
                          22;
                        byte[] bitmap =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++)
                            bitmap[i] =
                              is.
                                readByte(
                                  );
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            heightSrc);
                        mr.
                          addElement(
                            widthSrc);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            heightDst);
                        mr.
                          addElement(
                            widthDst);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBBITBLT:
                    {
                        int mode =
                          is.
                          readInt(
                            ) &
                          255;
                        int sy =
                          readShort(
                            is);
                        int sx =
                          readShort(
                            is);
                        int hdc =
                          readShort(
                            is);
                        int height =
                          readShort(
                            is);
                        int width =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int dy =
                          readShort(
                            is);
                        int dx =
                          (int)
                            (readShort(
                               is) *
                               xSign *
                               scaleXY);
                        int len =
                          2 *
                          recSize -
                          18;
                        if (len >
                              0) {
                            byte[] bitmap =
                              new byte[len];
                            for (int i =
                                   0;
                                 i <
                                   len;
                                 i++)
                                bitmap[i] =
                                  is.
                                    readByte(
                                      );
                            mr =
                              new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                                bitmap);
                            mr.
                              numPoints =
                              recSize;
                            mr.
                              functionId =
                              functionId;
                        }
                        else {
                            mr.
                              numPoints =
                              recSize;
                            mr.
                              functionId =
                              functionId;
                            for (int i =
                                   0;
                                 i <
                                   len;
                                 i++)
                                is.
                                  readByte(
                                    );
                        }
                        mr.
                          addElement(
                            mode);
                        mr.
                          addElement(
                            height);
                        mr.
                          addElement(
                            width);
                        mr.
                          addElement(
                            sy);
                        mr.
                          addElement(
                            sx);
                        mr.
                          addElement(
                            dy);
                        mr.
                          addElement(
                            dx);
                        records.
                          add(
                            mr);
                    }
                    break;
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DIBCREATEPATTERNBRUSH:
                    {
                        int type =
                          is.
                          readInt(
                            ) &
                          255;
                        int len =
                          2 *
                          recSize -
                          4;
                        byte[] bitmap =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++)
                            bitmap[i] =
                              is.
                                readByte(
                                  );
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord(
                            bitmap);
                        mr.
                          numPoints =
                          recSize;
                        mr.
                          functionId =
                          functionId;
                        mr.
                          addElement(
                            type);
                        records.
                          add(
                            mr);
                    }
                    break;
                default:
                    mr.
                      numPoints =
                      recSize;
                    mr.
                      functionId =
                      functionId;
                    for (int j =
                           0;
                         j <
                           recSize;
                         j++)
                        mr.
                          addElement(
                            readShort(
                              is));
                    records.
                      add(
                        mr);
                    break;
            }
            numRecords++;
        }
        if (!isAldus) {
            right =
              (int)
                vpX;
            left =
              (int)
                (vpX +
                   vpW);
            top =
              (int)
                vpY;
            bottom =
              (int)
                (vpY +
                   vpH);
        }
        setReading(
          false);
        return true;
    }
    public java.net.URL getUrl() { return url;
    }
    public void setUrl(java.net.URL newUrl) {
        url =
          newUrl;
    }
    public org.apache.batik.transcoder.wmf.tosvg.MetaRecord getRecord(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.MetaRecord)
                 records.
                 get(
                   idx);
    }
    public int getNumRecords() { return numRecords;
    }
    public float getVpX() { return vpX; }
    public float getVpY() { return vpY; }
    public void setVpX(float newValue) { vpX =
                                           newValue;
    }
    public void setVpY(float newValue) { vpY =
                                           newValue;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ficAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e8zsxnXf3nslXd0rWfdKtiRblizrZVve9CP3weVuFD9I" +
       "7nJJ7nK55O6Sy81D4mv5WL6Wr+WuqyYx2tqpAcdI5NRFY/3loE0gx0lboy3S" +
       "FCr6SAIbRR0ETVq0ttEEqJPUSFQgalDXSYfc7617r6RK6QdwODsz58z5nTlz" +
       "5sxwvpe+W7k9jirVMHC3phskB0aeHDgucpBsQyM+YIbIWIliQydcJY6noOxZ" +
       "7fFfufbq9z5nXb9YuWNReafi+0GiJHbgx4IRB25m6MPKtZPSnmt4cVK5PnSU" +
       "TIHSxHahoR0nzwwrd50iTSpPDo9EgIAIEBABKkWAsJNWgOgdhp96REGh+Em8" +
       "rvyNyoVh5Y5QK8RLKo+dZRIqkeIdshmXCACHO4vfIgBVEudR5f3H2PeYXwP4" +
       "81Xohb/7Y9f/0aXKtUXlmu1PCnE0IEQCOllU7vYMTzWiGNN1Q19U7vUNQ58Y" +
       "ka249q6Ue1G5L7ZNX0nSyDhWUlGYhkZU9nmiubu1AluUakkQHcNb2oarH/26" +
       "fekqJsD6wAnWPUKyKAcAr9pAsGipaMYRyW0r29eTyqPnKY4xPjkADQDpZc9I" +
       "rOC4q9t8BRRU7tuPnav4JjRJIts3QdPbgxT0klQeuinTQtehoq0U03g2qbz7" +
       "fLvxvgq0ulIqoiBJKvefb1ZyAqP00LlROjU+3x390Gc/4VP+xVJm3dDcQv47" +
       "AdH7zhEJxtKIDF8z9oR3f3j4c8oDv/7pi5UKaHz/ucb7Nv/0r7/y8R9438u/" +
       "uW/z3hu04VTH0JJntS+p93zjYeLpzqVCjDvDILaLwT+DvDT/8WHNM3kIZt4D" +
       "xxyLyoOjypeFfyf/xC8Zf3yxcpWu3KEFbuoBO7pXC7zQdo2ob/hGpCSGTleu" +
       "GL5OlPV05TLID23f2Jdyy2VsJHTlNrcsuiMofwMVLQGLQkWXQd72l8FRPlQS" +
       "q8znYaVSuQyeyt3geaKy/yvfScWErMAzIEVTfNsPoHEUFPhjyPATFejWglRg" +
       "9SsoDtIImCAURCakADuwjMOKJFL8WAt0I4I23hJKgjgzIYklBUMLIn0CDN84" +
       "KAwu/P/XVV6gvr65cAEMyMPn3YELZhIVuIDJs9oLKd575Zef/drF4+lxqK+k" +
       "0gS9H+x7Pyh7Pzjp/QD0flD2fnC298qFC2Wn7yqk2FsAGL8V8ATAR9799ORH" +
       "mec+/fglYHrh5jag/KIpdHNXTZz4Drr0kBow4MrLX9j8pPjj8MXKxbM+t5Ac" +
       "FF0tyMeFpzz2iE+en2s34nvtU9959Ss/93xwMuvOOPFDZ/BaymIyP35ex1Gg" +
       "GTpwjyfsP/x+5avP/vrzT16s3AY8BPCKiQKsGDic953v48ykfubIQRZYbgeA" +
       "l0HkKW5RdeTVriZWFGxOSsrBv6fM3wt0fFdh5e8Bz8Gh2ZfvovadYZG+a28s" +
       "xaCdQ1E64I9Mwi/+3r//w0ap7iNffe3U6jcxkmdO+YeC2bXSE9x7YgPTyDBA" +
       "u//6hfHPfv67n/rh0gBAiydu1OGTRUoAvwCGEKj5b/3m+j9965tf+p2LJ0aT" +
       "gAUyVV1by49BFuWVq7cACXr7wIk8wL+4YOIVVvPkzPcC3V7aiuoahZX+n2tP" +
       "1b76Pz57fW8HLig5MqMfeH0GJ+XvwSs/8bUf+1/vK9lc0Ir17URnJ832TvOd" +
       "J5yxKFK2hRz5T/72I3/vN5QvAvcLXF5s74zSi1VKHVTKQYNK/B8u04NzdbUi" +
       "eTQ+bfxn59epOORZ7XO/86fvEP/0X75SSns2kDk91qwSPrM3ryJ5fw7YP3h+" +
       "plNKbIF2zZdHP3Ldffl7gOMCcNSAP4u5CPiO/IxlHLa+/fJ//lf/+oHnvnGp" +
       "cpGsXHUDRSeVcpJVrgDrNmIL+Ks8/NjH94O7uRMk10uoldeA3xvFu8tfV4CA" +
       "T9/cv5BFHHIyRd/9vzlX/eR/+/PXKKH0LDdYfs/RL6CXfv4h4qN/XNKfTPGC" +
       "+n35ax0xiNlOaOu/5P3Zxcfv+LcXK5cXlevaYUAoKm5aTJwFCILioygRBI1n" +
       "6s8GNPvV+5ljF/bwefdyqtvzzuVkAQD5onWRv3rOnxQraOVd4HnqcKo9dd6f" +
       "XKiUmY+VJI+V6ZNF8sGj6Xs5jOwMrPaH8/cvwd8F8PxF8RTMioL92nwfcRgg" +
       "vP84QgjB2nQpjdyS9v6kcndpTL6RHMyE4d6VFWm9SD6+7wG5qeH84DGse4rS" +
       "R8DzwUNYH7wJrMFNYV0JoyAByjf0UmXdpHIVBPf71TG+tSWOI9sD7jM7DOSg" +
       "5+/71urnv/PlfZB23uzONTY+/cLf+cuDz75w8VRo/MRrotPTNPvwuBTyHaWk" +
       "xUR+7Fa9lBTkf//K87/2D5//1F6q+84Gej0A9cv/8ftfP/jCt3/rBtHEJRDE" +
       "nxuc4f/D4HzocHA+dJPB+eGbDE6R5Y5G5VIWzssW/CH44jVLirkQKOel/JG/" +
       "AimNNyilXGSfOyfQ8k0K9F7wPH0o0NM3Ech9IwJdjo4t+bGbWLKgbMp9zLPa" +
       "P+e//Y0v7r7y0t4UVAUE6pXqzbbEr92VF0HVU7cIDE82S3/W/8GX//D3xR+9" +
       "eLju3XUW/X23Qn/kQu45vYbt1/vsnNa9N6710kE+Bp7qYb/Vm2h9dwutE0da" +
       "v/1ZFcC/kbleVoPANRT/nKSfeF1J92wuAI91e/0APYCL33/zxrJcKrIfAgFX" +
       "XJ4RFHPE9hX3SLgHHVd78shFi0YUg9XyScdFjxR7vVRssS4d7Dfa52TtvmFZ" +
       "gdHdc8JsGIA9+2f+4HNf/+knvgUsjKncnhUrITCaUz2O0uIY42+/9PlH7nrh" +
       "258p40egXPGnfhX9dsH1p2+FuEg+XSQ/dQT1oQLqpNyYDZU4YcuQz9CP0Z4b" +
       "nNvc4C2gTe59jmrGNHb0N6wpyhzTcmGezjWvpday7UD3JEbm4zor9bZID1kQ" +
       "1EJzlbqcrIhtU2tznThypjOUbe/giRcLVotdWwtuneK57fQ4fIn4co8eM/xE" +
       "6gUw4MyKAj41Lb5rTmbBjOlxnM0OVs2u7+tjdbRDWXQwWQ8CEHX4aaeDNgwo" +
       "0hvS2PFb/YVltpQYGxCLvt53FsScj8Jeg+/mu9DdTLE6P6ryBmUYbVaqr+rp" +
       "HK9ROD0I5J6cG7MpvkmaU9fr9umWPSdpmrZlj01yhxrAiu5g1cTBQnK2ELri" +
       "ZLUY8yHrziaDjmLmU9MkcaeFr00B121bZlCnR/ZIfmkupF59FhGUjlod01z3" +
       "amISwnA1hymjJdiWi7noMODMdWxy8mxDM83VytpyE14Pp5wXTUXK9+PBdtLr" +
       "tQQYQxHN4ojRghqyWzxYDqbb3cjr0LUZa4YeEazt3loy4rwpr50qKePkXMlE" +
       "eDu1zEZgVO0MM9e6gE1r+CRnzEY37Pfl2mgohcFQdOus6xnWzJtGvZU7Me25" +
       "gONErU50er35zJblLJK9FUn0pmRt0d6aqDKAE3c37OLzTDGzLG0kam0CbWfc" +
       "zFyHk9kSbDt7wgKXGQbHcN4PXLPBeXRO4Umvxoex7kASM+tLTLzVI6e/kmcz" +
       "c6JbVSJXFU+fbHapAscy08FHDTjsWbOxUjN83JtVpaQ/x5U+r2stqWak8nSZ" +
       "4BtxyJC2TFlLDF1tJYgkGVvowzCbCrWICiUYwyJ6xkx76qxDThHbxPQ1rag2" +
       "sQk2VbLKdmtuv2f56z6BcStqt6TFSdQVcQqX+m2BqE2wjk7lbWLt0X28P7PW" +
       "o8Uwt6f4MG7sUIZxljtETevD8U4L14xsEjEny6QntSCXMZUM20Sankf98QZr" +
       "I3LiTLbzloVqvsbTEyLtCPjOczsQAgk1cjfTlk1qumM7RLxttbBmspp0N7No" +
       "biW8tIzazrblEMxoNJm0qhN05C2WNW8yTgY8bINhUWgLZiV5TNV21UZLl6n2" +
       "RMfF0aBLrARxaquYsw7JkUIybLKYy/w8wuJ+TrkT1hVNv1/t4EB92kqYskZn" +
       "STY3sjeeWMuFC5ODLB71WBHHaSnAmabLKIiyQ0JMSKzdZMXSpEZTrkb6hMFA" +
       "KJOazSVBezFu8QI/m4hUd6mGg850SfSovm1yNZrDQmmcB/XagOcYy5I6Rn+D" +
       "UfLGjGE8MNMBPaN5OB479tyW16wqa2O730jRmkROa1K3LY9NRDA74+qyxrnr" +
       "kbzLNyxeZzCy4WOmuTUS0ZvxrD1NJy005rLGBu5lWm1goR5lCjrus1Q62Fkd" +
       "J6bnWb3Hbgw54qjGkHN4Gh9xQZqaboyho3YgYDSdS1ICidlcHUG6hxle2AS9" +
       "QPYsGfXFlRMlWp8iqwSVS70GknPDhuvAU2EMFE5wNEP49IgdwS2W5dO2IMBo" +
       "YxiERIwy23zL9HbKcDgVBYqi+1ME4ZHpJOy1LH+uTDtYbG34KKhRy+4y81et" +
       "XSS0tbEzatc1NnZ5wCrcrFoIv6U1ZtJxNmpDx/GsHSiUStERurMQJHGqcyXQ" +
       "B2SO5PB63l/kMwtWMmnuWH1hMB9atEHNw62Yc91MMAlOoLD2BO+PfMfXWMnS" +
       "7dSb1epghPrNta31PB5Z9BmD74mwnjRSOROBCdRck1zPZ6yxJJi60BpkqRc0" +
       "Zooq6btqa1FHkj6ByNuois5RKOuu807H1MgsDHVGICHBgdMmrYiC3OUTo6aq" +
       "CzXBcjwKG11o2qkO0DGaOKyKy4HrTdSY9uq+0B3IWIwjabWjjUYqinYard6U" +
       "T3yW4KbwwtLpwBWVSWfNTaheRKj4Um41+/ygx8UBqU4TsodXkam9sgiRnUvx" +
       "sibXh40Mhnc1sYEhq9aQYluDIYPrTkerGbZUg5SOO+v2cpZXZus6q44Zg9ku" +
       "lVmWwpRoMbUa1YrUeasBbTMKWy6wLQ0HMmyKvinwm27eVRNtrUKMsu3suqM6" +
       "I9WVrrLMU6gxnE2DkT1PxmCmVdtjdxp23HVDleZaq4PiSl33cj0Zrmy8OvKN" +
       "5lBQ2J6CoRHYXKP6bKstx2Ys4CvCIoiuKrWEbjqz0SE7cH1yiHY63VGtXoOG" +
       "fJtMRWIQ8etclXutvh33W/G0R9BTxZ3PY73R2eW0Z6+9QRDwkMd2zWizSXO1" +
       "hsx5AhuhTcfYLdG53WaphseI4ZxdtHO3gwVoM1pH9KDhqzHeqTbbvkEtUQHy" +
       "RxoWgcyOZcFkgCKEc5IlhKB4yseOJ4XT3a5tVvtOp41GGSdPc69NkWyku2wE" +
       "vAsxU3VkSMF5uy9tYqOr0ISpC65kSTuMI/yBkHKmJQZeX4RFXEzbqk4K7Uzt" +
       "RFNszuEjxETCTOqzTtLdOJwbxpDrpxYJVpI63N+09IhtGOaMN6qWNSTq8Xy2" +
       "Vu1WzZwpTtgLt+uY0BWXk/mJixuzUFtAwpbYhk4+YOzeaN0at/s4U28lQdxc" +
       "DNWlVttpKBzhEpzkzerQUOLhtLVWx7gYis5U5AdYE7Eob0lrsrlamxIrRNuY" +
       "1Zs1rN3AIdYLsXGoTXpDlNqNogYcoUkzbXlZ1Nl4SEu1ZGpaE5oM1OiaOwHO" +
       "4qrAC0Ta7+pylUsDfE1sNE/xBhGUR1Usw5AaBPM1neUa5kjSRyEZDYZwOIs7" +
       "mqftUlGgh9sIyRqCAberOT7fGOGA6nOQ0WlyGd/I6m3ZGTvwaMiumquphVQZ" +
       "briG+7I61xv2fMhunLQ1dtJaC2LtlIPstZLsyKWgx/CKg8aQvm2xGDWsKyE9" +
       "Zldt2BrytdicL7sjLW2PxKrTQmtaNVY1L8qTtSMgM5ecrDxk0GSqaj3t0U5/" +
       "Lsau32DjqMGLdC3t9vp4qGIUlY6XVbwtQ03Jc0U0kKFNG4rmPBIs2D60dHB/" +
       "10/weAFJix1fdeZ6rO1UYt2janOaZ6hqgyPF6QLu1yaLIED7rroejC1vyXkt" +
       "rYk0ds2ECXdJFrHGLOG4cb1JS866NbcEvz3v1DaZg9KbDtNHwrUSRlKGkEHV" +
       "DSXJ1C2o13GgTl0bEu4knfbq/EBAcuBaKEKo9lCbExQahLj1FO8HptbuhmZz" +
       "3OaIHFHbbZJnVHq1w7RtH1UX2ITrLbLQsIidOPYTNvTxhRTVhwQOJcCVUtR6" +
       "HXaMnUqqKM4O1GVEZVkDVyB9RHWzgbzxRjt+UqvqdWchogYsjUZas+V4aj2c" +
       "t9AWkvXH43wnK2lNwKVaPWztYsnoxT1qlWdLoz0fd6V2Q6NEexZbq6qq8Hky" +
       "TpGNW4W5lZZvN3RbpWOdJwlCHg6bM8EVxTxgtvM0SnYt0ti6iCc11gt00MYM" +
       "BdEoNoHFQZ2W3AFwzLA8gcF6lHQa7FBNIW8uJQGJkPhITGsOCDytuk2EubUh" +
       "NlsRqXfr1nxV7UiNsW/JcKM7aOnbAO6ifVtB2BYBkU16McxmDb7amfgR1Ikg" +
       "tj7vctslv55jm7gzoFxynOBohxVFsmk18MRzGeB22S0ybMx2CeoKauBxkxou" +
       "NjS3YY/X3bEVt0UkQozmVDTqDbrNhL1qJ1vniGOakLOjQPAbavmU9aPWhB65" +
       "7HjeYV1pUGenbdhTIG+8pgTHbI06QocZ1HSfmwNtiLsGM7RWkzlejXBUj+bR" +
       "oEv67SmRhoERk3TGB1I4hHs5PCSmqgWjLrKordtjI23N7KG0Hs/yzNPD9kbA" +
       "wwkWLlzVSbjY6LdnfrihyIkTSnatu2GYJZO19NVcbcXcZBd0hNxh6s6OWPXI" +
       "DWLFtZHbWTLt0WadTTGM2bG8Pd+InMesDa8b0EulsdjJvSBfG5APorBxQq3U" +
       "Vbc7mXTzNQ1RnN71Rd7tOs7A5zxl5TS15dppCxKTzadUz2k7U3nJ8wHhNbAm" +
       "vnNmjKE3dL4pSBS2YU18PA01sAB1kx2yCnwmbpkUkHOJIV59HFP9Bgf2Rlx9" +
       "UBv5EL9AHVmaw3CXTES422Xmc6c136pV36Jn2RqtVk0F+NGtBG8NLl/MCHS1" +
       "oGVFwIiqzjL82gsnhj/jl7izU8hAlVt5XZ2E8aorI1jfMqKAULEkmPVH65kz" +
       "qvXGuQxp3GCjCsmOJnu9emNtyBjw5yBIoPv91kywo7XPNQYFZq3VF4YW1TPj" +
       "oF2bEE13RNlTBQKBRsgRG6TR6k4UyEDq0zbYg0Ctbbu6HBJbZazijlTdyvC4" +
       "tZtvFhTWtSdghzU3m6gPglxK01zLAxN/G3pJbYAjPF/zQbxhDgbSUmTBllDP" +
       "EUvk4RlETEnMSHotT9l4it/kmA25ciBtzCTIwBzY7eWQDjtc1WvxNDPC84yi" +
       "kM1qXSdFvkcvjR0fzWsIssy8LV0PsQx2ZMv04YzfZLKhoSPEdZ0kYlR2lCPk" +
       "zubW63yJ9nPHnTPjbGQ3EwcfSUk29hsktNyOAtsc9qq5HXUnBJH5w+lEhodV" +
       "brLZ+qOVK23STIzzyZjc6bKVhEFWp5S8KjfbdZ7iArc/9TkdaUgyHOrVVjYX" +
       "g1zkMpRAmmOwZ/JqJGZSYVWrqpETTiSrO86RleM1JrEmd1x0M1Ylo7EwtBrV" +
       "rnWz2BKGto7OhhDnUTnOUQmK5AiSd7szclYPRt5mvNLCDoj5uaQxSHFehgJz" +
       "EBpsZPFxTxFoM9226oO6CTwBv0QRK2WsjbvW0dYyCUwr2KEov2tUB/MtFzRr" +
       "rrGeTMR+vph2WT1Km9PM4XTYG2mNrjw2ZAl2VXuqqjOfb2z6WxCB15WF20Bc" +
       "CBHkLbkSUJXPbYTD3EymGw2l6kF9OJWopa1hGPaRjxRHLX//zR0B3Vuedh3f" +
       "MXFctKj4zJs45dlXPVYkTx2fF5Z/d1TO3Us4dV546oNWpTipf+RmV0fKU/ov" +
       "ffKFF3XuF2pHB6JiUrmSBOFfc43McE+xugo4ffjmR6xseXPm5APVb3zyjx6a" +
       "ftR67k18dn/0nJznWf4i+9Jv9T+g/czFyqXjz1WvudNzluiZsx+prkZGkkb+" +
       "9MynqkfOfvp+EDytQ822zp/EnozdjY9hP7Qf+1t8Z/3VW9T94yJ5KancHhmx" +
       "ccMz3NuywNZPbOfLr3dCeLqHsuAXj8E+cHTsTB6CJd8sWO6GYC8c3tQ4PNLd" +
       "f++1g4Oukii0H6bJJIkMxStpX7417TuPaGmul2tGWNhPSfdviuTXkspdgJN+" +
       "+MGsKPrxE9X8i7egmmtF4f2VysXv7Gn377fXDv7DLep+u0i+llTuMI1kFpW3" +
       "ufonyL7+FpDddegvLv7JIbI/eXuQXThp0C8b/JdbwPtmkfxu8ZHgGN5XT+D9" +
       "3lu16UcBrFcP4b36tsOblg2+cwt4f1Qkvw+8KBi9U7YJ7Bl+Y1ekgAtTThGW" +
       "WvmDt2rODwNtfP9QK99/+8351VvU/XmR");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vJJU3gEUMjr+wF0q8wTg/3wLAMtVEfjtS7ftaffvtxXghYu3qLutKPz+fr6K" +
       "4bz49dwJsr94O5DddYjsrrcf2T23qLteJFeOkMlnkV24+lY90QcBovsOkd33" +
       "tk/V50oID90C3sNFcv/eEx0O3IknuvDA2wHvPYfw3vNXBO8Dt4BXxKQXHjuC" +
       "J5+D9/ibgZcnlXvOXt0s7qG9+zVXx/fXnbVffvHanQ++OPvd8vbi8ZXkK8PK" +
       "ncvUdU9fGzqVvyOMjKVdwr6yv0QUljCgpPLUG/KcIHIq34X0Fw72xHUQI74O" +
       "cVK5BNLTREhSee8tiBIQvR7/OE3XTirXz9MBocr36XbPAA4n7cAA7TOnm3wU" +
       "SAWaFNmPhUcLCPrGFhBMjUG5lpQDphR36C6c3RMc+6b7Xs8GTm0jnjgT/Jf/" +
       "W3AUqKfjw2scX3mRGX3ildYv7G9/aq6y2xVc7hxWLu8voh4H+4/dlNsRrzuo" +
       "p793z69ceepoY3LPXuCTeXNKtkdvfNWy54VJeTly988e/Cc/9A9e/Gb5Vf//" +
       "Ahgvpy30MQAA");
}
