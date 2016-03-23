package org.sunflow.core;
public final class IntersectionState {
    private static final int MAX_STACK_SIZE = 64;
    float u;
    float v;
    org.sunflow.core.Instance instance;
    int id;
    private final org.sunflow.core.IntersectionState.StackNode[] stack;
    private final float[] rstack;
    org.sunflow.core.Instance current;
    public static final class StackNode {
        public int node;
        public float near;
        public float far;
        public StackNode() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1457076400000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAK1YfWwUxxWfO3/gL7Ax+AMCBIyJauLehTQ0jUxTwNjF5Gyf" +
                                                                  "MKGtCZi5vTl78d7usjtrn53SBqQIp1IRVQghEfAXUSKUBFQlaqU2kauobaqk" +
                                                                  "lZKmTdKqpKoqlSpFDaqaVKVt+t7M7u3H+UCVetLNzc2+mXkfv/m9N/v8NVJl" +
                                                                  "W2QN03mCz5jMTvTpPE0tm2V7NWrbe2BsTHmygv7twNWh++KkepQsmaD2oEJt" +
                                                                  "1q8yLWuPktWqbnOqK8weYiyLM9IWs5k1Rblq6KOkRbUH8qamKiofNLIMBfZS" +
                                                                  "K0WWUs4tNeNwNuAuwMnqFGiSFJokt0Uf96RIg2KYM754e0C8N/AEJfP+XjYn" +
                                                                  "TalDdIomHa5qyZRq856CRe40DW1mXDN4ghV44pC22XXBrtTmEhd0XG78+MbJ" +
                                                                  "iSbhgmVU1w0uzLN3M9vQplg2RRr90T6N5e3D5BukIkXqA8KcdKa8TZOwaRI2" +
                                                                  "9az1pUD7xUx38r2GMId7K1WbCirEybrwIia1aN5dJi10hhVquGu7mAzWri1a" +
                                                                  "K60sMfGJO5OnnjzQ9N0K0jhKGlV9BNVRQAkOm4yCQ1k+wyx7WzbLsqNkqQ7B" +
                                                                  "HmGWSjV11o10s62O65Q7EH7PLTjomMwSe/q+gjiCbZajcMMqmpcTgHL/VeU0" +
                                                                  "Og62tvq2Sgv7cRwMrFNBMStHAXfulMpJVc9ycnt0RtHGzgdAAKYuyjM+YRS3" +
                                                                  "qtQpDJBmCRGN6uPJEYCePg6iVQYA0OJkZdlF0dcmVSbpOBtDREbk0vIRSNUK" +
                                                                  "R+AUTlqiYmIliNLKSJQC8bk2tOXEw/pOPU5ioHOWKRrqXw+T1kQm7WY5ZjE4" +
                                                                  "B3Jiw8bUadr6ylycEBBuiQhLme99/frW7jXzr0uZ2xaQGc4cYgofUy5klry1" +
                                                                  "qrfrvgpUo8Y0bBWDH7JcnLK0+6SnYALDtBZXxIcJ7+H87p987ZGL7MM4qRsg" +
                                                                  "1YqhOXnA0VLFyJuqxqwvM51ZlLPsAKllerZXPB8gi6CfUnUmR4dzOZvxAVKp" +
                                                                  "iaFqQ/wHF+VgCXRRHfRVPWd4fZPyCdEvmISQdviS1fBtIfIjfjkZSk4YeZY0" +
                                                                  "1WTaMtB0OwlkkwG3TiRtR89pxnTStpSkYY0X/yuGxZIDiEsbJoB9eIZYAnFl" +
                                                                  "/t9XLKANy6ZjMXDvqujh1uBc7DS0LLPGlFPO9r7rL469IYGDYHet56Qb9kq4" +
                                                                  "eyVwr0TJXp3QKpNDwKYkFhObLcfdZRwhCpNwnoFQG7pG9u86ONdRAQAypyvB" +
                                                                  "hSjaEUosvf6h95h6TLnUvHh23ZVNr8VJZYo0U4U7VMM8sc0aFzu7h7QhAynH" +
                                                                  "Z/61AebHlGUZCssC8ZTLAO4qNcYUs3Cck+WBFby8hCcwWT4rLKg/mT8zfXTv" +
                                                                  "N++Kk3iY7HHLKuApnJ5Gii5ScWf0kC+0buPxqx9fOn3E8I97KHt4Sa9kJtrQ" +
                                                                  "EYVD1D1jysa19OWxV450CrfXAh1zCscHmG5NdI8Qm/R4zIy21IDBOcPKUw0f" +
                                                                  "eT6u4xOWMe2PCJwuxaZFQhYhFFFQkPoXR8xz7/3iz58TnvT4vzGQuEcY7wlw" +
                                                                  "Di7WLNhlqY/IPRZjIPe7M+nHn7h2fJ+AI0isX2jDTmx7gWsgOuDBR18//P4H" +
                                                                  "Vy68E/chzCHpOhmoXQrCluWfwicG3//gF3kCByRfNPe6pLW2yFom7nyHrxvw" +
                                                                  "lyZPlt35oA4wVHMqzWgMz8+/GjdsevkvJ5pkuDUY8dDSfesF/PEV28kjbxz4" +
                                                                  "ZI1YJqZg/vT954tJUl7mr7zNsugM6lE4+vbqp35KzwG9A6Xa6iwTLEmEP4gI" +
                                                                  "4Gbhi7tEe0/k2b3YbLCDGA8fo0CdM6acfOejxXs/evW60DZcKAXjPkjNHoki" +
                                                                  "GQXY7DPEbUKsjU9bTWzbCqBDW5SodlJ7Aha7Z37ooSZt/gZsOwrbKlBC2MMW" +
                                                                  "cGUhBCVXumrRb370WuvBtypIvJ/UaQbN9lNx4EgtIJ3ZE0CzBfNLW6Ue0zXQ" +
                                                                  "NAl/kBIPlQxgFG5fOL59eZOLiMx+v+2lLc+evyJgaco1bhPzK5D5QwwranL/" +
                                                                  "kF/85b2/evY7p6dlVu8qz2yRee3/HNYyx/7wj5K4CE5boOKIzB9NPn92Ze/9" +
                                                                  "H4r5Prng7M5CabYCgvbn3n0x//d4R/WP42TRKGlS3Bp4L9UcPNejUPfZXmEM" +
                                                                  "dXLoebiGkwVLT5E8V0WJLbBtlNb8LAl9lMb+4ggGG4lbPrS6GGyNYjBGRGeX" +
                                                                  "mHKHaLuw6Zbsgt3PForrIXLIkpusx0EvyFThvIq5a8TJ2JAD1Tzw4pRb9d2d" +
                                                                  "PqjMdab/KGO/YoEJUq7lueS397576E3BujWYZfd49gZyKGTjAJs3YZPAI3YT" +
                                                                  "TEX0SR5p/mDy7NUXpD5RAEWE2dypb32aOHFKsqGs69eXlNbBObK2j2i37ma7" +
                                                                  "iBn9f7p05AfPHTkutWoOV6l9cAl74df/fjNx5vc/W6B4qlDduxme6Fix5lke" +
                                                                  "drU0aMdjjT882VzRD+l2gNQ4unrYYQPZMNAW2U4m4Hv/vuCDzzUNsw4nsY1A" +
                                                                  "BzKjYvsFbB6QcNpSlo52hOG7Er5tLtzaysCXSvhiM1gK1nKzEazMrbzSbkTw" +
                                                                  "ZyTQ/wrHY2fQEjfi3/1R2zL/o20rvOre+13AtvxNbSs3G2Kfo4LOchEd9Zvo" +
                                                                  "WFiYBioEDUClYYsLN7pE1anm80Kl595yuS6QEgjCfnW5S6SA/IVjp85nh5/Z" +
                                                                  "FHdT9ldha/duH1yHk9pi5S8etHPScevrAmzfXvKmQd6OlRfPN9a0nX/wXVFz" +
                                                                  "Fm+wDUA7OUfTgpQb6FebFsupQtMGScAS9Mc4aYqqA5jDH6HuUSn2KCf1ATGO" +
                                                                  "p0z0gkJzEFAQwu5jpmdsk8jLmEoSMpUUYmFHF4PecitgBmKzPkSY4tWNRxaO" +
                                                                  "fHkDV6Lzu4Yevv75Z2QhrGh0dhZXqQeKkOV28Saxruxq3lrVO7tuLLlcu8GL" +
                                                                  "dqgQD+qG/e1w9ETRujJSGdqdxQLx/QtbXv35XPXbQIj7SIxysmxfadItmA7A" +
                                                                  "cF+qlAoh6YqStafr6Zn7u3N//a0oa1zqXFVeHoqKx98buDz5yVbxrqAKgMwK" +
                                                                  "ohrYMaPvZsqUFeLVJYguii9xhB9c9y0ujuKNCPBcmlJK75FQ8k0za7vh6FmX" +
                                                                  "mev9kdA7JBexdY5pRib4I4Es+pBkQvQ+4G8sNWia3nXiJVOc7P3lefGs6GJz" +
                                                                  "7r8RvrdLxRUAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "t/72C98sjhj+F5bN1elQHwAA");
    }
    public IntersectionState() { super();
                                 stack = (new org.sunflow.core.IntersectionState.StackNode[MAX_STACK_SIZE *
                                                                                             2]);
                                 for (int i =
                                        0;
                                      i <
                                        stack.
                                          length;
                                      i++)
                                     stack[i] =
                                       new org.sunflow.core.IntersectionState.StackNode(
                                         );
                                 rstack =
                                   (new float[53 *
                                                256]);
    }
    public final org.sunflow.core.IntersectionState.StackNode[] getStack() {
        return stack;
    }
    public final int getStackTop() { return current ==
                                       null
                                       ? 0
                                       : MAX_STACK_SIZE;
    }
    public final float[] getRobustStack() {
        return rstack;
    }
    public final boolean hit() { return instance !=
                                   null; }
    public final void setIntersection(int id,
                                      float u,
                                      float v) {
        instance =
          current;
        this.
          id =
          id;
        this.
          u =
          u;
        this.
          v =
          v;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "02G2zaEl4LPO1plKEyblvMpgDECtzbXaDtc9lbTpDqdW/bzNLdwYhzGdnGhG" +
       "IGOLFIiOH+he0OUqpNL1WaXjEzVksqkxusWgs0DDGn7HGTXMzaTthUrbS0jH" +
       "bjVrsLX1pwjtrvoB7khSiJFeB59Js2ENno2wZjKo2WS2NKntnFIsu1aZNNhY" +
       "UhB0MorY8SDMmbQq9LNQ3ckjhQ6sesvQhVaT28BMPLXyQF4zHdUeu/XU7k1l" +
       "B187wdTuWENNInbbcFqvLNIFuyQrUb0vDBQvowPVq+9Ykl01t0hiJ0uSUMfd" +
       "LrfbUolM01pdCEWqQrdsgmC2S5ZGBsOJGI4NIx+JVOYKRC5YbJ+oTKuGGIzN" +
       "pbMjzXp1TYiOn82EymjOLtWqiq1aVEsaos6mW1mIpom06Yo3VqY8PtjU8Kwz" +
       "EQdUtUm2OTQHy7Uo9evhDF8sW+Jg54/6yDzmR1mnJZgm3w2i4UgcDVVSVozZ" +
       "UnGj+VwVlv2VYQpVmByoi6RdQejxct1d29OkHrR2qTFt5e2lNRzMasx6wNv5" +
       "BMeqsbONHd7wYHZV2W77q3kz1PNsAOj3E1HMfVa0tIqZrirkVNeEea56K7Un" +
       "xskMNkPD8LZEpvlrIh023DAxUXvWqaz7Xi0fRNVeapDUltYFjKuZLNzY7DrY" +
       "GkFRHPfTtGsA/B1c6gyX/QjWV8tpTan1gUNy9N68MWqghE63YkxciAusMs5p" +
       "ZL4Ihc5WNqvMWCJaU8WumiNBaGmkyklYKFEU4Zga2zbmIevGVM7oKD+aSrLo" +
       "0WZM1Zx+Z+7SnfoizMgJjWl0TE/mTQOvEkzIzlgfb/Ym0jxUDL6X9FJadjaU" +
       "PA3T9gwb1pNGz4iNxMETrD4LW1HWm0x1t4WP5kpC010q1R28Vrd3GT1p+6vF" +
       "PMFaJFZHsaTRarCSIM25gY8u2zHqzrtUrb3t5FqrUt/6C8zN1nAtWs2aNanC" +
       "jzYEM0a2E1HgiQbbzNp9H8dWNXPkTDpzVgpmIbJpV2zFtHryZkrqycQJFxyd" +
       "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" +
       "T6byMydsfuf7ZbM4tEUdskn9cNi8cPE2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dZeK4kIE3bWyopvtzt6reJ6ty+4xyxcOvg+WS0/xbnBNDlme/ABZvuvEHZZf" +
       "Qcov9e8puXzsNhJ4oiiuRNDl4szoqS+kN92rTjxLOxHFI29EFBlwyTd8gS0O" +
       "hr35hnPY+7PD6hdevXzpiVen/2X/AfnofO99HHTJiG379DmeU/cX/UA3rFJA" +
       "9+1P9fglm89G0JXzX4QBQ8VfAfXCM/tmV4FVn2oGFODw7nSjtwN9AY2K2x/3" +
       "b/KZYn8+Kbtw1ucfG82jdxLbqTDx/Jlvu+XB9qPvsPH+aPt19Yuv9oc//e36" +
       "5/bHF8ECL88LKpc46N79Scrjb7nP3pLaEa2L9Du++/CX7nvhKPA8vAd8opan" +
       "sL3t5mcFCcePytN9+a898Ss/8c9e/Up5yun/A2SFMvtxMAAA");
}
