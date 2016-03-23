package org.sunflow.system;
public class SearchPath {
    private java.util.LinkedList<java.lang.String> searchPath;
    private java.lang.String type;
    public SearchPath(java.lang.String type) { super();
                                               this.type = type;
                                               searchPath = new java.util.LinkedList<java.lang.String>(
                                                              ); }
    public void resetSearchPath() { searchPath.clear(); }
    public void addSearchPath(java.lang.String path) { java.io.File f =
                                                         new java.io.File(
                                                         path);
                                                       if (f.exists(
                                                               ) &&
                                                             f.
                                                             isDirectory(
                                                               )) {
                                                           try {
                                                               path =
                                                                 f.
                                                                   getCanonicalPath(
                                                                     );
                                                               for (java.lang.String prefix
                                                                     :
                                                                     searchPath)
                                                                   if (prefix.
                                                                         equals(
                                                                           path))
                                                                       return;
                                                               org.sunflow.system.UI.
                                                                 printInfo(
                                                                   org.sunflow.system.UI.Module.
                                                                     SYS,
                                                                   "Adding %s search path: \"%s\"",
                                                                   type,
                                                                   path);
                                                               searchPath.
                                                                 add(
                                                                   path);
                                                           }
                                                           catch (java.io.IOException e) {
                                                               org.sunflow.system.UI.
                                                                 printError(
                                                                   org.sunflow.system.UI.Module.
                                                                     SYS,
                                                                   "Invalid %s search path specification: \"%s\" - %s",
                                                                   type,
                                                                   path,
                                                                   e.
                                                                     getMessage(
                                                                       ));
                                                           }
                                                       }
                                                       else
                                                           org.sunflow.system.UI.
                                                             printError(
                                                               org.sunflow.system.UI.Module.
                                                                 SYS,
                                                               ("Invalid %s search path specification: \"%s\" - invalid direc" +
                                                                "tory"),
                                                               type,
                                                               path);
    }
    public java.lang.String resolvePath(java.lang.String filename) {
        if (filename.
              startsWith(
                "//"))
            filename =
              filename.
                substring(
                  2);
        org.sunflow.system.UI.
          printDetailed(
            org.sunflow.system.UI.Module.
              SYS,
            "Resolving %s path \"%s\" ...",
            type,
            filename);
        java.io.File f =
          new java.io.File(
          filename);
        if (!f.
              isAbsolute(
                )) {
            for (java.lang.String prefix
                  :
                  searchPath) {
                org.sunflow.system.UI.
                  printDetailed(
                    org.sunflow.system.UI.Module.
                      SYS,
                    "  * searching: \"%s\" ...",
                    prefix);
                if (prefix.
                      endsWith(
                        java.io.File.
                          separator) ||
                      filename.
                      startsWith(
                        java.io.File.
                          separator))
                    f =
                      new java.io.File(
                        prefix +
                        filename);
                else
                    f =
                      new java.io.File(
                        prefix +
                        java.io.File.
                          separator +
                        filename);
                if (f.
                      exists(
                        )) {
                    return f.
                      getAbsolutePath(
                        );
                }
            }
        }
        return filename;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "jdBi/GrFoKiFLtckvzXViKY7WHvJiNZnM4FrWMu4WlPFuSzPZlo7a1pNRKo3" +
       "gE/iSWwl10m9jqx7Y01qhVaf6hhi3a6rzMifxrJI1BEUoTJO1Vf1alRvK7tO" +
       "3unE5FAIq56rxbY3pnue2+hkidtb9jvwYI3nxk7xt3C8WoGshWw2iWjj7rbb" +
       "GeNSOzhwrf4qxpy80qxInfFC8wcSX+s2p2rkzNCdgcG1se13dHOdbi2AD/g1" +
       "t0Has7yzYIFoscDL3IpU22lbuCWk0hzNNTiQvVif1w2h5dJ+f8aM1spsNhbX" +
       "ZBxpStAfC8tt3TVnOTGz+q476WI21UvdsSNR5LaRSBTFLWx2sa6FjcoG3dWT" +
       "XGzrlaSBeylNGVkwqatyh5pPuoyBkeTOru4UgZeigWjBzUyiPKLSUuraqAa2" +
       "HXi8qmiTLF6rHCL3Ld7wh1ruDPhxk4MbaGrSjdq25dR2c7hRmwTqOqpW2doA" +
       "A5mnNR/pcQMmN8zWc4erScxtRGquek0ShdXqpOHQrWGOuFsvZG3f7dL+dOY2" +
       "B2I+mS/T7RjFaLzq1sO2JAlpvaaMnWZrNB8TC9cPJmk+rG3aRNSXe/J6nKMM" +
       "M7XVKsnFor0jY2S9xsyeFbR8byou2vB62ndH1lCvLfxshy9XTqeL9GrAQ9HG" +
       "erxqiOt2RBPt0XSt4aMF36nHM5oSSXy07GqdmrWT+g16EqSDqNfc8uHcBMIJ" +
       "J4RhdxBluMrBX1nXJokcUWi9so4HTFe3Bd9EGj2PXg9lgp2qMIrS7FrsbLw6" +
       "mlsG7I49c9OiyYHRj3KhyU2oukJj2tIE2R0I69Ulx8MgJM1WGt1stkQOLEqj" +
       "myJVDVfjZcQhg6a9m2eDUaWeLpx8lslgM+PndcEgWx0ClhszWO72lhlddVd8" +
       "hRmAbKwWK3hlJq/bbHveVHG8qqUwgWptOgwnzYW9MisbNm+jvkIaTTxFhkg/" +
       "9Um1RWycKtqIw2G2sRhYXUgjKVmuOgyKLzAlXMCI2chro4awYg18ovPzVSql" +
       "sAF0IffjTUwNFDjuOkg4k8AO+7uKrffL39zpx+Ploc7pW4J/xHHOvuv5onjX" +
       "6fFX+bkKXbh/PnvtdfaYLfChZ+71RKA8xfj0h155VZr/eO3y8Znch0LowdBx" +
       "v9OUY9k8g+rKG5+tz8oXEocrjM9/6E+eXn239v5v4sb27RfovIjyP89e++Lo" +
       "28R/dxm6cnqhccfbjfNAL144cfXlMPLt1bnLjGfO35o+vz/vPDn3vNut6b1P" +
       "Fb99v/ZvcBP3qTfo+49F8YkQuuHLgRweLtjLwS+dUZYPhtB9saNLBy36sTc7" +
       "Ozo7V9nw8fNsF3c4Tx6z/eQ/D9uXDgOq5YDX3oD3zxTFT4TQI4IkHTgvGv/T" +
       "gcuf/CdwWa7lM+D77mMu3/3/icufewMu/3tR/NcQesjfv2w64bF64PFnvxke" +
       "0xC6fpBWcav81B2vtvYvjcTPvHrjgbe+yvxu+Rbh9DXQg1PoASUyzbN3fWfq" +
       "V10f7P5K0h/c3/y55c8vhtDNO9+EFMfbZaWk8/X90F8G3J4ZGkLXjmtnB30+" +
       "hK6AQUX1C+VqCOml827sVD4330w+ZzzfO+95QzWL9g/fbouffZUgv+/rrR/f" +
       "v3UQTSHPCywPTKFr+2cXp/7p+XtiO8F1dfyebzz6Mw++68SXPron+KBYZ2h7" +
       "+90fFgwsNyyfAuQ/99affe9PvPrl8gz+7wG1CroYjygAAA==");
}
