package edu.umd.cs.findbugs.classfile.impl;
public abstract class AbstractScannableCodeBase implements edu.umd.cs.findbugs.classfile.IScannableCodeBase {
    private final edu.umd.cs.findbugs.classfile.ICodeBaseLocator codeBaseLocator;
    private boolean isAppCodeBase;
    private edu.umd.cs.findbugs.classfile.ICodeBase.Discovered howDiscovered;
    private long lastModifiedTime;
    private final java.util.Map<java.lang.String,java.lang.String> resourceNameTranslationMap;
    public AbstractScannableCodeBase(edu.umd.cs.findbugs.classfile.ICodeBaseLocator codeBaseLocator) {
        super(
          );
        this.
          codeBaseLocator =
          codeBaseLocator;
        this.
          lastModifiedTime =
          -1L;
        this.
          resourceNameTranslationMap =
          new java.util.HashMap<java.lang.String,java.lang.String>(
            );
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBaseLocator getCodeBaseLocator() {
        return codeBaseLocator;
    }
    @java.lang.Override
    public boolean containsSourceFiles() { return false; }
    @java.lang.Override
    public void setApplicationCodeBase(boolean isAppCodeBase) { this.
                                                                  isAppCodeBase =
                                                                  isAppCodeBase;
    }
    @java.lang.Override
    public boolean isApplicationCodeBase() { return isAppCodeBase;
    }
    @java.lang.Override
    public void setHowDiscovered(edu.umd.cs.findbugs.classfile.ICodeBase.Discovered howDiscovered) {
        this.
          howDiscovered =
          howDiscovered;
    }
    @java.lang.Override
    public edu.umd.cs.findbugs.classfile.ICodeBase.Discovered getHowDiscovered() {
        return howDiscovered;
    }
    @java.lang.Override
    public void setLastModifiedTime(long lastModifiedTime) {
        if (lastModifiedTime >
              0 &&
              edu.umd.cs.findbugs.FindBugs.
              validTimestamp(
                lastModifiedTime)) {
            this.
              lastModifiedTime =
              lastModifiedTime;
        }
    }
    public void addLastModifiedTime(long lastModifiedTime) {
        if (lastModifiedTime >
              0 &&
              edu.umd.cs.findbugs.FindBugs.
              validTimestamp(
                lastModifiedTime) &&
              this.
                lastModifiedTime <
              lastModifiedTime) {
            this.
              lastModifiedTime =
              lastModifiedTime;
        }
    }
    @java.lang.Override
    public long getLastModifiedTime() { return lastModifiedTime;
    }
    public void addResourceNameTranslation(java.lang.String origResourceName,
                                           java.lang.String newResourceName) {
        if (!origResourceName.
              equals(
                newResourceName)) {
            resourceNameTranslationMap.
              put(
                origResourceName,
                newResourceName);
        }
    }
    public java.lang.String translateResourceName(java.lang.String resourceName) {
        java.lang.String translatedName =
          resourceNameTranslationMap.
          get(
            resourceName);
        return translatedName !=
          null
          ? translatedName
          : resourceName;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "yW/x7vv/A4lswgAKLQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "x+GU3a4yYEZTZlJvnBF5bU0l4kZYDUiM");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("Wc/JTgvBZzKMNscUYc5tjurEU2gTLFZ9Rdh0p2GMh7A/ByzT8QYe+ws4TkJ1" +
       "KCULQ+HYHbKog+UNC9uhwTOG7lUZdwWB5VC7WU+ZxsqCkuYW1vDJhPMwF2Ld" +
       "dEo71Zk9j9m8lWSZM+cyubWj81UV9tPuMko0ExlvqslmOqyR1ba3IQQP6uis" +
       "GSBg5va4OQZDw21zIa9qVQrHt1EbYkFMWSuDMHOQk8BbNE3hbsOOMrM7ZCbd" +
       "bvFq7Avf2+u515VvHY8Pun0f7xu3F+yiPBlX7lYOD++cnJ4oP1cq505Ondqg" +
       "OfU+9vjkQfVlNr1ecjao2C18661OxZU7hZ//yPMv6OMv1C4fvvWdxZV7Ys9/" +
       "t22khn2Kh/su3uMZlYcCTzbJf+0jf/qw8COrD3wPJ4bedo7P8yT/xeiLXyWf" +
       "0P7R5cptx1vmLzmueHbQM+f2AUIDOLMrnNkuf+uxSd5ytE/27KFJnj2/Z3bi" +
       "ETff4nty71EXnPX4dxe0/UpR/Ju4cs004t5NdstPXPGXzrri/ceueOwp107t" +
       "EKRGGFq6cYH3vvRoRlnxi8eqeaioLE4PkIeqIV991fz2BW3/sSi+GlceOjyq" +
       "Ee1fpveB15f9hRPd/PotdVNU/+rfRQvlsa4fBhd/qAX+1dHCpZMOQtnhv1yg" +
       "ij8sit+LK2+MjLjr+7allYF1fHihaD6/l5x6ln6iod9/7TRU+klxFOP9hxp6" +
       "/6vvJ9+6oO3bRfHf48obygMd53VzzlP++DX2FBxc5qEezFfdUz5QdvirC5Tx" +
       "10Xx5zF4jBFTp89QFPXfONHD/3zt9PBoUVktRd9/glfdHy7dcUHbXUVRASow" +
       "b6KCDxyr4NKl19gVfghcHzxUwQdfdVewSlmvXaCH1xfFAwA/i8Pd506fnPWG" +
       "Sw/+P1DFhw5V8aHXSBVvu0AVjxXFw0AViq6/jCp+8OX2YS+Qtez2dnD91KGs" +
       "P/Xqez50Qdu7i+IJIKZ5c4tbJ2K+8zW2+HvB9alDLXzq1dHC5ZP0ukzTP1HK" +
       "3L5AHz9UFPW48jAw+/TmB5nOWb/xd7B+efzqneD6zKHcn3nVPX0vMn6ByP2i" +
       "+FEwGcaHMhqnBS9pnEj7nu9F2m1c+YFb/h+hOA325pf8X2r/Hx/t51+4cveb" +
       "XhB/vzySf/w/nHuYyt3LxLZPH2o9dX+nHxrLMrIr9+yPuPqlgKO48vjL/3MC" +
       "5D/FVyHEJWY/kIsrb71wIFgEHd+fHsiDgLrJQLDCO7o93Ruspe496R1XLmtn" +
       "mhdx5a7D5rhyGyhPN74PVIHG4vb9pct8fLtP7t982uPK+fvay5nueMjp4//n" +
       "j5KNkv3f325oX3qBZj/4ndYX9n8/AHrI84LK3Uzlrv0/IUqixZLtsVtSO6J1" +
       "J/XUdx/8hXvecbS8fHDP8In3n+LtbTc/6084flyezs//9Zv+1bP/7IWvl6dx" +
       "/i++MhP/lTgAAA==");
}
