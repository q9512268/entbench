package org.apache.batik.svggen;
public class SVGGraphicContext implements org.apache.batik.util.SVGConstants, org.apache.batik.svggen.ErrorConstants {
    private static final java.lang.String[] leafOnlyAttributes = { SVG_OPACITY_ATTRIBUTE,
    SVG_FILTER_ATTRIBUTE,
    SVG_CLIP_PATH_ATTRIBUTE };
    private static final java.lang.String[] defaultValues = { "1",
    SVG_NONE_VALUE,
    SVG_NONE_VALUE };
    private java.util.Map context;
    private java.util.Map groupContext;
    private java.util.Map graphicElementContext;
    private org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack;
    public SVGGraphicContext(java.util.Map context, org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (context ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          context =
          context;
        this.
          transformStack =
          transformStack;
        computeGroupAndGraphicElementContext(
          );
    }
    public SVGGraphicContext(java.util.Map groupContext, java.util.Map graphicElementContext,
                             org.apache.batik.ext.awt.g2d.TransformStackElement[] transformStack) {
        super(
          );
        if (groupContext ==
              null ||
              graphicElementContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_MAP_NULL);
        if (transformStack ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_TRANS_NULL);
        this.
          groupContext =
          groupContext;
        this.
          graphicElementContext =
          graphicElementContext;
        this.
          transformStack =
          transformStack;
        computeContext(
          );
    }
    public java.util.Map getContext() { return context;
    }
    public java.util.Map getGroupContext() {
        return groupContext;
    }
    public java.util.Map getGraphicElementContext() {
        return graphicElementContext;
    }
    public org.apache.batik.ext.awt.g2d.TransformStackElement[] getTransformStack() {
        return transformStack;
    }
    private void computeContext() { if (context !=
                                          null)
                                        return;
                                    context =
                                      new java.util.HashMap(
                                        groupContext);
                                    context.
                                      putAll(
                                        graphicElementContext);
    }
    private void computeGroupAndGraphicElementContext() {
        if (groupContext !=
              null)
            return;
        groupContext =
          new java.util.HashMap(
            context);
        graphicElementContext =
          new java.util.HashMap(
            );
        for (int i =
               0;
             i <
               leafOnlyAttributes.
                 length;
             i++) {
            java.lang.Object attrValue =
              groupContext.
              get(
                leafOnlyAttributes[i]);
            if (attrValue !=
                  null) {
                if (!attrValue.
                      equals(
                        defaultValues[i]))
                    graphicElementContext.
                      put(
                        leafOnlyAttributes[i],
                        attrValue);
                groupContext.
                  remove(
                    leafOnlyAttributes[i]);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "67ZKxZoEhfwsFcdre+P1Jbe8rAczCx5W");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("0QncaiBwlWrBdrvWW4Vmk/CJuaMk5TII53KNX/RJz+jATbgpaX0oqG03xtSd" +
       "g2i32mzrrIEA/RF0Z7Mx22VRBKltrebBQmsrkfxsAvfmIm85SkMu62wa8NVp" +
       "u562K1Z1vob7mOckVtbzda5MyhFW784yNZ6moTqdIyG01OhxQNSJjVTvodOe" +
       "zbXsrhe0mC2ll5X1sGdXJBDljCEU9j3FHMNtF/Bt1XDHYiivg9Bgke305/G8" +
       "NSbnqAwTDkIPoGoLsTjNSGZIhrSAwfTKlkn2MAzLt4Z+761tWT1c7MQdXjL9" +
       "E+zBpbc7Tyv+8v38ExcTj21bHjtfOjyHfubMRY3i3JCfUoe3iQ9A33Pe/T4i" +
       "CLzgEDw/tXzivFupxdH65z/+yqva8BeqB/eAxlHp3sjzf9jWN7p9jMi7ducq" +
       "hwzmG7/FqcWL+wy+eLvd32sXbMq+bzcFF5yofOuCtv+VF1+PSvct9HP2p4vT" +
       "0IfeiMJjh5HFTH/jrZwS3k4mT4JH38eo/+Bl8r0L2v4oL74bla4CmVDnn0gc" +
       "CuZCMk8L5g+/X8G8Fzz2Pkb7By6YS/de0HZ/XtwRlR4rBPPGRxuHErqQ3lMS" +
       "unTn9yGhZ/PK/Ggj3McY/uAl9OgFbe/Ki0eAOwQSEs6ekRwx+bbvg8niLOfp" +
       "vHmfyeStMvkTb8jksxe05fdWLj0ZlR7Kr6jHkX588k8fTWw8Szvi+qnvl2sE" +
       "PC/vc/3yD57r2gVt9bz44ah0Y5/rwjNgrnZbQ8hh33vE995bujMB1OfM9fL8" +
       "ruxjZ/57ZfcfF+oXX716z6OvTv7d7kLnwX9F3MuW7jFi2z5+i+7Y+11+oBtW" +
       "IZJ7dxd0/ILPm1Hp0XOiYn7NonjJab70gR38B6PStdPwUenO4vc4HAaCzBEc" +
       "GGr3chykE5WuAJD8lfAPQvSxU7bdZcL00rF4uq8mhWt95I2kfNjl+AXs/IpT" +
       "8d9DB1fC4tH+JeIvvdodfPQ7zV/YXQBXbXlb3IW5hy3dvbuLXgyaXyt7+tzR" +
       "Dsa6i37+ew/90r3PHeQHD+0IPlLZY7Q9dfvb1oTjR8X96O0/ffSXf+Tvvvr7" +
       "xTHj/weYWkLC1jUAAA==");
}
