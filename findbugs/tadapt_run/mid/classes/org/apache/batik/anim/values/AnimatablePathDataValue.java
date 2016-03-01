package org.apache.batik.anim.values;
public class AnimatablePathDataValue extends org.apache.batik.anim.values.AnimatableValue {
    protected short[] commands;
    protected float[] parameters;
    protected AnimatablePathDataValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatablePathDataValue(org.apache.batik.dom.anim.AnimationTarget target,
                                   short[] commands,
                                   float[] parameters) { super(
                                                           target);
                                                         this.
                                                           commands =
                                                           commands;
                                                         this.
                                                           parameters =
                                                           parameters;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatablePathDataValue toValue =
          (org.apache.batik.anim.values.AnimatablePathDataValue)
            to;
        org.apache.batik.anim.values.AnimatablePathDataValue accValue =
          (org.apache.batik.anim.values.AnimatablePathDataValue)
            accumulation;
        boolean hasTo =
          to !=
          null;
        boolean hasAcc =
          accumulation !=
          null;
        boolean canInterpolate =
          hasTo &&
          toValue.
            parameters.
            length ==
          parameters.
            length &&
          java.util.Arrays.
          equals(
            toValue.
              commands,
            commands);
        boolean canAccumulate =
          hasAcc &&
          accValue.
            parameters.
            length ==
          parameters.
            length &&
          java.util.Arrays.
          equals(
            accValue.
              commands,
            commands);
        org.apache.batik.anim.values.AnimatablePathDataValue base;
        if (!canInterpolate &&
              hasTo &&
              interpolation >=
              0.5) {
            base =
              toValue;
        }
        else {
            base =
              this;
        }
        int cmdCount =
          base.
            commands.
            length;
        int paramCount =
          base.
            parameters.
            length;
        org.apache.batik.anim.values.AnimatablePathDataValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatablePathDataValue(
                target);
            res.
              commands =
              (new short[cmdCount]);
            res.
              parameters =
              (new float[paramCount]);
            java.lang.System.
              arraycopy(
                base.
                  commands,
                0,
                res.
                  commands,
                0,
                cmdCount);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatablePathDataValue)
                result;
            if (res.
                  commands ==
                  null ||
                  res.
                    commands.
                    length !=
                  cmdCount) {
                res.
                  commands =
                  (new short[cmdCount]);
                java.lang.System.
                  arraycopy(
                    base.
                      commands,
                    0,
                    res.
                      commands,
                    0,
                    cmdCount);
                res.
                  hasChanged =
                  true;
            }
            else {
                if (!java.util.Arrays.
                      equals(
                        base.
                          commands,
                        res.
                          commands)) {
                    java.lang.System.
                      arraycopy(
                        base.
                          commands,
                        0,
                        res.
                          commands,
                        0,
                        cmdCount);
                    res.
                      hasChanged =
                      true;
                }
            }
        }
        for (int i =
               0;
             i <
               paramCount;
             i++) {
            float newValue =
              base.
                parameters[i];
            if (canInterpolate) {
                newValue +=
                  interpolation *
                    (toValue.
                       parameters[i] -
                       newValue);
            }
            if (canAccumulate) {
                newValue +=
                  multiplier *
                    accValue.
                      parameters[i];
            }
            if (res.
                  parameters[i] !=
                  newValue) {
                res.
                  parameters[i] =
                  newValue;
                res.
                  hasChanged =
                  true;
            }
        }
        return res;
    }
    public short[] getCommands() { return commands;
    }
    public float[] getParameters() { return parameters;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        short[] cmds =
          new short[commands.
                      length];
        java.lang.System.
          arraycopy(
            commands,
            0,
            cmds,
            0,
            commands.
              length);
        float[] params =
          new float[parameters.
                      length];
        return new org.apache.batik.anim.values.AnimatablePathDataValue(
          target,
          cmds,
          params);
    }
    protected static final char[] PATH_COMMANDS =
      { ' ',
    'z',
    'M',
    'm',
    'L',
    'l',
    'C',
    'c',
    'Q',
    'q',
    'A',
    'a',
    'H',
    'h',
    'V',
    'v',
    'S',
    's',
    'T',
    't' };
    protected static final int[] PATH_PARAMS =
      { 0,
    0,
    2,
    2,
    2,
    2,
    6,
    6,
    4,
    4,
    7,
    7,
    1,
    1,
    1,
    1,
    4,
    4,
    2,
    2 };
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        int k =
          0;
        for (int i =
               0;
             i <
               commands.
                 length;
             i++) {
            sb.
              append(
                PATH_COMMANDS[commands[i]]);
            for (int j =
                   0;
                 j <
                   PATH_PARAMS[commands[i]];
                 j++) {
                sb.
                  append(
                    ' ');
                sb.
                  append(
                    parameters[k++]);
            }
        }
        return sb.
          toString(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "yJE23375G9/84zseeKWApZsFPigmgIsnA7ir47NjYVchjtsPuM0n4PzhzK07" +
       "Znf3EIpv6GQo+LqkyvCMG+zMXCad/eBdtsN2Ubo/DX+fRs5t/clTlim+bgHQ" +
       "jPdCO/j5u79hfO4vfm0Xtp2MA09Ulj/2wsf/+sonXjh7JFh+7Kp49WibXcBc" +
       "qOqOnar+GvzOgOv/5Veuojxjp6q7O3tR28MHYZvr5uw8chpZxRD9//KF5//5" +
       "P3n+ozs27j4eK/bAUujX/u3//dqVz/7Z718j6DgHnNYPD9xgH+lOlWI/N9TD" +
       "ifa+/02bwkf+83evQqUiPriGYE+0X8Mvf+7+zvu/WbQ/nKjz1g+mV4dTwMkO" +
       "21Z/1fpfZx89/6/OQhfW0GVxb8lXREZg+lsDNwr214FgWXis/PiSZRefP30Q" +
       "iLzzpGaPDHsyRDiUKHjOaxcefYjA/fQMVIDO6tr4dTZ/fAboQtFt3izakQDS" +
       "TNlWQ62oPCryduhGh9BNABzyx56bHmju7F58tzdH7Wa3nDWwCHJsOZ8o98t2" +
       "saLuXDlYgILC9Bo28NT1bYAswOhQEb/3kf92P/t+7YNvIEh86IRiT3b5K+TL" +
       "vz94l/ips9BNB2q5anV6vNHTx5Vx0ZfBctpmj6nkgZ1KCvnt9JEn7y8kfMpM" +
       "bZ1SVqyNNkCBYi7qnWZOqe7vzYedA/y+f3/l9O692erdO1CQb/xiBoRBjn8Q" +
       "puzD9d/MQOm1jBm4ksNfjUD5O5sn4b73fOg078mTH965Tp78SJ48myfB1T6S" +
       "vwp5Il1t9Pm7uhu2aJ0nxim6/MgpZX8/Tz6cJ+6OklPq/kS6u7dPqfOxPHm6" +
       "KELz5H078huvK+Da1b2veLuwk+7xFUtufk/smd8TJ6OvPRX81HUCsPzxPfvA" +
       "dYvoWBawm6JW7zBuK2j+xGvRfIKqR8D11B5VT12HqhdeD1UXi30+GQRVwYFi" +
       "j9D16ddP1w/muefB9coeXf/0OnT9o2vTVQSZ7wEAHxRbhEcsN4TumGDs8LkO" +
       "TZIY1Z2dQImCnLcBxu7cjbu7h1B6Q5033xPlkxAGjgtCLtEBwAuHuqLA7Kjf" +
       "7+q+nEf8233g+L6NfU0suVnU9vZsrwklv7ivmV95U1Dy0puEkl8sOnvptaDk" +
       "i6eU/XqevHIAJS+dBiW/kUInjPtzb8K4v7Rn3P/sOsb9m6cZd578wjHDvq0w" +
       "7Ak2xciTZl0sXi6BJRu1G3F3DyHvxs5JrhvAQawKvpMEsg9TwLgmumjIPuhP" +
       "Nvft+W9+0EJCz17faL+yL/HfeVNG++U3abRfKTr78msZ7VdPKfvXefK7B0b7" +
       "5dOM9mtXGe1vvabR7nz/DFj+n6teaVwp5+//5hSzfOZqs7x3Y4qP76+8ODA3" +
       "gFDl8Y3Z2A+VLx+G0buPGieIJF83kSCcvvOwM8Kx1ad/8s8/+bWffuwbYN2D" +
       "Q+eKbV4QFR8ZkYryT0Y/8fKnH7jthT/7yWI/Dqho8pne5Q/kvf7JG2P1/pzV" +
       "WWGpBB+EZLF/JksH3J6EUhDKvnluw7teHaLBCNv/kRwv17B5OrVjZBkoUisl" +
       "hhtbTtFeH/Ua6KZr6hOsziQZskI6Pa4LL1ZWqdoY1CxpsFjXG+mKZIQe2Sd6" +
       "QQfuhVwvY3BMaIOljbXQ3JnOw9v+yuJK3bXuLrdqXzE2K2NMloRGZK2RYUOt" +
       "y3PC5cpZ0EAkeAkvEaWBhOWs1KhZ+HSNW0aKd8pmKml1teKlOIXauETrHlPj" +
       "Am/LNYnpBIkFml1HNOwtPUtX3caW22jbmT+rrYLImGl84Hs4R86zxXiGm5RP" +
       "83PX7el8ZUxYAcnMl3JgounMJ6tVR/e2CbGp9EUR87bzLdN2jHResick5bpk" +
       "tW0snHGMB7Vlr9qcdC2NMNrummrxjTZZLqlqbTJEa1QEU+sNxdi+Oxu4S30w" +
       "XjhNh9MDYhHNykkqLdmSU9fTQbBNq+7So/2VZurLybZCdbcMVbXTKip6keTx" +
       "+KjMLiRxOo6Ehe/U2T6JzyOxtOSzWUgsaHikz3FSXWXV9mChTWh3OFhRWJ2l" +
       "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" +
       "FVOGS0QNZAWpuCWyB5byZbO38qaupKDa");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("OhRG1oDl68ZMI0sSZwSmovtrLm7EViq2ZLB+25pVqWdPJKrLTxyj2qrDk6Wh" +
       "DoZib8ZxNs+QHWPLg1Av0FtrH+EYmbIrwyq9bMmGQMTCaKW3dK48KqFra9uv" +
       "RLyMxmFtavrbDJ5kcINifNnZVPrbEYL3KUFuO4RFrhCzHi3mpkGHTBkdO3F5" +
       "MV9lTkDGDudptZHsLFduhizhdn1EpHa5NcYwLN/K+fM3tsV0V7GbdnBeeGM2" +
       "8oKvv4FdpPTIF9mDDWJof0/62BnTI3vSRz5tQfmRiQeudwy4OC7x+Y+88KJE" +
       "/1Ll7N7W4ySEbg0d94dMGUxhV30lU49vjb8LXHt07+5Ht8YPGb32x6hndoI6" +
       "sQ16rqhwbn/L8b2v8xhocYghb/PdPEkOnp4tBvmrU/Zav5cn/yOEbivOGAFZ" +
       "8eGuo0Md/c838mnxhJzuyTMfBNeP78npx2+MnI6wcObcKWUX8gQC7Kly2Dn6" +
       "KfKAvTNn3ip7D4Pr43vsffzGs3fXKWX35MntIXQHYG9y/JvmIYN3vFUG8xMJ" +
       "n9pj8FM3nsEHTil7KE/uC6ELIm9P9g/AndidviA4jinz9iHHP/AWOC5AJnfv" +
       "n9vj+OduDMdnDit8t2DtvaewfSVP3h1CFyV9d5iFLY6VJIcsvuctsFiAV36q" +
       "5KU9Fl+68UptnlL2t/IECaHbgdWuZd85RK9D/tC3wN/deeYD4PrtPf5++8bz" +
       "1z2lrJ8nzwDQCZ3dh6KpXIz79UP2PvCGjmuE0L3XOfKfH16+76q/I+3+QiO+" +
       "8uKlW+59cf7vdsdL9//mcisB3aJEpnn0oNqR5/OuLyt6wf+tu2NrbsEUmNLf" +
       "edpsFELndw85+WeIXSMwnb79mo1C6Ob8drTuLIQun6wbQueK+9F6HHCLw3pg" +
       "2N3D0SqrELoJVMkf1+7O484cjwv2FQHd/VqKOBJKPHbsCFxxhmT/uFq0+7fY" +
       "c+IXXsSpD32n/ku7E/uiyWdZ3sstBHRh9+eBotP8yNsj1+1tv6/zwye/d+cX" +
       "b31iPzi5c0fwofEeoe2ha5+N71luWJxmz37r3t943z9+8U+LL4f/H3xvwsXE" +
       "NwAA");
}
