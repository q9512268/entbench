package org.apache.batik.extension.svg;
public class FlowExtTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.extension.svg.FlowExtGlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public FlowExtTextLayoutFactory() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "e7u3OPXR9mX2SJup/wAouZB1yxoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "xvnJGuWdBoxo5eaWw1zPG5DzUiKl9WWPJTw0tAHmmNUxJU5EcjCqd6pYd9Nr" +
       "IKUVrnSoauYyDK8SaKUzIaRJb91Rq3U4Witwv8aOlqpa7+IKF4ntrO+k24xf" +
       "871my2lhGFye1m1Sdjp9YVITN4yUcJWkvlzatJtGE7fFdCeDHhvNywQ58OjF" +
       "KgnsUX29zlbhctPDnaSKNp1WUCZHBr92IrrSqTcQfdxzEAPBYAHlJm1d4NW0" +
       "Ao8Gg0YQ1rY8ktrkqCsi2w6CSuvacqkt1uokaQdk1q/WVJZZMKUJvm35NXXT" +
       "sMVoLNYqPmpnaI81Kkw8XPbnU67jleszETO0cFNZcEJ+7SljSY9l0J5b1Xot" +
       "dsVQ9U3a7WDYqKw4DTmR6p3OkkMmIssNhiZWzqK102btpU/oSaM9iPqTQWAT" +
       "6tAdlJS2aSzqbuwuxxXPyuJ6ZYvgSQebgRDQUNctle7Q+CjjJoloNuBGD5EM" +
       "jPCFts+PkRY9xpBluRt2Qr9d9XthNrJ7bXINK5VRKRxx85o9JWa1mt4s12hn" +
       "XROSyAvRbWbjdWUox2K2RvvKVhtikpSIK2kbtbeJO2VttzvUqKHYJadur74e" +
       "gx2dkn61C8djDhdQh8jafm1ui2iFxevLLMzgBlKLtWoDa25mhm+b3TI8rRIG" +
       "2iHcrRTWZ2a5VU+78sCI1ZrdW8NjLIi4ulEbGgIBN0SRomCx2TIItb6WGokP" +
       "Mz5slFBxHouVTTkthzPcyTbYrFILqqMswLYltqPK/FhKMnbWlRvs0pe4cEEY" +
       "s4QYV/0hP0aRzoiSY75dLq/SUJuWVHUmJCLMj/rNrD3s28wW7oeExU2iaYVt" +
       "ejw7iKIajthkldKYZUnnKI6rtqt0fxOVVM1KlQRuDxm8g4oaTfbXKb5x2qga" +
       "bmwMrlbWA0lKEaK92fQb0cjx/WVlkMqlbbKM+zjTShsLifAaUlMBWkfMqr+1" +
       "Sk2zVl5N5KQW+oSxdDZZnxsJVH/Dso2mVcdluIK0+yvdYLuaxkxGPZLug7BC" +
       "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" +
       "yf8D0GgGT4klAAA=");
}
