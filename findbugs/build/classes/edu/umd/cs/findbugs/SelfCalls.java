package edu.umd.cs.findbugs;
public class SelfCalls {
    private static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "selfcalls.debug");
    private final edu.umd.cs.findbugs.ba.ClassContext classContext;
    private final edu.umd.cs.findbugs.CallGraph callGraph;
    private final java.util.HashSet<org.apache.bcel.classfile.Method> calledMethodSet;
    private boolean hasSynchronization;
    public SelfCalls(edu.umd.cs.findbugs.ba.ClassContext classContext) { super(
                                                                           );
                                                                         this.
                                                                           classContext =
                                                                           classContext;
                                                                         this.
                                                                           callGraph =
                                                                           new edu.umd.cs.findbugs.CallGraph(
                                                                             );
                                                                         this.
                                                                           calledMethodSet =
                                                                           new java.util.HashSet<org.apache.bcel.classfile.Method>(
                                                                             );
                                                                         this.
                                                                           hasSynchronization =
                                                                           false;
    }
    public void execute() throws edu.umd.cs.findbugs.ba.CFGBuilderException {
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        org.apache.bcel.classfile.Method[] methods =
          jclass.
          getMethods(
            );
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Class has " +
                methods.
                  length +
                " methods");
        }
        for (org.apache.bcel.classfile.Method method
              :
              methods) {
            callGraph.
              addNode(
                method);
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Added " +
                callGraph.
                  getNumVertices(
                    ) +
                " nodes to graph");
        }
        for (org.apache.bcel.classfile.Method method
              :
              methods) {
            org.apache.bcel.generic.MethodGen mg =
              classContext.
              getMethodGen(
                method);
            if (mg ==
                  null) {
                continue;
            }
            scan(
              callGraph.
                getNodeForMethod(
                  method));
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Found " +
                callGraph.
                  getNumEdges(
                    ) +
                " self calls");
        }
    }
    public edu.umd.cs.findbugs.CallGraph getCallGraph() {
        return callGraph;
    }
    public java.util.Iterator<org.apache.bcel.classfile.Method> calledMethodIterator() {
        return calledMethodSet.
          iterator(
            );
    }
    public boolean wantCallsFor(org.apache.bcel.classfile.Method method) {
        return true;
    }
    public java.util.Iterator<edu.umd.cs.findbugs.CallSite> callSiteIterator() {
        return new java.util.Iterator<edu.umd.cs.findbugs.CallSite>(
          ) {
            private final java.util.Iterator<edu.umd.cs.findbugs.CallGraphEdge>
              iter =
              callGraph.
              edgeIterator(
                );
            @java.lang.Override
            public boolean hasNext() {
                return iter.
                  hasNext(
                    );
            }
            @java.lang.Override
            public edu.umd.cs.findbugs.CallSite next() {
                return iter.
                  next(
                    ).
                  getCallSite(
                    );
            }
            @java.lang.Override
            public void remove() {
                iter.
                  remove(
                    );
            }
        };
    }
    public boolean hasSynchronization() {
        return hasSynchronization;
    }
    private void scan(edu.umd.cs.findbugs.CallGraphNode node)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException {
        org.apache.bcel.classfile.Method method =
          node.
          getMethod(
            );
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        if (method.
              isSynchronized(
                )) {
            hasSynchronization =
              true;
        }
        java.util.Iterator<edu.umd.cs.findbugs.ba.BasicBlock> i =
          cfg.
          blockIterator(
            );
        while (i.
                 hasNext(
                   )) {
            edu.umd.cs.findbugs.ba.BasicBlock block =
              i.
              next(
                );
            java.util.Iterator<org.apache.bcel.generic.InstructionHandle> j =
              block.
              instructionIterator(
                );
            while (j.
                     hasNext(
                       )) {
                org.apache.bcel.generic.InstructionHandle handle =
                  j.
                  next(
                    );
                org.apache.bcel.generic.Instruction ins =
                  handle.
                  getInstruction(
                    );
                if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                    org.apache.bcel.generic.InvokeInstruction inv =
                      (org.apache.bcel.generic.InvokeInstruction)
                        ins;
                    org.apache.bcel.classfile.Method called =
                      isSelfCall(
                        inv);
                    if (called !=
                          null) {
                        edu.umd.cs.findbugs.CallSite callSite =
                          new edu.umd.cs.findbugs.CallSite(
                          method,
                          block,
                          handle);
                        callGraph.
                          createEdge(
                            node,
                            callGraph.
                              getNodeForMethod(
                                called),
                            callSite);
                        calledMethodSet.
                          add(
                            called);
                    }
                }
                else
                    if (ins instanceof org.apache.bcel.generic.MONITORENTER ||
                          ins instanceof org.apache.bcel.generic.MONITOREXIT) {
                        hasSynchronization =
                          true;
                    }
            }
        }
    }
    private org.apache.bcel.classfile.Method isSelfCall(org.apache.bcel.generic.InvokeInstruction inv) {
        org.apache.bcel.generic.ConstantPoolGen cpg =
          classContext.
          getConstantPoolGen(
            );
        org.apache.bcel.classfile.JavaClass jclass =
          classContext.
          getJavaClass(
            );
        java.lang.String calledClassName =
          inv.
          getClassName(
            cpg);
        if (!calledClassName.
              equals(
                jclass.
                  getClassName(
                    ))) {
            return null;
        }
        java.lang.String calledMethodName =
          inv.
          getMethodName(
            cpg);
        java.lang.String calledMethodSignature =
          inv.
          getSignature(
            cpg);
        boolean isStaticCall =
          inv instanceof org.apache.bcel.generic.INVOKESTATIC;
        org.apache.bcel.classfile.Method[] methods =
          jclass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methods) {
            java.lang.String methodName =
              method.
              getName(
                );
            java.lang.String signature =
              method.
              getSignature(
                );
            boolean isStatic =
              method.
              isStatic(
                );
            if (methodName.
                  equals(
                    calledMethodName) &&
                  signature.
                  equals(
                    calledMethodSignature) &&
                  isStatic ==
                  isStaticCall) {
                return wantCallsFor(
                         method)
                  ? method
                  : null;
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "No method found for " +
                calledClassName +
                "." +
                calledMethodName +
                " : " +
                calledMethodSignature);
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Ok2zs8jdGnM9MX9wRTuNs1d82/o/iTuqLY4oAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7aazr2HmY3pvlzeZ5z2+8TKazep4dj2lfiqQkShg7NSWK" +
       "2khRIilSYpM8U9wp7otEKZkkNtzaTRDHaMepAzjzy07bwImDtm4KBA4cFK3t" +
       "2gmQ1mjtAPEEbYE6cQzYLbKgTp0eUnefd9/MYCYXOOfynuU73/59Z7mf/W7l" +
       "riSuQGHgbk03SA/0PD1w3PpBug315GBI1ydKnOhax1WSRABtN9W3/dbVv/zB" +
       "x61rlyt3y5WHFN8PUiW1Az/h9CRw17pGV66etHZd3UvSyjXaUdYKnKW2C9N2" +
       "kj5LV+4/NTWt3KCPUIABCjBAAS5RgImTUWDSG3Q/8zrFDMVPk6jyM5VLdOXu" +
       "UC3QSytPnQUSKrHiHYKZlBQACPcUf4uAqHJyHleePKZ9T/NLCP4EBD//z37y" +
       "2r+6o3JVrly1fb5ARwVIpGARufKAp3tLPU4ITdM1ufJGX9c1Xo9txbV3Jd5y" +
       "5Xpim76SZrF+zKSiMQv1uFzzhHMPqAVtcaamQXxMnmHrrnb0112Gq5iA1rec" +
       "0LqnkCraAYH32QCx2FBU/WjKnSvb19LKE+dnHNN4YwQGgKlXPD21guOl7vQV" +
       "0FC5vpedq/gmzKex7Ztg6F1BBlZJK49cCLTgdaioK8XUb6aVh8+Pm+y7wKh7" +
       "S0YUU9LKm88PKyEBKT1yTkqn5PPd8Xs/9lN+379c4qzpqlvgfw+Y9Pi5SZxu" +
       "6LHuq/p+4gPvon9ZecsXPnq5UgGD33xu8H7Mb//099//7se/+OX9mL93izHs" +
       "0tHV9Kb66eWDf/ho55nWHQUa94RBYhfCP0N5qf6Tw55n8xBY3luOIRadB0ed" +
       "X+T+4+Lnfl3/zuXKfYPK3WrgZh7QozeqgRfarh73dF+PlVTXBpV7dV/rlP2D" +
       "yhXwTdu+vm9lDSPR00HlTrdsujso/wYsMgCIgkVXwLftG8HRd6ikVvmdh5VK" +
       "5QoolQdAeXdl/1P+TisCbAWeDiuq4tt+AE/ioKA/gXU/XQLeWrABlGmZmQmc" +
       "xCpcqo6uZXDmabCanHTyumt0FNdNDooh4d8R3Lyg59rm0iXA6kfPG7oLbKQf" +
       "uJoe31Sfz9rd7//mza9ePlb8Q06klcfAMgdgmQM1OTha5uB4mcqlSyX0NxXL" +
       "7YUIRLACxgzc3APP8D8x/MBH33YH0J5wcyfgXzEUvtjbdk7Mf1A6ORXoYOWL" +
       "n9x8UPzZ6uXK5bNus0ARNN1XTJ8Uzu7Yqd04by63gnv1I9/+y8/98nPBieGc" +
       "8cOH9vzSmYU9vu08M+NABXyK9RPw73pS+fzNLzx343LlTmDkwLGlClBE4DMe" +
       "P7/GGbt89sjHFbTcBQg2gthT3KLryDHdl1pxsDlpKaX8YPn9RsDj+wtFfRMo" +
       "7zvU3PJ30ftQWNRv2mtFIbRzVJQ+9H18+Kvf+IM/xUp2H7nbq6cCGK+nz54y" +
       "8QLY1dKY33iiA0Ks62DcH39y8k8/8d2P/INSAcCIp2+14I2i7gDTBiIEbP6H" +
       "X46++eK3Pv31yydKk4IYly1dW82PiSzaK/fdhkiw2jtO8AEuwgXmVGjNjZnv" +
       "BZpt2MrS1Qst/Zurb0c+/+cfu7bXAxe0HKnRu18ewEn7j7QrP/fVn/yrx0sw" +
       "l9QiRJ3w7GTY3u89dAKZiGNlW+CRf/A/P/YrX1J+FXhQ4LUSe6eXjujSoeEU" +
       "SL05rTx9K3NcKvuIcBiVSwHD5Yx3lfVBwZwSTqXsw4rqieS0oZy1xVNpx031" +
       "41//3hvE7/3u90vKzuYtp/WCUcJn96pYVE/mAPxbz3uFvpJYYFzti+Mfv+Z+" +
       "8QcAogwgqiBYJ2wMPFF+RosOR9915Y9+79+/5QN/eEflMlW5zw0UjVJKg6zc" +
       "CyxBTyzgxPLw779/rwibe0B1rSS18hLi9wr0cPnXPQDBZy72RVSRdpyY88P/" +
       "l3WXH/rvf/0SJpRe6BbR9tx8Gf7spx7p/Nh3yvkn7qCY/Xj+Uu8MUrSTueiv" +
       "e39x+W13/4fLlSty5Zp6mP+JipsVRiaDnCc5SgpBjnim/2z+sg/Wzx67u0fP" +
       "u6JTy553RCdRAXwXo4vv+875nh8puDwH5T2HZvme877nUqX8IMopT5X1jaL6" +
       "0VImd6SVK2Fsr0FwB0aflKlmCvCwfcU9NP6/BT+XQPlhUQroRcM+Nl/vHCYI" +
       "Tx5nCCGIYHeR3fasd3tpT2LbA+5sfZgbwc9df3H1qW//xj7vOS/ac4P1jz7/" +
       "83978LHnL5/KNp9+ScJ3es4+4yx594ai6hfG8tTtVilnUP/rc8/9zr947iN7" +
       "rK6fzZ26YGvwG//1/33t4JN/8pVbhPEryyBwdcXf+/6irhVVe89V/ELree+x" +
       "bK8fZUHwoWzhC2Q7u7VsLxef3aLqlZT3U5Dvn/JaRVv1HHriq0TvHaAgh+gh" +
       "F6D3468YvXtVkOL0YiW0jrzvLZOhztGoc8j/xKtEHgUFO0QeuwB5/RUjf7VA" +
       "XteYck8D3ATQsHddrP98tkzSU7uKX7Rf+P3/9BdXP7hXtbOGU24sD6een/fN" +
       "b9yB3p/e+KUye7hzqSSlBt4DfElSjEwrT168SS1h7a3i/hNbr9za1t96EniK" +
       "MAEIPCiVKQzzI2GdiyRgSNERnjG1WzPipjrwbvKf/+ZHGqUlXV3bINfRNeFw" +
       "73w2tp/ku8+e2U/fklU31W9/7he//NSfiQ+VG6U9Vwq06iAvKH43D7XlUqkt" +
       "lw9z5rdfgPAhRmUqclP96U/98Pf/9LlvfeWOyt0gSyxcvBKDTRLYhR1cdL5w" +
       "GsANAXyRYBZw/Q/uZ4PdbincQyFeP249TnjTynsugl261XN5cbFDd4ONHreD" +
       "zNfK6Hc2tNyXheHp3lIdHngt6vAzIJF7Bew7pv7QAgubBPJ8sFSiInqWHvZ0" +
       "J/CqD3VogudvCotJ96ZIcAOiTZdWGBZx51L3SBOvnQDZh+BjHX0yiM0DJVRU" +
       "Sz9Yqrq7x7rYoh7sLfdMylLJz7kY45W7mGIvW/lRUOqHJNQvcDH/+NYu5lLp" +
       "Yo68y3VLSfgt2JfGgX940FP0jM/h9/Mvi98+/F0COf5d6AF+UAaAj1+QHBSf" +
       "7ywq6oyne6vjqjeOQr+oxwlA5obj4rfg/v4A5xyS/VeMZHJGH+jAN5/9hf/5" +
       "8a/90tMvAj8xrNy1LlIuoDSnVhxnxfHYP/rsJx67//k/+YVyUwN4yT+z/D/v" +
       "L6D+yqsj9ZGCVD7IYlWnlSRlyn2Irh1TOzpFD5uC3UzwGqhNr4f9WjIgjn5o" +
       "USHnhIhwEoRvJL5L0HVz2u5AxKrrTcidH5Em2jGRztTt9vP20CZngYNh+DIc" +
       "uBC2nGNzbNjJYzgyx8golkYTFOUac26KUFTOeqKSCkEtXddmOMXFoxY/QmJZ" +
       "QMhITIwGk6bhDk+RFgRP9ElgSzt2N66ndXwXYz7WZyEVwuXJZAP1pHUgt2Vx" +
       "NzDrMdV1qlG06C+GWbXH03Tb6lGwQOXLjLYICPMpCzZCc9aqd4bwYpQL1pRB" +
       "bZljJb+6Gnr8IrQ7A3foTBRxGLLONJr1kanam4kjqY90rZ5ejYSh2N0iDXdo" +
       "W2yjLSC9yBQEZCR20UhIKZMVdoNdW4iGybDV9WCs7ThDno6cZSIMYc9LcbuX" +
       "9OSRpKabLS8mEtYJ2u2xVx+ozszrobLDbaXh2F0YuDyWmOpgI6O8sk4obqNK" +
       "OeWYsTdxl3lT17GWqG6p2YanujPEmzs9zouCpt0e5yubqraSqFrncmrpSRQz" +
       "H+hjbbVqCX28KzlJz5xRseRq0rKN29p0KCPRTF7VwgQNJTB9ulXC5o7m2hQy" +
       "kKRNAx022tOGG27VxmCqBXVJ8uouubKxeFXL1uuMlmcwzQ/EicJ1Zk6Ys9th" +
       "sgk4Sl91rPFQMrO0NxPGwxXZcPkaTeARXxsmsaCxmRtNoVBok8w4R6G4LayF" +
       "XjqXvaCR1dp5e+xUUy+KdEqB5j2gFkjL0iXdJCVFrSX+YIjihNHubIVFb9yI" +
       "N21UrveYntyZhV3Xg7belkllg7BYIu1w1G5eQ7LWdMEtCHaWIGOurczWnul7" +
       "Q5xvI5N+5HWIbOV57d2QmktZh+2Q1apgKWGvpbdzqCPp7GIQkt0hOYeUxUbw" +
       "x8MqtvXqu8xotTgjydxQjmrcsDNR1HA0YqC8OeHocZNrpyHdmoUQ0fVpqjnL" +
       "qtmimQos0+luMnWBeSpch4SZTyPBttEiaINpMJM+gw5pmasutjSUD4R5o54q" +
       "gg13aI2LIq9nDYz1Ss7r0kJFqqHDEb2eJ5O+vWCm+oQW8kzN1kbNhqit7OIK" +
       "txBZsdrJtgHvcoJnc4IxRcSo01iMxy6bu10XVekeCrR/zagry6B1com22s58" +
       "ueVsWeOkGO+1pjMe2kzbkrhZZqvWKEazrbKA9U0ryKkOnxFW3SCSgbHtw4I8" +
       "FHHOELReMCCiUThyONJFKGhRDQbdWkcbJwY+FR0+EnBnZFs2Qnmsw8tOJAtb" +
       "xQrYAauJbD3tSoJss8QMn+7ynUI0VzW5MxDbSKzBnGx0uFSJ1LAfqtgQyZYO" +
       "Vlcmm814O6ga3UQwaXQjELxkL6xeTtW8lYv2rC6QCcqpjtW0+0yXYEnWVOYu" +
       "Wa/P5stWtZ5u7ITLE4WAYzKaM62ZMqeac3MZZhPb1IMhCmUsjSWowCy7PD0z" +
       "Pc9t5zbJhRO1DQ9M0g10abgldZYm4Hwzx3ujVlVc8K3GbjqA7WoW6oGJLPvG" +
       "cDjW+uzWtNjanJzWhrqhTci0utO6E0yT9D6v2XSLdlYSQYRDtkUYDG6rNGZs" +
       "4Ekea1ZeyxhSq6GBE7XwaaBqzfkgmC2UOryeYNFWzUBa5vQHG3gs0hOErLHJ" +
       "2Jxt+ipR95Z1BG4TvMKMt1uLHk0dNYKCcKouLKmpuXIMZaSzau3IToxO0hUz" +
       "WOcNal1To767ZDeYs8K5ZIiNSM5Pdx2VMuEqzeIi7sA46s/ZRZZVBzO9O8Jl" +
       "bLbs81bXGcXy2hLqspW61Vq4668dP6jhuJ/DOSp7yQ5oWFyjGjiVEgLfGWym" +
       "CAbvOqJqAB3G18iy7dS3Src+n3aSMGXElZMM0RllDQSRchycEHmBmPanShZg" +
       "I6ljzKLmatjjR85aMuy1T5Pr+k7cShiRu40lOVZUL+gJ65a804XGBkkgT50v" +
       "rC7PRAHO+r2VGtlq3R+m1Tnn9AyJy/Te3CPrtTluzqftBoGELDpbSMag6c9V" +
       "hOSFHZP1B4TXbu+6MRBWfz0Ycj6DKSrSrTtEy1pAmsO0Whu2Fs8pBJVn7raJ" +
       "a7PJ0Odg4BmGw3CFIXN6mQthW4F4z2bQDkl3jIapb9MFzZHwhJ0sBchexfUq" +
       "C4xrqtbssG302mmVYCAmr0UJKo1peC0wCcKiazfvbjx0JVAKJQ/XRH84Yogq" +
       "ZHIObC5XS7y+mqvdgTwKFHcVhAO1NmcaTbINHBjsISHnJcFEhoMsnOCpCbdw" +
       "Z9cZIDuP6QVNvblOFXLTyS2tSpqBBhmtmtHC8FZsD4ym5ZGrZosaQ+iW9Gkn" +
       "x2etncjUNnS12ahFk7UtNJoyFtPRWl2spwzEU6ixnSIGwRIsboz6Mwui6vkS" +
       "Zlf5SF/ZrtKZD7DFSOVCIzMVYZrQY48fDVq1Vq3roOrOEd1NbMxIH03lCbSp" +
       "L7iJrgoKJMCEhYluzRpDHbmxoojVusW3VRtnZzzILKbpIttIasTGTXM1lINs" +
       "w89GmltPEmqnWn1kYNskHvRkxRQlQu6LcbOxQDC/wwyU5s4XCFPrAlthwvYI" +
       "GatYTIkY5RtNQcu6nuEOdHKnWI0BlsYtNF445ECjGcHCUCncWGJtUItq5oxZ" +
       "YTA/b1osWScsWKX7y40zyhr5LMbrnrCbOEJoxsuwuyUaszXmbYY1wcEI4FuW" +
       "gVfNMTzGgQbZGcblKqSL1nyFQ3i0tKiNCexWmdd0POpEWGc0jiFVIlfbqdbT" +
       "1m1NnKdCTVRqDQHb5nBTt7XdDgnSehKPeGsUj0Sqs220yVHd1YW1bpCWGLf8" +
       "RWhgrqwhhGKtZXQWWvMwcrhUwKJxmnCDIbLp192c6XdZNGcmJDNzg668Icnm" +
       "bmGY7LJHGp3OhrViQYzDsYiKFoo45FSpEWELEquWM2ouE9qfybArtmVbURm3" +
       "mnNYIkGeEMyhGWNvCbnuIRg9IHoavx6smOksn2y6Mr0eLyOzpaUgYYIUzKMn" +
       "zZUXOCLdqRsddYFink8QQwuHRlaXYgazrWORfN1xsSGhTnNKTcjJKM+xxVIc" +
       "NeIeDAkgIIZ13aqNEIjThB3OVXF2M8t4obnpWXgzbm4mdb5pzGfqZjNQZWjZ" +
       "nxA2pFJxFI6TRS8gzBW/gObdrgethjkwHlgSW0t51ahSfSrF1aDHYk2L1kY6" +
       "Ajd2M1UcQ1O6pmwiedhvNBY1jRYDCIt2cD+ZrJmFY8TDKaGqOAHyObITbTaM" +
       "WFOJrWY3IZRZyh6EE9bMJFhMH/ZHlNPMZC9qDB19NocDCcN22kjhWRtCQ501" +
       "2otdKjFhJ+kNp2auGy7n4pYHjcLmeIVVqzKgLFvPM9q2pyy2dklsuVZXYkqb" +
       "o6SjLXYRs0Y0GbPGNmaxaLWv97itHPe3u7UTpH135fiugdeRqQ5iL0Nykwk/" +
       "pye+XTf0nuBDwLmGlpfMZFvqCDaVMqvVKuotA9kljbYExeY02roLT5VcGuSX" +
       "7lJGMg1XMb3TRbfjgYnZDbTeQoGjWugBCGyey3M0Sm/bIb9NFb3OyfZMnDc1" +
       "LA6k5c7zAnqbtdoCO5Ajsm6rG5vRKWehLVqdEYXMVlkSLZkd5ot1Ds2aGeo6" +
       "OjLexUNRjgmFDMTlMu4k2tDJ4107bvap+dre2MoAOGC+O1oxaRNxwyrIG2pb" +
       "PBBUV6eWDLeDqQna1ox1ON3JUqxaHZ2SF2ZUHZjsDm9WGRRtEr0+Ek3oJjFR" +
       "Yw7a6KYqrvhanU8ljNP6mY908E7TbLdbis1gNj6mk7Du1CK/k4VLdNTuTscj" +
       "QLDTWxvOco0NHUNNm7sevq1O+RkiSttYmPIRLg3n3oJkYJY1ek112UVhuKH3" +
       "EaOJmpE4NrFGPkVGkxzXvF61hcIuxK0NX2sgkQ/HowFQZAxRmvG4qY4xkm7U" +
       "5cG4psu+uDGs+SiSW7jNhS3abAardCEu4UVth6w3m+V62stSFYGtMUJ3Vb/q" +
       "rkBe0Q4JadTpwnjubyl7JbatRYSOVSQESaIbcx6nRJaaZ7XpOGiRzKq2A1up" +
       "5ZqWEVZQ5qqUQVWbc9ruLGzMHaLb0La15nBuQHlQ0/v+glo4Y8GS2rXWSplN" +
       "lbUwInkiCZqYSuUu3q475Ar1sVmrw1sKsDWu2SBGXpjjvbw27ib60uCjTmeQ" +
       "Dtjasq0u9ZxVAp5X8G4rRFc4PRoobA0PeU4dBkJHQkbDGtKthVmuC8nSVCLN" +
       "ZTLd2Y5hGZoYpJrryQRGY3wmh5MqJ9WCPg/sb4uFsEGF7R3eYxcoCHP20kLB" +
       "+ly0cfqW19KmPFdfqRLteKifLzYrFdpAXKcpz6ypRyeLpbEjMgtpwZOEafQY" +
       "yVnNzUxd8Y1oyTW27GBMOWp1bHYW2/nCHFJiEGvVqR2vWxw/98TE29V26XgA" +
       "svQWlMMKgzboETOqgSjYZS0GlYIm1JcXqIvtIHMyDOyqORn5VG7HubLw2PF4" +
       "R5G0S3bsbricjpvjfM3P5/CIE7aLHo72VpzCdvRghFhzadoMewjYfXskbNTA" +
       "TnWwG88Zs09SlNlbZ2KAU3W5GXXlZLhD2zTeZE2EAvOlHjOGs3TSr8vpUOjz" +
       "sbmNiO1mmUeQIFoDUXJ9ojG0UDd0F2tch1ly3NVEHoMnkJWZuUrgQwPM3m1j" +
       "XjVqsQU3TWsSR1jgCxG2QtfJcgpDzaZUl0mi1ZBd1Ki2NxNRj1mvKqJ0g850" +
       "g0BskyTn5FxgJ5rsE7t+TJELXYHYXJoNmB265ayqwDapdDydeFt+4DmaWdcI" +
       "arOzlep2t9v6GGGtR22hJuloyIaSMG9Lub6gRHcuxzCFDNUJTWK1tTj3kbze" +
       "h1t6B/fJVoYN5PmWcSftSd7yaN6tmuN6CtxY1NttVWjsNSBDkeKalaJOPwNb" +
       "iA5qDt1IZ0jB4Jo7EB2ScRNxoG29BkWSlitQl5fMXWfqbrgw3U3ytpuSgtol" +
       "jb66Wqda5lmJ3utvGpnUmuCxZiyGzpq0Zz1sA9POQm0aXCtRe5PYG8DahJZo" +
       "gvA8yojdBQiTWciOLLyxXtaV3UqY0DN11dyNYSnPt2k8btNWl3Ww5pCIJLVO" +
       "Eo1ljyXTpDsONXc2SU0D7i/YFbpLmo7W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("85kWM29tOCEbJ4jWROEAtoUsohe1gCCI9xVHT595dUdibyxP/47fcjkuXnR8" +
       "4lWceu27niqqtx8fl5Y/d1fOvf85dVx65lg2iSuPXfREq7y6+/SHnn9BYz+D" +
       "XD48w52klXvTIHyPq69199yl9G2uafZnwic3w1/60J89IvyY9YFX8TbmiXN4" +
       "ngf5L5nPfqX3DvWfXK7ccXxP/JK3c2cnPXvuCD/W0yz2hTN3xI+dfZ9SXBT3" +
       "DjnbO38QfSK7W59Cv3Mv+9s8cPidc33nHlG866JHFFSvndnFk6huruphwckS" +
       "3BeK6t+mlSt6rqtZqt/yrHUd2NqJwv32yx2znka5bPjXxxx6c9H4FCj2IYfs" +
       "159DX7tN3x8U1ZfSygOmnp653FRO6Pvya6Dv0aKxCkp4SF/4+tP3jdv0/VFR" +
       "/Ze08qbTV6SDVC/fH5UznJe9cHr45MLpaOZLLiCvn1xAHo0pel4s++MLr/uK" +
       "9s1rQqCY+7PlUvt7qOLzQ2Xrh8/dJ50I9OuvQaAPFY1PgPLcoUCfe30Eeulk" +
       "wIfLAd+7jVT/d1F9B2jtRvFLtU2oPb/HJ0T++Wsg8vGisej/8CGRH379tfZv" +
       "btP3w6L6q7RyrdBa3k71sxpbVH9cDnzxFShZ0fw/jvT00YteNRSrXKgwf/1a" +
       "FebtoHzqkJefet15eenB2/RdK6p7L77GPKby0n2vgcryyvUZUH7tkMpfe7VU" +
       "dm9nFkfie+q2j1LGgaaXND9ysXH9bjng8aIC8O5M1P07od87YcNbXquwHwPl" +
       "q4ds+OrfCRueOX+VbhaPwGz1YOCvg1X5AqF4yHsY0y+98zbq8e6iejotHtYd" +
       "vXQufdAJP268Gn7kINk7fjFdvD95+CX/dLH/RwH1N1+4es9bX5j9t/LR8PFj" +
       "/nvpyj1G5rqnX+Cd+r47jHXDLll07/49XhkBLmFp5aFbqEYKgB1+FpheQvej" +
       "G4Dck9Fp5bJ6prtVZD/77rRyB6hPd74XNIHO4vN9pUg/lF+6wGtcfznGnUqp" +
       "n77wLQ2T7f+j5ab6uReG45/6fuMz++fKIADudgWUe+jKlf3L6ePE96kLoR3B" +
       "urv/zA8e/K17336UpD+4R/hEO0/h9sSt3wZ3vTAtX/Pu/t1b/817//kL3ypv" +
       "/P8/pc69ZGg0AAA=");
}
