package edu.umd.cs.findbugs.classfile.engine;
public class SelfMethodCalls {
    private static boolean interestingSignature(java.lang.String signature) {
        return !"()V".
          equals(
            signature);
    }
    public static <T> edu.umd.cs.findbugs.util.MultiMap<T,T> getSelfCalls(final edu.umd.cs.findbugs.classfile.ClassDescriptor classDescriptor,
                                                                          final java.util.Map<java.lang.String,T> methods) {
        final edu.umd.cs.findbugs.util.MultiMap<T,T> map =
          new edu.umd.cs.findbugs.util.MultiMap<T,T>(
          java.util.HashSet.class);
        edu.umd.cs.findbugs.asm.FBClassReader reader;
        try {
            reader =
              edu.umd.cs.findbugs.classfile.Global.
                getAnalysisCache(
                  ).
                getClassAnalysis(
                  edu.umd.cs.findbugs.asm.FBClassReader.class,
                  classDescriptor);
        }
        catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
            edu.umd.cs.findbugs.ba.AnalysisContext.
              logError(
                "Error finding self method calls for " +
                classDescriptor,
                e);
            return map;
        }
        reader.
          accept(
            new org.objectweb.asm.ClassVisitor(
              edu.umd.cs.findbugs.classfile.engine.asm.FindBugsASM.
                ASM_VERSION) {
                @java.lang.Override
                public org.objectweb.asm.MethodVisitor visitMethod(final int access,
                                                                   final java.lang.String name,
                                                                   final java.lang.String desc,
                                                                   java.lang.String signature,
                                                                   java.lang.String[] exceptions) {
                    return new org.objectweb.asm.MethodVisitor(
                      edu.umd.cs.findbugs.classfile.engine.asm.FindBugsASM.
                        ASM_VERSION) {
                        @java.lang.Override
                        public void visitMethodInsn(int opcode,
                                                    java.lang.String owner,
                                                    java.lang.String name2,
                                                    java.lang.String desc2,
                                                    boolean itf) {
                            if (owner.
                                  equals(
                                    classDescriptor.
                                      getClassName(
                                        )) &&
                                  interestingSignature(
                                    desc2)) {
                                T from =
                                  methods.
                                  get(
                                    name +
                                    desc +
                                    ((access &
                                        org.objectweb.asm.Opcodes.
                                          ACC_STATIC) !=
                                       0));
                                T to =
                                  methods.
                                  get(
                                    name2 +
                                    desc2 +
                                    (opcode ==
                                       org.objectweb.asm.Opcodes.
                                         INVOKESTATIC));
                                map.
                                  add(
                                    from,
                                    to);
                            }
                        }
                    };
                }
            },
            org.objectweb.asm.ClassReader.
              SKIP_DEBUG |
              org.objectweb.asm.ClassReader.
                SKIP_FRAMES);
        return map;
    }
    public SelfMethodCalls(org.objectweb.asm.ClassReader classReader) {
        super(
          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "LR4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16Dazr1nkY3332s/3s+D3biZ26sWMnz90cpZeSSEkUnHQh" +
       "KUoiRVGUKJISt/aF/yLFP/FHP2ydJQG6BCuaBq3TpVhiDEWKtV1ap8OCDdg6" +
       "uNhPkrYpmqLYmgFLimHA0nYBGgzthmVrd0jde3Xv9Xsvyf4EiDo65/u+8/2f" +
       "j+ecz34Tuj+JoUoUejvbC9Njc5seu17jON1FZnLMsA1ejRPTID01Saag77b+" +
       "js/d+PNvf3xx8wi6pkBPqEEQpmrqhEEyMZPQW5sGC9049FKe6ScpdJN11bUK" +
       "Z6njwayTpC+x0MPnUFPoFnvKAgxYgAELcMkCjB+gANKbzCDzyQJDDdJkBX0A" +
       "usJC1yK9YC+Fnr9IJFJj1T8hw5cSAAoPFv8lIFSJvI2h585k38v8BoE/UYFf" +
       "+Ts/cvMfXoVuKNANJxAKdnTARAomUaBHfNPXzDjBDcM0FOixwDQNwYwd1XPy" +
       "km8Fejxx7EBNs9g8U1LRmUVmXM550NwjeiFbnOlpGJ+JZzmmZ5z+u9/yVBvI" +
       "+uRB1r2E3aIfCHjdAYzFlqqbpyj3LZ3ASKG3X8Y4k/HWAAAA1Ad8M12EZ1Pd" +
       "F6igA3p8bztPDWxYSGMnsAHo/WEGZkmhp+9KtNB1pOpL1TZvp9BbL8Px+yEA" +
       "9VCpiAIlhd5yGaykBKz09CUrnbPPN7n3fOxHg35wVPJsmLpX8P8gQHr2EtLE" +
       "tMzYDHRzj/jIu9ifVZ/89Y8eQRAAfssl4D3MP/6xb73v3c++/sU9zPffAWak" +
       "uaae3tY/oz36lbeRL7avFmw8GIWJUxj/guSl+/MnIy9tIxB5T55RLAaPTwdf" +
       "n/zr+Qd/2fyTI+g6DV3TQy/zgR89pod+5Hhm3DMDM1ZT06Chh8zAIMtxGnoA" +
       "tFknMPe9I8tKzJSG7vPKrmth+R+oyAIkChU9ANpOYIWn7UhNF2V7G0EQ9AD4" +
       "Qo+A74vQ/lP+ptASXoS+Cau6GjhBCPNxWMifwGaQakC3C9gCzqRldgInsQ6X" +
       "rmMaGZz5Bqwnh8EyZAtOAKINGIQF07OGpf+RquclxwVm9P93um0h/c3NlSvA" +
       "MG+7nBY8EFH90DPM+Lb+SkZQ3/rV2791dBYmJ3pLIRTMfgxmP9aT49PZj89m" +
       "P97PfnxpdujKlXLSNxdc7D0B2HEJMgLIlY+8KPww8/6PvuMqcMFocx8wQgEK" +
       "3z1lk4ccQpeZUgeODL3+yc2HpL9ZPYKOLubegnPQdb1A54uMeZYZb12OuTvR" +
       "vfGRb/z5az/7cniIvgvJ/CQpvBGzCOp3XNZxHOpAfbF5IP+u59TP3/71l28d" +
       "QfeBTAGyY6oC/YHE8+zlOS4E90unibKQ5X4gsBXGvuoVQ6fZ7Xq6iMPNoac0" +
       "/qNl+zGg44cLb38afCcn7l/+FqNPRMXzzXtnKYx2SYoyEb9XiD79B7/zR0ip" +
       "7tOcfePcKiiY6Uvn8kRB7EaZER47+MA0Nk0A9+8/yf/MJ775kb9eOgCAeOed" +
       "JrxVPEmQH4AJgZp//Iurr379a5/5/aOD06Rgocw0z9G3Z0IW/dD1ewgJZvuB" +
       "Az8gz3gg+AqvuSUGfmg4lqNqnll46f+48ULt8//5Yzf3fuCBnlM3evd3JnDo" +
       "/z4C+uBv/ch/fbYkc0Uv1rmDzg5g++T5xIEyHsfqruBj+6Hfe+bnvqB+GqRh" +
       "kPoSJzfLbHblJHAKpt6SQs+EsX0clpl7Y2rHauLvV5SJqYIAL00Ll7DvKp/H" +
       "hVpKClA5hhSPtyfnQ+RiFJ6rWm7rH//9P32T9Kf//FulTBfLnvMeMVSjl/ZO" +
       "WDye2wLyT13OB301WQA49HXub9z0Xv82oKgAijpY65NRXHB+wX9OoO9/4N/9" +
       "xr948v1fuQoddaHrXqgaXbUMReghEANmsgBZbRv9tfftXWDzIHjcLEWF3iD8" +
       "3nXeWv67Chh88e5ZqFtULYdAfut/H3nah//Df3uDEsr8c4fF+hK+An/2U0+T" +
       "P/QnJf4hERTYz27fmK5BhXfArf+y/2dH77j2r46gBxTopn5SPkqqlxXhpYCS" +
       "KTmtKUGJeWH8YvmzX+tfOkt0b7uchM5NezkFHZYJ0C6gi/b181nnL8HnCvj+" +
       "RfEt1F107Bfdx8mTlf+5s6U/irZXQEzfXz9uHVcLfLyk8nz5vFU8/sreTEXz" +
       "r4LgT8q6FWCAZUn1yomJFLiYp986pS6BOhbY5JbrtU4j5WbpToX0x/vib5/2" +
       "iidakti7ROuu7vOePVS5vj16IMaGoI78if/48d/+qXd+HdiUge5fF/oGpjw3" +
       "I5cVpfXf+uwnnnn4lT/8iTKXgSAWXtT+y/sKqty9JC4eveLRPxX16UJUIcxi" +
       "3WTVJB2W6cc0Smnv6cp87PggS69P6kb45ce/vvzUN35lXxNe9ttLwOZHX/nb" +
       "f3n8sVeOzlXi73xDMXweZ1+Nl0y/6UTDMfT8vWYpMbr/6bWX/+kvvvyRPVeP" +
       "X6wrKfDa9Cv/5n/+9vEn//BLdyha7vPC/wPDpjf+WR9NaPz0w1YVTd7o25mE" +
       "Tf28r1s7ZcTgPFNFM5q0Fq5H2qGtDnSkR6PKRuf9oUS03KSlI0qvAqdsnOZt" +
       "dzkmlwtp7IikbRORAA9cMhu4ywG5WhGY6NshI+BeOladsWjTkoDXqytqIqFj" +
       "PW2zdQXW0BbTJOue38h4njd9JLBaWLWNTXqKpvhLpx4m29WcU5NZk1NUYUqv" +
       "fWoVLWV9tPEiyoqZWUU3eSZXDErgqqE6ac5iqqsk2aK3UMOG2hgn0lRgBSUa" +
       "xnpdbCxwV5EGrB8NBRGZpB65Hcd0jwyF1W5ja7U+JeOU7g2XrsoMJZ7pLpZG" +
       "gi83iTtmODTIfWza2qRZWzDoZRNTqwTSlDt5vqhX+7QdmPJWXMR6nFQHusxO" +
       "u31X0CVnLcjTuNOtGrNoWJP8oectkgxZTdj5IF4uTMmRO11xV7esvsabZDIb" +
       "z82lOo3dVtfr1DhWAryzy4WyTqWKR5iJrztZNFUGDd4neuEyCKodW++FRqcv" +
       "o+0B67b5QSiRG99IsKEuBHLPJQwn6qT0liGGK5mcChbVwlGxp6z50XLe1xpC" +
       "E7GTZNfN2hbVhlsoXU/5Juqx6mg5MfqCSVQVNunbyy41HpC15UoOao0ZXeWq" +
       "scp1ibofrQYRGbY0qo7I2GrOxJSz4rAJuUPljhzvhnlNsSdNgmsNw2G7Vq3r" +
       "aW63WNhv1GbRtG+nBu9KMxKlDJPYiPMu62s+o+GtXn0mLwas1+su5W1ANNwu" +
       "yuE0oc6aRDLrm7y/kpiE6qiLuR8u3bk8RflIlYf4yEv6eD5WZEmQBsNYXY7G" +
       "jDrf+lWS6eikvyUkIs9IfLxQqO58SoxITagOBmMvQNBKPcijIMpqU2lF1Yak" +
       "odcmMmY1clxdxovOhMLawhLFdTKRvRpm9yKsHRiUSOMmRdHysIO1GWUqNfN0" +
       "tB4IdtfTcVlhDTeTZHFe8Xu1iiH6TqPBqGtK7YRSMhi4MD6yzJ3HIlM5p+1N" +
       "IDS7fSpv+BuzN4sXWZqYEVLhlsM5ITpWrMYUbqRjv7mROqLqNRhDDgfTntrb" +
       "EfmKUViMrxKiDefRgJkkWugFLT3s7chcYhtiBPPwWJw0aJpy1FBohJlUU+oN" +
       "WmNyXtjMFxGBViJ8WeHFKYbJ7R6Tsa4Z9nuMFAhdqs5H1Y1R0SyH6vd2NLfe" +
       "mkRzOJASPakM5IFuNpoGoQ8lNGmMBruGXNt5mKzhI3o+65Bm5EeVJZdaY4+R" +
       "BiiwxhpGMoLZIXlXEjejgTyhR+QuQmukYuQSldMVDLyHYLAhuHni4g2D4DQt" +
       "3OrkwOqjvDDXhrJerfNZc9rdms62Olr5ETq3RttaQgsbvD1dEpQNzF1jRhUU" +
       "vJ5mNUu07aUqtjicHDtNOiJVymvN9R7TnrgtkNva/Tbq1fKqRcfkJPLqE9nr" +
       "TodcH/F7w/HG1Jk61pwnDFldG7scaYwbQ3M1z/Bq4seK0tHIkKs445qu1CeV" +
       "KTqY+kqnjzZm+S6RWtXKqMVkTcucao2qQTOMnWFDV6FGyzE/lwjERvzqjJyv" +
       "KAFRDIuZblA46fIIvpwDSy6iZLOZmpI94cJsY3bYXTObCdWGFxhVtVEfGfi4" +
       "pwsrYusokoW6FI41A8kZwayA4zl4rR3aK831QMk9cZV102MtsqXJXF4xO7K+" +
       "7RK1KhXs+tocXiKtYK6OSFRsh7V6NxuQDbTFVhOtwiFwa2OYaMZUq9XKIO60" +
       "B2Lbisjelokb1V6ST3ltrnCC3U9bs8qqUslhNVVmGkuRSdyf2N2hToHYGdNz" +
       "tzHawYbB7wxqY1gusqjnDol0W9yYjiSdCXoGN2zhDLOtu4FukXR1tcWzqp85" +
       "tV4KymrPXMZUPEmslgS0blQRWKvu4mRMi9IWzeUgauIp0qqbAavtcqNST2ZM" +
       "bejMfbeumDLuIIGBenw6FBtxz2xMMquORO1aU2wved/uLdLBNAk7GF5LV7Ab" +
       "6U2S8nBkW6eb01yZckQ2jWmGtpecaEcuJc2SySKvWy7wPrljdzdrPdvIPakx" +
       "MychYTXJVX1oDeG4j2FaxXIaYmMXzAczP0UXxM60pUnodkaCaK9zXN+4ClNz" +
       "XXw2WywxWE6bUZ+3R3QoMsKCZ3t1v+/mNo/Mqywfw7AbN/IMWUsRSy9SJmxG" +
       "bDavCkZV3BHIDpez4dih1j2uiY0ZtyPh1DBWGrI4lCp1kK7mkhcQ8Fju6Mos" +
       "qXABGdTy5o6mpggx58byaBtUSBC+222ssHANpNTIwFb4djJM4onK61yczDmk" +
       "1amP6zC7GXndWoob8aKPhrYCY5tWhd9aattsTUg8ijvGaIh5YkOozQyfoLGh" +
       "gu8mlrYL2zMtX5twm++s6nCSLMlaHo+W1eaGr8zwyShebSwY60rmesR3Jvpo" +
       "5tbhFhV0YVl09Lky4DvTxrY9jPJGP3HXA1SitQpYnVCnbYVdEjXVLh6hHSOg" +
       "vFmgt7pmk4jxeXeS9fNtrOGcIroxohtrB+2FVr7oz+erqTEkJlFnxzRq3Qxb" +
       "jxe9tTXWBFrF+O28JmtZNF/rBtXWG2s9rQ5Dk+71B02CH6ItUg63Y2rV6os7" +
       "u03hrDAx8240ZgS7t9usJobsVcZ1R1u7K83sbhTMsEUK1yy7ai0Mut5OeEyR" +
       "kDlZb4zjuVIzbLvVpGq7cIltZlhN7wQ6nNvIrEt4AzcltXQ0y1B5l7kUk/lK" +
       "qA254aJj1a3WaEsNg2A7Hi6IjKE6HWNtma0ZNq23iJk5YFepJ4ucu233je6O" +
       "7E92O5NdZ77YWvSINawHbjBE4Qwh5C03FfFFxEsGKJLkKGjSetLfCq0sy/oj" +
       "z4PNaq3ZoqwtZnfGImfKPr1AaEKutxEn8q1ZvOm5Ux7LalqIbZSVFKTb4WKN" +
       "dvBlIzLaW4scgrqkE28qzWmMD9ptTeEzDa0vgla32nBH9I5CBlFKhOGigwZz" +
       "25jUVzDnx2uuwXNtnDU8sTPKvXAsrFB8gmGsvKuspVRH2uiAAmHbzHB0zJsY" +
       "tllPlhavKWJXJ+Wgw8stN28JNNuWzFG3vUVWdXPeoIBKhcmuI5GwSjEbGdRF" +
       "i5XVbmJRt2cJrMyssOq4koxoY7fsz9YBx9fSrAvi16jM+NFUWfVGMOq3xFne" +
       "m00yZKn7c2m7YDFiTNRiWpjUOUkGRbSdovM1N+K2sh6MsbyZgDxZ0xFCqg5Q" +
       "q+Z2t+qws4Ojiq8a2KybVeGOLs7NQW8qTLewZUwpvifUp2Q0FdGwNuaHaY2I" +
       "Wl5ANTccTOiSRPk9K1iiWmo2141NRI/g8catY6YytzIWaWjKrBYM1kZv1dmO" +
       "e2arv96MXN3t17LYYpHFtInBjLfQpLlco4do2kGQys7WW9PtLmVm8njk9i3B" +
       "Ubu1YUTHXNQJGm3cIBZ+b4Ozy4DMN/Rc3/JS2mzNjNlMbA35DqPGk4ZFwut5" +
       "s7cJQKltxvWwoRAJx0y3DqotkIooV9eMZJmK3CTj0bg/zhrVxqSuNz0k23i6" +
       "kMMwk46xQFwuAyQyehqaeRNYWU3W6oBYW9rAkpsJ4eei2xVCApNtr8PXMm43" +
       "qdNDpDHczBQZ7se4OJejUK0zfIjMOmuxn+8ku+ahTZB6LZ+07CFnsnG7jcT1" +
       "rLvAUTearzzOqSi0BneXoW70V71NJk4sN3Sn8khExwlr1daLJWuiPBvzslet" +
       "u7UaqRlws9Xa5KRWnUmqamNZFYlBYGtCLxwhBIrQNRVRxN1ys3A4ByX7GWsb" +
       "NZUjxT47IjKki8reIk5gNBVMjJm0BMIxonbepqWV4bDxRmh3dj09rgxzWoy3" +
       "k4VSGwwq/Q4iNWt9Ie00Fl4rTRgKW1XyGQ73HXaCNavcYIMNyZoGE5VdUJe0" +
       "kF5xtbYoSZU5Njf1UTJamnMprzvTphpycF+mlibIU06Ktx08CFBPJyuzJSjB" +
       "Q18Z2QqiLS1sLNMsIY57GmFPYWQ82XpRe4Arju4QLZkbr9JYc7kp2eRgrC/k" +
       "BLNswBpwWSmfeVlmqLMAb7JWorYakoRVQCa0trTHUHy/tVhhWD1gg8Z8TQuE" +
       "1teShONG65kj6vB61FrFYr8b1XwkrKhIY5U7q6DZC6ddWF3VdLmCM3N8mE/H" +
       "MaF2g9BPVnyqGnxuR3qlncTrjFNtPY1olQRlU83SO66CiwyfgKJioS0romEz" +
       "XGgGWYVHkEZ9nVtIheH71KTaobLVpm4tq9ba7PcXKzQdxpUeJiQYRao9X+TI" +
       "WF74XuoMVyAbkMaK2dUaG3nHOcN4F2XLal2JVMr1TScDr4nhiqk3KKyrYK4w" +
       "RXageNrysDrts+PhaFPtR8tNxiWzQaLP+hzsitvchDeYo85mOTtBwcv6e99b" +
       "vMbf/t52Uh4rN43Ojg9dr1UMMN/DDsJ+6Pni8cLZdnT5uXb5yOn8dvRh9xEq" +
       "dkWeudupYLkj8pkPv/KqMfqF2tHJrq2SQg+lYfSDnrk2vXOkjgCld91992d/" +
       "TnPYTfzCh//46ekPLd7/PZykvP0Sn5dJ/tLws1/q/YD+00fQ1bO9xTcc115E" +
       "eunijuL12EyzOJhe2Fd85kyz319oDAbfyolmK3c+zbijFxyl0ANR7KzVtKTd" +
       "23vBpe3xkw320g9KgPU99s/LR5RCby7Pqs0EVOG2cHZGXgyK5xxoDubXwtAz" +
       "1eDgXKvvtD11fs6ywz/TxgtFZ+1EI6ea+a61cYiJOyri6MSnTvZPf/De54Gl" +
       "x3bMRI+dqDjzv6cnCpmWpOdOvn/SefXLv/lnNz603/K7uIFZXn44Qb2M99U/" +
       "uFp/OL31U6UH36epSWnXB1no/qSATKHn7n6RoqS13518+LBtDd152/qJC6cb" +
       "e7GjaHuqmzcdjirAcNH5sQtbnXdWwG2d9m8Ln//qR5rlTuaNtZM4qWlMT+51" +
       "XDwyOhyjvnThrscdVXRb/8ZrP/nF5/9YeqI8xN9ro2CrsY1KnrETb7taettp" +
       "7njhLgyfcFSecN3Wf+xTf/HlP3r5a1+6Cl0D4VrEuBqbIJxT6Phud1/OE7g1" +
       "Ba0OwAKB/+geGwRNadQT4z1+1nt2jgrc7260y23tS8etxe0RL9yYMRFmgVEe" +
       "rVzKMlkUnR8t3eCR/103+EAMvfu7UN2Z5KcrxOOlu587Syh2t88PgszyBMni" +
       "gnB7Ouep2xI+oXGCpUoHi8DgFekOpxv7s529b37iLFU8UdB8871SxQeKn7+b" +
       "Qk/xkxFJdcQJdXHWEuyDxazTovX3TmYoHj9X6u/TB74Ge4h9Et1eWO3Kzh+/" +
       "R079B+U8KfSIbabF9YLyYkEJ+dEzac7udDx7Is2zewPN/u9csthbOCtKF2Dm" +
       "kwsc/89on6WR5++UYvdZ5QS+APy1Evzjd43ji3b/vmL46cuaKkZfK6l97mC6" +
       "X9u71MF0P3+J1pMF6lPfA61zbvDzl9zgsAB+6LtZAM+tyoBSCt24dPGkOEV/" +
       "6xsuwO0vbem/+uqNB596Vfy35d2Ls4tVD7HQg1bmeeePM8+1r0WxaTkl7w/t" +
       "Dzej8uc3UujWd3M1JoWu7RulDK/vkf9lCj1zT2RQ2Z21zyN+AWSCOyCmQIST" +
       "5nno30yh6wfoFDrSLwx/GdQhJ8MpdBU8zw/+LugCg0XzK9HeflfuYrnHv5Pl" +
       "zlW477zrijXM9ncab+uvvcpwP/qt5i/s75oAPeT5yZLwwP7ay1kd+vxdqZ3S" +
       "utZ/8duPfu6hF05r5kf3DB/qoXO8vf3OFzsoP0rLqxj5P3nqH73n77/6tfLc" +
       "9n8Bn4iB8GoqAAA=");
}
