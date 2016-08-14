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
          1471188907000L;
        java.lang.String jlc$ClassType$jl7 =
          ("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");
        java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        long jlc$SourceLastModified$jl5 =
          1471188907000L;
        java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALV7C7DraHmYzrmPvXt3uffuLrtLF3bZx91MweTI8kt2lyTY" +
           "smVJlm1ZkmVbbbnoLVlP62HZTpZJSBtoSYCkS0I6sNPOsH1kSEg7ZdqZDBna" +
           "NAlLQtt0aAKdBphO2pAQ2jAtSSY00F/yOcfnnL33Luxdzow/y//j+7//e/76" +
           "vv987GvQhSiECoHvrA3Hjw+0VXwwd6oH8TrQogOKrjJSGGkq5khRxIO2G8qT" +
           "v3z1z775AfPaPnRRhB6QPM+PpdjyvYjVIt9ZaioNXd21dhzNjWLoGj2XlhKc" +
           "xJYD01YUP0ND95yYGkPX6SMSYEACDEiAcxLg5m4UmPQazUtcLJsheXG0gN4J" +
           "7dHQxUDJyIuhJ04jCaRQcg/RMPkOAIZL2W8BbCqfvAqhx4/3vt3zSzb8wQL8" +
           "3M+9/dq/PAddFaGrlsdl5CiAiBgsIkL3upora2HUVFVNFaH7PE1TOS20JMfa" +
           "5HSL0P2RZXhSnITaMZOyxiTQwnzNHefuVbK9hYkS++Hx9nRLc9SjXxd0RzLA" +
           "Xh/a7XW7QzxrBxu8bAHCQl1StKMp523LU2PojWdnHO/xeg8MAFPvcrXY9I+X" +
           "Ou9JoAG6fys7R/IMmItDyzPA0At+AlaJoUduiTTjdSAptmRoN2LodWfHMdsu" +
           "MOrunBHZlBh68OywHBOQ0iNnpHRCPl8bvPV9P+wR3n5Os6opTkb/JTDpsTOT" +
           "WE3XQs1TtO3Ee99M/6z00Cffsw9BYPCDZwZvx/zrH/n6297y2Kc+vR3z+puM" +
           "GcpzTYlvKB+Vr/zOG7A3Nc5lZFwK/MjKhH9q57n6M4c9z6wCYHkPHWPMOg+O" +
           "Oj/F/sbsR39B++o+dJmELiq+k7hAj+5TfDewHC3sap4WSrGmktDdmqdieT8J" +
           "3QWeacvTtq1DXY+0mITOO3nTRT//DVikAxQZi+4Cz5an+0fPgRSb+fMqgCDo" +
           "CvhAF8Dnn0Dbvw9nIIY42PRdDZYUybM8H2ZCP9t/BGteLAPemrAMtN6GIz8J" +
           "gQrCfmjAEtADUzvskIIggqOlEQRwX7K8g0y5gu8N2lW2m2vp3h5g9BvOmrkD" +
           "LITwHVULbyjPJa3O13/pxm/tH6v9IR9i6ACsdLBd6SBf6SBb6SBf6SBb6fow" +
           "yCRGSJ4KJAPt7eXLvTZbfytTIBEb2Dbweve+ifvb1Dve8+Q5oExBej7j5yo3" +
           "ttflP86BeW+6tSfGMzdA5q5PAZr5ur8cOvK7/vtf5DSfdKYZwv2baP+Z+SL8" +
           "sQ8/gv3gV/P5dwO/E4PNZCb92FkbPGU2mTGe5SVwpzu8pV9wv7H/5MVf34fu" +
           "EqFryqGvFiQn0TgN+MvLVnTkwIE/P9V/2tdsDeuZQ5uOoTecpevEss8cOcZs" +
           "8xdOyhA8Z6Oz58u5PlzJx9z3bfC3Bz7fyj6ZJLKGrYbfjx2a2ePHdhYEq729" +
           "GLpQOkAPitn8JzIZn2VwRsAPcMFHPv8f/qi8D+3vnPXVE+EPMOGZEw4iQ3Y1" +
           "dwX37VSGD7WMWb//IeYffPBr7/6bub6AEU/dbMHrGcwoBtEORI2/++nFF770" +
           "xY9+bv9Yx87FIEImsmMp4CHKgxfYiW55kpMz5MkYenjuKNePdi2AYAYIuz53" +
           "0JxVD4LwnZOWSeVgGwFywwIUXb+Fup6I2jeUD3zuT18j/Omvfv0lmnqaMX0p" +
           "eGYroZyqFUD/8FkrIqTIBOMqnxr8rWvOp74JMIoAowI8QjQMgSmvTrHxcPSF" +
           "u/7rv/21h97xO+egfRy67PiSiktZgAVuMjZBTDaBF1gFP/S2rZtLLwFwLbdN" +
           "KN//67fk5GZ9ZccI2geB8L1/8IHffv9TXwJ0UNCFZabDgIIT3Bok2dngJz72" +
           "wUfvee7L781lAkF7wt/7F+W/yLDW8wWezuFfz0BhK7Hs8S0Z+P4MHByJ6ZFM" +
           "TFzuAWkpivu+aoGzgZpL6raugwktF2jb8jDwwc/e/yX7w1/5xW1QO+snzgzW" +
           "3vPc3//2wfue2z9xlHjqJdH85JztcSIn+jXHonzidqvkM/A//Pizv/LPnn33" +
           "lqr7TwfGDjj3/eLv/tVvH3zoyy/exEufd/wjpcxg6XDZ7Kv68oKNr02JSkQ2" +
           "j/5oQZKmTWXFTpOyKjRCjpejZcecbnrUfGDH1CptNcfdicitN7Y/dngsJZwY" +
           "j8KyPEL7q0oAgkp3vFqZ/Z6NGRqJcSM8XK7TUdEQS9UpZrAswfesnjyr2Aa2" +
           "bJWbwPBCu+c1WQ6fMvZSQ0VP9cRRXVoLsrAU0VhXUbjckJMai0YFMplMOGER" +
           "rGwqKvdakwUez2GRCoqCNe053oSkWbyqR1gxLCyHalA2xMa4TXW7ZpdH1gGF" +
           "C2tzPBectkjWrMl4w4ndEBmzYbujF91YMqrUHMeRikwO+tMFxy4WpJVEQqXB" +
           "irgRuizBUW3c7UX9gPWWEcZaYifFqdRZc0pPKyfrAVZzebVL6DMRnc8SJG2s" +
           "KaeIhORMmq0UqoJQFZblEaLViQSTKFms15X9GrOgF3SH52mCU7VFZZAC355M" +
           "7RE9MGR4uKlMZ063HXXGnDooruLJBnFatFBXfbrTw3g3KXMBM2l55Bwbs2Q4" +
           "S0RbFkkx7qR0a9FleUYaOqmh82VhHNmJJy3b/flA6LbJ3qo/r5c7dn8tclxj" +
           "zjemXWnmz0IxWTItf1iqh7SIrTepgG6K4XJYKkirACa4dotkqXHc7IzZdGZ2" +
           "sXTdIttctd1EQqU6m/elLkf1u+4GafJjgXPG5RI/V+W1b7gRy0Z6OpvInVRE" +
           "hmw4dOYtxqcAwYGbBI5A1yuD9bIqEI7mdFQMWam4INEGVioSra4x7vQLfa5E" +
           "FRtBdzUuTnr9DTMZrofhTJ3baTpo96jumGLkeOxyYqtZsifUguqVbLPS7KyY" +
           "bkpMFLPYL3ZZW4xxqjOJ27YN1mED3IL5tDGLkkovdEfD5ohdiNWSbvajTrRh" +
           "5KVdCgpMwUIlLSyVxss+T9QNxUd7vXqsYz4uM357XOTtYk+3ml3EKg3hDrvQ" +
           "JgvaW7UMLxFNfL5mytN2VLQmcSGt9zzHxjV8xkyLqoMHQrnd1uoDOgnhGdm0" +
           "HNypURLmVgvzoa6t9TDxyBLSNLsetfEt1R9vPHguwBNC58OCQegOzY/WgT0d" +
           "F510VpPENhL0MB+ha31pwAnd2aZku+5iRceoPlqH5lCifIHmknmkxGsvIF1l" +
           "Ifc8vtBdY710NSLHo2K9hwTKZpPKHXuZVlG2hXXdZnvtEpt1gSwQURPj+u3K" +
           "jNOCLk45cxYv1plG4KO1SalLDvvDpsyR9TY+g7uhXHSattsdyANbbnbUADNU" +
           "X7W7uDzrmtFqTmDLoGuYAwydNzprmXVLrszw1eZwLk7n6jQdDyY1d9F3Hbw6" +
           "KQViAyXUoqbhmESIpY2RdvyeMHJ7TgevByaW4IWObwInEMezDho7NDcLm5vV" +
           "UJ+vi2W8oUy01K/1DbfRVnpISKBmDZEFGTf4pkuuB+LM9Nz5Ug77KdMdWqyN" +
           "LpHViOkaNbhQl5FloeLp1qjVEgqG5vc2bXE6roibYTlci8Tc7vLjpIXWYbRA" +
           "NGC0qJXDhG03I7k9MlyETOptiSRZrEeHcYWczWW0gFTQJtwD3olsTLoLnpmR" +
           "6WIVjH3JDJvOerZmMX9JsIU507J6ZnXALSv9OuGt4ZUBB5axwRZVC5WjRHV4" +
           "Nh417OYmQIx+hcHD1bosx5E6QZF0wdDjKlIr1MhJsV4PlOXUmKtwvWY2g1iZ" +
           "KWoq1nFpitW9AqyvS9ScCnCiugGeq7xE4lLdWDNrl7a74ojhJoHbV9ANS5Ad" +
           "pucTYz40Fx1badMbBlfdVUBjSHcsGXV2RHcYOUL4YNbgO6otueAMQCLN4oxk" +
           "lemmEWjFEazUl2g/HUccUqY2SqICmRWVsWEN0b4euUqJUzblmVZT6wmhT31l" +
           "OXSG8Kpe51oj2Wymka0iQ0JrCfNxQDXNgTAiJoXALI4EzYMnFi6Op5sqU2JF" +
           "WCr3xbLPLtZUOpyu+vy45hTrFGyWxUFKOjUf6wx7NVdkx2g/aE6jPheEKCtp" +
           "RCvoOLO+aZK4EDo0A3xks8bArRidpGu7WJymFX0de/0qUYykeJ3WXbHGdX1d" +
           "bsfzflXaxLMy5Q7jItUX6t2qgutSGLNGrTqpkEYpxIcMWa3jOAerjYQW2AlN" +
           "9mjRiSdzetXqoGhXWZK80tDrjcaE8RFmFYSYxRlDt2iOx9W1OCwifNdWqsW5" +
           "BjNDzWvVRgSpCS037I55kfXabg+lm6GwEiawORg4XlhNqJaSjgPdiASmMxas" +
           "xXLMNyQuoCyiNVeNGSOXqgUN5lp+pU56sOZqaX1TlunYRAp47Fb4BelKUhfX" +
           "JhqpkQXfot1oXl73+qPlgA4VigiZuedFCAMT9AadVuUN2hd77JJ3WKMvW4nl" +
           "Lpa9uRKUCb1m60nR41fw3EikyVqrzcrrSByFM5dqaZY8GDYmE80RsUkTrW4a" +
           "utpYCoyimyuXmHVmYn9hISWfHzt1lOq0xbKmCeFms5GVBKGbGqWPJsF4OlvE" +
           "Nt00TJnEdBI4UsWSJG2IOukCLVcsrdg3yo7GxgpSabsxraS2LHn8aDaoxYN5" +
           "sQE3ej0iDmE8qpTJpp1sdFPvSJrcFGt6rG4SeB7DZqUuJN46TjxBm9bIyCqw" +
           "lXmbG45pSZvIWNAdeOjQ6PQFYdWkq0HTdwmHIKoU0gzIkDfJhkwbi9aqp43S" +
           "yENYyZNNcCj3Ld1OV/O+2a4OKW1p9AKrzVf8yaiHtsdUjWp6mt8aT1Z9Be/w" +
           "pFERxo1WillaOlWbQ29ScftJhBT55brqBQQ1Q5DxQhqhrjWzU3q98dvK1GCr" +
           "Adb3RZvoewjXlj2ZLMwrGFjViXsNpmy0mh2htsFJnfTdxaiWDtbDKg7ePsd9" +
           "q8Xqw1pvARe6Y7NlaUpNXZZiuSwNmDjUqS61tLSwPYRbQ1FP6E25KC1xu79p" +
           "lktw30za8GQ4hKlFBU+QcIgQy64fpCjZE6UazncrJtUQJ+wMhnWswtJs5Dao" +
           "OAB8TqvyILE3RM3vMkWv2ZXRuiwxbCFdUGttMLeQpVbrqRWuVl/rzR4Xlqle" +
           "v12ooEBhgL1GnVWLC2rKNLJpdyUpVjXqWxo9D9b0nKRINpnMtUKlPmTgRiww" +
           "FUyYNM2gt+SNhJ5OGNSswKhZbaBDdlVVyty6qmE4i7OF2cxZ6/FYNlf1ycIq" +
           "LnwnTNxWpBUYGm9sJFjlzGZv0e6mNsX2k46CpbozpjshySgdecakcWvVHY2m" +
           "U7IjtvV+OWk6ZltBZ8hkXVkrnrRKps7AFgrtUUOWuT7iaPaCrsi8Xhe5RU8Z" +
           "pI1yD8WCWn2qFklTjSiD0oWyUq0HlDcvJ60ZuapuyhSSxpTH4ZqtdEljGCbL" +
           "5XyBxtMBwyfcBqvVamhbmxfbrMRUEHlFyEhvPBmotmnzeuhtFoUF7hQrsIoR" +
           "5XV5Y/BzYcb0zYWkwC1Nplu6XQhmRJ2wFwipWoQ4n/DL2mhZKhTDIjOVuJI+" +
           "YCm60arPjU5hNBprDpKq1nrMpMOeLvdrXd6Ep2k4pKrNuqWxZY6qturJZmps" +
           "GCNteriBiSbMF83QV3uNNgIboVHDSo2WErVaBQzjqlWsbmB0wJPepui2haAP" +
           "DgAsN9MLFOCzvbEDjSXaVdBcrDls2+dIt4CslUG1F5NTm1m3LEZoRuZQ4IvI" +
           "hK7KWJSUI8QqGAV+yTHVVWG5qS9ZqkFU17a3auD1eY1r1wnG1So1vToquFRq" +
           "e0Fhki4Hc4qqGwVW4+B1u4q2ebm6JAB9wqRV6WhLqlIcp9JYaCCBq5M8QcGW" +
           "VXTlOlMY6U2006q6kdwb2hE+sJYy2uu4c7RpemFDHJuLcYtTJ4sYSUsuBY6d" +
           "C9kvpf4kojcpqZdRqisuYMTv4pVqggMtAQfkel3H+0rAKQO0ZXstN6Vt0yHF" +
           "oNLtw6IX6zNkNkj4Kc1VO/VOVUdpt+bGeN+AKcMZkjVeZdqDAc7RtVYwKCf8" +
           "ZsB58ICjtGG9vhZreNpHapV1HUE9C5e4OnjbSaVlWOrBcE+uLDZh6oXkYrTw" +
           "HEoQytNluByFbYrp4rPqGDi4sFJVvKXZnEdFn2xW1Aj2S1ihXpmMqiLGC3GK" +
           "McZQD53qpoKPUG2CD3W37BYaddb1FcYy0BU5lKvjnl8jmzixSQxtORN6YuLx" +
           "Mk+ESyXFKpE2IGK+MkdQYVDb6MJUbyj6sLT2tEmHiJeuzW8M2ouKwQpRKl5b" +
           "41RrUNqImrSYDJzCsosvGxLd1ycLvjMwVzHiJgWiLhRIqRVX0g3D6hPBWZbK" +
           "y5Cc+4mmezi9UuJ0hVcZvUUqdiwSS0J1iIk9F0WyWlszw4KqI9NVWGcGMguH" +
           "zIqryh2mXFOnyIhThJo2FVO4ZzYKtWEwRQN35TcERvJiMpFoXCIWJILNJ3UP" +
           "j8Fhk9hgOBcic1Vim6zodOx4po4DnnVGlbC0In1VLcSbeZj06b4FF0U01fBI" +
           "J2VhaDUs0bZUjRhiRZFW11KIJuOpVyWUjoeW/GHYxOA1QhDMtOQ44JVsuTRX" +
           "cFFpyuWWng77BaMoECRa6tq8HbU8WfY8qVrp46XhIEripDBUKkM3rBRQlmvA" +
           "7ICG9fKiXkmZiEybzSzFQH53WZ778mTccW1m7qBZR/G7yG6sbr7g+Ri6Owj9" +
           "WFNiTY2hS5IcxaGkxDkJoO+4cLSl5ERmGsoyOI/eqgSTZ28++q7nnleHLyBZ" +
           "9iab2I6hi4eVsR2eewCaN986TdXPy0+7VPJvvuuPH+F/0HxHnkt9SYqbhi5n" +
           "M5msyndczXvjGSLPovzn/Y+92P0+5Wf2oXPHieWXFMZOT3rmdDr5cqjFSejx" +
           "x0nlEHryJbktX9HUJNR26775cekTNz757PV96PzJbHuG4dEzuet7dD90JSdb" +
           "4KgSdzkGgSDdtZxMZAO2ZqKHXg8+/+iwVJN/Z70PBBl87WqnPC/Riv1jNeQO" +
           "5R5C37fLoWK+4wCFybh+fey5ecpRkh0tq2f8v6tPI5/4k/dd2ybkHNByJIa3" +
           "vDyCXftfa0E/+ltv//PHcjR7Slbb3GWFd8O2BbMHdpibYSitMzpWP/afH/35" +
           "35Q+cg7aI6HzkbXR8goWdKi7GVFb7so51M/0WRl4ewzda+Y1nG09Jx/5Qycs" +
           "DYuh80vfUncmeOPlEownF8obxGORXc0aHwWfFw5F9sIdiezWm1vepi8Hixi6" +
           "YmhxW4uU0AqOShLF3TbDV7rNvKJy8xLLQ2fLPAd5CT8I7mTbe/movZsULbZr" +
           "5JN+/Db8ePeW+gy8M2/4OzcnZC8nZEtDBt6VgZ/IwHuA19MWieREN9Ofu2Tf" +
           "dzTJ2/H2nS/H25sT+jMZeG8GfjID78/AT58l/lVQnp+7Td/Pf4fM2q13sOPY" +
           "z2bgQxn4hyAQAfXLg8ntowOXgHh1ou7/U9bzn/3MN67+2LZecLr6kV/9OJx6" +
           "dt4XPn+udE98/f15VDkvS1Huxy8BLxxlI2Po8VtfI8lxbUsb97yskj+4U/J8" +
           "+WMdP9LQqzsNzQdkzR89VSu5ORNuKKR7g/vEF95dy13m1aUVWSCk84c3W047" +
           "0F35+ZlTt11uyqYbylc+/lOffuKPhQfyawxbjmRklYHzzb5rh5q6l2vqfm5v" +
           "IfT0LQg+pCj39zeUH/nwtz77R89+8cVz0EUQ0rLYK4UaCLMxdHCr2z8nEVzn" +
           "wVMbzAIB+cp2tuUZx4wDArz/uPU4AsfQ998Kd14XOxOos/szjp9qYctPPPUw" +
           "Op+K/kkQnOzNVeHeV64K7wSx8jtg3vHeD6MFdH+u9CfKkVmB7GRnEEMPYHST" +
           "427wM6ZzQ2iyZLNFd3IVC0DnHp/b7Oo20ptYjopJobo1mxe+ffdTb3v4xb+R" +
           "m81LmfQKGXPrQBBs6Tt5QeIwvNyJ5/zVDHwkA/84A7+SgU9+Dzznr92m79df" +
           "YZj5dxn49xn4DeA0TSkyMV/VbhZozlmHt+PuhFX/KQMvZuAzGfhsBv7jd8iq" +
           "3bsNByKiJ2WF3pfl2e/epu/z3yHPdgsfZOBzO+79lwz8Xga+kJHkx5a+zn7Z" +
           "d8yoL2fgv+W4MvD7GfjSd8+oE/TeZrH/cZu+P7xjJv1BBv5nBr4CXgi3TGo6" +
           "zqvDp/+dga8e8+lPMvC/vge2939v0/dnr9D2/k8GvpGBPwe2F/u7azDFO+bL" +
           "tzLwlzmuDHwzA3/1PdKfvXO3PzQ/tosoZJYOCJMAnCw6K0XLXw1yFBfuVM32" +
           "Mmnunc/AJfBWlUpW/Kpo2N7VDNxzpGF7");
        java.lang.String jlc$ClassType$jl5$1 =
          ("92bgyqukYXs7vWjli732lgP2LuYDHrqDE/LeAxl4MAMP7zZ1xwx69DSDHsnA" +
           "G15NVdvf7aiVgc/ky96al4esun7HKvVEBp7KwNOvIr8Kp/mVUbL35lUMvebU" +
           "pc8j43n85e6KgsPW615y3Xx7RVr5peevXnr4+fHv5Rmi42vMd9PQJT1xnJP3" +
           "GU88XwxCTbdyLty9TQrlb9B7xRh6/W2IicHJPvvOCN+Dt1PK4JR60ynAQrOv" +
           "k2Nr4O367FiAM/8+Oa4RQ5d340DY3T6cHPJWcFoBQ7LHH8huWd7iuHf/y8nv" +
           "RKLyqVu+4/ST7f8B3FA+/jw1+OGv117YXtMEZ87NJsMCXiLu2qbfcqRZKuuJ" +
           "W2I7wnWReNM3r/zy3U8fpT6vbAnemdIJ2t5488RYxw3iPJW1+TcP/6u3/tPn" +
           "v5hfFfz/Q9q80Z4xAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "WWEQmjJUNxwXZUFTwzDSAs9TFmie8qYKG6i5CASX6amoIkueHFFdQGGBGu3e" +
           "At/uY02KosoER6JApVmwdug1gOOoPGyFcmhf/dtDj1x53Eo5OYcRlzA5ePQb" +
           "nwQPHRUoFfc5i3KuVJxjxJ2OM9pNJ0fmmYWP6Pzz2X3Pntp3IENdSYqKhzU5" +
           "ZlPDcAFq+C8KOdaxTuf9e7JeamTfAvCcs7x0roDbWZPHwVMNLeDEwwW+HWHN" +
           "NymqHiR0PTElQ9azwQNEVcs5nNVPQXEnZhvoW/8PA6VhZvfFQmbmBTeiSPBz" +
           "U86dpriHk54YqymbNXb365yesndllUA08ZSiOIs5x3upbpC4zK1SKUo7kS/G" +
           "KJpTYDFQsPFfvvATYsgPKGrIOwRgxn6csuNgZa8s6OS/TrmTFFXYcsAB4sUp" +
           "cpqiIhBhr2f0PC4UJXDa56B6yzXcow038mh2iPMMzQiAX0FnyDTVaxUiZ8c2" +
           "bb7n2hcfFWd4ScGjo0zLdMjd4qYgS8gLp9SW0VW6sfV69ZPlizMB67pDcK6N" +
           "4wpIkh+2Z3tOtGYge7B9Y3z1+V8fLH0VqGYb8mGKZmzLPSyk9RRkwm3h3BoF" +
           "khc/are1fn/vmuXx99/kxzGUcwjzyg9IF0/ueO1I0zgcyad3oRLgIpLmp5j1" +
           "e9UtRBo2IqhKNjvSsETQImPFVQBVMyxjFojcLpY5q7K97HKHopZcysy9EoOj" +
           "6wgx1mkpNWaVUNPtHtfdeCanpXTdM8DucZTqWPAw8wbgcSDcreuZa5Gix3Qe" +
           "+FFvIcg7+ejz/JU1v/gPgZI4cZ4aAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "JAAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "+FFvIcg7+eiz/JU1v/oPQRci2Z4aAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vHzhJyQAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iaAgAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "QqrFpCAAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5a6zjWHmeOzu7M8PuzuzCLtuFfTLQLkHXiZ2nhqXYiZM4" +
           "sWMncZzYpcw6tmM7fsaP2DHdlkWiS4sEq7JQkGB/gdqi5dGqqJUqqq2qFhCo" +
           "EhXqSyqgqlJpKRL7oxSVtvTYuffm3juP1aptpJycnPN93/ne5zvnvPgD6Fzg" +
           "QwXPtTaa5Yb7ahLuL63Kfrjx1GC/R1VYyQ9UpWlJQcCBsWvy41+89KOfPKdf" +
           "3oNuF6HXSo7jhlJouE4wUgPXWqsKBV3ajRKWagchdJlaSmsJjkLDgikjCK9S" +
           "0GuOoYbQFeqQBRiwAAMW4JwFGNtBAaS7VCeymxmG5ITBCvpl6AwF3e7JGXsh" +
           "9NhJIp7kS/YBGTaXAFA4n/3ngVA5cuJDjx7JvpX5OoE/WoCf/813X/69s9Al" +
           "EbpkOOOMHRkwEYJFROhOW7Xnqh9giqIqInSPo6rKWPUNyTLSnG8RujcwNEcK" +
           "I189UlI2GHmqn6+509ydciabH8mh6x+JtzBUSzn8d25hSRqQ9f6drFsJ29k4" +
           "EPCiARjzF5KsHqLcZhqOEkKPnMY4kvFKHwAA1DtsNdTdo6VucyQwAN27tZ0l" +
           "ORo8Dn3D0QDoOTcCq4TQgzclmunak2RT0tRrIfTAaTh2OwWgLuSKyFBC6L7T" +
           "YDklYKUHT1npmH1+MHj7h97jdJ29nGdFla2M//MA6eFTSCN1ofqqI6tbxDvf" +
           "Sn1Muv/LH9iDIAB83yngLcwf/NLL73zbwy99dQvzhhvAMPOlKofX5E/P7/7m" +
           "G5tPNM5mbJz33MDIjH9C8tz92YOZq4kHIu/+I4rZ5P7h5EujPxfe+1n1+3vQ" +
           "RRK6XXatyAZ+dI/s2p5hqX5HdVRfClWFhC6ojtLM50noDtCnDEfdjjKLRaCG" +
           "JHSblQ/d7ub/gYoWgESmojtA33AW7mHfk0I97yceBEF3gy/0dgg6A20/298Q" +
           "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" +
           "/wOiI8RjpCAAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "PFOiIAAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5a6zjWHmeOzuzM8PuzuzCLtuFfTJLuwRdO3YSJxqgJE78" +
           "SOw4ifN0KYNjO37Er/gVx3RbQKJLiwSrslCQYH+B2qLl0aqolSqqraoWEKgS" +
           "FepLKqCqUmkpEvujFJW29Ni59+beO4/Vqm2kHB+f833f+d7+zjkv/AA6F/hQ" +
           "wXOtjWa54b6ahPumVd4PN54a7LfZck/yA1UhLCkIhmDsuvzEFy//6CfP6lf2" +
           "oPMi9GrJcdxQCg3XCQZq4FqxqrDQ5d1oy1LtIISusKYUS3AUGhbMGkF4jYVe" +
           "dQw1hK6yhyzAgAUYsADnLMD1HRRAult1IpvIMCQnDFbQL0NnWOi8J2fshdDj" +
           "J4l4ki/ZB2R6uQSAwoXsfQyEypETH3rsSPatzDcI/NEC/NxvvvPK752FLovQ" +
           "ZcMRMnZkwEQIFhGhu2zVnqt+UFcUVRGhex1VVQTVNyTLSHO+Rei+wNAcKYx8" +
           "9UhJ2WDkqX6+5k5zd8mZbH4kh65/JN7CUC3l8O3cwpI0IOsDO1m3EpLZOBDw" +
           "kgEY8xeSrB6i3LE0HCWEHj2NcSTj1Q4AAKh32mqou0dL3eFIYAC6b2s7S3I0" +
           "WAh9w9EA6Dk3AquE0EO3JJrp2pPkpaSp10PowdNwve0UgLqYKyJDCaH7T4Pl" +
           "lICVHjplpWP2+UH3LR96t0M7eznPiipbGf8XANIjp5AG6kL1VUdWt4h3vYn9" +
           "mPTAlz+wB0EA+P5TwFuYP/ill97+5kde/OoW5nU3geHnpiqH1+VPz+/55uuJ" +
           "p2pnMzYueG5gZMY/IXnu/r2DmWuJByLvgSOK2eT+4eSLgz+fveez6vf3oEsM" +
           "dF52rcgGfnSv7NqeYak+pTqqL4WqwkAXVUch8nkGuhP0WcNRt6P8YhGoIQPd" +
           "YeVD5938HahoAUhkKroT9A1n4R72PSnU837iQRB0D/hDb4GgM1eh/Ld9hpAA" +
           "666twpIsOYbjwj3fzeQPYNUJ50C3OjwHXr+EAzfygQvCrq/BEvADXT2YkDwv" +
           "gINY8zyYkwxnP3Mu7/+HbJJJc2V95gxQ9OtPh7kFIoR2LUX1r8vPRY3WS5+/" +
           "/vW9I7c/0EMIIWCl/e1K+/lK+9lK+/lK+9lKV4fSfGIooU5LjgJsA505ky/4" +
           "moyDrVWBTZYgukHeu+sp4Rfb7/rAE2eBO3nrOzK1AlD41umX2OUDJs96MnBK" +
           "6MWPr987/hVkD9o7mUczrsHQpQy9l2W/oyx39XT83Izu5We+96MvfOxpdxdJ" +
           "JxLzQYDfiJkF6BOn9eu7sqqAlLcj/6bHpC9d//LTV/egO0DUg0wXAvVlSeSR" +
           "02ucCNRrh0kvk+UcEHjh+rZkZVOHmepSqPvuejeSG/6evH8v0PFboW1z0pWz" +
           "2Vd7WfuaraNkRjslRZ5U3yp4n/qbv/hnLFf3Yf69fOyLJqjhtWMxnxG7nEf3" +
           "vTsfGPqqCuD+/uO9j3z0B8/8Qu4AAOINN1vwatYSINaBCYGa3//V1d9+59uf" +
           "/tbezmlC8NGL5pYhJ1shfwp+Z8D/v7N/Jlw2sI3X+4iDpPHYUdbwspXfuOMN" +
           "5A8LBFvmQVdHju0qxsKQ5paaeex/Xn6y+KV//dCVrU9YYOTQpd788gR24z/T" +
           "gN7z9Xf++yM5mTNy9v3a6W8Htk2Kr95Rrvu+tMn4SN77lw9/4ivSp0B6BSkt" +
           "MFI1z1JQrg8oNyCS66KQt/CpOTRrHg2OB8LJWDtWZ1yXn/3WD+8e//CPX8q5" +
           "PVmoHLc7J3nXtq6WNY8lgPxrT0c9LQU6gCu92H3HFevFnwCKIqAogxwW8D5I" +
           "PskJLzmAPnfn3/3Jnz7wrm+ehfZI6JLlSgop5QEHXQSergY6yFuJ9/Nv37rz" +
           "+gJoruSiQjcIv3WQB/O3s4DBp26da8isztiF64P/wVvz9/3Dj29QQp5lbvJ5" +
           "PYUvwi988iHibd/P8XfhnmE/ktyYkEFNtsNFP2v/294T5/9sD7pThK7IBwXf" +
           "WLKiLIhEUOQEh1UgKApPzJ8sWLZf52tH6ez1p1PNsWVPJ5rdhwD0M+isf2ln" +
           "8KeSMyAQz6H7+D6Svb89R3w8b69mzc9utZ51fw5EbJAXjgBjYTiSldN5KgQe" +
           "Y8lXD2N0DApJoOKrpoXnZO4HpXPuHZkw+9vqa5urshbbcpH3K7f0hmuHvALr" +
           "37MjxrqgkPvgPz77jQ+/4TvARG3oXJypD1jm2IrdKKttf/WFjz78que++8E8" +
           "AYHsM/6138V+nFHt3E7irGlmTetQ1IcyUYX8C85KQcjleUJVcmlv65k937BB" +
           "ao0PCjf46fu+s/zk9z63LcpOu+EpYPUDz/36T/c/9NzesVL4DTdUo8dxtuVw" +
           "zvTdBxr2ocdvt0qOQf7TF57+o99++pktV/edLOxaYN/yub/6r2/sf/y7X7tJ" +
           "lXGH5f4vDBvepdClgKkf/tjxbDFZj5JksuCxmkbVQodKiVFz3aMGZkdXKgTV" +
           "9cg2ZTZQrgnSbzMc9QYdPlLQclQd41E1jhwaQd2R3We8tKAN6haxwOoVvcAj" +
           "1mw5ICdmaLvDaOaP2i1v3hGslV2c6dbCoyt9ZTXqTJFmbWXjVSzAVDxER5KH" +
           "et1obsN2KsZYYRrGtcDrjqLezGM4scetHFYVW4U1UhBslF5NkYoiJondClZp" +
           "cTqIkwLOTZPY7vZtgeYn/JLrKIpRT5zhWBAbXTsi15JhctRE5JIBanYdftYb" +
           "2WVRd9vBUkwbDj/xjaVEp+2xrg3oVQNxfHGQTpDY4gchQk2JTadfERKmvwym" +
           "WKOslErSeMBJNdecFmQTh/mQoaY8X411jxgXtCUuTNplXzU2ET/fYLM2j7Mk" +
           "v0gjzTZxhjDLeL+GazbfGC5GKEWknmzSNaTgoMigbelkU+4t+ybmcHSXW4gd" +
           "Tx6wiRiHRcvp8kujMFiZulgRerZHhGqv2af06lxDOh2U1scMVhW4RQfvkby/" +
           "ZlaKJCBUg+9aUhoIRjdAy/OWRKYcoZt+VDGqqIaLkhBaLEvok0UkhGh1bpms" +
           "UggZr9UyJiZFMStTa9Tl5tKu98fLKJkkjlNxN90RKTWnTZRiueLKDlJ/tZjT" +
           "RNEctUt0LVl0Na9bNmqOMeRqk1Jr0U/lko+xA7ayGpN91oGlkKmkMyLCxUo0" +
           "CriGU5dJKu3301Z5aDRDTIAnLXFlyPM6HnV4Z1Yb1Pvr7mzMy1IqRrYruT2i" +
           "QdlDRmoPmYSba7V6yi0b0gxh6qi3CaZlxkPDlbHRht2AGFAi04jGRKkxniPr" +
           "BoXrYgvtD+k6wVaQnso5jlOOm2q1oHBaSZoNGMIeT+wKYYINrTlqKTpidyZi" +
           "KtR7ZW5O0QvSkRaRH6AkodF6VyNNYdErJJM1HOCkXhrV2sGEGdhtekJ0QPin" +
           "HVXCas6siHVjcuYNxLLN60EpRorJEpUMHLGidZ2iJSFJEm7sydOmWUU21UJ1" +
           "gKFW2vAoQigaK8eRkwbtz1ZikAoK2q9utJo94rBJv9jsNvFBz9fQPtnj5KJW" +
           "dcTldCjNppv+mA+NVTgbwVWyJU2IRtte1cVqkbGrY8eAO4FKlGd6u2EX2p2a" +
           "zggVo2cyUwSnZtYyTdD2yJ2Jts2SAxQZ1pyBpg01L7BLqMXwrjNzK2K4abVm" +
           "FUkxxhSjbZKUrOgWPyQdzu6KgUCtqHGLY6MYXuNSHV1tJMKd1pFG1JSkclPX" +
           "14giTkVBHRsLB4Z9URXm1aC/9hsYLjfbrKl5nWWhY3i8oZLtkdMYkkvcpyTV" +
           "ZcHOJW1UbF2za0yH6PNTBhGEToEYbmZatCZVCosp2iwiC1ZKiYAFYntUsG57" +
           "YtEWKwtOcxlzDtZdTWo9rhhF+HRdGFZM3XPXfm+UoH5ilvA6ZiyHrOahZYOo" +
           "R8OxJqAF3q2TaXM29jSGY8ej3pQoF8uGkMpiZVgclvhEWJGFgT6PlrOgY9bE" +
           "qDkslts0rZTG7aiRVqqyJvUJTO65q/q0z9q+3eyw1Rkmx3NqUFQXvUmxshnX" +
           "JkLJtQKKcSphXWwytqaKbMc0MMRSBd/DoxaqBg2naZVomooZTKeo+RwhnZak" +
           "SMumrvC2I3EVVh+HGEekoelY6UyfzeWxbvaTebND1bU6a+BJlLIxbJMYXDHZ" +
           "xjIYeK0FNa6aPVKl14wepFKjKxXVAYPPzTqtFMoKFcMsl8679GCoEcl8TjYj" +
           "oN5+od/A103SSVep2IsX00YNtvwZgZJ8xcDm5TYRDwmEUcYi3GxX+yBWutN1" +
           "n3fa9ToSzkHdaExabiKqPR0dput6t4GWZtME6U2SepvyPFMSEd1wkBQxMdxa" +
           "FNRVmVStDW1P2DrOrtM6ChdGcNxuodVFAVHpWaMrBJ1GpR0PmXZrFVdNMw5Q" +
           "pGJOmZHjJBhSXCzctgxYJk16AhKwoi3XxqBVoIlewI0iTikpk14gN0OU71VT" +
           "lqs60wIhjKs1uTBv+pvSJMJ0dmg5Ym9RG/VGFW/SaLNIXa8V6TJZ50u4Kc0j" +
           "qhRq9Y1fLxrFEb0SGVrE+nHTxIcugS90tN6XV+vmhjc4tE9JOtv25IrnjmMY" +
           "a1cKGI1VlkapTwtuOxzRUt0oI1qt0QzTwCXQhhqnTURveJGnSQ0aZRqjycrT" +
           "6yyaqBgL1/hZwJrVtDrjMazml9ZKsdjyjHF53qunGIFTtJ6gm8AkE6Q6FYKZ" +
           "ELYwluJimtsIahFrCfGEJymW7I98ueCyCMYq067RKgdwkJL8dLosKOimjGo+" +
           "njQrbp8sVMcLuGA5CBLBi8lqIBfnvrIiFIfiqn4nbTTdIE77PF4rayFcoMip" +
           "GFedlYCUihhFV1wa7pY4ii9LETkiB5hppmV4atZQtbcoMZtgaGmbTZOdr2uK" +
           "qsYNXF6RAaV74mziSsyU7cLTit9f0aiWVJR1b5y0l/ZyQs+FZWu4HpiezjRd" +
           "xeVtvqzrraA6NZHG2hbHvbWA9Q2kzTWpDWzZQqnZWS8ty8IbjJwM9VXK6G1r" +
           "3GojNSJJMZwv0qQwEOaKaXrFqIA2DSpVVKvdEuedajOhUrTkybDpVfBOpzvC" +
           "lhQ6Hq+bMB0ve6Mhg7rtJkl3rQrWcYwG0lzgSaWwXCx4B0Fx3i+3iMV4WZnZ" +
           "eEpjpWY9MucxFlf7qtPVY2NhD5beQpL72JoZDIrxYKAkEVKiOxZSJdtzC6OM" +
           "QN5IaCdJEC/R4XojJckoFYJls98dGdVGL5bHZNmEOU7h2/BMqhNkp1vniuuq" +
           "GkQKBwSOJdxgjFJsVj1WLlOVcMr14KKvjQo2UVzrzLKK+5FRG8Ajay7VloHf" +
           "t9MutxIkxl4kqSkGzHrtdAVmuqFLnbljyXNjyvouWdISGGYHzppLGpOo7i3i" +
           "IjLEaKHUbTUITqN71WXQLo7rmlvrTUpxaUSWqkSFBp97tTcnenGpywqkAy/0" +
           "taZhXjBChv0YK6f15mQYIT3Cm5RrtWkMvj3LsiMG/RqPlCcbvoLqnD63CoNJ" +
           "mRzjAa+g1WpcxOQJx6ohDs877TXDtFp9zCgs69OyI4xtn8bKsVqoxT0RdeSG" +
           "VKoILX68LI5pUCaHXmdiWlWr3jGrUm0W6Ti+mUvrWkX1EWwRp71aWCu0SZdl" +
           "0JpDeao93PijKR1jlj6dpkhLimiiX6y3pGBJ1Lu209VQ0+Ss1hLviy7i4dU6" +
           "ozFTU101PaIcS8QinZNEFxQGnAi+9R0+NWyf97pMMG0tS5VOSqVV3aVxZTYK" +
           "YHWujrhxt79aeakyrC07zqQ73ICFZyUOHU1ZuzKK1aUcNb0NA/fC4qjbb1Ym" +
           "K7XrxFWQcRCXROACn1QijQ0E09nQwhJu6RuwY2mtVlHUcErKyG5Wy5uW4hup" +
           "AZKOX6LmoBCPDESW43i5mI6nLRkvjcGu4q3ZduMdr2zHd2++uT26ZwAbvWyC" +
           "egU7neTmC4KN90XPd0OwuVeV5OikLz/zuPs2J33HTkPOHO6w91/2iJf3soOP" +
           "gwPebDf48K2uI/Kd4Kff99zzCv+Z4t7B4dMEbP4Pbol2y+8BMm+69ZaXy69i" +
           "diciX3nfvzw0fJv+rldw5vvoKSZPk/wd7oWvUW+Uf2MPOnt0PnLDJdFJpGsn" +
           "T0Uu+WoY+c7wxNnIw0fWuJwp/wmg6ScPrPHkzc9db27h3KW2jnSbg734NnN5" +
           "swqhu/Tcclsr5pCDY243Btvv2DWUnT/6L7fzPr5QPuAcyfxANgi87sz+gcz7" +
           "//cyv/82c89kzXtC6B5NDZtqIPuGd3gmTe0kfO8rkTAJocunLjkOQ+exlwsd" +
           "4OQP3nDBur0UlD///OULr31+9Nf5fcDRxd1FFrqwiCzr+OHbsf55z1cXRi7q" +
           "xe1RnJc/ng2h192GmRA6lz9zxj+8RflICN1/UxTgENnjOOzHQujKaVhAM38e" +
           "h/tECF3awYG433aOg3wyhM4CkKz7Ke8mp3zbI8vkzLFcceBluenueznTHaEc" +
           "v13I8kt+H36YC6Ltjfh1+QvPt7vvfqnyme3thmxJaZpRucBCd24vWo7yyeO3" +
           "pHZI6zz91E/u+eLFJw8T3z1bhncef4y3R29+fdCyvTA/8E//8LW//5bfev7b" +
           "+aHj/wDA6G0WqCAAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5a6zkVnneu9nN7pJkN4GENJAnC20YdD1jz4xntECZ99jz" +
           "sMf2jMcuZeOxPX4/xo+xxzQtINHQIkFUAgUJ8gvUFoVHq6JWqqhSVS0gUCUq" +
           "1JdUQFWl0lIk8qMUlbb02HPvnXvvPqKo7UhzfHzO933ne/s757zwA+hc4EMF" +
           "z7U2quWG+0oS7htWZT/ceEqwTwwrlOgHityyxCBgwdh16YkvXv7RT57VruxB" +
           "5wXo1aLjuKEY6q4T0ErgWmtFHkKXd6MdS7GDELoyNMS1CEehbsFDPQivDaFX" +
           "HUMNoavDQxZgwAIMWIBzFuDGDgog3a04kd3KMEQnDFbQL0NnhtB5T8rYC6HH" +
           "TxLxRF+0D8hQuQSAwoXsfQaEypETH3rsSPatzDcI/NEC/NxvvuvK752FLgvQ" +
           "Zd1hMnYkwEQIFhGgu2zFXih+0JBlRRagex1FkRnF10VLT3O+Bei+QFcdMYx8" +
           "5UhJ2WDkKX6+5k5zd0mZbH4kha5/JN5SVyz58O3c0hJVIOsDO1m3EnazcSDg" +
           "JR0w5i9FSTlEucPUHTmEHj2NcSTj1QEAAKh32kqouUdL3eGIYAC6b2s7S3RU" +
           "mAl93VEB6Dk3AquE0EO3JJrp2hMlU1SV6yH04Gk4ajsFoC7mishQQuj+02A5" +
           "JWClh05Z6Zh9fjB+64fe7fSdvZxnWZGsjP8LAOmRU0i0slR8xZGULeJdbx5+" +
           "THzgyx/YgyAAfP8p4C3MH/zSS+94yyMvfnUL87qbwJALQ5HC69KnF/d88/Wt" +
           "J+tnMzYueG6gZ8Y/IXnu/tTBzLXEA5H3wBHFbHL/cPJF+s/593xW+f4edAmH" +
           "zkuuFdnAj+6VXNvTLcXvKY7ii6Ei49BFxZFb+TwO3Qn6Q91RtqPkchkoIQ7d" +
           "YeVD5938HahoCUhkKroT9HVn6R72PTHU8n7iQRB0D/hDb4WgM1Uo/22fIcTA" +
           "mmsrsCiJju64MOW7mfwBrDjhAuhWgxfA6004cCMfuCDs+iosAj/QlIMJ0fMC" +
           "OFirngePRN3Zz5zL+/8hm2TSXInPnAGKfv3pMLdAhPRdS1b869JzUbPz0uev" +
           "f33vyO0P9BBCRbDS/nal/Xyl/Wyl/Xyl/Wylq21X4nQ51PqiIwPbQGfO5Au+" +
           "JuNga1VgExNEN8h7dz3J/CLx1AeeOAvcyYvvyNQKQOFbp9/WLh/gedaTgFNC" +
           "L348fu/sV4p70N7JPJpxDYYuZehUlv2OstzV0/FzM7qXn/nej77wsafdXSSd" +
           "SMwHAX4jZhagT5zWr+9KigxS3o78mx8Tv3T9y09f3YPuAFEPMl0I1JclkUdO" +
           "r3EiUK8dJr1MlnNA4KXr26KVTR1mqkuh5rvxbiQ3/D15/16g47dB2+akK2ez" +
           "r/ay9jVbR8mMdkqKPKm+jfE+9Td/8c9oru7D/Hv52BeNUcJrx2I+I3Y5j+57" +
           "dz7A+ooC4P7+49RHPvqDZ34hdwAA8YabLXg1a1sg1oEJgZrf/9XV337n25/+" +
           "1t7OaULw0YsWli4lWyF/Cn5nwP+/s38mXDawjdf7WgdJ47GjrOFlK79pxxvI" +
           "HxYItsyDrk4d25X1pS4uLCXz2P+8/MbSl/71Q1e2PmGBkUOXesvLE9iN/0wT" +
           "es/X3/Xvj+RkzkjZ92unvx3YNim+eke54fviJuMjee9fPvyJr4ifAukVpLRA" +
           "T5U8S0G5PqDcgMVcF4W8hU/NIVnzaHA8EE7G2rE647r07Ld+ePfsh3/8Us7t" +
           "yULluN1Hondt62pZ81gCyL/2dNT3xUADcOUXx++8Yr34E0BRABQlkMMC0gfJ" +
           "JznhJQfQ5+78uz/50wee+uZZaK8LXbJcUe6KecBBF4GnK4EG8lbi/fw7tu4c" +
           "XwDNlVxU6Abhtw7yYP52FjD45K1zTTerM3bh+uB/kNbiff/w4xuUkGeZm3xe" +
           "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" +
           "ZJG1IaQgAAA=");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "c5hmzSgjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "R+4F/9BqHzrmH8A9eeZPndH6T7xNrX8AXNLBsNJdtP4zb0XrV5JI9mLVB0R5" +
       "KO37b1tjx3XAy9Lh7RkEn3lTBMWIBeFdqOw39uH8+efvxWMFKZzisHfbjnrj" +
       "MNASgcjAZdywncadqAx/ywIBg3v4OPpgfM+4+ZP/+dO/8zef/TKwLrp0YZVH" +
       "psBgTkTogzTfSfz4668++cArX/nJ4vUPaFb88b9X/dO81198e7CeyGEJBc0z" +
       "cpywxRubruXIii7aJ/BQCXjvAyL+udEmjzxH1eIefvhjJpKM4pNMcaqNZjdr" +
       "bOMa16pR1Rbs+0xi8azYrlUpfaNTujqjcZFXEJdeJZUsnXu84+ppeco2eUqc" +
       "8/PuxKfLRIiN6r05r3TZiLRYM+BEqj7NeoE/TyacMNmiRL8/ZbOkt0RXaV2q" +
       "zvUyjIdzOXWDxqJRboQQBmnItkbZAbveCOOROO3xCVs3xLpGz1cVXh4MyEAI" +
       "ZKQdz0l0nPQDtpxCsrnSJWuSwV5ikWNkE9DdNJuGdLiuufLA7wYs7IoB5hBz" +
       "zsfKy64tUrSs+NNgDfdFabRxcHE6JTHd71lrXKFtukNa4+6YnPjbisuu1qyl" +
       "kl1cQCW+M6wx48a4KzD6ihyYWtM09Ca8HbaXhFNlailfTkxXFoV+ELgW7w77" +
       "meZvacex6sOwEvTDLcFW1htSQlyhQiBK1xkKtK/L29SqYysKBEO9wLBkKRoO" +
       "qdV06kZB3TIHWcfShljowIGAOIsN7rB8z+H0+VKR53FlORn4VSIw6lXG5LkZ" +
       "PES0fjBGy+u1VBc3HCwTJO2tZk2BGxOOw2CjkTyfi/3AHgxhlVRSzUl5UUUj" +
       "oqbBDrzNqjPExnQujayg0+BbAa6Sc9OIO0u11QnGHCbAQ7NHu741bhmVyWjS" +
       "GvBiX1TF1diWZAEhhGlrNWnMY6qVdLqDVahGfQy3m6TsSrKsTBcymU4oCWqG" +
       "pCgs6VUH3er8RNVStsZ2rQAnKTfG+YpUH04Uh4RbxGBrZKZEJWnawlu4JwmW" +
       "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" +
       "9aR0nytb3h03yVa+pR1r/J+/2f7YyQHO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("oC4OqeSfO4wD1MbbQF3gee6OgE/i+Tf3KPuDPPnXSel8lBYnWP7VMawv/QVg" +
       "FRvJT4Pr4wewPv52YaVvCuuP71H2J3nyH5PSlSCyvGSSf9s6g+4P/6LoroPr" +
       "1QN0r/6/R/eNe5T99zz5alJ6oEBH6fLBlvkJeF97O/AyYNL5Ibb8RM7jtx2E" +
       "3R3eVD//2tVL735t8ge7szGHBywvM6VLi9RxTp6IOHF/MYj0hVUIfXn3sTUo" +
       "/r6TlL7vHl8mk9KF4r+Q9Nu7Jv8zKT12xyZA+PzvZN0/S0rXztYFfRb/J+t9" +
       "D1jIcb2kdHF3c6LKuT2wNkCV/PZ8cPgZ48Ru/e4cSXbuNEkezcOjbzYPJ3j1" +
       "2VMfjYpzy4enAdLRwbepL7xGDz76rfov7E6lqY683ea9XGJK9+8OyBWd5icK" +
       "nrlrb4d9XaSe/+7Dv3L5fYdM/fBO4GPbPSHb03c+AtZxg6Q4tLX9x+/+hx/8" +
       "xdf+qPhc8X8Bxr9m5lAuAAA=");
}
