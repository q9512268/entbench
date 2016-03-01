package edu.umd.cs.findbugs.detect;
public class ReadOfInstanceFieldInMethodInvokedByConstructorInSuperclass extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final edu.umd.cs.findbugs.BugAccumulator accumulator;
    public ReadOfInstanceFieldInMethodInvokedByConstructorInSuperclass(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          accumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
    }
    java.util.Set<edu.umd.cs.findbugs.ba.XField> initializedFields;
    java.util.Set<edu.umd.cs.findbugs.ba.XField> nullCheckedFields;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) { if (getMethod(
                                                                  ).
                                                                  isStatic(
                                                                    )) {
                                                                return;
                                                            }
                                                            initializedFields =
                                                              new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
                                                                );
                                                            nullCheckedFields =
                                                              new java.util.HashSet<edu.umd.cs.findbugs.ba.XField>(
                                                                );
                                                            super.
                                                              visit(
                                                                obj);
                                                            accumulator.
                                                              reportAccumulatedBugs(
                                                                );
    }
    @java.lang.Override
    public void sawOpcode(int opcode) { if (opcode ==
                                              PUTFIELD) {
                                            edu.umd.cs.findbugs.ba.XField f =
                                              getXFieldOperand(
                                                );
                                            edu.umd.cs.findbugs.OpcodeStack.Item item =
                                              stack.
                                              getStackItem(
                                                1);
                                            if (item.
                                                  getRegisterNumber(
                                                    ) !=
                                                  0) {
                                                return;
                                            }
                                            initializedFields.
                                              add(
                                                f);
                                            return;
                                        }
                                        if (opcode !=
                                              GETFIELD) {
                                            return;
                                        }
                                        edu.umd.cs.findbugs.OpcodeStack.Item item =
                                          stack.
                                          getStackItem(
                                            0);
                                        if (item.
                                              getRegisterNumber(
                                                ) !=
                                              0) {
                                            return;
                                        }
                                        edu.umd.cs.findbugs.ba.XField f =
                                          getXFieldOperand(
                                            );
                                        if (f ==
                                              null ||
                                              !f.
                                              getClassDescriptor(
                                                ).
                                              equals(
                                                getClassDescriptor(
                                                  ))) {
                                            return;
                                        }
                                        if (f.
                                              isSynthetic(
                                                ) ||
                                              f.
                                              getName(
                                                ).
                                              startsWith(
                                                "this$")) {
                                            return;
                                        }
                                        if (initializedFields.
                                              contains(
                                                f)) {
                                            return;
                                        }
                                        edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
                                          edu.umd.cs.findbugs.ba.AnalysisContext.
                                          currentAnalysisContext(
                                            ).
                                          getFieldSummary(
                                            );
                                        edu.umd.cs.findbugs.classfile.ClassDescriptor superClassDescriptor =
                                          edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                          createClassDescriptor(
                                            getSuperclassName(
                                              ));
                                        java.util.Set<edu.umd.cs.findbugs.ProgramPoint> calledFrom =
                                          fieldSummary.
                                          getCalledFromSuperConstructor(
                                            superClassDescriptor,
                                            getXMethod(
                                              ));
                                        if (calledFrom.
                                              isEmpty(
                                                )) {
                                            return;
                                        }
                                        edu.umd.cs.findbugs.detect.UnreadFieldsData unreadFields =
                                          edu.umd.cs.findbugs.ba.AnalysisContext.
                                          currentAnalysisContext(
                                            ).
                                          getUnreadFieldsData(
                                            );
                                        int priority;
                                        if (!unreadFields.
                                              isWrittenInConstructor(
                                                f)) {
                                            return;
                                        }
                                        if (f.
                                              isFinal(
                                                )) {
                                            priority =
                                              HIGH_PRIORITY;
                                        }
                                        else
                                            if (unreadFields.
                                                  isWrittenDuringInitialization(
                                                    f) ||
                                                  unreadFields.
                                                  isWrittenOutsideOfInitialization(
                                                    f)) {
                                                priority =
                                                  NORMAL_PRIORITY;
                                            }
                                            else {
                                                priority =
                                                  HIGH_PRIORITY;
                                            }
                                        int nextOpcode =
                                          getNextOpcode(
                                            );
                                        if (nullCheckedFields.
                                              contains(
                                                f) ||
                                              nextOpcode ==
                                              IFNULL ||
                                              nextOpcode ==
                                              IFNONNULL ||
                                              nextOpcode ==
                                              IFEQ ||
                                              nextOpcode ==
                                              IFNE) {
                                            priority++;
                                            nullCheckedFields.
                                              add(
                                                f);
                                        }
                                        for (edu.umd.cs.findbugs.ProgramPoint p
                                              :
                                              calledFrom) {
                                            edu.umd.cs.findbugs.ba.XMethod upcall =
                                              getConstructorThatCallsSuperConstructor(
                                                p.
                                                  method);
                                            if (upcall ==
                                                  null) {
                                                continue;
                                            }
                                            org.apache.bcel.classfile.Method upcallMethod =
                                              null;
                                            for (org.apache.bcel.classfile.Method m
                                                  :
                                                  getThisClass(
                                                    ).
                                                   getMethods(
                                                     )) {
                                                if (m.
                                                      getName(
                                                        ).
                                                      equals(
                                                        upcall.
                                                          getName(
                                                            )) &&
                                                      m.
                                                      getSignature(
                                                        ).
                                                      equals(
                                                        upcall.
                                                          getSignature(
                                                            ))) {
                                                    upcallMethod =
                                                      m;
                                                    break;
                                                }
                                            }
                                            if (upcallMethod ==
                                                  null) {
                                                continue;
                                            }
                                            java.util.Map<java.lang.Integer,edu.umd.cs.findbugs.OpcodeStack.Item> putfieldsAt =
                                              edu.umd.cs.findbugs.ba.PutfieldScanner.
                                              getPutfieldsFor(
                                                getThisClass(
                                                  ),
                                                upcallMethod,
                                                f);
                                            if (putfieldsAt.
                                                  isEmpty(
                                                    )) {
                                                continue;
                                            }
                                            java.util.Map.Entry<java.lang.Integer,edu.umd.cs.findbugs.OpcodeStack.Item> e =
                                              putfieldsAt.
                                              entrySet(
                                                ).
                                              iterator(
                                                ).
                                              next(
                                                );
                                            int pc =
                                              e.
                                              getKey(
                                                );
                                            edu.umd.cs.findbugs.OpcodeStack.Item value =
                                              e.
                                              getValue(
                                                );
                                            if (value.
                                                  isNull(
                                                    ) ||
                                                  value.
                                                  hasConstantValue(
                                                    0)) {
                                                priority++;
                                            }
                                            edu.umd.cs.findbugs.SourceLineAnnotation fieldSetAt =
                                              edu.umd.cs.findbugs.SourceLineAnnotation.
                                              fromVisitedInstruction(
                                                getThisClass(
                                                  ),
                                                upcallMethod,
                                                pc);
                                            edu.umd.cs.findbugs.BugInstance bug =
                                              new edu.umd.cs.findbugs.BugInstance(
                                              this,
                                              "UR_UNINIT_READ_CALLED_FROM_SUPER_CONSTRUCTOR",
                                              priority).
                                              addClassAndMethod(
                                                this).
                                              addField(
                                                f);
                                            bug.
                                              addMethod(
                                                p.
                                                  method).
                                              describe(
                                                edu.umd.cs.findbugs.MethodAnnotation.
                                                  METHOD_SUPERCLASS_CONSTRUCTOR).
                                              addSourceLine(
                                                p.
                                                  getSourceLineAnnotation(
                                                    )).
                                              describe(
                                                edu.umd.cs.findbugs.SourceLineAnnotation.
                                                  ROLE_CALLED_FROM_SUPERCLASS_AT).
                                              addMethod(
                                                upcall).
                                              describe(
                                                edu.umd.cs.findbugs.MethodAnnotation.
                                                  METHOD_CONSTRUCTOR).
                                              add(
                                                fieldSetAt).
                                              describe(
                                                edu.umd.cs.findbugs.SourceLineAnnotation.
                                                  ROLE_FIELD_SET_TOO_LATE_AT);
                                            accumulator.
                                              accumulateBug(
                                                bug,
                                                this);
                                        }
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.ba.XMethod getConstructorThatCallsSuperConstructor(edu.umd.cs.findbugs.ba.XMethod superConstructor) {
        edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
          edu.umd.cs.findbugs.ba.AnalysisContext.
          currentAnalysisContext(
            ).
          getFieldSummary(
            );
        edu.umd.cs.findbugs.ba.XMethod lookfor =
          "()V".
          equals(
            superConstructor.
              getSignature(
                ))
          ? null
          : superConstructor;
        for (edu.umd.cs.findbugs.ba.XMethod m
              :
              getXClass(
                ).
               getXMethods(
                 )) {
            if ("<init>".
                  equals(
                    m.
                      getName(
                        ))) {
                if (fieldSummary.
                      getSuperCall(
                        m) ==
                      lookfor) {
                    return m;
                }
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAM1ZDWwcxRWeO/87jv/yS36cxHESJYQ7AoQIDCn2xSYHZ+dq" +
       "GxccymVvb8638d7usjtrnwOhEFolICWlEAKlIaqqQCACgiqitlBQWlQg/FSF" +
       "poWUEiilavhTiSqgKi30zczu7c/dOYQfqZZubj0z7+17b9773pt3D7yPKgwd" +
       "tWCFhMi4ho1Ql0Ligm7gVEQWDGMA5hLiHWXCP6863nteEFUOofqMYPSIgoG7" +
       "JSynjCE0V1IMIigiNnoxTlGKuI4NrI8KRFKVITRNMqJZTZZEifSoKUw3DAp6" +
       "DDUJhOhS0iQ4ajEgaG4MJAkzScId/uX2GKoTVW3c2T7TtT3iWqE7s867DIIa" +
       "YxuFUSFsEkkOxySDtOd0dLqmyuPDskpCOEdCG+WVlgkuia0sMEHrww0ffXJL" +
       "ppGZYIqgKCph6hl92FDlUZyKoQZntkvGWeNqdB0qi6FJrs0EtcXsl4bhpWF4" +
       "qa2tswukn4wVMxtRmTrE5lSpiVQgghZ4mWiCLmQtNnEmM3CoJpbujBi0nZ/X" +
       "lmtZoOLtp4d33nFV40/LUMMQapCUfiqOCEIQeMkQGBRnk1g3OlIpnBpCTQoc" +
       "dj/WJUGWNlkn3WxIw4pATDh+2yx00tSwzt7p2ArOEXTTTZGoel69NHMo67+K" +
       "tCwMg67THV25ht10HhSslUAwPS2A31kk5SOSkiJonp8ir2PbpbABSKuymGTU" +
       "/KvKFQEmUDN3EVlQhsP94HrKMGytUMEBdYJmlWRKba0J4ogwjBPUI3374nwJ" +
       "dtUwQ1ASgqb5tzFOcEqzfKfkOp/3ey/YcY2yVgmiAMicwqJM5Z8ERC0+oj6c" +
       "xjqGOOCEdctiu4Tpj28LIgSbp/k28z0/u/bERctbDj3D98wusmddciMWSULc" +
       "m6x/cU5k6XllVIxqTTUkevgezVmUxa2V9pwGCDM9z5EuhuzFQ31PXXH9fvxu" +
       "ENVGUaWoymYW/KhJVLOaJGP9YqxgXSA4FUU1WElF2HoUVcFzTFIwn12XThuY" +
       "RFG5zKYqVfY/mCgNLKiJauFZUtKq/awJJMOecxpCqAo+qA4+YcT/2DdB28MZ" +
       "NYvDgigokqKG47pK9TfCgDhJsG0mnAZnSprDRtjQxTBzHZwyw2Y2FRYNZzGF" +
       "CZCF+7AAgtr4xKAzqvQwN4wqo+oITnWOR5yYiCr91FlYvIcob+3/TaActeCU" +
       "sUAADneOH1pkiMq1qpzCekLcaXZ2nXgo8Rx3Wxpqlu0JGgT5QiBfSDRCtnwh" +
       "Ll/oS8iHAgEm1lQqJ/c38BagoMBft7T/25ds2NZaBo6ujZXDUdOtrZ4E6OHL" +
       "BUiIB5onb1pwbMWTQVQeQ82CSExBpvmsQx8GpBRHLDCpS0JqdDLUfFeGoqlV" +
       "V0VQWselMpXFpVodxTqdJ2iqi4OdPylShEtnr6Lyo0N3jt0w+J0zgyjoTUr0" +
       "lRWAp5Q8TlNJPmW0+cGoGN+Grcc/OrBrs+rAkifL2cm5gJLq0Op3HL95EuKy" +
       "+cLBxOOb25jZayBtEAHCHBC5xf8OD+q12xmE6lINCqdVPSvIdMm2cS3J6OqY" +
       "M8M8uok9TwW3mERhoBs+Z1u4wL7p6nSNjjN4BFA/82nBMtSF/drdr/z27bOZ" +
       "ue1k1uCqQvoxaXcBKGXWzKCyyXHbAR1j2PfanfHbbn9/63rms7BjYbEXttEx" +
       "AsAJRwhm/t4zVx99/djeI0HHzwlUEGYSCrFcXkk6j2onUBLettiRBwBYhuCk" +
       "XtN2mQL+KaUlISljGlj/aVi04uB7Oxq5H8gwY7vR8pMzcOZP60TXP3fVxy2M" +
       "TUCkBYBjM2cbzypTHM4dui6MUzlyN7w094dPC3dDfoKcYEibMIP5gBXrVKiZ" +
       "UCQUg55Oc7gPa6oOGZ8d7kq2+0w2nkMNw3ggtnYeHRYZ7iDxxqGroEuItxz5" +
       "YPLgB0+cYFp5K0K3T/QIWjt3QzoszgH7GX4QWysYGdh3zqHeKxvlQ58AxyHg" +
       "KEIZZKzTAXFzHg+ydldU/elXT07f8GIZCnajWlkVUt0CC0ZUA1GAjQyAdU77" +
       "xkXcCcaqYWhkqqIC5Qsm6EHMK37EXVmNsEPZ9PMZj1ywb88x5o0a5zGb0ZfR" +
       "/OFBXwvrbQDY//tVf9j3g11jvDJZWhr1fHQz/71OTm55818FJmd4V6Rq8tEP" +
       "hR/YPSuy+l1G7wAPpW7LFeY8AG+H9qz92Q+DrZW/CaKqIdQoWnX8oCCbNJyH" +
       "oHY17OIean3PurcO5UVXex5Y5/hBz/VaP+Q5uRae6W76PNmHcjT20SL4rLAA" +
       "YIUf5QKIPVzKSJawcRkdzrBBpQLiR5B9mFIzAUvC/NXMmrJgl/8Qka0lIrLD" +
       "2coBl47n0yHG33lhSbft8sq0Ej6rLJlWlVBzsLiayKde+QSsCGqSFMB0ejHC" +
       "KX5LpqDtODlN4/1m0iBscJX46pVNk37yUD/mvt5ShMK1ecdjjw4NLWkU+ebW" +
       "Ipt994D79lWLr2afeosTnFaEgO+bdl94++DLG59nqaua1jMDtve4qhWoe1x5" +
       "s5Hb5zP4Q/D5lH6oXdgEq6eneFJfiFVqFAp0NNcT/n41/9I7p1YdiTdxqZeV" +
       "jn8/4XZpzwvPfthwQzHgYFdmi9RPd/SVsrMmkbbvM/XLqfrsngXRZdCdtKYr" +
       "ef1mvDiE19NByNnuPdlBSFCfTmZo6VCoekLMTRuYurTum29wwRecROOEGM0m" +
       "+g8e3XouQ6qGUQkKCt6H4a2P6Z7Wh10Ht3taAkVtkhCPH9j+zIJ3Bqewux5X" +
       "n0pOky/9Xm1FXoBFXtCqpWd7dLLkYFk+IT6/XFpV/ecj93PVFpVQzUtz7e5P" +
       "X3h787HDZagSijaKg4ION0K4coZKNVPcDNoG4GkNUAE+1nNquNqz87bOtTk/" +
       "m68/CTqjFG/aHSpSxUNSHcN6p2oqKZYivPhba2qae5V5SMMXjZnroKb6HKbL" +
       "a24BFWpmVq9nnkjTC5yPmXUvwp1sSiTW0d+fGLgi3pUY7OiLdnTGupi3arAY" +
       "6LLdudFhwnNU3tHnFsPxpBC6nCFhzp37XcVEIH8Vm+rFJR6Ta25q+OUtzWXd" +
       "cAuIompTka42cTTltXEV+KcLqJx2i5P3XCgVKG7x5ojVepif7z2Awek6aL8M" +
       "Hn056FtfQw66iQ6XQxpRTFmOZLA4YqcRurDBJ8HNE0jAl5bQ4fS8HOyvEvka" +
       "Hu6a33NCgM+lelKsn7Z3y849qXX3rOAh3ezt81AHe/CP/30+dOcbh4s0AGqI" +
       "qp0h41Es+ypCb0qwr/12efVa/a1//UXbcOepXMXpXMtJLtv0/3kTJxm/KE9v" +
       "eWfWwOrMhlO4Vc/zmdPP8v6eBw5fvFi8Nch6k7zuK+hpeonafWgDAGbqitf3" +
       "F3pvtvPgc77lAOf7HdFxscKCjz6GitwgSzHz3aF897AWVR8OCZogZnAoKWKZ" +
       "Yxzt3MFFIoWZJD+e4Bq2lw53QRHK0p4x4QUhrktZqMtGLUwJb25+fWT38Qet" +
       "YqugFeHZjLftvPmz0I6d3Il5o3lhQa/XTcObzRx26PBdGkoLJnoLo+j++4HN" +
       "j923eWvQUvBWgspHVSnlBPyPvAFflw/4vFGbXeAMrq1LKTwBRnyeKx6diPCk" +
       "v8vrR/Tu0GUdfddX4UelmJXwo+KVr+/0zopvELe1xd+yjZqwDoR+3et63k9Q" +
       "mWT94OJ6Cf33xhyjfHQCX/w1HR4BVDOEsXWaaAHK/c7JHSx5cnT6wNdxRrSx" +
       "zZo6+yyz7juVMyKoStOlUciCvoOiR3+vxfHeUwv4UuUBRzQmzu8mMPIROhwm" +
       "aMkwdvdpBzICiQiybLA2sGuBbn/ROYJnTxo8c1l3O+RAeYil4G5V74V0/JWc" +
       "UY6g9i/R36YNl5kFv+bxX6DEh/Y0VM/Yc9nLLDfmfyWqgyyXBvHdLQHXc6Wm" +
       "47TE7FvHGwS80HmdoFmle/QEVfIHpucxTvImlJBFSAi833p07/4bQbXOboKC" +
       "omf5ODigtQyRCaN78V2YgkX6+J5mn97you5FEwuPSFYfrGFSq3ouUFiMMi+Z" +
       "drKqzlUdLSx5ieox+a+xCfHAnkt6rzlx7j28GQyHuGkT5QJ3jyrel84XBwtK" +
       "crN5Va5d+kn9wzWLbCxr4gI7YTzbFS0RcGyN+sssX6fUaMs3TI/uveCJF7ZV" +
       "vgSpbT0KCHB+6ws7UDnNhKpsfaywOLdvG+1L7xpfvTz9j1dZj8/C5jml9yfE" +
       "odteiT488vFF7Me/CjgsnGOtsTXjSh8WR3VPpV/86jbZc3UjqLUwJZ/0qgZ3" +
       "hUnOjOdHYbue8t7eKIEz42qCbOGphFoffDMR69E062ZR9qDGYv/G4qmFjp+x" +
       "RxgC6H9wDf8kliEAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "sXZLBq9HvaSzdOEptxi4Qua11JqNcJUpri8sG+01JAyVqvBgpoqLptm24CnS" +
       "XIzsxobaVpbZvNklV/CiKrEg5m+7DNM1HGM3C0wQwXS2tMZM6LnanDkoJpAY" +
       "taV7Kd+q0o7mUY6twxNSMvq0n6iZsO079qBD8bjVQhC/isHocrKcc0tvSHiO" +
       "0eC6lhlPdlNCGWEtqb4wN/NmZdBw3Da285IGRabJmKcWRtij+ADxEpGyWNaq" +
       "yFo4DHJb1BigQ0v3sopSyQiDxt1N3AxzO8PA5qM32dFJbwMC4AGy3oW63ULn" +
       "nTQequGoISkNrbJx22k+Y5ZEFqJmH1sI+ZLiq1O1txtVoiiaNw1RYSNE6MPJ" +
       "VicGFCZLW5P3l0J1CILISjONMLHrjlZDPzKUXcox2rZXqTFY5htbIW+va5q8" +
       "BtDYWDt2e2eQnhbrloC2WluKwljg4WszcntcHAnzNb9qzaaINAbo3Gqul7KK" +
       "iOugcAgZrgamjKxEl1tzGr1YJnorxvRhn8zRekAsuZ6/ojzD6LLTZpusNuvy" +
       "tB10e4st3EMDh1r7lWyamUSTbqddo7WxLRLH8fe8pzj++Ik3dgL1WHnYdvwG" +
       "Z21jRcUH3sDJy+EJX5E8f3w2Wf5dhc692zh923r6DDQKoScvelpTniR9+kMv" +
       "vaxxn6ldPjy0/FgMPRR7/vfb+la3T5G68tqXIEcvFI6uyn7pQ3/yhPCDq/e9" +
       "gYcCT5/j8zzJn2Y/9+Xe96r/8DJ05fji7K43T2c73T53UB7qcRK6wplLsyfP" +
       "XtY/Db4fONTsD5w/9T2Zu7tvzEor2M/9uRvfc7fGT3mheaD4irrSD5aqbu9P" +
       "3otHOweEp+kliZ9+jUvjzxfJp2Po/vKKpWzy909Z0kdj6L6tZ2knJvaZsyb2" +
       "yLGJHbN089SB+1YPQ0vTX8Mq777OLQv+yVlFFreP5KEiyf/7ijwn8hXLjcs+" +
       "X3wNzf2bIvkFYOCRknK+CpRdFLxyoql/caGmiuKf/250Ury0Kh9GfPZQJ599" +
       "IzqJoQf80Noqsf4dWdhFtyR77yhJ/Ppr");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("6Ok3i+RLMfR9ph6fenQjrJSYUGw7Kp8cnaoomv/7Ey1++XXt7cnyJdXBCSwc" +
       "lHcklBeOEtt+Q2rOYuj2d/FmqngA8ra7XojuXzWqP/vy9Qff+rL4O+WzoeOX" +
       "hw8x0IMGYPP0Pfyp/FUfbGisUo8P7W/l/fLf78XQExe/+4qhq/tMKeB/3Hf5" +
       "Wgw9fo8uMRj/MHu69R/G0LWT1jF0WT1T/cfAhg6rgbuA9HTl10ERqCyy3/CP" +
       "Zuld9zSjArH2zsPHQFHdkmsvzC6dXXeOreHm610tnFqq3nHhTTCb7F/43lFf" +
       "eXkw+uFvNT+zfxMFJjHPCyoPMtAD++dZxwvKsxdSO6J1lX7h24/+3EPPHy1+" +
       "j+4ZPvHEU7w9fe8HSKTjx+WTofwX3vrz7/7sy18tL67+N0ARnZt4LQAA");
}
