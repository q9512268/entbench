package org.apache.batik.svggen;
public abstract class AbstractSVGFilterConverter implements org.apache.batik.svggen.SVGFilterConverter, org.apache.batik.svggen.ErrorConstants {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    protected java.util.Map descMap = new java.util.HashMap();
    protected java.util.List defSet = new java.util.LinkedList();
    public AbstractSVGFilterConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public java.util.List getDefinitionSet() { return defSet; }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "edMZe4FBC0E3hrJq3g7/jy7/8OrLEz8u5rXA/NyY5+Kr/0e3HNn33mcZRmZo" +
       "l6VOcfH3+8ceb+i45xrjt2GHcs9JZmYmAGab987T8U+8zUW/8aLiflQtmpVz" +
       "nyAnaDD3Q7VoWOU0VNdp8+mVHy9z2lKwOsMNeY5l3YBnZ0ToU2rar3BhXCU9" +
       "RXqgrWb4t7oxzoNYJ8BY5rF2Pm0WWpBSqukqgV3iqAtVKvKIhTvQgCvI6Pgy" +
       "jqi0vZs267nIlTl9sSNdE7rMYnPJxTk06eGa0CaYueFc3AQVR7EhQvRQj3c6" +
       "Lb1K9iagrugRhlmBHBa/17x/7xeLbyznPtuUldpRSy+dWF7VdPophZO3ZBee" +
       "XkW/t+v8E+qfr3mtCjkbC6e8z+i68MK698MsDZXQ6mOj5QuOuqJdH3DkwOp0" +
       "q9bAd8W0yxVej277rxaGIASujFIcbjn+jVIcR+mVFSvEKkP/h6tRlJ2egUn2" +
       "0Z594ScrDi78xhPc8LNzwJFN/4uvXbl4fOTMGE+K1PyQenJduzPv+rRGmpun" +
       "zrOd6JO1Xx7/8GrfZq+Zkipp80DSSncVNkiDD9PBaArMPamKts7tSFx20ZLj" +
       "f9/znTe7oQQLoJKEIu1I4EA0HWKKjUTE4Vn2/dKGHdOtPocfD3z/ph91JzrA" +
       "3aq2w7xrNaUuW5qWpPMEeVqh68KH3tvEh0XwLTc9eXkOfFDy4kMubiitojgG" +
       "6M5Yvp6+bC18p0zGUxbjZsa4hWsQpg1JnValM8/zOmrIfVz0z0G3QdQ8Bklm" +
       "h3Av7S4iqEQw70Y2jLOfKmTeQq3fzuLQTuZea++teQor153LYpmXi2WNrrP8" +
       "wF+eaGzOzPUkwZ5TTu4bPRHtfnIJj87a9Gv+GiURf/qP//qd79iV17LcGUuJ" +
       "qi2S8RCW07SiQe6Ggy72YmPn+xWXJgouH6kvz7zhUUmNOe5vrbnj2r3AK/v+" +
       "1rDxnsGtt3F1m+UylFvkqa6x19bOE4942aMTLy8yHqvSmdrSI75MxyShK+kx" +
       "3pxyHuZ1TfAFTOcJuAPO9l0Wba2Zl5JcrHlK8SN55kZp831We5DVOCYp7OIF" +
       "QUvHDTuKDt8KVtJKYDrQzoa/m9Kgnk61wBcyNQjlUT5XRBbCDgXZVVVV5xHq" +
       "Ut3G9ew1RUiHJEikIRPlz9RN7Ph18chqK4P000aiQZen6nbJ8O+ufXf74x88" +
       "zQPQXWK7iPHB0UOf+w6P8mDk76VzMp4snTz8zZQnk9TuZudbhXF0vn9m94tP" +
       "7T5gabaforUKN2GcHVQZ0Y/yONIYbR4lqJxL4Q+0FppVM/Cm9bvPMcEc67Hb" +
       "d6wkQQ25X61oNVqf8ZbO33/FZ05UlUw7cf+f2MtJ6o22HMrAWEKWndcDR79I" +
       "0yEymJbl/LLAs+5ZgqblgGmwJu8wFZ7j9M+DIdz04NLst5PuRYLKbDoQxTtO" +
       "knMEFQAJ7b6sZbEyvyUlPQ7cNpMdM/rUWxk9xeJ8WKGezv6XYUVNImSWdGdO" +
       "rN+w68byJ/nDjigLIyNUymSogfgbUwqDZ+eUZskqWjf/ZuWzpXMtz6zhG7bB" +
       "YbrD69rBQTV64g2uVw+jJfX48dbJledeP1h0CWJqE/IIBE3ZlHmfTGoJSBCb" +
       "gtmqPchQ7EGmrezq1gufve2pZdd2E0ca83GExaPnLodimvaYF5UGUCEEHk6y" +
       "y+7qnUoPFof0tOKxKKImlNS/PSqpewo0WphlTINWpEbpwyBBzZnokPlYWiar" +
       "w1hfRaWzvOTKWglNc84yyw5wMKGWBl8LB7s0zSxKiw8xy2sai8ZLDB/+A9y5" +
       "OGKwHAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "L7/BBycAAA==");
}
