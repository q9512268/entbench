package org.apache.batik.svggen.font.table;
public class CmapIndexEntry {
    private int platformId;
    private int encodingId;
    private int offset;
    protected CmapIndexEntry(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        platformId =
          raf.
            readUnsignedShort(
              );
        encodingId =
          raf.
            readUnsignedShort(
              );
        offset =
          raf.
            readInt(
              );
    }
    public int getEncodingId() { return encodingId; }
    public int getOffset() { return offset; }
    public int getPlatformId() { return platformId; }
    public java.lang.String toString() { java.lang.String platform;
                                         java.lang.String encoding =
                                           "";
                                         switch (platformId) { case 1:
                                                                   platform =
                                                                     " (Macintosh)";
                                                                   break;
                                                               case 3:
                                                                   platform =
                                                                     " (Windows)";
                                                                   break;
                                                               default:
                                                                   platform =
                                                                     "";
                                         }
                                         if (platformId == 3) { switch (encodingId) {
                                                                    case 0:
                                                                        encoding =
                                                                          " (Symbol)";
                                                                        break;
                                                                    case 1:
                                                                        encoding =
                                                                          " (Unicode)";
                                                                        break;
                                                                    case 2:
                                                                        encoding =
                                                                          " (ShiftJIS)";
                                                                        break;
                                                                    case 3:
                                                                        encoding =
                                                                          " (Big5)";
                                                                        break;
                                                                    case 4:
                                                                        encoding =
                                                                          " (PRC)";
                                                                        break;
                                                                    case 5:
                                                                        encoding =
                                                                          " (Wansung)";
                                                                        break;
                                                                    case 6:
                                                                        encoding =
                                                                          " (Johab)";
                                                                        break;
                                                                    default:
                                                                        encoding =
                                                                          "";
                                                                }
                                         }
                                         return new java.lang.StringBuffer(
                                           ).
                                           append(
                                             "platform id: ").
                                           append(
                                             platformId).
                                           append(
                                             platform).
                                           append(
                                             ", encoding id: ").
                                           append(
                                             encodingId).
                                           append(
                                             encoding).
                                           append(
                                             ", offset: ").
                                           append(
                                             offset).
                                           toString(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1qsZtQ5TriIvKDrihUbLWcLzbdfYKuPuTN30yps5jVfcWjcLsRZfVsWJswhm" +
       "qKtVBEkNpdm0vvJnPba+6Tk+NnZkNEBnLLMOBCZm13OpUsFjq9Rik5k7svip" +
       "sRkuJ8Q6RSbLLWnTw6ozaCajsuktQjl2USeSlVgcNrejETzwk81oti1lHjxY" +
       "+NJ0aXUXXnXJhITXYbuziYx6s4nqN6UK5feXJjdg/VHP6FbQGejHXtVq7FaU" +
       "2LLJCkuNrtWI4ay/YCQdh+d8DWMWZCJaop00ooxqe9hGb3Auz1q9OGps5Ckn" +
       "IEmn3e+Z8bJPOpw3rEcVdzg1JvFaMTEC15nMa407nf6aDxZ+HxG3QoP3cWsz" +
       "EQ3cDALWJpajiWZ7Q3YUVzAcm1kzq2dIw7TLWZrFk2UMG20mtJLaHhr0XQWP" +
       "Vp3NqLzqkwrubyeOYiVqO3QQTYPRqSyNBMIUlkqdGg4TX++UN3FHWsQ0btOY" +
       "ay37/WSeLRpEtKkrGIpjWXfUzQjKSRoluK10N5XInaOjmjIUVs16mHhbQrYs" +
       "eNCkS2qF4isz0/G5vhzYdWbQohhVrDilVO0v6AlpiMzCqfcHC4Fsae127A5m" +
       "yLg2aU6arOlbc6VqEYumJHYr8RDzKnQFox1juDJZU5yGPN6rlMaW5ddXpiX1" +
       "ZBrZSNOeILJcMN8Ek0SD1xxP4gSeBJ7oTrk02IYjIxIGJbfLEYQ4XxPyfO1w" +
       "Oj6AEYdEcbESj8pE5LC+YzR9GubK83rY8ZYzFGkz0xIxQdjRlG2XFjhBTGtc" +
       "1iMJs7vQvGg1FFmeiCyVm3hDqcWyPVUaBaS0dBbool3LRrgkt+ewRNbT6sxo" +
       "h8NFf+WgCt4x+I00ZBIyWDZIHLEqrq4z3bScLJebWWcrc/VNZAxr3UUSrWtb" +
       "L4qXrVXF6ZdU1YRpFig+S5kJOsfXCpOtJgXQzSmjUhfpMdMpVW18MOgLqFsf" +
       "4K6si4K3KXMkigSDxmBMq/NImNuVxoibDRfBVLRsu8+F/XXYpWednrsxyRof" +
       "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" +
       "I5vpz+2qwFqq1ROGnbK5VFKYm691saPxzECfh/7cG9rrJodx2hhj58Sw1MVX" +
       "6zar93sdJZSNmYi7pcZWrG23vUSNmipGwSRPp420EyhDUZnAmCdbykapyvNW" +
       "OTM1vSchA7E3l6K1ZldwrEYiLa6BheLao9hBz+L7DV0Lu21YlnuzdiPB106r" +
       "tB1zuDbTysRE6lca2465BsEzrJfqdHUmVeBSc9Efxk2sBtbSIUmBLUS7BDZU" +
       "At2lJpNqddyYsxVO1xt9rzb26bacgs1Be9OEGy1RIijX0Ba6Z5T0oT9F6qXa" +
       "YLihuWngBVNlPZ8t7TYxyFpczKP1Clp21IXLuxNOmHiWGYRVIcnKm8moW23M" +
       "q1mtkvBOW+MkdJCWZHYA2wJbCTxkqrSqWnm25CYxrdbbrTrsIoZYUSvZqoN1" +
       "meaoUV7wWWlgUGS9nzH0JKSVtTuKuZmconWuw8yNWp1ktNLaQLJk7OtMOndx" +
       "nFBAIPaz+Vb0Tc9vi3x7cRpweNcJdsZ5hfU8dsHZNc4/lkdn68XvHHTqxuz4" +
       "2frRmSmUH1rde7VLzeLA6kNvffIplflwJT8iyAnHMXRz7Pk/Y2upZh9jdT3g" +
       "9MjVD+dGxZ3u0RnoF976r3fPXmO88XncDN1/Ss7TLH9/9PSX+q9Q3n0Wuu7w" +
       "RPSy2+aTRI+ePAc9H2pxErqzE6eh9x6O7IWD0Xzl/si+8vRJ1ZE1r2amwsin" +
       "jvkPTrPz73dfo+7JPPm1GLp1qcX4yeO3Iw964rnOUY5zLQrecVLBu8Dzqn0F" +
       "X/WTV/Cpa9T9dp68HzgYUJA5Osc7Uu63flzlcuuV95Ur/+SV+8g16p7Okw/v" +
       "rDc+PNI+peDv/BgK3pEX3g2e+r6C9Z+8gn94jbrP5MknY+im2Ds6z7SOdPvU" +
       "89Eti6HbTl5X5xdvd132L5ndPzuUjz114aY7n+L+prixPfz3xc0UdJOe2Pbx" +
       "q45j+XN+qOk7gL55d/HhF68/iaGHnvs2PYZuKN6F6J/bUf5ZDN1zLcoYuj5/" +
       "HSf5fAzdeRWS/GS5yBxv/8UYuni6PRCleB9v9+UYOn/UDrDaZY43+WoMXQea" +
       "5Nm/9K9wKr27XsrOnFwwDu15x3PZ89ga87ITK0Pxl6gDFE92f4p6TPn4UyT9" +
       "pmebH97dXiu2tN3mXG6ioBt3F+mHK8GDV+V2wOvc4OEf3PaJm19+sGrdthP4" +
       "aAIck+3+K98T444fFze728/c+Qev/t2nvlEckv8f4UHvDasmAAA=");
}
