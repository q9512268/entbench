package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter, javax.imageio.event.IIOWriteWarningListener {
    private java.lang.String targetMIME;
    public ImageIOImageWriter(java.lang.String mime) { super();
                                                       this.targetMIME = mime;
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.util.Iterator iter;
                                       iter = javax.imageio.ImageIO.
                                                getImageWritersByMIMEType(
                                                  getMIMEType(
                                                    ));
                                       javax.imageio.ImageWriter iiowriter =
                                         null;
                                       try { iiowriter =
                                               (javax.imageio.ImageWriter)
                                                 iter.
                                                 next(
                                                   );
                                             if (iiowriter !=
                                                   null) {
                                                 iiowriter.
                                                   addIIOWriteWarningListener(
                                                     this);
                                                 javax.imageio.stream.ImageOutputStream imgout =
                                                   null;
                                                 try {
                                                     imgout =
                                                       javax.imageio.ImageIO.
                                                         createImageOutputStream(
                                                           out);
                                                     javax.imageio.ImageWriteParam iwParam =
                                                       getDefaultWriteParam(
                                                         iiowriter,
                                                         image,
                                                         params);
                                                     javax.imageio.ImageTypeSpecifier type;
                                                     if (iwParam.
                                                           getDestinationType(
                                                             ) !=
                                                           null) {
                                                         type =
                                                           iwParam.
                                                             getDestinationType(
                                                               );
                                                     }
                                                     else {
                                                         type =
                                                           javax.imageio.ImageTypeSpecifier.
                                                             createFromRenderedImage(
                                                               image);
                                                     }
                                                     javax.imageio.metadata.IIOMetadata meta =
                                                       iiowriter.
                                                       getDefaultImageMetadata(
                                                         type,
                                                         iwParam);
                                                     if (params !=
                                                           null &&
                                                           meta !=
                                                           null) {
                                                         meta =
                                                           updateMetadata(
                                                             meta,
                                                             params);
                                                     }
                                                     iiowriter.
                                                       setOutput(
                                                         imgout);
                                                     javax.imageio.IIOImage iioimg =
                                                       new javax.imageio.IIOImage(
                                                       image,
                                                       null,
                                                       meta);
                                                     iiowriter.
                                                       write(
                                                         null,
                                                         iioimg,
                                                         iwParam);
                                                 }
                                                 finally {
                                                     if (imgout !=
                                                           null) {
                                                         java.lang.System.
                                                           err.
                                                           println(
                                                             "closing");
                                                         imgout.
                                                           close(
                                                             );
                                                     }
                                                 }
                                             }
                                             else {
                                                 throw new java.lang.UnsupportedOperationException(
                                                   "No ImageIO codec for writing " +
                                                   getMIMEType(
                                                     ) +
                                                   " is available!");
                                             }
                                       }
                                       finally {
                                           if (iiowriter !=
                                                 null) {
                                               java.lang.System.
                                                 err.
                                                 println(
                                                   "disposing");
                                               iiowriter.
                                                 dispose(
                                                   );
                                           }
                                       } }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.ImageWriteParam param =
          iiowriter.
          getDefaultWriteParam(
            );
        java.lang.System.
          err.
          println(
            "Param: " +
            params);
        if (params !=
              null &&
              params.
              getCompressionMethod(
                ) !=
              null) {
            param.
              setCompressionMode(
                javax.imageio.ImageWriteParam.
                  MODE_EXPLICIT);
            param.
              setCompressionType(
                params.
                  getCompressionMethod(
                    ));
        }
        return param;
    }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        final java.lang.String stdmeta =
          "javax_imageio_1.0";
        if (meta.
              isStandardMetadataFormatSupported(
                )) {
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  stdmeta);
            javax.imageio.metadata.IIOMetadataNode dim =
              getChildNode(
                root,
                "Dimension");
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    dim,
                    "HorizontalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "HorizontalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
                child =
                  getChildNode(
                    dim,
                    "VerticalPixelSize");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "VerticalPixelSize");
                    dim.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "value",
                    java.lang.Double.
                      toString(
                        params.
                          getResolution(
                            ).
                          doubleValue(
                            ) /
                          25.4));
            }
            try {
                meta.
                  mergeTree(
                    stdmeta,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ));
            }
        }
        return meta;
    }
    protected static javax.imageio.metadata.IIOMetadataNode getChildNode(org.w3c.dom.Node n,
                                                                         java.lang.String name) {
        org.w3c.dom.NodeList nodes =
          n.
          getChildNodes(
            );
        for (int i =
               0;
             i <
               nodes.
               getLength(
                 );
             i++) {
            org.w3c.dom.Node child =
              nodes.
              item(
                i);
            if (name.
                  equals(
                    child.
                      getNodeName(
                        ))) {
                return (javax.imageio.metadata.IIOMetadataNode)
                         child;
            }
        }
        return null;
    }
    public java.lang.String getMIMEType() {
        return this.
                 targetMIME;
    }
    public void warningOccurred(javax.imageio.ImageWriter source,
                                int imageIndex,
                                java.lang.String warning) {
        java.lang.System.
          err.
          println(
            "Problem while writing image using ImageI/O: " +
            warning);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "MYUXOlmq2jiJ3LFpoou96f8FOloI2acgAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456836489000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6Dawj13Xe7JO0K61l7Ur+U1RLtuS1a5vOG/4PCTlOhsP5" +
       "I4cccv5ITtqshzOXnCHn/4czpKvGNpDYaQDHqOXUBWIBRR2kDRwraBOkQetC" +
       "QZE6QdwUboM2KZA4CArUaWI0LpA0qNu4d4bvPb739kdWZKAE5nJ455xzzzn3" +
       "nO8e3jtf/CbyUBQiJd+zt0vbi49BFh+v7MZxvPVBdNzjGiMtjIBB2FoUSbDv" +
       "tv7cL974i29/2rx5hFxVkTdpruvFWmx5biSAyLM3wOCQG4de0gZOFCM3uZW2" +
       "0dAktmyUs6L4eQ55wznWGLnFnaqAQhVQqAJaqIDiByrI9EbgJg6Rc2huHAXI" +
       "30WucMhVX8/Vi5FnLwrxtVBzTsSMCgughIfz3wo0qmDOQuSdZ7bvbb7D4M+W" +
       "0Bf/wY/c/GcPIDdU5Iblirk6OlQihoOoyKMOcOYgjHDDAIaKPO4CYIggtDTb" +
       "2hV6q8gTkbV0tTgJwZmT8s7EB2Ex5sFzj+q5bWGix154Zt7CArZx+uuhha0t" +
       "oa1vPdi6t5DK+6GB1y2oWLjQdHDK8uDaco0YecdljjMbb/UhAWS95oDY9M6G" +
       "etDVYAfyxH7ubM1domIcWu4Skj7kJXCUGHnqnkJzX/uavtaW4HaMPHmZbrR/" +
       "BKkeKRyRs8TIWy6TFZLgLD11aZbOzc83hx/81Edcxj0qdDaAbuf6PwyZnrnE" +
       "JIAFCIGrgz3jo+/nflp765c/eYQgkPgtl4j3NL/yd771Qx945pXf2NP8jbvQ" +
       "8PMV0OPb+hfmj33t7cT72g/kajzse5GVT/4Fy4vwH508eT7zYea99Uxi/vD4" +
       "9OErwr+dffTnwZ8cIddZ5Kru2YkD4+hx3XN8ywYhDVwQajEwWOQR4BpE8ZxF" +
       "rsF7znLBvpdfLCIQs8iDdtF11St+QxctoIjcRdfgveUuvNN7X4vN4j7zEQS5" +
       "Bi+EhxeK7D/Fd4xsUNNzAKrpmmu5HjoKvdz+CAVuPIe+NdE5jPo1GnlJCEPw" +
       "+yvHddQLl6gGY8EEJw/z7NTSGLUcGAKo7sFJ299bHsrm3yxffE1CC0bZcR5/" +
       "/v+3kbPcJzfTK1fgdL39MljYMM8YzzZAeFt/MemQ3/rS7d86OkueE2/GyA9C" +
       "RY73ihwXihRACxU5LgY/LhQ5PlHk+E5FkCtXivHfnCu0DxU40WsIGRBMH32f" +
       "+Ld7H/7kcw/AGPXTB+Es5aTovTGdOIAMW0CpDiMdeeVz6ceUHy0fIUcXwTk3" +
       "AnZdz9lHOaSeQeety0l5N7k3PvGNv3j5p1/wDul5Ae1PUONOzjzrn7vs7tDT" +
       "gQFx9CD+/e/Ufvn2l1+4dYQ8CKEEwmeswXCHyPTM5TEuZP/zp0ia2/IQNHjh" +
       "hY5m549O4e96bIZeeugp4uCx4v5x6OM35OnwNLywk/wovvOnb/Lz9s37uMkn" +
       "7ZIVBVL/gOh//nd/+49rhbtPQf3GuWVSBPHz54AkF3ajgIzHDzEghQBAut//" +
       "3Ogzn/3mJ364CABI8a67DXgrbwkIIHAKoZt/7DeC3/v6H3zhd44OQRPDlTSZ" +
       "25aenRmZ9yPX72MkHO09B30gENkwJfOouSW7jmdYC0ub2yCP0v9z492VX/7T" +
       "T93cx4ENe07D6AOvLuDQ/30d5KO/9SP/65lCzBU9XwgPPjuQ7dH1TQfJeBhq" +
       "21yP7GP/4el/+BXt8xCnITZG1g4UcHflJHFypd4CC5aCM1/zjvdrXjGbaPH4" +
       "/UV7nHuiYEKKZ7W8eUd0PisuJt65Sua2/unf+bM3Kn/2r79VmHGxFDofBAPN" +
       "f34fd3nzzgyKf9tlCGC0yIR09VeGf+um/cq3oUQVStQhBEZ8CIEpuxAyJ9QP" +
       "Xfsvv/Zv3vrhrz2AHFHIddvTDEorsg95BIY9iEyIaZn/gz+0n/X0YdjcLExF" +
       "7jB+Hy1PFr8ehAq+797AQ+WVzCF3n/zfvD3/+B/95R1OKCDnLgv4JX4V/eLP" +
       "PEV86E8K/kPu59zPZHeCNaz6DrzVn3f+/Oi5q79+hFxTkZv6SUmpaHaSZ5QK" +
       "y6jotM6EZeeF5xdLov36//wZtr39Mu6cG/Yy6hwWCXifU+f31y8BzaO5l5+B" +
       "V+UkByuXgeYKUtzgBcuzRXsrb/7maV5f80NrA+uFk8T+Dvxcgddf5VcuLO/Y" +
       "r+5PECclxjvPagwfrl/XYy1cgnjADshcQnkPbXlbz5vOXjB2z3j5YN5Q2RWo" +
       "y0PVY+y4ENC/u74P5LfvhWAUFYU25FhYrmYXXqFiGP+2futUSwUW3jBgbq1s" +
       "7G56Ud+1XjBuHzukPOfBIvcn/+unv/pT7/o6DK4e8tAmn3gYU+dwYZjkdf+P" +
       "f/GzT7/hxT/8yQJHobPFauvl9+ZSpftZlzd83oxOzXoqN0ssShdOi+JBAX3A" +
       "yC27f06NQsuBK8TmpKhFX3ji6+uf+cYv7AvWywl0iRh88sW/953jT714dO5v" +
       "wrvuqNTP8+z/KhRKv/HEwyHy7P1GKTio//byC//yn7zwib1WT1wsekn4n+4X" +
       "/tP//erx5/7wN+9SOz1ow9n4a09sfPPNTD1i8dPPQFFBNdUzwVnwW6PE1zS9" +
       "t6UyZmWZYNphWFwQxls8G67W9awy08dJhO9cc7OLG+t5baG6c3njTdY90lLk" +
       "/roqkYRFoEOSNhV2SXVkRSEJv4+XWTGarGQqEBROEIE0DkjRb4/JBJ1X57W2" +
       "S45mTVuQ2kEjMdxNqaTN5zVsNwIzMFrLTjVT/dnOH7U6ZSfKhgaflFZ2VN66" +
       "QlDB5HI6DFb6VJbRzYZud9UFKS5k3JF6BCY0qWqQzVUlpBmru1OGNUehwGwz" +
       "o7Muw5UneuZUrJUdBORo3XECVw9UJwi8zWDBDghpJvXLZUf2GnF7bJoYL/fr" +
       "hAQm7rhHrMui1hxukga7Ls+pAbOoN7hBt9GrdoZlS22VwJaf2L15k18NeTtV" +
       "5MRR1LjWIKrbWlcsMzqvpcIg2mWjeczGOlnZGptgxXbYCGgoti5j5RWns2S5" +
       "aSV0JY12bYydk4O5qq7L2kJlkp04iaota7o1FM1gxyyvrUegMnQ8obfeEX5c" +
       "CRZEKGxmYSA1dxKph0s3MHxZJiie8jTKGYoWrxgDt42rvaEAZ71K0IqGeVxH" +
       "S/TA6hnNyohxl5gZz5mgZe3G/HpiTDFZKFM2j6fbMT6z+Qnt0JPNbiLMVK8z" +
       "qEzoXanh2PK6ZjRBoxw0y3yzMcaiURVMpt3xQF3bjY0QdxYRq2ED3RTiyWxq" +
       "q7i4qlVKYiR4hhlKo3ase4qRDOoc1wEdfRJx+FRPxK0UB3HT9EcNeYYRdJxs" +
       "8HFvGerrbOSwsu8HazlbLkOBteh4wqzRMj6almcioc9xkuDWO9s2tX4saX7k" +
       "t4YR2SFVDyRSWCcCyVwSE8lSSVGW1g4xbayFan+Oo/5O1UGyGJZcry05/aVe" +
       "n/l0Ei5wMotJTRtygyjqJAY+WM0SMSutBw1UJbc6adEGaRHToYS1qyXPU+a6" +
       "AdZdwbWbXZ8xQprqNj2m09RaENh2wWSq9Ekt1lQzwFYNT51wcnvubhKXdUod" +
       "UzVn63qUkG2Um2V2u9RWNabKGpnst6zKLDB5ycXLikRte06QBdvQGdSjrb12" +
       "BBDM3GQtYxV+3dn4vjIxtnEXzGPBztNJo/teNaNbqSyopMe6gaehwUQfhU5D" +
       "HFkMBnqsJKfksFmX12JJYBYumzpCPdXFSp9qBn7SG0UR3jY2vRaz6rJULDR6" +
       "3eUojEUjTjm2uwRiJAWNPj1Ut+slKwuNECPLZZcBFDfEx6JIuMu1sFAVtuES" +
       "WEXclLiQl5eUTejiojQtzflZq+pIs4nVoqq7WblJpDW+OvW7210nlLvuMuSj" +
       "JgpWSzHrs4Axda3W2/KiJa5Zb20SHBHPWIuQqMbYskS9o/QoIiZmKzJDa4Is" +
       "kiw1dD0swXdpdVbhStVSHSQJEJQJLk9hbCSpuLbq/Uxr8LVmu55OOmPegOs+" +
       "MzItdTrKdGc9pB2bcIFnBpQXSvJAWmMqtgk6mUWzmttIJwLOcuZS4eShSS86" +
       "cWPWH/Sb0wlNy5OVO9iOxG6HqFXq297IxsvtHqo7GWip1TmK0aUpKXZbuuQy" +
       "7DYhe2usNfDkUbeKKSQqr/2kVaptFlOuXCewbntrmTg/pSpij58OeKtP9q2G" +
       "acu2VV1KaVqKmrHhcGV+1G26Osl1nLlKNdJlI8SxUQkMNc1hOnDe+/K4sgCS" +
       "ljQgag2ANiJ4k6cWNR9nI3o0YHZ1zp2N4D9ruo3yQ442ehrN82wSjZfidIuG" +
       "w1INxbabaEq4Q0zXlo012S0P2nWhxZS9kFLqibYuzbuGusIZg0cXZWyOhhW+" +
       "Mu/QWqfuZyKJqatqui51sdl4x+zmxA60FwuOrEsLaxTVGx2m7RJM31vQtMCT" +
       "WNDfpqJqb6xmypfkdLBZBqa/qcyYRd9X7XHD7+LoRG1VOWWHZfYunvfwepke" +
       "UcuY7rXwBVafgA3LiahRGulVVtScGb+rzoEmbWd4ulNBqxJyXjcerzZoUgFG" +
       "C5OSElPGuaRGqbVBQpuzUkMVmooz3nou36UGvao4o0K4IE7N9sYxp54ok2TG" +
       "bLiIciKh3KIA3aXKVqnjT9rz2k6OR85KLZc4dSbu4i3OgmClslOa2alsy+q1" +
       "lLYSQuQuE0Y/4edzqyRIm2pfXuo4u+4DuopV0t7CWbY7WTAB0xGPubtWTS8l" +
       "oSJKQAJeZVnVmhDY2j7eWO5KqaAPho0WyoaNfnNUkTmJ9dW+ZaqLIUtM3Eq7" +
       "KWHxtmcCiNWj3kQqNdoDyyTTXsn3hcyIGGO3rDYmFbJbIhYlz9A3aFQVsKyu" +
       "rysuWd70Ei5ia6VKqV2NiRhDm6stLxGpOmV1gmvhLYfBGhspAWo3BW2MToRk" +
       "lxnMAO1ORkmL6sKEp+y2jE63egXfjqloOkwkQ9rpzI5POw0/Kdt1n4CebTJ6" +
       "WVNZRpZHPFypezondTYVfVqXTakhzrCWX49nmj7ezOuU67sbWJDM9Qnb7O1W" +
       "E7yhYBIXdd1Ra8tW/EAhpvrMmgeiubRxvuarWlrf1XwmaOq0WDF62GxhOvO4" +
       "I1Qnok1u7YU7C/nWoD+tK6S+C4Ou27LIabvcaM/83SBdzRWBIITW0IKYtXXW" +
       "DJ3KM2HTj+Uw6DdXlCPM0tRsSl0pIwat0K6VuGrCpOFY59Wpt5gQblYTQl6b" +
       "J0uV2ax30xLqciu3uy1NRLYWJDQN/DpJTJxOYyiZdpOUKtaQI82SjsnovN3S" +
       "3Gp9KktbpZKGdFXHcAHd1Q0KIiEq9vmA4dDKcufMK14WuTKuDVZtawfrDQad" +
       "tVC+p4gNoa0rNLOFy5bClShHCgm/OQUzu5M2/ZhQS/DfMxGklF+vcPF8YpN1" +
       "SoyIMkl3uUieWdIqHVQ5l9gtPLw2tmzCGjfoMSWuyisnGXcHUw/Mu55RzxyT" +
       "D/oC7ZOAqHfF0cCYzm0FzKxFtCyRooJXlBQVltaUbEzKwrQ2mXh82YeVQsUc" +
       "YI7XThbVUjtrCiSLNmvjZVatjZaTRsvFVumyLmIcVuP7/QRfruBCYWqzuBz3" +
       "F+lWp3c1NB2PN6slsetMVhuDdzsdT+iSS1oUTHUqk/awjKKuF/qtdsJvqkkv" +
       "IqYDtOdTVHe3MBML6jWptJZrvof7W5eO63MhNi0wN/XtVBgyk4quVpZLEHhj" +
       "S1mYO3qnaWY9U8gaL7fCtL+Z1MOu5La0cUDwGNHozcYx03Erq3mIdTtLhc2a" +
       "DbyHGaGjVJVdJ7BUc6pWPNpsrQYDn/YqFaGjOnYIdrNSP8sUPJlFsISqmcqM" +
       "6VdFu13ldswC75BUslEpN9CoHdvqlr1dV9zUyLRkS91WbTVclrpuHVtvUowB" +
       "w5hp6UO+FcZOq1GJgpJeoeoVyaW1mbq1PBrLSjVsuGqIqT5D02SOuWSWSXTH" +
       "GgOIs2DUruPprItV8W1/AnSrllZwYUy3FsnCWjXnDMnQLSZu477YbyeVzrTW" +
       "rbJKn3VGa9Lc6BxNVMo8LNBttUX70UJvs6zIl3V5Lg8i19va9S2qpMp2Bmpw" +
       "8SEqE5Q0lM2Omc4jnUlB0BOyDW/M+qbrZGmYTKPRmuqllaSZZHa/H7fFXYb6" +
       "a26su2YJEzHXntnzui9vQ17ploc109qZA3mUGKwKveDJXCmcBaAdYqglShY2" +
       "7A9Iq0mPW84GqzXCSXljlbc7yh7Nx259KtKR2Rk3dBQTloPtfKjiiya/s3w5" +
       "LqPyrN+zyYljlsBUrrQbAjqSQCUJE4tZSD6lCRVjo9vLgGzVG1o1c/t9YrzA" +
       "yE3H47QZXM/FyVbtj3lvRPsbZd0dJm2IJmt35/SzITCnVCR2woyncJepxYs6" +
       "rY9oYZYpIAWknCYlC2U3LmpuOA+mmzaZwepVjmW2PkXZjm+usT7vLydclSTQ" +
       "aijMFHPKaY2xHc7hrDa2kTMw2wNV3MzXsGxgyn5DGLuY0oZ/54CUTcG4vR3y" +
       "VSvc4b6hiUPTCL1WA4YrT7Rweq52m2R9lfqa1SFjb9mQ2kYnq67NkUsZjW4y" +
       "aK3wRTdgyZCVejgzVsZkz6BHJMeYKFrqDWr2dD2DkFIZTHrLIRi0QEeZ4S7Q" +
       "+mwvY0pCLaC2Da4kLFuhMIY+TEZuublcrFdaYJXVMibLXpchlEaiRB7dARMb" +
       "zHuB3UTbw4G/astxe8VhgdIza83EYCSTd6ddUZKlsjswK167AhJGaZVQwt6h" +
       "jUBClVAeCBErkf3YmEzqdmJseBv353V7CtKtxy0n7SZuiCXUiCYq1Q5KKIUa" +
       "js9bVY700IDLsgY7n7Zb5VKtM3O7ooPTqsiAKWMYvMwvxKEkBOVOOZC06dTO" +
       "+BalBN60VRbGrUVH3IzqijFlBlVKnmcjsy4GoGeFI3OxYsIhTY8mfDQSBs0G" +
       "o6EdZsMmXXlQix1aI1Oh1Uv4sVReutZ8iYNOe9D2k7Vi1CuLwUye8rYTVFdW" +
       "r8ZRvucl7eaiRfG2x1Y1fYnj+A/k2wPgte3QPF5sPJ2dmf41tpz2j57Nm3ef" +
       "be8Vn6uXz9nOb7EftlePTrenj1/lPCnyreNzx0enbKXiPOvsnAlsgBsfsyxf" +
       "UE200LXcZb5Hnm/95Rs7T9/r1LXY1PnCx198yeB/tnJ0sgP+4Rh5JPb877eh" +
       "XPuc1tegpPffewNrUBw6H3Zmv/Lx//6U9CHzw6/hIOodl/S8LPKfDr74m/R7" +
       "9L9/hDxwtk97x3H4RabnL+7OXg9BnISudGGP9umLh0E4vD50Mokfuvth0N03" +
       "aIuA24fZpQOGo4vT/vZi9/EwzQJwDRACo5jqU6L9GSGcXj6J/SQW4xBoTiH9" +
       "Ry9Jv3Tm8aZTRpYnMx34udMLvh/Lm12MXE/zODkM9sPnAv52jDy48SzjkAkf" +
       "ebU9uvOHCEVHetGf74YXdeJP8nvjzwcOGf7RvPn4qe3115ZQ+/Arhnjx7k7N" +
       "f/54QfC5vPmpC97Le37i4KlPvw5P5QcDSBVeHzvx1Mdei6dgxvqhFwM9Bsb9" +
       "HHbqpu+7CCDnPHLm0s8Wcv7xfU7Kfi5vPg8DdQniLlhoiR0XMg45DUd6+l4j" +
       "HagK3730Onz3VN75Xnh95sR3n3mtUfaPvpusfe6iKQ6INUOLtRx4Byf3B8f9" +
       "8/s47lfy5ksx8lgCq5IYnGf+pYNHXn4dHslTrjhf+tUTj/zqa/DIUeGRvOG/" +
       "G7fczFMurenHhuccDz2jyIpywflr93HCr+fNv4qRR2H0EKZlGznrqcz3vLqr" +
       "z8gLZ335dTjribwzfwPgKyfO+sr3BqTOW/u1+zz7j3nz1Rh5w8nJ3OniVD6Y" +
       "9+9eLwaX4PXvT8z77e+Neecw+At3W0YesNz4EAq/fx8H/FHe/G6M3Ej3pQuv" +
       "60kIl8NL8Pp7r8UJWYw8cef7N/nLBE/e8aLg/uU2/Usv3Xj4bS/J/7l4BeXs" +
       "BbRHOOThRWLb5494z91f9UOwsAozHtkf+PrF1x/HyAdey8tCMXLt5K4w5Rt7" +
       "KX8aI7e+Gykx8lDxfZ73f8TIM/fnhVzWWRFwwvU/Y+TJe3HBOYXteeo/h+h/" +
       "N2pICdvzlH95AhTnKeH4xfd5um/DBfZAFyNX9zfnSf4KSock+e13/DMUOhzo" +
       "7k/ysyvnSteTpCjC6IlXC6MzlvNv4OQuKF5EPS1Nk/2rqLf1l1/qDT/yrebP" +
       "7t8A0m1tt8ulPMwh1/YvI52Vt8/eU9qprKvM+7792C8+8u7TUvyxvcKHBD2n" +
       "2zvu/roN6fhx8YLM7l+87Zc++HMv/UFx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      "ov3/ADI8OTchLAAA";
}
