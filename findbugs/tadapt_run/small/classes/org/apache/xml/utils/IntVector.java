package org.apache.xml.utils;
public class IntVector implements java.lang.Cloneable {
    protected int m_blocksize;
    protected int[] m_map;
    protected int m_firstFree = 0;
    protected int m_mapSize;
    public IntVector() { super();
                         m_blocksize = 32;
                         m_mapSize = m_blocksize;
                         m_map = (new int[m_blocksize]); }
    public IntVector(int blocksize) { super();
                                      m_blocksize = blocksize;
                                      m_mapSize = blocksize;
                                      m_map = (new int[blocksize]); }
    public IntVector(int blocksize, int increaseSize) { super();
                                                        m_blocksize = increaseSize;
                                                        m_mapSize = blocksize;
                                                        m_map = (new int[blocksize]);
    }
    public IntVector(org.apache.xml.utils.IntVector v) { super();
                                                         m_map = (new int[v.
                                                                            m_mapSize]);
                                                         m_mapSize =
                                                           v.
                                                             m_mapSize;
                                                         m_firstFree =
                                                           v.
                                                             m_firstFree;
                                                         m_blocksize =
                                                           v.
                                                             m_blocksize;
                                                         java.lang.System.
                                                           arraycopy(
                                                             v.
                                                               m_map,
                                                             0,
                                                             m_map,
                                                             0,
                                                             m_firstFree);
    }
    public final int size() { return m_firstFree; }
    public final void setSize(int sz) { m_firstFree = sz; }
    public final void addElement(int value) { if (m_firstFree + 1 >=
                                                    m_mapSize) { m_mapSize +=
                                                                   m_blocksize;
                                                                 int[] newMap =
                                                                   new int[m_mapSize];
                                                                 java.lang.System.
                                                                   arraycopy(
                                                                     m_map,
                                                                     0,
                                                                     newMap,
                                                                     0,
                                                                     m_firstFree +
                                                                       1);
                                                                 m_map =
                                                                   newMap;
                                              }
                                              m_map[m_firstFree] =
                                                value;
                                              m_firstFree++;
    }
    public final void addElements(int value, int numberOfElements) {
        if (m_firstFree +
              numberOfElements >=
              m_mapSize) {
            m_mapSize +=
              m_blocksize +
                numberOfElements;
            int[] newMap =
              new int[m_mapSize];
            java.lang.System.
              arraycopy(
                m_map,
                0,
                newMap,
                0,
                m_firstFree +
                  1);
            m_map =
              newMap;
        }
        for (int i =
               0;
             i <
               numberOfElements;
             i++) {
            m_map[m_firstFree] =
              value;
            m_firstFree++;
        }
    }
    public final void addElements(int numberOfElements) {
        if (m_firstFree +
              numberOfElements >=
              m_mapSize) {
            m_mapSize +=
              m_blocksize +
                numberOfElements;
            int[] newMap =
              new int[m_mapSize];
            java.lang.System.
              arraycopy(
                m_map,
                0,
                newMap,
                0,
                m_firstFree +
                  1);
            m_map =
              newMap;
        }
        m_firstFree +=
          numberOfElements;
    }
    public final void insertElementAt(int value, int at) {
        if (m_firstFree +
              1 >=
              m_mapSize) {
            m_mapSize +=
              m_blocksize;
            int[] newMap =
              new int[m_mapSize];
            java.lang.System.
              arraycopy(
                m_map,
                0,
                newMap,
                0,
                m_firstFree +
                  1);
            m_map =
              newMap;
        }
        if (at <=
              m_firstFree -
              1) {
            java.lang.System.
              arraycopy(
                m_map,
                at,
                m_map,
                at +
                  1,
                m_firstFree -
                  at);
        }
        m_map[at] =
          value;
        m_firstFree++;
    }
    public final void removeAllElements() { for (int i =
                                                   0;
                                                 i <
                                                   m_firstFree;
                                                 i++) {
                                                m_map[i] =
                                                  java.lang.Integer.
                                                    MIN_VALUE;
                                            }
                                            m_firstFree =
                                              0; }
    public final boolean removeElement(int s) { for (int i =
                                                       0;
                                                     i <
                                                       m_firstFree;
                                                     i++) {
                                                    if (m_map[i] ==
                                                          s) {
                                                        if (i +
                                                              1 <
                                                              m_firstFree)
                                                            java.lang.System.
                                                              arraycopy(
                                                                m_map,
                                                                i +
                                                                  1,
                                                                m_map,
                                                                i -
                                                                  1,
                                                                m_firstFree -
                                                                  i);
                                                        else
                                                            m_map[i] =
                                                              java.lang.Integer.
                                                                MIN_VALUE;
                                                        m_firstFree--;
                                                        return true;
                                                    }
                                                }
                                                return false;
    }
    public final void removeElementAt(int i) { if (i >
                                                     m_firstFree)
                                                   java.lang.System.
                                                     arraycopy(
                                                       m_map,
                                                       i +
                                                         1,
                                                       m_map,
                                                       i,
                                                       m_firstFree);
                                               else
                                                   m_map[i] =
                                                     java.lang.Integer.
                                                       MIN_VALUE;
                                               m_firstFree--;
    }
    public final void setElementAt(int value, int index) {
        m_map[index] =
          value;
    }
    public final int elementAt(int i) { return m_map[i];
    }
    public final boolean contains(int s) { for (int i =
                                                  0;
                                                i <
                                                  m_firstFree;
                                                i++) {
                                               if (m_map[i] ==
                                                     s)
                                                   return true;
                                           }
                                           return false;
    }
    public final int indexOf(int elem, int index) {
        for (int i =
               index;
             i <
               m_firstFree;
             i++) {
            if (m_map[i] ==
                  elem)
                return i;
        }
        return java.lang.Integer.
                 MIN_VALUE;
    }
    public final int indexOf(int elem) { for (int i =
                                                0;
                                              i <
                                                m_firstFree;
                                              i++) {
                                             if (m_map[i] ==
                                                   elem)
                                                 return i;
                                         }
                                         return java.lang.Integer.
                                                  MIN_VALUE;
    }
    public final int lastIndexOf(int elem) { for (int i =
                                                    m_firstFree -
                                                    1;
                                                  i >=
                                                    0;
                                                  i--) {
                                                 if (m_map[i] ==
                                                       elem)
                                                     return i;
                                             }
                                             return java.lang.Integer.
                                                      MIN_VALUE;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return new org.apache.xml.utils.IntVector(
          this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gy70JP6z8v94+tCiqC4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Jn/J/PiNtroVL5i/8PFXX1fGX6ye2V8X");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7oel86Hr/Zilxqp1jN6O7793yMu7864fBoexz4txcqX1CO0N3iwcE9kpC9Vf" +
       "P+XZv8+Lr4a7XRzFGu2RdP/dTb/fPQJ3Ib/5DDiCfXDBOwju2Bvd3VvrPz4F" +
       "4X/Ji/8Qls4FapgvRF93FTR2DeUI+B/dKvDnwPHKPvBXbifwb50C/Nt58adh" +
       "6R5JUfJNv6pTbBf6xhHO/3GrOPN2n9vH+bl3EOf19yb8+Slg/zIvvhuW3nUE" +
       "NjiB9q1bRdsAx1f20X7lNmp1b+/GQPeKgPlXpwL961sF2gTH1/aBfu12q3Xv" +
       "vlPQXsiLu8N8k3eg+uE+YPSEIe+dv1XE7wfHt/YRf+sdRHwcyw+d8uyH8+I9" +
       "YNjzVduNVdSyrq/bvYduAWk+1hRv57+/j/T7t9OInz0F7vvz4qmwdN8O7nGs" +
       "JyLzuaXrWqrkHEng6VvV9fOAzcd2bXf/t0sC9VMk0MwLCBj2VRK4xrAr74Ar" +
       "71X3wVZvuyt/+BTEebW9F8LSvWAcvhHcD94C3CKdAvrce3Ef7ou3U7fUKUjp" +
       "vMBBFqgeh3mUWO0Rt+rET5bynbc7mIPbCVM4BaaYF1xYunt/u1leae+5I5T8" +
       "rSrzUcDKS/soX7rttqucAnWVF1dANALpvpqOVyf0+dI7gTTeRxrfTn2esp9l" +
       "L98tuGfeEKR1qyCfAJx8ah/kp24nyJ88BeQreZGA9AlM4cLBdYGmtwC0qPYQ" +
       "4Obz+0A/fxNACwgfeNs84pPXx19cPxSWLp3YMka7IRd5nuuHqtJLZdXL93MV" +
       "hH42L/72wX6ng/bHdqbsNnQeSeZnbmozLAiAhx/f5NsYH7nms77dp2jyl16/" +
       "cPfDr0//424X4sHnYuep0t2ryLKObww9dn7W89WVUQjr/G6bqFeA+mxYes/1" +
       "PgQCMIv/Ikq9uqv7Wli6/+q6YekOUB6v84tgAnVUJyyd3Z0cr/I6aAWq5Ke/" +
       "nGt579PpThuPHDeSIjV/8O0keNjk+Cco+ba94tPJgy120e7jySvyl18n6Z94" +
       "q/nF3ScwsiVlWU7lbqp0bvc1TkE036b39A2pHdA6Szz3vfu/cv7Zg3WM+3cM" +
       "HxnsMd6evP73Jj3bC4svRLLffPiff/CfvP6NYjfT/wcBMcab0zoAAA==");
}
