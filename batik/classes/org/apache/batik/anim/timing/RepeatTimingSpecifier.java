package org.apache.batik.anim.timing;
public class RepeatTimingSpecifier extends org.apache.batik.anim.timing.EventbaseTimingSpecifier {
    protected int repeatIteration;
    protected boolean repeatIterationSpecified;
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID) { super(
                                                                  owner,
                                                                  isBegin,
                                                                  offset,
                                                                  syncbaseID,
                                                                  owner.
                                                                    getRoot(
                                                                      ).
                                                                    getRepeatEventName(
                                                                      ));
    }
    public RepeatTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                 boolean isBegin,
                                 float offset,
                                 java.lang.String syncbaseID,
                                 int repeatIteration) {
        super(
          owner,
          isBegin,
          offset,
          syncbaseID,
          owner.
            getRoot(
              ).
            getRepeatEventName(
              ));
        this.
          repeatIteration =
          repeatIteration;
        this.
          repeatIterationSpecified =
          true;
    }
    public java.lang.String toString() { return (eventbaseID ==
                                                   null
                                                   ? ""
                                                   : eventbaseID +
                                                 ".") +
                                         "repeat" +
                                         (repeatIterationSpecified
                                            ? "(" +
                                          repeatIteration +
                                          ")"
                                            : "") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : "");
    }
    public void handleEvent(org.w3c.dom.events.Event e) {
        org.w3c.dom.smil.TimeEvent evt =
          (org.w3c.dom.smil.TimeEvent)
            e;
        if (!repeatIterationSpecified ||
              evt.
              getDetail(
                ) ==
              repeatIteration) {
            super.
              handleEvent(
                e);
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Tf5aHcefiUccLv8XIpL9Sy0bAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "aSh6ezOSWpMm5bcLfKPINgvzlY5syuikOat1JRcWq2MmbosiZbWmMoyB/CpQ" +
       "djHsIrUazdZwYswCpDM5hUXgztIw5+u1XzA2uq7K3aFlSIoYj9G6LSS1UrqO" +
       "cWelG1WdHk7c0ohCGNZF0mm9YPRtUbPn60bLw1ZoqRkIRTLoMAk9J+lIkgkB" +
       "C2ZLpInW2dhsJCt9hRECrTOVuVMAntks8pQxrY4pdsmBnUq4hFN0KYxXcMzh" +
       "CRcN4fZ6Qc/50UaINstyt+fMpDDkJyqadhqlzspZTbEFgslw2B6VmGptkoxY" +
       "jlGk3nrFERt/nE7qtRpGDbvOKl1Sdod1ZonNMW6x1i7XcWTQDsgWv6z7SpvD" +
       "OcFu+63YpGgAaePSsCjzVVZW5s4cJk3SUKNYRbzqUsZEsGVwFGHhUxMOq7TN" +
       "JTx3cB9eAhgZ9sPiUE81U6w7VXpq6H254S8K3bof22gF5eGuTMMjrSxSsqoZ" +
       "Y1lmVrVpx2fq/KYogZ3lm7Mt51OvbCt8e77D3794/Qn29sn1Dvnyv7PQscu6" +
       "44d89+wdLgbQa290n5ofBz//1DPPKexHkJO753f1CLoQef4bbXWl2oe6yq6l" +
       "Hr/xcVwvv04+OBP70lP/cu/oLYu3v4IbqQeOyXm8yz/ovfCV9uvl3zwJndo/" +
       "Ibvmovso0xNHz8UuBsBZAnd05HTstfuWvSOz2L3gaexatnGTk9frHjs9up37" +
       "mxyPPnuTd7+TFe+PoPORtz0zPziJzV3lmVdylJo3PH30VPkKeHq7uvX+b3Q7" +
       "sSXYO/a/J7t6WWPyjuI5O8CD3CjcIbOPnPn5myj/0az43Qi6ZSG6iq3mTNc9" +
       "MVp5hnJgk997RcfLEXTnda9os/ume675ccj2Bw3yJ567dP7u58Z/nd9S7v/o" +
       "4AIDnQfLTvvwseuh+lk/AECSa3Zhewjr5x+fiaD7bnY9FUFnt5Vc+E9vmT4L" +
       "5L4uEzBH9nGY9nMRdPk4bQSdyT8P030+gi4e0IFht5XDJF+MoFOAJKv+sb83" +
       "w+WbXq7l0yaJoXrMwMmJo6i0P393vNz8HQKyR47AT/6Tnz2oiLc/+rkqf/I5" +
       "uv+Olyof2V7NyraYplkv5xno3PaWeB9uHrphb3t9naUe++Ftn7rwuj1ovG0r" +
       "8EGgHJLtgevfg5KOH+U3l+nn7v7DN/3+c9/Mz1f/F3Zp+uSLJQAA");
}
