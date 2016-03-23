package org.sunflow.core.shader;
public class DiffuseShader implements org.sunflow.core.Shader {
    private org.sunflow.image.Color diff;
    public DiffuseShader() { super();
                             diff = org.sunflow.image.Color.WHITE; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        diff =
          pl.
            getColor(
              "diffuse",
              diff);
        return true;
    }
    public org.sunflow.image.Color getDiffuse(org.sunflow.core.ShadingState state) {
        return diff;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            getDiffuse(
              state));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                state.
                  getRay(
                    ).
                  getDirection(
                    )) >
              0.0) {
            state.
              getNormal(
                ).
              negate(
                );
            state.
              getGeoNormal(
                ).
              negate(
                );
        }
        diffuse =
          getDiffuse(
            state);
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            diffuse);
        float avg =
          diffuse.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avg) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  avg);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avg;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0 -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jWOjIpEvnxrNAnxz/rlNTez/3T8KTM5xrEiREeAfiJ55eF73uvc5vwsoyN2e" +
       "K0xNAMou782nM38Pt5X/JEwqBkiDbJe9OyU1i2E6AKWe5dTCUBr75v1lm6hR" +
       "OvOAuSAIZp5lg1DmpkToIzX26wLoxWuDFnjq7MCuC6JXiPBOL2e5gbcrsLnR" +
       "AYsKw1TgakQDaFEzjVAG+kAm5gxzGGnxpmslA9UlepFuCuDE9lPYbBErdBZz" +
       "UzF1AzYr8/vgv/JgJeRFLa8fFtsMrx1EtYDBuHCqYpYX4qf2Hz2Z3PboauGp" +
       "Tf4CcRPcf5741b9fjZz47ctFKpYqphs3qnSEqp49leKSvtjo43W+62jvzjj8" +
       "+x+0D224lmIDx1qvUk7g/0WgxIqpwy24lRf3/3nejnXpPddQNywKmDMo8jt9" +
       "Z16+fZl8OMwvNSICCi5DfqZOv99XmxRub9oOn/cvzTvITPSHuU7HeRfm7iK+" +
       "lc+IU7EGckeYn2jY8bLWAi/jpqFwN0O8dMiavWT94t0V7+XbGpomO2WwSUAi" +
       "zxpJCE1/5YoO0p9NWFBlKhkoKkbsa9XN8T3yZHv8D8J/5xZhEHSzH49+fedb" +
       "e1/lJ12JrpW3r8etwAU99VKDMNzH8AvB8x98cLc4IK4nTd32HWlx/pKEmWJa" +
       "yA8oEJ1oem/44YtPCAWC+B4gppNHv/px5OBREYzipr204LLr5RG3baEONhwS" +
       "lky3Cufo+ePZiWcfnzgQts9mACAzoesqlbT82YXyuXCW3+xirxvvr//RoaaS" +
       "HgjzXlKZ1ZR9Wdqb9Lt6hZVNeM7BvZy7jm/vGm3OSGiFk4g5uMrTgOv/UAPg" +
       "QJfBx3fnY6QR5+YTUR4T531t4TUVa8D5Q34QX1gUxBUNUREyFVJNThM+X8Pm" +
       "Pkaqhyizr4w4EnfN9eXrZa4F9uP0r9FcU7EWNxf+vZ9LPT6NNR7E5jAjNWCN" +
       "7WBFJ4l4zHHkOpiDX6zWwdNh69Rx7eaYirU4OHNzcM246FPT2OTb2HyTkTpL" +
       "lhiAdjytMzvXMRsb8JWDSmdEV5Kupb71/7AUiK3zfcrAGnxOwfdQ8Q1PfvJk" +
       "fWXLyTvf4kVC/jtbLWB3Kquq3irR0y83TJpSuK61omY0+Ou7xSok8XUF0o3o" +
       "8G2fE/RPMdIQpAej4MtL9gy4l4eMIZzxnpfoh4yUABF2nzWcUG/gVw+sliOi" +
       "Ws6FPCUU8UDc7KuZPs/ivTpj0uEfpB1UzopP0oPy2ZNbtt51+ZOPiqu7rErj" +
       "4yilBrBYfEXIFzpLppTmyCrfvPzKjHNVHU6SaBQbdj18vsf5uiB0DTzyeYF7" +
       "rdWev96+c2rt8z+bLH8D0tsuEpIYmbmr8F6RM7JQYe6KFeYcKAr5hbtz+UNj" +
       "61al/vobfnMjBfe1ID3cm4683Xtu+KP1/AtoGeQ/muMXno1j2nYqj5i+BDYD" +
       "vVHCT9PcDrb56vKj+KGHkbbCtFz4eQxutaPU3KBntaSdAmvcEd+XcdvDq7OG" +
       "EWBwRzyly90intH64H+DsT7DcKqWCYMH5EQxXJ3gzK/xLjY//y84OOrlmxoA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALU6aczsVnV+X96S97K8lwSSELLzQpsM/TyLZ2tYYs8+Hi8z" +
       "Y49n3MLD+3jG+za2acoiUVBRUwSBUhWiqgJBUVhUFYGEQKFVCwhUiQp1kwqo" +
       "qlRaikR+lFalLb32fPt7eTQKHcnX19fnnHvOueece3zPPPtD6IzvQQXHNhLN" +
       "sINdJQ52V0Z1N0gcxd8djqq04PmK3DIE32fA2BXp4c9e/PFP3ru8tAOd5aE7" +
       "BMuyAyHQbcufKL5tRIo8gi4ejnYMxfQD6NJoJUQCHAa6AY90P3h8BN10BDWA" +
       "Lo/2WYABCzBgAc5ZgNFDKIB0i2KFZivDEKzAd6Ffh06NoLOOlLEXQA8dJ+II" +
       "nmDukaFzCQCFG7PnGRAqR4496MED2bcyXyXwBwrw07/zpkt/dAN0kYcu6tY0" +
       "Y0cCTARgEh662VRMUfF8VJYVmYdusxRFniqeLhh6mvPNQ7f7umYJQegpB0rK" +
       "BkNH8fI5DzV3s5TJ5oVSYHsH4qm6Ysj7T2dUQ9CArHceyrqVsJuNAwEv6IAx" +
       "TxUkZR/l9Fq35AB64CTGgYyXcQAAUM+ZSrC0D6Y6bQlgALp9u3aGYGnwNPB0" +
       "SwOgZ+wQzBJA97wg0UzXjiCtBU25EkB3n4Sjt68A1PlcERlKAL38JFhOCazS" +
       "PSdW6cj6/JB87VNvsfrWTs6zrEhGxv+NAOn+E0gTRVU8xZKULeLNj40+KNz5" +
       "pXfvQBAAfvkJ4C3M53/t+Sdec/9zX9vCvPIaMJS4UqTgivRR8dZv3dt6tHlD" +
       "xsaNju3r2eIfkzw3f3rvzeOxAzzvzgOK2cvd/ZfPTf588bZPKj/YgS4MoLOS" +
       "bYQmsKPbJNt0dEPxeoqleEKgyAPovGLJrfz9ADoH+iPdUrajlKr6SjCAThv5" +
       "0Fk7fwYqUgGJTEXnQF+3VHu/7wjBMu/HDgRB58AFvQZcN0PbX34PoDG8tE0F" +
       "dnSY9uxMdB9WrEAEal3Cfmiphr2BfU+CbU87eJZsT4H9pSArHtzWVTX0lWn+" +
       "tJuZlvP/QTTOJLm0OXUKKPneky5uAO/o2waAvSI9HWKd5z995Rs7Bya/p4MA" +
       "egRMt7s33W423e52ut1j00GnTuWzvCybdruMYBHWwJ1BoLv50ekbh29+98M3" +
       "APtxNqeBBjNQ+IXjbeswAAzyMCcBK4Se+9Dm7bO3FnegneOBM2MVDF3I0Oks" +
       "3B2EtcsnHeZadC++6/s//swHn7QPXedYJN7z6KsxM498+KRSPVtSZBDjDsk/" +
       "9qDwuStfevLyDnQauDkIbYEATBFEjftPznHMMx/fj3KZLGeAwKrtmYKRvdoP" +
       "TReCpWdvDkfy1b41798GdHxTZqp3g+vinu3m9+ztHU7WvmxrHdminZAij6Kv" +
       "mzof+Zu/+OdKru79gHvxyBY2VYLHjzh5Ruxi7s63HdoA4ykKgPv7D9Hv/8AP" +
       "3/UruQEAiFdda8LLWdsCzg2WEKj5nV9z//a73/not3cOjSYAu1woGroUHwiZ" +
       "jUMXriMkmO3Vh/yAIGEAx8qs5jJrmbasq7ogGkpmpf918ZHS5/71qUtbOzDA" +
       "yL4ZveZnEzgcfwUGve0bb/r3+3Myp6RskzrU2SHYNvLdcUgZ9TwhyfiI3/6X" +
       "9/3uV4WPgBgK4pavp0oeiqBcB1C+aHAu/2N5u3viXSlrHvCPGv9x/zqSTFyR" +
       "3vvtH90y+9GXn8+5PZ6NHF1rQnAe35pX1jwYA/J3nfT0vuAvARzyHPmrl4zn" +
       "fgIo8oCiBLZgn/JAiIiPWcYe9Jlzf/eVP73zzd+6AdrpQhcMW5C7Qu5k0Hlg" +
       "3Yq/BAEqdt7wxHZxNzeC5lIuKnSV8FujuDt/Og0YfPSF40s3SyYOXfTu/6QM" +
       "8R3/8B9XKSGPLNfYQ0/g8/CzH76n9fof5PiHLp5h3x9fHXlB4nWIW/6k+W87" +
       "D5/9sx3oHA9dkvayuplghJnj8CCT8fdTPZD5HXt/PCvZbsGPH4Swe0+GlyPT" +
       "ngwuhxEf9DPorH/hRDzJt767wHXLnqvdcjKenILyzhtylIfy9nLW/MK++55z" +
       "PD0CW/ae//4U/E6B63+yKyOWDWw32Ntbe7v8gwfbvAM2o9PA39Qc+eUBdNfR" +
       "nUk3QSKVuaftbcNa1paz5ontbNUXNKJfzpp2fAoweKa8W98tZs/4tYW4Iev+" +
       "IghEfp4AAwxVtwQjV1UbsLQypMv7rM9AQgys6PLKqO+zfCl3gGy9drdZ5Ale" +
       "2/9nXoGB33pIbGSDhPQ9//jeb/72q74LrHAInYkyCwHGd2RGMsxy9N949gP3" +
       "3fT0996Tx1WwKtMn3mm/LaM6u57EWUNlDb0v6j2ZqFM79CRlJPgBkYdCRc6l" +
       "va7z0Z5ugh0j2ktA4Sdv/+76w9//1Da5POlpJ4CVdz/9mz/dferpnSMp/auu" +
       "yqqP4mzT+pzpW/Y07EEPXW+WHKP7T5958oufePJdW65uP56gdsD316f+6r+/" +
       "ufuh7339GhnTacN+CQsb3PqyPuIP0P3faLZQeZSdxPOookYFZFVDqRShKao6" +
       "aPB9uTMgYnmhSVisUHWij3cEu2H0yHIQyeWQNPmFIFbEsDAtIhNbEnvsWMdQ" +
       "VrNqWNqbDLRe4OCjnjPCpqY7ni6SWW9d1rtcz50J+JjgeWNh+2IlNOUybYnR" +
       "uuXxbmg59Xk9kkV4XocrSi01Up2f8EPTNHp2uCEWpLBmi4JeDM0JT8suaKky" +
       "5rPtqjKISkGzwQUBMhsWxi1+zQs+bZiJMGi2SsK4NMYWrumza0YQudnaZRKs" +
       "U3HZOdlZrJ1wxaO8HnBigx93Z8ZSnbvTgd+lkkUymdjrmC0a655SLmFMKyHQ" +
       "RV1XcXkyClvFajFm9ciLneWI9uV2JSzzY8klwqrYnXZI30vH+kQkCVYg4pjD" +
       "ZYqnfLI/KYmd1YxbMCbXm0ahvyhveHFhagMmGJY9GG7j9nzcJhtdYiqTxTjg" +
       "0sAgR7OibBNr0a3IXRL3S4tCQ5tPWZMo9fVBjzNpahH0FnLHHlGOXSuNsHoY" +
       "2oZfKtZKG7m61lyyzEidFjmCwaIm/DgJHA2ppOTA7U3LdWfDB92yVCrxNie0" +
       "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" +
       "iOkX7vrj1378me/k5/z/CwNGwpPjJAAA");
}
