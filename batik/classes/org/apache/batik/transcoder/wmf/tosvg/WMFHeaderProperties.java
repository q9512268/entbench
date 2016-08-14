package org.apache.batik.transcoder.wmf.tosvg;
public class WMFHeaderProperties extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFReader {
    private static final java.lang.Integer INTEGER_0 = new java.lang.Integer(
      0);
    protected java.io.DataInputStream stream;
    private int _bleft;
    private int _bright;
    private int _btop;
    private int _bbottom;
    private int _bwidth;
    private int _bheight;
    private int _ileft;
    private int _iright;
    private int _itop;
    private int _ibottom;
    private float scale = 1.0F;
    private int startX = 0;
    private int startY = 0;
    private int currentHorizAlign = 0;
    private int currentVertAlign = 0;
    private org.apache.batik.transcoder.wmf.tosvg.WMFFont wf = null;
    private static final java.awt.font.FontRenderContext fontCtx = new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    private transient boolean firstEffectivePaint = true;
    public static final int PEN = 1;
    public static final int BRUSH = 2;
    public static final int FONT = 3;
    public static final int NULL_PEN = 4;
    public static final int NULL_BRUSH = 5;
    public static final int PALETTE = 6;
    public static final int OBJ_BITMAP = 7;
    public static final int OBJ_REGION = 8;
    public WMFHeaderProperties(java.io.File wmffile) throws java.io.IOException {
        super(
          );
        reset(
          );
        stream =
          new java.io.DataInputStream(
            new java.io.BufferedInputStream(
              new java.io.FileInputStream(
                wmffile)));
        read(
          stream);
        stream.
          close(
            );
    }
    public WMFHeaderProperties() { super(); }
    public void closeResource() { try { if (stream != null)
                                            stream.
                                              close(
                                                ); }
                                  catch (java.io.IOException e) {
                                      
                                  } }
    public void setFile(java.io.File wmffile) throws java.io.IOException {
        stream =
          new java.io.DataInputStream(
            new java.io.BufferedInputStream(
              new java.io.FileInputStream(
                wmffile)));
        read(
          stream);
        stream.
          close(
            );
    }
    public void reset() { left = 0;
                          right = 0;
                          top = 1000;
                          bottom = 1000;
                          inch = 84;
                          _bleft = -1;
                          _bright = -1;
                          _btop = -1;
                          _bbottom = -1;
                          _ileft = -1;
                          _iright = -1;
                          _itop = -1;
                          _ibottom = -1;
                          _bwidth = -1;
                          _bheight = -1;
                          vpW = -1;
                          vpH = -1;
                          vpX = 0;
                          vpY = 0;
                          startX = 0;
                          startY = 0;
                          scaleXY = 1.0F;
                          firstEffectivePaint = true; }
    public java.io.DataInputStream getStream() { return stream;
    }
    protected boolean readRecords(java.io.DataInputStream is)
          throws java.io.IOException { short functionId =
                                         1;
                                       int recSize = 0;
                                       int gdiIndex;
                                       int brushObject = -1;
                                       int penObject = -1;
                                       int fontObject = -1;
                                       org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj;
                                       while (functionId >
                                                0) { recSize =
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
                                                     switch (functionId) {
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETMAPMODE:
                                                             {
                                                                 int mapmode =
                                                                   readShort(
                                                                     is);
                                                                 if (mapmode ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         MM_ANISOTROPIC)
                                                                     isotropic =
                                                                       false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETWINDOWORG:
                                                             {
                                                                 vpY =
                                                                   readShort(
                                                                     is);
                                                                 vpX =
                                                                   readShort(
                                                                     is);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETWINDOWEXT:
                                                             {
                                                                 vpH =
                                                                   readShort(
                                                                     is);
                                                                 vpW =
                                                                   readShort(
                                                                     is);
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
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEPENINDIRECT:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 int penStyle =
                                                                   readShort(
                                                                     is);
                                                                 readInt(
                                                                   is);
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
                                                                 java.awt.Color color =
                                                                   new java.awt.Color(
                                                                   red,
                                                                   green,
                                                                   blue);
                                                                 if (recSize ==
                                                                       6)
                                                                     readShort(
                                                                       is);
                                                                 if (penStyle ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         META_PS_NULL) {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         NULL_PEN,
                                                                         color,
                                                                         objIndex);
                                                                 }
                                                                 else {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         PEN,
                                                                         color,
                                                                         objIndex);
                                                                 }
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEBRUSHINDIRECT:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 int brushStyle =
                                                                   readShort(
                                                                     is);
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
                                                                 java.awt.Color color =
                                                                   new java.awt.Color(
                                                                   red,
                                                                   green,
                                                                   blue);
                                                                 readShort(
                                                                   is);
                                                                 if (brushStyle ==
                                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                                         META_PS_NULL) {
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         NULL_BRUSH,
                                                                         color,
                                                                         objIndex);
                                                                 }
                                                                 else
                                                                     objIndex =
                                                                       addObjectAt(
                                                                         BRUSH,
                                                                         color,
                                                                         objIndex);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SETTEXTALIGN:
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
                                                             currentHorizAlign =
                                                               org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                 getHorizontalAlignment(
                                                                   align);
                                                             currentVertAlign =
                                                               org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                 getVerticalAlignment(
                                                                   align);
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_EXTTEXTOUT:
                                                             {
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
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
                                                                            scaleXY);
                                                                     y1 =
                                                                       readShort(
                                                                         is);
                                                                     x2 =
                                                                       (int)
                                                                         (readShort(
                                                                            is) *
                                                                            scaleXY);
                                                                     y2 =
                                                                       readShort(
                                                                         is);
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
                                                                 java.lang.String sr =
                                                                   org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                   decodeString(
                                                                     wf,
                                                                     bstr);
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
                                                                 java.awt.font.TextLayout layout =
                                                                   new java.awt.font.TextLayout(
                                                                   sr,
                                                                   wf.
                                                                     font,
                                                                   fontCtx);
                                                                 int lfWidth =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getWidth(
                                                                       );
                                                                 x =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getX(
                                                                       );
                                                                 int lfHeight =
                                                                   (int)
                                                                     getVerticalAlignmentValue(
                                                                       layout,
                                                                       currentVertAlign);
                                                                 resizeBounds(
                                                                   x,
                                                                   y);
                                                                 resizeBounds(
                                                                   x +
                                                                     lfWidth,
                                                                   y +
                                                                     lfHeight);
                                                                 firstEffectivePaint =
                                                                   false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DRAWTEXT:
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
                                                                 java.lang.String sr =
                                                                   org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                                                                   decodeString(
                                                                     wf,
                                                                     bstr);
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
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
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
                                                                 java.awt.font.TextLayout layout =
                                                                   new java.awt.font.TextLayout(
                                                                   sr,
                                                                   wf.
                                                                     font,
                                                                   fontCtx);
                                                                 int lfWidth =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getWidth(
                                                                       );
                                                                 x =
                                                                   (int)
                                                                     layout.
                                                                     getBounds(
                                                                       ).
                                                                     getX(
                                                                       );
                                                                 int lfHeight =
                                                                   (int)
                                                                     getVerticalAlignmentValue(
                                                                       layout,
                                                                       currentVertAlign);
                                                                 resizeBounds(
                                                                   x,
                                                                   y);
                                                                 resizeBounds(
                                                                   x +
                                                                     lfWidth,
                                                                   y +
                                                                     lfHeight);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEFONTINDIRECT:
                                                             {
                                                                 int lfHeight =
                                                                   readShort(
                                                                     is);
                                                                 float size =
                                                                   (int)
                                                                     (scaleY *
                                                                        lfHeight);
                                                                 int lfWidth =
                                                                   readShort(
                                                                     is);
                                                                 int escape =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int orient =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int weight =
                                                                   (int)
                                                                     readShort(
                                                                       is);
                                                                 int italic =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int underline =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int strikeOut =
                                                                   (int)
                                                                     is.
                                                                     readByte(
                                                                       );
                                                                 int charset =
                                                                   (int)
                                                                     (is.
                                                                        readByte(
                                                                          ) &
                                                                        255);
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
                                                                 int style =
                                                                   italic >
                                                                   0
                                                                   ? java.awt.Font.
                                                                       ITALIC
                                                                   : java.awt.Font.
                                                                       PLAIN;
                                                                 style |=
                                                                   weight >
                                                                     400
                                                                     ? java.awt.Font.
                                                                         BOLD
                                                                     : java.awt.Font.
                                                                         PLAIN;
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
                                                                 java.lang.String face =
                                                                   new java.lang.String(
                                                                   lfFaceName);
                                                                 int d =
                                                                   0;
                                                                 while (d <
                                                                          face.
                                                                          length(
                                                                            ) &&
                                                                          (java.lang.Character.
                                                                             isLetterOrDigit(
                                                                               face.
                                                                                 charAt(
                                                                                   d)) ||
                                                                             java.lang.Character.
                                                                             isWhitespace(
                                                                               face.
                                                                                 charAt(
                                                                                   d))))
                                                                     d++;
                                                                 if (d >
                                                                       0)
                                                                     face =
                                                                       face.
                                                                         substring(
                                                                           0,
                                                                           d);
                                                                 else
                                                                     face =
                                                                       "System";
                                                                 if (size <
                                                                       0)
                                                                     size =
                                                                       -size;
                                                                 int objIndex =
                                                                   0;
                                                                 java.awt.Font f =
                                                                   new java.awt.Font(
                                                                   face,
                                                                   style,
                                                                   (int)
                                                                     size);
                                                                 f =
                                                                   f.
                                                                     deriveFont(
                                                                       size);
                                                                 org.apache.batik.transcoder.wmf.tosvg.WMFFont wf =
                                                                   new org.apache.batik.transcoder.wmf.tosvg.WMFFont(
                                                                   f,
                                                                   charset,
                                                                   underline,
                                                                   strikeOut,
                                                                   italic,
                                                                   weight,
                                                                   orient,
                                                                   escape);
                                                                 objIndex =
                                                                   addObjectAt(
                                                                     FONT,
                                                                     wf,
                                                                     objIndex);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEREGION:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 for (int j =
                                                                        0;
                                                                      j <
                                                                        recSize;
                                                                      j++)
                                                                     readShort(
                                                                       is);
                                                                 objIndex =
                                                                   addObjectAt(
                                                                     PALETTE,
                                                                     INTEGER_0,
                                                                     0);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CREATEPALETTE:
                                                             {
                                                                 int objIndex =
                                                                   0;
                                                                 for (int j =
                                                                        0;
                                                                      j <
                                                                        recSize;
                                                                      j++)
                                                                     readShort(
                                                                       is);
                                                                 objIndex =
                                                                   addObjectAt(
                                                                     OBJ_REGION,
                                                                     INTEGER_0,
                                                                     0);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_SELECTOBJECT:
                                                             gdiIndex =
                                                               readShort(
                                                                 is);
                                                             if ((gdiIndex &
                                                                    -2147483648) !=
                                                                   0)
                                                                 break;
                                                             gdiObj =
                                                               getObject(
                                                                 gdiIndex);
                                                             if (!gdiObj.
                                                                    used)
                                                                 break;
                                                             switch (gdiObj.
                                                                       type) {
                                                                 case PEN:
                                                                     penObject =
                                                                       gdiIndex;
                                                                     break;
                                                                 case BRUSH:
                                                                     brushObject =
                                                                       gdiIndex;
                                                                     break;
                                                                 case FONT:
                                                                     {
                                                                         this.
                                                                           wf =
                                                                           (org.apache.batik.transcoder.wmf.tosvg.WMFFont)
                                                                             gdiObj.
                                                                               obj;
                                                                         fontObject =
                                                                           gdiIndex;
                                                                     }
                                                                     break;
                                                                 case NULL_PEN:
                                                                     penObject =
                                                                       -1;
                                                                     break;
                                                                 case NULL_BRUSH:
                                                                     brushObject =
                                                                       -1;
                                                                     break;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DELETEOBJECT:
                                                             gdiIndex =
                                                               readShort(
                                                                 is);
                                                             gdiObj =
                                                               getObject(
                                                                 gdiIndex);
                                                             if (gdiIndex ==
                                                                   brushObject)
                                                                 brushObject =
                                                                   -1;
                                                             else
                                                                 if (gdiIndex ==
                                                                       penObject)
                                                                     penObject =
                                                                       -1;
                                                                 else
                                                                     if (gdiIndex ==
                                                                           fontObject)
                                                                         fontObject =
                                                                           -1;
                                                             gdiObj.
                                                               clear(
                                                                 );
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_LINETO:
                                                             {
                                                                 int y =
                                                                   readShort(
                                                                     is);
                                                                 int x =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 if (penObject >=
                                                                       0) {
                                                                     resizeBounds(
                                                                       startX,
                                                                       startY);
                                                                     resizeBounds(
                                                                       x,
                                                                       y);
                                                                     firstEffectivePaint =
                                                                       false;
                                                                 }
                                                                 startX =
                                                                   x;
                                                                 startY =
                                                                   y;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_MOVETO:
                                                             {
                                                                 startY =
                                                                   readShort(
                                                                     is);
                                                                 startX =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYPOLYGON:
                                                             {
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
                                                                 int offset =
                                                                   count +
                                                                   1;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     for (int j =
                                                                            0;
                                                                          j <
                                                                            pts[i];
                                                                          j++) {
                                                                         int x =
                                                                           (int)
                                                                             (readShort(
                                                                                is) *
                                                                                scaleXY);
                                                                         int y =
                                                                           readShort(
                                                                             is);
                                                                         if (brushObject >=
                                                                               0 ||
                                                                               penObject >=
                                                                               0)
                                                                             resizeBounds(
                                                                               x,
                                                                               y);
                                                                     }
                                                                 }
                                                                 firstEffectivePaint =
                                                                   false;
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYGON:
                                                             {
                                                                 int count =
                                                                   readShort(
                                                                     is);
                                                                 float[] _xpts =
                                                                   new float[count +
                                                                               1];
                                                                 float[] _ypts =
                                                                   new float[count +
                                                                               1];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     _xpts[i] =
                                                                       readShort(
                                                                         is) *
                                                                         scaleXY;
                                                                     _ypts[i] =
                                                                       readShort(
                                                                         is);
                                                                 }
                                                                 _xpts[count] =
                                                                   _xpts[0];
                                                                 _ypts[count] =
                                                                   _ypts[0];
                                                                 org.apache.batik.ext.awt.geom.Polygon2D pol =
                                                                   new org.apache.batik.ext.awt.geom.Polygon2D(
                                                                   _xpts,
                                                                   _ypts,
                                                                   count);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   pol);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_POLYLINE:
                                                             {
                                                                 int count =
                                                                   readShort(
                                                                     is);
                                                                 float[] _xpts =
                                                                   new float[count];
                                                                 float[] _ypts =
                                                                   new float[count];
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        count;
                                                                      i++) {
                                                                     _xpts[i] =
                                                                       readShort(
                                                                         is) *
                                                                         scaleXY;
                                                                     _ypts[i] =
                                                                       readShort(
                                                                         is);
                                                                 }
                                                                 org.apache.batik.ext.awt.geom.Polyline2D pol =
                                                                   new org.apache.batik.ext.awt.geom.Polyline2D(
                                                                   _xpts,
                                                                   _ypts,
                                                                   count);
                                                                 paintWithPen(
                                                                   penObject,
                                                                   pol);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ELLIPSE:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_INTERSECTCLIPRECT:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_RECTANGLE:
                                                             {
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ROUNDRECT:
                                                             {
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_ARC:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_CHORD:
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_PIE:
                                                             {
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 int bot =
                                                                   readShort(
                                                                     is);
                                                                 int right =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 java.awt.geom.Rectangle2D.Float rec =
                                                                   new java.awt.geom.Rectangle2D.Float(
                                                                   left,
                                                                   top,
                                                                   right -
                                                                     left,
                                                                   bot -
                                                                     top);
                                                                 paint(
                                                                   brushObject,
                                                                   penObject,
                                                                   rec);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_PATBLT:
                                                             {
                                                                 readInt(
                                                                   is);
                                                                 int height =
                                                                   readShort(
                                                                     is);
                                                                 int width =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int left =
                                                                   (int)
                                                                     (readShort(
                                                                        is) *
                                                                        scaleXY);
                                                                 int top =
                                                                   readShort(
                                                                     is);
                                                                 if (penObject >=
                                                                       0)
                                                                     resizeBounds(
                                                                       left,
                                                                       top);
                                                                 if (penObject >=
                                                                       0)
                                                                     resizeBounds(
                                                                       left +
                                                                         width,
                                                                       top +
                                                                         height);
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DIBSTRETCHBLT:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float heightDst =
                                                                   (float)
                                                                     readShort(
                                                                       is);
                                                                 float widthDst =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH;
                                                                 float dx =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   scaleXY;
                                                                 widthDst =
                                                                   widthDst *
                                                                     getVpWFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 heightDst =
                                                                   heightDst *
                                                                     getVpHFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        widthDst),
                                                                   (int)
                                                                     (dy +
                                                                        heightDst));
                                                                 int len =
                                                                   2 *
                                                                   recSize -
                                                                   20;
                                                                 for (int i =
                                                                        0;
                                                                      i <
                                                                        len;
                                                                      i++)
                                                                     is.
                                                                       readByte(
                                                                         );
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_STRETCHDIB:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float heightDst =
                                                                   (float)
                                                                     readShort(
                                                                       is);
                                                                 float widthDst =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH;
                                                                 float dx =
                                                                   (float)
                                                                     readShort(
                                                                       is) *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   scaleXY;
                                                                 widthDst =
                                                                   widthDst *
                                                                     getVpWFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 heightDst =
                                                                   heightDst *
                                                                     getVpHFactor(
                                                                       ) *
                                                                     (float)
                                                                       inch /
                                                                     PIXEL_PER_INCH;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        widthDst),
                                                                   (int)
                                                                     (dy +
                                                                        heightDst));
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
                                                             }
                                                             break;
                                                         case org.apache.batik.transcoder.wmf.WMFConstants.
                                                                META_DIBBITBLT:
                                                             {
                                                                 is.
                                                                   readInt(
                                                                     );
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 readShort(
                                                                   is);
                                                                 float height =
                                                                   readShort(
                                                                     is) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpHFactor(
                                                                     );
                                                                 float width =
                                                                   readShort(
                                                                     is) *
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   scaleXY;
                                                                 float dy =
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpHFactor(
                                                                     ) *
                                                                   readShort(
                                                                     is);
                                                                 float dx =
                                                                   (float)
                                                                     inch /
                                                                   PIXEL_PER_INCH *
                                                                   getVpWFactor(
                                                                     ) *
                                                                   readShort(
                                                                     is) *
                                                                   scaleXY;
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     dx,
                                                                   (int)
                                                                     dy);
                                                                 resizeImageBounds(
                                                                   (int)
                                                                     (dx +
                                                                        width),
                                                                   (int)
                                                                     (dy +
                                                                        height));
                                                             }
                                                             break;
                                                         default:
                                                             for (int j =
                                                                    0;
                                                                  j <
                                                                    recSize;
                                                                  j++)
                                                                 readShort(
                                                                   is);
                                                             break;
                                                     }
                                       }
                                       if (!isAldus) {
                                           width =
                                             vpW;
                                           height =
                                             vpH;
                                           right =
                                             vpX;
                                           left =
                                             vpX +
                                               vpW;
                                           top =
                                             vpY;
                                           bottom =
                                             vpY +
                                               vpH;
                                       }
                                       resetBounds(
                                         );
                                       return true;
    }
    public int getWidthBoundsPixels() { return _bwidth;
    }
    public int getHeightBoundsPixels() { return _bheight;
    }
    public int getWidthBoundsUnits() { return (int)
                                                ((float)
                                                   inch *
                                                   (float)
                                                     _bwidth /
                                                   PIXEL_PER_INCH);
    }
    public int getHeightBoundsUnits() { return (int)
                                                 ((float)
                                                    inch *
                                                    (float)
                                                      _bheight /
                                                    PIXEL_PER_INCH);
    }
    public int getXOffset() { return _bleft;
    }
    public int getYOffset() { return _btop;
    }
    private void resetBounds() { scale = (float)
                                           getWidthPixels(
                                             ) /
                                           (float)
                                             vpW;
                                 if (_bright !=
                                       -1) {
                                     _bright =
                                       (int)
                                         (scale *
                                            (vpX +
                                               _bright));
                                     _bleft =
                                       (int)
                                         (scale *
                                            (vpX +
                                               _bleft));
                                     _bbottom =
                                       (int)
                                         (scale *
                                            (vpY +
                                               _bbottom));
                                     _btop =
                                       (int)
                                         (scale *
                                            (vpY +
                                               _btop));
                                 }
                                 if (_iright !=
                                       -1) {
                                     _iright =
                                       (int)
                                         ((float)
                                            _iright *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _ileft =
                                       (int)
                                         ((float)
                                            _ileft *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _ibottom =
                                       (int)
                                         ((float)
                                            _ibottom *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     _itop =
                                       (int)
                                         ((float)
                                            _itop *
                                            (float)
                                              getWidthPixels(
                                                ) /
                                            (float)
                                              width);
                                     if (_bright ==
                                           -1 ||
                                           _iright >
                                           _bright)
                                         _bright =
                                           _iright;
                                     if (_bleft ==
                                           -1 ||
                                           _ileft <
                                           _bleft)
                                         _bleft =
                                           _ileft;
                                     if (_btop ==
                                           -1 ||
                                           _itop <
                                           _btop)
                                         _btop =
                                           _itop;
                                     if (_bbottom ==
                                           -1 ||
                                           _ibottom >
                                           _bbottom)
                                         _bbottom =
                                           _ibottom;
                                 }
                                 if (_bleft !=
                                       -1 &&
                                       _bright !=
                                       -1)
                                     _bwidth =
                                       _bright -
                                         _bleft;
                                 if (_btop !=
                                       -1 &&
                                       _bbottom !=
                                       -1)
                                     _bheight =
                                       _bbottom -
                                         _btop;
    }
    private void resizeBounds(int x, int y) {
        if (_bleft ==
              -1)
            _bleft =
              x;
        else
            if (x <
                  _bleft)
                _bleft =
                  x;
        if (_bright ==
              -1)
            _bright =
              x;
        else
            if (x >
                  _bright)
                _bright =
                  x;
        if (_btop ==
              -1)
            _btop =
              y;
        else
            if (y <
                  _btop)
                _btop =
                  y;
        if (_bbottom ==
              -1)
            _bbottom =
              y;
        else
            if (y >
                  _bbottom)
                _bbottom =
                  y;
    }
    private void resizeImageBounds(int x,
                                   int y) {
        if (_ileft ==
              -1)
            _ileft =
              x;
        else
            if (x <
                  _ileft)
                _ileft =
                  x;
        if (_iright ==
              -1)
            _iright =
              x;
        else
            if (x >
                  _iright)
                _iright =
                  x;
        if (_itop ==
              -1)
            _itop =
              y;
        else
            if (y <
                  _itop)
                _itop =
                  y;
        if (_ibottom ==
              -1)
            _ibottom =
              y;
        else
            if (y >
                  _ibottom)
                _ibottom =
                  y;
    }
    private java.awt.Color getColorFromObject(int brushObject) {
        java.awt.Color color =
          null;
        if (brushObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              getObject(
                brushObject);
            return (java.awt.Color)
                     gdiObj.
                       obj;
        }
        else
            return null;
    }
    private void paint(int brushObject, int penObject,
                       java.awt.Shape shape) {
        if (brushObject >=
              0 ||
              penObject >=
              0) {
            java.awt.Color col;
            if (brushObject >=
                  0)
                col =
                  getColorFromObject(
                    brushObject);
            else
                col =
                  getColorFromObject(
                    penObject);
            if (!(firstEffectivePaint &&
                    col.
                    equals(
                      java.awt.Color.
                        white))) {
                java.awt.Rectangle rec =
                  shape.
                  getBounds(
                    );
                resizeBounds(
                  (int)
                    rec.
                    getMinX(
                      ),
                  (int)
                    rec.
                    getMinY(
                      ));
                resizeBounds(
                  (int)
                    rec.
                    getMaxX(
                      ),
                  (int)
                    rec.
                    getMaxY(
                      ));
                firstEffectivePaint =
                  false;
            }
        }
    }
    private void paintWithPen(int penObject,
                              java.awt.Shape shape) {
        if (penObject >=
              0) {
            java.awt.Color col =
              getColorFromObject(
                penObject);
            if (!(firstEffectivePaint &&
                    col.
                    equals(
                      java.awt.Color.
                        white))) {
                java.awt.Rectangle rec =
                  shape.
                  getBounds(
                    );
                resizeBounds(
                  (int)
                    rec.
                    getMinX(
                      ),
                  (int)
                    rec.
                    getMinY(
                      ));
                resizeBounds(
                  (int)
                    rec.
                    getMaxX(
                      ),
                  (int)
                    rec.
                    getMaxY(
                      ));
                firstEffectivePaint =
                  false;
            }
        }
    }
    private float getVerticalAlignmentValue(java.awt.font.TextLayout layout,
                                            int vertAlign) {
        if (vertAlign ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BASELINE)
            return -layout.
              getAscent(
                );
        else
            if (vertAlign ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_TOP)
                return layout.
                  getAscent(
                    ) +
                  layout.
                  getDescent(
                    );
            else
                return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9IBj63UD1MOGRbbcMCm9ua570kxek+Nm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "4EwAAA==");
}
