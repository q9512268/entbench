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
      1447328484000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gn4n4YH/A4oiZPWgUwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328484000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ZTOyeqB7JzY58mbNyJInFD30EK3kL2k4");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "RkdfAoM7quqNoKY3XPq9LpMtED9a0fWr7/7CA8KbJ++4gnWqrzmh58kqf5z5" +
       "8K/j36B+917u/OH6rlNL1y8s9NSFq7pu8fUw8l3hgrVdDx4ye3fK2OvAQW6Z" +
       "JU++FD9qu1NWsHdkBRsD2LE68dM70v5jKn4lzN3uRy6fLQNpTnR1etGXnUvP" +
       "0o4s6Vcv957z+K2yC588hH7XwXoAbQtd+7qgty4L/fd3pP3XVPznMHe9rwd6" +
       "9hL9t47Q/c4Z0GUr2B4Hx7u26N51FdGdO1oQ0cky/LcdED+fij8Jc7eZejhw" +
       "rUWkd7fm2TmC+qdnbch0gd77t1DffxWh7h3l6hzh/V878P7vVHwJuJTDhTkn" +
       "mvV/nhXrU+D40Bbrh64R1ot1vhvHnufoipsV/sdLU3AuGx7+7w4K/v6sFFTB" +
       "8eKWghevYXN/f4bnth1Y70jFTZfGeu7ms2JNl9t+ZIv1I/+EzX294XhKmIF8" +
       "5Q4CHkrFK3YQcM/VIODntwT8/LUk4J4wd9/xtWfWTDH1dOm/52dQX7+Dhjem" +
       "4tEdNDx2NVzcp7Y0fOqfkoaZEk72Wc9yw1IGtbKDhnRh0bnCDhqKV8P7fWZL" +
       "w2euMQ33n6IhnTN6/oYHbAcPRCresoOHy65Gfyk8/OGWhz/8J+eBUULfSpAM" +
       "K7eDBzEVzA4eLrvG/aV4h89vefj8teLBzz1+6YlAtoNns17zhR959De/9YVH" +
       "/yTbBHOTFYiKX/fNi+zZPFbmyx/+3Bc/e9uDP5VtFLturASbSP3kZtfTe1kv" +
       "2KKaYbj1kJqMr3Tb4su31GS/YW549s2F6XJiaLN6Ptvfc7Bv8VpVnSH7/pPB" +
       "Z/Z35m207cLdc5dYYH+qocPcDY7umpuF3N+fllTnycl2PzD9lx8t82w6nqun" +
       "m74O0jabHi1v/3CPM0hMLqrpJzeaZjfbqJmKxy9meMe7T7QjLU6FD8ZpNdVr" +
       "A2NH9nWy+X3HjjzvSsXbdvTWbz5rb003Svz11iT/+hp6rXPK4X1fkd7mgbQl" +
       "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" +
       "8zD7RPX65+77d2/60Rf+KPvE3f8Hf+0l7TBjAAA=");
}
