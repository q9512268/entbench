package org.apache.batik.svggen;
public abstract class SwingSVGPrettyPrint implements org.apache.batik.svggen.SVGSyntax {
    public static void print(javax.swing.JComponent cmp, org.apache.batik.svggen.SVGGraphics2D svgGen) {
        if (cmp instanceof javax.swing.JComboBox ||
              cmp instanceof javax.swing.JScrollBar) {
            printHack(
              cmp,
              svgGen);
            return;
        }
        org.apache.batik.svggen.SVGGraphics2D g =
          (org.apache.batik.svggen.SVGGraphics2D)
            svgGen.
            create(
              );
        g.
          setColor(
            cmp.
              getForeground(
                ));
        g.
          setFont(
            cmp.
              getFont(
                ));
        org.w3c.dom.Element topLevelGroup =
          g.
          getTopLevelGroup(
            );
        if (cmp.
              getWidth(
                ) <=
              0 ||
              cmp.
              getHeight(
                ) <=
              0)
            return;
        java.awt.Rectangle clipRect =
          g.
          getClipBounds(
            );
        if (clipRect ==
              null)
            g.
              setClip(
                0,
                0,
                cmp.
                  getWidth(
                    ),
                cmp.
                  getHeight(
                    ));
        paintComponent(
          cmp,
          g);
        paintBorder(
          cmp,
          g);
        paintChildren(
          cmp,
          g);
        org.w3c.dom.Element cmpGroup =
          g.
          getTopLevelGroup(
            );
        cmpGroup.
          setAttributeNS(
            null,
            "id",
            svgGen.
              getGeneratorContext(
                ).
              idGenerator.
              generateID(
                cmp.
                  getClass(
                    ).
                  getName(
                    )));
        topLevelGroup.
          appendChild(
            cmpGroup);
        svgGen.
          setTopLevelGroup(
            topLevelGroup);
    }
    private static void printHack(javax.swing.JComponent cmp, org.apache.batik.svggen.SVGGraphics2D svgGen) {
        org.apache.batik.svggen.SVGGraphics2D g =
          (org.apache.batik.svggen.SVGGraphics2D)
            svgGen.
            create(
              );
        g.
          setColor(
            cmp.
              getForeground(
                ));
        g.
          setFont(
            cmp.
              getFont(
                ));
        org.w3c.dom.Element topLevelGroup =
          g.
          getTopLevelGroup(
            );
        if (cmp.
              getWidth(
                ) <=
              0 ||
              cmp.
              getHeight(
                ) <=
              0)
            return;
        java.awt.Rectangle clipRect =
          g.
          getClipBounds(
            );
        if (clipRect ==
              null) {
            g.
              setClip(
                0,
                0,
                cmp.
                  getWidth(
                    ),
                cmp.
                  getHeight(
                    ));
        }
        cmp.
          paint(
            g);
        org.w3c.dom.Element cmpGroup =
          g.
          getTopLevelGroup(
            );
        cmpGroup.
          setAttributeNS(
            null,
            "id",
            svgGen.
              getGeneratorContext(
                ).
              idGenerator.
              generateID(
                cmp.
                  getClass(
                    ).
                  getName(
                    )));
        topLevelGroup.
          appendChild(
            cmpGroup);
        svgGen.
          setTopLevelGroup(
            topLevelGroup);
    }
    private static void paintComponent(javax.swing.JComponent cmp,
                                       org.apache.batik.svggen.SVGGraphics2D svgGen) {
        javax.swing.plaf.ComponentUI ui =
          javax.swing.UIManager.
          getUI(
            cmp);
        if (ui !=
              null) {
            ui.
              installUI(
                cmp);
            ui.
              update(
                svgGen,
                cmp);
        }
    }
    private static void paintBorder(javax.swing.JComponent cmp,
                                    org.apache.batik.svggen.SVGGraphics2D svgGen) {
        javax.swing.border.Border border =
          cmp.
          getBorder(
            );
        if (border !=
              null) {
            if (cmp instanceof javax.swing.AbstractButton ||
                  cmp instanceof javax.swing.JPopupMenu ||
                  cmp instanceof javax.swing.JToolBar ||
                  cmp instanceof javax.swing.JMenuBar ||
                  cmp instanceof javax.swing.JProgressBar) {
                if (cmp instanceof javax.swing.AbstractButton &&
                      ((javax.swing.AbstractButton)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JPopupMenu &&
                      ((javax.swing.JPopupMenu)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JToolBar &&
                      ((javax.swing.JToolBar)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JMenuBar &&
                      ((javax.swing.JMenuBar)
                         cmp).
                      isBorderPainted(
                        ) ||
                      cmp instanceof javax.swing.JProgressBar &&
                      ((javax.swing.JProgressBar)
                         cmp).
                      isBorderPainted(
                        ))
                    border.
                      paintBorder(
                        cmp,
                        svgGen,
                        0,
                        0,
                        cmp.
                          getWidth(
                            ),
                        cmp.
                          getHeight(
                            ));
            }
            else {
                border.
                  paintBorder(
                    cmp,
                    svgGen,
                    0,
                    0,
                    cmp.
                      getWidth(
                        ),
                    cmp.
                      getHeight(
                        ));
            }
        }
    }
    private static void paintChildren(javax.swing.JComponent cmp,
                                      org.apache.batik.svggen.SVGGraphics2D svgGen) {
        int i =
          cmp.
          getComponentCount(
            ) -
          1;
        java.awt.Rectangle tmpRect =
          new java.awt.Rectangle(
          );
        for (;
             i >=
               0;
             i--) {
            java.awt.Component comp =
              cmp.
              getComponent(
                i);
            if (comp !=
                  null &&
                  javax.swing.JComponent.
                  isLightweightComponent(
                    comp) &&
                  comp.
                  isVisible(
                    )) {
                java.awt.Rectangle cr =
                  null;
                boolean isJComponent =
                  comp instanceof javax.swing.JComponent;
                if (isJComponent) {
                    cr =
                      tmpRect;
                    ((javax.swing.JComponent)
                       comp).
                      getBounds(
                        cr);
                }
                else {
                    cr =
                      comp.
                        getBounds(
                          );
                }
                boolean hitClip =
                  svgGen.
                  hitClip(
                    cr.
                      x,
                    cr.
                      y,
                    cr.
                      width,
                    cr.
                      height);
                if (hitClip) {
                    org.apache.batik.svggen.SVGGraphics2D cg =
                      (org.apache.batik.svggen.SVGGraphics2D)
                        svgGen.
                        create(
                          cr.
                            x,
                          cr.
                            y,
                          cr.
                            width,
                          cr.
                            height);
                    cg.
                      setColor(
                        comp.
                          getForeground(
                            ));
                    cg.
                      setFont(
                        comp.
                          getFont(
                            ));
                    if (comp instanceof javax.swing.JComponent)
                        print(
                          (javax.swing.JComponent)
                            comp,
                          cg);
                    else {
                        comp.
                          paint(
                            cg);
                    }
                }
            }
        }
    }
    public SwingSVGPrettyPrint() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "TWXyeRgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OU+y/MzguW90Xsd/bAe54eCU5op7reONLh0/mznnAM93jNmxE5r7DsbgjtTk" +
       "TfgW98agePXT3+uMbeZMWz86cca4s6XaH7q7shuHXTe9Ftjtpac6pgH2rjVh" +
       "9WuvM7Idh7M2Mu8Wth0F1znMfHea2B5y2kovHDIS+ojvzj3kxsCUhUOndl7s" +
       "KOFoD1mBcWC+O9PCDnzftme+t70U83nIGShkwHngRW2YfoZpEmdUH7qOAX49" +
       "TX4NunRmgC7Hq2nBew4Vfv/LVZjKSLdP9FL95YmXqutT19H16TT5TQ+5zeKg" +
       "rgcudULhj71chUn4fmBP4Q/83BX+1HUUfjZNPukhr8gUbprpKfkJbZ95udr2" +
       "4fupPW0/9XPX9vPX0faLafIZD7l1O7wbWRMcYJzQ97MvRd/IQ+68yr1kerFy" +
       "zxV/jNhe5vOff+b82bufYf4mu5o7uHC/mULOir6mHT0HP5K/yXKAKGda3Lw9" +
       "Fbeyny97yN3XALr0FDzLZFL/4Zb+jz3kwkl6CG7Z71G6r3jIuUM6yGqbOUry" +
       "vIfcAEnS7Fetq5ygb68DolNHVsA9B8nsfMeL2fmgydGbu3TVzP6Ysr/C+du/" +
       "plzmv/BMb/iuFyqf3t4c8hqXJCmXsxRyZnuJebBKPnRNbvu8buo+8tPbvnjz" +
       "a/dX9Nu2Ah866xHZHrj61Vxbt7zsMi35o7v/4E2/+8x3swP9/wO15KyrMSQA" +
       "AA==");
}
