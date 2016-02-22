package org.sunflow.core.shader;
public class ViewCausticsShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        state.
          faceforward(
            );
        state.
          initCausticSamples(
            );
        org.sunflow.image.Color lr =
          org.sunflow.image.Color.
          black(
            );
        for (org.sunflow.core.LightSample sample
              :
              state)
            lr.
              madd(
                sample.
                  dot(
                    state.
                      getNormal(
                        )),
                sample.
                  getDiffuseRadiance(
                    ));
        return lr.
          mul(
            1.0F /
              (float)
                java.lang.Math.
                  PI);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public ViewCausticsShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO39/5WwndhI3cb6cSE7Tu6Y0QOUQkrh24/Sc" +
       "nOI0Agdymdub8228t7vZnbPPDoa2gGIqEUWt0wbamn9SUVDbRIUKEDQKqkRb" +
       "tSC1qmgLaooEEuEjohFS+0eA8t7M7u3e3tlRED1pZ/dm37yvee/33uwzV0mN" +
       "bZFupvMonzKZHR3QeYJaNkv3a9S2D8JcUnmsiv7zyJV9d4VJ7ShZkqX2sEJt" +
       "NqgyLW2PktWqbnOqK8zex1gaVyQsZjNrgnLV0EdJh2oP5UxNVVQ+bKQZEhyi" +
       "Vpy0Uc4tNZXnbMhhwMnqOGgSE5rEdgVf98VJs2KYUx75Ch95v+8NUuY8WTYn" +
       "rfFjdILG8lzVYnHV5n0Fi9xqGtrUmGbwKCvw6DFtm+OCvfFtZS5YfyHy4fXT" +
       "2VbhgqVU1w0uzLMPMNvQJlg6TiLe7IDGcvZx8lVSFSdNPmJOeuKu0BgIjYFQ" +
       "11qPCrRvYXo+128Ic7jLqdZUUCFO1pUyMalFcw6bhNAZONRzx3axGKxdW7RW" +
       "Wllm4plbY3OPHWl9vopERklE1UdQHQWU4CBkFBzKcilm2bvSaZYeJW06bPYI" +
       "s1SqqdPOTrfb6phOeR6233ULTuZNZgmZnq9gH8E2K69wwyqalxEB5fyryWh0" +
       "DGzt9GyVFg7iPBjYqIJiVoZC3DlLqsdVPc3JmuCKoo099wIBLK3LMZ41iqKq" +
       "dQoTpF2GiEb1sdgIhJ4+BqQ1BgSgxUnXgkzR1yZVxukYS2JEBugS8hVQNQhH" +
       "4BJOOoJkghPsUldgl3z7c3Xf9lMn9D16mIRA5zRTNNS/CRZ1BxYdYBlmMcgD" +
       "ubB5c/xR2vnibJgQIO4IEEuan3zl2s4t3ZdekTS3VKDZnzrGFJ5UzqWWvLGq" +
       "v/euKlSj3jRsFTe/xHKRZQnnTV/BBITpLHLEl1H35aUDv/ri/T9kfwuTxiFS" +
       "qxhaPgdx1KYYOVPVmHUP05lFOUsPkQamp/vF+yFSB89xVWdydn8mYzM+RKo1" +
       "MVVriP/gogywQBc1wrOqZwz32aQ8K54LJiGkDi6yFa5GIn/izsnhWNbIsRhV" +
       "qK7qRixhGWi/HQPESYFvszE7r2c0YzJmW0rMsMaK/xXDYjE7S9PMih1S2WQ/" +
       "zduQSPaImIpikJmfLPsCWrd0MhQCx68Kpr0GGbPH0IA2qczldw9cey75mgwp" +
       "TAPHL5xsBplRR2YUZUalzGi5TBIKCVHLULbcX9idcchzANrm3pEv7z06u74K" +
       "AsucrAbXIun6koLT74GBi+BJ5Xx7y/S6y1tfCpPqOGmnCs9TDevHLmsMkEkZ" +
       "d5K3OQWlyKsIa30VAUuZZSgsDYC0UGVwuNQbE8zCeU6W+Ti49QozM7Zwtaio" +
       "P7l0dvKBQ1+7PUzCpUUARdYAfuHyBEJ3EaJ7gslfiW/k5JUPzz86Y3gwUFJV" +
       "3GJYthJtWB8MhqB7ksrmtfSF5IszPcLtDQDTnEJaAQJ2B2WUoEyfi9hoSz0Y" +
       "nDGsHNXwlevjRp61jElvRkRpGw4dMmAxhAIKCrD/3Ij55Du/+cunhCfduhDx" +
       "FfQRxvt8WITM2gXqtHkRedBiDOjeO5t45MzVk4dFOALFhkoCe3DsBwyC3QEP" +
       "fvOV4+++f/ncW2EvhDkU43wKepqCsGXZx/ALwfUfvBA/cELiSHu/A2Zri2hm" +
       "ouRNnm6AaxokPwZHz306hKGaUWlKY5g//4ps3PrC30+1yu3WYMaNli03ZuDN" +
       "r9xN7n/tyEfdgk1Iwbrq+c8jk2C91OO8y7LoFOpReODN1d95mT4JsA9Qa6vT" +
       "TKAnEf4gYgO3CV/cLsY7A+8+g8NG2x/jpWnk63+Syum3Pmg59MHFa0Lb0gbK" +
       "v+/D1OyTUSR3AYTdQZyhBM3xbaeJ4/IC6LA8CFR7qJ0FZnde2velVu3SdRA7" +
       "CmIVaC3s/RYgXKEklBzqmrrf/fKlzqNvVJHwIGnUDJoepCLhSANEOrOzALIF" +
       "8/M7pR6T9TC0Cn+QMg+VTeAurKm8vwM5k4sdmf7p8h9v//78ZRGWpuRxi5/h" +
       "JjH24rBFhi0+3lYoOkv8ahdxlo9nSDyv4GR5WWGQVQAdu3qh7kV0XucenJtP" +
       "739qq+wx2ks7ggFoeJ/97b9fj579w6sVylEDN8zbNDbBNJ9OVSiypJIMi8bO" +
       "Q7P3ljz8x5/1jO2+mSKCc903KBP4fw0YsXnhohBU5eUH/9p1cEf26E3UgzUB" +
       "dwZZ/mD4mVfv2aQ8HBZdrCwFZd1v6aI+v2NBqMWgXdfRTJxpEdm0oRggSzEe" +
       "VsLV5ARIUzCbJHCLaMNhoLi02o2nhZYGwCIsdjTsRll3WZQJ1zBoxjH2XbJO" +
       "P9mIvO9KDAm1vrAIHB3BYQRQPG+mAZFLOxIMkJF8yobuQc1BRZlw+ug7EkeV" +
       "2Z7En2T8rqywQNJ1PB379qG3j70udroeQ6voX19YQQj66mArDlHMod5FTqWl" +
       "+sRm2t8ff+LKs1Kf4CEgQMxm5x76OHpqTuaWPCltKDus+NfI01JAu3WLSREr" +
       "Bv98fubnT8+cDDuuvpeTupRhaIzqxa0IFRvBZaVelLre/a3IL063Vw1C1g6R" +
       "+ryuHs+zoXRp5NbZ+ZTPrd7hyotjR2ssxZyENrsY+VkcDsrn7f8jPOPEblPM" +
       "7y+GfBu+WwVXxAn5yM1ny0JLA7EcKsXk1RUxGU6weIZnQuzkItlwAgdo8ZrG" +
       "GD8A68THnEpwr+bgKIvVyDm1C1fan4ArBVjsgKvL8UfXzbtyoaWVgQf/CqYz" +
       "YpxdxF0P4fB1TlpshXIApETW4A6OK06i4G2Mk+oJQ017nvrG/8NTBWgpy89g" +
       "2DCsKPvCI79KKM/NR+qXz9/3tqiCxS8HzQBOmbym+ZLKn2C1psUyqjC4WTZZ" +
       "pridqdQCyLMh4Kl8ELrPSfqznLQG6cEzePOTPQ7h5yPjmODiyU80z0kVEOHj" +
       "90w3QltFn4SfbaLyG0UhVN4LCf933Mj/xSX+gwHCsPjE5uJUXn5kgyPq/N59" +
       "J659+il5MFE0Oj2NXJoAneTxp1jJ1y3IzeVVu6f3+pILDRtd2Cw5GPl1E1EA" +
       "uS8OEV2BTt3uKTbs757bfvHXs7VvAuAfJiHKydLDvg9c0lPQ7uehhTocL0dh" +
       "6HrEEaKv97tTO7Zk/vF70WY6qL1qYfqkMvrIO0MXxj/aKb7p1EBFYIVR0qja" +
       "d0/pB5gyYZVA+hKMRoof24QfHPe1FGfxhMrJ+vJCVX6uhxZ8klm7jbyedopC" +
       "kzdT8q3PbX7yphlY4M34avO4TGr0PsRfMj5smu7x7qIpslILArOYFIufF484" +
       "/Oi/wEA2Sm0XAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/AIm/aP7/uD1v/v8N/Mi8P8BKXUfz0IiAAA=");
}
