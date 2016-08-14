package org.apache.batik.css.engine.value.css2;
public class FontStyleManager extends org.apache.batik.css.engine.value.IdentifierManager {
    protected static final org.apache.batik.css.engine.value.StringMap values =
      new org.apache.batik.css.engine.value.StringMap(
      );
    static { values.put(org.apache.batik.util.CSSConstants.CSS_ALL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ALL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_ITALIC_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          ITALIC_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_NORMAL_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          NORMAL_VALUE);
             values.put(org.apache.batik.util.CSSConstants.CSS_OBLIQUE_VALUE,
                        org.apache.batik.css.engine.value.ValueConstants.
                          OBLIQUE_VALUE); }
    public boolean isInheritedProperty() { return true; }
    public boolean isAnimatableProperty() { return true; }
    public boolean isAdditiveProperty() { return false; }
    public int getPropertyType() { return org.apache.batik.util.SVGTypes.
                                            TYPE_IDENT; }
    public java.lang.String getPropertyName() { return org.apache.batik.util.CSSConstants.
                                                         CSS_FONT_STYLE_PROPERTY;
    }
    public org.apache.batik.css.engine.value.Value getDefaultValue() {
        return org.apache.batik.css.engine.value.ValueConstants.
                 NORMAL_VALUE;
    }
    public org.apache.batik.css.engine.value.StringMap getIdentifiers() {
        return values;
    }
    public FontStyleManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "55wUyfbdpmdH489BzzZ7/DqYsBbHZsKzwbbDhpGbMB9rATOdLjD2HDbf95tw" +
       "DcQqpxqrFgU+1qR21eVa6OR1sFANjs2AZ7Ot5uaRWygfawEr/KzA2MvY/MSy" +
       "0AqWpGnFKtgdC904fL3q0gvDvXAdDFeHY1irJmztEyM3XD7WAsZ5s8DYr7E5" +
       "y8lYMFx7ArIlHPiZVVd2ucb45f/CGBkAavDGD4+nk3L+erCuy6Vnj1aVTTy6" +
       "4bwokrNX2pVQ9CTTiuI9QHneS3SDJWWhW6V1nNLF17ucNH2xa0lOivFLqHHe" +
       "Yn6fk5nDMsO5qj+LIZvxAidTCjDCucp68fL8AfLpUDwQEqH1Un4EFg1SghTi" +
       "20v3MScVLh0sar14ST6B2YEEXy/pzq65dXiDuZixPZoJ+Q9fWQzVDYchz3lt" +
       "lq9IFf9gOVVc2voPq0c6dXT1mnuvfOkp6zJPUujOnTjLaKjdrCvD7HFlZt7Z" +
       "nLlKVjVfHXu6fLZTVPouE72yCSRDIhIXb5MDt1tmY/aS671ji1/61b6St6Ec" +
       "3kRCFI4Fm3IvDjJ6Gs6Jm2K5NSoc7cS1W0vz44NL5iX/+r64miE5FzJB+h7p" +
       "3PHN7xycdKw+TEa3k1FQL7OMuNFYMaiuY1K/0U3GyObKDIiIfqOKrwAei3uM" +
       "YgIRdrHNOSbbi7e8nDTklvW5d+MVijbAjOVaWk3gNFBCj3Z7nGOr78SX1vUA" +
       "g9vjOclkrCoBvQGQ7Yl16LpzRVo8XRehZnDosgHbz8UrNtf+Cxgxa6bdHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zMsjuWPuR+NR5IvdOC9iMZoLAi1oWUOe77lutuJ2qB+rOLfCdsNGEtUnDWVf" +
       "zMbrAJ8M9MziWIyWQkqNqVTY+YNCi1c8vQhmzY6KcCuXcAtvp9gTK1tbydTw" +
       "5/F0OyRCR1jESByOfXdqWTOMdqS9vOTnXXHXdGUmEgsnwlmOkBRrQLjN2XKN" +
       "qtNWNOv0uiqtT8gcT/2cz9I4WWj9tcQ2sxXWRkiS2/mcaRCZWEyKyZrp+oNE" +
       "kidLPajVO81O2F7wMUfWSb1P7kS75um93JpkWczXMmpMGpG4ri+jTjRfeuRs" +
       "mq87Wo8NWkPeWwzMFpwELW3Tr9ltBdiXS0uiSnvFRHb20haRbBVJaE8oVimJ" +
       "5YXpEakwaGyxBNuyMmUyuw6q9wkMfLo09usUbuExI6AyGyTzwpD37sjiitrQ" +
       "bcSJijaQHq3G0zhwg1Wrgeou0pjpaq2u9SesQIk7oTZYFJTXSmvYfN5G2gu/" +
       "znlYjMruIJ6sIkbk1uNsIOVca4e5zVCIBlsf9TxcLsRMTXaWLwyIKaNriJGi" +
       "wVTSjJ3DuPliXTfHG4GhJ7FHThWzQyRg/HAEDTd0raU1xp1Jx2vFFGfPzGnT" +
       "7bXFzJsTGTXh5ShYp+uYEbf1YXtqr+h+31WHeU2nCmmzR9Z64HVZaqWshlhE" +
       "jfd1YZ6RQtxDGXTCtX3B3xvUSjKk4XQ4Z6hiPpOUGbkcM9ReDGGkLe/Woxxb" +
       "KCTb6LJIj5JklK4lw86cWlFELPcTfOduRu2kyEkJa7izOjJd6hRJMfyCXUgs" +
       "ySfjyZZiPZYkmIXUkWJScnsFES7kgmU7Yp8lluSE3Wnz4VzL5ka7MZdJSUVI" +
       "m9tKGYvmXX6qI3mj3+k4aru+Dg1hH3tzPGlNBqlcyF7qh2uVi+PYH7stWpgF" +
       "xMZsJRjeQRqiVGxxoSWIqRak0oTmN7vBmCH8FZeFRajuWz623xaing6HfQF1" +
       "ZqwuhzjgCLtwscnyjiZuRwi88NbCAukwxKBu4EZ3vOkK+iCy9QyMTJEiYt9C" +
       "/bwYkT7bsTZ42HG7C4TSyOmwvhsNA7nnEA2/UJrC1t77tEUTFDwm0yY2TGrk" +
       "YOIWI1PWzJ3cdePeJFhjA2qFbRNbQxddI6qRBllHrbHWpGWWImXFrvW5OZxP" +
       "CAMmcCVgBgNMke35AGZqQhYmHcZrzziSma/YkGtvxyvJmQOjqTF9PoetgUiy" +
       "DC/2Zgk5RhGVVWqklYpkY55tikZkzldxnc+LbuDxztScLGHB4+Yty1nQGB+a" +
       "je0W6XX6zHywntVQbLgTjFp/bOZmoHRlbkFGNLW1epgkyerOC7RiOevVao6j" +
       "GKNwBNfmsDWb5cU8Mi1yZ8CLQWOEGX48shIUxscEqg7c8bITGhmODzRzjpoi" +
       "LOy2zU6Xo50ABp/GI0ddO2N2R9FjX24TgzFH+tslTov9zjIVZPCtUM8EXmWD" +
       "dhAwtVHNsKXYn689smbW+saoqON23umF7Uwz5kSByAbBSFrfo5gkt1C2vmmJ" +
       "o4iiGoY7DiR1xm5lDnW1ZVuwslwbOhZ4tfNtwlspt6Ulyzf1elfdj9yFxogj" +
       "btOwds22gI7iGS0FDU+KmQjzUG6lmpxkewIhjNgA780b63AAFNCbTpXtEvOK" +
       "Oov3bZdpyiPCQhUOb7ErsdGqtySbXxW1NtvrxLPGUNjJhro2MJZrxU0LFx27" +
       "54wNDIOt/orkFju9VbdRcljznCaiYOGmVhNa5gYDLsCbjum8u1nFeEsN+cTz" +
       "8k5jW893Q1TdyYhJc5TVWMihHLZGQ3zaGtEFl9cDRBs4496ezrYGkS8zfmz1" +
       "4oTjlTYGY7s6F+OzhKdMNNqm/WDWVVVkiPY7IsKvaviCpNb2ooM7pImLw60G" +
       "VE5uxy1joKfdySBbgkDUHLTH2k5uYkZPkqNePKsNuFmMdmOe5Xx5h85lWumo" +
       "8xlpYWMrQikz9aa5Koa1XsYuw4WhKp7Rg/t4gCcNU+liU2+fUdjS4Ruar1it" +
       "ySJJp1KN7tjEVHfCteb39/12tm/2li6hjPb8uDuvBZuxP+/Kdq434Ia3MvNp" +
       "Q8PMyDLXeJzV0rTfDOyhmhYTpY02tW6/45vdPrZt5x3HyfZq3th6QylEEak9" +
       "tezupql36XC0JYTJils30lpgFLWJBc9oTZrXt6OgSxP4Rm1OtVp77S2avcIJ" +
       "B+hyi+M7DJaxDJ4gktolm1wzTJwidhXKJDGrtwOhyswyanDPpPvzpYDMYcbd" +
       "cAKlsyOHpUyd3qGd6UobDa1EHk2T5hbXyTUdWYaDo5yT41xRRyPOlmWECttt" +
       "j0kl25rpSnuF181Zt9dSF2nPBfI2azl4a29smsQSCRt7e3tMUbvuQC4QRS1G" +
       "VKKQi/HC8Vy7uYbnXYIubCe1pQGVSySYII3mcDNnN+lopmxoMUhGu1WY2WGQ" +
       "Yg2NzOOAUZa0aYxrDrqZd+rEBl0GKNFoDQe6sp8ytKEkTLuD2hLSCNrMpK0q" +
       "jWbSbKp9PVoZqiOiHs81OLHNpSOb7qsciDvDjdCMCXE+XelyIFKF50erWMDH" +
       "GliSVN5k6isd5RmTgRED1jswrTX9YcjNV8t9vaYseHKUU2QwcgpRrYliwuKr" +
       "gTL1e2Kmc117uZ/OB6N042NBICGjoInM0dZy6EU1ZDGMRsx4SfQGm43E0QsM" +
       "QdVtD7MX+wLrS8VkORshrf5UnYUzodHp4jMyjRxjSqJ9u7Cl/ZpQiF5fzrw9" +
       "isV2zVn5NRz8tvLOMaw4sPpYq03t9xoBd9dqShl9LeX2W8PoLuOeIVDthJyK" +
       "Fr/qov2u4bTxbNs1pXVcrBNmIdeQNXDptqI3xTGSMuRwlaKkRogZnuvj2W7h" +
       "6Fs6gbk9iQobFRYmuzq5nsW9kOGyhdVp1zEwf9b1xaa7mZNWl7H7KuImg2Cf" +
       "0TuhAYYcQNHwtNVVE4LGdy1fFZiCIBPW749cTVEsNDcNDHfgTo/ySH3T7XWx" +
       "Wug1+JqddPJdUwlXiK5Mpzsw7beRlwznaKxI7c506uZsW+qH9qQx6Q5ms+Ws" +
       "qSDhkGcQIjeHfbTQ677obhh+3e/bath0PDzsCqmIr1c1ntU2Bela086q28nN" +
       "uNly+Bbp8LHc3Ur0uo/IIUYzC2SyWE5dtL5pCBNT4Zf1VE8QbDJtUqhK0/Md" +
       "HO/XTdyau91cA6uxFg1qUtuZSXulq5rLfcPP/HWbZZz2QlQUE91EIxCoNa35" +
       "FAnCfOOIXtzcD0ZyvhLD6YrXuZWVdDZdos/4WkZoIe9zykpx+vO86fDaVBlF" +
       "OU2gu85k3GWX7NzAhW6GZIEK65MmgaxcBG4iRnOSNWmz4Y07DIsxQYPddFeD" +
       "Zi9tDgKUw4eTyCTMCTKrb/YYNuRxdw7XkiYWuDTO7AdUbUnEjVF/SBQ70+K2" +
       "tSmtNzyEkXhCFPIhowq6m4MvA7guN3o70eC6rMs6a5FLtqTtNnJBXbBjK+kP" +
       "xYlhuITdCrtTz9/McKsmKO7KIFeios+8xmLIUJ1VQyPCnpgQrckc2cjkor1Z" +
       "iabvJZ2I2kg9iVB9pMnH+7ESteZje6mF3Shd9I19S06GmVPrFItCbxpWf0GS" +
       "5aew8/J2Ix6qNl5ODgNXPlFWSC/jK/xQ9USZvP1kk6v6XbnDBvqZTUao3Fl4" +
       "y+3O+KpdhU996LnnLfHTyOWjzVk9g+7Lovg7fHtj+2eaugpaevftd1CE6ojz" +
       "dNPwCx/6n49O37P8wMs4FnnrBTkvNvlzwmf+oPcO88cvQ3edbCHecvh6nunp" +
       "8xuH9yd2lifh9Nz24VtONPtIqbF3HJ9RHP/fejTxolZwqbKCw9jfYe/7++5Q" +
       "9/1lss2gR9yUDZd24ma2NUqi6ji7YvjuMwbzgQy6akSRb+vhqTEVL7Wlc7bL" +
       "qiA7j/6d4HnvEfr3vvroP3qHuh8tkx/KoNe6KRm6gZ6VhxbH8Mu6D57i/PAr" +
       "xfl28DBHOJlXH+dP3aHup8vkxzPoYbe821Bt8d0G5U+8ApTXysLHwCMcoRRe" +
       "fZT/6Q51ny6T5zPo2sLOjuGdnAlesOO73KNLJxXq//gKUD9cFj4BHvkItfzq" +
       "o/6lO9T9cpl89jzq4ZH/kU4hfu4VQKyWgMfB8/4jiO9/9SH+9h3qXiiTXz9A" +
       "7NqOnvuHo57j44R3vvRxyCl9pY3feAXaeF1ZWC6A1pE2rFdfG1+6Q90flckX" +
       "MuhBoA3WssOsPHA4XDHqnyL84stBWGTQ9Yv3GMqD2DfecqHqcAnI/Nzz1+59" +
       "w/Pyf62O8k8u6tzHQ/c6ue+fPTc7k78SJ7bjVhjuO5yixdXfn2bQO/51ly0y" +
       "6O7yr5L/ywfmP8+gJ16SOTs6CDrL+D8y6E13YMygK4fMWZ6vgKXixXiAPwHp" +
       "Wcq/BBq9SAmkqP7P0v11Bt1/Sgc6PWTOkvwNaB2QlNmvx8cm33hphZ3axtGI" +
       "FpfOh2kntvLwS9nKmcjuyXPxWHUv7zh2yg83854xP//8YPi932x++nBhwvT1" +
       "/b5s5V4eunq4u3ESfz1x29aO27rSf+pbD/7CfW8/jhUfPAh8OsXOyPbWF7+R" +
       "QAdxVt0h2P/aG375O//z81+pzvz+Be9X+q8wKQAA");
}
