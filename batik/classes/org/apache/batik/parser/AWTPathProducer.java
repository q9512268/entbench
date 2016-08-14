package org.apache.batik.parser;
public class AWTPathProducer implements org.apache.batik.parser.PathHandler, org.apache.batik.parser.ShapeProducer {
    protected org.apache.batik.ext.awt.geom.ExtendedGeneralPath path;
    protected float currentX;
    protected float currentY;
    protected float xCenter;
    protected float yCenter;
    protected int windingRule;
    public static java.awt.Shape createShape(java.io.Reader r, int wr) throws java.io.IOException,
        org.apache.batik.parser.ParseException { org.apache.batik.parser.PathParser p =
                                                   new org.apache.batik.parser.PathParser(
                                                   );
                                                 org.apache.batik.parser.AWTPathProducer ph =
                                                   new org.apache.batik.parser.AWTPathProducer(
                                                   );
                                                 ph.
                                                   setWindingRule(
                                                     wr);
                                                 p.
                                                   setPathHandler(
                                                     ph);
                                                 p.
                                                   parse(
                                                     r);
                                                 return ph.
                                                   getShape(
                                                     );
    }
    public void setWindingRule(int i) { windingRule =
                                          i;
    }
    public int getWindingRule() { return windingRule;
    }
    public java.awt.Shape getShape() { return path;
    }
    public void startPath() throws org.apache.batik.parser.ParseException {
        currentX =
          0;
        currentY =
          0;
        xCenter =
          0;
        yCenter =
          0;
        path =
          new org.apache.batik.ext.awt.geom.ExtendedGeneralPath(
            windingRule);
    }
    public void endPath() throws org.apache.batik.parser.ParseException {
        
    }
    public void movetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void movetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          moveTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void closePath() throws org.apache.batik.parser.ParseException {
        path.
          closePath(
            );
        java.awt.geom.Point2D pt =
          path.
          getCurrentPoint(
            );
        currentX =
          (float)
            pt.
            getX(
              );
        currentY =
          (float)
            pt.
            getY(
              );
    }
    public void linetoRel(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoAbs(float x, float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public void linetoHorizontalRel(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX +=
                 x),
            yCenter =
              currentY);
    }
    public void linetoHorizontalAbs(float x)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              (currentX =
                 x),
            yCenter =
              currentY);
    }
    public void linetoVerticalRel(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY +=
                 y));
    }
    public void linetoVerticalAbs(float y)
          throws org.apache.batik.parser.ParseException {
        path.
          lineTo(
            xCenter =
              currentX,
            yCenter =
              (currentY =
                 y));
    }
    public void curvetoCubicRel(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX +
              x1,
            currentY +
              y1,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicAbs(float x1,
                                float y1,
                                float x2,
                                float y2,
                                float x,
                                float y) throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            x1,
            y1,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoCubicSmoothRel(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              currentX +
                x2,
            yCenter =
              currentY +
                y2,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoCubicSmoothAbs(float x2,
                                      float y2,
                                      float x,
                                      float y)
          throws org.apache.batik.parser.ParseException {
        path.
          curveTo(
            currentX *
              2 -
              xCenter,
            currentY *
              2 -
              yCenter,
            xCenter =
              x2,
            yCenter =
              y2,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticRel(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX +
                x1,
            yCenter =
              currentY +
                y1,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticAbs(float x1,
                                    float y1,
                                    float x,
                                    float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              x1,
            yCenter =
              y1,
            currentX =
              x,
            currentY =
              y);
    }
    public void curvetoQuadraticSmoothRel(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX +=
              x,
            currentY +=
              y);
    }
    public void curvetoQuadraticSmoothAbs(float x,
                                          float y)
          throws org.apache.batik.parser.ParseException {
        path.
          quadTo(
            xCenter =
              currentX *
                2 -
                xCenter,
            yCenter =
              currentY *
                2 -
                yCenter,
            currentX =
              x,
            currentY =
              y);
    }
    public void arcRel(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX +=
                 x),
            yCenter =
              (currentY +=
                 y));
    }
    public void arcAbs(float rx, float ry,
                       float xAxisRotation,
                       boolean largeArcFlag,
                       boolean sweepFlag,
                       float x,
                       float y) throws org.apache.batik.parser.ParseException {
        path.
          arcTo(
            rx,
            ry,
            xAxisRotation,
            largeArcFlag,
            sweepFlag,
            xCenter =
              (currentX =
                 x),
            yCenter =
              (currentY =
                 y));
    }
    public AWTPathProducer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVbDZAUxRXu3fvljuP++DkQjr8D5W9XiAStQ+NxHt7hApc7" +
       "PPVQj7nZvruB2Zlhpvdu7wwGrTKQpKSMohJLMamgGErEMlgxogaLGDEaDYox" +
       "YomWsSJKKKUS0QpG817P7M7uzM4ua2W3at7Odvfrfu/r916/nul99BQpMnRS" +
       "TxUWYMMaNQItCmsXdIOGm2XBMNZAWY94b4HwrxtPrLrET4q7yZgBwVgpCgZd" +
       "LlE5bHSTKZJiMEERqbGK0jBytOvUoPqgwCRV6SbjJKMtosmSKLGVaphigy5B" +
       "D5FqgTFd6o0y2mZ1wMiUEEgS5JIEm5zVjSEyWlS1Ybt5XVLz5qQabBmxxzIY" +
       "qQqtFwaFYJRJcjAkGawxppN5mioP98sqC9AYC6yXF1sQrAgtdkEw4/HKM2fv" +
       "GKjiENQKiqIyrp7RQQ1VHqThEKm0S1tkGjE2kptJQYiUJzVmpCEUHzQIgwZh" +
       "0Li2diuQvoIq0UizytVh8Z6KNREFYmR6aieaoAsRq5t2LjP0UMos3TkzaDst" +
       "oa2ppUvFu+cFt997Y9UTBaSym1RKSieKI4IQDAbpBkBppJfqRlM4TMPdpFqB" +
       "ye6kuiTI0og10zWG1K8ILArTH4cFC6Ma1fmYNlYwj6CbHhWZqifU6+MGZf0q" +
       "6pOFftB1vK2rqeFyLAcFyyQQTO8TwO4slsINkhJmZKqTI6Fjw1XQAFhLIpQN" +
       "qImhChUBCkiNaSKyoPQHO8H0lH5oWqSCAeqMTPLsFLHWBHGD0E970CId7drN" +
       "Kmg1igOBLIyMczbjPcEsTXLMUtL8nFq1dNtNSqviJz6QOUxFGeUvB6Z6B1MH" +
       "7aM6BT8wGUfPDd0jjH92q58QaDzO0dhs89sfnL58fv3Bw2ab89K0Wd27noqs" +
       "R9zVO+bI5OY5lxSgGKWaakg4+Smacy9rt2oaYxpEmPGJHrEyEK882PHH6zbv" +
       "oSf9pKyNFIuqHI2AHVWLakSTZKpfSRWqC4yG28goqoSbeX0bKYH7kKRQs3R1" +
       "X59BWRsplHlRscp/A0R90AVCVAb3ktKnxu81gQ3w+5hGCCmBiyyDayYxP/yb" +
       "ke7ggBqhQUEUFElRg+26ivobQYg4vYDtQLAXrH5D0FCjOphgUNX7gwLYwQC1" +
       "KjT0Lz3YdM2adhgP2MNRkeoBtDEtr73HULfaIZ8PYJ/sdHoZ/KVVlcNU7xG3" +
       "R5e1nH6s52XToNAJLFQYOR8GDJgDBviAAXPAgGNA4vPxccbiwObUwsRsABeH" +
       "GDt6TucNK9ZtnVEANqUNFQKq2HRGylrTbMeBePDuEffVVIxMP77wkJ8UhkiN" +
       "ILKoIOPS0aT3Q1ASN1h+O7oXViF7MZiWtBjgKqarIg1DLPJaFKxeStVBqmM5" +
       "I2OTeogvVeiUQe+FIq385OCOoVu6fnihn/hT4z8OWQShC9nbMWononOD0+/T" +
       "9Vu55cSZffdsUu0IkLKgxNdBFyfqMMNpCU54esS504Qne57d1MBhHwURmgng" +
       "URD86p1jpASYxniwRl1KQeE+VY8IMlbFMS5jA7o6ZJdwE61GMs60VjQhh4A8" +
       "zl/aqT3wt1c//g5HMr4kVCat5Z2UNSaFIeyshgecatsi1+iUQrt3d7Tfdfep" +
       "LWu5OUKLmekGbEDaDOEHZgcQvO3wxrffO77rqN82YQbrcLQX0pkY12XsN/Dx" +
       "wfU1Xhg6sMAMITXNVhyblghkGo4825YNQpoMjo/G0XC1AmYo9UlCr0zRf76q" +
       "nLXwyX9uqzKnW4aSuLXMz96BXT5xGdn88o1f1PNufCIuqTZ+djMzTtfaPTfp" +
       "ujCMcsRueX3Kz18UHoCID1HWkEYoD5yE40H4BC7mWFzI6UWOuiVIZhnJNp7q" +
       "RkmpT494x9HPKro+e+40lzY1d0qe95WC1mhakTkLMFgzsUhKIMfa8RrSCTGQ" +
       "YYIzULUKxgB0dtHBVddXyQfPwrDdMKwIQddYrUOYjKWYktW6qOTY84fGrztS" +
       "QPzLSZmsCuHlAnc4MgosnRoDEGFj2vcuN+UYKgVSxfEgLoRcBTgLU9PPb0tE" +
       "Y3xGRp6asH/p7p3HuVlqZh/ncf5iDPopEZan6baT73ljyZu7f3bPkLnQz/GO" +
       "bA6+uv+slntv/eBL17zwmJYmCXHwdwcfvX9S82UnOb8dXJC7IeZeqCBA27yL" +
       "9kQ+988ofsFPSrpJlWilxV2CHEW/7oZU0IjnypA6p9SnpnVmDtOYCJ6TnYEt" +
       "aVhnWLMXSLjH1nhf4bDBMTiF58N1gWWDFzht0Ef4zQrOMpvTOUjmx6PLKE1X" +
       "GUhJw7FEt9wyKjJ0y8yshjPUMbLQtXzj9ApDLNBP1UigJcYgb6JhMyrJ7VY+" +
       "VMvZL0ZylTn2Uk8TviJV5SlwLbBkW+Ch8tWmykhWujXz4makVIzqsNiwa1OT" +
       "B1ygO6O9Biz0UgSC/6CV7S5qXydubWj/0DTwiWkYzHbjHgne3vXW+lf40lKK" +
       "qcSa+KQmJQqQciQtWVVIAhhHMjiOQ57gppr3Ntx/Yq8pj9NLHI3p1u0/+Saw" +
       "bbsZ8s39zEzXliKZx9zTOKSbnmkUzrH8o32bDjyyaYspVU1qdt4Cm8+9f/3v" +
       "K4Ed77+UJjkEt1AFlghcvkRqNzYVbFOlK35c+cwdNQXLIatoI6VRRdoYpW3h" +
       "VH8qMaK9SejbOyXbxyzlcHFlxDcXop7DZLu+hckusoxukYfJbshosl7ctsle" +
       "h7+vdwgq5yjoZLiWWEMt8RBUzyioFzcjJbFmitvodHIa30LOpdZISz3kHM4o" +
       "pxc3yDnsLedIjnLWw9VkjdTkIefmjHJ6cTNSPgS+JSn9HVHZTHW7LZ/ErxuS" +
       "7gVGCiTF5UT4s99p2bdkUDDmsY7g7QJ7AeGfYuKdGyWlEP74KjLTaxOIC0ar" +
       "oIQhs423neXVtnNAwAeC5nYRY9MUryccPC7tunX7zvDqhxb6reSxFxZEpmoL" +
       "ZDpI5SQhJ2JPKXnOSv5Mx04a3h1z599/19C/LJdNJJbVZ9km4u+pEDPneq8A" +
       "TlFevPWTSWsuG1iXw35wqgMlZ5e/XvnoS1fOFu/08wdYZjbjevCVytSYGnPL" +
       "dMqiupIaZWcmLKYubiWtlsW0Ol3FtlKX+fm5+cFOyeDPEB2JTHWGXh37CH+q" +
       "RY7hebGkBjqoEDajwW1cjl9l5quN87WtbomJVEuAD3Wzva0cvhLN+TC7kdwP" +
       "bi7qFHZz3LZTZcMcyy7m7vtAtviUeTuABcs0Xr4jgWM51s2C61oLx2szzA6S" +
       "21OnoCwDqwPKpMhkYv1Uhr3e00h+A2AYlF3jCIWO8Fc4qEphG6X9eUCpEutw" +
       "ne+xVO3JHSUv1gwgHM5Q9yckhwCg/hSAOLo2GH/IAxjodWQiXAOWRgO5g+HF" +
       "mkHhNzPUvYXkL5AuARjcafD3XhuGI/nynPPgUi1d1Nxh8GLNoOoH3l61hzf4" +
       "EMm7sNpByNRZfEv2jA3G8XyBgTYxYmk0kjsYXqwZwPg0GxinkXzC+IP+NFCc" +
       "zBcU8+DabOmzOXcovFjTL074k+ey1/Ouv8oGytdIvgALiUAqwtQOKjtg+TKf" +
       "sGyxdNuSOyxerOcCi29UFlh85UgKE7A09RqpsPiK8hlFtlm6bcsdFi9Wb8fx" +
       "jc8GRh2SagBDlFWDul3HV5NPG9lhabQjdzC8WM/JRmZmg2UWknqABV8RpnEd" +
       "39R8wvKgpduDucPixXpOsFyYDZZFSOYlYHG7zvx8wTIfroct3R7OHRYvVm+F" +
       "TUQuzYbI95BcDBsGE5FWVZdG8FG17DaZS/KJzV5Lwb25Y+PFmg2bFdmwCSFp" +
       "SYON226W5wubuXDttxTcnzs2XqzZsLkmGzb4oM/XwUi1iU0X1WHbm85qOvOJ" +
       "zAFLvQO5I+PFmg2ZcDZk+pD0uJBx28y6fCGzEK4XLPUO5Y7MIQ9Wh+LF5uu3" +
       "jYkQnI5wRDZmgwxrfDIjlWJUx5SmOdoriW5TiuQTsCOW1q/lDthrHqzfGrCb" +
       "swG2GcmwAzC3hWV9UPxtAcPn6u9YWh/LHbBjHqwOtQu5IIWeMP00G0y3I/kR" +
       "I+OSYeqMqCobcFvXlnyC9bGl8YncwTrhwZojWDuygXUfkrvSguW2rO35Amsx" +
       "XF9YGp/JHawzHqw5gvVQNrDwuajvF5AaWGB9PyqEdXzy67arX+YRKp/P7NP8" +
       "ygkqi9PNmiNUT2SDaj+SvWmgclvVY/mCqhEkKrX0Lc0dKi9Wh+rpNyW/zwbQ" +
       "80ieZmSiEyCvSHUgnzDVWrrW5g6TF+s5wfRKNpheRfKiJ0xuazqcL5guALlm" +
       "WLpOzR2mqR6sDgBKuCAlDp/j1RnesZb0qqpMBSUdjvw9q++YA/i3swH/PpKj" +
       "jBQLeprw9mY+UQ5YUM3LHeV5HqznhHIcJxdYJ7OBdQrJP0yw3Cb50f8DrBjk" +
       "fY5TyXiErs71dwfziL742M7K0gk7r36LvxdOHKMfHSKlfVFZTj7klXRfrOm0" +
       "T+I4jzaPfPHzJ77PGZng8f4Qz4nyG57O/9ts/yUjVc72jBTx7+R2Zxkps9sh" +
       "fvwmucnXjBRAE7z9xrSYOuicv4TEs24B86xbjO8mrJfmFoj8YfG4bNgnWJJP" +
       "yuKrbv53k/hr6aj5h5Mecd/OFatuOv3dh8yTuqIsjIxgL+UhUmKeB+ad4qvt" +
       "6Z69xfsqbp1zdszjo2bFDwGknBROlo1bABgcP1U7yXF01WhInGB9e9fS5/68" +
       "tfh1P/GtJT6IC7Vr3acCY1pUJ1PWhtyHmLoEnZ+pbZxz3/Bl8/s+fYefuyTm" +
       "oafJ3u17xKO7b3jjzrpd9X5S3kaKJCVMY/y44hXDSgcVB/VuUiEZLTEQEXqR" +
       "BDnlhNQYNE4B/4jCcbHgrEiU4hFuRma4j4e5D76XyeoQ1ZepUSWM3VSESLld" +
       "Ys6M43RAVNMcDHaJNZVI+8x4i7MB9tgTWqlp8fPPRa0ad9F+z+Drr+G3eFf7" +
       "P83dglaKNgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "fMXw2hNynqzyl7GPfnH0RuEfXyrddrDi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("d+rbp+OFHj2+zneXJwWhZ1HHVvtec2Cz+/btBO9sBp98k3/oFaf869Khf21d" +
       "68R69aXjpt6+29bsG3OJE7drEH5R7pefvdy9++XG+CAWJOdAp9mzN57tPtnP" +
       "AXvRzMdy8qGg9ALBk7hAKpzmuGz5GuTh7SIKPnze++yja9PFjX9xoNwX5Dcf" +
       "yo7lTrnL56DcYo3k4Zvqde+QYavAzzzLhwL/ISefyhD6UsA8+0LL7RtbEw+h" +
       "/7tbgH4tv5mv8D22g/7YxUA/iuxLz/Lsd3Py+Qy1cgx1obJDhF+4BYRFxntF" +
       "dqg7hOrFI/zDZ3n21Zz8flC6miEsfDa//reH2L5yq477quywd9jsi8f2J2c7" +
       "9ScKhj/Nydey1JzlNS/Y/wzgtw4Rfv1WEebWS3cI04tH+J3zEP7vnHwrKL51" +
       "vAm+P79VfOXseM8O33suBt+lw8RfrB/PC66/PA/pX+Xk+5ktTXsjBfZcMk5g" +
       "/YuLwPrEDusTzyPWvavnYN27Kye3HWDt8v5xrHu3X0RkPrnD+uSF++3eS85D" +
       "+LKcXMsQCobtS6c9d+/6RVjz6R3Cp59Pa77uPKwP5ORVGdb8y+ObeO7eqy8C" +
       "6wd3WD/4fGJ9y3lYb+TkTQdYT3vuw7eK9S3Z8ZEd1o9cDNYjKLYw2+fB/Fs5" +
       "aWTjyi1M2Pa0NP+Yzzht3OZFAP7YDvDHnifA/fMAD3Py4zcBfNrCb79VwG/O" +
       "jk/uAH/yeQJMnAc4d/o9JJvobgEvJC/QhJvZF70IuJ/ewf308wT3J86D+46c" +
       "MKfgnrbu8lbh1rLjt3dwP3cxcC8XDJcPc9XNSAFTPU8Pek6EoHRNCL2864VC" +
       "XhNOG128CC18eaeF//Kj1kJwnhY2ObFPaOG0Lzi3qoX868j/ttPCVy9GC7cX" +
       "DLefif0952F/b07eFZReehQ7adp2oJ72g3dfhAa+udPAN340GvjZ8zTwZE6e" +
       "uKkGTvvA+25VA0B2fH+nge/9aDTw9Hka+Gc5+fmst9tpYBZyopd/2HnaA566" +
       "APx7e9uy25/nH/+HzsP/kZx88Cb4T9v/n98q/kezlq/u8F+9GPw3H7t+4jzU" +
       "v5aTfx2UXnES9VnR/9GLwH7vDvu9zyf2f38e9t/MyW+cif203T91q9gfztp/" +
       "YIf9tReD/UrBcOWEyxePT7ymvMLbtiFx+ba0vS+e0NUXztPVf87J54LSZc67" +
       "SUL4jxehmBs7xZSfT8Xsgz+lgT84TwN/lJPf22rgtGv8/nPRQJyNMk7sFs23" +
       "u913ahv6duu08KvPXLv68mfoPyg2TB5sb74TLV2VQ8M4ujvpyPllx5NkrVDN" +
       "ndu9Sk6B4+tB6eVnvP3PdxMWJ7nEe1/b8v/PoHT9JH9QuqP4Pcr3p0HprkO+" +
       "XE/FyVGWbwal2zKW/PTPnEIrx/cBbDdpxXvFo/uOukuu49I95+n4oMjR/ZT5" +
       "+lPxbwD214rC7T8CeEz4+DOT6bu+2/rwdj+nYHBpmtdyFS1d2W4tLSrN15te" +
       "f2Zt+3Vdhh/5wd2fuPOh/bWxu7cCH7ruEdlee/MNkwPTCYotjumnXv7Jt/3L" +
       "Z/642Jbw/wGk9yDfn0EAAA==");
}
