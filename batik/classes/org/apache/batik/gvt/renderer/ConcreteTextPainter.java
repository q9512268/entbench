package org.apache.batik.gvt.renderer;
public abstract class ConcreteTextPainter extends org.apache.batik.gvt.renderer.BasicTextPainter {
    public void paint(java.text.AttributedCharacterIterator aci, java.awt.geom.Point2D location,
                      org.apache.batik.gvt.TextNode.Anchor anchor,
                      java.awt.Graphics2D g2d) { java.awt.font.TextLayout layout =
                                                   new java.awt.font.TextLayout(
                                                   aci,
                                                   fontRenderContext);
                                                 float advance =
                                                   layout.
                                                   getAdvance(
                                                     );
                                                 float tx =
                                                   0;
                                                 switch (anchor.
                                                           getType(
                                                             )) {
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_MIDDLE:
                                                         tx =
                                                           -advance /
                                                             2;
                                                         break;
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_END:
                                                         tx =
                                                           -advance;
                                                 }
                                                 layout.
                                                   draw(
                                                     g2d,
                                                     (float)
                                                       (location.
                                                          getX(
                                                            ) +
                                                          tx),
                                                     (float)
                                                       location.
                                                       getY(
                                                         ));
    }
    public ConcreteTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YX2wcRxmfO/+J7dg+24mdkMZO4lwiOXXumtJAK6el9sVO" +
       "Lj07lp1G4NBc5nbn7jbe293sztpnF5e2EkrgIYpSpw2o9ZOrAmqbClEBglZG" +
       "lWirAlJLBBTUFIkHwp+IRkjlIUD5Zmb3dm/v7Kg8cNLN7c188/2f3/fNvngD" +
       "1Vkm6iEajdE5g1ixYY2OY9MickLFlnUM5tLSMzX4Hyevj90XRvVTqDWPrVEJ" +
       "W2REIapsTaFuRbMo1iRijREisx3jJrGIOYOpomtTqFOxkgVDVSSFjuoyYQTH" +
       "sZlC7ZhSU8nYlCQdBhR1p0CTONckPhhcHkihZkk35jzyzT7yhG+FURY8WRZF" +
       "banTeAbHbaqo8ZRi0YGiie40dHUup+o0Roo0dlrd77jgSGp/hQt6X4l8fOtC" +
       "vo27YAPWNJ1y86wJYunqDJFTKOLNDqukYJ1Bj6GaFFrvI6YomnKFxkFoHIS6" +
       "1npUoH0L0exCQufmUJdTvSExhSjaUc7EwCYuOGzGuc7AoYE6tvPNYO32krXC" +
       "ygoTL90ZX3zmZNv3alBkCkUUbZKpI4ESFIRMgUNJIUNMa1CWiTyF2jUI9iQx" +
       "Fawq806kOywlp2FqQ/hdt7BJ2yAml+n5CuIItpm2RHWzZF6WJ5Tzry6r4hzY" +
       "2uXZKiwcYfNgYJMCiplZDHnnbKmdVjSZom3BHSUbow8BAWxdVyA0r5dE1WoY" +
       "JlCHSBEVa7n4JKSelgPSOh0S0KRoy6pMma8NLE3jHEmzjAzQjYsloGrkjmBb" +
       "KOoMknFOEKUtgSj54nNj7MD5R7XDWhiFQGeZSCrTfz1s6glsmiBZYhI4B2Jj" +
       "857U07jrtXNhhIC4M0AsaH7wlZsP9vesvCVo7qhCczRzmkg0LS1nWt/dmui7" +
       "r4ap0WDolsKCX2Y5P2XjzspA0QCE6SpxZIsxd3Fl4mdfevy75K9h1JRE9ZKu" +
       "2gXIo3ZJLxiKSsxDRCMmpkROokaiyQm+nkTr4DmlaETMHs1mLUKTqFblU/U6" +
       "/w8uygIL5qImeFa0rO4+G5jm+XPRQAi1wRd1wrcXiQ//pUiO5/UCiWMJa4qm" +
       "x8dNndlvxQFxMuDbfDwDWT8dt3TbhBSM62YujiEP8sRZyM3QOARBhkiYAE6a" +
       "ZBJKjsFRGsc8c2Ms24z/k5wis3fDbCgEodgaBAIVztBhXQUOaWnRHhq++XL6" +
       "HZFk7GA4nqJoH4iOCdExLjoGomOu6FgV0SgU4hI3MhVE4CFs0wAAgMDNfZOP" +
       "HDl1rrcGMs6YrQWfM9LeskqU8FDChfa0dKWjZX7HtX1vhFFtCnVgidpYZYVl" +
       "0MwBZEnTzqluzkCN8krFdl+pYDXO1CUiA1KtVjIcLg36DDHZPEUbfRzcQsaO" +
       "bHz1MlJVf7RyefaJ41+9K4zC5dWBiawDYGPbxxmml7A7GkSFanwjZ69/fOXp" +
       "Bd3Dh7Jy41bJip3Mht5gTgTdk5b2bMevpl9biHK3NwJ+Uwgyg8aeoIwy+Blw" +
       "oZzZ0gAGZ3WzgFW25Pq4ieZNfdab4cnazoZOkbcshQIK8ipw/6Tx3G9/+efP" +
       "ck+6BSPiq/SThA74QIox6+Bw1O5l5DGTEKD74PL4U5dunD3B0xEodlYTGGVj" +
       "AsAJogMe/NpbZ97/8Nry1bCXwhSqtJ2BZqfIbdn4CXxC8P0P+zJgYRMCYDoS" +
       "DsptL8GcwSTv9nQDwFMBDFhyRB/WIA2VrIIzKmHn51+RXfte/dv5NhFuFWbc" +
       "bOm/PQNv/jND6PF3Tv6zh7MJSazgev7zyASKb/A4D5omnmN6FJ94r/ubb+Ln" +
       "oB4ABlvKPOGwirg/EA/gfu6Lu/h4T2Dt82zYZflzvPwY+RqjtHTh6kctxz96" +
       "/SbXtryz8sd9FBsDIotEFEBYAjlDGcyz1S6DjZuKoMOmIFAdxlYemN2zMvbl" +
       "NnXlFoidArESALF11ATcK5alkkNdt+53P32j69S7NSg8gppUHcsjmB841AiZ" +
       "Tqw8YG3R+MKDQo/ZBrcIFVGFhyomWBS2VY/vcMGgPCLzP9z0/QMvLF3jaWkI" +
       "Hnf4Ge7mYx8b+vl8mD3upagBZwAdQNliyW/8E1nDb+XsTdS9WgfDu6/lJxeX" +
       "5KPP7xN9Rkd5VzAMTe9Lv/73z2OX//B2lQLUSHVjr0pmiOqTyYpGd1nRGOXN" +
       "nQdcH7Re/OOPormhT1Mv2FzPbSoC+78NjNizOv4HVXnzyb9sOfZA/tSngP5t" +
       "AXcGWX5n9MW3D+2WLoZ5JytQv6IDLt804HcsCIWqbZsaM5PNtPCDs7OUAOtZ" +
       "YO+H714nAfqDB0dgdNXECvHE8rKJZ0mTy6QKswBS1HIutfz/Zop28cxn95FY" +
       "6XYoJ/KYpSwxk5RwWHapOzk1nqWxHNEL0HNCU3L3QXc1WrWdYd3LGAQ3Ogit" +
       "l8dqQ4nVIRMbeUWy7j7I7f7iGtCWYcMERXUGa4cgT/vWuHCaSgFq1IzTsscX" +
       "Oj6cfvb6S+KYBPv7ADE5t/iNT2LnF8WREZegnRX3EP8ecRHiSraxIcYO7o61" +
       "pPAdI3+6svDjby+cDTsGHqGodkZXxEXqXjZMilAf+B/BjU0MGUXwd5VukkHf" +
       "5opLrLh4SS8vRRo2LT38G37IS5ejZjiuWVtVfdnuz/x6wyRZhZvSLMqFwX/O" +
       "UNS9ZrMLSOk+ciMMsY9Ck1htH0U1MPopZylqC1JCovBfP908RU0eHTQX4sFP" +
       "sgDcgYQ9Pma4+Rpbu1cfwpYi+VxbDFUWiXtFA3abePqAf2dZdvOXEi5m2eK1" +
       "BPTuS0fGHr35uedFxyapeH6eX2LhTi76whLu7ViVm8ur/nDfrdZXGne52VjW" +
       "Mfp141kFWMS7qy2BFsaKljqZ95cPvP6Lc/XvwTk6gUIYsvCE75WAuP9CH2RD" +
       "wTmR8kqO76UW760G+r4190B/9u+/5/XXKVFbV6dPS1dfeORXFzcvQw+2Ponq" +
       "4KCR4hRqUqyDc9oEkWbMKdSiWMNFUBG4KFhNogZbU87YJCmnUCtLdsxeV3C/" +
       "OO5sKc2yVp6i3ko8qLwAQa8yS8wh3dZkXgmgRnkzZW9L3NJhG0ZggzdTCuXG" +
       "StvT0sGvR35yoaNmBA5smTl+9ussO1MqS/4XKF6dcuBLdNQ16dSoYbgddtMh" +
       "Q5yHC4KGzVMU2uPMMuAJeUXqKc7uIn9kw6X/AsBbikwbFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lhvEeZU9/aPX/8Hbfvulr+eVvv8FYRtbEEAgAAA=");
}
