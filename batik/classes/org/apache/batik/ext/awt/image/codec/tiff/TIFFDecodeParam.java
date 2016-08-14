package org.apache.batik.ext.awt.image.codec.tiff;
public class TIFFDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    private boolean decodePaletteAsShorts = false;
    private java.lang.Long ifdOffset = null;
    private boolean convertJPEGYCbCrToRGB = true;
    public TIFFDecodeParam() { super(); }
    public void setDecodePaletteAsShorts(boolean decodePaletteAsShorts) {
        this.
          decodePaletteAsShorts =
          decodePaletteAsShorts;
    }
    public boolean getDecodePaletteAsShorts() { return decodePaletteAsShorts;
    }
    public byte decode16BitsTo8Bits(int s) { return (byte) (s >> 8 & 65535);
    }
    public byte decodeSigned16BitsTo8Bits(short s) { return (byte) (s + java.lang.Short.
                                                                          MIN_VALUE >>
                                                                      8);
    }
    public void setIFDOffset(long offset) { ifdOffset = new java.lang.Long(
                                                          offset);
    }
    public java.lang.Long getIFDOffset() { return ifdOffset;
    }
    public void setJPEGDecompressYCbCrToRGB(boolean convertJPEGYCbCrToRGB) {
        this.
          convertJPEGYCbCrToRGB =
          convertJPEGYCbCrToRGB;
    }
    public boolean getJPEGDecompressYCbCrToRGB() { return convertJPEGYCbCrToRGB;
    }
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
      ("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" +
       "KT8URgJFmfFYs1baNKqxNL/XVrHUnouz7QCtk7If0uRgBTdmUjgYUStKom1x" +
       "4fJWfcPGzYKJMYKSOJMZCz1LSybLrD1OlWmP7cpdZNFEOmoaEV4TIy3KCHyu" +
       "Ky+nrbjQVYyeqgmStWZ1jVXRdZKx/S2P+VtvxQJ3m2FrjY38CG+qLTmfZoXQ" +
       "9ZS0u4moVm2Ps5Qg1g1Hz7HFYuEw4chbhDg1cLZhU5QHBd2a2PR4OUP347Y1" +
       "d9LhutnpJS1nyI5rZIEacc5K2XJcN5tzZ6aPJjWm2REzoO5Y7LS7cZtDkB0W" +
       "pRiTKG6R4G7XnYgtxsoFBSYxlSqSJKu1Qp5oYAsnS/K2Xp/UCXi/wwum1VjN" +
       "WbYt9+ScEkzMrWeqinbaxnYsNNpqsfNEeMD32a1Ukza2NkalgUXNdSyJOjyl" +
       "iNQiNdFCyCQNR0LZ3MyGAm2uF1nqbCZFu4VE3XYN37ke47VqTW7Vb3P+eN+x" +
       "nEEhww3GGcN9Ia5NVFbt4UV7BaO0ug5Th2TW9KyxHBdwe82RjGCamwk/VWaZ" +
       "a8hWPpoRacJIGhJlmEF1/fa8qWGWxWKN9chtsXMyyNqTBsqncKvn1rt7FViX" +
       "N+UWjdVkoUTBsueDtWPUsqeFlwyovJ9P0SJKjai7prFFjdjhpE1vqP0UnQeb" +
       "fXs+YfZFIBoLBI43Ub9QuiDWdXxlRkuBFIQdsucMBFJHGQdfburRshHyOtvk" +
       "d2KOjqYzYdXO2RkbNAkfm+vGDCWsZTdared+YSEhN4oaVFargaWicGFSkWEJ" +
       "Vd2eWtPr9NpI085yjHWa3FCoE2R9EGObkdqlEKmTznwV6RrNNm3M2pNaC2t2" +
       "cIMMMVirZW3c2BXruW1TDblgJ5LBu8OGNlMMYY0wDXfdEOedYCRM0GCq9yKi" +
       "5w1W8wCfK+yspWyt/VJJ0l2Cx90kLASVUXRsgyXOwutEMWP6a5JqrBO5HUsr" +
       "xlviM26PR/Gmp7dh3kFaLBX4MOdwRJHubWGibepLsOwPON2zU9OatXp7R7Lq" +
       "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" +
       "98KkugJU/Mbb/+GP/dIrv1+dr/5fp4tzpuksAAA=");
}
