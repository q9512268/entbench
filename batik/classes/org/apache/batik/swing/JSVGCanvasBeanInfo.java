package org.apache.batik.swing;
public class JSVGCanvasBeanInfo extends java.beans.SimpleBeanInfo {
    protected java.awt.Image iconColor16x16;
    protected java.awt.Image iconMono16x16;
    protected java.awt.Image iconColor32x32;
    protected java.awt.Image iconMono32x32;
    public JSVGCanvasBeanInfo() { super();
                                  iconColor16x16 = loadImage("resources/batikColor16x16.gif");
                                  iconMono16x16 = loadImage("resources/batikMono16x16.gif");
                                  iconColor32x32 = loadImage("resources/batikColor32x32.gif");
                                  iconMono32x32 = loadImage("resources/batikMono32x32.gif");
    }
    public java.awt.Image getIcon(int iconType) { switch (iconType) {
                                                      case ICON_COLOR_16x16:
                                                          return iconColor16x16;
                                                      case ICON_MONO_16x16:
                                                          return iconMono16x16;
                                                      case ICON_COLOR_32x32:
                                                          return iconColor32x32;
                                                      case ICON_MONO_32x32:
                                                          return iconMono32x32;
                                                      default:
                                                          return null;
                                                  } }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYe2wUxxmfO7/fD17mYYPNAbIhdwECKTKlMY4NR89wwmCp" +
                                                              "B+GY25vzLd7bXXbn7LNT0gSpwolaRIkDNAr+i4gUkZBGjdqqTUQVtUmUtFIS" +
                                                              "2jStQqq2UmlT1KCqaVXapt/M7t4+7s6ISrW0c+vZ75v5nr/vm7l8E1XoGuog" +
                                                              "Mg3SSZXowQGZRrGmk2S/hHV9H8zFhbNl+K+Hbuze4keVMdSYxvqQgHUyKBIp" +
                                                              "qcdQuyjrFMsC0XcTkmQcUY3oRBvHVFTkGFog6uGMKomCSIeUJGEEI1iLoBZM" +
                                                              "qSYmspSEzQUoao+AJCEuSajP+7k3guoFRZ20ydsc5P2OL4wyY++lU9QcOYLH" +
                                                              "cShLRSkUEXXam9PQWlWRJkclhQZJjgaPSJtME+yKbCowQdeLTZ/ePpVu5iaY" +
                                                              "h2VZoVw9fS/RFWmcJCOoyZ4dkEhGP4oeQWURVOcgpigQsTYNwaYh2NTS1qYC" +
                                                              "6RuInM30K1wdaq1UqQpMIIo63YuoWMMZc5kolxlWqKam7pwZtF2R19bQskDF" +
                                                              "p9aGZs4ean6pDDXFUJMoDzNxBBCCwiYxMCjJJIim9yWTJBlDLTI4e5hoIpbE" +
                                                              "KdPTrbo4KmOaBfdbZmGTWZVofE/bVuBH0E3LClTR8uqleECZ/1WkJDwKui60" +
                                                              "dTU0HGTzoGCtCIJpKQxxZ7KUj4lykqLlXo68joEvAgGwVmUITSv5rcplDBOo" +
                                                              "1QgRCcujoWEIPXkUSCsUCECNoiUlF2W2VrEwhkdJnEWkhy5qfAKqGm4IxkLR" +
                                                              "Ai8ZXwm8tMTjJYd/bu7eevJheafsRz6QOUkEiclfB0wdHqa9JEU0AnlgMNb3" +
                                                              "RM7gha9M+xEC4gUeYoPmu1++9cC6jqtvGDRLi9DsSRwhAo0LFxKN7yzr795S" +
                                                              "xsSoVhVdZM53ac6zLGp+6c2pgDAL8yuyj0Hr49W9P/nSo5fIx35UG0aVgiJl" +
                                                              "MxBHLYKSUUWJaDuITDRMSTKMaoic7Offw6gK3iOiTIzZPamUTmgYlUt8qlLh" +
                                                              "/4OJUrAEM1EtvItySrHeVUzT/D2nIoSq4EH18HQg44//UnQwlFYyJIQFLIuy" +
                                                              "EopqCtNfDwHiJMC26VACon4spCtZDUIwpGijIQxxkCbWhwmIoNCu4ZEd/Vge" +
                                                              "x/p2guUwSBFkUab+n9fPMf3mTfh8YPpl3sSXIGd2KlKSaHFhJrt94NYL8beM" +
                                                              "oGKJYFqGom7YMmhsGeRbBvmWwcItkc/Hd5rPtjYcDO4Zg0QHpK3vHn5o1+Hp" +
                                                              "rjKILHWiHGzLSLtcFaffRgMLwuPCldaGqc7r61/zo/IIasUCzWKJFZA+bRSg" +
                                                              "SRgzs7c+AbXILgkrHCWB1TJNEUgSEKlUaTBXqVbGicbmKZrvWMEqWCw1Q6XL" +
                                                              "RVH50dVzE4+NfOVeP/K7qwDbsgIAjLFHGXbnMTrgzf5i6zaduPHplTPHFBsH" +
                                                              "XGXFqoYFnEyHLm8seM0TF3pW4JfjrxwLcLPXAE5TDHkFENjh3cMFM70WZDNd" +
                                                              "qkHhlKJlsMQ+WTaupWlNmbBneJC28Pf5EBZ1LO/a4QmZich/2deFKhsXGUHN" +
                                                              "4syjBS8Jnx9Wz//yZ3/cyM1tVY8mR9kfJrTXgVhssVaOTS122O7TCAG6D89F" +
                                                              "n3zq5okDPGaBYmWxDQNs7AekAheCmb/6xtEPPrp+4ZrfjnMKJTubgM4nl1eS" +
                                                              "zaPaOZSE3Vbb8gDiSYAKLGoC+2WITzEl4oREWGL9q2nV+pf/fLLZiAMJZqww" +
                                                              "WnfnBez5xdvRo28d+nsHX8YnsIpr28wmM2B8nr1yn6bhSSZH7rF327/5Oj4P" +
                                                              "BQFAWBenCMdVxG2AuNM2cf3v5eN9nm/3s2GV7gx+d345OqO4cOraJw0jn7x6" +
                                                              "i0vrbq2cvh7Caq8RXmxYnYPlF3nBaSfW00B339XdB5ulq7dhxRisKADY6ns0" +
                                                              "AMecKzJM6oqqX/3otYWH3ylD/kFUKyk4OYh5kqEaiG6ipwFXc+oXHjCcO1EN" +
                                                              "QzNXFRUoXzDBDLy8uOsGMirlxp763qLvbL04e51HmWqssZTzlzOod6Eqb9Dt" +
                                                              "xL703v0/v/iNMxNGie8ujWYevrZ/7pESx3/7jwKTcxwr0n54+GOhy88s6d/2" +
                                                              "Mee3AYVxB3KF5QlA2ebdcCnzN39X5Y/9qCqGmgWzIR7BUpalaQyaQN3qkqFp" +
                                                              "dn13N3RG99KbB8xlXjBzbOuFMrsswjujZu8NHvRqZC5cCU+nmdidXvTyIf4S" +
                                                              "5ixr+NjDhnsssKhRNYWClCTpwYuGOZalqFEEvSFYFG395tz6zZy1DaZ5JOEJ" +
                                                              "GgxnoAE1sJONn2PDLmOL3pKR2u/WrAuegClCoIRm+wzN2BApVKAUN0UNTIEh" +
                                                              "RVa4/Gwy6pF2/11Ky/ywxtxvTQlpD8wpbSlup7k3bsht3FBM3IP/g3F7zA17" +
                                                              "SoibmFPcUtwO45aUVphD2py969r8rvyvEnk6ZmcNs1EJMehtL3Wo4QeyC8dn" +
                                                              "ZpN7nl1v4FKr+6AwAOfg53/x77eD537zZpEetYYq6j0SGSeSY0/WX7a7kHCI" +
                                                              "n/dsWPmw8fTvvh8Y3X43rSWb67hD88j+Xw5K9JQGV68orx//05J929KH76JL" +
                                                              "XO4xp3fJbw1dfnPHauG0nx9uDbwrOBS7mXrdKFerETjFy/tcWLcyHwAtzLFt" +
                                                              "8GwxA2CLN2jtEPPETr7/KcXq6RR8xU4MzFXD2YQO3b2YgWZu3DzobogeFqYD" +
                                                              "0d8bkbS4CINBt+C50NdH3j/yNrd5NXNyXlOHgyEYHH1qs6HCZ/Dng+c/7GGi" +
                                                              "swn2C+Wm3zy1rsgfW1mFnrPUehQIHWv9aOyZG88bCnjrqoeYTM888Vnw5IyR" +
                                                              "Fsbdx8qC6wcnj3H/YajDhkeYdJ1z7cI5Bv9w5dgPnjt2wm92bBmKykTzWsrt" +
                                                              "o/lukxtyPvh40w9PtZYNQrKFUXVWFo9mSTjpDrgqPZtw+MC+KrHDz5SY2Zsi" +
                                                              "Xw+Ylk9PzdFafo0NWYqqRgkNC0bLH7WBb/xOMD13t8Ym+tQcOL7wRMxaubaC" +
                                                              "Czfjkkh4YbapetHs/vc5+uQvcuohFFNZSXI2G473SlUjKZGrVW+0Hir/mYGG" +
                                                              "vfhBnaIK/sslf9KgPktRs5ca6Pivk+5pimptOjjHGC9OkvMQBUDCXmdVq+lY" +
                                                              "zJuOBFhBDw6LGVUilkVyPndVyHthwZ284CgkK12ZxO89rXDLGjefceHK7K7d" +
                                                              "D9/a/KxxDhQkPDXFVqmDIDOOpHkc7Sy5mrVW5c7u240v1qyyIr/FENhGt6WO" +
                                                              "aOuDHFCZ45d4Dkl6IH9W+uDC1ld/Ol35LuTsAeTDFM07UNik5tQsFLADkcJk" +
                                                              "gprDT2+93U9PbluX+suv+THATL5lpenjwrWLD713uu0CnPLqwqgCkprkePf8" +
                                                              "4KS8lwjjWgwaBX0gByLCKiKWXJnayGIUsxtRbhfTnA35WXaLQFFXIfYU3r3A" +
                                                              "kWmCaNuVrJw0c73OnnFdyFqlKKuqHgZ7xoHP0wY8GFBcFo8MqaoFzXV7VZ6s" +
                                                              "j3sRi09y7m/zVza89F+D9D52ExkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "AxWVtxQsDxbllbx43UH6XvBDLwZa6tp+Bv8YfM6A57/zJxeXN+wm3zuw/RXA" +
       "A4dLAB9MSbeZwAcgjbyw0sgqjULMK0FzEVlyGu/RDlhr7ZAtL6t58dZdd/Xr" +
       "xtHPnbTyIfBc2bfyynWsZK5jZV7FCtfhMXRrri3nuV6hbN5InlKNfYmq5QPw" +
       "un3VXncd1cY/jWpHjkSqGVK9lm78/8Jtj+7r9uh1dBNfktuuq5r0E1UrRGVn" +
       "QNTdVN1D98r57yeu3fkNefX1YHaJiv0O4FiYrmwfaHPXylavHETjDOx/ADRc" +
       "WdnoQexdLmIvT8K93abhlK74T60rQK3bjoSxHth/vP8fPvD133j42wBaetBN" +
       "6zztAaIc67Gf5FuyX3nuQ/e+7OnvvL+YLIE3Z7/6u+h3cqnWi1mcF1pe6Aem" +
       "3pObyhfrTVaOYq6Y33StsPZFEXUYmg5YBqz39xvwk3d82/rYdz+z20uchs9T" +
       "xPr7nv61H+899fTZYzu4h6/aRB3n2e3iCqVv3fdwCD34Yr0UHMQ/fu7JP/zU" +
       "k+/daXXHyf1IF2y3P/OX//X1vY9+56vXWArfaHv/h4GNb/0iVYvo9sGHnYl6" +
       "NZ1mmbMYoPACr6COKA77bYVeamkXYyaMzYm1/rjZSlMH8zslUqzW11tWQ5X5" +
       "XHFRtj8pG7yferY8pi283w5LZs2YWlKHXGlBMJmOZvHUmcYEzVdXfDwKgurU" +
       "sScVBgvk2RzsPWAOjWslNGrQfCiU1dJaQuvruhvCawe1m93K3CMTz+AMhOel" +
       "uZeOSGkcko5V5eElNWtRzS2xVPp2iSlRSrLVa5Y+4zRezNbByKCmG6ZD+4Gq" +
       "jZLNKiS4CCvP1YnljNSpiHjjzpqaEROLJDyjkZAc4zkYT+vTHtnt0hWT9ToS" +
       "F/CiE/l8dzuaerJXavewbsLLq2EJtRAj8YixVC1vtEitD6sDtpZuxFLJnrZG" +
       "6kBkKZVfsmPemnbnc9lpDUeCLYx7lmovR1JvZchDvhdz3dKGUTBglqazEwnW" +
       "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" +
       "YNu4pfYsww/xSbXUQqatoWIn81KUrEsTqj1h67avu6s0FFgcrSBJUsbcIRuk" +
       "gYFZfmjpw0WzxvBNO12tBCOVO/Oy0dmwGGMywrznyhuSnkZZPFaWi4nbRurC" +
       "XGZHBDGnF+IUCZG2JTiY3E9mIZgoVBQZuC6hbYjAZpgkoAwJzTxqWE7FJkl0" +
       "VMJrcoHsEdv5DJ1JjWiFRGOz3NqgDrydbWUwq5bwFl6vdjMLbNTe9KZ8C/fO" +
       "l7aLvr04MDi8cgSb5/zFS9k97l49mBevOTxjKT7noFPXVMfPuo8OQKF8R3zv" +
       "9W4Si93ws+95+hlt8InK2f2D4zSGLsSe/7O2vtbtY6LyU4lHr7/z54qL1KMD" +
       "zS+/55/vmbx5+cRLuKa5/5Sep0X+DvfcV8nXqh88C91weLx51RXvSabHTh5q" +
       "Xgz1OAndyYmjzXsPPVt4927wtPY92zp9enU0dtc+unr9buxPncuf2Xdg/js8" +
       "NubrGLrBdOOC54Mvcpb/kbz49Rg6b+gxre7uWMijCHrqJ50/nDgej6E7rr63" +
       "yy8h7r7qbwG7q2z1s89cuvmuZ6Z/VVxdHV43X2ChmxeJbR8/Mz5WP+eH+sIs" +
       "1L+wO0H2i69nYujOa18nxtBNxXeh8sd31L8dQ5dPUwO64vs43bMxdPGILobO" +
       "7SrHST4JnA1I8uqn/IMzu1cVJ2gK8EK0xwMYtvUDj2RnTqbRobfv+EnePpZ5" +
       "D5/Il+LfGQexnez+n/G4+rlnev13vND4xO6CTbXl7TaXcjMLnd/d9R3mx4PX" +
       "lXYg6xz1yI9u+/yF1xzk8m07hY+i9phu91/7NqsL5qLi/mn7xbt+/42ffOZb" +
       "xVni/wDvB9S6NiMAAA==");
}
