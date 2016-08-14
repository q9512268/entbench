package org.apache.batik.bridge;
public class UpdateManagerEvent extends java.util.EventObject {
    protected java.awt.image.BufferedImage image;
    protected java.util.List dirtyAreas;
    protected boolean clearPaintingTransform;
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das) { super(source);
                                                    this.image = bi;
                                                    this.dirtyAreas =
                                                      das;
                                                    this.clearPaintingTransform =
                                                      false;
    }
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das,
                              boolean cpt) { super(
                                               source);
                                             this.
                                               image =
                                               bi;
                                             this.
                                               dirtyAreas =
                                               das;
                                             this.
                                               clearPaintingTransform =
                                               cpt;
    }
    public java.awt.image.BufferedImage getImage() {
        return image;
    }
    public java.util.List getDirtyAreas() { return dirtyAreas;
    }
    public boolean getClearPaintingTransform() { return clearPaintingTransform;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "o6mQ2LeVETtXDMf5p5qErhjCOD7HjXsoeEvdAnFAO7J732Flw90XulA9BF7E" +
       "DPMCjY5QLQQOrQFw6OP3Xl6kvdZwx9sPdAyuOpfzNfa1neUEjb/nQZh3lsab" +
       "sChP7P7r7E0rhnacw1F5XshK4SmP9514as158h0RfsknIKDgcjDI1BUM/FqL" +
       "sqylB+uvhfl9nYX7tQCezc6+bg475dlTeynWMlnlR2XGfozNDxmpGaSsNw8R" +
       "nu8e+iIyEO8/kNeFs2OFs83RZdu5m6EUaxlV7y0zdhKbY4zUgxmuDmKQZ4vj" +
       "X4ItpuDYUngURyHl3G1RirWMvg+WGXsYm1OMzAJbdJcGOc8uv/hCqhRIxYXX" +
       "hFhNzyz4I0Jcnsv3HW6smXF488scjfIX3HWAK+mspvnzse+92rRoWuWK1ons" +
       "bPKv3zAyo8T1JSPV4oXL/pigf4KRpjA9pFn+7af7HWQ1jw6mEi9+kmcZqQQS" +
       "fH3OdA+O07wzBLeEqE1yFUHoz+/BtLPtgS9bLAygLP83yEXEbMI5P588vG79" +
       "DWcuvVtcjcmaND6Os0yGE6e4pcuj6oKSs7lzVa9d/FnD/ZMWufmnWQjsOfYc" +
       "n/clocoxcdtnh+6N7I789dErRy5/9Nk91S9AsbiVVEiMTNlaWMXlzCyks63x" +
       "wpM1ZCB+odW1+AdjK5amP3yVn8OIOInPLU0/IL90dPuLd8w80hYhk3uhpNIV" +
       "muPl5dVj+kYqj1hJUq/aPTkQEWZRJS1wbG9AD5XwfyJuF8ec9flevFhlpL3w" +
       "SFN4HQ1n1lFqrTKyusLzDGRAryfwN5WbmLKmGWLwenw3TOuwiedwN8ApB+J9" +
       "puleE0RuNnmoXlP8bIPtn/krNm/9F22fbBYpHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "c+//A+rfZuO5KAAA");
}
