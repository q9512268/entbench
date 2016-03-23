package org.sunflow.core.primitive;
public class Torus implements org.sunflow.core.PrimitiveList {
    private float ri2;
    private float ro2;
    private float ri;
    private float ro;
    public Torus() { super();
                     ri = 0.25F;
                     ro = 1;
                     ri2 = ri * ri;
                     ro2 = ro * ro; }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        ri =
          pl.
            getFloat(
              "radiusInner",
              ri);
        ro =
          pl.
            getFloat(
              "radiusOuter",
              ro);
        ri2 =
          ri *
            ri;
        ro2 =
          ro *
            ro;
        return true;
    }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        org.sunflow.math.BoundingBox bounds =
          new org.sunflow.math.BoundingBox(
          -ro -
            ri,
          -ro -
            ri,
          -ri);
        bounds.
          include(
            ro +
              ri,
            ro +
              ri,
            ri);
        if (o2w !=
              null)
            bounds =
              o2w.
                transform(
                  bounds);
        return bounds;
    }
    public float getPrimitiveBound(int primID, int i) { switch (i) {
                                                            case 0:
                                                            case 2:
                                                                return -ro -
                                                                  ri;
                                                            case 1:
                                                            case 3:
                                                                return ro +
                                                                  ri;
                                                            case 4:
                                                                return -ri;
                                                            case 5:
                                                                return ri;
                                                            default:
                                                                return 0;
                                                        }
    }
    public int getNumPrimitives() { return 1; }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Point3 p =
          parent.
          transformWorldToObject(
            state.
              getPoint(
                ));
        float deriv =
          p.
            x *
          p.
            x +
          p.
            y *
          p.
            y +
          p.
            z *
          p.
            z -
          ri2 -
          ro2;
        state.
          getNormal(
            ).
          set(
            p.
              x *
              deriv,
            p.
              y *
              deriv,
            p.
              z *
              deriv +
              2 *
              ro2 *
              p.
                z);
        state.
          getNormal(
            ).
          normalize(
            );
        double phi =
          java.lang.Math.
          asin(
            org.sunflow.math.MathUtils.
              clamp(
                p.
                  z /
                  ri,
                -1,
                1));
        double theta =
          java.lang.Math.
          atan2(
            p.
              y,
            p.
              x);
        if (theta <
              0)
            theta +=
              2 *
                java.lang.Math.
                  PI;
        state.
          getUV(
            ).
          x =
          (float)
            (theta /
               (2 *
                  java.lang.Math.
                    PI));
        state.
          getUV(
            ).
          y =
          (float)
            ((phi +
                java.lang.Math.
                  PI /
                2) /
               java.lang.Math.
                 PI);
        state.
          setShader(
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
        org.sunflow.math.Vector3 worldNormal =
          parent.
          transformNormalObjectToWorld(
            state.
              getNormal(
                ));
        state.
          getNormal(
            ).
          set(
            worldNormal);
        state.
          getNormal(
            ).
          normalize(
            );
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r,
                                   int primID,
                                   org.sunflow.core.IntersectionState state) {
        float rd2x =
          r.
            dx *
          r.
            dx;
        float rd2y =
          r.
            dy *
          r.
            dy;
        float rd2z =
          r.
            dz *
          r.
            dz;
        float ro2x =
          r.
            ox *
          r.
            ox;
        float ro2y =
          r.
            oy *
          r.
            oy;
        float ro2z =
          r.
            oz *
          r.
            oz;
        double alpha =
          rd2x +
          rd2y +
          rd2z;
        double beta =
          2 *
          (r.
             ox *
             r.
               dx +
             r.
               oy *
             r.
               dy +
             r.
               oz *
             r.
               dz);
        double gamma =
          ro2x +
          ro2y +
          ro2z -
          ri2 -
          ro2;
        double A =
          alpha *
          alpha;
        double B =
          2 *
          alpha *
          beta;
        double C =
          beta *
          beta +
          2 *
          alpha *
          gamma +
          4 *
          ro2 *
          rd2z;
        double D =
          2 *
          beta *
          gamma +
          8 *
          ro2 *
          r.
            oz *
          r.
            dz;
        double E =
          gamma *
          gamma +
          4 *
          ro2 *
          ro2z -
          4 *
          ro2 *
          ri2;
        double[] t =
          org.sunflow.math.Solvers.
          solveQuartic(
            A,
            B,
            C,
            D,
            E);
        if (t !=
              null) {
            if (t[0] >=
                  r.
                  getMax(
                    ) ||
                  t[t.
                      length -
                      1] <=
                  r.
                  getMin(
                    ))
                return;
            for (int i =
                   0;
                 i <
                   t.
                     length;
                 i++) {
                if (t[i] >
                      r.
                      getMin(
                        )) {
                    r.
                      setMax(
                        (float)
                          t[i]);
                    state.
                      setIntersection(
                        0,
                        0,
                        0);
                    return;
                }
            }
        }
    }
    public org.sunflow.core.PrimitiveList getBakingPrimitives() {
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e+zz2FWgv983830z0+l83zw6MwydZ792aV1+juM4iXdY" +
       "2sSOEzuOndixk5jHN45fceJX/Egcs7OUImgFonR3p2xXC/MPRbBooIiHFrQq" +
       "GhYtpQKBeIjHSksrhAQLW20rLWW1hWWvnd/7e7SjGSLdG/vec84959xzzj2+" +
       "9772RejeOILgMHB3thskh2aWHC5d/DDZhWZ8yHL4UIti0yBdLY7HoO2m/sLP" +
       "XfvKVz++uH4AXVGhRzXfDxItcQI/Fs04cDemwUHXTls7runFCXSdW2obDUkT" +
       "x0U4J05e5KC3nUFNoBvcMQsIYAEBLCAlC0jrFAogvd30U48sMDQ/idfQv4Iu" +
       "cdCVUC/YS6DnzxMJtUjzjsgMSwkAhfuKdwUIVSJnEfTciex7mW8R+BMw8sq/" +
       "+87rP38ZuqZC1xxfKtjRARMJGESFHvRMb25GccswTEOFHvZN05DMyNFcJy/5" +
       "VqFHYsf2tSSNzBMlFY1paEblmKeae1AvZItSPQmiE/Esx3SN47d7LVezgayP" +
       "n8q6l5Au2oGADziAscjSdPMY5Z6V4xsJ9OxFjBMZb/QBAEC96pnJIjgZ6h5f" +
       "Aw3QI/u5czXfRqQkcnwbgN4bpGCUBHrqjkQLXYeavtJs82YCPXkRbrjvAlD3" +
       "l4ooUBLoHRfBSkpglp66MEtn5ueL/Ld87Lv8nn9Q8myYulvwfx9AeuYCkmha" +
       "ZmT6urlHfPB93I9oj3/mowcQBIDfcQF4D/Of/uWXP/j+Z17/zT3MN94GRpgv" +
       "TT25qX9q/tDvvZN8L3G5YOO+MIidYvLPSV6a//Co58UsBJ73+AnFovPwuPN1" +
       "8TdmH/pp828OoAcY6IoeuKkH7OhhPfBCxzWjrumbkZaYBgPdb/oGWfYz0FXw" +
       "zDm+uW8VLCs2Ewa6xy2brgTlO1CRBUgUKroKnh3fCo6fQy1ZlM9ZCEHQVVAg" +
       "GJRHoP2v/E8gDlkEnomEDjKMgkL0GDH9ZA7UukDi1LfcYIvEkY4EkX3yrgcR" +
       "wIgcDwi3MZFxEKXxYWFV4VtMLyv4v769dAmo9p0XHdsFPtELXMOMbuqvpO3O" +
       "l3/25m8dnBj6keQJ9BwY6fBopMNipMOTkQ7LkaBLl8oBHitG3M8b0PoK+C+I" +
       "bA++V/oO9qWPvnAZGEy4vQeorABF7hxgyVOPZ8q4pgOzg17/5PZ7lO+uHEAH" +
       "5yNlwSVoeqBAHxbx7SSO3bjoIbeje+0jf/WVT//Iy8Gpr5wLvUcufCtm4YIv" +
       "XNRnFOimAYLaKfn3Paf90s3PvHzjALoH+DWIZYkGbA+EiWcujnHOFV88DmuF" +
       "LPcCga0g8jS36DqORQ8kiyjYnraUE/1Q+fww0PHbCtu8DsrjR8Za/he9j4ZF" +
       "/djeMIpJuyBFGTb/hRT+2J/8zv/ASnUfR9hrZ9YsyUxePOPVBbFrpf8+fGoD" +
       "48g0Adx//+Tw337iix/5ttIAAMS7bjfgjaImgTeDKQRq/r7fXP/p5//sU394" +
       "cGo0CVjW0rnr6NmJkEU79MBdhASjveeUHxAVXOBOhdXckH0vMBzL0eauWVjp" +
       "3197N/pL//Nj1/d24IKWYzN6/9cmcNr+DW3oQ7/1nX/3TEnmkl6sSqc6OwXb" +
       "h7pHTym3okjbFXxk3/P7T//7z2o/BoImCFSxk5tl7IFKHUDlpCGl/O8r68ML" +
       "fWhRPRufNf7z/nUme7ipf/wPv/R25Uu/+uWS2/Ppx9m5Hmjhi3vzKqrnMkD+" +
       "iYue3tPiBYCrvc5/+3X39a8CiiqgqIM1NxYiEGCyc5ZxBH3v1f/2a7/++Eu/" +
       "dxk6oKEH3EAzaK10Muh+YN1mvACxKQs/8MH95G7vOzJpKINuEX5vFE+Wb1cB" +
       "g++9c3yhi+zh1EWf/L+CO//wn/+fW5RQRpbbLJoX8FXktR99ivzWvynxT128" +
       "wH4muzXogkzrFLf6097fHrxw5b8eQFdV6Lp+lMYpmpsWjqOC1CU+zu1Aqneu" +
       "/3wasl9zXzwJYe+8GF7ODHsxuJwGe/BcQBfPD1yIJw8WWv5GUB49crVHL8aT" +
       "S1D58IES5fmyvlFU/+zYfa+CVWMD1ugj//1H8LsEyv8rSkGsaNivqI+QR8v6" +
       "cyfregjWocuRU7371A6P16V9roK8/MjnVz/6Vz+zz1UuzuMFYPOjr/zAPx5+" +
       "7JWDMxniu25J0s7i7LPEUlFvLyqq8Izn7zZKiUH/5adf/s8/9fJH9lw9cj7f" +
       "6YB0/mf+6B9++/CTX/jcbZZiMHGBluxDd1FXi+qDe43id3SUf/7Gp3F0h2ks" +
       "HslSZKqYkKBkgL3AkPgGGfoGUB47YuixOzA0/XoYOoic2/Ez+yfg5+bXx09w" +
       "O35e+pr87M3pEvCae6uHjcNK8W7dfsTLxeM3gdUxLj/DChtxfM09ZuGJpavf" +
       "OPYnBXyWgdB2Y+k2SjLvAB+iZVQugsjh/lvmAq/U180rMP6HTolxAfgs+sG/" +
       "+Phv//C7Pg8MmYXu3RRhC1j8mRH5tPhS/P7XPvH02175wg+Wiz1QofTB7ws+" +
       "VFBd303ioloW1epY1KcKUaUgjXST0+JkUK7PpnEibfeMPP0ErPLBm5A2ubbo" +
       "1WKmdfzjFNXE2jIqrpB067JSi8U7Ybtnt5dBs9eertVZPZZJhhnQ/K5NrmbV" +
       "hTpP62au1GsmjLiYL4wpVZ3odBiE2CRmElIYbCqUiI1kn8GFHqpxtcbYlqhU" +
       "qW6iwGGxiaf0k6Cy87V1miBzPG/4ab6rit2BPxxiYZ5bpt7AYKIZYcN0BsNS" +
       "X1XZ6trvdrxcD2jV8fVZl+UFxxNxJV5vkwprTpaoyCBEBscW0hX6K41J+HyV" +
       "yL6UqUaEttDZtiqas9AbyN54bShDbTTD22AG5Ckvz4J1Sqkd1Ukmcx4VacV1" +
       "LH9NMzEt7+S6yM7iTF54aNfEK2yX9aZ2KK9geS1hRm8RLaTQxZQlRpoWLVEb" +
       "cra1VaM+Vcc9yeODcCmHrLdz14O1Mov6ib3yJt0oqA/XVMhVWizXoMWNTlIz" +
       "j1svSKYvsFkAw0PHnJJCL+hMJZ5FM0LLeZTnFFkN2dVIQwwc7TcJNW36irSS" +
       "WLQ1YbuCK6QVcsSMZ+xIQVOLdGfIchJWNyvLry/bWOiEVGbLWbxsNR2pq8pJ" +
       "XVUDctOdaMFs1kj9tleZmu2w3xjF8qYHq7pLiY0ZhkQOybd2YnslzzNhysQt" +
       "uzsKZi2ZDaxwPVd83R/l7XZY8ci8XfdCqb/eZYQfqqtYrUiit0W0Rtwl/blC" +
       "jneIlNl+pYPJ2VyNonCtWm47nTb53SSSHMHW8HSzJtrboaVRdiT3uUE+kLw2" +
       "Rq02LreacgOKQXZpL6z2VlGn1Y4Mtb7zhTq7TkarOknx25UoS2LCUgEXahLf" +
       "ElZyr5WPVE9Bd3I81laCaFTsBR9UlG69Ne906DaPyy2b3A3ywBObLFjIqipt" +
       "kGk+TJEKhk2rvWTV5VaZEwsy79KGYbUredLR5jzfSXjSr9ldIZ2GNs7N9aa+" +
       "bA/IjBo4GcN5LAo3kq6Kw7CX295caFPSfOEbkqdN3VpzOJ7i0TyGx13SzbpL" +
       "jZ6THg5LvWGqjoaCRFttu7Uc43GVsbcuBsC9KUHAeH1Y8cdO2JAUYPcNzZyT" +
       "S9b1h91a2M+VNBBXVbYibzeevEbHrabV2E2VJotLPBnW+eokp70JEdKcO1Xk" +
       "OpI17V3MyCTdSTZkoim+ZVEz34V7mzbDiPK2Iky2Bj/I2giiSpKSCy7uLSUZ" +
       "Z8gwgMNJJ+D4wYDUJHRddd0pGmuiu1v5Rm/Yg11MHgudrUs113wlHU2wuZS0" +
       "6bXSFP2h0qTQpJbTM5tKsP5iuYZb4y42QkfNasUaLMwUbkg7S+K23nJUaWN8" +
       "V1m1Vou+ELbEvuQ7UsfdSo4+qdm0JveHM17mmzRix+2k12BrtI41lsuZPOp0" +
       "Z7VMaXkiU13QfZaqwqtGKgpS1dLCelWFu3QdKHPVDGRNVVfAVtd4oKT6duQs" +
       "o5zT9ag+k+3MWotWh1lWvD47mGozlaQkl4lquVSrwNIKi9X6CB0wwnxBUMvV" +
       "epJvmXHE1s3hMsXmcIBGtd3IpNJaoNtRh52MrC1LxQujIaxpfsh3EcqexZZP" +
       "rZsKYhkCPkowUpxmzKpudESeaYXDiVuvj3rBGtFzc2w3GkrLQcYtFrP15aQX" +
       "yqKzwI25I3ank7BV07IUd2Rlge4GGuoL6MBq9rz6fGztCFrfOVRSDTtqrZo1" +
       "kBpXq1e7xlKgOW1gLOaivbLq3LaiUY1GvdogED8eJmww6Y6omRX2t1GHWWxj" +
       "b2bqYdiMCdSR7bAyz7ZGKiCwsSXiWj7jaNoYslxrXM1qzIgj6dZwgOUwDjf0" +
       "CpehsABjc4FpD+dblBrR1NaNVUR23Y4UklgV3QrtMSMzNj0fm2rcJdbuip64" +
       "s9BczPx8FKdpPbSI3OgLWWshNqZLVrUsu48g9TWKD2rTBENm+dpkd+qCsfSs" +
       "OVh0jQmyU9MKOu7GBkoPNcNHTGpA9KmOoC8SN+r34ohizc6sw+Ehj1FEBE8T" +
       "Qu1mrmHHccB1e4i2GQ26YzclcNhCwwlBIMSCtebzhUOmOOpXxQppDUnV77SB" +
       "WlRKrs1ZMu4ZvGk1NkQ/wIAN4YuM7GpyIO+2fLgadbbxYoeRQYhKCJLk+Xyc" +
       "mGuHAvFdnKDadGAGq0ZXXfXRVTXpMeOxHdH1pbHUYzHqhR2vTZOuhTKdVo4T" +
       "tToxdyl93sY2IDjIiEkMyYwk8j5F9Xq9AW45YgemaQXHzEqDWAvIFPF6CzC3" +
       "ZidbNZyJG6BeZ06oCL/2KRhBdrLYWw0ZnJdppQMzprTMK9u0aikCnlvUbslg" +
       "yirIV8HI7WEmPUM8JJtu1sNQ8enRECwN6noqYNJ6zc+XQSdRMZeOiBFZs7pb" +
       "bKL1O+v6hmnhfBYNWl5/Gej5cLEhBXRow5zYJ+o+mIUmNa4tF1UpF+vZaIHU" +
       "TTn24WEie7tUn/E0r4mK0NqIEicF/XwQMtnEi52+Ps5pnzIiik5HMFtJuZ2H" +
       "0dtWA58JVmtS5ZAIX7dGBsULbK+JJerUCBtLez7qxnA8UWCj1QhGcY9ZOssJ" +
       "x/pN1qJY4CAznstGuMiOp5jQn2qtNTEZISBNrdliW2UbHoHohE7RWU0mZS3l" +
       "OrxALRqNXDO5dLRj6k7AAdPsa0LTXjp+fUEtNSrl1jSuidvlRkGExhSri3yD" +
       "qi0UfmZxKKZsBX/TXCJNws2XdTzTvXU/b+U9iTVnHRsPlV5k9oyOFBmIUO1O" +
       "iXw85TrmwB9s1vMOqs6B1eX8Aq7vqg2h1zI2bo80CK9nKlstc1huphid3kqp" +
       "7ggnRjuzGW2xfX6Wm1o6jecrJVcUy9bgOZMz+QoXcXq8S5ZxPuks2XybCFtJ" +
       "nDQU0k3FtO8Nko7kSulW7DXkKrNyiJnb6XpKh/bzxPU9ElaaiqNmop1OQFPb" +
       "QXqVCd1TaWKO+jjIAOwcqBSbajiJb60hvJjhLk+hlamBcvUOw8fr9ma67kny" +
       "2u6y6Hgx7nemaNMS0B6MWF6vsZliyESYs9XBUkaISAE5SNRDYJMyd7WkN9k5" +
       "Uu7lCIypE3TuGqudY7FNaySt6mAVJJYNdLurcji2BHG0TbJrwZaYOJfp6Xwz" +
       "CQe7KjEmKb+KJkgliZIqKhAbqxfJDazZctx0oIQgh2N2iu4LRLBhtjwzlmRZ" +
       "5JMdqUQkzvBOgqS2UoejLqz0xT7iNCvwum8kzFYIbWIwEDodzarWuA3fFLyp" +
       "OENRea0ZPcbZwB7ZwJHGHNYl3NygDXJZhSnCzCu2CnMzxrcnQqWV+put6Xb7" +
       "PNMecTDSjRlugTumLFkik7s6h04FhlJNiuiM1V6XXcGjxJuCVJePeCXhJgLe" +
       "aTYT8D017BMRM1lWW3jSiezubLz0p60V1rIleQvy+n6sSrv6sosqfToUs4Va" +
       "XZgoiy1xs53Gfjz221Kbtxu6oi4da9ii6voS3baFdrKdU7XmOkMHyqpp5i6g" +
       "Mx3DqupleIPCBUng7Y6J+JZu1/SRb40dc2Oz2yaZ9lyLqghUhI7bdUFe5641" +
       "VUx5vtXzjh/IU0cdR/5MryotOKtU1WwRDuRsLZEzfrAiVgk7WaYhl8XjrBHO" +
       "wfpaNXsgwxV2E14FTk2KLcWSmAmnTmLRDVNXN4i63e8vnT4z3WzdWc1fJiMM" +
       "+KggbmbWQOt1R7JLyLkibvFGfdiAF0qLxgf1yagxnI7wjlGpmFihI1WEo2Y+" +
       "Yye52V7EnQytRNuRG7HCrjHLa04D206c9tjeDKSNh3RNlZ6L4i7KZrIMm9pu" +
       "oaZaVkUbC1obY01tYGpxN460qL3CcnszivR+P9lGZkSnSk13Ng1+J+SSSxAg" +
       "KgWL5bgpTVmiNWCSnT3aOGO8NRi7BNoa97tqbsG0Q/YzqbdotYEhLpxUAEmA" +
       "tOs30YrDmDWU5Oi2u6q0+77fwWtUdVIjZR+N581JnZ5nRORoVVob+ko8Q5qG" +
       "22hsV9xi5SpKmGd1PRzVBD/tw2g9pUFA03O1GmmxIC3rOjKYTkSzGgYde1Nt" +
       "TBfClnfqzHSmpcMuiCzmSFkbWMfytaaamoiOtdcbflvh8e5swc5AOux06yQ5" +
       "0wcLlU7XMNPi8a0K8wZY4xlrucZVH0Pi8QZ4fm3VgpNcJCaLer1BTE0WU4mU" +
       "URGfDcj2jtVqtDHma0Tk1VdNLVCFOjEUWWfa1OJFpgvkHN9MHXecdSKhHzkp" +
       "M+zOFZvjxxXN1msNwsKHZk3t98Rm3KostymFCXTaa0w1cSi2iZgjKuu4ufXZ" +
       "VJ/0sTY2po3YlvqJRU8tdoNbuDrzlVa1+MAuPrlffmNbAQ+Xux4nx7lLt1F0" +
       "eG/ga3/f9XxRvftkd6j8XYEuHAGePXA43YW+dLzD8swtx2cne4Lljn8cQU/f" +
       "6TC33DD81IdfedUQfgI9ONrk5xLo/iQIv9k1N6Z7Yd/7fXfeHB2UZ9mnm8+f" +
       "/fBfPzX+1sVLb+BI7dkLfF4k+R8Hr32u+x793xxAl0+2om85ZT+P9OL5DegH" +
       "IjNJI398bhv66ZMJePR4e+6Zowl45uL23OkU335v7pv2JnLhDOWgBDi4y5QV" +
       "ejATMyqm7Bjs8bNg0v6/NWTKET5xl1Oa/1BUH0+gK2loaIl5u82pq/MgcE3N" +
       "PzXWf/21tqbOjlI2/NCJ2p4oGt8NynuO1Paet0Ztl85b+pNn9eFpyeJwoCWR" +
       "k9VK5J+6i0ZeK6ofT6CHbDOZBJFrtIPUN+Jjwu+8hXDZ7/h2O8hOVfSpN6Gi" +
       "0r1fAOXwSEWHb71lXZjjy45fbuX/Son4y3dRz2eK6hdAWAPqOQkepQqKDvZU" +
       "A7/4JjRwrWh8FpQPHGngA2+NBs4K8tm79H2uqP5LAl0HQvKpdyJnCfwrpzL+" +
       "+puQsTwWb4BCHslI/pM4wtO3xA9poRXmWlyVMksKf3AXTfxxUf1OAniKzFCL" +
       "zLPIt93J3gSOcaqg332zCuJBeelIQS+9NQq6vF+ujxX02C0KErXd6TwDiBdu" +
       "gWCKa1zx/gD9VI9/cRc9/nVRfT6BHnGOUU+Mquj501OVfeFNqKxYjqD3g/K9" +
       "Ryr73rfeb/73Xfq+UlT/C1gL8Ju2tgKGct51PnIq5pfeiJhZAt1bXu8p7io8" +
       "eculwP1FNv1nX7123xOvyn9c3nA5uWx2PwfdZ6Wue/Zo+czzFWDYllNyf//+" +
       "oDks//4hgZ6682UjkPaE5yT7+xLrEgRixkUs4BTF31mwywn0tjNgYI09ejoL" +
       "dAWEZQBUPF4Nb3NGtj9ozy6dSbugMyvQI19LwScoZ+/BFKlaeTfzOK1K97cz" +
       "b+qffpXlv+vL9Z/Y38PRXS3PCyr3cdDV/ZWgk9Ts+TtSO6Z1pfferz70c/e/" +
       "+ziNfGjP8KlxnuHt2dtfeul4YVJeU8l/+Ylf/JaffPXPyiO7/w9fekCVNCsA" +
       "AA==");
}
