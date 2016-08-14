package org.apache.batik.ext.awt.image.rendered;
public class SpecularLightingRed extends org.apache.batik.ext.awt.image.rendered.AbstractTiledRed {
    private double ks;
    private double specularExponent;
    private org.apache.batik.ext.awt.image.Light light;
    private org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap;
    private double scaleX;
    private double scaleY;
    private java.awt.Rectangle litRegion;
    private boolean linear;
    public SpecularLightingRed(double ks, double specularExponent, org.apache.batik.ext.awt.image.Light light,
                               org.apache.batik.ext.awt.image.rendered.BumpMap bumpMap,
                               java.awt.Rectangle litRegion,
                               double scaleX,
                               double scaleY,
                               boolean linear) { super();
                                                 this.ks =
                                                   ks;
                                                 this.specularExponent =
                                                   specularExponent;
                                                 this.light =
                                                   light;
                                                 this.bumpMap =
                                                   bumpMap;
                                                 this.litRegion =
                                                   litRegion;
                                                 this.scaleX =
                                                   scaleX;
                                                 this.scaleY =
                                                   scaleY;
                                                 this.linear =
                                                   linear;
                                                 java.awt.image.ColorModel cm;
                                                 if (linear)
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         Linear_sRGB_Unpre;
                                                 else
                                                     cm =
                                                       org.apache.batik.ext.awt.image.GraphicsUtil.
                                                         sRGB_Unpre;
                                                 int tw =
                                                   litRegion.
                                                     width;
                                                 int th =
                                                   litRegion.
                                                     height;
                                                 int defSz =
                                                   org.apache.batik.ext.awt.image.rendered.AbstractTiledRed.
                                                   getDefaultTileSize(
                                                     );
                                                 if (tw >
                                                       defSz)
                                                     tw =
                                                       defSz;
                                                 if (th >
                                                       defSz)
                                                     th =
                                                       defSz;
                                                 java.awt.image.SampleModel sm =
                                                   cm.
                                                   createCompatibleSampleModel(
                                                     tw,
                                                     th);
                                                 init(
                                                   (org.apache.batik.ext.awt.image.rendered.CachableRed)
                                                     null,
                                                   litRegion,
                                                   cm,
                                                   sm,
                                                   litRegion.
                                                     x,
                                                   litRegion.
                                                     y,
                                                   null);
    }
    public java.awt.image.WritableRaster copyData(java.awt.image.WritableRaster wr) {
        copyToRaster(
          wr);
        return wr;
    }
    public void genRect(java.awt.image.WritableRaster wr) {
        final double scaleX =
          this.
            scaleX;
        final double scaleY =
          this.
            scaleY;
        final double[] lightColor =
          light.
          getColor(
            linear);
        final int w =
          wr.
          getWidth(
            );
        final int h =
          wr.
          getHeight(
            );
        final int minX =
          wr.
          getMinX(
            );
        final int minY =
          wr.
          getMinY(
            );
        final java.awt.image.DataBufferInt db =
          (java.awt.image.DataBufferInt)
            wr.
            getDataBuffer(
              );
        final int[] pixels =
          db.
          getBankData(
            )[0];
        final java.awt.image.SinglePixelPackedSampleModel sppsm;
        sppsm =
          (java.awt.image.SinglePixelPackedSampleModel)
            wr.
            getSampleModel(
              );
        final int offset =
          db.
          getOffset(
            ) +
          sppsm.
          getOffset(
            minX -
              wr.
              getSampleModelTranslateX(
                ),
            minY -
              wr.
              getSampleModelTranslateY(
                ));
        final int scanStride =
          sppsm.
          getScanlineStride(
            );
        final int adjust =
          scanStride -
          w;
        int p =
          offset;
        int a =
          0;
        int i =
          0;
        int j =
          0;
        double x =
          scaleX *
          minX;
        double y =
          scaleY *
          minY;
        double norm =
          0;
        int pixel =
          0;
        int tmp;
        double mult;
        mult =
          lightColor[0] >
            lightColor[1]
            ? lightColor[0]
            : lightColor[1];
        mult =
          mult >
            lightColor[2]
            ? mult
            : lightColor[2];
        double scale =
          255 /
          mult;
        pixel =
          (int)
            (lightColor[0] *
               scale +
               0.5);
        tmp =
          (int)
            (lightColor[1] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        tmp =
          (int)
            (lightColor[2] *
               scale +
               0.5);
        pixel =
          pixel <<
            8 |
            tmp;
        mult *=
          255 *
            ks;
        final double[][][] NA =
          bumpMap.
          getNormalArray(
            minX,
            minY,
            w,
            h);
        if (light instanceof org.apache.batik.ext.awt.image.SpotLight) {
            org.apache.batik.ext.awt.image.SpotLight slight =
              (org.apache.batik.ext.awt.image.SpotLight)
                light;
            final double[][] LA =
              new double[w][4];
            for (i =
                   0;
                 i <
                   h;
                 i++) {
                final double[][] NR =
                  NA[i];
                slight.
                  getLightRow4(
                    x,
                    y +
                      i *
                      scaleY,
                    scaleX,
                    w,
                    NR,
                    LA);
                for (j =
                       0;
                     j <
                       w;
                     j++) {
                    final double[] N =
                      NR[j];
                    final double[] L =
                      LA[j];
                    double vs =
                      L[3];
                    if (vs ==
                          0) {
                        a =
                          0;
                    }
                    else {
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        vs =
                          vs *
                            java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               vs +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                    }
                    pixels[p++] =
                      a <<
                        24 |
                        pixel;
                }
                p +=
                  adjust;
            }
        }
        else
            if (!light.
                  isConstant(
                    )) {
                final double[][] LA =
                  new double[w][4];
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    light.
                      getLightRow(
                        x,
                        y +
                          i *
                          scaleY,
                        scaleX,
                        w,
                        NR,
                        LA);
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        final double[] L =
                          LA[j];
                        L[2] +=
                          1;
                        norm =
                          L[0] *
                            L[0] +
                            L[1] *
                            L[1] +
                            L[2] *
                            L[2];
                        norm =
                          java.lang.Math.
                            sqrt(
                              norm);
                        double dot =
                          N[0] *
                          L[0] +
                          N[1] *
                          L[1] +
                          N[2] *
                          L[2];
                        norm =
                          java.lang.Math.
                            pow(
                              dot /
                                norm,
                              specularExponent);
                        a =
                          (int)
                            (mult *
                               norm +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
            else {
                final double[] L =
                  new double[3];
                light.
                  getLight(
                    0,
                    0,
                    0,
                    L);
                L[2] +=
                  1;
                norm =
                  java.lang.Math.
                    sqrt(
                      L[0] *
                        L[0] +
                        L[1] *
                        L[1] +
                        L[2] *
                        L[2]);
                if (norm >
                      0) {
                    L[0] /=
                      norm;
                    L[1] /=
                      norm;
                    L[2] /=
                      norm;
                }
                for (i =
                       0;
                     i <
                       h;
                     i++) {
                    final double[][] NR =
                      NA[i];
                    for (j =
                           0;
                         j <
                           w;
                         j++) {
                        final double[] N =
                          NR[j];
                        a =
                          (int)
                            (mult *
                               java.lang.Math.
                               pow(
                                 N[0] *
                                   L[0] +
                                   N[1] *
                                   L[1] +
                                   N[2] *
                                   L[2],
                                 specularExponent) +
                               0.5);
                        if ((a &
                               -256) !=
                              0)
                            a =
                              (a &
                                 -2147483648) !=
                                0
                                ? 0
                                : 255;
                        pixels[p++] =
                          a <<
                            24 |
                            pixel;
                    }
                    p +=
                      adjust;
                }
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16acwr13ne3E+6i65l3SvZlhXFkiX5OrHE5BsOZ4ZLZCsm" +
       "h0NyyBnORg7JySLPSg5n38jhpMpiJLFbA46RyI4LJPpROGgbOLGbOGiK1oXc" +
       "oomDBAEcJGnaInZSpMhqIP6RBXG2M8Nv173SvUhbAnN45sx73vO857znOeun" +
       "vwpdjiOoEvjObun4yaGRJYdrBz9MdoERHw5pnFOi2NAJR4njCUh7UXvmszf+" +
       "8usfW908gK7I0FsUz/MTJbF8LxaM2Hc2hk5DN05TScdw4wS6Sa+VjQKnieXA" +
       "tBUnz9PQm85kTaBb9DEEGECAAQS4hAC3T6VApjcbXuoSRQ7FS+IQ+l7oEg1d" +
       "CbQCXgI9fV5JoESKe6SGKy0AGq4V7xIwqsycRdBTJ7bvbX6NwR+vwC//+Hff" +
       "/Ln7oBsydMPyxAKOBkAkoBAZetA1XNWI4rauG7oMPewZhi4akaU4Vl7ilqFH" +
       "YmvpKUkaGSeVVCSmgRGVZZ7W3INaYVuUaokfnZhnWoajH79dNh1lCWx99NTW" +
       "vYW9Ih0YeN0CwCJT0YzjLPfblqcn0Dsv5jix8dYICICsV10jWfknRd3vKSAB" +
       "emTfdo7iLWExiSxvCUQv+ykoJYEev6PSoq4DRbOVpfFiAj12UY7bfwJSD5QV" +
       "UWRJoLddFCs1gVZ6/EIrnWmfr47f+9Hv8QbeQYlZNzSnwH8NZHryQibBMI3I" +
       "8DRjn/HB5+hPKI9+/sMHEASE33ZBeC/z7//Z197/LU+++sW9zDfeRoZV14aW" +
       "vKh9Sn3oS+8gnm3dV8C4FvixVTT+OctL9+eOvjyfBaDnPXqisfh4ePzxVeGX" +
       "Ft//08afHkDXKeiK5jupC/zoYc13A8sxor7hGZGSGDoFPWB4OlF+p6CrIE5b" +
       "nrFPZU0zNhIKut8pk6745TuoIhOoKKroKohbnukfxwMlWZXxLIAg6Cp4oAfB" +
       "825o/yv/E8iDV75rwIqmeJbnw1zkF/bHsOElKqjbFawCr7fh2E8j4IKwHy1h" +
       "BfjByjj6UPRMZZvAlguaHwbNoYM20WExMLTUUSLaWq4S4GOCoR8Wfhf8fy8x" +
       "K+rg5vbSJdA877hIDg7oVwPfARpe1F5OO+TXfvbFXz046SxHtZdAzwMQh3sQ" +
       "hyWIklgBiMMSxOExiMPbgIAuXSrLfmsBZu8WoFFtQA+AOB98Vvyu4Qc+/Mx9" +
       "wB+D7f2gRQpR+M78TZwSClXSpga8Gnr1k9sfkL6vegAdnCfiwgCQdL3IzhX0" +
       "eUKTty52wNvpvfGhP/rLz3ziJf+0K55j9iOGeG3Oooc/c7GqI18zdMCZp+qf" +
       "e0r5hRc//9KtA+h+QBuAKhMFuDZgoScvlnGupz9/zJqFLZeBwaYfuYpTfDqm" +
       "uuvJKvK3pymlDzxUxh8GdfymwvWfBM/oqC+U/8XXtwRF+Na9zxSNdsGKkpXf" +
       "JwY/+Tu//sdoWd3HBH7jzJAoGsnzZ0ijUHajpIeHT31gEhkGkPvdT3I/9vGv" +
       "fug7SgcAEu+6XYG3ipAAZAGaEFTzD30x/B9f+fKnfvPg1GkSMGqmqmNp2YmR" +
       "RTp0/XWMBKV90ykeQDoO6IaF19yaeq6vW6alqI5ReOnf3ng38gt/9tGbez9w" +
       "QMqxG33LGys4Tf+GDvT9v/rdf/VkqeaSVgx6p3V2KrZn0recam5HkbIrcGQ/" +
       "8BtP/MtfVn4ScDLgwdjKjZLarpV1cA1kevZ1Jj6R5YLW2BwNFvBLj3zF/ok/" +
       "+pn9QHBxZLkgbHz45X/xD4cfffngzPD7rteMgGfz7Ifg0o3evG+RfwC/S+D5" +
       "++IpWqJI2FPwI8TROPDUyUAQBBkw5+nXg1UW0fvDz7z0H//NSx/am/HI+dGH" +
       "BJOrn/ntv/u1w0/+3q/chtSu6D5wmfIdLTG+DfTuNyC6kteOheG7ZcVO6gaM" +
       "Ehzne6Rs2kJOAC0O5iFHIE6RVIsA2/tyPYGuqr7vGIpX1idcpj5XhodFBZat" +
       "D5XfukXwzvgsvZ13hDPTzxe1j/3mn79Z+vP//LWybs7PX8/2ZoB835IPFcFT" +
       "RcO8/SKXD5R4BeSwV8ffedN59etAoww0amD8itkIVEJ2ru8fSV+++j+/8F8f" +
       "/cCX7oMOetB1x1f0nlLSKPQA4C8jXoGBKQu+/f377ru9BoKbpanQa4zfV9Vj" +
       "5dubXr8j9Irp5ykJP/Y3rKN+8H//9WsqoRw7btM3LuSX4U//xOPEC39a5j8l" +
       "8SL3k9lrR1wwVT/NW/tp9y8Onrny3w6gqzJ0UztaB0iKkxbUKIO5b3y8OABr" +
       "hXPfz89j95O2508GqXdc7Jxnir04fJx2ChAvpIv49QsjRjFxgh4Fz7NHZPrs" +
       "xRHjElRGhDLL02V4qwi++ZigrwaRtQF9u9SMJdCBHZ94/c0yShaBuG/KwR2b" +
       "nTkP6hZ4Do9AHd4BlHwHUEVUOsZzMz6au5BZ4HtgMnY7dN9xj+geAw96hA69" +
       "AzrlbtBddgrmKV6+7QIk9R4hvQM8zSNIzTtAWt0NpKvqntaK1/deAGXdI6hn" +
       "wPPCEagX7gDKvxtQV2JNcYz57dou+H+AaXP3mBa3w7S9R0xPgYc4wkTcAdNL" +
       "d4PpAcdKBGN5NDt74QKs771HWN8InsERrMEdYP3gXVVVsbhTSvZ8/wVMP/SG" +
       "mEod2SXANZdrh43DchD9yO1Lva+IvqdomnL3A+QwLU9xjmG8fe1ot45nJZIR" +
       "xaCebq2dxvEIfrMcywrqPdxvIVzAit01VjBWPXSqjPa95fMf+YOP/dqPvOsr" +
       "YEAZQpc3BdmDceRMieO02KD54U9//Ik3vfx7HyknwaAapX/+79C/LrR+4vUs" +
       "LoIfKYKPHZv6eGGqWK41aSVOmHLeaugn1l6Yitzv+P8Ea5Mb7x9gMdU+/tFV" +
       "WalttWzuNPXNbkTm8I7xbMwyGJLV2npjq8idFT2gFnK+SOxVb2SumEhD8VaC" +
       "qaiRs7XEbLsgfdgTHWVR7fSCjrmcOgLZ8SVekNqK1KPFjj9CsJ7o98NIEhTL" +
       "IkIx3IiO1zBztpFgWaMzTdKJ7sloa5NWKnrDHKMMZ047bq2jBot1yDXzqhtX" +
       "mC67qrhOXN3BQog0lOrWQeg0VCQ4NfqtXDZ7IldduHJt3Qo6hKrKgixF/YE1" +
       "pqUx6ko9Y7GR3azbp5hZM3MRa+KEYZ+z527IyUt0LElCRSaEBW9t11IwrNoY" +
       "nrTE6rblLkWMmAyn3nJIkJgIlgJmitP2Su0BlBg2rHaaXKPdwyZMpbaRPZp3" +
       "9FZv6HoEFlozMYzRBrFa4FkuVjmDVbYGG29ZYDiZaD1pp29GoLb0Gpd4jeZO" +
       "62ku0u0MRlHUWZlWTeSYcSQMHdsVJa9V4/tj3MhNnAydsR3YnQWJ1+2kbhHS" +
       "stpeJPXqJuC3XDUO1hvctFlqmyOjlqIQ3UF/x5E5GXTUcVoT+x2t1fblfiNe" +
       "JrY9kOWp5AfywqV0vDJhBxOuO0PNcDdLFnVBQqaGMOBnC4zuUn3CmuI6x8SJ" +
       "7jDWNheSAGG4hR8jYhjOE11EzUU9WrEpz7mtlkjYWGNI03032qVbqrlyWd5H" +
       "o9EQmxk9vpGkTESqA15X8U2YiVu/inW3VC1sEgtHmS/1HT5CF2Io5yu5H0/9" +
       "XbLKu3y7rdis0ZQzYT4K2CDvdNhQpJUeb06wHVGveOt2N+q220aV7TkLW1yH" +
       "tXAy6nQQb2ROKGK828JtgZ9MKcFi6OGGsBZ+W5jNVlY2jduVQW1XgRlMbU2R" +
       "+nrMt/PMdRVmDU/Ibgj8dhwTu7zPiB2hn8neJGPwvIVQ5IJqMxW6TaaLrNas" +
       "m8YMnyuGYecEvYs7sWi0LMJuBkKLzecI6DxoItMqLSidsGbFC04U65Y6Xreq" +
       "jralNI6hEZpco4MNVncFD8Hh5tarmf622sWH9UwnNI5bCWmNtieStEYciZEz" +
       "1aG7YwpwpVEXTLNTtbscoUue5sm07sa5uVyGOkdKdHWF2r3eTCQ6Izfsy8ic" +
       "6yf1XJw7LNfRGd5educjvhcFEgnHok7mNYGBqZgXZmHYCIU+vWCccYvlGXm4" +
       "rOG5NREweDohxqstPe92VjOWGRJenV9UsMGa3NYzYRwO4p3ZHoztLaHI2Wg9" +
       "7JFGFx4ZLJ6vsVp7TWfjwSbn4Ia1nE+38i5wV/42rwx9LWkvo/VC7jsdarQw" +
       "tBbPeoOq26I6VW7ZnEsDS29tSUFjVuR8Qq2mhJ2THWGcrTEH64syNVkgC2OH" +
       "7ahWlVh3/U6dH+y06mZTp+qRnjXAslGCxyMz3BIUVVvVwimMVLobUjSrPl6b" +
       "9KIGPERpb+kKaSgGFBOiI1JxAgRB1kt73J8Ta9OdjXv8doO3YyLjxYgiZr7a" +
       "ZnC6N+poM6fqrhhmufFY2VZ9lpBYPvcFdgo6jwxraWSEUlozTa/Zp9yestVS" +
       "lufEQUhxiyagqI1iKAzmCw0TaW20Cuc5mFfpeWuknTXdwCdEdVTtoMg6XNWn" +
       "cRTKppghPa5h+BPF3RENbRsJBOXmo0bQH3U9xFjYhjyzyaXK9h1FU8zNsIoy" +
       "We6sB06+tVBVMDmtSSayO6rqcQ9ZC2kF83ETx2OMDjrp2sNm9pSa2nGFczcG" +
       "3DQZeG5Npg19piE2kTNMgM13XY5SSdYG61BTNXVlTfa1Pmyy8C5J8wpmqpvt" +
       "bNFZTGeNzmCVNyi10iGmg3GS19BKE0HR3KsrcY5q23oPtZ3uBuF9sPDKA9od" +
       "2XRXGQVNczdkFLndqLoBHulmhxsrGzFhFtuYa8jpZkRkMN6U8U21vUVcrqvV" +
       "W80tCXNujgSsOm+sVypSIyZUjdD1aO7yTdeGm5oHU/VdfdiwKZigxeamYip5" +
       "a4D5FE7U1fl0Q7ZcbGpYS0bIoz5ZWU+SsJ/2JvmCkodJo6OzdDZh9XYODxI5" +
       "YbBwueuu8BXCmQNUrTcSo0fKacasB4YsNCSLSKkpQ3KjbDzatCaV8bzdmlWa" +
       "U9bGKD4hhUZLBSQs7XAh6PndHLWClixZ7Yyus/rOTI1KazWaEtU1abRri15X" +
       "R7fKBmb5ZJjHuqRMk07SGYy9jTjobdP2Dp8heNJb9LMm3/RaMLqt0A11KGk6" +
       "pvmtNoUG2wbcRLBNZqBwbg5dYjpsZtuB7oS9OoM6OYPOuS4ekDvVXIV1nBmw" +
       "NR/lE38xpGpslOK1Wr/tih2xPtaTYaeSOwnSsyhrqdd8ZeIm0rITZAuqsfZX" +
       "3QxdWb5jBdTA46x4OKu17NwYhKy30vmlJzSWQnOA+JQ7z2NN9fAePe9464jI" +
       "M3M7dbq1dbsqbGY+uukgPkHY6VRoso0mxfM8Seqtviatgk416dS4KZFi6VTb" +
       "dKV1TU4qlXVQbQ6bmIEMGY4FI98QrXm9xUqt51QvDMcI2eig7bnXiprZRE0Q" +
       "Qm9r/NYfJYRR68XxtMesHOAt9Y493sAR4MIxunEEerFKhnFN5XNyEYpLPFg6" +
       "Odfo5NUBP88tK3HCIAlXo97YIoPRiqjI24GYJ4Ot1W9a6nwkGptpE/SkhpNh" +
       "9SaFjtLRzI5HqaJnCmnwtWwHT4YoFsy5zVyNXczw5D7gN5On5qkGJ+46gFW4" +
       "ZWDeSJCAf8KxANMDkoe1pNGDG5u4i+52idXKhFEt1/3pPNeIKmzDWRRFm9Zw" +
       "3RUZe6L2UElIfTzsCrOYGTujWtJiyfXM9A10NRkOtLapzWuLOVmt8OJsLai1" +
       "BdmdN6XuthJNtRRt7wZ13EiaOSK4Cd4VSI6JKhqtqRI7zD1Hw/pVhPIoQRoo" +
       "qcmMbB63pugikwidyurANkISRvWoDkYshtVaGjPXBYMCebUZl6WDOeHSjtrG" +
       "HYJFlwLmu9SCpZ2QXcxYpTswCR3MW3ByKvUHSsg426GLM3LfkiWTtsNtOrfH" +
       "tKN1x5qi41Wkp1pNMNmcA31Zo+nb67DSJScNdCJznBqtZ6mVJpHW9SJpjkcU" +
       "P5Z1aRYySmXKNPw5bJvxwB50Ix3fIbipJu5mMudked5F0uamJiHrWh+ZIdOt" +
       "q9o7eYyL4xjto1yEOVvDIxSPqBMKzjaQcDHyOvV059qO2mv7ntPjbdUYAIo2" +
       "pth8vIxgjdXmTjaqGEIbS9tx3CNWm049qtnVxBXrXMg2wPRgSHPOkk8s1W5l" +
       "Q8OS+hUZ7weJPfM70y4BxpFU5FkSzYlmQ40rcB3lW/Us0Tl5m7Iagni1/mRd" +
       "QUa+HsaR06r6oyacwi2OiGZJztYNMCHGlKo0muLUuNvNERgRIycKlhgbiFLM" +
       "TihmkU97dRzOBXW9DmeDWWspCWqctkbDqVaphYIMSsR3lJhNUNAcPJXXbARH" +
       "12xD3IqYn0T9DIka4+k6SSvkLMjr7JSvp2Q4N1aoNlmzosgYVbey9Fi6QTXq" +
       "Aw61XH6UGzVjQHYTJx1skQ2MaDRlSJsWLEoS7yIbekROKTq0EananPDsusp2" +
       "+jOt3liao7GJIDamKE19nmeDVpfjJRYPeFxpsrWU5uzutoMro2pTC0VE0/qC" +
       "gjSBj/vNWb/e2TFx3V3JMdqmuZai9uIw5JPprKbN6UlrsgUrFbg/EATM2mh+" +
       "NnDYqWcJdr0R9kZEg+S0JWI1sbqyI7OpnazJge/krjzbYgrVJxk+wvobSZuS" +
       "yWLe2nW1Pr6tVlCCrxtSlwR07rexZYVbR1gkZ/nM1NUQp2utHSHTgYRIy/6k" +
       "F/qEYaL+Ch6zOGN2phFhOe2wN2/axswD65mmE8jiRKg3DJPlAjGr8EJNHAkb" +
       "MxVEP1/MtHRSSUfhfIwLM9+IzGC8kWHGjIQgkHS7Zs27YL6ZEvGE7/rLGpkj" +
       "6MKYNHcsFgwstmWYk12Atmo+hzu1DiDDfDrdDFqN+qLuLLoBHzcWnlhtLn1m" +
       "Ry3rtQqawvFsnqStmEWzYZ3fdcCoKc9X02YYZajS1BzTqyrYwp3YVGO56o98" +
       "K0GoRavPVibIypID3e92Zm0hHAEezJBNziyWPryc2y2CDpu4nEl2c8HO7BQW" +
       "tgEsLPoblZs2M0XNV3VhxU9GAw4sapYmHcJ1drSQebPjtZf6sl8Td7ybttG6" +
       "IvJ1NfDmVQTWl9P6TFnCA7K3XlVGQratVJbN8ZJbgIUwBhbM73tfsZT+V/e2" +
       "xH+43M04uR0BVvbFhx+9h1X8/tPTRfDuk52f8ncFunCifmbn58yePFScGjxx" +
       "p0sP5VHOpz748is6+1PIwdFZRiOBHkj84FsdY2M4Z1QdAE3P3Xl7nynvfJzu" +
       "sf/yB//k8ckLqw/cw9nwOy/gvKjy3zKf/pX+N2k/egDdd7Lj/prbKOczPX9+" +
       "n/16ZCRp5E3O7bY/cVKzjx9vPzpHNetc3FM7bbvbb6i9Z9/2F46KLh2dsB/t" +
       "Yj1xcg61P6+aRVZSnFgKSpwYUanhF1/nsOk/FcHPJ9A1zQ92XSVRivf/cOpQ" +
       "n3ujbaGzCsuEz54/oX6uNHr/C/+v1kCJtBT4pdcx8ItF8IUEuro0vOKk7rb7" +
       "YRvf0k9t/i/3YnOWQG+5zYWJ4vT3sdfc4trfPNJ+9pUb197+yvS/l3cGTm4H" +
       "PUBD18zUcc4e5ZyJXwkiw7RKmx7YH+wE5d9vJNA33+UZJmjm42hpx5f2Gn4r" +
       "gZ58fQ0JdLn8P5vrdxLosTvlSqD7QHhW+n8l0FtvJw0kQXhW8ssJdPOiJCi/" +
       "/D8r9/sJdP1ULoGu7CNnRf4AaAciRfT/nBzcNu/2wLetxkmkaMnEcgwwu9Sz" +
       "S+e58MRfHnkjfzlDn+86R3rlbcBjgkr39wFf1D7zynD8PV+r/9T+aobmKHle" +
       "aLlGQ1f3t0ROSO7pO2o71nVl8OzXH/rsA+8+JuSH9oBPO94ZbO+8/T0I0g2S" +
       "8uZC/otv/9x7//UrXy53q/8R1XnrwaYpAAA=");
}
