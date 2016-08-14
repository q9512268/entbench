package org.apache.xml.dtm.ref.sax2dtm;
public class SAX2RTFDTM extends org.apache.xml.dtm.ref.sax2dtm.SAX2DTM {
    private static final boolean DEBUG = false;
    private int m_currentDocumentNode = NULL;
    org.apache.xml.utils.IntStack mark_size = new org.apache.xml.utils.IntStack(
      );
    org.apache.xml.utils.IntStack mark_data_size = new org.apache.xml.utils.IntStack(
      );
    org.apache.xml.utils.IntStack mark_char_size = new org.apache.xml.utils.IntStack(
      );
    org.apache.xml.utils.IntStack mark_doq_size = new org.apache.xml.utils.IntStack(
      );
    org.apache.xml.utils.IntStack mark_nsdeclset_size =
      new org.apache.xml.utils.IntStack(
      );
    org.apache.xml.utils.IntStack mark_nsdeclelem_size =
      new org.apache.xml.utils.IntStack(
      );
    int m_emptyNodeCount;
    int m_emptyNSDeclSetCount;
    int m_emptyNSDeclSetElemsCount;
    int m_emptyDataCount;
    int m_emptyCharsCount;
    int m_emptyDataQNCount;
    public SAX2RTFDTM(org.apache.xml.dtm.DTMManager mgr,
                      javax.xml.transform.Source source,
                      int dtmIdentity,
                      org.apache.xml.dtm.DTMWSFilter whiteSpaceFilter,
                      org.apache.xml.utils.XMLStringFactory xstringfactory,
                      boolean doIndexing) { super(
                                              mgr,
                                              source,
                                              dtmIdentity,
                                              whiteSpaceFilter,
                                              xstringfactory,
                                              doIndexing);
                                            m_useSourceLocationProperty =
                                              false;
                                            m_sourceSystemId =
                                              m_useSourceLocationProperty
                                                ? new org.apache.xml.utils.StringVector(
                                                )
                                                : null;
                                            m_sourceLine =
                                              m_useSourceLocationProperty
                                                ? new org.apache.xml.utils.IntVector(
                                                )
                                                : null;
                                            m_sourceColumn =
                                              m_useSourceLocationProperty
                                                ? new org.apache.xml.utils.IntVector(
                                                )
                                                : null;
                                            m_emptyNodeCount =
                                              m_size;
                                            m_emptyNSDeclSetCount =
                                              m_namespaceDeclSets ==
                                                null
                                                ? 0
                                                : m_namespaceDeclSets.
                                                size(
                                                  );
                                            m_emptyNSDeclSetElemsCount =
                                              m_namespaceDeclSetElements ==
                                                null
                                                ? 0
                                                : m_namespaceDeclSetElements.
                                                size(
                                                  );
                                            m_emptyDataCount =
                                              m_data.
                                                size(
                                                  );
                                            m_emptyCharsCount =
                                              m_chars.
                                                size(
                                                  );
                                            m_emptyDataQNCount =
                                              m_dataOrQName.
                                                size(
                                                  );
    }
    public int getDocument() { return makeNodeHandle(
                                        m_currentDocumentNode);
    }
    public int getDocumentRoot(int nodeHandle) {
        for (int id =
               makeNodeIdentity(
                 nodeHandle);
             id !=
               NULL;
             id =
               _parent(
                 id)) {
            if (_type(
                  id) ==
                  org.apache.xml.dtm.DTM.
                    DOCUMENT_NODE) {
                return makeNodeHandle(
                         id);
            }
        }
        return org.apache.xml.dtm.DTM.
                 NULL;
    }
    protected int _documentRoot(int nodeIdentifier) {
        if (nodeIdentifier ==
              NULL)
            return NULL;
        for (int parent =
               _parent(
                 nodeIdentifier);
             parent !=
               NULL;
             nodeIdentifier =
               parent,
               parent =
                 _parent(
                   nodeIdentifier))
            ;
        return nodeIdentifier;
    }
    public void startDocument() throws org.xml.sax.SAXException {
        m_endDocumentOccured =
          false;
        m_prefixMappings =
          new java.util.Vector(
            );
        m_contextIndexes =
          new org.apache.xml.utils.IntStack(
            );
        m_parents =
          new org.apache.xml.utils.IntStack(
            );
        m_currentDocumentNode =
          m_size;
        super.
          startDocument(
            );
    }
    public void endDocument() throws org.xml.sax.SAXException {
        charactersFlush(
          );
        m_nextsib.
          setElementAt(
            NULL,
            m_currentDocumentNode);
        if (m_firstch.
              elementAt(
                m_currentDocumentNode) ==
              NOTPROCESSED)
            m_firstch.
              setElementAt(
                NULL,
                m_currentDocumentNode);
        if (org.apache.xml.dtm.DTM.
              NULL !=
              m_previous)
            m_nextsib.
              setElementAt(
                org.apache.xml.dtm.DTM.
                  NULL,
                m_previous);
        m_parents =
          null;
        m_prefixMappings =
          null;
        m_contextIndexes =
          null;
        m_currentDocumentNode =
          NULL;
        m_endDocumentOccured =
          true;
    }
    public void pushRewindMark() { if (m_indexing ||
                                         m_elemIndexes !=
                                         null)
                                       throw new java.lang.NullPointerException(
                                         "Coding error; Don\'t try to mark/rewind an indexed DTM");
                                   mark_size.
                                     push(
                                       m_size);
                                   mark_nsdeclset_size.
                                     push(
                                       m_namespaceDeclSets ==
                                         null
                                         ? 0
                                         : m_namespaceDeclSets.
                                         size(
                                           ));
                                   mark_nsdeclelem_size.
                                     push(
                                       m_namespaceDeclSetElements ==
                                         null
                                         ? 0
                                         : m_namespaceDeclSetElements.
                                         size(
                                           ));
                                   mark_data_size.
                                     push(
                                       m_data.
                                         size(
                                           ));
                                   mark_char_size.
                                     push(
                                       m_chars.
                                         size(
                                           ));
                                   mark_doq_size.
                                     push(
                                       m_dataOrQName.
                                         size(
                                           ));
    }
    public boolean popRewindMark() { boolean top =
                                       mark_size.
                                       empty(
                                         );
                                     m_size =
                                       top
                                         ? m_emptyNodeCount
                                         : mark_size.
                                         pop(
                                           );
                                     m_exptype.
                                       setSize(
                                         m_size);
                                     m_firstch.
                                       setSize(
                                         m_size);
                                     m_nextsib.
                                       setSize(
                                         m_size);
                                     m_prevsib.
                                       setSize(
                                         m_size);
                                     m_parent.
                                       setSize(
                                         m_size);
                                     m_elemIndexes =
                                       null;
                                     int ds =
                                       top
                                       ? m_emptyNSDeclSetCount
                                       : mark_nsdeclset_size.
                                       pop(
                                         );
                                     if (m_namespaceDeclSets !=
                                           null) {
                                         m_namespaceDeclSets.
                                           setSize(
                                             ds);
                                     }
                                     int ds1 =
                                       top
                                       ? m_emptyNSDeclSetElemsCount
                                       : mark_nsdeclelem_size.
                                       pop(
                                         );
                                     if (m_namespaceDeclSetElements !=
                                           null) {
                                         m_namespaceDeclSetElements.
                                           setSize(
                                             ds1);
                                     }
                                     m_data.
                                       setSize(
                                         top
                                           ? m_emptyDataCount
                                           : mark_data_size.
                                           pop(
                                             ));
                                     m_chars.
                                       setLength(
                                         top
                                           ? m_emptyCharsCount
                                           : mark_char_size.
                                           pop(
                                             ));
                                     m_dataOrQName.
                                       setSize(
                                         top
                                           ? m_emptyDataQNCount
                                           : mark_doq_size.
                                           pop(
                                             ));
                                     return m_size ==
                                       0;
    }
    public boolean isTreeIncomplete() { return !m_endDocumentOccured;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1afXDcxBXfO387dvyVOMZJnMRxMnUIdxCglHGa4vgjNjk7" +
       "xnZScEousm7PVqKTFGnPPoemJAyUDO0wDAkUKGTaaRgoEwjTgbbTFpoOtIFS" +
       "ykBpy0chpfwBFNKSmYIpKaXvrXQnne6kcMDUM9qTV+/t+723b997q9WRk6TE" +
       "0EmrJigxIcRmNGqEhvB+SNANGuuSBcMYhd6oeMNrB66e/UPFviApHSNzJwVj" +
       "QBQM2itROWaMkcWSYjBBEakxSGkMOYZ0alB9SmCSqoyR+ZLRn9BkSZTYgBqj" +
       "SLBF0COkTmBMl8aTjPZbAzCyJMLRhDmacKeboCNCqkRVm7EZmrMYuhzPkDZh" +
       "yzMYqY3sEKaEcJJJcjgiGawjpZOzNVWemZBVFqIpFtohX2gZ4tLIhTlmaH2w" +
       "5v3TN03WcjM0CIqiMq6iMUwNVZ6isQipsXt7ZJowdpFvkKIImeMgZqQtkhYa" +
       "BqFhEJrW16YC9NVUSSa6VK4OS49UqokIiJFl2YNogi4krGGGOGYYoZxZunNm" +
       "0HZpRtv0dLtUvOXs8MHvbKv9URGpGSM1kjKCcEQAwUDIGBiUJsapbnTGYjQ2" +
       "RuoUmPARqkuCLO22ZrvekCYUgSXBBdJmwc6kRnUu07YVzCTopidFpuoZ9eLc" +
       "qaz/SuKyMAG6Ntq6mhr2Yj8oWCkBMD0ugO9ZLMU7JSXG/SibI6Nj20YgANay" +
       "BGWTakZUsSJAB6k3XUQWlInwCDifMgGkJSq4oM59zWNQtLUmiDuFCRplpMlN" +
       "N2Q+AqoKbghkYWS+m4yPBLPU7Jolx/ycHFx741VKnxIkAcAco6KM+OcAU4uL" +
       "aZjGqU5hHZiMVasitwqNj+wPEgLE813EJs1Pvn7qktUtx54waRbmodk0voOK" +
       "LCoeHp/77KKu9ouLEEa5phoSTn6W5nyVDVlPOlIaRJrGzIj4MJR+eGz4N1fs" +
       "vY++HSSV/aRUVOVkAvyoTlQTmiRTfQNVqC4wGusnFVSJdfHn/aQM7iOSQs3e" +
       "TfG4QVk/KZZ5V6nK/wcTxWEINFEl3EtKXE3fawKb5PcpjRBSBhepgmsdMf/4" +
       "LyM7wpNqgoYFUVAkRQ0P6SrqjxPKYw414D4GTzU1nBLAac7ZEV0TvSi6Jmzo" +
       "YljVJ8ICeMUkDacScjjGEmGdxsOGkFqD9yOdl68ZHu3tHh0Ioc9p/1dpKdS9" +
       "YToQgGlZ5A4KMqynPlWOUT0qHkyu7zn1QPQp0+FwkVhWY6QdRIZMkSEQGQIx" +
       "IRAZskSGbJEkEOCS5qFoc/Jh6nZCEIAoXNU+cuWl2/e3FoHXadPFYHckXZmT" +
       "lbrsaJEO8VHxyLPDs888XXlfkAQhoIxDVrJTQ1tWajAzm66KNAaxyStJpANl" +
       "2Dst5MVBjt02vW/L1edyHM5ojwOWQKBC9iGM0RkRbe5Vnm/cmuvffP/orXtU" +
       "e71npY901svhxDDS6p5Xt/JRcdVS4eHoI3vagqQYYhPEYybA+oFQ1+KWkRVO" +
       "OtKhGXUpB4Xjqp4QZHyUjqeVbFJXp+0e7nB1/H4eTHEFrq8GuGasBcd/8Wmj" +
       "hu0C00HRZ1xa8ND/5RHtrhd+/9b53NzpLFHjSO8jlHU4IhMOVs9jUJ3tgqM6" +
       "pUD3ym1DB245ef1W7n9AsTyfwDZsuyAiwRSCma97YteLJ149/HzQ9lkGqTk5" +
       "DlVOKqNkEHUq91ES/dzGA5FNhvWOXtO2WQGvlOKSMC5TXCT/qVlx3sPv3Fhr" +
       "+oEMPWk3Wn3mAez+s9aTvU9tm23hwwREzKy2zWwyM1w32CN36rowgzhS+55b" +
       "fPtx4S4I/BBsDWk35fGzlNuglGvexMjiPJEBwsCAoEAW1NNUzTwQcQKmC4qB" +
       "ThQaUZM6ZHNcHo4AgHXjSHLcYEO6lIAZnbKy2tHG2V2Pl+3uTmesfCwm5UZj" +
       "4Jmf9b0R5R5TjoEC+xFJtSMEdOoTDnetNWfyY/gLwPVfvHAGscPMD/VdVpJa" +
       "mslSmpYC9O0+ZWW2CuE99Sd23vnm/aYK7izuIqb7D97wcejGg6YbmKXO8pxq" +
       "w8ljljumOtisRXTL/KRwjt43ju75+b17rjdR1Wcn7h6oS+//00e/C9321yfz" +
       "5IUiySpXz8d1kYnoje7ZMVUqPe+uf1/9zRc2QQjqJ+VJRdqVpP0x55hQqxnJ" +
       "ccd02UUU73Aqh1PDSGAVzoLlZi35nfGrI72SzGxvXOEiQ02N0OUDEbMM7BUw" +
       "vM5w6ostQ+LPOsf9ekbKxlVVpoLi1h//7UtxpBfwZ+EMBeEUhD8bxabNcCaH" +
       "bP9x7BCi4k3Pv1u95d1HT/E5yN5iOGPhgKCZDlCHzQp0gAXuRNwnGJNAd8Gx" +
       "wa/VysdOw4hjMKIIK9HYpEMhkMqKnBZ1SdlLv3qscfuzRSTYSyplVYiZVoKS" +
       "DKI/NSahhkhpX7nEDH7TGAlruaokR3mMN0vyR7KehMZ47Nn90wUPrb3n0Ks8" +
       "6JoWX8jZ5xq4s3HXC3x7aqe6d17+7uu/nP1BmenRPuvTxdf04SZ5/Jq/fZBj" +
       "ZJ7Z8yxZF/9Y+MidzV3r3ub8dopF7uWp3OILihCbd819ifeCraW/DpKyMVIr" +
       "WlvBLYKcxMQ1BtsfI70/hO1i1vPsrYxZt3dkSohF7pjhEOtO7s6FWMyyFp2d" +
       "zxfgLJ4DV6eV6jrd+ZwXgKYPIaTQenOhPL1U3/vHOz/8B/e4kimEDhkFWczC" +
       "YSVv27FZzSe7CBaZpktTEGsh5Rp8f8oAsaQIsiv1NvrgAZbunvWbN+A/g2at" +
       "ge1mbOLmOJd7em40I6cSe9vh6rbkdOfoTfiNnl8bHhh2unBX+IwH28ZEVEzq" +
       "UIuxblVMJuB3EIIpPuxw6WF8cj243Da4NlhyN3josTu/HsSlQtBnKEYqEoK+" +
       "M4rVg1fFYEbffoWNMNg7u/S6qkC9cH76LTD9Hnpda+qFzZ5cVby4GZnLVYkJ" +
       "TOD6YO9eF9zrPgXcjZbAjR5wv+UL14s7DVecFHRPuN8uEO4X4BqwBA54wL3Z" +
       "F64XNyPVpnXVXZ5oDxSINgTXiCVvxAPt7b5ovbgZaeBoFQNjrEGZJ+Y7CsQc" +
       "husKS+oVHpi/54vZi5uReQ7MVKYJT9DfLxA0ZoRtlthtHqDv8QXtxc1IbSJK" +
       "sSrAwNelJhWWL/rdWyDgRXCJlkjRA/ADvoC9uHnMNgGPdIOdIXd7oj5aIOpl" +
       "cE1acic9UD/si9qLGzZobtT8lbYn9B9/Cg9JWMITHtB/4Qvdi9v2kG4IzJ6A" +
       "HykQcBNcuiVS9wD8mC9gL25G6izAXRCavU38eIGIz0IaS+a0B+Lf+iL24ob6" +
       "0mHiywY9IT/lAzlli16VEc3/SonrXaxDtKPyJ7iZWez1upzvZA9fc/BQbNPd" +
       "5wWtLVYXlB9M1c6R6RSVHUOV832xexMxwA8J7Ir8oudmi16+uakq930jjtTi" +
       "8TZxlfduwy3g+DV/bx5dN7m9gBeJS1z6u4f84cCRJzesFG8O8nMOcwOQcz6S" +
       "zdSRXfZX6pQldSV7x92ambHq9OI4bM3YYber2T7hmuzMKzIvVp/N8ms+z17H" +
       "5i+MzJmgmTKZe6ftmK+caS1l7U+x40re/UK23pg2HrLAP1S43l6sLt0crxHM" +
       "vfxJH+X/ic2bjNQ4lB9WVbcB3vrMBuDEi+E6bmlx3McAOVsfWIiarjLYmNKY" +
       "a/swx2fMM1nmtI9lPsLmX1BXQk3paZf3PrNdKtJ2OWHpcKJwx/Bi9dYuUJbf" +
       "NOk9VhPusXBzZQgpPJzpSYlUw9jCmSuwCYJpIALoGbfhvK53XMVTqhTLmCtQ" +
       "9PmYayFcs5bOs4Wby4vVx1xNnp4UqOQEzdg0QBChSswRRALVtvLzPh/lW0Bu" +
       "ozmC+VuQ8p6sPsq3+TxDMYElsFnUksbkMJ2GLDoAuwSX6ks/s+p1adWtlx2B" +
       "nJcnZ1bdi9VHvXN9nq3B5mxYBZqqZWlOBm3NV38+mkPpHohb8OOFa+7F6qPd" +
       "Wp9nuMgDF0HlLBl4MNav4Pm7TBl1Kf+lwpVPMVJpHwbjq96mnO9QzG8nxAcO" +
       "1ZQvOLT5z/xAMvN9Q1WElMeTsux8E+m4L9V0Gpe4yarM95IaV6kn/8t/xxk1" +
       "I2XWHUIPdJt8fYw05udjpAhaJ+1GKIRzaYHONeYgLKdsOqCB1klzGdjJpmGk" +
       "1LxxkowCF5Dg7WYtHdhXfoKDeDB8KpBdOaenlMw/05Q6iu3lWaUs/+ooXXYm" +
       "ze+OouLRQ5cOXnXqi3ebp7OiLOzejaPMiZAy86A4U7ou8xwtPVZpX/vpuQ9W" +
       "rEiX73UmYHt5LHSk9ythOWjoX82uo0ujLXOC+eLhtY8+vb/0uSAJbCUBgZGG" +
       "rbkvylNaEurqrZF8R1ZQ2PNT1Y7K17c/88FLgXp+HkHMQ64WP46oeODRl4fi" +
       "mnZHkFT0kxKILjTF3+J3zyjDVJzSs07ASsdhT5X5QGkuLgYBj6K4ZSyDVmd6" +
       "8XSfkdbcw8DcLx4qZXWa6utxdBym2lXsJzXN+ZRblr8nX5tCS4MHRiMDmpY+" +
       "Bb2WW17TcK0H+Dc1ff8DMpkBcFooAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zk1nXe/CtptStL2l3JelixZMleuZbG/jlvDqvYCTkP" +
       "PoaPmSGHM0OnXnNIzvD95pAzqRLHQGKjaV2jkVO3cQQkUNAkcGKjcJoAgQO1" +
       "ReMESQskSJ9AI6MNUDepWxto7SJOm15y/vfuv6uNhA7AO3fIc+/9vnPPPeeQ" +
       "vPPFb5bui8JS2ffszcr24n0ti/dNu7kfb3wt2qfo5lAOI03t2HIUCeDcDeW9" +
       "X77yne99Vr96oXRRKj0qu64Xy7HhudFYizx7ral06crx2Z6tOVFcukqb8lqG" +
       "ktiwIdqI4pfo0jtONI1L1+lDCBCAAAEIUAEBQo+lQKOHNDdxOnkL2Y2joPQj" +
       "pT26dNFXcnhx6bnTnfhyKDsH3QwLBqCHS/lvEZAqGmdh6dkj7jvONxH+XBl6" +
       "5e9/7Oo/vqd0RSpdMVw+h6MAEDEYRCo96GjOQgsjVFU1VSpdczVN5bXQkG1j" +
       "W+CWSo9ExsqV4yTUjpSUn0x8LSzGPNbcg0rOLUyU2AuP6C0NzVYPf923tOUV" +
       "4Pr4Mdcdw35+HhB8wADAwqWsaIdN7rUMV41L7znb4ojj9QEQAE3vd7RY946G" +
       "uteVwYnSI7u5s2V3BfFxaLgrIHqfl4BR4tJT53aa69qXFUteaTfi0pNn5Ya7" +
       "S0DqcqGIvElceuysWNETmKWnzszSifn5Jvv9n/lhl3AvFJhVTbFz/JdAo2fO" +
       "NBprSy3UXEXbNXzwRfqn5ce/+ukLpRIQfuyM8E7m1//mt3/wg8+8/js7me+7" +
       "hQy3MDUlvqG8tnj4D97deQG5J4dxyfciI5/8U8wL8x8eXHkp88HKe/yox/zi" +
       "/uHF18e/Pf/EL2t/dqH0AFm6qHh24gA7uqZ4jm/YWohrrhbKsaaSpcuaq3aK" +
       "62TpflCnDVfbneWWy0iLydK9dnHqolf8Bipagi5yFd0P6oa79A7rvhzrRT3z" +
       "S6XS/eAoPQiOj5R2n+I7LpmQ7jkaJCuya7geNAy9nH8+oa4qQ7EWgboKrvoe" +
       "lMnAaD5k3qjdgG/UoChUIC9cQTKwCl2DMseG1NiBQm0JRXJWy+s8OquNhX5X" +
       "YPZzm/P/v46W5dyvpnt7YFrefdYp2GA9EZ6tauEN5ZUE6337V2/83oWjRXKg" +
       "tbj0AhhyfzfkPhhyHwyzD4bcPxhy/3jI0t5eMdI786F3kw+mzgJOALjHB1/g" +
       "/wb18U+/9x5gdX56L9B7Lgqd76U7x26DLJyjAmy39Prn0x8Tf7RyoXThtLvN" +
       "4YJTD+TNh7mTPHKG188us1v1e+VT3/jOl376Ze94wZ3y3wd+4OaW+Tp+71nF" +
       "hp6iqcAzHnf/4rPyr9346svXL5TuBc4BOMRYBgYMfM0zZ8c4tZ5fOvSNOZf7" +
       "AOGlFzqynV86dGgPxHropcdnihl/uKhfAzq+nBv4o+DYHFh88Z1ffdTPy3fu" +
       "LCSftDMsCt/7Yd7/2X/3r/5rvVD3oZu+ciLw8Vr80gnXkHd2pXAC145tQAg1" +
       "Dcj9x88Pf+pz3/zURwsDABLvu9WA1/OyA1wCmEKg5h//neDfv/HHr/3RhWOj" +
       "iUFsTBa2oWRHJC/knC7dhiQY7f3HeIBrscGCy63m+sR1PNVYGvLC1nIr/Ysr" +
       "z1d/7b995urODmxw5tCMPnjnDo7PvwsrfeL3PvbdZ4pu9pQ8tB3r7Fhs5y8f" +
       "Pe4ZDUN5k+PIfuwPn/4HX5N/Fnhe4O0iY6sVDuxioYOLBfPH4tLTt1iaYB0y" +
       "sgvCUHgo9VThCQqBOJTdKDeifd5LQhBOw9ILt8mTQsMB07o+iC3Qy4+8YX3h" +
       "G7+yixtnA9EZYe3Tr/ytv9z/zCsXTkTr990UME+22UXswh4f2k3tX4LPHjj+" +
       "b37kU5qf2HnsRzoHYePZo7jh+xmg89ztYBVD9P/Ll17+zV98+VM7Go+cDlY9" +
       "kIv9yr/5P7+///mv/+4tfOE9xkGKBtT6zK2VP+X7hh0fa//5M2L5MNH+jKF3" +
       "eUdfzt3JppBu5EV7Z9d/PS7dv/A8W5PdQiVQcfbFotzPdVBYQqm41s+L90Qn" +
       "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" +
       "fET/+F1sWnrPGZxnu/wl5ou/i79f+XsX");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Svccvf69aTPk6UYvnX7p+0CoxUnoCqde/T59pNmHDp8wv3ag2dfOPsc9nrtb" +
       "vyT9wG7ub7Nv4Ru3ufanefGf49I7VtrRu9Xi+e+xtfzJnZ4znuyzOPH10/Ty" +
       "VyNfOaD3lbeH3t6xAFwI/M/bcPxOXvyPuHTlBMex553l+a23wLMQexocXzvg" +
       "+bW74QnM3w+9WFNiTX1TdPf2zqe7V/iG78Wlh26o55P9i7dA9vIh2TcOyL7x" +
       "ttvs3kO31sDhm4An8xfs+Zv1SM7ynZG9TNH8fK0Xja/kxSWgAbAiw6Mpv+Vz" +
       "9bVnqEda2bv8VrXyfeD47oFWvvv2a+WZc+1i72oh8GxevAssZ81VTyznvUeP" +
       "OT71Vjk+A0Z8fNd29/32cnzxNtc+mBfPx6WH/STSx1oKYgkjh9YZhu9/Cwyv" +
       "HTI82Leyd9O+lbfOsHWba+28qALT9T3/FMESdkyw9lYJPgewLg8ILt9+gtht" +
       "rnXz4sNx6aoR5RtWSTffmG5rsXaG40fuhmMWlx443h+db/Z88qa/Zuz+TqD8" +
       "6qtXLj3x6uTfFluEj7b8X6ZLl5aJbZ/crXWiftEPtaVR8L6827vlF2QGt96e" +
       "eGLbdly6/6CWg96jdu3YuPT4rdvFpXtAeVJ2FJceuVkWyJ3pUwDL4rQckAHl" +
       "SZkp0NOxTFy6uKucFJFAKyCSVz/qH7rb97+JvelA8dne6TzwcDJLj9xpMk+k" +
       "ju87lfAVf8Q5TM6S3V9xbihfepVif/jbrV/Y7ZdWbHm7zXu5RJfu323dPkrw" +
       "nju3t8O+LhIvfO/hL19+/jAZfXgH+HgVnMD2nltvTu7lL9Dz7cTb33jiK9//" +
       "j1794+Lt8P8DWATWFCE1AAA=");
}
