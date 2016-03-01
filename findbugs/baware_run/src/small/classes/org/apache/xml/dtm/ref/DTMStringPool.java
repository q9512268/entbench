package org.apache.xml.dtm.ref;
public class DTMStringPool {
    java.util.Vector m_intToString;
    static final int HASHPRIME = 101;
    int[] m_hashStart = new int[HASHPRIME];
    org.apache.xml.utils.IntVector m_hashChain;
    public static final int NULL = -1;
    public DTMStringPool(int chainSize) { super();
                                          m_intToString = new java.util.Vector(
                                                            );
                                          m_hashChain = new org.apache.xml.utils.IntVector(
                                                          chainSize);
                                          removeAllElements();
                                          stringToIndex(""); }
    public DTMStringPool() { this(512); }
    public void removeAllElements() { m_intToString.removeAllElements(
                                                      );
                                      for (int i = 0; i < HASHPRIME;
                                           ++i) m_hashStart[i] = NULL;
                                      m_hashChain.removeAllElements(
                                                    ); }
    public java.lang.String indexToString(int i) throws java.lang.ArrayIndexOutOfBoundsException {
        if (i ==
              NULL)
            return null;
        return (java.lang.String)
                 m_intToString.
                 elementAt(
                   i);
    }
    public int stringToIndex(java.lang.String s) { if (s ==
                                                         null)
                                                       return NULL;
                                                   int hashslot =
                                                     s.
                                                     hashCode(
                                                       ) %
                                                     HASHPRIME;
                                                   if (hashslot <
                                                         0)
                                                       hashslot =
                                                         -hashslot;
                                                   int hashlast =
                                                     m_hashStart[hashslot];
                                                   int hashcandidate =
                                                     hashlast;
                                                   while (hashcandidate !=
                                                            NULL) {
                                                       if (m_intToString.
                                                             elementAt(
                                                               hashcandidate).
                                                             equals(
                                                               s))
                                                           return hashcandidate;
                                                       hashlast =
                                                         hashcandidate;
                                                       hashcandidate =
                                                         m_hashChain.
                                                           elementAt(
                                                             hashcandidate);
                                                   }
                                                   int newIndex =
                                                     m_intToString.
                                                     size(
                                                       );
                                                   m_intToString.
                                                     addElement(
                                                       s);
                                                   m_hashChain.
                                                     addElement(
                                                       NULL);
                                                   if (hashlast ==
                                                         NULL)
                                                       m_hashStart[hashslot] =
                                                         newIndex;
                                                   else
                                                       m_hashChain.
                                                         setElementAt(
                                                           newIndex,
                                                           hashlast);
                                                   return newIndex;
    }
    public static void main(java.lang.String[] args) { java.lang.String[] word =
                                                         { "Zero",
                                                       "One",
                                                       "Two",
                                                       "Three",
                                                       "Four",
                                                       "Five",
                                                       "Six",
                                                       "Seven",
                                                       "Eight",
                                                       "Nine",
                                                       "Ten",
                                                       "Eleven",
                                                       "Twelve",
                                                       "Thirteen",
                                                       "Fourteen",
                                                       "Fifteen",
                                                       "Sixteen",
                                                       "Seventeen",
                                                       "Eighteen",
                                                       "Nineteen",
                                                       "Twenty",
                                                       "Twenty-One",
                                                       "Twenty-Two",
                                                       "Twenty-Three",
                                                       "Twenty-Four",
                                                       "Twenty-Five",
                                                       "Twenty-Six",
                                                       "Twenty-Seven",
                                                       "Twenty-Eight",
                                                       "Twenty-Nine",
                                                       "Thirty",
                                                       "Thirty-One",
                                                       "Thirty-Two",
                                                       "Thirty-Three",
                                                       "Thirty-Four",
                                                       "Thirty-Five",
                                                       "Thirty-Six",
                                                       "Thirty-Seven",
                                                       "Thirty-Eight",
                                                       "Thirty-Nine" };
                                                       org.apache.xml.dtm.ref.DTMStringPool pool =
                                                         new org.apache.xml.dtm.ref.DTMStringPool(
                                                         );
                                                       java.lang.System.
                                                         out.
                                                         println(
                                                           "If no complaints are printed below, we passed initial test.");
                                                       for (int pass =
                                                              0;
                                                            pass <=
                                                              1;
                                                            ++pass) {
                                                           int i;
                                                           for (i =
                                                                  0;
                                                                i <
                                                                  word.
                                                                    length;
                                                                ++i) {
                                                               int j =
                                                                 pool.
                                                                 stringToIndex(
                                                                   word[i]);
                                                               if (j !=
                                                                     i)
                                                                   java.lang.System.
                                                                     out.
                                                                     println(
                                                                       "\tMismatch populating pool: assigned " +
                                                                       j +
                                                                       " for create " +
                                                                       i);
                                                           }
                                                           for (i =
                                                                  0;
                                                                i <
                                                                  word.
                                                                    length;
                                                                ++i) {
                                                               int j =
                                                                 pool.
                                                                 stringToIndex(
                                                                   word[i]);
                                                               if (j !=
                                                                     i)
                                                                   java.lang.System.
                                                                     out.
                                                                     println(
                                                                       "\tMismatch in stringToIndex: returned " +
                                                                       j +
                                                                       " for lookup " +
                                                                       i);
                                                           }
                                                           for (i =
                                                                  0;
                                                                i <
                                                                  word.
                                                                    length;
                                                                ++i) {
                                                               java.lang.String w =
                                                                 pool.
                                                                 indexToString(
                                                                   i);
                                                               if (!word[i].
                                                                     equals(
                                                                       w))
                                                                   java.lang.System.
                                                                     out.
                                                                     println(
                                                                       "\tMismatch in indexToString: returned" +
                                                                       w +
                                                                       " for lookup " +
                                                                       i);
                                                           }
                                                           pool.
                                                             removeAllElements(
                                                               );
                                                           java.lang.System.
                                                             out.
                                                             println(
                                                               "\nPass " +
                                                               pass +
                                                               " complete\n");
                                                       }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC5AUxRnu3XsfHPdADgQ54DhUEHfjC9TjIR6PO93j1jsg" +
       "5oguc7O9dwOzM8NM77GcIYhVCmXUqKAhRqjE4IsgWEmM0ZSGVBIfRZSCGOMr" +
       "ilqJD7RKUqWn0cT8f/fszmMfgtFc1fTNdf/9d/+v7/+75/a8T8oskzQbkhaX" +
       "Qmy9Qa1QFN+jkmnReJsqWdYy6I3J17++dePwn6s2BUl5Lxk1IFmdsmTRxQpV" +
       "41YvmahoFpM0mVpLKY3jjKhJLWoOSkzRtV4yRrE6koaqyArr1OMUCVZIZoTU" +
       "S4yZSl+K0Q6bASOTInw3Yb6b8AI/QWuEjJR1Y70zYbxnQptrDGmTznoWI3WR" +
       "1dKgFE4xRQ1HFIu1pk1yhqGr6/tVnYVomoVWq+fZirgkcl6OGpofrP3o05sH" +
       "6rgaRkuapjMuotVNLV0dpPEIqXV6F6k0aa0l3yUlETLCRcxISySzaBgWDcOi" +
       "GXkdKth9DdVSyTadi8MynMoNGTfEyBQvE0MypaTNJsr3DBwqmS07nwzSTs5K" +
       "mzG3T8Tbzghv+8GVdT8vIbW9pFbRenA7MmyCwSK9oFCa7KOmtSAep/FeUq+B" +
       "wXuoqUiqMmRbu8FS+jWJpcAFMmrBzpRBTb6moyuwJMhmpmSmm1nxEtyp7L/K" +
       "EqrUD7I2OrIKCRdjPwhYrcDGzIQEvmdPKV2jaHHuR94ZWRlbLgUCmFqRpGxA" +
       "zy5VqknQQRqEi6iS1h/uAefT+oG0TAcXNLmvFWCKujYkeY3UT2OMjPPTRcUQ" +
       "UFVxReAURsb4yTgnsNJ4n5Vc9nl/6ZybrtLatSAJwJ7jVFZx/yNgUpNvUjdN" +
       "UJNCHIiJI2dEbpcaH9sSJASIx/iIBc3D3zl20cym/U8Jmgl5aLr6VlOZxeRd" +
       "faMOndI2/YIS3EaloVsKGt8jOY+yqD3SmjYAaRqzHHEwlBnc3/3Et67eTY8G" +
       "SXUHKZd1NZUEP6qX9aShqNRcQjVqSozGO0gV1eJtfLyDVMB7RNGo6O1KJCzK" +
       "OkipyrvKdf43qCgBLFBF1fCuaAk9825IbIC/pw1CSAU8ZCQ8FxDxw38zQsMD" +
       "epKGJVnSFE0PR00d5UeDcsyhFrzHYdTQw2kJnObM1bGzY7NjZ4ctUw7rZn9Y" +
       "Aq8YoOF0Ug3HWTJs0kR44bJO4VlRXVdD6G7G/2uhNEo8el0gAMY4xQ8FKkRR" +
       "u67GqRmTt6UuXnRsb+yAcDMMDVtXAF6wWkisFoLVQrBaCFYLeVYjgQBf5CRc" +
       "VVgbbLUGoh5gd+T0nisuWbWluQTczFhXCooOAumpOWmozYGHDKbH5D2HuocP" +
       "PlO9O0iCgCB9kIacXNDiyQUilZm6TOMARoWyQgYZw4XzQN59kP3b121asfEb" +
       "fB9ueEeGZYBMOD2KoJxdosUf1vn41m5++6N9t2/QnQD35ItMmsuZibjR7Dep" +
       "X/iYPGOy9FDssQ0tQVIKYAQAzCQIGMC2Jv8aHvxozWAxylIJAid0MympOJQB" +
       "0Go2YOrrnB7ua/X8/SQwcRUGVCM8i+0I479xtNHAdqzwTfQZnxQc6+f2GDte" +
       "ePadc7i6M2mh1pXPeyhrdUERMmvgoFPvuOAyk1Kg+9v26Nbb3t+8kvsfUEzN" +
       "t2ALtm0AQWBCUPO1T6198bVXdz0XzPpsgEEuTvVBWZPOChlEmSqLCIl+7uwH" +
       "oEyFKEevaVmugVcqCUXqUykGyWe108566L2b6oQfqNCTcaOZX8zA6T/5YnL1" +
       "gSuHmzibgIyp1NGZQybwebTDeYFpSutxH+lNhyf+8ElpByA9oKulDFEOmAGh" +
       "Awu92hW3WN/1pPosFjWVJBhi0M4++xqH1/6hYmhhJrPkmyIoL7U6Dz7a/laM" +
       "G7oS4xv7UfYaV+QuMPtdXlYnDPA5/ATg+Q8+qHjsEDje0GYnk8nZbGIYadj9" +
       "9CLln1eE8IaG19bc+fYDQgR/tvUR0y3brv88dNM2YT1RkkzNqQrcc0RZIsTB" +
       "5nzc3ZRiq/AZi9/at+E3923YLHbV4E2wi6B+fOD5f/8ptP3I03mQvESxy8pz" +
       "PAZt9FtHiFR+1o5PNl73QhcgRwepTGnK2hTtiLt5Qk1lpfpc5nKKHd7hFg5N" +
       "w0hgBliBd5/LNxLObofw7RA+tgSbFssNoF5jucrmmHzzcx/UrPjg8WNcYG/d" +
       "7caLTskQ2q7HZhpqe6w/WbVL1gDQnbt/6bfr1P2fAsde4ChDsWl1mZAn0x50" +
       "sanLKl763e8bVx0qIcHFpFrVpfhiiQM1qQKEpNYApNi0Mf8iARDrEC3quKgk" +
       "R3iMyUn5o31R0mA8Pod+PfaXc+7d+SoHJs5hYi7mRm04iubHXGxPxWZGLpIV" +
       "mlrEXiuKjF2OzWV8qB2bbgGelx6fPrAjKmZM4H14fp2cUzjwg6mT8957+Udv" +
       "/nb4pxUiRopEvG/euH91qX3XvPFxjifxFJ8HBHzze8N77hzfNu8on+/kWpw9" +
       "NZ1bgEE14sw9e3fyw2Bz+R+DpKKX1Mn2IXCFpKYwg/XCwcfKnAzhoOgZ9x5i" +
       "RMXemq0lTvGjkGtZf5Z3h3Yp84RxvddTxsLTantKq9/JAoS/yMLPeDsdm5m2" +
       "Wb2sgkVYMVKTjAFqLdNFqYnxkTeXdEvr+KEpJt/QfO2m0yqOzRLGn5yX2nW+" +
       "Omd4Vu3k3fdpgjx/bvOdrN646sBd+itHg0HbxWflBlFB1Vi+ZMjd19n8Q4/e" +
       "M3vLzMvvEruZUsBzHfpHLjtyaMfQvj0C7DF5MnJGocuG3BsOrCGnFamDHTV9" +
       "uOTC/e+8ueKKjMyjsEkKS45jpM4BrRUUwQ/7LX+uwT8XuiCIA0L8iwDhiqx6" +
       "a7F3CjxzbPXOyfG8QLYAxGAIdWiM9lOz4Y0f7xretPn8INY0ZYMYNCB5nUO3" +
       "NIW3HNftuW3iiG1HvsehFThz90/n9+IgVIMWvythEEOKJqk+tx5VZJ+MVLUv" +
       "6GmPdnd0LsKO2T6drD9+nfC1ToNnrr3W3ALReK2D+oncACw0m5ERydgAJLoe" +
       "JpnMD77ZCOHVo/CUR0a/84unV1W8mPGUNdnFWuytBn4m1hK/GfnmV3wUhoNp" +
       "5pT9dbHGOC4SOC517Lxn6rMbd059ndcSlYoF6Au1bJ47H9ecD/a8dvRwzcS9" +
       "/MzGo9qur7yXZbl3YZ4rLq79Wmxu4K+zc0o/7kmCwHaSrQWcHV/PxOZqzup8" +
       "cH6Vav3iRmUuNrcY6Sz/oH3Gt8FhtBNnbaquUTywZMbEfYGih7KXijCYztkp" +
       "YqEfNTu5rE4GnX14uOTlW8eNzL0oQG5NBa4BZhS2on+BJ695d/yyeQOrTuAG" +
       "YJLPyH6W93fueXrJqfKtQX4jKRJ2zk2md1KrN01Xm5SlTM1bczc7Vr/FVexx" +
       "0xWp1XYVGbsHm58A1sloQmHxIuT326Ub8Zsybw647gTxbhw882zEmlcA7x4o" +
       "ineFZmfxrm0AareMlzb5rsAw0VmYXJxk55Jm7/FLg7U6aYZnvr2f+XkyGr4M" +
       "4fkJX36VP0JLshG6UYSpV+QxRZZgpHTp8kgkXx56uIgk6XynCP5TTnzXqq7F" +
       "XKU8QRCdWOjmmx92d12zbWe86+6zMrlkPiROphtnqnSQqi5Wpfx9h/cchIXC" +
       "cnsby/1qdQQtdA4qNLWI0x8oMvYMNk8wUm/SpD5IF6gqfi6icCDn5Bfy2BQ6" +
       "nQcWGdSVuGOHJ0/80OTTCCeeCI9kiyWduEYKTfVJ7Qr02ZzrS/kJMsF1upMe" +
       "eA7s0OI03ZViXYmL9ZQWtxalZWogznJmr2DzFzgXKEiWPRfYvFwlnWuA6/D5" +
       "/1mHNTg0Hh7FVoRy4josNLWwDo9wru8Wca33sPk7qMTiIi/TuQa5/h3x//HV" +
       "uNDp8Nxoy3BjEfELVxAbfdBUW4RjEce5PsvlZJw0CZ6HbS78NyOXf8W134K0" +
       "YmXqyq+Nt1DO97H5JF3cq/NWcp/Y6S9AjrOSw+Z2bHgV91luFYd/bsfmjtyy" +
       "jDuIWJbPxuauwp4aqCgyVoVNGY7cK3ZShHZE8eqCb2a4yHx+ej0GMJuEJI/v" +
       "B51A+eeXuKCC2PN8DcN7vHE5X97F12J5787ayrE7l/9VVPeZL7ojI6QykVJV" +
       "9w2M673cMGlC4YKNFPcxBpdkDCON+b/PMVICLe44cJKgBU9qyKUFOmjddBMY" +
       "GeWlAxpo3TRNjFQ7NHAcEC9ukikwC0jwtdnI48rioiod8JYEWTuM+SI7uKqI" +
       "qZ4inv9nRKbgTkXtq5J9Oy9ZetWxWXeLD0qyKg0NIZcRcGoS37ayRfuUgtwy" +
       "vMrbp3866sGqaZm6pF5s2MG/CS54joJfGugR431fW6yW7EeXF3fNefyZLeWH" +
       "4ZS4kgQkODOtzL3SSxspOFGsjOS7rocjDf8Q1Fr95qqDH78UaMjcYeDZqanY" +
       "jJi89fGXownDuCNIqjpIGc+r/L5x4Xqtm8qDpuf2v7yPJ2WuqwgZhe4rodtz" +
       "zdgKrcn24gdJRppzP4TkfqStVvV11OQpH9nU+I45KcNwj3LNtnEESwu4L4lF" +
       "Og0j8wWIXztHDYNj4XkcFv4LkfH6/f4kAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C8zr1n2fvs/29dvXdhLb9WLn2r5p46j9KEqUSPXaSSlK" +
       "pF4kJYqiJGbJDd+ixPdDIpl5aYJtDtolDVqny9DEGLB0yzo3KYYVzTB08DD0" +
       "tQYBUmSPbliTpQPaLMuWYEtbLOuyQ+p7f/de22u2D+D5qHP+55z/8/c/h+e8" +
       "8q3SHWFQKnuulRqWGx1oSXSwsuoHUepp4UF/WB9JQaiphCWFIQ/qritP/8rl" +
       "P/nex5cP7pcuiaU3SY7jRlJkuk7IaaFrbTR1WLp8UtuxNDuMSg8OV9JGguLI" +
       "tKChGUbXhqV7T3WNSleHRyxAgAUIsAAVLED4CRXodL/mxDaR95CcKPRLf7W0" +
       "Nyxd8pScvaj01NlBPCmQ7MNhRoUEYIS78t8CEKronASlK8ey72S+IPAnytBL" +
       "f+t9D/6j20qXxdJl05nk7CiAiQhMIpbuszVb1oIQV1VNFUsPOZqmTrTAlCwz" +
       "K/gWSw+HpuFIURxox0rKK2NPC4o5TzR3n5LLFsRK5AbH4ummZqlHv+7QLckA" +
       "sj5yIutOQjKvBwLeYwLGAl1StKMut69NR41Kbzvf41jGqwNAALreaWvR0j2e" +
       "6nZHAhWlh3e2syTHgCZRYDoGIL3DjcEsUenxmw6a69qTlLVkaNej0mPn6Ua7" +
       "JkB1d6GIvEtUest5smIkYKXHz1nplH2+xTz3sQ84XWe/4FnVFCvn/y7Q6clz" +
       "nThN1wLNUbRdx/veOfx56ZFf/8h+qQSI33KOeEfza3/lOz/xo0+++ts7mr90" +
       "AxpWXmlKdF35jPzAl99KPNu8LWfjLs8Nzdz4ZyQv3H902HIt8UDkPXI8Yt54" +
       "cNT4Kvebi5/8Je2b+6V7eqVLimvFNvCjhxTX9kxLCyjN0QIp0tRe6W7NUYmi" +
       "vVe6E7wPTUfb1bK6HmpRr3S7VVRdcovfQEU6GCJX0Z3g3XR09+jdk6Jl8Z54" +
       "pVLpTvCU7gNPs7T7K/5HJQ1aurYGSYrkmI4LjQI3lz83qKNKUKSF4F0FrZ4L" +
       "JRJwmh9bXa9eR69XoTBQIDcwIAl4xVKDEtuC1MiGAk2H2jy986yR61oHubt5" +
       "/78mSnKJH9zu7QFjvPU8FFggirqupWrBdeWluNX5zueu/+7+cWgc6gqAF5jt" +
       "YDfbAZjtAMx2AGY7ODNbaW+vmOTN+aw7awNbrUHUAzy879nJe/vv/8jTtwE3" +
       "87a3A0XvA1Lo5rBMnOBEr0BDBThr6dVPbj8kfLCyX9o/i685p6Dqnrz7KEfF" +
       "Y/S7ej6ubjTu5Rf/+E8+//MvuCcRdgawDwP/Ys88cJ8+r9PAVTQVQOHJ8O+8" +
       "Iv3q9V9/4ep+6XaABgABIwl4LACXJ8/PcSaArx2BYS7LHUBg3Q1sycqbjhDs" +
       "nmgZuNuTmsLYDxTvDwEd35179CPgIQ9dvPift77Jy8s375wjN9o5KQqwfX7i" +
       "ffrffukbtULdR7h8+VSmm2jRtVNYkA92uYj6h058gA80DdD9h0+Ofu4T33rx" +
       "PYUDAIpnbjTh1bwkAAYAEwI1//Xf9n//q3/wma/sHzvNXgSSYSxbppIcC7mf" +
       "y3TXLYQEs/3wCT8ASywQZrnXXJ06tquauinJlpZ76f+6/Hb4V//Lxx7c+YEF" +
       "ao7c6Edfe4CT+h9qlX7yd9/3p08Ww+wpeS470dkJ2Q4g33QyMh4EUprzkXzo" +
       "9574278lfRpALYC30My0ArH2djoAnZ69xXomMG1gjc1hDoBeePir60/98S/v" +
       "8P18wjhHrH3kpZ/6/sHHXto/lVWfuZDYTvfZZdbCje7fWeT74G8PPP87f3JL" +
       "5BU7ZH2YOIT3K8f47nkJEOepW7FVTEH+0edf+KeffeHFnRgPn00qHbBm+uV/" +
       "/edfPPjk137nBuh1G1gwFBxCBYfvLMqDnKVCn6Wi7VpevC08DRhnVXtqnXZd" +
       "+fhXvn2/8O1/9p1itrMLvdPxQUveTjcP5MWVXNRHz6NjVwqXgA55lfnLD1qv" +
       "fg+MKIIRFbC6CdkAAHNyJpoOqe+489/983/xyPu/fFtpnyzdY7mSSkoFMJXu" +
       "BoighUuA6Yn37p/YBcQ2j44HC1FLF4QvKh6/CBmjw2ga3Rgy8vKpvHj7xUC8" +
       "WddbqL97i7Z+XhBF03N50d7x/O7XJd6O9rHi1123jhwyX4aeoPZj/5O15A9/" +
       "/c8u2LhINjcIpnP9ReiVTz1OvOubRf8T1M97P5lczMVgyX7St/pL9nf3n770" +
       "G/ulO8XSg8rhfkCQrDjHUhGsgcOjTQLYM5xpP7ue3S3erh1ntbeej+ZT057P" +
       "NydRBN5z6vz9nnMppjD6o+C5dmj0a+f9Za9UvPA7lynKq3nxI6dMjESl++3r" +
       "IE55d7egOAMKZy3FSdticXxd+Sfjr33509nnX9nFvCyB1V+pfLN91sWtXp69" +
       "336LFcjJCvy71I+/+o0/FN67f8juvRd9/qbiF6RvATvEkyAWtDxW8/r3nQRT" +
       "4drT13Jt9njmy3ntU+B57nDm5y4ofu84E+e+cNAD+yZDCx7++t/5zJ9+6EVs" +
       "P08ud2xynwGKePCEjonz/d7feOUTT9z70td+uki+YOTC+vKNjbgP0nJY7Boj" +
       "4EKmI1lHVr27i0+6I65Hd/KK2jlxldcvbqHoHwHP84fiPn8TP3New8/uta8v" +
       "AYiCTW4Qhbd0gCId7xzg5b/3zJc++PIz/7FA57vMEEQNHhg32Lad6vPtV776" +
       "zd+7/4nPFau+wjuL+Dm/3724nT2zSy3Yvu9YDVcP1bD3D3da2P2PSrMf8F4C" +
       "rOyPtin/r4YuJKsdA/bR4qYwe15sjiya3cTp8td35MXqyLaXLM0xdnu8wtVi" +
       "Lzkef/9w13EYjm868XfCch0tX8Edte12MKZ7cPyZAzQmFzgNSu+8ufPQhQ1P" +
       "EP23PvyfH+fftXz/G9i6vO2cb50f8h/Qr/wO9cPKz+6XbjvG9wvfQM52unYW" +
       "1e8JtCgOHP4Mtj+xU36hv1NpvlDxLbL0T92i7W/mxYsAG5Rc1TvL3IL8Z5LS" +
       "OaBw3yBQPAaedx0CxbtuAhQ/+/qAgliCtH3kGU+e2wjncB7mwHoC6ae4/rnX" +
       "z3W+4io9DZ53H3L97hugef6i5svp/OUXbsz+bcdRYZ4JjduZ6XB4Iwz+1Gsy" +
       "WYwA5gf2qx6gB5X89999Y7M/urKUq0erf0ELQuD5V1cWejY5FtG4y//nmERe" +
       "N5MgKh84GWzoOsa1n/5PH//izzzzVYDd/aN8l1NrIIZHUuUXvpD/eOWNyfN4" +
       "Ls/EjQNFG0phRBebQE09FqlyiukGUD5w+/97kaKHvtBFwh5+9DeEJaKOTxPO" +
       "iWvzUO+OVLxtjOtIezntdPUV0eRXPa4xYpu1FbwKjbprxArKNtUtm9EYQ6Mo" +
       "pfQWS4Gw51N/gC85f9VBeqEx69h0RZxQQqunc+KEoFg6MC2/30a5wdSfORWF" +
       "x3RIDzOb1o2IVGCdZ1QdaqpQeYNCZbQOSRiPueE6G8vrpTQf22lzLMFjkimv" +
       "1rbDaf3Qn6mLtNGr9WG0XFa10dZphNXW1KoPkzXcI201tHkuGXsCAi82trR0" +
       "SY+u2II3HCxqq9Vg2R/OXHayzrhIQFIu6DTWruSnIOfCLD0lBLEnuvx0gqTi" +
       "xCoPKuOGjE9Yvudsawu5IWN4DxrP4s6qz8ELtJIt5MQZe1HQpmw+c9xZrzbj" +
       "YHVgkB0k4cZwl+zFsLeG06VPBQ0oEpyF4NquMPPLumgGxlqxGizluXowqrmV" +
       "ethtBIbErWPJW9GxGwnMUKio3qjT8+dCg2ysK5JUsWrp1OrwQ4JTkt4knWRS" +
       "y5i1Fdak5mt1EC2bbVWYpLykmhidOrTLULzeSVvjTadCp57EM/0wqLVbW9+e" +
       "VFBnm034sD6wM6rGY7ycGctNGaMElcc2PXnW9EiZ0xwcpe2U2E4GTZckJHTA" +
       "2tEE1zyI1KZ+ubWdx64/NX3a5uQYIyfl1azvKThJ20Er87gWLzdsN423fXpp" +
       "e/bEtmEn6YDEgg6hQccPpm20V2WD3oDg1NVou1wESpvKeuPOxlZHA6G6krrd" +
       "mGsi4oyz5KExJWzS5zwqwbO0LvhrZzzm/I7ZMCfwEopxTefLLlXhcWXODO0N" +
       "OSMG8Wqx1ha1KV9l6dVoxHPKdDwlhYTT8CkXykjKG07I9BGnLihNx4IaYioH" +
       "0VACMva3fXQlkGICpYwx9ZjNdKUy0z5DdHtmv1dVO7KnSN1mOOnjk14Cmb2W" +
       "UmvXMqtaUVIbmmJ927Dq0jBoCBYrJhqn6hLNOmqvCi16k1pHslwhHFARtmIX" +
       "5dRv1yb2aoFLnJ91u52t1XKUGlTrRA1U4xcYNZlPuwNRhRlx2hk1/HlTmix9" +
       "hlPGK8GfuBnFVgwB1vqRPkzbAt1COYZyGyw86BPZgF2bXhpsBqqO1HzCaA3J" +
       "FgnrRCzh6yZWrffkHgF5W5iY4FNMJMYYmbSTbQ3LxiHd1rwB1RecCdmpjLhK" +
       "Ra1PtbYSpksyyLoLlR9vq+u+w8o0LFPZAmVWIqJE0y0aiE5zgfvYwmXJytSo" +
       "dWd8P6ysOQSR+ywiWNxcUNsNCqWgarxkOi6mWRUDpxdIAqYfrDkubqCUz9l8" +
       "1JjGcwdYqpziSpum20I0x8nGdrY2Q9IdCuOgJRHkYqgJi5Uxbul1EBmCYMjy" +
       "cEq5y7qhlvmKY4bxTJ5Z8ZhXMnI5J1yXxWPbY2e2my2obnsgd+vtajd2ldHI" +
       "YptsxSQMotVc9yTgSG0zHU9NS7QbPEvjnDtLx8ZC3CLzbMzUm+tRTYarsBTq" +
       "HVlvNWOto1HiokWz7erA7SeqG051eOMgsF0vlxtMM6pCY2fcrtV7EW2HsWjK" +
       "Kw4FWp5D5mJEsWmTbIfhuBKNhd5ggY/xjBj3KJqo9jeY1N0kbjbDk9Tq9XFT" +
       "BRENZOiPWxXKrS7YIHBaaCxBcwyajLcKN6UEgsbMcqWHoM0kYrq46mdbXh+L" +
       "TjJWGmW9SrUjDawYVQU1G3TVXsLefKSly0Cddjja3hguOdrELJ6u4YFRbm6q" +
       "DUaWa1EZW29CfdrJmKiKDyO7go9nLWI6YmG+ATcxWZirWWWejbzQ6HRifiO0" +
       "ZuKIJZZWx574Q6JnldF423U7KTnoaBtJsGNDUHxiOven6ZpKZxpcweqNxrAq" +
       "N9yx7jMEr0isOMcyvMFD9YUzhI1J3LUzUzZ6qQczlDhO5a0m821tQXqTOEq6" +
       "ZYtZpnoZ61heK8Wb7iC22mSHtXFqiW/jZnU5q80YCPZGbkiuZkK/tTQrNFIu" +
       "J34XhhrLhb1c9oPR2k577hCdNtoZmn8MoSnUnSDJBp3qC0koj2N6FKlza+G0" +
       "R3gdwnmjPMbKfncVdtorrUItnDXmiDLVW0jqqtkkhpYDax2sJ1FwU1bK+qI9" +
       "Njgo2ky5SlqTgw2GqQxdXfAwt15njD8OFKXCib2Qb9WdTKmJnOlDuGg2ISkq" +
       "d2rNam0x7MoC0qluzUarrLPtug5hXjSq9So1GwD+JEkxLxvhYtQko65JcmXY" +
       "rY8YC62Nl4rBbTWPp5xBdclH5jCqj9ew5emeUncGg66KLkmjzmwrS6NlmS21" +
       "Dg2ZZMjKrr5FObwcGROZDEPGJeurWAlsu5tlSgJNg9HKwGaMsqAgFVWkIR+u" +
       "x1Uf7YpLz9caW2gmC8B47bEjR1BD1gN4VNXxUNUQYtkOZxZsi7hTSeqVUHKG" +
       "Awtt1DTgTUnF7yld0iMDwdOXpjmmYX886HjMAvcYYDYdM3GuHXSImh8PjDVX" +
       "M+l06tTdGsxVbBwbuWp5pEtzpYyq5Ynb7Yf15cJEbc6uIGYsd+dUMkpmIjX0" +
       "eoJtBZ25GQ9WZJXNZgLmt6qybFCalTT0UYCvBrZII10Y0b2qMs1WW6Nh81iz" +
       "jpan6gZyZMRLpibnep0NBWlxtwn789p8MyKTlaknZB/rtoCeNIxB0WWmMzHm" +
       "OmVoPfO2TUaEZRArMBJum1pNT7fVVlbmym1vMJjDtFPtzQnSGyy2BjQntoo+" +
       "cPBs6bKG2EzqJkfPNduvWPyGWq2pSNTrYm1ZW3gYwiUbVeWTcMhLTjTwm1Af" +
       "dydQSg9HWjtU7bpdncnV0FgLC1oY8Cuc9IcqQ/oLJ1nz2lztbIIyUHM/gsY6" +
       "W7Urqc9m3JBy6um86szKrK0iQlxb13TVM1YJJG9YNWAaSCNsqWUz6hqVrpzM" +
       "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" +
       "WnEe/5kPv/Syyv4ifHQihkaluyPX+zFL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("22jWqaFuL97/2tnj5fzUanrIxvT8d84TQS+obK9QWfJaX6L/5S3avpgXvwG0" +
       "HGi2u9Fwy8ovcGpOFN7wu93GNdUTpf/mGzl4Pid4QfYEeKRDwaUfjOB7JwS1" +
       "guD3b0xw9KX1HScfR4uzqp6jagkbR6zecmNHDTuJonn5wUQx2L/Pi69EpfvN" +
       "nOzocLZwyBO1/Ku/gFruzysfB495qBbzB66WzxYEf3QLp/hGXnwdSBkW4vFu" +
       "oZRCpSdS/uFf1PjvAM9HD6X86BuQ8uScy7yVqMXv8HjKNx8pdu9wyuJ/VLp+" +
       "8Q7Oj1/xYyk0/diNtHfsbldd2Z3mXinOcq/srP6e916h2XbnOoPTncmV5684" +
       "2vaw5QOSLb/wnoODg/dee9bzkhP3uOG53nePDmD+7HWe6+XFC4U18uJ/XDzT" +
       "y39+MC8+dPGQrjDEbtqid1585Ba+8P2bt+0V7vTnefHRHSe3oL0t2Y33329B" +
       "c0de+V8BzNiSWVye+9KJu/23N3TJBfjumbuY+cWyxy7c+97dVVY+9/Llux59" +
       "efpvdgfTR/eJ7x6W7tJjyzp96ePU+yUv0PSdA969uwJSGHrvvqj0yI1vh0al" +
       "20CZ87p37472clR6+CItoAPlabqHo9IDZ+kADShP0wAou+eEJipd2r2cJnkM" +
       "9AIk+esPeTc4adrdjUn2zma+Yws8/FoWOJUsnzlzEFzcyz86tI1Hh7dVPv9y" +
       "n/nAdxq/uLtNqVhSluWj3DUs3bm72Hl88PvUTUc7GutS99nvPfArd7/9KP0+" +
       "sGP4BEVO8fa2G19d7NheVFw2zL7w6D9+7u+//AfFRY//A2UfFmkwMQAA");
}
