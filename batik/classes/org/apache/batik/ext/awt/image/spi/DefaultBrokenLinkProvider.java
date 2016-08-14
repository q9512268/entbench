package org.apache.batik.ext.awt.image.spi;
public class DefaultBrokenLinkProvider extends org.apache.batik.ext.awt.image.spi.BrokenLinkProvider {
    static org.apache.batik.ext.awt.image.renderable.Filter brokenLinkImg =
      null;
    static final java.lang.String MESSAGE_RSRC = "resources.Messages";
    static final java.awt.Color BROKEN_LINK_COLOR = new java.awt.Color(255,
                                                                       255,
                                                                       255,
                                                                       190);
    public static java.lang.String formatMessage(java.lang.Object base, java.lang.String code,
                                                 java.lang.Object[] params) {
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class.
                getClassLoader(
                  );
            cl =
              base.
                getClass(
                  ).
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        org.apache.batik.i18n.LocalizableSupport ls;
        ls =
          new org.apache.batik.i18n.LocalizableSupport(
            MESSAGE_RSRC,
            base.
              getClass(
                ),
            cl);
        return ls.
          formatMessage(
            code,
            params);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBrokenLinkImage(java.lang.Object base,
                                                                               java.lang.String code,
                                                                               java.lang.Object[] params) {
        synchronized (org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class)  {
            if (brokenLinkImg !=
                  null)
                return brokenLinkImg;
            java.awt.image.BufferedImage bi;
            bi =
              new java.awt.image.BufferedImage(
                100,
                100,
                java.awt.image.BufferedImage.
                  TYPE_INT_ARGB);
            java.util.Hashtable ht =
              new java.util.Hashtable(
              );
            ht.
              put(
                BROKEN_LINK_PROPERTY,
                formatMessage(
                  base,
                  code,
                  params));
            bi =
              new java.awt.image.BufferedImage(
                bi.
                  getColorModel(
                    ),
                bi.
                  getRaster(
                    ),
                bi.
                  isAlphaPremultiplied(
                    ),
                ht);
            java.awt.Graphics2D g2d =
              bi.
              createGraphics(
                );
            g2d.
              setColor(
                BROKEN_LINK_COLOR);
            g2d.
              fillRect(
                0,
                0,
                100,
                100);
            g2d.
              setColor(
                java.awt.Color.
                  black);
            g2d.
              drawRect(
                2,
                2,
                96,
                96);
            g2d.
              drawString(
                "Broken Image",
                6,
                50);
            g2d.
              dispose(
                );
            brokenLinkImg =
              new org.apache.batik.ext.awt.image.renderable.RedRable(
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  wrap(
                    bi));
            return brokenLinkImg;
        }
    }
    public DefaultBrokenLinkProvider() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16aewr13XfvCfpabGk9/Qc27JqSZb07FRm+h8uwyEJ2aln" +
       "Izkkh5wZzsJhWz8PZx/OvpBDJmoSI63dJnHtRk5dIBGCwGmaQLHTNkYKpGnV" +
       "FmkcOHCRIOgGNE6LAk3rGrA/NA3qtumd4X9/i6x+KIG5czn33HPPOfec313f" +
       "+Cb0UJpAtSj0dpYXZkdGkR25Xvso20VGejSatFk1SQ2d8NQ0FcC329qLv3L9" +
       "j7/zGfvGVejaEnqnGgRhpmZOGKS8kYbextAn0PWzr5Rn+GkG3Zi46kaF88zx" +
       "4ImTZq9MoHecq5pBtyYnIsBABBiIAFciwNgZFaj0hBHkPlHWUIMsjaG/DF2Z" +
       "QNcirRQvg164yCRSE9U/ZsNWGgAOj5T/JaBUVblIoPef6n7Q+Q6FP1eDX/tb" +
       "H7vx9x+Ari+h604wL8XRgBAZaGQJPe4b/spIUkzXDX0JPRUYhj43Ekf1nH0l" +
       "9xK6mTpWoGZ5YpwaqfyYR0ZStXlmuce1Urck17IwOVXPdAxPP/n3kOmpFtD1" +
       "3We6HjTsl9+Bgo85QLDEVDXjpMqDayfQM+j5yzVOdbw1BgSg6sO+kdnhaVMP" +
       "Bir4AN089J2nBhY8zxInsADpQ2EOWsmgZ+7JtLR1pGpr1TJuZ9DTl+nYQxGg" +
       "erQyRFklg951maziBHrpmUu9dK5/vjn98Kd/IBgGVyuZdUPzSvkfAZWeu1SJ" +
       "N0wjMQLNOFR8/EOTn1Lf/RufugpBgPhdl4gPNL/2g9/+6Pc99+ZXDjR/5i40" +
       "s5VraNlt7QurJ3/3fcTLvQdKMR6JwtQpO/+C5pX7s8clrxQRiLx3n3IsC49O" +
       "Ct/k/4Xyw79kfOMq9BgNXdNCL/eBHz2lhX7keEYyMAIjUTNDp6FHjUAnqnIa" +
       "ehjkJ05gHL7OTDM1Mhp60Ks+XQur/8BEJmBRmuhhkHcCMzzJR2pmV/kigiDo" +
       "YfBAj4PnJejwq94ZFMJ26BuwqqmBE4Qwm4Sl/ilsBNkK2NaGV8Dr13Aa5glw" +
       "QThMLFgFfmAbxwVlZKrbDHZ80P1wGjkwaZhq7mV4Eq6NAMi/Bjw3jm4kR6Xj" +
       "Rf//myxKK9zYXrkCOuh9l+HBA5E1DD1Ae1t7Lcepb3/x9levnobLsf0y6MNA" +
       "iqODFEeVFBW0AimOKimOgBRH95QCunKlavx7SmkOnlEWA4QA2Pn4y/O/NPr4" +
       "p158ALhktH0QdEpJCt8bwokzTKEr5NSAY0Nvfn77I9IP1a9CVy9icakB+PRY" +
       "WZ0tEfQUKW9djsG78b3+yT/64y/91KvhWTReAPdjkLizZhnkL162dRJqhg5g" +
       "84z9h96vfvn2b7x66yr0IEAOgJaZCrwbANFzl9u4EOyvnABnqctDQGEzTHzV" +
       "K4tO0O6xzE7C7dmXygmerPJPARs/Dx0nt47DoXqXpe+MyvR7Dk5TdtolLSpg" +
       "/sg8+pl/87X/0qrMfYLh18+NinMje+UcbpTMrlcI8dSZDwiJYQC6f/959ic/" +
       "981P/oXKAQDFS3dr8FaZEgAvQBcCM/+Vr8T/9ut/8IXfv3rmNBkYOPOV52jF" +
       "Qck/Bb8r4Pk/5VMqV344xPxN4hh43n+KPFHZ8gfPZAMY5IGgLD3olhj4oe6Y" +
       "jrryjNJj/9f1DzS+/N8+fePgEx74cuJS3/fWDM6+vxeHfvirH/sfz1Vsrmjl" +
       "GHhmvzOyA7C+84wzliTqrpSj+JHfe/Zv/5b6MwCiASymzt6okA6q7AFVHViv" +
       "bFGrUvhSWbNMnk/PB8LFWDs3V7mtfeb3v/WE9K1//O1K2ouTnfP9zqjRKwdX" +
       "K5P3F4D9ey5H/VBNbUCHvDn9ize8N78DOC4BRw1gXTpLAFwUF7zkmPqhh//d" +
       "P/3n7/747z4AXe1Dj3mhqvfVKuCgR4GnG6kNMKyI/vxHD968fQQkNypVoTuU" +
       "PzjI09W/a0DAl++NNf1yrnIWrk//z5m3+sR//JM7jFChzF2G6Ev1l/AbP/0M" +
       "8f3fqOqfhXtZ+7niTnAG87qzus1f8v/71Rev/eZV6OEldEM7njRKqpeXQbQE" +
       "E6X0ZCYJJpYXyi9Oeg4j/CuncPa+y1BzrtnLQHM2KIB8SV3mH7uELe8orfy9" +
       "4PngMbZ88DK2XIGqzEerKi9U6a0y+d7TUE6rWWnF+OUMemJ1OqbQ/kGYd2VQ" +
       "/S3GJACXwJvKoAP94GUHO9+oarfKBDs4AnpPp3nlVKXygT58rNaJehdVAlLf" +
       "BH54GLSPGODMQIaKwejual4ts2QGDOwEqnei6uMMNZ9jA+o2P+eJE01vVOFQ" +
       "9t7RYcp6SZPx29RkCJ6XjzV5+R6dI95P6jKZnYj8FM7PxtT09oSejm8Ts8mM" +
       "P5H7yUruskcAnoWX7S+9pdRVA5VpH2oedY7q5f+P3V2uB8rsn71TuPe4nnbr" +
       "BO8lsLAB4XrL9TplMXdJoJe/a4EAajx51ieTECwifuw/feZ3/sZLXwehPYIe" +
       "2pRhByL6XMdN83Jd9Vff+Nyz73jtD3+sGriAq0t/7e+1/qTkarw9tZ4p1ZpX" +
       "zjZR04ypxhdDLzW7P6KxieODIXlzvGiAX7359fVP/9EvHxYEl+HrErHxqdf+" +
       "+p8effq1q+eWYS/dsRI6X+ewFKuEfuLYwgn0wv1aqWr0//OXXv31v/vqJw9S" +
       "3by4qKDAmvmX/9X//p2jz//hb99lpvqgF94RH999x2bXf3CIpDR28ps0lkQL" +
       "F6ViXcsRiuuu2wjOhfg6xIRhkluFHo22ozHHDcg9Qw+ZHJ/LectkR5GpbUx9" +
       "1+l5aw6V6wLe4PityosBHw4pLXZwLlY68ixLJTsaLLCZJdcb6w7e6HAhk9KI" +
       "tDbFWtTbd7JWp0np68Kl9mD6n+cmDAdwr7HZdOERquch4g9cPy44a7SWmOkg" +
       "pOo2q4xypO8kE9wd8JEzcZiuSAzhpZGwiSJ0Y3LM7jhtGPYxkczqmeLanj2l" +
       "9DlJ0CHtqihDt3nXRvRBwzL7obMe+1RdEGiUKidz/CSSBjOF2nATw7IlQhFC" +
       "0eVHGq1F1hhr0zq23pHcKNmotZUV26I3lHi/tRtYejuuMdNI3CtqsaYkRW0S" +
       "3SnBUOv1jHfm5HQs1rO+IyylId6cS/iQGOOT1WRc3y4SrJbthjje4lJp2Nt2" +
       "mL47WpB4X8TnEsPOmIW/C7suMQPS9Fk99RFkXmD75oxYj8OC6jMixdKyy9HO" +
       "dmmLWqb627g+6U7HTDaImWBGj1SPo1CPwJlGi+hR1EJ0FCWIlb1D2M7IaTJN" +
       "dat7HVX22x6YZbCTLWIY/jJp62tCwvuD/nIy53siz3FrwkEEPBQsvljFxcxe" +
       "kalAxKJDKqbkLPB+oKqiijYjbNCnqTVt7mS5Zq/FlEHlHtvsaxy/ms4E2hs2" +
       "sqFXeB7pJ4hXyLyFyai5ygJ60qytu4O+lVryCF3QRJdprH2S8sbumGgvQrTu" +
       "cvWVheHKaCduB5IgzOsNDh/ZWEMo+kuKWhLsEkedNcmREW9zgkgsY0ncuY1s" +
       "rtJcl8bcjGB6U7LR7evYdLluWwnNTZnGpHB43Bss22E+p/e1Zt7eNNmxkYos" +
       "PMb3LpXuPAGmfCLuCWQDcV2ZMbbk3nPQ8ZBXfLazY90ewZH7Kdctos2mtsyR" +
       "bhoLrdYs1ts0lk31Ftfprz2KxZXMbE2bao0lcWk+pdf1xgiPul5NSj1YVlbt" +
       "aD5wSKY34amaO7I2wn5h1IaC0N5TGbwLc4yRnDjWBAozJMWLuWi6TsZwn8iU" +
       "vuUzukqOZCVupSZnqDjTtedav5u5qTHdkxGHT9dTTw7TDLZC16FDAoltXx85" +
       "6kZOdyrHmapWt3FiXSPIed4XXNgya7slTXJoTPBbkacGfJ9cKCG6EU2HoR2c" +
       "6be2yCBskw2u3icFI+asdV8abq3xGjPI5rDAdVTZcuFojqW0OSW5KMdWQ1vl" +
       "GTngGwSRW3BB0sPR0pExmCumbA2u536MG77L2l1qTC4XgcMpspGJTdlyFWe4" +
       "dhqZXu8NJ5uhGPY2/R7ew/cq3rcGKa/0wy2DiRmI0Ak2sPjdeN3vbgIF8WbR" +
       "1N3u0UGGETQZ1lO1NjHyVkdNE2skiLyzxETCjgI1EzM93Cp+H+bJQlislnt4" +
       "s/DacCPkSizYjUaEO87Y8aaBaVhd01ytF0v8eDBqTpZBEBNynZjFsTNgsOXK" +
       "ix3H9+Z4azCL6oE6jkjLW0ToCJm1Y2Qvm9KwjaAMO/Vho702a3rLs3ZIu/Tg" +
       "dKNzdapGGgizmCaTUaLbnS7C7O2WEU1Bp6FRX+JdBom5RqO1Eba5ozlgkAo2" +
       "uN02JI3U4GyNDS1nSytUZ7xvJPmQiHbKBEXXGS/j28VUFKx1YcoCko/CGTrz" +
       "J2w62WVhytSDlK7bwnacumDKte51epG+gWd9dz+ayrzqbTNs1PNJri3S23Hc" +
       "XCKSLAVtStEVFO/06i7rtWu1zULbz+uGFTO1poIxurwd9GgysbYaKMvZbNAz" +
       "2IXJrsbiznIJw61jTc8nGgKLcPCwta8JQlc0DIviUTKWbGbQRqVCHDPJpMM3" +
       "sPpcxOajUHP5VHSwabSy1vxAYnrdLjwulNSE+2xtl7Xzgaykq5G3My2iw/rL" +
       "ieGM5o0NLKUbqkbx6lpuwU2Z09qxqaw9M8ldfNwTrZ4hL2ZSAxGCUCawOZ7N" +
       "ybTYNloUTPcVrK9tF7vCRZCZoW9hXlGG9n44bE2DUV2wh8V2InaWZqO1SIJJ" +
       "NpRbixRF9G2kUt2uM7QkZUUgO3ur7skE39QCFeVTbTnWcdu2jbBhBQMaA/3c" +
       "3y/C9mKXL/LtCnfkPjcwXBnRKaLjzR1ZMPLxegG3EJjls1WhWOY+jT1PtBsO" +
       "uiUVzefQpasUuDVFpV7XHuRF3eLJ0YIZ7lySK9bCFIv2addoTVSK70cDfdJt" +
       "IasNW6RgOj8RxBzZDgeLOpZYXGbLS32zgseCVMBozaQ2Q75jm+LIXfnCvjtd" +
       "dMNGPutsgqy1Z52ti2XzLewiXHcoFE29sUrifj5rbRVpN0W5XVxoWMa0OvXl" +
       "bLSBk4QIYIdvs0Tcp+t5LapxYmdu8s2BkI23st8KN/3WpiXV7RUyUOs51m5u" +
       "s9T15V46WC6EheM32Hl7P5qRI2FODZEhy7nMsN+K9nXaVLatZJBGxNRd8Mp6" +
       "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" +
       "AA==");
}
