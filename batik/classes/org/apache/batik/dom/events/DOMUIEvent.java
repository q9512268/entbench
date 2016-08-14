package org.apache.batik.dom.events;
public class DOMUIEvent extends org.apache.batik.dom.events.AbstractEvent implements org.w3c.dom.events.UIEvent {
    private org.w3c.dom.views.AbstractView view;
    private int detail;
    public org.w3c.dom.views.AbstractView getView() { return view; }
    public int getDetail() { return detail; }
    public void initUIEvent(java.lang.String typeArg, boolean canBubbleArg,
                            boolean cancelableArg,
                            org.w3c.dom.views.AbstractView viewArg,
                            int detailArg) { initEvent(typeArg, canBubbleArg,
                                                       cancelableArg);
                                             this.view = viewArg;
                                             this.detail = detailArg; }
    public void initUIEventNS(java.lang.String namespaceURIArg, java.lang.String typeArg,
                              boolean canBubbleArg,
                              boolean cancelableArg,
                              org.w3c.dom.views.AbstractView viewArg,
                              int detailArg) { initEventNS(namespaceURIArg,
                                                           typeArg,
                                                           canBubbleArg,
                                                           cancelableArg);
                                               this.view = viewArg;
                                               this.detail = detailArg;
    }
    protected java.lang.String[] split(java.lang.String s) { java.util.List a =
                                                               new java.util.ArrayList(
                                                               8);
                                                             java.lang.StringBuffer sb;
                                                             int i =
                                                               0;
                                                             int len =
                                                               s.
                                                               length(
                                                                 );
                                                             while (i <
                                                                      len) {
                                                                 char c =
                                                                   s.
                                                                   charAt(
                                                                     i++);
                                                                 if (org.apache.batik.xml.XMLUtilities.
                                                                       isXMLSpace(
                                                                         c)) {
                                                                     continue;
                                                                 }
                                                                 sb =
                                                                   new java.lang.StringBuffer(
                                                                     );
                                                                 sb.
                                                                   append(
                                                                     c);
                                                                 while (i <
                                                                          len) {
                                                                     c =
                                                                       s.
                                                                         charAt(
                                                                           i++);
                                                                     if (org.apache.batik.xml.XMLUtilities.
                                                                           isXMLSpace(
                                                                             c)) {
                                                                         a.
                                                                           add(
                                                                             sb.
                                                                               toString(
                                                                                 ));
                                                                         break;
                                                                     }
                                                                     sb.
                                                                       append(
                                                                         c);
                                                                 }
                                                                 if (i ==
                                                                       len) {
                                                                     a.
                                                                       add(
                                                                         sb.
                                                                           toString(
                                                                             ));
                                                                 }
                                                             }
                                                             return (java.lang.String[])
                                                                      a.
                                                                      toArray(
                                                                        new java.lang.String[a.
                                                                                               size(
                                                                                                 )]);
    }
    public DOMUIEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "JWMGD/IcfBZAAm2ogr/iW+X/ADMJI8VXHwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "1MWNLIshuplPvBrhe1iFWgnpshJXtbGvNeBRKmHCblaRB4O+6y1b3IwnbJtq" +
       "M5QuisLY30TTRgsYpznirHiT48MssWILz7B6ZDT9nj2qzabePJgh0kbskbgf" +
       "0maP9MebxmS7Q1lvtMHpzbwrIho7b/TnkrZDtdHU7g42HFdnGkNFMKX21iQj" +
       "hK+yS7G3mOWVnOJzOatzemPWtjVp7i8Gs4koBduMSN2l2E3JxVglREfiO004" +
       "9X0+nFPqcIRMCToYZZNJOsLBOo7mvBxKTXVb5Xhv1KkRrMCSg3qAmnrkzyq4" +
       "7Ht01/FymgpMD4u2swZe43p4tbdO81lb9FYeGfT6Yp8fkBudnNKBKQkOjuWb" +
       "UIWlpr1sKm1mIaM9ruPXeaEvswi6Fau4JUZkz9nON6tuyIPKIoOxuZTDLaqX" +
       "Ur1KyvTMWJGCBtw0bHfdktR+LqWtSbeWNQXWMZHxCp7Oao1Ari37OqH0Z3K8" +
       "XZitJcq1dusgmmsynYpmPspDa22K6kxmlFruN6LqEJtu0q3ubRrKOPZtxmSr" +
       "kw2zmHvjtZB4uFcl5yLvLmbAV6jIoHa8QONNfjLwsGmVJK3aeLpx/F2QjDWj" +
       "PhlvAqK3tayxu1pGYz5O8JAbwEoyEOnZ3OwxMYvppEXB8LA9ULz6FNttZHvB" +
       "knNgOtRJtmOqJeAqR5ooNvRqwxReVVmuAiv1EcnW2N2YizvDtD3Tuanlj3Gw" +
       "GFYMlkALVFQdJhtjlokZFS/NASmF2MDc4pVYHcyqWF/uA+apve2G3rDihFi+" +
       "rjTgsZ+SaYovdjo9oSdwT+kbq2lraRoVSwzgUZy1yJVhopUaboiCnu5MbKSk" +
       "XRF8c8CLXArRpu7heD4eEJW+zVH+yIYteanhaW8YzwxbnMG1emrTwdLc8ZXV" +
       "yt8MuIVt8/QArTk9guASmp6ivlf3iU6tt8tTqUPSoizGlXTWmcsDWhy3ua3Y" +
       "nvWQUHJ0SUpVG/jUkE3tjUUhyAamh+wUSZK4S9Kp20yzXY3qUFqqW21CA/jo" +
       "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" +
       "V/68PA38v69/VtyOKgAA");
}
