package org.apache.batik.ext.awt.image;
public class PointLight extends org.apache.batik.ext.awt.image.AbstractLight {
    private double lightX;
    private double lightY;
    private double lightZ;
    public double getLightX() { return lightX; }
    public double getLightY() { return lightY; }
    public double getLightZ() { return lightZ; }
    public PointLight(double lightX, double lightY, double lightZ, java.awt.Color lightColor) {
        super(
          lightColor);
        this.
          lightX =
          lightX;
        this.
          lightY =
          lightY;
        this.
          lightZ =
          lightZ;
    }
    public boolean isConstant() { return false; }
    public final void getLight(final double x, final double y, final double z,
                               final double[] L) { double L0 = lightX -
                                                     x;
                                                   double L1 = lightY -
                                                     y;
                                                   double L2 = lightZ -
                                                     z;
                                                   final double norm =
                                                     java.lang.Math.
                                                     sqrt(
                                                       L0 *
                                                         L0 +
                                                         L1 *
                                                         L1 +
                                                         L2 *
                                                         L2);
                                                   if (norm > 0) {
                                                       final double invNorm =
                                                         1.0 /
                                                         norm;
                                                       L0 *=
                                                         invNorm;
                                                       L1 *=
                                                         invNorm;
                                                       L2 *=
                                                         invNorm;
                                                   }
                                                   L[0] = L0;
                                                   L[1] = L1;
                                                   L[2] = L2; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfZAUxRXv2/vkOLgP5CAgpxwHVSDsSgQlOaPiAnK4x13d" +
                                                              "ISWLcZmd7b0dmJ0ZZnrvFgxBLY3EVFFEQE0iV5WI+aD4MIlWTFIoqXyo5QcF" +
                                                              "seJXIqKpQkWq4I+IiUnMe90zOx/7QVFGr2p657rf636v33u/97pn/xlSa5mk" +
                                                              "05C0lBRmmwxqhfvxvV8yLZqKqpJlrYLehHz/yZ1bz/95zF0hUhcn4zOS1StL" +
                                                              "Fl2mUDVlxck0RbOYpMnUWklpCjn6TWpRc1hiiq7FyUTF6skaqiIrrFdPUSRY" +
                                                              "LZkx0ioxZirJHKM99gSMXBbj0kS4NJHFQYLuGGmSdWOTyzDFxxD1jCFt1l3P" +
                                                              "YqQltl4aliI5pqiRmGKx7rxJrjB0ddOQqrMwzbPwenWhvRErYguLtqHz8eaP" +
                                                              "PtmRaeHbMEHSNJ1xFa0BaunqME3FSLPbu1SlWWsj+SapjpGxHmJGumLOohFY" +
                                                              "NAKLOvq6VCD9OKrlslGdq8OcmeoMGQViZLp/EkMypaw9TT+XGWZoYLbunBm0" +
                                                              "vbygrWPugIq7r4jseuj2ll9Uk+Y4aVa0QRRHBiEYLBKHDaXZJDWtxakUTcVJ" +
                                                              "qwYGH6SmIqnKZtvabZYypEksBy7gbAt25gxq8jXdvQJLgm5mTma6WVAvzZ3K" +
                                                              "/q82rUpDoGu7q6vQcBn2g4KNCghmpiXwPZulZoOipbgf+TkKOnbdDATAWp+l" +
                                                              "LKMXlqrRJOggbcJFVEkbigyC82lDQFqrgwua3NfKTIp7bUjyBmmIJhiZHKTr" +
                                                              "F0NANYZvBLIwMjFIxmcCK00JWMljnzMrr91+h7ZcC5EqkDlFZRXlHwtMHQGm" +
                                                              "AZqmJoU4EIxNc2IPSu2Ht4UIAeKJAWJB86tvnLthbseR5wTN1BI0fcn1VGYJ" +
                                                              "eW9y/LFLo7O/Uo1iNBi6paDxfZrzKOu3R7rzBiBNe2FGHAw7g0cG/rTmzn30" +
                                                              "dIg09pA6WVdzWfCjVlnPGopKzZuoRk2J0VQPGUO1VJSP95B6eI8pGhW9fem0" +
                                                              "RVkPqVF5V53O/4ctSsMUuEWN8K5oad15NySW4e95gxBSDw9pgmcaEX/8l5H1" +
                                                              "kYyepRFJljRF0yP9po76o0E55lAL3lMwauiRJPj/hnnzw9dELD1ngkNGdHMo" +
                                                              "IoFXZKgY5HEqjbCIkgVngL0B540pQxmAHfA54wtdLY+6TxipqgKzXBoEBRXi" +
                                                              "abmupqiZkHflblx67mDiBeFwGCT2rjEyG5YMiyXDfEkOobBkmC8ZdpckVVV8" +
                                                              "pUtwaWF8MN0GAAFA4abZg19fsW5bZzV4nTFSA/uOpLOKslLURQsH4hPy/mMD" +
                                                              "54++1LgvREIAKEnISm5q6PKlBpHZTF2mKcCmcknCAcpI+bRQUg5y5OGRu1Zv" +
                                                              "vZLL4UV7nLAWgArZ+xGjC0t0BaO81LzN97330aEHt+huvPvSh5P1ijgRRjqD" +
                                                              "dg0qn5DnXC49mTi8pStEagCbAI+ZBPEDUNcRXMMHJ90ONKMuDaBwWjezkopD" +
                                                              "Dp42soypj7g93OFa+fslYOKxGF8T4VlkBxz/xdF2A9tJwkHRZwJacOj/2qCx" +
                                                              "57WX37+Kb7eTJZo96X2Qsm4PMuFkbRyDWl0XXGVSCnR/e7h/5+4z963l/gcU" +
                                                              "M0ot2IVtFBAJTAjbfO9zG18/8dbeV0KuzzJIzbkkVDn5gpLYTxorKIl+7soD" +
                                                              "yKZCvKPXdN2igVcqaUVKqhSD5N/NM+c/+eH2FuEHKvQ4bjT3whO4/V+6kdz5" +
                                                              "wu3nO/g0VTJmVnfPXDIB1xPcmRebprQJ5cjfdXza956V9gDwA9haymbK8bOG" +
                                                              "70GNhV7tiVss9wZzSYv1m0oWDDFsJ6ND7ec3/qF+8xIn0ZRiEZQ3W71Hf7P8" +
                                                              "VIIbugHjG/tR93GeyF1sDnm8rEUY4FP4q4Lnv/jgxmOHgPW2qJ1bLi8kF8PI" +
                                                              "g/SzK1SDfhUiW9pObHjkvQNChWDyDRDTbbvu/zS8fZewnqhQZhQVCV4eUaUI" +
                                                              "dbBZhNJNr7QK51h26tCW3/50y31CqjZ/vl0K5eSBv/znxfDDbz9fAs7rUjr4" +
                                                              "rwjXq9CjC1jcHjSQ0Kpu/p5/bv3Wa30AHj2kIacpG3O0J+WdFqosK5f0WMwt" +
                                                              "f3iHVz+0DiSKOWAI7LiGN1yYyYyM566IqQWcVDc5xQI+GCnIS7i8hI/1YNNl" +
                                                              "eUHWb1BPpZ2Qd7xydtzqs0+f45viL9W9mNIrGcIirdjMRItMCia05ZKVAboF" +
                                                              "R1be1qIe+QRmjMOMMiRoq8+EhJr3IZBNXVv/xu9+377uWDUJLSONqi6llkkc" +
                                                              "zMkYQFFqZSAX543rbxAgMtIATQtXlRQpj3F7WWlEWJo1GI/hzU9NeuLan4y+" +
                                                              "xcFLoNVUzl5t4QkhmHf5Mc9NGR+++YN3nzn/aL1wsQoBE+Cb/K8+NXn3Ox8X" +
                                                              "bTLPkCViKMAfj+x/ZEr0utOc301VyD0jX1zEQDJ3eb+8L/uPUGfdH0OkPk5a" +
                                                              "ZPtItVpSc5gA4nCMsJxzFhy7fOP+I4Gof7sLqfjSYBB7lg0mSW9Y1DBfCLh5" +
                                                              "EWtQMgee6XbKmB7Mi1WEv8Q5yyzezsZmrpOG6g1TgaM3DeShsRUmheBXsU67" +
                                                              "tRB5EzjzCmzWiol6y/rfqouXXsbmNmfZNaWWTX0Oy2Z8y8ZLLatUWFYMzcJm" +
                                                              "TmFx/ldHAkcHb5J3A4wgZkwrd7rjCL737l2jqb7H5odsJLueAQjoxjyVDlPV" +
                                                              "M1UtzwfBWO3lZ1rX8a85fr76zQcmNxWXxzhTR5nid075oA4u8OzdH0xZdV1m" +
                                                              "3UXUvZcF9A9O+bPe/c/fNEt+IMSP5SLOio7zfqZuf3Q1mpTlTM2fZjoLFmtD" +
                                                              "S0yFZ5ZtsVlBd3F9ImDsQkVXjrVCTtpSYWwrNnkw9RAVJ6Zb3fTH3XLThaLB" +
                                                              "lwSwY4B3s2Kt59miz7t4rcuxVtDs2xXGvoPNPR6t1wS0vvf/p/UCW/QFF691" +
                                                              "OdYKmu2uMPYQNjs8WscDWn/3M2s9AYcQh6K26NGL17ocawXNflhh7FFsHmHe" +
                                                              "VMvpFmKzSGj8Vc/7dZDIkrquUkkLVqT475K8u197PvN+teLQlfD020r3Vdiv" +
                                                              "YMoN4es8Bsle0SQ1kHVbnMlKTBrYLfsMxZ3BbYIlWeF8xI9kohD/9YT3f/n8" +
                                                              "uvrXRUlW+gQWuA58544XfqT/9XTISTNXF8TGYOEJdLktNv9lJPW5XE4NUT0b" +
                                                              "ieaSiuxcgn0h62Aenlk+y3n2dvTHM17eOjrjJK/kGxQL8iScNktc0np4zu4/" +
                                                              "cfr4uGkH+a1KDWZdnoaCt9vFl9e+O2lul2Zsnsq7COE9meH/qwSBXeA8U8lF" +
                                                              "sfk5n2oRlkBUG2KZUnFXDXLh62H7cIBLhsQ8znlMXA1gSQzli65RyTk4wpi4" +
                                                              "5FP0cOHDAAzmSwrPXO0Oe8CIi1MBS45WGDuGzYsQjTLKJdSoQP6KwAMPUPhA" +
                                                              "htM8UYH/VWwOMNLggHmpDa0Z1pWUi1cHLx6voDRodK9T8ZA3uehLjvj6IB8c" +
                                                              "bW6YNHrLq8L5nC8ETTHSkM6pqvcM4nmvM0yaVrhGTeJEIk7hJxnpqHzLCzvN" +
                                                              "f7ngbwuuvzMyuRwXuBe0XupT4DKlqIESWi/lB4y0BClhff7rpTsDu+XSga+L" +
                                                              "Fy/JWZgdSPD1nOF47twLXGgvBhw14WTOjZCv8hf2BfNOvJB5PWeBGT4M4t/w" +
                                                              "HODOia94CfnQ6IqVd5y7+jFx1ymr0ubNOMtYgAtx7VqorKeXnc2Zq2757E/G" +
                                                              "Pz5mpgP7rUJgN7tN9fj2AISBgb42JXARaHUV7gNf33vt0y9tqzsO8LiWVEmA" +
                                                              "DGuLj8t5Iwdl/9pYqWskwFN+R9nd+O66ox+/UdXGbyWIuHjqqMSRkHc+/WZ/" +
                                                              "2jC+HyJjesANtRTN87P8kk3aAJWHTd+tVF1Sz2kF7B2PgSHh9z2+M/aGjiv0" +
                                                              "4l05I53Fd3TF3w8aVX2Emjfi7DbM+84iOcPwjvKdjQp8EIm1OhHrNQz7crL2" +
                                                              "AN95w8C4r+LFwJL/AasgSKqoHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
