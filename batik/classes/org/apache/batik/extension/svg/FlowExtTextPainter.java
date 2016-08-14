package org.apache.batik.extension.svg;
public class FlowExtTextPainter extends org.apache.batik.gvt.renderer.StrokingTextPainter {
    protected static org.apache.batik.gvt.TextPainter singleton = new org.apache.batik.extension.svg.FlowExtTextPainter(
      );
    public static org.apache.batik.gvt.TextPainter getInstance() {
        return singleton;
    }
    public java.util.List getTextRuns(org.apache.batik.gvt.TextNode node,
                                      java.text.AttributedCharacterIterator aci) {
        java.util.List textRuns =
          node.
          getTextRuns(
            );
        if (textRuns !=
              null) {
            return textRuns;
        }
        java.text.AttributedCharacterIterator[] chunkACIs =
          getTextChunkACIs(
            aci);
        textRuns =
          computeTextRuns(
            node,
            aci,
            chunkACIs);
        aci.
          first(
            );
        java.util.List rgns =
          (java.util.List)
            aci.
            getAttribute(
              FLOW_REGIONS);
        if (rgns !=
              null) {
            java.util.Iterator i =
              textRuns.
              iterator(
                );
            java.util.List chunkLayouts =
              new java.util.ArrayList(
              );
            org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun tr =
              (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                i.
                next(
                  );
            java.util.List layouts =
              new java.util.ArrayList(
              );
            chunkLayouts.
              add(
                layouts);
            layouts.
              add(
                tr.
                  getLayout(
                    ));
            while (i.
                     hasNext(
                       )) {
                tr =
                  (org.apache.batik.gvt.renderer.StrokingTextPainter.TextRun)
                    i.
                    next(
                      );
                if (tr.
                      isFirstRunInChunk(
                        )) {
                    layouts =
                      new java.util.ArrayList(
                        );
                    chunkLayouts.
                      add(
                        layouts);
                }
                layouts.
                  add(
                    tr.
                      getLayout(
                        ));
            }
            org.apache.batik.extension.svg.FlowExtGlyphLayout.
              textWrapTextChunk(
                chunkACIs,
                chunkLayouts,
                rgns);
        }
        node.
          setTextRuns(
            textRuns);
        return textRuns;
    }
    public FlowExtTextPainter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HMCx74hs2gywJphlBweKfOtzFR3nHu2/wT1ZKIPyD++s0lySd2do3HMJj5yu" +
       "r1h8+o5Xef6z7qJqIBISGUly1kKO9zJVIwmR76nGqIxU/nMCzpDF7xYoKoGW" +
       "r/+4ofMARS3z60Bet96dWqcoCni1KCrlv06571BUZctBpWW8OEW+C2sCEfY6" +
       "q+bQkn9FwsgT2AWOCkQLjlJNmYDQcVg563PXOpZnm67lWUd5tNqFdH4dnANj" +
       "ZtgMqPOndw7eeeVTDxpnZUHCMzNslGqAoHEit6qDVfOOlhurbEfH1bpHK9fk" +
       "YsZ1VneujeMLIoSfa1s8h0e93TpDvja7+elfHCp7GaJ9F/Jhihbuyq/Ls2oG" +
       "UsOucH6oQSXFT7XdHQ9Mb+lMvPc6P/mgvPOOVz4qXDyz55WjS2bh9Fvdj0qh" +
       "liRZfmC4bVoeIcKkFkG1ot6bhSXCKCKWXHFcx3CP2UUxt4tpzlqrl12iUNSW" +
       "dyNc4OoJTolTRNumZOS4yQTVdo/rnjpXYGVU1aNg9zhSzmGDPIzsUhIND6hq" +
       "7gaiaqXKCeDrXj7jnVz7cf7Kmif+BbKuwe8qGgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ngSaw50gq+fUef3cCWy5M/cykT2P72HL4yex5RRQVJ4oWB4qyot58aZiTnZC" +
       "4Kznu2GmpZ7lcWeCIgEtBnks6wqyjMzWwz2v3xkCD16xIc3W4e6R/WcLZXlZ" +
       "yQtsGwC1awbLpWKo5FSGKafhXXS3nP/uXF3ZG/Lqj+ZFO6M2LEe29zW9e26r" +
       "F/ehZpilzFmkXJzb6L7eF4ogz+dkd5tnntDzsf+1nlkQ33YorOtmKesH/umD" +
       "X/nlR76RRRoDnF7nUZAF2JERe1Gexf/C88/ed8szL32gwNEMRIe/+DvoS7lU" +
       "6RWtzQtu39R7c1P7RWrSlYOQLeBO1wprr7vAeN9aZjvEei9FBZ+84xuLj3zz" +
       "09v08+RqOkGsP/XML/1w9+lndo4k/Y9ckXcf5dkm/oXSr9nzsA88dL1RCg7i" +
       "n1948o8+8eT7t1rdcTyFbWdvaJ/+q//6yu6HX/rSVbKlG233/zCx4W11qhrQ" +
       "2P6nC01kOJagZFSK6soaangzIY4nLDZdqJQy7837JjMfzGAS3xihCI+pIdKl" +
       "NActVTnHK0+nESrLG81r19zVkJA8TxDdIYHbnDUye21x6G7EsI0uO0tX7w+t" +
       "jjnQWLdH+jUaXnbapmD7kmcgjdrU0fTILk8bI2aFVtO1U2FVpAI6XGQY6nTY" +
       "X8k1a7hpibQHjaxmJbQ5N4YcVUSZTupPGtiYkGpSFQPh9RyubiZgh17NItOQ" +
       "mpgeLQYbsT+mSzNE7gTSJu6KzfqCYatlcz6y2nC5L0GkSNdMBuLXg5UldGgT" +
       "EqquwMxJNpw33dibupMN1OorMYKVDTr28UF7mHTl2rqiUtIEmq0YDi4xXYqj" +
       "G3OrwbLLCu8NWQnnQGqRWpIr0xLuBjVURVYyza36vR7Tl4nmYjVughpDlmMB" +
       "jZN1Oui1YJmHqGG1tMDCuI2j7aCDiOtBUjcji+ktnNkE0qLGWmSYWmwIBNRk" +
       "SEJCTdxetUrqsqWSC3o6K4dQqOD21OiXRDZaGCZcI5GF6kmzPky79jgShv2g" +
       "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" +
       "33vLbz/39eKQ/H8AbrwZtkIkAAA=");
}
