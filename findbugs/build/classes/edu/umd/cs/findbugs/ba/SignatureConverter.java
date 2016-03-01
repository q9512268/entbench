package edu.umd.cs.findbugs.ba;
public class SignatureConverter {
    private java.lang.String signature;
    public SignatureConverter(java.lang.String signature) { super();
                                                            this.signature =
                                                              signature; }
    public char getFirst() { return signature.charAt(0); }
    public void skip() { signature = signature.substring(1); }
    public java.lang.String parseNext() { java.lang.StringBuilder result =
                                            new java.lang.StringBuilder(
                                            );
                                          if (signature.startsWith("[")) {
                                              int dimensions =
                                                0;
                                              do  {
                                                  ++dimensions;
                                                  signature =
                                                    signature.
                                                      substring(
                                                        1);
                                              }while(signature.
                                                       charAt(
                                                         0) ==
                                                       '['); 
                                              result.
                                                append(
                                                  parseNext(
                                                    ));
                                              while (dimensions-- >
                                                       0) {
                                                  result.
                                                    append(
                                                      "[]");
                                              }
                                          }
                                          else
                                              if (signature.
                                                    startsWith(
                                                      "L")) {
                                                  int semi =
                                                    signature.
                                                    indexOf(
                                                      ';');
                                                  if (semi <
                                                        0) {
                                                      throw new java.lang.IllegalStateException(
                                                        "missing semicolon in signature " +
                                                        signature);
                                                  }
                                                  result.
                                                    append(
                                                      signature.
                                                        substring(
                                                          1,
                                                          semi).
                                                        replace(
                                                          '/',
                                                          '.'));
                                                  signature =
                                                    signature.
                                                      substring(
                                                        semi +
                                                          1);
                                              }
                                              else {
                                                  switch (signature.
                                                            charAt(
                                                              0)) {
                                                      case 'B':
                                                          result.
                                                            append(
                                                              "byte");
                                                          break;
                                                      case 'C':
                                                          result.
                                                            append(
                                                              "char");
                                                          break;
                                                      case 'D':
                                                          result.
                                                            append(
                                                              "double");
                                                          break;
                                                      case 'F':
                                                          result.
                                                            append(
                                                              "float");
                                                          break;
                                                      case 'I':
                                                          result.
                                                            append(
                                                              "int");
                                                          break;
                                                      case 'J':
                                                          result.
                                                            append(
                                                              "long");
                                                          break;
                                                      case 'S':
                                                          result.
                                                            append(
                                                              "short");
                                                          break;
                                                      case 'Z':
                                                          result.
                                                            append(
                                                              "boolean");
                                                          break;
                                                      case 'V':
                                                          result.
                                                            append(
                                                              "void");
                                                          break;
                                                      default:
                                                          throw new java.lang.IllegalArgumentException(
                                                            "bad signature " +
                                                            signature);
                                                  }
                                                  skip(
                                                    );
                                              }
                                          return result.
                                            toString(
                                              ); }
    public static java.lang.String convertMethodSignature(org.apache.bcel.classfile.JavaClass javaClass,
                                                          org.apache.bcel.classfile.Method method) {
        return convertMethodSignature(
                 javaClass.
                   getClassName(
                     ),
                 method.
                   getName(
                     ),
                 method.
                   getSignature(
                     ));
    }
    public static java.lang.String convertMethodSignature(org.apache.bcel.generic.MethodGen methodGen) {
        return convertMethodSignature(
                 methodGen.
                   getClassName(
                     ),
                 methodGen.
                   getName(
                     ),
                 methodGen.
                   getSignature(
                     ));
    }
    public static java.lang.String convertMethodSignature(org.apache.bcel.generic.InvokeInstruction inv,
                                                          org.apache.bcel.generic.ConstantPoolGen cpg) {
        return convertMethodSignature(
                 inv.
                   getClassName(
                     cpg),
                 inv.
                   getName(
                     cpg),
                 inv.
                   getSignature(
                     cpg));
    }
    public static java.lang.String convertMethodSignature(java.lang.String className,
                                                          java.lang.String methodName,
                                                          java.lang.String methodSig) {
        return convertMethodSignature(
                 className,
                 methodName,
                 methodSig,
                 "");
    }
    public static java.lang.String convertMethodSignature(edu.umd.cs.findbugs.ba.XMethod xmethod) {
        java.lang.String className =
          xmethod.
          getClassName(
            );
        assert className.
          indexOf(
            '/') ==
          -1;
        return convertMethodSignature(
                 className,
                 xmethod.
                   getName(
                     ),
                 xmethod.
                   getSignature(
                     ));
    }
    public static java.lang.String convertMethodSignature(edu.umd.cs.findbugs.classfile.MethodDescriptor methodDescriptor) {
        return convertMethodSignature(
                 methodDescriptor.
                   getClassDescriptor(
                     ).
                   toDottedClassName(
                     ),
                 methodDescriptor.
                   getName(
                     ),
                 methodDescriptor.
                   getSignature(
                     ));
    }
    public static java.lang.String convertMethodSignature(java.lang.String className,
                                                          java.lang.String methodName,
                                                          java.lang.String methodSig,
                                                          java.lang.String pkgName) {
        java.lang.StringBuilder args =
          new java.lang.StringBuilder(
          );
        edu.umd.cs.findbugs.ba.SignatureConverter converter =
          new edu.umd.cs.findbugs.ba.SignatureConverter(
          methodSig);
        converter.
          skip(
            );
        args.
          append(
            '(');
        while (converter.
                 getFirst(
                   ) !=
                 ')') {
            if (args.
                  length(
                    ) >
                  1) {
                args.
                  append(
                    ", ");
            }
            args.
              append(
                shorten(
                  pkgName,
                  converter.
                    parseNext(
                      )));
        }
        converter.
          skip(
            );
        args.
          append(
            ')');
        java.lang.StringBuilder result =
          new java.lang.StringBuilder(
          );
        result.
          append(
            className);
        result.
          append(
            '.');
        result.
          append(
            methodName);
        result.
          append(
            args.
              toString(
                ));
        return result.
          toString(
            );
    }
    public static java.lang.String convert(java.lang.String signature) {
        return new edu.umd.cs.findbugs.ba.SignatureConverter(
          signature).
          parseNext(
            );
    }
    public static java.lang.String shorten(java.lang.String pkgName,
                                           java.lang.String typeName) {
        int index =
          typeName.
          lastIndexOf(
            '.');
        if (index >=
              0) {
            java.lang.String otherPkg =
              typeName.
              substring(
                0,
                index);
            if (otherPkg.
                  equals(
                    pkgName) ||
                  "java.lang".
                  equals(
                    otherPkg)) {
                typeName =
                  typeName.
                    substring(
                      index +
                        1);
            }
        }
        return typeName;
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
       "hcZkgUw6CWe4eF8zSRqz7HC06naNVj2Ju4S4yLAqbzRh1crU8rYl99NuYFCe" +
       "igaa3yI0c9YkLIUlkO6c9jtMNhA7NutLdLeN+bKUsQOr76yUYNtBV5lENHQd" +
       "WlbV9Yam64RghKgw4Kt2FY9RZlyJlmjQgbXGetXWVTxCYrVjJZCBDvstuOKs" +
       "kaZsKE3Ic2ZQw5LcEV3FxO0qWbVZaNris8jlpr7cxIVsVTPWIKfuSMvAw3AJ" +
       "kyduvaetpmCisA09MQN0O4/5crtKECTsVFdLTEKMVas3H1UN1lzp7UkjMaaN" +
       "ZcaoUhfTVqqLtLMZH3I6Z5M8jCdLZVw2Qeo/aMybUJxMUxOacGYd473MyrBu" +
       "K7EtsZ6mSX3L4eX+Fkc5uMclk2kFyEzp6ay5DuqrLTOUPabBz9tBOuKwubYi" +
       "LL1OwlVzDSPZFkJtw4XXos7Ey0Woz4GH2FrbbsUSCwZFqgKyqrZoO+67+ISM" +
       "OCZT1Kmq0iHuuNKywdcDPrLtbRkX1bCF9OJ40+5D6WgMMQONAFGnUwYfmUuy" +
       "Vy+vmzTEZXSKKOnEj/SR1Fho3gBRfHKgl6XUTxbY3HRxDw4bnLVsdReOCvUs" +
       "ajreYkl5ilnlZnWVwliXX8CEHevzjbhccR2EJUWMyEhBr1g03Ysjft5DOLQm" +
       "6gjbgSLJGlS23XGyGkoc1hg14Jm5lS0P4xCVTMtDqaaVEwlXKbYPPs3yz3z1" +
       "G9tpebjYQDo5uPxbbB3tmp7Ni3ee7NIVv3vPH3ad3inf75KW8l2TJ293Hlns" +
       "mHzsva++pow+Xj042l1+OS5dif3g7zhqqjqnWN0POL14+90hujiO3e96/sp7" +
       "/98T3PcZL38DhzxPn5PzPMt/Tn/y8+R3yB86KF082QO96aD4bKeXzu58Xg3V" +
       "OAk97sz+55MnyBaoPw6e7zlC9ntufdBy683Pwgp2c3+Hzfv33KHtlbxI49J9" +
       "ugpy/TDa3Rr4/lNWciMuXZKNoxsBhfmsv94G1elBioro7MHSY+BBj/RF776+" +
       "P3aHtn+UFz8CVIpsM7ilrqlvKntdf/Sb0PWRvPLt4GGOdGXuvq4/fYe2n8mL" +
       "V4FvBfmdDQb4TxEM9sp9+JtQ7tvzSgg8HzpS7kPfgHIH+/B1Sw0PdlTH51XP" +
       "+6F+KAaibKiHkqw6h8WFlvyc/rAvpmIRXI5pn7k97c5PiwE/fgfY/kVe/Fxc" +
       "ekzeHVDvuk3PnBHsMfwndwPDjx5h+NG7iOG5M79nz+Oi50cgpnyECql6BZfP" +
       "3AGYz+bFp98sMP/ybgDziSNgPvGtM64XbgcM5aW+XRzG52f3x+sI6PGdt+tx" +
       "fKY29n3nGNBfvgOgn8+LX3qzgP77uwHoZ48A/exdBPTiPiWp7IuC9L/cQfvf" +
       "yovfeLPa/6e7of3njrT/3LfOz566zbWXxano88U7oPJ/8uJ33iwq/+NuoPKF" +
       "I1S+8K1D5fBWqJyPzF01kkMziP2wYPmVO6D0Rl58+c2i9Pt3A6UvHaH0pbuI" +
       "0qXdvYJznrN3n6/dAYK/zIuvvlkI/vSbheAZMJtXdn13f++uoZzofOHy7XW+" +
       "cCUvDuLS5SOdzyp54eLdUPKBIyUfuItKHuyp9rN74dE7aPrWvHgQaBoZfhir" +
       "3jlNr30jmmZx6ZGbb93lV4gev+ly7+5CqvwLr127722vzf5rcfHs5NLolWHp" +
       "Pi1xnNMXO0693xuEqmYWAFzZXfMICl3eAYz01lExLh1IYi7vhbfvSJ+OS4/e" +
       "ghR8nxy/nqZ+Li5d3VMDZvKZ5ncC+I6a49JFUJ5u/C5QBRrz1xeC4zB16gbE" +
       "7uZLtotgj5+2mcKfHvl6E3DqY/j5M5+wxbXr48/NZHfx+ob8qdf6zHvegD++" +
       "uzEHIuN2m3O5b1i6vLu8VzDNP1mfvS23Y1739l742oOfvvLO48/rB3cC7+33" +
       "lGxP3/p6Gu4GcXGhbPtv3/av3/VPX/vd4grI3wD8YjCYDy8AAA==");
}
