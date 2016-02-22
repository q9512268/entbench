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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VRcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "mk/qIKkFTGVcy886o5GOm7kSioESXyfQZsQ0LK7jUCLQVD3oCy6D1an1ZKpg" +
       "tXpIkz2d8RhFBSXcFdeb3KRnJYlM0lyO7aj00i03hg6rWSbvCtZwNsKqHlFe" +
       "hsQCVcS5svClNt3e4ItFpUxaOBpr1SS/8ZujlSosjG6Px0dDhdmIGpjZHbCQ" +
       "zRxnc05+iZVKKwxle9VGkwTqgBfc4pJkdaoylsbthQbQVXNIy+sFUJh+Z7mY" +
       "YXEQTTYDJXR7bLIoJ1NpxVaLpQq1kKJFT0HRBj5MJjmRyZPcOHS5wjg2iUI1" +
       "WDUrssnINU1g6k7V7JZrlWQVUQlWQfNikQlUWZ00+2GtS5BSMKY0XWDVIt7g" +
       "8QiLzDqe70xLgV7gOqxXM3J0Tmut3WZb7zBWcV0DOjq3ZcOo9lauJtYUtFvj" +
       "gOcuySmvJhhWGBabuZVsTTy3EqLhcFCWcLkp9Dw2JnBUc6Mm0Y0avGYRoBOW" +
       "AzAOKmIoxy0DtfVWHBU3kznDmWN+VpOHiadNHT4nyDJo1wjKHqkVgdg4BZ3D" +
       "sUpNbKMKuiKwaYEAWGVEVWJWr1mlWUiEgd2G/ER3PG8ZJoSy0O7KVrk8Rqs0" +
       "UKqzZLWac7pqj+TBxpig1Lq9HOgVqdXsehGlk/mqDATNLkdqiHdpnJxKbWFa" +
       "xFDamparljGqjYWRGAQ1RqguIksf+dXlWFy2nIY9zXEbSWQ687Df5LrNYN0x" +
       "IXYBtcm26bW1YdY6sWzMxHouHDjmlNBcsp7UZ4bSWLgMzufYuUQSDVwLl/nN" +
       "1K+4tFlUsFXcq41L5SG1HjTjTq9PFlQuIQualHdbqlofUyKzKtUSbtQSplJp" +
       "7mDmUl8lo7GB6ZOlXOEq9Q0jF+NhvIjjYqXC+jNP8ekF08ciodWasaq/LhGF" +
       "uNHqDF25SMaib1SDYQRfwB2wGulTvA69nBS6BI1FqlZtJkHSzxcp0xlXpkxM" +
       "Vdu2k6sTHr6YdN0ZrSxtvUpjCkGV5IEWVxeEhPe5wZgYcBSBt7zBuEvp+bwT" +
       "TvCyh+Yx0AvctjMObLGL1+RcVWBrDWHa75aVIeUx0L7CkDML0hB3l30wM8KB" +
       "3do0MU1qLkEZU+HrzrCrrqZjBukWG9E6z3oFwSXGi3IeX7Tg1ydbF8aoAAHG" +
       "BZPuIum7ZYjFZDngVMKmuzXB31icNButl35cEmboqqUkUqfREleslJtxfnmG" +
       "kSaXLyx0WWpKkmLwYb7IwbR+LQGlxtBuhSsEBb3cCSZav7jJEaRvQmTq2XRT" +
       "7rSAxNBtjONKXrzO4YW87XnQUScxVxQVUYn8Gi+0ynGPk1GFrwPbWvnTZJ5H" +
       "mziD5Vyl3nNqpt9tTZShaSQoTFgJas7zmugPAj+XxDJRQgs6NlILdaNizJ0R" +
       "G7lJfsR2vHHHRuuKjSaLZkdFaafkUqBcYTpDiSebTN4uT+X2MJlOmS7aMay+" +
       "X221mkN+Om+slaEyGLWqYmFZYbtknZoQxmqsTY04GRdsuhwSecxDdQmYOYll" +
       "xMGEq+hmfVrrdey4P5gmshrG0tTny4BAc1PLn5XInkXMO12/GM2UilaSpvGs" +
       "DZZMeV5kPaxMaEx+hOU9q2oLJOrRBtMw51I4yXe5sFTX/Cq5ZEYMOuRRMqou" +
       "l2qlOuJRMU/Z+GqNKXpFnJAg4jc4beO9dscu+qUBNauVo2ZYDESPFIJhsyvy" +
       "SrRilZzKQaChl7UoFnQDbbUGKN2Kp7nQbQWoZfc3EdVq872860Q6mIWS5JRq" +
       "lt1pMEWamCrVwYZwibqojqdg2a94y4qZY1bVBtaf6uvSwu2sYnTRdSt4tz+m" +
       "6otWwVKa1LiAYXU0YqcoxzMS/Lh54xvTz563vLwvz3uyj+yDcw74wZk+aL+M" +
       "L67to8fT5jUHhcXs78wtCotHii+n9j/o77+uirwtHKdfmQ/f7Hgj+8L82NPP" +
       "PS8PP47v7BW1hBA5Hzruz5sgAuaJOs/rbv41TWenO4fFli88/W8PTt6kve1l" +
       "lJMfPSHnSZafoF/4Uvu10nt3kNsOSi/XnTsdn3T1eMHlgg/ClW9PjpVdHj6w" +
       "/L2poV8Frwt7lr9w45LuDb3kVOYlW984UTPcyQh29vfqkev2KrMDCIGfFiX3" +
       "ye47SsZuf8lRN1shvEVVMkkbJ0TOrFxZDLfFa+aIJ/Ihchbm9CYQ7UMvdX9c" +
       "XeDoKtmAeWC2zGkfgtfde2a7+6djtlPHXfzhG7q4bqvpmSnIODxzC7O8K22e" +
       "DpE7VBAycF7qHjeMHt0SVZBWn/dOSTP7/NpPYJ870sE3wevynn0u/1TdKr19" +
       "Nm1+K6P64C1s8OG0eW+I3BVIYgjdbaQ54V5InvCQ2yNHlw/Vf9/LUT8OkTuP" +
       "Hl6l1fcHrjsI3x7eSp9+/uK5+5/n/i47vzk4YD1PIeeUlWkeLZYe6Z9xfaDo" +
       "mUrnt6VTN/v53RsB4fY4LS2VZp1M3N/Z0v9eiFw6SQ91T3+Okn0Ces0RMhg/" +
       "e72jRC+EyG2QKO1+yr1BnXVbNI5PHYHUPU/JLHz5x1n4YMrR850UhrP/RNiH" +
       "zNX2fxGuSZ95vjd4+0ulj2/PlyRTTDJcOEchZ7dHXQew+/hNue3zOtN58od3" +
       "f/b8a/ZfEXdvBT702iOyPXrjA5ym5YbZkUvyJ/f/0Rt+//lvZGXf/wNj5/8G" +
       "IiIAAA==");
}
