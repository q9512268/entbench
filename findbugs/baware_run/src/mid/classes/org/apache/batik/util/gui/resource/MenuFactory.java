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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbDsWHle3zfLm415b2aYYZgww8zwIIaGq97UrWbYutVS" +
       "b5JaLak3AR60dqu1tnYJJjG4HCioAmIPmMQwqQpQiTE2xIRynJRT44QEEzuO" +
       "SZGNSgyVpCo4mCpICjtlkpAjdd/13ffm3Vlyq3RaOjrL93/nP//5dfTrfvEH" +
       "hVs8t1B0bCNZGra/r8T+/tqA9/3EUbz9AQHTguspMmoInseBvCelx7986c9+" +
       "8vHV5QuFW/nCfYJl2b7ga7blMYpnG6EiE4VLR7mYoZieX7hMrIVQgAJfMyBC" +
       "8/wniMKdx6r6hSvEAQQIQIAABCiHALWOSoFKL1OswESzGoLle5vCXynsEYVb" +
       "HSmD5xceO9mII7iCuWuGziUALdyWXU+BUHnl2C08eij7VuarBP5EEXr6l3/2" +
       "8m/eVLjEFy5pFpvBkQAIH3TCF+4yFVNUXK8ly4rMF+6xFEVmFVcTDC3NcfOF" +
       "ez1taQl+4CqHJGWZgaO4eZ9HzN0lZbK5geTb7qF4qqYY8sHVLaohLIGsDxzJ" +
       "upUQz/KBgHdoAJirCpJyUOVmXbNkv/Dq0zUOZbwyBAVA1Yum4q/sw65utgSQ" +
       "Ubh3O3aGYC0h1nc1awmK3mIHoBe/8NA1G824dgRJF5bKk37hwdPl6O0tUOr2" +
       "nIisil+4/3SxvCUwSg+dGqVj4/MD6i0ffa/Vsy7kmGVFMjL8t4FKj5yqxCiq" +
       "4iqWpGwr3vUG4pPCA7/zoQuFAih8/6nC2zK/9b4fveONjzz7e9syf+mMMiNx" +
       "rUj+k9LnxLu/+Sr09c2bMhi3ObanZYN/QvJc/endnSdiB8y8Bw5bzG7uH9x8" +
       "lvnni5/7gvL9C4U7+oVbJdsITKBH90i26WiG4nYVS3EFX5H7hdsVS0bz+/3C" +
       "RXBOaJayzR2pqqf4/cLNRp51q51fA4pU0ERG0UVwrlmqfXDuCP4qP4+dQqFw" +
       "ERyFu8DRLWz/8l+/YEMr21QgQRIszbIh2rUz+bMBtWQB8hUPnMvgrmNDItB/" +
       "/U3l/Qbk2YELFBKy3SUkAK1YKdubW0qWgQaBuZGXgUgwxXEhmwDJfqZ4zv//" +
       "LuOMhcvR3h4YoFedNg8GmFk925AV90np6aCN/eg3nvz9C4fTZcefX9gH/e5v" +
       "+93P+90OMOh3/6Df/WP9Fvb28u5envW/LQpGUgc2AVjLu17Pvnvwng89fhNQ" +
       "Qie6GQxDVhS6ttFGj6xIP7eVElDlwrOfit4//aulC4ULJ61vhhlk3ZFVpzOb" +
       "eWgbr5yedWe1e+mD3/uzL33yKfto/p0w5zuzcHXNbFo/fppd15YUGRjKo+bf" +
       "8Kjw1Sd/56krFwo3A1sB7KMvAH0GpueR032cmN5PHJjKTJZbgMCq7ZqCkd06" +
       "sG93+CvXjo5y8mG/Oz+/B3B8Z6bvD4BD202A/De7e5+TpS/fqkk2aKekyE3x" +
       "W1nnM//+D/+kmtN9YLUvHVsHWcV/4pilyBq7lNuEe450gHMVBZT7T5+if+kT" +
       "P/jgO3MFACVec1aHV7IUBRYCDCGg+Rd+b/MfvvPHn/vWhSOl8cFSGYiGJsWH" +
       "Qmb5hTuuIyTo7XVHeIClMcDUy7TmysQybVlTNUE0lExL//el15a/+qcfvbzV" +
       "AwPkHKjRG5+7gaP8V7YLP/f7P/vnj+TN7EnZSnfE2VGxrfm876jllusKSYYj" +
       "fv+/fvhvfF34DDDEwPh5Wqrk9uxCzsGFXPL7gVk+qsns5mM7sGRDOSjwxhuY" +
       "wK0cCik4uSpAedU35Ol+RmPeYyG/B2fJq73jU+rkrD3m5zwpffxbP3zZ9If/" +
       "+Ec5BycdpeMaBDp+Yqu0WfJoDJp/xWn70RO8FShXe5Z612Xj2Z+AFnnQogQs" +
       "ozdygRGLT+jbrvQtF7/9u//0gfd886bCBbxwh2EL8tZMgYUFzBnFWwH7Fztv" +
       "f8dWZaLbQHI5F7VwlfBbVXswv7oXAHz9ta0Wnvk5RxP/wb8YGeIH/vP/uoqE" +
       "3F6dsbyfqs9DX/z0Q+jbvp/XPzIcWe1H4qsNO/AJj+pWvmD++MLjt/6zC4WL" +
       "fOGytHM4p4IRZNORB06Wd+CFAqf0xP2TDtPWO3ji0DC+6rTROtbtaZN1tKCA" +
       "86x0dn7HKSv1yozlt4BjsJvAg9NWag/M+5tJjJpkl2he8bE8vZIlfzkfmZv8" +
       "wkXH1ULgUwAj4eUerg/QaJZg7IzFT8HfHjj+b3ZkfWQZW5fgXnTnlzx66Jg4" +
       "YAm8nVvQ2JNZzwdz6nKuaRkx+1tPcmtBs7SeJZ1tX81ratbbrpZ7uJN7eKbc" +
       "fQ4js0vmGnJnp70s6WfJICd3eAD9oDJ1CiZ7TphvBQexg0mcBfMWptXpj7Jr" +
       "/nw478hxHtY+DfSdzwMouQNKngkU7WHoMLsWnw/Qw9qngUrnBNoEB7UDSp0F" +
       "dO9N2fn6nKPOYnSLaXEj5iyM+vMgk95hpM8kc/9gUrvnw3lnTiY7wfH+/Cyk" +
       "3vNAOt4hHV8DKbDW2XV6XqTYnLsO0veeE2kLHMwOKXMW0tv3TUsxbUuTsrwP" +
       "nA/tJZLCyBHVR6+D+OfPibgDDnaHmD0L8V372WpsKLnTlmV/+Hyg722hKEZg" +
       "udpeB/dHzon77eDgdri5s3BfBLgP/NZfPB/kl7VQrj+iroP2l56HXkx2aCdn" +
       "64WnZJ6jImd5f/OcesECglEO61wH8a+cE3FWbLpDPD0L8W37ipV5xjngv30+" +
       "wHdjVKtNXBfvZ5+HjZjt8M7OthGatNWGL5zTRvTR6+rCr9040my7ovAION61" +
       "Q/quq5AW8pPfPBviXg7xANjFrYLnhSqnQH3lnKCugEPYgRKuAeq3bwTUnWLg" +
       "+7bVde3AOXCrcqc/3vci4FHtt4/un8L8D58Tc97HdjQr+439Unb9T64zmj9z" +
       "9Wi+Ym1IVw78wanieoDBK2ujcdbIDm8YEHhwuPvIdyRsa/nER/7rx//gY6/5" +
       "DvDuB4VbwszzBk79MQeTCrJt2b/2xU88fOfT3/1I/hQMuKQ/iV1+R9bqN84n" +
       "1kOZWGz+1EcInk/mD66KnEl2/Yca2tVM8Hwf7vYcoafu/Y7+6e/9+nY/8fQT" +
       "zKnCyoee/vBP9z/69IVju7ivuWoj9Xid7U5uDvplO4bdwmPX6yWvgf+3Lz31" +
       "j/7uUx/corr35J4kZgXmr//b//MH+5/67jfO2Oi62bCv8uNvfGD9l//HXs3r" +
       "tw7+iLIowK1JmZkVScQrKkoUJP1+HyX9jWZL6XhRxvCa2YiiFuE1wnW4GYIR" +
       "qfqBGIolipZlqthusePiUNvEE9N2hrrZ2mirgTFsLdZzw2W7A8TAMWJRmuPF" +
       "/rpIYjy1YppDLCTrcFWsyliTbhZTcqwb02qx6ihIrdmEwiBQpOJIHTMbjimV" +
       "NtGA1Td9r1sSKHYwUDFkGOg4R071aN1p1EYapyCB1HDTarxqum5UZzY6FolY" +
       "LR5NuI7dta3hcDYapwNysozMIdsvBawxsnWZdcbqxG851ITnO6TRT0Y+yhO2" +
       "N66XGQZfjvE2B7e7Sw6Xu14tqpjYNCI1Hp3WxeGwSflkyS0N7OWkxEwrxYWd" +
       "kganEVYy6Yh+pUMuhMnKw4lFvzROOLi7Qklj5U41maCmc4XSNi6BDVOCGDCQ" +
       "PcBj2sXwyLGFXr0GORQtxk231uFIrM3gPJNopQlJTWUYnUQG26gmVJIyvojy" +
       "6oCZDEhfN1JsRUTrhdAWKIbsumtZYJdNY+ToutWbtuq9CjudCuxgpg26eHEx" +
       "tZdaXXdnQzYk4fF4WUm9HmWMCW+5avKBuISwAOa7crOZTiVyjQtMUacYgtWa" +
       "M6bGDMlOK0H7HNvsdKZrkZ9om0WXFUi0I8OEPDHHjlKeCSWk6uA4vmgbUYv3" +
       "ZtBgzWxI2B8ZcZuN+hWaJZOpBLW7RXzEq5VND+CaSB0B7rbKmNBoNyI04uzh" +
       "sM6SaHFQN0jT5JwhW+sVpy7cQStiq9WeDMujSSqYsB5TkyVXGw8FkdD6RGJq" +
       "JRyO6e54zrCrqTQZKUXcaNnSpjSoafzKaNVi0vdcI2XT8XAzw2rYZk2mJS3s" +
       "svZgbiq4OyhzNVUWKoi8UBJuaXIYNYaZyYSvpwhvjPiG0XNtlJo4zRbFSdKG" +
       "jakyWiqOGpHNthAsoT3USvVKMJo3Bh7k4BY30FO1y9ZXqczq48qgXROsHl8S" +
       "Z0Bl21NhzRgkhTIe1EmtkJ/orpPO3LHAOIkz65sM1kBKa3oCy6oMt4sYypd7" +
       "AjOcjqZkN0zsyZTjTI3hVLY83aC1yAzspT9lBvF8VWzXzW6zxuoTmnKbiNYf" +
       "T/WeyXIpV55soKg0WU9aDItjcoiFQ627gYSoL9aKTX7NtNnOuMi3vKawCBtr" +
       "NTYYu0JtTH2BT6YtnVmUTJmZx4sanZgYSSlYs+1u+O4K6UEUXElpoq8JmyXf" +
       "Y6JkE2zWk3EXWdiJYLILw451B7UqnaQ0btiLIMTEVkfsB8taxVRDSfe8dXst" +
       "JEusw3Hzbgzrddxypx0Db7J4LNcXTTVMVrYik2WEDhZhr8e2OI/RkwY2a8zF" +
       "Lhp1Gz2fMeIKy66xlK90m3qZEUiDwtrkcog1+SodTJtTNRQ2tdagyVY4e2CO" +
       "qW6KRoJjtkmk0V9CYIDqFYvWYkV1OzY/6I4IgmzFbKqvGX0ts2ZrJLu2XWoL" +
       "2EYgk6hWWZSUARe5Ywn2TNVtjum56jTmUVxFPKk91PAAODbs2OJophZUS2ow" +
       "n1WhZM5FDTWcUuXAghSh26eXy5nQxWdCuKi6bQ7RCUNf0h2xVCTrM3KgY/bY" +
       "Rcl4tByVerpZLJZ1RpZnQbm/nq42LRrtbzYS3hVpD8HdXmwx5Q00wpVyaa2m" +
       "CGVay0R2JVNBWReCupBJBfqCc4kmTpS6Y2RIrwZSdRj6CjTDmwi0lqmgw7hl" +
       "1x8VDZeaTDcEGtW5SKc4O6gMZQ61BmEDy16/yj2qDLWhMaLjoc6LJFZqL7Gh" +
       "uWrbYdjlU6HYbCpC20BGozTtLzYc3SFH1gDWO5pcHszbKFcPpqSK9sZJs5eW" +
       "TIcvtsWY7TpdbMEb2gAyqtDUInpQGJWXItepcLWFGzJeiBESUVerej1QivUN" +
       "BjSPZDGmXd70yJJKrqlaag0IUcari1U4789DiA27SJFQko40bmtugvtOmkir" +
       "td5bLGCEsqPh2hRofNwQyJIzdFyx5a0IjYmDkN0oS2kq1ay631XmtlLylj7m" +
       "wFWMXfgr1ydgYC3KKeOyRNqExSbdU9cNDJHgNmSlFCH1lgo+K1X0eMR6RCxB" +
       "yWrTLC/XWFcKJLUubpIx10iG/LiGorMhNtAocVXWhI5IV5PUSQJnHUKwX2pO" +
       "e8PSqtYRTG7K4gaj64tyvUNPuiQZmc1Zsdk3HA8YtkVXX05Io62gsSE1SiLU" +
       "rM3MERKLIiRTAj21YAiCQ2k6qap0f+SWY69Gq0x3xjV6ckRgq3oTKjbLqiVq" +
       "YcWJVkSrPtJAZkWFNoYth8pIUtvAhiijZapAPbtTWtANvsTNoEm7XJVQrGKD" +
       "GSqMZjFa78nltFNfQJ21PIdYmNws5cGysqacSMJGC1pWmY6p9xfNBAyAXIaL" +
       "gK6xRScleEmE825zLA+s8kpnrLDPVA1SrG74mq10NpWa7tTKhtdeuKUqai+W" +
       "rp5u1j21XEMQak7jnqU1unzbCJOW092sp/LSn8zLBDSstala250xONartIc0" +
       "z8yieOL7VYXrF1eU6Km+27LG4UAbaNwiJTeL5mbISn1PLc+WPrIgvFk9anSh" +
       "KJZdBi9CmAVLvQU5nw9QYb7wifUyKdpqO1BFoacuK7OIQ6N5BI8iEZ0jHs5V" +
       "/GE1qJOiGsVkF6uwLZ2zRwNTRbWSILUGzigpaxYBu4vAWnktqKFQXaw0HvMe" +
       "1dG5+ZpJzNkyWA1VgvRFY5XwpY5bT1GWHAxXieR2FEUc+U69GAbIeMSaEzQd" +
       "oGWRlZumJq/bvKJgEWhs0R0nIiwq0HrqjrRGuoToKSqhcJkYVIRxS+ribtQs" +
       "lbjVitJbox5GFD23FagmGXRLkUytZ0oYL8ukyLJeyWU3rEY1AzNFdeA0Rrxi" +
       "ecC/rcjVOaZ5aD2cxItNsef4bFopel0B8/DBWk/heXsJNWA98rRWg2wPq/GM" +
       "iMGKVXVYYhkauhmgULtUkfiGSnamUXXZ6Mw7ciKQQ2SJ9cu0uLBKcnVaxvtU" +
       "qdHiVM8vpuViI1iN57jJ4nStoaDYeDzhs3srQRg2pekcr/XKy3SwAo8SLX7e" +
       "a3XKwBdFN7Uw6No9pxRttJa4xhJCbszKg9oGLfoY1g/QObGg1OaSmnZ5HCtB" +
       "RnE0w0Hbi2XLEjHNdZVafd6J5FJKrorKMCm701hs9dXUkKFabbxKeg4kcBo8" +
       "7s1l2jOnsbESVJODpzwS87U2GbAY3klhpCIsoAG54Codv98zauN4vXEHs2k6" +
       "Emh+bmqI7MXUcugVV/0ApsOliqMYs+Kd1CEkf76C6ps+n6jclKnOdRtaDi1e" +
       "KXUXaTVZQhJJB5BgBY2kVsWrKYekclQr2SaktFQIohvJoF61oDmPC7GxsYQR" +
       "R8jjikiTc1yL0lGqgzk+Ms0qzibSZu42102HQ1Uu8oR5o0X4FbZGz+wy0uEo" +
       "KC5zfnHjCSFRGbYapdJo4iPL3miJNAOI95BFLaJLtcioLfE47sDspgqjCFm3" +
       "xCHphpxBjIuiVKoSZkPirVV5Vio2ouLGWtPteph0S822YNR9g0I5R/Xg+qwI" +
       "x12b7I7ohlSl0g3ccSrjRY2iK4yOIMNy34+TpO+GHbXe6FWVRSrhPiZUMUZv" +
       "qxvfUaKyWZ23oHENoUltGgldZI3oDYws45bUFxSuHAAexPmSM6yiGJg9kw+x" +
       "UXFUhqVEDsbRGImh0KIiU0DS2YaoIE4Ya+0pl/h8sYrCSbdegQW1KC50CKq5" +
       "gxW8RtaLsNiGKRp116iLSDKn1yUKlVJy5sU0LfPRqOZGutVOWt0V41PT2JRK" +
       "1hLXBQdL2ARzp6OAkcxSaaXxa2wpzLvCzJvWSY2OBGM4k12nA/UmwlpzOqaw" +
       "nBpEbW5NopCyJREZTBmexQRGwFaTVCu3YhQmu4wpNiaLXhOsomZ1hqliRJR4" +
       "e0GVNcqDJ/RIpzUKXgUhVE7LyDgkvZnQdhucO6RZBIvVCZGuamFlOPSh5dyy" +
       "kH7Rq4/gIjyFIKZd6TSWTZyMB5y0sFioqFLlxrgaIxvwRDNsK9P5gqLNFN4A" +
       "H3NBBVzNsgWE66tWa+GHkKMwa0EtiS1kyE4U3mgJXbtaZs2NGMVLfGqCp5li" +
       "2xCimoV1x7N14I9Ka6iKKIlfIcTQmzt0bTXurX2UhrxSqNKuExaLeAfeRGh9" +
       "JuuCjPqaNHS71lqSpwLTT8OexsGK0uwyzSYiFzF3MVoHi5UFdKPi0W2flmZQ" +
       "iujotORbyhhuqWJPRxK03hTCoKiWm42SYCkLbmQvKcbAK06y6gkWQoqQkLSS" +
       "xpwM4F6xQ7bQBCquIARFeum8CtY5CO3Upyq3aPJ8cUFIC9E0ea6r6nKLTWXX" +
       "gqtdGxG4NXjCk1dwvWTR4QAJqLHedQaSoqF9q2dr8NLjK4ypruLNtDzjUdtm" +
       "cFRhR+tlRW/wi84cmCeJMwf1oOo2BKS/Hs/1+tyGsdmI7gCnvieP1ErIVV0E" +
       "EYgN0qymnX4prjbEhqHCuCjDYVE04NVsykQawvqLMrwm1dJ62gjwWIijNTcP" +
       "e3ID1iC/WjXTRjHFF8y4LMK9NdLVfbkWDiWpBAkSpA2bcVxbGxal1mMkBc+x" +
       "hAQeW7U5rWID2RwmuCeXygiCK47mTgI7wmsC5oj1+sJCSvCsqrJWZ6qVjdhe" +
       "bwwTVUR1QcIIbwftTUCRRX3UcWSqPGDFpkcx5dJslpbxZWRXF/3uelVuo5XS" +
       "BK15Vr21LPNDSdjEJWPNa/1ASFeDYiAtVwOL38ByK1jOZrPVzJgU+5PuplbV" +
       "ySFcIQhes9cU2whGq2XZmQ6QwYZvT+tcUpxigqCMhl2vQU/ZiE+R4gTUG8yt" +
       "UUeYpU1uCgZPSFZ8UybnrtSCVzE7NVszRmrba4yoTNew02KddSA1fVgcxcXK" +
       "Qh1UmBGzUOnJYDjxyj41RNaEtEodtN3mfMR3avWikEQjVwPPS1pnqlvxRizq" +
       "UsNTdWvTl2xvLHfWzQbnbFSFX5VpuyMKtZ40S2vQWHDXgaw2nSmVYgO60R0Y" +
       "xoQhRbs4NOU1sO4CcMIYskUnxqjaxzmmmXbwcNNLEilgiYkeQ05cV9ImPiDV" +
       "tjvqVRaSJK1qsDAnakroa2Na0FYqitfA");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "Z/44DwL+fwvovhDzQgAA");
}
