package org.apache.batik.apps.svgbrowser;
public class SVGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JCheckBox xmlbaseCB;
    protected javax.swing.JCheckBox prettyPrintCB;
    public SVGOptionPanel() { super(new java.awt.BorderLayout());
                              add(new javax.swing.JLabel(resources.getString(
                                                                     "SVGOptionPanel.label")),
                                  java.awt.BorderLayout.
                                    NORTH);
                              xmlbaseCB = new javax.swing.JCheckBox(
                                            resources.
                                              getString(
                                                "SVGOptionPanel.UseXMLBase"));
                              xmlbaseCB.setSelected(resources.getBoolean(
                                                                "SVGOptionPanel.UseXMLBaseDefault"));
                              add(xmlbaseCB, java.awt.BorderLayout.
                                               CENTER);
                              prettyPrintCB = new javax.swing.JCheckBox(
                                                resources.
                                                  getString(
                                                    "SVGOptionPanel.PrettyPrint"));
                              prettyPrintCB.setSelected(resources.
                                                          getBoolean(
                                                            "SVGOptionPanel.PrettyPrintDefault"));
                              add(prettyPrintCB, java.awt.BorderLayout.
                                                   SOUTH); }
    public boolean getUseXMLBase() { return xmlbaseCB.isSelected(
                                                        ); }
    public boolean getPrettyPrint() { return prettyPrintCB.isSelected(
                                                             ); }
    public static org.apache.batik.apps.svgbrowser.SVGOptionPanel showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "SVGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.SVGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.SVGOptionPanel(
          );
        org.apache.batik.apps.svgbrowser.OptionPanel.Dialog dialog =
          new org.apache.batik.apps.svgbrowser.OptionPanel.Dialog(
          parent,
          title,
          panel);
        dialog.
          pack(
            );
        dialog.
          setVisible(
            true);
        return panel;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "7uKaV1Ue1i+x5pH/AjsgEr3lGQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "JdPyQ+B5ZM/VHjmJJ6egPPPmvMuDeXo5S35y333Pe4EbAS5VZc+DfwR+p8Dz" +
       "39mTkcsKtkv1ba29eOGBg4DBAwvT+cS25lKotpo5hTtA2JWvebvhGgR3u4OW" +
       "ocrLpruHbVlazpIntgNWr2tJP3VcztftPfv5a8lJXEfOLNvKGWhH0M1eoEbR" +
       "ZghCz6jVzAq7J1gjX5a1nFRyCijwTHm3vlvMvtlrD346y74eAGWYB/qgh2Y6" +
       "krXPzV0LS768r1gBBP7Ayi8vrPq+Li/lDprZ0+42Wj7Ba/t/zStwwFsOiZEu" +
       "CLzf/w8f/NoHHv4W8JIBdGaVWTBwjiMj0nG2F3nv88/e+6pnvv3+HPeBNocf" +
       "xi89kVF9y0tJnCVClkz2Rb0nE3Wch1GkFEZUDtWqkkv7kuAApsoGK9pqL9CG" +
       "n7ztW8uPfufT2yD6JBKcaKw+9cwv/Wj36Wd2jmxdHr5q93C0z3b7kjN9856G" +
       "A+jBlxol79H5x88++Ye//eT7tlzddjwQx8E+89N/+V9f2/3It79yjdjuBsv9" +
       "MSY2uvn7PSTsY/s/Spip5TWfJLbGNFZOs4JwbaZjrJv6cuqohiq1JzQ20maD" +
       "WEblZbc0cO2kkaoVumKulJKloEjBLmEtXmcIoTnqDGpCNCJKhNWcJybhdQPB" +
       "7+CrCct2bcLtdOfNtuDZaWFML3FCS1lm3FgV7YZTqeiMAUddTnHEuLqK7Kqz" +
       "aqxsuFzvCbxbjt0xKmxaruZ5eFCUB2kJKS248dj1Z0JFwyRqgGg43EtRBK2v" +
       "aqMizneXU3oircHWW3cmRd70NJaNcJNXZp6lq4t5i18mi8DoKgRBzzauj5qm" +
       "1C+4bUbgx00RZ8AktVo90SBnc4kiJpJNJRxlY/GI7pnddoM2Bqgdhtaw2KTb" +
       "ixlhcguXQtMixSuy7KLFaqGw5CN5XkYcXN4INGuGLO5oM54mWUmQuMGC4EZU" +
       "yxmhnbo3tSi2XCYrHd82arA94cpIYTmpWJJn0qJgG1OcbdiMSdB4dUwpnLno" +
       "1tgxXteMeo3w7YFrufHMjWuzaLLEabeCeZ6Eto2JvHKdfkFIeEQdjKTaZEQE" +
       "WJufc3yMAFriOrUQJ6VQilCUMe9wTDvCo1Aal9JCkUUlR1gWjHAYwbV1K5hQ" +
       "riGyPbvXw1Vs1GnPxOZsMp4OBm7BF3nTZ7u8GFJNAzVsV7dk2S8qQRiLNkuh" +
       "BaxlWcFs1kGsbgRzRVaY4TbHofpAoDsxSvdkHy016EnYF5fktL1UJiO5Fc6b" +
       "a3zOts2ZFc51dSOSDVF3vbquqZwVdueh1sQGeiAXWduahoHkWW2McStTjG3J" +
       "sbjBdMSprptFw+1MO+3FyhJtXhKDzihaMDg17lCVtIhOaEJq+VXE08kmR6Pi" +
       "MLHkJoFWShM5cpzCakYn8JyEp/1RU21TxHjQrw83qU44XJKyVHE5WuCY3J0V" +
       "GL9MMwiCThaj2RhT+7VhmWhX0TFV6VkLTlWXgl4Wmy3RN6odxCz22TUTWag4" +
       "6RSrqhqU2z1fwPmpreGN5YpyzWqYDke8sCTm7anXoQ2/MhijDAyviIWImr2R" +
       "MlrrONHqx0KK4EqkewOOnVmuxo/srj9b0rO2b4obAl0tmwK2atgtnZtVRq6j" +
       "zAY9vi3gBkoQ2hr2Wzo9TjGB5puaRTNESZCTVBsURjzfL8lEuxt3RNNda1qJ" +
       "WbLBgFgsx2u9K7CCOUi4SW9DIfQmbeG1Roda+xufHQwXcJn2SojGs1PZCpAB" +
       "xrJyhFM9o2MZJofimtCHPWTgLz0caQ2XYkfReMovrrGQrY3WaJqW4HrT0VXL" +
       "aCxHOtYSpRom91sTIphWO2MWD/tF2FFJTmMGJSR1+mhnAVDGjBbd2WS4oGgU" +
       "Sdszhkni3oqNF6N+e6Ws5brO4MyMWic6NsWqsiT0142oXGGK/jpA+UHZbS7D" +
       "ddEQOuo48JG+3CnojlEfTA1bjld0dT1wzSbGNcmNNaDCeFEZrEOjZJvEqEM0" +
       "hXjOGqOJutSIvquOqsWazOGuUOzVC6QjMxQ8qWNdtx8nSWL55VJULBSYQol0" +
       "IzatI1WK5JrJqIdx60Ei+21WXFMTMkBLK550kuaElPHVoIOgxWYJL82aE53G" +
       "+FFx1Cz0prUGjGEckL+03EwYA0OCiV4lSdxrlfG51BTlNesY80jrFioqZk7U" +
       "xCRDDsScdmvYr9iF0mjCraZyZ2hTKeKpbRJBXKOGhhUNXglxYCPBvD5G8BXS" +
       "d7liHHQJMprSvOTQstxXui263UB5Di10htNFIbVhXeY3RS8qUxWJ6GK83Wzz" +
       "MClMG0GlVF/ETmWt14bL0JioKscPZX4OQJXp+m6/xaVyQUb1Hj9O2vXUjmsK" +
       "5ZiW3RQT3uyH42FdCJ1UaSWoIqVTdNTvsxukMqn03KYIp8x0xbnSGh4qw4GF" +
       "6SQZzepMr91vr7tynSjDY7qdDlILR5TelKVLcHewwQVsmPqIwRlm30faBlYp" +
       "L0oyrBurOjynK7IqzaNKBNN1RI4EvKV2B3RajcuraZKwKzSia+bGrgQjKS13" +
       "mXrHjvnOpFeLe+VFLRSRTuyE8VxrEH6F8wb+GmmZIYERZG2JiWsBbiLG0lJ4" +
       "eFUe12G33GOslj6puLo4WEt2ZGOy6OvaauC4kyVJ6HMnxSimive4cTTtsPyg" +
       "nXLVAjm2In/Mb5xpXWGH1VXVXVcYpxJ3GHG6YLEQUUudZVRFFYAbWN0Fi2s0" +
       "KcANmBHrDV6qTRNL1dINKlfq1WqLHw43Uw6J+XTQDVjCMZCkQDu9kq2tuEIb" +
       "TCu26VJqyTYYisc2bR910pgrVOI1AY+DPuEqrFRuTbQ0XluE2lRnbqe3qQls" +
       "p52BdSMRV6w/Hc+KQ4CSDTSez0t6VeXKfnvod2x4M1OmqbwhphoW0kW6GrOF" +
       "FeYalcJiQbaiWixSRamV1H2BLxsy7o9Rs4PziGDpUnm0LBmqCYubwLFGY61f" +
       "7EUzx+0g9ByJbJNrT/yqgWyUoBQwywq9sloTFZarAyEyNGsGC8SmzcabcCLO" +
       "w9HCiluWzy+EVi1bcuy1VJ9M2uVK2elJ1rrsEmlt49UFGCELfIjQ9VENmVGz" +
       "vrn2hfI07aKkt24wDr8cDoMF0/IapXk8qTXNhl2twHCdLuCcVvFLbLvDc4lQ" +
       "Cniua6qcFK798rTj8qE7RPGYRGDYD6jSdOp46XTS2TTCAV/bNEa2jwa9yCm0" +
       "rTUMz7UaU6jT9blPhcCdOasHD3rrjarNhZWhNZdLGmiuhwWx06jaUx8dKTOs" +
       "4rWn1WZZ5Zl4w3Hx3J6sB0NituoysFn0W7jQ0AdRkgSGMi5GaF9eVWbNapu1" +
       "WnTZW25QOnGCprDY0MBCqKGjUtUBVWvy2nCkLJO5Ve+SDkfVh5EFbNGu1QaC" +
       "GU50rYNpq2HKwSuZq3SSUtoE4swtdCYyE1kR+GA2LzoovsKoBlymKCbV57Mu" +
       "gm2kqBZZkTkFi5BFgRVqrBm42UxcraKF9ghmumMSoRBiaDc3irbapCjZ8fol" +
       "ierC/sZdxhsbVRGPXZlhV9T0mTI0hCKSNOYVMkmRsiYPe5gtiY7fdyN/6S51" +
       "fFOfiRgs0W7IrFSGKbpT3oErvXXIqT0XG6mjnlCdKJvpYE15AapNait7uUlI" +
       "JlLqyRQeyhwT8k1B8kSddGoDqdBhxTqh8+VwgA9n5QZF9RcBlZTrdVhcuEYS" +
       "NOcNOKBIGQSfsuvr4swkY6QdzgW2wrZheOg6tC4i03TZcwruyDcLDTpe9qbT" +
       "kW3H6KYxX4XcXLA7glMYT7rVpRcPylPZMVuGZYUER7AEB3cVbNJxJm26tLF8" +
       "nfSSWcD0B2NhQU7VeqNs9VaoEk/raCccWBVGkOTUXNVAaIlWgFxO2ffsSuRX" +
       "ExjpKL1CM+L7hQHHjKtEXXHI0qjaToqb/jRudF2vwxUKJliQy4hFNJgRPNNI" +
       "tFluF7gxPzQnIiF5NplqkZyMSwV76flxZ0U3imKZKhtYUU4YuzaWE1bARg5w" +
       "YTkya+WqJwtywSziK3rSn8+L1ahOqD7SFKt6J4D13mwdECg6Ws6osOzNlVWl" +
       "Ul+sJiotkbiBSK4fUXo4SknTKJesgqQ4QkAKLXgcrehFQ1s11q1SOl+s8doa" +
       "hJfVxlLqt8VJtThNNUforSK/wMyrFRVYScmtdYNlUyy765YtDecxovsFl5GM" +
       "Jr1UCGQq8NgwqZWT4boS1UkHril+S5lWWUphCmEywAGiFNDOshDUArXl9xCs" +
       "xLfjPiYUVoqOEiOUmwlpOuqhrq+yVqEUJRRMV9M2wshoedayyxu2YTmdmV8z" +
       "DVpGJdmOcZrBifI0mNRsfNlQrI4iNDbptN5DFkFiiquWy3ZLrEDVqV49JiSh" +
       "xKsls5BUvR6MLUIdDypWd4Rh2dbPeWW771vzg4aDOzqw6c4qZq9g17mtejBL" +
       "Hjk4m8l/Z6ET9zpHj3sPzwChbCd97/Wu3vJd9Mff88xzCvOJ0s7e2akZQecj" +
       "13ujpa5U6wip04DSY9c/MaDym8fDM70vveef7+F+xnjbK7ipuP8EnydJfpJ6" +
       "/ivd18m/vAOdPjjhu+pO9Hinx4+f610I1CgOHO7Y6d69B5q9PdPYA+DZm4rt" +
       "++rbgusfeb1+O/cvcTT9Cy9R994seWcE3ayrER+qU4psSuH2YkM5YipGBJ2b" +
       "u66lSs6hGb3r5Q4vjg6WF7zjuNyZFXX35O7+38v9oZeoezZLno6gW4Dcw8Oj" +
       "wqz0qUMJP/BjSJi7SHYtwuxJyLwCCXcO/fuaYp7au87bOz+8LT/Nk9bRbnbI" +
       "6DqqE+XdfuMlNPCbWfJrEXQhNNx125Qs9+Th1K+/EukToMvjd5PZRcvdV/1R" +
       "Ynu5L3/muYs33vUc/1f59dzBBfx5ErpRiy3r6Ln4kfxZL1A1M+f+/PaU3Mtf" +
       "n4qgB17u4jQT9OAj5/6T286fjqA7rtk5gm7IXkfbfi6CLp1sG0Fn8vfRdr8L" +
       "RjtsF0Fnt5mjTX4/gk6DJln2C97+PL7hZa9/j+g3OXUcdQ/m7baXm7cjQP3w" +
       "MXjN//2yD4Xx9v8vV+TPPjeg3/5i7RPbK0nZktI0o3IjCZ3b3o4ewOmD16W2" +
       "T+ts79Ef3vK584/sQ/8tW4YPLe8Ib/df+/4Pt70ov7FL/+Cu33vTbz33zfzI" +
       "+n8AclF9fZYkAAA=");
}
