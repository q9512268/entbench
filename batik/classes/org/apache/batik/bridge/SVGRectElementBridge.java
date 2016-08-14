package org.apache.batik.bridge;
public class SVGRectElementBridge extends org.apache.batik.bridge.SVGShapeElementBridge {
    public SVGRectElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_RECT_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGRectElementBridge(
                                                            ); }
    protected void buildShape(org.apache.batik.bridge.BridgeContext ctx,
                              org.w3c.dom.Element e,
                              org.apache.batik.gvt.ShapeNode shapeNode) {
        try {
            org.apache.batik.dom.svg.SVGOMRectElement re =
              (org.apache.batik.dom.svg.SVGOMRectElement)
                e;
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _x =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getX(
                  );
            float x =
              _x.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _y =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getY(
                  );
            float y =
              _y.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _width =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getWidth(
                  );
            float w =
              _width.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _height =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getHeight(
                  );
            float h =
              _height.
              getCheckedValue(
                );
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _rx =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRx(
                  );
            float rx =
              _rx.
              getCheckedValue(
                );
            if (rx >
                  w /
                  2) {
                rx =
                  w /
                    2;
            }
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength _ry =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                re.
                getRy(
                  );
            float ry =
              _ry.
              getCheckedValue(
                );
            if (ry >
                  h /
                  2) {
                ry =
                  h /
                    2;
            }
            java.awt.Shape shape;
            if (rx ==
                  0 ||
                  ry ==
                  0) {
                shape =
                  new java.awt.geom.Rectangle2D.Float(
                    x,
                    y,
                    w,
                    h);
            }
            else {
                shape =
                  new java.awt.geom.RoundRectangle2D.Float(
                    x,
                    y,
                    w,
                    h,
                    rx *
                      2,
                    ry *
                      2);
            }
            shapeNode.
              setShape(
                shape);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_WIDTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_HEIGHT_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_RY_ATTRIBUTE)) {
                buildShape(
                  ctx,
                  e,
                  (org.apache.batik.gvt.ShapeNode)
                    node);
                handleGeometryChanged(
                  );
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    protected org.apache.batik.gvt.ShapePainter createShapePainter(org.apache.batik.bridge.BridgeContext ctx,
                                                                   org.w3c.dom.Element e,
                                                                   org.apache.batik.gvt.ShapeNode shapeNode) {
        java.awt.Shape shape =
          shapeNode.
          getShape(
            );
        java.awt.geom.Rectangle2D r2d =
          shape.
          getBounds2D(
            );
        if (r2d.
              getWidth(
                ) ==
              0 ||
              r2d.
              getHeight(
                ) ==
              0)
            return null;
        return super.
          createShapePainter(
            ctx,
            e,
            shapeNode);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVYe2wUxxmfu/P7bfMsYPMytLzuQghtkWkaY2wwORsLE0s1" +
       "Dcfc7tzd4r3dZXfWPjuhBaQI+hBCxElI2lBVIkqbB6RVUFu1iagildCklZKi" +
       "tmkVUql/lD5Qgyqlf9A2/WZm93Zv74Goykk7uzfzzTfz/b7nzEs3ULVloi6i" +
       "0SidNogV7dfoCDYtIvep2LL2Ql9CeiqC/7H/+vCWMKoZRy0ZbA1J2CIDClFl" +
       "axx1KppFsSYRa5gQmc0YMYlFzElMFV0bR/MUazBrqIqk0CFdJoxgDJtx1I4p" +
       "NZWkTcmgw4CizjjsJMZ3EusNDvfEUZOkG9Me+UIfeZ9vhFFmvbUsitriB/Ek" +
       "jtlUUWNxxaI9OROtM3R1Oq3qNEpyNHpQ3exAsCu+uQiCFa+0fnTrVKaNQzAH" +
       "a5pOuXjWHmLp6iSR46jV6+1XSdY6hL6EInHU6COmqDvuLhqDRWOwqCutRwW7" +
       "byaane3TuTjU5VRjSGxDFC0vZGJgE2cdNiN8z8Chjjqy88kg7bK8tELKIhGf" +
       "WBebfWp/2/cjqHUctSraKNuOBJugsMg4AEqySWJavbJM5HHUroGyR4mpYFWZ" +
       "cTTdYSlpDVMb1O/Cwjptg5h8TQ8r0CPIZtoS1c28eCluUM6/6pSK0yDrfE9W" +
       "IeEA6wcBGxTYmJnCYHfOlKoJRZMpWhqckZex+0EggKm1WUIzen6pKg1DB+oQ" +
       "JqJiLR0bBdPT0kBarYMBmhQtKsuUYW1gaQKnSYJZZIBuRAwBVT0Hgk2haF6Q" +
       "jHMCLS0KaMmnnxvDW08+ou3UwigEe5aJpLL9N8KkrsCkPSRFTAJ+ICY2rY0/" +
       "iee/diKMEBDPCxALmh88evOB9V2X3hQ0i0vQ7E4eJBJNSOeSLe8s6VuzJcK2" +
       "UWfolsKUXyA597IRZ6QnZ0CEmZ/nyAaj7uClPT/7wpEXyF/DqGEQ1Ui6amfB" +
       "jtolPWsoKjF3EI2YmBJ5ENUTTe7j44OoFr7jikZE7+5UyiJ0EFWpvKtG5/8B" +
       "ohSwYBA1wLeipXT328A0w79zBkKoFh7UBM+nkPjxN0WJWEbPkhiWsKZoemzE" +
       "1Jn8VgwiThKwzcSSYPUTMUu3TTDBmG6mYxjsIEOcgaSpyGkSGx3bsQfmsYgA" +
       "M7fxzigzNOPuL5FjUs6ZCoVAAUuC7q+C5+zUVZmYCWnW3tZ/83ziLWFazB0c" +
       "fChaD6tGxapRvmpUrBottSoKhfhic9nqQtOgpwnweAi5TWtGH9514MSKCJiY" +
       "MVUFIDPSFQWpp88LC24sT0gXOppnll/b+EYYVcVRB5aojVWWSXrNNMQoacJx" +
       "46YkJCUvNyzz5QaW1ExdIjKEpnI5wuFSp08Sk/VTNNfHwc1czEdj5fNGyf2j" +
       "S2emjo59+Z4wChemA7ZkNUQyNn2EBfF8sO4OhoFSfFuPX//owpOHdS8gFOQX" +
       "Ny0WzWQyrAiaQxCehLR2Gb6YeO1wN4e9HgI2xeBgEAu7gmsUxJseN3YzWepA" +
       "4JRuZrHKhlyMG2jG1Ke8Hm6n7fx7LphFI3PApfBscDySv9nofIO1C4RdMzsL" +
       "SMFzw+dGjWd/+8s/b+Jwu2mk1Zf/Rwnt8YUuxqyDB6l2z2z3moQA3ftnRh5/" +
       "4sbxfdxmgWJlqQW7WdsHIQtUCDA/9uah9z64du5q2LNzCrnbTkIJlMsLyfpR" +
       "QwUhYbXV3n4g9Kngbcxquh/SwD6VlIKTKmGO9a/WVRsv/u1km7ADFXpcM1p/" +
       "ewZe/ye2oSNv7f9nF2cTkljq9TDzyEQ8n+Nx7jVNPM32kTv6bufTl/GzkBkg" +
       "GlvKDOEBFnEMEFfaZi7/Pby9LzD2GdassvzGX+hfvhIpIZ26+mHz2Iev3+S7" +
       "Layx/LoewkaPMC/WrM4B+wXB4LQTWxmgu+/S8Bfb1Eu3gOM4cJQg5Fq7TYiP" +
       "uQLLcKira3/30zfmH3gngsIDqEHVsTyAuZOherBuYmUgtOaMzz8glDtVB00b" +
       "FxUVCV/UwQBeWlp1/VmDcrBnfrjg1a3Pn73GrcwQPBb7GX6SNevy9sZ/NcE0" +
       "57e3Ag4m6ixXifAq6tyx2bPy7uc2inqhozC790Px+vKv//129MwfrpRIKfVU" +
       "NzaoZJKovjXZMaSzIBcM8SLNi0fvt5z+44+609vuJA2wvq7bBHr2fykIsbZ8" +
       "WA9u5fKxvyzae3/mwB1E9KUBOIMsvzv00pUdq6XTYV6RimBeVMkWTurxAwuL" +
       "mgRKb42JyXqaudmvzBtAB1NsFzz3OgZwb+moWsJ28rGq3NQKXr23wtgYa3ZT" +
       "1JSGek2XsDoM0nDKhXBi4w7AqvGoqMb5wGdZMyIsvOd/9C7W0Wvw/gcL4emE" +
       "Z4sj45Y7h6fc1AoQSBXGuBr3U9QI8Lg6d9HpKleWiULMwypxF7BqcW1gwBF4" +
       "ewWseLuWNRvcZFhvmDqFiEbkQD5sdnmV4BkAKsKZRVw8VlXGwznFutRzGPXU" +
       "Jikq69moU8GWRzY9SaOjGWyQYYgWXDRaQWuPsiZLUUPSVlSZz4PQtqbCXYOp" +
       "ZKEQmXROa7HDHR9MfPP6yyKyBo92AWJyYvarH0dPzoooK86/K4uOoP454gzM" +
       "d9omwP8YfiF4/sMeJgbrYG84Evc5B7Fl+ZMYyzUmWl5pW3yJgT9dOPzj7xw+" +
       "HnZg2UFR1aSuyJ5lanfBMnnpyCqpo44VHblzLz5SZmpA5yHnCOOYzaYis2G2" +
       "ZU2moWxRsgy5OMCTv9Maw6otbOlUBVuaZc3XwCYzWJNV4nLKc+mD/jSRGdVR" +
       "D9iv3wVgF7vAnnbQOX0bYI1izy43tbRns782a6ZYM835f6sCVt9mzTNgs5JJ" +
       "ACTueCOYXxK5Olpe3rX9lBzEb/w/QMzBIbLUOZkVeAuL7uPEHZJ0/mxr3YKz" +
       "D/2G1zn5e54mqFhStqr6Er4/+dcYJkkpHIgmUe8a/PUiRQvKhEY4lCS9ZPGC" +
       "oD8PiTdIT1E1f/vpvgcBzqMDVuLDT/IqRREgYZ8XDVcFGypcJ3BFFOCUCxXX" +
       "tVw7826nHV8hu7Ig9PLLUrcGs8V1aUK6cHbX8CM3P/2cODNKKp6ZYVwa46hW" +
       "HF/zddzystxcXjU719xqeaV+lRv52sWGPf9Y7LPaXgghBjOHRYEDldWdP1e9" +
       "d27r6784UfMuBPl9KIQhfe3zXVWKezk4ldlQQO+LeyW077Kdn/R61jwzff/6" +
       "1N9/z48MSFy/LClPn5CuPv/wr04vPAcnwsZBVA1BneTGUYNibZ/WwKQnzXHU" +
       "rFj9OdgicFGwOojqbE05ZJNBOY5amOViVrhxXBw4m/O97MaBohXFyar4ngaO" +
       "V1PE3KbbGg91zVBzez0Ft7iONzTYhhGY4PXkVTm3WPaEtP0rrT851REZAO8r" +
       "EMfPvtayk/ky23+xyztEbmXNsZxIo5FEfMgw3LRa/aIh3OGyoGH9FIXWOr2+" +
       "3ML+/pyzu8I/WfP2fwHJVyMFsxkAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+4u240QnoLeeLu7UdvJp/9dnXB7Iyotp8fNbNaWvr4Ru7WUZJ+yh6pZkZAO/" +
       "wYcmZsgX97hzMAOFOrm4NGoZm5fCnDszp1T6nW3atg1oaVnMWGxNonJV8/mF" +
       "LVW2ct16wIyyYQb47n9+79fe89C3oE57yOlNijdU5aERB0GaFP/qcx+456an" +
       "v/3uLErBEMW96zOlH6ZcqWtJnBZEWpB7ot6dijrJlntK8nw6CyxAyaS9pikP" +
       "Xd2E8Xezm/Ghj1/41upD3/nENps7brfHiMGTT//aj3eeevrkoRz6ocvS2MN9" +
       "tnl0NulbdhF2kQeuNUrWg/yXTz3+ud99/J3bWV04mhEScMPzib/5n6/tPPPt" +
       "r1whDbnOsH8Kxfq3vLVT9rrNvQ/FCaAYslFkqgE6rM1V2hOGdOxTSTDSFv6K" +
       "X0lCMQyZsUcRea/QklW55idK2S0p4kzlh8tggUmjbm6B4RFhdIsGxnVX6zlW" +
       "HXMsGRR0SdMNBV8ZYl/3zRXHrg3UaFVGWrw21EaziPKi2SiJm1q5bcerVS1I" +
       "1CSZqgk6r1kJ4ZVYijNsvarnJ7oysDWupqg23hL87gY4RYoqjowGDvQ1jtY6" +
       "aG6D83TfFsdxXpw3C70i3m3hBlxEo6jQdxzSmwhjqaKNTDkv0IJBJoRBk1x+" +
       "PkZpVkowd91dr/I4qfTsSGv1/KjQLTsDkV9NZVMLy7ieLJdejxZLROANWhuV" +
       "YEVm1W7QIMd2VSA2NguSNDdzFq7+ro6hxGrpGyzLD6JI6jaYMePTpXGBWZfW" +
       "A8KJBx1nVAJR08ODXDDScVLK5VVr6nJ9aTBKmh2p4jDBbMl3TMqp6pNxubrk" +
       "qrnCbKII1QVVJbpWh63ijLlubQJqsW6NeSZc44E/DvnaPJYkC5SmwXTJVrjx" +
       "ctKOWiSe34jtnkYUZWWgD+pJHV8sl+u4Xl9ptXm/7hNUv7toqzwG5irvoEVU" +
       "Xq47rOxPXKk/CBisF2gerZWbxDqe8D1pM+/RlU6Hde12PC6bjkDyojydKsLE" +
       "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" +
       "JQAA");
}
