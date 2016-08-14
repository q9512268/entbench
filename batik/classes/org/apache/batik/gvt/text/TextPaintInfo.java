package org.apache.batik.gvt.text;
public class TextPaintInfo {
    public boolean visible;
    public java.awt.Paint fillPaint;
    public java.awt.Paint strokePaint;
    public java.awt.Stroke strokeStroke;
    public java.awt.Composite composite;
    public java.awt.Paint underlinePaint;
    public java.awt.Paint underlineStrokePaint;
    public java.awt.Stroke underlineStroke;
    public java.awt.Paint overlinePaint;
    public java.awt.Paint overlineStrokePaint;
    public java.awt.Stroke overlineStroke;
    public java.awt.Paint strikethroughPaint;
    public java.awt.Paint strikethroughStrokePaint;
    public java.awt.Stroke strikethroughStroke;
    public int startChar;
    public int endChar;
    public TextPaintInfo() { super(); }
    public TextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi) { super(
                                                                         );
                                                                       set(
                                                                         pi);
    }
    public void set(org.apache.batik.gvt.text.TextPaintInfo pi) { if (pi ==
                                                                        null) {
                                                                      this.
                                                                        fillPaint =
                                                                        null;
                                                                      this.
                                                                        strokePaint =
                                                                        null;
                                                                      this.
                                                                        strokeStroke =
                                                                        null;
                                                                      this.
                                                                        composite =
                                                                        null;
                                                                      this.
                                                                        underlinePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        underlineStroke =
                                                                        null;
                                                                      this.
                                                                        overlinePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        null;
                                                                      this.
                                                                        overlineStroke =
                                                                        null;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        null;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        null;
                                                                      this.
                                                                        visible =
                                                                        false;
                                                                  }
                                                                  else {
                                                                      this.
                                                                        fillPaint =
                                                                        pi.
                                                                          fillPaint;
                                                                      this.
                                                                        strokePaint =
                                                                        pi.
                                                                          strokePaint;
                                                                      this.
                                                                        strokeStroke =
                                                                        pi.
                                                                          strokeStroke;
                                                                      this.
                                                                        composite =
                                                                        pi.
                                                                          composite;
                                                                      this.
                                                                        underlinePaint =
                                                                        pi.
                                                                          underlinePaint;
                                                                      this.
                                                                        underlineStrokePaint =
                                                                        pi.
                                                                          underlineStrokePaint;
                                                                      this.
                                                                        underlineStroke =
                                                                        pi.
                                                                          underlineStroke;
                                                                      this.
                                                                        overlinePaint =
                                                                        pi.
                                                                          overlinePaint;
                                                                      this.
                                                                        overlineStrokePaint =
                                                                        pi.
                                                                          overlineStrokePaint;
                                                                      this.
                                                                        overlineStroke =
                                                                        pi.
                                                                          overlineStroke;
                                                                      this.
                                                                        strikethroughPaint =
                                                                        pi.
                                                                          strikethroughPaint;
                                                                      this.
                                                                        strikethroughStrokePaint =
                                                                        pi.
                                                                          strikethroughStrokePaint;
                                                                      this.
                                                                        strikethroughStroke =
                                                                        pi.
                                                                          strikethroughStroke;
                                                                      this.
                                                                        visible =
                                                                        pi.
                                                                          visible;
                                                                  }
    }
    public static boolean equivilent(org.apache.batik.gvt.text.TextPaintInfo tpi1,
                                     org.apache.batik.gvt.text.TextPaintInfo tpi2) {
        if (tpi1 ==
              null) {
            if (tpi2 ==
                  null)
                return true;
            return false;
        }
        else
            if (tpi2 ==
                  null)
                return false;
        if (tpi1.
              fillPaint ==
              null !=
              (tpi2.
                 fillPaint ==
                 null))
            return false;
        if (tpi1.
              visible !=
              tpi2.
                visible)
            return false;
        boolean tpi1Stroke =
          tpi1.
            strokePaint !=
          null &&
          tpi1.
            strokeStroke !=
          null;
        boolean tpi2Stroke =
          tpi2.
            strokePaint !=
          null &&
          tpi2.
            strokeStroke !=
          null;
        return tpi1Stroke ==
          tpi2Stroke;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZe2wcxRmfO8ePOHb8CEkcEzuJ4wTsJHdJGl5ySklMHoZL" +
       "4sYhbR3IZW9vzrfx3u5md84+h6Y81IpQqQjSEEIFaf8IDUVAUAUqFQ+lRS1Q" +
       "aFVepbQFqrZS00JUIlRaFSj9vpnd28fdXmoLLO14b2a++X7fN7/5vpnZB8+Q" +
       "assknVRjMTZhUCu2QWODkmnRdL8qWdYOqEvKd1VJ7+8+vfWyKKkZJjOzkrVF" +
       "liy6UaFq2homHYpmMUmTqbWV0jRKDJrUouaYxBRdGyazFWsgZ6iKrLAteppi" +
       "h52SmSAtEmOmksozOmAPwEhHApDEOZL4umBzX4I0yLox4XZv83Tv97Rgz5yr" +
       "y2KkObFXGpPieaao8YRisb6CSZYZujoxouosRgsstle9yHbBVYmLSlzQ9UjT" +
       "Bx/enm3mLpglaZrOuHnWdmrp6hhNJ0iTW7tBpTlrH/kaqUqQGZ7OjHQnHKVx" +
       "UBoHpY61bi9A30i1fK5f5+YwZ6QaQ0ZAjCzyD2JIppSzhxnkmGGEOmbbzoXB" +
       "2oVFa4WVJSbeuSx++K7dzT+sIk3DpEnRhhCODCAYKBkGh9JciprWunSapodJ" +
       "iwaTPURNRVKV/fZMt1rKiCaxPEy/4xaszBvU5DpdX8E8gm1mXma6WTQvwwll" +
       "/6rOqNII2DrHtVVYuBHrwcB6BYCZGQl4Z4tMG1W0NCMLghJFG7uvhg4gWpuj" +
       "LKsXVU3TJKggrYIiqqSNxIeAetoIdK3WgYAmI+2hg6KvDUkelUZoEhkZ6Dco" +
       "mqDXdO4IFGFkdrAbHwlmqT0wS575ObN17W3Xa5u1KIkA5jSVVcQ/A4Q6A0Lb" +
       "aYaaFNaBEGzoTRyR5jx1MEoIdJ4d6Cz6/OirZ69Y3nnqOdHn/DJ9tqX2Upkl" +
       "5eOpmS/N7++5rAph1Bm6peDk+yznq2zQbukrGBBh5hRHxMaY03hq+8+/cuMD" +
       "9J0oqR8gNbKu5nPAoxZZzxmKSs1NVKOmxGh6gEynWrqftw+QWnhPKBoVtdsy" +
       "GYuyATJN5VU1Ov8NLsrAEOiienhXtIzuvBsSy/L3gkEIqYWHNMCziIg//p+R" +
       "4XhWz9G4JEuaounxQVNH+604RJwU+DYbTwHrR+OWnjeBgnHdHIlLwIMstRtG" +
       "xmBucXnugGJQArYOAIYYcsz4TEcvoG2zxiMRcPv84KJXYb1s1tU0NZPy4fz6" +
       "DWcfTr4gCIWLwPYKIxeAwphQGOMKY6AwhgpjPoUkEuF6zkPFYmphYkZhiUOM" +
       "begZuu6qPQe7qoBTxvg08GoUunb5ck2/Gwec4J2UT7Y27l/01qpnomRagrRK" +
       "MstLKqaOdeYIBCV51F63DSnIQm4yWOhJBpjFTF2maYhFYUnBHqVOH6Mm1jNy" +
       "nmcEJ1XhooyHJ4qy+Mmpo+M37bxhZZRE/fEfVVZD6ELxQYzaxejcHVz35cZt" +
       "uuX0ByePHNDdCOBLKE4eLJFEG7qCTAi6Jyn3LpQeSz51oJu7fTpEaAbTjMGv" +
       "M6jDF2D6nGCNttSBwRndzEkqNjk+rmdZUx93azhFW/j7eUCLGbji2uC52F6C" +
       "/D+2zjGwnCsojTwLWMGTweeHjHt/+6u/fY6728kbTZ6EP0RZnydW4WCtPCq1" +
       "uLTdYVIK/d48OvjtO8/csotzFnosLqewG8t+iFEwheDmbzy374233zr+arTI" +
       "8wiDZJ1PwZ6nUDQS60l9BSNB21IXD8Q6FSICsqb7Gg34qWQUKaVSXFgfNS1Z" +
       "9di7tzULHqhQ49Bo+bkHcOvnrSc3vrD7X518mIiMudb1mdtNBPBZ7sjrTFOa" +
       "QByFm17uuPtZ6V5IBRB+LWU/5RGVcB8QPmkXcftX8nJNoO0SLJZYXvL715dn" +
       "T5SUb3/1vcad7z19lqP1b6q8c71FMvoEvbBYWoDh5waD02bJykK/Nae2Xtus" +
       "nvoQRhyGEWUItNY2E0JjwccMu3d17e9+8sycPS9VkehGUq/qUnqjxBcZmQ7s" +
       "plYWomrB+MIVYnLH66Bo5qaSEuNLKtDBC8pP3Yacwbiz9z8+99G1J469xVlm" +
       "8CE6SlfQpTa5Li2/grC8AItlpbwMEw3MYEQwnP9u+/8zBQewqQIbrsZiPW+6" +
       "FIt+4aa+KXoUK9YZouF8XtmM+dCXfPgJxo1/D7xyyWsn7jgyLvZAPeFBPyDX" +
       "9p9taurmP/27hJk83JfZnwXkh+MP3tPef/k7XN6NuyjdXSjN4ZC7XNnVD+T+" +
       "Ge2q+VmU1A6TZtk+MeyU1DxGs2HYJVvOMQJOFb52/45XbO/6inllfjDme9QG" +
       "I767d4B37I3vjeWCfAc8XTbPuoIUjRD+8qWKLA2TZqR2TLEUCHD+PQbm8aF8" +
       "yoL9gJKD8D9mb4pXD+6RD3YP/kVM9rwyAqLf7Pvj39r5+t4XeXKpwx3HDsdA" +
       "z34CdiaezNYsYH8CfxF4/osPwsUKsbls7bd3uAuLW1zDwFhVgXUBA+IHWt8e" +
       "vef0Q8KAIMUCnenBw9/8JHbbYZExxDlpcclRxSsjzkrCHCySiG5RJS1cYuNf" +
       "Tx544v4DtwhUrf5d/wY41D70m49fjB394/NlNp21KV1XqaSVhBrI+/75EUZd" +
       "eWvTk7e3Vm2E/coAqctryr48HUj76Vhr5VOeCXPPYC5FbfNwchiJ9MI8uLGS" +
       "R6IvnysSfdFP8gXwLLZpujiE5HpFkodJMzIdDjUqD6pOAJ7J84Y0zmK8OoDd" +
       "mCR2PPx029q7Q7AXKmIPk2ZkBuxL9VFahBnEOjFJrBgCltjaloRgvaEi1jBp" +
       "RhoE1iFeOq5uKrpa1Afw3zgFniy1ESwNwX+wIv4waYZpJMf3u0XwrUXw/U5T" +
       "AP+tU+DKhTaCC0Pw31ERf5g0sDqvwUYMT/ShdDk0SbgXwNNjK+wJgXu0Itww" +
       "aTg5FuEOVeb43VPgeK+ttjcE9Hcrgg6TBjoHQGP11wN4vzdJvAvhWW5rXB6C" +
       "9/sV8YZJM9KIJ/WKlDgxSbS4blbY+laEoH2oItowaUZmOWjPwYiHp7DqYrbW" +
       "WAjmRytiDpOGVefHXI4Qj00SLobWlbbClSFwn6gIN0waQhoEaWWU4uVCfiQb" +
       "6uEnJwl5GTyrbKWrQiD/tCLkMGlG2nyQz0GNZ6ZA59W26tUhwJ+vCDxMGuhc" +
       "Bng5fvxiCvxYY2tdE4L51xUxh0lDEoTjisn6s/Zl37VYJAU+yfMOJ6EqZ0Pl" +
       "2Xbiz9HgXvClz8C8P2DxMuPX2ggWf74W0PtmBb1l92P8r4YErrU92j0nY4J7" +
       "+46wLw98X3/85sPH0tvuWxW1T+sZ8C7TjRUqHaOqZyi84e3wHbK38G8t7on1" +
       "zZmH/vzj7pH1k7ncxbrOc1zf4u8FcOboDT9BBaE8e/Pf23dcnt0ziXvaBQEv" +
       "BYf8wZYHn9+0VD4U5R+WxFG65IOUX6jPf2KpNynLm5r/jLK4lFVr7XldG2SV" +
       "y5ywFRMmWv6mB39u5qOerXB98z4W78JKsigrt8KmjelK2uXzmU/jdofXny7a" +
       "145teOzI2PZlKriGl71YrBDExdcYIzUW/+wZuLdtqTBqwClRd7jNRddFqsJd" +
       "F6nGyo8Yqaf78sqYolKRDXa73vr4U7kLgx2U70oObx3bSr4Kiy+Z8sPHmurm" +
       "Hrvmdb5Mi18bG2DBZfKq6r3w8bzXGCbNKNzNDeL6hx+mI42MzAu9JwRu4D+E" +
       "HWkQ/ZthR12uP9ALSm/PWYw0B3syUs3/e/vNAfe6/WCaxYu3yzwYHbrga7vh" +
       "nJqa+akJb8hi4oasEPEHzuIczT7XHHli7WJfjOLf7514khdf8JPyyWNXbb3+" +
       "7MX3ia8asirt34+jzEiQWvGBpRiTFoWO5oxVs7nnw5mPTF/iRO8WAdhdDud7" +
       "VvI6WPMGcqM9cOVvdRdv/t84vvbpXx6seTlKIrtIRILtwa7Su8SCkYdksCtR" +
       "encD8Zt/i+jr+c7E5csz//g9v9Qm4q5nfnj/pPzqieteOdR2vDNKZgyQakhM" +
       "tMAvOa+c0LZTecwcJo2KtaEAEGEURVJ9F0MzkcYSftnnfrHd2VisxW9ijHSV" +
       "3ouVfkmsV/Vxaq7X4QjFozTkD7fGyU2+sJ43jICAW2NPJZZ7RdjE2QA+JhNb" +
       "DMO5Now+bvClPBq6U4ms4K/4FvsfYysOTNsjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "deTZU2SIw3AtaHh6uWljnkqu4W3m+JVsLMXroNNs6jV90t0MRL5U1X1g2ogc" +
       "D8g6U3L9CbEaSr245rANdyMI2cbuTcPycN4b2ZuOjq2orbMIfC1K4fHC0dle" +
       "051HSrjt8PG2MWOGtTlXHiXEsB8GDWpkGKqjLyM6i5NmON0i/epqTdE+v+gO" +
       "B63MoFcI4sETdKkvsnoHZahYdGNnM54PuzBWQidMysEkL83SbjCBRwvHVJsr" +
       "p6t0aauf0oMwmkSdjd2M5aUTrzrMuBHwowbN83KYoTNKTtxOJdsYg4nMJgTa" +
       "Y5a8VA7LEVcaCuwW1TKMXMjaLEBXLXrRT1m+R2/URurp485o0OOxRqqvPJN1" +
       "uTUVt7FszbZ529P5taAb3GggqSshjjGfHau47zZnm2RVIjouFztSTV5XkE6q" +
       "yihT4WY4X8EtpFT2Pce1J+IqmPQA8n7PF0eKytPN1rxWbmNVcurQYxvdLkY6" +
       "0/TM9qxdsUVeb/Oc0+z681EXG9hlc7h1bJliykvddbddBvW38AC8K8KDKi5t" +
       "dEGYUIhGafO5QGJUfzPmM3GjmnJ3nlVrshDF8bLU3Kpsd0gqrVGz36NQtc+0" +
       "qQ7ut2YNA2O2TrXvjdVpViu7TIxrM48SG9LMHHSSAWaS7QqJOZ3WMIqmzXTi" +
       "KBm19ofmGg5sReA29aqY6e0FYuIq1+p3JNOoxK1apY21EBKuZGYndVqha87S" +
       "/mLQmaWq2jW7EQJjMaLxGF4h1tJMwCi2NBGcrbJAF62IbfnluD9T+DndQxSU" +
       "GCVmNCIQOXSjrO24Yd9X0w4RwUabSnWVtKVsW8XRSrWaBbAYzGgiNUiBKbMg" +
       "QDkcOZ5iJavenA6blTK9JIkx1p7SrdCX8M6qivqLMdcT59Nle6UNp2Whrhh4" +
       "lHH9rq+P0XrThaV1Vx4lTjCVq0lA4stambBpYxArUtlWomGTbQp4aAaz9kgc" +
       "N7dtu4zHMRsJ2LxGNydNuL/gkNqkM5ebxJi110tZi5aEwwzdUWnaZwR+mfTx" +
       "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" +
       "v/kHxUb2/wPD+t3BFi8AAA==");
}
