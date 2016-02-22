package org.sunflow.core.gi;
public class AmbientOcclusionGIEngine implements org.sunflow.core.GIEngine {
    private org.sunflow.image.Color bright;
    private org.sunflow.image.Color dark;
    private int samples;
    private float maxDist;
    public AmbientOcclusionGIEngine(org.sunflow.core.Options options) { super(
                                                                          );
                                                                        bright =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.bright",
                                                                              org.sunflow.image.Color.
                                                                                WHITE);
                                                                        dark =
                                                                          options.
                                                                            getColor(
                                                                              "gi.ambocc.dark",
                                                                              org.sunflow.image.Color.
                                                                                BLACK);
                                                                        samples =
                                                                          options.
                                                                            getInt(
                                                                              "gi.ambocc.samples",
                                                                              32);
                                                                        maxDist =
                                                                          options.
                                                                            getFloat(
                                                                              "gi.ambocc.maxdist",
                                                                              0);
                                                                        maxDist =
                                                                          maxDist <=
                                                                            0
                                                                            ? java.lang.Float.
                                                                                POSITIVE_INFINITY
                                                                            : maxDist;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public boolean init(org.sunflow.core.Scene scene) {
        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        org.sunflow.image.Color result =
          org.sunflow.image.Color.
          black(
            );
        for (int i =
               0;
             i <
               samples;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  samples);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  samples);
            float phi =
              (float)
                (2 *
                   java.lang.Math.
                     PI *
                   xi);
            float cosPhi =
              (float)
                java.lang.Math.
                cos(
                  phi);
            float sinPhi =
              (float)
                java.lang.Math.
                sin(
                  phi);
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            onb.
              transform(
                w);
            org.sunflow.core.Ray r =
              new org.sunflow.core.Ray(
              state.
                getPoint(
                  ),
              w);
            r.
              setMax(
                maxDist);
            result.
              add(
                org.sunflow.image.Color.
                  blend(
                    bright,
                    dark,
                    state.
                      traceShadow(
                        r)));
        }
        return result.
          mul(
            (float)
              java.lang.Math.
                PI /
              samples);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVae+zrVn33/d323vb2cW9baEtH3xdGG3btxM5LZYwkjhM7" +
       "ju0kzsPeoPgV2/EzfiS2oRugbaAhMbQV6CSo9gfsgcpD0xiTEFMntgGDITGh" +
       "jU0aoGnS2BgS/WNsGtvYsfN73d99lIoRyScnx9/zPd/n57zy3HehG8MAKvme" +
       "neq2F13SkujSyq5eilJfCy9RdJWTglBTO7YUhjxoe1J55JPnv/+D9xoX9qAz" +
       "InSX5LpeJEWm54ZjLfTsjabS0Pmj1q6tOWEEXaBX0kaC48i0YdoMoydo6JZj" +
       "XSPoIn0gAgxEgIEIcCEC3DqiAp1u09zY6eQ9JDcK19AvQqdo6Iyv5OJF0MOX" +
       "M/GlQHL22XCFBoDDTfnvGVCq6JwE0EOHuu90vkLh95Xgpz/wpgt/cBo6L0Ln" +
       "TXeSi6MAISIwiAjd6miOrAVhS1U1VYTucDVNnWiBKdlmVsgtQneGpu5KURxo" +
       "h0bKG2NfC4oxjyx3q5LrFsRK5AWH6i1NzVYPft24tCUd6Hr3ka47DYm8HSh4" +
       "zgSCBUtJ0Q663GCZrhpBD57scajjxQEgAF3POlpkeIdD3eBKoAG6c+c7W3J1" +
       "eBIFpqsD0hu9GIwSQfddk2lua19SLEnXnoyge0/ScbtXgOrmwhB5lwh6+Umy" +
       "ghPw0n0nvHTMP99lXveet7h9d6+QWdUUO5f/JtDpgROdxtpSCzRX0XYdb32c" +
       "fr9092fftQdBgPjlJ4h3NJ9+6wtveO0Dz39hR/NTV6Fh5ZWmRE8qH5Zv/+or" +
       "O481T+di3OR7oZk7/zLNi/Dn9t88kfgg8+4+5Ji/vHTw8vnxXwhv+6j2nT3o" +
       "HAmdUTw7dkAc3aF4jm/aWtDTXC2QIk0loZs1V+0U70noLKjTpqvtWtnlMtQi" +
       "ErrBLprOeMVvYKIlYJGb6Cyom+7SO6j7UmQU9cSHIOgseKAmeG6Fdp/iO4Le" +
       "CBueo8GSIrmm68Fc4OX6h7DmRjKwrQGHsbu0vS0cBgrsBfrhb8ULNFg34ZYj" +
       "m4CYVRQ7DoGuPbLr6kDES3mY+T/pAZJcwwvbU6eA8V95MvVtkDV9z1a14Enl" +
       "6bjdfeHjT35p7zAV9m0TQa8Fo17aH/VSPuol3bx0rVGhU6eKwV6Wj77zMvCR" +
       "BbId4OCtj03eSL35XY+cBuHlb28ABs5J4WvDcecIH8gCBRUQpNDzz2zfPvsl" +
       "ZA/auxxXc4lB07m8O5ej4SHqXTyZT1fje/6d3/7+J97/lHeUWZcB9X7CX9kz" +
       "T9hHTto28BRNBRB4xP7xh6RPPfnZpy7uQTcAFADIF0nAXgBUHjg5xmWJ+8QB" +
       "COa63AgUXnqBI9n5qwPkOhcZgbc9aimcfntRvwPY+JY8kh8Fz537oV1852/v" +
       "8vPyZbsgyZ12QosCZH924n/o61/5F7Qw9wEenz82w0206IljGJAzO19k+x1H" +
       "McAHmgbo/uEZ7jff9913/nwRAIDi0asNeDEvOyD3gQuBmX/lC+u/++Y3Pvy1" +
       "vaOgicAkGMu2qSSHSubt0LnrKAlGe/WRPABDbJBmedRcnLqOp5pLU5JtLY/S" +
       "/z7/qvKn/u09F3ZxYIOWgzB67YszOGp/RRt625fe9B8PFGxOKfkcdmSzI7Id" +
       "MN51xLkVBFKay5G8/a/v/63PSx8CEAtgLTQzrUCqU/uJkwv1cgC4V2Qn6xdi" +
       "FV6FC7LHi/JSbpGiM1S8Q/PiwfB4dlyegMcWI08q7/3a926bfe9PXijUuXw1" +
       "czwYhpL/xC7+8uKhBLC/5yQU9KXQAHTY88wvXLCf/wHgKAKOCpjCQzYAaJRc" +
       "Fjr71Dee/fs//dzdb/7qaWiPgM7ZnqQSUpGF0M0g/LXQAECW+D/3hp33tzeB" +
       "4kKhKnSF8ruoubf4dRYI+Ni1AYjIFyNHOXzvf7G2/I5//M8rjFBAz1Xm4BP9" +
       "Rfi5D97Xef13iv5HGJD3fiC5EqHBwu2ob+Wjzr/vPXLmz/egsyJ0QdlfFc4k" +
       "O84zSwQrofBgqQhWjpe9v3xVs5vCnzjEuFeexJ9jw55En6OZAdRz6rx+7gTg" +
       "FFPnK8Bz234u3nYScE5BRaVVdHm4KC/mxU8f5PdZPzA3YMrfT/Afgs8p8Pxv" +
       "/uTM8obdBH1nZ3+V8NDhMsEHk9YZOTB1IzrIknuOZ4npgKVYnsFesEO+vMTy" +
       "or0br37NMHrd5UreA57b95W8/RpKDq+hZF7tFpYjIuAKKbDyOnlCIuYlSnQv" +
       "eM7vS3T+GhLxP4pEZ0PJ8W2QktfNDy4wHYD6m/01JvzUnd+0Pvjtj+3WjyeT" +
       "4QSx9q6nf+2Hl97z9N6xVfujVyycj/fZrdwLCW8rxMzh5eHrjVL0IP75E099" +
       "5veeeudOqjsvX4N2wRbrY3/zP1++9My3vniVxc9psL844ZLpS3TJfQevD76v" +
       "4hLlR3KJIyU4mBgKKmHfAPnXG6M8Sz3ppKTqi0q6Y3IKZNyNlUv1S0j+27m6" +
       "LKfz6mtAZoXFjjAf0nQl+0C4e1a2cvEgF2dghwhg8eLKrh9k4IUC0XMAurTb" +
       "Vp2QlfiRZQU+v/2IGe2BHdq7/+m9X/71R78J/EdBN25yyAOOPjYiE+eb1l99" +
       "7n333/L0t95drCSAcSc3vvD1YguQXE/jvFjnRXCg6n25qhMvDhSNlsJoWEz+" +
       "mnqo7QnX3GB7P4a20e1v7WMh2Tr40FNxKWynMxiN+ptle6nCibLYakp7K3CB" +
       "Lw+c1XbQovutqbaIG6GaLHQyaW7EqL7BMwUbDivwprmumbRgtR3MEAaDlt/E" +
       "NCMyKCmkCcmrlV2zV0nK0qRcsQWcmXvm3LPsJJLIuVuCmWxYD+vDZbVN1VM5" +
       "FZcajGolGIWX/RizyhPZWFu2ZDWSoYqInlSbMdU+LnIEa8zWThAZsqXXpogM" +
       "bzbNXgZ7+nqsW82pva77Ay+VZYonHVGvTIyAWitrgwRrHpMmp9JyO02cFdGK" +
       "pZKnO5O5jE5s1ZrMxXqTMvFWvzLtMB3HXLmGkTBKU4zkBk5tdWPUNaSpgS/r" +
       "dhaaPiFPmnh3sSSx/oZhM90HuqcpbzVkcsT7nW3FigelHilzA3bVJeY10Utt" +
       "u4X0HVLsr9ZeQDNEiLMpbTW6sqjIaNBskpHljfEOvl4HvfYicrhsWBYFniDX" +
       "fNvVypP50GuM6WorNQdWonPDyWLTZfnR0MBkY0qqMrEFfCvMmo3mfmchYWGZ" +
       "JWiTaLudjEKnE7dtoWIFHlGO0+sPnHpG+512pTETZROJG2WjoRILrEy5zZVS" +
       "mlqC2EbMTtBCTLbdHW/Z3mjUHvqT6VwSnMowIYzQ4ieep2EtcWgvLGW24TNJ" +
       "UqYdm9NhTw21tjV3tB7LsDNC08cazk26kTak+1EizPBKAA+wkcG1apV0McM2" +
       "uMzrHE7I9IjSx36ljTLhGhFmDqPINLmq9u1wiZRaLXyaGvxqMinXy/hktgWk" +
       "kZV0PRBXXKvj+KnQiogt3spGmDNTkWl1UubXM8Nx2rhEdUsxXg06UsfpIF29" +
       "Y2oZ3GubVBOfcFRpznHrakXmjFKLW+OrGdmy2tmqaw0Qu4FPBkjJ72NzcSvg" +
       "XL01kspqj484MUsadFenWyGatYgwQzm0GSClYJ6KCnCeRQj99apddbtGjc+Q" +
       "ZbAg3Ek8J0o9keB9x3RWDXeIEeX6XKw1EbE/IYc0m7ElykwJR6n34STcNjWB" +
       "bfQmiym6FlsIJSIdtrKeRNQoHjQyIbPHznRYNdH5qDatsKoQVOTZkELHhCQy" +
       "aiivqvFQrTK+6ZtrZDjedImuElmt8Uxh0WAolKvl2OU6TmmYeYbfJsG6t6bN" +
       "Hbpp8opbalAUrSw6s8EARGNgcBaDwyGyHVNbL8UFkYmY9YIhetuaYBj8dGUt" +
       "kUgaCTRV4rdVezxtx21tMqMn1KZT28gRzY86FMmPMlgalkhyqGSGzrS7ONaB" +
       "0zjA8EWd6Ux7ONvzCc6nZxXUNaq1hCcDtTWTGT8NDZvBm2vL4PD51OpyBG/O" +
       "2zpuhJRfjaWxjTCtTMPjXkUNF62Nj/RXwXymL1zfazKtbWsl2T5TYaPKCBvy" +
       "CanZE6WJYlYcBYHOU1HL8H2D4qbbeZb2hFVrSVC9QFRjXBh0FJfpYGFTG3V5" +
       "Z01QdEs0QEiVwr7mI5Yk6EtWyTg+xHqjqDlsbhtiMrb6WKotZMTjy8sNHpF6" +
       "4PgtshEaqdmr9RFhS7PtOEKWLT2IKiiOJJt4wRvwHO11RlY5VmzK7Jt8ipQU" +
       "tE1XMUPSZmYpzkYNbCkbqumO6rhDEKOhIuOzJSKyAWtvsZWcTvXpMMmmqzHw" +
       "sOKMlUxke0wcsB08irpRI9tOkjXCOfNtxIRajcGwkh/2FWWe1urjzE0Uk062" +
       "daxdqq/LS5hzV6MoYTuOu61yWDtZhQ1hFKJSIrTXoVWuNJGesG2j9Xm2TKfq" +
       "ph8hgdwWdNsQamEb7fO6sfC65KhRVTVuw1fY5pLbJARSFxMctap9b5lRIuV2" +
       "tRml6paFybJN49io2Z6Q+NxC6/AkEPwkXUizsVEjVjDYoVeqkQP3nRJS73ba" +
       "PUUbzqJmtYWqpbohp1hnU+cq+qyyHVk8HccZsd0OqjKn9Jea3DYQnHVJjuNr" +
       "23UJHg+b7ZnXJuVhsOJb/EIH6TBhRkraJqotabYgKiMqkDBe6Gu0MikPxp0W" +
       "H8qCZlTmTjmL0r7a5rltmaKaVSyo1DkthZVunFmE09aEpkE0R3UadtuC6/Wj" +
       "OZyNpa1StrYdVA1oV8HQQbWHCsq4XbEH+HrYD5nOoCP2GTbxlDBYwiw/qA+5" +
       "DSH29CgiI4keV3BhvaHawzbMuKJBmTKY85odkS7VmNkQHw1mlqU1UItfkwRh" +
       "LBayrQ6qyFDGlBRdoku8m/RnhhGsywmatrktyo+mdYGYzxs12FosNy61yNAk" +
       "UtnVzOxtPdfEGqU+U5ppm+4KTUso7JizbTfWKcLUm/CwnyXhwlF7zcas1Kt3" +
       "R1pW4fvYQK+tIiyqZuRyzgnEhuAx1lL8FjJxZXFDKmtpya9GE33GS9rciMia" +
       "mFXQOs2sXbIajglUX6GSJsCVJLMqaoNERyUCdTuVkhn5Os1X0ai0WJQaIL6w" +
       "eFjSl2QylOpdbIK5js2vDT2NiCVLWFVv4iAkaRp+SoaWylWypLTuKfrGm9an" +
       "ehYw5gCrqVuTMFyU2EyndJT25nHbb9YcT8ZIAQ3DxMW9VNP0Hi70V7M2WG5E" +
       "pX61t3Qmg7FSavsh2fQHXdra+FSXCIc9VNSnrI2QOO+UcVXgWiXH6yzmpEsO" +
       "kGGFXlSXS6QvdthouWwii0E5Hk1HNG2IPCbBYbxk9Fpp4BMSYSvVOKlvG+oo" +
       "mY6p2rDimGN40m+0NbxKZ1WStup6r5SWkLSWEhUtkFvbGbVAtQTBMYUb1rcY" +
       "rGpD39yysM457Uqd4fE+JrFunUxtdb6mFTSwgy02CyInFEDUlNZzG/cJoZfV" +
       "kdoC59AsbRA9eh3LSrIe0qV47S43leUMYdwlqpVHw5lMRZuoaftcw6Mksqyg" +
       "hMXIm2a29RKOAWipj2PPmc3tGeePHVTuKyOi7fvroSbKVuS1Q0VmxNFQ3HZn" +
       "HskuW1JpiXk9LmyKaoQROJ6oSNihBYFt+xXDGaQjQR+zZVsYbAxWrTs9xir3" +
       "TI3i+i7JN4FWCyGtG1YQrieDJbY2B02jURY5OQjomVHNGqnH+ZVm2yv7QsCG" +
       "87a7KKUDh5qz8ErCqAo9GlACHyyadDhlQnKaVQg7JhhWjhC7brjKuD+PYL8L" +
       "w4NWM5xP1+goYyO1Ziwa/aXZwIVZIqILvuHTCVpN65naqw77ftQRaI6iUhm2" +
       "I1RVN7TfjJdjckqk63nbQuoZ6RA1a1UuV9a4IvOGHwQkAA7HaXbG8lKk4pqg" +
       "eX3HI/Gx2N3EwtosVSJmEXfqw2G11KZIlBqsPWa6IjruJBlvxHob43WXH7m9" +
       "KI0kuxM0dbbsRc1m2VjDWqqqtI0JGCI5dEnQsmAIt5hpxgQ8sNKMXcxX/Sli" +
       "D2R30ih3FgOGZUsypfBlepyxipyWAaoIkrleOWthuzYElllXPSrDOggvVIeO" +
       "k1XVYUVVu/MRvABK62RHo7lpg/ISRl4O0j5RRXEMN9Wy0OdVZKDMGNpwYaM5" +
       "Sadtd1ZKpA4TAynsRdYUy+slj4y7zCxt8E0Z8zGHRicBuSAJqxGYgaY33WRR" +
       "a0l0itHEfB03Ipt2qI6SdewEYCk1TEk67Zej7Swz/OaQbQdan+7AgkllU23Y" +
       "yeKg09ggxNTrjVokh5YctgJkpL1M7hidmcWOOwsTgGNfqA629QlforGgXNoy" +
       "elzfpCpLpRV5U+n73ZBn0VCLuTmV1NAARxwDK7HYZItMyUgEGSfN6dSpOXVm" +
       "kQjYLCqFG74MOyKNOGYFX3ggjuUBwve71f5MgTN0VBHqqhXowZKT0ZVRbSjr" +
       "haelUtqgpgw+RzfZfFADE5fgxitttFhQOJoMZkSC+ZtVrwymNliWkVk2qW07" +
       "8pRINDBj8PX6bLlwMR1BTSuwlO4qoE2quq1VV1JWG43JmlpbI0rg91d1ujTW" +
       "zVojZrF4IYopUh1rMcD9IcKZ3NBhadsWV6QftV135iqbehUbTOBoUK93ma3I" +
       "o73NPOmO/BFcYRJe9LUIBBS8FjbEqKHSgbNZdbFlALdYRk27cKm3bbXybegv" +
       "v7Tt8R3FScDhbSvYFecvTp5NXG8HvL8fz4tXHZ6lFJ8z0IkbumNnKcdOdQ9P" +
       "x19xxen4wUVVfnR0/7WuWYtjow+/4+lnVfYj5b398/I3RdDNkef/jK1tNPvY" +
       "YKcBp8evfUQ2LG6Zj85xP/+Of72Pf73x5pdwffXgCTlPsvz94XNf7L1a+Y09" +
       "6PThqe4V99+Xd3ri8rPcc4EWxYHLX3aie/+h7Qv7P7J/lnVwpnWVK6RrH2K9" +
       "ZhcdJ64jTtxl3H+FtyaGBBbPev4nBK3g8MHrXGj8dl58AASgrkU925Mlewx6" +
       "59oWJ6tHsffMi52+HOdcNDx9aIq78sb83PeBfVM88BMxxd1XmkLR3J0NPnod" +
       "G3w8Lz4S5Vfd5lUPCs/Knmdrkntkjd/5Maxxx4EFHtm3xiP/P9bYKwj28p8f" +
       "KpxXUH3mOop/Ni/+KIJuA84ng+Dqjv/0S1E1iaB7r3XNnd/Z3XvFX2l2f/9Q" +
       "Pv7s+ZvueXb6t8VN7+FfNG6moZuWsW0fv0E5Vj/jB9rSLFS5eXef4hdffxZB" +
       "d13lAj6C9nSzEPlzO7rPR9CFk3QgDPKv42R/GUG3HCPLz/l3teNEfxVBpwFR" +
       "Xv2Kf5UD3N0NUnLqGAjuR0Zh5TtfzMqHXY7fAOfAWfyH6QDk4t2/mJ5UPvEs" +
       "xbzlhdpHdjfQii1lWc7lJho6u7sMPwTKh6/J7YDXmf5jP7j9kze/6gDUb98J" +
       "fBSlx2R78OrXvV3Hj4oL2uyP7/nD1/3us98ozpP/D9DtZy5cJgAA");
}
