package org.apache.batik.svggen.font.table;
public class KerningPair {
    private int left;
    private int right;
    private short value;
    protected KerningPair(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        left =
          raf.
            readUnsignedShort(
              );
        right =
          raf.
            readUnsignedShort(
              );
        value =
          raf.
            readShort(
              );
    }
    public int getLeft() { return left; }
    public int getRight() { return right; }
    public short getValue() { return value; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1YDYxUVxW+u8v+/y/sLn/LwrLQsKUzBYuGLNLCdheWzv6E" +
                                                              "pTRdhOXNmzszj33z3uO9O7sDiLY1htUoQVwo1ZZEQwUJLUSttbGtmEbbptWk" +
                                                              "Ba3VlBo1Ea3EEmM1otZz7n1v3s/sDCFRJ3n3vbn3nHPPOffc75x7z10jpZZJ" +
                                                              "FlGNhdg+g1qhXo0NS6ZFYz2qZFnboG9MfrRE+suuq4Nri0nZKKlLStaALFm0" +
                                                              "T6FqzBolbYpmMUmTqTVIaQw5hk1qUXNCYoqujZJmxepPGaoiK2xAj1Ek2C6Z" +
                                                              "EdIoMWYq0TSj/bYARtoioEmYaxLeEBzujpAaWTf2ueRzPeQ9nhGkTLlzWYw0" +
                                                              "RPZIE1I4zRQ1HFEs1p0xye2Gru5LqDoL0QwL7VHX2C7YElmT44KOC/Uf3DiS" +
                                                              "bOAumC1pms64edZWaunqBI1FSL3b26vSlLWXfIqUREi1h5iRzogzaRgmDcOk" +
                                                              "jrUuFWhfS7V0qkfn5jBHUpkho0KMLPELMSRTStlihrnOIKGC2bZzZrB2cdZa" +
                                                              "YWWOicduD08/uqvhWyWkfpTUK9oIqiODEgwmGQWH0lSUmtaGWIzGRkmjBos9" +
                                                              "Qk1FUpX99ko3WUpCk1galt9xC3amDWryOV1fwTqCbWZaZrqZNS/OA8r+VxpX" +
                                                              "pQTY2uLaKizsw34wsEoBxcy4BHFns8waV7QYI+1BjqyNnfcBAbCWpyhL6tmp" +
                                                              "ZmkSdJAmESKqpCXCIxB6WgJIS3UIQJOR+XmFoq8NSR6XEnQMIzJANyyGgKqS" +
                                                              "OwJZGGkOknFJsErzA6vkWZ9rg+sOH9A2a8WkCHSOUVlF/auBaVGAaSuNU5PC" +
                                                              "PhCMNV2R41LLC1PFhABxc4BY0Dz7yev3rFx08RVBs2AGmqHoHiqzMflUtO6N" +
                                                              "hT0r1pagGhWGbim4+D7L+S4btke6MwYgTEtWIg6GnMGLW3/84ENn6XvFpKqf" +
                                                              "lMm6mk5BHDXKespQVGpuoho1JUZj/aSSarEePt5PyuE7omhU9A7F4xZl/WSW" +
                                                              "yrvKdP4fXBQHEeiiKvhWtLjufBsSS/LvjEEIKYeH1MDTRsSPvxmRwkk9RcOS" +
                                                              "LGmKpoeHTR3tt8KAOFHwbTIchagfD1t62oQQDOtmIixBHCSpMzCRSFAtHNcR" +
                                                              "oaSoSsP3URNEJYYlxQxhqBn/j0kyaOnsyaIiWISFQQhQYfds1tUYNcfk6fTG" +
                                                              "3utPj70mwgu3hO0jRkIwb0jMG+LzhsS8IZw3xOcNeeYlRUV8ujk4v1hvWK1x" +
                                                              "2PcAvDUrRnZu2T3VUQKBZkzOAlcjaYcvAfW44OAg+ph8vql2/5Irq14qJrMi" +
                                                              "pEmSWVpSMZ9sMBOAVPK4vZlropCa3Ayx2JMhMLWZukxjAFD5MoUtpUKfoCb2" +
                                                              "MzLHI8HJX7hTw/mzx4z6k4snJh/e/uk7i0mxPynglKWAZ8g+jFCehezOIBjM" +
                                                              "JLf+0NUPzh8/qLuw4MsyTnLM4UQbOoIBEXTPmNy1WHpm7IWDndztlQDbTIJt" +
                                                              "Boi4KDiHD3W6HQRHWyrA4LhupiQVhxwfV7GkqU+6PTxSG/n3HAiLOtyG8+Dp" +
                                                              "tPclf+Noi4Ftq4hsjLOAFTxDfHzEeOIXP/3DR7i7nWRS76kCRijr9gAYCmvi" +
                                                              "UNXohu02k1Kge+fE8JePXTu0g8csUCydacJObHsAuGAJwc2ffWXv2+9eOXW5" +
                                                              "2I1zRioNU2ewwWksk7UTh0htATthwuWuSoCBKkjAwOm8X4MQVeIKbkDcW/+s" +
                                                              "X7bqmT8dbhChoEKPE0krby7A7Z+3kTz02q6/LeJiimTMwa7bXDIB7LNdyRtM" +
                                                              "U9qHemQefrPtsZelJyBFACxbyn7KkbbI3u6o1FxIGJxT0UNbJS2mpzbIgHBW" +
                                                              "H2A2X9g1nOxO3t6VyzzbYe4f6s3I1ECFON9abJZZ3s3j35+eQmtMPnL5/drt" +
                                                              "7794nZvqr9S8sTIgGd0iPLFZngHxrUFw2yxZSaC76+LgJxrUizdA4ihI5EYN" +
                                                              "mYCwGV9k2dSl5b/84Ustu98oIcV9pErVpVifxDcpqYTdQa0kgHPGuPseERmT" +
                                                              "FdA04FeGZB1DuGNIJqcDV6d95nXvTRmMr9T+77V+Z93pk1d4lBpCxgLOX4L5" +
                                                              "wofKvN53geHspY/97PSXjk+KimFFfjQM8M39x5AafeQ3f89xOcfBGaqZAP9o" +
                                                              "+Nzj83vWv8f5XUBC7s5Mbo4DUHd5V59N/bW4o+xHxaR8lDTIdn29XVLTuM1H" +
                                                              "oaa0nKIbanDfuL8+FMVQdxZwFwbB0DNtEArd3ArfSI3ftQH0w4KENMPTbqNC" +
                                                              "exD9igj/GOAst/G2C5s7HLApN0wFzmA0ADXVBYQyQA0aZ/6EjElvJB21IHkq" +
                                                              "KcDKCbusXD28W57qHP6dCIB5MzAIuuYz4S9uf2vP6xyJKzA9b3OM9iRfSOOe" +
                                                              "NNAgdP4QfkXw/Bsf1BU7RHnW1GPXiIuzRSIGcMFIDBgQPtj07vjjV58SBgTD" +
                                                              "LkBMp6Y//2Ho8LTAVnHSWJpT7Ht5xGlDmIPNA6jdkkKzcI6+358/+P0zBw8J" +
                                                              "rZr8dXMvHAuf+vm/Xg+d+PWrMxRqJYp9WvQiJiRI/9oIg+79XP3zR5pK+iCx" +
                                                              "95OKtKbsTdP+mD88y6101LNY7gnGDVnbNFwYRoq6YA1EWsZ2HTaDIv7uzgti" +
                                                              "m/xB3wLPYjs+F+cJehEqt2EznBvd+bgZKTWVRJInxe0BLZO3qOVceJbY8yzJ" +
                                                              "o6VWUMt83KDlBAIO59hmBw6+HvR87wQqSA5mzmrjXzm4BHoB4zJ58aPMSEdV" +
                                                              "RXbhg//KSOCk5K1U3PRBMNjb8h1meaCfemT6ZGzoyVUY6Mi4C+ojpht3qHSC" +
                                                              "qoFM1ObLRAP8+O7C+jt1R3/7XGdi460cDbBv0U2Kf/zfDpuwKz+kBFV5+ZE/" +
                                                              "zt+2Prn7Fqr89oCXgiK/OXDu1U3L5aPF/K5C5JucOw4/U7d/G1eZlKVNzb9x" +
                                                              "l2bXtd7Zdl32unYFA9qNJx7NB/zRXFWANVDFObUJ/v9CgbHD2ByCHJaAkzxk" +
                                                              "JL5l3YCeutluLVwYYUevwfs/4/dCKzwh25TQrXshH2sBSx8rMPZVbKYZqQAv" +
                                                              "bM0il+uGY/8DNzTiGB67Vtu2rL51N+RjLWDqNwqMncHma8INvBbD/5brhq//" +
                                                              "N9yQYaTac4eBxfPcnBtTccsnP32yvqL15P1vcbzJ3sTVAHLE06rqLe8832WG" +
                                                              "SeMKN6hGFHsiVV5gpOPm9yuA9/zN1T8vOL8NdWchTqjm8OVl+S4jrXlYAPDF" +
                                                              "h5f+OUYagvSgCn976Z5npMqlA1Hiw0vyAyhPgAQ/LxrOMa6Bn0+wpA6JkjpT" +
                                                              "5E8i2UVuvtkie/LOUh9e8+txB1vT4oJ8TD5/csvggesffVLcD8iqtH8/SqmG" +
                                                              "okdcVWTxeUleaY6sss0rbtRdqFzmZLJGobC7URZ4orkXkquB4TU/cHK2OrMH" +
                                                              "6LdPrXvxJ1Nlb0KJt4MUSXDc3ZF7+MgYaUiMOyK5xR3kMn6k717xlX3rV8b/" +
                                                              "/Ct+vCOiGFyYn35Mvnx656Wjc0/B0b+6n5RCkqYZfiq6d5+2lcoT5iipVaze" +
                                                              "DKgIUhRJ9VWOdbgTJLw4536x3Vmb7cXbJQj23KI5904OjsKT1Nyop7UYz1iQ" +
                                                              "S90e3729k+LShhFgcHs8B4soNg9kcDUgHsciA4bhnClKnjU4Fsj5a6pL/BOb" +
                                                              "y/8BHIMEGTobAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NNM/uOt3X/dbz3wtPxX+PyQwzt6cJQAA");
}
