package org.apache.batik.gvt.font;
public class GVTGlyphMetrics {
    private java.awt.font.GlyphMetrics gm;
    private float verticalAdvance;
    public GVTGlyphMetrics(java.awt.font.GlyphMetrics gm, float verticalAdvance) {
        super(
          );
        this.
          gm =
          gm;
        this.
          verticalAdvance =
          verticalAdvance;
    }
    public GVTGlyphMetrics(float horizontalAdvance, float verticalAdvance,
                           java.awt.geom.Rectangle2D bounds,
                           byte glyphType) { super();
                                             this.gm = new java.awt.font.GlyphMetrics(
                                                         horizontalAdvance,
                                                         bounds,
                                                         glyphType);
                                             this.verticalAdvance =
                                               verticalAdvance;
    }
    public float getHorizontalAdvance() { return gm.getAdvance(
                                                      ); }
    public float getVerticalAdvance() { return verticalAdvance;
    }
    public java.awt.geom.Rectangle2D getBounds2D() { return gm.
                                                       getBounds2D(
                                                         );
    }
    public float getLSB() { return gm.getLSB(); }
    public float getRSB() { return gm.getRSB(); }
    public int getType() { return gm.getType(); }
    public boolean isCombining() { return gm.isCombining(
                                               ); }
    public boolean isComponent() { return gm.isComponent(
                                               ); }
    public boolean isLigature() { return gm.isLigature();
    }
    public boolean isStandard() { return gm.isStandard();
    }
    public boolean isWhitespace() { return gm.isWhitespace(
                                                ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDZAUxRXu3fv/gftBDjzggOOwCtTd4E/UHDHCwcHhHpx3" +
       "SPRIXGZne/cGZmeGmd67vSNEIZWAVoqyBA0xSlIVzI9BsaxYWkkkpDRRY4yl" +
       "MYlKqUmsRONPlaQqYmLUvNc9szM7uztkI+VVTe9cd7/u971+/b1+PUfeJjWW" +
       "SboNSUtKETZpUCsyhO9DkmnRZJ8qWdZGqI3LN/15//WnftewK0xqR8n0Mcka" +
       "lCWL9itUTVqjZJ6iWUzSZGqtpzSJEkMmtag5LjFF10bJTMUayBiqIitsUE9S" +
       "7LBJMmOkTWLMVBJZRgfsARiZH+PaRLk20RX+Dr0x0izrxqQr0Fkg0Odpw74Z" +
       "dz6LkdbYVmlcimaZokZjisV6cyY519DVybSqswjNschW9WLbEOtiFxeZofu+" +
       "lnffv3mslZthhqRpOuMQrWFq6eo4TcZIi1u7WqUZazv5MqmKkSZPZ0Z6Ys6k" +
       "UZg0CpM6eN1eoP00qmUzfTqHw5yRag0ZFWJkYeEghmRKGXuYIa4zjFDPbOxc" +
       "GNAuyKN1ltsH8dZzowe+cV3r/VWkZZS0KNoIqiODEgwmGQWD0kyCmtaKZJIm" +
       "R0mbBgs+Qk1FUpUpe7XbLSWtSSwLLuCYBSuzBjX5nK6tYCUBm5mVmW7m4aW4" +
       "U9n/1aRUKQ1YO1ysAmE/1gPARgUUM1MS+J4tUr1N0ZLcjwol8hh7roQOIFqX" +
       "oWxMz09VrUlQQdqFi6iSlo6OgPNpaehao4MLmtzXygyKtjYkeZuUpnFGZvv7" +
       "DYkm6NXADYEijMz0d+MjwSp1+lbJsz5vr1++b4e2VguTEOicpLKK+jeBUJdP" +
       "aJimqElhHwjB5qWx26SOh/eGCYHOM32dRZ8Hv3TyivO6jj8u+swp0WdDYiuV" +
       "WVw+nJj+zNy+JZdVoRr1hm4puPgFyPkuG7JbenMGME1HfkRsjDiNx4d/de0N" +
       "d9M3w6RxgNTKuprNgB+1yXrGUFRqrqEaNSVGkwOkgWrJPt4+QOrgPaZoVNRu" +
       "SKUsygZItcqranX+P5goBUOgiRrhXdFSuvNuSGyMv+cMQkgdPKQZnvlE/PFf" +
       "RrZGx/QMjUqypCmaHh0ydcSPC8o5h1rwnoRWQ48mwP+3nb8scknU0rMmOGRU" +
       "N9NRCbxijIrGaHqcRVNgpuiaTRvXqJPG2CAFF5OtCPqc8YnOlkPsMyZCIViW" +
       "uX5SUGE/rdXVJDXj8oHsytUn740/KRwON4ltNUaWwJQRMWWETxmBKSM4ZcQ3" +
       "JQmF+Exn4dRi8WHptgEJAAs3Lxn54rote7urwOuMiWqwexi6nlMUlfpctnAo" +
       "Pi4feWb41NNPNd4dJmEglAREJTc09BSEBhHZTF2mSeCmckHCIcpo+bBQUg9y" +
       "/ODErk3Xf4rr4WV7HLAGiArFh5Cj81P0+Hd5qXFb9rz+7tHbdurufi8IH07U" +
       "K5JEGun2r6sffFxeukB6IP7wzp4wqQZuAj5mEuwfoLou/xwFdNLrUDNiqQfA" +
       "Kd3MSCo2OXzayMZMfcKt4Q7Xxt/PgiVuwv3VCc+59objv9jaYWA5Szgo+owP" +
       "Baf+z44Ydz7/279fyM3tRIkWT3gfoazXw0w4WDvnoDbXBTealEK/lw4O7b/1" +
       "7T2buf9Bj0WlJuzBsg8YCZYQzPzVx7e/8MrLh58L5302xCA0ZxNwysnlQWI9" +
       "aQwAiX7u6gPMpsJ+R6/puVoDr1RSipRQKW6S/7QsXvbAW/tahR+oUOO40Xmn" +
       "H8CtP3slueHJ60518WFCMkZW12ZuN0HXM9yRV5imNIl65HY9O++bj0l3AvED" +
       "2VrKFOX8Gbb3LSo1GwIll5QmHDbwUIGFju/Z2ngiHMkmLDZkKhlYq3E7Xh3t" +
       "OLX90bqpVU4sKiUiel5pDT79k7Wvxbkv1CMFYD1qMs2zuVeYaY8jtoo1+gj+" +
       "QvB8iA+uDVYI5m/vs8PPgnz8MYwcaL8k4MBYCCG6s/2VbXe8fo+A4I/Pvs50" +
       "74GbPorsOyAWWBxiFhWdI7wy4iAj4GDxGdRuYdAsXKL/taM7f/qDnXuEVu2F" +
       "IXk1nDjv+cMHv4kc/NMTJRgfdpouiaPohejzwvN5ZPetjwBVu+zOf13/tec3" +
       "AL0MkPqspmzP0oGkd1Q4h1nZhGfB3AMSr/DCw8VhJLQU1oFXX8QViebVIVwd" +
       "wtsGsOixvCxbuFyeo3Zcvvm5d6ZteufYSQ658KzuJZVByRD2bsNiMdp7lj+i" +
       "rZWsMeh30fH1X2hVj78PI47CiDJEaGuDCRE1V0BBdu+auhd/8UjHlmeqSLif" +
       "NIKNk/0SZ3PSADRKrTEIxjnjc1cIFpmoh6KVQyVF4HHjzi9NCaszBuObeOqh" +
       "WT9e/v1DL3P24iPMKybmS23OurQ0MWN5DhZLi+munKhvvaq5ytX472W8cOjj" +
       "7Dx9pKmegZOsDOEqrdILVvEel9jejj/LPe9XMFKdmGTU75/4b79wmWsCXEbC" +
       "YoQ3rcNioxh18H8zO1YMC4k5+UPMgqJDDM+Z3fj71olvvfrzU9+tE5sxgFp8" +
       "crP/vUFN7P7Le0UOy48bJdjGJz8aPXJHZ9/lb3J5N+6j9KJc8YkQTkau7AV3" +
       "Z/4Z7q79ZZjUjZJW2c5PN0lqFqPpKORklpO0Qg5b0F6YX4lkojd/rpnrpzvP" +
       "tP4Th5dBqlkBW7iHDDzQk7nwLLQdcqHfl0OEv6jCnXm5BIvznJheZ5jKOJC/" +
       "L6g3BQzKSDidwbeL3Z3CHSpzOodKFWrebT/OeynNs+5G1ItVLCcNtDYOpzxF" +
       "ltQVyXG0b34TevQdD9A3V4oA+F8t8WVRfgKYY28Z2B/zyiW6PFId3n3gUHLD" +
       "XcvC9gZdwYAOdeN8lY5T1TNUE497/p02yNN7120vefZU1YlbZjcXZwo4UleZ" +
       "PGBp+S3pn+Cx3W90brx8bEsFKcB8H37/kD8cPPLEmnPkW8L8hkLskqKbjUKh" +
       "3sK90WhSljW1wnjanV+xNlyJxfD02SvWVznblxMNoNqvB7Ttw2IPI2elKVur" +
       "m8oUklOBm7oeurdyiubVXyk0wCJ41tko1lVugHKiASAPBrTdjsV+oEowwKYS" +
       "u9SFf+Bjw5/lsMNVNoarKodfTjQA4uGAtu9h8W1GmgD+Sj2rJa0LVmHVtS7u" +
       "75yZZUfw19jKX1M57nKiAdjuC2i7H4sfQRYJuGMjK31LfeTMQY7bescrh1xO" +
       "NADWzwLajmHxoIA8XAT5oY8NuQWbOuBJ2XqnKodcTjQA1uMBbb/G4hE4VwDk" +
       "/OVIwIG2StGK8i38tz/nGurRj22oGdjUBU/GRpup3FDlRAOM8UJA2wksngMa" +
       "wNNkJqFoipY+nbHqErquUkk7ncF+f+YMxmzUrHKDlRMNMMobAW1vYfFXx2CG" +
       "rlGN3xG95OL+25nBPQ+eHbbyOyrHXU40ANu7AW3vYXGSYdoRU9L8w5MP9j/O" +
       "HOzdtu67K4ddTrQ8tFA4oI2nzR9w2CMMz7tm0gf7wzMDG8/wN9q631g57HKi" +
       "AdCmB7ThVVCogZFmxfr8mAK5viHJvvUONf4fiTtkRL5vFniRMrvoc6n4xCff" +
       "e6ilftahq//I783zn+GaY6Q+lVVVb27qea81TJpSuM2aRaZqcEyQjp1d9lMK" +
       "I9X4g3qHOkT/Tjgcl+oP0QJKb895jLT6ezJSw3+9/RaAH7n9ICCLF2+XRTA6" +
       "dMHXHnFnNBsG5xc1mMxHRDKfC/GmfIqXd8aZp1sTT1a4qCDn4h+2nfwoKz5t" +
       "x+Wjh9at33Hy03eJDwCyKk1N4ShNMVInvkXwQTHHWlh2NGes2rVL3p9+X8Ni" +
       "J89sEwq7vj3HQzfDEE8M9I1O3+241ZO/JH/h8PJjT+2tfTZMQptJSGJkxubi" +
       "a4+ckYUEcHOs1M0pZKD84r638dUtT7/3Yqid39QRcdfaFSQRl/cfOzGUMozb" +
       "w6RhgNRAGk1z/E5m1aQ2TOVxs+AitjbBT9jcVjEyHR1Zwo/e3DK2Qafla/ED" +
       "EiPdxbfSxR/VGlV9gpr8/I7DTPNlpVnD8LZyy67ezoM5Whp8LR4bNAz7Or72" +
       "HW55w8DNGuIHgP7/Av86quO9IgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
