package org.apache.batik.bridge;
public class SVGFeDisplacementMapElementBridge extends org.apache.batik.bridge.AbstractSVGFilterPrimitiveElementBridge {
    public SVGFeDisplacementMapElementBridge() { super(); }
    public java.lang.String getLocalName() { return SVG_FE_DISPLACEMENT_MAP_TAG;
    }
    public org.apache.batik.ext.awt.image.renderable.Filter createFilter(org.apache.batik.bridge.BridgeContext ctx,
                                                                         org.w3c.dom.Element filterElement,
                                                                         org.w3c.dom.Element filteredElement,
                                                                         org.apache.batik.gvt.GraphicsNode filteredNode,
                                                                         org.apache.batik.ext.awt.image.renderable.Filter inputFilter,
                                                                         java.awt.geom.Rectangle2D filterRegion,
                                                                         java.util.Map filterMap) {
        float scale =
          convertNumber(
            filterElement,
            SVG_SCALE_ATTRIBUTE,
            0,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel xChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_X_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.ARGBChannel yChannelSelector =
          convertChannelSelector(
            filterElement,
            SVG_Y_CHANNEL_SELECTOR_ATTRIBUTE,
            org.apache.batik.ext.awt.image.ARGBChannel.
              A,
            ctx);
        org.apache.batik.ext.awt.image.renderable.Filter in =
          getIn(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in ==
              null) {
            return null;
        }
        org.apache.batik.ext.awt.image.renderable.Filter in2 =
          getIn2(
            filterElement,
            filteredElement,
            filteredNode,
            inputFilter,
            filterMap,
            ctx);
        if (in2 ==
              null) {
            return null;
        }
        java.awt.geom.Rectangle2D defaultRegion;
        defaultRegion =
          (java.awt.geom.Rectangle2D)
            in.
            getBounds2D(
              ).
            clone(
              );
        defaultRegion.
          add(
            in2.
              getBounds2D(
                ));
        java.awt.geom.Rectangle2D primitiveRegion =
          org.apache.batik.bridge.SVGUtilities.
          convertFilterPrimitiveRegion(
            filterElement,
            filteredElement,
            filteredNode,
            defaultRegion,
            filterRegion,
            ctx);
        org.apache.batik.ext.awt.image.renderable.PadRable pad =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          in,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        java.util.List srcs =
          new java.util.ArrayList(
          2);
        srcs.
          add(
            pad);
        srcs.
          add(
            in2);
        org.apache.batik.ext.awt.image.renderable.Filter displacementMap =
          new org.apache.batik.ext.awt.image.renderable.DisplacementMapRable8Bit(
          srcs,
          scale,
          xChannelSelector,
          yChannelSelector);
        handleColorInterpolationFilters(
          displacementMap,
          filterElement);
        org.apache.batik.ext.awt.image.renderable.PadRable filter =
          new org.apache.batik.ext.awt.image.renderable.PadRable8Bit(
          displacementMap,
          primitiveRegion,
          org.apache.batik.ext.awt.image.PadMode.
            ZERO_PAD);
        updateFilterMap(
          filterElement,
          filter,
          filterMap);
        return filter;
    }
    protected static org.apache.batik.ext.awt.image.ARGBChannel convertChannelSelector(org.w3c.dom.Element filterElement,
                                                                                       java.lang.String attrName,
                                                                                       org.apache.batik.ext.awt.image.ARGBChannel defaultChannel,
                                                                                       org.apache.batik.bridge.BridgeContext ctx) {
        java.lang.String s =
          filterElement.
          getAttributeNS(
            null,
            attrName);
        if (s.
              length(
                ) ==
              0) {
            return defaultChannel;
        }
        if (SVG_A_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     A;
        }
        if (SVG_R_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     R;
        }
        if (SVG_G_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     G;
        }
        if (SVG_B_VALUE.
              equals(
                s)) {
            return org.apache.batik.ext.awt.image.ARGBChannel.
                     B;
        }
        throw new org.apache.batik.bridge.BridgeException(
          ctx,
          filterElement,
          ERR_ATTRIBUTE_VALUE_MALFORMED,
          new java.lang.Object[] { attrName,
          s });
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "Gra76u2dva39gYO93fM2p8Bqvb6829gtZuPfmHN5MC8vZsUvbt2UVX8JLOsw" +
       "T0zBCNVwBCuf+E0RgJglXdznPgeJKvDJxaXVyNm8EqTmOZwy7Xe32d02oGVl" +
       "OWexhUTtqvB53ZYq37luPWRGuiBRfO+/fODr73/428Cnfej6VWZv4MojM1Jx" +
       "lju/67kP3XvTU995bx6lQIia/9bnKz/JuJLX0jgrulmB7at6T6YqkycCpBBG" +
       "wzywKHKu7TWhTAeGDeLvai8xhJ+4/dvmR7/7mW3SdxK3J4iV9zz12z/bfd9T" +
       "O0dS7Ycvy3aPjtmm27nQt+xZOIAevNYs+QjsX59/4k8+9cS7t1Ldfjxx7IL3" +
       "os/8zX9/fffp73z1CjnJacv9ORwb3XpzrxoSyP6HLHFKeT3bbEzVacGrdhlV" +
       "2u66zUmaTA26FLVwuM1SwMOGI2xwn96keGVUUSoK3qqU+XKa1vk+0x/7ETYb" +
       "Ey4zZiy9LWleJHCGP7HLgl7aYIlJ9Qc13PBsc2Z404IpTrAO5wuwiamVZhpX" +
       "4kZUkW1DZD2v1uLSSmWdVmC1VVvJrXCjrNxSH50kpa67qNbdSQ+t1Olxl+Io" +
       "whHJMoqWx1irq5AEp1ZEzW3iEW2N2Ykz64vImih3Oq2uh2FENWGZqtcOGWLM" +
       "1ZCxKRWJujTWCrphm77fLY7Jfr3b8kNjQshdZN6ZDLn1wh1TbH8gM7bg+lN1" +
       "ZqKTpoGG/WG70o2XRdSRujOurAn6aFToDBYKKQd617QdcTY0dL+jwwiH+ozb" +
       "R5SOaXYbxWUguAMnmWAb1ucLpq8WxqvhPFlLDc3S14sIrS1g2KG6VRNvuP0a" +
       "i2GzJCymumvoiU110UG/7jXkXt90lsOei2BjeRLNYs4NBG3FagimVRBQLy31" +
       "abjyONdnmUoSlvXI55Ipi4iurc8jnaDqqe75Y2dDcyO8Ywd8aihoxIRpyfPY" +
       "mresbggR8RmJpujExCm2NxPLJkrSUYdE+h037q6FrokzbL3I2IMJkiwnGtuh" +
       "Z5tiR1oxXnvh9c3RYFAzbIJOymxJdxhjWF+06A0mjSciRU0Ra1Fa9swNaiyD" +
       "VWvALUeUJjSopV+2dLIQ9pB6aJb7mrKuIg2hGPT9AUNgAwCKcMmVSY5s421f" +
       "4cmx3vd435y2iwQuTIklwRJmT9ewOqNvukxphrjdxsR0+wNbaJZIIjVGhLme" +
       "9AJzHHNjBpsnkwbiYZ3K2nAwqjuYWY5h1KoO1ZKo1YZouqMNpwy4YdPoskwZ" +
       "LvtcaTTgqe7EmHTkNRomfUqptIuNZa3GDgt6t13VZipn0Q5PlWEpbmBWTStN" +
       "edtUbLkyGRcZrct266wj11hVrQfSPMQ3rCCYWljAbLZZGrKhydWLOkhgexRO" +
       "bFbFcnWYjuutVrWg0QnfavkDV7XGtu903c5SdzFKsPrDqNcwuv3ilHC4ZeL3" +
       "wZpIm4vaDI1bbYbB7EahxqWdTrFXWxCrQTSsqQXUKA80LbDdTlS1+oIoNDa+" +
       "3VHrSklvd2pqR8OdJUvAIxouEWZ70/dNjVlr7Xl/Nh7qC3ZRxteY5nSWVUrH" +
       "CST2ekhVEIoa3kHmLN1OUY3o4qEmaLGx6DJ4u+HVk4XYn42mCJDXRhOEmnF0" +
       "kxKxvroeynIAK2KxGFZgRcG6Ex0XeGuz5NJ22SfbRIvwNgNZXUgKKiaWZtZl" +
       "CwFAxYuYKGpUQ9VqpdXaBk/aMLE5Nu3Oaw06sokOEhK1TjhGUixJVWcJpy7d" +
       "Y92wbchetSMxHUPkbV7QYz0thYnbJKya5/dLslxREx+tzbqzyZAVkIAkR1ix" +
       "7uDa0O7NRnGxNJN0eap5fH3m6iSter7Z7gJEdnxpysx8fNTlK6VZOlU9CRtJ" +
       "o7XbXvuO1Ugbk5RyNnpTUBadKQrbSbjmxVAfE8tikR4KDVrq+aKVVJK6UIJb" +
       "A5oma+XCojKvEklIlWUz5RMhdWWWRIVWgzDJBrPaNGujRaPcWIqDam8x4Pi0" +
       "05/yVau4NGpcXSQ8J7IYZD3F5tPygEdlsxD4RH8xKVUUAB4cdhoq0caoaezg" +
       "hR7Pt0sSHEa4nS5Ycjlppw5qh9zAMckYj8QRXIAXvahCVcot265YMxtt00KV" +
       "Jaqen/Slkr1EWmFrZHS1VhPniyOKXvRaRbIphcwgHUVlBIAsbpeZTrc64ler" +
       "Ra+6mrYkR2wYUqU9IiTWcS3E86YUHjq1GcXFk5DyBD6FERMdrNsmRZUrxUEV" +
       "Gw2YqeZ3K8Iatuowv6JTNXUUbtRHdL0qTvSVM4/RIlmodSatZr1JSmzg8wTX" +
       "doQmby75iCzQXTn16o1lRxToVpdekT3YlxdrtqsZ48gAcSBsoAYdIk2hHVVV" +
       "flWNi7IT4KsQF6jqmIdbKyuZz4lJVWKAXaMe7VSsdtSKZMOxl8vZek5IfbIl" +
       "hFOOruvzWlJ2cao9XMrD6agaFHElHpvCut6eIChRluMIsWIz5LEl4yksDBfY" +
       "IB1LKyyhVLLuM3MmLXNOg5h1WM3eaP0qZRflsNDiHbQ3qLe96kAweiMqHXkG" +
       "Oi+M6cWsxbitlDfTllqgqKhWV2LJm3ieW7dEdxGw5FDXUrUwL4iUbtebPOuM" +
       "i2q/0x6HK7BHqPRyZjWcmh2WLJbCZwtkWhpX4UY1glvVcgW2y15Ua5qhNRcX" +
       "Io/2cZ5ShA2b9gNsvV7jYU2vNgs+uqpVx1HUFGoiMx6FQXk2cm0VDtbIsqyt" +
       "ANqkIEjhppfMGw2zKq2QOb4oYBuvpFromotXkV2ZL5detcoGjMLV2ixc9pB6" +
       "hStjYEvvYMESSdlZM9Lhio8iHYHF22KVsgyEbZOqJVJarTicg7g6CmOvsqTJ" +
       "MqIHskXNulUlmersmkaWrDS0MInsLdtVZN5Y1FNhJKFyg7D5zqBZTZvNhZAs" +
       "ZwW6FVdIOWzGiSQrUVxXx3OiSSYrC0/sElragJynmQhJ4DtlmUxtelptcH11" +
       "3qcKPqwb4xQTOYwdxSuNa6mqx3YjQlt2CY2ULKowJ4YxupQUf2E6nbQ5owZt" +
       "mF8yEqkOmtaabRAOGQs6x/U3SBByiDPoDIeOybTiFE27DUcaeX4X7zVRw1lW" +
       "jbVYKqFSa8WCDZyq2Ms+UYjreLsENyeq3iRdfD2ZxKkgVQvFfrG6SLBmr5FE" +
       "04LQ3YiOzaIDUtTGCp6alRm1asKUuB5rS6nsSTzS61Z9j8aX5CawaV3kpg5I" +
       "IVawuZqsVoWkSMieRMUL00VL63bVY2bjYEXzWFVbzdOUWmKrZn2sriY+ldYS" +
       "vqKumlGxXnc79MghVnCnJNRUemrV60KPgKWkheFrr9VrOq3BkPaLKVCH0kZj" +
       "uiG0Wiy/TJtSWSmknQE7omaisLHtyCwOda5Bj4iahbJ9pqZJKa2DlyNFjSv1" +
       "UrNenE+lTtO2eyXWxEbW2lgxZJmbiKLPGGS0rjrrrlQI5kgzgauDKuk4hY3O" +
       "4V25bxtC7BeDphQMncmSGU1ixx9o8iIwFW7CsSo3LrWrbazNVxCZHrlhUENR" +
       "m8JXGorXwC40SlMQMqi1qIt4DS82BBCkGac0bttGndF6yISYJuURqnpoag0X" +
       "Ua1skYXWKJHYcFCyHMTmh5WFOE6KaRFLnBnVWsjFPjPCu2plNikIPJ3GZFys" +
       "pzXUmvakzqjTcfsCWEp9v4XNGqtlryfJcKsC6wWUWRe8TUUscUUSCInhemGl" +
       "DxRH8Fcsqpcqjbgph16T8912040tnrIxYaoUkpSRN51JLBMlflxeNfmqb+jj" +
       "eYKZU0Yd4baDLqy02E1aTW86H3pwZUFOQapak3x0oPZw0hkoLt6dcvX1gkJX" +
       "3ZY+6bv9TaeAujOjuSnCGNOVywRI/JIpKRVsozLy+XYZbi+GWGpJcRCuDVJt" +
       "2CWGmc1DZ7kpRtPRmhlWVqtkqEyHcx5d1xJxMkNqLGcVJsNINHwX5cV5yx61" +
       "pmrg+JHElSjVbVh6ralFMouXuzV9xK3bfDWwyzgL3lxaUaPYipSCzG5CR0Ei" +
       "WjEILZlvrMZCLtEpkfQkeD4YV1UJlxJzOrCjAsAHBzfK/ThVcdqx1UVxHRpW" +
       "iWXRqrFAbRhOJQcrVtCVOKqDfKtT4Qbmuq4PhgFPDwBaliNLn3dCnmYdjrCN" +
       "SdhPsU1lNkxqxlxvrVfWMgqGjUoYr3ksmJqqCFNNlOuTFXQ5iVvMjLD84SKu" +
       "FPleiYm0VWwN+Fp/qbWCMNARmZOmfNRcbNZ9FOAXhHmrn84BouFizVgoCavA" +
       "Cdbim60BeCsRu+UFOsfHCJK9Fr755b2Z35YfQhzcN4EX8qyj9zLeSLddD2bF" +
       "IwcHl/nnzMk7iqMHl4enWVD2ln3v1a6R8jfsjz/51LPy6BOlnb1TwEUE3Ri5" +
       "3i9bykqxThyMPXb104Rhfot2eDr15Sf/7Z7pG/S3vowz9/tPyHmS5e8Nn/sq" +
       "/hrpgzvQdQdnVZfd7x0f9PjxE6pzAdigAmd67Jzq3gPL3p5Z7D7w1PYsW7vy" +
       "ufcVUXAqR8HW99c4ZA2v0RdnhRNBN2tKRLqSYFF7ovcO4eK+1AHGUaZ5g3m5" +
       "foM9/Qb/N/qdzQnO7h+uPXK1u6Dthc/eJfI+9R0Z9boi7cquvbt3M5R1PblP" +
       "8OBl7LRVtIsHgqcbUki5srJPWbyMMoOpsI52DVsA8weKIytBdui+ixlWpAT7" +
       "A1+VH85lhJoCpJgoEkCPZill9Ngh1XHQT4R1vpIuSX88/s43nkmff257BiUK" +
       "oRJBhavd7V/+94LsOuiRa1xpHd76/gh/3Qvf++f5m/fX6k0Hrr0/8+RD4Bnv" +
       "uXZ80rX7ut5yeJI+FPK+9+e83n4NYH4wK1IATClQhEjZGi9re9chMN/2cwDz" +
       "FVnjY+D52J70H3sZwNwBAcsL3Ag4TZHzKHxFkJ7OiU/n0DpcU8Agj70EapAJ" +
       "3u7oIIIp+R37O3Luz1zDWh/Lio9E0J2S66yUINobzCjZBY6b2+3ZQ7s9/XLs" +
       "tgHL4SVvVLProbsv+4PH9k8J0mefPX/DXc/O/ja/VDz448CNJHSDGlvW0dP8" +
       "I/UzXqCoRq7cjduzfS//+lQE3XWVxR5BZ7aVXIdPbul/P4IunKSPoOvz76N0" +
       "n42gc4d0gNW2cpTk8xF0HSDJql/w9l35xqtFHkQMo0CQosx2OXgPTpqPWW5z" +
       "6vjeeeCk21/KSUe224ePLeX8/zj7G1pM70WM55/tU297sf6J7RWpZAlpmnG5" +
       "gYTObm9rDzbFB6/KbZ/Xmd6jP731czc+sh8Ubt0KfLhijsh2/5XvI7u2F+U3" +
       "iOkf3fUHr//ks9/KLyX+F7vA4m0oJQAA");
}
