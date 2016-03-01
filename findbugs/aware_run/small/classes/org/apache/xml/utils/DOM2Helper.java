package org.apache.xml.utils;
public class DOM2Helper extends org.apache.xml.utils.DOMHelper {
    public DOM2Helper() { super(); }
    public void checkNode(org.w3c.dom.Node node) throws javax.xml.transform.TransformerException {
        
    }
    public boolean supportsSAX() { return true; }
    private org.w3c.dom.Document m_doc;
    public void setDocument(org.w3c.dom.Document doc) { m_doc = doc;
    }
    public org.w3c.dom.Document getDocument() { return m_doc; }
    public void parse(org.xml.sax.InputSource source) throws javax.xml.transform.TransformerException {
        try {
            javax.xml.parsers.DocumentBuilderFactory builderFactory =
              javax.xml.parsers.DocumentBuilderFactory.
              newInstance(
                );
            builderFactory.
              setNamespaceAware(
                true);
            builderFactory.
              setValidating(
                true);
            javax.xml.parsers.DocumentBuilder parser =
              builderFactory.
              newDocumentBuilder(
                );
            parser.
              setErrorHandler(
                new org.apache.xml.utils.DefaultErrorHandler(
                  ));
            setDocument(
              parser.
                parse(
                  source));
        }
        catch (org.xml.sax.SAXException se) {
            throw new javax.xml.transform.TransformerException(
              se);
        }
        catch (javax.xml.parsers.ParserConfigurationException pce) {
            throw new javax.xml.transform.TransformerException(
              pce);
        }
        catch (java.io.IOException ioe) {
            throw new javax.xml.transform.TransformerException(
              ioe);
        }
    }
    public org.w3c.dom.Element getElementByID(java.lang.String id,
                                              org.w3c.dom.Document doc) {
        return doc.
          getElementById(
            id);
    }
    public static boolean isNodeAfter(org.w3c.dom.Node node1,
                                      org.w3c.dom.Node node2) {
        if (node1 instanceof org.apache.xml.utils.DOMOrder &&
              node2 instanceof org.apache.xml.utils.DOMOrder) {
            int index1 =
              ((org.apache.xml.utils.DOMOrder)
                 node1).
              getUid(
                );
            int index2 =
              ((org.apache.xml.utils.DOMOrder)
                 node2).
              getUid(
                );
            return index1 <=
              index2;
        }
        else {
            return org.apache.xml.utils.DOMHelper.
              isNodeAfter(
                node1,
                node2);
        }
    }
    public static org.w3c.dom.Node getParentOfNode(org.w3c.dom.Node node) {
        org.w3c.dom.Node parent =
          node.
          getParentNode(
            );
        if (parent ==
              null &&
              org.w3c.dom.Node.
                ATTRIBUTE_NODE ==
              node.
              getNodeType(
                ))
            parent =
              ((org.w3c.dom.Attr)
                 node).
                getOwnerElement(
                  );
        return parent;
    }
    public java.lang.String getLocalNameOfNode(org.w3c.dom.Node n) {
        java.lang.String name =
          n.
          getLocalName(
            );
        return null ==
          name
          ? super.
          getLocalNameOfNode(
            n)
          : name;
    }
    public java.lang.String getNamespaceOfNode(org.w3c.dom.Node n) {
        return n.
          getNamespaceURI(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "3IOByfhj7/8ALJC+kR0gAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C6zr2Fmuz54558w5nc45M9PHdOjMdGZOgU5gOy/HDgO0" +
       "juPETvxIYsdJzOPUsZ3Eb8evOOYO0EqlFUVlxJ1yey90EFLLs6UIqIqEQIMQ" +
       "FAQq4v0SFBDvUomCePZeyrKz987ee845vaOZeyN5xV5e/1r/97/W77XWRz4L" +
       "XQwDqOR79nZpe9GhnkaHpo0cRltfDw97DDJQglDXCFsJQxHU3VSf+PFr//L5" +
       "Z1fXD6BLMvSg4rpepESG54YjPfTsRNcY6Nq+lrR1J4yg64ypJAocR4YNM0YY" +
       "Pc1ArzpFGkE3mGMWYMACDFiACxZgfN8KEL1ad2OHyCkUNwrX0DdDFxjokq/m" +
       "7EXQ42c78ZVAcY66GRQIQA/35M8SAFUQpwH0phPsO8wvAvz+Evzc//jG6z9x" +
       "F3RNhq4ZrpCzowImIjCIDN3r6M5cD0Jc03RNhu53dV0T9MBQbCMr+JahB0Jj" +
       "6SpRHOgnQsorY18PijH3krtXzbEFsRp5wQm8haHb2vHTxYWtLAHW1+2x7hB2" +
       "8noA8KoBGAsWiqofk9xtGa4WQY+dpzjBeKMPGgDSy44erbyToe52FVABPbDT" +
       "na24S1iIAsNdgqYXvRiMEkEP37bTXNa+olrKUr8ZQQ+dbzfYvQKtrhSCyEki" +
       "6LXnmxU9AS09fE5Lp/TzWe6r3/dNLuUeFDxrumrn/N8DiB49RzTSF3qgu6q+" +
       "I7z3Kea7ldf97HsOIAg0fu25xrs2n/hvn3vbVzz6wi/v2nzJLdrwc1NXo5vq" +
       "h+b3/cYbibc078rZuMf3QiNX/hnkhfkPjt48nfrA81530mP+8vD45QujX5p9" +
       "64/onzmArtLQJdWzYwfY0f2q5/iGrQdd3dUDJdI1GrqiuxpRvKehy+CeMVx9" +
       "V8svFqEe0dDddlF1ySuegYgWoItcRJfBveEuvON7X4lWxX3qQxB0GVzQveB6" +
       "Ctr9iv8Ieju88hwdVlTFNVwPHgRejj9XqKspcKSH4F4Db30PThVgNF9p3qze" +
       "RG9W4TBQYS9YwgqwipUOp45dCCSE2zxbpXQbGMFhbmn+/4cx0hzn9c2FC0AF" +
       "bzwfAGzgO5Rna3pwU30ubpGf+7Gbv3pw4hBHEgL+BAY63A10CAYqFBge7geC" +
       "Llwo+n9NPuBOvUA5FnBzEADvfYvwDb23v+eJu4Bd+Zu7gWTzpvDt4zCxDwx0" +
       "Ef5UYJ3QCx/YvEP6lvIBdHA2oOZMgqqrOfkgD4Mn4e7GeUe6Vb/X3v03//Kx" +
       "737G27vUmQh95Okvpsw99Ynz4gw8VddA7Nt3/9SblI/f/NlnbhxAdwP3ByEv" +
       "UoCJgmjy6Pkxznjs08fRL8dyEQBeeIGj2Pmr45B1NVoF3mZfU+j5vuL+fiDj" +
       "K7kJPwiu8pFNF//52wf9vHzNzi5ypZ1DUUTXrxH8D/7+p/62Voj7OBBfOzW1" +
       "CXr09Cnnzzu7Vrj5/XsbEANdB+3++AOD//7+z7776woDAC2evNWAN/KSAE4P" +
       "VAjE/K5fXv/Bp//kQ799sDeaCMx+8dw21PQE5EGO6Z47gASjfemeHxA8bOBc" +
       "udXcGLuOpxkLQ5nbem6l//vamysf//v3Xd/ZgQ1qjs3oK754B/v6N7Sgb/3V" +
       "b/zXR4tuLqj55LWX2b7ZLiI+uO8ZDwJlm/ORvuM3H/mfn1Q+CGIriGehkelF" +
       "iIIKGUCF0uAC/1NFeXjuXSUvHgtPG/9Z/zqVZNxUn/3tf3i19A8/97mC27NZ" +
       "ymlds4r/9M688uJNKej+9ec9nVLCFWhXf4H7+uv2C58HPcqgRxVMzSEfgPiS" +
       "nrGMo9YXL//hz//C697+G3dBBx3oqu0pWkcpnAy6AqxbD1cgNKX+W9+2U+4m" +
       "1/T1Air0IvA7o3ioeLobMPiW28eXTp5k7F30of/g7fk7//zfXiSEIrLcYm49" +
       "Ry/DH/neh4mv/UxBv3fxnPrR9MUxFyRke9rqjzj/fPDEpV88gC7L0HX1KNuT" +
       "FDvOHUcGGU54nAKCjPDM+7PZym5qfvokhL3xfHg5Nez54LKP9eA+b53fXz0X" +
       "T67mUn4DuCZHrjY5H08uQMXNWwuSx4vyRl582bH7XvYDIwFT+ZH/fgH8LoDr" +
       "P/Mr7yyv2E28DxBHs/+bTqZ/H0xDF52bmqcW1K+NoNfkk9Kmph5qnnPY9tTY" +
       "0d1oF9TyspoXb9uNhdzWhL4qL9rpBcDexeoheljOn/u3hnBXfvvlIAyFRVoM" +
       "KBaGq9iFoNoRcAlbvXHMuATSZGBDN0wbPeb3emH+ubYOd7nlOV7b/9e8AvO+" +
       "b98Z44E09b1/8eyvfeeTnwY22IMuJrl9ANM7NSIX55n7t33k/Y+86rk/fW8R" +
       "VYFOBkr5e34671W6E+K84PNicAz14Ryq4MWBqjNKGLFFINS1Au0dXW8QGA6Y" +
       "L5KjtBR+5oFPW9/7Nx/dpZzn/excY/09z337Fw7f99zBqUT/yRfl2qdpdsl+" +
       "wfSrjyQcQI/faZSCovPXH3vmZ37omXfvuHrgbNpKgq+yj/7u//m1ww/86a/c" +
       "IlO62/ZehmKja89S9ZDGj39MRdYRfJyO3GSqo9xGrA65NK1ThKCGRlL3enRG" +
       "r7YDvpmiHVqfUbjN1KpZUhttMxbjWLRZJTyLloa2JW09Rqzj7FqakVgfHwbl" +
       "mY8o5Mr3LKWztM1UUknL7k/TsUzCdd8ZKkwj0WuyqyVyazrp2OuGUtPQNRzA" +
       "CVqKdBgtJXo9LYnjKDRMYS7NMpGMEJdtu5KZyJHCeXFFiYRqBRvM1xQDTzew" +
       "ysIBtfUrrXEkM70lMozL/Iqz44g1Kk4TYeS1g2RrI2FRZxiuVozWCXiZGwuI" +
       "EhtNQLGOthorStK45lBkl5rPhv0yvVZ4dVL1F1bAVUcb0lW3PYNzyNSBW9tF" +
       "XZ8QfXvSpvh5P8NNodGWynW5SZaQOmfoFWtMNkYs1wucYGV0g8z2R53AJLm5" +
       "FMNygg8FmBp6lGLW60bFGkVZjWvXR2zVtdP6bN2SYoccVWp6mxhRoRZuKpHB" +
       "jg2flZtx2TeJaRjEcswaSDt1w4bKkVNhWZdX5TbOOsF8ig4nmYu1y3KfkUh+" +
       "von6s+0YI3vqtFeJVn1xYoqrNW9N1M2M62jbdDo02tGUzSprZVqtLoxlUydH" +
       "aKO2XihuvbzimIY9ao4aqrnsi/V2i2YyY9xbrGeyUBqkkhHaTdEPebyZdfq+" +
       "7yA1KUh0KYkqW5/Fl/PRHOtOBbk3m5XhsRQQ4kw2xtLcXspYiSYktpGUg1W3" +
       "hFGTvtKIyiEjlVp1Nuj0VjPwCYEnM9WS6Wi9qos8u55sOXOmtaIyzlHbFs+2" +
       "R47ikX6NICp0Qiu9USLCKl5qi6VGJ1gPyWGEixPCWHWmSDSujhl0IguiskBK" +
       "tTnd0+1xf9TA6R4yaNZmQ2fSH8uJPd0GLEy54iKJK1xSrrMWTvE8O562SzOM" +
       "8obKotz2JnKqtBcC3lkjodlukn5W2nDksq/14LCxzepwUkqMQFOrLuWPmr4j" +
       "++XmtLZtiXpniJTNRYr2s8lKwuarJu+xeGWeqtNBaGdh6DRcX5BsPOLY7cQk" +
       "U5toYJrQqNXgoOYMws2W8BVDs401aZN1wuRDiXb6QTdoS6yczm2Gk/m+b+lK" +
       "Oo1QZag2Vh1JhnuRlKUx20R4wRTTdbgZJlino0pEi1mviXgdUOZU1HwqxSsd" +
       "1qEBHWXTnJjxIwqmuK0+3yx7neVM8YdTbcKpjGZ7g2rdo3uZg9cqXUZQRuaq" +
       "g4sC01pzjGfFpoD1q/5syK2zJouPxm2ml/YVll5p7sqWMF3g1rMWQfZpbjCA" +
       "WXLWR+VNmcJNnAyzLVnHu3pjwZW7DGsYnrkdTQLGb9CJkbVWo4TARu2wly69" +
       "Hq72N+OWgevVIZ/ivRYtlta1Fh7Ptxu+Ey2dzWAgGXBYUlElm4bzdNONM54U" +
       "MCKtTmVc1Cq+NrCMQicLd641evZ0Xa93hBHueRvYMK2kJEquxVT5qSwsw1ac" +
       "in18a63FluoMzCzzeJU3DUzF2GalbiP6wFI78ozoKJ06h/Y2srd04AzlfVRz" +
       "MjheuG7qrUpU3OhvcGuGgAjUozt0rVRZDOdUZaIgzb7rhXCo4GuBdPDFrJPy" +
       "s5mKO+K0nmJLw+zNyiWFjjqT1qbG4ILE8g7X5SbYkGJAzFoQPVMyFr4UsoIU" +
       "06yzmfJa2JiSHCrz7Lyr9p1uzxl0ZFo1m92s5niixsNwpVHXkTLVN9PWANdT" +
       "O8Rq9KDfWE6ZCmMNp10sbSW10oJpoxuaXaBNy8NwtYnE43mIu4wU4+qE7G2w" +
       "Uh0YHIpkiWUGG0nLKJpOQqu07XJCV+DbSofrkAI7QkoItmTCcpWLaWc9n2tj" +
       "wu7amu9i8saCt66coIafoYq0jVKP7c45ehsn8w3RhGvlji7qdqZz3HJZwYeS" +
       "6ZfCLEJCCyGdGIknk9F8sRp0aDTDKqUSLjWI/lJrcKNJlA1aFinWl/SqE5ep" +
       "GQX8pDlvVB205YVBbZk1gfpXG3dtZpuqoYqcm21RcpxWSxtrO08mlDYKrUWb" +
       "mLn1foWEK2S5PI+G+rK2qbp80NTWSLXRavnoUGEJZ0Zp8rDb9Of9YX0xjJkp" +
       "HERYk6tO0yqFO3HPnijDCR+stZXlt5hhpm9aM1YZg6RqEs/Ndsz1KxtbEGZZ" +
       "1lDLaMmW1hLLuBsUxGI/QxCsjvFuqi8twwC5AdWORRvrt3qhto3g5kAxO7V6" +
       "VvK4bVeuTzvxLHGb2/KipvmLeVJq2g5vbaQMGVvaYtBv1nV+kE2MJjJmV2iF" +
       "poWwySCz2Zju2FMtdNK0XWqbkwlMIMx2avcDnnXD1tqz1cmgOlz2AD+cKlBG" +
       "Vg14kZVtJOoOPdVXFomZtUuhy7Qn0jBtIjMXdLPe+mqqu5sa3wkRMcEWrfHS" +
       "C3pdg9gMkTEdBlZNHKK2v562vZmIlNbE1rB7A2EEInyf7BldQ5vO5I2W2PVe" +
       "OktJpT9Z9VociyC0F0rb/khOxjAsYWFvxBFAr1mYEgs2wKqz6tSXNhYZpWq4" +
       "CW2PANE+6AUIRYSN0sow1EED7Y/ijpzKVAKLiwrWoxYZI9TcrUH6sUOHZS4c" +
       "ljNkBdxNlHjdTMiBgxCNiY2U51Qyr8ATF7ibRyjd5Zos6XOiig3hDR6jA99I" +
       "YV9pZROexigOM5N+AJMuhcmLCdNpV1vYeDTc0jWkagiMJgimpq4NrCMLdmmx" +
       "0oIuSphzgsW2ctWZIrPSVpeIkSFVOyOqHFI1Yra1OutgpPuu3kJYuSdMeSOg" +
       "V5jUFYTauouY0rIzqq6tVKlI/Zkwb0wJM0irtLjEla3ojBnTIafIvBIL5QrO" +
       "mm2LolyCLwWL6oKZlepNxh34vSzSZXRUReB6MkxW3d5k6tBuT8vMZNDf0rzl" +
       "dI1I470phrs4llmlBpli9BATmkqNVyZyjJgr0zGcVmnLiKTFh4sYtkwbbuqs" +
       "rnstbsXVWgLrCB4rq0PPGtM0iEn1WWTXXSlpLaNKtT1k3CVIS9OKuaqQq7LA" +
       "9DZ2pVON0e7MN0Rs2jK4ZZWpZjUm2boCsWwO6pQkiCgzQAK0M2jbtsYnGaJF" +
       "U39Z2pbGIytrJqFp8vCcCpN+ImMtudeX1xpCdCdIRYd76iRO2b44iGomSDhI" +
       "otlyuunaAA6PYfDAd2hBG0aJOUxKDQStl+MtC8+FsSRIqOpMpmAK3wz66ERY" +
       "yJUgpmYMQ7ANlaQItdXzuR4aDjFyBZLNDbmtbTru2sjSqJtuGvxQoVBi0ytp" +
       "wzgp0aulvNH7qNGiuonaEbR6baFh026lOhDn1LJLDcNuWkUwWiONaFWOy4nc" +
       "ZFr1bgzHGQriOTpFrW0lKddU1NLqsIZafSNVBqSEb6IuwYVGaxrFvmsNxoB1" +
       "RyB5aTZjcd7YbKzQtHqGrDO2v8T4AZxu1xTND/qqVi03BjUht7+q01LH2BKI" +
       "ol+uTx28SiHcxIrLjs4s+5NpdZCy5bqD2+YGZJqb0OnNS9i6XLFcnecb5RhG" +
       "GpgXNLlhdY6EVBY4AwBgiiHj0npZWWktXEsmTRB9UiZwjJ6CoaGwwGSSHs+b" +
       "w7RbS2ZMR0XblNQKM7MkpYyHYXElcwcU3Ml8hxXHZbyW9UGy0hhsRXuW9NqB" +
       "Q9MKcMxFQx5MDdi0RCHjN5GlerjQYwnC7tdRntT6MeBCC6UmKZdXAd5ktX5D" +
       "GegyK3WYqopv62NVJdBJb0tpeF0l2+R47UqETclNDE+mrVIT00Vkg/ozoiWg" +
       "QyNxlhZv2osBMaDNRh3k8FR5qXmJUxF6c2wwWG3RdqWvSoxT27qGyxo1l9km" +
       "CFePtnW3xaWa2I5QDEwLs2xRl8bD1JuK1bXSBJFkLetyB3wlbzxkrQ87S2MN" +
       "D9w+X4Pr3nzjmfVOxGr2tJzgsuY0S5NhV5iV5wg82AwbtXZKzALKaLRwetmS" +
       "qpuuKYpzLh02eojGG0N7VhWddQ9Jm7rIxJqfxX5pqs1oYZFunXKzb8F8OGRj" +
       "s61kSZJQpjieus21syqDpBrMJA1hPLVElBfbtSXPTiuRIlXcOTAr0W0Yqpuh" +
       "eIW1enHJ0BpjckqRdLu3RtE2B2s+Vx3HSg/DMJPL0EYjKm1UlxtXrSXR6TKz" +
       "tNmYebIwXy2YemoZcFSz8Eid1JSxK60wxB3UlsHY2IQIvRpUVsBLx/oUD6vN" +
       "WlquZZZA+HNCt9U2YvanXS6a9ueJV/eHFRl8gcITeStWMqrEkmnX6hB8DaMz" +
       "s4w7clRbNbOybaJrEDa2Ja4flmdyNOtXaGTdS5ZxW2/TSLcsuVG1vZI7hLgZ" +
       "bD2f5Mvl7UJMMck1Na5G8+CDcWWiMIYzPaJkjcpL8AX+Nfmn+fKlrY7cXywE" +
       "new4mjaavxi9hFWB3avH8+LNJytwxe/S+V2q04vd+xVQKF/peOR2G4nFKseH" +
       "3vnc8xr/4crB0crxPIKuRJ7/lbae6Paprq6Cnp66/YoOW+yj7lc0P/nOv3tY" +
       "/NrV21/CPs1j5/g83+UPsx/5le6Xqt91AN11sr75oh3es0RPn13VvBroURy4" +
       "4pm1zUfO7pU8Aa63Hkn2rbfeK7n1wmZhBTvdn1uYv3C023W8AHh6wZLzNL0g" +
       "eubORF9e7OEVu25RoLhhvhF0KB7f6QGZqrqfC7jo7B15kQJNqitdtfIxin6+" +
       "4ZTBKRF0d+IZ2t4St19sfer0OntREZ+IrjDMN4KLPRId+8qI7vSexrN3ePdd" +
       "efHeCHpVGPu+F0ShgE9vBfny3PNsXXH3qL/jZaAuDObLwHXzCPXNV9Rg8sdu" +
       "0eD77gD9+/Pif+XQ9ej08ve79hi/52VgfCCvfARc5hFG85XX7I/e4d1H8+IH" +
       "ALzlWXjdPbwffCVU+K4jeO/6f+Lzr899PnfeEDgx7fpxtFs2L2g/cXv1v7No" +
       "8DN58RMRdNHPT+qcU+5Pvly3fQxcnzpC/6lXBv1B0eAgfxztrfgX76DmT+bF" +
       "CxF0H1BzfoIKaLm1pdvH8nvwdMw8er8Xwc+/DBE8lFc+Ca6/PBLBX74EERQI" +
       "d1P/F5PDNxdF0eq37iCH38mLTwFzN8I8bOOLaLeF+Nwe7a+/DLSvzStvAN1d" +
       "2tHu/l8htKfsdgf003cA+md58YcRdA0oHOQBQJ/8IkdcUO/B/tHLAFs0A/P5" +
       "hTccgX3DK+rbe5yfuQPOz+bFX0XQAwAn46mKzYF8ZA91tIf6168E1KMTEBdu" +
       "c8zjZUP91ztA/fe8+Mcd1Bxl6CvqraH+00uBCvKYq/szRvmBiYdedIBxd+hO" +
       "/bHnr93z+ufHv1ccszk5GHeFge5ZxLZ9en/71P0lP9AXRoHgym6328//LkBH" +
       "e8vnDzyBOFz8F4x+Ydf2LhC5zraNoLtAebrNJYBj3yaCLu1uTje5AqhAk/z2" +
       "qn8c+x693amrnUDSC2cT/hMhP/DFhHzqG+HJM5l9cYz0OAuPdwdJb6ofe77H" +
       "fdPnGh/enQVSbSXL8l7uYaDLu2NJJ5n847ft7bivS9RbPn/fj1958/FXx307" +
       "hvdGeoq3x2598IZ0/Kg4KpP99Ot/6qt/8Pk/KXaz/wuXBmPP3ysAAA==");
}
