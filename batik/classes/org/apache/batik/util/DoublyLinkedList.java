package org.apache.batik.util;
public class DoublyLinkedList {
    public static class Node {
        private org.apache.batik.util.DoublyLinkedList.Node next = null;
        private org.apache.batik.util.DoublyLinkedList.Node prev = null;
        public final org.apache.batik.util.DoublyLinkedList.Node getNext() {
            return next;
        }
        public final org.apache.batik.util.DoublyLinkedList.Node getPrev() {
            return prev;
        }
        protected final void setNext(org.apache.batik.util.DoublyLinkedList.Node newNext) {
            next =
              newNext;
        }
        protected final void setPrev(org.apache.batik.util.DoublyLinkedList.Node newPrev) {
            prev =
              newPrev;
        }
        protected final void unlink() { if (getNext() != null)
                                            getNext(
                                              ).
                                              setPrev(
                                                getPrev(
                                                  ));
                                        if (getPrev() != null)
                                            getPrev(
                                              ).
                                              setNext(
                                                getNext(
                                                  ));
                                        setNext(null);
                                        setPrev(null); }
        protected final void insertBefore(org.apache.batik.util.DoublyLinkedList.Node nde) {
            if (this ==
                  nde)
                return;
            if (getPrev(
                  ) !=
                  null)
                unlink(
                  );
            if (nde ==
                  null) {
                setNext(
                  this);
                setPrev(
                  this);
            }
            else {
                setNext(
                  nde);
                setPrev(
                  nde.
                    getPrev(
                      ));
                nde.
                  setPrev(
                    this);
                if (getPrev(
                      ) !=
                      null)
                    getPrev(
                      ).
                      setNext(
                        this);
            }
        }
        public Node() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "HAAA");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1471188907000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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");
    }
    private org.apache.batik.util.DoublyLinkedList.Node
      head =
      null;
    private int size = 0;
    public DoublyLinkedList() { super(); }
    public synchronized int getSize() { return size;
    }
    public synchronized void empty() { while (size >
                                                0)
                                           pop(
                                             ); }
    public org.apache.batik.util.DoublyLinkedList.Node getHead() {
        return head;
    }
    public org.apache.batik.util.DoublyLinkedList.Node getTail() {
        return head.
          getPrev(
            );
    }
    public void touch(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        nde.
          insertBefore(
            head);
        head =
          nde;
    }
    public void add(int index, org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        if (index ==
              0) {
            nde.
              insertBefore(
                head);
            head =
              nde;
        }
        else
            if (index ==
                  size) {
                nde.
                  insertBefore(
                    head);
            }
            else {
                org.apache.batik.util.DoublyLinkedList.Node after =
                  head;
                while (index !=
                         0) {
                    after =
                      after.
                        getNext(
                          );
                    index--;
                }
                nde.
                  insertBefore(
                    after);
            }
        size++;
    }
    public void add(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        nde.
          insertBefore(
            head);
        head =
          nde;
        size++;
    }
    public void remove(org.apache.batik.util.DoublyLinkedList.Node nde) {
        if (nde ==
              null)
            return;
        if (nde ==
              head) {
            if (head.
                  getNext(
                    ) ==
                  head)
                head =
                  null;
            else
                head =
                  head.
                    getNext(
                      );
        }
        nde.
          unlink(
            );
        size--;
    }
    public org.apache.batik.util.DoublyLinkedList.Node pop() {
        if (head ==
              null)
            return null;
        org.apache.batik.util.DoublyLinkedList.Node nde =
          head;
        remove(
          nde);
        return nde;
    }
    public org.apache.batik.util.DoublyLinkedList.Node unpush() {
        if (head ==
              null)
            return null;
        org.apache.batik.util.DoublyLinkedList.Node nde =
          getTail(
            );
        remove(
          nde);
        return nde;
    }
    public void push(org.apache.batik.util.DoublyLinkedList.Node nde) {
        nde.
          insertBefore(
            head);
        if (head ==
              null)
            head =
              nde;
        size++;
    }
    public void unpop(org.apache.batik.util.DoublyLinkedList.Node nde) {
        nde.
          insertBefore(
            head);
        head =
          nde;
        size++;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "mRkvbGSEDQtLxNgYufK/rikskz0jAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZNsL09uepsWuLu0Rf/IeEBdkj4GkHyPW3wDi4gD6fa8L9tN3qftsnr26m8y+" +
       "LEj5a28P7e+9GdCcY2jOmw/tC3ep+7k8+9wO2lzQrQNo/+geoBUXsE9D+XXG" +
       "7he+OdDO7Ql6BcEv3QXfF/PsnwI9Dd1ILD51eGWP7hfvFd37QMqO0WVvDrqj" +
       "vZkye4hfugvEL+fZvwyh84IkHQD8lXsFmN93vXwM8OW3aPp+8y7Yvppnv35b" +
       "bP/mXrE9A9Knj7F9+i3C9rW7YPvPefY7IXTRl203lg/g/cd7dSrvAOnnj+H9" +
       "/JsD7yz3X79L3Tfy7L+BWfNc78Ch/P69wnoUpF8+hvXLbz6sP71L3f/Os/8F" +
       "JixyvCjQDpD90b3q41MgfeUY2VfeGn08d/7O8M5dyAv/HCzcJ+DOaOO334x1" +
       "4KvH4L76FoG7chdwD+fZZbAOgLnbKeUe3bm3vRF02xC6enjHnn/L8vgtH5Xu" +
       "PoQUf+bVK/c/9uri3xVfQJ1+rPgABd2vRJZ19tODM88XPV9W9AL3A7sPEbwC" +
       "x+Mh9M7b3vuDecv/cnbPPbajfRfg9JAWSKD4P0v3VAhd3tMB/d49nCV5Fhgz" +
       "IMkfn/MKkdx8U7z7+mJ7rqh6/KweFOrzyOsJ+MyO5/mb9inFB70ne4po90nv" +
       "DfELr5Lj7/tm47O7j7NES8iyvJf7KejS7juxotN8X/LsHXs76eti//3feuhn" +
       "H3jPyR7qoR3De508w9vTt/8SqpvHwLkeZP/ssX/yXX//1d8tLq7/P9NKhcJp" +
       "LQAA");
}
