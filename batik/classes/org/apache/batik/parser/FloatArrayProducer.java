package org.apache.batik.parser;
public class FloatArrayProducer extends org.apache.batik.parser.DefaultNumberListHandler implements org.apache.batik.parser.PointsHandler {
    protected java.util.LinkedList as;
    protected float[] a;
    protected int index;
    protected int count;
    public float[] getFloatArray() { return a; }
    public void startNumberList() throws org.apache.batik.parser.ParseException {
        as =
          new java.util.LinkedList(
            );
        a =
          (new float[11]);
        count =
          0;
        index =
          0;
    }
    public void numberValue(float v) throws org.apache.batik.parser.ParseException {
        if (index ==
              a.
                length) {
            as.
              add(
                a);
            a =
              (new float[a.
                           length *
                           2 +
                           1]);
            index =
              0;
        }
        a[index++] =
          v;
        count++;
    }
    public void endNumberList() throws org.apache.batik.parser.ParseException {
        float[] all =
          new float[count];
        int pos =
          0;
        java.util.Iterator it =
          as.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            float[] b =
              (float[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                b,
                0,
                all,
                pos,
                b.
                  length);
            pos +=
              b.
                length;
        }
        java.lang.System.
          arraycopy(
            a,
            0,
            all,
            pos,
            index);
        as.
          clear(
            );
        a =
          all;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        startNumberList(
          );
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        numberValue(
          x);
        numberValue(
          y);
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        endNumberList(
          );
    }
    public FloatArrayProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVaDXAV1RW+7yUkISEkhF8RAoQAw4/voZX6E7RCCBJ8gUgw" +
       "nYafsG/ffcnCvt11977kEUtVph1pZ2T8wZ86SjtTFLQojlOnWqvScUSpP1N/" +
       "WrVWtNW2WuoodbRObbXn3Lv79ue9fWmsyczebO6ec+49557znXPvzeH3yRjL" +
       "JI1UYzG206BWrE1jnZJp0VSrKlnWRujrlW8pkz7a+u6686KkooeM75esDlmy" +
       "6GqFqimrh8xUNItJmkytdZSmkKPTpBY1BySm6FoPmaxY7RlDVWSFdegpigTd" +
       "kpkgEyTGTCWZZbTdFsDIzATMJM5nEl8R/NySIONk3djpkk/zkLd6viBlxh3L" +
       "YqQ+sV0akOJZpqjxhGKxlpxJFhu6urNP1VmM5lhsu7rMNsHaxLICEzTdX/fJ" +
       "Z9f113MTTJQ0TWdcPWsDtXR1gKYSpM7tbVNpxrqcfIeUJUiNh5iR5oQzaBwG" +
       "jcOgjrYuFcy+lmrZTKvO1WGOpApDxgkxMscvxJBMKWOL6eRzBglVzNadM4O2" +
       "s/PaCi0LVLxpcXzfLVvrHygjdT2kTtG6cDoyTILBID1gUJpJUtNakUrRVA+Z" +
       "oMFid1FTkVRlyF7pBkvp0ySWheV3zIKdWYOafEzXVrCOoJuZlZlu5tVLc4ey" +
       "/xqTVqU+0HWKq6vQcDX2g4LVCkzMTEvgdzZL+Q5FSzEyK8iR17H5EiAA1soM" +
       "Zf16fqhyTYIO0iBcRJW0vngXuJ7WB6RjdHBAk5HpoULR1oYk75D6aC96ZICu" +
       "U3wCqrHcEMjCyOQgGZcEqzQ9sEqe9Xl/3fK9V2hrtCiJwJxTVFZx/jXA1Bhg" +
       "2kDT1KQQB4Jx3KLEzdKUR/dECQHiyQFiQfPzb5+6aEnj0acFzelFaNYnt1OZ" +
       "9coHkuNfmNG68LwynEaVoVsKLr5Pcx5lnfaXlpwBCDMlLxE/xpyPRzcc+9ZV" +
       "99CTUVLdTipkXc1mwI8myHrGUFRqXkw1akqMptrJWKqlWvn3dlIJ7wlFo6J3" +
       "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" +
       "5dcbPIqTofuiCL8MS+Lbuf8FnkLwJ4UlAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "09vV8jFwBYdaBu+8ln/6Vlr+j6L4YzCT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("pSvv8eycjl9+uzoWH4bzQx3zd0bHCyffHV848du/eCtt/7Io/mdYuc1zD79A" +
       "ntLzf71dPb8bXK8c6vnKOz6XB7e+hXYHF4vqN8PyROb1ZvKg8u1omIaVB649" +
       "ZFicknrkmmPM+6O3ymdfu3THw68t/u3+nMHR8dg7ycodemTbpw+1nKpf9HxN" +
       "N0vt79wfcfFKbe4NKw/fAJOLQ2hlpRD64J49/eWwcvk8PZjp8v803YNh5a4T" +
       "OsBqXzlN8lBYuQWQFNWHvaMFonqjBQLXdCmyTy0DR/nAwakl/dD0paM98FbT" +
       "cNzl9DG94gt2ecz86GtzxB4exvnca2P6Q19Hf2p/TFCxpTwvuNxBVm7fn1gs" +
       "mRZfrJ+6IbcjXheJ575x38/f+cxRinLfXuAT7z0l2xPXP4fX33pheXIu/+cP" +
       "/7Pv+8ev/WH5te//A7hiCrD/LwAA");
}
