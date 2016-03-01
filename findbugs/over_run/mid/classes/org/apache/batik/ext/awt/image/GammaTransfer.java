package org.apache.batik.ext.awt.image;
public class GammaTransfer implements org.apache.batik.ext.awt.image.TransferFunction {
    public byte[] lutData;
    public float amplitude;
    public float exponent;
    public float offset;
    public GammaTransfer(float amplitude, float exponent, float offset) {
        super(
          );
        this.
          amplitude =
          amplitude;
        this.
          exponent =
          exponent;
        this.
          offset =
          offset;
    }
    private void buildLutData() { lutData = (new byte[256]);
                                  int j;
                                  int v;
                                  for (j = 0; j <= 255; j++) { v = (int) java.lang.Math.
                                                                     round(
                                                                       255 *
                                                                         (amplitude *
                                                                            java.lang.Math.
                                                                            pow(
                                                                              j /
                                                                                255.0F,
                                                                              exponent) +
                                                                            offset));
                                                               if (v >
                                                                     255) {
                                                                   v =
                                                                     (byte)
                                                                       255;
                                                               }
                                                               else
                                                                   if (v <
                                                                         0) {
                                                                       v =
                                                                         (byte)
                                                                           0;
                                                                   }
                                                               lutData[j] =
                                                                 (byte)
                                                                   (v &
                                                                      255);
                                  } }
    public byte[] getLookupTable() { buildLutData(
                                       );
                                     return lutData;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yUOSyN4XWLPif0IpIwR7HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aa+wjV3Wf3U12N0uS3SSQpCHvbGgTw38e9vihUMBje+yx" +
       "x2OPx2N7pi3JPD3vGc/DHpumPCQKKhJFbUKDBKt+gBZQIKgqfajQpq14CYQE" +
       "Qn2pJbSqVFqKRD6UVqUtvTP+v/eRRK2wNNfX955zzzn3nPu7Z+71s9+Hro9C" +
       "qBD4znru+PGOlsY7loPvxOtAi3a6ND6UwkhTG44URWPQ9rjy4GfO//BHHzAu" +
       "nIROi9Btkuf5sRSbvheNtMh3lppKQ+cPWluO5kYxdIG2pKUEJ7HpwLQZxY/R" +
       "0KsOscbQRXpPBRioAAMV4FwFuH5ABZhu0rzEbWQckhdHC+iXoBM0dDpQMvVi" +
       "6IGjgwRSKLm7wwxzC8AIZ7PfE2BUzpyG0P37tm9tvszgpwvwU7/x1gu/cwo6" +
       "L0LnTY/L1FGAEjEQIkI3upora2FUV1VNFaFbPE1TOS00Jcfc5HqL0K2ROfek" +
       "OAm1/UnKGpNAC3OZBzN3o5LZFiZK7If75umm5qh7v67XHWkObL39wNathWTW" +
       "Dgw8ZwLFQl1StD2W62zTU2PovuMc+zZe7AECwHrG1WLD3xd1nSeBBujWre8c" +
       "yZvDXBya3hyQXu8nQEoM3XXVQbO5DiTFluba4zF053G64bYLUN2QT0TGEkOv" +
       "OU6WjwS8dNcxLx3yz/eZN77/bV7HO5nrrGqKk+l/FjDde4xppOlaqHmKtmW8" +
       "8VH6g9Ltn3/vSQgCxK85Rryl+f1ffPEtr7/3+S9vaV57BZqBbGlK/LjyUfnm" +
       "b9zdeKR2KlPjbOBHZub8I5bn4T/c7XksDcDKu31/xKxzZ6/z+dEXhXd8Uvve" +
       "SegcBZ1WfCdxQRzdovhuYDpa2NY8LZRiTaWgGzRPbeT9FHQG1GnT07atA12P" +
       "tJiCrnPyptN+/htMkQ6GyKboDKibnu7v1QMpNvJ6GkAQdAY8UBk890PbT/4d" +
       "Qy5s+K4GS4rkmZ4PD0M/sz9zqKdKcKxFoK6C3sCHZRD/9hvQnQoc+UkIAhL2" +
       "wzksgagwtG1nvk6lVQybLggGuC25rjQOJS8CjtrJwi74SQtMsxm4sDpxAjjn" +
       "7uPQ4IBV1fEdVQsfV55KiNaLn378qyf3l8ru3MXQ64HUna3UnVxqDqtA6k4u" +
       "deeIVOjEiVzYqzPp2ygAPrQBGgCcvPER7he6T7z3wVMg/ILVdcABGSl8dbhu" +
       "HOAHlaOkAoIYev6Z1Tsnb0dOQieP4m6mMWg6l7EPM7TcR8WLx9fblcY9/57v" +
       "/vC5Dz7pH6y8I0C+CwiXc2YL+sHjcxv6iqYCiDwY/tH7pc8+/vknL56ErgMo" +
       "AZAxlkAkA9C597iMIwv7sT2QzGy5Hhis+6ErOVnXHrKdi43QXx205E6/Oa/f" +
       "Aub4VVmk3wme6m7o599Z721BVr56GySZ045ZkYPwz3LBR/7q6/9czKd7D6/P" +
       "H9oBOS1+7BBGZIOdz9HgloMYGIeaBuj+7pnhrz/9/ff8XB4AgOKhKwm8mJUN" +
       "gA3AhWCa3/3lxV+/8O2PfuvkQdDEYJNMZMdU0n0js3bo3DWMBNJed6APwBgH" +
       "LLssai7ynuurpm5KsqNlUfpf5x9GP/uv77+wjQMHtOyF0etfeoCD9p8ioHd8" +
       "9a3/fm8+zAkl2+MO5uyAbAuctx2MXA9DaZ3pkb7zm/d86EvSRwAEA9iLzI2W" +
       "I9mpfA5OAaZHrpHnhKYLvLHc3RvgJ299wf7wdz+1xf3jG8kxYu29T/3Kj3fe" +
       "/9TJQ7vtQ5dteId5tjtuHkY3bT3yY/A5AZ7/yZ7ME1nDFnFvbezC/v37uB8E" +
       "KTDngWuplYsg/+m5J//o40++Z2vGrUc3mxbIpT71F//9tZ1nvvOVK6AYiFxf" +
       "yj1ZzItcWzjX9tG83MnUy+cWyvsey4r7osPgcXSaD+Vyjysf+NYPbpr84I9f" +
       "zCUfTQYPr5W+FGzn6easuD8z+47jSNmRIgPQlZ5nfv6C8/yPwIgiGFEB+B8N" +
       "QgDW6ZGVtUt9/Zm/+dM/v/2Jb5yCTpLQOWCqSko5SEE3AHTQIgPgfBq8+S3b" +
       "xbE6C4oLuanQZcZvF9Wd+a8z1w4zMsvlDiDuzv8cOPK7/uE/LpuEHJmvEHnH" +
       "+EX42Q/f1XjT93L+A4jMuO9NL9/AQN57wIt90v23kw+e/sJJ6IwIXVB2k+qJ" +
       "5CQZ8IggkYz2Mm2QeB/pP5oUbjOgx/a3gLuPh/4hscfB+SDkQD2jzurnroTH" +
       "rwXPxV2oungcj09AeYXKWR7Iy4tZ8dNb+MuqP5MPWoqhM04SN6VYAo56+OqO" +
       "ykFlu7wv/dZDX3/7pYf+Po+rs2YEzKmH8yskpYd4fvDsC9/75k33fDrfu66T" +
       "pWhr2PFs/vJk/UgOnqt84/483L2bhp343HYatt8xtPh/zZDk0FRBakQAnTkl" +
       "NIMYZPwtb2mGvudqXryXlv3khW6XGZK7cVsvx2Bu17EWBAG03ZKz8o1Z0d1S" +
       "vPmqC7h5eXg9shtej1wlvISXE143SG7gmHGiavvQeUgt8RWqdRd4dnbV2rmK" +
       "Wk+8HLXOgr3Q98BUXkkr6RVqleVGxV2tilfRav5ytNp9KbmSTsZL6rQNhBMg" +
       "ubke26ns5IHhXVnqqVwqkBflL+/Z5mZ6krOnxh2Wo1zc22Un4GUeQPBFy6nk" +
       "w7wmhi7ku0cGdjvbN+BjupZetq4AdG4+GIz2wcv0+/7xA1/71YdeAOjSha5f" +
       "ZvAKoOWQRCbJzhd++dmn73nVU995X57UgWkcfrB14S3ZqOtrWZwV+W4Q7Zl6" +
       "V2Yqly9DWorifp6Haeq+tceXl+P/H6yNb/7bTimi6nsfGhX16YpP06k+AO9h" +
       "gl7vCOSq0CTMptiiE27usmjAttqlFSNuDGNuhGPcWhcZTFkW41hVXT2uI1SX" +
       "ayD+wqgz3QYZRwzH6wQ7MpmeGdhoczFcjKiuP5cYro1QglvgANmIriJiYxqD" +
       "mXTVoryUkaFBjkkkKidiQWaWTX25VGsVuVARJuNxmyEbGyvmW824HQ8sssnr" +
       "gpoKYrdlID0mQhiESMYdr7Jc9UuyXt4oJD9y9KlVpZpipdtec+PA9htyfzgW" +
       "1YmNdSdUIkqs0etTrs/aqdV0+wsJ8xV3PRWLnKPanCTUpn5v1RglaYsnUZfs" +
       "Ni0n4VUmovkma61Cu6tglcYaRsaY2fOnMY2EXIVwGutGM6oKLh6va5t+sPDR" +
       "KI2AUiQpNnjVtiuS05xxndB0ZCLlGMM2JcMSQrOwbk4JVHQ6/f6Gg3m9E2xg" +
       "rB4PS0J3SvLo2uYRNGXGfEnsUn53UWTKk4btitNao8jzdsvSJ0DY3Cm5K8mw" +
       "i82oZ1vhJqITotaZNJYTf0amC5rhXK6UGqYpOTJGWXNMiQKtqwS4YbDBYl0t" +
       "d1l1IbantqrqcUsfcoNqv9PplI1axI4ntV5LmmqoU2lZdYKaMIWEqHNcMGh2" +
       "GJyyW5wuGQNCmBVb9rBthhsG9aRajy34LhnM61E5jVo43V3JOrJBQqQxpkRn" +
       "zqHCuq+1nGQyFGEBp3qdOSG20VQ0BE4NiWor7PaIPjfornQxsmPKmPLoalBd" +
       "uOu+JURzwa23HdyMCYKWmclCABFY4+kW2l4NjGZCaMyYwJqLdh3tI4MGNnGJ" +
       "kRoLZceXV3XKGaEDUyfTSbPfS7jOirX8qcnpaaA3ZBZJJcWxiuUkdLCyXAG7" +
       "KyuO6h1j0Go5BkxVSd8UdGS24Lp1gRimjRaq902r0G5PYKHdEuiuXVyPU3Gt" +
       "D4tWrbh0mACtzpSy7LpyP1kGDsU0BNUUqvCwjFk1KXIsCunNxowTLFfRWnZn" +
       "Iw0bxSE74JgBOxVbjBFsCKQQwzpca46q7oTqhYuRO+UCZx5EvX6Z45dBZPf6" +
       "E551iIVgIwKyMMXQLw2G6oJYF6hKtzcaFMoiQ9kxkUx64TocD4bwKm05Autg" +
       "I3K2oqW4u9G9aX9UtIuYrVITdtBE/f4GWdnw0pR9Z1TiW8mo35VWvUUsDdqB" +
       "P+6UXZ4q4Sk1XhLUZjG15oOaVUPwEs3aYSOYsoIgkvMNEVFC2O6xZquTBEWz" +
       "ZSQ8324xJZIvO9W60FysBb8XjfvjZcFkkPWmhc9XrblZVxYy7vMtIiyEnFNn" +
       "UyHuEoti0alpgzSq0pHbWwoioo90Zo52OwJTnSC4DRxKyXjYa8czsm6tNpy0" +
       "Lgr8ZF4vd+p1pG4tYlmrFNDEqy2VlSt4G5xrzIM5X9Bdo6cMyI2ghFStm1bL" +
       "y2Wxk1jSwmJHbEuknKbW6VqjVjy1iLqxieu2PW+wPYONO322T5ZKQ0136sGq" +
       "wFSYRalaTZTmGo6i1axTb1Np1Zw3y9XVlJ7hxU1FTTZieTi0iilWrzCqvo4G" +
       "g15rmaY9w9QZPZ6VDaHWrWKyaVfImRqyLZ5z62S9vkk1gpp3HAa2sLXSmzGr" +
       "6dzlVjzlMVyfJGXBrg+iyWzMIi1Z6bj4RtXTCrUwSnRngIw8K4ktbLisOf68" +
       "WpHWSrftKsVSMKinpUFSKyTtYhFOS9S4lnTRDa8NulW6TMYdH6BGbbLp94LN" +
       "eNZosqzVLxQSo0yRnbBQEdMBMhSjzSDGWrS0iequ3SCV/kbXZkU6VZbLjmeH" +
       "ZcaPjJERp1xH5aZaSxxi/sI32U0fV/V50ySHRFm0+LhWdubOrMulXpvsN3Rc" +
       "rWIKwSkwNlHCSqtBdCKtjwOquqzDXKHo+wDXi23LXK9Ym3RptV8ceA11rZV6" +
       "5Wqx2VxNIrGjxRpZ5gtVY15rEvUmz2iTGGxXQWNcaLYCRowVdTlVKzOpOmHa" +
       "1swmG4aJUXivmwaJPHTiggy2oWjcHa27bmiRlc0SW5erfWFSZMkqBk83GKvj" +
       "cEfBFameVoOFwVIFo1KtD4c1p7mJS6jZWS3lSrNpUZs+SrbR2rCuT5NR3CRk" +
       "Y9gYFKK4OS5WkCXRJDqlSc2uetp8VYM7cVDk28YwaCw2SoUi6RJKTUpsKaRd" +
       "WRlrIdYoK/5y2GxtYk13K51ORE70mTyfsQ6O6wxciKo66+sFADZD3+/L0mRu" +
       "e/VEZKfaPOm3l501yWMC3YRrG7wo67P6TET8VUA7sioEzaUxG03XtDroaenY" +
       "Dex2dbWONH6Fk/OZOydqUmo09Wp1XRnwltVsD8B+Oi5jJvBhYKj9KJ15nIRa" +
       "yLJcDP2irA2KvMrhVdWtJKlQ0kIqGYfYkOl05LUNY8RilcjzTXMZxky4RN3Q" +
       "o0vdHiwTptFrCcWBWpdbG0/gkVqySnENrhYshYE1lebp+niikEF346cEhvKN" +
       "qdHdtFpUgnk1z4vIKZXyLDmkRzyPr6wh7HU7ehXVXLUf1FQ1pu1iAasx3kjd" +
       "OFRjAsAicujxROAKg34YFpYKMmx2g1GtUB0smA6u0Pw6NNvNcjn1CjFf6FWK" +
       "cDXCcQLv9jdWb1MBoNFIu2UVoello6xiLFjRXlAcbkjWkugEnVkLudCarpIC" +
       "irCOrhnTyE38sWim0269uFLRecHmJw7hiQLqoau6WZoWaYMBG5Oro/IgGhpO" +
       "pUKXJ2KclGkdHRqSTDbZUgTDc54FRbuLe7Trufhc4lmGnzmmPZkJVFhbRJV5" +
       "r6QiJcWF3WEzHVdhxEGr/CIqD0t0uVwCGZ2IwxzsUU6bZlVl1m7HmIN1jGLJ" +
       "mRLMsuFJVa/GKNqg7VFNJTaQBruo2evmgrRdzBmYK9kNfLPnzdZls1bgS8JU" +
       "WfkVs6DzI7wgwpo8QFRvqWhr324hq55gWJoW1JtVDBVwbTkj5kV4bA1RJBAH" +
       "NDdi5KS+WWDDqBpoYdiS0CVLT0nDNlILKwShp6UuOZZFrjSv9ioA+aVJccbr" +
       "pZEtJ2nsR2ittJygBkDr5RTXY3IxLYphXa6xJhyQ1HTR61ntil3uAvQcNyxK" +
       "HVfGAu6x3eGaKYUTihgv1qZnSHOQwzV5zhkS4ZJKB95atugur5XbNVShGlYT" +
       "FxyQnKIMFyTLQZpIIKUsOAAS2nA/4cI1jQRRumzXl+uKLdErehqMgtUmjklW" +
       "o3B3ODZrCKbQm0VjUGmWSi5qYbUV1S5qVWK16Mn6QiQM3zOExrAXbYhaV6uY" +
       "y2RKBmuBl7uioknSZkBPaJGzEZKLCdyYdFrLKhkmYHmIymC90ivyool7hcG4" +
       "SMPu2HMZbxJhk87cW0831IiYMQla6XWxsGvN8AmxaE99THU0BZHHKL9O+wUi" +
       "iDcztWKpNIrLbjWUJow+UKVFrDCFkbFm0hquygJlRlOOY3V6Q2NEe4nxtYbS" +
       "5ZKuSaCzKtZxoobgzUC+AS/QKtNIDCFFR8UlVrNa7Bhj6pHWlKWWi0SKLZAw" +
       "LbDSqE14a3tdM9JQt8ejQp1sULiPiQNbnlJeV3MHSbkFq8vECMxIdGajRUrS" +
       "SooXutKMFnspooY9UxoWl6rXYk21USMXC6I9dhbdUn/THKq4k9i9cT+V5tOC" +
       "OPcZG2dRklXYRb1ccuFBoUgSNa5LWgJ4C2gsCNRaVrotflytYm1XBftUBW/x" +
       "Egp3k82wWMNxGmV4XCk124SgF03XEzpTYWXhOjrCkHAwcepIvGHXNDNmlarZ" +
       "lpv9WDcDMg76/NBcjifGqErAjtdg0xEFj1tNcVgJyhVdDk28Oo03EjcPs8w1" +
       "6Rv6qDVrEA7SdqYrdarEyqI8dQsDvUyuLX/IqkLXQNOCq/krrOGbRr+YSKVw" +
       "CRKDCLgqmlnrVa2myFo0T1jLRRt1fjMyWhhO8KQUr+plBpmtJwpXL+prLJCK" +
       "izmMb7wKMl4MVJRMKVQl+6kZGEiJ4RyJpGd6SrQcAFmSu2gEHRcFCVmYBDi1" +
       "QsTpfIJM0fUKtQsJI1alIcZXp3B7HNVTbFaeTou6waJ4rYThTLnF2naZ9VMs" +
       "toKOTBS0aSVMOhrvYWvQ1UUQjPQjZDEMa9aMdts6vuYHHFinsyk9NHWECqjV" +
       "qAKSu3r2mvvuV/b6fUt+0rB/8Q7eurOO5BW8YW+7HsiKh/dPZfLPaejYZe2h" +
       "U5lDJ9Qn9k414Je4pty7oSQTL794yc7e77naPXx+3fDRdz11SR18DD25eyNQ" +
       "iaEbYj94g6MtNeeQCifBSI9e/ey1nx+BHpxUf+ld/3LX+E3GE6/g/vK+Y3oe" +
       "H/IT/We/0n6d8msnoVP759aX/UHiKNNjR0+rz4VanITe+MiZ9T37Hrkxc8B9" +
       "4CF2PUIcPyc78Pnlh2QxdCYIzaUUa9vAucaty6Vr9P1mVjwTQzfKiemo9O65" +
       "95WOeZa+qR7E34de6oTnsKC84el9w2/LGh8Az2TX8MkrMfzQ6eA17PrUNfqe" +
       "y4qPx9DNcy2mfd9OgnF2zZi1Dg8s/MQrsTCNoZuO3NlnF5B3Xva/oe1/XZRP" +
       "Xzp/9o5L/F9uj/73/o9yAw2d1RPHOXzfcah+Ogg13cwNuGF7+xHkX78XQ/de" +
       "e5nG0PX5d671Z7dcfxhDd16NK4ZOgfIw9edi6NVXogaUoDxM+ScxdOE4JZCf" +
       "fx+m+7MYOndAF0Ont5XDJF8AowOSrPrF4ArnrNtLpfTEIdTYDbXcf7e+lP/2" +
       "WQ7fmWdTkP8rbA8Vku3/wh5XnrvUZd72Yvlj2zt7xZE2m2yUszR0Zvv3gX1k" +
       "eeCqo+2NdbrzyI9u/swND++h4M1bhQ/C/pBu9135grzlBnF+pb35gzt+942/" +
       "fenb+bHv/wJ8uy1uricAAA==");
}
