package org.apache.batik.transcoder.wmf.tosvg;
public class WMFPainter extends org.apache.batik.transcoder.wmf.tosvg.AbstractWMFPainter {
    private static final int INPUT_BUFFER_SIZE = 30720;
    private static final java.lang.Integer INTEGER_0 = new java.lang.Integer(
      0);
    private float scale;
    private float scaleX;
    private float scaleY;
    private float conv;
    private float xOffset;
    private float yOffset;
    private float vpX;
    private float vpY;
    private float vpW;
    private float vpH;
    private java.awt.Color frgdColor;
    private java.awt.Color bkgdColor;
    private boolean opaque = false;
    private transient boolean firstEffectivePaint = true;
    private static java.awt.BasicStroke solid = new java.awt.BasicStroke(
      1.0F,
      java.awt.BasicStroke.
        CAP_BUTT,
      java.awt.BasicStroke.
        JOIN_ROUND);
    private static java.awt.BasicStroke textSolid = new java.awt.BasicStroke(
      1.0F,
      java.awt.BasicStroke.
        CAP_BUTT,
      java.awt.BasicStroke.
        JOIN_ROUND);
    private transient java.awt.image.ImageObserver observer = new java.awt.image.ImageObserver(
      ) {
        public boolean imageUpdate(java.awt.Image img,
                                   int flags,
                                   int x,
                                   int y,
                                   int width,
                                   int height) {
            return false;
        }
    };
    public WMFPainter(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                      float scale) { this(currentStore, 0,
                                          0,
                                          scale); }
    public WMFPainter(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                      int xOffset,
                      int yOffset,
                      float scale) { super();
                                     setRecordStore(
                                       currentStore);
                                     org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                       getInstance(
                                         ).
                                       reset(
                                         );
                                     this.
                                       conv =
                                       scale;
                                     this.
                                       xOffset =
                                       -xOffset;
                                     this.
                                       yOffset =
                                       -yOffset;
                                     this.
                                       scale =
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           ) /
                                         (float)
                                           currentStore.
                                           getWidthUnits(
                                             ) *
                                         scale;
                                     this.
                                       scale =
                                       this.
                                         scale *
                                         (float)
                                           currentStore.
                                           getWidthPixels(
                                             ) /
                                         (float)
                                           currentStore.
                                           getVpW(
                                             );
                                     float xfactor =
                                       (float)
                                         currentStore.
                                         getVpW(
                                           ) /
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           ) *
                                       (float)
                                         currentStore.
                                         getWidthUnits(
                                           ) /
                                       (float)
                                         currentStore.
                                         getWidthPixels(
                                           );
                                     float yfactor =
                                       (float)
                                         currentStore.
                                         getVpH(
                                           ) /
                                       (float)
                                         currentStore.
                                         getHeightPixels(
                                           ) *
                                       (float)
                                         currentStore.
                                         getHeightUnits(
                                           ) /
                                       (float)
                                         currentStore.
                                         getHeightPixels(
                                           );
                                     this.
                                       xOffset =
                                       this.
                                         xOffset *
                                         xfactor;
                                     this.
                                       yOffset =
                                       this.
                                         yOffset *
                                         yfactor;
                                     scaleX =
                                       this.
                                         scale;
                                     scaleY =
                                       this.
                                         scale;
    }
    public void paint(java.awt.Graphics g) {
        float fontHeight =
          10;
        float fontAngle =
          0;
        float penWidth =
          0;
        float startX =
          0;
        float startY =
          0;
        int brushObject =
          -1;
        int penObject =
          -1;
        int fontObject =
          -1;
        java.awt.Font font =
          null;
        int lastObjectIdx;
        java.util.Stack dcStack =
          new java.util.Stack(
          );
        int numRecords =
          currentStore.
          getNumRecords(
            );
        int numObjects =
          currentStore.
          getNumObjects(
            );
        vpX =
          currentStore.
            getVpX(
              ) *
            scale;
        vpY =
          currentStore.
            getVpY(
              ) *
            scale;
        vpW =
          currentStore.
            getVpW(
              ) *
            scale;
        vpH =
          currentStore.
            getVpH(
              ) *
            scale;
        if (!currentStore.
              isReading(
                )) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj;
            int gdiIndex;
            g.
              setPaintMode(
                );
            java.awt.Graphics2D g2d =
              (java.awt.Graphics2D)
                g;
            g2d.
              setStroke(
                solid);
            brushObject =
              -1;
            penObject =
              -1;
            fontObject =
              -1;
            frgdColor =
              null;
            bkgdColor =
              java.awt.Color.
                white;
            for (int i =
                   0;
                 i <
                   numObjects;
                 i++) {
                gdiObj =
                  currentStore.
                    getObject(
                      i);
                gdiObj.
                  clear(
                    );
            }
            float w =
              vpW;
            float h =
              vpH;
            g2d.
              setColor(
                java.awt.Color.
                  black);
            for (int iRec =
                   0;
                 iRec <
                   numRecords;
                 iRec++) {
                org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr =
                  currentStore.
                  getRecord(
                    iRec);
                switch (mr.
                          functionId) {
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWORG:
                        currentStore.
                          setVpX(
                            vpX =
                              -((float)
                                  mr.
                                  elementAt(
                                    0)));
                        currentStore.
                          setVpY(
                            vpY =
                              -((float)
                                  mr.
                                  elementAt(
                                    1)));
                        vpX =
                          vpX *
                            scale;
                        vpY =
                          vpY *
                            scale;
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWORG_EX:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETWINDOWEXT:
                        vpW =
                          (float)
                            mr.
                            elementAt(
                              0);
                        vpH =
                          (float)
                            mr.
                            elementAt(
                              1);
                        scaleX =
                          scale;
                        scaleY =
                          scale;
                        solid =
                          new java.awt.BasicStroke(
                            scaleX *
                              2,
                            java.awt.BasicStroke.
                              CAP_BUTT,
                            java.awt.BasicStroke.
                              JOIN_ROUND);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETVIEWPORTORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETVIEWPORTEXT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETWINDOWORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SCALEWINDOWEXT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETVIEWPORTORG:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SCALEVIEWPORTEXT:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPOLYFILLMODE:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPENINDIRECT:
                        {
                            int objIndex =
                              0;
                            int penStyle =
                              mr.
                              elementAt(
                                0);
                            java.awt.Color newClr;
                            if (penStyle ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_PS_NULL) {
                                newClr =
                                  java.awt.Color.
                                    white;
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    NULL_PEN,
                                    newClr,
                                    objIndex);
                            }
                            else {
                                penWidth =
                                  mr.
                                    elementAt(
                                      4);
                                setStroke(
                                  g2d,
                                  penStyle,
                                  penWidth,
                                  scaleX);
                                newClr =
                                  new java.awt.Color(
                                    mr.
                                      elementAt(
                                        1),
                                    mr.
                                      elementAt(
                                        2),
                                    mr.
                                      elementAt(
                                        3));
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    PEN,
                                    newClr,
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
                              mr.
                              elementAt(
                                0);
                            java.awt.Color clr =
                              new java.awt.Color(
                              mr.
                                elementAt(
                                  1),
                              mr.
                                elementAt(
                                  2),
                              mr.
                                elementAt(
                                  3));
                            if (brushStyle ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    BS_SOLID) {
                                objIndex =
                                  addObjectAt(
                                    currentStore,
                                    BRUSH,
                                    clr,
                                    objIndex);
                            }
                            else
                                if (brushStyle ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        BS_HATCHED) {
                                    int hatch =
                                      mr.
                                      elementAt(
                                        4);
                                    java.awt.Paint paint;
                                    if (!opaque)
                                        paint =
                                          org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                            getInstance(
                                              ).
                                            getTexture(
                                              hatch,
                                              clr);
                                    else
                                        paint =
                                          org.apache.batik.transcoder.wmf.tosvg.TextureFactory.
                                            getInstance(
                                              ).
                                            getTexture(
                                              hatch,
                                              clr,
                                              bkgdColor);
                                    if (paint !=
                                          null)
                                        objIndex =
                                          addObjectAt(
                                            currentStore,
                                            BRUSH,
                                            paint,
                                            objIndex);
                                    else {
                                        clr =
                                          java.awt.Color.
                                            black;
                                        objIndex =
                                          addObjectAt(
                                            currentStore,
                                            NULL_BRUSH,
                                            clr,
                                            objIndex);
                                    }
                                }
                                else {
                                    clr =
                                      java.awt.Color.
                                        black;
                                    objIndex =
                                      addObjectAt(
                                        currentStore,
                                        NULL_BRUSH,
                                        clr,
                                        objIndex);
                                }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEFONTINDIRECT:
                        {
                            float size =
                              (int)
                                (scaleY *
                                   mr.
                                   elementAt(
                                     0));
                            int charset =
                              mr.
                              elementAt(
                                3);
                            int italic =
                              mr.
                              elementAt(
                                1);
                            int weight =
                              mr.
                              elementAt(
                                2);
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
                            java.lang.String face =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord)
                                 mr).
                                text;
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
                            fontHeight =
                              size;
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
                            int underline =
                              mr.
                              elementAt(
                                4);
                            int strikeOut =
                              mr.
                              elementAt(
                                5);
                            int orient =
                              mr.
                              elementAt(
                                6);
                            int escape =
                              mr.
                              elementAt(
                                7);
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
                                currentStore,
                                FONT,
                                wf,
                                objIndex);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBRUSH:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPATTERNBRUSH:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBITMAPINDIRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEBITMAP:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEREGION:
                        {
                            int objIndex =
                              addObjectAt(
                                currentStore,
                                PALETTE,
                                INTEGER_0,
                                0);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CREATEPALETTE:
                        {
                            int objIndex =
                              addObjectAt(
                                currentStore,
                                OBJ_REGION,
                                INTEGER_0,
                                0);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_REALIZEPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ANIMATEPALETTE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPALENTRIES:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RESIZEPALETTE:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTOBJECT:
                        gdiIndex =
                          mr.
                            elementAt(
                              0);
                        if ((gdiIndex &
                               -2147483648) !=
                              0)
                            break;
                        if (gdiIndex >=
                              numObjects) {
                            gdiIndex -=
                              numObjects;
                            switch (gdiIndex) {
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_NULL_BRUSH:
                                    brushObject =
                                      -1;
                                    break;
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_NULL_PEN:
                                    penObject =
                                      -1;
                                    break;
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_WHITE_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_LTGRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_GRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DKGRAY_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_BLACK_BRUSH:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_WHITE_PEN:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_BLACK_PEN:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_OEM_FIXED_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_ANSI_FIXED_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_ANSI_VAR_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_SYSTEM_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DEVICE_DEFAULT_FONT:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_DEFAULT_PALETTE:
                                case org.apache.batik.transcoder.wmf.WMFConstants.
                                       META_OBJ_SYSTEM_FIXED_FONT:
                                    break;
                            }
                            break;
                        }
                        gdiObj =
                          currentStore.
                            getObject(
                              gdiIndex);
                        if (!gdiObj.
                               used)
                            break;
                        switch (gdiObj.
                                  type) {
                            case PEN:
                                g2d.
                                  setColor(
                                    (java.awt.Color)
                                      gdiObj.
                                        obj);
                                penObject =
                                  gdiIndex;
                                break;
                            case BRUSH:
                                if (gdiObj.
                                      obj instanceof java.awt.Color)
                                    g2d.
                                      setColor(
                                        (java.awt.Color)
                                          gdiObj.
                                            obj);
                                else
                                    if (gdiObj.
                                          obj instanceof java.awt.Paint) {
                                        g2d.
                                          setPaint(
                                            (java.awt.Paint)
                                              gdiObj.
                                                obj);
                                    }
                                    else
                                        g2d.
                                          setPaint(
                                            getPaint(
                                              (byte[])
                                                gdiObj.
                                                  obj));
                                brushObject =
                                  gdiIndex;
                                break;
                            case FONT:
                                {
                                    this.
                                      wmfFont =
                                      (org.apache.batik.transcoder.wmf.tosvg.WMFFont)
                                        gdiObj.
                                          obj;
                                    java.awt.Font f =
                                      this.
                                        wmfFont.
                                        font;
                                    g2d.
                                      setFont(
                                        f);
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
                          mr.
                            elementAt(
                              0);
                        gdiObj =
                          currentStore.
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
                           META_POLYPOLYGON:
                        {
                            int numPolygons =
                              mr.
                              elementAt(
                                0);
                            int[] pts =
                              new int[numPolygons];
                            for (int ip =
                                   0;
                                 ip <
                                   numPolygons;
                                 ip++)
                                pts[ip] =
                                  mr.
                                    elementAt(
                                      ip +
                                        1);
                            int offset =
                              numPolygons +
                              1;
                            java.util.List v =
                              new java.util.ArrayList(
                              numPolygons);
                            for (int j =
                                   0;
                                 j <
                                   numPolygons;
                                 j++) {
                                int count =
                                  pts[j];
                                float[] xpts =
                                  new float[count];
                                float[] ypts =
                                  new float[count];
                                for (int k =
                                       0;
                                     k <
                                       count;
                                     k++) {
                                    xpts[k] =
                                      scaleX *
                                        (vpX +
                                           xOffset +
                                           mr.
                                           elementAt(
                                             offset +
                                               k *
                                               2));
                                    ypts[k] =
                                      scaleY *
                                        (vpY +
                                           yOffset +
                                           mr.
                                           elementAt(
                                             offset +
                                               k *
                                               2 +
                                               1));
                                }
                                offset +=
                                  count *
                                    2;
                                org.apache.batik.ext.awt.geom.Polygon2D pol =
                                  new org.apache.batik.ext.awt.geom.Polygon2D(
                                  xpts,
                                  ypts,
                                  count);
                                v.
                                  add(
                                    pol);
                            }
                            if (brushObject >=
                                  0) {
                                setBrushPaint(
                                  currentStore,
                                  g2d,
                                  brushObject);
                                fillPolyPolygon(
                                  g2d,
                                  v);
                                firstEffectivePaint =
                                  false;
                            }
                            if (penObject >=
                                  0) {
                                setPenColor(
                                  currentStore,
                                  g2d,
                                  penObject);
                                drawPolyPolygon(
                                  g2d,
                                  v);
                                firstEffectivePaint =
                                  false;
                            }
                            break;
                        }
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYGON:
                        {
                            int count =
                              mr.
                              elementAt(
                                0);
                            float[] _xpts =
                              new float[count];
                            float[] _ypts =
                              new float[count];
                            for (int k =
                                   0;
                                 k <
                                   count;
                                 k++) {
                                _xpts[k] =
                                  scaleX *
                                    (vpX +
                                       xOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           1));
                                _ypts[k] =
                                  scaleY *
                                    (vpY +
                                       yOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           2));
                            }
                            org.apache.batik.ext.awt.geom.Polygon2D pol =
                              new org.apache.batik.ext.awt.geom.Polygon2D(
                              _xpts,
                              _ypts,
                              count);
                            paint(
                              brushObject,
                              penObject,
                              pol,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_MOVETO:
                        startX =
                          scaleX *
                            (vpX +
                               xOffset +
                               mr.
                               elementAt(
                                 0));
                        startY =
                          scaleY *
                            (vpY +
                               yOffset +
                               mr.
                               elementAt(
                                 1));
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_LINETO:
                        {
                            float endX =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float endY =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            java.awt.geom.Line2D.Float line =
                              new java.awt.geom.Line2D.Float(
                              startX,
                              startY,
                              endX,
                              endY);
                            paintWithPen(
                              penObject,
                              line,
                              g2d);
                            startX =
                              endX;
                            startY =
                              endY;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYLINE:
                        {
                            int count =
                              mr.
                              elementAt(
                                0);
                            float[] _xpts =
                              new float[count];
                            float[] _ypts =
                              new float[count];
                            for (int k =
                                   0;
                                 k <
                                   count;
                                 k++) {
                                _xpts[k] =
                                  scaleX *
                                    (vpX +
                                       xOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           1));
                                _ypts[k] =
                                  scaleY *
                                    (vpY +
                                       yOffset +
                                       mr.
                                       elementAt(
                                         k *
                                           2 +
                                           2));
                            }
                            org.apache.batik.ext.awt.geom.Polyline2D pol =
                              new org.apache.batik.ext.awt.geom.Polyline2D(
                              _xpts,
                              _ypts,
                              count);
                            paintWithPen(
                              penObject,
                              pol,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RECTANGLE:
                        {
                            float x1;
                            float y1;
                            float x2;
                            float y2;
                            x1 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            x2 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            y1 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            y2 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            java.awt.geom.Rectangle2D.Float rec =
                              new java.awt.geom.Rectangle2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1);
                            paint(
                              brushObject,
                              penObject,
                              rec,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ROUNDRECT:
                        {
                            float x1;
                            float y1;
                            float x2;
                            float y2;
                            float x3;
                            float y3;
                            x1 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            x2 =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            x3 =
                              scaleX *
                                (float)
                                  mr.
                                  elementAt(
                                    4);
                            y1 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            y2 =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            y3 =
                              scaleY *
                                (float)
                                  mr.
                                  elementAt(
                                    5);
                            java.awt.geom.RoundRectangle2D rec =
                              new java.awt.geom.RoundRectangle2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1,
                              x3,
                              y3);
                            paint(
                              brushObject,
                              penObject,
                              rec,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ELLIPSE:
                        {
                            float x1 =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float x2 =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   2));
                            float y1 =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            float y2 =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   3));
                            java.awt.geom.Ellipse2D.Float el =
                              new java.awt.geom.Ellipse2D.Float(
                              x1,
                              y1,
                              x2 -
                                x1,
                              y2 -
                                y1);
                            paint(
                              brushObject,
                              penObject,
                              el,
                              g2d);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTALIGN:
                        currentHorizAlign =
                          org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                            getHorizontalAlignment(
                              mr.
                                elementAt(
                                  0));
                        currentVertAlign =
                          org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                            getVerticalAlignment(
                              mr.
                                elementAt(
                                  0));
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTCOLOR:
                        frgdColor =
                          new java.awt.Color(
                            mr.
                              elementAt(
                                0),
                            mr.
                              elementAt(
                                1),
                            mr.
                              elementAt(
                                2));
                        g2d.
                          setColor(
                            frgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETBKCOLOR:
                        bkgdColor =
                          new java.awt.Color(
                            mr.
                              elementAt(
                                0),
                            mr.
                              elementAt(
                                1),
                            mr.
                              elementAt(
                                2));
                        g2d.
                          setColor(
                            bkgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_EXTTEXTOUT:
                        try {
                            byte[] bstr =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.lang.String sr =
                              org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                              decodeString(
                                wmfFont,
                                bstr);
                            float x =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float y =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            if (frgdColor !=
                                  null)
                                g2d.
                                  setColor(
                                    frgdColor);
                            else
                                g2d.
                                  setColor(
                                    java.awt.Color.
                                      black);
                            java.awt.font.FontRenderContext frc =
                              g2d.
                              getFontRenderContext(
                                );
                            java.awt.geom.Point2D.Double pen =
                              new java.awt.geom.Point2D.Double(
                              0,
                              0);
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            java.awt.font.TextLayout layout =
                              new java.awt.font.TextLayout(
                              sr,
                              g2d.
                                getFont(
                                  ),
                              frc);
                            int flag =
                              mr.
                              elementAt(
                                2);
                            int x1 =
                              0;
                            int y1 =
                              0;
                            int x2 =
                              0;
                            int y2 =
                              0;
                            boolean clipped =
                              false;
                            java.awt.Shape clip =
                              null;
                            if ((flag &
                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                     ETO_CLIPPED) !=
                                  0) {
                                clipped =
                                  true;
                                x1 =
                                  mr.
                                    elementAt(
                                      3);
                                y1 =
                                  mr.
                                    elementAt(
                                      4);
                                x2 =
                                  mr.
                                    elementAt(
                                      5);
                                y2 =
                                  mr.
                                    elementAt(
                                      6);
                                clip =
                                  g2d.
                                    getClip(
                                      );
                                g2d.
                                  setClip(
                                    x1,
                                    y1,
                                    x2,
                                    y2);
                            }
                            firstEffectivePaint =
                              false;
                            y +=
                              getVerticalAlignmentValue(
                                layout,
                                currentVertAlign);
                            drawString(
                              flag,
                              g2d,
                              getCharacterIterator(
                                g2d,
                                sr,
                                wmfFont,
                                currentHorizAlign),
                              x,
                              y,
                              layout,
                              wmfFont,
                              currentHorizAlign);
                            if (clipped)
                                g2d.
                                  setClip(
                                    clip);
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_TEXTOUT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DRAWTEXT:
                        try {
                            byte[] bstr =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.lang.String sr =
                              org.apache.batik.transcoder.wmf.tosvg.WMFUtilities.
                              decodeString(
                                wmfFont,
                                bstr);
                            float x =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   0));
                            float y =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   1));
                            if (frgdColor !=
                                  null)
                                g2d.
                                  setColor(
                                    frgdColor);
                            else
                                g2d.
                                  setColor(
                                    java.awt.Color.
                                      black);
                            java.awt.font.FontRenderContext frc =
                              g2d.
                              getFontRenderContext(
                                );
                            java.awt.geom.Point2D.Double pen =
                              new java.awt.geom.Point2D.Double(
                              0,
                              0);
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            java.awt.font.TextLayout layout =
                              new java.awt.font.TextLayout(
                              sr,
                              g2d.
                                getFont(
                                  ),
                              frc);
                            firstEffectivePaint =
                              false;
                            y +=
                              getVerticalAlignmentValue(
                                layout,
                                currentVertAlign);
                            drawString(
                              -1,
                              g2d,
                              getCharacterIterator(
                                g2d,
                                sr,
                                wmfFont),
                              x,
                              y,
                              layout,
                              wmfFont,
                              currentHorizAlign);
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ARC:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PIE:
                        {
                            double left;
                            double top;
                            double right;
                            double bottom;
                            double xstart;
                            double ystart;
                            double xend;
                            double yend;
                            left =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            top =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            right =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            bottom =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            xstart =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     4));
                            ystart =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     5));
                            xend =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     6));
                            yend =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     7));
                            setBrushPaint(
                              currentStore,
                              g2d,
                              brushObject);
                            double cx =
                              left +
                              (right -
                                 left) /
                              2;
                            double cy =
                              top +
                              (bottom -
                                 top) /
                              2;
                            double startAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    ystart -
                                      cy,
                                    xstart -
                                      cx));
                            double endAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    yend -
                                      cy,
                                    xend -
                                      cx));
                            double extentAngle =
                              endAngle -
                              startAngle;
                            if (extentAngle <
                                  0)
                                extentAngle +=
                                  360;
                            if (startAngle <
                                  0)
                                startAngle +=
                                  360;
                            java.awt.geom.Arc2D.Double arc =
                              new java.awt.geom.Arc2D.Double(
                              left,
                              top,
                              right -
                                left,
                              bottom -
                                top,
                              startAngle,
                              extentAngle,
                              java.awt.geom.Arc2D.
                                OPEN);
                            if (mr.
                                  functionId ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_ARC)
                                g2d.
                                  draw(
                                    arc);
                            else
                                g2d.
                                  fill(
                                    arc);
                            firstEffectivePaint =
                              false;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_CHORD:
                        {
                            double left;
                            double top;
                            double right;
                            double bottom;
                            double xstart;
                            double ystart;
                            double xend;
                            double yend;
                            left =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     0));
                            top =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     1));
                            right =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     2));
                            bottom =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     3));
                            xstart =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     4));
                            ystart =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     5));
                            xend =
                              scaleX *
                                (vpX +
                                   xOffset +
                                   mr.
                                   elementAt(
                                     6));
                            yend =
                              scaleY *
                                (vpY +
                                   yOffset +
                                   mr.
                                   elementAt(
                                     7));
                            setBrushPaint(
                              currentStore,
                              g2d,
                              brushObject);
                            double cx =
                              left +
                              (right -
                                 left) /
                              2;
                            double cy =
                              top +
                              (bottom -
                                 top) /
                              2;
                            double startAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    ystart -
                                      cy,
                                    xstart -
                                      cx));
                            double endAngle =
                              -java.lang.Math.
                              toDegrees(
                                java.lang.Math.
                                  atan2(
                                    yend -
                                      cy,
                                    xend -
                                      cx));
                            double extentAngle =
                              endAngle -
                              startAngle;
                            if (extentAngle <
                                  0)
                                extentAngle +=
                                  360;
                            if (startAngle <
                                  0)
                                startAngle +=
                                  360;
                            java.awt.geom.Arc2D.Double arc =
                              new java.awt.geom.Arc2D.Double(
                              left,
                              top,
                              right -
                                left,
                              bottom -
                                top,
                              startAngle,
                              extentAngle,
                              java.awt.geom.Arc2D.
                                CHORD);
                            paint(
                              brushObject,
                              penObject,
                              arc,
                              g2d);
                            firstEffectivePaint =
                              false;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SAVEDC:
                        dcStack.
                          push(
                            new java.lang.Float(
                              penWidth));
                        dcStack.
                          push(
                            new java.lang.Float(
                              startX));
                        dcStack.
                          push(
                            new java.lang.Float(
                              startY));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              brushObject));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              penObject));
                        dcStack.
                          push(
                            new java.lang.Integer(
                              fontObject));
                        dcStack.
                          push(
                            frgdColor);
                        dcStack.
                          push(
                            bkgdColor);
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_RESTOREDC:
                        bkgdColor =
                          (java.awt.Color)
                            dcStack.
                            pop(
                              );
                        frgdColor =
                          (java.awt.Color)
                            dcStack.
                            pop(
                              );
                        fontObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        penObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        brushObject =
                          ((java.lang.Integer)
                             dcStack.
                             pop(
                               )).
                            intValue(
                              );
                        startY =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        startX =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        penWidth =
                          ((java.lang.Float)
                             dcStack.
                             pop(
                               )).
                            floatValue(
                              );
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_POLYBEZIER16:
                        try {
                            setPenColor(
                              currentStore,
                              g2d,
                              penObject);
                            int pointCount =
                              mr.
                              elementAt(
                                0);
                            int bezierCount =
                              (pointCount -
                                 1) /
                              3;
                            float _startX =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   1));
                            float _startY =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   2));
                            java.awt.geom.GeneralPath gp =
                              new java.awt.geom.GeneralPath(
                              java.awt.geom.GeneralPath.
                                WIND_NON_ZERO);
                            gp.
                              moveTo(
                                _startX,
                                _startY);
                            for (int j =
                                   0;
                                 j <
                                   bezierCount;
                                 j++) {
                                int j6 =
                                  j *
                                  6;
                                float cp1X =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         3));
                                float cp1Y =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         4));
                                float cp2X =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         5));
                                float cp2Y =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         6));
                                float endX =
                                  scaleX *
                                  (vpX +
                                     xOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         7));
                                float endY =
                                  scaleY *
                                  (vpY +
                                     yOffset +
                                     mr.
                                     elementAt(
                                       j6 +
                                         8));
                                gp.
                                  curveTo(
                                    cp1X,
                                    cp1Y,
                                    cp2X,
                                    cp2Y,
                                    endX,
                                    endY);
                                _startX =
                                  endX;
                                _startY =
                                  endY;
                            }
                            g2d.
                              setStroke(
                                solid);
                            g2d.
                              draw(
                                gp);
                            firstEffectivePaint =
                              false;
                        }
                        catch (java.lang.Exception e) {
                            
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_EXCLUDECLIPRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_INTERSECTCLIPRECT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_OFFSETCLIPRGN:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SELECTCLIPREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETMAPMODE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETRELABS:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETSTRETCHBLTMODE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTCHAREXTRA:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETTEXTJUSTIFICATION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FLOODFILL:
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETBKMODE:
                        {
                            int mode =
                              mr.
                              elementAt(
                                0);
                            opaque =
                              mode ==
                                org.apache.batik.transcoder.wmf.WMFConstants.
                                  OPAQUE;
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETROP2:
                        {
                            float rop =
                              (float)
                                mr.
                                ElementAt(
                                  0).
                                intValue(
                                  );
                            java.awt.Paint paint =
                              null;
                            boolean ok =
                              false;
                            if (rop ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_BLACKNESS) {
                                paint =
                                  java.awt.Color.
                                    black;
                                ok =
                                  true;
                            }
                            else
                                if (rop ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        META_WHITENESS) {
                                    paint =
                                      java.awt.Color.
                                        white;
                                    ok =
                                      true;
                                }
                                else
                                    if (rop ==
                                          org.apache.batik.transcoder.wmf.WMFConstants.
                                            META_PATCOPY) {
                                        if (brushObject >=
                                              0) {
                                            paint =
                                              getStoredPaint(
                                                currentStore,
                                                brushObject);
                                            ok =
                                              true;
                                        }
                                    }
                            if (ok) {
                                if (paint !=
                                      null) {
                                    g2d.
                                      setPaint(
                                        paint);
                                }
                                else {
                                    setBrushPaint(
                                      currentStore,
                                      g2d,
                                      brushObject);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PATBLT:
                        {
                            float rop =
                              (float)
                                mr.
                                elementAt(
                                  0);
                            float height =
                              scaleY *
                              (float)
                                mr.
                                elementAt(
                                  1);
                            float width =
                              scaleX *
                              (float)
                                mr.
                                elementAt(
                                  2);
                            float left =
                              scaleX *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   3));
                            float top =
                              scaleY *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   4));
                            java.awt.Paint paint =
                              null;
                            boolean ok =
                              false;
                            if (rop ==
                                  org.apache.batik.transcoder.wmf.WMFConstants.
                                    META_BLACKNESS) {
                                paint =
                                  java.awt.Color.
                                    black;
                                ok =
                                  true;
                            }
                            else
                                if (rop ==
                                      org.apache.batik.transcoder.wmf.WMFConstants.
                                        META_WHITENESS) {
                                    paint =
                                      java.awt.Color.
                                        white;
                                    ok =
                                      true;
                                }
                                else
                                    if (rop ==
                                          org.apache.batik.transcoder.wmf.WMFConstants.
                                            META_PATCOPY) {
                                        if (brushObject >=
                                              0) {
                                            paint =
                                              getStoredPaint(
                                                currentStore,
                                                brushObject);
                                            ok =
                                              true;
                                        }
                                    }
                            if (ok) {
                                java.awt.Color oldClr =
                                  g2d.
                                  getColor(
                                    );
                                if (paint !=
                                      null) {
                                    g2d.
                                      setPaint(
                                        paint);
                                }
                                else {
                                    setBrushPaint(
                                      currentStore,
                                      g2d,
                                      brushObject);
                                }
                                java.awt.geom.Rectangle2D.Float rec =
                                  new java.awt.geom.Rectangle2D.Float(
                                  left,
                                  top,
                                  width,
                                  height);
                                g2d.
                                  fill(
                                    rec);
                                g2d.
                                  setColor(
                                    oldClr);
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBSTRETCHBLT:
                        {
                            int height =
                              mr.
                              elementAt(
                                1);
                            int width =
                              mr.
                              elementAt(
                                2);
                            int sy =
                              mr.
                              elementAt(
                                3);
                            int sx =
                              mr.
                              elementAt(
                                4);
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 mr.
                                 elementAt(
                                   7));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 mr.
                                 elementAt(
                                   8));
                            float heightDst =
                              (float)
                                mr.
                                elementAt(
                                  5);
                            float widthDst =
                              (float)
                                mr.
                                elementAt(
                                  6);
                            widthDst =
                              widthDst *
                                conv *
                                currentStore.
                                getVpWFactor(
                                  );
                            heightDst =
                              heightDst *
                                conv *
                                currentStore.
                                getVpHFactor(
                                  );
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.awt.image.BufferedImage img =
                              getImage(
                                bitmap,
                                width,
                                height);
                            if (img !=
                                  null) {
                                g2d.
                                  drawImage(
                                    img,
                                    (int)
                                      dx,
                                    (int)
                                      dy,
                                    (int)
                                      (dx +
                                         widthDst),
                                    (int)
                                      (dy +
                                         heightDst),
                                    sx,
                                    sy,
                                    sx +
                                      width,
                                    sy +
                                      height,
                                    bkgdColor,
                                    observer);
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_STRETCHDIB:
                        {
                            int height =
                              mr.
                              elementAt(
                                1);
                            int width =
                              mr.
                              elementAt(
                                2);
                            int sy =
                              mr.
                              elementAt(
                                3);
                            int sx =
                              mr.
                              elementAt(
                                4);
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 (float)
                                   mr.
                                   elementAt(
                                     7));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 (float)
                                   mr.
                                   elementAt(
                                     8));
                            float heightDst =
                              (float)
                                mr.
                                elementAt(
                                  5);
                            float widthDst =
                              (float)
                                mr.
                                elementAt(
                                  6);
                            widthDst =
                              widthDst *
                                conv *
                                currentStore.
                                getVpWFactor(
                                  );
                            heightDst =
                              heightDst *
                                conv *
                                currentStore.
                                getVpHFactor(
                                  );
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            java.awt.image.BufferedImage img =
                              getImage(
                                bitmap,
                                width,
                                height);
                            if (img !=
                                  null) {
                                if (opaque) {
                                    g2d.
                                      drawImage(
                                        img,
                                        (int)
                                          dx,
                                        (int)
                                          dy,
                                        (int)
                                          (dx +
                                             widthDst),
                                        (int)
                                          (dy +
                                             heightDst),
                                        sx,
                                        sy,
                                        sx +
                                          width,
                                        sy +
                                          height,
                                        bkgdColor,
                                        observer);
                                }
                                else {
                                    g2d.
                                      drawImage(
                                        img,
                                        (int)
                                          dx,
                                        (int)
                                          dy,
                                        (int)
                                          (dx +
                                             widthDst),
                                        (int)
                                          (dy +
                                             heightDst),
                                        sx,
                                        sy,
                                        sx +
                                          width,
                                        sy +
                                          height,
                                        observer);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBBITBLT:
                        {
                            int rop =
                              mr.
                              ElementAt(
                                0).
                              intValue(
                                );
                            float height =
                              mr.
                              ElementAt(
                                1).
                              intValue(
                                ) *
                              conv *
                              currentStore.
                              getVpWFactor(
                                );
                            float width =
                              mr.
                              ElementAt(
                                2).
                              intValue(
                                ) *
                              conv *
                              currentStore.
                              getVpHFactor(
                                );
                            int sy =
                              mr.
                              ElementAt(
                                3).
                              intValue(
                                );
                            int sx =
                              mr.
                              ElementAt(
                                4).
                              intValue(
                                );
                            float dy =
                              conv *
                              currentStore.
                              getVpWFactor(
                                ) *
                              (vpY +
                                 yOffset +
                                 (float)
                                   mr.
                                   ElementAt(
                                     5).
                                   intValue(
                                     ));
                            float dx =
                              conv *
                              currentStore.
                              getVpHFactor(
                                ) *
                              (vpX +
                                 xOffset +
                                 (float)
                                   mr.
                                   ElementAt(
                                     6).
                                   intValue(
                                     ));
                            if (mr instanceof org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord) {
                                byte[] bitmap =
                                  ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                     mr).
                                    bstr;
                                java.awt.image.BufferedImage img =
                                  getImage(
                                    bitmap);
                                if (img !=
                                      null) {
                                    int withSrc =
                                      img.
                                      getWidth(
                                        );
                                    int heightSrc =
                                      img.
                                      getHeight(
                                        );
                                    if (opaque) {
                                        g2d.
                                          drawImage(
                                            img,
                                            (int)
                                              dx,
                                            (int)
                                              dy,
                                            (int)
                                              (dx +
                                                 width),
                                            (int)
                                              (dy +
                                                 height),
                                            sx,
                                            sy,
                                            sx +
                                              withSrc,
                                            sy +
                                              heightSrc,
                                            bkgdColor,
                                            observer);
                                    }
                                    else {
                                        g2d.
                                          drawImage(
                                            img,
                                            (int)
                                              dx,
                                            (int)
                                              dy,
                                            (int)
                                              (dx +
                                                 width),
                                            (int)
                                              (dy +
                                                 height),
                                            sx,
                                            sy,
                                            sx +
                                              withSrc,
                                            sy +
                                              heightSrc,
                                            observer);
                                    }
                                }
                            }
                            else {
                                if (opaque) {
                                    java.awt.Color col =
                                      g2d.
                                      getColor(
                                        );
                                    g2d.
                                      setColor(
                                        bkgdColor);
                                    g2d.
                                      fill(
                                        new java.awt.geom.Rectangle2D.Float(
                                          dx,
                                          dy,
                                          width,
                                          height));
                                    g2d.
                                      setColor(
                                        col);
                                }
                            }
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_DIBCREATEPATTERNBRUSH:
                        {
                            int objIndex =
                              0;
                            byte[] bitmap =
                              ((org.apache.batik.transcoder.wmf.tosvg.MetaRecord.ByteRecord)
                                 mr).
                                bstr;
                            objIndex =
                              addObjectAt(
                                currentStore,
                                BRUSH,
                                bitmap,
                                objIndex);
                        }
                        break;
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETPIXEL:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_BITBLT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_STRETCHBLT:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_ESCAPE:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FILLREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_FRAMEREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_INVERTREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_PAINTREGION:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETMAPPERFLAGS:
                    case org.apache.batik.transcoder.wmf.WMFConstants.
                           META_SETDIBTODEV:
                    default:
                        {
                            
                        }
                        break;
                }
            }
        }
    }
    private java.awt.Paint getPaint(byte[] bit) {
        java.awt.Dimension d =
          getImageDimension(
            bit);
        java.awt.image.BufferedImage img =
          getImage(
            bit);
        java.awt.geom.Rectangle2D rec =
          new java.awt.geom.Rectangle2D.Float(
          0,
          0,
          (float)
            d.
              width,
          (float)
            d.
              height);
        java.awt.TexturePaint paint =
          new java.awt.TexturePaint(
          img,
          rec);
        return paint;
    }
    private void drawString(int flag, java.awt.Graphics2D g2d,
                            java.text.AttributedCharacterIterator ati,
                            float x,
                            float y,
                            java.awt.font.TextLayout layout,
                            org.apache.batik.transcoder.wmf.tosvg.WMFFont wmfFont,
                            int align) { if (wmfFont.
                                               escape ==
                                               0) {
                                             if (flag !=
                                                   -1)
                                                 fillTextBackground(
                                                   -1,
                                                   flag,
                                                   g2d,
                                                   x,
                                                   y,
                                                   0,
                                                   layout);
                                             float width =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getWidth(
                                                   );
                                             if (align ==
                                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                                     TA_CENTER) {
                                                 g2d.
                                                   drawString(
                                                     ati,
                                                     x -
                                                       width /
                                                       2,
                                                     y);
                                             }
                                             else
                                                 if (align ==
                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                         TA_RIGHT) {
                                                     g2d.
                                                       drawString(
                                                         ati,
                                                         x -
                                                           width,
                                                         y);
                                                 }
                                                 else {
                                                     g2d.
                                                       drawString(
                                                         ati,
                                                         x,
                                                         y);
                                                 }
                                         }
                                         else {
                                             java.awt.geom.AffineTransform tr =
                                               g2d.
                                               getTransform(
                                                 );
                                             float angle =
                                               -((float)
                                                   (wmfFont.
                                                      escape *
                                                      java.lang.Math.
                                                        PI /
                                                      1800.0F));
                                             float width =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getWidth(
                                                   );
                                             float height =
                                               (float)
                                                 layout.
                                                 getBounds(
                                                   ).
                                                 getHeight(
                                                   );
                                             if (align ==
                                                   org.apache.batik.transcoder.wmf.WMFConstants.
                                                     TA_CENTER) {
                                                 g2d.
                                                   translate(
                                                     -width /
                                                       2,
                                                     height /
                                                       2);
                                                 g2d.
                                                   rotate(
                                                     angle,
                                                     x -
                                                       width /
                                                       2,
                                                     y);
                                             }
                                             else
                                                 if (align ==
                                                       org.apache.batik.transcoder.wmf.WMFConstants.
                                                         TA_RIGHT) {
                                                     g2d.
                                                       translate(
                                                         -width /
                                                           2,
                                                         height /
                                                           2);
                                                     g2d.
                                                       rotate(
                                                         angle,
                                                         x -
                                                           width,
                                                         y);
                                                 }
                                                 else {
                                                     g2d.
                                                       translate(
                                                         0,
                                                         height /
                                                           2);
                                                     g2d.
                                                       rotate(
                                                         angle,
                                                         x,
                                                         y);
                                                 }
                                             if (flag !=
                                                   -1)
                                                 fillTextBackground(
                                                   align,
                                                   flag,
                                                   g2d,
                                                   x,
                                                   y,
                                                   width,
                                                   layout);
                                             java.awt.Stroke _st =
                                               g2d.
                                               getStroke(
                                                 );
                                             g2d.
                                               setStroke(
                                                 textSolid);
                                             g2d.
                                               drawString(
                                                 ati,
                                                 x,
                                                 y);
                                             g2d.
                                               setStroke(
                                                 _st);
                                             g2d.
                                               setTransform(
                                                 tr);
                                         }
    }
    private void fillTextBackground(int align,
                                    int flag,
                                    java.awt.Graphics2D g2d,
                                    float x,
                                    float y,
                                    float width,
                                    java.awt.font.TextLayout layout) {
        float _x =
          x;
        if (align ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_CENTER)
            _x =
              x -
                width /
                2;
        else
            if (align ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_RIGHT)
                _x =
                  x -
                    width;
        if ((flag &
               org.apache.batik.transcoder.wmf.WMFConstants.
                 ETO_OPAQUE) !=
              0) {
            java.awt.Color c =
              g2d.
              getColor(
                );
            java.awt.geom.AffineTransform tr =
              g2d.
              getTransform(
                );
            g2d.
              setColor(
                bkgdColor);
            g2d.
              translate(
                _x,
                y);
            g2d.
              fill(
                layout.
                  getBounds(
                    ));
            g2d.
              setColor(
                c);
            g2d.
              setTransform(
                tr);
        }
        else
            if (opaque) {
                java.awt.Color c =
                  g2d.
                  getColor(
                    );
                java.awt.geom.AffineTransform tr =
                  g2d.
                  getTransform(
                    );
                g2d.
                  setColor(
                    bkgdColor);
                g2d.
                  translate(
                    _x,
                    y);
                g2d.
                  fill(
                    layout.
                      getBounds(
                        ));
                g2d.
                  setColor(
                    c);
                g2d.
                  setTransform(
                    tr);
            }
    }
    private void drawPolyPolygon(java.awt.Graphics2D g2d,
                                 java.util.List pols) {
        java.util.Iterator it =
          pols.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.geom.Polygon2D pol =
              (org.apache.batik.ext.awt.geom.Polygon2D)
                it.
                next(
                  );
            g2d.
              draw(
                pol);
        }
    }
    private void fillPolyPolygon(java.awt.Graphics2D g2d,
                                 java.util.List pols) {
        if (pols.
              size(
                ) ==
              1)
            g2d.
              fill(
                (org.apache.batik.ext.awt.geom.Polygon2D)
                  pols.
                  get(
                    0));
        else {
            java.awt.geom.GeneralPath path =
              new java.awt.geom.GeneralPath(
              java.awt.geom.GeneralPath.
                WIND_EVEN_ODD);
            for (int i =
                   0;
                 i <
                   pols.
                   size(
                     );
                 i++) {
                org.apache.batik.ext.awt.geom.Polygon2D pol =
                  (org.apache.batik.ext.awt.geom.Polygon2D)
                    pols.
                    get(
                      i);
                path.
                  append(
                    pol,
                    false);
            }
            g2d.
              fill(
                path);
        }
    }
    private void setStroke(java.awt.Graphics2D g2d,
                           int penStyle,
                           float penWidth,
                           float scale) {
        float _width;
        if (penWidth ==
              0)
            _width =
              1;
        else
            _width =
              penWidth;
        float _scale =
          (float)
            java.awt.Toolkit.
            getDefaultToolkit(
              ).
            getScreenResolution(
              ) /
          currentStore.
          getMetaFileUnitsPerInch(
            );
        float factor =
          scale /
          _scale;
        _width =
          _width *
            _scale *
            factor;
        _scale =
          currentStore.
            getWidthPixels(
              ) *
            1.0F /
            350.0F;
        java.awt.BasicStroke stroke;
        if (penStyle ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                META_PS_SOLID) {
            stroke =
              new java.awt.BasicStroke(
                _width,
                java.awt.BasicStroke.
                  CAP_BUTT,
                java.awt.BasicStroke.
                  JOIN_ROUND);
            g2d.
              setStroke(
                stroke);
        }
        else
            if (penStyle ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    META_PS_DOT) {
                float[] dash =
                  { 1.0F *
                  _scale,
                5.0F *
                  _scale };
                stroke =
                  new java.awt.BasicStroke(
                    _width,
                    java.awt.BasicStroke.
                      CAP_BUTT,
                    java.awt.BasicStroke.
                      JOIN_ROUND,
                    10.0F *
                      _scale,
                    dash,
                    0.0F);
                g2d.
                  setStroke(
                    stroke);
            }
            else
                if (penStyle ==
                      org.apache.batik.transcoder.wmf.WMFConstants.
                        META_PS_DASH) {
                    float[] dash =
                      { 5.0F *
                      _scale,
                    2.0F *
                      _scale };
                    stroke =
                      new java.awt.BasicStroke(
                        _width,
                        java.awt.BasicStroke.
                          CAP_BUTT,
                        java.awt.BasicStroke.
                          JOIN_ROUND,
                        10.0F *
                          _scale,
                        dash,
                        0.0F);
                    g2d.
                      setStroke(
                        stroke);
                }
                else
                    if (penStyle ==
                          org.apache.batik.transcoder.wmf.WMFConstants.
                            META_PS_DASHDOT) {
                        float[] dash =
                          { 5.0F *
                          _scale,
                        2.0F *
                          _scale,
                        1.0F *
                          _scale,
                        2.0F *
                          _scale };
                        stroke =
                          new java.awt.BasicStroke(
                            _width,
                            java.awt.BasicStroke.
                              CAP_BUTT,
                            java.awt.BasicStroke.
                              JOIN_ROUND,
                            10.0F *
                              _scale,
                            dash,
                            0.0F);
                        g2d.
                          setStroke(
                            stroke);
                    }
                    else
                        if (penStyle ==
                              org.apache.batik.transcoder.wmf.WMFConstants.
                                META_PS_DASHDOTDOT) {
                            float[] dash =
                              { 5.0F *
                              _scale,
                            2.0F *
                              _scale,
                            1.0F *
                              _scale,
                            2.0F *
                              _scale,
                            1.0F *
                              _scale,
                            2.0F *
                              _scale };
                            stroke =
                              new java.awt.BasicStroke(
                                _width,
                                java.awt.BasicStroke.
                                  CAP_BUTT,
                                java.awt.BasicStroke.
                                  JOIN_ROUND,
                                15.0F *
                                  _scale,
                                dash,
                                0.0F);
                            g2d.
                              setStroke(
                                stroke);
                        }
                        else {
                            stroke =
                              new java.awt.BasicStroke(
                                _width,
                                java.awt.BasicStroke.
                                  CAP_BUTT,
                                java.awt.BasicStroke.
                                  JOIN_ROUND);
                            g2d.
                              setStroke(
                                stroke);
                        }
    }
    private void setPenColor(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                             java.awt.Graphics2D g2d,
                             int penObject) {
        if (penObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                penObject);
            g2d.
              setColor(
                (java.awt.Color)
                  gdiObj.
                    obj);
            penObject =
              -1;
        }
    }
    private int getHorizontalAlignement(int align) {
        int v =
          align;
        v =
          v %
            24;
        v =
          v %
            8;
        if (v >=
              6)
            return org.apache.batik.transcoder.wmf.WMFConstants.
                     TA_CENTER;
        else
            if (v >=
                  2)
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_RIGHT;
            else
                return org.apache.batik.transcoder.wmf.WMFConstants.
                         TA_LEFT;
    }
    private void setBrushPaint(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                               java.awt.Graphics2D g2d,
                               int brushObject) {
        if (brushObject >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                brushObject);
            if (gdiObj.
                  obj instanceof java.awt.Color)
                g2d.
                  setColor(
                    (java.awt.Color)
                      gdiObj.
                        obj);
            else
                if (gdiObj.
                      obj instanceof java.awt.Paint)
                    g2d.
                      setPaint(
                        (java.awt.Paint)
                          gdiObj.
                            obj);
                else
                    g2d.
                      setPaint(
                        getPaint(
                          (byte[])
                            gdiObj.
                              obj));
            brushObject =
              -1;
        }
    }
    private java.awt.Paint getStoredPaint(org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore currentStore,
                                          int object) {
        if (object >=
              0) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdiObj =
              currentStore.
              getObject(
                object);
            if (gdiObj.
                  obj instanceof java.awt.Paint)
                return (java.awt.Paint)
                         gdiObj.
                           obj;
            else
                return getPaint(
                         (byte[])
                           gdiObj.
                             obj);
        }
        else
            return null;
    }
    private void paint(int brushObject, int penObject,
                       java.awt.Shape shape,
                       java.awt.Graphics2D g2d) {
        if (brushObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                brushObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setBrushPaint(
                  currentStore,
                  g2d,
                  brushObject);
                g2d.
                  fill(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
        if (penObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                penObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setPenColor(
                  currentStore,
                  g2d,
                  penObject);
                g2d.
                  draw(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
    }
    private void paintWithPen(int penObject,
                              java.awt.Shape shape,
                              java.awt.Graphics2D g2d) {
        if (penObject >=
              0) {
            java.awt.Paint paint =
              getStoredPaint(
                currentStore,
                penObject);
            if (!(firstEffectivePaint &&
                    paint.
                    equals(
                      java.awt.Color.
                        white))) {
                setPenColor(
                  currentStore,
                  g2d,
                  penObject);
                g2d.
                  draw(
                    shape);
                firstEffectivePaint =
                  false;
            }
        }
    }
    private float getVerticalAlignmentValue(java.awt.font.TextLayout layout,
                                            int vertAlign) {
        if (vertAlign ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                TA_BOTTOM)
            return -layout.
              getDescent(
                );
        else
            if (vertAlign ==
                  org.apache.batik.transcoder.wmf.WMFConstants.
                    TA_TOP)
                return layout.
                  getAscent(
                    );
            else
                return 0;
    }
    public org.apache.batik.transcoder.wmf.tosvg.WMFRecordStore getRecordStore() {
        return currentStore;
    }
    private transient java.io.BufferedInputStream
      bufStream =
      null;
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "I3wFf8SnK/8PyiiKrD48AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qo6UxJSwi7LGDMLRZlup6pC+ayIrY8Yg");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("qS1hgiDnI8XsLlVc1JXNcFdbjhcemeirceatp2Obmi8oDNm2qkLDx0QvwrWB" +
       "vBAcbek31b7Lg3XmOti1QXe02qBgrs0YKzpo9Dh/YxvdDZssuDzbIsau2ktC" +
       "Lw7NZW0n1iANau6STlpdKdIuik21PiTAFD7lXJshSKvaU9xqN5dmrW5EORIQ" +
       "K4ryA2sjZ9V4EXgTbZbsCKajg2miATdtYw3WacbCYGs5OtV3CdtvEDia7fB6" +
       "dRXTmk+gbIjzQ4HYhaGbpM7aZOcikWfcmGPXDsbwMSsYhuFw3hyXkW3I92OL" +
       "n9JVJVohdnWVT+F+2vMb3LJl4t7UqYXLrWqs4LRKoILRZ5tbNBFdedawR+im" +
       "xiqStuTdKCFWQ44gpRDyOqxhV1uLVcNUd4bXHvNcUsPjgTTXNfALQ+pmLWzq" +
       "bB1b0R5YMtQ3kzUwXUIyA1S0WqbXMIm0FcZhl1XX0UyJakM9yzI/2DbWTltj" +
       "W+MQGcXaYq1VvXZDyhu79Q4NtfaCntBpbZzjeqYvhUnPbrOjppgjhBlnRlYj" +
       "J9NOKvaQPNUibCy5QbaCYB6sMzeqZmT6ah1AdMOletSG95EtouQORqwH7Xgu" +
       "iZvMGcJZdeA1PFtA1DTe9OIFq1VjRE56nfrU4RJ+3SLF5moIQ0ObYbmIA/aM" +
       "ZDglIwiy1Vlt3st62/EAcVm7kTflJGsZs2E6R5HIXhB9eOj5CoW1lT5YVgx4" +
       "hes3pjlKrm2zusgdpqf3WrMwggkdX6Arw+8t2RBh7d2gs8z6Bj+MuCE7J1y5" +
       "lW8aawKREI2I1mNA/GBTr61abVxZ0PWd3Zga2041CWeLLtuE5yNWafUXRMdP" +
       "6j3JpeeLQZSGy9XADWGiVrXVbY1juGVbxNMOENeQxkxIE0buggyJrEb4y3nO" +
       "mnIvX6TbmJtNOD80kelQHu/4Zs5ogugyCulN+p7cdqrVFGQ1iKjh1qfywEzr" +
       "zdWC63YQ32vXSZz0KYGmNZmX2nmN7i1EI9/MSXHUwkeE0rIaGUu6aKvvYnC/" +
       "0yRitrElwEwrAOEx5dORVVUogZpZgRzE2/ogbqRBx2851LZO6nHHBGsEajFk" +
       "+/HED5fd7gLlUuAOLaw13/Vy2fRXbQ+ThcBq19ZkPmq1mCZY96CopGSw1aFS" +
       "bIlGUKxKRLszRNGJFXRX9YTpx62BGXfW/GwJvAqahziiBkqbyFx4LeFMvlw1" +
       "4XgR96oSbUQ9lQpCPooWG3ZsoNNUz62RVkuCnTaiWQzDG0qdTTAZrE26QXeL" +
       "azkvOqblUx1ohnbXLBnJseJk0qK90Ho7bKsj0ziOcyG0uynOrpdqqI5ISmgx" +
       "Yy5Sfdf1U04Uquii3SEaaryZjprZghCY0HR1YTOcMlAfoaIdsZtE3mY3jdbm" +
       "xGDMXJhCmGxqKm9Ma7XqNO4vgmawYMG0PBsHECGM8jyFYj12WxtrGKSY4JhE" +
       "Nok6a47oxf4crvkoO5w21qQ/l3O+w7YYsT3p7xRgp54RM9Wu3gMmH6i4vCCh" +
       "auTJE245XxBpBG3mQoT5o5nCjuqu28aTUPG70xHgrcb20CWd8k4G5jDK1Mnk" +
       "4W6lLIFXCOd4Jx81ck9fLtoeYSxUcasusDlTTymDEMBMiRjlljUIOijRarWK" +
       "vZIHL725VwUPla8+js91rG28KPjKTbwN2Bed23NYOXoDduYswKnXSGXNR4/2" +
       "OgaV117vuEa50fRD3/2BZzT+x2tXDvcUNouXdZ7/dbae6Paprh4APb39+lsE" +
       "h+VplZN9er/03X/w2PQd5tM3se399edwnu/yHw2f/ZXe16jvv1K57XjX3jXn" +
       "aM42evLsXr17Az2KA3d6Zsfea485W24ELd5/f88hZ7/n/Au6E9ld/PL7rXvZ" +
       "l2UnWzYP9hWOXnk9dPx6sRfIvmmpYdHq4PFzrU5t9Dx4S5G8Lqrc4Revoy98" +
       "0ZR4h++DC606eP3N7AQtMg5efcyGh4vMx4Be/+t92/33zbDh6UvZEFTefH09" +
       "KveT7zdnP/MPH//V73jm8d8p9wffbYVzOWgFqwvOH51q88VnP/uFT7/0tR8p" +
       "jy3crsjhXtDnD25dey7rzHGrEv59xwwpdmpU3gCgHzJk/33rx2KUwNJWOtQG" +
       "KAU1sPzIclddN7ECz3VAHy/U6ZsbGSa7UKeUPNIv1OLiDeUBcfi++uAbL3lf" +
       "/dYzLvFOW3dX+4NNxcbSA/xwF2TR/7mTAi87eZdL2p6rF8cVzu53sLyrx2f7" +
       "QGF2EdKDV++RloOd8qYX6edpg2MvKeOKhAHGqBa49mRcUn2c7b/RS+oIRQJF" +
       "lbtXejQ6NvEzW45OsksDh2/BwMt9PjQw7P9waOCffGEM/O6ywt2ldM+K8bSz" +
       "QzpHZW8uy4qdIVdbURRYShzpGmmCoKAC62QivTxRU1QuN4U1jto9etyn4QH9" +
       "nYIOWDn34mOufd0NnzKhvMMN96UYnrpERFaRSFHlXi2Q0+OtCgdvOxHJN9+q" +
       "SN4CRPG/DkXyxy+MSO4qK9x1ZHB7q3v6hKVHyYFWEhlewoC4SNyo8rBh2XbB" +
       "87asblaBF7vaOUZ4t8qIYpPM/fu2++9bZ8SVY5d08PSZAzhnI9BETsvp0VPq" +
       "vxh/7lM/tvvos/vzNUUkiSrV6x2MvvZsdnHM7pIwd+rI7J/0/spzv//f5u88" +
       "moC95JgXtYL0xmW8OOsmDo/YlCfADt5dCu07LhHoe4tkF1UeKDR6BKAW16o8" +
       "Endamt/2QkjzVYcUvOpFkGaRfue1TLtsyIN3n7Do/Zew6AeL5G8BFhU6f30W" +
       "ve9WWTQDON9yiPctLwyLTo4a7e19cGLvJWkfvITsf1AkPwIWAkDpjzcTnib4" +
       "R2+V4GWlmKDtCb5m8+tXR/BtJ4sx+ITqkp5nL6H1I0Xy4QiYHQi9unu0j/Y0" +
       "tc+7J/oSastqQKS3Tw+pnb4w1B6cVNjT+LOX0FjsCT74p1HlETC9oL3A2hVH" +
       "ruyWba1cvZgCbo8jdknvz9yqdN8J6HznIb3vfNGl++8uofzjRfILUeWlQLrt" +
       "IA7No/28p+X73K0ult4A6Fwd0rt6Yeg98XAlvYek/tolpH66SD4BYsGqMFov" +
       "0LVjWmcntH7yVmUrlE5lT+v2haH11KnIwYkqnpn9CqZcrtkPyh4OfvMSPnyu" +
       "SD5ztFY+J+rn3QX9fOQzAOh7Dsl/zwuu2uX07LdO6PyDS+j8wyL5H1HlvpJO" +
       "0YpM4L7Okfs/b1Wzq4DM9x+S+/4XWrMPtBPN/tNLKC336X4pqrwKaPZcDyJL" +
       "PXRehe8qj3YWrRonZP/xLZD9WJH5VkDujxyS/SM3S/bFD4FOEXTlyiVlZcT+" +
       "i70ZnzoDXzqCEwq/clMnfcGq5eQ/L4oD/I9e8z87+/+GUT/yzAN3P/LM7DP7" +
       "5ydH/99yD1u524ht+/Sx11P3d/qBblgl1ffsD8H6JSkvAUu8G1qJAWMtvwvk" +
       "V+7dN74/qrz+eRpHwHQc43Sjh6LKqy9pBPhw8uN0u5dHlQfPtwOgyu/T9R4B" +
       "PZzUiyp37m9OV3kMoAJVittX+0eOjLixBWlLCaNi8XsirGz/vOXRU7q6f2z8" +
       "8PMpwKkHwI+fWYeU/8R09Ig1Hh0udz76TJ/7ti9hP77/3wzVlne7ope72cpd" +
       "+7/wKDstHtO+8bq9HfV1J/22L9//0/e8+WhFc/8e8IndnML2+ov/pKLr+FH5" +
       "txK7n33kZ77+w8/8dnnK+f8BFEbwuiJLAAA=");
}
