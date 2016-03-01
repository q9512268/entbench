package org.apache.batik.gvt.flow;
public class FlowTextNode extends org.apache.batik.gvt.TextNode {
    public FlowTextNode() { super();
                            textPainter = org.apache.batik.gvt.flow.FlowTextPainter.
                                            getInstance(
                                              ); }
    public void setTextPainter(org.apache.batik.gvt.TextPainter textPainter) {
        if (textPainter ==
              null)
            this.
              textPainter =
              org.apache.batik.gvt.flow.FlowTextPainter.
                getInstance(
                  );
        else
            this.
              textPainter =
              textPainter;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Yb2wUxxWfO/83xj4bsAkEA+Ygwklui/IHtaYl4NjB5Gyf" +
                                                              "bIJUk+aY2527W7y3O+zO2WenLiFSCsoHFAUnpVXxJ6K0EQlR1aiVqiBXlZpE" +
                                                              "aRpBozZ/lKRVPzT9gxS+hFa0Td/M7N3u7d057Zdaur29mTdv5r33e7/3xhev" +
                                                              "oQbHRn0UmxqOsTlKnFiCvyew7RBt0MCOcwhGk+qTfzh74sZvWk6GUeMUas9i" +
                                                              "Z1TFDhnWiaE5U2iTbjoMmypxxgjR+IqETRxiz2CmW+YUWqc7Izlq6KrORi2N" +
                                                              "cIHD2I6jTsyYrafyjIy4ChjaHBenUcRplH1BgYE4alMtOuct2FC2YNA3x2Vz" +
                                                              "3n4OQ5H4MTyDlTzTDSWuO2ygYKPbqWXMZQyLxUiBxY4Z97iOOBi/p8INfS93" +
                                                              "fHbzqWxEuGENNk2LCROdCeJYxgzR4qjDGx0ySM45jr6F6uJolU+YoWi8uKkC" +
                                                              "myqwadFeTwpOv5qY+dygJcxhRU2NVOUHYmhruRKKbZxz1STEmUFDM3NtF4vB" +
                                                              "2i0la4vhDpj4zO3K4nceifyoDnVMoQ7dnOTHUeEQDDaZAoeSXIrYzj5NI9oU" +
                                                              "6jQh4JPE1rGhz7vR7nL0jIlZHiBQdAsfzFNiiz09X0EkwTY7rzLLLpmXFqBy" +
                                                              "fzWkDZwBW7s9W6WFw3wcDGzV4WB2GgP23CX107qpCRyVryjZGH0QBGBpU46w" +
                                                              "rFXaqt7EMIC6JEQMbGaUSQCfmQHRBgsgaAus1VDKfU2xOo0zJMnQ+qBcQk6B" +
                                                              "VItwBF/C0LqgmNAEUdoQiJIvPtfG9px51DxghlEIzqwR1eDnXwWLegOLJkia" +
                                                              "2ATyQC5s648/i7tfPR1GCITXBYSlzE++ef2+O3qXX5cyG6vIjKeOEZUl1Qup" +
                                                              "9iu3Du78ch0/RjO1HJ0Hv8xykWUJd2agQIFpuksa+WSsOLk88cuvP/YC+WsY" +
                                                              "tY6gRtUy8jnAUadq5ahuEPsBYhIbM6KNoBZiaoNifgQ1wXtcN4kcHU+nHcJG" +
                                                              "UL0hhhot8RtclAYV3EWt8K6baav4TjHLivcCRQg1wQe1wWcrkn/im6GMkrVy" +
                                                              "RMEqNnXTUhK2xe3nARWcQxx412CWWkoK8D99567YbsWx8jYAUrHsjIIBFVki" +
                                                              "J5XMDFPShjUL8LVmD0FCjQE9xTjg6P9vqwK3es1sKAQBuTVIBwZk0gHL0Iid" +
                                                              "VBfz+4euv5R8U0KNp4frL4Z2wH4xuV9M7BeD/WJ8v5h/PxQKiW3W8n1lzCFi" +
                                                              "05D7QL5tOye/cfDo6b46ABudrQd3c9EdFcVo0COJIrMn1YtXJm68/VbrC2EU" +
                                                              "Bh5JQTHyKkK0rCLIgmZbKtGAkmrVhiI/KrWrQdVzoOVzsycPn/iSOIef5LnC" +
                                                              "BuAnvjzBqbm0RTSY3NX0dpz65LNLzy5YXpqXVY1isatYydmjLxjUoPFJtX8L" +
                                                              "fiX56kI0jOqBkoCGGYa0AYbrDe5RxiIDRUbmtjSDwWnLzmGDTxVptJVlbQBA" +
                                                              "aUSgrVO8r4UQr+Jp1QOfbW6eiW8+2035s0eik2MmYIVg/K9O0vPv/vrPdwl3" +
                                                              "F4tDh6+qTxI24CMkrqxLUE+nB8FDNiEg9+G5xNlnrp06IvAHEtuqbRjlz0Eg" +
                                                              "IgghuPmJ14+/9/FHF94Je5hlUJHzKWhuCiUj+ThqXcFIjnPvPEBoBmQ6R030" +
                                                              "IRNQqad1nDIIT5J/dmzf9crfzkQkDgwYKcLoji9W4I3fsh899uYjN3qFmpDK" +
                                                              "C6rnM09MsvQaT/M+28Zz/ByFk1c3ffc1fB74HjjW0eeJoE0kfIBE0O4W9ivi" +
                                                              "eVdg7l7+iDp+8Jfnl6/xSapPvfPp6sOfXr4uTlveOfljPYrpgIQXf2wvgPqe" +
                                                              "INEcwE4W5O5eHns4YizfBI1ToFEFynTGbWC5QhkyXOmGpvd//ovuo1fqUHgY" +
                                                              "tRoW1oaxSDLUAugmThYIskD33ieDO9sMj4gwFVUYz/25uXqkhnKUCd/O/7Tn" +
                                                              "x3ueX/pIgEqiaKO7XPzYwR/9JXSJv8ZgqfKjq0yDjTbV6iZEJ3Th8cUlbfy5" +
                                                              "XbLmd5VX6CFoQF/87b9+FTv3+zeqlIEWZtE7DTJDDN+enMW3VrD4qGi2PAba" +
                                                              "ffVG3QdPr2+rJHCuqbcGPffXpufgBq89/pcNh76WPfo/MPPmgKOCKn84evGN" +
                                                              "B3aoT4dFvyhJuaLPLF804HcZbGoTaIxNbhYfWS3g21fOjrvhc5sb2tuqs2MV" +
                                                              "VJQ4p9bSQHaG3Fjx3+sZ2lK1oPM6nsCixRY7T6yQ4of5Y5Shdmi7fOsADDtX" +
                                                              "uGHZeg6IesbtUZWFro+nv//JixKLwYY2IExOLz75eezMosSl7Pq3VTTe/jWy" +
                                                              "8xenjUjHfQ5/Ifj8m3+4KXxAdn5dg277uaXUf1JaENhe4Vhii+E/XVr42Q8W" +
                                                              "ToVd1wwxVD9j6fKqsZs/xmRmf+W/4xA+sLfAUJu/t+LMsr7iNidvIOpLSx3N" +
                                                              "PUsP/U7U99ItoQ0qYzpvGD5A+sHZSG2S1sWJ2ySvUvGVZuiWmv0emMa/xKGJ" +
                                                              "lNcZWltNnqE6ePolIX8iQUmGGsS3X85iqNWTg4orX/wi0LvUgQh/dWgR1Ztq" +
                                                              "opp7sBCq5FoRnXVfFB0fuW4rA7e4hBfZIy+v4Un10tLBsUev3/uc7Frg+j4/" +
                                                              "Ly5tcAeVDVSJgbbW1FbU1Xhg5832l1u2F7HVKQ/s8cJGX07uhQynHCgbAiXd" +
                                                              "iZYq+3sX9lx+63TjVUijIyiEGVpzxHcFlvc96AvyQI9H4n5a9/0rR3QbA61/" +
                                                              "PPr2398PdYk65haC3pVWJNWzlz9IpCn9Xhi1jKAGSB1SmII7vXP/nDlB1Bmo" +
                                                              "uM15Uz+eJyMa4DNl5c3Sfb2doxrzC7rwjOvQ1aVR3vUy1FdJCJU3ASjxs8Te" +
                                                              "z7ULVg5wdp5S/2yB32OrWAWx2XX+Hye+/e44ZF3Zwf3ampx8qkT//n8HePUg" +
                                                              "wh8PFyQN1SXjo5S6tNT4oYgqpYISTgmjn5DSXIKhUD+l/wFZP+2p1hMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL05acwrV3Xzvpe3JuS9BEhCSvYHNDF8Y8/ipQ9KPLbHHnu8" +
       "jD2L7RYe49nHs3k2j4emBdQ2CNQUtYFSCfIL1BaFRVVRkSqqVFULCFSJCnWT" +
       "CqiqVFqKRH6UVqUtvTP+Fn/fey8IVaqluXN97znnnnPPcs898+L3oHOBDxU8" +
       "19polhvuK0m4b1r4frjxlGC/S+Mj0Q8UuWGJQcCCsRvS45+78oMffki/uged" +
       "n0OvFh3HDcXQcJ1grASuFSsyDV05Hm1Zih2E0FXaFGMRjkLDgmkjCK/T0J07" +
       "qCF0jT5kAQYswIAFOGcBrh9DAaRXKU5kNzIM0QmDFfSL0BkaOu9JGXsh9NhJ" +
       "Ip7oi/YBmVEuAaBwMfvPA6Fy5MSHHj2SfSvzTQJ/uAA//1vvvPr7Z6Erc+iK" +
       "4UwydiTARAgWmUN32Yq9UPygLsuKPIfucRRFnii+IVpGmvM9h+4NDM0Rw8hX" +
       "jjYpG4w8xc/XPN65u6RMNj+SQtc/Ek81FEs+/HdOtUQNyHrfsaxbCclsHAh4" +
       "2QCM+aooKYcodywNRw6hR05jHMl4rQcAAOoFWwl192ipOxwRDED3bnVniY4G" +
       "T0LfcDQAes6NwCoh9OBtiWZ77YnSUtSUGyH0wGm40XYKQF3KNyJDCaHXngbL" +
       "KQEtPXhKSzv6+d7grc+92+k4eznPsiJZGf8XAdLDp5DGiqr4iiMpW8S7nqI/" +
       "It73xffvQRAAfu0p4C3MH/7Cy0+/+eGXvryF+albwAwXpiKFN6RPLO7++usb" +
       "T9bOZmxc9NzAyJR/QvLc/EcHM9cTD3jefUcUs8n9w8mXxn8+e8+nlO/uQZcp" +
       "6LzkWpEN7OgeybU9w1L8tuIovhgqMgVdUhy5kc9T0AXQpw1H2Y4OVTVQQgq6" +
       "w8qHzrv5f7BFKiCRbdEF0Dcc1T3se2Ko5/3EgyDoAnigu8DzGLT95e8Q0mDd" +
       "tRVYlETHcFx45LuZ/JlCHVmEQyUAfRnMei68APa/fEtpvwIHbuQDg4RdX4NF" +
       "YBW6sp2EtTiEVctdA/N11yxwqIErK/uZwXn/f0slmdRX12fOAIW8/nQ4sIAn" +
       "dVxLVvwb0vMR0Xr5Mze+unfkHgf7FUJvBOvtb9fbz9fbB+vtZ+vt764HnTmT" +
       "L/OabN2tzoHGlsD3QVS868nJO7rvev/jZ4Gxees7wHZnoPDtg3PjOFpQeUyU" +
       "gMlCL310/V7+l4p70N7JKJvxCoYuZ+ijLDYexcBrp73rVnSvPPudH3z2I8+4" +
       "x352ImwfuP/NmJn7Pn56V31XUmQQEI/JP/Wo+PkbX3zm2h50B4gJIA6GIrBb" +
       "EGIePr3GCTe+fhgSM1nOAYFV17dFK5s6jGOXQ90HGjgaydV9d96/B+zxnZld" +
       "3w+eJw4MPX9ns6/2svY1W/PIlHZKijzkvm3iffxv/uKf0Xy7D6PzlZ3zbqKE" +
       "13ciQkbsSu779xzbAOsrCoD7+4+OfvPD33v253IDABBP3GrBa1nbAJEAqBBs" +
       "8698efW33/rmJ76xd2w0ITgSo4VlSMmRkNk4dPkVhASrvfGYHxBRLOBqmdVc" +
       "4xzblQ3VEBeWklnpf115Q+nz//rc1a0dWGDk0Ize/OMJHI+/joDe89V3/vvD" +
       "OZkzUnaiHe/ZMdg2TL76mHLd98VNxkfy3r986Le/JH4cBFwQ5AIjVfK4BeV7" +
       "AOVKg3P5n8rb/VNzpax5JNg1/pP+tZN53JA+9I3vv4r//h+/nHN7MnXZ1XVf" +
       "9K5vzStrHk0A+ftPe3pHDHQAh700+Pmr1ks/BBTngKIEYlYw9EGYSU5YxgH0" +
       "uQt/9yd/et+7vn4W2iOhy5YryqSYOxl0CVi3EuggQiXe25/eKnd9ETRXc1Gh" +
       "m4TfGsUD+b+zgMEnbx9fyCzzOHbRB/5zaC3e9w//cdMm5JHlFgfuKfw5/OLH" +
       "Hmz87Hdz/GMXz7AfTm4OvSBLO8ZFPmX/297j5/9sD7owh65KBykgL1pR5jhz" +
       "kPYEh3khSBNPzJ9MYbbn9fWjEPb60+FlZ9nTweU45IN+Bp31L+/Gkx+B3xnw" +
       "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" +
       "t/7OC9/MK1T/C6jrk4QYHwAA");
}
