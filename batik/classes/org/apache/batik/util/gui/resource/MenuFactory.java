package org.apache.batik.util.gui.resource;
public class MenuFactory extends org.apache.batik.util.resources.ResourceManager {
    private static final java.lang.String TYPE_MENU = "MENU";
    private static final java.lang.String TYPE_ITEM = "ITEM";
    private static final java.lang.String TYPE_RADIO = "RADIO";
    private static final java.lang.String TYPE_CHECK = "CHECK";
    private static final java.lang.String SEPARATOR = "-";
    private static final java.lang.String TYPE_SUFFIX = ".type";
    private static final java.lang.String TEXT_SUFFIX = ".text";
    private static final java.lang.String MNEMONIC_SUFFIX = ".mnemonic";
    private static final java.lang.String ACCELERATOR_SUFFIX = ".accelerator";
    private static final java.lang.String ACTION_SUFFIX = ".action";
    private static final java.lang.String SELECTED_SUFFIX = ".selected";
    private static final java.lang.String ENABLED_SUFFIX = ".enabled";
    private static final java.lang.String ICON_SUFFIX = ".icon";
    private org.apache.batik.util.gui.resource.ActionMap actions;
    private javax.swing.ButtonGroup buttonGroup;
    public MenuFactory(java.util.ResourceBundle rb, org.apache.batik.util.gui.resource.ActionMap am) {
        super(
          rb);
        actions =
          am;
        buttonGroup =
          null;
    }
    public javax.swing.JMenuBar createJMenuBar(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenuBar(
                 name,
                 null);
    }
    public javax.swing.JMenuBar createJMenuBar(java.lang.String name,
                                               java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenuBar result =
          new javax.swing.JMenuBar(
          );
        java.util.List menus =
          getSpecializedStringList(
            name,
            specialization);
        java.util.Iterator it =
          menus.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            result.
              add(
                createJMenuComponent(
                  (java.lang.String)
                    it.
                    next(
                      ),
                  specialization));
        }
        return result;
    }
    protected java.lang.String getSpecializedString(java.lang.String name,
                                                    java.lang.String specialization) {
        java.lang.String s;
        try {
            s =
              getString(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            s =
              getString(
                name);
        }
        return s;
    }
    protected java.util.List getSpecializedStringList(java.lang.String name,
                                                      java.lang.String specialization) {
        java.util.List l;
        try {
            l =
              getStringList(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            l =
              getStringList(
                name);
        }
        return l;
    }
    protected boolean getSpecializedBoolean(java.lang.String name,
                                            java.lang.String specialization) {
        boolean b;
        try {
            b =
              getBoolean(
                name +
                '.' +
                specialization);
        }
        catch (java.util.MissingResourceException mre) {
            b =
              getBoolean(
                name);
        }
        return b;
    }
    protected javax.swing.JComponent createJMenuComponent(java.lang.String name,
                                                          java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        if (name.
              equals(
                SEPARATOR)) {
            buttonGroup =
              null;
            return new javax.swing.JSeparator(
              );
        }
        java.lang.String type =
          getSpecializedString(
            name +
            TYPE_SUFFIX,
            specialization);
        javax.swing.JComponent item =
          null;
        if (type.
              equals(
                TYPE_RADIO)) {
            if (buttonGroup ==
                  null) {
                buttonGroup =
                  new javax.swing.ButtonGroup(
                    );
            }
        }
        else {
            buttonGroup =
              null;
        }
        if (type.
              equals(
                TYPE_MENU)) {
            item =
              createJMenu(
                name,
                specialization);
        }
        else
            if (type.
                  equals(
                    TYPE_ITEM)) {
                item =
                  createJMenuItem(
                    name,
                    specialization);
            }
            else
                if (type.
                      equals(
                        TYPE_RADIO)) {
                    item =
                      createJRadioButtonMenuItem(
                        name,
                        specialization);
                    buttonGroup.
                      add(
                        (javax.swing.AbstractButton)
                          item);
                }
                else
                    if (type.
                          equals(
                            TYPE_CHECK)) {
                        item =
                          createJCheckBoxMenuItem(
                            name,
                            specialization);
                    }
                    else {
                        throw new org.apache.batik.util.resources.ResourceFormatException(
                          "Malformed resource",
                          bundle.
                            getClass(
                              ).
                            getName(
                              ),
                          name +
                          TYPE_SUFFIX);
                    }
        return item;
    }
    public javax.swing.JMenu createJMenu(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenu(
                 name,
                 null);
    }
    public javax.swing.JMenu createJMenu(java.lang.String name,
                                         java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenu result =
          new javax.swing.JMenu(
          getSpecializedString(
            name +
            TEXT_SUFFIX,
            specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        java.util.List items =
          getSpecializedStringList(
            name,
            specialization);
        java.util.Iterator it =
          items.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            result.
              add(
                createJMenuComponent(
                  (java.lang.String)
                    it.
                    next(
                      ),
                  specialization));
        }
        return result;
    }
    public javax.swing.JMenuItem createJMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJMenuItem(
                 name,
                 null);
    }
    public javax.swing.JMenuItem createJMenuItem(java.lang.String name,
                                                 java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JMenuItem result =
          new javax.swing.JMenuItem(
          getSpecializedString(
            name +
            TEXT_SUFFIX,
            specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        return result;
    }
    public javax.swing.JRadioButtonMenuItem createJRadioButtonMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJRadioButtonMenuItem(
                 name,
                 null);
    }
    public javax.swing.JRadioButtonMenuItem createJRadioButtonMenuItem(java.lang.String name,
                                                                       java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JRadioButtonMenuItem result;
        result =
          new javax.swing.JRadioButtonMenuItem(
            getSpecializedString(
              name +
              TEXT_SUFFIX,
              specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        try {
            result.
              setSelected(
                getSpecializedBoolean(
                  name +
                  SELECTED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
        return result;
    }
    public javax.swing.JCheckBoxMenuItem createJCheckBoxMenuItem(java.lang.String name)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        return createJCheckBoxMenuItem(
                 name,
                 null);
    }
    public javax.swing.JCheckBoxMenuItem createJCheckBoxMenuItem(java.lang.String name,
                                                                 java.lang.String specialization)
          throws java.util.MissingResourceException,
        org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        javax.swing.JCheckBoxMenuItem result;
        result =
          new javax.swing.JCheckBoxMenuItem(
            getSpecializedString(
              name +
              TEXT_SUFFIX,
              specialization));
        initializeJMenuItem(
          result,
          name,
          specialization);
        try {
            result.
              setSelected(
                getSpecializedBoolean(
                  name +
                  SELECTED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
        return result;
    }
    protected void initializeJMenuItem(javax.swing.JMenuItem item,
                                       java.lang.String name,
                                       java.lang.String specialization)
          throws org.apache.batik.util.resources.ResourceFormatException,
        org.apache.batik.util.gui.resource.MissingListenerException {
        try {
            javax.swing.Action a =
              actions.
              getAction(
                getSpecializedString(
                  name +
                  ACTION_SUFFIX,
                  specialization));
            if (a ==
                  null) {
                throw new org.apache.batik.util.gui.resource.MissingListenerException(
                  "",
                  "Action",
                  name +
                  ACTION_SUFFIX);
            }
            item.
              setAction(
                a);
            item.
              setText(
                getSpecializedString(
                  name +
                  TEXT_SUFFIX,
                  specialization));
            if (a instanceof org.apache.batik.util.gui.resource.JComponentModifier) {
                ((org.apache.batik.util.gui.resource.JComponentModifier)
                   a).
                  addJComponent(
                    item);
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            java.lang.String s =
              getSpecializedString(
                name +
                ICON_SUFFIX,
                specialization);
            java.net.URL url =
              actions.
              getClass(
                ).
              getResource(
                s);
            if (url !=
                  null) {
                item.
                  setIcon(
                    new javax.swing.ImageIcon(
                      url));
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            java.lang.String str =
              getSpecializedString(
                name +
                MNEMONIC_SUFFIX,
                specialization);
            if (str.
                  length(
                    ) ==
                  1) {
                item.
                  setMnemonic(
                    str.
                      charAt(
                        0));
            }
            else {
                throw new org.apache.batik.util.resources.ResourceFormatException(
                  "Malformed mnemonic",
                  bundle.
                    getClass(
                      ).
                    getName(
                      ),
                  name +
                  MNEMONIC_SUFFIX);
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            if (!(item instanceof javax.swing.JMenu)) {
                java.lang.String str =
                  getSpecializedString(
                    name +
                    ACCELERATOR_SUFFIX,
                    specialization);
                javax.swing.KeyStroke ks =
                  javax.swing.KeyStroke.
                  getKeyStroke(
                    str);
                if (ks !=
                      null) {
                    item.
                      setAccelerator(
                        ks);
                }
                else {
                    throw new org.apache.batik.util.resources.ResourceFormatException(
                      "Malformed accelerator",
                      bundle.
                        getClass(
                          ).
                        getName(
                          ),
                      name +
                      ACCELERATOR_SUFFIX);
                }
            }
        }
        catch (java.util.MissingResourceException e) {
            
        }
        try {
            item.
              setEnabled(
                getSpecializedBoolean(
                  name +
                  ENABLED_SUFFIX,
                  specialization));
        }
        catch (java.util.MissingResourceException e) {
            
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "S985lYLqJNl0VIAjFR14msDxPHH/pFO09QCeODSMrz5ttI51e9pkHS0o4Dwr" +
       "nZ3fdspKvSpj+a3g6O0mcO+0ldoD8/5GusWMs8tmXvGxPL2cJX81H5kb4sLF" +
       "ILSWwG8ARiLKvdgYoLE81dkZi5+Avz1w/N/syPrIMrbL/j3Nne/x6KHzEYAl" +
       "8NaRPGg9mfV8MKfuyjUtI2Z/6y1uLWiWVrOE2PZVv6pmvf1Kufs7uftnyk2O" +
       "WnR2yV1F7uy0myVklvRycvsH0A8qM6dg8ueE+TZwUDuY1Fkwb+JwgmSza+V8" +
       "OG/LcR7WPg30nS8AKL0DSp8JtNltNfvZtfZCgB7WPg1UPyfQOjiYHVDmLKB7" +
       "b87O5+ccdb41wDl8xHJnYbRfAJmDHcbBmWTuH0zq8Hw4b8/J5MftNimdhTR6" +
       "AUiHO6TDqyAF1jq7Ts+LtCWNroH0vedEioOD2yHlzkJ6677rGa7vWXqW94Hz" +
       "ob1EMy2aZcjmNRD/3DkRE+Dgd4j5sxDfsZ+txo6RO21Z9ofPB/oevNlsUa1c" +
       "ba+B+yPnxP0OcIx2uEdn4b4IcB/4rb9wPsivwJsjkmWugfYXX4BejHdox2fr" +
       "RWRknqMxyfL+zjn1ggcEN0ct4hqIf/mciLNiwg6xcBbiW/YNL/OMc8B/73yA" +
       "72wxeIO6Jt7PvgAbIe7wimfbCEvfasMXzmkjyOY1deFXrx9ptiVReAQc79oh" +
       "fdcVSAv5yW+eDXEvh3gA7OJWwfNCpVOgvnxOUJfBoe5AqVcB9dvXA+p2LYlj" +
       "3+uEfhIcuFW507/ej1bAo9pvHN0/hfkfPy/mvI/taJb2a/vF7PqfXWM0f+rK" +
       "0Xxg7uiXD/xBwQgjwODluVM7a2T71w0IPDjceeQ7Ur43feIj/+3jf/Cx134b" +
       "ePe9wk3LzPMGTv0xB5NJsq3Xv/HFTzx8+9Pf+Uj+FAy4FP7mb5T/Imv16+cT" +
       "66FMLD5/6qPUKKbzB1djkkl27YeaQWi54Pl+udtXhJ+659v2p7/7a9s9w9NP" +
       "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" +
       "qxOYzNyqQN3NYrgeUbqHLh276lXqM91a");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "n/njPIj4/wGJcVrYF0MAAA==");
}
