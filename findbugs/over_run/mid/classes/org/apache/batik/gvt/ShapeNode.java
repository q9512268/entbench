package org.apache.batik.gvt;
public class ShapeNode extends org.apache.batik.gvt.AbstractGraphicsNode {
    protected java.awt.Shape shape;
    protected org.apache.batik.gvt.ShapePainter shapePainter;
    private java.awt.geom.Rectangle2D primitiveBounds;
    private java.awt.geom.Rectangle2D geometryBounds;
    private java.awt.geom.Rectangle2D sensitiveBounds;
    private java.awt.Shape paintedArea;
    private java.awt.Shape sensitiveArea;
    public ShapeNode() { super(); }
    public void setShape(java.awt.Shape newShape) { fireGraphicsNodeChangeStarted(
                                                      );
                                                    invalidateGeometryCache(
                                                      );
                                                    this.shape = newShape;
                                                    if (this.shapePainter !=
                                                          null) {
                                                        if (newShape !=
                                                              null) {
                                                            this.
                                                              shapePainter.
                                                              setShape(
                                                                newShape);
                                                        }
                                                        else {
                                                            this.
                                                              shapePainter =
                                                              null;
                                                        }
                                                    }
                                                    fireGraphicsNodeChangeCompleted(
                                                      ); }
    public java.awt.Shape getShape() { return shape; }
    public void setShapePainter(org.apache.batik.gvt.ShapePainter newShapePainter) {
        if (shape ==
              null)
            return;
        fireGraphicsNodeChangeStarted(
          );
        invalidateGeometryCache(
          );
        this.
          shapePainter =
          newShapePainter;
        if (shapePainter !=
              null &&
              shape !=
              this.
                shapePainter.
              getShape(
                )) {
            shapePainter.
              setShape(
                shape);
        }
        fireGraphicsNodeChangeCompleted(
          );
    }
    public org.apache.batik.gvt.ShapePainter getShapePainter() {
        return shapePainter;
    }
    public void paint(java.awt.Graphics2D g2d) { if (isVisible)
                                                     super.
                                                       paint(
                                                         g2d);
    }
    public void primitivePaint(java.awt.Graphics2D g2d) {
        if (shapePainter !=
              null) {
            shapePainter.
              paint(
                g2d);
        }
    }
    protected void invalidateGeometryCache() { super.
                                                 invalidateGeometryCache(
                                                   );
                                               primitiveBounds =
                                                 null;
                                               geometryBounds =
                                                 null;
                                               sensitiveBounds =
                                                 null;
                                               paintedArea =
                                                 null;
                                               sensitiveArea =
                                                 null;
    }
    public void setPointerEventType(int pointerEventType) {
        super.
          setPointerEventType(
            pointerEventType);
        sensitiveBounds =
          null;
        sensitiveArea =
          null;
    }
    public boolean contains(java.awt.geom.Point2D p) {
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case VISIBLE_FILL:
            case VISIBLE_STROKE:
            case VISIBLE:
                if (!isVisible)
                    return false;
            case PAINTED:
            case FILL:
            case STROKE:
            case ALL:
                {
                    java.awt.geom.Rectangle2D b =
                      getSensitiveBounds(
                        );
                    if (b ==
                          null ||
                          !b.
                          contains(
                            p))
                        return false;
                    return inSensitiveArea(
                             p);
                }
            case NONE:
            default:
                return false;
        }
    }
    public boolean intersects(java.awt.geom.Rectangle2D r) {
        java.awt.geom.Rectangle2D b =
          getBounds(
            );
        if (b !=
              null) {
            return b.
              intersects(
                r) &&
              paintedArea !=
              null &&
              paintedArea.
              intersects(
                r);
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getPrimitiveBounds() {
        if (!isVisible)
            return null;
        if (shape ==
              null)
            return null;
        if (primitiveBounds !=
              null)
            return primitiveBounds;
        if (shapePainter ==
              null)
            primitiveBounds =
              shape.
                getBounds2D(
                  );
        else
            primitiveBounds =
              shapePainter.
                getPaintedBounds2D(
                  );
        if (org.apache.batik.util.HaltingThread.
              hasBeenHalted(
                )) {
            invalidateGeometryCache(
              );
        }
        return primitiveBounds;
    }
    public boolean inSensitiveArea(java.awt.geom.Point2D pt) {
        if (shapePainter ==
              null)
            return false;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else {
                    return false;
                }
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                return shapePainter.
                  inPaintedArea(
                    pt);
            case VISIBLE:
            case ALL:
                return shapePainter.
                  inSensitiveArea(
                    pt);
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null)
                    return fillShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null)
                    return strokeShapePainter.
                      inSensitiveArea(
                        pt);
                break;
            case NONE:
            default:
        }
        return false;
    }
    public java.awt.geom.Rectangle2D getSensitiveBounds() {
        if (sensitiveBounds !=
              null)
            return sensitiveBounds;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveBounds =
                  shapePainter.
                    getPaintedBounds2D(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveBounds =
                      fillShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveBounds =
                      strokeShapePainter.
                        getSensitiveBounds2D(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveBounds =
                  shapePainter.
                    getSensitiveBounds2D(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveBounds;
    }
    public java.awt.Shape getSensitiveArea() {
        if (sensitiveArea !=
              null)
            return sensitiveArea;
        if (shapePainter ==
              null)
            return null;
        org.apache.batik.gvt.ShapePainter strokeShapePainter =
          null;
        org.apache.batik.gvt.ShapePainter fillShapePainter =
          null;
        if (shapePainter instanceof org.apache.batik.gvt.StrokeShapePainter) {
            strokeShapePainter =
              shapePainter;
        }
        else
            if (shapePainter instanceof org.apache.batik.gvt.FillShapePainter) {
                fillShapePainter =
                  shapePainter;
            }
            else
                if (shapePainter instanceof org.apache.batik.gvt.CompositeShapePainter) {
                    org.apache.batik.gvt.CompositeShapePainter cp =
                      (org.apache.batik.gvt.CompositeShapePainter)
                        shapePainter;
                    for (int i =
                           0;
                         i <
                           cp.
                           getShapePainterCount(
                             );
                         ++i) {
                        org.apache.batik.gvt.ShapePainter sp =
                          cp.
                          getShapePainter(
                            i);
                        if (sp instanceof org.apache.batik.gvt.StrokeShapePainter) {
                            strokeShapePainter =
                              sp;
                        }
                        else
                            if (sp instanceof org.apache.batik.gvt.FillShapePainter) {
                                fillShapePainter =
                                  sp;
                            }
                    }
                }
                else
                    return null;
        switch (pointerEventType) {
            case VISIBLE_PAINTED:
            case PAINTED:
                sensitiveArea =
                  shapePainter.
                    getPaintedArea(
                      );
                break;
            case VISIBLE_FILL:
            case FILL:
                if (fillShapePainter !=
                      null) {
                    sensitiveArea =
                      fillShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE_STROKE:
            case STROKE:
                if (strokeShapePainter !=
                      null) {
                    sensitiveArea =
                      strokeShapePainter.
                        getSensitiveArea(
                          );
                }
                break;
            case VISIBLE:
            case ALL:
                sensitiveArea =
                  shapePainter.
                    getSensitiveArea(
                      );
                break;
            case NONE:
            default:
        }
        return sensitiveArea;
    }
    public java.awt.geom.Rectangle2D getGeometryBounds() {
        if (geometryBounds ==
              null) {
            if (shape ==
                  null) {
                return null;
            }
            geometryBounds =
              normalizeRectangle(
                shape.
                  getBounds2D(
                    ));
        }
        return geometryBounds;
    }
    public java.awt.Shape getOutline() { return shape;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVafZAUxRXv3Tvui/sEuUOQA45DPcTd4AeWnorncRyHd9zW" +
       "HWB5GI7Z2d67kdmZYab3bkGJaFWUWCWxBMWo8I9oDIVipTSkNBryqZYaozEG" +
       "NdGoZTRRUpJUxECiea9nZmd2dmdw5XJV0zvX3e/1+733+vXr7tl/hEwydNKi" +
       "CUpCiLBNGjUiMXyPCbpBE52yYBiroHZYvO3dHTce+13lTWFSNkRqRwWjTxQM" +
       "ukyicsIYIrMkxWCCIlJjJaUJpIjp1KD6mMAkVRki0ySjJ6XJkiixPjVBscMa" +
       "Qe8lDQJjuhRPM9pjMWBkdi+XJsqliXZ4O7T3kmpR1TY5BDNyCDpdbdg35Yxn" +
       "MFLfe50wJkTTTJKjvZLB2jM6OUdT5U0jssoiNMMi18kXWopY0XthnhpaHqv7" +
       "7MQdo/VcDVMFRVEZh2gMUEOVx2iil9Q5tV0yTRkbybdISS+Z7OrMSGuvPWgU" +
       "Bo3CoDZepxdIX0OVdKpT5XCYzalME1EgRubmMtEEXUhZbGJcZuBQwSzsnBjQ" +
       "zsmitc3tgXjXOdGdu9bV/7CE1A2ROkkZRHFEEILBIEOgUJqKU93oSCRoYog0" +
       "KGDwQapLgixttqw9xZBGFIGlwQVstWBlWqM6H9PRFVgSsOlpkal6Fl6SO5X1" +
       "36SkLIwA1kYHq4lwGdYDwCoJBNOTAvieRVK6QVIS3I9yKbIYW6+CDkBanqJs" +
       "VM0OVaoIUEGmmC4iC8pIdBCcTxmBrpNUcEGd+5oPU9S1JogbhBE6zMh0b7+Y" +
       "2QS9KrkikISRad5unBNYaYbHSi77HFl56fbrleVKmIRA5gQVZZR/MhA1e4gG" +
       "aJLqFOaBSVi9oPduofHpbWFCoPM0T2ezz8Ebjl6xsPnQc2afmQX69MevoyIb" +
       "FvfGa185o7Pt4hIUo0JTDQmNn4Ocz7KY1dKe0SDSNGY5YmPEbjw08Otrtu6j" +
       "H4dJVQ8pE1U5nQI/ahDVlCbJVO+mCtUFRhM9pJIqiU7e3kPK4b1XUqhZ259M" +
       "GpT1kFKZV5Wp/H9QURJYoIqq4F1Skqr9rglslL9nNEJIOTykGp4WYv7xX0aG" +
       "o6NqikYFUVAkRY3GdBXxo0F5zKEGvCegVVOjcfD/DecuilwUNdS0Dg4ZVfWR" +
       "qABeMUrNxujIGIsOjgoaXQlhKYKOpv3/h8ggyqnjoRAY4Azv9Jdh5ixX5QTV" +
       "h8Wd6Su7jj46/ILpWjgdLP0w0gzjRMxxInycCIwTyY5DQiHO/jQcz7QtWGYD" +
       "zHEIstVtg99csX5bSwk4lTZeCmrFrmfmLTqdTjCwI/iwuP+VgWMvv1S1L0zC" +
       "EC/isOg4kb81J/KbC5euijQBocdvDbDjYNQ/6heUgxy6Z/ymNTd+g8vhDubI" +
       "cBLEISSPYQjODtHqncSF+Nbd+tFnB+7eojrTOWd1sBe1PEqMEi1eY3rBD4sL" +
       "5ghPDD+9pTVMSiH0QLhlAkwPiGTN3jFyokW7HXkRSwUATqp6SpCxyQ6XVWxU" +
       "V8edGu5lDfz9NDDxZJw++LLCmk/8F1sbNSybTK9En/Gg4JH9skFt9+Hf/PV8" +
       "rm57Eahzrd6DlLW7Ag8ym8JDTIPjgqt0SqHfn+6J7bjryK1ruf9Bj3mFBmzF" +
       "shMCDpgQ1Pzt5za+8c7be18LOz7LYOVNxyGJyWRBYj2pCgCJfu7IA4FLhpmN" +
       "XtO6WgGvlJKSEJcpTpL/1M1f9MQn2+tNP5ChxnajhSdn4NSffiXZ+sK6Y82c" +
       "TUjEhdPRmdPNjMZTHc4dui5sQjkyN70663vPCrshrkMsNaTNlIdHwnVAuNEu" +
       "4PijvDzf07YYi1bD7fy588uV4AyLd7z2ac2aT585yqXNzZDctu4TtHbTvbCY" +
       "nwH2Td5As1wwRqHfBYdWXlsvHzoBHIeAowgh0ujXIbplcjzD6j2p/M2f/aJx" +
       "/SslJLyMVMmqkFgm8ElGKsG7qTEKgTGjLbnCNO54BRT1HCrJA4/6nF3YUl0p" +
       "jXHdbv5x0+OXfn/P29ypTC+aycnLDUzMvPGQZ9fOVP7krfve/+mxB8rNtbnN" +
       "P3556KYf75fjN7/3eZ6SeeQqkDd46Iei+++f0Xn5x5zeCSFIPS+Tv6JAkHVo" +
       "z9uX+le4pexXYVI+ROpFK5NdI8hpnJhDkL0ZdnoL2W5Oe24mZqYd7dkQeYY3" +
       "fLmG9QYvZyWDd+yN7zWeeFWLVpwBz1nWVD7LG69ChL90c5IzedmGxUI7PFRq" +
       "uspASprwRIiaALYMdmC4inKK6YzUch8Sxq3F1QySWF6ExXKT8yW+LtmRC+hs" +
       "eBZaIy/0ATRgAsJiRb7cftSMVHO5YwJPwG3x5/rnCVZPD6LBr46o2ka0yJJp" +
       "kQ+itb4mKtd0CTal1GOgyQFMIRQBUQpWmTF6pZpWEoaN9fSsqUaomoJ0WwT3" +
       "G5HpeUs9GK8tEiP6yGJLnMU+GJOO1dblg/GjBv9CWSnTN5lYsDbuEXfka5ik" +
       "3Rqw3UfcVKC4ftSge4Mqhkv3heRVipS3GR6rq/lbQF4WKK8fNSOTNe7liQ6d" +
       "Cli10iNrukhZ58DTZY3W5SPr9YGy+lEzUpPVrZ+0NwRIm3FGXZAdlf+VEc8u" +
       "yp0QOYsewXV8lt9Gl2/S9968c0+i/8FF5pI3JXfz2KWkU4+8/t8XI/f8+fkC" +
       "O5ZKpmrnynSMyq4x62HIuXkLbR8/B3BWrYtePVby1p3Tq/P3HMip2WdHscB/" +
       "RfYO8OzNf5ux6vLR9UVsJmZ7FOVl+YO+/c93nyneGeZHGeYimXcEkkvUnrs0" +
       "VumUpXVlVc4C2ZKb0ONUX22ZdrXXHR3n8XhFNk32I/UklCEzXHOP5Fx3BGSc" +
       "d2GxnZEK2O3zdcYITI5idiw3DzyiW6a8s+H+jx4xPcybCXk60207b/sysn2n" +
       "6W3mMdO8vJMeN4151MTlrDfV8SX8heD5Ah8EgRX4C/lOp3XeMSd74KFpGe6x" +
       "AWLxIZZ9eGDLUw9vuTVsKeUWRkrHVCnhTOXvnizw5CSzWLGEV9+WtWIDNp0O" +
       "T9KyYrJ4B/AjDbDvwwFt+7B4AGw/Ytmeu4wDeu8pg+Zefxk8miW5VjxoP1J/" +
       "r7+ac308APmPsDjA10fmza7udRTw2CkrYDo2YUKy1UKxtXgF+JEG4DsU0PZz" +
       "LJ4C7CP52K92sP9kYow/H57bLQC3F4/dj7Sw8e3Ucmo2tezWBW1UEo3zlvLB" +
       "XgzQy2+xeBY2FDwH8XjCcxOjjQg8uyxIu4rXhh+p/1R4iXN9MwD2H7H4PWS2" +
       "2TQ9VgD/66eMn2+ocBv0kAXioZPgL7Cb8iMNgPeXgLaPsHiXkSZJGRNkKQFL" +
       "RreV3nfiFsyjg/cmxgcuhueABeRA8T7gR+ozI/AoyZWw4f3hYDpuMM/afKDx" +
       "2MZflm9eat9cFCIxe15l9L385PIPh3nyVYHZXTblcWV2HfqIlXthWY/Ffab6" +
       "drnedzNSIllXc7lCN3olMAcvW7T73zfecrg/TEp7SEVakTamaU8iNxErN9Jx" +
       "l0jOhRGvcMuDuQMjoQWQJvDqfwT4yhdYHIHQAitGTOUBs2uMKsxm7PKTv5+y" +
       "n0zFppnwPGkZ+8ni/cSPNDhyTsvdlHOkZuwMVfhrJ1SNRQlkEtb5lrnJ/6e/" +
       "2cvjqipTQSkUs05ksroMlU6MLmfBc9hSyOHidelH6h9341wtMwNUNguLRmbd" +
       "wBp4ZYU1tQ72plPG3oRNbfB8YAH4oHjsfqQB0M4KaMMDpVALZOuQfcRyD4a4" +
       "3hz48ybG9LiFPm5hOF48fD9SX9OHKjnO8wN0cCEWEcY/D/CcIbjtH50w+4es" +
       "07lQ3pHfSRXgSxqAb0lAWwcWl5j2HyxwOOXAb5+YLddckD1lYUgVD9+PNADi" +
       "VQFtfVgsY6TeDT97fuSA754Y258Nku+zEOwrHrwfaQDAqwParsFigJEGAN+d" +
       "f47qoD/pqfZXMz2soKGDFoSDxaP3Iw1AKAa0YZoQWgcBH9D3pxl+Z+Ex+nDx" +
       "sDOMVGY/I8BLtOl5HyiZH9WIj+6pq2jas/oP/Co7++FLNeRwybQsu+94XO9l" +
       "mk6TEtdVtXnjo3EsMiOnFbqqgHwOSr6QbTB7quDr3p6wx+K/7n46KMbpx0iZ" +
       "+eLukgbu0AVfxzQ7YWkreGPSAemqLojM3v6hdjJmkpM9PbXVTqadTO2uA9d5" +
       "OUdj/JsxO0lNm1+NQS69Z8XK648uftC8fBdlYfNm5DIZUlPzOwArM3afTHm5" +
       "2bzKlredqH2scr59MtVgCuw470xXjroEnFVDJ5jhuZk2WrMX1G/svfSZl7aV" +
       "vRomobUkJEBCuzb/njCjpXUye21voSR8jaDzS/P2qvfXv/z5m6Ep/DqWmGl7" +
       "cxDFsLjjmbdiSU27N0wqe8gkSQGj8EvMpZuUASqO6Tk5fVk8GxpKekkteqyA" +
       "35NxzVgKrcnW4scbjLTkHyfmf9BSJavjVOeBB9nUeM5x05rmbuWaPY7FfRnU" +
       "NDjhcG+fplkHj2UHueY1Dedj6Dv4z4n/AfD/ZW0YKgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NzTf/3VG2Q+y5L/HhUdNbyk5pirFYPm6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("PRdGsjP4Pah/ersabYHntR3U1+68Ge+NFXcBZWV1Ds7fWgQHF7OkAOwfBCnK" +
       "z523u9S8+HCoPIZ/cHAb8B/KMn8IPL+2g/9rfyFe/Mjpiwc5oK0fHzx8hhAe" +
       "y5LLYCja3cuJbibOC7LvO5rkHQvkyu0K5AnwfHMnkG/ecQ8Xc2zPnoH7vVny" +
       "VLy7Hx1lF0qznMePIT59GxAfzTKfA88f7iD+4Z2BeBJB+YyyapY8HxceBIMT" +
       "dfqiSi6eY5QfuF1FZjPx7+9Qfv9OK/LgkRzOB8+A+qEsacb5Vfy9axAntdm6" +
       "A9o82F0fOrjh+tDtaxM7o2yUJehWm/RNLsgco+ze7qT4acCwu0Pp3nmU7Bll" +
       "syyh4sKVkyiPLrQcY5zcribBaufgSzuMX7rzGKUzypQs+TGwTAYY+zdewzoG" +
       "+eO3q0gw4Bx8dQfyq3cepHtGWfYPgoM5CK0AJJnE2f8N9lRovhV0KVicH12k" +
       "z24FP3bDX3S2fytRvvzK5XsffYX9N/ld8qO/ftw3LtyrJ45z8hLnifd7glDT" +
       "zRzwfdsrnUGOYhkXHr7ZlUQwuQBpPlgkW8o1sNl9SjAxzr9P0v0kEMkxXVy4" +
       "Z/tykuRjoHVAkr2+FByO7M/d9GZkW47iUFLiwzl7Jp10Oxt47KRd5NO3B99I" +
       "4Ce2Tt5zasMj/9fU4eZEsv3f1HXltVeGxE98r/4L29vviiNtNlkr944LF7YX" +
       "8fNGsw2Op2/Z2mFb9wye+8Glr9z37OFmzKUtw8c2eoK3d9/8qnnXDeL8cvjm" +
       "Hz7693/kl175g/xi1/8D3aTpo842AAA=");
}
