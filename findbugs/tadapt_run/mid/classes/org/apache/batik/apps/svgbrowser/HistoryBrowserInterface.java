package org.apache.batik.apps.svgbrowser;
public class HistoryBrowserInterface {
    private static final java.lang.String ATTRIBUTE_ADDED_COMMAND = "Attribute added: ";
    private static final java.lang.String ATTRIBUTE_REMOVED_COMMAND = "Attribute removed: ";
    private static final java.lang.String ATTRIBUTE_MODIFIED_COMMAND = "Attribute modified: ";
    private static final java.lang.String NODE_INSERTED_COMMAND = "Node inserted: ";
    private static final java.lang.String NODE_REMOVED_COMMAND = "Node removed: ";
    private static final java.lang.String CHAR_DATA_MODIFIED_COMMAND = "Node value changed: ";
    private static final java.lang.String OUTER_EDIT_COMMAND = "Document changed outside DOM Viewer";
    private static final java.lang.String COMPOUND_TREE_NODE_DROP = "Node moved";
    private static final java.lang.String REMOVE_SELECTED_NODES = "Nodes removed";
    protected org.apache.batik.apps.svgbrowser.HistoryBrowser historyBrowser;
    protected org.apache.batik.apps.svgbrowser.AbstractCompoundCommand currentCompoundCommand;
    public HistoryBrowserInterface(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController commandController) {
        super(
          );
        historyBrowser =
          new org.apache.batik.apps.svgbrowser.HistoryBrowser(
            commandController);
    }
    public void setCommmandController(org.apache.batik.apps.svgbrowser.HistoryBrowser.CommandController newCommandController) {
        historyBrowser.
          setCommandController(
            newCommandController);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createCompoundUpdateCommand(java.lang.String commandName) {
        org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand cmd =
          new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          commandName);
        return cmd;
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodeChangedCommand(org.w3c.dom.Node node) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          getNodeChangedCommandName(
            node));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createNodesDroppedCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          COMPOUND_TREE_NODE_DROP);
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand createRemoveSelectedTreeNodesCommand(java.util.ArrayList nodes) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CompoundUpdateCommand(
          REMOVE_SELECTED_NODES);
    }
    public void performCompoundUpdateCommand(org.apache.batik.apps.svgbrowser.UndoableCommand command) {
        historyBrowser.
          addCommand(
            command);
    }
    public static class CompoundUpdateCommand extends org.apache.batik.apps.svgbrowser.AbstractCompoundCommand {
        public CompoundUpdateCommand(java.lang.String commandName) {
            super(
              );
            setName(
              commandName);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+b17fuep33zlO9kVwv8AAJocxgodAAA=");
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowser getHistoryBrowser() {
        return historyBrowser;
    }
    public void nodeInserted(org.w3c.dom.Node newParent,
                             org.w3c.dom.Node newSibling,
                             org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeInsertedCommand(
              newParent,
              newSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand createNodeInsertedCommand(org.w3c.dom.Node newParent,
                                                                                                                  org.w3c.dom.Node newSibling,
                                                                                                                  org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeInsertedCommand(
          NODE_INSERTED_COMMAND +
          getBracketedNodeName(
            contextNode),
          newParent,
          newSibling,
          contextNode);
    }
    public static class NodeInsertedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node newSibling;
        protected org.w3c.dom.Node newParent;
        protected org.w3c.dom.Node contextNode;
        public NodeInsertedCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              newParent =
              parent;
            this.
              contextNode =
              contextNode;
            this.
              newSibling =
              sibling;
        }
        public void execute() {  }
        public void undo() { newParent.removeChild(
                                         contextNode);
        }
        public void redo() { if (newSibling !=
                                   null) {
                                 newParent.
                                   insertBefore(
                                     contextNode,
                                     newSibling);
                             }
                             else {
                                 newParent.
                                   appendChild(
                                     contextNode);
                             } }
        public boolean shouldExecute() { if (newParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "pM2pfwENxTC92BsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "k36Bbw4HhUAl2CYrMHDHbkzxJprD8HqeKdrdui4yc24RM5LdbXY4Pi5GlXWM" +
           "zI1Bb9RQpnAlR/GCYzlcmUDnrC32ipzNsZOw06eK5bCj1Vm3KFQV3SuRJYdQ" +
           "KF83GgyPqrE+oRh0qY+pDkXlm0sVHWq02gjQFlEWuQY70W2y6rZRFTXWjcqk" +
           "K8ewD3MVlOD1hby0okKdj4r1QETNqodXplhitAbJ0NA8adJoroNmwoyGlbXU" +
           "tVphvWqpXINr9gkNn1isOqj73KSl2exQ5AYqGWqdJrOYz/vxlFl6jcSGGa+P" +
           "rKpIj1lYYnnW7k5QnurXDaTDaJYRL5DZgFYifIz0PC2XizC7omLNNozMZsNu" +
           "a5lrc34J9mDRayXCdK3Jis7n5zg35jplVECHKldWKWw8VMqFXmsxmpkMUhBG" +
           "GElU3P7S4aptlF2R4yXaWOM5sV3zbaSAlNHAc4lW0DDlqGBbhldyBIrtFiuW" +
           "qFWtXo7uq77coyPF6welCsJzo3WQFMB+e13hBjWTHlRsu9IbMwnmiYUkXpaJ" +
           "JN8raQMGbjhVJCyKXg1fqZOK4cdDMop5zbVicdWL5vQaEaOo1fIX1Z7qq5Iu" +
           "D5eYYDBLdzIiC6YBJhTZsxaLGF1wttroTYRaczaOyHZ3tWxjsTLg4A5r5hXa" +
           "6gWOsoILqDrIFZurIgJzw269lvP7s1ytHjYIouID96Q5hF0wlMyWe/UiL88K" +
           "Gsawo4W/DrFSF67P2zGJUS2bHjmLItqMO1Om4Y6ZWsHk3CHZbdqjRQ91rMZK" +
           "d/FOnqMqnYluYKrN1qe+zQc5tsgwjCeQUn82JxEi8SqEieBOb7GQ/ZzRiXK0" +
           "vizWa73WlE6KcsSMivUcH82Ha5uMZhOkbeYn/ASvmtMqJ2gKgwoYIiNrTx07" +
           "YG88Z4qouNZVfMh7YqPb9hK5PSanYz5X48WINWNkWu5g1QI2tlVr0LUJaURy" +
           "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" +
           "7/qPb//DN374ma9m1wj/C1fY8z/+JgAA");
    }
    public void nodeRemoved(org.w3c.dom.Node oldParent,
                            org.w3c.dom.Node oldSibling,
                            org.w3c.dom.Node contextNode) {
        historyBrowser.
          addCommand(
            createNodeRemovedCommand(
              oldParent,
              oldSibling,
              contextNode));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand createNodeRemovedCommand(org.w3c.dom.Node oldParent,
                                                                                                                org.w3c.dom.Node oldSibling,
                                                                                                                org.w3c.dom.Node contextNode) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.NodeRemovedCommand(
          NODE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextNode),
          oldParent,
          oldSibling,
          contextNode);
    }
    public static class NodeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldSibling;
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node contextNode;
        public NodeRemovedCommand(java.lang.String commandName,
                                  org.w3c.dom.Node oldParent,
                                  org.w3c.dom.Node oldSibling,
                                  org.w3c.dom.Node contextNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              oldParent;
            this.
              contextNode =
              contextNode;
            this.
              oldSibling =
              oldSibling;
        }
        public void execute() {  }
        public void undo() { if (oldSibling !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     contextNode,
                                     oldSibling);
                             }
                             else {
                                 oldParent.
                                   appendChild(
                                     contextNode);
                             } }
        public void redo() { oldParent.removeChild(
                                         contextNode);
        }
        public boolean shouldExecute() { if (oldParent ==
                                               null ||
                                               contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nTbn/gWW6wgQ1hsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6U3/4K7fe9NHn/tafovwvyyO/a/8JgAA");
    }
    public void attributeAdded(org.w3c.dom.Element contextElement,
                               java.lang.String attributeName,
                               java.lang.String newAttributeValue,
                               java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeAddedCommand(
              contextElement,
              attributeName,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand createAttributeAddedCommand(org.w3c.dom.Element contextElement,
                                                                                                                      java.lang.String attributeName,
                                                                                                                      java.lang.String newAttributeValue,
                                                                                                                      java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeAddedCommand(
          ATTRIBUTE_ADDED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeAddedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String newValue;
        protected java.lang.String namespaceURI;
        public AttributeAddedCommand(java.lang.String commandName,
                                     org.w3c.dom.Element contextElement,
                                     java.lang.String attributeName,
                                     java.lang.String newAttributeValue,
                                     java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              newValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "0ScAAA==");
    }
    public void attributeRemoved(org.w3c.dom.Element contextElement,
                                 java.lang.String attributeName,
                                 java.lang.String prevAttributeValue,
                                 java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeRemovedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand createAttributeRemovedCommand(org.w3c.dom.Element contextElement,
                                                                                                                          java.lang.String attributeName,
                                                                                                                          java.lang.String prevAttributeValue,
                                                                                                                          java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeRemovedCommand(
          ATTRIBUTE_REMOVED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          namespaceURI);
    }
    public static class AttributeRemovedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevValue;
        protected java.lang.String namespaceURI;
        public AttributeRemovedCommand(java.lang.String commandName,
                                       org.w3c.dom.Element contextElement,
                                       java.lang.String attributeName,
                                       java.lang.String prevAttributeValue,
                                       java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevValue =
              prevAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevValue);
        }
        public void redo() { contextElement.
                               removeAttributeNS(
                                 namespaceURI,
                                 attributeName);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "jb21nDteegW9g4cobRZnYPkmP1h1C+YI0N15vu/eOuX8TVhxCFYUAbLNfgMw" +
           "NeOJLou6rOKNF37auP1yCQpuQNWKJkgbBHZQURWcEGyOABxn9M/exSNkjIZM" +
           "HVMV5ShPfTI/v7e7Ujph/pn4YdPza7597BoLTB6Jcxh7qUlLSD+msnuAAwfv" +
           "Xf3GWz+Z/FYFryLaCmOgj2/23/qVxEN//DDHyAz98lQ4Pv6hyKmnmjvXvsv4" +
           "HRii3IsyuXkMgNrhXXEy9Zdga/nPgqhiCNWJVs29VVDS9HAPQZ1p2oU41OWe" +
           "eW/NyAukjizMzvVDoGtbPwA6+RP6lJr2p/swj1UqbQADFRYcVPgxL4BYZxNj" +
           "WcLaNtossyGmSjc0AlJiyYcy9UWWJWiGyG8BrhO3iuMrbTtoE+ULri0YiV1e" +
           "PT4OG9VYG9YU0GMz14M2fbniFuImaHr2dtlnmbXdJ+2WKUq7CPapt/arLyDt" +
           "tqLSFuJmPsGjLJ7ySXrvFCWlObHR2quxgKSJopIW4iaohkapCXUd3jLQk09Y" +
           "sYiwmfxBGaTdOyD5mey66YRlqS2Ppy53Jz8HnBDF23mFrk7s2nf8ocPHpP4T" +
           "yzk0NXivI11w237mN//4ZfjI71/OU8+WW1dfLxouzEHDXnatdKBl1ZXJkquP" +
           "za7JLS7pSi0FSselhWHTv8GFh/7cvHntyPYpVI3zfVbyL/l076mX71kiPhZk" +
           "N2OOZDk3ai9Thxe/qg1M0oa62YNird7KbR74c4Xl1xX+KHWCioXo0tx6qBBr" +
           "kaz/QJG5B2kzRuBemcEioIZZNHfFDDkFReGodbuO7G54c+dT7zzDA8ufqHzE" +
           "+MDhRz4KHzzMg4y/VyzKeTJw8/A3CyZmHTfER/AXgM8/6YfqQAfoN6SjTuvi" +
           "vCB7c9b1DIvVImKxLTa8fXr3j7+ze3/QsolGUOmoJkvO4c7cCok8tQYd6GTD" +
           "ptf1zeC3dst/7VN3fSHWIu79apG5Q7T5MuiaViX2QPAFR+Gv/O8UXm1JvXrq" +
           "ChdiLaLU0SJz36TNEVDYwDkKP/lfK9xEp0Ig7VpL6rVTV7gQaxGlni4y913a" +
           "HIeiAErltCJ1ZY94yI3f9HV6MJ0wie/Anm6c3PVixcTd9rtYPhZOucnsvfSj" +
           "7rfjDIsrKdhnEdAF9OuMYdd9to42X+RW3+vqPwxYlNA0BQtqVqdA9mmj0S8F" +
           "F6B8+dG/7nn4tX64i/egyrQq70rjHsmLzRVmOuESy3mSdJDakomCCkGBpbp1" +
           "C2ABcmLqAZIhqKnAq459qfvUf/pcBLaYnfOqzV9ixWeP1VY2HdvyW/YykX0t" +
           "rQHXJNOK4i63Xf1yKMWSMjNDDS++dfZ1jqAFtxKSoGrnB1PtLGd+gaBZeZnh" +
           "ENIvN+2LcPf10xJUxr7ddBdgN4cOKhTecZP8gqASIKHdi/q/b+p1ENAG3DC3" +
           "AB7yuz/zVSbgLbeyITHrViHhqtAWeZIq+7eFHcVp/o8LOHDHNvbdf+OTJ/jL" +
           "jKgIExN0lWkQu/yRKFvJLCy4mr1WeXfbzRnPVS22c1o9F9iBoDkunOiEw6XT" +
           "K3Kz79nCDGVfL14/vubcKwfKr0D63oYCAkEzt+VeADN6GsqsbdF8pxTqPPai" +
           "0lH91vZLH74RaGD3bOtctxTjiIuHzl2NJXX960FU1YPKIGXjDLud3j2uDmBx" +
           "1PAc+vKEllaz/+GYQeNfoA8pzDKWQadnR+nLHkGtuYVI7mtntaKNYWM9Xd0C" +
           "EU/tl9Z19yyz7PMcUailISbj0V5dt0uW7zPL6zrDimu0OfMvWn5qs5scAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "cXcL5Qf/B673Ulsc+j/69ief0gcfQw6O7rw3MXTL0QP6Xs7NQMwrr3+70S9e" +
           "qfcXsV94+7/cP35s/qZn8UT1ojNKnhX58f4nv9R9mfZrB9BNV65lr3o/P93p" +
           "0dOXsbeHRpyE3vjUlewDp5+JHgDmrByZtXL2Mm4/n9e+iXvFzh9u8J7wvhvU" +
           "vT9P3h1DF4zU0JJ495YVnnCcdQzdvPZtfe9R73mm+5WTYxQF7zoN934As34E" +
           "t/7Th/sbN6j7aJ58BEBKPL147/7gHtdTPw1crz7C9eqfPq5P36Dus3nycYAr" +
           "NK7C9Yn/A6778sLLAM9jR7ge++nj+oMb1P1Rnnwuhu6M5n7i6OT1nfTCzPcd" +
           "Q/X2uH/32eBOY+i+6zyuHz/tNX/SV3vAYi+46sdFux/EaJ9+6uKt9z0l/nXx" +
           "Pn3lRyu3sdCtZuI4Jx91TuRvCULDtAsD3bZ74gmKjy/G0EPPpGQM3b7/UkD7" +
           "wq7zl2Po+dfsDLwq/zjZ9qsxdOls2xg6X3yebPc1MNq+HaD4XeZkk6/H0E2g" +
           "SZ79y+DHNzU2y2/ntFgEcbx7AS7mKj13ehm64gz3PJMznFi5Hj615BS/Hjte" +
           "HpLd78ce1z7zVI978/cbH9u9z2tgt7DNpdzKQhd2PxW4ssS8+LrSjmXdQj3y" +
           "w7s+e9tLj9fCu3YK7yPrhG4vuvZjOOkGcfF8vf39+37nNb/51DeKJ4f/BdYX" +
           "I/jWJwAA");
    }
    public void attributeModified(org.w3c.dom.Element contextElement,
                                  java.lang.String attributeName,
                                  java.lang.String prevAttributeValue,
                                  java.lang.String newAttributeValue,
                                  java.lang.String namespaceURI) {
        historyBrowser.
          addCommand(
            createAttributeModifiedCommand(
              contextElement,
              attributeName,
              prevAttributeValue,
              newAttributeValue,
              namespaceURI));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand createAttributeModifiedCommand(org.w3c.dom.Element contextElement,
                                                                                                                            java.lang.String attributeName,
                                                                                                                            java.lang.String prevAttributeValue,
                                                                                                                            java.lang.String newAttributeValue,
                                                                                                                            java.lang.String namespaceURI) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AttributeModifiedCommand(
          ATTRIBUTE_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextElement),
          contextElement,
          attributeName,
          prevAttributeValue,
          newAttributeValue,
          namespaceURI);
    }
    public static class AttributeModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Element contextElement;
        protected java.lang.String attributeName;
        protected java.lang.String prevAttributeValue;
        protected java.lang.String newAttributeValue;
        protected java.lang.String namespaceURI;
        public AttributeModifiedCommand(java.lang.String commandName,
                                        org.w3c.dom.Element contextElement,
                                        java.lang.String attributeName,
                                        java.lang.String prevAttributeValue,
                                        java.lang.String newAttributeValue,
                                        java.lang.String namespaceURI) {
            super(
              );
            setName(
              commandName);
            this.
              contextElement =
              contextElement;
            this.
              attributeName =
              attributeName;
            this.
              prevAttributeValue =
              prevAttributeValue;
            this.
              newAttributeValue =
              newAttributeValue;
            this.
              namespaceURI =
              namespaceURI;
        }
        public void execute() {  }
        public void undo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 prevAttributeValue);
        }
        public void redo() { contextElement.
                               setAttributeNS(
                                 namespaceURI,
                                 attributeName,
                                 newAttributeValue);
        }
        public boolean shouldExecute() { if (contextElement ==
                                               null ||
                                               attributeName.
                                               length(
                                                 ) ==
                                               0) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVZfWwUxxWfO9vnD4y/CLZrwIA5qAzkrpRQ2prSgGNiw/mj" +
           "NiDVpDn2dsf2wt7usjtrn50QAlEAgYpQMClNA61U0rSUBBQVBTWF0jRpiGiC" +
           "oFGbBDVpG1VJmyCFPxqnpW36Znb39uM+qNtKtXRzczPvzbz35r3fezM+eR0V" +
           "6RpqUjlZ4CJkVMV6pIf2ezhNx0KrxOn6ehiN8/t+f2jHxK9KdwZRqB9VDHF6" +
           "J8/peI2IJUHvR7NEWSeczGO9C2OBcvRoWMfaMEdERe5H00W9I6lKIi+STkXA" +
           "lGAjp8VQNUeIJiYMgjusBQiaHWPSRJk00VV+gpYYKucVddRhaPAwtLrmKG3S" +
           "2U8nqCq2hRvmogYRpWhM1ElLSkOLVEUaHZQUEsEpEtkiLbMMsTa2LMMMTacr" +
           "P7p5cKiKmWEaJ8sKYSrqvVhXpGEsxFClM9om4aS+DT2ACmJoiouYoHDM3jQK" +
           "m0ZhU1tfhwqkn4plI9mqMHWIvVJI5alABM31LqJyGpe0lulhMsMKJcTSnTGD" +
           "tnPS2trH7VPx8KLo+DfurXqmAFX2o0pR7qPi8CAEgU36waA4mcCavkoQsNCP" +
           "qmU48D6siZwkjlmnXaOLgzJHDHAB2yx00FCxxvZ0bAUnCbppBk8ULa3eAHMq" +
           "61fRgMQNgq61jq6mhmvoOChYJoJg2gAHvmexFG4VZYH5kZcjrWN4HRAAa3ES" +
           "kyElvVWhzMEAqjFdROLkwWgfOJ88CKRFCrigxnwtx6LU1irHb+UGcZygej9d" +
           "jzkFVKXMEJSFoOl+MrYSnFKD75Rc53O9a8WB++R2OYgCILOAeYnKPwWYGn1M" +
           "vXgAaxjiwGQsXxh7lKs9tzeIEBBP9xGbNM/ef+POxY0XLpo0M7LQdCe2YJ7E" +
           "+eOJiiszW5u/UEDFKFEVXaSH79GcRVmPNdOSUgFpatMr0smIPXmh9xdfffAE" +
           "fj+IyjpQiFckIwl+VM0rSVWUsHY3lrHGESx0oFIsC61svgMVQz8mytgc7R4Y" +
           "0DHpQIUSGwop7DeYaACWoCYqg74oDyh2X+XIEOunVIRQDXxQHULB+xH7M78J" +
           "Go0OKUkc5XhOFmUl2qMpVH96oAxzsA59AWZVJZoA/996+5LI8qiuGBo4ZFTR" +
           "BqMceMUQNifhh6pH9eHBhKaMAD5G2wGDFG10tfmzw3blCHVB9f+5eYpaZtpI" +
           "IACHNtMPGRJQtSuSgLU4P26sbrvxdPyS6Y40hCybEvQVkCBiShBhEkSoBBFH" +
           "gkgOCcJp1IdsIQIewJEnk6AzCgSYRLdREU0XAgfYClACC5U3931t7ea9TQXg" +
           "u+pIIZweJV2QkdtaHcyxE0WcP3mld+LyK2UngigIsJSA3OYkmLAnwZj5UVN4" +
           "LADC5Uo1NtxGcyeXrHKgC0dGdm7c8Rkmhztn0AWLAO4oew9F+vQWYT9WZFu3" +
           "cs97H516dLvioIYnCdm5M4OTglGT//z9ysf5hXO4M/Fz28NBVAgIB6hOOIhC" +
           "AMxG/x4eUGqxAZ7qUgIKDyhakpPolI3KZWQIvMMZYY5Zzfq3wRFX0ij9NITr" +
           "k1bYsm86W6vSts50ZOozPi1YAvlSn3r09Vf/tJSZ2841la4ioQ+TFhe+0cVq" +
           "GJJVOy64XsMY6H57pOfQ4et7NjH/A4p52TYM0xa8mSZrMPPDF7e98fZbx18L" +
           "Oj5LIMEbCaiVUmklS6hOFXmUpH7uyAP4KAFMUK8Jb5CTLIS4hIRpkPy9cv6S" +
           "Mx8cqDL9QIIR240W33oBZ/xTq9GDl+6daGTLBHianx2bOWQm6E9zVl6ladwo" +
           "lSO18+qsb77EHYX0AZCti2OYoXCI2SDENK+Hco1x0lQcMVOxPTGNQsvIUj4i" +
           "KMkILbOwzBRZ5mvY6d/BuKKsXUotxzZBbO6LtAnr7ijyBqqrIIvzB1/7cOrG" +
           "D8/fYGp7Kzq303Ryaovpp7SZn4Ll6/yI1c7pQ0B3x4Wue6qkCzdhxX5YkQfg" +
           "1rs1QNaUx8Us6qLiN3/289rNVwpQcA0qkxROWMOxaEWlECZYHwJQTqlfvtN0" +
           "kxHqN1VMVZShPD2Y2dmPvC2pEnZIY2frfrTiyWNvMe803XEGY6eXhjkZwMpu" +
           "Aw4mfHDtW+/8dOK7xWYt0ZwbCH189X/rlhK7/vBxhpEZBGapc3z8/dGTjze0" +
           "rnyf8TtYRLnnpTKzGaC1w/vZE8m/BJtCLwZRcT+q4q3KeyMnGTTC+6Ha1O1y" +
           "HKpzz7y3cjTLpJY01s7046BrWz8KOlkU+pSa9qf6gI/VK82ABTstTNjpB74A" +
           "Yp11jGUBa5tps9jGmVJVUwhIiQUf1FTnWZagCt68C7jCbrkJsrRtoU3MXHBl" +
           "Tk9s8+pBAXy3teHuHHqsN/WgTVemuLm4CZqavmN2WWZd5pN2wySlXQz77Lf2" +
           "259D2k15pc3FDT6kang4Xf4wx8om8j2TFHkRbHbQ2vRgDpETeUXOxU3oFXDk" +
           "1hLzk5R4Aex12NrzcA6JxbwS5+ImqJwGmA6FKd7Q25FN2C15hE1lj6cg7d4O" +
           "yVtn92UnogpteTwXC3fydnAV0VQxK9fdj91bj+8aPyZ0P7HERNUa732qTTaS" +
           "T/36H7+MHPndy1kK8pB1d3c2LIT95mYAeSe7FzuouPzqRMG1R+rLM4tjulJj" +
           "jtJ3YW7E92/w0q4/N6xfObR5ElXvbJ+V/Ev+oPPky3cv4B8Jsqu9CcIZTwJe" +
           "phYv9JZpmBiavN4DwE3eynMWnOcZ61zP+L3UcSrmogsz67lcrHkKlofyzD1M" +
           "mwcIXIxTmIdg1POm3R5NTEJRO2w9D0S317y99fH3njIdy59jfcR47/i+TyIH" +
           "xk0nMx9c5mW8ebh5zEcXJmaVaYhP4C8An3/SD9WBDtBvQMFW6+Y/J331V9UU" +
           "89U8YrEt1rx7avtz39++J2jZZJigwmFFFJzg3nErJPKUSXSglQ2PeY++Ac7t" +
           "rHV+Zyd/9LlY8xzvkTxzj9HmEOhqyAJ74djnKDz+v1P4nCX1uckrnIs1j1LH" +
           "88x9jzbfBoU1nKHwd/5rhevoVBikfd6S+vnJK5yLNY9Sp/PMPUObH0I9A1W+" +
           "IQlt6RAPu/GbPq/3GQmd+AL2VO3EtheKx+6yH/aysZiU6/TOyz9ufzfOsLiE" +
           "gn0aAV1Av0obdN3Hq2iz37T6Hlf/64BFCUWRMCendQqkn2Zq/VKYAoSWHP3r" +
           "jt2vdwdRYQcqMWRxm4E7BC82F+tGwiWW86bqILUlEwUVggILVesCwxzk5OQd" +
           "JEVQfa5nKftW+vn/9MELjFGf8S5vviXzTx+rLKk7tuE37Gkl/d5bDmczYEiS" +
           "+6rg6oegjBwQmR3KzYuDyr5eJGjOrYQkqMz5wVR7wWS+SND0rMwQhfTLTXsJ" +
           "Lu9+WoKK2Leb7lXYzaGDEsXsuEmuEFQAJLR7Vf33Tb0KPFqD2/EGAETz8YKd" +
           "VSrgrbfSPjH9Vj7hKtHmebIq+8eL7caG+a8XiLhja7vuu/G5J8ynJV7ixsbo" +
           "KlPAec1XrnQpMzfnavZaofbmmxWnS+fbSa3aFNjBoBkuoGiF6FLp9b7B9+6i" +
           "h9PPL28cX3H+lb2hq5C/N6EAR9C0TZmX15RqQJ21KZYtTKHQY09CLWXvbL78" +
           "8ZuBGvZGYAV2Yz6OOH/o/LWeAVV9LIhKO1AR5GycYjfru0blXswPa56oDyUU" +
           "Q07/j6aC+j9HX4KYZSyDTk2P0qdJgpoyK5HM59oySRnB2mq6uoUinuLPUFX3" +
           "LLPscyakUEuDT8Zjnapq1yzPMsurKgOLP9LmJ/8CxSb+gV0dAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void charDataModified(org.w3c.dom.Node contextNode,
                                 java.lang.String oldValue,
                                 java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createCharDataModifiedCommand(
              contextNode,
              oldValue,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand createCharDataModifiedCommand(org.w3c.dom.Node contextNode,
                                                                                                                          java.lang.String oldValue,
                                                                                                                          java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.CharDataModifiedCommand(
          CHAR_DATA_MODIFIED_COMMAND +
          getBracketedNodeName(
            contextNode),
          contextNode,
          oldValue,
          newValue);
    }
    public static class CharDataModifiedCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String oldValue;
        protected java.lang.String newValue;
        public CharDataModifiedCommand(java.lang.String commandName,
                                       org.w3c.dom.Node contextNode,
                                       java.lang.String oldValue,
                                       java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              oldValue =
              oldValue;
            this.
              newValue =
              newValue;
        }
        public void execute() {  }
        public void undo() { contextNode.
                               setNodeValue(
                                 oldValue);
        }
        public void redo() { contextNode.
                               setNodeValue(
                                 newValue);
        }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "ldgPOwo//r9TeI4l9Zw7VzgfawGljhaYO0abb4PCBs5R+NB/rXATnQqBtK2W" +
           "1K13rnA+1gJK/aDA3AnaHCeoGpLOtCJ1Zq94yI3f9H23Px03ie/Cnm2c2v1S" +
           "2dh6+2VpOhZOucnsufBC1weDDIvLKdhnEdAF9GuNIVdFWEubcX7qo67+HsCi" +
           "uKYpWFCzOgWyjwONfim4AKXLj/99z+Nv9UE1243K06q8O427JS82l5npuEss" +
           "51HPQWpLJgoqBAWW6lY+zRxk4s4dJENQU553Ebss+tJnfXCBs2jOeRfmb5ni" +
           "mYma8qaJrW+y2j773lgFpkmkFcWduLr6pbqBEzI7hiqexurs6zmCWm8nJEGV" +
           "zg+m2s858wsENUzLDJeQfrlpz1lFopuWoBL27aabhN0cOshQeMdN8iJBRUBC" +
           "uy/p//lRrwWHNqBW2wp4yKtnZqtMwJtuZV2i4XYu4crQFnqCKnv4t704zZ/+" +
           "4cJNbOx96NoXn+ZvG6IijI3RVWaA7/JnlmwmsyDvavZapV1Lbs58pmKRHdPq" +
           "uMAOBM124UQHXC6dFpstvsLfDGXr/7dPrD7/+v7SSxC+t6OAQNCs7bmlVEZP" +
           "Q5q1PTrdLYU8j71JtFe+v+PCp+8E6lnFat3reYU4BsXD5y/HErr+vSCq6EYl" +
           "ELJxhtV560fVzVgcNjyXvjSupdXs/whmUv8X6FMEOxnrQKuzo/RtjKC23EQk" +
           "970QivkRbKyjq1sg4sn90rrunmUne5ojCj1p8MnBaI+u2ynL8+zkdZ1hxZu0" +
           "OfNvMzc0ut0bAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVae6wjV3mfvbvZ3SxJdhPIo2neWSiJ6R3P2B7bClDsmfFj" +
           "xvZ4xh4/BspmPG973g97PDQtoLaJSpVGbQhUhfzRgigoENQWtVJFFdQHUCgS" +
           "FepLKqCqUmkpEvkDWkHb9Mz43ut77z4CaaRe6R4fn/Od73y/c77vd15+7jvQ" +
           "dYEP5VzHXGumE+4qcbg7N0u74dpVgl2qU+qLfqDIuCkGwRCUXZIe+PT57//w" +
           "Kf3CDnRagF4r2rYTiqHh2AGnBI65VOQOdH5bSpqKFYTQhc5cXIpwFBom3DGC" +
           "8JEO9JpDTUPoYmffBBiYAAMT4MwEuLaVAo1uVOzIwtMWoh0GHvTz0IkOdNqV" +
           "UvNC6P6jSlzRF609Nf0MAdBwNv0+AqCyxrEP3XeAfYP5MsDvz8FPf+CdF37v" +
           "JHRegM4b9iA1RwJGhKATAbrBUqyZ4gc1WVZkAbrZVhR5oPiGaBpJZrcA3RIY" +
           "mi2Gka8cDFJaGLmKn/W5HbkbpBSbH0mh4x/AUw3FlPe/Xaeaogaw3rbFukHY" +
           "SMsBwHMGMMxXRUnZb3JqYdhyCN17vMUBxos0EABNz1hKqDsHXZ2yRVAA3bKZ" +
           "O1O0NXgQ+oatAdHrnAj0EkJ3XlVpOtauKC1ETbkUQnccl+tvqoDU9dlApE1C" +
           "6NbjYpkmMEt3HpulQ/Pznd6bn3yX3bJ3MptlRTJT+8+CRvcca8QpquIrtqRs" +
           "Gt7wcOcZ8bbPPrEDQUD41mPCG5k//LkX3/ame174wkbmJ68gw8zmihRekj4y" +
           "u+mrd+EPVU+mZpx1ncBIJ/8I8sz9+3s1j8QuiLzbDjSmlbv7lS9wfzF99yeU" +
           "b+9A59rQackxIwv40c2SY7mGqfhNxVZ8MVTkNnS9Yst4Vt+GzoB8x7CVTSmj" +
           "qoEStqFTZlZ02sm+gyFSgYp0iM6AvGGrzn7eFUM9y8cuBEG3gH/odgja+S6U" +
           "/W0+Q2gN646lwKIk2obtwH3fSfGnE2rLIhwqAcjLoNZ14Bnw/8VPI7tlOHAi" +
           "Hzgk7PgaLAKv0JVNJfjiBnCw1Ga+swoUH24BcnD8dX3ztb3vyrupC7r/n53H" +
           "6chcWJ04ASbtruOUYQKplmPKin9Jejqqky9+6tKXdg5CaG9MQ6gPLNjdWLCb" +
           "WbCbWrC7tWD3KhZcxHXRJ8RQ7DqyAegAzLhlAcjQiROZQa9LLdx4EJj/BWAS" +
           "oOeGhwY/Sz36xAMngeu6q1Ng8lJR+OpUj2+5p50xrAQCAHrhg6v3jH4hvwPt" +
           "HOXsFBUoOpc276dMe8CoF4/H6pX0nn/8W99//pnHnG3UHlkE9sjk8pYpGTxw" +
           "fPx9R1JkQK9b9Q/fJ37m0mcfu7gDnQIMA1g1FEEUAMK653gfR0jhkX2CTbFc" +
           "BwCrjm+JZlq1z4rnQh3MzrYkc4ybsvzNYIzPp1HyBgg6eeMmbDafae1r3TR9" +
           "3caR0kk7hiIj8LcM3A//3Vf+tZAN9z7Xnz+0eg6U8JFD/JIqO58xyc1bHxj6" +
           "igLk/vGD/d94/3cef3vmAEDiwSt1eDFNgTuliyUY5l/6gvf33/j6R762s3Wa" +
           "ECyw0cw0pPgA5NkU003XAAl6e8PWHsBPJgjT1Gsu8raV+bA4M5XUS//r/OuR" +
           "z/z7kxc2fmCCkn03etPLK9iW/0QdeveX3vkf92RqTkjp+rgds63YhnRfu9Vc" +
           "831xndoRv+ev7/7Nz4sfBvQNKDMwEiVjwVPZGJzKkN8K9jFZy3Qp3N0shQcV" +
           "aWivCtKu7Fi7PUfOgj6fJdmEw5ngw1m6mw5WphfK6kppcm9wOHCOxuahPdAl" +
           "6amvfffG0Xf/5MUM6dFN1GE/6YruIxvXTJP7YqD+9uMs0RIDHcgVX+i944L5" +
           "wg+BRgFolABXBowPyCw+4lV70ted+YfP/eltj371JLTTgM6Zjig3xCxAoetB" +
           "ZCiBDngwdn/mbRvPWKWuciGDCl0GfuNQd2TfTgMDH7o6NzXSPdA2vO/4AWPO" +
           "3vtP/3nZIGSsdIWl/1h7AX7uQ3fib/121n5LD2nre+LLCR7sF7dt0U9Y39t5" +
           "4PSf70BnBOiCtLcZHYlmlAadADZgwf4OFWxYj9Qf3Uxtdg6PHNDfXcep6VC3" +
           "x4lpu7CAfCqd5s8d46JsCX8QLN3f21vCv3eci05AWQbPmtyfpRfT5Kf2Q/96" +
           "13dCYKUi70X/S+DvBPj/n/Q/VZcWbHYGt+B725P7DvYnLlj1XiNttsr7UYFu" +
           "CDBNsTQhNpqrV3WZtx4F9AAA8oM9QD+4CqDuVQCl2WY2Sq0QOgs8NZuWg1g9" +
           "ZFXvFVj10p5VL13FquGPZJWtrK5qFf+yVmVa4hNg6q5Dd8u7mYK3X7nfk2n2" +
           "jYDeg+xEA1qohi2a+4bcPjeli/tTOgInHBBfF+dm+Up2tX5ku0CY37Ql0Y4D" +
           "ThPv++envvxrD34DxCIFXbdMoYMQPMS0vSg9YP3yc++/+zVPf/N92coEBq3/" +
           "DHnhbalW+Vro0uRSmjy6D+vOFNYg2xJ2xCDc31GlyK5NQX3fsMCau9w7PcCP" +
           "3fKNxYe+9cnNyeA43xwTVp54+lde2n3y6Z1D57EHLzsSHW6zOZNlRt+4N8I+" +
           "dP+1eslaNP7l+cf++Hcfe3xj1S1HTxckODx/8m/++8u7H/zmF6+wPT1lgtl4" +
           "xRMb3vSOVjFo1/b/uiNBHa/4OB6rTKEyaxYqrFrlKs1JV2MlXabFZr4n8vUp" +
           "2iHQYUlnaZeawgJaKqw6SnnZKbtxVY7ag7bBayOa5HF6FFbqlZAfLUkOYZGh" +
           "wNKY4bqLtd4jh5zXN/FhuFzMRa67yLW7RX02yydSEpUltTR3qbHnjWdWKSzN" +
           "cmJVGVdz5XIh9gaRExMca60xZ6HXLCdx0FXSEucrq2mIPMMNiV5nWMPoerlY" +
           "yZFVvpxbovWQdNmeI5jtlZIf1uN6uPDJuVWjHN9bT7lRvTlbcnrHxHvWtN6d" +
           "rVY015vwtZ6kW3LenQgN0uoLHklLJLqaGgbjkCxbxGxcwdCGUXdUl6NItDXg" +
           "ejMMl725R/p8tdFsOdKEyDNN0SmzrpDkhk7Pd4ZWY2rQA8onB0awsMXuSsTG" +
           "VYXPDxqNNtqU2kpTXi98v00IzVFuKrHVIOkJsKTilLAulnTTw72mRXqWG4Gx" +
           "sIlx2zOalpLnK6QrJSpGGR7t6Ito6lA4P1kO8eZK1HgkVLm8t+gURS9n8npl" +
           "xrdVgXZnbrs+oBxtInGTIU6anVF33l106RI7HBTUJtHzUMEfI4mCDCuSVW7n" +
           "lVwFJcJhMWQTFvcW8ihHO8U2qxNToVZjGrRqoAQxGej0uG7iMq7NlnFxGtB9" +
           "eiooCMbHpUFdaDcbZbyvs5glj9ervoAmtUWEzxaCSFEeNxrAdbvrYyOBYnW8" +
           "xYZyizPHUVGbYoTm8mu8OV3U+7WqgY2KJhbTSTtXaTUWMluKarXGvMO72gKs" +
           "XONYdGo1zFBAS8MjGU61azmZ1duDhFux035p7JYa2Mj2NV/vNLs0UScmZWxM" +
           "VXBP81CywTactgg3uYCa1QdGpUp3lqGEjZBqBW8igxVq1LpaMB019UpQqbn2" +
           "IucG+aLG5rvVYi0ZGWivpfNiksv329qQJIYlY7jsS6uqGo0TYVnRR0y3EIiW" +
           "Xy4OjfWAVRukyswaDId0lmZMxoP5pDdirHgpO4lVEhLKdZOcUeu1C0JDMRco" +
           "hUmF/nrmJ9U1aVd4jprIXmPImy2WhmmdQRo05jeJuerFBruuT7HFdDSmeAxt" +
           "rQq008uNGtO4lUM6FBl3I7MZrxyB7qnT2dzQ6oNqbe45g5yPT/MRVulQXRtr" +
           "cnl9VKuoSJtjK7hrqPB65vQabX6x1A28Rnte7C0EQ+dV1GU5G8RQHyODxBsb" +
           "LAP7sG9HE33ENYaDeKkt6q1es+20i/URleCqrqOlZsI09Yhu9mpEqRlpONFr" +
           "9vItFRZms3BtdTwNXsJSn+z1hVBot2v1ppVjWkRt7ERzrrEKRE3BB1V/2Rct" +
           "qTWJiOWARgcyzZPxAie6FKsluETxml+bs0OjX6ebjNvEg0ZRq634dpOp4R0X" +
           "obWu5pAWWS/wrFWqF1tVedUcrAgXuKMHB5NWC/anhtRAqm7d6HL5xaRUHKCE" +
           "Jq/LhBbTFIZFLdtbRdGIKnYdnNZ4vUpYMaWwVLm8qjR1p+1Oa8U+1WjqYdiG" +
           "zfm6zK2drjlvF6JCWV1UFpWu3I0MnJrWUZNAmtoQK3OS1m/ITDgu95erPMy0" +
           "9MKk1SNWMV4ry4yw4o3Yq5SWqg+vtajDjZTWbFVoaY7RdurFGsEbLD4h+/W1" +
           "bVf6xFpEUFhn5MGipXOMuODaPGONCckYUZrdLbYrqyWGzOHOvB4TM3RhxKTn" +
           "RWLBtOEhyotyuChIc8zu5zqcVlEYH1b9OCyUC0g8CSIGYflcnyZVJxYnar2J" +
           "oIGtNQRbYfDxat3VFKwfo3TLLq/Xs2SZ9LH6lOmhzbbs4b1qb0pIagXFo3Kh" +
           "UF4WuN6yXkdViiPUfKHRNoeUQEmRO5x3OzRpVwsU2So2yLpJ1xWy6nluqI3I" +
           "qE27rrpoJeOOOYfLFakhljWJnvf0KGQSFE/mcxuJWi3bDleiWZpRVm3QZRIJ" +
           "nTJN0PdYKtPiCiGa9Ggt9AXFWi5lsziZk0S+FvBIiSC6bMcSbL67ys+KQjCf" +
           "tAaDemIthlqZFRqm0Oanps/xUV2NWhyirjnXqrQCYTodIHRO14MJz1lwQM94" +
           "2srlqGIZm/p1LuDtwhzsmMaol1OWXR6tMkIyGxYccimgZcrKj4UxUaLm1bbM" +
           "mhYZzSNbiatOQxSWtYVPBDjdXuAIOpZqpjWtTKwRZ5YG1QoWTJoFWeqQnToh" +
           "6oM8y7lapRbRtFeziq0e1a2vuCUsqvIq4TzDRwhqxE/La6Q+S9yyvBbyjp3g" +
           "pXmSqNVZf9ynwpJJBIuqRAjzDiAiLJq3eHcGMwmxqiiT5RKGOx6XG1eUWB9M" +
           "ykEFJpFCTh8WHThXkhmJRUWnl0esYq6rGlSMed5onvBKt1Ak1bWfXy3iCK7R" +
           "Nblg5KRhI98P3UmOceY0WD9CkZmI6Io1hwMYqTGDieuiNTYpR5aqWsZ8FYsB" +
           "jGPxCq52LLTKMiqZKPoQM91l1WvJg5gYs4awnvA+W7ajuOzUpi7Smzf5WCyp" +
           "rOAueh1ujDlckyUXQU6mF36Ax/VufqDAclCYcXxrJHtofj2jR0g0RFb58pL3" +
           "8qtBseD3kKjUaBg4ouA9Hy0F0WxOeZrU0QbJUJ8OJm0qgtk1XvBpNHJHrTyT" +
           "b9SlQouY0h7gqqVTq/AkwSbLiUWEraCv13LDxnjNaNMwHA/Xgj8MK0xPknhl" +
           "IFoYXJy2J0ODV/pDUq8O17BtlhPFqtYLrI9gOQ2G4WahiFJVxR5M553OmOZQ" +
           "lZiG+pJlsajaIfCkYy28danXGOVzSGM9skplzlRm5mCGjUuapMGr6bIPewXT" +
           "QPzFfBm1mZxYTgITLrVhbGgj2BLtxHyvPjLD9bBruIMZ0i2PiguPYFeNXstr" +
           "AEYIW2Zilxe1hEXG45DQqgjR8gS93AkKPbD+xw3HUDGWStplts6UVJ2oi/p0" +
           "Pu1wTnPaFiXN5zwUC/ttpY+Uo1IZqxBcoUPAi1xxHsNGtzVz+H4rajCxsQTe" +
           "ZTbCUtQawUg3abg5sqNqnRWuqlWyj0xJJt+s1Koa5lebSQ9xMcy2mrnxohaE" +
           "wbhJVDAGznVaRTjCEXexwAeOglhDKgJUPivKuO3pvXriTwOmjajscurL1noC" +
           "M7KVFFVx1UpahraqrgtivyZirjmmTFnrMysHhv3qUGkXzaqwKo8SDcg2zbku" +
           "Tpm8OJsV+3g9KHG5Xh32J7WhzXr1kEbHCI0UfLAvQTSKhkWiVqjZYgtXnKbb" +
           "YUKcQgSvWly3C2q1hRb6cb5gKDBuW6iELpEBKutYDh25jC4wkWQHkVrHkZVC" +
           "EO1lh5Z1m5RrjWoz6rVHcmNMRjNpUvYcrJxrBbgR0VN33MATRhuv5yumpxpW" +
           "sUZPOnO4Wk1yvWWVJxG0WKDzmFdhioCLBhXULNluRAZBCWn12bHboTTHq9fG" +
           "Y8yc5hIuXhSDokyRPZYvlQrkLAhyIWWrEwAbnTMKp1qzkm1YU0useCLlj3Nr" +
           "dA5286bWcBfWoiGN5ajjY+7Mq5PAQ3TDU+LID7DEwsdWxabIJhjSnIUGlVJl" +
           "FZA9PukQYG1VfdNNELPhuNHYqXfQsijO9F5eYgKdVbpyr2JQdY6v49EadmHY" +
           "5PzVuNXz6mN05RbXdGgLXthdUWEkjFCjOJlGRclnG7aH0/ayGJbzxUSAc0WJ" +
           "6s2YuIr1nImdE5ZNrG2ARZsbjcVaGaZs01pZwZpYiktBdEdIZxaUKq5Fcy25" +
           "70XdGlPvgqHk2dYEx+SGG4TLoKMSzYkPl+W+T5Th3LI8GMR4LsSYGtvDg/LM" +
           "Mkek0GdLHtIf+nJnylfmZYQKG0pumevjbq5CYqbdEMOCr0z5Yj2YEKU13CJ9" +
           "P7cc4B5GTk2yQ8V6OCpheXWUjDSpN19PlvNB5MqTAF7pFr+sTLBGl2Ri22fp" +
           "KHFgLpzTOFog2UW1nGeN5YKb0eu5hwRaMbCred+PbIu3lZIzx+eIW+nadbGd" +
           "i9C13ankkoUsIHosRHlG7S27iZSPwvwMnCbfkh4zox/vpH9zdoFx8Mj5Cq4u" +
           "4it3uLPtcHsnnl1p3nz8vezwnfj2shNKD/N3X+1JMzvIf+S9Tz8rMx9FdvYu" +
           "icH5/PTeS/NWzymg5uGr31h0s+fc7c3l59/7b3cO36o/+mO85dx7zMjjKj/e" +
           "fe6LzTdIv74DnTy4x7zsofloo0eO3l6e85Uw8u3hkTvMu4++p9wNJvnWvaeG" +
           "W49frm3n88o3a2/c+MM1LuB/9Rp1T6bJ4yF0RokVKQo3jz6LQ47jhNCppWPI" +
           "W4964uXuTA73kRX84lG4dwKYd+zBvePVh/tb16j7cJo8AyBFtpw9DD+1xfWB" +
           "VwPXXXu47nr1cX3sGnUfT5PfBrh85TJcv/N/wHV7WngR4LlvD9d9rz6u379G" +
           "3WfS5FMhdGOgO5Epk1d30jMzxzEV0d7ifv7HwR2H0O1XeYXefwOrvNLnbcBi" +
           "d1z2K5zNL0ekTz17/uztz/J/mz3kHvy64/oOdFaNTPPwK8ih/GnXV1QjG6Dr" +
           "N28ibvbxuRC67+WMDKFz2y8ZtBc2jf8shG69YmPgVenHYdnP770IHpYNoeuy" +
           "z8Nyfwl628oBit9kDov8VQidBCJp9ivujz7UtVkQ+qIU8iCON0+l2VzFJ44u" +
           "QwfOcMvLOcOhlevBI0tO9jOr/eUh2vzQ6pL0/LNU710vYh/dPGRLppgkqZaz" +
           "HejM5k39YIm5/6ra9nWdbj30w5s+ff3r99fCmzYGbyPrkG33XvnVmLTcMHvn" +
           "Tf7o9j9488ee/Xr2jPC/+WlxPv8mAAA=");
    }
    public void appendChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createAppendChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand createAppendChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.AppendChildCommand(
          getAppendChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class AppendChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParentNode;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        public AppendChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              oldParentNode =
              childNode.
                getParentNode(
                  );
            this.
              oldNextSibling =
              childNode.
                getNextSibling(
                  );
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { parentNode.
                                  appendChild(
                                    childNode);
        }
        public void undo() { if (oldParentNode !=
                                   null) {
                                 oldParentNode.
                                   insertBefore(
                                     childNode,
                                     oldNextSibling);
                             }
                             else {
                                 parentNode.
                                   removeChild(
                                     childNode);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6MzeBfmhnBuAmEeufaJB57fQh0evX3rvv9w9eav5zldwD3XfCSVPivwU/fxX" +
           "em9Ufm0HOn1wEHvF/fhxpkePH7+eC7U4Cb3JsUPYe47fBd0DhtPZG1bn5Onb" +
           "4Xxe/ejtTVt/uM4Nwoev0/ZMVjwVQ2e1VFOSeHthFR5xnGUM3bD0LfXQoz74" +
           "UmcqR/vIX3zguLl3AzODPXODV9/c37hO23NZ8QlgUuKp+X32Rw/tevbVsCvd" +
           "syt99e367HXaPp8VnwJ2hdoVdn36/2DXndnLy8CeJ/bseuLVt+sPrtP2R1nx" +
           "hRi6NTL9xFE713bSs7LvO5rkHdr9u6/E7jSGLl15eb5/ddf4SS/kAYDddcX/" +
           "hrb/dVE+++yFm+58lvvr/P754P8oN1PQTXriOEdvcI7UzwShplv52Ny8vc8J" +
           "8p8vx9D9L6VkDJ07fMhN+9KW+asxdPtVmYFDZT9Hab++d5F5lDaGbsx/j9J9" +
           "A/R2SAfQfVs5SvLNGDoNSLLqXwYvf6hbchSHkhJzIIS3N7z5XKWnjmegAz+4" +
           "9FJ+cCRpPXQs2+R/DNvPDMn2r2GPK597tj9414u1T27v3xWwUNhkUm6ioLPb" +
           "vwIcZJcHriltX9YZ/OEfnf/8zW/YT4PntwofBtUR3e67+mV3xw3i/Hp68/t3" +
           "/s5bfvPZb+U3DP8L2Qi9X7EnAAA=");
    }
    public void insertChildBefore(org.w3c.dom.Node parent,
                                  org.w3c.dom.Node sibling,
                                  org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            historyBrowser.
              addCommand(
                createAppendChildCommand(
                  parent,
                  child));
        }
        else {
            historyBrowser.
              addCommand(
                createInsertNodeBeforeCommand(
                  parent,
                  sibling,
                  child));
        }
    }
    public org.apache.batik.apps.svgbrowser.UndoableCommand createInsertChildCommand(org.w3c.dom.Node parent,
                                                                                     org.w3c.dom.Node sibling,
                                                                                     org.w3c.dom.Node child) {
        if (sibling ==
              null) {
            return createAppendChildCommand(
                     parent,
                     child);
        }
        else {
            return createInsertNodeBeforeCommand(
                     parent,
                     sibling,
                     child);
        }
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand createInsertNodeBeforeCommand(org.w3c.dom.Node parent,
                                                                                                                          org.w3c.dom.Node sibling,
                                                                                                                          org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.InsertNodeBeforeCommand(
          getInsertBeforeCommandName(
            parent,
            child,
            sibling),
          parent,
          sibling,
          child);
    }
    public static class InsertNodeBeforeCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public InsertNodeBeforeCommand(java.lang.String commandName,
                                       org.w3c.dom.Node parent,
                                       org.w3c.dom.Node sibling,
                                       org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "VbVLlheY51WVYcWfaPPTfwNIRnzgNB0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "lanlweb09a9Pt62/+uJODm7KDkR2b5lfwlFIcu0Gj+81uHcpkZ0p33T4wnLf" +
           "kdK+02YoPRy486g75exg4Il3PvK41Pswcnz7lP6XI+j09lX/npyTQMyDR5+A" +
           "dLP79L2j4y+881/vGL9Be+uLuEy7+5CSh0V+pPvkl5qvFt9/HDqxe5B81U3/" +
           "QaaHDh4fnw/kKA6c8YFD5DsPXmilJ3XPbnfrs4dP6vbG89rHdK/Z+MN1bkB+" +
           "9zp1H0yTRyPojJzIYhxtbt1W+xzn4Qg6uXB1ac+jHnu+M5j9bWQF7z9o7h3A" +
           "zB9tm/ujn765H7lO3R+kyRPApNiRspv5x/fs+vBPwa6TG9bt50/Xrk9dp+7T" +
           "afJJYFcgX2XXH/4f7LotLbwM7Nk2bPP86dr12evUfS5N/iyCbgw1N7Yk8mgn" +
           "PTN3XUsWnD27P/Ni7E4i6LYjPgPYuYSsvNTvCwCK3X7VZ1CbT3fEjz9+8ext" +
           "j7N/nd2k735ec46GziqxZe2/htqXP+0FsqJnHXRucynlZY+vR9A9z6dkBJ3f" +
           "e8lM+9qG+ZsRdMs1mYFXpY/9tH+5fSW7nzaCTmXP/XTfAq3t0QGI32T2k/xt" +
           "BJ0AJGn277wX3tX4PIwCQYxYEMebu+psrJJjB6ehXWe4+fmcYd/Mdf+BKSf7" +
           "zm1neog3X7pdET/xeJt523OlD2++JBAtYb1OpZyloTObjxp2p5h7j5S2I+s0" +
           "9cCPL3zy3Kt25sILG4X3Imufbndf+9qetL0ou2hf/8ltf/y633v8mexa4n8B" +
           "lxTXnYAoAAA=");
    }
    public void replaceChild(org.w3c.dom.Node parent,
                             org.w3c.dom.Node newChild,
                             org.w3c.dom.Node oldChild) {
        
    }
    public static class ReplaceChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node oldParent;
        protected org.w3c.dom.Node oldNextSibling;
        protected org.w3c.dom.Node newNextSibling;
        protected org.w3c.dom.Node parent;
        protected org.w3c.dom.Node child;
        public ReplaceChildCommand(java.lang.String commandName,
                                   org.w3c.dom.Node parent,
                                   org.w3c.dom.Node sibling,
                                   org.w3c.dom.Node child) {
            super(
              );
            setName(
              commandName);
            this.
              oldParent =
              child.
                getParentNode(
                  );
            this.
              oldNextSibling =
              child.
                getNextSibling(
                  );
            this.
              parent =
              parent;
            this.
              child =
              child;
            this.
              newNextSibling =
              sibling;
        }
        public void execute() { if (newNextSibling !=
                                      null) {
                                    parent.
                                      insertBefore(
                                        child,
                                        newNextSibling);
                                }
                                else {
                                    parent.
                                      appendChild(
                                        child);
                                } }
        public void undo() { if (oldParent !=
                                   null) {
                                 oldParent.
                                   insertBefore(
                                     child,
                                     oldNextSibling);
                             }
                             else {
                                 parent.
                                   removeChild(
                                     child);
                             } }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (parent ==
                                               null ||
                                               child ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "XTFVZTzxJ1r89N/XfKwILB0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public void removeChild(org.w3c.dom.Node parent,
                            org.w3c.dom.Node child) {
        historyBrowser.
          addCommand(
            createRemoveChildCommand(
              parent,
              child));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand createRemoveChildCommand(org.w3c.dom.Node parent,
                                                                                                                org.w3c.dom.Node child) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.RemoveChildCommand(
          getRemoveChildCommandName(
            parent,
            child),
          parent,
          child);
    }
    public static class RemoveChildCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node parentNode;
        protected org.w3c.dom.Node childNode;
        protected int indexInChildrenArray;
        public RemoveChildCommand(java.lang.String commandName,
                                  org.w3c.dom.Node parentNode,
                                  org.w3c.dom.Node childNode) {
            super(
              );
            setName(
              commandName);
            this.
              parentNode =
              parentNode;
            this.
              childNode =
              childNode;
        }
        public void execute() { indexInChildrenArray =
                                  org.apache.batik.dom.util.DOMUtilities.
                                    getChildIndex(
                                      childNode,
                                      parentNode);
                                parentNode.
                                  removeChild(
                                    childNode);
        }
        public void undo() { org.w3c.dom.Node refChild =
                               parentNode.
                               getChildNodes(
                                 ).
                               item(
                                 indexInChildrenArray);
                             parentNode.insertBefore(
                                          childNode,
                                          refChild);
        }
        public void redo() { parentNode.removeChild(
                                          childNode);
        }
        public boolean shouldExecute() { if (parentNode ==
                                               null ||
                                               childNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "3f8XFFhEIy8nAAA=");
    }
    public void setNodeValue(org.w3c.dom.Node contextNode,
                             java.lang.String newValue) {
        historyBrowser.
          addCommand(
            createChangeNodeValueCommand(
              contextNode,
              newValue));
    }
    public org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand createChangeNodeValueCommand(org.w3c.dom.Node contextNode,
                                                                                                                        java.lang.String newValue) {
        return new org.apache.batik.apps.svgbrowser.HistoryBrowserInterface.ChangeNodeValueCommand(
          getChangeNodeValueCommandName(
            contextNode,
            newValue),
          contextNode,
          newValue);
    }
    public static class ChangeNodeValueCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
        protected org.w3c.dom.Node contextNode;
        protected java.lang.String newValue;
        public ChangeNodeValueCommand(java.lang.String commandName,
                                      org.w3c.dom.Node contextNode,
                                      java.lang.String newValue) {
            super(
              );
            setName(
              commandName);
            this.
              contextNode =
              contextNode;
            this.
              newValue =
              newValue;
        }
        public void execute() { java.lang.String oldNodeValue =
                                  contextNode.
                                  getNodeValue(
                                    );
                                contextNode.
                                  setNodeValue(
                                    newValue);
                                newValue =
                                  oldNodeValue;
        }
        public void undo() { execute(); }
        public void redo() { execute(); }
        public boolean shouldExecute() { if (contextNode ==
                                               null) {
                                             return false;
                                         }
                                         return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nYzlLLO8rjOo+A1tnvwXKarqYC0bAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    public org.apache.batik.apps.svgbrowser.AbstractCompoundCommand getCurrentCompoundCommand() {
        if (currentCompoundCommand ==
              null) {
            currentCompoundCommand =
              createCompoundUpdateCommand(
                OUTER_EDIT_COMMAND);
        }
        return currentCompoundCommand;
    }
    public void addToCurrentCompoundCommand(org.apache.batik.apps.svgbrowser.AbstractUndoableCommand cmd) {
        getCurrentCompoundCommand(
          ).
          addCommand(
            cmd);
        historyBrowser.
          fireDoCompoundEdit(
            new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
              getCurrentCompoundCommand(
                )));
    }
    public void performCurrentCompoundCommand() {
        if (getCurrentCompoundCommand(
              ).
              getCommandNumber(
                ) >
              0) {
            historyBrowser.
              addCommand(
                getCurrentCompoundCommand(
                  ));
            historyBrowser.
              fireCompoundEditPerformed(
                new org.apache.batik.apps.svgbrowser.HistoryBrowser.HistoryBrowserEvent(
                  currentCompoundCommand));
            currentCompoundCommand =
              null;
        }
    }
    private java.lang.String getNodeAsString(org.w3c.dom.Node node) {
        java.lang.String id =
          "";
        if (node.
              getNodeType(
                ) ==
              org.w3c.dom.Node.
                ELEMENT_NODE) {
            org.w3c.dom.Element e =
              (org.w3c.dom.Element)
                node;
            id =
              e.
                getAttributeNS(
                  null,
                  org.apache.batik.util.SVGConstants.
                    SVG_ID_ATTRIBUTE);
        }
        if (id.
              length(
                ) !=
              0) {
            return node.
              getNodeName(
                ) +
            " \"" +
            id +
            "\"";
        }
        return node.
          getNodeName(
            );
    }
    private java.lang.String getBracketedNodeName(org.w3c.dom.Node node) {
        return "(" +
        getNodeAsString(
          node) +
        ")";
    }
    private java.lang.String getAppendChildCommandName(org.w3c.dom.Node parentNode,
                                                       org.w3c.dom.Node childNode) {
        return "Append " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode);
    }
    private java.lang.String getInsertBeforeCommandName(org.w3c.dom.Node parentNode,
                                                        org.w3c.dom.Node childNode,
                                                        org.w3c.dom.Node siblingNode) {
        return "Insert " +
        getNodeAsString(
          childNode) +
        " to " +
        getNodeAsString(
          parentNode) +
        " before " +
        getNodeAsString(
          siblingNode);
    }
    private java.lang.String getRemoveChildCommandName(org.w3c.dom.Node parent,
                                                       org.w3c.dom.Node child) {
        return "Remove " +
        getNodeAsString(
          child) +
        " from " +
        getNodeAsString(
          parent);
    }
    private java.lang.String getChangeNodeValueCommandName(org.w3c.dom.Node contextNode,
                                                           java.lang.String newValue) {
        return "Change " +
        getNodeAsString(
          contextNode) +
        " value to " +
        newValue;
    }
    private java.lang.String getNodeChangedCommandName(org.w3c.dom.Node node) {
        return "Node " +
        getNodeAsString(
          node) +
        " changed";
    }
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
      ("H4sIAAAAAAAAAMV8C7Tr2Fme75lXZjKZVx4zmSSTSWbyVHJlW7ZlMQkgS7Yl" +
       "W7JkybIsQ7jRy7ZkvSXbktIpkFISCmtIyySllITFIpRHE0JpeS0WdAqLQhZp" +
       "6VBSoOWR8ljlUQrpWgRWA6Vbts/jnnvumbk591KvpV/y1t5b//ftf//739KW" +
       "PvGnpTviqAQFvpPNHT+5bKbJZdupX06ywIwv95g6r0axaRCOGscjkHZFf+MP" +
       "3/+FL35o8cBB6c5p6eWq5/mJmli+Fwtm7Dtr02BK9x+nth3TjZPSA4ytrlV4" +
       "lVgOzFhx8hRTeumJoknpSeZQBRioAAMV4K0KMH6cCxR6memtXKIooXpJHJb+" +
       "fukSU7oz0Av1ktIbrq4kUCPV3VfDbxGAGl5S/B8DUNvCaVR6/Aj7DvM1gD8M" +
       "wc/+06954EduK90/Ld1veWKhjg6USMBFpqV7XdPVzCjGDcM0pqUHPdM0RDOy" +
       "VMfKt3pPSw/F1txTk1VkHpFUJK4CM9pe85i5e/UCW7TSEz86gjezTMc4/HfH" +
       "zFHnAOurjrHuEHaKdADwHgsoFs1U3TwscvvS8oyk9PrTJY4wPtkHGUDRu1wz" +
       "WfhHl7rdU0FC6aFd2zmqN4fFJLK8Och6h78CV0lKj1630oLrQNWX6ty8kpQe" +
       "OZ2P350Cue7eElEUSUqvPJ1tWxNopUdPtdKJ9vnTwbueeZ9HeQdbnQ1Tdwr9" +
       "XwIKPXaqkGDOzMj0dHNX8N63Mx9RX/XTHzwolUDmV57KvMvz43/v81/5jsee" +
       "+8VdnteckYfTbFNPrugf1+57/rXE27DbCjVeEvixVTT+Vci35s/vzzyVBqDn" +
       "veqoxuLk5cOTzwn/Xvm6HzT/5KB0D126U/edlQvs6EHddwPLMaOu6ZmRmpgG" +
       "Xbrb9Axie54u3QWOGcszd6ncbBabCV263dkm3elv/wOKZqCKgqK7wLHlzfzD" +
       "40BNFtvjNCiVSneBrXQv2N5U2v22+6SUwQvfNWFVVz3L82E+8gv8RYN6hgon" +
       "ZgyODXA28GEN2P/ynZXLKBz7qwgYJOxHc1gFVrEwdyfBnyCG4/Vci/xNbEYw" +
       "BZyDH2Wt3V/60JQvFyYY/P+8eFow88Dm0iXQaK897TIckIvyHcOMrujPrlrt" +
       "z//QlV86OOpCe06TUhNocHmnweWtBpcLDS4fa3D5OhqULl3aXvgVhSY7SwHt" +
       "vAQeA+S/923ie3rv/eAbbwMmGmxuB41UZIWv79KJYx9Dbz2pDgy99Ny3b75+" +
       "/LXlg9LB1b650B4k3VMU5wuPeuQ5nzzdJ8+q9/4P/OEXPvWRp/3j3nmVs987" +
       "jWtLFp3+jad5jnzdNIAbPa7+7Y+rP3rlp59+8qB0O/AkwHsmKrB24JgeO32N" +
       "qzr/U4eOtMByBwA88yNXdYpTh97vnmQBWuE4ZWsA922PHwQcv7ToDW8E23Df" +
       "Pbb74uzLg0K+YmcwRaOdQrF11O8Wg4/++n/8I2RL96FPv//EKCmayVMn/EhR" +
       "2f1bj/HgsQ2MItME+X7r2/lv+/CffuCrtgYAcjxx1gWfLCQB/AdoQkDzP/zF" +
       "8Dd+57c//qsHx0aTgIF0pTmWnh6BLNJL95wDElztzcf6AD/kgO5YWM2Tkuf6" +
       "hjWzVM0xCyv96/vfVPnR//nMAzs7cEDKoRm944UrOE5/dav0db/0NX/52Laa" +
       "S3oxDh5zdpxt51xfflwzHkVqVuiRfv2vvO6f/YL6UeCmgWuMrdzcertL+45T" +
       "KPXKpITfYE99EjDrqoUn9pKo0CLaNj+8re/tW3m5oG57ldL2HFKI18cnu9HV" +
       "PfVE5HNF/9Cv/vnLxn/+M5/f4r46dDppNawaPLUz1EI8noLqHz7tMyg1XoB8" +
       "tecGX/2A89wXQY1TUKMOPGTMRcCFpVfZ2D73HXf913/3c6967/O3lQ46pXsc" +
       "XzU66ra7lu4G/cSMF8D7pcFXfOXOTDYvAeKBLdTSNeB35vXI9t99QMG3Xd9T" +
       "dYrI57izP/J/OEd7/+/+1TUkbH3UGQP+qfJT+BPf+Sjx5X+yLX/sLIrSj6XX" +
       "unUQJR6Xrf6g+xcHb7zz5w9Kd01LD+j7EHSsOquiC05B2BUfxqUgTL3q/NUh" +
       "1C5eeOrIGb72tKM6cdnTbup4OAHHRe7i+J5TnunVBcsDsL1132nfetozXQJ9" +
       "/UE8AbGcBqK4x9Uicv2yx4tz+LaWN2zlk4V4y7aZbktKdwWRtQYhB/AS8TYA" +
       "ToBqlqc6e2/xt+B3CWz/t9iKCxYJu4jhIWIftjx+FLcEYDR8GB+NBLoljdpX" +
       "cJJsk1cIjmXxAXnYBx/YGmHB2eVd2LlzqIWsFaK1uzJ6XaN719WUCGB7+56S" +
       "t59FycuPKYlM118fksJfh5TisFOIbiGobTPQSenVx7iENsuNj5EVGZhTKIY3" +
       "iGIEtnfsUbzjLBSvOEaxc6CHMCY3BuPRYxgsR9Id+nwcyg3i6IHt8h7H5bNw" +
       "3D/wDfNxywPeNTmE8N4bg/DKAUe2r9ADsS2MztdevUHtKbCV99qXz9L+vq32" +
       "V5nR4saUf8VW+RdhQdaXYEHVve7VMy1oq/u6cF2P6wvQ/w4RBDdoQQSFC1dI" +
       "fIS/KAsKbxDHV4GtucfRPAvHE6Svr1zTSw5RPA4mrbEFsJEc+/jYMjc735/e" +
       "GKyHONAnhCttkh6dBye7QThdsL17D+fdZ8G5Z9ssW4MqEr/uxrR+GKjKc9KA" +
       "vDIS2u0rW+MiBY4/S/Wv/xJ6Q2uveuss1V9WqB4fdoci/YM32JN3/eCK2Gba" +
       "RNGXC/3Fs3T/phev+31F6jv21B82wdW6l7YHHzpbWQDs7iDyEzCcm8ahpvct" +
       "rgoMDwcz+AYDylOo/vENoioMiNmjYq6D6juug6o4fPYQzqv0VQRmTUkxhPur" +
       "IsDdxrmHsF54RotrYGYHQsVTFZzC989fEN9Wn60x3VG9jF4uF/+/5xwjeusZ" +
       "XcB29CcPY5ExaBsQOj5pO+hZZkS/aIVABHvfcaTC+N78qW/+/Q995luf+B0Q" +
       "ZvZKd2z9KIguT4Qzg1Vxx/AbP/Hh17302c9983YKBnjnP9J+4CuLWn/wxmA9" +
       "WsASt/c4GDVO2P2gXyA7P7rmI8sFk8v1/nYY/PRDv7P8zj/85O5W1+lQ+lRm" +
       "84PP/qO/vfzMswcnbjA+cc09vpNldjcZt0q/bM9wVHrDeVfZluj8j089/VPf" +
       "//QHdlo9dPXtsra3cj/5X/7mM5e//XOfPuN+y+2Of03U+OIbNnn1B6laTOOH" +
       "P3asE/WhVJm6EDLjCEUmuoPNht7kxJznNt3OJMNTz2uR/LDptRzFKNtihRpN" +
       "8pZQHtfH46Sqq06LYOmlPkgrMjG1ZxblD1Y9Qqx5nlQxbTGfhoN0oMR+Ngvp" +
       "pSDnrj1ZLUdVpseEGsrDs3AVhlHYCBvTKIjztVcZNCvjmQljCDqDTQyGkXU0" +
       "XiDwoif6ROiOuRHFLcz5yh0bpDexzUxchlQVY/V+pOLgivFoDWNaA+tgDWVF" +
       "YLTorXtOu8NpSpL2I6xVaw3SZGroPXoe1vWhEqFaPmttKtxibNan0sKeh2K1" +
       "nbiEG0TSskazSrcqTtpmu5o7Dm5NM6cbElQ5yKJZ2B0TGcv2wnZVrRDGTGs3" +
       "MmZJh0qPa2YdNcw7LT/B8lZStlI+UIdh7LMaoD/oWyOiLXWdBkb3ZbHDWOMy" +
       "SShuFyKHA1Sy4rLiKZ2OOxqW+aRWl2ezCcUrLdlWRr5nLQCcgbSaBJI4RDbN" +
       "oRUNwma5x4eeKTD1rmX1lktLSnsTSfAxfNNphd3hvNqcWqEPy4I5IiStN1Sp" +
       "ru2OM7sbtwmZiW1O4JQx00iccmwHJLngfDsoBzgWqmQntFdyebgGis04G4oq" +
       "CiZJw9Asuw5NTW1D7g2JYdjB8P5ixvT5MTZqmL2Mx+r9gLaF2qDRpCdtRom0" +
       "WXXQkZQ26ar4gt2obJfpT52J3Fu6Y4wQ5+1KL1Wt5ZQjK2yDF+FsHYwQnJxT" +
       "smyNx+QK767xZivDxdDFqMHcRIN+U6q3bJJFs0SjlX6ukbiDJ2LeK5fbgVQR" +
       "04xtd9hlOV8Ohx7pi+hmZrdxaaHSfrvXj3N5QvY6kSutkgC0S5+TcqbrNTBh" +
       "NVTDno0vJF8WXV7wGGIcBtVk2nfWWj2gEGwzXXc6dofGHdLjWhij8GVvbtCE" +
       "W6EnSLMZ8fyQHGlgpm4ONwNoVcfLHYLmO6xcpZN8zCEek0B1pS94VSeo2+6y" +
       "YdraRjf8AaWWtWYYQArCRBZKqMts2BtP8DTGiNwLpgFS9yZjvzvK2WiZ8SbZ" +
       "WiICGpgwz60piIXJgMnGDq0u037QG9hCpWdJDi21o2q+FMboot/C1j1hUGcN" +
       "lEYjU2RtiyeI/npiIj5aMerVZdhvQ6kY6iOoVYsa9HC1DFs519I6MzauO/a8" +
       "kTVRgSUIl5xXRnisCP4MyiZLB1kMRa+3QJdKbxNaHa4u9ViRJ/WgSYYwYQr5" +
       "KnP6NRJK4XpDjoYVszsWXWfe7nZ7sjTP6c6Y5Bl1NFtQ45gPy21iRs+r5GyT" +
       "IXMcEp1OeVCNoGRhuVQZHzlwEybKTZvFuA6Ot4JknVScHtEaW3WRbpb9smHZ" +
       "4zKVrxZYZzKg+DYTCrkYO2OJ5oZjnx2CC9Bqimdq2srCYbvX6tgtFsVdNxzj" +
       "HNRs2xsq6NenlVl1MsLmXEWQCavp4emgRbuTqZ8vSFmNYkkhG/201jAbTJA3" +
       "zZmb0rhLYJBL0vpGF6AwSxedpNsRl91WkxIgpeovFubA3EAL25bntU2TZdJ1" +
       "A6uPoxYq+8N2zgAbX6xCozHAc8EYTSdKb7QOxsiMH00tfYD2Bmx9Spcr6YKY" +
       "+rUlFGCamVPapmzYWXeF9hrUAG34fXC9zZTrwv2hrJNr1MYnS1VGK44HUVSb" +
       "nbdxrJz0l8v1nNH5upMMWizO5ETEwaGZNlv2KO1xGZtMSN3nDQ7zE2TaXPrT" +
       "6rpq2VN72KS6lrxC68PZDOaAa4pRf+CrkriM4zKLjAxBQRaBM1A29Sh0XYIf" +
       "RvwQDRAKsppoZTVDmO6gKkBLmUslpYWATtCalWkBb0JleAW5CYbUMYwaDZPO" +
       "sl9DrJAs9y0DV5YTa+ZQFinkMdKYtxJ2Thp42PA02u+NiXWZqNRn83jKNw1I" +
       "FisSDKEuMZ7O9d6q21fKeiSwObHOq+X5BIGdMNXluLshWCHrjnSUnfaCtVdF" +
       "3Um/6SNEIxaQaNZIDQyY9moozJ0NyUUbt2FyxgpHXCiVPNYPZ7Ogz4V4VRQp" +
       "vNahO2rW2QQRTATTmct6zHIUyIRLIdGyJwSVEJUmUz4ZCmbZmGNBDhlrfjKq" +
       "N5spMnAFFxuHVXtR92TV7/fUJT1bT41gNt6ELrnkGv3lTFmPs3F37eO6mVFU" +
       "l1z4icS2yHrExXYbMyRvWoXhzbLiaaNUFmr4VPQCogbhKmeM9aw983vRpkE0" +
       "ywgzAf6CrfMLQiRCYJsinta1adjJ3Vz3pnqgqrPZKIaxFWw0dWgk5aNm2azn" +
       "VEUU/a5NaXwW9qBy5jXRoApz67VNYM2kXO13p2bDLPcVpA5znDCAEhRuQovq" +
       "yMVTxOpOE0iD7ZrR8LUIXimN6ZojGGkSIAOKmZCTYFV30jrjzVHZ4TdV0FXr" +
       "YsdgbbRf0Wl/bKxbpiUmEr3K2v0cDWeU2AlrBtGwGc7QELPtuEyiJbjOmG1d" +
       "gvj6tLf23NoqqeIo1dOC0YodraAhMxcbU7e+XFYoXHMr2Gi+HqtyVqFdp9FR" +
       "snFYsXp0JguduT6fzkVHkpEK57tWKyOmMeKuBsDxyXkDSRorx9eS9bAsQCvN" +
       "DULNBy5HA7lRqdJdN+qW4evNhSbQsseL/T7WjaVlpGnViB4ZbhnDOynSxwbx" +
       "ylB7i1U5JDei7NE0x/AT2sbLiCJR4rxB6QTakWa9SWvQHCMDLa0oI97S/GTZ" +
       "xcriTKLshdxw5bVB041NTQxNuUY2YCVVECkiGwrWS9SqHWoyqSKmQrozhZy1" +
       "2gbNkLnbiuSMcvtJt81SiLThPLar6tpy0pr1M8xvLOvVJDIRIx/XNsDVlCGa" +
       "mRBxOU6M+lBICZ9Tptqk77a6DWcouJuUdBWNDLt4XmUjRMnSzQA4dn24MNR2" +
       "Gre9KomvKY9lB0gfrw0Sre+tLVsbY9jIm2oEAuEiSiqNCGP7a33eR1dttx9M" +
       "+00Rr/qDcb8fzulheTASxtFgXKPNytwMq6wMKksb3WCD+kEFEeoAJ2XBbAKv" +
       "2+tWl1PhMREhE2LC1lR3sFxP1rnr9rt1Z0iT5IoM0IEtIotR0pCDlW33NG0F" +
       "IlBqRBgIzvKa0GJQr0UYGBhGdXUiiGsqreUCYxIbfBzMRryKCGmgLYfegiBQ" +
       "b0iaXg7j/cmiEhgNWnAHLp6N4jrR8QS6BflhSnfatMG7DZLFlraMtKJ5xRVW" +
       "aXu6oCpdmNTAGFoecU4gCn3MTvFJgx2WG5Zv5G0tCDb1oe84vXmwTNLEMh29" +
       "wxB1S+mWk/ZkaEaoQipcTSsneLpeokiCj4JkPKk3Am4dRz1N6TDSesxM2tBG" +
       "9RhBrke2m2EYZyWLGtrm0vo0kib1MspMmtOoM+Zpag1ns3GZ5T3Kmypix6eD" +
       "yVJM+Wa7B20capl2mGIsQAED02UukViW6OsOU8nRetZHcEnLu24rQxhWXxs9" +
       "i6niThXFMCg0GxsVgUAPk+W5nQWoo1QRaoI1agNqul72y6EKc4Q3mPhaf1yp" +
       "alxL92WvL03ibOqPKl11vYiGgiZsrDSEx8ESseOx05n6SGtkSNUFNvUaa3vd" +
       "DbSIRwI2drB2U+Y3ihjyFTfT/MbKXDYHnCDN++OWLXYaa9JsqFgCsygFV3A2" +
       "n6GjASG7JLZpsDV4MayZ5WXKy3B95jEsoWETgZp3N6JjBAi/6cHz3gZutXmB" +
       "Hk6aLb1baU8xSvPdOMWTrOq46wU6VpbjGOLJtueacAKZnM+iQwnMtciyQyBc" +
       "PqEbXD0O8x7fafjTujnLR8OAccKRBbWVSi8pl5lmheSsEEccbZjPGEwsA8Ob" +
       "U6ns9OuxBPr/PEcGscypKDaFZRGVB0Y/rOd5XROgWpKW0ZjWKuXBohHkAZgc" +
       "VMrI2DVQFms5va5Wa3Z8ECwKeJdqZEsyL/twaneg+ogtiwvKk5QEjoZsfwWp" +
       "aG+TkOR6smE6kwVqT/g8WYUWGvs4VyVb69qQWaIteeB38hm7CFMf5VC1ChvG" +
       "hJquIlNpqot0JNcb/mRSX2jyZBCbUE9e0416M8u9hozNYDYiyysYshc+Txi5" +
       "lHREzdG0kY2Omm5XssXmSMdJxqQmTK0jr0nOJq2m5LQn5XA9V7kUETkqGehl" +
       "HyX4xVxcyKIyXzXFVpPGhkGfr9UGEdF12bRCwouGvJDr1Uk7lZXRbL1ka5hp" +
       "yqRjD7EoJbCsK8EsRkKNmp4FLcSccf3agJTmcE9c61SEevyaoupZj+F7aOK2" +
       "p+XZiq3QaBMMllK0CM3ZfNVnkkF34gkaVRur84ztNqeYNxDF1cLgZXKGWWBY" +
       "rHI04axAHC76XmtkudBgutG5qRyGebU3q0cDl61l/nDdCbu+johzhlFEwXaa" +
       "ELqqg/h0jDadXr8eOIngpkLPSZBmFnkE2Q1rM6qLaOsFAsF6ZEBuaEATZwyT" +
       "szz19K5Ql/J2TxAl1xCW0gQ47mpzs6yyTRr4KRCvVhRibA7cxXAM5RNcr4Rt" +
       "A4uhvtuIEJkRwgreaVipNUn6BkWSiR02VTIb+VIzs6ZkqvbzDWu0kJ40Y8dL" +
       "nW/UumrelbP1nOtTI52l4Xm1EVJui6TWhuyPF93MGLa8lcaZi2alLDbXNl8p" +
       "b8iuNUzt1Mbqg4qibkBE1Yf0uUTyeIVyxVhAu93l3BcgpxutV60orvUrNWi6" +
       "oA2UcDRuxAXWCPacjdSszhabsskz4jxksWw1VLQkwevsShtWxcpI8HqkomQJ" +
       "NclpjShTqKFPMrURQlNer5WpbLwYGk47JRQoziqwFCeJUtcWvlzrVyvzbjew" +
       "XTmYpZE+5jlP0WKKnJT9xJ0Mut4w0/pq1Rxnbj3APR+2mYXWLQ9sFdCR92DL" +
       "lSdjIVm35NxcCN7GjqJOu8orcEdOsqWSqjQFm7aLb2hHyvuaYnimGMQLex3h" +
       "fROrzONWwiUjDWb4MjlGKl3ETRe8LHucVUsVjosabSW3NlqlawpS1HJw2Ii7" +
       "xjrYJPNlPtgQU2TSz9cLD6plTLiEqigszKFqTUoqA9EZtaFpDtXWOekmm3w4" +
       "66s2FG9g2jQqlRlv05C4aWVt3ufnjGg1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/9mPGdz3Vg72iwJ/LCndnfjBOx1zbTonqnoLqOnt13+Sx27X7R8vVvuF9//x" +
       "o6MvX7z3Bhbzvv6Unqer/AH2E5/uvln/Jwel246Wrl3zRsHVhZ66esHaPZGZ" +
       "rCJvdNWytdddvaCWLe3WdZQO9yefWx+33dkPrd+6a/tTay4vHWcobzM8f86i" +
       "zP9ciM8kpVfGZvHE+tSazm2Rf3XCbn40Kd2+9i3j2KD+wws9Xjx5xW3Cp48Y" +
       "KBbbl94CtsWegcVNZ4DZZvjcOQz8biH+W1J6jR6ZamIePraXAmP37+TT/8GX" +
       "up79yetXu2XxNy/A4huKRAxs8Z7F+KayeLQ6scC+QfTLYOy6XCxv2Rb6X+cw" +
       "+78L8UdJ6ZEds0UZYrcu6cSaiN8/JuGPL0rCl4Hta/ckfO3NJeHkk/urvZGg" +
       "brYu7or+k8PPPf/R/FOf2D2Y11TQpUrQ9V7zuvZNs+IFgDed8xLD8QtAf9H9" +
       "suf+6PfG7zl0oi89ouGpAjV5Hg2HzXnWUnFw6tLBtsa/vn6zXrqjSPzLpPTq" +
       "42aNycgPguu1619d1EUUCw6/ZQ/oW26+cf/N0dUqh1Z03tUuHRzxdOn+c3h6" +
       "eSHuSUpP7ngStmvBRNPZrp4q3mTYMncmZZdeegHKtuNKG2wf2YP4yC3xB+UX" +
       "9IWSZ/i7lxm2ELekvO4cworI49IjSem1AXCafuSe6TOLgp89JurVFyDq0SIR" +
       "Atun9kR96uYQdRITdM65dxbizSBym5vJtYvhPnIM8i0XtQYObM/tQT53c0De" +
       "dhyM/tmx2OJCz8GMFaKalO71gPHT+7XOp9oUuQDc1xeJxeLYX97D/eVbDpc4" +
       "B267EF9+la88BH0qtGC+5NDiepVuufyKi5rOANDy8K7sbn9LuRyew6VYCCYp" +
       "vbQwHeF4Ze0Jy2EvgPaxIrEBFH/zHu2bbzna95yD9kohJlcFT3vMpwynfyHD" +
       "OaPOLZMv+HbDC9kNuyVlx2Rwc5i8fZvh9qMI5mRAWrx2b3rbV+yYY7FlcnkO" +
       "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" +
       "XW+Y/8TD/+Zd3/ex395+EOr/AY/zsr6aXwAA");
}
