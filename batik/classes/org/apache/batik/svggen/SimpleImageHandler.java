package org.apache.batik.svggen;
public class SimpleImageHandler implements org.apache.batik.svggen.GenericImageHandler, org.apache.batik.svggen.SVGSyntax, org.apache.batik.svggen.ErrorConstants {
    static final java.lang.String XLINK_NAMESPACE_URI = "http://www.w3.org/1999/xlink";
    protected org.apache.batik.svggen.ImageHandler imageHandler;
    public SimpleImageHandler(org.apache.batik.svggen.ImageHandler imageHandler) {
        super(
          );
        if (imageHandler ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          imageHandler =
          imageHandler;
    }
    public void setDOMTreeManager(org.apache.batik.svggen.DOMTreeManager domTreeManager) {
        
    }
    public org.w3c.dom.Element createElement(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        org.w3c.dom.Element imageElement =
          generatorContext.
          getDOMFactory(
            ).
          createElementNS(
            SVG_NAMESPACE_URI,
            SVG_IMAGE_TAG);
        return imageElement;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.Image image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            null);
        int imageHeight =
          image.
          getHeight(
            null);
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.RenderedImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     int x,
                                                     int y,
                                                     int width,
                                                     int height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        int imageWidth =
          image.
          getWidth(
            );
        int imageHeight =
          image.
          getHeight(
            );
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    public java.awt.geom.AffineTransform handleImage(java.awt.image.renderable.RenderableImage image,
                                                     org.w3c.dom.Element imageElement,
                                                     double x,
                                                     double y,
                                                     double width,
                                                     double height,
                                                     org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        double imageWidth =
          image.
          getWidth(
            );
        double imageHeight =
          image.
          getHeight(
            );
        if (imageWidth ==
              0 ||
              imageHeight ==
              0 ||
              width ==
              0 ||
              height ==
              0) {
            handleEmptyImage(
              imageElement);
        }
        else {
            imageHandler.
              handleImage(
                image,
                imageElement,
                generatorContext);
            setImageAttributes(
              imageElement,
              x,
              y,
              width,
              height,
              generatorContext);
        }
        return null;
    }
    protected void setImageAttributes(org.w3c.dom.Element imageElement,
                                      double x,
                                      double y,
                                      double width,
                                      double height,
                                      org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        imageElement.
          setAttributeNS(
            null,
            SVG_X_ATTRIBUTE,
            generatorContext.
              doubleString(
                x));
        imageElement.
          setAttributeNS(
            null,
            SVG_Y_ATTRIBUTE,
            generatorContext.
              doubleString(
                y));
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            generatorContext.
              doubleString(
                width));
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            generatorContext.
              doubleString(
                height));
        imageElement.
          setAttributeNS(
            null,
            SVG_PRESERVE_ASPECT_RATIO_ATTRIBUTE,
            SVG_NONE_VALUE);
    }
    protected void handleEmptyImage(org.w3c.dom.Element imageElement) {
        imageElement.
          setAttributeNS(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_QNAME,
            "");
        imageElement.
          setAttributeNS(
            null,
            SVG_WIDTH_ATTRIBUTE,
            "0");
        imageElement.
          setAttributeNS(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            "0");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "vlvKMRFyY+1BfyaOHDuSHbNY4GhcMLxTnu4a/qM4R2eV6CDk5j4Q/fb213e9" +
       "xMmyFtm5QFEeZgYW9+R/rVjsFejd7Hn/KiNVir0ZXhuB7M8/v5j6yq+3PLm/" +
       "vWoDuIwYqc1qyg1ZGkv6abPGyo55FuReybkkaq8Gjy0jodVwQrHiB/7idl75" +
       "/QpGdwyLexhpSHP3zfF2tmFJYRvGKRhdXwoiNLrVlDQLM2bX+O49k8an2Rak" +
       "zdz4ynWtbHyLC1rz4CuyhWqQNdGka4olgPag/WQFtI9j8Zgfbaz6sQvm42cS" +
       "zGkbkemZg1mua2UwuwNgmhxMTOttXPHVc8ixPFz+nFUn9Sx0CB41/HmU6/Cy" +
       "vxA78mKFHTmBxbMVd+S5M7AjPKXYBM8RG9b7TrMjO4rThvvKdA1oW80XUl2w" +
       "3JfL4vRuBZx+h8WbEBzgHTaCVPjbi4vf6sL11pmCqweeJ2ydn5g5XOW6lvbw" +
       "HC4+6gcVUPkrFu9Bsimsh19nFEzIg8nJ/wcmeUC/+EYbb1cWFP1nJv7nkR8+" +
       "1FI7/9C213l6UvgvphFcXiqrqt783/NebZg0pXD9GsVtgPAtnzAyv0y8g2k8" +
       "f+Fr/1jI/wtwCcpDms+/vXKfMVLvysFQ4sUrAi6uCkTgFTLtEhm+uAbJhzy5" +
       "m40jh3/u6eAvdPFeoGLMzv+zdFx4VvxrmZCPHbp66MZTF98vLnBlVdq9G0dp" +
       "AMct7pILGdbysqM5Y1Vv7P60+ZG6lU7I3CYW7NrzIo+99YNlGrjjCwO3m1ZX" +
       "4ZLzjcOXPv3L6epXITvYQUISRI47ii+M8kYWUtsd8eIABbJRfu3a2/29qcvP" +
       "Tf3tLX4lR0RAs7i8fEI+ceS61+5YcLgzTBpiZDZkAzTPb7KunNK2UHnSHCVN" +
       "ijWQhyXCKIqk+qKfZjROCe9pOC42nE2FWrz+Z2RFcZZT/KdJvarnqLlez2pJ" +
       "HAbipwa3xsm0fUlq1jACHdwaTwD4I+GMcDfAHhPxQcNwsqb6Pxn8lB4t65pC" +
       "HfwV3+b8DyvbQfHPIAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4f3F/OawmL90Gu+euhyLzg17ORKdrRFFvaQu6w9dCj7lU/ue4nnh2C+/93Lw" +
       "uVK481N6FHl/DobTND1KG0flEof2ej14XyzlZkmGVQyfq8rny+J7qhm7WkSC" +
       "sEpPo0I2w5Gs44jwJ8XfleL5v+VTjlg2HNbzx/DjpOLZ06zCK9a4x9f0aDq5" +
       "OcWYIc9h+PDmYj468bEblQWWgB0dEsJDwCzLZln0D6N27mhx7zvF45ETDI6O" +
       "8Ti6BY9aVWFvr3EB1oNe4EbFrAG1wpqKag8b53y9bEMuCch9UwErTtVc3Fc/" +
       "6hxVDFa3F+Gesvq9ZUGUBXkixRM7S3n+BNxl8YVQOMPzO6tTvp5cEoj6UwtU" +
       "+OQjZ/DTbpGNf/g/fvQ3fuLdXy4cZ1y7LymNuvCXc3M0jcsPlB97/WNPv+XV" +
       "r3y4WjcK4JZ//e92vlJyff+bU+vJUi2+Sr5oKYyYKtQDtdTs7vGCCwy7WBGT" +
       "4+wbfvmxL5uf+N2fP2TWl4PDJWLwyqs//idHH3n16rnvmXff8klxvs/hm6YS" +
       "+q3HCAe15+42StWD+C+fffmXf/blDx2keuxidj4sPj5//t/88W8cffwrX7hN" +
       "Wniv5d7iCn/6iY1u3Es1wxF28kcvRbyeKvu5DdhMhZIWsgaCxjkE5ihDgC36" +
       "5mAvDFl2Pa4HA2Oc4paCOlGeuI2G6m1VVu22hpg39ztaQpDaKBqNR3OJ1Kf9" +
       "vkTMhr5L8C6HzQksGvOzYX87se2+5Rs45+MWnEM5gOPmvM577MpxerYMgW2+" +
       "hTmuB+e9Rm/IZPV8PB73lht9iIjoyGUkcr9hjLrUIRQr67kTdea0AiPwOj2w" +
       "pVh3bELeHPGyVTAkxDDWSF3yxlJrFi4EnuZFjwl4YmL29F19MltNecXy4p00" +
       "GdvBiiYZl/ezVJPR8XDV74gjcVxH+E17k1n2AhE1GMvGo2aAC5Plno7wXG7s" +
       "TXsX9CMhSDR81zBgL11YDNRSCIONussG7/WFKWOupnt9RfeAOA1DeYYWsXK5" +
       "Uua2DeZr4LbJ5iRoQvFkROz2PBM6DtTiosZoxBrzKbK31nnPw+llXfUYsymt" +
       "iaCP8lK4amrTFuuzpJPiA44n1oq9UybmQtwtEFVaatGiseDrclsFLTZMRV/1" +
       "Z8qCZGhO4TamYVs0SZFADHSd8G0J6XTSXKKNyJ10CpwSip2qw4GKNraQx/jI" +
       "bjxZ6fOoP1Z2aTbaCIPRRJvSDDlYRYnN82NTHdupJHOL8XS+nCwbW5GN0GQS" +
       "49KeJjMYS6OVqKF+d2epAYltZ4KST3JOpSfGuqmJFtzy1YW/3CPUCvjtZKZg" +
       "3Epr0ihu5IwwtDS1Ia1Xc3Zi2XNTkvvUTAGxwGPYehVm1mSNphafTzHT5+kw" +
       "HS7X/N5ndhsqkNjRjkXDISYsNitLRxahsDHBYiR5qY1ko4ESkhruCy7bp0Rd" +
       "JFuz3ag7jDuzNBzGAN5aaXtKy3I0q0v2kNd2C8eXcgPSY21RBxqylyTXkAgl" +
       "w9pTv81SLcHmhIU61vhhK5WGurLfTVv1djPK2Wa3S9uLhSUOJK4jjTK+a1D7" +
       "lrddqfm2sWSJrK2h6jDp51vVy01YDKcN3s4BtgGb5TwUSGM6bW6ZOEd7nWxE" +
       "IbDAejuPCFboKiU7E32K7ljSteh84nvzRX2EkPwUXQ6TehfebPwN1Ygn4/lC" +
       "DluWPHKNFiFOfMhHE6uwWI2YZf1hb4vHEu6oQFBMK5YTsGFmC43h4rkErMW8" +
       "Cw2UHYqsBeCK5Hjp8MSwzg28sN22e4S2pkhsGiEqloVbY+y3l6YgDHDfhqZz" +
       "HKSaINbJbEvsfXNJESwGkWGMDVbZIsJnLrEY5ky3g/QpZxHizBrXqKbRnFLr" +
       "5lIIUWJt9uZMhoGsnaosJ+6bC1FbUtpCJhFxlbbSObMCw3xvzhVEmrQyXh+O" +
       "e/4gbEY9Xa9LGM2yXj/awNuRutwmDtGa9xXRapGbfoIb7TRWEchCcYXQuqN5" +
       "L5B7fg8e19G8KYyDge5ZdX5lLQVktG7YLI0LHDncNpnNvoiH8RLd2d1Z4Obm" +
       "XvVMU/PWNEjnbWvpQeY42uRMqORazOZdak5mjZgx49DZQzDbkIPeBAIUr+4S" +
       "nBpM6kpfr1PIpi1HGIKifczQUDmMIbPVVdiOTqltB2uhpqKju8WwsdwMBZ4c" +
       "DdIx2C6ytkoNF424zbJ7dDZdMprPEPRUEx2Go6Y0wkptJo6kfsrvlNx0vekg" +
       "lFGabPisDMhV3ZS3re5AjEhsXu+OOTYJw64Bh+sV0MCyu1GXrpgOo5gATZnh" +
       "m71cSWDYwgfBdjcj3G4RoIah1eQkQGgdMQN1K8sbK4/HnXHSyBtdRwjhBg0G" +
       "9Ww/cgjUT41mCDXJcIOF/Zbf7W27jNzptHJoKGyiNUOud2GnHxJc4mMm6nFt" +
       "3AxweZIovdnA8xWMlgZLtZ7zxWf2yuJJxt9vOHSlJJNo04MUIg5CjFlKepqz" +
       "yRbBOjtUbCNO1Nk3YaHbhgRMJ8V6bLTMYOwZ3XRfb+U5bxUBnIIjcW0VArPA" +
       "Al3MwdKWlNmNsT9QLYeaAxTDM4Qao01jIyTdQQBa6z1Yu4LbHQ1HMpT0N/7a" +
       "4ngHSiFj7PXpDNaZ7XTVgNusJawHS3jCbtDdkBq3+6u6wax8DkthrqubZLYI" +
       "BuvRmprDbcWP2jDBbJT5nLRGpBwoiL0gHSAiUr3HZtK0AUM5nakBys+7mMgH" +
       "kMcrLjcUMt7T2lMsEPhUmXaaiL7Gh84EXdDzbLmw511zsYz7Ec1DcD5jRG1L" +
       "qnUu78BeSwHsdsZOEWuwo8lRL4V2G7g/ZzDYXc/FZpdeJHAcjDozNR8Zgkub" +
       "vZ62btJwgIqUmnSgRnc1U1rjAOGbw1iDyR3azrs0lPVgB1426qnaUqHV2Olr" +
       "edwLGlqq5FRzvl4mqSHYFsVPorDfo8RxDiYi5a40ZD0xJM3ItqABYUR/yHYQ" +
       "QrUQRRx0uGhIAaWFuMmEQZKdQviT5jSCsSIZ9CIi0XGT9fBZv00jzVS0EH4X" +
       "L9PYDMJU21FY3WsDx9bARm/EsCDvMQXWWys3zHVWxjv7XXdrqKnqLoTlaABP" +
       "OT8ndEM0N+3AdSh9t7H0xCX7iERCsEsVnlDfj/dCg3GjgUlODFwXF4PJyqoX" +
       "SU0+VZeRZPdTN5DWor3raYExn+szbkdPpRXaHw38ATF1QoJByCWe+sok3Q1m" +
       "PhUG/dgNBytrL89myVzFmisp9YWu2UOZUY6EZTozcRV6ChYbZAYg3M+svaFy" +
       "YUL37bUc7H1RC1lezeZrS2QUZthQaZJf85RIZ/5C5chFO+G2mAsEG+opRXqz" +
       "a+jwaGBOTKjHJnDS51tQR0mskaa3W3rsTLY8L3ltbLLrT9YNhelqOZMoWtJD" +
       "u/s9BNp9b8u1uNEACtvCnpObALJcRvC7zmy1Zrwih4MyhU2stojkODtZ9WOM" +
       "GSTOIJWYZE0vJ4nBMQgC95nh0vM7PSFo9dZtE5kAWaqjihKLcDiYCILKRaEE" +
       "IS61MBZMXKwgFhtKXQbpj1F41Z50FG5k6KiEm9oCoactKGmyYpJqk67aT0wl" +
       "acdLc+lMydQnZ7t4HDcK1/AdWK2PAdKExsO00aZMPHWEdjpQoF1vX5+NjX08" +
       "RJpxZug9eDOfpl43lRA8Lexl2KSdBDa0qWX0G1B/C8V1RLVMPUBWa3lMW5Yo" +
       "E15vlzaCYY9rRFreaac7pTkcdRhb5dfeUN90KICuBsYqLb4ctN466BMDP5Xn" +
       "ZpdRw8VmxzZcZ6xO0Gi+Wo2GZsD1m2lGLtFpd7gNA3s66tN0Z5xOIZkYDqgs" +
       "t/xGO+gv+0hzCVo4K9ILZk8kZHOLruoKhprrTaT5QBY29Xp9w0odO8bmui/T" +
       "PqquGnax5E+YOZFtILS/zSSWGsQ8JU83TVJXGHovOHFTgn2myMXBso0PzNau" +
       "OYO3ch1tgN6esTMislszYghEbbPqQXM4WO5CAuzUDuXAE2O6NAJEXOtxv8N0" +
       "4aS1a2c+1OBoG05W7iAepRtfQf1MQ0XSTNpFtkhmbqtFxHOQyaYp+V1ylyE7" +
       "V12ms4Ay+nDHUK1OC555pJpmNNjrHk9xjXxL1CObGG/mCTmZ6+o6dY0pHSyt" +
       "wYxm6vIaYps9sys59blk5mrezJxVJFMZjaNB3sTjTF/5s6lKmlLTtTRO0uDV" +
       "jIhGvV23CJGylLfDWWI36wqfk6ZsArtIW+1Yqi/SOJ1qtr5nBDaK1hy1VLrG" +
       "niNyyCEWTo/fI3i/icKUvWjDeJbssU7XnhCUYPf3MrNUIb7FdLAdN1lv+kx3" +
       "TvbkjhAwO7YZCHqSTFQMdVddZL2w6mljvKWbyTzui3tI767kYT/XKEHCl9xO" +
       "NprJth3SKOrZuJ8CMK5nqtPSWmt21bYSOaXwJtTWlOWCMwMi7vVDww51tOcQ" +
       "w3ykdZ0xnCo2WOAwNNzIMqqsCA4tVuyOYxYpHkqMOnAPL+baai8SLfF0Qlkb" +
       "fuBHnW4DngJZ1BBvPeiR4TLSOCxycixLkKyr1c3uFiICGN2N4DRKccUb2CEE" +
       "J+vJllnSSRYSs2a4CDCjHeOmoBECHQ11G4oxeaznWctuIju9AcdtgCUqRwCX" +
       "pJk8gXKV2DeXyT6wRZyjZK/dZkSB6HUT2ulbS9XvkYjqYYwSdbwRTapyFvpM" +
       "a4Mukw7XRiCRbFuLzqiBb1adaZCPXKjX20wtMtjt8JRt2Ki4bop0vlPYNZc0" +
       "6Dbw1iMh2cwWI34+anYMA2K65ma1iEK1C0ZYXx7Pt3FDqsP1nq8knLBtRPS6" +
       "ac2RORZ2jO52OIIUwLdRqLVRaC0X+p4hDkQTywVO7kxiZzqpLyiHp/Dl1Nit" +
       "Znq2xicj34T8yVbczVkc9DwWb9adYZ1YBTkk1ueEIooCPFHHiRQ4Pm2BvO6N" +
       "KUw2vFRq7EMb2S4sH91hOKWmkpAOmiOIZJTBFqN0bj9Tpmnoy21u73StfjNq" +
       "tzyc2qbLBiR3B1kiz7YUV378l9sB7pvbkXm02mg6Pcz9/9hiOrx6rizec7o1" +
       "V/1du3wAeP4I4Wyr+J6TrUHoTtvv1eaioZzfhT/p89wdj9OWJJ85kbQ/oXzv" +
       "nSiHQeAGp/cCyq2ep+90YFxt83z6g6++prI/g1493u/fRbUHI9f7sxZIgHVO" +
       "r/sLTi/eeUuLqc7Lz/ahf+2Dv/ek8P36B97EUdw7L8l5meXfYV7/Avle5W9c" +
       "rd1zuit9y0n+xU4vXdyLfigAURw4woUd6acvHoeVNoEdTzN2eQf2zJBu3X6t" +
       "TPJgiJeOUy6dy9xx6gYsU56GMZJTWMbhZObDdzmZ+Ymy+LHC6EMQXexakYNz" +
       "pm5EtXsT11DPfOBD32w37vxoVcNfPcXp8bLx2eIZHeM0+o7gdEcHKpzheIO+" +
       "svTy8knF7xN3Aetvl8VPR7W3KgGQIlBexgHH92aKoR4vh0obypHq2kfn31VY" +
       "ffxbwOq7y8b3Fs/iGKvFtwer+4+d8liBw0a4lEaHw72y9VO3s4J7DKc6s/zs" +
       "xeKT1Riv3wW/v18Wn4lqb9GriFWNcjL406eDa6DAD9tuDQcIgeSE5Yn0GY4/" +
       "++3A0TnG0fmO4PjUqSrVwcnRHDgqCIB6hupt0DsH4T+9C4S/Whb/+CKEZdPn" +
       "zhD65W8HQq8cI/TKdwShFy4hFFQIlQfcx2CV1bsb4TXVjeXDxZvfvFgcQPyX" +
       "dwHxi2Xx+buC+IVvAcTqEG5SPJ85BvFTbxZE/rYgXqsIrp1a0G/eUfkv3UX5" +
       "6pDqt6PaY+VtplJzLIoCQ46jgyv+5BkGv/OtYtArnl86xuCXvj0YXDkj+FRF" +
       "8Ht3UfUPyuI/RbUbh3ke2l6UnU72OUX/85tRdF9Ad+vFpPKWxTtuufp4uK6n" +
       "/MJr1x944rXFv63u5pxeqXuQrj2wjS3r/Dn3ufo1LwBbo9LjwcOpt1f9/Peo" +
       "9sQdFrXyuLqqVEL/twP91wv9L9NHtfuq3/N0/zuqPXRGV7A6VM6T/FER+wuS" +
       "svrH3m1Orw/H/fsr5zK+Y8OoYH7sm8F82uX81Z0yS6yunp5kdPHh8ulN5bOv" +
       "jac/9LX2zxyuDimWlOcllwfo2v2HW0ynWeFzd+R2wusa9cI3HvnFB99zksE+" +
       "chD4zEjPyfbO29/TqcyrvFmT/6Mn/sH7PvPal6qj4f8H9QwsGRMsAAA=");
}
