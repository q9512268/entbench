package edu.umd.cs.findbugs.ba;
public abstract class AbstractClassMember implements edu.umd.cs.findbugs.ba.ClassMember {
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    private final java.lang.String className;
    private final java.lang.String name;
    private final java.lang.String signature;
    private final int accessFlags;
    private boolean resolved;
    private int cachedHashCode = 0;
    protected AbstractClassMember(@edu.umd.cs.findbugs.internalAnnotations.DottedClassName
                                  java.lang.String className, java.lang.String name,
                                  java.lang.String signature,
                                  int accessFlags) { super();
                                                     if (className.
                                                           indexOf(
                                                             '.') >=
                                                           0) {  }
                                                     else
                                                         if (className.
                                                               indexOf(
                                                                 '/') >=
                                                               0) {
                                                             assert false;
                                                             className =
                                                               className.
                                                                 replace(
                                                                   '/',
                                                                   '.');
                                                         }
                                                     if (signature.
                                                           indexOf(
                                                             '.') >=
                                                           0) { assert false;
                                                                signature =
                                                                  signature.
                                                                    replace(
                                                                      '.',
                                                                      '/');
                                                     }
                                                     this.className =
                                                       edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                         canonicalizeString(
                                                           className);
                                                     this.
                                                       name =
                                                       edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                         canonicalizeString(
                                                           name);
                                                     this.
                                                       signature =
                                                       edu.umd.cs.findbugs.classfile.DescriptorFactory.
                                                         canonicalizeString(
                                                           signature);
                                                     this.
                                                       accessFlags =
                                                       accessFlags;
    }
    @java.lang.Override
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    public java.lang.String getClassName() {
        return className;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ClassDescriptor getClassDescriptor() {
        return edu.umd.cs.findbugs.classfile.DescriptorFactory.
          instance(
            ).
          getClassDescriptorForDottedClassName(
            className);
    }
    @java.lang.Override
    public java.lang.String getName() { return name;
    }
    @java.lang.Override
    @edu.umd.cs.findbugs.internalAnnotations.DottedClassName
    public java.lang.String getPackageName() {
        int lastDot =
          className.
          lastIndexOf(
            '.');
        if (lastDot ==
              -1) {
            return className;
        }
        return className.
          substring(
            0,
            lastDot);
    }
    @java.lang.Override
    public java.lang.String getSignature() {
        return signature;
    }
    public boolean isReferenceType() { return signature.
                                         startsWith(
                                           "L") ||
                                         signature.
                                         startsWith(
                                           "[");
    }
    @java.lang.Override
    public int getAccessFlags() { return accessFlags;
    }
    @java.lang.Override
    public boolean isStatic() { return (accessFlags &
                                          org.apache.bcel.Constants.
                                            ACC_STATIC) !=
                                  0; }
    @java.lang.Override
    public boolean isFinal() { return (accessFlags &
                                         org.apache.bcel.Constants.
                                           ACC_FINAL) !=
                                 0; }
    @java.lang.Override
    public boolean isPublic() { return (accessFlags &
                                          org.apache.bcel.Constants.
                                            ACC_PUBLIC) !=
                                  0; }
    @java.lang.Override
    public boolean isProtected() { return (accessFlags &
                                             org.apache.bcel.Constants.
                                               ACC_PROTECTED) !=
                                     0; }
    @java.lang.Override
    public boolean isPrivate() { return (accessFlags &
                                           org.apache.bcel.Constants.
                                             ACC_PRIVATE) !=
                                   0; }
    @java.lang.Override
    public boolean isResolved() { return resolved;
    }
    void markAsResolved() { resolved = true;
    }
    @java.lang.Override
    public int hashCode() { if (cachedHashCode ==
                                  0) { cachedHashCode =
                                         className.
                                           hashCode(
                                             ) ^
                                           name.
                                           hashCode(
                                             ) ^
                                           signature.
                                           hashCode(
                                             );
                            }
                            return cachedHashCode;
    }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (o ==
              null ||
              this.
              getClass(
                ) !=
              o.
              getClass(
                )) {
            return false;
        }
        edu.umd.cs.findbugs.ba.AbstractClassMember other =
          (edu.umd.cs.findbugs.ba.AbstractClassMember)
            o;
        return className.
          equals(
            other.
              className) &&
          name.
          equals(
            other.
              name) &&
          signature.
          equals(
            other.
              signature);
    }
    @java.lang.Override
    public java.lang.String toString() { return className +
                                         "." +
                                         name;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "6yq/y+aVXGV/y1/x7eX/A6egIbsCMAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "c80qi0u+tcVo1k9wbMxuFKS3ZoI241e37WBoLvABUanO7UhD03HVXk/DJdee" +
       "kBsnVsurLgyl/NBLaFvnR62Yb/ndrco1ESnaEuMkgAxcGrAmXhk329S2Oqu2" +
       "Y5Ix5DGkoqzJ8II4GOHosNFYU5CQuLRKwp2GNly5QjugYmo0zZqrSdPE6lS2" +
       "sFNpxEmphQGbbCl9L2Cm8qpFpi6brgi6aSJYo6HAuB5te9ZQhMa1TXNRbo3p" +
       "VieERszccduB3S9XNYtJen2YTKEmwjEo3IHrYLjLUF2jmtLKZK1e2ClXoGaT" +
       "XW7XUDtoYxnpRnSPCtfrVqctLRI37pabM6Aqm3ElIjU6tBHSiPB1B4fhVM0g" +
       "v10T1vUVpy5qy1nI12blqDuWEtNHoRpJyZ2BNOy4/iKB+bKUzfohY9lM20xC" +
       "uWpCCckrE9zbNskEH8H9oenqtS7vuOVstDQZbLaC3dkQdhs9KnIWjGvZ1JbX" +
       "EK/WxPEttrRX6Gg5c8zQcMXpxisLNh73hkpFaIV9R5eouU1jEFk3V7xQLzsu" +
       "LjQ20lZCdByTrKUDd0iU76Zur5uYQ3ceT2GiglfLTApWSuttfc1yjLitd73Q" +
       "mnVhBKMC8LTJKd9dUqxMAVTuogMNzGhrADOPbbVbNfvLfmXYna9bVauddTLM" +
       "jQbbBjlLN8iC5bsDfE5ElBgEBuJXO4SBYe6WkX1SkTrA8XppqDB0ZTBSBIkO" +
       "NUJEfTOdwARLOSkBl1PPZFA7IFYwvzTrQbMzN9g1NNP7TSVlFB4Esjwy65I1" +
       "aNNorlS+LGtBZmx9b+WOVHWL1Hhdaq+Gm2mtSxhKde5y1oAy8bmNRmYtM2po" +
       "v0PXuGYyRdfCynGWLYrAxESQxtUBqfON2QbeKIuu1obpbqxkpGy0pA7t15KN" +
       "7c1TVasxaLsZ4eP1IublcmPeC8XMLguGtNwKTmRW3OEqmbLJZJnpsrYe2gNL" +
       "raz52aYaQuV1T0jLshMZSjfZLpe1ZGG26IjvblQCrYFG5vCiLLXlJldXa57a" +
       "T7RVnenzEI22/IXutYSePoins7oOgsKh4Q3bSlMTlSYXVS23TquiQmZ1H0dk" +
       "zTGCStmcKRWVtpxwy8zbnkC7cmglDt9ebLf9rFcxqraaVuwR1ZvF3tpeiUO9" +
       "M5GJqmzFid8aw6IxpkMiCZYDq28ybN+oBXXSXwrNLatD5WGbjbeEE+G8IpLT" +
       "2SREjIbVNZiggo0rMxFPe8uRi4RNrLciEnnB+SMZqwcNY15v+wxptbrWemE0" +
       "GbYpIS5Z5VvtYUa7Y76ueaE042pOHyGjSYSO5NnENdYSRKgsjiFrymwy204v" +
       "GtbwRhbQlVU8QObrUWsYMngnViiFhSPS0OrWApl7VW5A0XqvTo7rHO8vRCeh" +
       "xh0YnUSMz/IGahM0skDr2LjaoUf1KiQ2F/20W/Pxaq1siltMdKVJdUTPuv6g" +
       "BWzA1PEtN7HjaZaW5wN2PLQzMu1anaxOrv0G4/jdNgJCV1+nBuUa2w/UzEsx" +
       "kRJtorcc+6xoVMSGrJjxOqz2yaBBbVgz6FbmQZXtS/REaE7UDUb0fX0SJH2W" +
       "HS4787658Fu1lSMsK6ZtjnzGGCp4Y1NZoeIG2xK9rEwsaZzimBHRmzp+yjCa" +
       "l6U08Mkam1T7aCUGBdEtMTASHiM0kxC5ltvsLOg4QMqw2lapUZoZ42zDao0J" +
       "FmeoS2lmxRwhzUiwexnCI9tFa9CQxokiZUbaZOheVg2ULO1qBDmcJFiD8tla" +
       "n52HPdRlKgy5FdFOuhaHBIkoIppt5mRmdNW8bIT2TQ3nxN5mqWPzNZytwXpB" +
       "S8sBaY/ATEUqHMHMjEGGEgt5PDUXxAAZTvu+yKXZkqouUbJKi5t6HY7n8KZr" +
       "lEPCD9DK1skqYCaP+mC+pTMV8yo0Zc4xLIVNDSvb6nRsIQ7eskc02rDDTWSU" +
       "p2qiRwTb8U2ujvLkVhJHUE2dLWALajSW6hqPg5iS8CQt913WCoPqamOQ/qBp" +
       "kwrTQyuIRMzhKkEbMuYZeI8SjQhwPFp1wJqLHIncqtmWCaOTMLwxSsZTGZjS" +
       "tpEaUL+SBonT8GEqEslORxN4rQpt9HUbxgNIbhHuRA45UXBqi3JQWQvaarys" +
       "0iQjye322NssifpmaE3r0SKzCY5HonqrHeLzDo4P46nJIyO0rClauTseUJXN" +
       "SrLYVlZvoH2xxvayFVohGmViYOFWszqSo64rdW2Gx3ly0Zu2y67IjDS4u2Ci" +
       "Pg78y7q6bUy2gM9FuiAmUDzrVDetut9vbYcx41ubqFafq32Lp8bMUO+6+sCE" +
       "6C3S8uZrzG914Uq7PSc3WBlmuinsmmh1644df9BdkslKNulom84mUSauB7DR" +
       "qbdVhtiuO45WFldTFpcn2GAjg2URFpalBi0nfI2NOJPVyKoRNddNaJokFuk3" +
       "dN2btSAeSA+xibUbpQPFbhudGKqxsWqL24a8scqy4CO9CrqFPLpjCV2H3oik" +
       "pqaxQ61WgUEoPVXBjVUbntWdaYMNQGxcRqYzG4uceMqurM4sSkOGd31+TvV5" +
       "qdkkWtu4J8SjNjlPZbnspi0cs0cyxZRtfdIcSZUy3OKmEqw0sxWUge5nPQHK" +
       "wBC39BmENHWDUiJsiCBIvvXzmbe2JXVvsdN2dOPkb7DHtrlgr/aluHRF3p+6" +
       "H598Fr9rpTNXGE7sXZ44tzna0X/qOof6Jw7z80OoR693IaU4a/vCx19+RRv/" +
       "UvXy/misE5euxn7wAUdf686JXu8FLT17/dOiYXEf5/jI5usf/2+P8B8yP/IW" +
       "jvgfP8Pn2Sa/OHz193vvUz9zuXTL0QHO624Kna703OljmztDPU5Cjz91ePPo" +
       "648vyP0gkGc3kI914Pzd45d2OnTByeOrF9C+nCe/HJfuMvQYO3XYc6x2v3K9" +
       "c57Lh1px3/FW7Xith6GlXXCEkxP4NzzhOclokfGFI5kVevoB8Az3MhveeJn9" +
       "swtov5MnvwFQH8oMrFnU0AoOb6UBgXzgPDMpDtPy60UH59UqRP2b1z1Sy7O/" +
       "+sNIrdC0d4KH3UuNvfFS+8YFtH+ZJ78bl+4AUjtHyb5+k5E/AZ7ZHvnsxiP/" +
       "owtof5wn/yYu3Q2Q7y/2nSOAb17Xyt5A");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("AD+0PR35IHkvH/nGy+c/X0D7dp78x50P4k6dcR5L589unnrcn2fmx6H6Hr5+" +
       "4+H/xQW0v8yT/xGXrlnRqTtcefbqWAL/842OnC6AmM/yxZmqvYdo33iIP7g+" +
       "7VLRxF/vLAA5c1J8jPD7N3mM83nD3wvAv+ECuHTXBbT8es6lO0AYZkXc0Tnr" +
       "8eBeunKToT9Syq9H7X7xjYf+zgto78qTdwC/b0Xd/G7JGeQP/C0MerZHnt14" +
       "5O+7gPZ38uTJYtCZ4pT9DPSnbjL03KV/dA/9ozceOnwBLb+2cOkgLr0NQD+8" +
       "c3kGPXST0b8bPD+xR/8TNx798xfQ0Dx5DixqcvTFxaoz2D94k7Hnrv6Le+xf" +
       "vPHYhxfQ8ntBl8g4vx93+OHGGfDUzQNfZOYx7pf24L/0FsCX3hD3/ALaj+XJ" +
       "FExxrhwukSPsRdmzF0rWvqUdy0P4YSf2h8Dz1T3gr9740bYuoC3zRAMuzjx5" +
       "Z+kYm36TFT0f69/aQ/+tGwP90ukNjxO3kHY3OQvc6wtkss2TVVy6XV8l8m47" +
       "44T2hzd5nZPP9F/bS+RrN14ZfvIC2ify5GNAGWL/xI3yY+gv3UDom7h0/zkf" +
       "kuRX4h9+3Sdru8+s1C+/cu3KQ69M/13xLcXRp1BX6dKVReI4J6/anni/PQj1" +
       "hVXI5eru4m1QgP3ZuPTg+XthcemyIucMX/rUruhnAK/nFAWCOnw9WfqzwHce" +
       "lwaNqafInwOR1J4cl24B6UniL4AsQMxfP58P+aV0s1Pkh09qTBFs3/dGXueo" +
       "yskPLvI9uOLDwcP9smT36eAL6lde6Y9+/HvNX9p98KE68ja3g9IVunTH7tuT" +
       "otF8z+3J67Z22Nbt5DPfv/vXrr73cH/w7h3Dx9p7grfHz/+0gnCDuPgYYvub" +
       "D/2TD/7yK39SXBr8/9YunfjROQAA");
}
