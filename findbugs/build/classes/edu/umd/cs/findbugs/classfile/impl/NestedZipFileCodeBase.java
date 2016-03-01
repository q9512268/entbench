package edu.umd.cs.findbugs.classfile.impl;
public class NestedZipFileCodeBase extends edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBase {
    private final edu.umd.cs.findbugs.classfile.ICodeBase parentCodeBase;
    private final java.lang.String resourceName;
    private java.io.File tempFile;
    private edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBase delegateCodeBase;
    public NestedZipFileCodeBase(edu.umd.cs.findbugs.classfile.impl.NestedZipFileCodeBaseLocator codeBaseLocator)
          throws edu.umd.cs.findbugs.classfile.ResourceNotFoundException,
        java.io.IOException { super(codeBaseLocator);
                              this.parentCodeBase = codeBaseLocator.
                                                      getParentCodeBase(
                                                        );
                              this.resourceName = codeBaseLocator.
                                                    getResourceName(
                                                      );
                              java.io.InputStream inputStream = null;
                              java.io.OutputStream outputStream =
                                null;
                              try { this.tempFile = java.io.File.
                                                      createTempFile(
                                                        "findbugs",
                                                        ".zip");
                                    tempFile.deleteOnExit();
                                    edu.umd.cs.findbugs.classfile.ICodeBaseEntry resource =
                                      parentCodeBase.
                                      lookupResource(
                                        resourceName);
                                    if (resource == null) {
                                        throw new edu.umd.cs.findbugs.classfile.ResourceNotFoundException(
                                          resourceName);
                                    }
                                    inputStream =
                                      resource.
                                        openResource(
                                          );
                                    outputStream =
                                      new java.io.BufferedOutputStream(
                                        new java.io.FileOutputStream(
                                          tempFile));
                                    edu.umd.cs.findbugs.io.IO.
                                      copy(
                                        inputStream,
                                        outputStream);
                                    outputStream.
                                      flush(
                                        );
                                    delegateCodeBase =
                                      edu.umd.cs.findbugs.classfile.impl.ZipCodeBaseFactory.
                                        makeZipCodeBase(
                                          codeBaseLocator,
                                          tempFile);
                              }
                              finally {
                                  if (inputStream !=
                                        null) {
                                      edu.umd.cs.findbugs.io.IO.
                                        close(
                                          inputStream);
                                  }
                                  if (outputStream !=
                                        null) {
                                      edu.umd.cs.findbugs.io.IO.
                                        close(
                                          outputStream);
                                  }
                              } }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseIterator iterator()
          throws java.lang.InterruptedException {
        return new edu.umd.cs.findbugs.classfile.impl.DelegatingCodeBaseIterator(
          this,
          delegateCodeBase);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseEntry lookupResource(java.lang.String resourceName) {
        edu.umd.cs.findbugs.classfile.ICodeBaseEntry delegateCodeBaseEntry =
          delegateCodeBase.
          lookupResource(
            resourceName);
        if (delegateCodeBaseEntry ==
              null) {
            return null;
        }
        return new edu.umd.cs.findbugs.classfile.impl.DelegatingCodeBaseEntry(
          this,
          delegateCodeBaseEntry);
    }
    @java.lang.Override
    public java.lang.String getPathName() {
        return null;
    }
    @java.lang.Override
    public void close() { delegateCodeBase.
                            close(
                              );
                          if (!tempFile.delete(
                                          )) {
                              edu.umd.cs.findbugs.ba.AnalysisContext.
                                logError(
                                  "Could not delete " +
                                  tempFile);
                          } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "is2n/wUAaB+Frh4AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lLeGy6tSEKZ2I5r1u7wS8V5bYbmY88Umu4n3WJN0+RmxFLpBWHPGeyVet+nt" +
       "kFvtqHUNHdiO3nEpWaFX7WQS0sSk3aUROJ122iOtQw6IATxPlXVv4iVB0gu8" +
       "Tj6X6Ekc+2rLVpRtP+MntCbNWcGbz3lC3yZrO5uH810yGIySzQ5ejHr2rqav" +
       "xAGFyvIS3bX1/QAdzuds6Iqbndk2gjYJtipWg9u67Mbod/fLfS1Mcrorr2Y2" +
       "JRuahSrsqLbcutuGEWDRDs1FVNtSnTW151s5Re9qeYPohY0121uhkdccNLmx" +
       "kSp+pGKuPduOonwsjtYsGis+X1v1BMwbo1J9Ju3YVZ8sJuQOOP+isfX4bKIq" +
       "UcrNaluNWY6Gc0naLPS62EbjvevKSleJMyyeE4JUU7MOaslZdxRw6cqZ5YXV" +
       "m+1xktH9hqxI45wkQrHNzNGhWXQsl9xNba27ZneslZpjuUPwariV+jLFT1vW" +
       "PGpRFMvj3Gyq2uYskbcOV9v0NU0Cv2IctOtMuKW3ylw1yU7XGU4na46ew6kz" +
       "JFeeKrWbSl8yk6JGxTUlH+87HJuLTq2wfYyfhRu5xhMDhC7SBUGgzGK7oCad" +
       "hj+VaW6MJHQH7bIrbGMXKN8ZdwtlhSyFGbtgHAfP1qtBb0MqDNcO9xbOJGFD" +
       "5eezJqLqzeXcM0Zy1kD5iGo1sTWCred+0moYctB1UICbfDrarIqFNzOm8Vpb" +
       "bAyqrzp5TjEUTNjbJYbA2TZdIpOeyLvCxgu5WXOnw3R/Gopyba4y/fk2nIyx" +
       "cc2fTNZbLkwb8JCb2aOMlz3X8NoLzhtOXGcikym8RbNVNqCp/pwnuWbaNeS1" +
       "qMLNpqCxJNLAZXLSqbXCbtOU9Cnc6rf7wz7d2aN016UkWV7PV1i7O7bQQScX" +
       "Nwy2q7P9BelZThKR2+WKNHJUHQaTiM7VDZUjG1aPJ47AdliO5Aq568sNhaiT" +
       "qRGQAbokN6Q6nWvIfmJqUzIV6WWvpwTz1dikWSc2lO0k3KiWMeyqmalNBjiW" +
       "Yc0mUzeF5brRz+zOmNuQnZU3dhd2MPbHY9addCeyPZAcS2RynvUTWiN9u94R" +
       "OwMEbeEpHC8IDU82cp0lmjopxyTVNJhZOCWmTSoV1hbXQAMmGq7RaONGLYlT" +
       "lkHNyflC6syLwgnWJG4D6AlWi3ZrRGWrhtJf2musQw57Yw7tccF2UTg678ur" +
       "rdNFlvtBD+/u4rzox2inmecT2W/smiOmsBoeYjCkleti1OHUuNNWyFZ/x1gd" +
       "RJvz/fGs3k53jZbgUnUDU9eN+orhJa/GCjzdZzCZWTjc1p+iwW6G71OiNTci" +
       "o4iDXU/3xusuKawVyq2tVxSaCHFzLURzW6eWhb7lyXGzOWy2nU4wxomRkfse" +
       "siZMhhRqkhMPYDrUm/zCgkeB1MW1iaaOgkabTsRuo8HHbXg1ypCRmk0Ir4Er" +
       "0ynF27LprCKy1dEHXubZQ22TwjXPRvllGyZWRKCbWbTyScRQvF7fx1g+wYRl" +
       "LxtQczvcWOZokcawNWIWtYjI4oZd5Fl7JjbckTnLmcZErincvI+Zwg7phB2+" +
       "bsvE1NzqPOK4viLQViCtlgi2XabwpJHB7SwZoR1bIhZrSTG8JWMh9YWsDK1o" +
       "XrTD+jx3qK0S4pgGD7sZkSOeLudeX2S5fUNsAZfHpRrMTjfUrJPO0EYXlm2G" +
       "GTrMcq4Wg3WC7NN6COa40GMcQTWRmGsmbgt6Hd8PUyHra+ZiseMieuBM1a1G" +
       "iYUsTFWEnaAaxnaZUBNRV+CEtDXQiHTgFZ4XU53efNgJxGm02TVbbbO/LCQY" +
       "NlhXG9K7opuhud10cGzS7xTarhVzrVnX6KLBetNpYfUGunAXAS5sB3BvSeY7" +
       "l+emA8Ee7UZdZL/wDEzWa9bCb7j1aInzG6dlt8ehF65TqrcZb2hqbBtj3aYn" +
       "YxRrW+o0s3WyVltbzpxrNFbkVI/3klELuqMBLzZMFWeb9V0zrzfBqhMVre1k" +
       "5JvkNBgGcOgL9UmMDljY8rndzrQAVJntKPUzPwkwvmE0QqOPd9ZGg2ljvIUR" +
       "OJLWduJYV+vZTJaY5iJl6nV0pMp40Wku8PEYjuZWn+6v9OmqhhPhXCTWsFhs" +
       "Fy2Fm07aocvlvEWIwbxju5ncMzyPaPSaZrfGOPVZtBDi9XKE8gbdmZo7rSul" +
       "yGwnEoWt4S2DooSlkuCd1YiNDRDj6JJhL+uTtuGLYw93iI4SUYbKFrMmuxyE" +
       "tf446wTOlB47+6EyW6036+WO2vJzhRAJwYiFNLSGtodbGwzpi0QnTFITRmVO" +
       "qjX6stJi1nuSbSTjcUYlnDRl0LwRD1eylHalqZQGQxrnbAPN0T7u1+ts3SeE" +
       "ISfxMBG59SxiFhzNOHORZGNepRaC2lisxViezd1af1Ef9LaDWo4wiqxaZlev" +
       "iWFtOdpyfENy5dTGzDBGphNqGwaJEy173TG/CAK14JoeGWNks6YZGgLWZl6R" +
       "Ebk77CzX2LgHcDXzii2FbBVpKsJ1Nmt3pr6PBRNRY6nmjrJGY89zRM+dhouW" +
       "xOS1dotaN9W677bXdUzawVsVlQAGTTUEIdC637PwZjIZbRDH85vLYCbOJnMS" +
       "Gw57joB1GWLVhpkEJ9hRNmrD6mJRS5RphCXyfkUNLGtQI7muOp+O6cmsRmTI" +
       "0FtMnYBOULSbF3VnOWhF+1WeihmhYH4m2f6wlWLCStfJWOK8QAjwvjFWXHfL" +
       "JaTXKxi93gtTgS7q+qbZC8khHOHZMl6sh2h/kzoFLdAsksobw4JhYU0ttkm+" +
       "tBKFq8+x4VJMpG19KoDgZK33cns1aIXRMjSWKbWlpjstNKlOm+o0A9OB7dGg" +
       "r1p6v7ljZgNxhgu52JPd3noZy5qPaHGrtheAKyLksnC8oUowo1B2ZH+XtXij" +
       "XcvaprfEW6O1OhpHijzs4+Nagm1RYrEItplO7lbosjW1nIHBa7aEMQhAMC73" +
       "teV+tFg2ZcOtjTYNw5Fj1eFa6WC0zIaDmdJX9n5EJ24nzEeNwIObTBut15B+" +
       "0Salenvtq0QUm6GT0RGbNyyX9oi+HPuBwc9ctjYZGG4TQdNxi+jGC5xNx7ps" +
       "rFWLwYvWLhlifhDP2w2GM0Skayktv72Ca3qj0Y6LvV9nWHzSH1mCP1j1sVph" +
       "dZpWv1cgu7GO7jpEq2t3t0azXlfwEPeZ9XagO7HuCTk3jWDw75MFskwnVjoX" +
       "JVNytsyw5ydwixhpQS9rdD1lNpoG66XZ3o8XyNBY4/U2W0h5uOVyrNFC9BaB" +
       "Jzg2mo93U3Ee2JMRW2dwNcHsPohy517LmvpTuD1ZruNmW18FNNpis0jXl57F" +
       "JV1T5kVKDFSiQFmwtRfh2oxlF14jajGKhfGbIkSGE3rH9xSYsRtUUVA2nQyY" +
       "brvZEboZg1rzRu4GML0twizZG/pWros0yxXjmCGRYrVX87WApGkwLcJcYXB/" +
       "pJgwwkttbqdgmED10iWIrKSIMONmZGOq3BC1/dat4wgh5lzNGhoLDN1L2jJv" +
       "9EPb6JrkrrkNkGTgyLulp+JmZjBK0EosOMbN5nowdt2EnbLTNkZz9f6AiOjV" +
       "xJ6jHExKUb3eYCxFWAwtLN/kYKs2Qgg2ylPW0mqtyJJaorhD2hQB1siOzyMb" +
       "hJbnO6yYjqawi695W9tOpQ1HeUmoh/i8mCjTsJ83hxuHScQ6IxXF2qKbrfFS" +
       "9gV9PLWjzDfjmabY6hZhtqThDWwpkgmciXC0F6qi2wQxdNbSlNTi+6llsAaO" +
       "EXV4yXiO3WSLsNMcW0s0TBaZqy66I0Kur+oojHGFiNW6i5piqYEYi62BbNVE" +
       "bNNqUO2uFivOBN2ZzlDeYwuwbo9gJ8Z8ZDfrqF2YjlZ1sAn+6EfL7fFPf38n" +
       "FE9WBy+nl+J/hiOXQ9ULZfK+07Ou6vcodOki9dxZ17mTbKg8bXj2fnfd1UnD" +
       "lz752uuG+AtoedJQEn4igR5LgvDDrpmZ7rmuHgY9ffD+pyqD6qr/7GT6a5/8" +
       "T89Mf3j18e/jTvA9l/i83OXfGnzlN/vv1//KVeih03Pquz5CuEh05+Lp9I3I" +
       "TNLIn144o372VLPPlhp7H3jsY83al08Rz+bu3keIHzjM/aXLm5M7hvL9i5fq" +
       "Ll0ePXd2XMaW311EaZiYxsU7mtfL5OcS6LqTmNWF3Akx8iYPsNnzdJURfuGi" +
       "ET5+aoSnjD11xpiYAb4cw3yA3d59v1IVvHaq6vJEGfoAeKJjVUc/GFVfOWsw" +
       "rxp89QFz8XfK5MsJ9IQbBJs0PLk1OxH5Q29SnZSfRPszXf7t++qyLP7r/zda" +
       "q+4PSit99Vhrr/7gDfTXHlD3Rpn8wwR6i20mIzVZDY9da34m/T/6fyd9dW3+" +
       "NHg+cyz9Z37w0n/9AXX/vEx+PYEe0d3g+E7gJ88h+KsJ9HAWOMaZLr72A9RF" +
       "nkDvuOetcXlZ/a67vjk7fCel/9LrN68//frsd6tPHE6/ZXpMgK5bqeuev7c7" +
       "l380jEzLqUR+7HCLF1Z/v5dAL37vCxCghfKvEuB3D4T/NoGefSAhWHJO8+cJ" +
       "v5FAb7sHIYC+k+z51v8+gW6ctU6gq/qF6j9IoGvH1Qn0EEjPV/4hKAKVZfZb" +
       "lTE5+ZWL6+jprD71vY7Szy29772wYFYfEJ4sbunhE8KX9a++zg1/4jvNXzh8" +
       "zgH0UBRlL9cF6Nrhy5LTBfKF+/Z20tejzEvffeKXH3vfyWL+xIHhM784x9t7" +
       "7v3tBOWFSfW1Q/EPnv57H/kbr3+juqj5P5Br+7vZKQAA");
}
