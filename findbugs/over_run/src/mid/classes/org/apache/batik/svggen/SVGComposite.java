package org.apache.batik.svggen;
public class SVGComposite implements org.apache.batik.svggen.SVGConverter {
    private org.apache.batik.svggen.SVGAlphaComposite svgAlphaComposite;
    private org.apache.batik.svggen.SVGCustomComposite svgCustomComposite;
    public SVGComposite(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        this.
          svgAlphaComposite =
          new org.apache.batik.svggen.SVGAlphaComposite(
            generatorContext);
        this.
          svgCustomComposite =
          new org.apache.batik.svggen.SVGCustomComposite(
            generatorContext);
    }
    public java.util.List getDefinitionSet() { java.util.List compositeDefs =
                                                 new java.util.LinkedList(
                                                 svgAlphaComposite.
                                                   getDefinitionSet(
                                                     ));
                                               compositeDefs.addAll(
                                                               svgCustomComposite.
                                                                 getDefinitionSet(
                                                                   ));
                                               return compositeDefs;
    }
    public org.apache.batik.svggen.SVGAlphaComposite getAlphaCompositeConverter() {
        return svgAlphaComposite;
    }
    public org.apache.batik.svggen.SVGCustomComposite getCustomCompositeConverter() {
        return svgCustomComposite;
    }
    public org.apache.batik.svggen.SVGDescriptor toSVG(org.apache.batik.ext.awt.g2d.GraphicContext gc) {
        return toSVG(
                 gc.
                   getComposite(
                     ));
    }
    public org.apache.batik.svggen.SVGCompositeDescriptor toSVG(java.awt.Composite composite) {
        if (composite instanceof java.awt.AlphaComposite)
            return svgAlphaComposite.
              toSVG(
                (java.awt.AlphaComposite)
                  composite);
        else
            return svgCustomComposite.
              toSVG(
                composite);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "msbj7xI2e/4Lnm+bc78dAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "N1xtx5N+g49kdEmXm6LQXFWmhE4brDKlR7QWTCU6kSZjK9T4iid0Kk5dn06B" +
       "Wc5bFWua+dyETMZ9jG2OjUmLxIaC1aqXRLc1TqbbJcONHAabTyphI1r1XXa7" +
       "8CO4iXaWXDPsyzzmkuJUtYlaX8/ayXSCLci21PDUelkU+2VirHUlBF/Hy+l8" +
       "MthIclSpwkLXJPuEuSLmAV1t2xNrVLdTplKRkk29LdvrrugZsTeQTU6QseGm" +
       "MRzjZlmek5VRR1yu2Wy9GCi9NgaaY0tNjdFKH47taIKgzKSpWfwMx32Gd7OV" +
       "OBPrzkRf4Ut3VCsTvDmehaSqdFCzJU3Noa+vtnY1XJHtcjiV+gI6nhkcnbEb" +
       "Y75I0BY/nSEtqp/QhthP9XmL2pT7jcHA1ur1YB5v0Y4lkIS+WAs9pq0bw0jL" +
       "xsloLC0qIb6pTG1ipZgLlmOr4aiVSFZpQbRxtZvhVWneqGJSjGwFVNHC6sYS" +
       "9Z7rhzCd8uK8s1XmyKg0s2PKWQ+UiSNY3fUgijfYtmfNsMpm7fMrZiPN8Q1q" +
       "dYjeOlWbJR/rpFXDbDIbz2VmuuQp0wWtGROZD9vygCcxhpQcymgv6tMpzxNR" +
       "pRkPmFmChPTMM8RqrUJ33QlATWSNzOVKQjOZTQaE07c8lKxMgQ1g/soMVhRm" +
       "j2aDPsOlG8pItzprrxF0O67325Jrki2yNRnMJBqLHL+OomK2HRLduL1c8SRj" +
       "wGoHFkoybUwzumu53Raq0p7teEOnNe+QrS3ddWjXHMx0TYrmGMpEXq866lOR" +
       "a1dUospP0C3ZcSatIPXGK5JejSfTcMbMepWIWsFBnTPqMZsGdUleCOtFuKKS" +
       "VbjRa1YyYc2YsNuIbi+qxNjOplWkJSiN5dpviHgFZwPe18qymdUkAePasi6O" +
       "jHG7069uaISazqiA6mwlK23OjRq2VBh4aVVkImmPmTZG0JJij1pB1pxbQ5Pm" +
       "y4KEd3DPbPGB2E+E7WpUq5S73U6yDQUf3lI+ylCNzEjIAT6wuHjMt6qutWLW" +
       "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");
}
