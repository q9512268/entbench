package org.apache.batik.ext.awt.image.codec.util;
public abstract class SimpleRenderedImage implements java.awt.image.RenderedImage {
    protected int minX;
    protected int minY;
    protected int width;
    protected int height;
    protected int tileWidth;
    protected int tileHeight;
    protected int tileGridXOffset = 0;
    protected int tileGridYOffset = 0;
    protected java.awt.image.SampleModel sampleModel = null;
    protected java.awt.image.ColorModel colorModel = null;
    protected java.util.List sources = new java.util.ArrayList();
    protected java.util.Map properties = new java.util.HashMap();
    public SimpleRenderedImage() { super(); }
    public int getMinX() { return minX; }
    public final int getMaxX() { return getMinX() + getWidth(); }
    public int getMinY() { return minY; }
    public final int getMaxY() { return getMinY() + getHeight(); }
    public int getWidth() { return width; }
    public int getHeight() { return height; }
    public java.awt.Rectangle getBounds() { return new java.awt.Rectangle(
                                              getMinX(
                                                ),
                                              getMinY(
                                                ),
                                              getWidth(
                                                ),
                                              getHeight(
                                                )); }
    public int getTileWidth() { return tileWidth; }
    public int getTileHeight() { return tileHeight; }
    public int getTileGridXOffset() { return tileGridXOffset; }
    public int getTileGridYOffset() { return tileGridYOffset; }
    public int getMinTileX() { return XToTileX(getMinX()); }
    public int getMaxTileX() { return XToTileX(getMaxX() - 1); }
    public int getNumXTiles() { return getMaxTileX() - getMinTileX() + 1;
    }
    public int getMinTileY() { return YToTileY(getMinY()); }
    public int getMaxTileY() { return YToTileY(getMaxY() - 1); }
    public int getNumYTiles() { return getMaxTileY() - getMinTileY() + 1;
    }
    public java.awt.image.SampleModel getSampleModel() { return sampleModel;
    }
    public java.awt.image.ColorModel getColorModel() { return colorModel;
    }
    public java.lang.Object getProperty(java.lang.String name) { name = name.
                                                                          toLowerCase(
                                                                            );
                                                                 return properties.
                                                                   get(
                                                                     name);
    }
    public java.lang.String[] getPropertyNames() { java.lang.String[] names =
                                                     new java.lang.String[properties.
                                                                            size(
                                                                              )];
                                                   properties.
                                                     keySet(
                                                       ).
                                                     toArray(
                                                       names);
                                                   return names;
    }
    public java.lang.String[] getPropertyNames(java.lang.String prefix) {
        java.lang.String[] propertyNames =
          getPropertyNames(
            );
        if (propertyNames ==
              null) {
            return null;
        }
        prefix =
          prefix.
            toLowerCase(
              );
        java.util.List names =
          new java.util.ArrayList(
          );
        for (int i =
               0;
             i <
               propertyNames.
                 length;
             i++) {
            if (propertyNames[i].
                  startsWith(
                    prefix)) {
                names.
                  add(
                    propertyNames[i]);
            }
        }
        if (names.
              size(
                ) ==
              0) {
            return null;
        }
        java.lang.String[] prefixNames =
          new java.lang.String[names.
                                 size(
                                   )];
        names.
          toArray(
            prefixNames);
        return prefixNames;
    }
    public static int XToTileX(int x, int tileGridXOffset,
                               int tileWidth) {
        x -=
          tileGridXOffset;
        if (x <
              0) {
            x +=
              1 -
                tileWidth;
        }
        return x /
          tileWidth;
    }
    public static int YToTileY(int y, int tileGridYOffset,
                               int tileHeight) {
        y -=
          tileGridYOffset;
        if (y <
              0) {
            y +=
              1 -
                tileHeight;
        }
        return y /
          tileHeight;
    }
    public int XToTileX(int x) { return XToTileX(
                                          x,
                                          getTileGridXOffset(
                                            ),
                                          getTileWidth(
                                            ));
    }
    public int YToTileY(int y) { return YToTileY(
                                          y,
                                          getTileGridYOffset(
                                            ),
                                          getTileHeight(
                                            ));
    }
    public static int tileXToX(int tx, int tileGridXOffset,
                               int tileWidth) {
        return tx *
          tileWidth +
          tileGridXOffset;
    }
    public static int tileYToY(int ty, int tileGridYOffset,
                               int tileHeight) {
        return ty *
          tileHeight +
          tileGridYOffset;
    }
    public int tileXToX(int tx) { return tx *
                                    tileWidth +
                                    tileGridXOffset;
    }
    public int tileYToY(int ty) { return ty *
                                    tileHeight +
                                    tileGridYOffset;
    }
    public java.util.Vector getSources() {
        return null;
    }
    public java.awt.image.Raster getData() {
        java.awt.Rectangle rect =
          new java.awt.Rectangle(
          getMinX(
            ),
          getMinY(
            ),
          getWidth(
            ),
          getHeight(
            ));
        return getData(
                 rect);
    }
    public java.awt.image.Raster getData(java.awt.Rectangle bounds) {
        int startX =
          XToTileX(
            bounds.
              x);
        int startY =
          YToTileY(
            bounds.
              y);
        int endX =
          XToTileX(
            bounds.
              x +
              bounds.
                width -
              1);
        int endY =
          YToTileY(
            bounds.
              y +
              bounds.
                height -
              1);
        java.awt.image.Raster tile;
        if (startX ==
              endX &&
              startY ==
              endY) {
            tile =
              getTile(
                startX,
                startY);
            return tile.
              createChild(
                bounds.
                  x,
                bounds.
                  y,
                bounds.
                  width,
                bounds.
                  height,
                bounds.
                  x,
                bounds.
                  y,
                null);
        }
        else {
            java.awt.image.SampleModel sm =
              sampleModel.
              createCompatibleSampleModel(
                bounds.
                  width,
                bounds.
                  height);
            java.awt.image.WritableRaster dest =
              java.awt.image.Raster.
              createWritableRaster(
                sm,
                bounds.
                  getLocation(
                    ));
            for (int j =
                   startY;
                 j <=
                   endY;
                 j++) {
                for (int i =
                       startX;
                     i <=
                       endX;
                     i++) {
                    tile =
                      getTile(
                        i,
                        j);
                    java.awt.Rectangle intersectRect =
                      bounds.
                      intersection(
                        tile.
                          getBounds(
                            ));
                    java.awt.image.Raster liveRaster =
                      tile.
                      createChild(
                        intersectRect.
                          x,
                        intersectRect.
                          y,
                        intersectRect.
                          width,
                        intersectRect.
                          height,
                        intersectRect.
                          x,
                        intersectRect.
                          y,
                        null);
                    dest.
                      setDataElements(
                        0,
                        0,
                        liveRaster);
                }
            }
            return dest;
        }
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster dest) {
        java.awt.Rectangle bounds;
        java.awt.image.Raster tile;
        if (dest ==
              null) {
            bounds =
              getBounds(
                );
            java.awt.Point p =
              new java.awt.Point(
              minX,
              minY);
            java.awt.image.SampleModel sm =
              sampleModel.
              createCompatibleSampleModel(
                width,
                height);
            dest =
              java.awt.image.Raster.
                createWritableRaster(
                  sm,
                  p);
        }
        else {
            bounds =
              dest.
                getBounds(
                  );
        }
        int startX =
          XToTileX(
            bounds.
              x);
        int startY =
          YToTileY(
            bounds.
              y);
        int endX =
          XToTileX(
            bounds.
              x +
              bounds.
                width -
              1);
        int endY =
          YToTileY(
            bounds.
              y +
              bounds.
                height -
              1);
        for (int j =
               startY;
             j <=
               endY;
             j++) {
            for (int i =
                   startX;
                 i <=
                   endX;
                 i++) {
                tile =
                  getTile(
                    i,
                    j);
                java.awt.Rectangle intersectRect =
                  bounds.
                  intersection(
                    tile.
                      getBounds(
                        ));
                java.awt.image.Raster liveRaster =
                  tile.
                  createChild(
                    intersectRect.
                      x,
                    intersectRect.
                      y,
                    intersectRect.
                      width,
                    intersectRect.
                      height,
                    intersectRect.
                      x,
                    intersectRect.
                      y,
                    null);
                dest.
                  setDataElements(
                    0,
                    0,
                    liveRaster);
            }
        }
        return dest;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVcDZQU1ZV+3cPPMDA/DP8/M/Iz6AF0WolsIKPEYfgb0gPj" +
       "zIgwiENNdc1MQXVXUVU902CIaM4KiUeOi/iXEzExKEZBXE9MNhoNWXfFrK7n" +
       "YIhGPSjZbLIYdcVE3R93N3vve6+6qqv7PWhj7/Y59bq63rvv3fu9e+9779Z7" +
       "ffh9MtyxSb2Wchvd7ZbmNC5Pue2K7WiJFkNxnC541qPeXab88fozaxZHyYhu" +
       "UjWgOG2q4mgrdM1ION2kTk85rpJSNWeNpiWQot3WHM0eVFzdTHWTCbrTmrQM" +
       "XdXdNjOhYYF1ih0nYxXXtfXetKu18gpcUhcHTmKUk1hzOLspTsaoprXdLz45" +
       "ULwlkIMlk35bjktq4luUQSWWdnUjFtcdtyljk/mWaWzvN0y3Ucu4jVuMhRyC" +
       "1fGFeRDMerz6k09vH6ihEIxTUinTpeI5HZpjGoNaIk6q/afLDS3pbCNfI2Vx" +
       "MjpQ2CUNca/RGDQag0Y9af1SwH2llkonW0wqjuvVNMJSkSGXzMytxFJsJcmr" +
       "aac8Qw3lLpedEoO0M7LSMinzRLxzfmz/3dfXPFFGqrtJtZ7qRHZUYMKFRroB" +
       "UC3Zq9lOcyKhJbrJ2BR0dqdm64qh7+A9Xevo/SnFTUP3e7Dgw7Sl2bRNHyvo" +
       "R5DNTquuaWfF66MKxX8N7zOUfpB1oi8rk3AFPgcBK3RgzO5TQO84ybCteirh" +
       "kgvCFFkZG74CBYB0ZFJzB8xsU8NSCjwgtUxFDCXVH+sE1Uv1Q9HhJiig7ZKp" +
       "wkoRa0tRtyr9Wg9qZKhcO8uCUqMoEEjikgnhYrQm6KWpoV4K9M/7a67Ye0Nq" +
       "VSpKIsBzQlMN5H80ENWHiDq0Ps3WwA4Y4Zh58buUic/siRIChSeECrMyP/rq" +
       "h1ddXH/sBVZmWoEya3u3aKrbox7srToxvWXu4jJko9wyHR07P0dyamXtPKcp" +
       "Y4GHmZitETMbvcxjHc9v2PWI9m6UVLSSEapppJOgR2NVM2nphmav1FKarbha" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lBx2GAvv1Dnc74SmxyImNyJ8pjdNmzPL05NJsOyZnOdYleUYRlcd35ihNEe3" +
       "+WRWISlx0kJk0qLKTUEydbVpdPwRxQhWsBIcdNlFRoLeai0L2mg1ZxwuyLfw" +
       "OZYqzhgEuiaq2+FM6NfNGia0au2p6AisycnSCmcduEwqJBLyllvswHN6FaSM" +
       "KFuFuFMzehHMgMjS5HSrNS4EYCa0wnu+SiI8U5U9vEsbDMEkHDaIxlLMLsuY" +
       "nsdMbGjWHB/njSULs0gDLiIchXtjX8ZN3F7VYrRdM0OltZZd0ce7YEiyhpUE" +
       "ncLYgF7ZSAMXGKsdw2NCmawSvQfmAwXEBu3VHVpyEKml95YDgUHY3jjQ1coY" +
       "qXPtitkbt4gCZVkq7a2Q0BkWnIpu4HPUF5mRwJhDFVZ79cksYbL2IizPwoNy" +
       "S2hH3WFocUMH74KAksVrVoVNRdroGVwvLkVAthJJOFibEYJC6BZbPY7V475s" +
       "aT1otHRUWANtrhIuazOmlV49qGLLUQGGjY46i+sLfER0Y3bWNQtbvhaGl02M" +
       "XPjUrOug1sKO+vXVrJmy9ohurnVfYAuzpea1cUtMYallWF0vP0YQX3Z9FJaJ" +
       "ch/mnaLaMlC/iafaMsDzqeWwNcdqzZHeQonhYqLNqqM+AsZ0kjTimKrZqJRO" +
       "acMDnBZNwgqWPMm6A9yvwrWKrNYJrOINR9NKM+TyPoi2mprH0tgURKntuhtI" +
       "JISUCaI4r1I9IkrlYhiUHaw343GmpSTx0JKXdEQ0q9CCa0YSMWDajXDBJAiY" +
       "z1TKCc2NbKg0qzgoa3HeME8UrNqqSGp61GtSTcFbsn6/lraCPO+1LbbUjNVq" +
       "QQajP+2qNbiWTBd4t0pUzKUSa8ig1DRKIqQNBs2SlHc6SRsYiApGXg1MvPhS" +
       "fah4KwMG054i349D1YOxWt7x+hMQ9ncr7R7dyA/l0rIZ2n4kTId9MBFaTcxV" +
       "njBny5YaKo4etBTBKMUOg3oiXy0J3tQvT0Z00cy71lCwZA0d4HkcCylSlAyp" +
       "SEazTi0thiusJiLDJZlMYBq1yxjH51EM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "6/Pgu91AuHfVBsKvD9+LZ/C9L0suAL7TDd8Tgdv+3efwNHFvuOU7PHdD3hD8" +
       "hjMIPpIlD5yq0P2XnwfBt2wJvuXrRPAbzyD4VJY8froGnzgPi9W2BLW/HYst" +
       "n8EXzpJLgG+2FxQo9aRCofPg6235en87fL/1DL5Ilrx+yxfo+KR+L5+HAW+f" +
       "ie+d0zPxqwy4fwZBMkuw0xXaOQ+C79oSfNfXieDkDIKZxvZHp2uQudmZx8MA" +
       "yvYp8d75PyXel8/Iy+Ki/W+LcheyyeN2T25Wbrc1dP15nvvOQngQ7t272xo6" +
       "VrOPo2Rtmzs5XblZOb0C3P1Htyh+9PzlFJ6RF2eJu3lp1xYj8YDzy06uGBBD" +
       "MGnYcfbOg/PPbTn/3Hkb/97r1uS+8wzi35Ulb98Rz34mO35P3wS/bLaUexwg" +
       "+eqW31fPld+Bih45oaJJYEbZRGSjqjXJv3+GAP5Blrwb9H7Z85cHEnjvTgLf" +
       "eyMSSMGE6RpfJcs+sfTgVR9M3HzkT/74sxfvfPmz3H/YTFcPPsR3F5G7U4tt" +
       "++gXcY6c3+4HqmauxXPXOr1nPU/c/0CUe+q6P6AW5W7N/mUs9n9oU/+Ho9yT" +
       "11M/m3Zl/4/WfTbKPXp2XVBr/f9orX8c5R48rVaUuwWkR0t/BMw6r1UalATp" +
       "0ZIfBQ7rZElw//X/o+V+EjjHXTkwN96cHC3yMdA6KJKdfnw90/7ldGN9Dx41" +
       "/PXb/ftfyFoOqxz9+lhGd/3ZzYPlPDG9/TbCJ57Fqbd9rfpjm6+fyba4WmWt" +
       "3Enk7th8iG3daLYk6FWntnbQ1u3dp/7inp++69UHy5fu2QDedcIj2F557U+N" +
       "oY4frT8Otvr5l3/yWz767O+sd73/P+bPVtwPVQAA");
}
