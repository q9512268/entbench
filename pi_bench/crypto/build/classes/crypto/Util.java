package crypto;
public class Util {
    private static final boolean DEBUG = false;
    public static final java.lang.String TEST_DATA_BASE = "./" + java.io.File.
                                                                   separator +
    "resources" +
    java.io.File.
      separator +
    "crypto" +
    java.io.File.
      separator;
    public static final java.lang.String TEST_DATA_1 = TEST_DATA_BASE + "fredmans21.txt";
    public static final java.lang.String TEST_DATA_2 = TEST_DATA_BASE + "track3.mp3";
    public static final java.lang.String TEST_DATA_3 = TEST_DATA_BASE + "random96.dat";
    public static final java.lang.String TEST_DATA_4 = TEST_DATA_BASE + "random1024.dat";
    public static final java.lang.String TEST_DATA_5 = TEST_DATA_BASE + "random4096.dat";
    public static final java.lang.String TEST_DATA_6 = TEST_DATA_BASE + "random65536.dat";
    public static final byte[] getTestData(java.lang.String name) { try {
                                                                        int length =
                                                                          io.Context.
                                                                            fileCache.
                                                                          getLength(
                                                                            name);
                                                                        length -=
                                                                          length %
                                                                            16;
                                                                        byte[] testData =
                                                                          new byte[length];
                                                                        java.io.ByteArrayInputStream bais =
                                                                          io.Context.
                                                                            fileCache.
                                                                          getStream(
                                                                            name);
                                                                        int counter =
                                                                          0;
                                                                        int bytes_read =
                                                                          0;
                                                                        do  {
                                                                            bytes_read =
                                                                              bais.
                                                                                read(
                                                                                  testData,
                                                                                  counter,
                                                                                  16);
                                                                            counter +=
                                                                              bytes_read;
                                                                        }while(counter +
                                                                                 16 <=
                                                                                 length); 
                                                                        return testData;
                                                                    }
                                                                    catch (java.io.IOException ioe) {
                                                                        throw new java.lang.RuntimeException(
                                                                          "Error getting input stream for file " +
                                                                          name,
                                                                          ioe);
                                                                    }
    }
    public static void createRandomTestData(java.lang.String fileName,
                                            int length)
          throws java.io.IOException { java.security.SecureRandom random =
                                         new java.security.SecureRandom(
                                         );
                                       byte[] testData =
                                         new byte[length];
                                       random.
                                         nextBytes(
                                           testData);
                                       java.io.FileOutputStream fos =
                                         new java.io.FileOutputStream(
                                         new java.io.File(
                                           fileName));
                                       fos.
                                         write(
                                           testData);
                                       fos.
                                         close(
                                           );
    }
    public static final int checkSum(byte[] arr) {
        byte sum =
          0;
        byte xor =
          0;
        for (int i =
               0;
             i <
               arr.
                 length;
             i++) {
            sum +=
              arr[i];
            xor |=
              arr[i];
        }
        return (xor <<
                  8) +
          sum;
    }
    public static final boolean check(byte[] ba1,
                                      byte[] ba2) {
        if (ba1 ==
              null ||
              ba2 ==
              null) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "Fail null.");
            return false;
        }
        if (ba1.
              length !=
              ba2.
                length) {
            if (DEBUG)
                java.lang.System.
                  out.
                  println(
                    "Fail length.");
            return false;
        }
        for (int i =
               0;
             i <
               ba1.
                 length;
             i++) {
            if (ba1[i] !=
                  ba2[i]) {
                if (DEBUG)
                    java.lang.System.
                      out.
                      println(
                        "Fail ba1[" +
                        i +
                        "]=" +
                        ba1[i] +
                        " ba2[" +
                        i +
                        "]=" +
                        ba2[i]);
                return false;
            }
        }
        return java.util.Arrays.
          equals(
            ba1,
            ba2);
    }
    public Util() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457062226000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457062226000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
