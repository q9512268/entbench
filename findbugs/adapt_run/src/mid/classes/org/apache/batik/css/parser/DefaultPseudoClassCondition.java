package org.apache.batik.css.parser;
public class DefaultPseudoClassCondition extends org.apache.batik.css.parser.AbstractAttributeCondition {
    protected java.lang.String namespaceURI;
    public DefaultPseudoClassCondition(java.lang.String namespaceURI, java.lang.String value) {
        super(
          value);
        this.
          namespaceURI =
          namespaceURI;
    }
    public short getConditionType() { return SAC_PSEUDO_CLASS_CONDITION;
    }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public java.lang.String getLocalName() { return null; }
    public boolean getSpecified() { return false; }
    public java.lang.String toString() { return ":" + getValue();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMUZbWwUx3XujD+x8QdgqAFjjEGCkLvSBGhkSmMMDkfO9skG" +
                                                              "pB4tx9zenL2wt7vsztqHKSUgNaBURRE4CWkDf0LUFJFAq0SpUkGp+pFEaYqg" +
                                                              "UZsENWmbH0mbIIUfjdPSNn0zs7e7t/cRWY1UpJ0bz7z35n2/N8P5m6jSNFCn" +
                                                              "jtUUDtH9OjFDMTaPYcMkqV4Fm+Y2WE1ID/355KGp39UeDqKqOJo1is1+CZuk" +
                                                              "TyZKyoyjRbJqUqxKxBwgJMUwYgYxiTGGqaypcTRXNiMZXZElmfZrKcIAdmAj" +
                                                              "ipoxpYactCiJ2AQoWhzl3IQ5N+EeP0B3FNVLmr7fRWjLQ+j17DHYjHueSVFT" +
                                                              "dA8ew2GLyko4Kpu0O2ugO3RN2T+iaDREsjS0R1ljK2JrdE2BGjovNn58++HR" +
                                                              "Jq6G2VhVNcpFNIeIqSljJBVFje7qZoVkzH3oW6giimZ6gCnqiuYODcOhYTg0" +
                                                              "J68LBdw3ENXK9GpcHJqjVKVLjCGKluQT0bGBMzaZGOcZKNRQW3aODNJ2ONLm" +
                                                              "zO0T8ZE7wpOP7Wr6cQVqjKNGWR1m7EjABIVD4qBQkkkSw+xJpUgqjppVMPgw" +
                                                              "MWSsyBO2tVtMeUTF1AIXyKmFLVo6MfiZrq7AkiCbYUlUMxzx0typ7L8q0woe" +
                                                              "AVlbXVmFhH1sHQSsk4ExI43B92yUGXtlNcX9KB/DkbHrfgAA1OoMoaOac9QM" +
                                                              "FcMCahEuomB1JDwMzqeOAGilBi5ocF8rQZTpWsfSXjxCEhTN98PFxBZA1XJF" +
                                                              "MBSK5vrBOCWwUpvPSh773BxYf/yAukUNogDwnCKSwvifCUjtPqQhkiYGgTgQ" +
                                                              "iPUro4/i1kvHgggB8FwfsIB54Zu37l3VfuVlAbOgCMxgcg+RaEI6m5x1bWHv" +
                                                              "insqGBs1umbKzPh5kvMoi9k73VkdMk2rQ5FthnKbV4Z+/bUHzpEPgqgugqok" +
                                                              "TbEy4EfNkpbRZYUY9xGVGJiSVATVEjXVy/cjqBrmUVklYnUwnTYJjaAZCl+q" +
                                                              "0vjfoKI0kGAqqoO5rKa13FzHdJTPszpCqBo+VA/fQiT+8V+KsuFRLUPCWMKq" +
                                                              "rGrhmKEx+ZlBec4hJsxTsKtr4ST4/947V4fWhU3NMsAhw5oxEsbgFaNEbIYl" +
                                                              "02RxCqkxvImksaXQmEmslMbtCzGW4uoIMQ/U/49nZ5leZo8HAmCyhf6EoUCs" +
                                                              "bdGUFDES0qS1cfOtZxOvCmdkAWRrlKJ1wEBIMBDiDISAgZBgIFSGARQI8HPn" +
                                                              "MEaEm4CR90K6gHxdv2L4G1t3H+usAP/Ux2eAhRjo8oL61evmlVwxSEjnrw1N" +
                                                              "XX2t7lwQBSH1JKF+uUWkK6+IiBpoaBJJQRYrVU5yKTVcuoAU5QNdOTV+eMeh" +
                                                              "L3I+vHWBEayElMbQYyybO0d0+fNBMbqNR9//+MKjBzU3M+QVmlx9LMBkCafT" +
                                                              "b2W/8AlpZQd+PnHpYFcQzYAsBpmbYog0SIrt/jPyEk93LokzWWpA4LRmZLDC" +
                                                              "tnKZt46OGtq4u8Ldr5nP54CJZ7JIXA7fMjs0+S/bbdXZOE+4K/MZnxS8SHxl" +
                                                              "WD/9xm//ehdXd66eNHoagWFCuz05jBFr4dmq2XXBbQYhAPfHU7GTj9w8upP7" +
                                                              "H0AsLXZgFxt7IXeBCUHN335535vvvH329aDrsxSKuJWEfijrCMnWUV0ZIZmf" +
                                                              "u/xADlQgFzCv6dquglfKaRknFcKC5F+Ny1Y//+HxJuEHCqzk3GjVZxNw17+w" +
                                                              "ET3w6q6pdk4mILEa7OrMBROJfbZLuccw8H7GR/bw9UWPv4RPQ4mAtGzKE4Rn" +
                                                              "2iDXQZBLPh9aMo7Jym1IlFu2voab9G4OE+bjXUwdHBPxvS+zocv0hkZ+9Hk6" +
                                                              "qYT08OsfNez46PItLkt+K+b1hH6sdwvnY8OyLJCf509DW7A5CnB3Xxn4epNy" +
                                                              "5TZQjANFCVKuOWhAUszm+Y0NXVn91s9/0br7WgUK9qE6RcOpPsxDENWC7xNz" +
                                                              "FPJpVv/qvcL04zUwNHFRUYHwTNuLi9txc0anXPMTP5n33PofnHmbu5zwsQVO" +
                                                              "tuwoyJa8jXcD/cMb33/3Z1NPVosmYEXp7ObDm//PQSV55C+fFCiZ57UiDYoP" +
                                                              "Px4+/0Rb74YPOL6bYBj20mxhIYIU7OJ+6Vzm78HOql8FUXUcNUl2y7wDKxYL" +
                                                              "2zi0iWauj4a2Om8/v+UT/U23k0AX+pOb51h/anMLIMwZNJs3+LLZLGbFTvg6" +
                                                              "7EDv8GezAOKTCEdZzscVbFiVSx61uqFR4JKkfPmjoQxZiuoZeyZUZLJ9KMKj" +
                                                              "TORNNt7Dhq2C3Ppifii2lrNhpXMo/1flb5q8Sct1PcSiaVGpvpb35GePTJ5J" +
                                                              "DT61WjheS36vuBmuQs/8/t+/CZ360ytF2o1aqul3KmSMKJ4z2eV2SYG79/O2" +
                                                              "3/WdddenKm6cmF9f2BcwSu0lqv7K0nHhP+ClI39r27ZhdPc0Cv5in6L8JH/Y" +
                                                              "f/6V+5ZLJ4L85iJcteDGk4/Une+gdQaBK5q6Lc9NOx3TNjOTLYEvZJs2VLzo" +
                                                              "FvEKp5SVQi2T1qUye5zPXVAxRgh12kXeNbAq4LEye2MYtpImjRlyBqDG7BvQ" +
                                                              "hdapfb+sntiUu90UQxGQ95v9V1/c8l6CW6yGuYSjJ4879BgjnoalSSjgU/gX" +
                                                              "gO8/7GO8swX2C3mm177QdDg3Gl1nYVEmx/pECB9seWfvE+8/I0TwJ1QfMDk2" +
                                                              "+dCnoeOTIlzEtXhpwc3UiyOuxkIcNuzJ8ggqcwrH6HvvwsGfPn3waNC21A4K" +
                                                              "oTeqGdSxY8ApP61+tQteq1af/sehB98YhO4ygmosVd5nkUgq32WrTSvpsYN7" +
                                                              "k3Yd2Oaa6ZyiwErdrn48vSXKpLfCMssWevhy3PHsllxQrLU9e+30g6IUahnH" +
                                                              "P1Rm7zAbJqCNgaAY8Od3V/YDn4/s7fBtsAXYMH3ZS6GWke87Zfa+y4YHobCB" +
                                                              "7FFNwsqA7SsewY/+z4LPZluL4euzue+bvuClUMsI91iZvcfZcEIIPqwTCXp3" +
                                                              "It6xRuyoZT+KZw4VsjqpaQrBqj8m2Z+WJ0xOfj6u0gZfvy12//Q1Vgq1jFae" +
                                                              "LrN3jg1PUlRDNc8twxX67PSFzlK0oMw7BuvT5xc8tooHQunZM401885s/wO/" +
                                                              "SzuPePVQa9KWonjbSM+8SjdIWubi1IumUuc/PwJGyjy2sMsmn3A5Lgqc5yia" +
                                                              "UwyHogoYvZAvQMH1Q0J6579euBcpqnPh4FAx8YJcAuoAwqaX9dz9b225d6Ie" +
                                                              "qMgG3JSc/wZw1JsN5PeWjiXnfpYlPe3o0ry6yx/Qc4XJEk/o0DSc2Tpw4Nba" +
                                                              "p8TzgaTgiQlGZSaUI/GS4fRsS0pSy9Gq2rLi9qyLtctydbJZMOxGwwKPy/ZA" +
                                                              "bOrMi9p8d2uzy7liv3l2/eXXjlVdhwq/EwUwRbN3Ft5lsroFDeXOaLHCCx0t" +
                                                              "v/Z31727++onbwVa+JURiVLdXg4jIZ28fCOW1vXvBVFtBFVCG0Cy/KK1ab86" +
                                                              "RKQxI6+OVyU1S3Xe2mcxl8csDrlmbIU2OKvs+YmizsJepfBJDm7T48TYyKgz" +
                                                              "Mg2+LtfSde8u1ywViZFpGjwyEe3XdbtJq5C55nWdh/g1nhr/C85fzPMlGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "0DfqXk0pxZs1Zhkr1Coh6mxmWryySHyklXDJWBqgZFSxwsAlm+psKNIdggAZ" +
       "7QoR0CJWwmDYdaSEF+EeNzZ4WpnpZbMrlGoaMZwWV7MVSOUjnOSJdoFYIxRV" +
       "FKVadUyN0m4VHvJrrsiiM7Vky6lVk8NmYIEXJq40pFYhPLeNTdhTPQ3vNW1s" +
       "Uq5N5mtK3/T1EkxHGquotbi4TnhDIL22maxbKjpTpKjnV4hKxZkqC0QvOosA" +
       "IWoVbcP0rXbSaGSvhuoP93Z+W37ocHBp9iMcN2y7HsyKRw6Od/LPmZMXLUfP" +
       "WQ+P16DsTfvel7oLy9+yn3vHU88qw48Wd/aOJZ+IoPOR673BUleqdWSo7N73" +
       "sZc+UejnV4GHx2Wff8e/3D15fPHED3FFcP8JOU8O+dv957/Yfp38wR3opoPD" +
       "s2suKY8zXTl+ZHYhUKM4cCbHDs7uPdBsrt0HwbO7p9nd6x/TX//ULLeC7drf" +
       "4NT3rTfoezIrVhF0SVejg+ucg0uFNx+xlqsRWI+FG0SHdpT8oNONo7PlDeEB" +
       "8Nv3gVf3gFdffuDvvUHfL2XFOyPoIgA+OHlseAjxXT8uxPvA8/gexMdffohP" +
       "36Dvmaz4lQi6BUCkXVm0BntmeQTfB38MfHdkjfeDh9zDR778+H7jBn3PZcVH" +
       "tvhYT5Xzg8jr2e1ZyXUtVXQOYT/74y7r3eDp78Huv/ywf+cGfb+XFc9H0LnI" +
       "PXL3c4jt4z8MtjSCXnuDi93sluqua/59sv3HhPyJZy+ee82z3F/nd5sH/2o4" +
       "T0PntNiyjl4bHKmf8QJVM3Ig57eXCF7+9cdAkBvcPmeXf3klR/BHW57PRNCr" +
       "rscTQTeB8ijlCyDCnaQE8Sz/Pkr32Qi6cEgHJt1WjpJ8DowOSLLq5739+7jq" +
       "jS7OG1IYBaIcNSKwXFIcqQfqTU8d3zgP1vD2H7SGR/bah4/tkPk/ivZ3s3j7" +
       "n6Kr8ief7Q3e+mL1o9vrXNkSN5tslHM0dHZ7s3ywIz74kqPtj3Wm8+j3bv3U" +
       "+Uf2d+9btwIfGv0R2e6//t1py/ai/LZz84ev+f03/uazX8tvJf4XS3/Dh+ol" +
       "AAA=");
}
