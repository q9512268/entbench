package org.apache.batik.svggen.font.table;
public class Panose {
    byte bFamilyType = 0;
    byte bSerifStyle = 0;
    byte bWeight = 0;
    byte bProportion = 0;
    byte bContrast = 0;
    byte bStrokeVariation = 0;
    byte bArmStyle = 0;
    byte bLetterform = 0;
    byte bMidline = 0;
    byte bXHeight = 0;
    public Panose(byte[] panose) { super();
                                   bFamilyType = panose[0];
                                   bSerifStyle = panose[1];
                                   bWeight = panose[2];
                                   bProportion = panose[3];
                                   bContrast = panose[4];
                                   bStrokeVariation = panose[5];
                                   bArmStyle = panose[6];
                                   bLetterform = panose[7];
                                   bMidline = panose[8];
                                   bXHeight = panose[9]; }
    public byte getFamilyType() { return bFamilyType; }
    public byte getSerifStyle() { return bSerifStyle; }
    public byte getWeight() { return bWeight; }
    public byte getProportion() { return bProportion; }
    public byte getContrast() { return bContrast; }
    public byte getStrokeVariation() { return bStrokeVariation; }
    public byte getArmStyle() { return bArmStyle; }
    public byte getLetterForm() { return bLetterform; }
    public byte getMidline() { return bMidline; }
    public byte getXHeight() { return bXHeight; }
    public java.lang.String toString() { java.lang.StringBuffer sb = new java.lang.StringBuffer(
                                           );
                                         sb.append(java.lang.String.
                                                     valueOf(
                                                       bFamilyType)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bSerifStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bWeight)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bProportion)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bContrast)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bStrokeVariation)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bArmStyle)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bLetterform)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bMidline)).
                                           append(
                                             " ").
                                           append(
                                             java.lang.String.
                                               valueOf(
                                                 bXHeight));
                                         return sb.toString(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1afXQU1RV/uwkhJIR88CkkISRBD6C7YrFiQ1USEhPdQCSI" +
                                                              "NKBhdvYlGTI7M8y8DRssVTm1oufUgxaV9mj6R1GsB8Vj9fTDj2I99eNobVWq" +
                                                              "tVattaf1o7Zweqo9pdbe+97szuzsztClTXPOvJ289+679/7ufffeNzOHPiJT" +
                                                              "LJM0Uo1F2LhBrUinxvok06KJDlWyrA3QNyjfUSL99ar31p4fJmUDZMaIZPXK" +
                                                              "kkW7FKomrAHSoGgWkzSZWmspTSBFn0ktao5JTNG1ATJbsXqShqrICuvVExQn" +
                                                              "bJTMGKmVGDOVeIrRHnsBRhpiIEmUSxJd7R1ui5Hpsm6MO9PnuaZ3uEZwZtLh" +
                                                              "ZTFSE9smjUnRFFPUaEyxWFvaJMsMXR0fVnUWoWkW2aaea0NwSezcPAiaH6z+" +
                                                              "+MTekRoOwUxJ03TG1bPWU0tXx2giRqqd3k6VJq3t5CukJEYqXZMZaY1lmEaB" +
                                                              "aRSYZrR1ZoH0VVRLJTt0rg7LrFRmyCgQI4tyFzEkU0ray/RxmWGFcmbrzolB" +
                                                              "26astkLLPBVvWxbdd8dVNQ+VkOoBUq1o/SiODEIwYDIAgNJknJrW6kSCJgZI" +
                                                              "rQbG7qemIqnKTtvSdZYyrEksBebPwIKdKYOanKeDFdgRdDNTMtPNrHpD3KHs" +
                                                              "/6YMqdIw6DrH0VVo2IX9oGCFAoKZQxL4nU1SOqpoCUYWeimyOrZeChOAdGqS" +
                                                              "shE9y6pUk6CD1AkXUSVtONoPrqcNw9QpOjigych830URa0OSR6VhOoge6ZnX" +
                                                              "J4Zg1jQOBJIwMts7ja8EVprvsZLLPh+tXXXz1Vq3FiYhkDlBZRXlrwSiRg/R" +
                                                              "ejpETQr7QBBOXxq7XZrz+J4wITB5tmeymPP9Lx+/6MzGI8+KOQsKzFkX30Zl" +
                                                              "NigfiM94qb5jyfklKEa5oVsKGj9Hc77L+uyRtrQBEWZOdkUcjGQGj6x/+kvX" +
                                                              "3kc/DJOKHlIm62oqCX5UK+tJQ1GpeTHVqCkxmugh06iW6ODjPWQq3McUjYre" +
                                                              "dUNDFmU9pFTlXWU6/x8gGoIlEKIKuFe0IT1zb0hshN+nDULIVLjIdLhOI+KP" +
                                                              "/zKyJTqiJ2lUkiVN0fRon6mj/lYUIk4csB2JxsHrR6OWnjLBBaO6ORyVwA9G" +
                                                              "aGZgbHiYatEhHSOUFFcpuIKmWzSCXmZM8vpp1G/mjlAIoK/3bnwV9ky3riao" +
                                                              "OSjvS7V3Hn9g8HnhVLgRbGQYWQIsI4JlhLOMCJYRZBnhLCOCJQmFOKdZyFoY" +
                                                              "GMwzChsdIu30Jf1XXrJ1T3MJeJaxoxSwxanNORmnw4kGmRA+KB+uq9q56K3l" +
                                                              "T4VJaYzUSTJLSSomkNXmMIQmedTevdPjkIuclNDkSgmYy0xdpgmISH6pwV6l" +
                                                              "XB+jJvYzMsu1QiZh4daM+qeLgvKTI/t3XLfxmrPDJJybBZDlFAhgSN6HsTsb" +
                                                              "o1u9u7/QutU3vPfx4dt36U4cyEkrmWyYR4k6NHt9wQvPoLy0SXpk8PFdrRz2" +
                                                              "aRCnmQT7CkJgo5dHTphpy4Rs1KUcFB7SzaSk4lAG4wo2Yuo7nB7upLX8fha4" +
                                                              "xTTcd9VwnWFvRP6Lo3MMbOcKp0Y/82jBU8IX+427fvXi+5/jcGeyR7Ur7fdT" +
                                                              "1uaKWLhYHY9NtY7bbjAphXlv7u/7xm0f3bCZ+yzMaCnEsBXbDohUYEKA+fpn" +
                                                              "t7/+9lsHjoYdP2eQslNxqHzSWSXDqFN5gJLA7XRHHoh4KkQF9JrWyzXwT2VI" +
                                                              "wY2HG+uf1YuXP/Knm2uEH6jQk3GjM0++gNN/Wju59vmrPmnky4RkzLgOZs40" +
                                                              "EcZnOiuvNk1pHOVIX/dywzefke6ChABB2FJ2Uh5XQ9m97qoucT/1p+IW49Qi" +
                                                              "9WypfPrH1nf+8JBIPc0FJnvy2b0Hy+U3kk//XhCcVoBAzJt9b/TrG1/b9gL3" +
                                                              "iHIME9iPIFW5ggCEE5c71mQtVY+GaQINHhOGEr+MyP9l3I6bSmKYRttBnH7Z" +
                                                              "VAwGhUanNqaYupZEVez08P9gkwbjLPaPai4bTdzT8uI1Ey3vgJMMkHLFgsgJ" +
                                                              "uBWoV1w0xw69/eHLVQ0P8EBSivDb0OcWevl1XE55xq1Sjc0X0lZh9+gzlSRs" +
                                                              "6THbPc7p2yrvae3j7oF0K4VJP4O/EFz/wgtNiR3CpHUddr3RlC04DAO5LQk4" +
                                                              "IeQyje6qe3v0zvfuFz7pLcg8k+mefTd9Frl5n9i5omptySsc3TSichUeik07" +
                                                              "SrcoiAun6Prj4V2P3rvrBiFVXW4N1glHjPtf/fSFyP7fPlcg/ZfGx5kwyYqc" +
                                                              "3Twr1wJCozU3Vj+2t66kC2zdQ8pTmrI9RXsS7iXBrFYq7tqATjnMO9y6oWUY" +
                                                              "CS1FI+QLUJ9TOvBTqJO97nvlvF8evOX2HULjAPt56Ob9Y50a3/27v3Mg8pJ1" +
                                                              "AZN66Aeih+6c33HBh5zeyZpI3ZrOr8Fg/zi059yX/Fu4ueynYTJ1gNTI9qlv" +
                                                              "o6SmMBcNwA6xMkdBOBnmjOeeWkSJ3patCuq9PuVi683XbkuVshyr1IrdFyI8" +
                                                              "Q13BKc7g7VJszuKWCeNthMGiiiapnK4d8p9KtWE2wievsR0Xf7oZKYF9j7cX" +
                                                              "uowcFkvx/+cxO9uganAO0jWKiSszJmpNRY9kz6AwWMhdGnLcpZeHFgf7N2fc" +
                                                              "+u4PW4fbiykysa/xJGUk/r8QDL/U3wO9ojyz+4P5Gy4Y2VpEvbjQ41beJb/b" +
                                                              "e+i5i0+Xbw3zY65wirzjcS5RW64rVJgUzvNa7jZtEQ7BrSe8AZtl3L78/7Oz" +
                                                              "diDcDiIQqwFjvBxTwH1kNLTwi4Dp2/N6sTpZWLju6UwajFcqO38w9+FVByfe" +
                                                              "4iWakSZeb8F/16Y5g3MDmO/AZrHlLtdzjet6ljMo7z16rGrjsSeO50WW3Oq0" +
                                                              "VzLanN12Osb3ud7jVLdkjcC8FUfWbqlRj5zgybhSkiFzWutMOM6lc2pZe/aU" +
                                                              "qb9+8qk5W18qIeEuUqHqUqJL4scCMg3qcWqNwEkwbVx4kahydmBtWsNVJXnK" +
                                                              "54OOHczewAt4ZwW/vyy34J0L1wK74F3grertuHJd4bhCPLVzOGApRirjXVJS" +
                                                              "Uccz/rpaHBmw5eDuFqtd7atuAcHrbW71PoLf6GyBr+bL6keNsmLoGupn42pB" +
                                                              "WW8qUtaZcDXY3Bp8ZN0bKKsfNSNT41dQZXiEFZLzllPAtNHm1Ogj5x2BcvpR" +
                                                              "I6ZQKBu6mTngeWXdX6Sss+FaaHNb6CPrRKCsftSMTIvjs1VTsgqi+u0iJUX/" +
                                                              "arJ5NflIenegpH7UjNTE+5mpj2KiUyQ/aO85BWgX2SwX+Qh8KFBgP2qEdrWZ" +
                                                              "9N1Y95+CwzbbvJp9JP1eoKR+1OiwMcrw/KObyUKyPlykrHjTYnNr8ZH1R4Gy" +
                                                              "+lEzOEL3Kgl8yFpI0EdPQdBWm1Wrj6BPBgrqR42Cbur2DVc/CRA07apmsgz5" +
                                                              "XxnxPCB2MXRlP4J5u8HvGT4/kx3YvW8ise7u5ZnjaQ+4K9ONs1Q6RlXXUpX8" +
                                                              "nmbFmIHLY8ZbYYuxwouao6hHg+xDJz/SgGLnaMDYq9j8nJGqYco8edfB+xcn" +
                                                              "c4z/pMLww2KlrdDK4rHwIw3Q952AsXex+Y3AwpPXHSzenCwsMEStshVaVTwW" +
                                                              "fqQB+v45YOwYNu+DXwMWrrrBweGDyfQJe03xWxwOfqQBup4IGPsUm4+FT3jq" +
                                                              "EgeLTyYLCwxTa2yF1hSPhR+pv76h8oCxCmxKIOEBFjl1TxaJUOlkIdEEV7et" +
                                                              "TnfxSPiRBmg7O2BsLjY1jNRhpChQVzmA1E6ma8RsrWLFA+JHGqB0c8BYKzYN" +
                                                              "wjVy6jYHicbJDBh9tjp9xSPhRxqgbTRgbDk2S0XAEHVhV6YudLBYNllYzINr" +
                                                              "g63QhuKx8CMN0HdVwNgF2JzHSAVg4a47HSBWTiYQm2xtNhUPhB9pgLI9AWOX" +
                                                              "YrNGAOGuax0gOicBiJoMEFtsbbYUD4QfaYCyGwPGNmFzGZT3TBff5/BZ8+B8" +
                                                              "6jwndg1wmvX/C2jSjJSJLx3wKeO8vA+pxMc/8gMT1eVzJy5/TbzwynygMz1G" +
                                                              "yodSqup+vu66LzNMOqRwMKeL538GFzzOSPPJP8BgZArLPBUPSYISOuuDKBkp" +
                                                              "xR83yQgjc31IQHVx454/Cph754Mo/Nc9D6grnHmwlLhxT9nOSAlMwVvTKGBQ" +
                                                              "8U4jHeJDC9yG4mjNPpl9XeeylpzHtfyrucxz85T4bm5QPjxxydqrj3/+bvEV" +
                                                              "gaxKO3fiKpUxMlV80MAXxWfvi3xXy6xV1r3kxIwHpy3OnPRqhcDOvlngODdh" +
                                                              "hIQMdK/5nlfsVmv2TfvrB1Y98bM9ZS+HSWgzCUmMzNyc//YnbaTgCLo5lv+a" +
                                                              "jpcZ4CxtS741fsGZQ395gz8HJ3lv1bzzB+WjB6985dZ5BxrDpLKHTIFDLE3z" +
                                                              "11JrxrX1VB4zB0iVYnWmQURYRZHUnHeAM3AnSLgtOS42nFXZXvwGBZw9//1n" +
                                                              "/pc7Faq+g5rtekpL4DJVMVLp9AjLeF5fpAzDQ+D02KbEtheb9jRaA/xxMNZr" +
                                                              "GJnXw5UzDR4G1majQ87bAnTc6/kt3n3t35wNHwBRKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17eezj2H2fZnZmdmavmV17vZv13jNOslYyFEWKErObxKIk" +
       "iqQoURIpimI3GfMSxZviIR7p1o6Bxm6DOka6Tl3U2T9ap22Mje0WSVq0TbFF" +
       "0RxIECCBe6RFY6dokbSOAS+Kpmnd1CWl3z3z+013d1oBfKL43vu+7+d7vS/f" +
       "e3rzm5WLYVCp+p6d6bYX3dTS6KZpN25Gma+FNym6MZaCUFM7thSGXPHslvLi" +
       "V67+ybc/s7p2vnJJrLxPcl0vkiLDc8OpFnr2RlPpytXDpz1bc8Koco02pY0E" +
       "xJFhA7QRRi/TlQePdI0qN+h9FoCCBaBgAdiyALQPWxWdHtbc2OmUPSQ3CteV" +
       "v1A5R1cu+UrJXlR54TgRXwokZ4/MeIugoHC5/M0XoLad06Dy/AH2HebbAH+2" +
       "Crz+13702t+/r3JVrFw1XLZkRymYiIpBxMpDjubIWhC2VVVTxcqjrqaprBYY" +
       "km3kW77FymOhobtSFAfagZDKh7GvBdsxDyX3kFJiC2Il8oIDeEtDs9X9XxeX" +
       "tqQXWD9wiHWHEC+fFwAfMArGgqWkaPtdLliGq0aV5072OMB4Y1A0KLre72jR" +
       "yjsY6oIrFQ8qj+10Z0uuDrBRYLh60fSiFxejRJWnTiVaytqXFEvStVtR5cmT" +
       "7ca7qqLVla0gyi5R5fGTzbaUCi09dUJLR/TzzdErn/4xl3DPb3lWNcUu+b9c" +
       "dHr2RKepttQCzVW0XceHPkz/jPSBX/nU+UqlaPz4ica7Nv/gz7/9ke979q1f" +
       "37X54B3aMLKpKdEt5QvyI7/zdOcl9L6Sjcu+Fxql8o8h35r/eK/m5dQvPO8D" +
       "BxTLypv7lW9Nf3Xx8S9q3zhfeYCsXFI8O3YKO3pU8RzfsLWgr7laIEWaSlau" +
       "aK7a2daTlfuLe9pwtd1TZrkMtYisXLC3jy5529+FiJYFiVJE9xf3hrv09u99" +
       "KVpt71O/UqncX1yVh4rruyq7z/Y7qrwKrDxHAyRFcg3XA8aBV+IPAc2N5EK2" +
       "K0AurN4CQi8OChMEvEAHpMIOVtp+xUbXNRdYFrIBIkm2tcIUXC/UbpZW5v8/" +
       "pp+W+K4l584Von/6pOPbhc8Qnq1qwS3l9Rjrvf2lW795/sAR9iQTVV4qhry5" +
       "G/LmdsibuyFvlkPe3A55czdk5dy57UjvL4feKbhQj1U4ehECH3qJ/RHqo596" +
       "8b7CsvzkQiHbsilweiTuHIYGchsAlcI+K299Lvlx/mO185Xzx0NqyW7x6IGy" +
       "+7gMhAcB78ZJV7oT3auf/KM/+fLPvOYdOtWxGL3n67f3LH31xZOCDTxFU4vo" +
       "d0j+w89Lv3TrV167cb5yoQgARdCLpMJIi3jy7Mkxjvnsy/vxr8RysQC89AJH" +
       "ssuq/aD1QLQKvOTwyVbjj2zvHy1kfKU04qvF9T17Vr39Lmvf55fl+3cWUirt" +
       "BIptfP1B1v/Zf/Pb/xnains/FF89MrmxWvTyEfcviV3dOvqjhzbABZpWtPv3" +
       "nxv/1c9+85N/bmsARYvrdxrwRll2CrcvVFiI+S/++vr3vvb7X/jq+UOjiYr5" +
       "L5ZtQ0kPQJ4vMV0+A2Qx2ncf8lOED7twsdJqbsxcx1ONpVFacWml/+vqh8Bf" +
       "+uNPX9vZgV082Tej77s7gcPn34VVPv6bP/rfn92SOaeU09ehzA6b7WLi+w4p" +
       "t4NAyko+0h//3Wf++q9JP1tE1yKihUaubYPUuQPH+dDpjrMlsgvnb/zt67/9" +
       "sTeu/0HBh1i5bIRFItAO9DvML0f6fOvNr33jdx9+5ktbW70gS+E2FDxwcmK+" +
       "fd49Np1u7eqhAxU9XWrk+YL1f7LT0O47qijvMfrJgaHqGoAVXLJKYPhRMV33" +
       "3I0ReK5T0NgPsv8/hkkLrbx0RmIZGE7hI5u9yRh47bGvWZ//o1/YTbQnZ+4T" +
       "jbVPvf6Xv3Pz06+fP5LeXL8twzjaZ5fibJXw8E4J3yk+54rrf5dXKfzywU4J" +
       "j3X25tnnDyZa3y/hvHAWW9sh8D/88mv/+O++9skdjMeOz+69Inn9hX/1Z791" +
       "83Nf/407TCwX5CzaGc/NY6Z9hhDx0gIPw+qT/5Ox5U/8hz/dEr9tNriDXE/0" +
       "F4E3P/9U54e+se1/GJbL3s+mt8+Yhfcc9q1/0flv51+89C/OV+4XK9eUvRyd" +
       "l+y4DHZi4R/hfuJe5PHH6o/nmLuE6uWDaefpk4o9MuzJCeFQoMV92Xrrqrs5" +
       "oCyg9FxlGwLxbY8XtuWNsvierbjPl7ffGxVEDVeyt/1+oAiwtubq0WrbGNk+" +
       "28XaV6LKfYXXl7d1Pz3Q3Pkdqe3vx6O9cFZCK7JWz9XKyLhft8sMDO/mwRtD" +
       "UZnewQY+fLoNDLdR5lARv/aJ//IU90Orj76DlOC5E4o9SfLnh2/+Rv+7lZ8+" +
       "X7nvQC23vU4c7/TycWU8EGjF+4/LHVPJMzuVbOW300dZfGgr4e3vDx9IorKV" +
       "RGXbVjyj7tWymBcKVEpR7zRzRvNb6e4bOKONVBbPhUcTp+M6OPKKekv5zFe/" +
       "9TD/rX/69m0ueDxPGEr+y4dm+XwZXJ44mSUSUrgq2sFvjV69Zr/17e2c9aCk" +
       "FAE5ZIIiS02PZRV7rS/e/2//2T//wEd/577KebzygO1JKi5tE7TKlSIz0sJV" +
       "keCm/g9/ZDftJGWWcG0LtXIb+J0dPrn9tQua7eMpxhPF9cG9FOODJ/OoPUcz" +
       "7+xolX3felDGJcews33LQHf5V1nKZWHtuNBO5fgOPD29x9PTp/C0vitPpTsu" +
       "2Siz78hT8A55el9xPbPH0zOn8JTehaf75blm6KvoTvxk70JGz+7x8+wp/Hzs" +
       "rjIqkgbfC/az3JM8ffwd8vR4cT23x9Nzp/D0E3fh6YpcrsoEUnhHKX3yHXJU" +
       "Ws/zexw9fwpHf+UuHF2T2SjwrHLByZBOE9Wn34WoXthj7IVTGHv9rqJqB86p" +
       "Bv7Zd2FQL+5x9OIpHP2NuxoUrUVlBl280t2Jp8+/Q57eX1zX93i6fgpPf/Mu" +
       "PF2Wh4ZaLp/ciaG/9S4YurHH0I1TGPr5uzIkEKeGgS/elaEtlfRc8c54sX6z" +
       "ebNW/v7KnYe8r7wtMqFL4Xa5s/xF7nPxhGkrN/ZzZF4LwsKwb5h2cz+ruXaY" +
       "8ewWDE8w+gP/14wW0+Ijh8Roz9Vf/sn/+Jnf+qnrXytmQ6pycVOmj8U8eGTE" +
       "UVwux/7Em5995sHXv/6T2xflIoXi/9Lfa369pPqPzoJbFr94DOpTJVR2+xpE" +
       "F3FluH231dQDtCfSwQtF1vHu0UaPvkXAIdne/9CgtBQmM3DKA3FirShy2mp1" +
       "LItkp1gX6TQXAW5MwBnbW43VSYclRwNspW4Wdp8jm8NW1upOw5DnHNCLlzM9" +
       "lXjUMZEp2A+xFm+iS65r1kkU1UaezM/XRSIeRdIS9Jpioq091FdlrYo2wzzO" +
       "wzzq2JwwZjZUvYVWkSYKNOPlcqmNcoYYGxRHU8PazAPxOr3CgpnhphvPqiED" +
       "qmvPs6ANTUaZuZyxNIpKAQT68JJyZl1xKJHiWBhY1ryJDzwnaBOs19fnVs6K" +
       "cyf0ORbD3ZoVSV6D4kZ9sM1Rciis2dU6IDvxhu+lE1emuGF/4PD9LsNrZDAl" +
       "3BCbrnyD7DkzNqXU5hSMjQbhhw4yZNCxG0siFPfERIzolcjhbA8NHXPmTnF8" +
       "PJN6WTrHNxI1DIfCtLbk3dncm1vzuiRpUm2UsFqujNuGRCB5tTrkNGvqMcks" +
       "pWoQ1wfl8XxWi4S0rhvT9VqFLISn1lDU6MQW1VusBXEoSgvQdnoSJk3ZhRhM" +
       "QdEjajw/pSkuqgV6kw7wqZN19AkJRxme96xZLZAyYJo68z6uOHKQezZWRwoL" +
       "tGh6jPGbeSqrakvlR5MqbzEeNluDHsAaTLdHJosu2dZHlOVSwRyx2A6li2Qw" +
       "kfvNteaQa3fARRtWFRdZ0LNCTJPHCTlQBwtGcgdaF1f1qdodccNoPAoIvwsN" +
       "iBBAFsO1SiZINyiZ9uqkgHr9Dt72BuIkpWF3BrLM2vc6s0WRozgZE4haZ8W0" +
       "1f6aDVc9NEP8mYV0umDbEmYsHzEjbxyslVGCTnzGNPRMWbWg2mwq1Rh2ivAr" +
       "xtM1RHQFChZ10JwwGEUmwyhsmlKrx/vBJhQLGayqkSAIOcivIdxYrKyujYlT" +
       "wQ4S1pjqwFQz/R43CZoTDGOEdN0UxCCvUnBCclgjcrTMGY9ROq0CyDDvk63q" +
       "gJmEgxy3BKgm2iNDXxpDFF7LDTNbWvagJzU8Phz0TZRQmk26GmfTKJhgvbnI" +
       "qNZMMfuTvomkQNXaCJClAF2KGRA26SB1b90RGrNBNaImYN/XOIJfd6zUifVV" +
       "DTHmCNM1x/PJGhoqM3MRaOps1MWdGerjnC3MZwiQtvS+R9q9ATmIca1GcmAu" +
       "11bhalR1uzOa5GmTVOkVQ1YHYyAfZBS3Nqi6PbMMflRbTj0XcUzAXsxIC1ZC" +
       "rE6lIRFMEWbumjSGSQzCTDM+aaN9qS/qMmEspKi3IlhmhuOKH5MDZ56zHcER" +
       "h62N74N9wDHtNukNAEh2Ex61MqhIaTyGNTdsk4cIF9VbhLviaX0q9yeL+YQM" +
       "SZiyVzQz7FCLqYi5K7rDdKiJgzMDVcxwb9EfJnlnFapkDNWoJSgIAQVy0JDS" +
       "KCn1UjZJJXfETB03ga2+M21XB1g1XqPrBjKAbA7mKWmRz1iOolnWc6yR4AzJ" +
       "iaOpnLZRx6ZFxoo96lqs7iyyWqr6ukOyBOInPGILWNWkNot8GMbgxBBXsCoN" +
       "q2uN1jcDjgQiSKCXqROMuxSVyZjYtfH2SmdHCBFyoeyBMRo3gUkczaDNeJnC" +
       "agQhM1jJelbgzLPFFLaQERGhyWQz9uisxgq+1RrjajDN69K04zoTrtmxKN1r" +
       "qATnr/wMnobgYKbgWJPNJdaC7XYfTrz6IvaaLtaMfVpoLVcSnHKcoqJ84hZB" +
       "ajpGaA8aDmVGGfi1BdCqm9isRQpVuN5cbgSj2gBMpa9l0+YsaC5VDoylwZxe" +
       "LYgFOooWTVk22/5KsDfNGGimTm0JyR2xmuVDqeP2QkyQu95qtugN2tWl70ZN" +
       "oIraIWF6C3Vc1yahPUrXRM7OWaG7xkcNnaLbTWFKEN4KHlgTHC1iTpYLCVfn" +
       "i0BUJ/rVeAkuYmEMDFynHvcIxJxYUN8c1qpVfTQC5mbcQDeFtB3XKmRh5bTO" +
       "iCFc6ymiyxjxZmSBPsHwpACoWZJrS0tDOqs2htVxqj5bNYQJ6qDNtRcrHAD6" +
       "VXIOoxMDnWf+chwQoLustiiMHCs1nHI3WV2uEVl1BlkWAAirjsJ7WDunIlQG" +
       "uKAPAjKq05BBkMMeaoxJfN7Q9U6v11CaoDOJ+EW1L03IEbFi+r2gOszGqA2R" +
       "iMw6g8U0ijCXaIp8O+mvZoXRrqVF7Is9XstrrTGqW4ls0mNpLBmwzKk514pJ" +
       "sJdBG50aDi2CxvVQp2Js7vFgUksTBAU0guYntXGrh7HGpivXGGWubWxQ6DUa" +
       "6RpkTaUm1GxxhVb13GanIcIR8lhp+vUs2EgaZDY9vDYo/GMMM0APz4FEj0bG" +
       "FOr4xExVA2hqd2pwt8006IkFk9okMzVkrUGbWr5Zxnje9GlFb1lVR1tyKooH" +
       "dsNFjUaR7EUZGyoQxxrKaqYZVq3JBopntGMXGQcmzNfHULAJMAPnhTk8AnWb" +
       "MMfREliyeDZuLse2ogPisp82rCRbrAs6SQAmVMfLZxBvVusRglideq5OWj7n" +
       "BCQ6FUK2aQhYgC/WzWjd5ky3mMMzxJvPFh0WxMnqhJ5RKMdsMG5NMWjT3dgb" +
       "vKVtGKFOzGizPY4aCCOji0ZNgoB6cwMN9ZZPgW1xhCBtzVhVEQWCCGzVyLVM" +
       "9ElIDJighetAbtQaaCYAeAzHWuYuOArURxyJru2Nh7DOECvmrTaSDi0VYzDX" +
       "MRlNm1ssBflS1Cmi0zjmDaQFCbIV8+EqC0AyUPGMbE1ACBsoTb3JU0VONZh3" +
       "tFG0GvYNw5B8dwCrLR8dRPNePTG0TTitCcumJw4WOGo2FSH2EgW3NsUEo6QM" +
       "GuuS22Zq5nxgsGFOOf5oukCtHGkn8+FK7bu04osagevL5qi+VKoxPJ7DS9nI" +
       "rCyUgJTqzywgaE26NDCDEgb1zCyvwuNGP4MXdd7vbWRzAoOyRslAkQAaDaNW" +
       "FeQEyhdIIzGC3FTYxnSOwAFP6bN8M5Kaphj1Jk0sYLVWW4xsiG62gCaTq0ZX" +
       "6RrkZJ3g5gZLuYQArRHNJQbc9evACAk5X5zTZozMEsnElTUDtRK0ivNYttRg" +
       "Yy5ZrKjJLRwAkUVDh4ZdhwHaYkDYdKTmphYhtjn0mjmIBP3ADFmNadTmc4hZ" +
       "1/icLhwQrDOhDMVq0+Rp1TKVTgufLefy2p6ajVzP5BVrGXg+j6MhM0RspV5I" +
       "DJBmaxmtttZWYw621qTWi2drYj1bUzQcKp2hDq2V+XqU9Apv5lPYklaZ6mDR" +
       "PBzxlOAOGjDDEEquJe0IFpM5sMkyCKZqNJgMmjAO6YEWRDFBqbC86oxpPmf6" +
       "bX9qBKbAU+xMUXIg8CUCc5KG1o3xdaQ2pShuK0Qgz5tgMZEskX6GBVWZRixt" +
       "FDq01499F6772HzeWs8iSVS6wgLC/JY4qsmDQbgcsSMOBtWJKBg9XKRz2x63" +
       "oxHhgIxuNtI6pmz8KYmIkwEWIw7n6tpcUAWEDcMqLknESEY642A66ITLiB1y" +
       "5MYMQZ4L9bVRjWsGNRMAKaAao6VNaq6m+0RzZo64XrXh+GZ9YMyyCSAxrQY2" +
       "14U6mwjVyao1wDF9XF/31GAuoiNwgTaqnSSX5Q3lo9QY1LzBtAoyRjJUggQY" +
       "MHI2G2RjO7MCwuQW7ihoiQQ4hftZ1e7lTI+GBrrdynCfrPXU8UTF5g44D0wE" +
       "G2N6sJ7C9Y4cB/UurwCdabvWlHwn1POGkLrpuIPViwTfHsNUI24Rmz4HA1YK" +
       "LTbzlhFqzbghuqY0qcIDlBmF4ASZ2oIw84WW68i4QxL0oiXKi0WcJl4seciK" +
       "0Ktpl8oBVu/TrjTsLtao2XKp/nqheC1NXWLVVHEVOAf8IZ0k9YEdqN0BHBAJ" +
       "mUATtFFvh4KWVhdQO/HHAsHmmttJwmGPjcIVL/FcMl+uJ1h1AzcWTLIYxdWu" +
       "kAznQRBgidbvZssJpdWgdJ4mTNku9mGyPw5nDlzFOchc93SN5rIF3UlSTqpn" +
       "OLhix6tp1d80kVXL66QdJx2QTA/DTRvkUomaMbZFqr0e39Qizl2m7NiYYo7e" +
       "ZOpYSJsL0BwVb1ed1YTPnTbYQxypNQ2DOY23qxTRX2M1pYUtBvlilJh8hpgL" +
       "wlBkqout0Mj00bQcOl3rMjfV5a5VZ2tCu0fwKx5ZxCqNLUa2vcjJUaAj0GQV" +
       "D9JWZziqESqfjHS8TuUE2+Z1WIKbBIvNOWMxceppNFrNxisM9XWaRNtzRlgE" +
       "o36b6cdSWtMZQ8EMyhv28CiU5cWsC0+W0qKT9ZNxf+TgeV/kIA5bLhsAJraq" +
       "WAsxE1fVwcTZCECnbrImxVJ0CiUDjWlt2lU/HSpASx9yoMbnVNYAODlPMjfT" +
       "hznYzzyVXcd+dRMjCJ2Phsx6mgwHGt2AWn08zxl2PKbGLUwX20Hx7jYbswuS" +
       "ZeK4O8AsP522oGyimwoEkhOiCCwNGOj4q2YDHnrASEG7iB64hJPY9CrlUJdh" +
       "2/Yw4TfcoI9NWjPYJDSq20GzPuyYo7Fvo4KmZbafE9EyC2IlzVsNDpadxmRs" +
       "pmmmrgMTAqrypsfrUjpgoKUx8Gfp0OZbtWFbSOfLjQGlQoakPBhAVkomhJ9B" +
       "jDuerldKl9nYrs501dWKnAzVAdBw7WXIO5s6tyzm/cKlW/IQFdkqwc71vDNz" +
       "hvkoUwBg4coSp3dor2FvqpLpKyLcSSO2CYPLsC9OILSh5y2CguwNKOc5Vp2b" +
       "GIK2GqrYwNKg69MDgiPxLt2DchCkgjQQQB6Dc6xm8At37kxm0+Llgpi5hNYe" +
       "Qm2XpfWIYeG6iwuisEn6mJigAAC6gK80cWld1RtBpFk+DXcpfsjTPto2aQ1v" +
       "LP123p1Uu7X6QO5FK01GzanUBtJ0OBKDPuUKSWOWd4sABDqSOWk15bbLKQhg" +
       "RZALRVAjGREJNh0k7e1Szq++syWmR7eraQdn8Uy7WVb88jtYRUqPbJ4drDlu" +
       "P5cqJ85vHVlzPLK7Uyn3n5457YjddmP7C594/Q2V+Tnw/N5i5A9GlSuR53+/" +
       "rW00+wipB7f33AEbj5Tky80heI8N+OTS");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("5yHQ20R2biuynaDO2KH7vTPq/l1ZfDWqPKxr0YmdpkPh/su7LdEdpXoawNYe" +
       "wNa9B/ifzqj7w7L4+g7giW2rQ4B/8F4Bliv8r+wBfOXeA3z7jLr/WhZ/XJhb" +
       "AfDIHtghuG/eC+3t9d1931twf3ZG3XfK4k932juxoXYI8H+8V4Cl63f3AHbv" +
       "OcBzV86oe7AsLkSVBwuAx3bnDuCdu/he4T1fXMQePOLew3v8jLonyuJaVHms" +
       "9L47bPUdonz0XiiR3kNJ33uUL5xRd70snt4p8di+4SG8Z+6FE4734I3vPbzv" +
       "P6MOKIvv3TnhbhMS39+EPAT40nsF+GRxcXsAuXsPED2j7uWygKPKAwXAozua" +
       "h+ga9wKdsIdOuPfoemfU9cviIzt0R7dHD9G13wO6a/voXt1D9+q9Rzc5o44t" +
       "CzqqXI68w83UXz7ENnwn2NKocml3Nr08aPvkbX992f1dQ/nSG1cvP/HG7F/v" +
       "jrzu/6XiCl25vIxt++gZuyP3l/xAWxpbrFd2R5v8LQAxqrx49yPzUeVitH8y" +
       "7txi1/NHosrTZ/WMKhfKr6NdPhpVnjilS7mXvb052l6JKtdOti9Y2X4fbbcs" +
       "zOuwXUFqd3O0iRFV7iualLfm7szZ8a3w3bnG9Ny26smjxrad5B+7mx6PpOrX" +
       "j51E2/7Paf/kXrz7p9Mt5ctvUKMfexv5ud1RdcWW8rykcpmu3L87Nb8lWp7+" +
       "e+FUavu0LhEvffuRr1z50H7y/8iO4UPDP8Lbc3c+F94rF5DLk9z5P3ziF1/5" +
       "O2/8/nZn/v8A+YYMwYA2AAA=");
}
