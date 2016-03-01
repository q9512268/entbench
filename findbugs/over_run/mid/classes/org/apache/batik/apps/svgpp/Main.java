package org.apache.batik.apps.svgpp;
public class Main {
    public static void main(java.lang.String[] args) { new org.apache.batik.apps.svgpp.Main(
                                                         args).
                                                         run(
                                                           ); }
    public static final java.lang.String BUNDLE_CLASSNAME = "org.apache.batik.apps.svgpp.resources.Messages";
    protected static org.apache.batik.i18n.LocalizableSupport localizableSupport =
      new org.apache.batik.i18n.LocalizableSupport(
      BUNDLE_CLASSNAME,
      org.apache.batik.apps.svgpp.Main.class.
        getClassLoader(
          ));
    protected java.lang.String[] arguments;
    protected int index;
    protected java.util.Map handlers = new java.util.HashMap(
      );
    { handlers.put("-doctype", new org.apache.batik.apps.svgpp.Main.DoctypeHandler(
                     ));
      handlers.put("-doc-width", new org.apache.batik.apps.svgpp.Main.DocWidthHandler(
                     ));
      handlers.put("-newline", new org.apache.batik.apps.svgpp.Main.NewlineHandler(
                     ));
      handlers.put("-public-id", new org.apache.batik.apps.svgpp.Main.PublicIdHandler(
                     ));
      handlers.put("-no-format", new org.apache.batik.apps.svgpp.Main.NoFormatHandler(
                     ));
      handlers.put("-system-id", new org.apache.batik.apps.svgpp.Main.SystemIdHandler(
                     ));
      handlers.put("-tab-width", new org.apache.batik.apps.svgpp.Main.TabWidthHandler(
                     ));
      handlers.put("-xml-decl", new org.apache.batik.apps.svgpp.Main.XMLDeclHandler(
                     )); }
    protected org.apache.batik.transcoder.Transcoder
      transcoder =
      new org.apache.batik.transcoder.svg2svg.SVGTranscoder(
      );
    public Main(java.lang.String[] args) {
        super(
          );
        arguments =
          args;
    }
    public void run() { if (arguments.length ==
                              0) { printUsage(
                                     );
                                   return;
                        }
                        try { for (; ; ) {
                                  org.apache.batik.apps.svgpp.Main.OptionHandler oh =
                                    (org.apache.batik.apps.svgpp.Main.OptionHandler)
                                      handlers.
                                      get(
                                        arguments[index]);
                                  if (oh ==
                                        null) {
                                      break;
                                  }
                                  oh.
                                    handleOption(
                                      );
                              }
                              org.apache.batik.transcoder.TranscoderInput in;
                              in = new org.apache.batik.transcoder.TranscoderInput(
                                     new java.io.FileReader(
                                       arguments[index++]));
                              org.apache.batik.transcoder.TranscoderOutput out;
                              if (index <
                                    arguments.
                                      length) {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.FileWriter(
                                        arguments[index]));
                              }
                              else {
                                  out =
                                    new org.apache.batik.transcoder.TranscoderOutput(
                                      new java.io.OutputStreamWriter(
                                        java.lang.System.
                                          out));
                              }
                              transcoder.
                                transcode(
                                  in,
                                  out); }
                        catch (java.lang.Exception e) {
                            e.
                              printStackTrace(
                                );
                            printUsage(
                              );
                        } }
    protected void printUsage() { printHeader(
                                    );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "syntax",
                                              null));
                                  java.lang.System.
                                    out.println(
                                          );
                                  java.lang.System.
                                    out.println(
                                          localizableSupport.
                                            formatMessage(
                                              "options",
                                              null));
                                  java.util.Iterator it =
                                    handlers.
                                    keySet(
                                      ).
                                    iterator(
                                      );
                                  while (it.
                                           hasNext(
                                             )) {
                                      java.lang.String s =
                                        (java.lang.String)
                                          it.
                                          next(
                                            );
                                      java.lang.System.
                                        out.
                                        println(
                                          ((org.apache.batik.apps.svgpp.Main.OptionHandler)
                                             handlers.
                                             get(
                                               s)).
                                            getDescription(
                                              ));
                                  } }
    protected void printHeader() { java.lang.System.
                                     out.
                                     println(
                                       localizableSupport.
                                         formatMessage(
                                           "header",
                                           null));
    }
    protected static interface OptionHandler {
        void handleOption();
        java.lang.String getDescription();
        java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        long jlc$SourceLastModified$jl7 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1aC3AbxRleyW/HtmyHOGlCTB5OpgkgTdoCpQ4Fx3GIUjlx" +
           "4yQMTkFZnVb2Jae7y93KVkIChU5LhhkoA6E8BlzoJLS0vEphYIYhk5YWCM/h" +
           "TcgQ2tIHUNIh7ZTQUqD/v3vSnc6SHLCpZ/TrtPvvv/9++792z3ceIVW2ReaZ" +
           "VE/SMN9mMjvch8991LJZslujtr0OWuPKFX+49pJjL9ZdGiTVA6RpiNq9CrXZ" +
           "CpVpSXuAzFZ1m1NdYfZqxpI4os9iNrOGKVcNfYBMU+1o2tRUReW9RpIhwwZq" +
           "xUgL5dxSExnOoo4ATk6KCW0iQptIl5+hM0YaFMPc5g6YWTCg29OHvGl3PpuT" +
           "5thmOkwjGa5qkZhq886sRU42DW3boGbwMMvy8GbtNAeIVbHTxsAw797QBx9d" +
           "PdQsYJhKdd3gYon2WmYb2jBLxkjIbe3RWNreSi4mFTEyxcPMSUcsN2kEJo3A" +
           "pLn1ulygfSPTM+luQyyH5yRVmwoqxMncQiEmtWjaEdMndAYJtdxZuxgMq52T" +
           "X21uu31LvO7kyO7rL2y+r4KEBkhI1ftRHQWU4DDJAADK0glm2V3JJEsOkBYd" +
           "NryfWSrV1O3Obrfa6qBOeQZMIAcLNmZMZok5XaxgJ2FtVkbhhpVfXkoYlfOr" +
           "KqXRQVhrm7tWucIV2A4LrFdBMStFwfacIZVbVD0p7KhwRH6NHd8CBhhak2Z8" +
           "yMhPValTaCCt0kQ0qg9G+sH49EFgrTLABC1hayWEItYmVbbQQRbnZIafr092" +
           "AVedAAKHcDLNzyYkwS7N9O2SZ3+OrF561UX6Sj1IAqBzkika6j8FBrX7Bq1l" +
           "KWYx8AM5sGFx7Ee07ZFdQUKAeZqPWfI8uOPoOae0739C8swqwrMmsZkpPK7s" +
           "STQ9f2L3ojMrUI1a07BV3PyClQsv63N6OrMmRJq2vETsDOc696997Pzv/pz9" +
           "LUjqo6RaMbRMGuyoRTHSpqox61ymM4tyloySOqYnu0V/lNTAc0zVmWxdk0rZ" +
           "jEdJpSaaqg3xGyBKgQiEqB6eVT1l5J5NyofEc9YkhDTBh1TB53Yi/25GwgmN" +
           "DBlpFqEK1VXdiPRZBq4fN1TEHGbDcxJ6TSOSAPvfcuqS8BkR28hYYJARwxqM" +
           "ULCKISY74YdpR+zhQdOM9FJVD6Opmf+PSbK40qkjgQBswon+EKCB96w0tCSz" +
           "4sruzLKeo3fHn5LmhS7hYMRJGGYKy5nCYqYwzhQWM4Vxpo41Ju7mStAado0E" +
           "AmK6E3B+ud+wW1vA7yHwNizqv2DVpl3zKsDQzJFKxDorHHFW7gcM9OkpXP6s" +
           "fvOW155956tBEnSjQ8gT1vsZ7/RYJMpsFbbX4uqxzmIM+N64oe/a645cvlEo" +
           "ARzzi03YgbQbLBHCK4Sp7z+x9eCbh/e8FMwrXslJnWkZHHaMQdyppQkIaVTh" +
           "nFTbInZCfz5IyUWe8Cn8BeDzCX5wvdggDa6127H6OXmzB5R90MwuFR9EbNtz" +
           "2e7R5Jq9S6QXtxb6XA+klLte+fjp8A2/P1Bkk6ud+O5OOAXmmzumQugVsTOX" +
           "aePKGS8cqzh0zYwGsS8NCSgO3AzdUZChZYFhGQpLQooolatz+Wpx6ezsV+Hx" +
           "y96due6bQ5uECt58i7KqIFXgyD7MknnpJ/lw9Iu8o/fOA+cuVK4JigSBwbZI" +
           "Yikc1OlFFCa1GGRCHZeFLY1ZLLd8/ufHIq4snkMfiD+ysyNIKiFjQJbk4F6Y" +
           "gNr9kxcE+c6cS+BUtQBCyrDSVMOuXJar50OWMeK2iMDQIq0SNrsWLWwWfG51" +
           "wqD4xt42E+l0GUgEf7ugc5F0CEsJgvmYmQTUedi2ULAuAutZ6HoexG4NHAV3" +
           "pWO9DhuuplSa0BjGhP+GFix54L2rmqVVatCS26ZTxhfgtn9pGfnuUxceaxdi" +
           "AgrWDm50cNlkQprqSu6yLLoN9che+sLsGx+nt0Bqg3Riq9uZyBDEcT9UaplY" +
           "+lmCdvn6liP5OicNQyIOypgIUy0qU2daahqi1bCTqSM7W9/ccvPbd0n/9ad1" +
           "HzPbtfuKT8NX7Zaoydpn/pjywztG1j9C12axRVnh4WVmESNW/PWenQ//bOfl" +
           "QWedp3JSOWyoSRjcUWJpnmo2rlz90vuNG97fd1QoWlgOe+N3LzWlbi1IzkTd" +
           "pvszyEpqDwHf1/av/k6ztv8jkDgAEhXIhvYaC9JYtiDaO9xVNa//+tG2Tc9X" +
           "kOAKUq8ZNLmCYuEJ5QP4BLOHIANmzbPPkXY/gp7QLDaVjNlmtJyTittkT9rk" +
           "woq2PzT9/qU/HT0sEoWQsCTvZSGUMhs+ex0v2/tZvAwfl3o9rLQtbizTdwGS" +
           "DZw0DTK+nNmKpZr5aDkDjkpifVgGh2UZLDp6kZwns1jf8WGFDeu9AIhcVzz5" +
           "tbm1tyw0w+KsY5rlAKlwAYEABCcPsNpxkdlSpk/mhyVInIRdiIdUrZwyHOKw" +
           "qlNRmqtSFySbkYhGqJRrAXeRt4vm1/4MlBGesv+892/L/r1x1kIZE8pkRf/A" +
           "K9XRZ578V+hSObAwCIkjozPUP+7gaxVfmcI7fiiyaSUmdHHOgAxjIycnc0of" +
           "P4Us6cVN4+75NHfPxfT5Lc8hH3KRFwzYvANAm1EctLjynnbg2Pc2H9oglzx3" +
           "HKziSjQd73/g4OWni8gUGlahcpS3GPLSoK3g0iBXwXYWHKaLohlX3r7nyifm" +
           "vrthqjglSeBQ+9VORPi240EB4UFBfMLIMmZdji4i0cWVl3ckPrh+YOQSubwF" +
           "JZZXOGbHzZ88887OwwcqSDXUAFjIUAvOU2CG4VJXEV4BHevgaTmMggqjSY6G" +
           "iJDfDbCK1nxrvpzh5NRSskXOG1sBQlQeYdYyI6MnUewZvlIqY5reXmFfoc9v" +
           "XxdDYXEc4OXX7sRq0ipwb3KtEktqbyeU0VO7Y139/fF15/f1xDd0rY12LYv1" +
           "CLs1oTOwrmRQwXRXakfPU7VkN7WS0j/3flo3/5zpB74h/HMscJMNlgjjRtZ3" +
           "SMunBDZeSigeaW+S2QGJcIxtSK5HcqM3b8gZji8FeEJumYl/XKbvNv+kxniJ" +
           "2BPiR5HciuQnEOKHoPTohlONGLrCKbbwaxUnFapzpzcRAO90AdyL5HYkdyD5" +
           "xWcCcLyiIiC4AtIIkP6yjFK/Ok4AhbilLnb3IrkPyf2QyNnWDNXsYsjVJAxD" +
           "Y1SfMHr7XPQeRPIQkoeRPDKp6HnnfLRM3+8+J3C/QfJbJI+B0XHDU7CVr+Q+" +
           "J27PubgdQPIkkqeRPPvFuu1LZfpeOU7w3Eltn+++iORlJK9iIWlwNSUCUnTC" +
           "gB12AXtdSERyCMkbXyxgb5Xp+/OEAfsjkj8h+QsndRKwLk2bHMyOuJi9k8fs" +
           "XSTvTT5mTnwrFm0qNUMfFIP+UWYQ+Fm762dRvO+zMibUkT1ZhYmDlRBxbMKY" +
           "H0XyAZL/gG4jVOWTAncg4ML9cR7uT7CHTGosDLpc/0Ryu5i9unS++VAw1H7m" +
           "pGznMQtUIalBUueub8KIhYogFmhA0vRFZY/ACePh1DYRnKYimYZk+iTiNLsY" +
           "TjORnCh7spw0Frw6yHnUnPHeOIhToP+FpnwJp9w9GqqdPrr+VXGHmn9R1hAj" +
           "tamMpnnOFd4zRrVpsZT0tgZ5CyWuHgLzOJlVRhk474tvVDwwVw5ZANV00SHg" +
           "tvjl5f0yZGk/L8gU316+kzmpd/kgSckHL0sYKktgwccI1O0yOo0t2KeNt5ee" +
           "tw3zSx5zezPyTXNcuWd01eqLjp6+V76XgVPD9u0oBU6GNfISWgitGHMe90rL" +
           "yapeueijpnvrFuRuGlukwq4LzfKkifVg/iZeyM30XeXaHfkb3YN7lu57Zlf1" +
           "C3DA30gCFI5nG2P+m6bOrJmBs/fGmPf07flvBXEW7Kx/a9NzH74eaBW3ekSe" +
           "19vLjYgr1+471JcyzZuCpC5KqlQ9ybIDpF61l2/T1zJl2IqS2oyubs2waBLs" +
           "L4EnNolVqaN2Y8FRm5N5Y297xz1aN5Y9WuNbirZiq4K9WXLLvy/5wWtrwKsK" +
           "FPdKq7EzifwLD+8bbykbqXPxjLsI9hqP9ZqmcwgNiHPyetPE2BDoEqZ9tuRG" +
           "Djg9LzbN/wE2dv8YuSIAAA==");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1445630120000L;
        java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "LsoRZSny5eN53/ok/4nrv/L8tTPIud3sOKTw+Klc832K41vgVRuSOqiqXQo1" +
           "34mPn+wmnoFYoeqRN4LvPz4ou2S/sPchF8LXJ8fGc4NVnDkyQ+ZA7z7yPcc5" +
           "z4ZjmsBgoNSvzcBpFKYIecGUYf3h/155FvvEn37g6jaBZoInh2p4250JHD//" +
           "G3XkBz/77r94IiOzJ8I65XEW9xhtW/x66Jgy4ft8CvlIfug/Pv4zn+J/9iyy" +
           "RyLnAn0jZ9Uo5MB2IVNb6QoZVE716RC8O0Tu17Kay7b+kmF+385Oa4TIubWj" +
           "S8db8PqdEoK7E2UPuCOVXYEPHwfflw9U9vJdqezWi1vfpi8DXohcVuWwKQei" +
           "r7uHJYT88TL973aZWQXk5iWRR06XZfazcrzr3m7Zxw6TAc7F5mG2947r//u3" +
           "6fuRLbcQvDe5SW1iy9qdmNmH4H1bRiD4exD8MATvB04WiDZzlLf3fOCsHYQ7" +
           "9ekf01/67d/8xpUf2uauT2bisysKB0NPj/vC588W7guv/XjmMc8JfJD5qIvA" +
           "wwQQM0SevPV1h4zWNs1+3x0V+PCxArPpj/R3KMYrx2LMEODjnziRt7+5EK6L" +
           "pHWd+cQX3l/J3MGVtR7oIFxND25gnHQOx6XQ507cyripmK6LX/n4j336qT+Z" +
           "P5SV27cSgWwVgWOBv5UDC9/LLPwMbAGGn70FwwccZb7suvgDH/7Wb//x81/8" +
           "zFnkAnDXMK7wvgxCSIjs3+qWyi6Ba1PQaoJRINhc3o7WbfVIcECBDx49PYou" +
           "IfL2W9HOajSnghC852E6sezXnciWDiLPicgWue5ub2YK93/3pvBeEAdehfCO" +
           "1n7gCZEHM6PfKY3BYs1upxsiDzUogmGuT9lR6/qcmJBEnWplJuaCzr0pbL6Q" +
           "3EZ7C92UGrwvbbfNy9++95l3PfqZv5VtmxuF9F0K5tFjQz2oHB6Jxt0yuFut" +
           "P/CdhR1vdGuXe3N/9jEI/iEEH4TgoxC8suvjXp1z3fFnt5nsF27T94unJ33h" +
           "ToFsx3/+Cwj+JQSfAP5TA5JrOJJ8s3h8Vj+40HU3Qvu3EPwSBL8Mwb+B4Fdf" +
           "pdDuFIj3Mqy9rbIh/Pe3YeQ3XqXQMnJvO5bXr0Hw6xB8CoRF2Yt4M7iZtO4R" +
           "HMeUefuuJfY5CH4Tgs9C8DsQ/IfXSGK78/zebfo+/10K6z9B8PsQfAEYV+gc" +
           "Xz/I37VcvgzBf8loQfAHEHzpr2v7/bfb9P3RqxTOrc8wfwjBf4fgK/Co5YS6" +
           "ksJ/xl0L6X9C8NWMFgR/CsH/+OsS0v++Td+f37WQ/hcE34DgL8Db81ZIhGm+" +
           "NnL6FgR/eSSnb0LwV6+lnHZ8Ux0i7J29OcLhge6J43hMwkSBH7ngXNZKRDl7" +
           "achInL9bme5B/7B3DoKL4H0r5vXwNRHn3hUI7jsU5979EFx+jXzWmWOsOgS/" +
           "nM34+lvKe+9ChvDIdxwk94/l9BAED0Pw");
        java.lang.String jlc$ClassType$jl5$1 =
          ("6PHK7lpKj5+U0mMQvOm19+x7t7bFA9lcuxvZPAXBMxA8+xrKJndSNpCJvbcm" +
           "IfK6E/c1D3fLk3e65gnOpm+44Rb59uaz+HMvXbn46Euz38+SRUe3k++lkItK" +
           "ZJq7VxF32hdcX1b0TAr3bvND2cv0Xj5E3ngbZkLwIgR/IeN76HZIERzqbzoE" +
           "bEn4s4tbAW/Mp3EBzex3Fw8PkUvHeCCobBu7KO8AJzqAApvvhBckM1neeDh+" +
           "8E7628lZPnPLV8JBtL3ef138+Eu94fd/vfLy9oYlOKFvNpAKeOe6Z5uJy4jC" +
           "rNZTt6R2SOtC9y3fvPzz9z57mAW9vGX4eNvs8Pbmm+fIWpYbZlmtzS89+ovv" +
           "+KcvfTG75ff/AJ8SNj51MQAA");
    }
    protected class DoctypeHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("remove", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_REMOVE);
          values.put("change", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                 VALUE_DOCTYPE_CHANGE);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCTYPE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doctype.description",
                null);
        }
        public DoctypeHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO9vnD/xNbFw+jTlo+chdKQTUmqaAwdjkjK+2" +
           "g1qT5Njbm7MX7+0uu3P2YUITkFLcqKVRIClJA6oS8lHqhKQqaksFdVW1SURT" +
           "BI3aJLQJDX8kKUEKfyROS9v0zczu7cedD0WqYmnn1jNv3sy893u/92bHr6IS" +
           "Q0ctmqAkhBDZpWEjFKXvUUE3cKJNFgyjD3pj4v1/P3jP5J/K9/pRoB9VDwpG" +
           "lygYuF3CcsLoR3MkxSCCImJjC8YJOiOqYwPrwwKRVKUfNUhGZ0qTJVEiXWoC" +
           "U4Gtgh5BdQIhuhRPE9xpKiBoXoTtJsx2E17nFWiNoEpR1XbZE2a6JrQ5xqhs" +
           "yl7PIKg2skMYFsJpIsnhiGSQ1oyOlmqqvGtAVkkIZ0hoh3yLaYjNkVtyzNDy" +
           "fM1H1x8YrGVmmC4oikrYEY0ebKjyME5EUI3du1HGKWMn+hYqiqBpDmGCghFr" +
           "0TAsGoZFrfPaUrD7KqykU20qOw6xNAU0kW6IoPluJZqgCylTTZTtGTSUEfPs" +
           "bDKctjl7WsvdniM+tDR86Ad31f60CNX0oxpJ6aXbEWETBBbpB4PiVBzrxrpE" +
           "Aif6UZ0CDu/FuiTI0qjp7XpDGlAEkgYIWGahnWkN62xN21bgSTibnhaJqmeP" +
           "l2SgMv8rScrCAJy10T4rP2E77YcDVkiwMT0pAPbMKcVDkpJgOHLPyJ4xeBsI" +
           "wNTSFCaDanapYkWADlTPISILykC4F8CnDIBoiQoQ1BnWplBKba0J4pAwgGME" +
           "NXnlonwIpMqZIegUghq8YkwTeGmmx0sO/1zdsubAbqVD8SMf7DmBRZnufxpM" +
           "muuZ1IOTWMcQB3xi5ZLIw0Lj6TE/QiDc4BHmMj+/+9raZXMnXuIys/LIdMd3" +
           "YJHExGPx6vOz2xZ/uYhuo0xTDYk633VyFmVRc6Q1owHTNGY10sGQNTjR8/tv" +
           "3nscX/Gjik4UEFU5nQIc1YlqSpNkrG/CCtYFghOdqBwriTY23olK4T0iKZj3" +
           "dieTBiadqFhmXQGV/Q8mSoIKaqIKeJeUpGq9awIZZO8ZDSFUDQ9qhecniP+x" +
           "X4KE8KCawmFBFBRJUcNRXaXnpw5lnIMNeE/AqKaG44D/oZuXh1aHDTWtAyDD" +
           "qj4QFgAVg5gPwj+aETaGBzQt3CVISohCTfssFsnQk04f8fnACbO9FCBD9HSo" +
           "cgLrMfFQev3Ga8/FznJ40ZAwbUQQXSnEVwqxlUJ0pRBbKURXCm5QRaqyA7YN" +
           "bkM+H1vvJroB7nBw1xAEPjBv5eLeOzdvH2spAqRpI8Vgayq6KCcTtdkMYdF6" +
           "TBw/3zN57pWK437kBxKJQyay00HQlQ54NtNVESeAj6ZKDBY5hqdOBXn3gSYO" +
           "j+zdes8X2T6cDE8VlgA50elRysvZJYLeyM6nt2b/ux+deHiPase4K2VYmS5n" +
           "JqWOFq93vYePiUuahZOx03uCflQMfAQcTMB5lN7metdwUUirRcf0LGVw4KSq" +
           "pwSZDlkcWkEGdXXE7mGwq6NNA0cghYNng4zJv9qrHXntj++tYJa0SL/Gka17" +
           "MWl1EA1VVs8opc5GV5+OMcj97XD04ENX929j0AKJBfkWDNK2DQgGvAMWvO+l" +
           "na+/9eaxV/02HAkq13SVQCDiRIYd56ZP4M8Hz3/pQ/mBdnCeqG8zyao5y1Ya" +
           "XXyRvT3gLRm0UXwEb1cAf1JSEuIypuHw75qFy0++f6CWe1yGHgswy26swO7/" +
           "3Hp079m7JucyNT6R5k3bhLYYJ+PptuZ1ui7sovvI7L0w55EXhSNA60ClhjSK" +
           "GTsiZhLEfLiS2SLM2hWesVW0CRpOmLsjyVHfxMQHXv2gausHZ66x3boLJKfr" +
           "uwStlQOJewEWW4PMxsXWdLRRo+2MDOxhhpd3OgRjEJStnNhyR608cR2W7Ydl" +
           "RSBRo1sH9su40GRKl5S+8ZvfNm4/X4T87ahCVoVEu8BiDpUD2LExCMSZ0b62" +
           "lu9jpAyaWmYPlGMhavR5+d25MaUR5oDRX8z42Zqnj77JgMhhNytLj8059Mgq" +
           "cDuy37/4w8u/nnyilOfvxVPTmWde07+65fi+tz/O8QQjsjy1hWd+f3j8sZlt" +
           "t15h821GobMXZHIzDnCuPfdLx1Mf+lsCv/Oj0n5UK5rV7lZBTtNg7ocKz7BK" +
           "YKiIXePuao2XJq1ZxpztZTPHsl4uszMdvFNp+l7lQV0T9eJKeMZN1I17UedD" +
           "7KWDTVnI2i/QZilzoZ++LiOwsqQIciarl2IGzSigl6DAMD2vQQHkxAC9TfWm" +
           "4wbpEUZYjRgTv9ty397Pl15bxSHQnFfaUU6umFxV03z8GYWLB/MrdxeSb+8+" +
           "+7j61yt+q0jMN4VL3mZ0nTvV8U6MsXoZzdN9lmkdGXidPuDIFrVZs7CSrA6e" +
           "S6ZZLnGq3fH/rZYUCW5NUgoK/XCflMIJemvDCrFqs89wNUpas3JC3HbtyVNP" +
           "rR5b9o3HueHnTxHdtvwvv37p/JHRE+M8qVDzE7R0qptn7nWXVhMLC1RENog+" +
           "3PSVifcub73Tb6aBatr0cYA3EVRlcx4QKu28I8uNviy5NXqBxHUHlh/55z3f" +
           "fq0bipVOVJZWpJ1p3JlwR2ypkY47kGVfseworqXNzRmasAnyLdE0sx6h7Wra" +
           "dPLttuZj8kz+ePaxeLbjmLF8VYGs5KJz0zihG1bV3RqlYrOophiZM9XtkN1s" +
           "j+07dDTR/eRyjpJ6941ro5JOPfvn//whdPjSy3lK/IB5u7f36Tco0ryY7GI3" +
           "Z5vDV1+YLLr4YFNlbkFONc2dotxeMjW4vAu8uO8fM/tuHdz+KSrteR4reVX+" +
           "uGv85U2LxAf97PLPU0bORwP3pFY37Cp0TNK64gZaSxYONdT7LfC8YMLhBW+6" +
           "sCGYiy1whpaOy5LoyRPVBRQWqMxGC4zdTRsouioHGcY43oyC9UNUBw4j0rAZ" +
           "pOE99W8NPfbusxxz3mLBI4zHDt3/SejAIY4//rVmQc4HE+cc/sXGGceGk//y" +
           "rMJmtL9zYs+vntmz36KlIYKKh1UpYQc9KRD0ueUb7VjLutWsTxrpUBCe06ZP" +
           "ThdwMm2Gc9051dQCLvtegbHv02aMoOoBTDZgQ9QlLRsqQDi1jI1pxRTi37ds" +
           "c3zn05sjA+u4r/3WOs03IjbwYVPO10j+BU187mhN2Yyjt/+FXVGzX7kqoYpI" +
           "pmXZWaw53gOajpMSs0ElL904yz9K0KwCm4GCjP2yjT/CpxwhqCHvFIAQ/XHK" +
           "/ghs6pUFnezXKfcEQRW2HMQ3f3GKPEVQEYjQ16e1PA7jJW7G5yBoMzkx/zXc" +
           "yH/ZKc5bMQ1u9vHYIsp01CwgThzdvGX3tVVP8lu5KAujo1TLNMi4/O6fJdv5" +
           "U2qzdAU6Fl+vfr58oRWMrq8Czr0xWAEBsuvzTM8d1Qhmr6qvH1tz5pWxwAWg" +
           "kW3IJxA0fVvuZSCjpSETbIvkqy0gFbHrc2vF5e3nPn7DV8/uXGY1MrfQjJh4" +
           "8MzFaFLTHvWj8k5UAlyDM+ymsmGX0oPFYd1VqgTialrJfmeupmgWaOAxy5gG" +
           "rcr20g82BLXkEmLuRyy4jo5gfT3VbpY+rvSU1jTnKLNsjPMnr6SLYpEuTTM/" +
           "YvjameU1jQX2Kdps/x/+gRDSIRoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aeezkVn33/rK7SZZkdxNISAM5WShh6M/2eM4utJnD45mx" +
           "PYfH4xm7hcXjY2yP72vsgZRDLaAiBVQSSiUSqVIQLQQCVVFbValSVS0gUCUq" +
           "1EsqoLZSoRSJ/AGtSlv67Pnde6RRq/4kv3l+7/ve+54ff997v2e/D50JfKjg" +
           "Oma6NJ1wV0nCXcMs74apqwS7fao8Ev1AkVumGAQsaLsiPfz5Cz/68Ue0izvQ" +
           "WQF6pWjbTiiGumMHjBI4ZqzIFHThsBU3FSsIoYuUIcYiHIW6CVN6EF6moFcc" +
           "GRpCl6h9FmDAAgxYgHMW4MYhFRh0u2JHVisbIdph4EG/BJ2ioLOulLEXQg8d" +
           "n8QVfdHam2aUSwBmuCV754BQ+eDEhx48kH0r81UCP1mAn/j1t1/8nZugCwJ0" +
           "QbcnGTsSYCIEiwjQbZZiLRQ/aMiyIgvQHbaiyBPF10VT3+R8C9Cdgb60xTDy" +
           "lQMlZY2Rq/j5moeau03KZPMjKXT8A/FUXTHl/bczqikugax3H8q6lbCTtQMB" +
           "z+mAMV8VJWV/yOmVbssh9MDJEQcyXiIBARh6s6WEmnOw1GlbBA3QnVvbmaK9" +
           "hCehr9tLQHrGicAqIXTvdSfNdO2K0kpcKldC6J6TdKNtF6C6NVdENiSE7jpJ" +
           "ls8ErHTvCSsdsc/3B295/J12197JeZYVycz4vwUMuv/EIEZRFV+xJWU78LY3" +
           "UR8T737+gzsQBIjvOkG8pfm9d7346Jvvf+HLW5rXXINmuDAUKbwiPbM4//XX" +
           "th6p35SxcYvrBHpm/GOS5+4/2uu5nLgg8u4+mDHr3N3vfIH5M/49n1a+twOd" +
           "60FnJceMLOBHd0iO5eqm4hOKrfhiqMg96FbFllt5fw+6GdQp3Va2rUNVDZSw" +
           "B50286azTv4OVKSCKTIV3Qzquq06+3VXDLW8nrgQBJ0HD3QZPJ+Btn/5bwiJ" +
           "sOZYCixKoq3bDjzynUz+zKC2LMKhEoC6DHpdB14A/1/9DLpbhQMn8oFDwo6/" +
           "hEXgFZqy7QQvbgAH8dJ1YVrU7d3M1dz/j0WSTNKL61OngBFeexICTBA9XceU" +
           "Ff+K9ETUxF/83JWv7hyExJ6OQihbaXe70m6+0m620m6+0m620qW2I2VTdgHb" +
           "wGzQqVP5eq/KGNgaHJhrBQIfQOJtj0ze1n/HBx++CXiauz4NdJ2RwtdH5tYh" +
           "VPRyQJSAv0IvfHz9Xu7dyA60cxxiM6ZB07ls+CgDxgMAvHQytK4174UPfOdH" +
           "z33sMecwyI5h9l7sXz0yi92HT6rXdyRFBmh4OP2bHhS/eOX5xy7tQKcBIAAQ" +
           "DIH2Mny5/+Qax2L48j4eZrKcAQKrjm+JZta1D2LnQs131octud3P5/U7gI7f" +
           "Au0Vx7w8632lm5Wv2vpJZrQTUuR4+9aJ+9Rf//l3sVzd+9B84cjHbqKEl4/A" +
           "QTbZhTzw7zj0AdZXFED3dx8fffTJ73/gF3IHABSvu9aCl7KyBWAAmBCo+Ve+" +
           "7P3Nt775zDd2Dp0mBN/DaGHqUrIV8ifg7xR4/it7MuGyhm0o39naw5MHDwDF" +
           "zVZ+wyFvAFpMEHmZB12a2pYj66ouLkwl89j/uPB69Iv/8vjFrU+YoGXfpd78" +
           "0hMctv9UE3rPV9/+r/fn05ySsk/bof4OybZ4+crDmRu+L6YZH8l7/+K+3/iS" +
           "+BRAXoB2gb5RcgCDcn1AuQGRXBeFvIRP9BWz4oHgaCAcj7UjKcgV6SPf+MHt" +
           "3A/+6MWc2+M5zFG706J7eetqWfFgAqZ/9cmo74qBBuhKLwx+8aL5wo/BjAKY" +
           "UQIQFgx9gD3JMS/Zoz5z89/+8Z/c/Y6v3wTtdKBzpiPKHTEPOOhW4OlKoAHY" +
           "Styff3TrzetbQHExFxW6Svitg9yTv50GDD5yfazpZCnIYbje8+9Dc/G+v/+3" +
           "q5SQo8w1vrwnxgvws5+4t/Vz38vHH4Z7Nvr+5Go8Buna4djip60f7jx89k93" +
           "oJsF6KK0lwtyohllQSSA/CfYTxBBvnis/3gus/1wXz6As9eehJojy54EmsPv" +
           "AKhn1Fn93AlsuSfTcgk8z+5hy7MnseUUlFcezYc8lJeXsuKnc5vshNCtru+E" +
           "gEsF5G9nVN0WzXyNR0CQx5lEATDbQ9cxGyOu8yzpivQH429//anNc89uA3Uh" +
           "gjQAKlwv4b46588w/PU3+A4dpmI/JH72he/+A/e2nb3QesVxXbzmRrrISe8K" +
           "odsPXR64e9ZIbSE4K7GsaGxpK9d18su5jpJTAAvPFHeru0j2Prq2km/Kqm8E" +
           "+gzytD57w/d1/GrDlC7tYyQHcnzg4pcMs7rP6sWc1cyZdreJ8QlGH/kfMwrM" +
           "eP5wMsoBOfaH/vEjX/vw674FbNaHzuTGBmY4suIgyrYd73/2yfte8cS3P5R/" +
           "AAD6jz6GX3w0m1W4kbhZwR4T9d5M1EmeQFFiENI5TityLu0NkWHk6xb4tMV7" +
           "OTX82J3fWn3iO5/d5ssnYeAEsfLBJ371J7uPP7FzZJfyuqs2CkfHbHcqOdO3" +
           "72n4aABcY5V8ROefnnvsD3/rsQ9subrzeM6Ngy3lZ//yP7+2+/Fvf+UaSd5p" +
           "0/lfGDY8j3RLQa+x/0ehvDpbT5Nkpg7rsd2Gk8Gisy4YrOkUJE0mx+zU8sTG" +
           "WjZWBlkoLlGPLQ+MhVWl59UCEkXYqMhPe+yqQ0keyTG9ltlvVJxJzex6Gjn2" +
           "xFXQkbkZOpkybLOHiX1q3G/PaytyipNqygwn9RjZSJuoChKwNjLzeMu2UWMQ" +
           "Y0Faq2MRXC8uun6lNxkjUmh5jZXWbAvuDDc65DyeTnFMIvuDzjI12phrlGIU" +
           "HmHGqNyHyTrsMk6zzrXXLgF0y0cdrCUFlMNg9CqZtFo9q2+0anx/qA89fj3y" +
           "12uS4cipOphqhIB4bJ/D9fnMaU1LRLjUyk153NMijRnh9cQl9aYzd9iwHyRF" +
           "HK3anZk+cHCXQecLAS+Klb4/LieeFqRmddQjl8VgRfOdoO/2AlvTickYddKh" +
           "aXleTIQNbrXqCYjmaFhKibwxWHFhuhm0U5VGu2hS432Cs6xWydFXPo/ziLIg" +
           "jZTGy/i0h8kR2iXIGW0XNN7TvabbtojWUuv4CNsICEfo+OpInPrtKumlq2kR" +
           "8YbrSjJoTJHVrNJzRmbUF7xlKzVZVmBDgp1McXUULNqkFIIYmwWxbOt0IWwz" +
           "tUpDxlC1grQGc8RJ3H5FnC/wGc42mwu3WRrpXHMDUgMXb+hqZSogrXYEdyKd" +
           "7SGe4VbnbpswG/hqyfdmhKjZs9WgUkwGRXSxnLD6wtbEvmcpI7M4WdJxzZ9I" +
           "fqvRT1GELfmjIl6t8lKbW+lrmkXcxmhBkxLXXrn95bBLjdJ+KVGaQW89YCed" +
           "ltgWbdHlV7NG22RHvUmPSletUqfWstu9pqOPnTHatGeu2SQXItIvuY31kqDx" +
           "wdwG4bTuubQn9JTldKl5NX61ZhXCshIkGMLoRg6iRWPhce3ahFarbavJCHak" +
           "Ji5tRZGA9obsjJbGTSzRywLVWyOUUWFxeKy3pVKza9FGAS7UfVGY0/Y86qUB" +
           "TPVkWsb4fhdPiFFSiYebYiLAEa9FDpKwbX5VwTAu7VgcI1WAq6y77IDgUSQg" +
           "xgPWYGpwGGN2IM1hwtBXpSnemZbtcU9CedObuIOVT8CtVsh3ltpQ9pprX2f5" +
           "IuaYZIlFdFIwMFlX2KYuyl5Hs+ZjgoPHNWvi9EjR65FKX5m6hFcX1z1BGNaE" +
           "9qQzbY/rnqZItj4qJPMSidfIlri2Os1Ok+lPpQEzF+e2uy6bdo8eKDjc8EiR" +
           "KJXasCNEcw0Vu212FjbSdtszSuPOssEty8vR2iiIOCsSzc04xFpcb+JoLVYN" +
           "gk5gj1dISa2pdqO1GNY7rWa73p040pLyabUzVmKMEGtwZ2P3S4jQWC+m4/F8" +
           "YuPc2kvMaR9xmeaCnDLzllUeM6KXNqr8YLGiC100jvu+06zazTWaNPCR0YzL" +
           "CqUMN3LcLQZuw2PcXo1biqlXIVsSG8ogYOVOhW2uYWwzKFfdGVnCqqtmQvbH" +
           "qZgiSHdsjsulQTjg8InSMCoC2W7yZc2Th825jS0n/NAobGQlqM2LbEVq4zXO" +
           "XDbKiGIyaRALfZ5SUrpih8UFHCUFWenqI5AClcgix1uTst33ZsOOV8diXhnp" +
           "00jUhGGCYFFLNce02hhLLN0sm4OqpYTyejrVfUZSEYrg1iVy4rnridA2V9Js" +
           "hRPyfI5XLWLtVQaDBiItNX5gL0ubflz3/O7cDo1CIeT7IjKhYGIlolV6ZqJ4" +
           "A+W4oOa4UpngyoUhLRn16ryNlECk1It1A2mQ/aa6mrUHZLE9XhJxg57Fw4Jp" +
           "iwW4rogJByPFbmPlodiEG7faOtPj5XJFGJXoWneDwe4Ytpqy3VI8orZJRaec" +
           "orw4n6dMzGJLirGQ6XyNL1CpoaL9CQ7ixY2662rZ66RIoaBWWjMFTYnuMlin" +
           "xUqwHlZhrOsi1bpV7UdSOmArTHmFLTSK5/uFkRuC8Iz0auDEca9KIetyGZ9r" +
           "k0EDIJmpGROSYANd0ChcpfRJcULRRW2mBNwMaTHu0KICI+W6akKPu/O4uBSj" +
           "oCtUKgm2cKg+qfrRehKa42FfWeOzWWlEJ8F8JlMM4xSKdHuYaJorY8MlY+D9" +
           "SWgPtJSpIDWJKc6qvGwykybjoEG3HkQlhGBIszwp1IRYHVgleF5ia1VRa3EO" +
           "h0e1pt52p+0ihScteiIgi0rRjOqG20jFmcWPTILWxJgpF+RimRanTNlpM/Pa" +
           "plQUPNuoVvtLWtMGaUgZNaRcp5ee1I5SrAqX1rUItu1UN4dqnHAj1prJClIt" +
           "VMqqXgg38LA2HhtAelSbyQUVM2qBYIYhWtZqRZRwFvRc6PY2bbsVjVSZSlBa" +
           "LZhBK4aHBmKXp2TZ56qm0GTDwbLqSOSm2iR5Uu/NlVEkOsV530OFxN2EAjvq" +
           "BmYpCja0HHcGbsGsmmMOYetKn1RoYYD20OoUpARVctZmObtX1OGxoJsbRygU" +
           "KH24DjwAerrom8UesZnoS7PSbtDtYjwed1dJo1Vn1ZlVWi9cfCrwBrNk43qY" +
           "YvXqyETLi2TSHdsdVZxOK5HVSTgE29QIfkY1YdqXE2WyKNQKhapRQdOw4CEG" +
           "PShxFGYJiM3GXG1aoYO5I2zkQd20VjIx1+VR1O51fE4Iqq2J36gok4ogUDbh" +
           "YWoX9gV+2pqVB9OlQ8JzEMJ0r69Ycbvld7ygVl8Ppq4YYP0W1l2EKTcY+Ux5" +
           "UXewbqR0bTbpymG8jmOs6sL9LoMX6Br4DG3wKoN4bmhX7dmc02iqhTL4wFkW" +
           "sNGE01UpWlQxdlERm2LoIxLfwHCOMaWkNCajYq1XiwaxnpYHc6+ZdKddU4PL" +
           "5Q2mqh6y0F1uyPWFmdtHXaxvrpli6q74UnVFcGqgrB3fmw82jCUGDTulZBwJ" +
           "kopWnfmiPKJCEGtGbbUpKCMxUaiFYVGdGscTQZnsb5CNrhHogsMYz+T9oeNq" +
           "ukDX5+FqgAZGAanKbZaBFSY1QGpRL6G+U+4PR2psw/Bak0fGJMVMEu41y1FV" +
           "xSqs5CB+yleJHiaU4zaHFniK8kt8Z2AuVp3hQCrKTpgotDErxY2oFg1rKg2H" +
           "UVfeFMiJHypMyVe4eSEi4lp5WqSShgq8ghpNkcWQWY8wt8Nj1ZaLsAOyUloK" +
           "4iThhwOZrVIqyBZpSmvOCpWgRfB6iq41VxymZcpJmRHXZMYzj06IVmkjs0zg" +
           "RLrTJSS+hDlpqz4dTJvrkoH4DcEd4vX6rDYYqYsoSJINZlHNXmnTbYcYPFGM" +
           "Ro8vwbDPWWOp1MULkgQHc4KQFGIFw6lP962Qqm/4oBDbobXBKqTZ40lSQ6cu" +
           "P5bqJNNGImW6qHIGFYWzgAVJ2bTZUhCAv6wmr2mrSEh1pIzK4xYVh8py0Y2R" +
           "okg7Q6fJtoXluD42KQZEVltHjR7qJgyrY1U5kLCNjZQDo1GISj6MzYYBgvWM" +
           "xZrnRkMUMQrNKVqrWtqgyKdGCBc6c47YzKsrz+HdnmvNhZm4LmPLoWi49CRA" +
           "cJOqI6V0UycRct2ySkTLGBVTg4VbbrLWvFY37vQaY3jeJeGlFlTcacdWNnNS" +
           "lfAxMyt26TGmYgQ5wrkxzhtjtKKgo0bV6M+qRDltOvRmlcCbuZR2YYGUygt6" +
           "jEb1uMv3AhdBW+slq4GPPjHHQo4b1cyoTDYiw0FZakDrJXhYUftyDNzC28iN" +
           "aaVjFmLVL9ccZkb7Xq218ZFk1sCbQRRvWLomo2PN8ite3EXDTdmdJevGbLma" +
           "Yb1+0kBULo6ESctwJzi76MUrL0WWHbCVkYpxp6xg9siutrkaHM1Bbkf76tjo" +
           "a6UavemIHYrtxjMQS+Vpw0zbdCG1AosAifeow8so5y1ZXTT9vmopkWstZ+Kw" +
           "kaTlJeFLfhFZ1opNar7CLSpi0rRkOOWlymLcwuULfjyZogZrk9QgMEa07Vcm" +
           "FO/iEcvSMB8bYH8JusfzIim7AZzAhSXTnvQYB2wQ3/rWbOu4enm79zvyg4qD" +
           "6zywocg6uJexa02uveCprNpODo5x8oPD229wXH7kSPHU/jHJ7ktekwzd7PRw" +
           "75Yk29Lfd73rvnw7/8z7nnhaHn4S3T9mUkPo7N4t7OHyO2CaN13/3ILOrzoP" +
           "jxW/9L5/vpf9Oe0dL+Pi5IETTJ6c8rfpZ79CvEH6tR3opoNDxqsuYY8Punz8" +
           "aPGcr4SRb7PHDhjvO7DGhUz5D4PnC3vW+MK1Ly+ub9o3bj3oBqfjv3yDvvdn" +
           "xbtD6DYtt9zWijmleMTflBA6HTu6fOiI73mp45OjC+UN7zqQ+e6s8RJ4nt+T" +
           "+fn/e5k/eoO+J7Pi8RA6v1TCthJIvu7uX+xwhxJ++OVImIDZjl8U7kfOgy8V" +
           "OcDH77nq/xe2d+7S556+cMurn57+VX6ndnAvfisF3aJGpnn0APtI/azrK6qe" +
           "S3rr9jjbzX+eDqHX3ICZEDqT/+aMP7Ud8pshdNc1hwB/yH6O0j4TQhdP0oI5" +
           "89+jdJ8KoXOHdCDst5WjJJ8OoZsASVb9jHuNk9rtsX9y6ghU7DlZbrk7X8py" +
           "B0OO3tBl8JL/u8k+FESjvbP3557uD975YuWT2xtCyRQ3m2yWWyjo5u1l5QGc" +
           "PHTd2fbnOtt95MfnP3/r6/dx7/yW4UOHP8LbA9e+gsMtN8wvzTa//+rffcun" +
           "nv5mfnD83zZP5S8HJAAA");
    }
    protected class NewlineHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        protected final java.util.Map values =
          new java.util.HashMap(
          6);
        { values.put("cr", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_CR);
          values.put("cr-lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                VALUE_NEWLINE_CR_LF);
          values.put("lf", org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                             VALUE_NEWLINE_LF);
        }
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.Object val =
                                       values.
                                       get(
                                         arguments[index++]);
                                     if (val ==
                                           null) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_NEWLINE,
                                         val);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "newline.description",
                null);
        }
        public NewlineHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO9vnD/xNbFw+jDEHLR+5K4WAWtMUcACbnPHV" +
           "dlBrkhx7e3P24r3dZXfOPkwoASnFjVoaBZKSNKAqIR9FJERVUVuqUFdVSCJI" +
           "ETRqSWgTGv5IUoIU/kiclrbpm5nd2487H4pUxdLOrWfezJt57/d+780eu4ZK" +
           "DB21aoKSEEJku4aNUJS+RwXdwIl2WTCMPuiNiQ/+ff+uiT+V7/ajQD+qHhSM" +
           "LlEw8DoJywmjH82SFIMIioiNjRgn6Iyojg2sDwtEUpV+1CAZnSlNlkSJdKkJ" +
           "TAU2CXoE1QmE6FI8TXCnuQBBsyNsN2G2m/Bqr0BbBFWKqrbdnjDdNaHdMUZl" +
           "U7Y+g6DayFZhWAiniSSHI5JB2jI6WqSp8vYBWSUhnCGhrfJtpiE2RG7LMUPr" +
           "izWf3HhosJaZYaqgKCphRzR6sKHKwzgRQTV271oZp4xt6HuoKIKmOIQJCkYs" +
           "pWFQGgal1nltKdh9FVbSqXaVHYdYKwU0kW6IoDnuRTRBF1LmMlG2Z1ihjJhn" +
           "Z5PhtC3Z01ru9hzxkUXhAz+5t/YXRaimH9VISi/djgibIKCkHwyKU3GsG6sT" +
           "CZzoR3UKOLwX65IgS6Omt+sNaUARSBogYJmFdqY1rDOdtq3Ak3A2PS0SVc8e" +
           "L8lAZf5XkpSFAThro31WfsJ1tB8OWCHBxvSkANgzpxQPSUqC4cg9I3vG4J0g" +
           "AFNLU5gMqllVxYoAHaieQ0QWlIFwL4BPGQDREhUgqDOsTbIotbUmiEPCAI4R" +
           "1OSVi/IhkCpnhqBTCGrwirGVwEvTPV5y+OfaxpX7digdih/5YM8JLMp0/1Ng" +
           "UrNnUg9OYh1DHPCJlQsjjwqNL435EQLhBo8wl/nVfddXLW4ef5XLzMgj0x3f" +
           "ikUSE4/Eq8/PbF/w9SK6jTJNNSTqfNfJWZRFzZG2jAZM05hdkQ6GrMHxntPf" +
           "vf8ovupHFZ0oIKpyOgU4qhPVlCbJWF+PFawLBCc6UTlWEu1svBOVwntEUjDv" +
           "7U4mDUw6UbHMugIq+x9MlIQlqIkq4F1Skqr1rglkkL1nNIRQNTyoDZ6XEf9j" +
           "vwQJ4UE1hcOCKCiSooajukrPTx3KOAcb8J6AUU0NxwH/Q7cuCa0IG2paB0CG" +
           "VX0gLAAqBjEfhH80I2wMD2hauEuQlBCFmvZFKMnQk04d8fnACTO9FCBD9HSo" +
           "cgLrMfFAes3a6y/EznB40ZAwbUQQ1RTimkJMU4hqCjFNIaopuBGPUOt3wLbB" +
           "bcjnY/puoRvgDgd3DUHgA/NWLui9Z8OWsdYiQJo2Ugy2pqLzczJRu80QFq3H" +
           "xGPneybOvV5x1I/8QCJxyER2Ogi60gHPZroq4gTw0WSJwSLH8OSpIO8+0PjB" +
           "kd2bdn2V7cPJ8HTBEiAnOj1KeTmrIuiN7Hzr1ux9/5Pjj+5U7Rh3pQwr0+XM" +
           "pNTR6vWu9/AxcWGLcCL20s6gHxUDHwEHE3Aepbdmrw4XhbRZdEzPUgYHTqp6" +
           "SpDpkMWhFWRQV0fsHga7Oto0cARSOHg2yJj8m73aoYt//GAps6RF+jWObN2L" +
           "SZuDaOhi9YxS6mx09ekYg9zfDkb3P3Jt72YGLZCYm09hkLbtQDDgHbDgA69u" +
           "e/Odt4+84bfhSFC5pqsEAhEnMuw4t3wGfz54/ksfyg+0g/NEfbtJVi1ZttKo" +
           "8vn29oC3ZFiN4iN4lwL4k5KSEJcxDYd/18xbcuLDfbXc4zL0WIBZfPMF7P4v" +
           "rUH3n7l3opkt4xNp3rRNaItxMp5qr7xa14XtdB+Z3RdmPfaKcAhoHajUkEYx" +
           "Y0fETIKYD5cxW4RZu9Qztpw2QcMJc3ckOeqbmPjQGx9Vbfro1HW2W3eB5HR9" +
           "l6C1cSBxL4CylchsXGxNRxs12k7LwB6meXmnQzAGYbFl4xvvrpXHb4DaflAr" +
           "Aoka3TqwX8aFJlO6pPSt3/+hccv5IuRfhypkVUisE1jMoXIAOzYGgTgz2rdW" +
           "8X2MlEFTy+yBcixEjT47vzvXpjTCHDD662m/XPns4bcZEDnsZmTpsSWHHlkF" +
           "bkf2h5d+euV3E0+V8vy9YHI688xr+le3HN/z7qc5nmBElqe28MzvDx97Ynr7" +
           "7VfZfJtR6Oy5mdyMA5xrz/3a0dTH/tbAy35U2o9qRbPa3STIaRrM/VDhGVYJ" +
           "DBWxa9xdrfHSpC3LmDO9bOZQ6+UyO9PBO5Wm71Ue1DVRLy6D57SJutNe1PkQ" +
           "e+lgU+ax9iu0WcRc6KeviwlolhRBzmTXpZhB0wqsS1BgmJ7XoAByYoDepnrT" +
           "cYP0CCOsRoyJP2x9YPeXS68v5xBoySvtKCeXTiyvaTn6nMLFg/kXdxeS7+44" +
           "86T616t+q0jMN4VL3ml0nTvZ8V6MsXoZzdN9lmkdGXi1PuDIFrVZs7CSrA6e" +
           "y6ZZLnOq3fr/rZYUCW5NUgoK/XCflMIJemvDCrFqsy9QGyWtGTkhbrv2xMln" +
           "Vowt/s6T3PBzJoluW/433758/tDo8WM8qVDzE7Rosptn7nWXVhPzClRENog+" +
           "Xv+N8Q+ubLrHb6aBatr0cYA3EVRlcx4QKu28O8uNviy5NXqBxNcOLDn0z13f" +
           "v9gNxUonKksr0rY07ky4I7bUSMcdyLKvWHYU19Lm1gxN2AT5FmqaWY/QdgVt" +
           "Ovl22/IxeSZ/PPtYPNtxzFi+qkBWctG5aZzQTavqbo1SsVlUU4zMmux2yG62" +
           "R/YcOJzofnoJR0m9+8a1Vkmnnv/zf86GDl5+LU+JHzBv9/Y+/QZFmheTXezm" +
           "bHP4igsTRZcebqrMLcjpSs2TlNsLJweXV8Ere/4xve/2wS2fo9Ke7bGSd8mf" +
           "dx17bf188WE/u/zzlJHz0cA9qc0Nuwodk7SuuIHWmoVDDfV+KzxnTTic9aYL" +
           "G4K52AJnaOm4LImePFFdYMECldlogbH7aANFV+UgwxjHm1GwfojqwGFEGjaD" +
           "NLyz/p2hJ95/nmPOWyx4hPHYgQc/C+07wPHHv9bMzflg4pzDv9g449hw8l8e" +
           "LWzGuveO7/ztczv3WrQ0RFDxsCol7KAnBYI+t3yjHatYt5r1SSMdCsJz0fTJ" +
           "xQJOps1wrjsnm1rAZT8qMPZj2owRVD2AyR3YEHVJy4YKEE4tY2NaMYX49y3b" +
           "HD/4/ObIgB73td/S03IzYgMfNuV8jeRf0MQXDteUTTt811/YFTX7lasSqohk" +
           "WpadxZrjPaDpOCkxG1Ty0o2z/OMEzSiwGSjI2C/b+GN8yiGCGvJOAQjRH6fs" +
           "z8CmXllYk/065Z4iqMKWg/jmL06RZwgqAhH6+qyWx2G8xM34HARtJifmv4ab" +
           "+S87xXkrpsHNPh5bRJmOmgXE8cMbNu64vvxpfisXZWF0lK4yBTIuv/tnyXbO" +
           "pKtZawU6FtyofrF8nhWMrq8Czr0xWAEBsuvzdM8d1Qhmr6pvHll56vWxwAWg" +
           "kc3IJxA0dXPuZSCjpSETbI7kqy0gFbHrc1vFlS3nPn3LV8/uXGY10lxoRkzc" +
           "f+pSNKlpj/tReScqAa7BGXZTuWO70oPFYd1VqgTialrJfmeupmgWaOAxy5gG" +
           "rcr20g82BLXmEmLuRyy4jo5gfQ1d3Sx9XOkprWnOUWbZGOdPXkkXxSJdmmZ+" +
           "xPCtZ5bXNBbYJ2mz5X81/sk/IRoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Wz719Lfyg+P/BuNMU64HJAAA");
    }
    protected class NoFormatHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_FORMAT,
                                         java.lang.Boolean.
                                           FALSE);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "no-format.description",
                null);
        }
        public NoFormatHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qpQK1HhaGP2UpOYUDIU2UfpfKPToCxUVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3P3ReCAAAA==");
    }
    protected class PublicIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_PUBLIC_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "public-id.description",
                null);
        }
        public PublicIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "lVKBGs8Ko5+R1JyCodAmSv8Lly/6CRUVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iTl4IAAA");
    }
    protected class SystemIdHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_SYSTEM_ID,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "system-id.description",
                null);
        }
        public SystemIdHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "qFIqUOM5YfSzkppTMBTaQul/AUsB7hkVFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "VtoN28W5V6WZeCEKVhMvNgTf6I6LFLWINXFcwpnI8YoFSSUrzpjmuNpwo5kI" +
           "PnISzFz2N9PxoKj0hkFNKdYKasuh0MIixBJyZjU3vD+NBV1tGyt0qdBcy6sP" +
           "oircDPyJ6rh2e0zQeJNm1ktF26gFl067RsN06VG73JlPGVIzkJkV1rpjXm8u" +
           "5htwiFsN7aFcL9WmBDUyuzI5aDYbqKr0i2VuBa/clby2OMsi4GJJiZO1KdaI" +
           "Zn9RnxtMdyam1QrZ1ym8DsebdNTnZpsSyncH03E/UXiEGBsVFmcauFxjG0aQ" +
           "1OtYleE2WG1Uj7pDd7Lwp+uEpaNWd+0lIldh4Sa3gTW4vlmyOFCVVm1YSHFq" +
           "FVrdmk+JcG+MF/B02VhxRkEnOzGvOhGVIDpZY7k0kAocMoHRQmxGrTJNLMZh" +
           "J4w3JinClZ5Sxw1xgxZX48KaEOya1HbjOrM0WzpcZtkCIo42ZJ3XlbjXQ2JZ" +
           "XbNSo7SmOm0nHRNtj1oTQzpZUavKQGsbs3mrpMDmQFYTb+bYvIqXWN4pp84Y" +
           "FsgymlYXwSAKOmTNlQuNPggw42VK6GTI6XybDwzbx5CxkcY9l+G6NFth5qnU" +
           "3rCoUubgfs/mkoary3iv6bvd5UZYcjWKj9NUmMTTlVjYlMHhFdZSEO04d65p" +
           "82mR1jdse6q3F/qCIVFiwweFlNfNtLzu4xZMt3yO4eWVjyIsp9rdIeCHK3up" +
           "Bq9gDiO0lB4uZD+SRKXXBhICCy6InQmaWoUyJcVxUxxF8mRjVBKTx6rhXI+K" +
           "Y6QoeZP6kJJjTI7Gq1K324XZFezCNI0UVgmCjJ3ipC/WVzI5Xa0MUYVrvrya" +
           "c2J94PaZUmwUHK81WKCtqtddVwy3vEnmSLltKSHTHlVLvl+tdB2KU5ueDi+m" +
           "DkOuvQomt+DAwNaovNE263a5uu4oRNCrVSSd6ifY3CMrE0pH3CHn+6VgkhYr" +
           "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" +
           "AA==");
    }
    protected class XMLDeclHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     java.lang.String s =
                                       arguments[index++];
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_XML_DECLARATION,
                                         s);
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "xml-decl.description",
                null);
        }
        public XMLDeclHandler() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "okqpAI3nhNHPSmpOwVBoC6X/BXTtMPcTFQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3nxBcFg+7wVuBA7kmpoeVOfyOsXdt6nOHalgnNo/Fe++ZlWW9bJixV5RNjvB" +
           "PXyr24X89PaZDzz/ksp+trizVzCSwIF979LncPkdQOZttz6mMvnNymEV46sf" +
           "+OcHh++cv+d11GkfPcHkSZK/w7z89fZbld/YgU4f1DRuuPM5jnTteCXjQqBF" +
           "ceAMj9UzHj7QxqVs858AO33vnjbuvXmt9OYazk1qa0i3KcatbjOXN34E3TXP" +
           "NbfVYg4pHDG7ETgyr1xTPbTH4LVOy0cXygecA5nvzwavAvYf2pP5of97mT94" +
           "m7lns+Z9EXTR0CJCC5XA9PbryO1DCd//eiRMAbXj9xL7nvPYa3kOsPEHbrgu" +
           "3V7xKV946dK5N70k/lVewj+4hjtPQ+f02LaP1suO9M96gaabuaTnt9UzL388" +
           "F0Fvvg0zEXQmf+aMf2yL8vEIuu+mKMAessdR2Bci6PJJWEAzfx6F+2QEXTiE" +
           "A26/7RwF+VQEnQYgWffT3k0Kc9sqY3rqSKjYM7Jcc1deS3MHKEcvBLLwkt9u" +
           "74eCeHu/fV354kvd/ntfrX52eyGh2DI4OAIq52jozu3dyEE4efyW1PZpnaWe" +
           "+snFL51/y37cu7hl+NDgj/D26M0r/uTSi/Ia/eYP3vR77/itl76T1wn/B9PF" +
           "nJF2IAAA");
    }
    protected class TabWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_TABULATION_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "tab-width.description",
                null);
        }
        public TabWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "oZiIKqUCNZ4VRj8jqTkFQ6GtlP4XMO5vJxUVAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "25DKpHwgAAA=");
    }
    protected class DocWidthHandler implements org.apache.batik.apps.svgpp.Main.OptionHandler {
        public void handleOption() { index++;
                                     if (index >=
                                           arguments.
                                             length) {
                                         throw new java.lang.IllegalArgumentException(
                                           );
                                     }
                                     transcoder.
                                       addTranscodingHint(
                                         org.apache.batik.transcoder.svg2svg.SVGTranscoder.
                                           KEY_DOCUMENT_WIDTH,
                                         new java.lang.Integer(
                                           arguments[index++]));
        }
        public java.lang.String getDescription() {
            return localizableSupport.
              formatMessage(
                "doc-width.description",
                null);
        }
        public DocWidthHandler() { super(
                                     ); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "IyKqlArUeFYY/Yyk5hQMhbZQ+l9u6hwmFRUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "cuMFwYb5vOs5AdiUq0pydEKXn1XcfYsTumOnGGcOd8b7r3o0O3azA4uDg9ls" +
           "F/fwza4Y8h3cZz7w/IvK+LOlvYNDoxnYtB/c/OyW3wNk3nbzreowv17ZnWR8" +
           "9QP//OD0nfp7XsNZ7aOnmDxN8neGL32991b5N/ag247ONa67+DmJdPXkacYF" +
           "Tw1Cz56eONN4+MgalzLlPwE0jRxYA7nxeemNLZy71NaRbnEgF91iLm/WAXSX" +
           "nltua8UckjnmdhzYNkeOoez80Xu1HfPxhfIB+0jm+7PBK4D9A9zt8/9W5g/e" +
           "Yu7ZrHlfAF1cqEFH9WXPcA/Pkns7Cd//WiRMAujSqcuJw9B57NVCBzj5A9dd" +
           "mm4v+uQvvHjpzje+yP5Vfo5/dBl3noTu1EC1efzQ7Fj/nOupmpGLen57hObm" +
           "j+cC6E23YCaAzubPnPGPblE+FkD33RAFOET2OA77QgBdPg0LaObP43CfDKAL" +
           "OzgQ99vOcZBPBdBtACTrftq9wenc9qgxOXMsVxx4WW66e1/NdEcox28FsvyS" +
           "33Ef5oJwe8t9Tf7ii4PRe1+pf3Z7KyGbYppmVO4koTu2FyRH+eTxm1I7pHWu" +
           "/+RPLn7p/FsOE9/FLcM7jz/G26M3PvbHLDfID+rTP3jj773jt178Tn5Y+D8o" +
           "fDl6fCAAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hgx/33kiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "FuaB1ObbkLqQ57k7CnxSnn9zj7o/yJN/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("HZXOB3FxC+VfHYv15b+AWMVm8NPg+fiBWB9/u2LFbyrWH9+j7k/y5D9GpSt+" +
       "YLmRmJ9PnZHuD/+i0l0Hz6sH0r36/166b96j7r/lydei0gOFdD1dPtj2PiHe" +
       "19+OeAkw6fwiWn6r5vHbLrruLmeqX3jt6qV3vyb+we5+y+EFystM6ZIR2/bJ" +
       "Ww0n8hf9QDesgunLuwNTv/j7blT6gXucLkalC8V/wel3dk3+Z1R67I5NAPP5" +
       "30naP4tK187Sgj6L/5N03wcWckwXlS7uMidIzu2BtQFI8ux5//Ao4sSO++4u" +
       "SHLuNEgezcOjbzYPJ3D12VMHP8W95MMT/Zg7OF/64mv04KPfrv3C7maZastZ" +
       "lvdyiSndv7vkVnSa3wp45q69HfZ1sff89x7+lcvvO0Tqh3cMH9vuCd6evvM1" +
       "rrbjR8XFq+wfv/sffvAXX/uj4sjh/wLQSvHAMC4AAA==");
}
