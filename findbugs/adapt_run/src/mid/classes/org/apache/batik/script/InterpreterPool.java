package org.apache.batik.script;
public class InterpreterPool {
    public static final java.lang.String BIND_NAME_DOCUMENT = "document";
    protected static java.util.Map defaultFactories = new java.util.HashMap(
      7);
    protected java.util.Map factories = new java.util.HashMap(7);
    static { java.util.Iterator iter = org.apache.batik.util.Service.providers(
                                                                       org.apache.batik.script.InterpreterFactory.class);
             while (iter.hasNext()) { org.apache.batik.script.InterpreterFactory factory =
                                        null;
                                      factory = (org.apache.batik.script.InterpreterFactory)
                                                  iter.
                                                  next(
                                                    );
                                      java.lang.String[] mimeTypes =
                                        factory.
                                        getMimeTypes(
                                          );
                                      for (int i = 0; i <
                                                        mimeTypes.
                                                          length;
                                           i++) { defaultFactories.
                                                    put(
                                                      mimeTypes[i],
                                                      factory);
                                      } } }
    public InterpreterPool() { super();
                               factories.putAll(defaultFactories);
    }
    public org.apache.batik.script.Interpreter createInterpreter(org.w3c.dom.Document document,
                                                                 java.lang.String language) {
        org.apache.batik.script.InterpreterFactory factory =
          (org.apache.batik.script.InterpreterFactory)
            factories.
            get(
              language);
        if (factory ==
              null)
            return null;
        org.apache.batik.script.Interpreter interpreter =
          null;
        org.apache.batik.dom.svg.SVGOMDocument svgDoc =
          (org.apache.batik.dom.svg.SVGOMDocument)
            document;
        try {
            java.net.URL url =
              new java.net.URL(
              svgDoc.
                getDocumentURI(
                  ));
            interpreter =
              factory.
                createInterpreter(
                  url,
                  svgDoc.
                    isSVG12(
                      ));
        }
        catch (java.net.MalformedURLException e) {
            
        }
        if (interpreter ==
              null)
            return null;
        if (document !=
              null)
            interpreter.
              bindObject(
                BIND_NAME_DOCUMENT,
                document);
        return interpreter;
    }
    public void putInterpreterFactory(java.lang.String language,
                                      org.apache.batik.script.InterpreterFactory factory) {
        factories.
          put(
            language,
            factory);
    }
    public void removeInterpreterFactory(java.lang.String language) {
        factories.
          remove(
            language);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfXAV1RW/7wXyRSAffCQNECAELF/vFVAyGqqG8BV8SV6T" +
       "wNhH9bHZvS9Zsm932b2bPKCAMKMw2qGOINIqdMZia2kUxilTtRVpnVYdahmo" +
       "Y1VapfKHWmRG/tDY0taee+/u23373gsw45iZvbm599xz7zn3nN8552boMhpt" +
       "GqheF1RJCJHNOjZDUdqPCoaJpRZFMM1uGI2LD/5j347hv5TsDKLCGBrXJ5ht" +
       "omDilTJWJDOGpsqqSQRVxGY7xhJdETWwiY0BgciaGkMTZbM1qSuyKJM2TcKU" +
       "YJ1gRFClQIgh91gEt9oMCJoWYacJs9OEm/0ETRFUJmr6ZndBbcaCFs8cpU26" +
       "+5kEVUQ2CgNC2CKyEo7IJmlKGWierimbexWNhHCKhDYqt9iKWBO5JUsN9cfL" +
       "P7/6cF8FU8N4QVU1wkQ0O7GpKQNYiqByd3SFgpPmJrQdFUTQGA8xQQ0RZ9Mw" +
       "bBqGTR15XSo4/VisWskWjYlDHE6FukgPRNCMTCa6YAhJm02UnRk4FBNbdrYY" +
       "pJ2elta5bp+Ij84L73/s3ornClB5DJXLahc9jgiHILBJDBSKkz3YMJslCUsx" +
       "VKnChXdhQxYUeYt921Wm3KsKxAITcNRCBy0dG2xPV1dwkyCbYYlEM9LiJZhR" +
       "2X+NTihCL8g6yZWVS7iSjoOApTIczEgIYHv2klH9sioxO8pckZax4S4ggKVF" +
       "SUz6tPRWo1QBBlAVNxFFUHvDXWB8ai+QjtbABA1ma3mYUl3rgtgv9OI4QTV+" +
       "uiifAqoSpgi6hKCJfjLGCW6p1ndLnvu53L5071Z1tRpEATizhEWFnn8MLKrz" +
       "LerECWxg8AO+sGxu5IAw6aU9QYSAeKKPmNP8+vtX7pxfd+o1TjM5B01Hz0Ys" +
       "krh4pGfc2Sktc24toMco1jVTppefITnzsqg905TSAWkmpTnSyZAzearzj9+9" +
       "7yi+FESlrahQ1BQrCXZUKWpJXVawsQqr2BAIllpRCValFjbfioqgH5FVzEc7" +
       "EgkTk1Y0SmFDhRr7G1SUABZURaXQl9WE5vR1gfSxfkpHCBXBh8rgW4D4D/tN" +
       "UF+4T0visCAKqqxq4aihUfnphTLMwSb0JZjVtXAP2H//goWhxrCpWQYYZFgz" +
       "esMCWEUf5pNhUzRknYRbqc3qBoY2qmlKiFqc/jXulaJyjx8MBOBKpvgBQQFf" +
       "Wq0pEjbi4n5r2Yorz8ZPc2OjDmJrjKCbYMMQ3zDENgzxDUO+DVEgwPaZQDfm" +
       "1w6X1g/uD/hbNqfrnjUb9tQXgL3pg6NA45R0dlY8anFxwgH3uDh0tnP4zBul" +
       "R4MoCFDSA/HIDQoNGUGBxzRDE7EEqJQvPDgQGc4fEHKeA506OLhz3Y5vsXN4" +
       "cZ4yHA0QRZdHKTqnt2jw+3cuvuW7P/r82IFtmuvpGYHDiXdZKymA1Ptv1S98" +
       "XJw7XTgRf2lbQxCNAlQCJCYCeA6AXJ1/jwwgaXJAmcpSDAInNCMpKHTKQdJS" +
       "0mdog+4IM7dK1p8AVzyGelYtfG22q7HfdHaSTttqbp7UZnxSMND/dpd+6O0/" +
       "f7yYqduJD+WewN6FSZMHkyizKoY+la4JdhsYA93fD0b3PXp593pmf0AxM9eG" +
       "DbRtASyCKwQ13//apnfef+/Im0HXZgkEZasH8ptUWkg6jkpHEJLauXsewDQF" +
       "fJ1aTcNaFaxSTshCj4Kpk/ynfNbCE5/sreB2oMCIY0bzr83AHf/GMnTf6XuH" +
       "6xibgEhjqqszl4wD9XiXc7NhCJvpOVI7z0390avCIYB8gFlT3oIZciKmA8Qu" +
       "7WYmf5i1i31zS2jTYHqNP9O/PLlPXHz4zU/Hrvv05BV22szkyXvXbYLexM2L" +
       "NrNSwL7aDzSrBbMP6G4+1f69CuXUVeAYA44igKbZYQDMpTIsw6YeXfTu716Z" +
       "tOFsAQquRKWKJkgrBeZkqASsG5t9gJAp/Y47+eUOFkNTwURFWcJTfU7LfVMr" +
       "kjphut3yfPWvlv788HvMqLgVTWbLC0yas/nxkCXerit/cv7xiy8P/7SIh+05" +
       "+fHLt67m3x1Kz64PvshSMkOuHCmFb30sPPREbcvtl9h6F0Lo6pmp7NACIOuu" +
       "XXQ0+VmwvvAPQVQUQxWineSuExSLOmYMEjvTyXwhEc6Yz0zSeEbSlIbIKX74" +
       "8mzrBy83pEGfUtP+WB9e1dBbvAO+RbYrL/LjVQAQoFjSRCuJVeacq9ji2ayd" +
       "Q5v5/DJpdwGghcmSagKHkVVB8aFG9QhbgejLWtuXx9ub21bEl3e0rG1b0d7N" +
       "ltdAdcOMjColxDNXjqO0baTNar7RbXmttjl9kIl0tAm+RvsgjVkyI9bpzi1p" +
       "kKAS3dAI3AyW6HDEJ+SEEXiDJBJOCJZCuM/J4KngQl4voGVkl9Vjkk5hkCXH" +
       "cfEH9ffvvKnoyhLuBNNzUnvy6MXDS8qnH31a5eQNuZlnZtAfbD39pPa3S0En" +
       "O861hFPeZbadeXH1h3EWo4ppatLtGJcn6Wg2ej0BsiKtoHFUH5XwXbAVdIHn" +
       "ohu/0vwQmEC5KCfBTsLdchJLtFwF+3Wy0a9xNwrbk7NAzr3aEy/+rHHP/Luf" +
       "5IqfkQffXPoXvnPh7KEtx4Z4xKTqJ2hevpI7u86nCdSsEZJA14g+W3XbqY8v" +
       "rrsnaMe4cbTZkHIccqyL+hBS6GBfOjoE0unuJL8hcd6FCw/9a8cDb3dAftaK" +
       "ii1V3mThVikTs4pMq8djWW5t6eKYbVZfwk8Avv/Rj5oTHeBmVdVi11nT04WW" +
       "rqfoPEGBudD1wcja64cRZsm0klpqW/LSPDBi5IaRAO3e7YOOsSPwA9hJOJhB" +
       "B+K+s5sjnJ1PzabN3PSO7KcQ+epCbx7nxmpE7XhqvtKdPTsc2bX/sNTx1EJu" +
       "yVWZ5fAK1Uo+89Z//xQ6eOH1HBVXCdH0BQoewIovP5iR5Tpt7GXDDbaN54YL" +
       "zj9SU5ZdKlFOdXkKobn5fcC/wau7/lnbfXvfhhuogab5FOVn+Yu2oddXzRYf" +
       "CbLHGR7bsx51Mhc1ZXpHKRShlqFm+kN9+mppnEXfhC9mX23Mb5yu8fisIp3d" +
       "51vqy4ODPCg6uDCB1s6Di8WQpCVDyz15Q5Rt+dAIWfQPafMAQZWigQX6LJou" +
       "th3mM6+jMHcdYve1nDkjk6UDd7DhXZnlXDN8lq0LcuNqJHmW5lYj05Qj7tzr" +
       "EJenEZvZQR4fQbk/oc0BgibqFslebo6YWkcNCG5EHrDRO7yt6v3+Jz56hju6" +
       "P4/2EeM9+x/8MrR3P3d6/n45M+sJ0buGv2FygKdNMmV6A2OOXdiKlR8e2/ab" +
       "p7ftduLVdoJGDWiy5NrDY1+NPdwK33b7UrffuD3kW+q7u4AbJLjnHB/hcp+j" +
       "zS8JqjFwUhvA2fdL54+4mhi6cU2koDj1PX/R4q8m682dvxOLzx4uL64+vPav" +
       "7Akm/ZZbBiljwlIUb23i6RcC84TMRCrjlQqP0C8QVJ3HF2jFwTrs3M9z+t9C" +
       "mu2nh4qE/fbSvUxQqUsHrHjHS/J7ggqAhHZf0XNUI7xESwUyY2Va0xOvpWlP" +
       "eJ2Z4YHsfx5O/LCidvp37PCa9q1XljzFX4hERdiyhXIZA/kSf6xKx6AZebk5" +
       "vApXz7k67njJLMdjKvmBXROe7DExKBIDOr3xWt/zidmQfkV558jSk2/sKTwH" +
       "vr4eBQSCxq/PLmZTugUBcn0kV2YIEZq97DSVXtxw5ot3A1XszQDxXLJupBVx" +
       "cd/J89GErv84iEpa0WgABJxilfbyzWonFgeMjESzsEez1PS/R8ZR8xRoVck0" +
       "Yyt0bHqUvjASVJ+NWtmvrqWKNoiNZZQ7i8u+qG3puneWabafgxyPEQXxSJuu" +
       "2wlsUYxpXteZC75FG+X/vSnajNgcAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qLDzjycAAA==");
}
