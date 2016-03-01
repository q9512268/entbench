package org.apache.batik.anim.values;
public class AnimatableNumberOptionalNumberValue extends org.apache.batik.anim.values.AnimatableValue {
    protected float number;
    protected boolean hasOptionalNumber;
    protected float optionalNumber;
    protected AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n) {
        super(
          target);
        number =
          n;
    }
    public AnimatableNumberOptionalNumberValue(org.apache.batik.dom.anim.AnimationTarget target,
                                               float n,
                                               float on) {
        super(
          target);
        number =
          n;
        optionalNumber =
          on;
        hasOptionalNumber =
          true;
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
                target);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                result;
        }
        float newNumber;
        float newOptionalNumber;
        boolean newHasOptionalNumber;
        if (to !=
              null &&
              interpolation >=
              0.5) {
            org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue toValue =
              (org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue)
                to;
            newNumber =
              toValue.
                number;
            newOptionalNumber =
              toValue.
                optionalNumber;
            newHasOptionalNumber =
              toValue.
                hasOptionalNumber;
        }
        else {
            newNumber =
              number;
            newOptionalNumber =
              optionalNumber;
            newHasOptionalNumber =
              hasOptionalNumber;
        }
        if (res.
              number !=
              newNumber ||
              res.
                hasOptionalNumber !=
              newHasOptionalNumber ||
              res.
                optionalNumber !=
              newOptionalNumber) {
            res.
              number =
              number;
            res.
              optionalNumber =
              optionalNumber;
            res.
              hasOptionalNumber =
              hasOptionalNumber;
            res.
              hasChanged =
              true;
        }
        return res;
    }
    public float getNumber() { return number;
    }
    public boolean hasOptionalNumber() { return hasOptionalNumber;
    }
    public float getOptionalNumber() { return optionalNumber;
    }
    public boolean canPace() { return false;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        if (hasOptionalNumber) {
            return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
              target,
              0.0F,
              0.0F);
        }
        return new org.apache.batik.anim.values.AnimatableNumberOptionalNumberValue(
          target,
          0.0F);
    }
    public java.lang.String getCssText() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        sb.
          append(
            formatNumber(
              number));
        if (hasOptionalNumber) {
            sb.
              append(
                ' ');
            sb.
              append(
                formatNumber(
                  optionalNumber));
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
      ("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" +
       "zzTdK8ezxcqbJjpZZBH+uOp/NOF4Pd8hAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "p1EfqcktSSEF2R/HcmntL5ZatSWbuoVR6rJHjZpaxk6YzbC27sFpzPe4tN9h" +
       "lcFSRiTFNQNvIqTGJitzXTckHLq02HAaKmH1DoxRccbO64PhNhyJfq1estYh" +
       "NTJUQrexjh+pTXedKhO77pYqasmhQzNDYT3ldHPtmEFjJGgJYVtMT12qgzbG" +
       "NvvISPGqTb7RMeF6xmsSWdqQHmySCNHJZdYa8byWzJi1s+k1qw3GkWc1oVwP" +
       "pIG5FJqLUC3h22Um1tu4PCMIr9nzvTpOOiEVcXI781CzkcmsExKijuq20oqZ" +
       "FryRt2ml0VuqTlrlmmUVayJUPla5NcysDW6SFTWVsSbcVPr9kmb1yGqNX2WV" +
       "2tA1abOhs7MomzZKab3LWo25KxExh5TBTiGoxRvgkpuQw+ax72JYsiFK/W7M" +
       "EfzasFt1c4BOVVZdLbZJJIidwdprVjZjbmiIJaM81det8XwVttExU9M8UicH" +
       "EZ8OgkFIblS+NMC5eYoz3f7UBktnA8eHQw1fVOsgxy0plAuMZ9OamWkkgbVk" +
       "nPqMLzG+b6ODiKv1421nrM6DEjcNEN9DSypZXY+3SlTBcHmilBSLUEQjFHrj" +
       "iOjLgwlwCCVqqWtkOlhP3KGNCKhcstwtlSJubPKYg0yXEuyjXAiHup/ZnpkM" +
       "CHmLVfwK2MrAC3yNNxqJLUcTuNVcpFuDb7ErJ425setux+msjIZTdF7vebS3" +
       "4HFaNud4wqrBuI52KtKCp9FedZKabdZnGGwzHxBdmWvI/qiM05TA0v00IYzK" +
       "AlsR1UZ7NhMSL1xblZUyLae2aqySsWyYpM2Hq1WZdTqLJK2nlt2rS4hYHyvm" +
       "OKwut+uM77eqnWkTn5UId4pTpb6tlrtDF0EXXTddVybGdjuV+w0FxO21SJv+" +
       "atXqlWLWh4dsp8aBnRLYjf9ovk3/2Td3fPBQcVJycpvAtLG84eU3cUKQ3ems" +
       "tvi7Au19gd4/q338+Iw4gJ662yWB4pD7iy+/8qrMfgk5ODqjpSPoWuT5P2Ir" +
       "iWKfYXUf4PT+ux+5Doo7Eqfnnl9/+X8+Mf2g/tE38YH0XXty7rP88uArv919" +
       "r/SzB9A9J6egt93eON/phfNnn9cDJYoDd3ruBPSpk5nNDz+h94JncDSzg/1z" +
       "u1Pd3fnQ7kM73e8dgV8uCC4fn5A9/wa/bxeHwHmfL5+c+X35TudO9xju7kPD" +
       "L1xw9P7VvPiXEfSO4h4MmDQhUk45Fpb4xTf97eFfnExdYZhPgCc5mrrk7Zm6" +
       "sxD+3QVtv5YXvwpMV1OiM+ekp+C+9hbAPZJX3gLPS0fgXnr7wf3mBW1fz4vX" +
       "7nR+nTd4pyB/461qMD/y/4kjkD/x9oP85gVt/yUvvgFAAg3eDvKMJv/TW9Vk" +
       "bqY/cwTyZ95+kH98Qdu38uIPI+iqJLicICl7+vujt6q/PIK9cgTtlbcH2qVT" +
       "gi8XBH9xAb5v58WfRdB12dgF4Km3p73//hYgFvE5/wL0c0cQf+7t195fXtD2" +
       "13nx3Qi6H5joSgm80wB9iu/1t4Dv4bzySfB86Qjfl952fJcuXdBWJDJ/A7QH" +
       "8LVBigAW+bzm5VN0f/umPthG0LNv4LZWfu/k8dtum+5uSEq//OqN+x57dfYH" +
       "xYWlk1uM1xjoPjW27bOfNc+8X/EDRTWKqbi2+8jpF/iuR9CTF629EXRl95JD" +
       "uXRt1+mBCHrnHTtF0L35v7O0NyPo5j5tBF0u/p+lewTM8SkdGHb3cpbkUbCu" +
       "A5L89TF/53yXzid2J0p5+Psp5Uwu+Oy5DK64CnycbcW7y8AvSl99lR5+7PX6" +
       "l3aXrSRb2G5zLvcx0NXdva+TjO09d+V2zOtK77nvPfgr137oOLt8cCfwqR2f" +
       "ke1dd77WRDp+VFxE2v7bx371A//q1T8pPuv9PwO2UvCjLQAA");
}
