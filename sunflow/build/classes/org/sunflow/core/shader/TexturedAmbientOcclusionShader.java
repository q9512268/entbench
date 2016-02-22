package org.sunflow.core.shader;
public class TexturedAmbientOcclusionShader extends org.sunflow.core.shader.AmbientOcclusionShader {
    private org.sunflow.core.Texture tex;
    public TexturedAmbientOcclusionShader() { super();
                                              tex = null; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        java.lang.String filename =
          pl.
          getString(
            "texture",
            null);
        if (filename !=
              null)
            tex =
              org.sunflow.core.TextureCache.
                getTexture(
                  api.
                    resolveTextureFilename(
                      filename),
                  false);
        return tex !=
          null &&
          super.
          update(
            pl,
            api);
    }
    public org.sunflow.image.Color getBrightColor(org.sunflow.core.ShadingState state) {
        return tex.
          getPixel(
            state.
              getUV(
                ).
              x,
            state.
              getUV(
                ).
              y);
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
      ("H4sIAAAAAAAAAL1ae8wsSVXv+9333ce9uwu7y8q+L+ju4NfT8+oel9dMz/TM" +
       "9PQ8u3t6ZhQuPf1+9/R7GlcBoxAxuNELrglsTARRsjxiJJoYzBqjQCAmGKJo" +
       "IhBjIook7B+iERWre773feBG45dMTU3VqVPnnDrnV6eqvhe/A531PajgOuZG" +
       "MZ1gV0qCXd2s7gYbV/J3Sao65j1fEnGT930GtF0TnvjM5e99/zn1yg50bgnd" +
       "x9u2E/CB5tj+VPIdM5JECrp82No2JcsPoCuUzkc8HAaaCVOaHzxDQXccGRpA" +
       "V6l9EWAgAgxEgHMR4MYhFRh0l2SHFp6N4O3AX0M/A52ioHOukIkXQI8fZ+Ly" +
       "Hm/tsRnnGgAOF7LfM6BUPjjxoMcOdN/qfIPCHyzA13/t7Vd+9zR0eQld1mw6" +
       "E0cAQgRgkiV0pyVZK8nzG6IoiUvoHluSRFryNN7U0lzuJXSvryk2H4SedGCk" +
       "rDF0JS+f89BydwqZbl4oBI53oJ6sSaa4/+usbPIK0PX+Q123GhJZO1DwkgYE" +
       "82RekPaHnDE0WwygR0+OONDxah8QgKHnLSlQnYOpztg8aIDu3a6dydsKTAee" +
       "ZiuA9KwTglkC6KFbMs1s7fKCwSvStQB68CTdeNsFqC7mhsiGBNCrT5LlnMAq" +
       "PXRilY6sz3eGb/zAO+2uvZPLLEqCmcl/AQx65MSgqSRLnmQL0nbgnU9TH+Lv" +
       "/9z7diAIEL/6BPGW5vd/+uW3vuGRl76wpfmRm9CMVrokBNeEj67u/spr8afq" +
       "pzMxLriOr2WLf0zz3P3Hez3PJC6IvPsPOGadu/udL03/bPGuT0jf3oEu9aBz" +
       "gmOGFvCjewTHcjVT8jqSLXl8IIk96KJki3je34POgzql2dK2dSTLvhT0oDNm" +
       "3nTOyX8DE8mARWai86Cu2bKzX3f5QM3riQtB0Hnwge4En0vQ9i//DiAFVh1L" +
       "gnmBtzXbgceek+nvw5IdrIBtVdgPbdl0Ytj3BNjxlIPfguNJsK/youTBDAgd" +
       "EA5iw1ppYOBIEMzQB3rTefdu5nDu/99USab1lfjUKbAgrz0JByaIpK5jAtpr" +
       "wvWw2X75U9e+tHMQHnv2CqAamH93b/7dbP7d7fy7t58fOnUqn/ZVmRxbHwAr" +
       "aAAsACh551P028h3vO+J08D53PgMMH9GCt8arPFD9OjlGCkAF4Zeej5+9+xn" +
       "izvQznHUzWQHTZey4eMMKw8w8erJaLsZ38vv/db3Pv2hZ53DuDsG43twcOPI" +
       "LJyfOGllzxEkEZjpkP3Tj/Gfvfa5Z6/uQGcARgBcDHjgxwByHjk5x7GwfmYf" +
       "IjNdzgKFZcezeDPr2se1S4HqOfFhS778d+f1e4CN78j8/CnwuWvP8fPvrPc+" +
       "NytftXWXbNFOaJFD8Jto9yNf+/N/LOfm3kfry0f2P1oKnjmCEBmzyzkW3HPo" +
       "A4wnSYDub58f/+oHv/Pen8wdAFA8ebMJr2YlDpABLCEw889/Yf3X3/j6R7+6" +
       "c+g0Adgiw5WpCcmBkmf2I/pWSoLZXn8oD0AYE4Re5jVXWdtyRE3W+JUpZV76" +
       "H5dfh3z2nz9wZesHJmjZd6M3/HAGh+2vaULv+tLb//WRnM0pIdvhDm12SLaF" +
       "zfsOOTc8j99kciTv/ouHf/3z/EcAAAPQ87VUynEMym0A5YsG5/o/nZe7J/qQ" +
       "rHjUP+r8x+PrSCZyTXjuq9+9a/bdP3o5l/Z4KnN0rQe8+8zWvbLisQSwf+Bk" +
       "pHd5XwV0lZeGP3XFfOn7gOMScBTA/u2PPAARyTHP2KM+e/5v/vhP7n/HV05D" +
       "OwR0yXR4keDzIIMuAu+WfBUgVuK+5a3bxY0vgOJKrip0g/Jbp3gw/3UGCPjU" +
       "rfGFyDKRwxB98N9H5uo9f/dvNxghR5abbMAnxi/hFz/8EP7mb+fjD0M8G/1I" +
       "ciMUg6ztcGzpE9a/7Dxx7k93oPNL6IqwlxLOeDPMAmcJ0iB/P08EaeOx/uMp" +
       "zXb/fuYAwl57El6OTHsSXA63AFDPqLP6pRN4ku2h0IP7wLL/fRRPTkF55S35" +
       "kMfz8mpW/Oh++J53PS0C+/1e/P4A/J0Cn//KPhmzrGG7O9+L76UIjx3kCC7Y" +
       "nU7vj301SEhu2Kn2tqgtrGVlKSveuh1RvaUT/URWtJJTQMCzpV10t5j97t9c" +
       "idNZ9ccAEPl59gxGyJrNm7mpWgEIClO4ui/6DGTTwIuu6ia6L/OVPACy9drd" +
       "pqAnZG39j2UFDn73ITPKAdns+//+uS//8pPfAF5IQmejzEOA8x2ZcRhmCf4v" +
       "vPjBh++4/s3357gKVoU++/LX8nRpdjuNs2KUFeN9VR/KVKWd0BMkiveDQQ6F" +
       "kphre9vgG3uaBXaMaC97hZ+99xvGh7/1yW1mejLSThBL77v+iz/Y/cD1nSPn" +
       "gSdvSMmPjtmeCXKh79qzsAc9frtZ8hHEP3z62T/87Wffu5Xq3uPZbRsc3j75" +
       "l//55d3nv/nFm6RQZ0znf7GwwV3Pdyt+r7H/RyELeZGws4SDB3BUhydtvxz7" +
       "Po4VcZu2kKDFUxuKNDeFnj8qtd0iz23KXTNdFvhkVa+iUVeW0TDWOENhVzjV" +
       "9JWZv4mqRLHoOrHAWx2r1OJX04AzEH5dKiIuuxxO8TBJhgrPSmG1jqKRNSsa" +
       "A7ayEeuoIGG1er2aoiO0nqJeELdm3KJpOXbfKU/xZWnh88U1w1EtcmRKzWVk" +
       "UaGyMtjavLKCw2jl6WVNW3fb/HDExSN6qBgyQ06L4SLmtLVH+tx6OohFtU8v" +
       "p0FPIfVuZ0CyiDjVhwZWLkR9tGcYcTdoTdWGFyYG2wgsgmwxpsXWhz7DUpNi" +
       "gwlJrFpuSxjVKk9MlirZNRWXCjEuS7UkUA3bjKjlSKv608K4t9IJl5tJ7V6J" +
       "n8vNSSdAmKXd66vroTHpD9GZUCrh6MIO1Em11x/RxaJcZrQpX1iEVm84m/Fj" +
       "Ydwd2ANmZur9CbMe2F6ZX0+irtGQp9aMnOEiU9W01KFTvhlzujDSdI+TiNGm" +
       "oPAqF5myXjWbtmu44kINNb49i9tqcTXq1MdGYYqqqrVec0V0Fi89E404XAsp" +
       "ppsUV/N0XR+i1hILJsW0uTYCVg3UIjk0CNXgiLg/sGyt0y25w4ExXiT8rKX7" +
       "PY7qcWTbRpfDcChxvrY2iKRQqKjzGT/SuxXLrUWVZtoc+iN63eErVYutOKME" +
       "JqYGscS63NCvcwuuLddiocWX5guL7DaVVrBy58A3gwEwPUiPW8uSrFTaE4pd" +
       "MyV1JFSF9Swlig6xaLYnnAc6J5M2PFQsjWgqjWKfcIqVGjNA0jU3tTuc3mq2" +
       "1ZCmF4pm8J6iWw2XwDBSk/FFxWU5lYX7YoqyYqeCyTNKctkp3RzzEulSrTpS" +
       "IWipqLokZkyUYkPAB/PacGEy4ahELJBOe9JVJZrQe+NxwaxVo3kwqxemguJT" +
       "Wju1hu6YbDmazfpI5HWMoBBJA48f8mYxXc5XlYYQVE18HhhSDW8pKVP10V7T" +
       "Go8qI04cwzY+KchkEyHYUgVbk2wpwRxcJwybqqEkro9DklaSAb1yZGTaQMpC" +
       "1C0g7dkYFw1zoUsxm3ZIaiKbdIitEUqHMYLoLDU85BXOtljESe3xaL2owmY6" +
       "abPkDGvPEayPEBV/CPcFryMgaymhOu3ZzJ5VDLO1gPmVwOECMVZKRCoEQ37o" +
       "VMpdxhj1eWM+h+mq26xYi5FbMablmFMbhc4E9cGpnGgIJs4QA78b9piKsKi0" +
       "GLhcp4ilPhOwhd5mtAnJtWssjtOBZfQ3vWqPrfMcyOzkztwcTnolQi0UIy2s" +
       "dercuFTQOyXZ2PjdalCXpzSJdea2bxd7rUGD1JXevNG052KM1AU5LCwSxGy0" +
       "qvWomQppcYI2DMtFNoOBWph13V4YtJYDz1sncH/h9ds1ZUbXGRz3/WTMLrhS" +
       "2+eDyQgbK3N34/v8powslRqLTqrDXsdbFFiYj5c1m0scvVnQLB6sfXPDGb4U" +
       "DtJllaYLRWmeVmK5HJVmo1rP6RgxuxoY/UpLs2yLKaIBWVlWFYX2yytxzKyn" +
       "iTjuij1srahGVxNVwjI2ndTD44aGLotT3k9ieAhTuMOiYV1dK4LjqPVewyxh" +
       "Q69Jak6pRCBLw0c6ZDrVWwlXIlt6BVnzA3SaeBVBDxwWTuPZAqG6E7RHRkpS" +
       "8mBSGgah5ds0NkntBuc7pK0L2KDGyXJBNOQxNhdREDakWTcH7akTVGC21KED" +
       "m6ry46EeDhSlGcryiGxjBSksO12nugRQseR9YoREC9wS2lPFDeGCv26K9QIs" +
       "hLVg3RNT3LRFGsDErIsPKaA0jy/0xWo+K9u1BtGcKXiF51NFZOO+JBhzot+j" +
       "NzEcWEU+QlI5RSWqiyuTHtZyymzZxlreHFWIsczwZQdeFZjJVKNnZlqSJKvT" +
       "qo1EdDBe8E2yrhRwR5bn43VgwsRy07QbxdoCoxkd6YWVVtKoBw1UhlsBKhHT" +
       "NaqmnMe04IoCd81+tdpxm8NIFrW4gA3mHjwWm2s/ghEAgxSyins+so79GJbj" +
       "eMSVW0sFNVBvjVUwwqrKvaHVbS+WLq1UW41ui8ORidJYBvaUQPh6oU5Qq0iX" +
       "+wDoxgjt8Ewkql2LdppBc5g2N5NVuwujnWUSjsazYmuaskhnirGsmA66FK3C" +
       "IuIlo3A1sKNUhsMklG0KxVmep0ZTHvUox4j7a0yNBLwAp2MUtgmjjmFDurZW" +
       "+rVlid4ATGrIStFbbzowPA+nm9QamH2XnsB2C4vDESXpYj0es/WJ1eXtxVyb" +
       "NzgDHdmSxKBwUFK71UVBX3ecxZANSukqXvWTBVUsdZx2sWQbPb420huSNzbb" +
       "ijgO2iFPD0i7aioIYy0FvbI0Sb8gddrdMOkpg0Do6IOCzKWzmEnUci0U1CBC" +
       "0JYlOoK/tqct1fZn+IogyvSGYU3G2uCFRn9ddGQxqHJJw+ZTeGiFCO6gPssM" +
       "5pMVnyxrhVpL3nit5ZKWAyYWeurSp0vSWuxaMzlEe0h3WsN6NtJwrCCW3KSP" +
       "bEZ2hJoRUhvbsj1cb2Z9s7le11aCt+zFTqRzOojjRl2RK6TQaBXtcKjDaVio" +
       "lpfUSqQZCi/U3ZDFCyk80JsaQB6VGKL9TVEuBB197gabAldTKNOZC50luinF" +
       "g/ncQ+BAnvbMYb3SHPSpleE2XamieJY/bBjNqRjPJ5HYI+JmUvIbkVoq9VpO" +
       "f1ZcabVml5H1lJ/wGwWZForTgKGE+WIJ/NdvEbrcUXv1lUUkPh2lZVL2KsHA" +
       "iEqViQS3gKYuLwAM6c/6k3HPINmNs1izGNIo6kOz7OkhU6hNdVuwZRyOQ6rf" +
       "VqqjRZ2Q4Q7qAVjDquPQdZsbmItayKIxmWF1BI+FemxivahVH8LhprzqjepK" +
       "WESsQHZIHh1uNA7neLNONpoYOwrQClaQo5m7YPFFVBzj1aHOxlW4rRsFctFk" +
       "5hg5I4alDqx7Wh8vDxdxWSovvOUsbK/k7qYiFXyCUSvVDroaV8dEU6NBvqCY" +
       "8zKKk6Hn+iuRiha1MiKvYE/VRH4zVvRUNqfBWu41NZi2FQSPBusSiyYbzEL9" +
       "rtyN5ulIYKfioqIteYas1giwr1PdAVaTbEaCa41VL40NMzDIpG0YQaJKg5rV" +
       "iUdYpdirrVx2riZ8tej77qLN9CgD9kAgdtNBxx+xdYCjcxokS2IqkDMGpYTC" +
       "YBxgcCHZdC2RTJuRXdbTTQQ3rQananXVX/drRY6ginq7UEfcjmRZNc9mUjge" +
       "+tgQ9cK5pOhLvc86cMhEUg1lW8v+NJyO11PaUrBqwTWGXIFL6Vjv6oroxiy2" +
       "FlxeQSkWYUZylGg6yC2qyUhvDebYhq4XCd9ptjv9cRF106YHvDOizfGM6zW7" +
       "o6qEUOnKXtJRRMMDv9mGm5zVrq05CXgOAkcuyvgjAIwoPidkI5lgI8G01otB" +
       "g5iJXeALAcDA0rKG9lezYrmjwTOv2184xZlfaoR8wqCDutLCxAnfm/JdSh/a" +
       "btmypfFKTpIlJq3LMTPqYGPNwvvVMHYpbQHS/5mZVKvtwZRoukIz4kRE1IuI" +
       "z7lydVOrV8NFra9FdDxuMhRZh90oZWoYtyqk6xinyTYrkTO0XKFrRlHVp05r" +
       "1lFNbjAPlxsZUcIa3EQ5rixVnJrmWbUCWezNO/OOBrDHr9PFdBEgcwNW5rzL" +
       "DAit1jWpWLLT6oogJ2tWFZf0iGzMkDIb2OnIgWWQMYUVFxEKTIQZzHwMK0Ld" +
       "XDeG6VQBB7E3vSk7oimv7JR8T34hcPBABQ7HWcf0FZwOt12PZ8XrDu5i8r9z" +
       "Jx81jl57Ht6FQdmJ9+FbvTvlp92Pvuf6C+LoY8jO3h3iKoAuBo7746YUSeYR" +
       "VjuA09O3PtkP8me3w7utz7/nnx5i3qy+4xXc2D96Qs6TLH9n8OIXO68XfmUH" +
       "On1w03XDg+DxQc8cv9+65ElBCOLz2C3XwweWvS+z2GvAZ9/M99z81vzmV1y5" +
       "F2zX/sQV7c6eAfcugh654fIqt4MUSF52B7xPdv9RMnr73Rj38hmevc0l8M9l" +
       "RRJA50JX5IPt+8DbjngaH0DnV45jSrx96IWbH3ZHcXSWvCE8MFtupUf3Lgj3" +
       "Lwr/D8x2au+5aM8eD99gtuz5SbOV7DFbyjk8dxuzXM+K9wfQ3YoUND1NUQPc" +
       "MfdeqAH3B45yB2cFRdo97M9N9EuvxETA/o/c/tUsewJ48IZ3++1bs/CpFy5f" +
       "eOAF9q/yh6OD9+CLFHRBDk3z6I3tkfo515NkLVf24vb+1s2/PnJCuyMve9ll" +
       "Zl7JFfjwlv43AujKSfoAOpN9HSX7zQC64wgZ8Kq92lGi3wqg04Aoq37c3bf1" +
       "7q3eGW9uqeTUcUQ7WJF7f9iKHAHBJ49BV/5vFfswE27/seKa8OkXyOE7X659" +
       "bPvsJZh8mmZcLlDQ+e0L3AFUPX5Lbvu8znWf+v7dn7n4un1YvXsr8GEkHJHt" +
       "0Zu/MbUtkIhmiJD+wQO/98aPv/D1/Nr2vwHQNOhq7yIAAA==");
}
