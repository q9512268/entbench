package edu.umd.cs.findbugs;
public class BugDesignation implements edu.umd.cs.findbugs.xml.XMLWriteable, java.io.Serializable, java.lang.Comparable<edu.umd.cs.findbugs.BugDesignation> {
    public static final java.lang.String UNCLASSIFIED = edu.umd.cs.findbugs.cloud.Cloud.UserDesignation.
                                                          UNCLASSIFIED.
      name(
        );
    @javax.annotation.Nonnull
    private java.lang.String designation = UNCLASSIFIED;
    @java.lang.Override
    public java.lang.String toString() { java.lang.String result =
                                           designation;
                                         if (user != null) { result +=
                                                               " by " +
                                                               user;
                                         }
                                         if (annotationText != null &&
                                               annotationText.
                                               length(
                                                 ) >
                                               0) { result += " : " +
                                                              annotationText;
                                         }
                                         return result; }
    private boolean dirty;
    public boolean isDirty() { return dirty; }
    public void cleanDirty() { setDirty(false); }
    public void setDirty(boolean dirty) { if (this.dirty == dirty) {
                                              return;
                                          }
                                          this.dirty = dirty; }
    @javax.annotation.CheckForNull
    private java.lang.String user;
    public BugDesignation() { super(); }
    public BugDesignation(java.lang.String designation, long timestamp,
                          java.lang.String annotationText,
                          java.lang.String user) { super();
                                                   this.designation =
                                                     designation;
                                                   this.timestamp =
                                                     timestamp;
                                                   this.annotationText =
                                                     annotationText;
                                                   this.user = user;
    }
    public BugDesignation(edu.umd.cs.findbugs.BugDesignation that) {
        this(
          that.
            designation,
          that.
            timestamp,
          that.
            annotationText,
          that.
            user);
    }
    private long timestamp = java.lang.System.currentTimeMillis();
    private java.lang.String annotationText;
    @javax.annotation.Nonnull
    public java.lang.String getDesignationKey() { return designation;
    }
    public boolean hasDesignationKey() { return designation.length(
                                                              ) >
                                           0 &&
                                           !designation.
                                           equals(
                                             UNCLASSIFIED); }
    public void setDesignationKey(java.lang.String designationKey) {
        if ("".
              equals(
                designationKey)) {
            assert false;
            designationKey =
              null;
        }
        if (designation.
              equals(
                designationKey)) {
            return;
        }
        setDirty(
          true);
        timestamp =
          java.lang.System.
            currentTimeMillis(
              );
        designation =
          designationKey !=
            null
            ? designationKey
            : UNCLASSIFIED;
    }
    @javax.annotation.CheckForNull
    public java.lang.String getUser() { return user; }
    public void setUser(java.lang.String u) { user = u; }
    public long getTimestamp() { return timestamp; }
    public void setTimestamp(long ts) { if (timestamp != ts) { timestamp =
                                                                 ts;
                                                               if (false &&
                                                                     !hasAnnotationText(
                                                                        ) &&
                                                                     !hasDesignationKey(
                                                                        )) {
                                                                   new java.lang.RuntimeException(
                                                                     ("Setting timestamp on bug designation without annotation or d" +
                                                                      "esignation")).
                                                                     printStackTrace(
                                                                       java.lang.System.
                                                                         out);
                                                               }
                                                               setDirty(
                                                                 true);
                                        }
    }
    @javax.annotation.CheckForNull
    public java.lang.String getAnnotationText() {
        return annotationText;
    }
    public boolean hasAnnotationText() { return annotationText !=
                                           null &&
                                           annotationText.
                                           length(
                                             ) >
                                           0;
    }
    @javax.annotation.Nonnull
    public java.lang.String getNonnullAnnotationText() {
        if (annotationText ==
              null) {
            return "";
        }
        return annotationText;
    }
    public void setAnnotationText(java.lang.String s) {
        if (s.
              equals(
                annotationText)) {
            return;
        }
        setDirty(
          true);
        annotationText =
          s;
        timestamp =
          java.lang.System.
            currentTimeMillis(
              );
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributeList =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         );
                                       if (hasDesignationKey(
                                             )) {
                                           attributeList.
                                             addAttribute(
                                               "designation",
                                               designation);
                                       }
                                       if (user !=
                                             null &&
                                             !"".
                                             equals(
                                               user)) {
                                           attributeList.
                                             addAttribute(
                                               "user",
                                               user);
                                       }
                                       if (dirty) {
                                           attributeList.
                                             addAttribute(
                                               "needsSync",
                                               "true");
                                       }
                                       if (timestamp >
                                             0) {
                                           attributeList.
                                             addAttribute(
                                               "timestamp",
                                               java.lang.String.
                                                 valueOf(
                                                   timestamp));
                                       }
                                       if (annotationText !=
                                             null &&
                                             !"".
                                             equals(
                                               annotationText)) {
                                           xmlOutput.
                                             openTag(
                                               "UserAnnotation",
                                               attributeList);
                                           xmlOutput.
                                             writeCDATA(
                                               annotationText);
                                           xmlOutput.
                                             closeTag(
                                               "UserAnnotation");
                                       }
                                       else {
                                           xmlOutput.
                                             openCloseTag(
                                               "UserAnnotation",
                                               attributeList);
                                       } }
    public void merge(@javax.annotation.CheckForNull
                      edu.umd.cs.findbugs.BugDesignation other) {
        if (other ==
              null) {
            return;
        }
        boolean changed =
          false;
        if ((annotationText ==
               null ||
               annotationText.
               length(
                 ) ==
               0) &&
              other.
                annotationText !=
              null &&
              other.
                annotationText.
              length(
                ) >
              0) {
            annotationText =
              other.
                annotationText;
            setDirty(
              true);
            changed =
              true;
        }
        if (!hasDesignationKey(
               ) &&
              other.
              hasDesignationKey(
                )) {
            designation =
              other.
                designation;
            setDirty(
              true);
            changed =
              true;
        }
        if (!changed) {
            return;
        }
        if ((user ==
               null ||
               user.
               length(
                 ) ==
               0) &&
              other.
                user !=
              null &&
              other.
                user.
              length(
                ) >
              0) {
            user =
              other.
                user;
        }
        if (timestamp ==
              0 &&
              other.
                timestamp !=
              0) {
            timestamp =
              other.
                timestamp;
        }
    }
    @java.lang.Override
    public int hashCode() { int hash = (int)
                                         this.
                                           timestamp;
                            if (user != null) {
                                hash +=
                                  user.
                                    hashCode(
                                      );
                            }
                            hash += designation.
                                      hashCode(
                                        );
                            if (annotationText !=
                                  null) {
                                hash +=
                                  annotationText.
                                    hashCode(
                                      );
                            }
                            return hash; }
    @java.lang.Override
    public boolean equals(java.lang.Object o) {
        if (!(o instanceof edu.umd.cs.findbugs.BugDesignation)) {
            return false;
        }
        return this.
          compareTo(
            (edu.umd.cs.findbugs.BugDesignation)
              o) ==
          0;
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugDesignation o) {
        if (this ==
              o) {
            return 0;
        }
        int result =
          edu.umd.cs.findbugs.util.Util.
          compare(
            o.
              timestamp,
            this.
              timestamp);
        if (result !=
              0) {
            return result;
        }
        result =
          edu.umd.cs.findbugs.util.Util.
            nullSafeCompareTo(
              this.
                user,
              o.
                user);
        if (result !=
              0) {
            return result;
        }
        result =
          this.
            designation.
            compareTo(
              o.
                designation);
        if (result !=
              0) {
            return result;
        }
        result =
          edu.umd.cs.findbugs.util.Util.
            nullSafeCompareTo(
              this.
                annotationText,
              o.
                annotationText);
        if (result !=
              0) {
            return result;
        }
        return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV8efAjWX2ffrOz1+yys8xyrNewFwMYGn4ttdQ6suaQWmqp" +
       "D0mt1tFShzD0rW71fahbbRYDqRhslzEkCyYpvP7DOCQGjMsJdmLKMYkrHLFJ" +
       "cIqyIRWD43IFbLJVJi7bSUjsvG7pd85vfrvrmZ2qfr/Wu/r7+Z7v9fv2fOqZ" +
       "wu2BX4Bcx9xophPuK0m4b5jofrhxlWCfpFFG8ANFxkwhCCag7pr0+C9f/svv" +
       "f3B5/4XCHXzhAcG2nVAIdccOWCVwzLUi04XLR7UdU7GCsHA/bQhrAY5C3YRp" +
       "PQifoAv3HBsaFq7SByTAgAQYkADnJMDNo15g0IsUO7KwbIRgh4FXeFdhjy7c" +
       "4UoZeWHhsZOTuIIvWLtpmBwBmOGu7PcMgMoHJ37h0UPsW8zXAf4wBD/1M2+/" +
       "/1duK1zmC5d1e5yRIwEiQvAQvnCvpVii4gdNWVZkvvBiW1HkseLrgqmnOd18" +
       "4Uqga7YQRr5yyKSsMnIVP3/mEefulTJsfiSFjn8IT9UVUz74dbtqChrA+rIj" +
       "rFuEeFYPAF7SAWG+KkjKwZCLK92Ww8Ijp0ccYrxKgQ5g6J2WEi6dw0ddtAVQ" +
       "UbiylZ0p2Bo8Dn3d1kDX250IPCUsPHTDSTNeu4K0EjTlWlh48HQ/ZtsEet2d" +
       "MyIbEhZeerpbPhOQ0kOnpHRMPs8MfvgDP2L37As5zbIimRn9d4FBD58axCqq" +
       "4iu2pGwH3vt6+iPCy37j/RcKBdD5pac6b/v82ju/99Y3PPz5L237/OAZfYai" +
       "oUjhNenj4n2/+wrsdY3bMjLucp1Az4R/Anmu/syu5YnEBZb3ssMZs8b9g8bP" +
       "s19YvPsXle9eKFwiCndIjhlZQI9eLDmWq5uK31VsxRdCRSYKdyu2jOXtROFO" +
       "cE/rtrKtHapqoIRE4aKZV93h5L8Bi1QwRcaiO8G9bqvOwb0rhMv8PnELhcKd" +
       "4Cq8DVyvLmz/5X/DwgJeOpYCC5Jg67YDM76T4Q9gxQ5FwNslrAJlEiMtgANf" +
       "gnPVUeQIjiwZloKjxlaktZWtXQC8+1k/94WcPMmQ3R/v7QGmv+K0yZvAWnqO" +
       "KSv+NempqNX53i9d++0Lhyaw40lYeBw8ax88a18K9g+etX/yWYW9vfwRL8me" +
       "uZUpkMgK2Dbweve+bvz3yHe8//HbgDK58UXAzttAV/jGzhc78gZE7vMkoJKF" +
       "z380fs/sR4sXChdOetGMTlB1KRvOZL7v0MddPW09Z817+X3f+cvPfORJ58iO" +
       "TrjlnXlfPzIzz8dPc9R3JMAsXzma/vWPCp+99htPXr1QuAhsHvi5UAB6CVzI" +
       "w6efccJMnzhweRmW2wFg1fEtwcyaDvzUpXDpO/FRTS7q+/L7FwMe35Pp7Q+A" +
       "i98pcv43a33AzcqXbFUjE9opFLlLfdPY/dmv/8c/KefsPvC+l4/Fs7ESPnHM" +
       "4rPJLue2/eIjHZj4igL6/cFHmX/04Wfe93dzBQA9XnXWA69mJQYsHYgQsPkf" +
       "fMn7xre++fGvXThUmr0QhLxINHUpOQSZ1RcunQMSPO01R/QAj2ECw8q05urU" +
       "thxZV3VBNJVMS//v5VeXPvs/PnD/Vg9MUHOgRm949gmO6n+gVXj3b7/9rx7O" +
       "p9mTsoh1xLOjbls3+MDRzE3fFzYZHcl7/vMr//EXhZ8FDhU4sUBPldwvFXIe" +
       "FHKhwTn+1+fl/qm2UlY8EhxX/pP2dWxlcU364Nf+7EWzP/s338upPbk0OS7r" +
       "vuA+sVWvrHg0AdO//LSl94RgCfpVPj942/3m578PZuTBjBKIx8HQBy4mOaEZ" +
       "u9633/lf/u1vvewdv3tb4QJeuGQ6gowLuZEV7gbarQRL4J0S9y1v3Qo3vgsU" +
       "9+dQC9eBzyseul79pZ1mSGerf1Y+lhWvvl6pbjT0FPsv5hRczH+/FCz6cpTZ" +
       "umF/u24A3HrdOStNX7eABa130Rl+8sq3Vh/7zqe3kfd0KD/VWXn/Uz/xN/sf" +
       "eOrCsfXOq65bchwfs13z5NhftAX8N+DfHrj+OrsyoFnFNuZdwXaB99HDyOu6" +
       "mfAfO4+s/BH4tz/z5Of+2ZPv28K4cjLcd8Bq9tO/9/9+Z/+jf/jlM+LNRdOx" +
       "tezXW/IiJ/bN56g8nRWNvAnJir+z1QX0ptTG2MneeP5qc6OhpyDsbb1aPl8+" +
       "6/QcjFxWMEcYR88H47bvg/mvu8/XRjxbdB9Frwf/z9AU3/tH/+s6/5AH3TMU" +
       "9NR4Hv7Uxx7C3vzdfPxR9MtGP5xcvyIBG5SjscgvWn9x4fE7/v2Fwp184X5p" +
       "t/uZCWaUxRQerPiDgy0R2CGdaD+5et8uVZ84jO6vOG0hxx57Ou4eaSa4z3pn" +
       "95dOhdoHMy6z4IJ2kodOK81eIb8RtnqTl1ez4rXb5VB2+0MgvAX5HisEJOi2" +
       "YOZP6YSFe6cDjG6OxwROdNqHdnH/kTKIz6YMbzsk9d6sNtMNZEcqcgNSjbNJ" +
       "BUH4TtfX18AXHJB3j3y0DjyLutVJ6u49pG7vwGM+mK9U94/Ua3/g2HZkmjeG" +
       "dTawh8C167z9ewaw6AbAslv7ANPtsg72qHmfZl61xdAF6EXHMRXBPgVy/dxF" +
       "kNtk1jTfUTq/AaU/+lwovRgFW3s6zfZ3PyvbX3kd27GlIq1wxx/8LXhfB5e9" +
       "Q2TfANGPPxdEd4e6pQBLsPIh7VOwfuJ56vrj4PJ3ZPk3IOuDz4Ws+474NAFu" +
       "8yyWf+hZadvq0h6wotuR/dp+Mfv9M+c5hazIfY56QMfLDVO6ehCYZ4ofAIKu" +
       "GmbtLII6z5kgEBXuO1q30CAAP/GTf/zB3/npV30LuG6ycPs6c6vAYx9b3Ayi" +
       "7AXQj33qw6+856k//Ml8nQ54Nn6d+OdvzWZ9+vnBeiiDNXYiX1JoIQj7+dJa" +
       "kQ+QnVaD544sfOm8VwmI5sE/uiRi5ZHMspaioENL4GkLmUqOyg+5YkNpTD2L" +
       "GI1ZspN4lTHXn2ArhN0g4pocmEgNQhEZQTccguCeo+qVaalV77RYSlDqG7hD" +
       "UJ4xjRO8FY8lSiewtQSxyza8cNZmuwiDkbW0FpWnSLs9MW0SjXhIhXgYXcOD" +
       "yVCEKtBY4HkSN6kBKS+HWskjJ065BCrxfoJ4PL5qT0mFW5eaFqxw41LZZwxy" +
       "SI1mRI0yV43AmrC0w3ldLhrReLOoFy1hQpWUsTEgipw81lHX6JiDosi3+zMv" +
       "jXyq4wUBWW00U7ztBma/OBXIPt/nx0ZPoNWBRnZwil+Sq6AOOMAHIii75qos" +
       "+75spWV5mMYh0mZ8w5omUxcWSKdEbthkUuqyVDBb+mV97Ldx0E+gPbrTS2ka" +
       "H8w5uS3hqDdnO51xAnlQI6iVKmVOinWB7JQnXVZlkNUonLOIYbFjV0KC2oz3" +
       "SrLbbLhYgnsGInc5kxwu+tZCbq7aQ5eowgKGSNCK02uiMx8kVn/oxm4rGTlx" +
       "UJ/0ExJnKMRKqxC5aY02XMoraocYlnXNZ7GNTrBiyZuVGQgfQx7MrUSvtbJk" +
       "Zz035O540SIGrZaGj6wlorshx23kdp/o2qMF3at5gkl4Pk3PI7M7TmyWJIU2" +
       "Ope1WPKk0bQIgX3xzMcYgo/4lesGeH0hoKPQhCdsyLlsdyQvKr6HYjEGha0Y" +
       "c3DSWgzH1VZ5sLJReTWn+zThjPHuKFBm9WoTWxVrw6mheLgjOSVs7BJOqcnO" +
       "ZLK7WiOaEjqETCKWFlOC0Y9pfuEuuihVn7PeUpAnxIiuQ8XRuMHbTW1FjFlE" +
       "wiO7NQyKftqkbJtDEWPNyXJ9GkZaMl31UXezDBw/9WNBX466+mQ+XljLSTBq" +
       "tTm/k8p0v4w2/EqFkFuo7GFplWFKk6RY4+E5RhQhktGVeZUeJEIrmnEzBxri" +
       "k1oRXslUvRLEiDnt+p5ZGdI1cihzJUsph8PFoN5updhyk/SVTrEX2kWUFOma" +
       "N1snK3M2qFojecLNW5OSt2K4wBGMKUPKXokcLdL5eNKdTWiZaSOiQchlc0ix" +
       "q3mYRPhSr5HR1KttPM2T4bg4ao/69JLSqPJyFnI9VWkvrEF9rdRHI51vaxDa" +
       "JVGTZdK4XEmC8aLmcbw35TvmZNAu8zzkOGt02jHSfgchKtay2OWXNmHMQmKD" +
       "jtl5j/dJcs7wE5xCyn0RXMsqFcUY2ilpDNL3LEVmA09MuGbStJN6UWG5gF8M" +
       "I97TeXOt2ogRMQxvQM6saQ+aHbFTFLjY1MguFizBje0TLEy3KLo+xq0Kv9Qn" +
       "HI6HziDUysOQk3uwrvajsqgU2+QEjKn3hv1Iq5ZIdTU0496ibYQys6lIAh+h" +
       "Qh3ssCfSjFIIBxmnPWqsG10jZeOWuGHXYYwgvGZgRhLguB3pTWKxnqJyq0kO" +
       "u+xoKI6rU4hdIQGPjLllpT9xGk1hBXVYJ5rUNzwuJjqswsMVk3RsqQYvk00X" +
       "bIBRrN5ulErxGCm3mgiED6AqVarVEKgrylAUVdVA19l+U98s2aU3a5EjA1uh" +
       "/Jx2F8rEbtTkOOqpI6HC60KLWvTmXKJJMSTz3LK4NkRyqgXtduRas1k32fQp" +
       "VHeqC6gW8nGNS7VabdCkBZ8tdaoY38AQRq2IHCQtuH5lhjhJFXcxjK10mcYy" +
       "Kq9hzCilMFGZLzDWLdrFtTwpRW4yDfRgJUZGy5TDVjGhHBmmQ3giKwOGpWr8" +
       "xl5MFRcdCUFzTrczwyJGzTqkKMi6p3vVuqRiqFJk+gtto8vdCrkiS/VRJwrJ" +
       "2WI86g/cjZzWNBSfxC1BK9Gs7DgkTAUYMfDY0aDaaJQ2RbQGdeB5qRk0plSv" +
       "OxWYWScdxNViwyNRtVEnKZiG2GBhEF2OldIQXcflTjFCU3Fi9kSdYag5jKQt" +
       "X4bmoiMtmr3afGrzbG3lkEmlHbOzdQ9V6026WGdCEmklE5r24ASCYGI1Qmw0" +
       "ilSI6TGpXWukRh/m7GIJLdXcXt/0cMXqJkwTDtBYkIuxSHadGeQmsLsWlwqj" +
       "EkOpFXcMg1p1Bny3U0v0sifxctRwi2W4VB6r1pzxJ/0lvSZMzqMtrkp20RXf" +
       "5J1BbdaNhZ5lLCCZSPjyukVRil7xKJaCvCbRmptstTrx0lY00Gqw3y1TkCwr" +
       "RpMqpXS7j+ojsYNvRH6zEaYh1g8nICbNfBBYXaIzo4dySkcyPCgOuqmgDJAZ" +
       "ifGdEMIrjShs18s80amBzprKDZC+TyG1EonOi2u1Vxzr0owgmyG+boRl0ksl" +
       "eA0VeTGMZlUGS3qBolTnPbvT0uqGN1M2DK9ChN2qbyoQ1RpwOtVWkC5u405A" +
       "e4vZ0qG8QB9oNNQEQdxC67Iahn5a1FpN3Zo7vaE8gKEUrpclqQQtxKbOpIhJ" +
       "debFoqNJs4XeZkdgb7uypxS50asVqCenDaQBVfyEigVYNjkSia3e2jBVFCXL" +
       "DCW6xagDlclZqbigNkk8MbSk4duNZNmZ+H41rZVsbsDPiiOq5pL8FJ3IEevI" +
       "dZHurEmfStUVNy6W68p0Ng/NmGd10l+weEw4g/UQW6NFsWJUokQAVPfqgj5K" +
       "lly1HBVHQuJgKReIIl8Syai+WHBsa8WmHVoaVFN9Q6c1RGqyGFLDRnNi3J1o" +
       "LOZE+GpuWq2qMF07CtNrcuhQUmAmhQ3cUcJ1bylRXQ5XmqJvqUhpuoRFqLZs" +
       "4GW3ak+xaUCvmrBFp3Bor2S+BpNVuSS1PFOsB1O3r4zbdFQWlNpgnaAyp2KN" +
       "oatBYyW0FdWCuFIrsTBiGKPiWGImZlCcl0M4QgwEi0q4TZWgaXfSiGMxpaj6" +
       "0pwM1Y5okKvaIMKqYgU3Ta+he05P7GK9Ot+JfWqDzhZ+q4cO6YpF4FYCYYIa" +
       "s6PpZEa0x9Ja0pudhSdaWrhhZqUQVsvyXI5EVFtPkajolBi3x3YXoib4nTKw" +
       "/oUiWgjBkMrM1NSNH1ldbwHWNTFMTFvllkn2PKMbTt3puFLGGthk2u1o/hSp" +
       "F0vz2JxPgelEwsSctXmlETKTtEJ3anqjbrp03WN7bh3mYjKWmEo8d22cZEK0" +
       "NbERrtNVkXJxzUhtdzWs+iZJYjXHg3sDmnHasxIQTLm3wZDemGWkLj3SxlBJ" +
       "BcvURKDlKj5QuS6rDKfouLGsS50uPBx2MVpfCkUCZSkLXheDstKoYV6vwveC" +
       "quIuR0uUr45HC3nUL67q5rjebQa1WMf5drGCjUNxs6q7BsJ1J/RE2Qzs7koc" +
       "jCmERrVmR8MJWirBHZkZmo6ewt4Ya0nJmglI1JkpC7CGjVyE9BnPsWjFJOaW" +
       "5hkRjm+GTpS2pzMGJypowHaRpc6NZyZaaUfrop5E3homNQYEk6RFTO2gNmcY" +
       "0akMMbch0s4c88i2mzrlOeJM7YoLbVjGsbsbtBaR9MaSoT6aauiwocYzvrOO" +
       "69x40sTKaYtpG+0yLA79BlVupBzRFSp9A+JbsRfNmnUYqgyR6qYYmU01lRB9" +
       "MSj65cootAUh5Df0FIY3aa/BxpZPzHgBafUZdUozcXu1Xk3p+WLdBUbSwCG+" +
       "hrOjnmivMTuKK5gwWcEK0uZ012PgothX66uO5qlmzdpUYagz92FtNAFsS5Yj" +
       "WsZ8Y75i+vVZqT0cyqYv1gB59MgdzudtE26USKI8MNREKiktIKB6Sm/iSm0Q" +
       "xBUziSuryUqi1BrJkLYmwe2pQafVhEs9o96YM2Vs0OWWC8NyYXsqKnUQZ/xo" +
       "hlYiAuwkps6cNDh2vKEri/GClcWexofNtImUPU3zxvbMbLcTt7OOakjdWMyF" +
       "2FjNCGSNKQwDjBl3e0g6Tqo270dgLdSHa3DHnM2kSrymStJU8aFJvBYWKD1L" +
       "KrjWHLV72mS2qXdDeS2NG5YvsQ1LHjD9EtVGUrdaTNZiuJ6WZUGpRmCbV2wZ" +
       "ItXuLM10ZZc28UqMy6IqrRo1dJQapSYymLbLSFMp02t41BWNuSChtCU1KyCu" +
       "+HjP7eLTBlGPvbo+bcBgQ5SKpOr75WWj0Qi6nKWmWGdd0hGp0tLmcKkyrfEI" +
       "NoVtqGyoVpuPG0q0WqVWMG/NmlTgb2wUrtppqRiVk7Y9KAY6PIaqK5WYhCOx" +
       "2CmNIB7xIVgl3CUgRe9HxEYhqlxxzbUWw1K3ZNJ8xSM7ljJZgA1Yw9XXbG3c" +
       "0KX5uiuYq8jQpIreUw2Vh612cyDArNPfbGKPmzhL2p5LHJzON8VmcTjWEK7S" +
       "LraqLdeotyiuOQeLuFaa1g0krLUqHjRSsTWnrNJxXaqL86GhMFa31xtXwKKl" +
       "ZTBGIof6Ul4VpaXRZqWiucRZPDBxHws9lEyaNQoK8ICs4W0qKY/Mady0cbfu" +
       "SR2wdGtEXNBbbypgT2MaFbKir4dTXptoM7Cp1UraIuFNA+w+PTMOup7UxCC0" +
       "PnFw29iUR7amBUa4RpftLt2hK6ZjFVFcC3iB1VqLQdqAVbPoNup0wgq4oneD" +
       "tU1TcKdIM70wtFR5CFwkNsb6GseuWdlwOCHGoqm08pbBusTQvc6stZqLLrUO" +
       "K1xVXZOVJdntdhMJXjhog25S04EeQ02vtSDnE0JAuHCKzEyF4evLTZkHLl/r" +
       "0cpsOQH+lOrYjlaUJSWRMHyg8axUcYFjoJeBLiohPUVwcU4qXNwb2rRiyauG" +
       "YvYHFCl3Tb+FU2rcJVKiO52tGNIrErOJ0+lKvSZTJWaRMkKHPcIBG6OQZvW2" +
       "UF8FWA1d+iOwY1BjfkqznOAxzY3Slkv2psyoKNUhiLg815fj+ZBVWkmqcQHR" +
       "9QM1qSj4zEhK4269IwcOWyXj4bBiT4NFEGtNZsmwDWMVyE4wKpt8XY40PRyq" +
       "DTkd4h2m6tDq0FiVFKc/IIgxVWUEOmD1atjBMKi7SRiMTDeGWq1TIUspCYIs" +
       "e0adxZbzLuAjPtzQwtpJcX8RF7UizePpmFWWM2hSac+mKCFIKwUvIQmDeAQ8" +
       "nFsNTB/KVC9udJo9eTFOI9wzRx2OV8TynJn17PVAbdcTUgzIjYxFErUwFwIJ" +
       "N8r9DUkRm8pwMOTEFUSYYo3GHXpVHvpTupwE1fqkWbYZA0aGrQUTl9Goh9V1" +
       "rSs1yytJn6lUSM0Ysg91UEEbIDJDeN3pQvBdwugRqE2UJpukpNUTSS/S7VlP" +
       "aGK2W5WbbSWKxXGt75f8GKdheJJO+zy7WELTgBXHDaM+CkcEoWFOglRVrslJ" +
       "Ykl0QwOe461iL9rokLQuz6GwohHzcFJN+cRTUZZoyomeSG0Utj26MtNULaFx" +
       "1HYJOtp0bB0fxBNx0KjA1Z6haM44WYpiUa9AHRnD+/yaWA7qg+WmOlS7NLxg" +
       "dLJtVq1is1dn2jDiOWuFadR7DYbqlxgP");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "bg/MeYpDHzlXVf7oplWlAa5ndgx85parSv4Jyd4nz1GVT2fFPw0Lt1uKrymn" +
       "wH/iJtTjclb5ckDHPdux27+31if82jlt/zorfgUIFji+Jebsdvqn9o+36bsv" +
       "53O4/+KFk3UeBsBKde/BHTcevOWy/koO+4vnsOTLWfHvwsIdihcJ25dXxwLA" +
       "b71w6HNdAIj3Ht2hf/QF0vSvnYP+97LiP4XZB0fZC0tlkn3rvfe5IwZ89RYy" +
       "IAkL9538GDr7svPB6/57he1/CSD90tOX73r509Pfz78HPvxs/266cJcKYtnx" +
       "r42O3d/h+oqq54y5e/vtkZsD/SZwd2c4TWAKB7cZuXt/sO3938LCpaPeYeGC" +
       "dKL5j8HyftcMzAWUxxu/DapAY3b7HXerg1uP++BxPchfzVx5NldyOOT4l8Cn" +
       "3+n3o+3/XXFN+szT5OBHvlf9he2XyJIppGk2y1104c7tR9H5pNl708duONvB" +
       "XHf0Xvf9+3757lcfvOO9b0vwkU4eo+2Rsz/77VhumH+om/6rl//LH/7E09/M" +
       "v3z4/6G1vXRSRAAA");
}
