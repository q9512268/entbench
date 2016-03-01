package org.apache.batik.css.dom;
public class CSSOMSVGStyleDeclaration extends org.apache.batik.css.dom.CSSOMStyleDeclaration {
    protected org.apache.batik.css.engine.CSSEngine cssEngine;
    public CSSOMSVGStyleDeclaration(org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider vp,
                                    org.w3c.dom.css.CSSRule parent,
                                    org.apache.batik.css.engine.CSSEngine eng) {
        super(
          vp,
          parent);
        cssEngine =
          eng;
    }
    protected org.w3c.dom.css.CSSValue createCSSValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        if (idx >
              org.apache.batik.css.engine.SVGCSSEngine.
                FINAL_INDEX) {
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGPaintManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                  name);
            }
            if (cssEngine.
                  getValueManagers(
                    )[idx] instanceof org.apache.batik.css.engine.value.svg.SVGColorManager) {
                return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                  name);
            }
        }
        else {
            switch (idx) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FILL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STROKE_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationPaintValue(
                      name);
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FLOOD_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LIGHTING_COLOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       STOP_COLOR_INDEX:
                    return new org.apache.batik.css.dom.CSSOMSVGStyleDeclaration.StyleDeclarationColorValue(
                      name);
            }
        }
        return super.
          createCSSValue(
            name);
    }
    public class StyleDeclarationColorValue extends org.apache.batik.css.dom.CSSOMSVGColor implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationColorValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGColor.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationColorValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "SkyCosCwpv0X22nbzg4WAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "RaVdtmyP5MWoysBTnhOMeuYbYcpXx15PtzSdG9ccczJ16XLfsMtRb2qNtjzv" +
           "hjDT8yos4ZXl1UIRMJSAk/XY7LYlVYJhHXHG9Y5bG0gobq6Z6VIi0glb511z" +
           "YlDoHE2W/mpmdccezbOLSSNspsaUrMGSOeP1Mu4lUivwp+E44Sf4ai6YXtVo" +
           "raWuNceWgmn2Vb437G0tfT1zUk0edP21L3Kx1hmKsbLeIFW1vG0qG6W8HGtq" +
           "r2Nh1bk3FhYSM10wkTluM6Yerjy6wwizQVkoZ7PpxMTd2bo2bq/K01k4TeN5" +
           "hIaDnqToc52lKwMNH3mhVNYcCbUdjGkSlWRqsPxCG2yqDDvXmojYncttJEIX" +
           "ZDTEYTXVrHbKDKhuC0+7KGlzDa/VM0Mj4ztoJ+SopjrB2+tZmWST0TpEpi19" +
           "TXQUccWult2puREwjfBGEyya6b3OKOTFTo+Lgg4bUbLQWPXUANlsFgNaxNY1" +
           "VsN8uzNDJ5rlhFhf42qJqmXbWrMzmtSaQanO6niIq5Npn16OS4FA9uBli55t" +
           "Jj2FxTYCgcRUrQzrrqGMsIzAa/OGFuLu1tvAWtJtLeEW0/fDbaNn9ThnOiS8" +
           "rmsI62XU8JZCuYMgSywZOo5Pb8e2bScDb4rolreZDZ3ekirLepeGl3o5YpMk" +
           "6aSMxsQEvejOpJG+CWd4rWdws3YsMdiw1Ue6tGWuJhlC9GcyK1BZi+K0tmpn" +
           "E7O1qjthKhm1hqHW7cqwlzQ1y9T7vUifGCqmzILeGpbqhhNrCcOWjajtqSRN" +
           "uUSnD6/WG2NKww7C9hhBJ4LVmukSaNBDu/KoLmadDqUvBH7CeZnbhlvk2CK4" +
           "2DL89YxV2hN71iKb87ZppRnWGOFthVnTE7/PmLK7ioboqjpRmUTtdDZkpTIj" +
           "ie5YKsPNeM0shLlUEvD2osNhVovZYJhWQiYiQ/nSiEzkSEucQclecG184/XJ" +
           "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");
    }
    public class StyleDeclarationPaintValue extends org.apache.batik.css.dom.CSSOMSVGPaint implements org.apache.batik.css.dom.CSSOMSVGColor.ValueProvider {
        protected java.lang.String property;
        public StyleDeclarationPaintValue(java.lang.String prop) {
            super(
              null);
            valueProvider =
              this;
            setModificationHandler(
              new org.apache.batik.css.dom.CSSOMSVGPaint.AbstractModificationHandler(
                ) {
                  protected org.apache.batik.css.engine.value.Value getValue() {
                      return StyleDeclarationPaintValue.this.
                        getValue(
                          );
                  }
                  public void textChanged(java.lang.String text)
                        throws org.w3c.dom.DOMException {
                      if (handler ==
                            null) {
                          throw new org.w3c.dom.DOMException(
                            org.w3c.dom.DOMException.
                              NO_MODIFICATION_ALLOWED_ERR,
                            "");
                      }
                      java.lang.String prio =
                        getPropertyPriority(
                          property);
                      CSSOMSVGStyleDeclaration.this.
                        handler.
                        propertyChanged(
                          property,
                          text,
                          prio);
                  }
              });
            property =
              prop;
        }
        public org.apache.batik.css.engine.value.Value getValue() {
            return CSSOMSVGStyleDeclaration.this.
                     valueProvider.
              getValue(
                property);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYa3AT1xW+kt/C+AU2rgEDjnDHDtXWDTTNmKYxCg9TGWss" +
           "4pmKNvLV7pW0sNpddq9sGZoQ6KRh+JGmAVL6wH9KpoWhSabTTPsn1J1Om2TS" +
           "NAPNtEmYpo/8aZswE340Tktf597d1a5Wkpn8qmf2an3vuefec893vnPuXr6B" +
           "GkwDDehYlXCEzuvEjMTZexwbJpGiCjbN/dCbEk/96fSxpd+0HA+ixiRqy2Fz" +
           "QsQm2SUTRTKTaL2smhSrIjH3ESKxGXGDmMSYxVTW1CTqls3xvK7IokwnNIkw" +
           "gWlsxFAnptSQ0wVKxm0FFG2I8d0IfDfCmF9gNIZaRU2fdyf0lU2IesaYbN5d" +
           "z6SoI3YQz2KhQGVFiMkmHS0a6E5dU+azikYjpEgjB5Vt9kHsjW2rOIaB59o/" +
           "uPVEroMfwyqsqhrlJppTxNSUWSLFULvbu1MhefMwehjVxdAKjzBF4ZizqACL" +
           "CrCoY68rBbtfSdRCPqpxc6ijqVEX2YYo2lSuRMcGzttq4nzPoKGZ2rbzyWDt" +
           "xpK1jrt9Jp69UzjzjQc7fliH2pOoXVYTbDsibILCIkk4UJJPE8MckyQiJVGn" +
           "Cg5PEEPGinzE9naXKWdVTAsAAedYWGdBJwZf0z0r8CTYZhREqhkl8zIcVPZ/" +
           "DRkFZ8HWHtdWy8JdrB8MDMmwMSODAXv2lPpDsipxHJXPKNkY/jwIwNSmPKE5" +
           "rbRUvYqhA3VZEFGwmhUSAD41C6INGkDQ4FiroZSdtY7FQzhLUhT1+uXi1hBI" +
           "tfCDYFMo6vaLcU3gpT6flzz+ubFv++NH1T1qEAVgzxIRFbb/FTCp3zdpimSI" +
           "QSAOrImtw7GncM8LJ4MIgXC3T9iS+fGXb963pX/xJUtmbRWZyfRBItKUeCHd" +
           "dnVddOieOraNZl0zZeb8Mst5lMXtkdGiDkzTU9LIBiPO4OLUL7/wyCXybhCF" +
           "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" +
           "yxV/nTWni0yCosCwrv8Pvc/Gjw4WAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fr2Q/sF9v/fW33r+W/kB3P8A9TtBq0khAAA=");
}
