package org.apache.batik.css.engine.value.svg;
public class ClipRuleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_EVENODD_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          EVENODD_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NONZERO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          NONZERO_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_CLIP_RULE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NONZERO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ClipRuleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ze5AUxRnv3YN7cXDHwQHyOLjjgOLhroiE6BHicYAc7sEV" +
                                                              "hxQ5lKV3tvd2YHZmmOm928MQkUoCSUUKEREtpfIHFoagUFasPIwGy0qUaKyo" +
                                                              "JGgsMQ+rJBIqUqmYVEgk39czs/PY2z2vKmSrpne2+/v6e/366697T14mI02D" +
                                                              "NDKVR/iAzszISpV3UcNkyXaFmuYG6ItLj5TRv225uPbWMCnvIWPS1OyUqMlW" +
                                                              "yUxJmj1kmqyanKoSM9cylkSOLoOZzOijXNbUHtIgmx0ZXZElmXdqSYYEG6kR" +
                                                              "I2Mp54acyHLWYU/AybQYaBIVmkTbgsOtMVIjafqASz7JQ97uGUHKjCvL5KQu" +
                                                              "to320WiWy0o0Jpu8NWeQ+bqmDPQqGo+wHI9sUxbbLlgTW1zggubTtZ9ePZCu" +
                                                              "Ey4YR1VV48I8cz0zNaWPJWOk1u1dqbCMuYN8jZTFyCgPMSctMUdoFIRGQahj" +
                                                              "rUsF2o9majbTrglzuDNTuS6hQpw0+SfRqUEz9jRdQmeYoZLbtgtmsHZG3lrL" +
                                                              "ygITH54fPfTIlrpny0htD6mV1W5URwIlOAjpAYeyTIIZZlsyyZI9ZKwKwe5m" +
                                                              "hkwVeacd6XpT7lUpz0L4HbdgZ1ZnhpDp+griCLYZWYlrRt68lACU/WtkSqG9" +
                                                              "YOsE11bLwlXYDwZWy6CYkaKAO5tlxHZZTXIyPciRt7HlTiAA1ooM42ktL2qE" +
                                                              "SqGD1FsQUajaG+0G6Km9QDpSAwAanEwuOin6WqfSdtrL4ojIAF2XNQRUVcIR" +
                                                              "yMJJQ5BMzARRmhyIkic+l9cu3X+vuloNkxDonGSSgvqPAqbGANN6lmIGg3Vg" +
                                                              "MdbMix2mE17YFyYEiBsCxBbND7965fYFjWdetWimDEKzLrGNSTwuHUuMeXNq" +
                                                              "+9xby1CNSl0zZQy+z3KxyrrskdacDhlmQn5GHIw4g2fW/+Iru0+wS2FS3UHK" +
                                                              "JU3JZgBHYyUto8sKM+5gKjMoZ8kOUsXUZLsY7yAV8B6TVWb1rkulTMY7yAhF" +
                                                              "dJVr4je4KAVToIuq4V1WU5rzrlOeFu85nRBSAQ+pgaeZWB/xzUk6mtYyLEol" +
                                                              "qsqqFu0yNLTfjELGSYBv09EEoH571NSyBkAwqhm9UQo4SDN7QDKRthd0ivZR" +
                                                              "JcuiZl8voEbW12cV1klVAIURQcTp/0dZObR7XH8oBCGZGkwICqyl1ZqSZEZc" +
                                                              "OpRdvvLKM/HXLLDhArE9xsliEB+xxEeE+AiIj1jiI0J8BMRHAuJJKCSkjkc1" +
                                                              "LBBACLdDMoBsXDO3+541W/c1lwH69P4R4H8kbfbtSu1uxnDSfFw6VT96Z9OF" +
                                                              "hS+HyYgYqacSz1IFN5k2oxfSl7TdXuE1Cdiv3G1jhmfbwP3O0CSWhKxVbPuw" +
                                                              "Z6nU+piB/ZyM98zgbGq4fKPFt5RB9SdnjvTfv/G+m8Ik7N8pUORISHLI3oX5" +
                                                              "PZ/HW4IZYrB5a/de/PTU4V2amyt8W4+zYxZwog3NQVwE3ROX5s2gz8Vf2NUi" +
                                                              "3F4FuZxTCD6kycagDF8qanXSOtpSCQanNCNDFRxyfFzN04bW7/YIwI7FpsHC" +
                                                              "LkIooKDYEb7UrT/xzht/XiQ86WwetZ5dv5vxVk/CwsnqRWoa6yJyg8EY0L1/" +
                                                              "pOuhhy/v3SzgCBQzBxPYgm07JCqIDnjwG6/uePeDC8fOhV0Ic9ixswkofHLC" +
                                                              "lvHX4BOC5zN8MMlgh5Vs6tvtjDcjn/J0lDzb1Q2SnwJJAcHRcpcKMJRTMk0o" +
                                                              "DNfPv2tnLXzuL/vrrHAr0OOgZcHQE7j9Nywnu1/b8o9GMU1Iws3X9Z9LZmX0" +
                                                              "ce7MbYZBB1CP3P1vTXv0FfoE7A2Qj015JxMplgh/EBHAxcIXN4n2lsDYEmxm" +
                                                              "mV6M+5eRp0iKSwfOfTJ64ycvXhHa+qssb9w7qd5qociKAghbQuzGl/JxdIKO" +
                                                              "7cQc6DAxmKhWUzMNk91yZu3ddcqZqyC2B8RKkJDNdQYkzZwPSjb1yIrfvfTy" +
                                                              "hK1vlpHwKlKtaDS5iooFR6oA6cxMQ77N6V++3dKjvxKaOuEPUuChgg6MwvTB" +
                                                              "47syo3MRkZ0/mviDpcePXhCw1K05puQz7FRfhhUFvbvIT7y95DfHHzzcb5UE" +
                                                              "c4tntgDfpH+tUxJ7/vjPgriInDZIuRLg74mefHxy+7JLgt9NLsjdkivctiBB" +
                                                              "u7w3n8j8Pdxc/vMwqeghdZJdQG/ETQnWdQ8UjaZTVUOR7Rv3F4BWtdOaT55T" +
                                                              "g4nNIzaY1tztEt6RGt9HBzA4BUO4DJ45NgbnBDEYIuJljWCZLdq52CwQ4Svj" +
                                                              "pEo3NA5aMih6y01RrXPQRFapksvLEVCZXEIO8IpN2xQskziZP/T+bpXHAG8r" +
                                                              "JWP7RWzutOQuHQzPucHtCOHrja6+4lNeYm16IExwnU4rVjGLav/YnkNHk+ue" +
                                                              "XGiBuN5fha6EQ9bTv/3P65Ejvz87SKFTxTX9RoX1McUjswJF+pZNpzhMuBh8" +
                                                              "f8zBP/24pXf5cGoS7GscourA39PBiHnFV2JQlVf2fDx5w7L01mGUF9MD7gxO" +
                                                              "+b3Ok2fvmC0dDIuTk7U4Ck5cfqZW/5KoNhgcEdUNvoUxMw+AcRjY2fAssgGw" +
                                                              "KLgwXNDNxmaTH+vVJVhL7D1yiTERMlhk42SzQ03DmReWHFRF4ljrr1Mxzt3Z" +
                                                              "hAk1pZyBOqPPPoLd3LVV2tfS9aEFwxsGYbDoGp6KPrDx/LbXRcAqESF5N3nQ" +
                                                              "AUjyVEd12ERwKZTI0QF9orvqP9j++MWnLX2CCTlAzPYd+va1yP5D1hKxDtkz" +
                                                              "C865Xh7roB3QrqmUFMGx6qNTu55/atfesO33uzmpSGiawqiaj0sov3mN93vR" +
                                                              "0nXFt2p/eqC+bBUsvg5SmVXlHVnWkfQDsMLMJjxudc/lLhxtrbFA4yQ0z9k5" +
                                                              "RZJjJZLc59i0sWO5Lvq3+kGPmfk2G7m3DR/0xVhLAPvrJca+ic19cNSRzTZV" +
                                                              "zlCOtaKDehzTXJfsvl4umQVPm21X2/BdUoy1hNkPlhh7CJvvQKEg4y2YwG4R" +
                                                              "hzxwHRxSi2ON8Ky2rVo9fIcUYy1h9NESY9/F5lGot3sZdzyRP7tl7JWPX7rn" +
                                                              "nXNSJtu3mp4VjT8HPMvssevgwnoca4Kny/ZD1/BdWIy1hJtOlxh7Fpvv+124" +
                                                              "FnKVU43ViQIfa1K76nI9dPI6eGgsjs2AZ5Nt5qbhe6gYawkv/KzE2EvY/MTy" +
                                                              "0AqWolnFKtgdD80Zul516YXjnr8OjmvAsZnwxG3r48N3XDHWEs55o8TYr7E5" +
                                                              "y8kYcFxHEnZLOPAzq67sdp3xy/+FM3IQnsCFH55OJxX852Ddk0vPHK2tnHj0" +
                                                              "rvOiRs7fZddAzZPKKor3/OR5L9cNlpKFaTXWaUoXX+9wMutz3UlC4oFW2HDe" +
                                                              "Yn2Pk6YhWeFQ1ZcHkM14gZMpJRjhUGW9eHn+AJvpYDygFrReyg9h3QcpQQvx" +
                                                              "7aX7iJNqlw6EWi9eko9hdiDB10u6s2QWDe0uFzB2PHMh/8krD6CGoQDkOazN" +
                                                              "9FWo4o8rp4TLWn9dxaVTR9esvffKF560bvIkhe7cibOMgsLNui/Mn1Wais7m" +
                                                              "zFW+eu7VMaerZjkVpe8m0aubgDHsQuLWbXLgastsyd9wvXts6Yu/2lf+FtTC" +
                                                              "m0mIwplgc+GtQU7PwiFxc6ywQIVznbhza5372MCyBam/vifuZUjBbUyQPi6d" +
                                                              "O37P2wcnHWsMk1EdZCQUyywnrjNWDKjrmdRn9JDRsrkyBypi3Kjiq37H4Aqj" +
                                                              "uHsIv9juHJ3vxSteTpoLa/rCi/FqRetnxnItqyZxGqifR7k9zpnVd9zL6nqA" +
                                                              "we3xHGNyVomA0QDIxmOduu7cj44YpYs8MzB4zYDtZ+IVm2v/BcBJvgbUHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DU5mbWXtCtQmVEM7IIRh3fKpTCXnBNrYMts5aYHRyKpaiDftBbJEeS4hrWnH" +
       "8DprJZuTpCBYQZYJZFsYJ+NEQW3NTBaKKMnNlTfHLN7Lq1SD2MiqgAiO5uFe" +
       "RfX1HrUWlmvL58Jmy+r0eHgZmrPdsL2eBn0E2VCJtVrjibDMmr21KY47UzS0" +
       "UkIQ5isyYySdCzHCmuudDuK6k0bNDKnarg/4cWQQsLxoiMNKddgc220W92ad" +
       "pCM6/SSa6k5zudvO5NCnGq5Bdga1Fc1y/EIiuWwyGrFod5J3OM7WMtLUpYrV" +
       "lqL6qhJHlkubKe46w9lMjXdMZ7cZdmi6adnkUK0v1Im8mehpze4j2HqQrft6" +
       "N+il3Q2NY+0mul0PjKWshEvdxvvjnPKH9GyeRAQfTZQVvau0002G9OiZVc0F" +
       "Nqvk9XGa+X5gyqKEa5bNOuiQIJOGWtsu4QrpR9VKMqsNZnXgXyO+PhLULrHO" +
       "+NBtBeNJBVXHxsQVWuaUD1a8QAVrLOssWt3mfLHcIL4ZWfNJUaQN5NHCbxhK" +
       "Y9xZzF0y2jXAyPKon/vWVBlELdThurMOW/FUURGWXTjNebNph+uM6rvWLtjt" +
       "BlE1o6n51uhTw9m6G1fb/b5LoBhCz7Ku2Ul2mt3mWbcxw2mMxcdcqMlVPRa4" +
       "kRTpgtWK3f5midSkBWJaiw7Jc6w09+CqLEw3HLYiWm63NxSGZkL2dpmFCLuZ" +
       "0BekqcfJcUyNJzCxoihc6/j9dhpYer9bSdO+0q90dNJADJ2sjlrdCUd0otFo" +
       "3JuZhikhVLfb6VEyPnG7wQqf1itoA1nCEmIlRLPNNLgG0TI32004i5AodfDZ" +
       "dpA0F/N2U2hPB9qsQmRrdb0TpVmOkAMaNWtuup1Z2FxeRX2kJ+txfYgYmr3d" +
       "JEx9Wu3Nlto4XWyYKBGaDl/x9C4sZJN2K1c3w11jO2YGIcp12zPZMeL5NoaH" +
       "FbtFmhjd8vgpR84Iiqy7K5QRYGLZIIW130VFWFZgZs43FjXRzsLWslHJ16mQ" +
       "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" +
       "fvXbf+6Zz5cHfv8HqDDRoScpAAA=");
}
