package org.apache.batik.apps.svgbrowser;
public class AboutDialog extends javax.swing.JWindow {
    public static final java.lang.String ICON_BATIK_SPLASH = "AboutDialog.icon.batik.splash";
    public AboutDialog() { super();
                           buildGUI(); }
    public AboutDialog(java.awt.Frame owner) { super(owner);
                                               buildGUI();
                                               addKeyListener(new java.awt.event.KeyAdapter(
                                                                ) {
                                                                  public void keyPressed(java.awt.event.KeyEvent e) {
                                                                      if (e.
                                                                            getKeyCode(
                                                                              ) ==
                                                                            java.awt.event.KeyEvent.
                                                                              VK_ESCAPE) {
                                                                          setVisible(
                                                                            false);
                                                                          dispose(
                                                                            );
                                                                      }
                                                                  }
                                                              });
                                               addMouseListener(
                                                 new java.awt.event.MouseAdapter(
                                                   ) {
                                                     public void mousePressed(java.awt.event.MouseEvent e) {
                                                         setVisible(
                                                           false);
                                                         dispose(
                                                           );
                                                     }
                                                 });
    }
    public void setLocationRelativeTo(java.awt.Frame f) {
        java.awt.Dimension invokerSize =
          f.
          getSize(
            );
        java.awt.Point loc =
          f.
          getLocation(
            );
        java.awt.Point invokerScreenLocation =
          new java.awt.Point(
          loc.
            x,
          loc.
            y);
        java.awt.Rectangle bounds =
          getBounds(
            );
        int dx =
          invokerScreenLocation.
            x +
          (invokerSize.
             width -
             bounds.
               width) /
          2;
        int dy =
          invokerScreenLocation.
            y +
          (invokerSize.
             height -
             bounds.
               height) /
          2;
        java.awt.Dimension screenSize =
          getToolkit(
            ).
          getScreenSize(
            );
        if (dy +
              bounds.
                height >
              screenSize.
                height) {
            dy =
              screenSize.
                height -
                bounds.
                  height;
            dx =
              invokerScreenLocation.
                x <
                screenSize.
                  width >>
                1
                ? invokerScreenLocation.
                    x +
                invokerSize.
                  width
                : invokerScreenLocation.
                    x -
                bounds.
                  width;
        }
        if (dx +
              bounds.
                width >
              screenSize.
                width) {
            dx =
              screenSize.
                width -
                bounds.
                  width;
        }
        if (dx <
              0)
            dx =
              0;
        if (dy <
              0)
            dy =
              0;
        setLocation(
          dx,
          dy);
    }
    protected void buildGUI() { getContentPane(
                                  ).setBackground(
                                      java.awt.Color.
                                        white);
                                java.lang.ClassLoader cl =
                                  this.
                                  getClass(
                                    ).
                                  getClassLoader(
                                    );
                                java.net.URL url =
                                  cl.
                                  getResource(
                                    org.apache.batik.apps.svgbrowser.Resources.
                                      getString(
                                        ICON_BATIK_SPLASH));
                                javax.swing.ImageIcon icon =
                                  new javax.swing.ImageIcon(
                                  url);
                                int w = icon.
                                  getIconWidth(
                                    );
                                int h = icon.
                                  getIconHeight(
                                    );
                                javax.swing.JLayeredPane p =
                                  new javax.swing.JLayeredPane(
                                  );
                                p.setSize(
                                    600,
                                    425);
                                getContentPane(
                                  ).add(p);
                                javax.swing.JLabel l =
                                  new javax.swing.JLabel(
                                  icon);
                                l.setBounds(
                                    0,
                                    0,
                                    w,
                                    h);
                                p.add(l, new java.lang.Integer(
                                        0));
                                javax.swing.JLabel l2 =
                                  new javax.swing.JLabel(
                                  "Batik " +
                                  org.apache.batik.Version.
                                    getVersion(
                                      ));
                                l2.setForeground(
                                     new java.awt.Color(
                                       232,
                                       232,
                                       232,
                                       255));
                                l2.setOpaque(
                                     false);
                                l2.setBackground(
                                     new java.awt.Color(
                                       0,
                                       0,
                                       0,
                                       0));
                                l2.setHorizontalAlignment(
                                     javax.swing.JLabel.
                                       RIGHT);
                                l2.setVerticalAlignment(
                                     javax.swing.JLabel.
                                       BOTTOM);
                                l2.setBounds(
                                     w -
                                       320,
                                     h -
                                       117,
                                     300,
                                     100);
                                p.add(l2,
                                      new java.lang.Integer(
                                        2));
                                ((javax.swing.JComponent)
                                   getContentPane(
                                     )).setBorder(
                                          javax.swing.BorderFactory.
                                            createCompoundBorder(
                                              javax.swing.BorderFactory.
                                                createBevelBorder(
                                                  javax.swing.border.BevelBorder.
                                                    RAISED,
                                                  java.awt.Color.
                                                    gray,
                                                  java.awt.Color.
                                                    black),
                                              javax.swing.BorderFactory.
                                                createCompoundBorder(
                                                  javax.swing.BorderFactory.
                                                    createCompoundBorder(
                                                      javax.swing.BorderFactory.
                                                        createEmptyBorder(
                                                          3,
                                                          3,
                                                          3,
                                                          3),
                                                      javax.swing.BorderFactory.
                                                        createLineBorder(
                                                          java.awt.Color.
                                                            black)),
                                                  javax.swing.BorderFactory.
                                                    createEmptyBorder(
                                                      10,
                                                      10,
                                                      10,
                                                      10))));
    }
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
