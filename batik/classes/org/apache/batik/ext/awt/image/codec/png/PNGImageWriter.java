package org.apache.batik.ext.awt.image.codec.png;
public class PNGImageWriter implements org.apache.batik.ext.awt.image.spi.ImageWriter {
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out)
          throws java.io.IOException { writeImage(image, out, null);
    }
    public void writeImage(java.awt.image.RenderedImage image, java.io.OutputStream out,
                           org.apache.batik.ext.awt.image.spi.ImageWriterParams params)
          throws java.io.IOException { org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder encoder =
                                         new org.apache.batik.ext.awt.image.codec.png.PNGImageEncoder(
                                         out,
                                         null);
                                       encoder.
                                         encode(
                                           image);
    }
    public java.lang.String getMIMEType() {
        return "image/png";
    }
    public PNGImageWriter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL06a6zjWHmeO+/Zx8zOwrLd7ntngSX0OrETJ9EAJQ87sePE" +
       "sWPHSUoZHNtxHD/jR2yHLgVUChSVItjlIcG2UqEtaGEpKm2limqrqgUEqkSF" +
       "+pIKqKpUWorE/ihFpS09du69uffOzC4rUCP5xDnn+77zvc53vvOdPP1d6LTv" +
       "QTnXMRPNdIJdNQ52F2ZpN0hc1d+l6FJf8nxVaZiS7/Og75r88Gcvfv+H75tf" +
       "2oHOTKA7Jdt2AinQHdvnVN8xV6pCQxe3vbipWn4AXaIX0kqCw0A3YVr3g6s0" +
       "dMsh1AC6Qu+zAAMWYMACnLEA17ZQAOk21Q6tRooh2YG/hN4CnaChM66cshdA" +
       "Dx0l4kqeZO2R6WcSAArn0t9DIFSGHHvQgweyb2S+TuAnc/ATH3rjpc+dhC5O" +
       "oIu6PUjZkQETAZhkAt1qqdZU9fyaoqjKBLrDVlVloHq6ZOrrjO8JdNnXNVsK" +
       "Qk89UFLaGbqql8251dytciqbF8qB4x2IN9NVU9n/dXpmShqQ9a6trBsJibQf" +
       "CHhBB4x5M0lW91FOGbqtBNADxzEOZLzSAQAA9aylBnPnYKpTtgQ6oMsb25mS" +
       "rcGDwNNtDYCedkIwSwDdc1Oiqa5dSTYkTb0WQHcfh+tvhgDU+UwRKUoAvfQ4" +
       "WEYJWOmeY1Y6ZJ/v9l7z3jfbbXsn41lRZTPl/xxAuv8YEqfOVE+1ZXWDeOur" +
       "6A9Kd33hXTsQBIBfegx4A/NHv/Tc6199/7Nf2sD87A1gmOlClYNr8sent3/t" +
       "3sZj1ZMpG+dcx9dT4x+RPHP//t7I1dgFK++uA4rp4O7+4LPcX47f+in1OzvQ" +
       "BRI6IztmaAE/ukN2LFc3Va+l2qonBapCQudVW2lk4yR0FrzTuq1uepnZzFcD" +
       "EjplZl1nnOw3UNEMkEhVdBa86/bM2X93pWCevccuBEFnwQMh4HkY2nyy7wBa" +
       "wHPHUmFJlmzdduC+56Ty+7BqB1Og2zk8BV5vwL4TesAFYcfTYAn4wVzdG0hX" +
       "phQFsG4B88OyAwwGu8C1+r0WmXaJng48azf1Off/dbY4lf1SdOIEMMu9x4OC" +
       "CdZT2zEV1bsmPxHW8ec+c+0rOweLZE9rAVQGDOxuGNjNGMgCKmBgN2NgN2Ng" +
       "FzCwe5QB6MSJbN6XpIxsXAEY0gAhAQTLWx8b/CL1pnc9fBL4oBudAlZIQeGb" +
       "x+zGNoiQWaiUgSdDz344etvwl/M70M7R4JsyD7oupOj9NGQehMYrxxfdjehe" +
       "fOe3v//MBx93tsvvSDTfiwrXY6ar+uHjavYcWVVAnNySf9WD0uevfeHxKzvQ" +
       "KRAqQHgMJODOIPLcf3yOI6v76n6kTGU5DQSeOZ4lmenQfni7EMw9J9r2ZPa/" +
       "PXu/A+gYhfaaI/6fjt7ppu1LNv6SGu2YFFkkfu3A/djf/dW/opm694P2xUPb" +
       "4EANrh4KFCmxi1lIuGPrA7ynqgDuHz/c/8CT333nL2QOACAeudGEV9K2AQIE" +
       "MCFQ8zu+tPz7b37j41/f2TpNAHbKcGrqcrwR8kfgcwI8/5s+qXBpx2aRX27s" +
       "RZoHD0KNm8788i1vIOiYYCmmHnRFsC1H0We6NDXV1GP/++Kjhc//+3svbXzC" +
       "BD37LvXqFyaw7f+ZOvTWr7zxP+/PyJyQ001vq78t2CaS3rmlXPM8KUn5iN/2" +
       "1/d95IvSx0BMBnHQ19dqFtqgTB9QZsB8potc1sLHxpC0ecA/vBCOrrVDyck1" +
       "+X1f/95tw+/96XMZt0ezm8N270ru1Y2rpc2DMSD/suOrvi35cwBXfLb3hkvm" +
       "sz8EFCeAogwinM94IAbFR7xkD/r02X/4sz+/601fOwntENAF05EUQsoWHHQe" +
       "eLrqz0H4it2ff/3Gm6NzoLmUiQpdJ/zGQe7Ofp0EDD5281hDpMnJdrne/V+M" +
       "OX37P/3gOiVkUeYGe/Ix/An89EfvabzuOxn+drmn2PfH18dlkMhtcZFPWf+x" +
       "8/CZv9iBzk6gS/JeljiUzDBdRBOQGfn7qSPIJI+MH81yNlv61YNwdu/xUHNo" +
       "2uOBZrsfgPcUOn2/sDX4Y/EJsBBPI7vl3Xz6+/UZ4kNZeyVtXrHRevr6SrBi" +
       "/SzbBBgz3ZbMjM5jAfAYU76yv0aHIPsEKr6yMMsZmZeCfDvzjlSY3U3KtolV" +
       "aYtuuMjesZt6w9V9XoH1b98Sox2Q/b3nn9/31d945JvARBR0epWqD1jm0Iy9" +
       "ME2If/XpJ++75YlvvScLQCD6DN/9++gPUqqd55M4bZppg++Lek8q6iDb32nJ" +
       "D7pZnFCVTNrn9cy+p1sgtK72sj348cvfND767U9vMrnjbngMWH3XE7/2o933" +
       "PrFzKH9+5LoU9jDOJofOmL5tT8Me9NDzzZJhEP/yzON/8nuPv3PD1eWj2SAO" +
       "Djuf/pv/+eruh7/15RskG6dM5ycwbHDbg+2iT9b2P3RhPBMjIY7FGYNW4Rbc" +
       "m9Q0qUvywjyo1mssMpDihYa0myD01vuSRU4Wq+bMFssJGubWDCLK7SAhuLqU" +
       "l+Y1bU7hS6dQ75jehGSHwpDqxxTHic7AlRCBoIe9ZanegaV+vrYWHWHltKdK" +
       "H53Yk1UVnvg4tkSoKiqjflyeVsvtabVU9itVheREhh8uJ5HYq+QtivG6M02r" +
       "cojYcaduEVu3ctIAC3tmtQWX6dVshg/EYYSxMVvK50x+6Q+RHpbMDStZj5pF" +
       "hWMtpd8Xa06pbqFWtx3Ksp/Pz32zsR6bNj0s8D2lZLtzbVDuEIjmJwu7t5IG" +
       "JLYOG2HNyAlUHmc5S58rRXXEAFFHvLgaUIXKgGQqjNeom4UAposSW5LHDUZI" +
       "Ru3esEBJtfJq3VsZhL8CBJSCUVHGti8zGBUoRC7uThulmFVCmueqKlMquYSO" +
       "jfkIbZa6ZGUSK2u+jcgu1zGSCRzkh7bICHpu0AV6bZRqa9wsR0EgaEIeiDpY" +
       "F5Zyo8yFY0MOEKtCymXDWgYEJ+hUbxgLpC8FjN9BJixWiwZLz/RCpNaSCrLo" +
       "UUPRdBdFpIF2EnmG9kY5dNFke0Yy7bVwqjAkGo0omTaLRENsiy0kXxp2fIWN" +
       "LFGp+aQ69oaEYqHkAlUpx4mmJsPqcCmW5DVhdwl7ha0csqhZBYQPRWvE11Y0" +
       "C5xqGZAYygpTAjWQxAnK3WGpS9fFWmXk92ojORyszXFpyRUtjrA6PW0M+1W2" +
       "1vCHQ7vVRSbzJdppRhrnGlyTW/KtZbPWzi8IXPP4Wl1rju0BIg91D0OWTbfF" +
       "FYwBDizXKnE0SwiLNon7diPqGpFJ4R3RdAYaUbQZc5YL43oxUjiXw1lGFgR0" +
       "JKwibCwavW5Y0CWEXTOaOPBHJbnIcWpVXnCdRr22atYJ2nJlZjQteDM1JHoJ" +
       "3+P5PtskI+AKbn9pKe1WUFULQSHmYmspiMhk4UzrdJmSbZqqK5iwnuZbLXE4" +
       "YHXSj6dwu+G5sFzN1VGEyi3c5oTpmEN+jQh1Du4JXSRwGY9Bu8X+xKR7gt1j" +
       "I7IqBIWQMRpukbf8tlHGa1iZr6lUTsSsjpOPR9VI4FzcIYNlcWis88spOiVa" +
       "Ki5XS3pcH9SHcNKZ6Qg+M7hVKZKFJmWZuim444lldZfaVKKrC42cTCKuYhWI" +
       "Vq0/XOhW35qSDW0cLBcNTZAnlF7WGirP23UiydNFghMTQ3LHtQ5ah8NCbPeX" +
       "sse2krGjlTA4h4lxKbDXFU4X6mPTEXlNK9vSWHXdkq4McdgKVkN5NmiXTI2V" +
       "23N6JJXWclPzcLdGxs64TjpSvcY3NBaPPJwlibHPkgY+b5dpo05QdVYzWgyL" +
       "6zW7gMpddFpdw9UW0vUbWm+IM4LQHARLWiowqN0cwBOqOlzTbIFfJqVg1ih0" +
       "kjljzCWnwqGC3xuiSKfBxoocVUuwsBDoUaXo4YnQTCIssKzE7LAhMvbIJSZI" +
       "NiMj/KKfjDu1eieXLw4IcaJX/G7O7dNuojL02h7EoU4RrkyjTbphzAtJEyPF" +
       "KcaulVVTFUkrFApt2q4Wy8Egj4lq19FooyDnB7w3mNPjpOu3wwHmLYfV9jox" +
       "VRMpzsZSwuhypFn4pGdI6LLrkKMhlnCFYMlKzTwmKS7vhCqPhSXOntr9ul1v" +
       "8XZxWmeduTwnCIotkKN+kzD7MOzZs3LcU3ukRwpIHVnAuNqSgf1bEeG2tNLK" +
       "ItFWfl23+ZXNlSpVGvc4eNxhajSBuQYy7apxq0oOuZpcyTEC2vTKZXgprgms" +
       "m5s3baGsRGTQrJbGcthY5Gq8pubgChm6dV0xEst2lVVfTQyQzKNNcOQvhUaN" +
       "KgxqEblYTcrNcWNuBlNH75YjuJ8sJBltVdBKqaCvm57MdOelaaEQz7Q1WtVb" +
       "qB15owI8jYc6qS/Fca8K9127i8G9ajJEEH6gcAt4PVdKY7jCu9WW7uCT1rBt" +
       "IaSe5+h5MyEbIWEXx0533CuOxKmvzBdcH1f7eNzwuM5gNirGbEWq2usIM8X5" +
       "dNRaEeO43C4LGDV2DaLVWCNFrUw0hrkRUTCKU63YXDt+U1eXbYWnNLreI+Al" +
       "nO/Es7A2nTZ9BunonDmpNFoBZaw0l6JHw3bBinNwYC1gBBEMxAiWyoQBKYFR" +
       "lDtsy+hicrPFy6v+aBJirIpXhahXC2CjTvZNIdYIYtpt93Kq1x0SXGeijlZJ" +
       "1ZNzajjgNEkwJr1IILz5cFGPyh4lruOKMqlEQ1sX1lbbj8iEzFGlxkCNsQJL" +
       "xVVK19RODTaLORGuLMDRe90s5StG7BYny74vmMuOWnRUibJmcE6AZ7FThqc+" +
       "Oknmk56S5KfBaML0us2lO52bhkC4Ri4/t7GBisFxzORgdI1hZWGybFSwwmip" +
       "YMV+ZTjuDjBEDAiRGo3asMfngwI6WU1nLGWO8REFNsMBmiuVyjIcSFWBE6rd" +
       "VsK6fH5dGXZtod2OlmNEKwL4Zi92DVz2A4FAe+ycpz1NLTO0VVo15/m1JUdE" +
       "o912Ol6towYjJprbFDnE2TzmECuL1/h+MEdYySe5gWbWGJlL+BLeRbpNRiyb" +
       "DM1XFy2JGLiV/mBcEViQHcWxNsO6lrfuksUGXaoytTgWFmHdoqQpInGLxTK0" +
       "PFGcEw5SXk+dBJ3ROYRgRnZJZpvoDCFFCqky3KhfdBQmsef0sgIv80FI4riq" +
       "ssLAWkwXeLfXDJBlOGK5djmGGX4GR2K113YsjFk5Kl+xCd4oqA7NL3zTM3UM" +
       "zY3jdl23kpFVL3p1P5JyrUKEd5oy07YEsWDWiwnCYhENo8Vpc9SAB1arEswr" +
       "K41aqckEH3OwUaS0Nqn4+JCL5iuT6c2Kbd5C64E6isDej038sMegAlJYWMtc" +
       "iJcK83KryNVsRWK61cqorGrLXhvWYZGL8iuKb5c6I7laKednlW5ZFYqSnqs4" +
       "ItEYmXTkG5xSqY6FNa+I9Lq6LncKONNwZ5FqLHxskoR1mNK7uCKKiwktVWhB" +
       "DSxcZGgbF4q53AhfCW4iiFI5HpX6coy1JvB6IdvEgEST5sqpNox1JU+PCGcu" +
       "lF3ZzTXEfuyPsJqyMPoONehU1gLbNRd4u+Mmze5Y8MYjOGph0yIzqYi2VplI" +
       "fY2jVlp7oLHsbIXYPa3RBmfj7qwjIvV6hxVHWnVQn0y1GVtXSKLcUIcCQhXg" +
       "ZiSj+XW3nKtjpVxubpbaBaLALERCCEFOh3sq0NFQDUQ/v4gnJu9j3kLMiXS/" +
       "lVQIooq1tKlGj42WjaMi4S5xAkW0oJrzAjsolzEfY4blfLOA4L5OkJ6E+jWv" +
       "yxgu1qfW+QYd8LN5TwhrpudpJaU9rgCPs3MrbjZLQmyQUKuyHFhuPrckSrkq" +
       "HMu26SZEKz8ByUutpfAGzLecQilXosaxwse5wjy/rJX6I5PFJc4Zkjkec5N5" +
       "W05iteHWW6s2K8gRHum5kIn9jo/OuZI0CILaUhyFuTleqmrVxXg9wTi8HFGK" +
       "yVf5anvKSiBimPOhXmnJHWcYs+DEPljNfI/nKxhq0mKjaC0SKtFy4GjfK1CO" +
       "S5KrZh9lEh2VWi2lpi5oblKwVXjatoyGwM0K5UGxGdnGaBROOxq+GqzBw6ry" +
       "bFFfRW10nC9TjVgDB6LXvjY9Kr3hxZ1W78gO5gcXK+CQmg60XsQpbTP0UNo8" +
       "elCMzD5nnqcYeahgc2K/CLD7AsVo39V3D9Wg0wPrfTe7ZskOqx9/+xNPKcwn" +
       "Cjt79TExgM4HjvtzprpSzWMlo1fd/GDezW6ZtnWbL7793+7hXzd/04uoTD9w" +
       "jM/jJD/ZffrLrZfL79+BTh5Uca67/zqKdPVo7eaCpwahZ/NHKjj3HRjkllT/" +
       "NfC8Ys8gr7hxdfiGznMic56NyxwrP+5kADv7Jrw3q6psTcaptgJ2WiUz2z7Q" +
       "5tJAd3aZMHDDYBB4qmRl1INj1E8cdZA79xFJBo9l1U2VnuGt08YJoAtR6hnb" +
       "ybhDzjsMoFMrR1e2Xu2+UO3hcIkx6zCP6vNR8OT39An/dPR5crtaw7SJ9mUv" +
       "vrjFsXG/bIp331ip6c83ZwC/nja/ckR7ac9btpp6x0+gqctp533gqexpqvLT" +
       "0dThwveHnmfsI2nz/gC6RVODLtnF91dIayveB16MeHEA3X70Miyt5t993a38" +
       "5iZZ/sxTF8+97Cnhb7P7oIPb3vM0dG4Wmubh4uuh9zOup870jP3zm1Ksm339" +
       "VgC98se9sQugk6DN2P/NDfZvB9CVHwc7gE5n34dxfyeA7n9+XIClHyy8PaxP" +
       "BtDdN8MC/IH2MPTTIDTcCBpAgvYw5DMBdOk4JJg/+z4M9zng1Fu4ADqzeTkM" +
       "8nlAHYCkr3/o3qAcvamtxycObRd7Lp65zuUXcp0DlMPXYKkKsn977G8H4eb/" +
       "HtfkZ56iem9+DvvE5hpONqV1FtvO0dDZzY3gwZby0E2p7dM6037sh7d/9vyj" +
       "+9vf7RuGt8vtEG8P3PieC7fcILuZWv/xy/7gNb/71Dey6vj/AWXJ7jaGIwAA");
}
