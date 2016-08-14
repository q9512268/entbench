package org.apache.batik.css.parser;
public class DefaultBeginHyphenAttributeCondition extends org.apache.batik.css.parser.DefaultAttributeCondition {
    public DefaultBeginHyphenAttributeCondition(java.lang.String localName,
                                                java.lang.String namespaceURI,
                                                boolean specified,
                                                java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public java.lang.String toString() { return "[" + getLocalName(
                                                        ) + "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wcRxkfn99v+/JsHnbsOEF53TaQVFROS2zHTpyeHStO" +
                                                              "I+GQXOb25u423tvd7M7aZxdDE6mKCyJEIW1D1foPcNWC2qZCVICgVVAl2qoF" +
                                                              "qSWiFNQUCSTCI6IRUvkjQPlmZm9fd3YShMRJO7c388033/P3fXPPX0eVlona" +
                                                              "iEZjdMogVqxfoyPYtEiqT8WWdQjmEvIT5fjvx64N3xtBVWOoKYutIRlbZEAh" +
                                                              "asoaQ2sVzaJYk4k1TEiK7RgxiUXMCUwVXRtDyxRrMGeoiqzQIT1FGMFhbMZR" +
                                                              "K6bUVJI2JYMOA4rWxkESiUsi9YSXu+OoQdaNKY98pY+8z7fCKHPeWRZFLfET" +
                                                              "eAJLNlVUKa5YtDtvoi2Grk5lVJ3GSJ7GTqg7HRPsj+8sMkHnS80f3zyXbeEm" +
                                                              "WII1TadcPesgsXR1gqTiqNmb7VdJzjqJvoTK46jeR0xRV7xwqASHSnBoQVuP" +
                                                              "CqRvJJqd69O5OrTAqcqQmUAUdQSZGNjEOYfNCJcZONRQR3e+GbRd52ortCxS" +
                                                              "8bEt0oUnjrV8rxw1j6FmRRtl4sggBIVDxsCgJJckptWTSpHUGGrVwNmjxFSw" +
                                                              "qkw7no5aSkbD1Ab3F8zCJm2DmPxMz1bgR9DNtGWqm656aR5Qzq/KtIozoOty" +
                                                              "T1eh4QCbBwXrFBDMTGOIO2dLxbiipShqD+9wdex6AAhga3WO0KzuHlWhYZhA" +
                                                              "UREiKtYy0iiEnpYB0kodAtCkaNWCTJmtDSyP4wxJsIgM0Y2IJaCq5YZgWyha" +
                                                              "FibjnMBLq0Je8vnn+vCusw9p+7QIKgOZU0RWmfz1sKkttOkgSROTQB6IjQ2b" +
                                                              "44/j5a/MRhAC4mUhYkHzgy/e2L217fIbgmZ1CZoDyRNEpgl5Ptn0zpq+TfeW" +
                                                              "MzFqDN1SmPMDmvMsG3FWuvMGIMxylyNbjBUWLx/82ecf/i75SwTVDaIqWVft" +
                                                              "HMRRq6znDEUl5l6iERNTkhpEtURL9fH1QVQN73FFI2L2QDptETqIKlQ+VaXz" +
                                                              "32CiNLBgJqqDd0VL64V3A9Msf88bCKFqeFADPGuQ+PBviiwpq+eIhGWsKZou" +
                                                              "jZg609+SAHGSYNuslISoH5cs3TYhBCXdzEgY4iBLnAXZslhmAhBKe0ga2yrt" +
                                                              "JRlF2zdlZInmYhukV4pbIsaCz/j/HJtn1lgyWVYGjloThgkVMmyfrqaImZAv" +
                                                              "2L39N15MvCVCkKWNY0eKdoMkMSFJjEsSA0liQpLY7UiCysq4AEuZRCJKwMfj" +
                                                              "gBYA1w2bRo/uPz7bWQ7haUxWgIMYaWegbPV5kFKoAwn5UrRxuuPq9tciqCKO" +
                                                              "olimNlZZFeoxM4Bv8rgDAQ1JKGheXVnnqyusIJq6TFIAawvVF4dLjT5BTDZP" +
                                                              "0VIfh0LVY/ktLVxzSsqPLl+cPHX4y3dHUCRYStiRlYCCbPsIKwAu0HeFIaQU" +
                                                              "3+Yz1z6+9PiM7oFJoDYVSmrRTqZDZzhEwuZJyJvX4ZcTr8x0cbPXAthTDMkJ" +
                                                              "ONoWPiOAVd0F3Ge61IDCad3MYZUtFWxcR7OmPunN8Nht5e9LISzqWfJK8HQ6" +
                                                              "2cy/2epyg40rRKyzOAtpwevKfaPG07/+xZ8+w81dKEHNvt5hlNBuH+wxZlEO" +
                                                              "cK1e2B4yCQG6Dy6OfOOx62eO8JgFivWlDuxiYx/AHbgQzPzIGyff//Dq/JWI" +
                                                              "F+cU6r6dhPYp7yrJ5lHdIkrCaRs9eQA2VcAQFjVdD2oQn0pawUmVsMT6Z/OG" +
                                                              "7S//9WyLiAMVZgphtPXWDLz5u3rRw28d+0cbZ1Mms7Lt2cwjE7Vgice5xzTx" +
                                                              "FJMjf+rdtd98HT8NVQWQ3FKmCQfnCm6DCq75Suji+E5WoWOiQrP5e4JIwLJt" +
                                                              "1E5akLVKDpw04VTBT48cl2e7Rv4gKtxdJTYIumXPSV87/N6Jt3kI1DBcYPPs" +
                                                              "oEZf1gN++OKvRbjmE/iUwfNv9jCXsAlRTaJ9Tklb59Y0w8iD5JsWaUKDCkgz" +
                                                              "0Q/Hn7r2glAgXPNDxGT2wlc+iZ29IPwqGqP1Rb2Jf49ojoQ6bOhm0nUsdgrf" +
                                                              "MfDHSzM/fm7mjJAqGizz/dDFvvCrf70du/i7N0vUjOqkrqsECzDbwYLdhfal" +
                                                              "Qf8IpfY82vyTc9HyAUCVQVRja8pJmwym/Fyht7PspM9hXtPFJ/zqMedQVLYZ" +
                                                              "/MDDiI87uSx3uxIhLhHia/vZsMHyI2zQZ74ePiGfu/JR4+GPXr3B9Q5eAvyA" +
                                                              "MoQNYfRWNmxkRl8RroD7sJUFuh2Xh7/Qol6+CRzHgKMM9d86YEJhzgfgx6Gu" +
                                                              "rP7NT19bfvydchQZQHWqjlMDmCM5qgUIJVYWanre+NxugSCTNTC0cFVRkfJF" +
                                                              "EyyL20vjQ3/OoDyjp3+44vu7np27yqHMEDxW+xl+ig1bXFDjn6pwH+YHtQAH" +
                                                              "E61dqFXmcTl/+sJc6sAz2yOO83op6K0b21QyQVQfqwjjFOgjhvjlwKtlHzSd" +
                                                              "//2PujK9d9JCsLm2WzQJ7Hc7uG7zwggQFuX1039edej+7PE76AbaQ1YKs/zO" +
                                                              "0PNv7t0on4/wm5BoBIpuUMFN3cGMqzMJXPm0YI6td/3ayvzVAc82x6/bSlfk" +
                                                              "EiHh1rmFti6SrOlF1nj3j6GcZAh1+0+3pfisg37s6z7few9FlZA1Jg3DFfu5" +
                                                              "V9A8wIakeB/+L3OLTRwy+PxR1xRRtrYKnh2OKXbcuRUX2rqIpfKLrE2zAdCs" +
                                                              "hur+Yuyagf4vzJCHtvR2bg8MkVYW/cMhbuXyi3PNNSvmHnyPZ7B7c26AXEzb" +
                                                              "quoLZX9YVxkmSStc0wYB0KJOnKZo9SJ3Hdau8Reu0Smx5xG4EJTaQ1E5jH7K" +
                                                              "WYjKMCXEHf/2032VojqPDg4VL36Ss8AdSNjr141CB7XzNq5pxdbNlxXDN/fx" +
                                                              "slv52IfX6wM4x/+0KmCSLf62guva3P7hh27c84zov2UVT/Moq4e6Lq4CLq51" +
                                                              "LMitwKtq36abTS/VbihUgFYhsJcnq33BfAjy2GBBtCrUnFpdbo/6/vyuV38+" +
                                                              "W/Uu1N8jqAzwY8kR319G4v8R6HBtKChH4sX9C9QA3jV3b3py6v6t6b/9lldG" +
                                                              "JPqdNQvTJ+Qrzx795fmV89Bd1w+iSihuJD+G6hRrz5R2kMgT5hhqVKz+PIgI" +
                                                              "XBSsBpqjJhbvmOUnt4tjzkZ3lt3eKOos7g2L77zQRUwSs1e3tZTTXtV7M4F/" +
                                                              "0wqlwTaM0AZvxtc/DwiYZd6AoE3Ehwyj0DpXtxscCvaWRl02fou/suHb/wH/" +
                                                              "j9Uq0BYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZecwsWVWv9828ZR7DvDcDDOMw+zzQmYavuquX6s4AUl3d" +
       "1V3VXd3VVdXVi8qb2peufemuLhwFEhyUOKIOiwrzF0Qlw6KBaGIwY4wCgZhg" +
       "iFsiEGMiiiTMH6IRFW9Vv299bx5LTOykbt+699xzzzn33N+5de7z34LORiFU" +
       "8j17q9tevK+m8b5l1/fjra9G+9SwzohhpCq4LUYRD9quyo986tJ3vvte4/Ie" +
       "dG4JvUJ0XS8WY9NzI1aNPHutKkPo0lFr11adKIYuDy1xLcJJbNrw0IziJ4bQ" +
       "y44NjaErwwMRYCACDESACxFg7IgKDHq56iYOno8Q3TgKoJ+Dzgyhc76cixdD" +
       "D59k4ouh6FxjwxQaAA4X8ncBKFUMTkPooUPddzpfp/D7SvCzH3jr5d+/Bbq0" +
       "hC6ZLpeLIwMhYjDJErrdUR1JDSNMUVRlCd3pqqrCqaEp2mZWyL2E7opM3RXj" +
       "JFQPjZQ3Jr4aFnMeWe52OdctTOTYCw/V00zVVg7ezmq2qANd7z7SdachkbcD" +
       "BS+aQLBQE2X1YMitK9NVYujB0yMOdbwyAARg6HlHjQ3vcKpbXRE0QHft1s4W" +
       "XR3m4tB0dUB61kvALDF070syzW3ti/JK1NWrMXTPaTpm1wWobisMkQ+JoVed" +
       "Jis4gVW699QqHVufb43e+Mzb3L67V8isqLKdy38BDHrg1CBW1dRQdWV1N/D2" +
       "x4fvF+/+7Lv3IAgQv+oU8Y7mD372xbe8/oEXPr+jec0NaMaSpcrxVfkj0h1f" +
       "vg9/rHVLLsYF34vMfPFPaF64P3Ot54nUBzvv7kOOeef+QecL7J8v3v4x9Zt7" +
       "0EUSOid7duIAP7pT9hzftNWwp7pqKMaqQkK3qa6CF/0kdB7Uh6ar7lrHmhap" +
       "MQndahdN57ziHZhIAyxyE50HddPVvIO6L8ZGUU99CILOgwe6HTz3Qbtf8R9D" +
       "EWx4jgqLsuiargczoZfrH8GqG0vAtgYsAa9fwZGXhMAFYS/UYRH4gaFe65Cj" +
       "KN+ZkRrCHVUTEztuq7rp9re+obpYDBxMAq4FtpdSWGI/dz7//2faNLfG5c2Z" +
       "M2Ch7jsNEzbYYX3PVtTwqvxs0u6++ImrX9w73DbX7BhDbwGS7O8k2S8k2QeS" +
       "7O8k2f9BJIHOnCkEeGUu0c5LwBqvAFoAHL39Me5nqCff/cgtwD39za1ggXJS" +
       "+KXhHD/CF7JAURk4OfTCBzfvEH6+vAftncTlXAvQdDEfzuRoeoiaV07vxxvx" +
       "vfT0N77zyfc/5R3tzBNAfw0wrh+Zb/hHTts79GRVARB6xP7xh8TPXP3sU1f2" +
       "oFsBigDkjEXg6QCUHjg9x4mN/8QBiOa6nAUKa17oiHbedYB8F2Mj9DZHLYUj" +
       "3FHU7wQ2flm+E2DwPHJtaxT/ee8r/Lx85c5x8kU7pUUB0m/i/A//zV/8c7Uw" +
       "9wGeXzoWITk1fuIYhuTMLhVoceeRD/ChqgK6v/8g8+vv+9bTP1U4AKB49EYT" +
       "XslLHGAHWEJg5nd9Pvjbr331I1/ZO3KaGATRRLJNOT1UMm+HLt5ESTDb647k" +
       "ARhkgw2Ze82Vqet4iqmZomSruZf+16XXVj7zr89c3vmBDVoO3Oj135/BUfuP" +
       "taG3f/Gt//5AweaMnMfAI5sdke2A9RVHnLEwFLe5HOk7/vL+3/ic+GEA0QAW" +
       "IzNTC6S7tbDBrYXmrwJnlWJkHu72d+Euby8Dlo/d5JQUmg5Yq/W1yAI/ddfX" +
       "Vh/6xsd3UeN0GDpFrL772V/63v4zz+4di9WPXhcuj4/ZxevCyV6+W6/vgd8Z" +
       "8PxP/uTrlDfs8Pou/FrQeOgwavh+CtR5+GZiFVMQ//TJp/7od556eqfGXSdD" +
       "VRecxD7+V//9pf0Pfv0LN8C985Ln2apYOG+5EBUuRH28KPdz2QqzQ0Xfm/Li" +
       "weg4rpy08bFj4FX5vV/59suFb//xi8W0J8+Rx7cRLfo7I92RFw/lOr/6NIj2" +
       "xcgAdLUXRj992X7hu4DjEnCUQQiJxiHA9vTEprtGffb83/3Jn9795JdvgfYI" +
       "6KLtiQohFvgF3QaAQ40MEBZS/yffsts3mwuguFyoCl2n/G6/3VO83XJzHyPy" +
       "Y+AR+t3zn2Nbeuc//Md1RihA+wZud2r8En7+Q/fib/5mMf4IPfPRD6TXxztw" +
       "ZD4ai3zM+be9R8792R50fgldlq+dxwXRTnJMWoIzaHRwSAdn9hP9J8+Tu8PT" +
       "E4fR4b7Tfn9s2tO4feRvoJ5T5/WLRwveSM8AXDuL7KP75fx9UAx8uCiv5MWP" +
       "76yeV38CAGBUnOvBCM10Rbvg04iBx9jylYMtJIBzPjDxFctGC7/ewXxevnk3" +
       "Y1HHXnLliQO5wErfcQQzQw+cqd/zj+/90q88+jWwHBR0dp2bCqzCMSwaJfln" +
       "xi88/777X/bs199TYDcAbuEXfw/9es6Vv5l2eTHOC+ZArXtztbjisDQUo5gu" +
       "4FZVcs0KFsgxfZoxAG1vh4M/krbx7Z/u1yISO/jRwkJFNjKbrjS31VqXYCrq" +
       "u1I07hL1Ki9OBIIdc0jW5/2t2ufiMVnqTeZjCaknNaQarxWURsVlqnS6DWeA" +
       "b6kuOat0KprHyKMZjgRLXCBxXRAwGwk8IuBmJjGaTHGOx8kGyU7XK2vC2M7S" +
       "aWlKdcEZNEuNUbnabJarVZipanOGmZdVAegrmt2lpdCeLgSp5m2ZRdw1A745" +
       "mykTy+muSb6uWeu0URtV07gtzMbeYJHEJGtLyy5miJEnTpBIyERqsaqtKnzX" +
       "HKCsnprTOY1PN8KcjTvblA3pnuqZQTYh+QrRowlDopfsoCFNBYpEqAU9xmrh" +
       "LF11OXMama0FN09KY2+iiKPBotX0F6Vmhmr4oM+oM3ZJDLUur2LUcGQL04FY" +
       "X8SdeO2ZSC9c1W2BqvY4Cu3xgY72WSaySs2IXvVdrlnWqtl2LqldZ0aSFV5U" +
       "ZEaN9GjOVvSAN4ORI6GCQmVWQK09flBrWCpbTlkBTTcBxvU5t+1NhITBA3ZN" +
       "UYHSaI3r45DHAjmYOFNsqky4ZW9kdccLbYRT8nI8YidsVS31JFapI14Y4ynX" +
       "lLpx2Zu6Vig0w3RTsRqEw7KxXYt0vU0KnTTCdYqSV3484zm/P+31QmEzcqyU" +
       "4DbBaoO6Xl3kVlKngklVopnhlIN0HCals4qks63OKO7NAqdRb4hsfZIF8CAm" +
       "vcwbx1u+ohq1CS61N/OQaHdovjcmx4gyTCXT9Dkj6JRaG0VNGxhm6GJ1Ni4P" +
       "sqRvz4zF0sCmLFjQeLEtm2bX9Rft8spTsBhficAHecqJO9yWqW1SKiJ1urxA" +
       "SErEg/piqc+2hkiYkuXS7WFQptTm2nVLazyJNi2/hE7IgT5eTsvszNGySjRY" +
       "xfF4pXPsmJ+0G6Q1QaRaDbbqIkyzBobXnKmxWPUzfQuryBCpoBop6c6ygi+9" +
       "zpYddX3drjOxW878oMRr6ozOiKAzqnAOQ3ecNR31qsQsWdM9kk639nYkWe3p" +
       "bJjCTUSVNdhE69yGFzoiGcwELe7TLBs0MrfTndp1u2F22RG/MvxuPGWHLa1f" +
       "mQiTEVolCBIIMun4cZcPyIE9KQniPKsiuDkatnUqCDpKWRg2akIVa9GR1mxK" +
       "+IAIVALrML1kUmLaa9PcAGlV0ujNosHSS6yl3ii3ShzW73GLURLZJOf163JU" +
       "5RdGG58rWVdf1Mz20MXmy8g2HMxoD9SyLiLbMKZYm0AyxV6SrrMwkpVQ8yUy" +
       "EvEMtuA+FbsVW9/OhEXPsj3e0FcC7Wy1MBBJZ4mtkWG1NarU6TUu4KvBbLQo" +
       "qwPFo1c0R1BWN+Kwsm1O/OECnZr4NgpqWDdZsjg12NCapbcXWGWDSKwHJ0yG" +
       "SrMJaojTdKaT9EKcqbrECPUVMfCwjVufhmyaJEzQimUzwAdjzzadkb1cEqqX" +
       "0rX2uhnqHWxSoQY9Q50Lrhtsk4ikggZPkJi4WQtETRlafL3Nd5ZMWSA1ozwU" +
       "FvAqHgppxkUBM7RLMtOf17ZVpT/F2QUXm6y9wHGJicjBBkvKfZUgxcm0Wlpk" +
       "laxRajEmjXoE5XUWAueELB8sO8vM6G6SJbWl1vPaUubDZlqWJWaOxQbfoVfU" +
       "eOTNGHOMCUqZqPbURoXs4KJSpRfLaUzMUplFxw6TuKPmyIjramtIclkw06hB" +
       "sz9pIPIWRlR/q9fKITvYZmMs9jfqeqCJTK+MwqV02SxtmhVl0O2P1nHdsEft" +
       "pF/apEu7O5YHFRVp17b4pNfobBtjbTxOG4g6blI6Ya5ndidJzUUKY31Jn2RM" +
       "Rva2mgbDnQCmZiRRkqeNsKEYzMJHtyFVt/sKuQpxkY1a6gRDBBmbEJagdBBv" +
       "4pZ9cTN1hIjmG0t43EM5GG7NwBcFCGRL3TdiZj7rDLN6Ug3ZDdJUSsA6ywrt" +
       "ROgwRuSN1UUF3ZTVeprxKUHRllYKlVhpNft8cyRMZpMqMXDwiebiTqODB2Df" +
       "JZZZ6tZn3mxsTkKmrtYocjOk4kq3Lq6GwqDjb8o1gW/ztaZsIyrKrmv6IE4V" +
       "il+QiTNnOKGJwqMGFVdXZKXTlhcME3ndpVbRR6XSeLBmJRC/YHO60UbrloXP" +
       "I8xmeZFq8StbqrcW5U3T7NSpaCZOBx18pWflCdx30RDRbUyfM6NO2uORjS2X" +
       "zCXSIplN0AuYCishlFZreZY3aUhjwym700jRQ43WOn0uo2HNQR2LwoKemWWw" +
       "0iHWazzU0LKSAKAZlddTaxyswiDq4llH2iyGiqGJ9kRrkr62aCLrLS+3+lts" +
       "igsTgbXEpk85m60DE1sjRpnIp1vGPGYICs4CWlUmwnCxhOlOxySbaMKl1SQl" +
       "jaHRN0V4vYzo/pZEsskSramM2dMSmGJrpR4zD6vt1qSuYustRnuT0UJjZyMn" +
       "XbF2kw29DhpRUyIxkLmBwhPPbpRwNuvrA5puKc3GoksZma7paaOXhAw64ist" +
       "SVtvFdmYLCf9WWDZAG9xuh7oU5ISFjPRDdXSKE10DudHPF6WCYFdaRTR3W6H" +
       "SHltTarwGCC45VdLtdo6QV0fQbdBn+520lkptUumXpHmRMdyG/6mX1r04wnW" +
       "7zYqSkDMHZm34VJEyY0Iy5DteNysen5jUJaQymQLMFoLNpZFjHXLWFv2ZhDb" +
       "/YxTYBhhEmvQUloUHg0dZJZNKLQvo0kPzTa6PiGSeaVcbamKapVQpos2MEmc" +
       "VBaDCM7GZWa0RkH0dmvwxqm3vTbpJ1OaGFXlHh1kNDVnnPKCbMQKXBW360zA" +
       "5CaSNmCJs7VV1+wbldAhYrPBhWObqLhW1Wr05CVmVErlUtXXzEivolEDHHLU" +
       "TYuwl1iF0qsdQkvqQgtrbkhxpbbh0rA6HvLsZltiUraSgpNDuBi4BjIezCU5" +
       "YadzJAyAHw2GYRfJMAWPjCQsLZKtqGu1dUbh/XjNIpLepFdgbWCZNqRkvjWr" +
       "zGjErZ2+u2WWaBuVkQY272ZSkHjD5by1ENKVw3GxXN6A2D+gxi4IVi2OqvYV" +
       "MWmyalLmnLSe9mpdChxowca1+uhgtrAGND7v9jUYKVcRwbMCpqPXhGG1wUVN" +
       "TOFGVlipVfA2Os9GQd1PFWlkp/POCNbSyF7XEVKbNzZ0LYVLZYAY3FBrIHqy" +
       "FqsMahgIKjdrmbdGpgIP015QUxvDoIYPg3plSJsxWOug2hAlnoMFyTSmOrEw" +
       "gJu4QbXa1jBri/Ta7RgPpy7hK5IHN+D1NhGqzdIMniaVUdMKsGyzaK7YaqXV" +
       "q62bbKPfjge4AY718xbemmBVS6hKVX/bWDfihgS3bFvpUUygjCZrnipNwixF" +
       "W3XNEZqttlLZlEzONBKqU+o1DDbM6iyyonW+bhiBMMhKDKmT8zYXtf3Aogxp" +
       "7YynblyLrWy1rNpxVQVRMkJ1ZIii2YSdbrioolbjJc/PYwGlawRc3gT2hhfp" +
       "MrZcp7EMdzbmYqk0MK9b7RqbrVXu+PM4jWR8Lc5Yu4xoXgJHSV+CN33Yak2D" +
       "MojfGPamIifx5A/3WXVn8bV4eK/yI3wn7roezovXHubiit+507n447m4oywC" +
       "lOc57n+p65Iir/ORdz77nDL+aGXvWvalFUO3xZ7/Bltdq/YxVnuA0+MvnZCg" +
       "i9uio6zA5975L/fybzae/CHSyA+ekvM0y9+ln/9C73Xyr+1BtxzmCK67xzo5" +
       "6ImTmYGLoRonocufyA/cf2jZwroPg+cN1yz7hhuncm/oBWcKL9it/U2SW+ub" +
       "9BVFEEOXdTU+TPkfJp5PfYWfjQzwxXTkR+H3+wI/PlvR4B4qflfeeC94atcU" +
       "r/3fK/6um/Q9nRdvj6ELsXc8y3qo2zt+GN3SGLryg9yl5Inhe667793dUcqf" +
       "eO7ShVc/N/3r4jrh8B7xtiF0QUts+3iy6Vj9nB+qmllodNsu9eQXf8/E0Gtu" +
       "cvOT59uLSqHKL+/G/GoMvfJGY2LoFlAep3wWOMxpSuAexf9xug/E0MUjOjDp" +
       "rnKc5DcBd0CSV3/LP0iB13+AS6vrrZueOQlDh2t51/dby2PI9egJvCmu8A+w" +
       "Idld4l+VP/kcNXrbi42P7i5QZFvMspzLhSF0fneXc4gvD78ktwNe5/qPffeO" +
       "T9322gMsvGMn8JHzH5PtwRvfVnQdPy7uF7I/fPWn3/jbz321SM79L71g90pb" +
       "IQAA");
}
