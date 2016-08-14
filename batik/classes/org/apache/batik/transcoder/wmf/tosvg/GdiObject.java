package org.apache.batik.transcoder.wmf.tosvg;
public class GdiObject {
    GdiObject(int _id, boolean _used) { super();
                                        id = _id;
                                        used = _used;
                                        type = 0; }
    public void clear() { used = false;
                          type = 0; }
    public void Setup(int _type, java.lang.Object _obj) { obj = _obj;
                                                          type = _type;
                                                          used = true; }
    public boolean isUsed() { return used; }
    public int getType() { return type; }
    public java.lang.Object getObject() { return obj; }
    public int getID() { return id; }
    int id;
    boolean used;
    java.lang.Object obj;
    int type = 0;
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0Za2wUx3l8fuIHfgDmbcAYIh65LQmUpKYk2GAwPRvLBqs1" +
                                                              "Dcfe3py9sLe77M7aZ6duE6QIEimIUkJIlKD+ICWlEKI2UdNHIkdRSqI8pBDa" +
                                                              "NE0DUdqqtAQ1qGpalbb0+2b3bh/nO+qq9KSd25v5vm++9/fN3KkrpNg0SANV" +
                                                              "WZgN69QMb1BZl2iYNN6qiKa5Feai0qOF4p93XOq8M0RK+sjkAdHskESTtslU" +
                                                              "iZt9ZK6smkxUJWp2UhpHjC6DmtQYFJmsqX1kmmy2J3VFlmTWocUpAvSKRoTU" +
                                                              "iowZcsxitN0hwMjcCHAicE6EdcHl5giplDR92AWf4QFv9awgZNLdy2SkJrJL" +
                                                              "HBQFi8mKEJFN1pwyyDJdU4b7FY2FaYqFdymrHBVsjqzKUkHjs9WfXTs4UMNV" +
                                                              "MEVUVY1x8cxuamrKII1HSLU7u0GhSXMP+TopjJAKDzAjTZH0pgJsKsCmaWld" +
                                                              "KOC+iqpWslXj4rA0pRJdQoYYWeAnoouGmHTIdHGegUIZc2TnyCDt/Iy0tpRZ" +
                                                              "Ij6yTDj86I6a7xeS6j5SLas9yI4ETDDYpA8USpMxapjr4nEa7yO1Khi7hxqy" +
                                                              "qMgjjqXrTLlfFZkF5k+rBSctnRp8T1dXYEeQzbAkphkZ8RLcoZxfxQlF7AdZ" +
                                                              "611ZbQnbcB4ELJeBMSMhgt85KEW7ZTXOyLwgRkbGpi8BAKCWJikb0DJbFaki" +
                                                              "TJA620UUUe0XesD11H4ALdbAAQ1GZuUkirrWRWm32E+j6JEBuC57CaAmcUUg" +
                                                              "CiPTgmCcElhpVsBKHvtc6Vxz4F51kxoiBcBznEoK8l8BSA0BpG6aoAaFOLAR" +
                                                              "K5dGjoj1L+4PEQLA0wLANswPv3b17uUNY6/ZMLPHgdkS20UlFpWOxya/M6d1" +
                                                              "yZ2FyEaZrpkyGt8nOY+yLmelOaVDhqnPUMTFcHpxrPtnX7nvJL0cIuXtpETS" +
                                                              "FCsJflQraUldVqixkarUEBmNt5NJVI238vV2UgrvEVml9uyWRMKkrJ0UKXyq" +
                                                              "ROO/QUUJIIEqKod3WU1o6XddZAP8PaUTQkrhIZXwzCb2h38zEhMGtCQVRElU" +
                                                              "ZVUTugwN5TcFyDgx0O2AEAOv3y2YmmWACwqa0S+I4AcD1FlghqiaEiQhQxhK" +
                                                              "JgSmmYP9wsa4bOsxjL6m/192SaGsU4YKCsAMc4JJQIH42aQpgB+VDlstG64+" +
                                                              "E33DdjAMCkdLjODGYXvjMN847G4cho3DfONwZmNSUMD3m4oM2CYHg+2G0Ifc" +
                                                              "W7mk557NO/c3FoKv6UNFoG0EbfTVoFY3P6STelQ6U1c1suDCildCpChC6kSJ" +
                                                              "WaKCJWWd0Q/JStrtxHNlDKqTWyTme4oEVjdDk2gcclSuYuFQKdMGqYHzjEz1" +
                                                              "UEiXMAxWIXcBGZd/MnZ06P7eb3wuREL+uoBbFkNKQ/QuzOaZrN0UzAfj0a3e" +
                                                              "d+mzM0dGNTcz+ApNuj5mYaIMjUGPCKonKi2dLz4ffXG0iat9EmRuJkKkQVJs" +
                                                              "CO7hSzzN6SSOspSBwAnNSIoKLqV1XM4GDG3IneGuWsvfp4JboGuQKnjmOKHJ" +
                                                              "v3G1Xsdxuu3a6GcBKXiR+GKP/uQv3/7D7Vzd6XpS7WkEeihr9uQwJFbHs1Wt" +
                                                              "67ZbDUoB7sOjXd965Mq+7dxnAWLheBs24dgKuQtMCGp+4LU971+8cPx8KOPn" +
                                                              "JOWXrSiPbLDJYpcNSH0KxBU6S9M2FdxSTshiTKEYT/+oXrTi+U8O1NjmV2Am" +
                                                              "7T3Lb0zAnZ/ZQu57Y8dfGziZAglLr6sqF8zO51NcyusMQxxGPlL3n5v72Fnx" +
                                                              "SagMkI1NeYTyBBvioof8IY5h1GPFTAhHOQnaH3Rq1W1dO6X9TV2/tevQzHEQ" +
                                                              "bLhpTwsP9763601u2zIMeJxHuas84QyJweNYNbbyr8OnAJ5/4YNKxwk759e1" +
                                                              "OoVnfqby6HoKOF+Sp1X0CyCM1l3c/cSl07YAwcocAKb7Dz90PXzgsG05u31Z" +
                                                              "mNVBeHHsFsYWB4c7kLsF+XbhGG2/PzP6k6dH99lc1fmL8QboNU//4p9vho9+" +
                                                              "9Po4ub9QdlrQ2zFTZ/L1VL9tbIHWP1j904N1hW2QKtpJmaXKeyzaHvdShO7L" +
                                                              "tGIeY7ltEZ/wioaGgVKyFG2AM6scifHrC573tYyUxjRNoaIaZBR/rk9xoiv5" +
                                                              "mpCBIE5I4u8IDotMb771G9rTnkelg+c/rer99KWrXFn+/t6bXjpE3bZULQ6L" +
                                                              "0VLTg/Vwk2gOANzKsc6v1ihj14BiH1CUoNabWwworilfMnKgi0t/9fIr9Tvf" +
                                                              "KSShNlKuaGK8TeR5nUyChErNASjoKf2uu+3EMlQGQw0XlWQJnzWBwT1v/LSx" +
                                                              "IakzHugjL0x/bs2JYxd4YnNsM5vjF2GP4Svk/JTo1pKT767++YlvHhmyHTFP" +
                                                              "WAXwZvx9ixLb+/HfslTOS+c4kRbA7xNOPTGrde1lju/WMMRuSmX3RdAHuLi3" +
                                                              "nUz+JdRY8mqIlPaRGsk5lfWKioWVoQ9OImb6qAYnN9+6/1Rh90bNmRo9Jxjq" +
                                                              "nm2D1dMbQUXMFy2BglkBT7dTVLqDBbOA8JcdHOUWHJZll6Rc2IyE5Di+rbbr" +
                                                              "Lo4dOERtH+jK6XJf9m9SC0+Ps0lPDhZpXhZzYTNSZMGxFt/bAkwmJshkNTxb" +
                                                              "nW225mBSyctkLmzIqVpsF4efwUgNjzZ0kLDtIAG+k/+Fcrc5O2/LwbeVl+9c" +
                                                              "2Mz1vKAHDOZh0l66hY9LcbjVzs2MlOhWTJEltyvinxISOIx5uyI31xBMqHNz" +
                                                              "nZd52Tu+9/Cx+JanVoScNH8Xgwyp6bcqdJAqHlIlSMmXtjr4DYGbAz6cfOg3" +
                                                              "P2rqb5nI0QPnGm5wuMDf8yABLc2dCYOsnN37x1lb1w7snMApYl5AS0GS3+04" +
                                                              "9frGxdKhEL8OsZNT1jWKH6nZn5LKDcosQ/WX8YUZu2JOItPhaXTs2hh0TNef" +
                                                              "uFeO+r2yPA9qnrJ+IM/aQRweZKRYgr7BGK+nKBrU5Ljr4g/dKA7z11Wc6NX5" +
                                                              "/AN+vQjwrHSEWzlxveRCDcjutOGZ4N3DSR/Lo6Fv4/AYaAiqnMVpHnK18fhN" +
                                                              "0MYUXJsJzxpHpDUT10Yu1Dxyfi/P2mkcvgOZSja3peuKq4QTN0EJWHZIPTwt" +
                                                              "jiQtE1dCLtQ8gr6QZ+3HOPwAmux+ytIRvtrVwnM3QQt1uIbJf5MjyqaJayEX" +
                                                              "ah5JX82zdhaHMaggoAW3UO9x9fDyzfIGfOl0hOmcuB5yoeaR9VyetfM4vAVp" +
                                                              "AfTQvj7gC2//L3SQAiVnrhLxQDIj678L+75deuZYddn0Y9ve42U5cydeCQU2" +
                                                              "YSmKt2X2vJfoBk3IXJZKu4HW+devGVn0H91zguz8m/P/gY18ESrmDZCh7YPR" +
                                                              "i/QxI7PzIDGo5ZkfXrzfQdcYxAOm+LcX7hJQcOEgi9kvXpDL2Iwa/fj6iZ6z" +
                                                              "JU0V+BuvjL2n3cjenl5toa/H4f9apfsRy/7fKiqdOba5896rn3/KvrOTFHFk" +
                                                              "BKlUREipfX2Y6WkW5KSWplWyacm1yc9OWpTu/mptht2Ame3x6l5oSHX0tVmB" +
                                                              "my2zKXPB9f7xNS+9tb/kHBwit5MCkZEp27NPdyndgmZyeyT7egT6P37l1rzk" +
                                                              "8eG1yxN/+oCfn4l9nTInN3xUOn/inncPzTjeECIV7aQYGlua4sfO9cNqN5UG" +
                                                              "jT5SJZsbUsAiUJFFxXf3MhnDQsT/s7heHHVWZWbxxpeRxuxrp+x78nJFG6JG" +
                                                              "i2apvBJWQf/pzqR7W19baOl6AMGdcUyJYysOd6TQGuCP0UiHrqdv5So+0nla" +
                                                              "WD/+1Q6O1/krDAXk37TIotbRHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+wsV12f+7vtvW0pvbcFWijQQrlgysJvdmZ3Z3dTQGZf" +
       "89yZnZ2ZfYxKmefO7M5r57E7u1gFEgUlQSIF0UD/UAhCePkgGglaYuQR0AQk" +
       "IiYCUaMgEOEPkYiKZ2Z/7957S23jJnP2zDnne873dT7f85gPfRe6MY6gUhi4" +
       "m5kbJPtmluzP3dp+sgnNeJ9mawM1ik2j7apxLIGyB/X7PnbpBz96m315D7qg" +
       "QM9QfT9I1MQJ/HhoxoG7Mg0WunRc2nVNL06gy+xcXalwmjguzDpx8gALPe0E" +
       "aQJdYQ9ZgAELMGABLliA8eNWgOjppp967ZxC9ZN4Cf0CdI6FLoR6zl4CvfB0" +
       "J6Eaqd5BN4NCAtDDTfn7CAhVEGcR9IIj2XcyP0bgd5Tgh3/jNZd//zx0SYEu" +
       "Ob6Ys6MDJhIwiALd6pmeZkYxbhimoUC3+6ZpiGbkqK6zLfhWoDtiZ+arSRqZ" +
       "R0rKC9PQjIoxjzV3q57LFqV6EkRH4lmO6RqHbzdarjoDst55LOtOwl5eDgS8" +
       "xQGMRZaqm4ckNywc30ige89SHMl4hQENAOlFz0zs4GioG3wVFEB37Gznqv4M" +
       "FpPI8Weg6Y1BCkZJoLuv2Wmu61DVF+rMfDCBnn223WBXBVrdXCgiJ0mgZ51t" +
       "VvQErHT3GSudsM93uVe89XU+6e8VPBum7ub83wSI7jlDNDQtMzJ93dwR3vpS" +
       "9p3qnZ988x4EgcbPOtN41+aPfv77r37ZPY9+dtfmuVdpw2tzU08e1N+r3fbF" +
       "57Xvb57P2bgpDGInN/4pyQv3HxzUPJCFYObdedRjXrl/WPno8NPT13/Q/PYe" +
       "dAsFXdADN/WAH92uB17ouGZEmL4ZqYlpUNDNpm+0i3oKugjyrOObu1LesmIz" +
       "oaAb3KLoQlC8AxVZoItcRRdB3vGt4DAfqold5LMQgqCL4IFuBc9zod2v+E8g" +
       "DbYDz4RVXfUdP4AHUZDLH8Omn2hAtzasAa9fwHGQRsAF4SCawSrwA9s8qEgi" +
       "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" +
       "fNcfvuL9j3ytuDj5X+GyBCMNKQAA");
}
