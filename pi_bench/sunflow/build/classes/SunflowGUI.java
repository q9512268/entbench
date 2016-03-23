@java.lang.SuppressWarnings("serial") 
public class SunflowGUI extends javax.swing.JFrame implements org.sunflow.system.UserInterface {
    private static final int DEFAULT_WIDTH = 1024;
    private static final int DEFAULT_HEIGHT = 768;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton renderButton;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JMenuItem fitWindowMenuItem;
    private javax.swing.JMenuItem tileWindowMenuItem;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JMenuItem consoleWindowMenuItem;
    private javax.swing.JMenuItem editorWindowMenuItem;
    private javax.swing.JMenuItem imageWindowMenuItem;
    private javax.swing.JMenu windowMenu;
    private javax.swing.JInternalFrame consoleFrame;
    private javax.swing.JInternalFrame editorFrame;
    private javax.swing.JInternalFrame imagePanelFrame;
    private javax.swing.JDesktopPane desktop;
    private javax.swing.JCheckBoxMenuItem smallTrianglesMenuItem;
    private javax.swing.JMenuItem textureCacheClearMenuItem;
    private javax.swing.JSeparator jSeparator4;
    private javax.swing.JMenuItem resetZoomMenuItem;
    private javax.swing.JMenu imageMenu;
    private org.sunflow.system.ImagePanel imagePanel;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JCheckBoxMenuItem clearLogMenuItem;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JButton taskCancelButton;
    private javax.swing.JProgressBar taskProgressBar;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JCheckBoxMenuItem autoBuildMenuItem;
    private javax.swing.JMenuItem iprMenuItem;
    private javax.swing.JMenuItem renderMenuItem;
    private javax.swing.JMenuItem buildMenuItem;
    private javax.swing.JMenu sceneMenu;
    private javax.swing.JTextArea editorTextArea;
    private javax.swing.JTextArea consoleTextArea;
    private javax.swing.JButton clearConsoleButton;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton iprButton;
    private javax.swing.JButton buildButton;
    private javax.swing.JMenuItem saveAsMenuItem;
    private javax.swing.JMenuItem saveMenuItem;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenuItem newFileMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenu batteryMenu;
    private javax.swing.JMenuItem lowBatteryItem;
    private javax.swing.JMenuItem midBatteryItem;
    private javax.swing.JMenuItem highBatteryItem;
    private java.lang.String currentFile;
    private java.lang.String currentTask;
    private int currentTaskLastP;
    private org.sunflow.SunflowAPI api;
    public static void usage(boolean verbose) { java.lang.System.out.println(
                                                                       "Usage: SunflowGUI [options] scenefile");
                                                if (verbose) { java.lang.System.
                                                                 out.println(
                                                                       "Sunflow v" +
                                                                       org.sunflow.SunflowAPI.
                                                                         VERSION +
                                                                       " textmode");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "Renders the specified scene file");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "Options:");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -o filename      Saves the output as the specified filenam" +
                                                                    "e (png, hdr, tga)"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("                   #\'s get expanded to the current frame nu" +
                                                                    "mber"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -nogui           Don\'t open the frame showing rendering p" +
                                                                    "rogress"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -ipr             Render using progressive algorithm");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -sampler type    Render using the specified algorithm");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -threads n       Render using n threads");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -lopri           Set thread priority to low (default)");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -hipri           Set thread priority to high");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -smallmesh       Load triangle meshes using triangles opti" +
                                                                    "mized for memory use"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -dumpkd          Dump KDTree to an obj file for visualizat" +
                                                                    "ion"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -buildonly       Do not call render method after loading t" +
                                                                    "he scene"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -showaa          Display sampling levels per pixel for buc" +
                                                                    "ket renderer"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -nogi            Disable any global illumination engines i" +
                                                                    "n the scene"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -nocaustics      Disable any caustic engine in the scene");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -pathgi n        Use path tracing with n samples to render" +
                                                                    " global illumination"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -quick_ambocc d  Applies ambient occlusion to the scene wi" +
                                                                    "th specified maximum distance"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -quick_uvs       Applies a surface uv visualization shader" +
                                                                    " to the scene"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -quick_normals   Applies a surface normal visualization sh" +
                                                                    "ader to the scene"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -quick_id        Renders using a unique color for each ins" +
                                                                    "tance"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -quick_prims     Renders using a unique color for each pri" +
                                                                    "mitive"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -quick_gray      Renders using a plain gray diffuse shader");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -quick_wire      Renders using a wireframe shader");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -resolution w h  Changes the render resolution to the spec" +
                                                                    "ified width and height (in pixels)"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -aa min max      Overrides the image anti-aliasing depths");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -bucket n order  Changes the default bucket size to n pixe" +
                                                                    "ls and the default order"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -bake name       Bakes a lightmap for the specified instan" +
                                                                    "ce"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -bakedir dir     Selects the type of lightmap baking: dir=" +
                                                                    "view or ortho"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -filter type     Selects the image filter to use");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -bench           Run several built-in scenes for benchmark" +
                                                                    " purposes"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -rtbench         Run realtime ray-tracing benchmark");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -frame n         Set frame number to the specified value");
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -anim n1 n2      Render all frames between the two specifi" +
                                                                    "ed values (inclusive)"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   ("  -v verbosity     Set the verbosity level: 0=none,1=errors," +
                                                                    "2=warnings,3=info,4=detailed"));
                                                               java.lang.System.
                                                                 out.
                                                                 println(
                                                                   "  -h               Prints this message");
                                                }
                                                java.lang.System.
                                                  exit(
                                                    1);
    }
    public static void main(java.lang.String[] args) {
        org.sunflow.system.UI.
          verbosity(
            4);
        if (args.
              length >
              0) {
            boolean showFrame =
              true;
            java.lang.String sampler =
              "bucket";
            boolean noRender =
              false;
            java.lang.String filename =
              null;
            java.lang.String input =
              null;
            int i =
              0;
            int threads =
              0;
            boolean lowPriority =
              true;
            boolean showAA =
              false;
            boolean noGI =
              false;
            boolean noCaustics =
              false;
            int pathGI =
              0;
            org.sunflow.core.Shader shaderOverride =
              null;
            int resolutionW =
              0;
            int resolutionH =
              0;
            int aaMin =
              -5;
            int aaMax =
              -5;
            int bucketSize =
              0;
            java.lang.String bucketOrder =
              null;
            java.lang.String bakingName =
              null;
            boolean bakeViewdep =
              false;
            java.lang.String filterType =
              null;
            boolean runBenchmark =
              false;
            boolean runRTBenchmark =
              false;
            int frameStart =
              1;
            int frameStop =
              1;
            while (i <
                     args.
                       length) {
                if (args[i].
                      equals(
                        "-o")) {
                    if (i >
                          args.
                            length -
                          2)
                        usage(
                          false);
                    filename =
                      args[i +
                             1];
                    i +=
                      2;
                }
                else
                    if (args[i].
                          equals(
                            "-nogui")) {
                        showFrame =
                          false;
                        i++;
                    }
                    else
                        if (args[i].
                              equals(
                                "-ipr")) {
                            sampler =
                              "ipr";
                            i++;
                        }
                        else
                            if (args[i].
                                  equals(
                                    "-threads")) {
                                if (i >
                                      args.
                                        length -
                                      2)
                                    usage(
                                      false);
                                threads =
                                  java.lang.Integer.
                                    parseInt(
                                      args[i +
                                             1]);
                                i +=
                                  2;
                            }
                            else
                                if (args[i].
                                      equals(
                                        "-lopri")) {
                                    lowPriority =
                                      true;
                                    i++;
                                }
                                else
                                    if (args[i].
                                          equals(
                                            "-hipri")) {
                                        lowPriority =
                                          false;
                                        i++;
                                    }
                                    else
                                        if (args[i].
                                              equals(
                                                "-sampler")) {
                                            if (i >
                                                  args.
                                                    length -
                                                  2)
                                                usage(
                                                  false);
                                            sampler =
                                              args[i +
                                                     1];
                                            i +=
                                              2;
                                        }
                                        else
                                            if (args[i].
                                                  equals(
                                                    "-smallmesh")) {
                                                org.sunflow.core.primitive.TriangleMesh.
                                                  setSmallTriangles(
                                                    true);
                                                i++;
                                            }
                                            else
                                                if (args[i].
                                                      equals(
                                                        "-dumpkd")) {
                                                    org.sunflow.core.accel.KDTree.
                                                      setDumpMode(
                                                        true,
                                                        "kdtree");
                                                    i++;
                                                }
                                                else
                                                    if (args[i].
                                                          equals(
                                                            "-buildonly")) {
                                                        noRender =
                                                          true;
                                                        i++;
                                                    }
                                                    else
                                                        if (args[i].
                                                              equals(
                                                                "-showaa")) {
                                                            showAA =
                                                              true;
                                                            i++;
                                                        }
                                                        else
                                                            if (args[i].
                                                                  equals(
                                                                    "-nogi")) {
                                                                noGI =
                                                                  true;
                                                                i++;
                                                            }
                                                            else
                                                                if (args[i].
                                                                      equals(
                                                                        "-nocaustics")) {
                                                                    noCaustics =
                                                                      true;
                                                                    i++;
                                                                }
                                                                else
                                                                    if (args[i].
                                                                          equals(
                                                                            "-pathgi")) {
                                                                        if (i >
                                                                              args.
                                                                                length -
                                                                              2)
                                                                            usage(
                                                                              false);
                                                                        pathGI =
                                                                          java.lang.Integer.
                                                                            parseInt(
                                                                              args[i +
                                                                                     1]);
                                                                        i +=
                                                                          2;
                                                                    }
                                                                    else
                                                                        if (args[i].
                                                                              equals(
                                                                                "-quick_ambocc")) {
                                                                            if (i >
                                                                                  args.
                                                                                    length -
                                                                                  2)
                                                                                usage(
                                                                                  false);
                                                                            float d =
                                                                              java.lang.Float.
                                                                              parseFloat(
                                                                                args[i +
                                                                                       1]);
                                                                            shaderOverride =
                                                                              new org.sunflow.core.shader.AmbientOcclusionShader(
                                                                                org.sunflow.image.Color.
                                                                                  WHITE,
                                                                                d);
                                                                            i +=
                                                                              2;
                                                                        }
                                                                        else
                                                                            if (args[i].
                                                                                  equals(
                                                                                    "-quick_uvs")) {
                                                                                if (i >
                                                                                      args.
                                                                                        length -
                                                                                      1)
                                                                                    usage(
                                                                                      false);
                                                                                shaderOverride =
                                                                                  new org.sunflow.core.shader.UVShader(
                                                                                    );
                                                                                i++;
                                                                            }
                                                                            else
                                                                                if (args[i].
                                                                                      equals(
                                                                                        "-quick_normals")) {
                                                                                    if (i >
                                                                                          args.
                                                                                            length -
                                                                                          1)
                                                                                        usage(
                                                                                          false);
                                                                                    shaderOverride =
                                                                                      new org.sunflow.core.shader.NormalShader(
                                                                                        );
                                                                                    i++;
                                                                                }
                                                                                else
                                                                                    if (args[i].
                                                                                          equals(
                                                                                            "-quick_id")) {
                                                                                        if (i >
                                                                                              args.
                                                                                                length -
                                                                                              1)
                                                                                            usage(
                                                                                              false);
                                                                                        shaderOverride =
                                                                                          new org.sunflow.core.shader.IDShader(
                                                                                            );
                                                                                        i++;
                                                                                    }
                                                                                    else
                                                                                        if (args[i].
                                                                                              equals(
                                                                                                "-quick_prims")) {
                                                                                            if (i >
                                                                                                  args.
                                                                                                    length -
                                                                                                  1)
                                                                                                usage(
                                                                                                  false);
                                                                                            shaderOverride =
                                                                                              new org.sunflow.core.shader.PrimIDShader(
                                                                                                );
                                                                                            i++;
                                                                                        }
                                                                                        else
                                                                                            if (args[i].
                                                                                                  equals(
                                                                                                    "-quick_gray")) {
                                                                                                if (i >
                                                                                                      args.
                                                                                                        length -
                                                                                                      1)
                                                                                                    usage(
                                                                                                      false);
                                                                                                shaderOverride =
                                                                                                  new org.sunflow.core.shader.QuickGrayShader(
                                                                                                    );
                                                                                                i++;
                                                                                            }
                                                                                            else
                                                                                                if (args[i].
                                                                                                      equals(
                                                                                                        "-quick_wire")) {
                                                                                                    if (i >
                                                                                                          args.
                                                                                                            length -
                                                                                                          1)
                                                                                                        usage(
                                                                                                          false);
                                                                                                    shaderOverride =
                                                                                                      new org.sunflow.core.shader.WireframeShader(
                                                                                                        );
                                                                                                    i++;
                                                                                                }
                                                                                                else
                                                                                                    if (args[i].
                                                                                                          equals(
                                                                                                            "-resolution")) {
                                                                                                        if (i >
                                                                                                              args.
                                                                                                                length -
                                                                                                              3)
                                                                                                            usage(
                                                                                                              false);
                                                                                                        resolutionW =
                                                                                                          java.lang.Integer.
                                                                                                            parseInt(
                                                                                                              args[i +
                                                                                                                     1]);
                                                                                                        resolutionH =
                                                                                                          java.lang.Integer.
                                                                                                            parseInt(
                                                                                                              args[i +
                                                                                                                     2]);
                                                                                                        i +=
                                                                                                          3;
                                                                                                    }
                                                                                                    else
                                                                                                        if (args[i].
                                                                                                              equals(
                                                                                                                "-aa")) {
                                                                                                            if (i >
                                                                                                                  args.
                                                                                                                    length -
                                                                                                                  3)
                                                                                                                usage(
                                                                                                                  false);
                                                                                                            aaMin =
                                                                                                              java.lang.Integer.
                                                                                                                parseInt(
                                                                                                                  args[i +
                                                                                                                         1]);
                                                                                                            aaMax =
                                                                                                              java.lang.Integer.
                                                                                                                parseInt(
                                                                                                                  args[i +
                                                                                                                         2]);
                                                                                                            i +=
                                                                                                              3;
                                                                                                        }
                                                                                                        else
                                                                                                            if (args[i].
                                                                                                                  equals(
                                                                                                                    "-bucket")) {
                                                                                                                if (i >
                                                                                                                      args.
                                                                                                                        length -
                                                                                                                      3)
                                                                                                                    usage(
                                                                                                                      false);
                                                                                                                bucketSize =
                                                                                                                  java.lang.Integer.
                                                                                                                    parseInt(
                                                                                                                      args[i +
                                                                                                                             1]);
                                                                                                                bucketOrder =
                                                                                                                  args[i +
                                                                                                                         2];
                                                                                                                i +=
                                                                                                                  3;
                                                                                                            }
                                                                                                            else
                                                                                                                if (args[i].
                                                                                                                      equals(
                                                                                                                        "-bake")) {
                                                                                                                    if (i >
                                                                                                                          args.
                                                                                                                            length -
                                                                                                                          2)
                                                                                                                        usage(
                                                                                                                          false);
                                                                                                                    bakingName =
                                                                                                                      args[i +
                                                                                                                             1];
                                                                                                                    i +=
                                                                                                                      2;
                                                                                                                }
                                                                                                                else
                                                                                                                    if (args[i].
                                                                                                                          equals(
                                                                                                                            "-bakedir")) {
                                                                                                                        if (i >
                                                                                                                              args.
                                                                                                                                length -
                                                                                                                              2)
                                                                                                                            usage(
                                                                                                                              false);
                                                                                                                        java.lang.String baketype =
                                                                                                                          args[i +
                                                                                                                                 1];
                                                                                                                        if (baketype.
                                                                                                                              equals(
                                                                                                                                "view"))
                                                                                                                            bakeViewdep =
                                                                                                                              true;
                                                                                                                        else
                                                                                                                            if (baketype.
                                                                                                                                  equals(
                                                                                                                                    "ortho"))
                                                                                                                                bakeViewdep =
                                                                                                                                  false;
                                                                                                                            else
                                                                                                                                usage(
                                                                                                                                  false);
                                                                                                                        i +=
                                                                                                                          2;
                                                                                                                    }
                                                                                                                    else
                                                                                                                        if (args[i].
                                                                                                                              equals(
                                                                                                                                "-filter")) {
                                                                                                                            if (i >
                                                                                                                                  args.
                                                                                                                                    length -
                                                                                                                                  2)
                                                                                                                                usage(
                                                                                                                                  false);
                                                                                                                            filterType =
                                                                                                                              args[i +
                                                                                                                                     1];
                                                                                                                            i +=
                                                                                                                              2;
                                                                                                                        }
                                                                                                                        else
                                                                                                                            if (args[i].
                                                                                                                                  equals(
                                                                                                                                    "-bench")) {
                                                                                                                                runBenchmark =
                                                                                                                                  true;
                                                                                                                                i++;
                                                                                                                            }
                                                                                                                            else
                                                                                                                                if (args[i].
                                                                                                                                      equals(
                                                                                                                                        "-rtbench")) {
                                                                                                                                    runRTBenchmark =
                                                                                                                                      true;
                                                                                                                                    i++;
                                                                                                                                }
                                                                                                                                else
                                                                                                                                    if (args[i].
                                                                                                                                          equals(
                                                                                                                                            "-frame")) {
                                                                                                                                        if (i >
                                                                                                                                              args.
                                                                                                                                                length -
                                                                                                                                              2)
                                                                                                                                            usage(
                                                                                                                                              false);
                                                                                                                                        frameStart =
                                                                                                                                          (frameStop =
                                                                                                                                             java.lang.Integer.
                                                                                                                                               parseInt(
                                                                                                                                                 args[i +
                                                                                                                                                        1]));
                                                                                                                                        i +=
                                                                                                                                          2;
                                                                                                                                    }
                                                                                                                                    else
                                                                                                                                        if (args[i].
                                                                                                                                              equals(
                                                                                                                                                "-anim")) {
                                                                                                                                            if (i >
                                                                                                                                                  args.
                                                                                                                                                    length -
                                                                                                                                                  3)
                                                                                                                                                usage(
                                                                                                                                                  false);
                                                                                                                                            frameStart =
                                                                                                                                              java.lang.Integer.
                                                                                                                                                parseInt(
                                                                                                                                                  args[i +
                                                                                                                                                         1]);
                                                                                                                                            frameStop =
                                                                                                                                              java.lang.Integer.
                                                                                                                                                parseInt(
                                                                                                                                                  args[i +
                                                                                                                                                         2]);
                                                                                                                                            i +=
                                                                                                                                              3;
                                                                                                                                        }
                                                                                                                                        else
                                                                                                                                            if (args[i].
                                                                                                                                                  equals(
                                                                                                                                                    "-v")) {
                                                                                                                                                if (i >
                                                                                                                                                      args.
                                                                                                                                                        length -
                                                                                                                                                      2)
                                                                                                                                                    usage(
                                                                                                                                                      false);
                                                                                                                                                org.sunflow.system.UI.
                                                                                                                                                  verbosity(
                                                                                                                                                    java.lang.Integer.
                                                                                                                                                      parseInt(
                                                                                                                                                        args[i +
                                                                                                                                                               1]));
                                                                                                                                                i +=
                                                                                                                                                  2;
                                                                                                                                            }
                                                                                                                                            else
                                                                                                                                                if (args[i].
                                                                                                                                                      equals(
                                                                                                                                                        "-h") ||
                                                                                                                                                      args[i].
                                                                                                                                                      equals(
                                                                                                                                                        "-help")) {
                                                                                                                                                    usage(
                                                                                                                                                      true);
                                                                                                                                                }
                                                                                                                                                else {
                                                                                                                                                    if (input !=
                                                                                                                                                          null)
                                                                                                                                                        usage(
                                                                                                                                                          false);
                                                                                                                                                    input =
                                                                                                                                                      args[i];
                                                                                                                                                    i++;
                                                                                                                                                }
            }
            ent.runtime.ENT_Util.
              initModeFile(
                );
            int PANDA_RUNS =
              java.lang.Integer.
              parseInt(
                java.lang.System.
                  getenv(
                    "PANDA_RUNS"));
            for (int k =
                   0;
                 k <
                   PANDA_RUNS;
                 k++) {
                ent.runtime.ENT_Util.
                  resetStopwatch(
                    );
                ent.runtime.ENT_Util.
                  startStopwatch(
                    );
                if (runBenchmark) {
                    org.sunflow.SunflowAPI.
                      runSystemCheck(
                        );
                    new org.sunflow.Benchmark(
                      ).
                      execute(
                        );
                    return;
                }
                if (runRTBenchmark) {
                    org.sunflow.SunflowAPI.
                      runSystemCheck(
                        );
                    org.sunflow.RealtimeBenchmark t =
                      new org.sunflow.RealtimeBenchmark(
                      showFrame,
                      threads);
                    return;
                }
                if (input ==
                      null)
                    usage(
                      false);
                org.sunflow.SunflowAPI.
                  runSystemCheck(
                    );
                if (frameStart <
                      frameStop &&
                      showFrame) {
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          GUI,
                        ("Animations should not be rendered without -nogui - forcing G" +
                         "UI off anyway"));
                    showFrame =
                      false;
                }
                if (frameStart <
                      frameStop &&
                      filename ==
                      null) {
                    filename =
                      "output.#.png";
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          GUI,
                        "Animation output was not specified - defaulting to: \"%s\"",
                        filename);
                }
                for (int frameNumber =
                       frameStart;
                     frameNumber <=
                       frameStop;
                     frameNumber++) {
                    org.sunflow.SunflowAPI api =
                      org.sunflow.SunflowAPI.
                      create(
                        input,
                        frameNumber);
                    if (api ==
                          null)
                        continue;
                    if (noRender)
                        continue;
                    if (resolutionW >
                          0 &&
                          resolutionH >
                          0) {
                        api.
                          parameter(
                            "resolutionX",
                            resolutionW);
                        api.
                          parameter(
                            "resolutionY",
                            resolutionH);
                    }
                    if (aaMin !=
                          -5 ||
                          aaMax !=
                          -5) {
                        api.
                          parameter(
                            "aa.min",
                            aaMin);
                        api.
                          parameter(
                            "aa.max",
                            aaMax);
                    }
                    if (bucketSize >
                          0)
                        api.
                          parameter(
                            "bucket.size",
                            bucketSize);
                    if (bucketOrder !=
                          null)
                        api.
                          parameter(
                            "bucket.order",
                            bucketOrder);
                    api.
                      parameter(
                        "aa.display",
                        showAA);
                    api.
                      parameter(
                        "threads",
                        threads);
                    api.
                      parameter(
                        "threads.lowPriority",
                        lowPriority);
                    if (bakingName !=
                          null) {
                        api.
                          parameter(
                            "baking.instance",
                            bakingName);
                        api.
                          parameter(
                            "baking.viewdep",
                            bakeViewdep);
                    }
                    if (filterType !=
                          null)
                        api.
                          parameter(
                            "filter",
                            filterType);
                    if (noGI)
                        api.
                          parameter(
                            "gi.engine",
                            "none");
                    else
                        if (pathGI >
                              0) {
                            api.
                              parameter(
                                "gi.engine",
                                "path");
                            api.
                              parameter(
                                "gi.path.samples",
                                pathGI);
                        }
                    if (noCaustics)
                        api.
                          parameter(
                            "caustics",
                            "none");
                    api.
                      parameter(
                        "sampler",
                        sampler);
                    api.
                      options(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS);
                    if (shaderOverride !=
                          null) {
                        api.
                          shader(
                            "ambocc",
                            shaderOverride);
                        api.
                          shaderOverride(
                            "ambocc",
                            true);
                    }
                    org.sunflow.core.Display display;
                    java.lang.String currentFilename =
                      filename !=
                      null
                      ? filename.
                      replace(
                        "#",
                        java.lang.String.
                          format(
                            "%04d",
                            frameNumber))
                      : null;
                    if (showFrame) {
                        display =
                          new org.sunflow.core.display.FrameDisplay(
                            currentFilename);
                    }
                    else {
                        if (currentFilename !=
                              null &&
                              currentFilename.
                              endsWith(
                                ".exr")) {
                            try {
                                display =
                                  new org.sunflow.core.display.OpenExrDisplay(
                                    currentFilename,
                                    "zip",
                                    "float");
                            }
                            catch (java.lang.Exception e) {
                                e.
                                  printStackTrace(
                                    );
                                return;
                            }
                        }
                        else
                            if (currentFilename !=
                                  null &&
                                  currentFilename.
                                  equals(
                                    "imgpipe")) {
                                display =
                                  new org.sunflow.core.display.ImgPipeDisplay(
                                    );
                            }
                            else
                                display =
                                  new org.sunflow.core.display.FileDisplay(
                                    currentFilename);
                    }
                    api.
                      render(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS,
                        display);
                }
                ent.runtime.ENT_Util.
                  stopStopwatch(
                    );
                ent.runtime.ENT_Util.
                  writeModeFile(
                    java.lang.String.
                      format(
                        "ERun %d: %f %f %f %f\n",
                        k,
                        0.0,
                        0.0,
                        0.0,
                        ent.runtime.ENT_Util.
                          elapsedTime(
                            )));
            }
            ent.runtime.ENT_Util.
              closeModeFile(
                );
        }
        else {
            javax.swing.plaf.metal.MetalLookAndFeel.
              setCurrentTheme(
                new javax.swing.plaf.metal.DefaultMetalTheme(
                  ));
            SunflowGUI gui =
              new SunflowGUI(
              );
            gui.
              setVisible(
                true);
            java.awt.Dimension screenRes =
              java.awt.Toolkit.
              getDefaultToolkit(
                ).
              getScreenSize(
                );
            if (screenRes.
                  getWidth(
                    ) <=
                  DEFAULT_WIDTH ||
                  screenRes.
                  getHeight(
                    ) <=
                  DEFAULT_HEIGHT)
                gui.
                  setExtendedState(
                    MAXIMIZED_BOTH);
            gui.
              tileWindowMenuItem.
              doClick(
                );
            org.sunflow.SunflowAPI.
              runSystemCheck(
                );
        }
    }
    public SunflowGUI() { super();
                          currentFile = null;
                          api = null;
                          initGUI();
                          pack();
                          setLocationRelativeTo(
                            null);
                          newFileMenuItemActionPerformed(
                            null);
                          org.sunflow.system.UI.
                            set(
                              this); }
    private void initGUI() { setTitle("Sunflow v" +
                                      org.sunflow.SunflowAPI.
                                        VERSION);
                             setDefaultCloseOperation(
                               EXIT_ON_CLOSE);
                             { desktop = new javax.swing.JDesktopPane(
                                           );
                               getContentPane(
                                 ).add(desktop,
                                       java.awt.BorderLayout.
                                         CENTER);
                               java.awt.Dimension screenRes =
                                 java.awt.Toolkit.
                                 getDefaultToolkit(
                                   ).
                                 getScreenSize(
                                   );
                               if (screenRes.
                                     getWidth(
                                       ) <=
                                     DEFAULT_WIDTH ||
                                     screenRes.
                                     getHeight(
                                       ) <=
                                     DEFAULT_HEIGHT)
                                   desktop.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         640,
                                         480));
                               else
                                   desktop.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         DEFAULT_WIDTH,
                                         DEFAULT_HEIGHT));
                               { imagePanelFrame =
                                   new javax.swing.JInternalFrame(
                                     );
                                 desktop.
                                   add(
                                     imagePanelFrame);
                                 { jPanel1 =
                                     new javax.swing.JPanel(
                                       );
                                   java.awt.FlowLayout jPanel1Layout =
                                     new java.awt.FlowLayout(
                                     );
                                   jPanel1Layout.
                                     setAlignment(
                                       java.awt.FlowLayout.
                                         LEFT);
                                   jPanel1.
                                     setLayout(
                                       jPanel1Layout);
                                   imagePanelFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       jPanel1,
                                       java.awt.BorderLayout.
                                         NORTH);
                                   { renderButton =
                                       new javax.swing.JButton(
                                         );
                                     jPanel1.
                                       add(
                                         renderButton);
                                     renderButton.
                                       setText(
                                         "Render");
                                     renderButton.
                                       addActionListener(
                                         new java.awt.event.ActionListener(
                                           ) {
                                             public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                 renderMenuItemActionPerformed(
                                                   evt);
                                             }
                                         });
                                   }
                                   { iprButton =
                                       new javax.swing.JButton(
                                         );
                                     jPanel1.
                                       add(
                                         iprButton);
                                     iprButton.
                                       setText(
                                         "IPR");
                                     iprButton.
                                       addActionListener(
                                         new java.awt.event.ActionListener(
                                           ) {
                                             public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                 iprMenuItemActionPerformed(
                                                   evt);
                                             }
                                         });
                                   } }
                                 { imagePanel =
                                     new org.sunflow.system.ImagePanel(
                                       );
                                   imagePanelFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       imagePanel,
                                       java.awt.BorderLayout.
                                         CENTER);
                                 }
                                 imagePanelFrame.
                                   pack(
                                     );
                                 imagePanelFrame.
                                   setResizable(
                                     true);
                                 imagePanelFrame.
                                   setMaximizable(
                                     true);
                                 imagePanelFrame.
                                   setVisible(
                                     true);
                                 imagePanelFrame.
                                   setTitle(
                                     "Image");
                                 imagePanelFrame.
                                   setIconifiable(
                                     true);
                               }
                               { editorFrame =
                                   new javax.swing.JInternalFrame(
                                     );
                                 desktop.
                                   add(
                                     editorFrame);
                                 editorFrame.
                                   setTitle(
                                     "Script Editor");
                                 editorFrame.
                                   setMaximizable(
                                     true);
                                 editorFrame.
                                   setResizable(
                                     true);
                                 editorFrame.
                                   setIconifiable(
                                     true);
                                 { jScrollPane1 =
                                     new javax.swing.JScrollPane(
                                       );
                                   editorFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       jScrollPane1,
                                       java.awt.BorderLayout.
                                         CENTER);
                                   jScrollPane1.
                                     setVerticalScrollBarPolicy(
                                       javax.swing.ScrollPaneConstants.
                                         VERTICAL_SCROLLBAR_ALWAYS);
                                   jScrollPane1.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         360,
                                         280));
                                   { editorTextArea =
                                       new javax.swing.JTextArea(
                                         );
                                     jScrollPane1.
                                       setViewportView(
                                         editorTextArea);
                                     editorTextArea.
                                       setFont(
                                         new java.awt.Font(
                                           "Monospaced",
                                           0,
                                           12));
                                     editorTextArea.
                                       setTransferHandler(
                                         new SunflowGUI.SceneTransferHandler(
                                           ));
                                   } }
                                 { jPanel3 =
                                     new javax.swing.JPanel(
                                       );
                                   editorFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       jPanel3,
                                       java.awt.BorderLayout.
                                         SOUTH);
                                   java.awt.FlowLayout jPanel3Layout =
                                     new java.awt.FlowLayout(
                                     );
                                   jPanel3Layout.
                                     setAlignment(
                                       java.awt.FlowLayout.
                                         RIGHT);
                                   jPanel3.
                                     setLayout(
                                       jPanel3Layout);
                                   { buildButton =
                                       new javax.swing.JButton(
                                         );
                                     jPanel3.
                                       add(
                                         buildButton);
                                     buildButton.
                                       setText(
                                         "Build Scene");
                                     buildButton.
                                       addActionListener(
                                         new java.awt.event.ActionListener(
                                           ) {
                                             public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                 buildMenuItemActionPerformed(
                                                   evt);
                                             }
                                         });
                                   } }
                                 editorFrame.
                                   pack(
                                     );
                                 editorFrame.
                                   setVisible(
                                     true);
                               }
                               { consoleFrame =
                                   new javax.swing.JInternalFrame(
                                     );
                                 desktop.
                                   add(
                                     consoleFrame);
                                 consoleFrame.
                                   setIconifiable(
                                     true);
                                 consoleFrame.
                                   setMaximizable(
                                     true);
                                 consoleFrame.
                                   setResizable(
                                     true);
                                 consoleFrame.
                                   setTitle(
                                     "Console");
                                 { jScrollPane2 =
                                     new javax.swing.JScrollPane(
                                       );
                                   consoleFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       jScrollPane2,
                                       java.awt.BorderLayout.
                                         CENTER);
                                   jScrollPane2.
                                     setVerticalScrollBarPolicy(
                                       javax.swing.ScrollPaneConstants.
                                         VERTICAL_SCROLLBAR_ALWAYS);
                                   jScrollPane2.
                                     setPreferredSize(
                                       new java.awt.Dimension(
                                         360,
                                         100));
                                   { consoleTextArea =
                                       new javax.swing.JTextArea(
                                         );
                                     jScrollPane2.
                                       setViewportView(
                                         consoleTextArea);
                                     consoleTextArea.
                                       setFont(
                                         new java.awt.Font(
                                           "Monospaced",
                                           0,
                                           12));
                                     consoleTextArea.
                                       setEditable(
                                         false);
                                   } }
                                 { jPanel4 =
                                     new javax.swing.JPanel(
                                       );
                                   consoleFrame.
                                     getContentPane(
                                       ).
                                     add(
                                       jPanel4,
                                       java.awt.BorderLayout.
                                         SOUTH);
                                   java.awt.BorderLayout jPanel4Layout =
                                     new java.awt.BorderLayout(
                                     );
                                   jPanel4.
                                     setLayout(
                                       jPanel4Layout);
                                   { jPanel6 =
                                       new javax.swing.JPanel(
                                         );
                                     java.awt.BorderLayout jPanel6Layout =
                                       new java.awt.BorderLayout(
                                       );
                                     jPanel6.
                                       setLayout(
                                         jPanel6Layout);
                                     jPanel4.
                                       add(
                                         jPanel6,
                                         java.awt.BorderLayout.
                                           CENTER);
                                     jPanel6.
                                       setBorder(
                                         javax.swing.BorderFactory.
                                           createEmptyBorder(
                                             5,
                                             5,
                                             5,
                                             0));
                                     { taskProgressBar =
                                         new javax.swing.JProgressBar(
                                           );
                                       jPanel6.
                                         add(
                                           taskProgressBar);
                                       taskProgressBar.
                                         setEnabled(
                                           false);
                                       taskProgressBar.
                                         setString(
                                           "");
                                       taskProgressBar.
                                         setStringPainted(
                                           true);
                                       taskProgressBar.
                                         setOpaque(
                                           false);
                                     } }
                                   { jPanel5 =
                                       new javax.swing.JPanel(
                                         );
                                     java.awt.FlowLayout jPanel5Layout =
                                       new java.awt.FlowLayout(
                                       );
                                     jPanel5Layout.
                                       setAlignment(
                                         java.awt.FlowLayout.
                                           RIGHT);
                                     jPanel5.
                                       setLayout(
                                         jPanel5Layout);
                                     jPanel4.
                                       add(
                                         jPanel5,
                                         java.awt.BorderLayout.
                                           EAST);
                                     { taskCancelButton =
                                         new javax.swing.JButton(
                                           );
                                       jPanel5.
                                         add(
                                           taskCancelButton);
                                       taskCancelButton.
                                         setText(
                                           "Cancel");
                                       taskCancelButton.
                                         setEnabled(
                                           false);
                                       taskCancelButton.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                   org.sunflow.system.UI.
                                                     taskCancel(
                                                       );
                                               }
                                           });
                                     }
                                     { clearConsoleButton =
                                         new javax.swing.JButton(
                                           );
                                       jPanel5.
                                         add(
                                           clearConsoleButton);
                                       clearConsoleButton.
                                         setText(
                                           "Clear");
                                       clearConsoleButton.
                                         addActionListener(
                                           new java.awt.event.ActionListener(
                                             ) {
                                               public void actionPerformed(java.awt.event.ActionEvent evt) {
                                                   clearConsole(
                                                     );
                                               }
                                           });
                                     } } }
                                 consoleFrame.
                                   pack(
                                     );
                                 consoleFrame.
                                   setVisible(
                                     true);
                               } }
                             { jMenuBar1 =
                                 new javax.swing.JMenuBar(
                                   );
                               setJMenuBar(
                                 jMenuBar1);
                               { fileMenu =
                                   new javax.swing.JMenu(
                                     );
                                 jMenuBar1.
                                   add(
                                     fileMenu);
                                 fileMenu.
                                   setText(
                                     "File");
                                 { newFileMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   fileMenu.
                                     add(
                                       newFileMenuItem);
                                   newFileMenuItem.
                                     setText(
                                       "New");
                                   newFileMenuItem.
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           "ctrl N"));
                                   newFileMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               newFileMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { openFileMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   fileMenu.
                                     add(
                                       openFileMenuItem);
                                   openFileMenuItem.
                                     setText(
                                       "Open ...");
                                   openFileMenuItem.
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           "ctrl O"));
                                   openFileMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               openFileMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { saveMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   fileMenu.
                                     add(
                                       saveMenuItem);
                                   saveMenuItem.
                                     setText(
                                       "Save");
                                   saveMenuItem.
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           "ctrl S"));
                                   saveMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               saveCurrentFile(
                                                 currentFile);
                                           }
                                       });
                                 }
                                 { saveAsMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   fileMenu.
                                     add(
                                       saveAsMenuItem);
                                   saveAsMenuItem.
                                     setText(
                                       "Save As ...");
                                   saveAsMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               saveAsMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { jSeparator2 =
                                     new javax.swing.JSeparator(
                                       );
                                   fileMenu.
                                     add(
                                       jSeparator2);
                                 }
                                 { exitMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   fileMenu.
                                     add(
                                       exitMenuItem);
                                   exitMenuItem.
                                     setText(
                                       "Exit");
                                   exitMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               java.lang.System.
                                                 exit(
                                                   0);
                                           }
                                       });
                                 } }
                               { sceneMenu =
                                   new javax.swing.JMenu(
                                     );
                                 jMenuBar1.
                                   add(
                                     sceneMenu);
                                 sceneMenu.
                                   setText(
                                     "Scene");
                                 { buildMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       buildMenuItem);
                                   buildMenuItem.
                                     setText(
                                       "Build");
                                   buildMenuItem.
                                     setAccelerator(
                                       javax.swing.KeyStroke.
                                         getKeyStroke(
                                           "ctrl B"));
                                   buildMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               if (sceneMenu.
                                                     isEnabled(
                                                       ))
                                                   buildMenuItemActionPerformed(
                                                     evt);
                                           }
                                       });
                                 }
                                 { autoBuildMenuItem =
                                     new javax.swing.JCheckBoxMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       autoBuildMenuItem);
                                   autoBuildMenuItem.
                                     setText(
                                       "Build on open");
                                   autoBuildMenuItem.
                                     setSelected(
                                       true);
                                 }
                                 { jSeparator3 =
                                     new javax.swing.JSeparator(
                                       );
                                   sceneMenu.
                                     add(
                                       jSeparator3);
                                 }
                                 { renderMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       renderMenuItem);
                                   renderMenuItem.
                                     setText(
                                       "Render");
                                   renderMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               renderMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { iprMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       iprMenuItem);
                                   iprMenuItem.
                                     setText(
                                       "IPR");
                                   iprMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               iprMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { clearLogMenuItem =
                                     new javax.swing.JCheckBoxMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       clearLogMenuItem);
                                   clearLogMenuItem.
                                     setText(
                                       "Auto Clear Log");
                                   clearLogMenuItem.
                                     setToolTipText(
                                       "Clears the console before building or rendering");
                                   clearLogMenuItem.
                                     setSelected(
                                       true);
                                 }
                                 { jSeparator4 =
                                     new javax.swing.JSeparator(
                                       );
                                   sceneMenu.
                                     add(
                                       jSeparator4);
                                 }
                                 { textureCacheClearMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       textureCacheClearMenuItem);
                                   textureCacheClearMenuItem.
                                     setText(
                                       "Clear Texture Cache");
                                   textureCacheClearMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               textureCacheClearMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 }
                                 { smallTrianglesMenuItem =
                                     new javax.swing.JCheckBoxMenuItem(
                                       );
                                   sceneMenu.
                                     add(
                                       smallTrianglesMenuItem);
                                   smallTrianglesMenuItem.
                                     setText(
                                       "Low Mem Triangles");
                                   smallTrianglesMenuItem.
                                     setToolTipText(
                                       ("Load future meshes using a low memory footprint triangle rep" +
                                        "resentation"));
                                   smallTrianglesMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               smallTrianglesMenuItemActionPerformed(
                                                 evt);
                                           }
                                       });
                                 } }
                               { imageMenu =
                                   new javax.swing.JMenu(
                                     );
                                 jMenuBar1.
                                   add(
                                     imageMenu);
                                 imageMenu.
                                   setText(
                                     "Image");
                                 { resetZoomMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   imageMenu.
                                     add(
                                       resetZoomMenuItem);
                                   resetZoomMenuItem.
                                     setText(
                                       "Reset Zoom");
                                   resetZoomMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               imagePanel.
                                                 reset(
                                                   );
                                           }
                                       });
                                 }
                                 { fitWindowMenuItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   imageMenu.
                                     add(
                                       fitWindowMenuItem);
                                   fitWindowMenuItem.
                                     setText(
                                       "Fit to Window");
                                   fitWindowMenuItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               imagePanel.
                                                 fit(
                                                   );
                                           }
                                       });
                                 }
                                 { jSeparator1 =
                                     new javax.swing.JSeparator(
                                       );
                                   imageMenu.
                                     add(
                                       jSeparator1);
                                 }
                                 { jMenuItem4 =
                                     new javax.swing.JMenuItem(
                                       );
                                   imageMenu.
                                     add(
                                       jMenuItem4);
                                   jMenuItem4.
                                     setText(
                                       "Save Image ...");
                                   jMenuItem4.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               javax.swing.JFileChooser fc =
                                                 new javax.swing.JFileChooser(
                                                 ".");
                                               fc.
                                                 setFileFilter(
                                                   new javax.swing.filechooser.FileFilter(
                                                     ) {
                                                       public java.lang.String getDescription() {
                                                           return "Image File";
                                                       }
                                                       public boolean accept(java.io.File f) {
                                                           return f.
                                                             isDirectory(
                                                               ) ||
                                                             f.
                                                             getName(
                                                               ).
                                                             endsWith(
                                                               ".png") ||
                                                             f.
                                                             getName(
                                                               ).
                                                             endsWith(
                                                               ".tga");
                                                       }
                                                   });
                                               if (fc.
                                                     showSaveDialog(
                                                       SunflowGUI.this) ==
                                                     javax.swing.JFileChooser.
                                                       APPROVE_OPTION) {
                                                   java.lang.String filename =
                                                     fc.
                                                     getSelectedFile(
                                                       ).
                                                     getAbsolutePath(
                                                       );
                                                   imagePanel.
                                                     save(
                                                       filename);
                                               }
                                           }
                                       });
                                 } }
                               { windowMenu =
                                   new javax.swing.JMenu(
                                     );
                                 jMenuBar1.
                                   add(
                                     windowMenu);
                                 windowMenu.
                                   setText(
                                     "Window");
                               }
                               { imageWindowMenuItem =
                                   new javax.swing.JMenuItem(
                                     );
                                 windowMenu.
                                   add(
                                     imageWindowMenuItem);
                                 imageWindowMenuItem.
                                   setText(
                                     "Image");
                                 imageWindowMenuItem.
                                   setAccelerator(
                                     javax.swing.KeyStroke.
                                       getKeyStroke(
                                         "ctrl 1"));
                                 imageWindowMenuItem.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             selectFrame(
                                               imagePanelFrame);
                                         }
                                     }); }
                               { editorWindowMenuItem =
                                   new javax.swing.JMenuItem(
                                     );
                                 windowMenu.
                                   add(
                                     editorWindowMenuItem);
                                 editorWindowMenuItem.
                                   setText(
                                     "Script Editor");
                                 editorWindowMenuItem.
                                   setAccelerator(
                                     javax.swing.KeyStroke.
                                       getKeyStroke(
                                         "ctrl 2"));
                                 editorWindowMenuItem.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             selectFrame(
                                               editorFrame);
                                         }
                                     }); }
                               { consoleWindowMenuItem =
                                   new javax.swing.JMenuItem(
                                     );
                                 windowMenu.
                                   add(
                                     consoleWindowMenuItem);
                                 consoleWindowMenuItem.
                                   setText(
                                     "Console");
                                 consoleWindowMenuItem.
                                   setAccelerator(
                                     javax.swing.KeyStroke.
                                       getKeyStroke(
                                         "ctrl 3"));
                                 consoleWindowMenuItem.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             selectFrame(
                                               consoleFrame);
                                         }
                                     }); }
                               { batteryMenu =
                                   new javax.swing.JMenu(
                                     );
                                 jMenuBar1.
                                   add(
                                     batteryMenu);
                                 batteryMenu.
                                   setText(
                                     "Battery");
                                 { lowBatteryItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   batteryMenu.
                                     add(
                                       lowBatteryItem);
                                   lowBatteryItem.
                                     setText(
                                       "Low Battery");
                                   lowBatteryItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               if (batteryMenu.
                                                     isEnabled(
                                                       ))
                                                   lowBatteryItemActionPerformed(
                                                     evt);
                                           }
                                       });
                                 }
                                 { midBatteryItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   batteryMenu.
                                     add(
                                       midBatteryItem);
                                   midBatteryItem.
                                     setText(
                                       "Mid Battery");
                                   midBatteryItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               if (batteryMenu.
                                                     isEnabled(
                                                       ))
                                                   midBatteryItemActionPerformed(
                                                     evt);
                                           }
                                       });
                                 }
                                 { highBatteryItem =
                                     new javax.swing.JMenuItem(
                                       );
                                   batteryMenu.
                                     add(
                                       highBatteryItem);
                                   highBatteryItem.
                                     setText(
                                       "High Battery");
                                   highBatteryItem.
                                     addActionListener(
                                       new java.awt.event.ActionListener(
                                         ) {
                                           public void actionPerformed(java.awt.event.ActionEvent evt) {
                                               if (batteryMenu.
                                                     isEnabled(
                                                       ))
                                                   highBatteryItemActionPerformed(
                                                     evt);
                                           }
                                       });
                                 } }
                               { jSeparator5 =
                                   new javax.swing.JSeparator(
                                     );
                                 windowMenu.
                                   add(
                                     jSeparator5);
                               }
                               { tileWindowMenuItem =
                                   new javax.swing.JMenuItem(
                                     );
                                 windowMenu.
                                   add(
                                     tileWindowMenuItem);
                                 tileWindowMenuItem.
                                   setText(
                                     "Tile");
                                 tileWindowMenuItem.
                                   setAccelerator(
                                     javax.swing.KeyStroke.
                                       getKeyStroke(
                                         "ctrl T"));
                                 tileWindowMenuItem.
                                   addActionListener(
                                     new java.awt.event.ActionListener(
                                       ) {
                                         public void actionPerformed(java.awt.event.ActionEvent evt) {
                                             tileWindowMenuItemActionPerformed(
                                               evt);
                                         }
                                     }); }
                             } }
    private void newFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        if (evt !=
              null) {
            
        }
        java.lang.String template =
          ("import org.sunflow.core.*;\nimport org.sunflow.core.accel.*;" +
           "\nimport org.sunflow.core.camera.*;\nimport org.sunflow.core" +
           ".primitive.*;\nimport org.sunflow.core.shader.*;\nimport org" +
           ".sunflow.image.Color;\nimport org.sunflow.math.*;\n\npublic " +
           "void build() {\n  // your code goes here\n\n}\n");
        editorTextArea.
          setText(
            template);
    }
    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser fc =
          new javax.swing.JFileChooser(
          ".");
        fc.
          setFileFilter(
            new javax.swing.filechooser.FileFilter(
              ) {
                public java.lang.String getDescription() {
                    return "Scene File";
                }
                public boolean accept(java.io.File f) {
                    return f.
                      isDirectory(
                        ) ||
                      f.
                      getName(
                        ).
                      endsWith(
                        ".sc") ||
                      f.
                      getName(
                        ).
                      endsWith(
                        ".java");
                }
            });
        if (fc.
              showOpenDialog(
                SunflowGUI.this) ==
              javax.swing.JFileChooser.
                APPROVE_OPTION) {
            final java.lang.String f =
              fc.
              getSelectedFile(
                ).
              getAbsolutePath(
                );
            openFile(
              f);
        }
    }
    private void buildMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        new java.lang.Thread(
          ) {
            public void run() {
                setEnableInterface(
                  false);
                if (clearLogMenuItem.
                      isSelected(
                        ))
                    clearConsole(
                      );
                org.sunflow.system.Timer t =
                  new org.sunflow.system.Timer(
                  );
                t.
                  start(
                    );
                try {
                    api =
                      org.sunflow.SunflowAPI.
                        compile(
                          editorTextArea.
                            getText(
                              ));
                }
                catch (java.lang.NoClassDefFoundError e) {
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          GUI,
                        "Janino library not found. Please check command line.");
                    api =
                      null;
                }
                if (api !=
                      null) {
                    try {
                        if (currentFile !=
                              null) {
                            java.lang.String dir =
                              new java.io.File(
                              currentFile).
                              getAbsoluteFile(
                                ).
                              getParent(
                                );
                            api.
                              addIncludeSearchPath(
                                dir);
                            api.
                              addIncludeSearchPath(
                                dir);
                        }
                        api.
                          build(
                            );
                    }
                    catch (java.lang.Exception e) {
                        org.sunflow.system.UI.
                          printError(
                            org.sunflow.system.UI.Module.
                              GUI,
                            "Build terminated abnormally: %s",
                            e.
                              getMessage(
                                ));
                        for (java.lang.StackTraceElement elt
                              :
                              e.
                               getStackTrace(
                                 )) {
                            org.sunflow.system.UI.
                              printInfo(
                                org.sunflow.system.UI.Module.
                                  GUI,
                                "       at %s",
                                elt.
                                  toString(
                                    ));
                        }
                        e.
                          printStackTrace(
                            );
                    }
                    t.
                      end(
                        );
                    org.sunflow.system.UI.
                      printInfo(
                        org.sunflow.system.UI.Module.
                          GUI,
                        "Build time: %s",
                        t.
                          toString(
                            ));
                }
                setEnableInterface(
                  true);
            }
        }.
          start(
            );
    }
    private void clearConsole() { consoleTextArea.
                                    setText(
                                      null);
    }
    private void println(final java.lang.String s) {
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                public void run() {
                    consoleTextArea.
                      append(
                        s +
                        "\n");
                }
            });
    }
    private void setEnableInterface(boolean enabled) {
        newFileMenuItem.
          setEnabled(
            enabled);
        openFileMenuItem.
          setEnabled(
            enabled);
        saveMenuItem.
          setEnabled(
            enabled);
        saveAsMenuItem.
          setEnabled(
            enabled);
        sceneMenu.
          setEnabled(
            enabled);
        buildButton.
          setEnabled(
            enabled);
        renderButton.
          setEnabled(
            enabled);
        iprButton.
          setEnabled(
            enabled);
    }
    public void print(org.sunflow.system.UI.Module m,
                      org.sunflow.system.UI.PrintLevel level,
                      java.lang.String s) {
        if (level ==
              org.sunflow.system.UI.PrintLevel.
                ERROR)
            javax.swing.JOptionPane.
              showMessageDialog(
                SunflowGUI.this,
                s,
                java.lang.String.
                  format(
                    "Error - %s",
                    m.
                      name(
                        )),
                javax.swing.JOptionPane.
                  ERROR_MESSAGE);
        println(
          org.sunflow.system.UI.
            formatOutput(
              m,
              level,
              s));
    }
    public void taskStart(java.lang.String s,
                          int min,
                          int max) { currentTask =
                                       s;
                                     currentTaskLastP =
                                       -1;
                                     final int taskMin =
                                       min;
                                     final int taskMax =
                                       max;
                                     javax.swing.SwingUtilities.
                                       invokeLater(
                                         new java.lang.Runnable(
                                           ) {
                                             public void run() {
                                                 taskProgressBar.
                                                   setEnabled(
                                                     true);
                                                 taskCancelButton.
                                                   setEnabled(
                                                     true);
                                                 taskProgressBar.
                                                   setMinimum(
                                                     taskMin);
                                                 taskProgressBar.
                                                   setMaximum(
                                                     taskMax);
                                                 taskProgressBar.
                                                   setValue(
                                                     taskMin);
                                                 taskProgressBar.
                                                   setString(
                                                     currentTask);
                                             }
                                         });
    }
    public void taskUpdate(int current) {
        final int taskCurrent =
          current;
        final java.lang.String taskString =
          currentTask;
        javax.swing.SwingUtilities.
          invokeLater(
            new java.lang.Runnable(
              ) {
                public void run() {
                    taskProgressBar.
                      setValue(
                        taskCurrent);
                    int p =
                      (int)
                        (100.0 *
                           taskProgressBar.
                           getPercentComplete(
                             ));
                    if (p >
                          currentTaskLastP) {
                        taskProgressBar.
                          setString(
                            taskString +
                            " [" +
                            p +
                            "%]");
                        currentTaskLastP =
                          p;
                    }
                }
            });
    }
    public void taskStop() { javax.swing.SwingUtilities.
                               invokeLater(
                                 new java.lang.Runnable(
                                   ) {
                                     public void run() {
                                         taskProgressBar.
                                           setValue(
                                             taskProgressBar.
                                               getMinimum(
                                                 ));
                                         taskProgressBar.
                                           setString(
                                             "");
                                         taskProgressBar.
                                           setEnabled(
                                             false);
                                         taskCancelButton.
                                           setEnabled(
                                             false);
                                     }
                                 }); }
    private void renderMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        new java.lang.Thread(
          ) {
            public void run() {
                setEnableInterface(
                  false);
                if (clearLogMenuItem.
                      isSelected(
                        ))
                    clearConsole(
                      );
                if (api !=
                      null) {
                    api.
                      parameter(
                        "sampler",
                        "bucket");
                    api.
                      options(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS);
                    api.
                      render(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS,
                        imagePanel);
                }
                else
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          GUI,
                        "Nothing to render!");
                setEnableInterface(
                  true);
            }
        }.
          start(
            );
    }
    private void iprMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        new java.lang.Thread(
          ) {
            public void run() {
                setEnableInterface(
                  false);
                if (clearLogMenuItem.
                      isSelected(
                        ))
                    clearConsole(
                      );
                if (api !=
                      null) {
                    api.
                      parameter(
                        "sampler",
                        "ipr");
                    api.
                      options(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS);
                    api.
                      render(
                        org.sunflow.SunflowAPI.
                          DEFAULT_OPTIONS,
                        imagePanel);
                }
                else
                    org.sunflow.system.UI.
                      printError(
                        org.sunflow.system.UI.Module.
                          GUI,
                        "Nothing to IPR!");
                setEnableInterface(
                  true);
            }
        }.
          start(
            );
    }
    private void textureCacheClearMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        org.sunflow.core.TextureCache.
          flush(
            );
    }
    private void smallTrianglesMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        org.sunflow.core.primitive.TriangleMesh.
          setSmallTriangles(
            smallTrianglesMenuItem.
              isSelected(
                ));
    }
    private void saveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        javax.swing.JFileChooser fc =
          new javax.swing.JFileChooser(
          ".");
        fc.
          setFileFilter(
            new javax.swing.filechooser.FileFilter(
              ) {
                public java.lang.String getDescription() {
                    return "Scene File";
                }
                public boolean accept(java.io.File f) {
                    return f.
                      isDirectory(
                        ) ||
                      f.
                      getName(
                        ).
                      endsWith(
                        ".java");
                }
            });
        if (fc.
              showSaveDialog(
                SunflowGUI.this) ==
              javax.swing.JFileChooser.
                APPROVE_OPTION) {
            java.lang.String f =
              fc.
              getSelectedFile(
                ).
              getAbsolutePath(
                );
            if (!f.
                  endsWith(
                    ".java"))
                f +=
                  ".java";
            java.io.File file =
              new java.io.File(
              f);
            if (!file.
                  exists(
                    ) ||
                  javax.swing.JOptionPane.
                  showConfirmDialog(
                    SunflowGUI.this,
                    "This file already exists.\nOverwrite?",
                    "Warning",
                    javax.swing.JOptionPane.
                      YES_NO_OPTION) ==
                  javax.swing.JOptionPane.
                    YES_OPTION) {
                saveCurrentFile(
                  f);
            }
        }
    }
    private void saveCurrentFile(java.lang.String filename) {
        if (filename ==
              null) {
            saveAsMenuItemActionPerformed(
              null);
            return;
        }
        java.io.FileWriter file;
        try {
            file =
              new java.io.FileWriter(
                filename);
            file.
              write(
                editorTextArea.
                  getText(
                    ));
            file.
              close(
                );
            currentFile =
              filename;
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  GUI,
                "Saved current script to \"%s\"",
                filename);
        }
        catch (java.io.IOException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  GUI,
                "Unable to save: \"%s\"",
                filename);
            e.
              printStackTrace(
                );
        }
    }
    private void selectFrame(javax.swing.JInternalFrame frame) {
        try {
            frame.
              setSelected(
                true);
            frame.
              setIcon(
                false);
        }
        catch (java.beans.PropertyVetoException e) {
            e.
              printStackTrace(
                );
        }
    }
    private void tileWindowMenuItemActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (imagePanelFrame.
                  isIcon(
                    ))
                imagePanelFrame.
                  setIcon(
                    false);
            if (editorFrame.
                  isIcon(
                    ))
                editorFrame.
                  setIcon(
                    false);
            if (consoleFrame.
                  isIcon(
                    ))
                consoleFrame.
                  setIcon(
                    false);
            int width =
              desktop.
              getWidth(
                );
            int height =
              desktop.
              getHeight(
                );
            int widthLeft =
              width *
              7 /
              12;
            int widthRight =
              width -
              widthLeft;
            int pad =
              2;
            int pad2 =
              pad +
              pad;
            imagePanelFrame.
              reshape(
                pad,
                pad,
                widthLeft -
                  pad2,
                height -
                  pad2);
            editorFrame.
              reshape(
                pad +
                  widthLeft,
                pad,
                widthRight -
                  pad2,
                height /
                  2 -
                  pad2);
            consoleFrame.
              reshape(
                pad +
                  widthLeft,
                pad +
                  height /
                  2,
                widthRight -
                  pad2,
                height /
                  2 -
                  pad2);
        }
        catch (java.beans.PropertyVetoException e) {
            e.
              printStackTrace(
                );
        }
    }
    private void lowBatteryItemActionPerformed(java.awt.event.ActionEvent evt) {
        org.sunflow.BatteryContext.
          batteryMode =
          0;
    }
    private void midBatteryItemActionPerformed(java.awt.event.ActionEvent evt) {
        org.sunflow.BatteryContext.
          batteryMode =
          1;
    }
    private void highBatteryItemActionPerformed(java.awt.event.ActionEvent evt) {
        org.sunflow.BatteryContext.
          batteryMode =
          2;
    }
    private void openFile(java.lang.String filename) {
        if (filename.
              endsWith(
                ".java")) {
            java.lang.String code =
              "";
            java.io.FileReader file;
            try {
                file =
                  new java.io.FileReader(
                    filename);
                java.io.BufferedReader bf =
                  new java.io.BufferedReader(
                  file);
                while (true) {
                    java.lang.String line;
                    line =
                      bf.
                        readLine(
                          );
                    if (line ==
                          null)
                        break;
                    code +=
                      line;
                    code +=
                      "\n";
                }
                file.
                  close(
                    );
                editorTextArea.
                  setText(
                    code);
            }
            catch (java.io.FileNotFoundException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GUI,
                    "Unable to load: \"%s\"",
                    filename);
                return;
            }
            catch (java.io.IOException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GUI,
                    "Unable to load: \"%s\"",
                    filename);
                return;
            }
            currentFile =
              filename;
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  GUI,
                "Loaded script: \"%s\"",
                filename);
        }
        else
            if (filename.
                  endsWith(
                    ".sc")) {
                java.lang.String template =
                  ("import org.sunflow.core.*;\nimport org.sunflow.core.accel.*;" +
                   "\nimport org.sunflow.core.camera.*;\nimport org.sunflow.core" +
                   ".primitive.*;\nimport org.sunflow.core.shader.*;\nimport org" +
                   ".sunflow.image.Color;\nimport org.sunflow.math.*;\n\npublic " +
                   "void build() {\n  parse(\"") +
                filename.
                  replace(
                    "\\",
                    "\\\\") +
                "\");\n}\n";
                editorTextArea.
                  setText(
                    template);
                currentFile =
                  null;
                org.sunflow.system.UI.
                  printInfo(
                    org.sunflow.system.UI.Module.
                      GUI,
                    "Created template for \"%s\"",
                    filename);
            }
            else {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      GUI,
                    "Unknown file format selected");
                return;
            }
        editorTextArea.
          setCaretPosition(
            0);
        if (autoBuildMenuItem.
              isSelected(
                )) {
            buildMenuItemActionPerformed(
              null);
        }
    }
    private class SceneTransferHandler extends javax.swing.TransferHandler {
        public boolean importData(javax.swing.JComponent c,
                                  java.awt.datatransfer.Transferable t) {
            if (!sceneMenu.
                  isEnabled(
                    ))
                return false;
            if (!canImport(
                   c,
                   t.
                     getTransferDataFlavors(
                       ))) {
                return false;
            }
            try {
                java.util.List files =
                  (java.util.List)
                    t.
                    getTransferData(
                      java.awt.datatransfer.DataFlavor.
                        javaFileListFlavor);
                for (int i =
                       0;
                     i <
                       files.
                       size(
                         );
                     i++) {
                    final java.io.File file =
                      (java.io.File)
                        files.
                        get(
                          i);
                    java.lang.String filename =
                      file.
                      getAbsolutePath(
                        );
                    if (filename.
                          endsWith(
                            ".sc") ||
                          filename.
                          endsWith(
                            ".java")) {
                        openFile(
                          filename);
                        break;
                    }
                }
            }
            catch (java.lang.Exception exp) {
                exp.
                  printStackTrace(
                    );
            }
            return false;
        }
        public boolean canImport(javax.swing.JComponent c,
                                 java.awt.datatransfer.DataFlavor[] flavors) {
            for (int i =
                   0;
                 i <
                   flavors.
                     length;
                 i++) {
                if (flavors[i].
                      isFlavorJavaFileListType(
                        ))
                    return true;
            }
            return false;
        }
        public SceneTransferHandler() { super(
                                          );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "5El03/7B8Kmn5/Ssusb3O807292Ryb0AgtWdvXefTP0j2Fb+iyCqGEQNkvVM" +
           "tB0radY3D4JdTfvtKIpqPeveZw5xp+/K1qx5fqRxHeu/NrizvJR6MrpR+CyA" +
           "eKxN5q9KPCu2UWAqq1jh+0JQqBSiDtMkJ5YsOGN/hikqgWhhnw/pmUJlSTTD" +
           "TDVod6AisUJjr4krr6yFso9WrArlhAvHCiE/P8wFA1ycIhXrqSJr32bDEdBW" +
           "YnIJNYqQTxXCMhfsBZw+UcnwXWNFOH6HDXA3rJKwGuEVlU3EHKg1/x9QmwE7" +
           "53t3sJ1Q7bxP6PbcXHcv4duXCeS2ylza5ttJ6+qE2z1JzV9LbWBNi/fSIen0" +
           "1MZNe2/e+6y4uEoKnphgXGoAksT1ONsLLizIzeZVvqHzVt2ZqkU2LHsuzm7Z" +
           "uM3AhfyOOcd3kTM7sve5d46tPPfLyfKLgBU7UABDnO/ITeKMnoYmfEc0t1JD" +
           "EvMbZlfnt8ZXLU387V1+C8kFRz89gNTjb0fOjHy0mj/PlUHXQDIcXdaOq1uI" +
           "NGp4yn4dwxDM3k25HSzz1WZn2QsGtIa5zUzuuw/c0MaI0a2l1bhVOGqcGc+z" +
           "rQVA1Wld921wZlzVZERACrM+AMpQtE/X7dt/hc5jWMmfX2w8yz/ZcO5/ZlHH" +
           "UzgZAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "RteFA7tKWMszh2OJL/LH64+8uOZU9bYIXRfozUrPW08YFmoNT8OtdjScdszw" +
       "xNv5WQNoIM/7DDgOMAM4wJt1YHR51hSh1kSSTdwk03pJiTRnsMyjIse4tpBk" +
       "u1dWd875ThjI9low6FZMXo78TGYIyshZXMk5C0gif0OSMzAak3aVfq1QBZVD" +
       "lp4MGldzMdeQW0PeBappG/2yHFkYJptMNnmCUfPEX41sUYkCskNLrLNz7ulq" +
       "HW+G92U1zz/r/ug/H/Nmkhea0c8t6nzwgSr1zdTz7/steiudUL9A3HpyKjt8" +
       "//zfXn14/n/Q1TVVugvtEZpvgdWnOTLHj7zz8SsTZz9C230lad3UvPllu/mr" +
       "ckOLbSnUWvbOtFBvXNBMY7bv7DuLPavNtIbtGI01NLPfW+d5OZHcaAdWE/GE" +
       "fBCTAxAxwzI1shQrFKw361Zzdqkz3MwUQhlZSKfTRzYG/dFiikXSSnZJ7vWS" +
       "5HJoQSrB5Kkgya6J2kRO88lvwnFJiTpJYtBQU4pOXmZEVgSttei3sjJaK+3x" +
       "ZwC+97wyvf+C1rqnYHcvFJWoiSX3hkhigTPUTR2v2RLnWCj67r9cFqC86D94" +
       "ZXr/S2JBKCrpCfwJW83KMPiOIeJ/2ugyt9XknJJxjYSo60lyJUaN3GsEr4wO" +
       "8AiWk9KSHH/7Rou/NlCeeeiozOcL+BOJFuaP1H8tZeFWCUPkI2LkJogm+DdD" +
       "coq+O1oUXQj6vcD0fKF0ikSixSi6R0LR35HkLoxmhT5jyfn53mjxA+O66CdM" +
       "yU9K50ckKlH/Icm9IyS5j8y0zPkiwlFx/2hRcTrocZzpc7x0KkSiYlOppDo/" +
       "JeHjpyR5zFtRaWKD754eHy0qIFv0C6bPF6VTIRIVU3E2VfcXEiqeJ8mzGDW4" +
       "Gl5tkvAkOy7kWDk2CqzQ/QFaQcVKr0zvv4SVxWFWqiWinNJRb7mg313NKjQq" +
       "jjdBvJwOwreCQ+d4UwexmgQZ+wbm9rKE49dI8hLEYtTcOFqLvhYvl9blwEk1" +
       "46a6dFpFooVp3eO/X6LvbLZRtd+VUPI+Sd4irxEUdxBG/g5Py9ujRctpoNNM" +
       "ptvM0mkRiQrbICPjMwkZJ0jyEUbVhIwtdlLBfNsr+ta5XDYgYK5cxFRaVDob" +
       "IlGJsn+R3PuKJJ9jVOVZhWVzNBSdjl6uY74IdFjOdFlehIZ8xywULRLORMeL" +
       "uYjWkKQSo9nhSUTSeCY6ZrQIWgHatTMt20snSCRajKCpEoKmk6QeBh45M8Lk" +
       "7DSMFjvrQDW2EKoybxlVcXZEosXYmS9hZwFJGjE6XTgzX85V0Vnk5XK1BhRl" +
       "C2gq85bfFOdKJFqMqzMlXJEZLNHFGC0ovDpDTtSS0fRJbMVFZd56jeJEiUSL" +
       "EXWBhKiLSHIe+KTw3A85QeePFkFLQTs2h6IybwZGcYJEomKCaKQXXSchKEGS" +
       "1RjVEoJiwedDjpL20aJkGehzM9Pr5tIpEYmKg5tPqNrbJJRcSpLNGNW4Gtn6" +
       "yF9qlktH52jREQNdDjGdDpVOh0i0WBNKSujoI0kPRqfkL5mWN6Ndo+lnjjJN" +
       "j5ZOkki0GEl7JCSRi1ED/Ex4PoacoNRoEvQ40/Lx0gkSiRYj6CoJQWS6ZXQE" +
       "CArPAJETtHcU3zdXPsW0fKp0gkSixQi6SULQzSS5AaNGbs6JnKEbR4shGB9V" +
       "Ps3UfLp0hkSixbqquyQMfZ8kt8NYy3+jzHFx8K/BRSa0p6idXbsb3qeI9gkZ" +
       "70vCzNwSCRA0JQxkQhYI9+nB+wyYtm2yRGib4pjke6BIFLNt2VwHnV10j0Ky" +
       "H7PGtqCj3zR71Ak1l/7xF/v+jLyduaAoWhG//SX9ggxDbBL00r81/LMnG1EW" +
       "3h6wUydBKLZMskXgos8W1q144AeHaHXjNA8PKWEN3WHw3JJU8HfX61HXb7rm" +
       "/Fnf+eANb782utUe5KDl5m+LR4ziSIZsPke/ZRJz6cj4xpB9bLkbaxIwdHdp" +
       "/2N02ttfukc9enjdhitOnHOft7Gnaih795JSakA5b49RRmfuLmp8aX5ZY9cu" +
       "/HLSo+MX+J+y6z2jCVrVzMDqyaedCptQNoPb9dJtym5++ft7VzzzmwNjXwGy" +
       "d6AKBaPJO/J3HczYaQfN3pHI329tq+LQ7ThbF35/5MIlfZ+9ybb3o9/xZ4nz" +
       "96jdt78ef3Tw84vpdsZjIDbQMnQ7xFUj5mZNHXJCm7dNItNLFPLRm/LA6JuY" +
       "vUq2gcVoXv6+dfmb51ZD89SclVbaTNLnnUA1wRXvSXCzVKCVcQLBlZyWoJJk" +
       "Ow2wMYr2JNbbtr+t3+k2bQHJQkFlkjqoZ+kpOTv2/9zTQYZoXgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "6WJ9EktthZdCpc46hc5YHwC/r7HiBJ7F");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "AAA=");
}
