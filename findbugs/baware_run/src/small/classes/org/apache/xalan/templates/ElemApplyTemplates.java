package org.apache.xalan.templates;
public class ElemApplyTemplates extends org.apache.xalan.templates.ElemCallTemplate {
    static final long serialVersionUID = 2903125371542621004L;
    private org.apache.xml.utils.QName m_mode = null;
    public void setMode(org.apache.xml.utils.QName mode) { m_mode = mode;
    }
    public org.apache.xml.utils.QName getMode() { return m_mode; }
    private boolean m_isDefaultTemplate = false;
    public void setIsDefaultTemplate(boolean b) { m_isDefaultTemplate = b;
    }
    public int getXSLToken() { return org.apache.xalan.templates.Constants.
                                        ELEMNAME_APPLY_TEMPLATES; }
    public void compose(org.apache.xalan.templates.StylesheetRoot sroot) throws javax.xml.transform.TransformerException {
        super.
          compose(
            sroot);
    }
    public java.lang.String getNodeName() { return org.apache.xalan.templates.Constants.
                                                     ELEMNAME_APPLY_TEMPLATES_STRING;
    }
    public void execute(org.apache.xalan.transformer.TransformerImpl transformer)
          throws javax.xml.transform.TransformerException {
        transformer.
          pushCurrentTemplateRuleIsNull(
            false);
        boolean pushMode =
          false;
        try {
            org.apache.xml.utils.QName mode =
              transformer.
              getMode(
                );
            if (!m_isDefaultTemplate) {
                if (null ==
                      mode &&
                      null !=
                      m_mode ||
                      null !=
                      mode &&
                      !mode.
                      equals(
                        m_mode)) {
                    pushMode =
                      true;
                    transformer.
                      pushMode(
                        m_mode);
                }
            }
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireTraceEvent(
                    this);
            transformSelectedNodes(
              transformer);
        }
        finally {
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireTraceEndEvent(
                    this);
            if (pushMode)
                transformer.
                  popMode(
                    );
            transformer.
              popCurrentTemplateRuleIsNull(
                );
        }
    }
    public void transformSelectedNodes(org.apache.xalan.transformer.TransformerImpl transformer)
          throws javax.xml.transform.TransformerException {
        final org.apache.xpath.XPathContext xctxt =
          transformer.
          getXPathContext(
            );
        final int sourceNode =
          xctxt.
          getCurrentNode(
            );
        org.apache.xml.dtm.DTMIterator sourceNodes =
          m_selectExpression.
          asIterator(
            xctxt,
            sourceNode);
        org.apache.xpath.VariableStack vars =
          xctxt.
          getVarStack(
            );
        int nParams =
          getParamElemCount(
            );
        int thisframe =
          vars.
          getStackFrame(
            );
        org.apache.xalan.transformer.StackGuard guard =
          transformer.
          getStackGuard(
            );
        boolean check =
          guard.
          getRecursionLimit(
            ) >
          -1
          ? true
          : false;
        boolean pushContextNodeListFlag =
          false;
        try {
            xctxt.
              pushCurrentNode(
                org.apache.xml.dtm.DTM.
                  NULL);
            xctxt.
              pushCurrentExpressionNode(
                org.apache.xml.dtm.DTM.
                  NULL);
            xctxt.
              pushSAXLocatorNull(
                );
            transformer.
              pushElemTemplateElement(
                null);
            final java.util.Vector keys =
              m_sortElems ==
              null
              ? null
              : transformer.
              processSortKeys(
                this,
                sourceNode);
            if (null !=
                  keys)
                sourceNodes =
                  sortNodes(
                    xctxt,
                    keys,
                    sourceNodes);
            if (transformer.
                  getDebug(
                    )) {
                transformer.
                  getTraceManager(
                    ).
                  fireSelectedEvent(
                    sourceNode,
                    this,
                    "select",
                    new org.apache.xpath.XPath(
                      m_selectExpression),
                    new org.apache.xpath.objects.XNodeSet(
                      sourceNodes));
            }
            final org.apache.xml.serializer.SerializationHandler rth =
              transformer.
              getSerializationHandler(
                );
            final org.apache.xalan.templates.StylesheetRoot sroot =
              transformer.
              getStylesheet(
                );
            final org.apache.xalan.templates.TemplateList tl =
              sroot.
              getTemplateListComposed(
                );
            final boolean quiet =
              transformer.
              getQuietConflictWarnings(
                );
            org.apache.xml.dtm.DTM dtm =
              xctxt.
              getDTM(
                sourceNode);
            int argsFrame =
              -1;
            if (nParams >
                  0) {
                argsFrame =
                  vars.
                    link(
                      nParams);
                vars.
                  setStackFrame(
                    thisframe);
                for (int i =
                       0;
                     i <
                       nParams;
                     i++) {
                    org.apache.xalan.templates.ElemWithParam ewp =
                      m_paramElems[i];
                    if (transformer.
                          getDebug(
                            ))
                        transformer.
                          getTraceManager(
                            ).
                          fireTraceEvent(
                            ewp);
                    org.apache.xpath.objects.XObject obj =
                      ewp.
                      getValue(
                        transformer,
                        sourceNode);
                    if (transformer.
                          getDebug(
                            ))
                        transformer.
                          getTraceManager(
                            ).
                          fireTraceEndEvent(
                            ewp);
                    vars.
                      setLocalVariable(
                        i,
                        obj,
                        argsFrame);
                }
                vars.
                  setStackFrame(
                    argsFrame);
            }
            xctxt.
              pushContextNodeList(
                sourceNodes);
            pushContextNodeListFlag =
              true;
            org.apache.xml.utils.IntStack currentNodes =
              xctxt.
              getCurrentNodeStack(
                );
            org.apache.xml.utils.IntStack currentExpressionNodes =
              xctxt.
              getCurrentExpressionNodeStack(
                );
            int child;
            while (org.apache.xml.dtm.DTM.
                     NULL !=
                     (child =
                        sourceNodes.
                          nextNode(
                            ))) {
                currentNodes.
                  setTop(
                    child);
                currentExpressionNodes.
                  setTop(
                    child);
                if (xctxt.
                      getDTM(
                        child) !=
                      dtm) {
                    dtm =
                      xctxt.
                        getDTM(
                          child);
                }
                final int exNodeType =
                  dtm.
                  getExpandedTypeID(
                    child);
                final int nodeType =
                  dtm.
                  getNodeType(
                    child);
                final org.apache.xml.utils.QName mode =
                  transformer.
                  getMode(
                    );
                org.apache.xalan.templates.ElemTemplate template =
                  tl.
                  getTemplateFast(
                    xctxt,
                    child,
                    exNodeType,
                    mode,
                    -1,
                    quiet,
                    dtm);
                if (null ==
                      template) {
                    switch (nodeType) {
                        case org.apache.xml.dtm.DTM.
                               DOCUMENT_FRAGMENT_NODE:
                        case org.apache.xml.dtm.DTM.
                               ELEMENT_NODE:
                            template =
                              sroot.
                                getDefaultRule(
                                  );
                            break;
                        case org.apache.xml.dtm.DTM.
                               ATTRIBUTE_NODE:
                        case org.apache.xml.dtm.DTM.
                               CDATA_SECTION_NODE:
                        case org.apache.xml.dtm.DTM.
                               TEXT_NODE:
                            transformer.
                              pushPairCurrentMatched(
                                sroot.
                                  getDefaultTextRule(
                                    ),
                                child);
                            transformer.
                              setCurrentElement(
                                sroot.
                                  getDefaultTextRule(
                                    ));
                            dtm.
                              dispatchCharactersEvents(
                                child,
                                rth,
                                false);
                            transformer.
                              popCurrentMatched(
                                );
                            continue;
                        case org.apache.xml.dtm.DTM.
                               DOCUMENT_NODE:
                            template =
                              sroot.
                                getDefaultRootRule(
                                  );
                            break;
                        default:
                            continue;
                    }
                }
                else {
                    transformer.
                      setCurrentElement(
                        template);
                }
                transformer.
                  pushPairCurrentMatched(
                    template,
                    child);
                if (check)
                    guard.
                      checkForInfinateLoop(
                        );
                int currentFrameBottom;
                if (template.
                      m_frameSize >
                      0) {
                    xctxt.
                      pushRTFContext(
                        );
                    currentFrameBottom =
                      vars.
                        getStackFrame(
                          );
                    vars.
                      link(
                        template.
                          m_frameSize);
                    if (template.
                          m_inArgsSize >
                          0) {
                        int paramIndex =
                          0;
                        for (org.apache.xalan.templates.ElemTemplateElement elem =
                               template.
                               getFirstChildElem(
                                 );
                             null !=
                               elem;
                             elem =
                               elem.
                                 getNextSiblingElem(
                                   )) {
                            if (org.apache.xalan.templates.Constants.
                                  ELEMNAME_PARAMVARIABLE ==
                                  elem.
                                  getXSLToken(
                                    )) {
                                org.apache.xalan.templates.ElemParam ep =
                                  (org.apache.xalan.templates.ElemParam)
                                    elem;
                                int i;
                                for (i =
                                       0;
                                     i <
                                       nParams;
                                     i++) {
                                    org.apache.xalan.templates.ElemWithParam ewp =
                                      m_paramElems[i];
                                    if (ewp.
                                          m_qnameID ==
                                          ep.
                                            m_qnameID) {
                                        org.apache.xpath.objects.XObject obj =
                                          vars.
                                          getLocalVariable(
                                            i,
                                            argsFrame);
                                        vars.
                                          setLocalVariable(
                                            paramIndex,
                                            obj);
                                        break;
                                    }
                                }
                                if (i ==
                                      nParams)
                                    vars.
                                      setLocalVariable(
                                        paramIndex,
                                        null);
                            }
                            else
                                break;
                            paramIndex++;
                        }
                    }
                }
                else
                    currentFrameBottom =
                      0;
                if (transformer.
                      getDebug(
                        ))
                    transformer.
                      getTraceManager(
                        ).
                      fireTraceEvent(
                        template);
                for (org.apache.xalan.templates.ElemTemplateElement t =
                       template.
                         m_firstChild;
                     t !=
                       null;
                     t =
                       t.
                         m_nextSibling) {
                    xctxt.
                      setSAXLocator(
                        t);
                    try {
                        transformer.
                          pushElemTemplateElement(
                            t);
                        t.
                          execute(
                            transformer);
                    }
                    finally {
                        transformer.
                          popElemTemplateElement(
                            );
                    }
                }
                if (transformer.
                      getDebug(
                        ))
                    transformer.
                      getTraceManager(
                        ).
                      fireTraceEndEvent(
                        template);
                if (template.
                      m_frameSize >
                      0) {
                    vars.
                      unlink(
                        currentFrameBottom);
                    xctxt.
                      popRTFContext(
                        );
                }
                transformer.
                  popCurrentMatched(
                    );
            }
        }
        catch (org.xml.sax.SAXException se) {
            transformer.
              getErrorListener(
                ).
              fatalError(
                new javax.xml.transform.TransformerException(
                  se));
        }
        finally {
            if (transformer.
                  getDebug(
                    ))
                transformer.
                  getTraceManager(
                    ).
                  fireSelectedEndEvent(
                    sourceNode,
                    this,
                    "select",
                    new org.apache.xpath.XPath(
                      m_selectExpression),
                    new org.apache.xpath.objects.XNodeSet(
                      sourceNodes));
            if (nParams >
                  0)
                vars.
                  unlink(
                    thisframe);
            xctxt.
              popSAXLocator(
                );
            if (pushContextNodeListFlag)
                xctxt.
                  popContextNodeList(
                    );
            transformer.
              popElemTemplateElement(
                );
            xctxt.
              popCurrentExpressionNode(
                );
            xctxt.
              popCurrentNode(
                );
            sourceNodes.
              detach(
                );
        }
    }
    public ElemApplyTemplates() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO38bg40BQ/kwYAziy3eF8NHKlGIMBJOzcbGx" +
       "imlzrPfm7IW93WV3zj47oQSiBpK0FIWP0CbwR0OUBhGI2qJWrUKomjYgklIo" +
       "SpMgIA1VkxaQoFIDlLTpe7O7t3t7vkMWqCft3NzOvDfz3vvN+5g7fJ3kGTqp" +
       "0gQlIgRYr0aNQDP2mwXdoJF6WTCMVngbFp/5y67Nt/5UtMVP8tvJkC7BaBQF" +
       "gy6TqBwx2sk4STGYoIjUaKI0ghTNOjWo3i0wSVXayQjJaIhpsiRKrFGNUJzQ" +
       "JughMlRgTJc64ow2WAwYGR/iuwny3QTrvBNqQ6REVLVeh2B0CkG9awznxpz1" +
       "DEbKQuuFbiEYZ5IcDEkGq03oZIamyr2dssoCNMEC6+W5liJWhOamqaHq9dLP" +
       "7u7sKuNqGCYoisq4iMYqaqhyN42ESKnzdqlMY8ZG8h2SEyKDXJMZqQ7ZiwZh" +
       "0SAsasvrzILdD6ZKPFavcnGYzSlfE3FDjExMZaIJuhCz2DTzPQOHQmbJzolB" +
       "2glJaW1ze0TcMyO4+/lHy36aQ0rbSamktOB2RNgEg0XaQaE01kF1oy4SoZF2" +
       "MlQBg7dQXRJkqc+ydrkhdSoCiwMEbLXgy7hGdb6moyuwJMimx0Wm6knxohxU" +
       "1q+8qCx0gqwVjqymhMvwPQhYLMHG9KgA2LNIcjdISoTjKJUiKWP1IzABSAti" +
       "lHWpyaVyFQFekHITIrKgdAZbAHxKJ0zNUwGCOsdaBqaoa00QNwidNMzIKO+8" +
       "ZnMIZhVxRSAJIyO80zgnsNJoj5Vc9rnetGDHY8pyxU98sOcIFWXc/yAgqvQQ" +
       "raJRqlM4ByZhyfTQXqHije1+QmDyCM9kc84vHr+5aGbliZPmnDH9zFnZsZ6K" +
       "LCwe7Bhydmz9tK/m4DYKNdWQ0PgpkvNT1myN1CY08DQVSY44GLAHT6z6/Zon" +
       "DtGrflLcQPJFVY7HAEdDRTWmSTLVH6YK1QVGIw2kiCqRej7eQAqgH5IUar5d" +
       "GY0alDWQXJm/ylf5b1BRFFigioqhLylR1e5rAuvi/YRGCCmAh5TAM4eYH/7N" +
       "iBLsUmM0KIiCIilqsFlXUX40KPc51IB+BEY1NZgQADQ168Ozw/PDs4OGLgZV" +
       "vTMoACq6qDkI88ENgiRGEH1DnabJva32qwDiTvu/r5hAHQzr8fnAPGO9zkGG" +
       "c7VclSNUD4u744uX3jwSPm0CDw+LpT1GamDZgLlsgC8bSC4bSF+W+Hx8teG4" +
       "vAkEMOMGcAjgkUumtXx7xbrtVTmAQK0nF2yAU6ekRah6x3PY7j4sHj676taZ" +
       "d4sP+YkfnEsHRCgnTFSnhAkzyumqSCPgpzIFDNtpBjOHiH73QU7s69nStvnL" +
       "fB9uz48M88BpIXkz+uvkEtXeE98f39Jtn352dO8m1Tn7KaHEjoBplOhSqry2" +
       "9QofFqdPEI6F39hU7Se54KfANzMBzhK4vUrvGimupdZ20yhLIQgcVfWYIOOQ" +
       "7VuLWZeu9jhvOOiGYjPCxB/CwbNB7uG/1qLtf/8Pf3+Ia9IOBqWuKN5CWa3L" +
       "ASGzcu5qhjroatUphXkX9zXv2nN921oOLZgxqb8Fq7GtB8cD1gENfvfkxg8u" +
       "Xzp43u/AkUEEjndAMpPgsgz/Aj4+eP6LDzoNfGE6j/J6y4NNSLowDVee4uwN" +
       "nJkMxxvBUb1aAfBJUUnokCmehc9LJ886dm1HmWluGd7YaJl5bwbO+y8tJk+c" +
       "fvRWJWfjEzGYOvpzppkeepjDuU7XhV7cR2LLuXE/fFvYD74e/Ksh9VHuMgnX" +
       "B+EGnMN1EeTtQ56xedhUG26Mpx4jV9ITFneevzG47cbxm3y3qVmT2+6NglZr" +
       "osi0AnF95rq/cbRCw3ZkAvYw0ut0lgtGFzCbc6LpW2XyibuwbDssK0I+YazU" +
       "wfElUqBkzc4r+PA3v61YdzaH+JeRYlkVIssEfuBIESCdGl3gMxPa1xeZ++gp" +
       "hKaM64OkaQiVPr5/cy6NaYwboO+XI3++4JUDlzgKTdiN4eQ5BmZ0Xt/I03Ln" +
       "WF+78MKVN2+9VGAG9WmZfZmHbtS/V8odWz++nWYJ7sX6STg89O3Bwy+Orl94" +
       "ldM77gSpJyXSgw04XId29qHYv/xV+b/zk4J2UiZaKXCbIMfxJLdD2mfYeTGk" +
       "ySnjqSmcma/UJt3lWK8rcy3rdWROkIM+zsb+YA/qhqIVF8Izz0LdPC/qeLAb" +
       "wk2MWwqEVMgpn/3rznd+MOky6GYFyevGfYNKypxJTXFMs586vGfcoN0fPcsN" +
       "P7XhTvXFr5wOIdflfP3JvJ2KzQyOBz84J4Mn7AxEkRRBTiQ3yuFWlmWjUB4Z" +
       "PJNvg/we7Ly6YQk/tC54YfXWEu8wWLMuxcDhdlu55dGKWxvfKuhbYueN/ZGY" +
       "Mx8xGs/8avknYe7QCzFEt9qKdQXfOr3TFSjKsKnB05sFvJ4dBTeVX97w4qev" +
       "mTvyItUzmW7f/cwXgR27TUdr1g+T0lJ4N41ZQ3h2NzHbKpxi2SdHN/36J5u2" +
       "mbsqT82Gl0Kx99p7/3knsO+jU/0kWbky4CbpPnzJ3KjCq21TpvxZ++9sfur9" +
       "lRDMG0hhXJE2xmlDJBXUBUa8w6V+pzRxgG5JhzGNEd90TbPiNbbzsWkwEVab" +
       "0dktTiKwGN9WwrPAQuCCtKNCeCfSP7oh9BZoutQNcdSBtR95FGVhCkciFkZg" +
       "cZJRUMS5s9WYzJVvBL7RZOnFJRsdoGwBeNZY21iTQTbVlA2bznQhMlEzMiwW" +
       "lowlNCrEZZZMpXGsxcIffrW5+u2grQ5VlamgeFGDP9d5DallETaRwSDYnenY" +
       "gn/yiaeIconhCl0ET8y4THUuPy0Ht+4+EFn58iy/lUisZRBeVa1Gpt1UdrEq" +
       "5GfPGwUbeXXvhJT5527lXHhuVEl6cYCcKjOk/tMzexzvAm9v/cfo1oVd6waQ" +
       "9Y/3yO9l+Wrj4VMPTxGf8/MLCjOCpV1spBLVph7xYp2yuK6kHuqqpMUQc2Qi" +
       "PPWWxeq9sHVQwjH7eCpmC7OQelJCF/Y2cK7fy5Iz7sBmGyAYavhG++x60J3b" +
       "rUoRB7/b73VYU7IufLGIv34yKVEpDlXA02hJ1DhwZWQizSLrC1nG9mOzF/TQ" +
       "aeqBa8+R+fn7lpkDoAYeydq4NHCZM5FmBgDjXF/JIvir2PyYkeF4qeP1ezi2" +
       "09HCS/ethcE4NIpgzWZ+2MC1kIk0i5A/yzJ2DJsjjAwCy3+zJdSqbqDKvfx9" +
       "jmRdE6f5ekdZRx8MZGbAs9mSePPAlZWJtH/I2JF7WpZ7phbWK0PhRSlbpaom" +
       "vt7Kzm0qv/7iKQDTIUjitUWg1e5RfWlCpBo6cM7sJDZvwknEW0nV8GLwxH2r" +
       "lU8eA8/Tlm6eHrhaM5Fmwdn5LGPvYXPGxGATeB9MkWztuWoV85rc0cUfHwzE" +
       "ZsOz1xJo78B1kYk0OyhmpkPMQYQbHfiHFt/Fx5nd3Ck+4W/YXATk0AQV42ne" +
       "69KD0VYdPKcskU8NXFuZSDMLd4VzvXEv6f+JzVVGKpJ6bKF4w0EjTXZcdynj" +
       "2sCVkYCCP/2SGa9VRqX912X+PyMeOVBaOPLA6j/zi87kfyglUJBG47Lsrvpd" +
       "/XxNp1GJy1Ri3gGYtdAdT0WR6pcwZbX7XIDbJtXncIK8VFCz82/3PKi6ip15" +
       "UMuYHdcUHxT9OTAFuzmajeMZ97iSrxdk2VZWwpealyetMeJe1nCl8pNSEmX+" +
       "Z6Sd1MbNvyPD4tEDK5oeuznvZfM2V5SFvj7kMggqUfPOOJkYT8zIzeaVv3za" +
       "3SGvF022i4OU22T33jhIAJL85nW053rTqE7ecn5wcMHxd7fnn4PSey3xCVBx" +
       "rU2/R0poccja14b6q7mhbOA3r7XFV9aduf2hr5zf2hCzSq/MRhEWdx2/0BzV" +
       "tB/5SVEDyYPahyb4JdeSXmUVFbv1lBI+v0ONK8n/LYcgfgX0wFwzlkIHJ9/i" +
       "RT8jVenXGel/fhTLag/VFyN3ZDPYU0rENc09yjUbxqYmgZoGGIZDjZpm3X/7" +
       "v881r2l4TH0V+GPd/wD4OfzPcSAAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
