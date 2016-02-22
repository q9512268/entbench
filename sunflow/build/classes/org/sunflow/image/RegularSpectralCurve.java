package org.sunflow.image;
public class RegularSpectralCurve extends org.sunflow.image.SpectralCurve {
    private final float[] spectrum;
    private final float lambdaMin;
    private final float lambdaMax;
    private final float delta;
    private final float invDelta;
    public RegularSpectralCurve(float[] spectrum, float lambdaMin, float lambdaMax) {
        super(
          );
        this.
          lambdaMin =
          lambdaMin;
        this.
          lambdaMax =
          lambdaMax;
        this.
          spectrum =
          spectrum;
        delta =
          (lambdaMax -
             lambdaMin) /
            (spectrum.
               length -
               1);
        invDelta =
          1 /
            delta;
    }
    public float sample(float lambda) { if (lambda < lambdaMin ||
                                              lambda >
                                              lambdaMax) return 0;
                                        float x = (lambda - lambdaMin) *
                                          invDelta;
                                        int b0 = (int) x;
                                        int b1 = java.lang.Math.min(
                                                                  b0 +
                                                                    1,
                                                                  spectrum.
                                                                    length -
                                                                    1);
                                        float dx = x - b0;
                                        return (1 - dx) * spectrum[b0] +
                                          dx *
                                          spectrum[b1]; }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALUZC3AdVfXm5dP8ml+/hCZtk7Ta0r4HSFUMAk3a0OBLGptS" +
                                                              "NEXSm333Jdvs293u3pe8Biu0MwwFtVPb0hYHojMWW2uhHUZGUcEwjHwGZAYE" +
                                                              "ARmKv9FqZaTjCI5V8Zx7d99+3nupMNPMvLt3757PPZ97Pjcn3iGltkWamc6j" +
                                                              "fLvJ7OhanfdRy2aJTo3a9kZYG1QOFdO/33qm9+oIKRsgNSPU7lGozbpUpiXs" +
                                                              "AdKk6janusLsXsYSiNFnMZtZY5Srhj5A5qh2d8rUVEXlPUaCIcAmasVJPeXc" +
                                                              "UofSnHU7BDhpisNOYmInsdXhz+1xUq0Y5nYPfL4PvNP3BSFTHi+bk7r4VjpG" +
                                                              "Y2muarG4avP2jEUuMw1t+7Bm8CjL8OhWbZWjghvjq3JU0HKq9r3ze0fqhApm" +
                                                              "UV03uBDP3sBsQxtjiTip9VbXaixlbyNfIcVxUuUD5qQt7jKNAdMYMHWl9aBg" +
                                                              "9zOZnk51GkIc7lIqMxXcECeLg0RMatGUQ6ZP7BkolHNHdoEM0i7KSiulzBHx" +
                                                              "3stiBw7dWvdIMakdILWq3o/bUWATHJgMgEJZaohZ9upEgiUGSL0Oxu5nlko1" +
                                                              "dcKxdIOtDuuUp8H8rlpwMW0yS/D0dAV2BNmstMINKyteUjiU81aa1OgwyDrX" +
                                                              "k1VK2IXrIGClChuzkhT8zkEpGVX1BCcLwxhZGds+BwCAOiPF+IiRZVWiU1gg" +
                                                              "DdJFNKoPx/rB9fRhAC01wAEtThoLEkVdm1QZpcNsED0yBNcnPwFUhVAEonAy" +
                                                              "JwwmKIGVGkNW8tnnnd5r9tymr9MjpAj2nGCKhvuvAqTmENIGlmQWg3MgEauX" +
                                                              "xw/SuY/vjhACwHNCwBLmh18+d/2K5qlnJcyleWDWD21lCh9UjgzVvLSgc9nV" +
                                                              "xbiNctOwVTR+QHJxyvqcL+0ZEyLM3CxF/Bh1P05tePqLdxxnZyOkspuUKYaW" +
                                                              "ToEf1StGylQ1Zt3AdGZRzhLdpILpiU7xvZvMgHlc1ZlcXZ9M2ox3kxJNLJUZ" +
                                                              "4h1UlAQSqKJKmKt60nDnJuUjYp4xCSEz4Eeq4VdM5J94cnJzbMRIsRhVqK7q" +
                                                              "RqzPMlB+OwYRZwh0OxKz03pSM8ZjtqXEDGs4+66mwN6xDWw4rVGr3wQki2qd" +
                                                              "aWuMRdHBzItHOoNSzRovKgKFLwgfdw1OyjpDSzBrUDmQ7lh77uHB56Urofs7" +
                                                              "+uBkKfCLOvyigl80Hz9SVCTYzEa+0qZgkVE42xBcq5f1f+nGLbtbQJMZc7wE" +
                                                              "1ImgLYEk0+kFADdqDyonG2ZOLD59xVMRUhInDVThaaphzlhtDUM0UkadA1s9" +
                                                              "BOnHywKLfFkA05dlKCwBQahQNnColBtjzMJ1Tmb7KLg5Ck9jrHCGyLt/MnV4" +
                                                              "fOem2y+PkEgw8CPLUohZiN6H4TobltvCBz4f3dq7zrx38uAOwzv6gUziJsAc" +
                                                              "TJShJewIYfUMKssX0UcHH9/RJtReAaGZUzhKEPWawzwCkaXdjdIoSzkInDSs" +
                                                              "FNXwk6vjSj5iGePeivDQejGfDW5RhUdtIfzKnbMnnvh1ronjPOnR6GchKUQW" +
                                                              "+Gy/+cDrL/75E0LdbsKo9WX6fsbbfUEKiTWIcFTvue1GizGAe+tw3/5737lr" +
                                                              "s/BZgGjNx7ANx04ITmBCUPOdz2574+3TR16JeH7OIUunh6DYyWSFxHVSOY2Q" +
                                                              "wG2ptx8IchocNPSatpt08E81qdIhjeHB+nftkise/eueOukHGqy4brTiwgS8" +
                                                              "9Us6yB3P3/p+syBTpGCS9XTmgcnIPcujvNqy6HbcR2bny033PUMfgBwAcddW" +
                                                              "J5gIpcVCB8XBghLPU396yOYCW2abW6qe/pn9nT8+IrNNSx7gUAo7drRceTP1" +
                                                              "9B8kwiV5ECTcnGOxr296besLwiPKMUzgOipppi8IQDjxuWNd1lI1aJhZ8Gt0" +
                                                              "LNUoU8EXPmq8VgyLxUxLTYH7jbHYRqiW9GGN9TB7xM0FF412BsywpHD88llj" +
                                                              "8rutL94+2fpbcIcBUq7aECNBQ3mKER/OuyfePvvyzKaHRcgoQUU7Sg5WcblF" +
                                                              "WqD2EvqvxeEzGTu/I/S5Ekq+V/ZtUXa39QlHQLxPS+N9AH9F8Psv/tBouCCN" +
                                                              "19DpFBOLstWEaSK3ZdOU/0GmsR0Nb4/ef+Yh6X3haisEzHYfuOeD6J4D8ozK" +
                                                              "krQ1pyr048iyVPoiDh24u8XTcREYXX86ueMnx3bcJXfVECyw1kL/8NCv/vNC" +
                                                              "9PBvnsuT5SFYGlQ2Fldh2Mom6dlBE0iR1txd+9O9DcVdYOxuUp7W1W1p1p3w" +
                                                              "0wS72ukh31nzil2x4BcOTcNJ0XK0Qu4GFgSqBNFjeonq+C8/9erRbxwclyJP" +
                                                              "Y8AQ3vx/rdeGdv3un0ITOXk5j01D+AOxE/c3dl57VuB7CRKx2zK5tRYcIA/3" +
                                                              "yuOpf0Rayn4eITMGSJ3i9HSbqJbGtDMAR8R2Gz3o+wLfgz2JLMDbswXAgrBT" +
                                                              "+diGU7PfUiU8YJV6efyKiEhGNwuMj4lxOQ4rhWUiOI2i36g61QReB6Q6jenD" +
                                                              "fEQAr3E8Fx/rOCmGg4/T63xGjkhS4n0+dxILigZdjqEzzFHuN1lWqkY022HC" +
                                                              "x3zu0hRwlx4RWzzdv1Wz7/ePtQ13fJh6EteaL1Ax4vtCMPzywh4Y3sozu/7S" +
                                                              "uPHakS0fojRcGHKrMMnv9Zx47oalyr6IaGKlU+Q0v0Gk9qArVFoMunU9eExb" +
                                                              "pUMI60lvwOEyYV/xfnnWDkTYQUZibZpvovJSwX0UNLT0i2nAt+WsYiGyMH+J" +
                                                              "szZlclGUTPxo3g+uOTp5WlRjZoaEvQVfewX91WIQ01XTbGMchyW2v0YPmtl3" +
                                                              "ZzOo7H3l3Zmb3n3iXE6MCZakPdRs987dUgz188I91DpqjwDcVVO9t9RpU+dF" +
                                                              "Xq6iCiRRe70FDVwmUMA60KUzfv3kU3O3vFRMIl2kEsJ7oouKXoBUQBEOVQH0" +
                                                              "fhnzuutlZTOORWidEJXkCJ+rflzgzlG+VCyWivnns7VTAwK2uuWu+/SX8k6E" +
                                                              "2VkgwnAyA6qZMcjPuDgQqp/rp6HMSbktetN0Ct+vlj0DjkLRuySp2wqKHhJi" +
                                                              "JUrnsCotIMQ904TJOwvtvxBRTio0mhpK0B5Vz7qnT4CvXgQB9uHwNY8zzeTj" +
                                                              "vP9Dcv44/MoczmUFOB/6KKorRBRCSoJpnObb/OGLsPlv4XAfOJyqj60pxPjb" +
                                                              "0zDO+CJqln2WZeAKysfed+4IRoymQreEojA8suvAZGL9g1e4NXI3mJkb5kqN" +
                                                              "jTHNR6pIzFl2G6hoMs/dq/v0a8ETNCRBtscthBoKs76QLOPwqWni8CM4fB/K" +
                                                              "DZumTHmlt9rT9okLmfn/imxQcuS75sK8Mz/n4lxe9ioPT9aWz5u86TXZA7kX" +
                                                              "stVQJyTTmuavuHzzMtNiSVXsvFrmAVM8fsxJfc7VG7i3eIptPyYBH+ekygfI" +
                                                              "sfIWMz/QFFRgAITTJ023qFqYe7UXEDZTFPSzrIrnXEjFPtdsDeRK8a8Jt3xJ" +
                                                              "y39ODConJ2/sve3cJx+U9zaKRicmkEoVdBHyCilbAi0uSM2lVbZu2fmaUxVL" +
                                                              "XGevlxv2PPVSnydx8DkTbdoYutSw27J3G28cueaJX+wuexmy7mZSRKFO3Zxb" +
                                                              "hGfMNJzCzfHcbgnKRXHb0r7sm9uvXZH825uiHCE5zU0YHpqM/a93nxp9/3px" +
                                                              "F14K55hlRHewZru+gSljVqD1qkF3o/hPCqEHR30zs6t4y8dJS27fmXs3CrXC" +
                                                              "OLM6jLSeQDLQvFV5K4H/kTguXJk2zRCCt+Jr7Htw6Mig9sEdB+M9pum25S+Y" +
                                                              "4uD1Fq7RXhFTHF79HxxjOBClHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
