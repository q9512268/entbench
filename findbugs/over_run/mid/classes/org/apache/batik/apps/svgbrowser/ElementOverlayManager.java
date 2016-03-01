package org.apache.batik.apps.svgbrowser;
public class ElementOverlayManager {
    protected java.awt.Color elementOverlayStrokeColor = java.awt.Color.black;
    protected java.awt.Color elementOverlayColor = java.awt.Color.white;
    protected boolean xorMode = true;
    protected org.apache.batik.swing.JSVGCanvas canvas;
    protected org.apache.batik.swing.gvt.Overlay elementOverlay = new org.apache.batik.apps.svgbrowser.ElementOverlayManager.ElementOverlay(
      );
    protected java.util.ArrayList elements;
    protected org.apache.batik.apps.svgbrowser.ElementOverlayController
      controller;
    protected boolean isOverlayEnabled = true;
    public ElementOverlayManager(org.apache.batik.swing.JSVGCanvas canvas) {
        super(
          );
        this.
          canvas =
          canvas;
        elements =
          new java.util.ArrayList(
            );
        canvas.
          getOverlays(
            ).
          add(
            elementOverlay);
    }
    public void addElement(org.w3c.dom.Element elem) { elements.add(
                                                                  elem);
    }
    public void removeElement(org.w3c.dom.Element elem) { if (elements.
                                                                remove(
                                                                  elem)) {
                                                              
                                                          } }
    public void removeElements() { elements.clear();
                                   repaint(); }
    protected java.awt.Rectangle getAllElementsBounds() { java.awt.Rectangle resultBound =
                                                            null;
                                                          int n =
                                                            elements.
                                                            size(
                                                              );
                                                          for (int i =
                                                                 0;
                                                               i <
                                                                 n;
                                                               i++) {
                                                              org.w3c.dom.Element currentElement =
                                                                (org.w3c.dom.Element)
                                                                  elements.
                                                                  get(
                                                                    i);
                                                              java.awt.Rectangle currentBound =
                                                                getElementBounds(
                                                                  currentElement);
                                                              if (resultBound ==
                                                                    null) {
                                                                  resultBound =
                                                                    currentBound;
                                                              }
                                                              else {
                                                                  resultBound.
                                                                    add(
                                                                      currentBound);
                                                              }
                                                          }
                                                          return resultBound;
    }
    protected java.awt.Rectangle getElementBounds(org.w3c.dom.Element elem) {
        return getElementBounds(
                 canvas.
                   getUpdateManager(
                     ).
                   getBridgeContext(
                     ).
                   getGraphicsNode(
                     elem));
    }
    protected java.awt.Rectangle getElementBounds(org.apache.batik.gvt.GraphicsNode node) {
        if (node ==
              null) {
            return null;
        }
        java.awt.geom.AffineTransform at =
          canvas.
          getRenderingTransform(
            );
        java.awt.Shape s =
          at.
          createTransformedShape(
            node.
              getOutline(
                ));
        return outset(
                 s.
                   getBounds(
                     ),
                 1);
    }
    protected java.awt.Rectangle outset(java.awt.Rectangle r,
                                        int amount) {
        r.
          x -=
          amount;
        r.
          y -=
          amount;
        r.
          width +=
          2 *
            amount;
        r.
          height +=
          2 *
            amount;
        return r;
    }
    public void repaint() { canvas.repaint(
                                     ); }
    public class ElementOverlay implements org.apache.batik.swing.gvt.Overlay {
        public void paint(java.awt.Graphics g) {
            if (controller.
                  isOverlayEnabled(
                    ) &&
                  isOverlayEnabled(
                    )) {
                int n =
                  elements.
                  size(
                    );
                for (int i =
                       0;
                     i <
                       n;
                     i++) {
                    org.w3c.dom.Element currentElement =
                      (org.w3c.dom.Element)
                        elements.
                        get(
                          i);
                    org.apache.batik.gvt.GraphicsNode nodeToPaint =
                      canvas.
                      getUpdateManager(
                        ).
                      getBridgeContext(
                        ).
                      getGraphicsNode(
                        currentElement);
                    if (nodeToPaint !=
                          null) {
                        java.awt.geom.AffineTransform elementsAt =
                          nodeToPaint.
                          getGlobalTransform(
                            );
                        java.awt.Shape selectionHighlight =
                          nodeToPaint.
                          getOutline(
                            );
                        java.awt.geom.AffineTransform at =
                          canvas.
                          getRenderingTransform(
                            );
                        at.
                          concatenate(
                            elementsAt);
                        java.awt.Shape s =
                          at.
                          createTransformedShape(
                            selectionHighlight);
                        if (s ==
                              null) {
                            break;
                        }
                        java.awt.Graphics2D g2d =
                          (java.awt.Graphics2D)
                            g;
                        if (xorMode) {
                            g2d.
                              setColor(
                                java.awt.Color.
                                  black);
                            g2d.
                              setXORMode(
                                java.awt.Color.
                                  yellow);
                            g2d.
                              fill(
                                s);
                            g2d.
                              draw(
                                s);
                        }
                        else {
                            g2d.
                              setColor(
                                elementOverlayColor);
                            g2d.
                              setStroke(
                                new java.awt.BasicStroke(
                                  1.8F));
                            g2d.
                              setColor(
                                elementOverlayStrokeColor);
                            g2d.
                              draw(
                                s);
                        }
                    }
                }
            }
        }
        public ElementOverlay() { super();
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public java.awt.Color getElementOverlayColor() {
        return elementOverlayColor;
    }
    public void setElementOverlayColor(java.awt.Color selectionOverlayColor) {
        this.
          elementOverlayColor =
          selectionOverlayColor;
    }
    public java.awt.Color getElementOverlayStrokeColor() {
        return elementOverlayStrokeColor;
    }
    public void setElementOverlayStrokeColor(java.awt.Color selectionOverlayStrokeColor) {
        this.
          elementOverlayStrokeColor =
          selectionOverlayStrokeColor;
    }
    public boolean isXorMode() { return xorMode;
    }
    public void setXorMode(boolean xorMode) {
        this.
          xorMode =
          xorMode;
    }
    public org.apache.batik.swing.gvt.Overlay getElementOverlay() {
        return elementOverlay;
    }
    public void removeOverlay() { canvas.
                                    getOverlays(
                                      ).
                                    remove(
                                      elementOverlay);
    }
    public void setController(org.apache.batik.apps.svgbrowser.ElementOverlayController controller) {
        this.
          controller =
          controller;
    }
    public boolean isOverlayEnabled() { return isOverlayEnabled;
    }
    public void setOverlayEnabled(boolean isOverlayEnabled) {
        this.
          isOverlayEnabled =
          isOverlayEnabled;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/PDSG+/+t5dK90ilq8o+uJzJdlyYmAQCqvAo4gQB6Jnys8HRLhJ4+tjZve68" +
       "Izo17Hk3dDJZgPuidnF/+ZzneaDg8jvAdbg3ysPznuegtL1pbZs8vk2fLJKf" +
       "ODL0+/zAiwCVmrq39b8GvwNw/Z/iKrorMnYz/YOdfbjx2HG84YOZ7LXamYkK" +
       "hISeVdjpPmIFNvTAVsnkTXS4zd65wyJFiqS9Gxm7oUq94yxgFFy1PeDaDQDT" +
       "NwBc3Pa2XOxHpYfOEn5MG3GOQOYmCXwKXI09gY0bEMi9FALvSb2A9lTtYtNh" +
       "A9MBM0Oyj2KhZx/8lvW5P/+VXYR63k7OVdY+9tzH//rwk89dOrUueOKa0Px0" +
       "m93aYEvhy7dkFp7n8YtG2bbo/9lXn/3nv/zsR3dUPXg2yu2BRdyv/MGPf+/w" +
       "s9/++nVCpXsWnmdrsntOLPxNiqWYot+5F8s7byAW5aWI5W5l6/eLJ/gcTepN" +
       "0lQYb3tPU/sGNK1eCk0PnNXlI8t74w1mLyOJDvdVzyGwbhLB4+Aa7BEMboAg" +
       "fCkI7t0jCM/o01ltn8ib7ULvGeW3xt/+5ufzr355py4LGaxkSuUb7Rlcu21R" +
       "xJRPXRAXn6wmfzj4my98509n7720n8zvPwv/NRfBP5LC9aKPoujZc7yPbpL3" +
       "VXBR+8GpG/D+Qy+F95eLGTIoYqZjn928yfVJ57iHc6A+fJOgijlsvAc1vgGo" +
       "j78UUFfNcE9bzy1CR7XIf8856j7xotTtnNwBmCvvqh5ih1uL/9nrj39Hcftm" +
       "4CDC7ZYQaKGbrmwfEfSala08eTSHzgCrQUDz5MrGjlh+dasmRehwuNtXOUdr" +
       "/yXTCkzogZPOKM81nv7Ef//U7/29J74F7IUs3ZUUwQowgVMjMnGxa/WRL3/6" +
       "9fc/9+1PbBcDgKHsZ3pX3130+rmLEBfJp4vkM0dQHymgTrcrbUoOI3obv2vq" +
       "MVrxFJ73RmAV4N0C2uihJY6EROvoR8/kTr3FpxM3rmm0hhNlDClPkE2tpwxs" +
       "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" +
       "0l5iOsKI8JaGtJojEdKfhYulS3lDOovn");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("S92SBmitHXbiuYJkVaHiloOG1RotBhpfJ/mm7wQxL9QXemfCcfLA3URyXVyj" +
       "C2mWsXG9vpgzZN72JvpmCfm6XDbcyKbTVqv1zmLL7ZdvbivwFdtdz+OjZSsb" +
       "Kwo+exO7fbuix4vkqeO94u3v7tK540in9opPvXsuFe+oXn+jE2Pb91Nf+PBz" +
       "z6ujX6ocbfO/LyrdF3n+220t0exTXT0EenrrjV8c0NsDcyfvkn/nw//jEe5d" +
       "y/ffxFmaN5yj83yX/4j+8tcHb1J+7lLpjuM3y9cc5Tvb6Omz75MvB1oUBy53" +
       "5q3y68+eZ3kzuLQ9Z7Xzu/Ansrv+Fvybd7I/dyTi3MGKh4oXDJuacqh6ztG7" +
       "hG27r11wlOJfFclvRaXLsqru21x3PznxTPVEuf7Zi20lnx5mm/FPz3KjDC5/" +
       "zw3/tnKjePwX2wr/8QLY3yySfx+VXh5ojpdoe+RF5r85QfmNW0X5GLg+sEf5" +
       "gduD8jSI/3ZB2R8VyR9EpQfOAAzPIfzDW0D4cJH5NnD9zB7hz9wswt6LIvyz" +
       "C8q+UyR/EpVeaWhRy7aPELa92FXDI5t48PigxERTgOkatnaC/k9vFX1h07+4" +
       "R/+Ltwf9NVr8wwtY8JdF8v2odBWwYI9/B7/I/+4J0B/cDqBf2gP90m0FeiSo" +
       "a0+FFW/UB4HsL00lZDxVK3o5OLgxNw7uKjL/6sW58eNb5caj4Pranhtfuz3c" +
       "uLStcOmE0nP+9w5z58sPrlzAgFcWyeWodLcXR6EWnYV9cP+terPXguvre9hf" +
       "v1nYL+rNDh69oOyxInltVLon0HzZPO+oDx65BWjb0OcnwPXjPbQf335ob72g" +
       "7G1F8lRUevWJ1l5zfOoE6ZtuVYgdQPTdu7a7/1tHesplEVtI6AVwG0VSAXDD" +
       "G8I9JdjqrQr27YCwK3u4V26/YNsXlHWL5J1R6XXXCPbUgb5z4n3XrYoXAqQ/" +
       "ssf72v9H4mUuAM0WCQFAXyPec6BPCZm8BdAPFZmvA+Q9sQf9xO0XsnRBWXH6" +
       "5YAHSxsznO+OFha13nMCbnYbIuWDt+/Bvf22S/Q9WxT6BQiLD1YOZLBAABI9" +
       "BfGU/Ba3Kr8nATHoHiJ6++UXXFBWzCQHDlhTX2OkRW3vBKR7q3J8A6B3f1jy" +
       "4JrDkrcO8qcuKPtgkWTHi51TAE9JMb9VgG1A6/7g3sE1B/duWVE/skXy8QtQ" +
       "/t0i+WmAEijq2bNzp1B+5FZ19YniDNceJXv7xfiZC8qKHZ6Dn73RMbwTjD93" +
       "q5J8GpAr7DEKt12SO5fzDy4A+oUi+TwwSiDJa5GekubzN4M0jUqvuu4XYMXn" +
       "LA9f843q7rtK5SvPX7n3Nc/zf7j9COr428f7qNK9emzbp78pOHV/tx9ourll" +
       "xH27Lwz8LbAvRaXHXuwUaOFpjx8KEAdf3DX+CqD/uo2j0p3F3+m6/xhoyfm6" +
       "Uemu7f/per8GRjupB1YOu5vTVX4DLD5AleL2N/0tU88erNx9k5HuFmYPn9aq" +
       "7WLrwRcT0akNxSfObANuPy4+2rKL2f0x5a8+TzI/+QP0l3Yfdym2nOdFL/dS" +
       "pXt235ltOy22/R6/YW9Hfd2Nv+VHD/zqfU8dbVE+sCP4RMNP0faG639J1XP8" +
       "aHv6OP/N1/zaO/7h83+8Pef5fwGlrYYT9T0AAA==");
}
