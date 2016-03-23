package org.sunflow.core.photonmap;
public final class GlobalPhotonMap implements org.sunflow.core.GlobalPhotonMapInterface {
    private java.util.ArrayList<org.sunflow.core.photonmap.GlobalPhotonMap.Photon>
      photonList;
    private org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] photons;
    private int storedPhotons;
    private int halfStoredPhotons;
    private int log2n;
    private int numGather;
    private float gatherRadius;
    private org.sunflow.math.BoundingBox bounds;
    private boolean hasRadiance;
    private float maxPower;
    private float maxRadius;
    private int numEmit;
    public GlobalPhotonMap(int numEmit, int numGather, float gatherRadius) {
        super(
          );
        this.
          numEmit =
          numEmit;
        this.
          numGather =
          numGather;
        this.
          gatherRadius =
          gatherRadius;
        bounds =
          new org.sunflow.math.BoundingBox(
            );
        hasRadiance =
          false;
        maxPower =
          0;
        maxRadius =
          0;
    }
    public void prepare(org.sunflow.math.BoundingBox sceneBounds) {
        photonList =
          new java.util.ArrayList<org.sunflow.core.photonmap.GlobalPhotonMap.Photon>(
            );
        photonList.
          add(
            null);
        photons =
          null;
        storedPhotons =
          (halfStoredPhotons =
             0);
    }
    public void store(org.sunflow.core.ShadingState state,
                      org.sunflow.math.Vector3 dir,
                      org.sunflow.image.Color power,
                      org.sunflow.image.Color diffuse) { org.sunflow.core.photonmap.GlobalPhotonMap.Photon p =
                                                           new org.sunflow.core.photonmap.GlobalPhotonMap.Photon(
                                                           state.
                                                             getPoint(
                                                               ),
                                                           state.
                                                             getNormal(
                                                               ),
                                                           dir,
                                                           power,
                                                           diffuse);
                                                         synchronized (this)  {
                                                             storedPhotons++;
                                                             photonList.
                                                               add(
                                                                 p);
                                                             bounds.
                                                               include(
                                                                 new org.sunflow.math.Point3(
                                                                   p.
                                                                     x,
                                                                   p.
                                                                     y,
                                                                   p.
                                                                     z));
                                                             maxPower =
                                                               java.lang.Math.
                                                                 max(
                                                                   maxPower,
                                                                   power.
                                                                     getMax(
                                                                       ));
                                                         }
    }
    private void locatePhotons(org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons np) {
        float[] dist1d2 =
          new float[log2n];
        int[] chosen =
          new int[log2n];
        int i =
          1;
        int level =
          0;
        int cameFrom;
        while (true) {
            while (i <
                     halfStoredPhotons) {
                float dist1d =
                  photons[i].
                  getDist1(
                    np.
                      px,
                    np.
                      py,
                    np.
                      pz);
                dist1d2[level] =
                  dist1d *
                    dist1d;
                i +=
                  i;
                if (dist1d >
                      0.0F)
                    i++;
                chosen[level++] =
                  i;
            }
            np.
              checkAddNearest(
                photons[i]);
            do  {
                cameFrom =
                  i;
                i >>=
                  1;
                level--;
                if (i ==
                      0)
                    return;
            }while(dist1d2[level] >=
                     np.
                       dist2[0] ||
                     cameFrom !=
                     chosen[level]); 
            np.
              checkAddNearest(
                photons[i]);
            i =
              chosen[level++] ^
                1;
        }
    }
    private void balance() { if (storedPhotons ==
                                   0) return;
                             photons = photonList.
                                         toArray(
                                           new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[photonList.
                                                                                                   size(
                                                                                                     )]);
                             photonList =
                               null;
                             org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp =
                               new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[storedPhotons +
                                                                                       1];
                             balanceSegment(
                               temp,
                               1,
                               1,
                               storedPhotons);
                             photons = temp;
                             halfStoredPhotons =
                               storedPhotons /
                                 2;
                             log2n = (int)
                                       java.lang.Math.
                                       ceil(
                                         java.lang.Math.
                                           log(
                                             storedPhotons) /
                                           java.lang.Math.
                                           log(
                                             2.0));
    }
    private void balanceSegment(org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp,
                                int index,
                                int start,
                                int end) {
        int median =
          1;
        while (4 *
                 median <=
                 end -
                 start +
                 1)
            median +=
              median;
        if (3 *
              median <=
              end -
              start +
              1) {
            median +=
              median;
            median +=
              start -
                1;
        }
        else
            median =
              end -
                median +
                1;
        int axis =
          org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
            SPLIT_Z;
        org.sunflow.math.Vector3 extents =
          bounds.
          getExtents(
            );
        if (extents.
              x >
              extents.
                y &&
              extents.
                x >
              extents.
                z)
            axis =
              org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                SPLIT_X;
        else
            if (extents.
                  y >
                  extents.
                    z)
                axis =
                  org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                    SPLIT_Y;
        int left =
          start;
        int right =
          end;
        while (right >
                 left) {
            double v =
              photons[right].
              getCoord(
                axis);
            int i =
              left -
              1;
            int j =
              right;
            while (true) {
                while (photons[++i].
                         getCoord(
                           axis) <
                         v) {
                    
                }
                while (photons[--j].
                         getCoord(
                           axis) >
                         v &&
                         j >
                         left) {
                    
                }
                if (i >=
                      j)
                    break;
                swap(
                  i,
                  j);
            }
            swap(
              i,
              right);
            if (i >=
                  median)
                right =
                  i -
                    1;
            if (i <=
                  median)
                left =
                  i +
                    1;
        }
        temp[index] =
          photons[median];
        temp[index].
          setSplitAxis(
            axis);
        if (median >
              start) {
            if (start <
                  median -
                  1) {
                float tmp;
                switch (axis) {
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                           SPLIT_X:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            x;
                        bounds.
                          getMaximum(
                            ).
                          x =
                          temp[index].
                            x;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          x =
                          tmp;
                        break;
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                           SPLIT_Y:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            y;
                        bounds.
                          getMaximum(
                            ).
                          y =
                          temp[index].
                            y;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          y =
                          tmp;
                        break;
                    default:
                        tmp =
                          bounds.
                            getMaximum(
                              ).
                            z;
                        bounds.
                          getMaximum(
                            ).
                          z =
                          temp[index].
                            z;
                        balanceSegment(
                          temp,
                          2 *
                            index,
                          start,
                          median -
                            1);
                        bounds.
                          getMaximum(
                            ).
                          z =
                          tmp;
                }
            }
            else
                temp[2 *
                       index] =
                  photons[start];
        }
        if (median <
              end) {
            if (median +
                  1 <
                  end) {
                float tmp;
                switch (axis) {
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                           SPLIT_X:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            x;
                        bounds.
                          getMinimum(
                            ).
                          x =
                          temp[index].
                            x;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          x =
                          tmp;
                        break;
                    case org.sunflow.core.photonmap.GlobalPhotonMap.Photon.
                           SPLIT_Y:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            y;
                        bounds.
                          getMinimum(
                            ).
                          y =
                          temp[index].
                            y;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          y =
                          tmp;
                        break;
                    default:
                        tmp =
                          bounds.
                            getMinimum(
                              ).
                            z;
                        bounds.
                          getMinimum(
                            ).
                          z =
                          temp[index].
                            z;
                        balanceSegment(
                          temp,
                          2 *
                            index +
                            1,
                          median +
                            1,
                          end);
                        bounds.
                          getMinimum(
                            ).
                          z =
                          tmp;
                }
            }
            else
                temp[2 *
                       index +
                       1] =
                  photons[end];
        }
    }
    private void swap(int i, int j) { org.sunflow.core.photonmap.GlobalPhotonMap.Photon tmp =
                                        photons[i];
                                      photons[i] =
                                        photons[j];
                                      photons[j] =
                                        tmp;
    }
    static class Photon {
        float x;
        float y;
        float z;
        short dir;
        short normal;
        int data;
        int power;
        int flags;
        static final int SPLIT_X = 0;
        static final int SPLIT_Y = 1;
        static final int SPLIT_Z = 2;
        static final int SPLIT_MASK = 3;
        Photon(org.sunflow.math.Point3 p,
               org.sunflow.math.Vector3 n,
               org.sunflow.math.Vector3 dir,
               org.sunflow.image.Color power,
               org.sunflow.image.Color diffuse) {
            super(
              );
            x =
              p.
                x;
            y =
              p.
                y;
            z =
              p.
                z;
            this.
              dir =
              dir.
                encode(
                  );
            this.
              power =
              power.
                toRGBE(
                  );
            flags =
              0;
            normal =
              n.
                encode(
                  );
            data =
              diffuse.
                toRGB(
                  );
        }
        void setSplitAxis(int axis) { flags &=
                                        ~SPLIT_MASK;
                                      flags |=
                                        axis;
        }
        float getCoord(int axis) { switch (axis) {
                                       case SPLIT_X:
                                           return x;
                                       case SPLIT_Y:
                                           return y;
                                       default:
                                           return z;
                                   } }
        float getDist1(float px, float py,
                       float pz) { switch (flags &
                                             SPLIT_MASK) {
                                       case SPLIT_X:
                                           return px -
                                             x;
                                       case SPLIT_Y:
                                           return py -
                                             y;
                                       default:
                                           return pz -
                                             z;
                                   } }
        float getDist2(float px, float py,
                       float pz) { float dx =
                                     x -
                                     px;
                                   float dy =
                                     y -
                                     py;
                                   float dz =
                                     z -
                                     pz;
                                   return dx *
                                     dx +
                                     dy *
                                     dy +
                                     dz *
                                     dz; }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAALVZDZAUxRXu3fvlOLgf4MBT/g8TUHeDaIx1aICTg9O944qD" +
           "Kz2UZXa2925gdmac6b3bw5CIVQkkMRaRA4lRKj9YooVipWJpKtE6RAEFksL4" +
           "S6JYJjEGtSKxlCQmMe/1zOz87M7CXelVTV9vz3uv3/f69Xuve/Z9QMoMnUyj" +
           "CouwQY0akaUK6xR0gyZbZMEwVsFYXLynRPho7bsdV4dJeQ8Z3ycY7aJg0FaJ" +
           "ykmjh0yVFIMJikiNDkqTyNGpU4Pq/QKTVKWHTJKMtrQmS6LE2tUkRYJuQY+R" +
           "OoExXUpkGG2zBDAyNQaaRLkm0cX+180xUi2q2qBDPsVF3uJ6g5RpZy6DkdrY" +
           "eqFfiGaYJEdjksGaszq5RFPlwV5ZZRGaZZH18pWWCa6PXZlnglmP1Xzy6ba+" +
           "Wm6CCYKiqIzDM1ZSQ5X7aTJGapzRpTJNG7eSb5KSGBnrImakKWZPGoVJozCp" +
           "jdahAu3HUSWTblE5HGZLKtdEVIiRmV4hmqALaUtMJ9cZJFQyCztnBrQzcmhN" +
           "lHkQd1wSHbpnbe0vSkhND6mRlC5URwQlGEzSAwal6QTVjcXJJE32kDoFFruL" +
           "6pIgSxutla43pF5FYBlYftssOJjRqM7ndGwF6wjY9IzIVD0HL8UdyvpVlpKF" +
           "XsDa4GA1EbbiOACskkAxPSWA31kspRskJcnIdD9HDmPTDUAArBVpyvrU3FSl" +
           "igADpN50EVlQeqNd4HpKL5CWqeCAOiONgULR1pogbhB6aRw90kfXab4CqjHc" +
           "EMjCyCQ/GZcEq9ToWyXX+nzQsfCu25TlSpiEQOckFWXUfywwTfMxraQpqlPY" +
           "ByZj9bzYTqHhqa1hQoB4ko/YpHniG2cWXTpt+IhJc2EBmhWJ9VRkcXFPYvyJ" +
           "i1rmXl2CalRqqiHh4nuQ813Wab1pzmoQYRpyEvFlxH45vPLQTbc/TN8Lk6o2" +
           "Ui6qciYNflQnqmlNkqm+jCpUFxhNtpExVEm28PdtpAL6MUmh5uiKVMqgrI2U" +
           "ynyoXOW/wUQpEIEmqoK+pKRUu68JrI/3sxohZCw8pBaeYWL+8f+MdEf71DSN" +
           "alK0U1cRuhGFYJMAs/ZFjYySktWBqKGLUVXvzf0WVR04+lSmKmlBiy6T1YQg" +
           "d/Lf7YIWQf/SvjDJWcQ0YSAUAnNf5N/sMuyT5aqcpHpcHMosWXrm0fhR05HQ" +
           "+S1rMDIf5oxYc0ZwzkhuzohvziazR0IhPuNEVMFcXFiaDbDJIcpWz+265fp1" +
           "W2eVgFdpA6VgVySd5ck2LU4ksMN3XNxfP27jzDfnHwyT0hipF0SWEWRMHov1" +
           "XghL4gZr51YnIA856WCGKx1gHtNVkSYhGgWlBUtKpdpPdRxnZKJLgp2scFtG" +
           "g1NFQf3J8K6Bzd3f+kqYhL0ZAKcsg+CF7J0Yt3Pxucm/8wvJrdny7if7d25S" +
           "nRjgSSl2JszjRAyz/D7hN09cnDdDeDz+1KYmbvYxEKOZAHsKwt80/xyeENNs" +
           "h2vEUgmAU6qeFmR8Zdu4ivXp6oAzwp21jvcngltU4p4bD8/vrE3I/+PbBg3b" +
           "yaZzo5/5UPB0cE2Xdv9rv/3bAm5uO3PUuFJ+F2XNrmiFwup5XKpz3HaVTinQ" +
           "vbGrc/uOD7as4T4LFLMLTdiEbQtEKVhCMPO3j9z6+qk397wUzvk5yXqxVRbB" +
           "BpNc7KgBQU6GmIDO0rRaAbeUUpKQkCnup//UzJn/+Pt31ZrLL8OI7T2XnluA" +
           "M37BEnL70bVnp3ExIRGTrGMqh8yM3BMcyYt1XRhEPbKbX5z6o8PC/ZADIO4a" +
           "0kbKQ2kZh17GkU9hZLI7mKQh6ELYh6S9wH4/Je99N0WnXYDvryooRUpDLkWE" +
           "qo6vr+ZucQUnjfJ2AdrWWgH8vRCbOYZ7e3l3sKvuiovbXvpwXPeHT5/hhvEW" +
           "bm5vgujXbDowNhdnQfxkf/hbLhh9QHfFcMfNtfLwpyCxBySKUK0YK3QIw1mP" +
           "71nUZRUnDxxsWHeihIRbSZWsCslWgW9jMgb2DzX6IIJnta8vMv1ooNLKXCRL" +
           "8sDnDeBaTi/sJUvTGuPruvHJyb9c+ODuN7kfa6aMCzl/NSYVT9zm5b8TOh7+" +
           "/VUvP/jDnQNmATE3OF76+Kb8e4WcuOPtf+aZnEfKAsWNj78nuu++xpZr3+P8" +
           "TshC7qZsfiKEsO/wXv5w+uPwrPLnwqSih9SKVrndLcgZDAQ9UGIadg0OJbnn" +
           "vbdcNGuj5lxIvsgfLl3T+oOlk4Chj9TYH1coPuJSH7BiyAF/fAwR3ungLF/C" +
           "5pL8CBTEzUgo603MmPy6MgkDkqiUhpjZb9WSl3euE7c2df7ZXOYLCjCYdJP2" +
           "Rn/Q/er6YzwiV2KaXmVDcyVhSOeudFBrKvwZ/IXg+R8+qCgOmDVZfYtVGM7I" +
           "VYbopkX9zQcguqn+1Ib73n3EBOB3Lh8x3Tr0vc8idw2Z8dY8XszOq/DdPOYR" +
           "w4SDTTdqN7PYLJyj9a/7N/1676Ytplb13mJ5KZwFH3nlv8ciu956vkDNBt6k" +
           "Ciy330O5Omuid3VMSNd9t+Y32+pLWiHFt5HKjCLdmqFtSa8bVhiZhGu5nIOL" +
           "45oWOFwacJ55sApmgsb2GmxWmNFjUWCwWp7v3M9Y7vlMgHOnijp3EDfoN4id" +
           "1T4Ne0eh4UFrjoMBGqaLahjEDRpuLKShMkIN6+F51prj2QANWVENg7gZKUlK" +
           "ZsHcZbk1/rvR1b8ZPBESlJ7nifgz4XePzAihTYLnOUu55wKg3V4UWhA3I+UK" +
           "L1fx16BPzc0jVLMOnkPWRIcC1NxSVM0gbga5RWDCuZagRFLObwG2jsK3Dlu6" +
           "HQ5Atr0osiBu8BtNHTBT9p0+LYdGoeURa54jAVreW1TLIG7mytp+LX98/lqi" +
           "H5M58LxgzfNCnpah3LEEa4tIm8JoL9Xr3/7JnrObt3wtjCV3WT/WIJApah26" +
           "jgxez31n346pY4fe+j6v4GzRPzUR83YeNpdxxwiD6xv8kg/BSYog+w4tE4vo" +
           "yUhFV2esbVX8xkIW+dkoLHLUmuloAYtg5+e2Lz8aAAe7e7F5qACOIOk5HDcV" +
           "wrF/FDiOWTMdK4KD6/rEaHAESc/h6CmE48kR4vgyPMetmY4XwVGCneHR4AiS" +
           "zkiViaN9cdcNhaAcKAIlW1gT7jV7HSX4gaiK+K78XEq4Dj4EC7ipQbeyvHjb" +
           "c8fQ7uSKB+aHrTPnLbCvrMtyR04pivEcoNr5JbRzGnlj/N1/+lVT75KR3Hnh" +
           "2LRz3Grh7+kQK+YF18h+VQ7fcbpx1bV960ZwfTXdZyK/yIfa9z2/7GLx7jC/" +
           "cTePSXk39V6mZm9VWqVTltEVbx062+tZs+E5aS3qSb/fOo4UFPyDWH0XDK68" +
           "eieXerLIDcQfsXmZwQmasi5NltjirGQUSt2l/aqUdPz8lXNt2eKnfRxo1fj4" +
           "iRxQvGEjDfCcsoCeGrmNgljPZaPTRWz0PjZ/YaSyl7IWVdWT+Hu1Y4t3vkhb" +
           "nLYAnR65LYJYfVBLuCI8Vq52Gi7/bBGr/Aubf5hWuU4y2HyfVT76Iq3ysQXt" +
           "45FbJYj1vK0SKg22SqgcBz9zrHK51yoh8nlYJQsh3Py+wSmmMDLv/L+MQKSf" +
           "kvex1fxAKD66u6Zy8u7Vr/Ign/uIVw3hOpWRZfdVkKtfruk0JXHLV5sXQ/y4" +
           "HaplpDFYLUbG5PqIIlRjck1gpNbPBdEH/7nJGhgZ6yJjeCvAe26iC+DEAUTY" +
           "bdRsU7mKUvNiLBvyJtScB08611q5cvBsT/ri37ztVJMxv3rHxf27r++47cxX" +
           "HzC/A4iysJGfq8fGSIX5SSKXrmYGSrNllS+f++n4x8bMsbN6namw4/4XurZq" +
           "K4Q6DRe+0XdbbjTlLs1f37Pw6eNby1+ECn4NCQmMTFiTf4WY1TJQJ6yJ5V/d" +
           "QGrn1/jNc+8dvPbS1N//YJf4Ie/VrJ8+LvZsf63tsQ1nF/GPrGVQsNAsv9u8" +
           "blBZScV+3XMPNB59UsCv39wOlvnG5UbxqxEjs/IvwfK/tVXJeKxbomYUHs/H" +
           "QSnhjNhliifDZzTNx+CMWEuHrWAmTrQ++F881q5p9h3hOxrfwYnAM3DoMt7F" +
           "XuT/BW0I6P4iAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "WSOWTS6YrUWx5G+msYmnVZRz2dAhpmNt0Z2JvLlerThzlEfKNFy6E6m9ludN" +
           "dSNxy769VCr2NGjXFgEshX3f6VW1mciFSWlgD7Uq0fbs2bApMAtN7E6kbD10" +
           "KpEnulVccZnl0unbNT+dNirITFEr4cYLphITroms6+b9GppNqCmnajBHN6gF" +
           "FlR5B1tqjkSb7tRfei69WHqlOR7y3dymk5DIBcKrNiZ6ErYobMR7Npo6pDBa" +
           "WtGgyq/9dSCOZ/CKn4bEgPCWAVkKSYZPscYwGsBInAe2jK8aYVsxpBlVapil" +
           "kU6Y9UqHpRWXLPMVjUntXlcajloxLHfn0ppdJLP2kuxRvCBmG7M8E5hyreSy" +
           "Hum5bWeNcRVpaukwZdalwWxqwmw27wxn2rQssS2+5dMmSsPxKF1zqLLUwn6o" +
           "9UdBPBMjr2zaTBntT0tsJRp1BiYa5JJWllebhZ1uAjvbOMqGKQ/sSUoTwqgL" +
           "htZROmpnONDC2aZUxVAzrMyqhmB19bCFCZawZnVUW1QpvraIRzQi0rk5qdbn" +
           "m47p91drrmw7YbfMzogZM+oHWUW0bKpmyRFakfxBq4FiM7xH5hWrn9DCgpXs" +
           "njVz23xChno40Zncl8khZYXVWOsmPatCd6cmMmyQWHujI2ZpsZRsqiy3SC22" +
           "Sni3PixLCTLJU82DG6tsGOn+uu6Ydb2Ksj4zt1jWrQ7jzZxprTdwp27T5abm" +
           "d/SO0dmUKqTkqZmUE+RYbvVjcpU0ynC+Ngiaju1qRvCW1+KxpdH1mIaspzUn" +
           "E0MsaG1WYbUyzzTgZxK+FtbUTgPOIgIZwKWJ2rYQda3ImwCFUX7SLmtEVdSz" +
           "ZpTBiNry0HSMTPi0Oyx1qyIdeU53lYaoSIYbpK8InONPM7UXaXA67tSVuMbV" +
           "qC41ojjdIdRpQpCCjY8mY2Te3GCl5QJp1lf8Jluga3GZC4zaboe0Viet9pTH" +
           "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" +
           "fGn7Fe//Aw/4NOeNLQAA");
    }
    public void init() { org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Balancing global photon map ...");
                         org.sunflow.system.UI.
                           taskStart(
                             "Balancing global photon map",
                             0,
                             1);
                         org.sunflow.system.Timer t =
                           new org.sunflow.system.Timer(
                           );
                         t.start();
                         balance();
                         t.end();
                         org.sunflow.system.UI.
                           taskStop(
                             );
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "Global photon map:");
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Photons stored:   %d",
                             storedPhotons);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Photons/estimate: %d",
                             numGather);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Estimate radius:  %.3f",
                             gatherRadius);
                         maxRadius = 1.4F *
                                       (float)
                                         java.lang.Math.
                                         sqrt(
                                           maxPower *
                                             numGather);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Maximum radius:   %.3f",
                             maxRadius);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Balancing time:   %s",
                             t.
                               toString(
                                 ));
                         if (gatherRadius >
                               maxRadius)
                             gatherRadius =
                               maxRadius;
                         t.start();
                         precomputeRadiance(
                           );
                         t.end();
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Precompute time:  %s",
                             t.
                               toString(
                                 ));
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Radiance photons: %d",
                             storedPhotons);
                         org.sunflow.system.UI.
                           printInfo(
                             org.sunflow.system.UI.Module.
                               LIGHT,
                             "  * Search radius:    %.3f",
                             gatherRadius);
    }
    public void precomputeRadiance() { if (storedPhotons ==
                                             0)
                                           return;
                                       int quadStoredPhotons =
                                         halfStoredPhotons /
                                         2;
                                       org.sunflow.math.Point3 p =
                                         new org.sunflow.math.Point3(
                                         );
                                       org.sunflow.math.Vector3 n =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.math.Point3 ppos =
                                         new org.sunflow.math.Point3(
                                         );
                                       org.sunflow.math.Vector3 pdir =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.math.Vector3 pvec =
                                         new org.sunflow.math.Vector3(
                                         );
                                       org.sunflow.image.Color irr =
                                         new org.sunflow.image.Color(
                                         );
                                       org.sunflow.image.Color pow =
                                         new org.sunflow.image.Color(
                                         );
                                       float maxDist2 =
                                         gatherRadius *
                                         gatherRadius;
                                       org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons np =
                                         new org.sunflow.core.photonmap.GlobalPhotonMap.NearestPhotons(
                                         p,
                                         numGather,
                                         maxDist2);
                                       org.sunflow.core.photonmap.GlobalPhotonMap.Photon[] temp =
                                         new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[quadStoredPhotons +
                                                                                                 1];
                                       org.sunflow.system.UI.
                                         taskStart(
                                           "Precomputing radiance",
                                           1,
                                           quadStoredPhotons);
                                       for (int i =
                                              1;
                                            i <=
                                              quadStoredPhotons;
                                            i++) {
                                           org.sunflow.system.UI.
                                             taskUpdate(
                                               i);
                                           org.sunflow.core.photonmap.GlobalPhotonMap.Photon curr =
                                             photons[i];
                                           p.
                                             set(
                                               curr.
                                                 x,
                                               curr.
                                                 y,
                                               curr.
                                                 z);
                                           org.sunflow.math.Vector3.
                                             decode(
                                               curr.
                                                 normal,
                                               n);
                                           irr.
                                             set(
                                               org.sunflow.image.Color.
                                                 BLACK);
                                           np.
                                             reset(
                                               p,
                                               maxDist2);
                                           locatePhotons(
                                             np);
                                           if (np.
                                                 found <
                                                 8) {
                                               curr.
                                                 data =
                                                 0;
                                               temp[i] =
                                                 curr;
                                               continue;
                                           }
                                           float invArea =
                                             1.0F /
                                             ((float)
                                                java.lang.Math.
                                                  PI *
                                                np.
                                                  dist2[0]);
                                           float maxNDist =
                                             np.
                                               dist2[0] *
                                             0.05F;
                                           for (int j =
                                                  1;
                                                j <=
                                                  np.
                                                    found;
                                                j++) {
                                               org.sunflow.core.photonmap.GlobalPhotonMap.Photon phot =
                                                 np.
                                                   index[j];
                                               org.sunflow.math.Vector3.
                                                 decode(
                                                   phot.
                                                     dir,
                                                   pdir);
                                               float cos =
                                                 -org.sunflow.math.Vector3.
                                                 dot(
                                                   pdir,
                                                   n);
                                               if (cos >
                                                     0.01F) {
                                                   ppos.
                                                     set(
                                                       phot.
                                                         x,
                                                       phot.
                                                         y,
                                                       phot.
                                                         z);
                                                   org.sunflow.math.Point3.
                                                     sub(
                                                       ppos,
                                                       p,
                                                       pvec);
                                                   float pcos =
                                                     org.sunflow.math.Vector3.
                                                     dot(
                                                       pvec,
                                                       n);
                                                   if (pcos <
                                                         maxNDist &&
                                                         pcos >
                                                         -maxNDist)
                                                       irr.
                                                         add(
                                                           pow.
                                                             setRGBE(
                                                               phot.
                                                                 power));
                                               }
                                           }
                                           irr.
                                             mul(
                                               invArea);
                                           irr.
                                             mul(
                                               new org.sunflow.image.Color(
                                                 curr.
                                                   data)).
                                             mul(
                                               1.0F /
                                                 (float)
                                                   java.lang.Math.
                                                     PI);
                                           curr.
                                             data =
                                             irr.
                                               toRGBE(
                                                 );
                                           temp[i] =
                                             curr;
                                       }
                                       org.sunflow.system.UI.
                                         taskStop(
                                           );
                                       numGather /=
                                         4;
                                       maxRadius =
                                         1.4F *
                                           (float)
                                             java.lang.Math.
                                             sqrt(
                                               maxPower *
                                                 numGather);
                                       if (gatherRadius >
                                             maxRadius)
                                           gatherRadius =
                                             maxRadius;
                                       storedPhotons =
                                         quadStoredPhotons;
                                       halfStoredPhotons =
                                         storedPhotons /
                                           2;
                                       log2n =
                                         (int)
                                           java.lang.Math.
                                           ceil(
                                             java.lang.Math.
                                               log(
                                                 storedPhotons) /
                                               java.lang.Math.
                                               log(
                                                 2.0));
                                       photons =
                                         temp;
                                       hasRadiance =
                                         true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.math.Point3 p,
                                               org.sunflow.math.Vector3 n) {
        if (!hasRadiance ||
              storedPhotons ==
              0)
            return org.sunflow.image.Color.
                     BLACK;
        float px =
          p.
            x;
        float py =
          p.
            y;
        float pz =
          p.
            z;
        int i =
          1;
        int level =
          0;
        int cameFrom;
        float dist2;
        float maxDist2 =
          gatherRadius *
          gatherRadius;
        org.sunflow.core.photonmap.GlobalPhotonMap.Photon nearest =
          null;
        org.sunflow.core.photonmap.GlobalPhotonMap.Photon curr;
        org.sunflow.math.Vector3 photN =
          new org.sunflow.math.Vector3(
          );
        float[] dist1d2 =
          new float[log2n];
        int[] chosen =
          new int[log2n];
        while (true) {
            while (i <
                     halfStoredPhotons) {
                float dist1d =
                  photons[i].
                  getDist1(
                    px,
                    py,
                    pz);
                dist1d2[level] =
                  dist1d *
                    dist1d;
                i +=
                  i;
                if (dist1d >
                      0)
                    i++;
                chosen[level++] =
                  i;
            }
            curr =
              photons[i];
            dist2 =
              curr.
                getDist2(
                  px,
                  py,
                  pz);
            if (dist2 <
                  maxDist2) {
                org.sunflow.math.Vector3.
                  decode(
                    curr.
                      normal,
                    photN);
                float currentDotN =
                  org.sunflow.math.Vector3.
                  dot(
                    photN,
                    n);
                if (currentDotN >
                      0.9F) {
                    nearest =
                      curr;
                    maxDist2 =
                      dist2;
                }
            }
            do  {
                cameFrom =
                  i;
                i >>=
                  1;
                level--;
                if (i ==
                      0)
                    return nearest ==
                      null
                      ? org.sunflow.image.Color.
                          BLACK
                      : new org.sunflow.image.Color(
                      ).
                      setRGBE(
                        nearest.
                          data);
            }while(dist1d2[level] >=
                     maxDist2 ||
                     cameFrom !=
                     chosen[level]); 
            curr =
              photons[i];
            dist2 =
              curr.
                getDist2(
                  px,
                  py,
                  pz);
            if (dist2 <
                  maxDist2) {
                org.sunflow.math.Vector3.
                  decode(
                    curr.
                      normal,
                    photN);
                float currentDotN =
                  org.sunflow.math.Vector3.
                  dot(
                    photN,
                    n);
                if (currentDotN >
                      0.9F) {
                    nearest =
                      curr;
                    maxDist2 =
                      dist2;
                }
            }
            i =
              chosen[level++] ^
                1;
        }
    }
    private static class NearestPhotons {
        int found;
        float px;
        float py;
        float pz;
        private int max;
        private boolean gotHeap;
        protected float[] dist2;
        protected org.sunflow.core.photonmap.GlobalPhotonMap.Photon[]
          index;
        NearestPhotons(org.sunflow.math.Point3 p,
                       int n,
                       float maxDist2) { super(
                                           );
                                         max =
                                           n;
                                         found =
                                           0;
                                         gotHeap =
                                           false;
                                         px =
                                           p.
                                             x;
                                         py =
                                           p.
                                             y;
                                         pz =
                                           p.
                                             z;
                                         dist2 =
                                           (new float[n +
                                                        1]);
                                         index =
                                           (new org.sunflow.core.photonmap.GlobalPhotonMap.Photon[n +
                                                                                                    1]);
                                         dist2[0] =
                                           maxDist2;
        }
        void reset(org.sunflow.math.Point3 p,
                   float maxDist2) { found =
                                       0;
                                     gotHeap =
                                       false;
                                     px =
                                       p.
                                         x;
                                     py =
                                       p.
                                         y;
                                     pz =
                                       p.
                                         z;
                                     dist2[0] =
                                       maxDist2;
        }
        void checkAddNearest(org.sunflow.core.photonmap.GlobalPhotonMap.Photon p) {
            float fdist2 =
              p.
              getDist2(
                px,
                py,
                pz);
            if (fdist2 <
                  dist2[0]) {
                if (found <
                      max) {
                    found++;
                    dist2[found] =
                      fdist2;
                    index[found] =
                      p;
                }
                else {
                    int j;
                    int parent;
                    if (!gotHeap) {
                        float dst2;
                        org.sunflow.core.photonmap.GlobalPhotonMap.Photon phot;
                        int halfFound =
                          found >>
                          1;
                        for (int k =
                               halfFound;
                             k >=
                               1;
                             k--) {
                            parent =
                              k;
                            phot =
                              index[k];
                            dst2 =
                              dist2[k];
                            while (parent <=
                                     halfFound) {
                                j =
                                  parent +
                                    parent;
                                if (j <
                                      found &&
                                      dist2[j] <
                                      dist2[j +
                                              1])
                                    j++;
                                if (dst2 >=
                                      dist2[j])
                                    break;
                                dist2[parent] =
                                  dist2[j];
                                index[parent] =
                                  index[j];
                                parent =
                                  j;
                            }
                            dist2[parent] =
                              dst2;
                            index[parent] =
                              phot;
                        }
                        gotHeap =
                          true;
                    }
                    parent =
                      1;
                    j =
                      2;
                    while (j <=
                             found) {
                        if (j <
                              found &&
                              dist2[j] <
                              dist2[j +
                                      1])
                            j++;
                        if (fdist2 >
                              dist2[j])
                            break;
                        dist2[parent] =
                          dist2[j];
                        index[parent] =
                          index[j];
                        parent =
                          j;
                        j +=
                          j;
                    }
                    dist2[parent] =
                      fdist2;
                    index[parent] =
                      p;
                    dist2[0] =
                      dist2[1];
                }
            }
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b/qxF/6sOB3+dwHtPgpWLAAA");
    }
    public boolean allowDiffuseBounced() {
        return true;
    }
    public boolean allowReflectionBounced() {
        return true;
    }
    public boolean allowRefractionBounced() {
        return true;
    }
    public int numEmit() { return numEmit;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F30IYvkyAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IJBS8F5VHGglG0UbLpj+yqrJDWgqxXVl");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
