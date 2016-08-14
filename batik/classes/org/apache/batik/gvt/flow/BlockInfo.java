package org.apache.batik.gvt.flow;
public class BlockInfo {
    public static final int ALIGN_START = 0;
    public static final int ALIGN_MIDDLE = 1;
    public static final int ALIGN_END = 2;
    public static final int ALIGN_FULL = 3;
    protected float top;
    protected float right;
    protected float bottom;
    protected float left;
    protected float indent;
    protected int alignment;
    protected float lineHeight;
    protected java.util.List fontList;
    protected java.util.Map fontAttrs;
    protected float ascent = -1;
    protected float descent = -1;
    protected boolean flowRegionBreak;
    public BlockInfo(float top, float right, float bottom, float left, float indent,
                     int alignment,
                     float lineHeight,
                     java.util.List fontList,
                     java.util.Map fontAttrs,
                     boolean flowRegionBreak) { super();
                                                this.top = top;
                                                this.right = right;
                                                this.bottom = bottom;
                                                this.left = left;
                                                this.indent = indent;
                                                this.alignment = alignment;
                                                this.lineHeight =
                                                  lineHeight;
                                                this.fontList = fontList;
                                                this.fontAttrs = fontAttrs;
                                                this.flowRegionBreak =
                                                  flowRegionBreak;
    }
    public BlockInfo(float margin, int alignment) { super();
                                                    setMargin(margin);
                                                    this.indent =
                                                      0;
                                                    this.alignment =
                                                      alignment;
                                                    this.flowRegionBreak =
                                                      false; }
    public void setMargin(float margin) { this.top = margin;
                                          this.right = margin;
                                          this.bottom = margin;
                                          this.left = margin; }
    public void initLineInfo(java.awt.font.FontRenderContext frc) {
        float fontSize =
          12;
        java.lang.Float fsFloat =
          (java.lang.Float)
            fontAttrs.
            get(
              java.awt.font.TextAttribute.
                SIZE);
        if (fsFloat !=
              null)
            fontSize =
              fsFloat.
                floatValue(
                  );
        java.util.Iterator i =
          fontList.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.gvt.font.GVTFont font =
              (org.apache.batik.gvt.font.GVTFont)
                i.
                next(
                  );
            org.apache.batik.gvt.font.GVTLineMetrics lm =
              font.
              getLineMetrics(
                "",
                frc);
            this.
              ascent =
              lm.
                getAscent(
                  );
            this.
              descent =
              lm.
                getDescent(
                  );
            break;
        }
        if (ascent ==
              -1) {
            ascent =
              fontSize *
                0.8F;
            descent =
              fontSize *
                0.2F;
        }
    }
    public float getTopMargin() { return top; }
    public float getRightMargin() { return right; }
    public float getBottomMargin() { return bottom; }
    public float getLeftMargin() { return left; }
    public float getIndent() { return indent; }
    public int getTextAlignment() { return alignment; }
    public float getLineHeight() { return lineHeight; }
    public java.util.List getFontList() { return fontList; }
    public java.util.Map getFontAttrs() { return fontAttrs; }
    public float getAscent() { return ascent; }
    public float getDescent() { return descent; }
    public boolean isFlowRegionBreak() { return flowRegionBreak; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVbDWwcxRWeOyeOY8e/IT8k2PlzAknIHQkJEEwBx7ET04tj" +
                                                              "7CQqTsCs9+bOi/d2N7tz9sUhNCBBQlsohfBTClHVhgZoIKjip7QFBVFaKBSJ" +
                                                              "n5Y/ASlUAgoUIgRUBdq+N7N3u7d3u/Tc2tKO1zPz5r33zZs3782sD31IJlom" +
                                                              "aaIai7AdBrUi7RrrlkyLxttUybI2QV2/fHOZ9MlF73atDpPyPlIzKFkbZMmi" +
                                                              "HQpV41YfaVQ0i0maTK0uSuNI0W1Si5rDElN0rY9MU6zOlKEqssI26HGKHbZI" +
                                                              "ZozUS4yZykCa0U57AEYaYyBJlEsSbfU2t8TIFFk3djjdZ7q6t7lasGfK4WUx" +
                                                              "Uhe7RBqWommmqNGYYrGWjEmWGrq6I6nqLEIzLHKJusqG4LzYqgII5t9X+9kX" +
                                                              "1w3WcQimSpqmM66e1UMtXR2m8RipdWrbVZqytpPLSFmMVLk6M9IcyzKNAtMo" +
                                                              "MM1q6/QC6auplk616Vwdlh2p3JBRIEbm5Q9iSKaUsofp5jLDCBXM1p0Tg7Zz" +
                                                              "c9oKLQtUvHFpdN/NF9X9oozU9pFaRetFcWQQggGTPgCUpgaoabXG4zTeR+o1" +
                                                              "mOxeaiqSqozaM91gKUlNYmmY/iwsWJk2qMl5OljBPIJuZlpmuplTL8ENyv5r" +
                                                              "YkKVkqDrdEdXoWEH1oOClQoIZiYksDubZMKQosUZmeOlyOnY/E3oAKSTUpQN" +
                                                              "6jlWEzQJKkiDMBFV0pLRXjA9LQldJ+pggCYjs3wHRawNSR6SkrQfLdLTr1s0" +
                                                              "Qa/JHAgkYWSatxsfCWZplmeWXPPzYddZ1+7U1mthEgKZ41RWUf4qIGryEPXQ" +
                                                              "BDUprANBOGVJ7CZp+iN7w4RA52mezqLPQ5ceO/fkpiNPij6zi/TZOHAJlVm/" +
                                                              "fGCg5rkT2havLkMxKgzdUnDy8zTnq6zbbmnJGOBhpudGxMZItvFIz+8u2H03" +
                                                              "fT9MKjtJuayr6RTYUb2spwxFpeY6qlFTYjTeSSZTLd7G2zvJJHiPKRoVtRsT" +
                                                              "CYuyTjJB5VXlOv8bIErAEAhRJbwrWkLPvhsSG+TvGYMQMgkeMgWe+UT88N+M" +
                                                              "bIkO6ikalWRJUzQ92m3qqL8VBY8zANgORgfA6oeilp42wQSjupmMSmAHg9Ru" +
                                                              "SA6zaELVR6JrVF0e6gT+EbQvY9xGzqBOU0dCIYD7BO9iV2GdrNfVODX75X3p" +
                                                              "Ne3H7u1/WhgSGr+NBiMLgFlEMItwZhFgFkFmkRwzEgpxHschUzGdMBlDsKzB" +
                                                              "r05Z3HvheRfvnV8GdmSMTAAkw9B1ft7+0uas/azD7pcPN1SPzntj+eNhMiFG" +
                                                              "GiSZpSUVt4tWMwmOSB6y1+qUAdh5nA1grmsDwJ3L1GUaB//jtxHYo1Tow9TE" +
                                                              "ekaOc42Q3Z5wIUb9N4ei8pMjt4xcvuXbp4RJON/nI8uJ4K6QvBs9dc4jN3vX" +
                                                              "erFxa/e8+9nhm3bpzqrP20Sye18BJeow32sFXnj65SVzpQf6H9nVzGGfDF6Z" +
                                                              "SbCKwOE1eXnkOZWWrINGXSpA4YRupiQVm7IYV7JBUx9xarh51vP348AsqnCV" +
                                                              "4cuZ9rLjv7F1uoHlDGHOaGceLfgG8I1e4/aXn33vVA53dq+odW3yvZS1uPwT" +
                                                              "DtbAPVG9Y7abTEqh3+u3dN9w44d7tnKbhR4LijFsxrIN/BJMIcB85ZPbX3nz" +
                                                              "jQMvhnN2HmKwQacHIM7J5JTEelIZoCRwW+TIA/5NBU+AVtO8WQP7VBKKNKBS" +
                                                              "XFhf1i5c/sAH19YJO1ChJmtGJ3/9AE798WvI7qcv+ryJDxOScX91MHO6Cac9" +
                                                              "1Rm51TSlHShH5vLnG3/4e+l2cP/gci1llHIvWskxqMxf67ieetMDFqxLJQXT" +
                                                              "MGxvSCu6L5b3Nnf/VWw2xxchEP2m3Rm9ZstLlzzDJ7kCVz7Wo97VrnUNHsJl" +
                                                              "YXUC/H/DTwief+GDoGOFcOwNbfbuMje3vRhGBiRfHBAP5isQ3dXw5tBt794j" +
                                                              "FPBuv57OdO++7/w7cu0+MXMiRllQECa4aUScItTBYjVKNy+IC6foeOfwrl/f" +
                                                              "uWuPkKohf8dth4Dynj9/9UzklqNPFXH8sIR0SUSaK9GYhUnj6sufHaHS2qtr" +
                                                              "f3NdQ1kHeI1OUpHWlO1p2hl3jwlBlpUecE2XE/3wCrdyODWMhJbALGDFGZ6C" +
                                                              "C3WajQP+anG9n8NImaIVCI5/tovRQIfGIhbWI43w2Kpf3nZi3fTm1Z/Mtyez" +
                                                              "SF9XEHbtr3/V13dinSw6F7N1T/B158EK+bXU77itozyn55xDDZpjAzx32c7h" +
                                                              "LmGf2/7H8ADIIBsA44A4dpOSonHMRlBQO/wY1/HRUmfk7fYO0D8fUls/OuNn" +
                                                              "3xDYzfNZbU7/h88/+tzto4cPCXPF5c/IUr/8qTBpwx1wYcAu7kzqp+vOPPLe" +
                                                              "21suzM5RDRbdwsBmMlLjDnSE3/1WcYPjtbH8Ga6H56g9w0ez7v987v57BEEv" +
                                                              "Ftty7Koddhsk3u+iAG4BC2PSgK6rVNKKU3NNV/G2U3I9CO8hUEhisdByxyn5" +
                                                              "ILpS1n75uhc/rt7y8aPH+GTl57zubRk0Eo6tHotF3Fy8ceR6yRqEfiuPdG2r" +
                                                              "U498ASP2wYgyGKO10YQINpO3idu9J0569bHHp1/8XBkJd5BKcGbxDonHQ2Qy" +
                                                              "BCLUGoTgN2Occ66YiJEKKOq4qqRA+YIK3AvnFN9l21MG4/vi6C9n3H/Wwf1v" +
                                                              "8IDA4EM0FgY7XbYhdBUPdrA8EYulhSGEH6lnBsMi6M65z3V86JGAed6BhQiN" +
                                                              "eVpkCQCGxogVVmw3RMNsXlmHCUmeT+BHR04QevcLp//p4A9uGhGOIWAb9tDN" +
                                                              "/OdGdeCKt/5RYHM85i6yM3vo+6KHbpvVdvb7nN4JfpG6OVOYREEC4dCuuDv1" +
                                                              "aXh++RNhMqmP1Mn2Uc0WSU1jSNlHKhUre34TI9V57flHDSKvbskF9yd4QwMX" +
                                                              "W2/Y7d5vJ7C8vdWJtGfivCyDZ4FtQQu8xsfTObGkUKRIp8ZokpoNb/34wOeX" +
                                                              "7zkjjKHexGEUHVCpc/p1pfFE6KpDNzZW7Tv6XW752aGvFLbMyyVYLOOmUIav" +
                                                              "EYiULX64hHGHokmqJ2KeESAsI1Wtsc51Xf29m1p7NnELd9YOt9+rvs5+v10I" +
                                                              "TbPNrbkINPiyJ+s3rw/SC4vvYXFNEYX8WDAyRSi0oXPt2lh7MY1uGINGC212" +
                                                              "CwM04l7iR2PWyI8FI5OFRu1da4upc9sY1Flk81oUoA4X+cCY1fFjwUilUKdj" +
                                                              "cyxWTJ87/nt9eEQwC56TbGYnFehD+Ms9xdWAJHOyYeoMPAaNe3SoDhgWomSm" +
                                                              "G7lNwSX8vSUKfwI8i20ui32Ef9DZyO4rlNGPGpyBqSQHWTEpHypRykZ4lth8" +
                                                              "lvhI+UiglH7U4LsGdMb0VDExHy1RzNnwLLUZLfUR87eBYvpRMzJBpYmiWD4x" +
                                                              "BiyX2WyW+Qj5dKCQftSAJaStEBkUE/OZEsWcC0/UZhT1EfP5QDH9qGHNSaqS" +
                                                              "1FK2pN71/0KJks6DZ7nNa7mPpK8ESupHDa4KD8HXU7919GqJos6BZ4XNbIWP" +
                                                              "qEcDRfWjZqQiAQFXNqHa6BH0L2OY/VNtVqf6CPpOoKB+1DD7KCjeRnKirR5J" +
                                                              "3x2DpCttXit9JP17oKR+1LCcJEv2WU4fjcFIV9mMVvmI+WmgmH7UkJjGqa+c" +
                                                              "n5UoJ+7Wp9ucTveR88tAOf2oIXHFi48emoSUYo1JJX4HIXnk/SpA3kyxhI7/" +
                                                              "lBPPfZOLrytzIpgfN/pdCfJDvwNX7Nsf33jH8uzZxblgr7DVL1PpMFVdQ9Xk" +
                                                              "n4NBEraBX4I6Gc3rNde//XBzck0pNzBY1/Q1dyz49xxIHJb453VeUX5/xd9m" +
                                                              "bTp78OISLlPmeFDyDnnXhkNPrVskXx/mN74i1Sq4Kc4naslPsCpNytKmln+E" +
                                                              "uSA/xz8Rns32vG72WqNjOX45vh+pJ3t3neOcgaOGpvqn96FpWNSAVViUbZDM" +
                                                              "pCJQ9JwVTRjWlXjOqkO1/48zAKwPVeYDhN51m63lttIB8iMtDhD/eyazz26k" +
                                                              "ERZBTx7pgKKHQuBh2h83cJwWBGCI4oSaIFNTNIXxm2dxnRya4UA2Zxwgm4pt" +
                                                              "uAcbtt65/Pq/h8yPNEDdFQFtK7FYBlAkKdukG8KiuCU6UETGC4p5XAXxs710" +
                                                              "KPxIA9Q9J6CtFYszGakBKHow4ioKRst4gYH7hmlrZJYOhh9pgMKxgLYuLNbB" +
                                                              "nglgrOEJUlE01o8XGnPhsWyVrNLR8CMN0PiCgDYMEkObGKkGNGKQhxXFYvN4" +
                                                              "YYE5etpWKF06Fn6kAfomAtq4rhJsQIBFp5PuOTgMjBcOeHY4YiszUjoOfqQB" +
                                                              "uloBbWksNEbq0HPCrtOal1M6cOjjuURGbZ1GS4fDjzRA5d0BbVdgsdNeIvlJ" +
                                                              "q4PFpeOFRRM8O22FdpaOhR9pgL7XBLR9H4u9jFQBFh3urNhB4urxDC8utdW5" +
                                                              "tHQk/EgDtL01oO02LG4U4UVHXtrtQHHTePrNXbY+u0qHwo80QN2DAW13YfET" +
                                                              "4TdbnXzZweGn44UDnvhdZitzWek4+JEG6Hp/QNuDWBxmpBJwWEuLAXHfeAGB" +
                                                              "dzW7bW12lw6EH2mAso8FtD2OxW8YqVesjiIHEw4ej/xfbnDB8nLffOIN+MyC" +
                                                              "D8jFR8/yvftrK2bs3/wSPzjIfZg8JUYqEmlVdV9Rut7LDZMmFA7iFHFhyb/+" +
                                                              "CT3NyPG+H6FCnoq/+FT9QfR/lpHjivVnpAxKd8/nYOv19mRkIv/t7vcimJrT" +
                                                              "Dw/V+Iu7y0swOnTB15fFXT9kma6LUXGnmxEJ6Gw30PzMaNrXzY/r9GdB3qkJ" +
                                                              "/9Q/e8KR7rY/lDm8/7yuncdOu0N8DCmr0ugojlIVI5PEd5l80LKCj27co2XH" +
                                                              "Kl+/+Iua+yYvzJ4n1QuBHWOf7VgkJlIhA21jludLQas598HgKwfOevSPe8uf" +
                                                              "D5PQVoJx4NSthbffGSNtksatscKPzbZIJv+EsWXxrTvOPjnx0WvZa+ZQ/lcF" +
                                                              "3v798osHL3zh+pkHmsKkqpNMxIuGDL+WX7tD66HysNlHqhWrPQMiwiiKpOZ9" +
                                                              "yVaDZizhPwFwXGw4q3O1+CktI/MLP+Mr/AC5EiyWmmv0tBbHYapjpMqpETPj" +
                                                              "OWhKG4aHwKmxpxJLfrm6OoOzAfbYH9tgGNmvHMtvN/gybs+tbu+HcaH3+Su+" +
                                                              "ffAfAv4QTwY0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ypJbB3ilK1YpYgQjqkUP0IEx9cfZZG2y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PooqlL+yjYmTZCNzgZZbNFvnQqgrptSI3HghCSaeTtvEmLNMgiWNbIRNR3DV" +
       "XddpruoRcYAzCVWVNiNcXQ7NeO7wHL1GzTm0saY+ReJ+27IkHpzotk0KnzM9" +
       "HNqurCQSqtMYgdbgEDTnrckMbynqkvbcoTEEB7gEa1OTjscQmMNwjL2dQuXm" +
       "ABG3Mlvm6kzTD5ZQmRk0ulYPckNu7qyGfkhsBAOHfFVawQ2vt+BXUIKtdMdr" +
       "RQNqDQ3LfIptK/Fa8gdgM2cx40Fj4Wn1tgI0xdvQrTq7Ripy1tHEaJypUNRg" +
       "DRJZLlpQowtOR0IPi1TIpTwcwraprxtSWhFxqulFlXQWzF1+yNdk2qi5eKUN" +
       "rF0V04PqmBPcMgTG1cpbdZW1UB8Gi4kbSRY2nC1aLm8TVXjupka7q8W1Bs7N" +
       "hLUlmau+bOKpRdXk7jBobVCxn9hTy2L7YrKINeA/BTmbTvjWqgzM+3gTDcA+" +
       "cO5vKqPVRCtPupCrM8gKnEWCmGsjGbAUC86LhcUyFDsbPmWpdnk0xhKqXue2" +
       "MdhDLO1RJHc7ztpxhFCaNLZDjZo4mS2vmfWYXaNLRILLzUXCQ522XO5EENGs" +
       "0c525HmrSkJOOVUL52FnGdIDeS6NbIFFNW4teJtw02pbkVeXAikjrKnKNZIZ" +
       "K3orrpOsRGi2ncblZJqWOV3jkHI/LVsWYRErtDtYqxWCIN6TP0L8wc092nyw" +
       "eFR7GCQ9d7G84I9v4unlruhElErxubN0IrD22IPtoubDB9ExUemtZ8U+F5Fh" +
       "n//wC581pC/AB4FRWFK6JwnCd7rmynSPdXU/6OmZsyNOOkXo91HYx9c//D8e" +
       "GfyY/b6bCDV97ATOk13+w86Lv8e+Xf/Fi6XbDoNArgtKv7bRs9eGflyKzCSN" +
       "/ME1ASBvPZRsETqUB28pe8kqp/2D88A5/xe8Yzf3RdlRBNCFowpIXuHCfScq" +
       "HAsRupBHWl24C0xCDI7cWjRz/FOfg68CxzhUogt330wcUZ5x4fZrWef/Vb13" +
       "z/q9t5T1wR8TjxX/JWjr5Gr+B9pVBiQ90zfMaP8mREH+zecI5rE8eUNSus/x" +
       "naQIU9/Fnl84WkwX3vgq5PDaPDP/yzPcyyG8NXI4zuHpc8rKeXIF8JuZySAI" +
       "d3Nf6MwRv6deLb8nCkq7z/LW86udU5ZbvwuVpHQ/4NfL/6I+lSH8ahnm1jDa" +
       "M4xuPUPinLJmnrw7KV0GDMkitONUiu95tRQfB1e8pxjfeoqdc8qkPOGS0msA" +
       "xbZpnT6H/KslmAf9pHuC6a0neE6E5oU8QvPCAJhfQJA/Cjw5IndTIZunkcuj" +
       "Ctd7cutbT848pyz/5/TC+5LSA7mJATaXuCaK5Yijdis0NNtzzG49x+U5ZQUc" +
       "d6+h14bDHBH0Xi3BR8H1/j3B9996gs+fU/YzebJJSvcCgszpcTWFS7/8chB3" +
       "cTVHQtneCuf5gf2IH7j1QvnYOWW/kCc/u3OezBkBOoVU7n85jLsAnSOpfORW" +
       "GLPn9yM+f+ul8ulzyv5OnrywM2bEUVDNEblPvlpyeZTfT+/J/fStJ/eFc8q+" +
       "mCefS0qXADnKPI3d33u17PJQ6A/u2X3w1rP7tXPK/nGevAgOkU7MnBJ6dETy" +
       "Szf1CgHQhcMXDvO3px6+7u3l3Ru3+pc/e/nuN35W+ffFO3eHb8Xe0y7dbaWu" +
       "ezyc/tj9nWFkWk7B+55dcH1YkPlnSelNZ74BCQ4z+Vch/9/Y1f9aUnrdafWT" +
       "0m0gPV7zJeDMTtZMSncU38fr/RbQk6N6eeBbcXO8yu+A3kGV/PbrYSG5a8Op" +
       "du8fbHYHmoePac3uHP/Qy83DsRP5k9eco4v3zA/OvKm8fzPqK59tie//fv0L" +
       "u5cHdVfLsryXu9ulu3bvMRad5ufmJ87s7aCvO7mnf3j/r97z1MEZ//4d4CMN" +
       "PobtsdPf1KO9MCnercv+6Rt//d1f/OwfFW8x/D+E8mytAEAAAA==");
}
