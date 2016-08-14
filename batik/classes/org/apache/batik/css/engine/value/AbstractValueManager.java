package org.apache.batik.css.engine.value;
public abstract class AbstractValueManager extends org.apache.batik.css.engine.value.AbstractValueFactory implements org.apache.batik.css.engine.value.ValueManager {
    public org.apache.batik.css.engine.value.Value createFloatValue(short unitType,
                                                                    float floatValue)
          throws org.w3c.dom.DOMException { throw createDOMException(
                                                    ); }
    public org.apache.batik.css.engine.value.Value createStringValue(short type,
                                                                     java.lang.String value,
                                                                     org.apache.batik.css.engine.CSSEngine engine)
          throws org.w3c.dom.DOMException {
        throw createDOMException(
                );
    }
    public org.apache.batik.css.engine.value.Value computeValue(org.apache.batik.css.engine.CSSStylableElement elt,
                                                                java.lang.String pseudo,
                                                                org.apache.batik.css.engine.CSSEngine engine,
                                                                int idx,
                                                                org.apache.batik.css.engine.StyleMap sm,
                                                                org.apache.batik.css.engine.value.Value value) {
        if (value.
              getCssValueType(
                ) ==
              org.w3c.dom.css.CSSValue.
                CSS_PRIMITIVE_VALUE &&
              value.
              getPrimitiveType(
                ) ==
              org.w3c.dom.css.CSSPrimitiveValue.
                CSS_URI) {
            return new org.apache.batik.css.engine.value.URIValue(
              value.
                getStringValue(
                  ),
              value.
                getStringValue(
                  ));
        }
        return value;
    }
    public AbstractValueManager() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1Ye2wcRxmfOz9iO3b8SJykeTix4wTZTe8a0hQqm1LHsRuH" +
       "c3KKkyAcksvc3tx5473dze6cfXZJ21SghCJCFNI2VDQSKFEDtEmpqABBq6CK" +
       "PtSC1BJRCmqKBBLhEdEIqfwRoHzfzO7t3t7ZbhBw0s7tzn7zvef3fbNPXSNV" +
       "tkXamM4jfMpkdmRA53Fq2SzVr1Hb3gVzCeWxCvq3/Ve33xUm1aNkwRi1hxVq" +
       "s0GVaSl7lKxUdZtTXWH2dsZSuCJuMZtZE5Srhj5KWlV7KGtqqqLyYSPFkGAP" +
       "tWKkmXJuqckcZ0MOA05WxkCTqNAk2hd83RMj9YphTnnkS33k/b43SJn1ZNmc" +
       "NMUO0gkazXFVi8ZUm/fkLXKraWhTGc3gEZbnkYPaJscF22KbSlzQ8Uzj+zdO" +
       "jDUJFyykum5wYZ69k9mGNsFSMdLozQ5oLGsfIveTihiZ7yPmpDPmCo2C0CgI" +
       "da31qED7Bqbnsv2GMIe7nKpNBRXipL2YiUktmnXYxIXOwKGGO7aLxWDt6oK1" +
       "0soSEx+5NXrqsf1Nz1aQxlHSqOojqI4CSnAQMgoOZdkks+y+VIqlRkmzDsEe" +
       "YZZKNXXaiXSLrWZ0ynMQftctOJkzmSVker6COIJtVk7hhlUwLy0SynmqSms0" +
       "A7Yu9myVFg7iPBhYp4JiVppC3jlLKsdVPcXJquCKgo2dnwICWDovy/iYURBV" +
       "qVOYIC0yRTSqZ6IjkHp6BkirDEhAi5NlMzJFX5tUGacZlsCMDNDF5SugqhWO" +
       "wCWctAbJBCeI0rJAlHzxuba99/h9+lY9TEKgc4opGuo/Hxa1BRbtZGlmMdgH" +
       "cmF9d+xRuvj5Y2FCgLg1QCxpvv+56/esb7v0iqRZXoZmR/IgU3hCOZtc8MaK" +
       "/q67KlCNGtOwVQx+keVil8WdNz15ExBmcYEjvoy4Ly/tfOkzD36b/TlM6oZI" +
       "tWJouSzkUbNiZE1VY9a9TGcW5Sw1RGqZnuoX74fIPLiPqTqTszvSaZvxIVKp" +
       "ialqQzyDi9LAAl1UB/eqnjbce5PyMXGfNwkhTXCR5XCtJfK3BgdO1OiYkWVR" +
       "qlBd1Y1o3DLQfjsKiJME345Fk5D141HbyFmQglHDykQp5MEYc14oNtJmQKfo" +
       "BNVyLNqXhIynCt+DT8NUh6ywIphy5v9TWB4tXzgZCkFQVgQhQYPdtNXQUsxK" +
       "KKdymweuX0i8JtMNt4jjM07uBPkRKT8i5EdAfkTKjwj5kXLySSgkxC5CPWQe" +
       "QBTHAQ8AkOu7RvZtO3CsowIS0JyshBAgaUdRYer3QMNF+oRysaVhuv3KhhfD" +
       "pDJGWkBkjmpYZ/qsDCCYMu5s8voklCyvcqz2VQ4seZahsBQA10wVxOFSY0ww" +
       "C+c5WeTj4NY13MHRmatKWf3JpdOTR/Y8cHuYhIuLBYqsApzD5XGE+AKUdwZB" +
       "ohzfxqNX37/46GHDg4ui6uMWzZKVaENHMDGC7kko3avpc4nnD3cKt9cCnHMK" +
       "0QekbAvKKEKjHhfZ0ZYaMDhtWFmq4SvXx3V8zDImvRmRsc04tMrkxRQKKCiK" +
       "widGzCd+9fM/bhSedOtHo6/wjzDe48MsZNYi0KnZy8hdFmNA987p+FcfuXZ0" +
       "r0hHoFhTTmAnjv2AVRAd8OAXXjn09rtXzl4OeynMoWjnktD75IUtiz6AXwiu" +
       "f+GFOIMTEm9a+h3QW11APRMlr/N0A/zTABYwOTp365CGalqlSY3h/vlH49oN" +
       "z/3leJMMtwYzbrasn5uBN3/LZvLga/v/3ibYhBSsv57/PDIJ6gs9zn2WRadQ" +
       "j/yRN1d+7WX6BJQHgGRbnWYCZYnwBxEB3CR8cbsY7wi8+xgOa21/jhdvI1+f" +
       "lFBOXH6vYc97L1wX2hY3Wv64D1OzR2aRjAIIW0GcwUV98Y9vF5s4LsmDDkuC" +
       "QLWV2mPA7I5L2z/bpF26AWJHQawCkGzvsAA180Wp5FBXzfv1T15cfOCNChIe" +
       "JHWaQVODVGw4UguZzuwxANy8+cl7pB6TNW5NypMSD5VMYBRWlY/vQNbkIiLT" +
       "P1jyvd4nz1wRaWlKHsv9DNeJsQuH9WI+jLe3cVJDHRTPF/wmfo1ulXT/fX7z" +
       "sQ+J+6WcROauF/46ga5fOVMfJHq4sw+dOpPacW6D7FZainuLAWidn/7lP1+P" +
       "nP7tq2WKVy03zNs0NsE0n6oVKLKo1gyLFtHDu3cWnPzdDzszm2+mzOBc2xyF" +
       "BJ9XgRHdM5eNoCovP/SnZbvuHjtwExVjVcCdQZbfGn7q1XvXKSfDoh+WxaKk" +
       "jy5e1ON3LAi1GDT+OpqJMw1iv60p5E0zpkk7XN1O3nQH95uE9rL5GBL56CWh" +
       "yN26WZgFACYss7q4n8DgjeQgweOWmoV6MOF0yx+NH1COdcZ/L3PrljILJF3r" +
       "+eiX97x18HURhRoMe8F2X8ghPXxVrAmHCOZ31yxnz2J9oodb3h3/+tWnpT7B" +
       "Vj9AzI6deviDyPFTMu/leWhNyZHEv0aeiQLatc8mRawY/MPFwz86f/ho2MHt" +
       "GCdVgGQWLzg9VGjiFhX7UGq65YuNPz7RUjEI+2mI1OR09VCODaWKc2qenUv6" +
       "nOodoLwMc3TGMspJqNvFt72OKfi333ef5NgYGLRETXzM5AXL0UD2hIrBbCmC" +
       "2eRGJZIyspEtO4YH8gozcfuJxeKQsYuTJsViUMIHUZbANnf5Rz4kFgr6j+Ow" +
       "W6re+x9WCJzYbIr5ePF27IBro7ODNs6yHXH4dOnmm2lpwH0VEmDxcZ/rhCZR" +
       "svCkHZEnbffF2tm80z8yMiDuhHL3lw8TPpqC4PM4THE4TYpQSEHCt/jC9hw8" +
       "/b9y8Eq4eh0v9d68g2daGjC8WihS/aGKLbhwhE9p2PPhNyrYmLjqARyOzLVx" +
       "KlR9hm3jiu6cTTTKhQovTLCF9V+ZpQ98HIeHOX4oypo5zsrF7Uv/jbjl4SRX" +
       "7rCKndXSkk9m8jOPcuFMY82SM7vfEs1A4VNMPdSBdE7TfAjmR7Nq02JpVVhX" +
       "L7tRmaff5KR9TlAA3JoowMI35MJznCyfZSGcPeSNf815MLfcGggvjH7K78A2" +
       "DVKCFuLfT3eBkzqPDoTKGz/Jd4E7kODts6abLDf7EUE2zVP5UGkDK7Khda5s" +
       "KCzxn+aw+orvp26ByskvqAnl4plt2++7fuc5eZpUNDo9jVzmQ1mSZ9ZCc9U+" +
       "IzeXV/XWrhsLnqld61bLotOsXzeRk7CvxMlvWeB4ZXcWTllvn+194WfHqt+E" +
       "Or+XhCgnC/f6vl7KT3VwRstBV7s3Vlp+oREV576ersen7l6f/utvxNnAKdcr" +
       "ZqZPKJef3PeLk0vPwvlw/hCpgkaA5UdJnWpvmdJ3MmXCGiUNqj2QBxWBi0q1" +
       "otq+AHcKRRgWfnHc2VCYxc8MnHSU9iulH2fgHDXJrM1GTk853cF8b6bow66z" +
       "++pyphlY4M34WrS0BD2MBmRtIjZsmu4ZvbLXFKCRKY+COP5U3OLw0r8BsIun" +
       "s1sZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
