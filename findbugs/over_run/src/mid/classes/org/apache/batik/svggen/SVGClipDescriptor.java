package org.apache.batik.svggen;
public class SVGClipDescriptor implements org.apache.batik.svggen.SVGDescriptor, org.apache.batik.svggen.SVGSyntax {
    private java.lang.String clipPathValue;
    private org.w3c.dom.Element clipPathDef;
    public SVGClipDescriptor(java.lang.String clipPathValue, org.w3c.dom.Element clipPathDef) {
        super(
          );
        if (clipPathValue ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CLIP_NULL);
        this.
          clipPathValue =
          clipPathValue;
        this.
          clipPathDef =
          clipPathDef;
    }
    public java.util.Map getAttributeMap(java.util.Map attrMap) {
        if (attrMap ==
              null)
            attrMap =
              new java.util.HashMap(
                );
        attrMap.
          put(
            SVG_CLIP_PATH_ATTRIBUTE,
            clipPathValue);
        return attrMap;
    }
    public java.util.List getDefinitionSet(java.util.List defSet) {
        if (defSet ==
              null)
            defSet =
              new java.util.LinkedList(
                );
        if (clipPathDef !=
              null)
            defSet.
              add(
                clipPathDef);
        return defSet;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+Nv4y+CoXwY27GpzMddKQHUGGjgMGA446tt" +
                                                              "rNY0Ofb25s4Le7vL7px9Nk0IRCmoSqOUj5S0hVYJSYtFQ1QVtY0EdVW1SURT" +
                                                              "BI3aJLQpDX+0KUEKfyROS7/ezOzX7d0ZIbW1tHPjmffezHvz3m/emzM3UbGh" +
                                                              "oxZNUOJCgIxq2AhEaD8i6AaOh2TBMPphNCp+5U9H9k3+pny/H5UMouohwegW" +
                                                              "BQNvlLAcNwbRfEkxiKCI2NiGcZxyRHRsYH1YIJKqDKKZktGV0mRJlEi3GseU" +
                                                              "YEDQw6hOIESXYmmCu0wBBC0Is90E2W6C67wEHWFUJaraqMMwJ4sh5JqjtCln" +
                                                              "PYOg2vAuYVgIpokkB8OSQToyOlqsqfJoUlZJAGdIYJe8wjTElvCKHDO0vFTz" +
                                                              "0e2nhmqZGWYIiqISpqLRiw1VHsbxMKpxRjtlnDL2oEdQURhVuogJag1biwZh" +
                                                              "0SAsaunrUMHup2MlnQqpTB1iSSrRRLohgpqzhWiCLqRMMRG2Z5BQRkzdGTNo" +
                                                              "22Rrax23R8Vji4NHv/5Q7Q+KUM0gqpGUProdETZBYJFBMChOxbBurIvHcXwQ" +
                                                              "1Slw4H1YlwRZGjNPu96QkopA0uACllnoYFrDOlvTsRWcJOimp0Wi6rZ6CeZU" +
                                                              "5n/FCVlIgq4Njq5cw410HBSskGBjekIA3zNZpu2WlDjzo2wOW8fWrUAArKUp" +
                                                              "TIZUe6lpigADqJ67iCwoyWAfOJ+SBNJiFVxQZ75WQCi1tSaIu4UkjhI020sX" +
                                                              "4VNAVc4MQVkImuklY5LglOZ4Tsl1Pje3rX5yr7JZ8SMf7DmORZnuvxKYGj1M" +
                                                              "vTiBdQxxwBmrFoWfFhrOH/IjBMQzPcSc5kdfuvXAksaJVznN3Dw0PbFdWCRR" +
                                                              "8VSs+vK8UPtniug2yjTVkOjhZ2nOoixiznRkNECaBlsinQxYkxO9v/zCo+P4" +
                                                              "hh9VdKESUZXTKfCjOlFNaZKM9U1YwbpAcLwLlWMlHmLzXagU+mFJwXy0J5Ew" +
                                                              "MOlC02Q2VKKy/8FECRBBTVQBfUlJqFZfE8gQ62c0hFApfGg9fK2I/7FfgnYF" +
                                                              "h9QUDgqioEiKGozoKtWfHijDHGxAPw6zmhqMgf/vXrossCpoqGkdHDKo6smg" +
                                                              "AF4xhPlk0BhOJrES7BvYFJIlbQM2RF3SwPkD1Oe0/+tqGar7jBGfD45lnhcU" +
                                                              "ZIinzaocx3pUPJpe33nrxehF7nA0SEyrEdQOSwb4kgG2ZIAvGchZEvl8bKV7" +
                                                              "6NL88OHodgMIAApXtfc9uGXnoZYi8DptZBrYnZIuzLmVQg5aWBAfFc9c7p28" +
                                                              "9HrFuB/5AVBicCs5V0Nr1tXAbzZdFXEcsKnQJWEBZbDwtZB3H2ji+Mj+gX2f" +
                                                              "Yvtwoz0VWAxARdkjFKPtJVq9UZ5Pbs3Bv3x09umHVSfes64P69bL4aQw0uI9" +
                                                              "V6/yUXFRk3Auev7hVj+aBtgEeEwEiB+AukbvGllw0mFBM9WlDBROqHpKkOmU" +
                                                              "hacVZEhXR5wR5nB1rH8PHHElja958C01A4790tkGjbazuINSn/FowaB/TZ92" +
                                                              "4s1fv7ecmdu6JWpc13sfJh0uZKLC6hkG1Tku2K9jDHR/OB45cuzmwR3M/4Di" +
                                                              "3nwLttI2BIgERwhmfvzVPW/98Z1Tb/gdnyVwNadjkOVkbCXpOKqYQknq585+" +
                                                              "ANlkiHfqNa3bFfBKKSEJMRnTIPlHTduyc+8/Wcv9QIYRy42W3FmAM/6J9ejR" +
                                                              "iw9NNjIxPpHerI7NHDIO1zMcyet0XRil+8jsvzL/mVeEEwD8ALaGNIYZfvqZ" +
                                                              "DfxM89mQaDFOeokG+CVqTcygkDGyXAzE1VSAJkhYIeyk72MUQdYup1ZiAhGb" +
                                                              "u582rYY7YrKD0pU2RcWn3vhg+sAHF24xFbPzLreDdAtaB/dJ2rRlQPwsLzpt" +
                                                              "FowhoLtvYtsXa+WJ2yBxECSKgLZGjw7omMlyJ5O6uPTtn/28YeflIuTfiCpk" +
                                                              "VYhvFFhkonIICWwMAbBmtM8+wD1ipAyaWqYqylGeHsKC/MfbmdIIO5CxH8/6" +
                                                              "4ervnnyHeSJ3vbnmYdB0zwuiLGd34v/9q9+8/tPJ50r5jd9eGPQ8fLP/3iPH" +
                                                              "Drz7cY6RGdzlyUY8/IPBM9+aE1p7g/E7uEO5783k3kiAzA7vp8dTH/pbSn7h" +
                                                              "R6WDqFY08+MBQU7TaB6EnNCwkmbIobPms/M7nsx02Lg6z4t5rmW9iOfchNCn" +
                                                              "1LQ/3QNyVfQUm+FrM+O/zQtyPsQ6WxnLQta202aJhSmlmi5BHYU9oFI5hVAC" +
                                                              "SsPtG4EEhylNB1dwNKVtB23CXN7agm7Yma1EE3wLzfUWFlCinytBm225uy3E" +
                                                              "TVCltdsNOEGHVnn2un2KvWacNRfZa7K/Em8y54Zdd5SYyNQ2RTLjJDIWdfMU" +
                                                              "1H2j4M0ZCijzC+XxrAY5deDoyXjP88t47NVn58adUPp9/7f//FXg+LXX8qRe" +
                                                              "5UTVlsp4GMueiG/OifhuVuY44bPqymTR1cOzq3IzJiqpsUA+tKgwNHgXeOXA" +
                                                              "X+f0rx3aeRep0AKPobwiT3efeW3TQvGwn1VqPFpzKrxspo7sGK3QMZSkSn9W" +
                                                              "pLbYLlNDPaQRvjWmy6zJn47k8Tb7ki/E6rnZfHaKu8B9VvRlpC8dM0ivMML8" +
                                                              "JCo+0fL4/k+W3lrJHaQpL7WrNFw+ubKmafx7CidvzS88uyh8d+/FZ9Xf3/Bb" +
                                                              "BV8+Fk651ei+9PLmP0fZoZZRr7FN6fKYdXrSle3V2jaqpiapg++aaSP2+98u" +
                                                              "eEBIKkikFOQbwX4pheNmgvG/Ka+mXI1G/9ycUHSO9tzLL6w6tOTzz3LDNxcI" +
                                                              "Lof+J5+7dvnE2NkzHAqo+QlaXOgVKffpilYDbVNUNI4Tfbjp/on3rg886Ddz" +
                                                              "r2raDGcs3JvuZCOQ6tDBR/I4doPXkbjskmUn/rbvy2/2QLHRhcrSirQnjbvi" +
                                                              "2XFaaqRjLs9ynkucqDXd6t/w54PvX/Sj7kQHuFvVh8yngyb77UDTMnSeIN8i" +
                                                              "6DI52hQp50Ha7IaMMYmJ/Qhpapx2rib5TtdoVjZHB0JsOGlHRq11u0bMyIjc" +
                                                              "PfAUYi0APPT/PdmhWQ/faVPKaUvKCJOS4SqO0uaI7QfV7lSZ1yLHvAvRfw9w" +
                                                              "U39tClM/Q5snoGYAU0MGICmsYINMjo4fdmz91bu3dYagupy3CJpUz855BuVP" +
                                                              "d+KLJ2vKZp3c/jtWD9vPa1UAeYm0LLtzPle/RNNh30yZKp4BauznOwTNKpAn" +
                                                              "QLHIO2zn3+b0z4ERvPQEFbNfN90LBFU4dCCKd9wkpwkqAhLaHdfyVGU89c34" +
                                                              "XNmDmUsxW8+8k61tFne5THGFPUNbkZ+OmPB19uSWbXtvrXyel+uiLIyNUSmV" +
                                                              "EO/85cDOBJoLSrNklWxuv139UnmbhVB1fMNOmMx1OVcI/FCjJz7HU8sarXZJ" +
                                                              "+9ap1RdeP1RyBbB1B/IJUKTuyC0SMloaLuwd4XzIBnkSK7M7Kq7vvPTx2756" +
                                                              "VouZWNg4FUdUPHLhaiShad/wo/IuVAxZIc6wCmbDqNKLxWE9CyhLYmpasV+s" +
                                                              "q6l7CrS6ZpYxDTrdHqXPPQS15LxF53kCgzJ1BOvrqXQTeLNyp7SmuWeZZffT" +
                                                              "5rEMB9yiaLhb00wALh1nltc0FoTnGQz8B2dqHT1rGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12f+2tvb3vb3nvbQltraXvLbaVd+M3s7NsCMjP7" +
       "mNmdnZl9zOzuKFxm57EzO8+d5+5oFfBBlaSiFiwJbUiEqFgoIeIjBlNjFAjE" +
       "BEN8JQJRE0EkoX+ARlQ8M/t730eFGDeZs2fP+Z7v+X6/53s+5zvnuy98Ezod" +
       "+FDBc63NwnLDXXUd7i6tym648dRgt0tXOMkPVIWwpCAYg7bL8sOfOP+d775X" +
       "v7AD3SRCd0mO44ZSaLhOMFQD14pVhYbOH7a2LNUOQugCvZRiCY5Cw4JpIwif" +
       "oKFbjwwNoUv0vggwEAEGIsC5CDB2SAUG3a46kU1kIyQnDFbQT0OnaOgmT87E" +
       "C6GLx5l4ki/Ze2y4XAPA4ebstwCUygevfeihA923Ol+h8PsK8DO//rYLn7wB" +
       "Oi9C5w1nlIkjAyFCMIkI3War9lz1A0xRVEWE7nBUVRmpviFZRprLLUJ3BsbC" +
       "kcLIVw+MlDVGnurncx5a7jY5082P5ND1D9TTDNVS9n+d1ixpAXS9+1DXrYbt" +
       "rB0oeNYAgvmaJKv7Q240DUcJoQdPjjjQ8VIPEIChZ2w11N2DqW50JNAA3bld" +
       "O0tyFvAo9A1nAUhPuxGYJYTuuybTzNaeJJvSQr0cQveepOO2XYDqltwQ2ZAQ" +
       "evVJspwTWKX7TqzSkfX5JvPGp3/SIZ2dXGZFla1M/pvBoAdODBqqmuqrjqxu" +
       "B972OP1+6e5PP7UDQYD41SeItzS//1Mvv+X1D7z02S3ND1+Fhp0vVTm8LH94" +
       "fu6L9xOPNW7IxLjZcwMjW/xjmufuz+31PLH2wM67+4Bj1rm73/nS8M9n7/io" +
       "+o0d6CwF3SS7VmQDP7pDdm3PsFS/ozqqL4WqQkG3qI5C5P0UdAbUacNRt62s" +
       "pgVqSEE3WnnTTW7+G5hIAywyE50BdcPR3P26J4V6Xl97EASdAQ+Eg+cStP3k" +
       "3yG0hHXXVmFJlhzDcWHOdzP9swV1FAkO1QDUFdDrufAc+L/5huJuDQ7cyAcO" +
       "Cbv+ApaAV+jqthMO4sVCdeCR0CEsw2uqgewbHnD+3cznvP/X2daZ7heSU6fA" +
       "stx/EhQssJ9I11JU/7L8TIS3Xv745c/vHGySPauF0GNgyt3tlLv5lLvbKXev" +
       "mBI6dSqf6VXZ1NvFB0tnAhAA8HjbY6O3dt/+1MM3AK/zkhuB3TNS+NooTRzC" +
       "BpWDowx8F3rp2eSdws8gO9DOcbjNxAVNZ7PhXAaSB2B46eQ2uxrf8+/+2nde" +
       "fP+T7uGGO4bfezhw5chsHz980rC+K6sKQMZD9o8/JH3q8qefvLQD3QjAAQBi" +
       "KAEHBljzwMk5ju3nJ/axMdPlNFBYc31bsrKufUA7G+q+mxy25Ct+Lq/fAWx8" +
       "a+bg94PnDXsen39nvXd5WfmqrYdki3ZCixx73zTynvubv/h6KTf3PkyfP3Lw" +
       "jdTwiSPQkDE7n4PAHYc+MPZVFdD9/bPcr73vm+/+8dwBAMVrrzbhpawkACSA" +
       "JQRm/vnPrv72K1/+8Jd2Dp0mBGdjNLcMeX2gZNYOnb2OkmC2Rw/lAdBigQ2X" +
       "ec0l3rFdxdAMaW6pmZf+5/lHip/616cvbP3AAi37bvT6V2Zw2P5DOPSOz7/t" +
       "3x7I2ZySs6Pt0GaHZFu8vOuQM+b70iaTY/3Ov3zNBz4jPQeQF6BdYKRqDmA7" +
       "uQ12cs1fDUKQfGR2iu1uT7H9jruyPZuU5F3FtXezeEV1wnyl4Zzi8bzczayU" +
       "M4TyvkpWPBgc3THHN+WRuOWy/N4vfet24Vt//HKu4vHA56iD9CXvia1PZsVD" +
       "a8D+npPwQEqBDujKLzE/ccF66buAowg4ygDuAtYH8LQ+5k571KfP/N2f/Ond" +
       "b//iDdBOGzpruZLSlvKdCd0CtoQa6ADZ1t6PvWXrEcnNoLiQqwpdofzWk+7N" +
       "f2Wh42PXBqV2Frcc7ut7/4O15u/6h3+/wgg5HF3luD4xXoRf+OB9xJu/kY8/" +
       "xIVs9APrKyEbxHiHY9GP2t/eefimP9uBzojQBXkvgBQkK8p2mwiCpmA/qgRB" +
       "5rH+4wHQ9rR/4gD37j+JSUemPYlIh0cFqGfUWf3sCRC6LbPyRfA8src/HzkJ" +
       "QqegvELkQy7m5aWs+JH9PX/G840YRAd7m/574HMKPP+dPRmzrGF7lt9J7AUU" +
       "Dx1EFB44xW6XwVHFgWggN0DGBNkiX1ZWs6K55d24psu8+bhCD4Hn0T2FHr2G" +
       "Qv1rKJRVO7mVyBC6dV+0pqplTegJwZhXFCxntD4F7HQa3a3t5pqNrz71DVn1" +
       "dQBEgzzkByM0w5GsfVnuWVrypX0LCuAVADjzpaVVu5rByP+1XGBPnTuEKtoF" +
       "4fZ7/um9X/jl134FOH4XOh1nawL8/QieMVH2BvILL7zvNbc+89X35PgP7Ma9" +
       "v3XhLRnXt15Pu6yYZsVsX637MrVGeQhFS0HYzyFbVTLNrr/fOd+wwckW74XX" +
       "8JN3fsX84Nc+tg2dT27uE8TqU8/80vd2n35m58gLy2uveGc4Omb70pILffue" +
       "hX3o4vVmyUe0//nFJ//ot55891aqO4+H3y3wdvmxv/qvL+w++9XPXSW6u9EC" +
       "q/EDL2x47o1kOaCw/Q9dnGmThF+vJxpbYOLypkC402SG1jpe2leU3oDkO53l" +
       "ot/ByuVqGPrMDGG1OVoJyrRai+mat24wJkINCdsdrVh+WRkhujDrjmZhe1Ac" +
       "COEMaSnCpDjih2OcKkldeuA1pwWkx7d62mbIjmqwmrLptKYgIjWfFEOSW9qa" +
       "pqZknJZsWLXTfomfd3R3LTI82yUW1HqFYnpLataNKiaxOjrG+5ynM4RXqPAN" +
       "smGWCp6zgckK33cjV0/UxQQfMLFFYzKTzIday1wbPYJCGaMji+vNkBwGM7I4" +
       "o7q9VbPXE82wIyD2sGu1jFInUPlZqzlIqjpLtUbTmW0TEZLgOIFQQQNpoZMq" +
       "Ua0lLXLS5rsg+ln1+0m3HOiV7moZEpbDzdgFGmPRTFhQnmuaeJ0dDcbuhrVW" +
       "wUrrurwldrGOQs26aj1ZjltWTPTIJovE7XGKqKij2yuxM5lRxooaeSt6aCRF" +
       "gQzm637PWw+XoeU0adRtKQN+qAuRu+hKi+LcSEQdGWGBFDk+3ycjD+1bzmDl" +
       "jfGiMRr5wyHt6gtvleoTg6BXw35/2EHFCj4YmqnSGTMuig59aY2WhnVhaZQZ" +
       "MoYrg9qg0OP7yGLldXgQKSutsYjPum28T+jseo5HPhWT8jQZFEdWUga2tJKh" +
       "2FkyXNSoDkzXw5AIIyzLcWdtv8la8TgYTuQua9geMjGqvlglVJGvOHCbECxq" +
       "sSozy1VFTspFhMRHgdnBl6pJYaWUEb0InVjNZeqiCTupaxOfxzC/x3tjSuTV" +
       "quUZC6y56lZrBpG4mwmmsd3CCGe6RltYD8RaZTIgjGI4kqiozJtLnUJQJJiW" +
       "BQYT5HJ/IJiUHZnWrEIvLFYsjwOryC3Vkj+tbPxaV6yP+lqtabND0YnidW/W" +
       "WRb78djAlcF6neC233YnWlv3WRKmlnh/kHLySK6YihbFU8wMpK6QOkypmSDc" +
       "vK1MiCEw7ygoxL06z4WOES3QzXIsmOxSF1GHdY21kTpDk2kREm4FhjNYz8w1" +
       "24jhlHALXFnXG4LSa414cTruacSStdqMJPb6Db44S+YeJtMJbU36FmnT6VRa" +
       "8AW73U2mG6RbaSV91iIQdIAKvd4GrrdbxBDHx8IA13iru2qLWqu+GFRRGdHb" +
       "mKd1Fg2th1Jwra0tnFlbbwz45mJluC2j13FTtxdONNJYNsnOGuOSamrrq/5C" +
       "g+Op7wYB4bmrjqmQzZ5bDewF1i6vdc4yEVxnu35rVMPjWbtLWfNBHx22S6OE" +
       "M5tFVkXgQrjqSH5tiXe0ZrliObrMi5ThpJIrr0sez3U9tVRy/LWqt2sOhoxa" +
       "Gx9sAXaUzMvmAvgyhcUdWRdbsVWf94RalaHrdZZ0lUUfYJ43DTW5EXWmjivO" +
       "jHrTC0XcnzkiFaW0LQwWFWmCY1pbbsg1D603SL8d4XAFE3BDJoKKgDB+MZxi" +
       "81RU2tOWHPScQXfSwsV5MwGMSiS6NAr9ZWExRbVZHCZuiggTbI0NFXPZ7nFh" +
       "V1g1eLHCzYMSHpfWSCOySWGkqUG1zFUbc7osDRIkohpCFd7w0/bQLGGRGtd0" +
       "YVmQ8HDRUltJy8ALWGTO445lJYgN9mADbAl8yK5Ir2eyNq9LsiC29Omwkgwr" +
       "Dl70yTpHki1rKTUqdQIpYuVaAwnNznIupRHFjMC2cxMJh8diAy0HRS2uqbKt" +
       "RNXuxJOLpUDr6kgk9miiqpud4tiM0F4DLPgQZvFyRY5SOxmW+nC5aZSchA5D" +
       "CsWpRWuY6LYWpwI3gRt1sTiewwvF2QgJIylLkxXMOTH12N5qNjCdVaVeKWCM" +
       "ZRqktmKk0ryt4b3eqNXtD50xxVnkWIk2cqEOT+S4MaBmw00ZnZTaNtaHq92G" +
       "ugSY2GCYJbXmPFL1qRpDNim2mPbljRoi06FhFerLIE5p2BbUVitp1jFa6jDU" +
       "TNTildjU1v16wx5IzTarumanQAirsbxZmM3OZoqlraIwwrqmPqPUjVlD+/xA" +
       "mUVeUTQwvTOPKnXUn81qM7/XRDweHcoTpxTri0KAkW20vG7PuZT21aaChcC6" +
       "Shf1h9aASwI69UJgcd2lw3gWBlOpMOmiG3zdIka9BQ1gM6m5dt/adCtsNeLG" +
       "oQOj9ZmqWVQ01gzCM4WZHrfbuuk6FEVMkj42x+2wXy8kzaLhYRtpspqtNlZH" +
       "JYMeAfe1ua1QFFsh1mQdrpZVP3acDamOuqV47tgzBUfSJDLojlIqx3Bj1QCG" +
       "DrluBfErS6WhdrhBXaM5uGRwZNNPa/KsOuwoqbXhZ3WY4oDvFaRW0ast4FYt" +
       "arGVWr1klkwDS7Fa7NWVMQl785FT04fVSXPVniH1Qh8f8LWxhFdbDkMkpj2n" +
       "3DlnB3C/5gRrBKUX1bQcVnx70jBYTQaHulOkB3BpwGwEbcDbhbbfL7BwOgg3" +
       "XDCoTtYOPQglFEGlrj6yLduo4OSMb7htqqILGDEKuLBTbrX0jcXgRSVhekKI" +
       "oyViytSkhV2b2VKx1SoldKrxk7ZFGM4mxG0UrUSbUmssEFaoBAzb6pCC46CR" +
       "g/biiSQzQ02Uaj24Zdc3lbKoKJXRbMMM0OGYXnab1ETR+nwRAEG5j4iEsUyJ" +
       "wnTtY7OKojbdzXTJ1ethucYITqUuKTznNeCaBsPt6aJAT6f11VCt8GPBCrxy" +
       "px+pRgdmDU2PhGhWLs+51cYeD4sym65KVNo1Vl7AY4Wwt0gYcjFV2Sk2LWiI" +
       "vy5J6lD1EKzHufPEGJdUTZ2UxoO4kzhFYcW1vbTnrwPPrQWdXmnQF0fmyGlM" +
       "PHo+oy2myUmDYbyc2Jtq2nXKNbM+ntdMA25VfUfUSKkX1fGGEA8tj6grfcSI" +
       "+3263gWnEqLRZdgsTEqW3yWlgUfXJj7TTgrRvGdL2rpGGEqcjur1aKPXlQLc" +
       "FhtTrQTjc1yoF9pmtVJUjUKDo20O0URXFId+rc1Utd5MmfojSy0J6FJaeYbk" +
       "LQoFSRpxaKFRj9QWTvVMw2yzg3kyLXu6ytiLuAP3pII9pYoduLGReXLENsKU" +
       "pqtJNWTHaVqim8xapmhXK3QrhZoSOy2UMVMSW7mFgSVN2YXQ0zTwMjVrzgWG" +
       "Z6jyWJsvPdh1Sv6iXq82ldRHfanZkYNSN45Egh1UQ4DAMFVWXG5qzpeBafMO" +
       "7M/jDQqjA5oc6rI/MvyBs5zHBjptS9JquKSDxsYxI3nVnCrVEE4qZS6ewqNl" +
       "zRyQUTsW9PrGWWzmtRrfHPedkUoxIN5tUhVUH3gVhJRqlNTvz+wuPNA9yVuj" +
       "vjGvjEPFFZYiiSPdgO1Y5HBVLEbIvL+hljKnYfzMQDCOG8OcYuuTAaxJAteT" +
       "+LhHdNlRGQTvSCRRtYEm1KyRWNzQZIzFQy1pJHypAcLZPjyoBI7bmWE80u9Q" +
       "hB3MKKa/dMuaYqeN4jwqKTNpEXmbEtH1+LReqeCRwCmFHt1F457olWR4GU6a" +
       "jZiTijymzmyEpsOUs1R4yDB6CdmIPa+MS1HqsMmY6XmYA2xHsWjqlApzJC23" +
       "hjE3aLXnjMY0EBpv82WFIHpKIzG9xFxhOi2RirYROny9IZfKU8Zu2nywntQL" +
       "dbNaDNuOWhmTnTbHM3NTLLA2hxcb0Wgyn4axP92oVgHgILVh+JEttFi4XpGb" +
       "LN516ZHPmNZkHcXFUoN37Lku4EWtz7B2f11kBZkCUeuym9ZIvh5I/lTsFhqS" +
       "VxwqKlccboB3F3GY6vK9cbQhkFHfciU6SpTyNKVwxxz1av1ab1WLY268RmuV" +
       "quBG4oRZlNs8gAaS1iVjpEsKnLgwFQnYWqTkakLY8+aK6dHrSatBbHR6ZntS" +
       "IBSCVdWqEf6oKnqzdXPsK+RqynGDUbFCr9uVkkks0m4RZ2N/NR2MVZrZeLWR" +
       "HU1UUdS0ccVv9fHGxpBofY4gCUbrRccKZaTtjp3OIK3jqLIix0W/s8Cw7DXS" +
       "+f7e5O/ILygOsnw/wNXEtutiVjxycKOTf26CTmSGjl4hH14RHly/PnKdzMhh" +
       "VmSf+uJ1qEcbJ5TW2dv+a66VFMzf9D/8rmeeV9iPFHf2rmyNELoldL03WGqs" +
       "WsdE9KHHr32r0c9zoodXiZ9517/cN36z/vbvI6vy4Ak5T7L87f4Ln+s8Kv/q" +
       "DnTDwcXiFdna44OeOH6deNZXw8h3xscuFV9zsGLnswV6ADxv2luxN528gzv0" +
       "iatfwL1u61MnbsRPHeSmLl7DgEMpyVflsvyHg69+8bn0xRe29ypzKVBDqHCt" +
       "rP+VfzzIkkePXCcBdpgP/nbnR1/6+j8Kb91f91sPzPBgpvXD1zPDvv/dfniF" +
       "3pfyvqdzXk9dJyXwK1nxsyF0fqGGWBiCcyEKVTA6J/7F41mmc6+0Fk/nxeEm" +
       "/blXumY6Kk3e8I6DGS/s38ByezNy/7erf1y/7O46v7S+5mz7Rj53NLexTR59" +
       "KJ/ouetY+Tey4tkQugCs3FQ1w8lzaSM1vJqZz7+S0h/Ki0Mzf+D7MfMaIOwV" +
       "ed0sSXXvFX8p2f4NQv748+dvvud5/q/z1ObBXxVuoaGbtciyjqYHjtRv8nyg" +
       "Zy7uLdtkgZd/vRBC91wDJrMr67ySy/w7W/oXgdFO0ofQ6fz7KN0nQ+jsIR1g" +
       "ta0cJflUCN0ASLLq73lXSbBtsyTrU0dQds8rcyvf+UpWPhhyNPOZ7fn8Lz37" +
       "KBpxe9Dy4vNd5idfrn5km3mVLSlNMy4309CZbRL4AIkvXpPbPq+byMe+e+4T" +
       "tzyyjx7ntgIf7pAjsj149TRny/bCPDGZ/sE9v/vG33z+y/mN/P8AYu/DGmsl" +
       "AAA=");
}
