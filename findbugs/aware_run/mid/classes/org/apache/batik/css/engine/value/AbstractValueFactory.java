package org.apache.batik.css.engine.value;
public abstract class AbstractValueFactory {
    public abstract java.lang.String getPropertyName();
    protected static java.lang.String resolveURI(org.apache.batik.util.ParsedURL base,
                                                 java.lang.String value) {
        return new org.apache.batik.util.ParsedURL(
          base,
          value).
          toString(
            );
    }
    protected org.w3c.dom.DOMException createInvalidIdentifierDOMException(java.lang.String ident) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        ident };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.identifier",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            SYNTAX_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidLexicalUnitDOMException(short type) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          type) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidFloatValueDOMException(float f) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Float(
          f) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.float.value",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createInvalidStringTypeDOMException(short t) {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ),
        new java.lang.Integer(
          t) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.string.type",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createMalformedLexicalUnitDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "malformed.lexical.unit",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            INVALID_ACCESS_ERR,
          s);
    }
    protected org.w3c.dom.DOMException createDOMException() {
        java.lang.Object[] p =
          new java.lang.Object[] { getPropertyName(
                                     ) };
        java.lang.String s =
          org.apache.batik.css.engine.value.Messages.
          formatMessage(
            "invalid.access",
            p);
        return new org.w3c.dom.DOMException(
          org.w3c.dom.DOMException.
            NOT_SUPPORTED_ERR,
          s);
    }
    public AbstractValueFactory() { super(
                                      ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "sK8dg59y5A2Db/c7PFT/FyBDCJQDHgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Ey9SB5WShbJJixmVqXJVLCzU4lIt4DYGl7UyZbLDVnPZUOT2bIb483JhhShY" +
       "kUlnKWEYXoWPU7RRDzsbbk2mSVmNdNznWQw3JIxZrliH4xGKKBq2AXLPFbGO" +
       "vUI64mEXNqqzZL4gBb7XMoQC3S8MhVDRpolOwTEZ22TEKZy2sCp6ybV4MYA1" +
       "uoQvaiZP1Vr4xNXsKdoNGuhcaAeDuqRWGutKs9QWELFGdxiks26BpR23e2qz" +
       "mb12vv7Zvflfn29yHJxegRf+rKP7LN5400tPuLO3uXKW39uKTw92ffPfuVN2" +
       "fY/sjEHZK/6tT3dilb/ef/RtjzwmUR8r7uztKM5C6OrQcV9lyrFsHmF1NeB0" +
       "39NvZZD5gd3hTteX3/YvtzCv1R56Fnv5t5+Q8yTL3yEf/2r3HvE3d6DLDva9" +
       "LjpKPD7o/uO7Xdf4chj5NnNsz+vWA8u+NLPYfeC6e8+yd196P/2UFcsKeesd" +
       "p+zahqf0xVnhhNA5VQ5p38lPZkd7KnQPfcp9pl2Uo3zzBvNAz5dljfeA6xV7" +
       "er7i2egJ/MP1nVAWQ1nKI+KS6u5sifd3+26/6NBpe8qYH3Gzk2GuXc7orafY" +
       "5u1Z8cYwW8f8nJqdECfM8qbnYJZ8+V8LLmTPLMizMMuZrPrmS5rizCHBVsX3" +
       "nqLib2TFu0LobtGX+VAm7Jg3dYmQZDvMNhX9NkXiqSi7B7EEjHtzZtykLO5K" +
       "jrV7EUFul3c/V7u8Dlz1PbvUn1e75PeTIzjJhdAVgeb4YT7qI6cY67ez4tEQ" +
       "unDMWEM51UUevBvq4VFjZLTvP7TIh56rRV4DrtaeRVrPu6c8lhM8foryn86K" +
       "j4fQXceU75gOH2YAd4rqn3g+gmSwp/rgF+8MSqZTPuoLp9jji1nxeycjJ7dH" +
       "foByikE+93wYhNkzCPML8oUvn6L7V7Pij0/qvj1XeQZn+NJz1b0JruWe7svn" +
       "R/ejqv3FKX1/mRXfCKF7tmqTvJmdocv/RwT4s+eq+avA9dCe5g89/5o/eUrf" +
       "P2TFt0Pohq3mp2j5d89GyzSEXnypjz+y0+ubL/o8bftJlfjpx86dfclj7F/n" +
       "3z8cfPZ09RA6q0SmefSw8Uj9SteXFT3X5ert0aOb/30/hO58xg9Uwr1DvVz+" +
       "720H/iCEXnrKwBC6cls5OubfgLqXGhNCl4HyKOVTIXT+JCWQIv8/SvfvIDk5" +
       "pAOTbitHSX4CuAOSrPpTd/8RfuRscnu0m545nsYfrOcNz7SeRzL/u4/l6/lX" +
       "iPu5dbT9DvFB8TOP9UdvfKr6se1XIKLJbzYZl7ND6KrtBykH+fmdT8ttn9eV" +
       "vXt/dt1nr375/rvEdVuBD0PhiGy3X/ozC9xyw/zDiM0XXvK5V3/8se/kh7P/" +
       "C4PXa6UeKgAA");
}
