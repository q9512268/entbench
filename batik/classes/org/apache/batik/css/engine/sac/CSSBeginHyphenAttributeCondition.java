package org.apache.batik.css.engine.sac;
public class CSSBeginHyphenAttributeCondition extends org.apache.batik.css.engine.sac.CSSAttributeCondition {
    public CSSBeginHyphenAttributeCondition(java.lang.String localName, java.lang.String namespaceURI,
                                            boolean specified,
                                            java.lang.String value) {
        super(
          localName,
          namespaceURI,
          specified,
          value);
    }
    public short getConditionType() { return SAC_BEGIN_HYPHEN_ATTRIBUTE_CONDITION;
    }
    public boolean match(org.w3c.dom.Element e, java.lang.String pseudoE) {
        return e.
          getAttribute(
            getLocalName(
              )).
          startsWith(
            getValue(
              ));
    }
    public java.lang.String toString() { return '[' + getLocalName(
                                                        ) +
                                         "|=\"" +
                                         getValue(
                                           ) +
                                         "\"]"; }
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
      ("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" +
       "6QzBxaE2DNBFwyuYPdj0U9ime4rEqAEqlkrpqGVV5IStCB5VxNAWW1UWawVJ" +
       "avVmfViRQhs1+K6LTs2CXEKrTVj0Z5UmHuNlQtIJY5So2lpCOqYkWmJZBYce" +
       "cARR+bQGj2okPG9gABuri6QjGEO6t0IEd+MPk6nL20ukqCAMiUlO7JYLxZLn" +
       "UEGg9eC60LPWSjLTEY4oj6Iy1qHKUt8M/ZgersuR0oj8MqpZycJslzcmP2SR" +
       "voJ60qwUNxXeH4/KrE7OtImDErbMl5bmEFYckWc4lyN79aXaZeIGQ8BqVVci" +
       "tae6a2cQ0I4Hry2FpmJ4SU7YRccj0zK3KBZKZaHGOL5XU6sVnUNW9XaFUS1f" +
       "ioaSlshdoZ6UU7TdMyueh5RCfEAujF6E6U7DR1AxHI2WQRi2W3I00EK8MWhO" +
       "UHbDJQFaJpomJSKGh9CmjyULYxmxMw1uq60kKbGTViGm5/wqZc0aXzEZrt0P" +
       "VIxbhhGDWBXOmQtqM1qlHaIwZXTZUQHKDxrtJilVa8zYqYza1VkwqfbDVm+2" +
       "jppznyVmcglGg0UZIRdVzCe1GkFoNpuiM1bFNhVns6prs1ILrS2oZJmgoqrB" +
       "Xs9Ko6rPWVUS6SKypfd7JIc2S3TYRasIO0D8UUSGXbeG+AUebg5Ef8nWSlrU" +
       "aa5GLku3a80Ir7GrVZUuDv2wSa0kpR4ummmppjcpxI0GC7GIztSuXe7ZagPr" +
       "jBWLxeTicJyENMp2jQXWn8/L+KyGpA1ElAsm0mkWBoo9ItyQqEoUEzdZN43r" +
       "jQKnG51CbzzcFJQ5Tg0iilg7eDWtO17UXPeRFK2s2pzL6JE4VZd+t8mTrJiC" +
       "FSSyeMfi4lSy1FQmJbNPlYo2CHncw5pdYZ2OK4lY5GgEL9h1qjosMgo58Xoj" +
       "ds7Zatpggv6imARkp2xj6loUuwPSjwjerHITyyt12IIRgDcha92pKCTc6ldq" +
       "tDAxu+CVKHtVevIHe4W7M38zPbzD+SHeSbddD2XF6w7zfvnnzMm8/9G83y5j" +
       "AWU5lfte6momzyF99B3PPCeNP4bsXcv0NH3ovG87P2nIoWycSH489tLJj2F+" +
       "M7XLQHz+Hf98L/Om1ZM/QMr6gRN6nhT5W8Pnv9h9vfjLe9Ath/mI6+7MjjM9" +
       "fjwLccGV/cC1mGO5iPsOPZt79yHwwNc8C984bXzDKDiVR8F27m+SSAtv0pcX" +
       "Gx+6pMr+4fXCYZL7xBv/afCq5vq7OHJf7m3/6Gh5g3Vo+F1Z4z3gqV0zvPaj" +
       "MXwvJ9g7SNzelV21RGVxX7LN/eziWbb8XfrxnTfxzHuy4m3AaJP3xfwOrLqz" +
       "/O3/B8svZ433gueJa5Y/8aOf8g/cpO/ZrHjah8759tFc9qFt7/tBbIt96MGX" +
       "u63KUu/3XHejvr0FFj/13MVzr35u9lf5hc3hTe35AXROCQzjaDrvSP2M48qK" +
       "lltzfpvcc/KvD4PV+TJ3az5AFV7M7fi1LdOv+9BrbsLkQ2e2laM8v+FDr7wR" +
       "D5AOyqOUHwNr6yQlCKr8+yjdx33owo4ODLqtHCX5bSAdkGTV552DAK/+L+4S" +
       "r5+S+NRxxD6c/MsvN/lHQP6RY9Cc/7PiAEaD7X8rroqffq4/euuLtY9t77VE" +
       "g0/TTMq5AXR2e8V2CMUPvaS0A1lneo9+747PnH/dwbZxx1bh3Wo5otsDN75E" +
       "wk3Hz6990j949e+98Tef+1qeM/0faz7y/fIiAAA=");
}
