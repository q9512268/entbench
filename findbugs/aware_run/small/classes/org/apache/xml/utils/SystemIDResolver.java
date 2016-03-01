package org.apache.xml.utils;
public class SystemIDResolver {
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
        org.apache.xml.utils.URI uri =
          null;
        try {
            org.apache.xml.utils.URI baseURI =
              new org.apache.xml.utils.URI(
              absoluteBase);
            uri =
              new org.apache.xml.utils.URI(
                baseURI,
                urlString);
        }
        catch (org.apache.xml.utils.URI.MalformedURIException mue) {
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
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/p3s2Oz/AKoj5t+FJwAA");
}
