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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "uT3CyxjusfH/AkaTg3sFIwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "J4ri6eOjxvJ36Ta3LqdOpi/sjzofu+GSjTt1yVYc4j12q3vg8gDvY+974UV1" +
       "/PHawdG5PxdW7gpd73stLdasUxNeyjG949aHlXR5DX5yHv0H7/ubR7nvN979" +
       "bdy4vfUcnedRfoJ+6XP425WfOajccXw6fcMF/dlBz549k77b18LId7gzJ9OP" +
       "Hcv/4ULcTx89+/pNbr1ufc773TsNOXetcuHsij1yesVsOTQOaTn0zbRZDv7x" +
       "29zJ/ERRvDes3LfUwrnrWyrqRo4a7BG/5QbEZb/pLFE3PdHL973Wyd7pacuG" +
       "9xyL6Dv3B/bAkYiAN0ZEp7n8yG36PloUP12o6JGSHx/5P36DHRwfVhe3YSfs" +
       "/8zrZb+wyk8csf+Jb5f97k3Zv2PnbnITe/rWJlbe7O2O91/8t099/kdefOo/" +
       "lpdjV8xgJvuIv7xJzsepMd946Stf+8K9j32qvEy+cyEHOxs4nyxzYy7MmRSX" +
       "kvx7jgVSSqlIe3jwSCDlf1ihX1daAhopay0sb/v2eQ5vLML0Zqfgd5hH+VHn" +
       "bbY86f6F/T3Pp2++ugfHe8XxNnHJ0pzlLj/kk0Xx8156jP9gN2ivvQ+e3ARg" +
       "lutohe/e9+3yIkz38DhFqnTsN6P0PTtKy8mK4qnbmNJv3qbvM0XxG2HlolIQ" +
       "s6P9NuAvH1nOx8/emuWVg1/fqcXuP6xMXtcyekWemQ+yWJlwdqwbbzzSm+rH" +
       "xXyMfBsN+Z29hnzuW9SQoviVY+347I3aUbz+alH8u9ss9++UyD77Wsv9J7fp" +
       "+0JRfL4ofntHyW1gv5iW/m5avnzsNoB/VhT/OqxcWR5lUez1+btu8NTe3lMf" +
       "crmGO8tdXtCJy/43r8Nllw6p8NtfOvJQX3pjdqxzBnyT7acIbrTclx5vPznY" +
       "Q6fB2N0/wgzKGb56G2G+UhR/mbuUyFNzUZYrcCKfL78O+ZRgxY7+1SP5fPWN" +
       "2dIunAB8sgT4b7dh778XxdfDygN5YEOZYWhpvTxukZ2BUybPfPKE1f/6Olh9" +
       "oGh8e/68csTqK/9IrP79rVm9UM73v3Ov");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("fo7VfuFcir7fO2H2774dZtPc1PYpdUVO0CM3JOnuEkuVT7149crDL/J/vgsE" +
       "9smfd1GVK3pkWadTOE7VL3m+ppsld3ftEjq8kp3LN/sCOZ3mF1buOf1akH3h" +
       "0m7s3WHl2vmxYeXO4u802L1h5U2nwMLK5aPaaaBr+f6dAxXV+729tZ26X9+l" +
       "taQXTn3RVE7FxA+8lqSPh5zOQCtCtDJjev/FEu1ypp9TPv0iOfrhV1sf32XA" +
       "KZacZQWWK3k0tUvGO/7qeeKW2Pa4LhHPfPO+X77r6f0X2n07gk909RRtb715" +
       "ilnP9sIyKSz79Yd/9ft+/sUvlwkG/w+02WhPyi4AAA==");
}
