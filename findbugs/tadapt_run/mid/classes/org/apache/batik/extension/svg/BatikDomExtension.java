package org.apache.batik.extension.svg;
public class BatikDomExtension implements org.apache.batik.dom.DomExtension, org.apache.batik.extension.svg.BatikExtConstants {
    public float getPriority() { return 1.0F; }
    public java.lang.String getAuthor() { return "Thomas DeWeese"; }
    public java.lang.String getContactAddress() { return "deweese@apache.org";
    }
    public java.lang.String getURL() { return "http://xml.apache.org/batik";
    }
    public java.lang.String getDescription() { return "Example extension to standard SVG shape tags";
    }
    public void registerTags(org.apache.batik.dom.ExtensibleDOMImplementation di) {
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_REGULAR_POLYGON_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikRegularPolygonElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_STAR_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikStarElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_HISTOGRAM_NORMALIZATION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.BatikHistogramNormalizationElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_EXT_NAMESPACE_URI,
            BATIK_EXT_COLOR_SWITCH_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.ColorSwitchElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_TEXT_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowTextElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_DIV_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowDivElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_PARA_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowParaElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_BREAK_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionBreakElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_REGION_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowRegionElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_LINE_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowLineElementFactory(
              ));
        di.
          registerCustomElementFactory(
            BATIK_12_NAMESPACE_URI,
            BATIK_EXT_FLOW_SPAN_TAG,
            new org.apache.batik.extension.svg.BatikDomExtension.FlowSpanElementFactory(
              ));
    }
    protected static class BatikRegularPolygonElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikRegularPolygonElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikRegularPolygonElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "KP0vLg+LrhMUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "57+dF9b+F42U0ykPIAAA");
    }
    protected static class BatikStarElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikStarElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikStarElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAMVYb2wUxxWfO9uH7RifbbBNIRhwDiQcehdEEtSalIAxsckZ" +
           "n2xCVdPkmNud8y3e2x3vztpnJykhUgttpSgKJKWV8CfTqogmUdWo/RLkqlKT" +
           "KE0jaNTmj5q26pf+QwpfQiv6783M7u3e3h1pPtXSzc3NvHkz773f/N4bX76O" +
           "mmwL9VNsqDjJFiixkxnez2DLJuqQjm37CIxmlW/84ezJm79qORVFsSnUXsD2" +
           "mIJtclAjumpPoY2aYTNsKMQ+TIjKV2QsYhNrDjPNNKZQt2aPFqmuKRobM1XC" +
           "BY5iK406MWOWlnMYGXUVMLQpLU6TEqdJ7QsLDKZRm2LSBX/B+ooFQ4E5Llv0" +
           "97MZ6kifwHM45TBNT6U1mw2WLHQ3NfWFad1kSVJiyRP6fa4jDqXvq3JD/8vx" +
           "j289W+gQbliDDcNkwkR7gtimPkfUNIr7o8M6Kdqz6CuoIY3uCAgzlEh7m6Zg" +
           "0xRs6tnrS8HpVxPDKQ6ZwhzmaYpRhR+IoS2VSii2cNFVkxFnBg3NzLVdLAZr" +
           "N5et9cIdMvH5u1PnvvVYxw8bUHwKxTVjkh9HgUMw2GQKHEqKOWLZ+1SVqFOo" +
           "04CATxJLw7q26Ea7y9amDcwcgIDnFj7oUGKJPX1fQSTBNstRmGmVzcsLULm/" +
           "mvI6ngZbe3xbpYUH+TgY2KrBwaw8Buy5SxpnNEMVOKpcUbYx8TAIwNJVRcIK" +
           "ZnmrRgPDAOqSENGxMZ2aBPAZ0yDaZAIELYG1Okq5rylWZvA0yTK0LiyXkVMg" +
           "1SIcwZcw1B0WE5ogSutDUQrE5/rhPc88bowYURSBM6tE0fn574BFfaFFEyRP" +
           "LAL3QC5sG0i/gHtePRNFCIS7Q8JS5sdP3HhwR9/K61JmQw2Z8dwJorCsspxr" +
           "v3rn0PbPNfBjNFPT1njwKywXtyzjzgyWKDBNT1kjn0x6kysTP//SU5fIX6Oo" +
           "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" +
           "Dtr/EwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    protected static class BatikHistogramNormalizationElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public BatikHistogramNormalizationElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.BatikHistogramNormalizationElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "G6D0f8X41BojFAAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZa6wjSXXuubMzOzssO7PvzYZ9MpDsNrnt9qvbGWDXdrvt" +
           "ttvt9vuRwNDuLne3+/3uNtkEkHgkRIBgIUSC/QVKgpaHCChIEdFGUQIIFIkI" +
           "5SUFUBQpJASJ/REShSSkun3v9b13Zpas8iOWXC5X1Tl1Tp1TX5069fwPkHOe" +
           "i6C2pSeybvn7IPb313pp309s4O232RIvuB6Q6rrgeSPYdk18/HOXfvTjDyiX" +
           "95DzC+RuwTQtX/BVy/QGwLP0EEgscmnX2tCB4fnIZXYthAIW+KqOsarnX2WR" +
           "Vxwj9ZEr7KEIGBQBgyJgmQhYdTcKEr0SmIFRTykE0/cc5FeRMyxy3hZT8Xzk" +
           "sZNMbMEVjAM2fKYB5HAh/T+BSmXEsYs8eqT7VufrFP4wij37W2++/PmzyKUF" +
           "ckk1h6k4IhTCh5MskNsNYCyB61UlCUgL5E4TAGkIXFXQ1U0m9wK5y1NlU/AD" +
           "FxwtUtoY2MDN5tyt3O1iqpsbiL7lHqm3UoEuHf47t9IFGep6307XrYZ02g4V" +
           "vKhCwdyVIIJDkls01ZR85JHTFEc6XunAAZD0VgP4inU01S2mABuQu7a20wVT" +
           "xoa+q5oyHHrOCuAsPvLgTZmma20LoibI4JqPPHB6HL/tgqNuyxYiJfGRe08P" +
           "yzhBKz14ykrH7PMD7vXve6vZMvcymSUg6qn8FyDRw6eIBmAFXGCKYEt4+5Ps" +
           "R4T7vvyePQSBg+89NXg75g9+5cWnX/fwC1/djvnZG4zpLddA9K+Jn1je8c1X" +
           "1Z+onE3FuGBbnpoa/4TmmfvzBz1XYxvuvPuOOKad+4edLwz+bP62T4Hv7yEX" +
           "GeS8aOmBAf3oTtEybFUHbhOYwBV8IDHIbcCU6lk/g9wK66xqgm1rb7XygM8g" +
           "t+hZ03kr+w+XaAVZpEt0K6yr5so6rNuCr2T12EYQ5F74Rd4Av7+PbD+fTwsf" +
           "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" +
           "9+0swfY/WUCFyR8gAAA=");
    }
    protected static class ColorSwitchElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public ColorSwitchElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.ColorSwitchElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "/S9yQQSoAxQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZa6wjSXXuubOzOzssO7PvZcM+GQi7JrftttvdzrDs2u32" +
           "s+223Q/bncDQ7267X+63TTYBJB4JESBYCJFgf4GSoOWhKCiRIqIlKGERKBIR" +
           "yksKoChSSAgS+yMkCklIdfve63vvzCxa5UcsuVyuqnPqnDqnvjp16vkfQucC" +
           "Hyp4rrXWLTfcV9Nwf2Gh++HaU4P9HoWORD9QFcISg4AFbVflx7548cc/+bBx" +
           "aQ+6WYDuEh3HDcXQdJ1gogauFasKBV3ctZKWagchdIlaiLEIR6FpwZQZhFco" +
           "6FXHSEPoMnUoAgxEgIEIcC4CXN+NAkSvVp3IJjIK0QmDFfSr0BkKutmTM/FC" +
           "6NGTTDzRF+0DNqNcA8DhfPafB0rlxKkPPXKk+1bnaxT+WAF+9rfedun3z0IX" +
           "Beii6TCZODIQIgSTCNBttmpLqh/UFUVVBOgOR1UVRvVN0TI3udwCdGdg6o4Y" +
           "Rr56tEhZY+Spfj7nbuVukzPd/EgOXf9IPc1ULeXw3znNEnWg6707XbcatrJ2" +
           "oOAFEwjma6KsHpLctDQdJYQePk1xpOPlPhgASG+x1dBwj6a6yRFBA3Tn1naW" +
           "6OgwE/qmo4Oh59wIzBJCD9yQabbWnigvRV29GkL3nx432naBUbfmC5GRhNA9" +
           "p4flnICVHjhlpWP2+eHwzR98h9Nx9nKZFVW2MvnPA6KHThFNVE31VUdWt4S3" +
           "PUF9XLz3y+/fgyAw+J5Tg7dj/vBXXnr6TQ+98OJ2zM9dZwwtLVQ5vCp/Wrr9" +
           "W68lHq+dzcQ477mBmRn/hOa5+48Oeq6kHth59x5xzDr3DztfmPz5/J2fVX+w" +
           "B13oQjfLrhXZwI/ukF3bMy3Vb6uO6ouhqnShW1VHIfL+LnQLqFOmo25baU0L" +
           "1LAL3WTlTTe7+X+wRBpgkS3RLaBuOpp7WPfE0MjrqQdB0D3gCz0Jvn8KbT9f" +
           "yYoQWsGGa6uwKIuO6bjwyHcz/TODOooIh2oA6gro9VxYAv6//IXSPgYHbuQD" +
           "h4RdX4dF4BWGuu3M9qnqBEBjOIh1uJG1NV2bPGzdz1zP+/+YNM1W4lJy5gww" +
           "0mtPQ4QFdlfHtRTVvyo/GzXIlz5/9Rt7R1vmYA1DqAdm3t/OvJ/PvH808z6Y" +
           "ef+amS8DS7o+k5ihbGTIqTphS8ywYA2dOZOLcncm29ZXgKWXADMAmt72OPPW" +
           "3tvf/9hZ4KRechMwUzYUvjGoEzuU6eZYKgNXh174RPIu/teKe9DeSXTO9AFN" +
           "FzLyUYapR9h5+fSuvB7fi+/7/o+/8PFn3N3+PAH3B7BxLWW27R87vfK+K6sK" +
           "ANId+yceEb909cvPXN6DbgJYAvAzFIG/A2h66PQcJ7b/lUMozXQ5BxTWXN8W" +
           "razrEP8uhIbvJruW3CVuz+t3gDW+mO2HN4LvVw82SP6b9d7lZeXdWxfKjHZK" +
           "ixyqn2S8T/3NX/xzOV/uQ1S/eOycZNTwyjEkyZhdzDHjjp0PsL6qgnF//4nR" +
           "Rz/2w/f9Uu4AYMTrrjfh5awkAIIAE4Jlfs+Lq7/97nc+/e29ndOE4CiNJMuU" +
           "0yMlz2c63f4ySoLZ3rCTB/ivBTZm5jWXOcd2FVMzRclSMy/9r4uvL33pXz94" +
           "aesHFmg5dKM3/WwGu/bXNKB3fuNt//5QzuaMnJ2EuzXbDdvC6107znXfF9eZ" +
           "HOm7/vLB3/6a+CkA1AAcA3Oj5ngH5WsA5UaDc/2fyMv9U32lrHg4OO78J/fX" +
           "sYjlqvzhb//o1fyP/uSlXNqTIc9xWw9E78rWvbLikRSwv+/0Tu+IgQHGVV4Y" +
           "/vIl64WfAI4C4CgDhAtoH0BResIzDkafu+XvvvLVe9/+rbPQXgu6YLmisgUU" +
           "cEQA71YDA6BY6j319Na4SWbuS7mq0DXKb53i/vzfWSDg4zfGl1YWsey26P3/" +
           "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" +
           "V9mnrknFKq69f5B4lSy1SQ8AxG9Trnlu4vLJ/Gt2D3vwRm8Q+R3s0+9+9jmF" +
           "/kxp7yBPNAPX7oOnoePy+NATN75sDvL3l13y4mvv/pcH2LcYb38FKdmHTwl5" +
           "muXvDZ7/evsN8kf2oLNHqYxrXoZOEl05mcC44Kth5DvsiTTGg0fmuS+zxoPg" +
           "++KBeV68flr0unY/kzva1r1O5eD2to6RO9ihVe/OrJqU5dyYTVeOMovl1MnL" +
           "ZPDekRU+MI/sg1hfPWR213FmB9bfOXHws67EJ1JlIfSaG6byD+crvtLXAeA7" +
           "91/zWLl9YJM//9zF8/c9x/11ngU/egS7lYLOa5FlHU8/Havf7PmqZuZrcus2" +
           "GeXlP+8NoYdeXrgQOgvKXJP3bGl+PYQeuDEN2M5H9eNUvxlCl05ThdC5/Pf4" +
           "uA+F0IXdOGC6beX4kI8AmcCQrPpR7zoZrG3+Lj1zbDceoE9u3zt/ln2PSI6n" +
           "17MdnD8zH+62aPvQfFX+wnO94Tteqn5mm96XLXGzybicp6Bbti8NRzv20Rty" +
           "O+R1c+fxn9z+xVtffwgtt28F3u2jY7I9fP1cOml7YZ793vzRfX/w5t957jt5" +
           "Qu1/AfudYvz/HwAA");
    }
    protected static class FlowTextElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowTextElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowTextElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "WwL9EwAA");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "AA==");
    }
    protected static class FlowDivElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowDivElementFactory() { super(
                                           );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowDivElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "SYa/+xMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZe8zjWHX3fLMzOzssO7Pv7ZZ9MtDuhn5OYjt2OjzWSRw7" +
           "sWM7D+fVwuD4ETvxK34ndMtD4tFSAYKFUgn2L1BbtDxUFbVSRbVVH4BAlahQ" +
           "X1JZWlWUliKxf5RWpS29dr7vy/d9M7No1T8aKTc3995z7jn3nPO7x8fPfR86" +
           "F/hQwXOt9dxyw30tDfcXFrYfrj0t2G9zmCj7gabWLTkIBmDsmvL4Fy798Ecf" +
           "Mi7vQeen0N2y47ihHJquE/S0wLViTeWgS7tRytLsIIQucws5luEoNC2YM4Pw" +
           "Kge94hhpCF3hDkWAgQgwEAHORYDJ3SpA9ErNiex6RiE7YbCCfhk6w0HnPSUT" +
           "L4QeO8nEk33ZPmAj5hoADhey/0OgVE6c+tCjR7pvdb5O4Y8W4Gd+/S2Xf+cs" +
           "dGkKXTKdfiaOAoQIwSZT6HZbs2eaH5CqqqlT6E5H09S+5puyZW5yuafQXYE5" +
           "d+Qw8rWjQ8oGI0/z8z13J3e7kunmR0ro+kfq6aZmqYf/zumWPAe63rfTdath" +
           "MxsHCl40gWC+LivaIcktS9NRQ+iR0xRHOl5hwQJAequthYZ7tNUtjgwGoLu2" +
           "trNkZw73Q9905mDpOTcCu4TQgzdlmp21JytLea5dC6EHTq8Tt1Ng1W35QWQk" +
           "IXTv6WU5J2ClB09Z6Zh9vs+//gNvcxhnL5dZ1RQrk/8CIHr4FFFP0zVfcxRt" +
           "S3j7k9zH5Pu+9L49CAKL7z21eLvm937pxade9/DzX9mu+ekbrBFmC00Jrymf" +
           "mt3xjVfVn6iezcS44LmBmRn/hOa5+4sHM1dTD0TefUccs8n9w8nne382ecdn" +
           "tO/tQRdb0HnFtSIb+NGdimt7pqX5tOZovhxqagu6TXPUej7fgm4Ffc50tO2o" +
           "oOuBFragW6x86Lyb/wdHpAMW2RHdCvqmo7uHfU8OjbyfehAE3Qu+UAV8vw1t" +
           "Py9kTQitYMO1NVhWZMd0XFj03Uz/zKCOKsOhFoC+CmY9F54B/1/+XGkfhwM3" +
           "8oFDwq4/h2XgFYa2ncziVHMCoDEcxHO4lo01XJs6HN3PXM/7/9g0zU7icnLm" +
           "DDDSq05DhAWii3EtVfOvKc9ENerFz1372t5RyBycYQg1wc7725338533j3be" +
           "BzvvX7fzlablJg0zzlBTc8KmnOHAGjpzJhfjnkyurZ8AKy8BXgAkvf2J/pvb" +
           "b33f42eBg3rJLcBE2VL45oBe3yFMK8dRBbg59PzHk3cO317cg/ZOInOmCxi6" +
           "mJGLGZ4e4eaV0xF5I76X3vvdH37+Y0+7u9g8AfUHkHE9ZRbyj58+dd9VNBWA" +
           "6I79k4/KX7z2paev7EG3ABwB2BnKwNcBLD18eo8ToX/1EEYzXc4BhXXXt2Ur" +
           "mzrEvouh4bvJbiR3hzvy/p3gjC9lsXAFfP/+IDjy32z2bi9r79m6T2a0U1rk" +
           "MP2GvvfJv/7zf0by4z5E9EvH7si+Fl49hiIZs0s5Xty584GBr2lg3d99XPzI" +
           "R7//3l/IHQCsePWNNryStXWAHsCE4Jjf/ZXV37zwrU99c2/nNCG4RqOZZSrp" +
           "kZIXMp3ueAklwW6v3ckDUMgCQZl5zRXJsV3V1E15ZmmZl/7XpdeUvvivH7i8" +
           "9QMLjBy60et+MoPd+E/VoHd87S3//nDO5oyS3YK7M9st20Lr3TvOpO/L60yO" +
           "9J1/8dBvfFn+JABpAIyBudFyrIPyM4Byo8G5/k/m7f6puVLWPBIcd/6T8XUs" +
           "W7mmfOibP3jl8Ad/+GIu7cl057itO7J3deteWfNoCtjffzrSGTkwwDr0ef4X" +
           "L1vP/whwnAKOCkC3QPABDKUnPONg9blb//aP/vi+t37jLLTXhC5arqxuAQVc" +
           "D8C7tcAACJZ6b3pqa9wkM/flXFXoOuW3TvFA/u8sEPCJm+NLM8tWdiH6wH8K" +
           "1uxd//Af1x1Cjiw3uKRP0U/h5z7xYP2N38vpdyGeUT+cXg/NILPb0ZY/Y//b" +
           "3uPn/3QPunUKXVYO0sahbEVZ4ExBqhQc5pIgtTwxfzLt2d7xV48g7FWn4eXY" +
           "tqfBZXclgH62OutfPI4nPwafM+D7P9k3O+5sYHvZ3lU/uPEfPbryPS89A6L1" +
           "XHkf3y9m9G/KuTyWt1ey5me2Zsq6PwvCOsjzVUChm45s5Rs/FQIXs5Qrh9yH" +
           "IH/Nrp+Fheds7gUZe+5Omfb726RvC2hZW85ZbF0Cu6n7/Px2VX5z3bFjxrkg" +
           "f3z/P37o6x989QvApm3oXJydNzDlsR35KEup3/PcRx96xTPffn+OUgCixI9R" +
           "l5/KuHIvpXHWUFnTPFT1wUzVfp4McHIQdnJg0dRc25d0ZdE3bYC/8UG+CD99" +
           "1wvLT3z3s9tc8LTfnlqsve+ZX/3x/gee2TuWgb/6uiT4OM02C8+FfuXBCfvQ" +
           "Yy+1S07R/KfPP/0Hv/X0e7dS3XUyn6TA49Jn//K/v77/8W9/9QYJyi2W+38w" +
           "bPiKP2HQoEUefjrDiT5KpDQd6UI1YvCeAc9HRTaZ1PCWwHTLa7Iv0aFMxmjL" +
           "s1UimFvDwZRfzBxdCBEjVvEEl7GC6i3ry2bosVKv1+qbsRGj5qq36LdXy1ko" +
           "FumIXYzaxUW/3rOLhRKzdqWwG3tiTZSpEYwEmwCJ8NCRnM1wjagIv+nYG32D" +
           "xDGP40iKaZGbzJo9hhjZhsUH817LsTSm2uAmqjsvymWGFhLaGMEKymBFXINp" +
           "ZFAZGOyAZUakM6OHwrpLTYsTeyE0+WhlJ3jdoyIlafU8fTmj291Cgm2YAedQ" +
           "bTVa8LLXkqOKvekU5/Ox0PJDXvDJBW9VNvZwWWqKZJGVi0KraA5WYrBI3I7X" +
           "pDk5pJuTDlMx56OGO1hGo2RTVlJjNcBgUikZqT1CAZSXDHItzRBJCidlgPdN" +
           "k7Wai5XB0DGGGo3KOPIRvoHofMyEKRqHZID4HdqWB03DXfA1phNNWiVXDruj" +
           "RZJMPMEXXboyjxYa2qoPBGkgRjPWr3ukF1eq82lfEf1hyvS5OTZJDNiWKWtg" +
           "1cptt1+R+qZdUqp8b5m2rVp3LW5mNY1LVJ+fjuKqQqkdXWxFGDABY/twv1da" +
           "2cV2GC2c9qIi1ls9I+jMJaGtSEowRar2Ui6yas/oBqRjyqVFtwQX3RDxKnzH" +
           "npoYmTAKxyBdL1BG2lwm5ku7PsNlvxMEsY11R27cJHity4vzCqLOZaSfGFSh" +
           "MZ+UKwiZCChR06qVfsFw1BLZF1hLk2ZSWqC7vXlFds1Jd+THzVHVHFGkKq1a" +
           "NG8qQ3NS04VJ0WxMJyTVnE3oYtNTN+MmG2y0trekh+7YUuIWO62tKBef99PF" +
           "ynTd9qBXt6pTyjW09gbWG1qaouUG5qXNVmcjF7ulgujEc2pUXUrSoE1VAzJW" +
           "Sc7eeINNoRmVCIIuKi2DC8zE4uxpqQArakFAotHYU9Y0veAWUY+npkOnJK3w" +
           "UsUrN8qbqp6icK9fLzEYQcdBc6MEboJ0SnUzaQzU6aREdKKhyC1horKKHMds" +
           "wgtZtKVpr8spnZB00cqQDVvqRJxUU2FQbs97s163RA07s6YoLOTauFjEvTYm" +
           "GKgYEV3e9VeNAS0FnV6sNCltyJBjXuJ1HhZGSEWbNKU+3Ks162O9VosKzEb0" +
           "2jAO07Q7tK1JbdQGoR9UVrI1pddcmSAa7MJkBL4xnrSncn+OJyIsYI68rJq2" +
           "gPHzWj8AeVqt21nVlz2BcEJ2QCrB0FtjsiaRTBqtzUAsyC2vsYBRmDdL6aCy" +
           "ni4Iad5nVJpVWLKMjLudRc+cVscb3GUMmqjaY2ycoCWdJtbNRguvbfpRRaEW" +
           "kbMG34mgSiUFb1OKIDNVzhEoor9ES/PNvMOxtckgLS24zXqYkhatkTOUTGx8" +
           "KsbO3NV4p1BwSZfpF5glR/Vm6rA9a9TmzQUxa9eGXKmgRqJTkQlETJuUEtUV" +
           "pt7ftFqBzXJ1duDSZa9HduTR2tYL7fXKb6c1kPY1uGFhIiJIEeMRcFAMldSk" +
           "MsnqKdazBKwghUurWV+xIwRX1rro4NFK0oJ5zV113LLeYsOREsw8M5lUZScd" +
           "4WqhMybMQoGaA1VXtdStV+iJ7NdWmwldLS/mzpLWazMnBBibjB2Os9nGAHak" +
           "MpGw4ULSF+S8qLqLwmhupDReYPu6QaB8iSeUkhOtrVhb9yrCaGIO3XlAKMO2" +
           "FjM8AqeYhdQRp9SQu96YbNNUo9XjFuuF2xyPJYpqpCaVtNc6bnYFXV9WByJT" +
           "EzES9YUSv9ysVaPRqhdbrVmM22ucj2Ndj7yBbpKjyXTKUEgtGfZWo3TZwjWv" +
           "OpjSipcwWEL1+RY5EOhVv4GZZH9RjlEsrRXqY2xajUdOHybwWbNsdjuNnpNM" +
           "cN1Y1hQGnSaVuVQhCirHj1ct2xPJJSPOY6rNCXF9MIjDMjiJTrUnOKUQhVU9" +
           "MRSjl5CxALsmNexzBlno1nm3mjhYMwQxrOAhtkQGdZQtEOMKAGo5KMDBlFmh" +
           "1YIqjGiBLllhbyRUe6ZNpuC4eAvckVJVkluY2S7W13x5o4uGjyuzNaeSaK3n" +
           "DVtN1UHIyYhrSvME46OROC5zCD7V9XTFTFYAzGeNxPOXHcIQ5jRuNls1so8M" +
           "dH3AosRmo+BKWxrSElEtaHbZo2TOatk6F6MEVtHxGDGKflAf1tpNGt9YaKCU" +
           "iyPc2XTRlLE111TdEVksUuuVQLUKqwrJVE186MKE7ugTPWlqRI/S01KjUHHd" +
           "MS6w7ASek1LaQMsCQdT0Irdie77Qq+BxhWerUsVdVvCqsMDaI4SoTMvrVmQH" +
           "fq1AuwAMCQ0uVLVYMnRVX03pLmVVQnpRQRezqdSeBKnUVegepzvloFxRMWxS" +
           "KrFqGzdtxBituyLMjvr1SiJFImyPq8s+MVw4BbbGkR66Grlro8CPx7gF28iK" +
           "Qpq99dKP/PWqxqYKb4jFpl11KdmRBzYxZIZuOCtaOt1LCkxSnKG6sDBQQpTb" +
           "9Q2ZYnFBtr2ZPLKpmtDqBw28VQ6GQ5QcYn1jtoSDnrzwcWwsuyQyrVuRkU5R" +
           "w9CjbjkUO+asLtUZ2ei4rFOyZIJjxXafjQZlwp52x1g3hsswYpFwyEo8POaY" +
           "BsGAMwlFqT9nVLWk87y4cKQppsu0E42Y2Kz2O7g1LVKcx40IOTWNTkttOCuy" +
           "vNbiOrsu95usg7LLmhDDiEGzq8bQmgO/0juJELrYYEiK0bCg1YadkFLHHbU7" +
           "jwN+HSRJqYa0uiK/bJsbEqXQReIvQ39CaYUxtUrlFSpRGl7xSHNsof2N6MMr" +
           "NGLCcTEci355U3F4zkhQWKdFpIhzq3ldx9FVG111aFxKpyQmR9WpNAzjFU4l" +
           "WhkZedW4bPhIi0+MRpoqEVk0dIFo2Cvg0fJa9OiuM1LwzqyEyFphVApQy++2" +
           "fUYik0bBLTQdH+lLWGM81urqpLBMxuisoPeFlTFhbDHFYFirxunGazJxaxLG" +
           "apkFMkX9OJ6KrASbdcFeTnskQhKshNSEKjodLUA+0nAZeib2eH04tdB0RfK0" +
           "gk19i0dcv7aZ2UydJNCNVVTHtjSsFDvV4aga26FEeHUTQ63qnA7Gak0xupje" +
           "J+h1Oy6V/BE5SstjJ2XWGlzVJuiYW7NzVCv5Y04Zt61xAhP1esssj2ecpRfI" +
           "uOZVYSIhRLZX6HJVRuhqBBZzDsGs5GJb0FdBtEz7C2Sa1pc1sug2G0hpzDbw" +
           "hl0ujCOy1wjGGAsnIdafyHAh7YCk/Q1vyNL5N7+8J6o784fHo9cH4EEqm2Be" +
           "xpNEeuMN90LoNs93Q/C0ran5vrtyVF6JuOewEH34e7wctatRnDl8jH3TdSVY" +
           "1bX3DwquM0trCB0A8dtya16XuHKy9po9gz10s3cP+fPXp971zLOq8OnS3kGN" +
           "aAweuQ9eCR2Xx4eevPmDZid/77IrXHz5Xf/y4OCNxltfRjn2kVNCnmb5253n" +
           "vkq/VvnwHnT2qIxx3Ruhk0RXTxYvLvpaGPnO4EQJ46Ej89yfWeMh8P3OgXm+" +
           "c+OS6A3tfiZ3tK17naq/7W0dI3ewQ6vek1k1QZTcmA1XiTKL5dTJS1Tv3pY1" +
           "PjCP4mtyqB0yu/s4swPr75w4+EmPwyfKZCF07w1L+Id7FV/uGwHgNw9c94Jy" +
           "+1JN+dyzly7c/6z0V3n1++jF120cdEGPLOt42elY/7zna7qZn8dt2yKUl/+8" +
           "J4QefmnhQugsaHNN3r2l+ZUQevDmNCCUj/rHqX4thC6fpgqhc/nv8XUfDKGL" +
           "u3XAbNvO8SUfBjKBJVn3I94NKlfbul165lgkHiBPbtu7fpJtj0iOl9Wz6M1f" +
           "LR9GWrR9uXxN+fyzbf5tL1Y+vS3rK5a82WRcLnDQrds3DEfR+thNuR3yOs88" +
           "8aM7vnDbaw5h5Y6twLsYOibbIzeuoVO2F+ZV783v3/+7r//NZ7+VF9L+F+Bq" +
           "cQzzHwAA");
    }
    protected static class FlowParaElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowParaElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowParaElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "TkCySf0TAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    protected static class FlowRegionBreakElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionBreakElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionBreakElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "hiJ9lP4XpYFlnAsUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAMVZaazkWHV2v+6e6WmG6Z59MmFWGpKZIs+1ucpOs4zLZZft" +
           "cm12LS4n0Li8VHnfy1VFJiwSS0IECAZCJJhfoCRoWBQFJVJENFGUAAJFIkLZ" +
           "pACKIoWEIDE/QqIQINeu916993pBo/xISXXrlu89555zzznfPff4he9D56MQ" +
           "KvievZ7bXryvreJ900b247WvRfssh/TlMNJUwpajaAieXVOe/MKlH/7oQ4vL" +
           "e9BtEnSv7LpeLMeG50a8Fnn2UlM56NLuKWlrThRDlzlTXspwEhs2zBlRfJWD" +
           "XnGMNIaucIciwEAEGIgA5yLA+G4WIHql5iYOkVHIbhwF0K9DZzjoNl/JxIuh" +
           "J04y8eVQdg7Y9HMNAIcL2f8xUConXoXQ40e6b3W+TuGPFuDnfvstl//gLHRJ" +
           "gi4ZrpCJowAhYrCIBN3paM5MCyNcVTVVgu52NU0VtNCQbWOTyy1B90TG3JXj" +
           "JNSONil7mPhamK+527k7lUy3MFFiLzxSTzc0Wz38d1635TnQ9YGdrlsNqew5" +
           "UPCiAQQLdVnRDknOWYarxtBjpymOdLzSBhMA6e2OFi+8o6XOuTJ4AN2ztZ0t" +
           "u3NYiEPDnYOp570ErBJDD9+UabbXvqxY8ly7FkMPnZ7X3w6BWXfkG5GRxND9" +
           "p6flnICVHj5lpWP2+X739R94m0u7e7nMqqbYmfwXANGjp4h4TddCzVW0LeGd" +
           "T3Mfkx/40vv2IAhMvv/U5O2cP/q1l5553aMvfmU75+dvMKc3MzUlvqZ8anbX" +
           "N15FPIWdzcS44HuRkRn/hOa5+/cPRq6ufBB5DxxxzAb3Dwdf5P9y+o7PaN/b" +
           "gy4y0G2KZycO8KO7Fc/xDVsLW5qrhXKsqQx0h+aqRD7OQLeDPme42vZpT9cj" +
           "LWagc3b+6DYv/w+2SAcssi26HfQNV/cO+74cL/L+yocg6H7whWrg+xNo+/lx" +
           "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" +
           "f/f5b+WFtf8FxtZokQsgAAA=");
    }
    protected static class FlowRegionElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowRegionElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowRegionElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "9L+Su9H8ARQAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "b+f1tP8FmXrJbv0fAAA=");
    }
    protected static class FlowLineElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowLineElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowLineElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "LY6u/RMAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "GHpYebIJ526fIFehW3dUNe6k8EBX3eKmwlg1z5vIomXDkwHVZNtraqHjizEx" +
           "s/B00Zu5E4xTOpvKatCbCKZXIQg67XYmTjnY8OXqMtIVieTBeZWwlr7y/XQz" +
           "WBr0iBqNXM0IYNS30kq1zhvddIGJPaPHWJuOx2m00cBn6+56CrvIKHK0hjVH" +
           "9QI+XhbjDouhC6pVJ7GZUmVqHNFmVRxZC7g/6VAx6o1pTpI8C13xI7+/qSzw" +
           "ScufsqVioUWWECwUbW4oIsPQQdJOaVYdiIs6Pa+P+gnm8tS6jMRjuFGv+0it" +
           "QoeNNdObVdWp2WlqZH+kub1kUje4LtYn1sDr1EYjpM0lw6LpqjYMSZZqV2Sh" +
           "3scDm8Xmq2ZLYtn5vBJUGqi0nHfLta7ZnA2bDioZ2MiQnA7jEowLV1RqQNYH" +
           "GBzbWFVXeyuK7ahYz5vVR1a/GheiTVoTgkERgUsJG9BqpdBhiVUwYNfEcLK2" +
           "UgfrWtG6zIWNqV7sx+NYglvxUKoaDVloVqLSfKRMkm5VSotrudEwuGqLwrq4" +
           "2PHpSZcM9ElZ7ZtrdBwFEz8ocKYcMhOJHKg1ZLO0Z64jpMAJ/CVAYbgsz8S6" +
           "N+Yq3KJcdAfTdm0dxybvteQJOiIts09PabK7jAoBHgVwQAeF7prqrKYqgQb9" +
           "YWD7xLjZxuHqQuJqLFLkG3XDk8dDeEI4Bb1qh1aBqGLWMA1jrD8L6VrNUtaD" +
           "8nIlOoqpa966wMOioMuu29eIxgBtTVAHDli5piUNckrr9iysB0YKlzbzRY1Z" +
           "A9cjNgATqjy2HiYuWRdEzlo0l9pEaCzLpoQg7bAflVp9Ey75RIlbErDg8JOu" +
           "3W+XsOqgLfQMEdblxGRGrfncRnyUNpb+BqeDetifE8EsqaBClZoaFj/EkyY7" +
           "T9poreEV6zqN1ODGyOZdGfc4v98N6trMNYdJT42a6mBdmtMNroFUJkIx9Orx" +
           "yK0aBbOFDCMrnmmdWlqFCWTWXQJEVobWGGuJpFHtuVEKV6n5vF0qTizbo2eB" +
           "aCCuLYRdejRkVku/ZxF2R0ULrViajY1ozNX5blogm3BLn1Fwd12rCVQrba4K" +
           "RYQRp0GQjlqYhc/9do0shRwXk3a9yok64g+FEYNItD5r1dyWMyBVX1nEEWoT" +
           "s65PmV2mtZphG3dsIHzVwzbtKrcR1XoJhysELKeIbDWSBVGnWjRTWilMpEh1" +
           "y+NVLJqFXtdqh3aBqSzETuDOlkksI2SNSOAODU7Y92vhqtqT0rW5lhNNmZaq" +
           "jswZo3EVaTntaQ2Ny0PFVQ2e74ez0CzPSwWk6agWSiIRZpsld+A1O+YQLXUq" +
           "nSkhYGuTtAKf0mK1jJdXahHGi/FgAM+nbiJ4IC9RatWw2Zob5cmEDSpFeDkp" +
           "1arzNetV040d0qNyGZYsFpVKNR5bIKXVcF7hyMHcKfpNQ0FKhjkrwqIttEsw" +
           "EimuUXGLSbvel2t2p92pSXCTbTakfr9ccZpFnU98qu46sIzSShWGFaGWDLy2" +
           "2Rr11hhbn9gLJapuDLKGlYdpGThDu9lG6q1RRaKwTdJgo2iONko9ub8iKgQT" +
           "1JyE4yvLlGukTAXkfYwOL0YFFdPTgjupUz20XS+L5cKGX/ETvtJcC+s+0+HI" +
           "pp1a435dCxrEsCeSqkGmqDqYc7qSiBSn01W3gSrMdFXZNJqbtO02QRxJIwZc" +
           "Ue06PKuznBBvXDKVKjSSrhvr+bJTHlBct73xxcU8qPQ9vBOVrWG/VaiNKzKi" +
           "LuFF1K4waDl22ms10qe1Zq3QrSviRqusU30dzA1ws0thjWKsChPbzXQ8nYBr" +
           "22MXEcuA7JvEw8hC6IZML6ohMuqDpP1Nb8rS+be8sieqO/OHx6P3B+BBKpvo" +
           "voInieTGG+4F0G2OZwfgaVuR83135ai8EnHPYSX68Pd4OWpXozhz+Bj79HU1" +
           "WNk29w8qrqKhtAd90nS25da8LnHlZO01ewZ7+GYvH/Lnr0+/+7nn5cFninsH" +
           "NaI5eOQ+eCd0XB4PeurmD5r9/MXLrnDxlXf/y4OTN6/e9grKsY+eEvI0y9/p" +
           "v/C1zuulj+xBZ4/KGNe9EjpJdPVk8eKipwShZ01OlDAePjLP/Zk1HgaqPnFg" +
           "niduXBK9od3P5I62da9T9be9rWPkDnZo1Xsyq8aolBuzbUthZrGcOn6Z6t3b" +
           "s8YD5pE8RQiUQ2Z3H2d2YP2dE/s/7XH4RJksgO67cQ3/cLPCK30nABzngete" +
           "UW5fq0mff/7Shfufn/51Xv4+evV1Gw1dWIaGcbzudKx/3vGUpZYfyG3bKpST" +
           "/7w3gB55eeEC6Cxoc03es6X51QB68OY0IJaP+sepfj2ALp+mCqBz+e/xdR8K" +
           "oIu7dcBu287xJR8BMoElWfejzg1KV9vCXXLmWCgeQE9u3Lt+mnGPSI7X1bPw" +
           "zV8uH4ZauH29fE36wvMU8/aXqp/Z1vUlQ0jTjMsFGrp1+4rhKFwfvym3Q17n" +
           "u0/++I4v3va6Q1y5YyvwLoiOyfbojYvouOkEedk7/YP7f++Nv/X8t/NK2v8C" +
           "MGTkc/UfAAA=");
    }
    protected static class FlowSpanElementFactory implements org.apache.batik.dom.ExtensibleDOMImplementation.ElementFactory {
        public FlowSpanElementFactory() {
            super(
              );
        }
        public org.w3c.dom.Element create(java.lang.String prefix,
                                          org.w3c.dom.Document doc) {
            return new org.apache.batik.extension.svg.FlowSpanElement(
              prefix,
              (org.apache.batik.dom.AbstractDocument)
                doc);
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "A0kiCv0TAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "iWmqhS62wYddN4UnIiGwvlFHe42WuVpW/Vk/aaYFfjFbIuUS5zJBRdHlCW7N" +
           "+TbZq8/b0wUtDxtjm5YWjCJ4i2aPlYb9uNEWxUXJBHoikWWBZ2CnwNuV9cil" +
           "nCkdKAQ5xKth6nZhdrwZzucNklVqsdTDsGrR5XvjPo2Jnb7cK3LjQB8KxbXO" +
           "6dEID7gl3FQKQ8MYryUyFQm8Smppt6sliBeO9PIgmSD1nldMHcQnW73UtjGa" +
           "9OHNStGlxngd9MzZQOWTPqwIfXwuFRoVjVoyWtlGuGq1Zq82UahTYoF3pjOx" +
           "tUCqU6mt67E+MWq4jfGIa7NSvzMi22iTaq0VazMKGxOmT9PzmkPPuHXMogrf" +
           "w+J5hXDIXonC/ZrcHGo4T0wikuoy3KiCFwq1StwL0uponhJsq1usrORZy1qK" +
           "83G64IKJnggWXy0Q1aTVai6INjMyWiaNUH4JG6vdxILbvVqIpkGyiQq67Kt4" +
           "t1mnTeB8I2Tan4N9Jpigmgraqtb3kK4kurhKujPJWtTmY7IUo+h8YOC84LuB" +
           "A1dTJ8Zpq99uNSVmshlScolJiEGbXBXhaYCbqIgOVhxaGI7MedU21ECkEBuR" +
           "DaMwnoPNKawwc+gGww2WBLSeYIN+4oXYuLiaxZbW4Vr6WkioUqEk94zlRBuz" +
           "ONdcaoSXBGHZS5V+i7cpZ4AXZ2iAxbCfVvzeZBnVqwNGUBrmdIElzXLf7Y+k" +
           "hOo2rXbFjYiBq+tmJdKc1nI5540C1uhXhJBrbLxB3MDgYbXM1zAkLgstsuM5" +
           "Vj1C0ipKKXJFSaWOqszrdXGAop2ZJZA1myHB6WXMRuW1VkbVApyuujFK9Rze" +
           "iqeoaTR0LRDnjN0dbYiyXsebHbhKKigrU/1gJZUrRoHrrKe4h1A4rI4b7SZW" +
           "K/SBO7iS0FjX68I6hfGaUisslAAvpNpS6gxpsbxp1tHynBUnADLJ8otBRbEL" +
           "y0K5LtVkROTVdrC0wbam/Rhrja1mJUFNDh5P4NDCxyN30yKVlo935GBTQLkJ" +
           "NreKo0nRYR1f2hiIyE3qthc2kxglR06xPlDcTlromktViMubeO7hk/qUonC1" +
           "2iPWQntFk4aJF5EapwzDaC6RxIRgxyTiVFbEstpawG0r2hjjbjzgKjW2IRMV" +
           "ubNYgcMHX/vGqk+FvSo6pYodRiY7fmdSc+Sw3ur54/aqjladkjApwb0aasAu" +
           "EZutvrQqdtY1eIMtakq33ygjiFDD+eG8jyHrpYyupYJjYvg8nDD4NKJJfVNZ" +
           "Nempn/L8tC37fJWN0mHLdgbWskq1e0KFwcsm71iNtsZt0v6mOkcknSisRxVP" +
           "myQgS9JIsV7XWxW2brAC052RtebIVYjWLOVJii+UI0LCS9zKbnRCZ7hmrGBR" +
           "7agTu83zWLralHUsLtc0fjLny6tCxIwW5U4X09JqvElKeERVV9ZSleP62ibF" +
           "YQFFojHCK8HQTHUjiJGSLEdqH64zBkskU0yhCRbvBaZp83q/JjXVCjVil4ZT" +
           "22CrOHaFlTpAptVk2JlO67ClASvFvA4dhOya6VrMUOkW67VkwC4StJcyCxSG" +
           "YQOZ+kWTZsIJijl2Q5wjcG3KdcFlMF7bzKjT9IgFuIx2JvM2n6iTlHCsdMF0" +
           "FGbAGdrU9tY+wTX1khQ7IhYuyflo0aa6NbxuIxqzEu1OkauJOhw3l0K1xJul" +
           "qQnSzNnEGGjzvj/qV8eFToys/XF/nDTZGJvXOMNgpjorYkwSspI498OARmPc" +
           "TQiyWJHYVZz04O4EJFhwAR8yNgG3InTuLnrTGWYjMG23lcWkUUR7guy3SxEu" +
           "hBQhLBo0tu50Uph1mhthlQwpTIB9gyguLCoujkDW/pYsnX/bq7tR3ZlfHo/e" +
           "D8BFKptgXsVNYn3jBfci6DY/8CJw29a1fN1dOSqvRNxzWIk+/D1ejtrVKM4c" +
           "XmOfuq4Gq3nO/kHFVbH1Ot9tOf623JrXJa6crL1md7CHbvb4kN+/PvWe51/Q" +
           "+E8jewc1ogm4ch+8CR3nJ4CevPlFs5s/vOwKF19+z788OHqr+Y5XUY595BST" +
           "p0n+TvfFrzbfqH54Dzp7VMa47knoJNLVk8WLi4EerQJ3dKKE8dCReu7PtPEQ" +
           "EBU5UA9y45LoDfV+Jje0rXmdqr/tbQ0jN7BDrd6TaTXB1FyZdU9dZRrLsZNX" +
           "qN69M2sCoB410OVIPyR293FiB9rfGXH4k67DJ8pkEXTfjWv4h4sVX+2bADCc" +
           "B657otw+q6mfe+HShftfEP46L38fPX3dxkIXjJVtH687Heuf9wPdsPINuW1b" +
           "hfLzn/dF0MOvzFwEnQVtLsl7tzi/GkEP3hwH+PJR/zjWr0fQ5dNYEXQu/z0O" +
           "96EIuriDA3rbdo6DfBjwBECy7kf8G5SutoW79ZljrngQenLl3vWTlHuEcryu" +
           "nrlv/rh86Gqr7fPyNfXzL7S5d75c/vS2rq/acppmVC6w0K3bJ4Yjd33sptQO" +
           "aZ1nnvjRHV+47Q2HceWOLcM7JzrG2yM3LqLTjh/lZe/0D+7/vTf/1gvfyitp" +
           "/wuYxJVe9R8AAA==");
    }
    public BatikDomExtension() { super();
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RITHdpNp8uN7HYfMfwG/qMoxABoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
