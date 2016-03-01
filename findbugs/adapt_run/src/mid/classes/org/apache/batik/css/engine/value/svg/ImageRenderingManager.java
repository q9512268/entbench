package org.apache.batik.css.engine.value.svg;
public class ImageRenderingManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_AUTO_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          AUTO_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZEQUALITY_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZEQUALITY_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OPTIMIZESPEED_VALUE,
                        org.apache.batik.css.engine.value.svg.SVGValueConstants.
                          OPTIMIZESPEED_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_IMAGE_RENDERING_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 AUTO_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public ImageRenderingManager() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Qy3w9Jla903cYIVYixjlTJGxs6w57TbYFogxVpVUy2tvViua1ZBtjx/etj3q" +
       "2NA8eCKmUpGJ26MQaxGdny0y9hxrfmbYYwNJ4LRklM2WPRaOXzXa9NxMT9+2" +
       "mRrY0Hx4sKkrnriZCrEWMcWLRcYusuYFiqaCmUJxIlM4VhOjwvuyrfqvJq56" +
       "hqKGvNdi7CA4M+ce37h7Fp48WVMx4+R9f+JXM9n74WqoPhJpSXKeUxz9MlUj" +
       "CZGrU22cWlT+dYmi9v/q/g7CBrRckdcM1isUtYzLCoeXoSxETMY/UDSrCCMc" +
       "XoyOk+cqpLl8PCAWtE7Ka7CPvZQgBf920l2nqMqmg0WNjpPkbZgdSFj3HdXa" +
       "FCvGN5cNEtOfGZ/7hJMFTcN4oHEciua7akX+Z5BVSqWNv4Ogbj25ecv9N+86" +
       "bdyRCRIeGWGzTIYCyriJy54cWgrOZs1V1rXo1tSnKtut2s51R+eUjWMZcgi/" +
       "z2ryXBrpbdm7ozdOrT7/6uGyK1CVbkc+DBX69tzTeUZNw7FmezhfqQjnKn6f" +
       "1VH17s5Ln77pq+eXIMgoLpuLcUSFo+ev9SZU9ft+VBlCpVC6kgy/OtiwR+4j" +
       "wpDmqjzLYkpazv5vNJXtMcy2J7eMadAp2bfs+pSi1tz6OvdKuUpShom2ns3O" +
       "ppniOWulVdU5yi07ZCRvZmmAYzTcrarmrWLJHdzyqsqjycc8hf8HGlElivEd" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae8zsxlX3vUnuTUKae5M0bUnbNI+blnTh8z7sfei2pV6v" +
       "1+tdex/22rtrHqnX9vqxfq099q5NA20laEVFqSAtrdSGP2gFVH0gBOIlUBCC" +
       "FlEhgcpbtICQKI9K7R8URHmNvd87994QJRKf5PlmZ+bMnN+ZMz8fz8ynv4bc" +
       "EYVIKfCd1HB8cKDvwIHt4AcgDfTooM/iYyWMdI10lCiawrKn1Md+4co3v/VB" +
       "8+pF5JKMPKB4ng8UYPlexOuR7yS6xiJXTkopR3cjgFxlbSVR0BhYDspaEbjO" +
       "It92ShQg19gjFVCoAgpVQAsVUOKkFRR6he7FLplLKB6INsgPIhdY5FKg5uoB" +
       "5NGznQRKqLiH3YwLBLCHO/PfEgRVCO9C5JFj7HvMzwP8oRL6zE99/9VfvA25" +
       "IiNXLE/I1VGhEgAOIiP3uLq71MOI0DRdk5H7PF3XBD20FMfKCr1l5P7IMjwF" +
       "xKF+bKS8MA70sBjzxHL3qDm2MFaBHx7DW1m6ox39umPlKAbE+qoTrHuE3bwc" +
       "ArzbgoqFK0XVj0RuX1ueBpA3nJc4xnhtABtA0cuuDkz/eKjbPQUWIPfv585R" +
       "PAMVQGh5Bmx6hx/DUQDy0E07zW0dKOpaMfSnAPKa8+3G+yrY6q7CELkIQB48" +
       "36zoCc7SQ+dm6dT8fG34lg/8gNfzLhY6a7rq5PrfCYUePifE6ys91D1V3wve" +
       "82b2w8qrfvN9FxEENn7wXON9m1955zfe/p0PP/eFfZvX3qDNaGnrKnhK/cTy" +
       "3j96Hflk67ZcjTsDP7LyyT+DvHD/8WHN9V0AV96rjnvMKw+OKp/jf2/xrk/p" +
       "/3wRuZtBLqm+E7vQj+5TfTewHD2kdU8PFaBrDHKX7mlkUc8gl2GetTx9Xzpa" +
       "rSIdMMjtTlF0yS9+QxOtYBe5iS7DvOWt/KN8oACzyO8CBEEuwwe5Bz6PIfu/" +
       "4j9A3omavqujiqp4luej49DP8ecT6mkKCvQI5jVYG/joEvr/+rsqBw008uMQ" +
       "OiTqhwaqQK8w9X0lqkYRqnsG1BBNFCfW0SgxUMaFnsFDCHrubZziwZ/hQe6F" +
       "wf/z+LvcPle3Fy7AqXvdeeJw4Jrr+Q6Uekp9Jm5T3/jsU39w8XghHVoWINeh" +
       "Egd7JQ4KJQ6gEgd7JQ4KJQ6gEgc3VAK5cKEY+5W5MnuXgRO+htQBSfWeJ4Xv" +
       "67/jfY/dBn012N4OZytvit6c28kTsmEKSlWhxyPPfWT7bumHyheRi2dJOgcA" +
       "i+7Oxcc5tR5T6LXzi/NG/V5571e/+bkPP+2fLNMzrH/IHs+XzFf/Y+dNHfqq" +
       "rkE+Pen+zY8ov/zUbz597SJyO6QUSKNAgfaEDPXw+THOsMD1I0bNsdwBAa/8" +
       "0FWcvOqIBu8GZuhvT0oKH7i3yN8HbfxW5DA5s07y2geCPH3l3mfySTuHomDs" +
       "twrBx//8D/+xVpj7iNyvnHpdCjq4fopQ8s6uFNRx34kPTENdh+3++iPjn/zQ" +
       "1977PYUDwBaP32jAa3lKQiKBUwjN/MNf2PzFV778iS9dPHEaAN+o8dKx1N0e" +
       "5P/Avwvw+e/8ycHlBXsyuJ88ZKRHjikpyEd+44lukJwcuEBzD7omeq6vWStL" +
       "WTp67rH/eeWJyi//yweu7n3CgSVHLvWdL9zBSfm3t5F3/cH3/9vDRTcX1Pzl" +
       "eGK/k2Z7xn3gpGciDJU012P37j9+/Uc/r3wccjfky8jK9IICkcIeSDGB5cIW" +
       "pSJFz9VV8+QN0emFcHatnQpinlI/+KWvv0L6+m99o9D2bBR0et45Jbi+d7U8" +
       "eWQHu3/1+VXfUyITtsOeG37vVee5b8EeZdijCpkuGoWQOHZnvOSw9R2X//K3" +
       "f+dV7/ij25CLXeRux1e0rlIsOOQu6Ol6ZEIK2wXf/fa9N2/vhMnVAiryPPB7" +
       "B3lN8et2qOCTN+eabh7EnCzX1/zHyFm+5+/+/XlGKFjmBu/uc/Iy+umPPUS+" +
       "7Z8L+ZPlnks/vHs+N8OA70S2+in3Xy8+dul3LyKXZeSqehhNSjnzwkUkwwgq" +
       "OgoxYcR5pv5sNLR/9V8/prPXnaeaU8OeJ5qTdwLM563z/N3nuOW1uZXfBp83" +
       "HXLLm85zywWkyLy9EHm0SK/lyZuKObkNIHcFoQ+gljqMAC9FRegKoCaWpzjF" +
       "YE/C4uKlExXCDwKk9MLvp30YCH1pT215WssTYu8Q9Zs6z/ViyN0FyDF3VA8a" +
       "B+X8N3sT5fPsd+QJlSfdI3VfbTvqtSPekWDkDd3mmu00jvS/Wnh8PkGHep5T" +
       "8sn/s5LQo+896Yz1YeT7/r//4Bd//PGvQLfrI3cUxoDedmrEYZx/DPzIpz/0" +
       "+m975m/eX5AqZNTxh6mrb897FV8c1IdyqEIRu7BKBLiC+3StQHvL1TYOLRe+" +
       "LpLDSBd9+v6vrD/21c/so9jzS+tcY/19z/zo/xx84JmLp74dHn9e+H5aZv/9" +
       "UCj9ikMLh8ijtxqlkOj+w+ee/o2fe/q9e63uPxsJU/BD7zN/+l9fPPjI3/z+" +
       "DYKo2x3/JUwsuPcLPSxiiKM/TpL16lbc7dzVqMR5bRslTNPfVofmZO6pjjno" +
       "DEyCoTFr6DWGPrURVyy3VGtapd4EjSTKgNsjUmkCtDYTSNR2MFuT6G5an5A8" +
       "tVT69Ebs93tbh3ettl8NBsbaWuJMdT0Nxu0eFgrl6bIk15aVVo0bVTZDYaq5" +
       "eAy/f90k0pIkLi3jJVcTB27sSwsprVGq3wOib2j12bI5V7JNXysHi0pjRVbr" +
       "9hYbgl4LQ1tJMiB6uNQtDyftsKeyM1Jf8iTbbU0shWn69d2yT7TIKrVrO72w" +
       "LJd9o2IOrCBtd2aMblmOsGGMsos5U9NuDzdpV+SrrtQe2ooYkLgxEbNJJVMW" +
       "fdWNiTpb7vborshaYdiTXTPl5pP6zjRB6uDjoG5UEyIaYzNSsRxmy442ZaY+" +
       "MvuKbzVEZ0Aa1UmHqEVrR1FMYKjzwLFNyJiKXcdbWptgp6vOkMxYMhY3da9C" +
       "SfWJSRklm04SwPvuujWs+fW6sbbJRcMinQ1Zidm22+MZcrepz8DUWPFTq78b" +
       "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" +
       "JokZoBoDpUGOE3litFetatmpehtu4xrl2dAOxuulbGhC1671tLnSJRN6iKtD" +
       "CoxWtIw2zD7XnapDzO9RKjRrQ1nPSzLeloTNbJhgI2NpV3FdTVrDUrO+1FKe" +
       "5BmdntHZlFmQaWj1UxxTZ0Y4kqOKVIHRcgUI3gDEoBrhFb6ki/aMk1XDQrNq" +
       "mM7bYbDU3IafadBJG2g9ptNBhZSWa7XUac/rLZBNdVEebhtdV8/M1WZiewOv" +
       "vqpIPUhjOOs1GsGmpM8ZzvDZIGZVUej6JT1pCbLYWoGS1HbIQCLrayNFR8Da" +
       "8iXM3gYdd2Nn7GIdKFmCJ8P+HHBqWu03dE7RiKC6XEWlQLAqIKuPEm0Qi4Fg" +
       "+m7Vi2qjIPCs0Sx2JA3yslVuyCSfyK5LLLKpGiqhG87Yfk/LUsgidqqqTXPV" +
       "7NEO5VgJpcEv17fmn7SrF7ercF+xgXJ8+Gc7jbxi8iK+pvdVj+bJE8ebVcXf" +
       "pVtshJ/aLETyHYLX3+xMr9gd+MR7nnlWG32ycvFwk1UByF3AD77L0RPdOdXV" +
       "ZdjTm2++E8IVR5onm3+ff88/PTR9m/mOF3G88YZzep7v8ue5T/8+/Ub1Jy4i" +
       "tx1vBT7vsPWs0PWzG4B3hzqIQ296Zhvw9ceWfSC32Bvhgx9aFr/xEcMNveBC" +
       "4QX7ub/FHvY7b1H3g3myBcgDVsR4ph5aQNfGoV8cXxcC33vKYd4BkMtL33d0" +
       "xTtxpt0Lbc2cHrIoAGfR5xufbzlE/5aXH/37b1H3Y3nyIwB5pRURnuUqID98" +
       "OIKf173rBOd7XyrOJ+BDHuIkX36cP3WLuo/myU8A5H4rv8tQbNXdBOVPvgSU" +
       "V/LCh+HTP0TZf/lR/swt6j6ZJ88C5IqhgyN4x2d75/z4NuvwkkmB+qdfAur7" +
       "88JH4cMfouZfftS/eIu6X8qTz5xFPTzkn8kJxM++BIjFK+AR+MiHEOWXH+Jv" +
       "3aLuuTz5tT3Ejr5SYmd/ZHN0LPCmFz7WOGlfWOPXX4I1HswLH4ePcmgN5eW3" +
       "xhdvUfeHefJ5gNwLrcFougfyg4P9laLeCcIvvBiEO4A8eMNLCfmp6mued4tq" +
       "f/NH/eyzV+589bPinxXn8se3c+5ikTtXseOcPgQ7lb8UhPrKKoDctT8SC4p/" +
       "fwKQJ/5Ptyfg2oVpAeFLe9E/B8ijLygKDs90Tgv+FUBeewtBgFzaZ07LfBm+" +
       "LW4kA9WC6emWfwuQq+dbQi2K/6fb/T1A7j5pBwfdZ043+QfYO2ySZ78aHHl9" +
       "7YXNdeIeh/O5u3A2Ujt2l/tfyF1OBXePnwnJiqt4R+FTvL+M95T6uWf7wx/4" +
       "Rv2T+7sPqqNkWd7LnSxyeX8N4zgEe/SmvR31dan35Lfu/YW7njgKF+/dK3yy" +
       "yk7p9oYbXy6g3AAU1wGyX331L73lZ5/9cnF897+CQLK0IykAAA==");
}
