package org.apache.batik.gvt.renderer;
public abstract class BasicTextPainter implements org.apache.batik.gvt.TextPainter {
    private static org.apache.batik.gvt.text.TextLayoutFactory textLayoutFactory =
      new org.apache.batik.gvt.text.ConcreteTextLayoutFactory(
      );
    protected java.awt.font.FontRenderContext fontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      true,
      true);
    protected java.awt.font.FontRenderContext aaOffFontRenderContext =
      new java.awt.font.FontRenderContext(
      new java.awt.geom.AffineTransform(
        ),
      false,
      true);
    protected org.apache.batik.gvt.text.TextLayoutFactory getTextLayoutFactory() {
        return textLayoutFactory;
    }
    public org.apache.batik.gvt.text.Mark selectAt(double x,
                                                   double y,
                                                   org.apache.batik.gvt.TextNode node) {
        return hitTest(
                 x,
                 y,
                 node);
    }
    public org.apache.batik.gvt.text.Mark selectTo(double x,
                                                   double y,
                                                   org.apache.batik.gvt.text.Mark beginMark) {
        if (beginMark ==
              null) {
            return null;
        }
        else {
            return hitTest(
                     x,
                     y,
                     beginMark.
                       getTextNode(
                         ));
        }
    }
    public java.awt.geom.Rectangle2D getGeometryBounds(org.apache.batik.gvt.TextNode node) {
        return getOutline(
                 node).
          getBounds2D(
            );
    }
    protected abstract org.apache.batik.gvt.text.Mark hitTest(double x,
                                                              double y,
                                                              org.apache.batik.gvt.TextNode node);
    protected static class BasicMark implements org.apache.batik.gvt.text.Mark {
        private org.apache.batik.gvt.TextNode
          node;
        private org.apache.batik.gvt.text.TextHit
          hit;
        protected BasicMark(org.apache.batik.gvt.TextNode node,
                            org.apache.batik.gvt.text.TextHit hit) {
            super(
              );
            this.
              hit =
              hit;
            this.
              node =
              node;
        }
        public org.apache.batik.gvt.text.TextHit getHit() {
            return hit;
        }
        public org.apache.batik.gvt.TextNode getTextNode() {
            return node;
        }
        public int getCharIndex() { return hit.
                                      getCharIndex(
                                        );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzBwZ/AMblw4A5kCDkrjRQ2prSwAViw9k+" +
           "YYNU0+aY25u7W7y3u+zO2WcHwodEQKhCaSApbYB/CmpKCaRRo1atQqnaNInS" +
           "FEGjNglq0jZ/JG2CFP5onJa26ZuZ3du9vQ+EKtXSzo1n3pt5b957v3lvLtxE" +
           "taaBunSsJnGIjuvEDMVYP4YNkyQjCjbNIRiNS0f/fHzf5O8aDvhRYBhNz2Cz" +
           "T8Im2SQTJWkOo/myalKsSsTsJyTJOGIGMYkxiqmsqcNolmz2ZnVFlmTapyUJ" +
           "I9iOjShqxZQaciJHSa+1AEULolyaMJcmvN5L0B1FTZKmjzsMc4oYIq45Rpt1" +
           "9jMpaonuwqM4nKOyEo7KJu3OG+geXVPG04pGQyRPQ7uU1dZBbI6uLjmGrmeb" +
           "P779WKaFH8MMrKoa5SqaW4mpKaMkGUXNzuhGhWTN3egRVBNFU13EFAWj9qZh" +
           "2DQMm9r6OlQg/TSi5rIRjatD7ZUCusQEomhR8SI6NnDWWibGZYYV6qmlO2cG" +
           "bRcWtLXN7VHxiXvCJ771UMtzNah5GDXL6iATRwIhKGwyDAdKsglimOuTSZIc" +
           "Rq0qGHyQGDJW5AnL2m2mnFYxzYEL2MfCBnM6MfiezlmBJUE3IydRzSiol+JO" +
           "Zf1Xm1JwGnRtd3QVGm5i46BgowyCGSkMvmexTBmR1ST3o2KOgo7BLUAArHVZ" +
           "QjNaYaspKoYB1CZcRMFqOjwIzqemgbRWAxc0uK9VWJSdtY6lEZwmcYo6vHQx" +
           "MQVUDfwgGAtFs7xkfCWw0hyPlVz2udm/9tjDao/qRz6QOUkkhck/FZg6PUxb" +
           "SYoYBOJAMDYtjz6J21844kcIiGd5iAXNj/fcun9F55WXBc3cMjQDiV1EonHp" +
           "bGL6tXmRZV+sYWLU65opM+MXac6jLGbNdOd1QJr2wopsMmRPXtn666/uP08+" +
           "8KPGXhSQNCWXBT9qlbSsLivEeJCoxMCUJHtRA1GTET7fi+qgH5VVIkYHUimT" +
           "0F40ReFDAY3/D0eUgiXYETVCX1ZTmt3XMc3wfl5HCM2CD62CbxcSf/yXIi2c" +
           "0bIkjCWsyqoWjhka058ZlGMOMaGfhFldCyfA/0fuXRlaEza1nAEOGdaMdBiD" +
           "V2SImAynR2kYTJIEuxjhDdiUpSGIqhjmThxijqf//7fMs1OYMebzgYHmeeFB" +
           "gcjq0RRgj0snchs23roYf1W4HgsX6/wo+gLsGxL7hvi+Idg3ZO8b8u4b5AN9" +
           "2BhBPh/feCaTRHgF2HQE0AHguWnZ4Nc37zzSVQPuqI9NAYMw0qUl11XEgREb" +
           "++PShWtbJ6++1njej/yANAm4rpw7I1h0Z4grz9AkkgTQqnR72AgarnxflJUD" +
           "XTk5dmD7vs9yOdzXAFuwFhCMsccYeBe2CHrDv9y6zYff//jSk3s1BwiK7hX7" +
           "OizhZPjS5TWzV/m4tHwhfj7+wt6gH00B0AKgpmA6hoGd3j2KcKbbxmymSz0o" +
           "nNKMLFbYlA20jTRjaGPOCPe/Vt6fCSZuY4E3Fz7DikT+y2bbddbOFv7KfMaj" +
           "Bb8Tvjyon37jt3+9jx+3fX00u+79QUK7XZDFFmvj4NTquOCQQQjQ/fFk7PgT" +
           "Nw/v4P4HFIvLbRhkbQSgCkwIx3zo5d1vvvP22df9js9S1KAbGoUgJsl8Qc96" +
           "plZrFT2ZqzsiAeopsAJznOA2FRxTTsk4oRAWJ/9qXrLy+Q+PtQhXUGDE9qQV" +
           "d17AGf/MBrT/1YcmO/kyPondus6xOWQCymc4K683DDzO5MgfuD7/2y/h03Ap" +
           "ABCb8gTh2Ornx+DnmndQNL8sVjB06Idws6kWlaViSQgn7ZEp94NVnD7M2/vY" +
           "AfK9EJ/7EmuCpjueikPWlW3Fpcde/2ja9o8u3+LaF6drbvfpw3q38FjWLMnD" +
           "8rO92NWDzQzQrbrS/7UW5cptWHEYVpQAn80BAxAxX+RsFnVt3Vu/+GX7zms1" +
           "yL8JNSoaTm7CPG5RAwQMMTOAwnn9K/cLZxlj7tPCVUUlyjP7LChv+Y1ZnXJb" +
           "Tfxk9o/Wfu/M29xPhVfOtezEskQvxPJU30GHD2889e7PJ79bJxKFZZUh0cPX" +
           "8c8BJXHwL5+UHDIHwzJJjId/OHzh1JzIug84v4NKjHtxvvT6Atx2eD93Pvt3" +
           "f1fgRT+qG0YtkpVWb8dKjsX6MKSSpp1rQ+pdNF+cFoocqLuAuvO8iOja1ouH" +
           "zrUJfUbN+tM8EMjtGoRPsaBB8UKgD/HOFs6ylLfLWLPCRpw63ZCh/CIevGmu" +
           "sigF4SAAWX+1gFjWdrMmKpZZV9H7NhbLvhi+rLVNtoLsQ0J21vSXClmJm6Ka" +
           "jMzhbY1Hxm1VZMyXPyc/695LUcDkRY5zVjyMZnqzQTc2O/HisxGrszJisUyH" +
           "IcX8Snk9r0nOHjxxJjlwbqUIqrbiXHkjlILP/P7fvwmd/NMrZRKwgFWXOXLV" +
           "wH6LSuK4j9c8TlCsuT5Zc+PxjqbSLImt1FkhB1peOeC9G7x08G9zhtZldt5F" +
           "+rPAc0reJb/fd+GVB5dKj/t52SZisKTcK2bqLo68RoNAfaoOFcVfV8H8s5m1" +
           "53PPEX/58ilIpeAL6LmE4vYn7tbTqyxY5RYzqszxQBiBDdOE3Yg8LJyIUO4U" +
           "tUV3BhuI8OF0Qe4OO5j3WHLvqXIQrFFLVa7EWkWtR6rM7WfNOEVTQWU7Z+CQ" +
           "5eg98T/rPYNNLYDvkCX8obvXuxJrFd2OVpn7BmsOUdQEekcy7IJJkjzPbVwh" +
           "zl7XBnMJk8YMOQvp7ahV+19qn9z9q7qJB+y6vhyLoNxi9l39ac97cR6u9QwP" +
           "CkHiwoL1RtqVu7cI5T+FPx98/2Efk5sNsF+4PSNWKb+wUMvrOpO+SubgUSG8" +
           "t+2dkVPvPyNU8KYJHmJy5MTRT0PHTgigFA9Ci0veZNw84lFIqMOab+Y5fFbZ" +
           "hXNseu/S3p89vfew37ISJM01svVWxyzoK1St7d5DF5IGVp7+x75H3xiAMqsX" +
           "1edUeXeO9CaL0arOzCVcVnBekBzssmRmJ06Rb7luZXQ8HB69+3DIQ8lSKNHt" +
           "+y10dzU+6NxR8tgoHsiki2ea62ef2fYHXlwWHrGawONSOUVxp0iufkA3SErm" +
           "6jaJhEnnP+cqlRS2aBTV212uy1nB9zRFM8vxgQmhdVP+gKIWLyVFtfzXTXeR" +
           "okaHDmBZdNwkP4TVgYR1n9Ptk23huTrLLUMit8z7XBc5ctly1p1sWWBxV6ss" +
           "tvjzsO1+OfFADMBwZnP/w7c+f05Uy5KCJybYKlPB6UThXriUF1VczV4r0LPs" +
           "9vRnG5bYsdAqBHaQcq4LziIQFTqrU+Z46kgzWCgn3zy79vJrRwLXIYp3IB+m" +
           "aMaO0iw8r+cgY9gRLRdekLLwEre78d2dVz95y9fGix0rIDurccSl45dvxFK6" +
           "/h0/auhFtTJDW14iPDCubiXSqFEUrYGEllMLL8nTmUNj9nTMT8Y60GmFUfba" +
           "QlFXKR6VvkBBHThGjA1sdSv6i9KYnK67Z/nJPiWgQABvTTzap+sWEAdu85PX" +
           "dR7kL7Lm1H8BPeXBtAMaAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aeczsVnX3+17eSpL3sqeB7A/axPTz7B4rQPEsns0ee2yP" +
           "Zynlxet4t8fLjMeQFiIFEFSU0pCmEuSPKqgtCgS1pYtaqlRVCwhUiQp1kwqo" +
           "qlRaQCJ/lFalLb32fNv73ntJI1BH8p07955z7jnnnvPzXeaF70KnwgCCfc/e" +
           "LGwv2lWTaNe0q7vRxlfD3T5ZZcQgVJWmLYYhD9ouyw999sL3f/AR/eIOdHoO" +
           "3Sa6rheJkeG5IauGnr1SFRK6cNjatlUnjKCLpCmuRCSODBshjTB6jIRed4Q1" +
           "gi6R+yogQAUEqIDkKiD4IRVgukl1Y6eZcYhuFC6hn4dOkNBpX87Ui6AHrxTi" +
           "i4Ho7IlhcguAhLPZbwEYlTMnAfTAge1bm68y+GMw8vSvvvPib5+ELsyhC4bL" +
           "ZerIQIkIDDKHbnRUR1KDEFcUVZlDt7iqqnBqYIi2keZ6z6FbQ2PhilEcqAdO" +
           "yhpjXw3yMQ89d6Oc2RbEcuQFB+Zphmor+79Oaba4ALbeeWjr1kIiawcGnjeA" +
           "YoEmyuo+yw2W4SoRdP9xjgMbLw0AAWA946iR7h0MdYMrggbo1u3c2aK7QLgo" +
           "MNwFID3lxWCUCLrnukIzX/uibIkL9XIE3X2cjtl2AapzuSMylgi64zhZLgnM" +
           "0j3HZunI/Hx3+JYPv8vtuju5zooq25n+ZwHTfceYWFVTA9WV1S3jjY+Sz4h3" +
           "fv4DOxAEiO84Rryl+f13v/z2N9/30he3NK+/Bg0tmaocXZafl27+6huaj2An" +
           "MzXO+l5oZJN/heV5+DN7PY8lPsi8Ow8kZp27+50vsX8xe8+n1G/vQOd70GnZ" +
           "s2MHxNEtsuf4hq0GHdVVAzFSlR50TnWVZt7fg86AOmm46raV1rRQjXrQDXbe" +
           "dNrLfwMXaUBE5qIzoG64mrdf98VIz+uJD0HQHeCBKuAxoe0n/44gD9E9R0VE" +
           "WXQN10OYwMvszybUVUQkUkNQV0Cv7yESiH/rp4u7KBJ6cQACEvGCBSKCqNDV" +
           "bSeyWEUImBIFzEuANMTQkHmQVYyYB/FuFnj+//+QSeaFi+sTJ8AEveE4PNgg" +
           "s7qeDdgvy0/HjfbLn7n85Z2DdNnzXwTVwbi723F383F3wbi7++PuHh/3Ut5A" +
           "iYEFnTiRD3x7psk2KsCcWgAdAG7e+Aj3c/3HP/DQSRCO/voGMCEZKXJ9+G4e" +
           "4kkvR00ZBDX00rPr9wq/UNiBdq7E4Ux70HQ+Y2cy9DxAyUvH8+9aci+8/1vf" +
           "f/GZJ7zDTLwC2PcA4mrOLMEfOu7nwJNVBUDmofhHHxA/d/nzT1zagW4AqAGQ" +
           "MgK+y0DovuNjXJHoj+2DZmbLKWCw5gWOaGdd+0h3PtIDb33YkgfAzXn9FuDj" +
           "W7PIfz14gr1UyL+z3tv8rLx9GzDZpB2zIgflt3L+J/72L/+lnLt7H78vHHkj" +
           "cmr02BHMyIRdyNHhlsMY4ANVBXT/8CzzKx/77vt/Ng8AQPHwtQa8lJVNgBVg" +
           "CoGbn/ri8u++8fXnv7ZzGDQRdM4PvAhkkaokB3aezcy65RXsBAO+6VAlADs2" +
           "kJAFzqWx63iKoRmiZKtZoP7XhTcWP/edD1/choINWvYj6c2vLuCw/Sca0Hu+" +
           "/M5/vy8Xc0LOXnuHbjsk22LpbYeS8SAQN5keyXv/6t5f+4L4CYDKAAlDI1Vz" +
           "cNvJ3bCTW35HBN17zWTN0nPoKeo+1YPXpMpWATlp14jyOEBy+kfzcjdzYD4W" +
           "lPdVs+L+8Gg+XZmyR5Y7l+WPfO17Nwnf+5OXc+uvXC8dDR9K9B/bRmxWPJAA" +
           "8XcdB4+uGOqArvLS8B0X7Zd+ACTOgUQZAGRIBwCSkiuCbY/61Jm//9M/u/Px" +
           "r56EdgjovO2JCiHmeQudAwmjhjqAwcT/mbdvg2Wdhc/F3FToKuO3QXZ3/itb" +
           "cT5yfcgisuXOYdbf/Z+0LT35j/9xlRNysLrGW/4Y/xx54eP3NN/27Zz/EDUy" +
           "7vuSq/EdLA0PeUufcv5t56HTf74DnZlDF+W9dacg2nGWi3Ow1gr3F6NgbXpF" +
           "/5Xrpu0i4bEDVHzDccQ6MuxxvDp8r4B6Rp3Vzx+DqNzvl8Bj76WufRyiTkB5" +
           "pZmzPJiXl7LiJ/cR4YwfGCuwqNjDgx+Czwnw/E/2ZMKyhu0S4Nbm3jrkgYOF" +
           "iA9eeTe4IFky3sIWDrOylhWtrUjsupHytivteBg8zp4dznXsoK5jR1bt5M7p" +
           "RtBJ3chxp3RMoeGrKpQLSE4At5wq7aK7uUX8tYc8GYEdSCzZBoCn02G+OQBc" +
           "muGK9r4ed5m2fGnfaQLYLID4vWTa6D6yXMxTL4uU3e0K+5i+3f+zviC1bj4U" +
           "Rnpgsf6hf/rIV37p4W+A+O9Dp1ZZbIKwPzLiMM72L+974WP3vu7pb34of0kA" +
           "PzLPtC++PZP6+HWszqrTrJhlxXzf1HsyU7l87UWKYUTloK4qubWvmPZMYDjg" +
           "9bfaW5wjT9z6Devj3/r0duF9PMePEasfePqDP9z98NM7R7Y7D1+14zjKs93y" +
           "5ErftOfhAHrwlUbJOYh/fvGJP/rNJ96/1erWKxfvbbA3/fRf//dXdp/95peu" +
           "sSK8wfZ+hImNbvpOtxL28P0PWZxpk/U4SSYaDTNpYz1HcEqy1xW8ajVbVmCy" +
           "o5IfcGtcMNaYBc9mw3EBFmelaoxO0E05hlO6NJG7a09pjwZ6U+RwX5o1kKbj" +
           "D5oiy3pFMRotXXHYczmi3TGHC3tZMOdIv1NqEkzVc/tiqTaP52UlxlYjuD2I" +
           "plzqFd2yH1UlrIquyvaKjJJ2JIqN2OXCvtvpmfGq3aKEGVOZDa3NyGya0rDH" +
           "GkOuoCFaN9WqdF1srXR21tCHaamZ8vWeU+JGfH9i0R7ibER7EHIhH/Y3fJ/u" +
           "9DrUzEqMJVijykPPdtLS3BUI2+FFfzPu9zCDNjl9mcxHomz0u5wIF/H2mAQT" +
           "JlJ92VkNq2ShUST4+cAx05CSK96st6xUWT8qYibli54br5dUxR3Qm7aHDvpx" +
           "me7AC3UqMJ1Cxe+MNiwzQuNxUZk3pF4tJk2nEziqxKAoNhmIRLdOUcHAE6vc" +
           "UpxUgFNFyuqMp8M01jv6hB+W1QUrNIbEuFhuE/jExJZzvdQaUQ4W1Gh7tEB4" +
           "zqgGPdYUoxY6HzfjcNT2HJ2tc73a0G1NJobUmc9mQm3p2HRJ7kisPInI6RAV" +
           "uokxXTX7KFocU1E6FPVqpzUlawbOs+uePuisNy1cGYQL23DomOfmPZldFpad" +
           "7mbUafUnVdwlS07JcYlZks7aZInSmg2XqlEgiVPbafTH7XJvo7ApZ3g23Kfn" +
           "WnHqFPvrjstGSnkkdJyqUak1Ft560+xwFrVy1IRvOGyR48teaUAvPLRBjnE8" +
           "6ArzkTkUZ2LoD7xZo9icyyxFLGlz3UuXqrOQ2AmeyIV4gAmTPqdEs5rdnq8d" +
           "eebVVt1RQo2EcUtbLzp4RIRoYmnNybqgbxhbSEux4iBYZLZED1myaW1Ejy1L" +
           "ly2EmC9qzDiRuBkYkO7jVGsWmWmtXyrWKxVL7hkdpWrg06GJaHLsYkS1Opk2" +
           "5LJMmaOWIRTbntv1pQ5Zi6YOOxfgcDYhx7Wq51MwNRXlmkl2pKFCK8VRPyit" +
           "PT+kHJaZRm6tVkNiplCH6wOmM9W50bAJ5PLY0pa4kDRWbbXf9BKqOe53IxYv" +
           "dvg2j2oGvFx0q4LQs2bdseHwBaJSYFWihc/KSKugjhfGdNbmhea0OOedqDyl" +
           "5PJas6vdJlVqtmqlppTInIZspj2jJBeknmU2J+Fm6U1M3RIL1frc7lA0JXY0" +
           "nbCV5kbDkYIWT1lbbKdi0cXbdEcRKaVhtIQS13PwjcuWrBnf77XjxNRbijH2" +
           "uU5vqZsOryeGudQQBNWosEjPKFVKF7Ouo6pEYyGbywLLLsxC6Mp6WCoH3kwr" +
           "TirdRTitIWsPXpBhJyFRfWXAPWVRntN1qR5XpCo+xEoNvcHoiKY2RZ7tLohS" +
           "d9Qu4N1FPHHnlaFcRtOUE0ZMvOxhQ3xGrQvLsV0sTtsLti3BMMPpk0jq12C4" +
           "6JqqiWzwIe5UAn+N9op6YV5ZBCmGW9aCBxDHoiV8IQZuotn9cWvKW1XFaaGr" +
           "ENvQSjrFiXhN6E0qlOWZ2lBLzW7QWmGbWjrTgNEmZ5XDYmNtDFB9itJGqs8Z" +
           "k6vyk1RAnErUXeuaicLrqLboFgqNAj5Y+A5e072OUjZLA3kgSYmzcbi04LnD" +
           "AUUS0szGSwWTB2nfYegmoyJCVNOa3DyeVdplIkVbhsXDm5IkKYpEEyt0oFGi" +
           "2ZDq/MrceG4ZNaMyjJkJXNamhUIMo9hoPECn8xZBOCuzMuSXMd0cjUbmCNEI" +
           "C2UW/HCNrCpMpUv0VqTE6pY04hZNa91LyqlXVYqr1YoplRQNM0OMKw5wqeON" +
           "F/3Qro9krObb84DgS/NlGhq4CgIe76cujZcINuH50Kp4LD7pI9hyGpAbeAQz" +
           "0UifjjutNrYcCUoRxTsaQjUCHinOZIdGrA3juUoc1hJ6MmpuHLkyqNXLrVZK" +
           "V6mFFrdQpLRB9EIZ9/FGU6oveL1Eg1mDW67jKqMhWQ8Fs1Go9ZR1WLMmtigY" +
           "3GjhovO2j1WGgttCqRKymuHaAGv3EbTtxE3fjFXDYib2pEz4sqIiJVPEvHpc" +
           "hkmRqCmBtNL8dXlZrhPmhKTcVj2gsdJw0kpH6SiQAg5Bx5Oq7EeTbnsm+CPc" +
           "rRcaeIInU5gNCVeIykKMwJ0pmjphcUPW+0POE3kHbTKdKouvRxTF0/jadbEB" +
           "IpPzxDbRiGkK47G9MRmUbOoreFacu9O+xGuJhXnIRIsRqoQljC5odKSm7dAa" +
           "rRKmPy4XOt1WqV7HVJTpo5jUTwbEfD7WCzIzrcv1Rn/aXZNVeNxt9brrtN83" +
           "ewpCd1O92E978aJeWVWGA7MbJasVX8OjpKS2sDKzispaUVuwPLzsFGaR5QsT" +
           "qa4MTJC61IDjfL8YjGBfGRKwTHievCRjPF7RdfDWFYte3E2DcV8bS0M4oupt" +
           "yow6HsuEYqNRHw8WLaRLE2FtY5MaOSGZJuuva+V5U0eaPXXVceLQWBAVDscn" +
           "U7i4AL5XAsoZ+PO5gHXRoS6RK92AA1IYRh4ZjgoAvlfctGk7fac2EE0q1aVZ" +
           "sZs4RWFObabMRkZqWJUcyy2LnVVTwdxQc3eZjni5RCNdI0w6QZj2jXC86fbk" +
           "aZ1zLSwouHTXTJK+aa+l5bi3DCRj2rVMu0cyCINqq7WjIEMqmLOD9YKYTOkp" +
           "Kay7NZKLBxUTk+u83QxjvjqXYSYxlxJH9pyoSFh6o+irtNrEOmhSqHewVI/m" +
           "thJVCThgcLkQqH0J0RS4IzSqwM9IVC1xcyMc8PKgJC1Jr1ZnvSGuiR5NyIIm" +
           "1Lv1sOoUq2WGaU+Rat2we76KkzXSaVdWMxeNJH65SWZVdpYuwzQZNYxGS6Hb" +
           "5dmiTvY3vTFdGUdjodzQ416dJgojtULTVbM86ZKr5bQ3CgiCFES0PbEmEVsL" +
           "KHSiDem2wI8mY3QON0dVdYHVeSRgZsMhOWutrOa07kmraZz0A0Ip0YLvog0n" +
           "pMfKqK1a8gbt9fuWmTKSsNZTG52CNUXfqs8oerTyUVEX4CK2dLEUW6LLfgPe" +
           "1Fb6hvSGiYHZZUyUMVRmazE2WjNNq2usPbLIRkshRuVelYcJJsHqSKmtWdVw" +
           "GBJwheGGk4EEr8fUKqB9GuZiaTHmOvUILimWwKyYzXBcH8z6Xae/qVI8yxeY" +
           "Lr8AQYdjTaOwUufDdb1iE70lRYsSPKtqhDTXp8NQjRGu7Nexlaauy2iP61OF" +
           "YrgSJskm9QZFLkKVaouo9jqCj8IJWu2WEwOnluG0qCpjdarSWFMkC2JAp01B" +
           "FtyGajXSMHRYp1+osRJqx/PpqN5t1DC43OqN6jY3GHYjeFMsKOkYrg0Tth4t" +
           "vG5oWEZJFWslVStps+7UXk+6QUdc00OOHguJXzBizcLLXDtwaqbY19uuy8Dy" +
           "0ma5ktjghVKxFG+KbgNLWYKqr5LFyNEVgYEXg96E3AhEpKVTfqqyniV2W05j" +
           "rgzXFlPhhcWMLboYE1mlsh7zAUmOKSOqp2Ai5aoc2ZuiXwwnk0Yi1MIwWoEV" +
           "NV2EaY3AWxTYmbgMskZlWCtUx5vqoNnfSLOBzTRqY16fBsaYKApyKlSCAsmE" +
           "2Ip1O1VpFir4stEVR/KyQqZGb0Twy2AMzys1a5FOmgu3nG5QbNUP2DU57c38" +
           "cq8BOyIl0gVjXQ9geTHDFizJKqpFkut2oKJ1paQIKVbdYFrHSApBrwV2qDJn" +
           "V6rKKiEGNfBmQcRYJyK+35oUKwbTasYg67kl0R4Hs07btimSrLu8Mx6amMtT" +
           "fH1WK3QcYqxJ4sgmpgO2JqysRqPL6x0TL4YKt6oZ2GDmDmroHHH7jDFZjPDG" +
           "iudT0YfDSRtX4nqVmSosapEo6RS79QajThsRTolgd/fWbNu3fG0771vyQ4aD" +
           "Oz2w4c463vEadpzJtQfcyao/lQ94eFacH+vdfvx66OhZ8eGB34n9c477rn+C" +
           "ml19ZHvwe6930Zfvv59/8unnFPqTxZ2981Q7gk7v3b8eDncSiHn0+gcNVH7J" +
           "eXjI94Un//Ue/m3646/hNuT+Y0oeF/lb1Atf6rxJ/ugOdPLgyO+q69crmR67" +
           "8qDvfKBGceDyVxz33Xvg/bsyZ9+bT9r2k1z7RuL6Z2TTbdi8wln1B1+h7xez" +
           "4ing/IWanXvnZ2yHMfa+VzvVOCoub3jywLK79w8A371n2bt//JY98wp9z2bF" +
           "L0fQ64Bl+xcA+ZnmoXkf/RHMuy1rvB88T+2Z99SP37xff4W+57PiExF0IzCv" +
           "qWeHzsrege/iCDpYEXTS2PuDRW7yc6/F5CSCzh1cZ+6n/u5ruw8FKXz3VX/M" +
           "2P6ZQP7McxfO3vXc+G/ye8CDC/9zJHRWi2376Gn5kfppP1A1I/fBue3ZuZ9/" +
           "ffZ6tz/7qkXQ2f1qbsuLW77fiaDbr8UHPAfKo5S/F0EXj1NG0Kn8+yjdH0bQ" +
           "+UM6kFvbylGSPwbSAUlW/bx/jcPj7TVDcuIIGO5FYD6Lt77aLB6wHL1YzAA0" +
           "/yvNPtjF2z/TXJZffK4/fNfLtU9uLzZlW0zTTMpZEjqzvWM9AMwHryttX9bp" +
           "7iM/uPmz5964j+w3bxU+zIYjut1/7SvEtuNH+aVf+gd3/e5bfuO5r+dn2f8L" +
           "L4yUEuMkAAA=");
    }
    public BasicTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "65++9g+f+FZxEfR/KVNQHrcoAAA=");
}
