package org.apache.batik.css.engine.value.svg;
public class StrokeDashoffsetManager extends org.apache.batik.css.engine.value.LengthManager {
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return true; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_LENGTH_OR_INHERIT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_STROKE_DASHOFFSET_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                 NUMBER_0;
    }
    public org.apache.batik.css.engine.value.Value createValue(org.w3c.css.sac.LexicalUnit lu,
                                                               org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        if (lu.
              getLexicalUnitType(
                ) ==
              org.w3c.css.sac.LexicalUnit.
                SAC_INHERIT) {
            return org.apache.batik.css.engine.value.svg.SVGValueConstants.
                     INHERIT_VALUE;
        }
        return super.
          createValue(
            lu,
            engine);
    }
    protected int getOrientation() { return BOTH_ORIENTATION;
    }
    public StrokeDashoffsetManager() { super(
                                         );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO39/4Q8wED4MBkOEQ+5CE1oikxAwdjA9g4vB" +
       "ak3AjPfmfIv3dpfdOfvslJRESqGtQhElCakK/YcIWhFAVdO0ShMRRWpCk1YN" +
       "RU1JBYmUqiVtUIMqpX/QNn1vdvf243xnuarVk3Zub+a9mfd+8+Z9zJ29SUpM" +
       "gzQxlUf4mM7MSIfKe6hhsni7Qk1zO/QNSM8W0b/vvrHl/jAp7SczktTslqjJ" +
       "OmWmxM1+slBWTU5ViZlbGIsjR4/BTGaMUC5raj9plM2ulK7Iksy7tThDgj5q" +
       "xEg95dyQB9OcddkTcLIwBpJEhSTR9cHhthipljR9zCWf6yFv94wgZcpdy+Sk" +
       "LraXjtBomstKNCabvC1jkLt0TRkbUjQeYRke2austiHYHFudA8GSC7Wf3j6S" +
       "rBMQzKSqqnGhnrmNmZoywuIxUuv2digsZe4jj5GiGKnyEHPSEnMWjcKiUVjU" +
       "0dalAulrmJpOtWtCHe7MVKpLKBAnzf5JdGrQlD1Nj5AZZijntu6CGbRdnNXW" +
       "0jJHxafvih57dnfdj4pIbT+pldVeFEcCITgs0g+AstQgM8z18TiL95N6FTa7" +
       "lxkyVeRxe6cbTHlIpTwN2+/Agp1pnRliTRcr2EfQzUhLXDOy6iWEQdm/ShIK" +
       "HQJdZ7u6Whp2Yj8oWCmDYEaCgt3ZLMXDshrnZFGQI6tjyxeBAFjLUowntexS" +
       "xSqFDtJgmYhC1aFoL5ieOgSkJRoYoMHJvLyTItY6lYbpEBtAiwzQ9VhDQFUh" +
       "gEAWThqDZGIm2KV5gV3y7M/NLWsPP6puUsMkBDLHmaSg/FXA1BRg2sYSzGBw" +
       "DizG6tbYM3T2K4fChABxY4DYonnpq7ceWtl08U2LZv4ENFsH9zKJD0inBme8" +
       "s6B9xf1FKEa5rpkybr5Pc3HKeuyRtowOHmZ2dkYcjDiDF7f94isHfsj+GiaV" +
       "XaRU0pR0CuyoXtJSuqww42GmMoNyFu8iFUyNt4vxLlIG7zFZZVbv1kTCZLyL" +
       "FCuiq1QTvwGiBEyBEFXCu6wmNOddpzwp3jM6IaQMHlINzzJifcQ3J3o0qaVY" +
       "lEpUlVUt2mNoqL8ZBY8zCNgmo4Ng9cNRU0sbYIJRzRiKUrCDJLMHJBNph0Cm" +
       "6AhV0ixqjgi70obZRmomLSm7qQrGYUTQ8vT/w5oZxGHmaCgEW7Qg6CAUOFub" +
       "NCXOjAHpWHpDx61zA29ZxocHxkaQkwdAjIglRkSIEQExIpYYESFGBMSI5BGD" +
       "hEJi9VkojmUcsLXD4CTAS1ev6N21ec+hJUVglfpoMewLki7xRat215M47n9A" +
       "Ot9QM958fdXrYVIcIw1U4mmqYPBZbwyBW5OG7ZNfPQhxzA0niz3hBOOgoUks" +
       "Dt4sX1ixZynXRpiB/ZzM8szgBDs81tH8oWZC+cnF46OP933tnjAJ+yMILlkC" +
       "zg/Ze9DvZ/17S9BzTDRv7cEbn55/Zr/m+hBfSHIiaQ4n6rAkaB9BeAak1sX0" +
       "xYFX9rcI2CvAx3MKRgDusym4hs9FtTnuHnUpB4UTmpGiCg45GFfypKGNuj3C" +
       "cOuxabRsGE0oIKCIFA/06id+/+uP7hVIOkGl1pMN9DLe5nFkOFmDcFn1rkVu" +
       "NxgDumvHe77z9M2DO4U5AsXSiRZswbYdHBjsDiD45Jv7rr5//dSVsGvCHCJ5" +
       "ehASoozQZdZn8AnB82980Plgh+WEGtptT7g46wp1XHm5Kxs4RQWcBBpHyw4V" +
       "zFBOyHRQYXh+/lm7bNWLHx+us7ZbgR7HWlZOPoHbf8cGcuCt3f9oEtOEJAzK" +
       "Ln4umeXpZ7ozrzcMOoZyZB6/vPC5N+gJiBngp015nAnXSwQeRGzgaoHFPaK9" +
       "LzD2BWyWmV4b9x8jT/I0IB258klN3yev3hLS+rMv7753U73NsiJrF2CxNmI3" +
       "vlCAo7N1bOdkQIY5QUe1CVwaTHbfxS2P1CkXb8Oy/bCsBA7a3GqA88z4TMmm" +
       "Lil777XXZ+95p4iEO0mlotF4JxUHjlSApTNwkko8o697yJJjtByaOoEHyUEo" +
       "pwN3YdHE+9uR0rnYkfGfzvnx2tMnrwuz1K055nsnXC7aFdistMwWX+/OZMES" +
       "n9ICYPnnNMjCfKmNSMtOPXHsZHzr86usBKTBny50QDb8wu/+9Xbk+AeXJohA" +
       "FVzT71bYCFM8a5bjkr5I0S2yPtdbXZtx9MOftQxtmEqQwL6mScIA/l4ESrTm" +
       "d/pBUd544i/ztj+Y3DMFf78oAGdwyh90n7308HLpaFikuJarz0mN/UxtXmBh" +
       "UYNBLq+imthTI07L0qwBzMSNXQ5Pq20ArcHTYjlmYU3YdGRZhU1UFmAt4Az6" +
       "Cox9GZsvcTITSk41CcUJ+EsIU6L+8CcOuM+96UETgrycAsc/YufKn+vZIx1q" +
       "6fmjZYZ3TMBg0TWeiT7V9+7et8WGlaOFZGHyWAdYkidc1WETwaOwokDl6Zcn" +
       "ur/h/eHv3XjBkieY6AeI2aFj3/wscviYdUSsamhpTkHi5bEqooB0zYVWERyd" +
       "fz6//+Uz+w+Gbdy7OCkb1DSFUTW7L6FsvjbLj6Il68Zv1P78SENRJxy+LlKe" +
       "VuV9adYV9xtgmZke9MDqFlCuOdpSY8TkJNTquLI12Gyz3tf+l14UOzboor/b" +
       "b/R3wrPKttxVUzf6fKwFDHtfgTHRCYd7lmyuV+UU5Ri8HavHsUdcSFLTBQk6" +
       "/zW2XmumDkk+1gJqP1Zg7AA2Y5A+yXhdIWw3DyDj0wBILY41wbPO1mrd1AHJ" +
       "x1pA6W8VGHsKm69DAjTEuINENpnut08+fu3yvFNOimT7+slzovFnwnPMDk4D" +
       "hA041gxPp41D59QhzMdaAKYTBca+j81xP4RbwFcJ4rmc1ImMC2+PItbtkYvQ" +
       "c9OAUD2OLYan21aze+oI5WMtgMLZAmPnsDltIbSRJWha4X1Y/jsI3Tn5RYFL" +
       "L4A7M13ALYBnu6399qkDl481AE5YCBJ29J+P+o/eKwm1TSpFYiwjS1TZocrc" +
       "oVlWCKP23t4O8SZEfDmwmhNw7ZnmOqvFtVRk49bujozEdMwpBfNr2PyEkyrJ" +
       "YFBVCtyx64IL/kvTda7RaqmNIC0Afk4FApm+bmgcihkWz/h3pabAnAVM9jcF" +
       "xi5jc4mTGWDOWw0ZkhjqXBB820Xpl/8LlDKczMlzP4bF3Nycq3vrulk6d7K2" +
       "fM7JHe+KCiZ7JVwNGWkirSieTMqbVZXqBkvIQsVqqwDWxdd7k1hf9ioPwgK0" +
       "QperFus1TponZeWkZCR7vG3GD+xTkYeRk1LrxcvzIaQ6E/GAWNB6Kf8EXjlI" +
       "CVKIby/dR5xUunSwqPXiJfkYZgcSfL2pO0csOjlcMfjFk/ZeZkK5dbYwosbJ" +
       "jMhTRi/11Q7ivx8nuU5b//4MSOdPbt7y6K3PP29dekkKHR/HWaogpbau1rJV" +
       "ZHPe2Zy5SjetuD3jQsUyJ9f3Xbp5ZROmDKdUXFDNC9wCmS3Zy6Crp9a++qtD" +
       "pZehStlJQpBkzNzp+efF+puhLaOnoXzfGcstHaDiFtdTbSu+O/bgysTf/iCu" +
       "MIhVaizITz8gXTm967dH555qCpOqLlICZQzL9JNK2dw4pm5j0ojRT2pksyMD" +
       "IsIsMlV8dckMPF0U47rAxYazJtuLt6GcLMmttnLvkCsVbZQZG7S0GsdpoLKp" +
       "cnuc2wRfIZ7W9QCD2+MpMAV9JIO7AeY6EOvWdecqsTiiC1+TmDibgzYkXGYC" +
       "30L/ARffxLsXHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
