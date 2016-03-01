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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZRXTZqt2wOkEhvr9Rc7uXBiBtjbMTJfd");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("bd0dVVWtJ2I0GWRkzU1q3nS6SJWVMKKtnrTgOGlrc2tMcqbbsTDtdHi6teF4" +
       "IIQ+OusJ/saozodIh+FDfcQvpo7DsmYPmisgmK2LSweBlZSdZUM1rdNaxtOw" +
       "vqLyuL1QGmza7i/wmQu82bqpE83JeNYSG7OG5U4JO5vz4tYg6ptY8AaiT7Rb" +
       "1WjCpZCJ1TYdesyjTGOKjDkw/W1UQ56DkNIaok6mL9kGDVWRONblDtaMWDKl" +
       "nSa+zgcLZ6O2ljnKtNym7454bK1I0IbKF5qmcTGDzOKcVefBil5zcGunRk69" +
       "lbNoez1oUV08A36cRgyspi3aXN6ekFKHcPJx3o+qjdFMrEO5zLMi13SQjkEz" +
       "QRcN5EhSSCObYOuWvuZagjfssqnVGau1NtOnBLybheHCEtmV4VVdHKk6fS6b" +
       "0wTXQNurTjNpTXC4Jay77V4u91120O96I5mIaG1eS2liEwzFXbXriGB1ypl8" +
       "B+PqSl9ek4Sowa7Zo5turRiYwfH2dkSIw+FE20VLKrJb6YYMTFpqCdUBLmSK" +
       "W7VhrZoJMd5DZh0mxNeQFeA52SHtRieh1wqfbRF1wcnGdILX3fZuy2iwvk4i" +
       "b4DrREQoSwJlSUfp9WdeJDsivVrjkJtyq7WcMETHmDQ2OZER0HS9he06HjN9" +
       "AVEHXK9VXwt9KyFWEmwKqDYnW4butnmzNVwmMocHBpZV2fUoI7qeSqTtrsj0" +
       "3dkEmWzWZFscDJo7uJqOlR6Bal0Q3sYOwueWSoW1Nmqkw1hxl4TRb7EEg/kN" +
       "Ls1jj9rOhbY+c+uKsO1FuhfBEGC9mVbdGF4lY9LnCQWXscmohcNBcyA5G8xf" +
       "44LAGWxez6qU5tHisJ7QU9yG7d4W1npkew0xPjmjRQrq4T18jW46eMblydxs" +
       "zGHaC6IacIVk1qi1hqHanoLgAApnybI1jnVsKUchbLf1NIWtvijrcxJlJ40Z" +
       "iJQUYd0ZLaqDdtqJ1I3CtdOGmlqTdiML2hwO9bSWn/EkWKKS1d5wk2aRD1uI" +
       "xsTcdEQEUMaK0cb0+OViUV/Vpzm3RLMN7vER0d0BoaQgmK2R08Fim7rVBFrm" +
       "eXUKOV0GG4Opgd22EiylKY/JMHSeBxsM67IzA2LZgdQYb5NJQE65PociG5Ee" +
       "0vnGI3YdZY7iXGrgkxz3IZaJB1pHsEeL7bCR0MpybCKMwC4IkRrlM5hZYjkO" +
       "c71FSrKdiAqtXgduIDCy6jZStO2RM7Sz0nXGy1BoziXdSV+yuFWYWGsrnZv1" +
       "6obGHJ/fiKhsOWD1s6jLzs6tW7qDtMw4tfw+NkFwfzWprXZZfzYMsOYiMzS1" +
       "HTMLKequoJo38EkHsifMnAqGjY4pTLZTz4vHfhOxe2w2sqz2HMkVXHPCbWDF" +
       "iF119RW3UhC0zarT7SrntozesiZTrNcJG5xTTUcDpXhCN21viHQWdmdMR4jE" +
       "egv2hPF8I4Z9tN12ibq1I3x2tAVLu8mam3vU2pLdHk3FukERW1HizapuQe2d" +
       "Z8mLaduGMwnZCozdbg8MT0o3UVjPMqhHbayZPWfYzXZC5RTNpjKar2Il2Mp4" +
       "vCM7fb/jVRkI00O2B3jNGhhWPP5/9e09/n+kfJ1xeo5jYyFFwV/exhP+fdGF" +
       "fYSVk7da5/b+n3k1VNZ8/GT/ol95882OZ5SbRz/xjR97TmW/t37teJ8gWryA" +
       "c70vsbRYs8509RDo6b033/ZHl6dTDnvvfvobf++J2fvWz97GVva3XsB5sct/" +
       "TD//s4MvUj56rXLH6U68G87NnG/09Pn9d/f7Whj5zuzcLrw3n3K23NxZvNP+" +
       "pmPOftPFl24H2V3+Qvvde9mXZYdtmEf7CievsR45fWU48CVvbSpB0eroyQut" +
       "zmzePHpXkbwlrNzlFa+YL315FLvH73gLrTp66+3s7iwyjt54yoZHi8wngF7/" +
       "633b/fftsOHZK9ngV955cz0q94jvN1w/94+e/Pmve+7J3yz3/N5rBgvJx3zj" +
       "kvNGZ9p87vnP/P4vvfrNnyyPItwpS8Fe0BcPat14Duvc8aoS/gOnDCl2X1Te" +
       "BqAfM2T//XIffJF9UzU0CAeYecU3vdB0DMKJTd91bOBEX5nTNrcyaHqpvslZ" +
       "qF2q4cUbyaPO8fvpoy+/4v30u8+5y7stzTH2h5yKjaRHyPGux6L/CycDXnN4" +
       "d9u1XEcrjiec399gutdPz/mBwvQypEdv3CMtBzvjaS/T3bPGSF1RxhTJEBiq" +
       "UuDak3FF9Um6/25dUYcvEiis3GtoIXdq/ue2GB2yS+OvvQTjL/f1kMDo/8Ox" +
       "8X/65TH+e8sK95bSPS/Gs46w0Tspe2dZVuwEuY6FoW+CCE9Tu2swYSjAcoeh" +
       "Vp6gKSqXm8Dgk3aPn/apu0B/Z6ADSsrc6JRrX3LLp0r67vEG+1IMz1whIrNI" +
       "xLByv+pLyenWhKP3HETylS9VJO8CovhfxyL5o5dHJPeUFe45Mbi91T17YOlJ" +
       "cqSWRAZXMCAqEiesPKqbllXwHJeUreG7kaNeYIT7UhlRbIp5cN92//3SGXHt" +
       "1CUdPXvuwM352WkqJWXo9IzyLyaf/cXvzj/1/P48TTHLhJXqzQ5J33hOuzhW" +
       "d8UUeOb47B8P/toLv/vfFu8/Cc5edcqLekE6fBUvzruJ4yM15Ymvow+WQvu6" +
       "KwT64SLJw8pDhUZzAGpxGeURuLPS/JqXQ5pvOKbgDa+ANIv0629k2lVDHn3w" +
       "wKKPXsGijxfJ3wYsKnT+5iz6yEtl0RzgfNcx3ne9PCw6HC3a2/v4YO8lad9z" +
       "Bdn/sEi+EywSgNKfbh48S/B3vVSChUoRvO0JvmGz6xdG8B2HhVrtQHVJz/NX" +
       "0PrJIvm+EJgdmHo152Tf7FlqX3QP9BXUltWASO+cHVM7e3moPTpU2NP4o1fQ" +
       "WOwBPvqnYeUxEF6Qrm/mxRErC7NMw9GKEHB3OmOX9P7wS5Xu+wGd7z+m9/2v" +
       "uHT/3RWU/1SR/ERYeTWQLu5Hwfpk/+5Z+b7wUhdSbwN0Gsf0Gi8PvQcPV9J7" +
       "TOovXEHqLxXJz4G5wCiM1vU19ZTW+YHWT79U2fKlU9nTunt5aD1zCnJ8UMVz" +
       "0S+/lsr1/FHZw9GvXcGHzxbJr5ysoy+I+kV3Pb8Y+UMA9EPH5H/oZVftMjz7" +
       "9QOdv3cFnX9QJP8jrDxQ0rk0wzVwXxfI/Z8vVbOrgMyPHpP70Zdbs4/Ug2b/" +
       "yRWU/lmRfD6svAFo9kLzQ1M5dl6F7yqPchat4APZf/QSyH6iyHw3IPc7j8n+" +
       "ztsl+/IHRGcIunbtirJyxv6LvRmfOfNeOoIDhX95Wyd7warl8B8XxYH9x2/4" +
       "z539/8Qon3zuoXsfe27+K/tnKyf/5XIfVblXjyzr7DHXM/d3e76mmyXV9+0P" +
       "vXolKa8CS7xbWokBYy2/C+TX7t83fjCsvPVFGofAdGz9bKNHwsobr2gE+HD4" +
       "cbbda8PKwxfbAVDl99l6j4EeDvXCyt37m7NVngCoQJXi9o3eiSPr3NqCFJOD" +
       "sFj8HoSV7p+3PH5GV/ePlB99MQU483D4yXPrkPJfmU4ev0bc8XLnU8+NmK/5" +
       "fPt79/+ToVhSnhe93EtV7tn/ZUfZafEI9+037e2kr7vJ9/z5gz903ztPVjQP" +
       "7gEf7OYMtrde/qcUhO2F5d9I5D/62A9/6fc99xvlqeb/Bw1tKoUuSwAA");
}
