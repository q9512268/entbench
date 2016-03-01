package org.apache.batik.bridge;
public abstract class SVGDescriptiveElementBridge extends org.apache.batik.bridge.AbstractSVGBridge implements org.apache.batik.bridge.GenericBridge, org.apache.batik.bridge.BridgeUpdateHandler, org.apache.batik.dom.svg.SVGContext {
    org.w3c.dom.Element theElt;
    org.w3c.dom.Element parent;
    org.apache.batik.bridge.BridgeContext theCtx;
    public SVGDescriptiveElementBridge() { super(); }
    public void handleElement(org.apache.batik.bridge.BridgeContext ctx, org.w3c.dom.Element e) {
        org.apache.batik.bridge.UserAgent ua =
          ctx.
          getUserAgent(
            );
        ua.
          handleElement(
            e,
            java.lang.Boolean.
              TRUE);
        if (ctx.
              isDynamic(
                )) {
            org.apache.batik.bridge.SVGDescriptiveElementBridge b;
            b =
              (org.apache.batik.bridge.SVGDescriptiveElementBridge)
                getInstance(
                  );
            b.
              theElt =
              e;
            b.
              parent =
              (org.w3c.dom.Element)
                e.
                getParentNode(
                  );
            b.
              theCtx =
              ctx;
            ((org.apache.batik.dom.svg.SVGOMElement)
               e).
              setSVGContext(
                b);
        }
    }
    public void dispose() { org.apache.batik.bridge.UserAgent ua =
                              theCtx.
                              getUserAgent(
                                );
                            ((org.apache.batik.dom.svg.SVGOMElement)
                               theElt).setSVGContext(null);
                            ua.handleElement(theElt, parent);
                            theElt = null;
                            parent = null; }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.apache.batik.bridge.UserAgent ua =
          theCtx.
          getUserAgent(
            );
        ua.
          handleElement(
            theElt,
            java.lang.Boolean.
              TRUE);
    }
    public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        dispose(
          );
    }
    public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        
    }
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        
    }
    public void handleOtherAnimationChanged(java.lang.String type) {
        
    }
    public float getPixelUnitToMillimeter() {
        return theCtx.
          getUserAgent(
            ).
          getPixelUnitToMillimeter(
            );
    }
    public float getPixelToMM() { return getPixelUnitToMillimeter(
                                           );
    }
    public java.awt.geom.Rectangle2D getBBox() {
        return null;
    }
    public java.awt.geom.AffineTransform getScreenTransform() {
        return theCtx.
          getUserAgent(
            ).
          getTransform(
            );
    }
    public void setScreenTransform(java.awt.geom.AffineTransform at) {
        theCtx.
          getUserAgent(
            ).
          setTransform(
            at);
    }
    public java.awt.geom.AffineTransform getCTM() {
        return null;
    }
    public java.awt.geom.AffineTransform getGlobalTransform() {
        return null;
    }
    public float getViewportWidth() { return theCtx.
                                        getBlockWidth(
                                          theElt);
    }
    public float getViewportHeight() { return theCtx.
                                         getBlockHeight(
                                           theElt);
    }
    public float getFontSize() { return 0;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "hoH7NHIXFiX/A07pgbDlKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BPtb58D+dh7947j07lOWnmiuv7mxoX/1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("diC+tkd87ceE+F+cg/i38uifnfTtVhyHh/a9EeTv3CrkBggv7yG//GMZ8i9c" +
       "NwkrUXSgeYblaQc4x3WLp+PB/+/OUdB/zKN/G5fesVPQ6dpnVPPbt6qa50GQ" +
       "96qRfiyquf722uH6pOVZbn6lgLI2Wu4DlryOteImRdHufz1HR/8tj37/iC0O" +
       "WzpqBXCHZ1zHFt+7HY6k7LWl3Paxs7ss+MfnwP5RHv1RXHrPDvYoNrVwhx1M" +
       "LTfG/D9vAfPDhx5i7zHbtwfzCUgX7j0n7/48ujMuPW5oMWslmjPzrHjq05bj" +
       "WK4W79fAZ5ZCd+mOL8VHCrhw160q4MlSfhVm9xfffgU8fk7eE3n0aFx64FAB" +
       "ADydpz14jO8dt4DvsTzxKRDSPb709uO7ek7eB/LoabDWA/jabf/ocsy7i5se" +
       "0jY+MDRAFhNNAet4w9HgzjHuZ24B93vyxA+BkO1xZ7cfN3xOHppHH4pLjwDc" +
       "nBJqmjcNJS/Kr5QequDJ0ypo6TqYAk6XKtRwcKucVgfhlb0aXrk9ajjmtAv1" +
       "Au9L5+iinUcvAl1E1+niNJVd+MitWvxZED6xh/qJ229x6pw8Jo/6cekSsDg+" +
       "LcZw/RjZ4Hb48if3yD55+5EJ5+SJecTtfLnv+LLknLTfSZTTW2Xi3H6v7lG+" +
       "evtRqufk6Xl0LS5dASh5S9sGfhjPLbX43uEkG798qxifA+FTe4yfuv0Yg3Py" +
       "8guyF+y49PAJjAPNMsz4DEjnVkG+F4TX9iBfu/0gf/acvJ/Lo21cuh+A7Ple" +
       "zFmZdgZe8nbgJWA1ds53GPml8sev+0Bs91GT8ktvXL7nsTdmv1V8inD04dG9" +
       "VOkefe04J+8An3i+FISabhU6uHd3IzgogH0qLj12k+NDQDvy0TnjhT+9K/8a" +
       "cOaz5cHqqfh/stxn4tJ9x+VAU7uHk0U+G5fuAEXyx88FhxPY8zc7y2ztT1aB" +
       "1nY6SnZ7hcdPOkyxdn3krQxxVOXkJwz5oWTx5d7hAeJ69+3eNeXrbxDMz/yg" +
       "/pXdJxSKI2VZ3so9VOnu3dccRaP5IeSzN23tsK1Lg+d/+NA37n3/4YHpQzuB" +
       "j533hGxP3/h7ha4bxMUXBtmvPPa3P/JX3/id4h7r/wVAnyuOUjkAAA==");
}
