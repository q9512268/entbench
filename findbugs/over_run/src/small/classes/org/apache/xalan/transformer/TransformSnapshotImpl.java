package org.apache.xalan.transformer;
class TransformSnapshotImpl implements org.apache.xalan.transformer.TransformSnapshot {
    private org.apache.xpath.VariableStack m_variableStacks;
    private org.apache.xml.utils.IntStack m_currentNodes;
    private org.apache.xml.utils.IntStack m_currentExpressionNodes;
    private java.util.Stack m_contextNodeLists;
    private org.apache.xml.dtm.DTMIterator m_contextNodeList;
    private java.util.Stack m_axesIteratorStack;
    private org.apache.xml.utils.BoolStack m_currentTemplateRuleIsNull;
    private org.apache.xml.utils.ObjectStack m_currentTemplateElements;
    private java.util.Stack m_currentMatchTemplates;
    private org.apache.xml.utils.NodeVector m_currentMatchNodes;
    private org.apache.xalan.transformer.CountersTable m_countersTable;
    private java.util.Stack m_attrSetStack;
    boolean m_nsContextPushed;
    private org.apache.xml.serializer.NamespaceMappings m_nsSupport;
    TransformSnapshotImpl(org.apache.xalan.transformer.TransformerImpl transformer) {
        super(
          );
        try {
            org.apache.xml.serializer.SerializationHandler rtf =
              transformer.
              getResultTreeHandler(
                );
            {
                m_nsSupport =
                  (org.apache.xml.serializer.NamespaceMappings)
                    rtf.
                    getNamespaceMappings(
                      ).
                    clone(
                      );
            }
            org.apache.xpath.XPathContext xpc =
              transformer.
              getXPathContext(
                );
            m_variableStacks =
              (org.apache.xpath.VariableStack)
                xpc.
                getVarStack(
                  ).
                clone(
                  );
            m_currentNodes =
              (org.apache.xml.utils.IntStack)
                xpc.
                getCurrentNodeStack(
                  ).
                clone(
                  );
            m_currentExpressionNodes =
              (org.apache.xml.utils.IntStack)
                xpc.
                getCurrentExpressionNodeStack(
                  ).
                clone(
                  );
            m_contextNodeLists =
              (java.util.Stack)
                xpc.
                getContextNodeListsStack(
                  ).
                clone(
                  );
            if (!m_contextNodeLists.
                  empty(
                    ))
                m_contextNodeList =
                  (org.apache.xml.dtm.DTMIterator)
                    xpc.
                    getContextNodeList(
                      ).
                    clone(
                      );
            m_axesIteratorStack =
              (java.util.Stack)
                xpc.
                getAxesIteratorStackStacks(
                  ).
                clone(
                  );
            m_currentTemplateRuleIsNull =
              (org.apache.xml.utils.BoolStack)
                transformer.
                  m_currentTemplateRuleIsNull.
                clone(
                  );
            m_currentTemplateElements =
              (org.apache.xml.utils.ObjectStack)
                transformer.
                  m_currentTemplateElements.
                clone(
                  );
            m_currentMatchTemplates =
              (java.util.Stack)
                transformer.
                  m_currentMatchTemplates.
                clone(
                  );
            m_currentMatchNodes =
              (org.apache.xml.utils.NodeVector)
                transformer.
                  m_currentMatchedNodes.
                clone(
                  );
            m_countersTable =
              (org.apache.xalan.transformer.CountersTable)
                transformer.
                getCountersTable(
                  ).
                clone(
                  );
            if (transformer.
                  m_attrSetStack !=
                  null)
                m_attrSetStack =
                  (java.util.Stack)
                    transformer.
                      m_attrSetStack.
                    clone(
                      );
        }
        catch (java.lang.CloneNotSupportedException cnse) {
            throw new org.apache.xml.utils.WrappedRuntimeException(
              cnse);
        }
    }
    void apply(org.apache.xalan.transformer.TransformerImpl transformer) {
        try {
            org.apache.xml.serializer.SerializationHandler rtf =
              transformer.
              getResultTreeHandler(
                );
            if (rtf !=
                  null) {
                rtf.
                  setNamespaceMappings(
                    (org.apache.xml.serializer.NamespaceMappings)
                      m_nsSupport.
                      clone(
                        ));
            }
            org.apache.xpath.XPathContext xpc =
              transformer.
              getXPathContext(
                );
            xpc.
              setVarStack(
                (org.apache.xpath.VariableStack)
                  m_variableStacks.
                  clone(
                    ));
            xpc.
              setCurrentNodeStack(
                (org.apache.xml.utils.IntStack)
                  m_currentNodes.
                  clone(
                    ));
            xpc.
              setCurrentExpressionNodeStack(
                (org.apache.xml.utils.IntStack)
                  m_currentExpressionNodes.
                  clone(
                    ));
            xpc.
              setContextNodeListsStack(
                (java.util.Stack)
                  m_contextNodeLists.
                  clone(
                    ));
            if (m_contextNodeList !=
                  null)
                xpc.
                  pushContextNodeList(
                    (org.apache.xml.dtm.DTMIterator)
                      m_contextNodeList.
                      clone(
                        ));
            xpc.
              setAxesIteratorStackStacks(
                (java.util.Stack)
                  m_axesIteratorStack.
                  clone(
                    ));
            transformer.
              m_currentTemplateRuleIsNull =
              (org.apache.xml.utils.BoolStack)
                m_currentTemplateRuleIsNull.
                clone(
                  );
            transformer.
              m_currentTemplateElements =
              (org.apache.xml.utils.ObjectStack)
                m_currentTemplateElements.
                clone(
                  );
            transformer.
              m_currentMatchTemplates =
              (java.util.Stack)
                m_currentMatchTemplates.
                clone(
                  );
            transformer.
              m_currentMatchedNodes =
              (org.apache.xml.utils.NodeVector)
                m_currentMatchNodes.
                clone(
                  );
            transformer.
              m_countersTable =
              (org.apache.xalan.transformer.CountersTable)
                m_countersTable.
                clone(
                  );
            if (m_attrSetStack !=
                  null)
                transformer.
                  m_attrSetStack =
                  (java.util.Stack)
                    m_attrSetStack.
                    clone(
                      );
        }
        catch (java.lang.CloneNotSupportedException cnse) {
            throw new org.apache.xml.utils.WrappedRuntimeException(
              cnse);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVaaXAcxRXuXd2yrctYMj5kW5ZJfLCLzWESAcEWMl6zkhZJ" +
                                                              "uIhsWLdme6WxZ2fGM73SSuAYUxAcKkUIGGIS7KoQk4DLYEKFSgIFMbmAMoQy" +
                                                              "UAlHAgR+cKfwDxBHCHndPdfO7izIRSqqmpnemfe63+v33vded+vQe6jCNFCb" +
                                                              "jtUUjtBxnZiRBGsnsGGSVKeCTXMA3ial6/95887JZ2t2hVHlIKobwWa3hE2y" +
                                                              "TiZKyhxE82XVpFiViNlDSIpxJAxiEmMUU1lTB9Es2YxldEWWZNqtpQgj2IiN" +
                                                              "OGrElBryUJaSmNUBRQviXJoolya6xk/QEUfTJU0fdxnm5DF0er4x2ow7nklR" +
                                                              "Q3wrHsXRLJWVaFw2aUfOQMt1TRkfVjQaITka2aqcaU3EhviZBdPQdl/9h5/e" +
                                                              "ONLAp2EmVlWNchXNPmJqyihJxVG9+7ZLIRlzO/oOKoujaR5iitrj9qBRGDQK" +
                                                              "g9r6ulQg/QyiZjOdGleH2j1V6hITiKJF+Z3o2MAZq5sElxl6qKaW7pwZtF3o" +
                                                              "aGub26fiLcuje350ecP9Zah+ENXLaj8TRwIhKAwyCBNKMkPEMNekUiQ1iBpV" +
                                                              "MHg/MWSsyBOWtZtMeVjFNAsuYE8Le5nVicHHdOcKLAm6GVmJaoajXpo7lfWr" +
                                                              "Iq3gYdC12dVVaLiOvQcFa2UQzEhj8D2LpXybrKa4H+VzODq2XwQEwFqVIXRE" +
                                                              "c4YqVzG8QE3CRRSsDkf7wfnUYSCt0MAFDe5rAZ2yudaxtA0PkyRFs/10CfEJ" +
                                                              "qGr4RDAWimb5yXhPYKU5Pit57PNezzk3XKGuV8MoBDKniKQw+acBU6uPqY+k" +
                                                              "iUEgDgTj9GXxW3Hzw7vDCAHxLB+xoPn1lcfPX9F65HFBM7cITe/QViLRpHRg" +
                                                              "qO7YvM6l3yhjYlTrmikz4+dpzqMsYX3pyOmANM1Oj+xjxP54pO/P377qIHkn" +
                                                              "jGpjqFLSlGwG/KhR0jK6rBDjQqISA1OSiqEaoqY6+fcYqoJ2XFaJeNubTpuE" +
                                                              "xlC5wl9Vavw3TFEaumBTVAttWU1rdlvHdIS3czqy/s6Ga6XV5k+KzOiIliFR" +
                                                              "LGFVVrVowtCY/sygHHOICe0UfNW1aA6D05y6NbkquTq5KmoaUlQzhqMYvGKE" +
                                                              "iI9RamDVTGtGhhjRAbvdr2LdHNEog8gIcz79/zNsjs3GzLFQCAw1zw8TCkTY" +
                                                              "ek1JESMp7cmu7Tp+b/KocEEWNtY8UrQKxo6IsSN87Ihn7EjRsVEoxIc8ickg" +
                                                              "/AKsug3wAQB6+tL+yzZs2d1WBg6pj5WDSRjpKQUJq9MFEhv9k9KhY32TTz9V" +
                                                              "ezCMwoA1Q5Cw3KzRnpc1RNIzNImkALaC8oeNodHgjFFUDnRk79iujTtP43J4" +
                                                              "EwHrsAIwjLEnGHw7Q7T7AaBYv/XXvfnh4Vt3aC4U5GUWOyEWcDKEafMb2K98" +
                                                              "Ulq2ED+QfHhHexiVA2wBVFMMoQUo2OofIw9pOmzUZrpUg8LM4Fhhn2yoraUj" +
                                                              "hjbmvuGe18jbJ4GJwyz0WuD6oRWL/Mm+Nuvs3iI8lfmMTwueFc7t1/c9/5e3" +
                                                              "TufTbSeQek/m7ye0wwNarLMmDk+NrgsOGIQA3T/2Jm6+5b3rNnH/A4rFxQZs" +
                                                              "Z/dOACswIUzztY9vf+GVlw88F3Z8FuXydQuX0I25tysGYJ0Cgc+cpf0SFZxR" +
                                                              "Tst4SCEsNv5dv2TlA+/e0CDMr8Ab23tWfHEH7vuT16Krjl4+2cq7CUks17pT" +
                                                              "5ZIJAJ/p9rzGMPA4kyO365n5tz2G90EqAPg15QnCETVkhSsTajZFK74cMhCD" +
                                                              "YQI38OmcNcLvq9gsWXPJfq9mt3bTGyj5segppJLSjc+9P2Pj+48c5yrmV2Je" +
                                                              "v+jGeodwRXZbkoPuW/ygtB6bI0B3xpGezQ3KkU+hx0HoUYLyw+w1AB1zeV5k" +
                                                              "UVdUvfjoH5q3HCtD4XWoVtFwah3mAYlqIBIIIKGSyunfOl94xFg13Bq4qqhA" +
                                                              "eWaEBcXN25XRKTfIxG9afnXOL/a/zB1QuN5czl5nsgLQj528infD/t2XfvL6" +
                                                              "7yZ/ViVqgKXBWOfjm/1JrzJ09WsfFUwyR7ki9YmPfzB66PY5nee9w/lduGHc" +
                                                              "i3OFGQkA2eVddTDzQbit8k9hVDWIGiSrYt6IlSwL4kGoEk27jIaqOu97fsUn" +
                                                              "ypsOB07n+aHOM6wf6NxMCG1GzdozfNhWy6y4FK7VVvyv9mNbCPHGes5yCr8v" +
                                                              "ZbcVIp4oqtINGVZWxAcqNSU6hZVPJjmKDR76UNFL20w7Llu9cclqIjazLp1A" +
                                                              "WnY/m91iYtCOQF9dm69pG1znWkKdG6Bpv9CU3S4qVCmIm6K6TFLKGpB3aA8k" +
                                                              "aUeh+V6FMgqPEzMSU2kxfQamqM8KuCxS8Syiz+aS+gRxQ+ns6NOV0wEVTAge" +
                                                              "rhn7fqlP8MumKPhiuLqsobsCBJdKCh7EDQEEgov1IROXIZDJUMoLNGzZ358d" +
                                                              "MmkfHuOLmaT0/bZrd32t6vhZAmcWFqX2rHtOnzyrfuHBu1RB3l688/wVz2tX" +
                                                              "HL1D+/s7YXs1U4xFUF5kdj/94Po3krxkqGaV4oAdv54acI0x7KlXGpwpmm97" +
                                                              "+pvWFPEnRZu+qiI+o/AEZUYv7gGIsdcI/8vuWe6bW5ApXOM98ODPV+9ecekd" +
                                                              "YmoXBSQJl/63F796bN/E4UOiVmETTNHyoE2Qwp0XVrEuKVF1u27ywYXfPPLW" +
                                                              "6xsvC1uFQh27ZXI2ONS7qdOBg6yTZEPOCqPZ7yyi98qV+z7e+d3ne6EkjqHq" +
                                                              "rCpvz5JYKh/6q8zskMd73PW+mw4s1/kc/kJw/YddzGXYC+E6TZ3W2nehs/jV" +
                                                              "9Rz7TlFoGTR9cJCaIhx8Ha4NlrduCICDnSXhIIibosZCOCiWawCaUzQTuWCg" +
                                                              "O0YJL5x9Ol01RZ3a4eq1pOoN0Gl3SZ2CuCmamUniHDFtSR3fUXwyf2+KMp8G" +
                                                              "14A16kCAzD8oKXMQN0VznXwyQKCmBh/qyyokZvZkFSXIIiJZrtU0pVi2vPEE" +
                                                              "tNtsybc5QLu9JbUL4qbo5ALt2HYr/HQKgYVFdRMVXjHtbjuBGEpb8qUDtPtp" +
                                                              "Se2CuClqcbTrxlQasVU0i/ncHVOUm1Wf9paXHiD3XSXlDuLmceKVO68wW1DU" +
                                                              "HoxkI5EKw//uEzDHqCXYaIBavyypVhA3pA0GaVm202wOsNLYVmlZyUVtp5fF" +
                                                              "p939U9RuAVxXWvJdGaDdgyW1C+LmhTQ7iIGVUiCuPfTlxeUDzoNrpzXgzgBx" +
                                                              "H3XFXVa4PxLEzfOLaloHEomsOUJSZlBBmDDkjEzlUSt9H26e3P7HqokL7OKA" +
                                                              "qzrBap0Sy1xfH9EdTa9su/3Ne0Tl41/T+ojJ7j3Xfx65YY8oe8TBxOKCswEv" +
                                                              "jzicEFWCI92iUqNwjnVvHN7x0F07rhNSNeVvs3ep2cw9f/3sycjeV58osmdb" +
                                                              "NQRwT7DqL4PYz3F/ofH7E4jKayxTXhPgCM+W9NsgboqmMUfoz+q6ZjglxnIf" +
                                                              "yJjW2RSEIytuTfhCurGuy6qo5T2qPVdCtVwxX3X+8s4MPCJ6tl6cfbDI1HbI" +
                                                              "mfnnB50GcdMfuHrP/lTvnSttp36Kohqq6acqZJQoeRIwR/KX9N38DMzdSVn9" +
                                                              "zGTZSzfNnl64Z856ag3YEV8WHD7+AR67+u05A+eNbJnCZvgCn/7+Lu/uPvTE" +
                                                              "hadIN4X5MZ7YuCk4/stn6siv2WsNQrOGml+lt+X7IkubRy1DH/V7sutKQXgW" +
                                                              "xOrb5PTE3hm813+V2AV9n93eoqgCHFoZ5ySPW6DBHk9SVD6qySnXxd/+oujN" +
                                                              "22pkL87PUTSr6LkN24mcXXCaLE5ApXv311e37L/kb/zswDmlnA6L6zRUn96N" +
                                                              "Mk+7UjdIWuaaTRfbZmKd8wlF80pFDSCB5xfX42PB+RlFDX5OmC7+9NCFYMVV" +
                                                              "69JRVCkaXpIyisqAhDXLdTuYG/hyku0cWnVlLuSJOAs1+MzP+qKZd1i8hwws" +
                                                              "mvi5vu352YS1oD68f0PPFcfPulMcckgKnphgvUyD9ac4b3GiZ1Fgb3ZfleuX" +
                                                              "flp3X80SG0EahcCuT8/1+BzIH9KZ7ef4jgLMdudE4IUD5zzy1O7KZyDZbEIh" +
                                                              "DGXhpsI91pyehdDeFC+20ra3IDtqX9/y9Ecvhpr4VrYFYq2lOJLSzY+8lEjr" +
                                                              "+o/DqCaGKgAgSY5vAF8wrvYRadTIW7hXDkGN5vwLQB1zVMzO/PnMWBM6w3nL" +
                                                              "DskoaitM4IUHh7WKNkaMtax3jig+vIGk5f3KZzYnQpfNNPhaMt6t69aGQFiE" +
                                                              "oq6zZ6iFJ+b/AjlSCM68IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qtCuwl+eq3D64M9flbevJ5UH5CBw8gsz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("dxvfVE9M7hvfKml35nRNUnnHhacEy7NPT91xdnl/3lb5+ddvPPTk68K/3x2U" +
       "Oz4T+zBbeUhPHef0qZNTz9eCSNPNHaaH92dQgvLnyrWk8sxb2W9SeeTUW4ng" +
       "ygP7lg8nlZvnW4KJ2v2ervdoUrl+Ui+pXNs/nK5yI6ncB6qUjzeDC5LB+/8w" +
       "bq+csv1D/93N+RPfas6Pm5w+UVf6y+4U+ZFtp+PDUwtfeL3Pff/X0J/Zn+hT" +
       "HLkoyl4eYisP7g8XHvvHi5f2dtTXtd7L33zsFx5+95EvP7YX+MRqT8n2/MXn" +
       "6Cg3SHYn34pfefKff88/ef2Pd7np/wuecOYM3i8AAA==");
}
