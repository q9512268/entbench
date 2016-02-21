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
          1450193822000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "VyfmKMBjTr9rvWBkvBqGRq4PVKAhpvQlxc3Zk9EpN8Dk8/O/v/bk9LvcDYXb" +
           "LbSO8z/L+Pg5NqwUXsoeV+XyquF7Z5VQjZemgRbPVBnwqubEgaPTqYEnbxH5" +
           "u9mbbXugmHzql/9+LXz8d68USQuVVmXnXBhk93mQvZ9XTA4y1T5485wYzaUL" +
           "QZ1RaZsBtlfMDNv+C1468OfW7etGd38GxF7i05Cf5Pf6z7yy+UbpoSAv+gRY" +
           "FxSL3kNdbl3BpQaB6lZlYrGZOu7uHXmbzme2Wgq2/NCy6Yd+dxfQWtxBwBB6" +
           "Ngl9kuMkzEtRfQmCvhgPWtZj/xcAqvDCIWyOQy0b3sKQT1OJ1U/Acgf3cTxO" +
           "wykMyrVqgbBdFDDI4gwPlUCSnWwYoFCNA3GDbgJC3qqAtXyD2aQJuV3OQEYY" +
           "s4rSW+O7pUOh+PvCYW8ockDsazkV+cbQr/a8xv2gmjlaXvsuJ9tgjLjyWCMb" +
           "bmJBs7xEi+flJzLVfHHv45eeEvz4K2rfZnLo6Nc/CR8+KoJJtB2dBZW/+4xo" +
           "PXzcLS11Cz/R+8ezUz88NXUwaKl7M+S6pKYpBKt5cwTyxdhcrxYFr5u+1vCj" +
           "I81lvVBDRFF1VpX3ZUk05fXrKjObdKnV6VQcL7e4ZpmUosAK3QK9O9kQF89d" +
           "/xu6son1fPpub+S0I1TRKCiI3xkihw3bCmJkxqPFY4T9/aL31Ufe83iaFdrb" +
           "Oev8j83v/OFZ4RbF/NrXbJ06WS29kzn/vm2xRJ7RCONrTSkZgZ1lMzusi6vp" +
           "73a+fu9053s8NVbLJmAsRECR9tF15uqZi5cv1C1+mteS5SyQLGt7++7CttrT" +
           "LXOZGtiQy9k40l4cRxgWQO02ZnX4Xldd5Mku/FWSA9Sn37zzFye/eWxcKL1E" +
           "DPvOLfh4QEke+P0/CwoVnjOKhLXv/HDkzOOt3esu8/NOuc1Od+YK2y7QunP2" +
           "1tOZvwc7Kn8WRFXDqFGyXt0MYSXLKt1h0Ktpv8+JoTrPuvfVg+izu/IZapEf" +
           "V1zX+gt9d0yXU0/8NgmbBRD3tQeK5yAeFYMUiMoqVvi5myAtKUQdoaN8M7bA" +
           "i/0A42XgLexxvwUHRZKQKF+ZaFCyQP5hacVeE42mrIXzL5JYzilwF44Vgn9+" +
           "mQsGODsl8tOxEmvH2fAwSCsxvoQYJbZ/WyCXC9ICTmW3R7BGS5yfZoNGwbGw" +
           "GuXZkk3sdmBU/+wwmgMdFuvkbQXXOh2/bs8tdFcFvnO5QGEpy3lr+TTeXJVq" +
           "pydg+dtJGzSz4v1kQjo7vWXr/mt3PCnaSEnBk5OMyiyAG9Gs5qu6pTNSs2lV" +
           "9i2/Xv9MzTIbcj1trJs3rjIwGO/4Wn1tlRnKd1dvn1j74s8PVV4AHNiBAhh8" +
           "eEdhgOb0LBTJO2KFORcClPd7Xcu/NbFuVfqv7/AmoRD4/PsTUs3HhyeXmoFw" +
           "ENVEUQXkf5LjyLFpQt1GpDHDk8Ark1pWzeN2PUMLzN5acq1YyqzLz7K3C1Dy" +
           "FRYphW9coHsaJ8ZGRt1KEZ4aOKvr7lWuVVnAAtMygEIi1q/rds8d4lrXde6w" +
           "z/NY+S+zJC1edhgAAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1450193822000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "z3w7L3n/H0g4/Zr5IgAA");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1450193822000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1450193822000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "GSIgJ1MNbq2alRRPiw2sqJUcBZfhRmdp");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "bBS7kimHUIONpHBip8tGiZqVlyV6BFYbUJXmEm0+raAgsKDL1ZiH6G4UN5or" +
       "RivqfdgmCbM1CGzJ1ab6dK47UrHH4l3OyPt1asC1E2FVq3NLGUf0adryxoKe" +
       "estJMgrpljx2R7NKVUjMrlsU2nxxGsHisDBJEpnXBJenwIplPPUSdxzHpsu7" +
       "BT0J+qVl0hrIPqUm0XJl1NPuMtVXRYiDOimaUB0UrMVbr31tdrn10bNdbn1w" +
       "fan4auK4c1wkTk+4UP7kYUKk9d8duZ30Y0cuvK9rvmibhWt7Tf2x6zwcMwrV" +
       "AD9IiZflG3l0Xyq5da6RD73zvR9Q6B8oXtymIWKi3HMi1/tqS022D+Fszvli" +
       "0NOr9+dV6a0z6R2mx/mld/75S7jX6W85Q9Kvl+3g3O3y3/Y+8ivYV8rfdjF3" +
       "6WqynGty/B1v9PTxFDl3B2oUBw53LFHOo1eH4KFM4l8Ntndvh+Ddu/c+HA77" +
       "NeN58VCBNrqzrnCY6unCkZHbuUZ/p+S6lio6WbuLtZ12R1JEXXw6K4pR7vY4" +
       "FDX1upf7E9dQDu+mKN3oSv/RM2Q7Ll4+Lo3sCeif3ErjJ78M0ghyT+zXqXVm" +
       "rU3qnQ/84Ct//W0feOUfrZNT3WWEYzFoBdp18iQeafP5j3zms7/53Ed/bJ3A" +
       "7TZJDDeDvptg8tr8kcfSQq7h33tVKs/PhPCSDPtWKuvPKHfl2tREX/OYH4uh" +
       "4cdupD65yX/22Cbj0WPrfEePbW5xesObHuvRMHKl3+oh7GOvfcxRF9sjbxVt" +
       "6Zk3XL58+U1PP+V56drwXFefsvs1LlIHd+bQNxqSq8btDkt1tE0OxOyWoYuk" +
       "l17t/+Km0YGled7hnS0dy3XULHfasZsaLxvu5atpQMHB9HpIL17eIF2fbAMz" +
       "K564noocVfw3nnDszVnBg0khZ7g2NE6oLqabz+4JdbI74i92wGyyRSO7sfri" +
       "aw+nFHwTU+rerfJc+NxWdz53hil19M6qE7DbJxzLMl9e1IHBMRwjwkb4DjXj" +
       "ZqmBdpc+tmm7+bx5aheOO7z1U/6XxQWwFonqRJdb65x8SPZ9zXB5AvtnsiKK" +
       "ci/duZF508cA2AA3sFVlRyjxzQoly5T1ya1QPnlLhZKdbLWm9uwJtL8pK94J" +
       "XOXu3eUn875hqqAb8X4d4PvpLe9Pf5l4f/sJvN+XFe+Jco8cexzsZNI3fMDk" +
       "RqRfBsh+cUv6i7d+cv/rE459MCu+O8uOceTRox1+33Oz/J4EvP5hy+8fbvWg" +
       "Xvj8msiPnEDyR7PiBzdJBJ3I2jXOH75ZfpVc7raLm7abz1uqtPU1h586gd/H" +
       "s+InotxDoRohTuZHr4byO1T//U1QXWeYfRpQvG9L9b6zUn3yulQvbZZSB8b6" +
       "keutTvDHe64SHwYP113C4I8PsvGlsjXIoWL83AmC+5Ws+CSIAtaKsSOrn7lZ" +
       "WVWBjJ6/ldXzb6ms/IPV5PqebXrN5bdO4Plfs+LXszWaGJpsJAa7XH/jZrm+" +
       "CnB8Ysv1iVvD9XAKbBl+5gSGf5QVvxeBFSJgOPIUEErvUPwfN0sRhGC3VbYU" +
       "K7eG4lEGnz3h2Oey4v9Eubs24+d6O9z+9GYt2OsBp9dvub3+rNxO6Xb/9gSC" +
       "f58VfxnlHj3+hPjJfvevbpb1awDbbcLH265J+HhrWF+6tJ/1pduzav8M4tMj" +
       "D+yfTPlfbpYyAahuU/3cdk2qn1tE+f4TKD+YFXdHuSf3Zgo6UQCXbpj75kYC" +
       "wADxbdaZ267JOnOLBPAVJwjg0ax4OMo9cf18Tyezf+GtmOfblCe3XZPy5Bax" +
       "f9UJ7J/KileAeX78Ud+TWb/yZlkXAdvto3G3XfNo3M2y3oQZl8onsM6y1Vy6" +
       "HOXuz1h3Dh9g2+EJ3SzPEuD3/i3P999qnrnfXXN5/Qk8W1nxNVHunlDN8t4f" +
       "ZIU7yvHpm+XYAdw+uOX4wS+TBpMncOxlBRrlXn5tatCTtfiG2WpOM3c/vmX+" +
       "8S8T88kJzPmsGIK5e/y52pNZs7eC9Se2rD/xZWItn8A6U+BLbwasjz+xezLr" +
       "G2b4PsVvYrf97Jb1z36ZWLsnsPazYh7lXrrzLPDJtM2bpf1qQPcXtrR/4VbT" +
       "3hrqt55AO/ux71IC4uyDX712CC7OQjA99soc72oqyuMJ4tdGMt38VPmiI6LZ" +
       "XCLcyal379UT7vy2uXn4Ofa8LIXXRAwc0He4r2m0fao0DHKVG741JHs1mbp9" +
       "BcX6MskV+d57+L/8+Wf+Prd5jwDoan2i3RfSrK8EZdc88I2sNp9HBzR7Ncz1" +
       "37XCGllQFLlO9oaUV/+/px54zYe/5/3r092pbvBkPbx2/VKV+pkoHLxd44rc" +
       "Y97RfOTdf/p762uNd61ftQFqrPu99rUY2eC/J81ePrG+WLHRpoNBvzpsR191" +
       "k4FZv1rt4LpkvHm52hX5ox8g+m/9Qu0HNq/akS1xtcp6uQuQ27z1ZyvOo+98" +
       "2O3toK87uk996b4ff84TB9dh79sozeFUOYLtZdeXNWJ70fpNNKuffuF/eM2H" +
       "P/AH6zdy/H9zyHqs824AAA==");
}
