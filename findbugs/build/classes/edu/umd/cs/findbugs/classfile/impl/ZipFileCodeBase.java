package edu.umd.cs.findbugs.classfile.impl;
public class ZipFileCodeBase extends edu.umd.cs.findbugs.classfile.impl.AbstractScannableCodeBase {
    java.util.zip.ZipFile zipFile;
    public ZipFileCodeBase(edu.umd.cs.findbugs.classfile.ICodeBaseLocator codeBaseLocator,
                           java.io.File file) throws java.io.IOException {
        super(
          codeBaseLocator);
        try {
            this.
              zipFile =
              new java.util.zip.ZipFile(
                file);
            setLastModifiedTime(
              file.
                lastModified(
                  ));
        }
        catch (java.io.IOException e) {
            if (!file.
                  exists(
                    )) {
                java.io.File parent =
                  file.
                  getParentFile(
                    );
                if (!(parent.
                        exists(
                          ) &&
                        parent.
                        isDirectory(
                          ) &&
                        parent.
                        canRead(
                          ))) {
                    throw new java.io.IOException(
                      "Can\'t read directory containing zip file: " +
                      file);
                }
                throw new java.io.IOException(
                  "Zip file doesn\'t exist: " +
                  file);
            }
            if (!file.
                  canRead(
                    )) {
                throw new java.io.IOException(
                  "Can\'t read file zip file: " +
                  file);
            }
            if (!file.
                  isFile(
                    )) {
                throw new java.io.IOException(
                  "Zip file isn\'t a normal file: " +
                  file);
            }
            if (file.
                  length(
                    ) ==
                  0) {
                throw new java.io.IOException(
                  "Zip file is empty: " +
                  file);
            }
            if (!(e instanceof java.util.zip.ZipException)) {
                java.io.IOException ioException =
                  new java.io.IOException(
                  "Error opening zip file " +
                  file +
                  " of " +
                  file.
                    length(
                      ) +
                  " bytes");
                ioException.
                  initCause(
                    e);
                throw ioException;
            }
            int magicBytes;
            try {
                java.io.DataInputStream in =
                  new java.io.DataInputStream(
                  new java.io.FileInputStream(
                    file));
                magicBytes =
                  in.
                    readInt(
                      );
            }
            catch (java.io.IOException e3) {
                throw new java.io.IOException(
                  java.lang.String.
                    format(
                      "Unable read first 4 bytes of zip file %s of %d bytes",
                      file,
                      file.
                        length(
                          )));
            }
            if (magicBytes !=
                  1347093252) {
                throw new java.io.IOException(
                  java.lang.String.
                    format(
                      "Wrong magic bytes of %x for zip file %s of %d bytes",
                      magicBytes,
                      file,
                      file.
                        length(
                          )));
            }
            java.util.zip.ZipException e2 =
              new java.util.zip.ZipException(
              "Error opening zip file " +
              file +
              " of " +
              file.
                length(
                  ) +
              " bytes");
            e2.
              initCause(
                e);
            throw e2;
        }
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseEntry lookupResource(java.lang.String resourceName) {
        resourceName =
          translateResourceName(
            resourceName);
        try {
            java.util.zip.ZipEntry entry =
              zipFile.
              getEntry(
                resourceName);
            if (entry ==
                  null) {
                return null;
            }
            return new edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBaseEntry(
              this,
              entry);
        }
        catch (java.lang.IllegalStateException ise) {
            return null;
        }
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseIterator iterator() {
        final java.util.Enumeration<? extends java.util.zip.ZipEntry> zipEntryEnumerator =
          zipFile.
          entries(
            );
        return new edu.umd.cs.findbugs.classfile.ICodeBaseIterator(
          ) {
            edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBaseEntry
              nextEntry;
            @java.lang.Override
            public boolean hasNext() {
                scanForNextEntry(
                  );
                return nextEntry !=
                  null;
            }
            @java.lang.Override
            public edu.umd.cs.findbugs.classfile.ICodeBaseEntry next()
                  throws java.lang.InterruptedException {
                scanForNextEntry(
                  );
                if (nextEntry ==
                      null) {
                    throw new java.util.NoSuchElementException(
                      );
                }
                edu.umd.cs.findbugs.classfile.ICodeBaseEntry result =
                  nextEntry;
                nextEntry =
                  null;
                return result;
            }
            private void scanForNextEntry() {
                while (nextEntry ==
                         null) {
                    if (!zipEntryEnumerator.
                          hasMoreElements(
                            )) {
                        return;
                    }
                    java.util.zip.ZipEntry zipEntry =
                      zipEntryEnumerator.
                      nextElement(
                        );
                    if (!zipEntry.
                          isDirectory(
                            )) {
                        addLastModifiedTime(
                          zipEntry.
                            getTime(
                              ));
                        nextEntry =
                          new edu.umd.cs.findbugs.classfile.impl.ZipFileCodeBaseEntry(
                            ZipFileCodeBase.this,
                            zipEntry);
                        break;
                    }
                }
            }
        };
    }
    @java.lang.Override
    public java.lang.String getPathName() {
        return zipFile.
          getName(
            );
    }
    @java.lang.Override
    public void close() { try { zipFile.close(
                                          );
                          }
                          catch (java.io.IOException e) {
                              
                          } }
    @java.lang.Override
    public java.lang.String toString() { return zipFile.
                                           getName(
                                             );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ubR3+Cs27/4X65E4kwAdAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tJOkzQ6Ztk1YCxk3xsJiXFTExSzgJmOYI5SaK/dUAcMDrj1BkYVexzsihoVu" +
       "txgjUEJieFcuS24iBGjZEcPA5XlKn8GBHldraneljIu8oTiLMeM7s4Ghtmm2" +
       "ORWQGcEERH8595U1Q5Mtt1NDWaFuUEsGa4dsw6hAXRKPsAXCBgEcNyFR7AaT" +
       "qt2vBVO0gZKN4tgSl/Xakq+MGhbImPiaQNa1ZNUvBizrx3Z15Hfw5lw1XERL" +
       "KEE3VFMYGVgUNnt4jRoIcA+xkIApEWXHc9kO4zeVPtJdFzljRFtUyxl4uEwi" +
       "/BJvIoUlQVJTTvckHu11xl1ciBvEDIGmSAntjDgIbWGRvyAw1Jqgg9W4S85M" +
       "CKzKNS4saTV1PZlZbBuPqsx4LJQSmLSoac9qSUyHHLsx1uvw5Jin1gmh2oJm" +
       "ocjMnhuzwJoXYJz3xKo0HIIqQ7Mk1HS9QtybLn1vXhl2eknNS6iSFw5k1DYt" +
       "y8XCoSlYK8Lp1tFeeUGIGBH53BqjaDdB5TjQCsQgNECmQeC2j4m8jruBC+Nk" +
       "bTwueYaRlBSOmYc+6viOMh43J8JaVuoMasHxmunwHtRYCjTKj2DXtM3JUnbB" +
       "WcVkMKRPcoi9Mtw+Y08UctocwkORoEe+N8O4SRSgAy+qw4IhYgvRdbso1xn1" +
       "2zzZCmfLmtVoI5M2MyVDWkSWMs63qW6p0+rUhrLCL5hF33OFzqi4ardV39OZ" +
       "JTKaddEyE3TrleLIngXoNCKxPlxeluUBRolsDA/nPMpWZ+P5aCo4/BLEGdHr" +
       "xeOhVV7WPLdArPhCrYvxA2nRb9enagVL0CK9mM4SBWYUqtJP6KifGKUmxiZG" +
       "q1RuVREqmeFdBJ31OlytgDa6dSkQ15VmtTHs6nAPZsilnNpVyjEajVuV0LYs" +
       "xzbjoihPqkTTooyRgAr4dDat1N0iJqMrmaYpuOm1PaQ5KPt+ozsm2Z5aw51+" +
       "k/LLkyEfuVXVmZakrmbQRqE5rlJRQSerPuyMazXNbvlrbQVaXiOi+2HPp7EO" +
       "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");
}
