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
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1afZAUxRXv3fs+OO44BE44juPu0AJhN0SMWocfxwHe6R5c" +
                                                              "cYjmUI/Z2d67gdmZYab3bg+DiFURyqpQlqIxUflDMYkUivmwNB8iqXyo5VeB" +
                                                              "ViIaJWpSatAq+EMxUWPe657dmZ3dGWrJlVs1vbPT/fq933uv33vdswc+IRWW" +
                                                              "SdoMSUtIETZuUCvSj/f9kmnRRLcqWdY6eDok3/Hu3dtPv1azI0wqB8mUEcnq" +
                                                              "kyWLrlKomrAGyRxFs5ikydRaTWkCKfpNalFzVGKKrg2S6YrVmzJURVZYn56g" +
                                                              "OGC9ZMbIVIkxU4mnGe21J2BkboxLE+XSRLu8AzpjZLKsG+MOwaw8gm5XH45N" +
                                                              "OfwsRhpim6RRKZpmihqNKRbrzJjkAkNXx4dVnUVohkU2qRfZirg6dlGBGtqe" +
                                                              "qP/siztHGrgapkmapjMO0VpLLV0dpYkYqXeerlRpytpCbiFlMTLJNZiRjliW" +
                                                              "aRSYRoFpFq8zCqSvo1o61a1zOCw7U6Uho0CMzMufxJBMKWVP089lhhmqmY2d" +
                                                              "EwPa1hzarLk9EO+5ILrnhzc1/KKM1A+SekUbQHFkEIIBk0FQKE3FqWl1JRI0" +
                                                              "MUimamDwAWoqkqpsta3daCnDmsTS4AJZteDDtEFNztPRFVgSsJlpmelmDl6S" +
                                                              "O5X9qyKpSsOAdYaDVSBchc8BYK0CgplJCXzPJinfrGgJ7kf5FDmMHdfAACCt" +
                                                              "SlE2oudYlWsSPCCNwkVUSRuODoDzacMwtEIHFzS5r/lMiro2JHmzNEyHGGny" +
                                                              "jusXXTCqhisCSRiZ7h3GZwIrzfJYyWWfT1Yv232z1qOFSQhkTlBZRfknAVGL" +
                                                              "h2gtTVKTwjoQhJMXxu6VZjyzK0wIDJ7uGSzGPPW9U1cuajn8vBgzu8iYNfFN" +
                                                              "VGZD8r74lCPN3QsuLUMxqg3dUtD4ecj5Kuu3ezozBkSaGbkZsTOS7Ty89s/f" +
                                                              "vXU/PREmtb2kUtbVdAr8aKqspwxFpeZVVKOmxGiil9RQLdHN+3tJFdzHFI2K" +
                                                              "p2uSSYuyXlKu8keVOv8NKkrCFKiiWrhXtKSevTckNsLvMwYhpAouMhmuc4n4" +
                                                              "8G9GNkVH9BSNSrKkKZoe7Td1xI8G5TGHWnCfgF5Dj8bB/zcvXhK5OGrpaRMc" +
                                                              "Mqqbw1EJvGKEis6oNTo8TLVoEjQVZVJcpTiPbtEI+pzxjXLLIPZpY6EQmKXZ" +
                                                              "GxRUWE89upqg5pC8J7185anHh14UDoeLxNYaIwuAZUSwjHCWEcEygiwjnGVE" +
                                                              "sCShEOd0DrIWxgfTbYYgAFF48oKBG6/euKutDLzOGCsHvePQ8wqyUrcTLbIh" +
                                                              "fkg+cGTt6Vdfrt0fJmEIKHHISk5q6MhLDSKzmbpMExCb/JJENlBG/dNCUTnI" +
                                                              "4fvGdqzf/i0uhzva44QVEKiQvB9jdI5Fh3eVF5u3fueHnx28d5vurPe89JHN" +
                                                              "egWUGEbavHb1gh+SF7ZKTw49s60jTMohNkE8ZhKsHwh1LV4eeeGkMxuaEUs1" +
                                                              "AE7qZkpSsSsbT2vZiKmPOU+4w03l9+eAiWtwfdXDdb694Pg39s4wsJ0pHBR9" +
                                                              "xoOCh/7LBowH33jlowu5urNZot6V3gco63RFJpyskcegqY4LrjMphXFv39d/" +
                                                              "9z2f7NzA/Q9GtBdj2IFtN0QkMCGo+fvPbzl2/J19r4cdn2WQmtNxqHIyOZBh" +
                                                              "xFQdABL93JEHIpsK6x29puNaDbxSSSq4iHCRfFk/f8mTH+9uEH6gwpOsGy06" +
                                                              "8wTO83OXk1tfvOl0C58mJGNmdXTmDBPhepozc5dpSuMoR2bH0Tk/ek56EAI/" +
                                                              "BFtL2Up5/Azl1m2re91iuTeQjluM04sk8+tpH/3yhY1Vx0SS6Sg63JO73rv5" +
                                                              "xYf0v50IZ/NSMRIx8hqr79Xf9HwwxP2iGsMBPkdV1bkWepc57HLKhpy9mtE8" +
                                                              "rYDjd8Jc4puRLRMal+Omkhim0eUg3IBsKgaDImOlNqqYupaiEDjtZPDNM82A" +
                                                              "+eb7xz2XDff+pP2V7Xvb3wU3GiTVigWRE3RapHJx0Zw8cPzE0bo5j/NQU46m" +
                                                              "sc2SX/IVVnR5hRq3WD02l6K4xd2n31RSsOxHbfc5OOP0lj9WbV2B7oOUFwuD" +
                                                              "fw2fEFz/xQsNjQ+EwRu77dqjNVd8GAbyWxCwW8hnGt3WeHzzAx8+JnzWW5x5" +
                                                              "BtNde+74OrJ7j1jdooJtLygi3TSiihX+i00XSjcviAunWPXBwW2//dm2nUKq" +
                                                              "xvx6bCVsNx77y1cvRe77+wtF0n15fJwJo1yYt+JneG0gMFUuefDf229/Yw3Y" +
                                                              "u5dUpzVlS5r2JtyTgmmtdNy1QJ3imD9wo0PbMBJaiGYoFKG1oFjge1Mnz338" +
                                                              "1v3vP3v64SqBO8CKHrqm/6xR47e99zlXR0FaL2JYD/1g9MADs7ovP8HpnfyK" +
                                                              "1O2ZwsoL1pFD++39qU/DbZV/CpOqQdIg2/vA9ZKaxqw1CCvFym4OYa+Y15+/" +
                                                              "jxFFe2eufmj2epaLrTezu61VzvIsM1WswhDhuWw9pziPtwuwWcStE8bbxQwm" +
                                                              "VTRJ5XRdkClVqg2zET6423Zf/LqKkTJY/3h7ucvQYTEV/93E7LyE0GBnpGsU" +
                                                              "U1y2T1SYih7J7Uqhs5jLzCtwmT4eZhz9X3z0dNlbdzVNLiwtcbYWn8Jxob9v" +
                                                              "eRk8d9u/Zq27fGRjCTXjXI/DeKd8tO/AC1edJ98V5ltaYe6CrXA+UWe+kWtN" +
                                                              "Cnt3LX8RtglTc7sIO2OzkFuO/47mNEy4hkWg3RzQl8JmBBxDRhMKiwcMN7Ag" +
                                                              "mVu81FmZMhgvTrY+PfNXy3669x1elWWI1+r4sy/Dp1sawCqNTYflLtDzTek6" +
                                                              "pRmS73z9ZN36k4dOFUSI/Hq0TzI6nVUzH6P1TO9mqEeyRmDc0sOrb2hQD3/B" +
                                                              "k+skSYZMaK0xYTOWyate7dEVVW/+/g8zNh4pI+FVpFbVpcQqiW8ESA1U4NQa" +
                                                              "gX1cxrjiSlHRjGE12sChkgLwfB2bYrHM5s9q+X1/fkE7E67ZdkE721u129Hg" +
                                                              "luLRgHhq43DAVIxMiq+SUoo6nvXFK8WWANtRbLaL2cZ9wRURvNnm1uwj+O2O" +
                                                              "e+8olNWPGmXFgJMcYONqUVl3lijrNLjm2Nzm+Mj6g0BZ/agZqYpfR5XhEVZM" +
                                                              "zt1nodMWm1OLj5x7AuX0o0adQtFr6GZ2A+eV9Z4SZZ0O11yb21wfWe8PlNWP" +
                                                              "mpGaOJ6RmpJVVKsPlCgp+lerzavVR9KHAiX1o2akIT7ATH0zJi1F8lPtw2eh" +
                                                              "2nk2y3k+Aj8aKLAfNaq2y0z5Lqz9Z+GwbTavNh9JnwiU1I8aHTZGGe5edDNV" +
                                                              "TNaflygr3rTb3Np9ZH0qUFY/agab4z4lgYelxQR9+iwE7bBZdfgIeihQUD9q" +
                                                              "FPT6Ht9w9WyAoBlXpZJjyD+VxHPQ62Loyn4Es/Qcv7N4vp/ad9uevYk1jyzJ" +
                                                              "bi17wF2ZbixW6ShVXVNN4veJnBhTcHrMeEttMZZ6teYA9SDIHSr5kQaUNkcC" +
                                                              "+l7D5iVG6oYp8+RdR98vn8kxCusJP+SX2OJfUjpyP9IAdG8H9B3H5g2B3JPF" +
                                                              "HeTHJgY5hp9ltvjLSkfuRxqA7qOAvhPY/AN8FpC7agIH9T8nzt72DOK7NNR+" +
                                                              "pAHIPg3oO43NSWFvT4XhID81McgxvKywxV9ROnI/Un90oVBAXxk+/BISFSDP" +
                                                              "q1cc3F9NDO5WuHps4XtKx+1HGoCtLqAPDwxD1Yw04govUv3k4IdqJs7sMRtD" +
                                                              "rHT4fqQBEM8N6JuNzTnC7Hm1lIN7+sQt9H5b+P7ScfuRBmCbH9B3PjatYqGL" +
                                                              "ymxVtjJzkM+bGORNcK2zxV9XOnI/0gB0SwL6LsRmESO1gNxd5zmwF08c7Ott" +
                                                              "2a8vHbYfaQC0ywL6rsDmEgHbXTU6sC/9v2E3ZGHfYMt+Q+mw/UgDoPUG9F2D" +
                                                              "zQoolZku/rPCRzXBXs85KXV1cEWsLF0RGUYqxft8PIxrKvgrkfj7i/z43vrq" +
                                                              "mXuv/at40ZP9i8rkGKlOplXVfZ7suq80TJpUuOomi3Myg0Nbx0jbmf9mwEgF" +
                                                              "y54ChwYE5XWMNAdRMlKOX26SQUZm+pAAdHHjHn8jaNg7HkTh3+5xG8EjnXEw" +
                                                              "lbhxD5EZKYMheJswiphPnOFnRHLPbU+y1iRnDN+uHU173rEm/99Y9jQ5Lf45" +
                                                              "NiQf3Hv16ptPfecR8X5dVqWtW3GWSTFSJV7180nxRHqe72zZuSp7Fnwx5Yma" +
                                                              "+dk90lQhsLNKZrtqM5OQED/rneV5+Wx15N5BH9u37NDLuyqPhkloAwlJjEzb" +
                                                              "UPi2I2OkTTJ3Q6zYyyme/MFdOmvf3/jq52+GGvmBMREvBlqCKIbkuw+91Z80" +
                                                              "jB+HSU0vqYAtIM3wVzErxrW1VB418951Vcb1tJZ7tTkF14KEy5BrxlZoXe4p" +
                                                              "/j8D3L3wvV/hf1ZqVX2MmstxdpymznOGnzYMdy/XbAybrgxqGnxtKNZnGPYL" +
                                                              "z+o6rnnDwGUeGsMfff8D7AS4IhwqAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tUJ0JNx/fadPa8dbPYsgtk8Qu/sE/8s5");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("eX9UJN/cETy13HRE8A/fLcHiy/zL+wRfvvsE3zon778XyZ8AcwMEj61dHZH7" +
       "9t3Q3n7d3fnukvvzc/K+VyR/ttPeqYWwI4L/690SLIZ+Z59g564TvHD1nLwH" +
       "iuRSXHoAEDyxqnZI78K975bec+Cg9ulRd5/eY+fkPV4k1+PSo8Xou80S3RHL" +
       "R+6GEul9lvTdZ/n8OXk3iuSpnRJPrPcd0Xv6bgzC8T698d2n96Fz8qAi+cHd" +
       "INwtHpIHi4dHBF98twSfAMd0n+D07hPEz8l7qUiqcel+QPD4SuQRu9rdYLfY" +
       "Z7e4++yIc/K6RfKRHbvjy5pH7Jrvgt31A3Yf3Wf30bvPbnJOHlckdFy6EntH" +
       "i6C/csRt+Ha4ZXHp8m6/ebF59olb/uqy+3uG/JXXr115/PXZv91tYz34C8VV" +
       "unRFS2z7+N64Y9eX/VDVzC3Xq7stSf6WgBCXXrjzNvi4dG98sKPtwnJX88fi" +
       "0lPn1YxLl4rT8Sofi0uPn1GlWIPeXhwvL8el66fLAyjb8/FyGjCvo3Kgqd3F" +
       "8SJmXLoHFCkuV7u9YieXsHf7EbML26wnjhvbdpJ/9E56PBaq3zixg2z7v6aD" +
       "HXfJ7p9Nr8hffb3P/MRb9Z/fbT+XbTHPi1au0KX7djvht40Wu/aeP7O1g7Yu" +
       "Uy9+9+GvXf3AQfD/8A7wkeEfw/bs7fd6E44fb3dn5//48V96+e+//gfbFfX/" +
       "B8LfFrpwNgAA");
}
