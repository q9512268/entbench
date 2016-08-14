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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "GDZzJgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "dIas3cUMX0mMOGKb9IiQXKqXdIhFZ+qoFFi0qDo7Fq3AKAd0lA2XMDrtjcyO" +
       "jTLKwgYKnNlKVRSwbKHExNZcoxN4vXZLfZyXKml/PJnyMZstR5K+slZyObGY" +
       "TbWG9lDLE5HEQCmkSgu1oMy72Lw85tVhXbWkmWEZklEhPBWuqXF3JpJuamRV" +
       "kVCbeimu+90krTTWs1XJGBimOAs3Mml6w8VEXbXKtdUGE4eCF3Br1UWDeWPY" +
       "rw+9sspLVSyJ6MkiTcRo2+2KXI0nUrOZWqpkIkzPapKTRk0gN03gUJatsFPj" +
       "yQbs2OGQiZcTO0qkhojJVQKZ9ZJtWuG5oSRN627miateEnTUkgwiGbbmDJR1" +
       "c2CNbd0OJHst8N1x0BsZAy6ttSd0HI5q8jRsUz6I3dY6PVtklEBMfTuIZGaA" +
       "KUpjHdW5RhxloTIilnMYoxJLLLED4AMn47idYcMOusYJu6r1B4nXlWmMqcW0" +
       "iAZNuFEV5lPcFvA13PNYvVupmFFfDs3yOG0hcLAi9M0aKfVZa7TuVdjqZGEm" +
       "TlQb1uWIWfK4y7PbaQnrVG0stLChUoZpiawxLcyYL5EmzCA9rWwpOA7LMS+k" +
       "QYkYg0Wsipc20aLpEg1xyNdL5mKEG6JCdEKYLhPoxlHM9mTcmc5XqiEL21UW" +
       "9WC4wm2YtY+gqZuNp1qK1Y3ytscKswZiOmOLl+CQ346YGUXqC7Exms1JONlG" +
       "Y6WS4mUkM6O54VtTazqRfb/hxjTabGKBNUKnelV35ymhbTAsyDDYtOZGxaki" +
       "9baVbhWHYPAg7i96it5EYgEl1x7LdJNqgCect5iXMKc0l5J+NKgM5EVpJqsJ" +
       "aVQ1oBq2VEG6PXeDlRaTUikNGLMRp6PS2E7hdbhx9XUXbngNRw00EPcN/XSw" +
       "RJfyyMExI6jQcQfx+i0p40Ic55JaxaT0SZncUnIb6/cWEQjVUtpQWzgyQtme" +
       "lI6F6ZjxZ7P2gmtYzVZzTWLbdOOJnNOKZ2nFzdSqDnOVFilKsNYcwVpXlsmQ" +
       "adFrPmtHmJLiio5OqmjPlYm1YEtpylfViBFNLRwsR+gy4uimxrdUBxMjySyB" +
       "KL08EebdbamLV2B8VS7jwOdLJdiZjBxpxrWV1bLnp014LFs4Hm3LZUoNBo4H" +
       "djdhdan23Wp1LmZgcaeri2ARY9HQsRTKwvqKgovTpczjETYdpMasizmoXF+C" +
       "tZ5X5920JQ8TVXPqVkALgjdso3OT1eVhb76kyyNlE8M6zG69Wm21Qs21MmnB" +
       "JTybcq3eqraobWY2N1d0GPVrfRAQdphosRhhLq4lAgpim9lSLqNDJ+IFp0/j" +
       "W3y6SrxKu7Sqr7bkwB0r0SY2uZheUqNENNvJrFTdoNMyxcSiwJQFXhZDqb/g" +
       "RpQWRpsULE1zXxBikmurpCgHruhXRc9tzcrbyaCtVnow303VLN87yNu+RRD5" +
       "ccnfe3vHOA8VJ1aHd0gWTi2v+MzbOKnZVT2dJ88dnvkVf/dCp+4dHDvzO/ZR" +
       "CspP25+409WQ4qT9y598+RWd+fnywaHmNIYux37ww46xNpxjrK4ATh+58zHp" +
       "sLgZc/SR6dc++QeP8R+dv/g2Pp0/dUrO0yx/Yfjqb1Af1P7WeejC4SenW+7s" +
       "nCR64eSHpiuhESehx5/43PTEyc/Xj4Knuq/Z6unT1KOxu/1R6od3Y3/Gt9J/" +
       "eEbdP86TV2PontCIjNuew15c+7Z+ZDtfebNTvuM9FAW/cAj2kYOj484+2M7b" +
       "BcvcFuy5/dsW+8eyu2+2tr9HKrHS84Ik5uLQUNyC9rWzad99QNtj2plmBLn9" +
       "FHT/Jk9+JYbuB5z0/Y9eedFPHanmX7wD1VzNCx+GoPPf3dHu3nfXDv7DGXW/" +
       "mSdfj6F7LSMWwuK2FnWE7BvvANn9+/7i/B/tI/uju4Ps3FEDqmjwX86A9608" +
       "+e38oP8Q3teO4P3OO7XppwCsN/bhvXHX4fFFg++eAe8P8uR3gRcFo3fMNoE9" +
       "I2/tmhNwYcoxwkIrv/dOzflxoI0f7GvlB3ffnN84o+5P8+T1GHoXUMjo8CN1" +
       "ocwjgP/zHQAsVkXgty9c3NHu3ncV4Lnz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Z9RdzAt/sJuv00DMf714hOzP7gay+/eR3X/3kT14Rt21PLl8gEw6iezclXfq" +
       "iT4EEF3fR3b9rk/VFwsIj50B7/E8eXjnifYH7sgTnXvkbsB73z689/0Fwfvg" +
       "GfDymPTc0wfwpFPwnnk78LIYevDk9cv8Ltl7b7kavrvOrP3SK1fve/QV4beL" +
       "G4iHV44v09B9YFvqHL/6cyx/bxAapl3Avry7CBQUMOAYeu4teU4QORXvXPpz" +
       "eztiFMSIb0IcQxdAepwIj6H3n0EUg+j18MdxunoMXTtNB4Qq3sfbvQA4HLUD" +
       "A7TLHG/yUSAVaJJnPxYcLCC1t7aAEGoEyrW4GDAlvwd37uSe4NA3XX8zGzi2" +
       "jXj2RPBf/O/AQaCesPtXMb76Sn/0iderP7+7wak5ynabc7mPhi7tLpMeBvtP" +
       "35HbAa97u89//8FfvvzcwcbkwZ3AR/PmmGxP3f66ZNsN4uKC4/afPfpPfvTv" +
       "v/Kt4sv8/wVKaW121DEAAA==");
}
