package org.apache.xml.utils;
public class SuballocatedByteVector {
    protected int m_blocksize;
    protected int m_numblocks = 32;
    protected byte[][] m_map;
    protected int m_firstFree = 0;
    protected byte[] m_map0;
    public SuballocatedByteVector() { this(2048); }
    public SuballocatedByteVector(int blocksize) { super();
                                                   m_blocksize = blocksize;
                                                   m_map0 = (new byte[blocksize]);
                                                   m_map = (new byte[m_numblocks][]);
                                                   m_map[0] = m_map0; }
    public SuballocatedByteVector(int blocksize, int increaseSize) { this(
                                                                       blocksize);
    }
    public int size() { return m_firstFree; }
    private void setSize(int sz) { if (m_firstFree < sz) m_firstFree =
                                                           sz; }
    public void addElement(byte value) { if (m_firstFree < m_blocksize)
                                             m_map0[m_firstFree++] =
                                               value;
                                         else {
                                             int index =
                                               m_firstFree /
                                               m_blocksize;
                                             int offset =
                                               m_firstFree %
                                               m_blocksize;
                                             ++m_firstFree;
                                             if (index >=
                                                   m_map.
                                                     length) {
                                                 int newsize =
                                                   index +
                                                   m_numblocks;
                                                 byte[][] newMap =
                                                   new byte[newsize][];
                                                 java.lang.System.
                                                   arraycopy(
                                                     m_map,
                                                     0,
                                                     newMap,
                                                     0,
                                                     m_map.
                                                       length);
                                                 m_map =
                                                   newMap;
                                             }
                                             byte[] block =
                                               m_map[index];
                                             if (null ==
                                                   block)
                                                 block =
                                                   (m_map[index] =
                                                      (new byte[m_blocksize]));
                                             block[offset] =
                                               value;
                                         } }
    private void addElements(byte value, int numberOfElements) { if (m_firstFree +
                                                                       numberOfElements <
                                                                       m_blocksize)
                                                                     for (int i =
                                                                            0;
                                                                          i <
                                                                            numberOfElements;
                                                                          i++) {
                                                                         m_map0[m_firstFree++] =
                                                                           value;
                                                                     }
                                                                 else {
                                                                     int index =
                                                                       m_firstFree /
                                                                       m_blocksize;
                                                                     int offset =
                                                                       m_firstFree %
                                                                       m_blocksize;
                                                                     m_firstFree +=
                                                                       numberOfElements;
                                                                     while (numberOfElements >
                                                                              0) {
                                                                         if (index >=
                                                                               m_map.
                                                                                 length) {
                                                                             int newsize =
                                                                               index +
                                                                               m_numblocks;
                                                                             byte[][] newMap =
                                                                               new byte[newsize][];
                                                                             java.lang.System.
                                                                               arraycopy(
                                                                                 m_map,
                                                                                 0,
                                                                                 newMap,
                                                                                 0,
                                                                                 m_map.
                                                                                   length);
                                                                             m_map =
                                                                               newMap;
                                                                         }
                                                                         byte[] block =
                                                                           m_map[index];
                                                                         if (null ==
                                                                               block)
                                                                             block =
                                                                               (m_map[index] =
                                                                                  (new byte[m_blocksize]));
                                                                         int copied =
                                                                           m_blocksize -
                                                                           offset <
                                                                           numberOfElements
                                                                           ? m_blocksize -
                                                                           offset
                                                                           : numberOfElements;
                                                                         numberOfElements -=
                                                                           copied;
                                                                         while (copied-- >
                                                                                  0)
                                                                             block[offset++] =
                                                                               value;
                                                                         ++index;
                                                                         offset =
                                                                           0;
                                                                     }
                                                                 }
    }
    private void addElements(int numberOfElements) {
        int newlen =
          m_firstFree +
          numberOfElements;
        if (newlen >
              m_blocksize) {
            int index =
              m_firstFree %
              m_blocksize;
            int newindex =
              (m_firstFree +
                 numberOfElements) %
              m_blocksize;
            for (int i =
                   index +
                   1;
                 i <=
                   newindex;
                 ++i)
                m_map[i] =
                  (new byte[m_blocksize]);
        }
        m_firstFree =
          newlen;
    }
    private void insertElementAt(byte value,
                                 int at) {
        if (at ==
              m_firstFree)
            addElement(
              value);
        else
            if (at >
                  m_firstFree) {
                int index =
                  at /
                  m_blocksize;
                if (index >=
                      m_map.
                        length) {
                    int newsize =
                      index +
                      m_numblocks;
                    byte[][] newMap =
                      new byte[newsize][];
                    java.lang.System.
                      arraycopy(
                        m_map,
                        0,
                        newMap,
                        0,
                        m_map.
                          length);
                    m_map =
                      newMap;
                }
                byte[] block =
                  m_map[index];
                if (null ==
                      block)
                    block =
                      (m_map[index] =
                         (new byte[m_blocksize]));
                int offset =
                  at %
                  m_blocksize;
                block[offset] =
                  value;
                m_firstFree =
                  offset +
                    1;
            }
            else {
                int index =
                  at /
                  m_blocksize;
                int maxindex =
                  m_firstFree +
                  1 /
                  m_blocksize;
                ++m_firstFree;
                int offset =
                  at %
                  m_blocksize;
                byte push;
                while (index <=
                         maxindex) {
                    int copylen =
                      m_blocksize -
                      offset -
                      1;
                    byte[] block =
                      m_map[index];
                    if (null ==
                          block) {
                        push =
                          0;
                        block =
                          (m_map[index] =
                             (new byte[m_blocksize]));
                    }
                    else {
                        push =
                          block[m_blocksize -
                                  1];
                        java.lang.System.
                          arraycopy(
                            block,
                            offset,
                            block,
                            offset +
                              1,
                            copylen);
                    }
                    block[offset] =
                      value;
                    value =
                      push;
                    offset =
                      0;
                    ++index;
                }
            }
    }
    public void removeAllElements() { m_firstFree =
                                        0;
    }
    private boolean removeElement(byte s) {
        int at =
          indexOf(
            s,
            0);
        if (at <
              0)
            return false;
        removeElementAt(
          at);
        return true;
    }
    private void removeElementAt(int at) {
        if (at <
              m_firstFree) {
            int index =
              at /
              m_blocksize;
            int maxindex =
              m_firstFree /
              m_blocksize;
            int offset =
              at %
              m_blocksize;
            while (index <=
                     maxindex) {
                int copylen =
                  m_blocksize -
                  offset -
                  1;
                byte[] block =
                  m_map[index];
                if (null ==
                      block)
                    block =
                      (m_map[index] =
                         (new byte[m_blocksize]));
                else
                    java.lang.System.
                      arraycopy(
                        block,
                        offset +
                          1,
                        block,
                        offset,
                        copylen);
                if (index <
                      maxindex) {
                    byte[] next =
                      m_map[index +
                              1];
                    if (next !=
                          null)
                        block[m_blocksize -
                                1] =
                          next !=
                            null
                            ? next[0]
                            : 0;
                }
                else
                    block[m_blocksize -
                            1] =
                      0;
                offset =
                  0;
                ++index;
            }
        }
        --m_firstFree;
    }
    public void setElementAt(byte value, int at) {
        if (at <
              m_blocksize) {
            m_map0[at] =
              value;
            return;
        }
        int index =
          at /
          m_blocksize;
        int offset =
          at %
          m_blocksize;
        if (index >=
              m_map.
                length) {
            int newsize =
              index +
              m_numblocks;
            byte[][] newMap =
              new byte[newsize][];
            java.lang.System.
              arraycopy(
                m_map,
                0,
                newMap,
                0,
                m_map.
                  length);
            m_map =
              newMap;
        }
        byte[] block =
          m_map[index];
        if (null ==
              block)
            block =
              (m_map[index] =
                 (new byte[m_blocksize]));
        block[offset] =
          value;
        if (at >=
              m_firstFree)
            m_firstFree =
              at +
                1;
    }
    public byte elementAt(int i) { if (i <
                                         m_blocksize)
                                       return m_map0[i];
                                   return m_map[i /
                                                  m_blocksize][i %
                                                                 m_blocksize];
    }
    private boolean contains(byte s) { return indexOf(
                                                s,
                                                0) >=
                                         0;
    }
    public int indexOf(byte elem, int index) {
        if (index >=
              m_firstFree)
            return -1;
        int bindex =
          index /
          m_blocksize;
        int boffset =
          index %
          m_blocksize;
        int maxindex =
          m_firstFree /
          m_blocksize;
        byte[] block;
        for (;
             bindex <
               maxindex;
             ++bindex) {
            block =
              m_map[bindex];
            if (block !=
                  null)
                for (int offset =
                       boffset;
                     offset <
                       m_blocksize;
                     ++offset)
                    if (block[offset] ==
                          elem)
                        return offset +
                          bindex *
                          m_blocksize;
            boffset =
              0;
        }
        int maxoffset =
          m_firstFree %
          m_blocksize;
        block =
          m_map[maxindex];
        for (int offset =
               boffset;
             offset <
               maxoffset;
             ++offset)
            if (block[offset] ==
                  elem)
                return offset +
                  maxindex *
                  m_blocksize;
        return -1;
    }
    public int indexOf(byte elem) { return indexOf(
                                             elem,
                                             0);
    }
    private int lastIndexOf(byte elem) { int boffset =
                                           m_firstFree %
                                           m_blocksize;
                                         for (int index =
                                                m_firstFree /
                                                m_blocksize;
                                              index >=
                                                0;
                                              --index) {
                                             byte[] block =
                                               m_map[index];
                                             if (block !=
                                                   null)
                                                 for (int offset =
                                                        boffset;
                                                      offset >=
                                                        0;
                                                      --offset)
                                                     if (block[offset] ==
                                                           elem)
                                                         return offset +
                                                           index *
                                                           m_blocksize;
                                             boffset =
                                               0;
                                         }
                                         return -1;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ae5AUxRnv3eOe3HEP4ECQA46DFA9vBUVMztdxgpzscVcc" +
       "UHioy9xs793A7Mww03u3h0F8lEKwyjKKxEShUiUmRlEsEyuppFSsxKjlgxJN" +
       "8FFq0FT5TsEfilET833dszuzsztzbCC5qumbne7v6+/3vfrrnjnwOSm1TNJs" +
       "SFpcamUjBrVae/C+RzItGu9QJctaA09j8q5jd20/+VrljWFS1kfGDUpWlyxZ" +
       "dLlC1bjVR6YpmsUkTabWKkrjSNFjUouaQxJTdK2PTFSszqShKrLCuvQ4xQHr" +
       "JDNK6iXGTKU/xWinzYCR6VEuTYRLE2n3DmiLkmpZN0Ycgik5BB2uPhybdOaz" +
       "GKmLbpKGpEiKKWokqlisLW2S+YaujgyoOmulada6SV1sK+LK6OI8NTQ/Vvvl" +
       "N3cM1nE1jJc0TWccorWaWro6RONRUus8XabSpLWFXE9KomSsazAjLdHMpBGY" +
       "NAKTZvA6o0D6Gqqlkh06h8MynMoMGQViZGYuE0MypaTNpofLDBwqmI2dEwPa" +
       "GVm0GXN7IN49P7L7J9fWPV5CavtIraL1ojgyCMFgkj5QKE32U9Nqj8dpvI/U" +
       "a2DwXmoqkqpsta3dYCkDmsRS4AIZteDDlEFNPqejK7AkYDNTMtPNLLwEdyr7" +
       "V2lClQYAa6ODVSBcjs8BYJUCgpkJCXzPJhmzWdHi3I9yKbIYW1bCACAtT1I2" +
       "qGenGqNJ8IA0CBdRJW0g0gvOpw3A0FIdXNDkvubDFHVtSPJmaYDGGJnsHdcj" +
       "umBUJVcEkjAy0TuMcwIrTfFYyWWfz1dddPt12gotTEIgc5zKKso/FoiaPESr" +
       "aYKaFOJAEFbPi+6RGp/cGSYEBk/0DBZjfvvDE5ctaDr0vBgztcCY7v5NVGYx" +
       "eX//uFfP7pj7/RIUo8LQLQWNn4OcR1mP3dOWNiDTNGY5YmdrpvPQ6j9fdcND" +
       "9NMwqeokZbKuppLgR/WynjQUlZpXUI2aEqPxTlJJtXgH7+8k5XAfVTQqnnYn" +
       "EhZlnWSMyh+V6fw3qCgBLFBFVXCvaAk9c29IbJDfpw1CSDlcpBquBUT88f+M" +
       "qJFBPUkjkixpiqZHekwd8aNBec6hFtzHodfQI2kJnOacTbFFsSWxRRHLlCO6" +
       "ORCRwCsGaSSdVLlCrEhvql9SVV1GQEtHGF1H0f1b0euM//N8acQ/fjgUAtOc" +
       "7U0MKsTUCl2NUzMm704tXXbi0diLwukwUGzNMTIfJm0Vk7bCpNywVmvhSUko" +
       "xOeagJMLFwADboZUALm4em7vNVdu3NlcAr5nDI8B7ZfA0Dl5a1OHkzMyiT4m" +
       "H3h19cnDL1c9FCZhSCv9sDY5C0RLzgIh1jdTl2kcMpTfUpFJlxH/xaGgHOTQ" +
       "PcM3rtt+LpfDnfORYSmkKyTvwUydnaLFG+uF+Nbu+OjLg3u26U7U5ywimbUv" +
       "jxKTSbPXsl7wMXneDOmJ2JPbWsJkDGQoyMpMgiiChNfknSMnqbRlEjRiqQDA" +
       "Cd1MSip2ZbJqFRs09WHnCXe5en4/AUxciVE2Ha52O+z4f+xtNLCdJFwUfcaD" +
       "gi8AF/cae9945ePzuLoza0Wta5HvpazNlZ+QWQPPRPWOC64xKYVx79zTc9fd" +
       "n+/YwP0PRswqNGELth2Ql8CEoOZbnt/y5nvv7n89nPXZEIMFOtUPtU46CzKM" +
       "mCoCQKKfO/JAflMhXNBrWtZq4JVKQpH6VYpB8m3t7IVPfHZ7nfADFZ5k3GjB" +
       "6Ayc52ctJTe8eO3JJs4mJOP66ujMGSaS9niHc7tpSiMoR/rGI9N++py0F9I/" +
       "pFxL2Up5FiVcB4Qb7XyOP8Lb8zx9F2DTYrmdPze+XHVQTL7j9eM1644/dYJL" +
       "m1tIuW3dJRltwr2wmZ0G9pO8iWaFZA3CuPMPrbq6Tj30DXDsA44yVA9Wtwmp" +
       "Lp3jGfbo0vK3nvlj48ZXS0h4OalSdSm+XOJBRirBu6k1CFkybVx6mTDuMFq6" +
       "jkMleeBRn9MLW2pZ0mBct1t/N+k3F/1y37vcqTiHafnxstJ2pZWF4wXbOdjM" +
       "y/dCP1KPvULCn7mRXDkYC3jI7hbrMZUkBNWQXV4cbDy55U/lWy/PlA6FSMTI" +
       "lVbX4d+v+DDGg7YCczU+x2lrXFm43RxwZYw6AeM7+AvB9W+8UHx8IBbqhg67" +
       "WpiRLRcMA31gbkB9nwshsq3hvc33ffSIgOAtpzyD6c7du75rvX23iERRc87K" +
       "K/vcNKLuFHCw6UTpZgbNwimWf3hw2x8e3LZDSNWQW0Etgw3CI3/910ut9/zt" +
       "hQKLc4li7xtyDdrotY6AVLZw7z+33/pGN6wCnaQipSlbUrQz7uYJRbOV6neZ" +
       "y6lm+QM3ODQNI6F5YAX+eFlAPliPzWW8awk27SJ5/uDUYgofXOoXKOttb19f" +
       "fKD4kXqAhLkcYfy5gjectRQAV8bmagfuNcXDFRRT+TPcw8/Iq5P45txZ4j97" +
       "+94Pnj55f7lwo4Cg8NBN/rpb7b/p/a/yki+vaArEiYe+L3Lgvikdl3zK6Z3S" +
       "AqlnpfPLTii+HNpFDyW/CDeXPRsm5X2kTrY3wuskNYULdh9s/qzM7hg2yzn9" +
       "uRs5sWtpy5ZOZ3sD1TWtt6hxe/8YluPpTh2DOwdyNlwR22ciXncLEX4j9DaH" +
       "t3OxWZApGyoNU2cgJY17KoexAWwZGZuM9UOhvRnX4KwLjnd8Sx/Ntwazs9Xg" +
       "0xlwLbJnW+QDYtgJmy35svpRc1khXwlxC8maPnVZucKnwrXYnm2xj6zXB8rq" +
       "R81IaTKWlHC5nu0fKrwcErlz3y9mvbJ936xjvKKoUCxwKFjBCmzlXTTHD7z3" +
       "6ZGaaY/yqnsMLoR2Vs09A8k/4sg5ueCeWJurmLogxfChN2cJzsL+aXCdaxPw" +
       "/4zEzvhOdH1XdOHCjkEpu9n9X08hoC63F1v8t9J1381A6bA39S6Q+HNt2jAM" +
       "4u0RPojNrRn3+nHheOarwTngRQlFk1Ruok7YGahUGxCnDquwucVIe1cR/nsy" +
       "s4tuTF6tHaquUazfM31i+6zordmDN+hM5wmLxYV3UejijuNk2CVHTpa8fefk" +
       "6vx9M3Jr8tkVz/MPCe8Ez930yZQ1lwxuLGJDPN0TMV6Wv+o68MIVc+Q7w/zU" +
       "TiT0vNO+XKK23DReZVKWMrXcsqVZ2JXbxVUWcNMFrOX3B/Q9gM3PwQtkNKGw" +
       "eMDwB+2lnXjS4vYi0yKm8AvtYL7QJy0+HJgW/ah5Ck8opsWWw6a5UAo/UKSs" +
       "U+Bqs2dr85H18UBZ/agh3HgKPxd/7fCI+esAMdOFikL+V0Y854Ou6Vz1GMHC" +
       "fprfES4v6vfftHtfvPuBhWHb9D2w/jPdOEelQ1R1sRJ5/b7cJboerrgtRtyr" +
       "MweoX1nrRxrgmc8G9D2HzSEmTgG4Szhqfua/rOMdwGhhXsdrttRaAOACVVW5" +
       "YSpDsBn01FSVARwL74M5Mj7ZawHK+As2L8G0FmW9oI+Ci86QrsQdHb182jqq" +
       "wq7ZcI3YiEaKdwo/Un9l3Ma5vh+gjL9j8w4jVVI8ju/CqMZPq4462N89M/5x" +
       "MVx7bAB7RsF+ON8R/Ej993m3Od7wjwAFHMfmY0iajgIsjwY+OTMaWAjX0zaM" +
       "p4vXgB/paKHwdQD4b7H5IhD8l2cGPI46aiM4Wjx4P9JTMX+ozF8DoQpsIAfV" +
       "KppFTWYrod0TBKHwaWuBH3bMBMuMExzE/6ISgC9pAL6GgL4J2NQwUm/SpD5E" +
       "21W1sA+Exp02+vHYNQNEb7IhNBXtA76ko6S/UFOACmZgcxYjNUIFbvwBW5Ly" +
       "fl1XqaQVmnNt2tHblDMTO98D1vbhQijvzGJ0vfmRjpI4QpEAvS3EZh6ETY7e" +
       "8sJm/pkJm1aQ6yobxVXFh40f6Sklj7YALVyMzQWMVEMl4aeCJaetAh7tk0D+" +
       "XTaOXcWrwI90NB+4IgB9JzZLoSimbui3OdA7zkzamAoS3WvLf2/x7u9HOlra" +
       "6A2AvhabVYxU2GelOCjU7CDvPm3kfBMBN6GHbfEfLt7ofqSn5PexAPgSNn2Q" +
       "B2GXRNPdCU7loN9w5tAfsSEcKR69H+lodt8cADyJTcIX+MBpA6/FLthvh47Z" +
       "0h8r3uH9SEcDPhwAfAQbEwpF2CGzzoLgrf/iBQkjjYW/QsFD3cl5n8GJT7fk" +
       "R/fVVkzat/aoOJPNfF5VHSUViZSqul8FuO7LDJMmFK6+avFiwODIbmBkQqHP" +
       "Yxgp5f95aG8XY29mZFzuWEZKoHWPuRX2Us4YRsrEjXvIj4AKhuDtLnHWNJmR" +
       "OucwUbwJSYujzOxxRUbRZOJoinadcMzKOQXknx9mTuxS4gPEmHxw35Wrrjtx" +
       "wQPiAw1ZlbZuRS5jo6RcfCvCmeKp30xfbhleZSvmfjPuscrZmTOTeiGw47RT" +
       "Hacil4L7GWjpKZ6vF6yW7EcMb+6/6KmXd5YdCZPQBhKSGBm/If+dUdpImWT6" +
       "hmihV6brJJN/WNFW9cHGw1+9FWrgr+yJOHxtCqKIyXc99XZPwjB+FiaVnaSU" +
       "xzx/oXX5iLaaykNmzhvYsn49pWVfCIxDt5Tw00SuGVuhNdmn+IEPI835L6Pz" +
       "P3qqUvVhai5F7simxnNOmjIMdy/X7BpsOtOoafC1WLTLMDJv4Z/nmjcMjMDQ" +
       "Xvyx9j9TzlZsYywAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JXyQ2F+On762Hvt+LuNnziKrmIL6T1964Z/+gxde3MF48HgQ0AYx7hf+zf/+" +
       "6uVP/8nvnbK+3AYCvILCD5yhzv08wYqqWp781E7OjVtSCWlfrtLNq8SNup6A" +
       "cK6g4Fz+s1UkxdDCGUAnecIeAuVuBuiu7WPFrwtn6yGVB+GHy9Nj/4uzlY/9" +
       "h/95nQMoVtVTVPNE/zn02mcfJz7w3aL/4fKW934yuz72ABuWw761X3f++7l3" +
       "nv+X50p3zkuX1P3d0FS243zRmIMdQHiwRQI7pmP1x6P5Xeh65dry/Y6TtnFk" +
       "2pML66FOgnzeOs/ffWItzcPH0jvAA+2LHzqpOXulInN1pzxF+lye/MTB0nWX" +
       "H3gRoFLXirGJqHSPc1UBgdQqd/HXFOXSoQZ8+I00YH6Nvvvy0qfBU9unr3YD" +
       "+hY3oC/PqkcIA5a7o+00wpZvnrCCcW8HT2OfsMYNCHPfDGF3OFcdOV83n7+x" +
       "fhfr6M5tvvr3n/3aR1999tvFUnTBDIEW4MHilE3YkT7ff+1b3/36fU98sQjX" +
       "blfkcKcPJ3ev129Oj+05C4LvPc6FS2dxoWhaJMku/8EC8i7fjgAlINT2ff/Q" +
       "9A8WnYLfu477rPzZ01lZOKN3AyYapivbByw9b+vuYrddKsQc+9lJJ1b8flu0" +
       "H6zkBgd2rZ6r53HPQd0u7je9y9dODEBldh2xQem9N5YcUzDw0D18+WN/9vj4" +
       "A8sP30TA/9QJwZ4c8teY136v8y71l8+VbrvmLK47Tjje6cpxF3F3oEdx4I6P" +
       "OYondvwv+Hdk9ShYfIbL/8Uz6n4pT14C0lJzVu8kc0bzX85KJ4zUu0kjzb1H" +
       "c189mzcw0k+9Se9hmEEYUSD2P817vHKThD0Oniv7hF25AWGffTOEnS+8RyX/" +
       "lZ6g6XNvSNPOHPeAI7+jdhm9XIzy906f9bZ9QzsfFgds+a+PHtDwqGWrzx2E" +
       "W1M9CIE+P2fZ6IEdXTq0sd0R1QlCiTdNKLC1+w8Hoz13ceUX/vSTX/2lZ78F" +
       "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" +
       "uF+pnts/C6ai0l2R5/+krSe6fWSoi0X+");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("xeMvjfKMtk+GdvJ09RDo6Uer787e6Ij7q2fUfS1Pvhzt7jgUJ8WHPP3KTb/m" +
       "PcR1T16Yv+Z193G5N4MrKt3pB2YiR/qp4PYO0e/e6f7hGQj/fZ78azBiqEcC" +
       "AHnquWfimdoh8G/cAvC788LnwbPZB755awR6BHNWNPjOGZj/LE/+Y1S6W9a0" +
       "/NKs7hb3aP7oEOKf3qps3w+eV/YhvnKzEL95KsQj7+uzQ9n+tzNw/jBP/mtU" +
       "uucQZ3gC6PdvFWgVPL+7D/R33xqgJ/V3r3RjjHsFP350JsY/v1WMMHi+uY/x" +
       "mz9GYe7dewbQ/FrT3p1Rfis61INoHyt+QnP3LtwC2OLyyTOA7vt3fXf/b904" +
       "j8J47Iy6x/PkIbCmBbrjJTpu26dLdO/hWwD5UF74NKD3yX2QT77lWlt4oL3n" +
       "zkD6rjx5Kirdt0N6FOYJ33un4nm2LruH4J++VXX+CUDm/iWRvesuibxFJguf" +
       "Ab6RJ5eBJh8Df50mQ7eqyaB+b7aPc/bWaPLpZvvBM8DiefJTUelesL7eCOmV" +
       "W0BamOijgOiX9pG+9NYgvU6igzNAMnmSx3T6UYTZIcLOrRrs2wEtn9lH+Jkf" +
       "k8GKZyCc5ckoKl3Yvz6WN9p79yFA4RYAFkHuw4CU39gH+Bs/TmVVz0CZh7h7" +
       "HwJOB4TsesYZRa9DkFffCpBf3wf59bdcT3dS9M7At84T64b4VreA72Je+Dig" +
       "5Nv7+L79Y9LSj5yB74U8SUAwBDZfUe9UjOlN3dmMSo+c/jFFfsPtseu+5tp9" +
       "gaR+8dWLFx59dfLN3QW1g6+E7qJLF4zYto9eZjySP+8HumEWPLhrd7XRLzD9" +
       "jaj08GlfeUSlO4r/hSX+9V3bF6PS/cfbRqXbQHq0zUsg7j9sE5XO7zJHm/wi" +
       "6AWa5NlP7G40Hb/2srvLme0utj12VB+KePPBN2LxkW3zs8fumhVf0R3cC4t3" +
       "39FdVb/0ap/9yA+QX9l95qDa8nabj3KBLt25++KiGDS/W/bMDUc7GOt89z0/" +
       "uv8373r+YCN+/47gQ908QttTp39T0Hb8qPgKYPvbj/6jn/7VV/+4uIXzfwHg" +
       "+8SK3jgAAA==");
}
