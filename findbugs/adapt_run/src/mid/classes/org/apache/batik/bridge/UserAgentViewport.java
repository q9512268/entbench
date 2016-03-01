package org.apache.batik.bridge;
public class UserAgentViewport implements org.apache.batik.bridge.Viewport {
    private org.apache.batik.bridge.UserAgent userAgent;
    public UserAgentViewport(org.apache.batik.bridge.UserAgent userAgent) {
        super(
          );
        this.
          userAgent =
          userAgent;
    }
    public float getWidth() { return (float) userAgent.getViewportSize().
                                       getWidth(
                                         ); }
    public float getHeight() { return (float) userAgent.getViewportSize().
                                        getHeight(
                                          ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YfWwUxxWfO+PzBwZ/EAwxYIwxSHbIXZ2EppFpGuNAbHLG" +
                                                              "Jwy0NWmOub25u8V7u8vurH04cQlELRSpCAUnpW3gnxKlRSREVaNWrUKp+pFE" +
                                                              "aYqgUZsENWmbP5I2QQp/NE5L2/TNzH7d3p1R/qmlnVvPvPdm3tfvvdmzV1G1" +
                                                              "aaBOHatpHKX7dGJGE+w9gQ2TpAcUbJrbYTYpHfnL8f2zv687EEaRMbQwh81h" +
                                                              "CZtks0yUtDmGVsiqSbEqEXMrIWnGkTCISYwJTGVNHUOLZXMoryuyJNNhLU0Y" +
                                                              "wU5sxFEzptSQUxYlQ7YAilbG+Wli/DSx/iBBXxw1SJq+z2NoK2IY8K0x2ry3" +
                                                              "n0lRU3wPnsAxi8pKLC6btK9goFt0TdmXVTQaJQUa3aOstw2xJb6+xAydzzV+" +
                                                              "dP1YrombYRFWVY1yFc1txNSUCZKOo0ZvdpNC8uZe9FVUFUfzfcQUdcWdTWOw" +
                                                              "aQw2dfT1qOD0C4hq5Qc0rg51JEV0iR2IolXFQnRs4LwtJsHPDBJqqa07ZwZt" +
                                                              "O1xtHXcHVHz8ltjMtx5s+mEVahxDjbI6yo4jwSEobDIGBiX5FDHM/nSapMdQ" +
                                                              "swoOHyWGjBV5yvZ2iylnVUwtCAHHLGzS0onB9/RsBZ4E3QxLoprhqpfhQWX/" +
                                                              "V51RcBZ0bfV0FRpuZvOgYL0MBzMyGGLPZpk3LqtpHkfFHK6OXfcDAbDW5AnN" +
                                                              "ae5W81QME6hFhIiC1WxsFIJPzQJptQYhaPBYqyCU2VrH0jjOkiRFS4N0CbEE" +
                                                              "VHXcEIyFosVBMi4JvNQW8JLPP1e3bjj6kDqohlEIzpwmksLOPx+Y2gNM20iG" +
                                                              "GATyQDA29MSfwK0vHA4jBMSLA8SC5scPX7tnXfuFlwTNsjI0I6k9RKJJ6XRq" +
                                                              "4aXlA913VbFj1OqaKTPnF2nOsyxhr/QVdECaVlciW4w6ixe2/ebLj5wh74dR" +
                                                              "/RCKSJpi5SGOmiUtr8sKMe4jKjEwJekhVEfU9ABfH0I18B6XVSJmRzIZk9Ah" +
                                                              "NE/hUxGN/w8myoAIZqJ6eJfVjOa865jm+HtBRwjVwINug2cZEn/8l6I9sZyW" +
                                                              "JzEsYVVWtVjC0Jj+zKEcc4gJ72lY1bVYCuJ//Nbe6J0xU7MMCMiYZmRjGKIi" +
                                                              "R8RiLGXI6SyJ7QBs7M8Sle6UyaSuGQA7EHP6/3W3AtN90WQoBG5ZHgQFBfJp" +
                                                              "UFPSxEhKM9bGTdeeTb4iAo4liW01irphy6jYMsq3jIotoyVbolCI73QT21o4" +
                                                              "H1w3DiAAKNzQPfqVLbsPd1ZB1OmT88DujHRtSVUa8NDCgfikdPbSttmLr9af" +
                                                              "CaMwAEoKqpJXGrqKSoOobIYmkTRgU6Ui4QBlrHJZKHsOdOHE5IGd+z/Dz+FH" +
                                                              "eyawGoCKsScYRrtbdAWzvJzcxkPvfXTuiWnNy/ei8uFUvRJOBiOdQb8GlU9K" +
                                                              "PR34+eQL011hNA+wCfCYYsgfcFh7cI8iOOlzoJnpUgsKZzQjjxW25OBpPc0Z" +
                                                              "2qQ3wwOumb/fBC6ez/JrOTyr7YTjv2y1VWfjEhGgLGYCWnDo//yofvL13/3t" +
                                                              "dm5up0o0+sr7KKF9PmRiwlo4BjV7IbjdIATo/nQicfzxq4d28fgDitXlNuxi" +
                                                              "4wAgErgQzPy1l/a+8fZbp18LezFLoTRbKehyCq6SbB7Vz6Eki3PvPIBsCuQ7" +
                                                              "i5quHSpEpZyRcUohLEn+3bim9/kPjjaJOFBgxgmjdTcW4M3fvBE98sqDs+1c" +
                                                              "TEhildWzmUcm4HqRJ7nfMPA+do7Cgcsrvv0iPgnAD2BrylOE42fIzlt2qKXQ" +
                                                              "m9wQGbh77+D0MT7ezkzDpSC+9jk2dJn+NCnORF+vlJSOvfbhgp0fnr/G9Spu" +
                                                              "tvxRMYz1PhGIbFhTAPFLgpA0iM0c0N1xYesDTcqF6yBxDCRKALHmiAGQWCiK" +
                                                              "IZu6uubNX/yydfelKhTejOoVDac3Y56OqA7ygJg5QNOC/oV7RBhM1sLQxFVF" +
                                                              "Jcozy68s79NNeZ1yL0z9ZMmPNjx96i0efiLelrnI2VGCnLxR95L+gyvffefn" +
                                                              "s9+rEWW+uzLSBfiW/mtESR3868clRuYYV6YFCfCPxc4+2TZw9/uc3wMbxr26" +
                                                              "UFqGAI493tvO5P8R7oz8OoxqxlCTZDfFO7FisRQeg0bQdDplaJyL1oubOtHB" +
                                                              "9LlgujwIdL5tgzDnlT94Z9TsfUEA2RqYFzvgWWEn/YogsoUQfxniLGv52M2G" +
                                                              "dQ6Q1OiGDJcnEkCS+XMIpajOcnKLTawX8MnGu9iwRcjaUC4ExdJaNvS4O/K/" +
                                                              "SLAj8mOXP+rsvO+olPdOI8AybkWl7pZ35qcPzpxKjzzVK4Kzpbhj3AQXomf+" +
                                                              "8J/fRk/8+eUyDUkd1fRbFTJBFN/hwrDlqpKUGObNvxdfd16erbry2NKG0j6C" +
                                                              "SWqv0CX0VM6d4AYvHvx72/a7c7s/RYOwMmCooMgfDJ99+b610mNhfn8R4Vxy" +
                                                              "7ylm6isO4nqDwEVN3V4Uyp1uDDQzl98MT48dAz3li3SZ8HFLXyXWOaCfzLGW" +
                                                              "ZcNuimqzhH5RTtMcrxA+77IvDKNWyqQJQ85D7Z+w7z/nWmf3/qpm6l7nblOO" +
                                                              "RVDebw5f/Ongu0nuqVoWCq59fGHQb2R9jU2TUPwT+AvB81/2sDOzCXGTaBmw" +
                                                              "rzMd7n1G11k6zIG/ARVi0y1vjz/53jNChSDYBojJ4Zkjn0SPzog0EZfi1SX3" +
                                                              "Uj+PuBgLddigFHjmzLEL59j87rnpn31/+lDY9tCXKANNDVPXfyG3NLUGzS7O" +
                                                              "Guk9+c/9X399BLrQIVRrqfJeiwyli0O1xrRSPj9492gvcO1TM5vDjaNHtysj" +
                                                              "xz88B/6VlmA20c+nHyhOhjZ4eu2I7v30yVCJdY6APzDH2qNseBhwD5JhkMjZ" +
                                                              "HIf+cU/r6U+vdYGi5pL7G+tJlpZ8OhKfO6RnTzXWLjm144/8DuF+kmiA3MlY" +
                                                              "iuIvmb73iG6QjMy1aBAFVOc/RyhaUqGIQIMtXvjJvyHov0lRU5AeApD/+umO" +
                                                              "UVTv0YEo8eInOU5RFZCw1xndqWhNvBNjnUNUdA6FkK+2IF+ELb6RrV0W/xWD" +
                                                              "5Tz/dOckhSU+3gFgndqy9aFrn31KXHEkBU9NMSnzIRXEbcutE6sqSnNkRQa7" +
                                                              "ry98rm6Nk6PN4sBewC7zRVU/5KrOPN4W6P/NLvca8MbpDedfPRy5DOiyC4Uw" +
                                                              "RYt2lfZYBd2CIrYrXi7poYryq0lf/Tu7L378ZqiFt7I2TLTPxZGUjp+/ksjo" +
                                                              "+nfCqG4IVQMEkQJvAO/dp24j0oRRhCGRlGap7le+hSw8Mfusxy1jG3SBO8uu" +
                                                              "yBR1luJk6WcD6PInibGRSbcxqaiyWrruX+WWnRAAJQpCVTI+rOt2gQhv4pbX" +
                                                              "dZ6ET7Nh8n+oUdlWnxcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aeczs1lX3+97+muS9pG2SptnzWkim/Tz7orSlHo89Y4/H" +
       "HnvGngXaV69jezy2x8t4KaGboKWVQgRpWlAbgdQKqNJFiAokVBSEoK1aIRVV" +
       "bBJthZAolErNHxREgXLt+fa3hAjESL5z595zzj3n3nN+9/jeeeH70Fnfgwqu" +
       "YyULywl21TjYNa3abpC4qr9LUrWh6Pmqglqi749B2zX50S9c/uGPntGv7EDn" +
       "5tCrRdt2AjEwHNvnVN+xNqpCQZcPWzFLXfkBdIUyxY0Ih4FhwZThB09S0KuO" +
       "sAbQVWpfBRioAAMV4FwFGDmkAky3q3a4QjMO0Q78NfRz0CkKOufKmXoB9Mhx" +
       "Ia7oias9McPcAiDhQvZbAEblzLEHPXxg+9bm6wz+aAF+9mPvvPI7p6HLc+iy" +
       "YY8ydWSgRAAGmUO3rdSVpHo+oiiqMofutFVVGameIVpGmus9h+7yjYUtBqGn" +
       "HkxS1hi6qpePeThzt8mZbV4oB453YJ5mqJay/+usZokLYOvdh7ZuLcSzdmDg" +
       "JQMo5mmirO6znFkathJAD53kOLDxah8QANbzKzXQnYOhztgiaIDu2q6dJdoL" +
       "eBR4hr0ApGedEIwSQPfdVGg2164oL8WFei2A7j1JN9x2AaqL+URkLAH02pNk" +
       "uSSwSvedWKUj6/N9+i1Pv9vu2Tu5zooqW5n+FwDTgyeYOFVTPdWW1S3jbU9Q" +
       "z4l3f+lDOxAEiF97gnhL83s/+9Lb3/Tgi1/Z0rz+BjSMZKpycE3+lHTHN+5H" +
       "H2+dztS44Dq+kS3+Mctz9x/u9TwZuyDy7j6QmHXu7ne+yP3p7L2fUb+3A10i" +
       "oHOyY4Ur4Ed3ys7KNSzV66q26omBqhDQRdVW0LyfgM6DOmXY6raV0TRfDQjo" +
       "jJU3nXPy32CKNCAim6LzoG7YmrNfd8VAz+uxC0HQefBAZfC8Htp+8u8AMmHd" +
       "WamwKIu2YTvw0HMy+7MFtRURDlQf1BXQ6zqwBPx/+ebSbgP2ndADDgk73gIW" +
       "gVfo6rYTljxDWagw76seslDtQDDUyHU8AELA59z/19HizPYr0alTYFnuPwkK" +
       "FoinnmMpqndNfjZsYy997trXdg6CZG/WAuhxMOTudsjdfMjd7ZC71w0JnTqV" +
       "j/SabOjt4oOlWwIQAPB42+Ojd5Dv+tCjp4HXudEZMO8ZKXxzlEYPYYPIwVEG" +
       "vgu9+PHofcJ7ijvQznG4zdQFTZcy9mEGkgdgePVkmN1I7uUPfveHn3/uKecw" +
       "4I7h9x4OXM+ZxfGjJyfWc2RVAch4KP6Jh8UvXvvSU1d3oDMAHAAgBiJwYDBj" +
       "D54c41g8P7mPjZktZ4HBmuOtRCvr2ge0S4HuOdFhS77id+T1O8Ecvypz8PvB" +
       "89iex+ffWe+r3ax8zdZDskU7YUWOvW8duZ/8qz/7x0o+3fswffnIxjdSgyeP" +
       "QEMm7HIOAnce+sDYU1VA97cfH/7KR7//wZ/OHQBQPHajAa9mJQogASwhmOaf" +
       "/8r6r7/9rU99c+fQaQKwN4aSZcjxgZFZO3TpFkaC0d54qA+AFgsEXOY1V3l7" +
       "5SiGZoiSpWZe+h+X31D64j8/fWXrBxZo2XejN728gMP217Wh937tnf/6YC7m" +
       "lJxtbYdzdki2xctXH0pGPE9MMj3i9/35A7/6ZfGTAHkB2vlGquYAdmovcDKl" +
       "XguSg5cNzXx54Zz+ibzczaYmlwLlfZWseMg/GibHI/FIsnJNfuabP7hd+MEf" +
       "vpTbdTzbOeoVA9F9cuuIWfFwDMTfcxITeqKvA7rqi/TPXLFe/BGQOAcSZYBx" +
       "PuMBTIqP+dAe9dnzf/NHf3z3u75xGtrBoUuWIyq4mIcjdBHEgerrAM5i96fe" +
       "vnWD6AIoruSmQtcZv3Wfe/NfZ4CCj98cifAsWTkM5nv/nbGk9//dv103CTkG" +
       "3WCPPsE/h1/4xH3o276X8x+CQcb9YHw9ToPE7pC3/JnVv+w8eu5PdqDzc+iK" +
       "vJc1CqIVZiE2B5mSv59KgszyWP/xrGe7xT95AHb3nwSiI8OehKHD/QHUM+qs" +
       "fukE8tyWzfLD4HlgLygfOIk8p6C8guQsj+Tl1az4if1AP+96xgakBHuR/mPw" +
       "OQWe/8qeTFjWsN3A70L3soiHD9IIF2xdF8P9OMgEFLdQl5XVrGhv5TZu6i5v" +
       "yQo8PgVUOVvebezmAvo3Vvd0Vv1JAE5+nkoDDs2wRSufFDwA7m/JV/eVFEBq" +
       "Dfzlqmk19iP5Su7q2crsbvPRE7ri/2NdgSvfcSiMckBq+5G/f+brv/TYt4G/" +
       "kdDZTeYLwM2OjEiHWbb/Cy989IFXPfudj+RYC+Z/+Bx25e2ZVOFWFmcFkxXD" +
       "fVPvy0wd5ekKJfrBIIdHVcmtvWWYDT1jBXaRzV4qCz9117eXn/juZ7dp6smY" +
       "OkGsfujZD/949+lnd468HDx2XX5+lGf7gpArffveDHvQI7caJefA/+HzT/3B" +
       "bz31wa1Wdx1PdTHwJvfZv/jPr+9+/DtfvUEmdcZy/hcLG9ze7FV9Atn/UKWZ" +
       "Non4OJ5oTGGYtqM5jCFRPCOieNSTiOm8jLku7nZDGpF6VJeMkiI9WTGhVK6F" +
       "TaERNjeh1ytWZdbCKG7koghvu5PKwo77FjfiMEGkJx7fdwsujomz9YKf+xjg" +
       "l4Y1osyyLkxjNaoMj+m011AqbomD1yvLFjbDzVBZVQJts1FWqVDqlkSxzfTE" +
       "wO31pw2lS3axQtRasOWxi8i8RHrSbDxze5pNNbVyuqk3GxgmcgOJjfRmSUfn" +
       "wdIvJnzQWXUF31iPJGyNTQceMbG7yzFKjGYROe4KdI9nqPl04HhJmJA0rVN8" +
       "cRbxNT/GsdQNRiwfzyy2MUMMS+oWJpYBd0YxbLTb0zgqjch1IS3TTr9MzJr9" +
       "Ylz2kopdtDi+Eg1tH4mNptun0LoU9FsLBw+KY2U1FcasSLK8WBEZP4jKMSnV" +
       "CzGSKGkqFJRhaeY5K2nG4RNhVkpwuRTE9IhH533GKc43ikujzXCutnCBx3kt" +
       "1WSWV+SJMp4wkchGZUUbl9ZMp4hW9XWNlYveolYiMaFocGXCsaY4a3N+lYoC" +
       "0u8NO21yvRaLjXk0D5hSHPSmck/opU0rMAdBXPMLK7CMetwxJaKeOFUzGmGO" +
       "1CG6bWNawzu9AWyPRHegsH7kML1k0jXbQi3ZzMtGApaSjwIU6QHPSUdFx263" +
       "YM5vz6tYhY0px/X0tavp7GQKC7USJ7fnRUkTijjnhvMNs5hRxUE7HSTdLjWc" +
       "u8sKtQbrv9TwXr/OTDW5g0idSQ2xaVGtTZoldoDVdVwnDLQ0iX2cIIcpS7oB" +
       "O9PFYXu2TlC+LABPNU1maXD4qEoXUQnDBGAsRiS44wvtgVElNzQ7aZLUcFhS" +
       "K5Jp1pedtaNbGJG60WrpU8wwLszKC3pQLhrdLjJO2A5Sbg1GWtQvbnpI1WwP" +
       "RhTSHKE1Xx5OG4E91ULcisa0bxJFor5scX2SrE+5dVWcWkirVBEk3Cwxa7E/" +
       "Htp42Wb8JNY9mBUUDBUFSzYm1ahuxGoZViXKrEV6o6pwMIf2R6Rr1EZdZmXw" +
       "gdf0+wO1avZNLCLVpS5gGt9C2lqvSJSa7fpUGJErLiXmyxai0xis83GXhqPm" +
       "KnEQYr4m6yqpCSYjNus1c1XoBW0uMoWIoMNFWZ5jNty06kTLnycTMsX8mSBM" +
       "AsFEi6RZSPuYLFcXZKNszUqSMENDEoZpSa2TxZhvDAbowJjNV5zZ7RMG1+QM" +
       "qjsl6qOEbLBtvzFojiy1zifiKOyySAPrDetwZVJBArpVnLBOu1ub9xYs3tZI" +
       "l8eHoxjT+4OW1B0rqjqWqgbiVC1jUiwZnqsndXM28NcVk3ACJxEkx0KJRoUd" +
       "l0tOtVeKKh0DQfp0yg61tUBJ/lApzdslZjVuNjuh2eOCkcCLTbqDLjRjqQyl" +
       "URCsKK8laqg4iBDM6a9dctr11v2RwzgSMVstx9yCr/NGlW1bXo+c93s+ozA9" +
       "rEZ0lUIKd9IC3lMTMeo6aN8fyTPOCyQFmaQbMpXj5XCjTcehMbHpBFaNZojz" +
       "G45k2gajsFKza/Gt/pCrVAsqSxVLJZ1GChGqobOZv9BkXG/IRNNgGCt1SNvl" +
       "F35/nrKmGU/KNabtDuXivLxmK1HEgK0Y1tpoXU1h0mPGideYjc1NOSkJE83E" +
       "9O6C6s7Qid1xYDhxtA1VqsCVQFnVQrfoFAu+1+j38dZwxRmR5VTbptAgJFMh" +
       "kLED26wha2m8rirlprboGMHUosPYqEbIAvMWbDpMShYsFpraXHJLTUpNccoZ" +
       "c1Jf1RN0XR9J7YaQ1rGlUQEQT7R9NGQbRm0d9kYu5s4TTuYdncLsQkUyVi14" +
       "OTRNkWTw9iJerExlLE+qg4q2aWOtpr/u+IWSPMZ0w1Im6YqXV9XemiMbtjYY" +
       "IgXFaaAL2fc2m6IxXNhIp9z2EovBqmWNSK2gvO5P2VUrYruS3mgUOsXBuKGm" +
       "y7TjjtBCy1yWFdIu0KjNcHhhY5EjZqNJ+sItarYHd1sjNww2MTeYpaWh3iUk" +
       "XB8jQ5xauEjRGBTlIl2KZ6rfGctrvJ604w7K9RGqtzKQLjtBjT4xD+thKNFT" +
       "OEkUTbX6+lg1GUfoiHJlVqsza6SRLMhFjaUZFHaEBtfWByWfYmNcwEnZSZN6" +
       "02+0aFqdlxKqmLbmg9WQNuNW3SiqmkGplmcTZaGL2lTMtWpUYZFsNE3VbL9V" +
       "8LDJpBCm1KitGRN4FWAjrtKsN2WLC2czoT7Dga8NY7laKI/nUQsO5Uo0kGKv" +
       "XOfxdRchqq1KsGFqwybXcNIm48Tr2ELH846GMw3c8DlWXRQlVum4lkgmVMkJ" +
       "JSbotVuUtQjNiFCoWrBIO7Y1blXnrbGv8RhS5tYzPN0sJhOANDNn4Ts8q8U2" +
       "wIpNrTwodxW2zpYYo9shZRtboqPCdEC4osnIdp8ai9G0ObC7YcuIONkUebSK" +
       "xQop0ptRlYH7MEBis7lipsOC52+YgmMNFYZoIom0nFgNd16preVh6sZ9E2y4" +
       "/Wo/dSXdrCDs1FlphSYJa9wSbhZUPunwS6WkcRI+Jts4DeuR17HWbp/vMhK9" +
       "iRVNKdVVT/KSMt3vFs06OpqsN0V0WhQGdaWKzDa9Tdwow2JDbvgwN2OiwQp1" +
       "nMFC65CtVkGql4orWtfsJlcV4qSRWKu64TNVe92JMIGuCFU+cUthp8OmVqs5" +
       "GFebCpJWLKMymjd7ODVNphNGRLWU6k7mMh0aq3Wq92rcOBjIXowUGg1i0+nT" +
       "k2TNkmyz1mnMC1Ejhe3JSqvAa3dVtxq2ZDEMJ3RUKappMGMvwqIdrgVngq5r" +
       "La3bY6Uy1zL58pgfRuMCsmk3S3DZ7zApOu2OxfYq8tKB0rBBklZa1lOiCyOc" +
       "YBST0sZM4VrFpFF91Jm1HZOszpemXRwNU2dRxOaaURpNK7xZGIbtBaUoxgLv" +
       "mauUwqhay2w2PNu1KyW4YHVmrQCd9hGa7gjDqZZ0KzTFg2yiwXTDZasgw61p" +
       "pdVqUx5LCJy31kjViBLLKIJMxuNGQ7NVbZUXG5kpjQe1TccU6V6Q+GacNptt" +
       "uC5YK6RclAt2L9EZ3ZxX1bBMNDaVYiKgpDKrI8O00yuvaV9t61GnRurLgTnv" +
       "EVpB5mGvzhc2yqxr1Fyq0S0EpOXOm4ze15g6Z4/T6YQyV6VqFQa7DF5Yguiv" +
       "DKyZERKbldSoGN06aw6SkthGcIGRYS7RRX7dJVhiEEw3JrlJes4myx9riIq4" +
       "HbgQrhheGG+KM8xpqoTN8DUOn6NRKbaV9USnN23atHmaV5A6vuwXygRewCip" +
       "znlCcQLHk05tnMIKIy/1EV+oLPAF4EpaIu6BOe5Pe9iyzbfowchOCW6KSXIY" +
       "YHV/PbLpJceKDS9pNb1VnV7Wh3TVb6sR2kg5gYdrfY8BLZP6EKapjSw2B5Lb" +
       "URVtyCW1DmMkaJWPuFlQtrT5rK2UUcKbeVOj4TozL1kXLQ0ehw2q0mjO1wYe" +
       "NIjymBoP43mXN90CvPRNp2Br6LpbJQSQ2i1ZcoMwsOKWq2bR4Tgd7XJWV3Qb" +
       "llrQR1FzoIV+nJTMbmXUZpphmLS5khWSy/pE7tSHhG1IXW4kyfFaNJKJ54XT" +
       "wmRicwhCsi4qjImCxwTlBatvqq40VeZ1bNyg9aZdcHjFmtixDF6U3vrW7BVq" +
       "8creYu/MX9gPbpPAy2vWwb2Ct7dt1yNZ8YaDU5H8c+7kDcTRo8rDU6mDY76H" +
       "b3bMt3/wnr26PnCz26T8tfVT73/2eYX5dGln79hPCqCLgeO+2VI3qnVkzB0g" +
       "6Ymbv6IP8su0w+OoL7//n+4bv01/1ys4jn/ohJ4nRf724IWvdt8o//IOdPrg" +
       "cOq6a77jTE8eP5K65KlB6NnjYwdTDxwsQb4MrwPPE3tL8MSNj8RvfCqVu8vW" +
       "SW5xqvqeW/S9LyvSALqwUIOJoQR6TvWOI+4kZqdHliMGh4727pc7Jjg6St4Q" +
       "HTf4PvCU9gwu/d8b/PQt+p7Jil8EDgcM7qnGQs9P4z5waNyHX4lxMYjN626e" +
       "smP0e6+79N5e1Mqfe/7yhXue5/8yv3w5uEy9SEEXtNCyjp5lHqmfcz2QkuX6" +
       "X9yebLr518cC6J6bhGMAndtWcp2f29L/WgBdOUkPljf/Pkr3yQC6dEgHRG0r" +
       "R0l+PYBOA5Ks+hvuDQ4Ot0e68akj4bznC/ks3/Vys3zAcvRuJoOA/E8H++Ea" +
       "bv92cE3+/PMk/e6X6p/e3g3JlpimmZQLFHR+e011EPKP3FTavqxzvcd/dMcX" +
       "Lr5hH57u2Cp86JdHdHvoxhcx2MoN8quT9Pfv+d23/Obz38rPMf8bHaO+GQ0i" +
       "AAA=");
}
