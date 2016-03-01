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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "w7ZKsZv32M0ujJU7eZ//6AsvGsNfQI5O");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("FP9+UrmYBOF7XHNjuqdY3QU4PXPzXUu+vC93cnj2lY/+t0fEDyw/8hpu0Dx+" +
       "Rs6zLP8e/9JXu+/U//pB5Zbjo7TrbvJdW+nZaw/QLkVmkka+eM0x2mPHmv3h" +
       "I216h5r1zm6qn/TdjXfun9v3/Zlz1NtKgtuONrnf/SpvPpUniUWdr5Q1//Yp" +
       "a/lCsbHuBmpy0+JbbH9/FeM3zjnU/ZdF8utJ5a7yoiTQpJqcarA0z3/6mk/s" +
       "f+1Yn1CR+V6gmoN93f33q9TnwcmouqFSL+5Pk0sON0u+epyUP79WMvrGOQr5" +
       "90Xyr69XyKnx+jtvhEI+dKiQD72BCrm7pLr7XIXcSDVn9fNfztHPt4vkP56r" +
       "n997HfopDrQqTwK9vHSon5femAF4GsL/PKfsfxXJd5LKPZaZiDc7eivvoTx4" +
       "npBHA/2Bk6M3JjHLm2ZFyfdOlPU/XoeyHiwyHwHtf/lQji+/4cq6cHBO2a1F" +
       "5p8klTt01R8d3bE+44Xu0ILANVX/BPGfvg7E5ewHnPSFXzlE/CtvDOILJwRf" +
       "KaHdfw7sB4vk7qRyybD3c4xY3hr+6jHEC/e8XoiPAmG+cQjxGz8giI+dA/Hx" +
       "InkYjPITiMgZjD/0RmD83iHG7/2AMD59DsZqkTx1DcbaGYzveAMwHrxpX3f/" +
       "/QPA2DwHYxFvXoCvwVg/gxF5HRjLcOldANvThxiffmMwnoZAnFPWKZL3JZW7" +
       "gbdWzCg4Ey+V+N7/OvA9UGQ+BnAdXio6uO5S0evHx59TNiySHui+JNhfhpiY" +
       "Zbs/dwKPeU238JLKo+fdqy9uCD983V+A9n9b0X/pxfvufMuL0r8pr5Yf/7Xk" +
       "Ile5c5G67ulLaqfebw8jc2GXSri4v7IWlshkIMl5QXBSuX3/UmC4IO0rzZPK" +
       "QzeslFRuLb5O034oqVw+SwtC5vL7NN1V4MdP6ECz+5fTJBqIpQFJ8aqH+3G3" +
       "vxX98GmrKee2B16pN04tyt5+zVKq/H/W0bInHR3eKv3ii/3Bj30X/YX9tXjd" +
       "VfO84HInV7ljf0O/ZFosnZ68KbcjXrf3nv7+vV+6+I6jZd69e4FPLPiUbI/f" +
       "+AI65YVJeWU8/0dv+fL7/s6Lv1tekfl/c+emJzg3AAA=");
}
