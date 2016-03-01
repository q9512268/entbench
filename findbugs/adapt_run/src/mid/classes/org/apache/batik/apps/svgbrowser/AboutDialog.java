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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Lzl6jROcgeNLrCbE9qo3q29cskYlpWFBt4RoRVvVVn/oOD7cd/CkbNJTC12U" +
       "VpN13RDWbFfU0HkKG+aM6kYNtrRk4QF4Q+LpAht0hFrAC5KsjEMptUEE4dJ+" +
       "s6W7UZ9rdUKjqLS7baHTN6w6t7bmi1G949TqtjtbUcMyFXJRvdEF68wEGU7B" +
       "zuunsi2Z98p2xXflm/2D67n/wzY/udHpXP45B5240jl5Onff/qmgBz1ws1u3" +
       "fHf7/HueeU7tfwLZ2TuNswLoYuC4bzS1SDOPNJVdWTxx8518L790PDzh+uJ7" +
       "/uX+8VsW73gFtxUPndDzZJO/23vhy63XKx/agU4fnHdddx16vNKTx0+5Lnla" +
       "EHr2+NhZ1wPHj0yzw0V+z7P8LY5MT6LgVI6C7djf+Hw0e31rLvD0LU5D35cl" +
       "vxhA92TXfI6SO22kmXJ+JOHkVRZHcAN8cCZyDPUQUL/0So5P84x3HXjgzizz" +
       "gdzo7Wf9SjwAkON6TqApgabe0BFH7Xz2FmW/mSUfCqALs9Aw1dakk73/6qGJ" +
       "H35FJ8QBdNuR48ns2uG+6/4tsL3hVj7z3OULr3lu8tf5ZdXBLfRFBrqgh6Z5" +
       "9Lz0yPM519N0I1f84vb01M1/fjuAHn65O8QAunT4kqv+W9vKzwME3LAyGO/s" +
       "56jsJwPoyknZADqb/x6V+xTo7VAugM5tH46KfDqATgOR7PEz7v7RaX5Lk+z6" +
       "sWHPd2kBkIYTJ6eO08zB2Nz9cmNzhJkeO8Yn+T899ud+uP2vxzXls8/R7Dtf" +
       "qn5iew+nmHKaZq1cYKDz2yvBA/545Kat7bd1rv34D+783MXX7XPdnVuFDzF9" +
       "RLeHbnzpRVlukF9TpX/4mt9/8yef+0Z+dvq/sIhZuIIjAAA=");
}
