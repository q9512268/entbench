package org.apache.batik.bridge;
public class SVGSwitchElementBridge extends org.apache.batik.bridge.SVGGElementBridge {
    protected org.w3c.dom.Element selectedChild;
    public SVGSwitchElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_SWITCH_TAG; }
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.SVGSwitchElementBridge(
                                                            ); }
    public org.apache.batik.gvt.GraphicsNode createGraphicsNode(org.apache.batik.bridge.BridgeContext ctx,
                                                                org.w3c.dom.Element e) {
        org.apache.batik.gvt.GraphicsNode refNode =
          null;
        org.apache.batik.bridge.GVTBuilder builder =
          ctx.
          getGVTBuilder(
            );
        selectedChild =
          null;
        for (org.w3c.dom.Node n =
               e.
               getFirstChild(
                 );
             n !=
               null;
             n =
               n.
                 getNextSibling(
                   )) {
            if (n.
                  getNodeType(
                    ) ==
                  org.w3c.dom.Node.
                    ELEMENT_NODE) {
                org.w3c.dom.Element ref =
                  (org.w3c.dom.Element)
                    n;
                if (n instanceof org.w3c.dom.svg.SVGTests &&
                      org.apache.batik.bridge.SVGUtilities.
                      matchUserAgent(
                        ref,
                        ctx.
                          getUserAgent(
                            ))) {
                    selectedChild =
                      ref;
                    refNode =
                      builder.
                        build(
                          ctx,
                          ref);
                    break;
                }
            }
        }
        if (refNode ==
              null) {
            return null;
        }
        org.apache.batik.gvt.CompositeGraphicsNode group =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            super.
            createGraphicsNode(
              ctx,
              e);
        if (group ==
              null) {
            return null;
        }
        group.
          add(
            refNode);
        return group;
    }
    public boolean isComposite() { return false; }
    public void dispose() { selectedChild = null;
                            super.dispose(); }
    protected void handleElementAdded(org.apache.batik.gvt.CompositeGraphicsNode gn,
                                      org.w3c.dom.Node parent,
                                      org.w3c.dom.Element childElt) {
        for (org.w3c.dom.Node n =
               childElt.
               getPreviousSibling(
                 );
             n !=
               null;
             n =
               n.
                 getPreviousSibling(
                   )) {
            if (n ==
                  childElt) {
                return;
            }
        }
        if (childElt instanceof org.w3c.dom.svg.SVGTests &&
              org.apache.batik.bridge.SVGUtilities.
              matchUserAgent(
                childElt,
                ctx.
                  getUserAgent(
                    ))) {
            if (selectedChild !=
                  null) {
                gn.
                  remove(
                    0);
                disposeTree(
                  selectedChild);
            }
            selectedChild =
              childElt;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            org.apache.batik.gvt.GraphicsNode refNode =
              builder.
              build(
                ctx,
                childElt);
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    protected void handleChildElementRemoved(org.w3c.dom.Element e) {
        org.apache.batik.gvt.CompositeGraphicsNode gn =
          (org.apache.batik.gvt.CompositeGraphicsNode)
            node;
        if (selectedChild ==
              e) {
            gn.
              remove(
                0);
            disposeTree(
              selectedChild);
            selectedChild =
              null;
            org.apache.batik.gvt.GraphicsNode refNode =
              null;
            org.apache.batik.bridge.GVTBuilder builder =
              ctx.
              getGVTBuilder(
                );
            for (org.w3c.dom.Node n =
                   e.
                   getNextSibling(
                     );
                 n !=
                   null;
                 n =
                   n.
                     getNextSibling(
                       )) {
                if (n.
                      getNodeType(
                        ) ==
                      org.w3c.dom.Node.
                        ELEMENT_NODE) {
                    org.w3c.dom.Element ref =
                      (org.w3c.dom.Element)
                        n;
                    if (n instanceof org.w3c.dom.svg.SVGTests &&
                          org.apache.batik.bridge.SVGUtilities.
                          matchUserAgent(
                            ref,
                            ctx.
                              getUserAgent(
                                ))) {
                        refNode =
                          builder.
                            build(
                              ctx,
                              ref);
                        selectedChild =
                          ref;
                        break;
                    }
                }
            }
            if (refNode !=
                  null) {
                gn.
                  add(
                    refNode);
            }
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZC2wUxxken98vbAwY8zLYGBIbuAsklCJTGmMMmB7GwgS1" +
       "JsHM7c3dLeztLrtz9uGUPIgqaKVSSoHQNiBVgpAiCOkDtVVDRJS2JMpDCqFN" +
       "0zRQpS/aFDWoatqGtuk/M7u3j3tQS6Un7dzezP/PzP/NP9//z9zp66jUNFAz" +
       "UWmQ7tSJGexRaT82TBLtVrBpboS6IenxYvyXLdf6lgZQ2SAal8DmOgmbZJVM" +
       "lKg5iGbIqkmxKhGzj5Ao0+g3iEmMYUxlTR1Ek2SzN6krsiTTdVqUMIFN2Aij" +
       "8ZhSQ46kKOm1OqBoRhhmEuIzCXX5mzvDqEbS9J2OeJNLvNvVwiSTzlgmRfXh" +
       "bXgYh1JUVkJh2aSdaQPN0zVlZ1zRaJCkaXCbstiCYG14cRYErc/UfXBzf6Ke" +
       "QzABq6pGuXnmBmJqyjCJhlGdU9ujkKS5Az2EisOo2iVMUVvYHjQEg4ZgUNta" +
       "RwpmX0vUVLJb4+ZQu6cyXWIToqjF24mODZy0uunnc4YeKqhlO1cGa2dlrBVW" +
       "Zpl4aF7o4ONb6r9djOoGUZ2sDrDpSDAJCoMMAqAkGSGG2RWNkuggGq/CYg8Q" +
       "Q8aKPGqtdIMpx1VMU7D8NiysMqUTg4/pYAXrCLYZKYlqRsa8GHco61dpTMFx" +
       "sLXRsVVYuIrVg4FVMkzMiGHwO0ulZLusRima6dfI2Nj2KRAA1fIkoQktM1SJ" +
       "iqECNQgXUbAaDw2A66lxEC3VwAENiqbm7ZRhrWNpO46TIeaRPrl+0QRSlRwI" +
       "pkLRJL8Y7wlWaapvlVzrc71v2b4H1TVqABXBnKNEUtj8q0Gp2ae0gcSIQWAf" +
       "CMWajvBh3Hh+bwAhEJ7kExYy3/vsjXvnN194UchMyyGzPrKNSHRIOh4Z9/r0" +
       "7valxWwaFbpmymzxPZbzXdZvtXSmdWCYxkyPrDFoN17Y8JPPPHKKvBdAVb2o" +
       "TNKUVBL8aLykJXVZIcZqohIDUxLtRZVEjXbz9l5UDu9hWSWidn0sZhLai0oU" +
       "XlWm8d8AUQy6YBBVwbusxjT7Xcc0wd/TOkKoHB5UA08rEh/+TREOJbQkCWEJ" +
       "q7KqhfoNjdlvhoBxIoBtIhQBr98eMrWUAS4Y0ox4CIMfJIjVEDHkaJyEBjat" +
       "HhiRqZRgnAC6K3h1kLma/v8YJM0snTBSVASLMN1PAQrsnjWaEiXGkHQwtaLn" +
       "xtNDLwv3YlvCwoiiIIwbFOMG+bhBMW4w97ioqIgPN5GNL9YbVms77Hsg3pr2" +
       "gQfWbt3bWgyOpo+UANRMtNUTgLodcrAZfUg621A72nJl4QsBVBJGDViiKayw" +
       "eNJlxIGppO3WZq6JQGhyIsQsV4Rgoc3QJBIFgsoXKaxeKrRhYrB6iia6erDj" +
       "F9upofzRI+f80YUjI49ueviuAAp4gwIbshT4jKn3MyrPUHabnwxy9Vu359oH" +
       "Zw/v0hxa8EQZOzhmaTIbWv0O4YdnSOqYhc8Nnd/VxmGvBNqmGLYZMGKzfwwP" +
       "63TaDM5sqQCDY5qRxAprsjGuoglDG3FquKeO5+8TwS2q2TZsgWeBtS/5N2tt" +
       "1Fk5WXg28zOfFTxCfGJAP/rz1/5wN4fbDiZ1rixggNBOF4Gxzho4VY133Haj" +
       "QQjIvXOk/yuHru/ZzH0WJGbnGrCNld1AXLCEAPPnXtzx1tUrxy8HHD+nEMFT" +
       "EUiE0hkjWT2qKmAkjDbXmQ8QoAL8wLym7T4V/FOOyTiiELax/lk3Z+G5P+2r" +
       "F36gQI3tRvNv3YFTP2UFeuTlLX9r5t0USSwAO5g5YoLVJzg9dxkG3snmkX70" +
       "0oyvXsRHIT4AJ5vyKOE0izgGiC/aYm7/Xby8x9e2hBVzTLfze/eXK1EakvZf" +
       "fr920/vP3eCz9WZa7rVeh/VO4V6smJuG7if7yWkNNhMgd8+FvvvrlQs3ocdB" +
       "6FEC2jXXG8CQaY9nWNKl5b94/oXGra8Xo8AqVKVoOLoK802GKsG7iZkAck3r" +
       "n7xXLO5IBRT13FSUZXxWBQN4Zu6l60nqlIM9+v3J31128tgV7mW66GNahlWn" +
       "e1iV5+vOxj71xpKfnvzy4RER8dvzs5lPr+nD9Upk97t/z4Kc81iObMSnPxg6" +
       "/cTU7uXvcX2HUJh2Wzo7RgEpO7qLTiX/Gmgt+3EAlQ+iesnKjzdhJcW26SDk" +
       "hKadNEMO7Wn35ncimenMEOZ0P5m5hvVTmRMb4Z1Js/daH3uNY0vYBs+d1sa+" +
       "089eRYi/9HKVO3jZwYoFNllU6oZGYZYk6uOL2gLdUlRrEoVrdSdkK51uomgC" +
       "C+Ejd0vBqJYMWtFa8CcrP86KtWKYzlzeKpruYMW8zGT4p8yfObnJy3FHxPbc" +
       "jHzJLU/Mj+8+eCy6/sRC4ZAN3oSxB85DZ372r1eCR371Uo4MpZJq+gKFDBPF" +
       "NWY5G9KzBdbxvN/xp3fGHfj1D9riK8aSU7C65ltkDez3TDCiI/+u8k/l4u4/" +
       "Tt24PLF1DOnBTB+c/i6/ue70S6vnSgcC/JAjHD3rcORV6vS6d5VB4DSnbvQ4" +
       "+eyMAzSwhW2GZ5HlAItyh+gcvpMJfPlUC4QIUqAtzoqtFNXE4QigSVjpA2vs" +
       "TVDP2ZQRQFAc8BznxwWc/7+galbRpfP6+73wzIBnqWXj0rHDk0+1AAS0QNsw" +
       "KzSKqgEee81tdJrzZfkiq3ew0m8DVk2srQOelZbBK8eOVT5VHx4BPpGAbfac" +
       "wmZb9x9MuJ/P4bEC8O5hxUMQaiSDwLF1tYH1hCyZfUAJ9nAtWcPFh2kwS5ID" +
       "/fBtAHoCa2N7NmahFRs70PlUCyBzsEDbYVZ8CZySRe8kT8iJ90zIOHkgFTHh" +
       "/CYnIV0ftm42FvVvlfa29f9GhIwpORSE3KSnQl/c9Oa2Vzi5VjA2z1Cai8mB" +
       "9V0nkXph90fwKYLn3+xhU2YV7BtWudu6ppiVuadgOVjBZMpnQGhXw9XtT1w7" +
       "IwzwZ04+YbL34Bc+Cu47KOKfuOyanXXf5NYRF17CHFZ8nc2updAoXGPV78/u" +
       "+uFTu/YErAX6NEXlEU1TCFYzC1iUyTInemEXc135+bpn9zcUr4LI2osqUqq8" +
       "I0V6o97oUm6mIq51cO7HnFhjzZphTlFRh53i8t2x/zbsDn7onAKPZrm4Nvbd" +
       "kU+1wA74VoG277DiNKxAVDZhbwh6OGqtJvv6BkUlw5ocdZA5cxuQ4QntEnhG" +
       "LfPSt0AmnJ20pvOo+qwv5hMpthmzIydjZpgiF8nWu7PdPishE/T9fAGoL7Li" +
       "WdjYCaxGFWKlyfzCm7WccxA+fzsRPmTBdGjsCOdT9RltbV4HlUsFULnMilcp" +
       "miJQ4ccKC5oNJAkprx+c1/4X4KQpasx9vcjOxU1Zf2aIC3jp6WN1FZOP3fcm" +
       "z+gzl+Q1wPqxlKK4T26u9zLdIDGZG1sjznE6//olRZPzZAcUlUWctOhtIX/V" +
       "8jy3PEWl/Nst9y5FVY4cdCVe3CK/pagYRNjr73TbrdsL3MOu9mCULvKevTJr" +
       "M+lWa+M6rs32hDH+L5PN8ynxP9OQdPbY2r4Hb3zshLhmkxQ8Osp6qQZ2Fzd+" +
       "mdNKS97e7L7K1rTfHPdM5Rw77IwXE3a8fprLK7vAf3XmClN9d1BmW+Yq6q3j" +
       "y557dW/ZJQiYm1ERhlPw5uw7gLSegmPi5nB2FIOTHb8c62z/2s7l82N/fpvf" +
       "sqCsuxW//JB0+eQDbxxoOt4cQNW9qBQiKknzy4mVO9UNRBo2BlGtbPakYYrQ" +
       "i4wVT4gcx7wWs+MJx8WCszZTyy5pKWrNDvzZV9tVijZCjBVaSo1aQbbaqbFP" +
       "rZ4DX0rXfQpOjSs5OiHiD1sNcNSh8Dpdt/Oi4h/pfAs/mYttnuTa/+CvrPjw" +
       "P/dwL4mBHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "v/Xajz395eK8738BdIT+qxspAAA=");
}
