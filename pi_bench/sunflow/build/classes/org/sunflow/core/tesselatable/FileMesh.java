package org.sunflow.core.tesselatable;
public class FileMesh implements org.sunflow.core.Tesselatable {
    private java.lang.String filename = null;
    private boolean smoothNormals = false;
    public org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        return null;
    }
    public org.sunflow.core.PrimitiveList tesselate() { if (filename.
                                                              endsWith(
                                                                ".ra3")) {
                                                            try {
                                                                org.sunflow.system.UI.
                                                                  printInfo(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "RA3 - Reading geometry: \"%s\" ...",
                                                                    filename);
                                                                java.io.File file =
                                                                  new java.io.File(
                                                                  filename);
                                                                java.io.FileInputStream stream =
                                                                  new java.io.FileInputStream(
                                                                  filename);
                                                                java.nio.MappedByteBuffer map =
                                                                  stream.
                                                                  getChannel(
                                                                    ).
                                                                  map(
                                                                    java.nio.channels.FileChannel.MapMode.
                                                                      READ_ONLY,
                                                                    0,
                                                                    file.
                                                                      length(
                                                                        ));
                                                                map.
                                                                  order(
                                                                    java.nio.ByteOrder.
                                                                      LITTLE_ENDIAN);
                                                                java.nio.IntBuffer ints =
                                                                  map.
                                                                  asIntBuffer(
                                                                    );
                                                                java.nio.FloatBuffer buffer =
                                                                  map.
                                                                  asFloatBuffer(
                                                                    );
                                                                int numVerts =
                                                                  ints.
                                                                  get(
                                                                    0);
                                                                int numTris =
                                                                  ints.
                                                                  get(
                                                                    1);
                                                                org.sunflow.system.UI.
                                                                  printInfo(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "RA3 -   * Reading %d vertices ...",
                                                                    numVerts);
                                                                float[] verts =
                                                                  new float[3 *
                                                                              numVerts];
                                                                for (int i =
                                                                       0;
                                                                     i <
                                                                       verts.
                                                                         length;
                                                                     i++)
                                                                    verts[i] =
                                                                      buffer.
                                                                        get(
                                                                          2 +
                                                                            i);
                                                                org.sunflow.system.UI.
                                                                  printInfo(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "RA3 -   * Reading %d triangles ...",
                                                                    numTris);
                                                                int[] tris =
                                                                  new int[3 *
                                                                            numTris];
                                                                for (int i =
                                                                       0;
                                                                     i <
                                                                       tris.
                                                                         length;
                                                                     i++)
                                                                    tris[i] =
                                                                      ints.
                                                                        get(
                                                                          2 +
                                                                            verts.
                                                                              length +
                                                                            i);
                                                                stream.
                                                                  close(
                                                                    );
                                                                org.sunflow.system.UI.
                                                                  printInfo(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "RA3 -   * Creating mesh ...");
                                                                return generate(
                                                                         tris,
                                                                         verts,
                                                                         smoothNormals);
                                                            }
                                                            catch (java.io.FileNotFoundException e) {
                                                                e.
                                                                  printStackTrace(
                                                                    );
                                                                org.sunflow.system.UI.
                                                                  printError(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "Unable to read mesh file \"%s\" - file not found",
                                                                    filename);
                                                            }
                                                            catch (java.io.IOException e) {
                                                                e.
                                                                  printStackTrace(
                                                                    );
                                                                org.sunflow.system.UI.
                                                                  printError(
                                                                    org.sunflow.system.UI.Module.
                                                                      GEOM,
                                                                    "Unable to read mesh file \"%s\" - I/O error occured",
                                                                    filename);
                                                            }
                                                        }
                                                        else
                                                            if (filename.
                                                                  endsWith(
                                                                    ".obj")) {
                                                                int lineNumber =
                                                                  1;
                                                                try {
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "OBJ - Reading geometry: \"%s\" ...",
                                                                        filename);
                                                                    org.sunflow.util.FloatArray verts =
                                                                      new org.sunflow.util.FloatArray(
                                                                      );
                                                                    org.sunflow.util.IntArray tris =
                                                                      new org.sunflow.util.IntArray(
                                                                      );
                                                                    java.io.FileReader file =
                                                                      new java.io.FileReader(
                                                                      filename);
                                                                    java.io.BufferedReader bf =
                                                                      new java.io.BufferedReader(
                                                                      file);
                                                                    java.lang.String line;
                                                                    while ((line =
                                                                              bf.
                                                                                readLine(
                                                                                  )) !=
                                                                             null) {
                                                                        if (line.
                                                                              startsWith(
                                                                                "v")) {
                                                                            java.lang.String[] v =
                                                                              line.
                                                                              split(
                                                                                "\\s+");
                                                                            verts.
                                                                              add(
                                                                                java.lang.Float.
                                                                                  parseFloat(
                                                                                    v[1]));
                                                                            verts.
                                                                              add(
                                                                                java.lang.Float.
                                                                                  parseFloat(
                                                                                    v[2]));
                                                                            verts.
                                                                              add(
                                                                                java.lang.Float.
                                                                                  parseFloat(
                                                                                    v[3]));
                                                                        }
                                                                        else
                                                                            if (line.
                                                                                  startsWith(
                                                                                    "f")) {
                                                                                java.lang.String[] f =
                                                                                  line.
                                                                                  split(
                                                                                    "\\s+");
                                                                                if (f.
                                                                                      length ==
                                                                                      5) {
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[1]) -
                                                                                          1);
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[2]) -
                                                                                          1);
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[3]) -
                                                                                          1);
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[1]) -
                                                                                          1);
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[3]) -
                                                                                          1);
                                                                                    tris.
                                                                                      add(
                                                                                        java.lang.Integer.
                                                                                          parseInt(
                                                                                            f[4]) -
                                                                                          1);
                                                                                }
                                                                                else
                                                                                    if (f.
                                                                                          length ==
                                                                                          4) {
                                                                                        tris.
                                                                                          add(
                                                                                            java.lang.Integer.
                                                                                              parseInt(
                                                                                                f[1]) -
                                                                                              1);
                                                                                        tris.
                                                                                          add(
                                                                                            java.lang.Integer.
                                                                                              parseInt(
                                                                                                f[2]) -
                                                                                              1);
                                                                                        tris.
                                                                                          add(
                                                                                            java.lang.Integer.
                                                                                              parseInt(
                                                                                                f[3]) -
                                                                                              1);
                                                                                    }
                                                                            }
                                                                        if (lineNumber %
                                                                              100000 ==
                                                                              0)
                                                                            org.sunflow.system.UI.
                                                                              printInfo(
                                                                                org.sunflow.system.UI.Module.
                                                                                  GEOM,
                                                                                "OBJ -   * Parsed %7d lines ...",
                                                                                lineNumber);
                                                                        lineNumber++;
                                                                    }
                                                                    file.
                                                                      close(
                                                                        );
                                                                    org.sunflow.system.UI.
                                                                      printInfo(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "OBJ -   * Creating mesh ...");
                                                                    return generate(
                                                                             tris.
                                                                               trim(
                                                                                 ),
                                                                             verts.
                                                                               trim(
                                                                                 ),
                                                                             smoothNormals);
                                                                }
                                                                catch (java.io.FileNotFoundException e) {
                                                                    e.
                                                                      printStackTrace(
                                                                        );
                                                                    org.sunflow.system.UI.
                                                                      printError(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "Unable to read mesh file \"%s\" - file not found",
                                                                        filename);
                                                                }
                                                                catch (java.lang.NumberFormatException e) {
                                                                    e.
                                                                      printStackTrace(
                                                                        );
                                                                    org.sunflow.system.UI.
                                                                      printError(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "Unable to read mesh file \"%s\" - syntax error at line %d",
                                                                        lineNumber);
                                                                }
                                                                catch (java.io.IOException e) {
                                                                    e.
                                                                      printStackTrace(
                                                                        );
                                                                    org.sunflow.system.UI.
                                                                      printError(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "Unable to read mesh file \"%s\" - I/O error occured",
                                                                        filename);
                                                                }
                                                            }
                                                            else
                                                                if (filename.
                                                                      endsWith(
                                                                        ".stl")) {
                                                                    try {
                                                                        org.sunflow.system.UI.
                                                                          printInfo(
                                                                            org.sunflow.system.UI.Module.
                                                                              GEOM,
                                                                            "STL - Reading geometry: \"%s\" ...",
                                                                            filename);
                                                                        java.io.FileInputStream file =
                                                                          new java.io.FileInputStream(
                                                                          filename);
                                                                        java.io.DataInputStream stream =
                                                                          new java.io.DataInputStream(
                                                                          new java.io.BufferedInputStream(
                                                                            file));
                                                                        file.
                                                                          skip(
                                                                            80);
                                                                        int numTris =
                                                                          getLittleEndianInt(
                                                                            stream.
                                                                              readInt(
                                                                                ));
                                                                        org.sunflow.system.UI.
                                                                          printInfo(
                                                                            org.sunflow.system.UI.Module.
                                                                              GEOM,
                                                                            "STL -   * Reading %d triangles ...",
                                                                            numTris);
                                                                        long filesize =
                                                                          new java.io.File(
                                                                          filename).
                                                                          length(
                                                                            );
                                                                        if (filesize !=
                                                                              84 +
                                                                              50 *
                                                                              numTris) {
                                                                            org.sunflow.system.UI.
                                                                              printWarning(
                                                                                org.sunflow.system.UI.Module.
                                                                                  GEOM,
                                                                                "STL - Size of file mismatch (expecting %s, found %s)",
                                                                                org.sunflow.system.Memory.
                                                                                  bytesToString(
                                                                                    84 +
                                                                                      14 *
                                                                                      numTris),
                                                                                org.sunflow.system.Memory.
                                                                                  bytesToString(
                                                                                    filesize));
                                                                            return null;
                                                                        }
                                                                        int[] tris =
                                                                          new int[3 *
                                                                                    numTris];
                                                                        float[] verts =
                                                                          new float[9 *
                                                                                      numTris];
                                                                        for (int i =
                                                                               0,
                                                                               i3 =
                                                                                 0,
                                                                               index =
                                                                                 0;
                                                                             i <
                                                                               numTris;
                                                                             i++,
                                                                               i3 +=
                                                                                 3) {
                                                                            stream.
                                                                              readInt(
                                                                                );
                                                                            stream.
                                                                              readInt(
                                                                                );
                                                                            stream.
                                                                              readInt(
                                                                                );
                                                                            for (int j =
                                                                                   0;
                                                                                 j <
                                                                                   3;
                                                                                 j++,
                                                                                   index +=
                                                                                     3) {
                                                                                tris[i3 +
                                                                                       j] =
                                                                                  i3 +
                                                                                    j;
                                                                                verts[index +
                                                                                        0] =
                                                                                  getLittleEndianFloat(
                                                                                    stream.
                                                                                      readInt(
                                                                                        ));
                                                                                verts[index +
                                                                                        1] =
                                                                                  getLittleEndianFloat(
                                                                                    stream.
                                                                                      readInt(
                                                                                        ));
                                                                                verts[index +
                                                                                        2] =
                                                                                  getLittleEndianFloat(
                                                                                    stream.
                                                                                      readInt(
                                                                                        ));
                                                                            }
                                                                            stream.
                                                                              readShort(
                                                                                );
                                                                            if ((i +
                                                                                   1) %
                                                                                  100000 ==
                                                                                  0)
                                                                                org.sunflow.system.UI.
                                                                                  printInfo(
                                                                                    org.sunflow.system.UI.Module.
                                                                                      GEOM,
                                                                                    "STL -   * Parsed %7d triangles ...",
                                                                                    i +
                                                                                      1);
                                                                        }
                                                                        file.
                                                                          close(
                                                                            );
                                                                        org.sunflow.system.UI.
                                                                          printInfo(
                                                                            org.sunflow.system.UI.Module.
                                                                              GEOM,
                                                                            "STL -   * Creating mesh ...");
                                                                        if (smoothNormals)
                                                                            org.sunflow.system.UI.
                                                                              printWarning(
                                                                                org.sunflow.system.UI.Module.
                                                                                  GEOM,
                                                                                ("STL - format does not support shared vertices - normal smoot" +
                                                                                 "hing disabled"));
                                                                        return generate(
                                                                                 tris,
                                                                                 verts,
                                                                                 false);
                                                                    }
                                                                    catch (java.io.FileNotFoundException e) {
                                                                        e.
                                                                          printStackTrace(
                                                                            );
                                                                        org.sunflow.system.UI.
                                                                          printError(
                                                                            org.sunflow.system.UI.Module.
                                                                              GEOM,
                                                                            "Unable to read mesh file \"%s\" - file not found",
                                                                            filename);
                                                                    }
                                                                    catch (java.io.IOException e) {
                                                                        e.
                                                                          printStackTrace(
                                                                            );
                                                                        org.sunflow.system.UI.
                                                                          printError(
                                                                            org.sunflow.system.UI.Module.
                                                                              GEOM,
                                                                            "Unable to read mesh file \"%s\" - I/O error occured",
                                                                            filename);
                                                                    }
                                                                }
                                                                else
                                                                    org.sunflow.system.UI.
                                                                      printWarning(
                                                                        org.sunflow.system.UI.Module.
                                                                          GEOM,
                                                                        "Unable to read mesh file \"%s\" - unrecognized format",
                                                                        filename);
                                                        return null;
    }
    private org.sunflow.core.primitive.TriangleMesh generate(int[] tris,
                                                             float[] verts,
                                                             boolean smoothNormals) {
        org.sunflow.core.ParameterList pl =
          new org.sunflow.core.ParameterList(
          );
        pl.
          addIntegerArray(
            "triangles",
            tris);
        pl.
          addPoints(
            "points",
            org.sunflow.core.ParameterList.InterpolationType.
              VERTEX,
            verts);
        if (smoothNormals) {
            float[] normals =
              new float[verts.
                          length];
            org.sunflow.math.Point3 p0 =
              new org.sunflow.math.Point3(
              );
            org.sunflow.math.Point3 p1 =
              new org.sunflow.math.Point3(
              );
            org.sunflow.math.Point3 p2 =
              new org.sunflow.math.Point3(
              );
            org.sunflow.math.Vector3 n =
              new org.sunflow.math.Vector3(
              );
            for (int i3 =
                   0;
                 i3 <
                   tris.
                     length;
                 i3 +=
                   3) {
                int v0 =
                  tris[i3 +
                         0];
                int v1 =
                  tris[i3 +
                         1];
                int v2 =
                  tris[i3 +
                         2];
                p0.
                  set(
                    verts[3 *
                            v0 +
                            0],
                    verts[3 *
                            v0 +
                            1],
                    verts[3 *
                            v0 +
                            2]);
                p1.
                  set(
                    verts[3 *
                            v1 +
                            0],
                    verts[3 *
                            v1 +
                            1],
                    verts[3 *
                            v1 +
                            2]);
                p2.
                  set(
                    verts[3 *
                            v2 +
                            0],
                    verts[3 *
                            v2 +
                            1],
                    verts[3 *
                            v2 +
                            2]);
                org.sunflow.math.Point3.
                  normal(
                    p0,
                    p1,
                    p2,
                    n);
                normals[3 *
                          v0 +
                          0] +=
                  n.
                    x;
                normals[3 *
                          v0 +
                          1] +=
                  n.
                    y;
                normals[3 *
                          v0 +
                          2] +=
                  n.
                    z;
                normals[3 *
                          v1 +
                          0] +=
                  n.
                    x;
                normals[3 *
                          v1 +
                          1] +=
                  n.
                    y;
                normals[3 *
                          v1 +
                          2] +=
                  n.
                    z;
                normals[3 *
                          v2 +
                          0] +=
                  n.
                    x;
                normals[3 *
                          v2 +
                          1] +=
                  n.
                    y;
                normals[3 *
                          v2 +
                          2] +=
                  n.
                    z;
            }
            for (int i3 =
                   0;
                 i3 <
                   normals.
                     length;
                 i3 +=
                   3) {
                n.
                  set(
                    normals[i3 +
                              0],
                    normals[i3 +
                              1],
                    normals[i3 +
                              2]);
                n.
                  normalize(
                    );
                normals[i3 +
                          0] =
                  n.
                    x;
                normals[i3 +
                          1] =
                  n.
                    y;
                normals[i3 +
                          2] =
                  n.
                    z;
            }
            pl.
              addVectors(
                "normals",
                org.sunflow.core.ParameterList.InterpolationType.
                  VERTEX,
                normals);
        }
        org.sunflow.core.primitive.TriangleMesh m =
          new org.sunflow.core.primitive.TriangleMesh(
          );
        if (m.
              update(
                pl,
                null))
            return m;
        return null;
    }
    public boolean update(org.sunflow.core.ParameterList pl,
                          org.sunflow.SunflowAPI api) {
        java.lang.String file =
          pl.
          getString(
            "filename",
            null);
        if (file !=
              null)
            filename =
              api.
                resolveIncludeFilename(
                  file);
        smoothNormals =
          pl.
            getBoolean(
              "smooth_normals",
              smoothNormals);
        return filename !=
          null;
    }
    private int getLittleEndianInt(int i) {
        return i >>>
          24 |
          i >>>
          8 &
          65280 |
          i <<
          8 &
          16711680 |
          i <<
          24;
    }
    private float getLittleEndianFloat(int i) {
        return java.lang.Float.
          intBitsToFloat(
            getLittleEndianInt(
              i));
    }
    public FileMesh() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Mdxj4/8FURVljPEiAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nleOWH3ln4nVf7w1qxeK8f4f8OXnWMVz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("55K3/eEJs3/3rTCbAVPbp87luT+P3JCCu0sbVT/+4tUrD784+Y+7RX+f2nkX" +
       "XbpiJI5zOlXjVP1SEOqGVXB31y5xIyjYuXyz3cbpdL64dM/p15zsC5d2fe+O" +
       "S9fO941Ld+Z/p8HujUuvOwUWly4f1U4DXQOrNgDKq/cHe2s7dY++S1/JLpza" +
       "vZROxb8PvJqkj7uczjTLw7EiH3q/O0l2GdHPqZ94kWR/9OuNj+wy3VRH3m5z" +
       "LFdA5LRLujve4TxxS2x7XJcGz3zjvt+46+n9buy+HcEnunqKtjfePJWs5wZx" +
       "kfy1/eTDv/UDv/LiF4tEgv8PhXK5CqguAAA=");
}
