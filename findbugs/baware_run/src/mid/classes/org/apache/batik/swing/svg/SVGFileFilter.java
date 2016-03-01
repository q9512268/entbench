package org.apache.batik.swing.svg;
public class SVGFileFilter extends javax.swing.filechooser.FileFilter {
    public boolean accept(java.io.File f) { boolean accept = false;
                                            java.lang.String fileName = null;
                                            if (f != null) { if (f.isDirectory(
                                                                     )) {
                                                                 accept =
                                                                   true;
                                                             }
                                                             else {
                                                                 fileName =
                                                                   f.
                                                                     getPath(
                                                                       ).
                                                                     toLowerCase(
                                                                       );
                                                                 if (fileName.
                                                                       endsWith(
                                                                         ".svg") ||
                                                                       fileName.
                                                                       endsWith(
                                                                         ".svgz"))
                                                                     accept =
                                                                       true;
                                                             }
                                            }
                                            return accept;
    }
    public java.lang.String getDescription() { return ".svg, .svgz";
    }
    public SVGFileFilter() { super(); }
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
      ("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" +
       "/eKhw59IT4GFeAbbre6i2fuT+cBH8vJaVvz81upZ9Y1gxYb55hKMMCxXcXI+" +
       "T0QgYhz12v4alcBmE5j4mu1UczavAdvrPDoyZXa3O7QtVmVlcStFXq/cNhqu" +
       "78sKvH/XITPWA5u9D//Dx7750ce+C1zUhs6sMvMBzxyZsRdn+99ffeHZB171" +
       "zPc+nAMQQB/+E80rT2ZcOy+ncVaQWdHcV/X+TNVh/gVnlTDq5jiha7m2LxuZ" +
       "fGAtALSu9jZ3yFNXvzv/1Pc/v924nQzDE8T6h575tZ/ufuSZnSPb5cdu2rEe" +
       "HbPdMudC37ln4QB65OVmyUdQ//jFp/7wt5/64Faqq8c3f01wtvn8X/7XN3ef" +
       "+97Xb7G7uMPx/heOjS69gymFrcb+jy1MFCxVB+lIH0/horZKly45iNyelXqw" +
       "UnAqM57YOI2mpXOusrEduUCXmo1iWNTclaDDOozMi45TrerEYjnBJ8iAkmwp" +
       "JKbGhqUkwhEmI6/fwemBRSpLv+95kxY8aKysQS20xRXn4jPRk7FpXHWxsCq3" +
       "kIAZuNVaRV2M+YVLw7CKTVZFsSFF3ljpCPKQ63qLzpS2VaOkp2W5J9poJYpR" +
       "G21HfQZBBFjj2FUFLTdRRWphpoRHIdkJ5HaATlGHxIjCIqY3U8JsrsKkNZzD" +
       "Law0WBRse0EvFt1Je6QUZcSJl8oyaOJddFRKKCpMpYYth5vh3HZo2Ecpuuf1" +
       "m/WJl5i+IxSIGVeSl5Lc42KTH8HDKap3ldK0N5XkDS82yRhPq/RwUl7GKTmc" +
       "AmSJohamwPHQmwYtbz3lPcJA8TRtMpMEFuMOU/cNn5/a2EAZ4LHSVeiJ0EkH" +
       "47iFdSaw4LRSiUOwaqS1C3alzcwppzseMoOyZdqOiS/77Q4l4QrWqQW4Nh03" +
       "h9y4KjCU5pimLy6XqtedKKvuqh/QVFgrrdVRcxNQZM9lMXY9Jae2OtaosKVh" +
       "XFvAyoI83SBqrdtdSyRMVGzJXrRje2Y2u05r3eijc2w4TKsgqinR4jx0QjTI" +
       "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" +
       "99bfev47eWLwfwDLmt6FcCAAAA==");
}
