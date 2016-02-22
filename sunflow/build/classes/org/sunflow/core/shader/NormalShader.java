package org.sunflow.core.shader;
public class NormalShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        org.sunflow.math.Vector3 n =
          state.
          getNormal(
            );
        if (n ==
              null)
            return org.sunflow.image.Color.
                     BLACK;
        float r =
          (n.
             x +
             1) *
          0.5F;
        float g =
          (n.
             y +
             1) *
          0.5F;
        float b =
          (n.
             z +
             1) *
          0.5F;
        return new org.sunflow.image.Color(
          r,
          g,
          b);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public NormalShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "FwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6e+zsaFW9v/u++7h3d2F3WffNBV2Kv7Yz03nkIm7n0XY6" +
       "nU7n1c5U5NL3Y/qaPmY6xVVYo7uRiASWVwL7h4IKWR4xEk0MZo1RIBATDFE0" +
       "EYgxEUUS9g/RiIpt5/e+9y7ZgJPMN1+/75zznXO+c07Pd7554bvA2TAAQN+z" +
       "N7rtRbtqEu1aNrobbXw13KVolBWDUFVathiGk2zsuvz4Zy9//wfvMa7sAOcE" +
       "4B7Rdb1IjEzPDUdq6NkrVaGBy4ejHVt1wgi4QlviSoTiyLQh2gyjazRw2xHU" +
       "CLhK77MAZSxAGQtQwQKEHUJlSHeobuy0cgzRjcIl8MvAKRo458s5exHw2HEi" +
       "vhiIzh4ZtpAgo3Ahf+YyoQrkJAAePZB9K/MNAr8fhJ774Fuv/MFp4LIAXDbd" +
       "cc6OnDERZYsIwO2O6khqEGKKoioCcJerqspYDUzRNtOCbwG4OzR1V4ziQD1Q" +
       "Uj4Y+2pQrHmoudvlXLYgliMvOBBPM1Vb2X86q9minsl676GsWwnxfDwT8JKZ" +
       "MRZooqzuo5xZmK4SAY+cxDiQ8WovA8hQzztqZHgHS51xxWwAuHu7d7bo6tA4" +
       "CkxXz0DPenG2SgQ8cEuiua59UV6Iuno9Au4/CcdupzKoi4UicpQIePVJsIJS" +
       "tksPnNilI/vzXeZN7367S7o7Bc+KKts5/xcypIdPII1UTQ1UV1a3iLe/gf6A" +
       "eO/nn90BgAz41SeAtzB/9EsvPfnGh1/84hbmp24CM5AsVY6uyx+T7vzqg60n" +
       "GqdzNi74Xmjmm39M8sL82b2Za4mfed69BxTzyd39yRdHfzl/xyfV7+wAl7rA" +
       "OdmzYyezo7tkz/FNWw0I1VUDMVKVLnBRdZVWMd8Fzmd92nTV7ehA00I16gJn" +
       "7GLonFc8ZyrSMhK5is5nfdPVvP2+L0ZG0U98AADOZ18AzL6XgO2n+I2AKWR4" +
       "jgqJsuiargexgZfLH0KqG0mZbg0ojF3N9tZQGMiQF+gHz7IXqFBoiIoaQIwX" +
       "OKI9Lh52c/Py/78IJ7lEV9anTmXKfvCkq9uZl5CencFel5+Lm52XPn39yzsH" +
       "pr+niyw4Zavt7q22m6+2u11t9+hqwKlTxSKvylfd7ma2F4vMq7N4d/sT41+k" +
       "3vbs46czM/LXZzJF5qDQrcNu6zAOdItoJ2fGCLz4ofU7uV+Bd4Cd4/Ez5zQb" +
       "upSjs3nUO4huV0/6zc3oXn7m29//zAee8g496FhA3nPsGzFzx3z8pE4DT1aV" +
       "LNQdkn/Do+Lnrn/+qas7wJnM27MIF4mZRWbB4+GTaxxz0Gv7wS6X5WwmsFZo" +
       "O5/aj1CXIiPw1ocjxWbfWfTvynT8RmCvOWbC+ew9ft6+amsc+aadkKIIpj83" +
       "9j/69b/6l3Kh7v24e/nIm2ysRteO+HpO7HLh1Xcd2sAkUNUM7h8+xL7v/d99" +
       "5hcKA8ggXnuzBa/mbSvz8WwLMzX/2heXf/fNb3zsazuHRhNlL7tYsk052Qr5" +
       "w+xzKvv+b/7NhcsHtn56d2svWDx6EC38fOXXH/KWxQ07c7Hcgq5OXcdTTM0U" +
       "JVvNLfa/L78O+dy/vfvK1ibsbGTfpN74owkcjr+mCbzjy2/9j4cLMqfk/L11" +
       "qL9DsG0wvOeQMhYE4ibnI3nnXz/04S+IH83CahbKQjNVi+gEFPoAig2EC12A" +
       "RQudmCvlzSPhUUc47mtH8ovr8nu+9r07uO/96UsFt8cTlKP73hf9a1tTy5tH" +
       "k4z8fSe9nhRDI4OrvMi85Yr94g8yikJGUc7eyuEgyMJFcsxK9qDPnv/7P/vz" +
       "e9/21dPADg5csj1RwcXC4YCLmaWroZHFqsT/+Se31ry+kDVXClGBG4TfGsj9" +
       "xdPpjMEnbh1r8Dy/OHTX+/9rYEtP/+N/3qCEIsrc5LV6Al+AXvjIA603f6fA" +
       "P3T3HPvh5MYgnOVih7ilTzr/vvP4ub/YAc4LwBV5L9HjRDvOnUjIkptwP/vL" +
       "ksFj88cTle1b+dpBOHvwZKg5suzJQHMY/LN+Dp33Lx1u+BPJqcwRz5Z2a7tw" +
       "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" +
       "OtD8PbmiX5N9b9vT/G03L+fe1EpOFVaytY0T9cKdAmBnf68evmGvCj2okRrk" +
       "Bcl9sHuPgo23vxjbLVaIXqYimeaNFwHnYl8Ro23henTEErkIOJ/l87YquodW" +
       "6v+omsDRVYoB+0BthdE+mH0v76nt8k9GbaeOm/hDNzVx09Xz+1K1oPDMy6jl" +
       "XXnzdATcpqvRKMPLzeOm3mM6oq7mlee9G9JCP7/6Y+insKI375nWvon95Mwq" +
       "f3w2b36zgPrgy+jgw3nz3gi4I5TFKDM31vCiPZc8YSFnVp6pHIr/vlcifhIB" +
       "tx+9uMor7/ffcAm+vbiVP/385Qv3PT/92+Lu5uBy9SINXNBi2z5aKD3SP+cH" +
       "qmYWIl3clk394ud3bhYIt1dpeZm06BTs/vYW/ncj4MpJ+Ez2/Oco2CcyqzkC" +
       "lvnPXu8o0AsRcDoDyruf8m9SY90WjJNTR0LqnqUUGr77R2n4AOXo3U4ehot/" +
       "IeyHzHj7P4Tr8meep5i3v1T9+PZuSbbFtIgLF2jg/Paa6yDsPnZLavu0zpFP" +
       "/ODOz1583f4r4s4tw4dWe4S3R25+edNx/Ki4bkn/+L4/fNPvPf+NouT7f1Ll" +
       "37seIgAA");
}
