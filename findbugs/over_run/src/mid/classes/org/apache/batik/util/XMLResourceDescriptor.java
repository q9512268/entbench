package org.apache.batik.util;
public class XMLResourceDescriptor {
    public static final java.lang.String XML_PARSER_CLASS_NAME_KEY = "org.xml.sax.driver";
    public static final java.lang.String CSS_PARSER_CLASS_NAME_KEY = "org.w3c.css.sac.driver";
    public static final java.lang.String RESOURCES = "resources/XMLResourceDescriptor.properties";
    protected static java.util.Properties parserProps = null;
    protected static java.lang.String xmlParserClassName;
    protected static java.lang.String cssParserClassName;
    protected static synchronized java.util.Properties getParserProps() {
        if (parserProps !=
              null)
            return parserProps;
        parserProps =
          new java.util.Properties(
            );
        try {
            java.lang.Class cls =
              org.apache.batik.util.XMLResourceDescriptor.class;
            java.io.InputStream is =
              cls.
              getResourceAsStream(
                RESOURCES);
            parserProps.
              load(
                is);
        }
        catch (java.io.IOException ioe) {
            throw new java.util.MissingResourceException(
              ioe.
                getMessage(
                  ),
              RESOURCES,
              null);
        }
        return parserProps;
    }
    public static java.lang.String getXMLParserClassName() { if (xmlParserClassName ==
                                                                   null) {
                                                                 xmlParserClassName =
                                                                   getParserProps(
                                                                     ).
                                                                     getProperty(
                                                                       XML_PARSER_CLASS_NAME_KEY);
                                                             }
                                                             return xmlParserClassName;
    }
    public static void setXMLParserClassName(java.lang.String xmlParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          xmlParserClassName =
          xmlParserClassName;
    }
    public static java.lang.String getCSSParserClassName() {
        if (cssParserClassName ==
              null) {
            cssParserClassName =
              getParserProps(
                ).
                getProperty(
                  CSS_PARSER_CLASS_NAME_KEY);
        }
        return cssParserClassName;
    }
    public static void setCSSParserClassName(java.lang.String cssParserClassName) {
        org.apache.batik.util.XMLResourceDescriptor.
          cssParserClassName =
          cssParserClassName;
    }
    public XMLResourceDescriptor() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "p6YUBPnma9p/AU1u9Q7ZHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5l2n15aM+oh1mtg62FXXw1ZTM3rDWY2u4v1JLyY6eDX1uk3EFUaz3XDuzLY0" +
       "MSJSUiE6Os4yTbEGj7i2miBctsIxx+0aGpj2lodudxLFDrM+jtaEMb0wKhVZ" +
       "lhuLdbszhFPSW9c6UjDpThodnU9kzNvWDV2fMw1+I8qsOMLMOrOhR65a1YYV" +
       "B523HS3SM3fXD/HANPN8KGxnQ9OJMgwVo6QhN8dyI62Em7imBohlMtNg2V4x" +
       "HVPisNBsWmKFaSEKw1ZXazRabqb1BS70u8y0T6hEv7usD2QDHywWHEnMFtWA" +
       "qLPmdpDyq9l2Po1W6bA52qZtcWEvu4IKNnhIdTlNGcVMYSlsIwGNrpP1chXL" +
       "A5VwvIhbJvQmk2SO6DqqkG4YBwmduGtZ9CRZtqpKbPkSHCJhe9IxI1vD/cTr" +
       "4Wxf10ycwOB2xWuwNNpIYQqBbbFOSk4l77a3IsVydjVep7t0PV5XjG5dHFTq" +
       "LDEld0wmIWIv6U62mtS0e62O2KWAMJv1bKov+FndZyd+ZdicY/V5ZaFkfLui" +
       "bTuMUYt7bMUOF0vDJSIZZaRkWq9oKOpkukynJiuNFnCe5lZYnbFKM4rNJnD4" +
       "NV7LGyO4RQWpReGaQCwmWUB1O+m0laomPt911gS1ETEuwEyyyREuQtNq3K/F" +
       "GJkJ4yRJVhUSWbsyOoroJcLDUl1NDanTapm0Lkw4I17p6ajVXOTqNFwPGJUw" +
       "QiOq1nS3h3cJWdk2dnxj3sIsqY9NFllf7/hVSehijADWsylPNeYKHC2SJrZS" +
       "GbJb4SRDmXtLsedR0Yia9ByxyeFCdwhi4Np8no/r87649XVYGEj0luNcra/t" +
       "WImcUl53uqzuKhXRW1soiod+x0UnXKjJFKHtNigXMD2QLNwa1qiq86VsNeQ0" +
       "TBoJl4kN21/CrVYcL+DERRr2VGQMh9SC+jxY93a72o6bTfINLGp6NGqOgtVW" +
       "y3i8TgTBGmVyZbaGRZRK4IW1sRvCYBVwWL4iZhGjAik4t0HHJkMRaphizm6t" +
       "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" +
       "Cep3FYXF0f2Hj1B/+AFQH5za/pvC/PJ96v5hkXwxgp4GMJdD9rIz0FO0P///" +
       "gPZmUdgDn3mE1vwuor2yv3otxS0JfvU+kL9SJP8EQA4vg1w2+dgZB/HjEfRw" +
       "4pnqqRp+5bsx6OmRGtK/oEH/V/ep+2qR/Np+0Ds8f/9B//XvxqD/2BHaH/uL" +
       "HPTfuw/k3y+Sr+0H/XLI//wU8u88COQMML30Pqq4Ln/2rudu+ydayi++fv2x" +
       "d74u/JvywcXJM6prLPTYOrbts7ebZ/JX/UBbmyWea/u7Tr/89w0gwqXPYIDp" +
       "Fv9Kmb++p/3DCLpxkTaCHin/n6X7TxH0+CldBF3dZ86SfDOCHgIkRfaP/OML" +
       "qTP3B/sL3uzK+XXxRMs330zLZ5bSl88tgOVTw+PFKt4/NryjfPn1AffRbze/" +
       "sH8LotjSbldweYyFHt0/SzlZ8F68J7djXlfpV77z5C9de9/x4vzkXuBTaz0j" +
       "23suf2xBOn5UPo/Y/dN3/uMf/JnXv15eoPxfJCJNtgMqAAA=");
}
