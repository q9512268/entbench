package org.sunflow.core.accel;
public class BoundingIntervalHierarchy implements org.sunflow.core.AccelerationStructure {
    private int[] tree;
    private int[] objects;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.math.BoundingBox bounds;
    private int maxPrims;
    public BoundingIntervalHierarchy() { super();
                                         maxPrims = 2; }
    public void build(org.sunflow.core.PrimitiveList primitives) { this.primitives =
                                                                     primitives;
                                                                   int n =
                                                                     primitives.
                                                                     getNumPrimitives(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Getting bounding box ...");
                                                                   bounds =
                                                                     primitives.
                                                                       getWorldBounds(
                                                                         null);
                                                                   objects =
                                                                     (new int[n]);
                                                                   for (int i =
                                                                          0;
                                                                        i <
                                                                          n;
                                                                        i++)
                                                                       objects[i] =
                                                                         i;
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Creating tree ...");
                                                                   int initialSize =
                                                                     3 *
                                                                     (2 *
                                                                        6 *
                                                                        n +
                                                                        1);
                                                                   org.sunflow.util.IntArray tempTree =
                                                                     new org.sunflow.util.IntArray(
                                                                     (initialSize +
                                                                        3) /
                                                                       4);
                                                                   org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats =
                                                                     new org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats(
                                                                     );
                                                                   org.sunflow.system.Timer t =
                                                                     new org.sunflow.system.Timer(
                                                                     );
                                                                   t.
                                                                     start(
                                                                       );
                                                                   buildHierarchy(
                                                                     tempTree,
                                                                     objects,
                                                                     stats);
                                                                   t.
                                                                     end(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "Trimming tree ...");
                                                                   tree =
                                                                     tempTree.
                                                                       trim(
                                                                         );
                                                                   stats.
                                                                     printStats(
                                                                       );
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Creation time:  %s",
                                                                       t);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Usage of init:  %3d%%",
                                                                       100 *
                                                                         tree.
                                                                           length /
                                                                         initialSize);
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Tree memory:    %s",
                                                                       org.sunflow.system.Memory.
                                                                         sizeof(
                                                                           tree));
                                                                   org.sunflow.system.UI.
                                                                     printDetailed(
                                                                       org.sunflow.system.UI.Module.
                                                                         ACCEL,
                                                                       "  * Indices memory: %s",
                                                                       org.sunflow.system.Memory.
                                                                         sizeof(
                                                                           objects));
    }
    private static class BuildStats {
        private int numNodes;
        private int numLeaves;
        private int sumObjects;
        private int minObjects;
        private int maxObjects;
        private int sumDepth;
        private int minDepth;
        private int maxDepth;
        private int numLeaves0;
        private int numLeaves1;
        private int numLeaves2;
        private int numLeaves3;
        private int numLeaves4;
        private int numLeaves4p;
        private int numBVH2;
        BuildStats() { super();
                       numNodes = (numLeaves =
                                     0);
                       sumObjects = 0;
                       minObjects = java.lang.Integer.
                                      MAX_VALUE;
                       maxObjects = java.lang.Integer.
                                      MIN_VALUE;
                       sumDepth = 0;
                       minDepth = java.lang.Integer.
                                    MAX_VALUE;
                       maxDepth = java.lang.Integer.
                                    MIN_VALUE;
                       numLeaves0 = 0;
                       numLeaves1 = 0;
                       numLeaves2 = 0;
                       numLeaves3 = 0;
                       numLeaves4 = 0;
                       numLeaves4p = 0;
                       numBVH2 = 0; }
        void updateInner() { numNodes++; }
        void updateBVH2() { numBVH2++; }
        void updateLeaf(int depth, int n) {
            numLeaves++;
            minDepth =
              java.lang.Math.
                min(
                  depth,
                  minDepth);
            maxDepth =
              java.lang.Math.
                max(
                  depth,
                  maxDepth);
            sumDepth +=
              depth;
            minObjects =
              java.lang.Math.
                min(
                  n,
                  minObjects);
            maxObjects =
              java.lang.Math.
                max(
                  n,
                  maxObjects);
            sumObjects +=
              n;
            switch (n) {
                case 0:
                    numLeaves0++;
                    break;
                case 1:
                    numLeaves1++;
                    break;
                case 2:
                    numLeaves2++;
                    break;
                case 3:
                    numLeaves3++;
                    break;
                case 4:
                    numLeaves4++;
                    break;
                default:
                    numLeaves4p++;
                    break;
            }
        }
        void printStats() { org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "Tree stats:");
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Nodes:          %d",
                                numNodes);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Leaves:         %d",
                                numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Objects: min    %d",
                                minObjects);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             avg    %.2f",
                                (float)
                                  sumObjects /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "           avg(n>0) %.2f",
                                (float)
                                  sumObjects /
                                  (numLeaves -
                                     numLeaves0));
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             max    %d",
                                maxObjects);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Depth:   min    %d",
                                minDepth);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             avg    %.2f",
                                (float)
                                  sumDepth /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "             max    %d",
                                maxDepth);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * Leaves w/: N=0  %3d%%",
                                100 *
                                  numLeaves0 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=1  %3d%%",
                                100 *
                                  numLeaves1 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=2  %3d%%",
                                100 *
                                  numLeaves2 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=3  %3d%%",
                                100 *
                                  numLeaves3 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N=4  %3d%%",
                                100 *
                                  numLeaves4 /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "               N>4  %3d%%",
                                100 *
                                  numLeaves4p /
                                  numLeaves);
                            org.sunflow.system.UI.
                              printDetailed(
                                org.sunflow.system.UI.Module.
                                  ACCEL,
                                "  * BVH2 nodes:     %d (%3d%%)",
                                numBVH2,
                                100 *
                                  numBVH2 /
                                  (numNodes +
                                     numLeaves -
                                     2 *
                                     numBVH2));
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
          ("H4sIAAAAAAAAALV6e8zj2HUfZ2Z3ZnZs78zOxuv1dl+2JynWTIei3srYa1Ok" +
           "JJKiqBcpSmzsMZ8iJb7El0hut7UNpHYbwDHateMC8f5lo226iYMgaYIWCbYo" +
           "2iRNUCBF0DZFE6cvNK1jwC7QJKjTpJeUvud833hm7ArgJXUf5/7Ovef87uHl" +
           "feub0OOBD8Gea6VLyw1va0l4e2XVboeppwW3aaY2kvxAU3FLCgIO5N1V3v9z" +
           "1//4O583blyELovQ05LjuKEUmq4TTLTAtWJNZaDrR7kdS7ODELrBrKRYQqLQ" +
           "tBDGDMI7DPSOY01D6BZzAAEBEBAAASkgINhRLdDoXZoT2XjeQnLCYAP9degC" +
           "A132lBxeCL3vpBBP8iV7L2ZUaAAkXM3/z4BSRePEh14+1H2n8z0KfwFG3vjJ" +
           "j9/4+UvQdRG6bjrTHI4CQISgExF6p63ZsuYHmKpqqgg95WiaOtV8U7LMrMAt" +
           "QjcDc+lIYeRrh4OUZ0ae5hd9Ho3cO5VcNz9SQtc/VE83NUs9+Pe4bklLoOsz" +
           "R7ruNOzm+UDBayYA5uuSoh00eWxtOmoIvXS6xaGOt/qgAmh6xdZCwz3s6jFH" +
           "AhnQzd3cWZKzRKahbzpLUPVxNwK9hNBz5wrNx9qTlLW01O6G0LOn6412RaDW" +
           "E8VA5E1C6N2nqxWSwCw9d2qWjs3PN9kPfe41h3QuFphVTbFy/FdBoxdPNZpo" +
           "uuZrjqLtGr7zg8wXpWd+5bMXIQhUfvepyrs6v/TXvv3RH37x7V/f1flLZ9QZ" +
           "yitNCe8qX5Gf/O3n8Vdal3IYVz03MPPJP6F5Yf6jfcmdxAOe98yhxLzw9kHh" +
           "25N/ufjkT2vfuAhdo6DLimtFNrCjpxTX9kxL83uao/lSqKkU9ITmqHhRTkFX" +
           "wDNjOtoud6jrgRZS0GNWkXXZLf6DIdKBiHyIroBn09Hdg2dPCo3iOfEgCHoa" +
           "XNCz4KpAu19xD6EfRQzX1hDPREa+m6seIJoTymBYDSSIHN1yt0jgK4jrLw//" +
           "K66vIZKiaBbSdiNHBTZE5VYaSxZpAk18xUhv51bm/X+Wn+T63dheuACG/vnT" +
           "jm8BnyFdS9X8u8obUbvz7Z+9+5sXDx1hPzIhdAf0fHvf8+2859tFz7fP7flW" +
           "OzItNaeNALpwoej7B3IwuykHE7YGrg9I8Z2vTD9Gf+Kz778EbM3bPgZGO6+K" +
           "nM/N+BFZUAUlKsBiobe/tP3U7G+ULkIXT5JsrgDIupY3H+XUeEiBt04711ly" +
           "r3/mD//4a1983T1ysxOsvff+e1vm3vv+00Ptu4qmAj48Ev/Bl6VfvPsrr9+6" +
           "CD0GKAHQYCgBswUM8+LpPk548Z0DRsx1eRworLu+LVl50QGNXQsN390e5RQ2" +
           "8GTx/BQY46u5Wd8EF7G38+Kelz7t5ekP7Gwmn7RTWhSM++Gp9+V//6//R6UY" +
           "7gNyvn5suZtq4Z1jhJALu164/lNHNsD5mgbq/d6XRn/3C9/8zF8tDADU+MBZ" +
           "Hd7KUxwQAZhCMMw/9uub3/3673/ldy4eGg2UnNTt6n10A5380BEMwCMWcLjc" +
           "WG7xju2qpm5KsqXlxvln138Q/cU/+tyN3fRbIOfAen74uws4yn9vG/rkb378" +
           "T14sxFxQ8nXsaKiOqu3I8ekjyZjvS2mOI/nUv3nh7/2a9GVAs4DaAjPTCraC" +
           "9qrnoG4X+r9SpH/lVFkpT14Kjtv8Sbc6Fm/cVT7/O9961+xbv/rtAu3JgOX4" +
           "FA8k787OqvLk5QSIf89pByelwAD1qm+zP3rDevs7QKIIJALiCIKhDygnOWEQ" +
           "+9qPX/kP/+yfP/OJ374EXexC1yxXUrtS4VvQE8CotcAAbJV4H/nobnK3+Uzf" +
           "KFSF7lF+ZxTPFv9uAoCvnE8r3TzeOPLMZ//P0JI//Z//9J5BKAjljGX2VHsR" +
           "eeunnsNf/UbR/siz89YvJvfSMIjNjtqWf9r+3xfff/lfXISuiNANZR/4zSQr" +
           "yv1FBMFOcBANguDwRPnJwGW3St85ZK7nT7PKsW5Pc8oR/YPnvHb+fO0UjRTj" +
           "/gK4qntXq56mkQtQ8fBq0eR9RXorT/7yjupD6IrnmzFY1ff++xfgdwFcf55f" +
           "ubA8Y7cG38T3gcDLh5GAB1amqyA4Zl0VmNR953fkmzbgongfBiGv3/z6+qf+" +
           "8Gd2Ic7pyTxVWfvsG3/7L25/7o2LxwLLD9wT2x1vswsui9F6V57guXu87369" +
           "FC26//1rr//Tf/D6Z3aobp4MkzpA0Z/5t//3t25/6Q9+44wV+hIIgXeknado" +
           "nnxkN6jVc32ldXImXwRXbT+TtXNmcnTOTOaP7UJhPISeAFAZTYp3iw91Ctb4" +
           "IWG9BK76Hlb9HFjCg8C6FkT2zifOxDV/BFyNPa7GObg+/kC4bNO5D667j4Cr" +
           "ucfVPAeX9mC4pOQ+uPSHxJUTRWuPq3UOLutBcF0F80ho3i5wP43KfgRUP7JH" +
           "9SPnoAoeCBWYxXNRhY+A6s4e1Z1zUGUPhkpKzkX12iNY1of2qD50DqpPPZBl" +
           "HRJE6Sxcn34EXB/e4/rwObg++3C40LNw/a1HwPXqHter5+D6iYfDVT4L1+cf" +
           "AddH9rg+cg6uLz4crspZuH7yEXDtq+7uZ+D68sPhqp6F682HxPUyuLA9Luwc" +
           "XF95EFzvOMLlnQXsqw8J7HlwtffA2ucA+0cPAuwKANaekWda11vfFVQhJLkA" +
           "wrnHy7cbtwuf/vmzu70UQpe9SLZM8Bp0OSh2FUEr3XQk6wDLe1aWcusg2Jtp" +
           "fgDi7lsrq1GIencI3SheGfII9/Zua+4UXvyB8YKg7MkjYYzrLO/8+H/9/G/9" +
           "xAe+DgIsGno8zmNqEIkd65GN8o3Pv/nWF154xxt/8OPFCygYy+lHf8z9ZC71" +
           "V8/ROn/8x3nyS3nyyweqPperOnUjX9EYKQgHxcujph5q2z2mDx2CV1D3e9A2" +
           "vP4LZDWgsIMfMxMJYcsniaANkZYp97YDm0SyWn2cTrUWDmPRYp5ElDPJlosO" +
           "0W0PkrrcrGllNlTVSA8GNa5J9efjzbpTorgW26lPBA/vuLhkbGxLDKnNxuUk" +
           "am2JfRuWQrzsTzbSbCi5uEHP1L7daFaCit5QGlNaTlRm6Au6biNaiy0jmpaN" +
           "sgSbTUXPXq8FN0jcxUAK5oK0SbiBWZbk7sBKW+5A5yopls6ndBaPZHQ5pbW5" +
           "KnZSROyX5/Qiivi6KYWMT6sdIbP7HI2yHiZNqNpwjW74OYst3E2kigPaDIUJ" +
           "a026s9Coj3h7suiHazowFibX5epKaVu2O6PtYFVq4zitpFyC6o0RM7amjBb3" +
           "1p0BnPJzrRZvcKtnkVYwo+ZCv8LiRHdQSibVrdNdmKi4RpNVfeiNnfom6w3K" +
           "ablXQ12hjNsJxeCl7RYuZaFY04atUE061ZRjO6gzJ1C/05iV1AVmd+qcUJ+V" +
           "/ZI/Ra1W0psa9DqkosVaEjucvVSMgdiWOjXZ2PpjFMXCdbnBRZwbsGi/Rk0H" +
           "y4kt1tpZZ82XfHlbmaQZ0cZpmUVrzXTZUNJmuGYYzJjHUSrCDaqnqlxzQ8lz" +
           "1evKk8jAhwSOLfDhurds0SUmE0JUWa+5ucQFE2+gGgra5a1ZK1xnc6Hp6aLf" +
           "GayI1lBml2JTWtKe7pUx3+7Mx9kgY7hMTup9rTZuOS2rP5tvMLQkk91y14ii" +
           "LZlMA36JL2yRwRrlVCityn3LnqwNr7nyyyMu4zHMb8+8NPbRuG9MuQU15M2W" +
           "MqGFUuws5xHdENr1iTVcmctUMflth5yg7mLdqJF1CWvVPQqO+MoW31ikAkDi" +
           "KTZGepMmLdp2X66JSrPCGtsGtYIbszLDu+aSsGhxMk9WW8meGAhHexuTdmco" +
           "1Tb9WipHgLe00WRrtamlA1PLbsaxetxYbcqBlDHbjbThZy4by5G3Yvw1j5RW" +
           "jhUKVpytjX6HFxzXcvtco9VT/AY9hEshg7oYVapheodDeoqBjGSgZ7gKh6Ux" +
           "vPL6G8IaRHV7bRNktTxryVNjw06ba8HnrbbBql57MutE5abWVD2M0TpVrzfR" +
           "kN5ssDF9MEwbP/XnQx1ZVq3pAJtKG8zXutOyVWtVWVOfZ6160sbba5KorTtZ" +
           "ZWsi8TKmGnoPRvjSahL2Y3bE83PeJ4Ke3W1mEgkMR1j7szY8FPqKigYpgsT1" +
           "VGbxBj2w5it/7vWmVWqkSvicWBubaNuXbJJBeCxtZcwKr5bVSVzpEeuxudA9" +
           "D6lK0VYMPZTlHZaMrYXnzMNEUutzQxwa47gdLrcrZorVxHU0dLXxwkq2jMVm" +
           "vG2RPE0tWLM0NucjsdrGhzaJiwGRJi2TqcyyWakhA7kauaBh2k0EzBcmISM6" +
           "RsbXgik57xIxmJs5CqeyKjS0Jtqd2iaBroNtunZdT5TnYhtlrJEu1v2o3m0M" +
           "x2tTtCOaIsVMnVi2O150xXHQ6HY2rXF3s1g1V1W0tKp1qQUTilUFozzTgxV9" +
           "TmyzTbkyTxSLF1ramO5aHbY/jifDlcbVNizirMZyN5G2sIrAWQkZqyU6o6ud" +
           "dSkaJeLWXdYzRG0YbAkejUjNbpHcKNhqUsRa5Fib2J3NtoRTG1Y3bG3LDqc4" +
           "3HenKe86LMOGfc70aim7QU1kM27WR2oSJghTaWqYYMnLaR3uiou0xSJuqPe2" +
           "SUBv3cokQzJJ6XHJiIqqtV5FR4YVWM2UaJ5M66nbiUzDVxR+S/ZTbVKPklUY" +
           "Rqy57kaxojWYrBIvIzJ0hnp74daS8bi8UINeMI7sziBpotWwUak4SIVaV1xn" +
           "jdCoHcseb0Rub7xJSovOyOPNNukyHVRmyTZDSzMqnvrdlj7pNmbzzIkb5Jpz" +
           "E2Tql2pM5pSDYFQdTUayOavETJY1SwuY63A9dBgtUrPDNeepMkDoTak27XU6" +
           "ejkLNUdHlG59QlKACllG4PXauCeU++5qg80UJDPiGhLBjMLY/SAOm62aVZtu" +
           "Jlo0XcmVRAmQ+aqW1tKQrUppVunWU2E1mS9nrKU6C92kEW/FM5bTGjP6skGJ" +
           "cr01zawy0ZGN5WThoZbMjY2pvWgRdpezUKEJN2OnV5Fas3XfrJfM2WYd0+qE" +
           "1oXymB8SAgqbJCa65dmmya2JiB6gle5suiDTNmC3atvpeuVaWLYJpTwK4WFM" +
           "kmlSbehutWGlZM8e+DUpI22tSnl+a6q25tkmrIZIq2VUGkaTj+RqbUitajAu" +
           "t7T6SNIQnNATYeFQWkw5ArVqNBtIwBF8yxP0warmcCZe6VTE7WrbDdSVEes1" +
           "Hg5HbmNE6xPe6rJ1m2soXnVTn9gKOSuPs5lbUzxrQ1dblUZ55kyNlRDTieK5" +
           "iOE7HdgcLtYJYpCSk8TKYh6OlgFXVZ2lXN52EZOYudzWqsjDpjHXsmBub1Jq" +
           "PrBow8b8wNksYyGc9oiBR9HadsGu22ngp7XuiJ3N6vJ86aeOh5MDQjW6VV1Q" +
           "I5gjOBFFuuvqNhqbhEuH24HTqKC+Wo6bfULCZzYalGrJDK11sv62X2XmuJro" +
           "W6vZcWLEXFbMZJxM5i0BLRucks3hvtGpqnW3BLdhiqy3EKWpj2q0uyB0MM6d" +
           "1ghP5EpJHFbogdExE65mcHx/09CUiTaWTCKbih02DQd4pC5aLZ1rV2pwM8CM" +
           "peRrAiJExtSqN4MKErfpRhNrxoCZqlNj0vCrWkLRVLwaiI1aaeGGQ0kO5WZV" +
           "sOCUcOi0XXcG0sDXiCFKaVa5tA38UmTKTHnerMp25BvGiJj2xlFGkYAxllGy" +
           "EQl4SEy3HUKoO/PmxFkK5VW9PhgQiVadrxYVNnMXCqlwgxQP0rnL9rF+W4ya" +
           "097MqFql9ipl5K7NYB62cXmTiNq2F6xoryOY/XFYamEbk5GFHoPVMcmd4USE" +
           "dTdC2MXdYVXF1LEs9zqVdgdTCYqXEgode8KWQofbrSv0B3ObYoSEwlqyON50" +
           "wLpNZW1MFcdjeJshfDsmt+TYkyXXG3exxtbtApJhxz2yjlW78GI7wYRyMmFA" +
           "WZyU+iy1lJe8L4777cqq2Waslm1aSx6LOYWX2lhF663hqYXOieEm6fBtVV6G" +
           "MrkkUIDZHatJtBkN+2O9ouF9PAooIcQpoo4clLHKfIlsiLydNA7l3phARXzF" +
           "U71qBR05XZeowthmWd7oyxCLZwDMeCmvdL6tCEvHWNso7Wx9Rur64zoGe2yh" +
           "64pKym7b7wZENeP6GVft2agn870FWSoXira4eMnMUKkSTrhKKWr3tDJMVZfm" +
           "pklPAkDmJhM3ML8qG+RokiWklVZd3yoZWx2shyHhDTYtlUu2TXWV1ppqt8bP" +
           "QyJeop2yq8PZyrSGVOKoDVsj64uG0JhXkjDLvFoTbcn8sFYbD+HEjZVtnUSa" +
           "MOY6XtRsy20CFrrLCqwHjtVF6jWDZFZsk3aoEcyt6iDYqCuSX5tHJjIUsQbe" +
           "YWQjbXJ4RQv8rO/hyUoKa7hONeZxXcaCpqChOAo3KuOm6cc2uwD0se4FlKTE" +
           "clVsakkko2WMFd10bYBFzY5KU7tBinQ7S6VqyhOR0S85JIqmMPDAwWgst1fW" +
           "1PDniLAZtm1NlqV+uSrGzpQQOljcpDVO1oQMxgddXsC1SpNtocSIbFsc3Rlk" +
           "24bcQ8sE2xyPwSItSuywO2QmjfYCbuGKQYMowq4gNjemkyHMZymvzksrvVyu" +
           "+CHZqNFLyySsRXm87iGKROtYh1rQdiWEWY3KkraOECV2PV7QGaz0PXrVTStz" +
           "LFZwvMSlmyo9WVRshOaScuDTSUNvGtKoHjtyUt5QWd0ebHx3lFhZXFuINA/W" +
           "bq3BV+loQBJ0dzMxNv1lebhejWCT8MjJ0t8IYO1E2PFYRsgeh/JDTPE6yWiE" +
           "AMqtm/gi5bF2D2aNJQjS50mALpqkm9KIwJerQVmBVVtSGEdUzLk8FKvNZIp4" +
           "Sra2qHrD02AOYESkYISY7lrvdhdCMI3jcnVqrsA7Il6h5XWz1Q+2bDdd1IQK" +
           "izYlpSzzM9kpjWYLTHUSeGNHwFnr1FLTByBWJ+GZyCGrDHEmI8ZxYlQZOT4/" +
           "YUTOpKYUPCx3k/padEuDLsbJnapAzmiCgMcoMUVYYpxGETevlLRKjeeUqYH6" +
           "kyVs1Gtwq14ZNhsBPN/O4oSPls1NR4zXdKPmGvJkOGuXspGpKotWh6d9OKqR" +
           "Qpah2qTR5PvMWrW7RqXcRavtWRUHMeQgIIy63bYD0ktVHoT4U20w3urLFrsC" +
           "g1EelqbaZBgRCMKvUSPsNcwMOKCob7M4m7YCGB4O1UpPkOFpBGd6SRdxUlf7" +
           "zRV4S/9w/vr+rx5uW+GpYgfl8KTTymrkBf/kIXYOkrM7vFhsGhUdHn1wL761" +
           "5ocJThyaObYTdewrLJR/CHvhvHNNxUewr3z6jTfV4VfRi/uv1/0Qurw/bnYk" +
           "5zEg5oPnf+0bFGe6jj6p/tqn/+dz3KvGJx7ifMhLp0CeFvkPB2/9Ru+HlL9z" +
           "Ebp0+IH1ntNmJxvdOflZ9ZqvhZHvcCc+rr5w8hzDc+Di98PKn97gO5rPeyZq" +
           "N3R4kX32oYD/dJ+y/5In/zGE3hF5qhRqlOPsB//0flTsmuqRQf3ed9uKOt5P" +
           "kfG7J7V9L7gWe20X31dtv3Wfsv+VJ98IoWs7bQ+2Qf/bkWJ/9L0q9gq4PrZX" +
           "7GPfs2IXj3yx2Kulilp/dh8V/zxP/uRQRUaT9FMq/un3Y+5e26v42vdz7i5c" +
           "vU/ZtTy5BBTzfNMJi+NmJxW78NjDKJYASUcH1w42nEsPe/gNkNOz95yw3Z0K" +
           "VX72zetX3/Mm/++KM1+HJzefYKCremRZx09dHHu+7PmabhYj9cTuDIZXqP90" +
           "CD1zNrgQery45zpcuLmr/UwI3ThdGzhxfjte7b3A8Y9VC6Er+6fjlZ4PoUug" +
           "Uv74gnfGzvzuu3Fy4ST3H5rbze82K8eWiw+c4PnigPMBJ0e7I853la+9SbOv" +
           "fbv+1d2JNMWSsiyXcpWBruwOxx3y+vvOlXYg6zL5ynee/LknfvBgAXpyB/jI" +
           "ho9he+nsc2Ad2wuLk1vZL7/nFz7099/8/eJDwf8DT20auXkuAAA=");
    }
    private void buildHierarchy(org.sunflow.util.IntArray tempTree,
                                int[] indices,
                                org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats) {
        tempTree.
          add(
            3 <<
              30);
        tempTree.
          add(
            0);
        tempTree.
          add(
            0);
        if (objects.
              length ==
              0)
            return;
        float[] gridBox =
          { bounds.
              getMinimum(
                ).
              x,
        bounds.
          getMaximum(
            ).
          x,
        bounds.
          getMinimum(
            ).
          y,
        bounds.
          getMaximum(
            ).
          y,
        bounds.
          getMinimum(
            ).
          z,
        bounds.
          getMaximum(
            ).
          z };
        float[] nodeBox =
          { bounds.
              getMinimum(
                ).
              x,
        bounds.
          getMaximum(
            ).
          x,
        bounds.
          getMinimum(
            ).
          y,
        bounds.
          getMaximum(
            ).
          y,
        bounds.
          getMinimum(
            ).
          z,
        bounds.
          getMaximum(
            ).
          z };
        subdivide(
          0,
          objects.
            length -
            1,
          tempTree,
          indices,
          gridBox,
          nodeBox,
          0,
          1,
          stats);
    }
    private void createNode(org.sunflow.util.IntArray tempTree,
                            int nodeIndex,
                            int left,
                            int right) { tempTree.
                                           set(
                                             nodeIndex +
                                               0,
                                             3 <<
                                               30 |
                                               left);
                                         tempTree.
                                           set(
                                             nodeIndex +
                                               1,
                                             right -
                                               left +
                                               1);
    }
    private void subdivide(int left, int right,
                           org.sunflow.util.IntArray tempTree,
                           int[] indices,
                           float[] gridBox,
                           float[] nodeBox,
                           int nodeIndex,
                           int depth,
                           org.sunflow.core.accel.BoundingIntervalHierarchy.BuildStats stats) {
        if (right -
              left +
              1 <=
              maxPrims ||
              depth >=
              64) {
            stats.
              updateLeaf(
                depth,
                right -
                  left +
                  1);
            createNode(
              tempTree,
              nodeIndex,
              left,
              right);
            return;
        }
        int axis =
          -1;
        int prevAxis;
        int rightOrig;
        float clipL =
          java.lang.Float.
            NaN;
        float clipR =
          java.lang.Float.
            NaN;
        float prevClip =
          java.lang.Float.
            NaN;
        float split =
          java.lang.Float.
            NaN;
        float prevSplit;
        boolean wasLeft =
          true;
        while (true) {
            prevAxis =
              axis;
            prevSplit =
              split;
            float[] d =
              { gridBox[1] -
              gridBox[0],
            gridBox[3] -
              gridBox[2],
            gridBox[5] -
              gridBox[4] };
            if (d[0] <
                  0 ||
                  d[1] <
                  0 ||
                  d[2] <
                  0)
                throw new java.lang.IllegalStateException(
                  "negative node extents");
            for (int i =
                   0;
                 i <
                   3;
                 i++) {
                if (nodeBox[2 *
                              i +
                              1] <
                      gridBox[2 *
                                i] ||
                      nodeBox[2 *
                                i] >
                      gridBox[2 *
                                i +
                                1]) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          ACCEL,
                        ("Reached tree area in error - discarding node with: %d object" +
                         "s"),
                        right -
                          left +
                          1);
                    throw new java.lang.IllegalStateException(
                      "invalid node overlap");
                }
            }
            if (d[0] >
                  d[1] &&
                  d[0] >
                  d[2])
                axis =
                  0;
            else
                if (d[1] >
                      d[2])
                    axis =
                      1;
                else
                    axis =
                      2;
            split =
              0.5F *
                (gridBox[2 *
                           axis] +
                   gridBox[2 *
                             axis +
                             1]);
            clipL =
              java.lang.Float.
                NEGATIVE_INFINITY;
            clipR =
              java.lang.Float.
                POSITIVE_INFINITY;
            rightOrig =
              right;
            float nodeL =
              java.lang.Float.
                POSITIVE_INFINITY;
            float nodeR =
              java.lang.Float.
                NEGATIVE_INFINITY;
            for (int i =
                   left;
                 i <=
                   right;
                 ) {
                int obj =
                  indices[i];
                float minb =
                  primitives.
                  getPrimitiveBound(
                    obj,
                    2 *
                      axis +
                      0);
                float maxb =
                  primitives.
                  getPrimitiveBound(
                    obj,
                    2 *
                      axis +
                      1);
                float center =
                  (minb +
                     maxb) *
                  0.5F;
                if (center <=
                      split) {
                    i++;
                    if (clipL <
                          maxb)
                        clipL =
                          maxb;
                }
                else {
                    int t =
                      indices[i];
                    indices[i] =
                      indices[right];
                    indices[right] =
                      t;
                    right--;
                    if (clipR >
                          minb)
                        clipR =
                          minb;
                }
                if (nodeL >
                      minb)
                    nodeL =
                      minb;
                if (nodeR <
                      maxb)
                    nodeR =
                      maxb;
            }
            if (nodeL >
                  nodeBox[2 *
                            axis +
                            0] &&
                  nodeR <
                  nodeBox[2 *
                            axis +
                            1]) {
                float nodeBoxW =
                  nodeBox[2 *
                            axis +
                            1] -
                  nodeBox[2 *
                            axis +
                            0];
                float nodeNewW =
                  nodeR -
                  nodeL;
                if (1.3F *
                      nodeNewW <
                      nodeBoxW) {
                    stats.
                      updateBVH2(
                        );
                    int nextIndex =
                      tempTree.
                      getSize(
                        );
                    tempTree.
                      add(
                        0);
                    tempTree.
                      add(
                        0);
                    tempTree.
                      add(
                        0);
                    stats.
                      updateInner(
                        );
                    tempTree.
                      set(
                        nodeIndex +
                          0,
                        axis <<
                          30 |
                          1 <<
                          29 |
                          nextIndex);
                    tempTree.
                      set(
                        nodeIndex +
                          1,
                        java.lang.Float.
                          floatToRawIntBits(
                            nodeL));
                    tempTree.
                      set(
                        nodeIndex +
                          2,
                        java.lang.Float.
                          floatToRawIntBits(
                            nodeR));
                    nodeBox[2 *
                              axis +
                              0] =
                      nodeL;
                    nodeBox[2 *
                              axis +
                              1] =
                      nodeR;
                    subdivide(
                      left,
                      rightOrig,
                      tempTree,
                      indices,
                      gridBox,
                      nodeBox,
                      nextIndex,
                      depth +
                        1,
                      stats);
                    return;
                }
            }
            if (right ==
                  rightOrig) {
                if (clipL <=
                      split) {
                    gridBox[2 *
                              axis +
                              1] =
                      split;
                    prevClip =
                      clipL;
                    wasLeft =
                      true;
                    continue;
                }
                if (prevAxis ==
                      axis &&
                      prevSplit ==
                      split) {
                    stats.
                      updateLeaf(
                        depth,
                        right -
                          left +
                          1);
                    createNode(
                      tempTree,
                      nodeIndex,
                      left,
                      right);
                    return;
                }
                gridBox[2 *
                          axis +
                          1] =
                  split;
                prevClip =
                  java.lang.Float.
                    NaN;
            }
            else
                if (left >
                      right) {
                    right =
                      rightOrig;
                    if (clipR >=
                          split) {
                        gridBox[2 *
                                  axis +
                                  0] =
                          split;
                        prevClip =
                          clipR;
                        wasLeft =
                          false;
                        continue;
                    }
                    if (prevAxis ==
                          axis &&
                          prevSplit ==
                          split) {
                        stats.
                          updateLeaf(
                            depth,
                            right -
                              left +
                              1);
                        createNode(
                          tempTree,
                          nodeIndex,
                          left,
                          right);
                        return;
                    }
                    gridBox[2 *
                              axis +
                              0] =
                      split;
                    prevClip =
                      java.lang.Float.
                        NaN;
                }
                else {
                    if (prevAxis !=
                          -1 &&
                          !java.lang.Float.
                          isNaN(
                            prevClip)) {
                        int nextIndex =
                          tempTree.
                          getSize(
                            );
                        tempTree.
                          add(
                            0);
                        tempTree.
                          add(
                            0);
                        tempTree.
                          add(
                            0);
                        if (wasLeft) {
                            stats.
                              updateInner(
                                );
                            tempTree.
                              set(
                                nodeIndex +
                                  0,
                                prevAxis <<
                                  30 |
                                  nextIndex);
                            tempTree.
                              set(
                                nodeIndex +
                                  1,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    prevClip));
                            tempTree.
                              set(
                                nodeIndex +
                                  2,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    java.lang.Float.
                                      POSITIVE_INFINITY));
                        }
                        else {
                            stats.
                              updateInner(
                                );
                            tempTree.
                              set(
                                nodeIndex +
                                  0,
                                prevAxis <<
                                  30 |
                                  nextIndex -
                                  3);
                            tempTree.
                              set(
                                nodeIndex +
                                  1,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    java.lang.Float.
                                      NEGATIVE_INFINITY));
                            tempTree.
                              set(
                                nodeIndex +
                                  2,
                                java.lang.Float.
                                  floatToRawIntBits(
                                    prevClip));
                        }
                        depth++;
                        stats.
                          updateLeaf(
                            depth,
                            0);
                        nodeIndex =
                          nextIndex;
                    }
                    break;
                }
        }
        int nextIndex =
          tempTree.
          getSize(
            );
        int nl =
          right -
          left +
          1;
        int nr =
          rightOrig -
          (right +
             1) +
          1;
        if (nl >
              0) {
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
        }
        else
            nextIndex -=
              3;
        if (nr >
              0) {
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
            tempTree.
              add(
                0);
        }
        stats.
          updateInner(
            );
        tempTree.
          set(
            nodeIndex +
              0,
            axis <<
              30 |
              nextIndex);
        tempTree.
          set(
            nodeIndex +
              1,
            java.lang.Float.
              floatToRawIntBits(
                clipL));
        tempTree.
          set(
            nodeIndex +
              2,
            java.lang.Float.
              floatToRawIntBits(
                clipR));
        float[] gridBoxL =
          new float[6];
        float[] gridBoxR =
          new float[6];
        float[] nodeBoxL =
          new float[6];
        float[] nodeBoxR =
          new float[6];
        for (int i =
               0;
             i <
               6;
             i++) {
            gridBoxL[i] =
              (gridBoxR[i] =
                 gridBox[i]);
            nodeBoxL[i] =
              (nodeBoxR[i] =
                 nodeBox[i]);
        }
        gridBoxL[2 *
                   axis +
                   1] =
          (gridBoxR[2 *
                      axis] =
             split);
        nodeBoxL[2 *
                   axis +
                   1] =
          clipL;
        nodeBoxR[2 *
                   axis +
                   0] =
          clipR;
        gridBox =
          (nodeBox =
             null);
        if (nl >
              0)
            subdivide(
              left,
              right,
              tempTree,
              indices,
              gridBoxL,
              nodeBoxL,
              nextIndex,
              depth +
                1,
              stats);
        else
            stats.
              updateLeaf(
                depth +
                  1,
                0);
        if (nr >
              0)
            subdivide(
              right +
                1,
              rightOrig,
              tempTree,
              indices,
              gridBoxR,
              nodeBoxR,
              nextIndex +
                3,
              depth +
                1,
              stats);
        else
            stats.
              updateLeaf(
                depth +
                  1,
                0);
    }
    public void intersect(org.sunflow.core.Ray r,
                          org.sunflow.core.IntersectionState state) {
        float intervalMin =
          r.
          getMin(
            );
        float intervalMax =
          r.
          getMax(
            );
        float orgX =
          r.
            ox;
        float dirX =
          r.
            dx;
        float invDirX =
          1 /
          dirX;
        float t1;
        float t2;
        t1 =
          (bounds.
             getMinimum(
               ).
             x -
             orgX) *
            invDirX;
        t2 =
          (bounds.
             getMaximum(
               ).
             x -
             orgX) *
            invDirX;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin)
                intervalMin =
                  t1;
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
        }
        else {
            if (t2 >
                  intervalMin)
                intervalMin =
                  t2;
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgY =
          r.
            oy;
        float dirY =
          r.
            dy;
        float invDirY =
          1 /
          dirY;
        t1 =
          (bounds.
             getMinimum(
               ).
             y -
             orgY) *
            invDirY;
        t2 =
          (bounds.
             getMaximum(
               ).
             y -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin)
                intervalMin =
                  t1;
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
        }
        else {
            if (t2 >
                  intervalMin)
                intervalMin =
                  t2;
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
        }
        if (intervalMin >
              intervalMax)
            return;
        float orgZ =
          r.
            oz;
        float dirZ =
          r.
            dz;
        float invDirZ =
          1 /
          dirZ;
        t1 =
          (bounds.
             getMinimum(
               ).
             z -
             orgZ) *
            invDirZ;
        t2 =
          (bounds.
             getMaximum(
               ).
             z -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin)
                intervalMin =
                  t1;
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
        }
        else {
            if (t2 >
                  intervalMin)
                intervalMin =
                  t2;
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
        }
        if (intervalMin >
              intervalMax)
            return;
        int offsetXFront =
          java.lang.Float.
          floatToRawIntBits(
            dirX) >>>
          31;
        int offsetYFront =
          java.lang.Float.
          floatToRawIntBits(
            dirY) >>>
          31;
        int offsetZFront =
          java.lang.Float.
          floatToRawIntBits(
            dirZ) >>>
          31;
        int offsetXBack =
          offsetXFront ^
          1;
        int offsetYBack =
          offsetYFront ^
          1;
        int offsetZBack =
          offsetZFront ^
          1;
        int offsetXFront3 =
          offsetXFront *
          3;
        int offsetYFront3 =
          offsetYFront *
          3;
        int offsetZFront3 =
          offsetZFront *
          3;
        int offsetXBack3 =
          offsetXBack *
          3;
        int offsetYBack3 =
          offsetYBack *
          3;
        int offsetZBack3 =
          offsetZBack *
          3;
        offsetXFront++;
        offsetYFront++;
        offsetZFront++;
        offsetXBack++;
        offsetYBack++;
        offsetZBack++;
        org.sunflow.core.IntersectionState.StackNode[] stack =
          state.
          getStack(
            );
        int stackTop =
          state.
          getStackTop(
            );
        int stackPos =
          stackTop;
        int node =
          0;
        while (true) {
            pushloop: while (true) {
                int tn =
                  tree[node];
                int axis =
                  tn &
                  7 <<
                  29;
                int offset =
                  tn &
                  ~(7 <<
                      29);
                switch (axis) {
                    case 0:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXFront]) -
                                 orgX) *
                              invDirX;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXBack]) -
                                 orgX) *
                              invDirX;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetXBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetXFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 1 <<
                      30:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYFront]) -
                                 orgY) *
                              invDirY;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYBack]) -
                                 orgY) *
                              invDirY;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetYBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetYFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 2 <<
                      30:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZFront]) -
                                 orgZ) *
                              invDirZ;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZBack]) -
                                 orgZ) *
                              invDirZ;
                            if (tf <
                                  intervalMin &&
                                  tb >
                                  intervalMax)
                                break pushloop;
                            int back =
                              offset +
                              offsetZBack3;
                            node =
                              back;
                            if (tf <
                                  intervalMin) {
                                intervalMin =
                                  tb >=
                                    intervalMin
                                    ? tb
                                    : intervalMin;
                                continue;
                            }
                            node =
                              offset +
                                offsetZFront3;
                            if (tb >
                                  intervalMax) {
                                intervalMax =
                                  tf <=
                                    intervalMax
                                    ? tf
                                    : intervalMax;
                                continue;
                            }
                            stack[stackPos].
                              node =
                              back;
                            stack[stackPos].
                              near =
                              tb >=
                                intervalMin
                                ? tb
                                : intervalMin;
                            stack[stackPos].
                              far =
                              intervalMax;
                            stackPos++;
                            intervalMax =
                              tf <=
                                intervalMax
                                ? tf
                                : intervalMax;
                            continue;
                        }
                    case 3 <<
                      30:
                        {
                            int n =
                              tree[node +
                                     1];
                            while (n >
                                     0) {
                                primitives.
                                  intersectPrimitive(
                                    r,
                                    objects[offset],
                                    state);
                                n--;
                                offset++;
                            }
                            break pushloop;
                        }
                    case 1 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXFront]) -
                                 orgX) *
                              invDirX;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetXBack]) -
                                 orgX) *
                              invDirX;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    case 3 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYFront]) -
                                 orgY) *
                              invDirY;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetYBack]) -
                                 orgY) *
                              invDirY;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    case 5 <<
                      29:
                        {
                            float tf =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZFront]) -
                                 orgZ) *
                              invDirZ;
                            float tb =
                              (java.lang.Float.
                                 intBitsToFloat(
                                   tree[node +
                                          offsetZBack]) -
                                 orgZ) *
                              invDirZ;
                            node =
                              offset;
                            intervalMin =
                              tf >=
                                intervalMin
                                ? tf
                                : intervalMin;
                            intervalMax =
                              tb <=
                                intervalMax
                                ? tb
                                : intervalMax;
                            if (intervalMin >
                                  intervalMax)
                                break pushloop;
                            continue;
                        }
                    default:
                        return;
                }
            }
            do  {
                if (stackPos ==
                      stackTop)
                    return;
                stackPos--;
                intervalMin =
                  stack[stackPos].
                    near;
                if (r.
                      getMax(
                        ) <
                      intervalMin)
                    continue;
                node =
                  stack[stackPos].
                    node;
                intervalMax =
                  stack[stackPos].
                    far;
                break;
            }while(true); 
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaC5AUxRnu3Xu/H3A8DjjgOEiBuuszxjpjPE6QI3twdYek" +
       "PAjH7Gzv7XCzM8NM790ehqhUWZBUhRBFJSm9JAYjsVCIFctYiQbLErU0VkmM" +
       "j1hCEh8xMVQkD7Wiifn/7pmdxz6os8JVTe9MT//d/6u///977vBpUmGZpINq" +
       "LMImDWpFVmlsQDItmuhVJcvaAH0j8p1l0j+2vLvuijCpHCaNKcnqlyWLrlao" +
       "mrCGyQJFs5ikydRaR2kCKQZMalFzXGKKrg2TNsXqSxuqIiusX09QHLBRMmOk" +
       "RWLMVOIZRvvsCRhZEANOopyTaE/wdXeM1Mu6MekOn+MZ3ut5gyPT7loWI82x" +
       "bdK4FM0wRY3GFIt1Z01ynqGrk6OqziI0yyLb1MtsFayNXZangs6jTR98vC/V" +
       "zFUwQ9I0nXHxrEFq6eo4TcRIk9u7SqVpazv5OimLkTrPYEa6Ys6iUVg0Cos6" +
       "0rqjgPsGqmXSvToXhzkzVRoyMsTIYv8khmRKaXuaAc4zzFDNbNk5MUi7KCet" +
       "kDJPxNvPi+6/c0vzQ2WkaZg0KdoQsiMDEwwWGQaF0nScmlZPIkETw6RFA2MP" +
       "UVORVGWHbelWSxnVJJYB8ztqwc6MQU2+pqsrsCPIZmZkpps58ZLcoeyniqQq" +
       "jYKss1xZhYSrsR8ErFWAMTMpgd/ZJOVjipZgZGGQIidj15dhAJBWpSlL6bml" +
       "yjUJOkircBFV0kajQ+B62igMrdDBAU1G2otOiro2JHlMGqUj6JGBcQPiFYyq" +
       "4YpAEkbagsP4TGCl9oCVPPY5ve7KvTdoa7QwCQHPCSqryH8dEHUEiAZpkpoU" +
       "9oEgrF8Ru0Oa9dieMCEwuC0wWIx55Gtnrj6/49gzYsy8AmPWx7dRmY3IB+ON" +
       "L87vXX5FGbJRbeiWgsb3Sc532YD9pjtrAMLMys2ILyPOy2ODx6+/6X76XpjU" +
       "9pFKWVczafCjFllPG4pKzWupRk2J0UQfqaFaope/7yNVcB9TNCp61yeTFmV9" +
       "pFzlXZU6fwYVJWEKVFEt3CtaUnfuDYml+H3WIIRUwUWuhauRiD/+y8jmaEpP" +
       "06ihRAdMHUW3ogA2cVBrKmpltKSqT0QtU47q5mjuWdZNGpVkmarRlXpGS4AP" +
       "9aGXjkvqGgUkMeXUZAS9zDjH82dRvhkToRCofn5w46uwZ9boaoKaI/L+zMpV" +
       "Zx4ceU44FW4EWzOMXAgrR+yVI7hyhK8cKboyCYX4gjORA2FnsNIY7HcA3Prl" +
       "Q19du3VPZxk4mDFRDirGoZ2+wNPrgoKD5CPykdaGHYtPXvRkmJTHSKsks4yk" +
       "YhzpMUcBoeQxexPXxyEkuZFhkScyYEgzdZkmAJiKRQh7lmp9nJrYz8hMzwxO" +
       "3MIdGi0eNQryT44dmLh5440XhknYHwxwyQrAMSQfQAjPQXVXEAQKzdu0+90P" +
       "jtyxU3fhwBddnKCYR4kydAZdIqieEXnFIunhkcd2dnG11wBcMwm2FyBhR3AN" +
       "H9p0O8iNslSDwEndTEsqvnJ0XMtSpj7h9nBfbeH3M8Et6nD7dcHVZu9H/otv" +
       "ZxnYzha+jX4WkIJHhi8OGXe/+sKfL+HqdoJIkyf6D1HW7QEunKyVQ1SL67Yb" +
       "TEph3BsHBm67/fTuTdxnYcSSQgt2YdsLgAUmBDXf8sz2106dPPhS2PVzBpE7" +
       "E4cEKJsTEvtJbQkhYbVlLj8AfCogBHpN13Ua+KeSVKS4SnFjfdK09KKH/7q3" +
       "WfiBCj2OG51/9gnc/rkryU3Pbfmwg08TkjHwujpzhwk0n+HO3GOa0iTykb35" +
       "xILvPi3dDXEBsNhSdlAOr4TrgHCjXcblv5C3lwbeXY7NUsvr/P795UmQRuR9" +
       "L73fsPH9x89wbv0ZltfW/ZLRLdwLm2VZmH52EJzWSFYKxl16bN3mZvXYxzDj" +
       "MMwISGdZ603AyKzPM+zRFVW/e+LJWVtfLCPh1aRW1aXEaolvMlID3k2tFMBr" +
       "1vjS1cK4E9XQNHNRSZ7weR2o4IWFTbcqbTCu7B0/n/2zK++bOsm9zBBzzOP0" +
       "mM7P96Eqz9PdjX3/by7/7X3fuWNCRPrlxdEsQDfn3+vV+K4/fpSnco5jBbKQ" +
       "AP1w9PBd7b1XvcfpXUBB6q5sfpQCUHZpL74//a9wZ+VTYVI1TJplOy/eKKkZ" +
       "3KbDkAtaTrIMubPvvT+vE0lMdw4w5wfBzLNsEMrc6Aj3OBrvGwLoVY8mnA1X" +
       "k72xm4LoFSL8po+TfI63K7C5wAGLKsNUoHaiAbSoKzEpA4YAsvyVHAatoUzc" +
       "YnyLijRvc93xX1k/euchYfzOAoMDueOh+6rl19PH3xIEcwsQiHFth6Lf2vjK" +
       "tuc57FZjLN7gaMgTaSFmezC/OScgT7la4JpnCzhP5GBDnzVHAhWmAd7HaXQD" +
       "VCjaqEr7YVM6qde5mBaxZWnxzeSxwdSPl7xw49SSP3CkqVYscDnQS4Hc30Pz" +
       "/uFT751oWPAgj8blqF5btf6iKb8m8pU6XOtN2GzIWoXNP+BIKNa9eGCrvKdr" +
       "gJsf6QaFyT6FvxBc/8ULTYUdwmStvXbuviiXvCNAlUSawKLRna2nxu569wHh" +
       "c0FYCQyme/Z/89PI3v0i/IkKcEleEealEVWg8EBsNiN3i0utwilW/+nIzl8c" +
       "2rlbcNXqr2dWQbn+wMv/eT5y4PfPFkilyxS7ikecD+Wy35l+AwiBrvlG0y/3" +
       "tZatBlP3keqMpmzP0L6EH36qrEzcs7/cytKFJFs0NAwjoRVOkPAygM+9whts" +
       "UBorDEphvI0wgENFk1Q+/WZIalSqjYpKSsLmes8SYUHHn+cwO19ABIaCVtco" +
       "ph7OO1EtKHokd5gAL/OZNckCX1Tr537thog3Gm9989Gu0ZXTKROwr+MshQA+" +
       "LwSDryjuvkFWnt71l/YNV6W2TiPjXxhwv+CUP+k//Oy1y+Rbw/y8QsSuvHMO" +
       "P1G332VqTcoypuZ3kiXC+tx6wvTYnMcNXCJX21ni3Y3Y7ABfkdHQwi9KDN+V" +
       "n/5gR4/hyZRsF8DHlJ38Y/sFbNYKT+kummr1+kNzu/Pa+S0Qmne7qojlx+Bi" +
       "1BC4dZ5dcJKhAJ97psnnUjsgOoGxEJ97S/JZjJqR2lwYs5xN2JFX6+cAMGZX" +
       "FB5hvj1NYRbC1Wqz01pEmDtLClOMGlAojscROUHmewVJSyyVO65YqQd958A0" +
       "xZgL1wybkRlFxPhBSTGKUTNSnZayqHJOsynA6A9LMJr17NvcgvyvkgTOtDwL" +
       "egqGkKO6ZXk+0IPnPRjDAbyG+DFCxqQYLRcUO6XkkfLgrv1TifX3XuQkDVBM" +
       "1jDduECl41T1lSp4P+6v/KO2oh2FF6j8Cwicq6eLkQYgyAMpt/FZHy6BUY9g" +
       "cxQgLZ5R7FxrC4dIofs4ZN/jupJw7fXTszlW6fpPAGBAOdwDh+DaZ0u47yzK" +
       "KeB+xUgDspdxRsocv5jr9Que7fRpoqbgQOcM657ucWHXSlQnfmWwOO9PlTDB" +
       "c9gcY6SRmyA3BfY+6ur9iXOl90G47rGVd8/09V6MNCBwOWekHB+P52BANHyR" +
       "l0so6FVsXgRsl00KOfc6O3PxKOfEuVLO9+E6ZEt4aPrKKUYaELaGM1Lj18tx" +
       "1wMH/MUkImy7PXO7M/N1fOaNQrqvYPO2uB/2bOfA1q4Af5byknd8TJXIqN92" +
       "4sHpUhk1NppIp7HhHyh4Kv1OfiqNj9uxsQovOy6W5dTY3FDCWf5Z4t0H2Pwd" +
       "m5sEJyXGfvRZkre3/CZ8hne+WWKVT7A5ybDKiSeUcSXPs0+dA8/msegKYDwj" +
       "5hS/JTw7PxYVJQ3IGqiVZubh6KA06bzszHvJYdUSB4SIpRQZC1UV12eoAZsw" +
       "6FNxSP36DJX9P/SZhcBRFPrxiHNO3vdo8Q1VfnCqqXr21HWviLMO5ztnPdRk" +
       "yYyqeg/hPPeVhkmTCjdKvTiSM7iwbYzMKhyYYGvzXxQgNFOMBg03B0dDdMcf" +
       "77B5jNR5hjGsx/mdd1AHlP0wCG8XGo79mt1CWBxFZkOehMjWJnfqtrMZIUfi" +
       "/S6BtSn/dwCnjsyIfwgYkY9MrV13w5nP3yu+i8iqtGMHzlIXI1XiEw2fFGvR" +
       "xUVnc+aqXLP848ajNUudBK9FMOzuiHme7dsDO8BAg7cHPhpYXblvB68dvPLx" +
       "X++pPBEmoU0kJDEyY1P+oW3WyEDmuSmWf2gCdTv/mtG9/HuTV52f/Nvr/Fic" +
       "iGOD+cXHj8jDt73ad3Tsw6v59+cKyF1plp8mXzOpDVJ53PSdwDSiL0r4jwFc" +
       "D7b6GnK9+BUNtmj+4VP+t8dacBZq8v2B0zTESJ3bIywRKN8zhhEgcHts02E7" +
       "KqIXah/8byTWbxjO2dw9Bt+aqaLQHLqY3+LdJf8DS2gP8BkkAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6C+zs2Fnf/P/3fXez97HJ7mbZR7J7N5AMvZ6nPcPyiO15" +
       "eMb22GPPw+Om2Xhsz/htj9+edJsQiSYtUliVDQQJFgklbUBLgqqmRVDQVi2F" +
       "QEQFSh+0KglVC7RpqkQV0DZt6bHn/76P5CbpSD5z7POdc77vO9/3O995vP6V" +
       "0oXAL5U918rWlhveVtPwtmE1b4eZpwa3h1STlfxAVXBLCoIJ+PaS/NwvXfvz" +
       "r7+iXd8vXRRLj0qO44ZSqLtOwKmBa8WqQpWuHX/tWqodhKXrlCHFEhSFugVR" +
       "ehC+SJUeOlE1LN2iDlmAAAsQYAEqWIDQYypQ6U2qE9l4XkNywmBT+hulPap0" +
       "0ZNz9sLS20834km+ZB80wxYSgBYu5+8zIFRROfVLbzuSfSfzHQJ/rAy9+pPv" +
       "vf73z5WuiaVrusPn7MiAiRB0IpYetlV7qfoBqiiqIpZuOKqq8KqvS5a+LfgW" +
       "SzcDfe1IYeSrR0rKP0ae6hd9HmvuYTmXzY/k0PWPxFvpqqUcvl1YWdIayPrY" +
       "saw7CXv5dyDgVR0w5q8kWT2sct7UHSUsPXu2xpGMt0hAAKpestVQc4+6Ou9I" +
       "4EPp5m7sLMlZQ3zo684akF5wI9BLWHryno3muvYk2ZTW6kth6YmzdOyuCFBd" +
       "KRSRVwlLbzlLVrQERunJM6N0Yny+Mvr+j77fIZz9gmdFla2c/8ug0jNnKnHq" +
       "SvVVR1Z3FR9+F/UT0mO/9pH9UgkQv+UM8Y7mH/31r737e59547d2NN91Fxpm" +
       "aahy+JL8ieUjv/cU/s72uZyNy54b6Pngn5K8MH/2oOTF1AOe99hRi3nh7cPC" +
       "N7h/vvjgL6hf3i9dHZQuyq4V2cCObsiu7emW6vdVR/WlUFUGpSuqo+BF+aB0" +
       "CeQp3VF3X5nVKlDDQem8VXy66BbvQEUr0ESuoksgrzsr9zDvSaFW5FOvVCpd" +
       "Ak+pD55HSrtf8R+W3gNprq1Cng6xvpuLHkCqEy6BWjUoiJyV5SZQ4MuQ66+P" +
       "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" +
       "9cj5TN5KK9zoWRbbb3jkdh55nFkbVqbj1UbqSa6nQkg2mslYezLCPbiaqZOe" +
       "PQNVt5YgTuFVspgN511y1uuGdTyUps4q6ixsq0zU54MBN02m80iTIk7vQOWs" +
       "ZdhS12MrsK5xqEIT03ndXaM1eYb5pO1ZIclvJpVxOG0gm6ZtRHNFHPU94PGS" +
       "z1mC1+cbKNuW+oJhxpv+emrSqjAVUb697RhEq6ZwsWZOXA53V04zacBRIraX" +
       "ruSS0gCiylvam4lpQ1anjUZv3ujOtwwtoGufK2ezAaJlGtmSyaWb4QuhsTYY" +
       "Dq31nGA0WCCEjNZZ3xpX20pUn7FiajbsTo/r6H7fFWvlZMT6a5fsNHE2MxWp" +
       "TyxCVog50x5OCJ4MzKCRmQtt69FTGXPVcaqmrJBmXTMSe5rJy9miu94qommj" +
       "Q53kxhpi2V7bGfqLbUujt0nK1OmB0tcr6mjsZ5NGQ7EprdloVATNdBZEkibZ" +
       "GAwxP16NUYMdCzOhi47JrRJVyu0Ka4RZOq2vtARTFIfEF1wDwBYqKoONrnYF" +
       "pzeIHM2UlZri9KvVBJPpxK71Mkzj6uiIaHsVpqWPAovvJF1HmXSDTewMKwId" +
       "8p6BaG0HWy1Vok63uiHsdBBFJmZi1CYgN4zF1FlsNalsCI25ORgSmt5i+oIK" +
       "lQNyRZWJjeIOB2a2gjtVYo6Mu5FDZrNxladgZLGcdD2tjgUEZsMItJpEEwU0" +
       "JvP8eB3WFkpArdGpjXWEVSvY1qoVWGFZja+xsy3mdZFuQ+6Sw2DSjcPhcmxq" +
       "i+XMoowWusLdNUZ4o2p9KpVJlZ+RfIN3esZKISttkiQgZFOfr3QMN2pMv1mF" +
       "2mtHhnzTz6Z1drmyk3WlNTENIokMb6slZsUpE0y9z0gVfZKZy3ozHVAA6OpK" +
       "R+hiwUjjFQtl/MbEXxO4IchLK27idStZqsICGU2D2IdYpN2c2mMu4toUUl8F" +
       "LNFOW+1kGVdEK1zNIZHiKCWh7NpMtIlmrTvczvnegkytKrwc1W0xFhYpMHqa" +
       "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" +
       "Tx/i8eIe6NEJ8ne0vfRuXn0B1JHuc7j6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("J4fnH//tfoerJ8A9T8Qj7f3xnaeq+et78uS9dx6TFuO867aonSfqfezsz+5T" +
       "9hd58t/zxNhxch/a/7k7Rfzj00P/+aLsP92n3tfz5Ethfpl0qeixfoeZ/9G3" +
       "YebFvNAGaol2dXf/D2Lmd58Xzpxuv/kO+OOk7LDwuTsKCzQMdjemcghU8z72" +
       "LtxbSXsP5Qlwjiv6YdXTStrbexAlpQDX74nM+QWuJ+64Wb27DSx/+rVrlx9/" +
       "bfqvd/dIDm/sXqFKl1eRZZ28b3Mif9Hz1ZVe6PHK7vaNVwh1Myw9dvd5A/hU" +
       "8Z9zvndjR50fup2lBjNq/neS7Imw9NAJsrB06SB3kui7wtI5QJRnn/LucqS3" +
       "u3WU7p2IOA5Mq7DIm99I2UdVTl4KzO8sFBfbD+8XRLur7S/Jn3ltOHr/1+BP" +
       "7i4lypa03eatXKZKl3b3I4tG8zsKb79na4dtXSTe+fVHfunKC4cR1CM7ho/N" +
       "/ARvz979BmDX9sLizt72lx//B9//9177w+KE8f8BCmYUVnEwAAA=");
}
