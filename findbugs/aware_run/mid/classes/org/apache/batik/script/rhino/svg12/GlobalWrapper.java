package org.apache.batik.script.rhino.svg12;
public class GlobalWrapper extends org.apache.batik.script.rhino.WindowWrapper {
    public GlobalWrapper(org.mozilla.javascript.Context context) { super(
                                                                     context);
                                                                   java.lang.String[] names =
                                                                     { "startMouseCapture",
                                                                   "stopMouseCapture" };
                                                                   this.
                                                                     defineFunctionProperties(
                                                                       names,
                                                                       org.apache.batik.script.rhino.svg12.GlobalWrapper.class,
                                                                       org.mozilla.javascript.ScriptableObject.
                                                                         DONTENUM);
    }
    public java.lang.String getClassName() {
        return "SVGGlobal";
    }
    public java.lang.String toString() { return "[object SVGGlobal]";
    }
    public static void startMouseCapture(org.mozilla.javascript.Context cx,
                                         org.mozilla.javascript.Scriptable thisObj,
                                         java.lang.Object[] args,
                                         org.mozilla.javascript.Function funObj) {
        int len =
          args.
            length;
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        if (len >=
              3) {
            org.w3c.dom.events.EventTarget et =
              null;
            if (args[0] instanceof org.mozilla.javascript.NativeJavaObject) {
                java.lang.Object o =
                  ((org.mozilla.javascript.NativeJavaObject)
                     args[0]).
                  unwrap(
                    );
                if (o instanceof org.w3c.dom.events.EventTarget) {
                    et =
                      (org.w3c.dom.events.EventTarget)
                        o;
                }
            }
            if (et ==
                  null) {
                throw org.mozilla.javascript.Context.
                  reportRuntimeError(
                    "First argument to startMouseCapture must be an EventTarget");
            }
            boolean sendAll =
              org.mozilla.javascript.Context.
              toBoolean(
                args[1]);
            boolean autoRelease =
              org.mozilla.javascript.Context.
              toBoolean(
                args[2]);
            global.
              startMouseCapture(
                et,
                sendAll,
                autoRelease);
        }
    }
    public static void stopMouseCapture(org.mozilla.javascript.Context cx,
                                        org.mozilla.javascript.Scriptable thisObj,
                                        java.lang.Object[] args,
                                        org.mozilla.javascript.Function funObj) {
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        global.
          stopMouseCapture(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe5AUxRnv3Xsfd9wDeYTHAcdBFaC7AZ/UoREuPE73uCsO" +
       "0RzRpXe2925gdmaY6b3bwxCUVITyD8pSfMTApWIwRgvFSmKZR0mw8lBj1JJY" +
       "iUoiUf9Qg1bBHxETkpjv657ZeexDqbIqVzU9s93f93V/r9/X3XfkI1JjW6TT" +
       "pHqaxvi4yezYAH4PUMtm6R6N2vYm6E0qd759z+5zf2y4PUpqh8jkEWr3KdRm" +
       "a1Wmpe0hMkfVbU51hdkbGEsjx4DFbGaNUq4a+hCZqtq9WVNTFZX3GWmGBJup" +
       "lSBtlHNLTeU463UEcDI3IVYTF6uJrwoTdCdIk2KY4x7DzABDj28MabPefDYn" +
       "rYltdJTGc1zV4gnV5t15iyw1DW18WDN4jOV5bJt2uWOI6xKXF5mh88mWj8/f" +
       "NdIqzDCF6rrBhYr2RmYb2ihLJ0iL17tGY1l7B/kmqUqQST5iTroS7qRxmDQO" +
       "k7r6elSw+mam57I9hlCHu5JqTQUXxMn8oBCTWjTriBkQawYJ9dzRXTCDtvMK" +
       "2rruDql479L4gftvaf1xFWkZIi2qPojLUWARHCYZAoOybIpZ9qp0mqWHSJsO" +
       "Dh9klko1dafj7XZbHdYpz0EIuGbBzpzJLDGnZyvwJOhm5RRuWAX1MiKonF81" +
       "GY0Og67TPF2lhmuxHxRsVGFhVoZC7Dks1dtVPS3iKMhR0LHreiAA1ros4yNG" +
       "YapqnUIHaZcholF9OD4IwacPA2mNASFoiVgrIxRtbVJlOx1mSU5mhOkG5BBQ" +
       "NQhDIAsnU8NkQhJ4aWbISz7/fLRh5f5b9fV6lERgzWmmaLj+ScDUEWLayDLM" +
       "YpAHkrFpSeI+Ou2ZfVFCgHhqiFjSPP2Ns9de3HH8eUkzqwRNf2obU3hSOZya" +
       "/OrsnsUrqnAZ9aZhq+j8gOYiywacke68CUgzrSARB2Pu4PGNv/vabY+x01HS" +
       "2EtqFUPLZSGO2hQja6oas9YxnVmUs3QvaWB6ukeM95I6+E6oOpO9/ZmMzXgv" +
       "qdZEV60hfoOJMiACTdQI36qeMdxvk/IR8Z03CSF18JAmeBYR+SfenFjxESPL" +
       "4lShuqob8QHLQP3RoQJzmA3faRg1jXgK4n/7JctiV8ZtI2dBQMYNazhOISpG" +
       "mByM24qlmjxujaAse3R42fL4Os1IUe1Gi5oQFjGMPfP/MmsebTFlLBIBN80O" +
       "g4QG+bXe0NLMSioHcqvXnH0i+aIMQEwax4qcLIOpY3LqmJg6JqeOialjYupY" +
       "YGoSiYgZL8IlyKAAl24HcAB0blo8ePN1W/d1VkE0mmPV4A8kXVRUrXo8FHGh" +
       "P6kceXXjuVdeanwsSqIANCmoVl7J6AqUDFnxLENhacCscsXDBdB4+XJRch3k" +
       "+ANjt2/e/WWxDn8VQIE1AGDIPoDYXZiiK5z9peS27H3/46P37TI8HAiUFbca" +
       "FnEivHSG/RtWPqksmUefSj6zqytKqgGzAKc5hbwCCOwIzxGAmW4XslGXelA4" +
       "Y1hZquGQi7ONfMQyxrweEXht4vsicPEkzLsZ8Cx1ElG8cXSaie10GagYMyEt" +
       "REm4etA89PrLH1wqzO1WjxZf2R9kvNuHWCisXWBTmxeCmyzGgO6vDwzcc+9H" +
       "e7eI+AOKBaUm7MK2B5AKXAhm/vbzO9449dbh16JezHIo2bkU7H7yBSWxnzRW" +
       "UBLj3FsPIJ4G+Y9R03WDDlGpZlSa0hgmyb9bFi576sP9rTIONOhxw+jizxbg" +
       "9X9pNbntxVvOdQgxEQUrrmczj0zC+BRP8irLouO4jvztJ+Z85zl6CAoCgLCt" +
       "7mQCVyNO3uKiZkD0IEJkjZ2qplEBOw5AOPsL4dvLBHFctJeiXYQIIsauwqbL" +
       "9udIMA19G6ikctdrZ5o3nzl2VigV3IH5Q6KPmt0yCrFZmAfx08N4tJ7aI0B3" +
       "2fENX2/Vjp8HiUMgUQG8tfstwMV8IIAc6pq6N5/99bStr1aR6FrSqBk0vZaK" +
       "XCQNkATMHgFIzZtfuVbGwFg9NK1CVVKkPJp9bmmHrsmaXLhg58+m/3TlIxNv" +
       "idiTwTbLYRc/FmGzpBCE4q82XPL8QRiQYJE55XYlYkd1eM+BiXT/w8vk3qE9" +
       "WOnXwEb28T/95w+xB/72QonC0cAN8xKNjTLNN2c1TDm/COz7xKbNA6orT5yr" +
       "Onn3jKZinEdJHWVQfEl5FA9P8Nyev8/cdM3I1gsA8LkhQ4VFPtp35IV1i5S7" +
       "o2LfKbG7aL8aZOr2mwwmtRhssHVUC3uaRfh2Flzbji7rgGe549rlpUG0RFQU" +
       "oKkca4Xs3FRhbDM2/Zw0DTMuAmcDaOPCQquIbNxzx+SeWwyswGZAxu7Kz5cl" +
       "2LFKdF8fNMZMeK5wNLriwo1RjrWCwqkKY2lsbuZwPDOkvvj7Jk/pW74YpVfA" +
       "40ggV1dQWrSLsblYyIzi5yVQt2xx+AvVrTZXWgmpIZ2rZSLjz8tdX88vUwIG" +
       "xQurko3HVF/e453BYC5lc1Fs5Enl51M++MkLW+vekGjTVZI8dAB659YXHzL+" +
       "cjrqHm5KsUjK6+2+V36x/r2kSPl6xJRCovnwZJU17NvBtJoIkQvL44pv8RM/" +
       "XPDy7okFb4sqUq/agEwgrMS5z8dz5sip0yea5zwhNmTVuCZnPcEDc/F5OHDM" +
       "FUttcYpDMPHkya7gukhhwz2vCIPFvY8HZx+e/O67vzr3gzpp2MXlTRDim/Gv" +
       "fi21551PisqzQNYSJ9oQ/1D8yMGZPdecFvzeHhW5F+SLTzFgZY93+WPZf0Q7" +
       "a38bJXVDpFVx7lg2Uy2HO78hsKPtXrwkSHNgPHhHIM3WXcDx2WEc900b3h37" +
       "Eb2aB7C8zcxHiMipb1XO0ZqMqlPNSdFP4S8Cz3/xwdTEDnzDmnuc0/S8wnHa" +
       "hMpbqzF9mI/YFf02YKlZ2C2POokU39V+avvB9x+X/g47KUTM9h2489PY/gOy" +
       "6su7mQVF1yN+Hnk/I5MKm715sRGoMIvgWPve0V2//NGuvVEHY9dxUgXJgJ/j" +
       "TsBjXEel9dwEmOIlQI9m6EzgjzMmD6WqEStccMFgvihDBPCaYs5xXxERS69Q" +
       "Ax6sMHYQm/vBuQquSapQgfx7sgT4aoOXvdPCOCfdUrvs0D933/F6P8BJL6nP" +
       "6eqOHOtNB0Oyzs6lfMDn3Vx5Yeo4CMOMk8gS00OWuWVgfm1OF/tWwV5JqUew" +
       "UTkcDTm1eJ+Rs1kPNcW1Io7c6YQGvvZzUj1qqGmvgG77YgroVfBscUrdTRdc" +
       "QLHJliieN5WRWKF4YrMDm1FsDou5n6pgvKexOQr4bsPO2m877H/Us9OTF26n" +
       "PCfNgTscPJrMKLpWllehyhMTLfXTJ274syxb7nVlE5TVTE7T/Pjn+641LZZR" +
       "hSJNLhri6xhAx+e4YoK8EW+hwDOS9VlO5lRkBSbx9jP9hpPpZZhwcyQ+/PTP" +
       "gcHD9CBXvP10v+ek0aMDUfLDT/ISoBeQ4OfLpptTSysrfyOgoDHmeCUfKT4A" +
       "CpdP/SyX+058CwI1QfyHwUWSnPwfQ1I5OnHdhlvPXvGwvHFRNLpzJ0qZBPgh" +
       "L38Kx6L5ZaW5smrXLz4/+cmGhS6Gt8kFe5k2yxfjqwDgTAy+maHrCLurcCvx" +
       "xuGVx17aV3sCqs8WEqGA91uKa3fezMGZbUuiFFJC9RY3Jd2N72595ZM3I+3i" +
       "cO1ga0cljqRyz7GTAxnTfDBKGnpJDTiH5cXG4qvj+kamjFoB4K1NGTm9sI2b" +
       "jJlC8WQgLOMYtLnQizd2nHQW19HiW8xGzRhj1mqU7gB54CCZw2DxRoVlvy+x" +
       "VW4cqpKJPtN0NhJ1dwjLm6bAgrexeeh/HQZKXUYcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
