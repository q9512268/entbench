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
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1Ze8zj2FX3fLMzOzvd7sxuuw+W7rOzha1Xn5PYcRxNW5rE" +
           "iePEdvxI4iSUzjp+JE78tuM4Lgt9AFtaURbYliK1+1croNo+QFQgoaJFCNqq" +
           "FaKo5SXRrRAShVKp+welokC5dr7vy/d9M7OrgkSk3Dj3nnPvOfec8/O55z7/" +
           "behcGECw51qbmeVG+3oS7S+s8n608fRwv8OUeSUIda1hKWHYB33X1Ec/c+m7" +
           "339mfnkPOj+BXqM4jhspkek6oaiHrhXrGgNd2vU2Ld0OI+gys1BiBVlFpoUw" +
           "ZhhdZaBXHWONoCvMoQgIEAEBIiC5CEhtRwWYXq07K7uRcShOFPrQz0BnGOi8" +
           "p2biRdAjJyfxlECxD6bhcw3ADBey/0OgVM6cBNDDR7pvdb5O4Q/CyLO//vbL" +
           "v3sWujSBLpmOlImjAiEisMgEut3W7akehDVN07UJdKej65qkB6ZimWku9wS6" +
           "KzRnjhKtAv1ok7LOlacH+Zq7nbtdzXQLVmrkBkfqGaZuaYf/zhmWMgO63rPT" +
           "dathK+sHCl40gWCBoaj6IcstS9PRIuih0xxHOl7pAgLAequtR3P3aKlbHAV0" +
           "QHdtbWcpzgyRosB0ZoD0nLsCq0TQ/TedNNtrT1GXyky/FkH3nabjt0OA6rZ8" +
           "IzKWCLr7NFk+E7DS/aesdMw+3+be9IF3OG1nL5dZ01Urk/8CYHrwFJOoG3qg" +
           "O6q+Zbz9jcyHlHs+9949CALEd58i3tL8/k+/9NYnHnzhC1uaH70BTW+60NXo" +
           "mvqx6R1feV3j8erZTIwLnhuamfFPaJ67P38wcjXxQOTdczRjNrh/OPiC+Gfj" +
           "d35C/9YedJGGzquutbKBH92purZnWnpA6Y4eKJGu0dBtuqM18nEauhU8M6aj" +
           "b3t7hhHqEQ3dYuVd5938P9giA0yRbdGt4Nl0DPfw2VOief6ceBAEvQp8oRL4" +
           "/gW0/eS/EWQic9fWEUVVHNNxET5wM/1DRHeiKdjbOTIFXr9EQncVABdE3GCG" +
           "KMAP5vrBgOJ5IRLGs2ngrkM9QDKEALy9WA8sZcMqDvCKYD9zOe//c7Ek0/zy" +
           "+swZYJTXnYYEC0RT27U0PbimPruqN1/61LUv7R2FyMGeRVATrL+/XX8/X38/" +
           "W39/t/7+Dde/crIXOnMml+K1mVhbtwBGXQJ4AMB5++PST3WefO+jZ4E/eutb" +
           "gEUyUuTm+N3YAQqdw6YKvBp64cPrdw1/trAH7Z0E4kwV0HUxY+cz+DyCySun" +
           "A/BG8156+pvf/fSHnnJ3oXgC2Q8Q4nrOLMIfPb3pgavqGsDM3fRvfFj57LXP" +
           "PXVlD7oFwAaAykgBrg1Q6MHTa5yI9KuHqJnpcg4obLiBrVjZ0CHUXYzmwEK7" +
           "ntwb7sif7wR7jEIHzYlYyEZf42Xta7fekxntlBY5Kr9Z8j76N3/+z2i+3YcA" +
           "funYK1HSo6vHQCOb7FIOD3fufKAf6Dqg+/sP87/2wW8//ZO5AwCK199owStZ" +
           "2wBgAUwItvnnv+D/7Ytf/9hX93ZOE4G35mpqmWqyVfIH4HMGfP87+2bKZR3b" +
           "gL+rcYA6Dx/Bjpet/IadbACALBCXmQddGTi2q5mGqUwtPfPY/7z0WPGz//qB" +
           "y1ufsEDPoUs98coT7Pp/pA6980tv//cH82nOqNkLcLd/O7Itqr5mN3MtCJRN" +
           "Jkfyrr984Dc+r3wU4DPAxNBM9RzmoHw/oNyAhXwv4LxFTo2Vsuah8HggnIy1" +
           "Y4nKNfWZr37n1cPv/NFLubQnM53jdmcV7+rW1bLm4QRMf+/pqG8r4RzQYS9w" +
           "b7tsvfB9MOMEzKgCuAt7AUCk5ISXHFCfu/Xv/vhP7nnyK2ehvRZ00XIVraXk" +
           "AQfdBjxdD+cAzBLvJ9669eb1BdBczlWFrlN+6yD35f/OAgEfvznWtLJEZReu" +
           "9/1Hz5q++x++d90m5Chzg/fzKf4J8vxH7m+85Vs5/y7cM+4Hk+tRGiR1O97S" +
           "J+x/23v0/J/uQbdOoMvqQcY4VKxVFkQTkCWFh2kkyCpPjJ/MeLav96tHcPa6" +
           "01BzbNnTQLN7O4DnjDp7vrgz+OPJGRCI50r7lf1C9v+tOeMjeXsla35su+vZ" +
           "44+DiA3zzBNwGKajWPk8j0fAYyz1ymGMDkEmCrb4ysKq5NPcDXLv3DsyZfa3" +
           "6dsWq7IW3UqRP+M39Yarh7IC69+xm4xxQSb4/n985su//PoXgYk60Lk42z5g" +
           "mWMrcqssOf6F5z/4wKue/cb7cwAC6DP8xd9Bv5fN2n05jbOGzJrmoar3Z6pK" +
           "+cueUcKIzXFC13JtX9Yz+cC0AbTGB5kf8tRdLy4/8s1PbrO60254ilh/77Pv" +
           "+8H+B57dO5ZLv/66dPY4zzafzoV+9cEOB9AjL7dKztH6p08/9Ye/9dTTW6nu" +
           "OpkZNsHB55N/9V9f3v/wN754g9TjFsv9Pxg2uv2JNhbStcMPUxxP5bUqJrbe" +
           "Q5GmZm+Miir2pDrrqJOE7odcJJRjaeM3C9oKHeOGRaqiXy/A402UamiEtPWK" +
           "PSlVnaTETqXhoNZp0IKE9qXYH+FY16cKvlgb0PLcGrp+oWt2xoNud+Y1FwTd" +
           "Tihuyfp8rSdrtoZO4z46HRghKaWGbqOog0w8xwFnJR0Z+37Q9HBToMwKOzGr" +
           "i6Q27nHjkt/XGLg3NUI6bYyGCR6veaxqUNNCatquMxixvdKG9aPQnomxVODH" +
           "dkmhp1zYbUp6WRK4FpH0XYtTas007Qv2YBrZJKxGoyFb5Oyu3RBVzLSXjUhm" +
           "KL8z2VB1q9TqNwodgdK7LN0vD0hMk4kGp/g2p/eY6XpDV9eGrrI2MSUi228M" +
           "k+ZcX2OLOjdMuko68pkWVwxtw2OHC23i1MUJ0pXgtIDWXVWCzblYiEWygvF+" +
           "eURH9LrvhVRj3Mc0u23KqF+fdHpuB+AU3ujH7ULXEFvDjkYqM7JOooLD+7UO" +
           "1eqTvghS/5mhcUmb3CDKmJ6jtqKYpWGP6AtVh7Za/hir4O6kleLkfBHYiYnJ" +
           "QqU/laJ2t9uIGgYv2hOjkmAb1AAmSySx31/UnNVi5vVYsrZpCEsLFqV51W0V" +
           "bF9wBkpYt9Ni3acnxak21fD+ZLpJ/HFvSlZHVoB5FCt27RRfjTvVOWe6btrt" +
           "WyHDNJqNMlpyN72w3AjqRTggmYbQx/haf+Ji9QU3ZhvaChdxacFLJFXggs2i" +
           "VWoX4gZLStzIaaj2tDNk5PpY6Bal8cItsTO/ua5V6fXK5KRxbUl2C8pAtnhO" +
           "lYe+trZMoUwvuQ2G0EOJkxmRr1kkI7eTsWCXukPOHRa6FRYZFoyi004latEw" +
           "uzO26mUghFTktU/2CjhJdprNYNZmzdZiGvYXMNWziHKzKTDzqtdYW7xTb+EV" +
           "LVa0FO8PPLXKbli75y0LoiWNBknRSO1yjOs9fIVRqCwrckQQRGi2cC1E22hf" +
           "rki1cd/rUrHDrHhtgxskz8eIoBHZ6W0+pzjZ91aVZW2gR75no1wHFWaEMGuR" +
           "Pam9nBaT5gI1EYNUagWik0rkhrOTPju2p/X5EC91/eK8b9CDwWTAtvrFGsnb" +
           "XjOJZZUJywnGWC7tTkdrYQI3UhwWkDqPUFp34HSWDjiEJ65o2+yyzLUDOKr1" +
           "ekuaUcsdQXadYics4M2aoMpLWRiQpMM0jXEz2hSnobAAbiZbMwEbpjV/rXWT" +
           "ho+Vl+K0VvOVTkKmsYdQZrzZcBonbrrr7iQmrS5JKqK7qfaluTQa6bi4wqpO" +
           "uiGFJWos+6pDNgs1frooOGW1RFdTGG0bhpNM4CpqhZuZ1BziYblU7shsw+7P" +
           "mtUaSaDV5ZpQe4umrWD+ussWR0Khsl7Klc3KG8QEMW/HTac4jqL+lJ8ycLXa" +
           "AZDTxGecT6T1nklU6qWZ3GiWNDWsEuO169utKh3NBt2GAteKLbFDOfPQGzOm" +
           "4i9TWhTgtEris5oSp3yTDJREnXSmxfamCCK5guEdbWUqHVfX0VnHXtWq8WKj" +
           "qhWsI09j0uEp1fEWHl4lVJ5KehrnLCods8yNBNMbEHMfW/dDxpMUvxLBzdFy" +
           "g3DaeFUornsVdr1xmmMzZUubxaKT4LzCOKEm1td1u18O2r0RuixP7Vq51hkg" +
           "9JpUN65WMuVBz500SHc5ISZhB8cdHUHYVUR7ANHGyxbs1jprxyVbrDKMBHuj" +
           "xANRHwtSzWHi0XyBlH1u1E+IvlqTOm01nFR6kwVfrI0qtfKSYFexMwqcWF0x" +
           "Fk7D87ozUBtqKxjWxYRhgIOZzLqXrcd580KVhm0n0FJrLWPLJiOXyxZMTAvd" +
           "Zo9h2/XCqGTU+uSAnXs9fCwZDoq0tVW5SuhVR4bFEp6SC1ce8QtxhBFlxBXW" +
           "cFU1EsMZdDixN7JKLGwwm3HZ8EoxLDQsnZ5WBqMUC6QiH9O+MbPdOkkVg7Ag" +
           "gUhmygJFk1XMUtEGQ5UKTMyHpbYzGgsYPGp3uVqpow1Tq1qOe3EAb6p6M4KH" +
           "1SFKGmKFHHaLzaW2plh0HKiusqYJRtVacwJtsVSblCmTCjsl0utr0ULEDWwF" +
           "a3WU7budSUtcKG2fq7nhYNNlHABREYxUuVFviRPyWDZn+LzOoS28SYfkHHbr" +
           "uNrv1QxCBuikM0ZpHLi9uagL5FCW3LHLxOtoalVRdTZNqYQGwIbyZBVRiXBU" +
           "V9ZRV+rZGN3VMDuZr6uVDpWWsY3OeLLQKY0nw+V8JFBiG3ig4/v+bFJdSAWZ" +
           "b4UzdaTNwnoaU7KFLI3C1F3xaQNeJuWK3q2sBlHc1cezulJeaTBRho1kgxCE" +
           "MbRMS4lKFYIyBK4yEYeWyEst3l9VS2gK91PET+NJ1aKYRjn14kGjglXxgrDW" +
           "8aEJ3trWUDVgfWXTqGH1nU1zFdSKFrtab1YwC8ARXw9RH1bm7swednzK1DeJ" +
           "UawHbFc07fo0QmZjozvpOJSveVKtuephpZptRMXSLAZZzHDC1Op6gLGturKx" +
           "Kd62tAlldjmJdJQy0yYLmwReUnTg4XaJ5eXyUFnYxqLMssBYgj40a3RJHyp4" +
           "e8hGZCqZGDkdb4rIVC8y+opvaHNKr1ACwSxTPhnx2MZwJqpgDXW5LcrofFVT" +
           "dLkg9oPpmlYxfhNPhwE9G85QGO7xxmJKwNoicOtoGAma2h6UmZFDLjB1KWs4" +
           "QqhLKq2Ik2QwUcxyXGESbsWji2i8FFBW6a5wnxjhDs8QfZ8zU7VajBK6GaFu" +
           "c4yBXKxdXPM02e0Wij69dLGlyjUDPSIkhOfFKod2RVeYIuZ6zlrYqj7Q/NFI" +
           "SCblGG6EcYrOK7Ww1kQJknCH644b18uC1cZok10nw5kwRxxGJkRGpSO+xyjF" +
           "VC+4vihZPiJUJiwHcreC15ktCD5hUIAR9KK57BOpwOhVlVoU1vIK5TfFCtMa" +
           "tcMKbw5mHjrlnI6lzl0YCxS+VSoKKTqyi7CLws48UtJ2A3Fttaa3R4ZI2oUO" +
           "N68WNXyB6rKWIoSJ9IoM1urAhbFpN6jivMCM+Jbl+fVUVWrddjPGNIlc0+WR" +
           "O3e8iuNtykoBsdsoIbS0XkSVo5G1hH2rXC5jnOFwm3KjWBFLFDeqDaR+S9Kk" +
           "WckwWIrWO7Lf6PtNO61jwYy2F2JI4iw+T8geLAvYSGhwI24wRirpjDAZm8Dt" +
           "gpnEsU+pw0WHKk8GrZUbeUIcsUlhxujutIGp8AAxgjkxtRay0mwhy8TrVrVR" +
           "4pUHFcTqVhqGU/JdCpMleS5y4D02KQ38odI0knrSIHQmbHfawcy3RTNhuoSz" +
           "mJUnzbhlLNMO4fhteuqopUFthBVxgtFko0UnMEz0kcFcayB4IoDDwZvfnB0b" +
           "3vbDndzuzA+pRxcO4MCWDVA/xIllO/RI1jx2VJjLSxQXX6Ywd6x4cebwQPzo" +
           "dWXacA2OxfuzONo/qMFmB7YHbnblkB/WPvbuZ5/Teh8v7h3Uh2RwPj+4CTq+" +
           "ZAC98eanUja/btkVLT7/7n+5v/+W+ZM/RFn2oVNCnp7yt9nnv0i9Qf3VPejs" +
           "UQnjuougk0xXTxYuLgIMWAVO/0T54oEjC1zKNvwx8P3agQW+duPS6A295Uzu" +
           "LVsfOVV7O3PSZtsSF3hF7VOB4s1NNcy5opep2OWNG0HnPMU8uCwUjznZEBya" +
           "Y9fUdt7nvdJ5+URZLILuOFm3PxQV/9/dAgBXue+6q8jt9Zn6qecuXbj3ucFf" +
           "54Xvoyuu2xjogrGyrONVpmPP571AN8x8F27b1py8/OfnIujhVxIxgi7u/uSK" +
           "vWfL/HQE3X1DZrCb2c9x2vdF0OXTtMAc+e9xul8Cq+3oQBxtH46TPBNBZwFJ" +
           "9vgr3g0KW9sqXXLmWOwdAEZu2bteybJHLMcL6lm85nfIh7G12t4iX1M//VyH" +
           "e8dL+Me3BX3VUtI0m+UCA926vVs4is9Hbjrb4Vzn249//47P3PbYIZDcsRV4" +
           "FzXHZHvoxhXzpu1FeY07/YN7f+9Nv/nc1/M62/8APQaRdtwfAAA=");
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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "hVCAQTTGN2WJmc8YL/bqnX4youtGle/y");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FkvwbV7rNMFqhPDcwpKiymCMmG5ITcu2T62KBGt1J5qmGFg8jQw57o+mpTla" +
       "xhGPb6awX0mmGFhBhO5KFir0CpNlwUirZJ1tZvpMkhBtOVb7whhuE2A8TB1p" +
       "5TbLQRw+08Amq6KuXahhsVbK4RmO48/nx3W/eG3HiHdvTkwPr56ZFppXfOEa" +
       "Tgq3VY/n2dOH58ybv/OFU9eVjp0zH3tvXcjfb739ajfKNu+2XvnoSy+r/V+A" +
       "D14RfCAq3B653rstba1Zx4a6F4z07NVfOrCbC3VH76F/+6P/86HhexcfvIZ7" +
       "OI+eovP0kP+EffUb9DuUnztXuOnwrfRlV/1Odnru5LvoC4EWrQJneOKN9NtP" +
       "3oV5J0jajrPa6RP8I9ld+fj+nVvZn7pOcepSxr35y4kYUfZV1z54D7Hp9/Uz" +
       "rmH86zz7zahwQVbVXZ8rnkWvXUM9Uq5//kbH0Men2RT8s5PcKILk7bjh3VBu" +
       "5D//5abBfzoD9rfy7D9EhbcEmu2utR3yvPDfHqH85vWifAykD+1QfujGoDwO" +
       "4r+fUfeHefb7UeGuEwDDUwj/4DoQPpAXvgukT+4QfvJaETbfEOGfnlH33Tz7" +
       "46jwVl2LcMs6QNhwV44aHtjEPYeXLHhNAaarW9oR+j+5XvS5Tf/8Dv3P3xj0" +
       "l2nxD89gwV/k2Q+iwiXAgh3+Lfy8/HtHQF+/EUC/sgP6lRsK9EBQl98oy9/G" +
       "04HsLQwl7Lmqlo+yt3d1buzdkhf+1Rtz48fXy41HQPr6jhtfvzHcOLdpcO6I" +
       "0lP+9yZj68v3Lp7BgLfm2YWocN5dRaEWnYS9d8f1erMHQfrGDvY3rhX2G3qz" +
       "vUfOqHsszx6MCrcGmicbpx313kPXAW0T+vwESD/eQfvxjYf27Bl178qzp6PC" +
       "fUdae9nVqyOk77heIRKA6PPbvtv/14/0mMtqbyDVzoCL5RkM4IZXhXtMsOXr" +
       "Fey7AWEXd3Av3njBNs6oI/Ps+ajw8GWCPXYZ8JR433u94oUA6Q/t8D74/0i8" +
       "vTNAD/KsDUBfJt5ToI8JuXMdoO/NCx8G5D25A/3kjRfy9Iy6/ObM3ghsbYxw" +
       "sr2WmLd63xG48Q2IlPfevQP37hsu0fdtUMzPQJh/0LIngw0CkOgxiMfkN7te" +
       "+T0FiKntINZuvPyCM+rylWTPBnvqy4w0b+0egXSuV46PAnp3Fy33Lrtoef0g" +
       "f/qMug/nWXq42TkG8JgUs+sF2AC07i797V126e+6FfVjGySfOgPl382znwEo" +
       "gaKevHd3DOXHrldXgX/ZG+xQDm68GD9/Rl1+wrP3s1e7wneE8eeuV5LPAXLF" +
       "HUbxhkty63L+0RlAX8mzLwGjBJK8HOkxab58LUiTqPC2K349ln8K88Bl37Bu" +
       "v7tUvvryxdvuf3n0B5sPqA6/jbydKdw2X1nW8e8Rjj2f9wJtbmwYcfv26wRv" +
       "A+wrUeGxN7pBmnvawx85iL0vbzt/FdB/xc5R4eb83/G2vwK05HTbqHDL5v/x" +
       "dr8KZjtqB3YO24fjTX4dbD5Ak/zxN7wNU09eytx+z5FsN2YPHNeqzWbrnjcS" +
       "0bEDxSdPHANuPj4+OLJbDXZXnL/2cqf3U6/XfmH7YZhiyVmWj3IbU7h1+43a" +
       "ZtD82O/xq452MNb51jM/uuuXb3/64Ijyri3BRxp+jLZHr/wVVtP2os3N5ew3" +
       "7v/V9/zjl/9oc0f0/wLo9hYAFT4AAA==");
}
