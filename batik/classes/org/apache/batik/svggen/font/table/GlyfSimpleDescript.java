package org.apache.batik.svggen.font.table;
public class GlyfSimpleDescript extends org.apache.batik.svggen.font.table.GlyfDescript {
    private int[] endPtsOfContours;
    private byte[] flags;
    private short[] xCoordinates;
    private short[] yCoordinates;
    private int count;
    public GlyfSimpleDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                              short numberOfContours,
                              java.io.ByteArrayInputStream bais) {
        super(
          parentTable,
          numberOfContours,
          bais);
        endPtsOfContours =
          (new int[numberOfContours]);
        for (int i =
               0;
             i <
               numberOfContours;
             i++) {
            endPtsOfContours[i] =
              bais.
                read(
                  ) <<
                8 |
                bais.
                read(
                  );
        }
        count =
          endPtsOfContours[numberOfContours -
                             1] +
            1;
        flags =
          (new byte[count]);
        xCoordinates =
          (new short[count]);
        yCoordinates =
          (new short[count]);
        int instructionCount =
          bais.
          read(
            ) <<
          8 |
          bais.
          read(
            );
        readInstructions(
          bais,
          instructionCount);
        readFlags(
          count,
          bais);
        readCoords(
          count,
          bais);
    }
    public int getEndPtOfContours(int i) { return endPtsOfContours[i];
    }
    public byte getFlags(int i) { return flags[i]; }
    public short getXCoordinate(int i) { return xCoordinates[i]; }
    public short getYCoordinate(int i) { return yCoordinates[i]; }
    public boolean isComposite() { return false; }
    public int getPointCount() { return count; }
    public int getContourCount() { return getNumberOfContours(); }
    private void readCoords(int count, java.io.ByteArrayInputStream bais) {
        short x =
          0;
        short y =
          0;
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   xDual) !=
                  0) {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       xShortVector) !=
                      0) {
                    x +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    x +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            xCoordinates[i] =
              x;
        }
        for (int i =
               0;
             i <
               count;
             i++) {
            if ((flags[i] &
                   yDual) !=
                  0) {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        bais.
                        read(
                          );
                }
            }
            else {
                if ((flags[i] &
                       yShortVector) !=
                      0) {
                    y +=
                      (short)
                        -((short)
                            bais.
                            read(
                              ));
                }
                else {
                    y +=
                      (short)
                        (bais.
                           read(
                             ) <<
                           8 |
                           bais.
                           read(
                             ));
                }
            }
            yCoordinates[i] =
              y;
        }
    }
    private void readFlags(int flagCount, java.io.ByteArrayInputStream bais) {
        try {
            for (int index =
                   0;
                 index <
                   flagCount;
                 index++) {
                flags[index] =
                  (byte)
                    bais.
                    read(
                      );
                if ((flags[index] &
                       repeat) !=
                      0) {
                    int repeats =
                      bais.
                      read(
                        );
                    for (int i =
                           1;
                         i <=
                           repeats;
                         i++) {
                        flags[index +
                                i] =
                          flags[index];
                    }
                    index +=
                      repeats;
                }
            }
        }
        catch (java.lang.ArrayIndexOutOfBoundsException e) {
            java.lang.System.
              out.
              println(
                "error: array index out of bounds");
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL0aCXDc1PXv2rEdH/GRO7GdywmTAy9XWoIJxXHsxHSdmDi4" +
                                                              "4EAcrfbvrhKtJKS/9jo0BUIpoZ0ygYZwDGQ609AADYQyhTbD0bS0AQbKDIGW" +
                                                              "UoarF7Q0LelBO6Qtfe9/aaXVHsakZmf0pf3/v//ffXzp4HEywTJJM9VYKxsx" +
                                                              "qNXaqbFeybRotEOVLGsj9A3Kt5VIf9v87roVQVI2QCYlJKtHlizapVA1ag2Q" +
                                                              "JkWzmKTJ1FpHaRQhek1qUXNIYoquDZCpitWdNFRFVliPHqU4oV8yw6ReYsxU" +
                                                              "IilGu+0FGGkKAyYhjkmo3T/cFibVsm6MuNNneKZ3eEZwZtLdy2KkLrxVGpJC" +
                                                              "KaaoobBisba0SZYaujoSV3XWStOsdau63GbBReHlOSyY/1DtByd3J+o4CyZL" +
                                                              "mqYzTp61gVq6OkSjYVLr9naqNGldSb5ESsKkyjOZkZaws2kINg3Bpg617izA" +
                                                              "voZqqWSHzslhzkplhowIMTIvexFDMqWkvUwvxxlWqGA27RwYqJ2boVZQmUPi" +
                                                              "rUtDe27bXPdwCakdILWK1ofoyIAEg00GgKE0GaGm1R6N0ugAqddA2H3UVCRV" +
                                                              "2W5LusFS4prEUiB+hy3YmTKoyfd0eQVyBNrMlMx0M0NejCuU/W9CTJXiQOs0" +
                                                              "l1ZBYRf2A4GVCiBmxiTQOxukdJuiRRmZ44fI0NjyeZgAoOVJyhJ6ZqtSTYIO" +
                                                              "0iBURJW0eKgPVE+Lw9QJOiigycisgosirw1J3ibF6SBqpG9erxiCWRM5IxCE" +
                                                              "kan+aXwlkNIsn5Q88jm+7vybrtLWakESAJyjVFYR/yoAavYBbaAxalKwAwFY" +
                                                              "vSS8V5r2xK4gITB5qm+ymPP9L564cFnzkWfEnNl55qyPbKUyG5T3Rya92Nix" +
                                                              "eEUJolFh6JaCws+inFtZrz3SljbAw0zLrIiDrc7gkQ1HL7vmfvpekFR2kzJZ" +
                                                              "V1NJ0KN6WU8aikrNNVSjpsRotJtMpFq0g493k3J4DisaFb3rYzGLsm5SqvKu" +
                                                              "Mp3/BxbFYAlkUSU8K1pMd54NiSX4c9oghJTDRarhmk3Ej98ZSYQSepKGJFnS" +
                                                              "FE0P9Zo60m+FwONEgLeJUAS0flvI0lMmqGBIN+MhCfQgQZ2BoXicaqGYjh5K" +
                                                              "iqg0tEYdifUp4ArpamrJpmKA0wGNMz7FvdJI9+ThQABE0uh3CCrY0lpdjVJz" +
                                                              "UN6TWtV54sHB54SyoYHYHGNkOWzfKrZv5du3iu1bcftWvn1r7vYkEOC7TkE0" +
                                                              "hBKACLeBMwBvXL2474qLtuyaXwLaZwyXAv9x6vysqNThegzHzQ/Khxpqts97" +
                                                              "48yngqQ0TBokmaUkFYNMuxkH9yVvsy28OgLxyg0bcz1hA+Odqcs0Cl6rUPiw" +
                                                              "V6nQh6iJ/YxM8azgBDU031DhkJIXf3Lk9uFr+68+I0iC2ZECt5wATg7Be9G/" +
                                                              "Z/x4i99D5Fu39oZ3Pzi0d4fu+oqs0ONEzBxIpGG+Xy/87BmUl8yVHhl8YkcL" +
                                                              "Z/tE8OVMAtsDN9ns3yPLFbU5bh1pqQCCY7qZlFQccnhcyRKmPuz2cIWt589T" +
                                                              "QC2q0Dab4FpgGyu/4+g0A9vpQsFRz3xU8LCxss+4+5cv/OFszm4nwtR6UoM+" +
                                                              "yto8Xg0Xa+D+q95V240mpTDv9dt7v3Hr8Rs2cZ2FGQvybdiCbQd4MxAhsPn6" +
                                                              "Z6589c039r8cdPWcQVhPRSA7SmeIxH5SWYRI2G2Riw94RRW8BWpNyyUa6KcS" +
                                                              "U9AI0bD+XbvwzEf+dFOd0AMVehw1Wjb6Am7/zFXkmuc2/7OZLxOQMSq7PHOn" +
                                                              "CVc/2V253TSlEcQjfe2xpjuelu6GoAGO2lK2U+57SzgPSjjlMxhZ9jE9y0Z8" +
                                                              "ynYQaIR9qYgFxqwkQXZDduw7q3eLvKul97cirs3MAyDmTb039PX+V7Y+zzWj" +
                                                              "At0F9iNeNR5nAG7Fo5Z1QmIfwS8A13/xQklhh4ghDR12IJubiWSGkQbMFxdJ" +
                                                              "PbMJCO1oeHPbXe8+IAjwR3rfZLprz1c/ar1pjxC3SIcW5GQkXhiREglysGlD" +
                                                              "7OYV24VDdL1zaMdj9+64QWDVkB3cOyF3feAX/3m+9fa3ns0TPyZYCd0USe05" +
                                                              "aAEZfz8lWzqCpNU31j6+u6GkC1xNN6lIacqVKdod9a4J+ZyVinjE5SZavMNL" +
                                                              "HIoGQtESlIKtdI1cXRW9ddUIo1xhuzUjxSADpFKSwy7nU8/IYEw4xoSPhbFZ" +
                                                              "aHndcrZEPXn9oLz75fdr+t9/8gTnSnZh4PVCPZIhRFKPzSIUyXR/2FwrWQmY" +
                                                              "d86RdZfXqUdOwooDsKIM6YG13oQQns7yWfbsCeW/+tFT07a8WEKCXaRS1aVo" +
                                                              "l8TdP5kIfpeCYNRo2vjchcLtDFdAU8dJJTnE53Sg6c/J71Q6kwbjbmD7D6Z/" +
                                                              "7/wD+97g/s8WwWwOj1VoY1a85+WlG3Luf+mzPz9w895hoXFF7McHN+PD9Wpk" +
                                                              "56//lcNyHmHzmJQPfiB08K5ZHRe8x+HdUIfQLencJArSBRf2rPuT/wjOL/tp" +
                                                              "kJQPkDrZLuf6JTWFAWQAShjLqfGg5Msazy5HRO7dlgnljX6b9mzrD7JeQyll" +
                                                              "WUbhxtVqJ8w02SGnyR9XA4Q/bOYgp/F2CTanO2Gs3DAVKPmpL45VFVkUynLI" +
                                                              "33uZtT6GZSZkt1b2YUTGSXO7FA7h8qqjP7S+9fuHhSLkCwG+8ufeAxXya8mj" +
                                                              "PATgtisyCE5CfOrhshVe3BnZdIrpOBbl0jALxamehAKQJSBbjLOEk+2P5/Lo" +
                                                              "KxYWNg4PH/d9e8ELV+9b8Db3HBWKBSoE4S1PCeqBef/gm+8dq2l6kOd9pRgl" +
                                                              "bZebXbvnluZZFTeXQi02CaEs59qRB28rPc/tjJQoWk6owL9r0jkBBP9fKla1" +
                                                              "lZXlV9YgPrZCIIopmqRybNogDVM5F/EfrxSThrtFUMA5IUNkOGiZUJ/rGuXp" +
                                                              "iD02xQknmbMRGMxF1iRNWd6uh/PHdR2vT7rlN4db4qvGUthgX/MopQv+nwNC" +
                                                              "XlJYR/yoPL3zj7M2XpDYMoYaZY5PhfxL3tdz8Nk1i+Rbgvz4Rfi0nGObbKC2" +
                                                              "bE9WaVKWMrXsIL9ASJ9LT4gem6VcwEVi+FeKjO3C5jrQFRkFLfSiyPSv5YZF" +
                                                              "7Og3PBE0S4tFuYJtDzaDQlN6C4bgS7Nd9ky4mm3n1VzAZe92WSHl+uZC0MyO" +
                                                              "IhyCZuAacdpcQP9xASbujMin6NMiphKN09AqUOc+fl6gaPFObUgxdS2JhmK7" +
                                                              "zk9jGyECbmF7R/VPpRHIGsfqoPY6ovlmMQeFzbDwTtikM57pjlzPhH+3Y/PF" +
                                                              "/NteLbbl0Nh8uYgOHygydh8292Bzo8CkyNzvnKIt3DxGW5gH1xxbm+cUsIWH" +
                                                              "itpCIWhGqtMdum5GIV6AtH0mwbOIyXC12OAtwiSUU9RVAEuGhjAZxLcDSlLi" +
                                                              "BbCI9ZhM8zzRMYxPbzOPeTzKRXZeYUV/1OH7Y59I0Q9/QkUXeB0eTdF/XGTs" +
                                                              "J9gcySj64WKKfvQUFf27n0DR59q6NreAoj9XVNELQYOij3gUHfse8SH7/BiR" +
                                                              "nWYj7CCeD9ljRZEtBI1BWU9p/ERL82H5UhEs057UILMb/5UR31sAz26eWpVg" +
                                                              "kt1U6EUNPx/Zv3PPvuj6e850ao5VDCps3ThdpUNU9Sw1UShtBo1ah9AVNhor" +
                                                              "/CxzCfVRkDk1LATq02CPRmp81d8VUfF3sHkLitI4ZZ1YsrkVG1/A5fzbo+lH" +
                                                              "8UMEYTg+rnDwGXCttElbOXauFAIdjSt/LcKVv2NznJEK4EqXU3Lf6fLiz+PA" +
                                                              "CyxXeYBqtwlqHzsvCoGOxouPCvMiwKd9yMgk4MWlrg/B3vNcjpwcT4502mR1" +
                                                              "jp0jhUBH4UigughHJmFTLjhyWSGOBCrGgSOYjPCEvtsmq3vsHCkEWoTgmUXG" +
                                                              "ZmMzhZEqPPJK8vcrdLTcujyi6yqVtCLpNWfh1HFgIXfEWOz02HzoGTsLC4EW" +
                                                              "YdPSImOnY7OIkRrQp15dwTeiTvRzeXHaePEC1elim6CLx86LQqBF6D23yNh5" +
                                                              "2JzNSC3wwg5E+bhxzjhwg2c16Dm32CRtGYUbeVKaQqA+ij05L09wujntnUX4" +
                                                              "sgabCxkej0hR7nOsfJZVOqQrUZdN7ePFptVwXW/Tev3Y2VQI9GOx6ZIibPoC" +
                                                              "Nr2QkyGbnMgd6HY5cvH/gyNpyJdyP4TA9yQzcr7FEt8PyQ/uq62Yvu+SV8QB" +
                                                              "q/ONT3WYVMRSquo9yfc8lxkmjSmcn9XiXN/gVA4yMn/0N6qQRjPnADOwWUBG" +
                                                              "GGksBgkahDcvCKwzvQAII2XiwTs/wUidfz6gwu/eedBZ6c6DpcSDdwpsUAJT" +
                                                              "8FEXajiDkdDHfJfsiCUdyM7wHVUgo0YXT1GwIOtUlX+X55yApsSXeYPyoX0X" +
                                                              "rbvqxGfuEd8gyKq0ndezVWFSLj6H4IviKeq8gqs5a5WtXXxy0kMTFzplRr1A" +
                                                              "2LWs2a7Sk34InQZq3yzfC3qrJfOe/tX95z/5s11lx4IksIkEJEYmb8p9DZU2" +
                                                              "UlD/bArnvq7tl0z+5UDb4jtHLlgW+8tr/EUfEQfejYXnD8ovH7jipVtm7G8O" +
                                                              "kqpuMgEqKJrm78dWj2gbqDxkDpAaxepMA4qwiiKpWe+CJ6GhSPjFHueLzc6a" +
                                                              "TC9+wQK2kPsiPPe7n0pVH6bmKoglUVymJkyq3B4hGd9BdMowfABujy1KbLuE" +
                                                              "B0ZpgLoOhnsMw/lOoGqZwT3GmvyJDur1Tv6IT9f9D8zwOkuzKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hTZzuBlVq3baIK2ItPqj/tqROj7aE7ga");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Z/dgCQvdXdCObSSvNLme1NjEQ8rWl5VOHMJ9TuszmrpZr9xex9sN2xvT52On" +
       "PejMrMDfTvR+MB6FTrujLDc1XQp6qdXzMTFV/QnWCBLTHPtLtYKPWgODpTfE" +
       "cKtSudwSFzhaSZhxzaIjk6ZVEG98ftiSnLGn2xyfOSMrC+rdhjFQ0K4y8RIN" +
       "6wJzr44latvvIoKvU97McKNJAtszbxAIyaI+cHbZqLcNq4tdi1ygGtrr5MnM" +
       "2uZg1YwV21D/6vVtj91X7gQeHwfd2O2i4iuvYwcsPfWG7njHtPzcAZ05Qnhq" +
       "x/TUQQeoOIrxyK1OeZYHUz7/sRdeUma/UL1wuM+MxtDl2PN/2FZ3qn2qq8v7" +
       "ne9jNq4cbdaih2ygZzduT4DefNf2h/aCOrPnfXBCsC4JvnbOpvgfF8V/iKH7" +
       "dTXuF4cFTs4KlB2ciPk/vtpG4+muz0AtyR4E1wcOoX7g+wT1T8+B+t+L4k9i" +
       "6BKAShwdzvjoCcCvvwGApVkVL6uwQ4DY9wngn58D8C+K4n/E0L0A4OrkBUPx" +
       "tHkC83++GTD7hzD73x+YB7fdGubBHcXD7+5hrm8F8wB6AzDfWjws3ouThzDJ" +
       "NwfmaRRXz6m7vyjujqG7i7NJTnkgU73Z+4A7Jc+zVdE9QX3PG0BdxqPi3f3k" +
       "EPXkzUf92Dl1RZQ+eCiG3gL0SnumG+PHr6JOAL7zjQIs1MocAmTefICVc+p+" +
       "uCjeHUNXAMDDIHsziD/4BiCWLwOL2PPcIcTnXi9E5qYQT73WLd8Lvr8E1D4H" +
       "LFoUtbg4QyMqpZdGN32ltfNM5QR7/Y1i74Hr44fYP/79xE6cg7145XaAgTSg" +
       "wH401Rw8cwKz+3pgpmB2vvGAfnHa+MEb/iO0/1+L/MWXrlx6x0vcv9mfxDv6" +
       "78llCrqkbW379GHEU/d3+KGqmaUILu+PJvolmlkMPfnqh5Nj6Pb46JDYwXTf" +
       "ch5DD5/XEqi/+DrdhIuhd9yiSfG2uLw5Tb+Koatn6QEr5fdpuh8DlnhCB7ra" +
       "35wm+VAMXQQkxe2z+3MEb48h+DUeyz5SS3pwffJ4pHLo/ldT+al886nrzs2V" +
       "/xc7OuO23f9j7Fn5Sy+Nph/+dusX9sf5ZVvM86KXSxR05/6fBWWnxTm5J27Z" +
       "21Ffdwzf8517v3z5XUcZ7L17hk/c5RRvj9387Hzf8ePytHv+T97xj9//D176" +
       "o/LV+P8HS3hXY8g3AAA=");
}
