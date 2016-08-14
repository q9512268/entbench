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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "/gfxbvLqKh0AAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "3sm5L/BP1lz8N1q1uymdHAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "xdvfu/93Xv0rT/99cQ3xv07NDR8iJwAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "KvJBzn2Fd1lz9d8hyVyDmxwAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fc/Tz2idj6A7e+fNYJ9/eu9OeivnJBDzyLVPPtrZxe/2EPRz7/nXuwdvMR99" +
           "GddC9x1T8rjIj7Wf+0Lj9eqv7kA3HByJXnElfZTp0tGD0LOhHs9Dd3DkOPSe" +
           "o1cz94DhbO8Na/v4Od12Pq9+SPeGjT9c5yz/l6/T9mRaPB5DZ/REV+fx5v5o" +
           "dshxvBg6ufAsbetRT7zU2cvhPrKKnztq7t1A8+6eud1X3tzfuE7bh9Pi/cCk" +
           "uatlV8hPbe36wCth12jPrtErb9dHr9P2sbT4TWBXqF9h12/9H+y6M628CFR8" +
           "+55db3/l7fq967R9Oi0+GUO3RKY3tzXq2k56Zux5tq64W7uffzl2JzF04cq7" +
           "7P2btPKPej8OAOyuK/6qs/l7ifrJZ87deOczwt9k18EHfwG5iYVuNOa2ffgu" +
           "5dDzaT/UDSsbm5s2Nyt+9vPZGLr/pZSMobPbl8y0FzbMfxpDt1+VGThU+nOY" +
           "9nN794qHaWPoVPZ7mO4v0kuWAzqA7puHwyR/GUM3AJL08cv+Dz/U1XEUh4oa" +
           "CyCENxeu2VwlJ45moAM/uPBSfnAoaT10JNtk/8Xazwzzzb+xLqvPP8Nw73wR" +
           "/8jmOly1lfU6lXIjC53Z3MwfZJcHriltX9Zp+uHv3/qpm163nwZv3Si8DapD" +
           "ut139btnyvHj7LZ4/Yd3/v6bPvrM17KbiP8FiydAziQnAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "cj1bHQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "+ScAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "H2gdYB0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "kSLDoDWjyc7aEaltP0FHfDUbqQRW5v1SKs+JjBsi9Q48c2exjNWNwCwT7JRR" +
           "+l6alZzqtMHzHl4yWxIVdcp1J1Jr/UjAsbkZTqOJ3OuIvbGJEMtgqK3Ejrsa" +
           "q1RIkAbf7pNSlxUzs2daa4uobjYkXh4MPKlFms5qhJYope4FFiU2R6RZ2SZW" +
           "PZuwAuMLDUziVl2kPKkovZaysQiz6wUkx8UDaRp0gnLEr30SX0/84brvOCw2" +
           "H8TlibigHaM+g9NSJjBLVVl3o8xeiIaRTUpwP7Eods73KMmvjGnDcZt0xRuI" +
           "I2Ess8oG57teKlkd0SjjoIIsfcHrlxHbQwS/QTMDWVoJ/tQlzF4ZJeIONhkl" +
           "i7lDMgukNVo6G7mnM3MOtZb01LHFlTMM5xaTVqph6Kddqi+BecKtwQr9cU0Y" +
           "0O1Bp20I/oaclzNlgJtST6DLjJOhOLvoTTYdO/Q3cVkRl46F92W5nnTbphcg" +
           "sSUtg6bRb3TQTCNIz5kxfJ3CI7cmkoSY9HqbWHHWCK1tnSraMvyRRUnCiqtG" +
           "mEWNq+Ji3jPMWY1bDlBzuWZaESnZTMseM6tI3G7WjIfPszEx5vpelRlxS3Jd" +
           "bkneCsclg0ewlkjpErKFCaOy5JjywEXKzIyhAiKYD7YGPZojJcaak2rgduNy" +
           "ksCyq8WlumHApMPNwQGB5nBt7gbDdTKfuggDTyySHWXuusdHU7PaXC+FJrsR" +
           "O8TAkHVl5GSyUtK1YcmWyrPZsuVjydRAF+HcqKx4rNxwJKs+rKNb2K9agSBV" +
           "g2RlVCoog3GosJFq82U4ogm2J6zKkbMezhwTLmu6PjTK+lIbUG48oqTmYGyE" +
           "VkBiMyHwvPm0PLHDfq/DZ2UP9yICQ8CxWhNHk0awjQ2lsvCZmr8sez2KbC+E" +
           "oN7WqhS+soJBFHg8TPHKLAk268VcR8uW2QoMvBmMLWM+5rIhTCw8tk1Zfp/o" +
           "VIE/2qQ4mHQ5D555nQ6htFITJUmiHYy3XG3uGCPD7HZ7VWzdwZUlSoaG2J0O" +
           "a71hmxDKi1bGMzIuC4LMk0tNHvaXcXWdTTxkCKeKYwewlm1GOA5MVdW7Fm+g" +
           "wWaAx7IF0/wm0tIeqpv0IlqO5yiNLSV8LrVwlB0ZWVshBaNOLEcTa9gKOkyY" +
           "6ksbJ70y5QC/X0cewDNqwvclx+wRYA6Kwrtbyg76TQtb6Kow3fQ6fuZr7Vbc" +
           "4dWoIUnpxBiP6u3GBFPWFXFVTdIw9OZjRhwjTHuz4fCV4wmoxHC4DG+91qgr" +
           "EoLpTWxsgTFeyBLdgPAaXYMWGyVlygPhHKnPK157lRAzeeqVlPpqCbsYO9Jn" +
           "E6MGR0tjUaoOvACv2Cpu82u8S80ShvRw4Kx6o0OStJygLalU0rk6OVSUdmeF" +
           "pZFNhl1+iniNqsZUMmSjpyur7rtVBY4BIpZFfCh1jAZDcmwYzBpcWxyX0brN" +
           "ytuob/gUZXMDm0MntYQkmJHAVAdWSawhfqM9F7t0u9TYcsyMDtkhkyZ2tCqH" +
           "8mI5RKVFhoW9FoZNmXYt7eowN6moGVlBt46H2EK93Wvz1fmgSQXbFi5um526" +
           "LLODbaseocuIb8BqWsHbppSN6M4KqQ5MNBqQwC5KZZh5RCXVNS4NtnzcIhtV" +
           "EuuXl7gmTjiHXXHy1Pc9Yhyx3na8KeGTkbM2OwtWoiOmwa+cMV8157NgDdu9" +
           "usoKmZ5t5ouG1GoRLNqjUJCNWi5MS2yN683UFEXs+YpstMcxl2HZltkoDJuM" +
           "005/kuBOMIaDsbhRG9iYrPTpATWgV8nEGfQya8a0tjOmEdqjDQgCJ+i3F56E" +
           "kuhiwrYCeLVu0LzlM8G2UdVn4yBUufVShNs9DjPqYkWQhHVp7jJq3HWCZF0a" +
           "NavbGh+OqnppSWnNabueIbCBuFGo95WGStPBGHEslnSm47DDwlFLXnLuct1W" +
           "Z2O9NrQFdyYbZMdT8YHRWIcoLOIDfeIm1jbopJSeuk0LLDe90cx5Wwvs1pir" +
           "cfJ8JAii0qHWQ2Mwcm05TZolZtXvSIw7Y0RybOvsHK+AhJ/IGkzVBD52epMK" +
           "Wi9hoT8ha7Ut3xXZPF3oWZ+lTGy1WCrdFoiIFJbHLlaplf3uJmouvKxaGgzD" +
           "GqY3GwGpyzDmNEF+U+cOxXCNtDMcK1VFKtkKvK0v1TJBKp7Oo4vVyGAr5mxW" +
           "rjUXqjEtrYZGzYwIdrYRHaG07ax6Q81vC4NKoIYrDpFjt2LHC8cRhfF6UcaA" +
           "jcryNOqva2ob3zT5VaWOTKqdxVBkuGqLcEYCt5hVO22iPa1NhSiusyg3LZfm" +
           "BsuZkue36EnHMJpZzUgGpGT12FKDClO2ElcdNO4ifSfDJtU+glUr1ASp1uW5" +
           "1AmkRi8Y9ueM48oj0pdieYklRuBlzUajtK0hoa76pbknS7TXRWpBBamlrJfU" +
           "OSNOQZpb1A1mvBgmkwlwWZaV5osoihfBNuB8odue6Oy6I6odD5E62w2b1rXK" +
           "wLcAnDmNqmp3+lJbYAKEdWwEd+m5HekTeJZMPIFjiB6VGul2JrfnmN5ewclq" +
           "so7nrui7I4QjmnF/0nL1zHdhOAP941kdiLgdJDFfH8wssDKdPjFz5Y3aa9vZ" +
           "ImzLWUPuxdXqCqaEZTjTPIOw041GtJQ0M2qxbgtpHW4SW1mvDOqmLThG3ExT" +
           "ntapsJINEtlOe32jtJ3KGqkiSUXZNifmWLap9phtr+oqFvVqZNz0ZZxOSmgc" +
           "NhEdm6sratjSKare8oI+mrT4pGfiLjMsoxKxbpWR5czFuyFimF7szw2P2k76" +
           "oW/WFwgM1pbuhhMsNbFy0x06gwarV7B2Y9D3G8iIZRsl2xk1h3UTy4bK0Hck" +
           "tTY3hlWigbsVeNyuT1vtuJXy3UBFLLEhaPPpJOUaJkAXwYviso7WFTgplUp8" +
           "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" +
           "KAAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "8UWjRM6nfYYPEl+PMEkqonrS1rEWqqKiMNSHLEuxltJq2WBPYJRqEU9Qo8Ja" +
           "DIuJgKorSqemeonQq2DD+/rXZ1vhX3tppxE35IcsB7fYP8PxSnrhBncOGzy8" +
           "D8lPsG84eSF65LTqyNk2lB043HGxO+v8sOGpdz7+pEx9uLSzdyfwjhg6vfcq" +
           "waGey4GaBy5+qjLK7+sPD6q/+M5/vZ1+g/7Wl3CPd9cJkCdVfnT09Jd7r5Le" +
           "twNddnBsfd6bBMcrPXj8sPqaUImT0KWPHVnfcfwu7Q7Qnc/sdeszJw8BD8fz" +
           "wieAr9n6wyXuW37vEmUfzJInYuhKJVWkJN5e+K2POM7DMXT50jPkQ496/wud" +
           "6xxtI89433FzbwdmfnbP3M/+/M396CXK/iBLngImJa6c3/w/eWjXh38edj27" +
           "Z9ezP3+7nrlE2Wey5FPArlA5z65P/x/sujXLPAfs+fyeXZ//+dv1uUuUfSFL" +
           "/iSGrot0sFOWsYs76ZWi59mK4B7a/exLsTuNodsu9grC/gVo82d9uQHQ2G3n" +
           "vWe1fTdI+sSTZ6669Unmr/Nb/IP3d64eQlepiW0fvfU68nzaDxXVyHvo6u0d" +
           "mJ///EUM3f1CIGPomsM/uWlf21b+RgzdfMHKwK2yn6OyfxlDZ0/KxtAV+e9R" +
           "uW+B1g7lAMdvH46K/F0MXQZEsse/9198V7fFKA4FKWZAIG/vyfOxSk8dn4cO" +
           "vOHGF/KGI1PXfcfmnPxFuv35Idm+SveQ9Mkn++Tbnq9/ePsWg2QLm02m5aoh" +
           "dOX2hYqDOeaei2rb13Uav/8n13/q6lfuT4bXbwEfhtYRbHdd+JUBzPHj/JJ/" +
           "89lb/+h1H3ny2/ldx/8CN9L9wuEoAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "IOe+yLusufQf/ImYTaIcAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "avYU8b9CZsCmJycAAA==");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZfWwUxxWfO39gG3+DMTFgwBxUfPQuJKFNZEqCHRtMz+aE" +
           "wVVN4djbnfMt3ttddmftsxNaiBRBooZSSoC2gX/qCIpIoFVRWrWJHEVpEkgT" +
           "kbgltAqpmkqhJahBVVNU2qZvZvduP+7DddTU0s3Nzbz35r03b37vzfjMDVSi" +
           "a6gZyyRIRlSsBztkEuE0HQvtEqfrm2Esyh8t4v66/VrPfX5U2o+qE5zezXM6" +
           "7hSxJOj9aJ4o64STeaz3YCxQjoiGdawNcURU5H7UIOpdSVUSeZF0KwKmBH2c" +
           "FkZ1HCGaGDMI7rIEEDQvDJqEmCahtd7p1jCq5BV1xCaf7SBvd8xQyqS9lk5Q" +
           "bXgnN8SFDCJKobCok9aUhparijQyICkkiFMkuFNaZblgQ3hVlgtaztV8fPtg" +
           "opa5YAYnywph5umbsK5IQ1gIoxp7tEPCSX0X+joqCqPpDmKCAuH0oiFYNASL" +
           "pq21qUD7KiwbyXaFmUPSkkpVnipE0EK3EJXTuKQlJsJ0BgllxLKdMYO1CzLW" +
           "mlZmmfjk8tDho9trf1yEavpRjSj3UnV4UILAIv3gUJyMYU1fKwhY6Ed1Mmx2" +
           "L9ZEThJHrZ2u18UBmSMGbH/aLXTQULHG1rR9BfsItmkGTxQtY16cBZT1qyQu" +
           "cQNg6yzbVtPCTjoOBlaIoJgW5yDuLJbiQVEWCJrv5cjYGPgyEADrtCQmCSWz" +
           "VLHMwQCqN0NE4uSBUC+EnjwApCUKBKBGUFNeodTXKscPcgM4SiPSQxcxp4Cq" +
           "nDmCshDU4CVjkmCXmjy75NifGz2rDzwkr5f9yAc6C5iXqP7TganZw7QJx7GG" +
           "4RyYjJXLwke4Wc/v9yMExA0eYpPmuYdvPrCiefxVk2ZODpqNsZ2YJ1F+LFZ9" +
           "aW770vuKqBplqqKLdPNdlrNTFrFmWlMqIMysjEQ6GUxPjm/65Vf3nMbX/aii" +
           "C5XyimQkIY7qeCWpihLW1mEZaxzBQhcqx7LQzua70DToh0UZm6Mb43Edky5U" +
           "LLGhUoX9BhfFQQR1UQX0RTmupPsqRxKsn1IRQvXwQY0IFb2M2J/5TdBgKKEk" +
           "cYjjOVmUlVBEU6j9eggQJwa+TYRiEPWDIV0xNAjBkKINhDiIgwS2JjhV1UP6" +
           "0EBMU4YBDUPrAXUUbaTN/NmVDt4gDTr1/7tcilo/Y9jng42Z64UFCajWK5KA" +
           "tSh/2GjruPls9KIZcvSYWH4jKAIaBE0NgkyDINUgaGsQzKNBAEAaTlQPwHMb" +
           "jisableSSU4WkM/HFJpJNTSjBPZ4ENAC5FQu7d22Ycf+liIIT3W4GDaIkra4" +
           "0la7DSnpPBDlz9ZXjS68uvIlPyoOo3qOJwYn0Sy0VhsAfOMHLQiojEFCs/PK" +
           "AkdeoQlRU3gsAKzlyy+WlDJlCGt0nKCZDgnprEfPdyh/zsmpPxo/Nry37xt3" +
           "+pHfnUrokiWAgpQ9QhNABugDXgjJJbdm37WPzx7Zrdhg4spN6ZSaxUltaPGG" +
           "jNc9UX7ZAu589PndAeb2cgB7wsHhBBxt9q7hwqrWNO5TW8rAYIiPJCfRqbSP" +
           "K0gCAsoeYbFcx/ozISxq6OFdAqf4fes0s286O0ulbaMZ+zTOPFawvPKlXvX4" +
           "O2/86W7m7nQKqnHUDr2YtDpgjwqrZwBXZ4ftZg1joHv3WOQ7T97Yt5XFLFAs" +
           "yrVggLZwAmgOBzc/+uquK+9dHZvw23FOIO8bMSifUhkjy6hN1QWMhNWW2PoA" +
           "bEqAJTRqAltkiE8xLnIxCdOD9c+axSvPf3ig1owDCUbSYbRicgH2+B1taM/F" +
           "7X9vZmJ8PE3bts9sMjMXzLAlr9U0boTqkdr71rzvvsIdh6wCSK6Lo5iBczHz" +
           "QTGzfDZUcYyTZuigmaEzExSNhu/mg4KSDFJooeP3soZt+CpGeCdr76HOYnIR" +
           "m2ulzWLdeXDcZ9NRmkX5gxMfVfV99MJNZqm7tnPGSTentpqhSZslKRDf6AW2" +
           "9ZyeALp7xnu+ViuN3waJ/SCRB3jXN2qAvylXVFnUJdN+++JLs3ZcKkL+TlQh" +
           "KZzQybEDisrhZGA9AdCdUu9/wIyMYRoqtcxUlGV81gDdnPm5t70jqRK2UaM/" +
           "bfzJ6pMnrrIIVU0Zcxg/vUjMdSEyuyHYoHD67S/++uS3jwybNcbS/Ejo4Zv9" +
           "j41S7JE/3MpyOcPAHPWPh78/dOappvY11xm/DUaUO5DKzoAA6DbvXaeTf/O3" +
           "lL7sR9P6US1vVeR9nGTQI94PVaieLtOhanfNuytKs3xqzYDtXC8QOpb1wqCd" +
           "eaFPqWm/yoN8rI5ZCGBwwQKFC17k8yHW6WYsn2PtMtp8Pg005aqmENASCx6s" +
           "qSsgFtgg5CAFwdZnTt0Mxr+aNj2mrPvzhuQ6twkUvN+01nozjwl9pgm0iWRr" +
           "mo+boGrQtAfCrVcEQJUHcqn7lU+h7oS14EQedbcVVDcfN6gr4+FJ1N0+RXWb" +
           "YaEr1oJX8qgrFFQ3HzfNU3mDAE9RzXmwwFVroat51BwsqGY+boJK+IQoCbm0" +
           "lApomcp9avy0GwTbdXZbts9NcVoR17XCmaNt5EQ0PczLd/Njt9axRw6fEDY+" +
           "vdLEznr3bapDNpLP/OZfrweP/f61HKV6qXVztxcspuu5oLqb3Yht3Hu3+tD7" +
           "PwsMtE2lbqZjzZNUxvT3fLBgWX7096ryyiN/btq8JrFjCiXwfI8vvSJ/2H3m" +
           "tXVL+EN+dv03ATnr2cDN1OqG4QoNE0OTN7vAeJG7DKVBfMPa/RveILZDj0Xw" +
           "8uziLh9rgVLm0QJz+2izh8DlOYV5g2C9YAqOaGISKtwh6wkhtLv+vcGnrj1j" +
           "hp8333qI8f7Dj38SPHDYDEXzUWZR1ruIk8d8mGFq1pqO+AT+fPD5N/1QG+gA" +
           "/Yas2m69DizIPA/QQkRDCwupxZbo/ODs7p+f2r3Pb/kkRVDxkCIKNgTsnQyo" +
           "ChdQdKBDZeMPu4OhCXbylrWjt6YeDPlYC2z49wvMHafNEbDekAX2LvJN2wVH" +
           "P0MXFJsire8puSAvawEzTxWYO02bH4ALNJzlgrHPwAWNdC4A+luGmN9Tc0E+" +
           "1gJmni8w9xxtzhFUBbcGQxI6MsDgeFihoN9rxHTiOeR3RXbw+wORP5qIcEcO" +
           "BpOu4VToib7LO19n6F1G00UGMx2pAtKK4zpfS5snTMc+5uh/C9ArpigS5uSM" +
           "Pb7Ma9BMtw7m8g8+VvOLg/VFnZDHulCZIYu7DNwluLF8mm7EHErZ77Q2slsa" +
           "URAiyLcsffFhwfKj/0WwABI15nkYS99x7/20L27gm9lZj//mgzX/7ImassYT" +
           "Wy6zPJ95VK6ErYobkuS8dzj6paqG4yJzTKV5C1HZ10WCFkymJEEV9g9m2gWT" +
           "+Q2CGnIywxGlX07aS9aN30kLhR37dtJNwGo2HVRCZsdJcpmgIiCh3XfU/97V" +
           "ayHANSiLtgB+mk8hbK9SPndZlwmShsmCxFEJLnKlZfbfnXRcG+b/d6L82RMb" +
           "eh66+YWnzYcqXuJGR6mU6RDN5ptZphZamFdaWlbp+qW3q8+VL05nxTpTYRuO" +
           "5jgwowMOm0ofCpo8rzh6IPOYc2Vs9Qu/2l/6FhQAW5GPI2jG1uybcEo1oAjd" +
           "Gs4+tVA3suel1qXfG1mzIv6X37G3BuuUz81PH+UnTm57+9DssWY/mt6FSiDh" +
           "4xS7oj84Im/C/JDWj6pEvSMFKoIUkZNckFBNo5+jr0rML5Y7qzKj9JmToJbs" +
           "Qib7cbhCUoax1qZAdrVAZbo94vq3k3WiKgxV9TDYIw5kHDdxiO4GxG003K2q" +
           "6cLI94HKsORFLzSyQcZ9nXVp8+F/AE7g6BL5HQAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "N6QoAAA=");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "oDAcedkNi2yQcd9iXdp88B/W4Lqu8R0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "SHVDXrSwUtIllNZiFnWW63Z+HPkEuuDxADV1qt2Cufa8FerOrNHiBWeANRWx" +
           "jpX0gd2m3F4jttrLFe04DSrqlAnOo8v5Bg9Xcj4pO2TDRprweJBveiKaL3cZ" +
           "LK7WChGNMYJoWp0JPyaatanMhWiVqpjGDI9qraU8JbAljutUXY/qPE1ieYLS" +
           "JbzbclAWblCy29BydG8y1PjBsNymJ3CzzXOyZKkkwa1XHQKjkvbMKasFQIB4" +
           "BEiBdOfMUq8WZm6nwJmsEEbDRRnP8ahRHAkoGqy8pkcZxWgmdKZxn1NJyyEL" +
           "ywWHydMk0qaR57j1jtdKkqQl8lK9NRT7lSbGMkmpL/KD5aKqm8MyH+C+hfZz" +
           "8ZK1uZKOFGF+2MwVtMa82ENKQmWlzD2eYHPJqIX1Oo7mhsQUG1tIY11KEikH" +
           "q11ubiTTQtKXely3NeDcvKUItGwFxRlqi90ZBcMG4yvauDG1K1atThOaApwJ" +
           "G3JyseGjSht47dQemiYdcUTZA2OzGBYWU7PUIfFWJx+FbdRcCXYvPxvm0K5c" +
           "JzR0za9bldaKW5uUUyjUye4ktzbjoe+W1ythWEaq8GQqrNmiW2O7gZQPy53R" +
           "It8TSwKlq1hFldqFdUWgE7zi5Xl0VK2q01WvPpPWPYZc5NEWXPDpltNdyMXu" +
           "eiIVV9PpFGnE9dGK0hRS8VCwCtGuyTcSk3WHgoLTo0ZBdHs1zNV1tLfsNlb5" +
           "AgHjvIHNFKHD5ydIOdbC0EvwnLqc1/XeZNBT+0ZoUxbBFmtco2YiIiIrVsuX" +
           "67lSP4CVyOggDMaQq6RvjkFkpWvLHrtipnNrWYvdhDAw1HWi+WwRwSW9O+2s" +
           "k1Co451hWbJ7bEP1S50h0ZPGSq45sekkh3Xt+aS8EntFuVofdYDRjooLWI21" +
           "nsEGatsqjyREw9B1WQoYehX1y7XaiLURdBgUrfaYC31Ua9UKSs5aki3AP+4Q" +
           "r+rxasLarISF89CG1+JowHJFHRhJQvTxwnwcLJfYamA2hZY9jHkWrk1pT4mk" +
           "FWVQq1bijMVBZZTIZN3wPV1sYAEmE+pwVqomtNEZ9p0lq8RDsyFU83pdtelR" +
           "Kajk5ss+URhqHUTuzvHQY23Zw2ihF6VLBbIa8h01wZIwzk+cZh2uKAiChusx" +
           "j0ZSbSgwU6OfqyrFGiiOtRVRnFZrCad0sSYz6hrFqq5xTTeFFMQGgg+lYaGE" +
           "tNc2ipVxeTXVNH6KDAsmsiaNwqTj4J7mdeQKJzTsfjHC2iYWjKVWPdbKEzUv" +
           "8f3QHlp6U4ZHqB4QRW+2IL1yrj0dBizs9lalEVZYN7ASY0SLNjOqLKpJfVQe" +
           "TXy70AyUwK2yei4nTpwlWcMGcT6eDPMBxjA4npBkW18WuzbjivNmVZXHTmfU" +
           "Q6y6YrL8jBtFfQdXynmsOeuW633WIauVEYtXiz1hpEs9mByVq5hOOGxJYIpG" +
           "qYYV1bGlL1frJRN6DuOVQpJSiUmNc7RKKEmejGNhwPZVxcpN1RFJ5avFJt9t" +
           "DYtEF8vlhQgjylGRyi+n/WpxplsgDkskx2qrgpigQdxrSa7dnjYMBDAMsAi1" +
           "MPTG3fkgWRkhxUyUyoCyacOaReOSbBf9eO7G1a4hFljRFmb2ZKRp1cFYoLUV" +
           "I46RijdXCLdYSTQnF606IyTIOzQcumh96a1EWZ0TYJKW81Ux7CPlWQDGfz0e" +
           "+NLEa1vdkkbgE3+NIrBsCloX7FViD2UNhXLNDsaM5VLOQOKwho7HbFKcz4u2" +
           "mFerWKkd2Vii8suYayR5oaNS46WC1mPSUsSB00FFEJwmeJEUQiMmqHJ/rK7N" +
           "SZLvJfN4NOHQnjyd8GHdsDvtKu/hQicaUcKAbFNcgYabEV/MyzkE6fKsiBYj" +
           "BcSu1JqEp92kNY/Y5nwWzqT6mmY6ZpmsNNcNuprwnZwUxeQ0KlWb3RVsNQtO" +
           "vSnVpwtqLK9FDe+Llo0JS3rZmMW0PJ6Qbh4JmfkqhqeF5rQtdReLfgkP+zNR" +
           "p7CeZmFLj8D7PbVM1Sdwu8tNGgYJtttrtdJfwX6jN6+MsZkNV0D07RbcCCsX" +
           "h24clMiVtSyh3MAuT9qqO8tVXBgmpu2IAjHhGOCuyjJaZ0w8NnXf6uogpmGx" +
           "0gBrwz2V4yLNqtB4zcP4zooqzSr2XBoT7SU5QjthPHeSqIFXRu2GXiwHIHqh" +
           "y6WuRuGIXUdW9VV9OEBbkVbvCSrCrGYLBBnW5HU9xyzHILDnxMDs4ZIiFGwJ" +
           "nq1FrjGJ4WJNrjbK+EgQ+9R66E80Hp7kJUbk8UK3NIvh1TSknLFA2iUGxCht" +
           "l4lMVFWrI2VUL9Vz5U7BlaLiSF+J/CTnEHhzMRLLMMzgOqxWENrUMWMkm2Dk" +
           "mWIBGU+D9phd1ZliO25OYW5m2UjINwU3KtlBPm9x63VkCVWsEI+FfsBWS3I3" +
           "N+grQqzzlhl5Bt7m1h6xaDCu2R44TcbD191AjOS1FfFCqTBooDkLqTD98VoN" +
           "YbsvtbmVGLgVv7HMm7khNhSb/KqlTtptne4XivkmrOXV1YzDR84ALP3BzO3S" +
           "XLQauiWbENTWor4EYXFvFI/QuNUYFMa1fG7eCBoIMjbA6r4urF1AeVyphMbN" +
           "pYku+v7UzbesntGTK4WRyFmzeGyZ7mgwkkdwaTQeuLLll+lgIhMU2Ab5MEXh" +
           "cZSb8eiAZVxNqfeRktG0ixMzzyDFqtIx5UU3LtJYtTmRc3M4lpSh3XN6TY30" +
           "F1U/T699SbLyJSGYN/IyUCv2an5Jt1f1Eqwt5ggzWgOHhVlbM5JJYKlLyhh0" +
           "J2gsVew6WmsV1hji6GV9sGh6A7rRpsmx3scURWCbTglEI+SKY8pKpb0mZjXU" +
           "GDicHNLJGJ0ws6k5lJJCIuIiPyREaZJDAdMs7OUsGQuUUmclut4f2vVeYoQR" +
           "FTciM9/OLcvtbht26piiqQvWKCQ9Ra0ZY9WtVnFkhDLLsNrPgY3to4+mW95f" +
           "fmmnDjdnhyn7N9Av4xglvnqHx7cdbi80svPom49eZh44jjpwUg2lBwt3X+u+" +
           "OTtUeOYdTz6tch/OH9894X9rAJ3a/QxgK+cEEPPwtU9POtld+/bY+Qvv+Ne7" +
           "+DfMHn8JF3H3HlHyqMiPdJ79UuM1yvuOQzfsH0Jf8RXA4UaPHD56PudpQejZ" +
           "/KED6LsPX4alp3zM7rAyR0/5tvN59SO+127s4Tq3J79znbIPpslTAXRaizUl" +
           "DDY3dskBw3kigE6sHEPdWtT7X+j85mAfWcb7DsO9C8Dkd+HyP324H7lO2e+n" +
           "yTMAUmir2a3901tcH/5p4HpsF9djP31cn75O2WfS5JMAl6ddgetT/wdcd6SZ" +
           "wNNPPL6L6/GfPq7PXafs82nyJwF0kz9zQlMlr22kp2XHMTXJ3uL+7EvBHQfQ" +
           "rVf5fGDv8rL6cr9JAAx25xWfR20+6VE+/vSFM3c8Pfzr7AZ+/7Obswx0Zhqa" +
           "5sHrqwPPp1xPmxrZ4JzdXGa52c9fBNB9L6RkAJ3bvmTQvrpp/PUAuu2qjYFF" +
           "pT8H6/7l7lXuwboBdDL7PVjvm6C3bT1A75uHg1X+LoBuAFXSx793X/xQY7If" +
           "eJISDIEPb+64s7mKjx1egvYN4ZYXMoQDq9aDh5ab7Pu3vaUh3HwBd1n5xNMt" +
           "9i3Plz+8+QJBMaX1OpVyhoFObz6G2F9e7r+mtD1Zp5oP/fj8J8++em8dPL9R" +
           "eOtVB3S79+rX/aTlBtkF/fqP7vjD1//u09/KrjP+F2m14MOYKAAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "j//Mt/74y39cHdv/X6n5Lp1TJwAA");
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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1ZDXBUVxW+u/khv+QHQmiAACHg8ONuaUttJ0gLaQLBTbJD" +
           "II7Bstx9ezf7yNv3Hu/dTTapaGGmEp0RkQJFpYzj0KEiLR1H1I5tRRltO63O" +
           "tMVi7ZQyakfaytiMY3FExXPvfbvvZ38Qx5qZffv23nPuPefcc75zzs2pK6jM" +
           "NFArUWmAjuvEDHSpNIwNk8Q6FWyam2EsIj1Sgv+y7XLf3X5UPoSmJ7DZK2GT" +
           "dMtEiZlDaJ6smhSrEjH7CIkxjrBBTGKMYipr6hBqks2epK7Ikkx7tRhhBIPY" +
           "CKEGTKkhR1OU9FgLUDQvBJIEuSTBtd7pjhCqkTR93Caf7SDvdMwwyqS9l0lR" +
           "fWgHHsXBFJWVYEg2aUfaQMt1TRkfVjQaIGka2KGsskywMbQqxwRtT9V9eG1/" +
           "op6bYAZWVY1y9cxNxNSUURILoTp7tEshSXMn+jwqCaFqBzFF7aHMpkHYNAib" +
           "ZrS1qUD6WqKmkp0aV4dmVirXJSYQRQvdi+jYwElrmTCXGVaooJbunBm0XZDV" +
           "VmiZo+Kh5cGDj2yr/14JqhtCdbI6wMSRQAgKmwyBQUkySgxzbSxGYkOoQYXD" +
           "HiCGjBV5wjrpRlMeVjFNwfFnzMIGUzox+J62reAcQTcjJVHNyKoX5w5l/SqL" +
           "K3gYdJ1l6yo07GbjoGCVDIIZcQx+Z7GUjshqjKL5Xo6sju2fAgJgnZYkNKFl" +
           "typVMQygRuEiClaHgwPgeuowkJZp4IAGRS0FF2W21rE0godJhHmkhy4spoCq" +
           "khuCsVDU5CXjK8EptXhOyXE+V/pW73tA3aD6kQ9kjhFJYfJXA1Orh2kTiROD" +
           "QBwIxpplocN41rOTfoSAuMlDLGh++Lmpe1e0nn1B0MzJQ9Mf3UEkGpGOR6e/" +
           "Mrdz6d0lTIwKXTNldvguzXmUha2ZjrQOCDMruyKbDGQmz276xWcePEne96Oq" +
           "HlQuaUoqCX7UIGlJXVaIsZ6oxMCUxHpQJVFjnXy+B02D95CsEjHaH4+bhPag" +
           "UoUPlWv8N5goDkswE1XBu6zGtcy7jmmCv6d1hFAjfFAzQqVvIv4nvikaCSa0" +
           "JAliCauyqgXDhsb0N4OAOFGwbSIYBa8fCZpaygAXDGrGcBCDHySINYF13Qya" +
           "o8NRQxsDNAxuANTRjPF14mdPxnkDzOn0/+92aab9jDGfDw5mrhcWFKDaoCkx" +
           "YkSkg6l1XVNPRl4SLsfCxLIbRf0gQUBIEOASBJgEAVuCQAEJ2jsTEGGkD+B5" +
           "ECsp0qklk1iNIZ+PyzOTCSicBI54BMAClqlZOnD/xu2TbSXgnfpYKZwPI21z" +
           "Za1OG1EyaSAinW6snVh4ceU5PyoNoUYs0RRWWBJaawwDvEkjFgLURCGf2Wll" +
           "gSOtsHxoaBKJAaoVSi/WKhXaKDHYOEUzHStkkh4L72DhlJNXfnT2yNjuwS/c" +
           "6kd+dyZhW5YBCDL2MMP/LM63exEk37p1ey9/ePrwLs3GEldqymTUHE6mQ5vX" +
           "Y7zmiUjLFuAzkWd3tXOzVwLWUwyxCTDa6t3DBVUdGdhnulSAwnHNSGKFTWVs" +
           "XEUT4E/2CHflBv4+E9yijsXuYgji96xg5t9sdpbOns3C9ZmfebTgaeWTA/qj" +
           "v/nVu7dzc2cyUJ2jdBggtMOBemyxRo5vDbbbbjYIAbq3joQfPnRl71bus0Cx" +
           "KN+G7ewJEcBSOJj5oRd2vvH2xePn/bafU0j7qShUT+mskhVMp+lFlITdltjy" +
           "AGoqACXMa9q3qOCfclzGUYWwwPpH3eKVZ/60r174gQIjGTdaceMF7PFb1qEH" +
           "X9p2tZUv45NY1rZtZpOJVDDDXnmtYeBxJkd696vzvv48fhSSCgC5KU8Qjs0l" +
           "3AYlXPPZUMRxTpagAyJBZycYGI3dLgViWjLAkIWN38nPehWnuZU/72B24ksi" +
           "PtfBHotNZ8y4w9JRlEWk/ec/qB384LkprqS7qnO6SC/WO4RXsseSNCzf7MW0" +
           "DdhMAN0dZ/s+W6+cvQYrDsGKEgC72W8A8qZdDmVRl0377U/Pzdr+Sgnyd6Mq" +
           "RcOxbsxjE1VCUBAzAaCd1u+5VzjFGPOSeq4qylE+Z4Cdy/z8J96V1Ck/o4kf" +
           "NX9/9YljF7lz6mKNOZzfz/KIC4x5b2DjwcnXPvHrE187PCaqi6WFQdDDN/vv" +
           "/Up0z+/+lmNyDn95Kh8P/1Dw1NGWzjXvc34bhxh3ezo39wGW27y3nUz+1d9W" +
           "/nM/mjaE6iWrFucpC6J7COpPM1OgQ73umnfXkqJw6sji7FwvBjq29SKgnXPh" +
           "nVGz91oP6PEKZhHgwCULDy55Qc+H+EsvZ/kYfy5jj49nMKZSNzQKUpKYB2Ya" +
           "iixLUbUkuoNMyN0l0JU9V7NHn1jtnoJOud6tRBvs8o612zsFlBgUSrBHOFfW" +
           "QtwUVahkjJ8OxwaPoJ8uImg6v9X87DUA8GzyPsm2W2lGFldB6YRnO3IQg4d5" +
           "hWp+3q8c33PwWKz/sZUidhrddXQXtIlPvP7PlwNHLr2Yp0grt3o2e8NStp8r" +
           "VHt5L2T7/VvTD/z+6fbhdTdTMrGx1hsURez3fNBgWeHo94ry/J73WjavSWy/" +
           "iepnvseW3iW/03vqxfVLpAN+3viJgMxpGN1MHe4wrDIIdLjqZlcwLnJXIPPA" +
           "0FPW6U/lr0CyTrw8N68XYi2SyvQicxzvRii0TWkiQTtrFoXgsCEnobgZtZrH" +
           "4K7Gt0eOXn5CuJ8Xbz3EZPLgl68H9h0Urija8UU5HbGTR7TkXMx6YYjr8OeD" +
           "z7/Yh+nABtg3oGqn1RcuyDaGLBEZaGExsfgW3X88vevHj+/a67dsAjVK6agm" +
           "x2wIUG6EVcUTKBvoEqcw7HaGFjjJq9aJXr15ZyjEWuTAv1hkbpI9doP2KTXG" +
           "O+Ix2wR7PkoTXLP0uHbzJijEWkTNh4vMHWKPfWACg+SY4KsfgQma2Vw7yH/d" +
           "0uP6zZugEGsRNb9VZO7b7PFNimqhakwpsa4sMDh6agb6A6moST1Bflt4uzTZ" +
           "Hv6DQIRb8jAIuqbHg18ZvLDjZY7eFSxdZDHTkSogrTg6uXr2SAvDUsf7BKBX" +
           "VNMUgtWsPr7sRcBMtwxi+/u+VPfM/saSbshjPagipco7U6Qn5sbyaWYq6hDK" +
           "vqGzkd2SiIEQRb5lmcKXO8vR/4WzpKFbyn8lkulu7vpvr1rANLNzbn3FTaX0" +
           "5LG6iuZjWy7wNJ+9TayBk4qnFMVZdjrey3WDxGVulxpRhOr86wcULbiRkBRV" +
           "2T+4amcE89MUNeVlhghlX07aZ6xez0lLURn/dtL9BHaz6aAQEi9Okp9RVAIk" +
           "7PWc/p+bei34twFV0RaAT9EE87NK+9xVXdZHmm7kI45CcJErK/Nr/Yxbp8TF" +
           "fkQ6fWxj3wNTdz4mrigkBU9MsFWqwZnFbUm2FFpYcLXMWuUbll6b/lTl4kxS" +
           "bBAC22g0xwEZXRBrOusTWzz9u9mebePfOL76uV9Olr8K+X8r8mGKZmzNbYTS" +
           "egpq0K2h3KCFspFfLHQs/cb4mhXxP7/JW00ryOcWpo9I50/c/9qB2cdb/ai6" +
           "B5VBvidp3qHdN65uItKoMYRqZbMrDSLCKjJWXIgwnXk/ZvcJ3C6WOWuzo+yC" +
           "i6K23Dom91oQ2vIxYqzTILlamFJtj7j+32BFVFVK1z0M9ogDGL8rYIidBvht" +
           "JNSr65m6yPeuzqHklBcZ+SDnfp2/sseFfwNmSkVS8hsAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "UgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tK5WPFU1N8X5BK0n5ECRuvWxolRrsU26");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "5C8MD1bCfxmvCndLCzLxpoM3tPm/2wvHVk8feUN7ZIFcIXtL9vi1Frjnb8g+" +
       "8f7nPy5T31/a2y0s/ImwcFfoeu+wlFixjlT1FlDT09d+GzjM1/cfLnj7pff/" +
       "6WPcV2vvuYEFwa8/pufxKn9o+KnP9N8s/bO9wm0Hy9+u+vLgykLPXLno7W5f" +
       "CSPf4a5Y+vb4lYtyh4Xt2pDC/u/Rd9+HbXfyi++3btv+2LrNc4cZinmGl05Z" +
       "2PlfMvHZsPBQoGRvvY+tC82L/OgRu/nxsHA+dnX50KD+4/VeUR69Y57wmQMG" +
       "skX5hbeAQ9sxoN10Bsg8w+dPYeD3M/Hfw8JrJV8RQ2X/1T/vydu/jq4gGH25" +
       "a+IvXrvanMXfPgOLb8gSm+AIdiwGN5XFgxWOGfakIl2SXftStkQmL/S/T2H2" +
       "/2TiT8LCI1tmszLt7dqmI+sq/vCQhD89KwlfBY737Uh4380l4ejb/yu90VhM" +
       "chd3Wfpp5vMvfSx94VPbl/sLEXSpAnStz8Gu/iIt+4jgTad8CHH4odBf9b/q" +
       "xT/5A+Hd+070FQc0PJOh7pxGw35znrTcHFw6t5fX+LfXbtZzF7LEvw4Ljx42" +
       "a9DxXc+7Vrv+zVldRLZo8dt3gL795hv33x3crbRvRafd7dzeAU/n7juFp1dl" +
       "4u6wcHHL0zhfT8YqVr4CK/saImfuRMrOveIMlOXjShccH9mB+Mgt8QfF6/pC" +
       "3pHd7QcROcSclMdPISyLPM49EhZe5wGn6fr2iT4zK/i5Q6IePQNRj2WJEDhe" +
       "2BH1ws0h6igm6JRr78jEm0HktlTCqxfUfeQQ5FvOag0UOF7cgXzx5oC87TAY" +
       "/YtDkeOqn4K5mYlyWLjHAcaP7dZLH2vTyhngvj5LzBbY/uoO7q/ecrjtU+B2" +
       "M/HVV/jKfdDHQgvyyw4trlVpzuXXnNV0RoCWh7dlt7+3lEvmFC7ZTJBh4RWZ" +
       "6YwPV+cesZzhGdA+kSXWgOJv3qF98y1H++5T0F7OxPSK4GmH+ZjhEGcynBPq" +
       "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" +
       "5ptK/X9n+guNwl8AAA==");
}
