package edu.umd.cs.findbugs.detect;
public class SynchronizationOnSharedBuiltinConstant extends edu.umd.cs.findbugs.bcel.OpcodeStackDetector {
    final java.util.Set<java.lang.String> badSignatures;
    final edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    public SynchronizationOnSharedBuiltinConstant(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        badSignatures =
          new java.util.HashSet<java.lang.String>(
            );
        badSignatures.
          addAll(
            java.util.Arrays.
              asList(
                new java.lang.String[] { "Ljava/lang/Boolean;",
                "Ljava/lang/Double;",
                "Ljava/lang/Float;",
                "Ljava/lang/Byte;",
                "Ljava/lang/Character;",
                "Ljava/lang/Short;",
                "Ljava/lang/Integer;",
                "Ljava/lang/Long;" }));
    }
    private static boolean newlyConstructedObject(edu.umd.cs.findbugs.OpcodeStack.Item item) {
        edu.umd.cs.findbugs.ba.XMethod method =
          item.
          getReturnValueOf(
            );
        if (method ==
              null) {
            return false;
        }
        return "<init>".
          equals(
            method.
              getName(
                ));
    }
    private static final java.util.regex.Pattern identified =
      java.util.regex.Pattern.
      compile(
        "\\p{Alnum}+");
    edu.umd.cs.findbugs.BugInstance pendingBug;
    int monitorEnterPC;
    java.lang.String syncSignature;
    boolean isSyncOnBoolean;
    @java.lang.Override
    public void visit(org.apache.bcel.classfile.Code obj) {
        super.
          visit(
            obj);
        accumulateBug(
          );
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void sawOpcode(int seen) { switch (seen) { case MONITORENTER:
                                                          edu.umd.cs.findbugs.OpcodeStack.Item top =
                                                            stack.
                                                            getStackItem(
                                                              0);
                                                          if (pendingBug !=
                                                                null) {
                                                              accumulateBug(
                                                                );
                                                          }
                                                          monitorEnterPC =
                                                            getPC(
                                                              );
                                                          syncSignature =
                                                            top.
                                                              getSignature(
                                                                );
                                                          isSyncOnBoolean =
                                                            false;
                                                          java.lang.Object constant =
                                                            top.
                                                            getConstant(
                                                              );
                                                          if ("Ljava/lang/String;".
                                                                equals(
                                                                  syncSignature) &&
                                                                constant instanceof java.lang.String) {
                                                              pendingBug =
                                                                new edu.umd.cs.findbugs.BugInstance(
                                                                  this,
                                                                  "DL_SYNCHRONIZATION_ON_SHARED_CONSTANT",
                                                                  NORMAL_PRIORITY).
                                                                  addClassAndMethod(
                                                                    this);
                                                              java.lang.String value =
                                                                (java.lang.String)
                                                                  constant;
                                                              if (identified.
                                                                    matcher(
                                                                      value).
                                                                    matches(
                                                                      )) {
                                                                  pendingBug.
                                                                    addString(
                                                                      value).
                                                                    describe(
                                                                      edu.umd.cs.findbugs.StringAnnotation.
                                                                        STRING_CONSTANT_ROLE);
                                                              }
                                                          }
                                                          else
                                                              if (badSignatures.
                                                                    contains(
                                                                      syncSignature)) {
                                                                  isSyncOnBoolean =
                                                                    "Ljava/lang/Boolean;".
                                                                      equals(
                                                                        syncSignature);
                                                                  edu.umd.cs.findbugs.ba.XField field =
                                                                    top.
                                                                    getXField(
                                                                      );
                                                                  edu.umd.cs.findbugs.ba.FieldSummary fieldSummary =
                                                                    edu.umd.cs.findbugs.ba.AnalysisContext.
                                                                    currentAnalysisContext(
                                                                      ).
                                                                    getFieldSummary(
                                                                      );
                                                                  edu.umd.cs.findbugs.OpcodeStack.Item summary =
                                                                    fieldSummary.
                                                                    getSummary(
                                                                      field);
                                                                  int priority =
                                                                    NORMAL_PRIORITY;
                                                                  if (isSyncOnBoolean) {
                                                                      priority--;
                                                                  }
                                                                  if (newlyConstructedObject(
                                                                        summary)) {
                                                                      pendingBug =
                                                                        new edu.umd.cs.findbugs.BugInstance(
                                                                          this,
                                                                          "DL_SYNCHRONIZATION_ON_UNSHARED_BOXED_PRIMITIVE",
                                                                          NORMAL_PRIORITY).
                                                                          addClassAndMethod(
                                                                            this).
                                                                          addType(
                                                                            syncSignature).
                                                                          addOptionalField(
                                                                            field).
                                                                          addOptionalLocalVariable(
                                                                            this,
                                                                            top);
                                                                  }
                                                                  else
                                                                      if (isSyncOnBoolean) {
                                                                          pendingBug =
                                                                            new edu.umd.cs.findbugs.BugInstance(
                                                                              this,
                                                                              "DL_SYNCHRONIZATION_ON_BOOLEAN",
                                                                              priority).
                                                                              addClassAndMethod(
                                                                                this).
                                                                              addOptionalField(
                                                                                field).
                                                                              addOptionalLocalVariable(
                                                                                this,
                                                                                top);
                                                                      }
                                                                      else {
                                                                          pendingBug =
                                                                            new edu.umd.cs.findbugs.BugInstance(
                                                                              this,
                                                                              "DL_SYNCHRONIZATION_ON_BOXED_PRIMITIVE",
                                                                              priority).
                                                                              addClassAndMethod(
                                                                                this).
                                                                              addType(
                                                                                syncSignature).
                                                                              addOptionalField(
                                                                                field).
                                                                              addOptionalLocalVariable(
                                                                                this,
                                                                                top);
                                                                      }
                                                              }
                                                          break;
                                                      case MONITOREXIT:
                                                          accumulateBug(
                                                            );
                                                          break;
                                                      default:
                                                          break;
                                      } }
    private void accumulateBug() { if (pendingBug ==
                                         null) {
                                       return;
                                   }
                                   bugAccumulator.
                                     accumulateBug(
                                       pendingBug,
                                       edu.umd.cs.findbugs.SourceLineAnnotation.
                                         fromVisitedInstruction(
                                           this,
                                           monitorEnterPC));
                                   pendingBug =
                                     null;
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
      ("H4sIAAAAAAAAAMV6eczs1nUf35P0JD0tT3qKJUextT67lml/nH2BbNcznIVD" +
       "zgw5Qw6Hw7Z55pB3uO/rTKw0NuDYSOAFrZy6qCP0DxttAyUOihoNUKRQUTSx" +
       "swEJgsYuWtsICsSJY8BukTStm7iXnG/X92lxC3QAXt65y+E5557zu+cuL38X" +
       "uSsMENRzra1qudEByKIDw6ofRFsPhAfkuM5IQQgU3JLCkINlt+VnfvXGX/7g" +
       "M9pDV5FrIvKI5DhuJEW664RzELpWApQxcuOktG8BO4yQh8aGlEhYHOkWNtbD" +
       "6Pkxct+prhFya3zEAgZZwCALWMEC1jlpBTs9AJzYxvMekhOFPvLTyJUxcs2T" +
       "c/Yi5OmzRDwpkOxDMkwhAaRwT/6fh0IVnbMAeepY9r3MrxL4syj24j/6yYf+" +
       "5R3IDRG5oTtszo4MmYjgR0TkfhvYaxCEHUUBiog87ACgsCDQJUvfFXyLyM1Q" +
       "Vx0pigNwrKS8MPZAUHzzRHP3y7lsQSxHbnAs3kYHlnL0766NJalQ1kdPZN1L" +
       "OMjLoYDXdchYsJFkcNTlTlN3lAh58nyPYxlvUbAB7Hq3DSLNPf7UnY4EC5Cb" +
       "+7GzJEfF2CjQHRU2vcuN4Vci5PFLiea69iTZlFRwO0Leer4ds6+Cre4tFJF3" +
       "iZC3nG9WUIKj9Pi5UTo1Pt+dvu9TP+UQztWCZwXIVs7/PbDTE+c6zcEGBMCR" +
       "wb7j/e8e/4L06K9/4iqCwMZvOdd43+Zff/j7H3zPE698Zd/mJy5oQ68NIEe3" +
       "5S+sH/z9t+HPte/I2bjHc0M9H/wzkhfmzxzWPJ950PMePaaYVx4cVb4y/43V" +
       "z/wS+M5V5PoIuSa7VmxDO3pYdm1Pt0AwBA4IpAgoI+Re4Ch4UT9C7ob5se6A" +
       "fSm92YQgGiF3WkXRNbf4D1W0gSRyFd0N87qzcY/ynhRpRT7zEAS5Gz7I/fB5" +
       "Dtn/ineEZJjm2gCTZMnRHRdjAjeXP8SAE62hbjVsA41pHashFgYyVpgOUGIs" +
       "thVMDk8qFRDBbhi7hV0C1zn0FdphNSkASjfWrUh3jjz9ICfj/X/8dpbr5aH0" +
       "yhU4ZG87DxgW9DXCtRQQ3JZfjLv97//K7d++euxAhxqNkA5k5QCyciCHB0es" +
       "HOxZOXhjrCBXrhQc/FjO0t5g4HCbEDggpN7/HPv3yA994pk7oKV66Z1wrPKm" +
       "2OXIjp9AzaigL0N7R175XPoR/u+XriJXz0J0LgYsup53Z3JgPQbQW+dd8yK6" +
       "Nz7+7b/80i+84J446RnMP8SOV/fMff+Z8woPXBnqMgAn5N/9lPTl27/+wq2r" +
       "yJ0QUCCIRhI0eohPT5z/xhkMeP4IT3NZ7oICb9zAlqy86ggEr0dwXNKTksIS" +
       "HizyD0Md35c7RRk+2KGXFO+89hEvT39sbzn5oJ2TosDr97PeL37t9/60Wqj7" +
       "CNpvnJosWRA9fwpOcmI3CuB4+MQGuAAA2O6/fI75h5/97sf/TmEAsMWzF33w" +
       "Vp7iEEbgEEI1f+wr/te/+Y0v/OHVE6OJ4Hwary1dzo6FzMuR668hJPzaO0/4" +
       "gXBkQaPOrebWwrFdRd/o0toCuZX+7xvvKH/5zz/10N4OLFhyZEbveX0CJ+U/" +
       "3kV+5rd/8n88UZC5IufT4YnOTprtMfaRE8qdIJC2OR/ZR/7g7f/4N6VfhGgN" +
       "ETLUd6AAvSuHjpMz9RY4ZV7kst1YnQPPDeD8VwwuVrR+d5Ee5IopaCBFXTVP" +
       "ngxPO8lZPzwV3tyWP/OH33uA/96//X4h1dn46LRNTCTv+b0Z5slTGST/2HlE" +
       "IKRQg+1qr0z/7kPWKz+AFEVIUYZBQUgHEKmyMxZ02Pquu//Tv/v3j37o9+9A" +
       "rg6Q65YrKQOpcEbkXugFINQgyGXe3/7g3gjSe2DyUCEq8irh98bz1uLfdcjg" +
       "c5fj0CAPb05c+a3/i7bWH/3jv3qVEgoEumBWP9dfxF7+/OP4B75T9D+Bgrz3" +
       "E9mr0RuGgid9K79k/8XVZ679h6vI3SLykHwIu7xkxbmDiTC2Co+wGMaiZ+rP" +
       "xkn7oOD5Y6h723kYOvXZ8yB0MmvAfN46z18/hzu5NyK34IMeuiR6HneuIEWm" +
       "U3R5ukhv5cnfOnLzu6BFS9ahl/8Q/q7A52/yJyeVF+wn/Jv4YdTx1HHY4cHp" +
       "7IG1pLDHcS0c4ndfPsRsvA6jUyHbJ/WXfve3/uLGR/ZR1VnbKKL2w67n+339" +
       "a3dU7otufbqAyzvXUljo5h6owDBvGSFPXb4CKGjt/ea+E5mRi2V+5AwCHxTr" +
       "C8/LjnDhgRPXgdV5IQ0V8PTrKOC2PLJvs1/++scbhW3eSHQI6kDhDhckZ0Hs" +
       "ZGJ//swi5UIV3Za//aVPfuXpP+MfKaLPvTZytuoQAPN369BprxROe/UwOHjH" +
       "JQwfclRg7m35w5//m9/90xe+8dU7kGtwOsztOQ9NRjAcObhs0XaawC0O5nqw" +
       "F7TzB/e94RKiGNTDwbt5XHo8s0fIey+jna9JzwcA+bLHclMQdN3YUQpXP+tH" +
       "12PPO11bmMH9P6oZ/DScrd6A6o4lP3RR5GZh7g8WxpPDxEEfrmZPV0K3egQf" +
       "d1j2Nrdi+rf5znzU6Y77hYHlPnelf2SBD50Q2WNNdkHNfrV2BouRw3gkT2t5" +
       "0t3XNi9F9fedxZx3wee9hyy/9xLM0S7BnDzbLxgYRMiDcDLtyHJsx5Z0tNqF" +
       "7D9zyZR7quk5CfQ3LsGP56UT+HzgUIIPXCKBf7EEd0TI3V6gJxADYZgUFhsB" +
       "Z4S6ritwLQLDFaAcCXRqag6ACrIDRopg6OCckyJ441IU4/gT8Dlsun9fIMWH" +
       "L5YCOebWg8tEaCFQva8X8Rx52jmuX3iTXD8Gn+4h191LuP7Y63D9oA3XSdAM" +
       "+vk+B4O/dnDBBLoNI+fkcMmPvXDzm+bnv/3L+4nnfCRxrjH4xIs/98ODT714" +
       "9dQmyrOv2sc43We/kVIw+kDBbXZmWrjgK0WPwZ986YV/889f+Pieq5tntwRy" +
       "jPjl//jXv3PwuW999YJV5R26E50blJ99k4OSe0XvcFB6lwzKi68zKA+EcAV7" +
       "HA7khfI5rj77Jrl6G3wGh1wNLuHqn7wOVzf0MF9Z007XdS0g7WPInzscmfz1" +
       "KejQ633dOXY//7rs7slcySOpykHzoJT//+IluJFn35UnyRm4eMyw5FtH4RUP" +
       "ghDGubcMq3mR/gZvmKHwzBwzdh31+Z//r5/5nU8/+01oPyRyV5LHq9DQTs0U" +
       "0zjfw/zZlz/79vte/NbPF6tBiNfsc+v//sGc6stvTqzHc7FYNw5kMJbCaFIs" +
       "4ICSS3bRCNxpQRZ/ZGmjm/cTtXDUOfpNFhK+TOXyRkhQN0tobGORk5o9ncpx" +
       "babrmsatQ9nB6ag5HM0X9G65aqGVMjMxwt1uspMapY47ooZ93Z8t0qhPLXxz" +
       "2tFHqsQv+uOVwroC2esuyuOF6atjftQb9IlFR+NnDSLBdmgqx80pvfS9oR1g" +
       "GwzDqvWommCcUq8RZXYFdNNiPbvc3Ql+l4j4cGu63bBUZRdjLeh3y9ZYJ5YC" +
       "Xt2BzZJQUHswo83Rap4Cle+umAo7mNPDdGoG/mzl+fioPNAIae5qpuGW/V7N" +
       "t0nK75G4Z2oEI41HJmtLie2LtRVFq2RJ361IvzEl1bKkZPiKpOq41DEzXSeV" +
       "jV6tZLTJWWxZBptab7rJxhF0mzCtNXfkpORxK8pNqVBKve162BdJI6LFUlgq" +
       "z+ubgbbcscbUVoZRK7CXOF4nnUGoqoHYM+ZtTEmmo37GdMX+YM6TdCY2to6m" +
       "+0zJYfFpzw+q3Hg6HABWKmmiGrGNnheaZtDdDF1ayGLcmgYbmpJw1NEDkSM3" +
       "VKU3iDhyKekdVhRHfUFn1+4sFHGzMit1aqJfQimlM6OrLYyRZb02Xo6zaLnc" +
       "JYQYrzeWOByqyshtcKXRztT7QwJnU7Hj9mY7llgao3rFbswINhjhW7Rhxvia" +
       "KlUVqLltf0rVKLG7EdarkBgEfbHcNusEDwex1q8yui/59ba5XqmihfGLjOwk" +
       "vZQOS1p5Q69maNypTcp9Dbd7qaUqmThCOZFkxch0tJa+qzDmwlA77mAhSm7D" +
       "RXnAU+koNLtiPAootTfZNNINu1hxmuSuRt2GLomDlQobl8iaIWo2tZ6NnKpj" +
       "OumYM8u6anZmZmlXJirw0/14txl42wbYtJX5JowXnujX5iQ+1OhFeTBE7bDr" +
       "TxdERNbohVjBiWqvE/tLslLjPQ5NqX5KER7m0q0dzQhEdevGy0irY5ZYWQm0" +
       "MqnG5JISzUBm2ka69bYxCYAwmju8bXsjn0iZems3NiORBqVGD+9NIiPrV11s" +
       "bdc2PCNUm1Fn4wF7yvVZaeluI3NSGQx3/nBVYqV1I+NZLbZ7rEJmE9f0Gzpa" +
       "Jdi5MOnXSRxdBpsS2e3uONWz2tCj5ADtav1pZ+YuFrPqhFzyowgAaTVqpGBR" +
       "M7QB152hgbpcjGsMJgYmXPXOJ9WZjXco3WfdUGLjUdIe9vAxPZpoFbK36mcG" +
       "uyI4Udf05tCmnZnSk5Y7aW648SD0fJNcjQlUnvXmvCxsLa5hbUrcTFq7O6oF" +
       "pZ/qgDAXpUqCZVXOXmxRNoMgsZiG8mYy5NJovfQdSmyw0XbdBCmK8j2/u2xM" +
       "Gn18Oe9X2Y4076si60r9ebTwKdmidc9ckPhose4OcJYcplsXZGG/5xqyskga" +
       "SbVKWlY5Epe4V7HUeqPjM5FjbpekzAlguzC7IyaK5olQ7bbq/FRbeDV1vCJd" +
       "EZpRv0wRjLrVuCiz5yu6MZO1iHN9sVlyM7sblfkZhypdfyHpaVgGrlsWCIUc" +
       "TOUhnfZ1qgbwUg2bA2jKaEuOK01DadUmZrNT9dFOQG07MHBUWbnUR+vmplWS" +
       "ZqtqKCnkroYCJqTLKzNwjLkltmWcpVltt2wZm2RoZpSw01YKx6Hb0WQ8YNRA" +
       "S/AYd/oDco0BLNWocoVOF+q4LXRaJO6L6UyMKqlYrmsqazM0bjBANKRNxxbn" +
       "erXR6nuNVV0xwkEVOBKn0fWWRCvx2lD95QrH4nJcQ1Fs0hS5aVaZ2l7JmhPt" +
       "8jCrzhfdfjkkdWE9NSItKrExIQ+rsr1uViNMrKztSRXXV8JA0IxuOAt1oqHO" +
       "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" +
       "owXVJqYztetk/EgxDBtEVq+xImNvTqH2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("clkRQl8u1fO4fcPvGsO0kilmHUvFhjbKUg1fdDqd978/3xb6tTe3XfVwsQt3" +
       "fBnuR9h/21c9nSfvON7FLH7XkHMXqE7tYp45lgkD5O2X3XErNom/8NEXX1Lo" +
       "L5avHm5vfjpC7o1c770WSIB1itSdr30UOymu+J0cef/mR//sce4D2ofexIWf" +
       "J8/xeZ7kv5i8/NXhO+V/cBW54/gA/FWXD892ev7ccV0AojhwuDOH328/1mx+" +
       "9lFcumkcarZxfn/4ZOxeZQVX82xcWMHeAM5d3zh3BeTWRQcitCe7CmAjSTZv" +
       "jSJgF4R+7zXugfxBnnw1Qh51QGptj+85AWV/eJfX/tMTU/ut19v8PE2+KPiN" +
       "sxeSnoTP6FA3ozehm+KE7l1vRC1PuIF6IHmSrIGDtQys/dlofrPwAIeqKUj8" +
       "59dQyLfy5I8i5K7iEPzCXeHE1ZUTnXztrE7uP9bJMUs3Tx2JJiAIdAW8hse+" +
       "MUU+Cx/mUJHM/1NF5n8/WTT43muo6b/lyXegp4dSuje6vOCPT9Ty55eqJS/+" +
       "k/8bBeR3P5Gn4POxQwV87M0qIL5QAafl++vXqPthnvxVhDwgHR39gm6snpP/" +
       "f74ZV8ki5J1v7KZlfm3sra+6GL6/zCz/yks37nnspcUfFZcNjy8c3ztG7tnE" +
       "lnX69s6p/DUvABu9EOze/V0eL39duRYhj19+MTRCru0zuSxX7tp3uTdCHrmg" +
       "SwS/f5g93fr+CLl+0jpCrspnqm9EyN2H1RFyB0xPV96ERbAyzz7iHfnZey5i" +
       "t8CAU7DYK7h2g+zK2VnueOBuvt7AnZoYn7309ssk3l/svy1/6SVy+lPfb3xx" +
       "f5MSotFul1O5Z4zcvb/UeTx9PX0ptSNa14jnfvDgr977jqOp9sE9wyfmfoq3" +
       "Jy++tti3vai4aLj7tcf+1fv+2UvfKM7U/g/XYNVEbzEAAA==");
}
