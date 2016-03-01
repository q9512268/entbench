package org.apache.batik.bridge;
public class EmbededExternalResourceSecurity implements org.apache.batik.bridge.ExternalResourceSecurity {
    public static final java.lang.String DATA_PROTOCOL = "data";
    public static final java.lang.String ERROR_EXTERNAL_RESOURCE_NOT_EMBEDED =
      ("EmbededExternalResourceSecurity.error.external.esource.not.e" +
       "mbeded");
    protected java.lang.SecurityException se;
    public void checkLoadExternalResource() { if (se != null) { throw se;
                                              } }
    public EmbededExternalResourceSecurity(org.apache.batik.util.ParsedURL externalResourceURL) {
        super(
          );
        if (externalResourceURL ==
              null ||
              !DATA_PROTOCOL.
              equals(
                externalResourceURL.
                  getProtocol(
                    ))) {
            se =
              new java.lang.SecurityException(
                org.apache.batik.bridge.Messages.
                  formatMessage(
                    ERROR_EXTERNAL_RESOURCE_NOT_EMBEDED,
                    new java.lang.Object[] { externalResourceURL }));
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYb2wcRxWfO/937PhPmtjNHydxHCM7yV1D04bKodS+XBqH" +
                                                              "s+90dgI40Mvc7py98d7uZnfOPqe4aSKVRP0QqvwpKTT+QiogJE2FqEBCDUEI" +
                                                              "2qqUKqGCthEt0A8U2kjNB5pCgPJmZu92b+/Ohk9Y2rnxzJs377157/fezIUb" +
                                                              "qMoyUaeBNRkH6IxBrECM9WPYtIgcUrFljcJoQnr8jycP3fpN3WE/qh5Diyew" +
                                                              "NSRhi+xQiCpbY2iVolkUaxKxhgmR2YqYSSxiTmGq6NoYWqpYg2lDVSSFDuky" +
                                                              "YQR7sBlBLZhSU0lmKBm0GVC0OsKlCXJpgv1egr4IapB0Y8ZZsLxgQcg1x2jT" +
                                                              "zn4WRc2R/XgKBzNUUYMRxaJ9WRNtMHR1ZlzVaYBkaWC/eo9tiF2Re4rM0Plc" +
                                                              "00e3n5ho5mZYgjVNp1xFK04sXZ0icgQ1OaNhlaStA+gRVBFBi1zEFHVFcpsG" +
                                                              "YdMgbJrT16EC6RuJlkmHdK4OzXGqNiQmEEVrC5kY2MRpm02MywwcaqmtO18M" +
                                                              "2q7Ja5s7bo+KpzcET33joeYfVKCmMdSkaCNMHAmEoLDJGBiUpJPEtPplmchj" +
                                                              "qEWDAx8hpoJV5aB92q2WMq5hmgEXyJmFDWYMYvI9HVvBSYJuZkaiuplXL8Wd" +
                                                              "yv6vKqXicdB1maOr0HAHGwcF6xUQzExh8D17SeWkosncjwpX5HXs+jwQwNKa" +
                                                              "NKETen6rSg3DAGoVLqJibTw4As6njQNplQ4uaHJfK8OU2drA0iQeJwmK2r10" +
                                                              "MTEFVHXcEGwJRUu9ZJwTnNJyzym5zufG8LbjD2s7NT/ygcwykVQm/yJY1OFZ" +
                                                              "FCcpYhKIA7GwoTfyJF72wjE/QkC81EMsaH701ZsPbOy48pKgWVGCJprcTySa" +
                                                              "kM4lF19dGeq5r4KJUWvolsIOv0BzHmUxe6YvawDSLMtzZJOB3OSV+C+/9Oh5" +
                                                              "8r4f1Q+iaklXM2nwoxZJTxuKSswHiUZMTIk8iOqIJof4/CCqgX5E0YgYjaZS" +
                                                              "FqGDqFLlQ9U6/x9MlAIWzET10Fe0lJ7rG5hO8H7WQAjVwIdi8K1G4o//UpQN" +
                                                              "TuhpEsQS1hRND8ZMnenPDpRjDrGgL8OsoQeT4P+TmzYHtgYtPWOCQwZ1czyI" +
                                                              "wSsmiJgMJk1FHifBMIQQhE84C06lYZUFBFswQqSMqdCZAPNA4/+4d5bZZcm0" +
                                                              "zwdHttILGCrE2k5dlYmZkE5lBsI3n028IpyRBZBtUYq2ggABIUCACxAQAgQW" +
                                                              "EAD5fHzfO5ggwk3gkCcBLgCvG3pGvrJr37HOCvBPY7oSToiRdhflr5CDK7lk" +
                                                              "kJAuXI3feu3V+vN+5AfoSUL+cpJIV0ESETnQ1CUiA4qVSyc5SA2WTyAl5UBX" +
                                                              "zkwf3nPoLi6HOy8whlUAaWx5jKF5fosuLx6U4tt09L2PLj05qzvIUJBocvmx" +
                                                              "aCUDnE7vKXuVT0i9a/DziRdmu/yoElAMkJtiiDQAxQ7vHgXA05cDcaZLLSic" +
                                                              "0s00VtlUDnnr6YSpTzsj3P1aeP8OOOJFLBJ74XvADk3+y2aXGaxtE+7KfMaj" +
                                                              "BU8Snx0xzr7x67/czc2dyydNrkJghNA+F4YxZq0crVocFxw1CXgo/f2Z2MnT" +
                                                              "N47u5f4HFOtKbdjF2hBgFxwhmPmxlw68+c7b5173Oz5LIYlnklAPZfNKsnFU" +
                                                              "P4+SzM8deQADVcAC5jVduzXwSiWl4KRKWJD8s2n95uc/ON4s/ECFkZwbbVyY" +
                                                              "gTN+5wB69JWHbnVwNj6J5WDHZg6ZAPYlDud+08QzTI7s4WurnnoRn4UUAbBs" +
                                                              "KQcJR1qfHbdMqHbI00U4IVIDr0t2xyP8cLdw6iBv72aG4TwQn/sMa7osd5AU" +
                                                              "xqGrpkpIT7z+YeOeDy/f5FoVFmVunxjCRp9wQ9aszwL7Ni8g7cTWBNBtuTL8" +
                                                              "5Wb1ym3gOAYcJQBfK2oCPGYLPMimrqp562c/X7bvagXy70D1qo7lHZgHI6qD" +
                                                              "KCDWBCBr1vic7QXTtdA0c1VRkfLM7qtLn2g4bVB+Bgd/3PbDbd+Ze5s7n/C2" +
                                                              "FXx5hcVqQS9u8oLeCfkPrn/r3Z/e+naNKAd6yuOcZ137P6Jq8sifPi4yMke4" +
                                                              "EqWKZ/1Y8MLTy0P3v8/XO1DDVq/LFqckAGNn7afPp//m76z+hR/VjKFmyS6e" +
                                                              "92A1wwJ4DApGK1dRQ4FdMF9Y/IlKpy8PpSu9MOfa1gtyTiqEPqNm/UYPrrWz" +
                                                              "U7wXvjV2yK/x4poPkKJSxhSzfwf5wm7e9rBmozhI1t0EiGLxQp2CIAqkVQ+y" +
                                                              "tM2zDUWN2/tH+xOxeHQ0GopGcpHZzH2L2SIgCmEBs6y9jzW7xB7byjprqFDV" +
                                                              "KHyfsmXoLqXqwEK1CTFN3WTex6cD9nRAYy4pljJme+YzFGuGWRMtYaHuMtJR" +
                                                              "tC4cj0fjifAXR8Px4f5IIh4eie6Oh8KJ4ehoIjw0EN4e3s5I4x4bfeG/t9Fi" +
                                                              "NroOvk22FJuKbIR4J1FaPzBgnWHqFJyWyB7lGudhS5HfIrkzX+E6c9vq4axE" +
                                                              "jFxidKm2bx7VxFQ3a3rzkvC/auQpsd0pzoGnfHq4q2wZWcZJGFSvKnd94le/" +
                                                              "c0dOzcnRZzYLVGstvJKE4cZ98bf/+lXgzB9eLlHV1lHd2KSSKaIWCGuitUVY" +
                                                              "OsRvlw4wbb12q+L6ifaG4vKTceooU1z2lgdd7wYvHvnr8tH7J/b9D3Xlao+h" +
                                                              "vCy/N3Th5Qe7pRN+fkEWOFh0sS5c1FeIfvUmoRlTGy3AwM7C2m4DfFtsn9ji" +
                                                              "dXrH6zzulK+Yyi2dp2aYnWfuEGuyFN0JLidNRiBDe13NmjcXxkwlDYXklH3t" +
                                                              "Ds62vjP59HsXhbd5E5+HmBw79fgngeOnhOeJh4x1RW8J7jXiMYML3ixM8wn8" +
                                                              "+eD7N/uYVmyA/UJ6C9k36jX5K7VhZLn3ziMW32LHny/N/uS7s0f9tpUgFiqn" +
                                                              "dEV28GBmIagrqF3YQD9YefUCmM+KnPaiNyvxziI9O9dU2za3+3f8SpJ/C2mA" +
                                                              "Yj6VUVV3Dnb1qw2TpBSuRIPIyAb/+TpFbWXABrKr6HA9jgv6E5AhvfSQffmv" +
                                                              "m+40RfUOHbASHTfJGYoqgIR1nzJKpF9RimR9LsyxIZZbfulCls8vcd9YmOPy" +
                                                              "N8Nc7GfEq2FCujS3a/jhm/c+I25MkooPHmRcFkVQjbi85fFjbVluOV7VO3tu" +
                                                              "L36ubn3Ob1qEwE5Ur3CFXj9gqcFOfLnnOmF15W8Vb57bdvnVY9XXIET2Ih+m" +
                                                              "aMne4qIta2QA3PZG3KDsennmN52++nf3vfbxW75WXhvbMN4x34qEdPLy9VjK" +
                                                              "ML7pR3WDqArCgmR5Rbl9RosTaQqq+NqMphzIkEEZHC2pZ7T88+Ji5p6YlVHc" +
                                                              "MrZBG/Oj7MZNUWdxsBe/QsC1YZqYA4w7x1QP4mYMwz2bZc9uJbSCs9l89u+H" +
                                                              "vvZGFMKnQHA3txork8yDt/v10kHzZtY8lhUQU5GIDBmGDTm+R/ipGgYP94tc" +
                                                              "6e8LakZBka/XMP4DEbfYPoUYAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
