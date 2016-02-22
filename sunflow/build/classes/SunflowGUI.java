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
            double[] energyRuns =
              new double[11];
            for (int k =
                   0;
                 k <
                   11;
                 k++) {
                double[] before =
                  jrapl.EnergyCheckUtils.
                  getEnergyStats(
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
                double[] after =
                  jrapl.EnergyCheckUtils.
                  getEnergyStats(
                    );
                ent.runtime.ENT_Util.
                  writeModeFile(
                    java.lang.String.
                      format(
                        "ERun %d: %f %f %f\n",
                        k,
                        after[0] -
                          before[0],
                        after[1] -
                          before[1],
                        after[2] -
                          before[2]));
                energyRuns[k] =
                  after[2] -
                    before[2];
            }
            double energyTotal =
              0.0;
            for (int k =
                   1;
                 k <
                   11;
                 k++) {
                energyTotal +=
                  energyRuns[k];
            }
            ent.runtime.ENT_Util.
              writeModeFile(
                java.lang.String.
                  format(
                    "Energy: %f %f %f\n",
                    0.0,
                    0.0,
                    energyTotal /
                      10.0));
            ent.runtime.ENT_Util.
              closeModeFile(
                );
            jrapl.EnergyCheckUtils.
              DeallocProfile(
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
          1456098642000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("H4sIAAAAAAAAAK1Ye2wUxxmfO79t/AQD4WGMfSCZ0LuQhqbIlAAGw9EzuBhQ" +
           "Y1KOub053+K93WV3zj6bkpdU4VYqogkhpE38R0sKRSSgqFFbtVCqqCRR0kih" +
           "aZs0CvQRtbQUFZQ0qUrb9JuZ3dvH3RmlrSWP1zPffPM9f983c+oaqjAN1EZU" +
           "GqZjOjHD61Xajw2TJHsUbJrbYC4uPV6G39t1ZfOKIKocRA1pbPZJ2CS9MlGS" +
           "5iCaL6smxapEzM2EJNmOfoOYxBjBVNbUQdQqm9GMrsiSTPu0JGEEO7ARQ82Y" +
           "UkNOZCmJWgwomh8DSSJcksga/3J3DE2TNH3MIZ/tIu9xrTDKjHOWSVFTbA8e" +
           "wZEslZVITDZpd85At+uaMjakaDRMcjS8R1lumWBTbHmBCTrONH5w81C6iZtg" +
           "OlZVjXL1zK3E1JQRkoyhRmd2vUIy5l50PyqLoToXMUWhmH1oBA6NwKG2tg4V" +
           "SF9P1GymR+PqUJtTpS4xgSha6GWiYwNnLDb9XGbgUE0t3flm0LY9r63QskDF" +
           "x26PHH58V9NzZahxEDXK6gATRwIhKBwyCAYlmQQxzDXJJEkOomYVnD1ADBkr" +
           "8rjl6RZTHlIxzYL7bbOwyaxODH6mYyvwI+hmZCWqGXn1UjygrP8qUgoeAl1n" +
           "OroKDXvZPChYK4NgRgpD3FlbyodlNUnRAv+OvI6hzwIBbK3KEJrW8keVqxgm" +
           "UIsIEQWrQ5EBCD11CEgrNAhAg6I5JZkyW+tYGsZDJM4i0kfXL5aAqoYbgm2h" +
           "qNVPxjmBl+b4vOTyz7XNKw/uUzeqQRQAmZNEUpj8dbCpzbdpK0kRg0AeiI3T" +
           "lsSO4JlnJ4IIAXGrj1jQfO+LN1YvbTv/kqCZW4RmS2IPkWhcOpZoeH1eT9eK" +
           "MiZGta6ZMnO+R3OeZf3WSndOB4SZmefIFsP24vmtF+598CS5GkS1UVQpaUo2" +
           "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" +
           "fwDUgNycQhkAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456098642000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "6Y84HSMAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456098642000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456098642000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV9CbDr2Fmm3329pbvTW5LOQrrTSbpJdwxP8iqLzoIWy5Yt" +
       "W7Zky7KzdGRJlmTtmy0rNFmmoEOoChQkhDVDagJhIBCGmQCpmYRQ7AMFE2AY" +
       "hhkIMMzAEFKTsIQlLHNk+757r9/zfffe17lVOvaVzjn6vv/85///Y0m/PvK5" +
       "3K1hkMt7rrXSLDe6oibRlblVuRKtPDW80mIqPSkIVYWwpDAcgH1Pya/48Xu/" +
       "+KVv1e87yN02yT1Pchw3kiLDdUJODV1roSpM7t6jvXVLtcModx8zlxYSFEeG" +
       "BTFGGD3J5O461jTKPcocQoAABAhAgNYQIOyoFmj0XNWJbSJrITlR6Oe+PneJ" +
       "yd3myRm8KPfyk514UiDZ2256awaghzuy/wVAat04CXKPXOW+4XwN4fflofe+" +
       "/833/cTl3L2T3L2Gw2dwZAAiAieZ5O62VXuqBiGmKKoyyd3vqKrCq4EhWUa6" +
       "xj3JPRAamiNFcaBeFVK2M/bUYH3OI8ndLWfcgliO3OAqvZmhWsrhf7fOLEkD" +
       "XB884rphSGX7AcE7DQAsmEmyetjkFtNwlCj3st0WVzk+2gYVQNPbbTXS3aun" +
       "usWRwI7cA5uxsyRHg/goMBwNVL3VjcFZotxL9naaydqTZFPS1Kei3It26/U2" +
       "h0Ct56wFkTWJci/YrbbuCYzSS3ZG6dj4fK77mve81Wk6B2vMiipbGf47QKOH" +
       "dxpx6kwNVEdWNw3vfjXzHdKDn3jXQS4HKr9gp/Kmzk993Re+9qse/tQvb+p8" +
       "xXXqsNO5KkdPyR+a3vPplxJPoJczGHd4bmhkg3+C+Vr9e9sjTyYemHkPXu0x" +
       "O3jl8OCnuF8cv/2H1c8e5O6kc7fJrhXbQI/ul13bMyw1aKiOGkiRqtC556iO" +
       "QqyP07nbwXfGcNTNXnY2C9WIzt1irXfd5q7/ByKagS4yEd0OvhvOzD387kmR" +
       "vv6eeLlc7naw5dpga+U2f+vPKPckpLu2Ckmy5BiOC/UCN+MfQqoTTYFsdSiM" +
       "nZnlLqEwkCF+870xpK9kSuTdXPMkQ3ff8tIlILiX7k5bC2h807UUNXhKfm+M" +
       "17/wY0/96sFVNd7yinJ3HvWZu3Rp3dXzs7438gfSM8E8BBbq7if4N7Xe8q5X" +
       "XAYD7y1vAdSzqtB+Q0kczVx6bZ9koD65T33n8h3C2+CD3MFJi5fhAbvuzJr3" +
       "Mjt11R49uqvp1+v33mf+7Isf/Y6n3SOdP2FCt1Px2pbZVHrFruQCV1YVYJyO" +
       "un/1I9LHnvrE048e5G4B8xPYpEgCOgSm+8O75zgxpZ48NE8Zl1sB4Zkb2JKV" +
       "HTq0KXdGeuAuj/ash/Se9ff7gYzvynTsBUDWf7zRuc1ndvR5XlY+f6MC2aDt" +
       "sFibv9fy3vf97q//39Ja3IeW8t5jvodXoyePzc6ss3vX8/D+Ix0YBKoK6v3+" +
       "d/a+/X2fe+YNawUANV55vRM+mpUEmJVgCIGYv+GX/f/+mT/40G8fHClNBNxT" +
       "PLUMOblKMtufu/MUkuBsX3mEB8xuC0yRTGseHTq2qxgzQ5paaqal/3jvY4WP" +
       "/cV77tvogQX2HKrRV924g6P9L8Zzb//VN//tw+tuLsmZdzmS2VG1jcl63lHP" +
       "WBBIqwxH8o7ffOi7fkn6PmD8gMEJjVRd25DcWga59aBBa/6vXpdXdo4VsuJl" +
       "4XHlPzm/jkUBT8nf+tuff67w+U9+YY32ZBhxfKw7kvfkRr2y4pEEdP/C3Zne" +
       "lEId1Ct/qvvG+6xPfQn0OAE9ysB3hmwATElyQjO2tW+9/fd+9ucefMunL+cO" +
       "qNydlisplLSeZLnnAO1WQx1YocR7/dduRnd5ByjuW1PNXUN+oxQvWv/3OgDw" +
       "if32hcqigKMp+qJ/YK3pO//4764RwtqyXMf57bSfQB/53pcQr/vsuv3RFM9a" +
       "P5xca15BxHTUtvjD9t8cvOK2XzjI3T7J3SdvwzFBsuJs4kxACBIexmggZDtx" +
       "/GQ4sfGdT141YS/dNS/HTrtrXI7MOvie1c6+37ljT16cSbm4dWSHDu2EPVl7" +
       "gM0YZ5Cu0CB60tTggT/+/g/97TueqR1kCn3rIoMOpHLfUb1unEV93/iR9z10" +
       "13v/8JvXEz6b2Vmnr1+f/uXr8tGseNV6fC9Hudu9wFgAvw2MQriOIiPAyXAk" +
       "a2sc/gX8XQLbP2dbhjTbsXG7DxBb3//IVefvAXf2XLJOYUNm8NSIJgfN0zWo" +
       "Fxg2MHuLbfgDPf3AZ8zv/bMf3YQ2u+qyU1l913vf/S9X3vPeg2MB5SuviemO" +
       "t9kElevxeG5W0NkEfPlpZ1m3oP70o0//xx96+pkNqgdOhkd1EP3/6O/8069d" +
       "+c4//JXr+PbLIPTd+IesLGbF124kW9k7G7/mWl1htrrCXEdXsi8YGMv1fmHP" +
       "QGdfqaxoZEVzLQM6yt1zOFbNOt1oDrK97A7c0dnh3p3t/QqwdbZwO9fAza2/" +
       "vPn6KC+tUR5iu33ekxzVKq1rvQCo2zreuhIuQbh/pbU+tgP1qXNCfQxs3S3U" +
       "7h6o2lmg3j3n5QD4pAxU4RDvC0/gPaqwA1o/J+hXgo3dgmb3gPbOBFpNjKgD" +
       "Vq90pNqHoF9wAvTh0R3I/gUg97aQe3sgr84C+a45r27jmuIh4gdPivnw+A7k" +
       "9AJa3N9C7u+B/M5zaPE6nJB3QP2rc4J6Odi4LShuD6hvOtPQg/gYhBJ4HEVb" +
       "9wwE+bwTgtwc2wH87gsA5reA+T2Av+0sgO+cH6piOdsT7+D69gso5GCLa7AH" +
       "13edUyHXI/z1O8C++5zAHgfbcAtsuAfY958F2P0zIxoB3+Uuj8/hXbl98Jzw" +
       "ngCbsIUn7IH34bPAewC4TvXG+H7oAuM62uIb7cH3Y+cc18r1xvWj5wT2VWAT" +
       "t8DEPcA+dhZgL8hCV/cssvvJc0LMg228hTjeA/E/nQXi81XFAHK7McJPnBPh" +
       "q8E22SKc7EH4c2dB+DzDlrQziPDnzwnwIbC9YQvwDXsA/uczmbvlVWyH1vn+" +
       "axzzDthfvYCpeeMW7Bv3gP2tMzmTrUpSAQh8D+G+5ATcbAUTgDXFusoO7t8+" +
       "J+5Xge1NW9xv2oP7f55pjm/09Cqm390B9vsXmEBv3gJ78x5g/+sswO5dq+c6" +
       "bNgL7k8u4Imf2oJ7ag+4Pz9TPKOooRm53uFAv+jEQJObg9cJcz97TsAVsL1l" +
       "C/gtewD/1VkAPxjakmUNAgMskS013A14HzqBn9BV2cTdZE/g+9fnJAGDTdqS" +
       "kPaQ+MezkHhxdmEnDlRCknWVsFQpOM1u/dMF3OZ0C3N6fZiXLp/Tba7jtB23" +
       "eemWC9goeQtM3gPszjOFQ4EaqtHEde1T5HbprnPCeynYlC08ZQ+8+88C7znr" +
       "GX9o1H9jB9YD54T1CrCpW1jqHlgvOpMbOjJEV6eLG2hXttdDroSrEEjyCn21" +
       "1g7wF19g0TXbAp/tAf7yMxmpzaKrmv27s+i69IpzgoLApm1BaXtAPX4WUPfJ" +
       "2bxlXO24Cv7dDronLiAyfYtO34MOOofIKtcTGXyB31WMLShjD6jqmUQWSaFJ" +
       "ZD+1Wkfr0ffsoEMusIiZb9HN96B77Zn8dIauF7gaMC4hvr1+f41LPFZhB/jr" +
       "LmCmzS1wcw9w6pxmuuRfx0w3LuDmrC0waw+wzpnMtBRHLh4blnLaHOlewB7a" +
       "W3j2HniDM8nN8E7zu5eGF5gnzhaYswfYG84C7J7N7zmnYXvjObE9CjZ3i83d" +
       "g216FmzPne6O5y40+QJu19tC8/ZAM87kdkNZdfa63fkFRtPfwvL3wDrTD7P3" +
       "bBYmAxDyYYEqHZqVkz/NHh7dAX3en2a/EmzBFnSwB/SZfpq9d7sKPIbr0u5A" +
       "n/dH2GypF27BhXvAvf0s4B5Yu15ig3C/J3nHBZxvtMUX7cH3zDmc7zpm3nW+" +
       "77qAGsZbUPEeUO85C6jjFzXWy4rd8O5bzonsYbAttsgWe5C972zhshfsH8Xv" +
       "OCesR7I6W1jLPbC+90zuYW3p9gP7vguMZLIFluwB9m/OZFBCaaFi4Wk2+EMX" +
       "iEVWW2yrPdh++ExalmE7DdmPXMBopFtk6R5k/+5MwafrqQ5lWKei+4kL2Nu3" +
       "btG9dQ+6nz6TvXXU5Y3AffwC9uzrtuC+bg+4nzkLuDtmW2TZ/7t+9VPnRPUy" +
       "sD29RfX0HlS/eCazsb6IBOLwq5don3/Nj6rXRum/dAEr97Yt3LftgfsbZzMn" +
       "UhSpwWqfHP/LBczJ27fA3r4H2O+cyZyAtT++wbZP8/7bBbC9Y4vtHXuw/f6Z" +
       "sNmGcgNsf3CBKfvOLbZ37sH2J2easrqh6TcA978vMDm+YQvuG/aA++yZtE2O" +
       "A7CKiDKbcjg9jt1btLnLegfsX1wA7DduwX7jHrB/fR6wA7AAzxp9fgfY31zg" +
       "1/FntsCe2QPsS2fyGceAMVIY9bL9O3fUXPrHC5jld23Rvev66A4OzoLusuQZ" +
       "h2P74PEf8rY3IGM9+iTUg8s3hLruOrl0KcrdWryCXIGzVnddH8z6JqTHs+Lk" +
       "TUgvnFvyo4f3kglqEBqu8+jcQq4zstktW2cEFAa5e470l3Ed7clv/pNv/bVv" +
       "eeVnDnKXWoc30GW1cSAn/rbX3ZEN1sED58P+kgw778aBrGbj3VnfyaoqGfx1" +
       "F8wx0L0od4vl7s6ic1CKHrqvWQ5p7PCPEWRC7MvJxIxT2SgyXWc0FlOtn0pF" +
       "sqdjy3Bqj1oWafm1ZFyIixWsM2EYpTqyWtOeUooQ3fMmJK4typgyampho77k" +
       "a+x4affITn0g1Ws4gzF0o07K1rReGus1GgtruDQqlxvptExh1EJaVOPAq058" +
       "r2GPizUnUhrOTBQhqDSDSqJYEJQEafRgbC72ZyPJ4BaJ2S5W5nzUKbXH5cCb" +
       "uF1uICJjHBFVX/d7zKyIolMFrtfnalIvQ+5QqRb9uOu1xUGHnxpgEeeFsWAm" +
       "gowq3sht0RFpS35qkkQ0jsKk24W7hTE8n8CCrATBmGt07GTkkIYvDPAiypaH" +
       "BbsdYvTKTpZUqw6LfKFDQ1O3Ou9InkUuxUmrqFjTWqHad2gbK8AxNxcTR/Yx" +
       "2BsQcVQfFgol2WlO+7NuuNIdt0ukii8pqzJcmBNtShuIlRa5lFZNP4XQmifl" +
       "G2aAq50hzAzTrgzqBvawI9Fm2deQOJgTsMeEjDguGrLACxZnz/XAWESYPey6" +
       "FF9CXY2qYjO/YnuTdkSlMpXn+W5k9UmiynBLejo12nVrNMAXFEkIw3FjjFD9" +
       "STApSiEqpZ3OrFnMD+EmWSwuVJ5v+/OIi0bVYj3VfK1DaB7eoQsTRrFjttjC" +
       "W5Kr9wR7QayKqdAUlgnaLS0GioSo0sot4xI088qiPOjaUr80bIgdCsG7sWzR" +
       "btQqdlWyNHTRoMb1xlOeQCYs2UgLDJW0EJfFrYGLySV3WCNDexhVF/bS7kwW" +
       "GN/gwinjDjs06fq+Ws+3q6xfogYa7gep2OH6abdqKw6Ghom6mgckhnHFjqdp" +
       "TEtIp0bkL9CGpyQEW5k1Sipd0wq23sI5kpCWDXXekqmpHbZRT0pLNbRR9QbK" +
       "TJLKRbqqdTqEDBd4suzDhOvoPcnvCe5cmxaWeEfurNC8njKJ0e9wOkGmOFFN" +
       "rTywE3AFuEUyn2/kaz2ql1YoZ7YQugN5olS95kI2RnYkr/J0XdeEKBb9Cjtq" +
       "Mm21ENAwKg2Rab1Rtyema5LJAtVrcqnnzCbRTAmaMNef9FddgYDnVr8P+dYo" +
       "8trw1A667Q4Yh6XgGroJxtRvCz03rw9nGBJ4saSUFHRQzgdlTvO7eSMyuSna" +
       "K5BDDB72DSPQoyJSHPUqi1GNQtHmTOI0o6tpkUJEslTpFeezlPKnMZg5lj9w" +
       "Dd+eWl53Oq5QSFOd0mwLxhDQ/whpI2QjXPJTcTgBk13JB91wCOZxbwKlUNKt" +
       "10uzgAhJ2pgmljLF0iQfjYZmt60wvYkuRTFjaoUihAorIgYKQVR7bbeeDAVT" +
       "Ylh3NERm9R7SE8jemMPYxiTOJ0Kg6KsxNR6K02V+pOVNs1pN+hqKSQI1hpaO" +
       "5JHoqFsSS1JjGc8MiVyxbW8gtBKexJnZqJKoBp74vWokjxFgT/qagYar0KgX" +
       "pUao8FG/XyeppjnxheEIY6V+vjJX6t6IECtI3/ZYMzWkSm3Um0e1Stycpd2R" +
       "0hwSfdmjnXadw2dGU5sSUnFS7waYUKvUKsJ0MctDAz2PjMdLUejigwIkj32u" +
       "wow7dAQVB0sU2LWaLftzcQiFkgQGuTxeGrqwVMt6H52u2CHOuajR8UNpSJBs" +
       "NXHanGHW5XxSGZVTpN7Q0sWQKC48pNDDGMmjo4mGIYvGSICLtUV+4HGt2DTT" +
       "1aIlIo3RsD5HXTFCo+IC6lWh1KfgfK2Bsn4kTCNlKRcmGD0WBVjBuQaiR3q1" +
       "65ksVGDRKI6h4hxSYjeF22xxZg67HgFTfbq1qLe1/DSYIb1gbhdrssqbfJ60" +
       "G9RcFEiuOFA6E1rWUYF3l/WpJDdVAtMaAhEYigxPSQbvQUNVVM1il2onkOWi" +
       "k3xj3kQrchmycUxUat2C149pUoN8h4GZEXAclUmPL9oDYtgdh/jE7BSZMGZJ" +
       "0wplLjENtttCxEqad4RaoMBsTdfnXjUIC43FuF/pk5yFSPWiUysOOCVNa+X5" +
       "iluWipBDonwclNG2VVowfKvYAf6JMfmxWyz1eq1ZpATUdDEB85d3WtVG2Zgl" +
       "y5FdKC8m+CIUm4VCQR0nKVQ3g1DHW4LEgsnRr9QXpQHdKczjutRVZzN/Ygwi" +
       "lqMoE1hSmCFGydBvCCQNNxB0Kvc0Q5ZmC4NHViW2oOF8Hy5Q6nDslFiyTi7n" +
       "UDWamtN+0hIXpXQ1QxXW4ZZFtM8gLNrxJ3x+NOZXcJezZtJMK3solEBsHlHn" +
       "UIlsul2ZSBOh2YErcU2fBXO1gk5LRbWf2t1xyarilaQ2QdkkrkqwuOjjVr9G" +
       "EB4V86xa7CXEEEMtCl3NoFbaCipMh+u23UFBMsIF4k06Qtu0nQnRrJUKLNLs" +
       "e0sYJSG1tOhUKHk10QZgbEaTidTz+hTCIbVW4LQQhJJR0hcWnRYVtMXSCEr6" +
       "aLvV9ViFw6nWnGR8cTHxBsDVl+alVVGBoEpdaKGctuxXO3h7AMQujj3YqNYg" +
       "ZbGAfbcLxV4jr+KtJt+uJ/6i3LFDMLaCM6Qkejyf0kpTnjSXnRZtlYDjUwzT" +
       "Lge4LjGtetgfz4VifmyLjOfozUJlOq65iFAeSdMuXYr8UVm0LQ0lOKqgNYcN" +
       "ChGjIVaDI6Y0jxXbU/t8bYb3YgnxvFotRMQqmcQuDZd1OB8JVrdLDoqjcYGa" +
       "92d5CdJFPFLECtHWVv3iYlgQxZXjFTtpV2ELgH8PYRsK8Pl5pAsFC1WtYanW" +
       "VGIm6BbLLNYV05k662LMMkLK4+aEpdLCNNHDuQpM1YSIcKXidYiKMM6rFVIt" +
       "VZJSBUGbvl+VG2gJB4PdXMxLUKkI3EsZ6k3yjp9MhSJn9ICNWA1wKLR6BFLr" +
       "JxIUl3wRrfBUAW6lYq0jSFxnJihtYyUS1ogY2vmAVS0HjwnWbXSWcM2ml20v" +
       "bCI1PFjUrWrPdEYqjYwZbCUEU0to18pyd1IF1rk+K3dwTg3Q3pCA6DSV+ClB" +
       "tpJ5UuhLfcItUXlRMFAaeDOlr1bi8ijlZ5DddWFdqc6IaDL2xFY0r1dpYIqG" +
       "JW+8kpa61W/xZq8fMmw3FIfzJuumDd5tO30TZjV2aRKw3C+gSeTMqYbTazLz" +
       "UWdWCvDeRK4qFln3Voxo8F14YiiI5JIMz+CxgpXGAkPrBEZOaorAKW7SqCIF" +
       "smNVNa40MyNXN7UxEjE8Wyh6dtudTlrJajmGGZpc1LxJTSi0hDmXOARMSKsy" +
       "P/IpHvfnvleKGvGixCzaXRvX841ZJU1df8pXtXkjMViyTweIh0v0hGELtEFV" +
       "mDzZ7FRIDkQvpFTtDrrdBiZXEW+gU3CMgQDOJ8jYXlEdKSwuBXi+hDhkUJpP" +
       "SV3WtFJE1kfIkp6A+hLtkQ2/xNoIOmqtKmgoF9odi23KzSE61rWej1Ftj2bj" +
       "gVwghbgyxfIjYjDq5JtSwnBR3SZRn+ODjENRLyvTcjPWBqNxcyCUFb0W1ReU" +
       "HJPj1JmElNGs6Ry/4nV73GSNRBrLBsR06no0B6qz5PtQwWyP+L4iu5qV51LD" +
       "5tsJ4+JBG2WLwpgsqLw1Mgd9uDXq9ydNeKAv8hbfHaTlqd+pTgsdrefNPAnw" +
       "142qq5lKkYA7eZPnXHaGF2RnqGgetlgt");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "9yNvAAA=");
}
