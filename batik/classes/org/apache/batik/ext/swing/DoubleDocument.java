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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
