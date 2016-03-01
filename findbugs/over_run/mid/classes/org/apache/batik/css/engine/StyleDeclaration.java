package org.apache.batik.css.engine;
public class StyleDeclaration {
    protected static final int INITIAL_LENGTH = 8;
    protected org.apache.batik.css.engine.value.Value[] values = new org.apache.batik.css.engine.value.Value[INITIAL_LENGTH];
    protected int[] indexes = new int[INITIAL_LENGTH];
    protected boolean[] priorities = new boolean[INITIAL_LENGTH];
    protected int count;
    public int size() { return count; }
    public org.apache.batik.css.engine.value.Value getValue(int idx) { return values[idx];
    }
    public int getIndex(int idx) { return indexes[idx]; }
    public boolean getPriority(int idx) { return priorities[idx];
    }
    public void remove(int idx) { count--;
                                  int from = idx + 1;
                                  int to = idx;
                                  int nCopy = count - idx;
                                  java.lang.System.arraycopy(values,
                                                             from,
                                                             values,
                                                             to,
                                                             nCopy);
                                  java.lang.System.arraycopy(indexes,
                                                             from,
                                                             indexes,
                                                             to,
                                                             nCopy);
                                  java.lang.System.arraycopy(priorities,
                                                             from,
                                                             priorities,
                                                             to,
                                                             nCopy);
                                  values[count] = null;
                                  indexes[count] = 0;
                                  priorities[count] = false; }
    public void put(int idx, org.apache.batik.css.engine.value.Value v,
                    int i,
                    boolean prio) { values[idx] = v;
                                    indexes[idx] = i;
                                    priorities[idx] = prio; }
    public void append(org.apache.batik.css.engine.value.Value v,
                       int idx,
                       boolean prio) { if (values.length == count) {
                                           org.apache.batik.css.engine.value.Value[] newval =
                                             new org.apache.batik.css.engine.value.Value[count *
                                                                                           2];
                                           int[] newidx =
                                             new int[count *
                                                       2];
                                           boolean[] newprio =
                                             new boolean[count *
                                                           2];
                                           java.lang.System.
                                             arraycopy(
                                               values,
                                               0,
                                               newval,
                                               0,
                                               count);
                                           java.lang.System.
                                             arraycopy(
                                               indexes,
                                               0,
                                               newidx,
                                               0,
                                               count);
                                           java.lang.System.
                                             arraycopy(
                                               priorities,
                                               0,
                                               newprio,
                                               0,
                                               count);
                                           values =
                                             newval;
                                           indexes =
                                             newidx;
                                           priorities =
                                             newprio;
                                       }
                                       for (int i =
                                              0; i <
                                                   count;
                                            i++) {
                                           if (indexes[i] ==
                                                 idx) {
                                               if (prio ||
                                                     priorities[i] ==
                                                     prio) {
                                                   values[i] =
                                                     v;
                                                   priorities[i] =
                                                     prio;
                                               }
                                               return;
                                           }
                                       }
                                       values[count] =
                                         v;
                                       indexes[count] =
                                         idx;
                                       priorities[count] =
                                         prio;
                                       count++; }
    public java.lang.String toString(org.apache.batik.css.engine.CSSEngine eng) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          count *
            8);
        for (int i =
               0;
             i <
               count;
             i++) {
            sb.
              append(
                eng.
                  getPropertyName(
                    indexes[i]));
            sb.
              append(
                ": ");
            sb.
              append(
                values[i]);
            sb.
              append(
                ";\n");
        }
        return sb.
          toString(
            );
    }
    public StyleDeclaration() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7Jv58DGuecPAFRviJNJ/AZZaxcIIKQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "HWSNIIk80X4ywdmt5k8dhrN3nw41x6Y9HWiOFgFQz6nz+pVTseVduZZRcD2y" +
       "H1seOR1bitVgZ+OcpT0G5HOGFt77jX/80l9/4lPE+RzQF9OcdaCVa0d0fJLn" +
       "oX//5c8/dOdzf/qZwvlzG+aDPl1M/2hRXs+LHy7se1tcusMPvRhIrIEE8VJU" +
       "ZLYxkMp0Zbtg/Mm4dDfDMyOm0Xum1+apEX02JoTQdEBQS/dTLPjZe7+++oU/" +
       "/9IufToNgFPE2qef+4ff2/vsc+ePJa2P35A3Hu+zS1wLRt9WcJu71KNnzVL0" +
       "6PzZV579l7/y7Kd2XN17MgVrgzeML/3h//2dvRf+9LdusrbfBtLrXfTPSywv" +
       "GjufwW/pX08dWv/u/GkdXNf3rX/9BuuXisr45hY7l1epA8tcKlAQAZmfuLVF" +
       "ioi4U/CLv/z4737sxcf/cxFULpsRwHIjNG6SXR/r8+2Xv/7N33/bQ18uFuEL" +
       "Cznaofr0a8mNbx0nXiYKju86qYb7wPW+fTW8b7f22G9VqlcoqnjzLHz+ILX8" +
       "gc63Q8k74tIPn5UeFj33il6HsfncfuZXYCkvfvwAJsrNYXI+r74vL5hDrNhg" +
       "gl1+z+fFj/nZ4fjnd50O+LvvKKaQtudq+cp80LbLUk1v7/AVFzRmN3Aalt5/" +
       "a0RyBTCOgvdvfvK/PTj60eVHXkd6+sgpwJ4e8p9yL/8W9V7lZ86XbjsM5Te8" +
       "/57s9NTJAH4l1MALuzs6EcYf2im/0F9ePH5GBhGe0VZEEIC/i0qu3505ziBf" +
       "Z6VTIWfyOkMODq4n933tyVuEnO1rCTm3g/CpZSDm5PfS4ST5e2Lpaql0gd/N" +
       "sfuNS8Gb6mAySEThKDUWIHmPtBDmPVUTTGWlhWA8zT7w6h/8pIV2+Fv768cP" +
       "dPyTr9Ff80I/9NWP3eir+W3hzNaNzpffO7tpi96vhtTPnNH2U3nxD/Ii2XFy" +
       "Bu1P3wDTj75OmDbAtbcP071bwPRnXgtMr/ih6YVg1b8BqZf3kXrlE7tpdr9v" +
       "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" +
       "OinRZKiBDLLtLuzokjr0IBMkeRDt9bn1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GivbGuVuNL86CVWvzJj40l93fCHlyusam1aJFpVoitDoDFKT5Vm4IUlypjBM" +
       "V2w08q2fr72+Lal7ii22w6OXll3LG37jdew67ZoezYsnDrchi79LpVufWTp2" +
       "rqOUfyZ/6FYnKotP5C998rkX1f4vIef3t0iFuHRH7PkftMFaYJ84IlJs2h6y" +
       "cTUfPv+yS+yzQZzeDT0S9OZboe/bKeqM7dr/dEbbH+fFH8a7Ez/FNuqRTv/o" +
       "1Xbyjg92Sq5CxT8Erg/vy/XhN0euc0cEfEHwZ2cI9xd58Y24dNnQdt+V8/uP" +
       "HAn4X96AgIXh3gmuzr6AnbdIwP91hoB/mRf/Yycgk39oPGXB//kGBMxBWRzq" +
       "4/YF5N4iAb93awHPFWR/E5fuBAIKu09Um/zRzx/J+N03IOOd+cP8QNFoX8bR" +
       "WyPjuTvPkDE/iXPuUly6FGqOl2o33WdPPVM9FPnc7W9U5L8FLntfZPvNEflC" +
       "QXChELlws8PazxdSPniGBt6dF++IS7f5Sf4p59zVI1Hvf6Oi5l/yk31RkzdH" +
       "1NuO1qvTUr73DCnzte3co8DOsu9rrnpK0MfegKD35g8fBNfz+4I+/6bC+OBj" +
       "1hNnncMhh8N2UStkRc/QA54XHwRBK/aOvon9xpEm9l6PJrK4dO30CfH8iOsD" +
       "N/yXyu4/K5Qvv3j18jtfHP/R7nzWwX8/3NErXdYT2z5+IvFY/ZIfarpZ6OiO" +
       "3flEvxDlR+LSu85QCrD1rpKzfe5Duz5Px6W336wPgD8oj1OSQLbTlHHpYvF7" +
       "nK4Tl64c0RUAyyvHSRgwOiDJq6x/k4+Tu2Oc2bmTSc9hjL331UxyLE96/MRB" +
       "puJ/ig4OHSW7/yp6RvnKiyz/0e/gv7Q78Q0Mt93mo1zulW7fHT4vBs0PLj16" +
       "y9EOxrpEP/ndu3/1jicOMq+7dwwfIf4Yb4/c/Eh12/Hj4hD09l+889c+9E9e" +
       "/JPiMOj/B+FLxW3sNQAA");
}
