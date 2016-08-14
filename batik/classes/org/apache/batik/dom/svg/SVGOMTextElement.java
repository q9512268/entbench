package org.apache.batik.dom.svg;
public class SVGOMTextElement extends org.apache.batik.dom.svg.SVGOMTextPositioningElement implements org.w3c.dom.svg.SVGTextElement, org.apache.batik.dom.svg.SVGMotionAnimatableElement {
    protected static final java.lang.String X_DEFAULT_VALUE = "0";
    protected static final java.lang.String Y_DEFAULT_VALUE = "0";
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextPositioningElement.
                 xmlTraitInformation);
             t.put(null, SVG_TRANSFORM_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_TRANSFORM_LIST));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedTransformList
      transform;
    protected java.awt.geom.AffineTransform motionTransform;
    protected SVGOMTextElement() { super(); }
    public SVGOMTextElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() { transform =
                                                createLiveAnimatedTransformList(
                                                  null,
                                                  SVG_TRANSFORM_ATTRIBUTE,
                                                  "");
    }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
    }
    public org.w3c.dom.svg.SVGElement getNearestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getNearestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGElement getFarthestViewportElement() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getFarthestViewportElement(
            this);
    }
    public org.w3c.dom.svg.SVGRect getBBox() { return org.apache.batik.dom.svg.SVGLocatableSupport.
                                                 getBBox(
                                                   this);
    }
    public org.w3c.dom.svg.SVGMatrix getCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getScreenCTM() {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getScreenCTM(
            this);
    }
    public org.w3c.dom.svg.SVGMatrix getTransformToElement(org.w3c.dom.svg.SVGElement element)
          throws org.w3c.dom.svg.SVGException {
        return org.apache.batik.dom.svg.SVGLocatableSupport.
          getTransformToElement(
            this,
            element);
    }
    public org.w3c.dom.svg.SVGAnimatedTransformList getTransform() {
        return transform;
    }
    protected java.lang.String getDefaultXValue() {
        return X_DEFAULT_VALUE;
    }
    protected java.lang.String getDefaultYValue() {
        return Y_DEFAULT_VALUE;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public java.awt.geom.AffineTransform getMotionTransform() {
        return motionTransform;
    }
    public void updateOtherValue(java.lang.String type,
                                 org.apache.batik.anim.values.AnimatableValue val) {
        if (type.
              equals(
                "motion")) {
            if (motionTransform ==
                  null) {
                motionTransform =
                  new java.awt.geom.AffineTransform(
                    );
            }
            if (val ==
                  null) {
                motionTransform.
                  setToIdentity(
                    );
            }
            else {
                org.apache.batik.anim.values.AnimatableMotionPointValue p =
                  (org.apache.batik.anim.values.AnimatableMotionPointValue)
                    val;
                motionTransform.
                  setToTranslation(
                    p.
                      getX(
                        ),
                    p.
                      getY(
                        ));
                motionTransform.
                  rotate(
                    p.
                      getAngle(
                        ));
            }
            org.apache.batik.dom.svg.SVGOMDocument d =
              (org.apache.batik.dom.svg.SVGOMDocument)
                ownerDocument;
            d.
              getAnimatedAttributeListener(
                ).
              otherAnimationChanged(
                this,
                type);
        }
        else {
            super.
              updateOtherValue(
                type,
                val);
        }
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
       "wL8M0gu7yXvh5IH/kXqcedp/xtvRXzqj");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("7h/n2WtR6R2GY0TFfTYVtSzK2KhoFAXGMo7UsGj4mWO6+fei0p0b11COlPbL" +
       "N/PCtSj4uUMR3H+gs+pOBOrNiCAq3eMFxkaK1BvK4VfPqPu1PPuVqPT4kRyu" +
       "FkJe/5UjwP/8FgA/lBfm91PsHWD7Zuf8gzfE+q/PqPs3efa1qHS/pkaUK0sW" +
       "s1NX9Ajf128B36N5IZxX7/Altx/f75xR95/y7JtR6e0AH6NKgRpGgqEmnhuc" +
       "dG9PnOIFj5MUovh3tyqK3Lxf3Inixdsvit8/o+4P8+z3AFAgClwKIv1aWeQU" +
       "3z5C+59vAe3DeeETIL20Q/vS7Uf7P8+o+5M8++/AIwC0nY6bHkzzY6dM8yS/" +
       "cHiI+n/cAurinXp+BeAzO9Sfue2oz507o64IN/4sKt0NUGMcfQD67aeApiXg" +
       "ztIj2H9+q7CfBumVHexXbj/si2fUPZhnF/a92FQOVNUB4POyuw7xnXvLreJ7" +
       "DqQv7PB94fbgO3dE8O0CyDtOJziYx3ee5qNSWfXy0Kbo4Mk8ezQqPQIkcfgW" +
       "n3OP7Pu4SB67BZFczgtzb/alnUi+dPun/Nkz6qA8u7w/5ddcanjfKXI69XbG" +
       "kSyeuVX1eAak13eyeP1mZXHDwO1c84y6dp5VotIlIIuuupJiK5oXt7ty4qOF" +
       "/Fz1dmD85R3GX779GLEz6vLbTuc+dBXGxWkYf+R2rFlf3WH86u3HODqjbpxn" +
       "A7BmOWrCuIp6oM6XjqvzYUUBd3gLcHOHXWqD9Os7uL9+++G+cEbdlTybgzh7" +
       "34SvujV2eBPMOMK6uAWsxbW8HwbpGzus37hZrDd2V8YZdWaeKVHpIYCVvvom" +
       "Vk7+sSOUN7zvdgbK4q5vB6Rv7VB+6/agPH904Q89UMr3X3McIAEPu1fco8ov" +
       "Vx+cBBRGWsggPkM+2zzzgKrHngK89CjKzwoPzPtor3XOv6nbvKC/k99o5LfN" +
       "H7/mE7D9z5bkX3j14r2Pvcp/q/hM4fDTovuo0r2r2LKOX3A99ny3F6gro5Db" +
       "ffvXXb0C0ieAZl/vyCQq3QHynOFzL+5T/82o9LbTqAElyI9TvrRzCMcpo9Jd" +
       "xf/jdD8elS4c0YGYcP/hOMnfAb0DkvzxM97BxNZu/L3LwWdLhqMdHPTsxyiP" +
       "H9fLIqx86EYTdtjk+BcR+flO8TnfwVlMvP9B3xX59VcHzMe+3/jZ/S8yZEvK" +
       "sryXe6nSPfsfhxSd5uc5T1+3t4O+7iae/cEDv3jfMwdnTw/sM3xkI8d4e9fp" +
       "3z70bC8qvlbI/tlj/+QD//DV3y2uCf4/RQ1Z92c5AAA=");
}
