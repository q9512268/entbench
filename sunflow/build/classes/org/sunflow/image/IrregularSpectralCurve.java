package org.sunflow.image;
public class IrregularSpectralCurve extends org.sunflow.image.SpectralCurve {
    private final float[] wavelengths;
    private final float[] amplitudes;
    public IrregularSpectralCurve(float[] wavelengths, float[] amplitudes) {
        super(
          );
        this.
          wavelengths =
          wavelengths;
        this.
          amplitudes =
          amplitudes;
        if (wavelengths.
              length !=
              amplitudes.
                length)
            throw new java.lang.RuntimeException(
              java.lang.String.
                format(
                  ("Error creating irregular spectral curve: %d wavelengths and " +
                   "%d amplitudes"),
                  wavelengths.
                    length,
                  amplitudes.
                    length));
        for (int i =
               1;
             i <
               wavelengths.
                 length;
             i++)
            if (wavelengths[i -
                              1] >=
                  wavelengths[i])
                throw new java.lang.RuntimeException(
                  java.lang.String.
                    format(
                      ("Error creating irregular spectral curve: values are not sort" +
                       "ed - error at index %d"),
                      i));
    }
    public float sample(float lambda) { if (wavelengths.length ==
                                              0) return 0;
                                        if (wavelengths.length ==
                                              1 ||
                                              lambda <=
                                              wavelengths[0])
                                            return amplitudes[0];
                                        if (lambda >= wavelengths[wavelengths.
                                                                    length -
                                                                    1])
                                            return amplitudes[wavelengths.
                                                                length -
                                                                1];
                                        for (int i = 1; i <
                                                          wavelengths.
                                                            length;
                                             i++) { if (lambda <
                                                          wavelengths[i]) {
                                                        float dx =
                                                          (lambda -
                                                             wavelengths[i -
                                                                           1]) /
                                                          (wavelengths[i] -
                                                             wavelengths[i -
                                                                           1]);
                                                        return (1 -
                                                                  dx) *
                                                          amplitudes[i -
                                                                       1] +
                                                          dx *
                                                          amplitudes[i];
                                                    } }
                                        return amplitudes[wavelengths.
                                                            length -
                                                            1];
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
