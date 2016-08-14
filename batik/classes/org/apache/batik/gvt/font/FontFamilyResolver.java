package org.apache.batik.gvt.font;
public class FontFamilyResolver {
    public static final org.apache.batik.gvt.font.AWTFontFamily defaultFont =
      new org.apache.batik.gvt.font.AWTFontFamily(
      "SansSerif");
    protected static final java.util.Map fonts = new java.util.HashMap();
    protected static final java.util.List awtFontFamilies = new java.util.ArrayList(
      );
    protected static final java.util.List awtFonts = new java.util.ArrayList(
      );
    static { fonts.put("sans-serif", "SansSerif");
             fonts.put("serif", "Serif");
             fonts.put("times", "Serif");
             fonts.put("times new roman", "Serif");
             fonts.put("cursive", "Dialog");
             fonts.put("fantasy", "Symbol");
             fonts.put("monospace", "Monospaced");
             fonts.put("monospaced", "Monospaced");
             fonts.put("courier", "Monospaced");
             java.awt.GraphicsEnvironment env;
             env = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment(
                                                  );
             java.lang.String[] fontNames = env.getAvailableFontFamilyNames(
                                                  );
             int nFonts = fontNames != null ? fontNames.length : 0;
             for (int i = 0; i < nFonts; i++) { fonts.put(fontNames[i].
                                                            toLowerCase(
                                                              ),
                                                          fontNames[i]);
                                                java.util.StringTokenizer st =
                                                  new java.util.StringTokenizer(
                                                  fontNames[i]);
                                                java.lang.String fontNameWithoutSpaces =
                                                  "";
                                                while (st.
                                                         hasMoreTokens(
                                                           )) {
                                                    fontNameWithoutSpaces +=
                                                      st.
                                                        nextToken(
                                                          );
                                                }
                                                fonts.put(
                                                        fontNameWithoutSpaces.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                java.lang.String fontNameWithDashes =
                                                  fontNames[i].
                                                  replace(
                                                    ' ',
                                                    '-');
                                                if (!fontNameWithDashes.
                                                      equals(
                                                        fontNames[i])) {
                                                    fonts.
                                                      put(
                                                        fontNameWithDashes.
                                                          toLowerCase(
                                                            ),
                                                        fontNames[i]);
                                                }
             }
             awtFontFamilies.add(defaultFont);
             awtFonts.add(new org.apache.batik.gvt.font.AWTGVTFont(
                            defaultFont.
                              getFamilyName(
                                ),
                            0,
                            12));
             java.util.Collection fontValues = fonts.
               values(
                 );
             java.util.Iterator iter = fontValues.
               iterator(
                 );
             while (iter.hasNext()) { java.lang.String fontFamily =
                                        (java.lang.String)
                                          iter.
                                          next(
                                            );
                                      org.apache.batik.gvt.font.AWTFontFamily awtFontFamily =
                                        new org.apache.batik.gvt.font.AWTFontFamily(
                                        fontFamily);
                                      awtFontFamilies.
                                        add(
                                          awtFontFamily);
                                      org.apache.batik.gvt.font.AWTGVTFont font =
                                        new org.apache.batik.gvt.font.AWTGVTFont(
                                        fontFamily,
                                        0,
                                        12);
                                      awtFonts.
                                        add(
                                          font);
             } }
    protected static final java.util.Map resolvedFontFamilies =
      new java.util.HashMap(
      );
    public static java.lang.String lookup(java.lang.String familyName) {
        return (java.lang.String)
                 fonts.
                 get(
                   familyName.
                     toLowerCase(
                       ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(java.lang.String familyName) {
        familyName =
          familyName.
            toLowerCase(
              );
        org.apache.batik.gvt.font.GVTFontFamily resolvedFF =
          (org.apache.batik.gvt.font.GVTFontFamily)
            resolvedFontFamilies.
            get(
              familyName);
        if (resolvedFF ==
              null) {
            java.lang.String awtFamilyName =
              (java.lang.String)
                fonts.
                get(
                  familyName);
            if (awtFamilyName !=
                  null) {
                resolvedFF =
                  new org.apache.batik.gvt.font.AWTFontFamily(
                    awtFamilyName);
            }
            resolvedFontFamilies.
              put(
                familyName,
                resolvedFF);
        }
        return resolvedFF;
    }
    public static org.apache.batik.gvt.font.GVTFontFamily resolve(org.apache.batik.gvt.font.UnresolvedFontFamily fontFamily) {
        return resolve(
                 fontFamily.
                   getFamilyName(
                     ));
    }
    public static org.apache.batik.gvt.font.GVTFontFamily getFamilyThatCanDisplay(char c) {
        for (int i =
               0;
             i <
               awtFontFamilies.
               size(
                 );
             i++) {
            org.apache.batik.gvt.font.AWTFontFamily fontFamily =
              (org.apache.batik.gvt.font.AWTFontFamily)
                awtFontFamilies.
                get(
                  i);
            org.apache.batik.gvt.font.AWTGVTFont font =
              (org.apache.batik.gvt.font.AWTGVTFont)
                awtFonts.
                get(
                  i);
            if (font.
                  canDisplay(
                    c) &&
                  fontFamily.
                  getFamilyName(
                    ).
                  indexOf(
                    "Song") ==
                  -1) {
                return fontFamily;
            }
        }
        return null;
    }
    public FontFamilyResolver() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZe5AUxRnv3Tvuxb15IxxwHFI83BWFqDk0HgcHhwtcuOOs" +
       "LOLSO9t7O9zszDjTc7d35hKxyhKpCkUIIKaEf4JBDQqVhDLGYJGy4qN8VKkk" +
       "xlgiFa34CqWU0aRiEvN1z8zOY3eWYOCqpm+2++vv6+/Rv+/rnqPn0DhdQy1E" +
       "phE6ohI9skqmPVjTSapTwrreB30J4f4y/NntH6y/IYwq4qg+g/V1AtZJl0ik" +
       "lB5HM0VZp1gWiL6ekBSb0aMRnWhDmIqKHEeTRL07q0qiINJ1Soowgn6sxVAT" +
       "plQTkwYl3RYDimbGYCVRvpJoh3+4PYZqBUUdccinusg7XSOMMuvI0ilqjG3D" +
       "QzhqUFGKxkSdtuc0tEhVpJEBSaERkqORbdIyywRrY8sKTNB6vOGLL3dnGrkJ" +
       "JmBZVihXT99IdEUaIqkYanB6V0kkq9+BvofKYmi8i5iitpgtNApCoyDU1tah" +
       "gtXXEdnIdipcHWpzqlAFtiCK5niZqFjDWYtND18zcKiilu58Mmg7O6+tqWWB" +
       "ivsWRffef3vjz8tQQxw1iHIvW44Ai6AgJA4GJdkk0fSOVIqk4qhJBmf3Ek3E" +
       "kjhqebpZFwdkTA1wv20W1mmoROMyHVuBH0E3zRCoouXVS/OAsn6NS0t4AHSd" +
       "7OhqatjF+kHBGhEWpqUxxJ01pXxQlFMUzfLPyOvYdgsQwNTKLKEZJS+qXMbQ" +
       "gZrNEJGwPBDthdCTB4B0nAIBqFE0PZAps7WKhUE8QBIsIn10PeYQUFVzQ7Ap" +
       "FE3yk3FO4KXpPi+5/HNu/fJdd8pr5DAKwZpTRJDY+sfDpBbfpI0kTTQC+8Cc" +
       "WLswth9PPrkjjBAQT/IRmzRPfPf8zYtbTj1v0lxRhGZDchsRaEI4nKx/dUbn" +
       "ghvK2DKqVEUXmfM9mvNd1mONtOdUQJjJeY5sMGIPntr47HfuepR8HEY13ahC" +
       "UCQjC3HUJChZVZSItprIRMOUpLpRNZFTnXy8G1XCe0yUidm7IZ3WCe1G5RLv" +
       "qlD4bzBRGlgwE9XAuyinFftdxTTD33MqQqgSHlQLTxsy//h/ihLRjJIlUSxg" +
       "WZSVaI+mMP31KCBOEmybiSYh6gejumJoEIJRRRuIYoiDDLEGBoZoNA2GiXZB" +
       "04WzojRixb8WYYGmXn4ROablhOFQCBwww7/9Jdg5axQpRbSEsNdYser844kX" +
       "zdBi28GyD0WLQWrElBrhUiMgNcKkRgqlolCIC5vIpJueBj8Nwo4HyK1d0Ltl" +
       "7dYdrWUQYupwORiZkbZ6Uk+nAws2lieEY811o3POLHkmjMpjqBkL1MASyyQd" +
       "2gBglDBobePaJCQlJzfMduUGltQ0RSApgKagHGFxqVJAD9ZP0UQXBztzsT0a" +
       "Dc4bRdePTh0Y3t7//avDKOxNB0zkOEAyNr2HgXgerNv8MFCMb8O9H3xxbP+Y" +
       "4gCCJ7/YabFgJtOh1R8OfvMkhIWz8YnEybE2bvZqAGyKYYMBFrb4ZXjwpt3G" +
       "bqZLFSicVrQsltiQbeMamtGUYaeHx2kTayaZIctCyLdADvs39qoH//jKh9dy" +
       "S9oZosGV2nsJbXehEmPWzPGnyYnIPo0QoHv7QM+P9p27dzMPR6CYW0xgG2s7" +
       "AY3AO2DBe56/4813zhw+HXZCmEJaNpJQ3eS4LhO/gr8QPP9hD0MS1mEiSnOn" +
       "BWuz87imMslXOmsDhJMAAlhwtG2SIQzFtIiTEmH7518N85ac+OuuRtPdEvTY" +
       "0bL4wgyc/mkr0F0v3v73Fs4mJLAM69jPITNhe4LDuUPT8AhbR277azMfeA4f" +
       "hAQAoKuLo4TjKOL2QNyBy7gtrubtUt/YdayZp7tj3LuNXJVQQth9+tO6/k+f" +
       "Ps9X6y2l3H5fh9V2M4pML4Cw2chqPLjORierrJ2SgzVM8QPVGqxngNnSU+tv" +
       "a5ROfQli4yBWAPjVN2iAlTlPKFnU4yr/9NtnJm99tQyFu1CNpOBUF+YbDlVD" +
       "pBM9AzCbU791s7mO4SpoGrk9UIGFCjqYF2YV9++qrEq5R0Z/NeWXy48cOsPD" +
       "UjV5XMHns+J+hgdhedXubPJHX7/u90d+uH/YzPsLgpHNN2/qPzdIybv//I8C" +
       "v3BMK1KT+ObHo0cfnN5508d8vgMubHZbrjBbAUA7c695NPt5uLXid2FUGUeN" +
       "glUl92PJYPs6DpWhbpfOUEl7xr1VnlnStOfBc4Yf2Fxi/bDmZEl4Z9Tsvc4X" +
       "g1OZC+fDs8iKwYX+GAwh/rKWT7mStwtYs5i7r4y9XgUQo/NanMISRBlLubwA" +
       "HiNTbMZFBFA0PkXS2JAoy9Z83lSK5gcn9Y5b+5y8boIxa69nzS2m4OWBkbwy" +
       "v7ArWO8yeJZYC1sSoHl/gOYUVauaQsE/JMW617Nmg0/z6SUEMGMxlWEHzHR2" +
       "AMvjvUZSpxvxMK+tE8Jt8xsnt93wWau5BVqK0LqK8F1P/Toen98omMStxRh7" +
       "i++Hj1QJb2Wffc+cMK3IBJNu0sPRH/S/se0lntqqWCnTZweVq1CBkseVMhvz" +
       "1qhnyjfBc9ayxlkz5dz2f1aYMA1OlmIWDkPRPjFLUuxky3SwKtjLyp8DtAe8" +
       "HKf9bFDq+OT6n95omnVOAG459E9+++yrB0ePHTWTJzMvRYuCzuKFFwCsZJpX" +
       "ouxzAuTz1d889eG7/VvCVrqrZ00yZ++8OgfKIXGwzm15yA/li+KJ3jAxOa+8" +
       "r+E3u5vLuqAe60ZVhizeYZDulBeJKnUj6Yob58jpoFMjayI5VpZQFFoI+cK3" +
       "y2+9yF2+Ap5rrbC7NmCXayXwLV5yewdxhvyPh2keqkRI0Kx/i3dLNMPziMXh" +
       "EZuDwDmkTGHcMiN5/9S7CwKzwrrT7yD2U/ZbTb9Iq7XDs9Ra2dIAq931ta0W" +
       "xJmiKstqfI5fie0XqcRKeHRLlB6gxI6vrUQQZziZadZNktv/bAz7FLqvhEK5" +
       "4gvj7r3KWQ7/q0DBdaSr3EIMsmYGXeHw66fDd+89lNrw0BITuJq91yKrZCP7" +
       "2B/+/VLkwNkXipzFq6miXiWRISK5ZJZ7Exyg5Dp+u+XUS2/X73n3ybaBFRdz" +
       "fmZ9LRc4IbPfs0CJhcHA6F/Kc3d/NL3vpszWizgKz/KZ08/ykXVHX1h9pbAn" +
       "zK/yzEKu4ArQO6ndC5o1GqGGJnthcm4+AKYxx86CZ8wKgDF/pDtBVxBNYR5N" +
       "PMx9Ed5UgqPv+GQnBgujGjlGsQo2Yt5T8gX8pMSZ6whrDkIdKSnKoMFlHHY2" +
       "yaEL7frSBxTWsULl/Q94T1+s8t1pqbjzkhktiGNxo3FdubBflDDQCdY8RlGl" +
       "BSz/Q6G8ut9VKDvGfPxyGvO4pfrxS2bMII6lIzASbJZNcgE2j/DlPVPC/M+x" +
       "5qRjfvbzCcemT18um14HzwnLAicumU2DOAbYtPgxokeDqpiKQ1bxd03PVmFH" +
       "W897dlm5lTURlm5KnNl9PKJjze8MPvjBY9ZBp+AG0ENMduzd+VVk114zDZlf" +
       "VuYWfNxwzzG/rrhrTN1dmReRwmd0vX9s7KmHx+61NdtHUbmQsdJNQdXFSV4v" +
       "EUrvsOZliqYMECv6+jKYdmJ5pairEh7xhdYrlyK0chQ1F16Gs5ubqQUf3cwP" +
       "RcLjhxqqphza9AbPyfmPObWQXdOGJLnvFlzvFapG0iJXs9a8aTCL9/cpmha4" +
       "I8Gcabve+4tJ/xFUUMXoKSqD1k15DrKNnxIO1vy/m+5TimocOkg05oub5DPg" +
       "DiTs9W9qkVRmXsbkQt5yKu+oSRdylKsCm+vZEvzzqL29jB7rQHjs0Nr1d57/" +
       "xkPmVbIg4dFRxmU8nKHMC+t8ATInkJvNq2LNgi/rj1fPs0PYc5XtXhsPF4hl" +
       "fu073Xe3qrflr1jfPLz86Zd3VLwGm28zCmGKJmwuvLbKqQZUfptjhWdFKNb4" +
       "pW/7gh+P3LQ4/clb/GLQApsZwfQJ4fSRLa/vmXq4JYzGd6NxsDtJjt+nrRyR" +
       "NxJhSIujOlFflYMlAhcRS56DaD0LY8wKEm4Xy5x1+V72jYGi1kIQKfwyUyMp" +
       "w0RboRgyv/yBo+x4p8cuRD01nKGqvglOj+vKJGsiE/MGxGMitk5V7Qv6mg6V" +
       "72c58LwXquSv7K3qv0H5xco6IQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bNfrm1Wh4la1Pcx76JKeLMO+jYfm3GKMsUJteCOwPbtLdBsp4ZOJhq/b461X" +
       "H+VURUXp2G6pghou5xMh8bcsb4kbWWzON7CLbaMqmAD0hXal4tU4lh5tnDXj" +
       "rwN8Q1cYbJrnE7Vq4Ibdwz1Z4ySyO7HJQmfUZD604wnKTzHfoCRjNBxkwYLE" +
       "eh2RQ+eTFV7ERTRDpZ5Sl3lV42YmKtTiFoJIaY9iszGOFhu2j+XjsDoyVoYW" +
       "jtM2M+gycpvtjGpZJnOwUDe6XbKFCJI8MMiYNSt8m9VTZmMSy6ItuP1c7lfl" +
       "VAywYU4JAoMPQrkurtZbP64N5UCkB1NLWYSTyI6tiawxkhMP54KkjbLqZibl" +
       "kkgocTenVayXRrVO4I0QZE2ZHTWfdsCARcNF1Y1IeaWZfYdbFtzQzQWX4Dx0" +
       "4o3S1oSBuY5fbakFw/HNrrBEM2NYjVqYUMPYag/XGk2k3q7UCnMLj1Zi1+mT" +
       "0tgnJzVtWqdNFjHC9oTjOmYPZaYVp29NXdbFl0nRblkOE9kr1ol6JslgmA0y" +
       "zrA6JSbFICasWd8ZtRqV9rjdkBSYTRI+5tR+OhNQma5vjVxBnE2IDtC0lrZq" +
       "g6jukDTGNDtrjpiNTa1O95I5N2tjpsxXWy2pYHQNq+smNsE8KqG9+mxNsXR1" +
       "Ms7xvGXEYSLH8xgRVCkX/Va8rtHJeEUuJhPg7HDMNpENrHNRZ9XMq3Zt1NDN" +
       "zqLK1H2Grne3VcUMOHoNTE0LQ7I6NYoFAyReDIPMNcbudA7HqdTgWX1iW/Uc" +
       "X2LcejGuWpg9szlq4M7reYh0xrFLOp1OPMkHSaU79ll8PoAFuWcvQAxiOljR" +
       "leetTiVqOWx96nsgX3TmxHDQXQfCoCosOjAchP2gwaMiMtaWq7zeVtiI683X" +
       "i8aKGbkRTMKmoZqaukpkjhytWkjSQVU4GSFCwUW04Y/G4yoScAVIUHKKIES7" +
       "m9ZwhqpQM5iVRx6q6O640UDbajs1mEQeiXK4xmVsjrWUZqcx5uJGQq8stTqY" +
       "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" +
       "w+0kKwAA");
}
