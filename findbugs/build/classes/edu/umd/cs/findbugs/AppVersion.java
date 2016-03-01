package edu.umd.cs.findbugs;
public class AppVersion implements edu.umd.cs.findbugs.xml.XMLWriteable, java.lang.Cloneable {
    public static final java.lang.String ELEMENT_NAME = "AppVersion";
    private final long sequence;
    private long timestamp;
    private java.lang.String releaseName;
    private int numClasses;
    private int codeSize;
    public AppVersion(long sequence, long time, java.lang.String name) { super(
                                                                           );
                                                                         this.
                                                                           sequence =
                                                                           sequence;
                                                                         this.
                                                                           timestamp =
                                                                           time;
                                                                         this.
                                                                           releaseName =
                                                                           name;
    }
    public AppVersion(long sequence, java.util.Date time,
                      java.lang.String name) { super(
                                                 );
                                               this.
                                                 sequence =
                                                 sequence;
                                               this.
                                                 timestamp =
                                                 time.
                                                   getTime(
                                                     );
                                               this.
                                                 releaseName =
                                                 name;
    }
    public AppVersion(long sequence) { super();
                                       this.sequence =
                                         sequence;
                                       this.timestamp =
                                         java.lang.System.
                                           currentTimeMillis(
                                             );
                                       this.releaseName =
                                         ""; }
    @java.lang.Override
    public java.lang.Object clone() { try { return super.
                                              clone(
                                                );
                                      }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    public long getSequenceNumber() { return sequence;
    }
    public long getTimestamp() { if (timestamp <=
                                       0) {
                                     return java.lang.System.
                                       currentTimeMillis(
                                         );
                                 }
                                 return timestamp;
    }
    public java.lang.String getReleaseName() {
        return releaseName;
    }
    public edu.umd.cs.findbugs.AppVersion setTimestamp(long timestamp) {
        this.
          timestamp =
          timestamp;
        return this;
    }
    public edu.umd.cs.findbugs.AppVersion setReleaseName(java.lang.String releaseName) {
        this.
          releaseName =
          releaseName;
        return this;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { xmlOutput.
                                         openCloseTag(
                                           ELEMENT_NAME,
                                           new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                             ).
                                             addAttribute(
                                               "sequence",
                                               java.lang.String.
                                                 valueOf(
                                                   sequence)).
                                             addAttribute(
                                               "timestamp",
                                               java.lang.String.
                                                 valueOf(
                                                   timestamp)).
                                             addAttribute(
                                               "release",
                                               releaseName).
                                             addAttribute(
                                               "codeSize",
                                               java.lang.String.
                                                 valueOf(
                                                   codeSize)).
                                             addAttribute(
                                               "numClasses",
                                               java.lang.String.
                                                 valueOf(
                                                   numClasses)));
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.StringBuilder buf =
                                           new java.lang.StringBuilder(
                                           );
                                         buf.
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 sequence));
                                         buf.
                                           append(
                                             ',');
                                         buf.
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 timestamp));
                                         buf.
                                           append(
                                             ',');
                                         buf.
                                           append(
                                             releaseName);
                                         buf.
                                           append(
                                             ',');
                                         buf.
                                           append(
                                             codeSize);
                                         buf.
                                           append(
                                             ',');
                                         buf.
                                           append(
                                             codeSize);
                                         return buf.
                                           toString(
                                             );
    }
    public edu.umd.cs.findbugs.AppVersion setNumClasses(int numClasses) {
        this.
          numClasses =
          numClasses;
        return this;
    }
    public int getNumClasses() { return numClasses;
    }
    public edu.umd.cs.findbugs.AppVersion setCodeSize(int codeSize) {
        this.
          codeSize =
          codeSize;
        return this;
    }
    public int getCodeSize() { return codeSize;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1mIhkl8rRg7yV3y74X95ENeKtykAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7efDj1n0fd3XsaiVrJTmWFdnW5bVjicoPIAkQZGQ7JnHx" +
       "AAiAB0igqdc4SRD3RYKI1SZuGyvJ1PW0cmpPE/3lTNvEiTNN08uTjFpPc9SZ" +
       "dtzJJD0mcSbtTJKmbuPJJO3Ebd0H8Hfv7k9SJHPmPYLv/H6+53t4j1/4euWe" +
       "OKpUA9/ZLR0/OTCy5GDtoAfJLjDigwGD8koUGzruKHE8BWU3tWd+7vqfffPT" +
       "q4cuV+6VK29XPM9PlMTyvXhsxL6zMXSmcv2klHQMN04qDzFrZaNAaWI5EGPF" +
       "yQtM5f5TXZPKDeaIBAiQAAESoJIEqHPSCnR6m+GlLl70ULwkDit/pXKJqdwb" +
       "aAV5SeXps4MESqS4h8PwJQIwwtXitwhAlZ2zqPLUMfY95lsAf6YKvfx3P/rQ" +
       "P7qrcl2uXLe8SUGOBohIwCRy5QHXcFUjiju6buhy5WHPMPSJEVmKY+Ul3XLl" +
       "kdhaekqSRsYxk4rCNDCics4Tzj2gFdiiVEv86BieaRmOfvTrHtNRlgDroydY" +
       "9wipohwAvGYBwiJT0YyjLnfblqcnlSfP9zjGeGMIGoCuV1wjWfnHU93tKaCg" +
       "8shedo7iLaFJElneEjS9x0/BLEnl8TsOWvA6UDRbWRo3k8pj59vx+yrQ6r6S" +
       "EUWXpPKO883KkYCUHj8npVPy+frog5/6fq/nXS5p1g3NKei/Cjo9ca7T2DCN" +
       "yPA0Y9/xgeeYH1Me/cWXLlcqoPE7zjXet/mnH//GR55/4tVf3bd5123acOra" +
       "0JKb2ufVB7/6bvzZ9l0FGVcDP7YK4Z9BXqo/f1jzQhYAy3v0eMSi8uCo8tXx" +
       "L0s/8FPGH12uXOtX7tV8J3WBHj2s+W5gOUZEG54RKYmh9yv3GZ6Ol/X9yhXw" +
       "zFiesS/lTDM2kn7lbqcsutcvfwMWmWCIgkVXwLPlmf7Rc6Akq/I5CyqVyhWQ" +
       "Kt8D0vsr+0/5nVRm0Mp3DUjRFM/yfIiP/AJ/DBleogLeriATKJOaLmMojjSo" +
       "VB1DT6HU1SEtPqnsBIEIrAZgPSjaBN+ugbMC0UPbS5cAs9993tQdYCU939GN" +
       "6Kb2ctolv/GzN79y+Vj1D3mRVJ4A8xyAeQ60+OBonoOTeSqXLpXDf0cx316O" +
       "QAo2sGfg6R54dvKXBx976Zm7gAIF27sBC+8CTaE7O1z8xAP0Sz+nATWsvPrZ" +
       "7Q+KfxW+XLl81nMWNIKia0V3vvB3x37txnmLud241z/5B3/2xR970T+xnTOu" +
       "+NCkb+1ZmOQz57kZ+RpgVGScDP/cU8ov3PzFF29crtwN7Bz4tkQBugjcxhPn" +
       "5zhjmi8cubkCyz0AsOlHruIUVUe+6VqyivztSUkp5gfL54cBj+8vdPUdIDUP" +
       "lbf8LmrfHhT5d+zVohDaORSlG/3QJPiJ//Bv/7BRsvvI414/FcMmRvLCKSsv" +
       "Brte2vPDJzowjQwDtPvtz/J/5zNf/+RfKhUAtHjv7Sa8UeQ4sG4gQsDmv/Gr" +
       "4X/82u98/jcuHyvNpQSEuVR1LC07BlmUV65dABLM9v4TeoCXcIBBFVpzY+a5" +
       "vm6ZlqI6RqGl/+f6+2q/8N8/9dBeDxxQcqRGz7/2ACfl39mt/MBXPvq/niiH" +
       "uaQVUeqEZyfN9q7v7Scjd6JI2RV0ZD/479/zuV9RfgI4UeC4Yis3Sl9017Hh" +
       "PHvBSiWyXCCNzaF3h1585Gv2j//Bz+w99/lQcK6x8dLLP/Ktg0+9fPlUvHzv" +
       "LSHrdJ99zCzV6G17iXwLfC6B9P+KVEiiKNj7zEfwQ8f91LHnDoIMwHn6IrLK" +
       "Kajf/+KLX/oHL35yD+ORs+GCBKuhn/nN//vrB5/93V+7jd+62/G9ZfGrUVL4" +
       "DrAOK3lehPKDfSgvAUBl9XNlflBQXLK7UtZ9qMiejE/7k7OcP7VAu6l9+jf+" +
       "+G3iH//SN0pizq7wTpsPqwR71j1YZE8VnHjneefZU+IVaIe8Ovq+h5xXvwlG" +
       "lMGIGljWxFwEPHZ2xtgOW99z5T/9yy8/+rGv3lW5TFWuOb6iU0rptyr3AYdh" +
       "xCvg7LPgez+yt5ftVZA9VEKt3AK+LHj8Vo/ywUNj++DtPUqRP11k77vVTu/U" +
       "9Rz7D7X9jOAePIFKAPUpSr+nnHFwgexGRUaWVR8uMmoPqvOm8HcPQXTfOP47" +
       "dT0H4dLe45X4y1HnF2CUimx8gnHyRjDu2z5W/rrvYu9CFYvwk8j22J9zjvqJ" +
       "3/vftyh6GZBv43DO9ZehL/z44/iH/6jsfxIZi95PZLeuVMCG5aRv/afcP738" +
       "zL3/+nLlilx5SDvcDYmKkxbxRgY7gPhoiwR2TGfqz67m90vXF44j/7vPe7xT" +
       "056PySeeBjwXrYvna+fC8GMFl18A6blDyT93XmkugcB27WQpVRRqex0q8xtF" +
       "9l0n9vABEAbjcv+VAHIsT3HKGZGk8gDJkCw5mt4cdViyNI8TfSwVQ38txfjo" +
       "MdmPFKVPgfT8IdnP30J2pXxwb0/q5aRyJYiszaGhWkc0Xo2NMC0WOaVqn6PP" +
       "e/30PVCUvgukg0P6Du5AX3p7+krTCo+oui+xXAMw1Q1uR9bmDZL1JEjwIVnw" +
       "Hcj6+Osh6/7IcAwlNkaHenZeni/+BfhVPySsfgfC/trrIexa8Qqi2H6CSFQU" +
       "wWX5nppmUrkL7L/PkfrX3yCp3wkSckgqcgdS/+brIfWq5uvGBKyiit8vnaPq" +
       "U69J1R5YYaL31A+wgxLoyxdZZ5Gtzqj8O9eOduNo9XNo5DfWDnY7iSKvmyDg" +
       "qh88WckwYJXzwo/+10//+t9679eAPx1U7tkUvg640VPLnVFavKX5oS985j33" +
       "v/y7P1ourAG3Js+qf/KRYtS/98ZgPV7AmvhppBmMEidsuRY29CNk543o9SNL" +
       "Hs56SNzvHH2YmmI0OmJtbEPtnWT3Bc9eTnN7Kq2kfrJjKIaEQ7LTJ6MMdfpT" +
       "aWEFK7AX1mTWMxqLRUPtDbohG7L99nocSz7fY2vmfAhvPCrq6U6nt6p7IqxH" +
       "magu5ll7zVF0LMvTIBw3G/VqC0s3ZorouUn356JLoEmebwwdg1Idayy4hq9z" +
       "9sylp6k8XWkLSfVhJRYVShfcpiCySex2JF4nFoM2Ou5vMixrudxIpCaONZ52" +
       "t/P1Yiywqe1aWhz0bc+dSOtul1S8sTC3h0M1gBWn257T+CS0pgOddfxd3doN" +
       "yDBezGpjb9SJmh1nMshxdwLBrl+H6x1YdQczfMINNHuTIFBjsF3WlGGILRQ3" +
       "bwxGaoMeIeyOjVG1O6FrlpN34oyE3Z1JkzJDuBGJcXBtjLYRPI5X61GcLNOq" +
       "0FeXVn2Ab/2l0rNgNGI3ataM0XGXJbMxJYvbtrSLa2LPlYLV0M5SJ3HmHp0O" +
       "mNZ6INiTgRixFjey9J2liUuY8Ddu0hPdpTmehvTAnTuTlADbnmEyIqm+NR6L" +
       "iOuGHYaWkxGFajJHCdt5Q+eIkZ/mdBIpoCviNrxMgPRY4eu13dwe2E44GM5U" +
       "QE4X7yjMoEMJbup6aURWHWUYDIbOVGI4LJwggzia9hqp0xSyQOjSKt5O9eV2" +
       "hk79PDDhFjlsrygYhuvjcBEYm6nQGPLpZjJ3ZLrT1eXcas5XQbr1UCGm+vjW" +
       "nMCdnuzZqMBNZuHQFsSqFe24tWx2ASFJXuvUQ05ZDJ0Z2cSJGtiM9JfrvoBt" +
       "1elsKy+bliASVNeTe9Jy1horZEtYSRJR92eLJuqJspB3I3ap4ZOxJWMBRHMa" +
       "meammthuAk29ebwx7FBW2clgTAvcTKRoY77phGAfGBbcrNVwD12SotQYzJGF" +
       "vM5qfdLvTwdY6tbzkTFnNs3FgkFXbSgPAPqWpeUbVBfpcRsJetVwAvGq6DaD" +
       "5ZQKR92Z0GJG7fqa2yg503M9Tll1V3IqoIjbiUeNVauZtataDBPtIeuH8+1a" +
       "Vvqhm7lbMPI4n1uTKS8y4WxQW+rUjEYd1hEFpldvrVETN+zuOGwDHYW3sqMq" +
       "4xnq1JzhpqUCegkcmfhkgjgDpeE21vMuYTKNiJT6Q8noQV3cGGjTZga1PZlK" +
       "WjO2IaR4Z2iFE781QfWxWR9x5EQz426dHSC0VPUbXWSH+FKSqWsfljV1NMX9" +
       "lI6xpWE3oq7S6i7mLDJGYz9zvJkyCvqDzmCZQ3MsXWZG7LjirDbdkNuqTNcC" +
       "nm8zjaUr0grv16llPhGAn9lO/QyW1k7Nt9Em2u2vGBbC20YO9KouCesWLQzC" +
       "ts6kQ0yN+VFX6CwVey0L+AqfbRONns4pXwtabaq5xjKg3jNe2hi82SadgeBO" +
       "GHjJOpzAzqpxbastO75DJMFo3ob5oTZhIMEx7QydOOGu34/a3JKgu3ko4r1Q" +
       "wtrrQe4gAcFMqla3ZeDxjBpXtU3O2fMEi2rIeCBSm5jVnAFMa8KmnxKjHjob" +
       "5b4ODSyTTlMe8mRY3zRCqYkZ2KDHpLY4G/Y5YoEQLZafDnIpobrYxqgHZh/R" +
       "26w/Xg98AhOGExWrQQQJ1xUNJWVdsTsrnQu9FWX32GC1YG1aXyzIpkHP55pp" +
       "5tthHpJMw11ivJJszCrfQjibJ/RQdnbzlcdbNQRlqv4c23i5rFUhotnjUM1W" +
       "nFzeyOlOdvSl4Ko1vjMVubmq+jV22Go30bi6mddhVN+gDZVhM2lB592xm6l9" +
       "nOhSS4at5bUGKm42m8XGTuZrI7dYlo14mdiK3Chs2e2AH5K4uEomc47vEpLc" +
       "X3YVYj6qZ5PtdGcnuAnvxprZDFNFa2UQVIPrNWfV6MMDNvfr4pptEM28jXYi" +
       "z1llVTPn5LRv9T1xq+1k2V5EioB5bdVPMVJC48Sosim0jVv9Nslrq9oqmvTi" +
       "iJBhO1vAOtRcqxhhdpmhwKssnXl+IOpca0asxRqUYAxbn836Uc+bYghk1vkN" +
       "Ha1MdOAYS7TOgr4NCtU1oS9uQURLu9C20bJaRD6aIn3OkyVSrVezGRLh0Agd" +
       "69yuz3sTm2SEEO62FlANExqGaY5Wk+2g3TBlPlgCozO7HNaU8ZpWk7M4spa8" +
       "R0znnfkwEJC6UsOb4zkdaf1gBAH/CTSxXW02G8EwagRJMA9xwYQ2I2iB5HrV" +
       "xPLxfFANlW1I+bsIHkiJBateq97kAr1HL3ORbziZGS9dfLxKA7a7CCYBVw/0" +
       "beyry13ewxbq2hGJanvbRCRsC1s2PpW6XAPrBPKSSqZhgw9zQnIkPfO1DQIk" +
       "3Ar7E8aKVlIt3XKavh3X1M00CsNmjmVoolVdncF2Oudx48hoJVt9MvKpXA+H" +
       "nLubI5TKtmmjmkv9DOdH854BIYpSa0HkZul2Jlw/mdjjUOOaUzXCp5s6RnqO" +
       "2fDcrL/TGdQQmrg8GSoJrgR8p59bMjGkp7TPCaHKKwMjjXcENenM4EREZ7Mh" +
       "BQlLvYn5vZWmsDV/3dvsvATiILahVGHVRCcUi+xyl5JUL1mo9tyJWzw9wpi1" +
       "6lGC0u5TjEkk4WqL8Y1Z1pBHyJCQ0qpjsqK949XNlpbUHuazbg1hHATb4DhV" +
       "b3emVhxTc+CpEE2wrbbiuNyu1wNGqxMjqk3liuU3NuGUW6WElq+8uSjNetGQ" +
       "62FbfRcOurVmu8UvMNPrYVZXbAvuMFjXsTmF1nYQhPCQwy9XUbYdrgZAqaaD" +
       "Kjlq5PUmWsVHHFYTtpNRXWImO9wXwFqI0qo2b8N1h6hXd8tgig4UeIr67W24" +
       "sxZil1w2F+MUgwkg2hxbN3za0q0gyik90MxG1mCMdOPp2RgsXNB+OJ4ycQM3" +
       "5y4dtOy6ZylQYzZfdoYOHHrTuMeorM3oozqeNRY4TKNS1F1DEpsNyJlgKiIz" +
       "HRGUy9kpWMHVE0yBdX4Rq822o6aeBNaeHdKkWbuTbGrbdttqkjLqthtMH28I" +
       "KyhVFYR3KHq3FnU6kohMbJp9b7byum7A4iubaS/nmKtVB6YMGbs5WOxpHE9Q" +
       "WChaHXKtzUSEwaqLWRUGelMlqD5ZG9LbFeom9HAHNXZabFU7MjJv13y/U5+3" +
       "MyQJRyu5T8+mo0kgcrKw8eaSmDYbtVUKCQgSYWOw8LWXzSolzCXO30rmdres" +
       "b+a7Liq19VAdyVJnrWANq70KyMlOrYotBHjVZpvfRF4v1HOpFda3A3G78PV6" +
       "1Tft3kziOxaVOEJS5U0/R7tmZlsKI0szEEV2/npTjydmbbidkXHNabdki9rm" +
       "8rqbY9piY2lOzaLYVpxq3tQjhtuuFMx4X6bqzG45zAcGnkGyWV/CtYW3qYok" +
       "xjdRQq/RNXTa14NowARuZKOkE2FmNoFZe4zBuzY6r0JKlkvsoMngxk7lW6rY" +
       "gZrtTncwmzVwt93f7DAehfK0iRo9wuM4RKI2K6EV8S3RTIi8Vm2Oma2zc9ud" +
       "yBiLWo8PB/OoHoTZ0JsOpiK2c6D5YKOxuga7tjoZmqa3gqdMF5lJ8IKD4R4r" +
       "WKEtwww9dbs50R2urK48RztdC12YvSmKwVXbqTXslsUZgyaV9+IUbzpKfxWt" +
       "VdYwJ0Mep40tPmja69ly16Wam2ZV7RJ4f9QxctFmeot44Q5s1e/uoihBR8EK" +
       "sTXCCyWN5NtwlgZ5L0NzZEzFgTTNkIwi6ZDJqztq3asD3x+M2SVp8IM6i834" +
       "rNYJib5TE4lkjRIIolkWMSYbIruSwAZJy4acviUo0WkPkD6RIcKkwwp8j047" +
       "IJjW2ZbEjsdENE+NOkOSk+oW7I3YDkbI4x1KEww9VndEndamK3G55ntJkpgG" +
       "cBfkEnYJsorbELu2pXi2FEehuBRgpUss6vp4J+wUoS8gcxNCzY6WjGZNus/0" +
       "Exh1BG03lFAhX89mq4E48XbTyVRTCRqhGVEM+opSTeIc6NC2PsThVqMbLJvD" +
       "bEzGGdL1YnPY0ClLnC0xuy2RKKmmpoes4wzmNbW35Oq7jsGvWIyMhTjDrcUK" +
       "yal4ai9iehLqEhQQC2OMQQ1IM7jqZmwZ3TrYBm3zLqPhjSVsEeYinW3bpNZJ" +
       "RKo+zFy5EyG6bVZpTs4xIfa2jBhpnZxZxXocjRGV33W7Ad5rqktE3rY28aST" +
       "LFmD6EnJtCulI7K7QOKhBMn4Clb5TO4GNCtnmCQIONYL/HQ8XOMclWhyzZ0p" +
       "POr7cKsjaS1m3tSmCCIsLUKn63xdiFcaLC7ZSYfaugvJ2CJ9yIC8VUJBQ2kb" +
       "VomF0JY2i3jcG7txKPtoaiCcaW84aBK6dKuOKQ69aBCKGW1m+VQRI6tKiWob" +
       "bbTIWofMQ2JqpUIDH9KoiAoI605Hok0N5Vxaz3Qyj4jRRF228tlymBhtnGRW" +
       "a7JWpVp1UdxicaLgC46jd6ihw7CJV2cty0wjNsDyqlStaa6+g6EQFYM2ovfG" +
       "TFabe2K7HZn6bC7Pe3wvHU+cCeGATUY9X035thTjqSEizrxmVNPFbLwzTBuL" +
       "u6HKkrqf1dbuaBx0DLBvYEde2sBQOgb7W6i18UQb00cQTxH1STAmk4Drd3op" +
       "vDE7ND9MZS5wG7zYQ+pqdwHzbqPJKY5erVcNymsimInqO90y54pG5ztoCudG" +
       "1QXrUJgzoyoHEYFPUjaeQ3RQReqoM8zmPV1rNXZDxze2Q3cuNQlCr85MHKp2" +
       "/eF4FTObCJlDvaELdv10qNa6o+4Y5jb1wZybNubTDeC2nY1aGYnwpjqX1Hjs" +
       "5qI87kJxtIPGkeuieZsT6Y3Rrrn9le20ovES24mNHYYs2ig5MobJzu50Oh8q" +
       "D7o+/8ZeAz1cvt06vkbzF3ivld3uwKT83Fs5d/Xi1EvAU8cWl49OiG7c7pJC" +
       "5joHC5aZR1ZiFEe1R43ffvJiDAf78rKuOIV7z52u2ZRnkZ//xMuv6NxP1i4f" +
       "nr1gxctjP/hux9gYzimaHgAjPXfnoxS2vGV0cp7xK5/4b49PP7z62Bu43PDk" +
       "OTrPD/kP2S/8Gv1+7W9frtx1fLpxy/2ns51eOHumcS0ykjTypmdONt5z9ojg" +
       "nSBxhyLizr+nPVGC27+k/cBeiS442vqlC+peLbJ/nlTu0Qrx3eZ4d3+2c6KE" +
       "/+KsEj5wrISXjjo/cqrzxogiSzcu0Ns7HBj+k2MOlQ2fBkk+5JD81nPo311Q" +
       "99Ui+zfARpdGMjk8d9m/BC7f0J5w5itv+FT0HMh3g6QcglTeepD/+YK63y6y" +
       "30wqDwCQ0zPHOCf4futN4Ds+CbMP8dlvPb7fv6DuD4vs95LKgwDf+Nx50AnC" +
       "//ImED5aFD4DUnyIMH5rEN5yiP0nF8D80yL7H0CM8Tkxnooi//PNgrwB0scP" +
       "QX78LQe5v43wrTuDvFQ2+3Mgy/gWWZ6C");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("+c03AbO8o/DdIP3wIcwffkthHjnKpy+ItFyaBGlS4r3/4lH2IdjyD/ocmWlG" +
       "UES8st/1Irs3qVzdFlEbjHm7U8a7N76lH3Pt0pU7evei+JffjB8vXcDjIH3u" +
       "kKmfe8tdwKUnL6gr1kaXHgfsSPz9laWzxn/pXd8+6KXZvBeknz6E/tNvudm8" +
       "VGJ8/gL8B0X2XUnlbcBsRscnz2et5tIH3oTVXC8Kixj284cof/6tF3Drgrpi" +
       "uXypAQAuzwN86QTga56gvpYYi5XIlw4BfunbJEbiApRUkX1vUrkfiBE/dSp/" +
       "SogfebNCLKz0y4cYv/zWC5G/oG5cZEMAb3kW3ikRMm/oZtaZa0HFddHHbvmf" +
       "xv6/BdrPvnL96jtfmf1Wecn4+P7/fUzlqpk6zulrSqee7w0iw9zv4+7bX1oK" +
       "ShwScMy3ce/A/Rw9FqReWuxbfx+g8qR1Urmsnam+mVSuHFYnlbtAfrpSBUWg" +
       "snjUShH9q2wfGx47LeEyJj7yWpw77nL6enGx7yr/AnO0R0r3f4K5qX3xlcHo" +
       "+7/R/Mn99WbNUfK8GOUqU7myv2ldDlrss56+42hHY93be/abD/7cfe872hM+" +
       "uCf4RNtO0fbk7e8Sk26QlLd/83/2zn/8wb//yu+UtzP+P+gigGObNAAA");
}
