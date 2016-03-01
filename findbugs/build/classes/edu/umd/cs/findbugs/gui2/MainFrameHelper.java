package edu.umd.cs.findbugs.gui2;
public class MainFrameHelper {
    public static javax.swing.JButton newButton(java.lang.String key, java.lang.String name) {
        javax.swing.JButton b =
          new javax.swing.JButton(
          );
        edu.umd.cs.findbugs.gui.AnnotatedString.
          localiseButton(
            b,
            key,
            name,
            false);
        return b;
    }
    public static javax.swing.JMenuItem newJMenuItem(java.lang.String key,
                                                     java.lang.String string,
                                                     int vkF) { javax.swing.JMenuItem m =
                                                                  new javax.swing.JMenuItem(
                                                                  );
                                                                edu.umd.cs.findbugs.gui.AnnotatedString.
                                                                  localiseButton(
                                                                    m,
                                                                    key,
                                                                    string,
                                                                    false);
                                                                m.
                                                                  setMnemonic(
                                                                    vkF);
                                                                return m;
    }
    public static javax.swing.JMenuItem newJMenuItem(java.lang.String key,
                                                     java.lang.String string) {
        javax.swing.JMenuItem m =
          new javax.swing.JMenuItem(
          );
        edu.umd.cs.findbugs.gui.AnnotatedString.
          localiseButton(
            m,
            key,
            string,
            true);
        return m;
    }
    public static javax.swing.JMenu newJMenu(java.lang.String key,
                                             java.lang.String string) {
        javax.swing.JMenu m =
          new javax.swing.JMenu(
          );
        edu.umd.cs.findbugs.gui.AnnotatedString.
          localiseButton(
            m,
            key,
            string,
            true);
        return m;
    }
    public static boolean isMacLookAndFeel() {
        java.lang.String name =
          javax.swing.UIManager.
          getLookAndFeel(
            ).
          getClass(
            ).
          getName(
            );
        return name.
          startsWith(
            "com.apple");
    }
    public static void attachAcceleratorKey(javax.swing.JMenuItem item,
                                            int keystroke) {
        attachAcceleratorKey(
          item,
          keystroke,
          0);
    }
    public static void attachAcceleratorKey(javax.swing.JMenuItem item,
                                            int keystroke,
                                            int additionalMask) {
        if (!edu.umd.cs.findbugs.gui2.MainFrame.
               MAC_OS_X &&
              additionalMask !=
              0) {
            return;
        }
        item.
          setAccelerator(
            javax.swing.KeyStroke.
              getKeyStroke(
                keystroke,
                java.awt.Toolkit.
                  getDefaultToolkit(
                    ).
                  getMenuShortcutKeyMask(
                    ) |
                  additionalMask));
    }
    public static void attachAcceleratorKeyNoCtrl(javax.swing.JMenuItem item,
                                                  int keyEvent) {
        item.
          setAccelerator(
            javax.swing.KeyStroke.
              getKeyStroke(
                keyEvent,
                0));
    }
    public MainFrameHelper() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "60T+dA5tgMeaCXwr+R+cl+U+zB0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
