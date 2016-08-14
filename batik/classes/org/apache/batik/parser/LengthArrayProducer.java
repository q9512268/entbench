package org.apache.batik.parser;
public class LengthArrayProducer extends org.apache.batik.parser.DefaultLengthListHandler {
    protected java.util.LinkedList vs;
    protected float[] v;
    protected java.util.LinkedList us;
    protected short[] u;
    protected int index;
    protected int count;
    protected short currentUnit;
    public short[] getLengthTypeArray() { return u; }
    public float[] getLengthValueArray() { return v; }
    public void startLengthList() throws org.apache.batik.parser.ParseException {
        us =
          new java.util.LinkedList(
            );
        u =
          (new short[11]);
        vs =
          new java.util.LinkedList(
            );
        v =
          (new float[11]);
        count =
          0;
        index =
          0;
    }
    public void numberValue(float v) throws org.apache.batik.parser.ParseException {
        
    }
    public void lengthValue(float val) throws org.apache.batik.parser.ParseException {
        if (index ==
              v.
                length) {
            vs.
              add(
                v);
            v =
              (new float[v.
                           length *
                           2 +
                           1]);
            us.
              add(
                u);
            u =
              (new short[u.
                           length *
                           2 +
                           1]);
            index =
              0;
        }
        v[index] =
          val;
    }
    public void startLength() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_NUMBER;
    }
    public void endLength() throws org.apache.batik.parser.ParseException {
        u[index++] =
          currentUnit;
        count++;
    }
    public void em() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_EMS;
    }
    public void ex() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_EXS;
    }
    public void in() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_IN;
    }
    public void cm() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_CM;
    }
    public void mm() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_MM;
    }
    public void pc() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PC;
    }
    public void pt() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PT;
    }
    public void px() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PX;
    }
    public void percentage() throws org.apache.batik.parser.ParseException {
        currentUnit =
          org.w3c.dom.svg.SVGLength.
            SVG_LENGTHTYPE_PERCENTAGE;
    }
    public void endLengthList() throws org.apache.batik.parser.ParseException {
        float[] allValues =
          new float[count];
        int pos =
          0;
        java.util.Iterator it =
          vs.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            float[] a =
              (float[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                a,
                0,
                allValues,
                pos,
                a.
                  length);
            pos +=
              a.
                length;
        }
        java.lang.System.
          arraycopy(
            v,
            0,
            allValues,
            pos,
            index);
        vs.
          clear(
            );
        v =
          allValues;
        short[] allUnits =
          new short[count];
        pos =
          0;
        it =
          us.
            iterator(
              );
        while (it.
                 hasNext(
                   )) {
            short[] a =
              (short[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                a,
                0,
                allUnits,
                pos,
                a.
                  length);
            pos +=
              a.
                length;
        }
        java.lang.System.
          arraycopy(
            u,
            0,
            allUnits,
            pos,
            index);
        us.
          clear(
            );
        u =
          allUnits;
    }
    public LengthArrayProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Fu/e/S/UTRrzFTQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "TNUbLjh1uUJlDvbs8QxrLLTpMJM3+rgC");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("ZZLR0BC2gwWUOcn0jjAua2pjM5uaHRhvUM3FVpWDWm/c16sVgm9LBNlJWW2w" +
       "VqioE+Db1CRBd6zhJY1F63DqixNOC0TW5mzdTocMNuszjErqOrPCmpJd9xiK" +
       "gwLA1FB7olTlcQi3bIqCzSnvOJBrtxVCa46ykV1fauMKOW929Yap2e02bbST" +
       "ORG15WDR5MdCPSk3vJZeaY/BfNHq23ZbiAi+u1KJvjmbdIhECZth0kssubbF" +
       "6g1bqnHbikwIfZ6Yoz1uA5GUwPNkOFiLnKFmTIOozBEwFYda1uisql66lTtl" +
       "1Icm2mowgxkiWTByZx23za2jz+umvJ2h2apbU7Ky5KTCKhg2V0zE9oImxY4m" +
       "K6SPa3g8N+Yt07JJbTThOmNo0OmlgYIGGVMfDtpzEowViCFBEFbNwlYUuVMO" +
       "psAiF6y2hJ5uWlRKbhuUM7L7YJnQ6GeplxIrRAiXPVvqt8esH0h0EgQy1YPq" +
       "ywbalhZzZG6Q9XLWjzvDCFKgOcQyM387ZOhut/vmN+fbeV95cduMdxc7qkcH" +
       "WE2rnSd86UXsJO6SHs7F6472n4u/m0pnHww7cXimlL8AfvCsc6nFy99Pvvfp" +
       "Z+Tpp6qHpySeDEu3hq73Q5YSK9aJqu7evdM4UuPevPrXgQs/UAPf3wY/Bnrl" +
       "PfA37Ax1lbcZX79K2h/l4j+FpXs0JdydaMwhFScXirckxxb+z9faqz1Z9ZVQ" +
       "5qdDqAOU1PVH+adXSfufufjjsHTvEcrivNARTO4Y5jdeAszbD/3obQcw33b9" +
       "Yf7FXtrJV2X3haXHzjquWpz/GaSS4uVvA4uq/jIX/yss3RWEon9gl/xgzhV3" +
       "72PXkI+t9L9fqpUeBZdxYCXj+ljp3HGGt+cZzt16dobvFhluz8WNYel2p3gx" +
       "UvhEnvpXR0DPXXipQHOvdw+Aut8noPddC+grc3ERALWOnX8P6N0vFeiD4Hrq" +
       "AOhT193vzz18LYyP5OJVAOMJb97D+OBLxfgD4PqJA4w/cf0x/tC1MEK5eENY" +
       "HPq/IsJrvlC7FsKXg+sDBwg/cP0RwtdCmL/wO9cIS+cVew9a83pA+/ABtA9f" +
       "f2iDa0FDc/HWHFq6B+2apx5fCLSfO4D2c9cfGn0taPNcjAE0w9mDRl4PaJ84" +
       "gPaJ6w/t7deC9mQuFgCatO+Qy+sB7dMH0D59/aEZ14K2zoUMoNn70JTrAe25" +
       "A2jPXX9o0bWgJbnwADRP2oO2uR7QfvUA2q9ef2jvuRa0v5OLH82hhXvQnroe" +
       "0L50AO1L1x/aT18L2s/k4v05tH2G/MmXCi0/+fjlA2hfvv7QPnYtaD+fi6fD" +
       "0m2e4kuKE4rafgD2kZcKMT8J/pUDiF+5/hA/dS2Iv5iLfxzmX+7Kx4uJPZSf" +
       "eDEoU7Biu8Jndvl3Qvdf9i3v7vtT6XPP3HXLK59h/93upP3hN6K3jku3qJFl" +
       "nfys48T9TZ6vqEZhglt3H3kUHnjuc2HplWcsqPLPsIqbXOtzn93l/0JYurif" +
       "PyxdKP6fzPfLwBGO84Gqdjcns3wxLN0AsuS3v7Y7qghWd5WzVnd9RRUj68Qa" +
       "DhMd2VL8dLcwvP+k2+T9ULrnWv1wYufjkVNnuItvrQ/PW0fUwecozz1DTN71" +
       "ndandh/KSZa43ea13DIu3bz7Zq+oND+z/fCZtR3WdRP2+Hfv/PytrzvcS7lz" +
       "p/CxC5/Q7TVX/hJtYHth8e3Y9tde+cs//IvP/GFx2O3/A0UNotcEPwAA");
}
