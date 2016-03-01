package org.apache.batik.css.parser;
public class DefaultDirectAdjacentSelector extends org.apache.batik.css.parser.AbstractSiblingSelector {
    public DefaultDirectAdjacentSelector(short type, org.w3c.css.sac.Selector parent,
                                         org.w3c.css.sac.SimpleSelector simple) {
        super(
          type,
          parent,
          simple);
    }
    public short getSelectorType() { return SAC_DIRECT_ADJACENT_SELECTOR;
    }
    public java.lang.String toString() { return getSelector(
                                                  ) + " + " +
                                         getSiblingSelector(
                                           ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "ySv8Anv0/Re34+myDBYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZeawrV3mfd1/eSsh7eUBIA9lfKMnAHXu8jK2w2bN4G4/H" +
       "nvHY47Y8Zp+xZ/MsnrEhLUQUoiIFRBOaqpC/QG1RWFQVtVJFlapqAYEqUaFu" +
       "UgFVlUpLkcgfpVVpS8+M372+976XR6NWqiUfH5/zfd/5tvM72ws/gM6EAQT7" +
       "nr02bC/a19Jof25X9qO1r4X7XbrCSkGoqbgthSEP2q4pD33x0o9+/DHz8h50" +
       "dga9RnJdL5Iiy3PDkRZ69kpTaejSrpW0NSeMoMv0XFpJSBxZNkJbYfQ4Db3q" +
       "CGsEXaUPVECACghQAclVQBo7KsD0as2NHTzjkNwoXEK/CJ2iobO+kqkXQQ8e" +
       "F+JLgeRcF8PmFgAJ57P/AjAqZ04D6IFD27c232DwszDyzK+9+/LvnIYuzaBL" +
       "lstl6ihAiQgMMoNudzRH1oKwoaqaOoPudDVN5bTAkmxrk+s9g66EluFKURxo" +
       "h07KGmNfC/Ixd567XclsC2Il8oJD83RLs9WDf2d0WzKArXftbN1aSGXtwMCL" +
       "FlAs0CVFO2C5bWG5agTdf5Lj0MarPUAAWM85WmR6h0Pd5kqgAbqyjZ0tuQbC" +
       "RYHlGoD0jBeDUSLonpcVmvnal5SFZGjXIujuk3TstgtQXcgdkbFE0OtOkuWS" +
       "QJTuORGlI/H5AfO2p9/rtt29XGdVU+xM//OA6b4TTCNN1wLNVbQt4+2P0Z+Q" +
       "7vryU3sQBIhfd4J4S/N773vpXW+578WvbmnecBOagTzXlOia8mn5jm++EX+0" +
       "fjpT47zvhVYW/GOW5+nPXu95PPXBzLvrUGLWuX/Q+eLoT8X3f1b7/h50sQOd" +
       "VTw7dkAe3al4jm/ZWtDSXC2QIk3tQBc0V8Xz/g50DtRpy9W2rQNdD7WoA91m" +
       "501nvfw/cJEORGQuOgfqlqt7B3Vfisy8nvoQBJ0DX+h28H0A2n7y3wjaIKbn" +
       "aIikSK7leggbeJn9WUBdVUIiLQR1FfT6HiKD/F+8tbiPIaEXByAhES8wEAlk" +
       "haltOxElDLN5GmoBQmi6FNsRYQVAXkOdgwx2I06ztWwy7Gc56P+/jp5mvrmc" +
       "nDoFwvbGk6BhA/q2Z6tacE15Jm6SL33+2tf3DifRda9GUB2osL9VYT9XYR+o" +
       "sL9VYf+WKkCnTuUjvzZTZZssINQLABoATm9/lPuF7nueeug0yFI/uQ3EKSNF" +
       "Xh7V8R3MdHIwVUCuQy8+l3xA+KXCHrR3HJ4z9UHTxYydzUD1EDyvnpyWN5N7" +
       "6cPf+9EXPvGEt5ugx/D+Om7cyJnN+4dOOjrwFE0FSLoT/9gD0peuffmJq3vQ" +
       "bQBMAIBGEkh4gE33nRzj2Px//ABLM1vOAIN1L3AkO+s6AMCLkRl4ya4lz4A7" +
       "8vqdwMevyibEm8H3keszJP/Nel/jZ+VrtxmTBe2EFTlWv53zP/VXf/aPpdzd" +
       "B7B+6chCyWnR40egJBN2KQeNO3c5wAeaBuj+9jn2V5/9wYd/Lk8AQPHwzQa8" +
       "mpU4gBAQQuDmX/7q8q+/8+1Pf2tvlzQRWEtj2baU9NDIrB26eAsjwWhv2ukD" +
       "oCjL1yxrro5dx1Mt3ZJkW8uy9D8uPVL80j8/fXmbBzZoOUijt/x0Abv2n2lC" +
       "7//6u//1vlzMKSVbCnc+25Ft8fU1O8mNIJDWmR7pB/783l//ivQpgNQAHUNr" +
       "o+WAdzr3wWnA9OgttkOB5YBorK4vIcgTV76z+OT3PrddHk6uNyeItaee+ZWf" +
       "7D/9zN6RRfnhG9bFozzbhTlPo1dvI/IT8DkFvv+VfbNIZA1bYL6CX18dHjhc" +
       "Hnw/BeY8eCu18iGof/jCE3/wW098eGvGleNrEgm2XJ/7i//8xv5z3/3aTSDt" +
       "TGh6wXYv9jqw2mUAl5SUHNdCSdk/wK8DgvtuILAc39YOyHJbkZz4sbzcz4zL" +
       "IwPlfe/MivvDo9BzPEhHNozXlI9964evFn74hy/leh/fcR6daX3J33r5jqx4" +
       "IHPa60/ibFsKTUBXfpH5+cv2iz8GEmdAogLWlXAQANxPj83L69Rnzv3NH/3x" +
       "Xe/55mloj4Iu2p6kUlIOcdAFgC0acJ2tpv4737WdWsl5UFzOTYVuMH47Je/+" +
       "nyQplW0YdwB5978PbPnJv/u3G5yQ4/pN8vYE/wx54ZP34O/4fs6/A9iM+770" +
       "xrUQbK53vOhnnX/Ze+jsn+xB52bQZeX6zl2Q7DiDrRnYrYYH23mwuz/Wf3zn" +
       "ud1mPX64gLzx5MQ5MuxJaN8lLKhn1Fn94i7g5fQUgL4z6D62X8j+93PGB/Py" +
       "alb87NbrWfXNACPD/AQAOHTLlexcTjkCGWMrVw/moABOBMDFV+c2dpD5l/Ps" +
       "yIzZ326jt6tDVr5rq0Vex182G9oHuoLo37ETRntgR/6Rv//YNz768HdAiLrQ" +
       "mVXmPhCZIyMycXZI+dALz977qme++5Ec8gHes58gL+djT29lcVYMs2J0YOo9" +
       "malcvquipTDq5yitqYfWFo7YU40A1nv/C2uj2z/YLoedxsGnL4gSmoyL6QSO" +
       "MXlad+iksSHGzQbb8gadxaAwXhT6VsGSqVSm5nNbKxhFfjTDQkyZDmHNHdkO" +
       "Fi1pMlU7xTFRMSTa8OlhD1lMxozVMZfmsiiZ08XSnvA9sjBiWsFm3GUmyKxd" +
       "MEY8nPaKnlOpYFitMp/VNbm2jCeqO6thG9d1Y7W0iYo0U8QZWSIHJBz25hE1" +
       "7wbUHNclLenOGJsqMygiigEu2/1SrQo4wFl17CZrYz23Z32xHXXSuewLZcdB" +
       "B4y3kgKZGoTrcFgbenN8YJJCKC6KQM+gOqCWEeoxs3GRse1heYY7JNnESGFU" +
       "Q8XxImIqnDGjG5YBVFGkNZPKEqd1SKrUJqYd03X7ImoEYjwvYnxbCtqaxgsU" +
       "jzQsLbF7g6XvjQW0JLmyPnQlyWwD3Gp66IjtFNSCVo4Gra6OMGWOKXG1Ejv3" +
       "A05xncCQBaerMmujVBiVzWhJMSQ3GbSCkrAaBV10oY+YYlNo46UNKbDj1lQZ" +
       "2FpziA8rRYydeEN2ZY/6dVtLijHhjhej8XrWG/Mj3+mY3WCWRFbDSabjFj6d" +
       "FEQicptOWIojsVoeVkWY5dRClJbajlsVR8KyTWrMco71il2qiQ+X7XmHITh+" +
       "RtF01B6LwNe+X8RZwwsFLlzyA0qidVFayG2mofhl2qJoDcRiRW5Yod7s9km0" +
       "t1b5pEQzHDJY9FbpdFGfJU0njeqTRKBW0kblG8nS61qC6ROYKYhLSxWmGlUR" +
       "+hsTjaxKO7EaET+jqx3ebNuTSCyaDZrrUkwvdX2K6rDzAuET45bfIygFLXQ9" +
       "ZTPt+qKriOKiJ3iyT8YdWsKXlXLFoJtcRPjdlBvhdrTAxzrbqigTooSO9WKD" +
       "R/vDJb4ZOhxTlWt9h/EIHu8veC7BVa4htrDA2sDERCjAbXJIW8UhZQ11dp6i" +
       "ZVihdCyJY3xmF2ZO3B6THM377SSNwDRvyyUZW0aWFHEzc4muy011tlmG4Vid" +
       "+xs/bjA9NB7R4kzZiNORixWjUX+1oGFqPB0OR5MRsUbH5rzi2x00XrYCUusS" +
       "y7SPT3udnufGEU3XE3VEy5u2MEM7RY0qoNasQFJCoOO2VWOR5miyGCZCMjan" +
       "qsCnq0Fcdv1mG2GdxDInK8torsxwNOixerFf6BQK4oTrmi0tXsoLo7tGCTQs" +
       "N9cbnERXeJxIqc/hqy5Si7EoFFBO1oYhR867IdHhzOVa7LS6/MJB5SJnN7z6" +
       "qF2YW26Bx4SGu6ivzXZH7KID0kMT0bPSNsEjQVV3nUl9wnsqTtIiZixxs6Gj" +
       "DY9zSS70NzFfxGSsOtap/qKLx5ZhK35s1MdWYyGI9ppq9YwhuQ7I3nLZGFoU" +
       "XLOWjrUwJjg7XhgNyVDDAVoQ9VKbx9TxUJhJi8p0WEnEqipxdCQHnrjiSZ9e" +
       "+5NwbhV13QrKw5FDNrzmqNCXYEFtSkUyIrv0uO/gDjEbL0pUQ5j5VX7GCQZc" +
       "UNpYtdJvz6dwtwrTIUEWDSLpyyKZbPgS168aVXPIO9h8KdaQlb7pB4O2OSy2" +
       "MEX2FzinEa5YMdwO2+rCk3iuW0KlF2/cCTUmBKMFk4W02IwaYmmVzHG6XJ1K" +
       "hsvYXDORXIKLaUaW7XILHvP2vBXROk5i+GxVhXESr8/ruknBrcSn8DkyC+Ko" +
       "68YxOXRpxZoZzUlNmKaLIo1tNg4445cHFTReLOdymohdmZdNdNSfNFbtoCWu" +
       "mooSDj0iJmCFr1SqsKJ5w80GNlBqEyckhmKNMWmkOA7kFOGIKrHIxihHkUmj" +
       "ih+xXQVfStaqFS4mBX2EL6Q1y+qFBjdaVJTe2l/1zbbc5XgpLPsjatJl68sS" +
       "SGdbhnV51K14/VZvUZiVdLnckJECrdXxLpPWZ/JAtYZzOki7GMsSnSa2Dutr" +
       "Hp2YYi1l9Y4bVBEEc1blxnzYa7RU2eVIRa7GZaLqh3YE1j5nOi9PjHimDkh/" +
       "IpokNaAq7qSi6m2PRiMX9jctoVOhxoNqyaxisDrA591GvdCWolUUVsIpXA1K" +
       "zXJQrsVrMFMaG7ixanYRJGzUNywVDmUJYEsdp5kgYNYEv/FYFMUjZh4OXU7u" +
       "x+1FrQ4jvU7SUa2wUeMXdWY926Bdt1LgCynJbeIJ59XYQWc5lsQkreizyI+W" +
       "7rBXgedIlaXDDVZGtILvFQVacREdh1nXwhCsXq3PKyxWGTWjSoA1XIJ0WZ/w" +
       "5SFtcqVm3J/PO364Qgi2XIBr/WQj9sX5Ugn8KkMqLUquj1v9IJz2vWm/VZfK" +
       "RgTXimbSa/jFkLcSWx4nOt2E+1iRqDilVurSfYlTBsNp2DWGQYmMe0NFb5eU" +
       "Ft1lhlEapoSO1mqaK4u65a0IzF/pC6THyyV4jQwaroBW1sVU0BvsptMvjxhS" +
       "Vp16NMfLgeigrNgKiUJTZZWwzZrVBTZL8DU3MArDGRokdZkk5Y2pm0KnVfVX" +
       "Ut1FYKuu48WeycejYptJSA+p+DhbNagAH4/YMUI7yLDWWXad2CgoPJNOhFYf" +
       "XmoFplJiLJnhnFW96+gB646wWHdZuDHsglUrCIkBUnd7bbsQF1cthGsTVs1h" +
       "1MVwSAdCfdkbSF2dbafx1LZh2o3K456HLVXDn7S1YEb63somzak9a5Ia1ZmW" +
       "hRoTKEEc04JWQyJZMlXSNxbRcuo0WlXbkIhyo7VidWwaBa0Vb67huS4hnUkT" +
       "GQ+GrGlV6zWtOYGlRbKqoZ2NXV/ja9+pWuV4tTTBzmjpUBVVNtM4nVlqb2xR" +
       "1ni1mExxWZQdRrYCAS9I4wBjyW570a/PRAMbbIIlBncURZ91rGGiIFF97XJo" +
       "v6ZN2tMhI6GUKOttcUIwZgXGxFUqBE12ucLbDuJNhn5JJxlFaKJjCe5Ra6ea" +
       "9NVaSy2PYLiMdcYYB5eXm0HYoqK1UuuVLS9cbXh9QqsOsmzrtZI7WklldNiK" +
       "BpUNz9ilFcx21iK1cIJS32gZYuIglaUtUSjVS8bykjXoCB6myXSAe/bU1nBr" +
       "aSw1veavjJhr2AzhwpikgvWj540SrW2ZCrKW1ebAx5PiZuCQFVG1JxWC5YnG" +
       "pEMMvLUPwCdoYWPLHJsb2xA2dU1sFxqa7nTsubVK+xWy2+FXKd80iAmC1fA5" +
       "U1LgLjybT5T+po+kpaY274j2qCRO5vwi6iiTWaspy+pkRa2RVGxbs2UrEdZE" +
       "oFOLWtMaEGuh59F8o4b6pZhg3ThVi9PS3FPjYSXC0kZvKDsrdsBj9liudRsk" +
       "LzXKSc3Ga6VB0uz0Sy4aY56b1HVEUTFvJGteBRcFcCRWON5WirrGV0dMrRSZ" +
       "AgF3pCXBL9ikbC19tLSh6mbf5IWI9MjCYjZQS3VusqDWJb3f85uYHxPDilZe" +
       "xsX6qEiR1WJlqg0kqs6nTEBUGK3VQXsG2DM6q4qKRbbW55SUL/Sr3ZghfHsh" +
       "Sr2IK7EDZ82tag13VUBGWqkMO2uiKYJDx9vfnh1H1Fd2TLozPxEevrKA01HW" +
       "wb+Ck9C268GseOTwSi7/nD15M3/0Sm53UwBldxn3vtzjSX758+knn3leHXym" +
       "uHf9hgWLoAuR57/V1laafUTUHpD02MtfOvTzt6Pdyf8rT/7TPfw7zPe8gtvk" +
       "+0/oeVLkb/df+FrrTcrH96DTh/cAN7xqHWd6/Pjp/2KgRXHg8sfuAO499Oyd" +
       "B95ErnsWufmN7k2z4FSeBdvY3+ICa3OLvvdlRRxBlwzt8OL/QNfSLmNWP+3s" +
       "fFRu3hAcmngla7wHfKvXTaz+35v4oVv0PZUVH4ig85G3uwXhd7Y9+UpsSyPo" +
       "3lu+mmRXwHff8MC7fZRUPv/8pfOvf378l/nDweHD4QUaOq/Htn30zuhI/awf" +
       "aLqVm3Jhe4Pk5z8fjaA33OJxJ7tZzyu5DU9veT4eQa+9GU8EnQblUcpnI+jy" +
       "ScoIOpP/HqV7LoIu7ujAoNvKUZLfANIBSVb9pH9wN1W61btUQw6jQFIizpJt" +
       "ELDDq9pTx3HmMIRXfloIj0DTw8cAJX+xP5j88fbN/pryhee7zHtfqn5m+1Ci" +
       "2NJmk0k5T0Pntm82hwDy4MtKO5B1tv3oj+/44oVHDsDujq3Cu5w/otv9N3+V" +
       "IB0/yt8RNr//+t99228+/+38Nu2/AbGmZvpKIQAA");
}
