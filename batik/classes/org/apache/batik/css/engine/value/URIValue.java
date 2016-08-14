package org.apache.batik.css.engine.value;
public class URIValue extends org.apache.batik.css.engine.value.StringValue {
    java.lang.String cssText;
    public URIValue(java.lang.String cssText, java.lang.String uri) { super(
                                                                        org.w3c.dom.css.CSSPrimitiveValue.
                                                                          CSS_URI,
                                                                        uri);
                                                                      this.
                                                                        cssText =
                                                                        cssText;
    }
    public java.lang.String getCssText() { return "url(" +
                                           cssText +
                                           ')'; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYa2xUxxWeXb+NjR+AoeAHGENkY3ZDG1JRExrY2MFk/ZBt" +
       "kLoUltm7s7sX3733cu+svXZKmiBVIX8iSnm1SvzLEQqiSVQ1ais1kauoTaK0" +
       "lZLQR1qFVu2ftClqUNW0Kn2dmbnvXZvmR1e6c2dnzjkz58w53zlzr99CVaaB" +
       "OolKI3ROJ2ZkUKXj2DBJOqZg05yCsaR0uQL/5fgHo3vCqDqBVuewOSJhkwzJ" +
       "REmbCdQhqybFqkTMUULSjGPcICYxZjCVNTWB1snmcF5XZEmmI1qaMIIj2Iij" +
       "FkypIacKlAxbAijqiMNOonwn0f3B6YE4apA0fc4l3+Ahj3lmGGXeXcukqDl+" +
       "Es/gaIHKSjQum3SgaKAduqbMZRWNRkiRRk4quy0THIrvLjFB90tNH985l2vm" +
       "JliDVVWjXD1zgpiaMkPScdTkjg4qJG+eQo+hijha5SGmqCduLxqFRaOwqK2t" +
       "SwW7byRqIR/TuDrUllStS2xDFG3xC9GxgfOWmHG+Z5BQSy3dOTNou9nRVmhZ" +
       "ouLFHdELl483f6sCNSVQk6xOsu1IsAkKiyTAoCSfIoa5P50m6QRqUeGwJ4kh" +
       "Y0Wet0661ZSzKqYFOH7bLGywoBODr+naCs4RdDMKEtUMR70MdyjrX1VGwVnQ" +
       "tc3VVWg4xMZBwXoZNmZkMPidxVI5LatpirqCHI6OPY8AAbDW5AnNac5SlSqG" +
       "AdQqXETBajY6Ca6nZoG0SgMHNCjauKxQZmsdS9M4S5LMIwN042IKqOq4IRgL" +
       "ReuCZFwSnNLGwCl5zufW6N6nH1UPqmEUgj2niaSw/a8Cps4A0wTJEINAHAjG" +
       "hr74Jdz2ytkwQkC8LkAsaL7zpdsP9ncuvSFoNpWhGUudJBJNSoup1W+3x3r3" +
       "VLBt1OqaKbPD92nOo2zcmhko6oAwbY5ENhmxJ5cmfvSFx6+RD8OofhhVS5pS" +
       "yIMftUhaXpcVYjxMVGJgStLDqI6o6RifH0Y10I/LKhGjY5mMSegwqlT4ULXG" +
       "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" +
       "tJBIkuzvRb7+Bd5lzeX/AkyDYKUBFgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h6/5/Tf+1vPfyk/f/hc7LlzwfiAAAA==");
}
