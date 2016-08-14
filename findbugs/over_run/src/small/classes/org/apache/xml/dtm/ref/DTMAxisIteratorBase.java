package org.apache.xml.dtm.ref;
public abstract class DTMAxisIteratorBase implements org.apache.xml.dtm.DTMAxisIterator {
    protected int _last = -1;
    protected int _position = 0;
    protected int _markedNode;
    protected int _startNode = org.apache.xml.dtm.DTMAxisIterator.END;
    protected boolean _includeSelf = false;
    protected boolean _isRestartable = true;
    public int getStartNode() { return _startNode; }
    public org.apache.xml.dtm.DTMAxisIterator reset() { final boolean temp =
                                                          _isRestartable;
                                                        _isRestartable = true;
                                                        setStartNode(_startNode);
                                                        _isRestartable = temp;
                                                        return this; }
    public org.apache.xml.dtm.DTMAxisIterator includeSelf() { _includeSelf =
                                                                true;
                                                              return this;
    }
    public int getLast() { if (_last == -1) { final int temp = _position;
                                              setMark();
                                              reset();
                                              do  { _last++; }while(next(
                                                                      ) !=
                                                                      END); 
                                              gotoMark();
                                              _position = temp; }
                           return _last; }
    public int getPosition() { return _position == 0 ? 1 : _position; }
    public boolean isReverse() { return false; }
    public org.apache.xml.dtm.DTMAxisIterator cloneIterator() { try { final org.apache.xml.dtm.ref.DTMAxisIteratorBase clone =
                                                                        (org.apache.xml.dtm.ref.DTMAxisIteratorBase)
                                                                          super.
                                                                          clone(
                                                                            );
                                                                      clone.
                                                                        _isRestartable =
                                                                        false;
                                                                      return clone;
                                                                }
                                                                catch (java.lang.CloneNotSupportedException e) {
                                                                    throw new org.apache.xml.utils.WrappedRuntimeException(
                                                                      e);
                                                                }
    }
    protected final int returnNode(final int node) {
        _position++;
        return node;
    }
    protected final org.apache.xml.dtm.DTMAxisIterator resetPosition() {
        _position =
          0;
        return this;
    }
    public boolean isDocOrdered() { return true;
    }
    public int getAxis() { return -1; }
    public void setRestartable(boolean isRestartable) {
        _isRestartable =
          isRestartable;
    }
    public int getNodeByPosition(int position) {
        if (position >
              0) {
            final int pos =
              isReverse(
                )
              ? getLast(
                  ) -
              position +
              1
              : position;
            int node;
            while ((node =
                      next(
                        )) !=
                     org.apache.xml.dtm.DTMAxisIterator.
                       END) {
                if (pos ==
                      getPosition(
                        )) {
                    return node;
                }
            }
        }
        return END;
    }
    public DTMAxisIteratorBase() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1afWwcxRWfO8efseOPEMc4iROMiZoAtw0EEHJKiJ0PG87x" +
       "EYdUdVIu4705e5O93c3unHMxTWkitURIRYgESIGkfxDUQgOhVRFVW2gQbQFR" +
       "GvHRFojKpypoIVKiCkJJW/re7N7t3t7tRqdEPWnn5nbem3nvzZvfezNzh0+Q" +
       "assk3QbVUjTGdxjMiiWwnqCmxVL9KrWs9fA2Kd/x3t7bTr9WvytKakbJjAlq" +
       "DcnUYqsVpqasUTJP0SxONZlZaxlLIUfCZBYzJylXdG2UzFKswYyhKrLCh/QU" +
       "Q4IN1IyTVsq5qYxlORt0OuBkflxIIwlppBV+gt44aZR1Y4fL0FnE0O9pQ9qM" +
       "O57FSUt8C52kUpYrqhRXLN6bM8mlhq7uGFd1HmM5HtuiXuUY4ob4VSVm6H6i" +
       "+bMzd020CDPMpJqmc6GitY5ZujrJUnHS7L5dpbKMtY18m1TFyXQPMSc98fyg" +
       "EgwqwaB5fV0qkL6JadlMvy7U4fmeagwZBeLkouJODGrSjNNNQsgMPdRxR3fB" +
       "DNouKGibn26fivdcKu2775aWn1WR5lHSrGgjKI4MQnAYZBQMyjJjzLRWpFIs" +
       "NUpaNZjwEWYqVFWmnNlus5RxjfIsuEDeLPgyazBTjOnaCmYSdDOzMtfNgnpp" +
       "4VTOr+q0SsdB13ZXV1vD1fgeFGxQQDAzTcH3HJZpWxUtJfyomKOgY8+NQACs" +
       "tRnGJ/TCUNM0Ci9Im+0iKtXGpRFwPm0cSKt1cEFT+FpAp2hrg8pb6ThLctLh" +
       "p0vYTUBVLwyBLJzM8pOJnmCWOn2z5JmfE2uX3XmrNqBFSQRkTjFZRfmnA1OX" +
       "j2kdSzOTwTqwGRsXx++l7U/viRICxLN8xDbNU986df1lXUdfsGnmlKEZHtvC" +
       "ZJ6UD43NeGVu/6Jrq1CMOkO3FJz8Is3FKks4Lb05A5CmvdAjNsbyjUfX/f4b" +
       "33mUfRwlDYOkRtbVbAb8qFXWM4aiMnMN05hJOUsNknqmpfpF+yCphXpc0Zj9" +
       "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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17e+zkxn0ff3eSTneWdCfJlhXZevriRGJ83Bf3Udmxd7lL" +
       "Lrnkkrtccrls6zPfj+Vr+djlrqsmNtDaaFDHSOXUgRMVqB2kCRwraGs0aJBW" +
       "QdE4gdMCiYOmKVA7cFs0jWvU+qNOUTVNh9zf734P3Z0l3KELcJY7852Z72fm" +
       "O5/5zmO//F3o3iSG4Cj0tpYXpteMPL3meui1dBsZyTWKRjklTgwd85QkmYG4" +
       "69pzv3b5+2981r5yDrpPhh5VgiBMldQJg2RqJKG3NnQaunwcO/AMP0mhK7Sr" +
       "rBUkSx0PoZ0kfZGG3nEiawpdpY9UQIAKCFABKVVAusdSINODRpD5WJFDCdJk" +
       "Bf1N6ICG7ou0Qr0UevZ0IZESK/5hMVyJAJRwf/FbBKDKzHkMPXMD+x7zmwB/" +
       "DkZe/vsfvfKPz0OXZeiyE/CFOhpQIgWVyNADvuGrRpx0dd3QZejhwDB03ogd" +
       "xXN2pd4y9EjiWIGSZrFxo5GKyCwy4rLO45Z7QCuwxZmWhvENeKZjePrRr3tN" +
       "T7EA1seOse4R4kU8AHjJAYrFpqIZR1nuWTqBnkJPn81xA+PVERAAWS/4RmqH" +
       "N6q6J1BABPTIvu88JbAQPo2dwAKi94YZqCWFnrhloUVbR4q2VCzjego9flaO" +
       "2ycBqYtlQxRZUuhdZ8XKkkAvPXGml070z3fHH/zMx4NhcK7UWTc0r9D/fpDp" +
       "qTOZpoZpxEagGfuMD7xA/6zy2G9++hwEAeF3nRHey/yzv/H6R37sqdd+Zy/z" +
       "npvIsKpraOl17UvqQ7//Xuz5zvlCjfujMHGKzj+FvDR/7jDlxTwCI++xGyUW" +
       "ideOEl+b/vbiJ3/F+M456BIJ3aeFXuYDO3pYC/3I8YyYMAIjVlJDJ6GLRqBj" +
       "ZToJXQDvtBMY+1jWNBMjJaF7vDLqvrD8DZrIBEUUTXQBvDuBGR69R0pql+95" +
       "BEHQFfBAffA8Ce0/5XcKLRE79A1E0ZTACUKEi8MCf9Ghga4gqZGAdx2kRiGS" +
       "K8BoPuBer11vXa8hSawhYWwhCrAK20By30P01Ediw0T6M6abOwmZFqjCuKck" +
       "xrXC6KL/v9XlBform4MD0DHvPUsLHhhRw9DTjfi69nLWG7z+letfP3djmBy2" +
       "Wwq9AOq8tq/zGqjzGqjzGqjz2k3qhA4OyqreWdS973/Qe0vAA4AhH3ie/+vU" +
       "xz793HlgeNHmHtD0hShya6LGjpmDLPlRA+YLvfb5zSfEn6icg86dZtxCXxB1" +
       "qcjOFTx5gw+vnh1pNyv38qf+9Puv/uxL4fGYO0Xhh1Tw5pzFUH7ubMvGoWbo" +
       "gByPi3/hGeWr13/zpavnoHsAPwBOTBVgw4Bunjpbx6kh/eIRPRZY7gWAzTD2" +
       "Fa9IOuK0S6kdh5vjmLLLHyrfH4ZOfJ46+V2kPhoV4Tv3JlJ02hkUJf1+iI9+" +
       "4d//2/9WL5v7iKkvn5j7eCN98QQ7FIVdLnng4WMbmMWGAeT+4+e5v/e5737q" +
       "r5YGACTed7MKrxYhBlhBKa3qb/3O6o+/9c0v/eG5Y6NJwfSYqZ6j5XuQfwk+" +
       "B+D5v8VTgCsi9iP7EeyQXp65wS9RUfP7j3UDTOOB4VdY0FUh8EPdMR1F9YzC" +
       "Yv/P5R+ufvW/f+bK3iY8EHNkUj/2gws4jv+hHvSTX//onz9VFnOgFTPdcfsd" +
       "i+3p89HjkrtxrGwLPfJP/MGTP/c15RcAEQPyS5ydUfIZVLYHVHZgpWwLuAyR" +
       "M2m1Ing6OTkQTo+1Ex7Jde2zf/i9B8Xv/YvXS21PuzQn+51Rohf3plYEz+Sg" +
       "+HefHfVDJbGBXOO18V+74r32BihRBiVqYB5P2BjQTn7KSg6l773wH37rXz32" +
       "sd8/D53DoUteqOi4Ug446CKwdCOxAWPl0Yc/srfmzf1HxJ5DbwK/N5DHy18X" +
       "gYLP35pr8MIjOR6uj/9v1lM/+e3/9aZGKFnmJhPxmfwy8uWffwL78e+U+Y+H" +
       "e5H7qfzNVAy8t+O8tV/x/+e55+771+egCzJ0RTt0DUXFy4pBJAN3KDnyF4H7" +
       "eCr9tGuzn8dfvEFn7z1LNSeqPUs0x1MAeC+ki/dLZ7jlgaKV3wOeq4fccvUs" +
       "txxA5ctHyizPluHVIviRo6F8MYrDFGhp6GXZz6fQvdeBI5Tevre42PEB3awP" +
       "3R7kpUe+tfz5P/3VvUtztmvOCBuffvnv/OW1z7x87oQj+b43+XIn8+ydyVK/" +
       "B0slC2N/9na1lDnw//rqS7/xj1761F6rR067RQPg9f/qv/uL37v2+T/53ZvM" +
       "ueeBy7vn5SKsF0F3b83NW1r+i6f7peD55w/75flb9At3i34pXvtHHXLx+kly" +
       "J8+oNXmbar0XPMihWsgt1Jq/FbXecd1XYkAy41A3bqaY9DYVq4KncahY4xaK" +
       "ffStKHbpOhhScXorva6/Tb2Kvusc6tW5hV7GW9HrgetOoHmZDljEM0tR/NCa" +
       "iy8qhS6oYegZSnBGYfNtKvwCeD58qPCHb6Fw+FYUfui6Uywki8YsJtQi1j2j" +
       "W/QDddtDPABUc2/tWutapfi9vnnt54vXHwXuRVKuh0EO0wkU70idd7uedvXI" +
       "oRDB+hiMiKuu1yqLeVcKXSmnsoJ5r+0XlWd0ff4t6wro5aHjwugQrE9/6j9/" +
       "9vd++n3fAlRBQfeuC64HnHKixnFWLNn/9pc/9+Q7Xv6Tnyq9JdCcnFL5wq8X" +
       "pX7idoiLYFcEHz+C+kQBlQ+zWDNoQMZM6dQY+g20ZwznHi+8A7TplZeHjYTs" +
       "Hn3oqmLON1o+nZts2wArPJYbMFrDmbKMI4fddFMZDIbUyKEqHNFu5YOFLugi" +
       "mTVaFdRA2U5dq2fBkMln86WTClNyurAGPEkszbwvTCzWFqe4OK9ZE3WCT4n1" +
       "cIqH7ijaRiEpjhxsSVFzsKBqjVtpPW2l05U+4OZBgAaq4deD9U5em8ZuvLMr" +
       "8ASs1pf1iSoK7ozQc5dxnPkmWGF+LtKdUTxPOma3NtKRHJSjzuLOfL1NR8pS" +
       "pdyut+prgbBYJWK0UhJhRnEVPmfHsicruUeTgonJvcWO2nqSTtSEHT5KNout" +
       "PYppzEYmwqRBjqvkdiYmK3S1yD12mlbYrLc0vZwkN14U9UTYShsNRZ5WFw2T" +
       "ruDBoMJ2oklnxbBoC+eFtI2htaUQLeKVPZXocVNl2r5nr1oZgevVoc+gwzRz" +
       "pExYNEK1IfKi3xw2HVhldnqlVsH6HBNRK19rEk66QOXMjSkhGPItGtUjdcSk" +
       "i2rbr87wrTThGF7rtM2tNbA2q43SQ02xslrSTUrRPWa9bQkN0zcUayP3DHoZ" +
       "ZhTbJ2LeHY/Hk8RiOH2aT+tmrz8OsxHhqEGtaTprXRtltVYLVeZBdT5FvSEf" +
       "E5Y7IhvMJOgu5N6E2bqUu6On8wgnk7EQKWPZ3Qzmi5WIz/1g7GUJOs1dk0yy" +
       "Qd+gOWur7Hozlw0UzF/wep/dMak5toIoaogzNoZXFT7Re9W6LInVdb9qWgZO" +
       "5JNJv7ubacP6kJKjeS6klLkN/RFrLdrweNLFknQaEBQyw4QxU8GcDunDFWeU" +
       "SkQ0xTecX9H4UVrVBvgMxqNuVLNjqx2pzZlNayltR5X1Yib0RHqz7dHUjmlH" +
       "LBX42JwNajuU8s1BLZPqkh+PVz2cn0yXMxeXp6YfdKus5NaWOr9jZ5vZakNM" +
       "EymHYa8lIGtnSmI5PW7nfXUsdNpN3ax6kqCbCRH43mggD9M1JlNNod+ojw1C" +
       "zJAmFa+qGMMu2TpO7dpkUsdHy6RBqxW0i2L+Wu+640TduoIpIWZDrdd9wZxu" +
       "vP6CXU5TVVS7anuFS3OmoThMwIwrqE2xQjJeBis/MiMc3mKRLUVaRXY7uuvo" +
       "qW2Z1HgstJWIwFtIb0oEYXdZF7pDEefhNZoth6g9coP+gCKxXb6kZrudw1Wm" +
       "dTRPPF6t9Ck2nPVFvNKcD1YKB7OjAaahFt6Z8hUiXgkh3K14tQ4lRUQbNCYu" +
       "U/42otbuwJqvfaLH06vxaCQ3pzNKmYurhjmPBn2e5UNv3qp1ZZqosD6DwJ0N" +
       "q09hdC2TPUz2Y7s9F3F72m2tlIUv8/XITOd1adU2pnSarG0mGCZAO4foj303" +
       "9/vMnNnI1o5wKUFeVibOYmXRGpG3EH9YSy2S7fa6ddqOUdSqqZ36VLIMRq41" +
       "jV5TxisLwbOagdYjG8iWN4PNCE7ZYT1DG/ogdCYj32XwhRrMwtEiZPWgu9Nl" +
       "3+tSTayxnBijpmRt8d68H1AVBJEBpbRaq6jfxxB3sZiJFq6SwWC0oCfIrIHX" +
       "V6gZpWsEdnYkYmbVccWT8mmvHRJru8dOo3GCJFLLWyK00zNnFDpmWkaTWhJJ" +
       "dzbpj4KEnHRbatxe5BOb99tGIBIS63UbsZzIK5+aDT1ShUk+UuumiZGdOJ+P" +
       "5i1pF/bdRq+n9hBVmzTazMJE6k0vISZwz522rLVGAm436syQrVkzLKVjI9XR" +
       "ZZ914cyF8w7amKW1thBbgoCjmpp0TdpMuupovatm205iIKyebuDOMJD0pcBZ" +
       "uwXa60fMLPN2G0raOG1uIw3bk5FJ4O7Uy5BudUNjie01GIsGObqb6nRRYy2N" +
       "m+lxY5iP5ivcHSVstc0iPo+CEa/5Om3KlRXS9VvbmhQAc+wgNdw0Ji26U91m" +
       "y7QyQAe5Hcc1re0lC6oVdeIdNgaDy8PYerMjolzdMYYWRvaqTtXDlv6SIkkj" +
       "7+aWkOE0P51KmRdn+YoeJuu40ZboLcXFFAuazkVkYAlLpmkMUkailoFp2E13" +
       "qtSzKTdZD9pwsDX9cZw1hl6rtyOZccKxFif4YZ/1bFTPmh7OSSFh2zV8MRdJ" +
       "spnbg2p3LcLTUT8Qqy1xzXGpAcOysBp41THh8XrkybPE6JGcZDWT7aLLDME0" +
       "nKUpq6oSaoxHbjRdYGQFXiN5JU7ChTTYdatYx0fqO8DETZhWdxM9TlArrhOb" +
       "5Yx1GxWHqBtShzeHQ8S1xk3NXMWiCyuURXNcrkubPCZbqblGdstoORnhC3+H" +
       "9HO3shoO4V2yhlF3YyAYJlFmgGXjcRdr0FlbdGsL2JVUCcFQMO/qlAPny7Wd" +
       "hX4yF7luLAeRyNnbQYv2w/Uu3SXj0bzepfQdIvZ9Ql9wMtEcWLuIX7TqFFqf" +
       "j1ky3TVYL1+PWsNWHTgWTti3MoEXpAbuVNY7A6fWfj8cjsTlCszANSeuMn3Y" +
       "ny/hEHTnWIuxjOvBGKw4k5a8Jgar+aQ72Bp6zHZIQNPpulnT51HANZlVXqMm" +
       "9fmSG5pusFmIlKXaVaJiimh9Vs+1hYC2kuEWdzZZvhHmDa8NOwqvq0YnAaPK" +
       "zWtbCmFaS7ImtzppPZeNHWvOFvNaFHRyXqJS2RzuMrRT8SrCOIytOVe3l3IN" +
       "gddgfNVqUS2Md1V8vulL62SHIOiktkOyLTznF6MVTuh120raQmIbtXWdSL35" +
       "ai7RltTSO61G1cZoox9hzXikZ1u13xNbQ6UqBiqzqFfrOxhrhitGm9pVlgyT" +
       "8abhh3O82c+VfiqqtZ42nkotZkP6jUSLq4nQYLaqOjeJRiLzwabu9DydMxyu" +
       "OpuhlLKY87tQHGqJwnedid5HhYpDZbOmtmTG/ACOSQkdOWY8JedbOsSD1Qx4" +
       "wlZPTsWebLUsVBEszKKWbR7nOxMPz2srtNqLk9pkPE1WI7tXpzYVyhbHYsx0" +
       "2UE+xtqyLdeHTnUXceaECdI524zd0QrWNQFJd0sd4SgsFrU+09lO2y2vK8YZ" +
       "lgrbQidCWOKznb4R3K60aekzLsDrdsNRR3l7FXpOx6WYJubZ6SShbdta5wqv" +
       "wJKSDqklwg96w2p/2Wxu4Z1sckk1Z3J0MtcmXcBaLR2tM32p3aZG4RKudobT" +
       "BVpt1GlxplIiA4ezCdVBlGC07NuoZnDwWIGN2I1gvaK7zUmDNeBwVKPaaT9s" +
       "oIhFGHWkxu3WkjSbb7MFkdTqTQNZt9OhbTWRjFBsc6gLw15LVgSVCkUmF2rt" +
       "fOsaC5fQx/HUlbJNNqs1pjuDH7QVdEdJxrgudow6v2boxoyH8xGZRTQ7mXFo" +
       "lwc8lKgWh6+tRmM7xhV21kS45o7WCSfv2aaEdYzWtkq61cWky8c2T7VJZiLM" +
       "O6i2GiYTJUw3LjmvIBuDnETEGDBItaaMO/Wx1GoghMNsdbhBInIDnYbDZCGH" +
       "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" +
       "g+bbQZqn0KM3uX1aXJ97/E133/f3tbWv");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("vHL5/ne/IvxReQHzxp3qizR0v5l53snbTife74tiw3TKZri4v/sUlbCwFHrs" +
       "5rdiU+g8CAuND3p7WTyFHnmzLJAD4Uk5EhjIaTkgA8KTMjQg8mOZFLpv/3JS" +
       "hAW5gEjxykVly52+mrC/FJbvl4KPnzSdcjZ45Af1w40sJ+9vFou68r8JRwuw" +
       "bP/vhOvaq69Q44+/3vzF/f1RzVN25ZL5fhq6sL/KWhZaLOKevWVpR2XdN3z+" +
       "jYd+7eIPHy04H9orfGzGJ3R7+uYXNAd+lJZXKne//u5/+sFfeuWb5U2J/wdA" +
       "/4SgNDIAAA==");
}
