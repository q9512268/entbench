package org.apache.batik.dom.svg;
public abstract class AbstractSVGPathSegList extends org.apache.batik.dom.svg.AbstractSVGList implements org.w3c.dom.svg.SVGPathSegList, org.apache.batik.dom.svg.SVGPathSegConstants {
    public static final java.lang.String SVG_PATHSEG_LIST_SEPARATOR = " ";
    protected AbstractSVGPathSegList() { super(); }
    protected java.lang.String getItemSeparator() { return SVG_PATHSEG_LIST_SEPARATOR;
    }
    protected abstract org.w3c.dom.svg.SVGException createSVGException(short type,
                                                                       java.lang.String key,
                                                                       java.lang.Object[] args);
    public org.w3c.dom.svg.SVGPathSeg initialize(org.w3c.dom.svg.SVGPathSeg newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                initializeImpl(
                                                  newItem);
    }
    public org.w3c.dom.svg.SVGPathSeg getItem(int index)
          throws org.w3c.dom.DOMException {
        return (org.w3c.dom.svg.SVGPathSeg)
                 getItemImpl(
                   index);
    }
    public org.w3c.dom.svg.SVGPathSeg insertItemBefore(org.w3c.dom.svg.SVGPathSeg newItem,
                                                       int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                insertItemBeforeImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPathSeg replaceItem(org.w3c.dom.svg.SVGPathSeg newItem,
                                                  int index)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                replaceItemImpl(
                                                  newItem,
                                                  index);
    }
    public org.w3c.dom.svg.SVGPathSeg removeItem(int index)
          throws org.w3c.dom.DOMException {
        return (org.w3c.dom.svg.SVGPathSeg)
                 removeItemImpl(
                   index);
    }
    public org.w3c.dom.svg.SVGPathSeg appendItem(org.w3c.dom.svg.SVGPathSeg newItem)
          throws org.w3c.dom.DOMException,
        org.w3c.dom.svg.SVGException { return (org.w3c.dom.svg.SVGPathSeg)
                                                appendItemImpl(
                                                  newItem);
    }
    protected org.apache.batik.dom.svg.SVGItem createSVGItem(java.lang.Object newItem) {
        org.w3c.dom.svg.SVGPathSeg pathSeg =
          (org.w3c.dom.svg.SVGPathSeg)
            newItem;
        return createPathSegItem(
                 pathSeg);
    }
    protected void doParse(java.lang.String value,
                           org.apache.batik.dom.svg.ListHandler handler)
          throws org.apache.batik.parser.ParseException {
        org.apache.batik.parser.PathParser pathParser =
          new org.apache.batik.parser.PathParser(
          );
        org.apache.batik.dom.svg.AbstractSVGPathSegList.PathSegListBuilder builder =
          new org.apache.batik.dom.svg.AbstractSVGPathSegList.PathSegListBuilder(
          handler);
        pathParser.
          setPathHandler(
            builder);
        pathParser.
          parse(
            value);
    }
    protected void checkItemType(java.lang.Object newItem) {
        if (!(newItem instanceof org.w3c.dom.svg.SVGPathSeg)) {
            createSVGException(
              org.w3c.dom.svg.SVGException.
                SVG_WRONG_TYPE_ERR,
              "expected SVGPathSeg",
              null);
        }
    }
    protected org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem createPathSegItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
        org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem pathSegItem =
          null;
        short type =
          pathSeg.
          getPathSegType(
            );
        switch (type) {
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_ARC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_ARC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CLOSEPATH:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_MOVETO_ABS:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_MOVETO_REL:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_HORIZONTAL_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_HORIZONTAL_ABS:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                    pathSeg);
                break;
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_VERTICAL_REL:
            case org.w3c.dom.svg.SVGPathSeg.
                   PATHSEG_LINETO_VERTICAL_ABS:
                pathSegItem =
                  new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                    pathSeg);
                break;
            default:
        }
        return pathSegItem;
    }
    protected class SVGPathSegItem extends org.apache.batik.dom.svg.AbstractSVGItem implements org.w3c.dom.svg.SVGPathSeg, org.w3c.dom.svg.SVGPathSegClosePath {
        protected short type;
        protected java.lang.String letter;
        protected float x;
        protected float y;
        protected float x1;
        protected float y1;
        protected float x2;
        protected float y2;
        protected float r1;
        protected float r2;
        protected float angle;
        protected boolean largeArcFlag;
        protected boolean sweepFlag;
        protected SVGPathSegItem() { super(
                                       );
        }
        public SVGPathSegItem(short type,
                              java.lang.String letter) {
            super(
              );
            this.
              type =
              type;
            this.
              letter =
              letter;
        }
        public SVGPathSegItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CLOSEPATH:
                    letter =
                      PATHSEG_CLOSEPATH_LETTER;
                    break;
                default:
            }
        }
        protected java.lang.String getStringValue() {
            return letter;
        }
        public short getPathSegType() { return type;
        }
        public java.lang.String getPathSegTypeAsLetter() {
            return letter;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMV6C6zsxnneniPdq4cl3StZkmXFeli6dmKve7jLJXe5le16" +
           "l7tcckkuuUsu95E0Mt/L5XP5WHKZKk2MpjbqwjES2XGKRGgBB0kDxw6Kug1S" +
           "pFVRNC8HLVIEbZMgcVAUiFNVtRXHj0R13eHued1zz7m6VynQg8PZ4cw//3z/" +
           "/P/883NmPvdq6VIUlsqB72xMx48P9Cw+WDroQbwJ9Oigz6C8HEa6hjtyFImg" +
           "7Hn1mV++8s3XP7m4ul+6PC+9VfY8P5Zjy/eikR75zlrXmNKVk9Kuo7tRXLrK" +
           "LOW1DCWx5UCMFcXPMaW3nGoal64xRxAgAAECEKAtBKh1QgUa3a97iYsXLWQv" +
           "jlalHy7tMaXLgVrAi0vvvJ5JIIeye8iG30oAONxdvEtAqG3jLCw9fSz7TuYb" +
           "BP5UGXrxp37w6j+7o3RlXrpieUIBRwUgYtDJvHSfq7uKHkYtTdO1eelBT9c1" +
           "QQ8t2bHyLe556aHIMj05TkL9eJCKwiTQw22fJyN3n1rIFiZq7IfH4hmW7mhH" +
           "b5cMRzaBrI+eyLqTkCjKgYD3WgBYaMiqftTkTtvytLj01NkWxzJeowEBaHqX" +
           "q8cL/7irOz0ZFJQe2unOkT0TEuLQ8kxAeslPQC9x6fELmRZjHciqLZv683Hp" +
           "sbN0/K4KUN2zHYiiSVx65CzZlhPQ0uNntHRKP68O3v+JH/JIb3+LWdNVp8B/" +
           "N2j05JlGI93QQ91T9V3D+97LfFp+9Nc+tl8qAeJHzhDvaP7l33ntQ+978uXf" +
           "3NF8zzk0nLLU1fh59bPKA7/7Dvw9zTsKGHcHfmQVyr9O8q3584c1z2UBmHmP" +
           "HnMsKg+OKl8e/frsR35Rf2W/dC9Vuqz6TuICO3pQ9d3AcvSwp3t6KMe6RpXu" +
           "0T0N39ZTpbtAnrE8fVfKGUakx1TpTmdbdNnfvoMhMgCLYojuAnnLM/yjfCDH" +
           "i20+C0ql0gPgKb0bPH9W2v39aZHEpQBa+K4OyarsWZ4P8aFfyF8o1NNkKNYj" +
           "kNdAbeBDCrB/+29UDxpQ5CchMEjID01IBlax0HeVkOa7ULQ2oZYCzF5WY0Hq" +
           "8QCGoJuFmzgoLC/4/9BnVozD1XRvD6joHWcdhAPmFuk7mh4+r76YtLuvff75" +
           "L+0fT5jDEYxLHwQdH+w6Pth2fAA6PgAdH5zf8bWTVyrW3dLe3rb7hws8O+sA" +
           "urWBlwC0971H+Nv9D3/smTuAWQbpnUAxdwBS6GI3jp/4FWrrPVVg3KWXP5P+" +
           "qPR3K/ul/ev9cSEDKLq3aM4XXvTYW147Ow/P43vlo1/55hc+/YJ/MiOvc/CH" +
           "juLGlsVEf+bsaIe+qmvAdZ6wf+/T8hef/7UXru2X7gTeA3jMWAYWDpzRk2f7" +
           "uG7CP3fkPAtZLgGBDT90ZaeoOvJ498aL0E9PSrZm8MA2/yAY44eKGfA0eF4/" +
           "nBLb36L2rUGRPrwzm0JpZ6TYOucPCMHP/tf/8Ge17XAf+fErp1ZGQY+fO+U7" +
           "CmZXtl7iwRMbEENdB3R/9Bn+Jz/16ke/f2sAgOLZ8zq8VqQ48BlAhWCYf+w3" +
           "V7//5T/+7O/tHxvNXly6Jwj9GEwmXcuO5by7EOvBm8gJOnz3CSTgfhzAoTCc" +
           "a2PP9TXLsGTF0QtD/d9X3lX94v/8xNWdKTig5MiS3vfGDE7K394u/ciXfvBb" +
           "T27Z7KnF8ncybCdkO5/61hPOrTCUNwWO7Ef/0xM//RvyzwLvDDxiZOX61smV" +
           "tsNQ2uoN2sr/3m16cKauWiRPRaft//opdipMeV795O997X7pa//6tS3a6+Oc" +
           "0+pm5eC5nYUVydMZYP+2s5OdlKMFoENeHvzAVefl1wHHOeCoAr8WcSHwQNl1" +
           "xnFIfemuP/i3/+7RD//uHaV9onSv48saIW/nWekeYOB6tADOKwv+1od2yk0L" +
           "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" +
           "+f8vjGzdFR4vAAA=");
    }
    public class SVGPathSegMovetoLinetoItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegMovetoAbs, org.w3c.dom.svg.SVGPathSegMovetoRel, org.w3c.dom.svg.SVGPathSegLinetoAbs, org.w3c.dom.svg.SVGPathSegLinetoRel {
        public SVGPathSegMovetoLinetoItem(short type,
                                          java.lang.String letter,
                                          float x,
                                          float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
        }
        public SVGPathSegMovetoLinetoItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_REL:
                    letter =
                      PATHSEG_LINETO_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoRel)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_ABS:
                    letter =
                      PATHSEG_LINETO_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_REL:
                    letter =
                      PATHSEG_MOVETO_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegMovetoRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegMovetoRel)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_MOVETO_ABS:
                    letter =
                      PATHSEG_MOVETO_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegMovetoAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegMovetoAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "x2btfwGHD59O+hoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVae+wsV12f3+8+2l7ae28LLeVK3xdqu/ibfcy+KCC7O/ue" +
           "3Xns7OzuoNzOc2d23u/Z0SqQCAhJbbStaKCJBhRJeWgkmCimPoGARpSgkAjE" +
           "mIgiCf1DNKLimdnf77e/+7sPWsC4yZ6dPed7zvl+vs/zmGe/CZ3yXChnW/p6" +
           "qVv+nhT7eyu9vOevbcnbG2BlgnM9SWzpnOfRoO6ScP/Hzn37O08o53eh0yz0" +
           "Us40LZ/zVcv0KMmz9FASMejctratS4bnQ+exFRdycOCrOoypnv8IBr3kSFcf" +
           "uogdsAADFmDAApyxADe2VKDTLZIZGK20B2f6ngP9DLSDQadtIWXPh+67fBCb" +
           "czljfxgiQwBGuDH9zwBQWefYhe49xL7BfAXgp3Lwk7/85vO/cwI6x0LnVHOS" +
           "siMAJnwwCQvdbEgGL7leQxQlkYVuNSVJnEiuyulqkvHNQrd56tLk/MCVDoWU" +
           "Vga25GZzbiV3s5BicwPBt9xDeLIq6eLBv1Oyzi0B1ju2WDcIO2k9AHhGBYy5" +
           "MidIB11Oaqop+tA9x3scYrw4BASg6w2G5CvW4VQnTQ5UQLdtdKdz5hKe+K5q" +
           "LgHpKSsAs/jQhWsOmsra5gSNW0qXfOjO43TEpglQ3ZQJIu3iQ7cfJ8tGAlq6" +
           "cExLR/TzzfHrHv8ps2fuZjyLkqCn/N8IOt19rBMlyZIrmYK06Xjzw9jT3B2f" +
           "fOcuBAHi248Rb2g+8dPPv/E1dz/36Q3Nj1yFBudXkuBfEt7Pn/38K1sP1U+k" +
           "bNxoW56aKv8y5Jn5E/stj8Q28Lw7DkdMG/cOGp+j/nzxlg9J39iFzvSh04Kl" +
           "Bwawo1sFy7BVXXK7kim5nC+JfegmyRRbWXsfugE8Y6opbWpxWfYkvw+d1LOq" +
           "01b2H4hIBkOkIroBPKumbB0825yvZM+xDUHQS8AXejUE7dwNZZ+dC2npQzas" +
           "WIYEcwJnqqYFE66V4k8Vaooc7EseeBZBq23BPLB/7ccKe1XYswIXGCRsuUuY" +
           "A1ahSJtGWLQM2AuXcIMHZs8J/oTpEoCNibRMw8Reann2/8OccSqH89HODlDR" +
           "K48HCB34Vs/SRcm9JDwZNNvPf+TSZ3cPHWZfgj40ABPvbSbeyybeAxPvgYn3" +
           "rj7xxe3fkRVKvpWq0rf6vmRAOzsZKy9LedtYCmjUQMQA/W5+aPKTg0ffef8J" +
           "YKJ2dBIoaReQwtcO6a1tjOlnkVQAhg49957orczP5neh3ctjc4oHVJ1JuxNp" +
           "RD2MnBeP++TVxj33jq9/+6NPP2ZtvfOyYL8fNK7smTr9/ccl71qCJIIwuh3+" +
           "4Xu5j1/65GMXd6GTIJKA6OlzQGogMN19fI7LnP+Rg0CaYjkFAMuWa3B62nQQ" +
           "/c74imtF25rMJM5mz7cCGZ9LveEh4Bb37rtH9pu2vtROy5dtTChV2jEUWaB+" +
           "/cR+39/95T+XMnEfxPRzR7LkRPIfORJH0sHOZRHj1q0N0K4kAbq/fw/xS099" +
           "8x1vygwAUDxwtQkvpmULxA+gQiDmn/u086WvfuX9X9g9NJodHyTSgNdVIT4E" +
           "eWOK6ex1QILZXr3lB8QhHfhlajUXp6ZhiaqscrwupVb6X+deVfj4vz5+fmMH" +
           "Oqg5MKPXfO8BtvWvaEJv+eyb//3ubJgdIc2DW5ltyTbB9aXbkRuuy61TPuK3" +
           "/vVdv/Ip7n0gTIPQ6KmJlEW7k5kMToJOD11nLeSqBtBGuJ8/4Mdu+6r23q9/" +
           "eJMbjiebY8TSO59813f3Hn9y90hGfuCKpHi0zyYrZ2Z0y0Yj3wWfHfD9n/Sb" +
           "aiKt2ETl21r7qeHew9xg2zGAc9/12Mqm6PzTRx/7/Q8+9o4NjNsuT0htsN76" +
           "8Bf/+3N77/naZ64S4055iuVuFmK3g1VeJu90obC3WShkDfm0QDZGVfFTY7e4" +
           "TPmvy7DBWcPDWbmXgsk0AWVtb0yLe7yjoeZypRxZHV4SnvjCt25hvvWHz2d8" +
           "Xr68POpZI87eSPVsWtybCunlx+Nqj/MUQIc8N/6J8/pz3wEjsmBEAaQTD3dB" +
           "4I8v88N96lM3fPmP/uSORz9/AtrtQGcASrHDZSENugnEEgmIShdj+8ffuPGl" +
           "KHWu8xlU6ArwWcWFK4PNg/t++ODVg01a3pcWr7rSha/V9Zj4dzbB4EClF9Ik" +
           "FpWEw9y1TVLZnKPraI9Mi17W1EiL/gYW+oIksKG9M/t34vpu2UnXx9uUcOd/" +
           "4jr/tn/4jyvMIMtkV/HUY/1Z+Nn3Xmi94RtZ/21KSXvfHV+5HAB7iW3f4oeM" +
           "f9u9//Sf7UI3sNB5YX+jwnB6kAZqFizOvYPdC9jMXNZ++UJ7s6p85DBlvvJ4" +
           "qDgy7fFktnVR8JxSp89ntiaPxDsg2J8q7lX3Mt9808ZusvJiWjy4kXr6+KMg" +
           "K3jZhif1XNXk9GwcxAc+owsXD6IOAzZAQMQXV3o1bX7t1hwbR7z/2ppnDvgC" +
           "mj67jSKYBTYb7/7HJz73Cw98FahjAJ0KU1EBLRwJNeMg3X+9/dmn7nrJk197" +
           "d5bQgAETT7fPZ+FDvB66tLiUFo8ewLqQwppkS0eM8/xRloMkMUV2tWh2Ugcs" +
           "ft9o/Vue7SFev3HwGTELeRZN43gm46X6souMYFBpdNFWd92npQ7VBZFzoS26" +
           "sSd4C9OIGxG9qBZK9rruYVK1OqqybEVoq4NJY9qnJv0B1W3y08mwm2/3Zw42" +
           "c6etNj11JjNjaHW6PBozXH2R03r5lWLWW0M/0MEQQUkqeTIypCbY3KiZppmw" +
           "ZjUMZaM+LhGVgWok9HjgTTq20HLb8bLgKMNeuTcQcbU2ZxnPWY/zzYBG4cSu" +
           "4VU+rJSE7prWG0Xa8bp0YT0YdPB45sROvjnSZQprsfbInRanTbfXZbr0zCcF" +
           "jVVVLhprijEoDKICo1HzmVUT7JaxniQN1dbiZaIL7alVLxYbGm9QshJEZlRC" +
           "RCa35Bd9h2ULi9pazA+WBUvMJ4o7GIhJEdNEty8aervlSAvLWqxUb87lVbYc" +
           "jVEGAGLYdZdjnZ5fWbp8G/dWwxI2yhMxl0zE0lxRg/KMWwwMg0tWSttB6lyw" +
           "sltI3JkgMFt0UMquTihCK/f7hhRRrEPqiBpxijZHvaGKFsqzVmmaU2aqy7rm" +
           "CEnGnSnvqUh/upixLS8edMbDouGo8ii3tBYYWyR0jUQ9eFlnYz+CVTXKtVel" +
           "xF2LlqzbLa7BDFccUUR6lFaMZi2qQTcsmixP8gDxqk4gjaFJR3ivXuiQGkMZ" +
           "pZAphMMpzsWdPtmwyqyHjvXpAA8rojUkGuYiGdAjER2hWK2LrsNKiA07QxJp" +
           "FSJh6rR7rEpELW9qNFesNmwVMdzU8TLpoyph5SK2u4j8FdJv0IPi1O7Gi2Qd" +
           "M45mkqRkd9ShOhkrdKDkUFrRWnm6L5DjnuF1GGBvq4UmLYQ81cVHCYFhlDAl" +
           "gRrWZK4xpQweifmlUesMV0nek+B6IngEtpwWnHlHJZvFHi6sVTeQk8GICwfj" +
           "ijMacHofaRYHap3F+lPOVGACWfYnjVq0Fjy2V12vmIDAusVKbsiRBjvu2aYY" +
           "4WWGpVGkjBNzR5aK/nxtNnmGXATObFmr4mStMJr5U5nLLxcRPR13+1Gla466" +
           "mMzDghcITM4Vlo5kGWV+GNh2n6RKs7W5Iqc667pOmx2rYgcZVwxtBjS3Kkn0" +
           "RG6IU5p0JNOjW4tgzetDp+aU16ZcIwaa02itKKozj9yZNiiFy+IAlYnQb7f7" +
           "BrmGWbStLCd8S46G4yI6UJW+XBg0CpjnkLahVHBj5aoUIq4Tpz2TR6JSGKPo" +
           "MkZhvFqJMIIii+MBPVhS2gyVepEyaMd0g1nmuoi5jPl+nlAKixFZt7FRbiX5" +
           "aq1fzAUa6entfr8GI0RlzVIrf9SN8u2oPS/lSL2l8ARjc37MebzWr2iFHi9K" +
           "KyY/ixZCL3YXy37OVxC2ucBHJHCCXqvPLBG9ByudUJZ7ZrE9UgriWqYCyh5p" +
           "bbzJG4tytV1ut5ZJ0BjNmpI4C+F2LihVZ7VgSTUKlBY2J9M2OWfXdOTbImf2" +
           "1uQ0ysn8PKzbs5JTQAaa2oqSdUsboRLhd2m9zba7NFM0hElrTSpmZyEyEUKt" +
           "J2IMa4jbo0LWL8rlXhiVPW7abbNe08ZX66HCllmrxoxbhJsv5JJqpYwn1Jy3" +
           "MVQ3yrFmUDiNU0LZra9CCV3VdKysheYiEEs+SQ2GVIPVUImOumZDzZdyY36I" +
           "2LWSIgjUpLFo0IFtTJlmvF5j0hBlw4ozDtF+dYjL+VqvU5eXi9m6M01MmbBL" +
           "NQxBit3xCu80u6ORNEYjmWgXYGeM5OBcWYWxgDdEvYOtHHJeGc7CJN9cOk5O" +
           "ajOS1EXaHD210WpU7VkIJYZVPxwiUU3rBCzvNea86DRCodVd5EStJFbLJQR2" +
           "ByIyZI1GPlrjuE1O1EFeMcjOQrE5pUt2cTmQrUaX4Rqd1cCZxcmkP1FnyqQ/" +
           "cuIpsXbLdmddq9bhWctXQTKT7CiamXapOavCVZTRktzU5BMxHpNtNl9tuqOC" +
           "OBIIL8/AYydfprtCE7ZDUTbkMJiIzfW6ibYSexHTtMvppQandzSuUK7HKg9y" +
           "csPl+oZmTXpoR2UrlQTlxVK46tjysEjr8mDcZofEbFWYyz5fWCyiarDEiDG8" +
           "WNVVQ9KqIdcjBu0ZV4iioRy1EVSGc42wqyBVqlGx+KpA5+V4NFgNR2N8nfOn" +
           "KxvIRAmHYS62qqHco7ok0TQ5uxaV5rAWDSVlmZfa9TxZ9pKWaYUo3p7Mxss+" +
           "MdZLnVILcfzIEPOyqRQLtRwcFgO52GHqookFy7GbJDicg6WQ9OhcTl/I4boS" +
           "KyUQBirz/ohRejNiJFfh1rihT2pV2IPFpFriW/WEoif2xHD7CcWHq7lTAIHe" +
           "sMkFjJY6w4FYWinWfLRoTeImUUQJbLjyJTkddzERKU+edbt8A67XCjJeV9U2" +
           "Ven08UYYlzAm56hVgRCsTkRZcTQSsN7YQOmFaQ5w2iMJnKnRvapiLnImT7hI" +
           "pBaCBE+qy4GESSqFSlgfN/Jza82aOWq81GfCaFnPoR2UyYXMBJYaizwK1h5d" +
           "uAsXDLtl5wvmiJ0Gc3ruwnWmlucxnyOtoWg3nChOPN1cUv0B3wib85xT4+m4" +
           "1sJb8pSjVoZVZgZ9tOfB1ZCIR3m7ne+icBVJcmJOwhmsnEMSzSC4ssqvc3Kp" +
           "WKBKcgnJxaVFPNb89YzHSGaQg81RK29VSGpdpqnyfGjgZg9rY1WjnZ8L2Kyb" +
           "GCRcWLjjjtLB5JDVRniMzEc5fiHLZlRj244dNQtw6MYJ32YLba7goQ1nysRN" +
           "dM4TnlmYhqTITrmqaBQQpVWyYgMXZoHvR5OVW04Gbbomluk1MiwmVK5LdXUZ" +
           "Z0oCyyYi3GRktArjgTgfknUx0EtxxHXYAu92e4ZtDfXeAGuZeEVGOlgCrwuC" +
           "hDvILE87OGbkBLTKyJVlGab4SsxjCoLVKNUaBoM1zxOc5hsR7tJ9e44VC/yY" +
           "9RKLnqP9tVGkmjMul0SzFRFrBdHi7O6qVppQHl1arNDOBNdoltUqtarS5k14" +
           "SSH1oj0fNcS6g1QHywqSH5Oq1UCm3bknGUWhg7TyuWhUr/NeS5jFAuliq7br" +
           "eibqrsgCkQgVlcesPEP2aoRhIA3ODWZ8LTdf5ZWOqPLBDCcmsJefECgnmoi9" +
           "sMYEE+grBUi3Hy7gsbggzQAui0JhDFdLQ8VE4oYWT1tyKM9yfUcpFxF3PA1E" +
           "aWoYC9wae3SA55y8LgJNdfJExVqPl2W+jSQjhcGX6ooba7qjKuO5XQzoUbmm" +
           "JPmhgcFJAxlOvFqDlrEW6icju0zETCiHQ3dQtBzWLiNVQq7xdlzWK0EXLBRU" +
           "m7OkZchNRF5X8hbdopm2z60qwDrNxnoYt6QirjU7Fo7wa1K2i1RFNjSQNjg3" +
           "R/LTFl8dcG2ybObqgi0snDmm9xszDK3AfTffqKo4arLCKK4MXQJeqm1Z03qC" +
           "5616y3ZSVRZNY2JKLWD4AoE4VZXm9d5yrsShrspT3nTdgs0QKjltzmy5ExfQ" +
           "PuuqqMpPhrTXFKYFnAdGUndCmij4gt2hPWYySHiv5/bLptWEe6MKvhSZxMrl" +
           "ijzGaJhXCk0mLiNSqV4WpaXj14cNpb/KV9lKyaE7jXUsBMyYpGfrcRnzPZI2" +
           "UQwe+MwclsRgKlcj2ZFIHY+JmeeI6sjoJUi0lCml2611WhOmxJGj1mrI9dQm" +
           "o7pMkcaDVc1SWXEuuL06Rc+CRVOeWN1wMekZnbA7DtQp3arlhmhvYvYCKpkX" +
           "tGU9HAzR+dzqsdNRjZkjDjmKknCIiV6gLXWuq/aTTqDFKOF156UhOqsjEY4y" +
           "QlzkfTnq9tByHc8pFticvf716bbNfnHbyVuzXfLhRdv3sT+Or3aqk52RnDm4" +
           "lDn4PX6qc+f+oeb+Wc4D1z7L2Vw4NHjvBdNSkv4CaDdXGC9s3A0tGDc9kbvr" +
           "Wvd92ZHl+9/25DMi/oHC7v5JU9WHTu9fw25xpxfbD1/71GiU3XVuj24+9bZ/" +
           "uUC/QXn0RVyA3HOMyeND/tbo2c90Xy384i504vAg54pb2Ms7PXL58c0ZV/ID" +
           "16QvO8S569AMbk+1/gqg/ua+GTSvcy543GR3MpPdGOp1TvEev07bE2nx8z50" +
           "cin58+xId2vT73oxp31ZxduvxNXex9X+4eP61eu0vTctntrgWhzD9fQPgCs7" +
           "x70PSq8eNrj6PxxcO1uCzaH6b1wH3AfT4tcAOA8o7apnWqGlilvAv/7DADza" +
           "Bzz6PwL88esA/kRafGwDONPmh7bgfvsHAPeKtPJBwAa1D456MeB86CbbtXxJ" +
           "8CXxexrrH1+n7U/T4g986Cww1s21S3aenNa+dgv0ky/q8N2HLlz7NvoglsMv" +
           "8oIbxOM7r3jZZvOCiPCRZ87d+PJnpn+b3eMevsRxEwbdKAe6fvRA+8jzaduV" +
           "ZDUTwk2b4207+/kLH7rzWrz50AlQZhA+t6H+Kx962dWoASUoj1L+jQ+dP07p" +
           "Q6ey36N0X/ShM1s6kJs2D0dJvgRGByTp45ftA4G+4ft/YyDVS7xzJPvtW2um" +
           "+9u+l+4Puxy9PE4zZvYK1UF2CzYvUV0SPvrMYPxTz1c+sLm8FnQuSdJRbsSg" +
           "Gzb36IcZ8r5rjnYw1uneQ985+7GbXnWQys9uGN56zhHe7rn6TXHbsP3sbjf5" +
           "vZf/7ut+85mvZHcA/wt1lapI2yYAAA==");
    }
    public class SVGPathSegCurvetoCubicItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs, org.w3c.dom.svg.SVGPathSegCurvetoCubicRel {
        public SVGPathSegCurvetoCubicItem(short type,
                                          java.lang.String letter,
                                          float x1,
                                          float y1,
                                          float x2,
                                          float y2,
                                          float x,
                                          float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x1 =
              x1;
            this.
              y1 =
              y1;
            this.
              x2 =
              x2;
            this.
              y2 =
              y2;
        }
        public SVGPathSegCurvetoCubicItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_ABS:
                    letter =
                      PATHSEG_CURVETO_CUBIC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY1(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicAbs)
                         pathSeg).
                        getY2(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_REL:
                    letter =
                      PATHSEG_CURVETO_CUBIC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY1(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicRel)
                         pathSeg).
                        getY2(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX1() { return x1;
        }
        public float getY1() { return y1;
        }
        public void setX1(float x1) { this.
                                        x1 =
                                        x1;
                                      resetAttribute(
                                        );
        }
        public void setY1(float y1) { this.
                                        y1 =
                                        y1;
                                      resetAttribute(
                                        );
        }
        public float getX2() { return x2;
        }
        public float getY2() { return y2;
        }
        public void setX2(float x2) { this.
                                        x2 =
                                        x2;
                                      resetAttribute(
                                        );
        }
        public void setY2(float y2) { this.
                                        y2 =
                                        y2;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x1) +
            ' ' +
            java.lang.Float.
              toString(
                y1) +
            ' ' +
            java.lang.Float.
              toString(
                x2) +
            ' ' +
            java.lang.Float.
              toString(
                y2) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVaC7DjVnnW3WQ3myXZ3SQkbLbkvTwSpVe2ZUs2oRTZkp+S" +
           "JVu2bIvCRpZkW9bTeliy27SQAcKQDlC6hHSAMNMJpYVAaAtTOh3adFoKDEyn" +
           "dGhpO+XRx0yhNFMyUyht2tIj2ff67t3dS0M20ztz/6t7zn/O+b/zv87riaeh" +
           "w54LwY5tLMaG7W+rkb89NXLb/sJRve06neMk11OVkiF5XgeUnZXv/MSJ7z/7" +
           "rsnJQ9AREbpBsizbl3zNtry26tnGXFVo6MSmlDJU0/Ohk/RUmktI4GsGQmue" +
           "fx8NvWhPUx86Q++IgAARECACkoiAEBsu0Oha1QrMUtxCsnxvBv08tEVDRxw5" +
           "Fs+H7ji/E0dyJXPdDZcgAD0cjf8XAKikceRCt+9iX2G+APB7YOTce99w8reu" +
           "gE6I0AnN4mNxZCCEDwYRoWtM1RyqrkcoiqqI0HWWqiq86mqSoS0TuUXoek8b" +
           "W5IfuOruJMWFgaO6yZibmbtGjrG5gezb7i68kaYays5/h0eGNAZYb9pgXSEs" +
           "x+UA4DENCOaOJFndaXKlrlmKD922v8UuxjMNwACaXmWq/sTeHepKSwIF0PUr" +
           "3RmSNUZ439WsMWA9bAdgFB86fclO47l2JFmXxupZHzq1n49bVQGuq5OJiJv4" +
           "0I372ZKegJZO79PSHv083Xz1O37WqlqHEpkVVTZi+Y+CRrfua9RWR6qrWrK6" +
           "anjNPfQj0k2fedshCALMN+5jXvH8zs8989p7b33q8yuen7gIDzucqrJ/Vn58" +
           "ePzLLy3dXbgiFuOoY3tarPzzkCfmz61r7osc4Hk37fYYV27vVD7V/pPBGz+i" +
           "fucQdKwGHZFtIzCBHV0n26ajGapbUS3VlXxVqUFXq5ZSSupr0FXgm9YsdVXK" +
           "jkae6tegK42k6Iid/A+maAS6iKfoKvCtWSN759uR/EnyHTkQBL0I/EL3QtDW" +
           "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" +
           "LT/9kk+++sOPfT253/9fylRHEssuAAA=");
    }
    public class SVGPathSegCurvetoQuadraticItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs, org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel {
        public SVGPathSegCurvetoQuadraticItem(short type,
                                              java.lang.String letter,
                                              float x1,
                                              float y1,
                                              float x,
                                              float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x1 =
              x1;
            this.
              y1 =
              y1;
        }
        public SVGPathSegCurvetoQuadraticItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_ABS:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticAbs)
                         pathSeg).
                        getY1(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_REL:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getY(
                          );
                    x1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getX1(
                          );
                    y1 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticRel)
                         pathSeg).
                        getY1(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX1() { return x1;
        }
        public float getY1() { return y1;
        }
        public void setX1(float x1) { this.
                                        x1 =
                                        x1;
                                      resetAttribute(
                                        );
        }
        public void setY1(float y1) { this.
                                        y1 =
                                        y1;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x1) +
            ' ' +
            java.lang.Float.
              toString(
                y1) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "m9VrqZoeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "st99/a8//LX0du9/AWuwrqnDKgAA");
    }
    public class SVGPathSegArcItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegArcAbs, org.w3c.dom.svg.SVGPathSegArcRel {
        public SVGPathSegArcItem(short type,
                                 java.lang.String letter,
                                 float r1,
                                 float r2,
                                 float angle,
                                 boolean largeArcFlag,
                                 boolean sweepFlag,
                                 float x,
                                 float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              r1 =
              r1;
            this.
              r2 =
              r2;
            this.
              angle =
              angle;
            this.
              largeArcFlag =
              largeArcFlag;
            this.
              sweepFlag =
              sweepFlag;
        }
        public SVGPathSegArcItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_ABS:
                    letter =
                      PATHSEG_ARC_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getY(
                          );
                    r1 =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getR1(
                          );
                    r2 =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getR2(
                          );
                    angle =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getAngle(
                          );
                    largeArcFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getLargeArcFlag(
                          );
                    sweepFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcAbs)
                         pathSeg).
                        getSweepFlag(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_ARC_REL:
                    letter =
                      PATHSEG_ARC_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getY(
                          );
                    r1 =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getR1(
                          );
                    r2 =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getR2(
                          );
                    angle =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getAngle(
                          );
                    largeArcFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getLargeArcFlag(
                          );
                    sweepFlag =
                      ((org.w3c.dom.svg.SVGPathSegArcRel)
                         pathSeg).
                        getSweepFlag(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getR1() { return r1;
        }
        public float getR2() { return r2;
        }
        public void setR1(float r1) { this.
                                        r1 =
                                        r1;
                                      resetAttribute(
                                        );
        }
        public void setR2(float r2) { this.
                                        r2 =
                                        r2;
                                      resetAttribute(
                                        );
        }
        public float getAngle() { return angle;
        }
        public void setAngle(float angle) {
            this.
              angle =
              angle;
            resetAttribute(
              );
        }
        public boolean getSweepFlag() { return sweepFlag;
        }
        public void setSweepFlag(boolean sweepFlag) {
            this.
              sweepFlag =
              sweepFlag;
            resetAttribute(
              );
        }
        public boolean getLargeArcFlag() {
            return largeArcFlag;
        }
        public void setLargeArcFlag(boolean largeArcFlag) {
            this.
              largeArcFlag =
              largeArcFlag;
            resetAttribute(
              );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                r1) +
            ' ' +
            java.lang.Float.
              toString(
                r2) +
            ' ' +
            java.lang.Float.
              toString(
                angle) +
            ' ' +
            (largeArcFlag
               ? "1"
               : "0") +
            ' ' +
            (sweepFlag
               ? "1"
               : "0") +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "fln/P24Rz9KRJAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "4it/UtwZ+X+lJ83uMjEAAA==");
    }
    public class SVGPathSegLinetoHorizontalItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs, org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel {
        public SVGPathSegLinetoHorizontalItem(short type,
                                              java.lang.String letter,
                                              float value) {
            super(
              type,
              letter);
            this.
              x =
              value;
        }
        public SVGPathSegLinetoHorizontalItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            this.
              type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_ABS:
                    letter =
                      PATHSEG_LINETO_HORIZONTAL_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoHorizontalAbs)
                         pathSeg).
                        getX(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_HORIZONTAL_REL:
                    letter =
                      PATHSEG_LINETO_HORIZONTAL_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegLinetoHorizontalRel)
                         pathSeg).
                        getX(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "mHHOgSQAAA==");
    }
    public class SVGPathSegLinetoVerticalItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs, org.w3c.dom.svg.SVGPathSegLinetoVerticalRel {
        public SVGPathSegLinetoVerticalItem(short type,
                                            java.lang.String letter,
                                            float value) {
            super(
              type,
              letter);
            this.
              y =
              value;
        }
        public SVGPathSegLinetoVerticalItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_ABS:
                    letter =
                      PATHSEG_LINETO_VERTICAL_ABS_LETTER;
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoVerticalAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_LINETO_VERTICAL_REL:
                    letter =
                      PATHSEG_LINETO_VERTICAL_REL_LETTER;
                    y =
                      ((org.w3c.dom.svg.SVGPathSegLinetoVerticalRel)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getY() { return y; }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "RKzXNJ37WNmfuOdNk4PDz3DY8B/kicdcyhgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Q76ZSnkkAAA=");
    }
    public class SVGPathSegCurvetoCubicSmoothItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs, org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel {
        public SVGPathSegCurvetoCubicSmoothItem(short type,
                                                java.lang.String letter,
                                                float x2,
                                                float y2,
                                                float x,
                                                float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
            this.
              x2 =
              x2;
            this.
              y2 =
              y2;
        }
        public SVGPathSegCurvetoCubicSmoothItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_ABS:
                    letter =
                      PATHSEG_CURVETO_CUBIC_SMOOTH_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getY(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothAbs)
                         pathSeg).
                        getY2(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_CUBIC_SMOOTH_REL:
                    letter =
                      PATHSEG_CURVETO_CUBIC_SMOOTH_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getY(
                          );
                    x2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getX2(
                          );
                    y2 =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoCubicSmoothRel)
                         pathSeg).
                        getY2(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        public float getX2() { return x2;
        }
        public float getY2() { return y2;
        }
        public void setX2(float x2) { this.
                                        x2 =
                                        x2;
                                      resetAttribute(
                                        );
        }
        public void setY2(float y2) { this.
                                        y2 =
                                        y2;
                                      resetAttribute(
                                        );
        }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x2) +
            ' ' +
            java.lang.Float.
              toString(
                y2) +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "R2N61aIeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "vv8FLAWzh8sqAAA=");
    }
    public class SVGPathSegCurvetoQuadraticSmoothItem extends org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem implements org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs, org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel {
        public SVGPathSegCurvetoQuadraticSmoothItem(short type,
                                                    java.lang.String letter,
                                                    float x,
                                                    float y) {
            super(
              type,
              letter);
            this.
              x =
              x;
            this.
              y =
              y;
        }
        public SVGPathSegCurvetoQuadraticSmoothItem(org.w3c.dom.svg.SVGPathSeg pathSeg) {
            super(
              );
            type =
              pathSeg.
                getPathSegType(
                  );
            switch (type) {
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothAbs)
                         pathSeg).
                        getY(
                          );
                    break;
                case org.w3c.dom.svg.SVGPathSeg.
                       PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL:
                    letter =
                      PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL_LETTER;
                    x =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                         pathSeg).
                        getX(
                          );
                    y =
                      ((org.w3c.dom.svg.SVGPathSegCurvetoQuadraticSmoothRel)
                         pathSeg).
                        getY(
                          );
                    break;
                default:
            }
        }
        public float getX() { return x; }
        public float getY() { return y; }
        public void setX(float x) { this.
                                      x =
                                      x;
                                    resetAttribute(
                                      ); }
        public void setY(float y) { this.
                                      y =
                                      y;
                                    resetAttribute(
                                      ); }
        protected java.lang.String getStringValue() {
            return letter +
            ' ' +
            java.lang.Float.
              toString(
                x) +
            ' ' +
            java.lang.Float.
              toString(
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYfWwUxxWfO39gG4M/APMVDDiGCkLvigihrSkJGIxNzvhq" +
           "EwdMk2O9O2cv7O0uu3P24YQmICWgSEUROJRWAakqUZOIhLRq1DYVyFWqkChN" +
           "ETRqE6ImrSo16QdS+Ce0om363szu7d7eBzGp1JNubm/mzZv3Nb/33p65Sips" +
           "i7SYkq5IEbbPpHYkjs9xybKp0q5Jtr0NZhPyE3889sj131QfCJPKATJ9WLK7" +
           "ZcmmHSrVFHuALFB1m0m6TO2tlCq4I25Rm1ojElMNfYDMUu2ulKmpssq6DYUi" +
           "Qb9kxUiDxJilDqYZ7XIYMLIwxqWJcmmi64MEbTFSKxvmPm/DvJwN7b41pE15" +
           "59mM1Md2SyNSNM1ULRpTbdaWscgdpqHtG9IMFqEZFtmtrXYMsSW2Os8MLS/V" +
           "fXLjyeF6boYZkq4bjKto91Lb0EaoEiN13uwmjabsveSbpCxGpvqIGWmNuYdG" +
           "4dAoHOrq61GB9NOonk61G1wd5nKqNGUUiJHFuUxMyZJSDps4lxk4VDFHd74Z" +
           "tF2U1dZ1d0DFp+6Ijn/7wfoflZG6AVKn6n0ojgxCMDhkAAxKU4PUstcrClUG" +
           "SIMODu+jlipp6pjj7UZbHdIlloYQcM2Ck2mTWvxMz1bgSdDNSsvMsLLqJXlQ" +
           "Of8qkpo0BLo2eboKDTtwHhSsUUEwKylB7DlbyveousLjKHdHVsfWe4EAtk5J" +
           "UTZsZI8q1yWYII0iRDRJH4r2QfDpQ0BaYUAIWjzWijBFW5uSvEcaoglG5gTp" +
           "4mIJqKq5IXALI7OCZJwTeGlewEs+/1zduvbIQ3qnHiYhkFmhsobyT4VNzYFN" +
           "vTRJLQr3QGysXR47LjWdOxwmBIhnBYgFzU8evnbPiuaJ1wXN/AI0PYO7qcwS" +
           "8unB6Zdua1/2lTIUo8o0bBWdn6M5v2VxZ6UtYwLSNGU54mLEXZzofW3Ho8/T" +
           "v4VJTReplA0tnYI4apCNlKlq1NpMdWpJjCpdpJrqSjtf7yJT4Dmm6lTM9iST" +
           "NmVdpFzjU5UG/w8mSgILNFENPKt60nCfTYkN8+eMSQiZCl9yFyFlqwn/lK3C" +
           "kREzOmykaFSSJV3VjWjcMlB/dCjHHGrDswKrphEdhPjf88WVkTVR20hbEJBR" +
           "wxqKShAVw1QsRhUjFbVHhqLrByHsJZn19W+Ogxh9dAjRKIKRZ/4fzsygHWaM" +
           "hkLgotuCAKHB3eo0NIVaCXk8vWHTtRcTb4rgwwvjWJCRbXBwRBwc4QdH4OAI" +
           "HBwpfHCr97c9bY1QZnw9LSkWgk1fyjDYcBejKRIKcaFmopQiZsDjewA7gEPt" +
           "sr4Htuw63FIGwWqOloO7wkC6NC+ZtXsg42aGhHzmUu/1i2/VPB8mYcChQUhm" +
           "XkZpzckoIiFahkwVgLRiucXF12jxbFJQDjJxYvRA/yNf4nL4kwQyrAB8w+1x" +
           "hPbsEa1BcCjEt+7QR5+cPb7f8GAiJ+u4yTJvJ6JPSzAEgson5OWLpJcT5/a3" +
           "hkk5QBrAOJPg2gFCNgfPyEGhNhfRUZcqUDhpWClJwyUXhmvYsGWMejM8Nhv4" +
           "80xwcR1eS7ibZWuce8p/cbXJxHG2iGWMmYAWPGN8rc88+c6v/7KKm9tNLnW+" +
           "qqCPsjYfoCGzRg5dDV4IbrMoBbrfn4gfe+rqoZ08/oDi9kIHtuLYDkAGLgQz" +
           "P/b63nc/eP/02+FszIYYZPT0IBRHmaySVajT9BJKYpx78gAgagAQGDWt9+kQ" +
           "lWpSlQY1ipfkX3VLVr789yP1Ig40mHHDaMXNGXjzczeQR9988HozZxOSMSF7" +
           "NvPIBMrP8DivtyxpH8qROXB5wXcuSCchXwBG2+oY5bBbzm1QbmNU++4tVol9" +
           "acCNuKWmwBEjTg4723R97y+njG1081OhLYLyXrv74iudHya4o6vwfuM86j7N" +
           "d3PXW0O+KKsXDvgUPiH4/ge/aHicENmgsd1JSYuyOck0MyD9shJFZK4K0f2N" +
           "H+x5+qMXhArBnB0gpofHn/g0cmRceE8UNrfn1Rb+PaK4Eerg8GWUbnGpU/iO" +
           "jg/P7v/5s/sPCakac9P0JqhCX/jtv38VOfGHNwogf4U9bFiiPMWkGRJhzbN9" +
           "wD9CqcqVJ//5yOPv9AB2dJGqtK7uTdMuxc8VajM7PehzmFc08Qm/eugcRkLL" +
           "0Q84MweqfB5/WMFFRAXHF1Y75sCfr/qe1zEEAkPK0wD/buRHdfLxTk4QzZIR" +
           "Tkb42lYcWm0/OOcGgq+wT8hPvv3xtP6Pz1/jxsztDPxY1C2ZwpMNOCxBT84O" +
           "JsJOyR4Gujsntn6jXpu4ARwHgKMMlYDdY0HOzuQgl0NdMeXKL15t2nWpjIQ7" +
           "SA3ornRIPAmQakBfCv7UlIx59z0CfUYRjuq5qiRPebzvCwsjyaaUyfjdH/vp" +
           "7B+v/cGp9znocQ4L8vF8nQN16wrjOY5LcViej5LFtgb85QamEyXzsGAZXSVn" +
           "6xSvIOFnPlDC3RIO2/lSDw47RCj1fjaT4cT9Ysd8Z66Qfnylxi1F3d+gfvOd" +
           "ysfRalVxrQqXWVCd3fLeXqphUC4o1q1waDl9cPyU0vPMyrBju7sh4TlNpCd/" +
           "BUepYOXWzRs0r+pYc/l62XtH59TmF23IqblISba8ODYHD7hw8K/ztq0b3jWJ" +
           "amxhQPkgy+e6z7yxeal8NMx7TFGI5fWmuZvacrGwxqLQTOu56NeSDZNZGBVz" +
           "ITx6nDDpmfwNKra1xBUYK7H2MA5pRsqHKNvOAdS7KiOTvyp8em++wr2O1L2T" +
           "V7jY1hJKPV5i7TAOB4TCOwIKH/zcCnOMXAzS9jtS909e4WJbC2Okl/SOltB6" +
           "HIdvgdbQaG8vlFfLRwxV8Sxx5H9niQFHnYHJW6LY1ptZ4nslLPF9HJ4WluD+" +
           "P+5pffJzaz0Xl74AIicc0RMltObjMhxWuP1FtWkZDLIyVQItRkMJniW0PVti" +
           "7Yc4PMvIdLgJovjql7Q0B64OzybP3UK+hP71s7wycJNZdJLvIyABzcl7Nyre" +
           "58kvnqqrmn3qvt/xbjf7zq0WGotkWtN8UO2H7UrTokmVG6VWVHEm/3mFkTnF" +
           "ZGOkDEauws8E9TlGZhaiBkoY/ZQTUPgGKaG05b9+ulcZqfHoIBmLBz/Ja8Ad" +
           "SPDxgukadN2tv+BBv2RC+QUPj4VZN4uF7BZ/i42pnL/xdtNuWrzzhh7x1Jat" +
           "D1276xnR4suaNDaGXKZCUyHeNmRT9+Ki3FxelZ3Lbkx/qXqJW7s0CIG96zbf" +
           "F/r3w2UzsR6eF+h/7dZsG/zu6bXn3zpceRnq9J0kJDEyY6fvfbN4uQpNdBrq" +
           "ip2xQu0TFDa8NW+r+dOui/+4EmrkRTURDVdzqR0J+dj59+JJ0/xumFR3kQoo" +
           "zWhmgNSo9sZ9ei+VR6ycbqxy0Ejr2Zfj0zHoJbzO3DKOQadlZ/EVESMt+a1p" +
           "/msz6DdGqbUBuSObaYFiJ22a/lVu2XaRVtDSEJmJWLdpOj152Z+55U2Tg8QV" +
           "HDb+Fy9SVbLWGgAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/lp+o/+/dn5zTbMmAAA=");
    }
    protected class PathSegListBuilder extends org.apache.batik.parser.DefaultPathHandler {
        protected org.apache.batik.dom.svg.ListHandler
          listHandler;
        public PathSegListBuilder(org.apache.batik.dom.svg.ListHandler listHandler) {
            super(
              );
            this.
              listHandler =
              listHandler;
        }
        public void startPath() throws org.apache.batik.parser.ParseException {
            listHandler.
              startList(
                );
        }
        public void endPath() throws org.apache.batik.parser.ParseException {
            listHandler.
              endList(
                );
        }
        public void movetoRel(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_MOVETO_REL,
                  PATHSEG_MOVETO_REL_LETTER,
                  x,
                  y));
        }
        public void movetoAbs(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_MOVETO_ABS,
                  PATHSEG_MOVETO_ABS_LETTER,
                  x,
                  y));
        }
        public void closePath() throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CLOSEPATH,
                  PATHSEG_CLOSEPATH_LETTER));
        }
        public void linetoRel(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_REL,
                  PATHSEG_LINETO_REL_LETTER,
                  x,
                  y));
        }
        public void linetoAbs(float x, float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegMovetoLinetoItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_ABS,
                  PATHSEG_LINETO_ABS_LETTER,
                  x,
                  y));
        }
        public void linetoHorizontalRel(float x)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_HORIZONTAL_REL,
                  PATHSEG_LINETO_HORIZONTAL_REL_LETTER,
                  x));
        }
        public void linetoHorizontalAbs(float x)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoHorizontalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_HORIZONTAL_ABS,
                  PATHSEG_LINETO_HORIZONTAL_ABS_LETTER,
                  x));
        }
        public void linetoVerticalRel(float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_VERTICAL_REL,
                  PATHSEG_LINETO_VERTICAL_REL_LETTER,
                  y));
        }
        public void linetoVerticalAbs(float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegLinetoVerticalItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_LINETO_VERTICAL_ABS,
                  PATHSEG_LINETO_VERTICAL_ABS_LETTER,
                  y));
        }
        public void curvetoCubicRel(float x1,
                                    float y1,
                                    float x2,
                                    float y2,
                                    float x,
                                    float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_REL,
                  PATHSEG_CURVETO_CUBIC_REL_LETTER,
                  x1,
                  y1,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicAbs(float x1,
                                    float y1,
                                    float x2,
                                    float y2,
                                    float x,
                                    float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_ABS,
                  PATHSEG_CURVETO_CUBIC_ABS_LETTER,
                  x1,
                  y1,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicSmoothRel(float x2,
                                          float y2,
                                          float x,
                                          float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_SMOOTH_REL,
                  PATHSEG_CURVETO_CUBIC_SMOOTH_REL_LETTER,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoCubicSmoothAbs(float x2,
                                          float y2,
                                          float x,
                                          float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoCubicSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_CUBIC_SMOOTH_ABS,
                  PATHSEG_CURVETO_CUBIC_SMOOTH_ABS_LETTER,
                  x2,
                  y2,
                  x,
                  y));
        }
        public void curvetoQuadraticRel(float x1,
                                        float y1,
                                        float x,
                                        float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_REL,
                  PATHSEG_CURVETO_QUADRATIC_REL_LETTER,
                  x1,
                  y1,
                  x,
                  y));
        }
        public void curvetoQuadraticAbs(float x1,
                                        float y1,
                                        float x,
                                        float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_ABS,
                  PATHSEG_CURVETO_QUADRATIC_ABS_LETTER,
                  x1,
                  y1,
                  x,
                  y));
        }
        public void curvetoQuadraticSmoothRel(float x,
                                              float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL,
                  PATHSEG_CURVETO_QUADRATIC_SMOOTH_REL_LETTER,
                  x,
                  y));
        }
        public void curvetoQuadraticSmoothAbs(float x,
                                              float y)
              throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegCurvetoQuadraticSmoothItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS,
                  PATHSEG_CURVETO_QUADRATIC_SMOOTH_ABS_LETTER,
                  x,
                  y));
        }
        public void arcRel(float rx, float ry,
                           float xAxisRotation,
                           boolean largeArcFlag,
                           boolean sweepFlag,
                           float x,
                           float y) throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_ARC_REL,
                  PATHSEG_ARC_REL_LETTER,
                  rx,
                  ry,
                  xAxisRotation,
                  largeArcFlag,
                  sweepFlag,
                  x,
                  y));
        }
        public void arcAbs(float rx, float ry,
                           float xAxisRotation,
                           boolean largeArcFlag,
                           boolean sweepFlag,
                           float x,
                           float y) throws org.apache.batik.parser.ParseException {
            listHandler.
              item(
                new org.apache.batik.dom.svg.AbstractSVGPathSegList.SVGPathSegArcItem(
                  org.w3c.dom.svg.SVGPathSeg.
                    PATHSEG_ARC_ABS,
                  PATHSEG_ARC_ABS_LETTER,
                  rx,
                  ry,
                  xAxisRotation,
                  largeArcFlag,
                  sweepFlag,
                  x,
                  y));
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "RkI9mmYdiZW8z5HXNBz+voM8S/8XBPQDctIsAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "zLdszQzTIe76s3qF4Sh52UYxp5dorCPguN2uLNBVWlZIuTaVkIkw5FibmeC8" +
           "PuP6zfEEMadrsc/P7UVT2Pht2cEaZW4mz2RZN1OhP12TGOXg9bDSmyEbXFks" +
           "Vh1zscC8aBJjK6tih9OwX/FFj4YjtRnija4/GU+53jzRx2XJNZVUHZf76qjS" +
           "DsLK2C5vqi09cLAZ7phze9wmFow25xWc75b7srs0fDIatiljzrTmpaXi92YT" +
           "ZO0SXa2fjkmfYUWsF/a4iUn74wk3TUe1ddid4CGDS5uGiQxUWpT63SSG65UK" +
           "nfpKMKV0ziAbZbQ8s/rdaQrMhwmpLtcVFzN+XKb0rtuTtJh2HVJW08miWRNX" +
           "uNJV/Q4zJfA5ScupzfXFoGpoKFse+pI+1HmjQXnxaogsK8uKMe7ZK7mirpqc" +
           "RmPiVpY6brqIu3h7KHdr5JBmNmuCQdhsFOjaoDpYBSMCdWbrNF2xS5Eb6Wrc" +
           "iZhVb4j3HEZZoaUpm+hYhSW40UjJPMuYq4biyZ4y6Y+I2cxxRcnsZxjJuBSK" +
           "2rGuavN6bYmS5XLS7pH9bS1rrXiuVEWYUJnCrdWAnjPeqEG3yuOhF40p1wAZ" +
           "BdvvSOZqXmk2ug2lsTbbW33YCcW+sqG8FkzxGZeWxC2c4u5yUuo61YlcCZ0U" +
           "I9WEwsaV0rpKemYLnVRtYBPd2G/SqpPSvodyZWcwJybjsrOI8FjH3NZAiwa1" +
           "RtzKOu16uuVq/EzgKA4fDJQ52XASdj1ytnKFc7F63A/LJscxQzEi041BoFna" +
           "G9rSZqNt+qspp9dG6yXi1kYcHLemCd8ZKSMZPG3ODcflpckKn7RKkj6T1XVn" +
           "09aHKm7EdRY2B611eUV2eSfuo1xvOsTnE8Wac/WWQCGsOehHHUHhhpPutI7B" +
           "TVEMsDQmTNXGZmWiz7EVm+90PFQ11yYeuz7fTXxlKkzmcrlXny44GJ4serFd" +
           "b1ErdjUiaKoMl6kNI8wUxNVotFIuVxBdXqPKZsnbgrN0cHqIrqLtxl8h+JLd" +
           "kopM4tN1f1qZoHHcj5uxItNTodPhu+EsDLGaJi05LI7cYdYSRZOYl8xpisJB" +
           "uW9Oh2Xe2ZRrG7SUtpsL3MXMiWGPrBXlqpUKyzUkcW6Q2RSftlqGFyEjP+IS" +
           "uIpnbd2a91dhmCF2WvFgDbPoSpnjZ1PGnIhj3XfNqVRCiIawRWgNLXO1dlBp" +
           "jmFBFXCvi419xeTRZn82RELbr64xi+QWzciSWyWqthG7wXqCVZSUNRVHNBzF" +
           "WzhlsSnHJcJbRfiwMaZJSsvm7RGx6qFlc4V1uyShwJS4WbCGRSBz2F+vRupA" +
           "NkfeAJ2Z5Fw3a6Zc8xqu1lY0KrE0mJbVRpjM+3Uc57UNURnBikiaGTP3yzWT" +
           "MAVhvu0idTZoV/VJFNEjmsk0weVNfWKOJ2VcXM/Km0bs27w0GrlBatYZXpi3" +
           "aaQ1HmR0NIOjqpAhaOKSgrZcKR7BlpV1mRDQVqluBZsmkknhaF4rrXwZ1pvj" +
           "qULai2kjxR0VUWCaGA6sQCtNYXNGoC2VD0J/vhrN53p9hpoSIZc2ZFU2OXrr" +
           "MVEWMmi332YmPZePYrIJL00vFerLDZIKWSNKVFZrVx1tzZtryqpaywj3lgo7" +
           "KBNNy0PIeEszrRZKjrvr/qzbd4VWunV9YRVQk+mkS3PjfiXAe0TSZ+gSrDBN" +
           "Y6iPAxJHKxIu9Qyj0bPH2XDARGs56ynsTGCabK2cRtsSu27BaZkkluu1hTfQ" +
           "frnrUOQIQ4hptMgsznSYDOtPJZipJ2HoIRS9jfFKV8cmhDpTVo0x1WDS9YyZ" +
           "kGEjUz3gI4FpkXy6xKM6Mk8b9nTJgBZz011hynSVyOmGGzUbpstiLk1orC2N" +
           "LLynlbAaQjUXwbI/aa3qK7i19IeVTQmZoE6mY6wQSpZeEjAOJnWs5jRrA7jc" +
           "lumIZreIQCyQQU8DTxexIPo1uKbKdDNqekjamEprj/S5WVLttHAti+sOTI/G" +
           "7UzKNNGOGM2xXEIm2mG1ltkC3Ga3iwhp0g19RQwWarDUwl5pimshgS66Hd6d" +
           "zSskiWWpN15uSyCQpZTIloSGUKn0/RYyXpdLkxaR8aVuJupizPvodrPaJFEg" +
           "bNqcKaatZFAqjyuTnkUh6HjJcFjDKVsMJ6+FckOXrTY3mactuVydIdtS30XM" +
           "OTdb2ogacdYmNeLyhPAXdqwa1RKDAxYCvViY42GAoJ0tS49aPdIoCWwpBlpS" +
           "G611zxiGLfA8KU34ao8WaYaGa7oj0F2xVxv505YbdFeeuMKoctBGe+1Zo1Qi" +
           "RcQvkfp6bAHFByDf8XGvb5aSeCTXlsGYQoP6NpIGQrYWKSCRTJpwsuozfsvd" +
           "tpUEqa+9Xt2qw7VmaTUZLAOpOZpQHjlc8BW2OpIds0nYVcduw811Z1sCM0bJ" +
           "RZB2qzwUPdFH3GVjNnWWS2ZOSfwk4RFk2pqIXh8J14Fgznhb8cnYHQT8ZNwj" +
           "5O2wppgBtRo7VE9kdIqv4zO+PZ7XJoM488AkmCnuOOivAyUbiVQJDZt1qtkN" +
           "ZD8gBUVF0uZ0mm2ENBgNpHKmsyEPa0kstZclIuzUO0E2apNTXqoOeu60Nhu6" +
           "C4RipFitSQnp1bRSpV4KcFGC40VMV8cG0bDnwVRqOTiIgEkT8fGlC2uevEjD" +
           "jKCogTdubEdJ7FnqmvX7XEtMhHjZ1pZUz+x1rH5QDxS+1bKq9T7dw7YxMVDb" +
           "ZXhYWpf6qIToDTmaZDSctPw1NSvTmLYwWlhg6NRUQTwzyEph3Usm4Pl3i9XZ" +
           "OTzh7dKWW9b49qA0GLqzUbbMbGPdZ0rc1pkm2qjd1ZeCgsMjqbdaszbvxr1M" +
           "62WtDjWIYzNtb9sBBm8ATG1VjWNJNo2p0as6DbkmDnyuxynDziqzyBFst9Vh" +
           "ChOEEsdaZK1Wg62msmoTJMMSCzNKdcrzhJtSc3dTmYsaaohwfyW4ICdYCotM" +
           "mUbldjKubwcbopuuuvVZd0QhtByjGzEWCLTudzt+3Sk1KkRbESjZ2Tq9gaWW" +
           "l6kyKG+SMTENU9dBhSozUiWyAsfUAuQJ84EH7Ii1KnBCI9OBPEpYvNPZlFRk" +
           "ZuNaItBKR/d028Km205KM8JUC4VunRVsS29062gdj1KbwlCxi+JSwBD1Rdce" +
           "Ld2lWF9HcYSsIrg3Y+lxRrIa2SYrPJfUCHq40VxhhNYZtmIpdG9ex42GWVqj" +
           "dSJpMZtGrw5meGajN4SRXGc6U02jmFBAYmcQ+355kAzhtL7Fa5V+Ky6rbXU+" +
           "hStrXUdMEg9by24dZEIZYWECkDdbbbtD2IhLmDQap3WhNsjqbleuk4Qgg9kU" +
           "tbBYUJCx5Nj1OG3qW2TJqxnG1YUKbHZKstcbUuMKYQ8Ha2FqrQyUWbIsQtNq" +
           "vKXCnkQ7cYgjzcWgEbVIzW3FXa3R4mcrvTtQxOZ2tOzJvNBdaYGWbBWlvkVb" +
           "jf7AxcjRvFQBv4Lrb0edss0rhtPFWZCC111vqPRqk5YoLLqINvYivUUqpTXb" +
           "bY8xmzOnXcRZ9KitpYw3E9OzerK0TlsgW6v4KIfV6f5kbCgLtVNm4AmKl7tJ" +
           "d60K5EItmQmmUgayEAa0abbmXcfnRxvDU2I8y8ZYeWqOo7SzHPdUPUg71MTM" +
           "gOwdaeW2yO1MdRuJ0Mda7LhtUFJ7o8clSmTUcBVOW8MkkfrSxq3bA2alLxdz" +
           "TbaX7sZCcbs+SNX2aNSsgLg9MXpoMu3pI5yr6DNxLVGYFgxcnhKwsD5IFlRZ" +
           "oMh2o0vA4sIFaubWjG2HXLdJzLcBKm9BPi11F3M2oeebEcpWBovIKbVYrB3L" +
           "Q3Mm9Vde1IlpRhzPG2rdJixLjldRPVL77EITxOF4pKSbIUPQzblsLDfmSl9Q" +
           "3XYPH1sZ32gK4aZNRv1k2lxwftwW26lYGqTDNtrwzRnmaBhnUTQdkRLWXIqo" +
           "y0oDeG5iEgrT4MmonYTtaDTRZ6NpnxhGlQlTUte9dbiZoXiVMRG1OgYTf6XP" +
           "WNo2oyui1mM2UqBsYWzADpcbe7CexsJ2E8wYuck1rHE/sFlcI+BRbIirdTQI" +
           "qnoGt5loHvMtmEsTZ6DYbtLt15qb8XYuUouBJNZTIokbQa3WZauLFrwymnW8" +
           "zylbNPHM2UrtSRsRr9SdgQumrVEccJyIVBAiWmsJSIAHbjZiJXEiS2xqbSna" +
           "7FQVW0rHbeCnq7gajJZE0BAWtOWntYhkYXe4yegEYzvwprbaTlKpouAIP7HF" +
           "dMtso15tVprzlFbyymAybJYMt4RaJZtttaIGPNJ9IiTaWbMuaqbFa3BVd51w" +
           "zszd+TAy1qWhnThraUTUvMUa3qZTdqE4WLsPchkMq8msrk60Dgvmwtkq6nYH" +
           "TENr2oJRUl1nw815N0oCNzFDk4pbKnhuXiwEk62ZrM7r09ViphNt01yJ6nrR" +
           "ypDBcoJmpcgetxiQNKH0tCsEhA8ee380X06RX92K1n3F4t2NXWjNaOYVs1ex" +
           "kpPcYp0zv8SP9jOK1ek3ntzLPL6fcbRuDeXrVY/earu5WKt68QPPvyBSn61c" +
           "Oljv3wTQlYNTAEd8HgRsnr71oty42Go/WoT+9Q/8wSPsjynveRX7cI+fEPIk" +
           "y78zfukr/bcLH78E3XZjSfrUIYCbGz1z80L03Z4UhJ7F3rQc/ejNe2GPA3V6" +
           "B2r1zt4Lu/UY/dDOFF5hL+UnT9Sd2LB5+6kNGyc/v+HtjnHgiSA5uRYLVs/l" +
           "RRpAdwGsXpDvthZcfuKYkfEBdHtkq+KR9WXnrSMeF7i4Ed2sn0eBXtID/aQX" +
           "r5+fOVs/+d/3FwQ/mxcfDorDAfTBDv9PHeH7yGvFBwNczx3ge+5i8F0qCC6d" +
           "NTqXt4bNF1uInymafvo8+H8jLz4JBt20IymwZ5JxQgE/dxEK+OkDBfz0hSqg" +
           "gHmE9XPnYX0pLz57A2tn45/A+jdfK9bc2T9+gPXjF2/MXzwP4a/kxd8FCAXD" +
           "9qUzzPmXLmI0P32A8NOv52j+o/Ow/pO8+BLAmp/fOctyf/UisL54gPXF1xPr" +
           "b52H9V/kxVduYD1tuf/8tWItA4yfP8D6+YvBegzFDubvnQfz3+bFvwygB3Yw" +
           "B7anZvlWtXF6cH/3IgB/8QDwF18nwP/xPMDfzIt/fwbg0yP8+68VMKi/7dcO" +
           "AP/a6wT4v50H+L/nxbdBarsDzEleoApnje9/vQi4Xz6A++XXCe6fnAN3r+j0" +
           "f52Ce3p0//i1wkUAzK8ewP2di4F7pSC4chSrzioKmHefp4d78uJyAF0VQi+f" +
           "erFwowqnBn3vykVo4RsHWvja91sLD52nhYfz4r4TWjhlC3v3v1YtPAPQf+tA" +
           "C39wMVq4fXdm6ZbYnzwPe97N3qMB9OBx");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("7Ixp24Fy2g4euwgNfPdAA3/0/dHA/nkayE/x7D11pgZO28DTr1UDbSDr3q5t" +
           "QfR90MCPnKeB/EjJHgJmuwMNTENe9PJTS6ctoHER+O85wP+G7w/+V5gudvgH" +
           "edE5A//p8T/3jNh5+H8cSPrgAf4HLwb/mbnr3uw81GxejAPoB06ivpX3Ty4C" +
           "++MH2B9/PbG/+zzs78mL1S2xnx739WvF/g6A+YcPsD99MdjvKAjuOGHyRfWJ" +
           "1Yc7NrZtSHx+KntPP6Er7Txd5e9Z7EkBdIX3zggI24tQzI8cKKb5eirmEPwp" +
           "DaTnaeC9eRHsNHDaNMJXo4EkgO4//b5EQfZgAMGv8tUL34MePvUa2O7VJeEX" +
           "Xrh655tfmP+r4k2DG68X3UVCd25Dwzh+avfY9RXHk7ZqodS7dmd4nUIDPxVA" +
           "D99KtgC6DZQ5hL2/tKP+YAC96SxqQAnK45QfDqBrJykD6HLxe5zurwbQ3Ud0" +
           "+UgUF8dJPga4A5L88medQ4U+fatl1q605UOjWEw9PB2/W5t9+LipFo8A56Z9" +
           "x9bf33bTwnnxIt/hIne4e5XvWeELLwwn7/1O47O7VykEg8+ynMudJHTH7q2O" +
           "gmm+UP7ELbkd8royeOp79/7iXT94uKJ/707gI7c5JtvjZ7+3gJtOULxpkP3K" +
           "m//eO//WC18rzvv+X80CiJJhOQAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/B+eF8+9vCYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xs0JvloQfDNPvhaX7jz0sedAfv2NgnwX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("eJxDkM6bA3L/xHe8dIL0j25O9dWTYf3jPPl3wIFZbqSHBeKOvgBR1jnc33qj" +
       "uB8v5WfGu1/8w8T9p68J93/Nk1fi0ltC3c9vYV0w1N9+M8z+w4eQP/xD0ufv" +
       "vZo+/888+U6chzYrL7kI55+/GTg/eojzo286zpcKgr9+TaP6N3nylwCs4vu6" +
       "q10A9q/eKNgnwfOLh2B/8fWCvTj8OwX2UznB3uWbT2t7d+fJbXHp3uNpLUd5" +
       "5Mgfu1Xsf0yYS2Lv0huQRHGb7X3g+eyhJD775kji1KgOjiBduymkfNHTV1zN" +
       "0cNCNA/eeo581w0N+fkF7XB3T/t4yiuaejhP7gezgOYVpReFX5cSz9JO5PnA" +
       "G5VnGTxfPJTnF39ImvX0LTQLypNruWaZumrnynK4Dtp79ATlU28AZT6/F+W/" +
       "cYjyN950lIWz2GvcAmW+uN8rg1X/zn4Og6TTNvT+13nb9trJ61kLq7weWaVx" +
       "6cGL28/vJT50w78W7K7Dq1964crlt78w+Q+75czRlfW7qNLlxdpxTl8jO5W/" +
       "ww/1hVXI8q7dpbIivt979jASvAg8WG6ANGd77wM7agwsIS6iBpQgPU1JgPji" +
       "PCWI9Yu/p+lI4LlP6MDaZ5c5TUKB1gFJnqX9oxF792sZseIq584ZPHRaP4tp" +
       "4VWN97jK6fuy+dq0+NeQow2J9e6fQ66rX35hwPzk95tf2N3XVR0ly/JWLoNl" +
       "5O7qcNFovqnx+E1bO2rrjv7TP7jvK3c9dbQBc9+O4RNbOcXbOy++GYuv/Li4" +
       "y5r99tv/5Y//8xf+pLhl9n8BQv89GLMzAAA=");
}
