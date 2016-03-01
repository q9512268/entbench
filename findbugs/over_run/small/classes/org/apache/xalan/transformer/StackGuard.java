package org.apache.xalan.transformer;
public class StackGuard {
    private int m_recursionLimit = -1;
    org.apache.xalan.transformer.TransformerImpl m_transformer;
    public int getRecursionLimit() { return m_recursionLimit; }
    public void setRecursionLimit(int limit) { m_recursionLimit = limit; }
    public StackGuard(org.apache.xalan.transformer.TransformerImpl transformerImpl) {
        super(
          );
        m_transformer =
          transformerImpl;
    }
    public int countLikeTemplates(org.apache.xalan.templates.ElemTemplate templ,
                                  int pos) { org.apache.xml.utils.ObjectStack elems =
                                               m_transformer.
                                               getCurrentTemplateElements(
                                                 );
                                             int count = 1;
                                             for (int i =
                                                    pos -
                                                    1; i >=
                                                         0;
                                                  i--) { if ((org.apache.xalan.templates.ElemTemplateElement)
                                                               elems.
                                                               elementAt(
                                                                 i) ==
                                                               templ)
                                                             count++;
                                             }
                                             return count;
    }
    private org.apache.xalan.templates.ElemTemplate getNextMatchOrNamedTemplate(int pos) {
        org.apache.xml.utils.ObjectStack elems =
          m_transformer.
          getCurrentTemplateElements(
            );
        for (int i =
               pos;
             i >=
               0;
             i--) {
            org.apache.xalan.templates.ElemTemplateElement elem =
              (org.apache.xalan.templates.ElemTemplateElement)
                elems.
                elementAt(
                  i);
            if (null !=
                  elem) {
                if (elem.
                      getXSLToken(
                        ) ==
                      org.apache.xalan.templates.Constants.
                        ELEMNAME_TEMPLATE) {
                    return (org.apache.xalan.templates.ElemTemplate)
                             elem;
                }
            }
        }
        return null;
    }
    public void checkForInfinateLoop() throws javax.xml.transform.TransformerException {
        int nTemplates =
          m_transformer.
          getCurrentTemplateElementsCount(
            );
        if (nTemplates <
              m_recursionLimit)
            return;
        if (m_recursionLimit <=
              0)
            return;
        for (int i =
               nTemplates -
               1;
             i >=
               m_recursionLimit;
             i--) {
            org.apache.xalan.templates.ElemTemplate template =
              getNextMatchOrNamedTemplate(
                i);
            if (null ==
                  template)
                break;
            int loopCount =
              countLikeTemplates(
                template,
                i);
            if (loopCount >=
                  m_recursionLimit) {
                java.lang.String idIs =
                  org.apache.xalan.res.XSLMessages.
                  createMessage(
                    null !=
                      template.
                      getName(
                        )
                      ? "nameIs"
                      : "matchPatternIs",
                    null);
                java.lang.Object[] msgArgs =
                  new java.lang.Object[] { new java.lang.Integer(
                  loopCount),
                idIs,
                null !=
                  template.
                  getName(
                    )
                  ? template.
                  getName(
                    ).
                  toString(
                    )
                  : template.
                  getMatch(
                    ).
                  getPatternString(
                    ) };
                java.lang.String msg =
                  org.apache.xalan.res.XSLMessages.
                  createMessage(
                    "recursionTooDeep",
                    msgArgs);
                throw new javax.xml.transform.TransformerException(
                  msg);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/g+2o8Q5LScAAA==");
}
