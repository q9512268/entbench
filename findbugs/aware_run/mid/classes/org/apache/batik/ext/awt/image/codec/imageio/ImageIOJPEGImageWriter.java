package org.apache.batik.ext.awt.image.codec.imageio;
public class ImageIOJPEGImageWriter extends org.apache.batik.ext.awt.image.codec.imageio.ImageIOImageWriter {
    private static final java.lang.String JPEG_NATIVE_FORMAT = "javax_imageio_jpeg_image_1.0";
    public ImageIOJPEGImageWriter() { super("image/jpeg"); }
    protected javax.imageio.metadata.IIOMetadata updateMetadata(javax.imageio.metadata.IIOMetadata meta,
                                                                org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        if (JPEG_NATIVE_FORMAT.
              equals(
                meta.
                  getNativeMetadataFormatName(
                    ))) {
            meta =
              addAdobeTransform(
                meta);
            javax.imageio.metadata.IIOMetadataNode root =
              (javax.imageio.metadata.IIOMetadataNode)
                meta.
                getAsTree(
                  JPEG_NATIVE_FORMAT);
            javax.imageio.metadata.IIOMetadataNode jv =
              getChildNode(
                root,
                "JPEGvariety");
            if (jv ==
                  null) {
                jv =
                  new javax.imageio.metadata.IIOMetadataNode(
                    "JPEGvariety");
                root.
                  appendChild(
                    jv);
            }
            javax.imageio.metadata.IIOMetadataNode child;
            if (params.
                  getResolution(
                    ) !=
                  null) {
                child =
                  getChildNode(
                    jv,
                    "app0JFIF");
                if (child ==
                      null) {
                    child =
                      new javax.imageio.metadata.IIOMetadataNode(
                        "app0JFIF");
                    jv.
                      appendChild(
                        child);
                }
                child.
                  setAttribute(
                    "majorVersion",
                    null);
                child.
                  setAttribute(
                    "minorVersion",
                    null);
                child.
                  setAttribute(
                    "resUnits",
                    "1");
                child.
                  setAttribute(
                    "Xdensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "Ydensity",
                    params.
                      getResolution(
                        ).
                      toString(
                        ));
                child.
                  setAttribute(
                    "thumbWidth",
                    null);
                child.
                  setAttribute(
                    "thumbHeight",
                    null);
            }
            try {
                meta.
                  setFromTree(
                    JPEG_NATIVE_FORMAT,
                    root);
            }
            catch (javax.imageio.metadata.IIOInvalidTreeException e) {
                throw new java.lang.RuntimeException(
                  "Cannot update image metadata: " +
                  e.
                    getMessage(
                      ),
                  e);
            }
        }
        return meta;
    }
    private static javax.imageio.metadata.IIOMetadata addAdobeTransform(javax.imageio.metadata.IIOMetadata meta) {
        javax.imageio.metadata.IIOMetadataNode root =
          (javax.imageio.metadata.IIOMetadataNode)
            meta.
            getAsTree(
              JPEG_NATIVE_FORMAT);
        javax.imageio.metadata.IIOMetadataNode markerSequence =
          getChildNode(
            root,
            "markerSequence");
        if (markerSequence ==
              null) {
            throw new java.lang.RuntimeException(
              "Invalid metadata!");
        }
        javax.imageio.metadata.IIOMetadataNode adobeTransform =
          getChildNode(
            markerSequence,
            "app14Adobe");
        if (adobeTransform ==
              null) {
            adobeTransform =
              new javax.imageio.metadata.IIOMetadataNode(
                "app14Adobe");
            adobeTransform.
              setAttribute(
                "transform",
                "1");
            adobeTransform.
              setAttribute(
                "version",
                "101");
            adobeTransform.
              setAttribute(
                "flags0",
                "0");
            adobeTransform.
              setAttribute(
                "flags1",
                "0");
            markerSequence.
              appendChild(
                adobeTransform);
        }
        else {
            adobeTransform.
              setAttribute(
                "transform",
                "1");
        }
        try {
            meta.
              setFromTree(
                JPEG_NATIVE_FORMAT,
                root);
        }
        catch (javax.imageio.metadata.IIOInvalidTreeException e) {
            throw new java.lang.RuntimeException(
              "Cannot update image metadata: " +
              e.
                getMessage(
                  ),
              e);
        }
        return meta;
    }
    protected javax.imageio.ImageWriteParam getDefaultWriteParam(javax.imageio.ImageWriter iiowriter,
                                                                 java.awt.image.RenderedImage image,
                                                                 org.apache.batik.ext.awt.image.spi.ImageWriterParams params) {
        javax.imageio.plugins.jpeg.JPEGImageWriteParam param =
          new javax.imageio.plugins.jpeg.JPEGImageWriteParam(
          iiowriter.
            getLocale(
              ));
        return param;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SOqqoRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739551000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM1aa+zkVnX3/je7myxJdhMghDTvbIDE4e/xzHgeDa+xZ+zx" +
       "2OPxeDyeGbdl8due8dgeP2Y8Q0OBqiUtakDthoIE6RcQlIZHKxBVK1CqqgUE" +
       "qkSF+pIKqKpUWopEPpRWpS299vzfu5sQ+qUj+fr6+txzzzn3nN89vnee/T50" +
       "JgohOPDdteX68a6RxrtTF9uN14ER7XZYjFfCyNAJV4kiEbRd1h787IUf/uj9" +
       "9sUd6KwMvVzxPD9WYsf3IsGIfHdp6Cx04bC15RrzKIYuslNlqSBJ7LgI60Tx" +
       "4yz0siNdY+gSuy8CAkRAgAhILgLSOKQCnW4xvGROZD0UL44W0DugUyx0NtAy" +
       "8WLogeNMAiVU5nts+FwDwOHG7FkCSuWd0xC6/0D3rc5XKfw0jFz57bde/IPT" +
       "0AUZuuB4g0wcDQgRg0Fk6Oa5MVeNMGrouqHL0G2eYegDI3QU19nkcsvQ7ZFj" +
       "eUqchMaBkbLGJDDCfMxDy92sZbqFiRb74YF6pmO4+v7TGdNVLKDrHYe6bjUk" +
       "s3ag4HkHCBaaimbsd7lh5nh6DN13sseBjpcYQAC6npsbse0fDHWDp4AG6Pbt" +
       "3LmKZyGDOHQ8C5Ce8RMwSgzddV2mma0DRZsplnE5hu48ScdvXwGqm3JDZF1i" +
       "6JUnyXJOYJbuOjFLR+bn+9wbnnq71/Z2cpl1Q3Mz+W8Ene490UkwTCM0PM3Y" +
       "drz5UfYDyh1ffHIHggDxK08Qb2m+8IvPv+Wxe5/7ypbmZ65B01OnhhZf1j6q" +
       "3vqNu4lH6qczMW4M/MjJJv+Y5rn783tvHk8DEHl3HHDMXu7uv3xO+PPJOz9p" +
       "fG8HOk9DZzXfTebAj27T/HnguEZIGZ4RKrGh09BNhqcT+XsaOgfqrOMZ29ae" +
       "aUZGTEM3uHnTWT9/BiYyAYvMROdA3fFMf78eKLGd19MAgqBz4IJuBtfD0PaX" +
       "32PoScT25waiaIrneD7Ch36mfzahnq4gsRGBug7eBj6iAv+fvR7drSKRn4TA" +
       "IUG9jPihhSjAM2xjS5DHqrKKEWcOHALRfDCF27rjI3R2p3sdvkXl1VHoAL/b" +
       "zTwy+H8kS5rZ7eLq1CkwpXefBBQXxGLbd3UjvKxdSfDW85++/LWdgwDbs3gM" +
       "EUCY3a0wu7kwORgDYXZzAXZzYXb3hNm9tjDQqVO5DK/IhNq6FHCIGYAWALo3" +
       "PzL4hc7bnnzwNPDlYHUDmM2MFLk+9hOHYETnkKuBiICe++DqXdIvFXagneMg" +
       "nikCms5n3fkMeg8g9tLJ4L0W3wvv+e4PP/OBJ/zDMD62Kuyhy9U9M3R48KTJ" +
       "Q18zdIC3h+wfvV/5/OUvPnFpB7oBQA6A2VgBYQEQ7N6TYxxDicf3ETfT5QxQ" +
       "2PTDueJmr/Zh8nxsh/7qsCX3hVvz+m3Axi/LwuYBcD22F0f5PXv78iArX7H1" +
       "nWzSTmiRI/obB8FH/uYv/rmUm3sf/C8cWU4HRvz4EcDJmF3IoeW2Qx8QQ8MA" +
       "dH//Qf63nv7+e34udwBA8dC1BryUlQQAGjCFwMy/8pXF3377Wx/95s6h08Rg" +
       "xU1U19HSAyWzduj8CygJRnvNoTwAsFwQqJnXXBp6c193TEdRXSPz0v+68DD6" +
       "+X996uLWD1zQsu9Gj704g8P2V+PQO7/21n+/N2dzSssWzEObHZJtUfjlh5wb" +
       "YaisMznSd/3lPR/6svIRgOcAQyNnY+SwCOU2gPJJQ3L9H83L3RPv0Ky4Lzrq" +
       "/Mfj60hic1l7/zd/cIv0gy89n0t7PDM6OtddJXh8615ZcX8K2L/qZKS3lcgG" +
       "dOXnuJ+/6D73I8BRBhw1gHhRLwQYlB7zjD3qM+f+7k/+9I63feM0tENC511f" +
       "0UklDzLoJuDdRmQD+EqDN79lO7mrG0FxMVcVukr5rVPcmT/dAAR85Pr4QmaJ" +
       "zWGI3vmfPVd99z/8x1VGyJHlGuv5if4y8uyH7yLe9L28/2GIZ73vTa/GZZAE" +
       "HvYtfnL+bzsPnv2zHeicDF3U9jJMSXGTLHBkkFVF+2knyEKPvT+eIW3TgccP" +
       "IOzuk/ByZNiT4HK4HoB6Rp3Vz5/Ak1dnVhbB9dq9UHvtSTw5BSL07nxVury3" +
       "WlyeBoa1fbiM7hYysjfnDB/Iy0tZ8dp8xk7H0LkgdJYguQBhHuWpbgykdDzF" +
       "3Qv3H4PfKXD9T3ZlY2cN29zgdmIvQbn/IEMJwMp2e7ZKXeYaIi21LpM9odsQ" +
       "c1avBB8GuStmltvd5pZbMMzKYla8ZTsodl3X+9msoHKdzxR3q1vluOsol1Vf" +
       "lxWtrCBzy1IxiCFXu7QvugRyeeB0l6ZuNXvdOSEQ9RMLBHz/1kPtWB/kze/9" +
       "x/d//X0PfRs4aAc6s8ycB/jlERNwSfYp8avPPn3Py65857055AK85ZXChTsz" +
       "rsOXptZdmVqDPNthlSju5ihp6JlmLxyXfOjMwWKy3MuTkSdu//bsw9/91DYH" +
       "PhmEJ4iNJ6/8+o93n7qyc+TL46Grkv+jfbZfH7nQt+xZOIQeeKFR8h7kP33m" +
       "iT/+xBPv2Up1+/E8ugU+Ez/1V//99d0Pfuer10i1bnD9qzztJ5/Y+JbvtMsR" +
       "3dj/ddGJUVwN03RuJqse0uWn+Dq1VpPGKrC5FKdbVKxM7LSJr+pljI+H3LDQ" +
       "M+QiVlqxRnXZrNoruI92jaEdDgeOxXQYMuh3JGJkjYUO4yvxuFZAybHUcSlF" +
       "iAlfnDAKv+zwxVU/QDiq74YVeK7P6yU9rg65AAE5fm8TobVarVSCu6WSqXbH" +
       "4YINYn9UYUR52KZGostNhU6v5kWjoRhLSDueFhh/7bmLag0xzGmFTRPedts6" +
       "1VlIqalY1ry4lga9iuLDdioHdre48lMO6zjdYNwhUKcFRw05CIIpQ2Fzu8QP" +
       "JVTkmrK/8PtitdsZNULJTp1V7I20WXWKW0rLJQZ4VyxEYsWyBnVCH0TztjgY" +
       "1XE5WjRNrqYHWh2DuVkvdtRSuUFX3bmitltByBlWNEqCogIng7Ia0j6jNv3x" +
       "spCkaaPa8gxprrSrqazw6matqII0n9MFblUUCGGcTIqMDFuM1UF7DNdMrJkM" +
       "19vjgiLgndCmi4rfgcmE8jluUiWCRaXexnWW77QmMFqsMbo8ZReT8mJMEJQb" +
       "DNe+PiV6E50bRla3jS8mfjWeNDk/YUdhmEwTq5z0SmmhXIdHzVBf93y5v0aV" +
       "7oQmCxpOC3bUtSZUR50VImMFS4PxgqL8zarXmqYcswpttLDk0ESBu5TszRsW" +
       "FY34wPFSvFM1wgkhljuJ5GJ24EpDds01MHOtenE77fWsyqbOgTXGkablHiEK" +
       "Pi3Ph6tJty5350VTXliEUBmGzjQsmo0yPaHc+jQkopGeLuY+aTdYiXV60wlF" +
       "w1yDd7ragNBVi26xEwplZmssHLijekKmsznj0wVn7JJcAx1Y3ZWsrbimTnem" +
       "Du5u/OZ4yWIYHPbEgdaj9ITrNhb4hggEnagiTXI6JCWrIDbZFu01eliXnaOT" +
       "mVdj1+NpWRMaCYM1Rp1ODSksx2pcEnVzuMA680l/pPimYPghMdSccr1SZxzE" +
       "HZlTr5FSCztQ6husIy/YISYXZM9nSYLllkSnDRwZ7VQMykQUkobNDl5sD8mW" +
       "jjoLz9PKxJSLxt3hsOChU9lpNaKNH8kCvWkPzWnLFJBxXyxa1EzhmvNJyo3w" +
       "lCvUpL438GCrPFuvaEZdNLzKPGilJbFKssSygk/8/sLX2pzW2zSiuWk0uQLf" +
       "maDaekCRo9S3bZcdOerY28TDFE+dPgqTo1FIFfwmYo6NyClWusWRajRmOGEW" +
       "+G7cladUhxA6cqfhkcPaatRRmlZDGK4bMKMyy7naKps1o607/Xbsewm2LnAa" +
       "broOIyJClR4mHDoXywJR5jrkakI4K9TT1MRfRBLLLMz1yBot+QCtjCe9YXvD" +
       "tsp9pGCJZJ9ppWPC4RvsajYgG2TLFrm+0HEDmcL7DCF4c41pzYJGow+viUKf" +
       "Spfj6RjYo1xPq9HUooaVbr9YWw/dsZuMKqZTo5LJbBpI6zLX3tQ3oqFsfF2g" +
       "up0h5TG6W8IrA5vpbTrGaCE0JNqtoGivR5XQKSqTnNCcCqiRsH4YcaEtbOB2" +
       "l5ZF31ylmOYZRn+pxi1xihclmJ3UapHBj0tTh9Z7LO1InbVWdOVBjGk9v2dM" +
       "177ZCuSlMEDcdoj5cnk1tyZCs0LXVqXGgp7gRdzUfEJi6mrU9JLpoLGyPXE9" +
       "p3Sx6goJ+HBgxzxBpWRfxfl6z2g6lLkZsj7nTce9biov+c0CAOsAttebllho" +
       "0TO3C/cKTW6JwB2+Uh5hJX0jlp1IEaxpWNeG1c0i1QV2UmyWmSnpkI06thTX" +
       "cg/ogM7iWsMcEutlTLV4FYnsjd9iV9qKX1ZDxNNhWIcrcUTrMm7NEK+sKgsJ" +
       "H858eBrYAaMFabU2I2ooQfY0TiyUqFqDCUddO+5WyhNzVl0XQjQsFcoTd+T0" +
       "u7rgriahOsMaxXptJcgFjB+2w5LW4RyKxIpLXrYrsthgNryG1V1/6CXCmvQx" +
       "bWwiBclsqANiIqxGm5gWSIFaWTLdo4rNQrM2Ly5HeKLGWKHIV1dSvbL0UlQa" +
       "BlidKfJyUq1UejRKj9BgYqil+oCYL4WOsSRdoQEQ3CqT815V2fRZ3VYSbTxC" +
       "RgFVw9Nm01q02s2Y7sfEhGm1qH4VrfNByUTWojGOEkHCy0wxHIhKmqQG0/eH" +
       "coOrUptWs8DqfK9eCGdiUycKhCsJc5PVvFm0MIq+JWDzVVVrmRseMYI5bJpD" +
       "uDFYdPyJ2AIfp0XWrjB+vVxd26gB18wKH07rIltICEkfT6Uirqd1mKrzg5Qv" +
       "pQN53heSwWLIlNvopNpixZJZLCE9fNSDyRaLVQylVasOiX5dVw1DrJZADJRK" +
       "Q6S5aJe78SDoNdQCWym5cLdrWAor6gt7wVRBdlawOn1pmtRTgcAY3IFNLqIs" +
       "zBhXF01+MXYR2cEN1sCNNj32uETzS6nSldYU3aDjVmFWwNYigbpYJ4UHBsqG" +
       "i9GsCKCYNBjdlpaoZbWF1FkEGAD8TbO/qJVHrrhqMuKwWSmTq4JLNvGw0RGr" +
       "68AbF6c1qdBcKGhzVebqfrGD4eg6wPlFOVaY9bgzwd1QUw2V09XlQB54xGi4" +
       "jrGo6vvT5VTCB1FqlsRNi96UfSnVQska2WYFm1TM3mLG82HAl9VBLe43TMtc" +
       "jvQxUppi9ba4LCVx3y8N1q20YhfKvRZXLMmrQXFMykXFUsmxxjTLXZVF19y4" +
       "ncQ+69SsHmMkTDLGK0nYZkACwtRMuNR0K2JJ5VmpTw1WDEWEnZq6bBJKPR4x" +
       "PkymY4mmw2pEuaPKgtWGWKEAUrLE7EoLop5UHGUDoHZTJjelsB0bUSjDBjOh" +
       "5U2hZcWzGoV3KL+xFLmw1ljPpipukZ5qF9fFnhS2ezYeWdK03SyM7RpYWoKk" +
       "0ldVl0mL7oCF/UBUxok9VGWqYtMoTsm+FFQJORJ1l64vSo7LoBubxIZzvFlc" +
       "jVar2rCqDlpipUgKJTMKOJioar3aHG5yk25zXRWHZTzs9waixmw0YT7bjLua" +
       "b5VmnaYaMWFxMVKUKRlOovasTrGNLozV4kJt5FV90bMZvu0Ii1F5girNEFsM" +
       "Vl1FCADKO/iiP/DKZg9PmaE4qxfJiKIqlSEBh1YgilWcJ3hp05y5yHQjUBTm" +
       "r0TdRjpldtNLccxQabxOuoaYMt0BOsUqlfok6TelCWyGlIMZvSipCzU7YWrL" +
       "jez6KibDCBKrNkGy9Q3X4lNP80COBZfgZYCiBC0TCjafj+aB0UEdpVuMS03N" +
       "Vjd+HSwxnbUhdRKCr3fQlZVOFiUTRkWNN4KlIINlWEdQYU71Fot44lhEKCMV" +
       "YLfZIBYahFI0a7ZHFwskUyThGjIWzcli2vHLXaXvqbVOt4br66ZdMvmhrfNz" +
       "BJbX1QJH0dJAwehleV6KNgjvLaxk6K4lodb2huIYxWC6VQhYbKNHJt+P1cR0" +
       "BQ0WNK3dLNFJN2X8cVyuOzV3M5KkhF3AlaoSJ5v2ItWGYIke2/Fw3lgaxKbg" +
       "aSHXaswCfkXolp70S1KvRrLoRo15kitXx+OJyshNjelPKpOlmtQ4p9TnKbFY" +
       "6ruIYLDVNVFOlBDlqnAdq2FcqQ+XHMLHZ5hel5SCxPTGXjqYdpoVibNR3GrL" +
       "IAtkJlMCVrHOBLN8HCbWhaBRinkUa7mmXWLG3JJs12bTBeuhalcpkDalGVa3" +
       "nEwRuovLXGWtVvoSv2Ab1ZFDjMiorKNkH+8uOJ4Zw8U+i6xcG2eQJpdMOYQ3" +
       "11Jc1qx50KeriT5SYVMEKEEilfaIKUqKbIgIiaREjV+LfH3tmjSB+BKb6BtM" +
       "YR0UjpVBge5pzkLrW0EfA1btEngwYBjglRQP97lUYz2asQtUwCArtDoATuAL" +
       "M/BB98Y3Zp965kv72r4t30Q4OFL7KbYPtq8eyIqHD7Z78t/Zk8cwR3dWD7fb" +
       "oOzL+Z7rnZTlX80fffeVZ/Tex9CdvW1KJYZuiv3g9a6xNNwjrE4DTo9ef4eg" +
       "mx8UHm6fffnd/3KX+Cb7bS/hUOC+E3KeZPm73We/Sr1G+80d6PTBZtpVR5jH" +
       "Oz1+fAvtfGjESeiJxzbS7jmw7F2ZxV4HrtKeZUvX3pi/phecAnYLQj82tNjQ" +
       "ty5wYjN4J6fb2d/oejDfkDs4vpkbsaIrsbJL073uXn2ftPwiB0FR4OweOfPZ" +
       "mjWX4YkX2JD+5axYxdCtSQAGM/YHzVrfceif6YvtghxlmzfEBwa9L2ssgMvd" +
       "M6j7Egy6k1WbeVhd05yntmbPxc0JfuMFdH1fVjwJYlLR9Ybuq4YYKl6UHd2c" +
       "UPfX/g/q3ps1FsH11J66T70U/8mqb7+mpqf3AnDPG1593HGOTPw+Rb7Xe8Q/" +
       "BMPTjdDQc9KM5p35OB96AYP9TlZciaFXWEbcNEwlceN8jMOQBePccz1JDqly" +
       "oz79UoyaxtAd1z7LzA5m7rzqzxnbPxRon37mwo2vemb41/lx3sGh/00sdKOZ" +
       "uO7RffQj9bNBaJhOrvBN2131IL99IoYeeymHrzF0bq+Wq/PxLZffi6FLPwmX" +
       "GDqT34/2/XQM3fvCfUGv/H601+/H0J3X6xVDp0F5lPpzYHqvRQ0oQXmU8gsx" +
       "dPEkJRg/vx+l+6MYOn9IF0Nnt5WjJF8E3AFJVv1SsO9Ib/5pTrqPeEZ66vii" +
       "d+B5t7+Y5x1ZJx86trrl/xXaX4mS7b+FLmufeabDvf35yse2h6+aq2w2GZcb" +
       "Wejc9hz4YDV74Lrc9nmdbT/yo1s/e9PD+yvvrVuBDzHiiGz3XfukszUP4vxs" +
       "cvOHr/rcGz7+zLfyE4L/BTT9mgPEJQAA");
}
