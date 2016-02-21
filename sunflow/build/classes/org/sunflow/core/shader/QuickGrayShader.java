package org.sunflow.core.shader;
public class QuickGrayShader implements org.sunflow.core.Shader {
    public QuickGrayShader() { super(); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        return true;
    }
    public org.sunflow.image.Color getRadiance(org.sunflow.core.ShadingState state) {
        if (state.
              getNormal(
                ) ==
              null) {
            return state.
              getShader(
                ) !=
              this
              ? state.
              getShader(
                ).
              getRadiance(
                state)
              : org.sunflow.image.Color.
                  BLACK;
        }
        state.
          faceforward(
            );
        state.
          initLightSamples(
            );
        state.
          initCausticSamples(
            );
        return state.
          diffuse(
            org.sunflow.image.Color.
              GRAY);
    }
    public void scatterPhoton(org.sunflow.core.ShadingState state,
                              org.sunflow.image.Color power) {
        org.sunflow.image.Color diffuse;
        if (org.sunflow.math.Vector3.
              dot(
                state.
                  getNormal(
                    ),
                state.
                  getRay(
                    ).
                  getDirection(
                    )) >
              0.0) {
            state.
              getNormal(
                ).
              negate(
                );
            state.
              getGeoNormal(
                ).
              negate(
                );
        }
        diffuse =
          org.sunflow.image.Color.
            GRAY;
        state.
          storePhoton(
            state.
              getRay(
                ).
              getDirection(
                ),
            power,
            diffuse);
        float avg =
          diffuse.
          getAverage(
            );
        double rnd =
          state.
          getRandom(
            0,
            0,
            1);
        if (rnd <
              avg) {
            power.
              mul(
                diffuse).
              mul(
                1.0F /
                  avg);
            org.sunflow.math.OrthoNormalBasis onb =
              state.
              getBasis(
                );
            double u =
              2 *
              java.lang.Math.
                PI *
              rnd /
              avg;
            double v =
              state.
              getRandom(
                0,
                1,
                1);
            float s =
              (float)
                java.lang.Math.
                sqrt(
                  v);
            float s1 =
              (float)
                java.lang.Math.
                sqrt(
                  1.0 -
                    v);
            org.sunflow.math.Vector3 w =
              new org.sunflow.math.Vector3(
              (float)
                java.lang.Math.
                cos(
                  u) *
                s,
              (float)
                java.lang.Math.
                sin(
                  u) *
                s,
              s1);
            w =
              onb.
                transform(
                  w,
                  new org.sunflow.math.Vector3(
                    ));
            state.
              traceDiffusePhoton(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                power);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HPkPFU1UPqgWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "bsjPbQmf2HFhSlNNBEeLSbEpcS3C0osKq0rJarLGvY0mcktxpRfqvVbTKKgl" +
       "n2fGarqUZvSyC5NdA60ocBElOkmzVOWSeIqTCkPxY3tRHbZAOFJtgb3DJosC" +
       "aw7ptdfTm01/RMdFPg3WBbnbCoHbI9YzkUr6RWfF0gM+mRrAkYzozXIacS3H" +
       "2cAlrWVobtjbbGp+zNUG5TImrCLfSZsFZU6ILWkNM53amgrmVp2vSPPZBFid" +
       "giRqPfJafZRg60CT2XKPZweNqYNr0QDUyZD0bRCS4ZoQk/hoihF8F6uhtXYV" +
       "Z9PaHIt6pUrBChPSwUfFAVGdtBkSk7hZbE7GrblVThGOJcvTcUlfl4Mp1lsG" +
       "BjWAOaUDJyvTNhtlftEDwdfETry0LqabxSTmmiMM3/D1Uatkb+q1YiHgu0O8" +
       "0EHsTjPpmUKbVzrFca3QG/CVcRWoz7jjRt2KuZDRZbw2zAkZ2UphU4NxX9kk" +
       "5jwZ90aWYq/kgKg3TJzRyE1h4EloM1WX8wCdtmBs2g/KTbhUxjtkc1nERrIv" +
       "huRgaFl2irutdakBr72CiNBCsVJey3Z7kLTRJoiOcYmzZwyIfcIhXxwkTIsc" +
       "gt1lsiBCAWyxfWqwSdIAnXCwUYBJXTCICuZLtYFtdkXY7rqKVJXHIOZYg5ij" +
       "XmqZ7sIfe7UlsinoOud6yVpsV/ptpxJpsCgZNN6tctEU6Xj+hhLhVrvA2exo" +
       "Krpwr72R+E3I9ksOJU+lYeyhsowkG5bwSl5/hZuWh9IuKQ4QJKpskii0ylIn" +
       "xuIZxa7YFl/kWW8hgJPKW7MjzDte3Sny9vzAfHDrAQ6PWQf1Kk5P265HsuL1" +
       "B0m2/HfmZKb8aJLtMPNyav9wfs9VmeNtpjg7MT7wSpcd+Wnx+fddeU5hPl7c" +
       "2ctoTUPoptBxf9JUY9U8keR5/JVPxv38rucw0/LF9/3rfdzb9He9ivzxQyfm" +
       "eZLk7/Vf+HL7DfJv7EA3HORdrrqFOo70xPFsy3lfDSPf5o7lXB44kPydmaBf" +
       "u788+++rc7jX1JJTuZZsdeNEwnAnB9jZX6sHr1qrXA5qqPpZRnIf7O6jYOPt" +
       "u8528hGi66Qk350V4Ch/JgJWFm6z1eMjmiiE0Nm545iqZB9qqffDzvhHR8kb" +
       "rAOx5Up7P3ju2hPbXT8esZ06ruIPXFPFDXuR3aCqOYWnryOWX8uKXwihmxdq" +
       "OAJ4mXpc03oMS1qoWep57840l88v/gjyya8G3gaeR/fk8+iPVa2yz1/Jimdy" +
       "qGevI4PfzooPhdCtgSyFQN1Y3Qn3TPKEhtwYO4ZyyP6VV8N+GkIXTlxYZdn3" +
       "e6+6Gd/e5sqffu7CuXue4/8mv7M5uHG9iYbOaZFpHk2WHqmfcX1VM3Kubtqm" +
       "Tt389fy1fOH2Fi3LfOaVfMa/s4X/RAhdPAkP2M9eR8E+CRTnCBgwob3aUaBP" +
       "hdANACirftq9Rtp0mzROTx3xqnvKkgv5jh8m5AOUo3c6mSfO/zVh32tG239O" +
       "uCx/5rnu4N0vlT++vVOSTWmzyaico6Gz2+utA8/7yCtS26d1hnrs5ds+e9Pr" +
       "93eJ27YTPlTcI3N76NoXOKTlhvmVy+bz9/zBWz7x3DfyLO7/Aau+XDAzIgAA");
}
