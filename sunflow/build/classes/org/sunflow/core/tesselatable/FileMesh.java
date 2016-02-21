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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "DQMXYaSdZ9z/A/RrZOLzIQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "cLV9+lye//PIDUm6u8RS+RMvXr3y8Ivz");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("f78LGPbJn3dRpSta4jin0zVO3V8KQlUzC+nu2iVvBIU4l2/2pXI6pS8u3XP6" +
       "MWf7wqVd27vj0rXzbePSnfnfabJ749LrTpHFpctHd6eJroE1HRDlt/cHe287" +
       "dZa+S2HJLpz68imdip0feDVNHzc5nW2Wh3JFxvT+yybZ5Uw/J3/yRZL54a8j" +
       "H91lu8mOuN3mvVwBUdcu8e746+iJW/a27+tS/5lv3Pdrdz29/5K7b8fwia2e" +
       "4u2NN08n67pBXCSAbX/n4d/4/l968YtFMsH/BcdeyDnKLgAA");
}
