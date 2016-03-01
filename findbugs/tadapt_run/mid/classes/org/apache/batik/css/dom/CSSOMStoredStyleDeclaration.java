package org.apache.batik.css.dom;
public abstract class CSSOMStoredStyleDeclaration extends org.apache.batik.css.dom.CSSOMSVGStyleDeclaration implements org.apache.batik.css.dom.CSSOMStyleDeclaration.ValueProvider, org.apache.batik.css.dom.CSSOMStyleDeclaration.ModificationHandler, org.apache.batik.css.engine.StyleDeclarationProvider {
    protected org.apache.batik.css.engine.StyleDeclaration declaration;
    public CSSOMStoredStyleDeclaration(org.apache.batik.css.engine.CSSEngine eng) {
        super(
          null,
          null,
          eng);
        valueProvider =
          this;
        setModificationHandler(
          this);
    }
    public org.apache.batik.css.engine.StyleDeclaration getStyleDeclaration() {
        return declaration;
    }
    public void setStyleDeclaration(org.apache.batik.css.engine.StyleDeclaration sd) {
        declaration =
          sd;
    }
    public org.apache.batik.css.engine.value.Value getValue(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getValue(
                    i);
            }
        }
        return null;
    }
    public boolean isImportant(java.lang.String name) {
        int idx =
          cssEngine.
          getPropertyIndex(
            name);
        for (int i =
               0;
             i <
               declaration.
               size(
                 );
             i++) {
            if (idx ==
                  declaration.
                  getIndex(
                    i)) {
                return declaration.
                  getPriority(
                    i);
            }
        }
        return false;
    }
    public java.lang.String getText() { return declaration.
                                          toString(
                                            cssEngine);
    }
    public int getLength() { return declaration.size(
                                                  );
    }
    public java.lang.String item(int idx) { return cssEngine.
                                              getPropertyName(
                                                declaration.
                                                  getIndex(
                                                    idx));
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
      ("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");
}
