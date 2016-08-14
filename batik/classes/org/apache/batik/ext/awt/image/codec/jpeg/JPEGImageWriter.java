package org.apache.batik.ext.awt.image.codec.jpeg;
public class JPEGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { java.awt.image.BufferedImage bi;
                                       if (image instanceof java.awt.image.BufferedImage) {
                                           bi =
                                             (java.awt.image.BufferedImage)
                                               image;
                                       }
                                       else {
                                           bi =
                                             org.apache.batik.ext.awt.image.GraphicsUtil.
                                               makeLinearBufferedImage(
                                                 image.
                                                   getWidth(
                                                     ),
                                                 image.
                                                   getHeight(
                                                     ),
                                                 false);
                                       }
                                       com.sun.image.codec.jpeg.JPEGImageEncoder encoder =
                                         com.sun.image.codec.jpeg.JPEGCodec.
                                         createJPEGEncoder(
                                           out);
                                       if (params !=
                                             null) {
                                           com.sun.image.codec.jpeg.JPEGEncodeParam param =
                                             encoder.
                                             getDefaultJPEGEncodeParam(
                                               bi);
                                           if (params.
                                                 getJPEGQuality(
                                                   ) !=
                                                 null) {
                                               param.
                                                 setQuality(
                                                   params.
                                                     getJPEGQuality(
                                                       ).
                                                     floatValue(
                                                       ),
                                                   params.
                                                     getJPEGForceBaseline(
                                                       ).
                                                     booleanValue(
                                                       ));
                                           }
                                           encoder.
                                             encode(
                                               bi,
                                               param);
                                       }
                                       else {
                                           encoder.
                                             encode(
                                               bi);
                                       } }
    public java.lang.String getMIMEType() {
        return "image/jpeg";
    }
    public JPEGImageWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae6zjWHn33HnPPmZ2Fpbtdt/MUobAtZ04TqyhlCROYsdO" +
       "bOflxKUMfiV24lf8iBPTpYCgQFEpguUlwbZSoS1oYSkqbaWKaquqBQSqRIX6" +
       "kgqoqlRaisT+UYpKW3rs3Htz752ZXVagRvKJc/x93/mev3N8Tp76LnQ68KGc" +
       "51rrqeWGu/oq3J1Zxd1w7enBbost8rIf6FrNkoOgD/quq49+9uL3f/he49IO" +
       "dEaC7pYdxw3l0HSdoKsHrrXUNRa6uO2tW7odhNAldiYvZTgKTQtmzSC8xkK3" +
       "HWINoSvsvgowUAEGKsCZCnBlSwWY7tCdyK6lHLITBgvoTdAJFjrjqal6IfTI" +
       "USGe7Mv2nhg+swBIOJf+HgKjMuaVDz18YPvG5hsM/kAOfuJDr7/0uZPQRQm6" +
       "aDq9VB0VKBGCQSTodlu3Fd0PKpqmaxJ0l6PrWk/3Tdkyk0xvCbocmFNHDiNf" +
       "P3BS2hl5up+NufXc7Wpqmx+poesfmDcxdUvb/3V6YslTYOs9W1s3FjbSfmDg" +
       "BRMo5k9kVd9nOTU3HS2EHjrOcWDjFQYQANazth4a7sFQpxwZdECXN7GzZGcK" +
       "90LfdKaA9LQbgVFC6L5bCk197cnqXJ7q10Po3uN0/OYRoDqfOSJlCaEXHyfL" +
       "JIEo3XcsSofi893Oq9/zRodydjKdNV21Uv3PAaYHjzF19Ynu646qbxhvfwX7" +
       "QfmeL7xzB4IA8YuPEW9o/uiXn33tKx985ksbmp+9CQ2nzHQ1vK5+XLnza/fX" +
       "rhInUzXOeW5gpsE/YnmW/vzek2srD1TePQcS04e7+w+f6f7l+M2f0r+zA12g" +
       "oTOqa0U2yKO7VNf2TEv3m7qj+3KoazR0Xne0Wvachs6Ce9Z09E0vN5kEekhD" +
       "p6ys64yb/QYumgARqYvOgnvTmbj7954cGtn9yoMg6Cy4oAK4Xg5tPtl3CFmw" +
       "4do6LKuyYzouzPtuan8A606oAN8asAKyfg4HbuSDFIRdfwrLIA8Mfe9BWply" +
       "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" +
       "+h23U+PHQpCIC7nYiTwyUFkxFEYuGev5UnU9ZhsK23RK64imCcNuoN0ob46S" +
       "9rQllPycPKvjyZgLzAIqeeM+zE2xZqdpGra0nk0TW/SoUGx3aqofG7HVLC2j" +
       "itCa+mqQOLMOK6IDpVGTaAPr0X03H7SnfaFdalVEu12rNFHOCrBFg0LDwUgc" +
       "SBbwVdc2e2XXcpuuMJtXxL4B8mIszM0O2xu0hFpZsXGJiFpVbKV1vW5d4FRk" +
       "UBgNlrE95uadto7azbyQcFOxG4y8MiasdGJCrphatbIkqw3WNtTJklJGRoCz" +
       "PhLJYl6eNrtxMWn09EGQ6yRU6IsiXEBNb+AS2JoS8uQoLxe55rCl4aIj15tN" +
       "cdjrmXSwUmDKLHiwShDVQr6Vm3lkg5OtYZ/NCdVuLr+wFRVxtHnJVhvB2prj" +
       "fWMxnuvYEC80etVyuZWI1bU2q/XVrsnP857W74gyNsthTKVtInWxU2Ziqal1" +
       "SqE5A4mvm13B9KbrXJFSsEkLpmeTmdO1pLUkxd5wIdclz2OQvtKfDHrkbEZX" +
       "l2rZpV2qOFDVdY3sVgd9MvIH7Wp15s9ZnWQ9rqEjPN0F9HVloXqGmReHBdXO" +
       "OaOmCtPrsKJIpkn6PlxaTep6fsKv8JbQNEWjy5GkrS0s3HZsCe31V1qeaKAl" +
       "fina1SqiNzpa4jTjRkNs9QzJEAS52x3U6vaQnrYaIuMK5npeca36qo2xg+qg" +
       "VavMHKYmNNftpFMY8IVSUkQm1GBId+qyj0ljmnMWwdQf4nmVZ3Oig4LUZiXO" +
       "Z20C7wwWizreIxf+qqL1YiyfQwKPbKEoCWCq1xEiOO4Fs5Yg+GQ+LysM4pFV" +
       "yQws3+viKpZIXBtuTd1K3S+TxmAo2ey6nODzcuQYCBwty2yIDFshu1pgrTE6" +
       "52sCP7aLS6/fj8qsNDblIpj+oglF5pJW3yti+XU76g6T2OPCZgNtVkODwPsD" +
       "orf0DK3PDtBCrSTkBTSxG2o89YKEK3dRS8aXjR7f8XpkLDl9MuS1YbKedBJa" +
       "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" +
       "E0PofOh6r7L0pW4d2zJ6xa1fzNvZWdN23+aLb/23+/qvMd7wAnamHzqm53GR" +
       "n2w/9eXmy9T37UAnD3ZxbjgFO8p07ejezQVfDyPf6R/ZwXngICC3pf6vgOtV" +
       "ewF51c13h2+aPCey5NmkzLHtx52MYGc/hPdnuyrbkHV1R9N9XcvCtk+0OTQw" +
       "3V0uCr0o7IW+LtuZ9PCY9BNHE+TufUaaq69U3UudnvElaeOG0IU4zYztYN1D" +
       "yTsMoVNL19S2We09397D4S3GrMM66s/HwIXv+bP40/HnyW21RmkT79uOvbDi" +
       "2KRfNsS7bu7U9OcbM4JfT5u3HfFe2vOmrafe/hN46nLa+QC4+D1P8T8dTx3e" +
       "+P7Qczz7SNq8L4Rum+phm27X9yukuTXv/S/EvFUIXTx2GpZu5997w+H85kBZ" +
       "/cyTF8+95MnB32YHQgeHvudZ6NwksqzDu6+H7s94vj4xM/3Pb/Zivezrt0Lo" +
       "6o99aAcSPv3KLPjNDf9vh9CVH4c/hE5n34d5fyeEHnxuXsBlHtTeHtcnQ+je" +
       "W3GF0EnQHqZ+CqDDzagBJWgPUz4dQpeOU4Lxs+/DdJ8Deb2lC6Ezm5vDJJ8H" +
       "0gFJevuH3k12pDfb66sTh2aMvSzPsufy82XPAcvhk7DUBdnfPvZnhGjzx4/r" +
       "6tNPtjpvfBb/xOYkTrXkJIO3cyx0dnMoeDCrPHJLafuyzlBXf3jnZ88/tj8D" +
       "3rlReFtxh3R76OZHXXXbC7PDqeSPX/IHr/7dJ7+RbZD/H+J1oYWPIwAA");
}
