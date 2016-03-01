package org.apache.xalan.transformer;
public class XalanTransformState implements org.apache.xalan.transformer.TransformState {
    org.w3c.dom.Node m_node = null;
    org.apache.xalan.templates.ElemTemplateElement m_currentElement = null;
    org.apache.xalan.templates.ElemTemplate m_currentTemplate = null;
    org.apache.xalan.templates.ElemTemplate m_matchedTemplate = null;
    int m_currentNodeHandle = org.apache.xml.dtm.DTM.NULL;
    org.w3c.dom.Node m_currentNode = null;
    int m_matchedNode = org.apache.xml.dtm.DTM.NULL;
    org.apache.xml.dtm.DTMIterator m_contextNodeList = null;
    boolean m_elemPending = false;
    org.apache.xalan.transformer.TransformerImpl m_transformer = null;
    public void setCurrentNode(org.w3c.dom.Node n) { m_node = n; }
    public void resetState(javax.xml.transform.Transformer transformer) {
        if (transformer !=
              null &&
              transformer instanceof org.apache.xalan.transformer.TransformerImpl) {
            m_transformer =
              (org.apache.xalan.transformer.TransformerImpl)
                transformer;
            m_currentElement =
              m_transformer.
                getCurrentElement(
                  );
            m_currentTemplate =
              m_transformer.
                getCurrentTemplate(
                  );
            m_matchedTemplate =
              m_transformer.
                getMatchedTemplate(
                  );
            int currentNodeHandle =
              m_transformer.
              getCurrentNode(
                );
            org.apache.xml.dtm.DTM dtm =
              m_transformer.
              getXPathContext(
                ).
              getDTM(
                currentNodeHandle);
            m_currentNode =
              dtm.
                getNode(
                  currentNodeHandle);
            m_matchedNode =
              m_transformer.
                getMatchedNode(
                  );
            m_contextNodeList =
              m_transformer.
                getContextNodeList(
                  );
        }
    }
    public org.apache.xalan.templates.ElemTemplateElement getCurrentElement() {
        if (m_elemPending)
            return m_currentElement;
        else
            return m_transformer.
              getCurrentElement(
                );
    }
    public org.w3c.dom.Node getCurrentNode() { if (m_currentNode !=
                                                     null) { return m_currentNode;
                                               }
                                               else {
                                                   org.apache.xml.dtm.DTM dtm =
                                                     m_transformer.
                                                     getXPathContext(
                                                       ).
                                                     getDTM(
                                                       m_transformer.
                                                         getCurrentNode(
                                                           ));
                                                   return dtm.
                                                     getNode(
                                                       m_transformer.
                                                         getCurrentNode(
                                                           ));
                                               } }
    public org.apache.xalan.templates.ElemTemplate getCurrentTemplate() {
        if (m_elemPending)
            return m_currentTemplate;
        else
            return m_transformer.
              getCurrentTemplate(
                );
    }
    public org.apache.xalan.templates.ElemTemplate getMatchedTemplate() {
        if (m_elemPending)
            return m_matchedTemplate;
        else
            return m_transformer.
              getMatchedTemplate(
                );
    }
    public org.w3c.dom.Node getMatchedNode() { if (m_elemPending) {
                                                   org.apache.xml.dtm.DTM dtm =
                                                     m_transformer.
                                                     getXPathContext(
                                                       ).
                                                     getDTM(
                                                       m_matchedNode);
                                                   return dtm.
                                                     getNode(
                                                       m_matchedNode);
                                               }
                                               else {
                                                   org.apache.xml.dtm.DTM dtm =
                                                     m_transformer.
                                                     getXPathContext(
                                                       ).
                                                     getDTM(
                                                       m_transformer.
                                                         getMatchedNode(
                                                           ));
                                                   return dtm.
                                                     getNode(
                                                       m_transformer.
                                                         getMatchedNode(
                                                           ));
                                               } }
    public org.w3c.dom.traversal.NodeIterator getContextNodeList() {
        if (m_elemPending) {
            return new org.apache.xml.dtm.ref.DTMNodeIterator(
              m_contextNodeList);
        }
        else {
            return new org.apache.xml.dtm.ref.DTMNodeIterator(
              m_transformer.
                getContextNodeList(
                  ));
        }
    }
    public javax.xml.transform.Transformer getTransformer() {
        return m_transformer;
    }
    public XalanTransformState() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "DuW59PPOznZmv3ZKZ+8+pJozzR4SzX4iAO9Z7uz94QNuybX8FHg+sOOWDxxy" +
       "y1Ehf/lwXuSFPLyaBe8/Y54vgwHtXHc9dUtg7wTedjbvrGHlWPWcYwYkbCkq" +
       "C+EsqG87tnpLI7h2XsQSeF7eifjyLUTs3kHEK851JQ4AMUfZkkDbee9A2OMb" +
       "J0nN8W3ANeFxlpXb/doVO4BC3SWUD+6ek/ebQRndAcrjp1BOZDvB8v6vE8sB" +
       "iPE/AERxB6J4CxDfcmcQjhQBQdWzQk0PJPvWu5Ts/eB5ZSfZK7eQTL6DZE+e" +
       "qjcz3Q7w8Gzt9uTDBpYDZs/Vzq+HXnviS4sf+POf2Prsh0xzkFn75Bv/8mvH" +
       "n3rjwpmV0ntvWKycLbNdLeXSPpqLnHH3C7drJS/R/rPPv/YffvS1T2yleuK8" +
       "30+AZe1P/O7/+cLxZ/7o127iSN5n3WD4yl32TObCvLrrmVdv0TPLO/TMo+d6" +
       "JoskDqQK7lKqF8BzvJPq+BZSJXeWamfJJ1LND6Ta3KVUGcdBO6mgW0j1nV8H" +
       "SWy3CDKpMi/khCSeO0sSjn2sRs5xi6O7kZZ7bAeyf/QuZX+xsOXrwsn3TWT/" +
       "5J01qgG2YsEiEqz282zGztKzr0VUuCR7nq1J7oGw/+IfoOjyTtjyLYT9njsL" +
       "e2ZVdaLkV2679OL2711AfgcovveOKLbKOAKu9AOVY+y4lP3+/pvLeV/2+gEw" +
       "RYf5thEooVuuZJ9I/9TcVq6eeNk8kB84SVfnNnY6lef+XeaOHG/3Xg5kffnr" +
       "lhWQ1GP7yvqea1z77j99/Qv/6r1fAoRDFR5YZQ4QYKYzLTJxtrP18c99+tlH" +
       "3vij786XEGD9wEql7//5rNYfvh3iLPi3WfDvTqA+k0Ede3GgaH0pjOjc09fU" +
       "U7QHJna/7b0NtNGV1ztI2K2ffGhe0sX6JBnNVrAeFgcDBEGJJjFEkBbLoZXh" +
       "iOu7jcBsDPA1hs0tbtEdIGkXLsEhTLfCNGU5ra+ZbW/s9yCaGRqGwKEiXqek" +
       "9jBoD8NJSowXvuXRgoxMhIXuj4Wkx/FLW9+YYrVPrhglDaFBMqjSAe9MA9/V" +
       "KnEZgotYuQhpqxk8W9VmPGWTyxHTLo+ocb+hDuYTDtLnWj8xHFv2Jmtu2Oly" +
       "SgSvqnA9VVnW1mCqVF2aNas0UTphezjlAl/zu77dEqlq6CyS4WgaVCbjpTnq" +
       "4w1uuqSbk3RabhKbSSpiYeBZVtoPyuNxr80J/ZHn0+3ESNEBoXhpuVJHUpqD" +
       "29HC3sgo5Rumgkycsb8sWuhM6KKsR0ec6U5T2a053VLFx5SesKDXyXTiOCLF" +
       "lFGjsuEZbTIbD3qJ2S2lSV+2J1E4rCRdgHVhBkKHTCFEYnGPSPVWi2jzjCKY" +
       "jh97y7E954nlaDRXYXfSS9EFtuH43qhr0zV7ZPtc6qjUssNRHW6JdPjA0AWG" +
       "p8t2nA4HZrqIeC20eiHXrbu1eezUu1M5FvUlkkbtVl8eJArJNLVZqRW0Okod" +
       "scv9xVqDtBLLgdm6iyQN32YmDZ5QCGpklmhjSPqqbUq+GVBduzesjKtNgy4O" +
       "62VxMuBU3DFgB+p1e0FdibuNeTtM6arKGbq8rBg+QciEOBApf2RQusk5M2gZ" +
       "et7aMA15RiZTYz4TUqQeUGqDHtNzYwCJXX+Cie2ZpcfjWY9shKtEWBqkydgB" +
       "NQrUBu+P/XrDcSozYjgqU51FvWXpA4Pil+loPRRYbLqw5hIZqURH6XZTjtkM" +
       "EmM1qwZNMuCVycBoNunUwHlknDZ6yro3RxuOrkJhvCoyZMTHzCKZe/12ezTU" +
       "K67RbgRD0uBSvtlazzdrUCIeq6Uoam2q/RLS5SlEXJIpr+mWQ5eVSErhstme" +
       "uasGVWYMdOVvqL5V0kg/LaVRdTUPDX/ileUZ11h0YERTUowqxtVhGqxZLmqM" +
       "pITuERPYXJaKxaIehknRlZQyqw0lu80ptrv2io5lR7xtjoLZhJpI9SUzblWd" +
       "+TLi2hs46rbkjStSvBSPwpQUB5uO3fNrvWQ512skUZkaTW40YuW0Ly3EFHan" +
       "jbneh1cE0l0KZCftMi4tE0UrbZgiqW54ejX2m/XecpksNzO0NYTWiEcl6bLu" +
       "rgifW07n3ZXB0CGMVou9TtkvLnsLSTCpdGRSzbjOe/hwybWo1oSu0CIYOAt1" +
       "0xwIzKCxQFJn0ZqVoJruavKImLOkkBKC37cblt0wVJcPrMWYiTrGOoJl1Rnq" +
       "Y67sxmaZJSOLmPeqLddk+NRYaUqNHSs9hkgthUfMomY0fLGz7szjOinUJR+T" +
       "aL3JtNRVJeKn9V4xmNtcXZh2+KTE93mU73XXUOTXdCN1NiLLlstQn8Csdavf" +
       "CttjtFqaYjJWWdvzqEVUF4TZmFaU+Tx0honeKwXL4QRRyaiYFjWBn9WhFeHV" +
       "Gd5oY97MgAhXMy1INspNiJdjJpJhdI3ECJWOJw0YDax+l28vQiOSlY7ZEijW" +
       "Kq0G7QTtsWkw6lgaP2yb9dJiUx8PZ7VyEoTrmpK4Q1TvoqJU767n/bEpoFQj" +
       "ZEdhOeoQsAmtVJVInKlV7WJmY7hos3h7yFb1MVSrSWUepvqDZdTypgrS6Q1W" +
       "JbpBVMrhGhWxIJgJNOnzrZU9YfFGEa3imBTB/amRhNS4I4vzijGhGz261V6l" +
       "UyKNdH0A890a1JnN1EXY4FzTIoF90CEKr3tuYtSg2qRTGdJpvyH6WNDzMXbd" +
       "tIuuUKtQM6ZSLzfGAjpY6Jg69hAX3YzMKdlG7BSJO53RxtO1WGIp0kHaipms" +
       "prostuQ5ilYRO0qT8royDOSN4CDLYFkJi5Fod8qtvm4zgmBiRBevubHmznQW" +
       "qVH4kPXrUU+qOXA/ppi1ZtYhI1HX07FYjZv+OEqWgLvYJaInPur5xVLMQiie" +
       "eBUwQW5ajD7tpCiaYGVAk2HUxyiyzvkBNZMtpeVCSdSddlRG1NSGyfuNUmzw" +
       "abuxxIptTscncG8pFAH7dzze4+rrKPHqrG7rErooV6tLTbNnq4or4ot125Jq" +
       "Li54zngQttm43e3MjCoz0RrMiq3y1eIGb1grUxpTFYSeTIcWwwZQSelh/aq3" +
       "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" +
       "9vaZaSnL+vt7hK/eDcIkKjx5kwum2Q25");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("p2+48L69pK385JuXH3zqzcl/ye9Ynl6kfqhfeFCPbfvshaYz7xf9QNOtHP5D" +
       "2+tNfo7pH0eFd9/OY4wKjxwc2x7h25If2l1gOlsyKjyQf5/N92EwH+/zRYWL" +
       "25ezWZpR4T6QJXtt+SdmdeaAc3vDKzk643DujCPnySfupPHTImcvY2ZOav7X" +
       "gxOHMt7++eC68vk3KeY7vlL9oe1lUMWW0jSr5cF+4dL2XuqpU/rCLWs7qeti" +
       "5+WvPvZTD7104kA/thV4b6hnZHv+5rctCceP8vuR6c8/9TPf9CNv/mF+wvv/" +
       "ALCzz8ATMgAA");
}
