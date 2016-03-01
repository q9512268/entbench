package org.apache.batik.gvt.flow;
public class BlockInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected java.util.List fontList;
    protected java.util.Map fontAttrs;
    protected float ascent = -1;
    protected float descent = -1;
    protected boolean flowRegionBreak;
    public BlockInfo(float top, float right, float bottom, float left, float indent,
                     int alignment,
                     float lineHeight,
                     java.util.List fontList,
                     java.util.Map fontAttrs,
                     boolean flowRegionBreak) { super();
                                                this.top = top;
                                                this.right = right;
                                                this.bottom = bottom;
                                                this.left = left;
                                                this.indent = indent;
                                                this.alignment = alignment;
                                                this.lineHeight =
                                                  lineHeight;
                                                this.fontList = fontList;
                                                this.fontAttrs = fontAttrs;
                                                this.flowRegionBreak =
                                                  flowRegionBreak;
    }
    public BlockInfo(float margin, int alignment) { super();
                                                    setMargin(margin);
                                                    this.indent =
                                                      0;
                                                    this.alignment =
                                                      alignment;
                                                    this.flowRegionBreak =
                                                      false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public void initLineInfo(java.awt.font.FontRenderContext frc) {
        float fontSize =
          12;
        java.lang.Float fsFloat =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        if (fsFloat !=
              null)
            fontSize =
              fsFloat.
                floatValue(
                  );
        java.util.Iterator i =
          fontList.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.font.GVTFont font =
              (org.apache.batik.gvt.font.GVTFont)
                i.
                next(
                  );
            org.apache.batik.gvt.font.GVTLineMetrics lm =
              font.
              getLineMetrics(
                "",
                frc);
            this.
              ascent =
              lm.
                getAscent(
                  );
            this.
              descent =
              lm.
                getDescent(
                  );
            break;
        }
        if (ascent ==
              -1) {
            ascent =
              fontSize *
                0.8F;
            descent =
              fontSize *
                0.2F;
        }
    }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public java.util.List getFontList() { return fontList; }
    public java.util.Map getFontAttrs() { return fontAttrs; }
    public float getAscent() { return ascent; }
    public float getDescent() { return descent; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1aD3QUxRmfu0ASQv6jgCD/QkABuSsCosaqIRCIXkJMgGpQ" +
                                                              "w+ZuLlnY211255IQQEWrom3Vp2i1Kk8tVqUotupr1afF2vrnWWu1Pv9Wpdo+" +
                                                              "tep70j7FP23t983s3e7t7a5emmfe27nNznzzfb+Zb74/M7P3IzLaNEidLqkJ" +
                                                              "KcI269SMtON7u2SYNNGkSKa5Gr52xy//6zXnH/rzmO1hUtxFKvskszUumbRZ" +
                                                              "pkrC7CJTZNVkkhqnZhulCaRoN6hJjX6JyZraRQ6XzZaUrshxmbVqCYoN1kpG" +
                                                              "jNRIjBlyT5rRFqsDRqbFuDRRLk200d2gIUbK45q+2SaYlEPQ5KjDtimbn8lI" +
                                                              "dWyD1C9F00xWojHZZA2DBpmna8rmXkVjETrIIhuUxdZAnBZbnDcMdfdWffrl" +
                                                              "VX3VfBjGSaqqMQ7R7KCmpvTTRIxU2V+XKzRlbiLnkaIYGetozEh9LMM0Ckyj" +
                                                              "wDSD124F0ldQNZ1q0jgclumpWI+jQIzMyO1ElwwpZXXTzmWGHkqZhZ0TA9rp" +
                                                              "WbSZ6XZBvHZedOePz63+ZRGp6iJVstqJ4sRBCAZMumBAaaqHGmZjIkETXaRG" +
                                                              "hQnvpIYsKfKQNdu1ptyrSiwNKpAZFvyY1qnBedpjBTMJ2Ix0nGlGFl6SK5X1" +
                                                              "3+ikIvUC1vE2VoGwGb8DwDIZBDOSEuieRTJqo6wmuB7lUmQx1p8ODYC0JEVZ" +
                                                              "n5ZlNUqV4AOpFSqiSGpvtBOUT+2FpqM1UEGD65pPpzjWuhTfKPXSbkYmutu1" +
                                                              "iypoNYYPBJIwcri7Ge8JZmmSa5Yc8/NR20lXbFFXqmESApkTNK6g/GOBaKqL" +
                                                              "qIMmqUFhHQjC8rmx66Txj+wIEwKND3c1Fm1+tfXgqcdM3f+UaDPZo82qng00" +
                                                              "zrrju3sqnz+yac4JRShGqa6ZMk5+DnK+ytqtmoZBHSzN+GyPWBnJVO7veOKs" +
                                                              "C/bQD8KkrIUUxzUlnQI9qolrKV1WqLGCqtSQGE20kDFUTTTx+hZSAu8xWaXi" +
                                                              "66pk0qSshYxS+Kdijf8PQ5SELnCIyuBdVpNa5l2XWB9/H9QJISXwkHJ46oj4" +
                                                              "47+MJKJ9WopGpbikyqoWbTc0xI8Tym0ONeE9AbW6Fu0B/d84f0FkSdTU0gYo" +
                                                              "ZFQzeqMSaEUfFZXR3n4WTSraQHSposU3toA0EdQ2/VviM4h4xw2EQjAVR7oN" +
                                                              "gQJraKWmJKjRHd+ZXrr84D3dzwglw4VhjRQjM4FZRDCLcGYRYBZBZpEsMxIK" +
                                                              "cR6HIVMx1TBRG2HJg80tn9N5zmnrd9QVgY7pA6NglMPQdHaeD2qybUPGoHfH" +
                                                              "9z7fcei5Z8v2hEkYzEcP+CDbEdTnOALhxwwtThNgifxcQsYsRv2dgKccZP/1" +
                                                              "A9vXnv8dLofTtmOHo8EsIXk7WuQsi3r3mvbqt+rS9z7dd902zV7dOc4i4+Py" +
                                                              "KNFo1Lln1A2+Oz53uvRA9yPb6sNkFFgisL5MgtUChm2qm0eO8WjIGGLEUgqA" +
                                                              "k5qRkhSsyljPMtZnaAP2F65qNfz9MJjisbia8OVEa3nxX6wdr2M5Qagm6owL" +
                                                              "BTf03+3Ub37lj+8v5MOd8QlVDmfeSVmDww5hZ7Xc4tTYKrjaoBTavXF9+zXX" +
                                                              "fnTpOq5/0GKmF8N6LJvA/sAUwjBf/NSmV996c/eL4azOhhg44nQPxDSDWZD4" +
                                                              "nZQFgEQ9t+UBO6bAGketqV+jglbKSVnqUSgukn9XzVrwwIdXVAs9UOBLRo2O" +
                                                              "+foO7O9HLCUXPHPuoam8m1Ac/ag9ZnYzYZzH2T03Goa0GeUY3P7ClBuelG4G" +
                                                              "Mw+m1ZSHKLeWZXwMykzUase6xeCuM91jsnZDTsFE9FuuZ9/4Q5t+VzK0LONW" +
                                                              "vEhEy9PN1uceWvluN5/oUlzf+B2xVzhWbqPR69CyajEBX8FfCJ7/4oMDjx+E" +
                                                              "Ea9tsjzJ9Kwr0fVBkH5OQOyXCyG6rfatjTe9d7eA4Ha1rsZ0x87Lv4pcsVPM" +
                                                              "nohHZuaFBE4aEZMIOFgcj9LNCOLCKZrf3bft4Tu3XSqkqs31rssheLz7pf/8" +
                                                              "IXL9gac9DDksI00SUeVCVGih1txJu+ZHgCpecPPn51/yyiqwHS2kNK3Km9K0" +
                                                              "JeHsFUIqM93jmDA71uEfnPBwchgJzYV5wA9LXAUXa7E1EvhzouP9ZEaKZDVP" +
                                                              "dPx3megNUEzz1LIOaYDHUt3xH9ZdvP2okoPHiaGb7tnaEXYtPHRc1fQ9d6qi" +
                                                              "ubfWuwKut7c8c5v2lw/CSIJSHZc1FJWolrXw3GUZiruEnm4Y0SAAOoF8AFQG" +
                                                              "ItnVcoomMB+hKsuEHN8iN9TmyXke3p6MBx762ZIdx5x5mxjdGT6r0m7/4BkH" +
                                                              "nr95aN9eodZoJhiZ55dT5Sdy6C1nBXh8e9o/WXHi/vffWXtOZg4rsVgl1HAi" +
                                                              "I5XOAEfY6O95qyX/enquBtTAc8DSgAMZV9HOXcUZgqADi3VZdhU2u1aJtzsn" +
                                                              "gFvA8inp0TSFSqo3NUe6iNdFsy0IbyFGIYlFvemMaXIH0ZHGdsevevHjirUf" +
                                                              "P3qQT1ZuHux04YBIGMAaLGahykxwx48rJbMP2i3a33Z2tbL/S+ixC3qMg0Ka" +
                                                              "qwyIXAdzHL7VenTJa489Pn7980Uk3EzKwOglmiUeO5ExELRQsw+C3kH9lFPF" +
                                                              "RAyUQlHNoZI88Ogmp3k74OUpnXGXOfTrCfefdMeuN3mswHuYkh8GtVnT3uYd" +
                                                              "BmE5G4u5+cGFH6lrvsIitM6a1GbedTpgVgewEBL3YrFJqMuGbzYy+EETFJP5" +
                                                              "t2rTZVb5mudbRnZA+uHrN77zm0M/LRELP8Adu+gmfrFK6bnw7c/ydIrH3x4e" +
                                                              "2kXfFd1706Smkz/g9HYgjNQzB/OTI0gVbNpj96Q+CdcV/z5MSrpIddzanlkr" +
                                                              "KWkML7tImWxm9mxipCKnPnd7QeTSDdlA/0h3iOBg6w7BnV53FMvxsHbUPRGn" +
                                                              "Zj48My2dmelWN56miSWDIkVaVEZ7qVH79i27D22/9Pgwhn2j+1F0GJVqu11b" +
                                                              "GneBLtl77ZSxOw/8gKt6pusLhfbycg4Wx3B1KMLX+RA1m3xDCeMPWZUUV/Q8" +
                                                              "IUBYRsY2xlpWtHV3rm7sWM112l4tXGMv+jqN3Zo/NPUWt3qPocGX72fs4pVB" +
                                                              "uLC4DIvLPQD5sWCkXABqbVm2LLbcC9FVw0A0y2I3KwARtwvXDxuRHwtGxghE" +
                                                              "y9uWecG5YRhwZlu8ZgfA4SLfOmw4fiwYKRNwmtfEYl54bvvmeLjHnwTP0Raz" +
                                                              "o/PwEP6yxxsGJJxjdENjYDFowoWhIqBbiJWZpmfdgEP4nxco/JHwzLG4zPER" +
                                                              "/j7bdd2dL6MfNRgDQ+7tY15S3l+glFPgmWvxmesj5UOBUvpRg+3q0RjTUl5i" +
                                                              "PlygmJPhmWcxmucj5mOBYvpRMzJKoUnPsfztMMZyvsVmvo+QTwUK6UcNYwnp" +
                                                              "K6QHXmI+XaCY0+GJWoyiPmI+FyimHzWsOUmRe9WUJal7/f+pQElnwLPA4rXA" +
                                                              "R9KXAiX1owZThRvfK6nfOnq5QFGnwXOsxexYH1HfCBTVj5qR0iQEXJmEqc0l" +
                                                              "6JvDmP2FFquFPoL+LVBQP2qYfRQUzyA5UZdL0r8PQ9JFFq9FPpJ+ECipHzUs" +
                                                              "J8mM+yynD4ehpIstRot9xPxnoJh+1JB4JqivnP8qUE701kssTkt85Pw8UE4/" +
                                                              "akhM8UCjg/ZCSrHUoNJG/LzeJe8XAfIOeqVw/K+YuM6YHHwd2RPB/HeK3zEg" +
                                                              "3/zbfeHOXYlVty/I7E2cAvoKrn6+Qvup4uiqkm8luhOxVn74aWc1S144VPT6" +
                                                              "1RPL809WsKepPucmc/0zNjeDJy/8x6TVJ/etL+DIZJoLv7vLu1r3Pr1idvzq" +
                                                              "MD+/FUlU3rlvLlFDbupUZlCWNtTcLcq63Hz9KHjWWDO2xq1ntk745et+pK5M" +
                                                              "3LEDswR7DVX7p+qhWizGwnyblLVKRq8sRtG1yzOqX5MTWX0NlReez+PnUEnu" +
                                                              "cGCrsy1MZxc+HH6k3sPB/5/IrE0XaYBF0CJHmqHooBBAGNbFBD4q0wJGbCYW" +
                                                              "kyDjklWZ8VNjcRQcOsweoMn/9wCNwyr0nLqFUneh/AYD5EcaAG5+QF0Ui6MB" +
                                                              "eC9lqzVdaAvXMhv4nJEBPoMLLP42FQ7cjzQA3AkBdQ1YLGKkEoB3YFTkCX3x" +
                                                              "yEBHS25Y8huFQ/cjDYC3PKBuBRanghcD6Et5yuKJvXFksE+Hx7QAmIVj9yMN" +
                                                              "wHdGQF0nFjFGKgB7DPIgT+StI4McM+K0JX66cOR+pAHozgmo68biTHAKgLzF" +
                                                              "Tq5s1GeNDGrclxuwRB8oHLUfaQAyOaAOQ7NQgpFqtG/gCRpz8jUbPB05ZR+y" +
                                                              "EAwVDt6PNABgwJZ9CLfsQ7ql7Lnpn418GPv4XsinwrPFEn9L4cj9SAPQbQ+o" +
                                                              "uwiLrYyMBeTNzmzSxr1t5Nz5Vkv4rYXj9iMNwPajgLorsdgh3HlzTnJqA79s" +
                                                              "5KzbNkv6bYUD9yMNAHdDQN2NWOwU1q3RziFt1NeODGrc8zrPEv28wlH7kQYg" +
                                                              "uz2g7g4sbmGkDFAvo16wbx0Z2Hg2cYEl+wWFw/YjDYD2i4C6+7DYy0iNbDZ7" +
                                                              "JOI2+ruHcUYJOpS9qYgHuhPzrkSLa7zxe3ZVlU7YteZlflsue9W2PEZKk2lF" +
                                                              "cR7AOd6LdYMmZT5k5eI4jt9wCT3EyBG+VychV8MfPjEPivaPMHKYV3tGiqB0" +
                                                              "ttwPzs/dkpHR/NfZ7nFQI7sdbhnxF2eTJ6B3aIKvT4qTYMi9HMd+4sRyUKRl" +
                                                              "2Y2KzGyQw79uNhx7GzNzdg745fVMlp9ut6557Nt1WtuWg8fdLq79xRVpaAh7" +
                                                              "GRsjJeIGIu+0KO/KiLO3TF/FK+d8WXnvmFmZ3ZIaIbCt2pNt/SMapJ466sYk" +
                                                              "1504sz57Ne7V3Sc9+uyO4hfCJLSOhCRGxq3LP9sd1NMGmbYu5nWlaq1k8Ot6" +
                                                              "DWXvrH/us9dCtZljVDyTnRpE0R2/5tHX25O6/pMwGdNCRuNW+iA/eF62We2g" +
                                                              "8X4j54ZWcY+WVrP33CtRkSW82M5HxhrQiuxXvDbKSF3+dbX8q7RloLPUWIq9" +
                                                              "YzcVrr2VtK47a/nINmFx/CCONOhad6xV1617esWv8pHXdVymodfwn2X/A9l8" +
                                                              "cYWhMgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "rsyNe/Go5CFCahBhidN6Gad66vP4ulyP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("TQpd9ad6lJZ1VK8EM4sExzawCkq1eJYUpTKll5UpbkLxmIjhKZB/u2xUWjUI" +
       "bU83RYObtSW006PLkB9Rymja6bmDhjfVqWjBp/5qwMhommiIJJojdBpqkjk3" +
       "gwjYnzKPS91V2SQUAcV6ao1Rp6wlDaurqkZXliHQqiGCb5okJG6UhVhn5/wS" +
       "5421zLNUdyoiIWl4zWIYxnwawOrKpQSYm0uoTfRpNFBnCzshytqwU2siMt1d" +
       "DyvecMoaDYpVoUogbEZdwSxPy92U3PRjtBFxiwQlUy5VdbDO5iJruo0orFWr" +
       "KBeWxmE01utzlfHQRiKIrowtUFIIlh2NJukIKnZ7cNdgesiQgIkupNbH4NRl" +
       "EZaESLRMz1ph2eVCeMDKLjjC1oLpqlQtVoIUdK2hIjJQGlC06VUWYHvODHqL" +
       "lkAmHsLwjUAtcSxpzaZR1R6bslda1XthrT2erH0KjoKG2golcym2N0NbcPGi" +
       "UIarITUpV3s12GVjUuVaQsSNIQODNaJWHmtlvT6pLKsVaaxMobHo8wjSCoXV" +
       "YFwHxy8qWfh9I0om6zY47xAIpM4mdQ8VTIcBzpj2GtNUEX2/LIbdCirDNs1Z" +
       "RAK3Wj2ut5DVWiKWaiVUC8bruktNVHFjOeo8tssTGGuYdWU6XrA6hmWP/350" +
       "Y48l780fsx4EPy9NNCv4oxt48rgtOhZhkn9uLxwLmD3yUDqv+eB+ZItfePi0" +
       "mOY8quuLH33pZbX3pdJ+UBMaFu4KHfcZE+yLzSNdXQA9PX16tAibh3Qfhmx8" +
       "86P/7aHhTy1euIEw0UeP4Tze5d9jX/ld8l3KL50r3HIQwHFNsPnVjZ69Omzj" +
       "vK+FkW8PrwreePhAsnnYTxZ4NdpJdnTSvy+XznjW/+7t3Odlh9E7e4cVkKzC" +
       "3j3HKhwJ79nLoqT27gCTEGghK/u6YZ/4DHvtGOqBEu3deSMxQFnG3q1Xs87+" +
       "Z3r/jvX7byrr/T8VHs3/B5Dj8Er259cVAiSCZquav3vDISf/9jME82iWPBAW" +
       "7jFsI8zDz7cx5XuHi2nvrW9ADvdnmdnfle5ODu7NkcNRDk+dUQZlyWXAT9fC" +
       "oeNu5z7XmUN+T75Rfo/nlLYf7+bzq55Rllm/vWJYuAD4CdnfyycyLL1Rhpk1" +
       "9HcM/ZvPEDujrJUlz4WFi4BhMw/LOJHie98oxcfAFewoBjefIntGWS9LqLDw" +
       "JkCR0eYnzyH9RglmATvRjmB08wmeEV25l0VX7g2B+QUE6cOgkUNyNxRueRK5" +
       "LCIw3pGLbz457Yyy7F/PvRfCwqXMxACbi10VgXLIUb4ZGpruOKY3n6N3RlkO" +
       "x9xp6NWhLIcErTdK8BFwfWBH8AM3n+CLZ5T9XJYkYeFuQJA4OSYmd+kXXwvi" +
       "NibmUCibm+E8P7gb8YM3XyifOKPsF7Pk57fOkzgluCaXyoXXwrgNrjmUysdu" +
       "hjF7cTfiizdfKp87o+xvZslLW2OGHQbEHJL79Bsll0XofWhH7kM3n9yXzij7" +
       "cpZ8ISycB+Ta2kns/vYbZZeFMX94x+7DN5/d3z+j7B9mySvgEGkExAlhQ4ck" +
       "v3JD4f9AFw5eFszefHrwmreSt2/SKl99+eKdb3159G/z9+UO3na9iyncOY9M" +
       "82go/JH7211fmxs577u2gfFuTuafhIW3nfr2IjjMZF+5/H99W/8bYeHNJ9UP" +
       "C7eA9GjNV4EzO14zLNyWfx+t95tATw7rZUFr+c3RKr8NegdVsttvurnkrg6F" +
       "2r47kGwPNA8e0ZrtOf6+15qHIyfyJ646R+fvj++feSN+91bT117ucB/4Ye1L" +
       "2xf/FFNO06yXO5nCHdt3EPNOs3Pz46f2tt/X7dRTP77wq3c9uX/Gv7AFfKjB" +
       "R7A9evJbdrjlhvl7cek/fuuvPffll/8wfwPh/wHEyne+2D8AAA==");
}
