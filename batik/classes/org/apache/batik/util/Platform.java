package org.apache.batik.util;
public abstract class Platform {
    public static boolean isOSX = java.lang.System.getProperty("os.name").
      equals(
        "Mac OS X");
    public static boolean isJRE13 = java.lang.System.getProperty("java.version").
      startsWith(
        "1.3");
    public static void unmaximize(java.awt.Frame f) { if (!isJRE13) {
                                                          try {
                                                              java.lang.reflect.Method m1 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "getExtendedState",
                                                                  (java.lang.Class[])
                                                                    null);
                                                              java.lang.reflect.Method m2 =
                                                                java.awt.Frame.class.
                                                                getMethod(
                                                                  "setExtendedState",
                                                                  new java.lang.Class[] { java.lang.Integer.
                                                                                            TYPE });
                                                              int i =
                                                                ((java.lang.Integer)
                                                                   m1.
                                                                   invoke(
                                                                     f,
                                                                     (java.lang.Object[])
                                                                       null)).
                                                                intValue(
                                                                  );
                                                              m2.
                                                                invoke(
                                                                  f,
                                                                  new java.lang.Object[] { new java.lang.Integer(
                                                                    i &
                                                                      ~6) });
                                                          }
                                                          catch (java.lang.reflect.InvocationTargetException ite) {
                                                              
                                                          }
                                                          catch (java.lang.NoSuchMethodException nsme) {
                                                              
                                                          }
                                                          catch (java.lang.IllegalAccessException iae) {
                                                              
                                                          }
                                                      }
    }
    public Platform() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "OCmpNL/y3HCcrNJRuDAttkOs5obQwawSGsPiYLus1MqiOWqBXICKVcXFBzpt" +
       "bma9JANWu17X8UZJ4Yh5rVxmqlZ/0FOsJmWLDRkuexJH8GmstCNWKtHztQPD" +
       "/WqZGepiK9oGZY1k3Kg95tnKys9GWoAu1XhtJOuZ2aB4Vx7UG5bp4WW3H3aa" +
       "3WhiDP3twoMVuWTLnCt3SHI42MRYi+3gLEVmMLvkStvhyrcR2wjkJqezQ9YR" +
       "Uh5VjP5catHzPk/BfWwyw1PO9fEGMjeyklbGhHl3u/ZrKjpYRgg6aNaTcGOP" +
       "7HJVlUgTrZVmMDfDnMiXA6O7bo0kWN824YlmTAnBtJBeGK9Iy1/FVa1DY0xr" +
       "sJq06VhIY8ssCXzCb1DbYxNhYVWpVZa0VdUZ9mb9HmkqZRPudMhptuhVPEVN" +
       "Oao9rdSX7BZtp5REDmlBLsfVadMwQN4qMhWc4mSLqzR4kXQXfXDMs1wPs2BM" +
       "JlJEinSvx9fGFXQbS9YmjYylbU+Buw6qWRI6aAonFMa2Z4NBVlKaXVSW0Gmj" +
       "rA+wabc8o/vrlJsoPYywZ7VVJMSyUVciEDB5GGtYMdEA6VA8Gzk9E8umOKIx" +
       "JmHSqU6Lk21lJFR5sdm2cK5rV0ZVidjWI3FJtkdal1+mo6rPkmkjiKpYW9P7" +
       "aW+RoQiTGJ2FhepbjWs31hKWRlJiGras6WVenJTq24EpNhGDHou8lVUlCU3U" +
       "1SrGZF3Fgmxrr6bL5mA6UBsxMpy3Vki2iqyFgKBJli6nc2TCqNO1J1eMAOsN" +
       "vZhfdJiSnumZIopYSLTK2MyxHEYrtbqIS40wcxqvKtUwmmIIaaEGRY6MqVNC" +
       "aKeOJ+banKXLYTpXvPViE1CbarMeIm550vVUa5ItaKe7nK2nbipMeN9tojYJ" +
       "q12ymRnlKYUY/UqEU/wGBpkpJUhOinTUFJ6X6LpddVUdXdJsa4Vjxpxek52y" +
       "FM1LyyFDheC2wSQlUYgaTJPrz8bNirqYWoNQzeb1wdpouzMRq8ceVxdMyeMi" +
       "s4TDI17lp+Am9Yb8iuX+dFe/e4pb7uFzFLjx5RNv/ilud9lL11wuKGoUh4oW" +
       "Z4cFg+Jz6SVKxcfKaVBeAXn4Vk9QRfXjk+989jmd/RS6t1+G7MfQHbEf/IJj" +
       "rA3nGKr8nv30rSs9TPECd1Qe+9I7//WhyS8u3vpTPAA8eorO0yh/l3n+K93X" +
       "ah/cg247LJbd8DZ4ctG1kyWyi6ERJ6E3OVEoe/hkKSYvwyD7kkVuXoT/yeow" +
       "p0q9Z/aluF//2JUslDS+2gEyMIol73qJ6vB78+btMXQx8Vwls1xra9y0uLD2" +
       "Lf3I8t7xcnWFE3VYYG4HT0R5jfvBGx6Yd4+i2mefu3ThgeeEvyleSQ4fLu8Y" +
       "QBfMxHGOlySP9c8FoWFaBS937AqUQfHzoRi676bPVYCZ/Kcg84M72I/E0OXT" +
       "sDF0tvg9DvcxIKcjuBg6t+scB/l4DN0GQPLuJ4KbFKV2VdnszElnOhTsvS8n" +
       "2GP+9+QJryke9w8sPNk971/XPvccPXzbi7VP7R5wNEfZbnMsFwbQ+d1b0qGX" +
       "PH5LbAe4zlFP/ejuz9/xmgOPvntH8JHtHqPt0Zu/kLTdIC7eNLZ/9MAfvP63" +
       "n/tmUSP7X9hcU4J1IQAA");
}
