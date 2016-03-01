package org.apache.batik.ext.awt.image.renderable;
public class ComponentTransferRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractColorInterpolationRable implements org.apache.batik.ext.awt.image.renderable.ComponentTransferRable {
    public static final int ALPHA = 0;
    public static final int RED = 1;
    public static final int GREEN = 2;
    public static final int BLUE = 3;
    private org.apache.batik.ext.awt.image.ComponentTransferFunction[] functions =
      new org.apache.batik.ext.awt.image.ComponentTransferFunction[4];
    private org.apache.batik.ext.awt.image.TransferFunction[] txfFunc =
      new org.apache.batik.ext.awt.image.TransferFunction[4];
    public ComponentTransferRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                                      org.apache.batik.ext.awt.image.ComponentTransferFunction alphaFunction,
                                      org.apache.batik.ext.awt.image.ComponentTransferFunction redFunction,
                                      org.apache.batik.ext.awt.image.ComponentTransferFunction greenFunction,
                                      org.apache.batik.ext.awt.image.ComponentTransferFunction blueFunction) {
        super(
          src,
          null);
        setAlphaFunction(
          alphaFunction);
        setRedFunction(
          redFunction);
        setGreenFunction(
          greenFunction);
        setBlueFunction(
          blueFunction);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public org.apache.batik.ext.awt.image.ComponentTransferFunction getAlphaFunction() {
        return functions[ALPHA];
    }
    public void setAlphaFunction(org.apache.batik.ext.awt.image.ComponentTransferFunction alphaFunction) {
        touch(
          );
        functions[ALPHA] =
          alphaFunction;
        txfFunc[ALPHA] =
          null;
    }
    public org.apache.batik.ext.awt.image.ComponentTransferFunction getRedFunction() {
        return functions[RED];
    }
    public void setRedFunction(org.apache.batik.ext.awt.image.ComponentTransferFunction redFunction) {
        touch(
          );
        functions[RED] =
          redFunction;
        txfFunc[RED] =
          null;
    }
    public org.apache.batik.ext.awt.image.ComponentTransferFunction getGreenFunction() {
        return functions[GREEN];
    }
    public void setGreenFunction(org.apache.batik.ext.awt.image.ComponentTransferFunction greenFunction) {
        touch(
          );
        functions[GREEN] =
          greenFunction;
        txfFunc[GREEN] =
          null;
    }
    public org.apache.batik.ext.awt.image.ComponentTransferFunction getBlueFunction() {
        return functions[BLUE];
    }
    public void setBlueFunction(org.apache.batik.ext.awt.image.ComponentTransferFunction blueFunction) {
        touch(
          );
        functions[BLUE] =
          blueFunction;
        txfFunc[BLUE] =
          null;
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        java.awt.image.RenderedImage srcRI =
          getSource(
            ).
          createRendering(
            rc);
        if (srcRI ==
              null)
            return null;
        return new org.apache.batik.ext.awt.image.rendered.ComponentTransferRed(
          convertSourceCS(
            srcRI),
          getTransferFunctions(
            ),
          rc.
            getRenderingHints(
              ));
    }
    private org.apache.batik.ext.awt.image.TransferFunction[] getTransferFunctions() {
        org.apache.batik.ext.awt.image.TransferFunction[] txfFunc =
          new org.apache.batik.ext.awt.image.TransferFunction[4];
        java.lang.System.
          arraycopy(
            this.
              txfFunc,
            0,
            txfFunc,
            0,
            4);
        org.apache.batik.ext.awt.image.ComponentTransferFunction[] functions;
        functions =
          (new org.apache.batik.ext.awt.image.ComponentTransferFunction[4]);
        java.lang.System.
          arraycopy(
            this.
              functions,
            0,
            functions,
            0,
            4);
        for (int i =
               0;
             i <
               4;
             i++) {
            if (txfFunc[i] ==
                  null) {
                txfFunc[i] =
                  getTransferFunction(
                    functions[i]);
                synchronized (this.
                                functions)  {
                    if (this.
                          functions[i] ==
                          functions[i]) {
                        this.
                          txfFunc[i] =
                          txfFunc[i];
                    }
                }
            }
        }
        return txfFunc;
    }
    private static org.apache.batik.ext.awt.image.TransferFunction getTransferFunction(org.apache.batik.ext.awt.image.ComponentTransferFunction function) {
        org.apache.batik.ext.awt.image.TransferFunction txfFunc =
          null;
        if (function ==
              null) {
            txfFunc =
              new org.apache.batik.ext.awt.image.IdentityTransfer(
                );
        }
        else {
            switch (function.
                      getType(
                        )) {
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       IDENTITY:
                    txfFunc =
                      new org.apache.batik.ext.awt.image.IdentityTransfer(
                        );
                    break;
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       TABLE:
                    txfFunc =
                      new org.apache.batik.ext.awt.image.TableTransfer(
                        tableFloatToInt(
                          function.
                            getTableValues(
                              )));
                    break;
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       DISCRETE:
                    txfFunc =
                      new org.apache.batik.ext.awt.image.DiscreteTransfer(
                        tableFloatToInt(
                          function.
                            getTableValues(
                              )));
                    break;
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       LINEAR:
                    txfFunc =
                      new org.apache.batik.ext.awt.image.LinearTransfer(
                        function.
                          getSlope(
                            ),
                        function.
                          getIntercept(
                            ));
                    break;
                case org.apache.batik.ext.awt.image.ComponentTransferFunction.
                       GAMMA:
                    txfFunc =
                      new org.apache.batik.ext.awt.image.GammaTransfer(
                        function.
                          getAmplitude(
                            ),
                        function.
                          getExponent(
                            ),
                        function.
                          getOffset(
                            ));
                    break;
                default:
                    throw new java.lang.Error(
                      );
            }
        }
        return txfFunc;
    }
    private static int[] tableFloatToInt(float[] tableValues) {
        int[] values =
          new int[tableValues.
                    length];
        for (int i =
               0;
             i <
               tableValues.
                 length;
             i++) {
            values[i] =
              (int)
                (tableValues[i] *
                   255.0F);
        }
        return values;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAM17e7Drxnkfz5WuXpZ1ryU/ZMWWbEvyQ7QvSAIkyMovvkAA" +
       "BEkQD4Jg3ch4A8STeBAgbSW28rCndh03lh174qj9w+kjUWxPx2kz00nqTiaN" +
       "U2fScSaT9DGJU7czSeq6tqeTpBO3dRfg4TnnnnvukW7udaacwRLY/Xb3+33f" +
       "t99+C+w+/63SxSgslQPf2RiOH1/RsvjK0qlfiTeBFl0hqTothZGmdh0pijiQ" +
       "95Tyhi9e+ovvfdy8fKF0x6L0gOR5fizFlu9FjBb5zlpTqdKl49y+o7lRXLpM" +
       "LaW1BCWx5UCUFcVPUqWXnKgalx6j9ixAgAUIsAAVLEDtYypQ6aWal7jdvIbk" +
       "xdGq9COlA6p0R6Dk7MWl11/dSCCFknvYDF0gAC3clT/PAKiichaWXneEfYf5" +
       "GsCfLEPP/swPX/5nt5UuLUqXLI/N2VEAEzHoZFG619VcWQujtqpq6qL0Mk/T" +
       "VFYLLcmxtgXfi9L9kWV4UpyE2pGQ8swk0MKiz2PJ3avk2MJEif3wCJ5uaY66" +
       "f7qoO5IBsL7yGOsOIZbnA4D3WICxUJcUbV/ldtvy1Lj0yOkaRxgfGwICUPVO" +
       "V4tN/6ir2z0JZJTu3+nOkTwDYuPQ8gxAetFPQC9x6aHrNprLOpAUWzK0p+LS" +
       "g6fp6F0RoLq7EEReJS694jRZ0RLQ0kOntHRCP98av/1j7/Nw70LBs6opTs7/" +
       "XaDSw6cqMZquhZqnaLuK9z5BfUp65a9++EKpBIhfcYp4R/Mv3v/dd7/14S9/" +
       "ZUfzQ2fQTOSlpsRPKZ+T7/vaa7pvad2Ws3FX4EdWrvyrkBfmTx+WPJkFYOS9" +
       "8qjFvPDKvvDLzL8RP/AL2jcvlO4hSncovpO4wI5epvhuYDlaONA8LZRiTSVK" +
       "d2ue2i3KidKd4J6yPG2XO9H1SIuJ0u1OkXWHXzwDEemgiVxEd4J7y9P9/X0g" +
       "xWZxnwWlUulOcJUeB9cTpd3vzXkSl34CMn1XgyRF8izPh+jQz/HnCvVUCYq1" +
       "CNyroDTwIRnYv/226hUUivwkBAYJ+aEBScAqTG1XWIxTKY0hywXGAAHlqACY" +
       "7GhQF0D1Pc2LuVDyIqA3Js9udizgn4A5Bv+/MJLlErucHhwAZb7mtCtxwCjE" +
       "fQc09ZTybNLpf/fzT331wtHQOpR1XOoBbq7suLlScFO4YcDNlYKbK8fcXLk+" +
       "N6WDg4KJl+dc7awJ2IINvArwt/e+hf075Hs//IbbgBkH6e1AkTkpdH233z32" +
       "Q0ThbRUwGEpf/nT6wdmPVi6ULlztv3MkIOuevDqde90j7/rY6XF7VruXPvSn" +
       "f/GFTz3tH4/gqyaEQ8dybc3cMbzhtMxDX9FU4GqPm3/iddIvP/WrTz92oXQ7" +
       "8DbAw8YSGBHAeT18uo+rHMSTe2ebY7kIAOt+6EpOXrT3kPfEZuinxzmFMdxX" +
       "3L8MyPgl+yH0rsMhVPznpQ8EefrynfHkSjuFonDm72CDn/v3v/NncCHuvd+/" +
       "dGImZbX4yRO+Jm/sUuFVXnZsA1yoaYDuDz9Nf+KT3/rQ3y4MAFA8elaHj+Vp" +
       "bmFAhUDMP/GV1X/4+h997vcuHBtNDCbbRHYsJTsCmeeX7jkHJOjtjcf8AF/l" +
       "gGGaW81jvOf6qqVbuQnnVvq/Lz1e/eX//rHLOztwQM7ejN76wg0c57+6U/rA" +
       "V3/4Lx8umjlQ8rnyWGbHZDsH/MBxy+0wlDY5H9kHf/e1n/lN6eeAKwfuM7K2" +
       "WuERLxYyuFggf0Vcqrz4UYtZDpgt9xWbL1DxmjGOJZ6yV3DtOCmsBypafaJI" +
       "r+SSL5gsFWX1PHkkOjkKrx7oJ4Krp5SP/953Xjr7zq99txDb1dHZSaMbScGT" +
       "OzvPk9dloPlXnXY5uBSZgA758vg9l50vfw+0uAAtKsDxRpMQCCW7ykQPqS/e" +
       "+R//9a+/8r1fu610ASvd4/iSiknFaC/dDYaZFpnAkWbBu969s7L0LpBcLqCW" +
       "rgG/s84Hi6e7AYNvub6jw/Lg6thXPPhXE0d+5hv/6xohFC7ujJjiVP0F9Pxn" +
       "H+q+85tF/WNfk9d+OLt2hgCB6HHd2i+4f37hDXf8xoXSnYvSZeUwyp1JTpKP" +
       "4AWI7KJ96Asi4avKr47SdiHJk0e+9DWn/dyJbk97ueOZCdzn1Pn9Pacc24O5" +
       "lN8Irrcejvm3nnZsxVS003HO0hUCBKWGFt7/jX/4ub/84IeaF/KRdXGdsw6k" +
       "cvmYbpzkwfRPPv/J177k2T/+SOF59k13i+5fX6SP5cmbCv3elt++GTimqIjL" +
       "YwDH8iTn0EF9H/wOwPV/8ytvKc/YBTL3dw+jqdcdhVMBmIwvtikab59vNHRo" +
       "ucDlrg8DSejp+79uf/ZPf2kXJJ62kFPE2oef/bvfv/KxZy+cCM0fvSY6Plln" +
       "F54XKnhpnlD5mHv9eb0UNbA/+cLT//KfPP2hHVf3Xx1o9sE66pd+///89pVP" +
       "//FvnRGR3AYWEbu5KU8bedLbSbR13QH4zmvN422H5vG2M8wjv+nnc0p+I56n" +
       "2zwh82RYyIAC7DH9Xn7LnOJx8dfg8cohj1fO4fFCfiPdGI8XB0y/Pz6LS/mv" +
       "wSV0yCV0DpcFJ9aNcXl7h+L7ZzG5fPFM3pvn1sHVOGSyfg2TpeJmdTZvIKq4" +
       "MwitNRiBe7bu1g+nvAiY+uPXH4jFlL0bV8/9o0d/50efe/Q/F5PNXVYEfFw7" +
       "NM5YOp6o853nv/7N333paz9fRIa3y1K083an19zXLqmvWikXTN97tTge34vh" +
       "LHEUs3cQBKVTMg9vUOb5yuwdh528/Toyf/o6Ms9vk72474wzPQ8yCqr06k5e" +
       "s2/8rE72IQ30AiHN6UjmDPA/8oLgd77vAJjLxdoV9Eolf/7wjZn7q5aO8tje" +
       "789ASAZ4eWzpoHscJ2ai3auOU0xSL5pJYLf3HTdG+Z7x5Ef+68d/+6ce/Tow" +
       "UHI/9+XUGNAG/an+5XfnD3//xvA8lONhizUtJUXxqIiGNfUI0uQE0ywY7Y5/" +
       "E5DiB76EIxHR3v9GVUmDp7OMcXWtMtLMvtq1Ca2Jp30qDassI2x6y6zdZbpN" +
       "k0wHvE/IY9h2N5GnwrVFRaasJjOHezxvJb5AzLlOayE0Z5gs1BIa67fCqgbm" +
       "NLIuxBQq+5nYSs3yMJyFqM5NUBXSk7UcmTa+khRY3Kg1rexqELzWJLmmevCI" +
       "dWtcjyJtirWxAR32BiHmhj2NJG2BU6XAdvnYlNW4acBrdGw20cm8LDSGdkDy" +
       "IzQYRplM2pUpP5wtxsIwc0OpI3Fj0pGWi6lrSxQZdMRqshHcBuaHA2kh9lin" +
       "NxNYjFIlDutFkdNM+wOWyBZWGEu8KKPtvjhYQAY8mtbHECbpiCZ1OrbfaIoN" +
       "p9bhe/ZADVIYDeJtneqLq35VJeAZ0dwy06rntKNZMMo2mjsIV2g4w3nBz2wh" +
       "qQxVebq20oiL6B420lZLK9q0EnQV2qJprKRFOJn02dCdrRo1u8Z1Z5S5XlXn" +
       "khJI0wZiM1N7k44nC1tb9Uc1WyF9uBe061qcqSmNmKvGjFW3ST9dNKbstCIN" +
       "BqQrThDDdGfUEIidbKbp0un15clGGcSdyUbqVKvlTU/TvKBZL9fms21dYbqB" +
       "xIqCFbNtdLTsdUSSFPpdcxzPaG5lV1xJHs56Y6yNsDA/6zIzQWiFSTNgJ0uB" +
       "DJR+H6dwY4MyHY5reMPNekoO2tvKluK27KbZc+t8awVZPWe+6gy3vbmUdpEp" +
       "2eylPQoTeiOU7LVb7obVV9GMUrx4SCqWheINIjHawZAPNmFYQTGuNW47mt0N" +
       "TGK1slVlIae0VeESE4TII9KNt0LbWGACk7BrLFwFg9poSXOwlJHjyjCCsJRl" +
       "Rz1qBCM1uoP5Ul2dsMy2qY+bqLq2MTnoz8gObk54x8EgQ2lXOEPnOTr2uyJG" +
       "Z91+u6F4cjAZ0CgSs4ZZwRM5pOiwqSY0061JownUrTR6kwaA5aAzderKc1Jr" +
       "Rfh6y7pyHMBW0B2P7AmMYUy551HJgq/W2Ao8MPrGlu5F1jiSlMygx3q1nlVl" +
       "uKKQLD+ut1lhpnNDubsk5KE2MtmZayQBY9fIijDtNfhyddGpruVN1+H7TX9g" +
       "ztYOzFQEclq1cWSlVwWr2WoavoGIbXvG97wZ1mh11cQaZJSD0gOCnfLeksBw" +
       "y+1DOEyxqZiwqBZIqj8nCYdT8YpGTgICrvNDolmvEmSj7/hjWkUmrbDVqK+2" +
       "okdZTlCppBvKTNRIdCLCT4bmqu5VglCYZaTB4f0p55DtsZTwhikPeXq+GkmC" +
       "G5CuoTakps7XmxlLsIPuJFs3KSJz+dq4W7Wnhq8gKeQMl4YpxhVMXKxsWHPr" +
       "LV7XpV4sCAMwple1sOMueq1tv9NTsq1RodejzniJjzgFdcnOfNwjTHySdT3C" +
       "kdtuRMxnfYw3wnZZqXrUwpSSGsf63dFWFlrGGBNjLQDLMcVj4rLXE5acisL8" +
       "epJh9eZ6vVWHvtk1a+5gobQ0qRFsqoy1mQUWypFtFvWxOW7J2wzBBZfoQHY6" +
       "bFSF+mJN+/QWmVXKyqhjWXhGwD7TobcxFnOtCOusYDGJcG9bRWobWe2x7Xqj" +
       "PtguJwtGdDZSHdPqOLyRabzWbfWXMlJPVn5jqnd6EdHsp10T4cSJgkBMpd5c" +
       "eZhFC0TQbrbVJHDZ2SDbtL1pvbGlqrGGyLIf9zS6wvN0v50hNB1vayLU1AVk" +
       "KgkEwsV+BCM83a3Wx6kgQlpIwRlCmhoclTNeo4cYFgUretifdBprayrUCAkh" +
       "KY5fmXCWoK4nK+U1LjjqtuyPdHtqjgURsQc9y++PZhDcIoOejNbqrbrgS+ho" +
       "VF0HlUmDGbtsRuh9aDitdC1PXjenQ5Mn+JVRnU3XlWZ75UwRjJ5aan2UDIfy" +
       "SCsLJhrI7R6mIshiyS7rKa60GvqEqAKNQG6mzDeiRWRUzEbbuJ4QUIVWbSEe" +
       "89UVrg/YGt7J0KxKs7JjkgQeyBsvHLZhInMq/YzZNlibm0zomhHxGCOGHbir" +
       "wL6xbUdZtzWUUCDtpROnja1LLbPQqy9sX1MQGxFgPZMoqekFZrgao0oY1cra" +
       "Yr40Mkl3OYhnGzV4wk0lmKVIaTyo9WyB3xIp1DahDItsYQZP0UbaWy5UYWVo" +
       "ZaODySI/XSBho5q1WXOBk6PqpK7O6VDqw01lnawcwiTV6SiYzXk/sSkLtiHU" +
       "WMTcylha2khpQFNsuagtCX+4dHjbUDSMS8rRyOODdDtw5G25wgwgz1vT3lKr" +
       "q9N4i0cwyW62I1avdVyhCZ6Wm4oWw+u1hovbZowJHhlPOu3GaiSXtaYjrdcz" +
       "FG5oZG2qTY3E5npoo7q2yklFnnlzTaygSdYb2t4CIuZTYlmjkhqMVqqtQVDl" +
       "my7LO5TEsrEzQQKVkkx/yXQjOwwkrsZPLK810VyEHS6HkTtorPHyZOIvqgGE" +
       "4fx8vjKXciOlm8Z8YktLbKX3RtGAHvZwyKh3kzjqYvZQFduTueKNpbUGqbgG" +
       "Zv+aZ46x7QZOmHjRGQazZN0ELJpCAsN6WGv3URhtMI0WsihbRBmaMRoXja3O" +
       "UsOJ1XZijjpeU6jg7a01JFduud0zLBOzjRVfqVBS6CwTKxu2MiRecTKlLuyh" +
       "5RLIuFoT1lujORiHkMM29LDBNU3R6nOVdWRKUHlsWa3WGuk6g4GlYCzTGGqk" +
       "DAkoPY24utBtSpBJpRStQ52OuR5gbK8bNpI0UitEbcvxoxY9mo4gtWMNyivN" +
       "XVfnDKRQmx4iq+HcFVBZU+h5pFVQRjXmWgPMQyqYVxFYpFJgrsOsjVrSYKsQ" +
       "ARZuIWQo6xC85WYRNpsJqDtPm3INWkPNeLaNZtU1XR0ZDJuxKF1JssAhxv5I" +
       "RmNtYmDTjQRp0NiBoAYYThMmIIRZwFVXTDDdUvOyncQqFeNzDUm2NE8Ad7Tq" +
       "xBTVkNqYzXUMQRxj02BpaiLGRByqBzVZWixXW6PfMhcc1k0Rn62bHXE8oBk+" +
       "anPGSmyPOHkOpuwVySHGrJ62bdJosZu0z3amYd2we92F353jganA1Za46ftV" +
       "w2lb6nqb9SeGgouw1+vyftcWG5yyjqRNuU8OxxnSsgmqofYUaNFasttmvT2d" +
       "h25t1O4RVD8a82V3IE7opS62twKBdQaap4uaOnA8aLb1F0MvFskY2qqVdgtq" +
       "KZtVxR5Z7c50koXI1vIUmKYjDhLKuF/towHqIxg05PsTJB32K2QvsLX1Wm7K" +
       "NEG5kDrSfcVjXWHY0SKvM6l0gw2iuRaNwsugqYx7YgeyksCEBvoymdY79Xl9" +
       "0RrUmXSj8OlMGGxpD2fKkmkNXGS9GDEkxHuQmKwac9PnPWKiS3yAyCJmwd0m" +
       "3RXdpNxRKmO/LW3Fuj3pjDqBHG1UtZISgdhLdTYDoT8/RytYhdxssjnbZzfo" +
       "kghqer0ON52sh1SVdR0tAxe77gxwaBpPWmba5+b1qNK3zTlCw/OwuuVgioTl" +
       "kaJXfYyOsorYWAyThrdCBDudt/CWoJuWHAYJu1x7CDWwqrXmYsL1oEWbwQem" +
       "mqLLfqvW9Vr9bVZtcS2c4mprqcqvl8vtoAz1UBPaYogH0xSZrmAQ1TBoahlN" +
       "BB1EiLOKvDE+CsabeOg6QRRyIx9SXasyUyF/XIXnCZ4Jdgsedep4Qw0iza7D" +
       "Ywaqjje4XOHZrNzVV7XhIGIypIcsLF4YIlMmbmKr6rASsqqe4mUkmE24qAx1" +
       "MHzeaukZsFxOGpuutlgKzgJt8gzTWXVbkTuNV1o6aXfZBj61U3bu+x5qBdhg" +
       "Ca3doTr0xuWV0GKyan/gU1Gw6NYcFEOWATacYrVw4FTZbegOuhBat1OZpqV2" +
       "B4+dAUErmt7pBFFbI9p1G55aXIqZ0tow2KhtksiWnLd9uc7Q0IKVGXOFbvgp" +
       "0/G7zdFkGkdjESJrTCr1yovAH/E0ApVtud7SwZhbtwS00cdtXbKhfqvX7EA9" +
       "xFgaMUSlWpWB4kmzqTdGY9GlwaStMZ1osh1vVlgNWtbq/bVZnsZjNuTb9Tk0" +
       "U+t1aCnChhs3er0NFU91l5kCW0o7U5S3xCZdaXbDtb+E9HgACXpHqY/GSEPW" +
       "2E2XGOfDnsViH+0j5qIPQsdmc8wDt7ttbsJBubLOuhrOSW1chnHc5gCzkme2" +
       "l8a4m7pGuxvpbQxxelAWtGfpcLkwA6+ML7XhBDYiwwLBbpvcxGnNay6puTFb" +
       "DRazMowOnFSLKqQ9ZhJqwLbDmjRlfYQUK9xKtRQZxESEKlFER0fdjYd7bGRu" +
       "aE5dhrQTGS2INzYpJW+tHtunN1VCqFaFUebUO0xK0i3BNmmlPg0NmByB6J2v" +
       "bUXck5g1Vtn0u8hw7k0JRV8P4J4fO7CPjWYjl6S5WBSJIHWpjpiNlgwx6Wop" +
       "DetYTe2A+dkle3qDo82xVyEMk0oSTSVSKw4H+sKHutB23C1DTKOTbtjUL68T" +
       "x6bGcgNXkwYDpk4u0ZSqzS2YOdLA1jpekfkhNaky6ma5Xmd1qNaUGN2jZ9Yc" +
       "7wvY1EYmmjqsD7UKNdvOh5kR8JInDAW0NScaPCqKqO5MpxNZRKt0bTiT9NUg" +
       "mouNkCUnG22IR7GmTyb4SOSR9ayVbix9G7Ynipf11g2jHiAIj/HBhKHS/jKg" +
       "owHCNBYGOVrDibbp034YyYY4M6wBcI5GEMirni57A1VLOhu608fNaJnNocEM" +
       "L5MtTZisXM2wMHGGEGGVwmO5hmyWcHWNqIsqK3dN2euPWnq4HGNctKpJ49Y4" +
       "aBLN+dwd1fvLTjdE4AwLI6FraktY22AxPi6PhWHKeQRXgfgB4sluBi0oLYPE" +
       "EdGYgAqUCYkTRlNVKZvNRmWx38IEftmytuhqayFqo0717M008huVledDS3i9" +
       "IsUFOcnYZEnglrj1IMxcLjLFqiDbRmUxNzcNOmuLJC5nrAmPlkSiAxuSoxkZ" +
       "dTYrWtyMekPSCtrmUC439Wl9uqp24sY08eKE0Wqs3tBGPQhCy1W4V+5k5Uo/" +
       "wph8bRib6sTqVvVoRFaNGk43A7VWQzM+Ixde2kq5aEC61izceFaCRWKrtpTH" +
       "FCEw81DZuAy5xrTMblfLi5Zfn/ANSmiN46Y/Ril3qyg0FyVNAB5zZ9UVhPNT" +
       "0WaHLuIoIp6ptGeJg+VEmMwoMqxlWhcv262MS7p4l5DnQBJ0RUJomwtSLKXH" +
       "2oJbewEz8+RKogrLNUzDtLyJ6oOuwDjs1Er5VXW0Lm/Y0YJwa1xzY7MmWp5T" +
       "5GKsI5If6DVoZtXLELZyNiCiMTBokYkM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "zfH/AEElEu5yPgAA");
}
