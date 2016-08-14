package org.apache.xml.dtm;
public abstract class DTMManager {
    private static final java.lang.String defaultPropName = "org.apache.xml.dtm.DTMManager";
    private static java.lang.String defaultClassName = "org.apache.xml.dtm.ref.DTMManagerDefault";
    protected org.apache.xml.utils.XMLStringFactory m_xsf = null;
    protected DTMManager() { super(); }
    public org.apache.xml.utils.XMLStringFactory getXMLStringFactory() { return m_xsf;
    }
    public void setXMLStringFactory(org.apache.xml.utils.XMLStringFactory xsf) {
        m_xsf =
          xsf;
    }
    public static org.apache.xml.dtm.DTMManager newInstance(org.apache.xml.utils.XMLStringFactory xsf)
          throws org.apache.xml.dtm.DTMConfigurationException {
        org.apache.xml.dtm.DTMManager factoryImpl =
          null;
        try {
            factoryImpl =
              (org.apache.xml.dtm.DTMManager)
                org.apache.xml.dtm.ObjectFactory.
                createObject(
                  defaultPropName,
                  defaultClassName);
        }
        catch (org.apache.xml.dtm.ObjectFactory.ConfigurationError e) {
            throw new org.apache.xml.dtm.DTMConfigurationException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_NO_DEFAULT_IMPL,
                  null),
              e.
                getException(
                  ));
        }
        if (factoryImpl ==
              null) {
            throw new org.apache.xml.dtm.DTMConfigurationException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_NO_DEFAULT_IMPL,
                  null));
        }
        factoryImpl.
          setXMLStringFactory(
            xsf);
        return factoryImpl;
    }
    public abstract org.apache.xml.dtm.DTM getDTM(javax.xml.transform.Source source,
                                                  boolean unique,
                                                  org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                                                  boolean incremental,
                                                  boolean doIndexing);
    public abstract org.apache.xml.dtm.DTM getDTM(int nodeHandle);
    public abstract int getDTMHandleFromNode(org.w3c.dom.Node node);
    public abstract org.apache.xml.dtm.DTM createDocumentFragment();
    public abstract boolean release(org.apache.xml.dtm.DTM dtm,
                                    boolean shouldHardDelete);
    public abstract org.apache.xml.dtm.DTMIterator createDTMIterator(java.lang.Object xpathCompiler,
                                                                     int pos);
    public abstract org.apache.xml.dtm.DTMIterator createDTMIterator(java.lang.String xpathString,
                                                                     org.apache.xml.utils.PrefixResolver presolver);
    public abstract org.apache.xml.dtm.DTMIterator createDTMIterator(int whatToShow,
                                                                     org.apache.xml.dtm.DTMFilter filter,
                                                                     boolean entityReferenceExpansion);
    public abstract org.apache.xml.dtm.DTMIterator createDTMIterator(int node);
    public boolean m_incremental = false;
    public boolean m_source_location = false;
    public boolean getIncremental() { return m_incremental;
    }
    public void setIncremental(boolean incremental) {
        m_incremental =
          incremental;
    }
    public boolean getSource_location() {
        return m_source_location;
    }
    public void setSource_location(boolean sourceLocation) {
        m_source_location =
          sourceLocation;
    }
    private static boolean debug;
    static { try { debug = java.lang.System.
                             getProperty(
                               "dtm.debug") !=
                             null; }
             catch (java.lang.SecurityException ex) {
                 
             } }
    public static final int IDENT_DTM_NODE_BITS =
      16;
    public static final int IDENT_NODE_DEFAULT =
      (1 <<
         IDENT_DTM_NODE_BITS) -
      1;
    public static final int IDENT_DTM_DEFAULT =
      ~IDENT_NODE_DEFAULT;
    public static final int IDENT_MAX_DTMS =
      (IDENT_DTM_DEFAULT >>>
         IDENT_DTM_NODE_BITS) +
      1;
    public abstract int getDTMIdentity(org.apache.xml.dtm.DTM dtm);
    public int getDTMIdentityMask() { return IDENT_DTM_DEFAULT;
    }
    public int getNodeIdentityMask() { return IDENT_NODE_DEFAULT;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVafZAUxRXv2eM++bg7Pg7k4/g6SEDcFRXRHAbh4ORw7zi5" +
       "A8yhLHOzvXcDszPDzOzdAhJEo6BWEVRQkgiaEitioRgrxpRRg5ooliglmgQ1" +
       "fkT/0IhWSSURDUnMez0zO7OzO3McbK5qevumu1/37/dev9fd0we+IMW6Riap" +
       "vBznw8Z6lerhVsy38ppO4w0Sr+vt8DYm3P7XuzeferN8S4iUdJAh3bzeLPA6" +
       "bRSpFNc7yDhR1g1eFqjeQmkcW7RqVKdaD2+IitxBRoh6U1KVREE0mpU4xQrL" +
       "eS1KqnnD0MTOlEGbLAEGGR9lo4mw0UTmeSvUR8kgQVHXOw1GZzVocJVh3aTT" +
       "n26QqugavoePpAxRikRF3ahPa+R8VZHWd0mKEaZpI7xGmmURsTg6K4eGSY9X" +
       "fnV6R3cVo2EYL8uKwSDqS6muSD00HiWVztuFEk3q68gPSVGUDHRVNkhd1O40" +
       "Ap1GoFMbr1MLRj+Yyqlkg8LgGLakElXAARlkYrYQldf4pCWmlY0ZJJQZFnbW" +
       "GNBOyKC11e2BuOv8yM57V1U9UUQqO0ilKLfhcAQYhAGddAChNNlJNX1ePE7j" +
       "HaRaBoW3UU3kJXGDpe2hutgl80YKTMCmBV+mVKqxPh2uQJOATUsJhqJl4CWY" +
       "UVn/FSckvguw1jhYTYSN+B4AVogwMC3Bg+1ZTQasFeU4s6PsFhmMdVdDBWha" +
       "mqRGt5LpaoDMwwsy1DQRiZe7Im1gfHIXVC1WwAQ1Zms+QpFrlRfW8l00ZpBR" +
       "3nqtZhHUKmdEYBODjPBWY5JAS6M9WnLp54uWOds3yovkEOFgzHEqSDj+gdCo" +
       "1tNoKU1QjcI8MBsOmh69h695dluIEKg8wlPZrPPUDSevnFF76LBZZ0yeOks6" +
       "11DBiAn7Ooe8MbZh2uVFOIwyVdFFVH4WcjbLWq2S+rQKnqYmIxELw3bhoaUv" +
       "/eDGR+iJEKloIiWCIqWSYEfVgpJURYlqV1GZarxB402knMrxBlbeREohHxVl" +
       "ar5dkkjo1GgiAyT2qkRh/wNFCRCBFFVAXpQTip1XeaOb5dMqIaQKHjICnguJ" +
       "+cd+DbIq0q0kaYQXeFmUlUirpiB+VCjzOVSHfBxKVSWS5sFoLlgTuyg2O3ZR" +
       "RNeEiKJ1RXiwim4aSSelSNxIRha0NzfzMpiCFkY7U//vPaQR47BejgP6x3on" +
       "vwTzZpEixakWE3am5i88+VjsVdOwcDJY7BhkHHQTNrsJQzdh6CbsdEM4jkkf" +
       "jt2ZigW1rIUJDh520LS26xev3japCCxK7R0AnGLVqTkRp8HxBLb7jgkH3lh6" +
       "6uhrFY+ESAicRSdEHMft12W5fTNqaYpA4+B3/AKA7QQj/i4/7zjIod29W5Zv" +
       "vpCNw+3JUWAxOCFs3or+N9NFnXcG55NbufXTrw7es0lx5nJWaLAjWk5LdBGT" +
       "vLr0go8J0yfwT8ae3VQXIgPA74CvNXiYG+DGar19ZLmKetvtIpYyAJxQtCQv" +
       "YZHtKyuMbk3pdd4wI6tm+eGg4kE4d2rgWWBNJvaLpTUqpiNNo0Sb8aBgbv2K" +
       "NnXP8df/djGj244Ala7Q3UaNepfXQWFDmX+pdkywXaMU6r23u/XuXV9sXcns" +
       "D2pMztdhHaYN4G1AhUDzLYfXvf3B+/veCjk2a5ByVVMMmJg0ns7gDCGsgQE4" +
       "0dSdIYHjkkACGk7dMhkMU0yIfKdEcZ78u3LKzCc/315lmoIEb2xLmtG3AOf9" +
       "efPJja+uOlXLxHACBk6HNqea6Y2HOZLnaRq/HseR3nJs3E9e5veAXwdfqosb" +
       "KHOPhNFAmN4uYfgjLL3YU3YpJnW62/6zp5hrgRMTdrz15eDlXz53ko02e4Xk" +
       "Vnczr9abFobJlDSIH+n1NYt4vRvqXXKo5boq6dBpkNgBEgVYFuhLNPBv6Szj" +
       "sGoXl77z/Is1q98oIqFGUiEpfLyRZ/OMlIOBU70bXGNanXulqdzeMjtOpEkO" +
       "eORzfH5NLUyqBuN2w29G/mrOL/a+z+zKtKIxrHmFjgszr0tkq2tnNn/+7s8+" +
       "/t2pB0vN2DzN34V52o361xKp86aPvs4hmTmvPOsGT/uOyIH7Rjd8/wRr73gR" +
       "bD05nRtTwM86bS96JPnP0KSSP4RIaQepEqyV7HJeSuHc7IDVm24vb2G1m1We" +
       "vRIzlx31GS851uvBXN16/ZcTyyCPtTE/2OOyRqIW6+CZZU3lS7wui+P6CoRY" +
       "7yomcSpLp2Eyg2m4yCClqibChgiAlehsTW3AMEWZlzz+pMbuPM8gYF7EaYJP" +
       "SQa4e7UFcLG2o2Bnw2wPuQqbq1bTw2I6G5NFZi/f8zXmeZlRVOPbCDyXW6O4" +
       "LIcKwjLL8mMNYTaKSbMHWpUtLI9QgGBBY4vdFktn13hwLD9zHCwKTYdnrtXl" +
       "XB8c15s4MJme69v9WoP6krG0nrA1MMVjG+gH9PC1zVFTH6ZnWe+Bs+rM4ZTj" +
       "2+9ALJpoVjV/88BJ5FcLmG+JmuqEXbhHK2UBMg0yOBkTZUGjSQoTX2Ke3eWo" +
       "cDvflurUwR7FJATjHmuzcbDm1Lrfl25YYG8k8jUxa16tNx99etEnMRbsy3CN" +
       "125PUdfqbZ7W5VppVJkAvoU/Dp7/4oMDxxf4C76jwdo7TMhsHlQVA0eA3/RA" +
       "iGwa+sHa+z591ITgdZKeynTbztu/DW/faYZvcwc6OWcT6G5j7kJNOJiw0U0M" +
       "6oW1aPzk4KbfPrxpqzmqodn7qYVyKvnon/5zJLz7w1fyLONLOxVForycCV5c" +
       "ZkFe49WQCatk5p5vNt96fAmsIJtIWUoW16VoUzzbpZbqqU6Xypz9reNmLYCo" +
       "HoNw00ETnmnQ1c9pcD6MepplstN8psGNzqwWcw3er7VBqpMxXUlpEL4kReDt" +
       "9aXiGfGWfvrT8dAXb/XJ+4x461n4U1+h4J7itDPVlW/w28588BiN0Fa4jVY/" +
       "G3MGz2UW3iz8NMkGhWA49KMH9p3asvWyEC4ki3swpIPBusJUSwoPkm49sGvc" +
       "wJ0f3sHWRDgKFPpjnyCK2TWMCExaPGyMCBilQYY1LVjY0h6DaB1rWbJgYWx+" +
       "U3sba5+0Zh/+aK58j0GKROvYzTVZ8N8bvPa7o5+ELgZBN1tDvTkPoZi5E/0Z" +
       "Zu4/azb8ugD/aLLBmFiwsHHesmg7luz24Hqgn7jmQ2e3WZ3e5ocLfTRmHj5r" +
       "XH5dwOR1tBwAa38/Ya2EvrZbfW73VRdnvv/lWcPy68IgQ0xYzfOuRWht+TA9" +
       "EYApHeBY1hikjIdorMH6xBkT+6sknuMw15hcuxeCkWuc34kli1r7btq5N77k" +
       "oZkha5vYC/tpQ1EvkGgPlVyihrEY6N0INbNzWmdXMfvYqaJ37xo1KPdYCCXV" +
       "+hz6TPeP/N4OXr7ps9Ht3+9e3Y/znvEe/F6R+5sPvHLVVOGuEDtqNjcxOUfU" +
       "2Y3qs+NshUaNlCZnR9ZJGY2NRk1cAE/U0ljUa6iOwfgERd+mARv+IwFlr2Py" +
       "MrjeLmrkWwd3OtZ7uK8ZmbXXxhdz2esXs9cFs+FZYYFY0X/8fk09GF2RoJNJ" +
       "PR5AwjuYvAkk6Lkk5Is5A3oUMe4Q89Y5EzMGi6bCY0UDkhNwXMTkdxHMa3kc" +
       "VmWAxL74+jR/BXsnNSP/LrtBkRNiV0ozv62lBapihgn8DJOPDDJQpr329LGl" +
       "Be/ZHaY/PmemWawYC89TFi9PnRXTz3iYrg6Q6CGymIkqtqGPZh8AGGrw77KO" +
       "B7nhNra4xRqKXa82P0Ur2hpFyTDPNdgSUmEAvgmwdrZg+TvsNGHKgwS7g5r8" +
       "HTjk/6Nw5L9gUfVCwcj3k+hv5ruxM26QP1HcEExKMkThf1yGDq60MHTg4ccR" +
       "a/BHCkaHn8TgSV2FJtB7sRCOK8lwC8RnRsN5ARSNw2SYQYabFC2CpYBEGzUl" +
       "ia0Zyw5hwwtD2Ax4jlnwjhWMMD+JAdi/G1A2HZNJMKkEjfIGXaAIKTycadT4" +
       "Lvz1mNLkc2aGrSzwYOg9C8d7BWPGT6IHfSgjiuMyfoibFcARgx4xSKlGJQoL" +
       "RMfdsZILz5mUWizCQ9ITFoQTBSPFT2J+UjLzy9lZm4fljh+aH0BUIyZzYONk" +
       "GVN7c5NB2VewPoJDVjVG6hWFI/W0RcHpgpHqJ9HX0sg1NgGT8x7stmo0Iaat" +
       "uywa47ItgOcVmDTn4xkLFjksthSMRc7ayJm/hWDRV6IHeJGz491tszg2vxm5" +
       "VhiMp84ADhOYXHcGHF5fOA5rLcS1BePQT2Jfq4l1AczgS27tGTAjnTMzmdNM" +
       "62SA854M9L3P8m0agHBTQNlmTNIGGQILhSbnW8W6bJ+/vjBbzJkw7ius8V/R" +
       "f+h+Tf21b86L2wLw34HJjwC/noP/Lw7+Wwqj+skED3RNEE39x+/XNADeroCy" +
       "ezHZYZChoPq2PKf2Dvw7C6P+y2Ds1jEB1/8TBt+mfan/5wEcPIjJfcCBnpcD" +
       "lwnsKcwquQ6GttsCsjuAg/75RT+JvtRwHIP/WAA1j2PysOkZ0CnGYWKIBjt8" +
       "cm0e+jwO7pOWwViETvF+C8T9/TcNv6YB8J4OKHsGkyfNmeGC3szraz3wf10Y" +
       "+BNg7PstDPv7D9+vaQDElwLKDmPyvHn2iPvFAPwv9B8/BJsK5wwJ7/6MyrlX" +
       "bd4FFh7bW1k2cu+yP7NLeJn7uoOipCyRkiT31RRXvkRlq0tW07yowj6ZckdB" +
       "n7nrKIMUQcrWAK+b9Y6ByWfXgzqQuuv8ETA4dQxSYmbcVY5DK6iC2bdV341G" +
       "2txtZj4G2MSSEX0R6/p+MDnrdJ7dZbdP0lPmbfaYcHDv4paNJy99yLwXKEj8" +
       "hg0oZWCUlJpXFJlQPI2f6CvNllWyaNrpIY+XT7G/SFSbA3bsdIxjTHj1g1NR" +
       "y6M9N+b0uszFubf3zXnutW0lx0KEW0k4HixvZe79pbSa0sj4ldF8X9uX8xq7" +
       "zFdf8fHqo1+/ww21P4ni99XaoBYx4e7n3m1NqOpPQ6S8iRSLcpym2eWqBevl" +
       "pVTo0bI+3pd0Kik5c+19CJokj4fSjBmL0MGZt3iv1CCTcu8y5N61rZCUXqrN" +
       "R+koZrDn+0VKVd2ljNmNmKhpZBpsLRZtVlX7EkcpY15VccZxn+M/N/wP7OCr" +
       "9bAyAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "P9L7uK7MdK7sct4MZA5at7XGQpXtbxuN");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("LZ1OB+1F3TLLgSKRE7cfTjt9d8T10HkNLI1cV9qqbBT2ZGgq4BQ87oxnzQpY" +
       "C/Y2C6G7QIB181uwrmehWXkVZ53VbF7Jpv4KoHI35UFbKjtY196sFQNvhLOx" +
       "Wo4XmKt36tPGalrfLPGso8/r8+4yQCA4TVGEw3y70ZiqASFvQKLpVzyEXQ5D" +
       "blQb121+TGvh1kMNaUkYazcUhaA860FgVVYe2E5Vg5AG2Q+cBTYfLwiPLjOU" +
       "klTsNUKSgraqb6tsDYkUcjJdRiwPgeksavlQWRyIOuouWI/1BlaoEGFM80oi" +
       "ulO87WihjFRFTVM2PsTALJxy+JCMGrPmttlsvi1//ferN/gyunilenR47q/w" +
       "MnVzzt7KLCndpc7iJFK15PhcR/HvUunUaawT76tPbPaX8m2yV1/vwFyxRfaZ" +
       "DzzznD78BeTCwSEJOyndnQThW1xjbbgnunoI9PSm628HMsV5wePN+6984H88" +
       "IrzdevcNnEp6zSk+T3f5Oebzv0e9QfupC6XbjrbyrznJeHWjp67ewL8nMpJV" +
       "5AtXbeO/+kiyj+QSewu46APJ0qd3Ao4Ve+5m3TlnUL56Tt2/yYvfSUoPmUZy" +
       "1jaxcmxSX3mhl9kn+y4e/PbV25I4uKQDmNKtgbl3TKAUBH94DtY/youvA6zx" +
       "tVjPfKO/Dmz9GP+/uwn8r8ofvgFcB7tqpWt21c7Bf+E4Erw4IfzXswkODwm8" +
       "+exDIWTgz21zFe1OTm80I8xvig6/nRf/OSm9xDfSQzs/FXC+dRPSKbbDHgXX" +
       "lw6k86W/knT++ZnSuVhQXTwE/0hxCLPADYKcH+dn+fZ3uzw5hXlI99jZQpLG" +
       "HdtNdkdndpvOxaB/eo7Z/UVe/K+kdAdwMdDD4QAPnz3AsUS/dysk+lsHEv2t" +
       "WyjRE/b2oZxg747ro9+7Ky/2jtDnJD88wrh34WYx5udovnaA8Wu3HuOhsu7P" +
       "lZVWtH098PbZQC92F/cePAf3w3lxb1J62Q53V/V11+hEgZe3LkR3LIX7blYK" +
       "bwbX1w+k8PVbKIWTgB4/p+51efEqYNNaZKiJ0Qq0VX6epxOpZv57SumP3gTc" +
       "Yr7MDx194wDuN24h3AvHVD888u29N58DfD8v3piU7owM11DjEyGkQPojN4H0" +
       "sfxhfpLtOwdIv3PrkR6Z9/Fu+u7g4rFv189B/9a8qICU9EDtAtNLjOLE8AtE" +
       "0avICklht0JSPziQ1A/+emyif4jqiTNP2XGRMbc3B1/TRIWAuucIj84L8izh" +
       "5RVvPxZN6xaIZu9lu7a731skmtuO1ykfOhTNo2cr/MSkWYAXzxGMkhejFyEY" +
       "/lYI5rEDwTx2CwVzzQSpnwN3nhdXXgTcd98E3KNzdwcLuL3TC7ibX2bshefU" +
       "FVicpHQfmA17x8c9T4VL92ZXGAhg9m0HCN92axCe0OXOdN97Dsz35UUKYMbX" +
       "wPxPxzA3N6vIJ0r5acMdzN6tV+RHzqn7WF58MCk9CBQ5PuNo6DHKD92sMuuA" +
       "4YPl4t6tXy7ulPnMOVA/lRc/CaDGZ0I9odBP3Gz+dhkw9ewB1GdvAOoNBKIf" +
       "Fph+/hy8/zgvfmbno3kU0oHt2knxFuBErvrpm8B6b/4wj0I/d4D152698X7+" +
       "nLov5MUv7oz3BEJGjZ1TKD97sygfBwx/7gDl5249yi+fU/dP8+JXd6908sXG" +
       "OTB/7UZgbpLSPcffjuTfS73ymo+Xdx/cal947tJdr3hu8ofFh3ZHH8XeTZfu" +
       "mq9c9+TnLSfu7wiLBKqg3H3sEhZ4fhMo7NqsIindBsqcyb3nd3T/Epju1XSA" +
       "BpQnab4CMBzTgFXp7uYkyb8GrQBJfvvVXF97jc1uGfjKk+ouVugPvpD4TrwR" +
       "feKq95jFx+GH7xxXu8/Dr2hffK7Pvuf7tV/YfeenuWqW5b3cRZfu3H1yWHSa" +
       "v7d87XV7O+zrju6TP7jvV+5+/eE71vt2DB+b3gneXnP2F3VtL0yKb+CyL7/i" +
       "1976i8/9cXF6/f8DVN9uALU/AAA=");
}
