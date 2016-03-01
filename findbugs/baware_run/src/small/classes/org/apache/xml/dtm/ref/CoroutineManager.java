package org.apache.xml.dtm.ref;
public class CoroutineManager {
    java.util.BitSet m_activeIDs = new java.util.BitSet();
    static final int m_unreasonableId = 1024;
    java.lang.Object m_yield = null;
    static final int NOBODY = -1;
    static final int ANYBODY = -1;
    int m_nextCoroutine = NOBODY;
    public synchronized int co_joinCoroutineSet(int coroutineID) { if (coroutineID >=
                                                                         0) {
                                                                       if (coroutineID >=
                                                                             m_unreasonableId ||
                                                                             m_activeIDs.
                                                                             get(
                                                                               coroutineID))
                                                                           return -1;
                                                                   }
                                                                   else {
                                                                       coroutineID =
                                                                         0;
                                                                       while (coroutineID <
                                                                                m_unreasonableId) {
                                                                           if (m_activeIDs.
                                                                                 get(
                                                                                   coroutineID))
                                                                               ++coroutineID;
                                                                           else
                                                                               break;
                                                                       }
                                                                       if (coroutineID >=
                                                                             m_unreasonableId)
                                                                           return -1;
                                                                   }
                                                                   m_activeIDs.
                                                                     set(
                                                                       coroutineID);
                                                                   return coroutineID;
    }
    public synchronized java.lang.Object co_entry_pause(int thisCoroutine)
          throws java.lang.NoSuchMethodException {
        if (!m_activeIDs.
              get(
                thisCoroutine))
            throw new java.lang.NoSuchMethodException(
              );
        while (m_nextCoroutine !=
                 thisCoroutine) {
            try {
                wait(
                  );
            }
            catch (java.lang.InterruptedException e) {
                
            }
        }
        return m_yield;
    }
    public synchronized java.lang.Object co_resume(java.lang.Object arg_object,
                                                   int thisCoroutine,
                                                   int toCoroutine)
          throws java.lang.NoSuchMethodException {
        if (!m_activeIDs.
              get(
                toCoroutine))
            throw new java.lang.NoSuchMethodException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_COROUTINE_NOT_AVAIL,
                  new java.lang.Object[] { java.lang.Integer.
                    toString(
                      toCoroutine) }));
        m_yield =
          arg_object;
        m_nextCoroutine =
          toCoroutine;
        notify(
          );
        while (m_nextCoroutine !=
                 thisCoroutine ||
                 m_nextCoroutine ==
                 ANYBODY ||
                 m_nextCoroutine ==
                 NOBODY) {
            try {
                wait(
                  );
            }
            catch (java.lang.InterruptedException e) {
                
            }
        }
        if (m_nextCoroutine ==
              NOBODY) {
            co_exit(
              thisCoroutine);
            throw new java.lang.NoSuchMethodException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_COROUTINE_CO_EXIT,
                  null));
        }
        return m_yield;
    }
    public synchronized void co_exit(int thisCoroutine) {
        m_activeIDs.
          clear(
            thisCoroutine);
        m_nextCoroutine =
          NOBODY;
        notify(
          );
    }
    public synchronized void co_exit_to(java.lang.Object arg_object,
                                        int thisCoroutine,
                                        int toCoroutine)
          throws java.lang.NoSuchMethodException {
        if (!m_activeIDs.
              get(
                toCoroutine))
            throw new java.lang.NoSuchMethodException(
              org.apache.xml.res.XMLMessages.
                createXMLMessage(
                  org.apache.xml.res.XMLErrorResources.
                    ER_COROUTINE_NOT_AVAIL,
                  new java.lang.Object[] { java.lang.Integer.
                    toString(
                      toCoroutine) }));
        m_yield =
          arg_object;
        m_nextCoroutine =
          toCoroutine;
        m_activeIDs.
          clear(
            thisCoroutine);
        notify(
          );
    }
    public CoroutineManager() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "WULvDlMfAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL16C8zr2F2n73dn7p2ZTufemdJpme3MdKa3hWnodWzHSawB" +
       "to4TJ05sJ47jODbQr47txE78fsRO2NmlFdAKpNJdZmCqhdkKyqsqtEI8KqGi" +
       "4U0BIUCIlwRFFW+ooCAeouyyx873vvd2etVdIvnk2P6fc/7P3/n7nPORz0D3" +
       "xhFUCXxnu3T85KaZJzdXDn4z2QZmfLPP4iMtik2DcrQ4noBnh/rTH7v2T597" +
       "v3X9ALqiQq/RPM9PtMT2vXhsxr6zMQ0Wunb6tOOYbpxA19mVttHgNLEdmLXj" +
       "5FkWetWZpgl0gz1mAQYswIAFuGQBJk+pQKNXm17qUkULzUviEPqv0CUWuhLo" +
       "BXsJ9NT5TgIt0tyjbkalBKCH+4r7KRCqbJxH0BtPZN/LfIvAL1Tg57/zHdd/" +
       "9DJ0TYWu2Z5YsKMDJhIwiAo96Jru3Ixi0jBMQ4Ue9kzTEM3I1hx7V/KtQo/E" +
       "9tLTkjQyT5RUPEwDMyrHPNXcg3ohW5TqiR+diLewTcc4vrt34WhLIOujp7Lu" +
       "JaSL50DAB2zAWLTQdPO4yT1r2zMS6MmLLU5kvDEABKDpVddMLP9kqHs8DTyA" +
       "HtnbztG8JSwmke0tAem9fgpGSaDH7thpoetA09fa0jxMoNdfpBvtXwGq+0tF" +
       "FE0S6LUXycqegJUeu2ClM/b5DP+V7/t6r+cdlDwbpu4U/N8HGj1xodHYXJiR" +
       "6enmvuGDb2W/Q3v0E+89gCBA/NoLxHuan/wvn337Vzzx8i/vaf7TbWiG85Wp" +
       "J4f6h+YP/eYbqGeIywUb9wV+bBfGPyd56f6jozfP5gGIvEdPeixe3jx++fL4" +
       "F5Vv+LD51wfQAwx0Rfed1AV+9LDuu4HtmFHX9MxIS0yDge43PYMq3zPQVVBn" +
       "bc/cPx0uFrGZMNA9Tvnoil/eAxUtQBeFiq6Cuu0t/ON6oCVWWc8DCIKuggt6" +
       "EFwraP8r/xPIgi3fNWFN1zzb8+FR5BfyFwb1DA1OzBjUDfA28OFcA07zttUh" +
       "etg4ROE40mE/WsIa8ArLhHPXgY3EhSNzAVN+BPwJsMlpHnCK6GbhccF/4Fh5" +
       "Iff17NIlYJI3XAQEB8RSz3cMMzrUn09bnc/+yOGvHpwEyJHGEujLwIA39wPe" +
       "BAPeBAPeBAPevDggdOlSOc6XFAPvzQ6MtgbhD4DxwWfEr+u/871PXwb+FmT3" +
       "AI0XpPCd8Zk6BQymhEUdeC308ovZu6b/rXoAHZwH2oJZ8OiBovmogMcTGLxx" +
       "McBu1++19/zFP330O57zT0PtHHIfIcCtLYsIfvqiWiNfNw2Aiafdv/WN2o8f" +
       "fuK5GwfQPQAWABQmGlAbQJknLo5xLpKfPUbFQpZ7gcALP3I1p3h1DGUPJFbk" +
       "Z6dPSns/VNYfhs781mf/i7evCYryS/b+URjtghQl6n6VGHz37/36X2Kluo8B" +
       "+tqZKU80k2fPgELR2bUy/B8+9YFJZJqA7g9fHH37C595z9eUDgAo3nS7AW8U" +
       "JQXAAJgQqPmbfjn8/U/90Yd+++DUaRIwK6Zzx9bzvZD/Dn6XwPV/iqsQrniw" +
       "D+hHqCNUeeMJrATFyG855Q0AjAMCr/CgG5Ln+oa9sLW5YxYe+2/X3oz8+N+8" +
       "7/reJxzw5NilvuKVOzh9/qUt6Bt+9R3//ETZzSW9mOBO9XdKtkfN15z2TEaR" +
       "ti34yN/1W49/4Je07wb4CzAvtndmCWNQqQ+oNGC11EWlLOEL79CieDI+Gwjn" +
       "Y+1MInKov/+3/+7V07/76c+W3J7PZM7andOCZ/euVhRvzEH3r7sY9T0ttgBd" +
       "7WX+a687L38O9KiCHnUwfcfDCGBOfs5LjqjvvfoHP/Nzj77zNy9DBzT0gONr" +
       "Bq2VAQfdDzzdjC0AV3nwn9++9+bsPlBcL0WFbhF+7yCvL+/uBww+c2esoYtE" +
       "5DRcX/+vQ2f+7k//yy1KKFHmNvPvhfYq/JHveoz66r8u25+Ge9H6ifxWHAZJ" +
       "22lb9MPuPx48feUXDqCrKnRdP8oIp5qTFkGkgiwoPk4TQdZ47v35jGY/fT97" +
       "AmdvuAg1Z4a9CDSn+A/qBXVRf+ACthwUWn66hJP9L7yILZegsvL2sslTZXmj" +
       "KL7sjHs+k0Cvcg+Bje2NybTjkui1IK8+9YyWnQDJ9zhVlFhRkHvr1u/oCc+e" +
       "8HmtePoMuLZHfG5v4fPSCWIVqrvJgEQTzGePfPqDH/rnd72neVAE3r2bQsXA" +
       "etdP6fi0SJC/+SMvPP6q5//4W0uQgqB7yq6Z28t8AOArLtPsBGjc9jTnWAnX" +
       "3cPUi0wt9r0CPxjj83vsKLJdu9DZPpuDn3vkU+vv+osf3mdzF93zArH53ue/" +
       "5d9vvu/5gzM59JtuSWPPttnn0SWrry75LQL+qc83StmC/vOPPvdTP/jce/Zc" +
       "PXI+I+yAD54f/p3//Ws3X/zjT94m6bgMsv0LNu9/4TYvffNRcL1wZPMX7uCb" +
       "X/cKvnnVPdyefKWc+GVp/X2AXeDxHXfpl4+D68UjHl+8jV8WlUExpRWVxR2c" +
       "qqiOikI4ZvsKP2wN20pxN73A4fIuOXwCXB844vADr8Sh9wVzeJXklTux6N+l" +
       "oQslfvCIxQ/ewdCbVzD0NffQA1F2ktPejq/sFfnaB8clkKXci95s3KwW98/d" +
       "fuTLRfXLb1XM61aOfuM4c5mC728w8dxYOY3beOD+o/UCk898wUyCGH7otDPW" +
       "B9+/3/on7/+1b3vTp0A89o8Rr6BmQeI10qr/8+PFzTffnTyPFfKIfhrpJqvF" +
       "CVemSKZxIpJ4hmk5AYmW/0WIlFz7xl4tZsjjH4uoFJpJee6aw0aFz3SlI2Su" +
       "krcsbeaZtMW3BzwpcS1uhDPSVuC6qEwYdX0jqxuDcI1Er6wdxpSEgdvxl2SQ" +
       "MJQgJKK89hfieI1MrDGF7CQep8eRM5YSsWqHVYsKJC3YyknqwbvKzmikmIFq" +
       "ND2SvV6dQGB44y4weAc3OI8NOBEVGS6oYx08W6q8ttbrTRZvJ26mzQl1jSI1" +
       "drKdOrsKjM3Hm/pEl4cc5SWMy9fVeTJdy2hdCKcaNqzZEjIx1GiQSmzKV1er" +
       "YZ2l/ImGVFzN7WLrWTfEVLaajKWxLCfjILOzSaTaQTfn3KGMptUMTZmt0h2H" +
       "q048wY1+x8mEvusO1uKqxwkyTAWDrL+b45jY31SRiFNDxUO2C2SLdLsh7aMB" +
       "7yYDWRZRTbbbIzVqMasJzXiYRia6EKIMq8c7oUmvkBxZbOp1zFKtpVdvRK2U" +
       "idCu68/lVYXPqzZCYCI+DkaouunzkiWsfGzXWbUn3aqfdBWj47P9SEbqHFWX" +
       "jAkmrdEukhlOqkqa7fsdisPUHZerUjJM3ayecjvSV7d4uhn1/SHCd2Vs0ljW" +
       "fbPbQo0RgTXCAN8wlmTgdDg1iY4+FoRl3LFncktw063rRNV1L1zk7Kovt2oG" +
       "GC6d8jOZrVcQTa5gY9VUSWow4ZfLprFGguZEJ+RaxxN2M0ZSnaVKjJlmyO9g" +
       "0RpoGDmsI55bp5bIrNbjhZhm6Ezbdtpsz5sAwAmGQd5bL1Rux9T5sNYlA0tz" +
       "QjFGmst4qu3YJtOWbKs9Blb00KXXCmCd1JR1i5FXuUxtSLqLJNvYd1PFGKw6" +
       "GVf1ZGZabU0zAW1J+VLtbScrj2ux66xvNjeepyepvZktogEsZZTS44rFhsGo" +
       "6bu0sHBZsdsPLZoR4E4+CNRYWKzT0MCsbN2qbTotZd3bVVFClydbD94I7DKd" +
       "d0ftSYLNEElR+9tNb8O5usdzDUK3ugPJrYGvuc1wxw8NFUm7FU0K1WV7jHSV" +
       "Ro0L+hVzFvF6JcW8OjXLQnFrqUJopcqaURrdwXouTtvTEJNoRItdLncSpmXM" +
       "VrtFTlBbt13B7VCCu9WR2s0Gcmzl4wCedqMMbtIdSqZa/TDsmMh01B06DQnV" +
       "CLiNO501O6hR/ak+ksZNk4e7pssTVtDvBtJUnhoIQwRWVwM5dDBetaOZNVri" +
       "m4k41NY27eMbtd+sy3R1s/XnojPOKmF/a5FTQKCJbjQedpIuq/rkimWW3rrN" +
       "TR2357Ok3e31XBjrJvTQJ+Y2KZGBwbWXA6oVudVq0raR/kCC9YaIT3VzPa2J" +
       "maL0a07IrXW4vbS6uUIK8oqjqM50mXWcrWB1+k1vnGSKSaM677tiDyaxeqh6" +
       "U2KRzGhMyHsdd+cI7Zbaq1prvIJ0d1bOB3rfBFGzkNsshoqp3OfIddvpTdqL" +
       "dAxmP0R1a6xS3eZtf0aTgcTOhdy3/ZqEWWy+XfNcr4VpMQqrNOvrCxynLUoi" +
       "pUlKkAZXi6vjFdfA8maIGQY8Wo1bDUWbAZbm410Ai7jXX/YZgaAiwZQc1VD5" +
       "pjUSq0g8z+qCIpGu4HLekhcovJKSmiy1RYdUHWQg6XSnpkwdVm7SkiaKiRqh" +
       "Emd2iFrKYLQy3zIjcttbMqS+a8CiNsbxOiHBmM4krjKvaEnFxMBw64xI1/Q6" +
       "aeFaPvPEJBGXdJo0jQZvYbXRIG1PttVlt69tltJcl7OuS/Y2S3K2MeXeDq1U" +
       "zBGM11Ey6bU2aQLQ0hFrUaTHQ69JblqEXGl2KDZbKtQAdZVZhDYGZF/rD5pw" +
       "ppIjv2pTDjdZag1CsCq82Bl4RkT3RpZHzCb4DstrRk2ryTXeC8WVqjeYNrvz" +
       "PCQZJBFRRRCSUHNe1IebamNojqlJZuIYbSqOt2W4cIx6NLoNex4uDskGQ7lJ" +
       "FNK6T66xVr0zhFvy3I/9Htrsb9iYt6rzea8yUjVTiHRx4mwSHe5GWOoj/Cxl" +
       "JyqvsotGHd2iomiLPbtV6dXncA/O5yrar9UEadsmLartR+o8nrk8Uk9TJOKN" +
       "KAgbrZjebiNhNF0mSEyamhtLvUEgNiPTXCgzY7wZ0f1eRjmDoDvrNy09m6yc" +
       "MRnQwwZNkFt1hiOx2lr5rW2369ZGa5ez+FEkwUNc91aCajQpub9dNFW+h63w" +
       "hieJK6qxViobY9Kt2CizmmcMQbD1DBstTLii+sKCzVtKJd5RcstUebhjNpAI" +
       "22W2jnsp6Tuh2aS43cYOas3RwMOJddLcLHVv2Eu0gWfOSb2N4HENXi/yeTro" +
       "VacoLSLraUizi+VMNKK2q27pfIwbkT+wQqZWxxA0E7VwXVe4Wac2FAJng4qU" +
       "YBrxHKM4BPObwzFdVTbGiiSrWJNfmit2PantJL+iTvzFptZuz9s6FTsubaE9" +
       "ejuwAbB3XSIZyupEW/A5rXUpou6EPrejOIHWTXrIigytgvHTkbgiJ9NKT3Bn" +
       "zDBtMRy+9YUtCubV1XxMxgLSMFOUVppmz0h3dclaWn4oLGCBTKNNz0etPO6k" +
       "NcKU24NwhG0Watzj7B7tjWQNZpQ+SbS1DT9d1lrq1GnIZKArHLM1lL64xtP1" +
       "1EEJctx2NnaPaTVDpU+o9cVkPueGYhUNNZofNye4xjcmuINO504oRZiXT1rD" +
       "aZjCMhIgaoUZ9fhwvGNX81nAjDrTzjqNe0nFndZG7VlHtJUxkzM0XdUqaMPN" +
       "8MWCthia29bJds/YzOBRgHeJSlN2mUm40CYeiObKsN6rUdWk2sSooJn7/qiX" +
       "YPVmTsQYSN3CGE1ruNF24SjrwkR9OGOzzXixc5iADpOUYKxBl3On5sxoK0I4" +
       "E01pUdmkmJkQocW6awtX6uncm5Me4eGyrDRARhGZOxToZpjq0ZLg8oGmqmEg" +
       "DPrVxUbt1ARaaRF6i8/IEc1Z9aU6n+hT23ArNq2ueH+szVoTPp2Ls4EpLlmR" +
       "jJg5gq/WUoWs1wd4hetUxFoT0fjWzGy3JozE5saqys+8RIjzFiamIUJoi3g7" +
       "cjqDsN+tj1ezsDaJ1qw39vttGYV3RkgPmSHrROB7oS70VmnKqROhpy90R6lN" +
       "qcF00x4nA0tW26gqSgZDKZNWKk+IGpE17fnWraAdvjFsirvuoi6tqxTc6I96" +
       "U1YQLHUdWkxWHbJNA2usmtocI/xZYoP8lF5EKNUdTs0VPJ3sYjGylJYUL6cR" +
       "Lij4bLLNmkNkXG1s6v3p3DWY2SBkiTa2E32uqndoL4FxvOpE8wpsmGQ1wQiR" +
       "hNddeYRmRMVkDA6fNDI4i8VA2AxlQ0HVoRavu3k1ZLl4MY673R1jdjPRdJl0" +
       "1qnUe1687fYc0xlORu7K5aa8206XrOEJeCJMtsKoMuzVxojf7fTNScdpooLZ" +
       "q4tLM0s7GVPhJKHi76bt6gR1GzmDua2FLK7H3DbMF72WsmnUlI4ymXSq2269" +
       "xkY2wP/EGQxbO1bBE6rXMbc7eYRTRr+RT8cLVJ5Wh+twQ/VZZ6DIWrc/1PMK" +
       "V/O6rXWbt4V6nGlOZ6cChNXRfgNfeGNi19bbARWPe9xkUUe7laWVtRHbsyMm" +
       "rKmWF3dqajOIKGfRzPpePLPUbDenM68+tHWV51sTuDFsxYy/pND21NJqdape" +
       "mS8FkG9SbmVm1VwCadC1iafAwPBS6Pu13dzmaIMhR1NXn1esfFWdj2YEMecF" +
       "mgvxLT8NEEzOJXvIe+06u1hZ4w6Yk2pLnB4gqCDWqovhBlZiYqgh8nZJ83Iv" +
       "U1uzUceeuwuuNva2lDSu4bJTbdbM1ARzjLBp4u6SWoUza8AHsDOfGQgRyivR" +
       "0m00HA+5KEwVmHMGM7ixnNlerKRGC+6wwswXR6NAkOrdEVJ1MoqLU5dsrRV4" +
       "N4VJ26rxTp+18zWxbclKizIaFUTMlVFoUKg5ZXJrthpjAzqqDVTHkRZNjkjq" +
       "c0zvjGHd71ebaRglDTvFRiLgoDXlsYihU2VLOWtZX6PzcKnGrL7e7AZOFW9W" +
       "QiXfhm6ApnbU4qUNmjUFm+xWZG8VcNTYS1BlaDiNCmzbUh2O2VWVZQ3gckHf" +
       "GhPA4zBN5KyqP13NO83V1JMoLK82NXe70bHNZt4f1mktaYy8xnRH6G1urRqV" +
       "QM+r/Sqcpy4tVsGE4Vdke9CrZHGXmMykwWyxTSNEjGIAwkTTHaftmrhZBTsr" +
       "7Rrm0t/xo+aMmq+VuZ6sFljGEiKXaX4yFnEG34yXQjTgJAyWUVydaqQhW4E9" +
       "UULEdef1HWsOZaJW5SSj3V9YIwxrkrLEbtoOtwBf3V9VfI7/97tbJni4XPY4" +
       "2bhfOY3ixbvvYiVg/+qponjz+Q2wK9CFzd4z60NnNgmgYlXz8Tvtx5crmh96" +
       "9/MvGcPvQw6OFo5mCXR/4gdvc8yN6Zzpqjh78tY7r95y5XGE00X/X3r3Xz02" +
       "+WrrnXexrfnkBT4vdvlD3Ec+2X2L/j8OoMsnWwC3HJQ43+jZ8wv/D0Rmkkbe" +
       "5Nzy/+Mnmn2s0NjbwPXxI81+/OLK26ntbr8g+OUJ9GC89XQr8j17Zxp7V7iw" +
       "lXVpv+1XLseVBD/4efa6PlwU35NAr9H9w5VveyereUcbCNNTT/reV1pTOtt3" +
       "+eB/nYherDdCFXB9+kj0T9+16EXx/V+YwD92e4Lj9cAnz+xH+GKqW3ujdnLd" +
       "DAofKvv4iaL4aAI9BBRjekm0PQy0NC7tOj/Vyce+WJ28BfB1777t/v//kU4u" +
       "n0LH/GRhdq+dn72z+n6yJPj5ovhEUuzDHUYmmB0uSv3TX4TUxRYDhIPxGkdS" +
       "N/5/esKvfx7X/42i+GQCXS0snNvJbddWN75tnAr+K1+s4CpUrBPvBe//x5j7" +
       "D1/J3J8qit9LoAeO9HCYlMeAfutU7N+/G7HzBLp+8ZxLsVH/+lsO1+0PhOk/" +
       "8tK1+173kvS75VGPk0Nb97PQfYvUcc7uq56pXwkic2GX/N+/32UNyr8/S6BH" +
       "b3/4JoEug7Jk90/3tH+ZQI/cSgvoQHmW7m8ACpynAzSgPEvzt0B/pzQJdGVf" +
       "OUvy96AVICmq/1BafJ5fOj+Xnij8kVdS+Jnp903nJs3yoOPxBJfujzoe6h99" +
       "qc9//Wfr37c/laI72m5X9HIfC13dH5A5mSSfumNvx31d6T3zuYc+dv+bjyf0" +
       "h/YMnzrvGd6evP2xj44bJOVBjd3HX/djX/kDL/1RuRH8fwHSdpIhgSoAAA==");
}
