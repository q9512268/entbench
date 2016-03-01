package org.apache.xpath.operations;
public class Variable extends org.apache.xpath.Expression implements org.apache.xpath.axes.PathComponent {
    static final long serialVersionUID = -4334975375609297049L;
    private boolean m_fixUpWasCalled = false;
    protected org.apache.xml.utils.QName m_qname;
    protected int m_index;
    public void setIndex(int index) { m_index = index; }
    public int getIndex() { return m_index; }
    public void setIsGlobal(boolean isGlobal) { m_isGlobal = isGlobal; }
    public boolean getGlobal() { return m_isGlobal; }
    protected boolean m_isGlobal = false;
    public void fixupVariables(java.util.Vector vars, int globalsSize) { m_fixUpWasCalled =
                                                                           true;
                                                                         int sz =
                                                                           vars.
                                                                           size(
                                                                             );
                                                                         for (int i =
                                                                                vars.
                                                                                size(
                                                                                  ) -
                                                                                1;
                                                                              i >=
                                                                                0;
                                                                              i--) {
                                                                             org.apache.xml.utils.QName qn =
                                                                               (org.apache.xml.utils.QName)
                                                                                 vars.
                                                                                 elementAt(
                                                                                   i);
                                                                             if (qn.
                                                                                   equals(
                                                                                     m_qname)) {
                                                                                 if (i <
                                                                                       globalsSize) {
                                                                                     m_isGlobal =
                                                                                       true;
                                                                                     m_index =
                                                                                       i;
                                                                                 }
                                                                                 else {
                                                                                     m_index =
                                                                                       i -
                                                                                         globalsSize;
                                                                                 }
                                                                                 return;
                                                                             }
                                                                         }
                                                                         java.lang.String msg =
                                                                           org.apache.xalan.res.XSLMessages.
                                                                           createXPATHMessage(
                                                                             org.apache.xpath.res.XPATHErrorResources.
                                                                               ER_COULD_NOT_FIND_VAR,
                                                                             new java.lang.Object[] { m_qname.
                                                                               toString(
                                                                                 ) });
                                                                         javax.xml.transform.TransformerException te =
                                                                           new javax.xml.transform.TransformerException(
                                                                           msg,
                                                                           this);
                                                                         throw new org.apache.xml.utils.WrappedRuntimeException(
                                                                           te);
    }
    public void setQName(org.apache.xml.utils.QName qname) {
        m_qname =
          qname;
    }
    public org.apache.xml.utils.QName getQName() {
        return m_qname;
    }
    public org.apache.xpath.objects.XObject execute(org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        return execute(
                 xctxt,
                 false);
    }
    public org.apache.xpath.objects.XObject execute(org.apache.xpath.XPathContext xctxt,
                                                    boolean destructiveOK)
          throws javax.xml.transform.TransformerException {
        org.apache.xml.utils.PrefixResolver xprefixResolver =
          xctxt.
          getNamespaceContext(
            );
        org.apache.xpath.objects.XObject result;
        if (m_fixUpWasCalled) {
            if (m_isGlobal)
                result =
                  xctxt.
                    getVarStack(
                      ).
                    getGlobalVariable(
                      xctxt,
                      m_index,
                      destructiveOK);
            else
                result =
                  xctxt.
                    getVarStack(
                      ).
                    getLocalVariable(
                      xctxt,
                      m_index,
                      destructiveOK);
        }
        else {
            result =
              xctxt.
                getVarStack(
                  ).
                getVariableOrParam(
                  xctxt,
                  m_qname);
        }
        if (null ==
              result) {
            warn(
              xctxt,
              org.apache.xpath.res.XPATHErrorResources.
                WG_ILLEGAL_VARIABLE_REFERENCE,
              new java.lang.Object[] { m_qname.
                getLocalPart(
                  ) });
            result =
              new org.apache.xpath.objects.XNodeSet(
                xctxt.
                  getDTMManager(
                    ));
        }
        return result;
    }
    public org.apache.xalan.templates.ElemVariable getElemVariable() {
        org.apache.xalan.templates.ElemVariable vvar =
          null;
        org.apache.xpath.ExpressionNode owner =
          getExpressionOwner(
            );
        if (null !=
              owner &&
              owner instanceof org.apache.xalan.templates.ElemTemplateElement) {
            org.apache.xalan.templates.ElemTemplateElement prev =
              (org.apache.xalan.templates.ElemTemplateElement)
                owner;
            if (!(prev instanceof org.apache.xalan.templates.Stylesheet)) {
                while (prev !=
                         null &&
                         !(prev.
                             getParentNode(
                               ) instanceof org.apache.xalan.templates.Stylesheet)) {
                    org.apache.xalan.templates.ElemTemplateElement savedprev =
                      prev;
                    while (null !=
                             (prev =
                                prev.
                                  getPreviousSiblingElem(
                                    ))) {
                        if (prev instanceof org.apache.xalan.templates.ElemVariable) {
                            vvar =
                              (org.apache.xalan.templates.ElemVariable)
                                prev;
                            if (vvar.
                                  getName(
                                    ).
                                  equals(
                                    m_qname)) {
                                return vvar;
                            }
                            vvar =
                              null;
                        }
                    }
                    prev =
                      savedprev.
                        getParentElem(
                          );
                }
            }
            if (prev !=
                  null)
                vvar =
                  prev.
                    getStylesheetRoot(
                      ).
                    getVariableOrParamComposed(
                      m_qname);
        }
        return vvar;
    }
    public boolean isStableNumber() { return true;
    }
    public int getAnalysisBits() { org.apache.xalan.templates.ElemVariable vvar =
                                     getElemVariable(
                                       );
                                   if (null !=
                                         vvar) {
                                       org.apache.xpath.XPath xpath =
                                         vvar.
                                         getSelect(
                                           );
                                       if (null !=
                                             xpath) {
                                           org.apache.xpath.Expression expr =
                                             xpath.
                                             getExpression(
                                               );
                                           if (null !=
                                                 expr &&
                                                 expr instanceof org.apache.xpath.axes.PathComponent) {
                                               return ((org.apache.xpath.axes.PathComponent)
                                                         expr).
                                                 getAnalysisBits(
                                                   );
                                           }
                                       }
                                   }
                                   return org.apache.xpath.axes.WalkerFactory.
                                            BIT_FILTER;
    }
    public void callVisitors(org.apache.xpath.ExpressionOwner owner,
                             org.apache.xpath.XPathVisitor visitor) {
        visitor.
          visitVariableRef(
            owner,
            this);
    }
    public boolean deepEquals(org.apache.xpath.Expression expr) {
        if (!isSameClass(
               expr))
            return false;
        if (!m_qname.
              equals(
                ((org.apache.xpath.operations.Variable)
                   expr).
                  m_qname))
            return false;
        if (getElemVariable(
              ) !=
              ((org.apache.xpath.operations.Variable)
                 expr).
              getElemVariable(
                ))
            return false;
        return true;
    }
    static final java.lang.String PSUEDOVARNAMESPACE =
      "http://xml.apache.org/xalan/psuedovar";
    public boolean isPsuedoVarRef() { java.lang.String ns =
                                        m_qname.
                                        getNamespaceURI(
                                          );
                                      if (null !=
                                            ns &&
                                            ns.
                                            equals(
                                              PSUEDOVARNAMESPACE)) {
                                          if (m_qname.
                                                getLocalName(
                                                  ).
                                                startsWith(
                                                  "#"))
                                              return true;
                                      }
                                      return false;
    }
    public Variable() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0afXAU1f3d5TtAEoJ8yDchoHzdFVCYEmrJFxC8JCcJKQ3V" +
       "y2bvJVnY211295ILFhVmVNSOpYrWWuEPiy0yKI5Tp6Ij0lGrDliLtfX7u1O1" +
       "akc6o7HVan+/t7u3e3u3izdkejP7dm/f+/3e7+v9Pt7bI5+QIk0lNQonxbmQ" +
       "PqxQLRTF5yinajTeKHKa1glvY/yN79x69cify3YFSXE3qRjgtFae0+hagYpx" +
       "rZvMECRN5ySeam2UxhEiqlKNqoOcLshSN5koaC0JRRR4QW+V4xQHdHFqhIzn" +
       "dF0VepM6bTER6GRWhFETZtSE690D6iJkLC8rwzbA1AyARkcfjk3Y82k6qYps" +
       "5Qa5cFIXxHBE0PS6lEoWKbI43C/Keoim9NBW8WJTEBsiF2eJoeaBys+/3DtQ" +
       "xcQwgZMkWWcsahupJouDNB4hlfbbZpEmtO3kKlIQIWMcg3VSG7EmDcOkYZjU" +
       "4tceBdSPo1Iy0SgzdnQLU7HCI0E6mZOJROFULmGiiTKaAUOpbvLOgIHb2Wlu" +
       "LXW7WLxtUXjfz6+oerCAVHaTSkHqQHJ4IEKHSbpBoDTRS1WtPh6n8W4yXgKF" +
       "d1BV4ERhh6ntak3olzg9CSZgiQVfJhWqsjltWYEmgTc1yeuymmavjxmV+a+o" +
       "T+T6gddJNq8Gh2vxPTBYLgBhah8HtmeCFG4TpDizo0yINI+1l8IAAC1JUH1A" +
       "Tk9VKHHwglQbJiJyUn+4A4xP6oehRTKYoMpszQMpylrh+G1cP43pZIp7XNTo" +
       "glFlTBAIopOJ7mEME2hpqktLDv180rb65iul9VKQBIDmOOVFpH8MAM10AW2k" +
       "fVSlsA4MwLELI7dzkx7bEyQEBk90DTbG/O7HZ9YsnnniGWPMtBxj2nu3Ul6P" +
       "8Qd7K05Pb1zw3QIko1SRNQGVn8E5W2VRs6cupYCnmZTGiJ0hq/PExj/88JrD" +
       "9KMgKW8hxbwsJhNgR+N5OaEIIlXXUYmqnE7jLaSMSvFG1t9CSuA5IkjUeNve" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ay9Q+iOKbjpxP/NwjI1o17KRYCVuTXVSF2vkhG/surbV5dM2byN+31C7AOml" +
       "nBjPuybKuuM54RpuS1GaoxmNGaPNYFVvjpYGhahmmySxZnuyrPKsm7rLXA83" +
       "yNTBAmOkzqZyc6a7OW4sNzsUpwKMGLq1RReMynodK2oLmw5Y0HUTeDUISUgl" +
       "2ISvk+4COGcNDlPQzLd3QQOKOq6zoWcdoz6r9sFaRqz1lOWq744ZtpOyS3HS" +
       "mCxXQ960cYoY1H3XbifD9nLK51tGJG3WmHXpHaRsJ+3mGGbsWm5Pudmu3x4p" +
       "bDvbGSONWFvOdDuqDrp6xKzdhVDLkRGXjDMVNNiwaWsrmLLa9tb5UnYX2iDy" +
       "UJZgzDETOisBHnqj8aJhQwuVENPqNF4tlUhcLvW8SWYBO0jhVZNkccVimw11" +
       "uWq3vXha31hEup4Qwo7TfAHx+ghYcizF+jw0MCddrHrNXgvaoHDWMQ0p4pIh" +
       "OubZtanSLIVHjRTNmG6zY6k0GY1yi8ZVut8aw52UNCf0mDJEeh0OnT6k8nOC" +
       "cNH1rM/Vt2zYqq8cwllYQsK5IVhyKyO5a+FElDFafbcdedakilOdaJUNbBJE" +
       "cSnTjdvt0POGVgQmuBCFd6Iy74g6H3HWdm2lnCeDOHI16ERYPQtCmzDiYYg4" +
       "aXvbo9MmmEmb6bTZMmSDFkKRH7j5YOTGPDN3hXzoT7PlPBFRZ7bUHXykNGFi" +
       "sTHcoBZRCWfL2Eqf9DO4qZshMmvQyWzYz5ygT82i/mqsmzNlNJ1E/mhjej2d" +
       "WzQVZ8DoBLkypvJgpdW4QZdjVDrH2GWdCwa8hLdHI7wF2ZktNCzGH1pkbbLu" +
       "DeM8Wwmp6rEDctsRbZsZjNEqvUoQxg8b63luzMGcPlnQIKbRIUy3dQ9dD9Wl" +
       "H7VarR8tXp393Ft7ffdg+Vbx+OzN3+F94r7omSJ54crN7DsrZ85rnHqNe2rD" +
       "7+DoNetzV51ckNLyDFRsFu89fU/z4mLT5cnrHb8pN1w+/7FXXlX5L6DnDjdV" +
       "+bhyd+wH73e0reacGvYC6Om9199c4srT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("RyebfV//2P96fPZj5ktv4TjDU2foPNvlv+Fe+53uu5SfO1e57Xjr76pzUVc2" +
       "unTlht89oRYnoTe7YtvvyWMt3F0I/RlwkYdaIM++TD/R87Xf8L9nbydn9qwP" +
       "Tip4ZYUv3WBT+7Ui+UJcuas4/3O9zYzbt76lntjbv3qzt8SnBykz/uUx0/cV" +
       "mQ+Diz1kmr01TJ/m6Ws3KPvVIvllwK9xyG8pphPevnoTvJUKLXb0hEPehFuu" +
       "ULGs8Fs3YPDrRfJ6XHlbodBTuz5fPuHxN26CxxI+ir2/lw55fOnW6+8bNyj7" +
       "z0XyBgANoL9TW1onzP2Hm1VgB1zJIXPJrWHu3H5X64od6SshbSLtSpy8rHxt" +
       "/O1vfC7/ymv7DWdZAmqsQNc78Xr1odviHNULNzgLdnIW8s+7H3j9T/9Y+PAR" +
       "Er/tWAxPFly//0ZiuHLrrdwsF7TidEmR/8cnyPPNG2jyfxTJH8SV+3UrTYKj" +
       "o2/RGVv9w5tV53PgevWQj1dvuT/u8eN7N2DzfxfJd/YAe7x7fYrBP7sJBsvt" +
       "2EfB9cVDBr94653xr29Q9jdF8pd7MD3mTTvh7a9uFmiKrfqvHfL2tVuqvCML" +
       "fvKqqGa5j2jKI9tFDwd33biH95RHQ8szCnEoeVFxtPDi7OhOC6lU0YIiFik7" +
       "u7dIbosr57VUU5L4+LjD01efCy2PHUUXl/vzR8dSPbj9Vkj1jUOpvnFrpHru" +
       "eN/+4O4SkEtmH7+u4xzcV1Z4okgePpFG8XgS2B48chOcokUmaHdw+77t/v+W" +
       "+sbBu25QVkTzB8/ElQvAN4ovG64AOMDyu08rvDgZcTHW3MCRgElcvKp+KY1n" +
       "b1bvTwHGLh1K49Ktl0b9BmVYkcAA7K1oGhds7Q+nlaZywiFys4HlE4DYziGH" +
       "nVvP4YduUEYWyaW9vlue5GSRFZHW3m1P4suDD97sfNatFMc/9yyKt9R5rw9F" +
       "VBqEWlQcaeF3nha+CXYKVmSBUKCUCnsDiU2KpBtX7lUkxzlsdGb6P+jdrM2/" +
       "A3AuHYpLujXiOoP/77iBuEo+f+IGMnipSBZx5R5V0wJqk0j7NfApn1jeCq/f" +
       "HUpgd+t9Yn2DsiI2P9BKrx+Vx74AqE00/QyH+lvhMAXRxhE0Fue8H7vqk6z9" +
       "Z0TKl1+9cNejr85/v/xS4PhTn7vZyl164jinj+Weur8TKA6Eo2XN/SHdoGQk" +
       "upaaTz7cAPo7eShIPgj37bYgRD7bLq7cUf6frpcVPRzXiyt37m9OV/mpuHIb" +
       "qFLcvlwo7+DD6d4EHzut+zLseujNBHrc5PTHA8VaofwM7uh9SDI6XJJ85dXB" +
       "8CPfx76w/3hBcaQ8L3q5i62c339HUXZavFN55rq9HfV1Z+/FH9z/S3e/cLTq" +
       "uH9P8IkdnqLtqWt/HUC5QVye589/5dFf/uC/fvWPyqPN/w+4Kzr6nzgAAA==");
}
