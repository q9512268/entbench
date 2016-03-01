package org.apache.xml.utils;
public class ObjectVector implements java.lang.Cloneable {
    protected int m_blocksize;
    protected java.lang.Object[] m_map;
    protected int m_firstFree = 0;
    protected int m_mapSize;
    public ObjectVector() { super();
                            m_blocksize = 32;
                            m_mapSize = m_blocksize;
                            m_map = (new java.lang.Object[m_blocksize]); }
    public ObjectVector(int blocksize) { super();
                                         m_blocksize = blocksize;
                                         m_mapSize = blocksize;
                                         m_map = (new java.lang.Object[blocksize]);
    }
    public ObjectVector(int blocksize, int increaseSize) { super(
                                                             );
                                                           m_blocksize =
                                                             increaseSize;
                                                           m_mapSize =
                                                             blocksize;
                                                           m_map =
                                                             (new java.lang.Object[blocksize]);
    }
    public ObjectVector(org.apache.xml.utils.ObjectVector v) {
        super(
          );
        m_map =
          (new java.lang.Object[v.
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
    public final void setSize(int sz) { m_firstFree = sz;
    }
    public final void addElement(java.lang.Object value) {
        if (m_firstFree +
              1 >=
              m_mapSize) {
            m_mapSize +=
              m_blocksize;
            java.lang.Object[] newMap =
              new java.lang.Object[m_mapSize];
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
    public final void addElements(java.lang.Object value,
                                  int numberOfElements) {
        if (m_firstFree +
              numberOfElements >=
              m_mapSize) {
            m_mapSize +=
              m_blocksize +
                numberOfElements;
            java.lang.Object[] newMap =
              new java.lang.Object[m_mapSize];
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
            java.lang.Object[] newMap =
              new java.lang.Object[m_mapSize];
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
    public final void insertElementAt(java.lang.Object value,
                                      int at) { if (m_firstFree +
                                                      1 >=
                                                      m_mapSize) {
                                                    m_mapSize +=
                                                      m_blocksize;
                                                    java.lang.Object[] newMap =
                                                      new java.lang.Object[m_mapSize];
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
    public final void removeAllElements() { for (int i = 0;
                                                 i <
                                                   m_firstFree;
                                                 i++) { m_map[i] =
                                                          null;
                                            }
                                            m_firstFree =
                                              0; }
    public final boolean removeElement(java.lang.Object s) {
        for (int i =
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
                      null;
                m_firstFree--;
                return true;
            }
        }
        return false;
    }
    public final void removeElementAt(int i) { if (i > m_firstFree)
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
                                                     null;
                                               m_firstFree--;
    }
    public final void setElementAt(java.lang.Object value,
                                   int index) { m_map[index] =
                                                  value; }
    public final java.lang.Object elementAt(int i) { return m_map[i];
    }
    public final boolean contains(java.lang.Object s) { for (int i =
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
    public final int indexOf(java.lang.Object elem, int index) {
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
    public final int indexOf(java.lang.Object elem) { for (int i =
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
    public final int lastIndexOf(java.lang.Object elem) {
        for (int i =
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
    public final void setToSize(int size) { java.lang.Object[] newMap =
                                              new java.lang.Object[size];
                                            java.lang.System.
                                              arraycopy(
                                                m_map,
                                                0,
                                                newMap,
                                                0,
                                                m_firstFree);
                                            m_mapSize = size;
                                            m_map = newMap;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return new org.apache.xml.utils.ObjectVector(
          this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ssl/NHz19/tvV3/+TOm2w82iqw7FXVnp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+Su3iO6O9CSNPP6KjaLHD7n+YM7kR0Cy9rlunVyqPpLrVRpy5lBD9pXjlO3C" +
       "3zrl3Wt59s+T3QGJYpH7SI/+xQ1vnf7TQ3D51krpGZDifXDxGwju2GbpbkP4" +
       "35yC8Kt59ttJ6WysJ/lK/jXXkFe+pR0B/52bBf4ukD64D/yDtwb4i0WBPzoF" +
       "+H/Ks68npbtlTcsP1upecRLna0c4/+3N4kRBenkf58tvIM5j2/4vHkn5v50C" +
       "9s/y7JsJsP1DsPEJtH9ys2gbIH15H+2Xb6U6v34K0P+ZZ39xKtBv3yzQDkhf" +
       "2Qf6lVsu1r8+Be338+yvkvwgdaxHyT5g5KQi/5+bRfyjIP3pPuI/fQMRH8Oy" +
       "d+6Ud2/Ks9vBAB/prr/SEce5tmz37rgJpPlYU7oI0vf2kX7v1ihx4Zr2HjoF" +
       "7iN5diEp3buDexzrCc98VvF9R5e9Iw7cf7Oyfg6Q+ZZd3d31Fpnx3sVTOPD2" +
       "PHsSKPYVHDip2HtPvQGmvLe/Fb531Vb4G23Ke5VTEBd4yknpHjAOXw/uu24C" +
       "7sP5wycBzHfvw333rZTte05B+t48a4HAVj8O88UjmO2bNeIcJr4PE7+VRjw4" +
       "BWZ+pHAPTEru2j/JlRfae8sRyt5NoCxi48cAKe/fR/n+W667/ClQp3nGAm8E" +
       "ZjB6xhpFrSOk3BuBdD9Q3rtFgfJOni+cAlLJs/ddF+RP3SzIJwAln9gH+Ylb" +
       "CdI5BWR+vn5vAcInMCtNiGsCNd+AYGLvc/tAP3drgO5UNjsF6DbPYuCEgLvl" +
       "/YMjTMd8bXITMItiDwFavrAP8ws3ALMA8I4fGC79zLXRF/8fSkoXTyw/MH4y" +
       "SYPAjxJdwzJVD/Lpf9HQz+bZh5LSHWpeLrzSFX/4ho7OgtHr+Nc6+bnHR6/6" +
       "IHD3EZv6xVfO3/XIK8K/3x1bPPjQ7BxdustIHef4SdJj93cGkW5YBW/O7c6V" +
       "BgWGTyWlN1/r4yGAqrgWvveTu7I/n5Tuu7JsUroN5MfLfAZMC4/KJKU7dzfH" +
       "i3wW1AJF8ttfDHbGtWP+o8d1ogi/H/hBTDyscvyblXxRp/jo8mABJt19dnlZ" +
       "/dIrJPPTrzd/ZffNjOrI21ybS3fRpbO7z3eKRvNFnKev29pBW3cO3vnd+758" +
       "7tmDBaf7dgQf6ecx2p689gcqmBskxScl29945J+85x+88sfFCbf/D/GPb90N" +
       "OwAA");
}
