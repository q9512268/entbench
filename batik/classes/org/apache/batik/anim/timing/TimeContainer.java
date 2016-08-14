package org.apache.batik.anim.timing;
public abstract class TimeContainer extends org.apache.batik.anim.timing.TimedElement {
    protected java.util.List children = new java.util.LinkedList();
    public void addChild(org.apache.batik.anim.timing.TimedElement e) { if (e ==
                                                                              this) {
                                                                            throw new java.lang.IllegalArgumentException(
                                                                              "recursive datastructure not allowed here!");
                                                                        }
                                                                        children.
                                                                          add(
                                                                            e);
                                                                        e.
                                                                          parent =
                                                                          this;
                                                                        setRoot(
                                                                          e,
                                                                          root);
                                                                        root.
                                                                          fireElementAdded(
                                                                            e);
                                                                        root.
                                                                          currentIntervalWillUpdate(
                                                                            );
    }
    protected void setRoot(org.apache.batik.anim.timing.TimedElement e,
                           org.apache.batik.anim.timing.TimedDocumentRoot root) {
        e.
          root =
          root;
        if (e instanceof org.apache.batik.anim.timing.TimeContainer) {
            org.apache.batik.anim.timing.TimeContainer c =
              (org.apache.batik.anim.timing.TimeContainer)
                e;
            java.util.Iterator it =
              c.
                children.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                org.apache.batik.anim.timing.TimedElement te =
                  (org.apache.batik.anim.timing.TimedElement)
                    it.
                    next(
                      );
                setRoot(
                  te,
                  root);
            }
        }
    }
    public void removeChild(org.apache.batik.anim.timing.TimedElement e) {
        children.
          remove(
            e);
        e.
          parent =
          null;
        setRoot(
          e,
          null);
        root.
          fireElementRemoved(
            e);
        root.
          currentIntervalWillUpdate(
            );
    }
    public org.apache.batik.anim.timing.TimedElement[] getChildren() {
        return (org.apache.batik.anim.timing.TimedElement[])
                 children.
                 toArray(
                   new org.apache.batik.anim.timing.TimedElement[0]);
    }
    protected float sampleAt(float parentSimpleTime,
                             boolean hyperlinking) {
        super.
          sampleAt(
            parentSimpleTime,
            hyperlinking);
        return sampleChildren(
                 parentSimpleTime,
                 hyperlinking);
    }
    protected float sampleChildren(float parentSimpleTime,
                                   boolean hyperlinking) {
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            float t =
              e.
              sampleAt(
                parentSimpleTime,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        return mint;
    }
    protected void reset(boolean clearCurrentBegin) {
        super.
          reset(
            clearCurrentBegin);
        java.util.Iterator i =
          children.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.anim.timing.TimedElement e =
              (org.apache.batik.anim.timing.TimedElement)
                i.
                next(
                  );
            e.
              reset(
                clearCurrentBegin);
        }
    }
    protected boolean isConstantAnimation() {
        return false;
    }
    public abstract float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child);
    public TimeContainer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaCXAcxRXtXcmy7pVlSzbGko0sQ2SbXc5gR+aQ5EtmZSuS" +
       "UVXkQ56d7ZXGmp0ZZnqltYi4kpQdkrgcxxwhoFQqBhtibIoKlRACcQIBXBBS" +
       "3AHCEaAChFDYRSCpACH/98zsHHsIVyFVTWvU3b+P/99//3ePDr1Pphk6aaQK" +
       "C7MdGjXCqxTWLegGjXfIgmFshLoB8cYi4cOt76xfHiQl/aR6SDC6RMGgqyUq" +
       "x41+0iApBhMUkRrrKY2jRLdODaqPCExSlX5SJxmdSU2WRIl1qXGKHfoEPUpm" +
       "CIzpUizFaKc1ACMNUVhJhK8k0uZvbo2SSlHVdjjd57i6d7hasGfSmctgpCa6" +
       "XRgRIikmyZGoZLDWtE6WaKq8Y1BWWZimWXi7fL6lgnXR87NU0HR36ONP9gzV" +
       "cBXMFBRFZXx7Rg81VHmExqMk5NSukmnSuJxcSYqipMLVmZHmqD1pBCaNwKT2" +
       "bp1esPoqqqSSHSrfDrNHKtFEXBAjp3kH0QRdSFrDdPM1wwilzNo7F4bdLsjs" +
       "1txl1havXxLZd+PWmnuKSKifhCSlF5cjwiIYTNIPCqXJGNWNtnicxvvJDAWM" +
       "3Ut1SZClMcvStYY0qAgsBea31YKVKY3qfE5HV2BH2JueEpmqZ7aX4ICy/pqW" +
       "kIVB2Gu9s1dzh6uxHjZYLsHC9IQAuLNEioclJc7IfL9EZo/Nl0IHEJ2epGxI" +
       "zUxVrAhQQWpNiMiCMhjpBegpg9B1mgoA1BmZm3dQ1LUmiMPCIB1ARPr6dZtN" +
       "0KuMKwJFGKnzd+MjgZXm+qzkss/761fsvkJZqwRJANYcp6KM668AoUafUA9N" +
       "UJ2CH5iClYujNwj1D+wKEgKd63ydzT6/+uaJS5Y2Hn3M7HNqjj4bYtupyAbE" +
       "/bHqp+Z1tCwvwmWUaqohofE9O+de1m21tKY1YJj6zIjYGLYbj/Y88o2r76Tv" +
       "BUl5JykRVTmVBBzNENWkJslUX0MVqguMxjtJGVXiHby9k0yH96ikULN2QyJh" +
       "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" +
       "35b8H4AeEPYOJAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6ecwkx3Vf7/La5bVLSiQVhodErhxT42zP9Nyh46inZ3p6" +
       "ju45+pieTmSq7/uYvqa7FVq24kSyDMiCQjkyYPEPQ05igZaUwEbiBHYYB/EB" +
       "CUYkGLETJJISG4hsRYgExEoQ2XGqe75vv2OXSxNkvg9dU131quq9V+/96nVV" +
       "vfIt6K4ohGqB7+S648fX1Sy+bjnt63EeqNH16by9FMNIVTBHjCIGlL0gP/OF" +
       "K9/93seNqxehuwXobaLn+bEYm74XrdXId1JVmUNXTkpHjupGMXR1bompCCex" +
       "6cBzM4qfn0P3nWoaQ9fmxyzAgAUYsABXLMDoCRVo9IDqJS5WthC9ONpBPwJd" +
       "mEN3B3LJXgy962wngRiK7lE3y0oC0MOl8p0DQlWNsxB65w3ZDzLfJPAna/BL" +
       "/+CHr/7TO6ArAnTF9OiSHRkwEYNBBOh+V3UlNYxQRVEVAXrIU1WFVkNTdMyi" +
       "4luAHo5M3RPjJFRvKKksTAI1rMY80dz9cilbmMixH94QTzNVRzl+u0tzRB3I" +
       "+uiJrAcJ8bIcCHivCRgLNVFWj5vcaZueEkNPn29xQ8ZrM0AAmt7jqrHh3xjq" +
       "Tk8EBdDDh7lzRE+H6Tg0PR2Q3uUnYJQYevw1Oy11HYiyLerqCzH0jvN0y0MV" +
       "oLpcKaJsEkOPnCeregKz9Pi5WTo1P9+ifvBjH/AI72LFs6LKTsn/JdDoqXON" +
       "1qqmhqonq4eG979n/tPio7/6kYsQBIgfOUd8oPlnf/s77/2Bp179rQPNX74F" +
       "zUKyVDl+Qf6M9OCXn8Ce699RsnEp8COznPwzklfmvzyqeT4LgOc9eqPHsvL6" +
       "ceWr69/Y/uhn1W9ehO6dQHfLvpO4wI4ekn03MB01HKueGoqxqkygy6qnYFX9" +
       "BLoH5Oempx5KF5oWqfEEutOpiu72q3egIg10UaroHpA3Pc0/zgdibFT5LIAg" +
       "6Cp4oEfA8zR0+Kt+Y+h9sOG7KizKomd6PrwM/VL+CFa9WAK6NWAJWL0NR34S" +
       "AhOE/VCHRWAHhnpUAZoBpzRdYEcwY7pq6Ugi4DC8XppZ8P97gKyU8Or+wgWg" +
       "/CfOu74DvIbwHUUNX5BfSgaj73zuhS9evOEKR7qJofeAMa8fxrxejXm9HPP6" +
       "YczrZ8aELlyohnp7OfZhjsEM2cDXAQre/xz9vun7P/LMHcC4gv2dQL0lKfza" +
       "YIydoMOkwkAZmCj06qf2P8Z9sH4RungWVUt+QdG9ZfNliYU3MO/aeW+6Vb9X" +
       "PvyN737+p1/0T/zqDEwfufvNLUt3fea8ZkNfVhUAgCfdv+ed4i+/8KsvXrsI" +
       "3QkwQD5WWAw9dX6MM277/DEElrLcBQTW/NAVnbLqGLfujY3Q35+UVFP+YJV/" +
       "COi4Dx0lZwy7rH1bUKZvP5hIOWnnpKgg9q/Twad//3f+qFmp+xiNr5xa32g1" +
       "fv4UApSdXal8/aETG2BCVQV0//lTy7//yW99+G9WBgAonr3VgNfKFAOeD6YQ" +
       "qPnv/tbuP3ztq5/53YsnRhODJTCRHFPODkL+Ofi7AJ7/Wz6lcGXBwXsfxo4g" +
       "5J03MCQoR/6+E94AmjjA4UoLusZ6rq+YmilKjlpa7J9eeXfjl//7x64ebMIB" +
       "Jccm9QOv38FJ+V8aQD/6xR/+X09V3VyQy9XsRH8nZAeIfNtJz2gYinnJR/Zj" +
       "X3nyZ35T/DQAWwBwkVmoFWZBlT6gagLrlS5qVQqfq0PK5OnotCOc9bVTUccL" +
       "8sd/99sPcN/+te9U3J4NW07POykGzx9MrUzemYHuHzvv9YQYGYCu9Sr1t646" +
       "r34P9CiAHmWAY9EiBLCTnbGSI+q77vmP//rfPPr+L98BXcShex1fVHCxcjjo" +
       "MrB0NTIAYmXB33jvwZr3l47BO4NuEv5gIO+o3u4EDD732liDl1HHibu+4/8s" +
       "HOlD//V/36SECmVusdieay/Ar/zs49gPfbNqf+LuZeunspuhGERoJ22Rz7p/" +
       "cvGZu//tRegeAboqH4V/nOgkpRMJIOSJjmNCECKeqT8bvhzW6udvwNkT56Hm" +
       "1LDngeZkCQD5krrM33sOWx4stVwq/NoRtlw7jy0XoCrz3qrJu6r0Wpn8lWNX" +
       "vhyEfgy4VJWq7+di6JJsmI4CEBBM2LteY8LW4r4KiV6Qf2X19S9/uvj8KwcX" +
       "lUSw5kO114qubw7wS/R+921WoJO460/Gf+3VP/oD7n0Xj5zqvrNaePh2WqhI" +
       "H4mhB087yAFMZgf0LdNmmaAH4s5r2vfzlZqyC0B3dyHXu9fr5fvi1vq9o8x+" +
       "P8DLqAriQQvN9ETnWNOPWY587RghORDUAwO/ZjndY3avVuyWpnT9EAmf4/W5" +
       "vzCvYCofPOls7oOg+if/8ONf+qlnvwbmbQrdlZbGC6bi1IhUUn5n/L1XPvnk" +
       "fS99/Scr+AcGw/3EP+l+vexVuJ3EZUKXCXMs6uOlqHQVQ83FKCYrlFaVStrb" +
       "4sIyBGFObKZHQTT84sNfs3/2G794CJDPg8A5YvUjL330z69/7KWLpz5Lnr3p" +
       "y+B0m8OnScX0A0caPu0EtxilaoH/t8+/+C//8YsfPnD18NkgewS+IX/x3//Z" +
       "l65/6uu/fYvo7k7HfxMTG1/9JaIVTdDjvzknYjwqZ2s+5mU37wacQxfS2Pbr" +
       "0QqhJV5u6+uauGqPYlegE5rleHvV7ihdgR+7QV0QvJ0Tb82WHawUO9TlLNsb" +
       "Pr7aDYzYlCb+zFmjmLyaDPjBgG6iBDYSUczAh9s1jQUoRsD9XhERRDThcpxj" +
       "NinblGpLuN+H4aa6HIaNZWDYHVFczbAuqYwtHttlzGau6iCrTXQXj4y5P+jJ" +
       "gAF5EXc7mUaYKwcW1x16iHXW5Fjf5ewuazVqdRMNBgbJ2uswnG0Raz1XFkNx" +
       "t8RGGe3wbXqauQrNIpv1xGns+PGM0PzRkg1cbFIErFng4kxuoBhJsZwxNWY9" +
       "u54IqeQjNO0QnGJZSrtrAqUYYjTWaFeO9QATO/xaX09M282FsS/Mh5t41NmI" +
       "s11v2xhsNoLpbnizq807ju7x616XYuvEutlZUMu+XnDygCfxwRoX+Ky71nsN" +
       "jnBH2Y602xSd2K5HJ9NMprc7MyDnnCsQ7m7YCAaYSO1nDCIFDTVa+rvdjqYJ" +
       "OtSGIUXMYnzED1AraNpEfbVWaDwcKkuysd+bTkH5XbwlKfPIihpx5jQMMeWz" +
       "uaDUlhvXS2b0zNQMjHbwtmztzcmWoSZLbMdPx9SGij0Q1aXpdIhuyCYbN2gB" +
       "c0g5pePttr5D9Wigis3GdsbNts2dNmoTHDIgkGmijgJ3J3RFvjXBcjjYbewJ" +
       "N0DGST9qKIXRSTLCErbziMD6kxWazKmR6cvOVO5OtHl/JPgw5dQnxGiKqME4" +
       "mxRsxoWosVptAsokTYw0rGCg6oHeHzRc3UcbA1dwm8qqMWddk1xik0EDXS/D" +
       "jiLEVH2WkLP9FB/PvEKpkZYu8G5tV9hRBHc7DS1K7amw26+nKLWVg86M7HR6" +
       "qM+KGov2KXaKYETbxJxtYlF7qzGs7WcjfaZ0mrlSMB24lohTur1FCK9Jdglq" +
       "Z1ktaRsnQY5KI1gidkFNaMTYPt27G1bc+YavjfqLmqI2XKQRz7aN7dTqFBNr" +
       "O55vJQve9no+EnY7TDpgnfY0t9cc43KDQUGNqI09jRyWr5PcTk/IzIqnY443" +
       "CSnv2/Wc6HdMm51TyCqfGiwlTE2XUzlxnqd1HMfWOsZxq0W3PaPZRaPJbAZD" +
       "eIjEI3a6a2F4o0fuvbYOw4VsbvIpJgYDHPyvpyy9VBI/7FL5HF0MiVWXQ+3B" +
       "Ttcsw9jRujxZO+s+iU3QoS/6jdXAbE3X9MhDWYTWnRmzo1EsZfd7vZBE36MX" +
       "5EJotcbobthT+S7v9PCwsQtyb+EPW2GbrXV8xtjLKoWM8dAdBkZA4ORY23rD" +
       "JdneF5Y3xosiHHiMMZn0Zo7bUnLXknFsXxuGq7nIzaWG1HCbUoNbjVrUdGzW" +
       "x31kzk9HzVWHGM32Gz5Dl/hUonhJ3CEyjGMMznKT0MT2Tj4whki6HmwxJUOI" +
       "uZ4b5miSy7s5AdSwyrzEDOnFdECniaFb3GxnOajSyVyhvQ4HluP5nkD0RvTS" +
       "q0Xe2q2LaUdKdyGGTlWdHDCWTS3QAk/a4xpZMEoXU1F+sRgrYbfoCSMpczYE" +
       "ZuXrbNWZbIRZy8i38HhZ7MZrlJ9nw4TgDT2dumHK5nVJziZ+s7cY9hd1ZJdT" +
       "au7iQ1phl7Q3QcZMmEz3VEfd+WyPWi/0xXxhLPYYRmio5Rl83wybGnDofq/v" +
       "IClt6XWDawzTQCy4jJVbG6zheYa9mFjazhnNYA7p7uCYaHRrsJwtRpPlWnLd" +
       "EBXyfVefSOhCXKJdq9Gstdwk7Xo9pDPCtit2sMhoLKW1Rb9Y+rKmz/cw2tPa" +
       "Aywi564dR6QZo6ywjql9O14o8WrczNVhDZt03TyjUV+gVwB5yTrfqw3peqfW" +
       "b8PdXSsr6MbQ2iKbQCCXLYrW6nYn0bwiTLO0TaKj9baTWMuOKtGKXoC5kBS8" +
       "udXVeMLDVH3f6mn4poV3dLVDiassN1xWBugoRcMiobuLVsK10xDAEG7YyZBI" +
       "FJrih9ZK73oeouK81lspyx7FdezcbDalaBQq3Mje2Lg73rejlb/0ESpMt5LT" +
       "HdLRVhK1HbWdZQZKKnF33RfisD1baPs50ydn9UljHEf1ySioZy1/IyEew8NB" +
       "fw9zUjPZmeiat5tTAVdn4UBt7wM0XzF+3ZhQbl1JR07bCsZ0rdGyc0EYR7vd" +
       "CkvJAmlqHOtS8jYhYT5E5g1ZdgmT2zcmRVbojX13WCzRYt5r8kSu9nttf+4N" +
       "02JvOKOiFWq2UIhac1rAUjCwGt1u5uV5Vx515/a22WovI8tAOgLSJNZqo1An" +
       "a5WV7LaX5b4ujjTEGyYMsd9IdNraTqlll942/Las9PUgw9Jah/AobG8jIDpg" +
       "mnEzLRbMWBDJ2qpd1PtR6Hr9eCGNaMIimqmhtmVKpwR/j9q1wpBxd7nfDo15" +
       "LWrlM6/XneBmh0WS9jpIokB3GFot9GJuczi3xY0xHbEGvW0NZysSHRt7dDuw" +
       "QkZmyYa5IHu7db6ist7abvR78GTp1vcjaiH5nZ5fU0D44cLdGokEo6hJMaE/" +
       "7m9UbYB2eDPvOUTTmuBMZBtb8GmyyKz2SunNkTasF3hnZvO5FXIU703ESbfl" +
       "bymu1W/0pmBN26wW9WLc1PbOtKFkS2puEGCdkdiQaMOF3eOahDjvbZ04qm0I" +
       "CUQSgsj0Uiu2u3Ct263VnEXTMuptgdwuOKxn0fBEWYXUMg30bI7tVn1GR2sb" +
       "i2q0OrUaImnOboj3Y27bn3orT6YmsRCnxQpDKJZq66vMKbS5mQ2yTptXhmm/" +
       "wWy6K7EX4As2COiAjJl4uEz6MhOszdBF/XaBELNetBfn8iAckuZikMkYDyL6" +
       "QZuZRHOL45N8wvMdpagh9orv9UZhRqL1YbBPa4sQxhR2guZtZLrT83Wae1qz" +
       "lfA8HGuR2zLiZNGP6tqs2VzOuRlN86madoppb9JM+Va0zqda5jAxM3UXLGU3" +
       "hLbLT9CBw2vZtksN41mf6za7eapKw75ATdNwnMhTkhinNW04NSRv0Bbg2bav" +
       "1lq19jjviYi3pV1t3QMQ0V/1u2tFtbZuvMRTFq8NkOFYF/Mu2umvdplStJnA" +
       "mXHNzHczY6CjnEiZ6Z6iTFQc4sSelOExS6BoKyLgBY9nFuk0LWHubtp8L7HX" +
       "hSvpmmlm+s6WOcXcr4d5j9eJzNhZ22W4CmVSZga7TBvaOZ+mYg9rps0xi3ti" +
       "MTRnctGU+DSJ4GECq4I9FFMlAyGMhLUEeR8SododI51NMRzNnYbV7wdEVtvX" +
       "Ft0uM8U6g9VyNp3JW1li9U2rtUpt2bHWYYp3inXSQxJcEGKnvlmN0S015ryV" +
       "ZY9gViAX5r6xZpFpNGO2yMyZ7bYrfIjsRH1qMXtc75JLU93nvktMBvCSkixd" +
       "hJd7VmxjHWQwbTUcI9wws/mgvsmJ3FRFpDNuDVLXX+aIbgZ9Q2ZIC2cCCk3i" +
       "jILHQStXGH/SaSPz7cQz2iFT1L2w1e75OoeoHQNFkFE09FF3YHqhPJwzPGW7" +
       "S0QVrbDWbgWENmZguFYgyBIWOnOm060PREo33LnYnk2RTK6pCj/ah3DmNzqB" +
       "MMJ8PTI3rWy+mfLLXn2cpkuuyclTk1hP24vNyiX68LZTa85FuaaR/YzBWkGb" +
       "1FMGH3MhQ00ncycc1/VOZ8i20MSLGVKvq3UO6y/0XUtWptySGirKWHKW47Dl" +
       "y2y3SXk4L8OKRDk6sonoZQpETfma1GLxBc7pwG8Qlm8KHQbnnJlptgPNI7Xc" +
       "0sEn0biljyZuS1w1xoyYJV62lRVzWO9wmRDqNo008lxJIz43a6sluW/ocqu+" +
       "gLkRamg93lwwuuCiuyyXxx74QvdmSUfFerVWLGmZ3VDmy5josfKSzakIp5aT" +
       "BHd7KJ0S3R3TB2hj4+bOIih7b4PIDpH7zeksn2niBO/DuxhFespWI4cTZiHv" +
       "gn2jxc7RVNn22mPLrnHrEUtJcx6JJRU1wqm2tkbbyOQTsheRi4mtslvwudaX" +
       "9M0sgqf0ejRieIdZGcGY2TC67KQZ1e+7nD+LGhNHBd7caK+KyOvs3KyGrdkl" +
       "01rPhHpf7vsTYbZAUkfg9pid2wLl9A0V2EAfr7sB1jLNlMIKrrbW+yxpzVKW" +
       "MOyAXPf2EkvM7NwYYVRjsWX1uKdo3bDTsCimVWtNtF4Mg7hhQzoADbd4WGRK" +
       "HV959lohCZ4tGMZMtkEXp5ta6Agdc1uYtTjfzkZeoI41eIHs3cUO6Xq7BTPL" +
       "JK23mYb9tquZq7WwwaPhSA30RTGEB2tLWMM1NV82xaWwnW5iablzawmSrwlu" +
       "1ScQTxZrSx0lh/kwCwqN61HWQiKzFsn3O/1Wb1Tr0kFnLI0jBltZektI8jnC" +
       "MBvb94ZCYiKSgtpTsLxnbjxntDQZG0HLX/A1gW3mUuj3U1kbTXv9aLERUn6J" +
       "UHsBROWqMPDlvptsmxkdN2fDBktQRJcWODschcORO2JpAe1z9YIz8f0Azly0" +
       "0+NoobFx8bCmksqM1WiJghPwvbZLLG7c59m9D2P2cLFZECwyds120zeCjV1D" +
       "RW3ssPpsM2EYEW2iTRur0/1lxNRrq9ybkJk38eYri860PddsSz2ihaqj5XYx" +
       "RVG03L6w39gO0kPVZtmNM2TL6ZYV3BvYOcluPeDFo026S6IUxaEox9mNncXq" +
       "78ptzm5O7W9D5VbRk691blxtE33mQy+9rCx+vnG8hanF0OXYD/6qo6aqc6qr" +
       "y6Cn97z2lhhZHZuf7Ff/5of++HHmh4z3v4ETuafP8Xm+y18gX/nt8ffJn7gI" +
       "3XFj9/qmA/2zjZ4/u2d9b6jGSegxZ3aun7yh2ftKjX0/eJ470uxztz4Vu/W2" +
       "dTVjB8M4d+xy4ehc82gH9bnXPTpVyisjqhdXvf2d2xzifLhMfqQ0E0XByh3y" +
       "iko8ZXRqDN2Z+qZyYo0ffL19vNODVAUfOLurPQBP70hDvTeqoeEtNXTxxOh/" +
       "/FhN119fTUNfTko9rX3/oKuXbqOrT5XJT8XQPZFaNShff+JELR9/E2qpDKcG" +
       "nvGRWsZvqeFUaqkIfu428n2mTD4dQ/eFquunamUO52R8+U3I+HhZ+G7wrI9k" +
       "XL81Mp4W4XO3qftCmfwCEA98WmMnh0G3OaepTkoPm+4v/8Nnf+eDLz/7X6rD" +
       "xktmxIkhGuq3uFNzqs23X/naN7/ywJOfqw7nq0OkCjPOX0a6+a7RmStEFe/3" +
       "n7WUx15Piz8eBAF0Mm2ffRPT9vay8AnwyEcDym+px94Kb+7SHF+Mb1Vzj+T7" +
       "jip6VY+/dpvJ/o0y+RWAa5HoBo6KVs76r0408i/erEaeAY9zpBHnLdVIxWmZ" +
       "/HpF9e9uI+VXyuSLMfTgQcpjqz4n65feLF43wfPikawvvjWyngKmg5j/6TZi" +
       "frVMfg/YRagC6D0HSb//JqR7tCws1+iPHkn30bdGutPMf+M2dX9cJn8QQ287" +
       "OXtHwRIlHl95+fUTMf/wzSJvKeYnjsT8xBsQ8xBIlkn8F1ti/udtBP5umfyP" +
       "GLoCMHioamLixANVN89b7LffiLBZDD1w5rpYed/lHTddSD1copQ/9/KVS4+9" +
       "zP7eAZSPLzpenkOXtMRxTl9POJW/OwhVzawkuHy4rBBUP38WQ0/cLsiIobsP" +
       "mYrpP60aXYBi6JFbNgKBVvlzmvaOGLp6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nhb4QfV7mu7uGLr3hA4Me8icJrkcQ3cAkjJ7b3CYrQtnA/0b6n/49dR/6tvg" +
       "2TPLZ3Vb+Dj6TpZHtyk+//KU+sB3Oj9/uO0lO2JRlL1cAivd4eLZ0Up3/mbG" +
       "6d6O+7qbeO57D37h8ruPvzYePDB8YsCneHv61tepRm4QVxegin/+2C/94D96" +
       "+avVNYD/B5XqE7nGLQAA");
}
