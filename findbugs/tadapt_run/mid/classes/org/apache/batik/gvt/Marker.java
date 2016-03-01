package org.apache.batik.gvt;
public class Marker {
    protected double orient;
    protected org.apache.batik.gvt.GraphicsNode markerNode;
    protected java.awt.geom.Point2D ref;
    public Marker(org.apache.batik.gvt.GraphicsNode markerNode, java.awt.geom.Point2D ref,
                  double orient) { super();
                                   if (markerNode == null) { throw new java.lang.IllegalArgumentException(
                                                               );
                                   }
                                   if (ref == null) { throw new java.lang.IllegalArgumentException(
                                                        );
                                   }
                                   this.markerNode =
                                     markerNode;
                                   this.ref = ref;
                                   this.orient = orient;
    }
    public java.awt.geom.Point2D getRef() { return (java.awt.geom.Point2D)
                                                     ref.
                                                     clone(
                                                       );
    }
    public double getOrient() { return orient; }
    public org.apache.batik.gvt.GraphicsNode getMarkerNode() {
        return markerNode;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0Gye//2/fxM8+ac3ihSCQFyDPBAevpdlRh7TW70OElYFVp76x/5vvjMEIDSA" +
       "ajKqvCdDBuJOsdCDmZmYw2N2c8QnnPYx71DkWwqO4NP3cUVCeXUQVwfxtc1s" +
       "6DKdWOz2l6PNjkpPvv1Zw7bPLt3kNrv7dCf0DGJdHHgzGxazA5/trXv92EwB" +
       "3X2Xt+xsUi7fAomjIFGCWm0OGVBpsy6gsqirqt979Retu65WIH8fqlM0HO/D" +
       "HPNRLYAtMVNQpLP61x4UWDNRA0MTNxUVGM/Se35x4NiQ1ilP9cmfzP7RmhdP" +
       "v88xToDaHCvN2fXAW575Hc+uLJ9ef/bDn089Xy0iqEw+ePja/jmkxA7+5YuC" +
       "Q+aFtEiKePhHQ+eea+994BPOb1c0xr0oW9jdQM23ee85m/67vzPwKz+qHkVN" +
       "knWf2oaVDKsTo3CHMHOXLLhzudbd9wHR/PbkK/Zcb446tvXWUmfUV1JXhNvl" +
       "czrz4lx4uq3K0u0tnz7EX3Zylm4+LmHD8ly1qtUNjYKWJO4pWA1lxEJ2a4ZM" +
       "VF59ekSJZmOYDQ8LQUMlI3CbW38mfJm10bIS+gsY6WZDtFDNUtwU1aV548lK" +
       "DZtZ5VE1cYeqtsOzwtpsRQlVlbKqluKmqMIgCfa62qNjuoyOWXuvpfm9+F8A" +
       "ea4mznbDzmHEYGleqdsjrwFnDh4/HR96YaXfAsteiBmq6XcrZJwoHjhYWAAH" +
       "g/zObOfW6mtTFdefaqsvbNSZpI4SbfjS0rjh3eC1g39r3/pAatcddODzPfZ7" +
       "Rf5g8NwbG7ulp/z82i9SueBzgZupx53AdQahGUN1F6rOvMdmME/cBc9my2Ob" +
       "vbFlx4TH2fneshRrmbL3jTJrT7DhMcjzJKHDVmDaMbn/dnnjKjJsYiufnszr" +
       "3cKW5sAzbOk9fOcml2ItY9a3y6x9hw1HILrB5CEb3Wyrv/U/W93GlhbDs91S" +
       "ffudW12KtYxlz5ZZO8WGExQ1gNWDbrC0LX/mzi3PQuwIeazJaCv4jCg+fUkX" +
       "TjfWzD790B/4zTP/eaoemvNERlGcNdDxHtABK2Wufr2oiDr/OUPRzGJXDgBX" +
       "GLmizwvKFylq8lJSVMV/nXRnoYTYdGCSeHGSnAfpQMJeL+i5+0wTb6pYExAU" +
       "TUDW50bd/NHOut3ROoB6kQsG+QfcHGRlxCdcuAud3rTl0ZtfeUFciSUFT04y" +
       "KdOgdxa38zzsLSwpLScr0L/k1vSXahfnoL9ZKGzH6BxHIG2FdkJnvm733BfN" +
       "rvy18d0zay69dThwDbqyHciHKZqxo7BdyuoZwOQd4WK3BCgK/CrbU/fhritf" +
       "vOdr4V0pEveKjnIcUenYpeuRhK5/z49qB1AVVDaS5b3c+r3qMJHGDdelIxDT" +
       "Mmr+W+90FpiYfdzlJ2MdaEN+ln1Soaiz8ApW+JkJGvYJYqxj0nkp8BSKjK47" +
       "V/nJbmTDmiw7aYi1aHhQ1627Z+AcP3ld5zn3Khv6/wvIdm4JpRkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "5C6V0lU8odtUqaUtOu7aqaEobgBY2RTrWiFVNlVMG5oxOV1uaNWiu/Iy8Wq4" +
       "tll5ctwfaGWpi+LErIsQwVREDDOwImPd14LyCJwm1np37razPcLE11e82a0g" +
       "aRlb4sXGaEQqQmWKqnCALtkOTZGabrcTEuxkAliCsULLtyaGloItJ6spzR5s" +
       "u0UBbF3A4cqX4M6iQ60nnckymRfchV/Hhe68W64Bq3amzpB0rLimTKyiQpuD" +
       "YrVUk+GGyqG2VkldtGuuq0i8bmtOuePzC3CAe9ObsqNd+sqOnLfkp+v9l4Pg" +
       "sJB1zF/BqXLb9WBWPLJ/DZF/zkDHXigdvqM+uDmDsru9e6/2zi+/xXz+fc88" +
       "p/U/UTy5e+P4RASdjTz/Dba+1u1DrE4BTo9f/RKOzV95HtyEfeV9/3r38M3m" +
       "O1/B65X7j8l5nOXvsS98jXpU/dBJ6NT+vdhlL2OPDnri6G3YuQAksMAdHrkT" +
       "u3ffsrdlFnsNeLq7lu0ev+A5WLsr3+68brv217jQffoafR/Kig9E0JmZHvG7" +
       "t0MHjvIbL3f9cJhd3vDUvma3Zo2vBQ+/qxn/89fsY9foey4rPgo8C2jWP7gj" +
       "PFDu2Z9BubuyxkfAM9lVbvLzV+6T1+j7VFb8TgTdBJRjj142Hij4/CtRMAE+" +
       "sOWUvdW567J/Vmz/DaB+5rnzN9z5nPg3+bvA/Tf2ZxnoBmNl24dvgQ/Vz/iB" +
       "bli54Ge3d8J+/vX7EfTqK70EiqBToMxF/NyW8vMRdOE4ZQSdzr8P030xgs4d" +
       "0AGVtpXDJH8EuAOSrPol/wq3jttr8OTEUUjbN+qtL2fUQyj48BHsyv/Tsocz" +
       "q+2/Wi6pn32u03vXS9VPbF9SqraSphmXGxjo+u370n2sevCq3PZ4naEf+/HN" +
       "nzv7yB6u3rwV+MAVD8l2/5XfCDYdP8rf4aV/eOfn3/i7z307vwT9P58PVSxs" +
       "JAAA");
}
