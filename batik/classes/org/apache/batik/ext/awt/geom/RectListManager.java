package org.apache.batik.ext.awt.geom;
public class RectListManager implements java.util.Collection {
    java.awt.Rectangle[] rects = null;
    int size = 0;
    java.awt.Rectangle bounds = null;
    public void dump() { java.lang.System.err.println("RLM: " + this + " Sz: " +
                                                      size);
                         java.lang.System.err.println("Bounds: " + getBounds(
                                                                     ));
                         for (int i = 0; i < size; i++) { java.awt.Rectangle r =
                                                            rects[i];
                                                          java.lang.System.
                                                            err.println("  [" +
                                                                        r.
                                                                          x +
                                                                        ", " +
                                                                        r.
                                                                          y +
                                                                        ", " +
                                                                        r.
                                                                          width +
                                                                        ", " +
                                                                        r.
                                                                          height +
                                                                        ']');
                         } }
    public static java.util.Comparator comparator = new org.apache.batik.ext.awt.geom.RectListManager.RectXComparator(
      );
    public RectListManager(java.util.Collection rects) {
        super(
          );
        this.
          rects =
          (new java.awt.Rectangle[rects.
                                    size(
                                      )]);
        java.util.Iterator i =
          rects.
          iterator(
            );
        int j =
          0;
        while (i.
                 hasNext(
                   ))
            this.
              rects[j++] =
              (java.awt.Rectangle)
                i.
                next(
                  );
        this.
          size =
          this.
            rects.
            length;
        java.util.Arrays.
          sort(
            this.
              rects,
            comparator);
    }
    public RectListManager(java.awt.Rectangle[] rects) {
        this(
          rects,
          0,
          rects.
            length);
    }
    public RectListManager(java.awt.Rectangle[] rects,
                           int off,
                           int sz) { super();
                                     this.size = sz;
                                     this.rects =
                                       (new java.awt.Rectangle[sz]);
                                     java.lang.System.
                                       arraycopy(
                                         rects,
                                         off,
                                         this.
                                           rects,
                                         0,
                                         sz);
                                     java.util.Arrays.
                                       sort(
                                         this.
                                           rects,
                                         comparator);
    }
    public RectListManager(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        this(
          rlm.
            rects);
    }
    public RectListManager(java.awt.Rectangle rect) {
        this(
          );
        add(
          rect);
    }
    public RectListManager() { super();
                               this.rects = (new java.awt.Rectangle[10]);
                               size = 0; }
    public RectListManager(int capacity) { super(
                                             );
                                           this.rects =
                                             (new java.awt.Rectangle[capacity]);
    }
    public java.awt.Rectangle getBounds() { if (bounds !=
                                                  null)
                                                return bounds;
                                            if (size ==
                                                  0)
                                                return null;
                                            bounds =
                                              new java.awt.Rectangle(
                                                rects[0]);
                                            for (int i =
                                                   1;
                                                 i <
                                                   size;
                                                 i++) {
                                                java.awt.Rectangle r =
                                                  rects[i];
                                                if (r.
                                                      x <
                                                      bounds.
                                                        x) {
                                                    bounds.
                                                      width =
                                                      bounds.
                                                        x +
                                                        bounds.
                                                          width -
                                                        r.
                                                          x;
                                                    bounds.
                                                      x =
                                                      r.
                                                        x;
                                                }
                                                if (r.
                                                      y <
                                                      bounds.
                                                        y) {
                                                    bounds.
                                                      height =
                                                      bounds.
                                                        y +
                                                        bounds.
                                                          height -
                                                        r.
                                                          y;
                                                    bounds.
                                                      y =
                                                      r.
                                                        y;
                                                }
                                                if (r.
                                                      x +
                                                      r.
                                                        width >
                                                      bounds.
                                                        x +
                                                      bounds.
                                                        width)
                                                    bounds.
                                                      width =
                                                      r.
                                                        x +
                                                        r.
                                                          width -
                                                        bounds.
                                                          x;
                                                if (r.
                                                      y +
                                                      r.
                                                        height >
                                                      bounds.
                                                        y +
                                                      bounds.
                                                        height)
                                                    bounds.
                                                      height =
                                                      r.
                                                        y +
                                                        r.
                                                          height -
                                                        bounds.
                                                          y;
                                            }
                                            return bounds;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        return copy1(
                 );
    }
    public org.apache.batik.ext.awt.geom.RectListManager copy1() {
        return new org.apache.batik.ext.awt.geom.RectListManager(
          rects);
    }
    public int size() { return size; }
    public boolean isEmpty() { return size ==
                                 0; }
    public void clear() { java.util.Arrays.
                            fill(
                              rects,
                              null);
                          size = 0;
                          bounds = null; }
    public java.util.Iterator iterator() {
        return new org.apache.batik.ext.awt.geom.RectListManager.RLMIterator(
          );
    }
    public java.util.ListIterator listIterator() {
        return new org.apache.batik.ext.awt.geom.RectListManager.RLMIterator(
          );
    }
    public java.lang.Object[] toArray() {
        java.lang.Object[] ret =
          new java.awt.Rectangle[size];
        java.lang.System.
          arraycopy(
            rects,
            0,
            ret,
            0,
            size);
        return ret;
    }
    public java.lang.Object[] toArray(java.lang.Object[] a) {
        java.lang.Class t =
          a.
          getClass(
            ).
          getComponentType(
            );
        if (t !=
              java.lang.Object.class &&
              t !=
              java.awt.Rectangle.class) {
            java.util.Arrays.
              fill(
                a,
                null);
            return a;
        }
        if (a.
              length <
              size)
            a =
              (new java.awt.Rectangle[size]);
        java.lang.System.
          arraycopy(
            rects,
            0,
            a,
            0,
            size);
        java.util.Arrays.
          fill(
            a,
            size,
            a.
              length,
            null);
        return a;
    }
    public boolean add(java.lang.Object o) {
        add(
          (java.awt.Rectangle)
            o);
        return true;
    }
    public void add(java.awt.Rectangle rect) {
        add(
          rect,
          0,
          size -
            1);
    }
    protected void add(java.awt.Rectangle rect,
                       int l,
                       int r) { ensureCapacity(
                                  size +
                                    1);
                                int idx =
                                  l;
                                while (l <=
                                         r) {
                                    idx =
                                      (l +
                                         r) /
                                        2;
                                    while (rects[idx] ==
                                             null &&
                                             idx <
                                             r)
                                        idx++;
                                    if (rects[idx] ==
                                          null) {
                                        r =
                                          (l +
                                             r) /
                                            2;
                                        idx =
                                          (l +
                                             r) /
                                            2;
                                        if (l >
                                              r)
                                            idx =
                                              l;
                                        while (rects[idx] ==
                                                 null &&
                                                 idx >
                                                 l)
                                            idx--;
                                        if (rects[idx] ==
                                              null) {
                                            rects[idx] =
                                              rect;
                                            return;
                                        }
                                    }
                                    if (rect.
                                          x ==
                                          rects[idx].
                                            x)
                                        break;
                                    if (rect.
                                          x <
                                          rects[idx].
                                            x) {
                                        if (idx ==
                                              0)
                                            break;
                                        if (rects[idx -
                                                    1] !=
                                              null &&
                                              rect.
                                                x >=
                                              rects[idx -
                                                      1].
                                                x)
                                            break;
                                        r =
                                          idx -
                                            1;
                                    }
                                    else {
                                        if (idx ==
                                              size -
                                              1) {
                                            idx++;
                                            break;
                                        }
                                        if (rects[idx +
                                                    1] !=
                                              null &&
                                              rect.
                                                x <=
                                              rects[idx +
                                                      1].
                                                x) {
                                            idx++;
                                            break;
                                        }
                                        l =
                                          idx +
                                            1;
                                    }
                                }
                                if (idx <
                                      size) {
                                    java.lang.System.
                                      arraycopy(
                                        rects,
                                        idx,
                                        rects,
                                        idx +
                                          1,
                                        size -
                                          idx);
                                }
                                rects[idx] =
                                  rect;
                                size++;
                                bounds = null;
    }
    public boolean addAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager) {
            add(
              (org.apache.batik.ext.awt.geom.RectListManager)
                c);
        }
        else {
            add(
              new org.apache.batik.ext.awt.geom.RectListManager(
                c));
        }
        return c.
          size(
            ) !=
          0;
    }
    public boolean contains(java.lang.Object o) {
        java.awt.Rectangle rect =
          (java.awt.Rectangle)
            o;
        int l =
          0;
        int r =
          size -
          1;
        int idx =
          0;
        while (l <=
                 r) {
            idx =
              l +
                r >>>
                1;
            if (rect.
                  x ==
                  rects[idx].
                    x)
                break;
            if (rect.
                  x <
                  rects[idx].
                    x) {
                if (idx ==
                      0)
                    break;
                if (rect.
                      x >=
                      rects[idx -
                              1].
                        x)
                    break;
                r =
                  idx -
                    1;
            }
            else {
                if (idx ==
                      size -
                      1) {
                    idx++;
                    break;
                }
                if (rect.
                      x <=
                      rects[idx +
                              1].
                        x) {
                    idx++;
                    break;
                }
                l =
                  idx +
                    1;
            }
        }
        if (rects[idx].
              x !=
              rect.
                x)
            return false;
        for (int i =
               idx;
             i >=
               0;
             i--) {
            if (rects[idx].
                  equals(
                    rect))
                return true;
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        for (int i =
               idx +
               1;
             i <
               size;
             i++) {
            if (rects[idx].
                  equals(
                    rect))
                return true;
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        return false;
    }
    public boolean containsAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return containsAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return containsAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean containsAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        for (int j =
               0,
               i =
                 0;
             j <
               rlm.
                 size;
             j++) {
            i =
              xChange;
            while (rects[i].
                     x <
                     rlm.
                       rects[j].
                       x) {
                i++;
                if (i ==
                      size)
                    return false;
            }
            xChange =
              i;
            x =
              rects[i].
                x;
            while (!rlm.
                      rects[j].
                     equals(
                       rects[i])) {
                i++;
                if (i ==
                      size)
                    return false;
                if (x !=
                      rects[i].
                        x)
                    return false;
            }
        }
        return true;
    }
    public boolean remove(java.lang.Object o) {
        return remove(
                 (java.awt.Rectangle)
                   o);
    }
    public boolean remove(java.awt.Rectangle rect) {
        int l =
          0;
        int r =
          size -
          1;
        int idx =
          0;
        while (l <=
                 r) {
            idx =
              l +
                r >>>
                1;
            if (rect.
                  x ==
                  rects[idx].
                    x)
                break;
            if (rect.
                  x <
                  rects[idx].
                    x) {
                if (idx ==
                      0)
                    break;
                if (rect.
                      x >=
                      rects[idx -
                              1].
                        x)
                    break;
                r =
                  idx -
                    1;
            }
            else {
                if (idx ==
                      size -
                      1) {
                    idx++;
                    break;
                }
                if (rect.
                      x <=
                      rects[idx +
                              1].
                        x) {
                    idx++;
                    break;
                }
                l =
                  idx +
                    1;
            }
        }
        if (rects[idx].
              x !=
              rect.
                x)
            return false;
        for (int i =
               idx;
             i >=
               0;
             i--) {
            if (rects[idx].
                  equals(
                    rect)) {
                java.lang.System.
                  arraycopy(
                    rects,
                    idx +
                      1,
                    rects,
                    idx,
                    size -
                      idx);
                size--;
                bounds =
                  null;
                return true;
            }
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        for (int i =
               idx +
               1;
             i <
               size;
             i++) {
            if (rects[idx].
                  equals(
                    rect)) {
                java.lang.System.
                  arraycopy(
                    rects,
                    idx +
                      1,
                    rects,
                    idx,
                    size -
                      idx);
                size--;
                bounds =
                  null;
                return true;
            }
            if (rects[idx].
                  x !=
                  rect.
                    x)
                break;
        }
        return false;
    }
    public boolean removeAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return removeAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return removeAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean removeAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        boolean ret =
          false;
        for (int j =
               0,
               i =
                 0;
             j <
               rlm.
                 size;
             j++) {
            i =
              xChange;
            while (rects[i] ==
                     null ||
                     rects[i].
                       x <
                     rlm.
                       rects[j].
                       x) {
                i++;
                if (i ==
                      size)
                    break;
            }
            if (i ==
                  size)
                break;
            xChange =
              i;
            x =
              rects[i].
                x;
            while (true) {
                if (rects[i] ==
                      null) {
                    i++;
                    if (i ==
                          size)
                        break;
                    continue;
                }
                if (rlm.
                      rects[j].
                      equals(
                        rects[i])) {
                    rects[i] =
                      null;
                    ret =
                      true;
                }
                i++;
                if (i ==
                      size)
                    break;
                if (x !=
                      rects[i].
                        x)
                    break;
            }
        }
        if (ret) {
            int j =
              0;
            int i =
              0;
            while (i <
                     size) {
                if (rects[i] !=
                      null)
                    rects[j++] =
                      rects[i];
                i++;
            }
            size =
              j;
            bounds =
              null;
        }
        return ret;
    }
    public boolean retainAll(java.util.Collection c) {
        if (c instanceof org.apache.batik.ext.awt.geom.RectListManager)
            return retainAll(
                     (org.apache.batik.ext.awt.geom.RectListManager)
                       c);
        return retainAll(
                 new org.apache.batik.ext.awt.geom.RectListManager(
                   c));
    }
    public boolean retainAll(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        int x;
        int xChange =
          0;
        boolean ret =
          false;
        for (int j =
               0,
               i =
                 0;
             j <
               size;
             j++) {
            i =
              xChange;
            while (rlm.
                     rects[i].
                     x <
                     rects[j].
                       x) {
                i++;
                if (i ==
                      rlm.
                        size)
                    break;
            }
            if (i ==
                  rlm.
                    size) {
                ret =
                  true;
                for (int k =
                       j;
                     k <
                       size;
                     k++)
                    rects[k] =
                      null;
                size =
                  j;
                break;
            }
            xChange =
              i;
            x =
              rlm.
                rects[i].
                x;
            while (true) {
                if (rects[j].
                      equals(
                        rlm.
                          rects[i]))
                    break;
                i++;
                if (i ==
                      rlm.
                        size ||
                      x !=
                      rlm.
                        rects[i].
                        x) {
                    rects[j] =
                      null;
                    ret =
                      true;
                    break;
                }
            }
        }
        if (ret) {
            int j =
              0;
            int i =
              0;
            while (i <
                     size) {
                if (rects[i] !=
                      null)
                    rects[j++] =
                      rects[i];
                i++;
            }
            size =
              j;
            bounds =
              null;
        }
        return ret;
    }
    public void add(org.apache.batik.ext.awt.geom.RectListManager rlm) {
        if (rlm.
              size ==
              0)
            return;
        java.awt.Rectangle[] dst =
          rects;
        if (rects.
              length <
              size +
              rlm.
                size) {
            dst =
              (new java.awt.Rectangle[size +
                                        rlm.
                                          size]);
        }
        if (size ==
              0) {
            java.lang.System.
              arraycopy(
                rlm.
                  rects,
                0,
                dst,
                size,
                rlm.
                  size);
            size =
              rlm.
                size;
            bounds =
              null;
            return;
        }
        java.awt.Rectangle[] src1 =
          rlm.
            rects;
        int src1Sz =
          rlm.
            size;
        int src1I =
          src1Sz -
          1;
        java.awt.Rectangle[] src2 =
          rects;
        int src2Sz =
          size;
        int src2I =
          src2Sz -
          1;
        int dstI =
          size +
          rlm.
            size -
          1;
        int x1 =
          src1[src1I].
            x;
        int x2 =
          src2[src2I].
            x;
        while (dstI >=
                 0) {
            if (x1 <=
                  x2) {
                dst[dstI] =
                  src2[src2I];
                if (src2I ==
                      0) {
                    java.lang.System.
                      arraycopy(
                        src1,
                        0,
                        dst,
                        0,
                        src1I +
                          1);
                    break;
                }
                src2I--;
                x2 =
                  src2[src2I].
                    x;
            }
            else {
                dst[dstI] =
                  src1[src1I];
                if (src1I ==
                      0) {
                    java.lang.System.
                      arraycopy(
                        src2,
                        0,
                        dst,
                        0,
                        src2I +
                          1);
                    break;
                }
                src1I--;
                x1 =
                  src1[src1I].
                    x;
            }
            dstI--;
        }
        rects =
          dst;
        size +=
          rlm.
            size;
        bounds =
          null;
    }
    public void mergeRects(int overhead, int lineOverhead) {
        if (size ==
              0)
            return;
        java.awt.Rectangle r;
        java.awt.Rectangle cr;
        java.awt.Rectangle mr;
        int cost1;
        int cost2;
        int cost3;
        mr =
          new java.awt.Rectangle(
            );
        java.awt.Rectangle[] splits =
          new java.awt.Rectangle[4];
        for (int j,
               i =
                 0;
             i <
               size;
             i++) {
            r =
              rects[i];
            if (r ==
                  null)
                continue;
            cost1 =
              overhead +
                r.
                  height *
                lineOverhead +
                r.
                  height *
                r.
                  width;
            do  {
                int maxX =
                  r.
                    x +
                  r.
                    width +
                  overhead /
                  r.
                    height;
                for (j =
                       i +
                         1;
                     j <
                       size;
                     j++) {
                    cr =
                      rects[j];
                    if (cr ==
                          null ||
                          cr ==
                          r)
                        continue;
                    if (cr.
                          x >=
                          maxX) {
                        j =
                          size;
                        break;
                    }
                    cost2 =
                      overhead +
                        cr.
                          height *
                        lineOverhead +
                        cr.
                          height *
                        cr.
                          width;
                    mr =
                      r.
                        union(
                          cr);
                    cost3 =
                      overhead +
                        mr.
                          height *
                        lineOverhead +
                        mr.
                          height *
                        mr.
                          width;
                    if (cost3 <=
                          cost1 +
                          cost2) {
                        r =
                          (rects[i] =
                             mr);
                        rects[j] =
                          null;
                        cost1 =
                          cost3;
                        j =
                          -1;
                        break;
                    }
                    if (!r.
                          intersects(
                            cr))
                        continue;
                    splitRect(
                      cr,
                      r,
                      splits);
                    int splitCost =
                      0;
                    int l =
                      0;
                    for (int k =
                           0;
                         k <
                           4;
                         k++) {
                        if (splits[k] !=
                              null) {
                            java.awt.Rectangle sr =
                              splits[k];
                            if (k <
                                  3)
                                splits[l++] =
                                  sr;
                            splitCost +=
                              overhead +
                                sr.
                                  height *
                                lineOverhead +
                                sr.
                                  height *
                                sr.
                                  width;
                        }
                    }
                    if (splitCost >=
                          cost2)
                        continue;
                    if (l ==
                          0) {
                        rects[j] =
                          null;
                        if (splits[3] !=
                              null)
                            add(
                              splits[3],
                              j,
                              size -
                                1);
                        continue;
                    }
                    rects[j] =
                      splits[0];
                    if (l >
                          1)
                        insertRects(
                          splits,
                          1,
                          j +
                            1,
                          l -
                            1);
                    if (splits[3] !=
                          null)
                        add(
                          splits[3],
                          j,
                          size -
                            1);
                }
            }while(j !=
                     size); 
        }
        int j =
          0;
        int i =
          0;
        float area =
          0;
        while (i <
                 size) {
            if (rects[i] !=
                  null) {
                r =
                  rects[i];
                rects[j++] =
                  r;
                area +=
                  overhead +
                    r.
                      height *
                    lineOverhead +
                    r.
                      height *
                    r.
                      width;
            }
            i++;
        }
        size =
          j;
        bounds =
          null;
        r =
          getBounds(
            );
        if (r ==
              null)
            return;
        if (overhead +
              r.
                height *
              lineOverhead +
              r.
                height *
              r.
                width <
              area) {
            rects[0] =
              r;
            size =
              1;
        }
    }
    public void subtract(org.apache.batik.ext.awt.geom.RectListManager rlm,
                         int overhead,
                         int lineOverhead) {
        java.awt.Rectangle r;
        java.awt.Rectangle sr;
        int cost;
        int jMin =
          0;
        java.awt.Rectangle[] splits =
          new java.awt.Rectangle[4];
        for (int i =
               0;
             i <
               size;
             i++) {
            r =
              rects[i];
            cost =
              overhead +
                r.
                  height *
                lineOverhead +
                r.
                  height *
                r.
                  width;
            for (int j =
                   jMin;
                 j <
                   rlm.
                     size;
                 j++) {
                sr =
                  rlm.
                    rects[j];
                if (sr.
                      x +
                      sr.
                        width <
                      r.
                        x) {
                    if (j ==
                          jMin)
                        jMin++;
                    continue;
                }
                if (sr.
                      x >
                      r.
                        x +
                      r.
                        width)
                    break;
                if (!r.
                      intersects(
                        sr))
                    continue;
                splitRect(
                  r,
                  sr,
                  splits);
                int splitCost =
                  0;
                java.awt.Rectangle tmpR;
                for (int k =
                       0;
                     k <
                       4;
                     k++) {
                    tmpR =
                      splits[k];
                    if (tmpR !=
                          null)
                        splitCost +=
                          overhead +
                            tmpR.
                              height *
                            lineOverhead +
                            tmpR.
                              height *
                            tmpR.
                              width;
                }
                if (splitCost >=
                      cost)
                    continue;
                int l =
                  0;
                for (int k =
                       0;
                     k <
                       3;
                     k++) {
                    if (splits[k] !=
                          null)
                        splits[l++] =
                          splits[k];
                }
                if (l ==
                      0) {
                    rects[i].
                      width =
                      0;
                    if (splits[3] !=
                          null)
                        add(
                          splits[3],
                          i,
                          size -
                            1);
                    break;
                }
                r =
                  splits[0];
                rects[i] =
                  r;
                cost =
                  overhead +
                    r.
                      height *
                    lineOverhead +
                    r.
                      height *
                    r.
                      width;
                if (l >
                      1)
                    insertRects(
                      splits,
                      1,
                      i +
                        1,
                      l -
                        1);
                if (splits[3] !=
                      null)
                    add(
                      splits[3],
                      i +
                        l,
                      size -
                        1);
            }
        }
        int j =
          0;
        int i =
          0;
        while (i <
                 size) {
            if (rects[i].
                  width ==
                  0)
                rects[i] =
                  null;
            else
                rects[j++] =
                  rects[i];
            i++;
        }
        size =
          j;
        bounds =
          null;
    }
    protected void splitRect(java.awt.Rectangle r,
                             java.awt.Rectangle sr,
                             java.awt.Rectangle[] splits) {
        int rx0 =
          r.
            x;
        int rx1 =
          rx0 +
          r.
            width -
          1;
        int ry0 =
          r.
            y;
        int ry1 =
          ry0 +
          r.
            height -
          1;
        int srx0 =
          sr.
            x;
        int srx1 =
          srx0 +
          sr.
            width -
          1;
        int sry0 =
          sr.
            y;
        int sry1 =
          sry0 +
          sr.
            height -
          1;
        if (ry0 <
              sry0 &&
              ry1 >=
              sry0) {
            splits[0] =
              new java.awt.Rectangle(
                rx0,
                ry0,
                r.
                  width,
                sry0 -
                  ry0);
            ry0 =
              sry0;
        }
        else {
            splits[0] =
              null;
        }
        if (ry0 <=
              sry1 &&
              ry1 >
              sry1) {
            splits[1] =
              new java.awt.Rectangle(
                rx0,
                sry1 +
                  1,
                r.
                  width,
                ry1 -
                  sry1);
            ry1 =
              sry1;
        }
        else {
            splits[1] =
              null;
        }
        if (rx0 <
              srx0 &&
              rx1 >=
              srx0) {
            splits[2] =
              new java.awt.Rectangle(
                rx0,
                ry0,
                srx0 -
                  rx0,
                ry1 -
                  ry0 +
                  1);
        }
        else {
            splits[2] =
              null;
        }
        if (rx0 <=
              srx1 &&
              rx1 >
              srx1) {
            splits[3] =
              new java.awt.Rectangle(
                srx1 +
                  1,
                ry0,
                rx1 -
                  srx1,
                ry1 -
                  ry0 +
                  1);
        }
        else {
            splits[3] =
              null;
        }
    }
    protected void insertRects(java.awt.Rectangle[] rects,
                               int srcPos,
                               int dstPos,
                               int len) {
        if (len ==
              0)
            return;
        ensureCapacity(
          size +
            len);
        for (int i =
               size -
               1;
             i >=
               dstPos;
             i--)
            this.
              rects[i +
                      len] =
              this.
                rects[i];
        java.lang.System.
          arraycopy(
            rects,
            srcPos,
            this.
              rects,
            dstPos,
            len);
        size +=
          len;
    }
    public void ensureCapacity(int sz) { if (sz <=
                                               rects.
                                                 length)
                                             return;
                                         int nSz =
                                           rects.
                                             length +
                                           (rects.
                                              length >>
                                              1) +
                                           1;
                                         while (nSz <
                                                  sz)
                                             nSz +=
                                               (nSz >>
                                                  1) +
                                                 1;
                                         java.awt.Rectangle[] nRects =
                                           new java.awt.Rectangle[nSz];
                                         java.lang.System.
                                           arraycopy(
                                             rects,
                                             0,
                                             nRects,
                                             0,
                                             size);
                                         rects =
                                           nRects;
    }
    private static class RectXComparator implements java.util.Comparator, java.io.Serializable {
        RectXComparator() { super(); }
        public final int compare(java.lang.Object o1,
                                 java.lang.Object o2) {
            return ((java.awt.Rectangle)
                      o1).
                     x -
              ((java.awt.Rectangle)
                 o2).
                x;
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
          ("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" +
           "fj0v6f4vD+yyXE0iAAA=");
    }
    private class RLMIterator implements java.util.ListIterator {
        int idx = 0;
        boolean removeOk = false;
        boolean forward = true;
        RLMIterator() { super(); }
        public boolean hasNext() { return idx <
                                     size;
        }
        public int nextIndex() { return idx;
        }
        public java.lang.Object next() { if (idx >=
                                               size)
                                             throw new java.util.NoSuchElementException(
                                               "No Next Element");
                                         forward =
                                           true;
                                         removeOk =
                                           true;
                                         return rects[idx++];
        }
        public boolean hasPrevious() { return idx >
                                         0;
        }
        public int previousIndex() { return idx -
                                       1;
        }
        public java.lang.Object previous() {
            if (idx <=
                  0)
                throw new java.util.NoSuchElementException(
                  "No Previous Element");
            forward =
              false;
            removeOk =
              true;
            return rects[--idx];
        }
        public void remove() { if (!removeOk)
                                   throw new java.lang.IllegalStateException(
                                     "remove can only be called directly after next/previous");
                               if (forward)
                                   idx--;
                               if (idx !=
                                     size -
                                     1) java.lang.System.
                                          arraycopy(
                                            rects,
                                            idx +
                                              1,
                                            rects,
                                            idx,
                                            size -
                                              (idx +
                                                 1));
                               size--;
                               rects[size] =
                                 null;
                               removeOk =
                                 false; }
        public void set(java.lang.Object o) {
            java.awt.Rectangle r =
              (java.awt.Rectangle)
                o;
            if (!removeOk)
                throw new java.lang.IllegalStateException(
                  "set can only be called directly after next/previous");
            if (forward)
                idx--;
            if (idx +
                  1 <
                  size) {
                if (rects[idx +
                            1].
                      x <
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            if (idx >=
                  0) {
                if (rects[idx -
                            1].
                      x >
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            rects[idx] =
              r;
            removeOk =
              false;
        }
        public void add(java.lang.Object o) {
            java.awt.Rectangle r =
              (java.awt.Rectangle)
                o;
            if (idx <
                  size) {
                if (rects[idx].
                      x <
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            if (idx !=
                  0) {
                if (rects[idx -
                            1].
                      x >
                      r.
                        x)
                    throw new java.lang.UnsupportedOperationException(
                      "RectListManager entries must be sorted");
            }
            ensureCapacity(
              size +
                1);
            if (idx !=
                  size)
                java.lang.System.
                  arraycopy(
                    rects,
                    idx,
                    rects,
                    idx +
                      1,
                    size -
                      idx);
            rects[idx] =
              r;
            idx++;
            removeOk =
              false;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "L9xJcATsIwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "ikCfumVrh21dJJ/59v2/dNd7D0Pl+/cK");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "H8+GE7q9++Y3qAa2F5Z3nvJfe+TT3/3Jl/6wPID+P305YZO5LQAA";
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "lhQbfKqvzWWK+Bd54Vf5Iz6d/z+5e0uiPUcAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18C7Dr6F2fz9n3brJ7s3nsssluXruQjZMr25ItmyUE23pY" +
       "smTLlp+CsNHTkvW0HpYs8oAwdPOYpCnZQNIh2840PJpZEmCaUoYJSYcGwpBm" +
       "mjRtoTMQ0hfQNDOEDoQSCv0k+1yfe+653lzuSc8c/S3re/1//9f3/6TPevbr" +
       "hdsCv1D0XGuzsNzwspqEl5dW9XK48dTgMs1UOdEPVKVtiUEwAteelF/1S/f9" +
       "5bfer186LtwuFF4oOo4biqHhOsFQDVxrrSpM4b79VdxS7SAsXGKW4lqEotCw" +
       "IMYIwieYwj2nmoaFR5kTFiDAAgRYgHIWoOa+Fmj0fNWJ7HbWQnTCYFV4W+GI" +
       "KdzuyRl7YeGVV3fiib5o77rhcgSghzuz7xMAKm+c+IVXXMG+xXwN4A8Woad/" +
       "+ocv/cothfuEwn2Gw2fsyICJEAwiFJ5nq7ak+kFTUVRFKLzAUVWFV31DtIw0" +
       "51so3B8YC0cMI1+9IqTsYuSpfj7mXnLPkzNsfiSHrn8FnmaolnLy7TbNEhcA" +
       "60v2WLcIiew6AHi3ARjzNVFWT5rcahqOEhZefrbFFYyPdkEF0PQOWw1198pQ" +
       "tzoiuFC4f6s7S3QWEB/6hrMAVW9zIzBKWHjoup1msvZE2RQX6pNh4cGz9bht" +
       "Eah1Vy6IrElYePHZanlPQEsPndHSKf18vfd97/sRp+Mc5zwrqmxl/N8JGj1y" +
       "ptFQ1VRfdWR12/B5r2V+SnzJp955XCiAyi8+U3lb51ff8o0feN0jn/ncts5L" +
       "z6nTl5aqHD4pf1S694svaz/euCVj407PDYxM+Vchz82f25U8kXjA815ypces" +
       "8PJJ4WeGvzX/0Y+pXzsu3E0VbpddK7KBHb1Adm3PsFSfVB3VF0NVoQp3qY7S" +
       "zsupwh3gnDEcdXu1r2mBGlKFW6380u1u/h2ISANdZCK6A5wbjuaenHtiqOfn" +
       "iVcoFO4AR6ECjscL27/8Myy8GdJdW4VEWXQMx4U4383wB5DqhBKQrQ5JwOpN" +
       "KHAjH5gg5PoLSAR2oKu7gswzxTiEFqprQ0PQNIsHrOgAY/AvZ5bm/X8YI8lw" +
       "XoqPjoAKXnY2AFjAdzqupaj+k/LTUQv/xsef/N3jKw6xk1BYeD0Y9vJ22Mv5" +
       "sHnwBMNezoa9fGbYwtFRPtqLsuG3ygaqMoHTgzrPe5x/E/3md77qFmBlXnxr" +
       "Jn1QFbp+VG7vwwSVB0MZ2GrhMx+Kf2zy9tJx4fjq8JqxDC7dnTXnsqB4Jfg9" +
       "etatzuv3vqf+5C8/8VNvdfcOdlW83vn9tS0zv33VWeH6rqwqIBLuu3/tK8RP" +
       "Pvmptz56XLgVBAMQAEMRGCyILY+cHeMq/33iJBZmWG4DgDXXt0UrKzoJYHeH" +
       "uu/G+yu51u/Nz18AZHxPZtAPgaO9s/D8Myt9oZfRF22tJFPaGRR5rH0D733k" +
       "977wp3Au7pOwfN+piY5XwydOhYKss/typ3/B3gZGvqqCen/wIe4DH/z6Uz+Y" +
       "GwCo8erzBnw0o20QAoAKgZh/4nOr3//KH370y8dXjOYoBHNhJFmGnFwBmV0v" +
       "3H0AJBjtu/f8gFBiAcPNrObRsWO7iqEZomSpmZX+zX2PlT/5v953aWsHFrhy" +
       "Ykave+4O9te/q1X40d/94W8+kndzJGdT2V5m+2rb+PjCfc9N3xc3GR/Jj33p" +
       "4Q//tvgREGlBdAuMVM0D1tFWBqDRK6/jOEMxzueNJ+VfG/zRFz+SfuLZLRRJ" +
       "BIGxULxeCnJtFpRZ9mMHvHM/Of0F+b2f+dP/OnlTpqRMWvdcUcxLMz08dsj6" +
       "8qovDk+HjL14srJq3iWU13ttTi9nfeRy2A5Xz8jLg9OOfjW3p9KrJ+X3f/nP" +
       "nj/5s9/4Ri6Vq/Oz03bNit4TW1fKyCsS0P0DZ6NaRwx0UA/5TO+HLlmf+Rbo" +
       "UQA9yiBaB30fRNbkKi/Y1b7tjv/8r3/zJW/+4i2FY6Jwt+WKCiHmAaVwF/Bk" +
       "NdBBUE68N/7AVl7xnYBcyqEWrgGfX3joWlcf74Q9Pt/VM/rKjDx2rQNdr+kZ" +
       "8e/N8ICF5La8tZBnfu7VX3j7M6/+ai6iO40A5KZNf3FOynOqzZ89+5Wvfen5" +
       "D388D5m5+Waj3302V7w2Fbwqw8sxP8+7Ymf35wrJJrBs7gLpnqWeg+rx66Mi" +
       "ssH3gf3Bv+5b0jv+y19dY075fHROfnamvQA9+zMPtb//a3n7/cSQtX4kuXbe" +
       "BoLbt618zP6L41fd/tnjwh1C4ZK8WzFMRCvKwq0ARBOcLCPAquKq8qsz3m16" +
       "98SVie9lZyelU8OenZL2+QI4z2rnWtq6jpccFXL7GWyNLqePZuR7clEfZ6ev" +
       "CUGHhiNau3j+d+DvCBx/mx2ZGWYXtmnZ/e1dbviKK8mhB5KU2y3VWYT6Yb1x" +
       "vmGDKWq9y4uht97/FfNn/uQXtznvWSWdqay+8+l3/93l9z19fGql8eprkv3T" +
       "bbarjVwKz8/IOLkqZJ8zSt6C+ONPvPXXf+GtT225uv/qvBkHy8Jf/I//9/OX" +
       "P/RHv3NOqnYLcITsS2dn7JlFH2/FfGL824kmUzlYW7iOms1ZVwdgw718ZV0H" +
       "CpNzfOO115cxmzve3kB/+x3/86HR9+tvvoFk7eVnZHS2y3/OPvs75HfLP3lc" +
       "uOWKuV6z6Lu60RNXG+ndvgpWqc7oKlN92Ms/OqeCY662A9OOdaAsn7kMYNhy" +
       "JuatVg5UXyXbT/xAnfziD+S0kZHmVjffd1MzhbgL9+KNzxTXa3oGwi05B7fk" +
       "IsjID+Yk7/8tB9C+LSPxHm1yEWjtHcv2jaO9XtPz58W8v7zXpw5gfFdG3rHH" +
       "+OMXgTHaMRrdOMbrNb0+Rirv9ScPYHw6I+/dY3zfRWB8247Rt904xus1PQDh" +
       "IwfK/klGPrSH9+GLgPeuHY/vunF412t6fRVuXfEXDmD8WEb+2R7jR28E47bu" +
       "g7vlfnbOXM31I+B47Y7r154FvMsePnF+9rBlbwyirJ/dOLkSYi7tef2l5+L1" +
       "DDfZSXHHTfE63PzL5+AmX6xdCXWnmPnVG2TmZeB4/Y6Z11+HmU89BzO3S27k" +
       "bFNh6gw7v/Hts3N/djWr9oYdO2+4Djv/5nCed3uQ31Y+Ye5u+co6P29RunrA" +
       "lx0a8Nx140lvWdnnz8D97HPCzblKjo6AQVUuo5dL2fd/dz6gfD57TUY+l5HR" +
       "CaIHlpb86EmSOlH9ACQ7jy4t9ITbS/sEbHuX+QyT42+bSZCI3bvvjHGdxRPv" +
       "+W/v//w/fPVXQGpIF25bZ1k+yKdOjdiLsnv4/+DZDz58z9N/9J78jgoIApN3" +
       "/TL8V1mvv39jUB/KoPL5zUlGDEI2vwmiKlfQzk7h+SHgFSAR+vujDR/4cgcJ" +
       "qObJH1OWMXgwKQs2hBbHHMUT0GLeajZdcdEuGaqGhu2EcvVBL55tWnSvsjHw" +
       "jbSRBHZTt6cdex0NLMYaCSWEqcQdnPBnAqP4a2JgVNq1hIQtY1XqGLoym3l4" +
       "hArl4bTU8EXY70aVRAmVKGo0YBSN4XpRbNjqxl9HolycSupaU9EGXIOKDXhd" +
       "LNaUaOTUMcNORj2a6ilSO1kkq1Aa+j4ebJih5483MybSHb4YDdaEaUMVLZ0W" +
       "o4k+Dj1m5c7NVbk/ZRiPdKc+WzPGPcOeJ7zQ90IB5ckOXbIV3qi6S5wgYJ8e" +
       "sZPVphetqFUQ4Ehj6BPNZWVI8iKM212nRCfLMGiHC6+Nd7m5EzvmcKpKPcmt" +
       "8KLfCpejdUfwIzr09TggZ5oY6IZnKEi0HBvDFsGNeYJPpuSap/GgNxuWpEln" +
       "Nh14/aA6k8qkHrXtGjMT8M6gQSzLUlqsKzWDHKQtpbTkFVkjg6Uy4stDXDSq" +
       "9IpGJ4o3I/xuw+obq64ZW9O5qQruKsSpXmvVGloc319NF43qZMzXR5LSRvp8" +
       "YzIWg+WcGs+jdJXiJh57kqWNEi1ge8IgmcJSH+tREY8HvsfGfF2rWeasrMFE" +
       "mqot0kON2cQIxR4skDoex2JtMGmK0kazQ3E1pVJSNe2w5XLKaFwmxt4kUWsj" +
       "nyEnA7O8aOvLOtHezG2M9Dc9vRLMW0mrt2R1tlFmjVRrErJfnIy6C95lFyJa" +
       "Wq6qrRgTRWzRH3cVNpZNHFtLtGTMx1OGHTHapkpOA81eu812PHKtUW/FO/bG" +
       "n9L4YqGMaWKCm9Kyw2M128bGzBBvxeMSKTjL6cYypPFyE2BDqlhuLjl1Whu2" +
       "xDFYPrUGLQFUWTF1wVtYfQEZBmaZi4rBuoJyHcWtMeOkXerLc2syC7R4HPdm" +
       "q3kvpFqi1Z23EDqpeIzbLDONErpu6zim2wLadoMNBLEVgtxUfa5jkRZtS259" +
       "Q0Jh5KWcbzah8oSpJ/4U3dTbTDgUImO6cPsaNbI1YVKujOw132yGI6eGDNly" +
       "yNu8DDtrlHXm0CCs98011R9v/JVoUKxalr0aTLTG4qpmkcuxNbRZRWj7k7ld" +
       "qq+RHrtQVde1yGFkE4u42w0WCe9zXWtcRestd0G6TQNf6RWFIButUYpIuL7W" +
       "05LRxkcUycyazmxuMMUiXRkyAq5zY2RpGolnrIROZMZKVZKNeadTayqRzmMN" +
       "F5pheEln7RXZwnuxvMSjZQtnxqlMCl13E294boII7X7sho5nYcNBy2eJngwj" +
       "LMoPh5jtLEEp2xyl66bQ1CU7HVnKstzfjBqbSSQxjdjr16vuJEao6QYnCZNM" +
       "JZESrBAJGok88NmwQm4Yr2zy7XVnKthYOvdb+ooS9JLZF8R5hPYalZIwUUb4" +
       "1BCA17M1nBt6i3RdKgpz3RtU0WqfK1vT/gxOi4atYR6md2sGL9D8YOLI5kpO" +
       "MNbCkiAtDj1Ibc86nBrH/bFa6haFyEyWcxquw9RQ4atmETgAK1R4coWI43qd" +
       "9sg1AXdGDjoqIcV+x5ulFXmNVXuxZ2pN2lw37TaBEg0/CZly1LBW7Rk3maJw" +
       "6oclWat052jP6GCJOKjPk7mzCTGzPJDXXAfemIsZH0g1J0wnaaWrttPpnE8x" +
       "PNYRWO0taRbYUlfrsoHAY/GCREl6OE3HujELNsSoA0/4qMtM65EsuK35pN/U" +
       "nLg3sUclr5g0klqzaAZgfnKFBPGiTjivTOEAanSEWRklkHG1atrerN1r9abi" +
       "mlFtwlKUpF8eeSsV7dFdYYg2ZDICsR0KoN7U93uDuU1GLS8ahm5nsjBw3MYa" +
       "sBBF3CwNIaQ7iadBA8N6CezqRcMlhyKPx051QLQHdjTrc6VWraa1Z3g/FKUq" +
       "AXxo3NJ5b1YbI8Gsqq1VozuHilWvJLmLget1R9OaxFFdh+MZyRjCnK9VFyVB" +
       "HY11Ei2Gi6o+GNFOpTaG2FWpOiKDFkRHdaTMcYOGOKojrRSjrCXdj+alXnuw" +
       "aa6AEddSQ4t0rkGEgbucUXB5o2mKbfU0jdvA6YBmGvzcraVMp4hUoRWswmbo" +
       "CwQJoGmEPUPjEotvisIMqY1kIi6NqyTOV+25bERwqK7X5aq/LFsiQcWdARkq" +
       "LZNlsVJUFsv0cuOtmKlp09xGJ4lhIlRGoyE6Ki82bLDQV2TXXM9sj0o8djlV" +
       "I53deOY4dHET69UCDOdCrBfAejiZoGUUDYVxu0KFDanbG0ErG9LWFQJSex0s" +
       "DsPhvClMVXdGkkoHqRh1YjGez3GFgK0iioC5VmuIaXsUkUi5T3jEjI17DouK" +
       "rFyVxXrPQo3aIu05AukxtW6rPFNmGrRWwcRanrebKE9Y7TE6t0VcY9Exrlf8" +
       "AQ/xCCEHdNOJsKmzhNqz2Ii4YpuYuiw9cNarSrQZiDheo5ddlu7PU9xy20t0" +
       "o4rwomHVFHQEL9e6mgxpKgjCCkfrbK3cjOwRCsPeWl6pjWqtGlOyK8fOMlz1" +
       "FTPEVyNM5XnU4NUWDPUDU1w49MwpJ9AUKdfqZt8NhsrKwvGOPyjZLWATWDf0" +
       "rU1NqHvcmiMiqDofG7hVxTbWRDFWlWHUZJfjOpGOyYBCPNGsy6aUtGKJGfR4" +
       "oGNrKtMOLWKJ7UESw0gdTJ73KtoCFtJyAsskXW9s2iS66ep2ulaoMIxIiEaF" +
       "ymDmeqYoSSBkceVlt73UUDugJBUd6L31KtUb8dpfpUmDW2mrcmtRJWNsmNTH" +
       "1bqkdoS0hAQaxXIjwTIGfIyXDbgjBiOi3kD1cgMpThpWrFMyqTVRqehVqks2" +
       "VL3pOFg7+myFwKVlN13GSDeh5+IkaNEjcYC4VXs2pySEQ+RBsERTxErr9WJH" +
       "5pZNbxn2FlqzCWkoBwkuJ62LfWcdLHlVryyqE8tUoRClEB7iRFAkyeg6wX0K" +
       "CIBd+khrjmggiGkGiqgSbxaJjTBUxwYn1SBE5cflRatHMV1i5aXzpruSUyot" +
       "b2DDnIhi6k6dvtorldOeumJLYb20EnSnslIESl8sQXwl9TIdRwOpyy5L7rxT" +
       "DuaTru6agVctmx3cLdOh2SwLC5kbCLyXtFmalKhArEwkuLJuz2DYH2MLcjMP" +
       "eTZ2RrO1sy5WGNpx4KY5X9sQSwYEGs2H0xhr1zhaRYxNtd9dTFK/YxMlFcT6" +
       "YkkSNXcyge25Lyh8faBBGviXUCtWVMipcI1JczhqdhqUbve78aJbtnorZtz0" +
       "OnhLqkfmPOkGYWns+qoZVoOFnJhLyxmaGO7312Ygl0dBWfRRbS2M68V2ryhu" +
       "Fmy3DCqNechDOLudJp0KsZ6gNRgpK6nkV4siHqhGrVN19M5msnbKacBpMzii" +
       "NaI4R4syBcuQ2KoDuwvgcbHTHQUu7wmab+kDEeL5KpN6Yztmy0XGaK3pKqWw" +
       "eGh2SB7khR0CrTuVGb0czFFDdjCQ4nf6odEkonZNT7AqzdXFpE/T9akajso0" +
       "5A1LwwCqbpZCx0S7cOrUArBm6BYppSt3NbsGy3zc5mLJ2IhIVF+hjp8K/GzW" +
       "rgZNgvJ7NYFa10feIu40UVPdlGOiMtuQraWydhOO7ZRdaEIXV/Fo0ir2S+06" +
       "GctYzLmk6TQ2MeetKJnoVlqUU19ozDIdgzQh1jES8qfNpjHaENUU75hOHNGb" +
       "jiD5fbhKFZkOaWBiEBNVr9qsI4jecL2WAVdgGFLReqIJy1QsUctghgzmWMBs" +
       "sOqkpFWqKdKvjGfkjK7OU7rheUu+J7criTdxjJZM9esTtN9RqWFaFybyuDVB" +
       "+jQLd9YLK3RaVryuuXUTb8z4KgFyO2UZMprk1+1lr87Vncgb1mE8DccaE9ed" +
       "WdxIS2h/UYkEWI43Tgktckx7pIXxYKhpfntcCawqWlI4dgZBjahs4yvCCr0e" +
       "OuK96nrdwjXEGwoQIyzZjsFDhm56VoNF3Woa4hXLhlao1TXpbich68gaHTZQ" +
       "ypwyvY5Pd1qaxWqhuBCmUkUPSqru1muSVacqVK9d7QQOGs1UaezoC9iB0GFS" +
       "iwKttl4wRL+6pLWmhRmq1LF6k0bq8GBiJFZurNYJmqh3OoqRSJtuBVFxf7wm" +
       "RguP9EDsnq5mPL5aoTVy7aQNM/ZnzcYs6VeZpBs2zHKoc2UBosACGasbkr4a" +
       "4BLeDPCh0l+UVXhkYzRF9vBJhfYgvG91qmEq223BmFmuCWtSEMH9TjKHygts" +
       "WI1HZjpmNzgilE2GkrJQhxAtrdnaICBbIsolQrIprooUscw2fE8mhzOm50yk" +
       "qio0SnTcaPWGNhfygilG5NIi+DJZ8oZipTtDxCQpBjy0XDBG3Gxj/USKCblV" +
       "ScyRwXOIXvSb+GKmR4MwZugJSMAlN1EW/LjfH+rybNBkV0ti3bfSjoST/eq8" +
       "2OpUoqbTL7XUaTSE++1+bxhTYDXcbHpgmkNBvZHdr8bbenYrwOp2lSwFDkWw" +
       "M4MsbuolnI3EYpSsCa6mTCqW6UkSk/qxz9ebWi8ZubxVqwTSoqaler3C9hbt" +
       "xdTE1KZHNSRi4+lJq72Sl9h8vGiyKsc3KbXsTavYqDjlFkniLqoNscnhMbua" +
       "b8bdeWq3jeFQNNAK7YeKZmtmKamX0xAk0uRggnOE4qSiK/bNmb+Y+pXY1Aab" +
       "vjrZsHWtv4lZudlGqr2e6SxaBDkAk9cMUxSBLFbSYjsCfrpq4k4MURVkZjKm" +
       "aCOyzHUke0JjUxhMMoatC3DKVPohCvMtLZ6VAmwWlRtu35ksXaUyWkjF5RjH" +
       "l2lQTXsuk8UIDcSIJkLJbbCgUjcjJAaO5/ixXnXHcEUxea0Ou2ulNDIxqezW" +
       "7PKIJ2O+uEoIc7o0JkOWhxwTiJEdVfiGWAdrSXMZbeBqEiucRWqVRduB6pVB" +
       "r71uFUd6CJaKVF8KcL9EdbnIhctLVFJL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "0n/1wL/4vp9/5g/zH1n+P6a1aDGAUgAA");
}
