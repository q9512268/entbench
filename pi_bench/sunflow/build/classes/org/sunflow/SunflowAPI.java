package org.sunflow;
public class SunflowAPI {
    public static final java.lang.String VERSION = "0.07.2";
    public static final java.lang.String DEFAULT_OPTIONS = "::options";
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.renderer.BucketRenderer bucketRenderer;
    private org.sunflow.core.renderer.ProgressiveRenderer progressiveRenderer;
    private org.sunflow.system.SearchPath includeSearchPath;
    private org.sunflow.system.SearchPath textureSearchPath;
    private org.sunflow.core.ParameterList parameterList;
    private org.sunflow.RenderObjectMap renderObjects;
    private int currentFrame;
    public static void runSystemCheck() { final long RECOMMENDED_MAX_SIZE =
                                            800;
                                          long maxMb = java.lang.Runtime.
                                            getRuntime(
                                              ).
                                            maxMemory(
                                              ) /
                                            1048576;
                                          if (maxMb < RECOMMENDED_MAX_SIZE)
                                              org.sunflow.system.UI.
                                                printError(
                                                  org.sunflow.system.UI.Module.
                                                    API,
                                                  ("JVM available memory is below %d MB (found %d MB only).\nPle" +
                                                   "ase make sure you launched the program with the -Xmx command" +
                                                   " line options."),
                                                  RECOMMENDED_MAX_SIZE,
                                                  maxMb);
                                          java.lang.String compiler =
                                            java.lang.System.
                                            getProperty(
                                              "java.vm.name");
                                          if (compiler ==
                                                null ||
                                                !(compiler.
                                                    contains(
                                                      "HotSpot") &&
                                                    compiler.
                                                    contains(
                                                      "Server")))
                                              org.sunflow.system.UI.
                                                printError(
                                                  org.sunflow.system.UI.Module.
                                                    API,
                                                  ("You do not appear to be running Sun\'s server JVM\nPerforman" +
                                                   "ce may suffer"));
                                          org.sunflow.system.UI.
                                            printDetailed(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "Java environment settings:");
                                          org.sunflow.system.UI.
                                            printDetailed(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "  * Max memory available : %d MB",
                                              maxMb);
                                          org.sunflow.system.UI.
                                            printDetailed(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "  * Virtual machine name : %s",
                                              compiler ==
                                                null
                                                ? "<unknown"
                                                : compiler);
                                          org.sunflow.system.UI.
                                            printDetailed(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "  * Operating system     : %s",
                                              java.lang.System.
                                                getProperty(
                                                  "os.name"));
                                          org.sunflow.system.UI.
                                            printDetailed(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "  * CPU architecture     : %s",
                                              java.lang.System.
                                                getProperty(
                                                  "os.arch"));
    }
    public SunflowAPI() { super();
                          reset(); }
    public final void reset() { scene = (org.sunflow.core.Scene)
                                          ent.runtime.ENT_Runtime.
                                          putObj(
                                            new org.sunflow.core.Scene(
                                              ),
                                            new java.lang.Integer[] { org.sunflow.EntMode.
                                                                        DYNAMIC_MODE });
                                bucketRenderer =
                                  (org.sunflow.core.renderer.BucketRenderer)
                                    ent.runtime.ENT_Runtime.
                                    putObj(
                                      new org.sunflow.core.renderer.BucketRenderer(
                                        ),
                                      new java.lang.Integer[] { org.sunflow.EntMode.
                                                                  DYNAMIC_MODE });
                                progressiveRenderer =
                                  (org.sunflow.core.renderer.ProgressiveRenderer)
                                    ent.runtime.ENT_Runtime.
                                    putObj(
                                      new org.sunflow.core.renderer.ProgressiveRenderer(
                                        ),
                                      new java.lang.Integer[] { org.sunflow.EntMode.
                                                                  DYNAMIC_MODE });
                                includeSearchPath =
                                  new org.sunflow.system.SearchPath(
                                    "include");
                                textureSearchPath =
                                  new org.sunflow.system.SearchPath(
                                    "texture");
                                parameterList =
                                  new org.sunflow.core.ParameterList(
                                    );
                                renderObjects =
                                  new org.sunflow.RenderObjectMap(
                                    );
                                currentFrame =
                                  1; }
    public final java.lang.String getUniqueName(java.lang.String prefix) {
        int counter =
          1;
        java.lang.String name;
        do  {
            name =
              java.lang.String.
                format(
                  "%s_%d",
                  prefix,
                  counter);
            counter++;
        }while(renderObjects.
                 has(
                   name)); 
        return name;
    }
    public final void parameter(java.lang.String name,
                                java.lang.String value) {
        parameterList.
          addString(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                boolean value) {
        parameterList.
          addBoolean(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                int value) {
        parameterList.
          addInteger(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                float value) {
        parameterList.
          addFloat(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                org.sunflow.image.Color value) {
        parameterList.
          addColor(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                org.sunflow.math.Point3 value) {
        parameterList.
          addPoints(
            name,
            org.sunflow.core.ParameterList.InterpolationType.
              NONE,
            new float[] { value.
                            x,
            value.
              y,
            value.
              z });
    }
    public final void parameter(java.lang.String name,
                                org.sunflow.math.Vector3 value) {
        parameterList.
          addVectors(
            name,
            org.sunflow.core.ParameterList.InterpolationType.
              NONE,
            new float[] { value.
                            x,
            value.
              y,
            value.
              z });
    }
    public final void parameter(java.lang.String name,
                                org.sunflow.math.Matrix4 value) {
        parameterList.
          addMatrices(
            name,
            org.sunflow.core.ParameterList.InterpolationType.
              NONE,
            value.
              asRowMajor(
                ));
    }
    public final void parameter(java.lang.String name,
                                int[] value) {
        parameterList.
          addIntegerArray(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                java.lang.String[] value) {
        parameterList.
          addStringArray(
            name,
            value);
    }
    public final void parameter(java.lang.String name,
                                java.lang.String type,
                                java.lang.String interpolation,
                                float[] data) {
        org.sunflow.core.ParameterList.InterpolationType interp;
        try {
            interp =
              org.sunflow.core.ParameterList.InterpolationType.
                toEnum(
                  interpolation.
                    toUpperCase(
                      ));
        }
        catch (java.lang.IllegalArgumentException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "Unknown interpolation type: %s -- ignoring parameter \"%s\"",
                interpolation,
                name);
            return;
        }
        if (type.
              equals(
                "float"))
            parameterList.
              addFloats(
                name,
                interp,
                data);
        else
            if (type.
                  equals(
                    "point"))
                parameterList.
                  addPoints(
                    name,
                    interp,
                    data);
            else
                if (type.
                      equals(
                        "vector"))
                    parameterList.
                      addVectors(
                        name,
                        interp,
                        data);
                else
                    if (type.
                          equals(
                            "texcoord"))
                        parameterList.
                          addTexCoords(
                            name,
                            interp,
                            data);
                    else
                        if (type.
                              equals(
                                "matrix"))
                            parameterList.
                              addMatrices(
                                name,
                                interp,
                                data);
                        else
                            org.sunflow.system.UI.
                              printError(
                                org.sunflow.system.UI.Module.
                                  API,
                                "Unknown parameter type: %s -- ignoring parameter \"%s\"",
                                type,
                                name);
    }
    public void remove(java.lang.String name) {
        renderObjects.
          remove(
            name);
    }
    public boolean update(java.lang.String name) {
        boolean success =
          renderObjects.
          update(
            name,
            parameterList,
            this);
        parameterList.
          clear(
            success);
        return success;
    }
    public final void addIncludeSearchPath(java.lang.String path) {
        includeSearchPath.
          addSearchPath(
            path);
    }
    public final void addTextureSearchPath(java.lang.String path) {
        textureSearchPath.
          addSearchPath(
            path);
    }
    public final java.lang.String resolveTextureFilename(java.lang.String filename) {
        return textureSearchPath.
          resolvePath(
            filename);
    }
    public final java.lang.String resolveIncludeFilename(java.lang.String filename) {
        return includeSearchPath.
          resolvePath(
            filename);
    }
    public final void shader(java.lang.String name,
                             org.sunflow.core.Shader shader) {
        if (shader !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare shader \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                shader);
        }
        if (lookupShader(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "Unable to update shader \"%s\" - shader object was not found",
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void modifier(java.lang.String name,
                               org.sunflow.core.Modifier modifier) {
        if (modifier !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare modifier \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                modifier);
        }
        if (lookupModifier(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                ("Unable to update modifier \"%s\" - modifier object was not f" +
                 "ound"),
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void geometry(java.lang.String name,
                               org.sunflow.core.PrimitiveList primitives) {
        if (primitives !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare geometry \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                primitives);
        }
        if (lookupGeometry(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                ("Unable to update geometry \"%s\" - geometry object was not f" +
                 "ound"),
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void geometry(java.lang.String name,
                               org.sunflow.core.Tesselatable tesselatable) {
        if (tesselatable !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare geometry \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                tesselatable);
        }
        if (lookupGeometry(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                ("Unable to update geometry \"%s\" - geometry object was not f" +
                 "ound"),
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void instance(java.lang.String name,
                               java.lang.String geoname) {
        if (geoname !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare instance \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            parameter(
              "geometry",
              geoname);
            renderObjects.
              put(
                name,
                new org.sunflow.core.Instance(
                  ));
        }
        if (lookupInstance(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                ("Unable to update instance \"%s\" - instance object was not f" +
                 "ound"),
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void light(java.lang.String name,
                            org.sunflow.core.LightSource light) {
        if (light !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare light \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                light);
        }
        if (lookupLight(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                ("Unable to update instance \"%s\" - instance object was not f" +
                 "ound"),
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void camera(java.lang.String name,
                             org.sunflow.core.CameraLens lens) {
        if (lens !=
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare camera \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                new org.sunflow.core.Camera(
                  lens));
        }
        if (lookupCamera(
              name) !=
              null)
            update(
              name);
        else {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "Unable to update camera \"%s\" - camera object was not found",
                name);
            parameterList.
              clear(
                true);
        }
    }
    public final void options(java.lang.String name) {
        if (lookupOptions(
              name) ==
              null) {
            if (renderObjects.
                  has(
                    name)) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to declare options \"%s\", name is already in use",
                    name);
                parameterList.
                  clear(
                    true);
                return;
            }
            renderObjects.
              put(
                name,
                new org.sunflow.core.Options(
                  ));
        }
        assert lookupOptions(
                 name) !=
          null;
        update(
          name);
    }
    public final org.sunflow.core.Geometry lookupGeometry(java.lang.String name) {
        return renderObjects.
          lookupGeometry(
            name);
    }
    private final org.sunflow.core.Instance lookupInstance(java.lang.String name) {
        return renderObjects.
          lookupInstance(
            name);
    }
    private final org.sunflow.core.Camera lookupCamera(java.lang.String name) {
        return renderObjects.
          lookupCamera(
            name);
    }
    private final org.sunflow.core.Options lookupOptions(java.lang.String name) {
        return renderObjects.
          lookupOptions(
            name);
    }
    public final org.sunflow.core.Shader lookupShader(java.lang.String name) {
        return renderObjects.
          lookupShader(
            name);
    }
    public final org.sunflow.core.Modifier lookupModifier(java.lang.String name) {
        return renderObjects.
          lookupModifier(
            name);
    }
    private final org.sunflow.core.LightSource lookupLight(java.lang.String name) {
        return renderObjects.
          lookupLight(
            name);
    }
    public final void shaderOverride(java.lang.String name,
                                     boolean photonOverride) {
        scene.
          setShaderOverride(
            lookupShader(
              name),
            photonOverride);
    }
    public final void render(java.lang.String optionsName,
                             org.sunflow.core.Display display) {
        renderObjects.
          updateScene(
            scene);
        org.sunflow.core.Options opt =
          lookupOptions(
            optionsName);
        if (opt ==
              null)
            opt =
              new org.sunflow.core.Options(
                );
        scene.
          setCamera(
            lookupCamera(
              opt.
                getString(
                  "camera",
                  null)));
        java.lang.String bakingInstanceName =
          opt.
          getString(
            "baking.instance",
            null);
        if (bakingInstanceName !=
              null) {
            org.sunflow.core.Instance bakingInstance =
              lookupInstance(
                bakingInstanceName);
            if (bakingInstance ==
                  null) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Unable to bake instance \"%s\" - not found",
                    bakingInstanceName);
                return;
            }
            scene.
              setBakingInstance(
                bakingInstance);
        }
        else
            scene.
              setBakingInstance(
                null);
        scene.
          prepare(
            opt,
            display);
        bucketRenderer.
          preprepare(
            opt);
        org.sunflow.core.ImageSampler sampler2 =
          ent.runtime.ENT_Snapshot.
          snapshot(
            bucketRenderer,
            org.sunflow.EntMode.
              LOW_MODE,
            org.sunflow.EntMode.
              HIGH_MODE,
            true);
        sampler2.
          prepare(
            opt,
            scene,
            scene.
              getImageWidth(
                ),
            scene.
              getImageHeight(
                ));
        sampler2.
          render(
            scene.
              getDisplay(
                ));
    }
    public final boolean parse(java.lang.String filename) {
        if (filename ==
              null)
            return false;
        filename =
          includeSearchPath.
            resolvePath(
              filename);
        org.sunflow.core.SceneParser parser =
          null;
        if (filename.
              endsWith(
                ".sc"))
            parser =
              new org.sunflow.core.parser.SCParser(
                );
        else
            if (filename.
                  endsWith(
                    ".ra2"))
                parser =
                  new org.sunflow.core.parser.RA2Parser(
                    );
            else
                if (filename.
                      endsWith(
                        ".ra3"))
                    parser =
                      new org.sunflow.core.parser.RA3Parser(
                        );
                else
                    if (filename.
                          endsWith(
                            ".tri"))
                        parser =
                          new org.sunflow.core.parser.TriParser(
                            );
                    else
                        if (filename.
                              endsWith(
                                ".rib"))
                            parser =
                              new org.sunflow.core.parser.ShaveRibParser(
                                );
                        else {
                            org.sunflow.system.UI.
                              printError(
                                org.sunflow.system.UI.Module.
                                  API,
                                "Unable to find a suitable parser for: \"%s\"",
                                filename);
                            return false;
                        }
        java.lang.String currentFolder =
          new java.io.File(
          filename).
          getAbsoluteFile(
            ).
          getParentFile(
            ).
          getAbsolutePath(
            );
        includeSearchPath.
          addSearchPath(
            currentFolder);
        textureSearchPath.
          addSearchPath(
            currentFolder);
        return parser.
          parse(
            filename,
            this);
    }
    public final org.sunflow.math.BoundingBox getBounds() {
        return scene.
          getBounds(
            );
    }
    public void build() {  }
    public static org.sunflow.SunflowAPI create(java.lang.String filename,
                                                int frameNumber) {
        if (filename ==
              null)
            return new org.sunflow.SunflowAPI(
              );
        org.sunflow.SunflowAPI api =
          null;
        if (filename.
              endsWith(
                ".java")) {
            org.sunflow.system.Timer t =
              new org.sunflow.system.Timer(
              );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  API,
                "Compiling \"" +
                filename +
                "\" ...");
            t.
              start(
                );
            try {
                java.io.FileInputStream stream =
                  new java.io.FileInputStream(
                  filename);
                api =
                  (org.sunflow.SunflowAPI)
                    org.codehaus.janino.ClassBodyEvaluator.
                    createFastClassBodyEvaluator(
                      new org.codehaus.janino.Scanner(
                        filename,
                        stream),
                      org.sunflow.SunflowAPI.class,
                      java.lang.ClassLoader.
                        getSystemClassLoader(
                          ));
                stream.
                  close(
                    );
            }
            catch (org.codehaus.janino.CompileException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Could not compile: \"%s\"",
                    filename);
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "%s",
                    e.
                      getMessage(
                        ));
                return null;
            }
            catch (org.codehaus.janino.Parser.ParseException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Could not compile: \"%s\"",
                    filename);
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "%s",
                    e.
                      getMessage(
                        ));
                return null;
            }
            catch (org.codehaus.janino.Scanner.ScanException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Could not compile: \"%s\"",
                    filename);
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "%s",
                    e.
                      getMessage(
                        ));
                return null;
            }
            catch (java.io.IOException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "Could not compile: \"%s\"",
                    filename);
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      API,
                    "%s",
                    e.
                      getMessage(
                        ));
                return null;
            }
            t.
              end(
                );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  API,
                "Compile time: " +
                t.
                  toString(
                    ));
            if (api !=
                  null) {
                java.lang.String currentFolder =
                  new java.io.File(
                  filename).
                  getAbsoluteFile(
                    ).
                  getParentFile(
                    ).
                  getAbsolutePath(
                    );
                api.
                  includeSearchPath.
                  addSearchPath(
                    currentFolder);
                api.
                  textureSearchPath.
                  addSearchPath(
                    currentFolder);
            }
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  API,
                "Build script running ...");
            t.
              start(
                );
            api.
              setCurrentFrame(
                frameNumber);
            api.
              build(
                );
            t.
              end(
                );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  API,
                "Build script time: %s",
                t.
                  toString(
                    ));
        }
        else {
            api =
              new org.sunflow.SunflowAPI(
                );
            api =
              api.
                parse(
                  filename)
                ? api
                : null;
        }
        return api;
    }
    public static org.sunflow.SunflowAPI compile(java.lang.String code) {
        try {
            org.sunflow.system.Timer t =
              new org.sunflow.system.Timer(
              );
            t.
              start(
                );
            org.sunflow.SunflowAPI api =
              (org.sunflow.SunflowAPI)
                org.codehaus.janino.ClassBodyEvaluator.
                createFastClassBodyEvaluator(
                  new org.codehaus.janino.Scanner(
                    null,
                    new java.io.StringReader(
                      code)),
                  org.sunflow.SunflowAPI.class,
                  (java.lang.ClassLoader)
                    null);
            t.
              end(
                );
            org.sunflow.system.UI.
              printInfo(
                org.sunflow.system.UI.Module.
                  API,
                "Compile time: %s",
                t.
                  toString(
                    ));
            return api;
        }
        catch (org.codehaus.janino.CompileException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            return null;
        }
        catch (org.codehaus.janino.Parser.ParseException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            return null;
        }
        catch (org.codehaus.janino.Scanner.ScanException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            return null;
        }
        catch (java.io.IOException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            return null;
        }
    }
    public int getCurrentFrame() { return currentFrame;
    }
    public void setCurrentFrame(int currentFrame) {
        this.
          currentFrame =
          currentFrame;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "zGSPs13c++b/AT3i8PFcVwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "auzSrbGteP2hNbDNqVyQJpaKIc1oyJPV");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "/8fZZ+7+P2XRktsWYwAA");
}
