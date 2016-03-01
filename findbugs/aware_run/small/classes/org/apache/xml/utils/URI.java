package org.apache.xml.utils;
public class URI implements java.io.Serializable {
    static final long serialVersionUID = 7096266377907081897L;
    public static class MalformedURIException extends java.io.IOException {
        public MalformedURIException() { super(); }
        public MalformedURIException(java.lang.String p_msg) { super(p_msg);
        }
        public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
        public static final long jlc$SourceLastModified$jl7 = 1444739587000L;
        public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVXbWwcxRmeO3/Evjg+24mdNCEhmAtSQrht+FTrVPlw7ebS" +
                                                                  "c3yySQQ25TK3O+fbZG93sjsbrw00BKkl4gdCSqApUvwrCAlRQAjU/iEyQmqp" +
                                                                  "KEWhqAWq0lb906qNRP6QVunXOzP7dXvn0D896ebmZt555/183ndevoI6HBsN" +
                                                                  "U2xqOM8WKHHyJT4vYdsh2qiBHed+WC2rT/3x7Klrv+o+nUadM6i3hp0JFTtk" +
                                                                  "XCeG5sygzbrpMGyqxDlEiMZPlGziEPskZrplzqBB3SnUqaGrOpuwNMIJjmC7" +
                                                                  "iPoxY7ZecRkp+AwYurkopFGENMq+JMFIEfWoFl2IDmxsODAa2+O09eg+h6G+" +
                                                                  "4jF8Eisu0w2lqDtsxLPR7dQyFuYMi+WJx/LHjHt8Qxws3tNkhuHXsl9cf6bW" +
                                                                  "J8ywFpumxYSKzhRxLOMk0YooG62OGaTunEDfRW1FtDpGzFCuGFyqwKUKXBro" +
                                                                  "G1GB9GuI6dZHLaEOCzh1UpULxNAtjUwotnHdZ1MSMgOHLubrLg6DtltDbQN3" +
                                                                  "J1R89nbl3A8e7nu9DWVnUFY3p7k4KgjB4JIZMCipV4jt7NM0os2gfhMcPk1s" +
                                                                  "HRv6ou/tAUefMzFzIQQCs/BFlxJb3BnZCjwJutmuyiw7VK8qgsr/11E18Bzo" +
                                                                  "OhTpKjUc5+ugYEYHwewqhtjzj7Qf101NxFHjiVDH3LeBAI6uqhNWs8Kr2k0M" +
                                                                  "C2hAhoiBzTllGoLPnAPSDgtC0BaxtgJTbmuK1eN4jpQZ2pCkK8ktoOoWhuBH" +
                                                                  "GBpMkglO4KWNCS/F/HPl0O6nHzEPmGmUApk1ohpc/tVwaEvi0BSpEptAHsiD" +
                                                                  "PTuKz+Ght86kEQLiwQSxpPnxo1f37tyy/K6k2dSCZrJyjKisrF6s9F6+aXT7" +
                                                                  "19q4GF3UcnTu/AbNRZaV/J0RjwLSDIUc+WY+2Fye+umDj79E/ppGmQLqVC3D" +
                                                                  "rUMc9atWneoGsb9FTGJjRrQC6iamNir2C2gVzIu6SeTqZLXqEFZA7YZY6rTE" +
                                                                  "fzBRFVhwE2VgrptVK5hTzGpi7lGEUB980SB8x5H8iF+GHlRqVp0oWMWmblpK" +
                                                                  "yba4/tyhAnOIA3MNdqmleBiC5o5j5TvL95XvVBxbVSx7TsEQFTWieHVDGMRR" +
                                                                  "Dk8V8jzE6P+Tucc1WzufSoHRb0qmvAHZcsAyNGKX1XPu/rGrr5Tfk+HEU8C3" +
                                                                  "CUN5uCEvb8jDDcJlTh5uyE1go2rZdaLBnzFPJZQ7EaVS4rp1/H7pX/DOcchz" +
                                                                  "ANqe7dPfOXj0zHAbBBadbwfTpoH0tqbCMxoBQoDiZfXly1PXPng/81IapQEz" +
                                                                  "KlB4IvTPNaC/LF62pRIN4GelOhBgobIy8reUAy2fnz995NRXhRxxQOcMOwCL" +
                                                                  "+PESh+HwilwykVvxzT755y9efe4xK0rphgoRFLamkxwphpPOTSpfVndsxW+W" +
                                                                  "33osl0btAD8AuQxDigCabUne0YAYIwH6cl26QGHucmzwrQAyM6xmW/PRioi6" +
                                                                  "fjFfBy5ezVNoK3wn/JwSv3x3iPJxvYxSHjMJLQS6f2OaXvj4l3+5S5g7KATZ" +
                                                                  "WAWfJmwkBj6c2YCAmf4oBO+3CQG6350vnX32ypOzIv6A4tZWF+b4OAqgAy4E" +
                                                                  "M3/v3ROf/P6zix+lw5hNMai+bgUaGS9Ukq+jzA2U5HEeyQPgZUCO86jJHTYh" +
                                                                  "KvWqjisG4Unyz+y2XW/+7ek+GQcGrARhtPPLGUTrX9mPHn/v4WtbBJuUyotn" +
                                                                  "ZLOITCLy2ojzPtvGC1wO7/SHm3/4M3wBsB3w1NEXiYBIJGyAhNPuFvorYrwr" +
                                                                  "sXcvH3JOPPgb8yvW5JTVZz76fM2Rzy9dFdI2dklxX09gOiLDiw/bPGC/Pgk0" +
                                                                  "B7BTA7q7lw891GcsXweOM8BRhdbAmbQB7byGyPCpO1Z9+vY7Q0cvt6H0OMoY" +
                                                                  "FtbGsUgy1A3RTZwaAKVH9+yVzp3vCmqFh5qU5/a8ubWnxuqUCdsu/mT9G7tf" +
                                                                  "XPpMBJXgsLk5Xx7wQ+mB1vnCx9v4sKM5Clc6mvBXSsaz+L8B+mIhNe958rLn" +
                                                                  "ETeN3cDJBT7sFVv38WGfzIiv/2+G4gt75IlN/prUSozb+bBTVgk+vQPSzhFt" +
                                                                  "aJR2aX4om6zXSYVD5jbavFJLJdrBi0+cW9ImX9glG5+BxjZlDLrwH/36X7/I" +
                                                                  "n//Dz1vUyU6/JY5fCL1dyyIZGHzDSrUVJN3Q1KLLtlJ9ZSnbtX7p8G8EkIet" +
                                                                  "Xw9AYNU1jFCmuHz8uWCTqi581iMTiIqfhxha10oIhjrEr5B0VtJCR9vbSMsA" +
                                                                  "lupGnKbCUCaiAavISZwEVtuAhE+rNLCEBCDdyhcmQyt5qebQEFE2+GVRFnP4" +
                                                                  "rQ3oI15HvkEnXPk+KquvLh089MjVe1+QJQbeVYuLopuGx4GsdmEhv2VFbgGv" +
                                                                  "zgPbr/e+1r0t7WdIvxQ4StlNsfTZA8lHOV5sTOCvkwth+JOLuy+9f6bzQwi5" +
                                                                  "WZTCYKrZ2NtENuIA4i6Azmwx3knF3tiiNIxk/nT0g79/mhoQoCPynr8WbnCi" +
                                                                  "rJ699NtSldLn06i7gDogQ4g3A48t55sL5hRRTwI8drmmfsIlBXjHdVYs1wwf" +
                                                                  "Ur08MjFHEWEZ36BrwlXeojA03PREatG2AR7PE3s/587ZrGkM7YxLaXzX4w+M" +
                                                                  "FlqBb3Zd+Mep7388CZnTIHic2yrHrXBq/6LonSZ587FPws9/4JOC77/5l7uU" +
                                                                  "L8jnwsCo/2bZGj5aKPXkXlu5OEGpT5t6QoQBpQKtHhWMxR2LHqdgKLWD0v8C" +
                                                                  "It8lhKARAAA=");
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
    public URI(org.apache.xml.utils.URI p_other) {
        super(
          );
        initialize(
          p_other);
    }
    public URI(java.lang.String p_uriSpec)
          throws org.apache.xml.utils.URI.MalformedURIException {
        this(
          (org.apache.xml.utils.URI)
            null,
          p_uriSpec);
    }
    public URI(org.apache.xml.utils.URI p_base,
               java.lang.String p_uriSpec)
          throws org.apache.xml.utils.URI.MalformedURIException {
        super(
          );
        initialize(
          p_base,
          p_uriSpec);
    }
    public URI(java.lang.String p_scheme,
               java.lang.String p_schemeSpecificPart)
          throws org.apache.xml.utils.URI.MalformedURIException {
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
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
          throws org.apache.xml.utils.URI.MalformedURIException {
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
          throws org.apache.xml.utils.URI.MalformedURIException {
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_SCHEME_REQUIRED,
                  null));
        }
        if (p_host ==
              null) {
            if (p_userinfo !=
                  null) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_NO_USERINFO_IF_NO_HOST,
                      null));
            }
            if (p_port !=
                  -1) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
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
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_NO_QUERY_STRING_IN_PATH,
                      null));
            }
            if (p_path.
                  indexOf(
                    '#') !=
                  -1 &&
                  p_fragment !=
                  null) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
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
    private void initialize(org.apache.xml.utils.URI p_other) {
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
    private void initialize(org.apache.xml.utils.URI p_base,
                            java.lang.String p_uriSpec)
          throws org.apache.xml.utils.URI.MalformedURIException {
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
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
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
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
            if (m_scheme !=
                  null &&
                  p_base !=
                  null) {
                if (uriSpec.
                      startsWith(
                        "/") ||
                      !m_scheme.
                      equals(
                        p_base.
                          m_scheme) ||
                      !p_base.
                      getSchemeSpecificPart(
                        ).
                      startsWith(
                        "/")) {
                    p_base =
                      null;
                }
            }
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
          throws org.apache.xml.utils.URI.MalformedURIException {
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_NO_SCHEME_INURI,
                  null));
        }
        else {
            setScheme(
              scheme);
        }
    }
    private void initializeAuthority(java.lang.String p_uriSpec)
          throws org.apache.xml.utils.URI.MalformedURIException {
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
                            throw new org.apache.xml.utils.URI.MalformedURIException(
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
          throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_uriSpec ==
              null) {
            throw new org.apache.xml.utils.URI.MalformedURIException(
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
                    throw new org.apache.xml.utils.URI.MalformedURIException(
                      org.apache.xml.res.XMLMessages.
                        createXMLMessage(
                          org.apache.xml.res.XMLErrorResources.
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
                        throw new org.apache.xml.utils.URI.MalformedURIException(
                          org.apache.xml.res.XMLMessages.
                            createXMLMessage(
                              org.apache.xml.res.XMLErrorResources.
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
                        throw new org.apache.xml.utils.URI.MalformedURIException(
                          "Query string contains invalid escape sequence!");
                    }
                }
                else
                    if (!isReservedCharacter(
                           testChar) &&
                          !isUnreservedCharacter(
                             testChar)) {
                        throw new org.apache.xml.utils.URI.MalformedURIException(
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
                        throw new org.apache.xml.utils.URI.MalformedURIException(
                          "Fragment contains invalid escape sequence!");
                    }
                }
                else
                    if (!isReservedCharacter(
                           testChar) &&
                          !isUnreservedCharacter(
                             testChar)) {
                        throw new org.apache.xml.utils.URI.MalformedURIException(
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
          throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_scheme ==
              null) {
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_SCHEME_FROM_NULL_STRING,
                  null));
        }
        if (!isConformantSchemeName(
               p_scheme)) {
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_SCHEME_NOT_CONFORMANT,
                  null));
        }
        m_scheme =
          p_scheme.
            toLowerCase(
              );
    }
    public void setUserinfo(java.lang.String p_userinfo)
          throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_userinfo ==
              null) {
            m_userinfo =
              null;
        }
        else {
            if (m_host ==
                  null) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
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
                        throw new org.apache.xml.utils.URI.MalformedURIException(
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
                        throw new org.apache.xml.utils.URI.MalformedURIException(
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
          throws org.apache.xml.utils.URI.MalformedURIException {
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
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_HOST_ADDRESS_NOT_WELLFORMED,
                      null));
            }
        m_host =
          p_host;
    }
    public void setPort(int p_port) throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_port >=
              0 &&
              p_port <=
              65535) {
            if (m_host ==
                  null) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_PORT_WHEN_HOST_NULL,
                      null));
            }
        }
        else
            if (p_port !=
                  -1) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_INVALID_PORT,
                      null));
            }
        m_port =
          p_port;
    }
    public void setPath(java.lang.String p_path)
          throws org.apache.xml.utils.URI.MalformedURIException {
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
          throws org.apache.xml.utils.URI.MalformedURIException {
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
            throw new org.apache.xml.utils.URI.MalformedURIException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
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
          throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_queryString ==
              null) {
            m_queryString =
              null;
        }
        else
            if (!isGenericURI(
                   )) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  "Query string can only be set for a generic URI!");
            }
            else
                if (getPath(
                      ) ==
                      null) {
                    throw new org.apache.xml.utils.URI.MalformedURIException(
                      "Query string cannot be set when path is null!");
                }
                else
                    if (!isURIString(
                           p_queryString)) {
                        throw new org.apache.xml.utils.URI.MalformedURIException(
                          "Query string contains invalid character!");
                    }
                    else {
                        m_queryString =
                          p_queryString;
                    }
    }
    public void setFragment(java.lang.String p_fragment)
          throws org.apache.xml.utils.URI.MalformedURIException {
        if (p_fragment ==
              null) {
            m_fragment =
              null;
        }
        else
            if (!isGenericURI(
                   )) {
                throw new org.apache.xml.utils.URI.MalformedURIException(
                  org.apache.xml.res.XMLMessages.
                    createXMLMessage(
                      org.apache.xml.res.XMLErrorResources.
                        ER_FRAG_FOR_GENERIC_URI,
                      null));
            }
            else
                if (getPath(
                      ) ==
                      null) {
                    throw new org.apache.xml.utils.URI.MalformedURIException(
                      org.apache.xml.res.XMLMessages.
                        createXMLMessage(
                          org.apache.xml.res.XMLErrorResources.
                            ER_FRAG_WHEN_PATH_NULL,
                          null));
                }
                else
                    if (!isURIString(
                           p_fragment)) {
                        throw new org.apache.xml.utils.URI.MalformedURIException(
                          org.apache.xml.res.XMLMessages.
                            createXMLMessage(
                              org.apache.xml.res.XMLErrorResources.
                                ER_FRAG_INVALID_CHAR,
                              null));
                    }
                    else {
                        m_fragment =
                          p_fragment;
                    }
    }
    public boolean equals(java.lang.Object p_test) {
        if (p_test instanceof org.apache.xml.utils.URI) {
            org.apache.xml.utils.URI testURI =
              (org.apache.xml.utils.URI)
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
       "b8m+/wP0rpM27UcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALWcC9Dr2F3Yfb/de+/ustndZJPsskk2u8nNU8mVZcuWzbIh" +
       "tiVZfkiWLUu2TMmNrIcl6/2yZNMNSSgQkpIsNC8mZDvThIEwIYECTaY0ZYFp" +
       "AhNghkdL6YMw0FICZUqYATqkgR7Jvvf77ne/x95833pGx5LOQ//fOf/zP/8j" +
       "HenTf1m4GAYFyHOt9cJyo6tqGl1dWpWr0dpTw6vdfoWVglBVWpYUhmNw7pr8" +
       "qp+5/2+//rT+wF7h0qzwoOQ4biRFhuuEIzV0rZWq9Av3758lLNUOo8ID/aW0" +
       "kuA4Miy4b4TRE/3CtxzIGhWu9K+LAAMRYCACnIsAN/ZTgUwvUJ3YbmU5JCcK" +
       "/cI7Chf6hUuenIkXFR6/uRBPCiR7VwybE4AS7sqOBQCVZ06DwmM32LfMtwB/" +
       "CII/+JG3PfCv7yjcPyvcbzhcJo4MhIjARWaFe23VnqtB2FAUVZkVXuioqsKp" +
       "gSFZxiaXe1Z4UWgsHCmKA/VGJWUnY08N8mvu19y9csYWxHLkBjfwNEO1lOtH" +
       "FzVLWgDWl+6zbgnJ7DwAvMcAggWaJKvXs9xpGo4SFV55OMcNxis9kABkvWyr" +
       "ke7euNSdjgROFF60bTtLchYwFwWGswBJL7oxuEpUeOTYQrO69iTZlBbqtajw" +
       "8OF07DYKpLo7r4gsS1R4yeFkeUmglR451EoH2ucvmW9//3c7lLOXy6yospXJ" +
       "fxfI9OihTCNVUwPVkdVtxnvf2P+w9NIvvGevUACJX3Io8TbN5/7p1976pkef" +
       "/bVtmpcdkWYwX6pydE3+5Py+33556w31OzIx7vLc0Mga/ybyXP3ZXcwTqQd6" +
       "3ktvlJhFXr0e+ezoi+I7f0r9i73CPZ3CJdm1Yhvo0Qtl1/YMSw3aqqMGUqQq" +
       "ncLdqqO08vhO4TLY7xuOuj070LRQjTqFO6381CU3PwZVpIEisiq6DPYNR3Ov" +
       "73tSpOf7qVcoFC6DrfB6sH17YfvL/6OCCOuurcKSLDmG48Js4Gb8WYM6igRH" +
       "agj2FRDruXAqAaV58/Ja6Rp2rQSHgQy7wQKWgFboKpzaVl4hIcyPOlczFfOe" +
       "z8LTjOyB5MIFUOkvP9zlLdBbKNdS1OCa/MG4SXztM9e+vHejC+zqBDQluMLV" +
       "7RWugivkTRZeBVcoXLiQF/zi7ErblgTtYIIeDWzdvW/gvqv79ve86g6gQl5y" +
       "Z1a1ICl8vMlt7duATm7pZKCIhWc/mrxL+J7iXmHvZtuZSQdO3ZNlZzOLd8Oy" +
       "XTncZ44q9/4f+LO//eyHn3L3e89NxnjXqW/NmXXKVx2ux8CVVQWYuf3i3/iY" +
       "9AvXvvDUlb3CnaCnA+sWSUAbgeF49PA1buqcT1w3dBnLRQCsuYEtWVnUdet0" +
       "T6QHbrJ/Jm/g+/L9F4I6vjvT1nvB9qGd+ub/WeyDXha+eKsQWaMdosgN6ZOc" +
       "9/H//FtfLefVfd3m3n9gFOPU6IkD/Twr7P68R79wXwfGgaqCdP/9o+y/+NBf" +
       "/sB35goAUrz6qAteycIW6N+gCUE1f9+v+X/wlT/85O/t3VCaCxEY6OK5Zcjp" +
       "Dci9jOmuEyDB1V67Lw+wExboTpnWXOEd21UMzZDmlppp6f+7/zXIL/zv9z+w" +
       "1QMLnLmuRm86vYD989/aLLzzy2/7u0fzYi7I2Ti1X2f7ybbG78H9khtBIK0z" +
       "OdJ3/c4rfvRL0seBGQWmKzQ2am6NCnkdFPJGg3P+N+bh1UNxSBa8Mjyo/Df3" +
       "rwP+xDX56d/7qxcIf/Xvv5ZLe7NDcrCtacl7YqteWfBYCop/6HBPp6RQB+nQ" +
       "Z5l/8oD17NdBiTNQogxG4XAQAMOS3qQZu9QXL/+XX/7Vl779t+8o7JGFeyxX" +
       "Ukgp72SFu4F2q6EObFLqfcdbt42bZC39QI5auAU+P/HIrer/8Z1mfPxo9c/C" +
       "x7PgNbcq1XFZD1X/ha165uXlpb7lhPZ5axbU86hSFnzbVvDKmRh/difoz94+" +
       "43FZj2bMj18C3Nm8JTOP6OrWI8qv1Dk509XjRo8rtGRl9k1VwAGRyqqX6WBe" +
       "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" +
       "vuejM4FGMHYCpj3JJIlnNBJ1B8vKCkb90B5HkWAyCVSbsyjkdYMN8CVlCdI3" +
       "FM7DdXIy7pZKI9seymRAtbtOTLmVVknDqo3inKOiueqEfWnk96AS2zartisy" +
       "Ijf0fHFKMySwGH7AeYooyIPUWqplyycDcjIqVthouYwHXq3nTgSEDkrtRIlb" +
       "ltsXhqlnG51udWWG+rovsP5yrKtdFTJMx4kisb8UFJ4nS2ItBj4PE2wUcx7z" +
       "g57eoCSFqURc05cpxaqgVNPYcMx0pJhtdFTtC6QtrSxjlBpjEpErYTv2Ki5a" +
       "U9UVK0xkd6WpCBjTV5jnbtgVPMGZsbCex0mIdmSvvJipZdbW+LqissBUGVRY" +
       "pTcbdCXwUNlhi95sZRtabNTZakqNHRPMIwfkJOguRyrwUqxee+LFBG5im6JC" +
       "zAMSK8KVko11l3Q30dN0aqXVhjJpr0zOrDURpJLMGoQtr9c1KEGbg4pPCxSu" +
       "sNV5tyWrkr2uhKP1Yt2pqKwnNW3TJXt6rOJdyG9OyviGxnr8JvWZcmugJZNR" +
       "F18y6GxG4Uk0JUWV8PkBusJGQYghjVAmphWonbRKbqcj0ZqpLhYcNexX6VpY" +
       "YZJiYJgszohNvVkbrDubhGEZYtGORKI4bYCZW7QYq9iw2HVboxLeQQyRJTby" +
       "VEdNMaGMaTI1y2yTrhW5ho0s5FQeh3Z1nayTSdtAELQe8zZal7pdt8OvFmmr" +
       "15x3LFVtr3V0XCtPerHfqQUUS3XNDTFb2FY66verzmzZHnLFSRMWZJ60HD9e" +
       "6bzGENqsNWMd0xuTXH9M+wYWyRY/qk5GM13pD2v4xCFEuzEHDjGRLN2RswA+" +
       "yALuqA6WKHZ7XVrj+kKkG0pn6aNROqTqpdEQMmwbJlldzsqf4wpWGZSzMS+k" +
       "RbLcLc1Uhm1qTJ0Uq1izjy88dSZ6sJ2iGzwdUUiq1UIHo405NqfXdVvFhWS+" +
       "hoHy1GiLrVWAS6FKfZnhIdMyRB5VlHoRh1rrSbvN6vR4ABnwZLkpzjd0Z44q" +
       "1CZlkWQ6pbtQ3Rt3sYW4qlKo3YybHR4W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RfmH4Daff+jnv/0nnvnD/Isf/x+/RWziqFYAAA==");
}
