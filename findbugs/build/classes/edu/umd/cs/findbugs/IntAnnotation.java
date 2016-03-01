package edu.umd.cs.findbugs;
public class IntAnnotation implements edu.umd.cs.findbugs.BugAnnotation {
    private static final long serialVersionUID = 1L;
    private static final java.lang.String DEFAULT_ROLE = "INT_DEFAULT";
    private final int value;
    private java.lang.String description;
    public static final java.lang.String INT_SYNC_PERCENT = "INT_SYNC_PERCENT";
    public static final java.lang.String INT_OCCURRENCES = "INT_OCCURRENCES";
    public static final java.lang.String INT_VALUE = "INT_VALUE";
    public static final java.lang.String INT_MIN_VALUE = "INT_MIN_VALUE";
    public static final java.lang.String INT_MAX_VALUE = "INT_MAX_VALUE";
    public static final java.lang.String INT_SHIFT = "INT_SHIFT";
    public static final java.lang.String INT_EXPECTED_ARGUMENTS = "INT_EXPECTED_ARGUMENTS";
    public static final java.lang.String INT_ACTUAL_ARGUMENTS = "INT_ACTUAL_ARGUMENTS";
    public static final java.lang.String INT_OBLIGATIONS_REMAINING = "INT_OBLIGATIONS_REMAINING";
    public IntAnnotation(int value) { super();
                                      this.value = value;
                                      this.description = DEFAULT_ROLE; }
    @java.lang.Override
    public java.lang.Object clone() { try { return super.clone(); }
                                      catch (java.lang.CloneNotSupportedException e) {
                                          throw new java.lang.AssertionError(
                                            e);
                                      } }
    public int getValue() { return value; }
    @java.lang.Override
    public void accept(edu.umd.cs.findbugs.BugAnnotationVisitor visitor) {
        visitor.
          visitIntAnnotation(
            this);
    }
    @java.lang.Override
    public java.lang.String format(java.lang.String key, edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        if ("hash".
              equals(
                key)) {
            if (isSignificant(
                  )) {
                return java.lang.Integer.
                  toString(
                    value);
            }
            else {
                return "";
            }
        }
        return getShortInteger(
                 value);
    }
    public static java.lang.String getShortInteger(int value) {
        java.lang.String base16 =
          java.lang.Integer.
          toHexString(
            value);
        int unique =
          uniqueDigits(
            base16);
        java.lang.String base10 =
          java.lang.Integer.
          toString(
            value);
        if (unique <=
              3 &&
              base16.
              length(
                ) -
              unique >=
              3 &&
              base10.
              length(
                ) >
              base16.
              length(
                )) {
            return "0x" +
            base16;
        }
        return base10;
    }
    public static java.lang.String getShortInteger(long value) {
        java.lang.String base16 =
          java.lang.Long.
          toHexString(
            value);
        int unique =
          uniqueDigits(
            base16);
        java.lang.String base10 =
          java.lang.Long.
          toString(
            value);
        if (unique <=
              3 &&
              base16.
              length(
                ) -
              unique >=
              3 &&
              base10.
              length(
                ) >
              base16.
              length(
                )) {
            return "0x" +
            base16;
        }
        return base10;
    }
    private static int uniqueDigits(java.lang.String value) {
        java.util.Set<java.lang.Character> used =
          new java.util.HashSet<java.lang.Character>(
          );
        for (int i =
               0;
             i <
               value.
               length(
                 );
             i++) {
            used.
              add(
                value.
                  charAt(
                    i));
        }
        return used.
          size(
            );
    }
    @java.lang.Override
    public void setDescription(java.lang.String description) {
        this.
          description =
          description;
    }
    @java.lang.Override
    public java.lang.String getDescription() { return description;
    }
    @java.lang.Override
    public int hashCode() { return value; }
    @java.lang.Override
    public boolean equals(java.lang.Object o) { if (!(o instanceof edu.umd.cs.findbugs.IntAnnotation)) {
                                                    return false;
                                                }
                                                return value ==
                                                  ((edu.umd.cs.findbugs.IntAnnotation)
                                                     o).
                                                    value;
    }
    @java.lang.Override
    public int compareTo(edu.umd.cs.findbugs.BugAnnotation o) {
        if (!(o instanceof edu.umd.cs.findbugs.IntAnnotation)) {
            return this.
              getClass(
                ).
              getName(
                ).
              compareTo(
                o.
                  getClass(
                    ).
                  getName(
                    ));
        }
        return value -
          ((edu.umd.cs.findbugs.IntAnnotation)
             o).
            value;
    }
    @java.lang.Override
    public java.lang.String toString() { java.lang.String pattern =
                                           edu.umd.cs.findbugs.I18N.
                                           instance(
                                             ).
                                           getAnnotationDescription(
                                             description);
                                         edu.umd.cs.findbugs.FindBugsMessageFormat format =
                                           new edu.umd.cs.findbugs.FindBugsMessageFormat(
                                           pattern);
                                         return format.
                                           format(
                                             new edu.umd.cs.findbugs.BugAnnotation[] { this },
                                             null);
    }
    private static final java.lang.String
      ELEMENT_NAME =
      "Int";
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput)
          throws java.io.IOException { writeXML(
                                         xmlOutput,
                                         false,
                                         false);
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean addMessages,
                         boolean isPrimary)
          throws java.io.IOException { edu.umd.cs.findbugs.xml.XMLAttributeList attributeList =
                                         new edu.umd.cs.findbugs.xml.XMLAttributeList(
                                         ).
                                         addAttribute(
                                           "value",
                                           java.lang.String.
                                             valueOf(
                                               value));
                                       java.lang.String role =
                                         getDescription(
                                           );
                                       if (!DEFAULT_ROLE.
                                             equals(
                                               role)) {
                                           attributeList.
                                             addAttribute(
                                               "role",
                                               role);
                                       }
                                       edu.umd.cs.findbugs.BugAnnotationUtil.
                                         writeXML(
                                           xmlOutput,
                                           ELEMENT_NAME,
                                           this,
                                           attributeList,
                                           addMessages);
    }
    @java.lang.Override
    public boolean isSignificant() { return !INT_SYNC_PERCENT.
                                       equals(
                                         description) &&
                                       !INT_OCCURRENCES.
                                       equals(
                                         description);
    }
    @java.lang.Override
    public java.lang.String toString(edu.umd.cs.findbugs.ClassAnnotation primaryClass) {
        return toString(
                 );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EQJ8IDcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "iOluWbCjmPxgQlXVTbPntDBP64LnL69p");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "7g+KL5j+H9CIzXSRQQAA");
}
