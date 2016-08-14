package org.apache.batik.ext.awt.image.codec.png;
public class PNGDecodeParam implements org.apache.batik.ext.awt.image.codec.util.ImageDecodeParam {
    public PNGDecodeParam() { super(); }
    private boolean suppressAlpha = false;
    public boolean getSuppressAlpha() { return suppressAlpha; }
    public void setSuppressAlpha(boolean suppressAlpha) { this.suppressAlpha =
                                                            suppressAlpha;
    }
    private boolean expandPalette = false;
    public boolean getExpandPalette() { return expandPalette; }
    public void setExpandPalette(boolean expandPalette) { this.expandPalette =
                                                            expandPalette;
    }
    private boolean output8BitGray = false;
    public boolean getOutput8BitGray() { return output8BitGray; }
    public void setOutput8BitGray(boolean output8BitGray) { this.output8BitGray =
                                                              output8BitGray;
    }
    private boolean performGammaCorrection = true;
    public boolean getPerformGammaCorrection() { return performGammaCorrection;
    }
    public void setPerformGammaCorrection(boolean performGammaCorrection) {
        this.
          performGammaCorrection =
          performGammaCorrection;
    }
    private float userExponent = 1.0F;
    public float getUserExponent() { return userExponent; }
    public void setUserExponent(float userExponent) { if (userExponent <=
                                                            0.0F) {
                                                          throw new java.lang.IllegalArgumentException(
                                                            org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                                                              getString(
                                                                "PNGDecodeParam0"));
                                                      }
                                                      this.
                                                        userExponent =
                                                        userExponent;
    }
    private float displayExponent = 2.2F;
    public float getDisplayExponent() { return displayExponent;
    }
    public void setDisplayExponent(float displayExponent) {
        if (displayExponent <=
              0.0F) {
            throw new java.lang.IllegalArgumentException(
              org.apache.batik.ext.awt.image.codec.util.PropertyUtil.
                getString(
                  "PNGDecodeParam1"));
        }
        this.
          displayExponent =
          displayExponent;
    }
    private boolean expandGrayAlpha = false;
    public boolean getExpandGrayAlpha() {
        return expandGrayAlpha;
    }
    public void setExpandGrayAlpha(boolean expandGrayAlpha) {
        this.
          expandGrayAlpha =
          expandGrayAlpha;
    }
    private boolean generateEncodeParam =
      false;
    private org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam
      encodeParam =
      null;
    public boolean getGenerateEncodeParam() {
        return generateEncodeParam;
    }
    public void setGenerateEncodeParam(boolean generateEncodeParam) {
        this.
          generateEncodeParam =
          generateEncodeParam;
    }
    public org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam getEncodeParam() {
        return encodeParam;
    }
    public void setEncodeParam(org.apache.batik.ext.awt.image.codec.png.PNGEncodeParam encodeParam) {
        this.
          encodeParam =
          encodeParam;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeOye247edl/NyXk4gD+6AkIZgSnEcJ3F6caw4" +
       "sYoDuaz35ux19nY3u3P2OWAKaVFCHzQNIUAElioFhaaQRC1pi8ojCFFAQCUe" +
       "LYWKgNqqoaWhRFCKoC39/9m927292zUn9bC0s+uZ+Wf+/5tv/v/fvXnoPJlo" +
       "6KSJKizERjRqhNoV1iXoBo21yYJhbIW6qHh3ifDhjnc7VwdJaS+pGRCMTaJg" +
       "0HUSlWNGL5kjKQYTFJEanZTGUKJLpwbVhwQmqUovmSoZHQlNlkSJbVJjFDv0" +
       "CHqE1AuM6VJfktEOawBG5kRAkzDXJNzqbm6JkCpR1Ubs7o2O7m2OFuyZsOcy" +
       "GKmLDApDQjjJJDkckQzWktLJMk2VR/pllYVoioUG5ZUWBBsjK3MgWHCq9uPP" +
       "DgzUcQgmC4qiMm6esYUaqjxEYxFSa9e2yzRh7CY3k5IIqXR0ZqQ5kp40DJOG" +
       "YdK0tXYv0L6aKslEm8rNYemRSjURFWJkfvYgmqALCWuYLq4zjFDOLNu5MFg7" +
       "L2OtaWWOiXctCx+6e0fdT0tIbS+plZRuVEcEJRhM0guA0kQf1Y3WWIzGekm9" +
       "AovdTXVJkKU91ko3GFK/IrAkLH8aFqxMalTnc9pYwTqCbXpSZKqeMS/OCWX9" +
       "NzEuC/1g6zTbVtPCdVgPBlZIoJgeF4B3lsiEXZISY2SuWyJjY/PXoQOIliUo" +
       "G1AzU01QBKggDSZFZEHpD3cD9ZR+6DpRBQLqjMz0HBSx1gRxl9BPo8hIV78u" +
       "swl6TeJAoAgjU93d+EiwSjNdq+RYn/OdV99xo7JBCZIA6Byjooz6V4JQk0to" +
       "C41TncI+MAWrlkYOC9Me3x8kBDpPdXU2+/zipgvXLm8685zZZ1aePpv7BqnI" +
       "ouLRvpqXZ7ctWV2CapRrqiHh4mdZzndZl9XSktLAw0zLjIiNoXTjmS2/vu6W" +
       "4/S9IKnoIKWiKicTwKN6UU1okkz19VShusBorINMokqsjbd3kDJ4jkgKNWs3" +
       "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" +
       "e55oPs/If0YNPMsf8em5/wG5gu71ijAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zkxn3f3ul9lnUnyZZlxdbLZ0cS1ePukrvcteLYS+5y" +
       "SS7JfXIfdOozl6/l+73k0pHjCEjkOIVqJFLqpImAAjbSuo6dFhUao3Ctok0T" +
       "w2mBtEabBmhsFEGd1nFgF2li1GnS4e73uu+++3SHO3UBDrmcB3+/+f3nP8OZ" +
       "4Re+W7ojCkuQ79kb3fbiS2oWXzLt2qV446vRJYatDaQwUhXClqJoAu5dlp/8" +
       "zfN/8cNPry6cLd0plh6UXNeLpdjw3GikRp69VhW2dP7wbsdWnSguXWBNaS3B" +
       "SWzYMGtE8XNs6S1Hssali+w+BBhAgAEEeAsBbh2mApneqrqJQxQ5JDeOgtLH" +
       "S2fY0p2+XMCLS09cWYgvhZKzV8xgywCUcHfxfwpIbTNnYenxA+47zlcRfgWC" +
       "X/57H7nwT28rnRdL5w13XMCRAYgYPEQs3euozlINo5aiqIpYut9VVWWshoZk" +
       "G/kWt1h6IDJ0V4qTUD2opOJm4qvh9pmHNXevXHALEzn2wgN6mqHayv6/OzRb" +
       "0gHXhw657hiSxX1A8JwBgIWaJKv7WW63DFeJS48dz3HA8WIPJABZ73LUeOUd" +
       "POp2VwI3Sg/stLMlV4fHcWi4Okh6h5eAp8SlR65ZaFHXviRbkq5ejksPH083" +
       "2EWBVPdsK6LIEpfefjzZtiSg0iPHVDqiz3f5H3vpYy7lnt1iVlTZLvDfDTI9" +
       "eizTSNXUUHVldZfx3mfYX5Ie+sonz5ZKIPHbjyXepfnnP/n9Dz376Ou/u0vz" +
       "Iyek6S9NVY4vy59d3vf77yKebt5WwLjb9yKjEP8K5lvzH+zFPJf5oOU9dFBi" +
       "EXlpP/L10b9dfOLz6nfOls7RpTtlz04cYEf3y57jG7YadlVXDaVYVejSPaqr" +
       "ENt4unQXuGYNV93d7WtapMZ06XZ7e+tOb/sfVJEGiiiq6C5wbbiat3/tS/Fq" +
       "e535pVLpLnCUMHDwpd1ve45LJrzyHBWWZMk1XA8ehF7BP4JVN16Cul3BS2D1" +
       "Fhx5SQhMEPZCHZaAHazUvYiiZUppDBsOkB+WPSAY7APTGvDdtlr8HRTN9lJh" +
       "c/7/16dlBfcL6ZkzQJZ3HXcKNmhPlGcranhZfjnBO9//4uWvnz1oJHu1Fpcw" +
       "AODSDsClLYCtQwUALm0BXNoCuAQAXLoSQOnMme1z31YA2ZkCENICLgE4y3uf" +
       "Hv9t5qOffPI2YIN+ejtQoUgKX9tnE4dOhN66ShlYcun1z6Q/Pf2p8tnS2Sud" +
       "bwEe3DpXZN+COXCNF483upPKPf/in/zFl37pee+w+V3hzfe8wtU5i1b95PFq" +
       "Dj1ZVYCfPCz+mcel1y5/5fmLZ0u3A1cB3GMsAXMGnufR48+4onU/t+8pCy53" +
       "AMKaFzqSXUTtu7dz8Sr00sM7W/3v217fD+r4LYW5vxMc4z37356L2Af9Inzb" +
       "zl4K0Y6x2HriD4z9X/uDf/8/kG117zvt80e6wbEaP3fEURSFnd+6hPsPbWAS" +
       "qipI918/M/jFV7774oe3BgBSvOekB14sQgI4CCAhqOaf+d3gv3zzjz77jbOH" +
       "RhODnjJZ2oacHZAs7pfOnUISPO19h3iAo7FB8yus5qLgOp5iaIa0tNXCSv/q" +
       "/Hsrr/3pSxd2dmCDO/tm9OwbF3B4/5146RNf/8hfProt5oxcdHSHdXaYbOc9" +
       "HzwsuRWG0qbAkf30f3j3L/+O9GvADwPfFxm5unVnpW0dlLaiwVv+z2zDS8fi" +
       "KkXwWHTU+K9sX0cGJJflT3/je2+dfu9ffn+L9soRzVGtOcl/bmdeRfB4Bop/" +
       "x/GWTknRCqRDX+d/4oL9+g9BiSIoUQZeLeqHwO9kV1jGXuo77vrDf/WvH/ro" +
       "799WOkuWztmepJDStpGV7gHWrUYr4LIy/4Mf2omb3g2CC1uqpavI74zi4e2/" +
       "ewHAp6/tX8hiQHLYRB/+P317+cJ/+8FVlbD1LCf0w8fyi/AXfvUR4se/s81/" +
       "2MSL3I9mV/tiMHg7zFv9vPO/zz5552+fLd0lli7IeyPDqWQnRcMRwWgo2h8u" +
       "gtHjFfFXjmx23fhzBy7sXcfdy5HHHncuh30AuC5SF9fnjvmTe4tafgYcwl5T" +
       "E477kzOl7cUHt1me2IYXi+BH95vvXX5orEG3v9d+/wb8zoDjr4ujKKy4seuk" +
       "HyD2RgqPHwwVfNA9vRUMtXxgFlHL9lfS6SIPQsMBnmm9N1iCn3/gm9av/slv" +
       "7AZCxxU9llj95Muf+ptLL7189sjw8z1XjQCP5tkNQbdV9tYiaBdt5InTnrLN" +
       "QX77S8//i3/4/Is7VA9cOZjqgHeF3/hP//f3Ln3mW187oa++a+l5tiq5Ozde" +
       "hNUi+NCudmvXbDTvv1pSc09S8xqSDq8haXFJbEm3gTjAUUmuMpBsNY63MJlj" +
       "0EY3CA0Cxwt70F64BrT59UC7D4z2/SRu4EbcBW72JGyLG8RWBcere9hevQa2" +
       "y9eD7SHw8lB07l3JcSTCC8NdB3ESxo/eIMb3gePLexi/fA2M2vVgvDeJ1LCT" +
       "+Z6r7r22dveMvDj14sKdeFJ8DK5+g3CfBsef7cH9s2vA9a8H7nnFiHxb2uwj" +
       "Lm5bx8AFNwjuWfCQx3ZJd+cTwKXXBW7XTAo73Hqxk4TObhBcGTwE2wOHXQPc" +
       "x68H3IP6nrvtuAdj+5MA/tQNAgQd9ZnmHsDmNQD+zPUAfIt6CGyb8u03+NJy" +
       "jNgRTj/7hpx2Nn8G9GR3VC9hl8rF/5dORn1bcfkUGLFG29mWooUYrmTv03iH" +
       "acsX9/u4qRpGoMVfNG1sn9KF7Uip6Ngv7aYsjmFtXzdW0A3dd1gY67n6cz//" +
       "x5/+vb/7nm+CLoUp3bEuhhKg7znyRD4pJoR+9guvvPstL3/r57cDcCDD9Of+" +
       "CfKDotRfPo1xEfxCEfziPtVHCqrj7fstK0Uxtx0zq8oB22Oe5Hbbuwm28QM2" +
       "hUZ0a//HViSimsrZyFH7G7WKYqpiw/xmbqF6G6q3LFrUx25HZhCyLkspGi28" +
       "diLlSC3JKk13gSTIoNqftXrSlCSofMjTQqtjGx65kqThiKj4RsMzCZJsDQlB" +
       "ZRezns4HgSfNViOS6HkE0oSbTrOKVZvVXHCbS6IcQYkIzTQIrsVreA1r67nr" +
       "DRjbq/fGTM/IOyNzFKx4b1ox5h7uVSubBbNa0rN6QK0QQ2uvTFfGpqnCSGPI" +
       "744IbiIxepkSxvaM77I1y+wNFxOS6UiuOOkKPYb10+V0lQ6dQPDWztgTqaHN" +
       "29aYWU4Zk2yvywQVdCqthKtPGc2KO30pxbs1a9Sy8vac4fNg6dQZi/BHFWEZ" +
       "YV61jznVPplsxKgvb7o9h223/PbQNBmmbcnWMJ9ZMctwVnU6gn3bXkw9wxO6" +
       "NVGY4Xhk9hBOn1FE0EwGg7aeC/JQdwg0MDinrkYLQQrMrLPIyLHUVKubfLTC" +
       "iAVi1Wg6mI/KYjCsWT5abjP97kLpleP5Yl1m61IvsjtOI+QXqjMam8KInDGW" +
       "tl7oTtBiiVmyYAM0B0T7LJ/UOFLH2Go/lmazvjGXYyKD6mpZUyblmF6C+rTF" +
       "UTLtyB1mtOLKetIqW0OtskBmMzrvqpbTbHlrZTKfMlZPaFYsD+mSPZgOWxZL" +
       "NSQyyDjwcu7KTX+RTgJiOffHYi9QuTHcJ2bzJp93EgKu6PV8spzGA0KZ6gPc" +
       "FmmP0VUSxRE7MjpzkR4vquNktmHMBTyYe8M+bRuC1620cqFcGeI9XW+PRVLs" +
       "UH4bkdtNcQTV2/4IH7KByeVlCh9nFX2U2U184DVW9BRrJFFq1ycq0/Jauik0" +
       "EQXqGOnY5JUAGi1cuK9Mm83MwxicEOlWHd+YnpfXpygztMqxR6AVQIiGuNYs" +
       "tK1Fn2hyKpI1LLztD5S5UIXg3PD19Zx1GvVGLRfFiqQO/DWGBy7tJexo7Qdz" +
       "EZPj2bRKSP4oDAxqhTqKmLuKaDfnY2ArrbScsyZt8N58YjrjKrxO6jMUHjfp" +
       "nuvRvZnRM+RJ2uPrglDxLCuvNKfjVRLh4P2Q5zwriMylglhtBjUtvcfPIiSD" +
       "uK44qlh6tAnH9hwalFvCatMZerqP2v4YdVxshreXLbfCSbQ05NiQ7oVWzYDX" +
       "HYxGB6vWZIqnKO31QGtchXGZVMtImuAZpLeX+rylRVRtXiWJSd9upWE/bC6G" +
       "JMp1iBiPN2Jqtthxai/gsEUjls5JZSIOI6wibVyois6XvDeWyxgmVKeMB0GT" +
       "1bBFzMTlctmTjdTNJU/28kDQyKFsIdhqNBiR5ZxAx1ImdHmLHOtDbiXQ8nCG" +
       "EqlADu0N3iFlHW8FnWgl6PqQ0JTUCxY2jZMuPU9ak3QznbKJAy8SagDrK1b3" +
       "2otGa7rAkw1GG1YljuMm3YcTT2V7K/A204hqcpMaDyd0MAJl22OrTQkx4Ihy" +
       "k85cWUAhFLSDrkCZiNNHaXI0qShkVx9otdG0E5JUrzLuBou8bApZavodbrlM" +
       "eqlSbTNB3qjJDTgNJ4i2bo9oPXazVqDKRA/tZxMb6s5gFRssJpAsxYimJdlG" +
       "Hpj1oJo19N6w76DOuM/wRpZyDY6fVEZy32qg1LzSiBm3PdCtRn/F6zjay5cU" +
       "O7DU2XAWs31qVvZxdGAGPjoUu1lvUclx3B1Vqj1sZfcQN6/0W6Q/Q4dVrVWZ" +
       "VeLZHKMqjiXZMc8bxmAwJ5cpOqCmywSBEBh2wk2EIn0LFaCY7rCeLyEUyq82" +
       "kT5PMtVPqjNk2vOU5rKJTBRV0WqaEtXEOkWlbjrhnYGImyhvr3B9nVRryAxq" +
       "aNrSk8rdZS3dECpGD+RgJGSWETGZAI0iJjKqlWba1npouzvkZWRJ9gmXZNTO" +
       "wHeNbO0jmMSykzXcNM1ggues4HedsjZIcWzgiVJDj1koR6cZpzEGbixZ8GqD" +
       "JWLbhTaDeS8M9cgMOlpQsTUHGSSR3IY6bbc9X4VjStabXL8lddim31uuIXvN" +
       "5kRluegZ5VnXgnMRaiSjYXlOturNpsAjeTri5gm7FMfiKg8nMjPzYobdpDO/" +
       "2kbrM8yNO50UD9oaOZPrYR2a5EjapeElYRA0unD6eTtAN7YscAGsdSJT1VQ3" +
       "lHJfYcdUSwlEfEovxT7KJNykxVSFKtdaAy2hZlCpJXTfLvOjrFy2+/LSnRLt" +
       "lgxz6/k8JhZZHg2WkAxH5jRrLPuyL/q1lZEng9RSBpk492duY73sDtZYEMQN" +
       "FYKo1WLCibM+G+fTbGOKzcRer4Ez6k4ozqhRjWQSsKalNrgBMlFzTAyRhM1j" +
       "gSTqfVFYhlzLr2K9OVWGGxxm6E0GOCM1shWpN+2vZVpe9RDQX1tGeVF30WW5" +
       "H0TNPiyAVrGZmVxfxuaiYzquEkZp31oT3Frr1qrJrBm4LcZu9Cq5Ei6qzVzt" +
       "ldvoMJXnycKYj7EuyvTL0cYcKXosh/U1PbMn9TZn0zwkyd2szUviEFHRJW30" +
       "ytIac8Zaa0oOx1570sWYcdZIMMULMQdbQ8s2sxqtUDxqwgLeGGgYYjcbnXki" +
       "RFGWOzV+BkG0tyIGlFZv5DZoprDOpoOptiZxP2zjk4heVHspJNtlq2PJDmRT" +
       "Q7GD12KVWs81tQEt8VCv+VDINStwvZ1oKwhFxYHPNKoVYyHUCKw2zJDNipOx" +
       "tjdKEAdqIASjSEo/d+tBqlDNmi3xs4mbJUhaX2spBmP5IgEjyBo2sJBg2gQD" +
       "+UlLsNFsSDjTkT9eL+tOR4rXS6QaDTmeUSMwxlOHjWBoYAI2Nm29Om0knMg0" +
       "zVRNEVJMYNt10D6dduyIrjvtzmyzSbJq1xhH8nziYXMb83DcqG/alBm3eEoG" +
       "voOUAzdmWk1hFbVWvbCTDHuzgWwQ5WQ540gpjLgwRGYaFTVjHClXFJF1/I6k" +
       "cppgJXmPHzHLdq2zcbEAI+wJIodmN2y51ICfKJiUJHY+6mhqq+s7ebgSRoRE" +
       "8hVkmDYhZTIjKiOMm24GsxUH1wOyurGVmK3a3cCnuxUlnjiBP6zX+J6NTc3G" +
       "csk35qkyrEMJEW2amdbWAmaN0OlcSlrjpLkpxwispg0lgXjXZ4ZVemKlGU9a" +
       "y7HosJWgs9aqaSgoubUYxFokxVheH8TKACk3fYHU5FrDqCP2cBOpKyybeVhd" +
       "SMsbP8xsQYVWGOCtAN4UA08XsmTLmxCb1BS2ng+ZSpvj40BqLqeUGWr1epLb" +
       "+dC0AT9bjirk2qxjITtdqIsRlXNKFRmJIxuBpmVfRiqeXDeDTaWDS1UpgSyW" +
       "biiUqK9UPm+Vl2Z/WtMqlG4NgABlchU10v4clyqISaLd+tIJ5mN2Qo89LO66" +
       "LWvJbGoW0ujWe4rO1qYyjA/MfImEG9ei08mMXyC5M6RgN43F1GbXLqfGm5DH" +
       "gCvM67nQ7qdr1DWB7xQZbIM312pi1pqLNQkG5VCqTDiT4qC4u2BjYL9dXKiL" +
       "gq1sZDQgHcnjRo4Y4USCjRaVOFwjulCGyHq0WTZ81TOxtU3DaDwoy0atz1UG" +
       "00klQThXc2YxpuGBRlYTGMIoUipLYQ4xTUfr8y08G1eXqDdvo+N5wMXWCGGX" +
       "qSDCm1Qd+SyOtietdM6sHaNOD1fTRSj22xUVZ9JNzHeiBTYnZI0eNxfUShSh" +
       "6hQj0bI04tUyqkrRIBNM0pcx3i43qmQKdez+qhbna19v6OhsWTPKG5myuqNk" +
       "wqMxac0ktGk7XQy0oM6mOaJqA61RtTCzMdW6PYsynLw/0WrxgEOnxqa/YLJN" +
       "Zrb9cR+vqV7CZzUcNJQ2AGBxrUzWKcPjLCqbseBFI7BW/Zk4lnt4Y8pW+LWT" +
       "dsZabNIRQXC5TowUJGjK3WlK6LPeyB/2k3JNzPx0TWVCXKZYutN185azYEh+" +
       "gZsQTZrWRhwK6Sith2RM2RloVwtoNtHReUBDcQRXJDEB5DM0Stnxkuo3Gl1W" +
       "E0YJP5NnxkYHLxi25biAZ3vcHC3rASeH/TlUbo3ThDZ0bkKv5BFu0WBAPGpz" +
       "E7O+wQaBJ3eMxogqR/MEmVQ8liQXabnVoWa1tS0tWv1N5BkZ08Q90C+oRMp2" +
       "BGTYMIM8H86ENhlUW4bfmZNDha+shiFEpIQoRnG55rGjok44zVv6jWreH7bd" +
       "schX13zDZzt4dZpGTjhu8eMoCioLoe0Z8zq1Gol1edBzK4tlW/EtXZ7i5WrC" +
       "ZiJve8Sm4pvOeoIL686oaXYwNO53RSdqtehmv8UkUXPtIaLXMUnP8pap0mQm" +
       "XGSsFgODmXjqVFuiNMVNSMtuZWu8k1nduTemdS4bLFldItVNnqu6T2XWWshg" +
       "vDlwqsgC686tUVjuxbZu8rau9eIFz1o9lrYl0hJYvMGzFSZyFs08GOZ1UPzS" +
       "wFGCBq8ntJ6hFLyCaL9LzDAevBLSG51TlUVAOYIwSbOpHUHaLF/W4QwTEwld" +
       "TGcdm1MnUZI3PGWdgaGRzxO1jO2tORdDahg6xjlhkcABq7m45eujXkzw2Xq8" +
       "hmhLXazpCKGBYYOuq2b7nK2RwQRFxnbFZMguu3GH7bLvYlCfm3DuvIv4RF3N" +
       "axzBVzAfTQdYA4NqFcPn2CQrGz6ktqOGyS2oZaijG86pZvFKplAP5xrZisvy" +
       "NuHmHOxFTK6hY3giNMbGtDPvqJJF0xBFmc2uZviUq/eJQKX49UJV+2SYZzoV" +
       "eGNxRg2o1cbmLLaXD3hFI9uNSjvXZGxSnvWEpe1mM7kajr31iILm/mQxT6g8" +
       "ZJBO1yHX0mJlVdX6ZJWKuei0R9WGvAY9iA1L8/WKtnS1bNHt1kadrxNjAQl2" +
       "PGHcfnWE4PBITccKhU6D2ZyxakxoN+ZwQxchn1alARb2m1BZIysopjT6IZ4F" +
       "PD+csmJrMposzAlp1nsRNe1WBYqksc18asVdtbWarsiOM4yQ+ipskDwD4bhI" +
       "11l8plT8lTSotbsbeqC2hkkNz3RfpKRlvWvO/IwiFnXd8OPumrPnZDMUmoFj" +
       "rVth2J11okiZUWNXbs9aZpOiGavCuk1o0WxVebVW8wYRTGvlBT/gIq2hOjU4" +
       "7db0BKsYZjG59IEPFNNOn7ux6bD7tzN/BzuXTBsrIl65gRmvXdQTRfDeg1nW" +
       "7e/O0rHdLkdmWY+sjp7Zn2V8/3VNnG7XoujixpENH8Xy1ruvtadpu7T12Rde" +
       "flXpf65ydm9hmo1L98Se/7dsda3aR9A8AEp65trLeNx2S9fhgunvvPA/H5n8" +
       "+OqjN7AN5LFjOI8X+Y+4L3yt+z75F86WbjtYPr1qs9mVmZ67ctH0XKjGSehO" +
       "rlg6ffeBOA8WWrwHHB/eE+fDx6fAD+U/");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ef77qZ35nLLu/5VT4r5aBL8Vly7oajw+uoK6ndo/tLovv9E869GCtzdeu3K7" +
       "SbH2oO1x1G4NxzOHCZhtgq+dQvTrRfBvANHoGNETZ5rXnqEckv/tmyB/ILC/" +
       "R96/9QL/wSlxf1gE/3EncOeqVdhDjt+4FQJ/fI/jx98kgf/4FKL/vQi+uRP4" +
       "KqL/7pDot25WzIvgeHGP6Iu3XszvnRL3v4rgO6CnAGL2r163PiT5pzerZrES" +
       "9yt7JH/lTVLzr05h+tdF8JeAaXQS0yNy/uBm5XwWHF/cY/rFWy7nmbtPiTtX" +
       "BLfFpXcCOQfXXuo/IHvm9puVlQbHa3tkX3tzZD3ztlMYP1QE5wHj6DTGh/Ke" +
       "uXATjLeDn8fB8dU9xl+99fI+fkrck0XwI3HpPJBXOLJLokhrHVJ8182KioDj" +
       "23sUv33LRbW2XJ49heelIvhRwDO6mucRKZ+6WSmLXvTP93j++a2XsnFKXLGK" +
       "fAaJSw8AKdsn7CA5ZIneAs975uFd3t35TVDztGogi+CDgGp0ItUjgr7hdrI3" +
       "cr3vBaAu7lG9eOsFHZwSNyqC3k7Qzgm7bg5Zsjcr6HMAMLLHErnlgu587k+c" +
       "QvUjRTDbCXoC1SOCzm9W0KcBqL28u/OtFXR1SpxZBMWeaiBo9xo7lQ6ZKjcr" +
       "KlEqdl3umLJvkqjxKXTXReAButE16R4R1r8Juo8UN58qdvns0Z3eemE/cUrc" +
       "C0Xwsbh0X9FSr2T4qUOGP3mzgr4fgL28x/DyLRf0U1sqf+cUmi8VwYuAZnQV" +
       "zSNCfvJGaGagtCu/xSk+LHj4qo8Cdx+yyV989fzd73hV+M/bz1EOPja7hy3d" +
       "rSW2fXQf+JHrO8GLtGZs6d+z2xXub+m8Epeeut69d3HpNhAW8M+8vMv9mbh0" +
       "8Xpyx6U7tuejef9+XHr09Lwg1/Z8NNercenha+UC+EB4NPU/iEtvOyk1SAnC" +
       "oyk/C15Ij6cEz9+ej6b79bh07jBdXLpzd3E0yedB6SBJcfmPd3tdr9wNuNvm" +
       "n+2m8B4+aurbF6UH3sh0DrIc/QqnqILtx6b7E2TJ7nPTy/KXXmX4j32//rnd" +
       "V0CyLeV5UcrdbOmu3QdJ20KLSbYnrlnafll3Uk//8L7fvOe9+xOC9+0AHza7" +
       "I9geO/mTm47jx9uPZPLfesc/+7Fff/WPtpsT/x+0vEcNBTwAAA==");
}
