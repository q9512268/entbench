package org.apache.batik.bridge;
public class DocumentLoader {
    protected org.apache.batik.dom.svg.SVGDocumentFactory documentFactory;
    protected java.util.HashMap cacheMap = new java.util.HashMap();
    protected org.apache.batik.bridge.UserAgent userAgent;
    protected DocumentLoader() { super(); }
    public DocumentLoader(org.apache.batik.bridge.UserAgent userAgent) { super(
                                                                           );
                                                                         this.
                                                                           userAgent =
                                                                           userAgent;
                                                                         documentFactory =
                                                                           new org.apache.batik.dom.svg.SAXSVGDocumentFactory(
                                                                             userAgent.
                                                                               getXMLParserClassName(
                                                                                 ),
                                                                             true);
                                                                         documentFactory.
                                                                           setValidating(
                                                                             userAgent.
                                                                               isXMLParserValidating(
                                                                                 ));
    }
    public org.w3c.dom.Document checkCache(java.lang.String uri) {
        int n =
          uri.
          lastIndexOf(
            '/');
        if (n ==
              -1)
            n =
              0;
        n =
          uri.
            indexOf(
              '#',
              n);
        if (n !=
              -1) {
            uri =
              uri.
                substring(
                  0,
                  n);
        }
        org.apache.batik.bridge.DocumentLoader.DocumentState state;
        synchronized (cacheMap)  {
            state =
              (org.apache.batik.bridge.DocumentLoader.DocumentState)
                cacheMap.
                get(
                  uri);
        }
        if (state !=
              null)
            return state.
              getDocument(
                );
        return null;
    }
    public org.w3c.dom.Document loadDocument(java.lang.String uri)
          throws java.io.IOException { org.w3c.dom.Document ret =
                                         checkCache(
                                           uri);
                                       if (ret !=
                                             null)
                                           return ret;
                                       org.w3c.dom.svg.SVGDocument document =
                                         documentFactory.
                                         createSVGDocument(
                                           uri);
                                       org.apache.batik.dom.util.DocumentDescriptor desc =
                                         documentFactory.
                                         getDocumentDescriptor(
                                           );
                                       org.apache.batik.bridge.DocumentLoader.DocumentState state =
                                         new org.apache.batik.bridge.DocumentLoader.DocumentState(
                                         uri,
                                         document,
                                         desc);
                                       synchronized (cacheMap)  {
                                           cacheMap.
                                             put(
                                               uri,
                                               state);
                                       }
                                       return state.
                                         getDocument(
                                           );
    }
    public org.w3c.dom.Document loadDocument(java.lang.String uri,
                                             java.io.InputStream is)
          throws java.io.IOException { org.w3c.dom.Document ret =
                                         checkCache(
                                           uri);
                                       if (ret !=
                                             null)
                                           return ret;
                                       org.w3c.dom.svg.SVGDocument document =
                                         documentFactory.
                                         createSVGDocument(
                                           uri,
                                           is);
                                       org.apache.batik.dom.util.DocumentDescriptor desc =
                                         documentFactory.
                                         getDocumentDescriptor(
                                           );
                                       org.apache.batik.bridge.DocumentLoader.DocumentState state =
                                         new org.apache.batik.bridge.DocumentLoader.DocumentState(
                                         uri,
                                         document,
                                         desc);
                                       synchronized (cacheMap)  {
                                           cacheMap.
                                             put(
                                               uri,
                                               state);
                                       }
                                       return state.
                                         getDocument(
                                           );
    }
    public org.apache.batik.bridge.UserAgent getUserAgent() {
        return userAgent;
    }
    public void dispose() { synchronized (cacheMap)  {
                                cacheMap.
                                  clear(
                                    );
                            } }
    public int getLineNumber(org.w3c.dom.Element e) {
        java.lang.String uri =
          ((org.w3c.dom.svg.SVGDocument)
             e.
             getOwnerDocument(
               )).
          getURL(
            );
        org.apache.batik.bridge.DocumentLoader.DocumentState state;
        synchronized (cacheMap)  {
            state =
              (org.apache.batik.bridge.DocumentLoader.DocumentState)
                cacheMap.
                get(
                  uri);
        }
        if (state ==
              null) {
            return -1;
        }
        else {
            return state.
                     desc.
              getLocationLine(
                e);
        }
    }
    private class DocumentState extends org.apache.batik.util.CleanerThread.SoftReferenceCleared {
        private java.lang.String uri;
        private org.apache.batik.dom.util.DocumentDescriptor
          desc;
        public DocumentState(java.lang.String uri,
                             org.w3c.dom.Document document,
                             org.apache.batik.dom.util.DocumentDescriptor desc) {
            super(
              document);
            this.
              uri =
              uri;
            this.
              desc =
              desc;
        }
        public void cleared() { synchronized (cacheMap)  {
                                    cacheMap.
                                      remove(
                                        uri);
                                } }
        public org.apache.batik.dom.util.DocumentDescriptor getDocumentDescriptor() {
            return desc;
        }
        public java.lang.String getURI() {
            return uri;
        }
        public org.w3c.dom.Document getDocument() {
            return (org.w3c.dom.Document)
                     get(
                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAL1Ye5AURxnv3XsfB/cAjpPHAcdCCcFdERBTRyJw3MHhHrd1" +
           "B1gemqV3pvduYHZmmOm9W4gXAqkIhVUYAyFoAv8IaigSKEsKSiuI+AipEBMw" +
           "pUkoEzV/GE2oCn8Yoqjx6+6ZncfeLlKp8qpmtq/7+7q/56+/b07dQBWWidoM" +
           "rMk4SncYxIom2DiBTYvIHSq2rA0wm5T2/+ngrlu/rdkdRpUDaMIQtnokbJEu" +
           "haiyNYBmKJpFsSYRaz0hMuNImMQi5jCmiq4NoMmK1Z0xVEVSaI8uE0awCZtx" +
           "1IgpNZVUlpJuewOKZsa5NDEuTWxlkKA9juok3djhMkz1MXR41hhtxj3Poqgh" +
           "vhUP41iWKmosrli0PWeiewxd3TGo6jRKcjS6VV1qG2JdfGmBGdrO1H94+7Gh" +
           "Bm6GiVjTdMpVtPqIpavDRI6jene2UyUZazt6CJXF0TgPMUWRuHNoDA6NwaGO" +
           "vi4VSD+eaNlMh87Voc5OlYbEBKJotn8TA5s4Y2+T4DLDDtXU1p0zg7az8to6" +
           "7g6o+MQ9sUNPPtDwozJUP4DqFa2fiSOBEBQOGQCDkkyKmNZKWSbyAGrUwOH9" +
           "xFSwquy0vd1kKYMaplkIAccsbDJrEJOf6doKPAm6mVmJ6mZevTQPKvu/irSK" +
           "B0HXZldXoWEXmwcFaxUQzExjiD2bpXybosk8jvwceR0jXwICYK3KEDqk548q" +
           "1zBMoCYRIirWBmP9EHzaIJBW6BCCJo+1IpsyWxtY2oYHSZKiliBdQiwBVQ03" +
           "BGOhaHKQjO8EXpoa8JLHPzfWLz/woLZWC6MQyCwTSWXyjwOm1gBTH0kTk0Ae" +
           "CMa6BfHDuPn5fWGEgHhygFjQnPv6zRULWy9eFjTTxqDpTW0lEk1Kx1MTrk7v" +
           "mH9vGROj2tAthTnfpznPsoS90p4zAGma8zuyxaizeLHv1195+CR5L4xqu1Gl" +
           "pKvZDMRRo6RnDEUl5hqiERNTInejGqLJHXy9G1XBOK5oRMz2ptMWod2oXOVT" +
           "lTr/H0yUhi2YiWphrGhp3RkbmA7xcc5ACNXBgxrhOYvEH/+laDA2pGdIDEtY" +
           "UzQ9ljB1pj9zKMccYsFYhlVDj6Ug/rd9ZlF0WczSsyYEZEw3B2MYomKIiMVY" +
           "ylTkQRJbrUvZDNFoXMcyMaMs4Iz/31E5pvXEkVAIHDI9CAcqZNJaXQXapHQo" +
           "u6rz5nPJl0SosfSw7UXREjgvKs6L8vOi4ryo/7yI8y9DEYJCIX7oJCaFiADw" +
           "3zZAAoDiuvn9X1u3ZV9bGYSeMVIOxmek8wqupg4XMhycT0qnrvbdeuXl2pNh" +
           "FAZUScHV5N4PEd/9IK43U5eIDABV7KZw0DJW/G4YUw508cjI7k27Psvl8EI+" +
           "27AC0IqxJxhQ54+IBFN9rH3r97774enDo7qb9L47xLn6CjgZlrQFXRxUPikt" +
           "mIXPJp8fjYRROQAUgDLFkESAd63BM3yY0u7gM9OlGhRO62YGq2zJAdVaOmTq" +
           "I+4Mj71GPp4ELq5nSTYdnp/YWcd/2Wqzwd5TRKyymAlowfH/vn7j6Ou/+eti" +
           "bm7nqqj33PH9hLZ74Ilt1sSBqNENwQ0mIUD3hyOJg0/c2LuZxx9QzBnrwAh7" +
           "dwAsgQvBzI9e3v7G228dfy3sxiyF+zmbglInl1eymuk0oYSSLM5deQDeVMh7" +
           "FjWRjRpEpZJWcEolLEn+VT930dn3DzSIOFBhxgmjhXfewJ3/1Cr08EsP3Grl" +
           "24Qkdr26NnPJBGZPdHdeaZp4B5Mjt/vajO+8gI8C+gPiWspOwkG0jNugjGve" +
           "AtUW52Q3aVTcpM7CJIYeI4ulqKxn8ojhLC4sgBZGxc93SFcTSzIVAzzA42MJ" +
           "Z43x92JmWy4G4mvL2StiefPMn8qeiispPfbaB+M3fXDhJjeMv2TzhlUPNtpF" +
           "JLPX3BxsPyWIaWuxNQR0Sy6u/2qDevE27DgAO0qA1VavCdCY8wWhTV1R9ebP" +
           "f9G85WoZCnehWhUwtAvzfEY1kEjEGgJkzhlfXCHiaIRFVgNXFRUoz1w3c+yg" +
           "6MwYlLtx5/kpP17+g2Nv8fgVATuNs4ctVikGoZeX+y5qvH/9qXd+dut7VaJY" +
           "mF8cKgN8Lf/sVVN7/vxRgZE5SI5RyAT4B2Knnp7acf97nN9FK8Y9J1d4pQGe" +
           "u7yfO5n5e7it8ldhVDWAGiS7tN6E1SzDgAEoJy2n3oby27fuLw1FHdSeR+Pp" +
           "QaT0HBvESfcqhTGjZuPxAWjkfp0GzzkbNc4FoTGE+KCHs8zj7/nstdBBoirD" +
           "VKAFIwEoqi+xKUVlWVNhw6UCedn7PvZaL3ZZUTT41vhF/zQ85+1TzhcRfZMQ" +
           "nb0ShTIW46bM5pbExvcGhPxyCSFzYx3Gc2VcsOzzYrObFIjl+YxilTnvKo7v" +
           "OXRM7j2xSKREk7/a7YRm7tnf/ftK9MgfXxyjpKq0Oyv3wHI4b3ZBFvbwrsUN" +
           "6WXXbpVdf7ylrrD2YTu1FqlsFhRP1+ABL+z529QN9w9tuYuiZmbASsEtn+k5" +
           "9eKaedLjYd54iQwqaNj8TO3+vKk1CXSY2gZf9rT5C4sZ8Fyy/Xpp7MIiHxIL" +
           "Cq/rYqwlbhutxBpnViArJZVgk8hWScxMmEoGapZhu3mLjTa9ve3pd58VgRUE" +
           "yAAx2Xdo/8fRA4dEkIl2eE5BR+rlES0xF7NBGOJj+AvB8x/2MB3YBPsFGOyw" +
           "+7JZ+cbMMHI8VkuIxY/o+svp0Z/+cHRv2LYJhlwe1hXZzeCtd4IZ3x3HJjr5" +
           "NMn7r40tLYPnsu2/y3fv+mKsJdz7SIm1R9nrIej3BwktrGE4kLkW2PWJLdDM" +
           "llhVfcVW48rdW6AYawktv1Vi7dvstR9ADiywsa+bXzCuyt/8xCq3sKU58Lxq" +
           "y/3q3atcjLWEWk+VWDvKXocpGudxOpta5ur95N3rnaNovK+pdsrmef9bRw5p" +
           "2lLwCVB8tpKeO1ZfPeXYxt/zNjD/aakOGqh0VlW9RYtnXGmYJK1wjetECWPw" +
           "n+9TNKWISBAGYsBlPyHon4F+IUhPUQX/9dKdoqjWpYOtxMBLchqqGCBhwzOG" +
           "Y58vFAgj6mIAYwCxDVBdYznSr6dpvsXtEDidC/lrgLz3Jt/Je56yYY4P6fmn" +
           "WudqzIqPtUnp9LF16x+8+fkTopuVVLxzJ9tlXBxVicY6f73OLrqbs1fl2vm3" +
           "J5ypmesAbaMQ2E2CaZ5I7YRq0WD9wtRAq2dF8h3fG8eXX3h5X+U1uFM2oxDg" +
           "9sTNhdVwzsjC3b857q1ZPB/8eRfaXvvOllc+ejPUxJsOJD7ztJbiSEoHL1xP" +
           "pA3ju2FU040q4B4hOV6qr96h9RFpGNqj6qymbM+SbhkCMqVntfxX3QksjDFr" +
           "PrllbIOOz8+yryEUtRXejoVfiKAfGyHmKrY7LzkCBUnWMLyrOfa1cwytwDeL" +
           "jv5j1zde74U08wnu3a3KyqbytY33o7HYm1/U7DWcY16EeE/GewzDvqNDo9yr" +
           "hsEh45dc6UuCmlFQFFpgGP8FCYQpH/wZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
