package org.apache.batik.parser;
public class PointsParser extends org.apache.batik.parser.NumberParser {
    protected org.apache.batik.parser.PointsHandler pointsHandler;
    protected boolean eRead;
    public PointsParser() { super();
                            pointsHandler = org.apache.batik.parser.DefaultPointsHandler.
                                              INSTANCE; }
    public void setPointsHandler(org.apache.batik.parser.PointsHandler handler) {
        pointsHandler =
          handler;
    }
    public org.apache.batik.parser.PointsHandler getPointsHandler() {
        return pointsHandler;
    }
    protected void doParse() throws org.apache.batik.parser.ParseException,
        java.io.IOException { pointsHandler.startPoints();
                              current = reader.read();
                              skipSpaces();
                              loop: for (; ; ) { if (current ==
                                                       -1) {
                                                     break loop;
                                                 }
                                                 float x =
                                                   parseFloat(
                                                     );
                                                 skipCommaSpaces(
                                                   );
                                                 float y =
                                                   parseFloat(
                                                     );
                                                 pointsHandler.
                                                   point(
                                                     x,
                                                     y);
                                                 skipCommaSpaces(
                                                   ); }
                              pointsHandler.endPoints(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ckLU9I7iaObjW/yvITVx+Hf/LDA5x7FZ+g0f/0j4/BNLI1vf4/wOoDDu9mxh" +
       "ZQJQdnjvOpf+e7C1/MUgqhhBDZLdAe/Gaoal6Qh0fVauLYYu2bPu7eBEu9KV" +
       "B8zlfjBzbeuHMqciwjujZu91PvSax1zYCU+bndhtfvQKIP7Sx1k+xsdONmzI" +
       "gUWVYeoUTklkH17UzSGWojqDl+LtWJOhR+KciylaM3fhtqkForLxk2zoFxt3" +
       "FY3fiFff5fDcYR/sjiL67hT6siFaqFYxborKyA6CZW+rwMrxcCZhQVlX0oDi" +
       "43ZLe1dsnzTdHvuDCO0lszAIuoVPh7+y+639r/EaUckah505d7raAmgwXAWq" +
       "QRz6Q/gLwPNf9rDDsgnRGjZF7P50Vb5BZak5Z475FAgfbHp37IlrF4QC/oTy" +
       "EZPpmS99GDo6I4Bf3HLaCi4abh5x0xHqsOEBdrrVc+3COXr/ePHgD58+eESc" +
       "qsnbs/fAlfTCL//zWujUb1+ZpXGsSOi6SrCWR7lAvvdb4PWPUOq+L9b/6FhT" +
       "SS+0HX2oMqMpBzKkT/YmX4WVSbgc5tygnIS01WPOoSjQCX7whfiuOUI864Tq" +
       "unyo8r9y5LsQuCu2g8GI2XVFsTsbt+mZwzOn5aGnNgbt8gcFt4rqxgaVjBPV" +
       "JaqESfLA+QC/pTrY+M6847//Qfvottvpj9lcyy06YPb/SvB3Z/Ho9R/lpcN/" +
       "Xrpza2rfbbS6K31W8ov81sD5V+5fKx0P8iu5AO2Cq7yXqcsbLdUmoRlT88ZH" +
       "m7fd3AzPFtuvW/wA5kSOLyTyTVwxVl+7Y4c++zfGpT48Rz/0CBsmKOAOobEC" +
       "ZN9rpy/7SVBUOq4rshPc2Vvh99z9B5voNvi8lVd2CVvrgCdiKxu5fTsVY53D" +
       "DF+eY+0oG46AiUZ9JuIWdswx/RGYI1/3+m2d+m9hjlmKXjHWOVR+3LcWtHs+" +
       "u9qvLVrt2U9PViJGPh+BXLTxih7qG8qv8W2+wYYZQG9Z55zs30OOQU/8Pwya" +
       "pajW/fWAtb2LC75Gii9o0jOn6yubT+96i4Nc/itXLcBVMqOq7sbM9V5umCSp" +
       "cIVqRZsmysBZipqLGIpd1fgLP/U3Bf05CDE/PTQm/NdNd4GiaocORIkXN8kl" +
       "ikqAhL1+28i5oejHlcEM+7YqzJMNeAtM3hkLb+UMV01q82A5/0Kcw92M+EYc" +
       "ly6e7h986MYnnhIXaEnFU1NMSg3UXXGXz2P36qLScrLKt3fcnHepak2uyjWK" +
       "AzupscwV292AjQaLgqW+26XVnr9kvn1my/M/my5/AzqNPSiAIYT3FHb3WSMD" +
       "RXNPtLC/gDrHr71dHV+f3Lo++dff8PsTEv3I8uL0cenK2QffPL74DFyPa/pQ" +
       "GRRwkuXXjvsmtR1EGjdHUJ1i9WThiCBFwaqneZnHAhazb8fcLrY56/Kz7PML" +
       "Ra2FvVvhRyu4a04Qc5ue0WS7/alxZjyfrnPlL2MYPgZnxtXfjoqKwrwBMRqP" +
       "DhhGrrUtPW7wnE3NVslSnPsn/JUNL/4PjPURQz0aAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "e1F+oZd+4Y7fe8tvPfvNPIf7P21953x4JAAA");
}
