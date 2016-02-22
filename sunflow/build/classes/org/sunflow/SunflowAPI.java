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
      1456098652000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bVLNv4CG/6ouQ0YIDNXhOXDisQ0cz4YRj7LAqgKktwnO4UKc2F6b1IE3avG8" +
       "u03Nz2Xj1rB8znKA0skhdY6cjaCqwYbBxtRXBJTgYqDYF4ASq5gSjwv6YiUo" +
       "ydmk1h2f+EmjmUXfjmTfO5QfP1JXM+PI9T9lC2adbxJOSJKa/qymeT+649mv" +
       "MkylX6VETqCyni7si90PAbPHR9j4ijbdw4bG7mOFHrBJDArh7mHDcS2eJYvs" +
       "gwQ5tihrjhcpEkTKPhz3vHu9sGCdMV0R5SzCzrLvbPbKJ45sar/lg08eY58s" +
       "kzVp927UMj5JqtnX06hSfEd5fqA2R1fVxsUfT3pi3CJnCXc9a7BrcHNcg8DA" +
       "NWJg38z2fc/Lasx/1utnR1c//eMDVWejJHIjiUg2mXpj8feUckbWJPNuTBa/" +
       "R98tmfRDY02L/354zRX9771Kv1hF2Hv3c4PL98o9d73S9sSO311HP+s4VoVw" +
       "NEc/9LRuONOpyENmwUv5k9BsJFxoSnng9E3MH8UP3NlkQfH3CIo/C1gLxqKY" +
       "NEBBNROTOANzjrCe8L3WnTUMXwX3CO86lN9A8VAO2Qf7601uNgzncw1LDDps" +
       "TpYa1yepyT5Bd3HvG/8HgufQEXBXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456098652000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL19C7Dj1nke967elrSSbD0sW7JkSbFlOguSAB+Q/AIJkCDx" +
       "IAkSIEjHkfAiCBAv4kGAtNVE7iT2xDOOmyipPYnUmUR51onTpB6nycRxxuM8" +
       "6jQZu2nSJE2cZ+vYdWM3TdLGbdwDkPex9+5ytbq72Rn8xMV54P++85///Ac4" +
       "B/vRr+SuD/xc3nOtlW654XktCc+bVvl8uPK04HyHLvckP9DUhiUFwRBce0p5" +
       "/c+c+7uvf2h2x17uhknulZLjuKEUGq4TcFrgWktNpXPnDq8SlmYHYe4O2pSW" +
       "EhSFhgXRRhA+SedecaRomHuU3lcBAipAQAUoUwHCDnOBQrdpTmQ30hKSEwaL" +
       "3D/LnaFzN3hKql6Ye/jCSjzJl+xtNb0MAajhpvRvAYDKCid+7qED7BvMJwB/" +
       "Xx567l9+6x0/ezZ3bpI7ZziDVB0FKBGCm0xyt9qaLWt+gKmqpk5ydzqapg40" +
       "35AsY53pPcndFRi6I4WRrx2QlF6MPM3P7nnI3K1Kis2PlND1D+BNDc1S9/+6" +
       "fmpJOsB6zyHWDcJmeh0AvMUAivlTSdH2i1w3Nxw1zL3ueIkDjI9SIAMoeqOt" +
       "hTP34FbXORK4kLtr03aW5OjQIPQNRwdZr3cjcJcwd/8lK0259iRlLunaU2Hu" +
       "vuP5epskkOvmjIi0SJi7+3i2rCbQSvcfa6Uj7fMV9i0ffLdDOnuZzqqmWKn+" +
       "N4FCDx4rxGlTzdccRdsUvPVN9PdL9/zS+/dyOZD57mOZN3k+8Z6vvePND37q" +
       "1zd5XnORPF3Z1JTwKeVF+fbPvbbxOHo2VeMmzw2MtPEvQJ6Zf2+b8mTigZ53" +
       "z0GNaeL5/cRPcb86/vaf1L68l7ulnbtBca3IBnZ0p+LanmFpfktzNF8KNbWd" +
       "u1lz1EaW3s7dCM5pw9E2V7vTaaCF7dx1VnbpBjf7G1A0BVWkFN0Izg1n6u6f" +
       "e1I4y84TL5fL3QiO3K3gqOU2/7LfMNeCZq6tQZIiOYbjQj3fTfEHkOaEMuB2" +
       "BgWRM7XcGAp8BXJ9/eDvweYX67XPpwblXb2qklTrO+IzZwChrz3enS3QE0jX" +
       "UjX/KeW5qE587aef+uzegXlv8YL+BOo/v63//GH9uTNnsmpfld5n00aA4Tno" +
       "q8CL3fr44F2dp9//+rPAOLz4OkBPmhW6tDNtHPbudubDFGBiuU99OH5W+LbC" +
       "Xm7vQq+Y6gYu3ZIW76W+7MBnPXq8N1ys3nPv++Lffez7n3EP+8UFbnbbXU+W" +
       "TLvb64+z6LuKpgIHdlj9mx6SPv7ULz3z6F7uOtCHgd8KJWBnwCU8ePweF3S7" +
       "J/ddWIrlegB46vq2ZKVJ+37nlnDmu/Hhlax5b8/O7wQcvyK1w7vB8S1bw8x+" +
       "09RXeql81cYc0kY7hiJzkW8deM//59/6Kzije9+bnjsyPg208MkjPTit7FzW" +
       "V+88tIGhr2kg3x99uPe93/eV970zMwCQ45GL3fDRVDZAzwVNCGj+jl9f/P4X" +
       "/vjF39k7NJoQDGGRbBlKcgAyvZ67ZQdIcLdvOtQHeAALdJ3Uah7lHdtVjakh" +
       "yZaWWun/PfdY8eP//YN3bOzAAlf2zejNl6/g8Pqr67lv/+y3/v2DWTVnlHQE" +
       "OuTsMNvGrb3ysGbM96VVqkfy7Ocf+MivSc8DBwmcUmCstczP5DIOclmjQRn+" +
       "N2Xy/LG0YipeFxw1/gv715FI4SnlQ7/z1duEr37ya5m2F4YaR9uakbwnN+aV" +
       "iocSUP29x3s6KQUzkA/5FPstd1if+jqocQJqVMD4GnR94FaSCyxjm/v6G//g" +
       "Vz59z9OfO5vba+ZusVxJbUpZJ8vdDKxbC2bAIyXe29+xadz4JiDuyKDmToDf" +
       "GMV92V+3AQUfv7R/aaaRwmEXve8fupb83j/73ydIyDzLRQbIY+Un0Ed/8P7G" +
       "276clT/s4mnpB5OTrhZEVYdlSz9p/+3e62/4zF7uxknuDmUbsgmSFaUdZwLC" +
       "lGA/jgNh3QXpF4Ycm/H1yQMX9trj7uXIbY87l0MXD87T3On5Lcf8yX0pyyVw" +
       "oNuuhh73J2fSHlo4X6ieL6UX3p4VfTiTj6biDVnbnE1P3whyBlmAGAJVDEey" +
       "tn36G+DfGXD8Y3qkN0gvbEbUuxrbYf2hg3HdAyPSjQLBDdpdNit/N4ihMyNL" +
       "OTm/CcM2bi6VmVrv2NypfEmjeuJCyG8FxxNbyE9cDPLNTzzhegf2wuxCnQo8" +
       "FURGbhP0MpxoYjw9fKrbGwIQg/Ry+5jG7EvXOA1Ecg+B4y1bjd9yQuNcdsJf" +
       "XE0A50bPN5aA3H0Nrw8UQPc+uxeM/4rra+cHafIxjYUr1Li05Xmf74tp/NQl" +
       "NE5Px/vK3i5HylwLORDXgbHU39f6jSe09rc5ztcvKHAMx9NXiCNl+21bHG+7" +
       "BI7ZS8HxSs93deD/AmOpHQfzzZcG0ztZ6hgi4woRPQ6ObdbN70UQLV4KojsN" +
       "R7EiFXg1yVdmPRBD7+N54CieYBWEmn3+MNcx/f2XoT+21R+7hP7rl6R/Oo0F" +
       "kd2Fmi2PqffuK1TvjeCob9WrX0K9Z1+Kerdls3gNTDbTGGKf2gdPmErvaLZj" +
       "yr/3CpV/EzgaW+Ubl1D+u16S8hsD3gxhwb7yrzmqPHckB4gbjmn+gSvU/AFw" +
       "4FvN8Uto/r0vRfNblcgHyofNlNXdQUfPN2wQKS+3s2rombu+MP/BL/7UZsZ8" +
       "PMI4lll7/3Pf9Y3zH3xu78hzikdOPCo4WmbzrCJT87ZM1zRme3jXXbISzf/2" +
       "sWd+8cefed9Gq7sunHUTTmT/1O/+v988/+E/+Y2LTA3PGs5xi3rusu2y0S0d" +
       "Rq8vna+eL6R//9CVDaH3mpby6H5sIAA/CYbiR02rmiYfH0qbL1khQNfth5EE" +
       "7Tr6kx/4iw/95nc/8gUAvZO7fpmGYICjI+EGG6VPuL7zo9/3wCue+5MPZBMX" +
       "YC+DG94GPZ3W+hNXBuv+FNbAjXxFo6UgZLK5hqamyLIqPnwEzw+GYMbingh1" +
       "Xjra8P6nSSRoY/v/aEGZTvp8cSJAcL+wjiEswRkdNjEKb9g6TGAwRbCT2biF" +
       "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" +
       "KQ0Sslla18Uhy4ktbihJchXjpaFl+w2r");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("W3ddJSiMrBkRyjgyFXiTxnRT49tRMcFaTaQWBZhlYlAHY9qjmcnrPkK0gN9D" +
       "IA5kJQzTRPKrEt8tdZ1mP3bEwaDN6FiybOKtpNAalD1PE9D+elBAu4Gk0/Y0" +
       "RotTpk/hbBPBdLlLNdiEKebZdUPnO6WGbo+pnliS+vZ6tEQGWBxCVRfEf1V7" +
       "jqGiyfR1k1OxsWtZCl9tzKoVRgeNE/h1bs10Wl0E74DIiGyxvIKaxGQ0o0rN" +
       "KZZPRAIShoSd+alOb214prKwjJE7n5fW2lhvjTuMXO+vA7UZxvygZbmzEPNn" +
       "TldbrZsDZjWgutiqA4Nwaq6PuIEV6w1NYCCqE6M9VxtRczDh7FILmAomwzkz" +
       "phnaKHN9SRQwpVUdIKhU8xnYRBykR2CGFYaMJeMDExmgiIjgDTAARtZ8WQYO" +
       "T8DN+gRDPMQkmvqMGjZsb9JYU4UVUZ9B2qyLzeCx54xqExKx5HpbxNp6yzTn" +
       "M3fBtahBInYTWCCwvudQBldKBlXRQhOl25cYx5bqtmFLPo0pCmWCsAOMOVTB" +
       "MrruhGnMvDKhqLE9X3MqXCaKrAOcTbI2m52BTuPICHOXhUDljJjxp8J4Plpq" +
       "1sCcj8rN9rKIubA16q3yOsNPXTCiOXPBgUd6bMS8RbUjp2/Xk6ZXlutNHVZA" +
       "X6RqE2POTFZ0BxGCnr4yZmrAuK1kVV/N4hKZqIywdkwaQar1Vq3EE0JSWy8Z" +
       "m2I4Yx5wK3yZtON8QwIz9WmHY2S9GclFEvOcpkW6NI+Ve3V1tFxg3JytYgTo" +
       "O7yO4L0R1U+ctgLNZQwZodyy04Vjo+zMZ6FaUemC7Okg+ke6iwVqsJjg0QQ7" +
       "NLHhsMkwPrfM91XYluGxFahtli4yyowgwChKx7CH24HKiK1JB28pc44lZo0m" +
       "jVQJyY5XILAWyt1mhPbGtUG1mYx5YSGDaNFuMZLv6eX6aM7P6KBaG8zr3qgb" +
       "6ZTbaoKptmfNbEmJ+mPPW6zMKW4EhbZRKdpSFw5Jdhk2R4yf2qM/apBLvlLE" +
       "iYLk2XFIDBsdfzwvgoYSbKmtiKOEG9FEC2dgMPNbLwuJYDLEzIyEVnkwx/vS" +
       "jBPj6XAYE+i0OkgQoz6qdnUuX2P4kWLYutYZmZosgBiC85oMPqVwg1wpznjk" +
       "RUyriAeh6JbmNZckyC5dXDpcreSBvlvSlLzlN7SoXMNiLN8fk3lEwnqzYXNY" +
       "YPBFvEAiohlXQ8btBi0i71MLa9lmA6kSD1v6DCONHgZbS6Ex4ZFgtOq3i4ZV" +
       "K2vUWPcwj46BSSfiPOHstje3IKSgL5cgdNWgwEKbLTBYE20QQ5ldEPYpAwgT" +
       "FnRXMwKdXqgLsi8LNLtEGi2o4kb9wriNs+KsKwJ6+wVljYw5s0pjC52ah7HT" +
       "RXhKKTUrcrFNwNKyVYsKMAvm32bRr9fWDoUVgvlMHVcUU2os4rFcT0JOrHeG" +
       "+niBj4FbGyzK+sCMl5Wxwbsr1Z4XZ6VpnrBNmxenpj2cdsv9aa/YEZl8r40O" +
       "UatRklQ56XQHHUqCFitbG+YrCGovmfnKEisCMVw0Vo5RDQy00MPkHsmhJmKY" +
       "shojcqtqd5ukX+/gwGFVbRJXBiWtM14Getwvh8bMN2eKR8yHVG+2hpdkhAat" +
       "BuhiBa48WDfWPr2UezLVQcqB5EOWXqhp43ItmK8FDy1VecYsdxahIxYqs8GU" +
       "UMvTBVbiilMhCfjpEPYMuNFxGqKCStW6r5CsotdwjB11dLi2Lk0ViJaCBCpG" +
       "ocMVFQjSGFwYaWaHbJsGr5ds0TNrU41X5vKo02OjYV2COLQW2lMOHxfAzAwu" +
       "I2tORKvVIrUszpolEoT7SI9Gay6qVuEBGgy6cLFI9vIBIrhCzBIKhNJc1GW7" +
       "3opg7ZhfludoPeg0E3fgODpKwAxZ43swa837UxJutF2oUdTpZEGNWaJeZ7nu" +
       "sIuxaxNYb42GR86QZ8RYhBtd4J9ZFKsJWLfUn1YrhWLE6mtHiYs0jnvB0BtL" +
       "xZXmrYblugqTyxZUI/Vo2ifEuohh2FvTV00fv7JXYHdmb/YOll+/jHd6m6SH" +
       "U/HYwSvg7N8NuWNLdo+8Aj6ykiyXvjd94FKrqrN3pi++97kX1O6PFPe2K/Ce" +
       "D3M3h673zRaYylpHqnozqOlNl34/zGSLyg9Xhv3ae790//Bts6evYL3r647p" +
       "ebzKn2A++hutb1K+Zy939mCd2Inl7hcWevLC1WG3+FoY+c7wgjViDxwwe1fK" +
       "2BvA0dky2zn+cv2w7U5Ywd6hFWwMYMcqx8/uSPsPqfjVMHe7HzmDbDlJY6Yp" +
       "84u+NF26hnpoSb92ufelR2+VXfj0AfQ799cVqFvo6suCTlwW+h/sSPsvqfhP" +
       "Ye56Xwu07GX8bx+i+91ToMtWwj0Gjvds0b3nKqI7c7iwop1l+K87IH4xFX8a" +
       "5m7TtZB3jEWksVvzbB9C/bPTNmS60O+DW6gfvIpQ9w5ztQ/x/s8deP9XKr4C" +
       "XMrBAp9jzfo/Tov1SXB8ZIv1I9cI68U6342y61qa5GSF//HSFJzJhof/s4OC" +
       "fzgtBVVwvLil4MVr2Nw/kOG5bQfWc6m46dJYz9x8Wqzpst2PbbF+7J+wua+f" +
       "Wq4UZiBfvYOAB1Pxqh0E3H01CPiFLQG/cC0JuDvM3Xt0DRuYdupauoXA9TOo" +
       "b9xBw5tT8cgOGh69Gi7uM1saPvNPSYMthbPzPddwQjiDWtlBQ7pA6UxxBw2l" +
       "q+H9Prel4XPXmIb7TtAgaOluhw0P+A4eyFS8fQcPl13V/lJ4+KMtD3/0T84D" +
       "I4W+kSAZVm4HD0IqmB08XHat/EvxDl/c8vDFa8WDn3vs0hOBbCfQZt3nCz/6" +
       "yG992wuP/Gm2meYmIxAkH/P1i+zzPFLmqx/9wpc/f9sDP51tOLtOloJNpH58" +
       "g+zJ/a8XbGvNMNx6QE3GV7rV8ZVbarLfMMe83K2J6WJkaLP2PtsdtL/X8epW" +
       "mKH4geOBZvZ35lnU7WLfM5dYlH+iUcPcDZbm6JvF3z+QllS85Hgb75v5Kw+X" +
       "hjYs19HSjWL7aZuNkoZ7/mAPNEhMLqrppzeaZjfbqJmKxy5mZEe7SrQjLU6F" +
       "D8ZkJdVrA2NH9nWy+X16R573pOKdO3rmt5y2Z6abK/5ma35/cw091Bnp4L6v" +
       "Sm9zf9oS2/ue2Zj9Uye3Ij3x0CKSAjAfcUPtjZttig9tdjg9lO1vemizGemd" +
       "73qI6eLEUyzGEIOH3vqQo8XblHdLtvzMO8+fP/+uJx/3vOTQYV7Uct+/b7kf" +
       "eImg07zzA6t930mrTS/bqXB3mOH7s7Z+XyqCHcbwPTvSnkvFh1KxqWuX4X3/" +
       "1vC+c0eeNMw88+wOw7vstobLGd67AAVnt+1/9ioa3nVZruuylj4Ux0ww268A" +
       "TvZ+fqPB5jfM9U/lKL306w0+NGhkn3E48L5Xv9Ksie6/tB2/uG/HP/6y7PiH" +
       "X6Ydv5jp9cOXs+OP7Uj7N6n4qQM7/uFddvxzWzv+oR15Pp6K53fY8QunsONs" +
       "M/gjgIKHt3b88BXYcfZk5o0v6dHNmV/egfBXUvELYAj1Ndtdasfg/eIp4GXR" +
       "yKuBIue38M5fI3g7njueSZ87nvlVAC/yVDAipFm+cQjv1M8Wq0CR7T7UMyf2" +
       "oZ7CC53A+Hs7MP5+Kj4PwhdJVdvHN/Qda9D/eDUQbzfHnTmxOe5qIv7zHYj/" +
       "MhV/vEE8vNgWwCOIv3DaJ6wg/Qy7RcxeS8R/vQPx11LxpTB3j7/53s4WdRPE" +
       "O86JR61nvnw1ME+2mCfXEvPXd2D+f6n4u0PMW9u+BOa/P61l14Bi0y3m6VXE" +
       "fNlnL5sd2zMp/R4DSN+78dKc7L0iFXvpRv0s/4W2vnf2tBy8DWB/dsvBs9eY" +
       "g1ef4GC7nW7Dwt07WHh1Ku4IczfZ2xLHeLjztDwQAP/zWx6ev8Y8XGQ/8P4W" +
       "0OzTIymgR3aQ8YZUPAjI0DUQJ4b+6hgZrzstGU1Awie2ZHziGpPxwAkyhloQ" +
       "aJYUZnPxFE9xBxflVLz50lx881V4Infm81suPn+NuDjwjntv3wEVS8UTAKqx" +
       "fSt8DOqTVwPql7ZQv3SNm/21J5qdNvRZuNlpm8GldlDRTUX6VQwrLXSMh9ZV" +
       "eCa/d/2m7Ob3GvLwmhM8NMBI50u05gQZ1PEOGt6ViiEYG5SszDEe+NPy8Cag" +
       "7INbHh68ijwcjwn29B0YjVTIYe7GI193OQJSOQXI9JFS+u2HvdIWZOlagtwx" +
       "w92LUuGEudst151HXmvryy49cF6QIyPCPQURr0kvPg4wbb/+snfi6y+XI2J8" +
       "BUQ8u4OIf56K9xwQsb/+5dJEXJAjI+KZUxDx6vTiYwATuSWCvJZEfPcOIv5F" +
       "Kr4rzN26IWLjFC4dTB5Jz0i47Kc4Ltct3pBLVzdtSKCvJQnP7yDhX6Xiw2Hu" +
       "tg0J3Y0H2GfhvhMsHM2Q0fCR006LHgWIRlsaRtfSO/zrHTSkj7f2fvTAFgb7" +
       "E4G9mw6R/tjV8IPyFql8LZF+YgfSf5eKnz3o/sxhsL93zyHWnzsF1mwcS12d" +
       "vcVqX0vj/vQOrJ9JxSfD3Cs2WOltJLNHHwL95dOO4G2g82oLdHUVG/V48PqN" +
       "DNFv70D7uVT8e9Cym2lsd6n5vqEeD2E/e1rAGNDqO7aAv+MaAb60/8GNwLOk" +
       "VQb4D3eQ8YVU/G72CNY5Oaf/vdMOYMDG9z65JeGT17Ir/9UOjF9OxV+AED17" +
       "H5EZySHEvzwFxHR1Z+6bgLZ/uIX4h1cR4lEEf7sj7e9T8dUwd7OuhXU3ctSD" +
       "Uem1J1ZVZOmGo9e3IVrGwNdO+xrhXgDmz7cM/PkVMLDjOfsRgGfP7ki7PgXw" +
       "j6Bp5ciw1GPW+43TNu0jANBfb4H99ctq2osvXL7oKsCz53bgvDMVt6TTK1/b" +
       "vko4XPB+9hWnBQpii7OPb8pufq8S0OPd9OxrdmB8IBX3gOnV9mvdx0DeewqQ" +
       "59KLwBedbW1Btq6+mb5hR9rjqXh9mDsH+mjjyAfissY/hPjIaXtiEUDjthC5" +
       "qwPxSBNuzBTegTN9BHb2PMAZnMR52DHPQleCMwlztxx+Vzz9SPJ9J/7ngc3X" +
       "8pWffuHcTfe+wP/eZqXT/hftb6ZzN00jyzr6Tdsj5zd4vjY1Muw3Z/L2bK3F" +
       "2beAeOiIAwV2uT1LNTz75CbT28PcWZApPX2Ht+93j3wBbvN9wmTzovm+oy2X" +
       "rVO+63JEHNlz8sgFC8Syd8L7uzqizf/S8JTysRc67Lu/VvmRzTe6FUtar9Na" +
       "bqJzN24+F55Vmu4MefiSte3XdQP5+Ndv/5mbH9vfxXL7RuFDKzqi2+su/kFs" +
       "wvbC7BPW65+/99++5cde+OPsE3j/HzSKUX48YwAA");
}
