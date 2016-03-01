package org.apache.batik.dom.svg;
public class SVGOMTextPathElement extends org.apache.batik.dom.svg.SVGOMTextContentElement implements org.w3c.dom.svg.SVGTextPathElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGOMTextContentElement.
                 xmlTraitInformation);
             t.put(null, SVG_METHOD_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_SPACING_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_IDENT));
             t.put(null, SVG_START_OFFSET_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH));
             t.put(XLINK_NAMESPACE_URI, XLINK_HREF_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_URI));
             xmlTraitInformation = t; }
    protected static final org.apache.batik.dom.svg.AttributeInitializer
      attributeInitializer;
    static { attributeInitializer = new org.apache.batik.dom.svg.AttributeInitializer(
                                      4);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XMLSupport.
                                      XMLNS_NAMESPACE_URI,
                                    null,
                                    "xmlns:xlink",
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI);
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "type",
                                    "simple");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "show",
                                    "other");
             attributeInitializer.addAttribute(
                                    org.apache.batik.dom.util.XLinkSupport.
                                      XLINK_NAMESPACE_URI,
                                    "xlink",
                                    "actuate",
                                    "onLoad");
    }
    protected static final java.lang.String[]
      METHOD_VALUES =
      { "",
    SVG_ALIGN_VALUE,
    SVG_STRETCH_VALUE };
    protected static final java.lang.String[]
      SPACING_VALUES =
      { "",
    SVG_AUTO_VALUE,
    SVG_EXACT_VALUE };
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      method;
    protected org.apache.batik.dom.svg.SVGOMAnimatedEnumeration
      spacing;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      startOffset;
    protected org.apache.batik.dom.svg.SVGOMAnimatedString
      href;
    protected SVGOMTextPathElement() { super(
                                         );
    }
    public SVGOMTextPathElement(java.lang.String prefix,
                                org.apache.batik.dom.AbstractDocument owner) {
        super(
          prefix,
          owner);
        initializeLiveAttributes(
          );
    }
    protected void initializeAllLiveAttributes() {
        super.
          initializeAllLiveAttributes(
            );
        initializeLiveAttributes(
          );
    }
    private void initializeLiveAttributes() {
        method =
          createLiveAnimatedEnumeration(
            null,
            SVG_METHOD_ATTRIBUTE,
            METHOD_VALUES,
            (short)
              1);
        spacing =
          createLiveAnimatedEnumeration(
            null,
            SVG_SPACING_ATTRIBUTE,
            SPACING_VALUES,
            (short)
              2);
        startOffset =
          createLiveAnimatedLength(
            null,
            SVG_START_OFFSET_ATTRIBUTE,
            SVG_TEXT_PATH_START_OFFSET_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              OTHER_LENGTH,
            true);
        href =
          createLiveAnimatedString(
            XLINK_NAMESPACE_URI,
            XLINK_HREF_ATTRIBUTE);
    }
    public java.lang.String getLocalName() {
        return SVG_TEXT_PATH_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getStartOffset() {
        return startOffset;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getMethod() {
        return method;
    }
    public org.w3c.dom.svg.SVGAnimatedEnumeration getSpacing() {
        return spacing;
    }
    public org.w3c.dom.svg.SVGAnimatedString getHref() {
        return href;
    }
    protected org.apache.batik.dom.svg.AttributeInitializer getAttributeInitializer() {
        return attributeInitializer;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMTextPathElement(
          );
    }
    protected org.apache.batik.util.DoublyIndexedTable getTraitInformationTable() {
        return xmlTraitInformation;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0aa3QU1fnuJmwe5AWBkIIECYEWhF2oD6qhYgyPBDckkpCj" +
       "wbJMZm+SgdmZceZusmAx4mkL9Yd6FK1WzWkt2upB5Nha+jhSPD1VOdYX9VTR" +
       "KlV/qEV74Idi1dZ+352ZndnZncGAx5wzN7Nzv++73+t+jzuz90MywdBJoyYo" +
       "SSHKtmrUiHbhfZegGzTZKguG0QNPE+JNb90+eupvZTvCJNJHqoYEo0MUDLpK" +
       "onLS6CMzJcVggiJSYy2lScTo0qlB9WGBSarSR6ZKRntKkyVRYh1qkiJAr6DH" +
       "ySSBMV3qTzPabhFgZFaccxPj3MRavADNcVIhqtpWB2F6DkKraw5hU856BiM1" +
       "8c3CsBBLM0mOxSWDNWd0cp6mylsHZZVFaYZFN8sXWopYE78wTw2N+6s//uzW" +
       "oRquhlpBUVTGRTTWUUOVh2kyTqqdpytlmjKuJdeTojiZ6AJmpCluLxqDRWOw" +
       "qC2vAwXcV1IlnWpVuTjMphTRRGSIkdm5RDRBF1IWmS7OM1AoZZbsHBmkPTcr" +
       "rW1uj4h3nBfb/ZONNY8Vkeo+Ui0p3ciOCEwwWKQPFEpT/VQ3WpJJmuwjkxQw" +
       "eDfVJUGWtlnWnmxIg4rA0uACtlrwYVqjOl/T0RVYEmTT0yJT9ax4A9yprF8T" +
       "BmRhEGStc2Q1JVyFz0HAcgkY0wcE8D0LpXiLpCS5H+ViZGVsugIAALUkRdmQ" +
       "ml2qWBHgAZlsuogsKIOxbnA+ZRBAJ6jggjr3NR+iqGtNELcIgzTBSL0Xrsuc" +
       "AqgyrghEYWSqF4xTAitN91jJZZ8P1y67+TqlTQmTEPCcpKKM/E8EpAYP0jo6" +
       "QHUK+8BErFgQv1Ooe2JXmBAAnuoBNmEOfP/kZQsbDj1jwswoANPZv5mKLCHu" +
       "6a966ZzW+RcXIRulmmpIaPwcyfku67JmmjMaRJq6LEWcjNqTh9Y9dfUND9Pj" +
       "YVLeTiKiKqdT4EeTRDWlSTLVV1OF6gKjyXZSRpVkK59vJyVwH5cUaj7tHBgw" +
       "KGsnxTJ/FFH5b1DRAJBAFZXDvaQMqPa9JrAhfp/RCCElcJHZcM0n5t83cWBE" +
       "iQ2pKRoTREGRFDXWpasoPxqUxxxqwH0SZjU11g/+v2XRkujSmKGmdXDImKoP" +
       "xgTwiiFqTsaSaipmDINj9a7u7OiBDdUFTGCYoAqEHvA77WtfMYM6qB0JhcA8" +
       "53iDgwz7qk2Vk1RPiLvTl688uS/xrOl4uFks7TGyCJaNmstG+bJRWDYKy0YL" +
       "LUtCIb7aFFzedAQw4xYICBCRK+Z3f2/Npl2NReCB2kgx2CAMoPPyMlSrEzns" +
       "cJ8Q97607tQLz5U/HCZhCC79kKGcNNGUkybMLKerIk1CnPJLGHbQjPmniIJ8" +
       "kEN3jezoHV3M+XBHfiQ4AYIWondhvM4u0eTd8YXoVu987+NH79yuOns/J5XY" +
       "GTAPE0NKo9e2XuET4oJzhccTT2xvCpNiiFMQm5kAewnCXoN3jZzQ0myHaZSl" +
       "FAQeUPWUIOOUHVvL2ZCujjhPuNNN4vdTwMRVuNca4RqxNh//j7N1Go7TTCdF" +
       "n/FIwdPAd7u1+159/v3zubrtjFHtSvXdlDW7ohQSm8zj0STHBXt0SgHujbu6" +
       "br/jw50buP8BxJxCCzbh2ArRCUwIav7hM9cePfbmnpfDWZ8NMVKm6SqDjUuT" +
       "maycOEUqA+REV3dYgkAnAwV0nKb1CjimNCAJ/TLFffJ59dwlj39wc43pCjI8" +
       "sT1p4ekJOM+/cTm54dmNpxo4mZCIidZRmwNmRu9ah3KLrgtbkY/MjiMz735a" +
       "uA/yAMReQ9pGeTglXA2E2+0CLn+Mj+d75i7Coclw+3/uFnMVRAnx1pdPVPae" +
       "OHiSc5tbUbnN3SFozaaH4TA3A+SneWNNm2AMAdwFh9ZeUyMf+gwo9gFFEWKo" +
       "0alDvMvkOIcFPaHktSf/XLfppSISXkXKZVVIrhL4PiNl4ODUGIJQmdGWX2YZ" +
       "txSGGi4qyRMe9TmrsKVWpjTGdbvtd9N+s+yXY29yv+IUZmZdaSJSmQXXqOVK" +
       "o4W3DI7z+Dgfh4W2e0a0dD8U5B7fLA8g6LFi2ArO+LseKmsuC1ZNUbNqsifm" +
       "FswNLf0Qo0B3K1QxjTmBc7s6wFE6cLiMTy3FocXk/JIvp2x8sNzEmMGflRpY" +
       "CnuTCu9nnHj4wev3vPOnU78oMauh+f5JwINX/2mn3H/j25/kuSkP/wUqNQ9+" +
       "X2zvvdNbLz3O8Z04jNhzMvlZGjKVg/vth1MfhRsjfwmTkj5SI1q9Q68gpzG6" +
       "9UG9bNgNBfQXOfO5ta9Z6DVn88w53hzgWtabAZzqAO4RGu8rPUF/KppmGVxR" +
       "y+GiXg8OEX5zVWEnDuPtIvBkg3coHk+eEkCYkdpMSu7RBYm1KzxZZa0DDvut" +
       "PIflO3SFChsGWsskzUCLi1HU2WDcI68+nUeuy3I4A5+uhMsCNf8XEF0sLHoR" +
       "Fx2HaxhoXlIE2SP+9ADijExx9d2QEbF3o7otv38x11IAy6OE5DiVEIFrvcXn" +
       "lT5KUE6rBBwGC2jgSh/KjFR2rOxp61yR6G2Jr1/Z7Q0GeEjRnYYQxdOc2Rr9" +
       "vvb9Xx/eVHLUDAZNBcE9Hdfb1z17v/qP42G7myqEYkJeYXS88Ie2dxO8ginF" +
       "wrXH3jWukrRFH3SVTzUaJra5/lHJxfzYg3OeHx2b8xZPc6WSAXsXiBVoNF04" +
       "J/YeO36kcuY+Xg0WI08WP7kden4DntNXc1artUxwnsBgHTJTk+klmm386wM2" +
       "/wq33b+AvxBc/8ML7Y0P8D+EtVarkTw320lq0LVEZKoMsiEjMLR36VIKnH3Y" +
       "Mmls++RjW+597xHTpN447gGmu3bf9EX05t1mjWYeS8zJOxlw45hHE6Z5cdiB" +
       "Jp4dtArHWPXuo9v/+KvtO02uJuc22SuVdOqRv//3r9G7/nm4QO9WBPbDH9ss" +
       "GxXI7bWOzVplVaEY/Ow5s4mT1Gj2EAgmM3lGRSm82baDu4mTupYeOVX0+m31" +
       "FfndG1Jr8OnNFvjbzrvA0zf+a3rPpUObxtGWzfLo3kvyoY69h1fPE28L8xMk" +
       "M1PmnTzlIjXn5sdynbK0rvTkZMlGjf/bZjo/Dq3cHQIKpLsD5u7B4U5IFSKa" +
       "z7R2APiYVS+RAmas80Yx09UjS+77z+iPXu2EYNFOStOKdG2atidzJS0x0v2u" +
       "sOYchDlyW06PW5eR0AJNc1WxPL+oZ5BfNlpZoM8nvzxwxvmlz4cyI1XdXS2t" +
       "7WtXWwkGn454RHnwy4vC+2OsYkRrQdFHlEcch1mQ33X6YUModIVs2NRLgs9z" +
       "WhQphUEUIwuGU6uldsm2b5yyxeAasrgb8pHtt4Gy+WEzcDsQBBIN/nzMw+eB" +
       "M7BBylop5cPnE4F8+mEzMhHCg87MY0zbEAu/nCHiPJF5ZDs4TtnwwFO3uNN9" +
       "ZHsqUDY/bEaKoTseGKdQZnngEerpAKEyrmiZZY7/RSzxbDHz2toZrtoDOGxE" +
       "DkfOF92MeQ4xMTHP9Dul50l5z427x5KdDywJW1H1x4yUMVVbJNNhKrtWLef3" +
       "t+UaYzFcOy2Od3qN4ejEzxJ+qAFB/42AuWM4vMrIDClb+LfIchxKkGxLYHDE" +
       "H5jxm9/vArMPq1LSMd7R8ffsHt1U4NR5cN1iCXhLgG4KnHqUaLo0DM7lieUT" +
       "AygGqOXfAXMncHiXkXpHZbn6wvm3HN28d9a6mYxTDXDdb0ly/2n8pjVXCeUB" +
       "qAGCfhow9zkOHzFSMUhZXBUFea1VDbQ5gn981oLPtJ3iIYv7h8YvuB+qv3Ch" +
       "SMBcKQ7gb1UgeHd+WJ9dIL7kxvKsfkLhs9ZPo62f/ZaQ+8evHz/UAB1MCZir" +
       "w6EaAiLopyOn9JgXoBpXveHop+ar0c9CuA5YQh4Yv378UAN00Bgw14TDTEbK" +
       "0X+y5Uuo3hG74avZNk1wPWnx/uT4xfZDDRAtGjC3GIf5EKZB7DZXxRC0X1yn" +
       "CFwxC85aMXNw6hK4DlvSHT6NYgokYD/UAOGXBcxdisNSRqaBYvxO4TY7OvjO" +
       "WeugFqewxXnREuTF8evADzVAzraAuTU4tIJzKHRkLTSetnPUuJ0jO8H1sOKs" +
       "9YBfBJCL4XrFEuaV8evBDzVA1t6AuatwuBIqC/AF7xl29lw64Shh3Rm8KWFk" +
       "SqE39/jSqj7vAyLzoxdx31h16bSx9a+Y54X2hykVcVI6kJZl9xsB131Eg20u" +
       "cSVWmO8HeMsfwm9o/NoERopgRNZDG03ofuC3EDRAwuiGpJa/uCEZmcD/u+GG" +
       "IPY6cNAgmzduEMArAhC8lTXbGRef/ksI/imVwuw+IuRqBawWhtdFU09ntiyK" +
       "+yU1noHxD8HsE5q0+SlYQnx0bM3a605e9ID5klyUhW3bkMrEOCkx39dzonjm" +
       "NduXmk0r0jb/s6r9ZXPt1maSybCzFWa4isDlUHlr6DnTPa+PjabsW+Sje5Yd" +
       "fG5X5EiYhDaQkMBI7Yb8V1EZLa2TWRvihU6gegWdv9luLn9n0wufvBaazN+Z" +
       "EvPMqiEIIyHefvD1rgFN+2mYlLWTCRK+4eHvyVZsVdZRcVjPOdCK9KtpJXv4" +
       "XYVuLmAC4pqxFFqZfYofWUA7mX/mm//hSbmsjlD9cqSOZCo9p4RpTXPPcs3+" +
       "DIcdGdQ0+GIi3qFp1qF3Ma+8l2sa7ufQKP74+f8BzCUE++0pAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL17C8zr1n2fvmv72r5+Xb9iz4nta/smjcPkI/UWc+3WFB+i" +
       "JJKSSIqSmMcNRVISKb7Et5R5aTOszhYgyTonS4HGwIL0kcJNsmJFhg0dHBRd" +
       "G7Qr2qJYtgFNuqLYuqUBkmHrtmZrd0jpe957P/vGxj7gnI86z//v//+f33nw" +
       "8NXvFW4L/ALkudZ6brnhvp6G+6ZV3Q/Xnh7sd5hqX/EDXcMtJQhEkHZVffpr" +
       "9/3lDz+zuHiucF4uPKg4jhsqoeE6Aa8HrhXrGlO47yiVtHQ7CAsXGVOJFTgK" +
       "DQtmjCC8whTuOlY1LFxmDkSAgQgwEAHORYCxo1Kg0j26E9l4VkNxwmBV+DuF" +
       "PaZw3lMz8cLCUycb8RRfsXfN9HMEoIU7st8SAJVXTv3CpUPsW8zXAP4sBL/8" +
       "jz988VdvKdwnF+4zHCETRwVChKATuXC3rdtT3Q8wTdM1uXC/o+uaoPuGYhmb" +
       "XG658EBgzB0ljHz9UElZYuTpft7nkebuVjNsfqSGrn8Ib2bolnbw67aZpcwB" +
       "1rcdYd0ipLJ0APCCAQTzZ4qqH1S5dWk4Wlh48nSNQ4yXu6AAqHq7rYcL97Cr" +
       "Wx0FJBQe2NrOUpw5LIS+4cxB0dvcCPQSFh67YaOZrj1FXSpz/WpYePR0uf42" +
       "C5S6M1dEViUsPHy6WN4SsNJjp6x0zD7f45771Ecd2jmXy6zpqpXJfweo9MSp" +
       "Srw+033dUfVtxbvfw3xOeduvf+JcoQAKP3yq8LbM1//2D1547xOv/fa2zNuv" +
       "U6Y3NXU1vKp+aXrvH7wDfxa9JRPjDs8NjMz4J5Dn7t/f5VxJPTDy3nbYYpa5" +
       "f5D5Gv+vJz/5y/p3zxUutAvnVdeKbOBH96uu7RmW7rd0R/eVUNfahTt1R8Pz" +
       "/HbhdvDMGI6+Te3NZoEetgu3WnnSeTf/DVQ0A01kKrodPBvOzD149pRwkT+n" +
       "XqFQuB2EwlMgPFvY/v1YFoUFB164tg4rquIYjgv3fTfDnxnU0RQ41APwrIFc" +
       "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" +
       "QFhD2vJrhCP2FahvKtNgBAmmXp1os1Z1");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("XCWNyYJQBku22a5Ppg2pSMqMUhJHfGwshrW5Ph9pMQr26g7qIEk0i5uKsuEg" +
       "mYz77Mog2+01rc9ioujPKQ4q2ROLGYnZbqWi0/FakgMJrGlVyez3NLyLdkOv" +
       "M44r44kUMTaGV7xVSlEreTZxZ6MhVrfHsG3D8EKY2oFpEai6Enoy7qJehffE" +
       "cb+vBmWIaKtaSxsgUKttlFeUV1xRZVaBGlYpALuz2aDbr1egWaO5wYckBCEe" +
       "hmH5Cda/ubkjrvvzk7vDC5A/wpldeuzFw+FhaP53fncgenAwes0dh0ePvUV7" +
       "OCw8nR1zJmX1+OnmqRti2fuox290BTJ/F/Wlj7/8itb7+eK53QuKTVi4M3S9" +
       "91l6rFvHer2QP//dk8e3CAgv7SR+6fTx7ZFOzjy7PeNlyZ+ekfdnWfTHYeHt" +
       "xuELZMyyGCPWD18tB9c9dIxdQzuy1Ldv5rbGKRXcnSVCIHx6p4JP34wKwsLt" +
       "nm/ESqi/rh7+2xl5/z2L/iIsPHqkh5NKyPL/0xHg770JwA9kiU+A8MUd4C/e" +
       "rM2ff12sf33jvL28q/8dFu6e6yHjqorF7d73YUf4/upN4Hv8wKBf3uH78luO" +
       "b+/CGXl3Z9FtYeFegE+49sXMU9cZ7yffxhyqYe/8m1DD0wdq+NpODV9769Xw" +
       "6Bl5j2XRg4CHgBrYE2//3nWGBo698jtSw0NvVg3vBeHrOzV8/a1Xw7vOyMte" +
       "1O49FRYuZN5w+O5w7x1H6J5+s75+GYRv7NB9461HVzojr5JF7wMkCNDRx97d" +
       "neXkx+7v5fj33wT+Z7LE94PwzR3+b94s/tedv/bOuDa418yiK2HhEYD/Rpeh" +
       "pkdQn3sTUB/MErNbQL+/g/r7bz1U5ow8LotawNSOnnCudngX5eJxUx9m5HDp" +
       "NwE3+/aggILwrR3cb731cOUz8j6YRWCp+Ciw7Ok7f4f3+MZHWKWbujAaFh66" +
       "3qcA2aXmR6/5Imn7FY36lVfuu+ORV4bf2t4tO/jS5U6mcMcssqzj9yiPPZ/3" +
       "wKg0ck3cub1VmV/qym5WP3qj9+th4RYQZ0LvTbelZ0De65UGJUF8vKSxc4jj" +
       "JcPCbfn/4+UswIhH5cLC+e3D8SIuaB0UyR4978DbkNf/tCL/NssJD9bOe8eW" +
       "vzsvy5cYD7yewQ6rHL90n12jyr8sO7jyFG2/LbuqfvWVDvfRH9R+fnvpX7WU" +
       "zSZr5Q6mcPv2+4O80eza1FM3bO2grfP0sz+892t3vvNgOX/vVuAjjz8m25PX" +
       "v15P2l6YX4jf/PNH/tlzv/jKt/NrAf8PWuijdfI3AAA=");
}
