package edu.umd.cs.findbugs.gui2;
public class SpringUtilities {
    public static void printSizes(java.awt.Component c) { if (edu.umd.cs.findbugs.gui2.MainFrame.
                                                                GUI2_DEBUG) {
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "minimumSize = " +
                                                                  c.
                                                                    getMinimumSize(
                                                                      ));
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "preferredSize = " +
                                                                  c.
                                                                    getPreferredSize(
                                                                      ));
                                                              java.lang.System.
                                                                out.
                                                                println(
                                                                  "maximumSize = " +
                                                                  c.
                                                                    getMaximumSize(
                                                                      ));
                                                          }
    }
    public static void makeGrid(java.awt.Container parent,
                                int rows,
                                int cols,
                                int initialX,
                                int initialY,
                                int xPad,
                                int yPad) {
        javax.swing.SpringLayout layout;
        try {
            layout =
              (javax.swing.SpringLayout)
                parent.
                getLayout(
                  );
        }
        catch (java.lang.ClassCastException exc) {
            if (edu.umd.cs.findbugs.gui2.MainFrame.
                  GUI2_DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "The first argument to makeGrid must use SpringLayout.");
            }
            return;
        }
        javax.swing.Spring xPadSpring =
          javax.swing.Spring.
          constant(
            xPad);
        javax.swing.Spring yPadSpring =
          javax.swing.Spring.
          constant(
            yPad);
        javax.swing.Spring initialXSpring =
          javax.swing.Spring.
          constant(
            initialX);
        javax.swing.Spring initialYSpring =
          javax.swing.Spring.
          constant(
            initialY);
        int max =
          rows *
          cols;
        javax.swing.Spring maxWidthSpring =
          layout.
          getConstraints(
            parent.
              getComponent(
                0)).
          getWidth(
            );
        javax.swing.Spring maxHeightSpring =
          layout.
          getConstraints(
            parent.
              getComponent(
                0)).
          getWidth(
            );
        for (int i =
               1;
             i <
               max;
             i++) {
            javax.swing.SpringLayout.Constraints cons =
              layout.
              getConstraints(
                parent.
                  getComponent(
                    i));
            maxWidthSpring =
              javax.swing.Spring.
                max(
                  maxWidthSpring,
                  cons.
                    getWidth(
                      ));
            maxHeightSpring =
              javax.swing.Spring.
                max(
                  maxHeightSpring,
                  cons.
                    getHeight(
                      ));
        }
        for (int i =
               0;
             i <
               max;
             i++) {
            javax.swing.SpringLayout.Constraints cons =
              layout.
              getConstraints(
                parent.
                  getComponent(
                    i));
            cons.
              setWidth(
                maxWidthSpring);
            cons.
              setHeight(
                maxHeightSpring);
        }
        javax.swing.SpringLayout.Constraints lastCons =
          null;
        javax.swing.SpringLayout.Constraints lastRowCons =
          null;
        for (int i =
               0;
             i <
               max;
             i++) {
            javax.swing.SpringLayout.Constraints cons =
              layout.
              getConstraints(
                parent.
                  getComponent(
                    i));
            if (i %
                  cols ==
                  0) {
                lastRowCons =
                  lastCons;
                cons.
                  setX(
                    initialXSpring);
            }
            else {
                assert lastCons !=
                  null;
                cons.
                  setX(
                    javax.swing.Spring.
                      sum(
                        lastCons.
                          getConstraint(
                            javax.swing.SpringLayout.
                              EAST),
                        xPadSpring));
            }
            if (i /
                  cols ==
                  0) {
                cons.
                  setY(
                    initialYSpring);
            }
            else {
                assert lastRowCons !=
                  null;
                cons.
                  setY(
                    javax.swing.Spring.
                      sum(
                        lastRowCons.
                          getConstraint(
                            javax.swing.SpringLayout.
                              SOUTH),
                        yPadSpring));
            }
            lastCons =
              cons;
        }
        assert lastCons !=
          null;
        javax.swing.SpringLayout.Constraints pCons =
          layout.
          getConstraints(
            parent);
        pCons.
          setConstraint(
            javax.swing.SpringLayout.
              SOUTH,
            javax.swing.Spring.
              sum(
                javax.swing.Spring.
                  constant(
                    yPad),
                lastCons.
                  getConstraint(
                    javax.swing.SpringLayout.
                      SOUTH)));
        pCons.
          setConstraint(
            javax.swing.SpringLayout.
              EAST,
            javax.swing.Spring.
              sum(
                javax.swing.Spring.
                  constant(
                    xPad),
                lastCons.
                  getConstraint(
                    javax.swing.SpringLayout.
                      EAST)));
    }
    private static javax.swing.SpringLayout.Constraints getConstraintsForCell(int row,
                                                                              int col,
                                                                              java.awt.Container parent,
                                                                              int cols) {
        javax.swing.SpringLayout layout =
          (javax.swing.SpringLayout)
            parent.
            getLayout(
              );
        java.awt.Component c =
          parent.
          getComponent(
            row *
              cols +
              col);
        return layout.
          getConstraints(
            c);
    }
    public static void makeCompactGrid(java.awt.Container parent,
                                       int rows,
                                       int cols,
                                       int initialX,
                                       int initialY,
                                       int xPad,
                                       int yPad) {
        javax.swing.SpringLayout layout;
        try {
            layout =
              (javax.swing.SpringLayout)
                parent.
                getLayout(
                  );
        }
        catch (java.lang.ClassCastException exc) {
            if (edu.umd.cs.findbugs.gui2.MainFrame.
                  GUI2_DEBUG) {
                java.lang.System.
                  err.
                  println(
                    "The first argument to makeCompactGrid must use SpringLayout.");
            }
            return;
        }
        javax.swing.Spring x =
          javax.swing.Spring.
          constant(
            initialX);
        for (int c =
               0;
             c <
               cols;
             c++) {
            javax.swing.Spring width =
              javax.swing.Spring.
              constant(
                0);
            for (int r =
                   0;
                 r <
                   rows;
                 r++) {
                width =
                  javax.swing.Spring.
                    max(
                      width,
                      getConstraintsForCell(
                        r,
                        c,
                        parent,
                        cols).
                        getWidth(
                          ));
            }
            for (int r =
                   0;
                 r <
                   rows;
                 r++) {
                javax.swing.SpringLayout.Constraints constraints =
                  getConstraintsForCell(
                    r,
                    c,
                    parent,
                    cols);
                constraints.
                  setX(
                    x);
                constraints.
                  setWidth(
                    width);
            }
            x =
              javax.swing.Spring.
                sum(
                  x,
                  javax.swing.Spring.
                    sum(
                      width,
                      javax.swing.Spring.
                        constant(
                          xPad)));
        }
        javax.swing.Spring y =
          javax.swing.Spring.
          constant(
            initialY);
        for (int r =
               0;
             r <
               rows;
             r++) {
            javax.swing.Spring height =
              javax.swing.Spring.
              constant(
                0);
            for (int c =
                   0;
                 c <
                   cols;
                 c++) {
                height =
                  javax.swing.Spring.
                    max(
                      height,
                      getConstraintsForCell(
                        r,
                        c,
                        parent,
                        cols).
                        getHeight(
                          ));
            }
            for (int c =
                   0;
                 c <
                   cols;
                 c++) {
                javax.swing.SpringLayout.Constraints constraints =
                  getConstraintsForCell(
                    r,
                    c,
                    parent,
                    cols);
                constraints.
                  setY(
                    y);
                constraints.
                  setHeight(
                    height);
            }
            y =
              javax.swing.Spring.
                sum(
                  y,
                  javax.swing.Spring.
                    sum(
                      height,
                      javax.swing.Spring.
                        constant(
                          yPad)));
        }
        javax.swing.SpringLayout.Constraints pCons =
          layout.
          getConstraints(
            parent);
        pCons.
          setConstraint(
            javax.swing.SpringLayout.
              SOUTH,
            y);
        pCons.
          setConstraint(
            javax.swing.SpringLayout.
              EAST,
            x);
    }
    public SpringUtilities() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
