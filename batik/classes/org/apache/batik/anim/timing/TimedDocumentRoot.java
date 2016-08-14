package org.apache.batik.anim.timing;
public abstract class TimedDocumentRoot extends org.apache.batik.anim.timing.TimeContainer {
    protected java.util.Calendar documentBeginTime;
    protected boolean useSVG11AccessKeys;
    protected boolean useSVG12AccessKeys;
    protected org.apache.batik.util.DoublyIndexedSet propagationFlags = new org.apache.batik.util.DoublyIndexedSet(
      );
    protected java.util.LinkedList listeners = new java.util.LinkedList(
      );
    protected boolean isSampling;
    protected boolean isHyperlinking;
    public TimedDocumentRoot(boolean useSVG11AccessKeys, boolean useSVG12AccessKeys) {
        super(
          );
        root =
          this;
        this.
          useSVG11AccessKeys =
          useSVG11AccessKeys;
        this.
          useSVG12AccessKeys =
          useSVG12AccessKeys;
    }
    protected float getImplicitDur() { return INDEFINITE;
    }
    public float getDefaultBegin(org.apache.batik.anim.timing.TimedElement child) {
        return 0.0F;
    }
    public float getCurrentTime() { return lastSampleTime;
    }
    public boolean isSampling() { return isSampling;
    }
    public boolean isHyperlinking() { return isHyperlinking;
    }
    public float seekTo(float time, boolean hyperlinking) {
        isSampling =
          true;
        lastSampleTime =
          time;
        isHyperlinking =
          hyperlinking;
        propagationFlags.
          clear(
            );
        float mint =
          java.lang.Float.
            POSITIVE_INFINITY;
        org.apache.batik.anim.timing.TimedElement[] es =
          getChildren(
            );
        for (int i =
               0;
             i <
               es.
                 length;
             i++) {
            float t =
              es[i].
              sampleAt(
                time,
                hyperlinking);
            if (t <
                  mint) {
                mint =
                  t;
            }
        }
        boolean needsUpdates;
        do  {
            needsUpdates =
              false;
            for (int i =
                   0;
                 i <
                   es.
                     length;
                 i++) {
                if (es[i].
                      shouldUpdateCurrentInterval) {
                    needsUpdates =
                      true;
                    float t =
                      es[i].
                      sampleAt(
                        time,
                        hyperlinking);
                    if (t <
                          mint) {
                        mint =
                          t;
                    }
                }
            }
        }while(needsUpdates); 
        isSampling =
          false;
        if (hyperlinking) {
            root.
              currentIntervalWillUpdate(
                );
        }
        return mint;
    }
    public void resetDocument(java.util.Calendar documentBeginTime) {
        if (documentBeginTime ==
              null) {
            this.
              documentBeginTime =
              java.util.Calendar.
                getInstance(
                  );
        }
        else {
            this.
              documentBeginTime =
              documentBeginTime;
        }
        reset(
          true);
    }
    public java.util.Calendar getDocumentBeginTime() {
        return documentBeginTime;
    }
    public float convertEpochTime(long t) { long begin =
                                              documentBeginTime.
                                              getTime(
                                                ).
                                              getTime(
                                                );
                                            return (t -
                                                      begin) /
                                              1000.0F;
    }
    public float convertWallclockTime(java.util.Calendar time) {
        long begin =
          documentBeginTime.
          getTime(
            ).
          getTime(
            );
        long t =
          time.
          getTime(
            ).
          getTime(
            );
        return (t -
                  begin) /
          1000.0F;
    }
    public void addTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          add(
            l);
    }
    public void removeTimegraphListener(org.apache.batik.anim.timing.TimegraphListener l) {
        listeners.
          remove(
            l);
    }
    void fireElementAdded(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementAdded(
                e);
        }
    }
    void fireElementRemoved(org.apache.batik.anim.timing.TimedElement e) {
        java.util.Iterator i =
          listeners.
          iterator(
            );
        while (i.
                 hasNext(
                   )) {
            ((org.apache.batik.anim.timing.TimegraphListener)
               i.
               next(
                 )).
              elementRemoved(
                e);
        }
    }
    boolean shouldPropagate(org.apache.batik.anim.timing.Interval i,
                            org.apache.batik.anim.timing.TimingSpecifier ts,
                            boolean isBegin) {
        org.apache.batik.anim.timing.InstanceTime it =
          isBegin
          ? i.
          getBeginInstanceTime(
            )
          : i.
          getEndInstanceTime(
            );
        if (propagationFlags.
              contains(
                it,
                ts)) {
            return false;
        }
        propagationFlags.
          add(
            it,
            ts);
        return true;
    }
    protected void currentIntervalWillUpdate() {
        
    }
    protected abstract java.lang.String getEventNamespaceURI(java.lang.String eventName);
    protected abstract java.lang.String getEventType(java.lang.String eventName);
    protected abstract java.lang.String getRepeatEventName();
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "/Y2/4tuH/wP5bq0VPzMAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e7AkV3nf3NVbCO1KAiRhvQAJkAa25/2IALmne6a7Z7rn" +
       "0dOP6SFY9PR7+v2c7jEYDGWDoYxxIjCpWPonOE4oYSAVylApB6USB1x2XMZF" +
       "hdhVASpPG5sqK1UmroDtnO6Zu/fu3d272uw6U3VO95zn9/vOd77vO49+8Qel" +
       "W8KgVPZcK9MsNzqvpNH5tdU8H2WeEp4fks2pGISKjFhiGDIg7VnpjV88+8Mf" +
       "fVI/d6Z067J0n+g4biRGhuuEtBK6VqLIZOnsUWrfUuwwKp0j12IiQnFkWBBp" +
       "hNHTZOlVx6pGpcfJQxIgQAIESIAKEiD4qBSo9GrFiW0kryE6UeiXfqZ0QJZu" +
       "9aScvKj0hosb8cRAtPfNTAsEoIXb8/8cAFVUToPSYxew7zBfAvhTZei5X/mp" +
       "c//iptLZZems4cxzciRARAQ6WZbushV7pQQhLMuKvCzd4yiKPFcCQ7SMbUH3" +
       "snRvaGiOGMWBcoFJeWLsKUHR5xHn7pJybEEsRW5wAZ5qKJZ8+O8W1RI1gPV1" +
       "R1h3CAd5OgB4pwEIC1RRUg6r3GwajhyVHj1Z4wLGx0egAKh6m61Eunuhq5sd" +
       "ESSU7t2NnSU6GjSPAsPRQNFb3Bj0EpVef8VGc157omSKmvJsVHrgZLnpLguU" +
       "uqNgRF4lKr32ZLGiJTBKrz8xSsfG5wfjd3zipx3cOVPQLCuSldN/O6j0yIlK" +
       "tKIqgeJIyq7iXU+RnxZf91sfPVMqgcKvPVF4V+Y33/fyT77tkZe+sSvzE5cp" +
       "M1mtFSl6Vvrs6u5vPoQ82b0pJ+N2zw2NfPAvQl6I/3Sf83TqgZn3ugst5pnn" +
       "DzNfov+98MHPKX92pnQnUbpVcq3YBnJ0j+TanmEpAaY4SiBGikyU7lAcGSny" +
       "idJt4J00HGWXOlHVUImI0s1WkXSrW/wHLFJBEzmLbgPvhqO6h++eGOnFe+qV" +
       "SqVzIJReC8IbS7tf8YxKIqS7tgKJkugYjgtNAzfHH0KKE60Ab3VoBaTehEI3" +
       "DoAIQm6gQSKQA13ZZ4BqYFIaNpAjiDFsRUZdKbZBbdoFXMhFzfv/0UmaIz23" +
       "OTgAg/DQSRVggdmDu5asBM9Kz8W9/su/8ezvnrkwJfY8ikrnQb/nd/2eL/o9" +
       "n/d7ftfv+Uv6LR0cFN29Ju9/N95gtEww74FGvOvJ+XuG7/3oG28CguZtbgas" +
       "zotCV1bMyJGmIAp9KAFxLb30mc3Pch+onCmduVjD5jSDpDvz6tNcL17Qf4+f" +
       "nFmXa/fsR/7kh1/49Pvdozl2kcreT/1La+ZT940nuRu4kiIDZXjU/FOPiV9+" +
       "9rfe//iZ0s1AHwAdGIlAZoF6eeRkHxdN4acP1WGO5RYAWHUDW7TyrEMddmek" +
       "B+7mKKUY9ruL93sAj1+Vy/RDINB7IS+eee59Xh6/Zicm+aCdQFGo23fOvef/" +
       "0+//ab1g96FmPnvM1s2V6Olj2iBv7Gwx7+85kgEmUBRQ7j9/ZvoPP/WDj7y7" +
       "EABQ4k2X6/DxPEaAFgBDCNj8c9/w/+i73/nst84cCU0EzGG8sgwpvQAyTy/d" +
       "eQpI0Nubj+gB2sQCky2XmsdZx3ZlQzXElaXkUvrjs09Uv/znnzi3kwMLpByK" +
       "0duu3sBR+oO90gd/96f+9yNFMwdSbs2OeHZUbKci7ztqGQ4CMcvpSH/2Dx/+" +
       "R18XnwfKFii40Ngqhc46U/DgDKj05CkeTQDmZ2QkeysAvf/e75q/+ief32n4" +
       "kybjRGHlo8997G/Pf+K5M8fs6psuMW3H6+xsayFGr96NyN+C3wEIf5OHfCTy" +
       "hJ1uvRfZK/jHLmh4z0sBnDecRlbRxeB/fuH9/+qfvf8jOxj3XmxW+sBr+vx/" +
       "/OvfO/+Z7/3OZfTYbSvXtRSxEM96QSpUkPpUEZ/PaSsYWyryns6jR8PjmuNi" +
       "Hh9z2Z6VPvmtv3g19xf/+uWi24t9vuMThRK9HZPuzqPHcsz3n1STuBjqoFzj" +
       "pfHfP2e99CPQ4hK0KAEDEE4CoKvTi6bVvvQtt/3xv/m3r3vvN28qnRmU7rRc" +
       "UR6IhYYq3QFUgxLqQM2n3jM/uZsZm9sPLV9augT8bkY9UPy783QZG+Qu25F+" +
       "e+D/TKzVh/7LX13ChEItX0bsTtRfQi/+6uuRd/1ZUf9IP+a1H0kvtV/AvT2q" +
       "W/uc/Zdn3njrb58p3bYsnZP2vjMnWnGudZbAXwwPHWrgX1+Uf7Hvt3N0nr6g" +
       "/x86KffHuj2pmY/kDbznpfP3O08o47tzLj8Jwlv2euotJ5XxQal4IYoqbyji" +
       "x/PoLYe67w4vcCNApSIXbTei0j3y3gL3FM1wcptcVHstwHZMY4kWcJjEYKfs" +
       "8/gdeTTcjfgzV5QO9FLa376n/e1XoH1+BdrzV+qQ6HvjUJlzWLUKF9I9UrKi" +
       "fP0Efcz/A331PX31K9C3vBb6aqfT9+5rpI8Aobunr3sF+sRXQt85IAaeqBVz" +
       "rLCbh2P+5ks8tmL8UReYzIxwZCXNF2/RCRyra8TRAuGZPY5nroBj/Upw3JFb" +
       "2NwShBfZgIvVDS1uitXQs9JXZ9/75vPbL7y4U/ErEbj7pfKVFtaXru1zZ+2J" +
       "UxzOoyXXX2J/76U//a/ce87sTcKrLsb/wGn4D4fisl5wnneS++Y1cv8NIKD7" +
       "3tErcD99JdwHmnEu2h5YPmmXk+7sGul6Yi/hh5J+Obo+8EroutsIcTAMASDM" +
       "vAJtH7wqbUVb6QHQmbfUzrfPV/L/P3/53m/KX98KHMuw2PkANVTDEa1Dcu5f" +
       "W9Ljh44LB2QVTLrH11b7cKDPFQOdm5Dzu+2DE7Q2XjGtYBLcfdQY6Tra0x//" +
       "b5/8vV9603eBxA9LtyS50QJCfKzHcZxvzvz8i596+FXPfe/jhZ8M2Mn9wpfa" +
       "38tb/eXTEOfRx/Lo44dQX59DnReLTlIMI6pwbRX5AtrKMTytCDjI7nWgjV5z" +
       "M94ICfjwR1ZFpQmzKe0kdSaeNLZGY1CG6o0Guol1jrV6G7qhtODKho3lBsLN" +
       "tmt7CYrqXixjvNxab1i9w/Ux05uzs0VKb/TOsKd33DQhlm6NbM4m1HpqTihW" +
       "yOyRb+gWSVRGczatd6VtuKXa8Xa8ENtY049tuVVuJWUoKkOrWsvblFVCoyiH" +
       "zTTEjjR+y/ljcuYG/foMpb3A1BYoD4+rC4WIhhKxwCrlmNc1e7msmiLR1YLe" +
       "bKBlLcbvbbaT0GrMGUxwiTXL9zkPRRxRxrxZwnY10/cqZozNK8uAXfZtttZ3" +
       "q3SAoxMTm5q636O4us+scVHU6nA21VypR+pOf84rw3Dltug5R/IRk8h0EDfH" +
       "gb4K7QVjU7rhre0GX3ZpwjCtbIi4ywDFIrNriyO7O84QYEgwhw8HZrneIDUz" +
       "XjcndI+KV5Dv17pxa+TY/fFsaPhERnptmtGqXNufpKORlYlWZNrreUygHXvI" +
       "9bPamF+aqu9OebM/dOuwR4oVxoA0VQODF5q2JSRoe4iPxr3+UrDprGsgogtH" +
       "Q7Gp1bZrMC5UI6wxZjpHQ49oVbyl0CLGndqkTVYtAWLRoTj3zSo9nGtKRmwI" +
       "BkVWXq/f80Iv8VNvKKwpoTUXKojRrfZk1p55fJ2fR5LImgTNwz5fbwiDUZUS" +
       "q6otoZa4WRvIytFHS99W+0Z9MgiTxqo/VAY9SmttPJyzcHhZdSfwgCY2XigN" +
       "KmhMeiS9YO0RxUzp+RKbh0k6a8ETBx5ibFe0RZ81eRixhoHvauGIsIhey1BM" +
       "F4nhKj2bDWs0tWqhRCSKxFQYIbI/wGLHq9aE2kzs9nBYMwV+3ojSUEW4pbfG" +
       "FG4xibZixBt1TvJHzdkGmeFTah6MsmlXI4aBRvC+I4keE8ITJsSHfBdb6mlv" +
       "0t64NNwsY8rWFlW6LaqJs57oIyqx8TrWjO1t7ITbAWcvFLLXbk2StW0LMdnv" +
       "17L1gjNxNA0zxuGipR0xc3uswhtiS6wFe4LWF0YFUk11sWDrEENTI8sb2uJ6" +
       "5M8ZlxVq7nDNDb3Ey3yrJwsow8+1JT2UV/1aNRnOcGM619wqGAC8sVlagUiz" +
       "TYuzRklHJYgA7cM63Vul5NzKqvUt3+uqaD3qC4QviDhKyA6yxqEy0lnPfBpn" +
       "5BFBwP7IGxn02KoOykKFUIZpvCEFp6JVxXoaptXhbDLSdbrL0n0YrbsuJ6Am" +
       "MaDnpjNzO5o4Yq31VvSFuTasxhvXdUeeBzW6w4qhe/Xlcob0lrozlgYZBndH" +
       "1VmTTthY4ru+KCVeue0pVMSSjEQixrCP2aTac0ilt+3GcGcrCp3tytz2I4Rg" +
       "2jI13KoLrCsEXGuj1JGOxVDtsZVloqywfQuurNjQmxFV2avNBi6ywieypiRs" +
       "2GHXkVkrM/XmtsIMfY5mjZggkQWB9ct8C3Y2HDZKllLG1WlEdGAtzWhWp0jG" +
       "80193RihHcJlq/PAEek6Hy5rc0HczNqqj1l0kq3parucyYNVVM26bUN19L7Z" +
       "mGRrzYKnsJMNmlg7yNZUHHe3PqpOxnyb2TarS2wlt4wJ3zFGlLPcbEeDPiYu" +
       "GwOJIJmm1BCb5IYdS8yk7DbbxBReMVRvC286DY1J8IGleF281kB0cjLTJA7i" +
       "TQKbMOtFf9Dq4hzJNsbV7kyE1g2qihEbO+43lLEbxeU5VEM9ZFMfmb5su8u0" +
       "4SkE05gJSg3qlBPVAaahG06GFh+TIwQNTXEBd6Y9MbAD38FZ2a1ORmAGtLti" +
       "Dat1WtGC6larjksxC1WfcsLYxdeawfbtUbfdELw6E6RQZ1TbuGWJIhzDx9KR" +
       "LveXRIBIHMySyGpMyWoI97IYVlks8auZrznVodQPgBflLqueHYgJoZbjVSJW" +
       "YWop2puqHU0huN/utkYLoOKlGmSHCJ4JpqD1ahQ+adlcq7vVraYhNki+iU27" +
       "Yy5Zk1Bkk7Da0KaNZX8q0oG9QhcUtYns2jpZsabi1jZIu2dtEW/b8IRON6wZ" +
       "q8SvQc2Y9qe0MltTajhN1oMMaoPpbUGmYbWmlrCtj6YSbVXLsL7oefxKICFS" +
       "zQaNqZlMNa3FeYaStFdDZF1mqGSAV7okXJYyWEcHK40yJjV90o2a5U41ZWCs" +
       "2ek6ih0nDASIxesLZwrIoW3RbCgNUUj7qcXgyIYnHIXRait9QCVliWfwRl2N" +
       "a5iVcctQNq1Qa7S3dQbqNmMF59Fqm+pvKEz2Y5+BF8xiWcNbXprWw0lW7Uis" +
       "n1gOtypD7mppYqoxBtpDYf1ZwAazalNvcJ01vK4qVZFC5F5D5+LOopcSozal" +
       "OQvY0KKmwrSd5nJD0Q16S+PrFWJkNsY3VDuo2oGTteftrR5IZTyYJp1MHkvt" +
       "OOvXlUrGab6ILNzxIKLo7hBXMFJGKNzX6nUL56pVhaShbs9chXpvMDDGbUzU" +
       "K8iKCcgNZ3SB2e9k3el0PV5XFM0ckhnFhUbQtzRH4prjXgOZe5UZlU78SpRE" +
       "60qfS0bt1cxiFqP+tmXBk2ZNqG8mlSG6wFaL1crNKHWBM+5mmkg879gYRjUh" +
       "tkdh7RFCdaHaRMX19lpKlGkyI2uQIsQeqxFco9VfdhMuiJN4haplGd6GYx33" +
       "p2kFlzE06pS92DaYrd3tN5VZvG7JdtmDV7jsNrtlGUKJjqdkTarnCHPRG4jN" +
       "uMp4PaY1qbQFPtJreJjUCM+KeDnpdzIpRvuM3JGbgSxUA0YyYq2mWxjrJTTV" +
       "18vEfOvSjq6z6tIxUIFYb6xKc0K5k0XYRgSxo0izpR9TMTJP16m+rKzhkNiy" +
       "6SijVoY1nsOBDXR9awCjGmsse7pGSxWqSqwxNhjEyRh4NmUkCG2ugzQHhrxV" +
       "Z7OK1yz3UmEpTdTM1eSYnTEJTy479dXGrm/YxOPMZtcVVKuMy1qZS4OKM+7y" +
       "QwHlVXEtW4aCd9IsNBGeLw+WYr/WqhCyRTR71rTmYb6JD8cI3iOBuZi1xYyh" +
       "oOXEQQciJ+h9ORD9kHYxs0PbfanC+T0XKfeWKxSr1/oKYB5mlDkMhYCDoi9s" +
       "GBabG3XYZL1BXdg4qgcMtEW1PLyKQB0BWLCuOq3IfN2Rt1A57rQnmMwbNcZS" +
       "2ZhZplG36Q/SzhgyO0zDn0WbOKNobbBtxPxgmi1MKZl248Z82+ZnLJ/UgbeY" +
       "KgtmbKyBcE3VSmaG5RiC69MtktrlDSMPt+U1VN9oXbW+2kZZjUoDqt81l+RK" +
       "nXPbuEN3Y0sUBqupItFqNSurylRNtnSs1WuYVh80Ar+yAtNS7jCCHFTqgTSE" +
       "+C6hhF2ddgcWpfvqknUtG29PhX5N49VoRgm1Oa5RSmtujFSp7aezgejws/ZI" +
       "tpgmT1Yic8BCoikCz0sY8b2KrEzqVWEhqzCZeNCoX12POuP1cEYKI7flYdFE" +
       "mXAQJ9Fbb8IY2ZLT+jKz7SxajrpOo2l9Pa5rk7S6UKmwufAFpzdixgs7C+bT" +
       "zG/prYCQB4M1NXfak9Z8Vm5v6nKnO1h3BdvSl5kujGt91WwOO9PyUEDmW4io" +
       "97OOn4rbxjIsi2DtWhnghEx1R6iJq6PYEmR1gTblem9q623Ppr3lFhum4+rQ" +
       "kPXqwrVGXGW4CElqzW+DcBpGcqoFSogFLaElxrzjOS0TXsTL3oYU8ZAxFhGa" +
       "9rBFjWuubIu0EGAOBHHkWW456lLSmOJ6nKD66pqnuC5EW2mHEtBR160unO6i" +
       "52riahj2mQ6BEFF/qgfjLVpJOnO00qgxEZtBzqQ97bCVhgs5BOfA1R4EC7Ej" +
       "4BQBPAImHgLADJilabfWQSORnG7sjT8WCMQYNMoyjhloam8G0ao2TX3fRpm5" +
       "KbO6iIl4AJcxit6M1miU4BsPyYasy6MNVgI+MYzDfEUVkkG8ctKKBqgKBRSW" +
       "SEg27WW7waINcyYQCrC5bYYKmVicJlpDwFOVpPsrRGpVrMqKH2jlAd7S+432" +
       "aIag9emwPO6pvU4v67lhgs3N7WhSld26TzVHobGh+tOKg5NyZMxbC1SXpgbd" +
       "TJRGGYGgTm8mtohuX+zBvMCKWAOr9JZOF850JZonETtaCr0RR897w15DnHaU" +
       "KdEVzXVTnAAN58F9oUfy49Qn+LFWGfaadUqYZXiNwMzA0m0dbVsjNo69jY+n" +
       "RKdCDAh8idSs0HfNjiFFOIm3YJR2hC1GdxSqnA28pdESR9OVpY/Wc4/vrw00" +
       "VoSepKRgrVIhyvUprEvAWx613THcqaAwaXbCPk8vLU7ZjrVO0hEc365mW31h" +
       "gMXMFpo3BtkGyiAR4eozxSf5yqyL+5kJZwonLGCaQIKBgK75GroQZ4vBJhwC" +
       "NkrdDGnU1/p86tNl2xP8oUPW9RacpW7IrYmM9eVhDdnWep2aT5goWoOQRted" +
       "WfWGCYv42qvFM+BJWk1RghuQt2rglGywm96kzukVzVFG861flQ2843os7uLN" +
       "aTXoBDNyqpel2bw9HGv1mRVl1KK/bs8gZkj0bKwXDyae7o3FwZyJFgSYgKw+" +
       "mPnSvAZWUVLIztrsVvNVf6a4bNggMr62arp8axiJHXm5cjJ0lShqpdlxNK8y" +
       "Wbv6fLEdddfTPjtezUIYMtyQDZD2eBGwVi8Nwka7prA0MBnybJEOZs2a0kNF" +
       "2LAUUWjaZRjvhF1B7VvoEm0MgPxXgfyzlSVQ8iu+agE+ZfRy4ScDZrCVaoGx" +
       "RUid2pCrJjGYy0MulWGkqQw7Yh0sZdLycIE7YF2Dof2GNlhtzdq2g4w9re4t" +
       "TH5c4bXJuExijUqla/NTrZdZS8TsGVq8kJOJJCfOjDTqfA+dwPoA4zej6dQO" +
       "Z2W37uJbpy6x6xhx0QA30vKWNQC9cnU0sbEWj6QC6uK1YeoizAIofNwc1wgY" +
       "cTv9CK1hKd/RQV9Im5uvNX/M495GmfTChkfbXrZyfGMoBXTMSQEqJHAjqeOi" +
       "5uN1S2svBuWa12qGg3A5VBaphWTtKVRu18Ow4kiChTojS6FteFE3h1OpTsRI" +
       "b7GtGMuyQHb0RkukqU5GrTdJX8msDqXK3VQTopWUEJtpI2gnKp4anjQNetFE" +
       "JONOGKyHNDyop11uRXVTPy2z5YZdTod4zZlthW4l2LhdXE+UujlqJiNrsk3M" +
       "xWYCkTW5MWZtiJM7lNGbV5eysgh6uCJYM67PR3YdZWdLPGPRbWIQaoQwDtYa" +
       "t8d4HIY6u01SqwW1el4XCAPmjfW0GmCTwCerUIpgRjDFqM544lNlqYkDRToh" +
       "HSe1uK65EuihyFSAHq4vAqlVVjySZ5lQTNblpbLhXKcFVOiiPKVULkxsfQq1" +
       "B9VyLCgC115hZVVN+hFY10zw8VSkJoxm");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "m/2/ZSPOJys+AAA=");
}
