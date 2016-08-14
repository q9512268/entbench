package org.apache.batik.transcoder.wmf.tosvg;
public abstract class AbstractWMFReader {
    public static final float PIXEL_PER_INCH = java.awt.Toolkit.getDefaultToolkit(
                                                                  ).
      getScreenResolution(
        );
    public static final float MM_PER_PIXEL = 25.4F / java.awt.Toolkit.
      getDefaultToolkit(
        ).
      getScreenResolution(
        );
    protected int left;
    protected int right;
    protected int top;
    protected int bottom;
    protected int width;
    protected int height;
    protected int inch;
    protected float scaleX;
    protected float scaleY;
    protected float scaleXY;
    protected int vpW;
    protected int vpH;
    protected int vpX;
    protected int vpY;
    protected int xSign = 1;
    protected int ySign = 1;
    protected volatile boolean bReading = false;
    protected boolean isAldus = false;
    protected boolean isotropic = true;
    protected int mtType;
    protected int mtHeaderSize;
    protected int mtVersion;
    protected int mtSize;
    protected int mtNoObjects;
    protected int mtMaxRecord;
    protected int mtNoParameters;
    protected int windowWidth;
    protected int windowHeight;
    protected int numObjects;
    protected java.util.List objectVector;
    public int lastObjectIdx;
    public AbstractWMFReader() { super();
                                 scaleX = 1;
                                 scaleY = 1;
                                 scaleXY = 1.0F;
                                 left = -1;
                                 top = -1;
                                 width = -1;
                                 height = -1;
                                 right = left + width;
                                 bottom = top + height;
                                 numObjects = 0;
                                 objectVector = new java.util.ArrayList(
                                                  ); }
    public AbstractWMFReader(int width, int height) { this();
                                                      this.width =
                                                        width;
                                                      this.height =
                                                        height; }
    protected short readShort(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[2];
        is.
          readFully(
            js);
        int iTemp =
          (255 &
             js[1]) <<
          8;
        short i =
          (short)
            (65535 &
               iTemp);
        i |=
          255 &
            js[0];
        return i;
    }
    protected int readInt(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[4];
        is.
          readFully(
            js);
        int i =
          (255 &
             js[3]) <<
          24;
        i |=
          (255 &
             js[2]) <<
            16;
        i |=
          (255 &
             js[1]) <<
            8;
        i |=
          255 &
            js[0];
        return i;
    }
    public float getViewportWidthUnits() { return vpW;
    }
    public float getViewportHeightUnits() { return vpH;
    }
    public float getViewportWidthInch() { return (float)
                                                   vpW /
                                            (float)
                                              inch;
    }
    public float getViewportHeightInch() { return (float)
                                                    vpH /
                                             (float)
                                               inch;
    }
    public float getPixelsPerUnit() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public int getVpW() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpW /
                                          (float)
                                            inch);
    }
    public int getVpH() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpH /
                                          (float)
                                            inch);
    }
    public int getLeftUnits() { return left; }
    public int getRightUnits() { return right; }
    public int getTopUnits() { return top; }
    public int getWidthUnits() { return width; }
    public int getHeightUnits() { return height; }
    public int getBottomUnits() { return bottom; }
    public int getMetaFileUnitsPerInch() { return inch;
    }
    public java.awt.Rectangle getRectangleUnits() {
        java.awt.Rectangle rec =
          new java.awt.Rectangle(
          left,
          top,
          width,
          height);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectanglePixel() {
        float _left =
          PIXEL_PER_INCH *
          (float)
            left /
          (float)
            inch;
        float _right =
          PIXEL_PER_INCH *
          (float)
            right /
          (float)
            inch;
        float _top =
          PIXEL_PER_INCH *
          (float)
            top /
          (float)
            inch;
        float _bottom =
          PIXEL_PER_INCH *
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectangleInch() {
        float _left =
          (float)
            left /
          (float)
            inch;
        float _right =
          (float)
            right /
          (float)
            inch;
        float _top =
          (float)
            top /
          (float)
            inch;
        float _bottom =
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public int getWidthPixels() { return (int) (PIXEL_PER_INCH *
                                                  (float)
                                                    width /
                                                  (float)
                                                    inch);
    }
    public float getUnitsToPixels() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public float getVpWFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      width /
                                    (float)
                                      inch /
                                    (float)
                                      vpW; }
    public float getVpHFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      height /
                                    (float)
                                      inch /
                                    (float)
                                      vpH; }
    public int getHeightPixels() { return (int) (PIXEL_PER_INCH *
                                                   (float)
                                                     height /
                                                   (float)
                                                     inch);
    }
    public int getXSign() { return xSign; }
    public int getYSign() { return ySign; }
    protected synchronized void setReading(boolean state) {
        bReading =
          state;
    }
    public synchronized boolean isReading() { return bReading;
    }
    public abstract void reset();
    protected abstract boolean readRecords(java.io.DataInputStream is)
          throws java.io.IOException;
    public void read(java.io.DataInputStream is) throws java.io.IOException {
        reset(
          );
        setReading(
          true);
        int dwIsAldus =
          readInt(
            is);
        if (dwIsAldus ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                META_ALDUS_APM) {
            int key =
              dwIsAldus;
            isAldus =
              true;
            readShort(
              is);
            left =
              readShort(
                is);
            top =
              readShort(
                is);
            right =
              readShort(
                is);
            bottom =
              readShort(
                is);
            inch =
              readShort(
                is);
            int reserved =
              readInt(
                is);
            short checksum =
              readShort(
                is);
            if (left >
                  right) {
                int _i =
                  right;
                right =
                  left;
                left =
                  _i;
                xSign =
                  -1;
            }
            if (top >
                  bottom) {
                int _i =
                  bottom;
                bottom =
                  top;
                top =
                  _i;
                ySign =
                  -1;
            }
            width =
              right -
                left;
            height =
              bottom -
                top;
            mtType =
              readShort(
                is);
            mtHeaderSize =
              readShort(
                is);
        }
        else {
            mtType =
              dwIsAldus <<
                16 >>
                16;
            mtHeaderSize =
              dwIsAldus >>
                16;
        }
        mtVersion =
          readShort(
            is);
        mtSize =
          readInt(
            is);
        mtNoObjects =
          readShort(
            is);
        mtMaxRecord =
          readInt(
            is);
        mtNoParameters =
          readShort(
            is);
        numObjects =
          mtNoObjects;
        java.util.List tempList =
          new java.util.ArrayList(
          numObjects);
        for (int i =
               0;
             i <
               numObjects;
             i++) {
            tempList.
              add(
                new org.apache.batik.transcoder.wmf.tosvg.GdiObject(
                  i,
                  false));
        }
        objectVector.
          addAll(
            tempList);
        boolean ret =
          readRecords(
            is);
        is.
          close(
            );
        if (!ret)
            throw new java.io.IOException(
              "Unhandled exception while reading records");
    }
    public int addObject(int type, java.lang.Object obj) {
        int startIdx =
          0;
        for (int i =
               startIdx;
             i <
               numObjects;
             i++) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
              (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                objectVector.
                get(
                  i);
            if (!gdi.
                   used) {
                gdi.
                  Setup(
                    type,
                    obj);
                lastObjectIdx =
                  i;
                break;
            }
        }
        return lastObjectIdx;
    }
    public int addObjectAt(int type, java.lang.Object obj,
                           int idx) { if (idx == 0 ||
                                            idx >
                                            numObjects) {
                                          addObject(
                                            type,
                                            obj);
                                          return lastObjectIdx;
                                      }
                                      lastObjectIdx =
                                        idx;
                                      for (int i =
                                             0; i <
                                                  numObjects;
                                           i++) {
                                          org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
                                            (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                                              objectVector.
                                              get(
                                                i);
                                          if (i ==
                                                idx) {
                                              gdi.
                                                Setup(
                                                  type,
                                                  obj);
                                              break;
                                          }
                                      }
                                      return idx;
    }
    public org.apache.batik.transcoder.wmf.tosvg.GdiObject getObject(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                 objectVector.
                 get(
                   idx);
    }
    public int getNumObjects() { return numObjects;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "oXf2UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "3SpudTtjCxYMYSCVO2Oz1+j2lyNlMtEx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NrTKslmCeqTX61cZBzQXyzZZL5tgOF42KlUY00K/xUWz1bxm95kZTq1C3iKL" +
       "mE+rykabGaSZ1qgeJOMDgjIUv6FBCdaeVkpRsyvMRqv6iFZmHbbHu6Gtregh" +
       "1WSbsjTT212Ym3Wr3FB1ZCaOY9BfXPmwP+5jo/YUYg2rXG6m/LRuIQsHX9J1" +
       "Nxg00r4BJ7TEihOKpzTWilIdjixyKhspOVYlDCPbXCVO6pjFd92esQmMgciY" +
       "3VqbZJ1ic7TRLAduksD/zrqNSjmemTW4ntpob7Kml+PEF+l5pyG25fkCBo0K" +
       "rPXB8Dsr12HqfWe4mHfWVUlPMJGljMpgtJjQiu+XxWCJaH3W0FvyqqZ3G8F0" +
       "mg6nLbpnUawns1p5aE0nWqVErcw20jUqZEPdyHDDXiqz1FZkSgON8cxj4gYr" +
       "GdCCoY3OaObQdtJICErzxhoZ0QNfNKRKk+7Q5MIv6tVG0JkmxTlR18osU8fL" +
       "bbJPRFGEGZZUESl6oU2doQ7VcXcIyvN6zJTUKAFFULM7b9XxljadRqAT2Ksp" +
       "YNBAsmSn2S0De5syi2HHLzZbYLgYCDODs2caztcAz+bEB4J0powWsGrGEzOE" +
       "RiChOj4pGeVFrzUbQClbHOKOL3c0P8AaFb5J0yrCDdwKa9LlVl2pOVxp5pJD" +
       "v14Jh07QJ1oVC5QJBheLpNXshnVkZpLcCpTX4ftEvQQZ1QUxoqApCVkiWYGt" +
       "qCQxWpy9f7wS6bq+1HGz1K6kZayfMlSibhyVbixw1I6mS0ZTxRVIqOKNDgmz" +
       "br9lNtOG2HCMrlWamy2TVOUmt+CcUmXerajAkmYdAh1pc2ymVWaZnHlv3eTH" +
       "koab3jhy45FLTWYDuj2sp8FQ0xhmHsmA34TvUSIr2/16i9Q1UNmF4SDxIz/B" +
       "62rLYD2Wq+NOjKs+EiVkymLj4dTZ6Lo6SCmfUzm/nLDoQqj263WQY91vlhW9" +
       "j3PNtkEYRNQEgHwSW4ekmI5GoPNDR9go1M3pxNcamDakKmOKrgBdU13FIRKE" +
       "lwdzuFRdbMTqEFmuCJjETHotrfyQoioi0AdI6hPrrh/MDA0uLTdgXF8elSp2" +
       "cxYpbWkqdslQ6bvl4orFqQyDy60BBmmFW/F6OSZHAlZrujSl22lz2p+0YQsR" +
       "1tW2Wq+zM4+KNg5o3EZ9BQoJsuWl+HResbsLPCYZwUOZcK45me4EHZuXSbiV" +
       "CsjU7ExW7VZtLvLhVGiSYskLbC+cUkl1QLe6ZLIWu2mENVCCMM1Fo90Spxst" +
       "rvSRijrWNFM0E1tb5GVq1VGrAc+nsRy2qQWqMg2vLtuTuNlWCLRpGXWK9NCe" +
       "GhNtc+2JGz5RsUUXRWpsmRcmwYCv86q/qHE9FUbKqK024pAgIqbdFxWnOunG" +
       "WqM5lBkXlvBlv8r6bVapJ+mQEMkq12PnZAsBBl4RWs0W3tJXYNSi8eyCDurz" +
       "VmVqkkgD7StBry5QqzYVAmm0KiUBb3b7C6WK67M1LyeiTTRra0Pl5NRpTkmy" +
       "Ljb5ueoMlIqw1heGWqY0BscrJTJliI6Hcj2hX6GbCw6lYOATA3wxsDyv0Yrr" +
       "LRuLN5SSzERVLvUTpDhIR9F0NmSGAVWySkpnUeKDEdufW/OZmiTWOLLqKVE1" +
       "XUhKys2h5lhUpdhOx/ICIvBKG580gTEpo9UMmbDiqNgD/TlmRZWdtkGZyGrl" +
       "IXw/aQZae82z2koZThFhhNbZuUDrcps1vVWDNGPOnPQXljhymybZXdmrRrFB" +
       "FEuLUi2e8Ti9KtOsN1XmJDlsriWhg2LEuFJTpSkCdwlygfOdyNGWranWnfN1" +
       "PHV4JGRqI2OWBP21GJXlBlHrN9t2bLYx4HgJYpT2rQZHmE2mWNl4Qj0RZkPM" +
       "DpD2ptvVK5g2SJU6tKAWXpI2ZzizapVYT23LM2eY9Cet5aIYD5djA4KHph5A" +
       "rY2cVGXDj1KMXWugh2Ga1EbfMLg3g4IqaQWuS6YoZo6QURepVIQSjXnyhvEE" +
       "H0vmzFxZzLR0XeoSCF0fF9eLWayOJzwbDHVzpbYtERJoWVcGYUUNXGsSAIvg" +
       "EntYRpqb2aRvgFpEth28UlxiVic2W5Vqk/ZrURSGKimIsjuawg0l6moh2fX0" +
       "eoiKi3iGLRgNR9IaTMLDmpFaqxoGlBQtG8a6zmBhC9GW7W5koJDBzBO1Ul2s" +
       "13NoqCgLShl0vUGjW/dnY8RAKDisjBZOxUqnOBWVVTecLdkI4iZjQ2n36rpE" +
       "VuGUtNlmKcVaaUmNG4lBLq2ijUYOMuOYDb1R2o3WZlOebKQZRUcTuDM1OsAH" +
       "F0U/XaYTY8UnnbaHBj2oSI98yQgCKBrUkRrsVXozaAzVygwMjXhdQUYryW7U" +
       "kDXr18pQDbeQSQOvdoyiA/fN5ahvd2VludEqZknQmmaDV4u811r5uE7oYbdD" +
       "C4ExH+pLLeg0YgcR+60Ys5M2HSlrUIY6N6lUdCFY40ww1kmLvMAIcmKWplbo" +
       "DrwOrkRtER+V+ESTCV2kBtWZRfEr0TBkOWaCYCnX4g3RReCqy1jNuIbUwXhu" +
       "YJNVYwLXjBBZz4sUoqDOXIGnKpGtOu4J17ZcdX++Mnd5h+/KxLJC2GtYkUrO" +
       "+LDrqbBwu7DbxHi4myz/d2/h2JbRI0ucecqHDjYc+YVHTtvVm2+O+cA7Xny/" +
       "NPyh8sEabiss3BE67ptNeS2bR4p6ApT0zOmrwv18U/Ph1pBffsefPjz5Ku1t" +
       "17AR8rFjOI8X+R/6H/qV9hvF79ov3HR5o8hV262vzPTsldtD7vTlMPLtyRWb" +
       "RB65LNlXHCwej3eSHR9fPD5U7JmL9nnc4S6hvW2Cg+Xa7aY03bnUEEKBtt0o" +
       "HIe+LFhZ3r307LwvP8hLD5sJ8DKZSPN8z2dBCHQHSpLGmuOHJ62X3hJcjsmX" +
       "r6Nr2aOUPdjzLksrW90vvBpcz+2k9dyFSit72San9h2nJ/jmPMG7suCFsHBb" +
       "xp3e7dc6JPnO6yCZV7jsQ0dzR9K8VpJPnUjyyMaxvfeeEfe9WfDusPCgKocz" +
       "XY5doL78o56prW/1+LWHRF+8XqLZx5PBjmhw8UQ/cEbcv8+C7w8LrzxCdPuR" +
       "0ElMf+B6mWafSm92TDcXz/Qnzoj7qSz40bDwiuMqpXfbLo7w/NBFmO7bdzzf" +
       "fvE8P3pG3M9lwc9cabpbjZ5A9CPXS/R14HphR/SFiyf6iTPifjULfjEs3AeI" +
       "MnoCWk1G9jOrPcbxJb+eP4Nj1t7n50S8a8fxXRfP8dNnxP1WFvy3sHBrpszd" +
       "fo5DZr95Eczes2P2notn9vkz4n4vC/7HATPqGLP/eb3MXgOu9+2Yve/imf3Z" +
       "GXH/Owv+KCzcDZj1ZOXQkR7h98fXyy/bT/GDO34/ePH8vnRG3N9nwV+FhZcB" +
       "fqMrWoojBP/P9RJ8GFwf3BH84IUT3L/5jLhbMzhfDgt3AYITxz2B3v5LfsJ+" +
       "Hv395I7eT148vfvOiHsgC+7a6u/KPs0RgndfL8GsP/+RHcGPXDzB154R92gW" +
       "vCos3AMIHuvLHGH40EUw/Pkdw5+/eIZPnRH3TBY8sWVI5ht+T2L45PUyzHox" +
       "v7Rj+EsXz7ByRlw1CyAwaAMMwdhSaOmmnHMEbfxBP+YI1dJ1UH3wgOqndlQ/" +
       "dfFUv+aMuOzb5v1nw8L9mT+VRTCAVndc8+Rg9PlAPvoU4vDS5fhD6m+9Dur5" +
       "PrjsQIPP7Kh/5uKpD86IY7KAPkZ925fbUX/1Zeqq7FiH/OHGoQQ61yuBbPz1" +
       "hzsJ/OHFS+Drzoj7hizgtp3Yy+R2Br4/OuQ4vwhv9Vc7jn918Ry1M+JWWSBu" +
       "vVXe4Bxq+EgVli5iKPJ3O4Z/d/EMwzPi1lngbLWY19yJc8jxcCiy/5LnVLwU" +
       "x0yLX95x/PLFc/zWM+LekQXfuO3WgqHI9iimY/y+6QL47d2yzbv9e7H8jk9p" +
       "HY3LZrP2XzjgR53I73qmtPJa+CiAeteO310Xz++MKa39bEpr/91h4d7LvaIT" +
       "q+H1TGblFIFH3XtgR/GBi6d4xmTWfjaZtf/9YeF2QHF+eZv4Ibfrmb66zO3V" +
       "O26vvnhuZ0xf7WfTV/s/uuW2OIHb9UxZZYPlwrMA5iM7bo9cA7eDvfB3Bylo" +
       "tnzH1jcHhwgdo3M4gVz4bM7pY2fw/fks+JmwcGeQNYyn7qm/ee3o0qEUrmc+" +
       "6/Hs4dMA4BM7KTxxrVLIVqr2f/Yl1fzrZ8T9Rhb8cr4Nfsc6F9chw09cB8N8" +
       "oQXQ3NudV7N31Xk152G4t3pJhr9zRtzvZsF/z05zkoFqsx+/cMju09fB7rHs" +
       "4TOFbPPlll3vmq34dHbHV0f2/+D0BPnqyP4fZsHnwsJd2erIdht1cEyXn78O" +
       "tnnrAbrue/KOrXwNbM/wR1cR/YuXIvqXWfAFUBUzosf0+WfX63EfAq/azXPt" +
       "XdA81/6hwrf+88qtnNt9pzmzfzzdjG/KgOz/LaiogiRtsxwWmFP/0gXMgO19" +
       "dEf9oxdD/aY8Qb6qno86/ym/y/nceQbXu7PgFmDKl7kSx9jedOv1DsCzntFv" +
       "7tj+5kWb8o7jK8/g+FAW3A/0CdrXI9vRgW1A5zv2uC3pR/LlQnngAmYJ9357" +
       "J5TfvhihHOX85Blxb8yCx7azhIMrd+gfEnz8ms7aBOP8q86Gzg66feiqQ+q3" +
       "B6uLP/7+e29/1funv50fj3z58PM7eoXblcg0j54/eeT+VteXFT3nfkce3uPm" +
       "hN4cFt5wLk2Cpin/mxG46U3bzKWw8NhLZA5B7bKUo5mQsPCaMzKBvs3hj6P5" +
       "qsAfHc8HQOV/j6argRIO04WFW7c3R5O8FaACSbLbr3TzGp9sv2l46IjVbb+W" +
       "eUljPfJpyxNXfJCS/1cEBx+PRMzuNIQPv78z+MYvVn9oe0a0aAqbTVbK7b3C" +
       "bdvjqvNCsw9QXndqaQdl3Uo9/Q/3/MQdbzj4WOaeLeDDGnAE22MnH8jctNww" +
       "P0J585FX/ce3/vD7P5tvmf9/baN5TyNiAAA=");
}
