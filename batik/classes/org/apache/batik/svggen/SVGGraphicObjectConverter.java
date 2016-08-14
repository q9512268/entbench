package org.apache.batik.svggen;
public abstract class SVGGraphicObjectConverter implements org.apache.batik.svggen.SVGSyntax {
    protected org.apache.batik.svggen.SVGGeneratorContext generatorContext;
    public SVGGraphicObjectConverter(org.apache.batik.svggen.SVGGeneratorContext generatorContext) {
        super(
          );
        if (generatorContext ==
              null)
            throw new org.apache.batik.svggen.SVGGraphics2DRuntimeException(
              org.apache.batik.svggen.ErrorConstants.
                ERR_CONTEXT_NULL);
        this.
          generatorContext =
          generatorContext;
    }
    public final java.lang.String doubleString(double value) { return generatorContext.
                                                                 doubleString(
                                                                   value);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ZecwsWVWv9828mfceM/PeDDAzjMzKA51p/Kq7eqvOAFJd" +
       "vVR1V1d3V1VXd5fCo/ala1+6qwtGgURAUZzIsJjA/AVRybBoJJoYzBijQCAm" +
       "GOKWCMSYiCIJ84doRMVb1d/+FiQmdtK3b98699xzzj3nV+ee+8J3ofNRCJV8" +
       "z97qthfvq2m8b9n1/Xjrq9H+gKpPxDBSFdwWo4gDY9fkJz53+fs/eNa4sgfd" +
       "IUAvF13Xi8XY9NyIUSPPXqsKBV0+Hu3aqhPF0BXKEtcinMSmDVNmFD9NQS87" +
       "MTWGrlKHIsBABBiIABciwNgxFZh0t+omDp7PEN04CqCfh85R0B2+nIsXQ4+f" +
       "ZuKLoegcsJkUGgAOF/L/PFCqmJyG0GNHuu90vk7hD5Xg5z7y1iu/ext0WYAu" +
       "my6biyMDIWKwiADd5aiOpIYRpiiqIkD3uqqqsGpoiraZFXIL0H2RqbtinITq" +
       "kZHywcRXw2LNY8vdJee6hYkce+GRepqp2srhv/OaLepA1/uPdd1p2MvHgYKX" +
       "TCBYqImyejjl9pXpKjH06NkZRzpeHQICMPVOR40N72ip210RDED37fbOFl0d" +
       "ZuPQdHVAet5LwCox9NBNmea29kV5JerqtRh68CzdZPcIUF0sDJFPiaFXniUr" +
       "OIFdeujMLp3Yn+/Sb/jA213C3StkVlTZzuW/ACY9cmYSo2pqqLqyupt411PU" +
       "h8X7v/C+PQgCxK88Q7yj+f13vPTm1z/y4pd2ND9xA5qxZKlyfE3+hHTP116N" +
       "P9m6LRfjgu9FZr75pzQv3H9y8OTp1AeRd/8Rx/zh/uHDF5k/W77zU+p39qBL" +
       "JHSH7NmJA/zoXtlzfNNWw77qqqEYqwoJXVRdBS+ek9CdoE+ZrrobHWtapMYk" +
       "dLtdDN3hFf+BiTTAIjfRnaBvupp32PfF2Cj6qQ9B0BXwhTrg+2po9yl+Y0iB" +
       "Dc9RYVEWXdP14Eno5fpHsOrGErCtAUvA61dw5CUhcEHYC3VYBH5gqIcP1rqu" +
       "ujDL9/uh6BumvDMgiKc1cCg13M+9zf9/WifN9b2yOXcObMWrzwKBDWKI8GxF" +
       "Da/JzyXt7kufufaVvaPAOLBUDFXA0vu7pfeLpfd3S+/fdGno3LlixVfkIuw2" +
       "HmzbCgAAgMa7nmTfMnjb+564DXicv7kd2DwnhW+O0PgxZJAFMMrAb6EXP7p5" +
       "F/8L5T1o7zTU5mKDoUv59EkOkEdAePVsiN2I7+X3fvv7n/3wM95xsJ3C7gMM" +
       "uH5mHsNPnDVw6MmqAlDxmP1Tj4mfv/aFZ67uQbcDYABgGIvAeQHOPHJ2jVOx" +
       "/PQhLua6nAcKa17oiHb+6BDMLsVG6G2OR4qdv6fo3wts/LLcua+C7+sOvL34" +
       "zZ++3M/bV+w8Jd+0M1oUuPtG1v/4X//5P1ULcx9C9OUTLz1WjZ8+AQs5s8sF" +
       "ANx77ANcqKqA7u8+Ovngh7773p8tHABQvOZGC17NWxzAAdhCYOZf/FLwN9/8" +
       "xie+vnfsNDF4LyaSbcrpkZL5OHTpFkqC1V53LA+AFRu4be41V2eu4ymmZoqS" +
       "reZe+p+XX1v5/L984MrOD2wwcuhGr//RDI7HX9WG3vmVt/7bIwWbc3L+Wju2" +
       "2THZDitffswZC0Nxm8uRvusvHv6NL4ofB6gLkC4yM7UAr3MHgZML9coYKt0q" +
       "RHdY6oUHb/Rio+Fi5lNFu58bqeAHFc+qefNodDJgTsfkiZTlmvzs1793N/+9" +
       "P3qp0PB0znPSP0ai//TOJfPmsRSwf+AsOhBiZAC62ov0z12xX/wB4CgAjjJA" +
       "v2gcApRKT3nTAfX5O//2j//k/rd97TZorwddsj1R6YlFYEIXQUSokQEALvV/" +
       "5s07h9hcOET+FLpO+Z0jPVj8ux0I+OTNMamXpyzHYf3gf4xt6d1//+/XGaFA" +
       "oxu8qc/MF+AXPvYQ/qbvFPOPYSGf/Uh6PXKD9O54LvIp51/3nrjjT/egOwXo" +
       "inyQO/KineTBJoB8KTpMKEF+eer56dxnB+JPH8Heq89C0ollzwLS8RsD9HPq" +
       "vH/pDAbdk1u5Cr6PHYTnY2cx6BxUdLBiyuNFezVvfvIw5C/6oRcDKVXlIOp/" +
       "CD7nwPe/82/OLh/Yvcjvww+yiceO0gkfvM6u6GcCIudT3qFf3tbypr1j37yp" +
       "37whb3rpOSDTeWS/uV8wGN5Y7tvy7k8BvIqKzBrM0ExXtAvr9GIQB7Z89VBW" +
       "HmTawHGuWnbzMLivFD6fb9H+Lj09I2vvfy0r8Ol7jplRHsh03/8Pz371117z" +
       "TeB4A+j8OncK4G8nVqSTPPl/zwsfevhlz33r/QX8go3gf+l3mt/KufK30jhv" +
       "xnkzOVT1oVxVtshoKDGKRwViqkqh7S3jbRKaDnixrA8yW/iZ+765+ti3P73L" +
       "Ws8G1xli9X3P/fIP9z/w3N6Js8JrrkvXT87ZnRcKoe8+sHAIPX6rVYoZvX/8" +
       "7DN/+FvPvHcn1X2nM98uONh9+i//66v7H/3Wl2+QZN1ue/+HjY3v5ohaRGKH" +
       "H6qy1OabWZrOtTEysZrbUikbyGk96OArOpkaPW5mYMtxv5yNSyQ78JnaIG1l" +
       "apWummulYitorTSuziWSmtdWS5IcLJk5vkCFFUuyXuAz8+Z8EAxJxBQGczZo" +
       "0+VtsBLNhKdXMzrw/bk/rzYER6oqDryWBj4MsvI4kxFU1UYlrQTTi3DbDswy" +
       "pzBD2kic7lRMN25ZsBCKIYfBwNy2vIm8cesNNkQrtcmihdQGnu/VxKhuipVO" +
       "v5fYC3MQbGuOaXv2aiZmw7RlDNmlFZuDsE+Ol6LvOXEad8207Q77QaQPCYXh" +
       "jHZ/tOyMh4iF275PjWbZQB812p7ATFcrSV+VXQmWHXRGy0FjpPZZpWqRZL3G" +
       "M76dZU3SE72ymjr0cmvTID0ZDplFRA1iX2+M/S4T877TZrwShTcQTmq7ieWM" +
       "DLq8bllbVCxzCC8kus4vy1VuWJEmSHcWL9KyHph2KCNcg68PN1ajm3hDzxMn" +
       "o+nMEKmxx5DyMOobVrhMejNLYygGpYJBpohWJ5DFqTPDZiFbt5cOxtWRDTJi" +
       "a5k8NO04qaMjxJJ4hZmLPcep2SPJ79ETAslaisEHpjiaM0zs1CJdb5N8p+a0" +
       "gQEittwKVNbvzQiK92vj1Fia/pJnhZhrKhK7kjo0BicKmuGD9ag/0hwhDKqY" +
       "1cAlR1B9yZB4Fh5j0brF+5W5jPHlRdL0hh1tLUxwYxnW2rpg+J0qbUt1rxzM" +
       "vcDktZrCMJVOZ4O1pQGikRkb9mol0Uf6y+m4bDI9NhJExsA75RhrcPxYZ3VW" +
       "6W/nwmo7T+MlEc2ElYMxDXFMmexcD5Jxf9mLvHkydWv1DGPRGF2sqVodBRgm" +
       "y1p5IYRTZoo5PN3lfRftSLhfbio+UV5xqzKmmiRCTxSCUycEVS73uzphMlbF" +
       "mmoTlaJLsIYQbl2Z9bM1RtGzCblZzW3cXa2QdbNsRm6d6jFjqxJjscE5MEOM" +
       "VYHrNX1J0bERGVHuYGUiPRfVhiW3mhnl6Xq12eIBUcYqUdB05LRNSNJQHaUs" +
       "71AJyazSETv3sArTjXsqEWKIXrKG4yETcdGs48ddLsDqgY0GK8mF0V5XnHfa" +
       "XG86WZZ5qoE2l5sOR6WbWYdUpsNFc8qtzWRamrTB2XjA8hHK4HK8nGWMYvqr" +
       "RrlVYjGizy7pJLJBiBP1WTSZt3C8GzQcobtJu/35GIstZ5ox/rjPLKR4JPWn" +
       "/JzRp6izGmFesFwyQpyuYd/FKE5BezUSw5P5uEtgBr8VKTXxPVNYdWFbgTlF" +
       "w4nU1/WtbZiIz1piu6sSqdIzNJdZEm1Ebc31GT7BuF5GMsZ40pbEEYaRHcxS" +
       "E4Jo1TORCpq4SY37A5SgHXVVZec8MI1pYJMY12xWbU1WDSeRFjpiqjwxs5y5" +
       "mG69kKLXdKeLzyd931XmI1b0GWkYeqi/pPhxb7xgp8EUnDfY5WLsV2ZdgGcw" +
       "M9VRwq/jqT0A27Id8fWZushqG5heU/a4NvLmPU9BBgSP9dNIraWGavSb02p9" +
       "FozYal0B3rMtKW48ADrrPl1u8ECGgTK2kLTGaRPMqfubBLYJoz6MOHqhazWO" +
       "I1b9ctvy4dKou7Z8RcTlBk9SeKBURjWFjxNumQzqDreoyq4KrBVJBL7tRn1b" +
       "LxkJ3sxW9SkcxfNeuo6S2bRL16LMTUWUpzdVqZM1t3W4hc7riRSoQUxYoj7v" +
       "4WpWIVPfrMhoGsgojazLK7JMVeDBWqr4SE0eo22rZ1pzvuNt0kGNmXbaG1Kw" +
       "6sMGqqlqqSNmQHSkIc+2ll1imTJDzs2Vs1ErcskYDLZI5s+IVQ/vcX2a6Vb9" +
       "qQ4bs7LujwNvalfCllhx6o2GDBPz8kwOOh3LoIk+ktGbel1LpmSppGqdtSuk" +
       "9LQv8gg1F9itpGtLglKl2K/pK4cp9VOlIpRq2QKl2tMh1lcoh53K0oZGQmts" +
       "jE1LHLXVAJ9YC06KBrVlU80ITd0KcHWE06nmmWtp3p/EwrK6nPlZOabtgTrl" +
       "+KwV9NeuZwuxvGmRSMZEmt6yvB5LDIgkGm6IxoBotZHlNqKUiSJX1/E0qIb1" +
       "nouPsLIsYHQkjvTeEt8uGKFHLzIY5q1KXdHGVjw0uIiB54FlT1oOLjuBNx6R" +
       "veV8RNm6NqmXukzHimeNdBhg27ocOU6PnvMLobpAG3q12+eqlfXWFatuVmla" +
       "q/mKJKKEYqmt2SbtelQq4ZvlLHThar3EKhOrFiNLrRrhY0uqwMSE5Ph6i9Lg" +
       "YWdUT5u1YbhM11pl2yiNttsttZyUFrWFQVvJbNhHY6w/TarrdeJ3mvMm3qxH" +
       "SpvulMZzZ95MmGZb9Bu2YmxENlr7ybDbpiqrtTSt92w1ivVkM5xs2g1rvei4" +
       "lZhdylsPkayBUbXojOSrm6ZGtb1RMimRvW4bRTeUghpWq4mMR+M20gk6vbFL" +
       "4vygxOGOOG0gcrc6LPWG40xBQ3Qwa01QWZ3JxHa9CsCLTgdvA4zepBxfM9kZ" +
       "UTO2/DYsiRpRXVSaKxQVbYsJwnoZp2tThzT1AVWuzzNamaCk1c5aNCdUaLzO" +
       "scM+Uo6kSqdR07IqbFZLcI9rZk4mB63uoMJ3tGQ2Wi1ni4oQNcmVuJHqE3lE" +
       "bzRV4uBmUmoQI2sFc0mI17M4Kg9KGTy0cVOAhW6LXG+RuAtTSgJTi7U3q06N" +
       "oJo5LWqCVpJOj66K8aqM9ksiP6x3JUEQ0/IMaflMzErtfmOCrBvsumdwncFs" +
       "7KfjabOHM0NXxuWaoCt8yIBjMmXGy7ozCQNObIPsKZDHgy2BkA2B1Zui2SGa" +
       "DZdfNAcYSizD1iLilmXdk9o0YtYbU5eJay24LVUZs5JprW6fiJWOQ+gNvyca" +
       "G1Pb4HKnOillFNOXuZoeckRIrGd8tWemXKfErdpIQ8VoelHaqHpWqaMLfG0x" +
       "yEwZ+Su0Ba/cWgl3mNGYRNaBFE2TTCGR5mpqVJHywC4HJblhqLAHo2M7YFCU" +
       "rs4ikdZaRgO32MSdzvzuULL9pejOjEbUWMdatmGImJ8gnIkNQ1pEA2bStkl7" +
       "JlkanmgtymqvpVIzmq+obJaOZyJGhKPEZUqaNxOlJbbJuCE2nUupJy/6a3sg" +
       "xLwD0jZdHCXOlK7ANaWkdytdCxv0WPBKCsO+CjKziBJ6tWjbh2VKtJXIFdot" +
       "2C73eLTUwsiyEI6DRlANXLdPL4UBwLhFUiFmY3ICE0Pa27IbsuPXZlijifOb" +
       "RauGYMIkq6xGa7hStirtmVSh2o2su+nGWz0gA7JPdAa18lAwZGQ4naJJvyGt" +
       "qrFRVhGQpGbmmkE21JheN4RNLSPXVYXAhYkUu83tqNrMQDZrqlvTlN2+IPfN" +
       "Tj2dsYHZLPlCwjmo6IrrdWuBLuOKONiuRWOEJQOzWTX63e4qonXChh2xhcQz" +
       "qt/RkJbT2EawK9brbZiqY5ivm8ZSHvZL4ECxVLdxoy0SznwqLkylFqotpSQj" +
       "1DKFBUVDy2K2pqrl8lZbgT3W1u5wu9xICaGXO0HbY12DqWlNIZvGMVHvdDPL" +
       "92ZBA8VInVy0xcgeKtlIN8ZZfdxDIrkq8IPUVirJMIniNNC2NNbh7BrKyZ6q" +
       "VmysjHfU+mirxsDMHbsjj6sboZouJ2p3g5Xb5cp80Bi2jTHVBoIt9C0X+kZG" +
       "lrYLbYLivaY7idZuv4Ws0O4CnKLemB+v9B/vhHtvcZg/ungCB9v8AfNjnOzS" +
       "Gy+4d1BEuCBKURyKcnxc9iw+l8/eZJwsex7XtY5Kho/fomTIbt1YTPND78M3" +
       "u5YqDryfePdzzyvjT1b2DiqHUgxdjD3/p211rdqnFg2hp25+uB8Vt3LHFa0v" +
       "vvufH+LeZLztx6jtP3pGzrMsf3v0wpf7r5N/fQ+67ai+dd194elJT5+ual0K" +
       "1TgJXe5Ubevhoz148LC+Dh/sAXzj+vot9vaEH52pzp6s9r7lhP+IMXSH4iWS" +
       "rRbT3nWLou578uYdMXTXjv64kMQce+UzP6recKpYGkOvuukFUF7NfvC6e+fd" +
       "Xan8mecvX3jg+dlfFXcgR/eZFynogpbY9slC4on+HX6oamahysVdWdEvfn41" +
       "hh64iSfnBbeiU8j+Kzv6Z2Poyln6GDpf/J6k+2AMXTqmA6x2nZMkH46h2wBJ" +
       "3v2If4Ni3c4m6bkTgXAQ3IW17/tR1j6acvKKJA+e4t7/0NGT3c3/Nfmzzw/o" +
       "t7/U+OTuika2xSzLuVygoDt3t0VHwfL4Tbkd8rqDePIH93zu4msPA/uencDH" +
       "LnxCtkdvfB/Sdfy4uMHI/uCB33vDbz7/jaJ2+D/Np7QUkCEAAA==");
}
