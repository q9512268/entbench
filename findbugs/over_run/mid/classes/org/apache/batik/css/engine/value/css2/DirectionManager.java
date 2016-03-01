package org.apache.batik.css.engine.value.css2;
public class DirectionManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_LTR_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          LTR_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_RTL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          RTL_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return false; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_DIRECTION_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 LTR_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public DirectionManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVZe3BU1Rk/u3mHQB6QQAMEEgLy3C2gUiaUAuGRxQ1JCeI0" +
                                                              "tCxn755NLrl77+Xes8kSpQqdFupMqSPBYhX+KfTBoDitTh07UuxDcawyUNui" +
                                                              "TLHqH9oqM/KHxpa29jvn3N372EeaoTPdmXv27jnfd873+J3v+87ZM9dRiWmg" +
                                                              "Fh2rMRyge3ViBrrZezc2TBJrV7BpboPeiPTg20fuH/19xX4/Ku1Fk/qx2Slh" +
                                                              "k2yUiRIze9FMWTUpViVibiEkxji6DWISYxBTWVN7Ub1shhK6Iksy7dRihBFs" +
                                                              "x0YY1WJKDTmapCRkTUDRrDCXJsilCa71ErSFUZWk6XtthkYXQ7tjjNEm7PVM" +
                                                              "imrCu/EgDiaprATDsknbUgZapGvK3j5FowGSooHdyh2WITaH78gyQ8tT1Z/c" +
                                                              "fKi/hpthMlZVjXIVza3E1JRBEgujart3g0IS5h70dVQURhMcxBS1htOLBmHR" +
                                                              "ICya1temAuknEjWZaNe4OjQ9U6kuMYEoanZPomMDJ6xpurnMMEM5tXTnzKDt" +
                                                              "7Iy2aXd7VDy6KDjyvZ01Py1C1b2oWlZ7mDgSCEFhkV4wKElEiWGujcVIrBfV" +
                                                              "quDwHmLIWJGHLW/XmXKfimkSIJA2C+tM6sTga9q2Ak+CbkZSopqRUS/OQWX9" +
                                                              "KokruA90bbB1FRpuZP2gYKUMghlxDNizWIoHZDXGceTmyOjYehcQAGtZgtB+" +
                                                              "LbNUsYqhA9UJiChY7Qv2APjUPiAt0QCCBsdankmZrXUsDeA+EqFompeuWwwB" +
                                                              "VQU3BGOhqN5LxmcCLzV6vOTwz/Utqw7fq3aofuQDmWNEUpj8E4CpycO0lcSJ" +
                                                              "QWAfCMaqheFHcMPzh/wIAXG9h1jQ/Py+G2sWN52/IGim56Dpiu4mEo1IJ6OT" +
                                                              "Ls1oX7CyiIlRrmumzJzv0pzvsm5rpC2lQ6RpyMzIBgPpwfNbX/zKA6fJB35U" +
                                                              "GUKlkqYkE4CjWklL6LJCjE1EJQamJBZCFUSNtfPxECqD97CsEtHbFY+bhIZQ" +
                                                              "scK7SjX+G0wUhymYiSrhXVbjWvpdx7Sfv6d0hFAZPKgKnjlIfPg3Ralgv5Yg" +
                                                              "QSxhVVa1YLehMf2ZQ3nMISa8x2BU14JRwP/AkqWBFUFTSxoAyKBm9AUxoKKf" +
                                                              "iMGgZJpBovaBhMFBrCQJ61gWXC8bMCfYoROrABIjwBCo/x/XTjG7TB7y+cBl" +
                                                              "M7wBQ4G91qEpMWJEpJHkug03noy8IsDINpBlUYpWgAABIUCACxCA9QJCgAAX" +
                                                              "gHUsC3gFQD4fX3cKE0TABJw8AOEC4nXVgp6vbd51qKUI8KkPFYOHGOm8rPzV" +
                                                              "bseVdDKISGcubR29+GrlaT/yQ+iJQv6yk0irK4mIHGhoEolBFMuXTtIhNZg/" +
                                                              "geSUA50/NrR/+/2f53I48wKbsARCGmPvZtE8s0SrNx7kmrf64PufnH1kn2ZH" +
                                                              "BleiSefHLE4WcFq8XvYqH5EWzsbPRJ7f1+pHxRDFIHJTDK6EoNjkXcMVeNrS" +
                                                              "QZzpUg4KxzUjgRU2lI68lbTf0IbsHg6/WtbUCyQyOHgE5PH/iz368Suv/XU5" +
                                                              "t2Q6VVQ7cnwPoW2O8MQmq+OBqNZG1zaDEKD787HuI0evH9zBoQUUc3It2Mra" +
                                                              "dghL4B2w4Dcv7HnjrWsnX/fbcKSQn5NRKHVSXJcpn8HHB8+/2cNCCusQoaWu" +
                                                              "3YpvszMBTmcrz7Nlg1CniN1htt6tAvjkuIyjCmF74Z/Vc5c+8+HhGuFuBXrS" +
                                                              "aFk89gR2/+fWoQde2TnaxKfxSSzV2vazyUT8nmzPvNYw8F4mR2r/5ZmPvoSP" +
                                                              "QyaA6GvKw4QHVMTtgbgDb+e2CPJ2uWfsTta0mk6Mu7eRoySKSA+9/tHE7R+d" +
                                                              "u8GldddUTr93Yr1NoEh4ARb7ArIaV4Bnow06a6emQIap3qDTgc1+mOz281u+" +
                                                              "WqOcvwnL9sKyEgRYs8uAEJhyQcmiLil784VfN+y6VIT8G1GlouHYRsw3HKoA" +
                                                              "pBOzH6JnSv/SGiHHUDk0NdweKMtCzOizcrtzQ0Kn3AHDz059etWPTlzjKBSw" +
                                                              "m56JjbOzYiMv2u1t/eHVx9795egPykTKX5A/lnn4pv2jS4keeOfTLE/wKJaj" +
                                                              "HPHw9wbPPN7YvvoDzm+HE8Y9J5WddiDg2rzLTic+9reU/taPynpRjWQVyNtZ" +
                                                              "UoGd3AtFoZmumqGIdo27CzxRzbRlwuUMbyhzLOsNZHa6g3dGzd4nelA3nXlx" +
                                                              "NTzzLdTN96LOh/hLB2eZy9v5rFnEXVhEUYVuaBSkJFDUlpq8GqcgiaxiJZVZ" +
                                                              "h6OlscA6wMuTrslZplG0aOz8LMpfALQIwqxdwZqQWLctF4JTufXwsdfFtrz8" +
                                                              "U1pgNzpgjNjOnJmvIubV/MkDIydiXaeWChDXuavMDXCIeuKP//pd4NhfXs5R" +
                                                              "qFRQTV+ikEGiONYsgyWbs7ZOJz8w2DhccXm06OrD06qyKwo2U1OeemFh/j3m" +
                                                              "XeClA39r3La6f9c4SoVZHkN5p/xJ55mXN82THvbzM4+AfdZZyc3U5gZ7pUHg" +
                                                              "cKduc0G+JePaycxl8+BZZrl2mRfyNpzmsma7G8WVBVgL5JG+AmMya6IUTZbN" +
                                                              "kNoPp1XYTFDh8AMpzzwOR7MLip5k1KTdhpyAqmHQOj6dbRjd85uy4fXpo1Eu" +
                                                              "FkF5l9l58bmO9yLcaeUMFRlTORCx1uhzVDs1rFnCgF4gAnskCu6re2vg8fef" +
                                                              "EBJ5w62HmBwaefCzwOERsQHEEXlO1inVySOOyR7pmgutwjk2vnd23y9+vO+g" +
                                                              "37J9L0VlUU1TCFYzvvFl0lOD145C2tKlx/9+/7eudEGtGULlSVXekyShmBuG" +
                                                              "ZWYy6jCsfa62QWnJzUouinwLdSs78iAmFQhi2WmYdazh3TvdQL8NnpUWWleO" +
                                                              "H+j5WAuAeX+BsW+w5j6KpsjmWlVOYMpqvTTS2VjCNsC+/40B5sJjzSC+x2eA" +
                                                              "fKwFlPxOgbHvsuYQJHmZ3VBxZOZR/9u3rH41G2qCZ5Olw6bxq5+PtYCKjxYY" +
                                                              "e4w1I1AL9xGa1jtzrhqwdjH7Uh3vcIQrkq37RcfuZD+HHBvm6C0brI4NNcPT" +
                                                              "ZWndNX6D5WMtYJTTBcbOsOaU22BbIMakq6QaXnuzWtGqhmx7/PCW7VHLhmbD" +
                                                              "c4+l1D3jt0c+1gI6P1tg7DnW/EzYYz2J46Qiyua0PW4bu2q06bmZnr5lM9Wz" +
                                                              "IVYf7rR03Tl+M+VjLWCKFwuMXWDNCxRNAjOFYkSlcKwmosL7sq36r8avegog" +
                                                              "570RY2fAaVnX9uKqWXryRHX51BN3/4nfymSug6ug8IgnFcV5RHG8l+oGictc" +
                                                              "kypxYNH510WK5v1313YUFbMvrsVrgvkyRc1jMsPJZTCDD4vxDxRNL8AIJxfx" +
                                                              "4uS5AjkuFw+EMmidlFfBol5KkIJ/O+muUVRp08Gi4sVJ8jbMDiTs9R09vSOW" +
                                                              "j20wGyGWR1M+9/Emg5j6sRDjOBHNcRWK/N+fdB2VFP//QNF6YvOWe2/ceUpc" +
                                                              "kEkKHh5ms0yA6klcw2WODc15Z0vPVdqx4Oakpyrmpgs71wWdUzYOZEgg/DKr" +
                                                              "0XNjZLZmLo7eOLnq3KuHSi9DSboD+TCU5zuyj+YpPQlnmh3hXHUiHKr4ZVZb" +
                                                              "5bu7Ln76pq+O34AgUVk2FeKISEfOXe2O6/r3/agihEqgbiUpfm+wfq+6lUiD" +
                                                              "hqvsLI1qSTXzR9EktsswSwbcMpZBJ2Z62d0pRS3ZxXX2fXKlog0RYx2bnU0z" +
                                                              "0XPQSuq6c5RbdlBkbmZpgGMk3Knr1pViUR23vK7zUPIxz9//AZQ2uzPiHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UfGo2aKpzqTZrZFuf7Gcygyv9v3xUEw9Tq9045Rb6CMOseha3ZpPtCI9Dyi9" +
       "BgvhnCOSYcJSOlkdULCZlmv1cbSGp1w1RIY1nh+isrMZuALC1pmhvSqw+Kov" +
       "tkup1CS7TbSOUhFdVNdUI8XdIcfJZTpEGF9SdKNXwZFNpSmvUcpZ+ELgTGFt" +
       "LnfHQ6faH3UpfjztyJ5Tpyi8Diwi9wkiCoauJETlmbcOUgaf2LKfon1LLxGO" +
       "2QdwFtZCbL1YRnSyIOwWWhFhXq7KhXqBMtpRK8Kn/lhqLesNfYTABU1wh4qK" +
       "TBwp7mrxeJzyyFpKE25Sd+x0sO7PNvVWxR4hPlwVwQC448EwkbAawOJNZUjx" +
       "zCTU53pzXlARYtBBIkELJqFUtJc1JkLVkZuMu2Os0IBDikRHBSWqty1FUbiJ" +
       "3yjP/FLfJY0KNpqjmE9LfAV33E2xJtVUe0hLXnnVnOhyqWCzKVIvRQVhxcrr" +
       "jdNrBN2E1EezoB5hZMdIhrJt9kwLrVd4rV9Iajw9qbdLbcuNqNko2JSprot5" +
       "OJtStY4zXsPjtklRXHNZ7CsbtcuERMqaqeyH6bDYdcoY1UyL1YYaCoOJlS66" +
       "+HgDQKizmLPpzGTWSFQKYZXi4wbaqKr6IFlOutMqBluOU/HWyGJcWaoqq016" +
       "JLzpdqQFNaA2jc18MOijs/XabaZ2gSLrs0anKiiK2dQRP+1NTLnQ8FUODqVB" +
       "4nijhTDkk34ocm5bKWNhyxUB0K3atOIiKJHGo3Q+sjYRx8wTI+2xQV+kpJpe" +
       "VtqpUnFUCys7UyvuT9K0p0z6jVqPNWCjhyOqmDTWVb/lkFPeILkZH0n4eNlp" +
       "NTnLW9XbK1k3pdjsiLxo1FgrkLHahokmfmCJntUuSmxa7zGehvWG9GYVKxtx" +
       "NRR6ctiqdCaRNt0EitYK/bTOlTy9n3r6or9gnY69pqM5DzPLJp0o5lRSBcJo" +
       "TiNpzTSnBK1G3QEMe0qlb2jToDpatUbDCV8wl2TbZPuzQE+EeYCKbCetb5Cm" +
       "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");
}
