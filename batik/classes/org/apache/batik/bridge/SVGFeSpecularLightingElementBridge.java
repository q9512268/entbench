package org.apache.batik.bridge;
public class SVGFeSpecularLightingElementBridge extends org.apache.batik.bridge.AbstractSVGLightingElementBridge {
    public SVGFeSpecularLightingElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_SPECULAR_LIGHTING_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float surfaceScale =
          convertNumber(
            filterElement,
            SVG_SURFACE_SCALE_ATTRIBUTE,
            1,
            ctx);
        float specularConstant =
          convertNumber(
            filterElement,
            SVG_SPECULAR_CONSTANT_ATTRIBUTE,
            1,
            ctx);
        float specularExponent =
          convertSpecularExponent(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.Light light =
          extractLight(
            filterElement,
            ctx);
        double[] kernelUnitLength =
          convertKernelUnitLength(
            filterElement,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion =
          in.
          getBounds2D(
            );
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter filter =
          new org.apache.batik.ext.awt.image.renderable.SpecularLightingRable8Bit(
          in,
          primitiveRegion,
          light,
          specularConstant,
          specularExponent,
          surfaceScale,
          kernelUnitLength);
        handleColorInterpolationFilters(
          filter,
          filterElement);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static float convertSpecularExponent(org.w3c.dom.Element filterElement,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            SVG_SPECULAR_EXPONENT_ATTRIBUTE);
        if (s.
              length(
                ) ==
              0) {
            return 1;
        }
        else {
            try {
                float v =
                  org.apache.batik.bridge.SVGUtilities.
                  convertSVGNumber(
                    s);
                if (v <
                      1 ||
                      v >
                      128) {
                    throw new org.apache.batik.bridge.BridgeException(
                      ctx,
                      filterElement,
                      ERR_ATTRIBUTE_VALUE_MALFORMED,
                      new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                      s });
                }
                return v;
            }
            catch (java.lang.NumberFormatException nfEx) {
                throw new org.apache.batik.bridge.BridgeException(
                  ctx,
                  filterElement,
                  nfEx,
                  ERR_ATTRIBUTE_VALUE_MALFORMED,
                  new java.lang.Object[] { SVG_SPECULAR_CONSTANT_ATTRIBUTE,
                  s,
                  nfEx });
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YfWwUxxUfn/H3twHzbbAxIL7ugIQWYpLGGNuYnM0VE0s1" +
       "H8d4b+5u8d7usjtnn00JJGoFTVWEqJPQqPAXBNKSGFWN2jRN5IoqH0paiRQ1" +
       "TaMQpEQqaYsSFDX9g7bpm5nd2729OyPappZ2bj375s28N7/3e2/m4k1UZBqo" +
       "kajUT0d1Yvo7VBrChkki7Qo2zZ3QF5aeKsSf7b3Ru9GHigdQdRybPRI2SadM" +
       "lIg5gBbIqkmxKhGzl5AIGxEyiEmMYUxlTR1AM2WzO6ErsiTTHi1CmEA/NoKo" +
       "DlNqyINJSrotBRQtCMJKAnwlgTbv59YgqpQ0fdQRn+0Sb3d9YZIJZy6Totrg" +
       "fjyMA0kqK4GgbNLWlIFW6poyGlM06icp6t+vrLdcsC24PssFzZdqPr99Il7L" +
       "XTAdq6pGuXnmDmJqyjCJBFGN09uhkIR5AD2CCoOowiVMUUvQnjQAkwZgUtta" +
       "RwpWX0XUZKJd4+ZQW1OxLrEFUdSUqUTHBk5YakJ8zaChlFq288Fg7aK0tcLK" +
       "LBOfWBkYf2pv7U8KUc0AqpHVPrYcCRZBYZIBcChJDBLDbItESGQA1amw2X3E" +
       "kLEij1k7XW/KMRXTJGy/7RbWmdSJwed0fAX7CLYZSYlqRtq8KAeU9V9RVMEx" +
       "sLXBsVVY2Mn6wcByGRZmRDHgzhoybUhWIxQt9I5I29jyEAjA0JIEoXEtPdU0" +
       "FUMHqhcQUbAaC/QB9NQYiBZpAECDorl5lTJf61gawjESZoj0yIXEJ5Aq445g" +
       "Qyia6RXjmmCX5np2ybU/N3s3HT+oblV9qADWHCGSwtZfAYMaPYN2kCgxCMSB" +
       "GFi5Ivgkbnj5mA8hEJ7pERYyP/vmrQdXNU6+LmTm5ZDZPrifSDQsnR2svjK/" +
       "ffnGQraMUl0zZbb5GZbzKAtZX1pTOjBMQ1oj++i3P07uePUbR35E/uJD5d2o" +
       "WNKUZAJwVCdpCV1WiNFFVGJgSiLdqIyokXb+vRuVwHtQVono3R6NmoR2o2kK" +
       "7yrW+P/goiioYC4qh3dZjWr2u45pnL+ndIRQCTyoEp4WJP74L0WJQFxLkACW" +
       "sCqrWiBkaMx+MwCMMwi+jQcGAfVDAVNLGgDBgGbEAhhwECfWh0FDjsRIoK+/" +
       "q5P06URKKkB6cixOAViMH0DPZi7iZ7DT/98TppgHpo8UFMDmzPdSgwJRtVVT" +
       "IsQIS+PJzR23ng+/KWDHQsXyHUX3wRr8Yg1+vga/WIP/zmtABQV86hlsLQIT" +
       "sKNDwA1AzpXL+/Zs23esuRDAqI9Mg+1gos0ZSardIRCb9cPSRH3VWNO1tZd9" +
       "aFoQ1WOJJrHCck6bEQM2k4asgK8chPTlZJFFrizC0p+hSSQCJJYvm1haSrVh" +
       "YrB+ima4NNg5jkVzIH+Gybl+NHlq5NH+w2t8yJeZONiURcB5bHiI0X2a1lu8" +
       "hJFLb83RG59PPHlIc6gjIxPZCTRrJLOh2QsOr3vC0opF+IXwy4dauNvLgNop" +
       "hlAE1mz0zpHBTK02yzNbSsHgqGYksMI+2T4up3FDG3F6OGrr+PsMgEUFC9XV" +
       "8Ky0Ypf/sq8NOmtnCZQznHms4Fnk/j799B9++/E93N12wqlxVQp9hLa6SI4p" +
       "q+d0VufAdqdBCMi9fyr0/SduHt3FMQsSi3NN2MLadiA32EJw87dfP/DuB9fO" +
       "XvU5OKeQ5ZODUCyl0kayflQ+hZEw21JnPUCSCvAGQ03LwyrgU47KeFAhLLD+" +
       "UbNk7Qt/PV4rcKBAjw2jVXdW4PTP2YyOvLn3741cTYHEkrTjM0dMMP90R3Ob" +
       "YeBRto7Uo28v+MFr+DTkEOBtUx4jnIoR9wHim7ae27+Gt/d6vn2VNUtMN/gz" +
       "48tVTIWlE1c/rer/9JVbfLWZ1Zh7r3uw3irgxZqlKVA/y0tOW7EZB7l7J3t3" +
       "1yqTt0HjAGiUgI7N7QawZSoDGZZ0Uckff3W5Yd+VQuTrROWKhiOdmAcZKgN0" +
       "EzMORJvSv/ag2NyRUmhquakoy/isDubghbm3riOhU+7ssZ/P+umm82eucZTp" +
       "Qsc8t8JlrFmZxhv/K/YmRDfeMjQYaEG+moXXW2cfGz8T2X5urags6jPrgA4o" +
       "c5/7/T/f8p+6/kaOBFNGNX21QoaJ4pqzkE2ZkQt6eDnn8NH71Sc/fLEltvlu" +
       "0gDra7wD0bP/F4IRK/LTuncprz3257k7H4jvuwtGX+hxp1flsz0X3+haKp30" +
       "8dpVkHlWzZs5qNXtWJjUIFCkq8xM1lPFYb84DYB6trGN8KyxALAmN6vmwE6a" +
       "q/INnSKqd07xrZ812ymqjEFlp0lY6QVruORsONvxAGB1u1/U7fzDBtaEBMJb" +
       "/8PoYh1tOu9/KNs9nZaNnXfvnnxDPS4o4QspsQ1dkq/eEjWVdVSzpacz6ZF7" +
       "JH9ES/it4ot9itoCTVnqYsPU32VgPS5LZi8A3pZckyXJgI9HqF9OwOHGDykd" +
       "2I8lCX+nrMCByR44h28NE4wRWMUOICfYJoWs25IZxCw6+5KDJt2BRzh9hKXd" +
       "y2obWjZ+1ix4ozGHrOtsdPylXwwMLKuVhHBzLsWZZ6IL50ul9xKvfiQGzMkx" +
       "QMjNvBD4Xv87+9/i8VvKCCMdNS6yAGJx1Se16f2uZttbB891a7/5L0W7/8tS" +
       "H4bBgV9OANYDO+UEiVjbax8lvlT9PDNm8K+zaT8eUto+2fDM/cKtTXl40pF/" +
       "8evXr5wem7gouJ+5l6KV+a5Isu9lWH26ZIoa2wHI37rum/z4w/49PotQqllj" +
       "pmycVjk5FDI26zyYDsKC9AlkRiZMhOYt36n55Yn6wk5INt2oNKnKB5KkO5JJ" +
       "uCVmctCFG+cmwKFfCzRfwF8BPP9iDwML6xCgqW+3TsWL0sdiSOfsO0UFK+CV" +
       "65GmYNFvsWYvsKhkEBguQpX17XcYM/wlMOY89m0dPCesMDgxBWPydgVrVnOl" +
       "PigDdEOjAGASgfLY5NdSnvJ4xhTKPQ7xCa2cCVkT4ZOfnMJt46x5nKJZcLKB" +
       "SoDaB9uOlK6pAAkzN+OEDAggKg9bOFkX2icdawl9ZCPwAGuOsGBaPsU9ZKaO" +
       "wKH6D4Z+eOM5ixOzTmYZwuTY+ONf+I+Pi9gSd2OLs66n3GPE/ZiAY3p1TVPN" +
       "wkd0/mni0EsXDh21Leui7DClYeoNIfbv4ZSDte/+L7CWoqj5zvcNrFCenXUD" +
       "Km7tpOfP1JTOOvPwO7xeTN+sVQLhR5OK4opjd0wX6waJytzgSnFu0PnPMwCU" +
       "PHka0CteuC3nhPyzUMB45cGB/Nctd5GickcOVIkXt8gERYUgwl4v6Ta1bchX" +
       "NLQBRg0ojsF5OV2WKsg+KvBtm3mnbXOdDRZnYJvfVNtxkgxZSWDizLbeg7e+" +
       "ck4cwyUFj40xLRXAm+JGIF0aN+XVZusq3rr8dvWlsiU2FuvEgh1+mecK7DbA" +
       "pM6QMddzRjVb0kfVd89ueuU3x4rfhijahQowlFW7XPfE4lIUDrpJKGd2BbPz" +
       "Axwj+OG5dfnTow+sin7yHj+FWflkfn75sHT1/J7fnZx9Fg7ZFd2oCMKMpAZQ" +
       "uWxuGVWhjBo2BlCVbHakYImgRcZKRvKpZiDGrBbmfrHcWZXuZZc4EDfZbJB9" +
       "9QUn1hFibNaSasRKXxVOT8YVuhUY5Uld9wxwelxl0iOCYkRyKwwHe3TdTnZF" +
       "T+s8ug/nZhDWXuavrPn1vwFNDLmAxRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "a9hurLcRe7v7/QfbexCsToHVeh22W91Fs/Fvybk8kJcXsuKXtm7Kqr8MlnWU" +
       "56ZghGF5spNP/NYYhJijXtjnLoJcFfjkwtyp5mxeCbLzPJwy7Xe3Cd4W0LIS" +
       "y1lsQ6J8xfB5w5Yq37luOWRG+yBX/OC/PPmNDz/0HeDTHnTdMrM3cOWRGZkk" +
       "S5/f99xH77nxqe9+MEcpAFHib/xe8acZV/pqGmdFKyvIfVXvzlQd5KkALUdx" +
       "PwcWXcu1vWooc6HlAvxd7uWGyOO3fcf+xPc+t837TsbtCWL9A0/95s93P/TU" +
       "zpFs+6FLEt6jY7YZdy70zXsWDqEHrjZLPoL81+cf/5NPP/7+rVS3Hc8dW+DV" +
       "6HN/89/f2H36u1+7TFJyreP/Ao6Nbwk6paiL73/owtQYp6PVamR4SKcYp52N" +
       "ouCrLl1NzC4/ngZ0u80kU6+Pii00KnRqWkmBy0lNqybRPPY8FO312j45FMet" +
       "RY/jFxw+aTDUoE2OGWwuMOWuv+iggWwJfGEo9/mgxS/kaTQgm5O6WVUCt+xp" +
       "WBWrs2tODgIJU+bFajnCakwVKeoY4pbswkhqLHxbno+GqFaYLv2q2AiJmW1b" +
       "Vd7HNlKRJ8uyTkUDo6oUhaTe7limxmvCWuGELjaQtb7TNctmQ+kubHdFzdob" +
       "p4x326vW2mq5/elo5QyFAt7Hxhu20gIrajjsWAXCbeEI41N+02EW6y7TG4R+" +
       "3BD4mOj3KNxLHXOoLMv1qbkIeNTQeMGD0YFS1OpTqduT1pWhH4emMV/3cdRe" +
       "UKW2qTD02OmS40rgr9tOH61YalCJ4WVIa2pEYCUuisiNpC24sF7vOlV6MsS1" +
       "RSVoJxPPbbq9xXpO9Bpkm0HryczuCmW8iRGEz/qpJfZHoyXvzXncTiVzFMey" +
       "kAbjCToZSVRPK8ESPy6wKzpskSNtMFqMhp2GXZ7Kdq+2kYmZQy6wWo00qzKF" +
       "xipN0Q3WGDfsqYEFy+qoRo1UFF8EHZELpyohSA2gX0MlZr1mg24q3bg1aPN4" +
       "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" +
       "6mclAAA=");
}
