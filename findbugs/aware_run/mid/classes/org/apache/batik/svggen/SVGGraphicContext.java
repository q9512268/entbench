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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Sg3kRhZPlWs+ndYsU5uahKebGyeA+qJO");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b8ueWU48PORaq8mcopM1jgjNRtZShcnMLY8WiBzoZFmvzBUdJaym4/jrYUPw" +
       "JjWbg9WK2SOZ1ngk0xJVbrKCRaXTPlojxkNxWZYENe22AIY7KwIJ4M3WMrtA" +
       "3VAqZup0qTW7HARVIdhbDCSqIVsbxUqdgFabQ8nzmpZpIZ05qg779iZa1nG9" +
       "sVgMkGCotUZmgDiuTvYQrb9GKcjs92zLJTftdv5p5/fe3CenB4svaYeHS/8E" +
       "39DSW+2HFX/59/gTBxKPfXY8tj90uI/81JmDFsW+Hyf0D08RH5C+57yze3gQ" +
       "uMEheb7r+Nh5p1GLrfEvfuLlVxT6FyoHZ3yYqHR35HofsNREtY4xeWW3L3Io" +
       "YP7htth1eGFfwBdu9fX22gUfVd+3M8EFOyLfuaDtf+XFN6PSPSv1nO/LxW7m" +
       "A6/H4bHNxMLS33ozu3y30snj4FL3Z1Tfep384IK2P8qL70elq0An/fN3FA4V" +
       "cyGbpxXzhz+sYt4LLmt/RustV8yluy9ouzcvbo9KjxSKef2tiUMNXcjvKQ1d" +
       "uuOH0NDTeWW+NRHuzxi+9Rp6+IK2d+XFQwAOgYb4s3scR0K+7YcQstiLeTJv" +
       "3hdy82aF/InXFfLpC9rycyeXHo9KD+RH0+NIPW7801sLiWsoR1I/8cNK3QTX" +
       "S/tSv/TWS41c0FbLiw9EpWf2pS6Qoe0ot1wIOe17j+Tee1NnHoD7nDk6np+D" +
       "feTMf63s/tNC/vIrV+96+JXpv9sd1jz4b4i7qdJdWmxZx0/BHbu/4gWqZhQq" +
       "uXt3wMYr5LwRlR4+JyrmxySKm5znSx/c0X8oKl07TR+V7ih+j9O1QZA5ogND" +
       "7W6Ok3Sj0m2AJL/FvYMQfWyXbHcYML10LJ7uu0kBrQ+9npYPuxw/XJ0fUSr+" +
       "a+jgSFc82T8g/JVXyPHHvtf4hd3hbhm8fBZnWe6iSnfuzpkXg+bHwp48d7SD" +
       "sa4MnvvBA79097MH+cEDO4aPXPYYb0/c+iQ1bntRcfY5+ycP//KP/t1Xfr/Y" +
       "Jvz/zwsRMc41AAA=");
}
