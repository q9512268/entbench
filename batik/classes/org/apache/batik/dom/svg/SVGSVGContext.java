package org.apache.batik.dom.svg;
public interface SVGSVGContext extends org.apache.batik.dom.svg.SVGContext {
    java.util.List getIntersectionList(org.w3c.dom.svg.SVGRect svgRect, org.w3c.dom.Element end);
    java.util.List getEnclosureList(org.w3c.dom.svg.SVGRect rect, org.w3c.dom.Element end);
    boolean checkIntersection(org.w3c.dom.Element element, org.w3c.dom.svg.SVGRect rect);
    boolean checkEnclosure(org.w3c.dom.Element element, org.w3c.dom.svg.SVGRect rect);
    void deselectAll();
    int suspendRedraw(int max_wait_milliseconds);
    boolean unsuspendRedraw(int suspend_handle_id);
    void unsuspendRedrawAll();
    void forceRedraw();
    void pauseAnimations();
    void unpauseAnimations();
    boolean animationsPaused();
    float getCurrentTime();
    void setCurrentTime(float t);
    java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    long jlc$SourceLastModified$jl7 = 1471188908000L;
    java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVZe2wcxRmfO8fP+BUncUIeJjhOaBK4K6FQwJDiOHZy9OJc" +
                                          "7RCB83Dm9ubuNt7b3ezO2hdDKEWtSKsSUQjloRJVVSiEAkFVUctTaSvxENAK" +
                                          "SqFAeaggAW0RRLT0D6D0+2b2bvf27EMquSg73pv55vH95vt+3zez97xPam2L" +
                                          "dDGdR/g+k9mRAZ0nqGWzVL9GbXsr1I0pN9fQj3a9O3R+mNSNktYstTcr1GaD" +
                                          "KtNS9ihZquo2p7rC7CHGUtgjYTGbWROUq4Y+Suardixnaqqi8s1GiqHANmrF" +
                                          "yRzKuaUmHc5i7gCcLI3DSqJiJdG+YHNvnDQrhrnPE1/oE+/3taBkzpvL5qQ9" +
                                          "vodO0KjDVS0aV23em7fIGtPQ9mU0g0dYnkf2aOe4EFwSP6cMgu772z7+5Pps" +
                                          "u4BgLtV1gwv17GFmG9oES8VJm1c7oLGcvZdcRWriZLZPmJOeeGHSKEwahUkL" +
                                          "2npSsPoWpju5fkOowwsj1ZkKLoiT00oHMalFc+4wCbFmGKGBu7qLzqDtsqK2" +
                                          "UssyFW9aEz108672X9aQtlHSpuojuBwFFsFhklEAlOWSzLL7UimWGiVzdNjs" +
                                          "EWapVFOn3J3usNWMTrkD21+ABSsdk1liTg8r2EfQzXIUblhF9dLCoNxftWmN" +
                                          "ZkDXTk9XqeEg1oOCTSoszEpTsDu3y6xxVU9xcmqwR1HHnm+CAHStzzGeNYpT" +
                                          "zdIpVJAOaSIa1TPRETA9PQOitQYYoMXJohkHRaxNqozTDBtDiwzIJWQTSDUK" +
                                          "ILALJ/ODYmIk2KVFgV3y7c/7QxcevELfpIdJCNacYoqG658NnboCnYZZmlkM" +
                                          "/EB2bF4d/zHtfPRAmBAQnh8QljK/vvLExWd0HX9SyiyeRmZLcg9T+JhyJNn6" +
                                          "3JL+VefX4DIaTMNWcfNLNBdelnBbevMmMExncURsjBQajw8/fvnVd7N/hElT" +
                                          "jNQphubkwI7mKEbOVDVmbWQ6syhnqRhpZHqqX7THSD28x1Wdydot6bTNeIzM" +
                                          "0kRVnSF+A0RpGAIhaoJ3VU8bhXeT8qx4z5uEkHp4SAgei8h/PVhwcnk0a+RY" +
                                          "lCpUV3UjmrAM1N+OAuMkAdtsNAlWPx61DccCE4waViZKwQ6yzG1IGbmoPQGm" +
                                          "tG0j/HfdKIImZlZz8DxqNncyFALQlwRdXgNv2WRoKWaNKYec9QMn7ht7WpoT" +
                                          "uoCLCScrYb6InC8i5ovAfBGYL1IyHwmFxDTzcF65r7Ar4+DfQLDNq0Z2XrL7" +
                                          "QHcNGJQ5OQsxzQuHW1z4AR0D6xOufdGIeftf/vDe2WES9ligzUffI4z3+iwP" +
                                          "x+wQNjbHW8dWizGQe+2WxI03vX/tdrEIkFg+3YQ9WPaDxQGNAh1978m9L7/x" +
                                          "+pEXwsWF13CgXicJEYyTBpoE3qIK56SxSEBSsXmfw78QPP/FB3XECmlMHf2u" +
                                          "RS8rmrRp+uAIifeFnCyvBL2LO0K3dCaeEBx35JpDh1Nb7jhLenNHqe8NQGi5" +
                                          "98XPnonc8uZT02x+IzfMMzU2wTTf+lpxypIkYbOg0ELAHVNea73hrQd7MuvD" +
                                          "ZFacdABADtUw3PdZGQgkyrjLtc1JyBy8AL7MF8Ax87AMhaUgfswUyN1RGowJ" +
                                          "ZmE9J/N8IxTSCyTS1TMH9+DSn7jm74u2rsvuFhbnD9c4Wy1EGuyZwCBbDKan" +
                                          "BuAPDnl08z1PbVyp3BAW8QW5epq4VNqp178RMKnFIJDqqA7WtMCk3UF3DqI1" +
                                          "pqxeRh8Ye3R/j9iFRgiynAIpQvzqCk5eEiN6C56GUzUACGnDylENmwqQN/Gs" +
                                          "ZUx6NYJn5kjDBwNpRDtfAs8al0XFX2ztNLFcIHlJyHeJ8jQseoR1hfF1BRYr" +
                                          "hdhXwNpWes4MtK8BO+KO9Fyqw7araZUmNYY082nbirMe+OfBdmnIGtQUtuiM" +
                                          "Lx7Aqz9lPbn66V3/6RLDhBRMOzzC8cRkLJvrjdxnWXQfriP/neeX3voEvR2i" +
                                          "IkQiW51iIriEpX4F716A3j15tuJ36mEkfrd9rr8dk0iwbYFIv5BYJ8r1iKxL" +
                                          "ovg7hsUF0DkDURApyZaLxWWVui36x4gDBDZMJwVhjCk7Tm/v7Dn/o27JFF3T" +
                                          "yPoykIMPPzQ6enq7IoW7pxu4NPO4684G5dXc42/LDqdM00HKzb8ret22l/Y8" +
                                          "IzywASmiaPc+AgAq8dlee9H2WhGKDniOurZ3VJLuji8ZZKEbpNVqDjLB6FY1" +
                                          "x1LujhSCeFXHR5JfUMK43qb9Ylzr++C8n18kYT1tBqbz5B/81pvP3T517B7p" +
                                          "JAgvJ2tmOoiUn36QTlfMTKc+A/n3xguOv/fWtp1h1zRbsUjkC+bd6k8UpKde" +
                                          "VjTpkBsIIS0otRM59Ibvtz1yfUfNIDBbjDQ4urrXYbFUKWfW207SZzhewi0Z" +
                                          "VFiN4Jc8RmbIX1abJuLcM4NyvjPZmHL9Cx+2bPvwsRMCxNJDnT872UzNXsmN" +
                                          "WPSKbQzmR5uonQW5rx0f2tGuHf8ERhyFERUwEnuLBclZviSXcaVr61/57e87" +
                                          "dz9XQ8KDpEkzaGqQ4vEJkmCgZmZnIa/Lm9+4WLrAZAMU7YIjSBlrlFUgq506" +
                                          "PV8O5EwuGG7qNwt+deGdh18XeZHMXdaW0v8p8Kx1XXDtl6L/UrILe1IbsBgU" +
                                          "UrkKlChS/Syc+oESB3RFM2yIkgWT2yK67MJClVDQ/xM1rMgEoWjGtqXwnOdC" +
                                          "cV51oBgUeAipqQpQXImFw+FMlWXKuD8+2NNTeMICRuLqhOt3axO7lQM9ibcL" +
                                          "Lj0kHQg6r6pwfVI6RnR/xxvjP3n3XjfIlKUxJcLswKEffB45eEiSlTzSLy87" +
                                          "Vfv7yGO9371tPytOM4voMfjOsf0P37X/2oJmEU7qk4ahMaoHSQl/7sh7djNR" +
                                          "LbtZBM86127WVd1uflTBbm7E4ofA2cJuik6Etd/2gLiuCkCItk54NrhAbDiJ" +
                                          "QPhVPFyh7adY3MrJ7BSzGZJhnybPQ1e7FoZ/vsvJrAlDTXl43FYFPHAIMh+e" +
                                          "mItH7CTiEfIdP6/yqRZQs0Z1ryHLnEKMel8FJB/A4ignLbZjm0xPDbOURSex" +
                                          "8piH293VcqjF8Ay5uA2dfNyEGkLgeAUIfofFw5AnOHoZCD5neqRazoTRaMQF" +
                                          "YaRKzvRshbY/YvEkJx0B/cGnsOVnHgRPVZNPLnMhuKxKELxSoe2vWPyZi5O1" +
                                          "wrzt9+n+YrV0x6Cy09V9Z5V0f6dC23tY/A3M36SOzfrg1ONdr/j0f6ta+uO1" +
                                          "RNLVP1kl/f9Voe1jLD6AFMzRKyPwYbVYEBHIuAhkqoNAKFShrQYrP4V8nBZV" +
                                          "TyASqQADflYFAJqwbSE8mguAViUAWiu0YV4aaoRsCg4k/Y5lQd6NJ/4vCru1" +
                                          "aTjnzRB4i6iFmqrlOMsEUPLf3pOImqdHqEPAs6wCdN1YLAbo7BLoSl0ntORk" +
                                          "YJCHLKXkCweeixeWfTeV3/qU+w63NSw4fOlL4q61+D2uOU4a0o6m+a4l/FcU" +
                                          "dabF0qpApVleE5hCy9WcLJzp6h/SLyhx0aFVUvpMTuZNJw2SUPolvwpOF5QE" +
                                          "uxJ//XJnc9LkyXFSJ1/8IufC6CCCr183zbz098V+SIUPz/+infB9AFpecoQU" +
                                          "37ELx1En4V5eHTt8ydAVJ869Q34PUjQ6NYWjzI6TenlLLQatKbsI849WGKtu" +
                                          "06pPWu9vXFE48s2RC/ZMebGPtoEoQyZawKLAfa/dU7z2ffnIhY89e6DueTis" +
                                          "bichysnc7b6vyPKTaW/edCyydHu8/FprG7XERXTvqtv2rTsj/cGr4nKFyGuw" +
                                          "JTPLjykv3LnzTzcsPNIVJrNjpBZOsyw/SppUe8M+fZgpE9YoaVHtgTwsEUZR" +
                                          "qVZyZ9aKxkrxC7fAxYWzpViLHxY46S4/dJd/nWnSjElmrTccXXB5S5zM9mrk" +
                                          "zgS+azimGejg1bhbieV2yYS4G2B3Y/HNpln4nFb7kCkcdsf0xIgGukm84lvs" +
                                          "f6Zq7mDjIgAA");
    java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    long jlc$SourceLastModified$jl5 = 1471188908000L;
    java.lang.String jlc$ClassType$jl5 = ("H4sIAAAAAAAAALV6e6zk1nkf792VtLuStSvZlmTZ8kNeGZHHuRzOi5wqdcIZ" +
                                          "kjPkcDgccobzSJ01n0MOn8PHDIeu28RIG6dBHbeVGwew9U8cNDWUOEkbJEWb" +
                                          "QmnRxEHSAA6MtglQ2+g7DwNRgaRB3SQ95NzH3LvaaxirvVie5ZzznXO+3/c6" +
                                          "53yHr34TeigKoVLgO9uF48dHehofLZ36UbwN9OiIYeu8HEa61nbkKBqBujvq" +
                                          "8z9/88++9Wnz1iH08Bx6q+x5fizHlu9Fgh75zlrXWOjmWS3p6G4UQ7fYpbyW" +
                                          "4SS2HJi1ovglFnp0r2sM3WZPWIABCzBgAS5YgPEzKtDpLbqXuO28h+zF0Qr6" +
                                          "W9ABCz0cqDl7MfS+84MEcii7x8PwBQIwwrX8twRAFZ3TEHrvKfYd5rsAf6YE" +
                                          "v/wTP3DrF69AN+fQTcsTc3ZUwEQMJplDj7m6q+hhhGuars2hJzxd10Q9tGTH" +
                                          "ygq+59CTkbXw5DgJ9VMh5ZVJoIfFnGeSe0zNsYWJGvvhKTzD0h3t5NdDhiMv" +
                                          "ANanzrDuEFJ5PQB4wwKMhYas6iddrtqWp8XQey72OMV4uwcIQNdHXD02/dOp" +
                                          "rnoyqICe3OnOkb0FLMah5S0A6UN+AmaJoWfvOWgu60BWbXmh34mhZy7S8bsm" +
                                          "QHW9EETeJYbefpGsGAlo6dkLWtrTzze57/nUx7yud1jwrOmqk/N/DXR694VO" +
                                          "gm7ooe6p+q7jYx9k/7H81K9+8hCCAPHbLxDvaH75b77+fR9692tf3tG88w1o" +
                                          "BspSV+M76heUx7/yrvaLzSs5G9cCP7Jy5Z9DXpg/f9zyUhoAz3vqdMS88eik" +
                                          "8TXh12c/+EX9jw6hGzT0sOo7iQvs6AnVdwPL0cOO7umhHOsaDV3XPa1dtNPQ" +
                                          "I+CdtTx9VzswjEiPaeiqU1Q97Be/gYgMMEQuokfAu+UZ/sl7IMdm8Z4GEAQ9" +
                                          "Ah7oADwhtPu7nRcxNINN39VhWZU9y/NhPvRz/BGse7ECZGvCCrB6G478JAQm" +
                                          "CPvhApaBHZj6cYPmu3C0BqYkdcC/Yzc6yk0seJCDpzmyW5uDAyD0d110eQd4" +
                                          "S9d3ND28o76ctMjXf+7Obx2eusCxTGLoA2C+o918R8V8R2C+IzDf0bn5oIOD" +
                                          "Ypq35fPu9Aq0YgP/BpHvsRfFjzAf/eTzV4BBBZuruUzTwuGeKX5cAf1evHc0" +
                                          "pvJQQBfhTwXW+cz/HTjKJ/7Lnxe87gfUfMDDN/CAC/3n8Kufe7b94T8q+l8H" +
                                          "sSeWga0At373RT885zq5Q16UIQipZ+NWvuj+6eHzD/+7Q+iROXRLPY7Xkuwk" +
                                          "uqiDmHnDik6COIjp59rPx5udc7107Ncx9K6LfO1N+9JJcMzBP7SvO/CeU+fv" +
                                          "Nwo7eLygeeKvwN8BeP4yf3JN5BU7K3+yfexq7z31tSBIDw5i6KHKEXpUzvu/" +
                                          "L9fxRQHnDPx1Mfj8f/qdP6geQodnAfvm3hIIhPDSXpDIB7tZhIMnzkxmFOq5" +
                                          "sP7zZ/l/9Jlv/sj3F/YCKN7/RhPezsucY7DigZXj73x59Xtf/9oXvnp4amNX" +
                                          "YrBKJopjqeAlKhYwgMSwPNkpBPJ8DD29dNTbJ6glsKABxm4vHbQQ1dvBEl6w" +
                                          "lmvlaLcKFA4FOLp9D3PdW7nvqJ/+6p+8RfqTf/36XZZ6XjB9OXhpp6GCqxQM" +
                                          "//RFL+rKkQnoaq9xf+OW89q3wIhzMKIK4kE0CIELp+fEeEz90CO//2v/9qmP" +
                                          "fuUKdEhBNxxf1ig5X2RBqIxNsC6bwPvT4Hu/bxfqNtdAcavwTajA/84dO4Vb" +
                                          "P34mCNYHi+GP/bdP//aPv//rgA8Gemid2zDgYE9aXJLvD/7uq5957tGXv/Fj" +
                                          "hU5AYJV+9BfQb+SjYsUELxTld+VFaaex/PVDefHdeXF0oqZnczWJRfxj5Sju" +
                                          "+5oF9gdaoalLQwcfWi6wtvXx4gd//Mmv25/7Xz+7W9guxokLxPonX/57f3X0" +
                                          "qZcP97YT779rRd/vs9tSFEy/5VSV77tslqIH9T+/9PF/+TMf/5EdV0+eXxxJ" +
                                          "sPf72f/wF7999Nlv/OYbROerjn9ilHlZOZ42/6/+7RUb3/zhbi2i8ZM/Vprr" +
                                          "lY2aCq4xwAy+1Bp76pjWmaU5kFu9Wq9BDTcMYQ26821zwKio0G5hVcJtJkrC" +
                                          "xahS1bNBxdSIHjmJxV4kjodLxxcYSRItErcpaazGI1lcpySH98QVhevyYoFP" +
                                          "yoLAjspEgyiXKkpFWRsVlOyvEnGBVoN1vb7uNuvruFTN9KyJprzsVliN6GgC" +
                                          "vCjZTVfA52Vv1ZlkEtvsKNMoROhywDWN4bIqNwdVoeRyImfHsygeqSHSkYle" +
                                          "zIlNy5yvEr8SoGEbbXc743ixnI06ykQYjFe1WUlM5FCzUk9erSwsQjrWqotz" +
                                          "bkhthayXyGO3q9YtdNFWWbpKiCvGYrROadbl1h4xDM3Q40kE9skSXI3llp0F" +
                                          "a7a+GjbXvjYo95aEJJZlqVLVXdSgOzE/bLrj8qKszTzbqMgDvUZSG5FvqP1F" +
                                          "gqKVDC3V+SBKaq0FG0vIYrNG0A7ldpo+KWIS4yIq6rMddT3XVGESWnN2zrvM" +
                                          "QNc7XbFHbmRzbLMVLxAj3p8Ey6Ru2AN/s4mWyNzusb41Kpf9bl92KLVU27QV" +
                                          "MG6v00rQFZutCHDO6FXGUbSlJk2ZzJAy1kAr06Y8jJ2uGCT+MmltKCqiTNsh" +
                                          "cWcwETOWRceWO+lYUqZxy4icyIFEDbwqU00ibtIfhTZRQUp4S4w0G3Gs0QIL" +
                                          "K6QxzKb0WHFMqqmxbZ9LjXjicnObmI7s5nSlkwvEH7RHoh9lZDCKiKS6baSp" +
                                          "NG6mqrvaCEi367mlNt4V4yzr6NwsGGUaHUgMPpBFWkZGvECO8CY/HFjxcDbz" +
                                          "+1PGN+2uIKfcys9GRCsmrE1GM5PhSCTGPZrFWQYeEDOXtis9iVpI1S2qwugw" +
                                          "VfU1yRoBrTFtTlZn/qrTqGOcp/htbzafu47dh8lWRaFqGpx1Y4MXcLeFDz0T" +
                                          "GzrLHrxes2Q60crdaVPcWltdcOesumiOSoy5ZTivUWXYkqQb0xpBy6M+N1EN" +
                                          "juVamu54LUVf990+mQI/FKJlaygvNxhsrD1JQznYJJ3RkhsGZqLYGxp1e6Qy" +
                                          "kAjJVSbDRrQ1vZVgBvPuajVFR12RqGApMtG2mh83lBGn01m/bAuSJ1IlvCwE" +
                                          "HZw2ZZ+pSmNMMaf6CFultayekHY3qIn4QrcwE+Ylc6N6dlkuCTOnHYyl6njp" +
                                          "hngf4UoDPOnbuBZHHO5M+LSBEKraJmsbWbLmvc2wsc06CN1RXJ8fdty4U17C" +
                                          "XUPr0bQ7d+YZRqQrzlO3FM4OnY2gTRfcujIR/N5E5nozXW0O+x5qxugk8EeJ" +
                                          "32bbohrOlAbttTGr7q9xo9WZsQi97W5cKiVGmUo16iGKh7USYQxZgluV55Vp" +
                                          "yKLDrsp1mGF9MIzSbJh0J0hWwwUQetJBYmgdWjdiA14TemVCik3HWmRjw6Br" +
                                          "WbVkbfi0tBlyS6U7wbSJlXWGeqkySelydT2FYy0kaZtalKqzYXPCy0Q67HC4" +
                                          "iTRRzG2yKJyWAnK6iSYUUm0vppbKkLPtqBX4ZHVF9+oNMRVJ4BVT19ig2JDn" +
                                          "YapVnZJt1+l3jUoiiFjohkJQSnDaMnTKa2/XLbbCgmBS1dqyTrbSap0JCBPh" +
                                          "FHRpsrrHdVc6xg07Vr2JTXnP91QsmY/KlbREZ0a/n40rm9HIKDlBug1oe6YM" +
                                          "FmWSxbsSp8to1QyHGtpP1sQcbBU0vIUT8XhT5bV5Z7iwt+GSjVWE2ba2GM6i" +
                                          "fQrDUwzF+6Y8XhjRZrzlEKHjb5i5SzYZmMPodCS2tyMRGfW7zRIheujSRWtJ" +
                                          "JYzWCWUqHtFUa5MtQnaS7XzTbilET/ZaCc4TnlPGMoRXpG1QbeETbDip68Gq" +
                                          "JnGrAEExod/zKJohViscncT9tl0dU1ViRSPBKtUFE5vpVQFeNi1KWFhbD6eD" +
                                          "4Tpbte26Tlpco11vdMbZGG93PGLrkJy7WQ05uBPNx2mDmzFe3V4SrQ0XCERs" +
                                          "4BEmO+UpNa1kMcdSKt11mG1XZ7DlMNJ9ATENCmkJs9DUzCnoMtGjWj/uYa1B" +
                                          "qTdoUtvVBgVb0/nY5WazMlbxFCvs66WB0dLAubUTD8dxYvXZFMVXWdPhFa/R" +
                                          "kKpwQ2AJsyX0B1nWxlTBZpl1uNRSbzIdGqHFw56uT6trn1wLFYu2h9akjlh0" +
                                          "aJHBtEahSAOvLpF6nDDVhkvaRqg1wxDT7LK1UWYUva63ZgwWIlYvZf31AjWj" +
                                          "MVUmbGIs4MF2LrPpZCIlVrWR1hZEi5j3mY1kLts2OnLhNUp4sF9BGYqqjra8" +
                                          "v7XpPs9nw4burVDan6BBmtQ4flBrYLVOXZuqtQrMEiutXy53e5mChXpcqTjw" +
                                          "DKOz7QYXXUvm1RK+wFeY5uh6s1uZmJ0e4VmDJJxXJYZNlhY2n4OAFnDSiliy" +
                                          "rQY1Q1IE1JtiW6emXaHOGON+r1ZdKc2Zk4WlUhvzEMyejZC4tVKyegvGkGDN" +
                                          "V0d1BG2hAYMv1kwldge+NfaqjeHIMfqjHuAB9qrpIhmsYWMSB4iJZIISjZd2" +
                                          "u6RoDRsbBz1Nl5ajwG5FNC2W/Vjo15u0so4zZGuMDY4mWsqSGNaSMJzOFGrc" +
                                          "mxiTShkV55mpb6zyXKIsrsaomOAq9BSRFSZh1X6N266X/Nztss12CnY9/HoT" +
                                          "Cf12yjGEN8LQyjjjppHLTXixpwwzV6gnvgd8IEzLRiXuJF0DIwVzS5HCeAP2" +
                                          "h2xLdeZrS5yqshQ2ELiO6hiqZc3pEOsRAWlncmc1rK1Jxnbbi7k792gZZt1m" +
                                          "qTZhQ3yO98fojF6KLSd0qPFiVS83eAkb1MlN0umgK24TlzS9o5kINtXn3f5U" +
                                          "kyflNRZgvRSZTonYabDwOKRZHaGVqLUYj0O757RNERa3aglsU1pVgepXtrS9" +
                                          "mIwq214D7TNtRyKGcNpHwv6C9CfLTryabryB1lalOuKDMXTcClbDYDilXWpT" +
                                          "ovrOZNpLCKxU4biR3qfbQsKuzEFcldMB6gz7TUtRWXZZtrvDRSNsBBtDohuC" +
                                          "J8BpCqRc9arTpUE7vXHKqGy06ZGG0arlwUB0RpnIbjFUMtbotjNoVlEk5rfx" +
                                          "oF9b+31jOYiMMl9Fp3DFZ1xyjK7smgyOVX5XHDowGpmotuQEVonnrT7WQCro" +
                                          "RNKQxHBGLcVFyZpv4BWVSSy7QcYaXFmwVtK223Rs12tcaOIKYTFD3pR4amui" +
                                          "sjar9kMGbYlZZ86Y3lbhh4iOUv4cXkdrJsQdYjR1alVqRvFdnO6bJd2l4y7a" +
                                          "HlmkQWt8A96uhPkwKs+RcNtlPbLX1x2MYlowXrMWHqvMl2455QllMBZEPcUC" +
                                          "q1tpViV1tQQhfFtP8IpmcFuyY7MLHR/Thm9QmzruDbr+vE3UPX0lyJk/EuT+" +
                                          "kJrJQi9bC5GpzODZmrSZtNyC1Y4XDSSvuxB4ac7xrNc3k17aI9lU9PXKesJv" +
                                          "51Z9gGzCLG6WvNIslMppo70tN6XmvC6VjYbWrlTjGYxX+9WGOMiMcIEMOC2E" +
                                          "l6AtlkvJABE4VuIR24GNpuTryJIlGjjVz4Telt/MFGlGtrp0gpv2ygeHC0oE" +
                                          "69gs5GsS5rXm0miLi6shThjOjMKZ1UYRScxdJLhkjfGJlZRnUk2WfSFqL2o2" +
                                          "PKs7Q63BMXBt3Q4TRB4tvUxo1ayGRbmr0Bn0I3LMs0Y1GNDuSuuuSB6PGpu2" +
                                          "xiEzFld8tMX6olP24oFgz5h2l+1N7fZG161UnxgjHUT41bi0aVQ5cVMzBg5b" +
                                          "WzWQElFJBuOaXPYbbkmuOTCljjVZocqrAA8kRyfrZnvbnKgskwUNEwY2a6Zl" +
                                          "GZyn1kF/lMw5ZlMRx7zvrDfBgKoPySRlYHjKeGqTtbdTSmQQGKMTo91ot9sh" +
                                          "glUzJSs3Makk0mM+g0uWZ7SaOBXoqj8cV1GgNYT0alJd745ibKvhEoM1msNq" +
                                          "jR8vh2CNnCwzujHSPYdlh3LcUyIaqzUnnV6clBsBP0ma6ylF1rCoIrTheV9X" +
                                          "Onzsk/4QLDCbHosbMqyN0axiGB5tzrCm3iASfWRFiqWa28hTUaWx3vK9kTyB" +
                                          "da293WrdBIOpIOygU1KYjtareF0JR9ES2FxY83rUtpNsmBHPLrf2usp6Gdj9" +
                                          "RTxHS0zILYPWfBBtN7AYBGMd65eM+SIgmzNflrrxYrQBipwLK2m+nTflXmqH" +
                                          "aRs18HQ2yQLJYrvprNYQa7DGaLA38cQl6bjhSFWn01ZdrGf9phva2UIsyZnl" +
                                          "dvTlAlFMxdKlynYm1jqVVnUGd7nA8WoepaB221Y1EExSetFJbBerOevIaMxX" +
                                          "qEss6QWO58dx+jvLiDxRJK5O7zKWDpo3lL+DTEB62YQxdE1WojiU1TiGrp9e" +
                                          "ruxm38vcHpwkyt5/WZb4OEWcZ0Oeu9eVRpEJ+cInXn5FG/w0kmdC8oEJMHns" +
                                          "B9/t6Gvd2Zv2cTDSB++d9ekXNzpnmdnf+MQfPjv6sPnRIjV5V8aYhW7kPfn8" +
                                          "4uz0guw9F/i8OOQ/7b/6m50PqP/wELpymqe9667pfKeXzmdnb4AtURJ6o9Mc" +
                                          "bQg9f1eqyFd1LQn1s3k/+F75l+786sdvH0JX95PX+QjPXUgFP2r4oSs7+QQn" +
                                          "l1s3YjP0N2c1+3lhINbruWW8Czyl49uP4v+89a1BXr4tPbOvuwzn8NRShWMz" +
                                          "CaEPnKUk277j6Goh9dtjzy0yeLLi6Pn1wP+7+QLyS3/8qVu7/JYDak7U8KFv" +
                                          "P8BZ/Tta0A/+1g/8n3cXwxyo+XXhWZL1jGx3B/XWs5HxMJS3OR/pD/3ucz/5" +
                                          "G/Lnr0AHNHQ1sjK9uBQ63OE7MfWnc1PfVNV9CxfyC5vj9rfut+dXwboXFxIx" +
                                          "Cwq1KBeFO+5uQvLfRTr8Dui80GM6d7dox2zO1rkk4nljF+RN4UF31H8x/MZX" +
                                          "Pp996dWdDBU50mOodK/75buvuPPbjRfu7VF7N49/2vlrr/3Bf5U+cuKjj56a" +
                                          "T4Hm2mXmcyKix/fT2zttJ2dR66PfLn+5L7yi4vvPm/A7wFM55qFyXyZ8XmGH" +
                                          "Z1RWXtgF1d++RK0/lBdZDN0CaiU91fEj4M2FTvOG4G7RXcp2ckFQH7sPQT2W" +
                                          "Vz4HHux4RuzBCMoupFVQ/f1LBPXjefFJsK6BBUS19z2gIP/evdWsHUOPKL7v" +
                                          "6LJ3JoofvV9RPAueDx+L4sMPXBSfu0QUr+TFTwAnKURxajV57T84A/zZ+wBc" +
                                          "VD4FHuIYMPEmAt6H8jOXtH0xL34qhh7V9EjPQzPuOG+k66tr39LOcH/hPnDn" +
                                          "pNDbwUMf46bfRNwHexuiCxCuWMcrwC9fIo9/lRe/GENviZIo0D1N0LVQ3uSV" +
                                          "v3KG/p/dr5m/EzzcMXruzUdfsFsQ/PolUL+cF78WQzcT7y6weyb+b+7XxPPw" +
                                          "Jh6DFR+Qif/uJW1fzYt/H0NPXsAJLD1vefUM6u+8Gd48PYY6fUBQv3ZJW3Gr" +
                                          "+3txselU9TN17mH8/fvFmIfojxxj/MgDwviHl7T9cV78d2C2gZxEOu5Z7tkp" +
                                          "Yg/n/7hfnPkOXDnGqTwgnH92Sduf58XrYC1OvMuR/u/7jUY50sUx0sWDQXpw" +
                                          "eEnb1bzyL8D2TD6FyOeItQuR6C/vA+iNvPIZ8DjHQJ0HBPTxS9pu5cV1sKcA" +
                                          "+9B2EobgSDKyXP2NFitwhvTl+BT7wY37Nef3FnB3f6s3EfvZknPwZAHyuUsE" +
                                          "8J68eAYIIDongPMGffCO7wRrCtbqc5/A5cfKZ+76sHb3Maj6c6/cvPb0K+P/" +
                                          "WBzcTz/YvM5C14zEcfa/2tp7fzgIdWO3Y7y+O6sHBZoPxNAz90q4gO0GKHNu" +
                                          "D17YUb8YQ297I2pACcp9yg8BV7hICSyi+H+fDo6hG2d0MfTw7mWfpAJGByT5" +
                                          "azX/iKwQ3zP7ZlJ41pPfTuKnXfa/AsvPp8WHzifZmYQ/PgZ/6RWG+9jrjZ/e" +
                                          "fYWmOnKW5aNcY6FHdumQYtA8tfC+e452MtbD3Re/9fjPX3/h5KT7+I7hM5Pd" +
                                          "4+09b5yoIN0gLlIL2a88/c+/55+88rXiS6j/D2jbq4aBLgAA");
}
