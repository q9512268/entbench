package org.apache.xpath.patterns;
public class UnionPattern extends org.apache.xpath.Expression {
    static final long serialVersionUID = -6670449967116905820L;
    private org.apache.xpath.patterns.StepPattern[] m_patterns;
    public void fixupVariables(java.util.Vector vars, int globalsSize) { for (int i =
                                                                                0;
                                                                              i <
                                                                                m_patterns.
                                                                                  length;
                                                                              i++) {
                                                                             m_patterns[i].
                                                                               fixupVariables(
                                                                                 vars,
                                                                                 globalsSize);
                                                                         }
    }
    public boolean canTraverseOutsideSubtree() {
        if (null !=
              m_patterns) {
            int n =
              m_patterns.
                length;
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                if (m_patterns[i].
                      canTraverseOutsideSubtree(
                        ))
                    return true;
            }
        }
        return false;
    }
    public void setPatterns(org.apache.xpath.patterns.StepPattern[] patterns) {
        m_patterns =
          patterns;
        if (null !=
              patterns) {
            for (int i =
                   0;
                 i <
                   patterns.
                     length;
                 i++) {
                patterns[i].
                  exprSetParent(
                    this);
            }
        }
    }
    public org.apache.xpath.patterns.StepPattern[] getPatterns() {
        return m_patterns;
    }
    public org.apache.xpath.objects.XObject execute(org.apache.xpath.XPathContext xctxt)
          throws javax.xml.transform.TransformerException {
        org.apache.xpath.objects.XObject bestScore =
          null;
        int n =
          m_patterns.
            length;
        for (int i =
               0;
             i <
               n;
             i++) {
            org.apache.xpath.objects.XObject score =
              m_patterns[i].
              execute(
                xctxt);
            if (score !=
                  org.apache.xpath.patterns.NodeTest.
                    SCORE_NONE) {
                if (null ==
                      bestScore)
                    bestScore =
                      score;
                else
                    if (score.
                          num(
                            ) >
                          bestScore.
                          num(
                            ))
                        bestScore =
                          score;
            }
        }
        if (null ==
              bestScore) {
            bestScore =
              org.apache.xpath.patterns.NodeTest.
                SCORE_NONE;
        }
        return bestScore;
    }
    class UnionPathPartOwner implements org.apache.xpath.ExpressionOwner {
        int m_index;
        UnionPathPartOwner(int index) { super(
                                          );
                                        m_index =
                                          index;
        }
        public org.apache.xpath.Expression getExpression() {
            return m_patterns[m_index];
        }
        public void setExpression(org.apache.xpath.Expression exp) {
            exp.
              exprSetParent(
                UnionPattern.this);
            m_patterns[m_index] =
              (org.apache.xpath.patterns.StepPattern)
                exp;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1444739587000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "9d7ToEhJoQnoyi/2f/ai/eIPgUQRSFTAaiccBACk0xODaJ/67M1/+8d/cs87" +
           "v34G2iWh87YnqaSU4xF0KwACLTQBvqf+z7xtOyCSW0BxMTcVusr47UC6L3+7" +
           "6capRWbrtiM0u+8/Brb8vr//96uckIPwNbLtFL+IvPDM/Y23fjfnP0LDjPvB" +
           "9OqJC6xxj3iLn3L+dffRc3+6C90sQheV/QU0L9lxhjEiWDSGB6tqsMg+8f3k" +
           "AnC72nniEO1fezrdj3V7GoeP0gzUM+qsfv5a0HsBPB/Zh6ePnIbeHSivUDnL" +
           "I3l5KSt+6lh6liKwmL0MBoKWvxa3cJ2VT2RFZxvFt1434o1cSLqzE0Fni3vV" +
           "vUL2Prh2j2cisAOJZdsCyHUuzDcHgEu3XMk+0OXeua1cOhjNPNgsgLBfmtvV" +
           "XNTdYHuUZ2zm4L3tCvuUvqWfWF+QkXccCaM9sFj/4D88/bUPP/YtkDZd6Owq" +
           "CynIlmM99uNs//JLL3z0gVdc+fYH8zkDoOZQKnziC5nUt1/H6qzKZcU4KyYH" +
           "pt6fmcp5caBotBRGTI73mnpoLXLMHiwCs4b3v7A2un1MlcMOcfBHozOtmEzS" +
           "1NEH+MqtJzPE6qDzpEOkHCV3BK5lN7ruyGgPmmvW0ZleO5KEIVNVSiqtbSI6" +
           "iDa4Qza0iRH1yA5b5zSzodeHo2nBb/AUvySnQYtU8S7ZljrOfNJdkP1iLA39" +
           "VnGUmHC/gHeKyFR0cERMscJqMy4gUqw6YhWLxSoiVFeRTffRNi9J9QElRV2q" +
           "J1fVdq89qyR6Uha7C7fQ64eliKkvBWpV2ixnw/GqEuJUizMn45Fr1ApmQ4wW" +
           "o4bYK5gp2SgKvE9avEU7/KIxnlt1t9VlZjM/6DnzZWdaZDdMxfPCtcB2uLTb" +
           "DglGnqhcqzcWFmynwo2mYd0yRRKeLiykybFNodIoWdbS3rC4WxuOqg7lKbVC" +
           "WlyuN27BZmelUYkKByzVnfIcOSpKU0QbUbrvBJ1VMDUK42GnsCIjUeZsiyux" +
           "6IL1Km6xVK4Mpe640RcSdB0uzcDu+IFs9Rb+bD0S2VFpINF4I4xFDW/yk9Zk" +
           "uhGY0USdCNGYGyTSaFSMNB5dDpqFsOxIa0T0hXq6DNIx1xVmhuWLZRJvp4Y8" +
           "nDJzEhZtyzTt5VopSiPVJevTaKUMzZYer8M1rIyb8zEcjojifNkipyxupt2m" +
           "0TInaHsktRbOutGOubbYZWwW7XGNZKJ1OtM+6QaNsDTd9CRWGFO0RQTsrOj0" +
           "B91EVwsqMZ3W+w7jtkaot65r1jzmcV7iJy4hiW0UFesTrhnU0xZdH5geI/ZG" +
           "a1iskpOqT/HdoTKnCyqwpkwZo/psWR20xGDc4P3J0jSoCU2mrWTqVRiDHvgV" +
           "qR61vCa54cpBrZj0+gN0vpzgg1bJImkBq0y7VmNpLmOuM2sUJpE+78Et2/JL" +
           "U8W2SyjAJ7Sk03BlOipaRDfBOI4jXaE2ZSih7NASSzZbnbRDGsEA7g49THY3" +
           "tSlLWJ1padMyYpma4+uKXhAotBU3RLfcdWKqJVs0G1MjmNF0yQiqccQKYbs5" +
           "rYhhwMD1alcTx2TQdbUVgXUKqD9bTIrtquL4sozAtWUbLL4KxtKMWp2JPVZs" +
           "N/HWYncNL9cjL+2zjUnbt0aY1V6CvjbzWnngtVc+O+V4S21aPGMsVLY76VGJ" +
           "7yN1dGJ3OrbTCZZeAw56SimuYKajNeFVp8wSM4+dJiWmYbEI4q8NdT01xVbY" +
           "4niH563aiJkr7rDJeKmJzUfjWi8MFsK63d041aiU8noLrfETtoARluO3B7Nh" +
           "o9fsuIuiMANqjmtcczJvVhaGuljXTNFtVnQYCfQuUwncuTEiZmKnpTdNruMz" +
           "RWlhsW2hGzCytkbwyaZGauSSbiahzrcL5GpGW0ipAWKUrHhktuJhARE7dbdH" +
           "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");
    }
    public void callVisitors(org.apache.xpath.ExpressionOwner owner,
                             org.apache.xpath.XPathVisitor visitor) {
        visitor.
          visitUnionPattern(
            owner,
            this);
        if (null !=
              m_patterns) {
            int n =
              m_patterns.
                length;
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                m_patterns[i].
                  callVisitors(
                    new org.apache.xpath.patterns.UnionPattern.UnionPathPartOwner(
                      i),
                    visitor);
            }
        }
    }
    public boolean deepEquals(org.apache.xpath.Expression expr) {
        if (!isSameClass(
               expr))
            return false;
        org.apache.xpath.patterns.UnionPattern up =
          (org.apache.xpath.patterns.UnionPattern)
            expr;
        if (null !=
              m_patterns) {
            int n =
              m_patterns.
                length;
            if (null ==
                  up.
                    m_patterns ||
                  up.
                    m_patterns.
                    length !=
                  n)
                return false;
            for (int i =
                   0;
                 i <
                   n;
                 i++) {
                if (!m_patterns[i].
                      deepEquals(
                        up.
                          m_patterns[i]))
                    return false;
            }
        }
        else
            if (up.
                  m_patterns !=
                  null)
                return false;
        return true;
    }
    public UnionPattern() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "4zd/9v4zw/eXivg9Nz+W+egm/qtV7brhvc+zLMFRLEdu4aPvDA/eO6npilOc" +
       "3oUTpK5LZUcZAFyX9pIDiU+DtSV/CpLSTlIl29luh6Qm8SR3QoZnOSkwZMQZ" +
       "45nZmkhNGtNwOcUPZZ5t/UDmRjfo42zsj/Z53Vi04pXw1NteV+/3Oh7sxnAT" +
       "I0uhiA7p460f3P7SD+tOgG7WkBF9yDeopMqdtDaJGfVNg3dNHbXnnVu54e9P" +
       "HJn4q7PV+3HV1Xz/Wbydg8184Q8AThbPzRmIomiSmkozyt2tqgCjUAlZPGnv" +
       "gFQe7Ly+eTk/tB73wkKtLdllsaipJABw++w08mDN8JZnSweWOyliLhIx82qr" +
       "5ZUnV38Y44BehiG63VGsJ/guNXs8gaIKmwY8vQWc18dReHv1ic33fvSw4Mjv" +
       "qb7JdNeeW74I7d4jgFaUCnVZ2bqXRpQLPu5mFtqFU6z88OD2px7afrPgqjoz" +
       "8V0Bdd3Df/nPS6F73nkhR3ZVrILfpOEjkM6NavzaFjKVLNz7zx03vd4KwbyZ" +
       "lCU1ZUuSNscznbrUSnZ51O9WIa6j29JhTGMkMM8w7HiN7WJsmoWHNeYFu2Vp" +
       "Dyx3QHmO7YFzso4K4Z14bu+G0FtqmEofxFHXrYO4xsgCizJSnog5iagfL9Pe" +
       "yYOd0NwT404+9sLG0uPCSLn931dGvbftxfv0v50KBu2Q155mr4QIjAg+LrgT" +
       "v4zIFzSvd4qisJNwOOXDV7ENuv6s/AfTo9l9D9a9vGNf3bs8yJYpFmAvnPQc" +
       "pa2H5pPBE6eOjZ76CE9KixEwbG/NvBPILvkzKnlulUpsNOE6ExmZlb9caWPU" +
       "sKuVrBPHfVqsZLtrfx4wxu4CbKJ8+wYAZ5VqPayXz+ywcQN/OhkpAgGwa9kB" +
       "HrcM2kHeZnicGx6aAAwopnnOmCimFD2UvneBwVQOuJiZlS60cD25sXfxseGi" +
       "N++YWJFdReFq0/LUSPPye4B/g+du+Mek9it6N55HeTTd5yD+JX/ZMvjCqtny" +
       "HUF+aSNCfdZlTyZRYyYWlpuUJU0tE/1qhZ25XfJgEjeysG+BHPi2AmO7sdkF" +
       "AVtGowofKDD9R9znrvKkkgGXk41+eKYF4FkMzcLmlswsGlEr487Dg6ee9JPg" +
       "0Z+a71qKR7z9N+zZF299YKGDjBsYpMi60aDSPqp6lirl/R+k2UBEJ8vhabDZ" +
       "aPDHCldQnwQ8IpQVIPUpN5hOpafnxnqpn8sUk2+rvXHn10rPLBKRIXcg8dzK" +
       "XTq8qHLGgYc0R3Y1m8VGm8VGERXohYLrhBqOs0TYpN3h5e0t4soyquuqExe+" +
       "mo3QPSZn4Y2rz0NPPrh414Jr7hP6nJkHQdz5T3z7naN7Bw4OiuwIkYmR+flu" +
       "zbOv6vEapECg8lju01XfHDr5fse1juXGYPNAOnJUufVaB8W6D98/nPs88rdt" +
       "Auux3ZZ7Gh/7eYFj/xg29zIypltJJQ1AXl7lW7lCSXGfrsRdCNh7rgwtoxzl" +
       "4OI7jNU4NB+eJba7Lvm/D2MRsQ9zPtICIg8VGPsDNk8xcjF4cLsp9UHJQluT" +
       "zFL4MWQmpV7F59JSaRe4KZWyArzHbFx9v/vS6uNYthCeqK2D6PljWT5Sn4o8" +
       "MiT4qkcL6PBVbF5iZBScI2+2c8gV/siXFn4CDmEMkW0J5PMXPh9pAdneKjB2" +
       "ApvXQe6eTLkTrtzHv7Tc/F5gIjxJm/nk+cudjzS30R10mpqV114DUvbaX+v4" +
       "ticLrzCHg3cIwD3ETDgheKEband61FyRkqmBGRtf7DQ2H8CBoikqJ1k6JZ2R" +
       "xYfOL2Os0DXiVsZV998vzBlbBc9BW2cHz1/d+Ujz5At5xVyRMkxAZtBPa79G" +
       "zXPYpUOxFAghnL+z+b02wA/1Z4xUyJKq2kT+4zp8Ydx2MjzP2Mp45vz1mI+0" +
       "sNNNLqBHroBRBZSDpV2gBEr9OKXGii1JSeRaz6ZVEyg9f9WkQNneD1d4VTsx" +
       "61O5+LwrP7KvsmzCvvV/FXWq8wm2IkLKupOq6r1J9PRLQECI53ymuFfk9yuB" +
       "GghseatThh+V7esMnDxe0FwMeYmfBooK/uudNwW05M6DmlR0vFOmQzkKU7A7" +
       "A1URqEgFMtP+tMeNP5daPZVCXUbuxf9rgpM9J6N2indw35q1284sekB88JFV" +
       "aWAAVxkF9bz4rJQuCWfmXc1Zq2T13LNjHh05y8niMj44eXnj1gZX5B9nJvm+" +
       "gFj16Q8hx/cvOXxkV8kxyD83kIAEFfmG7KvmlJGESmJDJNe1nJO2NZa/v/GV" +
       "z98IVPOLXSIq82mFKGLynYffjHYbxk+DZGQzGQGlFU3xe/DlW7V1VO4zM275" +
       "Srr0pJa+HBmD7ihhas41Yyt0dPotfgtkpDb7xjP7+2i5qvdTcxmujsuM9hXR" +
       "ScPwjnLNxrBpSKGmwa9ikRbDsD+RBQ5zzRsGd7KF+MfG/wGFyNPbfyQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1444739587000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "67dRxJeL4tUYuJ0en969+ccnMv7am5Dx");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("kSMUUQ9lVN96O3/1NnX/tii+AsQzz4r3kRPxfvtNiFeC5qPgSg7FS95SEx7F" +
       "9+M37LqJQJjV4SHNsoc/vH0P7yt38Q4y1zmIQ+DAxTGig9nRnR52M1UPin2q" +
       "srM/LorfB/6uZ7qaxMcbZk/ewIdfHjGIDsT9WYMTrf7Bmw2MHrheOdTqK2+N" +
       "Vs9tDd4oTTcLQgB9QA2TraeHr6N+wYosgLXlUP/tNj74naL4s7hyryo7zmGj" +
       "8zH2jTfrhO8C168equtX/7844btuo66y/XdvrYMLZSLzF3HliqbrQXeTyPv5" +
       "/1+caOC1N6KBDGjz9LnD4uDUozecdN6fzlW/+NIDdz/y0vzf7zf9j07Q3jOq" +
       "3G0kjnP6nMup+0tANDAjlpT7Uy9BKcgVMGfccg88Ls4EHx5jKIjv2be5D8zQ" +
       "59vElbvK/9N0V4F+TujiyqX9zWmSh+PKHYCkuH17YdwLlezC2aTsWKEPvZ5C" +
       "T+Vxz5xJVcqT5Ueb0Ql7mBG98hLN/OC3Gz+9PwmoOnKeF73cPapc3h9KLDst" +
       "NrSfumVvR31d6j/32v2/cM+zR0nP/XuGT/z0FG/vuflRu64bxOXhuPxLj/yT" +
       "D/7Dl/6oPCf0fwAId5gm8i8AAA==");
}
