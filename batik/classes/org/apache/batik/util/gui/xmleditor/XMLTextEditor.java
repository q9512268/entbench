package org.apache.batik.util.gui.xmleditor;
public class XMLTextEditor extends javax.swing.JEditorPane {
    protected javax.swing.undo.UndoManager undoManager;
    public XMLTextEditor() { super();
                             org.apache.batik.util.gui.xmleditor.XMLEditorKit kit =
                               new org.apache.batik.util.gui.xmleditor.XMLEditorKit(
                               );
                             setEditorKitForContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                                          XML_MIME_TYPE,
                                                        kit);
                             setContentType(org.apache.batik.util.gui.xmleditor.XMLEditorKit.
                                              XML_MIME_TYPE);
                             setBackground(
                               java.awt.Color.
                                 white);
                             undoManager =
                               new javax.swing.undo.UndoManager(
                                 );
                             javax.swing.event.UndoableEditListener undoableEditHandler =
                               new javax.swing.event.UndoableEditListener(
                               ) {
                                 public void undoableEditHappened(javax.swing.event.UndoableEditEvent e) {
                                     undoManager.
                                       addEdit(
                                         e.
                                           getEdit(
                                             ));
                                 }
                             };
                             getDocument(
                               ).addUndoableEditListener(
                                   undoableEditHandler);
    }
    public void setText(java.lang.String t) {
        super.
          setText(
            t);
        undoManager.
          discardAllEdits(
            );
    }
    public void undo() { try { undoManager.
                                 undo(
                                   ); }
                         catch (javax.swing.undo.CannotUndoException ex) {
                             
                         } }
    public void redo() { try { undoManager.
                                 redo(
                                   ); }
                         catch (javax.swing.undo.CannotRedoException ex) {
                             
                         } }
    public void gotoLine(int line) { javax.swing.text.Element element =
                                       getDocument(
                                         ).
                                       getDefaultRootElement(
                                         ).
                                       getElement(
                                         line);
                                     if (element ==
                                           null) {
                                         return;
                                     }
                                     int pos =
                                       element.
                                       getStartOffset(
                                         );
                                     setCaretPosition(
                                       pos);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1YDWwUxxWeO////4CN+TNgDBF/t4GGppEpjXHsYHqGEzYo" +
       "NQnH3N7cefHe7rI7Z5+dukmQEihqESUESJTQSiUipQTSKlHapomoojaJkqZK" +
       "QpumVUjVViptihpUNa1K2/TNzN7tz92ZIDW1tHPjmffmzXvz3vfezJnLqMwy" +
       "UTvRaIhOGMQK9Wo0gk2LxHtUbFlDMBaVj5Xgv+68tPmWICofRvUj2BqQsUX6" +
       "FKLGrWE0X9EsijWZWJsJiTOOiEksYo5hqujaMGpRrP6UoSqyQgf0OGEE27EZ" +
       "Rk2YUlOJpSnptxegaH4YdiLxnUjd/umuMKqVdWPCIW9zkfe4ZhhlypFlUdQY" +
       "3o3HsJSmiiqFFYt2ZUy0wtDViaSq0xDJ0NBuda1tgk3htXkm6Hiq4cOrh0Ya" +
       "uQlmYE3TKVfP2kosXR0j8TBqcEZ7VZKy9qAvoZIwqnERU9QZzgqVQKgEQrPa" +
       "OlSw+zqipVM9OleHZlcqN2S2IYoWeRcxsIlT9jIRvmdYoZLaunNm0HZhTluh" +
       "ZZ6KD62Qjhzb2fjdEtQwjBoUbZBtR4ZNUBAyDAYlqRgxre54nMSHUZMGhz1I" +
       "TAWryqR90s2WktQwTcPxZ83CBtMGMblMx1ZwjqCbmZapbubUS3CHsv8rS6g4" +
       "Cbq2OroKDfvYOChYrcDGzAQGv7NZSkcVLU7RAj9HTsfOzwMBsFakCB3Rc6JK" +
       "NQwDqFm4iIq1pDQIrqclgbRMBwc0KZpTdFFmawPLozhJoswjfXQRMQVUVdwQ" +
       "jIWiFj8ZXwlOaY7vlFznc3nzuoN3axu1IArAnuNEVtn+a4Cp3ce0lSSISSAO" +
       "BGPt8vBR3Pr8/iBCQNziIxY0z37xyq0r28+/LGjmFqDZEttNZBqVT8bq35jX" +
       "s+yWEraNSkO3FHb4Hs15lEXsma6MAQjTmluRTYayk+e3/uQL954m7wdRdT8q" +
       "l3U1nQI/apL1lKGoxLydaMTElMT7URXR4j18vh9VQD+saESMbkkkLEL7UanK" +
       "h8p1/j+YKAFLMBNVQ1/REnq2b2A6wvsZAyFUAR+qhW8VEn/8l6K4NKKniIRl" +
       "rCmaLkVMnelvSYA4MbDtiBQDrx+VLD1tggtKupmUMPjBCLEnuBGSaUXKpFQS" +
       "V8DRpTsGwkMQS738vxDzNuP/JCfD9J0xHgjAUczzA4EKMbRRV+PEjMpH0ht6" +
       "r5yNviqcjAWGbSmKVoPokBAd4qLFUYLoUE50yCMaBQJc4ky2BUENxzYKAAAI" +
       "XLts8K5Nu/Z3lIDHGeOlYHNG2uHJRD0OSmShPSqfa66bXHRx9YtBVBpGzVim" +
       "aayyxNJtJgGy5FE7qmtjkKOcVLHQlSpYjjN1mcQBqYqlDHuVSn2MmGycopmu" +
       "FbKJjIWsVDyNFNw/On98/L7t99wYREFvdmAiywDYGHuEYXoOuzv9qFBo3YZ9" +
       "lz48d3RKd/DBk26yWTKPk+nQ4fcJv3mi8vKF+Jno81Od3OxVgN8UQ7wBNLb7" +
       "ZXjgpysL5UyXSlA4oZsprLKprI2r6Yipjzsj3FmbeH8muEUNi8c2+NbYAcp/" +
       "2WyrwdpZwrmZn/m04Knis4PGY798/Y+f4ubOZpUGVzkwSGiXC8nYYs0cs5oc" +
       "tx0yCQG6d49HHnzo8r4d3GeBYnEhgZ2s7QEEgyMEM9//8p533rt48kLQ8XMK" +
       "qTwdg4ook1OSjaPqaZQEaUud/QASqoASzGs6t2ngn0pCwTGVsMD6V8OS1c/8" +
       "+WCj8AMVRrJutPLaCzjjszege1/d+fd2vkxAZpnYsZlDJuB9hrNyt2niCbaP" +
       "zH1vzn/4JfwYJAoAZ0uZJBxvEbcB4oe2lut/I29v8s3dzJolltv5vfHlqpii" +
       "8qELH9Rt/+CFK3y33pLLfdYD2OgS7sWapRlYfpYfnDZiawTobjq/+c5G9fxV" +
       "WHEYVpQBfK0tJoBkxuMZNnVZxa9+9GLrrjdKULAPVas6jvdhHmSoCrybWCOA" +
       "rxnjc7eKwx2vhKaRq4rylM8bYAZeUPjoelMG5cae/N6sp9edOnGRe5kh1pib" +
       "Q9V5HlTlhbsT2Kffuvnnp752dFyk/mXF0czH1/bPLWps72//kWdyjmMFyhIf" +
       "/7B05tE5Pevf5/wOoDDuzkx+mgJQdnjXnE79LdhR/uMgqhhGjbJdKG/HapqF" +
       "6TAUh1a2eoZi2jPvLfREVdOVA8x5fjBzifVDmZMeoc+oWb/Oh1717AiXwifZ" +
       "gS350SuAeKefs9zA2+WsWZUFiyrD1CnsksR9eFE3zbIU1aS1uD6ANag+RTpr" +
       "A/V4MRCyxqG6DbH50DaHSMAoaz/Dmk1CWlchpxVTN7BmRW5P/K/cX0m5Mczx" +
       "SsRCb36xYpcX6if3HjkR3/L4auGXzd4CshfuR0/+4t+vhY7/5pUCtUoV1Y1V" +
       "KhkjqktmKRPpiYQBfg9w3Ord+sO/+35ncsP1lBZsrP0axQP7fwEosbx4cPm3" +
       "8tLeP80ZWj+y6zqqhAU+c/qX/NbAmVduXyofDvJLj/D3vMuSl6nL6+XVJoHb" +
       "nTbk8fXF3ky9CL4+2wH6CmfqAr6Ty3/FWH2ZImBjm+3XjRweWUSHxNWNSyLT" +
       "pBeFNbsoqoC7AqtYrWmhL2IqKagOxuwblTTV/N7oo5eeFK7pxzkfMdl/5MBH" +
       "oYNHhJuKO+rivGuim0fcU/k2G4WFPoK/AHz/YR/TgQ2wX0CzHvuytDB3W2IJ" +
       "wESLptsWF9H3h3NTzz0xtS9o2+QOikrHdCXuYACeBgM+RuJiA90GH7/T6yWt" +
       "8A3YRz1w/V5SjHWaA5+aZu4e1mRAewaJrK85Jpj4JE0wZOsxdP0mKMY6jZoH" +
       "ppn7CmvuBxOYJM8ED3xSJuiAL2rrEb1+ExRjLYIVntslg/XBdMyivmhdE9kl" +
       "7++M/F6E9uwCDIKu5Qnpq9vf3v0ax+dKlhByqOhKBpA4XHeaRtbowkKjrv4e" +
       "ikoU+53Pu+GZXvlC9G1fbvjhoeaSPshS/agyrSl70qQ/7kXqCisdc23IeXty" +
       "cNveDUMSigLLATT48LFpnOSbrDlMUWVSpzp7gfE5yoP/C0eBOKzzPCOw+rct" +
       "7/VSvLjJZ080VM46se1tnrJzr2K1cCaJtKq6KzRXv9wwSULhKtWKes3gP98G" +
       "ZP4YrxxQX+T6XIvTgv0sRbOLssMZQ+sm/w5FLQXJGRDBj5v2achxflqKyviv" +
       "m+5ZiqodOrhoio6b5AewEyBh3eeMbAKd5S4MNwm7R7BGMgFv0ZY76pZrHbWr" +
       "zlvsSaz8uTrr1GnxYB2Vz53YtPnuK59+XFzTZRVPTrJVasCVxYtBrsxZVHS1" +
       "7FrlG5ddrX+qakk2rzWJDTuAMtfl090QaQZzsTm+O6zVmbvKvnNy3Qs/3V/+" +
       "JqTwHSiAKZqxI/8OkTHSUF/uCOeHLJSE/HLdteyRifUrE3/5Nb+loby7mZ8+" +
       "Kl84dddbh9tOwiW8ph+VQcomGX65uW1C20rkMXMY1SlWbwa2CKsoWPXgQT2L" +
       "BsyqIW4X25x1uVH2yENRR34pkv80BjfacWJu0CE/2ohS44x43tHtCKtOG4aP" +
       "wRlxQeLXBQix0wC3jIYHDCNb2gQOGBwRvuHHRT7IuV/nXdb87L/sPcAuyhoA" +
       "AA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
