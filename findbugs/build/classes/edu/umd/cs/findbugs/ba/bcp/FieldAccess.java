package edu.umd.cs.findbugs.ba.bcp;
public abstract class FieldAccess extends edu.umd.cs.findbugs.ba.bcp.SingleInstruction implements org.apache.bcel.Constants {
    private final java.lang.String fieldVarName;
    private final java.lang.String valueVarName;
    public FieldAccess(java.lang.String fieldVarName, java.lang.String valueVarName) {
        super(
          );
        this.
          fieldVarName =
          fieldVarName;
        this.
          valueVarName =
          valueVarName;
    }
    protected edu.umd.cs.findbugs.ba.bcp.MatchResult checkConsistent(edu.umd.cs.findbugs.ba.bcp.Variable field,
                                                                     edu.umd.cs.findbugs.ba.bcp.Variable value,
                                                                     edu.umd.cs.findbugs.ba.bcp.BindingSet bindingSet) {
        bindingSet =
          addOrCheckDefinition(
            fieldVarName,
            field,
            bindingSet);
        if (bindingSet ==
              null) {
            return null;
        }
        bindingSet =
          addOrCheckDefinition(
            valueVarName,
            value,
            bindingSet);
        if (bindingSet ==
              null) {
            return null;
        }
        return new edu.umd.cs.findbugs.ba.bcp.MatchResult(
          this,
          bindingSet);
    }
    protected static boolean isLongOrDouble(org.apache.bcel.generic.FieldInstruction fieldIns,
                                            org.apache.bcel.generic.ConstantPoolGen cpg) {
        org.apache.bcel.generic.Type type =
          fieldIns.
          getFieldType(
            cpg);
        int code =
          type.
          getType(
            );
        return code ==
          T_LONG ||
          code ==
          T_DOUBLE;
    }
    protected static edu.umd.cs.findbugs.ba.bcp.Variable snarfFieldValue(org.apache.bcel.generic.FieldInstruction fieldIns,
                                                                         org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                         edu.umd.cs.findbugs.ba.vna.ValueNumberFrame frame)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        if (isLongOrDouble(
              fieldIns,
              cpg)) {
            int numSlots =
              frame.
              getNumSlots(
                );
            edu.umd.cs.findbugs.ba.vna.ValueNumber topValue =
              frame.
              getValue(
                numSlots -
                  1);
            edu.umd.cs.findbugs.ba.vna.ValueNumber nextValue =
              frame.
              getValue(
                numSlots -
                  2);
            return new edu.umd.cs.findbugs.ba.bcp.LongOrDoubleLocalVariable(
              topValue,
              nextValue);
        }
        else {
            return new edu.umd.cs.findbugs.ba.bcp.LocalVariable(
              frame.
                getTopValue(
                  ));
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jRtdQRbUThcrjVAyVrHRbDWaowM0JsOptmq5S0KbhXZMEG0FxWJAkzAH1IR1" +
       "E5pks2HakZQKS6a17VIrR0M2qpm4RvJosJmsxkaVjG0fVBrlWp1vJSntefho" +
       "J4d13ypp8rwLugJjTbO0ipbq5dbWNNds2GpMWjODwafDNu2LStbvRuVpTw9G" +
       "oT3sWXVVlO1Ro2ZWDKxFO45S91abQJ+aBD2aD73OztvWABAss9+wQKcTlWSH" +
       "XnR3VGh1WJWZuOjSCR22v61UeVck2BrlD8hmFFSmHbEWse7QcDdzLu6hUw5b" +
       "V3d0SeRVu8TANMDHWqw3caKhlqpts4o30pqo7Hx9PiCkeDnY2c2MaqquUN/W" +
       "+U2dT3r1AK96i9piYm1qdUIkGB5rSh07aceuMLe3W2CSqDGBu+iNBpM7brRQ" +
       "QtaXoNzYeRxcX4JaUKtQusLxohmCLi96lsqToWGhYquy6lWn+E5QrZ4yVepi" +
       "Y2Auo5LXjGkfEJa6Q3kS64AkCrl1a5N0gu5yyPG1zoLsdVyjA0JCqftir74Y" +
       "q0BB0bjH7aZrgJep9jQdeXBeAIn6zGy+3FiADeYQ0TTHqihbzVpy5G5RUz2S" +
       "b8pzU0YbXNNeYeyyLum1Fbkz8AbamAVRv7XpTVSxZw0SwSXGTX+wziqbAB/g" +
       "aA0jS1ZJXLKkLKJmJneFtNRcWU3N6/Z7FoqKPXay8wap7KMLf1GTRTHVJQuY" +
       "uMXVOnwlq4DtrGpsaFeo8muhLpZGOJniwnjet1vtzoydcMPWYqu029DhEN4b" +
       "0zLdHoGm1sLUuloJRn5tKrV7pcjYosv2LvFnzUEjrExXaae10nAucuzRtNJH" +
       "dzPa7TTrSq2kDifrCc76C8UtOUk0kWdDGa57TZpmMi/YzsqeQwkQrNbcsNsf" +
       "aslOqW0SVcKCispn3VF1VO5Z+MCfRAavxUuB4LgEri4saGOuvJP4DqPN5pvd" +
       "fDdtU6odrhmX9Lde1qZpmB6NEetgpjtCWzK+LTPV8WI9ovX2SI8aDjsezOT5" +
       "ICLcseSOOZXJNh1/ptDwja7ELTwMdMOGGNgNaHJbNuuN1RAI8zLaaixKa3uM" +
       "l3CvD4bLitRfhZoz28hbXYmpWHPZko6X9F6P1DqcOURbNT2o1FlV7+v0bFpK" +
       "ecdZVEBGMYnObBaiU20msb3G5WTdETA805bReFwyrUi1lhaK9xXcmydi23LV" +
       "XW2XBJxgm1g/4OuNmCf6MHj9gG0sp6pXcbOpPp5ChABrfsr1PLPTWHYkbyL3" +
       "CUJ0LPjiqs8YGSttOY4e6HIwLzvMRMCcfr1a72rpXPZsRU2ISWnYmHU5QSHL" +
       "JFsvOe24HLX9jSXQA6BjLtNgzOk4S1GbDe2WzOhKp8GoVKCQir6BLlQHXqNk" +
       "K0AvzTCAkXw86weLiqKvLWMel2uT9pZwXTzAtkzJaZaXm1QJeK9ltwgXVUlZ" +
       "9SfGOKBkdhvMccrvkI7LyHp/y/bDkGpXjNWO4GldnGGYvfWXFD5maku4kZQq" +
       "fY9MqRUaLQa9tkv0wi4/pfi2LNRamrnxqyPL4Eat1dySdUnzKoCUZAvfWu2p" +
       "3UI1NFuKjU3YZXkvNEKKIRg8lvn2vLGeLUqEPC9JLbzSr6ttdNWt81g6HRHJ" +
       "Lq0Nk94y0ISeQ23bzaUQmIkBVqI/7tf6LckayG6Dlzq9miLIajDUsNqOMyr1" +
       "xrQnDjSI3D16NmhOKmlDhg7K4P4NFXpWbLs1ILTJsj7Uw/WiRrVIVdvx88yV" +
       "W93duhtWW3iMza04WOzApEX0IdRT/WE2E2HirPG5UjHSCrMCu3kV7jIGXSv1" +
       "V74RJu3+qr5zN9MAzTLSiJUs6cjbPj3W+9zQCDS8YbA7gjOMjRiBXTBv7OqO" +
       "jWXLzZLAcGcwxLdar9OZ7ZT5miUt0kQ9s1cCRFqOZkqtY03cLBt6jL9akk1/" +
       "MyRww2VGXcXe1X0wa2LRnLbNzFs62HYXznpUbxd76XpdRROq0g39eNoeNnHQ" +
       "3PEruVaJd1s6alhxv6QO8OqSo7OeqjVdzRE1ihkHq0a6wKZLFYIfvV0p8UDx" +
       "Am/abI0wmqlNJu0x4VStFjfwUYvfTBNMlDFqWB6odMkR+upqZtuAE61gIqM1" +
       "yemHhuYTPqiphs0tMbvSlsp40uXKhNLBRUXS7LRlqtRAIEbqxGFW8aBJTXtj" +
       "w3CnAGdTld+taUtZtxO2g0oK2bGVXkmWiWXAroEYdMTWsBLsJok8NJgekLR1" +
       "O5xvuCq5xUxNmqdZMvWnuuDj40BrGarPT0Pcs9nKLljVWZGHC912vV1mU+CF" +
       "nBnomQ4EfRplatPkpkln3IMbg7BNqyVcEPWRNyHEfpWvjKakU27Uq8LCbwnV" +
       "2G00dctqdoWsrZY5MhU7oSXbKboWFtVKzTdbfa/WzyRGs9jYFLaLFTPo1+sG" +
       "pwgrOfMnWWR06npDi4UWzjT4MNYNnaXxAebSm3GpzME9TbbF3DhQG6LYUpQu" +
       "PVY1Z6nXOLnWXIblrTbzm/5O7chS3IiUwXy8aLIL1LNLCSCBhdLr0jaKOXQj" +
       "ssqY5ODeHL7kvvnN+euv962dQNxfHKyc3Dl+G0cq2S2Ok16XIndpepLGmpGe" +
       "HoUXn6vIhUuss0fhpyegl46PkV8WxvNDLdIMGxzqBvAOTy6c88OIh292E1kc" +
       "RHzs6WeeNYWfxg6OzpbnKXJ3GkZv9MAaeGcGuwwlvf7mhy6D4iL29MzzD57+" +
       "h4fkt9jv+BbueV5xQc+LIn928Nxnuq8xfvQAuXxyAnrdFfF5pifOn3teiUG6" +
       "igP53Onnwye+f+j4ZJA+8j198ZTwdOqvm9NL0G9RHKbASIG5j6ALJ/iXj/x4" +
       "NGmvusWd3ESLiwuJnPR9xwyvvgVDG/52grkE0mLo997i8uCH8+LdKXIVRovh" +
       "5pHiJCk4+nPCi299VzjQUsMegWTlpacJ8PQ3O3o6q0HR8H0nLn84byzB521H" +
       "Ln/bt+DyIo3eU+TtDR1+4bLldRezZJ4fNzvG6VF/fjV4HKOQ4bU3YzhOLzEM" +
       "vS4IisE/fAuX/1RePJMi9zpJfpAqxJ1wBWe3oNXPYIiVInfqUCbQglP3fvB/" +
       "4d5H8sY3wic8cm/4f+jey6fg+ZN58ZFjv5VuEkHrQDssbjX2B8U0TH5QSH7u" +
       "guRL5+GtfBN5HS3VLC/cEIHmbWEUU5kBonwCC6GfyoufgXGeBFps0fvLBDj4" +
       "aU4V7v34t+LeLEVecOa+PL/8e+l1/8bZ/4PE+Plnr971kmfHf1ZcGZ/8y+Nu" +
       "DrnLWnne2duYM/U7ohhYTqH/3fu7maj4+tUUeejmeZkil2FZaPsre/pfT5EH" +
       "b0yfIge6dpb0t1LkRTcghavTcfUs9e+kyJVTaijMONf9ezCCj7qhUrA82/lp" +
       "2AQ78+pnouPJfcMt4EaCkOaBM5mZXTqzIh1FezGLD3yzWTxhOXtvna9ixX+u" +
       "jlec1f5fV08an3yW5d/51cZP7+/NDU/b7XIpd3HInfsr/JNV69GbSjuWdUfv" +
       "8a/f+6m7X328wt67V/g0887o9oobX1JTfpQW18q7X3nJL77pZ5796+Jy5b8B" +
       "fWOVnQwnAAA=");
}
