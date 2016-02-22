package org.sunflow.core.primitive;
public abstract class CubeGrid implements org.sunflow.core.PrimitiveList {
    private int nx;
    private int ny;
    private int nz;
    private float voxelwx;
    private float voxelwy;
    private float voxelwz;
    private float invVoxelwx;
    private float invVoxelwy;
    private float invVoxelwz;
    private org.sunflow.math.BoundingBox bounds;
    public CubeGrid() { super();
                        nx = (ny = (nz = 1));
                        bounds = new org.sunflow.math.BoundingBox(1); }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        nx =
          pl.
            getInt(
              "resolutionX",
              nx);
        ny =
          pl.
            getInt(
              "resolutionY",
              ny);
        nz =
          pl.
            getInt(
              "resolutionZ",
              nz);
        voxelwx =
          2.0F /
            nx;
        voxelwy =
          2.0F /
            ny;
        voxelwz =
          2.0F /
            nz;
        invVoxelwx =
          1 /
            voxelwx;
        invVoxelwy =
          1 /
            voxelwy;
        invVoxelwz =
          1 /
            voxelwz;
        return true;
    }
    protected abstract boolean inside(int x, int y, int z);
    public org.sunflow.math.BoundingBox getBounds() { return bounds;
    }
    public void prepareShadingState(org.sunflow.core.ShadingState state) {
        state.
          init(
            );
        state.
          getRay(
            ).
          getPoint(
            state.
              getPoint(
                ));
        org.sunflow.core.Instance parent =
          state.
          getInstance(
            );
        org.sunflow.math.Vector3 normal;
        switch (state.
                  getPrimitiveID(
                    )) {
            case 0:
                normal =
                  new org.sunflow.math.Vector3(
                    -1,
                    0,
                    0);
                break;
            case 1:
                normal =
                  new org.sunflow.math.Vector3(
                    1,
                    0,
                    0);
                break;
            case 2:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    -1,
                    0);
                break;
            case 3:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    1,
                    0);
                break;
            case 4:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    -1);
                break;
            case 5:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    1);
                break;
            default:
                normal =
                  new org.sunflow.math.Vector3(
                    0,
                    0,
                    0);
                break;
        }
        state.
          getNormal(
            ).
          set(
            parent.
              transformNormalObjectToWorld(
                normal));
        state.
          getGeoNormal(
            ).
          set(
            state.
              getNormal(
                ));
        state.
          setBasis(
            org.sunflow.math.OrthoNormalBasis.
              makeFromW(
                state.
                  getNormal(
                    )));
        state.
          setShader(
            parent.
              getShader(
                0));
        state.
          setModifier(
            parent.
              getModifier(
                0));
    }
    public void intersectPrimitive(org.sunflow.core.Ray r, int primID,
                                   org.sunflow.core.IntersectionState state) {
        float intervalMin =
          r.
          getMin(
            );
        float intervalMax =
          r.
          getMax(
            );
        float orgX =
          r.
            ox;
        float orgY =
          r.
            oy;
        float orgZ =
          r.
            oz;
        float dirX =
          r.
            dx;
        float invDirX =
          1 /
          dirX;
        float dirY =
          r.
            dy;
        float invDirY =
          1 /
          dirY;
        float dirZ =
          r.
            dz;
        float invDirZ =
          1 /
          dirZ;
        float t1;
        float t2;
        t1 =
          (-1 -
             orgX) *
            invDirX;
        t2 =
          (+1 -
             orgX) *
            invDirX;
        int curr =
          -1;
        if (invDirX >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  0;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  1;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        t1 =
          (-1 -
             orgY) *
            invDirY;
        t2 =
          (+1 -
             orgY) *
            invDirY;
        if (invDirY >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  2;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  3;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        t1 =
          (-1 -
             orgZ) *
            invDirZ;
        t2 =
          (+1 -
             orgZ) *
            invDirZ;
        if (invDirZ >
              0) {
            if (t1 >
                  intervalMin) {
                intervalMin =
                  t1;
                curr =
                  4;
            }
            if (t2 <
                  intervalMax)
                intervalMax =
                  t2;
            if (intervalMin >
                  intervalMax)
                return;
        }
        else {
            if (t2 >
                  intervalMin) {
                intervalMin =
                  t2;
                curr =
                  5;
            }
            if (t1 <
                  intervalMax)
                intervalMax =
                  t1;
            if (intervalMin >
                  intervalMax)
                return;
        }
        orgX +=
          intervalMin *
            dirX;
        orgY +=
          intervalMin *
            dirY;
        orgZ +=
          intervalMin *
            dirZ;
        int indxX;
        int indxY;
        int indxZ;
        int stepX;
        int stepY;
        int stepZ;
        int stopX;
        int stopY;
        int stopZ;
        float deltaX;
        float deltaY;
        float deltaZ;
        float tnextX;
        float tnextY;
        float tnextZ;
        indxX =
          (int)
            ((orgX +
                1) *
               invVoxelwx);
        if (indxX <
              0)
            indxX =
              0;
        else
            if (indxX >=
                  nx)
                indxX =
                  nx -
                    1;
        if (java.lang.Math.
              abs(
                dirX) <
              1.0E-6F) {
            stepX =
              0;
            stopX =
              indxX;
            deltaX =
              0;
            tnextX =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirX >
                  0) {
                stepX =
                  1;
                stopX =
                  nx;
                deltaX =
                  voxelwx *
                    invDirX;
                tnextX =
                  intervalMin +
                    ((indxX +
                        1) *
                       voxelwx -
                       1 -
                       orgX) *
                    invDirX;
            }
            else {
                stepX =
                  -1;
                stopX =
                  -1;
                deltaX =
                  -voxelwx *
                    invDirX;
                tnextX =
                  intervalMin +
                    (indxX *
                       voxelwx -
                       1 -
                       orgX) *
                    invDirX;
            }
        indxY =
          (int)
            ((orgY +
                1) *
               invVoxelwy);
        if (indxY <
              0)
            indxY =
              0;
        else
            if (indxY >=
                  ny)
                indxY =
                  ny -
                    1;
        if (java.lang.Math.
              abs(
                dirY) <
              1.0E-6F) {
            stepY =
              0;
            stopY =
              indxY;
            deltaY =
              0;
            tnextY =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirY >
                  0) {
                stepY =
                  1;
                stopY =
                  ny;
                deltaY =
                  voxelwy *
                    invDirY;
                tnextY =
                  intervalMin +
                    ((indxY +
                        1) *
                       voxelwy -
                       1 -
                       orgY) *
                    invDirY;
            }
            else {
                stepY =
                  -1;
                stopY =
                  -1;
                deltaY =
                  -voxelwy *
                    invDirY;
                tnextY =
                  intervalMin +
                    (indxY *
                       voxelwy -
                       1 -
                       orgY) *
                    invDirY;
            }
        indxZ =
          (int)
            ((orgZ +
                1) *
               invVoxelwz);
        if (indxZ <
              0)
            indxZ =
              0;
        else
            if (indxZ >=
                  nz)
                indxZ =
                  nz -
                    1;
        if (java.lang.Math.
              abs(
                dirZ) <
              1.0E-6F) {
            stepZ =
              0;
            stopZ =
              indxZ;
            deltaZ =
              0;
            tnextZ =
              java.lang.Float.
                POSITIVE_INFINITY;
        }
        else
            if (dirZ >
                  0) {
                stepZ =
                  1;
                stopZ =
                  nz;
                deltaZ =
                  voxelwz *
                    invDirZ;
                tnextZ =
                  intervalMin +
                    ((indxZ +
                        1) *
                       voxelwz -
                       1 -
                       orgZ) *
                    invDirZ;
            }
            else {
                stepZ =
                  -1;
                stopZ =
                  -1;
                deltaZ =
                  -voxelwz *
                    invDirZ;
                tnextZ =
                  intervalMin +
                    (indxZ *
                       voxelwz -
                       1 -
                       orgZ) *
                    invDirZ;
            }
        boolean isInside =
          inside(
            indxX,
            indxY,
            indxZ) &&
          bounds.
          contains(
            r.
              ox,
            r.
              oy,
            r.
              oz);
        for (;
             ;
             ) {
            if (inside(
                  indxX,
                  indxY,
                  indxZ) !=
                  isInside) {
                r.
                  setMax(
                    intervalMin);
                if (isInside)
                    curr ^=
                      1;
                state.
                  setIntersection(
                    curr,
                    0,
                    0);
                return;
            }
            if (tnextX <
                  tnextY &&
                  tnextX <
                  tnextZ) {
                curr =
                  dirX >
                    0
                    ? 0
                    : 1;
                intervalMin =
                  tnextX;
                if (intervalMin >
                      intervalMax)
                    return;
                indxX +=
                  stepX;
                if (indxX ==
                      stopX)
                    return;
                tnextX +=
                  deltaX;
            }
            else
                if (tnextY <
                      tnextZ) {
                    curr =
                      dirY >
                        0
                        ? 2
                        : 3;
                    intervalMin =
                      tnextY;
                    if (intervalMin >
                          intervalMax)
                        return;
                    indxY +=
                      stepY;
                    if (indxY ==
                          stopY)
                        return;
                    tnextY +=
                      deltaY;
                }
                else {
                    curr =
                      dirZ >
                        0
                        ? 4
                        : 5;
                    intervalMin =
                      tnextZ;
                    if (intervalMin >
                          intervalMax)
                        return;
                    indxZ +=
                      stepZ;
                    if (indxZ ==
                          stopZ)
                        return;
                    tnextZ +=
                      deltaZ;
                }
        }
    }
    public int getNumPrimitives() { return 1; }
    public float getPrimitiveBound(int primID, int i) { return (i &
                                                                  1) ==
                                                          0
                                                          ? -1
                                                          : 1; }
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        if (o2w ==
              null)
            return bounds;
        return o2w.
          transform(
            bounds);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6a6zj2HmY7p3dndn1emd21vvIrPfpsZ217CH1ICV13dh6" +
       "kBIliiIpiaLUNrN8HEoUn+JbTDcPA4mNpHXddp06hbPIDwdpg00cFDUSoEiw" +
       "adE8ECNACrdNgzZOg6J1m7rIFqgb1G3cQ+reqzt37ox3sF4BPKQOv3PO9/4+" +
       "nvO98c3C/b5XKLqOuV2aTnADJMGNtYndCLYu8G/0aYyVPB+obVPy/Qnsu6m8" +
       "+CuXv/Xtz62uHBYeWBQek2zbCaRAd2yfB75jRkClC5f3vYQJLD8oXKHXUiQh" +
       "YaCbCK37wct04T2nhgaF6/QxCghEAYEoIDkKSHMPBQe9F9ih1c5GSHbgbwo/" +
       "XDigCw+4SoZeUHjh1klcyZOso2nYnAI4w6XsvwCJygcnXuH5E9p3NN9G8OeL" +
       "yGv/4Aev/JMLhcuLwmXdHmfoKBCJAC6yKDxsAUsGnt9UVaAuCo/aAKhj4OmS" +
       "qac53ovCVV9f2lIQeuCESVln6AIvX3PPuYeVjDYvVALHOyFP04GpHv+7XzOl" +
       "JaT1iT2tOwrJrB8S+JAOEfM0SQHHQ+4zdFsNCs+dHXFC4/UBBIBDL1ogWDkn" +
       "S91nS7CjcHUnO1Oyl8g48HR7CUHvd0K4SlC4dsdJM167kmJIS3AzKDx1Fo7d" +
       "vYJQD+aMyIYEhcfPguUzQSldOyOlU/L5JvPxz/6Q3bMPc5xVoJgZ/pfgoGfP" +
       "DOKBBjxgK2A38OGP0D8tPfHrnzksFCDw42eAdzC/+jff+uRHn33zd3YwT58D" +
       "M5LXQAluKl+SH/mD97dfalzI0LjkOr6eCf8WynP1Z4/evJy40PKeOJkxe3nj" +
       "+OWb/G/Nf/QXwZ8dFh6iCg8ojhlaUI8eVRzL1U3gdYENPCkAKlV4ENhqO39P" +
       "FS7CZ1q3wa53pGk+CKjCfWbe9YCT/4cs0uAUGYsuwmfd1pzjZ1cKVvlz4hYK" +
       "hSvwKtTgdbmw++X3oDBBVo4FEEmRbN12ENZzMvp9BNiBDHm7QvzQ1kwnRnxP" +
       "QRxvefJfcTyAuJ5uQQojgLRDGXQ9Xb2RaZf7Ls2bZPRciQ8OIKvff9bQTWgj" +
       "PcdUgXdTeS1sEW/98s3fOzxR/CNOBIUPwMVuHC12I1vsxsliN44XKxwc5Gu8" +
       "L1t0J0ooCAOaNHR2D780/hv9Vz7z4gWoQ258H+RiBorc2ee2906Ayl2dAjWx" +
       "8OYX4h8TfgQ9LBze6jwzRGHXQ9lwNnN5J67t+lmjOW/ey5/+xre+/NOvOnvz" +
       "ucUbH1n17SMzq3zxLEs9RwEq9HP76T/yvPSVm7/+6vXDwn3Q1KF7CySojtBz" +
       "PHt2jVus8+VjT5fRcj8kWHM8SzKzV8fu6aFg5TnxvieX9SP586OQx+/J1PUx" +
       "eD1+pL/5PXv7mJu179vpRia0M1TknvSvjt2f/cPf/6+VnN3HTvfyqTA2BsHL" +
       "pww9m+xybtKP7nVg4gEA4f7DF9i///lvfvqv5QoAIT5w3oLXs7YNDRyKELL5" +
       "x39n8+++/sdf+trhXmkCGOlC2dSV5ITIrL/w0F2IhKt9aI8PdBQmNKpMa65P" +
       "bctRdU2XZBNkWvp/L3+w9JX//tkrOz0wYc+xGn30u0+w7/++VuFHf+8H//ez" +
       "+TQHShao9jzbg+2832P7mZueJ20zPJIf+1fP/MxvSz8L/Sj0Xb6egtwdFXIe" +
       "FHKhITn9H8nbG2felbLmOf+08t9qX6cSipvK57725+8V/vw33sqxvTUjOS3r" +
       "oeS+vFOvrHk+gdM/edbSe5K/gnDVN5m/fsV889twxgWcUYFh2B950Mckt2jG" +
       "EfT9F//oN//FE6/8wYXCIVl4yHQklZRyIys8CLUb+CvonhL3E5/cCTe+dOyX" +
       "k8JtxO+U4qn833shgi/d2b+QWUKxN9Gn/s/IlD/1p39xGxNyz3JOHD0zfoG8" +
       "8cVr7R/4s3z83sSz0c8mt/tdmHztx5Z/0fpfhy8+8C8PCxcXhSvKUWYnSGaY" +
       "Gc4CZjP+cboHs79b3t+amezC8MsnLuz9Z93LqWXPOpe9v4fPGXT2/NAZf/Jw" +
       "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" +
       "PISeUucDbDeqAbX97CjoBrPbabCPB4X3");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("nAKD6cHR02mgTwSFCxAoe/yke86Z567oKTk4lTEe6UvuOa5+Nx6fDDldk5hl" +
       "mXnp/HFGGO6K528qX369z/zQW/jP72oiFVNK80PtS3Th4q488ySrfOGOsx3P" +
       "9UDvpW8/8isPfvA4A35kh/Bed0/h9tz5BYiE5QZ5yWD6a0/+04//wut/nB/B" +
       "/n+Rtw/C0zAAAA==");
}
