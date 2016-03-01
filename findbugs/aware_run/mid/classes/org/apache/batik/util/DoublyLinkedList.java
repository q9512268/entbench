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
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "UYpjGXV/VGbuFGuOw6GY0VSoWHyW+N6tsUQEvpW23CtvmSVKcbxZZDxfxhw/" +
           "Y82zFNUrmgV38DUEbtXEZ5QfT9woWcg5VgU6lWPXf1c5Qn63FrwUi9dN6enx" +
           "hpoZ4/f/nj8b5F4g6+FWnsyoqreG9vSroNRLKlzTelFRG/zXixQ1FxUJ5Ga/" +
           "uNy/ErQvUdTop4UjnP/20p2jqM6lgwgTHS/JaxRVAAnrnjcc2zTyaxm7RoTE" +
           "NSIbyK8Nc45ovpkjPOVkRx6K81d6p2TKiHf6uHR6fEP/g1fvOi6ePSQV79zJ" +
           "uEyOomrxuJIru+aX5ObwqlrffX3qM7ULHNTNe3bxysbjA+KTP1HM9L0DWJ25" +
           "54C3jq04c35/1UU4L7agAKZo+pbCC1fWyEBNuCXqrWU9/+vhTxSRuve2vv7J" +
           "24Emfq9F4qmvrdyKuHTozKVY0jC+FUS1vagSDhWS5bfBe8a0jUQagRt4TUZT" +
           "dmRIrwxBltAzWu5BfyoLTcxe8LllbINOyY2yFzGK2gtPvsJXQrjyjxJzDePO" +
           "2EzxFaoZw/DOZtlDdxGtwDfLjv5999feHIDUyRPcy63ayiRyNa/3/wWCt+cQ" +
           "Zl6EOI5H+wzDfoSqucG9ahg8+9/lSl8W1IyCosAiw/gPDqe4o/cbAAA=");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "ILusTT55x++/8bef/Vp2D/J/RjDofocmAAA=");
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
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Z4KlhoHrL7QAfyT/C/CefHToIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "z17bLWZXk9T8kdpD++tvBTTnGJrz1kP74j3a/k6efX4HbSKZ1gG0v30f0IoX" +
       "qM9C+euI3S96a6Bd2BNQBcEv3wPfl/Ls7wM9jVwQtOQPn96j+6X7Rfc+kLJj" +
       "dNlbg+5ob6b8HuKX7wHxK3n2jyPooqSqBwB/9X4B5u+rXj0G+Op3afn+xT2w" +
       "fS3PfuOO2P7Z/WJ7DqTPHGP7zHcJ29fvge3f59lvR9DlQLPdjXYA79/er1N5" +
       "B0i/cAzvF94aeGe5/8Y92r6ZZ/8JrJrnegcO5ffuF9bjIP3KMaxfeeth/dE9" +
       "2v5Xnv03sGCx48WhcYDsv9+vPj4D0lePkX31u6OPFy7eHd6FS3nlH4ON+wTc" +
       "GW38zluxD3ztGNzXvkvgrt0D3KN5dhXsA2Dtdkq5R3fhbW8GXRpB1w/fkeff" +
       "ojx52weju48clZ977dqDT7wm/KviC6bTDxEfYqAH9diyzn46cKZ82Qs03Sxw" +
       "P7T7kMArcDwZQe+843t7sG75X87uhSd2tO8CnB7SAgkU/2fpnomgq3s6oN+7" +
       "wlmS54ExA5K8+IJXiOT8m97d1xPphaLpybN6UKjPY28k4DMnnhfPnVOKj3VP" +
       "zhTx7nPdW8oXX6OHP/Qt7HO7j6sUS8qyfJQHGejK7juvYtD8XPL8XUc7Gety" +
       "9/3ffuTnH3rPyRnqkR3De508w9uzd/6SqZ3HwLkeZP/gib/3/X/jtd8pXjz/" +
       "P1e4NeFFLQAA");
}
