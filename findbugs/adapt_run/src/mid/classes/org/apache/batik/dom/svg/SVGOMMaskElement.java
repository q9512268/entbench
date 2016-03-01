package org.apache.batik.dom.svg;
public class SVGOMMaskElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGMaskElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_X_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_Y_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_WIDTH_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_HEIGHT_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_MASK_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_MASK_CONTENT_UNITS_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             xmlTraitInformation = t; }
    protected static final java.lang.String[]
      UNITS_VALUES =
      { "",
    SVG_USER_SPACE_ON_USE_VALUE,
    SVG_OBJECT_BOUNDING_BOX_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      x;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      y;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      width;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      height;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      maskUnits;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      maskContentUnits;
    protected SVGOMMaskElement() { super(
                                     ); }
    public SVGOMMaskElement(java.lang.String prefix,
                            org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        x =
          createLiveAnimatedLength(
            null,
            SVG_X_ATTRIBUTE,
            SVG_MASK_X_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        y =
          createLiveAnimatedLength(
            null,
            SVG_Y_ATTRIBUTE,
            SVG_MASK_Y_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        width =
          createLiveAnimatedLength(
            null,
            SVG_WIDTH_ATTRIBUTE,
            SVG_MASK_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        height =
          createLiveAnimatedLength(
            null,
            SVG_HEIGHT_ATTRIBUTE,
            SVG_MASK_WIDTH_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
        maskUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_MASK_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              2);
        maskContentUnits =
          createLiveAnimatedEnumeration(
            null,
            SVG_MASK_CONTENT_UNITS_ATTRIBUTE,
            UNITS_VALUES,
            (short)
              1);
    }
    public java.lang.String getLocalName() {
        return SVG_MASK_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getMaskUnits() {
        return maskUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getMaskContentUnits() {
        return maskContentUnits;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getX() {
        return x;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getY() {
        return y;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getWidth() {
        return width;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getHeight() {
        return height;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMMaskElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GPfpm9NzL4vgThju4b8am8LH//x/X+dAOTHfIHDZa89BL//KI+hPfjdvf8KQ" +
       "WevHNtcvXiDaPWlb+S3rL889cf5r5wp3coVL4i6UnvNmlPEOB8LH4Ci+BuH2" +
       "NeXXhoLbuOfZ4xXgnfvsfGrYfW4+WTTBfVY7u797j47flmn5/eAq7nynuO+M" +
       "B4X8hrqxP57Lbt8DnDLIA/adU/4N+DsA1//NrqzDLGMb2TyA7sKry8fxlQvW" +
       "9Ac3lkn7vB5idr6kHFsK+OF7rvPDfKJ2HDAPEsyW5I0s0RnXncyb3NEmr+Vo" +
       "o2M1ZNOxcB5c3Z0akJuo4cM3VsNtuRqyhA6BFXSbN3NFM2HhHobE6NnVOYIz" +
       "3Rnw4Kdu7sE5025D4pd+48k/+OmXnvwvOVld0ANgZ8RXbxCjn2rz/Ze/9d0/" +
       "uvfRL+Zr+u0CH2wtvr+5uX7vcs2WJJf7nmPNvDVTxCMZ8+w0c7C149Xr7fi+" +
       "y17EB7oXgcXwPVuSurx1i8u5Ri5v6eVDH7lMjDvdqyRCdGeXP3DZluNdycd4" +
       "S3j+Q4eHhx959mnXzQVBjhnhYMt/W8NliXxkE+0M1/xAljx3ZIvzpmyroXY2" +
       "j1C+boHYYb3bwEDPP/At41e+89vbzck+aexVlj/54j/4m8NPvXju1Jbwyet2" +
       "ZafbbLeFuYD35lJmS9jjZ42St+j9ty89/2/+2fOf2Er1wLUbnC7Yv//2f/g/" +
       "3zj83Le/foP4+TbgANkPyd3cbE148GRNQE3HlrPZdVS2DaZ15/B4Aw4KN9fZ" +
       "yS88c3MdE7nDnRDm7378vz9C/6T23C1E0e/a09F+l18gXv56/93iL54r3HZM" +
       "n9ftzq9t9Oy1pHm3L4eRb9PXUOejW9fL9bf1uyx5f266MxbBF84o+3iWPA94" +
       "Q8xUvbXMGdV/dlPYI7qPvH6iy8PvbJM53E3n4U2I7pM3iT9yojuaTwebI6d4" +
       "79l7MsTWrYwi8Hz+7Yn/938M8cc78cc3Ef8XXpf4SXbzD/fE+cVbFOc94KJ3" +
       "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" +
       "ca9Hk5uKOdI2miLJYHtTo9rkmHTtutO1xqgiuCYxqq1b8FxsrUO7ldRUyVBW" +
       "Q00QiJ4lkGsEq3VHEzFVlCLMO5UiFMrFsghmxiTh3fKAnmtIGe+2DJGOYr0b" +
       "D2PHM2Ac66VGpdsnh6klTRzWdWeM1u1ztRVcX/cF2QjE4tq3FlYNI5aVDb6w" +
       "Uwvl0vWyHI4lvxE355OVlbAGa7fLmzFL1DYNOHWt+lySe76oDaRQ0RZ0qz73" +
       "1YHSgWqLEsVPXQMfMjGhje2QdVgoCT2cGlSWbEgG0bgEKbWobnhoTSZCf5gI" +
       "JTvVaobdF+zSol6WSi6PVsXYRzmztnTdqtmihVB1+x1xw8oN37PmnXql359I" +
       "6lTrNd1WP1QbEF7XrAG5dMUiF0Iy7hZLjcAc4sloTlie0VPNYFDuAyMjHtdF" +
       "ybo99820b9LhDGFKoVpyRvGIaHIbZVkmvBK3wjlhvQ5DshlA8tJZNJOogiSp" +
       "6LGlgSVzCNuyLG64UIhQHdeLZRRuc8IwtC2O5TSUFtl6OEemZCNs6xW7QxWp" +
       "aSXhWbZHNBgsrdPByjZ7tRLuY5TqGGRpNBc3Kg3w+WotNrv1wPT7UQK33Tq3" +
       "gZrNYNhPW2IyM62g35y3PR6qeh2U11aDQbXeFMYteJ1C5WZ1JCOzatyJMTmK" +
       "bAh22YFQXVWDGEs5uQHNBoLlTMHM8IuwI1dGtVoqN0USo2hJ6I+6Glg5S8tq" +
       "U4XEVsy0jJSdY8VJ3+15ZdjpFSeE7IvtZNglo5qOWPpoTaWQUhdNaZbA45Si" +
       "+wgpJ1V1pXKIEK88aqOw+KDBtHrlWdLj6j1TxKJmT4t1eLz0agYrbkIRB7xC" +
       "zt15DR+Yo5iYWJ4YWXW6LhlEPNYmC98eCAhLNNdET69MyrIT9Puq3U0n+HBW" +
       "bnQXUgcsPuK6wuGDYbgyKDFsTAjbZRZao1QsEUu91A1YqZ9EBDNIDB3HBmuV" +
       "bHnT3nAlDVuCF618WJYHLV8gq6Nl1BrHI69JxhRsQMDz1KDJKIrmNFvr0Qoa" +
       "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" +
       "xAwxtNsOXIPUOGm6mFVWRssQ2GAB2Mrp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("2VI5DMuzVli05mmrRtALvuo6E6XaYfqMSPcqcU1ulEyvYkAdFx91VkMqXjmK" +
       "ZI6qrOclZs1HZanhLklPs0wyJuPurCQiA6rpmgaIncfJACgAJuLZnNLipaKt" +
       "63UmkR2szCkruLMi20RryjMCXcXLRGBLKtEcekza6cijDV1qJDTUwm1rPCl3" +
       "BGnTGKxrm3oVQiC/qqKD1WiC5E/bvn5rj7nuz5/eHR81/DGe221Ovcw4ftiZ" +
       "/2WvRa/s7q/sPew89Xb+4Ohp7GPZ09i4Kp5+CHvqTFb2fuvRmx00zN9tff7j" +
       "L74kjX+9fG73wsMLC3eFjvsTpryWzWvOA2T36bWPZks5mu3fZv/R7Ik+znwu" +
       "e8bLl2+eUfbtLPnTsPAO3dbD/M2YjJgmrq9lJAx9XYhCObjhQ8e1o0snVvqz" +
       "WzkfsaeCe7LM7BX+CzsVvHArKggLd7q+vuZD+TX18D/PKPt+lnwnLDx8oodr" +
       "lZCV//kJ4L94A4AfyDKz42S/vAP8y7dq8w+8Jta/OqPsr7PkL8PCPaoc4o4I" +
       "osvd+0PkBN8P3wC+J7LMrPzXdvh+7U3Hd3D+jLILWXKwxUfsv3d59w1m+g1e" +
       "thxr4uDcG9VEHVxf2GniC2++JvZPSp0ueyhLLoaFB3ea2Htrc3D3CcxLbwBm" +
       "dhi48Di4XtnBfOXNh3n5jLInsuQdgJQAzOWRoR8/w9DbV7on4N/5ZoD/8g78" +
       "l9988IdnlGUvzg6e3oJns/srJ7ieeaO4ngLXV3e4vvrm43rfGWXZ8YSDeli4" +
       "AHAtdi+ZT2NrvFFs2fH1r+2wfe3Nx9Y7o2yQJQgIEQC2wdHb6tPg2m8A3INZ" +
       "Znb66Rs7cN+4VXCvGVIcTM8oy6K8AwKsy7Yck450fAbn0ukJeVyQwyXfANxs" +
       "6hVa4PrjHdw/fvPhPndGmZAlHwKRA7Dl/mnA4xN+yxOsH76lo6RAbfsfCGRH" +
       "nR++7tuk7fc04hdfunjh7S8x/3F7nu7om5e78MIFJTLN06crT92fd31Z0XMt" +
       "3LU9a5kfZDvQAaqbHVMIC7eBNF9FtG1tMyy89Ua1QU2Qnq7p7JzhdM2wcEf+" +
       "/3Q9PyzcfVIvLJzf3pyuEoHeQZXsdu0eeVrxrLMVfZ93NV0MjkL77R7g4dPO" +
       "lUdAD7yWnY6bnD6Fn50ayz8vOzrhFW0/MLsqfumlIfmxHzR+ffsVgGjyaZr1" +
       "cgEv3Ln9ICHvNDsl9vhNezvq6/zg6R/d98pdTx3tNu7bCnzi6Kdke9eNz9t3" +
       "LTfMT8in//rt//L9v/nSN/NTC/8PqMmmdvc3AAA=");
}
