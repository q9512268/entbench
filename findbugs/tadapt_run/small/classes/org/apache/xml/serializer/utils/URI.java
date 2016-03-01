package org.apache.xml.serializer.utils;
final class URI {
    public static class MalformedURIException extends java.io.IOException {
        public MalformedURIException() { super(); }
        public MalformedURIException(java.lang.String p_msg) { super(p_msg);
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1444739587000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1XbWwUxxmeO39gH8Znm9gQiAkxRyQIuS35VGoqPlxTjp7x" +
                                                                  "yQ5ItdMcc7tzvoW93WFnDq+hlFCpDcqPKBIkpZHwL6JIUZpEUaL2T5CrSkmq" +
                                                                  "NI1IozZJ1bRV/7RqkcKf0Ip+vTOze7u3d4b86kk7tzvzzjvv5/O+8/JV1MFc" +
                                                                  "NEKxbeAsX6CEZQvivYBdRowxCzP2KMwW9af+dO709V93n0mizhnUW8FsQseM" +
                                                                  "7DWJZbAZNGzajGNbJ+wAIYbYUXAJI+5xzE3HnkGDJstVqWXqJp9wDCIIDmE3" +
                                                                  "j/ox565ZqnGS8xlwdGdeSqNJabTdcYLRPOrRHboQbljXsGEssiZoq+F5jKO+" +
                                                                  "/BF8HGs1blpa3mR81HPRPdSxFuYsh2eJx7NHrAd9Q+zPP9hkhpHX0l/ceKbS" +
                                                                  "J82wGtu2w6WKbIowxzpOjDxKh7PjFqmyY+i7qC2PVkaIOcrkg0M1OFSDQwN9" +
                                                                  "QyqQfhWxa9UxR6rDA06dVBcCcXRXIxOKXVz12RSkzMChi/u6y82g7ca6toG7" +
                                                                  "Yyo+e492/oeP973ehtIzKG3a00IcHYTgcMgMGJRUS8Rluw2DGDOo3waHTxPX" +
                                                                  "xJZ5wvf2ADPnbMxrEAKBWcRkjRJXnhnaCjwJurk1nTtuXb2yDCr/q6Ns4TnQ" +
                                                                  "dSjUVWm4V8yDgikTBHPLGGLP39J+1LQNGUeNO+o6Zr4JBLB1RZXwilM/qt3G" +
                                                                  "MIEGVIhY2J7TpiH47Dkg7XAgBF0Za8swFbamWD+K50iRo7VxuoJaAqpuaQix" +
                                                                  "haPBOJnkBF5aF/NSxD9XD+x4+qS9z06iBMhsEN0S8q+ETRtim6ZImbgE8kBt" +
                                                                  "7Nmafw4PvXU2iRAQD8aIFc1PvnNt17YNS+8qmvUtaCZLR4jOi/qlUu+VO8a2" +
                                                                  "PNImxOiiDjOF8xs0l1lW8FdGPQpIM1TnKBazweLS1NvfeuIl8rckSuVQp+5Y" +
                                                                  "tSrEUb/uVKlpEfcbxCYu5sTIoW5iG2NyPYdWwHvetImanSyXGeE51G7JqU5H" +
                                                                  "foOJysBCmCgF76ZddoJ3inlFvnsUIdQHDxqEJ4fUT/5zZGgVp0o0rGPbtB2t" +
                                                                  "4DpCf+FQiTmEwbsBq9TRPAxBc++R4n3Fh4v3aczVNced0zBERYVoXtXSmJ8n" +
                                                                  "xJW2YdrBqVxWRBv9P53jCX1XzycS4Io74kBgQQ7tcyyDuEX9fG3P+LVXiu+p" +
                                                                  "IBOJ4VuKo0fgsKw6LAuHZcPDpE9ZFg7LTGCr7LhVYsDHuKcTKryMEgl58m1C" +
                                                                  "FBUA4L6jAASAxD1bpr+9//DZkTaIPDrfDrZPAundTZVpLESMAOaL+stXpq5/" +
                                                                  "8H7qpSRKAqiUoDKF5SHTUB5UdXMdnRiAT8sVigAsteVLQ0s50NKF+TOHTn9F" +
                                                                  "yhFFfMGwA8BKbC8InK4fkYlneiu+6Sf/8sWrz51ywpxvKCFB5WvaKaBkJO7n" +
                                                                  "uPJFfetG/GbxrVOZJGoHfAJM5hhyCOBuQ/yMBkgZDeBZ6NIFCguXY0ssBZia" +
                                                                  "4hXXmQ9nZAD2y/fbwMUrRY5thKfgJ538F6tDVIxrVMCKmIlpIeH/a9P04se/" +
                                                                  "+uv90txBpUhHSvw04aMRdBLMBiQO9Ych+KhLCND9/kLh3LNXn5yV8QcUm1od" +
                                                                  "mBHjGKASuBDM/P13j33yh88ufZSsx2yCQ3mulaDT8epKinmUuomSIs5DeQDd" +
                                                                  "LMh8ETWZgzZEpVk2cckiIkn+ld68/c2/P92n4sCCmSCMtt2aQTh/+x70xHuP" +
                                                                  "X98g2SR0UV1Dm4VkCrJXh5x3uy5eEHJ4Zz4c/tE7+CKAPwAug+SXGIqkDZB0" +
                                                                  "2gNSf02O98fWHhJDhkWDvzG/Il1QUX/mo89XHfr88jUpbWMbFfX1BKajKrzE" +
                                                                  "sNkD9mviQLMPswrQPbB04LE+a+kGcJwBjjr0DmzSBeDzGiLDp+5Y8enPfj50" +
                                                                  "+EobSu5FKcvBxl4skwx1Q3QTVgHM9OjOXcq5811BMfFQk/LCnne29tR4lXJp" +
                                                                  "2xM/XfPGjhcXP5NBJTkMN+fLrB9Ks63zRYx3i2FrcxQutzXmr4SKZ/m9Fhpn" +
                                                                  "KbVoirKqKZInjd/EyTkx7JJLD4tht8qIr345Q4mJnWrHen9OaSXHLWLYpqqE" +
                                                                  "eL0X0o7JPjVMu6TYlI4X9LjCdeYuGl6u55L94qXvnV80Jl/YrjqjgcY+Zhza" +
                                                                  "9B//5t+/zF744y9alMxOv2eOHgjNX8siGRh805cosyD02qZ2XrWg+iuL6a41" +
                                                                  "iwd/KzG93ib2ABqWa5ZVFy8qqrhauKRsSvf1qFyi8u8xaKdvIQ9HHfJfyj+r" +
                                                                  "tkEjfPuy2zhKhR/RXSWOeht3cYC4qhWlgbqeCmnAwuolSlKBXUAiXk0aWFWB" +
                                                                  "melkc5N1i3uJ5jCTETt4q4iNBM+mBiSTVzHfIxM1dRkr6q8u7j9w8tpDL6hy" +
                                                                  "BZe4Eydk6w43EVU5603BXctyC3h17ttyo/e17s1JP9v6lcBh+q+PpOJOSGQq" +
                                                                  "sGddDMtZpg7pn1zacfn9s50fQvjOogQGU81GLkKq64eCUAMAm81Hu7LIhV6W" +
                                                                  "mdHUnw9/8I9PEwMSwCSGiKvJTXYU9XOXf1coU/p8EnXnUAdkG/Fm4GbHvr5g" +
                                                                  "TxH9OEBtV802j9VIDi6NnSWnZtdvbb0itLFAJGkZ36Cr6rOi3eFopOk+1qIF" +
                                                                  "BGyfJ+4ewV2wWdWYG6kapdFVT9xmWmgFvtl+8Z+nf/DxJKReg+BRbitYrSSo" +
                                                                  "/YPCS6HiLcY+BWX/hV8Cnv+IR7hUTKi7ycCYf0HaWL8hUeqptbZifoJSn7Zt" +
                                                                  "WIYBpRL5TkvGJ8VwyhMUHCW2Uvo/1YWQVA0SAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private static final java.lang.String
      RESERVED_CHARACTERS =
      ";/?:@&=+$,";
    private static final java.lang.String
      MARK_CHARACTERS =
      "-_.!~*\'() ";
    private static final java.lang.String
      SCHEME_CHARACTERS =
      "+-.";
    private static final java.lang.String
      USERINFO_CHARACTERS =
      ";:&=+$,";
    private java.lang.String m_scheme = null;
    private java.lang.String m_userinfo =
      null;
    private java.lang.String m_host = null;
    private int m_port = -1;
    private java.lang.String m_path = null;
    private java.lang.String m_queryString =
      null;
    private java.lang.String m_fragment =
      null;
    private static boolean DEBUG = false;
    public URI() { super(); }
    public URI(org.apache.xml.serializer.utils.URI p_other) {
        super(
          );
        initialize(
          p_other);
    }
    public URI(java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        this(
          (org.apache.xml.serializer.utils.URI)
            null,
          p_uriSpec);
    }
    public URI(org.apache.xml.serializer.utils.URI p_base,
               java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        super(
          );
        initialize(
          p_base,
          p_uriSpec);
    }
    public URI(java.lang.String p_scheme,
               java.lang.String p_schemeSpecificPart)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        super(
          );
        if (p_scheme ==
              null ||
              p_scheme.
              trim(
                ).
              length(
                ) ==
              0) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              "Cannot construct URI with null/empty scheme!");
        }
        if (p_schemeSpecificPart ==
              null ||
              p_schemeSpecificPart.
              trim(
                ).
              length(
                ) ==
              0) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              "Cannot construct URI with null/empty scheme-specific part!");
        }
        setScheme(
          p_scheme);
        setPath(
          p_schemeSpecificPart);
    }
    public URI(java.lang.String p_scheme,
               java.lang.String p_host,
               java.lang.String p_path,
               java.lang.String p_queryString,
               java.lang.String p_fragment)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        this(
          p_scheme,
          null,
          p_host,
          -1,
          p_path,
          p_queryString,
          p_fragment);
    }
    public URI(java.lang.String p_scheme,
               java.lang.String p_userinfo,
               java.lang.String p_host,
               int p_port,
               java.lang.String p_path,
               java.lang.String p_queryString,
               java.lang.String p_fragment)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        super(
          );
        if (p_scheme ==
              null ||
              p_scheme.
              trim(
                ).
              length(
                ) ==
              0) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_SCHEME_REQUIRED,
                  null));
        }
        if (p_host ==
              null) {
            if (p_userinfo !=
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_NO_USERINFO_IF_NO_HOST,
                      null));
            }
            if (p_port !=
                  -1) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_NO_PORT_IF_NO_HOST,
                      null));
            }
        }
        if (p_path !=
              null) {
            if (p_path.
                  indexOf(
                    '?') !=
                  -1 &&
                  p_queryString !=
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_NO_QUERY_STRING_IN_PATH,
                      null));
            }
            if (p_path.
                  indexOf(
                    '#') !=
                  -1 &&
                  p_fragment !=
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_NO_FRAGMENT_STRING_IN_PATH,
                      null));
            }
        }
        setScheme(
          p_scheme);
        setHost(
          p_host);
        setPort(
          p_port);
        setUserinfo(
          p_userinfo);
        setPath(
          p_path);
        setQueryString(
          p_queryString);
        setFragment(
          p_fragment);
    }
    private void initialize(org.apache.xml.serializer.utils.URI p_other) {
        m_scheme =
          p_other.
            getScheme(
              );
        m_userinfo =
          p_other.
            getUserinfo(
              );
        m_host =
          p_other.
            getHost(
              );
        m_port =
          p_other.
            getPort(
              );
        m_path =
          p_other.
            getPath(
              );
        m_queryString =
          p_other.
            getQueryString(
              );
        m_fragment =
          p_other.
            getFragment(
              );
    }
    private void initialize(org.apache.xml.serializer.utils.URI p_base,
                            java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_base ==
              null &&
              (p_uriSpec ==
                 null ||
                 p_uriSpec.
                 trim(
                   ).
                 length(
                   ) ==
                 0)) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_CANNOT_INIT_URI_EMPTY_PARMS,
                  null));
        }
        if (p_uriSpec ==
              null ||
              p_uriSpec.
              trim(
                ).
              length(
                ) ==
              0) {
            initialize(
              p_base);
            return;
        }
        java.lang.String uriSpec =
          p_uriSpec.
          trim(
            );
        int uriSpecLen =
          uriSpec.
          length(
            );
        int index =
          0;
        int colonIndex =
          uriSpec.
          indexOf(
            ':');
        if (colonIndex <
              0) {
            if (p_base ==
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_NO_SCHEME_IN_URI,
                      new java.lang.Object[] { uriSpec }));
            }
        }
        else {
            initializeScheme(
              uriSpec);
            uriSpec =
              uriSpec.
                substring(
                  colonIndex +
                    1);
            uriSpecLen =
              uriSpec.
                length(
                  );
        }
        if (uriSpec.
              startsWith(
                "//")) {
            index +=
              2;
            int startPos =
              index;
            char testChar =
              '\000';
            while (index <
                     uriSpecLen) {
                testChar =
                  uriSpec.
                    charAt(
                      index);
                if (testChar ==
                      '/' ||
                      testChar ==
                      '?' ||
                      testChar ==
                      '#') {
                    break;
                }
                index++;
            }
            if (index >
                  startPos) {
                initializeAuthority(
                  uriSpec.
                    substring(
                      startPos,
                      index));
            }
            else {
                m_host =
                  "";
            }
        }
        initializePath(
          uriSpec.
            substring(
              index));
        if (p_base !=
              null) {
            if (m_path.
                  length(
                    ) ==
                  0 &&
                  m_scheme ==
                  null &&
                  m_host ==
                  null) {
                m_scheme =
                  p_base.
                    getScheme(
                      );
                m_userinfo =
                  p_base.
                    getUserinfo(
                      );
                m_host =
                  p_base.
                    getHost(
                      );
                m_port =
                  p_base.
                    getPort(
                      );
                m_path =
                  p_base.
                    getPath(
                      );
                if (m_queryString ==
                      null) {
                    m_queryString =
                      p_base.
                        getQueryString(
                          );
                }
                return;
            }
            if (m_scheme ==
                  null) {
                m_scheme =
                  p_base.
                    getScheme(
                      );
            }
            if (m_host ==
                  null) {
                m_userinfo =
                  p_base.
                    getUserinfo(
                      );
                m_host =
                  p_base.
                    getHost(
                      );
                m_port =
                  p_base.
                    getPort(
                      );
            }
            else {
                return;
            }
            if (m_path.
                  length(
                    ) >
                  0 &&
                  m_path.
                  startsWith(
                    "/")) {
                return;
            }
            java.lang.String path =
              new java.lang.String(
              );
            java.lang.String basePath =
              p_base.
              getPath(
                );
            if (basePath !=
                  null) {
                int lastSlash =
                  basePath.
                  lastIndexOf(
                    '/');
                if (lastSlash !=
                      -1) {
                    path =
                      basePath.
                        substring(
                          0,
                          lastSlash +
                            1);
                }
            }
            path =
              path.
                concat(
                  m_path);
            index =
              -1;
            while ((index =
                      path.
                        indexOf(
                          "/./")) !=
                     -1) {
                path =
                  path.
                    substring(
                      0,
                      index +
                        1).
                    concat(
                      path.
                        substring(
                          index +
                            3));
            }
            if (path.
                  endsWith(
                    "/.")) {
                path =
                  path.
                    substring(
                      0,
                      path.
                        length(
                          ) -
                        1);
            }
            index =
              -1;
            int segIndex =
              -1;
            java.lang.String tempString =
              null;
            while ((index =
                      path.
                        indexOf(
                          "/../")) >
                     0) {
                tempString =
                  path.
                    substring(
                      0,
                      path.
                        indexOf(
                          "/../"));
                segIndex =
                  tempString.
                    lastIndexOf(
                      '/');
                if (segIndex !=
                      -1) {
                    if (!tempString.
                          substring(
                            segIndex++).
                          equals(
                            "..")) {
                        path =
                          path.
                            substring(
                              0,
                              segIndex).
                            concat(
                              path.
                                substring(
                                  index +
                                    4));
                    }
                }
            }
            if (path.
                  endsWith(
                    "/..")) {
                tempString =
                  path.
                    substring(
                      0,
                      path.
                        length(
                          ) -
                        3);
                segIndex =
                  tempString.
                    lastIndexOf(
                      '/');
                if (segIndex !=
                      -1) {
                    path =
                      path.
                        substring(
                          0,
                          segIndex +
                            1);
                }
            }
            m_path =
              path;
        }
    }
    private void initializeScheme(java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        int uriSpecLen =
          p_uriSpec.
          length(
            );
        int index =
          0;
        java.lang.String scheme =
          null;
        char testChar =
          '\000';
        while (index <
                 uriSpecLen) {
            testChar =
              p_uriSpec.
                charAt(
                  index);
            if (testChar ==
                  ':' ||
                  testChar ==
                  '/' ||
                  testChar ==
                  '?' ||
                  testChar ==
                  '#') {
                break;
            }
            index++;
        }
        scheme =
          p_uriSpec.
            substring(
              0,
              index);
        if (scheme.
              length(
                ) ==
              0) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_NO_SCHEME_INURI,
                  null));
        }
        else {
            setScheme(
              scheme);
        }
    }
    private void initializeAuthority(java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        int index =
          0;
        int start =
          0;
        int end =
          p_uriSpec.
          length(
            );
        char testChar =
          '\000';
        java.lang.String userinfo =
          null;
        if (p_uriSpec.
              indexOf(
                '@',
                start) !=
              -1) {
            while (index <
                     end) {
                testChar =
                  p_uriSpec.
                    charAt(
                      index);
                if (testChar ==
                      '@') {
                    break;
                }
                index++;
            }
            userinfo =
              p_uriSpec.
                substring(
                  start,
                  index);
            index++;
        }
        java.lang.String host =
          null;
        start =
          index;
        while (index <
                 end) {
            testChar =
              p_uriSpec.
                charAt(
                  index);
            if (testChar ==
                  ':') {
                break;
            }
            index++;
        }
        host =
          p_uriSpec.
            substring(
              start,
              index);
        int port =
          -1;
        if (host.
              length(
                ) >
              0) {
            if (testChar ==
                  ':') {
                index++;
                start =
                  index;
                while (index <
                         end) {
                    index++;
                }
                java.lang.String portStr =
                  p_uriSpec.
                  substring(
                    start,
                    index);
                if (portStr.
                      length(
                        ) >
                      0) {
                    for (int i =
                           0;
                         i <
                           portStr.
                           length(
                             );
                         i++) {
                        if (!isDigit(
                               portStr.
                                 charAt(
                                   i))) {
                            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                              portStr +
                              " is invalid. Port should only contain digits!");
                        }
                    }
                    try {
                        port =
                          java.lang.Integer.
                            parseInt(
                              portStr);
                    }
                    catch (java.lang.NumberFormatException nfe) {
                        
                    }
                }
            }
        }
        setHost(
          host);
        setPort(
          port);
        setUserinfo(
          userinfo);
    }
    private void initializePath(java.lang.String p_uriSpec)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_uriSpec ==
              null) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              "Cannot initialize path from null string!");
        }
        int index =
          0;
        int start =
          0;
        int end =
          p_uriSpec.
          length(
            );
        char testChar =
          '\000';
        while (index <
                 end) {
            testChar =
              p_uriSpec.
                charAt(
                  index);
            if (testChar ==
                  '?' ||
                  testChar ==
                  '#') {
                break;
            }
            if (testChar ==
                  '%') {
                if (index +
                      2 >=
                      end ||
                      !isHex(
                         p_uriSpec.
                           charAt(
                             index +
                               1)) ||
                      !isHex(
                         p_uriSpec.
                           charAt(
                             index +
                               2))) {
                    throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                        createMessage(
                          org.apache.xml.serializer.utils.MsgKey.
                            ER_PATH_CONTAINS_INVALID_ESCAPE_SEQUENCE,
                          null));
                }
            }
            else
                if (!isReservedCharacter(
                       testChar) &&
                      !isUnreservedCharacter(
                         testChar)) {
                    if ('\\' !=
                          testChar)
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                            createMessage(
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_PATH_INVALID_CHAR,
                              new java.lang.Object[] { java.lang.String.
                                valueOf(
                                  testChar) }));
                }
            index++;
        }
        m_path =
          p_uriSpec.
            substring(
              start,
              index);
        if (testChar ==
              '?') {
            index++;
            start =
              index;
            while (index <
                     end) {
                testChar =
                  p_uriSpec.
                    charAt(
                      index);
                if (testChar ==
                      '#') {
                    break;
                }
                if (testChar ==
                      '%') {
                    if (index +
                          2 >=
                          end ||
                          !isHex(
                             p_uriSpec.
                               charAt(
                                 index +
                                   1)) ||
                          !isHex(
                             p_uriSpec.
                               charAt(
                                 index +
                                   2))) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Query string contains invalid escape sequence!");
                    }
                }
                else
                    if (!isReservedCharacter(
                           testChar) &&
                          !isUnreservedCharacter(
                             testChar)) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Query string contains invalid character:" +
                          testChar);
                    }
                index++;
            }
            m_queryString =
              p_uriSpec.
                substring(
                  start,
                  index);
        }
        if (testChar ==
              '#') {
            index++;
            start =
              index;
            while (index <
                     end) {
                testChar =
                  p_uriSpec.
                    charAt(
                      index);
                if (testChar ==
                      '%') {
                    if (index +
                          2 >=
                          end ||
                          !isHex(
                             p_uriSpec.
                               charAt(
                                 index +
                                   1)) ||
                          !isHex(
                             p_uriSpec.
                               charAt(
                                 index +
                                   2))) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Fragment contains invalid escape sequence!");
                    }
                }
                else
                    if (!isReservedCharacter(
                           testChar) &&
                          !isUnreservedCharacter(
                             testChar)) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Fragment contains invalid character:" +
                          testChar);
                    }
                index++;
            }
            m_fragment =
              p_uriSpec.
                substring(
                  start,
                  index);
        }
    }
    public java.lang.String getScheme() {
        return m_scheme;
    }
    public java.lang.String getSchemeSpecificPart() {
        java.lang.StringBuffer schemespec =
          new java.lang.StringBuffer(
          );
        if (m_userinfo !=
              null ||
              m_host !=
              null ||
              m_port !=
              -1) {
            schemespec.
              append(
                "//");
        }
        if (m_userinfo !=
              null) {
            schemespec.
              append(
                m_userinfo);
            schemespec.
              append(
                '@');
        }
        if (m_host !=
              null) {
            schemespec.
              append(
                m_host);
        }
        if (m_port !=
              -1) {
            schemespec.
              append(
                ':');
            schemespec.
              append(
                m_port);
        }
        if (m_path !=
              null) {
            schemespec.
              append(
                m_path);
        }
        if (m_queryString !=
              null) {
            schemespec.
              append(
                '?');
            schemespec.
              append(
                m_queryString);
        }
        if (m_fragment !=
              null) {
            schemespec.
              append(
                '#');
            schemespec.
              append(
                m_fragment);
        }
        return schemespec.
          toString(
            );
    }
    public java.lang.String getUserinfo() {
        return m_userinfo;
    }
    public java.lang.String getHost() { return m_host;
    }
    public int getPort() { return m_port;
    }
    public java.lang.String getPath(boolean p_includeQueryString,
                                    boolean p_includeFragment) {
        java.lang.StringBuffer pathString =
          new java.lang.StringBuffer(
          m_path);
        if (p_includeQueryString &&
              m_queryString !=
              null) {
            pathString.
              append(
                '?');
            pathString.
              append(
                m_queryString);
        }
        if (p_includeFragment &&
              m_fragment !=
              null) {
            pathString.
              append(
                '#');
            pathString.
              append(
                m_fragment);
        }
        return pathString.
          toString(
            );
    }
    public java.lang.String getPath() { return m_path;
    }
    public java.lang.String getQueryString() {
        return m_queryString;
    }
    public java.lang.String getFragment() {
        return m_fragment;
    }
    public void setScheme(java.lang.String p_scheme)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_scheme ==
              null) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_SCHEME_FROM_NULL_STRING,
                  null));
        }
        if (!isConformantSchemeName(
               p_scheme)) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_SCHEME_NOT_CONFORMANT,
                  null));
        }
        m_scheme =
          p_scheme.
            toLowerCase(
              );
    }
    public void setUserinfo(java.lang.String p_userinfo)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_userinfo ==
              null) {
            m_userinfo =
              null;
        }
        else {
            if (m_host ==
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  "Userinfo cannot be set when host is null!");
            }
            int index =
              0;
            int end =
              p_userinfo.
              length(
                );
            char testChar =
              '\000';
            while (index <
                     end) {
                testChar =
                  p_userinfo.
                    charAt(
                      index);
                if (testChar ==
                      '%') {
                    if (index +
                          2 >=
                          end ||
                          !isHex(
                             p_userinfo.
                               charAt(
                                 index +
                                   1)) ||
                          !isHex(
                             p_userinfo.
                               charAt(
                                 index +
                                   2))) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Userinfo contains invalid escape sequence!");
                    }
                }
                else
                    if (!isUnreservedCharacter(
                           testChar) &&
                          USERINFO_CHARACTERS.
                          indexOf(
                            testChar) ==
                          -1) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Userinfo contains invalid character:" +
                          testChar);
                    }
                index++;
            }
        }
        m_userinfo =
          p_userinfo;
    }
    public void setHost(java.lang.String p_host)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_host ==
              null ||
              p_host.
              trim(
                ).
              length(
                ) ==
              0) {
            m_host =
              p_host;
            m_userinfo =
              null;
            m_port =
              -1;
        }
        else
            if (!isWellFormedAddress(
                   p_host)) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_HOST_ADDRESS_NOT_WELLFORMED,
                      null));
            }
        m_host =
          p_host;
    }
    public void setPort(int p_port) throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_port >=
              0 &&
              p_port <=
              65535) {
            if (m_host ==
                  null) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_PORT_WHEN_HOST_NULL,
                      null));
            }
        }
        else
            if (p_port !=
                  -1) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_INVALID_PORT,
                      null));
            }
        m_port =
          p_port;
    }
    public void setPath(java.lang.String p_path)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_path ==
              null) {
            m_path =
              null;
            m_queryString =
              null;
            m_fragment =
              null;
        }
        else {
            initializePath(
              p_path);
        }
    }
    public void appendPath(java.lang.String p_addToPath)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_addToPath ==
              null ||
              p_addToPath.
              trim(
                ).
              length(
                ) ==
              0) {
            return;
        }
        if (!isURIString(
               p_addToPath)) {
            throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
              org.apache.xml.serializer.utils.Utils.
                messages.
                createMessage(
                  org.apache.xml.serializer.utils.MsgKey.
                    ER_PATH_INVALID_CHAR,
                  new java.lang.Object[] { p_addToPath }));
        }
        if (m_path ==
              null ||
              m_path.
              trim(
                ).
              length(
                ) ==
              0) {
            if (p_addToPath.
                  startsWith(
                    "/")) {
                m_path =
                  p_addToPath;
            }
            else {
                m_path =
                  "/" +
                  p_addToPath;
            }
        }
        else
            if (m_path.
                  endsWith(
                    "/")) {
                if (p_addToPath.
                      startsWith(
                        "/")) {
                    m_path =
                      m_path.
                        concat(
                          p_addToPath.
                            substring(
                              1));
                }
                else {
                    m_path =
                      m_path.
                        concat(
                          p_addToPath);
                }
            }
            else {
                if (p_addToPath.
                      startsWith(
                        "/")) {
                    m_path =
                      m_path.
                        concat(
                          p_addToPath);
                }
                else {
                    m_path =
                      m_path.
                        concat(
                          "/" +
                          p_addToPath);
                }
            }
    }
    public void setQueryString(java.lang.String p_queryString)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_queryString ==
              null) {
            m_queryString =
              null;
        }
        else
            if (!isGenericURI(
                   )) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  "Query string can only be set for a generic URI!");
            }
            else
                if (getPath(
                      ) ==
                      null) {
                    throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                      "Query string cannot be set when path is null!");
                }
                else
                    if (!isURIString(
                           p_queryString)) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          "Query string contains invalid character!");
                    }
                    else {
                        m_queryString =
                          p_queryString;
                    }
    }
    public void setFragment(java.lang.String p_fragment)
          throws org.apache.xml.serializer.utils.URI.MalformedURIException {
        if (p_fragment ==
              null) {
            m_fragment =
              null;
        }
        else
            if (!isGenericURI(
                   )) {
                throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                  org.apache.xml.serializer.utils.Utils.
                    messages.
                    createMessage(
                      org.apache.xml.serializer.utils.MsgKey.
                        ER_FRAG_FOR_GENERIC_URI,
                      null));
            }
            else
                if (getPath(
                      ) ==
                      null) {
                    throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                      org.apache.xml.serializer.utils.Utils.
                        messages.
                        createMessage(
                          org.apache.xml.serializer.utils.MsgKey.
                            ER_FRAG_WHEN_PATH_NULL,
                          null));
                }
                else
                    if (!isURIString(
                           p_fragment)) {
                        throw new org.apache.xml.serializer.utils.URI.MalformedURIException(
                          org.apache.xml.serializer.utils.Utils.
                            messages.
                            createMessage(
                              org.apache.xml.serializer.utils.MsgKey.
                                ER_FRAG_INVALID_CHAR,
                              null));
                    }
                    else {
                        m_fragment =
                          p_fragment;
                    }
    }
    public boolean equals(java.lang.Object p_test) {
        if (p_test instanceof org.apache.xml.serializer.utils.URI) {
            org.apache.xml.serializer.utils.URI testURI =
              (org.apache.xml.serializer.utils.URI)
                p_test;
            if ((m_scheme ==
                   null &&
                   testURI.
                     m_scheme ==
                   null ||
                   m_scheme !=
                   null &&
                   testURI.
                     m_scheme !=
                   null &&
                   m_scheme.
                   equals(
                     testURI.
                       m_scheme)) &&
                  (m_userinfo ==
                     null &&
                     testURI.
                       m_userinfo ==
                     null ||
                     m_userinfo !=
                     null &&
                     testURI.
                       m_userinfo !=
                     null &&
                     m_userinfo.
                     equals(
                       testURI.
                         m_userinfo)) &&
                  (m_host ==
                     null &&
                     testURI.
                       m_host ==
                     null ||
                     m_host !=
                     null &&
                     testURI.
                       m_host !=
                     null &&
                     m_host.
                     equals(
                       testURI.
                         m_host)) &&
                  m_port ==
                  testURI.
                    m_port &&
                  (m_path ==
                     null &&
                     testURI.
                       m_path ==
                     null ||
                     m_path !=
                     null &&
                     testURI.
                       m_path !=
                     null &&
                     m_path.
                     equals(
                       testURI.
                         m_path)) &&
                  (m_queryString ==
                     null &&
                     testURI.
                       m_queryString ==
                     null ||
                     m_queryString !=
                     null &&
                     testURI.
                       m_queryString !=
                     null &&
                     m_queryString.
                     equals(
                       testURI.
                         m_queryString)) &&
                  (m_fragment ==
                     null &&
                     testURI.
                       m_fragment ==
                     null ||
                     m_fragment !=
                     null &&
                     testURI.
                       m_fragment !=
                     null &&
                     m_fragment.
                     equals(
                       testURI.
                         m_fragment))) {
                return true;
            }
        }
        return false;
    }
    public java.lang.String toString() { java.lang.StringBuffer uriSpecString =
                                           new java.lang.StringBuffer(
                                           );
                                         if (m_scheme !=
                                               null) {
                                             uriSpecString.
                                               append(
                                                 m_scheme);
                                             uriSpecString.
                                               append(
                                                 ':');
                                         }
                                         uriSpecString.
                                           append(
                                             getSchemeSpecificPart(
                                               ));
                                         return uriSpecString.
                                           toString(
                                             );
    }
    public boolean isGenericURI() { return m_host !=
                                      null;
    }
    public static boolean isConformantSchemeName(java.lang.String p_scheme) {
        if (p_scheme ==
              null ||
              p_scheme.
              trim(
                ).
              length(
                ) ==
              0) {
            return false;
        }
        if (!isAlpha(
               p_scheme.
                 charAt(
                   0))) {
            return false;
        }
        char testChar;
        for (int i =
               1;
             i <
               p_scheme.
               length(
                 );
             i++) {
            testChar =
              p_scheme.
                charAt(
                  i);
            if (!isAlphanum(
                   testChar) &&
                  SCHEME_CHARACTERS.
                  indexOf(
                    testChar) ==
                  -1) {
                return false;
            }
        }
        return true;
    }
    public static boolean isWellFormedAddress(java.lang.String p_address) {
        if (p_address ==
              null) {
            return false;
        }
        java.lang.String address =
          p_address.
          trim(
            );
        int addrLength =
          address.
          length(
            );
        if (addrLength ==
              0 ||
              addrLength >
              255) {
            return false;
        }
        if (address.
              startsWith(
                ".") ||
              address.
              startsWith(
                "-")) {
            return false;
        }
        int index =
          address.
          lastIndexOf(
            '.');
        if (address.
              endsWith(
                ".")) {
            index =
              address.
                substring(
                  0,
                  index).
                lastIndexOf(
                  '.');
        }
        if (index +
              1 <
              addrLength &&
              isDigit(
                p_address.
                  charAt(
                    index +
                      1))) {
            char testChar;
            int numDots =
              0;
            for (int i =
                   0;
                 i <
                   addrLength;
                 i++) {
                testChar =
                  address.
                    charAt(
                      i);
                if (testChar ==
                      '.') {
                    if (!isDigit(
                           address.
                             charAt(
                               i -
                                 1)) ||
                          i +
                          1 <
                          addrLength &&
                          !isDigit(
                             address.
                               charAt(
                                 i +
                                   1))) {
                        return false;
                    }
                    numDots++;
                }
                else
                    if (!isDigit(
                           testChar)) {
                        return false;
                    }
            }
            if (numDots !=
                  3) {
                return false;
            }
        }
        else {
            char testChar;
            for (int i =
                   0;
                 i <
                   addrLength;
                 i++) {
                testChar =
                  address.
                    charAt(
                      i);
                if (testChar ==
                      '.') {
                    if (!isAlphanum(
                           address.
                             charAt(
                               i -
                                 1))) {
                        return false;
                    }
                    if (i +
                          1 <
                          addrLength &&
                          !isAlphanum(
                             address.
                               charAt(
                                 i +
                                   1))) {
                        return false;
                    }
                }
                else
                    if (!isAlphanum(
                           testChar) &&
                          testChar !=
                          '-') {
                        return false;
                    }
            }
        }
        return true;
    }
    private static boolean isDigit(char p_char) {
        return p_char >=
          '0' &&
          p_char <=
          '9';
    }
    private static boolean isHex(char p_char) {
        return isDigit(
                 p_char) ||
          p_char >=
          'a' &&
          p_char <=
          'f' ||
          p_char >=
          'A' &&
          p_char <=
          'F';
    }
    private static boolean isAlpha(char p_char) {
        return p_char >=
          'a' &&
          p_char <=
          'z' ||
          p_char >=
          'A' &&
          p_char <=
          'Z';
    }
    private static boolean isAlphanum(char p_char) {
        return isAlpha(
                 p_char) ||
          isDigit(
            p_char);
    }
    private static boolean isReservedCharacter(char p_char) {
        return RESERVED_CHARACTERS.
          indexOf(
            p_char) !=
          -1;
    }
    private static boolean isUnreservedCharacter(char p_char) {
        return isAlphanum(
                 p_char) ||
          MARK_CHARACTERS.
          indexOf(
            p_char) !=
          -1;
    }
    private static boolean isURIString(java.lang.String p_uric) {
        if (p_uric ==
              null) {
            return false;
        }
        int end =
          p_uric.
          length(
            );
        char testChar =
          '\000';
        for (int i =
               0;
             i <
               end;
             i++) {
            testChar =
              p_uric.
                charAt(
                  i);
            if (testChar ==
                  '%') {
                if (i +
                      2 >=
                      end ||
                      !isHex(
                         p_uric.
                           charAt(
                             i +
                               1)) ||
                      !isHex(
                         p_uric.
                           charAt(
                             i +
                               2))) {
                    return false;
                }
                else {
                    i +=
                      2;
                    continue;
                }
            }
            if (isReservedCharacter(
                  testChar) ||
                  isUnreservedCharacter(
                    testChar)) {
                continue;
            }
            else {
                return false;
            }
        }
        return true;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "gtfYmoGxKDsaLtm2hVtDRokadgVMlAVx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
