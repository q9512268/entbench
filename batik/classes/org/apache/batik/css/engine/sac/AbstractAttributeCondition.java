package org.apache.batik.css.engine.sac;
public abstract class AbstractAttributeCondition implements org.w3c.css.sac.AttributeCondition, org.apache.batik.css.engine.sac.ExtendedCondition {
    protected java.lang.String value;
    protected AbstractAttributeCondition(java.lang.String value) { super(
                                                                     );
                                                                   this.value =
                                                                     value;
    }
    public boolean equals(java.lang.Object obj) { if (obj == null || obj.
                                                        getClass(
                                                          ) !=
                                                        getClass(
                                                          )) { return false;
                                                  }
                                                  org.apache.batik.css.engine.sac.AbstractAttributeCondition c =
                                                    (org.apache.batik.css.engine.sac.AbstractAttributeCondition)
                                                      obj;
                                                  return c.
                                                           value.
                                                    equals(
                                                      value);
    }
    public int hashCode() { return value == null ? -1 : value.
                              hashCode(
                                ); }
    public int getSpecificity() { return 1 << 8; }
    public java.lang.String getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F6cw/t1Z31p7euKyQKBurTE3E3HnZUVcUe+7Tn/m7U//7PRXjo1aFcOywpHO" +
       "xzf7H1uU6P5f/z3H5CLG5almfPwD4bMnmzrWfSD43WCD3K3p3FwGAdvlXXUm" +
       "+ddgS/mPgqRigNRLdn3dT5UUuvAA1JSmU3RDDZ41n10fWsVQeyaYzvMHOs+2" +
       "/jDn5lDoIzX2a/JFtrnwLLE9fok/sgWI6NwvWG7BZnluvCjEzUnZCGqFP+60" +
       "YiS2d2ETsWBwdz7UWVO3iLYNm1sFWIIcLiepKNzxOKmkdtJ3w5f4q3NKK+ft" +
       "DV8u7oKO67dgcTF6uyRqClFM5BQRDunKG9UhnWkOhSLcdhxO9OD5hUptcU2Y" +
       "3H90Irbl1EoL3o3Z5Wsn3M6efudfb4RO/Oq1PHVRFdf0WxU2whSPYqW4ZZZD" +
       "9YhbiIvO92qP/OaF1qENN1O94FjzDeoT/L0AlGgr7KN+UV7Z/4embesSu26i" +
       "EFngM6d/yad6zr5231LpSFBcuSy3ybmqZTO1ZztLtcHgbqluy3KZxRmUTUNQ" +
       "zYFnlY2yVfmLgbwIDmB3my/jVhdZzJeCCuctK1SIvYeL5C1xO4EoU872wLGb" +
       "2fUuoqAvBX7Va8hJAPCIfbNb1btLOtja+1sLpHPyMFh0M54Mf7n/0u43xHFW" +
       "In4yRvRgB3DmqbLqLVt8DH8BeP6ND0qLA9YNqbHDvqYtzNzTMIcUTQY+BcJ7" +
       "G98fPnnlaUsBf+T3EbODRx/7OHToqOVx1mV/cc5928tjXfgtdbDhKN2iYrsI" +
       "jq7fndv7vSf3HgjaZ7ODk4qopimMqjkHDqVlttktWe/9Yt2LhxtLusCXu0ll" +
       "SpX3pFh3LBvPFWYq6jkH9/uAi25barQ5J4E2J0WLOB0vEqf/i+oABzp0MU4z" +
       "sMcgTWbBs86G/boiPoRNItdjCrEWAf9jRea+hM2jkFcSUDJ1gIEF1R77OPE1" +
       "4umPc1Ii25/MPMeEP/d5bPeFT8p28+HptA3QefO2K8RaxD4ni8xNYHOck9oh" +
       "xvt0JkEZL8l8DEcPucY48QkYoxHnmuDpsTXquXljFGItovBTRea+gc0kAAmM" +
       "0Z8pflwznPpfmCHNSVPhrx5Yks/O+Q5rfTuUnpmoq5w18cAlkf4z3/emQsCO" +
       "pxTFWzR6+uW6weKy0G+qVULq4vVNSK43qIrAU6AVijxnMX2bk7lFmDA5iY6X" +
       "5wVOpufjgdWh9VK+CGnRTwl1qHh76b7PSbVLB5taHS/JD2F1IMHuBb1wzg14" +
       "yi/i8f4ZNzrpDIv3Ho+5THxqd4J9yvrYPiidm9i0+cFrd56yviNICh0fx1Wm" +
       "QIi3PmlkiqRFBVdz1irfuOx67bNVS5zc02AJ7HrLXA+kOyC06QiqJt8N22zN" +
       "XLTfnVz78k8Olr8FWXM7CVBOpm3Pvcik9RRUp9sjuakMCkpx9W9f9vWxdSvi" +
       "f/qluCqSnAuin35Qunh6x9tHZk82B8mUblIGaZWlxQ3r3jF1K5NGjAFSI5ud" +
       "aRARVpGpkpUnaxH/FG/8wi62OWsyo/gVCu4Iudk/99sdXKtHmbFBS6kxO9NO" +
       "cUey/gdg+1R1Std9DO6Ip0J6yMo7eBqAx8FIj647xVH5X3QREPblT0TYviO6" +
       "2Fz6DygtGU2GGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "UrGE9zAyoOZ4YclumsXq0PB7UY0plVJmTo1VZ5pitWUNbF41Yjansea0wXo2" +
       "OlhJxrI+Gk28emjGwpIGbzxJfVZX66tZInMrQ4VBUDZ9zsFjw0Erw9jRq0k9" +
       "IvllrdSo2RPR6nYEfmYlQzRATQLpV5iOiRNctxLLwggfTb2Ot/QmjpCQMNGB" +
       "a2ujWmJn4caFtWkzLndjeQnX66E870ekLRINrroEwMWwAPg3sCZrBWSEcJFc" +
       "b7HVrlfsVTe0iykNH09qRNeslrFkSlbm6HDUHojWuDherAy2WiLSamujRZ1J" +
       "qdNZ43j2mqn8YG/6t+YHGAc3bD/E0UVy9QF38gEj6LSwd4lweIKbf87vX9Xs" +
       "fx89wT08vdvZP/18MLusWKNSfkeRX05ccSmxT4q82L1GO4kUR1bkA87s3OCe" +
       "a13d5WcGH37y6Wdk9iPIzt7R6uMRdCZyvZ+0lJViHTttfOTa5yN0fnN5eOT3" +
       "+Sf/5e7xY/rjP8Alx33H9Dwu8mP0s1/svFp67w50w8EB4BV3qpczPXr5sd/Z" +
       "QIniwBlfdvh3z8Hy3Z6t1svBU9pbvtLVLxquffLHbL3v2Mn1tY+7t+eZOdPb" +
       "r3Pc/Y6seEsEnVL8WLDCnOYNR9z3UgTdJLqupQjOoWs/8WKHN0dHyRs2BzOR" +
       "+TB0J3ge25uJx348M3HUqPdep+/prPglEGO6EOpNV1auZvINxt5fEHJzn/pR" +
       "zb0HPO09c9s/fnN//Tp9v5EVH4ygc5oScZ4iGaohGdEma33/oYUf+hEsvC1r" +
       "vBs89J6F9I/fwk9cp++5rPgoWFBg4fTgjPvQto/9ILYlEXT3tW9ws7uou674" +
       "T8n2fxDSJ585f/rOZyZ/nV9iHvxX4QwFnVZjyzp6Q3CkfsoLFNXI7TizvS/w" +
       "8q/fBfjzIogMvBSUuQWf3jL9QQS94jpMWZDnlaM8fxRBL70aD5AOyqOUfwLg" +
       "5ThlBJ3Mv4/S/VkEnT2kA4NuK0dJPgukA5Ks+rncR55MThzZD/ZcLF+9215s" +
       "9Q5Yjl6ZZntI/hehfbyPt38SuiQ990yPefML1Y9sr2wlS0jTTMppCrppe3t8" +
       "sGc8cE1p+7JOkQ9/79ynzjy0v7+d2yp86O5HdLvv6pejbduL8uvM9Pfv/J3X" +
       "/eYzX8tvIf4XOlr/5LslAAA=");
}
