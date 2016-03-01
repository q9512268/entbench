package org.apache.batik.dom.svg;
public abstract class SVGOMAnimationElement extends org.apache.batik.dom.svg.SVGOMElement implements org.w3c.dom.svg.SVGAnimationElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMElement.
                 xmlTraitInformation);
             t.put(null, SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_BOOLEAN));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedBoolean externalResourcesRequired;
    protected SVGOMAnimationElement() { super(); }
    protected SVGOMAnimationElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() { super.
                                                     initializeAllLiveAttributes(
                                                       );
                                                   initializeLiveAttributes(
                                                     );
    }
    private void initializeLiveAttributes() { externalResourcesRequired =
                                                createLiveAnimatedBoolean(
                                                  null,
                                                  SVG_EXTERNAL_RESOURCES_REQUIRED_ATTRIBUTE,
                                                  false);
    }
    public org.w3c.dom.svg.SVGElement getTargetElement() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getTargetElement(
            );
    }
    public float getStartTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                            getSVGContext(
                                              )).
                                    getStartTime(
                                      ); }
    public float getCurrentTime() { return ((org.apache.batik.dom.svg.SVGAnimationContext)
                                              getSVGContext(
                                                )).
                                      getCurrentTime(
                                        );
    }
    public float getSimpleDuration() throws org.w3c.dom.DOMException {
        float dur =
          ((org.apache.batik.dom.svg.SVGAnimationContext)
             getSVGContext(
               )).
          getSimpleDuration(
            );
        if (dur ==
              org.apache.batik.anim.timing.TimedElement.
                INDEFINITE) {
            throw createDOMException(
                    org.w3c.dom.DOMException.
                      NOT_SUPPORTED_ERR,
                    "animation.dur.indefinite",
                    null);
        }
        return dur;
    }
    public float getHyperlinkBeginTime() {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          getHyperlinkBeginTime(
            );
    }
    public boolean beginElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElement(
            );
    }
    public boolean beginElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          beginElementAt(
            offset);
    }
    public boolean endElement() throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElement(
            );
    }
    public boolean endElementAt(float offset)
          throws org.w3c.dom.DOMException {
        return ((org.apache.batik.dom.svg.SVGAnimationContext)
                  getSVGContext(
                    )).
          endElementAt(
            offset);
    }
    public org.w3c.dom.svg.SVGAnimatedBoolean getExternalResourcesRequired() {
        return externalResourcesRequired;
    }
    public org.w3c.dom.svg.SVGStringList getRequiredFeatures() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredFeatures(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getRequiredExtensions() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getRequiredExtensions(
            this);
    }
    public org.w3c.dom.svg.SVGStringList getSystemLanguage() {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          getSystemLanguage(
            this);
    }
    public boolean hasExtension(java.lang.String extension) {
        return org.apache.batik.dom.svg.SVGTestsSupport.
          hasExtension(
            this,
            extension);
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "F38c+R9cuk4LWioAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17Ccwj133ffKtbkbQryZJlxZIsaeVaorVDcoZDMvI1vIbH" +
       "DGfIOUhOmqyHM8M5OBfn5rjK4aC1kSCOkUiOg8QCWthIEzhW0MZIg9aFjMBN" +
       "DBtFHQSNW7R2UKRtmsRAVKBuELdN3wz5Hfvtt7tWdlsC8zh87/+O3/96/3fw" +
       "89+B7gh8qOS51laz3PCSmoaXTKt2Kdx6anBpSNYYyQ9UpW1JQcCBvMvyM795" +
       "/rvf+6R+4Rx0pwg9LDmOG0qh4TrBVA1cK1YVEjp/nNu1VDsIoQukKcUSHIWG" +
       "BZNGEL5EQj9womoIXSQPhwCDIcBgCHAxBBg/pgKV7ledyG7nNSQnDDbQj0EH" +
       "JHSnJ+fDC6Gnr2zEk3zJ3jfDFAhAC3fnvwUAqqic+tC7jrDvMF8F+NUS/Mov" +
       "/uiFf3IbdF6EzhsOmw9HBoMIQScidJ+t2kvVD3BFURURetBRVYVVfUOyjKwY" +
       "twg9FBiaI4WRrx4xKc+MPNUv+jzm3H1yjs2P5ND1j+CtDNVSDn/dsbIkDWB9" +
       "9BjrDmEvzwcA7zXAwPyVJKuHVW5fG44SQk+drnGE8eIIEICqd9lqqLtHXd3u" +
       "SCADemgnO0tyNJgNfcPRAOkdbgR6CaHHr9lozmtPkteSpl4OocdO0zG7IkB1" +
       "T8GIvEoIPXKarGgJSOnxU1I6IZ/vjN/3iY84fedcMWZFla18/HeDSk+eqjRV" +
       "V6qvOrK6q3jfC+SnpEe/9PFzEASIHzlFvKP57b/35ofe++Qbv7+j+cEzaOil" +
       "qcrhZfmzywe+8c72883b8mHc7bmBkQv/CuSF+jP7kpdSD1jeo0ct5oWXDgvf" +
       "mP6rxU/8uvrn56B7B9CdsmtFNtCjB2XX9gxL9QnVUX0pVJUBdI/qKO2ifADd" +
       "Bd5Jw1F3ufRqFajhALrdKrLudIvfgEUr0ETOorvAu+Gs3MN3Twr14j31IAi6" +
       "AB7oGfC8B9p93p0nIeTCumursCRLjuG4MOO7Of5coI4iwaEagHcFlHouvAT6" +
       "v36xcqkOB27kA4WEXV+DJaAVurorhBXXhoMYKJZA0BTuGPaR11Ad4ImA4nn/" +
       "/7tMcy5cSA4OgIDeedo9WMCy+q6lqP5l+ZWo1X3zC5e/du7IXPb8C6FLoN9L" +
       "u34vFf1eAv1eAv1eOrNf6OCg6O5tef87XQCSXAOfALzlfc+zPzL88MefuQ0o" +
       "oZfcDsRwDpDC13ba7WMvMih8pQxUGXrj08lPCj9ePgedu9L75mMGWffm1Znc" +
       "Zx75xounre6sds9/7E+/+/qnXnaP7e8Kd753C1fXzM36mdPc9V1ZVYCjPG7+" +
       "hXdJX7z8pZcvnoNuB74C+MdQAvoMXM+Tp/u4wrxfOnSVOZY7AOCV69uSlRcd" +
       "+rd7Q913k+OcQuwPFO8PAh4/kOv7s+D5wN4Aiu+89GEvT9+2U5NcaKdQFK74" +
       "/az3mW/+6/+GFOw+9NrnT8yDrBq+dMJT5I2dL3zCg8c6wPmqCuj+46eZX3j1" +
       "Ox/74UIBAMWzZ3V4MU/bwEMAEQI2//3f3/y7b3/rs3947khpDkLoHs93Q2A7" +
       "qpIe4cyLoPuvgxN0+O7jIQFnY4EWcsW5yDu2qxgrQ1paaq6o/+v8c5Uv/sUn" +
       "LuxUwQI5h5r03hs3cJz/jhb0E1/70f/5ZNHMgZxPdsdsOybbedCHj1vGfV/a" +
       "5uNIf/IPnvil35M+A3wx8H+BkamFS4MKNkCF3OAC/wtFeulUWSVPngpO6v+V" +
       "JnYiKLksf/IP//J+4S//5ZvFaK+Mak6Km5K8l3YalifvSkHzbz9t7H0p0AEd" +
       "+sb4716w3vgeaFEELcrAjQW0DzxOeoVy7KnvuOvff/l3H/3wN26DzvWgey1X" +
       "UnpSYWfQPUDB1UAHzir1PvihnXCTuw99ewpdBb7IePxqC+jtNaN3tgXk6dN5" +
       "8tzVSnWtqqfYf27v1vLfj4B4sUCZhxyXdiHHYcFzZ7pVfAmcCwDdceUo96bF" +
       "uD5wHQl38qRZFFXz5Id20GvfF5d2tI8Vv/Lo+flrO+JeHrod+7LH/pq2lh/9" +
       "T391laoULviMiOVUfRH+/K883v7Anxf1j31hXvvJ9Oq5CoS5x3Wrv27/j3PP" +
       "3PmVc9BdInRB3sfQgmRFuYcRQdwYHAbWIM6+ovzKGHAX8Lx05OvfedoPn+j2" +
       "tBc+niPBe06dv997yvE+knP5feB5ca87L55WuwOoeBnvNK9IL+bJ39lpUf76" +
       "nhC6Mygi9b2n+xvwOQDP/8mfvME8YxfSPNTex1XvOgqsPDCFP5zaFudLRjhw" +
       "isnjSFJAD99zlR4WJtlxo6W1HTiKmqoKl3u1YwspFI2+kaINrrS+94OnuWdD" +
       "8xpsEM9mw0HBhoK3bAi9A+im6juSlS82ishoqm4iw1eVQ0gvfj8Ri6q0XNdS" +
       "JecUrh++Ia5iHOkBmITuqF6qXyrnv+WzR34bkJ0HGGnIed4U1FgZYOSHUN5u" +
       "WvLFQ5EJYOkF5HLRtOp58QdPjYv9vscFDPmBY69DumCZ8zN/8smv/9yz3wbW" +
       "NoTuiHNLAEZ2wjWNo3zl9w8+/+oTP/DKH/9MMdECtjOf6l74UN6qdQ10+atW" +
       "IMsT/RDW4zkstpANKQUhVUyMqpIju76TYXzDBiFEvF/WwC8/9O31r/zpb+yW" +
       "LKc9yili9eOv/PTfXPrEK+dOLBSfvWqtdrLObrFYDPr+PYd96Onr9VLU6P3X" +
       "11/+5//45Y/tRvXQlcueLljV/8a//d9fv/TpP/7qGbH07RaQxt9asOGDf9JH" +
       "gwF++CErUkfE+XQ6jxAujkyUrqMwjGg0rbWI3lwzS5ZeGqZyv71NK5VUHYp9" +
       "ZWgr9WV5uURE26bt5qzSNhb6aNBjqybabRheb9SCe5prbWbDoTFvldfskJpM" +
       "zdFs44HYZgTX2PXIHqyNuR2LVdFRHNHJvJk/H8/LGY/BlSYSY7BaqjTLmZ6h" +
       "9iLZKmPCbq/1ibEchoTJawjiyGS0JrjlcqgRw1iThG2jKTURZG5iWZNH9LLV" +
       "66dreNAygN12JorrjFiJZrLhgtcSe8QOymOrLU7dSuS0wlm/1ZY8Vi+JZGut" +
       "SHx1Nh1Ylc3aHuF+td03qDFu05hFaUnV7lYSypCJVnNsDRp2NXIFaWBPZ1Zf" +
       "CM31iIIHfNVKK6NhWC2Z1GKzaCrDJBmWJ1uuRugUZemkYKwcabNp+EJzNltM" +
       "7Zk6wUqTAWm0Q6OXcniZmSaIpDh13XBrWYvqtaY9UUm7iy1VEfr2YGjT68yx" +
       "selG9BbbuNYybHK97EYLXpIWiOTwqlZue4jUND2WYrxUoOx1tTKNOv54uQlb" +
       "3X4LNxvwYFmeTBW2F48VhkonSShk5EgZoXRFRphZNWRCat6PI6XbbFbSJVzW" +
       "xI0amIpIslqDmi6mOEVH686EWGOT+cwci/Z6y9VZl2p3m5WW0rWnXpTNl91k" +
       "683T3qJlZbiu8SvRZDeNDFV8ArcTbtEcZEMhq9lzdF2z4OmGW7tCKejPRgss" +
       "9BZcUGolY3/YMhaOTuLN7VZorHtDdj6At+FqUFWMRl+b4iE3HFcXbQnDPLmr" +
       "4i171saMduLCSleVO5jVL3P9Dd1u07FcccqLqVQuT1qoUCJsZW1balTFkvZm" +
       "5tKtkZtQ4dpPrag9E33dZudzuL9tLOR5WNnGvtXBh4locMJwmsLEuLVRCDMc" +
       "Evami+qdddarBrM0QnmPK6F0NyHb6wxpe0ESLzO9AjSLcBslkTJpctufWP6G" +
       "Mgw06HejMZMR3lLpd8XOZjzik/JwmMGMrNcsRBDHbGXR8TybldKuP0CWVnlR" +
       "hSN4Y7dKRn8hkNyE9bqCjK2TRUOadmYhy5FCpTLqYdrI3E5qLCcKawKD48FQ" +
       "SPo1ipfMeshueGpreoNITlaCZDbG5TavGYuJq29Qq8byUtj0cT3WmhV73O0N" +
       "mF7VbmNpasAG0tX0boXetG1JmExavMBWCAPxN2STHhGyjGmtZtl2K8rUxeMU" +
       "lml7u+0K00kDcdFhayqoJaYd4QLeZAOzvRSU8WSBB6vNXImFquQNsGnK8PgM" +
       "baUpU4KbiM3z/FDD+hOz1QrqWXnQHa99gbGG47mJenVqY86cvuvCy7qr6m7U" +
       "62+pKdZRjKYe6zAvaUhilomtI5GJ3VP7Khf0Ya5Xxe0W2uW04dTvwYIsN2Yz" +
       "hK9Y6ICT5I5FTVK920sX6w0n9RkiI0w06nN20littj1bW7WHeNZYu/i6NmNH" +
       "NT+lFuwCm08Fr7sxR2R1tYhbTiVLh720TNCIGTbkUmlcg3tpRK1XRJp04sF8" +
       "g/CmGLGYFPO9lT+uYnO12VRjM+pLLgc7jph2sXZL9AejNaJuV7zUT+V5lvKq" +
       "kZVqbmZRW5fYaENMxOluNxuv3DpLM3PBC7y1uNwEHc0abZzW1PaX/U24mNAY" +
       "HSUNVKjPE7rhJFOWSZH2stNULCHOUrii1afyeLuJbAvrUOoI0eyInParyGpr" +
       "lhpxDeksWYmhLbVSHxFh2p3y1bHb43iXMTUvLLPrfmTOo3q96dcbUn2MME18" +
       "4WBpx4vSJU63NWPdtUm4gozFOYL4WdKNdYcqEcTImSlDoYWNh+uxLTuC10vx" +
       "uWRssrCDbzDOnQhlh174vXmLGrH8sC1ahsNs68uA2KYZhsVKrQwwqtUhVhbp" +
       "CeHQK06oEUvHh6tKexwPjanhO4ImN6YU7sFuCCBijUG1311Va7riIDBYRQJF" +
       "xJV2PJhVHafXHepoP1G5aFVNYas2HzLIQliMW2EENxoMpajSqF1XG2D9gSIu" +
       "TM9HIzMTYV6dqfV1rSVl3WZnEPRmM7208RS/ojkEThnKCuE6lVJsuVVVS7ma" +
       "y08ms/HSKw/INHCc8aJsU5s5Em8w1lpyHjuVO5G3Fni9ytYTus0IKN3hCbwd" +
       "ZYTrk5nsKHVzxBkVkbfxBmraTqm7DdlZRC3qcbMh2Ywfmx5sqrU53J2Jukpw" +
       "ZGyxEdKbJEtSF7SAjKdtpjJnVgM+JILlqlzFxYxXxyzGDiKe3Y7SBc9N6LA9" +
       "w80JYVdGtjSBVzZa0Vg07bsBGSlCr9qfSsGSGQoNWnC2STlkFzYfrOQkZlvN" +
       "UoOmMqQMAiWVlhEPacoSW2v2YoeLeSWuRooi26RTrTUEuj1xSgZJUm6zNIe5" +
       "CcwxEhlHEyyLKKPpZwHKD4n5iHXhqNJqknCnowhwR6RGcTiIZ3rY67s9ekE1" +
       "KppKLhqMysgte7BplFZYz/ejPHS3LMtbhXOlgkVKTWxTQOAR06TxUpNrSN5s" +
       "0p/zQaxbjtcc8xzKSbDn+6msUzwrJ36qGGuzN1muTMdEld4QT9CUykZLi1u6" +
       "WjDBeh42l+uDTsexGC3oJDMBi0Qdz+rbNjdOHHRWUgbDoYpNBRRZrxWktpi7" +
       "3rylLAf1bJEiE53qkc2wZYsdozZS+NlEnjE9Ae0uMUWivDG9XqpzlqxTmNuw" +
       "hI3hcZMVsbA1LRmrQTbLWlPCwN0JJwHfk7lKSaLgJj+V0EoIw+rWTO36QImI" +
       "0szsNPrklJlzcaAPvZW/XFVcKy4l9QAhKbg6FxJ76lhdeIQMqqEWgtBvC8O1" +
       "SYlT4zTxg0AKxc2mKozEjtCXxn5CYE5vhZNipSGW1l1szceOUavDcs0LFzOf" +
       "t7deebYaRyBc18lEYcg401IbKF+84IPhVkbR/ogocUyp0VCILJzEfZoaN2S7" +
       "nk6CkUMLVX8oopTkLEeUb2cjFGVtmMLRDoaOLT0MRp0KXJLWBGDsEo+86sLp" +
       "ghiCslqiNFRHYmtW5WtDDZkiXYJfTKa2Xq0prMts1uTcMyNs0RgvNVgFoSKz" +
       "WY5TAdVpJ2KWSqm7tJog1K3XzD4BD0Zci1RpVeRaeqUWazHVgwdzrWQ0Vakl" +
       "lxLg40oEMls5YFm2pkNJcKI46XdQq1qOkRBNsSYc2uN5lQKzrhVbE2zDKz3T" +
       "0MMhN+43Gs4w5mabBOthNVUq1+p4M2ttMyOpbuq8QqwHJkOudb/bIiciCqaw" +
       "lrJSdHkim+U0ibdzeeqPYWvB0M2gIdpGUGVlOWLVtrNAR0igSbztkl28nDS6" +
       "FabcNeBqQkdbZzmktUnVmQZrRKdQbxL1oq4GzztBIvm4FNpJbbatd4OeNpj3" +
       "zGSjNwRqTDGlqUZ6/WBuTNaCi3sLeUiHwdpjnVXD17atFBs3qxNthnguumrz" +
       "5Uq02ijbUtXE+BEmGuwGRWgXhqWwWpdFtLcxO+Maac6t2VBqzuvznp+oBggY" +
       "QCtlRIFH8tB22kbq8JQ+2oKgu5baneoc6QXAW0dxfzmsx22P3HYEguelWUQo" +
       "BpfJ5ZG15m20Fc1k3XTFRHenXV02XXk+4DknVgm9HBMUPScs3wjBNIaqK8nF" +
       "+0xLmTSRIHBscc309f6svJwPpvUJA3c8FK17GbqlsblJbKUsDZrDcbMC+EE3" +
       "LK5SdlfVLpJ3vKkHWKU67W3AzK2zEWxSQjrV3UTesOVhyAiEUE1MpCU3mNRT" +
       "6FZr7QMsMTErR/2UT6p4rVTFI7+pNyYLc93oY8oUX0dG4mlY6MbYhJdFHMnS" +
       "TcuYiwFCSKIsxF6bMbyWZdaapQGtmc0VOhmtFky3VCbkNjdXHbMHo0FFsZIw" +
       "o3tEXDUGIcvomlKll61QAeHEDPYCxvZKayajCbhipETShvvLDO3JyNioNDZM" +
       "e5VpmgPWQd1Ox6/7VFAFAWa7j21gH+UIM2KBY082BFiOGd5wC3uNapkW3FRG" +
       "Wttyp+OJUVSDN20cnbR1PMFFg04nk0Ffk/E6zPaHHlppDSoLZWLJ+rZc73gy" +
       "rYnNTcJwTAfTl1qXNwf1cTLkfLbL21wd7rXrVtbVZjE9k6lKX4pmCTPriiuK" +
       "82TG8lIX3y5HeBQJC5LorQdBy3KbYzpbrdDxepMZWGvtaB1zseQ75TE5xVmt" +
       "XanQM4svCR2vvZI0fDBKmM3MJ9C0mxHjdccVUE/vL9ku6eATCfCh1Vp2FDnZ" +
       "ohVzz3+jxmzaURcNq1JGVLMZXu5PaR52swmXITM/LTdZs6Lb87ah0HFTYMpi" +
       "UKsuVYHHWz3FDKb9hdLFE9lj4oVCq0F9ofZSpuEx6lqUyWFXSmLZ5Gwv9YAc" +
       "9EmKrdCZZURoqa7KtY1Kbwk41bo6rM/VKt8KequKjI9LPMfGqEw5jWpXbEj9" +
       "plJRuKZQr7fnFcdhXMPTJ5VkZDBk3ZM5Pw5GIOIF6/HxQqpjmzJpCIHPr0Zz" +
       "cZGtNdHqZJNWueJZYm+YStNWd71BPKo2iAWZHYdmI64EEZ4EwhTFpu2YIcjJ" +
       "wLUW3QFi17klMYjgaBAqjWHsoKWljWFiL/Lphg1v2SEt8AgBd4JVh4Prgj0H" +
       "IWSHgGk0InVYWQVqH+NTWR334L5RHyUrLqpS+rIKnP4cX6ZTZjBTa81IQoRl" +
       "L1oLTmo25VjGS2o1SVqlpJt0sz7bsEZtYjJGZjOiVp5VymJan8PIRpsK/Xmo" +
       "Kw2wvNQ7ErfGcXGJMPqm3g6ssD90qGq6MGQlXpA0ghFIhdxmtZXu+ChvN0g1" +
       "SzvJUppkLLAppD+3mzQmeEhS4jAN3U6DAcIxSRNRvXC7Xmw6kVVrbWWhzc3M" +
       "Wqc2IdBSiZy1tzVZX2iDOsnIc4ae4TqP6NqcMYYsWg061rjZW0p0tsgyZxw6" +
       "Y6qibGu9ZteNlRk/kfodXMWakzJWNWqAgbLKI50RDmIrBCwzpk05WqPkzHBx" +
       "HH//+/Ptnpff2o7bg8VG4tEtiL/FFmJ6nR1oLYTulvYHE8enbcXnPLQ/Tj/8" +
       "Pn0wsjtcODjcmn0235pNEPnkjuzpE+R8G+6Ja92SKLbgPvvRV15T6M9Vzu0P" +
       "QdIQuid0vRctNVatE90+CFp64drbjVRxSeT4YOH3Pvpnj3Mf0D/8Fs6Vnzo1" +
       "ztNN/hr1+a8S75Z//hx029Exw1XXV66s9NKVhwv3+moY+Q53xRHDE1furZfB" +
       "M95LYXx6b/3Eydb1Ntavc8b0i9cp+6U8+fkQ+kHDMcLiqpCKWxZpxCoehr6x" +
       "jEKwWMtpghMamITQ7bFrKMeq+Qtv5diqyPi5Ixbcl2eWwCPsWSC8FRaE0F2e" +
       "b8RSqN6QD796nbJfy5N/GEKPHfPhSibk5b98DPgf3QTgRw+t7fIe8OW3KnPt" +
       "hlj/6XXKvpgnXwihC5oacpIP0r3lHlr542dY+UmSggOv3wQHCv/zBHhWew6s" +
       "bj0Hvnydst/Nk38RQvcB7Gwo+SFn2OpZan7HynKlE6C/dLOgnwKPvQdt33rQ" +
       "/+Y6ZX+QJ18LoQcA6Hbk+0CaOew89yvH");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("CL9+swjzm1rhHmF46xH+h1NlB1dOUI+dVN0OTXVBQOPlk0BR+Vt58kdgvs3l" +
       "btiepXYiXzq89HKCC9+8WS7k5v1Tey781K3nwp9dp+wv8uQ/h9AjAGQfTDu+" +
       "ZTjrlqoZzhni/i83AfThQ4X+2T3Qn731QL97trjzn98uCP4qT94EprzMEZ70" +
       "UqdM+a7l7rz4GPt/v1nsT4Pn1T32V28N9hP4vpITHNxxAwYc3JUnwNIeOMkA" +
       "vLjv9NdHWA8ObhZr7q0/s8f6mVsu54MHbwTz4Ty5L4TuVR1lD/IUxPtvhSp/" +
       "bg/xc/+PxPnEjXA+lSePAX0+xnmVMN9xE0ifzDN/CDyv75G+fuuF+fx1ykp5" +
       "cjGE3pmHHTe6CfLMNZcbR9c/jrny3E1w5R155nvB8zt7rvzOredK/TplzTyp" +
       "htDDgCuHTOipu5v6h8x44gxm7O6k5TcNj/mA3Cwf8vIv7/nw5VvPh+51yog8" +
       "+dBu7jrkQ64lTrBfxx28dAwUv1mgL4Dnq3ugX731QCfXKWPzhNxHItsgVG1S" +
       "crRI0tRTIKlb4dW+sQf5jVsD8oTT+mCB5keug/RynsyBQ9Ol4EiUpxza4iZA" +
       "5pNwcSPtm3uQ33yrIG+4gj4wrlO2zhMFRJ75aurUJb2ji3fCMVb1Ld3wBKZw" +
       "5jX9/MLxY1f9YWj3Jxf5C6+dv/vtr/F/VNxUP/ojyj0kdPcqsqyTNx9PvN/p" +
       "+erKKFhxz+4epFfg8/dB9VkX8kLoNpAWdrnZUUch9LazqAElSE9SAmgXTlOC" +
       "BVfxfZLuI2DOP6YLoTt3LydJfgy0Dkjy1x/3Dt3l2Rd0j24RHm5W7VYOj53U" +
       "rSI4fOhGYjqqcvIWfL5HVfzb63A/Kdr93+uy/Pprw/FH3sQ+t7uFL1tSluWt" +
       "3E1Cd+3+EFA0mu9JPX3N1g7burP//Pce+M17njvcP3tgN+BjPT8xtqfOvu/e" +
       "tb2wuKGe/bO3/9b7fvW1bxWXBv8v3E0KeYY3AAA=");
}
