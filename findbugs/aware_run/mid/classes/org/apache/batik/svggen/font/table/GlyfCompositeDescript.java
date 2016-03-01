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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+p0H+Ge3qPvzIvnvCXQFADyk3RtB/B9v");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("F+Lj4PnJQ4g/+b1ZieduvznOcxeKwu+AKK3EeXhRgPY0Pbse6TnonUD604dI" +
       "f/odN+a5q7eou79I7joD8gbmPHf32wBZ4IOq4PnCIcgvvFWQi+/OnI/cAumj" +
       "RfJgAl09QlrwTpEpWz+QQPW3eg/yuHOpoIferoIa4HntUEGvfY8U9OwtFPRc" +
       "kTyVQA+cVVAZYhWVj5+gffqtoM3AoDe8QVpch3voDTfd97ez1V985cqlB18R" +
       "/015ifL4BvWdQ+iSsXGc03eMTuUvBJFu2KUy7tzfOCpPW+fQBHryze0L4onk" +
       "6O7cudq+ZzOBHrlVTxB+FX9Od2kn0IM36VLccigzp9t/AHjl2fZAlPLv6XY/" +
       "nECXT9qBofaZ001wEEKDJkWWOPZs+Lv07COzZPvQ/KHTzlpy+v1vZvVTh8r3" +
       "XncULP/Xw9GxbcMfXqh67RVm9CPfav7M/r6p6sh5XoxyaQhd3F99LQctjn5P" +
       "3HS0o7EuUM98+95fuvOpo2PqvXuBTxbOKdkeu/HlTtINkvI6Zv6rD/6DD/zs" +
       "K79b3uf4vwTM7P+OMgAA");
}
