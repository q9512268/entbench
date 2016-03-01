package org.apache.batik.bridge;
public class SVGTextElementBridge extends org.apache.batik.bridge.AbstractGraphicsNodeBridge implements org.apache.batik.dom.svg.SVGTextContent {
    protected static final java.lang.Integer ZERO = new java.lang.Integer(
      0);
    public static final java.text.AttributedCharacterIterator.Attribute TEXT_COMPOUND_DELIMITER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_DELIMITER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXT_COMPOUND_ID =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXT_COMPOUND_ID;
    public static final java.text.AttributedCharacterIterator.Attribute
      PAINT_INFO =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        PAINT_INFO;
    public static final java.text.AttributedCharacterIterator.Attribute
      ALT_GLYPH_HANDLER =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ALT_GLYPH_HANDLER;
    public static final java.text.AttributedCharacterIterator.Attribute
      TEXTPATH =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        TEXTPATH;
    public static final java.text.AttributedCharacterIterator.Attribute
      ANCHOR_TYPE =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        ANCHOR_TYPE;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONT_FAMILIES =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONT_FAMILIES;
    public static final java.text.AttributedCharacterIterator.Attribute
      GVT_FONTS =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        GVT_FONTS;
    public static final java.text.AttributedCharacterIterator.Attribute
      BASELINE_SHIFT =
      org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
        BASELINE_SHIFT;
    protected java.text.AttributedString laidoutText;
    protected java.util.WeakHashMap elemTPI = new java.util.WeakHashMap(
      );
    protected boolean usingComplexSVGFont = false;
    public SVGTextElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_TEXT_TAG;
    }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGTextElementBridge(
                                                            );
    }
    protected org.apache.batik.gvt.TextNode getTextNode() {
        return (org.apache.batik.gvt.TextNode)
                 node;
    }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.TextNode node =
          (org.apache.batik.gvt.TextNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (node ==
              null)
            return null;
        associateSVGContext(
          ctx,
          e,
          node);
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                addContextToChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
        if (ctx.
              getTextPainter(
                ) !=
              null)
            node.
              setTextPainter(
                ctx.
                  getTextPainter(
                    ));
        java.awt.RenderingHints hints =
          null;
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertColorRendering(
              e,
              hints);
        hints =
          org.apache.batik.bridge.CSSUtilities.
            convertTextRendering(
              e,
              hints);
        if (hints !=
              null)
            node.
              setRenderingHints(
                hints);
        node.
          setLocation(
            getLocation(
              ctx,
              e));
        return node;
    }
    protected org.apache.batik.gvt.GraphicsNode instantiateGraphicsNode() {
        return new org.apache.batik.gvt.TextNode(
          );
    }
    protected java.awt.geom.Point2D getLocation(org.apache.batik.bridge.BridgeContext ctx,
                                                org.w3c.dom.Element e) {
        try {
            org.apache.batik.dom.svg.SVGOMTextPositioningElement te =
              (org.apache.batik.dom.svg.SVGOMTextPositioningElement)
                e;
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            float x =
              0;
            if (xs.
                  getNumberOfItems(
                    ) >
                  0) {
                x =
                  xs.
                    getItem(
                      0).
                    getValue(
                      );
            }
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            float y =
              0;
            if (ys.
                  getNumberOfItems(
                    ) >
                  0) {
                y =
                  ys.
                    getItem(
                      0).
                    getValue(
                      );
            }
            return new java.awt.geom.Point2D.Float(
              x,
              y);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected boolean isTextElement(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            SVG_TEXT_TAG) ||
          nodeName.
          equals(
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
    }
    protected boolean isTextChild(org.w3c.dom.Element e) {
        if (!SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    )))
            return false;
        java.lang.String nodeName =
          e.
          getLocalName(
            );
        return nodeName.
          equals(
            SVG_TSPAN_TAG) ||
          nodeName.
          equals(
            SVG_ALT_GLYPH_TAG) ||
          nodeName.
          equals(
            SVG_A_TAG) ||
          nodeName.
          equals(
            SVG_TEXT_PATH_TAG) ||
          nodeName.
          equals(
            SVG_TREF_TAG);
    }
    public void buildGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                  org.w3c.dom.Element e,
                                  org.apache.batik.gvt.GraphicsNode node) {
        e.
          normalize(
            );
        computeLaidoutText(
          ctx,
          e,
          node);
        node.
          setComposite(
            org.apache.batik.bridge.CSSUtilities.
              convertOpacity(
                e));
        node.
          setFilter(
            org.apache.batik.bridge.CSSUtilities.
              convertFilter(
                e,
                node,
                ctx));
        node.
          setMask(
            org.apache.batik.bridge.CSSUtilities.
              convertMask(
                e,
                node,
                ctx));
        node.
          setClip(
            org.apache.batik.bridge.CSSUtilities.
              convertClipPath(
                e,
                node,
                ctx));
        node.
          setPointerEventType(
            org.apache.batik.bridge.CSSUtilities.
              convertPointerEvents(
                e));
        initializeDynamicSupport(
          ctx,
          e,
          node);
        if (!ctx.
              isDynamic(
                )) {
            elemTPI.
              clear(
                );
        }
    }
    public boolean isComposite() { return false;
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return n.
          getFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return n.
          getNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return n.
          getParentNode(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener
      childNodeRemovedEventListener;
    protected class DOMChildNodeRemovedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMChildNodeRemovedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMChildNodeRemovedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6fhxUZbO/uiBP3jL7zz/raI09r/kP4Vynx8AAA==");
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener
      subtreeModifiedEventListener;
    protected class DOMSubtreeModifiedEventListener implements org.w3c.dom.events.EventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            handleDOMSubtreeModifiedEvent(
              (org.w3c.dom.events.MutationEvent)
                evt);
        }
        public DOMSubtreeModifiedEventListener() {
            super(
              );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL05a8zjWHWeb3Z2Z2YfM7vA7nbLPhlod00/x4kTOxqg6zh2" +
           "nMR5OE6cOKUMfseJX7EdPwLbAhKPlgpW7UKpBPsL1BYtD1VFrVRRbVW1gECV" +
           "qFBfUgFVlUpLkdgfpVVpS6+d+Z4zs6tVpUbKzc2955x73j73+IUfQOfCAIJ9" +
           "z85M24v29TTaX9rV/Sjz9XC/w1WHchDqGmXLYTgGa9fUJ7546Uc/fnZxeQ+6" +
           "fQ69RnZdL5Ijy3PDkR56dqxrHHTpaJW2dSeMoMvcUo5lZBNZNsJZYXSVg+48" +
           "hhpBV7gDFhDAAgJYQAoWEPIICiDdrbsbh8oxZDcK19AvQWc46HZfzdmLoMdP" +
           "EvHlQHaukxkWEgAK5/P/IhCqQE4D6LFD2Xcy3yDwx2Dkud98x+XfOwtdmkOX" +
           "LFfI2VEBExE4ZA7d5eiOogchqWm6NofudXVdE/TAkm1rW/A9h+4LLdOVo02g" +
           "HyopX9z4elCceaS5u9RctmCjRl5wKJ5h6bZ28O+cYcsmkPX+I1l3EjL5OhDw" +
           "ogUYCwxZ1Q9QbltZrhZBj57GOJTxShcAANQ7HD1aeIdH3ebKYAG6b2c7W3ZN" +
           "RIgCyzUB6DlvA06JoIduSTTXtS+rK9nUr0XQg6fhhrstAHWhUESOEkGvOw1W" +
           "UAJWeuiUlY7Z5wf9t3zkXS7r7hU8a7pq5/yfB0iPnEIa6YYe6K6q7xDveor7" +
           "uHz/lz+0B0EA+HWngHcwf/Dul55+8yMvfnUH89M3gRkoS12NrqmfVu755uup" +
           "J+tnczbO+15o5cY/IXnh/sPrO1dTH0Te/YcU8839g80XR38uveez+vf3oItt" +
           "6HbVszcO8KN7Vc/xLVsPWrqrB3Kka23ogu5qVLHfhu4Ac85y9d3qwDBCPWpD" +
           "t9nF0u1e8R+oyAAkchXdAeaWa3gHc1+OFsU89SEIugd8IQ6CziRQ8dn9RpCD" +
           "LDxHR2RVdi3XQ4aBl8ufG9TVZCTSQzDXwK7vIQrw/9XPofs4EnqbADgk4gUm" +
           "IgOvWOi7TUQJLM3UEUFsjUE05dlCd6NGsbifu53//31gmmvgcnLmDDDO60+n" +
           "BhtEFevZmh5cU5/bNOiXPn/t63uHoXJddxHEgVP3d6fuF6fu707dv9mpV5qD" +
           "nrBRokDXe55mgWDX6Bjs5mkyNzN05kzBzGtz7nZeAmy8AtkCANz1pPCLnXd+" +
           "6ImzwD395LbcTAAUuXU6p47yS7vIoipwcujFTyTvFX+5tAftnczLuURg6WKO" +
           "Psyz6WHWvHI6Hm9G99IHv/ejL3z8Ge8oMk8k+usJ40bMPOCfOK37wFN1DaTQ" +
           "I/JPPSZ/6dqXn7myB90GsgjInJEMPB0kpUdOn3Ei8K8eJNFclnNAYMMLHNnO" +
           "tw4y38VoEXjJ0UrhFPcU83uBjnvQbjgZGvnua/x8fO3OiXKjnZKiSNJvFfxP" +
           "/c1f/HOlUPdBPr907Akp6NHVYzkkJ3apyBb3HvnAGPgLgPv7Twx/42M/+OAv" +
           "FA4AIN5wswOv5CMFcgcwIVDz+7+6/tvvfPvT39o7cpoIPEQ3im2p6U7In4DP" +
           "GfD9n/ybC5cv7OL/Pup6EnrsMAv5+clvOuIN5CMbhGjuQVcmrlN4tazYeu6x" +
           "/3XpjeiX/vUjl3c+YYOVA5d68ysTOFr/qQb0nq+/498fKcicUfPn4ZH+jsB2" +
           "SfY1R5TJIJCznI/0vX/58G99Rf4USNcgRYbWVi+yHlToAyoMWCp0ARcjcmqv" +
           "nA+PhscD4WSsHatbrqnPfuuHd4s//OOXCm5PFj7H7d6T/as7V8uHx1JA/oHT" +
           "Uc/K4QLAYS/2337ZfvHHgOIcUFRBrgsHAUhM6QkvuQ597o6/+5M/vf+d3zwL" +
           "7THQRduTNUYuAg66ADxdDxcgp6X+zz+9c+fkPBguF6JCNwi/c5AHi39nAYNP" +
           "3jrXMHndchSuD/7nwFbe9w//cYMSiixzk8f1Kfw58sInH6Le9v0C/yjcc+xH" +
           "0huTNajxjnDLn3X+be+J2/9sD7pjDl1WrxeQomxv8iCag6IpPKgqQZF5Yv9k" +
           "AbR72l89TGevP51qjh17OtEcPSTAPIfO5xePDP5kegYE4rnyPr5fyv8/XSA+" +
           "XoxX8uFndlrPpz8LIjYsClGAYViubBd0noyAx9jqlYMYFUFhClR8ZWnjBZnX" +
           "gVK88I5cmP1dNbfLVflY2XFRzGu39IarB7wC699zRIzzQGH44X989hsffcN3" +
           "gIk60Lk4Vx+wzLET+5u8Vv7ACx97+M7nvvvhIgGB7DP8OH356Zxq9+Ukzodm" +
           "PtAHoj6UiyoUT3pODqODx2ch7ct65jCwHJBa4+uFIPLMfd9ZffJ7n9sVeafd" +
           "8BSw/qHnfvUn+x95bu9Yaf2GG6rb4zi78rpg+u7rGg6gx1/ulAKD+acvPPNH" +
           "v/PMB3dc3XeyUKTBPehzf/Xf39j/xHe/dpMK5Dbb+z8YNrrzeywWtsmDD4dK" +
           "yjSZpKmjDyqE0qoQvNJRaZKoNSyrVRkJo4Y9XXGDpiy5MSt21iYqS7VqZewa" +
           "WFDRpJkxHS432II2I2ZZ55lONhHDKWL1/VaHHokeKq9NOxXlRdeWeaFfdjNP" +
           "kGNYHq4bzLBGi8GoX6m68029ohBV1xlnFa3CLh13ZujLsg4+6qZSItGlh9a6" +
           "TQllW+rWbi7TzoBwQ73EBxpCLt2eNLKH6/IY1oeVWdBPyq5XW5TZbmUgOZqU" +
           "8tgcbTuLgd734ilWa3bCtcpjIy+mRWEeYmkHp8ac0VOV0VTD5hnab4gujyqt" +
           "DU2NcErjW2WpJ0bDDZb0dN6Tyj7Jo9aSajliPO2SsTn3JxaBY1RdFrmBOdyy" +
           "7NzlYCNBGwG2tPTECziN7ndqJB5k9chr4dOew7tNyW0Jc4RdpmZfb5OYw1om" +
           "xxMwx40Qw1hySjfsJg1/46SSwG2tRcq1Bl2ZdCeYRwxa1Nh16abBM5NORHnm" +
           "liHDibaYmJOSWObGZpARDLpUxyWigk6JtiZGjYmAihuaHiiCL/LKYKD6meQr" +
           "pNSvq9vtTEhayladxkJ5NYDHVqm+mSymBFKO18tuxGdL2y+pWKZ4WHvUbErz" +
           "BUYJs04gbe1qv133MHnZW2DTIY0GrcW2EswV1yhRo96WyRo8RYaGRjlpOq/C" +
           "AUWNsU4crcMss+Cq3eha4BAva/gYOdtGxKw2Zc1KorKt7SQZk7iZMHjF59aC" +
           "Vpk02tWumI7qS7Y0b7Qa/kyqJQEzU9dRQPfaTbkz4XsKjXlSQsJq0qHlLCM9" +
           "qpyIK9pfbmdMzRL0NuW0NmEnE8YrZmKWLJpNOnw5bkqr9njesrUuvWkg/QSL" +
           "hrEqwVKjh3mWxPVbYnuoxIk31SR1upy3eyHvqCTuJOuxkTYHVUwf17o0acVN" +
           "3uacOazGnO3qiCGsUc7BHXE1ijjWUn2htp6Vak5cqbeQutGYVLxqVV6GtfEM" +
           "7lYHLbGj1KR4jDH+wPNkeCoQPW5VgsNNPDQwFRbDSZ+vLabRJKs0tuaaLqOq" +
           "zVcsrmw4vXFr2Vo01+2WNA1giS110BKNeB2/tWxXnR5fN/n1UqEn3ZKNeCo/" +
           "n5BME6WXdXayldJZjeEGYQ24BO+YqMGQlKeaJdpFMqfWUleBmI169LrvzsYT" +
           "v1tOjYpLjaYqn249edvgOGHShzswoZQ0woY7UmCWSZFKcT5skZaVjValQEaD" +
           "ScfzEq08I6TxYug2yt3MmLaTrcOwSJ1Qqu6KRlcp2/YpVSe4idSj/IFDzlsB" +
           "M655XVyBmw5Vc2cdfYtNDMZKUZLSvAo30/sWii/VvoKrQdBiR57CVprClpJa" +
           "Ad82moGJ9hIhdaVq1WHaq7YE4xa6ciZ8G3NNASW9lhuU++qQ9eN4zXew0sZe" +
           "u5bEV8RO2TBmeMR0MQrl1tXpZhnVq4SHtKrdtkcRtfECjrl4xSw7rNCN+X4k" +
           "WLy0EjercndMrSexC0/70iBiRwBOGE2qxFgzhbgh15LGwupzpXrWs+obmo/H" +
           "yaxTmxJVAh62xDkshW666OK+S9VFq7yK+/3xdolKujaWN8BrGMCLYksMM2la" +
           "PJP2koRtjq10gKcspSMlZmypMNoeNh01HGBqf2hPzMpKnkYy6hulkRl6pYqc" +
           "TYjBKKUaZlBDiLYUG8tygMDZpCRkKjMoNbo41lO5GrnZ0rYy4Vgn2JZmE2lF" +
           "LrIYh/nhECktx322oYxILMLtvrdNo0VdopR2kza2zjozdFhv1oVynTHGZobS" +
           "jcgiWp2O6OsbdjjrIOTMVOsI3NbH1ALmq31Ox7esmlocM1HwKhMRRLsZNiOW" +
           "IdIGVlZhro1xowbMsphIxA4rIHVEzIItZzbayYxUOHhLugjRQ2IeqxGIvo6U" +
           "ddvxEI5DedjiBH5uYOVYl+sRtog2o2EFrSMzTU9GxoIzm7BmjOZtyxStOWmu" +
           "1CE+EpJJScd623Gl7VTN8YJ1fYH3JiPBRTNFheUlnpW0qZJEgbC21hLsMD04" +
           "A6c05mZYplcO2u1W8Z5mc7qmK9SiRyR4AzxiGtNZhUvRmt8XpY1ZUZbhoNwN" +
           "qKhXbjf7+pwrDUYdtC7UYaRvaI0MF72pZdaWo5Ajy1ZvOueTEqltOitTnG3r" +
           "dIT7FDuua1TJci0zNJep16pLQ7/UBGFMk84c5G53WdHqhsEQ5ETlNooDV+GW" +
           "vpWbCOeUS4KPZ/hQJHrLeSOaWXSJnJdGJb1uydTQRXRHk+1sq7osJWhZx66Q" +
           "1SVs1AR/2lv32puh0krW7RKxKQ2nLbhso6BkYDhkiCCKEWO+Aff6QYYmeCRi" +
           "disY90Z+3OW8/mKiz6ojTgngdXldr+Jr2VojDdxycNMLK+hmXlV7Sjzk6Fld" +
           "1RCHK5e7qgmT5UW3LYqI28QIJ8aj2mI4mkwX3cCpBz0ymmn8bNnQQnkx8DK6" +
           "smEWdZ9x9KWfWCTj4/HMXC4EniA7RN/lt1xKOBY1Z8hKUydwFqXVUpB567WZ" +
           "jEhrNHFSVFS703AwCLp4s9PGt1VqNQhCv0GY2IIx25uoi28zpVli68RgImZq" +
           "oMIlY8zicQKrdifsM9rEkrYUrCLCCFZWrDXBMQK3SgHi9YPqIGo6/aDrIHFG" +
           "BpMApzrT5hCvZtF2aCwblc5mXR2oI74+F+ysbnBcVOtlm2YFmcJhYhrlKskw" +
           "Wm3JUqY7RxynOxxS3hrOtK5Wb9XMDccZU81KEGQc8aPU0Dga3Y5bmpqQntn3" +
           "An1atoQlRehKpxuNCX7GetyAkqRGpzyi9THtV60aOw2bKfDHNt4lNXss9+JG" +
           "zV91sqXVs3mmHST4iI9G8kKktxo8UA2bz1ZGtzyzZlyrsll1K9bKIaMkoIMK" +
           "yI6u27SFLWzP7BWhD6zUSQi4Ww4XqEptQ7ijUb26Op3R4mY6H4+mJWamTNgo" +
           "qurIlGtWTW4qOGvg16CUYBvrkdbKOJufDzjGMo3mwNfQWaVqxTFfc6uU1ZXa" +
           "ypQly0ToTFcelyYmbw07XptmYwsVGnxkSCgyiBVnWK/1o/ZG2a6HBO6LUx9k" +
           "WLFe5+bWsq4seLTZpeUB7a2GGCZrur5ozQaTNdNPOnUdpGVgsUlPJik02kyV" +
           "tIOxItupSUgiAdfoMRG3wrIwWi3coLutxNVS0uqaLdvC4aHcMOBWue/Y/aal" +
           "VEuIPVcyqjLIMLhXH1cqPg7qm6GlMw1lNh04GSYYBjlrVJHqUF+P5tOF2F0y" +
           "vbWoT0ebiBatlciwzHTQLMW+sqL5KqMLMcEN6iO53lxNQGX/1rzkf/uru3Xd" +
           "W1wwD98dgMtWvtF6FbeN9OYHgsvvBT/wInDB1rX0sNtW9B3ufplu27GOxJmD" +
           "W+5jeQs2qaj7mufs63k/Ndw/0VbN72AP3+qlQnH/+vT7nnteG3wG3bve8pmC" +
           "K/f1dz3HDwygp2590ewVL1SO+hBfed+/PDR+2+Kdr6LT+ugpJk+T/N3eC19r" +
           "vUn99T3o7GFX4oZXPSeRrp7sRVwM9GgTuOMTHYmHD/V/KVf3U0DUd1/X/7tv" +
           "3u28uU0LJ9q5zql22pmTFnvwVhYrkOOX6cVt82EdQXcuZFez9QKpABwdc0QR" +
           "XIpjz9KOPDR4pfvwibYXUOorNOoPBHnzq+n+A/d58IYXkLuXZurnn790/oHn" +
           "J39d9LcPX2xd4KDzxsa2jzeTjs1v9wPdsAq9XNi1lvzi5wMR9MAtGAN+vZsU" +
           "Erx/B/8rEXT5NHwEnSt+j8P9WgRdPIIDpHaT4yAfjaCzACSfPuvfpA2166ml" +
           "Z46F1fUUUdjpvley0yHK8fZ3HorFC+CDsNnsXgFfU7/wfKf/rpdqn9m131Vb" +
           "3hYOdJ6D7ti9CTgMvcdvSe2A1u3skz++54sX3niQI+7ZMXwUEMd4e/Tm/W3a" +
           "8aOiI739wwd+/y2//fy3i67Y/wIMrcB1mR8AAA==");
    }
    protected void initializeDynamicSupport(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element e,
                                            org.apache.batik.gvt.GraphicsNode node) {
        super.
          initializeDynamicSupport(
            ctx,
            e,
            node);
        if (ctx.
              isDynamic(
                )) {
            addTextEventListeners(
              ctx,
              (org.apache.batik.dom.events.NodeEventTarget)
                e);
        }
    }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          addEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false,
            null);
        ctx.
          storeEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        e.
          removeEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    public void dispose() { removeTextEventListeners(
                              ctx,
                              (org.apache.batik.dom.events.NodeEventTarget)
                                e);
                            super.dispose(
                                    ); }
    protected void addContextToChild(org.apache.batik.bridge.BridgeContext ctx,
                                     org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.dom.svg.SVGOMElement)
                   e).
                  setSVGContext(
                    new org.apache.batik.bridge.SVGTextElementBridge.TspanBridge(
                      ctx,
                      this,
                      e));
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.dom.svg.SVGOMElement)
                       e).
                      setSVGContext(
                        new org.apache.batik.bridge.SVGTextElementBridge.TextPathBridge(
                          ctx,
                          this,
                          e));
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
                        ((org.apache.batik.dom.svg.SVGOMElement)
                           e).
                          setSVGContext(
                            new org.apache.batik.bridge.SVGTextElementBridge.TRefBridge(
                              ctx,
                              this,
                              e));
                    }
        }
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                addContextToChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
    }
    protected void removeContextFromChild(org.apache.batik.bridge.BridgeContext ctx,
                                          org.w3c.dom.Element e) {
        if (SVG_NAMESPACE_URI.
              equals(
                e.
                  getNamespaceURI(
                    ))) {
            if (e.
                  getLocalName(
                    ).
                  equals(
                    SVG_TSPAN_TAG)) {
                ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                   ((org.apache.batik.dom.svg.SVGOMElement)
                      e).
                   getSVGContext(
                     )).
                  dispose(
                    );
            }
            else
                if (e.
                      getLocalName(
                        ).
                      equals(
                        SVG_TEXT_PATH_TAG)) {
                    ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                       ((org.apache.batik.dom.svg.SVGOMElement)
                          e).
                       getSVGContext(
                         )).
                      dispose(
                        );
                }
                else
                    if (e.
                          getLocalName(
                            ).
                          equals(
                            SVG_TREF_TAG)) {
                        ((org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler)
                           ((org.apache.batik.dom.svg.SVGOMElement)
                              e).
                           getSVGContext(
                             )).
                          dispose(
                            );
                    }
        }
        org.w3c.dom.Node child =
          getFirstChild(
            e);
        while (child !=
                 null) {
            if (child.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                removeContextFromChild(
                  ctx,
                  (org.w3c.dom.Element)
                    child);
            }
            child =
              getNextSibling(
                child);
        }
    }
    public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                laidoutText =
                  null;
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElement =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElement)) {
                        addContextToChild(
                          ctx,
                          childElement);
                        laidoutText =
                          null;
                    }
                    break;
                }
        }
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMChildNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        switch (childNode.
                  getNodeType(
                    )) {
            case org.w3c.dom.Node.
                   TEXT_NODE:
            case org.w3c.dom.Node.
                   CDATA_SECTION_NODE:
                if (isParentDisplayed(
                      childNode)) {
                    laidoutText =
                      null;
                }
                break;
            case org.w3c.dom.Node.
                   ELEMENT_NODE:
                {
                    org.w3c.dom.Element childElt =
                      (org.w3c.dom.Element)
                        childNode;
                    if (isTextChild(
                          childElt)) {
                        laidoutText =
                          null;
                        removeContextFromChild(
                          ctx,
                          childElt);
                    }
                    break;
                }
            default:
        }
    }
    public void handleDOMSubtreeModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
        if (laidoutText ==
              null) {
            computeLaidoutText(
              ctx,
              e,
              getTextNode(
                ));
        }
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            laidoutText =
              null;
        }
    }
    protected boolean isParentDisplayed(org.w3c.dom.Node childNode) {
        org.w3c.dom.Node parentNode =
          getParentNode(
            childNode);
        return isTextElement(
                 (org.w3c.dom.Element)
                   parentNode);
    }
    protected void computeLaidoutText(org.apache.batik.bridge.BridgeContext ctx,
                                      org.w3c.dom.Element e,
                                      org.apache.batik.gvt.GraphicsNode node) {
        org.apache.batik.gvt.TextNode tn =
          (org.apache.batik.gvt.TextNode)
            node;
        elemTPI.
          clear(
            );
        java.text.AttributedString as =
          buildAttributedString(
            ctx,
            e);
        if (as ==
              null) {
            tn.
              setAttributedCharacterIterator(
                null);
            return;
        }
        addGlyphPositionAttributes(
          as,
          e,
          ctx);
        if (ctx.
              isDynamic(
                )) {
            laidoutText =
              new java.text.AttributedString(
                as.
                  getIterator(
                    ));
        }
        tn.
          setAttributedCharacterIterator(
            as.
              getIterator(
                ));
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        setBaseTextPaintInfo(
          pi,
          e,
          node,
          ctx);
        setDecorationTextPaintInfo(
          pi,
          e);
        addPaintAttributes(
          as,
          e,
          tn,
          pi,
          ctx);
        if (usingComplexSVGFont) {
            tn.
              setAttributedCharacterIterator(
                as.
                  getIterator(
                    ));
        }
        if (ctx.
              isDynamic(
                )) {
            checkBBoxChange(
              );
        }
    }
    private boolean hasNewACI;
    private org.w3c.dom.Element cssProceedElement;
    public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
        if (alav.
              getNamespaceURI(
                ) ==
              null) {
            java.lang.String ln =
              alav.
              getLocalName(
                );
            if (ln.
                  equals(
                    SVG_X_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_Y_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DX_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_DY_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_ROTATE_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_TEXT_LENGTH_ATTRIBUTE) ||
                  ln.
                  equals(
                    SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                char c =
                  ln.
                  charAt(
                    0);
                if (c ==
                      'x' ||
                      c ==
                      'y') {
                    getTextNode(
                      ).
                      setLocation(
                        getLocation(
                          ctx,
                          e));
                }
                computeLaidoutText(
                  ctx,
                  e,
                  getTextNode(
                    ));
                return;
            }
        }
        super.
          handleAnimatedAttributeChanged(
            alav);
    }
    public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
        hasNewACI =
          false;
        int[] properties =
          evt.
          getProperties(
            );
        for (int i =
               0;
             i <
               properties.
                 length;
             ++i) {
            switch (properties[i]) {
                case org.apache.batik.css.engine.SVGCSSEngine.
                       BASELINE_SHIFT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DIRECTION_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       DISPLAY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_FAMILY_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_SIZE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STRETCH_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_STYLE_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       FONT_WEIGHT_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_HORIZONTAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       GLYPH_ORIENTATION_VERTICAL_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       KERNING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       LETTER_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       TEXT_ANCHOR_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       UNICODE_BIDI_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WORD_SPACING_INDEX:
                case org.apache.batik.css.engine.SVGCSSEngine.
                       WRITING_MODE_INDEX:
                    {
                        if (!hasNewACI) {
                            hasNewACI =
                              true;
                            computeLaidoutText(
                              ctx,
                              e,
                              getTextNode(
                                ));
                        }
                        break;
                    }
            }
        }
        cssProceedElement =
          evt.
            getElement(
              );
        super.
          handleCSSEngineEvent(
            evt);
        cssProceedElement =
          null;
    }
    protected void handleCSSPropertyChanged(int property) {
        switch (property) {
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   FILL_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_OPACITY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_WIDTH_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINECAP_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_LINEJOIN_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_MITERLIMIT_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHARRAY_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   STROKE_DASHOFFSET_INDEX:
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_DECORATION_INDEX:
                rebuildACI(
                  );
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   VISIBILITY_INDEX:
                rebuildACI(
                  );
                super.
                  handleCSSPropertyChanged(
                    property);
                break;
            case org.apache.batik.css.engine.SVGCSSEngine.
                   TEXT_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertTextRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            case org.apache.batik.css.engine.SVGCSSEngine.
                   COLOR_RENDERING_INDEX:
                {
                    java.awt.RenderingHints hints =
                      node.
                      getRenderingHints(
                        );
                    hints =
                      org.apache.batik.bridge.CSSUtilities.
                        convertColorRendering(
                          e,
                          hints);
                    if (hints !=
                          null) {
                        node.
                          setRenderingHints(
                            hints);
                    }
                    break;
                }
            default:
                super.
                  handleCSSPropertyChanged(
                    property);
        }
    }
    protected void rebuildACI() { if (hasNewACI)
                                      return;
                                  org.apache.batik.gvt.TextNode textNode =
                                    getTextNode(
                                      );
                                  if (textNode.
                                        getAttributedCharacterIterator(
                                          ) ==
                                        null)
                                      return;
                                  org.apache.batik.gvt.text.TextPaintInfo pi;
                                  org.apache.batik.gvt.text.TextPaintInfo oldPI;
                                  if (cssProceedElement ==
                                        e) {
                                      pi =
                                        new org.apache.batik.gvt.text.TextPaintInfo(
                                          );
                                      setBaseTextPaintInfo(
                                        pi,
                                        e,
                                        node,
                                        ctx);
                                      setDecorationTextPaintInfo(
                                        pi,
                                        e);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            e);
                                  }
                                  else {
                                      org.apache.batik.gvt.text.TextPaintInfo parentPI;
                                      parentPI =
                                        getParentTextPaintInfo(
                                          cssProceedElement);
                                      pi =
                                        getTextPaintInfo(
                                          cssProceedElement,
                                          textNode,
                                          parentPI,
                                          ctx);
                                      oldPI =
                                        (org.apache.batik.gvt.text.TextPaintInfo)
                                          elemTPI.
                                          get(
                                            cssProceedElement);
                                  }
                                  if (oldPI ==
                                        null)
                                      return;
                                  textNode.
                                    swapTextPaintInfo(
                                      pi,
                                      oldPI);
                                  if (usingComplexSVGFont)
                                      textNode.
                                        setAttributedCharacterIterator(
                                          textNode.
                                            getAttributedCharacterIterator(
                                              ));
    }
    int getElementStartIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 startChar;
    }
    int getElementEndIndex(org.w3c.dom.Element element) {
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        if (tpi ==
              null)
            return -1;
        return tpi.
                 endChar;
    }
    protected java.text.AttributedString buildAttributedString(org.apache.batik.bridge.BridgeContext ctx,
                                                               org.w3c.dom.Element element) {
        org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb =
          new org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer(
          );
        fillAttributedStringBuffer(
          ctx,
          element,
          true,
          null,
          null,
          null,
          asb);
        return asb.
          toAttributedString(
            );
    }
    protected int endLimit;
    protected void fillAttributedStringBuffer(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element element,
                                              boolean top,
                                              org.apache.batik.gvt.text.TextPath textPath,
                                              java.lang.Integer bidiLevel,
                                              java.util.Map initialAttributes,
                                              org.apache.batik.bridge.SVGTextElementBridge.AttributedStringBuffer asb) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        java.lang.String s =
          org.apache.batik.dom.util.XMLSupport.
          getXMLSpace(
            element);
        boolean preserve =
          s.
          equals(
            SVG_PRESERVE_VALUE);
        boolean prevEndsWithSpace;
        org.w3c.dom.Element nodeElement =
          element;
        int elementStartChar =
          asb.
          length(
            );
        if (top) {
            endLimit =
              0;
        }
        if (preserve) {
            endLimit =
              asb.
                length(
                  );
        }
        java.util.Map map =
          initialAttributes ==
          null
          ? new java.util.HashMap(
          )
          : new java.util.HashMap(
          initialAttributes);
        initialAttributes =
          getAttributeMap(
            ctx,
            element,
            textPath,
            bidiLevel,
            map);
        java.lang.Object o =
          map.
          get(
            java.awt.font.TextAttribute.
              BIDI_EMBEDDING);
        java.lang.Integer subBidiLevel =
          bidiLevel;
        if (o !=
              null) {
            subBidiLevel =
              (java.lang.Integer)
                o;
        }
        for (org.w3c.dom.Node n =
               getFirstChild(
                 element);
             n !=
               null;
             n =
               getNextSibling(
                 n)) {
            if (preserve) {
                prevEndsWithSpace =
                  false;
            }
            else {
                if (asb.
                      length(
                        ) ==
                      0) {
                    prevEndsWithSpace =
                      true;
                }
                else {
                    prevEndsWithSpace =
                      asb.
                        getLastChar(
                          ) ==
                        ' ';
                }
            }
            switch (n.
                      getNodeType(
                        )) {
                case org.w3c.dom.Node.
                       ELEMENT_NODE:
                    if (!SVG_NAMESPACE_URI.
                          equals(
                            n.
                              getNamespaceURI(
                                )))
                        break;
                    nodeElement =
                      (org.w3c.dom.Element)
                        n;
                    java.lang.String ln =
                      n.
                      getLocalName(
                        );
                    if (ln.
                          equals(
                            SVG_TSPAN_TAG) ||
                          ln.
                          equals(
                            SVG_ALT_GLYPH_TAG)) {
                        int before =
                          asb.
                            count;
                        fillAttributedStringBuffer(
                          ctx,
                          nodeElement,
                          false,
                          textPath,
                          subBidiLevel,
                          initialAttributes,
                          asb);
                        if (asb.
                              count !=
                              before) {
                            initialAttributes =
                              null;
                        }
                    }
                    else
                        if (ln.
                              equals(
                                SVG_TEXT_PATH_TAG)) {
                            org.apache.batik.bridge.SVGTextPathElementBridge textPathBridge =
                              (org.apache.batik.bridge.SVGTextPathElementBridge)
                                ctx.
                                getBridge(
                                  nodeElement);
                            org.apache.batik.gvt.text.TextPath newTextPath =
                              textPathBridge.
                              createTextPath(
                                ctx,
                                nodeElement);
                            if (newTextPath !=
                                  null) {
                                int before =
                                  asb.
                                    count;
                                fillAttributedStringBuffer(
                                  ctx,
                                  nodeElement,
                                  false,
                                  newTextPath,
                                  subBidiLevel,
                                  initialAttributes,
                                  asb);
                                if (asb.
                                      count !=
                                      before) {
                                    initialAttributes =
                                      null;
                                }
                            }
                        }
                        else
                            if (ln.
                                  equals(
                                    SVG_TREF_TAG)) {
                                java.lang.String uriStr =
                                  org.apache.batik.dom.util.XLinkSupport.
                                  getXLinkHref(
                                    (org.w3c.dom.Element)
                                      n);
                                org.w3c.dom.Element ref =
                                  ctx.
                                  getReferencedElement(
                                    (org.w3c.dom.Element)
                                      n,
                                    uriStr);
                                s =
                                  org.apache.batik.bridge.TextUtilities.
                                    getElementContent(
                                      ref);
                                s =
                                  normalizeString(
                                    s,
                                    preserve,
                                    prevEndsWithSpace);
                                if (s.
                                      length(
                                        ) !=
                                      0) {
                                    int trefStart =
                                      asb.
                                      length(
                                        );
                                    java.util.Map m =
                                      initialAttributes ==
                                      null
                                      ? new java.util.HashMap(
                                      )
                                      : new java.util.HashMap(
                                      initialAttributes);
                                    getAttributeMap(
                                      ctx,
                                      nodeElement,
                                      textPath,
                                      bidiLevel,
                                      m);
                                    asb.
                                      append(
                                        s,
                                        m);
                                    int trefEnd =
                                      asb.
                                      length(
                                        ) -
                                      1;
                                    org.apache.batik.gvt.text.TextPaintInfo tpi;
                                    tpi =
                                      (org.apache.batik.gvt.text.TextPaintInfo)
                                        elemTPI.
                                        get(
                                          nodeElement);
                                    tpi.
                                      startChar =
                                      trefStart;
                                    tpi.
                                      endChar =
                                      trefEnd;
                                    initialAttributes =
                                      null;
                                }
                            }
                            else
                                if (ln.
                                      equals(
                                        SVG_A_TAG)) {
                                    org.apache.batik.dom.events.NodeEventTarget target =
                                      (org.apache.batik.dom.events.NodeEventTarget)
                                        nodeElement;
                                    org.apache.batik.bridge.UserAgent ua =
                                      ctx.
                                      getUserAgent(
                                        );
                                    org.apache.batik.bridge.SVGAElementBridge.CursorHolder ch;
                                    ch =
                                      new org.apache.batik.bridge.SVGAElementBridge.CursorHolder(
                                        org.apache.batik.bridge.CursorManager.
                                          DEFAULT_CURSOR);
                                    org.w3c.dom.events.EventListener l;
                                    l =
                                      new org.apache.batik.bridge.SVGAElementBridge.AnchorListener(
                                        ua,
                                        ch);
                                    target.
                                      addEventListenerNS(
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false,
                                        null);
                                    ctx.
                                      storeEventListenerNS(
                                        target,
                                        org.apache.batik.util.XMLConstants.
                                          XML_EVENTS_NAMESPACE_URI,
                                        SVG_EVENT_CLICK,
                                        l,
                                        false);
                                    int before =
                                      asb.
                                        count;
                                    fillAttributedStringBuffer(
                                      ctx,
                                      nodeElement,
                                      false,
                                      textPath,
                                      subBidiLevel,
                                      initialAttributes,
                                      asb);
                                    if (asb.
                                          count !=
                                          before) {
                                        initialAttributes =
                                          null;
                                    }
                                }
                    break;
                case org.w3c.dom.Node.
                       TEXT_NODE:
                case org.w3c.dom.Node.
                       CDATA_SECTION_NODE:
                    s =
                      n.
                        getNodeValue(
                          );
                    s =
                      normalizeString(
                        s,
                        preserve,
                        prevEndsWithSpace);
                    if (s.
                          length(
                            ) !=
                          0) {
                        asb.
                          append(
                            s,
                            map);
                        if (preserve) {
                            endLimit =
                              asb.
                                length(
                                  );
                        }
                        initialAttributes =
                          null;
                    }
            }
        }
        if (top) {
            boolean strippedSome =
              false;
            while (endLimit <
                     asb.
                     length(
                       ) &&
                     asb.
                     getLastChar(
                       ) ==
                     ' ') {
                asb.
                  stripLast(
                    );
                strippedSome =
                  true;
            }
            if (strippedSome) {
                java.util.Iterator iter =
                  elemTPI.
                  values(
                    ).
                  iterator(
                    );
                while (iter.
                         hasNext(
                           )) {
                    org.apache.batik.gvt.text.TextPaintInfo tpi =
                      (org.apache.batik.gvt.text.TextPaintInfo)
                        iter.
                        next(
                          );
                    if (tpi.
                          endChar >=
                          asb.
                          length(
                            )) {
                        tpi.
                          endChar =
                          asb.
                            length(
                              ) -
                            1;
                        if (tpi.
                              startChar >
                              tpi.
                                endChar)
                            tpi.
                              startChar =
                              tpi.
                                endChar;
                    }
                }
            }
        }
        int elementEndChar =
          asb.
          length(
            ) -
          1;
        org.apache.batik.gvt.text.TextPaintInfo tpi =
          (org.apache.batik.gvt.text.TextPaintInfo)
            elemTPI.
            get(
              element);
        tpi.
          startChar =
          elementStartChar;
        tpi.
          endChar =
          elementEndChar;
    }
    protected java.lang.String normalizeString(java.lang.String s,
                                               boolean preserve,
                                               boolean stripfirst) {
        java.lang.StringBuffer sb =
          new java.lang.StringBuffer(
          s.
            length(
              ));
        if (preserve) {
            for (int i =
                   0;
                 i <
                   s.
                   length(
                     );
                 i++) {
                char c =
                  s.
                  charAt(
                    i);
                switch (c) {
                    case 10:
                    case 13:
                    case '\t':
                        sb.
                          append(
                            ' ');
                        break;
                    default:
                        sb.
                          append(
                            c);
                }
            }
            return sb.
              toString(
                );
        }
        int idx =
          0;
        if (stripfirst) {
            loop: while (idx <
                           s.
                           length(
                             )) {
                switch (s.
                          charAt(
                            idx)) {
                    default:
                        break loop;
                    case 10:
                    case 13:
                    case ' ':
                    case '\t':
                        idx++;
                }
            }
        }
        boolean space =
          false;
        for (int i =
               idx;
             i <
               s.
               length(
                 );
             i++) {
            char c =
              s.
              charAt(
                i);
            switch (c) {
                case 10:
                case 13:
                    break;
                case ' ':
                case '\t':
                    if (!space) {
                        sb.
                          append(
                            ' ');
                        space =
                          true;
                    }
                    break;
                default:
                    sb.
                      append(
                        c);
                    space =
                      false;
            }
        }
        return sb.
          toString(
            );
    }
    protected static class AttributedStringBuffer {
        protected java.util.List strings;
        protected java.util.List attributes;
        protected int count;
        protected int length;
        public AttributedStringBuffer() {
            super(
              );
            strings =
              new java.util.ArrayList(
                );
            attributes =
              new java.util.ArrayList(
                );
            count =
              0;
            length =
              0;
        }
        public boolean isEmpty() { return count ==
                                     0; }
        public int length() { return length;
        }
        public void append(java.lang.String s,
                           java.util.Map m) {
            if (s.
                  length(
                    ) ==
                  0)
                return;
            strings.
              add(
                s);
            attributes.
              add(
                m);
            count++;
            length +=
              s.
                length(
                  );
        }
        public int getLastChar() { if (count ==
                                         0) {
                                       return -1;
                                   }
                                   java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         count -
                                           1);
                                   return s.
                                     charAt(
                                       s.
                                         length(
                                           ) -
                                         1);
        }
        public void stripFirst() { java.lang.String s =
                                     (java.lang.String)
                                       strings.
                                       get(
                                         0);
                                   if (s.
                                         charAt(
                                           s.
                                             length(
                                               ) -
                                             1) !=
                                         ' ')
                                       return;
                                   length--;
                                   if (s.
                                         length(
                                           ) ==
                                         1) {
                                       attributes.
                                         remove(
                                           0);
                                       strings.
                                         remove(
                                           0);
                                       count--;
                                       return;
                                   }
                                   strings.
                                     set(
                                       0,
                                       s.
                                         substring(
                                           1));
        }
        public void stripLast() { java.lang.String s =
                                    (java.lang.String)
                                      strings.
                                      get(
                                        count -
                                          1);
                                  if (s.charAt(
                                          s.
                                            length(
                                              ) -
                                            1) !=
                                        ' ')
                                      return;
                                  length--;
                                  if (s.length(
                                          ) ==
                                        1) {
                                      attributes.
                                        remove(
                                          --count);
                                      strings.
                                        remove(
                                          count);
                                      return;
                                  }
                                  strings.
                                    set(
                                      count -
                                        1,
                                      s.
                                        substring(
                                          0,
                                          s.
                                            length(
                                              ) -
                                            1));
        }
        public java.text.AttributedString toAttributedString() {
            switch (count) {
                case 0:
                    return null;
                case 1:
                    return new java.text.AttributedString(
                      (java.lang.String)
                        strings.
                        get(
                          0),
                      (java.util.Map)
                        attributes.
                        get(
                          0));
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            java.text.AttributedString result =
              new java.text.AttributedString(
              sb.
                toString(
                  ));
            java.util.Iterator sit =
              strings.
              iterator(
                );
            java.util.Iterator ait =
              attributes.
              iterator(
                );
            int idx =
              0;
            while (sit.
                     hasNext(
                       )) {
                java.lang.String s =
                  (java.lang.String)
                    sit.
                    next(
                      );
                int nidx =
                  idx +
                  s.
                  length(
                    );
                java.util.Map m =
                  (java.util.Map)
                    ait.
                    next(
                      );
                java.util.Iterator kit =
                  m.
                  keySet(
                    ).
                  iterator(
                    );
                java.util.Iterator vit =
                  m.
                  values(
                    ).
                  iterator(
                    );
                while (kit.
                         hasNext(
                           )) {
                    java.text.AttributedCharacterIterator.Attribute attr =
                      (java.text.AttributedCharacterIterator.Attribute)
                        kit.
                        next(
                          );
                    java.lang.Object val =
                      vit.
                      next(
                        );
                    result.
                      addAttribute(
                        attr,
                        val,
                        idx,
                        nidx);
                }
                idx =
                  nidx;
            }
            return result;
        }
        public java.lang.String toString() {
            switch (count) {
                case 0:
                    return "";
                case 1:
                    return (java.lang.String)
                             strings.
                             get(
                               0);
            }
            java.lang.StringBuffer sb =
              new java.lang.StringBuffer(
              strings.
                size(
                  ) *
                5);
            java.util.Iterator it =
              strings.
              iterator(
                );
            while (it.
                     hasNext(
                       )) {
                sb.
                  append(
                    (java.lang.String)
                      it.
                      next(
                        ));
            }
            return sb.
              toString(
                );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "bz/yaw89d5SLPrJn+MSeT/H29N2vT5W5");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          "U3HTIf+tx3/zB3/p5a+WZ5r/DwDinQrjLQAA";
    }
    protected boolean nodeAncestorOf(org.w3c.dom.Node node1,
                                     org.w3c.dom.Node node2) {
        if (node2 ==
              null ||
              node1 ==
              null) {
            return false;
        }
        org.w3c.dom.Node parent =
          getParentNode(
            node2);
        while (parent !=
                 null &&
                 parent !=
                 node1) {
            parent =
              getParentNode(
                parent);
        }
        return parent ==
          node1;
    }
    protected void addGlyphPositionAttributes(java.text.AttributedString as,
                                              org.w3c.dom.Element element,
                                              org.apache.batik.bridge.BridgeContext ctx) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        if (element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_PATH_TAG)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        int lastChar =
          getElementEndIndex(
            element);
        if (!(element instanceof org.w3c.dom.svg.SVGTextPositioningElement)) {
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
            return;
        }
        org.w3c.dom.svg.SVGTextPositioningElement te =
          (org.w3c.dom.svg.SVGTextPositioningElement)
            element;
        try {
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _x =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getX(
                  );
            _x.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _y =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getY(
                  );
            _y.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dx =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDx(
                  );
            _dx.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedLengthList _dy =
              (org.apache.batik.dom.svg.SVGOMAnimatedLengthList)
                te.
                getDy(
                  );
            _dy.
              check(
                );
            org.apache.batik.dom.svg.SVGOMAnimatedNumberList _rotate =
              (org.apache.batik.dom.svg.SVGOMAnimatedNumberList)
                te.
                getRotate(
                  );
            _rotate.
              check(
                );
            org.w3c.dom.svg.SVGLengthList xs =
              _x.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList ys =
              _y.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dxs =
              _dx.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGLengthList dys =
              _dy.
              getAnimVal(
                );
            org.w3c.dom.svg.SVGNumberList rs =
              _rotate.
              getAnimVal(
                );
            int len;
            len =
              xs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      X,
                    new java.lang.Float(
                      xs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              ys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      Y,
                    new java.lang.Float(
                      ys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dxs.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DX,
                    new java.lang.Float(
                      dxs.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              dys.
                getNumberOfItems(
                  );
            for (int i =
                   0;
                 i <
                   len &&
                   firstChar +
                   i <=
                   lastChar;
                 i++) {
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      DY,
                    new java.lang.Float(
                      dys.
                        getItem(
                          i).
                        getValue(
                          )),
                    firstChar +
                      i,
                    firstChar +
                      i +
                      1);
            }
            len =
              rs.
                getNumberOfItems(
                  );
            if (len ==
                  1) {
                java.lang.Float rad =
                  new java.lang.Float(
                  java.lang.Math.
                    toRadians(
                      rs.
                        getItem(
                          0).
                        getValue(
                          )));
                as.
                  addAttribute(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ROTATION,
                    rad,
                    firstChar,
                    lastChar +
                      1);
            }
            else
                if (len >
                      1) {
                    for (int i =
                           0;
                         i <
                           len &&
                           firstChar +
                           i <=
                           lastChar;
                         i++) {
                        java.lang.Float rad =
                          new java.lang.Float(
                          java.lang.Math.
                            toRadians(
                              rs.
                                getItem(
                                  i).
                                getValue(
                                  )));
                        as.
                          addAttribute(
                            org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                              ROTATION,
                            rad,
                            firstChar +
                              i,
                            firstChar +
                              i +
                              1);
                    }
                }
            addChildGlyphPositionAttributes(
              as,
              element,
              ctx);
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
    }
    protected void addChildGlyphPositionAttributes(java.text.AttributedString as,
                                                   org.w3c.dom.Element element,
                                                   org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE)
                continue;
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
                addGlyphPositionAttributes(
                  as,
                  childElement,
                  ctx);
            }
        }
    }
    protected void addPaintAttributes(java.text.AttributedString as,
                                      org.w3c.dom.Element element,
                                      org.apache.batik.gvt.TextNode node,
                                      org.apache.batik.gvt.text.TextPaintInfo pi,
                                      org.apache.batik.bridge.BridgeContext ctx) {
        if (!org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                element,
                ctx.
                  getUserAgent(
                    )) ||
              !org.apache.batik.bridge.CSSUtilities.
              convertDisplay(
                element)) {
            return;
        }
        java.lang.Object o =
          elemTPI.
          get(
            element);
        if (o !=
              null) {
            node.
              swapTextPaintInfo(
                pi,
                (org.apache.batik.gvt.text.TextPaintInfo)
                  o);
        }
        addChildPaintAttributes(
          as,
          element,
          node,
          pi,
          ctx);
    }
    protected void addChildPaintAttributes(java.text.AttributedString as,
                                           org.w3c.dom.Element element,
                                           org.apache.batik.gvt.TextNode node,
                                           org.apache.batik.gvt.text.TextPaintInfo parentPI,
                                           org.apache.batik.bridge.BridgeContext ctx) {
        for (org.w3c.dom.Node child =
               getFirstChild(
                 element);
             child !=
               null;
             child =
               getNextSibling(
                 child)) {
            if (child.
                  getNodeType(
                    ) !=
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                continue;
            }
            org.w3c.dom.Element childElement =
              (org.w3c.dom.Element)
                child;
            if (isTextChild(
                  childElement)) {
                org.apache.batik.gvt.text.TextPaintInfo pi =
                  getTextPaintInfo(
                    childElement,
                    node,
                    parentPI,
                    ctx);
                addPaintAttributes(
                  as,
                  childElement,
                  node,
                  pi,
                  ctx);
            }
        }
    }
    protected java.util.List getFontList(org.apache.batik.bridge.BridgeContext ctx,
                                         org.w3c.dom.Element element,
                                         java.util.Map result) {
        result.
          put(
            TEXT_COMPOUND_ID,
            new java.lang.ref.SoftReference(
              element));
        java.lang.Float fsFloat =
          org.apache.batik.bridge.TextUtilities.
          convertFontSize(
            element);
        float fontSize =
          fsFloat.
          floatValue(
            );
        result.
          put(
            java.awt.font.TextAttribute.
              SIZE,
            fsFloat);
        result.
          put(
            java.awt.font.TextAttribute.
              WIDTH,
            org.apache.batik.bridge.TextUtilities.
              convertFontStretch(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              POSTURE,
            org.apache.batik.bridge.TextUtilities.
              convertFontStyle(
                element));
        result.
          put(
            java.awt.font.TextAttribute.
              WEIGHT,
            org.apache.batik.bridge.TextUtilities.
              convertFontWeight(
                element));
        org.apache.batik.css.engine.value.Value v =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_WEIGHT_INDEX);
        java.lang.String fontWeightString =
          v.
          getCssText(
            );
        java.lang.String fontStyleString =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_STYLE_INDEX).
          getStringValue(
            );
        result.
          put(
            TEXT_COMPOUND_DELIMITER,
            element);
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              FONT_FAMILY_INDEX);
        java.util.List fontFamilyList =
          new java.util.ArrayList(
          );
        java.util.List fontList =
          new java.util.ArrayList(
          );
        int len =
          val.
          getLength(
            );
        for (int i =
               0;
             i <
               len;
             i++) {
            org.apache.batik.css.engine.value.Value it =
              val.
              item(
                i);
            java.lang.String fontFamilyName =
              it.
              getStringValue(
                );
            org.apache.batik.gvt.font.GVTFontFamily fontFamily;
            fontFamily =
              org.apache.batik.bridge.SVGFontUtilities.
                getFontFamily(
                  element,
                  ctx,
                  fontFamilyName,
                  fontWeightString,
                  fontStyleString);
            if (fontFamily ==
                  null)
                continue;
            if (fontFamily instanceof org.apache.batik.gvt.font.UnresolvedFontFamily) {
                fontFamily =
                  org.apache.batik.gvt.font.FontFamilyResolver.
                    resolve(
                      (org.apache.batik.gvt.font.UnresolvedFontFamily)
                        fontFamily);
                if (fontFamily ==
                      null)
                    continue;
            }
            fontFamilyList.
              add(
                fontFamily);
            if (fontFamily instanceof org.apache.batik.bridge.SVGFontFamily) {
                org.apache.batik.bridge.SVGFontFamily svgFF =
                  (org.apache.batik.bridge.SVGFontFamily)
                    fontFamily;
                if (svgFF.
                      isComplex(
                        )) {
                    usingComplexSVGFont =
                      true;
                }
            }
            org.apache.batik.gvt.font.GVTFont ft =
              fontFamily.
              deriveFont(
                fontSize,
                result);
            fontList.
              add(
                ft);
        }
        result.
          put(
            GVT_FONT_FAMILIES,
            fontFamilyList);
        if (!ctx.
              isDynamic(
                )) {
            result.
              remove(
                TEXT_COMPOUND_DELIMITER);
        }
        return fontList;
    }
    protected java.util.Map getAttributeMap(org.apache.batik.bridge.BridgeContext ctx,
                                            org.w3c.dom.Element element,
                                            org.apache.batik.gvt.text.TextPath textPath,
                                            java.lang.Integer bidiLevel,
                                            java.util.Map result) {
        org.w3c.dom.svg.SVGTextContentElement tce =
          null;
        if (element instanceof org.w3c.dom.svg.SVGTextContentElement) {
            tce =
              (org.w3c.dom.svg.SVGTextContentElement)
                element;
        }
        java.util.Map inheritMap =
          null;
        java.lang.String s;
        if (SVG_NAMESPACE_URI.
              equals(
                element.
                  getNamespaceURI(
                    )) &&
              element.
              getLocalName(
                ).
              equals(
                SVG_ALT_GLYPH_TAG)) {
            result.
              put(
                ALT_GLYPH_HANDLER,
                new org.apache.batik.bridge.SVGAltGlyphHandler(
                  ctx,
                  element));
        }
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          );
        pi.
          visible =
          true;
        pi.
          fillPaint =
          java.awt.Color.
            black;
        result.
          put(
            PAINT_INFO,
            pi);
        elemTPI.
          put(
            element,
            pi);
        if (textPath !=
              null) {
            result.
              put(
                TEXTPATH,
                textPath);
        }
        org.apache.batik.gvt.TextNode.Anchor a =
          org.apache.batik.bridge.TextUtilities.
          convertTextAnchor(
            element);
        result.
          put(
            ANCHOR_TYPE,
            a);
        java.util.List fontList =
          getFontList(
            ctx,
            element,
            result);
        result.
          put(
            GVT_FONTS,
            fontList);
        java.lang.Object bs =
          org.apache.batik.bridge.TextUtilities.
          convertBaselineShift(
            element);
        if (bs !=
              null) {
            result.
              put(
                BASELINE_SHIFT,
                bs);
        }
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              UNICODE_BIDI_INDEX);
        s =
          val.
            getStringValue(
              );
        if (s.
              charAt(
                0) ==
              'n') {
            if (bidiLevel !=
                  null)
                result.
                  put(
                    java.awt.font.TextAttribute.
                      BIDI_EMBEDDING,
                    bidiLevel);
        }
        else {
            val =
              org.apache.batik.bridge.CSSUtilities.
                getComputedStyle(
                  element,
                  org.apache.batik.css.engine.SVGCSSEngine.
                    DIRECTION_INDEX);
            java.lang.String rs =
              val.
              getStringValue(
                );
            int cbidi =
              0;
            if (bidiLevel !=
                  null)
                cbidi =
                  bidiLevel.
                    intValue(
                      );
            if (cbidi <
                  0)
                cbidi =
                  -cbidi;
            switch (rs.
                      charAt(
                        0)) {
                case 'l':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_LTR);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi++;
                    else
                        cbidi +=
                          2;
                    break;
                case 'r':
                    result.
                      put(
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION,
                        java.awt.font.TextAttribute.
                          RUN_DIRECTION_RTL);
                    if ((cbidi &
                           1) ==
                          1)
                        cbidi +=
                          2;
                    else
                        cbidi++;
                    break;
            }
            switch (s.
                      charAt(
                        0)) {
                case 'b':
                    cbidi =
                      -cbidi;
                    break;
            }
            result.
              put(
                java.awt.font.TextAttribute.
                  BIDI_EMBEDDING,
                new java.lang.Integer(
                  cbidi));
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                WRITING_MODE_INDEX);
        s =
          val.
            getStringValue(
              );
        switch (s.
                  charAt(
                    0)) {
            case 'l':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_LTR);
                break;
            case 'r':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_RTL);
                break;
            case 't':
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      WRITING_MODE_TTB);
                break;
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_VERTICAL_INDEX);
        int primitiveType =
          val.
          getPrimitiveType(
            );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_IDENT:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_AUTO);
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION,
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      ORIENTATION_ANGLE);
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      VERTICAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (V):" +
                  primitiveType);
        }
        val =
          org.apache.batik.bridge.CSSUtilities.
            getComputedStyle(
              element,
              org.apache.batik.css.engine.SVGCSSEngine.
                GLYPH_ORIENTATION_HORIZONTAL_INDEX);
        primitiveType =
          val.
            getPrimitiveType(
              );
        switch (primitiveType) {
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_DEG:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          )));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_RAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      java.lang.Math.
                        toDegrees(
                          val.
                            getFloatValue(
                              ))));
                break;
            case org.w3c.dom.css.CSSPrimitiveValue.
                   CSS_GRAD:
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      HORIZONTAL_ORIENTATION_ANGLE,
                    new java.lang.Float(
                      val.
                        getFloatValue(
                          ) *
                        9 /
                        5));
                break;
            default:
                throw new java.lang.IllegalStateException(
                  "unexpected primitiveType (H):" +
                  primitiveType);
        }
        java.lang.Float sp =
          org.apache.batik.bridge.TextUtilities.
          convertLetterSpacing(
            element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  LETTER_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertWordSpacing(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  WORD_SPACING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        sp =
          org.apache.batik.bridge.TextUtilities.
            convertKerning(
              element);
        if (sp !=
              null) {
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  KERNING,
                sp);
            result.
              put(
                org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                  CUSTOM_SPACING,
                java.lang.Boolean.
                  TRUE);
        }
        if (tce ==
              null) {
            return inheritMap;
        }
        try {
            org.apache.batik.dom.svg.AbstractSVGAnimatedLength textLength =
              (org.apache.batik.dom.svg.AbstractSVGAnimatedLength)
                tce.
                getTextLength(
                  );
            if (textLength.
                  isSpecified(
                    )) {
                if (inheritMap ==
                      null) {
                    inheritMap =
                      new java.util.HashMap(
                        );
                }
                java.lang.Object value =
                  new java.lang.Float(
                  textLength.
                    getCheckedValue(
                      ));
                result.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                inheritMap.
                  put(
                    org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                      BBOX_WIDTH,
                    value);
                org.apache.batik.dom.svg.SVGOMAnimatedEnumeration _lengthAdjust =
                  (org.apache.batik.dom.svg.SVGOMAnimatedEnumeration)
                    tce.
                    getLengthAdjust(
                      );
                if (_lengthAdjust.
                      getCheckedVal(
                        ) ==
                      org.w3c.dom.svg.SVGTextContentElement.
                        LENGTHADJUST_SPACINGANDGLYPHS) {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_ALL);
                }
                else {
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          LENGTH_ADJUST,
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          ADJUST_SPACING);
                    result.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                    inheritMap.
                      put(
                        org.apache.batik.gvt.text.GVTAttributedCharacterIterator.TextAttribute.
                          CUSTOM_SPACING,
                        java.lang.Boolean.
                          TRUE);
                }
            }
        }
        catch (org.apache.batik.dom.svg.LiveAttributeException ex) {
            throw new org.apache.batik.bridge.BridgeException(
              ctx,
              ex);
        }
        return inheritMap;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getParentTextPaintInfo(org.w3c.dom.Element child) {
        org.w3c.dom.Node parent =
          getParentNode(
            child);
        while (parent !=
                 null) {
            org.apache.batik.gvt.text.TextPaintInfo tpi =
              (org.apache.batik.gvt.text.TextPaintInfo)
                elemTPI.
                get(
                  parent);
            if (tpi !=
                  null)
                return tpi;
            parent =
              getParentNode(
                parent);
        }
        return null;
    }
    protected org.apache.batik.gvt.text.TextPaintInfo getTextPaintInfo(org.w3c.dom.Element element,
                                                                       org.apache.batik.gvt.GraphicsNode node,
                                                                       org.apache.batik.gvt.text.TextPaintInfo parentTPI,
                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        org.apache.batik.gvt.text.TextPaintInfo pi =
          new org.apache.batik.gvt.text.TextPaintInfo(
          parentTPI);
        org.apache.batik.css.engine.StyleMap sm =
          ((org.apache.batik.css.engine.CSSStylableElement)
             element).
          getComputedStyleMap(
            null);
        if (sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  FILL_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  STROKE_WIDTH_INDEX) &&
              sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  OPACITY_INDEX)) {
            return pi;
        }
        setBaseTextPaintInfo(
          pi,
          element,
          node,
          ctx);
        if (!sm.
              isNullCascaded(
                org.apache.batik.css.engine.SVGCSSEngine.
                  TEXT_DECORATION_INDEX))
            setDecorationTextPaintInfo(
              pi,
              element);
        return pi;
    }
    public void setBaseTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                     org.w3c.dom.Element element,
                                     org.apache.batik.gvt.GraphicsNode node,
                                     org.apache.batik.bridge.BridgeContext ctx) {
        if (!element.
              getLocalName(
                ).
              equals(
                SVG_TEXT_TAG))
            pi.
              composite =
              org.apache.batik.bridge.CSSUtilities.
                convertOpacity(
                  element);
        else
            pi.
              composite =
              java.awt.AlphaComposite.
                SrcOver;
        pi.
          visible =
          org.apache.batik.bridge.CSSUtilities.
            convertVisibility(
              element);
        pi.
          fillPaint =
          org.apache.batik.bridge.PaintServer.
            convertFillPaint(
              element,
              node,
              ctx);
        pi.
          strokePaint =
          org.apache.batik.bridge.PaintServer.
            convertStrokePaint(
              element,
              node,
              ctx);
        pi.
          strokeStroke =
          org.apache.batik.bridge.PaintServer.
            convertStroke(
              element);
    }
    public void setDecorationTextPaintInfo(org.apache.batik.gvt.text.TextPaintInfo pi,
                                           org.w3c.dom.Element element) {
        org.apache.batik.css.engine.value.Value val =
          org.apache.batik.bridge.CSSUtilities.
          getComputedStyle(
            element,
            org.apache.batik.css.engine.SVGCSSEngine.
              TEXT_DECORATION_INDEX);
        switch (val.
                  getCssValueType(
                    )) {
            case org.w3c.dom.css.CSSValue.
                   CSS_VALUE_LIST:
                org.apache.batik.css.engine.value.ListValue lst =
                  (org.apache.batik.css.engine.value.ListValue)
                    val;
                int len =
                  lst.
                  getLength(
                    );
                for (int i =
                       0;
                     i <
                       len;
                     i++) {
                    org.apache.batik.css.engine.value.Value v =
                      lst.
                      item(
                        i);
                    java.lang.String s =
                      v.
                      getStringValue(
                        );
                    switch (s.
                              charAt(
                                0)) {
                        case 'u':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  underlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  underlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  underlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'o':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  overlinePaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  overlineStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  overlineStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                        case 'l':
                            if (pi.
                                  fillPaint !=
                                  null) {
                                pi.
                                  strikethroughPaint =
                                  pi.
                                    fillPaint;
                            }
                            if (pi.
                                  strokePaint !=
                                  null) {
                                pi.
                                  strikethroughStrokePaint =
                                  pi.
                                    strokePaint;
                            }
                            if (pi.
                                  strokeStroke !=
                                  null) {
                                pi.
                                  strikethroughStroke =
                                  pi.
                                    strokeStroke;
                            }
                            break;
                    }
                }
                break;
            default:
                pi.
                  underlinePaint =
                  null;
                pi.
                  underlineStrokePaint =
                  null;
                pi.
                  underlineStroke =
                  null;
                pi.
                  overlinePaint =
                  null;
                pi.
                  overlineStrokePaint =
                  null;
                pi.
                  overlineStroke =
                  null;
                pi.
                  strikethroughPaint =
                  null;
                pi.
                  strikethroughStrokePaint =
                  null;
                pi.
                  strikethroughStroke =
                  null;
                break;
        }
    }
    public abstract class AbstractTextChildSVGContext extends org.apache.batik.bridge.AnimatableSVGBridge {
        protected org.apache.batik.bridge.SVGTextElementBridge
          textBridge;
        public AbstractTextChildSVGContext(org.apache.batik.bridge.BridgeContext ctx,
                                           org.apache.batik.bridge.SVGTextElementBridge parent,
                                           org.w3c.dom.Element e) {
            super(
              );
            this.
              ctx =
              ctx;
            this.
              textBridge =
              parent;
            this.
              e =
              e;
        }
        public java.lang.String getNamespaceURI() {
            return null;
        }
        public java.lang.String getLocalName() {
            return null;
        }
        public org.apache.batik.bridge.Bridge getInstance() {
            return null;
        }
        public org.apache.batik.bridge.SVGTextElementBridge getTextBridge() {
            return textBridge;
        }
        public float getPixelUnitToMillimeter() {
            return ctx.
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
        public java.awt.geom.AffineTransform getCTM() {
            return null;
        }
        public java.awt.geom.AffineTransform getGlobalTransform() {
            return null;
        }
        public java.awt.geom.AffineTransform getScreenTransform() {
            return null;
        }
        public void setScreenTransform(java.awt.geom.AffineTransform at) {
            return;
        }
        public float getViewportWidth() {
            return ctx.
              getBlockWidth(
                e);
        }
        public float getViewportHeight() {
            return ctx.
              getBlockHeight(
                e);
        }
        public float getFontSize() { return org.apache.batik.bridge.CSSUtilities.
                                       getComputedStyle(
                                         e,
                                         org.apache.batik.css.engine.SVGCSSEngine.
                                           FONT_SIZE_INDEX).
                                       getFloatValue(
                                         );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "G/85+j/bHL5fxCQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Wkp3YiqjtdUgDZdQ3PUwrG0WlcyDG+vWVul15FqthdNMDaO3oh8NkrrGC8R2" +
           "0kalajisxMxouVyHVbxetdxyYxIGJtJbzIZqv7ucmZMeJnQoyejMVI1mIlYM" +
           "l+02PyOnW65mt1icZ8ea11+uW4inhgwujDV1xC3EphGLwkhfi7Vg2dbJWUL5" +
           "djQYO7rEbRy2S1iTJbqdsV0PS4yQGk96LcR3qHqXXk62i9Twl2u55G/4MUk4" +
           "M9+mgrjDYTpwc2aRwcqouuXK9UqMdUPbxPkkwpcy1ZRqNpasxzMOE9psVI1H" +
           "aZOvwXoqDKsc10qzpWVGU0CtzLWklOkYOdpEvsT1NuyoMV53OW467vTxil0h" +
           "eXxSquiq0auha9ZsYBNuUwYdA5dzBtmG62r6UnbryTChDKPbT+sMux203Cou" +
           "NxhZarSr/bTRQTKV2MQpYTQJe0SaNYM2y2sq3G5gXJXULtPwwYD2mmGmQ2Uy" +
           "RuCZyDPeyppLxFgbcnY3WRrVpl7C6rEUbZvb0lhsT6I1RYrSlJhHvckCBalD" +
           "NZ2vxAqm65bnl6wNVepX2PFmNd3MBtFkut4aLdLyGukWNwJ+MemOFWwwH46I" +
           "QV9xeqosWf3UtuLuUuhttHSeTUp+azCslWdhGvpUDDfUoc535HpJm7MjjeiM" +
           "mbTeGEpUl6jzI81bxsNpc0Vg2FJtMjSmo3WOsoky3lIqDu4NuLlCVuok2UNh" +
           "asP2uYzs+Gt31p5UgzbL88sBg7QCo0WjLZPky0JE6rVtuzroD0gsHXfT7WrS" +
           "1WNzRUd9sdGEB1WtXBeHFm1gWr9brqklPV2Xh4hccgMjVMIKV+Y6WKeWtju6" +
           "WYoDw0ssIaTYcTIaylVeGdYb+LbM4uvmJqIiZDHjFcriUdSqaG1pqJRhLHUl" +
           "2hr7nNQyVoKADML+qNa1NCSiXX84njHespWk5V4N2Zp1ccN2uUWI16q9ZMDW" +
           "fAVhOrVy1MD0VKbqcKmitqrJFKP7aH0e6GybkHhmuV4kNpphsGqkcKexSc3V" +
           "ZEauY14GvXgPrq6ozhxuNOS10EGjidwfeVkdb3aXze284kmyiWwNmaemUjAO" +
           "qG4Vx5RGUpppvLfm5ysUY+wgMMvWcl43rHEwUCbt2swk5qLaJRCuGW4rcHfC" +
           "oa2aJs4UHa1II6/TaVZZtyN1zY4ibfTGqkvLzraN1doEH5uMGvVpZ90lu9UV" +
           "ujH7Oh0JlqkOWW2mBAy6cHhp0VtFrieuZxhlRX5sNkSJ7PsdNaYjfcF7AjLZ" +
           "4tE201UuY3QQrCYDLaIXW19t1MtZGgYy7Q5QqRVnPlZOnDK89lV26Rpjle+U" +
           "UKMvbTYs32xL48iLcKOEBRg8MYCGZNtKpiXEmGQbAl0TNRSRIhypl4Qu1VQc" +
           "WgqsSB9VWXZcaZNjr4K0Z1ZVMEU9bNaI6nKFeqUy5dQq8Upk+A5LZOVQpz14" +
           "opc4uTlNbbY2wmJyoiYsOXUUeGrrpVqTU9qzeqvisnqpoTnIXO0i4mIblpR6" +
           "M0wwcQnPValBzATTpLi6Vy/TVavcmAnk1hya9iyor5lFOxobiessl9nQ6Cyd" +
           "eS2psxbDWnV4NM1KKu1O1BBJ6RVteBUFV9f9CjLuY0l1snGELrZdjkBsjnpU" +
           "K1x3o5Y2dDi9shW2hoOHukukJsqwyQjIBktUYz1d+aUa3QjL1RndXqpg9ArO" +
           "Nhsx2+rMjayxFN25JAqRu2xVQnyo2JRY2hhMMp2mAgGvWSMOkZnRK03qIimv" +
           "jbVfI2kYduylVxOGg0pXkZpLHq73MXQgTA0N17CO1yAn80ZHtqnNKBGo9rSq" +
           "jP050o0E8OGcVnu2JsabfsYvUF3DO0lfTuuuXWO4rDqvK6zmbxK9PBpOhhIb" +
           "q0kmcC10KIgNuGtoIVZdu26znQw7jp1tZ7bisXKw9Tr+1EwXHLyg1yWuWWrh" +
           "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" +
           "KW4NHl8Vvo+GrhqJ45y8L3Pi+UoQ6oZV");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("6OG+3e2ZoABXi6E33yYbBgvQ/DgfvlDd0TeAQZ+lB1lV8XuS7idj6NqeDrDa" +
           "PZwkeU8MXQIk+eN7g6NFrnS71Bz3LFeJ8/t0QFW7XDa7UPR67KTZFFHzoR83" +
           "HSdeyN9+6k26uG1/9Nab7O7bv6h+/pX+8IPfrX92d99RdZTtNudylYbu3V29" +
           "LJjmb87P3JbbEa8r3Xf94IEv3PeOo1f8B3YC7034hGxP3fpyYcsN4uI64Paf" +
           "v/mf/dQ/fOWrxR2a/wskPRU0BjEAAA==");
    }
    protected abstract class AbstractTextChildBridgeUpdateHandler extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext implements org.apache.batik.bridge.BridgeUpdateHandler {
        protected AbstractTextChildBridgeUpdateHandler(org.apache.batik.bridge.BridgeContext ctx,
                                                       org.apache.batik.bridge.SVGTextElementBridge parent,
                                                       org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleDOMAttrModifiedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMNodeInsertedEvent(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMNodeInsertedEvent(
                evt);
        }
        public void handleDOMNodeRemovedEvent(org.w3c.dom.events.MutationEvent evt) {
            
        }
        public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
            textBridge.
              handleDOMCharacterDataModified(
                evt);
        }
        public void handleCSSEngineEvent(org.apache.batik.css.engine.CSSEngineEvent evt) {
            textBridge.
              handleCSSEngineEvent(
                evt);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            
        }
        public void handleOtherAnimationChanged(java.lang.String type) {
            
        }
        public void dispose() { ((org.apache.batik.dom.svg.SVGOMElement)
                                   e).setSVGContext(
                                        null);
                                elemTPI.remove(
                                          e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "pFkIjkKczd+ebsNqhvDJPFMBvB+y5rt56jmW8laAiFqyiHrfmzrqHbOxODZ5" +
           "GMupVoaxmRe47K4vLO76+EhnK2D0c9acoWiewGiQpogpgIJaoDRAP5oagOaD" +
           "d0/ZXj41eYDKqVbw9cUK737NmnMU1cmKBadm4vP5l5P3OUfRJ7oc+u/OgCaa" +
           "U3TzLW5rpedPNIXaT2x9g19q5G9UG6MolMioqqdq9VawtYZJEgqHolEc5Qz+" +
           "8RpF7WUmBnVp3D2QXhDyF4GEfnmKavinV+4yRQ2uHJgSD16RNyiqAhH2eMVw" +
           "UOr73y7nQMo+eucCxec7vtSzb7bUeRXvXQkrcPkvFs4ZIyN+s4hJp09s2nzv" +
           "tbueFnc1kor37WNWpkVRnbg2yp9TFpW15tiq7Vt6Y8aZ+sVOfdkiJuzulnke" +
           "SkMxEDDYsXeu7xbD6spfZrx5cvW5CwdrL0EpvR0FMEUzt3t+LxCX4905IwOH" +
           "qO1R7+HP87sXv2Dpbvjzztf//laglZ+dkbjE7KikEZMOn3t7KGEYx4Kovh/V" +
           "QPlMcqOoQbHW79WGiZSFU34ooyl7MqRfBoLG9YyW/3FjBqM1ZhGOI2MDOj3f" +
           "y+76KOosPhQU3382qPoYMdcx68zMdN/JLmMY3rc5dulfwitYm5XH/3H/168M" +
           "wrYrmLjXWp2ViecPid7fToRt1jazJpVjqwj8j0UHDMM+mgQb+KoaBo8vH3Cn" +
           "3xfSTIKiwDLD+A+z9weAAx0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "Y2ph6O8eNGU2Mr3ZgXB9IISuiRxd3o/j9c87eTnYbFYRXeqqaMdV0XPqqvTf" +
           "N2YC77qKG34zLd5x0A1dR04vjRQ/3HFDKvGWfcgPP1vIQO/0gzuQH3yeIP/O" +
           "VSB/KC0eDaGXHILMKpYTXR7x+54tYgIgfcsO4rc8T4g/dhXEH0+L3w2hO/YQ" +
           "45qQUqjiN4RQ2A36I7B/79nCfhWA+/AO7IefFxq47xIOl4JgW7Hnuq1s48Mh" +
           "kT3tE8IfXsVJn02LT4XQizZOOqx9xDVPPFvXIMAlj+y45j3Pi2uKl7gmpcog" +
           "mm/XbN1KbyZoPVJSztPFZahktyiZ3c9fxUdfSIs/3QukXUt7VkBY2fNLAulz" +
           "z0UgfWDHWx94zudPLxP466vA/lpa/GUIvXQDuxdqir/BDpaby2P+yrPFfDvA" +
           "+uEdzB9+bjAfhPQPV3n3rbT4RgidkvXAdQLlCLRvPhNoSQj9nz7bSPUKID26" +
           "9ZJvzDbfRUmfeuzs6VseG38z+3ph79ula2notLo0zYOXdgeeT7q+ouoZqGs3" +
           "V3hu9ud7IXTLFdI/kLeJ+zfP/7SR/34InTsqH0Insr8H5X4YQmf25YCpzcNB" +
           "kadC6DgQSR//1d2drK1n9xkMkNq5Y0+OHUg3dwIrG7Qbf96g7akc/CgiTVGz" +
           "bwN308nl5uvAi9ITj1Hd1z9d/ujmowzJFNbr1MppGjq1+T5kLyW9+4rWdm2d" +
           "bN370+s/fe0rdnPn6zcd3g/yA3278/KfPxCWG2YfLKz/+JY/etXHHvt2dgH5" +
           "v1O6yUi0KQAA");
    }
    protected class AbstractTextChildTextContent extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildBridgeUpdateHandler implements org.apache.batik.dom.svg.SVGTextContent {
        protected AbstractTextChildTextContent(org.apache.batik.bridge.BridgeContext ctx,
                                               org.apache.batik.bridge.SVGTextElementBridge parent,
                                               org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public int getNumberOfChars() { return textBridge.
                                          getNumberOfChars(
                                            e);
        }
        public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
            return textBridge.
              getExtentOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
            return textBridge.
              getStartPositionOfChar(
                e,
                charnum);
        }
        public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
            return textBridge.
              getEndPositionOfChar(
                e,
                charnum);
        }
        public void selectSubString(int charnum,
                                    int nchars) {
            textBridge.
              selectSubString(
                e,
                charnum,
                nchars);
        }
        public float getRotationOfChar(int charnum) {
            return textBridge.
              getRotationOfChar(
                e,
                charnum);
        }
        public float getComputedTextLength() {
            return textBridge.
              getComputedTextLength(
                e);
        }
        public float getSubStringLength(int charnum,
                                        int nchars) {
            return textBridge.
              getSubStringLength(
                e,
                charnum,
                nchars);
        }
        public int getCharNumAtPosition(float x,
                                        float y) {
            return textBridge.
              getCharNumAtPosition(
                e,
                x,
                y);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected class TRefBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TRefBridge(org.apache.batik.bridge.BridgeContext ctx,
                             org.apache.batik.bridge.SVGTextElementBridge parent,
                             org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "t//ui9/Oq2f/CzfrGxxXIAAA");
    }
    protected class TextPathBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TextPathBridge(org.apache.batik.bridge.BridgeContext ctx,
                                 org.apache.batik.bridge.SVGTextElementBridge parent,
                                 org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "oDo11SyL8CLslDTWFSKuJgS+Fxl8ZxyMHWc+xAuzmcdVenBMDR1hsVj4TK4z" +
           "cXp8Q7DnTXG6Uoy8zSdDVDQtYkmXpGrRJATci9xKWWrN2qMAKWltOca62qyt" +
           "EvNOvYfUSq1uZTCuFyd5m160Q7kyKsKlGazrAUmX0GqHR/O2ODJa84pIalOb" +
           "o6oAglQq51WiHDXuVUqYO5sbDFuLSo7DdchKoxbqhtTv82tiiCMoOaDaZKkU" +
           "dCYRLfSXctcfOzI9wWZGpxEGCCU3mvyKWkSzDq4u5l2SwUy10yPLFRMP6Dq9" +
           "rkUiEVdkX1RyOXqkq2i0rGMjiytQiLh0dLOBjwaNySwezZZTtiYIhtWBddFE" +
           "9XW/UC6VyAXRJlwNGVk1y7Vsg4ymOM6xxeLaKpc0NLdYJDk65EMBQwassFo5" +
           "dasw9TF1OS/W13C9zzfyeXxgcTUjj7PdWVvmcWfUbyZIr2P24SrAm+JYKmKY" +
           "MqvXlxNSqxGzKlyN8ZBDqRzWEqOkgtE9edhtC4JKs8vpiCRXE7Wx1sPJMr/A" +
           "rUUgYlURhXN6iYh4otRqj8e41BvZ9KqBu36uJ7HRHGRfyRPgLtPqUMU1Wq5T" +
           "dMue9JuBEowUxi/LhW5PCKs+0XPcddxctEa+SZSjmYLSTikPix5Izg5C5mxu" +
           "oWPdKrZ0h5UqNWkMdJCKnoN287zRVDhKHvJ6wXNZj50ECqkstLDtlkvL5hzD" +
           "hcDlJZrV2TILNNO1KQ12PxdZe1gOjVhhUlD7ZHtW83v5dmupLfttbtDQ7WYR" +
           "D5aqX8jJEooXKt0aUqrnm1IhGTtrtyohddp2rHGrGqEe1tarlpsTR1xXWg7N" +
           "Flzw0ZiLUcESlpyizPnieIZYpVa1t2TwEcaXUDSoI7lhOB56a79clPwJavPo" +
           "qmkSYbVDwcW5i2AuBVdza0EezhUaDonJuEyai5hfYzIytSSGlfJVvlLTvEUA" +
           "C0VLKqG5VtR1S4X+yED5PjpaBx2pPhhxzZVYEUzTnebnTI3PDQN7zgkqv2zA" +
           "6HxaXzOkbpRi1m2WrSiw2VVQJAjdH9TKg/lAHJRbLXZg1kzHg/kOEZTXhfES" +
           "K4+m9RqBJAMzlux5S+4Y4bQi0EFn3NM1MhnI42JgLAwc5KtM+2ONL64ihCMH" +
           "iTadLarkat5uWIUijLrsnKJrTcm1xba/mDZB3TIkuVIxaMXRrD5O0HbEwJFW" +
           "VSsjrGNbg7oTrmxqwEQtbVrr1oSJGFnTluMg7rLsaWOskJTLhXVbKzU0b2XW" +
           "DTnHCmZpWgl5JmCjujMtRQKBwjMlzpc5sovVcyCm4qKVdBv0rIihGDUR0bxX" +
           "0bQFTIoTT++LXTZgvaLYYWxSnxbiYQ4e2FpJ9vxSnY8tsP2wjsA11xM2nLPi" +
           "Wo377TxeKEyV2UiYwZ0GwrhBM5yQFtofFj1BbFMjfCkooBzKFfD+CFtP5jzW" +
           "m7OWOm71JZYYVmkk7hVRGBbznG+2F46x4qQ4yi9kksemCkkhAhkVDZbE5SoD" +
           "L3solxvnOmHUFIrzsYUP0BXqjpK4SOSDQDKTITlLhEoYxSzOTHlyNuOmQH9e" +
           "KY8EpdfGh8iA8/SkhPCr0kwAleqH0xJWfX+niLuzA9PBLT04PKQD7PuonjdD" +
           "j6ePpw7uebIz9l3Hb3YP3/NsT99QeiJ4+HaX79lp4LVP33hVZb9Q2Nm7tbgG" +
           "DoB770QOy4mgC0dvOtNBBEh/4KYXMJuXBsqXX714x/2vDv4mu/A7uNg/R0F3" +
           "6LFtHz7nHmqf8QNNNzNFzm1OvX72E4Hz520uboC+8vayJtzQL8F59Dg9ONBm" +
           "v4fp1hF0fksHRG0ah0muR9BJQJI2P+HvH3Y77+uOuCaHUSApUTqCT01bzRrp" +
           "vZQbJSeOrtdBYFz+SceqQ0v85JEjafbmbG856Hjz7uya8sarXebj71S+sLnI" +
           "VGxpvc7etFDQ2c2d6sF18eO3lbYv60z76XcvfOXcU/tBc2Gj8Da0D+n26K2v" +
           "DAnHj7JLvvXX7v/9D/3Oq9/NDu3/CyE8LVnSHAAA");
    }
    protected class TspanBridge extends org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildTextContent {
        protected TspanBridge(org.apache.batik.bridge.BridgeContext ctx,
                              org.apache.batik.bridge.SVGTextElementBridge parent,
                              org.w3c.dom.Element e) {
            super(
              ctx,
              parent,
              e);
        }
        public void handleAnimatedAttributeChanged(org.apache.batik.dom.svg.AnimatedLiveAttributeValue alav) {
            if (alav.
                  getNamespaceURI(
                    ) ==
                  null) {
                java.lang.String ln =
                  alav.
                  getLocalName(
                    );
                if (ln.
                      equals(
                        SVG_X_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_Y_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DX_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_DY_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_ROTATE_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_TEXT_LENGTH_ATTRIBUTE) ||
                      ln.
                      equals(
                        SVG_LENGTH_ADJUST_ATTRIBUTE)) {
                    textBridge.
                      computeLaidoutText(
                        ctx,
                        textBridge.
                          e,
                        textBridge.
                          getTextNode(
                            ));
                    return;
                }
            }
            super.
              handleAnimatedAttributeChanged(
                alav);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "cTEpYoLMDnhOL3ZKdMegPEstzzU+LE2b+JggNH4Zj4yh6zKT2thjiQJC0gG6" +
           "1rsaBTwmuzpIb+z2dm9+UT16GgGXtqyj/wZuLduux7PiqaP8Wp7buPt0Ov14" +
           "fm2X9YCym9jDt3vxyG9hn3zupZel/qewvYNs0Q1w8T54iNrJya7Cz9z+utnL" +
           "X3t2KYwvPfcvD43fqb3nDaSGHz01ydMif7f3yldabxM/vAedPUpo3PQOdZLp" +
           "+sk0xiVfDiPfHp9IZjx8tKyXs+XCwHI+erCsj9w6PXtLEziTm8B2409l4s4c" +
           "LOBBdqJwU9ovS+UFsbpP2rqVpUq64I5MhqGvL6NQztM6udz0dTJ878uKKIQe" +
           "0QRbMuVDSUdS6qBdlbfmyx8zuneDi3Ts6NLOGuMfd4c+kV8LoTcde3PIunFg" +
           "KA/e9A66fbsTP/vy5QsPvDz56zz1fvS+drELXVAi0zyecTpWP+/6sqLnal7c" +
           "5p/c/OeFEHrgNilUYMHLXdr0+S39B0Poymn6EDqX/x6nezGELu3ogKht5TjJ" +
           "r4fQWUCSVT/sHm4s/YaeashlEPqCGGY9dU03pbySZYjtMDlz0oOPNufqj9uc" +
           "Y07/5AlvzR+wDz0r2j5h3xA/9zLDvve18qe2TwqiKaRpJuVCF7pz+7px5J2P" +
           "31baoazz7ad/eM/nLz51CCP3bCe885ljc3v01sn7puWGebo9/cMHfv8dv/3y" +
           "N/P02f8C7c1oSlkgAAA=");
    }
    public int getNumberOfChars() { return getNumberOfChars(
                                             e);
    }
    public java.awt.geom.Rectangle2D getExtentOfChar(int charnum) {
        return getExtentOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getStartPositionOfChar(int charnum) {
        return getStartPositionOfChar(
                 e,
                 charnum);
    }
    public java.awt.geom.Point2D getEndPositionOfChar(int charnum) {
        return getEndPositionOfChar(
                 e,
                 charnum);
    }
    public void selectSubString(int charnum,
                                int nchars) {
        selectSubString(
          e,
          charnum,
          nchars);
    }
    public float getRotationOfChar(int charnum) {
        return getRotationOfChar(
                 e,
                 charnum);
    }
    public float getComputedTextLength() {
        return getComputedTextLength(
                 e);
    }
    public float getSubStringLength(int charnum,
                                    int nchars) {
        return getSubStringLength(
                 e,
                 charnum,
                 nchars);
    }
    public int getCharNumAtPosition(float x,
                                    float y) {
        return getCharNumAtPosition(
                 e,
                 x,
                 y);
    }
    protected int getNumberOfChars(org.w3c.dom.Element element) {
        java.text.AttributedCharacterIterator aci;
        aci =
          getTextNode(
            ).
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        int lastChar =
          getElementEndIndex(
            element);
        return lastChar -
          firstChar +
          1;
    }
    protected java.awt.geom.Rectangle2D getExtentOfChar(org.w3c.dom.Element element,
                                                        int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        java.awt.Shape b =
          null;
        if (info.
              glyphIndexStart ==
              info.
                glyphIndexEnd) {
            if (it.
                  isGlyphVisible(
                    info.
                      glyphIndexStart)) {
                b =
                  it.
                    getGlyphCellBounds(
                      info.
                        glyphIndexStart);
            }
        }
        else {
            java.awt.geom.GeneralPath path =
              null;
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (it.
                      isGlyphVisible(
                        k)) {
                    java.awt.geom.Rectangle2D gb =
                      it.
                      getGlyphCellBounds(
                        k);
                    if (path ==
                          null) {
                        path =
                          new java.awt.geom.GeneralPath(
                            gb);
                    }
                    else {
                        path.
                          append(
                            gb,
                            false);
                    }
                }
            }
            b =
              path;
        }
        if (b ==
              null) {
            return null;
        }
        return b.
          getBounds2D(
            );
    }
    protected java.awt.geom.Point2D getStartPositionOfChar(org.w3c.dom.Element element,
                                                           int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getStartPoint(
                 info);
    }
    protected java.awt.geom.Point2D getStartPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexStart))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexStart);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexStart);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          0,
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected java.awt.geom.Point2D getEndPositionOfChar(org.w3c.dom.Element element,
                                                         int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return null;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return null;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        if (info ==
              null)
            return null;
        return getEndPoint(
                 info);
    }
    protected java.awt.geom.Point2D getEndPoint(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info) {
        org.apache.batik.gvt.font.GVTGlyphVector it =
          info.
            layout.
          getGlyphVector(
            );
        if (!it.
              isGlyphVisible(
                info.
                  glyphIndexEnd))
            return null;
        java.awt.geom.Point2D b =
          it.
          getGlyphPosition(
            info.
              glyphIndexEnd);
        java.awt.geom.AffineTransform glyphTransform;
        glyphTransform =
          it.
            getGlyphTransform(
              info.
                glyphIndexEnd);
        org.apache.batik.gvt.font.GVTGlyphMetrics metrics =
          it.
          getGlyphMetrics(
            info.
              glyphIndexEnd);
        java.awt.geom.Point2D.Float result =
          new java.awt.geom.Point2D.Float(
          metrics.
            getHorizontalAdvance(
              ),
          0);
        if (glyphTransform !=
              null)
            glyphTransform.
              transform(
                result,
                result);
        result.
          x +=
          b.
            getX(
              );
        result.
          y +=
          b.
            getY(
              );
        return result;
    }
    protected float getRotationOfChar(org.w3c.dom.Element element,
                                      int charnum) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return 0;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return 0;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info;
        info =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        double angle =
          0.0;
        int nbGlyphs =
          0;
        if (info !=
              null) {
            org.apache.batik.gvt.font.GVTGlyphVector it =
              info.
                layout.
              getGlyphVector(
                );
            for (int k =
                   info.
                     glyphIndexStart;
                 k <=
                   info.
                     glyphIndexEnd;
                 k++) {
                if (!it.
                      isGlyphVisible(
                        k))
                    continue;
                nbGlyphs++;
                java.awt.geom.AffineTransform glyphTransform =
                  it.
                  getGlyphTransform(
                    k);
                if (glyphTransform ==
                      null)
                    continue;
                double glyphAngle =
                  0.0;
                double cosTheta =
                  glyphTransform.
                  getScaleX(
                    );
                double sinTheta =
                  glyphTransform.
                  getShearX(
                    );
                if (cosTheta ==
                      0.0) {
                    if (sinTheta >
                          0)
                        glyphAngle =
                          java.lang.Math.
                            PI;
                    else
                        glyphAngle =
                          -java.lang.Math.
                             PI;
                }
                else {
                    glyphAngle =
                      java.lang.Math.
                        atan(
                          sinTheta /
                            cosTheta);
                    if (cosTheta <
                          0)
                        glyphAngle +=
                          java.lang.Math.
                            PI;
                }
                glyphAngle =
                  java.lang.Math.
                    toDegrees(
                      -glyphAngle) %
                    360.0;
                angle +=
                  glyphAngle -
                    info.
                    getComputedOrientationAngle(
                      );
            }
        }
        if (nbGlyphs ==
              0)
            return 0;
        return (float)
                 (angle /
                    nbGlyphs);
    }
    protected float getComputedTextLength(org.w3c.dom.Element e) {
        return getSubStringLength(
                 e,
                 0,
                 getNumberOfChars(
                   e));
    }
    protected float getSubStringLength(org.w3c.dom.Element element,
                                       int charnum,
                                       int nchars) {
        if (nchars ==
              0) {
            return 0;
        }
        float length =
          0;
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation currentInfo;
        currentInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastCharacterInRunInfo =
          null;
        int chIndex =
          currentInfo.
            characterIndex +
          1;
        org.apache.batik.gvt.font.GVTGlyphVector vector =
          currentInfo.
            layout.
          getGlyphVector(
            );
        float[] advs =
          currentInfo.
            layout.
          getGlyphAdvances(
            );
        boolean[] glyphTrack =
          new boolean[advs.
                        length];
        for (int k =
               charnum +
               1;
             k <
               charnum +
               nchars;
             k++) {
            if (currentInfo.
                  layout.
                  isOnATextPath(
                    )) {
                for (int gi =
                       currentInfo.
                         glyphIndexStart;
                     gi <=
                       currentInfo.
                         glyphIndexEnd;
                     gi++) {
                    if (vector.
                          isGlyphVisible(
                            gi) &&
                          !glyphTrack[gi])
                        length +=
                          advs[gi +
                                 1] -
                            advs[gi];
                    glyphTrack[gi] =
                      true;
                }
                org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation newInfo;
                newInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                if (newInfo.
                      layout !=
                      currentInfo.
                        layout) {
                    vector =
                      newInfo.
                        layout.
                        getGlyphVector(
                          );
                    advs =
                      newInfo.
                        layout.
                        getGlyphAdvances(
                          );
                    glyphTrack =
                      (new boolean[advs.
                                     length]);
                    chIndex =
                      currentInfo.
                        characterIndex +
                        1;
                }
                currentInfo =
                  newInfo;
            }
            else {
                if (currentInfo.
                      layout.
                      hasCharacterIndex(
                        chIndex)) {
                    chIndex++;
                    continue;
                }
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k -
                      1,
                    aci);
                length +=
                  distanceFirstLastCharacterInRun(
                    currentInfo,
                    lastCharacterInRunInfo);
                currentInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    k,
                    aci);
                chIndex =
                  currentInfo.
                    characterIndex +
                    1;
                vector =
                  currentInfo.
                    layout.
                    getGlyphVector(
                      );
                advs =
                  currentInfo.
                    layout.
                    getGlyphAdvances(
                      );
                glyphTrack =
                  (new boolean[advs.
                                 length]);
                lastCharacterInRunInfo =
                  null;
            }
        }
        if (currentInfo.
              layout.
              isOnATextPath(
                )) {
            for (int gi =
                   currentInfo.
                     glyphIndexStart;
                 gi <=
                   currentInfo.
                     glyphIndexEnd;
                 gi++) {
                if (vector.
                      isGlyphVisible(
                        gi) &&
                      !glyphTrack[gi])
                    length +=
                      advs[gi +
                             1] -
                        advs[gi];
                glyphTrack[gi] =
                  true;
            }
        }
        else {
            if (lastCharacterInRunInfo ==
                  null) {
                lastCharacterInRunInfo =
                  getCharacterInformation(
                    list,
                    firstChar,
                    charnum +
                      nchars -
                      1,
                    aci);
            }
            length +=
              distanceFirstLastCharacterInRun(
                currentInfo,
                lastCharacterInRunInfo);
        }
        return length;
    }
    protected float distanceFirstLastCharacterInRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first,
                                                    org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last) {
        float[] advs =
          first.
            layout.
          getGlyphAdvances(
            );
        int firstStart =
          first.
            glyphIndexStart;
        int firstEnd =
          first.
            glyphIndexEnd;
        int lastStart =
          last.
            glyphIndexStart;
        int lastEnd =
          last.
            glyphIndexEnd;
        int start =
          firstStart <
          lastStart
          ? firstStart
          : lastStart;
        int end =
          firstEnd <
          lastEnd
          ? lastEnd
          : firstEnd;
        return advs[end +
                      1] -
          advs[start];
    }
    protected float distanceBetweenRun(org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation last,
                                       org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation first) {
        float distance;
        java.awt.geom.Point2D startPoint;
        java.awt.geom.Point2D endPoint;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          layout =
          last.
            layout;
        info.
          glyphIndexEnd =
          last.
            layout.
            getGlyphCount(
              ) -
            1;
        startPoint =
          getEndPoint(
            info);
        info.
          layout =
          first.
            layout;
        info.
          glyphIndexStart =
          0;
        endPoint =
          getStartPoint(
            info);
        if (first.
              isVertical(
                )) {
            distance =
              (float)
                (endPoint.
                   getY(
                     ) -
                   startPoint.
                   getY(
                     ));
        }
        else {
            distance =
              (float)
                (endPoint.
                   getX(
                     ) -
                   startPoint.
                   getX(
                     ));
        }
        return distance;
    }
    protected void selectSubString(org.w3c.dom.Element element,
                                   int charnum,
                                   int nchars) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return;
        int firstChar =
          getElementStartIndex(
            element);
        if (firstChar ==
              -1)
            return;
        java.util.List list =
          getTextRuns(
            textNode);
        int lastChar =
          getElementEndIndex(
            element);
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation firstInfo;
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation lastInfo;
        firstInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum,
            aci);
        lastInfo =
          getCharacterInformation(
            list,
            firstChar,
            charnum +
              nchars -
              1,
            aci);
        org.apache.batik.gvt.text.Mark firstMark;
        org.apache.batik.gvt.text.Mark lastMark;
        firstMark =
          textNode.
            getMarkerForChar(
              firstInfo.
                characterIndex,
              true);
        if (lastInfo !=
              null &&
              lastInfo.
                characterIndex <=
              lastChar) {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastInfo.
                    characterIndex,
                  false);
        }
        else {
            lastMark =
              textNode.
                getMarkerForChar(
                  lastChar,
                  false);
        }
        ctx.
          getUserAgent(
            ).
          setTextSelection(
            firstMark,
            lastMark);
    }
    protected int getCharNumAtPosition(org.w3c.dom.Element e,
                                       float x,
                                       float y) {
        org.apache.batik.gvt.TextNode textNode =
          getTextNode(
            );
        java.text.AttributedCharacterIterator aci;
        aci =
          textNode.
            getAttributedCharacterIterator(
              );
        if (aci ==
              null)
            return -1;
        java.util.List list =
          getTextRuns(
            textNode);
        org.apache.batik.gvt.text.TextHit hit =
          null;
        for (int i =
               list.
               size(
                 ) -
               1;
             i >=
               0 &&
               hit ==
               null;
             i--) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun textRun;
            textRun =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            hit =
              textRun.
                getLayout(
                  ).
                hitTestChar(
                  x,
                  y);
        }
        if (hit ==
              null)
            return -1;
        int first =
          getElementStartIndex(
            e);
        int last =
          getElementEndIndex(
            e);
        int hitIndex =
          hit.
          getCharIndex(
            );
        if (hitIndex >=
              first &&
              hitIndex <=
              last)
            return hitIndex -
              first;
        return -1;
    }
    protected java.util.List getTextRuns(org.apache.batik.gvt.TextNode node) {
        if (node.
              getTextRuns(
                ) ==
              null) {
            node.
              getPrimitiveBounds(
                );
        }
        return node.
          getTextRuns(
            );
    }
    protected org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation getCharacterInformation(java.util.List list,
                                                                                                        int startIndex,
                                                                                                        int charnum,
                                                                                                        java.text.AttributedCharacterIterator aci) {
        org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation info =
          new org.apache.batik.bridge.SVGTextElementBridge.CharacterInformation(
          );
        info.
          characterIndex =
          startIndex +
            charnum;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            if (!run.
                  getLayout(
                    ).
                  hasCharacterIndex(
                    info.
                      characterIndex))
                continue;
            info.
              layout =
              run.
                getLayout(
                  );
            aci.
              setIndex(
                info.
                  characterIndex);
            if (aci.
                  getAttribute(
                    ALT_GLYPH_HANDLER) !=
                  null) {
                info.
                  glyphIndexStart =
                  0;
                info.
                  glyphIndexEnd =
                  info.
                    layout.
                    getGlyphCount(
                      ) -
                    1;
            }
            else {
                info.
                  glyphIndexStart =
                  info.
                    layout.
                    getGlyphIndex(
                      info.
                        characterIndex);
                if (info.
                      glyphIndexStart ==
                      -1) {
                    info.
                      glyphIndexStart =
                      0;
                    info.
                      glyphIndexEnd =
                      info.
                        layout.
                        getGlyphCount(
                          ) -
                        1;
                }
                else {
                    info.
                      glyphIndexEnd =
                      info.
                        glyphIndexStart;
                }
            }
            return info;
        }
        return null;
    }
    protected static class CharacterInformation {
        org.apache.batik.gvt.text.TextSpanLayout
          layout;
        int glyphIndexStart;
        int glyphIndexEnd;
        int characterIndex;
        public boolean isVertical() { return layout.
                                        isVertical(
                                          );
        }
        public double getComputedOrientationAngle() {
            return layout.
              getComputedOrientationAngle(
                characterIndex);
        }
        public CharacterInformation() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "PX24mXrdl6/BwCRrqO7r1l1wVwd1w2Jw05Tlrilv+NmxUhQEUBoH9GxCcfqf" +
           "RWRThQ0rVI2HK6wdocPXCa0CRqFFkUVBYXRfsmCR/ok5vncQVJvQNAULqhfN" +
           "6L9WJc/C/xu3u62u2o1OrGPT+wpKt9Ol1aDsCUvpExWsSIfHiu1VjrWCTZ6p" +
           "sHaSDscJmpfChLYkWWhEhgwZOnUWk31qSsG3M2BA0sC7+Hb2e/rO7ZcjaE6p" +
           "p4J8kbPqTh4d4PbPLXr35G914rlTzXUdpx76I2txC+9pjVATJLOK4iz2HN8B" +
           "3cBJmZmxkZd+PB/9gKCOMoKBsfgH0+AMpz9HUIuXnqAa9tdJ90MIa5sOtuIf" +
           "TpIXITEDCf28oOet1MJ6CFrzBnnNm/O50bXgorbbucgByEtciMfenfPolOUv" +
           "z1CIndq89ZGb9z/H23RRESYn6S4zINnzx4ACwi0uu1t+r8DA8ltNL9QvzUO8" +
           "65nAKRuLHIg/1k93eppWs6fQu755eu3F1w4FrkFxsx35BIJmby/uDnJ6FuB3" +
           "e6RUWQP4z/rp3oZ3d1755C1fK2vCEC+EuipxxMVjF69Hk7r+bT+qD6MamaZc" +
           "1ro8OKEOY3HMcFVJgYSWVQtP1E00PAX6Js0sYxl0ZmGWvuAQ1F1cMBa/akF/" +
           "Oo6N9XR3hvqenJDVdecqs6zI7z61NMRaPDKo69arhr+JWV7X2d29zK7//wDc" +
           "Ji66XBoAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL1aeewj112f/W12N0mT7CbNRZo729LU5Tf22B7bSlviGR9z" +
           "eDy+7Rmgm/Hc9+0ZuwTaStCoLSGFTRukNvBHylGlBxUVlUpREIK2aoVUVHFJ" +
           "tBVColAqNX9QEAXKm/Hv3t2ECISl3/s9v+P7vufnfd97fvF70JkwgAqea61V" +
           "y4125TTaNazqbrT25HCX6lUHQhDKEm4JYTgBbZfEhz9z/gc/fEa7sAOd5aHX" +
           "C47jRkKku044kkPXWslSDzp/2Nq2ZDuMoAs9Q1gJcBzpFtzTw+ixHvS6I1Mj" +
           "6GJvnwUYsAADFuCcBbh5OApMull2YhvPZghOFPrQz0GnetBZT8zYi6CHjhPx" +
           "hECw98gMcgkAheuz7zMgVD45DaAHD2TfynyFwM8W4MsfeeeFz56GzvPQed0Z" +
           "Z+yIgIkILMJDN9myvZSDsClJssRDtzqyLI3lQBcsfZPzzUO3hbrqCFEcyAdK" +
           "yhpjTw7yNQ81d5OYyRbEYuQGB+IpumxJ+9/OKJagAlnvPJR1K2EnawcC3qgD" +
           "xgJFEOX9KdeZuiNF0AMnZxzIeJEGA8DUc7Ycae7BUtc5AmiAbtvazhIcFR5H" +
           "ge6oYOgZNwarRNA91ySa6doTRFNQ5UsRdPfJcYNtFxh1Q66IbEoE3XFyWE4J" +
           "WOmeE1Y6Yp/v9d/29LscwtnJeZZk0cr4vx5Muv/EpJGsyIHsiPJ24k1v6X1Y" +
           "uPOLT+1AEBh8x4nB2zG//7MvP/7W+1/68nbMG64yhl0ashhdEl9Y3vL1e/FH" +
           "G6czNq733FDPjH9M8tz9B3s9j6UeiLw7Dyhmnbv7nS+N/pR79yfk7+5AN5LQ" +
           "WdG1Yhv40a2ia3u6JQdd2ZEDIZIlErpBdiQ87yehc6De0x1528oqSihHJHSd" +
           "lTeddfPvQEUKIJGp6Byo647i7tc9IdLyeupBEHQH+IPugaDXPQXln+3/CLJh" +
           "zbVlWBAFR3dceBC4mfyZQR1JgCM5BHUJ9HouvAT+b/5EabcGh24cAIeE3UCF" +
           "BeAVmrzthJeBLqkyPJ51JyCaMrSQnQjLG3czt/P+vxdMMw1cSE6dAsa59yQ0" +
           "WCCqCNeS5OCSeDnG2i9/6tJXdw5CZU93EdQEq+5uV93NV93drrp7tVUv4hrA" +
           "KRFEEwlsEdg5ZkCnTuUc3J6xtHUNYFgTQAQAz5seHf8M9cRTD58GPukl1wGr" +
           "ZEPha2M4fggqZA6dIvBs6KXnkvfMfr64A+0cB+NMDNB0YzZ9kEHoAVRePBmE" +
           "V6N7/n3f+cGnP/ykexiOx9B9DyWunJlF+cMnFR64oiwB3Dwk/5YHhc9d+uKT" +
           "F3eg6wB0ALiMBODeAInuP7nGsWh/bB85M1nOAIFzVVtZ1z7c3RhpgZsctuSe" +
           "cEtevxXoGIa2xfF4yHpf72Xl7VvPyYx2Qoocmd8+9j72V3/2j+Vc3fsgfv7I" +
           "tjiWo8eOAEdG7HwOEbce+sAkkGUw7m+fG/zqs99730/lDgBGPHK1BS9mJQ4A" +
           "A5gQqPkXvuz/9be++cI3dg6dJgI7Z7y0dDHdCvkj8DkF/v4r+8uEyxq2QX8b" +
           "voc8Dx5Aj5et/KZD3gAIWSAuMw+6OHVsV9IVXVhacuax/3H+jaXP/fPTF7Y+" +
           "YYGWfZd666sTOGz/MQx691ff+a/352ROidkmeKi/w2FbZH39IeVmEAjrjI/0" +
           "PX9+3699SfgYwGiAi6G+kXOog3J9QLkBi7kuCnkJn+hDsuKB8GggHI+1I8nK" +
           "JfGZb3z/5tn3//DlnNvj2c5RuzOC99jW1bLiwRSQv+tk1BNCqIFxlZf6P33B" +
           "eumHgCIPKIoA4EI2AGiUHvOSvdFnzv3NH/3xnU98/TS004FutFxB6gh5wEE3" +
           "AE+XQw0AWer95ONbd06uB8WFXFToCuG3DnJ3/u0cYPDRa2NNJ0tWDsP17n9n" +
           "reV7/+7frlBCjjJX2aNPzOfhFz96D/6O7+bzD8M9m31/eiVCg8TucC7yCftf" +
           "dh4++yc70DkeuiDuZY0zwYqzIOJBphTup5IgszzWfzzr2W7xjx3A2b0noebI" +
           "sieB5nBnAPVsdFa/8QS2ZLqH7geY8v49bHn/SWw5BeWVx/MpD+Xlxaz48SPu" +
           "+SgIaEtYg8ws778jgt58xUakroCqMqNl+9DYE5xePmELXVlZzorm1uDoNZ3j" +
           "seOs3wtY/uAe6x+8Buvkq7B+XrXWnkY6kpyCDDuIXtnNBoFuA5xc7aVy8JO3" +
           "fcv86Hc+uU3TTvrUicHyU5ff/6Pdpy/vHEmOH7kiPz06Z5sg55zenLObRelD" +
           "r7RKPqPzD59+8gu//eT7tlzddjzVa4OTzCf/4j+/tvvct79ylRziNEjjT1iF" +
           "eo1WyZK3p/es8vQ1rLJ4FavcfGiVtiNljcMTXHGvkas3AG4+tMfVh67B1aVX" +
           "4eoW8TBnApxdja0nXpWtrSFPgW3wDLJb2y1m35WrL3w6q74ZhFeYn/3ADEV3" +
           "BGufnbsMS7y4v0POwFkQANxFw6rth+GFHJszKNndHqBO8Pro/5hX4Ha3HBLr" +
           "ueAs9oG/f+Zrv/zIt4ALUdCZVQZewNeOrNiPs+PpL7747H2vu/ztD+TbP9j7" +
           "Bx9uX3g8o+q/ksRZYWSFuS/qPZmo4zy57glhxOS7tCwdSNs/Is8oAnu9+7+Q" +
           "NrrlXqISks39T6/EyUgyTVNbYRsrB6tzCBatpmqzY0wJwwyM4WBG2Xa3qSTJ" +
           "yFaWLOmP6nEabaJyVMPLcWHDInPZsdqtpYph+HjRJJfDHmzRakTx2HwolARt" +
           "1iu1BbI4AoeqCUcLEVNUxnyoapO64KGzqBCWmXJcNghXg4XQMRriprxZrFeF" +
           "RVnpI9LKxYLJsI+gbtvDzfbGRZppF11IU6adhI1xjAtztIUstUoBh4mGWYZX" +
           "DgoTyUz3cTOySVbnWLrPWJzJVLj5mvYorLNoVy2BoUR31F/ilDHpYmvKFYYI" +
           "su6KNVfXNzTfwScMPuU6XELa+nTIhTrVYzqakLB4xxS4Pt62J4IxGDeayyGH" +
           "6J4Jcy2qGGtOjej6iz7CyjzWm7Ul1TKGutbj8enUnJbH9mYwHFulCWXR9Mgl" +
           "K6MKXbMGYThE1my5I5laXFnYRqHQWOioxlta5ON+1277djjgStQw7bVnw3CD" +
           "1IZimxcTGO36Pu1iJsu5FEqurNawjLl4s9ZHkWiiKsNNyAf9RjdiCL6n0ALe" +
           "m+E43gnCcnE4a607xnJEOUzYZqRwMXI2dCtyXRqRF1JtRqQ+Pzd8dFSMBqiH" +
           "bybEtEeHxgxLRhqOJeNmwugGQy0prWG6Y6tL+ZYa9okQb/d0I/Xk5WpmdVh/" +
           "2COHTcfeFBk7NNQS4tnFoI5PXN4edVzN7DR4sIfRG3CepGmzSUkIUpJijlui" +
           "k8RFcLzFtfmx2tc3c9orr9GgXQmN/lTCUz4Jh81uFGEeW5wZuj/XZmozWKzb" +
           "nXa7P5oKqoxNpkVMcIttsgumr+2UXgrFXsWuaJrMtDfKYjxSzPG0P90MS825" +
           "Gvl1vps49Q7tpMWQhRsbLl4tXbLgN1FTLJgdB3fNnuUkHWYxQm2O37Qxl68l" +
           "mLmcFccsXiiuCIU0MGYUETbF1gvsqmyty368GvPTyiZIJv1pl1x0TEscUCU3" +
           "NnxYgR3HR1VOWnr2OppUe2GZ73GRQNeKVYLH7dWyaSyGG7uzrvfhwlIb1WG1" +
           "Ba9dkktw1+dNJsWIsDiM3HpI9w1e64xCPJmRXGnen6G2EnCzYa+cdvh0kSI0" +
           "ZRaZoW0I7qyPTSbIoKq6+CwatjeLZoQmdqSsyz2vWSzUax5Ot5FCey7hTLGi" +
           "9dUBXIyGlDeZM4Zq6iTp+yXXFWxtqhS8oWY4nNatUzNnGllkq1IGHxSEpElb" +
           "wBkN0uwK5lCl2qNRsElnLdykp9OWizDLyO1GFUdvlpaUbHC81+06cK0+2HTa" +
           "vQ1WKxfEZrVeKw9dBo+6UXOKj6JUHPs1JRz0RbizkCVj5CM93vCbBba1ICcJ" +
           "sp5WBvVSF/em5RVarGATMlrbzMDA160WM2xVFBNpsh3OJjBDQ/rFZpsjJkbd" +
           "666W/WrV74U0Z5FKkAiraZ+yRhM7KNeFsdKkSR2RVy2zochCWTMwuNqcV8Zm" +
           "bxCmfcIYa0m9ltqCjs+agUN6VLNguApFuehQRPs0VVcQo7Cp9apEy24GntYS" +
           "mxzPNcYYXheL8qCjdnq1vtaow4XBJoUlv6/5FdMMC1TKp1Ov5TVWwdIvp+Ki" +
           "1yFjDIOFeWFAlKYtUe0I7aQTdxJMs2CR6TSMYtXtLlGLJHCjP6DLQ8+ocX2q" +
           "W3IrMMfg9REvdQ2DmTqtZMyoCZysDFZ1yrAhlQtVzQrXjobwxEKDMa8vYuPF" +
           "eDNTuUJYAHhr82qLGMGs1m40onFfbUS80CSAK5NEI8JTAm2SqyYzBzm9NZgX" +
           "CnV46ZXgEsJi1DRIQ0Gdx7Q3Sid8HXXqLNsqw/B4UXFNiSSNsR3D2Dzu4SDR" +
           "K9bZBSKTWKLbSbeCDBxXmuqtepUehhQmDYI6C4OTd7hSCL2oLSJR5a16Qq9R" +
           "eLhE4K4yd4uSUp4QUrpcpvpk0kJ0obieaOGmxpdrBsNwXI82pQheit3yQuPZ" +
           "oUo2i62FNRbTpNPqTkh22ZKrZjS01/W01kcGaQmddGUuRgpjN6VpvVKA4Yhg" +
           "ilw9LtuTcWyGnlcICWyJLLC0V25qyXzopEll40lLSfEQqg2o+vW4xah21+Fq" +
           "/WpvXoNFkLKimKh0Kx11RPY5kVGbAxGtuqGvBUIEo+kYXkolNBqu0L7fJkZY" +
           "1zYStiL6rqSmCCe4rbGjlNtSBxnXWy4359XGlMc7foOcW+WlqbnpwFYZW5F6" +
           "60ojiJ2yLWBrph8TNrvq2zZfrcyImQ/cHl610HqhXoAHXq0xWU96hfqASqsF" +
           "dlkQihpFDIyAKs5lro3NXTVI64yE81U4qhGw2qzzKzIJrIVHBhuz24wny1W1" +
           "XjXhmFi1VhvBQDzDb8+LaEyNhqIzXqfr1jxqMZ16NGRrq3l5MZV6CIXiFbVa" +
           "rkS2YbONeXfpDFa6XRqMap6u+H63MeoUJ0tuvPJbTmxsXIVLE8yYi0E3LuhJ" +
           "0XWbjRJf6iw5naabZLuEq4wnVLF+aWaRjQnIZAaoZQuGKap9nGZUmQkJSRmS" +
           "YjKojYtLV15Jw7BIcFyVG2pFz23Uk1Klzs4r3owOxX608a0Ja3ghHmhEa6hi" +
           "dqdZGWoeYgosjzG2PvLWmIMVNri33tSkQQ22ZjV53CoMaaTTBHrvkuxi5XgJ" +
           "EaWWqfhCd5705AYzqtdWTIlm4f4I12qhx1njCoOh1NCJluWG06gNVgOxYtej" +
           "er9lNBt9QqkUZWJMq5toxVPctDGiWCKqMTI9Wi5Yc5oGRLpS+jUFFhqroVyd" +
           "0eU4dJKWRJUHcKENrxJELgyYgJL9Bh1Z/ki39MLQnc2XqwXSWVsJ60/AflcG" +
           "iV9r2qbb01lpbimSKc60dRntC0w1Sub9RmzK6xo/tojiWsNW2hx1Vv12ra5K" +
           "I70QNbiGUF/IxclgbNNFfsXOUZyPglFc7M5QdtIibMdiqyOE8DYbjVjIbWRu" +
           "lsYePa+gSxdfjnqhhVWsHkh6Fu0NP+8yLbixaC5UvkcSGLYadgFM+jw+IgST" +
           "Kc41eUpXeN7r1Atha0rPHTeWZgW/BjIfI1JXM4IrwAbvKbidtok53FhVeREp" +
           "oUIQTOrVqNetzNF2VeJnPtaR51pCrJrrRCmUAydSlQnLFlS84/jTBlKrwmJ3" +
           "EyCpQBk1jy/WuQFVnA0WSMVeBJKFwliCjwKfrQUlq5TMEqmUIFRSrE6sQLdW" +
           "hb6dTrVhe4q5RKOb4qLiK6P5aKINi8GMRAgaTSRXHCxwoYiP/E7HnM4wbjFS" +
           "Qhsfwa5ZXTnicEathv3mtOdrSh/tNeaUCONwGpdjFIkRt8QG3cGkkHh01GCt" +
           "ktAK8enKa6fzcEwClIxLMyOY4xMe9UJCGLdCkbKBUrQeZ87nWltTE551pnOz" +
           "XPLHYbfMIFizGOK1ArFEZDhga7xoCG3U8ypU3VwO/IlWkSqD5aC3CMrVbqNU" +
           "CazJBsSxl9ZQEolSvNDwjFlzQvVYuqJvEKJfx8oiRtm8nZq8VBhgcEOlcZZx" +
           "aSxUVKJYaDLepkFMyXjh+E2hEUlUo8iQQjVko5hUJh4JNvZ2C1eQusvKUYkB" +
           "eNEJNpjj9G2YrRaXC9UNlstYVLF1OxJ1RpEdZeBa7HS1KeHgGOvXG3x32djA" +
           "BFIejdpjzkHHlQ3ZdzZppYknejGOS1EhqLeadSvq9xrD1WbK1tGq06RHcY8g" +
           "VbhkNsqy581DVBnGtWpVjsudUlLpBGYnDdNyFSMpe7mG45ZDoZ0YK8voaDof" +
           "DiobOPDKLl+WSmASXlJoZIW38UI71r00ZWZGB20QZi0oLCcFv4Uygi3wYilw" +
           "6yzdZrkywYidGaVy4/lsGA1K7WJx0FygVFgMudQq8nZ3voqbw1KnJDKYAAtm" +
           "B2ZdtN9YjMraypcdqjWTZNEP0Q1Z26ClPjMSBi3aRRtCoAUFaj6rLRAJaWzo" +
           "GgwnLZHSUXSBueAw+Pa3Z8fEJ1/b8fXW/KR+8O4JTq1Zh/0aTqjp1RfciaAb" +
           "vMCNZDGS82sSIz249sivLm5/hZeDI7erUHazdN+1HjvzW6UX3nv5eYn9eGln" +
           "7z5kHEFn996gD+nsADJvufb1GZM/9B5elX7pvf90z+Qd2hOv4THogRNMniT5" +
           "O8yLX+m+SfyVHej0wcXpFU/Qxyc9dvy69MZAjuLAmRy7NL3vQK13Zep6CKjz" +
           "8p5aL5+8TTo06xX2OpU7yNYtXuHG/9lX6PtIVjwTZdfIMzmIdFGwrnYFcm7p" +
           "upYsOIfu9aFXuwA5ulLe8EsHQt+ZNZaAsM/tCf3c/73QL7xC329mxa9H0BtU" +
           "OcpuvGLg7mygy87WX5qOaslX08JZyY2Xe125En7jtSghjaDbr/ZMun/B9tbX" +
           "8uAKIuPuK37zsf2dgvip589ff9fz07/MXxcPfktwQw+6Xokt6+hV/pH6WS+Q" +
           "FT1Xzw3bi30v//fZCLrrGowBhWwruQS/ux3/uQi6cHJ8BJ3J/x8d93ngc4fj" +
           "AKlt5eiQL0TQaTAkq/6Bd5VryO2LRnrqOPIcGOe2VzPOEbB65BjK5L+52UeE" +
           "ePurm0vip5+n+u96Gf349vFTtITNJqNyfQ86t32HPUCVh65JbZ/WWeLRH97y" +
           "mRveuA9/t2wZPnT7I7w9cPXXxbbtRfl74Obzd/3e237r+W/mt6L/DTi0yDIM" +
           "JQAA");
    }
    public java.util.Set getTextIntersectionSet(java.awt.geom.AffineTransform at,
                                                java.awt.geom.Rectangle2D rect) {
        java.util.Set elems =
          new java.util.HashSet(
          );
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (elems.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem))
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                glBounds =
                  at.
                    createTransformedShape(
                      glBounds).
                    getBounds2D(
                      );
                if (!rect.
                      intersects(
                        glBounds)) {
                    continue;
                }
            }
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        elems.
                          add(
                            elem);
                        break;
                    }
                }
            }
        }
        return elems;
    }
    public java.util.Set getTextEnclosureSet(java.awt.geom.AffineTransform at,
                                             java.awt.geom.Rectangle2D rect) {
        org.apache.batik.gvt.TextNode tn =
          getTextNode(
            );
        java.util.Set elems =
          new java.util.HashSet(
          );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return elems;
        java.util.Set reject =
          new java.util.HashSet(
          );
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element elem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (elem ==
                  null)
                continue;
            if (reject.
                  contains(
                    elem))
                continue;
            if (!isTextSensitive(
                   elem)) {
                reject.
                  add(
                    elem);
                continue;
            }
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null) {
                continue;
            }
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (rect.
                  contains(
                    glBounds)) {
                elems.
                  add(
                    elem);
            }
            else {
                reject.
                  add(
                    elem);
                elems.
                  remove(
                    elem);
            }
        }
        return elems;
    }
    public static boolean getTextIntersection(org.apache.batik.bridge.BridgeContext ctx,
                                              org.w3c.dom.Element elem,
                                              java.awt.geom.AffineTransform ati,
                                              java.awt.geom.Rectangle2D rect,
                                              boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return false;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return false;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return false;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.AffineTransform at =
          tn.
          getGlobalTransform(
            );
        at.
          preConcatenate(
            ati);
        java.awt.geom.Rectangle2D tnRect;
        tnRect =
          tn.
            getBounds(
              );
        tnRect =
          at.
            createTransformedShape(
              tnRect).
            getBounds2D(
              );
        if (!rect.
              intersects(
                tnRect))
            return false;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds ==
                  null)
                continue;
            glBounds =
              at.
                createTransformedShape(
                  glBounds).
                getBounds2D(
                  );
            if (!rect.
                  intersects(
                    glBounds))
                continue;
            org.apache.batik.gvt.font.GVTGlyphVector gv =
              layout.
              getGlyphVector(
                );
            for (int g =
                   0;
                 g <
                   gv.
                   getNumGlyphs(
                     );
                 g++) {
                java.awt.Shape gBounds =
                  gv.
                  getGlyphLogicalBounds(
                    g);
                if (gBounds !=
                      null) {
                    gBounds =
                      at.
                        createTransformedShape(
                          gBounds).
                        getBounds2D(
                          );
                    if (gBounds.
                          intersects(
                            rect)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static java.awt.geom.Rectangle2D getTextBounds(org.apache.batik.bridge.BridgeContext ctx,
                                                          org.w3c.dom.Element elem,
                                                          boolean checkSensitivity) {
        org.apache.batik.dom.svg.SVGContext svgCtx =
          null;
        if (elem instanceof org.apache.batik.dom.svg.SVGOMElement)
            svgCtx =
              ((org.apache.batik.dom.svg.SVGOMElement)
                 elem).
                getSVGContext(
                  );
        if (svgCtx ==
              null)
            return null;
        org.apache.batik.bridge.SVGTextElementBridge txtBridge =
          null;
        if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge)
            txtBridge =
              (org.apache.batik.bridge.SVGTextElementBridge)
                svgCtx;
        else
            if (svgCtx instanceof org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext) {
                org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext childCtx;
                childCtx =
                  (org.apache.batik.bridge.SVGTextElementBridge.AbstractTextChildSVGContext)
                    svgCtx;
                txtBridge =
                  childCtx.
                    getTextBridge(
                      );
            }
        if (txtBridge ==
              null)
            return null;
        org.apache.batik.gvt.TextNode tn =
          txtBridge.
          getTextNode(
            );
        java.util.List list =
          tn.
          getTextRuns(
            );
        if (list ==
              null)
            return null;
        org.w3c.dom.Element txtElem =
          txtBridge.
            e;
        java.awt.geom.Rectangle2D ret =
          null;
        for (int i =
               0;
             i <
               list.
               size(
                 );
             i++) {
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun run;
            run =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                list.
                get(
                  i);
            org.apache.batik.gvt.text.TextSpanLayout layout =
              run.
              getLayout(
                );
            java.text.AttributedCharacterIterator aci =
              run.
              getACI(
                );
            aci.
              first(
                );
            java.lang.ref.SoftReference sr;
            sr =
              (java.lang.ref.SoftReference)
                aci.
                getAttribute(
                  TEXT_COMPOUND_ID);
            org.w3c.dom.Element runElem =
              (org.w3c.dom.Element)
                sr.
                get(
                  );
            if (runElem ==
                  null)
                continue;
            if (checkSensitivity &&
                  !isTextSensitive(
                     runElem))
                continue;
            org.w3c.dom.Element p =
              runElem;
            while (p !=
                     null &&
                     p !=
                     txtElem &&
                     p !=
                     elem) {
                p =
                  (org.w3c.dom.Element)
                    txtBridge.
                    getParentNode(
                      p);
            }
            if (p !=
                  elem)
                continue;
            java.awt.geom.Rectangle2D glBounds =
              layout.
              getBounds2D(
                );
            if (glBounds !=
                  null) {
                if (ret ==
                      null)
                    ret =
                      (java.awt.geom.Rectangle2D)
                        glBounds.
                        clone(
                          );
                else
                    ret.
                      add(
                        glBounds);
            }
        }
        return ret;
    }
    public static boolean isTextSensitive(org.w3c.dom.Element e) {
        int ptrEvts =
          org.apache.batik.bridge.CSSUtilities.
          convertPointerEvents(
            e);
        switch (ptrEvts) {
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE_STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   VISIBLE:
                return org.apache.batik.bridge.CSSUtilities.
                  convertVisibility(
                    e);
            case org.apache.batik.gvt.GraphicsNode.
                   PAINTED:
            case org.apache.batik.gvt.GraphicsNode.
                   FILL:
            case org.apache.batik.gvt.GraphicsNode.
                   STROKE:
            case org.apache.batik.gvt.GraphicsNode.
                   ALL:
                return true;
            case org.apache.batik.gvt.GraphicsNode.
                   NONE:
            default:
                return false;
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "SLT4yrJZwgauYY5uLDTuEb20NP0U0ImJ");
    public static final java.lang.String jlc$ClassType$jl7$1 =
      ("s1gK7ByICqGonApXvy0qWZAc1TDoL6rfFh3/gmR77nciT4Gdg/EhEhU2J6Fz" +
       "KFJTwkIGA93ZnQeqBcaLzHbAF9wEvCB4Ond6HuR8M0ewOTh4kagHmzOzFJnt" +
       "1AvbXV9a1Ib7lJgdEtJwAXN0u0VmcdXx+vTUMjkEXl2aARBwyibu4yzsK0Bg" +
       "/gCIUNTfwtqMzc+dOWgYGNB0tddQdBPRIlBG179J6Pp3DHay7iDqGH7UwTDZ" +
       "p0J6VO8CA7rxIAAO869FhO2vReQvMIju9lsGCUnivT1+/pVriDI6/hXVtFiW" +
       "AKdPc26fDl4sIlFhwxfd5bD+OQnruHVFdK9FpnPWm/V4MmVmDJXzc5vDxJ2l" +
       "GZQ5DWC8y+G8K2GChq7l9rQHwHY29yy8nypJ0QPdbwEGpwr/pYszo/dK+Lof" +
       "g4MOX24tpSk4fI1/wwvcyQ93UJ+0nqXAzqXgS5iisNV0L8mmTHxXwtKDGBxm" +
       "oxHI0tpURqe74riGt6IPlGyQbxLfmH+Sd2P+E+dHlKKwFeWdssclrOD63+h/" +
       "glvFNlTqUXWTbl/s0ZvvB+dlDBwUv7Ek/PbS7LwvYLKvNsbv3Vc9Yda+S56j" +
       "X0DLfllxUoxMGMgkk+5PA7l+l6cNdUCjvE6i4VS6TXb0KLRzglEui5T3Z7cw" +
       "jD7N4v+E77Pjjm+RMnp2x3vOIlVOPEiK/XBHed4iEYiCP19I25Z+tWjIzd6P" +
       "3b2REyNrjI3XzeXMZguEzChUIFkR9yfU0H2g3yi1NwPNdPHd2u/bt77j6jfO" +
       "+gL7hFs8qWzHrbbIxBipYF+To4lG8nZ+d6dmp1XeuvydKfdXLrU3VZ3KMuzo" +
       "/VxHAclFoKpp1Ik5nu+bmbXZz5z9/MD5D/14Z/kzYRLaTEIKWLrN+V+bGktn" +
       "DLJwc8xvA/eNikE/vbam6uUrn/rL86Fp9KNehG35vkAm0Re/7aEXugbS6c+E" +
       "SWUbKdPw5R76KaymbXq3Gh8xcvaDL++3rQpupzoFFVjBXgplhhM6OXsVNxG2" +
       "yJL8XcfzP4tYlUyNqga1WZjMZM8WrJl02n2XMosGjzxM3+cFbeyLtafTfJ95" +
       "un8DuSidxpoa/RP+89A/AIhmPHmIeAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "06lvArlmyYPhiF7Yrof1Vd0qV4eG06mT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "cFCyH8tQEsElFQwysVIkiXZzzflOySehZtdrDyjVwLN4IWyXGbXUEjFhrUuT" +
       "plzEJlNOAmoZN5hWcyBuwCNXNdyAEjkC/UCxWPPH3tpL3W6XX3QE3bMMY9gc" +
       "CQFPJXh10ychQdZSuh7OLG5DrXSxMp0vhvMhNPX7VrnqVIWhG+CLNBnWinJX" +
       "UjdkKGqs1m831g6EriemkniuWGLoIrCqJZgwbLpnEyoMw5mJ+dvzWbdHbrNu" +
       "T1XOa9+2t16ZJa85mqeX/91T2K2APjyfmKeX53xstzx3N7PtdbfN2szmDAaR" +
       "fjhtM99AwAmzCb9P3Glxez7Z92Pv/uAzyuinK4dTtT8VFm6Ervdtlhqp1olH" +
       "90FNb7jzxOZhvrb/ePnc5979nx9n32p89zkWBT95is7TVf6T4Se+gL9W/ocH" +
       "hatHi+lu23Xg1kJvunUJ3X2+Gq59h71lId0TR5J4eDcHtfBTO0n81OkZk8ey" +
       "Pnu65LdutSW/d+Yq0Csv3nPv0Sx5KCw8X1dD0pVFi9qR/qdH6nXlhc/WfZ6s" +
       "NLtw5QW34svW3P/MDt/PXD6+V+659+oseVlYuB/gO5TQoUK//E7TkLcTj48Z" +
       "8MQFGPBodvFV4Pi5HQN+7rwMQJ6VAXuWAF/JDMaVN2wZkDXSbAL5IQOeuI0B" +
       "ehTevCVXjr94Afz5er03gOMzO/yfuRwFOMgzHBxCec1+We72Nsky/27Olrfs" +
       "YVlmqq9AYeFh2VfFUMV90TNMOTjJuVeeybnbcubca1+Ae/k622ztyJd23PvS" +
       "5WvPcM+9bC3klV5YeNTcrjU2T/Eju40cQyUuAPUl2cVXguNPdlD/5HKg7hQl" +
       "e9hbj+U/2wP67VnCbptMZhOP+pCjFUJiHN7UVdD70a7phFX0mAPcRTnwagDm" +
       "yrbs9nxxDlw5zrAFr+8Bb2aJFBZeYAYnlmJkOT95jFK+BDlfecEO5QueI5TB" +
       "HpTrLHGAiLco86U1pzC6F8CYb7dRB9S8aofxFefFeLbRu3rkLu50OW9/OaLv" +
       "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" +
       "21Hwumfh+sv2cP0VWfIo6LYB1490E3hP");
    public static final java.lang.String jlc$ClassType$jl5$2 =
      ("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" +
       "Sen/9Ogvvvlnnvn3+adD/z/LXj2BS48AAA==");
}
