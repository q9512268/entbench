package org.apache.batik.bridge.svg12;
public class SVG12TextElementBridge extends org.apache.batik.bridge.SVGTextElementBridge implements org.apache.batik.bridge.svg12.SVG12BridgeUpdateHandler {
    public org.apache.batik.bridge.Bridge getInstance() { return new org.apache.batik.bridge.svg12.SVG12TextElementBridge(
                                                            ); }
    protected void addTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                         org.apache.batik.dom.events.NodeEventTarget e) {
        if (childNodeRemovedEventListener ==
              null) {
            childNodeRemovedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMChildNodeRemovedEventListener(
                );
        }
        if (subtreeModifiedEventListener ==
              null) {
            subtreeModifiedEventListener =
              new org.apache.batik.bridge.svg12.SVG12TextElementBridge.DOMSubtreeModifiedEventListener(
                );
        }
        org.apache.batik.bridge.svg12.SVG12BridgeContext ctx12 =
          (org.apache.batik.bridge.svg12.SVG12BridgeContext)
            ctx;
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          addImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
        ctx12.
          storeImplementationEventListenerNS(
            e,
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected void removeTextEventListeners(org.apache.batik.bridge.BridgeContext ctx,
                                            org.apache.batik.dom.events.NodeEventTarget e) {
        org.apache.batik.dom.AbstractNode n =
          (org.apache.batik.dom.AbstractNode)
            e;
        org.apache.batik.dom.svg12.XBLEventSupport evtSupport =
          (org.apache.batik.dom.svg12.XBLEventSupport)
            n.
            initializeEventSupport(
              );
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMNodeRemoved",
            childNodeRemovedEventListener,
            true);
        evtSupport.
          removeImplementationEventListenerNS(
            org.apache.batik.util.XMLConstants.
              XML_EVENTS_NAMESPACE_URI,
            "DOMSubtreeModified",
            subtreeModifiedEventListener,
            false);
    }
    protected class DOMChildNodeRemovedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMChildNodeRemovedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
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
          ("H4sIAAAAAAAAAMVYbWwUxxmeO39gG3872JQEA+ZAxZDbOpCgyrQFHBtMz/bJ" +
           "Bks1bY653Tnf4r3dYXfOPjt1CZFaSCqhKDgprYp/EbWJSIiiRo0UBbmq1CRK" +
           "0wgatflQk1b90fQDKfwJrWibvjOzd7u35zNN//Skm9ubeef9nud9Zy9dR1WO" +
           "jbooNjUcZbOUONE4f45j2yFan4Ed5zDMJtRH/3Du5M1f154Ko+oJ1JjGzpCK" +
           "HTKgE0NzJtB63XQYNlXiDBOi8R1xmzjEnsZMt8wJtEZ3BjPU0FWdDVka4QTj" +
           "2I6hFsyYrSezjAy6DBjaEBPaKEIbZV+QoDeG6lWLznob1hVt6POtcdqMJ89h" +
           "qDl2HE9jJct0Q4npDuvN2Wg7tYzZScNiUZJj0ePGva4jDsXuLXFD1/NNn9x6" +
           "LN0s3NCGTdNiwkRnlDiWMU20GGryZvsNknFOoG+hihha7SNmKBLLC1VAqAJC" +
           "8/Z6VKB9AzGzmT5LmMPynKqpyhViaFMxE4ptnHHZxIXOwKGGubaLzWDtxoK1" +
           "+XAHTHxiu7LwvQeaX6hATROoSTfHuDoqKMFAyAQ4lGSSxHb2aRrRJlCLCQEf" +
           "I7aODX3OjXaro0+amGUhBfJu4ZNZSmwh0/MVRBJss7Mqs+yCeSmRVO6/qpSB" +
           "J8HWds9WaeEAnwcD63RQzE5hyD13S+WUbmoij4p3FGyMfBUIYOuqDGFpqyCq" +
           "0sQwgVplihjYnFTGIPnMSSCtsiAFbZFrZZhyX1OsTuFJkmBobZAuLpeAqlY4" +
           "gm9haE2QTHCCKK0LRMkXn+vDe84+aB40wygEOmtENbj+q2FTZ2DTKEkRm8A5" +
           "kBvru2NP4vZXzoQRAuI1AWJJ89Nv3ti7o3PpNUlz5zI0I8njRGUJ9WKy8epd" +
           "fdu+WMHVqKGWo/PgF1kuTlncXenNUUCa9gJHvhjNLy6N/uJrDz1D/hpGdYOo" +
           "WrWMbAbyqEW1MlQ3iH2AmMTGjGiDqJaYWp9YH0Sr4Dmmm0TOjqRSDmGDqNIQ" +
           "U9WW+A8uSgEL7qI6eNbNlJV/ppilxXOOIoQa4Yva4Gsh+RG/DGWVtJUhClax" +
           "qZuWErctbj8PqMAc4sCzBqvUUpKQ/1N390R3K46VtSEhFcueVDBkRZrIRSVp" +
           "69okUZzpyZ57lLHxAz33HIZTxXGCmGy/WIzy9KP/L8E57pG2mVAIgnVXECoM" +
           "OGUHLUMjdkJdyO7vv/Fc4g2ZhvzouL5k6AhIj0rpUSE9KqVHhfTo8tIj948M" +
           "9aV1QxsGwB4lGQsAon8aljlM8/ijUEhodQdXU6YPBH8KYAQI6reNfePQsTNd" +
           "FZC3dKYSIsdJt5bUtT4Pb/JFIqFeujp68603654JozBAUhLqmldcIkXFRdZG" +
           "21KJBuhWrszkoVYpX1iW1QMtnZ85NX7yC0IPf73gDKsA6vj2OEf5gohIECeW" +
           "49t0+qNPLj85b3mIUVSA8nWzZCcHoq5gDgSNT6jdG/GLiVfmI2FUCegGiM4w" +
           "nEAAy86gjCJA6s2DO7elBgxOWXYGG3wpj8h1LG1bM96MSM4WPqyRecrTIaCg" +
           "qAtfGqMX3vnVn3cKT+ZLSJOv9o8R1uuDLc6sVQBUi5ddh21CgO535+Pnnrh+" +
           "+qhILaDYvJzACB/7AK4gOuDBb7924t0PP7j4dthLR4ZqqW0xOMJEywlz7vgU" +
           "PiH4/pt/OdrwCYk6rX0u9G0sYB/lwrd66gEKGsCN50fkiAn5p6d0nDQIPw7/" +
           "bNrS8+LfzjbLiBswk0+YHbdn4M1/bj966I0HbnYKNiGVV2HPhR6ZhPY2j/M+" +
           "28azXI/cqWvrv/8qvgBFAoDZ0eeIwFokXIJEDHcJXyhi3BlYu48PEcef5sUn" +
           "ydctJdTH3v64YfzjKzeEtsXtlj/0Q5j2ykSSUQBhh5A7UBf7xS9fbad87MiB" +
           "Dh1B3DmInTQw27U0/PVmY+kWiJ0AsSrArzNiA0bmirLJpa5a9d7Pft5+7GoF" +
           "Cg+gOsPC2gAWZw7VQrITJw3wmqNf2Sv1mKmBoVn4A5V4iDt9w/Lh7M9QJgIw" +
           "91LHT/b8aPEDkYgy7e50t4s/W8T4eT5sl3nKH3fkCq4RtA3BsuhzTTFPG60v" +
           "17mIruviwwuL2shTPbK/aC3uBvqh2X32N//6ZfT8719fpqxUu52nJ5Bj/KYS" +
           "jB8SXZ2HT7uv3ax4//G19aXwzjl1lgHv7vLgHRTw6sN/WXf4y+ljnwG3NwS8" +
           "FGT59NCl1w9sVR8Pi8ZUQnZJQ1u8qdfvLxBqE+jATW4Wn2kQKd9ViGsTj1e3" +
           "CKX8nAimvATY5ZMEgkGzSbjPeYnCM1U0UeUYBs55yI0g/78W2kbeM8zsVKOa" +
           "lYkSXvedqCj/Qo/xFUBigg8jDK1OQ/ANIjZBXmxb4VZn6xmA/Wm3L1bmWz+c" +
           "+uFHz8qcDDbRAWJyZuHRT6NnF2R+ypvG5pJm379H3jaEqs18uDsnsnYFKWLH" +
           "wJ8uz7/84/nTYdfMAwxVTlu6vK3s5kNcOr/3vwMLPrE3x9DG2/VZ+Yjs+l+6" +
           "ODBtbckFU16K1OcWm2o6Fo/8VvQJhYtLPZThVNYwfKnrT+NqapOULjxQL1Gb" +
           "ip/jDK1fUUGGqsSvMEeXmzIMdZTZBBktH/z0ADrNQXrgK379dFBh6jw6YCUf" +
           "/CTTDFUACX+coXkXD5WzAJz72RvkXKgU33fLZuk2ieKD781Fx0a8UshDVFa+" +
           "VEiolxcPDT94476nZHelGnhuTlxB4UYte7gCzG0qyy3Pq/rgtluNz9duyad5" +
           "UXfn103kLwCGaIPWBXoNJ1JoOd69uOfKm2eqr8EBPYpCmKG2o74Lvby9QsOS" +
           "BQw+GvPXDt+LKdEG9db98dhbf38v1Cpqp1ttOlfakVDPXXk/nqL0B2FUO4iq" +
           "4BST3ASq0537Z81Rok5Dla/JmvqJLBnUILWTVtYsvH1o5AcC89cNwjOuQxsK" +
           "s7zxZqirFGpKLyPQVswQez/nLqA/UBiylPpXc/xWvoxVEJueC/84+Z13RuDA" +
           "Finu57bKySYLNcb/csMrOi7qyca2IhEbotRtdMOnRFQpFej0XWH0I5KaUzAU" +
           "6qb0PwzJXiakFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "jezu/PJ59MIBXMSyAeY13ETWN58QXIwv+qEXg8u3rq2PKnF5TeLO09XrY5W4" +
           "Y9UKKLt2PXSrFwz5lesT733+Ba37SWTvoMozBrfsg/c+OznZvfepW98tO/nL" +
           "lV3p4Yvv/ecHhbcZ73wNxdVHTil5WuTvdF78MvNm9df2oLNHhYgbXvucZLp2" +
           "svxwKdTjJHSFE0WIh47cejlz11O5J7ef4OYFzpsvVR4b24g4VUE7c+DAg1LE" +
           "A1nBfIWq+5rn7OtZ0Tvaz2vfOXP8CuW3vPFi6HWG7Gq2njPlhINj8TUC9+Cl" +
           "Z2q7wPNf7Qp8otIVQ4++WnH+0BLsf1P6B3H0wA1vJbdv0tTPvHD5wv0viH+V" +
           "17aP3nZd5KALs8S2jxeSjvVv80N9Zua+ubgtK/n5zy/E0EOvqGAMnc9/c3Pe" +
           "t2V6NobuvwUT2BXbznH6D8TQldP0QG7+e5zul2Po0o4OiNp2jpM8F0NnAUnW" +
           "/VX/0MWdW1kAnPva36qsz5xEhqMQuefVQuQYmDxxAgXy99CHOzbZvom+rn72" +
           "BZZ/18uVT26L/aotp2km5QIH3b5973C06x+7pbRDWbc1n/zBXZ+7+KZDeLpr" +
           "q/BuLx7T7ZGbV9Prjh/n9e/0D+7/vbf+1gvfyGtw/wPnrKLRICAAAA==");
    }
    protected class DOMSubtreeModifiedEventListener extends org.apache.batik.bridge.SVGTextElementBridge.DOMSubtreeModifiedEventListener {
        public void handleEvent(org.w3c.dom.events.Event evt) {
            super.
              handleEvent(
                org.apache.batik.dom.events.EventSupport.
                  getUltimateOriginalEvent(
                    evt));
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
          ("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" +
           "HWHeOYjtLCjbtXT4K83a0m3YdgK2lYF97WELKDJfhCZXumrVuz/7efvRaxUo" +
           "OoDqNAMrA5ifOVQLYCd2Ftg1b35pr7BjpgYezTweqCRCLOgblk9nf86kPAFz" +
           "P+n40Z7vLb7PgShgd7e7nP+zhT8/yx7bBU7Z6458ITRctiFcFQOhKdZpofXl" +
           "GhfedF06vbCoDD/bI9qL1uJmoB963ed/869fxi/8/rVlqkq123j6GzKO31TC" +
           "8UO8qfP5aff1WxXvPbm2vpTemabOMuTdXZ68wxu8cvov68a+mD36KXh7QyhK" +
           "YZU/GLr82oGt8pNR3pcKyi7pZ4sX9QbjBZtaBBpwnbnFRho45LsKeW1i+eqG" +
           "zwk3ryfCkBcEuzxIIBmmk4brnA8UhlTeQ5VTGDrnETeD7P+10DWylmFmpxxX" +
           "jFycsLpvx3n553aMr0ASE+wxTNHqLCRfI3wR4GLbCpc6S80B7U+7bbE03/rB" +
           "1DMfPi8wGe6hQ8Lk7MLjn8TPLQh8iovG5pJeP7hGXDa4qc3scW+eo3aFXfiK" +
           "gT9dmf/p9+fPRF03D1BUOW2o4rKymz2SIvi9/x1ZsIG9eUDRHdosLyG7/pce" +
           "DjxbW3K9FFci+YXFppqOxYd/y9uEwrWlHqpwxtG0AHKDKK42LZJReQDqBWmb" +
           "/OsYRetXNJCiKv7N3VHFohxFHWUWAaDFS1AeOKc5LA96+XdQDgpMnS8HqsRL" +
           "UGSaogoQYa8zphfiRDkPILifuj3OR0rZfbdole4AkwB5by46NPz3BI+gHPGL" +
           "Qkq+snjo8ImbDzwreitZw3Nz/P4J12nRwRVIblNZbZ6u6oPbbje+WLvFA3lR" +
           "bxe0jaMX6II3QetCnYYdKzQc71zac/WNs9XX4XgeQRFMUduRwG1eXF2hXXGA" +
           "gY8kgpUj8KsUb4J66/549M2/vxtp5ZXTrTWdK61IyeevvpfMmOZ3o6h2EFXB" +
           "GSb5CVSn2g/O6iNEnoYaX+Po6nGHDCqA7LTh6IWfHhrZecDstwYeGTegDYVR" +
           "1nZT1FVKNKVXEWgqZoi1n2nnxB8qC45pBmfz7Eq+jFeQm56L/zj5zbeH4bwW" +
           "GR7Utsp20oUKE/xlwy85LueJtrYilRgyTbfNjZ7mWTVNzk3f4k4/JqSZBEWR" +
           "btP8D3Oigi2hFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "R+8bwEUsG2Bex00kufmE4GJ80Q+9GFy+NTU5qsTlNYk7Txevj1XijlUroOza" +
           "9dCt3i/kV66Pv/eFF9X+J9C9gyrPBNyyD1777ORk996nbn237OXvVnalhy+8" +
           "958fFH7CfNfrKK4+ckrJ0yJ/p/fSl5i3Kr+2B509KkTc8NbnJNO1k+WHS6EW" +
           "L0NXOFGEeOjIrZczdz0Fvs8cuPWZmxc4b75UeWxsI+JUBe3MgQMPShEPZPXy" +
           "Nabsq56zr2VF72g/r33nzPGrlN/yxouhN5iSq9pazpQT8sfiawzuwSvPUneB" +
           "57/WFfhEpQs49TVq84eGlP43hX8QRg/c8E5y+x5N+fSLly/c/+Lor/LS9tG7" +
           "rotd6IK+tO3jdaRj/dv8UNOt3DUXt1UlP//5hRh66FUVjKHz+W9uzs9vmZ6L" +
           "oftvwQQ2xbZznP79MXTlND2Qm/8ep/vlGLq0owOitp3jJM/H0FlAknV/1T90" +
           "cfdWFgDnvu53KsmZk7hwFCD3vFaAHIOSJ05gQP4S+nC/Lrevoa8rn3mxzT7z" +
           "SuUT21K/Yktpmkm50IVu3751ONrzj91S2qGs25pPfv+uz158yyE43bVVeLcT" +
           "j+n2yM1r6ZTjx3n1O/2D+3/v7b/14tfzCtz/ANnowRwdIAAA");
    }
    protected org.w3c.dom.Node getFirstChild(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblFirstChild(
            );
    }
    protected org.w3c.dom.Node getNextSibling(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblNextSibling(
            );
    }
    protected org.w3c.dom.Node getParentNode(org.w3c.dom.Node n) {
        return ((org.apache.batik.dom.xbl.NodeXBL)
                  n).
          getXblParentNode(
            );
    }
    public void handleDOMCharacterDataModified(org.w3c.dom.events.MutationEvent evt) {
        org.w3c.dom.Node childNode =
          (org.w3c.dom.Node)
            evt.
            getTarget(
              );
        if (isParentDisplayed(
              childNode)) {
            if (getParentNode(
                  childNode) !=
                  childNode.
                  getParentNode(
                    )) {
                computeLaidoutText(
                  ctx,
                  e,
                  node);
            }
            else {
                laidoutText =
                  null;
            }
        }
    }
    public void handleBindingEvent(org.w3c.dom.Element bindableElement,
                                   org.w3c.dom.Element shadowTree) {
        
    }
    public void handleContentSelectionChangedEvent(org.apache.batik.bridge.svg12.ContentSelectionChangedEvent csce) {
        computeLaidoutText(
          ctx,
          e,
          node);
    }
    public SVG12TextElementBridge() { super(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZfWwUxxWfO38bGxsTG0qCAceg8nVXAwFR0xQwGEzPH7UB" +
       "tabl2Nudu1vY21125+wzqQtEDVCkoggIIVVxIxXUlpIQkUZNE4GIKoVENEXQ" +
       "NA1JG9rmj6YfSOGPhla0Td/M7N7u7d0tsYLUk3Zub+a9N/Pe+733ZubO3ERl" +
       "poFadEGVhBAZ0bEZ6qPvfYJhYqlDEUxzI/RGxYN/PLL79q+r9gZR+SCamBTM" +
       "blEwcaeMFckcRNNl1SSCKmKzB2OJcvQZ2MTGkEBkTR1EjbLZldIVWZRJtyZh" +
       "SrBZMCJokkCIIcfSBHdZAgiaEWGrCbPVhFd5CdojqEbU9BGHYVoOQ4drjNKm" +
       "nPlMguoj24UhIZwmshKOyCZpzxhovq4pIwlFIyGcIaHtykOWITZEHsozQ8tz" +
       "dR/deTxZz8wwWVBVjTAVzX5sasoQliKozuldq+CUuRN9E5VE0AQXMUGtEXvS" +
       "MEwahkltfR0qWH0tVtOpDo2pQ2xJ5bpIF0TQrFwhumAIKUtMH1szSKgklu6M" +
       "GbSdmdXWdrdHxSfmh48+ubX+XAmqG0R1sjpAlyPCIghMMggGxakYNsxVkoSl" +
       "QTRJBYcPYEMWFHmX5e0GU06oAkkDBGyz0M60jg02p2Mr8CToZqRFohlZ9eIM" +
       "VNavsrgiJEDXJkdXrmEn7QcFq2VYmBEXAHsWS+kOWZUYjnI5sjq2fgkIgLUi" +
       "hUlSy05VqgrQgRo4RBRBTYQHAHxqAkjLNICgwbBWRCi1tS6IO4QEjhI01UvX" +
       "x4eAqooZgrIQ1OglY5LAS9M8XnL552bPikOPqOvVIArAmiUsKnT9E4Cp2cPU" +
       "j+PYwBAHnLFmXuSY0HT+QBAhIG70EHOan33j1soFzRdf4zT3F6DpjW3HIomK" +
       "J2MTrz7QMXd5CV1Gpa6ZMnV+juYsyvqskfaMDpmmKSuRDobswYv9r351z2n8" +
       "tyCq7kLloqakU4CjSaKW0mUFG+uwig2BYKkLVWFV6mDjXagC3iOyinlvbzxu" +
       "YtKFShXWVa6x32CiOIigJqqGd1mNa/a7LpAke8/oCKEKeNB8eBYi/qHviKB0" +
       "OKmlcFgQBVVWtXCfoVH9qUNZzsEmvEswqmvhGOB/x8K20LKwqaUNAGRYMxJh" +
       "AVCRxHwwHDNkKYHD5lCibVF4YPO6tkUbIaponsAqWc0GQxR++v9r4gy1yOTh" +
       "QACc9YA3VSgQZes1RcJGVDyaXr321rPRyxyGNHQsWxK0BGYP8dlDbPYQnz3E" +
       "Zg8Vnh0FAmzS++gqODrAtzsgS0Carpk78PUN2w60lAAs9eFScAwlnZNXtjqc" +
       "dGLXgKh45mr/7StvVJ8OoiBknBiULad2tObUDl76DE3EEiSvYlXEzqTh4nWj" +
       "4DrQxePDezfv/hxbh7scUIFlkMkoex9N4tkpWr1poJDcuv0ffHT22KjmJISc" +
       "+mKXxTxOmmdavC72Kh8V580UXoieH20NolJIXpCwiQABBrmw2TtHTr5pt3M3" +
       "1aUSFI5rRkpQ6JCdcKtJ0tCGnR6GvUm0aeQwpHDwLJCl/S8M6Cfe/tVfFjNL" +
       "2hWizlXaBzBpd2UlKqyB5Z9JDro2GhgD3e+P9x154ub+LQxaQPFgoQlbadsB" +
       "2Qi8AxZ87LWd12+8d/LNoANHAmU5HYMdTobpct/H8AnA81/60ExCO3hGaeiw" +
       "0trMbF7T6cxznLVBhlMg2Ck4WjepAD45LgsxBdNY+Hfd7LYX/n6onrtbgR4b" +
       "LQvuLsDp/8xqtOfy1tvNTExApBXWsZ9DxtP2ZEfyKsMQRug6MnuvTX/qknAC" +
       "CgAkXVPehVkeRcweiDlwCbNFmLWLPWNLadNqujGeG0aunVBUfPzND2s3f3jh" +
       "Fltt7lbK7fduQW/nKOJegMkWIKux8zr7pqNNOm2nZGANU7xJZ71gJkHYkos9" +
       "X6tXLt6BaQdhWhFSq9lrQP7L5EDJoi6reOeVXzRtu1qCgp2oWtEEqVNgAYeq" +
       "AOnYTELqzOhfXMnXMVwJTT2zB8qzEDX6jMLuXJvSCXPArhen/HTFD8feYyjk" +
       "sLvfYmc/ZrP2s7SZz0FKXxdksqZhn3K71NnfLtO4ZAbY+1SCln6C5M4z+iZd" +
       "Amyvh5wKWKdWnl5sU8M2ZCcfPTom9Z5q41uPhtyNwlrYBz/z1n9+GTr+h9cL" +
       "VJwqoukLFTyEFdeSq2DKWXklopvt+Zz0tuza7ZJ3D0+tya8OVFJzkdw/r3ju" +
       "905w6dG/Ttv4cHLbONL+DI+hvCJ/3H3m9XVzxMNBtm3lGT9vu5vL1O42GUxq" +
       "YNifq1Qt2lPLgqYli4wGCoTp8CyykLHIGzQ8PzOY0aYjy8oAWO3D6pMTNvuM" +
       "fYU2XyZoQgI2efZp08JkczFMciAysmW06efgb/9kMUg7VrLu7qx6E+lQDzzL" +
       "LfWW+1gmLwABqbqhEQhlLGVyTVbrI9NjliATFrS1n+2vvXVys6nn51FLWioE" +
       "oQMHzFAPQH0tfd0oGGBnpkvcxyns6AHHnUZBktiOjvLS3EQLmwnxN9fnbG3I" +
       "KajOQ9bpJDzacGPH9z54hoe/9yjjIcYHjh78OHToKE8F/Lz3YN6Ry83Dz3xs" +
       "0fW0WZhh2cFnFsbR+eezoy//aHR/0FK4i6DSIU2WHEhtuzeQehieqOX+rXcJ" +
       "tlg+crYWYS2MHPozQRuZiR718fBu2mTgWGfglAaGyXMyHd/pmGPkU5tjMh2a" +
       "Cc8+S6d94zdHMVaPooHc0lZPQ2N4scgigoYCm+nbPtb5Dm2+RVAtBEunbJik" +
       "IykrEu086JjksXtjklnwHLL0OjR+kxRjLWwSpgKT+qSP+k/R5jBBE0H9HkDG" +
       "gAw7YDXh0f/IvYPEMUuJY+PXvxjr3fT/gY/+p2gzxt0PFRzCgqLGo/73P7X6" +
       "E+jQKnietnR4+i7qF6jGxVj9I2KmOyKsGtGdti436U8281kfEz1Pm9NQopNs" +
       "H7imt7sjCXsdKIDGGoEI3exkgiVPFvnJvbHZUnietxQ/N36bnSvC6l+OJ7tt" +
       "Zl1x0KELbMbzPrZ6hTYvwgGR22o11B+IJmZnj31+fm/sE4bnZUvJl8Zvn5eK" +
       "sPpj6vP+Bwi2XVHJALYOPAAXNYElB22XfSx4hTavEtTCLegny2PRS+O3KFTF" +
       "psJ3WfT0NjXvnp3fDYvPjtVVThnb9Ft2n5K9v62JoMp4WlFce3T3fr1cN3Cc" +
       "V+safsDV2ddbBE33tSdBZeyb6fAbznSdoClFmAgqjzl7Zov+d1ZpdNODXPbt" +
       "prtBULVDB6L4i5vkTwSVAAl9fV+3EbGgmAZg3TzbZgL5J13mwca7eTDL4r7k" +
       "odtS9seJfdRK879OouLZsQ09j9xaeopfMomKsGsXlTIhgir4VVb2uDarqDRb" +
       "Vvn6uXcmPlc1295G5lxyudfGgAXBwi6EpnluXczW7OXL9ZMrLrxxoPwabIC3" +
       "oIAAWWeL628LfkffntHTcJbcEnGfgV1/v7ELofbq97dd+ec7gQZ2i4D4xWqz" +
       "H0dUPHLh3b64rn83iKq6UBlkKZwZRNWyuWZE7cfikNGFKtOqvDONuyRAbkxL" +
       "q9n/WCZSvAv0TxVmGcugtdleev8I4Zu/lc+/k61WtGFsrKbSqZhazwE3revu" +
       "0Qz976GAVuCbthP/2r3v7V6Ix5yFu6VVmOlY9qzs/guHy6atdaqgXgSMRyPd" +
       "um5d+QX3MK/qOksbt5nS/+DUlIKgwDxd/x9oxfvfih0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
