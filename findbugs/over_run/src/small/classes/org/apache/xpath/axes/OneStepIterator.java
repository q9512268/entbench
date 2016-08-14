package org.apache.xpath.axes;
public class OneStepIterator extends org.apache.xpath.axes.ChildTestIterator {
    static final long serialVersionUID = 4623710779664998283L;
    protected int m_axis = -1;
    protected org.apache.xml.dtm.DTMAxisIterator m_iterator;
    OneStepIterator(org.apache.xpath.compiler.Compiler compiler, int opPos,
                    int analysis) throws javax.xml.transform.TransformerException {
        super(
          compiler,
          opPos,
          analysis);
        int firstStepPos =
          org.apache.xpath.compiler.OpMap.
          getFirstChildPos(
            opPos);
        m_axis =
          org.apache.xpath.axes.WalkerFactory.
            getAxisFromStep(
              compiler,
              firstStepPos);
    }
    public OneStepIterator(org.apache.xml.dtm.DTMAxisIterator iterator,
                           int axis) throws javax.xml.transform.TransformerException {
        super(
          null);
        m_iterator =
          iterator;
        m_axis =
          axis;
        int whatToShow =
          org.apache.xml.dtm.DTMFilter.
            SHOW_ALL;
        initNodeTest(
          whatToShow);
    }
    public void setRoot(int context, java.lang.Object environment) {
        super.
          setRoot(
            context,
            environment);
        if (m_axis >
              -1)
            m_iterator =
              m_cdtm.
                getAxisIterator(
                  m_axis);
        m_iterator.
          setStartNode(
            m_context);
    }
    public void detach() { if (m_allowDetach) { if (m_axis >
                                                      -1)
                                                    m_iterator =
                                                      null;
                                                super.detach(
                                                        );
                           } }
    protected int getNextNode() { return m_lastFetched = m_iterator.
                                                           next(
                                                             );
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.xpath.axes.OneStepIterator clone =
          (org.apache.xpath.axes.OneStepIterator)
            super.
            clone(
              );
        if (m_iterator !=
              null) {
            clone.
              m_iterator =
              m_iterator.
                cloneIterator(
                  );
        }
        return clone;
    }
    public org.apache.xml.dtm.DTMIterator cloneWithReset()
          throws java.lang.CloneNotSupportedException {
        org.apache.xpath.axes.OneStepIterator clone =
          (org.apache.xpath.axes.OneStepIterator)
            super.
            cloneWithReset(
              );
        clone.
          m_iterator =
          m_iterator;
        return clone;
    }
    public boolean isReverseAxes() { return m_iterator.
                                       isReverse(
                                         ); }
    protected int getProximityPosition(int predicateIndex) {
        if (!isReverseAxes(
               ))
            return super.
              getProximityPosition(
                predicateIndex);
        if (predicateIndex <
              0)
            return -1;
        if (m_proximityPositions[predicateIndex] <=
              0) {
            org.apache.xpath.XPathContext xctxt =
              getXPathContext(
                );
            try {
                org.apache.xpath.axes.OneStepIterator clone =
                  (org.apache.xpath.axes.OneStepIterator)
                    this.
                    clone(
                      );
                int root =
                  getRoot(
                    );
                xctxt.
                  pushCurrentNode(
                    root);
                clone.
                  setRoot(
                    root,
                    xctxt);
                clone.
                  m_predCount =
                  predicateIndex;
                int count =
                  1;
                int next;
                while (org.apache.xml.dtm.DTM.
                         NULL !=
                         (next =
                            clone.
                              nextNode(
                                ))) {
                    count++;
                }
                m_proximityPositions[predicateIndex] +=
                  count;
            }
            catch (java.lang.CloneNotSupportedException cnse) {
                
            }
            finally {
                xctxt.
                  popCurrentNode(
                    );
            }
        }
        return m_proximityPositions[predicateIndex];
    }
    public int getLength() { if (!isReverseAxes())
                                 return super.
                                   getLength(
                                     );
                             boolean isPredicateTest =
                               this ==
                               m_execContext.
                               getSubContextList(
                                 );
                             int predCount = getPredicateCount(
                                               );
                             if (-1 != m_length &&
                                   isPredicateTest &&
                                   m_predicateIndex <
                                   1) return m_length;
                             int count = 0;
                             org.apache.xpath.XPathContext xctxt =
                               getXPathContext(
                                 );
                             try { org.apache.xpath.axes.OneStepIterator clone =
                                     (org.apache.xpath.axes.OneStepIterator)
                                       this.
                                       cloneWithReset(
                                         );
                                   int root = getRoot(
                                                );
                                   xctxt.pushCurrentNode(
                                           root);
                                   clone.setRoot(
                                           root,
                                           xctxt);
                                   clone.m_predCount =
                                     m_predicateIndex;
                                   int next;
                                   while (org.apache.xml.dtm.DTM.
                                            NULL !=
                                            (next =
                                               clone.
                                                 nextNode(
                                                   ))) {
                                       count++;
                                   } }
                             catch (java.lang.CloneNotSupportedException cnse) {
                                 
                             }
                             finally { xctxt.popCurrentNode(
                                               );
                             }
                             if (isPredicateTest &&
                                   m_predicateIndex <
                                   1) m_length = count;
                             return count; }
    protected void countProximityPosition(int i) {
        if (!isReverseAxes(
               ))
            super.
              countProximityPosition(
                i);
        else
            if (i <
                  m_proximityPositions.
                    length)
                m_proximityPositions[i]--;
    }
    public void reset() { super.reset();
                          if (null != m_iterator)
                              m_iterator.
                                reset(
                                  ); }
    public int getAxis() { return m_axis; }
    public boolean deepEquals(org.apache.xpath.Expression expr) {
        if (!super.
              deepEquals(
                expr))
            return false;
        if (m_axis !=
              ((org.apache.xpath.axes.OneStepIterator)
                 expr).
                m_axis)
            return false;
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Cj3ANa/ruCtD6/BH138A1/k8m3clAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C6zk1nUY3660q11L2pVkfSLbkiWtPxKtxxnOl5XtmMPv" +
       "zJDDmeFwPkycNYd/Dn/DzwxnXKWJgUZODbhGKydu4ygFaiNpqsRG0CAG6gQq" +
       "0jZOHRRwEKRpgcZGEaRuU7cxmqRF3Na95Ly377NvV1F30QfcO5e85957/uee" +
       "y/te/w50bxxBcBi4G9MNkn09S/Ydt7afbEI93u9wtb4SxbpGuEocj8C76+qz" +
       "X77yF9/7jHX1HHRBhh5RfD9IlMQO/Hiox4G70jUOunL0lnJ1L06gq5yjrBQk" +
       "TWwX4ew4eYmD3nZsaAJd4w5RQAAKCEABKVBA8CMoMOgB3U89Ih+h+Em8hH4U" +
       "2uOgC6Gao5dAz5ycJFQixTuYpl9QAGa4L38eA6KKwVkEvfsG7TuabyL4szDy" +
       "6k//yNVfOQ9dkaErti/m6KgAiQQsIkP3e7o316MY1zRdk6GHfF3XRD2yFdfe" +
       "FnjL0MOxbfpKkkb6DSblL9NQj4o1jzh3v5rTFqVqEkQ3yDNs3dUOn+41XMUE" +
       "tD52ROuOQjp/Dwi8bAPEIkNR9cMh9yxsX0ugp0+PuEHjtS4AAEMvenpiBTeW" +
       "usdXwAvo4Z3sXMU3ETGJbN8EoPcGKVglgZ685aQ5r0NFXSimfj2BnjgN1991" +
       "AahLBSPyIQn06GmwYiYgpSdPSemYfL7T++CnP+6z/rkCZ01X3Rz/+8Cgp04N" +
       "GuqGHum+qu8G3v8C91PKY7/+yXMQBIAfPQW8g/m1v/7dj3zgqTe+toN5xxkw" +
       "wtzR1eS6+oX5g994J/E8dj5H474wiO1c+CcoL9S/f9DzUhYCy3vsxox55/5h" +
       "5xvDfzn7sV/U/+QcdLkNXVADN/WAHj2kBl5ou3rE6L4eKYmutaFLuq8RRX8b" +
       "ugjanO3ru7eCYcR60obucYtXF4LiGbDIAFPkLLoI2rZvBIftUEmsop2FEARd" +
       "BAW6H5T3Qru/4jeBDMQKPB1RVMW3/QDpR0FOfy5QX1OQRI9BWwO9YYBkClCa" +
       "F53r6PXGdRSJIxUJIhNRgFZYOpLlyyFKBoQs+LqY6GE7yYkKov1c38L/bytl" +
       "Oc1X13t7QBzvPO0MXGBHbOBqenRdfTVtUd/95etfP3fDOA64lUDvAcvt75bb" +
       "L5bbz5fbP7UctLdXrPL2fNmdwIG4FsDwgUu8/3nxo52PffLZ80DTwvU9gNfn" +
       "AChya89MHLmKduEQVaCv0BufW//4+G+UzkHnTrrYHFXw6nI+vJ87xhsO8Npp" +
       "0zpr3iuvfPsvvvRTLwdHRnbCZx/Y/s0jc9t99jRTo0DVNeANj6Z/4d3Kr17/" +
       "9ZevnYPuAQ4BOMFEAUoL/MtTp9c4YcMvHfrDnJZ7AcFGEHmKm3cdOrHLiRUF" +
       "66M3hbQfLNoP5TzOlTpvNA+0vPjNex8J8/rtO+3IhXaKisLffkgMf/YP/vV/" +
       "qhTsPnTNV44FO1FPXjrmDvLJrhSG/9CRDowiXQdw//5z/b/72e+88kOFAgCI" +
       "585a8FpeE8ANKIVG/c2vLf/tN//wC7937obSQNlJ2s7dhjawyHuP0ABexAX2" +
       "lSvLNcn3As02bGXu6rly/q8r7yn/6n/59NWd+F3w5lB7PvDmExy9/4EW9GNf" +
       "/5H/8VQxzZ6aR7EjVh2B7VzjI0cz41GkbHI8sh//3Xf9vd9SfhY4WeDYYnur" +
       "F77qfEH6+YLyRxPo2Zus8dBx7hMHDTD/87fZ9ES2B+S1OggUyMsPf3Px+W//" +
       "0i4InI4qp4D1T776t76//+lXzx0Lvc/dFP2Oj9mF30LRHtgJ7/vgbw+U/5OX" +
       "XGj5i537ffiQgnffCAJhmAFynrkdWsUS9H/80sv/9BdefmVHxsMnIw8FNla/" +
       "9Pv/+3f2P/et3z7DwZ0Hu4r8oVqguV+g+XxRvwjQ2iv4v3fI//cXbnU/89z9" +
       "JFL8OLdKoOUHLT2iMlUPc0EXk30wr56OjzuikwI5tgW8rn7m9/70gfGf/sZ3" +
       "CxxP7iGP2x2vhDuOPphX784Z9Phpr8sqsQXgqm/0fviq+8b3wIwymFEFG6dY" +
       "iIDHz05Y6QH0vRf/3T/7zcc+9o3z0DkauuwGikYrhcODLgFPo8cWCBZZ+IMf" +
       "2Vnc+j5QXS3MErrBLei4oT55w1wv5S+fAKV7YK7ds11RXj9T1Nfy6n073idg" +
       "G5zOXVs9Zf/33WbCU1I8dxB1zrIiIEot8fbJEY9ndnwY0I40gj9bI/LHDxUA" +
       "g7yii/4fzCtmh2frr8SpHewTxdOF25sunW+WjwLLE38puPNP/If/eZO6FPHw" +
       "DGs+NV5GXv/8k8SH/6QYfxSY8tFPZTfvF0BicTQW/UXvz889e+FfnIMuytBV" +
       "9SBrGStumrt7GezU48NUBmQ2J/pP7rp3W8yXbgTed552J8eWPR0Sj8wYtHPo" +
       "vH35VBTMC/RhUN5/oCnvP616xb7lwcIacpT2uQCkAZ/6o8/8zt9+7puANx3o" +
       "3lWON2DJ1SOgXppnRj/x+mff9bZXv/WpIkZ95IWvJH/8yM99Kp/1h85W5XNA" +
       "leMix0oAKbavuAW2NZBFxkVeNQbuG4hQapPF0HLRu1ORRgKiE0DtyFIKZfvh" +
       "N1O28Q1W5Dte6J2gvHDAihduYgVUNJxbGuKlMAoSIDBdO0T8gnddAWZTmMsp" +
       "1BZvEbX3gfLiAWov3gK16Bao5U3/EKfL3nX7mBn3TuEVvyleO7bvAYLvRfcb" +
       "+6X8eXP2yufzZiev5nmlHuLwuOOq1w4D2oFYrzlu49AFHdOlXeZ5CsnaXxnJ" +
       "4umjgAd9pfQzX8kfPvHWUH0yR1UM0kjVOSVO+GJ3o2s5tjmE/v+MWfLQB9lq" +
       "3MYP/7iyQtRwKRv6aUUX9ApL9WucsxYEqSpRjZkztOh6YG3Ytqo2euWkMqAn" +
       "pD+RPdjDmJqtMRO57qylxZKWuuF4ylAuIeLUwp3QbEQTqUsPeWMtLfmJUw3Y" +
       "ktvMaI0PAk9chIMhW/U9pJJ4mif7WlVTA64zLm3jRmWKVBA4WiEIErKjRBAX" +
       "KJkINtE1F8PEnfiyLQpYhW3xXV9aDmwvHSh6JxbnYKptEx5yIH2iRW1heiPQ" +
       "SaL2rNce8660UGsk79KTEaGE7e241u0oYpvBxEW2dHCZKmkdureIt6nbbbSD" +
       "OKv1Ascy/QlJiVwF9wiqHw79JLE1syasZ7XNvJvOXBTG9VJWsstL4Pens04o" +
       "DETNd6qqV+GmfAY0DS1Jw2AceLHb7RHKPCLLzqLfK4+0RT1izHjg8HHsMrUN" +
       "PaeWiUXrkzBI5wi62GApq/iOEgLX2o2YtG15/a1UluVhlx9zUT8tiwofqSOu" +
       "1hO9ziLw1HW7XspkjAq41pIeDsu1ypjFjUF5XKq7gjNbkX7H72otSp55w0nD" +
       "Fusz3Az1WlCtZa63ZAi00VnPQrLkd+tlZx7CbbhZ7zeiilOPloYbkspg3I6W" +
       "637bMS2ep60F1Rp2pVJf4sl4YUtLMqSrtLnGBoNsJulykjQG8oh1Z7RrzqZq" +
       "TyRIjK/3wB49WjbwhU3MF0NFlr0RLVa6fuzD4441thhmmAClKnfoTWtbYvGu" +
       "tZjxtTYBd2o93mNGERWpTqUdxk4XjYJZa0Av9cDLqM2mWh4MpyY+8dZTajAs" +
       "C2yAk7YhmBkpbsfrwazfmIR0R9L0epupipbnEQtxjqScM24p/DIVuwOrQ4WI" +
       "Rzc7ESn2OvC435/VKtFq4aaVpeiM+UFMbIeURMNysz3kS3Dg15UQV2hjgg/H" +
       "kUHPLVVhMaBH5oAZIVQviefNRicYibBaYSuVLuMI2Lpjw8GsLMm4nzV7xIJG" +
       "5dLWTVTTy6R6JwgDhN52BL3BMY1KwmilQSdiGu3tjJlSdQeZIzV3Na0seITo" +
       "CMu52/aURVBvTWsShwbhdKwE6sgdL0Vq3fUnI3EZdv35BvFqI9KQssnSmJS4" +
       "2qLU1WOPykbwkto6qxJNi7JJjMcDGmt0lXIna0wnuIOQdYcqcd2qyI1VvuSW" +
       "Aw3ha13e8cyQscbUQB6PuWFQ6XUGBqkGmVUL11yJWUULaYs7Ts8M0I41c2l7" +
       "Nh6WMsLxHEqlVTwaembJbCa0NVjPUgl28ep2WRls6FKwbsPhCjbKcWhuO/2K" +
       "1e6aI9eDeRo3p8CIXH6h2CNqpbvuVDRScZs5wjBMSTeZO/ymVRO5iWox8BQX" +
       "pzZiT9p1ajCFpXjam22EjhVRaNYc9BpLfdCbRtpyndYlqk9VDN6kS+xMsVSE" +
       "tyVF5yi8HneaYkYjYZ/107QeVtfEQGiTFLVQ415LKVWrcbcrBzNXwp31krZM" +
       "VW2vJ+Qa6IXYYjEUrs2TihBVeHiF232qNiMEgq6xLFVLS2JkoOrUizS0jKQG" +
       "y7mYBc/TprwZVCWx3qeWlGMpyMioEAAHVK0OWKqKpAqOjohZizV5mjfJEtns" +
       "zePphmcHSaAJlCx3FyQQirJo4ZMGi2+SmS0wSTzG1iGa+AlsWOKc6Y+lfnkz" +
       "RTtp30B7aTDbrsbqolFi5KbECnVEUHDDEKa1VbnRLutlynLDvtiCzaiHkkPH" +
       "kvGmrumJSpczW1pHZgWLjUqDTGFlW6n0MzNLMYKINAvFzaBT6dIrnYm2SxTG" +
       "dAMEsp7si6I8TXwCnwuOzlkxPjPDeF4RJ+VIWgpdQXXbkmXpnA7TRuLjsY70" +
       "iYkQr5qEk2UrxoCXorb2K1jCzH3UU5J+b9ULB3abkcbauOHgnCfqDb6izqwI" +
       "H8OqpWIwxze21ZDFRb5VXpdrE1QaoFKHbqCUiDUokYp1hrSrrO6V5qVtSW8i" +
       "QmYP122yvIgj0wqbLSmoKG0h6VTVlbDaNNREa3b67WEnqjHLbQ0zV+OoPq12" +
       "awNzYOPbGuMwMaI3HILpT2szGfOXXcSmqv1A5BqDYT8i8VVMW3Anizc9tkyy" +
       "OMJtWuy2JVnpsm9FUomtRMiUiilj4aNkXa9jvUppnE4mK3liRvOap7nbsKoo" +
       "WzUbtlmvOW1XlI05Hjk0SLqFButUIwttAItV1GVvTW9EGUMaaaWJMViEYBrO" +
       "rLkam1RY3qoTDjUfInagZT4rpYvYjAUjmm8z16jjdFoXJZAUjHRfmQNUhrzI" +
       "bXmsRjJTL2OzVrlhlUiRt3oRTqwck0pq+obzOrU+vYDhXq3PhzRvL9y1mbV6" +
       "Q8ad9Yy5ho2CTWBJw6bhL+oVKkymJdwXUntUknWp28T0SV9JZAzrmZ1oOVfd" +
       "Xp0bbFFinngBG8Y1pSuEiE1UJafFznrrirOS9QlInJFBx2PbA3moWs52VCVx" +
       "H/dajWlcUqZutK3Ay+asx9XEQRMPxXBiEwnFmfisJeGrjqiuh7ZWUpB516MH" +
       "IE8Mur7DU5MNardRVWC8fiNe+6zoavysNeslpJRhs2bYI+cVDrisPr8VOlpH" +
       "bYitnrZkYGxCAyOeC8ZGs6poc1N2eNFySovegDICPCFARAgReV2ZTyTcZtb9" +
       "mSiWJpMI9sMNRSaKqC4iM004OCNgTpiTJcuMq/NK1JS9SB37jQrsT/z1ekbT" +
       "fNKkxO4GQ+Zxn5O3amwgTh3DEKymLgy3nM57eGtjsMOej6jhADOQpsY3Q3go" +
       "g02Z1Eyo/jBWhZGQNjG8JzTqM1IkS41FrbkYxNyiZNebHWTaV6mVTKG02F84" +
       "yyGXSFNRDZTBZmOWCd2TGhiRjuORj6XLyXRM6xVZY3SGXc+wDRKMKBFGRwxe" +
       "EwTOY0MLXVArS4gxNEL6TSRejsqS2xQ3LW4hm0yiIT2jEZVRHeENMynF1aXk" +
       "2JwRdNp1rdxaMfHKYpoGupU3VQxG57Aky+hqNoCbqwWLbfgYrcaNPmY1WXhE" +
       "YzN+2KHHgylbwQ3dSs0Ww0iDzdRnVmbT7GpuY76S16MpumZb/WyJYZmR2UQH" +
       "pxddfZpO5Zq2GWJYqbvQp3GQ2Yk09Na9scdjy0lYZol5vRoSZnecLqksJtOx" +
       "QZprfgLCAV1atlUCrq1WcobAgmp0EM5dc422NKEFFmmBpHnOzr247PFeyCzH" +
       "FIcOeLC3cOUVyeDl6qZWG07lDmIvnJUVjZ0aOfLVLUg2BW4lzU1RZa06ouqL" +
       "VZSucEKjTW9qOugstLFBnbDGfbo3bmYjkixXMUSYdOy1yE2dTG6uwmSkTWu9" +
       "oS+U6c2i6gWR43NwS643EQ8Zld11HewC1Eyby/2Vj0lYQ+OReak27dNok2si" +
       "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" +
       "/+d59V8T6O3A1PsRSC89O9n0j13SOWbz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("/+0OiH0gf5k76z87IPbP7r6Qv3/rvr1iir8EOwdAJ6f75u6C3zHivncHxBXf" +
       "I/cBnh/Yjd393n1J7r3tNhQ+kFcXEugxNUj9s2V5FJ72Lt5p4AXua69xQG7j" +
       "rsty7/Hb9P1AXj0MXHKU+6pThD1yp0r6doAjdUAYdfcJe+42fe/Jq6eAnwFK" +
       "ih9+Jj8i7ek7dbJgS7HHH5DG3x3STsXVd9x04YzKQiCm+CCc7iG3Ib+SVy8k" +
       "0GVN10NqmSq73f23jzgAv6W7Mgl05dS90/w23RM3XXPfXc1Wf/m1K/c9/pr0" +
       "b4qrlzeuT1/ioPuM1HWP3x451r4AqDPsgjWXdndJwoKWv5ZAj555FRZsgZWD" +
       "8LKH7WA/BDbbp2GBdhe/x+E+AlhzBAc2nrvGcRAigc4DkLxJhodCed/Zd3IJ" +
       "y3a1EcDokDvZToxPHNegwjc+/GZsP5bLPXciAyv+8+AwW0p3/3twXf3Sa53e" +
       "x79b/+LusqjqKtttPst9HHRxd2+1mDTPuJ655WyHc11gn//eg1++9J7D7PDB" +
       "HcJH2nwMt6fPvqJJeWFSXKrcfuXxf/LBn3/tD4sLOv8XDIEtnBIyAAA=");
}
