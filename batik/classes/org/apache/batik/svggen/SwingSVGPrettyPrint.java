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
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "xSs2P/8faUXHuFgZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaeczsVnX3+5KXvPdI8l4SSNKUrDxow8Dn2TyLHtt4ZryM" +
       "PTOesT2LoTy8je3xOrbHYxtCAbGkUFFKA00lyB8oqAWFpVUpVSuqoKoFBKpE" +
       "hbpJBVRVKi1FIn+UVqUtvfZ8+1uip4iRfOfOveeee8655/zu8b3z7I+g04EP" +
       "FTzXSjTLDXfVONxdWshumHhqsNujEUb0A1VpW2IQcKDtsvzoF8//5Kcf0S/s" +
       "QLcI0N2i47ihGBquE4zVwLUiVaGh84etXUu1gxC6QC/FSITXoWHBtBGEl2jo" +
       "JUeGhtBFel8EGIgAAxHgXAS4dUgFBt2uOmu7nY0QnTBYQe+ETtHQLZ6ciRdC" +
       "jxxn4om+aO+xYXINAIcz2e8JUCofHPvQwwe6b3W+QuGPFeAnf/utF/7gJui8" +
       "AJ03HDYTRwZChGASAbrNVm1J9YOWoqiKAN3pqKrCqr4hWkaayy1AdwWG5ojh" +
       "2lcPjJQ1rj3Vz+c8tNxtcqabv5ZD1z9Qb2GolrL/6/TCEjWg6z2Hum41xLJ2" +
       "oOA5AwjmL0RZ3R9ys2k4Sgg9dHLEgY4XKUAAht5qq6HuHkx1syOCBuiu7dpZ" +
       "oqPBbOgbjgZIT7trMEsI3X9NppmtPVE2RU29HEL3naRjtl2A6mxuiGxICL3s" +
       "JFnOCazS/SdW6cj6/Gjwug+/3SGcnVxmRZWtTP4zYNCDJwaN1YXqq46sbgfe" +
       "9mr64+I9X3liB4IA8ctOEG9pvvyO59/0mgef+/qW5hevQjOUlqocXpafke74" +
       "9svbjzVvysQ447mBkS3+Mc1z92f2ei7FHoi8ew44Zp27+53Pjf9y/q7Pqj/c" +
       "gc6R0C2ya61t4Ed3yq7tGZbq46qj+mKoKiR0VnWUdt5PQreCOm046rZ1uFgE" +
       "akhCN1t50y1u/huYaAFYZCa6FdQNZ+Hu1z0x1PN67EEQdAE80BvA81po+8m/" +
       "Q+itsO7aKizKomM4Lsz4bqZ/AKtOKAHb6rAEvN6EA3ftAxeEXV+DReAHurrf" +
       "EWma6sDsBjgSO8EZXw3DhAFuBYAH+Jn3c58hznS8sDl1Cpj/5SeD3wJxQ7iW" +
       "ovqX5SfXaPf5z1/+5s5BMOxZJ4QKYNLd7aS7+aS720l3rzIpdOpUPtdLs8m3" +
       "ywwWyQThDoDwtsfYX+m97YlHbwL+5W1uBhbOSOFr43H7ECDIHAZl4KXQc09t" +
       "3j351eIOtHMcWDOBQdO5bDiTweEB7F08GVBX43v+Az/4yRc+/rh7GFrHkHov" +
       "4q8cmUXsoydN67uyqgAMPGT/6ofFL13+yuMXd6CbAQwA6AtF4KoAVR48Ocex" +
       "yL20j4KZLqeBwgvXt0Ur69qHrnOh7rubw5Z8ze/I63cCG78R2iuO+XbWe7eX" +
       "lS/d+ki2aCe0yFH29az3yb/7q3+t5ObeB+TzR7Y4Vg0vHQGBjNn5PNzvPPQB" +
       "zldVQPePTzG/9bEffeDNuQMAildcbcKLWdkGwQ+WEJj5fV9f/f33vvvMd3YO" +
       "nSYEu+Basgw53ir5M/A5BZ7/y55MuaxhG8B3tfdQ5OEDGPGymV91KBsAFAuE" +
       "XOZBF3nHdhVjYYiSpWYe+z/nX1n60r9/+MLWJyzQsu9Sr3lhBoftv4BC7/rm" +
       "W//zwZzNKTnb0A7td0i2Rcm7Dzm3fF9MMjnid//1A7/zNfGTAG8BxgVGquaw" +
       "BeX2gPIFLOa2KOQlfKKvnBUPBUcD4XisHUk8Lssf+c6Pb5/8+M+ez6U9nrkc" +
       "Xfe+6F3aulpWPBwD9veejHpCDHRAV31u8JYL1nM/BRwFwFEGSBYMfYA78TEv" +
       "2aM+fes/fPXP73nbt2+CdjDonOWKCibmAQedBZ6uBjqArNh745u23rw5s4/f" +
       "MXSF8lsHuS//dRMQ8LFrYw2WJR6H4Xrffw8t6T3/9F9XGCFHmavstyfGC/Cz" +
       "n7i//YYf5uMPwz0b/WB8JRaDJO1wbPmz9n/sPHrLX+xAtwrQBXkvA5yI1joL" +
       "IgFkPcF+WgiyxGP9xzOY7XZ96QDOXn4Sao5MexJoDvcAUM+os/q5wwV/LD4F" +
       "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" +
       "JAAA");
}
