package org.apache.batik.gvt.flow;
public class MarginInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected boolean fontSizeRelative;
    protected boolean flowRegionBreak;
    public MarginInfo(float top, float right, float bottom, float left, float indent,
                      int alignment,
                      float lineHeight,
                      boolean fontSizeRelative,
                      boolean flowRegionBreak) { super();
                                                 this.top = top;
                                                 this.right = right;
                                                 this.bottom = bottom;
                                                 this.left = left;
                                                 this.indent = indent;
                                                 this.alignment =
                                                   alignment;
                                                 this.lineHeight =
                                                   lineHeight;
                                                 this.fontSizeRelative =
                                                   fontSizeRelative;
                                                 this.flowRegionBreak =
                                                   flowRegionBreak;
    }
    public MarginInfo(float margin, int alignment) { super();
                                                     setMargin(margin);
                                                     this.indent =
                                                       0;
                                                     this.alignment =
                                                       alignment;
                                                     this.flowRegionBreak =
                                                       false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public boolean isFontSizeRelative() { return fontSizeRelative;
    }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1aaYwcxRWumfWe3vUevm97vTasj5k4QGyyXPYe9uDZw7u2" +
                                                              "A2tg3dNTM9t2T3e7u2Y9NnHAJMEWSRACmzgJOJFiciCDUQJKBIKYXIAIcSAo" +
                                                              "4RC3FEgACf+AJQFC3qvume7p6W4Ya5WVuqa3ql6999V79eq9qj7xLqk0dNKq" +
                                                              "CUpSiLC9GjUiA/g+IOgGTXbKgmFsgdoR8abXbrtu/K+1B8KkaphMGRWMXlEw" +
                                                              "aI9E5aQxTOZLisEERaRGH6VJpBjQqUH1MYFJqjJMpktGLKPJkiixXjVJscM2" +
                                                              "QY+TZoExXUpkGY1ZAzCyMM6liXJpouvcHTripF5Utb02wZwigk5HG/bN2PwM" +
                                                              "RpriO4UxIZplkhyNSwbryOlkhabKe9OyyiI0xyI75Qusibg8fkHJNLTe1/jB" +
                                                              "R7eMNvFpmCooiso4RGOQGqo8RpNx0mjXdss0Y+wmXyMVcTLZ0ZmRtnieaRSY" +
                                                              "RoFpHq/dC6RvoEo206lyOCw/UpUmokCMLC4eRBN0IWMNM8BlhhFqmIWdEwPa" +
                                                              "RQW0eXW7IB5ZET383WuaflFBGodJo6QMoTgiCMGAyTBMKM0kqG6sSyZpcpg0" +
                                                              "K6DwIapLgizts7TdYkhpRWBZMIH8tGBlVqM652nPFWgSsOlZkal6AV6KG5X1" +
                                                              "X2VKFtKAdYaN1UTYg/UAsE4CwfSUALZnkUzaJSlJbkfFFAWMbZugA5BWZygb" +
                                                              "VQusJikCVJAW00RkQUlHh8D4lDR0rVTBBHVuaz6D4lxrgrhLSNMRRma5+w2Y" +
                                                              "TdCrlk8EkjAy3d2NjwRamuPSkkM/7/ZddPO1ykYlTEIgc5KKMso/GYgWuIgG" +
                                                              "aYrqFNaBSVi/PH67MOPhQ2FCoPN0V2ezz6++euaylQtOPW72mevRpz+xk4ps" +
                                                              "RDyemPL0vM72CytQjBpNNSRUfhFyvsoGrJaOnAaeZkZhRGyM5BtPDf7xyuvv" +
                                                              "pm+HSV2MVImqnM2AHTWLakaTZKpvoArVBUaTMVJLlWQnb4+RaniPSwo1a/tT" +
                                                              "KYOyGJkk86oqlf8PU5SCIXCK6uBdUlJq/l0T2Ch/z2mEkGp4SD08s4n5x38Z" +
                                                              "odFRNUOjgigokqJGB3QV8aNCuc+hBrwnoVVTowmw/12rVkfWRA01q4NBRlU9" +
                                                              "HRXAKkap2RhNj7FoSlb3RHsFPS0pMRAnguam/b8Y5RDx1D2hEChjntsVyLCK" +
                                                              "Nqpykuoj4uHs+u4z9448aZoZLg1rrsB5AbeIyS3CuUWAWwS5RWxuJBTiTKYh" +
                                                              "V1PboKtdsOrB7da3D119+Y5DrRVgZtqeSTDRYei6rGQb6rTdQ96nj4gnnh4c" +
                                                              "P/1U3d1hEgYPkoBtyN4L2or2AnMr01WRJsEZ+e0Kec8Y9d8HPOUgp47uObDt" +
                                                              "ui9wOZzuHQesBM+E5APolAss2tzL2mvcxoNvfXDy9v2qvcCL9ov8NldCiX6j" +
                                                              "1a1SN/gRcfki4YGRh/e3hckkcEbggJkACwZ82wI3jyL/0ZH3xYilBgCnVD0j" +
                                                              "yNiUd6B1bFRX99g13Naa+fs0UPFkXFDT4YlYK4z/YusMDcuZpm2izbhQcF9/" +
                                                              "8ZB253N//ud5fLrz20KjYz8foqzD4YpwsBbudJptE9yiUwr9Xjo6cNuRdw9u" +
                                                              "5/YHPZZ4MWzDshNcEKgQpvmbj+9+/pWXjz8bLthsiMFenE1AWJMrgMR6UhcA" +
                                                              "Eu3clgdcmQyrHK2mbasCVimlJCEhU1wkHzcuXf3AOzc3mXYgQ03ejFZ+9gB2" +
                                                              "/ez15PonrxlfwIcJibiV2nNmdzP981R75HW6LuxFOXIHnpn/vceEO8HTg3c1" +
                                                              "pH2UO8xaPge1Blq1Y91ifDeUTRhsQJcyoIgxa/c5OWN89++r93XldxYvErPn" +
                                                              "JqP39IMb3xzhiq7B9Y31iL3BsXLX6WmHlTWZCvgU/kLw/BcfnHisMP14S6e1" +
                                                              "mSwq7CaalgPp2wPCv2II0f0tr+y64617TAju3dbVmR46fNOnkZsPm9ozQ5Il" +
                                                              "JVGBk8YMS0w4WKxF6RYHceEUPW+e3P/Qz/YfNKVqKd5guyF+vOdvn/wpcvTV" +
                                                              "Jzw8OSwjVTADy/PQoE2z5vu0Sz8mqKrVd/77uhuf6wffESM1WUXanaWxpHNU" +
                                                              "iKqMbMKhMDvc4RVOeKgcRkLLQQ9YscZVcLEusGYCf77seL+EkQpJKREd/+3K" +
                                                              "fS7y6oSqylRQ/IfYxMvzeYdooRvh3Qhv24xFm+F07MVG5AjnR8Rbnn2vYdt7" +
                                                              "j5zhiijOB5x+rFfQTCtoxmIpWsFM9ya6UTBGod/5p/quapJPfQQjDsOIIoQC" +
                                                              "Rr8O+3euyOtZvSurX3j0dzN2PF1Bwj2kDjSf7BH4BkJqwXNTYxS2/px26WWm" +
                                                              "49pTA0UTh0pKwKOvWOjthbozGuN+Y9+vZ95/0U+PvcwdJh9hfuleYDEzf0v3" +
                                                              "AiyXYbG81MP6kbr0FTbji4Jd9fChdwRoNYHFdt40iMVVps1s/XwzgxXDJsVc" +
                                                              "XtdgYNblDm146mzvyu+8+IM3fjP+42pzFQf4JBfdrP/0y4kbXv+wxKZ4EOLh" +
                                                              "plz0w9ETd8zpvORtTm9HA0i9JFcaIkK8ZNN+8e7M++HWqj+ESfUwaRKtNHWb" +
                                                              "IGdxjx2G1MzI566Qyha1F6dZZk7RUYh25rn9pIOtOw5xup5JrMjN2KHHLFTN" +
                                                              "KnjmWDYzx21uPFY1lwyKFIlBVpmmesvrPzo+fuDg2jDufZVjKDrMSpPdry+L" +
                                                              "2fCNJ47Mn3z41W9xU88PbYZ9y3jZjsVKbg4V+LoKQgeDJ9bohCVFkF0hxMwA" +
                                                              "YRmZvC4e29A3MrRl3eAWbtP2auEWq3yWxaZLp2auxW2ux9Tgi5p3jvuCcGHB" +
                                                              "45SsByA/FozUm4B6Y11d8W4vRNeeBaJ5Frt5AYi4X/j6WSPyY8FIrYmou6/L" +
                                                              "C843zgLOfIvX/AA4XORvnzUcPxaM1JlwerbG4154vvP58UzJm/RCi9nCEjyE" +
                                                              "vxzxhgFRd62mqww8Bk26MDQEDAsBA1O1wjbgEP72MoVHZS+yuCzyEf6YvXUd" +
                                                              "LZXRjxqcgS6lR5mXlD8sU0rU4WKLz2IfKe8KlNKPGnxXQmVMzXiJ+ZMyxURf" +
                                                              "0GoxavUR80SgmH7UDJImmvKcy3vOYi7bLDZtPkL+MlBIP2qYS4jhqeIp5v1l" +
                                                              "ionmtMxitMxHzAcDxfSjhjUnyFJayViSutf/Q2VKiiZ1rsXrXB9JHw2U1I8a" +
                                                              "XBUeAG6kfuvot2WKeg487Razdh9RHw8U1Y+akaYUBFxDkFEPUlnArA7rN7kE" +
                                                              "fqJMgVF3KyyWK3wEPh0osB815Cl4yjdI0xBhrtepsMtL3r8EyJvziuj5XxVx" +
                                                              "Hb06+DqCaYLp0Hy/03GeEB+/4fCxZP9dq8NWOH8pGC94/lUyHaOyY6g6nl67" +
                                                              "4/JefidgB7lrnhmvePHWWfWlp4040gKfs8Tl/gG8m8FjN/xrzpZLRneUcYy4" +
                                                              "0IXfPeTPe088sWGZeGuYX2uYMXXJdUgxUUdxJF2nU5bVleK0vbU4fcOFscHS" +
                                                              "2Aa3ndk24Ze++ZG6EjNHVr6Gj/qPgMztLSxeA30blJlH0V6Z/6QxVUra9vp6" +
                                                              "+ekdr36pgGkqNmG80Wdh6it/OvxIA9C+H9A2jsV7EFinKduiauZk8Em0gZ+Z" +
                                                              "GODoy/st6fvLB+5H6g/Oine923iU+zEjUwD4IO4BntA/mRjoGHIMWPIPlA/d" +
                                                              "jzQAXkNAWyMWNeCkAfp6HqB5YQ/VTgz2RfBstgBsLh+7H2kAvtkBbXOxmMZI" +
                                                              "A2CPQ9TniXz6xCDH+H/IEn+ofOR+pAHolga0nYPFIvB5gDxmh5I26sUTg3oJ" +
                                                              "PFst0beWj9qPNADZ6oC287BYCREU+jfYY9cVRac2+FUTZ+xXWAiuKB+8H2kA" +
                                                              "wIsD2i7FYq1l7MXBro38wolBvhSeKy3xrywfuR9pALpYQBvGmqEuRloko8cr" +
                                                              "dLbhd08MfMzXtlsYtpcP3480AOLWgLavYDHASDPA9wjEbfSbz+LIGjIn+/oe" +
                                                              "D/hnlXwqZH7eIt57rLFm5rGtf+dXyIVPUOrjpCaVlWXngazjvUrTaUric1Zv" +
                                                              "Hs/ya5/QNYzM9v2gAII1/EGRQ1eb/QVGpnn1Z6QCSmfPJLgHd09GKvmvs18a" +
                                                              "kNv9ICM3X5xddsLo0AVfd5l3GbOY8xjYPMHOhYozlbw6yGduPI7kZklR6sA/" +
                                                              "6sqH+Vnzs64R8eSxy/uuPfOlu8y7cFEW9u3DUSbHSbV5LV9IFRb7jpYfq2pj" +
                                                              "+0dT7qtdmk+Xmk2Bbdue6wgrhyEU19A25rguio22wn3x88cveuSpQ1XPhElo" +
                                                              "O0F1Td1eetaf07KQx2yPe90zQiLF77A76t7YcfrDF0It+WN1PKNfEEQxIt72" +
                                                              "yIsDKU37fpjUxkglHq3k+EVE115lkIpjetG1ZVVCzSqF77+moCEL+MEXnxlr" +
                                                              "QhsKtfgtBSOtpXe4pd+X1IHNUn09jo7DNLiSq6ymOVv5zHZisTaHMw22NhLv" +
                                                              "1TTr8rrqNT7zmobrNPQ1/Kfrf0dDh5O5KQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1Wh3H+zMd4mJZyhHSvSn93LOXiR845D1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("O/PE/EhsuM96eH9YHyf1nXPy/lce/Leo9IiuRlPP33EuxuqI339/u/zyI4jR" +
       "Pr/Rfed34dI5eZfzxL+KSo8Cflx+dHEmw++9XYb5qRi7z5C9/wyvn5P3WB5c" +
       "i0rXAUOiOPI7i+KFh98uxRfAM96nOL7/FN97Tt6zefBEVHoHoEir2pkyvPDk" +
       "2yWYHwZP9glO7j/BD5yT90oevATMDiBIHR1IHpF7+e2Sexk8/D45/v6Tq5yT" +
       "V8uDvah0IzcxYOnCT5xuHnGE74eGLvY5Lu4/xx87Jy/3UC788L6GnjwmPSL4" +
       "6tsl+D7wCPsEhftPcHBOHpMH3aj0uBF2zzpuPWLZe7ss8/P8j+2z/Nj9Zzk/" +
       "J0/IAw44j4DlGce2RyQn93S1LipdO7pcnt+Ufeq2P7Ls/nwh/+qb1x968k3+" +
       "3xb3qw//IHGVLj2kxbZ9/J7ZsfgVPwA774L41d2tM79g8/Go9J47XncHXkz+" +
       "lYO9cGtXXo5K7zqrfFS6BMLjJTUwm0+XjEqXi+/j5QzA/KhcVLqyixwvAtzI" +
       "S6BIHnX8YuhOnkXvLualF0761QeCKD3+/QRxzBV/+YQDXfzl6MDZjXd/Orol" +
       "f+XN/vCnvo390u6iuGxL223eykN06cHdnfVDh/nFO7Z20NYV8pXvPvrVq+87" +
       "cO4f3QE+UuFj2J4/+1Z2x/Gj4h719jee/Gc/8o/e/OPiet//AxHRQDcLNgAA");
}
