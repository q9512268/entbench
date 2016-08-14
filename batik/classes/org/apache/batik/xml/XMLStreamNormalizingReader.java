package org.apache.batik.xml;
public class XMLStreamNormalizingReader extends org.apache.batik.util.io.StreamNormalizingReader {
    public XMLStreamNormalizingReader(java.io.InputStream is, java.lang.String encod)
          throws java.io.IOException { super();
                                       java.io.PushbackInputStream pbis =
                                         new java.io.PushbackInputStream(
                                         is,
                                         128);
                                       byte[] buf = new byte[4];
                                       int len = pbis.read(buf);
                                       if (len > 0) { pbis.unread(
                                                             buf,
                                                             0,
                                                             len);
                                       }
                                       if (len == 4) { switch (buf[0] &
                                                                 255) {
                                                           case 0:
                                                               if (buf[1] ==
                                                                     60 &&
                                                                     buf[2] ==
                                                                     0 &&
                                                                     buf[3] ==
                                                                     63) {
                                                                   charDecoder =
                                                                     new org.apache.batik.util.io.UTF16Decoder(
                                                                       pbis,
                                                                       true);
                                                                   return;
                                                               }
                                                               break;
                                                           case '<':
                                                               switch (buf[1] &
                                                                         255) {
                                                                   case 0:
                                                                       if (buf[2] ==
                                                                             63 &&
                                                                             buf[3] ==
                                                                             0) {
                                                                           charDecoder =
                                                                             new org.apache.batik.util.io.UTF16Decoder(
                                                                               pbis,
                                                                               false);
                                                                           return;
                                                                       }
                                                                       break;
                                                                   case '?':
                                                                       if (buf[2] ==
                                                                             'x' &&
                                                                             buf[3] ==
                                                                             'm') {
                                                                           java.io.Reader r =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             createXMLDeclarationReader(
                                                                               pbis,
                                                                               "UTF8");
                                                                           java.lang.String enc =
                                                                             org.apache.batik.xml.XMLUtilities.
                                                                             getXMLDeclarationEncoding(
                                                                               r,
                                                                               "UTF-8");
                                                                           charDecoder =
                                                                             createCharDecoder(
                                                                               pbis,
                                                                               enc);
                                                                           return;
                                                                       }
                                                               }
                                                               break;
                                                           case 76:
                                                               if (buf[1] ==
                                                                     111 &&
                                                                     (buf[2] &
                                                                        255) ==
                                                                     167 &&
                                                                     (buf[3] &
                                                                        255) ==
                                                                     148) {
                                                                   java.io.Reader r =
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     createXMLDeclarationReader(
                                                                       pbis,
                                                                       "CP037");
                                                                   java.lang.String enc =
                                                                     org.apache.batik.xml.XMLUtilities.
                                                                     getXMLDeclarationEncoding(
                                                                       r,
                                                                       "EBCDIC-CP-US");
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       enc);
                                                                   return;
                                                               }
                                                               break;
                                                           case 254:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     255) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                               break;
                                                           case 255:
                                                               if ((buf[1] &
                                                                      255) ==
                                                                     254) {
                                                                   charDecoder =
                                                                     createCharDecoder(
                                                                       pbis,
                                                                       "UTF-16");
                                                                   return;
                                                               }
                                                       }
                                       }
                                       encod =
                                         encod ==
                                           null
                                           ? "UTF-8"
                                           : encod;
                                       charDecoder =
                                         createCharDecoder(
                                           pbis,
                                           encod);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z2QdXv4PyeagfW0RAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zeCKsxmSMdzgltZqBEdJyFDw2EcqZcTTtJpfxlfMNhxVXF1YmjCGyzqKNKZi" +
       "HfHSWoorgPcIQyWcqGz7rWikBK2UcdwAq6khMjIk0xxt6gkNskfQNI2ptqa7" +
       "TbMVzDSe3pZH/sqrZkN6Q4BDsN2T6bHNGbP1aKM5HNMh65NVhe5ps1IDGSO1" +
       "oIkqkhVvFpTAlEWlyWyqlW28QmkciYkuNdLWkbZwnditaTizhXml1FLwZNSe" +
       "N7XZEJdmLIxKLh7Smm07zJIG3XraW7KcuSEb5Nx0XXilmyMOb3L82uVhQxrF" +
       "y+pImcf1YaqKujYr86CafUde5or/t07jgaKBOrpe/xFap93S4/nw1NEtTvG5" +
       "ePZK9uQtznEnDuVdw5vvdGtedAyfeN8LLyncJyt5x5AjvjMEzb/r/bSlxqp1" +
       "ihTone58p5lf0Dx8y58ou4t/+bMvXb37jS9N/qa41ju6nL/MQHdrkWWdbH9P" +
       "vF/0fFUzC54u75phr/jahNDrb3fhGkJ3gbHg2NtBhiF07Swk6HKL75Nw2xC6" +
       "cgwHGuLdy0mQDFAHIPnrs97hLVD5FjaKNst09++gpOTcadscOcGDP6zNOmHO" +
       "J0+1qMXfWwf6HkS7P7huyp97iWKffbX5yd19pGyJWVb8HcJAl3ZXo0e3vo/f" +
       "kdohrYu9p79//+cvP3XoIPfvGD524xO8veX2l38d2wuL67rsD974e2//rZe+" +
       "XjTx/wsaBMsodxwAAA==");
}
