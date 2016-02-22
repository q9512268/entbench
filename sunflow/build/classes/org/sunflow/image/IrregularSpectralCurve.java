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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
