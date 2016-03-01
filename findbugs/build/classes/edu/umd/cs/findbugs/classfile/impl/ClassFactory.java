package edu.umd.cs.findbugs.classfile.impl;
public class ClassFactory implements edu.umd.cs.findbugs.classfile.IClassFactory {
    private static edu.umd.cs.findbugs.classfile.IClassFactory theInstance =
      new edu.umd.cs.findbugs.classfile.impl.ClassFactory(
      );
    private ClassFactory() { super(); }
    public static edu.umd.cs.findbugs.classfile.IClassFactory instance() {
        return theInstance;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.IClassPath createClassPath() { return new edu.umd.cs.findbugs.classfile.impl.ClassPathImpl(
                                                                          );
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.IClassPathBuilder createClassPathBuilder(edu.umd.cs.findbugs.classfile.IErrorLogger errorLogger) {
        return new edu.umd.cs.findbugs.classfile.impl.ClassPathBuilder(
          this,
          errorLogger);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseLocator createFilesystemCodeBaseLocator(java.lang.String pathName) {
        try {
            pathName =
              new java.io.File(
                pathName).
                getCanonicalPath(
                  );
        }
        catch (java.io.IOException e) {
            
        }
        return new edu.umd.cs.findbugs.classfile.impl.FilesystemCodeBaseLocator(
          pathName);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseLocator createNestedArchiveCodeBaseLocator(edu.umd.cs.findbugs.classfile.ICodeBase parentCodeBase,
                                                                                             java.lang.String path) {
        return new edu.umd.cs.findbugs.classfile.impl.NestedZipFileCodeBaseLocator(
          parentCodeBase,
          path);
    }
    static edu.umd.cs.findbugs.classfile.IScannableCodeBase createFilesystemCodeBase(edu.umd.cs.findbugs.classfile.impl.FilesystemCodeBaseLocator codeBaseLocator)
          throws java.io.IOException { java.lang.String fileName =
                                         codeBaseLocator.
                                         getPathName(
                                           );
                                       java.io.File file =
                                         new java.io.File(
                                         fileName);
                                       if (!file.
                                             exists(
                                               )) {
                                           throw new java.io.FileNotFoundException(
                                             "File " +
                                             file.
                                               getAbsolutePath(
                                                 ) +
                                             " doesn\'t exist");
                                       }
                                       else
                                           if (!file.
                                                 canRead(
                                                   )) {
                                               throw new java.io.IOException(
                                                 "File " +
                                                 file.
                                                   getAbsolutePath(
                                                     ) +
                                                 " not readable");
                                           }
                                           else
                                               if (file.
                                                     isDirectory(
                                                       )) {
                                                   return new edu.umd.cs.findbugs.classfile.impl.DirectoryCodeBase(
                                                     codeBaseLocator,
                                                     file);
                                               }
                                               else
                                                   if (!file.
                                                         isFile(
                                                           )) {
                                                       throw new java.io.IOException(
                                                         "File " +
                                                         file.
                                                           getAbsolutePath(
                                                             ) +
                                                         " is not a normal file");
                                                   }
                                                   else
                                                       if (fileName.
                                                             endsWith(
                                                               ".class")) {
                                                           return new edu.umd.cs.findbugs.classfile.impl.SingleFileCodeBase(
                                                             codeBaseLocator,
                                                             fileName);
                                                       }
                                                       else {
                                                           return edu.umd.cs.findbugs.classfile.impl.ZipCodeBaseFactory.
                                                             makeZipCodeBase(
                                                               codeBaseLocator,
                                                               file);
                                                       }
    }
    static edu.umd.cs.findbugs.classfile.IScannableCodeBase createNestedZipFileCodeBase(edu.umd.cs.findbugs.classfile.impl.NestedZipFileCodeBaseLocator codeBaseLocator)
          throws edu.umd.cs.findbugs.classfile.ResourceNotFoundException,
        java.io.IOException { return new edu.umd.cs.findbugs.classfile.impl.NestedZipFileCodeBase(
                                codeBaseLocator);
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.IAnalysisCache createAnalysisCache(edu.umd.cs.findbugs.classfile.IClassPath classPath,
                                                                            edu.umd.cs.findbugs.BugReporter errorLogger) {
        edu.umd.cs.findbugs.classfile.IAnalysisCache analysisCache =
          new edu.umd.cs.findbugs.classfile.impl.AnalysisCache(
          classPath,
          errorLogger);
        return analysisCache;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "tfFXHDr+C7uKHmOPIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "4OYA8Tl3UiUjpVZncaS97uyYiok3qVpX0jiOXIYRJo+aMed481XfJOwdO+kk" +
       "mabFFhiLlLay670AIze1BTzbtjWxzw9QtiaQjjyCGQMZKwxqELzfwu14gXUb" +
       "SbwMRYZozdg+verganemW0Nx5Y7coLnq64nZk4zFuqtoLTCXMTpYAw76mtIY" +
       "czWErC9NXVQWyZLryqtgXs+6qr2dNPGN43q1USAwIArNxVoyomY0mA0x3dKo" +
       "KZus+8OpMFvalOUpfK/GxGuz0WQ0dLGkadUfkWCWawYbh6eTyF0Yos9NkF4D" +
       "76BZoye2tgtMJesjCndXG8rU4ZyUV7EyqikaUZ2rqMZ5dVKoDBw9k1JLXk/Y" +
       "vl+h826TEOPM1mGlrbOKyjPoarZF40TKZqExHlXXxBBbOKIfrwlFasRVzB7r" +
       "HspQWRh5leWYa6TeoNVs2FtqAW9aYz0bNhb8SsTjljRKFjqG0y7BpVMuIp1h" +
       "vquICr0diaJjSOMk45E6Z4a7Uae5AKszuCvOHJ7MNnV5MBvyGGLbjb5GcakW" +
       "e7AgSjm25hNtNRSYIHRoYhWZsD1J6UqV3+CzScuPwNqkjsCW7KTMkqkNukE+" +
       "M22pJm4sqeJPGmlr00sam0q02237eLtqeRzO+UOw0tupW2dFNXa9rUj22daS" +
       "5TJqp4rTjSZOFh2479YyptIbAM+erentOhJymFg6hCxnoxaMYd1m1gYzeaIx" +
       "Mj8fqkLm+XnW6aWmtqyTFZNcp0qOgkiTxEzS6iCpt2Idoz/vi7ue4w1VbWdw" +
       "NUpE8GknaGWVqMalCtmj2ImbVzIEnggjlBZ9rRfmVqPqY60altG+GZkMZRjB" +
       "HKmj6JiJWlZPbuaKGc67Y1SMleE6awi1dpOsLRf0kIrS9crZ5KmeBIRMbYnA" +
       "b8ASbc7onezgVc6Z7aweu6vasJQuohnqMPFqLFV7SE93Egyd1tpaO6WRXLbX" +
       "YFWrLwcrTFRNpMJp7TkWNIRZqMyR5QJIs+WqcD/aEtVGh5gaQrsFw23RIFoJ" +
       "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" +
       "4v9/d6jK8jItAAA=");
}
