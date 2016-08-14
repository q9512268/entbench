package org.apache.batik.svggen;
public class ImageHandlerPNGEncoder extends org.apache.batik.svggen.AbstractImageHandlerEncoder {
    public ImageHandlerPNGEncoder(java.lang.String imageDir, java.lang.String urlRoot)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        super(
          imageDir,
          urlRoot);
    }
    public final java.lang.String getSuffix() { return ".png"; }
    public final java.lang.String getPrefix() { return "pngImage";
    }
    public void encodeImage(java.awt.image.BufferedImage buf, java.io.File imageFile)
          throws org.apache.batik.svggen.SVGGraphics2DIOException {
        try {
            java.io.OutputStream os =
              new java.io.FileOutputStream(
              imageFile);
            try {
                org.apache.batik.ext.awt.image.spi.ImageWriter writer =
                  org.apache.batik.ext.awt.image.spi.ImageWriterRegistry.
                  getInstance(
                    ).
                  getWriterFor(
                    "image/png");
                writer.
                  writeImage(
                    buf,
                    os);
            }
            finally {
                os.
                  close(
                    );
            }
        }
        catch (java.io.IOException e) {
            throw new org.apache.batik.svggen.SVGGraphics2DIOException(
              ERR_WRITE +
              imageFile.
                getName(
                  ));
        }
    }
    public java.awt.image.BufferedImage buildBufferedImage(java.awt.Dimension size) {
        return new java.awt.image.BufferedImage(
          size.
            width,
          size.
            height,
          java.awt.image.BufferedImage.
            TYPE_INT_ARGB);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ikdsXvsPMxu1EVIYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeewkWV2v+c2xO7PHzC6wu6x774DuNv6q7yOzrHRXd11d" +
       "V19VXaUyVNfRXV332dUNqxxRFokrkQUxwsY/lqi4XAaiicGsMQoEYoIhXolA" +
       "jIkokrB/iEZUfFX9u2dmyYLaSb2ufu/7/b73Pd7nfd97/cK3obNhABU811rP" +
       "LTfa1dJod2nVdqO1p4W7JFXj5CDUVMSSw3AM6q4qj3zq4ne/977FpR3onAS9" +
       "SnYcN5Ijw3XCoRa6VqKpFHTxsLZnaXYYQZeopZzIcBwZFkwZYXSFgm45whpB" +
       "l6n9IcBgCDAYApwPAW4fUgGm2zQntpGMQ3ai0Id+DjpFQec8JRteBD18XIgn" +
       "B7K9J4bLNQASbs5+80CpnDkNoIcOdN/qfI3CHyjAz/7amy/93mnoogRdNJxR" +
       "NhwFDCICnUjQrbZmz7QgbKuqpkrQHY6mqSMtMGTL2OTjlqA7Q2PuyFEcaAdG" +
       "yipjTwvyPg8td6uS6RbESuQGB+rphmap+7/O6pY8B7redajrVkM0qwcKXjDA" +
       "wAJdVrR9ljOm4agR9OBJjgMdL/cBAWC9ydaihXvQ1RlHBhXQnVvfWbIzh0dR" +
       "YDhzQHrWjUEvEXTvDYVmtvZkxZTn2tUIuuckHbdtAlTnc0NkLBH0mpNkuSTg" +
       "pXtPeOmIf77NPPHMWx3c2cnHrGqKlY3/ZsD0wAmmoaZrgeYo2pbx1sepD8p3" +
       "fe7pHQgCxK85Qbyl+f23vfSmNzzw4he2ND92HRp2ttSU6Kry/Oz2r9yHPNY6" +
       "nQ3jZs8Njcz5xzTPw5/ba7mSemDm3XUgMWvc3W98cfhn4ts/pn1rB7pAQOcU" +
       "14ptEEd3KK7tGZYWYJqjBXKkqQR0XnNUJG8noJvAO2U42raW1fVQiwjojJVX" +
       "nXPz38BEOhCRmegm8G44urv/7snRIn9PPQiCbgIPdCt4CtD2k39HkAwvXFuD" +
       "ZUV2DMeFucDN9A9hzYlmwLYLeAai3oRDNw5ACMJuMIdlEAcLbb8hmc81ByZs" +
       "4H1cdlSgDsdgPUdxVS3YzULN+//oJM00vbQ6dQo44b6TEGCB2YO7FqC9qjwb" +
       "d3ovfeLql3YOpsSejSJoF/S7u+13N+93d9vv7vX7hU6dyrt7ddb/1t/AWyaY" +
       "9wARb31s9LPkW55+5DQING91Bpg6I4VvDMzIIVIQOR4qIFyhFz+0egf/88Ud" +
       "aOc4wmZjBlUXMnYuw8UD/Lt8cmZdT+7Fd3/zu5/84FPu4Rw7Btl7U/9azmzq" +
       "PnLSuoGraCoAw0Pxjz8kf/bq5566vAOdAXgAMDCSQcwCeHngZB/HpvCVfTjM" +
       "dDkLFNbdwJatrGkfwy5Ei8BdHdbkbr89f78D2PiWLKYfBk9lL8jz76z1VV5W" +
       "vnobJpnTTmiRw+0bR95H/vrP/6mSm3sfmS8eWetGWnTlCBpkwi7m8/6OwxgY" +
       "B5oG6P7uQ9z7P/Dtd/90HgCA4tHrdXg5KxGAAsCFwMy/8AX/b77+tee/unMY" +
       "NBFYDuOZZSjpgZJZPXThZZQEvb3+cDwATSww2bKouTxxbFc1dEOeWVoWpf95" +
       "8XWlz/7LM5e2cWCBmv0wesMPFnBY/9oO9PYvvfnfHsjFnFKy1ezQZodkW4h8" +
       "1aHkdhDI62wc6Tv+4v5f/7z8EQC2AOBCY6PlmLWT22An1/w1IOvIObOFa3e7" +
       "cGX1xdylcE7zeF7uZnbbm3J7nMUbzewRj2GB7C0MJSx3CbaXKpqXDTUXWsmK" +
       "B8Ojc+r4tD2SzFxV3vfV79zGf+ePXsqNcDwbOhpCtOxd2UZtVjyUAvF3nwQQ" +
       "XA4XgK76IvMzl6wXvwckSkCiAqAxZAOAPOmxgNujPnvT3/7xn9z1lq+chnZQ" +
       "6ILlyioq53MXOg8mjRYuAACm3k+9aRszq5tBcSl7S6EDq0G51aB0G2v35L9O" +
       "gwE+dmPYQrNk5nDm3/MfrDV759//+zVGyAHrOmv4CX4JfuHD9yJPfivnP0SO" +
       "jPuB9FpkB4nfIW/5Y/a/7jxy7k93oJsk6JKyl1XyshVn81ECmVS4n2qCzPNY" +
       "+/GsaJsCXDlAxvtOotaRbk9i1uGKAt4z6uz9wlGY+j74nALPf2dPZu6sYrsW" +
       "34nsJQQPHWQEnpeeAiBwtrzb2C1m/Egu5eG8vJwVP751U/b6EwAtwjydBRy6" +
       "4chW3nE3AiFmKZf3pfMgvQU+uby0GvkM2mJiVtZz8q37WzcMlSe3VPnid/vh" +
       "nKRckEq+9x/e9+VfefTrwH8kdDbJbAvcdmTiMnGWXf/iCx+4/5Znv/HeHOjA" +
       "POXf8+nGNzKpzMtplxVEVpD7at2bqTXKswZKDiM6xyZNzTR7+bDlAsMGEJ7s" +
       "pY7wU3d+3fzwNz++TQtPxugJYu3pZ3/p+7vPPLtzJBl/9Jp8+CjPNiHPB33b" +
       "noUD6OGX6yXnQP/xk0/94W8/9e7tqO48nlr2wM7p43/5X1/e/dA3vnidXOaM" +
       "5W7x8YdybHRbFa+GRHv/Q5VEWVwpw1SInVkxaRR6Gy6aTcvhApfslSJs+g2W" +
       "wisho0mcNiwt0bmDR3qxRK+LUV1rVPjyhm0kmNkbIqpLmhStkmOkHRBykR/0" +
       "TIWQicEI6S9HyHDYpp1Oe97vz5sDboMBhrXTpDtdzS/4WiO2JUGJCZqhJi0q" +
       "rbfkQPPrhUKr7utJEfNnYlSkyTJekMZkA0f0jam50ozpLYtSVFh3CTEMxpY+" +
       "Tob1KtcYrIf2sremipVoIE7lAG1ZQkhoxDqaVDRpwtfmrRSdI8NqKm6wmdBh" +
       "Bd8VC8OF7LbMbq/E83jNJdG5jyOEYOGj4dKulHBDCFc43kaUwA2QkYEuSAnX" +
       "VvE66tuLcdfhqIkFLydaZdXySSetBURNFouam9JFMxZ81LV9Job7gjAay8Ji" +
       "3Fcqc1GaLasCJ6uG0ivUuZlR7K9qviAsywV1PNP6PXoNIqG2qkq11pyxMSbs" +
       "jSYgBR3pYdEKMM5cF8ZrY+G1EGtTXFglslppex1MLHFToVileGZDt+yCmS66" +
       "iRLxw2U/mM/HljjFlpg3HLOsPcRSKegM0rSip0J3pVpTTShYlilG3Mz1FR32" +
       "iDqsBCMlFGUeL034Ndt2kzlNm2KHHFrVcL1W18qI6qJY2RmLDRS1fX449mpl" +
       "dRbovNWr1dBgpncHYT9cy5uUTMGGqK2vxkrgV7rddRBPUaKzhq2Jw0guMk3V" +
       "WmK6XKHUY7tL2Q277WA0QCsbD/EVnucUilizCJWIBb3ltjtdecPSXrXS5NFJ" +
       "vTNAPSvtDn2y3l+2qWKrM3L5RdgeEPHYEwRG9FPGdzdjlAgXxJypEw2CilgP" +
       "JfA2Qa7irhwSowZDjVZIo9aKdWzCaVIPdgvcZOCLdJH0bKMKm6JY6vRElWhb" +
       "tjKd47TRGQ/j5biFokGtyfYGVB9Zcf1JrPFUq9ycVTi8NtOsTUCM2JBLxeJm" +
       "QQuTMgfioOlVGXYdpdhUsEU5rhYGgmaU6HI1GRZrk3Ru9/ia0ZpL6jJMcHjp" +
       "oSlcwJOIMroD2uwEaJEipBWKzUR7SPMCJ0x9cWNU+gKGdEvjHlw0uGpnMk+4" +
       "Cc87k6WvjBmf7tba/lhc+F2upw+8Qa+XGkbHWQgtebzgvHjiNfnNxhj1SnR/" +
       "ytBopVfr6U0lJJfyiOkS0WCh+f7MHGJUm2tFa67N4hgxG7ujTmvEDcurpbzq" +
       "9YiqzBtWtz2Q/Bo+BAZm6GU7dUR4WpqMq+0GUWQahcoA1WizT7TGNNxUTFYf" +
       "FmF7iHaEDdI02qiMd+qthSnXaXnSbJktfazqS6oYVEUeX7nmkCxjIrPeOF0x" +
       "qq0qlKawVm00EVAbq3Y2BlzBKlKA09VWD4PHiwjDW4tmK5HF0RyTWN7E3MmU" +
       "ZwYDym8qy46kj0TFt1vaNChFcilZmAveoobjhaB5i8Qyo9oE8SwKcxROQQl9" +
       "UsMEgp9V6bnsMPRiJLQJwrfWptKvTLEOxQw2oYk4q0lFL6DkUhpzuDGdjtc1" +
       "3cY3ZhHVyoue4dKIM7eYaVvaLJqdvtkct2x1MCYAnulWiRM4alMqFZOO6466" +
       "VEzbqYyM6yEiEgbWqQKcw3h9bJXZ0GGLU7FexcqsyC877kbsSevlHBfqQDI+" +
       "LQTtqjxcSLIBQqxOY5WlTBtiy5h0fLuy0NpUx00xtooFjZmD054eoBVTdCLR" +
       "tcIUddpIrbfgli2fS+LZFE49e2VU7GIq6+i03WcZlZuTXbFQRvzIbZY79SLW" +
       "ZlvddZ3mONxc8izeEaSOWC57yDhOGwPcmBvlHo3DpYbGJXplEbXsgFhtbLxL" +
       "1pnBGpusNzGpRMRqUaNX5YoHAhdpY0m76/qzTXtYWfkjicciRcT9FI78zayQ" +
       "kPqmMezj2HyuCFixoIsYx1mq1lx2G2mjNqwqq0kdnbcTyaj5Fsl7cCKotUiY" +
       "DvqlGtqoUUW+UjEobp7U2uOlxPua5DL2wOihhEZVe/VlL+05TCSwkmyxzYHQ" +
       "8NQ6tho2xkWRqSqWQ6KztYcP632spa1LvmdNUdjeJCu8o4/tnk1ZE7EiOgwb" +
       "RbA397lAhguGYTlBpTHRWWPJlOt9ojMQFLxKdPn+ZlQnBBue1GiqWV3jTsMn" +
       "i1gyDePupiL6VrnQGc7wVZ9AZliVE4qIEA+oNqsGfDSDW2spppZW3SP7aKHo" +
       "tyWGQblUNa3WtOPaQM4mrEutVtWhx4zUKRYDLuYJzvZ6Q6JiGvNRdbaOKKJO" +
       "JGKlny5aNDzl1t1GrNrB3FnZEYXRAdzZlJFNf9BaNmWTrFlteNkOQwEbovGY" +
       "xC3M2CxrdX00SPUK4lOmPkOKfo/rx/RUT4TEqU4SmKurvcD2nUViV4ZgOSe9" +
       "ZGP4Smh00S7h9ot9ttYtyGqhyQaObLbUGqlOGCm14XUHLmlIL00oqZrMJ1Gt" +
       "3qJbVLdQ6+ONcndI9dY9uj5fa02WS2C2kkz7sdR21bLA9hF/jKzUUmFAU2bJ" +
       "peuOq1YmQzKsdlvl5aptBQuzohXbLhUWhUESGri4ZByVmoRdnG5rAu8Ifkcx" +
       "UnVQX7ZlctUTG3BamLlaiswmYqdvJPhw1u17SGyyrhozmwlWWzgJvF6x2HxZ" +
       "G69BJAGMC1iGaaQpjtTmobWyOLa6WC1GNDxUV+tZ3F5xFXZErepME4l7w/K0" +
       "OtX7LEu3erWVxRBcYiqCXXNXjNomLTeOyQ7bDJB+SUir3XUbqXtGz8dKqjeS" +
       "F14nWOjBYmz0eXNUVjyYC2vutI1ga8QcGrIv2g5LAPtrrDX3h7Y7HMkKgDxT" +
       "4mK82irUYZC/rbS2StW79NhrwTDJrWydHfU0HtWwynCqDuChVcdSnpxJoxU8" +
       "nzRRnSsw0+pqgSTtaSMUWxu3FPJ6rb9wnA7hJ47gyaKbFDir2CgUuqEzrk4U" +
       "jalwI1XouSOxyXUqMMp1iigsLVCfYPusoVbrjlKknMCExabjBHyXYaJoRdUK" +
       "ixRvzK0QBx5oymufHLgDo1scT/11oRUUCH5Q9+OInDLAAdZi1OqTRMLUBlOp" +
       "FPho2Gw2sXhIwHRCkO68vBY2dixRaNLoTQTO7stDsmT6doEzbbKaUDxODshm" +
       "iId6zfG4Kl0i0o4+mUvVSEta5RKLLVctGpnoMOJvHHSEIMuaxjClqFyS44BZ" +
       "qYtaOEbb48K86wzX1mTCFyXDSmfazFObntqV2yYxaMCUQpF1fgZz88Yy3uiF" +
       "ZW8zLE5rAo8VtWWRQT1vSZKyJsN9ftUP1iVvM1OnYbnSCSpmUqq3NmBaitNG" +
       "p4xLY5DUzrHVeDBGiyZizSq6jcCNitRI9ALneHaitbV5fYyEAQnTbIEpO+to" +
       "iCpogxzMF2VWMwWxUSqvYoIszqYLW450u8a0CmTVY4moSVFIIcFLbAzQe0A1" +
       "m5EtCsEoptv+AMTVzEyLfldOeK7eliVawFhTmE0bStDphX1yNBO7E2k6LWmk" +
       "yJB90sTj/rQalropPSGlCqMZlroYR+JkUl6myGrgFhFNihSdqM/NYnGV8vZa" +
       "8TTacR3CxgLMxDqOMYJRMe5zYstLBoVSQsllfdbXl0a3ozWqG1WXy1OjMOFY" +
       "WE0HyFpfihzZH9fQqmSs6rJnJuUur9LaaKGZY9et1YeGu6aZGuXqyJRNDFMN" +
       "p0nI0Wlc6vGECHZJb8y2T1df2Q72jnxjfnBz80NsybdND2fF6w7OCPPPuZOn" +
       "/UfPCA9PeKBsN3r/jS5k8p3o8+989jmV/Wgp24lmjFIEnY9c7yctLdGsI6LO" +
       "AEmP33jXTef3UYcnNp9/5z/fO35y8ZZXcLz94IlxnhT5O/QLX8Rer/zqDnT6" +
       "4Pzmmpuy40xXjp/aXAi0KA6c8bGzm/sPLHvP/hHzE3uWfeL6R8zXjYKdgyjY" +
       "C4ATx5b7B3DZ7/hl2lZZAXb55+daNIp13chri4cB4/+grf5RiXmFfa2G3T0N" +
       "u/9HGr7jZdrelRVv22rIBdq1Gj71I2iYXxM8CR5qT0PqFWh4KtfwusqdOK++" +
       "Lz/2klfRrpFdIO12gKe0QFPz66R9oltzIsPdRQ1Ly6X+8vXPsrOf1Zzg/Vnx" +
       "dATdouUXUYfiJkewQoygM4lrqIcWe8+PYLHX7mOIvGcx+X/HYifO6e88sFjX" +
       "sDUn3D+J/82XiZTns+I3AO8sBmvEMRtnLc8cGuDDr8QAaQTddf17v+wS455r" +
       "/mWwvRlXPvHcxZvvfm7yV/nV18Ht9XkKulmPLevo4fCR93PeQYSf3x4Ve/nX" +
       "70bQ3Te4uchOevOXfOAf29J/IoIunaSPoLP591G6T0fQhUM6IGr7cpTkMxF0" +
       "GpBkr5/19t1TudE1SnsWRoEMtmZHDLZnrfTU8aXmwBt3/iBvHFmdHj22puR/" +
       "BNnH/3j7V5CryiefI5m3vlT/6PbyTrHkzSaTcjMF3bS9RzxYQx6+obR9Wefw" +
       "x753+6fOv25/vbt9O+DDGD8ytgevf1PWs70ov9va/MHdn3nit577Wn7W/T9a" +
       "OBYsoSMAAA==");
}
