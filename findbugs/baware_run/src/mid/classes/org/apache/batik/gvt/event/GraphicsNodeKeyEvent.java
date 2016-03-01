package org.apache.batik.gvt.event;
public class GraphicsNodeKeyEvent extends org.apache.batik.gvt.event.GraphicsNodeInputEvent {
    static final int KEY_FIRST = 400;
    public static final int KEY_TYPED = KEY_FIRST;
    public static final int KEY_PRESSED = 1 + KEY_FIRST;
    public static final int KEY_RELEASED = 2 + KEY_FIRST;
    protected int keyCode;
    protected char keyChar;
    protected int keyLocation;
    public GraphicsNodeKeyEvent(org.apache.batik.gvt.GraphicsNode source,
                                int id,
                                long when,
                                int modifiers,
                                int lockState,
                                int keyCode,
                                char keyChar,
                                int keyLocation) { super(source, id, when,
                                                         modifiers,
                                                         lockState);
                                                   this.keyCode = keyCode;
                                                   this.keyChar = keyChar;
                                                   this.keyLocation = keyLocation;
    }
    public int getKeyCode() { return keyCode; }
    public char getKeyChar() { return keyChar; }
    public int getKeyLocation() { return keyLocation; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZfWwUxxUfn8Hf4A/AEAMGjEGBwF1JSAkxpBhjw8EZTjah" +
                                                              "wlCOvb05e/He7np3zpydUgJVA0oqRMGktAFUqURtEB9RlKhtqlBXbULSJEWQ" +
                                                              "KA2hDTT5I2kTpKCqcVrapu/N7t3u7X0Qp3/0pJ3bm3nz3vvNe/Pem7nTN8hY" +
                                                              "QycNmqBEBC8b0KjhDeJ7UNANGmmRBcPYCL0h8dE/H9498kbpHg8p6iLjewSj" +
                                                              "XRQM2iZROWJ0kemSYjBBEamxntIIzgjq1KB6v8AkVekikyTDH9NkSZRYuxqh" +
                                                              "SLBJ0AOkWmBMl8JxRv0WA0ZmBLg2Pq6Nr9lN0BQgFaKqDdgT6tImtDjGkDZm" +
                                                              "yzMYqQrsEPoFX5xJsi8gGawpoZO7NFUe6JZV5qUJ5t0h32stxNrAvRnL0PB0" +
                                                              "5ae3DvZU8WWYICiKyjhEo4MaqtxPIwFSafe2yjRm9JFvkcIAKXcQM9IYSAr1" +
                                                              "gVAfCE3italA+3FUicdaVA6HJTkVaSIqxMisdCaaoAsxi02Q6wwcSpiFnU8G" +
                                                              "tDNTaJPmdkE8cpdv6Pvbqp4pJJVdpFJSOlEdEZRgIKQLFpTGwlQ3miMRGuki" +
                                                              "1QoYvJPqkiBLg5a1awypWxFYHFwguSzYGdeozmXaawWWBGx6XGSqnoIX5U5l" +
                                                              "/RoblYVuwFprYzURtmE/ACyTQDE9KoDvWVPG9EpKhPtR+owUxsZ1QABTi2OU" +
                                                              "9agpUWMUATpIjekisqB0+zrB+ZRuIB2rggvq3NdyMMW11gSxV+imIUamuOmC" +
                                                              "5hBQlfKFwCmMTHKTcU5gpTqXlRz2ubF+2YGHlDWKhxSAzhEqyqh/OUyqd03q" +
                                                              "oFGqU9gH5sSK+YHHhdoX9nsIAeJJLmKT5mffvLliQf3wyybN1Cw0G8I7qMhC" +
                                                              "4snw+EvTWuYtLUQ1SjTVkND4acj5LgtaI00JDSJNbYojDnqTg8MdL21++BT9" +
                                                              "yEPK/KRIVOV4DPyoWlRjmiRTfTVVqC4wGvGTUqpEWvi4nxTDe0BSqNm7IRo1" +
                                                              "KPOTMTLvKlL5b1iiKLDAJSqDd0mJqsl3TWA9/D2hEUKK4SEV8Ewn5od/M6L5" +
                                                              "etQY9QmioEiK6gvqKuJHg/KYQw14j8CopvrC4P+9Cxd5l/gMNa6DQ/pUvdsn" +
                                                              "gFf0UHPQ190Pe7WfKsy3Whe0Hkk01kN8WkcHWrHTi56n/R9kJnAdJuwsKAAT" +
                                                              "TXMHCBn21hpVjlA9JA7FV7bePBt61XQ+3DDWCjKCgr2mYC8X7AXBXi7Ym00w" +
                                                              "KSjg8iaiAqY7gDF7ISxAXK6Y1/mNtdv3NxSCH2o7x4AlkHRuRp5qseNHMuiH" +
                                                              "xNOXOkYuvl52ykM8EGLCkKfsZNGYlizMXKerIo1AtMqVNpKh05c7UWTVgwwf" +
                                                              "3bln0+6vcD2c8R8ZjoXQhdODGLVTIhrd+z4b38p9H3567vFdqh0B0hJKMg9m" +
                                                              "zMTA0uC2rht8SJw/U3gu9MKuRg8ZA9EKIjQTYEdB8Kt3y0gLME3JYI1YSgBw" +
                                                              "VNVjgoxDyQhbxnp0dafdw92umr9PBBOX446bAc8mawvybxyt1bCdbLop+owL" +
                                                              "BU8Gyzu142///i/38OVO5o1KR8LvpKzJEauQWQ2PStW2C27UKQW6Px0NHj5y" +
                                                              "Y98W7n9AMTubwEZsWyBGgQlhmb/zct+Va++efNNj+yyDZB0PQ92TSIHEflKW" +
                                                              "ByT6ua0PxDoZ9j56TeODCnilFJWEsExxk/yrcs6i5z4+UGX6gQw9STdacHsG" +
                                                              "dv8dK8nDr24bqedsCkTMtfaa2WRmAJ9gc27WdWEA9UjsuTz9BxeE45AKIPwa" +
                                                              "0iDlEbWEr0EJRz4FqpWs8cEZGQz0f8cOx1KxMx42WFCXYmCyfiuRnasd6ftt" +
                                                              "8eCqZJLKNsWkXGe0X3x+zQch7hIlGAmwHxUa59jjzXq3wx+rTFN9Dp8CeP6D" +
                                                              "D5oIO8yUUNNi5aWZqcSkaQnQfl6eSjIdgm9XzbXeYx+eMSG4E7eLmO4fevRz" +
                                                              "74Eh085mdTM7o8BwzjErHBMONvejdrPySeEz2j44t+uXP921z9SqJj1Xt0Ip" +
                                                              "euatf7/mPXr9lSzhv1CyKtR70PFTIbvWbR0TUtGi4//Y/cjbGyDG+ElJXJH6" +
                                                              "4tQfcfKE8syIhx3msusm3uEEh6aBfDIfrYA9SyzM+LXM8b6CwTZRlW63nviz" +
                                                              "jTNcaje35ST2WLkhOyfeLuYEvhQZ4WSEj3Vi02g4g3662zjOAiHx4JufjNv0" +
                                                              "yfmbfOnTDxPOGNcuaKbdq7GZg3af7E6wawSjB+gWD6/fWiUP3wKOXcBRhOLB" +
                                                              "2KBDmk+kRUSLemzxO7/+Te32S4XE00bKZFWItAk8uZBSiOrU6IEKIaF9bYUZ" +
                                                              "1HaWQFPFoZIM8BhHZmSPUK0xjfGYMvjzyc8u+8mJd3kwNdd8Kp9ebOAZxl0H" +
                                                              "8IOoncI+vvrE+78a+XGx6ch5tqVr3pR/bpDDe9/7LGORecbOslNd87t8p4/V" +
                                                              "tTzwEZ9vp06cPTuRWVpBcWHPvftU7O+ehqIXPaS4i1SJ1qFvkyDHMSF1wUHH" +
                                                              "SJ4E4WCYNp5+aDEr9KZUaTDNHSocYt1J27n/xrC0vWbn6Wq04hwrVydzdlqe" +
                                                              "5oWd6UOoktcPZ7Ruqte896OTI3v23efBRDG2H1WHVamy6dbH8Wz5yOkj08uH" +
                                                              "rj/GbQ+b6iAyNY9pc3k7D5sF3B08kGINfkJlgERSBNmVaqvy6MlI6brWzaE2" +
                                                              "f0fnxtTGn8Dn89/U5PX1nF69LSVrCvbeDc+dlqw7M9cEv/mJoy87lkJ8XYhN" +
                                                              "LzZuJJPzcLeQbNwcbF2VDYk+SiT3weO1ZHmzWBdfomCa7+HLwJeGk0sEI+UI" +
                                                              "J9jR2tmZHdDgKAEthWexJW1xHkCH8GXvlwaUSwQjFQioozXQ2pwD0be/OKLx" +
                                                              "2FsHz3JL3PIMRIS/PJYdCNSlpZquMggTNOJCMS4PW0aKe+lAC2TxbAC+O0oA" +
                                                              "U+FZZUlalQPAkAkAmwOZeuaabekJ+Rl/trv0PDJKPevh8VuS/Dn0fCKvnrlm" +
                                                              "g5uDngFVFJLnEfeaHsuja8KWOT8lk3+KiOsawyHTkUoJVgfTc9008Yrw5N6h" +
                                                              "E5ENTy7yWDVLM3gOU7WFMpzrZQerQl5furNyO79fs1PckssjhVcPTanIPJgj" +
                                                              "p/ocx+75udO3W8CFvX+t2/hAz/ZRnLhnuPC7WT7VfvqV1XPFQx5+RWhm1Iyr" +
                                                              "xfRJTel5tEynLK4r6ZVrQ8pilWiJO+AJWxYLu33M9gmXsVNnyVxT81Sfz+QZ" +
                                                              "exabM4yUdVO2zrHhbb88e7s9lFbvYcdW3v1USndOjDFsh6X7jtHDzjU1D7Tz" +
                                                              "ecaGsfmFDTsZP2zYz//PsCuTe7LP0r1v9LBzTc0D7Xd5xl7D5kVGxpuw08KR" +
                                                              "Df2l0UNPMDIx280f1v9TMv6GMK/OxbMnKksmn3jwD/z2KXW9XQHH92hclp3l" +
                                                              "qeO9SNNpVOJoKsxiVeNfbzBSl/taEipG/s3Vv2zOeAt0zjYDDrjQOimvMFLl" +
                                                              "pgSO/NtJ90dwKJsOylXzxUlyDbgDCb5e15L3JYu+4H2qX9HijK9roiA9uKds" +
                                                              "N+l2tnPkg9lp0Zb/p5SMjHHzX6WQeO7E2vUP3fzqk+ZNmygLg4PIpRzO7Oal" +
                                                              "Xyq6zsrJLcmraM28W+OfLp2TzDDVpsL2LpjqcNWtULto6D51rmsoozF1G3Xl" +
                                                              "5LLzr+8vugyHjC2kQGBkwpbMw1FCi0Po3xLIdjsBuYffkDWVvb/94mfvFNRY" +
                                                              "5xB+n1Gfb0ZIPHz+ajCqaT/0kFI44UACpQl+cls1oHRQsV9Pu+woCqtxJfX3" +
                                                              "03j0dQH/b+IrYy3ouFQv3tQy0pB575N5ew3H851UX4ncecZx5aO4pjlH+cq2" +
                                                              "YnN/AlcanDEUaNc068Kr6AJfeU3jm/pv2LT9F06aheA4HgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMV6fczkyFmn953d2ZnZzc7s5mtZsrvZZMIlaXjt/ra1CcTd" +
       "drfbdtvutrvd3QeZ+LPbbn+1v9ptWEhyB4lACgE2IaeDFX8EcaANAe4QIBRY" +
       "BBxEQUhBwHF3IkEI6bjjIpE/Dk6Xu+PK7vd73plk7pDufVXl6qqnqn5P1VO/" +
       "p1yuV78CPRKFUCXwnd3S8eNDI4sPbad5GO8CIzqk2aaghJGhdx0liiSQd0d7" +
       "2y/c/LuvfXx16wC6uoBer3ieHyux5XvR2Ih8JzV0Frp5mks6hhvF0C3WVlIF" +
       "TmLLgVkril9kocfOVI2h2+wxBBhAgAEEuIQA46dSoNLrDC9xu0UNxYujDfS9" +
       "0EMsdDXQCngx9ML5RgIlVNyjZoRSA9DCteL3FChVVs5C6K0nuu91vkvhT1Tg" +
       "l3/8/bd+6Qp0cwHdtDyxgKMBEDHoZAE97hquaoQRruuGvoCe9AxDF43QUhwr" +
       "L3EvoKcia+kpcRIaJ4NUZCaBEZZ9no7c41qhW5hosR+eqGdahqMf/3rEdJQl" +
       "0PVNp7ruNewV+UDBGxYAFpqKZhxXeXhteXoMPX+xxomOtxkgAKo+6hrxyj/p" +
       "6mFPARnQU/u5cxRvCYtxaHlLIPqIn4BeYuiZezZajHWgaGtladyJoacvygn7" +
       "IiB1vRyIokoMvfGiWNkSmKVnLszSmfn5Cveej323R3kHJWbd0JwC/zVQ6bkL" +
       "lcaGaYSGpxn7io+/m/2k8qbPffQAgoDwGy8I72V+5Xu++r5vfe6139/LfPMl" +
       "MrxqG1p8R/u0+sQX39J9F3algHEt8COrmPxzmpfmLxyVvJgFYOW96aTFovDw" +
       "uPC18b+df/DnjL85gG4MoKua7yQusKMnNd8NLMcI+4ZnhEps6APouuHp3bJ8" +
       "AD0K0qzlGftc3jQjIx5ADztl1lW//A2GyARNFEP0KEhbnukfpwMlXpXpLIAg" +
       "6FEQoMdBeBba/5XPGArgle8asKIpnuX5sBD6hf7FhHq6AsdGBNI6KA18WAX2" +
       "v/626mEbjvwkBAYJ++ESVoBVrIx9IbxMwVpNDS+G+6ESrCwt4nzdYIwdWWQe" +
       "FpYX/H/oMyvG4db2oYfAFL3lIkE4YG1RvqMb4R3t5aRDfvXn73zh4GTBHI1g" +
       "DBUdH+47Piw7PgQdH5YdH17WMfTQQ2V/bygA7M0BTOYa0AIgzMffJX4X/YGP" +
       "vu0KsMNg+zCYiUIUvjdvd0+JZFDSpQasGXrtU9sPTb8POYAOzhNwARpk3Siq" +
       "CwVtntDj7YsL77J2b37kr//us598yT9dgucY/YgZ7q5ZrOy3XRze0NcMHXDl" +
       "afPvfqvyy3c+99LtA+hhQBeAImMFmDRgn+cu9nFuhb94zJaFLo8AhU0/dBWn" +
       "KDqmuBvxKvS3pznlvD9Rpp8EY/xYYfLPgzA9WgPlsyh9fVDEb9jbSTFpF7Qo" +
       "2fi9YvCTf/aH/7leDvcxcd884wpFI37xDFkUjd0saeHJUxuQQsMAcn/+KeHH" +
       "PvGVj/zT0gCAxNsv6/B2EXcBSYApBMP8/b+/+fdf/tKn//jg1Ghi4C0T1bG0" +
       "7ETJIh+6cR8lQW/fcooHkI0DFl9hNbcnnuvrlmkpqmMUVvo/b76j+sv/9WO3" +
       "9nbggJxjM/rWr9/Aaf43daAPfuH9f/9c2cxDWuHsTsfsVGzPoK8/bRkPQ2VX" +
       "4Mg+9EfP/ovfU34ScDHgv8jKjZLSrpVjcK3U/I1gu3DpAj27NEHz77rP1ii0" +
       "XDBv6ZE7gV966svrn/jrz+xdxUXfc0HY+OjLP/gPhx97+eCMg377XT7ybJ29" +
       "ky4N7nX7ufsH8PcQCP+7CMWcFRl7kn6qe+Qp3nriKoIgA+q8cD9YZRe9//TZ" +
       "l379X730kb0aT533TyTYfn3mT//XHxx+6i8+fwnlXbGOdmW1ImrtbQyNgSn4" +
       "3rJIN0+jS+W0lRKWpaWecJn/7jI+LBQr5w8qy7pF9Hx0lqDOT9CZjeMd7eN/" +
       "/Levm/7tb3y1xHx+53l2PQ6VYD/CTxTRW4sBe/NFNqaUaAXkGq9x33nLee1r" +
       "oMUFaFEDnibiQ+ATsnOr90j6kUf/w2/99ps+8MUr0EEPuuH4it5TSiKErgMG" +
       "MqIVcCdZ8B3v2y/A7TUQ3SpVhe5Sfj9YT5e/btzfQHvFxvGURp/+H7yjfvgv" +
       "//tdg1Cy/yU2e6H+An71J57pfvvflPVPabio/Vx2t58Em+zTurWfc//bwduu" +
       "/u4B9OgCuqUd7eCnipMU5LYAu9boeFsPdvnnys/vQPfbrRdP3MxbLi6aM91e" +
       "dACnxgrShXSRvnGB84sAveOI94/5/xznl156P8cFpMMB2HAvjfCpv/ypT//9" +
       "hz6CHhSk80haQAejcutUjkuKF4UfePUTzz728l/8UEnKgJE/XjQ6Krt/oYxv" +
       "F9E/Kef3ANB1VL5uxEATy1OcEmwrhq4z5PxObzAWpZMVdausTRTReG8k/Xsa" +
       "FHui7tNFbg2Edx6p+8671S2ekyL6rsthXimS7yyiWRHNz4GU5gJJXAby/Q8I" +
       "EgXh8Ajk4SVzUiREMKA/UiT0B0P6WIFUGJOieDlW4wGxYiA0jrA27oP1R4uE" +
       "82BYHy+wjkmWxO8B1v3GwT5R5D4DwnuPwL73LrBQmYgvxwj2E9eD0I/BkjT0" +
       "Y4CPro1dF3jPy7AlD4jtm0EgjrAR98D2PffAViSzc6COvMt3XAD10gOCeg6E" +
       "wRGowT1A/bNvBNRjABTra8rx5u/iaP3zrwusbAhYFOCH2mH7ECl+/+CD2dOb" +
       "bUe7fbxfmBphBMDctp328TbpDIPtX/8vgGx9wyABbT5x2hgL9gQv/tBfffwP" +
       "fvjtXwacSR9zZiEtgZESPkneel/x48ceTJ9nCn3E8uWPVaJ4WG4wDb1QqZB4" +
       "z/81/PgmQjWiAX78N5wuTHk7ybKJ6aGU2cBhnMSHfZvsd7a9Ki3i6yzorOwt" +
       "Si4kW1ltnS6fqkjTgCmj7QX1PNjpkyU9xRF/Mx721zHem2wm45jsYGOHWcUb" +
       "pzNTJ6xIk/KIwWsrQpKag9paCpjuRpuCXWoCc+24nrRnyCiow0hA11W37uX1" +
       "NOUMWDDctidx6Go+2mmcu+mQnS6qIoy9Igy6PeFwru+6444mzLssskJ1Eqaw" +
       "Boau1YBaokHLYm1jK9qz8WhYsxZjXqaRteGKc7vTIRU38+LBIF/amyrTaaUo" +
       "vp4aa2u9kwgK49biYjxPss1KZDs0gvNr2e0MHZTOxiki48jC7bDLmrBpcSHm" +
       "cEhntOwpzIbQl1IrHrgxYffXxMLd5cP5ZhRGpOD3Zs2Mjix02Ve2gb/g21xv" +
       "YrToxbS5mdDNGFnVa2DDz4V4OvZYROggTcWoE+ligsryfNC1mJ29Iv3GUNnE" +
       "mTDY9kTFNGo7e+xidC9dawOcmWmjITaYi3hYXU5xs0vWrVhx8Eq9N7E0XZni" +
       "LYqW1lNFHGyyoRXpXUXx8SizkNqotd1qYmD1vAnajwlOUmjB1dckqgV62hJS" +
       "dRM0Apqe6kGPFnmH1MnFeDlgRmwvkPpbZ1R3reG4n6yt6sifp7SwWVtgdJpK" +
       "VdnuAjnrzanedpmI+byvG37uzhRlK8udftaa9cWN5w9mzUnTgce+6synybYX" +
       "hPMcGJBLwnh3J40IEmN8IpWnQh8jA2YlxOOKD+w1WlRHeEeyavwEU5bBRB5O" +
       "cCkY2GAOo00HqeRhp7IYJ4NOLVwu002d03fDoVytLsVsWrHcwURxE97tNled" +
       "kWMyvW3XHUoUI2mT5jKQNjNnnNcStVepzfuUQ8jMKhPxfEVudpsVzE92Gx2p" +
       "b/xefzPBllQzEpnKnKJWuj/DPLC2DJpmXUZquqaZso41Muvb3U7lqt0t0kcH" +
       "7c1w1W1E3rZCppKczGN2MqqKtjRdc0RD0ewmu4yVAYLQhEhz6ty3CW8jLdGh" +
       "ztaqlUpHwnakwMDMeDDlpw1C2PmyM7ZdayyZ0nS66Ta2/bQvTTYBKadWw8sk" +
       "wkA64oZz24OxX2UEXhpKbMo4bFOtWhbDEjgtAtNFXHoTOXVJxjGYqK3ICcM0" +
       "RHKKkluv6evwsMU2jXg0x0au5ZMW0wJjyiQ0tYSZ+Whbbdho1w/SsNsQKlg3" +
       "08GELoec0iJGcDBJ9chb9kxkQgmjKoYIRls2mWhXl1cGQq3XSHXNofJao+SQ" +
       "kqxmy4PH2Jr2cJ1OthGD45I0G1LdjlerroKp7eAYjbd707ZqCJ24VZ2NKnWC" +
       "kLs2012GNXfeRWdtfNaZWe25iyBbRrSXqKVY+GbeXhK99kDM8BnTmldhl4v1" +
       "tM5lYpeq+e2sgTtrapyMg+YmMjhqmFhUxvEzfj1PUqdZ262HKNlnu2vGjBZc" +
       "f+5Y+XDGGOHAr+LxcDPlgGkiTa09kaXpcrs166rjIZVWqhE1DR2jC9ufjVY6" +
       "T/TZqTRYhXolb6h1NMCoerPVTnv6ZoV0kBXNDJeYmw8lHEm6tXAVoyK9hSf1" +
       "ZYINmWS8RBc4RjIDeyTNSb2DMnF9hyzZIVmn54PqXFx2tlNuai/9jNiNVmrm" +
       "BYiumPoWqyVuiAmdDj9rNFoqrqGusk13araLq2pXV1k/AGuK7YD1v8uTaqMG" +
       "w7AF11F+yjeByYxRNg2YnCaVZCSPaoIYy7VurT1hRnJLyBCOspu7OYbKbQ/D" +
       "h1KibslFJO86/eXIWbkqnGtxZapUKobJcXZltyMWHUQYYTVJHFCk6TByZye1" +
       "EgURMsJfYHazJRk80fUsp0fLZERm2RrehVrUspp5ozLpz1rL0RYTJV3RqKiv" +
       "p6jOoB4R1hrqxtCj7loaxqai1OSxi9PYUqu1ZV0mcWxiR4mUY53MIBtNnBkI" +
       "WwWxCIdUZTJESHqcN3qbQI5QjVz0RzliohqfVZlsmDVqcq87m7vdnWklY0+J" +
       "9JYZx6jR3SxoluEieT3rG8isnlXykbZqrwZOH3e3VDZRmpht57NNfZtVQqnH" +
       "YUSAdg2hRRBNf8Cju8mE46ymIi82mrhWRt7IdFqGaA/0pYvNcnVmzLOKMRT7" +
       "DbJtsC7fMI10nLcb5ApBm64uDds+2tnmNhlSnSHPpYath8JONMi8ZjcacSWZ" +
       "CVitmmPihrarsxgZBEaixGYbdoUZ8Fpivkqr3R0Tj9uI0JMGaiqrY0SaxH2r" +
       "AcNzWLPV/o7oV0iHntFUqxGPTM1kSDTaDVZZ3Y2SyK0nJLlqKR2TGJjhHMdE" +
       "4PAq7GyIqq3uVlqMHblV91IrtyVOU2yj3hSlmsyuV/zONNhkTqar0aIhi6Rd" +
       "nwI3tGws661WLbd5HCy9Bp2YNpciO9NVTd6TiEzg+5yWKIyqb9r9xbKumG2y" +
       "tVWAf+9UljLRgk3Zmgj1LcPPtM54xbOdGtMh3HVlPZ6IrOHmGd+GK5JRr4mN" +
       "GYkgKrPoyYMYX6PJoiNafDhpDcDaUnqYOp8sqpQij3pCz18MhmhnRS1cUZgw" +
       "SGab/fkwtfOdhiYV1KX1+nrL6TrKBJih8vgicxAKHfC+pw0qaRqSlTaqVGbA" +
       "2WmrZryZhvVgDKsBQRgY3Gb7/NjQVD5yOB1tx2jQgKexlIPlg6UB0tIEKRnL" +
       "06CjyZSQmvGkzVeM1WYwExSxYVVFuroBvn9HUEOxV91OKEqkG2RD7s65oFlR" +
       "CDLEmMVEkQiOEn1tHlfpWtuDs7CLgJn2WvIGaay24XSn57qzMZq+rLcmvL+O" +
       "NWHRHieb2ECxFi8N6mmtbpidMdGvUVWZmirurqWrFCrnzR2/thE0oUIb7quj" +
       "itqy8B03xwKtvm4TzahX7yDouj/gzDXtLMmx2OHcqbJJd62hM2ipoZwrZM1E" +
       "TC+Lpb6HEh6KwZOmMKt6vRbGitOwm6oGoVUAvG17iGlkCru0v0PbzppGZ/MV" +
       "x+aLhKaFXGONkcptNbVXmxLzdUW0pPrW4KsLys3ljm76bldpVyh2Sxv9NRKR" +
       "g8pkQGP2uBa7C0onlgxOxivZyGi5mlHrLoX2Z6mzVSbidmT3Rpbv57NRLdgS" +
       "iGrAPMNmtV5E5XWarQuD4XggwgI917uc6ASLTTJcLiWOp7tDsSHIiMIYFQfv" +
       "1qRMxbsVHvHxSaW3WEwcxRkJ+Br8u1t+AdalohprujJ24DhMEYGgGcFIV+g0" +
       "EWHCQ8wuk3qh4y6bCQEc6bRHsx5pGgoVJbaCMjIvoc66XmEsPgJbLkpaT3x6" +
       "ujQlDUMQdB5um1xrRTZJTtq1dzIxZYf1JT9py71hkIeLkRGOnKaZhNyOb2Nm" +
       "VBW0dRTZqykwP8UbCPTSDmBfyyrtZqLzdRnt9tJZJa7BKzyHF2C3uvISoduW" +
       "pfbUTDfT6kzojbJmZSyv3OpgF2bmmJYMpxmTO49lGmFrMQ1HKHhLky2ar+C0" +
       "nM3ZpF4fYkt3Fk05bzfNJLQqmnlltDAyRR02dhN9ytfykFqpKooa7Qhzemo6" +
       "13S5nlYnoqfzNtGLVq1Z244pIrcnVaIt5Yam9CPT7RFStBBq+TyHYSHqJpLR" +
       "ZgUkrKYY28klDSHaM72ZOcBc19N+FiRbBGXGhFlzkAknDIlBVkMRE0hLw7TV" +
       "HzIwn6lDj1lHrle3twSc15iZjM1GFIXVVpoT1MFK4jGR44IpT/sM2F5PDc5U" +
       "844IZlYhraAPR/VpWst5A4+R3J4TRGiPeMtNhz3WCZYiD3MxjSH6lqEjfufM" +
       "8mzi7Ah1SXTVplFtssDRJ5UGVdvMMMqyGSz0LRxLGD3iKk4t9oT1EnMCZKHC" +
       "QVMc2hSVz1ryyODbZC0F3Gjmm3Vlwbm7JbtsCINgnPNtXnFmu00rj0Ka1dxQ" +
       "GdZQucKbbFCTcoKYBhFbYwN7o3FyPGFjv0U0q6EbgTXRq/brM6fJsnlYQdNk" +
       "uaPsbm096nfW20Adbqu9roUIfj1jB7oddZK5aa4JeZqqMNZwzbTHjefNrFPx" +
       "qn1TRRYDgcorit3dKBKMrHuDRmOCd4ORU9GcqOpT41E0xYSksvW74AWINmd1" +
       "pG4j+oiC1cognO/qftIbpfV4tEOCTrPd5JrGtk6hzepk1vA0Q1tkTYVvBLZD" +
       "VbRNbe5xMO5oikeQE4XTkBbKhC2cNo1J3XbhIK2xEtZDWsrKwBvUEseLV+d/" +
       "+WCv70+WxxEnVxOO3tp/+AHe2vdFLxTRO04Obsq/q9CFz9lnDm7OHKtDxcH/" +
       "s/e6cVB+Jfn0h19+Red/unpw9DkCi6HrsR98m2OkhnOmqSugpXff+4R+WF64" +
       "OD0m/70P/5dnpG9ffeABPtA+fwHnxSZ/dvjq5/vfov3oAXTl5ND8rqsg5yu9" +
       "eP6o/EZoxEnoSecOzJ89GdmbxYh9Ewjq0ciqF4/ETufu8vOwd+7n/j5fe37x" +
       "PmX/uohejaEbSyNmzpw8nhrLZ77eEc/ZJsuMnz3RrhQrTkjtI+3sf3ztPnef" +
       "st8sol891e74CPNUu1/7f9Du5vFK2Bxpt/nH1+7z9yn7QhH9Tgw9sdfu3Fno" +
       "qYa/+yAaZjH0hsuuVxTfip++667X/n6S9vOv3Lz25lcm/668YXByh+g6C10z" +
       "E8c5+9noTPpqEBqmVepxff8RKSgffxRDz9z77kcMPVI+S+Bf3Nf4E4D5shox" +
       "dAXEZyX/LIZuXZQELZbPs3L/EVjMqVwMXd0nzop8CbQORIrkl4Pjw97qN3hp" +
       "ZeAFSVyOa/bQeeY8mbWnvt6snSHbt5+jyPLi3jGdJfure3e0z75Cc9/91dZP" +
       "729TaI6S50Ur11jo0f3FjhNKfOGerR23dZV619ee+IXr7zim7yf2gE+N/Qy2" +
       "5y+/ukC6QVxeNsh/9c3/5j0/88qXyg96/weY9eDiUSkAAA==");
}
