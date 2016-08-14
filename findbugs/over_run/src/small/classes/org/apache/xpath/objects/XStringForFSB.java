package org.apache.xpath.objects;
public class XStringForFSB extends org.apache.xpath.objects.XString {
    static final long serialVersionUID = -1533039186550674548L;
    int m_start;
    int m_length;
    protected java.lang.String m_strCache = null;
    protected int m_hash = 0;
    public XStringForFSB(org.apache.xml.utils.FastStringBuffer val, int start,
                         int length) { super(val);
                                       m_start = start;
                                       m_length = length;
                                       if (null == val) throw new java.lang.IllegalArgumentException(
                                                          org.apache.xalan.res.XSLMessages.
                                                            createXPATHMessage(
                                                              org.apache.xpath.res.XPATHErrorResources.
                                                                ER_FASTSTRINGBUFFER_CANNOT_BE_NULL,
                                                              null));
    }
    private XStringForFSB(java.lang.String val) {
        super(
          val);
        throw new java.lang.IllegalArgumentException(
          org.apache.xalan.res.XSLMessages.
            createXPATHMessage(
              org.apache.xpath.res.XPATHErrorResources.
                ER_FSB_CANNOT_TAKE_STRING,
              null));
    }
    public org.apache.xml.utils.FastStringBuffer fsb() {
        return (org.apache.xml.utils.FastStringBuffer)
                 m_obj;
    }
    public void appendToFsb(org.apache.xml.utils.FastStringBuffer fsb) {
        fsb.
          append(
            str(
              ));
    }
    public boolean hasString() { return null !=
                                   m_strCache;
    }
    public java.lang.Object object() { return str(
                                                );
    }
    public java.lang.String str() { if (null ==
                                          m_strCache) {
                                        m_strCache =
                                          fsb(
                                            ).
                                            getString(
                                              m_start,
                                              m_length);
                                    }
                                    return m_strCache;
    }
    public void dispatchCharactersEvents(org.xml.sax.ContentHandler ch)
          throws org.xml.sax.SAXException {
        fsb(
          ).
          sendSAXcharacters(
            ch,
            m_start,
            m_length);
    }
    public void dispatchAsComment(org.xml.sax.ext.LexicalHandler lh)
          throws org.xml.sax.SAXException {
        fsb(
          ).
          sendSAXComment(
            lh,
            m_start,
            m_length);
    }
    public int length() { return m_length;
    }
    public char charAt(int index) { return fsb(
                                             ).
                                      charAt(
                                        m_start +
                                          index);
    }
    public void getChars(int srcBegin, int srcEnd,
                         char[] dst,
                         int dstBegin) { int n =
                                           srcEnd -
                                           srcBegin;
                                         if (n >
                                               m_length)
                                             n =
                                               m_length;
                                         if (n >
                                               dst.
                                                 length -
                                               dstBegin)
                                             n =
                                               dst.
                                                 length -
                                                 dstBegin;
                                         int end =
                                           srcBegin +
                                           m_start +
                                           n;
                                         int d =
                                           dstBegin;
                                         org.apache.xml.utils.FastStringBuffer fsb =
                                           fsb(
                                             );
                                         for (int i =
                                                srcBegin +
                                                m_start;
                                              i <
                                                end;
                                              i++) {
                                             dst[d++] =
                                               fsb.
                                                 charAt(
                                                   i);
                                         }
    }
    public boolean equals(org.apache.xml.utils.XMLString obj2) {
        if (this ==
              obj2) {
            return true;
        }
        int n =
          m_length;
        if (n ==
              obj2.
              length(
                )) {
            org.apache.xml.utils.FastStringBuffer fsb =
              fsb(
                );
            int i =
              m_start;
            int j =
              0;
            while (n-- !=
                     0) {
                if (fsb.
                      charAt(
                        i) !=
                      obj2.
                      charAt(
                        j)) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }
        return false;
    }
    public boolean equals(org.apache.xpath.objects.XObject obj2) {
        if (this ==
              obj2) {
            return true;
        }
        if (obj2.
              getType(
                ) ==
              org.apache.xpath.objects.XObject.
                CLASS_NUMBER)
            return obj2.
              equals(
                this);
        java.lang.String str =
          obj2.
          str(
            );
        int n =
          m_length;
        if (n ==
              str.
              length(
                )) {
            org.apache.xml.utils.FastStringBuffer fsb =
              fsb(
                );
            int i =
              m_start;
            int j =
              0;
            while (n-- !=
                     0) {
                if (fsb.
                      charAt(
                        i) !=
                      str.
                      charAt(
                        j)) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }
        return false;
    }
    public boolean equals(java.lang.String anotherString) {
        int n =
          m_length;
        if (n ==
              anotherString.
              length(
                )) {
            org.apache.xml.utils.FastStringBuffer fsb =
              fsb(
                );
            int i =
              m_start;
            int j =
              0;
            while (n-- !=
                     0) {
                if (fsb.
                      charAt(
                        i) !=
                      anotherString.
                      charAt(
                        j)) {
                    return false;
                }
                i++;
                j++;
            }
            return true;
        }
        return false;
    }
    public boolean equals(java.lang.Object obj2) {
        if (null ==
              obj2)
            return false;
        if (obj2 instanceof org.apache.xpath.objects.XNumber)
            return obj2.
              equals(
                this);
        else
            if (obj2 instanceof org.apache.xpath.objects.XNodeSet)
                return obj2.
                  equals(
                    this);
            else
                if (obj2 instanceof org.apache.xpath.objects.XStringForFSB)
                    return equals(
                             (org.apache.xml.utils.XMLString)
                               obj2);
                else
                    return equals(
                             obj2.
                               toString(
                                 ));
    }
    public boolean equalsIgnoreCase(java.lang.String anotherString) {
        return m_length ==
          anotherString.
          length(
            )
          ? str(
              ).
          equalsIgnoreCase(
            anotherString)
          : false;
    }
    public int compareTo(org.apache.xml.utils.XMLString xstr) {
        int len1 =
          m_length;
        int len2 =
          xstr.
          length(
            );
        int n =
          java.lang.Math.
          min(
            len1,
            len2);
        org.apache.xml.utils.FastStringBuffer fsb =
          fsb(
            );
        int i =
          m_start;
        int j =
          0;
        while (n-- !=
                 0) {
            char c1 =
              fsb.
              charAt(
                i);
            char c2 =
              xstr.
              charAt(
                j);
            if (c1 !=
                  c2) {
                return c1 -
                  c2;
            }
            i++;
            j++;
        }
        return len1 -
          len2;
    }
    public int compareToIgnoreCase(org.apache.xml.utils.XMLString xstr) {
        int len1 =
          m_length;
        int len2 =
          xstr.
          length(
            );
        int n =
          java.lang.Math.
          min(
            len1,
            len2);
        org.apache.xml.utils.FastStringBuffer fsb =
          fsb(
            );
        int i =
          m_start;
        int j =
          0;
        while (n-- !=
                 0) {
            char c1 =
              java.lang.Character.
              toLowerCase(
                fsb.
                  charAt(
                    i));
            char c2 =
              java.lang.Character.
              toLowerCase(
                xstr.
                  charAt(
                    j));
            if (c1 !=
                  c2) {
                return c1 -
                  c2;
            }
            i++;
            j++;
        }
        return len1 -
          len2;
    }
    public int hashCode() { return super.
                              hashCode(
                                ); }
    public boolean startsWith(org.apache.xml.utils.XMLString prefix,
                              int toffset) {
        org.apache.xml.utils.FastStringBuffer fsb =
          fsb(
            );
        int to =
          m_start +
          toffset;
        int tlim =
          m_start +
          m_length;
        int po =
          0;
        int pc =
          prefix.
          length(
            );
        if (toffset <
              0 ||
              toffset >
              m_length -
              pc) {
            return false;
        }
        while (--pc >=
                 0) {
            if (fsb.
                  charAt(
                    to) !=
                  prefix.
                  charAt(
                    po)) {
                return false;
            }
            to++;
            po++;
        }
        return true;
    }
    public boolean startsWith(org.apache.xml.utils.XMLString prefix) {
        return startsWith(
                 prefix,
                 0);
    }
    public int indexOf(int ch) { return indexOf(
                                          ch,
                                          0);
    }
    public int indexOf(int ch, int fromIndex) {
        int max =
          m_start +
          m_length;
        org.apache.xml.utils.FastStringBuffer fsb =
          fsb(
            );
        if (fromIndex <
              0) {
            fromIndex =
              0;
        }
        else
            if (fromIndex >=
                  m_length) {
                return -1;
            }
        for (int i =
               m_start +
               fromIndex;
             i <
               max;
             i++) {
            if (fsb.
                  charAt(
                    i) ==
                  ch) {
                return i -
                  m_start;
            }
        }
        return -1;
    }
    public org.apache.xml.utils.XMLString substring(int beginIndex) {
        int len =
          m_length -
          beginIndex;
        if (len <=
              0)
            return org.apache.xpath.objects.XString.
                     EMPTYSTRING;
        else {
            int start =
              m_start +
              beginIndex;
            return new org.apache.xpath.objects.XStringForFSB(
              fsb(
                ),
              start,
              len);
        }
    }
    public org.apache.xml.utils.XMLString substring(int beginIndex,
                                                    int endIndex) {
        int len =
          endIndex -
          beginIndex;
        if (len >
              m_length)
            len =
              m_length;
        if (len <=
              0)
            return org.apache.xpath.objects.XString.
                     EMPTYSTRING;
        else {
            int start =
              m_start +
              beginIndex;
            return new org.apache.xpath.objects.XStringForFSB(
              fsb(
                ),
              start,
              len);
        }
    }
    public org.apache.xml.utils.XMLString concat(java.lang.String str) {
        return new org.apache.xpath.objects.XString(
          str(
            ).
            concat(
              str));
    }
    public org.apache.xml.utils.XMLString trim() {
        return fixWhiteSpace(
                 true,
                 true,
                 false);
    }
    private static boolean isSpace(char ch) {
        return org.apache.xml.utils.XMLCharacterRecognizer.
          isWhiteSpace(
            ch);
    }
    public org.apache.xml.utils.XMLString fixWhiteSpace(boolean trimHead,
                                                        boolean trimTail,
                                                        boolean doublePunctuationSpaces) {
        int end =
          m_length +
          m_start;
        char[] buf =
          new char[m_length];
        org.apache.xml.utils.FastStringBuffer fsb =
          fsb(
            );
        boolean edit =
          false;
        int d =
          0;
        boolean pres =
          false;
        for (int s =
               m_start;
             s <
               end;
             s++) {
            char c =
              fsb.
              charAt(
                s);
            if (isSpace(
                  c)) {
                if (!pres) {
                    if (' ' !=
                          c) {
                        edit =
                          true;
                    }
                    buf[d++] =
                      ' ';
                    if (doublePunctuationSpaces &&
                          d !=
                          0) {
                        char prevChar =
                          buf[d -
                                1];
                        if (!(prevChar ==
                                '.' ||
                                prevChar ==
                                '!' ||
                                prevChar ==
                                '?')) {
                            pres =
                              true;
                        }
                    }
                    else {
                        pres =
                          true;
                    }
                }
                else {
                    edit =
                      true;
                    pres =
                      true;
                }
            }
            else {
                buf[d++] =
                  c;
                pres =
                  false;
            }
        }
        if (trimTail &&
              1 <=
              d &&
              ' ' ==
              buf[d -
                    1]) {
            edit =
              true;
            d--;
        }
        int start =
          0;
        if (trimHead &&
              0 <
              d &&
              ' ' ==
              buf[0]) {
            edit =
              true;
            start++;
        }
        org.apache.xml.utils.XMLStringFactory xsf =
          org.apache.xpath.objects.XMLStringFactoryImpl.
          getFactory(
            );
        return edit
          ? xsf.
          newstr(
            buf,
            start,
            d -
              start)
          : this;
    }
    public double toDouble() { if (m_length ==
                                     0) return java.lang.Double.
                                                 NaN;
                               int i;
                               char c;
                               java.lang.String valueString =
                                 fsb(
                                   ).
                                 getString(
                                   m_start,
                                   m_length);
                               for (i = 0;
                                    i <
                                      m_length;
                                    i++) if (!org.apache.xml.utils.XMLCharacterRecognizer.
                                               isWhiteSpace(
                                                 valueString.
                                                   charAt(
                                                     i)))
                                             break;
                               if (i == m_length)
                                   return java.lang.Double.
                                            NaN;
                               if (valueString.
                                     charAt(
                                       i) ==
                                     '-')
                                   i++;
                               for (; i <
                                        m_length;
                                    i++) {
                                   c =
                                     valueString.
                                       charAt(
                                         i);
                                   if (c !=
                                         '.' &&
                                         (c <
                                            '0' ||
                                            c >
                                            '9'))
                                       break;
                               }
                               for (; i <
                                        m_length;
                                    i++) if (!org.apache.xml.utils.XMLCharacterRecognizer.
                                               isWhiteSpace(
                                                 valueString.
                                                   charAt(
                                                     i)))
                                             break;
                               if (i != m_length)
                                   return java.lang.Double.
                                            NaN;
                               try { return new java.lang.Double(
                                       valueString).
                                       doubleValue(
                                         );
                               }
                               catch (java.lang.NumberFormatException nfe) {
                                   return java.lang.Double.
                                            NaN;
                               } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1bC3QcVRm+u3mnTZO0Ni1tE0qT1tMHuwJixVQh3SY0ZdPG" +
       "pJSaKtvZ2ZtkyuzMdOZuui2WlyI9UBFtUVCoRy0+agV81DdYDiBwFJGKWuBo" +
       "AVFU4Jz2+ChaFP//3tmd2dmdCWtXc87cncy9/73/99//de/cOfgqqbFMssCQ" +
       "tJQUYdsNakUG8X5QMi2aiqmSZa2Hpwn5xuf3XH3yFw3XhkntCJk2LlkDsmTR" +
       "PoWqKWuEtCuaxSRNptZaSlNIMWhSi5oTElN0bYTMVKz+tKEqssIG9BTFBhsk" +
       "M05aJcZMJZlhtN/ugJEz45ybKOcm2uNt0B0nU2Xd2O4QzCkgiLnqsG3aGc9i" +
       "pCW+RZqQohmmqNG4YrHurEmWGrq6fUzVWYRmWWSLer4tiDXx84vEsODe5r+f" +
       "umW8hYthhqRpOuMQrSFq6eoETcVJs/O0V6Vpayu5ilTFyRRXY0a64rlBozBo" +
       "FAbN4XVaAfdNVMukYzqHw3I91RoyMsTIWYWdGJIppe1uBjnP0EM9s7FzYkA7" +
       "P482N90eiLcuje791OUt36gizSOkWdGGkR0ZmGAwyAgIlKaT1LR6UimaGiGt" +
       "Gkz4MDUVSVV22LM93VLGNIllQAVyYsGHGYOafExHVjCTgM3MyEw38/BGuVLZ" +
       "/9WMqtIYYG1zsAqEffgcADYqwJg5KoHu2STVVyhaiutRIUUeY9cl0ABI69KU" +
       "jev5oao1CR6Q6UJFVEkbiw6D8mlj0LRGBxU0ua75dIqyNiT5CmmMJhiZ7W03" +
       "KKqgVQMXBJIwMtPbjPcEszTHM0uu+Xl17Yqbr9RWa2ESAp5TVFaR/ylA1OEh" +
       "GqKj1KRgB4Jw6pL4J6W2+3aFCYHGMz2NRZvvfPDERcs6Dj8q2swt0WZdcguV" +
       "WULen5z25LzY4guqkI16Q7cUnPwC5NzKBu2a7qwBnqYt3yNWRnKVh4d+/L5r" +
       "DtCXw6Sxn9TKuppJgx61ynraUFRqXkw1akqMpvpJA9VSMV7fT+rgPq5oVDxd" +
       "NzpqUdZPqlX+qFbn/4OIRqELFFEj3CvaqJ67NyQ2zu+zBiGkDi4yFa6ziPjj" +
       "v4yMRcf1NI1KsqQpmh4dNHXEjxPKfQ614D4FtYYezUqgNGdvSZybWJ44N2qZ" +
       "clQ3x6ISaMU4jWZxuKieFNQbhWb16Wbf8MoIKpzx/xsqi6hnbAuFYELmed2B" +
       "Cpa0WldT1EzIezMre0/cnfiJUDU0D1tejCyC8SJivAgfL2KPFykYj4RCfJi3" +
       "4LhizmHGrgDbB+c7dfHwB9Zs3rWgCpTN2FYN4g5D00VFwSjmOImcZ0/IB58c" +
       "OvnE440HwiQMfiQJwciJCF0FEUEENFOXaQpckl9syPnHqH80KMkHOXzbtms3" +
       "XP02zofbyWOHNeCfkHwQXXN+iC6vcZfqt/mGP/79nk/u1B0zL4gauWBXRIne" +
       "Y4F3Ur3gE/KS+dKhxH07u8KkGlwSuGEmgdmAh+vwjlHgRbpzHhmx1APgUd1M" +
       "SypW5dxoIxs39W3OE65trfz+LTDFDWhWbXC907Yz/ou1bQaWs4R2os54UHCP" +
       "/+5h486jP/vTeVzcueDQ7Irqw5R1uxwSdjadu55WRwXXm5RCu9/cNrjn1ldv" +
       "2MT1D1p0lhqwC8sYOCKYQhDz9Y9uffrYb/c/Fc7rbIhBRM4kIbnJ5kGGEVN9" +
       "AEjUc4cfcGgq2A5qTdelGmilMqpISZWikbzevPCcQ6/c3CL0QIUnOTVaNnkH" +
       "zvMzVpJrfnL5yQ7eTUjGgOrIzGkmvPQMp+ce05S2Ix/Za4+03/6IdCf4e/Cx" +
       "lrKDcrdZxWVQxZHPZmSh2y2kVd4HCFKymPAKKzOjoE0W2oDLyjEnHM4kLTZo" +
       "KmmYtgk7Yt3TdnLrQ3U7VuWiUSkS0fISa+CJ769+KcHVoh69AT5Hpppcdt5j" +
       "jrl0skVM1xvwF4Lr33jhNOED4funx+wAND8fgQwjC9wvDkgZCyFEd04/dsUd" +
       "f/yagOCN0J7GdNfeG9+I3LxXzLVIYzqLMgk3jUhlBBws3oXcnRU0Cqfoe+me" +
       "nT/48s4bBFfTC4NyL+ScX/vVv34aue25x0p4/irFTkXPQ+UXJsAju2d2BKTa" +
       "c+78x9UfOboO/Ew/qc9oytYM7U+5+4Q8zMokXdPlJEj8gRscTg0joSUwC/jg" +
       "Al6+nXMTzfNEOE+E1/Vj0WW5fW7hjLny7YR8y1PHmzYcv/8ER12YsLtdzIBk" +
       "CJG3YrEQRT7LG99WS9Y4tHv74bXvb1EPn4IeR6BHGbJUa50JwTVb4JDs1jV1" +
       "zzzwYNvmJ6tIuI80qrqU6pO4bycN4FSpNQ5xOWtceJHwKdvQwbRwqKQIPJrx" +
       "maUdRG/aYNykd3x31rdWfGnfb7kv4z205z1YI/YyC641tgdbU9pNY7mIl4ux" +
       "WJZziXWGqcDqj3p8YkNAj55pzKmW7VlaOBjMyiPClXAGRgLm/nIshnnVGizW" +
       "C14G3pz88MGQoJjLn+FCeX5RbsJXwE5YfeXZz/zuRye/UCcMK8BNeOhm/3Od" +
       "mrzuhdeKNI9nESU8h4d+JHrwjjmx97zM6Z1wjtSd2eIsDxIeh/bcA+m/hRfU" +
       "PhwmdSOkRbZXmxskNYNBcgRWWFZuCQor0oL6wtWSWBp059OVeV7X5RrWm0i4" +
       "/UE1K7B9J3doxam5EK5OW4U6vUrJk81pjqrEdVi+3fTiLT/9WOcxkM0aUjOB" +
       "fINIXPq0NoMr2o8cvLV9yt7nbuLW8Ofv7T5lvvjV3dirUlrJwxD3Lb42ZgBF" +
       "0STV0XWuQy0BjII+W3zRvAGiIczzpf2rOPFy24njzwrX/UUMYj9g8VoH/tvn" +
       "MkWu6FsmU3S50CinwbXIZnRRkUQJv7mytBCIx77DAV2BU0gnQGImz2Au8DD9" +
       "wTKZboZrsT3SYh+mPySYxuKqYj79qBmpTydUqo2J5aGX0Q+/eUZxOUkWwrXM" +
       "HmqZD6M3+vrRBsPUGVgVTXkkPSWgW0YaUdJmDPMwfLLJg+GmMjHMhStqDxb1" +
       "wbDHEfZHi1n1owYjSifGIfyVEvXeADazznBL8sPxv1riWcR7Y8zcnOqapN1v" +
       "n4WnSfuv27svte6uc8J2ROmB+WC6cbZKJ6jq6qqdJ13e0DDAd5ccP7v8yMmq" +
       "Zz8xe2rxihV76vBZjy7xjyHeAR657s9z1r9nfHMZS9EzPfi9XX5l4OBjFy+S" +
       "PxHmG2TCrRdtrBUSdRc680aTsoypFaZzC/IzNgdnoh2ujfaMbfSqlyvPKJzs" +
       "/CLLjzQgNzgQUHcQi7sg0R21knh7vqOQXyw/heCPP1e4/F0FV9JmOlk+Xj/S" +
       "0gkUh8B7/XYA6O9i8XUGamMYVEut1/usZMkoNKErKUcg3zhtgfCYjlqQtlGl" +
       "yxeIH2kA3ocD6h7B4jDYOvglkWtOFpvrkrquUkkrHZ4dcT1w2uLijXH75Cob" +
       "81Xli8uPNEAkvwqoO4rFk+DI7R1A/LcwYV/nVHAxHKmMGGbAtcvGsqt8MfiR" +
       "BkB9MaDuD1gcA7cBgRdvNzl4n6uM2+iF65DN9KHy8fqRBq+75uCODm7lWFI2" +
       "wt8CaWw1hDcV1rDY5Hgw+Ww3+XDPxt6sTA0MSpz4r1i8DK1SimVITB6PjUN4" +
       "gmzHtHonqL3P8H1HkK9URpAr4XrIlsZD5QvSjzRYEh1uSWAsj9OsIkuqS5gh" +
       "4u/C/8YbVOPtKUZacwLrgbVZOg2i8kjq9dOWVFPOxH5uw/15+ZLyI/U3o9C0" +
       "gDrcBQo1gKdxZed5yKHG04aMCyF+84LN9wvlQ/Yj9Z9ZvosVmhOAex4WMwG3" +
       "DObRwyaLRtXYbJJQFGqrjCnhJs7rNuTXy5eWH6lHGNWcD678F4hZN8lC/8SY" +
       "b1qL/cd9X+z82dX7Op/nG3D1igWpdY85VuINq4vm+MFjLx9par+bvxupxkQd" +
       "x2zyvpoufvNc8EKZo28ulBbYVOiAQCx+GbmsUi/90mo0xdLRVesHcu8T/1dd" +
       "c53sKOnnZKyK2kvC0Hli7nnp3jnB27Ox2MqF9K4Ci74QKSNGNt9/2H41aPvR" +
       "GU5eEVN1jeJ7jlydeM2o6JH8iQSozJbk9HOCUz6YS0U5PwGmeFFA3Uos3s1I" +
       "jYx8CRgBzXvtPUbiOIGlAc0vxmIRI/VjlMVyBu54/NBbK5OKzwIB2avnkHf1" +
       "PLlB+5K+idhY9Npo40Dc2eoNvTdANpdiEQc1olszkliZP+ZIZqBykrnEhndJ" +
       "+ZLxIw2WzHz/9+wiq+b4EwGy4SY54iebTZWTTdYGmC1fNn6k/kFzE8eWDsCN" +
       "5zxC4364lcrh/rzN/OfLx+1H6o/7GY5tewDuK7FgfrgzlcEN5h162Gb+4fJx" +
       "+5FONt/XB+C+AYtrYN0pcPePabpJY3bwdkng2spkxrAGDx21YRwtXwJ+pL4S" +
       "CA1xlB8PkMAeLHYzfP+DxxXoen7UyZUhf7Qy0OcDjlrRg/gtC7ov6WTQ7wyA" +
       "/lksboPkIA+9cP5dQri9MkKYCQgiNpJI+ULwIw3A+JWAuq9isR+SA9xKj+kp" +
       "L+i7KmP2c4HjzTbnm8sH7UfqARbOZ4mhIY6DQzwUAP87WNzLSCN/vWRdpohU" +
       "0mX1X6+cAHbbKHaXLwA/0slU/4EA7A9i8cMg7PdVRuPhJmwHrHD5sc6X1N/n" +
       "i3l/PAD7E1g8ykidoqVodt2oR+sfqxzwB23uHywfuB+pr9bba1yO8OkA9M9i" +
       "8ZQv+l+eNnrc/SHzgKnjNoTj5aP3I51s2n8fAPwlLJ5jeFIoafEVAjcVB/rz" +
       "FYNe1Sx6EL9lQfclfVMTfyIA/1+weCUA/6uVwX8GML/UBrG0fPx+pJNlef8K" +
       "gP4GFq/hVpiuyRLz4P5HZXBDVl+13GZ+efm4/Uj9YYUbAuqmYFHNSDXMdLoQ" +
       "cLjmtAGfgVXzgduYzXUsADAvvTs5l2FheI4ntAT06B/tOjjgtgBhzMaiBX2e" +
       "NQyrYk9yH26tjAKgPDbY3G8oXwH8SD247LOzHIJTcJgLAkTQhUU7I02jSvay" +
       "cYXRnCDcitFRmVdss4G/b9povlm+IPxIA9BFAurehsViyHKZvkrP5Pb9AnbC" +
       "a1NOM/+98PCS/+JkIMi/4EsHPHA5u+jbKvE9kHz3vub6Wfsu/bXYUc59szM1" +
       "TupHM6rqPvrmuq81TApTzFuKg3D81Gt4hf1WrdSuEBiGfYd8h7sFxYWwKvZS" +
       "MFLDf93tVkIW6bQD8Ykbd5NeRqqgCd72ic3N4E0qewNP7GflD97kJE9mTiZ5" +
       "11mdzoINf/61W+7USkZ875aQ79m3Zu2VJ95xl/g8QFalHTuwlylxUie+VOCd" +
       "4smXs3x7y/VVu3rxqWn3NizMnf5pFQw7Wj/XUU0yBGploA7M8Zydt7ryR+if" +
       "3r/i/sd31R4Jk9AmEpJgtbqp+PRk1siY5MxN8VLHqTdIJj/W3934u81PvPZM" +
       "aDo/q0jEAeyOIIqEvOf+ZwdHDePTYdLQT2p4xsiPdq7arg1RecIsOJ1dm9Qz" +
       "Wv5FxzRUWAnnkUvGFmhT/il+XsLIguKD6sWf3DSq+jZqrsTesZsmz1mhjGG4" +
       "a7lke4VJo6RB9xLxAcOwT+iHnueSNww0yfD7uFX/B3gPsHrSOgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "h9PFkjFeixtpNh3ZZEPSw9bI4uUgQNvw");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
