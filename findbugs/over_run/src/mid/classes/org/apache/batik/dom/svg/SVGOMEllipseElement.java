package org.apache.batik.dom.svg;
public class SVGOMEllipseElement extends org.apache.batik.dom.svg.SVGGraphicsElement implements org.w3c.dom.svg.SVGEllipseElement {
    protected static org.apache.batik.util.DoublyIndexedTable xmlTraitInformation;
    static { org.apache.batik.util.DoublyIndexedTable t = new org.apache.batik.util.DoublyIndexedTable(
               org.apache.batik.dom.svg.SVGGraphicsElement.
                 xmlTraitInformation);
             t.put(null, SVG_CX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_CY_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             t.put(null, SVG_RX_ATTRIBUTE, new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_WIDTH));
             t.put(null, SVG_RY_ATTRIBUTE,
                   new org.apache.batik.dom.svg.TraitInformation(
                     true,
                     org.apache.batik.util.SVGTypes.
                       TYPE_LENGTH,
                     PERCENTAGE_VIEWPORT_HEIGHT));
             xmlTraitInformation = t; }
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      cx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      cy;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      rx;
    protected org.apache.batik.dom.svg.SVGOMAnimatedLength
      ry;
    protected SVGOMEllipseElement() { super(
                                        );
    }
    public SVGOMEllipseElement(java.lang.String prefix,
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
        cx =
          createLiveAnimatedLength(
            null,
            SVG_CX_ATTRIBUTE,
            SVG_ELLIPSE_CX_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            false);
        cy =
          createLiveAnimatedLength(
            null,
            SVG_CY_ATTRIBUTE,
            SVG_ELLIPSE_CY_DEFAULT_VALUE,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            false);
        rx =
          createLiveAnimatedLength(
            null,
            SVG_RX_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              HORIZONTAL_LENGTH,
            true);
        ry =
          createLiveAnimatedLength(
            null,
            SVG_RY_ATTRIBUTE,
            null,
            org.apache.batik.dom.svg.SVGOMAnimatedLength.
              VERTICAL_LENGTH,
            true);
    }
    public java.lang.String getLocalName() {
        return SVG_ELLIPSE_TAG;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getCx() {
        return cx;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getCy() {
        return cy;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getRx() {
        return rx;
    }
    public org.w3c.dom.svg.SVGAnimatedLength getRy() {
        return ry;
    }
    protected org.w3c.dom.Node newNode() {
        return new org.apache.batik.dom.svg.SVGOMEllipseElement(
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
      ("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" +
       "lN4y2F7L24XYLLbhWanlhuA07sNmbYhA3ypGreCMfzfDsZrbgkemmHlksgfa" +
       "SqaGziGIUeC721UxhzmBa7sqBCi92NzKh27CptPU/Bv/m7OxY4XJMZv3Yc0z" +
       "ryip8GLGjYcfnnv03ecu/rjKPAotDE4CPr7mf/XJQzv/8lkRTHn4L3FM8/EP" +
       "xo89Nqvrlg84vxuHkXtBvjhJQ6Zyeb9+NPtJtKXyhSipGiQNolU4rBfkHEa3" +
       "QTgsG3Y1AcVFwXjhwdc85XU4eeZqfw7wTOvPAO7hAN6RGt8n+4L+dFya5fC0" +
       "W4Br9yM4QvjLhtIgjuLrEkCywcsTH5KnhQhmZGo+K6/TBYn1KDxZOasDgP1a" +
       "EWD5Dr1dhQ0DdWWK5qG+xSjqbjCOyLsvhciBwnzXZplvu6GU6aJpOjbtxVkk" +
       "iJuRqOWO5ksezToVKYvn6gRVhs3DsMek1GWY1Gkp1RlgkhxqUhA3mrQN3/wq" +
       "Zi9DxW5rku4AFY1QFYO4QUU9X0pFdhkq3mlNcmeAimOhKgZxo4olvXhviIp5" +
       "d6ouZyr+U0msGsn+7c8WZqyN2FCcj1AcXSZ6EVhYGmCqnhNU+PKifXzn/sOp" +
       "viNLzZjcVFhMrlRy2cf/8J9XYwf/9HKJKqWGqdoSmY5Q2aNdDUw5vygT9PJ7" +
       "ATes3nT6Ytm5h5vriisLlDQ3oG5oD04Z/gle3PmPWetuyWyaQMlwjc9RfpE/" +
       "6z328qprxYej/GrDjOJFVyKFTB2FsbtWpyynK+sKInhLIVqvg2eTBYJNfrR6" +
       "ziABUA1iDTkK7A8ZO4DNXkZmSwoc9fFGinbKckIaoc41omGE5vJ+XcoC64h1" +
       "ZRLf3nR+y2PvPW7izZ+4fcR09/4Hv4zt2W9iz7yEWlB0D+TlMS+iuOoNpnO+" +
       "hJ8IPF/gg3ZhB/6G9Nxl3YbMc65DNC3P8RuiFp+i++/Ht//mp9t3RS0/7WKk" +
       "fESVUm4IeGjiByre/X1nTetwaBE8GWtNMyFwKHEkrdJ0aQSM8mXySSESQ5Dw" +
       "85Cxx7EZZ6TZRUkhRHD8Udc3R67YN004hMf1McuSsUtsla5CJ9SGsIYY+kzI" +
       "2K+xeYqRumHKEqooyGusjb/aNfwXV2z4HBxqgWeHpf2OiRsexBpi3PMhYy9g" +
       "c4KRCjC8yzknlUpOhYcj1y3PfXVu2W3ZtnvibgliDTH9VMjYG9i8armFnxJe" +
       "dC1+7auzeK+l9t6JWxzEGmLV2yFj57E5Y1o8kPdZfPars/iApfaBiVscxBpi" +
       "1fshYx9g81fLYv8a/+2KLZ6KQ7PgOWSpfegSFpc4EASxhlj1ScjYRWw+huSi" +
       "0NE1cESzt3uDd7s7A9wPF67YD3iVSW6GZ9wyZnzifghiDbY1UhYyVoGdX0DK" +
       "g5X3V75ONZt0nfDlZdyvQF1d4rofb7qaiz45mp/JxCcO11fPPHzXH/mVs/Mp" +
       "qy5BqtM5WfZeI3jeKzWdpiXuwzrzUkHjNtaBeUHVLiNl0KLmkUkmdT0j00pR" +
       "AyW0XsomCy5eSthD/LeXbjojtS4dI5Xmi5cEkFcGJPh6lWZjcVFYib5KF7SM" +
       "JBp2hRTx1C5WbcYXbPqlFsxh8V5q4/GXfzW2a4ic+d04KR4/fMeaey/ceMS8" +
       "VBdlYWwMpUxKkCrzft+pQ+YHSrNlVa5e+PmUJ2va7NNno6mwuwlme3bsCjgM" +
       "agiaWb7rZqPVuXU+O778xGu7K0/DQXsjiQgAvI3FV1d5LQdF0saEt7jz/O8B" +
       "vwnvqH130+ufvRVp4nesBItVPOWHcCTFfSfO9ac17UdRUtNDKiS8EeL3ardv" +
       "UwaoOKL3kOqcIm3N0Z4UYHVIzSnOB+YpiHABr0e5ZyyHTnZ68aMMIy3FJUPx" +
       "h6paWR2l+m0oHcVM9lVuOU3zjubxw2sJq2Btlh76533fO9MHO7BAca+0KiM3" +
       "5BSB3u/XpmxsG7B5LI+rCBBPJno1zSpcyh/lq6ppGCUiS/huWGRSIwUjkXZN" +
       "+y84vKAqhyIAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "8P8DfOij7fkuAAA=");
}
