package org.apache.batik.svggen.font.table;
public class Device {
    private int startSize;
    private int endSize;
    private int deltaFormat;
    private int[] deltaValues;
    public Device(java.io.RandomAccessFile raf) throws java.io.IOException {
        super(
          );
        startSize =
          raf.
            readUnsignedShort(
              );
        endSize =
          raf.
            readUnsignedShort(
              );
        deltaFormat =
          raf.
            readUnsignedShort(
              );
        int size =
          startSize -
          endSize;
        switch (deltaFormat) {
            case 1:
                size =
                  size %
                    8 ==
                    0
                    ? size /
                    8
                    : size /
                    8 +
                    1;
                break;
            case 2:
                size =
                  size %
                    4 ==
                    0
                    ? size /
                    4
                    : size /
                    4 +
                    1;
                break;
            case 3:
                size =
                  size %
                    2 ==
                    0
                    ? size /
                    2
                    : size /
                    2 +
                    1;
                break;
        }
        deltaValues =
          (new int[size]);
        for (int i =
               0;
             i <
               size;
             i++) {
            deltaValues[i] =
              raf.
                readUnsignedShort(
                  );
        }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wU1xW+u35iG/zg5fIw+AESBHZLkzStTGlgsYNhjS3b" +
                                                              "INWkMePZu/bA7Mwwc9deoJSH1ILyA6WBUNIG/2ghbZADUVr6VChVHwmiCYJG" +
                                                              "bQhtaJIfSUqQ4EdDWtqm59w7s/PYXSOkKivN3Ttzz7n3nHvO+c65d/wGKbFM" +
                                                              "0mRIWkKKsO0GtSLd2O+WTIsmYqpkWX3wdUB+/O1Du2//cdLeMCntJ1OGJatT" +
                                                              "lizarlA1YfWTuYpmMUmTqbWe0gRydJvUouaIxBRd6yfTFasjZaiKrLBOPUGR" +
                                                              "YKNkxkmtxJipDKYZ7bAnYGRenEsT5dJEVwYJWuOkStaN7S7DLB9DzDOGtCl3" +
                                                              "PYuRmvgWaUSKppmiRuOKxVozJrnP0NXtQ6rOIjTDIlvUB+2NWBt/MGcbml6o" +
                                                              "/ujOE8M1fBumSpqmM66i1UMtXR2hiTipdr+2qTRlbSNfJ0VxUukhZqQl7iwa" +
                                                              "hUWjsKijr0sF0k+mWjoV07k6zJmp1JBRIEYa/ZMYkiml7Gm6ucwwQzmzdefM" +
                                                              "oO38rLaOuQMqPnVf9PC3H6t5sYhU95NqRetFcWQQgsEi/bChNDVITWtlIkET" +
                                                              "/aRWA4P3UlORVGWHbe06SxnSJJYGF3C2BT+mDWryNd29AkuCbmZaZrqZVS/J" +
                                                              "ncp+K0mq0hDoOsPVVWjYjt9BwQoFBDOTEviezVK8VdES3I/8HFkdW9YBAbCW" +
                                                              "pSgb1rNLFWsSfCB1wkVUSRuK9oLzaUNAWqKDC5rc1wpMinttSPJWaYgOMFIf" +
                                                              "pOsWQ0A1iW8EsjAyPUjGZwIrzQpYyWOfG+uXH9yprdHCJAQyJ6isovyVwNQQ" +
                                                              "YOqhSWpSiAPBWLU4fkSa8dKBMCFAPD1ALGh++rVbDy9pOPeKoJmdh6ZrcAuV" +
                                                              "2YB8fHDKpTmxRV8sQjHKDd1S0Pg+zXmUddsjrRkDkGZGdkYcjDiD53p+/5U9" +
                                                              "J+n1MKnoIKWyrqZT4Ee1sp4yFJWaj1CNmhKjiQ4yiWqJGB/vIGXQjysaFV+7" +
                                                              "kkmLsg5SrPJPpTp/hy1KwhS4RRXQV7Sk7vQNiQ3zfsYghJTBQ6rgmUvEj/8z" +
                                                              "siU6rKdoVJIlTdH0aLepo/5oUI451IJ+AkYNPToI/r916bLIQ1FLT5vgkFHd" +
                                                              "HIpK4BXDVAxGrZGhIapFk7BTUSYNqjS6mo4oMo2gzxmf6moZ1H3qaCgEZpkT" +
                                                              "BAUV4mmNriaoOSAfTq9qu3Vq4IJwOAwSe9cYWQRLRsSSEb5kRCwZwSUjfMmI" +
                                                              "WJKEQnylabi0MD6YbiuAAKBw1aLer67dfKCpCLzOGC2GfUfShTlZKeaihQPx" +
                                                              "A/L4pZ7bF1+tOBkmYQCUQchKbmpo8aUGkdlMXaYJwKZCScIBymjhtJBXDnLu" +
                                                              "6Ojejbs/y+Xwoj1OWAJAhezdiNHZJVqCUZ5v3ur97390+sgu3Y13X/pwsl4O" +
                                                              "J8JIU9CuQeUH5MXzpTMDL+1qCZNiwCbAYyZB/ADUNQTX8MFJqwPNqEs5KJzU" +
                                                              "zZSk4pCDpxVs2NRH3S/c4Wp5fxqYuBLjqxaeBXbA8X8cnWFgO1M4KPpMQAsO" +
                                                              "/V/qNY698doH9/PtdrJEtSe991LW6kEmnKyOY1Ct64J9JqVA99ej3YeeurF/" +
                                                              "E/c/oGjOt2ALtjFAJDAhbPM3Xtl25dpbx18Puz7LIDWnB6HKyWSVxO+kYgIl" +
                                                              "0c9deQDZVIh39JqWDRp4pZJUMIgwSP5dvWDZmQ8P1gg/UOGL40ZL7j6B+/0z" +
                                                              "q8ieC4/dbuDThGTMrO6euWQCrqe6M680TWk7ypHZe3nu0y9LxwD4AWwtZQfl" +
                                                              "+Bmy4xaFqoc0wDkVPdIDQaenVsoAUFY7IDG36gOcLMrb+3OZpzrMHV1tGZka" +
                                                              "KBDn+wI2LZY3cvzB6SmfBuQnXr85eePNs7e4qv76y+sonZLRKnwTmwUZmH5m" +
                                                              "EKXWSNYw0D1wbv2jNeq5OzBjP8zIleoyASUzPreyqUvK3vz1b2ZsvlREwu2k" +
                                                              "QtWlRLvEI5RMgtCg1jAAbMb48sPCM0bLoanBXoZkN4bwjRFeOS+/mdtSBuOG" +
                                                              "2fGzmT9e/oOxt7hHCheczdmLLSz7gmDKa3cXBz68+t13f3X7+2Ui8y8qDH4B" +
                                                              "vvp/damD+975OGeTOezlqUoC/P3R8WdmxVZc5/wu/iB3cyY3MwFCu7yfO5n6" +
                                                              "R7ip9HdhUtZPamS7Tt4oqWmM6n6oDS2neIZa2jfur/NEUdOaxdc5QezzLBtE" +
                                                              "PjcjQh+psT85AHZYWJBZ8MyzcWBeEOxChHfWcZaFvF2EzRIHW8oMU4HzFA2A" +
                                                              "S+UEkzIoNplksl4IUh40Hh/Ac1hvetBi3aaSAoQcsavE0zNub/tt2Y7VTgWY" +
                                                              "j0VQrrM6L/5izXsDHIHLMfH2Odp7UupKc8gD/zVC+E/gF4Lnv/ig0PhB1Ft1" +
                                                              "Mbvom5+t+gwDY3IClwyoEN1Vd23rM+8/L1QI+l+AmB44/PgnkYOHBayKo0Nz" +
                                                              "TvXu5RHHB6EONhtQusaJVuEc7e+d3vXLH+7aL6Sq8xfCbXDOe/5P//lD5Ojf" +
                                                              "zueps4oU+/jnBUuspgPWESqVLjv2z93ffKMLUnoHKU9ryrY07Uj4PbXMSg96" +
                                                              "zOUeSlzvtZVD0zASWgxWEAkZ21Zs4sIVVxREsDa//9fDM9921fkF/F/UCgux" +
                                                              "WZ/r6IW4GT8LoJvja19AzuQ9yjkHnkZ7pcYCcqoTylmIm5HKBFWZ1I7FEssn" +
                                                              "a+oeZW2Ap8leramArNaEshbidmTlcGkFU0gWC3hdIPzu51M/+NH5zWVXhIfn" +
                                                              "R5vAmfSdnRe+p//lehhZcNXerHxTUBwsD+2NEP+MKP/XExLem0ijLDpE9RRM" +
                                                              "wYbjVBtiw85x7NNbDDFkQWGE8+zy2LPNr+0ea36b1yDligWpCTA2z52Bh+fm" +
                                                              "+LXrlyfPPcWL/GKEajvu/ZctuXcpvisSbqFqbHbybl/e+q1NENi+ty9/Pgtj" +
                                                              "dymDTKpokspn2wDls8o3BN/6sdljlzG4RFjw+UtETN6RmKprFItcZ2yaUz5m" +
                                                              "76VgMJMHPxtziqJOrq5bYTx0+XbR1Sfrq3IPlzhbQ4Gj4+LChgwu8PK+v8/q" +
                                                              "WzG8+R5OjfMCdg5O+Vzn+PlHFspPhvmllihoci7D/Eyt/uRQYVKWNjV/Omhy" +
                                                              "Db/HBZTF3HSBct6pWvH98ARjR7D5FniBjCYUFp+A/GnuUTFPeWybEl+lYHZi" +
                                                              "EyBpxqNAFnH4r5QEboA8iOgpqQnG69xCl3Q83x/fd3gs0XVimQNtj0I1xnRj" +
                                                              "qUpHqOqbChxfXJJglV+fcz8r7hTlU2PV5TPHNvxZxLBz71cFpVcyrareItTT" +
                                                              "LzVMmlT4+lWiJBVZ/FlGmu5+dwOWYdnAOiE4n4PqeCJORorxz8syzsjMAiyg" +
                                                              "uuh46U8zUhOkB1H4v5fuRUYqXDqYSnS8JGegdgIS7P7EcPChxsUOUfhnQn7T" +
                                                              "Zn1o+t2ysccbmn1Bzy/jnQBNi+t4KK7H1q7feevzJ8SlhaxKO3bgLJUAtOL+" +
                                                              "JBvkjQVnc+YqXbPozpQXJi1w/KtWCOxGwWxP6MQgSgx0r1mBE73Vkj3YXzm+" +
                                                              "/OyrB0ovQ2LZREISYOym3CNSxkgDAm2K56s8AQL5ZUNrxbubL378ZqiOn0Rt" +
                                                              "rG2YiGNAPnT2anfSML4TJpM6SAmED83w89vq7VoPlUdMXyFbOqintWzWmoKx" +
                                                              "IOFFPd8Ze0MnZ7/ipRe4e25Nn3sRCIf0UWquwtntBOmDxbRheEf5zm7mAJgR" +
                                                              "xUnRQLzTMOzDTNUhvvOGwdHjPAep/wEaVJnIcRsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "+YHX/wJ/5fHb1yYAAA==");
}
