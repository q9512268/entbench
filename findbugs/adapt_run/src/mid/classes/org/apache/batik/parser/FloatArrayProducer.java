package org.apache.batik.parser;
public class FloatArrayProducer extends org.apache.batik.parser.DefaultNumberListHandler implements org.apache.batik.parser.PointsHandler {
    protected java.util.LinkedList as;
    protected float[] a;
    protected int index;
    protected int count;
    public float[] getFloatArray() { return a; }
    public void startNumberList() throws org.apache.batik.parser.ParseException {
        as =
          new java.util.LinkedList(
            );
        a =
          (new float[11]);
        count =
          0;
        index =
          0;
    }
    public void numberValue(float v) throws org.apache.batik.parser.ParseException {
        if (index ==
              a.
                length) {
            as.
              add(
                a);
            a =
              (new float[a.
                           length *
                           2 +
                           1]);
            index =
              0;
        }
        a[index++] =
          v;
        count++;
    }
    public void endNumberList() throws org.apache.batik.parser.ParseException {
        float[] all =
          new float[count];
        int pos =
          0;
        java.util.Iterator it =
          as.
          iterator(
            );
        while (it.
                 hasNext(
                   )) {
            float[] b =
              (float[])
                it.
                next(
                  );
            java.lang.System.
              arraycopy(
                b,
                0,
                all,
                pos,
                b.
                  length);
            pos +=
              b.
                length;
        }
        java.lang.System.
          arraycopy(
            a,
            0,
            all,
            pos,
            index);
        as.
          clear(
            );
        a =
          all;
    }
    public void startPoints() throws org.apache.batik.parser.ParseException {
        startNumberList(
          );
    }
    public void point(float x, float y) throws org.apache.batik.parser.ParseException {
        numberValue(
          x);
        numberValue(
          y);
    }
    public void endPoints() throws org.apache.batik.parser.ParseException {
        endNumberList(
          );
    }
    public FloatArrayProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "1hgGRmloGf7R9T/Eix72vCQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16e+zr1n2ffte+12/fa7uxPTd+xddOHbaXFCnxETddKIoS" +
       "JZIS9aTELbEpPiS+3xSpzE1roE2wDlnQOmkGNP5jSPco3KToVnTF0M5D0UfQ" +
       "oluKoHs3WTeg6dIMCbZ2RdMtI6nf+z6cxEYF8OiQ53vO+T4/58vD8/rXahej" +
       "sAb4np2vbS++pmXxNdNuXotzX4uu9bmmIIeRplK2HEXT4tmLyrt+4fKff/Pj" +
       "mysXapek2kOy63qxHBueG421yLNTTeVql0+e0rbmRHHtCmfKqQwmsWGDnBHF" +
       "L3C1e051jWtXuSMWwIIFsGABrFgAyROqotN9mps4VNlDduMoqP1w7YCrXfKV" +
       "kr249vTZQXw5lJ3DYYRKgmKEO8v7eSFU1TkLa08dy76X+TqBPwGAr/70B6/8" +
       "4m21y1LtsuFOSnaUgom4mESq3etozkoLI1JVNVWqPeBqmjrRQkO2jV3Ft1R7" +
       "MDLWrhwnoXaspPJh4mthNeeJ5u5VStnCRIm98Fg83dBs9ejuom7L60LWh09k" +
       "3UvYKZ8XAt5tFIyFuqxoR11utwxXjWtPnu9xLONVtiAout7haPHGO57qdlcu" +
       "HtQe3NvOlt01OIlDw10XpBe9pJglrj1200FLXfuyYslr7cW49uh5OmHfVFDd" +
       "VSmi7BLX3nGerBqpsNJj56x0yj5fG/zgxz7kMu6FimdVU+yS/zuLTk+c6zTW" +
       "dC3UXEXbd7z3Pdwn5Yd/9aMXarWC+B3niPc0v/x3vvH+73/ijd/e03zvDWiG" +
       "K1NT4heVz6zu/8I7qeeJ20o27vS9yCiNf0byyv2Fw5YXMr+IvIePRywbrx01" +
       "vjH+zeWP/Jz21Qu1u3u1S4pnJ07hRw8onuMbthZ2NVcL5VhTe7W7NFelqvZe" +
       "7Y6izhmutn861PVIi3u12+3q0SWvui9UpBdDlCq6o6gbru4d1X053lT1zK/V" +
       "ancUV+2p4nq6tv89WRZxzQI3nqOBsiK7huuBQuiV8pcGdVUZjLWoqKtFq++B" +
       "q8L/rR+oX8PAyEvCwiFBL1yDcuEVG23fWMZopIWF83pyTIahnBfjqYmihddK" +
       "p/P/eqfLSumvbA8OCsO88zws2EVEMZ6tauGLyqtJi/7GZ1/8nQvHYXKot7j2" +
       "nmLOa/s5r1VzXtvPee36OWsHB9VU31POvbd/YT2rwIECIe99fvKB/ksffddt" +
       "heP529sL1Zek4M2BmjpBjl6Fj0rhvrU3PrX90fmHoQu1C2cRt+S3eHR32V0o" +
       "cfIYD6+ej7QbjXv5I1/588998mXvJObOQPghFFzfswzld53XbOgpmlqA48nw" +
       "73lK/qUXf/Xlqxdqtxf4UGBiLBc+XMDNE+fnOBPSLxzBYynLxUJg3Qsd2S6b" +
       "jjDt7ngTetuTJ5XJ76/qDxz5+tOnnL76L1sf8svye/YuUhrtnBQV/L5v4n/6" +
       "3//enyCVuo+Q+vKptW+ixS+cQodysMsVDjxw4gPTUNMKuv/yKeGnPvG1j/yt" +
       "ygEKimduNOHVsqQKVChMWKj5x347+A9f+sPPfPHCidPExfKYrGxDyfZCfqv4" +
       "HRTX/yuvUrjywT6yH6QO4eWpY3zxy5mfO+GtQBq7CL/Sg67OXMdTDd2QV7ZW" +
       "euxfXX62/kt/+rEre5+wiydHLvX9bz7AyfO/0ar9yO988P88UQ1zoJQr3Yn+" +
       "Tsj28PnQychVaJV8ZD/6+4//g9+SP10AcQF+kbHTKjyrVfqoVQaEKl0AVQme" +
       "a4PL4snodCCcjbVTGcmLyse/+PX75l//tW9U3J5NaU7bnZf9F/auVhZPZcXw" +
       "j5yPekaONgVd443B375iv/HNYkSpGFEpcCwahgXsZGe85JD64h3/8V//+sMv" +
       "feG22oVO7e4CYtSOXAVc7a7C07VoUyBW5v/N9++9eXtnUVypRK1dJ/zeQR6t" +
       "7u4oGHz+5ljTKTOSk3B99C+H9uqVP/qL65RQocwNFuJz/SXw9Z95jPqhr1b9" +
       "T8K97P1Edj0UF9nbSV/455w/u/CuS79xoXaHVLuiHKaGc9lOyiCSinQoOsoX" +
       "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" +
       "3L09Ml44+Wb4gRO//Ys3k/Yvy+J/xbWL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vnf49fCUnP/7rcr5vcX1yqGcr7zttjy4/U2kO7hUVr8VV6cwb2TJg9p3ImEW" +
       "1x68/vBgefrp0euOLu+P2yqffe3ynY+8Nvt3+/MDR0di7+Jqd+qJbZ8+rHKq" +
       "fskPNd2opL9rf3TFr6S5L649chNMLg+XVZWS6YN79/RX4tqV8/SFpav/03QP" +
       "xbW7T+iKofaV0yQPx7XbCpKy+oh/tEBAN1sg2pouJ/apZeAoHzg4taQfqr5y" +
       "tAffzAzHXU4fvyu/PldHy4++FCfC4SGbz73WH3zoG+jP7o//Kba825Wj3MnV" +
       "7tifRKwGLb82P33T0Y7GusQ8/837f+GuZ49SlPv3DJ947ynenrzx+Tra8ePq" +
       "RNzuXzzyz3/wH7/2h9WXuv8PtDDmcvMvAAA=");
}
