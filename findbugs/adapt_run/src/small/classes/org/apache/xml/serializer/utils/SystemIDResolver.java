package org.apache.xml.serializer.utils;
public final class SystemIDResolver {
    public static java.lang.String getAbsoluteURIFromRelative(java.lang.String localPath) {
        if (localPath ==
              null ||
              localPath.
              length(
                ) ==
              0)
            return "";
        java.lang.String absolutePath =
          localPath;
        if (!isAbsolutePath(
               localPath)) {
            try {
                absolutePath =
                  getAbsolutePathFromRelativePath(
                    localPath);
            }
            catch (java.lang.SecurityException se) {
                return "file:" +
                localPath;
            }
        }
        java.lang.String urlString;
        if (null !=
              absolutePath) {
            if (absolutePath.
                  startsWith(
                    java.io.File.
                      separator))
                urlString =
                  "file://" +
                  absolutePath;
            else
                urlString =
                  "file:///" +
                  absolutePath;
        }
        else
            urlString =
              "file:" +
              localPath;
        return replaceChars(
                 urlString);
    }
    private static java.lang.String getAbsolutePathFromRelativePath(java.lang.String relativePath) {
        return new java.io.File(
          relativePath).
          getAbsolutePath(
            );
    }
    public static boolean isAbsoluteURI(java.lang.String systemId) {
        if (isWindowsAbsolutePath(
              systemId)) {
            return false;
        }
        final int fragmentIndex =
          systemId.
          indexOf(
            '#');
        final int queryIndex =
          systemId.
          indexOf(
            '?');
        final int slashIndex =
          systemId.
          indexOf(
            '/');
        final int colonIndex =
          systemId.
          indexOf(
            ':');
        int index =
          systemId.
          length(
            ) -
          1;
        if (fragmentIndex >
              0)
            index =
              fragmentIndex;
        if (queryIndex >
              0 &&
              queryIndex <
              index)
            index =
              queryIndex;
        if (slashIndex >
              0 &&
              slashIndex <
              index)
            index =
              slashIndex;
        return colonIndex >
          0 &&
          colonIndex <
          index;
    }
    public static boolean isAbsolutePath(java.lang.String systemId) {
        if (systemId ==
              null)
            return false;
        final java.io.File file =
          new java.io.File(
          systemId);
        return file.
          isAbsolute(
            );
    }
    private static boolean isWindowsAbsolutePath(java.lang.String systemId) {
        if (!isAbsolutePath(
               systemId))
            return false;
        if (systemId.
              length(
                ) >
              2 &&
              systemId.
              charAt(
                1) ==
              ':' &&
              java.lang.Character.
              isLetter(
                systemId.
                  charAt(
                    0)) &&
              (systemId.
                 charAt(
                   2) ==
                 '\\' ||
                 systemId.
                 charAt(
                   2) ==
                 '/'))
            return true;
        else
            return false;
    }
    private static java.lang.String replaceChars(java.lang.String str) {
        java.lang.StringBuffer buf =
          new java.lang.StringBuffer(
          str);
        int length =
          buf.
          length(
            );
        for (int i =
               0;
             i <
               length;
             i++) {
            char currentChar =
              buf.
              charAt(
                i);
            if (currentChar ==
                  ' ') {
                buf.
                  setCharAt(
                    i,
                    '%');
                buf.
                  insert(
                    i +
                      1,
                    "20");
                length =
                  length +
                    2;
                i =
                  i +
                    2;
            }
            else
                if (currentChar ==
                      '\\') {
                    buf.
                      setCharAt(
                        i,
                        '/');
                }
        }
        return buf.
          toString(
            );
    }
    public static java.lang.String getAbsoluteURI(java.lang.String systemId) {
        java.lang.String absoluteURI =
          systemId;
        if (isAbsoluteURI(
              systemId)) {
            if (systemId.
                  startsWith(
                    "file:")) {
                java.lang.String str =
                  systemId.
                  substring(
                    5);
                if (str !=
                      null &&
                      str.
                      startsWith(
                        "/")) {
                    if (str.
                          startsWith(
                            "///") ||
                          !str.
                          startsWith(
                            "//")) {
                        int secondColonIndex =
                          systemId.
                          indexOf(
                            ':',
                            5);
                        if (secondColonIndex >
                              0) {
                            java.lang.String localPath =
                              systemId.
                              substring(
                                secondColonIndex -
                                  1);
                            try {
                                if (!isAbsolutePath(
                                       localPath))
                                    absoluteURI =
                                      systemId.
                                        substring(
                                          0,
                                          secondColonIndex -
                                            1) +
                                      getAbsolutePathFromRelativePath(
                                        localPath);
                            }
                            catch (java.lang.SecurityException se) {
                                return systemId;
                            }
                        }
                    }
                }
                else {
                    return getAbsoluteURIFromRelative(
                             systemId.
                               substring(
                                 5));
                }
                return replaceChars(
                         absoluteURI);
            }
            else
                return systemId;
        }
        else
            return getAbsoluteURIFromRelative(
                     systemId);
    }
    public static java.lang.String getAbsoluteURI(java.lang.String urlString,
                                                  java.lang.String base)
          throws javax.xml.transform.TransformerException {
        if (base ==
              null)
            return getAbsoluteURI(
                     urlString);
        java.lang.String absoluteBase =
          getAbsoluteURI(
            base);
        org.apache.xml.serializer.utils.URI uri =
          null;
        try {
            org.apache.xml.serializer.utils.URI baseURI =
              new org.apache.xml.serializer.utils.URI(
              absoluteBase);
            uri =
              new org.apache.xml.serializer.utils.URI(
                baseURI,
                urlString);
        }
        catch (org.apache.xml.serializer.utils.URI.MalformedURIException mue) {
            throw new javax.xml.transform.TransformerException(
              mue);
        }
        return replaceChars(
                 uri.
                   toString(
                     ));
    }
    public SystemIDResolver() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "2ldk/o8F8qYpNu/fefGN/wL8NpSxnRwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae6zkVnn33mSTzZJkN4E8COS9UMLAtWc8TwVS5uV5eTwe" +
       "e8YznlIWv+3xc/we01CI1CYqVRq14VEF8kcLokSBoLaoqIgSVJWHoJWoKC1V" +
       "SxCtVFqKRP4oRaUtPfbce+feu5uNViHqSD5jH3/fd87ve/nzOX76h9BJz4Vy" +
       "jm2sFcP2d6XY310apV1/7Ujebh8vkZzrSWLT4DxvAvrOC/d8+syPf/qYenYH" +
       "umoBvZKzLNvnfM22PErybCOURBw6s+1tG5Lp+dBZfMmFHBz4mgHjmuffj0Ov" +
       "OMTqQ+fw/SnAYAowmAKcTQGub6kA03WSFZjNlIOzfG8FvRs6gUNXOUI6PR+6" +
       "+6gQh3M5c08MmSEAEk6l1wwAlTHHLnTXAfYN5gsAvz8HP/7Bd5z9wyugMwvo" +
       "jGbR6XQEMAkfDLKArjUlk5dcry6KkriAbrAkSaQlV+MMLcnmvYBu9DTF4vzA" +
       "lQ6UlHYGjuRmY241d62QYnMDwbfdA3iyJhni/tVJ2eAUgPXmLdYNQiztBwBP" +
       "a2BirswJ0j7LlbpmiT5053GOA4znBoAAsF5tSr5qHwx1pcWBDujGje0MzlJg" +
       "2nc1SwGkJ+0AjOJDt72g0FTXDifonCKd96Fbj9ORm1uA6ppMESmLD910nCyT" +
       "BKx02zErHbLPD4m3PPouq2vtZHMWJcFI538KMN1xjImSZMmVLEHaMF77RvwD" +
       "3M2ff2QHggDxTceINzR/8ivPv+1Ndzz7lQ3Nay5CM+KXkuCfFz7KX/+N1zbv" +
       "q12RTuOUY3taavwjyDP3J/fu3B87IPJuPpCY3tzdv/ks9SX2PU9JP9iBTveg" +
       "qwTbCEzgRzcItulohuR2JEtyOV8Se9A1kiU2s/s96GpwjmuWtOkdybIn+T3o" +
       "SiPrusrOroGKZCAiVdHV4FyzZHv/3OF8NTuPHQiCrgMHdCM43gxtftm/D61g" +
       "1TYlmBM4S7NsmHTtFH9qUEvkYF/ywLkI7jo2HHPAad68PF84XzlfgD1XgG1X" +
       "gTngFaoEx6YBe3txIrmZbjyYXnu+ZPZaexHh7qau5/x/DBqnmjgbnTgBjPTa" +
       "4ynCANHVtQ1Rcs8LjweN9vOfOv+1nYOQ2dOhDyFg5N3NyLtg5N3tyJm1vd3j" +
       "I0MnTmQDviqdwcYjgD11kBlAzrz2PvqX++985J4rgCs60ZXAGCkp/MKpu7nN" +
       "Jb0sYwrAoaFnPxS9l/lVZAfaOZqD01mDrtMpO5lmzoMMee547F1M7pmHv//j" +
       "Zz7woL2NwiNJfS85XMiZBvc9x/Xr2oIkgnS5Ff/Gu7jPnP/8g+d2oCtBxgBZ" +
       "0ueAV4MEdMfxMY4E+f37CTPFchIAlm3X5Iz01n6WO+2rrh1tezLDX5+d3wAd" +
       "+u0e/k/vvtJJ21dtHCU12jEUWUJ+K+185O/+6l/RTN37ufvMoachLfn3H8oX" +
       "qbAzWWa4YesDE1eSAN0/foj8nff/8OFfyhwAUNx7sQHPpW0T5AlgQqDmX/vK" +
       "6tvPfeej39zZOo0PHpgBb2hCvAH5M/A7AY7/TY8UXNqxifUbm3sJ566DjOOk" +
       "I79+OzeQewwQiqkHnZtapi1qssbxhpR67H+feV3+M//+6NmNTxigZ9+l3vTi" +
       "Arb9r25A7/naO/7zjkzMCSF99m31tyXbJNRXbiXXXZdbp/OI3/vXt//ul7mP" +
       "gNQM0qEHAjDLcFCmDygzIJLpIpe18LF7hbS50zscCEdj7VCNcl547Js/uo75" +
       "0Z89n832aJFz2O5Dzrl/42ppc1cMxN9yPOq7nKcCuuKzxNvPGs/+FEhcAIkC" +
       "eLJ7Ixckn/iIl+xRn7z677/45ze/8xtXQDsYdNqwORHjsoCDrgGeLnkqyFux" +
       "84tv23hzdAo0ZzOo0AXgNw5ya3Z1BZjgfS+ca7C0RtmG663/NTL4h773kwuU" +
       "kGWZizyaj/Ev4Kc/fFvzgR9k/NtwT7nviC9MyKCe2/IWnjL/Y+eeq/5iB7p6" +
       "AZ0V9opFhjOCNIgWoEDy9itIUFAeuX+02Nk82e8/SGevPZ5qDg17PNFsHwTg" +
       "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" +
       "yx+/5eNPfifbsvs/Q14V5SIoAAA=");
}
