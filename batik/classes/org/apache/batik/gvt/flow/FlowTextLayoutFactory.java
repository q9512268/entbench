package org.apache.batik.gvt.flow;
public class FlowTextLayoutFactory implements org.apache.batik.gvt.text.TextLayoutFactory {
    public org.apache.batik.gvt.text.TextSpanLayout createTextLayout(java.text.AttributedCharacterIterator aci,
                                                                     int[] charMap,
                                                                     java.awt.geom.Point2D offset,
                                                                     java.awt.font.FontRenderContext frc) {
        return new org.apache.batik.gvt.flow.FlowGlyphLayout(
          aci,
          charMap,
          offset,
          frc);
    }
    public FlowTextLayoutFactory() { super(
                                       );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "cYmlpc7XuM294FI2dtJhBU9b+nh7Lu8s9imfxlmuNQPseS5By4tWB9o2hgoq" +
       "A3X2gqmaHNagTT42PpEYeGYlb0WavI1DD/TFz/70n2+Ejv7itSJ1agbR9NsV" +
       "PIwVj54g0lNd+ln/5yDc+3WHf/29jtSGj1JY6FzrLUoH/b8QjFg2daHwq/LK" +
       "Y39o2bY2vfsj1IiFPnf6l/xm/6nX7lsqHQ6yZpeXh4Im2cvU5XYsCDUwdPUq" +
       "NZPO1LId1p5PmhaaI8vgK1hJI/h3GAdzloF06MmzstysmobVByClLKKlduYt" +
       "YRuCZVr+uJjoToN7JGjb+whmaO094dLADmbjJmFAxtvfB6vPv2R+/bfP85xr" +
       "K0Ls66lPHK+U3suc/w1nmFeEgdM1nxC+uP2dPW+wcFbS/Mk70ZU7kGeuAtiQ" +
       "904ddUajjWH2L0E7/suukZ4axREipLCWgRMKSUODkyJpuyn9Xy5P9/+SqbeD" +
       "KyYT32h/8+GJ9l8y6K2UTdhg4KciZyQXz/VTl69eqF1wmm3kUupuy9Xew2Xh" +
       "2dFzJGRRqKdDLGcWT4eIIWegsxi20mFVZLd0oCPC0oHy7aRDiDJ3TnPJ4F1D" +
       "2Nd0eejpK8/ylPKf6XzE+MD45z8MHRznGMgPvu0FZ083Dz/88gTLa7d4OimM" +
       "o/d3Z/Z9/8S+/bZl9xNUIlt3EnRDBvIQO8vrJq7nxifqf3CoqaQXAtKHKrOq" +
       "vDeL+xJedKkws3HXrnDOyQ7WWBrTFoqgwDK7tnkVmO/BeHY95YDgybfv/snx" +
       "Lx0Z4d6dJio+vrl/H1Dij/3qbwV9B8PjIoHy8UeFU0+3dK+9yvid5plyd+QK" +
       "D2SQ5A7vqpOZvwTbyn8URBVR1CBZ10HbRSVL+9YopLFp3xGFUa3nvfc6g5/d" +
       "u/LoP9+fKS6x/rbdHalS4olKI98iAcSgerR4hxFkHQaBRWVVVBhfCHplhUEC" +
       "/beHDglXRIOcz8Z43npSO6BR0FRMu1j7HT9fyloofxMFLwtzg/4f4MoyYa5K" +
       "xPSZpkvdP827J+jwOJgmUb24GdOQf6Gwp6MTG3RX+xdwujLLI2BlM7MSEDVE" +
       "ETUU0WADrtpov12Yf5uE7Ar1wrAVq9CiWld3TPanptFrnA6DBDLMwHAWcVo2" +
       "W8LHpu/vBnVRdTF8gg7buPJr/sNe1/ILmF70eoH2wnML7jP5HZx0eqK+cs7E" +
       "A+/wGmDfk9VA+U1mFcWdza7nct3ASZm5o4bnts5+JgiaN+XdB0Gl9Iepf4zT" +
       "fw1yshg9oCaMbspJcLifElKJ/brpjhNU5dDBzuEPbpKTsDqQ0Mdv6XbQGpxt" +
       "w7d/LlB4HmCxar5VrPIs7sMxjT67ebYxP8vvnmPSmYnNWx66cdcz/HAuKeLY" +
       "GF2lGpCeXwHkO9fFU65mr1W+qfNm3XMzltjlx3M54NaNZQzsHHaQbvGdVs2O" +
       "/KH13ck1Z398oPwC4PEOFBABXnYUAmVOz8KRYUe4sKIBULJjdFfnV0fXrkj+" +
       "6T121CosQH76mHTx+M63D8+dhON2dR8qg8qKcwzBN46qW7E0bERRrWz25EBF" +
       "WAWwzFMu62gai/ROmvnFcmdtfpbe2hDUVtgAFN51wbF0BBsbtKyasAputTPj" +
       "uRK3m/+srvsYnBlXw6TxGs071JJYuF/X7SuPqrt0tqX14jhHx7PskQ4v/Rsh" +
       "4pPslRoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
