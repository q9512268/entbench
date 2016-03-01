package edu.umd.cs.findbugs.gui2;
@java.lang.SuppressWarnings("serial") 
public class BugRenderer extends javax.swing.tree.DefaultTreeCellRenderer {
    @java.lang.Override
    public java.awt.Component getTreeCellRendererComponent(javax.swing.JTree tree,
                                                           java.lang.Object node,
                                                           boolean selected,
                                                           boolean expanded,
                                                           boolean leaf,
                                                           int row,
                                                           boolean hasFocus) {
        java.awt.Component toReturn =
          super.
          getTreeCellRendererComponent(
            tree,
            node,
            selected,
            expanded,
            leaf,
            row,
            hasFocus);
        if (!(node instanceof edu.umd.cs.findbugs.gui2.BugLeafNode)) {
            return toReturn;
        }
        else {
            edu.umd.cs.findbugs.BugInstance bug =
              ((edu.umd.cs.findbugs.gui2.BugLeafNode)
                 node).
              getBug(
                );
            final java.awt.Color c;
            switch (bug.
                      getPriority(
                        )) {
                case edu.umd.cs.findbugs.Priorities.
                       LOW_PRIORITY:
                    c =
                      new java.awt.Color(
                        0.4F,
                        0.4F,
                        0.6F);
                    break;
                case edu.umd.cs.findbugs.Priorities.
                       NORMAL_PRIORITY:
                    if (bug.
                          isDead(
                            )) {
                        c =
                          new java.awt.Color(
                            0.2F,
                            0.2F,
                            0.2F);
                    }
                    else {
                        c =
                          new java.awt.Color(
                            255,
                            204,
                            0);
                    }
                    break;
                case edu.umd.cs.findbugs.Priorities.
                       HIGH_PRIORITY:
                    if (bug.
                          isDead(
                            )) {
                        c =
                          new java.awt.Color(
                            0.65F,
                            0.2F,
                            0.2F);
                    }
                    else {
                        c =
                          new java.awt.Color(
                            0.85F,
                            0,
                            0);
                    }
                    break;
                case edu.umd.cs.findbugs.Priorities.
                       EXP_PRIORITY:
                case edu.umd.cs.findbugs.Priorities.
                       IGNORE_PRIORITY:
                default:
                    c =
                      java.awt.Color.
                        blue;
                    break;
            }
            if (leaf) {
                javax.swing.Icon icon =
                  new javax.swing.Icon(
                  ) {
                    @java.lang.Override
                    public void paintIcon(java.awt.Component comp,
                                          java.awt.Graphics g,
                                          int x,
                                          int y) {
                        java.awt.Graphics2D g2 =
                          (java.awt.Graphics2D)
                            g;
                        g2.
                          setRenderingHint(
                            java.awt.RenderingHints.
                              KEY_ANTIALIASING,
                            java.awt.RenderingHints.
                              VALUE_ANTIALIAS_ON);
                        g2.
                          setColor(
                            c);
                        g2.
                          fillOval(
                            2,
                            2,
                            12,
                            12);
                        g2.
                          setColor(
                            java.awt.Color.
                              BLACK);
                        g2.
                          drawOval(
                            2,
                            2,
                            12,
                            12);
                    }
                    @java.lang.Override
                    public int getIconWidth() {
                        return 16;
                    }
                    @java.lang.Override
                    public int getIconHeight() {
                        return 16;
                    }
                };
                ((edu.umd.cs.findbugs.gui2.BugRenderer)
                   toReturn).
                  setIcon(
                    icon);
            }
            return toReturn;
        }
    }
    public BugRenderer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DZ5UFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/l8BZQdiqSIAAA==");
}
