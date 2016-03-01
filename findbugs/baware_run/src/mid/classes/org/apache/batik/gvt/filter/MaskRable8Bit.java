package org.apache.batik.gvt.filter;
public class MaskRable8Bit extends org.apache.batik.ext.awt.image.renderable.AbstractRable implements org.apache.batik.gvt.filter.Mask {
    protected org.apache.batik.gvt.GraphicsNode mask;
    protected java.awt.geom.Rectangle2D filterRegion;
    public MaskRable8Bit(org.apache.batik.ext.awt.image.renderable.Filter src,
                         org.apache.batik.gvt.GraphicsNode mask,
                         java.awt.geom.Rectangle2D filterRegion) { super(
                                                                     src,
                                                                     null);
                                                                   setMaskNode(
                                                                     mask);
                                                                   setFilterRegion(
                                                                     filterRegion);
    }
    public void setSource(org.apache.batik.ext.awt.image.renderable.Filter src) {
        init(
          src,
          null);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getSource() {
        return (org.apache.batik.ext.awt.image.renderable.Filter)
                 getSources(
                   ).
                 get(
                   0);
    }
    public java.awt.geom.Rectangle2D getFilterRegion() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public void setFilterRegion(java.awt.geom.Rectangle2D filterRegion) {
        if (filterRegion ==
              null) {
            throw new java.lang.IllegalArgumentException(
              );
        }
        this.
          filterRegion =
          filterRegion;
    }
    public void setMaskNode(org.apache.batik.gvt.GraphicsNode mask) {
        touch(
          );
        this.
          mask =
          mask;
    }
    public org.apache.batik.gvt.GraphicsNode getMaskNode() {
        return mask;
    }
    public java.awt.geom.Rectangle2D getBounds2D() {
        return (java.awt.geom.Rectangle2D)
                 filterRegion.
                 clone(
                   );
    }
    public java.awt.image.RenderedImage createRendering(java.awt.image.renderable.RenderContext rc) {
        org.apache.batik.ext.awt.image.renderable.Filter maskSrc =
          getMaskNode(
            ).
          getGraphicsNodeRable(
            true);
        org.apache.batik.ext.awt.image.renderable.PadRable maskPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          maskSrc,
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        maskSrc =
          new org.apache.batik.ext.awt.image.renderable.FilterAsAlphaRable(
            maskPad);
        java.awt.image.RenderedImage ri =
          maskSrc.
          createRendering(
            rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed maskCr =
          org.apache.batik.ext.awt.image.rendered.RenderedImageCachableRed.
          wrap(
            ri);
        org.apache.batik.ext.awt.image.renderable.PadRable maskedPad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          getSource(
            ),
          getBounds2D(
            ),
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        ri =
          maskedPad.
            createRendering(
              rc);
        if (ri ==
              null)
            return null;
        org.apache.batik.ext.awt.image.rendered.CachableRed cr;
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            wrap(
              ri);
        cr =
          org.apache.batik.ext.awt.image.GraphicsUtil.
            convertToLsRGB(
              cr);
        org.apache.batik.ext.awt.image.rendered.CachableRed ret =
          new org.apache.batik.ext.awt.image.rendered.MultiplyAlphaRed(
          cr,
          maskCr);
        return ret;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZfWwUxxWfO38bGxvzZb7BGFLzcRdIqItMUsBgMD2DZROq" +
       "mjZmvTd3Xry3u+zO2QeB8iEloKhFaSApaQP9o6A2lARaFaVSCyWK2oBSGkGj" +
       "lg/lo0Vq0iZI4Y+GpLRN35vZvd3b+6AWUU/aubmd99689+a937yZO3GTlFgm" +
       "aTAkLSqF2FaDWqFO7HdKpkWjrapkWevhba/85J8P7Lz9h4rdQVLaQ0b2S1aH" +
       "LFm0TaFq1OohUxTNYpImU2stpVHk6DSpRc1BiSm61kPGKlZ7wlAVWWEdepQi" +
       "wQbJjJBREmOm0pdktN0WwMi0CNcmzLUJL/MTtERIlawbW12GiRkMrZ4xpE24" +
       "81mM1EY2S4NSOMkUNRxRLNaSMslcQ1e3xlWdhWiKhTari2xHrIksynJDw6ma" +
       "j+881V/L3TBa0jSdcROtLmrp6iCNRkiN+3alShPWFvJNUhQhIzzEjDRGnEnD" +
       "MGkYJnXsdalA+2qqJROtOjeHOZJKDRkVYmRGphBDMqWELaaT6wwSypltO2cG" +
       "a6enrXWW22fiM3PDB7/7aO3PikhND6lRtG5URwYlGEzSAw6liT5qWsuiURrt" +
       "IaM0WPBuaiqSqmyzV7vOUuKaxJIQAo5b8GXSoCaf0/UVrCTYZiZlpptp82I8" +
       "qOxfJTFVioOt41xbhYVt+B4MrFRAMTMmQezZLMUDihblcZTJkbax8StAAKxl" +
       "Ccr69fRUxZoEL0idCBFV0uLhbgg+LQ6kJTqEoMljLY9Q9LUhyQNSnPYyUu+n" +
       "6xRDQFXBHYEsjIz1k3FJsEoTfavkWZ+ba5fsf0xbrQVJAHSOUllF/UcA01Qf" +
       "UxeNUZNCHgjGqjmRZ6VxZ/YFCQHisT5iQfPy9ltL5009d17QTMpBs65vM5VZ" +
       "r3y0b+Slya1Ni4tQjXJDtxRc/AzLeZZ12iMtKQOQZlxaIg6GnMFzXb/92q7j" +
       "9IMgqWwnpbKuJhMQR6NkPWEoKjVXUY2aEqPRdlJBtWgrH28nZdCPKBoVb9fF" +
       "YhZl7aRY5a9Kdf4bXBQDEeiiSugrWkx3+obE+nk/ZRBCyuAho+GZT8RnLjaM" +
       "bA736wkalmRJUzQ93GnqaD8uKMccakE/CqOGHu6D+B+YvyDUHLb0pAkBGdbN" +
       "eFiCqOinYjAcH2Rh0AdiKdwhWQNdUp9Kv7RcAdiBmDP+r7Ol0PbRQ4EALMtk" +
       "PyiokE+rdTVKzV75YHL5ylsv9b4uAg6TxPYaI00wZUhMGeJThmDKkJgylDEl" +
       "CQT4TGNwarH4sHQDAAKAwlVN3d9Ys2lfQxFEnTFUDH5H0tlZu1KrixYOxPfK" +
       "Jy513X7jYuXxIAkCoPTBruRuDY0ZW4PY2UxdplHApnybhAOU4fzbQk49yLlD" +
       "Q7s37Lyf6+FFexRYAkCF7J2I0ekpGv1Znktuzd73Pz757A7dzfeM7cPZ9bI4" +
       "EUYa/OvqN75XnjNdOt17ZkdjkBQDNgEeMwnyB6Buqn+ODDhpcaAZbSkHg2O6" +
       "mZBUHHLwtJL1m/qQ+4YH3CjeHwNLPALzqx6exXbC8W8cHWdgO14EKMaMzwoO" +
       "/Q91G4ev/P5vD3B3O7tEjWd776asxYNMKKyOY9AoNwTXm5QC3VuHOg88c3Pv" +
       "Rh5/QDEz14SN2LYCIsESgpsfP7/l6jtvH30z6MYsg6052QdVTiptJL4nlQWM" +
       "xDh39QFkUyHfMWoaH9EgKpWYghmESfKvmlkLTn+4v1bEgQpvnDCad3cB7vsJ" +
       "y8mu1x+9PZWLCci4s7o+c8kEXI92JS8zTWkr6pHafXnKc69JhwH4AWwtZRvl" +
       "+FnEfVDELa9n5P4sZMAskoZYSEnAPhiCQAJwQdVCbRwuHMYZOSFllSkZ/Yps" +
       "rYVEdSgncOVQZJzqCdjtZAjpuEoXruCR8yCnC/P2AfQ6V5DwsSXYNFreDMxM" +
       "ck8Z1is/9eZH1Rs+OnuLuyyzjvMGXIdktIgYx2ZWCsSP96PdasnqB7oHz639" +
       "eq167g5I7AGJMqC3tc4Eh6QywtOmLim79sqr4zZdKiLBNlKp6lK0TeKZTiog" +
       "xajVD0CdMr68VETYUDk0tdxUkmU8Luq03OGyMmEwvsDbfjH+50t+dORtHtki" +
       "lCdx9qCF5aMflPkZwMWTD69//8avb/+wTFQQTflB1MdX/891at+ev3yS5WQO" +
       "nzmqGx9/T/jE8xNbH/6A87s4htwzU9k7HCC9y7vweOIfwYbS3wRJWQ+ple16" +
       "e4OkJhEdeqDGtJwiHGryjPHMelEURy1pnJ7sx1DPtH4EdXdW6CM19qt9oDkS" +
       "V3E6PAttPFnoB80A4Z0OzjKbt03YzHMwqsIwdQZa0qgPpqoLiGWkOAHbOfab" +
       "BSxj+xA2a4WYpXnjb1Wm9vfB02xP05xH+w1Ce2w6s5XMx81IlSg9umjcRvzF" +
       "PmW/WkDZlDvpnPSk/FPqlIPOtxfA3fwIOMg0/W5lEWLDlHwlPj+eHN1z8Eh0" +
       "3bEFIo3qMsvmlXAqfPGP//5d6NC7F3JUZRVMN+ardJCqHuXKYcoZWcnbwU9A" +
       "biY0X75ddP3p+qrsYgolTc1TKs3Jn+X+CV7b8/eJ6x/u3zSMKmmaz1F+kS90" +
       "nLiwarb8dJAf4kTiZR3+MplaMtOt0qRwWtXWZyRdQ2alMgueFXYMrMhdqeQI" +
       "n/T+n4/Vt0kFRCDhz0VcqlFgF+PgNgDrDeecbnEGKIi4naaSgFpo0D4PhnfU" +
       "vTPw/PsvihDzw6uPmO47+ORnof0HRbiJE/bMrEOul0ecsrmitcIfn8EnAM9/" +
       "8EEr8AV+A4i22ke96emznmGkeMgWUItP0fbeyR2//PGOvUHbK1DSFA/qStRN" +
       "evVuCJWxQ+KLlfx1PL2MdTg0CZ6IvYyR4UdAPtYCC/x4gbG92OyCxY87i8+D" +
       "xrV69z1bPR6HZsPTbavePXyr87EWsOw7BcYOYPMtqLvA6jY/1ru2f/uebec5" +
       "j8V6j21Az/Btz8eaP+cXc6mHCzjgB9gcAgdY2Q4Ych3w3OfjgBA8A7YVA8N3" +
       "QD7W/A5o5lJfKOCAn2BzlJER4ADcSvFE4DP+2D0bj8dSMhOepG1BcvjG52Mt" +
       "YNvpAmMvY3MK7I5n2t3s2v3TzyfjG+DZbiu/ffh252MtYNsrBcZexeZXwu7l" +
       "elKLWgtX+LL9zD3bPQGHvgDPLlv5XcO3Ox9r7mB3SsX70ofYrHNxF+/aF+9c" +
       "gYsF/HQJm/MADLJJYfsUzIoWdyaa7JtIENBoO/5yfXlh+L5MMVKdcdeHh8z6" +
       "rL8ZxNW4/NKRmvLxRx75E79vSl9fV0VIeSypqt4zkKdfapg0pnA7q8SJyOBf" +
       "1xiZVKDWZvhnQvpy4argeYuRMbl4GCmC1kv5LiO1fkpGSvi3l+4GI5UuHUwq" +
       "Ol6Sv4J0IMHue4azJM3/+x3Jsj6LmXDo5z5OBTx1vX1s4Ys39m6Ll2bx3nHh" +
       "pPy/I6e+Top/j3rlk0fWrH3s1hePiTs2WZW2bUMpIyKkTFz3pWv0GXmlObJK" +
       "VzfdGXmqYpZTpo0SCrt5NckTzCshQwwMo4m+CyirMX0PdfXokrMX95Vehop0" +
       "IwlIjIzemH0STxlJOEBsjHgPPp5/IPndWEvljU1vfHItUMcvPIi4fJ5aiKNX" +
       "PnD2emfMML4XJBXtpASqUJri1wQrtmpdVB4020l5UlO2JGl7FKK3j+MW91WE" +
       "jMSYlzA1uWdsh1an3+IdLSMN2bV19r11paoPUZOjIoqp9p1qkobhHU3h3y85" +
       "rIK1WXD4051PXFkHOZmhuFdamZXsSx+QvP9iCdnY1mKTSuEqQrj3RjoMw67w" +
       "S6/wVTUMjhh3uNGfCmqkYCQwxzD+C9XhbL2NHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1aCezryFn3e2/P1+2+t9tjt9t2u7t9Pbahf19JnGg56sRO" +
       "nMSOHTuJYxfY+kwcn7EdxwldKJVoq4JKBdtSBKxAasWhLeUUIFRYBAWqIkQR" +
       "t4ACAnEWsRKXKNfY+d/vWKpdEcmT8cz3zXy/me/75vPMPPtF6PYkhipR6G3n" +
       "XpgeWHl6sPRqB+k2spKDPlsTtDixzLanJckYlD1pPPZjV/71Sx9eXL0I3aFC" +
       "r9CCIEy11AmDRLSS0Mssk4WunJTSnuUnKXSVXWqZBq9Tx4NZJ0mfYKGXnWJN" +
       "oWvskQgwEAEGIsClCDB5QgWYXm4Fa79dcGhBmqygb4QusNAdkVGIl0KPnm0k" +
       "0mLNP2xGKBGAFu4q3qcAVMmcx9Ajx9j3mK8D/JEK/PR3ff3Vn7gEXVGhK04g" +
       "FeIYQIgUdKJC9/iWr1txQpqmZarQfYFlmZIVO5rn7Eq5Vej+xJkHWrqOreNB" +
       "KgrXkRWXfZ6M3D1GgS1eG2kYH8OzHcszj95utz1tDrC++gTrHmGnKAcALztA" +
       "sNjWDOuI5TbXCcwUesN5jmOM1waAALDe6VvpIjzu6rZAAwXQ/fu587RgDktp" +
       "7ARzQHp7uAa9pNBDN220GOtIM1xtbj2ZQg+epxP2VYDq7nIgCpYUetV5srIl" +
       "MEsPnZulU/PzxeFXfugbAia4WMpsWoZXyH8XYHr4HJNo2VZsBYa1Z7znbexH" +
       "tVd/+gMXIQgQv+oc8Z7mZ979/Du+4uHnfn1P89ob0PD60jLSJ42P6/d+/nXt" +
       "x5uXCjHuisLEKSb/DPJS/YXDmifyCFjeq49bLCoPjiqfE39Vec+PWH9/Ebrc" +
       "g+4wQm/tAz26zwj9yPGsuGsFVqylltmD7rYCs13W96A7QZ51Amtfytt2YqU9" +
       "6DavLLojLN/BENmgiWKI7gR5J7DDo3ykpYsyn0cQBN0JHugV4Hk7tP9ViiSF" +
       "lvAi9C1YM7TACUJYiMMCfzGhganBqZWAvAlqoxDWgf67b0cPCDgJ1zFQSDiM" +
       "57AGtGJh7SvheZbCQB6gSzCnJa6o6Z7VaDnACQGdi/5fe8sL7Fc3Fy6AaXnd" +
       "eafgAXtiQs+04ieNp9ct+vkfffJzF4+N5HDUUuhx0OXBvsuDsssD0OXBvsuD" +
       "M11CFy6UPb2y6Ho/+WDqXOAEgHu853Hp6/rv+sBjl4DWRZvbwLgXpPDNvXT7" +
       "xG30SudoAN2FnvvY5pun34RchC6edbeFuKDocsEuFE7y2BleO29mN2r3yvv/" +
       "5l8/9dGnwhODO+O/D/3A9ZyFHT92fmDj0LBM4BlPmn/bI9pPP/npp65dhG4D" +
       "zgE4xFQDCgx8zcPn+zhjz08c+cYCy+0AsB3GvuYVVUcO7XK6iMPNSUk54/eW" +
       "+fvAGL+sUPAHwdM81Pjyv6h9RVSkr9xrSDFp51CUvverpOj7/uA3/xYvh/vI" +
       "TV85tfBJVvrEKddQNHaldAL3nejAOLYsQPcnHxO+8yNffP87SwUAFG+8UYfX" +
       "irQNXAKYQjDM3/Lrqz/8wp9+/HcunihNCtbGte45Rn4MsiiHLt8CJOjtzSfy" +
       "ANfiAYMrtObaJPBD07GdQoULLf3PK29Cf/ofPnR1rwceKDlSo6944QZOyl/T" +
       "gt7zua//t4fLZi4YxdJ2MmYnZHt/+YqTlsk41raFHPk3//brv/vXtO8Dnhd4" +
       "u8TZWaUDu1SOwaUS+atSCLnONAsr0jbpgeODhegAKBKw7kK0g05pr0eMj97Q" +
       "pruxFi0cIxmGpnVE+ZpSuKLJuRX6YLkxgErPPQujSs2BS7q3lelBMeqlgFBZ" +
       "RxTJG5LTFnjWyE/FQU8aH/6df3r59J9+4flyyM4GUqcVjtOiJ/Y6XiSP5KD5" +
       "B867G0ZLFoCu+tzwa696z30JtKiCFg3gPhM+BgOSn1HPQ+rb7/yjX/rlV7/r" +
       "85egix3oshdqZkcrLR26G5iYlSyAp8yjr3nHXsM2d4HkagkVug78XjMfLN+K" +
       "UPTxmzu5ThEHnfiJB/+D9/T3/sW/XzcIpXu7wfJ/jl+Fn/3eh9pf/fcl/4mf" +
       "Kbgfzq9fAkDMeMKL/Yj/Lxcfu+MzF6E7VeiqcRiQTjVvXVivCoKw5ChKBUHr" +
       "mfqzAdU+enji2I++7ryPO9XteQ93svSAfEFd5C+fc2r3FqP8CHiwQ3vHzju1" +
       "C1CZoUuWR8v0WpG85ciH3B3FYQqktMxDN/I/4HcBPP9dPEVzRcE+Ori/fRii" +
       "PHIco0RgXbzNB2tfwYvtXWiRNoqks2/yiZvqyjvOInkLeIhDJMRNkPA3QVJk" +
       "e+Xw9FPonv2iLFrzQ1dcPSeZ8IKSlS3lF8AI3Y4dEAdI8T69cd+XiuxbgTtO" +
       "yo8HwGE7geYdCfPA0jOuHY3cFLgeINO1pUccOZarpQUWCnOwj8DPydr/P8sK" +
       "LOzek8bYEATz3/qXH/6Nb3/jF4AZ9KHbs0JFgfaf6nG4Lr5v3vfsR17/sqf/" +
       "7FvL1QUMpvBR+mrZqnYrxEWiFsk7j6A+VECVygCN1ZKUKxcEyyzR3tL6hdjx" +
       "wbqZHQbv8FP3f8H93r/55D4wP2/q54itDzz9wf85+NDTF099Dr3xui+S0zz7" +
       "T6JS6JcfjnAMPXqrXkqOzl9/6qmf/6Gn3r+X6v6zwT0Nvl0/+Xv/9RsHH/uz" +
       "z94gdrzNC1/ExKb3/gNTTXrk0Y9FVVveTPJctnm8oXfzbKfqRKvbYXeGaPZW" +
       "vZSbJK05R2GUKvIrf6n62djEZ/EWX1d2PDayWg2H9sLBoqNJZKSNhGZYJzGP" +
       "FLWONpXaW3mAhS2p63aX3hz2QmS6Qhy1V1Uq3YgVh3gtUzMT1yt1Up5MYG2t" +
       "+2azWW80K1oTJ7Yqj3fHXmfua2PSZaVVB+tolLzq8ARjDiJXXoLV1ZWtbKFr" +
       "cKPWbwgEu2suqrE5mrLaCNExCdUYtuMjY62zQvlwMcnHQyXq+RMsSaMp49Yp" +
       "KRINtOVIfh11he7AU4mNR05lmTataORsRnp/2W+JtM/7SGS66RCRN5yDtIeG" +
       "v2MnfRbmxikt9jxto8so1nVEl4vVah7RWLWB+hxKK5hUHUo8506GYi6yQ03i" +
       "Es8YoRaee7K5kJ3BYqzFDpYzcc9NtkGf2tR9bVlpNNApzOLjloYsJdMQ+ZT1" +
       "46jutIei6wwruOZJC0HuZP3hZDFa9HY7ekmJ3YAOKK7rKv1glpiaR1aw1aoP" +
       "ePmlxfBqf0CJ7lTxxW60aFHcSqZZTRvXNxtpG3kpjxldrW4F8UyWMcx2OFyg" +
       "WgRMaDwuOO5iSNU9Me3WJuJG8br0TiI3dc8Z11ZysnYmYpz2NA6RhdZac1bS" +
       "yt/upkTGT9YDLe/3RmRY0xvdmRS2NRuBJ9O4PVZUR/WA048aWK+x4nO7P+5M" +
       "nZBPq2iuL5RpWmlVubgjktyY80fWTmW5CeUsdM9Qx31X1/KGlJLkIPfaRlxv" +
       "2uIkV0OaRRyz3epMkTW70OfzCjuqu/3xig45b8kqzVGTnSy2o6EUCMp2sq4E" +
       "9VykRp1Zi1HoZNnboS7e6Sd0OLa1zJXViq7V7MRGcj0eTfskI/ETz+vAE4NE" +
       "0JE9ya3hRB22mfmyu1r6olqf5iqsdNojxknGNWdkC9uml7I1BGmaKDEac1Er" +
       "qdcyrjZVY3yL6BXJ22ro0Kmmo+WsT6W5aMDkjrVUFcUcLh2M+JHq5VpvXu8G" +
       "XGc30+EmtiKWzR43X8mbINIH6/6CG4n1oSvIdDhYTmcTBdPolSCaXr+VyvOY" +
       "wRqBaraFQSuc6k27oyxUj9BEpaY1B6Zd1WetEUVbjiOt57Hs5ngl1OlK4MKq" +
       "2Gpv1+QirHTVcUMMQCjC6SSB1zeu5vlif7IbNfFusNKoxnrAGYbm0nB7xXeZ" +
       "dZ2qtCpKtqUmDKsjEem2uqY+tDoOqHYCZUkaDCYuENJ0BuZmIY+G5iRqDjJC" +
       "NEBRy6eESkzwHiLo4qhKkyyXusLWCV26Epvj6QAoVU1h2NrWS7KmXl2T8/o4" +
       "FxSthyAbdbLgulZ/vPCpgdufbz2K9tqjcXXcHW60GHg9ZkQBhSE33nSIm00l" +
       "wTx7lHfoYNyZUEyNQVJPXaOD2MkVPhfsQX9bQ/EZsVTWs7xHuu1QGLfitbim" +
       "FESVq4KCTXIz8hgyCrb6guQnVXunj9xqc8t61IhIcILd2vVKp2PlogLYO0Qf" +
       "6yGWG3UzVA3cdL0zCVzYETWCJMydbXGEIahNvVelJ4oG89lqSNRmwXJo8ilK" +
       "qK65dMFcDee0xW2CbaveWq+CCk9Ri8jQSFWXXGaO8XVfbU0Yht2kfRb14dWo" +
       "UlUYvA2MfzNkBZLdrfK6lc/0dkNuGIxsznm0Sg84jdttQh4eNdFu1cpgoZZR" +
       "eAvniZReyiZB1LUkV4bcYLDllSYZDjfjmV8btfHpmuHnjYaBC5m4qMFAk3Zo" +
       "VRpirNLuJbQ0jxJbIGCvvkwzBkd2dU5J5nWkho3M6diJgIjVwBvJXE4t8Oao" +
       "4062jM3JocY06fkgkpX5wqcle5D5nsuOg0o1Q3V6PoqygGprJm60iCzpbxv+" +
       "Gs0rTUGV2bbhVBMirBgNl571mlhfauzGshvXI0azZ8HAqDf7iw1TJeVNqoqZ" +
       "V+kEtD2lgA9sBjWhmqgcmbihqkh0QAoLpz0i+xsgalsXN2uGU1Re6nie5AIT" +
       "B1+YypQ2pXlg8NOR2t+t2uYyVclltKbDWbxui41tO2jDAkbao/q0Rm0SaaYM" +
       "O7FFcTlnuA0VdRK4aakMKiYVPliz6+12t8y47qwH1pjeXMkxVW4nktCsC6aW" +
       "BKsWETK7Ot60VmidmNd6BNntc6s2nhpVelEfbTcp77OOTzSTVVzdqebAYVtD" +
       "bxDVvQEytgbq2AnnubacUkjb5OJ6Y0qPlQnlIqmZT1x/0mDXKwTnu1vOpzdZ" +
       "Qun2kqnUkLRi8mLKpK7jtc28uWp3ahpne4Krbjh5TNWbMNzQMh2ubMad0Whs" +
       "ey2UM2dwo4lqacXK8K1Uk0d8sPNX3bwJj+El3ciHOgPXyQaRVBfpZjdpugTT" +
       "bje3RLax+J69UXQJ34h9eVSJPAutW1Xe7S/AWryiuml/4zDdeLsUGM7y6Im4" +
       "RaOgTyQ5SgkpU6XNmSnX2xzaXKXNkHKlKU7XBTJNhU4QthoIWVURfrcc6CmC" +
       "KzuG26yS3sYcqRqymgvRKmSdruzyJKPztqa3pHxZyUlMq8pKBKxQR2W/mdkt" +
       "BMsFpJYzlQ3atrBNPanNuLyB9jxp3lz7S0PMdh3Bl2HZpVSPyqJAkFy4I6y8" +
       "nsCnuU3i9qbHc3MElmseLbOUx2w8YVmxmCG6a9ALBNfpTi/EV1wC1H5Grmyh" +
       "K8BwzawP20QH709UccoNK1ps9tsrZj0bKEaoykagbyZNUncUZEbUTFPAo8oq" +
       "TpR56I0NdDxI8H5QmVXaU0JvwFa/nsNrfCdxA9/Xdmin4kpNJGAd4CP1htkn" +
       "7ao7dlQRr3CRp3EpnyIrcSOnM1ndiuYI0zxuvrY6M4WLuYW5ska9AB5Xgio8" +
       "TRG3I7apxQ6ZGisQtHUqwnw4p2LKsgw9oLuDnlMNNE2ad6IQoarCIrAn2VjY" +
       "wEKSOQtqt6mvBZ+vEhVeDEIbYUTd6dOwzsU0v/YQy0hiEEUbPTtoAAPlmnCD" +
       "puMGOa2QVQfDXKtZt/xd4Hddi5vLk14qILZubUUMhoUun00YfYBSUoeEV1Iq" +
       "Dq1sum735XxUGbCenaMCi3HmeI601XovU7ZidWKSQqq023BenevdJsZv27nS" +
       "IJxGhcrjab25Q3VBrDNqIox1LbOE2TZuELSc8BuiZSi8InDpis3I+lKB0XiN" +
       "2fDa0i2jtmxM60sMJXdwK901LE2oGDOj7jPt3XLeas4Ncm4q2KiqGAt8g/M2" +
       "KCQbJKFMycYQH1GEDJO1sOb17QHfJgOstfP6tFglKUPKOnQVrJ0YhejLhilx" +
       "C96KumjLyJbdGsalyjCLSJ/LFJwbEL1agKV4gmX4eLe1l90KperOGrbtBban" +
       "TeKWoVq5pc42a8KzvAErz9NZhWWbOwrXhVGXyeaUwHpZbWbwOJ83Y8Jv4VIy" +
       "I5DQVmJmmHcqsNapNI25knRgZtT3YY6k2H5fsZPJrhfK5lbTiH7ao4ctsPDU" +
       "tvbMW1TYGsdNB6ZhWsyisavHbEPNh3IVHg5EP2NzMSdqNNHMJK9pT5FpzwJR" +
       "6yqt7lwQyWjRHIkCklg1pP6Wb9lo7qjTASWr2SIYZdG2qsVzS1mLnO5Vu22/" +
       "jbpZjXV41AbLsZQ5uFepdnu1yZqZbFa8V5eyah/pcczaqmq7PofDlRzvJ8s6" +
       "68+osLar8a1xjmYzNKkqCd7066yH6TkeMItI2MK9ulUZhxG8xGPPRWw5ZvAE" +
       "XViCM04wWZUxfcJFve3AHXd2eCRnSHfme7zeH0x3tgnyKyVSx8BCpHac1oaG" +
       "O961k8Vos+HCql9pb52YmyGCac9CF+Satam1CCOkt/F6IH61fAaRxrnX5+lW" +
       "smTmghDV4J4QmDKdecsJmtlML51wRiYAW7T7Nc0ZDGdCQGGWb3McW531W7M0" +
       "IqXVpB876GYUp35kTltVBEO82sTjsX7XIzqDAb6scHITleklJynejkTXspks" +
       "UC3AKz2Tlbghpk/RZoyikRYKE5Vf9sJV1IzQlRvqC2aCL/Btoxb3Bqg8o6pI" +
       "DRVmHRd8n/iLdcfUfHWWSHlllAlNp20GCuoPxtKaXo3iJS4uQ25TJzZSHd5M" +
       "xxNuuVjg62HXbvsrV2mPNvmOqrSbs4XOYkNmTpLFZ2/85e083FdushyfeS69" +
       "cs/1676ML+591aNF8qbjbanyd8fR+djR/+kN9ZMNzgtHGzqPvNA5UbHd8Pqb" +
       "nXmWWw0ff+/Tz5j8J9CLhzvIfgrdnYbR2z0rs7xTfd4FWnrbzbdVuPLI92Rn" +
       "89fe+3cPjb968a4v49DoDefkPN/kD3PPfrb7ZuM7LkKXjvc5rzuMPsv0xNnd" +
       "zcuxla7jYHxmj/P1Zw9u3gQe6nAKqPM7gyeTfONtwbfuleTcBv2FEwKkJPjg" +
       "LXbwv61IvgVMQmKl+/2tkmxxSqkA7tuy0DFPtO19L7S/c7qXsuC9x6jvLwpf" +
       "Cx72EDX70qA+Deq7b1H3PUXyNAA8PwJcDtQJuI+8CHAPFIVvBo90CE566cF9" +
       "4hZ1P1gk359CVwC4zvmd4hOIP/AiIJZaW5y+qYcQ1Zdca6slwY/fAudPFsmz" +
       "AGdyPc4PneD85IvFWdS7hzjdlxwnVhJ8+hY4f7FIfjaFXgZwFv61OLY7h/Hn" +
       "XgTG4tQYeiN41ocY1y+9un72FnWfK5JfAfDmZ+FhJ/A+82Kt8THwvPsQ3rtf" +
       "eni/e4u63y+S39rDa4XrwEww6pwlfv5FwHtNUfhW8LznEN57XlINPVr033J8" +
       "PHzdibNYZg/vlJVt/fkthuOviuSPgdEasaWl1p7ZCeZHHb3uXEd7AsvsFW8n" +
       "Q/YnX86Q5Sn08jMXWIrT+Aevuzu3v+9l/OgzV+564JnJ75d3OI7vZN3NQnfZ" +
       "a887fW55Kn9HFFu2UyK8e3+KGZV//5hCr71FvJQWN+SOD+y/uOd5PoVeeSOe" +
       "FLoE0tOU/5xCV89TptDt5f9pun9LocsndKDTfeY0yX+A1gFJkf1SdDQZxP/9" +
       "3gGpJ2msGWk5xvmFU0HcocqW03b/C03bMcvpeyNFp+WFyKMgbb2/Evmk8aln" +
       "+sNveL7+if29FcPTdruilbtY6M79FZrjQO/Rm7Z21NYdzONfuvfH7n7TUVB6" +
       "717gE/M5JdsbbnxJhPajtLzWsfvZB37qK3/wmT8tTxz/F10c/z6pKgAA");
}
