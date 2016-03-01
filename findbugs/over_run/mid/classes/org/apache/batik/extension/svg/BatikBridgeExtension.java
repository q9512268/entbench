package org.apache.batik.extension.svg;
public class BatikBridgeExtension implements org.apache.batik.bridge.BridgeExtension {
    public float getPriority() { return 1.0F; }
    public java.util.Iterator getImplementedExtensions() { java.lang.String[] extensions =
                                                             { "http://xml.apache.org/batik/ext/poly/1.0",
                                                           "http://xml.apache.org/batik/ext/star/1.0",
                                                           "http://xml.apache.org/batik/ext/histogramNormalization/1.0",
                                                           "http://xml.apache.org/batik/ext/colorSwitch/1.0",
                                                           "http://xml.apache.org/batik/ext/flowText/1.0" };
                                                           java.util.List v =
                                                             java.util.Arrays.
                                                             asList(
                                                               extensions);
                                                           return java.util.Collections.
                                                             unmodifiableList(
                                                               v).
                                                             iterator(
                                                               );
    }
    public java.lang.String getAuthor() {
        return "Thomas DeWeese";
    }
    public java.lang.String getContactAddress() {
        return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() {
        return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.bridge.BridgeContext ctx) {
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikRegularPolygonElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikStarElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikHistogramNormalizationElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.BatikFlowTextElementBridge(
              ));
        ctx.
          putBridge(
            new org.apache.batik.extension.svg.ColorSwitchBridge(
              ));
    }
    public boolean isDynamicElement(org.w3c.dom.Element e) {
        return false;
    }
    public BatikBridgeExtension() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "df3xgMk/Oj8mz4ZHcvSWxm9yJdYqZv20ytjPsTnCyBQw+Upqy5Zqumdmn+kP" +
       "f27TJ+FQFJ6so392/KZXYg2YFyo+ssyrfmRx7rW5+KeqOOoZbB5npMmiGTh+" +
       "QQUjZcSq2ILNYuEhiZEJw4aqeK574nO7bioOIUzc5Nh/0/hdV4m1uuumoutG" +
       "lsoRxchGVosihQt7sYqjTmHzPECnal85CmWgKjucnHrQ56yA4+pShqFRSf+s" +
       "Leh34/donpELyl074kF7Rsn/IeIOX37kYHP99IPX/YlffRXu2ZvgoJDOaZqv" +
       "wPUXu7WmRdMqd0STuIsw+dcbjHRUvxdlpAZabsDrgudtRmZW5oHtqvDu5/or" +
       "uD7IBYU9//bTnWak0aMD0BMvfpL3QScgwdcPzDJbovgrIB8qvX3ggZr2WYEq" +
       "sPgv3rCo4f9kucVpLuHUTkcPrlt/45nlh8XFn6xJY2M4yyQ4YojrxcKJek7F" +
       "2dy5atfOPzfl0YZ5bnlUdPHo143nD2Qhv6SbGbgJs7sKF2KvHFr59Au7a09B" +
       "YbeZhCCdp272/Y8kPNWdN3NQ12+OlztMbZQsfknX3fjO1hP/eDXUxm92iDh+" +
       "dVTjSMp7nn4tkTbN74VJQ4xMhKMdzQ+SRr4A+6k8bBWdzWpTRk4v/Ok1BRNb" +
       "wtKGe8Zx6ORCL94JM9JZev4svSdv1IwRaq3C2XGayYE7iJxp+ke5Z6mAAPQ0" +
       "5Foy3meazlVp7Sj3vGnyFfwJB4H/APpcAiyuHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OYqbr4aaalXReZbK2WTRZv1aEzGnk3lr1+WDJivgM1edo6tZTOCTSMqzpowi" +
       "kh1iYjbKtvNlaJkuWbOiBE4EvFmH+8F4mbdMJBvA05DD0y5B5Ts9mCnweIJ3" +
       "/EzottXY6QayRrPtzmpal8LddEgLs7g7JGd5WreGA6a2hcc61RpvU2S17tWD" +
       "SBICL8xc36uJtcBIpH5UMxdssszxeUsKGktuio5Y3Msztt6rIzA92fjbiUpJ" +
       "O7LHkkutP0Q2WkXjG4g0JaOxG+7qU3uUzNnpxIvqCQEvm8wmmldWNU4i5OGm" +
       "xowQKe7iFVXDl8IiEDpkx0EwRm2imCm2E6zVy7NWN+91PRnjsbBJ0oMVojSE" +
       "OWpKsYMsUkFy4np9l8iplm19mWHZLE8bftUw85bjGXxtUm8xOry2driQjWuZ" +
       "YTpiBR2TmekzIyxZ9Na5u0oEQdMDQeqtw/oYF1rSphcnW70Dq7GXqVk326wy" +
       "yx5aA8LZ5hiSo7KNEpRu6jlrNeeyX7VjqS5wAc46Ct4T3e4Mpsb9Kr9h5ZCq" +
       "8lmAhI0A0fCdjFRGZlsGEdpGXSOiIA5S2Rw6gxrJykiLnOi1dtNY1HNr5CIT" +
       "h/B3qNLX17yY+80tY8grZV2rbFOHTWYBtW1NN/A8Wm0byirzDT+AXXZRw2cM" +
       "3J12GSwJ680aMlAk2arJ3W0IJ8k2XvhcjsdiAx6Yq8kkVLRWI4hGvt2bLeHp" +
       "dO4oOr+q0cOxnHWWttJhNqi6MgcNHA0muGaHE3q+0xvjJVJBloaA+tUsy/ww" +
       "S3teEnK5vuwJYWIvpymeyCtn5vd3bIcC38REg/JFa+BketCPpw1sS6JwxC9X" +
       "XY5fwMnQXNZRxAiDqDPcehUcdbs4lwQIbdITqY67cp9tNmlWQmRvseCkrKas" +
       "rZBpT1Rltd6wcynDRZ8zRiujws8yOtnAhq45fW6+zg0vIhVVS9qxlRkp5yti" +
       "I+ynq3U7ayBhnLVxuiXPmwiizQJRdSvqqF1pjdaLaFif8rq1MXR212a0cG3F" +
       "dItYraW6ZSlxTZQ7q4S11vWYAmtT0810IRpm/fnM1dnYSxG0EXhLQuoGWM7I" +
       "tRG63U5ROXTiXB8wpot3a8a2oabAV+0WXkVWGlrgzQ22H1bRetCuTZdrjNd6" +
       "msUkeDLo1gbA28SNJpnhaqXZkjVTWVKUEdXwGiITLjsWjXF9PK3W4Im3S0ea" +
       "Mk0WbiDVF86kumQRsy3Nge3UQGAKG8LM4UcRHgRo6s60MY4KzBTNR8vByNhN" +
       "YZ6LURLGXEJricZOjGaci66RiVttcWNtkw56JqHk2ISjhk2UGTUZxVyjyZo3" +
       "1lV6w6ngW6Am9dSt3MFtJo9g12womE+S7LTS6Ibbum+qO0+IcN6pr3vBtrvY" +
       "MC20j5BspJP2NutbJFl89n7NF7bz8EC5yXJ8aOZ4eFHR+wK+uPdVjxfJE8cb" +
       "y+XvygUby6c23y4dbeh86Q2HClp5gnBw7iCh2HV43a3Ozsodhw+989nnjMkP" +
       "VS8fbnKKKXR3GkZv8cy16Z0a+i7Q05tuvbsyKo8OTzbffv2df//I7CuXb/8C" +
       "jhdef47P813+6Oj53+x9if49l6HbjrfibjjUPEv01NkNuHtiM83iYHZmG+51" +
       "x5ootfFa8LzlUBNvufkW/02t5lJpNXtbuWAPOb2gbl0kYQrda5kpG9thbKfb" +
       "siF3yrCEYu/PC9X0xOSiz7fJc3qgssA7xvzKovDN4GkcYm68/Ji/5YK6by2S" +
       "b0ihhwFm2o880zeD1DSODTg5s2121uw4dVPa8tP6z0w/9YkP7j76/H5XTFMT" +
       "M4XgW10puPFWQ3H29MQF52cnh83/0vvyF/7ur4SvPZot9x4L8t4C0kMXCfJo" +
       "7j54slVPp2Z5OlPUfOeJQr/xJSj0waLwi8FDH/JBv/wKff8FdR8oku8GTgQo" +
       "lMzAZCzB9U7Afc9LBfdG8LCH4NiXH9wPXlD3oSL5IFgKALjiBoiqp6RhxGaS" +
       "nAP53EsF+TB4pEOQ0ssP8iMX1H2sSH40ha4AkHNueA7Zh18qssfAox4iU19+" +
       "ZD97Qd3PF8nHU+h+gKxtJnpsR0dnracQ/uRLQFh6gaLeP0TovzwIL51d/p+4" +
       "ePk/vJxU9vRrF8jjt4rkl1Lovti07AT4oplqJTdbcW5fh7ZxIqFffgkSeuho" +
       "Cr/jUELv+D+R0EOFhDZ1/cAI/YPOflkp6f7oAnn8WZH8Xgpds5P2FsQNtn5I" +
       "eTOZ3KmFoWeqwYlYfv8LEUueQq+82dWP4uz64RvupO3vUekfee7qXa95bv5H" +
       "5e2H47tOdw+huxaZ550+ajyVvxLF5sIuAd69P3iMyr+/SaFHL76bkkK3gbRk" +
       "/a/3NJ9OoUduTQO8/nH+NNVngEjPU4Ewpvw/3e4fU+iek3bAA+0zp5u8CHgC" +
       "TYrsP0dHyj512Lg/q80vnYpcD02wVNGDn09FxySnr1UUEUF5m/AoMs3Yw8Dj" +
       "o88x469/Efuh/bUO3VN3u6KXu4bQnfsbJsfR7eO37O2oryv9Jz93/8fufuIo" +
       "trh/z/DJdDjF2+tvfm+i40dpedNh99Ov+Ym3/vBzf1Getv4vtpcLjuYpAAA=");
}
