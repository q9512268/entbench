package org.sunflow.core.gi;
public class PathTracingGIEngine implements org.sunflow.core.GIEngine {
    private int samples;
    public PathTracingGIEngine(org.sunflow.core.Options options) { super(
                                                                     );
                                                                   samples =
                                                                     options.
                                                                       getInt(
                                                                         "gi.path.samples",
                                                                         16);
    }
    public boolean requiresPhotons() { return false; }
    public boolean init(org.sunflow.core.Scene scene) { samples =
                                                          java.lang.Math.
                                                            max(
                                                              0,
                                                              samples);
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "Path tracer settings:");
                                                        org.sunflow.system.UI.
                                                          printInfo(
                                                            org.sunflow.system.UI.Module.
                                                              LIGHT,
                                                            "  * Samples: %d",
                                                            samples);
                                                        return true;
    }
    public org.sunflow.image.Color getIrradiance(org.sunflow.core.ShadingState state,
                                                 org.sunflow.image.Color diffuseReflectance) {
        if (samples <=
              0)
            return org.sunflow.image.Color.
                     BLACK;
        org.sunflow.image.Color irr =
          org.sunflow.image.Color.
          black(
            );
        org.sunflow.math.OrthoNormalBasis onb =
          state.
          getBasis(
            );
        org.sunflow.math.Vector3 w =
          new org.sunflow.math.Vector3(
          );
        int n =
          state.
          getDiffuseDepth(
            ) ==
          0
          ? samples
          : 1;
        for (int i =
               0;
             i <
               n;
             i++) {
            float xi =
              (float)
                state.
                getRandom(
                  i,
                  0,
                  n);
            float xj =
              (float)
                state.
                getRandom(
                  i,
                  1,
                  n);
            float phi =
              (float)
                (xi *
                   2 *
                   java.lang.Math.
                     PI);
            float cosPhi =
              (float)
                java.lang.Math.
                cos(
                  phi);
            float sinPhi =
              (float)
                java.lang.Math.
                sin(
                  phi);
            float sinTheta =
              (float)
                java.lang.Math.
                sqrt(
                  xj);
            float cosTheta =
              (float)
                java.lang.Math.
                sqrt(
                  1.0F -
                    xj);
            w.
              x =
              cosPhi *
                sinTheta;
            w.
              y =
              sinPhi *
                sinTheta;
            w.
              z =
              cosTheta;
            onb.
              transform(
                w);
            org.sunflow.core.ShadingState temp =
              state.
              traceFinalGather(
                new org.sunflow.core.Ray(
                  state.
                    getPoint(
                      ),
                  w),
                i);
            if (temp !=
                  null) {
                temp.
                  getInstance(
                    ).
                  prepareShadingState(
                    temp);
                if (temp.
                      getShader(
                        ) !=
                      null)
                    irr.
                      add(
                        temp.
                          getShader(
                            ).
                          getRadiance(
                            temp));
            }
        }
        irr.
          mul(
            (float)
              java.lang.Math.
                PI /
              n);
        return irr;
    }
    public org.sunflow.image.Color getGlobalRadiance(org.sunflow.core.ShadingState state) {
        return org.sunflow.image.Color.
                 BLACK;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwcRxWfO39/xV+1nU/HcZwgp+GubVIgOCR1XDtxOMen" +
       "OIlUB3KZ25u722Rvd7M7Z59dDE0kmlCJEMD5oGoDf6S0REkTAaVI0CoIQVta" +
       "kPoBpSBaQEgESkQDoqAGKO/N7t7u7Z1dRSAs7Xhv5r0372t+781euEYqTIN0" +
       "MpWH+JTOzNCgyqPUMFliQKGmuQvmYtLpMvrXfVd3bAiSynGyIE3NEYmabEhm" +
       "SsIcJ8tk1eRUlZi5g7EEckQNZjJjgnJZU8dJm2wOZ3RFlmQ+oiUYEuyhRoQ0" +
       "U84NOZ7lbNgWwMmyCGgSFpqE+/3LfRFSL2n6lEu+0EM+4FlByoy7l8lJU+QA" +
       "naDhLJeVcEQ2eV/OILfqmjKVUjQeYjkeOqDcabtge+TOIhd0X258+8aJdJNw" +
       "QStVVY0L88ydzNSUCZaIkEZ3dlBhGfMQ+SQpi5A6DzEnPRFn0zBsGoZNHWtd" +
       "KtC+ganZzIAmzOGOpEpdQoU4WVEoRKcGzdhiokJnkFDNbdsFM1jblbfWsrLI" +
       "xJO3hmdP72v6ehlpHCeNsjqG6kigBIdNxsGhLBNnhtmfSLDEOGlWIdhjzJCp" +
       "Ik/bkW4x5ZRKeRbC77gFJ7M6M8Serq8gjmCbkZW4ZuTNS4qEsn9VJBWaAlvb" +
       "XVstC4dwHgyslUExI0kh72yW8oOymuBkuZ8jb2PPR4EAWKsyjKe1/FblKoUJ" +
       "0mKliELVVHgMUk9NAWmFBglocLJ4TqHoa51KB2mKxTAjfXRRawmoaoQjkIWT" +
       "Nj+ZkARRWuyLkic+13ZsPH6vuk0NkgDonGCSgvrXAVOnj2knSzKDwTmwGOvX" +
       "RE7R9qeOBQkB4jYfsUXz5Ceu37W288qzFs2SEjSj8QNM4jHpXHzBi0sHejeU" +
       "oRrVumbKGPwCy8Upi9orfTkdEKY9LxEXQ87ilZ0/vOe+8+zNIKkdJpWSpmQz" +
       "kEfNkpbRZYUZW5nKDMpZYpjUMDUxINaHSRW8R2SVWbOjyaTJ+DApV8RUpSZ+" +
       "g4uSIAJdVAvvsprUnHed8rR4z+mEkCp4yHp4FhDrT/znJB5OaxkWphJVZVUL" +
       "Rw0N7ceAqgka5syE9wSs6lrYzKpJRZsMm4YU1oxU/rekGSyckoGFp3cZVIKU" +
       "2jo8qKZAzxDmmv5/2SWHtrZOBgIQhqV+EFDg/GzTlAQzYtJsdsvg9cdjz1sJ" +
       "hofC9hIn74MNQ/aGIdwwlJJDJTYkgYDY5xbc2Ao1BOogHHnA3PresY9v33+s" +
       "uwxyTJ8sBy8jaXdB7RlwccEB85j0l+2/Wbdt5sMvB0kQoCMOtcctAV2eEoC1" +
       "y9AklgAEmqsUOHAYnhv8S+pArpyZPLznU7cJHbyYjgIrAI6QPYpInN+ix3+W" +
       "S8ltPHr17UunZjT3VBcUCae2FXEiWHT7o+k3Piat6aJPxJ6a6QmSckAgQF1O" +
       "IUwAaJ3+PQpAo88BYLSlGgxOakaGKrjkoGYtTxvapDsj0qxZvN8Coa3DU9QJ" +
       "T7N9rMR/XG3Xceyw0hJzxWeFAPiPjOkP//wnf1gn3O3UgkZPER9jvM+DPyis" +
       "RSBNs5t6uwzGgO5XZ6JfPHnt6F6Rd0CxstSGPTgOAO5ACMHNn3720GtvvH7u" +
       "laCbqxwKcDYOfUwubyTOk9p5jITdVrv6AH4pcLoxa3p2q5CVclKmcYXh4fhn" +
       "46rbn/jT8SYrDxSYcdJo7XsLcOcXbSH3Pb/v751CTEDC+un6zCWzQLnVldxv" +
       "GHQK9cgdfmnZl56hDwO8A6Sa8jQTKBmwzysqtRDAvggPRnWhlojqekEWFuM6" +
       "9IhgJmLtQzj0mN7TUXgAPY1QTDrxylsNe956+rowp7CT8ibDCNX7rPzDYVUO" +
       "xHf4EWgbNdNAt/7Kjo81KVdugMRxkChB+2COGoB/uYLUsakrqn7xve+373+x" +
       "jASHSK2i0cQQFaeQ1ED6MzMN0JnTN99lRX+yGoYmYSopMh4dvrx0KAczOhfO" +
       "n/52xzc3Pnr2dZF1VpotyQPl0gKgFN23e87Pv/zBnz76+VOTVv3unRvcfHwL" +
       "3xlV4kd++48iBwtYK9Fb+PjHwxceWjyw6U3B7+ILcq/MFdcbQGCX947zmb8F" +
       "uyt/ECRV46RJsrvdPVTJ4qkdhw7PdFpg6IgL1gu7Nas16cvj51I/tnm29SOb" +
       "W+fgHanxvcEHZvUYwYXwNNrnvNEPZgEiXoYFy2ox9uKw1sGOKt2Q4UbEfOBR" +
       "N49QYDIp3JwgQwvKJN6ixrJxE4qdnAH0m7D7vDui+6VjPdHfWTmwqASDRdf2" +
       "WPize1498ILA1mosp7scuz3Fst9IeYC9yVL7XfgLwPNvfFBdnLD6pZYBu2nr" +
       "yndtuo4ncZ5k9BkQnml54+BDVy9aBvgzz0fMjs0+8G7o+KwFmFbrv7Ko+/by" +
       "WO2/ZQ4OY6jdivl2ERxDv780853HZo5aWrUUNrKDcE+7+LN/vRA68+vnSvRN" +
       "ZbJ9fVvnwVAoeYWxsQy6+zON3z3RUjYEpXqYVGdV+VCWDScKM7TKzMY9wXKv" +
       "FG7W2qZhYDgJrIEYWIUWxw04bLdScGMp1LKWVuOwJp+o4q/S3yF7q5wXqOwK" +
       "saioQjg9Inp92VzXHOHxc0dmzyZGH7k9aNeMcQ5wq+nvV9gEUzyblaOkAlQc" +
       "ERc7F2Jq77+tNcJzyeLOEaV0ztEbrpk7Y/0bPHPkj4t3bUrvv4m2cLnPdr/I" +
       "r41ceG7raukLQXE3tRCt6E5byNRXmCW1BoNLuFqYF935eLZi+LrhabPj2Va6" +
       "NSuRCvmGZy7WeSp/dp61SRzgvDQa7FBWhsIaTWscvCiIo/ZhxX+7Pe/3AEDG" +
       "NU1hVPWfMfwZy7k5f2ienC+u1DjRL6aVQqd1wLPItnzRzTttLlafY3y9VnvR" +
       "SRqTAGHFfvfP49MHcDjM8e4ri2ZyyvXHkf/aH6LTxf6+yzaq6+b9MRerz6ig" +
       "0CPo+GNZsT/SNAGXUPxgxRyqDi+VnKEphi2XZgi1Zudx24M4fI6ThhTjw9AV" +
       "J2QHLk67/jvxv/EfHsLNthM237z/5mItnU/486SQem4e87+Kw5c5aQbztypa" +
       "nCo7S7vgKzfvghwnrSU+GmBnvLDo66T1RU16/GxjdcfZ3a+KC2z+q1c9NC7J" +
       "rKJ4mzfPe6VusKQs7Km3WjmrCl4EBUp8yeAkmJKFzhcsusucNPnp4CDhPy/Z" +
       "Nzip85Bhv2a9eYm+BV0AEOHrk7qTnU3iIoDNa8hqXnMBT10jHuRqey8351m8" +
       "F1usW+KzsFNjstaH4Zh06ez2Hfde/8Aj1sVaUuj0NEqpg97CuuPn69SKOaU5" +
       "siq39d5YcLlmlVOnmy2F3cRd4kmsfkhBHUO92HfrNHvyl8/Xzm18+sfHKl+C" +
       "TmovCVCI1t7iNj+nZ6Hs740U91BQw8V1uK/3walNa5N//qW4R5Gi65OfPibV" +
       "vHN8eoUZCAVJzTCpgBaE5cT94+4pdSeTJoyChqwyrmXV/NfjBZiTFD8XC6/Y" +
       "zmzIz+JHGU66izvT4g9VcMGcZMYWlI5iGnxVPavr3lXh1X1WPUQvQ57FIiO6" +
       "7rTkIq79ui7O3o9ERfwP9JiY/u8ZAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "vyZMP3XnH77ut5/+Wp7A/l/qpvRe5yQAAA==");
}
