package org.apache.batik.ext.awt.image.rendered;
public class CompositeRed extends org.apache.batik.ext.awt.image.rendered.AbstractRed {
    org.apache.batik.ext.awt.image.CompositeRule rule;
    java.awt.CompositeContext[] contexts;
    public CompositeRed(java.util.List srcs, org.apache.batik.ext.awt.image.CompositeRule rule) {
        super(
          );
        org.apache.batik.ext.awt.image.rendered.CachableRed src =
          (org.apache.batik.ext.awt.image.rendered.CachableRed)
            srcs.
            get(
              0);
        java.awt.image.ColorModel cm =
          fixColorModel(
            src);
        this.
          rule =
          rule;
        org.apache.batik.ext.awt.image.SVGComposite comp =
          new org.apache.batik.ext.awt.image.SVGComposite(
          rule);
        contexts =
          (new java.awt.CompositeContext[srcs.
                                           size(
                                             )]);
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        java.awt.Rectangle myBounds =
          null;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            contexts[idx++] =
              comp.
                createContext(
                  cr.
                    getColorModel(
                      ),
                  cm,
                  null);
            java.awt.Rectangle newBound =
              cr.
              getBounds(
                );
            if (myBounds ==
                  null) {
                myBounds =
                  newBound;
                continue;
            }
            switch (rule.
                      getRule(
                        )) {
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_IN:
                    if (myBounds.
                          intersects(
                            newBound))
                        myBounds =
                          myBounds.
                            intersection(
                              newBound);
                    else {
                        myBounds.
                          width =
                          0;
                        myBounds.
                          height =
                          0;
                    }
                    break;
                case org.apache.batik.ext.awt.image.CompositeRule.
                       RULE_OUT:
                    myBounds =
                      newBound;
                    break;
                default:
                    myBounds.
                      add(
                        newBound);
            }
        }
        if (myBounds ==
              null)
            throw new java.lang.IllegalArgumentException(
              "Composite Operation Must have some source!");
        if (rule.
              getRule(
                ) ==
              org.apache.batik.ext.awt.image.CompositeRule.
                RULE_ARITHMETIC) {
            java.util.List vec =
              new java.util.ArrayList(
              srcs.
                size(
                  ));
            i =
              srcs.
                iterator(
                  );
            while (i.
                     hasNext(
                       )) {
                org.apache.batik.ext.awt.image.rendered.CachableRed cr =
                  (org.apache.batik.ext.awt.image.rendered.CachableRed)
                    i.
                    next(
                      );
                java.awt.Rectangle r =
                  cr.
                  getBounds(
                    );
                if (r.
                      x !=
                      myBounds.
                        x ||
                      r.
                        y !=
                      myBounds.
                        y ||
                      r.
                        width !=
                      myBounds.
                        width ||
                      r.
                        height !=
                      myBounds.
                        height)
                    cr =
                      new org.apache.batik.ext.awt.image.rendered.PadRed(
                        cr,
                        myBounds,
                        org.apache.batik.ext.awt.image.PadMode.
                          ZERO_PAD,
                        null);
                vec.
                  add(
                    cr);
            }
            srcs =
              vec;
        }
        java.awt.image.SampleModel sm =
          fixSampleModel(
            src,
            cm,
            myBounds);
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              myBounds.
                y /
                defSz);
        init(
          srcs,
          myBounds,
          cm,
          sm,
          tgX,
          tgY,
          null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        genRect(
          wr);
        return wr;
    }
    public java.awt.image.Raster getTile(int x, int y) { int tx =
                                                           tileGridXOff +
                                                           x *
                                                           tileWidth;
                                                         int ty =
                                                           tileGridYOff +
                                                           y *
                                                           tileHeight;
                                                         java.awt.Point pt =
                                                           new java.awt.Point(
                                                           tx,
                                                           ty);
                                                         java.awt.image.WritableRaster wr =
                                                           java.awt.image.Raster.
                                                           createWritableRaster(
                                                             sm,
                                                             pt);
                                                         genRect(
                                                           wr);
                                                         return wr;
    }
    public void emptyRect(java.awt.image.WritableRaster wr) {
        org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter zr =
          org.apache.batik.ext.awt.image.rendered.PadRed.ZeroRecter.
          getZeroRecter(
            wr);
        zr.
          zeroRect(
            new java.awt.Rectangle(
              wr.
                getMinX(
                  ),
              wr.
                getMinY(
                  ),
              wr.
                getWidth(
                  ),
              wr.
                getHeight(
                  )));
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        int idx =
          0;
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                if (!cr.
                      getColorModel(
                        ).
                      isAlphaPremultiplied(
                        ))
                    org.apache.batik.ext.awt.image.GraphicsUtil.
                      coerceData(
                        wr,
                        cr.
                          getColorModel(
                            ),
                        true);
                first =
                  false;
            }
            else {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (crR.
                      intersects(
                        r)) {
                    java.awt.Rectangle smR =
                      crR.
                      intersection(
                        r);
                    java.awt.image.Raster ras =
                      cr.
                      getData(
                        smR);
                    java.awt.image.WritableRaster smWR =
                      wr.
                      createWritableChild(
                        smR.
                          x,
                        smR.
                          y,
                        smR.
                          width,
                        smR.
                          height,
                        smR.
                          x,
                        smR.
                          y,
                        null);
                    contexts[idx].
                      compose(
                        ras,
                        smWR,
                        smWR);
                }
            }
            idx++;
        }
    }
    public void genRect_OVER(java.awt.image.WritableRaster wr) {
        java.awt.Rectangle r =
          wr.
          getBounds(
            );
        java.awt.image.ColorModel cm =
          getColorModel(
            );
        java.awt.image.BufferedImage bi =
          new java.awt.image.BufferedImage(
          cm,
          wr.
            createWritableTranslatedChild(
              0,
              0),
          cm.
            isAlphaPremultiplied(
              ),
          null);
        java.awt.Graphics2D g2d =
          org.apache.batik.ext.awt.image.GraphicsUtil.
          createGraphics(
            bi);
        g2d.
          translate(
            -r.
               x,
            -r.
               y);
        java.util.Iterator i =
          srcs.
          iterator(
            );
        boolean first =
          true;
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.ext.awt.image.rendered.CachableRed cr =
              (org.apache.batik.ext.awt.image.rendered.CachableRed)
                i.
                next(
                  );
            if (first) {
                java.awt.Rectangle crR =
                  cr.
                  getBounds(
                    );
                if (r.
                      x <
                      crR.
                        x ||
                      r.
                        y <
                      crR.
                        y ||
                      r.
                        x +
                      r.
                        width >
                      crR.
                        x +
                      crR.
                        width ||
                      r.
                        y +
                      r.
                        height >
                      crR.
                        y +
                      crR.
                        height)
                    emptyRect(
                      wr);
                cr.
                  copyData(
                    wr);
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  coerceData(
                    wr,
                    cr.
                      getColorModel(
                        ),
                    cm.
                      isAlphaPremultiplied(
                        ));
                first =
                  false;
            }
            else {
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  drawImage(
                    g2d,
                    cr);
            }
        }
    }
    protected static java.awt.image.SampleModel fixSampleModel(org.apache.batik.ext.awt.image.rendered.CachableRed src,
                                                               java.awt.image.ColorModel cm,
                                                               java.awt.Rectangle bounds) {
        int defSz =
          org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
          getDefaultTileSize(
            );
        int tgX =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                x /
                defSz);
        int tgY =
          defSz *
          (int)
            java.lang.Math.
            floor(
              bounds.
                y /
                defSz);
        int tw =
          bounds.
            x +
          bounds.
            width -
          tgX;
        int th =
          bounds.
            y +
          bounds.
            height -
          tgY;
        java.awt.image.SampleModel sm =
          src.
          getSampleModel(
            );
        int w =
          sm.
          getWidth(
            );
        if (w <
              defSz)
            w =
              defSz;
        if (w >
              tw)
            w =
              tw;
        int h =
          sm.
          getHeight(
            );
        if (h <
              defSz)
            h =
              defSz;
        if (h >
              th)
            h =
              th;
        if (w <=
              0 ||
              h <=
              0) {
            w =
              1;
            h =
              1;
        }
        return cm.
          createCompatibleSampleModel(
            w,
            h);
    }
    protected static java.awt.image.ColorModel fixColorModel(org.apache.batik.ext.awt.image.rendered.CachableRed src) {
        java.awt.image.ColorModel cm =
          src.
          getColorModel(
            );
        if (cm.
              hasAlpha(
                )) {
            if (!cm.
                  isAlphaPremultiplied(
                    ))
                cm =
                  org.apache.batik.ext.awt.image.GraphicsUtil.
                    coerceColorModel(
                      cm,
                      true);
            return cm;
        }
        int b =
          src.
          getSampleModel(
            ).
          getNumBands(
            ) +
          1;
        if (b >
              4)
            throw new java.lang.IllegalArgumentException(
              "CompositeRed can only handle up to three band images");
        int[] masks =
          new int[4];
        for (int i =
               0;
             i <
               b -
               1;
             i++)
            masks[i] =
              16711680 >>
                8 *
                i;
        masks[3] =
          255 <<
            8 *
            (b -
               1);
        java.awt.color.ColorSpace cs =
          cm.
          getColorSpace(
            );
        return new java.awt.image.DirectColorModel(
          cs,
          8 *
            b,
          masks[0],
          masks[1],
          masks[2],
          masks[3],
          true,
          java.awt.image.DataBuffer.
            TYPE_INT);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMUZC3AV1fXmJeRHQj5AwCAhhKADYl4RkNZYK0QCwYTEBFMb" +
       "qo/NvptkYd/usntf8ohFBMeCtqNWUbGVOLVohUGxH8dPK6WjrVorFHTqrxU/" +
       "M1WLdmSmGlus9px7d99+3gczOu2b2bv77p5z7j3/c+7ue5+Ms0xSZ0haVGpg" +
       "Gw1qNXTgc4dkWjTapEqWtRpmI/L1b9yyefT5oi0hkt9DJgxIVpssWbRZoWrU" +
       "6iHTFc1ikiZTaxWlUcToMKlFzUGJKbrWQyYrVkvMUBVZYW16lCJAt2S2kgqJ" +
       "MVPpjTPaYhNgZEYr302Y7ya8JAjQ2EpKZN3Y6CJU+xCaPO8QNuauZzFS3rpO" +
       "GpTCcaao4VbFYo0Jk5xl6OrGflVnDTTBGtapi2xBrGxdlCKGugfLPjp500A5" +
       "F8NESdN0xlm0Oqmlq4M02krK3NllKo1ZG8hVJLeVjPcAM1Lf6iwahkXDsKjD" +
       "rwsFuy+lWjzWpHN2mEMp35BxQ4zM9BMxJFOK2WQ6+J6BQiGzeefIwG1tkltH" +
       "3QEWbz0rvOP2K8p/nkvKekiZonXhdmTYBINFekCgNNZLTWtJNEqjPaRCA4V3" +
       "UVORVGXY1nalpfRrEouDCThiwcm4QU2+pisr0CTwZsZlpptJ9vq4Udn/xvWp" +
       "Uj/wWuXyKjhsxnlgsFiBjZl9EtiejZK3XtGi3I78GEke6y8GAEAtiFE2oCeX" +
       "ytMkmCCVwkRUSesPd4Hxaf0AOk4HEzS5rWUgirI2JHm91E8jjEwNwnWIVwBV" +
       "xAWBKIxMDoJxSqCl6oCWPPp5f9X5N1yprdBCJAf2HKWyivsfD0g1AaRO2kdN" +
       "Cn4gEEvmtt4mVT2+PUQIAE8OAAuYh79z4sJ5NQefFjDT0sC0966jMovIu3sn" +
       "HDm9ac7XcnEbhYZuKah8H+fcyzrsN40JAyJNVZIivmxwXh7s/P23rt5Lj4dI" +
       "cQvJl3U1HgM7qpD1mKGo1FxONWpKjEZbSBHVok38fQspgOdWRaNitr2vz6Ks" +
       "heSpfCpf5/9BRH1AAkVUDM+K1qc7z4bEBvhzwiCEFMBFSuA6h4gfvzMSDw/o" +
       "MRqWZElTND3cYerIPyqUxxxqwXMU3hp6uBfsf/3Z8xsWhy09boJBhnWzPyyB" +
       "VQxQ8ZL7qTTEwkoMjCEMyomChqIQtGJcgrSTRhvQ/Iz/18IJlMjEoZwcUNbp" +
       "wVChgpet0FVAjcg74kuXnXgg8qwwQ3QdW5aMLITVG8TqDXx1Hlhh9Qa+eoOz" +
       "eoN3dZKTwxedhLsQ1gG6XQ9RAsJ0yZyuy1eu3V6XC2ZpDOWBYhD0jJS01eSG" +
       "EycHROR9RzpHDz9XvDdEQhBxeiFtubmj3pc7ROozdZlGIXhlyiJOJA1nzhtp" +
       "90EO7hza0r35K3wf3nSABMdBJEP0DgziySXqg2EgHd2ybe98tP+2TbobEHz5" +
       "xUmLKZgYZ+qCKg4yH5Hn1koPRR7fVB8ieRC8IGAzCRwMYmFNcA1fvGl0Yjfy" +
       "UggM9+lmTFLxlRNwi9mAqQ+5M9z2KvjzJFDxeHTAKXAttj2S3/FtlYHjFGGr" +
       "aDMBLnhu+HqXseulQ+8u4OJ20kiZJ/93UdboCV1IrJIHqQrXBFeblALcX3d2" +
       "3HLr+9vWcPsDiFnpFqzHEU0aVAhivvbpDS8fe233CyHXZhnk7ngvlEGJJJM4" +
       "T4qzMIl27u4HQp8KUQCtpv5SDaxS6VOkXpWik3xSNnv+Q+/dUC7sQIUZx4zm" +
       "nZqAO3/aUnL1s1eM1nAyOTKmXldmLpiI5xNdyktMU9qI+0hsOTr9jqekXZAZ" +
       "IBpbyjDlATbEZRACpBlev8V6sCvea7FOaYhnuYj8/bprt5xZcOJckYRq00J7" +
       "EuKC0XPLavfepwnw+vTE/anwzSufvVv/y/GQk+bSoQjIi622w4+teDvCragQ" +
       "gwfOo2BLPWFhidnvMeHypHYnoDIr4dpja3ePSCrrvtTYDkSg7lNiUKqEVysx" +
       "GsW6k2rMyST/w9USVkCcfA1XtQ89du/i7fMuu1sIfmaGCOrCP3rJ60d2De/f" +
       "J2waxc/IWZlq59SCHUPc7Cxh2jWiD5efd/Ddt7ovx42h9ibgcJ7w06mMTPBm" +
       "JeFYS/m7BejXyYxUFbQkQTx//q5/bf7uS+0QQltIYVxTNsRpS9SbNqEYteK9" +
       "HtNyq0Q+4bWrz+CXA9eneKE94YSwq8omu2KqTZZMhpHA94zkzIVHh595p0jR" +
       "bmaOq5QvvpCjhpNME860EFYbDvWWN1/5Ze3paiLyTS98UNr9wYETXKf+tsgb" +
       "ntsko1FkBBxmo2VNCdYGKyRrAOAWHlz17XL14Emg2AMUZbBbq92EGiPhC+Y2" +
       "9LiCV377RNXaI7kk1EyKVV2KNks8L5IiSEjUGoAKJ2F840LhsUOFMJRzVkkK" +
       "8xgCZ6QPrstiBuPhcPiRKb88/6cjr/E8IBQwLRkKa1N8hbfUbvZ979UfvfWb" +
       "0Z8UCIeZk9mWA3hT/92u9m598+MUIfNiI02zEMDvCe+7s7rpguMc3836iD0r" +
       "kVoaQl3k4p6zN/ZhqC7/dyFS0EPKZbt97ZbUOObSHmjZLKenhRbX997ffole" +
       "ozFZ1ZwerDg8ywbrDa9v5TGfH1X4sy+WGAvt+LwwWGLkEP5wBUc5g49zcJhn" +
       "W4CfVF4WUozkmXHRiawUhQuOq3CICDKXZLS5y/zLzIRrkb3Mogw77hM7xkFK" +
       "3WQmbEYKZdHpW0HrTCZGnuhFYHt04ru/eGZtwctO1FzsX2lStn1aWUOzZ5GR" +
       "e2cd2jwy6w3u3YWKBUqHfJumSfbgfLDv2PGjpdMf4EUrzxt2XPWfLqQeHvjO" +
       "BDhPZTjEkpHzNO7uGCmTMdI+GzEMgwRzAv5tTgTU3Z9F3QlXbXOTwuS/fBLo" +
       "Tb1FohtVCAp2eqbjA370sXvrjpFo+z3zRUyp9Lfky7R47P4//+ePDTtffyZN" +
       "b1fEdONslQ5S1bNmgYW5PBjJ2rgk3bCw+Oho7qs3Ty1J7cOQUk2GLmtuZhsJ" +
       "LvDU1r9Xr75gYO0YGqwZAUEFSe5p2/fM8jPkm0P8gEhEoZSDJT9Soz/2FJuU" +
       "xU3Nn8nrkqqtRpXVwXWdrdrrgn7iGk/AKpKtQybUQMZ2yhTbkKcnDVmk/G+a" +
       "CsNOoFOywCf4stuy5Pzv4bCVxwtj40USk/D/dtfIrzlVTPPlUZzo5tNXJfnD" +
       "upmcBteNNn83jl00mVADjLm9Sfr2ocOEepcpg3Y9t79qdMOTBcMXOWHvqzgs" +
       "R8fLkqADNMKbKo+tv/Od+4UTBrNxAJhu33H9Zw037BAOKc43Z6UcMXpxxBmn" +
       "KBuTu5uZbRWO0fz2/k2/um/TNoezYUZyFfvoOW1Yu52Pt2YxlB/jcBMjBf2U" +
       "rYba1LG/yQH7E3bnGtAPvrAB8QOEeXDdYVvBHWM3oEyo6X2L+wCnen8WiezH" +
       "4T6IpRRrxE7sxXBmp60nvN0J1cKgrkRdcez5csQxF667bJ7uGrs4MqGeShy/" +
       "ziKOAzg8zA1EQ2Hg35+5jD/y5TAehuuQvftDY2c8E+qpGH86C+N/wOEJRkps" +
       "xiPt3cs6A9w/+YW5n+lw/4nNwidZuA8WuCGwUsPUGeyOQszJt/jHoEDVOykL" +
       "8QD7uZxqrhMDFnzuk2IA4cmJRlMLMadlVXUTI7bqQFQmIVC60FDYreyLWXRy" +
       "DIfD0PD3KYkuKWao1EeyOrBoEITr7E9fWGe1+OpsMKQaQUHcP6/O8PF5HF5I" +
       "VVRGipkN+SW+2HtZhPYPHP7GSCkIzVUDTr7iSuXtsUslAb7h/UaA7fbUlO+X" +
       "4pub/MBIWeGUkUtfFCW/812spJUU9sVV1dsNep7zDZPCpjmk6A0NfvuQkTM/" +
       "p21CCeQ8cjb+KSh8zEhNdgqMjON3L9ZJRqZmwoJUDKMX+lNGJqWDBkjs4FzI" +
       "nBxGyoOQsD6/e+HyGCl24cDhxYMXpACoAwg+FhpjduQlUE2ZksxAm4kcf9uS" +
       "tJTJp7IUT6czy1dw8U/gTvEW77APEfePrFx15Ylz7xFfAmRVGh5GKuOh2xMf" +
       "JZLtwMyM1Bxa+SvmnJzwYNFsp0CqEBt23XGaxy+6wYMMNNrqwDG5VZ88LX95" +
       "9/kHntuefxRKuzUkR2Jk4prUE5CEEYdeZU1ruuNFaJb4CX5j8VtrD3/8Sk4l" +
       "P2gi4kCyJhtGRL7lwKsdfYbxwxApagFrBB0l+PHMRRsxIQ2avtPK/F49riVb" +
       "5wnoYRJ+HueSsQVampzFL0mM1KUWqalf14pVfYiaS5E6kikNNFBxw/C+5ZJd" +
       "hsPyBEoazDHS2mYY9ilo/jlc8tCMo4VOwz/N/wUU+bOW5yIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "i/o7r0fUFPjuyTtcxYWUR2+5X7q/E6l8");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6cWrlx95kf/N/anr4b3F+8bQZT227ZOH5CfqF/1AA+yWkPsjc7/8+98R9IPf" +
       "p6uBefKwWgrwv/YU/jCCnrg7hQi6t/w/ifVHEfTonbDATAbKk9B/HEFvuR00" +
       "gCwOuY8hz0ERdO0sJOi//D8JdyGCrhzDRdDFfeUkyEVAHYAU1Uv+6x6XuBxG" +
       "gaREwJrpudN55JGPPPxaPnIi9XzmVMJYXlE+TO7iycFlo5dfpJgf/U7rp/cX" +
       "xRRbyvOCyuUxdGl/Z+0oQXzqjtQOaV0cvPu7D/7sfe86TGYf3DN8PMZO8PbO" +
       "29/KIos5trhIlP/LR/75D/+DF3+7PGz+fysil7E7LgAA");
}
