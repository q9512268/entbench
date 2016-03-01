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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tpkmv4U49GOqedNEBxM9Tifx/wNxSz/2JkcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L1LDpU8XEjyxppNajxcsq5U0jd4gD1n0");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "GWloJi5HuZdu+V3TZr/tZgm+ChzfuyX4vedPkDwjjcpEG1joluDJBYs7lp3z" +
       "YPmRLcuPnD9L8Yy0SSbY4yzH12TJ3SzLh8Hx0S3Lj54/S+WMNC0TV6Lc3Zsx" +
       "PyN6IqTZe9HFw9dD7ye29H7i/On5Z6Rln0fsWVt6UnotevZ5uNJPb+l9+vzp" +
       "vf2MtO/IxGLjSqnYETN+4Ql+6Xmo7+e2/H7u/Pm994y0787Eu49Z54mobe9v" +
       "nwe9z27pffb86T17RtqHMvE9x6zzJL0PnId1fm5L73PnT+8fnZH20Ux8/6F1" +
       "jq9lnT9wE/yyeDv3anB8YcvvC+fP7/kz0j6RiR+JcvcAfifWlr9nx/BHb4Jh" +
       "NhnMPQmO39oy/K3zZ/iZM9L+ZSb+2SaUOb4O/QM7gp+6CYLZquz1Zx1f3hL8" +
       "8vkQ3Ntl+NSayc+fwfIXMvGvN92Q3iyyXq4zHl+DvPn2bcf7hZvg/Q3ZxafA" +
       "8Udb3n90/or9tTPSPp+Jfw/oHaFMSc56Tf8Zy+3Xn49ults/90+f/NXvfO7J" +
       "/7z+AvNOMxSkoBHo19ix4EiZrz7/xa/82ksf/cT6K+X1twAZtgsnt3q4eieH" +
       "Yxs0rIm/5HhTZk58b9uU6/9R7srVn/a97vF5LIXmPPYi9Zs3H/k+vlma/vh6" +
       "Yfrjm2Xmb37L4/0Bhl+hGn2cffz1j7vqYpvyNsmZPvPmS5cuveXy076/BvKp" +
       "kza3/p2txd77je36/r3/eG09XvVcI8rdbquuvvtYau/X/fSw/v1NoQPLfNnO" +
       "Mpu256rZB8IHaZsP5E3v0uGGHCAxvSbSL2yQrm+2gZmJV7+Ycf3uGWlfycTv" +
       "RLnb5AzXhsYZ2f/ntrusO9WvnkOn2rtnawj3fJ2cyZ+eweZ/Z+IPr9Gzdi28" +
       "Jvq/bnZYeAxAgrdE4RsgurO6n7om21t2bxR6O5Fl3b/ldN77t2Wk/jLK3Sly" +
       "3rXC7L86D77bj//2rvr47+vD9+IZfO/LxAXAd7zheyJw27/7HJ4m7g23fIfn" +
       "bsgbgt94BsFHM/HAqQrdf/A8CL5lS/AtXyeC33QGwacz8cTpGnzyPCxW2xLU" +
       "/mYstnwG30omLgG+2XecQKknFQqdB19vy9f7m+H7xjP4NjLxui1foOOT+r18" +
       "Hga8fSa+d07PxK8yYOIMgv1MtE5XaPs8CL5nS/A9XyeCozMIZhrbZ07XIHuz" +
       "M49HAJTtU+K9839KvC+fkZbFRfvfHuUuZJPH7fe0Wb7dZ53rrXXuOwvhQbh3" +
       "7+6zTkHNNjbJ6jZ37XTlZtvpFeDuP7RF8UPn307hGWlxJtzNSztMiqQDzi8/" +
       "uWJACsGkYcfZOw/OP7Pl/DPnbfx7r12Te+cZxN+dibfviGc/Fzt+z9wEv2y2" +
       "lHsCIPnqlt9Xz5XfgYoePaGiUWBG2URko6o1yb9/RgP8g0y8F/R+2fOXBy3w" +
       "/l0L/N0baYEUTJiusaNYtj3SQ1dthLjZvE/+xHMX73zwOf4/bKarBxvs3UXm" +
       "7tRi2z66m82R89v9QNXMdfPctZb3rOeJ+x+Ock9f9+ZnUe7W7F/GYv/7NuW/" +
       "P8o9dT3ls2lX9v9o2eei3GNnlwWl1v+PlvrHUe6h00pFuVuAPJr7Y2DWea3c" +
       "ICeQR3P+CHBYJ3OC+6//H83348A57vKBufHm5GiWj4PaQZbs9BPrmfYvphvr" +
       "e+io4a/f7t//YtZyWOTozmEZ3fV2mgfLeWJ6u6/BJ5/rUW/7WvWHNzuXyba0" +
       "WmW13Enm7thsorauNFsS9KpTazuo6/bO039+z0/e9eqD5Uv3bADvOuERbK+8" +
       "9jZhuONH6429Vp958FPf9iPP/fb6i/X/Bx5C7bHnVAAA");
}
