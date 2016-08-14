package org.apache.batik.anim.values;
public class AnimatableTransformListValue extends org.apache.batik.anim.values.AnimatableValue {
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWX =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SKEWY =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_SCALE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_ROTATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    protected static org.apache.batik.dom.svg.SVGOMTransform IDENTITY_TRANSLATE =
      new org.apache.batik.dom.svg.SVGOMTransform(
      );
    static { IDENTITY_SKEWX.setSkewX(0.0F);
             IDENTITY_SKEWY.setSkewY(0.0F);
             IDENTITY_SCALE.setScale(0.0F, 0.0F);
             IDENTITY_ROTATE.setRotate(0.0F, 0.0F, 0.0F);
             IDENTITY_TRANSLATE.setTranslate(0.0F, 0.0F); }
    protected java.util.Vector transforms;
    protected AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target) {
        super(
          target);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        org.apache.batik.dom.svg.AbstractSVGTransform t) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            );
        this.
          transforms.
          add(
            t);
    }
    public AnimatableTransformListValue(org.apache.batik.dom.anim.AnimationTarget target,
                                        java.util.List transforms) {
        super(
          target);
        this.
          transforms =
          new java.util.Vector(
            transforms);
    }
    public org.apache.batik.anim.values.AnimatableValue interpolate(org.apache.batik.anim.values.AnimatableValue result,
                                                                    org.apache.batik.anim.values.AnimatableValue to,
                                                                    float interpolation,
                                                                    org.apache.batik.anim.values.AnimatableValue accumulation,
                                                                    int multiplier) {
        org.apache.batik.anim.values.AnimatableTransformListValue toTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            to;
        org.apache.batik.anim.values.AnimatableTransformListValue accTransformList =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            accumulation;
        int accSize =
          accumulation ==
          null
          ? 0
          : accTransformList.
              transforms.
          size(
            );
        int newSize =
          transforms.
          size(
            ) +
          accSize *
          multiplier;
        org.apache.batik.anim.values.AnimatableTransformListValue res;
        if (result ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            res =
              (org.apache.batik.anim.values.AnimatableTransformListValue)
                result;
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accTransformList.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        for (int i =
               0;
             i <
               transforms.
               size(
                 ) -
               1;
             i++,
               index++) {
            res.
              transforms.
              setElementAt(
                transforms.
                  elementAt(
                    i),
                index);
        }
        if (to !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                toTransformList.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              null;
            int type;
            if (transforms.
                  isEmpty(
                    )) {
                type =
                  tt.
                    getType(
                      );
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        ft =
                          IDENTITY_SKEWX;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        ft =
                          IDENTITY_SKEWY;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        ft =
                          IDENTITY_SCALE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        ft =
                          IDENTITY_ROTATE;
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        ft =
                          IDENTITY_TRANSLATE;
                        break;
                }
            }
            else {
                ft =
                  (org.apache.batik.dom.svg.AbstractSVGTransform)
                    transforms.
                    lastElement(
                      );
                type =
                  ft.
                    getType(
                      );
            }
            if (type ==
                  tt.
                  getType(
                    )) {
                org.apache.batik.dom.svg.AbstractSVGTransform t;
                if (res.
                      transforms.
                      isEmpty(
                        )) {
                    t =
                      new org.apache.batik.dom.svg.SVGOMTransform(
                        );
                    res.
                      transforms.
                      add(
                        t);
                }
                else {
                    t =
                      (org.apache.batik.dom.svg.AbstractSVGTransform)
                        res.
                          transforms.
                        elementAt(
                          index);
                    if (t ==
                          null) {
                        t =
                          new org.apache.batik.dom.svg.SVGOMTransform(
                            );
                        res.
                          transforms.
                          setElementAt(
                            t,
                            index);
                    }
                }
                float x;
                float y;
                float r =
                  0;
                switch (type) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        r =
                          ft.
                            getAngle(
                              );
                        r +=
                          interpolation *
                            (tt.
                               getAngle(
                                 ) -
                               r);
                        if (type ==
                              org.w3c.dom.svg.SVGTransform.
                                SVG_TRANSFORM_SKEWX) {
                            t.
                              setSkewX(
                                r);
                        }
                        else
                            if (type ==
                                  org.w3c.dom.svg.SVGTransform.
                                    SVG_TRANSFORM_SKEWY) {
                                t.
                                  setSkewY(
                                    r);
                            }
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getA(
                                  );
                            y =
                              fm.
                                getD(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getA(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getD(
                                     ) -
                                   y);
                            t.
                              setScale(
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        {
                            x =
                              ft.
                                getX(
                                  );
                            y =
                              ft.
                                getY(
                                  );
                            x +=
                              interpolation *
                                (tt.
                                   getX(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tt.
                                   getY(
                                     ) -
                                   y);
                            r =
                              ft.
                                getAngle(
                                  );
                            r +=
                              interpolation *
                                (tt.
                                   getAngle(
                                     ) -
                                   r);
                            t.
                              setRotate(
                                r,
                                x,
                                y);
                            break;
                        }
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        {
                            org.w3c.dom.svg.SVGMatrix fm =
                              ft.
                              getMatrix(
                                );
                            org.w3c.dom.svg.SVGMatrix tm =
                              tt.
                              getMatrix(
                                );
                            x =
                              fm.
                                getE(
                                  );
                            y =
                              fm.
                                getF(
                                  );
                            x +=
                              interpolation *
                                (tm.
                                   getE(
                                     ) -
                                   x);
                            y +=
                              interpolation *
                                (tm.
                                   getF(
                                     ) -
                                   y);
                            t.
                              setTranslate(
                                x,
                                y);
                            break;
                        }
                }
            }
        }
        else {
            org.apache.batik.dom.svg.AbstractSVGTransform ft =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                res.
                  transforms.
                elementAt(
                  index);
            if (t ==
                  null) {
                t =
                  new org.apache.batik.dom.svg.SVGOMTransform(
                    );
                res.
                  transforms.
                  setElementAt(
                    t,
                    index);
            }
            t.
              assign(
                ft);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        int type =
          ft1.
          getType(
            );
        float x;
        float y;
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            x =
              ft1.
                getMatrix(
                  ).
                getA(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getD(
                  );
        }
        else {
            x =
              ft1.
                getMatrix(
                  ).
                getE(
                  );
            y =
              ft2.
                getMatrix(
                  ).
                getF(
                  );
        }
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            if (type ==
                  org.w3c.dom.svg.SVGTransform.
                    SVG_TRANSFORM_SCALE) {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getA(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getD(
                         ) -
                       y);
            }
            else {
                x +=
                  interpolation1 *
                    (tt1.
                       getMatrix(
                         ).
                       getE(
                         ) -
                       x);
                y +=
                  interpolation2 *
                    (tt2.
                       getMatrix(
                         ).
                       getF(
                         ) -
                       y);
            }
        }
        if (type ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_SCALE) {
            t.
              setScale(
                x,
                y);
        }
        else {
            t.
              setTranslate(
                x,
                y);
        }
        res.
          hasChanged =
          true;
        return res;
    }
    public static org.apache.batik.anim.values.AnimatableTransformListValue interpolate(org.apache.batik.anim.values.AnimatableTransformListValue res,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue value3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to1,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to2,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue to3,
                                                                                        float interpolation1,
                                                                                        float interpolation2,
                                                                                        float interpolation3,
                                                                                        org.apache.batik.anim.values.AnimatableTransformListValue accumulation,
                                                                                        int multiplier) {
        int accSize =
          accumulation ==
          null
          ? 0
          : accumulation.
              transforms.
          size(
            );
        int newSize =
          accSize *
          multiplier +
          1;
        if (res ==
              null) {
            res =
              new org.apache.batik.anim.values.AnimatableTransformListValue(
                to1.
                  target);
            res.
              transforms =
              new java.util.Vector(
                newSize);
            res.
              transforms.
              setSize(
                newSize);
        }
        else {
            if (res.
                  transforms ==
                  null) {
                res.
                  transforms =
                  new java.util.Vector(
                    newSize);
                res.
                  transforms.
                  setSize(
                    newSize);
            }
            else
                if (res.
                      transforms.
                      size(
                        ) !=
                      newSize) {
                    res.
                      transforms.
                      setSize(
                        newSize);
                }
        }
        int index =
          0;
        for (int j =
               0;
             j <
               multiplier;
             j++) {
            for (int i =
                   0;
                 i <
                   accSize;
                 i++,
                   index++) {
                res.
                  transforms.
                  setElementAt(
                    accumulation.
                      transforms.
                      elementAt(
                        i),
                    index);
            }
        }
        org.apache.batik.dom.svg.AbstractSVGTransform ft1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value1.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value2.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform ft3 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            value3.
              transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            res.
              transforms.
            elementAt(
              index);
        if (t ==
              null) {
            t =
              new org.apache.batik.dom.svg.SVGOMTransform(
                );
            res.
              transforms.
              setElementAt(
                t,
                index);
        }
        float x;
        float y;
        float r;
        r =
          ft1.
            getAngle(
              );
        x =
          ft2.
            getX(
              );
        y =
          ft3.
            getY(
              );
        if (to1 !=
              null) {
            org.apache.batik.dom.svg.AbstractSVGTransform tt1 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to1.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt2 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to2.
                  transforms.
                lastElement(
                  );
            org.apache.batik.dom.svg.AbstractSVGTransform tt3 =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                to3.
                  transforms.
                lastElement(
                  );
            r +=
              interpolation1 *
                (tt1.
                   getAngle(
                     ) -
                   r);
            x +=
              interpolation2 *
                (tt2.
                   getX(
                     ) -
                   x);
            y +=
              interpolation3 *
                (tt3.
                   getY(
                     ) -
                   y);
        }
        t.
          setRotate(
            r,
            x,
            y);
        res.
          hasChanged =
          true;
        return res;
    }
    public java.util.Iterator getTransforms() {
        return transforms.
          iterator(
            );
    }
    public boolean canPace() { return true;
    }
    public float distanceTo(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        )) +
                  java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo1(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getE(
                        ) -
                      m2.
                      getE(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getA(
                        ) -
                      m2.
                      getA(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWX:
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SKEWY:
                return java.lang.Math.
                  abs(
                    t1.
                      getAngle(
                        ) -
                      t2.
                      getAngle(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo2(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        org.w3c.dom.svg.SVGMatrix m1 =
          t1.
          getMatrix(
            );
        org.w3c.dom.svg.SVGMatrix m2 =
          t2.
          getMatrix(
            );
        switch (type1) {
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_TRANSLATE:
                return java.lang.Math.
                  abs(
                    m1.
                      getF(
                        ) -
                      m2.
                      getF(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_SCALE:
                return java.lang.Math.
                  abs(
                    m1.
                      getD(
                        ) -
                      m2.
                      getD(
                        ));
            case org.w3c.dom.svg.SVGTransform.
                   SVG_TRANSFORM_ROTATE:
                return java.lang.Math.
                  abs(
                    t1.
                      getX(
                        ) -
                      t2.
                      getX(
                        ));
        }
        return 0.0F;
    }
    public float distanceTo3(org.apache.batik.anim.values.AnimatableValue other) {
        org.apache.batik.anim.values.AnimatableTransformListValue o =
          (org.apache.batik.anim.values.AnimatableTransformListValue)
            other;
        if (transforms.
              isEmpty(
                ) ||
              o.
                transforms.
              isEmpty(
                )) {
            return 0.0F;
        }
        org.apache.batik.dom.svg.AbstractSVGTransform t1 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            transforms.
            lastElement(
              );
        org.apache.batik.dom.svg.AbstractSVGTransform t2 =
          (org.apache.batik.dom.svg.AbstractSVGTransform)
            o.
              transforms.
            lastElement(
              );
        short type1 =
          t1.
          getType(
            );
        if (type1 !=
              t2.
              getType(
                )) {
            return 0.0F;
        }
        if (type1 ==
              org.w3c.dom.svg.SVGTransform.
                SVG_TRANSFORM_ROTATE) {
            return java.lang.Math.
              abs(
                t1.
                  getY(
                    ) -
                  t2.
                  getY(
                    ));
        }
        return 0.0F;
    }
    public org.apache.batik.anim.values.AnimatableValue getZeroValue() {
        return new org.apache.batik.anim.values.AnimatableTransformListValue(
          target,
          new java.util.Vector(
            5));
    }
    public java.lang.String toStringRep() {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          );
        java.util.Iterator i =
          transforms.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            org.apache.batik.dom.svg.AbstractSVGTransform t =
              (org.apache.batik.dom.svg.AbstractSVGTransform)
                i.
                next(
                  );
            if (t ==
                  null) {
                sb.
                  append(
                    "null");
            }
            else {
                org.w3c.dom.svg.SVGMatrix m =
                  t.
                  getMatrix(
                    );
                switch (t.
                          getType(
                            )) {
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_TRANSLATE:
                        sb.
                          append(
                            "translate(");
                        sb.
                          append(
                            m.
                              getE(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getF(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SCALE:
                        sb.
                          append(
                            "scale(");
                        sb.
                          append(
                            m.
                              getA(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            m.
                              getD(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWX:
                        sb.
                          append(
                            "skewX(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_SKEWY:
                        sb.
                          append(
                            "skewY(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                    case org.w3c.dom.svg.SVGTransform.
                           SVG_TRANSFORM_ROTATE:
                        sb.
                          append(
                            "rotate(");
                        sb.
                          append(
                            t.
                              getAngle(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getX(
                                ));
                        sb.
                          append(
                            ',');
                        sb.
                          append(
                            t.
                              getY(
                                ));
                        sb.
                          append(
                            ')');
                        break;
                }
            }
            if (i.
                  hasNext(
                    )) {
                sb.
                  append(
                    ' ');
            }
        }
        return sb.
          toString(
            );
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
       "bawvvL6dxAeKTdPDW2gLp5EX/Ozr2EFL");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b3coWnwulk7dXDq2hXzs0K6U7wo+ftblsmJH8LMfefElg/t55OBk8u/Fpcux" +
       "H/ywY65N5xipewClZ8/e/WSKu3VHh3Bf/sh/e1T6wPzDr+MmzpOn+DxN8u8y" +
       "L3+l9y79r+2V7jg8krvl1t/JRs+dPIi7EppxEnrSieO4xw8l+4MH0nT3Jeue" +
       "3pw/GrvbnwA8vxv7U+exdxUV7jrYLH/Pa7xBVZxI5m2+XLT8W8e05XP5Br3j" +
       "a/GZxXfY3u5Kx6+dczj8L/PkV+PSPcWlSiBJLT7WYaGe//R1n/z/yqE8oTzz" +
       "vUA0e7u2u+/XKM+9I6u6rVAv706lCwpnJV85TIqfXy0Iff0cgfz7PPnXtwrk" +
       "mL3+1pshkA/uC+SDb6JA7i1q3XuuQG4nmtPy+S/nyOdbefIfz5XP77wB+eQH" +
       "Y6WngVxe3pfPy2+OAR6H8D/PKftfefLtuHSfZcbSWUd4xX2Wh85j8sDQHzw6" +
       "wqNis7ixlpd890hY/+MNCOuhPPNR0P8X9/n44psurAt755TdmWf+UVy6pGve" +
       "8OA+9ikvdGnq+46peUeI//gNIC5mP+CkL3xpH/GX3hzEF44qfLmA9sA5sB/K" +
       "k3vj0hXD3s0xUnHD+CuHEC/c90YhPgaY+fo+xK9/nyA+fg7EJ/PkEWDlRxCR" +
       "Uxh/4M3A+N19jN/9PmF85hyM5Ty5fgIjegrjO98EjHtv2bXdfX8fMNbOwZjH" +
       "mxfgExgrpzAibwBjES69G2B7Zh/jM28OxuMQsHPK2nnyvrh0L/DWEzP0T8VL" +
       "Bb73vwF8D+aZjwNc+5eT9m65nPTG8THnlHF5QoLhi/3dpQrBLPr92SN41Ou6" +
       "zReXHjvvfn5+0/iRW/4utPuLi/6LL129+20vjf5NcUX98G8ol+nS3bPEcY5f" +
       "djv2fjEIzZldCOHy7upbUCCTASfnBcFx6eLuJcdwYbRrpMalh2/bKC7dmX8d" +
       "r/vBuHTtdF0QMhffx+vdBH78qB7odvdyvMoUxNKgSv6qBzu7292ufuS41hRz" +
       "24OvNhrHFmXvOLGUKv7LdbDsSYb7t1M//1Kf/bHv1H9+d71ed7Qsy6ncTZcu" +
       "7W76F0TzpdPTZ1I7oHWRfOZ793/h8jsPlnn37xg+0uBjvD15+4vshBvExdXz" +
       "7B+97Yvv+9sv/XZx1eb/AQUiI2JkNwAA");
}
