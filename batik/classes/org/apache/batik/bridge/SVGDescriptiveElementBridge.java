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
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1aC2wcxRmeOzuO48TxI++HncRxAnHCHeEdzMtx4sThHLux" +
       "4wqnxNnbmztvvLe72Z2zz4bQJCVNWomUpgEChbRSg4AoEFRBaUVBqWgLFFqV" +
       "VymteKhFalpKIUKFqhTo/8/u3u7teTc6qVdLM96bmX9m/m/++eb/d/bk+2SS" +
       "oZNGqrAIG9OoEVmvsB5BN2iiXRYMow/KBsW7yoSPtp/ZvCZMKgbI9CHB6BIF" +
       "g3ZIVE4YA6RBUgwmKCI1NlOaQIkenRpUHxGYpCoDZJZkdKY1WRIl1qUmKDbo" +
       "F/QYqRMY06V4htFOqwNGGmIwkyifSbTNW90aI9NEVRtzms91NW931WDLtDOW" +
       "wUhtbKcwIkQzTJKjMclgrVmdrNRUeSwlqyxCsyyyU77UgmBT7NICCJoerfn4" +
       "09uHajkEMwRFURlXz9hCDVUeoYkYqXFK18s0bewit5CyGJnqasxIc8weNAqD" +
       "RmFQW1unFcy+miqZdLvK1WF2TxWaiBNiZEl+J5qgC2mrmx4+Z+ihklm6c2HQ" +
       "dnFOW1PLAhXvWBk9ctf22h+WkZoBUiMpvTgdESbBYJABAJSm41Q32hIJmhgg" +
       "dQosdi/VJUGWxq2VrjeklCKwDCy/DQsWZjSq8zEdrGAdQTc9IzJVz6mX5AZl" +
       "/ZqUlIUU6Drb0dXUsAPLQcEqCSamJwWwO0ukfFhSEows8krkdGy+HhqA6OQ0" +
       "ZUNqbqhyRYACUm+aiCwoqWgvmJ6SgqaTVDBAnZH5vp0i1pogDgspOogW6WnX" +
       "Y1ZBqykcCBRhZJa3Ge8JVmm+Z5Vc6/P+5qsO3aRsVMIkBHNOUFHG+U8FoUaP" +
       "0BaapDqFfWAKTmuJ3SnMfupgmBBoPMvT2GzzxM1nr1vVePo5s82CCdp0x3dS" +
       "kQ2Kx+PTX1rYvmJNGU6jUlMNCRc/T3O+y3qsmtasBgwzO9cjVkbsytNbfnnD" +
       "nhP0vTCp6iQVoipn0mBHdaKa1iSZ6huoQnWB0UQnmUKVRDuv7yST4TkmKdQs" +
       "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" +
       "j0PTJ3LVpnPpk/wRs4f/C1FZjhy4LQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17efAk131X70pa3dqVZFuybJ1eO5HG/vXch+U47u45umd6" +
       "umemu+dog1d9H9P3PZMo2CqMBaZsF8jGVCXiD+wCjBObI0UoyiAKQuJyisJU" +
       "IECROFBQhBgXcVEEgwnmdc/8zt39CdWu+VW99+t5x/d9P9/rvX7v9Ve/B90V" +
       "BlDJc62NZrnRgZJFB6bVOIg2nhIeDMnGRAhCRcYsIQxZUHZNeu7rl//wh5/T" +
       "r1yELvHQo4LjuJEQGa4TzpTQtRJFJqHLx6U9S7HDCLpCmkIiwHFkWDBphNGL" +
       "JHT/ia4RdJU8ZAEGLMCABbhgAUaOW4FODypObGN5D8GJQh/6OegCCV3ypJy9" +
       "CHr2NBFPCAR7T2ZSIAAU7sl/zwGoonMWQM8cYd9hvg7w50vwa3/hY1f+5h3Q" +
       "ZR66bDhMzo4EmIjAIDz0gK3YohKEiCwrMg897CiKzCiBIVjGtuCbhx4JDc0R" +
       "ojhQjoSUF8aeEhRjHkvuASnHFsRS5AZH8FRDseTDX3eplqABrO84xrpD2M/L" +
       "AcD7DMBYoAqSctjlzrXhyBH09NkeRxivjkAD0PVuW4l092ioOx0BFECP7HRn" +
       "CY4GM1FgOBpoepcbg1Ei6ImbEs1l7QnSWtCUaxH0+Nl2k10VaHVvIYi8SwS9" +
       "/WyzghLQ0hNntHRCP9+jPvSZn3Fw52LBs6xIVs7/PaDTU2c6zRRVCRRHUnYd" +
       "H3iB/ILwjm+8ehGCQOO3n2m8a/N3fvb7H3n/U2/8+q7Nu27QhhZNRYquSV8S" +
       "H/r2u7HnO3fkbNzjuaGRK/8U8sL8J/uaFzMPeN47jijmlQeHlW/M/snq419R" +
       "vnsRuo+ALkmuFdvAjh6WXNszLCUYKI4SCJEiE9C9iiNjRT0B3Q2eScNRdqW0" +
       "qoZKREB3WkXRJbf4DUSkAhK5iO4Gz4ajuofPnhDpxXPmQRB0BSTowyD9JLT7" +
       "+4k8iyAV1l1bgQVJcAzHhSeBm+MPYcWJRCBbHRaB1a/h0I0DYIKwG2iwAOxA" +
       "V/YVYmDImgIz80FXCaXA8CIjUfIwAQigRd1Bbm/e/7eRshzzlfTCBaCOd58N" +
       "BhbwI9y1ZCW4Jr0Wo73v/9K1b108co69tCKoBgY/2A1+UAx+sBv84JzBoQsX" +
       "ijHfljOxUz9Q3hqEARAgH3ie+ePDl1597g5gd156J5B83hS+eZzGjgMHUYRH" +
       "CVgv9MYX00/M/0T5InTxdMDNGQdF9+XdJ3mYPAqHV8862o3oXv7U7/3h177w" +
       "snvscqci+D4SXN8z9+Tnzoo4cCVFBrHxmPwLzwi/fO0bL1+9CN0JwgMIiZEA" +
       "TBhEm6fOjnHKo188jI45lrsAYNUNbMHKqw5D2n2RHrjpcUmh+4eK54eBjO/P" +
       "Tfx9IB3sbb74n9c+6uX523a2kivtDIoi+v4U4/3Cv/qn/7lWiPswUF8+MfUx" +
       "SvTiieCQE7tchIGHj22ADRQFtPvtL07+/Oe/96mPFgYAWrznRgNezXMMBAWg" +
       "QiDmT/66/6+/8ztf+s2Lx0YTgdkxFi1Dyo5A5uXQfeeABKO975gfEFws4Ha5" +
       "1VzlHNuVDdUQREvJrfR/X35v5Zf/y2eu7OzAAiWHZvT+NydwXP5OFPr4tz72" +
       "P54qyFyQ8sntWGbHzXYR89FjykgQCJucj+wT//zJv/hrwi+A2AviXWhslSKE" +
       "QYUMoEJpcIH/hSI/OFNXybOnw5PGf9q/TixCrkmf+80/eHD+B3//+wW3p1cx" +
       "J3U9FrwXd+aVZ89kgPxjZz0dF0IdtKu/Qf2xK9YbPwQUeUBRAtEspAMQc7JT" +
       "lrFvfdfd/+Yf/qN3vPTtO6CLfeg+yxXkvlA4GXQvsG4l1EG4yryf/shOuek9" +
       "h7E8g64DvzOKx4tflwCDz988vvTzRcixiz7+v2hLfOXf/+A6IRSR5QZz75n+" +
       "PPzVn38C+/B3i/7HLp73fiq7Pg6DBdtx3+pX7P9+8blLv3oRupuHrkj71eBc" +
       "sOLccXiwAgoPl4hgxXiq/vRqZjd1v3gUwt59NrycGPZscDmO/+A5b50/33cm" +
       "nhRSfhSkF/au9sLZeHIBKh5+uujybJFfzbOf2GtoR+pH4O8CSP8nT3l5XrCb" +
       "jh/B9muCZ44WBR6YkC5FOphtdkvkt0fQo/n8lNakA9m1D/az0C6U5Xk1zz6y" +
       "G6txU8P54PWwSntYpZvAGt4MVv6M5bFJCPac9M+wM3qL7LwTpPfv2Xn/TdiZ" +
       "vhk7QGhYlB0K7b03m9R38/f+DeAM37M35bsYLLsAQvNd1YPWQTn/zd+Yszvy" +
       "x58EjIXFOwfooRqOYB3y+5hpSVcP9T8H7yDAAa+aVusQwJUiduSmfrBbuJ/h" +
       "Fft/5hXEhoeOiZEueAf49H/43G989j3fAQ48hO5KcucCfntiRCrOX4v+1Fc/" +
       "/+T9r/3up4spCcxH8z/9N2o/yKkq5yHOs4/l2bVDqE/kUJlipUcKYTQuZhFF" +
       "LtCeG7cmgWEb+dprt56HX37kO+uf/71f3K3nzwapM42VV1/7Mz86+MxrF0+8" +
       "Rb3nuheZk312b1IF0w/uJRxAz543StGj/5++9vLf+6svf2rH1SOn3wl64JX3" +
       "F//lH/3GwRd/95s3WHreabm3oNjoER2vhwRy+EdWBKyaStnMVuhtTNfbbEaU" +
       "SrgjzTLEwTFc6cnbcZTVQ1bHyTirp76TUY5ob6MkIZVWla9ut3VxOsTm1MK1" +
       "OU/rYbo4Y7Q64vb6M1Tg5qi/0Mh+35/PN3akjPS+YHkjghv1fZ114TYc1+JW" +
       "pLBS05/L5LjTFO1lx4ZtuFRSRFiGxXWpyjAuTw38ACEGHdrtze0kRBsoVTWM" +
       "5Ww1dlN4hIaL1sZlJpEH8wnGj0eaSHQwHG2iRF+r8cS8V18hzRnKaak9wogK" +
       "ZdHClFgrzszj8Gyw8jC3yw/5tTxaVRYzwqr4nD3qim4fnq782XhVbs7retSn" +
       "/ZQaDGwiXW8MlRFZatEpC0SH6s1n0dYOOxVQUKssumTUpRcpp0fiSEqJ9XTL" +
       "DkfmWLK0YG7LATXjFCa1/E2GhZvNhmu1OM1G2RZFYNjQBe/yTr3ciXHBXPfG" +
       "6azPzazltqNj3TmnuKv1yl/2R5V2WBaV1Iga2GYwdHwhzAipnSoU4ndndn+6" +
       "qMROX9qUbMPnZTIZVRb9KpstBAOlDL5nlYYNX8OqdmBn9RJfMvS1ZTelKj6V" +
       "nT69qExIRF8mC3TdkSK1WtVLizXvopwx9hJWk3uMiK6GCIoMGbtemdaqOjG0" +
       "dU2Tp24oG/B8yA0WmV+dB6aytrBR2sU2cHcaLniT8dvbnhwMEHnKSh1iO5xv" +
       "m/aygfAWzPucRXBcsxuIZXnJhciEnEo9H2MEe5guUrocr9W+zvTcNGyvg7U8" +
       "2JRw3Uea9LTMc5Qv+vpmtkIwzi4JBpa6wOYSe9hkNF9g510UcXi8kXhlo+K5" +
       "WlcLPdrVFs2Fs1xVeNTfrCUMnen8UKgNlPZwbtslvjGXmvCk1PBDuibMwvmY" +
       "WKM4RXN9fFDi2n2XEyZlVBC8rt9XF8iIteNhjXHGauwBVaLuZJyw1cF2m40r" +
       "TlBJ5srEbYTtKobJXjmrycx6Wh1lpQm7rAQrwCg14JomZ40pbCbBbI0ubWp+" +
       "aEdCiGrplu5I5nwthpuIElXH6Tr6pJywmNc0pnPX8JyyjeKyMBIqBsM39did" +
       "Ogu0zE0dmxvNZ904aW0Yts6u7ZE8DVtc3e5KbpMRnbGx8ThYDzVmTSyxfm8+" +
       "6UUjLlio1KpHtRUlnGmGp3NMrC2npbEK02l9M+PxGcHKtEsg/sgbmTPcqvTh" +
       "Vdkd9+pSiAJMIe7rTXpgRziKjmjfcd3RCpG7lZFPNCuEMRPoDjxLFhw34Yar" +
       "ypDImCHCeqtNKTSEASzA1eqapN32ajvltHi+amJcd6CKs5k1pzm8Mp0Mh3wM" +
       "t0KiPk5sQhjYbQozGgNypWIEvTR63ayeofV2r9trYATbstnhpherm1QZUwjS" +
       "7nbLFbFcC3Qvaw/scYC0RHEqrceKzS4dhxOTbp8V0W7dd5p+glutTaXkrdPR" +
       "qjRT1v31gMMH9eacYtN+ZkiTRc2rL/TGZESzyCJO6+MJbZXnwnRYx2JYa098" +
       "b07ILusvxluSrayojkPjA1N11aE+oZ1GWqIDvwY3w6W+Xtfh+hYhGAlNhH69" +
       "ux22zHAgJnKacmK7grYbbZUOgB0G3Z5j46YDvHltGN11RfHhLjbeGFUSXSl4" +
       "LfPlLY2rUz+lUUqrpH2UcgJ8g9H63EumHC+PuK7hNW0LzQxXrG/cqjeKTVZb" +
       "1yrboDRBJ+OVEcSbeDElolW1oZYyORAGpdmWTSicnvSDFClN/GVcLdVg2A4y" +
       "GcwY1a0niVZ/MmMqcWCMS5vQMamls6CrKutbZbpFuduaGiuTDtKJ61tuRHqz" +
       "MVUlsgYNIysSw5EEuNlyUWrDspjN2zTtsON6uUtlbSLe0Mwic/rT/gixTXKp" +
       "2kgtdZEKrVXYWTKXkJInTNfZYDEalEKYkqLFBG7Vpq2FjUv6dOUlM9+havUh" +
       "O1mUk2pCdjtrEDVZzuy1Oya6HVj2OknHXkmqLmfqQEJbfMK0a7VJNZTQttQv" +
       "d2e6OaNpJWRMDdeN2sqrwB3MsWDDF0MprC4GVdjcdhoqKWYuJ9bgSloKSt1G" +
       "u7SpKmKrZjQqLY8s9z2q3R6GykxoOqWx5dWr2HjKRqRpd0pMXGnH1sSVJLTZ" +
       "7/UQU2jKQncoDhvWYlR2WLXV3TaafKLQ1lgnY6K/2IyMaRMlW8MNyqSi7Y4R" +
       "ibKjRZyMM7kWUURJDUbr6cTGEG1WL0szMto2o/G0VS0RsDPBxTnSVpW6Jdj2" +
       "shzWJ0OLmXiNYBzIclU2nZpptSNJKU0E2W2uuuF4pG7ZbCPBsExKag1WLBXl" +
       "0S3uJQit4kS3PJvUzBiG+aAWk1l3hJmyg5XbPoFxuGyTrM/Cg0XTL/UWKxat" +
       "a5FAWmQikZIm1JpTrG4QYjStU6QzV9RWCeBcVwLTRJZK6IwpYbPceGm35zUz" +
       "im0slY5BkqXemMFqi8xuZaGlEG1CpkmHULaVMI3baNRt2fFGo5uI1dCnNaRn" +
       "1/Dussfb9VGvowS9FSOYnoFzZbvKDEuzxUpkyZYIc5WtymPzOS/Um3CZE5bL" +
       "ObLYLmg8hAVm1p8uZdse1PiG15lxjS3uz+aVNRaoo1Wj19WpSXXNNnBhEXF9" +
       "pRFLvM01p32Ob3So9cLtdaqrNQhXVbq35ly9u5bA6isyB+om0S1NCSY1VV36" +
       "9ZKCSu2SUIo2jFBuyWKQbheSHy+QQafjNpF1its1nl8B5SPyAMzDMupGyyGG" +
       "DeAMw7NmFZc7NfDKbpTg1nxowvNGXWKbm76gJnrNaZVXtBrQ7YyqB3N6BbxS" +
       "K2c9P85QZN7s6WY2aCl91i2PY7GcwnCJUcGEuuzHQ31VcTR6mA1hMiWsRZIN" +
       "K2Y852G1Iy5bKsWNW0aCLPo1R+vgYoOj1GFjK4X9tIQrUz1sWw20OUyTyjCY" +
       "yBbX1Oe62pQSMxktG7gVBh4WRlJry8QpLdckrFZre9ikrU8q9DjTh9VoLOkN" +
       "rSZ3pDqqStPIdusZ1631zWhuzjDgFYoz9chFv76qi+OyXKuIKawqJV4vb0ad" +
       "rLFxxmyl3hhG6gypy2Ohxqr9QRbRqKzNk4Had9BhJQqQZNyHCU5TV/UhJfUw" +
       "GCnhCxFM9wxM61JWh+NozchYuYQisrq1K6X2GpdBZFq0DdccMhO/T2IrwQnj" +
       "uVarDmBUMwXKypJG5uJllaxW0khaillWcjWcVE1Da2m6HW17IK71+B7Cpzbc" +
       "FLT2SOf8fkoJ08gyPNFYqyjbYUxB0kaBUWGW8baKrUBjdWUuZ07QYpalBkYB" +
       "nWAxXkWr3c1ku51Vy0EQBeMaInLIvKdtWbQEI1qJqjCErA18uYS5YqeOTiq9" +
       "YXk1VWtNtQN7BNL1J6tkNdXHXEOmfBztbmJfbNCrHrHstuZu6k6mxpwUql2e" +
       "3C5qfaI0dRSj2XO0DGliYL0TskTS3baqHMlKvYwWuo2JhY6kKZd0U4VE27Nx" +
       "p781J+iqux21N4q0aMcJUs2CxcqQ8YYycsD6gmS7nNPH24pZN6Yiy5VjdLvR" +
       "hJk79UcrDUS0aidRksa6THFBOtdKU95OqvM1eGuykmCKZ2Be0xVixOA9EvP7" +
       "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" +
       "8uxXIuipI8iYLuQBWAm6QiQcnuucgf13");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("b4c1fHQP+6M/JtjfPAf2t/LsH0fQO09peqbYbnJjRf/q7UB8bY/42o8J8b84" +
       "B/Fv5dk/O2nbSATeR/f6vRHkb98q5DZIL+0hv/RjcfkXrpuEpTA8UBzNcJQD" +
       "jGF6xdOx8/+7cwT0H/Ps30bQ23YCOt37jGh++1ZF8zxI4l40wo9FNNffgDtc" +
       "nyCOYefXEkgjUXIbMMQ4UorbGAXd/3qOjP5bnv3+UbQ4pHREBcQOR7suWnz3" +
       "dhiStJeWdNt9Z3fh8I/Ogf2jPPtBBL1rB5uOdCXYYQdTy40x/89bwPzwoYWs" +
       "95jXtwfzCUgX7j2n7v48uzOCHteUaGJkisU5RsS6Y8OyDFuJ9mvgM0uhu1TL" +
       "FaIjAVy461YF8CSUX6fZ/UW3XwCPn1P3RJ49GkEPHAoAgB/nZQ8e43vbLeB7" +
       "LC98CqTNHt/m9uO7ek7d+/LsabDWA/hQ1D26YPPO4raIkEYHmgKCxUyRwDpe" +
       "s5Rq9xj3M7eA+1154QdA2u5xb28/7uo5dfU8+0AEPQJwM1KgKA4bCE6YX0s9" +
       "FMGTp0WAqCqYAk63KsRwcKsxrQnSy3sxvHx7xHAc0y40C7wfOUcWaJ69CGQR" +
       "XieL06HswoduVePPgvTxPdSP336Nk+fUUXk2iKBLQOMYW/hw8xgZfjts+RN7" +
       "ZJ+4/ciW59TxecbsbHlguaJgndTfSZTsrUbiXH+v7FG+cvtRyufUqXl2LYKu" +
       "AJRzQ0k9N4gWhlx8F3EyGr90qxifA+mTe4yfvP0YvXPq8ku2F9YR9PAJjLhi" +
       "aHp0BqR1qyDfDdKre5Cv3n6QP3tO3c/lWRpB9wOQfdeJGGOrnIGXvRV4GViN" +
       "nfMtR34x/fHrPiTbffwk/dLrl+957HXut4rPGY4+ULqXhO5RY8s6eY/4xPMl" +
       "L1BUo5DBvbtbxV4B7JMR9NhNtg9B2BGP9hkv/Mld+1eBMZ9tD1ZPxf+T7T4d" +
       "QfcdtwOkdg8nm3wmgu4ATfLHz3qHE9jzN9vLRPY7q0BqOxllu3eFx08aTLF2" +
       "feTNFHHU5eRnEPmmZPGF3+EGYrz7xu+a9LXXh9TPfL/55d1nGJIlbLc5lXtI" +
       "6O7dFyEF0XwT8tmbUjukdQl//ocPff3e9x5umD60Y/jYeE/w9vSNv3no2V5U" +
       "fKWw/ZXH/vaH/srrv1Pchf2/C5mpc3o5AAA=");
}
