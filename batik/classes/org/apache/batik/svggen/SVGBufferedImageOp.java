package org.apache.batik.svggen;
public class SVGBufferedImageOp extends org.apache.batik.svggen.AbstractSVGFilterConverter {
    private org.apache.batik.svggen.SVGLookupOp svgLookupOp;
    private org.apache.batik.svggen.SVGRescaleOp svgRescaleOp;
    private org.apache.batik.svggen.SVGConvolveOp svgConvolveOp;
    private org.apache.batik.svggen.SVGCustomBufferedImageOp svgCustomBufferedImageOp;
    public SVGBufferedImageOp(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          generatorContext);
        this.
          svgLookupOp =
          new org.apache.batik.svggen.SVGLookupOp(
            generatorContext);
        this.
          svgRescaleOp =
          new org.apache.batik.svggen.SVGRescaleOp(
            generatorContext);
        this.
          svgConvolveOp =
          new org.apache.batik.svggen.SVGConvolveOp(
            generatorContext);
        this.
          svgCustomBufferedImageOp =
          new org.apache.batik.svggen.SVGCustomBufferedImageOp(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List filterSet =
                                                 new java.util.LinkedList(
                                                 svgLookupOp.
                                                   getDefinitionSet(
                                                     ));
                                               filterSet.addAll(svgRescaleOp.
                                                                  getDefinitionSet(
                                                                    ));
                                               filterSet.
                                                 addAll(
                                                   svgConvolveOp.
                                                     getDefinitionSet(
                                                       ));
                                               filterSet.
                                                 addAll(
                                                   svgCustomBufferedImageOp.
                                                     getDefinitionSet(
                                                       ));
                                               return filterSet;
    }
    public org.apache.batik.svggen.SVGLookupOp getLookupOpConverter() {
        return svgLookupOp;
    }
    public org.apache.batik.svggen.SVGRescaleOp getRescaleOpConverter() {
        return svgRescaleOp;
    }
    public org.apache.batik.svggen.SVGConvolveOp getConvolveOpConverter() {
        return svgConvolveOp;
    }
    public org.apache.batik.svggen.SVGCustomBufferedImageOp getCustomBufferedImageOpConverter() {
        return svgCustomBufferedImageOp;
    }
    public org.apache.batik.svggen.SVGFilterDescriptor toSVG(java.awt.image.BufferedImageOp op,
                                                             java.awt.Rectangle filterRect) {
        org.apache.batik.svggen.SVGFilterDescriptor filterDesc =
          svgCustomBufferedImageOp.
          toSVG(
            op,
            filterRect);
        if (filterDesc ==
              null) {
            if (op instanceof java.awt.image.LookupOp)
                filterDesc =
                  svgLookupOp.
                    toSVG(
                      op,
                      filterRect);
            else
                if (op instanceof java.awt.image.RescaleOp)
                    filterDesc =
                      svgRescaleOp.
                        toSVG(
                          op,
                          filterRect);
                else
                    if (op instanceof java.awt.image.ConvolveOp)
                        filterDesc =
                          svgConvolveOp.
                            toSVG(
                              op,
                              filterRect);
        }
        return filterDesc;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VvUfFDPC2BchAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e4wkx3lf35K8I48U70hJJM2IL/GoSBx5+zGPnglp2dM9" +
       "75me7ume7plpSz72+zH9mn7MdI/D2BaSSIkBRXAoRQkk/hMZsQ3KdAILiWE4" +
       "oJHYsmHZgGzDsQPYEuIAfshCrABSgiiJU92zu7O7d7cSQWaBrq2p+qrq+331" +
       "fV999XjtG9A9UQiVAt/JDMePD7U0PrSd6mGcBVp0OBhVGSmMNJV0pCiagrKb" +
       "ynt/4dq3v/NJ8/oBdFmE3il5nh9LseV7EatFvrPW1BF0bV/adjQ3iqHrI1ta" +
       "S3ASWw48sqL4hRF0/6mmMXRjdMwCDFiAAQtwwQLc3FOBRu/QvMQl8xaSF0cr" +
       "6O9Bl0bQ5UDJ2YuhZ852Ekih5B51wxQIQA/35r8FAKponIbQ0yfYd5hvAfyp" +
       "EvzKP/uR6//mLuiaCF2zPC5nRwFMxGAQEXrA1VxZC6OmqmqqCD3kaZrKaaEl" +
       "Oda24FuEHo4sw5PiJNROhJQXJoEWFmPuJfeAkmMLEyX2wxN4uqU56vGve3RH" +
       "MgDWR/ZYdwg7eTkAeNUCjIW6pGjHTe5eWp4aQ0+db3GC8cYQEICmV1wtNv2T" +
       "oe72JFAAPbybO0fyDJiLQ8szAOk9fgJGiaHH79hpLutAUpaSod2MocfO0zG7" +
       "KkB1XyGIvEkMvfs8WdETmKXHz83Sqfn5xvjFT/yo1/MOCp5VTXFy/u8FjZ48" +
       "14jVdC3UPEXbNXzg+dGnpUd+5eMHEASI332OeEfzb//uN3/og0++8Rs7mr91" +
       "GxpatjUlvql8Xn7wK+8hP9C4K2fj3sCPrHzyzyAv1J85qnkhDYDlPXLSY155" +
       "eFz5Bvvrix//Oe3rB9DVPnRZ8Z3EBXr0kOK7geVoYVfztFCKNbUP3ad5KlnU" +
       "96ErID+yPG1XSut6pMV96G6nKLrsF7+BiHTQRS6iKyBvebp/nA+k2CzyaQBB" +
       "0BXwQQ+A7/3Q7q/4H0MfgU3f1WBJkTzL82Em9HP8Eax5sQxka8Iy0PolHPlJ" +
       "CFQQ9kMDloAemNpxxdowNA/mhC6R6Pl8qH0XKAIdHOZqFvz/HiDNEV7fXLoE" +
       "hP+e86bvAKvp+Y6qhTeVVxKi/c2fv/lbByemcCSbGHoejHm4G/OwGPNwN+bh" +
       "rWNCly4VQ70rH3s3x2CGlsDWgRd84APcRwYvffy9dwHlCjZ3A/HmpPCdnTG5" +
       "9w79wgcqQEWhNz6z+Qnhx5AD6OCsV835BUVX8+ZM7gtPfN6N89Z0u36vfezP" +
       "v/36p1/293Z1xk0fmfutLXNzfe95yYa+oqnAAe67f/5p6Ys3f+XlGwfQ3cAH" +
       "AL8XS0BPgUt58vwYZ8z2hWMXmGO5BwDW/dCVnLzq2G9djc3Q3+xLiil/sMg/" +
       "BGR8f67HT4CPPFLs4n9e+84gT9+1U5F80s6hKFzsD3DB5/7wd/6iXIj72Btf" +
       "O7W+cVr8wikPkHd2rbD1h/Y6MA01DdD98WeYf/qpb3zshwsFABTP3m7AG3lK" +
       "AssHUwjE/A9+Y/VHX/2Tz//+wV5pYrAEJrJjKekJyLwcunoBSDDa+/b8AA/i" +
       "ACPLteYG77m+aumWJDtarqX/+9pz6Bf/6hPXd3rggJJjNfrgd+9gX/59BPTj" +
       "v/Uj/+PJoptLSr6C7WW2J9u5xXfue26GoZTlfKQ/8btP/PMvSZ8DDhY4tcja" +
       "aoWfunRkODlT746h0gW2eeQ2/fBo8S4mGi5aPl+kh7mQiv6goq6cJ09Fpw3m" +
       "rE2eik5uKp/8/b9+h/DX//6bBcKz4c1p/aCk4IWdSubJ0yno/tHz3qEnRSag" +
       "q7wx/vB1543vgB5F0KMC/F1Eh8A9pWe06Yj6niv/+Vf/wyMvfeUu6KADXXV8" +
       "Se1IhWFC9wGL0CITeLY0+MEf2inE5l6QXC+gQreA3ynSY8WvK4DBD9zZJ3Xy" +
       "6GRv1o/9L9qRP/pf/uctQii80W0W5XPtRfi1zz5OfujrRfu9W8hbP5ne6rJB" +
       "JLdvi/2c+62D917+tQPoighdV47CREFyktzYRBAaRcexIwglz9SfDXN2a/oL" +
       "J27vPedd0qlhzzuk/VIB8jl1nr96zgfl6yp0A3wfPDLPD573QZegItMsmjxT" +
       "pDfy5G8fm/yVILTWIAY4svm/AX+XwPd/8y/vLC/YrdgPk0dhw9MncUMAVrH7" +
       "gWGMfH+ZBHRwbD3PXmA9x7Q775inlTwhdgzgd9SrF8+ifh/40CPU6B1QU3dA" +
       "nWfbhSg7MfQAYA1EzorkaHsANy4AcEJ8DsH4TSLIA6HaEYLaHRAI3wuCdwDe" +
       "gEKu8+B/D+G5CyDsqc9hmL1JDB8C34tHGF68A4ab3wuGx3IMSRT77rnI5xgO" +
       "chGc2zU8h+yl74qs4CS9BGziHuwQP0Ty3+bteb8rz74frJdRsYkDLXTLk5xj" +
       "MI/ajnLj2FoEsKkDjuuG7eDHWK4XPjd3EYe7ndA5XjvfM6/Apz6472zkg03V" +
       "T/7XT375nzz7VeD4BtA969wpAX93asRxku8z/+Frn3ri/le+9pPF8g8mQ/hH" +
       "/xr/Wt5rdBHiPCm2Re4x1MdzqFwRQ4+kKKaKFVtTC7QX+nsmtFwQ2KyPNlHw" +
       "yw9/dfnZP//CboN03rmfI9Y+/so//pvDT7xycGpb+uwtO8PTbXZb04LpdxxJ" +
       "OISeuWiUokXnz15/+Zd/5uWP7bh6+Owmq+0l7hf+4P98+fAzX/vN20T3dzv+" +
       "W5jY+Np/7FWifvP4bySI+rwpoOwMxitCfdmtk0R70m83h7MQ1tsrC+mu2CbJ" +
       "EvXlQLQlArYX+Chaz+TBWm1gDRfftqVACNhtotLxggkG6LC00YYzc4pXZHal" +
       "qoOUtIOViLJSvMD5lYgFqLNy7FCclrw5XdYaDTmFx3GXdfHGWtHqtWqjmuLb" +
       "pKQpsO6XalMOaS9lQbBIe7bmud4kDNvwpCWG8dKYt7Cm0+jqXY1MurbUgMW1" +
       "LdKreLhUBGMDTJecTNWRQFUkSR40eWPjDsk+Gju0xC4qJY8N+F46WwRkEFBO" +
       "lGnroTTqLzmsJrpDtk+RvdVwSzQXSE0glo22Nts0bRIdbpYWq3PzQUsbGVtW" +
       "CzoCuy5ntF7LRnG9j1hio7TIul2Hxtlx15Smg0HLFZfGdjZTWwNuiQlpRV06" +
       "nOAb3BzLRH0xCI1M5V2WVH1d1sPlli63tuqmTW2EDs86823DJFoCrwXqkpf0" +
       "QS3BZtK4VrHH1eGwM/S27SnDLed9d6oMl5xo84gq2UbMl3lqTqk1R+lpYn8V" +
       "D9pzomlblTE5brfn9VBaMGHVXXZaLXmMVCnMwrPxfIaEg34qx/NBUgITEbo9" +
       "VJoENhssA7Y071f6FtbccKxPcWu6JbQUTBxRiJsttp2xHemrYGRY6RhrrdXF" +
       "0mxZEUFhPbw3GpsB2AF5SnmFGR7SLs/ZqTgMk1Wg2y13DgtVd2qCiY3V+RRV" +
       "BxsKllpGyHOj9pYhNaI8jhKkzXsDKuxvtnRvhfXaQrtJhKpYyxbqTJUC35o0" +
       "1SAS0nYn4EyxVap4dr8dDPgVPWzR2Sjt+zMznLJEzyS70mRRpxBdECdIE/XY" +
       "iJyxltjjZHvpkvOqL2CZrMA41tDVxhrNnIUzdYebqrURRCGFe1MSNUUTQ4it" +
       "MFQ4IhUsuO8JTalXXqG2YU5aG5ztblmYZkdBrbFAp3I1bAtb3XClctRpCN2J" +
       "WNcJo4Kst0lVWocK4aBda9XXei6xnXq8Knp2eTIbt8mF4ChWy5KUjbJUU7xR" +
       "QRAGWU+tAOc6gm+tZE0n7a40lNCME2tO4k+8GYHMNozL1wSZUHQ86wn1QY3r" +
       "dEO0kYgZ4fINcRBSSS3gYbu0GDYVC2lzaJ2sBLQqVNHNBNuO66Ou1V12zSrX" +
       "qpc8i5n39NQTl2k6q28ngdXvW8PZKgMTxeoZNbBaVD82Ubrlj+Z2Nhmj6pQg" +
       "gAkywYTfNEvd1ZTa0DbbdmZTeDOQxqKBl/uNZEoguo+yI1+MV1VvRTa7UUWx" +
       "6vNmiWFaPtdood1UqHJbgSoN1GokJ0ilsfRCXSGXDBEbiD3EWrTZEjwjKokR" +
       "LVIdqjFY2O0SymUK1ghsbNhmrR7fxODQgedJUu7FobbhK852gbWUbBTQGDGp" +
       "6aPmZtJLp4wViVLXUmYeam+mg8aYC9r8xOW8vtYXI6SvND1lwtKVVkiU2pX6" +
       "stZh5eq0uahv56wQdJbNoOZxm0DlfB+d9vSl6Ja4SUVMxa64HdVS0qrq9qCq" +
       "0FvX4Bp6l9TTSrvb5NEFaVodvFcflskGpS4mTX8g64HjKSV6LhtEPGsZUWtQ" +
       "MbM+K2b+pLxedJURMDcj7BguI4q1mr+gZX0aNMcsZcTNZgerD7bEgHQRpBOj" +
       "Q77boWqB5tQmimKlCofIaMynYUXFa5NtiTHWim9UW/KmXZ/PF1HdqSuyOtt4" +
       "s3F1rAci14xLQ2erhY0yjlmwDk8n5bhMN8eMQ8MePqQ9zDCVgUS3gNaMUyxA" +
       "KgEyQqsRDdNJowSLrF6eScSCd0Oy5WZ4c5gaZL1HzctlLIlVWCuFm0y2veom" +
       "peU5NVkGJRJoFrZs+BkXDaIM36JN2h4YzbU/ZtH5sETq/LLCEe5saOgzJlgJ" +
       "YW+9nsoKNuvV7UkFt9lVSI3qTMhgiJloa1xa42JKTdtsCy0zolkTTW2yZZSl" +
       "rHaQRVrmedmrVjeySpOMTrqTZkVuG1OnPQ63/So6H7MK60gzg6XkmjBXt7Ze" +
       "YR2YpDl4iSuCPyBrDLAWFCM3KNxsT+22o08CnpW3cHWhME0TKelV0+9S2yGs" +
       "Y5tp3MZHA7kjCkYrVerDZuzwG9PvJZXIi5Pq2smmlEFNEI5dEECPlB5LIu01" +
       "5brhalvaKiVdUss4b8wGciahkRUsx5uoTlEOYjXNVatJLTr4lJnP2tW0Y4zH" +
       "FKoIwnCpd9o9OQpJJF6rnqosyjVy4NXxal32bROpptvGJOpq6hZ2nQpjcBOX" +
       "1tGeadQbVODp3nzpbvRuSKWGNp2Q5tp24RCd9+ItnOB1wRVTe15xo4HC6VMT" +
       "b2zDLGlojVQ3Su3lKLH5XuY2RQJfE0rDYeqVsoOj1tYKpsHYRZSaTWymYjom" +
       "6Emp6tPUEq2OV0R91tQkkm94HN7fGvWW34UlikmrYubW+9tZaVyZTFopxSBG" +
       "jxmaESX4PDtC5EqGzpTqZARCYsKNJ9QGFf1kIqGdycacCsjC75f5iWY5Qm/a" +
       "RecRNthmglOJaTPWm3Osnmw4wZ3OTTxIVJSYijoR1UUNHfj96USJpnJPnK9S" +
       "rtNS7IZMSKsWiJAkSZuaqKP2hoMJEjQWi2C4UAaVlYxFXEbzWcAKQ38lLyfi" +
       "YhTaq+FYHHuOOMow2+EXOo/ZcSdW5VZUr2rYyO/HC3m0MudgCJ5cubw0BStn" +
       "fWn2Npv1SBKsISVxkdCWRSPUfUerWSWhLpAiT8AOI26QjCTqNLlqr8ZgLe01" +
       "Gg10OI7xcuqPxkJCony93GEUBoZX+iib0Ou1oFgyi9MOjaLTvhqAWG5rrRTK" +
       "b02xssHWKj3NraDlNYNW0karu+KmI2ysYo43WcBovc+tsr65xjf8Eo/gEl33" +
       "tKTXQComjiILylUX1T4j23atLIpOha2mc5xYSB10XptIMt1vyvNawIlJCKaX" +
       "Ykfzpm5sw3bfs3G5qYckk5SqM8osl/ubxAoFqhfS8HZszqORSyy1hZnZMusN" +
       "p5uQEOho2FxXSLnsVqgulnUphYMpC8SmUhePZ0zMJiWhJIM4S2eVUbwtV9lW" +
       "0JjIY78ta/O2mdX5nm1w/XKFXeMVPMO6dcTfzHrctoeYpUWpJehcYzOumcS6" +
       "TI9xmKrW2w2dUlvRLORZXG2S2wqNCfpy3cfXcIr7IsYMBoOEd+hxo8x5rpSq" +
       "UQ2luklWLwX6oMoR0WiB4dO1XTdkZm1HsKjKooMo7VlFgzVa10uJo2Ua3ZN5" +
       "g6CQEVgDeHg2SgNuMTOQ9agz4jSjnNWr8migNuoaRtBlWO6zbq0+7w3TpDHU" +
       "+4LhZEFpzVCyrnnpHGkjayRY1VFY22KOH46bHb8RUCIf0DGFBdSYcGvoYoLX" +
       "epSGszBDYowk6fWx3hpU4cqC0QwTm6E4i2BzdWg10tGAt9qKmLFY0/cGJdFL" +
       "K6hHZ/YoKDELZAaiF5pOqDpMROJ8M+9SeH0rTNmq4qN2v6+ENoUx5YU+0NjZ" +
       "oplMvVUvm1B8yZGktUJtM12nDd5zK7G50nqyrCWYlixda0YlPrygQJQJk1XL" +
       "sKM62BB4i0VELZNttmC8DS17fdXm5jaG+WHsycHYd+xRjUERV+4MZKLqBYQQ" +
       "VZLZrCmNl4xE1ZVJjTISnq0tFp6EJTPQhs3bDJlq3ZXb82gKYHX7CLdykDFY" +
       "sNddTW+X9CZjJAOZm44FZygnHmbN2iByZuhOSpSXconpjypZavbZ1SAbciVW" +
       "mstNTQk6xDyrTtY1mc86dq2z5RJKaPUFfo3DVSMIooxrracqgdErrgomrbJc" +
       "wCW9vtGMHjIcATOOknnCCzq6ytYTrW+b1WBVNbNayZlpSznWZdo3O/WVGCUZ" +
       "3FuTDQFb1oIeiCzX85m46HX1RtUU27V2w8hWTRgnUbjSs+BKIyPWrUaXoOEk" +
       "8Upbyo7ZimqNBhpMcl5XWjbb3rZh4UnQQYQ4nch9uDzxmcYmVma02W5GM16r" +
       "dLdTXCbW3iq0ZoTTF+BSmcvIkGG2fgb0OMhK8MwDEJjEMGbirGM1V3N+wlXN" +
       "Mu/ioqJbXNelw+Eqzup1hLGDxkpk6ttRc4b353xpWlvjiwFvwuv2etyMV2rP" +
       "nAdSSfdsFclgDWwHs6CL4Vw7NURaSipm4hmuSNphPRTEzXay8LohVsedcgPX" +
       "GWxVbqrreitqLBJhUa8xAVUaDfrlWEtmTFKRF5WVFpmOQC4RYwiTcYSES0Kx" +
       "kyAAC6xYngiLPtj4ES13smzNrNImrAjiVE6nomc0kpGXthcSB9fgjmdVkCQO" +
       "+1VWl8arobPkm5kD1l7ddgYlIovKfEyQLbREh71J1VBwspls2pqLODGynXhN" +
       "KW3wyTjV2/UKpc3UjMDC6hCuCGte77SAfRKKCXbtP5Bv5//+mztReag4PDq5" +
       "U7cdPK/w38RJwq7qmTx57uS4rvi7DJ27hz19k7M/qofy05En7nRVXpyMfP6j" +
       "r7yq0j+NHhxdcfxYDN0X+8H3O9pac051dRn09PydT4Go4qXA/uj9Sx/9y8en" +
       "HzJfehOXkE+d4/N8lz9Lvfab3fcpP3UA3XVyEH/LG4azjV44e/x+NdTiJPSm" +
       "Zw7hnziRbCH1p8HHHEmWOX8Qup+725+Cvn839xfcIP2LC+o+myefiqHrhha3" +
       "NN3yivtCTovPHHGdFT0rbYr5vKn80uRrX/nc9vXXdidYshRpMVS60yuaWx/y" +
       "5Le0z11w07x/X/Gt7t954y/+VPjIscbcf/Ym9dpFAjw+OH3w9AXX7gLxX+5t" +
       "4tPf7XTttOSKgp864eHRvLAEvvkRD/O3fxK/cEHd63nyMzH0LjCJxzck+Sm9" +
       "Fsa7W6v+HufPvgWcj+WF3w++Dx/h/PDbj/OXLqj75Tz5xRh6N8B5cpFyBii7" +
       "B/rFtwD0+/JCGHwvHQF96e0H+msX1H0pT96IoUcA0P11yxmkP7xH+qtvAWl+" +
       "/we1waceIVXffqRfuaDu9/LkyzH0TI70djcxZ0Cre9C//RZAPwUdIQ+OQAdv" +
       "D+iDguDg2OE8WTgcaRMfWjmWwztcTj18QsZqClhCDEcrev/jC8T2p3nyhzF0" +
       "T+xzQvd7eXfQsRwgxBawmtAKjl/2FZL8ozcjyRTwe+sLo/y5xGO3vGHcvbtT" +
       "fv7Va/c++ir/n4pHNidv4+4bQffqieOcvqk+lb8chGA1KrDet7u3Dop/fxVD" +
       "j94BZX6jVmQKpr++o/9vYGk7Tw/EVvw/TfffY+jqng50tcucJvlWDN0FSPLs" +
       "t08mD7uTyJtyFIeSEp+I/kSR00tno6WTiXj4u03EqQDr2TPLZvHK9DiESZij" +
       "1fn1VwfjH/1m7ad3r4QUR9pu817uHUFXdg+WTsKgZ+7Y23Ffl3sf+M6Dv3Df" +
       "c8cL8IM7hvd2coq3p27/JKftBnHxiGb77x79xRf/1at/Ulwf/j+8MrsL/isA" +
       "AA==");
}
