package org.apache.batik.svggen.font.table;
public class GlyfCompositeDescript extends org.apache.batik.svggen.font.table.GlyfDescript {
    private java.util.List components = new java.util.ArrayList();
    protected boolean beingResolved = false;
    protected boolean resolved = false;
    public GlyfCompositeDescript(org.apache.batik.svggen.font.table.GlyfTable parentTable,
                                 java.io.ByteArrayInputStream bais) {
        super(
          parentTable,
          (short)
            -1,
          bais);
        org.apache.batik.svggen.font.table.GlyfCompositeComp comp;
        do  {
            comp =
              new org.apache.batik.svggen.font.table.GlyfCompositeComp(
                bais);
            components.
              add(
                comp);
        }while((comp.
                  getFlags(
                    ) &
                  org.apache.batik.svggen.font.table.GlyfCompositeComp.
                    MORE_COMPONENTS) !=
                 0); 
        if ((comp.
               getFlags(
                 ) &
               org.apache.batik.svggen.font.table.GlyfCompositeComp.
                 WE_HAVE_INSTRUCTIONS) !=
              0) {
            readInstructions(
              bais,
              bais.
                read(
                  ) <<
                8 |
                bais.
                read(
                  ));
        }
    }
    public void resolve() { if (resolved) return;
                            if (beingResolved) { java.lang.System.
                                                   err.println("Circular reference in GlyfCompositeDesc");
                                                 return; }
                            beingResolved = true;
                            int firstIndex = 0;
                            int firstContour = 0;
                            java.util.Iterator i = components.iterator(
                                                                );
                            while (i.hasNext()) { org.apache.batik.svggen.font.table.GlyfCompositeComp comp =
                                                    (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                                      i.
                                                      next(
                                                        );
                                                  comp.
                                                    setFirstIndex(
                                                      firstIndex);
                                                  comp.
                                                    setFirstContour(
                                                      firstContour);
                                                  org.apache.batik.svggen.font.table.GlyfDescript desc;
                                                  desc =
                                                    parentTable.
                                                      getDescription(
                                                        comp.
                                                          getGlyphIndex(
                                                            ));
                                                  if (desc !=
                                                        null) {
                                                      desc.
                                                        resolve(
                                                          );
                                                      firstIndex +=
                                                        desc.
                                                          getPointCount(
                                                            );
                                                      firstContour +=
                                                        desc.
                                                          getContourCount(
                                                            );
                                                  }
                            }
                            resolved = true;
                            beingResolved = false;
    }
    public int getEndPtOfContours(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                             getCompositeCompEndPt(
                                               i);
                                           if (c !=
                                                 null) {
                                               org.apache.batik.svggen.font.table.GlyphDescription gd =
                                                 parentTable.
                                                 getDescription(
                                                   c.
                                                     getGlyphIndex(
                                                       ));
                                               return gd.
                                                 getEndPtOfContours(
                                                   i -
                                                     c.
                                                     getFirstContour(
                                                       )) +
                                                 c.
                                                 getFirstIndex(
                                                   );
                                           }
                                           return 0;
    }
    public byte getFlags(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                    getCompositeComp(
                                      i);
                                  if (c !=
                                        null) {
                                      org.apache.batik.svggen.font.table.GlyphDescription gd =
                                        parentTable.
                                        getDescription(
                                          c.
                                            getGlyphIndex(
                                              ));
                                      return gd.
                                        getFlags(
                                          i -
                                            c.
                                            getFirstIndex(
                                              ));
                                  }
                                  return 0;
    }
    public short getXCoordinate(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                           getCompositeComp(
                                             i);
                                         if (c !=
                                               null) {
                                             org.apache.batik.svggen.font.table.GlyphDescription gd =
                                               parentTable.
                                               getDescription(
                                                 c.
                                                   getGlyphIndex(
                                                     ));
                                             int n =
                                               i -
                                               c.
                                               getFirstIndex(
                                                 );
                                             int x =
                                               gd.
                                               getXCoordinate(
                                                 n);
                                             int y =
                                               gd.
                                               getYCoordinate(
                                                 n);
                                             short x1 =
                                               (short)
                                                 c.
                                                 scaleX(
                                                   x,
                                                   y);
                                             x1 +=
                                               c.
                                                 getXTranslate(
                                                   );
                                             return x1;
                                         }
                                         return 0;
    }
    public short getYCoordinate(int i) { org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                           getCompositeComp(
                                             i);
                                         if (c !=
                                               null) {
                                             org.apache.batik.svggen.font.table.GlyphDescription gd =
                                               parentTable.
                                               getDescription(
                                                 c.
                                                   getGlyphIndex(
                                                     ));
                                             int n =
                                               i -
                                               c.
                                               getFirstIndex(
                                                 );
                                             int x =
                                               gd.
                                               getXCoordinate(
                                                 n);
                                             int y =
                                               gd.
                                               getYCoordinate(
                                                 n);
                                             short y1 =
                                               (short)
                                                 c.
                                                 scaleY(
                                                   x,
                                                   y);
                                             y1 +=
                                               c.
                                                 getYTranslate(
                                                   );
                                             return y1;
                                         }
                                         return 0;
    }
    public boolean isComposite() { return true;
    }
    public int getPointCount() { if (!resolved)
                                     java.lang.System.
                                       err.
                                       println(
                                         "getPointCount called on unresolved GlyfCompositeDescript");
                                 org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                   (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                     components.
                                     get(
                                       components.
                                         size(
                                           ) -
                                         1);
                                 return c.
                                   getFirstIndex(
                                     ) +
                                   parentTable.
                                   getDescription(
                                     c.
                                       getGlyphIndex(
                                         )).
                                   getPointCount(
                                     ); }
    public int getContourCount() { if (!resolved)
                                       java.lang.System.
                                         err.
                                         println(
                                           "getContourCount called on unresolved GlyfCompositeDescript");
                                   org.apache.batik.svggen.font.table.GlyfCompositeComp c =
                                     (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                                       components.
                                       get(
                                         components.
                                           size(
                                             ) -
                                           1);
                                   return c.
                                     getFirstContour(
                                       ) +
                                     parentTable.
                                     getDescription(
                                       c.
                                         getGlyphIndex(
                                           )).
                                     getContourCount(
                                       );
    }
    public int getComponentIndex(int i) {
        return ((org.apache.batik.svggen.font.table.GlyfCompositeComp)
                  components.
                  get(
                    i)).
          getFirstIndex(
            );
    }
    public int getComponentCount() { return components.
                                       size(
                                         );
    }
    protected org.apache.batik.svggen.font.table.GlyfCompositeComp getCompositeComp(int i) {
        org.apache.batik.svggen.font.table.GlyfCompositeComp c;
        for (int n =
               0;
             n <
               components.
               size(
                 );
             n++) {
            c =
              (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                components.
                get(
                  n);
            org.apache.batik.svggen.font.table.GlyphDescription gd =
              parentTable.
              getDescription(
                c.
                  getGlyphIndex(
                    ));
            if (c.
                  getFirstIndex(
                    ) <=
                  i &&
                  i <
                  c.
                  getFirstIndex(
                    ) +
                  gd.
                  getPointCount(
                    )) {
                return c;
            }
        }
        return null;
    }
    protected org.apache.batik.svggen.font.table.GlyfCompositeComp getCompositeCompEndPt(int i) {
        org.apache.batik.svggen.font.table.GlyfCompositeComp c;
        for (int j =
               0;
             j <
               components.
               size(
                 );
             j++) {
            c =
              (org.apache.batik.svggen.font.table.GlyfCompositeComp)
                components.
                get(
                  j);
            org.apache.batik.svggen.font.table.GlyphDescription gd =
              parentTable.
              getDescription(
                c.
                  getGlyphIndex(
                    ));
            if (c.
                  getFirstContour(
                    ) <=
                  i &&
                  i <
                  c.
                  getFirstContour(
                    ) +
                  gd.
                  getContourCount(
                    )) {
                return c;
            }
        }
        return null;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "t89DF0XoinwQdi4lOymWpAhCregwFgWh6an602HTPkZ47ogcHz5LXCemPUtb" +
       "x9sLyBeti/ylM0xV7NOlwq8eLOKrZ5nqHFRm8LLL42V6tUjed0gMF/3Q2IKY" +
       "4oAZvgX+nQPP/ymeYrCiYB8B3IcfhCGPHcUhPti/LhXRieeCjTkCFn78BhZm" +
       "pLSM3Z6X//H89S9/bvfqK3u2WEsgOIEqNzoGvPEkUmweT95kAzwOEP988P7X" +
       "/vg/Lz90/mAV3nlabVduprbDdX/PyRW157XZnvyLtFkkvX3j9g0XxAeP5r2n" +
       "KH0WPE8dzPvUDcy1uKG57vBDLwZOpSolpmEM3b1WQWx+eJa4+SKbhYYD9pzt" +
       "QSQMv3jfV62f+tov7aPcsyvqTGP14y/98LeuffKl8yfOFu99Q3h/ss/+fFHK" +
       "eXcpbHbKQa4zS9mD+KNXX/wnP//ix/ZS3Xc6Uu6Dg+Av/f7//r1rn339S9cJ" +
       "wy6uPc9WJfeMjbj/Bxu978BG77uBjZQb2KjICofGuT08sEvx+0NnpFLfVKq9" +
       "1s4Bu99Wv9a6Vi1+W9ef95Yi+z1go4/KcyrooRmuZB8K8oBpy1cPF/ASnFsB" +
       "l1417daho18pHb1grWv7w94ZWYfftqzAxvccD0Z54Nz4I//lU7/3o+/9KrDX" +
       "GLptW/AkMOyJGadJcZT+u6985j13vvT6j5RxC1Dk8hO/2nq9GHV7M8RFUh5l" +
       "/EOoDxVQ2fJgQElRPClDDVU5QiuewPPhGAQs3ttAG9/78SESjTqH/6iahNdT" +
       "OWMcld7BZoxWEZmh1iyTuhzTkjtcDVD8xJwIoqF6LYUem0Zn0lIbft7GlFYS" +
       "mbHrVmuL4WZkLHES7/fH0ojU7T7Z6XqZyA113p6HKcmoFNMJuP6S1El/vmG7" +
       "fd7eaC24RbfiRtyKB2ultkADdCu6sIu6sFOHKxVeq5suOjL0XJkSNLFRDITx" +
       "avMNNm52lboeCaI4Ge1irrfyGvZc14ZUpta2QrfqZh3SkggvS7hF1/OrC9vp" +
       "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" +
       "PnEA7xPvPLw/vUndfyuSP4qhu4EBZx6g");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("M9xL3PgML33t7QIs7PfpA4CffucB/uVN6v6qSP57DF0GAA9o93oQ/8fbhfgY" +
       "eH7yAOJPfmdW4rlbb4zz3IWi8FsgSitxHlwyGLmKmp1Geg56J5D+9AHSn37H" +
       "jXnuyk3q7iuSO8+AvI45z931NkAW+KAqeD5/APLzbxWk8O2Z8+GbIH2kSB6I" +
       "oSuHSAveKTJl6/tjCHmrdyiPOpcKevDtKggFz6sHCnr1O6SgZ26ioGeL5MkY" +
       "uv+sgsoQq6h87BjtU28FbQYGve7t0+Iq3YNvuAm/v70t//LLl29/4GXu35QX" +
       "MI9uWN9BQbdriW2fvJ90In/BD1XNKJVxx/62UnnaOteIoSfe3L4gnogP792d" +
       "q+97NmPo4Zv1BOFX8edkl3YMPXCDLsUNiTJzsv0HgFeebQ9EKf+ebPd9MXTp" +
       "uB0Yap852aQLQmjQpMjiR54Nf5uefWiWbB+aP3jSWUtOv+/NrH7iUPneU0fB" +
       "8n9FHB7bktnBZaxXXx5Pf+AbzZ/d31WVbWm3K0a5nYIu7q/NloMWR7/Hbzja" +
       "4VgXhk9/855fuePJw2PqPXuBjxfOCdkevf7F0L7jx+VVzt1vPPAPPvBzL/9B" +
       "eRfk/wLb4eRUrjIAAA==");
}
