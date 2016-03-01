package edu.umd.cs.findbugs.ba;
public class SignatureParser {
    private int totalArgumentSize;
    public int getTotalArgumentSize() { if (parameterOffset == null) { getParameterOffset(
                                                                         );
                                        }
                                        return totalArgumentSize;
    }
    @javax.annotation.CheckForNull
    private int[] parameterOffset;
    @javax.annotation.Nonnull
    int[] getParameterOffset() { if (parameterOffset != null) { return parameterOffset;
                                 }
                                 java.util.ArrayList<java.lang.Integer> offsets =
                                   new java.util.ArrayList<java.lang.Integer>(
                                   );
                                 java.util.Iterator<java.lang.String> i =
                                   parameterSignatureIterator(
                                     );
                                 int totalSize = 0;
                                 while (i.hasNext(
                                            )) { java.lang.String s =
                                                   i.
                                                   next(
                                                     );
                                                 if ("D".
                                                       equals(
                                                         s) ||
                                                       "J".
                                                       equals(
                                                         s)) {
                                                     totalSize +=
                                                       2;
                                                 }
                                                 else {
                                                     totalSize +=
                                                       1;
                                                 }
                                                 offsets.
                                                   add(
                                                     totalSize);
                                 }
                                 totalArgumentSize =
                                   totalSize;
                                 int numParameters =
                                   offsets.
                                   size(
                                     );
                                 parameterOffset =
                                   (new int[numParameters]);
                                 for (int j = 0; j <
                                                   numParameters;
                                      j++) { parameterOffset[j] =
                                               offsets.
                                                 get(
                                                   j);
                                 }
                                 return parameterOffset;
    }
    public int getSlotsFromTopOfStackForParameter(int paramNum) {
        int offset =
          getParameterOffset(
            )[paramNum];
        int result =
          totalArgumentSize -
          offset;
        return result;
    }
    private class ParameterSignatureIterator implements java.util.Iterator<java.lang.String> {
        private int index = 1;
        @java.lang.Override
        public boolean hasNext() { return index <
                                     signature.
                                     length(
                                       ) &&
                                     signature.
                                     charAt(
                                       index) !=
                                     ')'; }
        @java.lang.Override
        public java.lang.String next() { if (!hasNext(
                                                )) {
                                             throw new java.util.NoSuchElementException(
                                               );
                                         }
                                         java.lang.StringBuilder result =
                                           new java.lang.StringBuilder(
                                           );
                                         boolean done;
                                         do  {
                                             done =
                                               true;
                                             int ch =
                                               signature.
                                               charAt(
                                                 index);
                                             switch (ch) {
                                                 case 'B':
                                                 case 'C':
                                                 case 'D':
                                                 case 'F':
                                                 case 'I':
                                                 case 'J':
                                                 case 'S':
                                                 case 'Z':
                                                     result.
                                                       append(
                                                         signature.
                                                           charAt(
                                                             index));
                                                     ++index;
                                                     break;
                                                 case 'L':
                                                     int semi =
                                                       signature.
                                                       indexOf(
                                                         ';',
                                                         index +
                                                           1);
                                                     if (semi <
                                                           0) {
                                                         throw new java.lang.IllegalStateException(
                                                           "Invalid method signature: " +
                                                           signature);
                                                     }
                                                     result.
                                                       append(
                                                         signature.
                                                           substring(
                                                             index,
                                                             semi +
                                                               1));
                                                     index =
                                                       semi +
                                                         1;
                                                     break;
                                                 case '[':
                                                     result.
                                                       append(
                                                         '[');
                                                     ++index;
                                                     done =
                                                       false;
                                                     break;
                                                 case 'V':
                                                 default:
                                                     throw new java.lang.IllegalStateException(
                                                       "Invalid method signature: " +
                                                       signature);
                                             }
                                         }while(!done); 
                                         return result.
                                           toString(
                                             );
        }
        @java.lang.Override
        public void remove() { throw new java.lang.UnsupportedOperationException(
                                 ); }
        public ParameterSignatureIterator() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "Yfb7g5PYLZXbgEp+NWRP+n2NGeo+Fup+M0ynuXQy5WDFUlI8sVC6qu53rz3C" +
           "VZtXRjX3mtv2fXbyvS1nXqxCNVDj0owi6HCXhctyqNwzkJNBcAB6y2AVZJpG" +
           "vlpShpjTTee2FEYL5TpBl5TjzeC1+NID5ckY1peqOSXNkq0bX+pzmuacZWES" +
           "+K9Oz+1Qn34B+xXUNzEGtTDTN7KYpNmaQa1zEuB1Uk+0Ox5PDtwU600Odq+O" +
           "dC+N9rKQ1WDS12sFdpPNhKf8fIkZ/giUd1ZPjnLMZ+fj9XmGCOWebljOOHDn" +
           "rv3pVQ8vsgDoWwTVmC9qNvuqImDpYy9VdqXzduN9f/xJcGjpl7n60rGOC1xu" +
           "6f8zK0OVV5Tn73y/fWDJ8IYvcYud6TGRl+UjfY+9eN188T4/e5bjJVjRc557" +
           "UZcnXOEE5HTFnQDnFhLXFKv8WmOGzRpv+WWnxuLaC1ym5VKyJHrqr8YKDCvc" +
           "e/ZWmHuQNvfCXXJYMPrBFYwoZtYo9Cvu6K8BupSqylhQSoennervc6f6hkKq" +
           "97kxnx8NCA5dSuMK1cEXua/QgaUcd3cUDNdG59rhs8403Lov4wna3V3CC+WY" +
           "VbD04QpzR2lziECEgQto/y7bko+UtSQd/uFXYTNa56Pp8LnbVPPu/4XNyjGr" +
           "YJdjFeZ+Tpsn4ajoOAvoUipYq0dVKW1b8qn/gyXzBLWXf6a0Yn/+F3vwBJSe" +
           "WvRrCv8FQDy8P1A3Zf+NbzCALrzSNwDUZnKy7LwiOvo1mo4zEjNfA78w8hr9" +
           "JNRApUUiyA8QT2lOcNLfQO4rQUpgX7PrpH6VoHqbGpiJrunXAVDMabixQOuc" +
           "PA1DMEm7b2rlE6qvOG0yb7dWuGy4lzif4LxlXl+O/9KVFI/sX9l/6/krH+ZP" +
           "gFBjbN5MuUB1VMsfGgvZZ3ZZbhavmhWdnzYeHT/PStKuJ0inbCyoIEDZa127" +
           "50nMCBZexk4fWPzMye01r0CBuxb5wGuT1ha/NuS1HKT9tdHiK6BVCnV1Prhp" +
           "ycLM395i7zmo6BXHS58UE/efihwd+eRa9sMKfwFgzyDLNimrsTiqu+6TpYvL" +
           "ia7ikqA5xVfpCxaTcCOdYI+4fnCzEra7vqQL7BHH68E6DiHU+hB/yWifppnV" +
           "pm+Zxg75+tK5j7bnWJc2f/0PMcz1vfIeAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private final java.lang.String signature;
    @java.lang.Override
    public java.lang.String toString() { return signature;
    }
    public SignatureParser(java.lang.String signature) {
        super(
          );
        if (!signature.
              startsWith(
                "(")) {
            throw new java.lang.IllegalArgumentException(
              "Bad method signature: " +
              signature);
        }
        this.
          signature =
          signature;
    }
    public java.lang.String[] getArguments() {
        java.util.ArrayList<java.lang.String> result =
          new java.util.ArrayList<java.lang.String>(
          );
        for (java.util.Iterator<java.lang.String> i =
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            result.
              add(
                i.
                  next(
                    ));
        }
        return result.
          toArray(
            new java.lang.String[result.
                                   size(
                                     )]);
    }
    public java.util.Iterator<java.lang.String> parameterSignatureIterator() {
        return new edu.umd.cs.findbugs.ba.SignatureParser.ParameterSignatureIterator(
          );
    }
    public java.lang.Iterable<java.lang.String> parameterSignatures() {
        return new java.lang.Iterable<java.lang.String>(
          ) {
            @java.lang.Override
            public java.util.Iterator<java.lang.String> iterator() {
                return new edu.umd.cs.findbugs.ba.SignatureParser.ParameterSignatureIterator(
                  );
            }
        };
    }
    public java.lang.String getReturnTypeSignature() {
        int endOfParams =
          signature.
          lastIndexOf(
            ')');
        if (endOfParams <
              0) {
            throw new java.lang.IllegalArgumentException(
              "Bad method signature: " +
              signature);
        }
        return signature.
          substring(
            endOfParams +
              1);
    }
    public int getNumParameters() { return getParameterOffset(
                                             ).
                                             length;
    }
    public boolean hasReferenceParameters() {
        for (java.util.Iterator<java.lang.String> i =
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            char c =
              i.
              next(
                ).
              charAt(
                0);
            if (c ==
                  'L' ||
                  c ==
                  '[') {
                return true;
            }
        }
        return false;
    }
    public java.lang.String getParameter(int pos) {
        int count =
          0;
        for (java.util.Iterator<java.lang.String> i =
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.lang.String p =
              i.
              next(
                );
            if (pos ==
                  count) {
                return p;
            }
            ++count;
        }
        throw new java.lang.IndexOutOfBoundsException(
          "Asked for parameter " +
          pos +
          " of " +
          signature);
    }
    public static boolean isReferenceType(java.lang.String signature) {
        return signature.
          startsWith(
            "L") ||
          signature.
          startsWith(
            "[");
    }
    public static int getNumParametersForInvocation(org.apache.bcel.generic.InvokeInstruction inv,
                                                    org.apache.bcel.generic.ConstantPoolGen cpg) {
        edu.umd.cs.findbugs.ba.SignatureParser sigParser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          inv.
            getSignature(
              cpg));
        return sigParser.
          getNumParameters(
            );
    }
    public static int getNumSlotsForType(java.lang.String sig) {
        if ("J".
              equals(
                sig) ||
              "D".
              equals(
                sig)) {
            return 2;
        }
        else {
            return 1;
        }
    }
    public static void main(java.lang.String[] args) {
        if (args.
              length !=
              1) {
            java.lang.System.
              err.
              println(
                "Usage: " +
                edu.umd.cs.findbugs.ba.SignatureParser.class.
                  getName(
                    ) +
                " \'<method signature>\'");
            java.lang.System.
              exit(
                1);
        }
        edu.umd.cs.findbugs.ba.SignatureParser parser =
          new edu.umd.cs.findbugs.ba.SignatureParser(
          args[0]);
        for (java.util.Iterator<java.lang.String> i =
               parser.
               parameterSignatureIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            java.lang.System.
              out.
              println(
                i.
                  next(
                    ));
        }
        java.lang.System.
          out.
          println(
            parser.
              getNumParameters(
                ) +
            " parameter(s)");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "+j/6EftIvjMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "r11KQlKivfDjBNYiRmphjh5T9npJ6baf");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("NfopSpS1iT+be2hlbOkTSmyaiwWHj6sps+m0emg31mE+s7bLFRZVyfqoCXaj" +
       "S5gUNpO12oV6ZTxpRRrTNOMFiUdhOm1bG23WbdoYGap1NpvC3JCLupatCnYl" +
       "USu1SSg12IaYbCVKw+G2UIvRCLZiaYQkzXEkb1yjaQZrtKkhkC0364gc07xh" +
       "S+K4P7UnrajabDZqk44000bDuFLXBnqn3YvFORVGZq08Wk0XHdSi02FzOkq3" +
       "OMlmwjhRG/AaMeEVmo1ill9w+gqB2kNUnsazVd/3NjMBmuPoLOV1s+Ohdk+D" +
       "a7P1qM1r5UBeQSSlNelgO1nYM9zYsFbVrc3EJQWNDMgdVFWDldCkXwcrpaVE" +
       "GGZX7IYtbgdS1JMWqlGVt9VepEUmYk7MoTARvMlq4FLzcRIJOjcZ6Awx71hz" +
       "tpkwCNTbwuhqAlEw2qg1dbFRXzUp3Egzqd+ZdjbGlF4P1g6xGuq9rTAe1/nm" +
       "tGtH8dSEEdqQYhraUA3TnvAWw3YgkagpUzcpx0ajkUatGpKWpWlSlzAsarYj" +
       "gypnfd5u1zJxoOu4bZq1pb/OmknF9uspbALdFjmqZ1eNpO8yq7CPCwQM9zJC" +
       "X0d9XemXt1SzXp1wMz1ipvUMR4NVYPcr1qhSNdFeo94qL6E6aUbMZslhGPaa" +
       "1+SfW9/7o30Gvqv4un0UZPdjfNdOT5x2HB0HFH8XS2cCs04cB5w42i/lh6oP" +
       "XC92rjhQ/eBbn3xKFz5UvXBw1MFHpVsjz/9p29gY9omuLhXvy6NpXDo8lXjF" +
       "wTRecfZU4pjQa5+FviJ9phOc3z6n7F/lyQej0r1zIxqePeguztuOefyhZ/qa" +
       "frLzM3Tec8ji6gGd1R+BztIzkvjpc8p+N08+GZXuBiSKp4+LixOrYwL/9TOe" +
       "Rt131WkU77nuD3MQdQ5vLh3ygzvgDffc6MDecQW2qPCfz+HS7+fJf4hKDwEu" +
       "SUDLQyrwnKHnC6YUKcV52xHvzqjF089CLYpDuTwk4N0HpL/7uVf//3pO2Rfz" +
       "5PNR6ZbI28U6FdhyTNsXnlEj7j4+/hI2RhBYuvFsdOHePPMyeD58wJAPP/cM" +
       "+eo5ZX+eJ38WlW4HanAIBWFRc3p6jrnQ9g7mWPyPSleuDqD5mcvrWAmtdexF" +
       "xit2EXaXdyeYl4sD/ss7rr/u9Zc5gSCv8BhHSpdfc9k1koOSNyqO+vjr9vf3" +
       "X//Yo76fHovnmtEFf3l4hvtX50UX5MnB8pInxWFqEVbwF1eHFeQ/CxycXx0n" +
       "UEhuN2zROk/cc3j7v84p+1ae/G2ehLuZnFP3fx+oUaGh//1ZWN+L88w6eD51" +
       "IMhPPffK9r1zyv4hT74ble4/iuI5iv1lIqOI1Tw/GEOK1TA6EcT+q9ZTf/hf" +
       "/u7SW3ZhTaeDtIoxDpqebfflP70Bfl70yK8VQRxHkT23sKWbwrxmVLp8/TsR" +
       "RV+7CKzn7ThbhJRdO8bsvuP4xkMK94trF/6B6h0hShGJdVgHlOzddCqw69qs" +
       "uKIxzhXp019+e72I27oENpoWsMLhwWWN0xGjx1HUj526wHFNZl3Rvv6JX/3s" +
       "S/9mfE8Rmb/jSz7hWrpT1eaBAu4VCnihtAukuV4w1sGMigDXK9qb3v/9P/zr" +
       "x7/yuRtKF9nSbXnAixIYOuNGpf3rXWg52cEjQ/BGgFaPsaU7dq0BchTiPRDj" +
       "3Ue5R2HUUemnr9d3EcR3Jto6vxJie4kRtL3Y1fNuHzwTchP7/snSk2FeP6ZC" +
       "/GJQetUPwb8j8g+MOF9U01PBG3lA38lCPyrdg7OYJF0ZzkTyyhgbMFibJQst" +
       "y0Me98hDXTwR3LEL9twh8KnA1wNYKdDo758tGuXRgL9zMNXfec7RaO+hc8ry" +
       "3vYeAKy5Go12ivSDH1KaRWxsIU0gneuYd8HSwzr5wI/m5Xs3X9eW8tIfVp2u" +
       "PYG8h3uLoQoZD/PXF50vz70Hn61vl29nPnMgz8889/L8mXPKco9grwYwD7gy" +
       "g6N4OOlUyNYxpfVnQWnhwL8EPF88oPSLzz2l55XReYIBawWU8rFz5KgXlY89" +
       "9b1nDNN9pg3co+D50gGNX3ruaRycU1aoKwekuVDCo+ssx5QWbc5EhN2sep5t" +
       "KO4xA/hnq84PgudrBwz42nPDgLO7tD3lHC7kvurez+/c81P7sROa/PpnQeT9" +
       "h1L+zgGR3/kRiDz2rt/2TJRWCmqccyjN79PtLaLSJSs8dXspzx4fE2s9C2Jf" +
       "mGci4Pn+AbHffw6JPROW/KgXzPcVX9EWxr6qGfb+PN8iWdo+4268VeFm5HfA" +
       "DgOHQYuful6Lw7sZItBusNEquLU9h5NvzhPgwz5wFh2o/MbZxtOUw0tWJ6Ai" +
       "frZ8BcC/d/uu7e7/T0qJ/uk5pL8zT/7J7tMPIH33XcMLDuOiT9D7y88WGV4J" +
       "JnXvAb33/mTo/YuCpvecQ++v58kTUelGR7Hca0HijRvP0o+p/mc/CtUpMMYz" +
       "dzPzi2b3XXXze3dbWfv4U5duedFTo/+2uy5xeKP4VrZ0ixnb9snrPyfeL/qB" +
       "YVoFJ27dXQbaOS7/AiD/te+LRqULagGZe7+5q/pB4MJdo2oExj14PVn7t6LS" +
       "bce1QWfaqeKPgGXkoDgq3QDSk4UfA1mgMH/9eC5p4E7tXccxvvuZOH3iS/PD" +
       "192KcfHuBv4V7RNPdfk3frv+od0dSuDiZVneC9jr3Ly7zll0mt82eOl1ezvs" +
       "6yL96Pfu+OStLzv8dn3HbsLHSntibi+59oVF0vGj4oph9m9f9G9e/VtPfaUI" +
       "/v7/jAteexhBAAA=");
}
