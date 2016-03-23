package org.sunflow.core.shader;
public class SimpleShader implements org.sunflow.core.Shader {
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        return new org.sunflow.image.Color(
          java.lang.Math.
            abs(
              state.
                getRay(
                  ).
                dot(
                  state.
                    getNormal(
                      ))));
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        
    }
    public SimpleShader() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYfWwcRxWfO39/25fY+WjifDmRnKR3DTRA5RCSuHbj9Jyc" +
       "cmkEDuSytzd3t/He7mZ31j47GNoCiqlEFLVOG2hr/klFQW0TFSpA0CqoEm3V" +
       "gtSqoi2oKRJIhI+IRkgtUoDy3szu7d7e2VEQPWnndmffvK957/fe7FNXSZ1l" +
       "kl6qsSibMqgVHdJYQjItmhlUJcs6BHMp+ZEa6R9Hr+y/I0zqx0h7XrJGZcmi" +
       "wwpVM9YYWa1oFpM0mVr7Kc3gioRJLWpOSEzRtTHSrVgjBUNVZIWN6hmKBIcl" +
       "M066JMZMJW0zOuIwYGR1HDSJcU1iu4OvB+KkVdaNKY98uY980PcGKQueLIuR" +
       "zvhxaUKK2UxRY3HFYgNFk2wxdHUqp+osSosselzd7rhgX3x7hQvWX+z44PqZ" +
       "fCd3wRJJ03TGzbMOUktXJ2gmTjq82SGVFqwT5CukJk5afMSM9MVdoTEQGgOh" +
       "rrUeFWjfRjW7MKhzc5jLqd6QUSFG1pUzMSRTKjhsElxn4NDIHNv5YrB2bcla" +
       "YWWFiWe3xOYeOdr5bA3pGCMdipZEdWRQgoGQMXAoLaSpae3OZGhmjHRpsNlJ" +
       "aiqSqkw7Ox2xlJwmMRu233ULTtoGNblMz1ewj2CbactMN0vmZXlAOU91WVXK" +
       "ga09nq3CwmGcBwObFVDMzEoQd86S2nFFyzCyJriiZGPf3UAASxsKlOX1kqha" +
       "TYIJEhEhokpaLpaE0NNyQFqnQwCajKxckCn62pDkcSlHUxiRAbqEeAVUTdwR" +
       "uISR7iAZ5wS7tDKwS779ubp/x+mT2l4tTEKgc4bKKurfAot6A4sO0iw1KeSB" +
       "WNi6Of6w1PP8bJgQIO4OEAuaH3/52q6tvZdeFjS3VKE5kD5OZZaSz6fbX181" +
       "2H9HDarRaOiWgptfZjnPsoTzZqBoAML0lDjiy6j78tLBX37h3h/Qv4ZJ8wip" +
       "l3XVLkAcdcl6wVBUat5FNWpKjGZGSBPVMoP8/QhpgPu4olExeyCbtSgbIbUq" +
       "n6rX+TO4KAss0EXNcK9oWd29NySW5/dFgxDSABfZAlcTET/+z0giltcLNGYo" +
       "sYSpo+lWDMAmDW7Nxyxby6r6ZMwy5Zhu5krPsm7SmJWXMtSMJRUAPZrkD1GM" +
       "LONj4FlEO5ZMhkLg4lXBBFchN/bqKtCm5Dl7z9C1Z1KviuDBgHc8AJAE0qKO" +
       "tChKiwppUb80EgpxIUtRqthD2IFxyGUA09b+5Jf2HZtdXwPBY0zWgvuQdH1Z" +
       "URn0Et5F6ZR8IdI2ve7ythfDpDZOIpLMbEnFGrHbzAH6yONOgramodx4qL/W" +
       "h/pYrkxdphkAnYXQ3+HSqE9QE+cZWerj4NYkzL7YwhWhqv7k0rnJ+w5/9bYw" +
       "CZcDPYqsA4zC5QmE5xIM9wUTvBrfjlNXPrjw8IzupXpZ5XALXsVKtGF9MAyC" +
       "7knJm9dKz6Wen+njbm8CKGYSpA6gXG9QRhmSDLiojLY0gsFZ3SxIKr5yfdzM" +
       "8qY+6c3w+OzCoVuEKoZQQEEO6J9NGo+//es/f5J70sX+Dl/RTlI24MMbZBbh" +
       "yNLlReQhk1Kge/dc4qGzV08d4eEIFBuqCezDcRBwBnYHPPiNl0+8897l82+G" +
       "vRBmUHDtNPQtRW7L0o/gF4LrP3ghRuCEwIrIoANYa0uIZaDkTZ5ugF0qJDwG" +
       "R989GoShklWktEoxf/7VsXHbc3873Sm2W4UZN1q23piBN79iD7n31aMf9nI2" +
       "IRlrp+c/j0wA8hKP827TlKZQj+J9b6z+9kvS4wDtAKeWMk05QhLuD8I3cDv3" +
       "xW18vD3w7tM4bLT8MV6eRr4eJyWfefP9tsPvv3CNa1veJPn3fVQyBkQUiV0A" +
       "YVuJM5QhNr7tMXBcVgQdlgWBaq9k5YHZ7Zf2f7FTvXQdxI6BWBnaB+uACQhX" +
       "LAslh7qu4be/eLHn2Os1JDxMmlVdygxLPOFIE0Q6tfIAr0Xjc7uEHpONMHRy" +
       "f5AKD1VM4C6sqb6/QwWD8R2Z/smyH+343vxlHpaG4HGLn+EmPvbjsFWELd7e" +
       "Wiw5i//qF3GWj2eI3y9nZFlFSRBVAB27eqEOhXdX5++fm88ceGKb6CMi5VV/" +
       "CJrap3/z79ei537/SpVC1MR041aVTlDVp1MNiiyrJKO8efPQ7N32B//w077c" +
       "npspIjjXe4Mygc9rwIjNCxeFoCov3f+XlYd25o/dRD1YE3BnkOX3R5965a5N" +
       "8oNh3qmKUlDR4ZYvGvA7FoSaFFpyDc3EmTaeTRtKAbIE42EFXM1OgDQHs0kA" +
       "N482HIZKS2td8oWWBsAizHc07EZZb0WUcddQaLgx9l2yHj9ZUvzvToxwtT6/" +
       "CBwdxSEJKG4bGUDk8o4EAyRppy3oHpQCVJQJp1f+ROKYPNuX+KOI3xVVFgi6" +
       "7idj3zr81vHX+E43YmiV/OsLKwhBXx3sxCGKOdS/yMmzXJ/YTOS98ceuPC30" +
       "CTb6AWI6O/fAR9HTcyK3xGloQ8WBxL9GnIgC2q1bTApfMfynCzM/e3LmVNhx" +
       "9d2MNKR1XaWSVtqKUKkRXFruRaHrnd/s+PmZSM0wZO0IabQ15YRNRzLlkdtg" +
       "2WmfW70DlBfHjtZYihkJbXYx8jM4HBL3O/5HeMaJPQafP1AK+S58twqudifk" +
       "228+WxZaGojlUDkmr66KyXBKxXM65WInF8mGkzhAi9eSo+wgrOMfbKrBvVKA" +
       "4ypWI+dkzl1pfQyubMF3O+GKOP6I3LwrF1paHXjwkTOd4ePsIu56AIevMdJm" +
       "yRIDQErkdebguOwkCv7lGKmd0JWM56mv/z88VWSk1X/6wlZhecX3G/HNQX5m" +
       "vqNx2fw9b/H6V/ou0AqwlLVV1ZdO/tSqN0yaVbipraK9Mvjf2WrFX5wHAUnF" +
       "Ddd6TtCfY6QzSA8+wT8/2aMQeD4yhqnN7/xE84zUABHeftdwY7OTd0j4USYq" +
       "vkAUQ5VdEPd89408X1riPxIgAPMPaC5C2eITGhxO5/ftP3ntU0+II4msStPT" +
       "yKUFcEkcfEo1fN2C3Fxe9Xv7r7dfbNroAmbZkcivG99/yHp+fFgZ6NGtvlKr" +
       "/s75HS/8arb+DYD6IyQkMbLkiO/zlfAUNPo2NE9H4pX4C/0OPzwM9H9naufW" +
       "7N9/xxtMB69XLUyfksceenvk4viHu/gXmzqoBbQ4RpoV684p7SCVJ8wyMG/H" +
       "aJTwUxr3g+O+ttIsnk0ZWV9ZoipP9NB8T1Jzj25rGacctHgzZV/y3LbHNozA" +
       "Am/GV5XHRTqj9yH+UvFRw3APdv80eD6qQUjmk3zxs/wWhx/+F4LzMb5LFwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "IgAA");
}
