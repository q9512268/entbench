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
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO39/5WwndhI3cb6cSE7Tu6Y0QOUQkrh24/Sc" +
       "nOLUAgfizO3N3W28t7vZnbXPDoa2gGIqEUWt04aPmn9SUVDbRIUKELQKqkRb" +
       "tSC1qmgLaooEEuEjohFS+0eA8t7M3u3e3tlRED1pZ/dm37yvee/33uxTV0mN" +
       "bZFupvMonzaZHR3QeYJaNkv1a9S2D8PcuPJYFf3n0SsH7gqT2jGyLEvtYYXa" +
       "bFBlWsoeI2tV3eZUV5h9gLEUrkhYzGbWJOWqoY+RDtUeypmaqqh82EgxJBil" +
       "Vpy0Uc4tNelwNuQy4GRtHDSJCU1ie4Kv++KkWTHMaY98lY+83/cGKXOeLJuT" +
       "1vhxOkljDle1WFy1eV/eIreahjad0QweZXkePa7tcF2wP76jzAUbL0Y+uH4m" +
       "2ypcsJzqusGFefYhZhvaJEvFScSbHdBYzj5Bvkyq4qTJR8xJT7wgNAZCYyC0" +
       "YK1HBdq3MN3J9RvCHF7gVGsqqBAnG0qZmNSiOZdNQugMHOq5a7tYDNauL1or" +
       "rSwz8eytsfnHjrY+W0UiYySi6iOojgJKcBAyBg5luSSz7D2pFEuNkTYdNnuE" +
       "WSrV1Bl3p9ttNaNT7sD2F9yCk47JLCHT8xXsI9hmOQo3rKJ5aRFQ7r+atEYz" +
       "YGunZ6u0cBDnwcBGFRSz0hTizl1SPaHqKU7WBVcUbey5FwhgaV2O8axRFFWt" +
       "U5gg7TJENKpnYiMQenoGSGsMCECLk65FmaKvTapM0Awbx4gM0CXkK6BqEI7A" +
       "JZx0BMkEJ9ilrsAu+fbn6oGdp0/q+/QwCYHOKaZoqH8TLOoOLDrE0sxikAdy" +
       "YfPW+KO08/m5MCFA3BEgljQ/+dK13du6L70saW6pQHMweZwpfFw5n1z2+pr+" +
       "3ruqUI1607BV3PwSy0WWJdw3fXkTEKazyBFfRgsvLx361efv/yH7W5g0DpFa" +
       "xdCcHMRRm2LkTFVj1j1MZxblLDVEGpie6hfvh0gdPMdVncnZg+m0zfgQqdbE" +
       "VK0h/oOL0sACXdQIz6qeNgrPJuVZ8Zw3CSF1cJHtcDUS+RN3TkZjWSPHYqYa" +
       "S1gGmm7HAGyS4NZszHb0tGZMxWxLiRlWpvhfMSwWs7M0xazYqMqm+qljQw7Z" +
       "I2IqivFlfmyc82jT8qlQCNy9JpjsGuTJPkMD2nFl3tk7cO2Z8VdlIGHwu97g" +
       "ZCvIjLoyoygzKmVGy2WSUEiIWoGy5a7CnkxAdgO8NveOfHH/sbmNVRBO5lQ1" +
       "OBRJN5aUmX4PAgq4Pa5caG+Z2XB5+4thUh0n7VThDtWwauyxMoBHyoSbss1J" +
       "KEBeHVjvqwNYwCxDYSmAocXqgcul3phkFs5zssLHoVClMB9ji9eIivqTS+em" +
       "Hhj9yu1hEi6FfhRZA6iFyxMI2EVg7gmmfCW+kVNXPrjw6KzhJX9JLSmUwLKV" +
       "aMPGYDAE3TOubF1Pnxt/frZHuL0BwJlTSCbAve6gjBJs6SvgNNpSDwanDStH" +
       "NXxV8HEjz1rGlDcjorQNhw4ZsBhCAQUFxH9mxHz87d/85RPCk4VqEPGV8RHG" +
       "+3wIhMzaBda0eRF52GIM6N49l3jk7NVTR0Q4AsWmSgJ7cOwH5IHdAQ9+/eUT" +
       "77x3+fybYS+EOZRgJwmdTF7YsuIj+IXg+g9eiBo4IdGjvd+FsPVFDDNR8hZP" +
       "N0AzDZIfg6PnPh3CUE2rNKkxzJ9/RTZvf+7vp1vldmswU4iWbTdm4M2v3kvu" +
       "f/Xoh92CTUjBaur5zyOTEL3c47zHsug06pF/4I2133qJPg5gDwBrqzNMYCYR" +
       "/iBiA3cIX9wuxjsD7z6Fw2bbH+OlaeTresaVM2++3zL6/gvXhLalbZN/34ep" +
       "2SejSO4CCLuDuEMJhuPbThPHlXnQYWUQqPZROwvM7rx04Aut2qXrIHYMxCrQ" +
       "UNgHLUC4fEkoudQ1db/75Yudx16vIuFB0qgZNDVIRcKRBoh0ZmcBZPPmZ3dL" +
       "PabqYWgV/iBlHiqbwF1YV3l/B3ImFzsy89OVP975/YXLIixNyeMWP8MtYuzF" +
       "YZsMW3y8LV90lvjVLuEsH8+QeF7FycqywiCrADp27WI9i+i3zj84v5A6+MR2" +
       "2Vm0l/YBA9DmPv3bf78WPfeHVyqUowZumLdpbJJpPp2qUGRJJRkW7ZyHZu8u" +
       "e/iPP+vJ7L2ZIoJz3TcoE/h/HRixdfGiEFTlpQf/2nV4V/bYTdSDdQF3Bln+" +
       "YPipV+7ZojwcFr2rLAVlPW/poj6/Y0GoxaBJ19FMnGkR2bSpGCDLMR5Ww9Xk" +
       "BkhTMJskcItow2GguLS6EE+LLQ2ARVjsaLgQZd1lUSZcw6AFx9gvkHX6yUbk" +
       "fU9iSKj1uSXg6CgOI4DijpkCRC7tSDBARpykDd2DmoOKMul2z3ckjilzPYk/" +
       "yfhdXWGBpOt4MvbN0beOvyZ2uh5Dq+hfX1hBCPrqYCsOUcyh3iXOoqX6xGbb" +
       "35v47pWnpT7B1j9AzObmH/ooenpe5pY8H20qO6L418gzUkC7DUtJESsG/3xh" +
       "9udPzp4Ku66+l5O6pGFojOrFrQgVG8EVpV6Uut79jcgvzrRXDULWDpF6R1dP" +
       "OGwoVRq5dbaT9LnVO1J5cexqjaWYk9DWAkZ+GofD8nnn/wjPOLHXFPMHiyHf" +
       "hu/WwBVxQz5y89my2NJALIdKMXltRUyGcyue3JkQO7VENpzEAVq8pgzjh2Cd" +
       "+IRTCe7VHBxgsRq5Z3XhSvtjcKUAi11wdbn+6Lp5Vy62tDLw4F/BdFaMc0u4" +
       "6yEcvspJi61QDoCUyBrcxXHFTRS8ZTipnjTUlOepr/0/PJWHlrL8DIYNw6qy" +
       "7zryW4TyzEKkfuXCfW+JKlj8XtAM4JR2NM2XVP4EqzUtllaFwc2yyTLF7Wyl" +
       "FkCeDQFP5YPQfV7Sn+OkNUgPnsGbn+w7EH4+Mo4JLp78RAucVAERPn7PLERo" +
       "q+iT8GNNVH6ZyIfKeyHh/44b+b+4xH8wQBgWH9YKOOXIT2twRF3Yf+DktU8+" +
       "IQ8mikZnZpBLE6CTPP4UK/mGRbkVeNXu672+7GLD5gJslhyM/LqJKIDcF4eI" +
       "rkCnbvcUG/Z3zu984ddztW8A4B8hIcrJ8iO+z1rSU9DuO9BCHYmXozB0PeII" +
       "0df77eld29L/+L1oM13UXrM4/bgy9sjbQxcnPtwtvuTUQEVg+THSqNp3T+uH" +
       "mDJplUD6MoxGip/YhB9c97UUZ/GEysnG8kJVfq6HFnyKWXsNR0+5RaHJmyn5" +
       "wldofhzTDCzwZny1eUImNXof4m88Pmya7vEuVGOKrNSCwCwmxeJnxSMOP/ov" +
       "mxd8bmMXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5YiP5e3lrPnZrdaz7s8Bjw3yxBFgLAxbMnM6T4TAYkz58r6PCiCRBCq+vDSx" +
       "nMyrQeqcW0cmzO42+9rGqqxFt1zk/eoNreHKPq9g9e88JMY4IJF7zz+972u/" +
       "+dpvgSWioTPrTH1gZY7M2I+y3PbXXvzgQ7c9/+335AEIRB/+qXc778iodm8m" +
       "cda0sobYF/WBTFTeiXxZZaQg7OVxQlVyaW9qmaxvWCC0rvcSN+Tpu7+1+th3" +
       "PrNNyk6a4Qlg9bnnf/1Hu+99fudIKvzaa7LRozjbdDhn+o49DfvQYzebJccg" +
       "//lzT//x7z397Jaru48ndgQ4t3zmr//na7sf+fZXrpNfnDadn2Bhw9u/T5WD" +
       "TmP/jxFmi0ksc8lkMUDrSGUS24reQeV5VeYJbBRVZ4XhYDxc+XqpjPCyPWDG" +
       "DW1hbAZoH52UaiG2Fu35lG05UklrdzxiPAkLZYm17Do/FlpzrjPuEsyw6624" +
       "ecjjRc/SGMlxCCIilo5O8nBBbQAiPTRCVTQ0OaJVdEVEsVAsXasqgqJRMhIK" +
       "Vn8ukpG77jn2RhIpDh2qM1rqr9ZFqc6XWjVWjlh6Ri5Qu8AHFKZ5o9KynTLE" +
       "OpzNptKcbJqTwFE7pVBAVXEsVPS6xhBjf6XPNu35hB5MPGcGc61wrKauJXme" +
       "XisRWkI3DVNw08JYLod91Yz70TAtt7mQavE0Pi4aarm7huHuajKietKsXjNn" +
       "cA1F5HZ3OlAZOhoV13oyWJnLlqkWJ2RaVAVE7fiqpC8lpTCMVXG6ApkXFspk" +
       "KWax6nLTGM+ZwgyOqLJVSl05oDdeFLRJdTHTRX0t0cSa5GV+TinN2WZZaa5X" +
       "qVf2RjRXS+gRFmv9hojPUrww6xappuKhvT5K17k1TpGYJrQDz2s27HbBE60+" +
       "bwxEpT+MtB418CqAhVmrL0VM0fF9Pt7U1DQMFja19GfwpDA2ZilvVI2Bs9To" +
       "rtxspE2tYkY8v8FaJZckov5qNFP6dkRMeF8oNk3UrYdhX+qPsKBVIuspvipj" +
       "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" +
       "fX/wxt994Zt5Afj/AE0CYu40IgAA");
}
