package org.apache.xpath.objects;
public class XNumber extends org.apache.xpath.objects.XObject {
    static final long serialVersionUID = -2720400709619020193L;
    double m_val;
    public XNumber(double d) { super();
                               m_val = d; }
    public XNumber(java.lang.Number num) { super();
                                           m_val = num.doubleValue();
                                           setObject(num); }
    public int getType() { return CLASS_NUMBER; }
    public java.lang.String getTypeString() { return "#NUMBER"; }
    public double num() { return m_val; }
    public double num(org.apache.xpath.XPathContext xctxt) throws javax.xml.transform.TransformerException {
        return m_val;
    }
    public boolean bool() { return java.lang.Double.isNaN(m_val) ||
                              m_val ==
                              0.0
                              ? false
                              : true; }
    public java.lang.String str() { if (java.lang.Double.isNaN(m_val)) {
                                        return "NaN";
                                    }
                                    else
                                        if (java.lang.Double.
                                              isInfinite(
                                                m_val)) {
                                            if (m_val >
                                                  0)
                                                return "Infinity";
                                            else
                                                return "-Infinity";
                                        }
                                    double num = m_val;
                                    java.lang.String s = java.lang.Double.
                                      toString(
                                        num);
                                    int len = s.length();
                                    if (s.charAt(len - 2) == '.' &&
                                          s.
                                          charAt(
                                            len -
                                              1) ==
                                          '0') { s = s.substring(
                                                         0,
                                                         len -
                                                           2);
                                                 if (s.equals("-0"))
                                                     return "0";
                                                 return s; }
                                    int e = s.indexOf('E');
                                    if (e < 0) { if (s.charAt(len -
                                                                1) ==
                                                       '0') return s.
                                                              substring(
                                                                0,
                                                                len -
                                                                  1);
                                                 else
                                                     return s; }
                                    int exp = java.lang.Integer.parseInt(
                                                                  s.
                                                                    substring(
                                                                      e +
                                                                        1));
                                    java.lang.String sign;
                                    if (s.charAt(0) == '-') { sign =
                                                                "-";
                                                              s =
                                                                s.
                                                                  substring(
                                                                    1);
                                                              --e;
                                    }
                                    else
                                        sign =
                                          "";
                                    int nDigits = e - 2;
                                    if (exp >= nDigits) return sign +
                                                        s.
                                                          substring(
                                                            0,
                                                            1) +
                                                        s.
                                                          substring(
                                                            2,
                                                            e) +
                                                        zeros(
                                                          exp -
                                                            nDigits);
                                    while (s.charAt(e - 1) == '0')
                                        e--;
                                    if (exp > 0) return sign + s.
                                                   substring(
                                                     0,
                                                     1) +
                                                 s.
                                                   substring(
                                                     2,
                                                     2 +
                                                       exp) +
                                                 "." +
                                                 s.
                                                   substring(
                                                     2 +
                                                       exp,
                                                     e);
                                    return sign + "0." + zeros(-1 -
                                                                 exp) +
                                    s.
                                      substring(
                                        0,
                                        1) +
                                    s.
                                      substring(
                                        2,
                                        e); }
    private static java.lang.String zeros(int n) { if (n < 1) return "";
                                                   char[] buf = new char[n];
                                                   for (int i = 0;
                                                        i <
                                                          n;
                                                        i++) { buf[i] =
                                                                 '0';
                                                   }
                                                   return new java.lang.String(
                                                     buf); }
    public java.lang.Object object() { if (null == m_obj) setObject(
                                                            new java.lang.Double(
                                                              m_val));
                                       return m_obj; }
    public boolean equals(org.apache.xpath.objects.XObject obj2) {
        int t =
          obj2.
          getType(
            );
        try {
            if (t ==
                  org.apache.xpath.objects.XObject.
                    CLASS_NODESET)
                return obj2.
                  equals(
                    this);
            else
                if (t ==
                      org.apache.xpath.objects.XObject.
                        CLASS_BOOLEAN)
                    return obj2.
                      bool(
                        ) ==
                      bool(
                        );
                else
                    return m_val ==
                      obj2.
                      num(
                        );
        }
        catch (javax.xml.transform.TransformerException te) {
            throw new org.apache.xml.utils.WrappedRuntimeException(
              te);
        }
    }
    public boolean isStableNumber() { return true; }
    public void callVisitors(org.apache.xpath.ExpressionOwner owner,
                             org.apache.xpath.XPathVisitor visitor) {
        visitor.
          visitNumberLiteral(
            owner,
            this);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1xKBw9zyhsGdjPvTqv8AI2EFmIcjAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8eYi2t2/viG/+kqf+YnXq7+0uz8nm2KW");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5a1cpqFLu6t8RaP5BuVdd23tuK2LvRd+8PCvX3nP8Wbq4Z3AJxZ+SrZn73xZ" +
       "rWO5YXG9LPvNJ37jQ19+5Q+LqxP/F7Ndem0WLwAA");
}
