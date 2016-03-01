package org.apache.batik.dom.svg;
public abstract class SVGPointShapeElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGAnimatedPoints {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_POINTS_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_POINTS_VALUE));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedPoints
      points;
    protected SVGPointShapeElement() { super(); }
    public SVGPointShapeElement(java.lang.String prefix, org.apache.batik.dom.AbstractDocument owner) {
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
    private void initializeLiveAttributes() { points =
                                                createLiveAnimatedPoints(
                                                  null,
                                                  SVG_POINTS_ATTRIBUTE,
                                                  "");
    }
    public org.apache.batik.dom.svg.SVGOMAnimatedPoints getSVGOMAnimatedPoints() {
        return points;
    }
    public org.w3c.dom.svg.SVGPointList getPoints() {
        return points.
          getPoints(
            );
    }
    public org.w3c.dom.svg.SVGPointList getAnimatedPoints() {
        return points.
          getAnimatedPoints(
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
      ("H4sIAAAAAAAAAL1Za3AUxxGeO72FhB68FN4IQUUC7kwwUI6IsRAvwQldSZiK" +
       "pcTHam9Ot2hvd9mdkw5sBUMqgfgH5QB2iGNIqoLzINhQLrvyKhOlUn7Fdlxg" +
       "l2NMYpz4R5zYVJlUYpyQxOme3b3d27tbQkjlqnZubqe7Z7r7m+6euVOXSZmh" +
       "k2ZNUOJCiO3SqBGKYj8q6AaNd8qCYWyFtzHx/t8d3nP11aq9QVLeTyYmBaNb" +
       "FAy6XqJy3OgnsyTFYIIiUmMLpXHkiOrUoPqIwCRV6SdTJKMrpcmSKLFuNU6R" +
       "YJugR0iDwJguDaYZ7bIEMDInwlcT5qsJd3gJ2iOkRlS1XQ7D9ByGTtcY0qac" +
       "+QxG6iM7hBEhnGaSHI5IBmvP6GSRpsq7hmSVhWiGhXbIyy1DbIoszzND85m6" +
       "D689kKznZpgkKIrKuIpGLzVUeYTGI6TOebtOpiljJ/kCKYmQCS5iRloi9qRh" +
       "mDQMk9r6OlSw+lqqpFOdKleH2ZLKNREXxMi8XCGaoAspS0yUrxkkVDJLd84M" +
       "2s7Namu726Pig4vCR752d/0TJaSun9RJSh8uR4RFMJikHwxKU4NUNzricRrv" +
       "Jw0KOLyP6pIgS7stbzca0pAisDRAwDYLvkxrVOdzOrYCT4Juelpkqp5VL8FB" +
       "Zf0qS8jCEOg61dHV1HA9vgcFqyVYmJ4QAHsWS+mwpMQ5jnI5sjq2bAYCYK1I" +
       "UZZUs1OVKgK8II0mRGRBGQr3AfiUISAtUwGCOsdaEaFoa00Qh4UhGmOkyUsX" +
       "NYeAqoobAlkYmeIl45LAS9M9XnL55/KWVQfvUTYqQRKANcepKOP6JwDTbA9T" +
       "L01QncI+MBlr2iIPCVOfPhAkBIineIhNmh/ee+WOxbPHnzdpZhSg6RncQUUW" +
       "E08MTjw3s7P1thJcRqWmGhI6P0dzvsui1kh7RoNIMzUrEQdD9uB477N33XeS" +
       "vhck1V2kXFTldApw1CCqKU2Sqb6BKlQXGI13kSqqxDv5eBepgH5EUqj5tieR" +
       "MCjrIqUyf1Wu8t9gogSIQBNVQ19SEqrd1wSW5P2MRgiph4fMhWcBMT/zsWFE" +
       "CSfVFA0LoqBIihqO6irqjw7lMYca0I/DqKaGBwH/w0uWhlaGDTWtAyDDqj4U" +
       "FgAVSWoOhuNqKmyMALC2bYiqgNy+pKBRDBNUgdADuNP+7zNm0AaTRgMBcM9M" +
       "b3CQYV9tVOU41WPikfSadVcej71oAg83i2U9RpbAtCFz2hCfNgTThmDaUKFp" +
       "SSDAZ5uM05tAADcOQ0CAiFzT2vf5TdsPNJcAArXRUvBBEEgX5mWoTidy2OE+" +
       "Jp4613v1lZerTwZJEILLIGQoJ0205KQJM8vpqkjjEKeKJQw7aIaLp4iC6yDj" +
       "R0f3bttzC1+HO/KjwDIIWsgexXidnaLFu+MLya3b/+6Hpx8aU529n5NK7AyY" +
       "x4khpdnrW6/yMbFtrvBU7OmxliAphTgFsZkJsJcg7M32zpETWtrtMI26VILC" +
       "CVVPCTIO2bG1miV1ddR5w0HXwPuTwcUTca81w9NubT7+jaNTNWynmSBFzHi0" +
       "4GngM33asTd+9cdl3Nx2xqhzpfo+ytpdUQqFNfJ41OBAcKtOKdD99mj08IOX" +
       "9w9w/AHF/EITtmDbCdEJXAhm/tLzOy9ceuvEa8EsZgOMVGm6ymDj0ngmqycO" +
       "kVofPRHqzpIg0MkgAYHTcqcCwJQSkjAoU9wn/6hbsPSp9w/Wm1CQ4Y2NpMXX" +
       "F+C8/8Qact+Ld1+dzcUEREy0jtkcMjN6T3Ikd+i6sAvXkdl7ftbXnxOOQR6A" +
       "2GtIuykPp4SbgXC/3cr1D/N2mWdsBTYthhv/uVvMVRDFxAde+6B22wdnr/DV" +
       "5lZUbnd3C1q7iTBsFmRA/DRvrNkoGEmgu3V8y+fq5fFrILEfJIoQQ40eHeJd" +
       "JgccFnVZxZs//8XU7edKSHA9qZZVIb5e4PuMVAHAqZGEUJnRVt9hOne00s4r" +
       "GZKnPNpzTmFPrUtpjNt294+mPbnqu8ff4rjiEmZloTQBpcyBp9OCUmfhLYPt" +
       "Qt62YrPYhme5lh6EgtyDzWofgR4vBq3gjL+boLLmumDVFDKrJntgQcHc0DEI" +
       "MQpst1YV05gT+Go3+AClG5s7+NBKbDrMlX/6PzM2vlhtcszIJpW5eUmFn2ec" +
       "ePj+xW+887Or364wq6HW4knAw9f09x55cN/vP8qDKQ//BSo1D39/+NQj0ztv" +
       "f4/zO3EYuedn8rM0ZCqH91MnU38NNpc/EyQV/aRetM4O2wQ5jdGtH+plwz5Q" +
       "wPkiZzy39jULvfZsnpnpzQGuab0ZwKkOoI/U2K/1BP0p6JpV8LRZgGvzIjhA" +
       "eOezhUEcxO4SQLLBTygeJE/2EczIpExK3qoLEutSeLLKegcA+8k8wPIdulaF" +
       "DQNHyzjNwBEXo6izwTgi77oeIntz810rPCusFa4oorpoqo5NW34WKcaNuxuL" +
       "LsNWabFffdbT3aFIKSyveaVmeNSK+6iV8fHMWkYqBWuXO77hnzpildf2tzfK" +
       "mHs0YC9/Hi5/dJnoXnXumjHEzyp2ZuLnvRP7jhyP9zy61NzLjbnnkHVwzH7s" +
       "9X++FDr69gsFytsqpmpLZDpCZdfqymHKeXkRpJsfKZ3tuPL81ZKLh5pq8itS" +
       "lDS7SL3ZVjzUeCd4bt+fpm+9Pbn9BkrNOR5DeUV+v/vUCxsWioeC/FRs7v68" +
       "03QuU3vunq/WKRz/la05O785F/63wLPZAsFmn9xVBPvFWH1SyF6fsS9icy8j" +
       "MyQFSkS8zKAdshyRRmj2BsowfHNAVJdSwDpinbbDY42Xhh959zETb96A7yGm" +
       "B47c/3Ho4BETe+b9xfy8KwQ3j3mHwZdebxrnY/gE4PkXPqgXvsBvCOud1kF6" +
       "bvYkrWkZjl+fZfEp1v/h9NhPvze2P2jZiTFSOqJKcSc+jN14IuavnZhQg0OL" +
       "4OmzfNrnA4cCpUyFpksjoJQnA0zwkeiDhKM+Yw9j81VGmhyU5EIExw84tjl0" +
       "07bBCo8sh2fA0mTgOlulM7+gK8bqo+gJn7HvYPNNOCkMUVYkfSQdE3zrpk3Q" +
       "hEPz4BEtPcQbN0ExVh81z/iMPYHNDyAxgAmiOZl2ZoFUxSmwnnescup/YxUs" +
       "IYYt1YZv3CrFWH00P+szNo7NjxlpAKvkY+JJR/uf3LT2CAdyGzy6pYJ+He0L" +
       "ZJBirD4a/tJn7CVsnoHYANp7S8tsuRhzjPDsf3GAYWRyoQs1PEs25d3rm3fR" +
       "4uPH6yqnHb/z1/xSJ3tfXBMhlYm0LLsLdVe/XNNpQuJ61Zhlu8a/XgX9itWS" +
       "jJRAy5d+3qR+HdZbiBoooXVTXoADpJeSkTL+7ab7DSPVDh3UuWbHTXIJpAMJ" +
       "dt/W7G25yK8A3qALWlISDcuamYCryrMwxz025Xoey7K4r42wUOB/zdjVVtr8" +
       "cyYmnj6+acs9V1Y8al5bibKwezdKmRAhFeYNWrZim1dUmi2rfGPrtYlnqhbY" +
       "ebrBXLCzC2a4oLoa0qaGoJnuudAxWrL3OhdOrDr78oHy81CSDJCAAEemgfzD" +
       "YUZLQzk5EHGXwa4/+PhdU3v1O9tf+ejNQCO/xSBY1mM95MMREw+fvRhNaNrD" +
       "QVLVRcokPHPxk+vaXUovFUf0LlKZVqSdadoVB6wOqmkl+y/ORES4gBcQ3DKW" +
       "QWuzb/Hak5Hm/OIq/yq4WlZHqb4GpaOYWk+Nm9Y092gG/90ooBX4Zumxv+35" +
       "8hs9sANzFu6WVmGkB7PlsvtPIlM2tvXYfCWDXgSIxyLdmmaVeGXV3KuaxsPE" +
       "X7jSfzapkYKRQJum/Ru6+VtR7B0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
