package org.apache.batik.anim.values;
public class AnimatableBooleanValue extends org.apache.batik.anim.values.AnimatableValue {
    protected boolean value;
    protected AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableBooleanValue(org.apache.batik.dom.anim.AnimationTarget target,
                                  boolean b) { super(target);
                                               value = b;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableBooleanValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableBooleanValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                result;
        }
        boolean newValue;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableBooleanValue toValue =
              (org.apache.batik.anim.values.AnimatableBooleanValue)
                to;
            newValue =
              toValue.
                value;
        }
        else {
            newValue =
              value;
        }
        if (res.
              value !=
              newValue) {
            res.
              value =
              newValue;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public boolean getValue() { return value;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableBooleanValue(
          target,
          false);
    }
    public java.lang.String getCssText() {
        return value
          ? "true"
          : "false";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO9vnD2z8QTCUDwPGUJmQu1JCaWSaxjgQTM7Y" +
       "wg4qhuaY252zF+/tLrtz9tkpIURqQVGFUiCUtsF/tERtEAFUlbZKG0r6kRCl" +
       "KYWiJgGFtM0fSZughj8ap6Vt+mZm93Zv7yO4VOpJO7c3896befN+8z7mjl9D" +
       "ZZaJmg2syThMRw1ihXvYew82LSJ3qNiy+qA3Jj32xwO7Jn5XuTuIQv1o6iC2" +
       "uiRskbUKUWWrH81VNItiTSLWBkJkxtFjEouYw5gqutaPpitWZ9JQFUmhXbpM" +
       "GMEmbEZRPabUVOIpSjptARTNi/LVRPhqIu1+grYoqpZ0Y9RlmJXF0OEZY7RJ" +
       "dz6LorrodjyMIymqqJGoYtG2tIluN3R1dEDVaZikaXi7usLeiPXRFTnb0Hyq" +
       "9oMbjw/W8W2YhjVNp1xFayOxdHWYyFFU6/auUUnS2oEeRiVRNMVDTFFL1Jk0" +
       "ApNGYFJHX5cKVl9DtFSyQ+fqUEdSyJDYgihakC3EwCZO2mJ6+JpBQgW1defM" +
       "oO38jLaOuX0qPnF75ODXH6z7fgmq7Ue1itbLliPBIihM0g8bSpJxYlrtskzk" +
       "flSvgcF7ialgVRmzrd1gKQMapimAgLMtrDNlEJPP6e4VWBJ0M1MS1c2MegkO" +
       "KvtXWULFA6Bro6ur0HAt6wcFqxRYmJnAgD2bpXRI0WSOo2yOjI4t9wMBsJYn" +
       "CR3UM1OVahg6UIOAiIq1gUgvgE8bANIyHSBocqwVEMr22sDSEB4gMYpm+ul6" +
       "xBBQVfKNYCwUTfeTcUlgpVk+K3nsc23Dqn0Paeu0IArAmmUiqWz9U4Cpyce0" +
       "kSSISeAcCMbqJdFDuPG5vUGEgHi6j1jQ/OhL1+9Z2nT2nKCZnYemO76dSDQm" +
       "HY1PvTCno/WuEraMCkO3FGb8LM35KeuxR9rSBniaxoxENhh2Bs9ufGHzI8fI" +
       "u0FU1YlCkq6mkoCjeklPGopKzPuIRkxMidyJKokmd/DxTlQO71FFI6K3O5Gw" +
       "CO1EpSrvCun8N2xRAkSwLaqCd0VL6M67gekgf08bCKFyeFA1PHOR+PBvimhk" +
       "UE+SCJawpmh6pMfUmf7MoNznEAveZRg19Egc8D90x7Lwyoilp0wAZEQ3ByIY" +
       "UDFIxGAEhCQjw1hN8aOuJDHFcZWs1nWVYG0T6w8z9Bn/p3nTbD+mjQQCYKo5" +
       "fkehwhlbp6syMWPSwdTqNddPxF4WIGQHx95JipbD5GExeZhPHmaTh8Xk4fyT" +
       "o0CAz3kbW4SABhh2CFwE+Ojq1t4vrt+2t7kEMGmMlIJVgkC6OCdmdbi+xAkA" +
       "Men4hY0T51+pOhZEQXA3cYhZbuBoyQocIu6ZukRk8FyFQojjRiOFg0bedaCz" +
       "h0d2b9r1Kb4ObyxgAsvAjTH2HubBM1O0+H1APrm1e9754OShnbrrDbKCixMT" +
       "cziZk2n2W9ivfExaMh+fjj23syWISsFzgbemGE4XOMIm/xxZzqbNcdxMlwpQ" +
       "OKGbSayyIcfbVtFBUx9xezj06vn7bWDiqez0tcDzSfs48m822miwdoaAKsOM" +
       "TwseGD7Xaxx57Td/Xs6324khtZ7g30tom8dvMWEN3EPVuxDsMwkBujcO9xx4" +
       "4tqeLRx/QLEw34QtrO0AfwUmhG3+8rkdr7959eilYAazAYoqDVOncIiJnM7o" +
       "yYZQTRE9GdTdJYHrU0ECA07LAxoAU0ko7DCxc/LP2kXLTr+3r05AQYUeB0lL" +
       "P16A2/+J1eiRlx+caOJiAhILve62uWTCn09zJbebJh5l60jvvjj3Gy/iIxAZ" +
       "wBtbyhjhDjYgtoFrPpOi1hw3IetJ4SqEj4A5+rA5QCi39J2cL8Lb5WyLuDTE" +
       "xz7LmhbLe2KyD6UnqYpJj196v2bT+2euc/2yszIvQLqw0SYwyZpFaRA/w++d" +
       "1mFrEOjuPLtha5169gZI7AeJEnhgq9sEP5nOgpNNXVZ++flfNG67UIKCa1GV" +
       "qmN5LeYnE1XCkSDWILjYtPH5ewQcRiqgqeOqohzlmQXm5bftmqRBuTXGfjzj" +
       "B6u+O36VI5FLmJsB3xQmZQE8YRt84fyHjLWLedvKmqUOoENGKg5JvQ/NVUUE" +
       "+qwYFO6c/VzB7efx6axQ6E3FLdpjKkk4pMN2GnOycWLHL8vH7nVSlHwsgvJ+" +
       "q+v8s+vejnEnUMF8P+tnk9V4vHq7OeDxQHVCl4/gE4Dn3+xhOrAOkRA0dNhZ" +
       "yfxMWmIYDB6tReqIbBUiOxveHHrynWeECv60zUdM9h587KPwvoPiWIvcdmFO" +
       "eunlEfmtUIc1XWx1C4rNwjnWvn1y50++t3OPWFVDdqa2BgqRZ37/r1+HD//h" +
       "pTxBvzwuonnGss5pZymfz0JCrdCyI3/f9ZXXuiGydKKKlKbsSJFO2SsXEnQr" +
       "FfeYzM2ceYdXQWYeigJLwBK8u7OIu9jKmtV86C7WdAj8rrq5I8c62gXH7IyO" +
       "83OSEV4Zu3H0vSvfeutnE98pF3tbBCk+vpn/6Fbjj/7pwxxnxdOGPODx8fdH" +
       "jj85q+Pudzm/G78Z98J0bo4HGY7L++ljyb8Fm0O/CqLyflQn2VUoz9cgKvZD" +
       "5WU5pSlUqlnj2VWUKBnaMvnJHD96PdP6MwcvHEpplul9ycIceJptt9Ps92MB" +
       "xF+E2MWsWZIbggtxU1TGs1f2I+p6RA6ewSLgSbuzrcnMxj8h5Ksz/C5ytg03" +
       "wNbcQqUgP7RHHz04Lnc/tSxog7sP0gyqG3eoZJioHlEh7gL8KO3iBbBr8pUX" +
       "J0qu7J9ZnZstM0lNBXLhJYXh7J/gxUf/Mqvv7sFtk0iD5/n094t8uuv4S/ct" +
       "lvYHeQ0vEJZT+2cztWXjqsokNGVq2Y6lOWOx2cwSi+FZaVtsZZEomW3sTDws" +
       "xOpzU2XcVmVOjrT0JkupTQ46d3HO9bbTZ1/dnvdeys6WjqnfS7Ofm9M3JaBE" +
       "0Qqwc/6Hi/jdr7JmlKIp/MYGDASh052Tn6axybti3p3K7Pg0ZFusz97xvskb" +
       "qxBrEd0OFRk7zJqvUVQBuWzGUlFX6f3/G6VnwbPVXvnWyStdiLWIYt8uMnaU" +
       "NUcgMZCw1oMlv87jt6xzvWNo2V64PHmdC7H69PLAfBeXeqKI4qdY8zRFVbIi" +
       "nE0fv3Da7ep+7JZ15x6JFYpDtgJDk9e9EGsR1Z4tMvZT1pymqBpA3k9M3eeS" +
       "uOI/vGXFG9gQC/SmvXpz8ooXYi2i3AtFxs6x5nmwNyjeAYEZQqDjvut4acZS" +
       "oLC4SHa34uf/Rc4JlXj+2zNWBs7MudYXV9HSifHaihnjD7zKb3Ay18XVUBAl" +
       "Uqrqza487yHDJAmF61ctci2Df12A5K1YTIKSULxwHX4rmC5RND0vE0Wl7MtL" +
       "+yrsmp8Wohb/9tJdhg136WBa8eIleQOCFZCw16uGOLuB7NwqY43pH2cNTzq2" +
       "MCvZ4f+5OIlJSvzrAiXq+PoND13/zFPi9klS8dgYkzIFKhpxEZZJbhYUlObI" +
       "Cq1rvTH1VOUiJ8GrFwt2cT7bA8Z2cFMGg8Ms372M1ZK5nnn96Kozr+wNXYSS" +
       "YAsKYIqmbcnN1dNGCjKvLdF8tRukfvzKqK3qrW3nP7wcaOBXC0hUQk3FOGLS" +
       "gTNXehKG8c0gquxEZZC/kjQvJO4d1TYSadjMKgVDcT2lZf6emcqwi9kx4jtj" +
       "b2hNppfdXlLUnFsZ597oVqn6CDFXM+lMTI0vHUwZhneU7+wXWNOVZjsNuIpF" +
       "uwzDuRKYz3feMDjI/sqazf8BOyrTm1gdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "M78j+T//cK3uiigAAA==");
}
