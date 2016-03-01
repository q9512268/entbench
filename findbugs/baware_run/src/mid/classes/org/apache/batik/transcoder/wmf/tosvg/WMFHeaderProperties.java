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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "VgfiorC2nlXmXL7U571GNovX3milKC1W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xYbJABrOGRYsrllhYkYNts+0VLqHMlS5Sy3m1mxmRRYdjsVRSWScZIIs3Eq1" +
       "q0mKzbEVKimjCmfoMF5nJE9B+yWRNt2sMhB1qCiQIySdTddaS57X7GKWpB7T" +
       "mHpO0qUgoVzr1LRqRXAQiKwzLZNJOw3cXTQMr+HMWa0JjRIqlZBWfwmmWboc" +
       "YnhtImaYNqhSQQxbujRvLttoaDR12URMstZSJKTbRNTycmxZEs7ZcWvGj029" +
       "N3AXIakPBp3SWuwpA76H4Ewf7ViIN8hoh00Eqhah6KyM6FkdRWtFtZ1USjpk" +
       "wvTIhHtNFe1ULDRdynhq1Q3EV5moO20k7To5d2Cki9QVEjiNRCewi2yZQrNW" +
       "cca3gI+hI9IMSESHEj5Eq1mthNP62PfThOfrfJBQSAkdjDJ0ykPJYCQ4XbGF" +
       "OrUKjEwb8w4UV4FnJjB2cdmh59pyiJXIWrfHhuuuUZyHbWi9YKvGqCZEcAL8" +
       "pArbhXxLmHeVGINWHGZhMNNohTS/Vmspo1AtQYH4lt8aaG49mVeDFtsyyy7O" +
       "lud1yWxyJCwmIQT1yDo17gx4GB0FtUlpPWCaFNX2cWcpyj0hShquX+r1va7V" +
       "TUvAiEYzfQT5ATlONA/taR7UjbNBWiJHGI2vGFWNF2zWSDv2co0zGsKvxTlf" +
       "nwXJHOK1stSZjPBV01Ywp400NXlB9apjSLIn0+akrmSCN6u4JhiESdjDkiqC" +
       "emQwH7lVoq26M6WENoYzeqrHk2VtArp81sB9N6lIOD5DbYSSOti8rHlJpYo5" +
       "i5DhhH6IBxzSMYwy2cFxpNHngjnmRsw0iAaTJcKxfdpsLfphLfZCPKQVM1ys" +
       "DSxUihYybhPl0Xo5bZEr1QraLUkLqzgyga0eWBw1J9MWnEQ0Z8H8yHGU9ZwP" +
       "+owoZ7PRUge+6hwCCyWyBOx51Oe50cjSlj3RVySSF8cNezkITKS6EI06WL2W" +
       "ipCMwRkR07FNZXEj4eJqI1zN4G6olKCagGgkXS8CH2NctNYD24tiD5NsMZsq" +
       "gsGtGpaUscYSwjEJLBBMcSpUGsOFtogT3dK6k67W4s1lRdaFCJuEddvwnFCY" +
       "juoo1mFm9XrTWC3CuTjrjPVJC4nghdqHx3q5PbDKYcJPiha5FNGe4CrLKFBC" +
       "R6ku5LLW01nZQBshWKbEdqbFtYVQnlfWVcrzXdmbmpliVbtlw4TMfkddh6nQ" +
       "yShnzaksPFrWIHk9mWUUVF1j9nzmidO6pa3Tvg11e0S/5kveSIMjR6xOlFUV" +
       "8hhyjJQlsYJ06GxIKm5gyEvZnBM6K6oGl5Yzrb/QlQWPyJobIEAORaU3rtTH" +
       "aBfm+AWqrBsS5CiNIJ2WEHcZz9oxXmvCWLcMKVFHQHqxNHNNSGh0pondXuqS" +
       "DKGpwdXiKht3JUrsg2WvM1LN/oji/MApzmdxZ8L2CIx3m10aBrL31VIDbSME" +
       "HbIIVaQss1xL7VJPwqcQmAXrnQqyXFl1oUn0ZXPZ7c/qJjqQxFk36qzkUiAZ" +
       "vLgWqktmYXVMvk/7DtOsrERlrlYgU5GR+rItczQDr32kGCNoi9e79WWIoCj6" +
       "5vzRNnNtj7bv2Tyqv3yuy7ThvJG3XMPT623Wke3Xm8+thSNngQ79zbEp+eD+" +
       "tu+g8MqTjmtt9kV+8j3PPKsMfqm8t9uFnW+rjTz/DbYaq/ahpu4FLT158h5Q" +
       "ZnNa7WBn82+9588eGr9l8c5rOL/y8BGcR5v8FebTv91+rfyze4WbLu9zft45" +
       "uisrPXXl7uY7AjVaBe74ij3Or7zcs5s98fluo9muZ2dH/0A6kN3xuytet5X9" +
       "Ju/YTe7n5FPyclDn3hEVXizbXqjmBxE3R6WO+xsk9gzl4J+nS9eyUz5POPdj" +
       "V5LO/4EWd6TFG0P63EGB0oZdcHKB2qZAvi/jnBMVzodqRG6PxZ3TD0i610vy" +
       "ARDMHUnzxkv2p07Je1cepVHhlkAF5I4Qy66DWL6/a7OZ4307Yu+78cQ+eEre" +
       "38+jnwYmQ1cP7VyXDsi97zrIbXbbPALCB3fkPnit5N55NdWUNiw+djXV/Hge" +
       "/UxUeBFgqIxU2Qu2o+8vD4hedZ/sKUTvzhNfUyjsvX1bd/t9Y6X4T07J+2Qe" +
       "fSIqvARIcZpvT8a8lauErLHeTQHuAc9nr5cn0NY9ZcdTufE8P3tK3ufz6Fei" +
       "wksBz85mx/MpRD91vUQfBQStHVHrxhP916fk/ds8+mJUuO9KgfKuER2l+c9v" +
       "hN4GO5rBjaf5pVPyvpxHv7HV28PyPI7nv79eni8D/NIdz/TG8/zDU/K+mke/" +
       "GxXuADxn26PkR9j93o1g964du3fdeHZfPyXvm3n0R1t282PZfe062O3vmt17" +
       "747de6+V3eiq7P7slLxv59H/2EwdgNhWP5dXOgD/83rpFQGtX9zR+8UbQ2/v" +
       "YL/qdt/yhsz3TiH6gzz6blS4ExA1MvVYpn95vUxLANMXdky/8AIy3ds7mene" +
       "ZovjX4MF3pYp5Yj68XT/5jro3psn5nPlczu6z90Yuod8my3Tu05heiGPbo8K" +
       "94KhiXu2F5CB52zPmm7KvzTa7RHLN1tvClwmv3fVDaZXkzUOSP/+jvzv3xjy" +
       "Nx0s2N0DG3MFC24h+pttbXuvOKVjXp1HDwCH3he3ZwMPiX3vwetl3gSMv7Vj" +
       "/q0XRMv3Xrmh8eQpFF+fR4+D8byhODWiBau6R5i+9noVPLdc39sx/d4NZbov" +
       "2QevPAwwVtcRLabeKjoYAY1TeuGNeVSOCi8DIyA/yGHIor05zOGou4PYea1/" +
       "ddAlV90FesWpdeCiHfN+kfxlCQ8+71VI29f3yJ999u7bHniW/8+bV2xcfsXO" +
       "7XThNm1l24fPch+6vtUPVM3Y9Nft25Pd/oYeGhUeP9PpD6Dqm++cwt7btpVb" +
       "UeHhq1SOwJBztMOV2lHh5adUAm7AwY/D9bpR4cLRegDU5vtwOQa0cFAuKty6" +
       "vThchAWoQJH8cujv6wl8tkMwqBSCdDkCUhttpLbe7il+8JCSbx/sXXXf+qFH" +
       "dK+54sHa5l1Z+w/BVtu3ZV2SP/dst/8T32380vYVJbItZlneym10fv4lf1vK" +
       "ptH8QdojJ7a239atnSd+eNfnb398/6HfXVvABwPuELaHj38fCOH40eYNHtm/" +
       "fOBX3/TLz359c97j/wGxY3J+xEwAAA==");
}
