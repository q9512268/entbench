package org.apache.batik.script.rhino.svg12;
public class GlobalWrapper extends org.apache.batik.script.rhino.WindowWrapper {
    public GlobalWrapper(org.mozilla.javascript.Context context) { super(
                                                                     context);
                                                                   java.lang.String[] names =
                                                                     { "startMouseCapture",
                                                                   "stopMouseCapture" };
                                                                   this.
                                                                     defineFunctionProperties(
                                                                       names,
                                                                       org.apache.batik.script.rhino.svg12.GlobalWrapper.class,
                                                                       org.mozilla.javascript.ScriptableObject.
                                                                         DONTENUM);
    }
    public java.lang.String getClassName() {
        return "SVGGlobal";
    }
    public java.lang.String toString() { return "[object SVGGlobal]";
    }
    public static void startMouseCapture(org.mozilla.javascript.Context cx,
                                         org.mozilla.javascript.Scriptable thisObj,
                                         java.lang.Object[] args,
                                         org.mozilla.javascript.Function funObj) {
        int len =
          args.
            length;
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        if (len >=
              3) {
            org.w3c.dom.events.EventTarget et =
              null;
            if (args[0] instanceof org.mozilla.javascript.NativeJavaObject) {
                java.lang.Object o =
                  ((org.mozilla.javascript.NativeJavaObject)
                     args[0]).
                  unwrap(
                    );
                if (o instanceof org.w3c.dom.events.EventTarget) {
                    et =
                      (org.w3c.dom.events.EventTarget)
                        o;
                }
            }
            if (et ==
                  null) {
                throw org.mozilla.javascript.Context.
                  reportRuntimeError(
                    "First argument to startMouseCapture must be an EventTarget");
            }
            boolean sendAll =
              org.mozilla.javascript.Context.
              toBoolean(
                args[1]);
            boolean autoRelease =
              org.mozilla.javascript.Context.
              toBoolean(
                args[2]);
            global.
              startMouseCapture(
                et,
                sendAll,
                autoRelease);
        }
    }
    public static void stopMouseCapture(org.mozilla.javascript.Context cx,
                                        org.mozilla.javascript.Scriptable thisObj,
                                        java.lang.Object[] args,
                                        org.mozilla.javascript.Function funObj) {
        org.apache.batik.script.rhino.svg12.GlobalWrapper gw =
          (org.apache.batik.script.rhino.svg12.GlobalWrapper)
            thisObj;
        org.apache.batik.dom.svg12.SVGGlobal global =
          (org.apache.batik.dom.svg12.SVGGlobal)
            gw.
              window;
        global.
          stopMouseCapture(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "MdzBns4xX6895avl+J5Wqveob3/+avmHJ/c1QOf2joy7QcnOR8+E1Vey55+7" +
       "R98vFMXPJtD9SsHTXoR7gP+7IysGPD99F+PppF55VFbC/4t70PpCUXwQrDEg" +
       "zkVJ309jrSUH5eWUO2j4cuZb6qmf/cz36mcEeN595Gfz/0d+VhQfLnVaFC+V" +
       "8L9+D438ZlH8CjDhGKxeZxVStP/SqfC/+mqE3ybQw+cO/YsTzMdvu2u0vx+j" +
       "fP7F61ff8OL0v+x98vgOy4M8dFUHX2tnT5LO1K8EkaZbpQgP7s+V9kb6xQR6" +
       "9v/gTgKwvvJdsv4f96hfSqAn74kKkMr3WaQvJ9Ab7oJUHEOVlbPwXwWqvggP" +
       "6Jbvs3BfS6Brp3CA1L5yFuTrIAYAkKL6+8Gxi8D3Fn4GUhd/czQr20vnc56T" +
       "yX7slSb7TJr07LlYXV47O05E0v3Fs1vKF15khR/9TuMz+xsCiiPneUHlKgir" +
       "+8sKJ8nMM3eldkzrSvdt333kFx98y3Hi9cie4VP3OcPb03c+jm+7QVIeoOe/" +
       "+ob/8M6ff/FPysO2/w354VD1DygAAA==");
}
