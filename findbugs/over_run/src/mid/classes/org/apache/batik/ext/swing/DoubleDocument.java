package org.apache.batik.ext.swing;
public class DoubleDocument extends javax.swing.text.PlainDocument {
    public void insertString(int offs, java.lang.String str, javax.swing.text.AttributeSet a)
          throws javax.swing.text.BadLocationException { if (str ==
                                                               null) {
                                                             return;
                                                         }
                                                         java.lang.String curVal =
                                                           getText(
                                                             0,
                                                             getLength(
                                                               ));
                                                         boolean hasDot =
                                                           curVal.
                                                           indexOf(
                                                             '.') !=
                                                           -1;
                                                         char[] buffer =
                                                           str.
                                                           toCharArray(
                                                             );
                                                         char[] digit =
                                                           new char[buffer.
                                                                      length];
                                                         int j =
                                                           0;
                                                         if (offs ==
                                                               0 &&
                                                               buffer !=
                                                               null &&
                                                               buffer.
                                                                 length >
                                                               0 &&
                                                               buffer[0] ==
                                                               '-')
                                                             digit[j++] =
                                                               buffer[0];
                                                         for (int i =
                                                                0;
                                                              i <
                                                                buffer.
                                                                  length;
                                                              i++) {
                                                             if (java.lang.Character.
                                                                   isDigit(
                                                                     buffer[i]))
                                                                 digit[j++] =
                                                                   buffer[i];
                                                             if (!hasDot &&
                                                                   buffer[i] ==
                                                                   '.') {
                                                                 digit[j++] =
                                                                   '.';
                                                                 hasDot =
                                                                   true;
                                                             }
                                                         }
                                                         java.lang.String added =
                                                           new java.lang.String(
                                                           digit,
                                                           0,
                                                           j);
                                                         try {
                                                             java.lang.StringBuffer val =
                                                               new java.lang.StringBuffer(
                                                               curVal);
                                                             val.
                                                               insert(
                                                                 offs,
                                                                 added);
                                                             java.lang.String valStr =
                                                               val.
                                                               toString(
                                                                 );
                                                             if (valStr.
                                                                   equals(
                                                                     ".") ||
                                                                   valStr.
                                                                   equals(
                                                                     "-") ||
                                                                   valStr.
                                                                   equals(
                                                                     "-."))
                                                                 super.
                                                                   insertString(
                                                                     offs,
                                                                     added,
                                                                     a);
                                                             else {
                                                                 java.lang.Double.
                                                                   valueOf(
                                                                     valStr);
                                                                 super.
                                                                   insertString(
                                                                     offs,
                                                                     added,
                                                                     a);
                                                             }
                                                         }
                                                         catch (java.lang.NumberFormatException e) {
                                                             
                                                         }
    }
    public void setValue(double d) { try {
                                         remove(
                                           0,
                                           getLength(
                                             ));
                                         insertString(
                                           0,
                                           java.lang.String.
                                             valueOf(
                                               d),
                                           null);
                                     }
                                     catch (javax.swing.text.BadLocationException e) {
                                         
                                     } }
    public double getValue() { try { java.lang.String t =
                                       getText(
                                         0,
                                         getLength(
                                           ));
                                     if (t !=
                                           null &&
                                           t.
                                           length(
                                             ) >
                                           0) {
                                         return java.lang.Double.
                                           parseDouble(
                                             t);
                                     }
                                     else {
                                         return 0;
                                     } }
                               catch (javax.swing.text.BadLocationException e) {
                                   throw new java.lang.Error(
                                     e.
                                       getMessage(
                                         ));
                               } }
    public DoubleDocument() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IgAA");
}
