package org.apache.batik.dom.events;
public abstract class AbstractEvent implements org.w3c.dom.events.Event, org.apache.batik.dom.xbl.OriginalEvent, java.lang.Cloneable {
    protected java.lang.String type;
    protected boolean isBubbling;
    protected boolean cancelable;
    protected org.w3c.dom.events.EventTarget currentTarget;
    protected org.w3c.dom.events.EventTarget target;
    protected short eventPhase;
    protected long timeStamp = java.lang.System.currentTimeMillis();
    protected boolean stopPropagation = false;
    protected boolean stopImmediatePropagation = false;
    protected boolean preventDefault = false;
    protected java.lang.String namespaceURI;
    protected org.w3c.dom.events.Event originalEvent;
    protected java.util.List defaultActions;
    protected int bubbleLimit = 0;
    public java.lang.String getType() { return type; }
    public org.w3c.dom.events.EventTarget getCurrentTarget() { return currentTarget;
    }
    public org.w3c.dom.events.EventTarget getTarget() { return target;
    }
    public short getEventPhase() { return eventPhase; }
    public boolean getBubbles() { return isBubbling; }
    public boolean getCancelable() { return cancelable; }
    public long getTimeStamp() { return timeStamp; }
    public java.lang.String getNamespaceURI() { return namespaceURI;
    }
    public org.w3c.dom.events.Event getOriginalEvent() { return originalEvent;
    }
    public void stopPropagation() { this.stopPropagation = true; }
    public void preventDefault() { this.preventDefault = true; }
    public boolean getDefaultPrevented() { return preventDefault;
    }
    public java.util.List getDefaultActions() { return defaultActions;
    }
    public void addDefaultAction(java.lang.Runnable rable) { if (defaultActions ==
                                                                   null)
                                                                 defaultActions =
                                                                   new java.util.ArrayList(
                                                                     );
                                                             defaultActions.
                                                               add(
                                                                 rable);
    }
    public void stopImmediatePropagation() {
        this.
          stopImmediatePropagation =
          true;
    }
    public void initEvent(java.lang.String eventTypeArg,
                          boolean canBubbleArg,
                          boolean cancelableArg) {
        this.
          type =
          eventTypeArg;
        this.
          isBubbling =
          canBubbleArg;
        this.
          cancelable =
          cancelableArg;
    }
    public void initEventNS(java.lang.String namespaceURIArg,
                            java.lang.String eventTypeArg,
                            boolean canBubbleArg,
                            boolean cancelableArg) {
        if (namespaceURI !=
              null &&
              namespaceURI.
              length(
                ) ==
              0) {
            namespaceURI =
              null;
        }
        namespaceURI =
          namespaceURIArg;
        type =
          eventTypeArg;
        isBubbling =
          canBubbleArg;
        cancelable =
          cancelableArg;
    }
    boolean getStopPropagation() { return stopPropagation;
    }
    boolean getStopImmediatePropagation() {
        return stopImmediatePropagation;
    }
    void setEventPhase(short eventPhase) {
        this.
          eventPhase =
          eventPhase;
    }
    void stopPropagation(boolean state) {
        this.
          stopPropagation =
          state;
    }
    void stopImmediatePropagation(boolean state) {
        this.
          stopImmediatePropagation =
          state;
    }
    void preventDefault(boolean state) { this.
                                           preventDefault =
                                           state;
    }
    void setCurrentTarget(org.w3c.dom.events.EventTarget currentTarget) {
        this.
          currentTarget =
          currentTarget;
    }
    void setTarget(org.w3c.dom.events.EventTarget target) {
        this.
          target =
          target;
    }
    public java.lang.Object clone() throws java.lang.CloneNotSupportedException {
        org.apache.batik.dom.events.AbstractEvent newEvent =
          (org.apache.batik.dom.events.AbstractEvent)
            super.
            clone(
              );
        newEvent.
          timeStamp =
          java.lang.System.
            currentTimeMillis(
              );
        return newEvent;
    }
    public org.apache.batik.dom.events.AbstractEvent cloneEvent() {
        try {
            org.apache.batik.dom.events.AbstractEvent newEvent =
              (org.apache.batik.dom.events.AbstractEvent)
                clone(
                  );
            newEvent.
              originalEvent =
              this;
            return newEvent;
        }
        catch (java.lang.CloneNotSupportedException e) {
            return null;
        }
    }
    public int getBubbleLimit() { return bubbleLimit;
    }
    public void setBubbleLimit(int n) { bubbleLimit =
                                          n;
    }
    public AbstractEvent() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "0P8FdKqlWJs/AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL18CbArWXme7p19Yd6bGZgZD8zKsAzyvJZaraUZM6a19CK1" +
       "1JukltrGQ6u71Yt6Uy9qqckYTNkBhxTB9kCAMlNOFSQxNQZix4FUDDVO4gXj" +
       "coXEcRIXMcShYmxCAqkYBxPbOS3pvru8e+97b+6t3Krz39ZZv++c//znP92n" +
       "+8Vv5W4Kg1ze9+yVbnvRJW0ZXbLs8qVo5WvhpTZdZuUg1NSGLYdhH8Q9qzz+" +
       "mQvf/f4HjIu7uZul3L2y63qRHJmeG/Ja6NkLTaVzF/ZjW7bmhFHuIm3JCxmK" +
       "I9OGaDOMnqZzdxwoGuWeoPcgQAACBCBAawgQtp8LFHqF5sZOIyshu1E4z/14" +
       "bofO3ewrGbwo99jhSnw5kJ1tNeyaAajh1uz3EJBaF14GuUcvc99wvoLwB/PQ" +
       "83//xy7+8g25C1LugukKGRwFgIhAI1LuTkdzJloQYqqqqVLublfTVEELTNk2" +
       "0zVuKXdPaOquHMWBdrmTssjY14J1m/s9d6eScQtiJfKCy/Smpmare79umtqy" +
       "Drjet891wxDP4gHB200ALJjKirZX5MaZ6apR7pGjJS5zfKIDMoCitzhaZHiX" +
       "m7rRlUFE7p7N2Nmyq0NCFJiuDrLe5MWglSj34ImVZn3ty8pM1rVno9wDR/Ox" +
       "mySQ67Z1R2RFotyrjmZb1wRG6cEjo3RgfL7V+6H3v8Ml3d01ZlVT7Az/raDQ" +
       "w0cK8dpUCzRX0TYF73wT/SH5vs+/dzeXA5lfdSTzJs9n/9Z33vqDD7/025s8" +
       "rz4mDzOxNCV6Vvn45K4vv6bxJHpDBuNW3wvNbPAPMV+rP7tNeXrpg5l33+Ua" +
       "s8RLe4kv8b85ftcntW/u5m6ncjcrnh07QI/uVjzHN20tIDRXC+RIU6ncbZqr" +
       "NtbpVO4WcE2brraJZabTUIuo3I32Oupmb/0bdNEUVJF10S3g2nSn3t61L0fG" +
       "+nrp53K5iyDkYBBel9v8PZGJKGdBhudokKzIrul6EBt4Gf9sQF1VhiItBNcq" +
       "SPU9aAL0f/ZU8VIVCr04AAoJeYEOyUArDG2TCKmeA2kLDUxmCJsAzZeVqJX9" +
       "vJTpnP//tbVlxv1isrMDhuU1R42CDeYT6dmqFjyrPB/XW9/51LNf2r08Sba9" +
       "FuWeBE1e2jR5ad3kJdDkpU2Tlw41mdvZWbf0yqzpzeCDoZsBIwDM451PCm9r" +
       "v/29j98AtM5PbgT9nmWFTrbSjX2zQa2NowJ0N/fSh5OfGL6zsJvbPWxuM7gg" +
       "6vasOJsZycvG8Imj0+y4ei+85xvf/fSHnvP2J9wh+721A1eWzObx40c7NvAU" +
       "TQWWcb/6Nz0q/+qzn3/uid3cjcA4AIMYyUCBga15+Ggbh+bz03u2MeNyEyA8" +
       "9QJHtrOkPYN2e2QEXrIfsx7xu9bXd4M+LuW2Yk/j1/+z1Hv9TL5yoyHZoB1h" +
       "sba9bxH8j/3H3/vT0rq798z0hQMLn6BFTx8wDVllF9ZG4O59HegHmgby/ecP" +
       "sz/3wW+950fWCgByvPa4Bp/IZAOYBDCEoJt/6rfn/+mrf/Tx39/dV5oIrI3x" +
       "xDaV5Ybk34C/HRD+OgsZuSxiM63vaWxty6OXjYuftfz6fWzAzNhg8mUa9MTA" +
       "dTzVnJryxNYyjf2/F15X/NX//v6LG52wQcyeSv3g1SvYj/+Beu5dX/qxv3h4" +
       "Xc2Oki1z+/23n21jO+/drxkLAnmV4Vj+xL996CO/JX8MWGFg+UIz1dbGLLfu" +
       "j9x6AAvrvsivJXQkDc7EI+HBiXB4rh1wR55VPvD7337F8Ntf+M4a7WF/5uC4" +
       "d2X/6Y2qZeLRJaj+/qOznpRDA+RDXur96EX7pe+DGiVQowKsWMgEwOosD2nJ" +
       "NvdNt/zhr/+r+97+5Rtyu3judtuTVVxeT7jcbUDTtdAABmvp//BbN9qc3Lpn" +
       "1Ze5K8hvFOSB9a+7AcAnT7Y1eOaO7E/XB/6SsSfv/uP/c0UnrK3MMavwkfIS" +
       "9OLPP9h45pvr8vvTPSv98PJKSwxct/2y8CedP999/Obf2M3dIuUuKlu/cCjb" +
       "cTaJJOALhXvOIvAdD6Uf9ms2i/jTl83Za46amgPNHjU0+ysAuM5yZ9e3H7Et" +
       "d2W9/CAIb9raljcdtS07ufXFW9dFHlvLJzLxhr2pfJsfeBFAqanrup+MNq2t" +
       "c74KuNhr9cjYXNp4aRtjlclSJrDNEFdOVIenD4N9DARoCxY6AWz7BLDZZXMP" +
       "JRiEejwBVsjVT1csNjAdYBkXW/cMeu6er85+/hu/tHG9jmrRkczae5//O39z" +
       "6f3P7x5weF97hc95sMzG6V2DfMUaaTYvHzutlXUJ/E8+/dy/+MfPvWeD6p7D" +
       "7lsL7E5+6Q/+6ncvffhrXzzGO7hl4nm2JrtHRqbzMkYG2Y4McsLIjK9pZJRM" +
       "n+3MBGcx/BFc0nXieiMI6BYXegKut18LrlcocQDW9agvB7oW7Sn4w5lvlZSU" +
       "gy7V2pXaZDsCXn4ZnfrMFvwzJ4A3rwX8zdFlONoRTNZ1YnoEhMYWU+METP41" +
       "DfS6u1hDDjfmgtkqfPZPiHI3gZUiONqB8+sE+2YQyC1Y8gSw6bWAvS0yHQ1s" +
       "sh3/OKw32t4Vpu0d1wn1Egi9LdTeCVB/8lqgXggjzwcurC/r8p5Ld3QW/dR1" +
       "gquCIGzBCSeAe9+1gHsgA0c5jqaawJu7Csq/e50onwJhtEU5OgHlz14Lyrv8" +
       "YK2cTW0qx3Z0HLafu05sj4Pwti22t52A7SPXgu3OzHqHYDenDXgqi8OPIPvo" +
       "y0A22SKbnIDsF67JQnqBqZuubK8N4J6FfOAkC3kE9j94GbD1LWz9BNi/eE2D" +
       "rW5GGdtsAg4tuIfdAV5O1rd4nlX+Ofe1L38s/fSLm/V0AkxYlMufdLfwyhuW" +
       "2abzdadsnPfvI/058eaX/vS/Dt+2u90L3HG4E+45rRP2RuCug379Zg/0K0c6" +
       "/5Mvo/Pn23bnJ3T+Z6+l8++YZF4Y2K0Bj+Y4y3qDeYWifO6qWDdV7AD39Cb4" +
       "UvVSIfv968ejuSG7fCNYIMP1DVRQYppp8B68+y1beWJvEzrUghBoyBOWXT1u" +
       "3j15zbiAit217xjTYO14+n1f/8Dv/r3XfhXoUzt30yLbCwAVOeA99+Lsfu7f" +
       "fvGDD93x/Nfet95Ng65kP9S6+Nas1t85jV0mfiMTv7lH68GMlrC+IUXLYdRd" +
       "b3o1dY/ZO182s+i+PomEFLb3RxcnzRGmLKVRPFIcge7GAs0w03xLgyXV1vWS" +
       "ak3IOoY0MJrgXHFmUhIu4Va550q21Yer3SUiRZLsQD1jAOGGos/wROhjdU2Z" +
       "d6fuklCWqiF0Z4aSHxmUoNCrFtcxibqQGhQuCISNF9tdiqdjVq1IruRIVXUy" +
       "chaLYU+MYM3OlzS0Ck2DooaW+ksUcQarVT+qm4Ltt03UqTTFoJWfMpV+n4od" +
       "xu63Q2vShGGyPIBQtJQvuVPLL07L/KApkZWu4srtViiWZIPriYPebCx2pMgR" +
       "2jYTGCg1GCwEqdihHTq0RZWAqRTvhNVAMDpB25yg7T7eCLuCIzfSdj2EiwC8" +
       "FMFxUhpLONFQ+J5b6vYnyXIkt+Y8U/RKKhsSNZbqMFzdFfvTBSr2Jb9PrEbq" +
       "zF1aHdirjXkTFovSrLicV5ggHgzF0jjlg2VVDoZVsxE38SU/bo1Fo7zQmCmq" +
       "1caywxuO4M8dOFmZxUEtGqlFfJC4AkJD0ZBwZXjm5m2bm61oHpOkuNAOlgyC" +
       "1n2yGRRr7Lyoswt/2I1nTIkjlpAkz632TOrqjgBRk67A94Vg0UObhOaNBzJc" +
       "GzEmRkaIsZQnVaPZYvJQj6x6taoCQ7MQl3ndbI49WGdSKqG4nsut6hwxqwgD" +
       "OGAl0ZwLrRWHdOtkpeFQc7dDulrBWS3tYZsNmx0Tay+lmtMnvNU0KEjcwGqo" +
       "Vtci0kDSq1oD785RVBu0hgO5Lq/SqZwwiVdCSL0pdsLGmBE69Wowm9n9cEAr" +
       "o0KnXTONKllsz3XM7w192YP8WEbmPc7WZg2J5Id8m0AKrM62fa9YL5o6Mpeb" +
       "bRVJhU5ojWfaWCkInhp1LVUJajVft/2+IzS4ZUNOk2g4FtJ6p1boWHjdnEal" +
       "OI6nIRwMYnqmW4nb6azMxZLFKrTTwlsQKbccY+TqrZ4c9ckl4yxKhUTQjQFp" +
       "i3O63S/XHIgZLVRJKbhuaTRPG6jgp1rZVQI4JJOZOIVquocMh8WBTqQiMTFn" +
       "SJ50KVhIA6WwkENdGjuRU8aDVlI2RK3KQvklpKi+rFk+LU+GXafizJwmGcIc" +
       "OhGMeU+o6WIwsImVXDGl/lyazMfMSPXrc62F+IQ70VBq1RWjSdT2FV8bam7Y" +
       "Qwyv3vaxljpqhJVOr9KrpJRqW9WmHbRalExJJE0JBSu1a4FkTSTSgPqFlItX" +
       "UseRyXktRTmeTRAvTN2BHisDu+5XWMytLGB2WInMStwZun28ScVEhVmaI860" +
       "yDnelfqAAaMWiXHKknCbMPPtXqzmmwzBONPaApJFXkvS5arLE+0xPpYZPXHT" +
       "eSEaDHrjqc2VZz1XVKZEWrU79SXTstV5z57VR4qs0A4TrpZGgRgxFYsZgtlL" +
       "8cWoh8P0IM036wWmhlF6XYzFlEhQRYrqxXDOMXG3NgD/ipI6CrC5OrXExGKX" +
       "CdRZlqEFy041C573+JYuNmceP1wNa7K4YMS6o9rdkij5IQbX+HE7LTaJvBI1" +
       "Bv0qteKmBJpAGuSQBI825THS6yc4Zmg8JFfwZBRouAQ0QjWsxXTKTJEyNJlD" +
       "bsqKaaU2lPNYKyxSQslQknyDLEsi7Qsa4aLVCWGKw3F7AWZrCFS1lqhKyWAX" +
       "dFeQItcxcLrJYVpBgQs+0eGlAhpU+3ifhKbTLiVOdHUW8pDKkQOq251H+eq4" +
       "uay1QgiKC3J7Zi8wUaeCXtIsEghNgI4JKEeyl05edQpwZzysQNAQK4G/Rank" +
       "4nNJHhA9P+TKk65Ww8YJY2FLqlZjUmYEpZVhQdUsNpjLXWbuFJwGVu7ZYqNa" +
       "wVjEnLGVToMr4AsX6/I2Q8rVgViurUS9X1igpVkTq0waUWtiy3RRwvLDPm9w" +
       "/nzYURoQ1A+JtNiCIbWk6d0o8RcsAZcnDEVArDKFZ03YnQTFUbMHLDltYXFA" +
       "pxXIERlRmoaLyAceDG9VVvkiOs4zGOtT0/rC6/UiiUPttt1OYr4OY41YmnSo" +
       "sLTszZllJ8XnkUdV3X6Fwby0G5YgFmw/naZUqCiSmjpaIagram1GiDCDW46F" +
       "teHlNFJaaXNStSpi2lRSV6IIkhEJq7AaSmO0OYb9LurCBlAThC1x5XqUUsAK" +
       "L0b1DjNKh107guRBxYby+ZLqTkpxXp9xpZntD+0iNWn3J8YK73MqMe/pk1KX" +
       "MPJoGuPWoitNhnRnxrUoD22NcKPaTSeqEWKsVFNqSClYuHNkWFvSo/5gYiFW" +
       "UJ1yZrKY8LHcyaNsJZCmEDIdQgw0tWVHMUY1oiQJRCUeQfFQ6pUWrBQnAz3p" +
       "FCfA2Ft8syayUxHXllDQt3pIqV0w0R4eIwWqWUfF2YItB/lBVbAr/syb84hp" +
       "TegA1csdWZfcmtFANH/iNpBe4OKaVq2Oy+zMn6R2Ejfa8YqjVYPLjxcK2+hG" +
       "U7yszayg4rYG5QIuV8RAXQVNkeeMaoWgZquikW+I8khbSLO5Q857br09QG0l" +
       "LCRlX4/liIdFoosrJiGPGyY5cxjGZ5zxsFYSx2o/6kUlvKjMunnPFDnEqY4U" +
       "rmJinMJLljLshhUrcsmk5wjCuNUpDsTxEFvMaUrDsXqwwlm719YLo2m5Pw+X" +
       "sDaFIQetWKWRVit7Xb7jlmcl0Y+1fHE6AhDCpRxhJMyseiMwuSapSmKriKdg" +
       "OSg0E0qaaZQHWZpvQ4t8tzOxUk8xZLUxb1Koxhh9staP2ZgfK6biiUOPwxPe" +
       "d7vYbNkrCAMh3x3H3ckSUvN5OKpWSwIih34p7IeG7qYFqQSVU1RvBlAlMTF1" +
       "5Kp80R74cjrjcWVRHVXpJkYOjeF8iearkAxpldmIpKR44LO83S5IsF/quKk1" +
       "HJpjicBaUJltubMk5IqFYtK0FZm35NmiHS440h3F8bxkz5maadfLmiroi2ZH" +
       "bhjiSCSTFCfaRQ1xwpFO+51AS+epGRKztqipHAx3xW5jWJEXw9mKr7iROPYd" +
       "tdcnizWjDtCXy4NKsdWuqPiqWUGFMllJbUTVF8tax6pXq+2UJKTGhEH8mVLE" +
       "Z81AsSwPAb/7YehYdb1ocHFhgqFsc0WUl+UVlIeXbYQMJm2cxQb9ZlhDppjb" +
       "VPJ1SBiYi7ov2LXIwpOp4SMDCvBIxj274+jV8SCajxtEw547sVVGRovuamSa" +
       "BXKu9N0Q0epVjjJZPoEZ3xkFdZ2nDIuba0Mc1zoUJDY6UGWF9eJmgVFYC/X8" +
       "+pQMhr2y2YFK2qzQF2bcuJBi+WZeXLH6XKA1ZKRCjfE0CbhQKhebst8rJLAo" +
       "V1yq2CaicbzMowMBFuF61BtFSiMmSwMNr7IdbzLskJWybwvNDhpPapMSJBIO" +
       "WQox3+jFUcFmlGWeq+mhtZyHCxiZe4jnzJUVoqESRIdQxShjNYXDKd4uarxl" +
       "U64xNpEh0bTnnIKKRgkxqa5DeRWdLQlML1RIaQyVRm0dqo2GUgUtlDpNnBdD" +
       "ErXJkUvHq/GU5APYZlCNYmRRJ9HJaNJ3i+1pfljoMR4R8xCLF5S+38lX9Z4F" +
       "KTHkcgLrM23DqHVIy6m1ZB9qYMgUDdFic0yU5k4NmIsBWUvchSUO0bG6YFYi" +
       "nbrCSKGXIVuq9EulsKgp05LL1sC8Nz1dXcwKUdlYCXg7ZRAYeFAhQbpNKJ5O" +
       "AqtSJtApiaZzS2yhUgSxms3YbGAMEWaFArNfswOqj6f1khoEndDvpmoJmbtA" +
       "d2Q/6gpwZ8bz3XGntSqIuOLBC7dMmbUORsi0UbX5KZ1225YoxMtRaFSDMEAI" +
       "BM6nGpQ0OmD2k/U+ki+PS1xt3q6mkTMj4jCSFpGTt/BVHdJtnCwiw14FX9S7" +
       "Im5TaqyxHDLsL6hKiNKqQ0AeGgc4XdfmXr1oyCusUag1+/JSWQ2hMcyqjbwy" +
       "Hy2qYYkOGrToh3PJSbEJLAQ1yGi65WSZh5zJEIGiOdxaaCpOTVOjHeTzFVVn" +
       "J0U9nqaTjhXKylQSGlR1WPOCSY2im6JPTogiSzcXvqzU541iu442+BFVHDeT" +
       "WqOU4HRviY0lbwhbjg+WLQfu+DW+2IRpR3Kp1opodblmIV6w5qTb70/ntX4f" +
       "rSl8sQoNZabWt8dqk5hNhaqVT3gB7AxYQzLKPrlUZrKpB/X2FAoHjjVulKml" +
       "0UUWcbcJVRZljoCIXlulvU5V0KcstRxgQV0bIBOpJTWCrmqkCTXXrUjqESzH" +
       "0I5JqpVqOz/JO54mcw2J7bYkLkycZBRT+WaUYuJKZBnMKqWw3ybZZaeDz+rl" +
       "FTzKeyrD1YD3XimPqVXUcPg234CwUgdm806rWujmq+3JKmmNi2yeXk3nfAFu" +
       "LgVs0qfr4jDoDhd2kzRIKKqIVprAsiaENb1NWdVFyBaRimJUfKxXrHCqXXTw" +
       "Aj7mi4xCoGDdWGiVhIG0iMZgrUPAcJuNowQS+35CzmdYiYIboc47LtiHYgyG" +
       "IlJTXFYrS5Yd90IJTTAp8UiwnAyp+mKANwjIgWbjWkWwY8Uex6I7ZZvoLBlD" +
       "KdeDVrNhMnf7CYtT9aQj6DQ1kooh1QscmueYQTwauOVaYBZZtj1uMrMhjnKB" +
       "r8RNfhVgC7zHGWbNkgMcnXdNqpkWVTJgILLXXozYMjRI/cIar12uwxo8loSW" +
       "p7uunsTl1GjVebDZJaYltWw1UcZQu7HZY2wkr/ENq6m1Bauq1ZK8LHUl1i2X" +
       "pokdsHnGYouYtpzWEr/ZjY0mY3sgv2HUK3xpghArWmtbkFlVUI/QI6SlsigW" +
       "tmpmb4aOGw172PDZbgeXFBEtlynaheN8GekhwUhAwBiTGJ0sOmRIhiEYM1Yw" +
       "W3RZ6jFCu9fXY37pd3CkjQ0orlAPpo3SoGcRPTWak3AHsZJoVgvzY3I8QIRe" +
       "awCDPYdeoBEfoihk1MbCroGH83qBElJ9RsncsE/lO26v0WgtTDhpt1mqJC1Q" +
       "fybOEIHluobYT8ry0B2MebJltFtDeo4NMdtJWBqTuBldpdpiQ9V5zF2KA4hT" +
       "nVJCTjBPSr2uXnaEPF0tSyRuKM1qJVKanUVLM/Cyb2B5q8hhtcGwDiu1RKsh" +
       "Tq1YQkpEtzRKEGAcOEXstWyM6BQbsFSs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("jGh9xktTbtp0MW6CDMetZBSyoTTW1UCtOxzwZhc4peU7OjGs6uPA1FXWyw+a" +
       "aH5Zh2tthK1pYap1XEMh69O6o3ECZiL9ajjQZgjO8CY3wqhykcKYWqfO1sHO" +
       "qJxA4cIma6HVmDZmwCuqKB0kGvFUraDPZi25NBNWbdkYFdFuqzVrCSM7mdRE" +
       "mPBL3EQYWT5KrkJtOub1SX0KrE07JEbz3jDGu4rdqqv5vqAXkBEvTryW1uH6" +
       "gtiocxjdcxiS7PLjqOkWY20iC2UDq+GlEdJHTAMvMX2QtyG1lQGeLKrNAU7I" +
       "eWMcDLRSPe0QnhRywkhyJHGuUyLWCxQ+nA9gZ4VbrJegtTj2a4EW0wE5Eqiw" +
       "129PqEFcLxYULi/SFqXNB/UZuSQGo3FJIhYrodURObXQLkO+6oEui9yJ0K0x" +
       "yRDNU1aoRwPaLhIs3qmTzXFnFXiJnIANShTT0mo6FtmBTUJzoqZz2gppLqpC" +
       "FYILMZmarE2UGeCgSnlsWu05RKEB4ePxFG2YaFtg2ARsdH3ERKZwM+YGI04q" +
       "0SbUtoxlNAcLaT6vTUPebsa6g6t6JHQlnCvmSbuG0LOOHWJg6+bE6cIeu26J" +
       "I9BCox/0sAVcFMr9RC+jLcPIS6JTXA6s7tjBJYyUC74udKlionYSqIZXOpKB" +
       "TK2SVyRn1NBw8OK81WE9RBo14qHKpTpENJUlVwb7sUKhYzkCUi/M2J7hFksy" +
       "ykFG14VCNGXJZg+aKOpi0uHLSXVAU/Oq6jSDwZKeEYHrG8Mg6tA6DHYMcrE8" +
       "GQ4LQWmOQlPGW1Vhhlg0ozGnVsah16iAbWR2f2ikz1Ox1IP10XJVLocC27Rl" +
       "tNUQeVrgGnpaT4U8GZmVFd9VHJMe2+ao3AImQ64GKC/moTlcRquoJAvt0Ygy" +
       "UnfqpkKnM546+dYKKlm8RXDF1iqSou5gwg3A0htQ6nRRXMz9RXfRza9MtDO3" +
       "3aiX9EolfyDps4VgNdsx1lFdN6aL+V5YsGnEGlUNW8HlIZ93y7oUklIskYug" +
       "gEmTxrjh9GkyUuzBsK1XkF47HUuGGwUBQy3brttMmJm84IpQga3hKmhMbIcQ" +
       "hmFvyW4v/7vru8V99/rO/eXDxC/jnv3y+AZ3t08MbpW3JyeXlx+NrP8u5Lan" +
       "Uvf+H3g0ss75wD7uT+w9onn9sUc0lxP7EnPcM7V79x8MNGzP1bLDEtlJkYdO" +
       "OpC8PiXy8Xc//4LKfKK49yypnz3W9vynbG2h2QegPQRqetPJT6e66/PY++ed" +
       "fuvdf/Zg/xnj7ddxovORIziPVvmL3Re/SLxe+dnd3A2XTz9dcVL8cKGnD595" +
       "uj3Qojhw+4dOPj10eaSy52a5H8gGfDtSydGHWPuKcvwTrDduFG2ddvyxvf95" +
       "Stp3MvFnUe4WXYv2MOL7avnNqz1wOVjfOuJPLlO7P4t8Awjv2lJ71/lT+/4p" +
       "aX+Vie9GuYuAWuPgkZksXtvn+Bdn5fgoCD+95fjT585x55ZT0m7LxC6YPtnw" +
       "HUNu54YzkFtbkodB+JktuZ85f3L3npL2qkzcFeVeAWi1Lh/RyXLG+wQvnIHg" +
       "vVnkQyB8dEvwo+dP8JFT0h7LxINR7nZAcH0IcDNw/D67V5+VXaabH9+y+/j5" +
       "s8ufkvZUJl6/Gb7G4aN0+wTfcAaC62yvAeEzW4KfOX+C1VPS0EzAUe7ObPLt" +
       "ncrKMr5zn1/pDPzWa0N28u6zW36fPX9+jVPSWpl4JspdAPx6R8/67FP84bOa" +
       "mIziF7YUv3D+FJlT0rhMtDdrxCEHJ8v8iX2OVz2EegrHO/Y4fmnL8Uvnz/FH" +
       "Tkl7WyaGVx7HW2c+en5w4ZnqPm3xrLQfBeErW9pfOX/a1ilp2XtuO9pxR+h2" +
       "nt1nOD2rgX09CF/fMvz6+TNcnJK2FnPghAPl3bJjN1w1dX7YzAZnNbOZ/n5z" +
       "S/Ob50/z3aek/WQmngMbqX2aeyfksuyfOqxxF64G9FfWYr9rfvysOl4A4dvb" +
       "Fr99Pl2zs32rLfsNdln37O+y+Nh115usDPoHTum15zPxPmDZZFU91GtHJsBV" +
       "j7ZejX72qsb3tvS/d/6a8cIpab+QiY+cfpb3INerHki9hqHeuWdTdufi+XC9" +
       "YX8Tvr4nsD7ey6/pffIU6i9m4hPA8TddM9pbsQ5y/Ydn5QoD2I9sub7mfLje" +
       "uM5w42WuRwn/s1MIfy4T/yTK3XGZcE84QvmXz0D5ziwS7HV2ntxSfvI6KOeu" +
       "qsX/8pS0f52Jz4NZDuybcMyJ+X2CXzgrQbAb33lqS/CpcyX4e6ek/ZtMfDHK" +
       "vXpL8MRT9/tMf+cMTNeRbwQMi1umxTMz3dnX7HhN6Q9PofuVTPx7sO8Jj2xb" +
       "D+rqH5yVYDaU5S3B8nkS3EzF/3YKwW9k4r8c+37HQYp/fFaKmbXdvjG1c8Ub" +
       "U2en+L9Oofi/M/Gta19Z/sdZuQI3cuctW65vOX+uf30y192sqZ3vXc1R/suz" +
       "MkQAIGzLEDtPhmtfaPf2UxjemYmbgC8UXnkn8ADH3ZvPYxRbW46t8+d43ykc" +
       "H8jE3cAhCLXjyd1z1jsR9+eyd0w25OjrIHdtjt7u48ezX/8GPvATR5409LxI" +
       "iH3fC8Bmp7VUND+bleuKsqZ3H4pyNylZvr3yB15h2LzOvN8zD5+hZ7Jb97nX" +
       "ApzDbc8Mz79n4FPSkEw8lb2smpE95nWm3UtnYJdtprIbpDvKlp1y/uyeOSUt" +
       "e6VkFwWm6fIN0vX7OVnWX9tn+OazurqvA2CtLUPrfBgemLu/tqbSPoUmnYkW" +
       "oBkepXlwAuPXQ3MJ/I9DX1TJPgnxwBUfc9p8gEj51AsXbr3/hcF/WH9U5PJH" +
       "gm6jc7dOY9s++Ab/geubwXoxNdfsb1vLu/w1GwF4eqd86CXK3by5yDDv8psy" +
       "wyj3yuPKRLkbgDyYcwym8tGcYK6v/x/M96NgTuznA41uLg5meRbUDrJkl2/P" +
       "Bnv3jcuNuXngoK5kfZ+7qvG8XOTg10iyJ5brz2ztPV2M2e1re59+od17x3cq" +
       "n9h8DUWx5TTNarmVzt2y+TDLutLsCeVjJ9a2V9fN5JPfv+szt71u72nqXRvA" +
       "+3p7ANsjx39upOX40foDIenn7v+nP/SPXvij9Xtd/w9odx3Q/0wAAA==");
}
