package org.apache.xalan.templates;
public class FuncFormatNumb extends org.apache.xpath.functions.Function3Args {
    static final long serialVersionUID = -8869935264870858636L;
    public org.apache.xpath.objects.XObject execute(org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException { org.apache.xalan.templates.ElemTemplateElement templElem =
                                                              (org.apache.xalan.templates.ElemTemplateElement)
                                                                xctxt.
                                                                getNamespaceContext(
                                                                  );
                                                            org.apache.xalan.templates.StylesheetRoot ss =
                                                              templElem.
                                                              getStylesheetRoot(
                                                                );
                                                            java.text.DecimalFormat formatter =
                                                              null;
                                                            java.text.DecimalFormatSymbols dfs =
                                                              null;
                                                            double num =
                                                              getArg0(
                                                                ).
                                                              execute(
                                                                xctxt).
                                                              num(
                                                                );
                                                            java.lang.String patternStr =
                                                              getArg1(
                                                                ).
                                                              execute(
                                                                xctxt).
                                                              str(
                                                                );
                                                            if (patternStr.
                                                                  indexOf(
                                                                    164) >
                                                                  0)
                                                                ss.
                                                                  error(
                                                                    org.apache.xalan.res.XSLTErrorResources.
                                                                      ER_CURRENCY_SIGN_ILLEGAL);
                                                            try {
                                                                org.apache.xpath.Expression arg2Expr =
                                                                  getArg2(
                                                                    );
                                                                if (null !=
                                                                      arg2Expr) {
                                                                    java.lang.String dfName =
                                                                      arg2Expr.
                                                                      execute(
                                                                        xctxt).
                                                                      str(
                                                                        );
                                                                    org.apache.xml.utils.QName qname =
                                                                      new org.apache.xml.utils.QName(
                                                                      dfName,
                                                                      xctxt.
                                                                        getNamespaceContext(
                                                                          ));
                                                                    dfs =
                                                                      ss.
                                                                        getDecimalFormatComposed(
                                                                          qname);
                                                                    if (null ==
                                                                          dfs) {
                                                                        warn(
                                                                          xctxt,
                                                                          org.apache.xalan.res.XSLTErrorResources.
                                                                            WG_NO_DECIMALFORMAT_DECLARATION,
                                                                          new java.lang.Object[] { dfName });
                                                                    }
                                                                    else {
                                                                        formatter =
                                                                          new java.text.DecimalFormat(
                                                                            );
                                                                        formatter.
                                                                          setDecimalFormatSymbols(
                                                                            dfs);
                                                                        formatter.
                                                                          applyLocalizedPattern(
                                                                            patternStr);
                                                                    }
                                                                }
                                                                if (null ==
                                                                      formatter) {
                                                                    dfs =
                                                                      ss.
                                                                        getDecimalFormatComposed(
                                                                          new org.apache.xml.utils.QName(
                                                                            ""));
                                                                    if (dfs !=
                                                                          null) {
                                                                        formatter =
                                                                          new java.text.DecimalFormat(
                                                                            );
                                                                        formatter.
                                                                          setDecimalFormatSymbols(
                                                                            dfs);
                                                                        formatter.
                                                                          applyLocalizedPattern(
                                                                            patternStr);
                                                                    }
                                                                    else {
                                                                        dfs =
                                                                          new java.text.DecimalFormatSymbols(
                                                                            java.util.Locale.
                                                                              US);
                                                                        dfs.
                                                                          setInfinity(
                                                                            org.apache.xalan.templates.Constants.
                                                                              ATTRVAL_INFINITY);
                                                                        dfs.
                                                                          setNaN(
                                                                            org.apache.xalan.templates.Constants.
                                                                              ATTRVAL_NAN);
                                                                        formatter =
                                                                          new java.text.DecimalFormat(
                                                                            );
                                                                        formatter.
                                                                          setDecimalFormatSymbols(
                                                                            dfs);
                                                                        if (null !=
                                                                              patternStr)
                                                                            formatter.
                                                                              applyLocalizedPattern(
                                                                                patternStr);
                                                                    }
                                                                }
                                                                return new org.apache.xpath.objects.XString(
                                                                  formatter.
                                                                    format(
                                                                      num));
                                                            }
                                                            catch (java.lang.Exception iae) {
                                                                templElem.
                                                                  error(
                                                                    org.apache.xalan.res.XSLTErrorResources.
                                                                      ER_MALFORMED_FORMAT_STRING,
                                                                    new java.lang.Object[] { patternStr });
                                                                return org.apache.xpath.objects.XString.
                                                                         EMPTYSTRING;
                                                            }
    }
    public void warn(org.apache.xpath.XPathContext xctxt,
                     java.lang.String msg,
                     java.lang.Object[] args)
          throws javax.xml.transform.TransformerException {
        java.lang.String formattedMsg =
          org.apache.xalan.res.XSLMessages.
          createWarning(
            msg,
            args);
        javax.xml.transform.ErrorListener errHandler =
          xctxt.
          getErrorListener(
            );
        errHandler.
          warning(
            new javax.xml.transform.TransformerException(
              formattedMsg,
              (org.apache.xml.utils.SAXSourceLocator)
                xctxt.
                getSAXLocator(
                  )));
    }
    public void checkNumberArgs(int argNum)
          throws org.apache.xpath.functions.WrongNumberArgsException {
        if (argNum >
              3 ||
              argNum <
              2)
            reportWrongNumberArgs(
              );
    }
    protected void reportWrongNumberArgs()
          throws org.apache.xpath.functions.WrongNumberArgsException {
        throw new org.apache.xpath.functions.WrongNumberArgsException(
          org.apache.xalan.res.XSLMessages.
            createMessage(
              org.apache.xalan.res.XSLTErrorResources.
                ER_TWO_OR_THREE,
              null));
    }
    public FuncFormatNumb() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16f+zjyHUfd29v70fOt3vn2L5efec73zr1WcmXpCiKFC5O" +
       "TImiKIkiKZHUD7bJmuIPkeJPkRRF0b3YMdrYSArHaM+u6yaXP2I3iXG2gyJG" +
       "Y6Qprg3aOE0Q1IHRtCmaS4sCSesasP9oWtRt0yH1/b27515jRACHw5k3M2/e" +
       "vPeZpzfzyjeg+5MYqkWht195YXpk5unR2sOP0n1kJkcDDhe1ODGNjqcliQzK" +
       "buvv/OUbf/rtj9s3r0LXVejNWhCEqZY6YZBMzCT0MtPgoBtnpV3P9JMUusmt" +
       "tUyDt6njwZyTpC9w0Peca5pCt7gTFmDAAgxYgCsWYOqMCjR6kxls/U7ZQgvS" +
       "ZAP9GHSFg65HesleCj17sZNIizX/uBuxmgHo4cHyewomVTXOY+iZ07kf5nzH" +
       "hD9Rg1/6uz968x/eB91QoRtOIJXs6ICJFAyiQo/4pr8044QyDNNQoccC0zQk" +
       "M3Y0zykqvlXo8cRZBVq6jc1TIZWF28iMqzHPJPeIXs4t3uppGJ9Oz3JMzzj5" +
       "ut/ytBWY61vP5nqYIVOWgwk+7ADGYkvTzZMm11wnMFLoHZdbnM7x1hAQgKYP" +
       "+GZqh6dDXQs0UAA9flg7TwtWsJTGTrACpPeHWzBKCj15z05LWUea7mor83YK" +
       "PXGZTjxUAaqHKkGUTVLoLZfJqp7AKj15aZXOrc83+B/82AcCNrha8WyYulfy" +
       "/yBo9PSlRhPTMmMz0M1Dw0few31Se+uvf/QqBAHit1wiPtD8o7/+rfd9/9Ov" +
       "fuVA85fvQiMs16ae3tY/s3z0q2/vPN+6r2TjwShMnHLxL8y8Un/xuOaFPAKW" +
       "99bTHsvKo5PKVyf/YvGhz5lfvwo93Ieu66G39YEePaaHfuR4ZtwzAzPWUtPo" +
       "Qw+ZgdGp6vvQAyDPOYF5KBUsKzHTPnTNq4quh9U3EJEFuihF9ADIO4EVnuQj" +
       "LbWrfB5BEPQAeKBHwPM8dPhV7xRaw3bom7Cma4EThLAYh+X8ywUNDA1OzQTk" +
       "DVAbhXCuAaX5gfXt+m3idh1OYh0O4xWsAa2wzUMloPcjD8wE6O820Jkw9rWU" +
       "3/rLo1Lnor/Q0fJy7jd3V66AZXn7ZVDwgD2xoWeY8W39pW27+60v3P7tq6dG" +
       "ciy1FHoeDHl0GPKoGvLodMiji0NCV65UI31vOfRh8cHSuQAEADw+8rz0I4P3" +
       "f/Sd9wGti3bXgNxLUvjeKN05g41+BY460F3o1U/tfnz6QeQqdPUi3JbsgqKH" +
       "y+ZiCZKnYHjrspndrd8bH/mTP/3iJ18MzwzuAn4f48CdLUs7fudlwcahbhoA" +
       "Gc+6f88z2pdu//qLt65C1wA4AEBMNaDAAGuevjzGBXt+4QQby7ncDyZslbL2" +
       "yqoTQHs4teNwd1ZSrfijVf4x6NzvPeffZe2bozL93oOGlIt2aRYV9r5Xin72" +
       "3/zuf8YqcZ/A9I1zG59kpi+cg4aysxsVCDx2pgNybJqA7t9/Svw7n/jGR/5q" +
       "pQCA4rm7DXirTDsAEsASAjH/za9s/u1rf/iZr109U5oU7I3bpefo+WGSfwZ+" +
       "V8Dzf8qnnFxZcDDrxzvH2PLMKbhE5cjfd8YbgBkPGF+pQbeUwA8Nx3K0pWeW" +
       "Gvu/brwL/dJ//djNg054oOREpb7/O3dwVv6X2tCHfvtH//vTVTdX9HKbO5Pf" +
       "GdkBO9981jMVx9q+5CP/8d976u/9pvazAIUB8iVOYVZgBlXygKoFRCpZ1KoU" +
       "vlRXL5N3JOcN4aKtnXNHbusf/9o33zT95j/5VsXtRX/m/LqPtOiFg6qVyTM5" +
       "6P5tl62e1RIb0DVe5f/aTe/Vb4MeVdCjDjbxRIgB6uQXtOSY+v4H/uCf/sZb" +
       "3//V+6CrDPSwF2oGo1UGBz0ENN1MbABYefTD7zto8+5BkNyspgrdMfmDgjxR" +
       "fV0DDD5/b6xhSnfkzFyf+J+Ct/zwf/wfdwihQpm77MKX2qvwKz/zZOeHvl61" +
       "PzP3svXT+Z1IDFy3s7b1z/n/7eo7r//zq9ADKnRTP/YLp5q3LY1IBb5QcuIs" +
       "At/xQv1Fv+awib9wCmdvvww154a9DDRnOwDIl9Rl/uFL2FLhyw+Dp3aMLbXL" +
       "2FLtBo9Wa1yydMSFwNH6qf/08d/56edeA7IZQPdnJd9AJDfPiMqdxIx/4pVP" +
       "PPU9L/3RT1WW/zf++Bdfe/svfaiyv/dV4z9bpbfK5K9UC3wV4EJSebEpmIoT" +
       "aF7F7fPAT08qz3UK/FmwhEqffn1VEGPHB1iWHTtU8IuPv+b+zJ98/uAsXV73" +
       "S8TmR1/6yT87+thLV8+5qM/d4SWeb3NwUytW31TxW1rSs683StWC+eMvvvhr" +
       "v/jiRw5cPX7R4eqC/xOf/9f/+3eOPvVHv3WX/fyaB1bhgPplipUJdbCV5j3t" +
       "6oUDc1cA/N5fPyKOkPJbvvtS3Fdm310mvTJhTxbibWtPv3UCycfLcWvtEVX7" +
       "t6TndeDgk19i8vn/ZyarrzbYLEQN+fu/Wn78yBtj9cmSVSncxrrJaUk6qmDd" +
       "NEpuS4rR/zdn6Y1X2EbSp05+HKpaKqXkk3mGWUmN3jYaeIfqO6zJDqQOQSnj" +
       "2NDW1F4PbNbfNQaC2p8Lqm/WyB5Ie77RJBrjwu43vLFv28NxH5tsUGngTIfs" +
       "zNFmI0WlF/YQVTp+X5qOJURdbWRDGsLtbt5feHiMpT5eH8FcdyPHamxi22CO" +
       "mbXYqtVaWMxi0mDquZ5KI+lAWvcQdNOecos1GfkTlTeaG0nV6nS6D3B8bdWX" +
       "Mlz4xMZQppwx2S9GkqeJHOMjUpPZ1LfhepTL/CLq+0o9QaOZr7uyFE10xHYk" +
       "v4m6uj9EVQz1qOls1m2ZUejs5vFAHnQGXV/wkai1TvlUXQ26XDfaLwVB9zMn" +
       "HyGD7opeDrZLUfFlKh01RYnvz7BZnWw5UcfPpclGaqx9fyP2uou4K9T3ckEz" +
       "mCFs6A3XVVMm3bpcsFASaZNvuxQfj0nMCtp1ok7JU3LkSgaP5O4MQb0BN20Y" +
       "oeB2tWypx9PBBk2jTuaGYbdn6mt1M241Zg3NRrB1MnTjGNEZrF8LZg6x3Mz5" +
       "3OdSKZW663Ej13tM0XW7u6i538s4XdCdeD5yVVRs+16Aa1O0mCASqXfImtgg" +
       "lr7djPp9pBUxvYmZMoY/Wa2Srm9p7bG/rQdRrCSBtozE9WBCNURM8YTJtDfv" +
       "JnOtiMZ52E227Q5hb3aqjq/wiJSR1nzR9ceFXgxk2ioa/qyhFD68WQ83PNXZ" +
       "p4Gz76x8gqSR/mxIUou62qPSVhF5k+00HiOtprhac/sRYegdStmn+2m/vhFM" +
       "bJOOXbPb0+zFNnTXizGxmwfITqPSbsgyhYTH+HTBsNNUEge+tuj4vYGrRe52" +
       "2Nc6m0YjpoaLfERHYu7p7SGCDGZkGgSZMeWWMTqZNT1GGk8asserE4tgd5qk" +
       "hooXawtNY0bNts+vdjzWI1CRcwNnZY/pHT7p5CGbZcOmNpsXdLGPhxSe7da8" +
       "n+H8tLeIajMatgVRFmoGGa84dUNPEQlh1+29HET7Ilqz8qLttHkJwxm2v8dX" +
       "iDWDsw0n7IiJ0Ry6WZQqe2Kj7Rt9S1ZlNB72QpTb97RUUnpdFHOLzSaSM9yk" +
       "zWg1xzuIZje2e01OpHU8iJSNhc5SslVbhatdspI2G5toOupcwpaInbiika7y" +
       "tkTtWtGqpwvdCVwrdMevDTtmNGcG3nrCIDV+oCAWjmiUrjdXDCxLo14Q617S" +
       "jnC/NeSU3Ai8cJEiOzyOElof++Qi6gzHGsX2qMlgx7YKP917PuoPYh33anUx" +
       "1MklbMj6UlVJhO371EzT2LHSY0hiIk1boiKPAkIn03nANnbGdNxg2w1pUt+O" +
       "in43XdQ5rseTey8l90y6lyadARnB/E6rM+SIR32KYqjGYoFn05aZzhlR200b" +
       "gczonXnEImEyDL1hYOeLbT603MTk4yLPidDCx1533FbE0B4Gvh3KyLjnTtwR" +
       "NlOBYJbSShkw+/U60vmOIhN9V96yAA4t2AsEO4dTXe9uqM5GD1xpBFR8wq4J" +
       "LzfUFBOxensHG5mLYUWQrCzOnsR1yt+5dlwf4nZjKu4xJpDCphukxJSVpOmq" +
       "W6Nyt0aTFC/ztEBOVoORwODRxPPCsdAX/GnA9nODb/L+erNrNZZEQMmJ6iYW" +
       "BRt9fbyawEpshigxD4ica2wbgxShEMHhMK6uGJZNtXMjxjNqj1jC1pA0byxa" +
       "rICLBB3vMRNoN6e1wyGh2gKhGRStrliDXvE4YZDJJkJ3zRojznVXYZXCmtKU" +
       "zxcznSA6dGNiik2a3vWZzO5QiFFEIa8lYm+nbkWeYX1g351Q1zBJaG0TRKcb" +
       "XoisW8NkVpBDuFcfJ6ZlWbOBz2wZo9nAAm6Q7+FVZsEjPebWTQoN1Gzg9df9" +
       "ntJtwWzkUbgSmHuwXyqtzdDiV4RMFo1iLUrigs5WQ382cvu43B5uabLPm51g" +
       "PlH3mIMM1l6dlZeZ1xJZZ2T1PUFKCQLJsjVKwDDaC4Sl3JbJdNuaFP2m3dYH" +
       "w5y21CYB9xBjSff2QX1E0x5Nh/FASsbTdYI4Qpy1JJddu1wdXrbTNed2+YXW" +
       "RWiRjh1pjKJTshaLQZ1QTW7fmXBpP9Mirik1B2xhS20cF2KFpaTWtqFtgtWC" +
       "WM18R9vS6HDVn8rNtj7nt9IgHvWalDtpiTWjJ7GNfS2P0fGWx3Bztteniw4v" +
       "tufYOpsRAwIm8AQWMCZZU5mvIx7ob22hQT1TYA+FazFNde2CcZyxGlpei1z2" +
       "iAibmrVx0yLI7qDwm0VnN+KpYQMzaj2b4Gvr2JjBTjTUxLTvCvUgM92AbyjB" +
       "doXKoh7wttRH6AbZQ2RzHLJzvxG0m71RWqsvJLqg7AJxJzHRQHiTz3up2VZI" +
       "Mt9nfm7VBZtIBkB/+8g2tykcxzsojGUZmbZSYTXDZ64W2ng7VZDteLLQOi7u" +
       "out2XRvVYbjJGcVujsEx7Iky21q3xzPKwzCyvtzDPdUmMHvvUC45kw1Kc4aD" +
       "jVsPvN52maDerKtIzpBTa3Dc13RWQOG5JStwShPYLtykfMvIEk2KVIrZ2XhO" +
       "kpvebISmtZnM71M1iZkocYbDGmqGREsVpsvhmAjTieOghD9sjeeWamrA1aKQ" +
       "hTyy5Dqp4js0Z3h4ZvXiApuRFmPvGVGedmXRSjLYX9eHGNE2OkN/00v7PYAT" +
       "OYOOGw7RIbN05xtIZs3HqWNtMUJd6ryiF/32fNxnsBprwdYar+O1TGQUfzf0" +
       "5ju/yMmJyAXZfpYsJUZuLYA2xGwrikAnNJ0NYgWXDV8KW1gUAkOecV4tgDct" +
       "PZkURldvrnv+aCIsNNsWsmSJ6H6dsBcTjNmNGltio0wIBnfajR4hRHlWKwrZ" +
       "xlZdRq6vp92g683zHQoTk9YgJhjgzdQ4oU1JcZwH+yntgQ0ZHXs86i5ENm30" +
       "zZWNmEpQeJKe9dDNuM4IjpTx3KCbFw6WboQuH6QBitaDOLYL3aSIQWOl2DWd" +
       "58SUKlrpDmVIH5vM3XTY6GQhtRDkbdg3Xa0laUyINoY1pB12My3YcewiSder" +
       "kRk158VI6+Ebo+cuh/WCn4wH225TyJoAR1YjC/fb6jRLao6EFBHSxQp1boUz" +
       "ztQVOSH4zXrgS6rfq3fAHySkKfodb+u37Q3FEYtpr7BbvCH5I1uuEc6m6GTr" +
       "salJ+SI1OVcQDLeDerILpBpSmZdxc83DA0N2EHrQJNgBZhgmseHWChoNd8PC" +
       "1RnYzveqNWMG8y5HrYzA8F0Wx/w1NWQnBGG2tmwdIcZ1c2ooG8beTVbiwgF/" +
       "QmuCWRODeRzk4kql4f4mavfFgOLFnbEFu//W3LURAUXs9XyFzkNeMki2MJWx" +
       "CKuOjGqTuTqTFcGcwmQtwrt0XRKQFd3HeTmHa0lKdAY+GXurGjVO8pq6NMLJ" +
       "jqyRsasYO3u08PcTBWfh/tCbhcBNbstxYHTYgEBH034buAVbHsd0hjNHTjDV" +
       "MUfFM3baYYf8Ilza64aNU8hMxLfIaJH2k328i/3abFFb1qzEG3oU4SCFYZN1" +
       "rMEjkqLV7Lbt7QVy3m6NZxm2mNt5TAp6f0D7vaLT4LCkN9nk88lc0MaxNibj" +
       "LFtGC0rpISMBqC5ZM5q7kF8qo0RcDJNlpxXiqyafRiTBsfs6tw8pRikEBVXG" +
       "RDfzBzTscOMFQo5WMl1rFxI/7ieDkbnkWVuDWVGc18i2EDNNktnr850oEGFT" +
       "7O6bDtq3OpQ8UvbGDiygBhS0hTEe6hTrNVmbtpKOpYfDdV3cd1zd9fm5JNtL" +
       "ME4Cy3izYfl4d7CzklbccwIm26P9IUHjY4Pt1bfBmiEws8FuiWiKUq1xx1f3" +
       "m9oq2c4JWBv1vF7D7COOOOCiYTfoDbxZLQ0nSNHECtyFOX/ZYjbUXqQyQYRh" +
       "oEjYSOJQtr1bhULQlNxduzbuc4aYr/H2UBh1MR3PlFlo0Ykk94pCjdakPlvu" +
       "cH2QrhR6BANlTcihXhMSdh+Lk6mWZiKLqZbZn8lTzXMnjK5Oiq7MMnOPJBNu" +
       "v8f9OJ219BBX9zo5p61loTXoFLNrWAwQpZPte81WFM4Sb1Og8BaWhztpKmbL" +
       "TlBbyW6nnfYn/cEi0Xo7KzZ5dii1ejnHaDYQUebwU8Rq+flWtCx7Ew28+R6Z" +
       "KJNC5AplPajhjaav7xa5h06U1OA3m3YjpDV4ztnNDaHN9i7vh6y0IVKjmK0b" +
       "bX9BC8N6t5nT8zUwPRJ2UDOhOWnm2T3GazTRZtYc0bN5o7ZpFKI95qJGQYtk" +
       "iNZzAEvophfsdp65ymnBMpPFYKkOPZsURZwHfhS8U1y83iewCQL+nL/3veXf" +
       "duONhQ4eq6Icp8eQxxGDxRuIGByqni2Td10M5F+/fHR1Lth2LtgJlUGkp+51" +
       "ulgFkD7z4ZdeNoTPolePg8RCCj2UhtEPeGZmepfipu+5d7BsVB2ungUvf/PD" +
       "/+VJ+Yfs97+B45l3XOLzcpe/NHrlt3rfp//tq9B9p6HMO459LzZ64WIA8+HY" +
       "TLdxIF8IYz51MYz5BHjwY8nidz8iuasWXKm04LD2l2LwV44PuY6jW0+dP0Yr" +
       "jyWP5iJIj8/cqx6K1+/h3dWJ3lHue0dprAVJeRh0JJ/kzLib62ZUSrvq7MfK" +
       "ZJtCD5i5qW9T86SXZ+7gI6wCxcnR/BAxPlPS7DuFtc5H26uC+FSqD5WFFHg+" +
       "fSzVT393pHrfmfF9oDIsoKDvureCVocoh+Dsy//gud/94MvP/YfqHOJBJ5lq" +
       "MRWv7nIOf67NN1957eu/96anvlCd211baslBgy5fYLjzfsKFawfVRB65KJob" +
       "4Pm5Y9FU7xQyv1vnwr4Hx8Ao5iOuG8dhXF7FKCOZyckB9F/MQPld4rrnNOyy" +
       "glch0o/nV6BKPT55jyj/Keie4u11zwxWqV1RDs5BK59C94FlKbM/HeWnQ149" +
       "9HPC25vPeOt4YWCWR3cndYdjbCc8Or36AirzuzIfH5ivBiuT517nPO6zr1P3" +
       "C2Xy8yl0v14yc+D9dcg/lx/ef+vuwFF+frAieKVMPpJC13ZaHNxNVNey0DHO" +
       "LP+jf17LL3enzx+r9+e/q3hafn66Ivjy68MldgfQWdvgcFJ7NIvDYHU4aAIY" +
       "kFxEzl8rk19JoRugpe6eUZXFXziT0Zf+HDIq76BA7wbPl49l9OU3IiOwV0dx" +
       "mAJLMo27iuq8jnzl3mL8xxXBvyyTf5ZCb4nNKAQ+4EXRXJr0b7yRSecp9OjF" +
       "GyLlEfcTd1xOO1yo0r/w8o0H3/ay8vsHsD259PQQBz1obT3v/Inkufz1KDYt" +
       "p5rIQ4fzyah6fTWFnrz3xZXS2znJV2z/q0OrrwG0utwKWGP1Pk/3+yn08Bkd" +
       "AKFD5jzJHwD8ASRl9t9Fp1v46+gkc5zDSrHnVy76c6cL8Ph3WoBzLuBzF/bF" +
       "6urgiZO1PVwevK1/8eUB/4FvNT97uOGhe1pRlL08CLaww2WTU0ft2Xv2dtLX" +
       "dfb5bz/6yw+968SpfPTA8Jkqn+PtHXe/QtH1o7S69FD86tt+5Qd/4eU/rM5/" +
       "/y8B/nj70ykAAA==");
}
