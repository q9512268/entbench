package org.sunflow.core.parser;
public class SCParser implements org.sunflow.core.SceneParser {
    private org.sunflow.system.Parser p;
    private int numLightSamples;
    public SCParser() { super(); }
    public boolean parse(java.lang.String filename, org.sunflow.SunflowAPI api) {
        java.lang.String localDir =
          new java.io.File(
          filename).
          getAbsoluteFile(
            ).
          getParentFile(
            ).
          getAbsolutePath(
            );
        numLightSamples =
          1;
        org.sunflow.system.Timer timer =
          new org.sunflow.system.Timer(
          );
        timer.
          start(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              API,
            "Parsing \"%s\" ...",
            filename);
        try {
            p =
              new org.sunflow.system.Parser(
                filename);
            while (true) {
                java.lang.String token =
                  p.
                  getNextToken(
                    );
                if (token ==
                      null)
                    break;
                if (token.
                      equals(
                        "image")) {
                    org.sunflow.system.UI.
                      printInfo(
                        org.sunflow.system.UI.Module.
                          API,
                        "Reading image settings ...");
                    parseImageBlock(
                      api);
                }
                else
                    if (token.
                          equals(
                            "background")) {
                        org.sunflow.system.UI.
                          printInfo(
                            org.sunflow.system.UI.Module.
                              API,
                            "Reading background ...");
                        parseBackgroundBlock(
                          api);
                    }
                    else
                        if (token.
                              equals(
                                "accel")) {
                            org.sunflow.system.UI.
                              printInfo(
                                org.sunflow.system.UI.Module.
                                  API,
                                "Reading accelerator type ...");
                            p.
                              getNextToken(
                                );
                            org.sunflow.system.UI.
                              printWarning(
                                org.sunflow.system.UI.Module.
                                  API,
                                "Setting accelerator type is not recommended - ignoring");
                        }
                        else
                            if (token.
                                  equals(
                                    "filter")) {
                                org.sunflow.system.UI.
                                  printInfo(
                                    org.sunflow.system.UI.Module.
                                      API,
                                    "Reading image filter type ...");
                                parseFilter(
                                  api);
                            }
                            else
                                if (token.
                                      equals(
                                        "bucket")) {
                                    org.sunflow.system.UI.
                                      printInfo(
                                        org.sunflow.system.UI.Module.
                                          API,
                                        "Reading bucket settings ...");
                                    api.
                                      parameter(
                                        "bucket.size",
                                        p.
                                          getNextInt(
                                            ));
                                    api.
                                      parameter(
                                        "bucket.order",
                                        p.
                                          getNextToken(
                                            ));
                                    api.
                                      options(
                                        org.sunflow.SunflowAPI.
                                          DEFAULT_OPTIONS);
                                }
                                else
                                    if (token.
                                          equals(
                                            "photons")) {
                                        org.sunflow.system.UI.
                                          printInfo(
                                            org.sunflow.system.UI.Module.
                                              API,
                                            "Reading photon settings ...");
                                        parsePhotonBlock(
                                          api);
                                    }
                                    else
                                        if (token.
                                              equals(
                                                "gi")) {
                                            org.sunflow.system.UI.
                                              printInfo(
                                                org.sunflow.system.UI.Module.
                                                  API,
                                                "Reading global illumination settings ...");
                                            parseGIBlock(
                                              api);
                                        }
                                        else
                                            if (token.
                                                  equals(
                                                    "lightserver")) {
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      API,
                                                    "Reading light server settings ...");
                                                parseLightserverBlock(
                                                  api);
                                            }
                                            else
                                                if (token.
                                                      equals(
                                                        "trace-depths")) {
                                                    org.sunflow.system.UI.
                                                      printInfo(
                                                        org.sunflow.system.UI.Module.
                                                          API,
                                                        "Reading trace depths ...");
                                                    parseTraceBlock(
                                                      api);
                                                }
                                                else
                                                    if (token.
                                                          equals(
                                                            "camera")) {
                                                        parseCamera(
                                                          api);
                                                    }
                                                    else
                                                        if (token.
                                                              equals(
                                                                "shader")) {
                                                            if (!parseShader(
                                                                   api))
                                                                return false;
                                                        }
                                                        else
                                                            if (token.
                                                                  equals(
                                                                    "modifier")) {
                                                                if (!parseModifier(
                                                                       api))
                                                                    return false;
                                                            }
                                                            else
                                                                if (token.
                                                                      equals(
                                                                        "override")) {
                                                                    api.
                                                                      shaderOverride(
                                                                        p.
                                                                          getNextToken(
                                                                            ),
                                                                        p.
                                                                          getNextBoolean(
                                                                            ));
                                                                }
                                                                else
                                                                    if (token.
                                                                          equals(
                                                                            "object")) {
                                                                        parseObjectBlock(
                                                                          api);
                                                                    }
                                                                    else
                                                                        if (token.
                                                                              equals(
                                                                                "instance")) {
                                                                            parseInstanceBlock(
                                                                              api);
                                                                        }
                                                                        else
                                                                            if (token.
                                                                                  equals(
                                                                                    "light")) {
                                                                                parseLightBlock(
                                                                                  api);
                                                                            }
                                                                            else
                                                                                if (token.
                                                                                      equals(
                                                                                        "texturepath")) {
                                                                                    java.lang.String path =
                                                                                      p.
                                                                                      getNextToken(
                                                                                        );
                                                                                    if (!new java.io.File(
                                                                                          path).
                                                                                          isAbsolute(
                                                                                            ))
                                                                                        path =
                                                                                          localDir +
                                                                                          java.io.File.
                                                                                            separator +
                                                                                          path;
                                                                                    api.
                                                                                      addTextureSearchPath(
                                                                                        path);
                                                                                }
                                                                                else
                                                                                    if (token.
                                                                                          equals(
                                                                                            "includepath")) {
                                                                                        java.lang.String path =
                                                                                          p.
                                                                                          getNextToken(
                                                                                            );
                                                                                        if (!new java.io.File(
                                                                                              path).
                                                                                              isAbsolute(
                                                                                                ))
                                                                                            path =
                                                                                              localDir +
                                                                                              java.io.File.
                                                                                                separator +
                                                                                              path;
                                                                                        api.
                                                                                          addIncludeSearchPath(
                                                                                            path);
                                                                                    }
                                                                                    else
                                                                                        if (token.
                                                                                              equals(
                                                                                                "include")) {
                                                                                            java.lang.String file =
                                                                                              p.
                                                                                              getNextToken(
                                                                                                );
                                                                                            org.sunflow.system.UI.
                                                                                              printInfo(
                                                                                                org.sunflow.system.UI.Module.
                                                                                                  API,
                                                                                                "Including: \"%s\" ...",
                                                                                                file);
                                                                                            api.
                                                                                              parse(
                                                                                                file);
                                                                                        }
                                                                                        else
                                                                                            org.sunflow.system.UI.
                                                                                              printWarning(
                                                                                                org.sunflow.system.UI.Module.
                                                                                                  API,
                                                                                                "Unrecognized token %s",
                                                                                                token);
            }
            p.
              close(
                );
        }
        catch (org.sunflow.system.Parser.ParserException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            e.
              printStackTrace(
                );
            return false;
        }
        catch (java.io.FileNotFoundException e) {
            org.sunflow.system.UI.
              printError(
                org.sunflow.system.UI.Module.
                  API,
                "%s",
                e.
                  getMessage(
                    ));
            return false;
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
            return false;
        }
        timer.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              API,
            "Done parsing.");
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              API,
            "Parsing time: %s",
            timer.
              toString(
                ));
        return true;
    }
    private void parseImageBlock(org.sunflow.SunflowAPI api)
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        p.
          checkNextToken(
            "{");
        if (p.
              peekNextToken(
                "resolution")) {
            api.
              parameter(
                "resolutionX",
                p.
                  getNextInt(
                    ));
            api.
              parameter(
                "resolutionY",
                p.
                  getNextInt(
                    ));
        }
        if (p.
              peekNextToken(
                "aa")) {
            api.
              parameter(
                "aa.min",
                p.
                  getNextInt(
                    ));
            api.
              parameter(
                "aa.max",
                p.
                  getNextInt(
                    ));
        }
        if (p.
              peekNextToken(
                "samples"))
            api.
              parameter(
                "aa.samples",
                p.
                  getNextInt(
                    ));
        if (p.
              peekNextToken(
                "contrast"))
            api.
              parameter(
                "aa.contrast",
                p.
                  getNextFloat(
                    ));
        if (p.
              peekNextToken(
                "filter"))
            api.
              parameter(
                "filter",
                p.
                  getNextToken(
                    ));
        if (p.
              peekNextToken(
                "jitter"))
            api.
              parameter(
                "aa.jitter",
                p.
                  getNextBoolean(
                    ));
        if (p.
              peekNextToken(
                "show-aa")) {
            org.sunflow.system.UI.
              printWarning(
                org.sunflow.system.UI.Module.
                  API,
                "Deprecated: show-aa ignored");
            p.
              getNextBoolean(
                );
        }
        if (p.
              peekNextToken(
                "output")) {
            org.sunflow.system.UI.
              printWarning(
                org.sunflow.system.UI.Module.
                  API,
                "Deprecated: output statement ignored");
            p.
              getNextToken(
                );
        }
        api.
          options(
            org.sunflow.SunflowAPI.
              DEFAULT_OPTIONS);
        p.
          checkNextToken(
            "}");
    }
    private void parseBackgroundBlock(org.sunflow.SunflowAPI api)
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        p.
          checkNextToken(
            "{");
        p.
          checkNextToken(
            "color");
        api.
          parameter(
            "color",
            parseColor(
              ));
        api.
          shader(
            "background.shader",
            new org.sunflow.core.shader.ConstantShader(
              ));
        api.
          geometry(
            "background",
            new org.sunflow.core.primitive.Background(
              ));
        api.
          parameter(
            "shaders",
            "background.shader");
        api.
          instance(
            "background.instance",
            "background");
        p.
          checkNextToken(
            "}");
    }
    private void parseFilter(org.sunflow.SunflowAPI api)
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        org.sunflow.system.UI.
          printWarning(
            org.sunflow.system.UI.Module.
              API,
            ("Deprecated keyword \"filter\" - set this option in the image" +
             " block"));
        java.lang.String name =
          p.
          getNextToken(
            );
        api.
          parameter(
            "filter",
            name);
        api.
          options(
            org.sunflow.SunflowAPI.
              DEFAULT_OPTIONS);
        boolean hasSizeParams =
          name.
          equals(
            "box") ||
          name.
          equals(
            "gaussian") ||
          name.
          equals(
            "blackman-harris") ||
          name.
          equals(
            "sinc") ||
          name.
          equals(
            "triangle");
        if (hasSizeParams) {
            p.
              getNextFloat(
                );
            p.
              getNextFloat(
                );
        }
    }
    private void parsePhotonBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { int numEmit =
                                0;
                              boolean globalEmit =
                                false;
                              p.checkNextToken(
                                  "{");
                              if (p.peekNextToken(
                                      "emit")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Shared photon emit values are deprectated - specify number o" +
                                       "f photons to emit per map"));
                                  numEmit =
                                    p.
                                      getNextInt(
                                        );
                                  globalEmit =
                                    true;
                              }
                              if (p.peekNextToken(
                                      "global")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Global photon map setting belonds inside the gi block - igno" +
                                       "ring"));
                                  if (!globalEmit)
                                      p.
                                        getNextInt(
                                          );
                                  p.
                                    getNextToken(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                              }
                              p.checkNextToken(
                                  "caustics");
                              if (!globalEmit)
                                  numEmit =
                                    p.
                                      getNextInt(
                                        );
                              api.parameter(
                                    "caustics.emit",
                                    numEmit);
                              api.parameter(
                                    "caustics",
                                    p.
                                      getNextToken(
                                        ));
                              api.parameter(
                                    "caustics.gather",
                                    p.
                                      getNextInt(
                                        ));
                              api.parameter(
                                    "caustics.radius",
                                    p.
                                      getNextFloat(
                                        ));
                              api.options(
                                    org.sunflow.SunflowAPI.
                                      DEFAULT_OPTIONS);
                              p.checkNextToken(
                                  "}"); }
    private void parseGIBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "type");
                              if (p.peekNextToken(
                                      "irr-cache")) {
                                  api.
                                    parameter(
                                      "gi.engine",
                                      "irr-cache");
                                  p.
                                    checkNextToken(
                                      "samples");
                                  api.
                                    parameter(
                                      "gi.irr-cache.samples",
                                      p.
                                        getNextInt(
                                          ));
                                  p.
                                    checkNextToken(
                                      "tolerance");
                                  api.
                                    parameter(
                                      "gi.irr-cache.tolerance",
                                      p.
                                        getNextFloat(
                                          ));
                                  p.
                                    checkNextToken(
                                      "spacing");
                                  api.
                                    parameter(
                                      "gi.irr-cache.min_spacing",
                                      p.
                                        getNextFloat(
                                          ));
                                  api.
                                    parameter(
                                      "gi.irr-cache.max_spacing",
                                      p.
                                        getNextFloat(
                                          ));
                                  if (p.
                                        peekNextToken(
                                          "global")) {
                                      api.
                                        parameter(
                                          "gi.irr-cache.gmap.emit",
                                          p.
                                            getNextInt(
                                              ));
                                      api.
                                        parameter(
                                          "gi.irr-cache.gmap",
                                          p.
                                            getNextToken(
                                              ));
                                      api.
                                        parameter(
                                          "gi.irr-cache.gmap.gather",
                                          p.
                                            getNextInt(
                                              ));
                                      api.
                                        parameter(
                                          "gi.irr-cache.gmap.radius",
                                          p.
                                            getNextFloat(
                                              ));
                                  }
                              }
                              else
                                  if (p.
                                        peekNextToken(
                                          "path")) {
                                      api.
                                        parameter(
                                          "gi.engine",
                                          "path");
                                      p.
                                        checkNextToken(
                                          "samples");
                                      api.
                                        parameter(
                                          "gi.path.samples",
                                          p.
                                            getNextInt(
                                              ));
                                      if (p.
                                            peekNextToken(
                                              "bounces")) {
                                          org.sunflow.system.UI.
                                            printWarning(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              ("Deprecated setting: bounces - use diffuse trace depth instea" +
                                               "d"));
                                          p.
                                            getNextInt(
                                              );
                                      }
                                  }
                                  else
                                      if (p.
                                            peekNextToken(
                                              "fake")) {
                                          api.
                                            parameter(
                                              "gi.engine",
                                              "fake");
                                          p.
                                            checkNextToken(
                                              "up");
                                          api.
                                            parameter(
                                              "gi.fake.up",
                                              parseVector(
                                                ));
                                          p.
                                            checkNextToken(
                                              "sky");
                                          api.
                                            parameter(
                                              "gi.fake.sky",
                                              parseColor(
                                                ));
                                          p.
                                            checkNextToken(
                                              "ground");
                                          api.
                                            parameter(
                                              "gi.fake.ground",
                                              parseColor(
                                                ));
                                      }
                                      else
                                          if (p.
                                                peekNextToken(
                                                  "igi")) {
                                              api.
                                                parameter(
                                                  "gi.engine",
                                                  "igi");
                                              p.
                                                checkNextToken(
                                                  "samples");
                                              api.
                                                parameter(
                                                  "gi.igi.samples",
                                                  p.
                                                    getNextInt(
                                                      ));
                                              p.
                                                checkNextToken(
                                                  "sets");
                                              api.
                                                parameter(
                                                  "gi.igi.sets",
                                                  p.
                                                    getNextInt(
                                                      ));
                                              if (!p.
                                                    peekNextToken(
                                                      "b"))
                                                  p.
                                                    checkNextToken(
                                                      "c");
                                              api.
                                                parameter(
                                                  "gi.igi.c",
                                                  p.
                                                    getNextFloat(
                                                      ));
                                              p.
                                                checkNextToken(
                                                  "bias-samples");
                                              api.
                                                parameter(
                                                  "gi.igi.bias_samples",
                                                  p.
                                                    getNextInt(
                                                      ));
                                          }
                                          else
                                              if (p.
                                                    peekNextToken(
                                                      "ambocc")) {
                                                  api.
                                                    parameter(
                                                      "gi.engine",
                                                      "ambocc");
                                                  p.
                                                    checkNextToken(
                                                      "bright");
                                                  api.
                                                    parameter(
                                                      "gi.ambocc.bright",
                                                      parseColor(
                                                        ));
                                                  p.
                                                    checkNextToken(
                                                      "dark");
                                                  api.
                                                    parameter(
                                                      "gi.ambocc.dark",
                                                      parseColor(
                                                        ));
                                                  p.
                                                    checkNextToken(
                                                      "samples");
                                                  api.
                                                    parameter(
                                                      "gi.ambocc.samples",
                                                      p.
                                                        getNextInt(
                                                          ));
                                                  if (p.
                                                        peekNextToken(
                                                          "maxdist"))
                                                      api.
                                                        parameter(
                                                          "gi.ambocc.maxdist",
                                                          p.
                                                            getNextFloat(
                                                              ));
                                              }
                                              else
                                                  if (p.
                                                        peekNextToken(
                                                          "none") ||
                                                        p.
                                                        peekNextToken(
                                                          "null")) {
                                                      api.
                                                        parameter(
                                                          "gi.engine",
                                                          "none");
                                                  }
                                                  else
                                                      org.sunflow.system.UI.
                                                        printWarning(
                                                          org.sunflow.system.UI.Module.
                                                            API,
                                                          "Unrecognized gi engine type \"%s\" - ignoring",
                                                          p.
                                                            getNextToken(
                                                              ));
                              api.options(
                                    org.sunflow.SunflowAPI.
                                      DEFAULT_OPTIONS);
                              p.checkNextToken(
                                  "}"); }
    private void parseLightserverBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              if (p.peekNextToken(
                                      "shadows")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Deprecated: shadows setting ignored");
                                  p.
                                    getNextBoolean(
                                      );
                              }
                              if (p.peekNextToken(
                                      "direct-samples")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Deprecated: use samples keyword in area light definitions");
                                  numLightSamples =
                                    p.
                                      getNextInt(
                                        );
                              }
                              if (p.peekNextToken(
                                      "glossy-samples")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Deprecated: use samples keyword in glossy shader definitions");
                                  p.
                                    getNextInt(
                                      );
                              }
                              if (p.peekNextToken(
                                      "max-depth")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Deprecated: max-depth setting - use trace-depths block inste" +
                                       "ad"));
                                  int d =
                                    p.
                                    getNextInt(
                                      );
                                  api.
                                    parameter(
                                      "depths.diffuse",
                                      1);
                                  api.
                                    parameter(
                                      "depths.reflection",
                                      d -
                                        1);
                                  api.
                                    parameter(
                                      "depths.refraction",
                                      0);
                                  api.
                                    options(
                                      org.sunflow.SunflowAPI.
                                        DEFAULT_OPTIONS);
                              }
                              if (p.peekNextToken(
                                      "global")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Deprecated: global settings ignored - use photons block inst" +
                                       "ead"));
                                  p.
                                    getNextBoolean(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                              }
                              if (p.peekNextToken(
                                      "caustics")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Deprecated: caustics settings ignored - use photons block in" +
                                       "stead"));
                                  p.
                                    getNextBoolean(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                              }
                              if (p.peekNextToken(
                                      "irr-cache")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      ("Deprecated: irradiance cache settings ignored - use gi block" +
                                       " instead"));
                                  p.
                                    getNextInt(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                                  p.
                                    getNextFloat(
                                      );
                              }
                              p.checkNextToken(
                                  "}"); }
    private void parseTraceBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              if (p.peekNextToken(
                                      "diff"))
                                  api.
                                    parameter(
                                      "depths.diffuse",
                                      p.
                                        getNextInt(
                                          ));
                              if (p.peekNextToken(
                                      "refl"))
                                  api.
                                    parameter(
                                      "depths.reflection",
                                      p.
                                        getNextInt(
                                          ));
                              if (p.peekNextToken(
                                      "refr"))
                                  api.
                                    parameter(
                                      "depths.refraction",
                                      p.
                                        getNextInt(
                                          ));
                              p.checkNextToken(
                                  "}");
                              api.options(
                                    org.sunflow.SunflowAPI.
                                      DEFAULT_OPTIONS);
    }
    private void parseCamera(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "type");
                              java.lang.String type =
                                p.
                                getNextToken(
                                  );
                              org.sunflow.system.UI.
                                printInfo(
                                  org.sunflow.system.UI.Module.
                                    API,
                                  "Reading %s camera ...",
                                  type);
                              parseCameraTransform(
                                api);
                              java.lang.String name =
                                api.
                                getUniqueName(
                                  "camera");
                              if (type.equals(
                                         "pinhole")) {
                                  p.
                                    checkNextToken(
                                      "fov");
                                  api.
                                    parameter(
                                      "fov",
                                      p.
                                        getNextFloat(
                                          ));
                                  p.
                                    checkNextToken(
                                      "aspect");
                                  api.
                                    parameter(
                                      "aspect",
                                      p.
                                        getNextFloat(
                                          ));
                                  api.
                                    camera(
                                      name,
                                      new org.sunflow.core.camera.PinholeLens(
                                        ));
                              }
                              else
                                  if (type.
                                        equals(
                                          "thinlens")) {
                                      p.
                                        checkNextToken(
                                          "fov");
                                      api.
                                        parameter(
                                          "fov",
                                          p.
                                            getNextFloat(
                                              ));
                                      p.
                                        checkNextToken(
                                          "aspect");
                                      api.
                                        parameter(
                                          "aspect",
                                          p.
                                            getNextFloat(
                                              ));
                                      p.
                                        checkNextToken(
                                          "fdist");
                                      api.
                                        parameter(
                                          "focus.distance",
                                          p.
                                            getNextFloat(
                                              ));
                                      p.
                                        checkNextToken(
                                          "lensr");
                                      api.
                                        parameter(
                                          "lens.radius",
                                          p.
                                            getNextFloat(
                                              ));
                                      if (p.
                                            peekNextToken(
                                              "sides"))
                                          api.
                                            parameter(
                                              "lens.sides",
                                              p.
                                                getNextInt(
                                                  ));
                                      if (p.
                                            peekNextToken(
                                              "rotation"))
                                          api.
                                            parameter(
                                              "lens.rotation",
                                              p.
                                                getNextFloat(
                                                  ));
                                      api.
                                        camera(
                                          name,
                                          new org.sunflow.core.camera.ThinLens(
                                            ));
                                  }
                                  else
                                      if (type.
                                            equals(
                                              "spherical")) {
                                          api.
                                            camera(
                                              name,
                                              new org.sunflow.core.camera.SphericalLens(
                                                ));
                                      }
                                      else
                                          if (type.
                                                equals(
                                                  "fisheye")) {
                                              api.
                                                camera(
                                                  name,
                                                  new org.sunflow.core.camera.FisheyeLens(
                                                    ));
                                          }
                                          else {
                                              org.sunflow.system.UI.
                                                printWarning(
                                                  org.sunflow.system.UI.Module.
                                                    API,
                                                  "Unrecognized camera type: %s",
                                                  p.
                                                    getNextToken(
                                                      ));
                                              p.
                                                checkNextToken(
                                                  "}");
                                              return;
                                          }
                              p.checkNextToken(
                                  "}");
                              if (name !=
                                    null) {
                                  api.
                                    parameter(
                                      "camera",
                                      name);
                                  api.
                                    options(
                                      org.sunflow.SunflowAPI.
                                        DEFAULT_OPTIONS);
                              } }
    private void parseCameraTransform(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { if (p.peekNextToken(
                                      "steps")) {
                                  int n =
                                    p.
                                    getNextInt(
                                      );
                                  api.
                                    parameter(
                                      "transform.steps",
                                      n);
                                  for (int i =
                                         0;
                                       i <
                                         n;
                                       i++)
                                      parseCameraMatrix(
                                        i,
                                        api);
                              }
                              else
                                  parseCameraMatrix(
                                    -1,
                                    api);
    }
    private void parseCameraMatrix(int index,
                                   org.sunflow.SunflowAPI api)
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        java.lang.String offset =
          index <
          0
          ? ""
          : java.lang.String.
          format(
            "[%d]",
            index);
        if (p.
              peekNextToken(
                "transform")) {
            api.
              parameter(
                java.lang.String.
                  format(
                    "transform%s",
                    offset),
                parseMatrix(
                  ));
        }
        else {
            if (index >=
                  0)
                p.
                  checkNextToken(
                    "{");
            p.
              checkNextToken(
                "eye");
            api.
              parameter(
                java.lang.String.
                  format(
                    "eye%s",
                    offset),
                parsePoint(
                  ));
            p.
              checkNextToken(
                "target");
            api.
              parameter(
                java.lang.String.
                  format(
                    "target%s",
                    offset),
                parsePoint(
                  ));
            p.
              checkNextToken(
                "up");
            api.
              parameter(
                java.lang.String.
                  format(
                    "up%s",
                    offset),
                parseVector(
                  ));
            if (index >=
                  0)
                p.
                  checkNextToken(
                    "}");
        }
    }
    private boolean parseShader(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "name");
                              java.lang.String name =
                                p.
                                getNextToken(
                                  );
                              org.sunflow.system.UI.
                                printInfo(
                                  org.sunflow.system.UI.Module.
                                    API,
                                  "Reading shader: %s ...",
                                  name);
                              p.checkNextToken(
                                  "type");
                              if (p.peekNextToken(
                                      "diffuse")) {
                                  if (p.
                                        peekNextToken(
                                          "diff")) {
                                      api.
                                        parameter(
                                          "diffuse",
                                          parseColor(
                                            ));
                                      api.
                                        shader(
                                          name,
                                          new org.sunflow.core.shader.DiffuseShader(
                                            ));
                                  }
                                  else
                                      if (p.
                                            peekNextToken(
                                              "texture")) {
                                          api.
                                            parameter(
                                              "texture",
                                              p.
                                                getNextToken(
                                                  ));
                                          api.
                                            shader(
                                              name,
                                              new org.sunflow.core.shader.TexturedDiffuseShader(
                                                ));
                                      }
                                      else
                                          org.sunflow.system.UI.
                                            printWarning(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "Unrecognized option in diffuse shader block: %s",
                                              p.
                                                getNextToken(
                                                  ));
                              }
                              else
                                  if (p.
                                        peekNextToken(
                                          "phong")) {
                                      java.lang.String tex =
                                        null;
                                      if (p.
                                            peekNextToken(
                                              "texture"))
                                          api.
                                            parameter(
                                              "texture",
                                              tex =
                                                p.
                                                  getNextToken(
                                                    ));
                                      else {
                                          p.
                                            checkNextToken(
                                              "diff");
                                          api.
                                            parameter(
                                              "diffuse",
                                              parseColor(
                                                ));
                                      }
                                      p.
                                        checkNextToken(
                                          "spec");
                                      api.
                                        parameter(
                                          "specular",
                                          parseColor(
                                            ));
                                      api.
                                        parameter(
                                          "power",
                                          p.
                                            getNextFloat(
                                              ));
                                      if (p.
                                            peekNextToken(
                                              "samples"))
                                          api.
                                            parameter(
                                              "samples",
                                              p.
                                                getNextInt(
                                                  ));
                                      if (tex !=
                                            null)
                                          api.
                                            shader(
                                              name,
                                              new org.sunflow.core.shader.TexturedPhongShader(
                                                ));
                                      else
                                          api.
                                            shader(
                                              name,
                                              new org.sunflow.core.shader.PhongShader(
                                                ));
                                  }
                                  else
                                      if (p.
                                            peekNextToken(
                                              "amb-occ") ||
                                            p.
                                            peekNextToken(
                                              "amb-occ2")) {
                                          java.lang.String tex =
                                            null;
                                          if (p.
                                                peekNextToken(
                                                  "diff") ||
                                                p.
                                                peekNextToken(
                                                  "bright"))
                                              api.
                                                parameter(
                                                  "bright",
                                                  parseColor(
                                                    ));
                                          else
                                              if (p.
                                                    peekNextToken(
                                                      "texture"))
                                                  api.
                                                    parameter(
                                                      "texture",
                                                      tex =
                                                        p.
                                                          getNextToken(
                                                            ));
                                          if (p.
                                                peekNextToken(
                                                  "dark")) {
                                              api.
                                                parameter(
                                                  "dark",
                                                  parseColor(
                                                    ));
                                              p.
                                                checkNextToken(
                                                  "samples");
                                              api.
                                                parameter(
                                                  "samples",
                                                  p.
                                                    getNextInt(
                                                      ));
                                              p.
                                                checkNextToken(
                                                  "dist");
                                              api.
                                                parameter(
                                                  "maxdist",
                                                  p.
                                                    getNextFloat(
                                                      ));
                                          }
                                          if (tex ==
                                                null)
                                              api.
                                                shader(
                                                  name,
                                                  new org.sunflow.core.shader.AmbientOcclusionShader(
                                                    ));
                                          else
                                              api.
                                                shader(
                                                  name,
                                                  new org.sunflow.core.shader.TexturedAmbientOcclusionShader(
                                                    ));
                                      }
                                      else
                                          if (p.
                                                peekNextToken(
                                                  "mirror")) {
                                              p.
                                                checkNextToken(
                                                  "refl");
                                              api.
                                                parameter(
                                                  "color",
                                                  parseColor(
                                                    ));
                                              api.
                                                shader(
                                                  name,
                                                  new org.sunflow.core.shader.MirrorShader(
                                                    ));
                                          }
                                          else
                                              if (p.
                                                    peekNextToken(
                                                      "glass")) {
                                                  p.
                                                    checkNextToken(
                                                      "eta");
                                                  api.
                                                    parameter(
                                                      "eta",
                                                      p.
                                                        getNextFloat(
                                                          ));
                                                  p.
                                                    checkNextToken(
                                                      "color");
                                                  api.
                                                    parameter(
                                                      "color",
                                                      parseColor(
                                                        ));
                                                  if (p.
                                                        peekNextToken(
                                                          "absorbtion.distance"))
                                                      api.
                                                        parameter(
                                                          "absorbtion.distance",
                                                          p.
                                                            getNextFloat(
                                                              ));
                                                  if (p.
                                                        peekNextToken(
                                                          "absorbtion.color"))
                                                      api.
                                                        parameter(
                                                          "absorbtion.color",
                                                          parseColor(
                                                            ));
                                                  api.
                                                    shader(
                                                      name,
                                                      new org.sunflow.core.shader.GlassShader(
                                                        ));
                                              }
                                              else
                                                  if (p.
                                                        peekNextToken(
                                                          "shiny")) {
                                                      java.lang.String tex =
                                                        null;
                                                      if (p.
                                                            peekNextToken(
                                                              "texture"))
                                                          api.
                                                            parameter(
                                                              "texture",
                                                              tex =
                                                                p.
                                                                  getNextToken(
                                                                    ));
                                                      else {
                                                          p.
                                                            checkNextToken(
                                                              "diff");
                                                          api.
                                                            parameter(
                                                              "diffuse",
                                                              parseColor(
                                                                ));
                                                      }
                                                      p.
                                                        checkNextToken(
                                                          "refl");
                                                      api.
                                                        parameter(
                                                          "shiny",
                                                          p.
                                                            getNextFloat(
                                                              ));
                                                      if (tex ==
                                                            null)
                                                          api.
                                                            shader(
                                                              name,
                                                              new org.sunflow.core.shader.ShinyDiffuseShader(
                                                                ));
                                                      else
                                                          api.
                                                            shader(
                                                              name,
                                                              new org.sunflow.core.shader.TexturedShinyDiffuseShader(
                                                                ));
                                                  }
                                                  else
                                                      if (p.
                                                            peekNextToken(
                                                              "ward")) {
                                                          java.lang.String tex =
                                                            null;
                                                          if (p.
                                                                peekNextToken(
                                                                  "texture"))
                                                              api.
                                                                parameter(
                                                                  "texture",
                                                                  tex =
                                                                    p.
                                                                      getNextToken(
                                                                        ));
                                                          else {
                                                              p.
                                                                checkNextToken(
                                                                  "diff");
                                                              api.
                                                                parameter(
                                                                  "diffuse",
                                                                  parseColor(
                                                                    ));
                                                          }
                                                          p.
                                                            checkNextToken(
                                                              "spec");
                                                          api.
                                                            parameter(
                                                              "specular",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "rough");
                                                          api.
                                                            parameter(
                                                              "roughnessX",
                                                              p.
                                                                getNextFloat(
                                                                  ));
                                                          api.
                                                            parameter(
                                                              "roughnessY",
                                                              p.
                                                                getNextFloat(
                                                                  ));
                                                          if (p.
                                                                peekNextToken(
                                                                  "samples"))
                                                              api.
                                                                parameter(
                                                                  "samples",
                                                                  p.
                                                                    getNextInt(
                                                                      ));
                                                          if (tex !=
                                                                null)
                                                              api.
                                                                shader(
                                                                  name,
                                                                  new org.sunflow.core.shader.TexturedWardShader(
                                                                    ));
                                                          else
                                                              api.
                                                                shader(
                                                                  name,
                                                                  new org.sunflow.core.shader.AnisotropicWardShader(
                                                                    ));
                                                      }
                                                      else
                                                          if (p.
                                                                peekNextToken(
                                                                  "view-caustics")) {
                                                              api.
                                                                shader(
                                                                  name,
                                                                  new org.sunflow.core.shader.ViewCausticsShader(
                                                                    ));
                                                          }
                                                          else
                                                              if (p.
                                                                    peekNextToken(
                                                                      "view-irradiance")) {
                                                                  api.
                                                                    shader(
                                                                      name,
                                                                      new org.sunflow.core.shader.ViewIrradianceShader(
                                                                        ));
                                                              }
                                                              else
                                                                  if (p.
                                                                        peekNextToken(
                                                                          "view-global")) {
                                                                      api.
                                                                        shader(
                                                                          name,
                                                                          new org.sunflow.core.shader.ViewGlobalPhotonsShader(
                                                                            ));
                                                                  }
                                                                  else
                                                                      if (p.
                                                                            peekNextToken(
                                                                              "constant")) {
                                                                          p.
                                                                            peekNextToken(
                                                                              "color");
                                                                          api.
                                                                            parameter(
                                                                              "color",
                                                                              parseColor(
                                                                                ));
                                                                          api.
                                                                            shader(
                                                                              name,
                                                                              new org.sunflow.core.shader.ConstantShader(
                                                                                ));
                                                                      }
                                                                      else
                                                                          if (p.
                                                                                peekNextToken(
                                                                                  "janino")) {
                                                                              java.lang.String code =
                                                                                p.
                                                                                getNextCodeBlock(
                                                                                  );
                                                                              try {
                                                                                  org.sunflow.core.Shader shader =
                                                                                    (org.sunflow.core.Shader)
                                                                                      org.codehaus.janino.ClassBodyEvaluator.
                                                                                      createFastClassBodyEvaluator(
                                                                                        new org.codehaus.janino.Scanner(
                                                                                          null,
                                                                                          new java.io.StringReader(
                                                                                            code)),
                                                                                        org.sunflow.core.Shader.class,
                                                                                        java.lang.ClassLoader.
                                                                                          getSystemClassLoader(
                                                                                            ));
                                                                                  api.
                                                                                    shader(
                                                                                      name,
                                                                                      shader);
                                                                              }
                                                                              catch (org.codehaus.janino.CompileException e) {
                                                                                  org.sunflow.system.UI.
                                                                                    printDetailed(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "Compiling: %s",
                                                                                      code);
                                                                                  org.sunflow.system.UI.
                                                                                    printError(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "%s",
                                                                                      e.
                                                                                        getMessage(
                                                                                          ));
                                                                                  e.
                                                                                    printStackTrace(
                                                                                      );
                                                                                  return false;
                                                                              }
                                                                              catch (org.codehaus.janino.Parser.ParseException e) {
                                                                                  org.sunflow.system.UI.
                                                                                    printDetailed(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "Compiling: %s",
                                                                                      code);
                                                                                  org.sunflow.system.UI.
                                                                                    printError(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "%s",
                                                                                      e.
                                                                                        getMessage(
                                                                                          ));
                                                                                  e.
                                                                                    printStackTrace(
                                                                                      );
                                                                                  return false;
                                                                              }
                                                                              catch (org.codehaus.janino.Scanner.ScanException e) {
                                                                                  org.sunflow.system.UI.
                                                                                    printDetailed(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "Compiling: %s",
                                                                                      code);
                                                                                  org.sunflow.system.UI.
                                                                                    printError(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "%s",
                                                                                      e.
                                                                                        getMessage(
                                                                                          ));
                                                                                  e.
                                                                                    printStackTrace(
                                                                                      );
                                                                                  return false;
                                                                              }
                                                                              catch (java.io.IOException e) {
                                                                                  org.sunflow.system.UI.
                                                                                    printDetailed(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "Compiling: %s",
                                                                                      code);
                                                                                  org.sunflow.system.UI.
                                                                                    printError(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "%s",
                                                                                      e.
                                                                                        getMessage(
                                                                                          ));
                                                                                  e.
                                                                                    printStackTrace(
                                                                                      );
                                                                                  return false;
                                                                              }
                                                                          }
                                                                          else
                                                                              if (p.
                                                                                    peekNextToken(
                                                                                      "id")) {
                                                                                  api.
                                                                                    shader(
                                                                                      name,
                                                                                      new org.sunflow.core.shader.IDShader(
                                                                                        ));
                                                                              }
                                                                              else
                                                                                  if (p.
                                                                                        peekNextToken(
                                                                                          "uber")) {
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "diff"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "diffuse",
                                                                                              parseColor(
                                                                                                ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "diff.texture"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "diffuse.texture",
                                                                                              p.
                                                                                                getNextToken(
                                                                                                  ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "diff.blend"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "diffuse.blend",
                                                                                              p.
                                                                                                getNextFloat(
                                                                                                  ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "refl") ||
                                                                                            p.
                                                                                            peekNextToken(
                                                                                              "spec"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "specular",
                                                                                              parseColor(
                                                                                                ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "texture")) {
                                                                                          org.sunflow.system.UI.
                                                                                            printWarning(
                                                                                              org.sunflow.system.UI.Module.
                                                                                                API,
                                                                                              ("Deprecated uber shader parameter \"texture\" - please use \"" +
                                                                                               "diffuse.texture\" and \"diffuse.blend\" instead"));
                                                                                          api.
                                                                                            parameter(
                                                                                              "diffuse.texture",
                                                                                              p.
                                                                                                getNextToken(
                                                                                                  ));
                                                                                          api.
                                                                                            parameter(
                                                                                              "diffuse.blend",
                                                                                              p.
                                                                                                getNextFloat(
                                                                                                  ));
                                                                                      }
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "spec.texture"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "specular.texture",
                                                                                              p.
                                                                                                getNextToken(
                                                                                                  ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "spec.blend"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "specular.blend",
                                                                                              p.
                                                                                                getNextFloat(
                                                                                                  ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "glossy"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "glossyness",
                                                                                              p.
                                                                                                getNextFloat(
                                                                                                  ));
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "samples"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "samples",
                                                                                              p.
                                                                                                getNextInt(
                                                                                                  ));
                                                                                      api.
                                                                                        shader(
                                                                                          name,
                                                                                          new org.sunflow.core.shader.UberShader(
                                                                                            ));
                                                                                  }
                                                                                  else
                                                                                      org.sunflow.system.UI.
                                                                                        printWarning(
                                                                                          org.sunflow.system.UI.Module.
                                                                                            API,
                                                                                          "Unrecognized shader type: %s",
                                                                                          p.
                                                                                            getNextToken(
                                                                                              ));
                              p.checkNextToken(
                                  "}");
                              return true;
    }
    private boolean parseModifier(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "name");
                              java.lang.String name =
                                p.
                                getNextToken(
                                  );
                              org.sunflow.system.UI.
                                printInfo(
                                  org.sunflow.system.UI.Module.
                                    API,
                                  "Reading shader: %s ...",
                                  name);
                              p.checkNextToken(
                                  "type");
                              if (p.peekNextToken(
                                      "bump")) {
                                  p.
                                    checkNextToken(
                                      "texture");
                                  api.
                                    parameter(
                                      "texture",
                                      p.
                                        getNextToken(
                                          ));
                                  p.
                                    checkNextToken(
                                      "scale");
                                  api.
                                    parameter(
                                      "scale",
                                      p.
                                        getNextFloat(
                                          ));
                                  api.
                                    modifier(
                                      name,
                                      new org.sunflow.core.modifiers.BumpMappingModifier(
                                        ));
                              }
                              else
                                  if (p.
                                        peekNextToken(
                                          "normalmap")) {
                                      p.
                                        checkNextToken(
                                          "texture");
                                      api.
                                        parameter(
                                          "texture",
                                          p.
                                            getNextToken(
                                              ));
                                      api.
                                        modifier(
                                          name,
                                          new org.sunflow.core.modifiers.NormalMapModifier(
                                            ));
                                  }
                                  else {
                                      org.sunflow.system.UI.
                                        printWarning(
                                          org.sunflow.system.UI.Module.
                                            API,
                                          "Unrecognized modifier type: %s",
                                          p.
                                            getNextToken(
                                              ));
                                  }
                              p.checkNextToken(
                                  "}");
                              return true;
    }
    private void parseObjectBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              boolean noInstance =
                                false;
                              org.sunflow.math.Matrix4 transform =
                                null;
                              java.lang.String name =
                                null;
                              java.lang.String[] shaders =
                                null;
                              java.lang.String[] modifiers =
                                null;
                              if (p.peekNextToken(
                                      "noinstance")) {
                                  noInstance =
                                    true;
                              }
                              else {
                                  if (p.
                                        peekNextToken(
                                          "shaders")) {
                                      int n =
                                        p.
                                        getNextInt(
                                          );
                                      shaders =
                                        (new java.lang.String[n]);
                                      for (int i =
                                             0;
                                           i <
                                             n;
                                           i++)
                                          shaders[i] =
                                            p.
                                              getNextToken(
                                                );
                                  }
                                  else {
                                      p.
                                        checkNextToken(
                                          "shader");
                                      shaders =
                                        (new java.lang.String[] { p.
                                           getNextToken(
                                             ) });
                                  }
                                  if (p.
                                        peekNextToken(
                                          "modifiers")) {
                                      int n =
                                        p.
                                        getNextInt(
                                          );
                                      modifiers =
                                        (new java.lang.String[n]);
                                      for (int i =
                                             0;
                                           i <
                                             n;
                                           i++)
                                          modifiers[i] =
                                            p.
                                              getNextToken(
                                                );
                                  }
                                  else
                                      if (p.
                                            peekNextToken(
                                              "modifier"))
                                          modifiers =
                                            (new java.lang.String[] { p.
                                               getNextToken(
                                                 ) });
                                  if (p.
                                        peekNextToken(
                                          "transform"))
                                      transform =
                                        parseMatrix(
                                          );
                              }
                              if (p.peekNextToken(
                                      "accel"))
                                  api.
                                    parameter(
                                      "accel",
                                      p.
                                        getNextToken(
                                          ));
                              p.checkNextToken(
                                  "type");
                              java.lang.String type =
                                p.
                                getNextToken(
                                  );
                              if (p.peekNextToken(
                                      "name"))
                                  name =
                                    p.
                                      getNextToken(
                                        );
                              else
                                  name =
                                    api.
                                      getUniqueName(
                                        type);
                              if (type.equals(
                                         "mesh")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Deprecated object type: mesh");
                                  org.sunflow.system.UI.
                                    printInfo(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Reading mesh: %s ...",
                                      name);
                                  int numVertices =
                                    p.
                                    getNextInt(
                                      );
                                  int numTriangles =
                                    p.
                                    getNextInt(
                                      );
                                  float[] points =
                                    new float[numVertices *
                                                3];
                                  float[] normals =
                                    new float[numVertices *
                                                3];
                                  float[] uvs =
                                    new float[numVertices *
                                                2];
                                  for (int i =
                                         0;
                                       i <
                                         numVertices;
                                       i++) {
                                      p.
                                        checkNextToken(
                                          "v");
                                      points[3 *
                                               i +
                                               0] =
                                        p.
                                          getNextFloat(
                                            );
                                      points[3 *
                                               i +
                                               1] =
                                        p.
                                          getNextFloat(
                                            );
                                      points[3 *
                                               i +
                                               2] =
                                        p.
                                          getNextFloat(
                                            );
                                      normals[3 *
                                                i +
                                                0] =
                                        p.
                                          getNextFloat(
                                            );
                                      normals[3 *
                                                i +
                                                1] =
                                        p.
                                          getNextFloat(
                                            );
                                      normals[3 *
                                                i +
                                                2] =
                                        p.
                                          getNextFloat(
                                            );
                                      uvs[2 *
                                            i +
                                            0] =
                                        p.
                                          getNextFloat(
                                            );
                                      uvs[2 *
                                            i +
                                            1] =
                                        p.
                                          getNextFloat(
                                            );
                                  }
                                  int[] triangles =
                                    new int[numTriangles *
                                              3];
                                  for (int i =
                                         0;
                                       i <
                                         numTriangles;
                                       i++) {
                                      p.
                                        checkNextToken(
                                          "t");
                                      triangles[i *
                                                  3 +
                                                  0] =
                                        p.
                                          getNextInt(
                                            );
                                      triangles[i *
                                                  3 +
                                                  1] =
                                        p.
                                          getNextInt(
                                            );
                                      triangles[i *
                                                  3 +
                                                  2] =
                                        p.
                                          getNextInt(
                                            );
                                  }
                                  api.
                                    parameter(
                                      "triangles",
                                      triangles);
                                  api.
                                    parameter(
                                      "points",
                                      "point",
                                      "vertex",
                                      points);
                                  api.
                                    parameter(
                                      "normals",
                                      "vector",
                                      "vertex",
                                      normals);
                                  api.
                                    parameter(
                                      "uvs",
                                      "texcoord",
                                      "vertex",
                                      uvs);
                                  api.
                                    geometry(
                                      name,
                                      new org.sunflow.core.primitive.TriangleMesh(
                                        ));
                              }
                              else
                                  if (type.
                                        equals(
                                          "flat-mesh")) {
                                      org.sunflow.system.UI.
                                        printWarning(
                                          org.sunflow.system.UI.Module.
                                            API,
                                          "Deprecated object type: flat-mesh");
                                      org.sunflow.system.UI.
                                        printInfo(
                                          org.sunflow.system.UI.Module.
                                            API,
                                          "Reading flat mesh: %s ...",
                                          name);
                                      int numVertices =
                                        p.
                                        getNextInt(
                                          );
                                      int numTriangles =
                                        p.
                                        getNextInt(
                                          );
                                      float[] points =
                                        new float[numVertices *
                                                    3];
                                      float[] uvs =
                                        new float[numVertices *
                                                    2];
                                      for (int i =
                                             0;
                                           i <
                                             numVertices;
                                           i++) {
                                          p.
                                            checkNextToken(
                                              "v");
                                          points[3 *
                                                   i +
                                                   0] =
                                            p.
                                              getNextFloat(
                                                );
                                          points[3 *
                                                   i +
                                                   1] =
                                            p.
                                              getNextFloat(
                                                );
                                          points[3 *
                                                   i +
                                                   2] =
                                            p.
                                              getNextFloat(
                                                );
                                          p.
                                            getNextFloat(
                                              );
                                          p.
                                            getNextFloat(
                                              );
                                          p.
                                            getNextFloat(
                                              );
                                          uvs[2 *
                                                i +
                                                0] =
                                            p.
                                              getNextFloat(
                                                );
                                          uvs[2 *
                                                i +
                                                1] =
                                            p.
                                              getNextFloat(
                                                );
                                      }
                                      int[] triangles =
                                        new int[numTriangles *
                                                  3];
                                      for (int i =
                                             0;
                                           i <
                                             numTriangles;
                                           i++) {
                                          p.
                                            checkNextToken(
                                              "t");
                                          triangles[i *
                                                      3 +
                                                      0] =
                                            p.
                                              getNextInt(
                                                );
                                          triangles[i *
                                                      3 +
                                                      1] =
                                            p.
                                              getNextInt(
                                                );
                                          triangles[i *
                                                      3 +
                                                      2] =
                                            p.
                                              getNextInt(
                                                );
                                      }
                                      api.
                                        parameter(
                                          "triangles",
                                          triangles);
                                      api.
                                        parameter(
                                          "points",
                                          "point",
                                          "vertex",
                                          points);
                                      api.
                                        parameter(
                                          "uvs",
                                          "texcoord",
                                          "vertex",
                                          uvs);
                                      api.
                                        geometry(
                                          name,
                                          new org.sunflow.core.primitive.TriangleMesh(
                                            ));
                                  }
                                  else
                                      if (type.
                                            equals(
                                              "sphere")) {
                                          org.sunflow.system.UI.
                                            printInfo(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "Reading sphere ...");
                                          api.
                                            geometry(
                                              name,
                                              new org.sunflow.core.primitive.Sphere(
                                                ));
                                          if (transform ==
                                                null &&
                                                !noInstance) {
                                              p.
                                                checkNextToken(
                                                  "c");
                                              float x =
                                                p.
                                                getNextFloat(
                                                  );
                                              float y =
                                                p.
                                                getNextFloat(
                                                  );
                                              float z =
                                                p.
                                                getNextFloat(
                                                  );
                                              p.
                                                checkNextToken(
                                                  "r");
                                              float radius =
                                                p.
                                                getNextFloat(
                                                  );
                                              api.
                                                parameter(
                                                  "transform",
                                                  org.sunflow.math.Matrix4.
                                                    translation(
                                                      x,
                                                      y,
                                                      z).
                                                    multiply(
                                                      org.sunflow.math.Matrix4.
                                                        scale(
                                                          radius)));
                                              api.
                                                parameter(
                                                  "shaders",
                                                  shaders);
                                              if (modifiers !=
                                                    null)
                                                  api.
                                                    parameter(
                                                      "modifiers",
                                                      modifiers);
                                              api.
                                                instance(
                                                  name +
                                                  ".instance",
                                                  name);
                                              noInstance =
                                                true;
                                          }
                                      }
                                      else
                                          if (type.
                                                equals(
                                                  "banchoff")) {
                                              org.sunflow.system.UI.
                                                printInfo(
                                                  org.sunflow.system.UI.Module.
                                                    API,
                                                  "Reading banchoff ...");
                                              api.
                                                geometry(
                                                  name,
                                                  new org.sunflow.core.primitive.BanchoffSurface(
                                                    ));
                                          }
                                          else
                                              if (type.
                                                    equals(
                                                      "torus")) {
                                                  org.sunflow.system.UI.
                                                    printInfo(
                                                      org.sunflow.system.UI.Module.
                                                        API,
                                                      "Reading torus ...");
                                                  p.
                                                    checkNextToken(
                                                      "r");
                                                  api.
                                                    parameter(
                                                      "radiusInner",
                                                      p.
                                                        getNextFloat(
                                                          ));
                                                  api.
                                                    parameter(
                                                      "radiusOuter",
                                                      p.
                                                        getNextFloat(
                                                          ));
                                                  api.
                                                    geometry(
                                                      name,
                                                      new org.sunflow.core.primitive.Torus(
                                                        ));
                                              }
                                              else
                                                  if (type.
                                                        equals(
                                                          "plane")) {
                                                      org.sunflow.system.UI.
                                                        printInfo(
                                                          org.sunflow.system.UI.Module.
                                                            API,
                                                          "Reading plane ...");
                                                      p.
                                                        checkNextToken(
                                                          "p");
                                                      api.
                                                        parameter(
                                                          "center",
                                                          parsePoint(
                                                            ));
                                                      if (p.
                                                            peekNextToken(
                                                              "n")) {
                                                          api.
                                                            parameter(
                                                              "normal",
                                                              parseVector(
                                                                ));
                                                      }
                                                      else {
                                                          p.
                                                            checkNextToken(
                                                              "p");
                                                          api.
                                                            parameter(
                                                              "point1",
                                                              parsePoint(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "p");
                                                          api.
                                                            parameter(
                                                              "point2",
                                                              parsePoint(
                                                                ));
                                                      }
                                                      api.
                                                        geometry(
                                                          name,
                                                          new org.sunflow.core.primitive.Plane(
                                                            ));
                                                  }
                                                  else
                                                      if (type.
                                                            equals(
                                                              "cornellbox")) {
                                                          org.sunflow.system.UI.
                                                            printInfo(
                                                              org.sunflow.system.UI.Module.
                                                                API,
                                                              "Reading cornell box ...");
                                                          if (transform !=
                                                                null)
                                                              org.sunflow.system.UI.
                                                                printWarning(
                                                                  org.sunflow.system.UI.Module.
                                                                    API,
                                                                  ("Instancing is not supported on cornell box -- ignoring trans" +
                                                                   "form"));
                                                          p.
                                                            checkNextToken(
                                                              "corner0");
                                                          api.
                                                            parameter(
                                                              "corner0",
                                                              parsePoint(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "corner1");
                                                          api.
                                                            parameter(
                                                              "corner1",
                                                              parsePoint(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "left");
                                                          api.
                                                            parameter(
                                                              "leftColor",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "right");
                                                          api.
                                                            parameter(
                                                              "rightColor",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "top");
                                                          api.
                                                            parameter(
                                                              "topColor",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "bottom");
                                                          api.
                                                            parameter(
                                                              "bottomColor",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "back");
                                                          api.
                                                            parameter(
                                                              "backColor",
                                                              parseColor(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "emit");
                                                          api.
                                                            parameter(
                                                              "radiance",
                                                              parseColor(
                                                                ));
                                                          if (p.
                                                                peekNextToken(
                                                                  "samples"))
                                                              api.
                                                                parameter(
                                                                  "samples",
                                                                  p.
                                                                    getNextInt(
                                                                      ));
                                                          new org.sunflow.core.primitive.CornellBox(
                                                            ).
                                                            init(
                                                              name,
                                                              api);
                                                          noInstance =
                                                            true;
                                                      }
                                                      else
                                                          if (type.
                                                                equals(
                                                                  "generic-mesh")) {
                                                              org.sunflow.system.UI.
                                                                printInfo(
                                                                  org.sunflow.system.UI.Module.
                                                                    API,
                                                                  "Reading generic mesh: %s ... ",
                                                                  name);
                                                              p.
                                                                checkNextToken(
                                                                  "points");
                                                              int np =
                                                                p.
                                                                getNextInt(
                                                                  );
                                                              api.
                                                                parameter(
                                                                  "points",
                                                                  "point",
                                                                  "vertex",
                                                                  parseFloatArray(
                                                                    np *
                                                                      3));
                                                              p.
                                                                checkNextToken(
                                                                  "triangles");
                                                              int nt =
                                                                p.
                                                                getNextInt(
                                                                  );
                                                              api.
                                                                parameter(
                                                                  "triangles",
                                                                  parseIntArray(
                                                                    nt *
                                                                      3));
                                                              p.
                                                                checkNextToken(
                                                                  "normals");
                                                              if (p.
                                                                    peekNextToken(
                                                                      "vertex"))
                                                                  api.
                                                                    parameter(
                                                                      "normals",
                                                                      "vector",
                                                                      "vertex",
                                                                      parseFloatArray(
                                                                        np *
                                                                          3));
                                                              else
                                                                  if (p.
                                                                        peekNextToken(
                                                                          "facevarying"))
                                                                      api.
                                                                        parameter(
                                                                          "normals",
                                                                          "vector",
                                                                          "facevarying",
                                                                          parseFloatArray(
                                                                            nt *
                                                                              9));
                                                                  else
                                                                      p.
                                                                        checkNextToken(
                                                                          "none");
                                                              p.
                                                                checkNextToken(
                                                                  "uvs");
                                                              if (p.
                                                                    peekNextToken(
                                                                      "vertex"))
                                                                  api.
                                                                    parameter(
                                                                      "uvs",
                                                                      "texcoord",
                                                                      "vertex",
                                                                      parseFloatArray(
                                                                        np *
                                                                          2));
                                                              else
                                                                  if (p.
                                                                        peekNextToken(
                                                                          "facevarying"))
                                                                      api.
                                                                        parameter(
                                                                          "uvs",
                                                                          "texcoord",
                                                                          "facevarying",
                                                                          parseFloatArray(
                                                                            nt *
                                                                              6));
                                                                  else
                                                                      p.
                                                                        checkNextToken(
                                                                          "none");
                                                              if (p.
                                                                    peekNextToken(
                                                                      "face_shaders"))
                                                                  api.
                                                                    parameter(
                                                                      "faceshaders",
                                                                      parseIntArray(
                                                                        nt));
                                                              api.
                                                                geometry(
                                                                  name,
                                                                  new org.sunflow.core.primitive.TriangleMesh(
                                                                    ));
                                                          }
                                                          else
                                                              if (type.
                                                                    equals(
                                                                      "hair")) {
                                                                  org.sunflow.system.UI.
                                                                    printInfo(
                                                                      org.sunflow.system.UI.Module.
                                                                        API,
                                                                      "Reading hair curves: %s ... ",
                                                                      name);
                                                                  p.
                                                                    checkNextToken(
                                                                      "segments");
                                                                  api.
                                                                    parameter(
                                                                      "segments",
                                                                      p.
                                                                        getNextInt(
                                                                          ));
                                                                  p.
                                                                    checkNextToken(
                                                                      "width");
                                                                  api.
                                                                    parameter(
                                                                      "widths",
                                                                      p.
                                                                        getNextFloat(
                                                                          ));
                                                                  p.
                                                                    checkNextToken(
                                                                      "points");
                                                                  api.
                                                                    parameter(
                                                                      "points",
                                                                      "point",
                                                                      "vertex",
                                                                      parseFloatArray(
                                                                        p.
                                                                          getNextInt(
                                                                            )));
                                                                  api.
                                                                    geometry(
                                                                      name,
                                                                      new org.sunflow.core.primitive.Hair(
                                                                        ));
                                                              }
                                                              else
                                                                  if (type.
                                                                        equals(
                                                                          "janino-tesselatable")) {
                                                                      org.sunflow.system.UI.
                                                                        printInfo(
                                                                          org.sunflow.system.UI.Module.
                                                                            API,
                                                                          "Reading procedural primitive: %s ... ",
                                                                          name);
                                                                      java.lang.String code =
                                                                        p.
                                                                        getNextCodeBlock(
                                                                          );
                                                                      try {
                                                                          org.sunflow.core.Tesselatable tess =
                                                                            (org.sunflow.core.Tesselatable)
                                                                              org.codehaus.janino.ClassBodyEvaluator.
                                                                              createFastClassBodyEvaluator(
                                                                                new org.codehaus.janino.Scanner(
                                                                                  null,
                                                                                  new java.io.StringReader(
                                                                                    code)),
                                                                                org.sunflow.core.Tesselatable.class,
                                                                                java.lang.ClassLoader.
                                                                                  getSystemClassLoader(
                                                                                    ));
                                                                          api.
                                                                            geometry(
                                                                              name,
                                                                              tess);
                                                                      }
                                                                      catch (org.codehaus.janino.CompileException e) {
                                                                          org.sunflow.system.UI.
                                                                            printDetailed(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "Compiling: %s",
                                                                              code);
                                                                          org.sunflow.system.UI.
                                                                            printError(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "%s",
                                                                              e.
                                                                                getMessage(
                                                                                  ));
                                                                          e.
                                                                            printStackTrace(
                                                                              );
                                                                          noInstance =
                                                                            true;
                                                                      }
                                                                      catch (org.codehaus.janino.Parser.ParseException e) {
                                                                          org.sunflow.system.UI.
                                                                            printDetailed(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "Compiling: %s",
                                                                              code);
                                                                          org.sunflow.system.UI.
                                                                            printError(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "%s",
                                                                              e.
                                                                                getMessage(
                                                                                  ));
                                                                          e.
                                                                            printStackTrace(
                                                                              );
                                                                          noInstance =
                                                                            true;
                                                                      }
                                                                      catch (org.codehaus.janino.Scanner.ScanException e) {
                                                                          org.sunflow.system.UI.
                                                                            printDetailed(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "Compiling: %s",
                                                                              code);
                                                                          org.sunflow.system.UI.
                                                                            printError(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "%s",
                                                                              e.
                                                                                getMessage(
                                                                                  ));
                                                                          e.
                                                                            printStackTrace(
                                                                              );
                                                                          noInstance =
                                                                            true;
                                                                      }
                                                                      catch (java.io.IOException e) {
                                                                          org.sunflow.system.UI.
                                                                            printDetailed(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "Compiling: %s",
                                                                              code);
                                                                          org.sunflow.system.UI.
                                                                            printError(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "%s",
                                                                              e.
                                                                                getMessage(
                                                                                  ));
                                                                          e.
                                                                            printStackTrace(
                                                                              );
                                                                          noInstance =
                                                                            true;
                                                                      }
                                                                  }
                                                                  else
                                                                      if (type.
                                                                            equals(
                                                                              "teapot")) {
                                                                          org.sunflow.system.UI.
                                                                            printInfo(
                                                                              org.sunflow.system.UI.Module.
                                                                                API,
                                                                              "Reading teapot: %s ... ",
                                                                              name);
                                                                          boolean hasTesselationArguments =
                                                                            false;
                                                                          if (p.
                                                                                peekNextToken(
                                                                                  "subdivs")) {
                                                                              api.
                                                                                parameter(
                                                                                  "subdivs",
                                                                                  p.
                                                                                    getNextInt(
                                                                                      ));
                                                                              hasTesselationArguments =
                                                                                true;
                                                                          }
                                                                          if (p.
                                                                                peekNextToken(
                                                                                  "smooth")) {
                                                                              api.
                                                                                parameter(
                                                                                  "smooth",
                                                                                  p.
                                                                                    getNextBoolean(
                                                                                      ));
                                                                              hasTesselationArguments =
                                                                                true;
                                                                          }
                                                                          if (hasTesselationArguments)
                                                                              api.
                                                                                geometry(
                                                                                  name,
                                                                                  (org.sunflow.core.Tesselatable)
                                                                                    new org.sunflow.core.tesselatable.Teapot(
                                                                                    ));
                                                                          else
                                                                              api.
                                                                                geometry(
                                                                                  name,
                                                                                  (org.sunflow.core.PrimitiveList)
                                                                                    new org.sunflow.core.tesselatable.Teapot(
                                                                                    ));
                                                                      }
                                                                      else
                                                                          if (type.
                                                                                equals(
                                                                                  "gumbo")) {
                                                                              org.sunflow.system.UI.
                                                                                printInfo(
                                                                                  org.sunflow.system.UI.Module.
                                                                                    API,
                                                                                  "Reading gumbo: %s ... ",
                                                                                  name);
                                                                              boolean hasTesselationArguments =
                                                                                false;
                                                                              if (p.
                                                                                    peekNextToken(
                                                                                      "subdivs")) {
                                                                                  api.
                                                                                    parameter(
                                                                                      "subdivs",
                                                                                      p.
                                                                                        getNextInt(
                                                                                          ));
                                                                                  hasTesselationArguments =
                                                                                    true;
                                                                              }
                                                                              if (p.
                                                                                    peekNextToken(
                                                                                      "smooth")) {
                                                                                  api.
                                                                                    parameter(
                                                                                      "smooth",
                                                                                      p.
                                                                                        getNextBoolean(
                                                                                          ));
                                                                                  hasTesselationArguments =
                                                                                    true;
                                                                              }
                                                                              if (hasTesselationArguments)
                                                                                  api.
                                                                                    geometry(
                                                                                      name,
                                                                                      (org.sunflow.core.Tesselatable)
                                                                                        new org.sunflow.core.tesselatable.Gumbo(
                                                                                        ));
                                                                              else
                                                                                  api.
                                                                                    geometry(
                                                                                      name,
                                                                                      (org.sunflow.core.PrimitiveList)
                                                                                        new org.sunflow.core.tesselatable.Gumbo(
                                                                                        ));
                                                                          }
                                                                          else
                                                                              if (type.
                                                                                    equals(
                                                                                      "julia")) {
                                                                                  org.sunflow.system.UI.
                                                                                    printInfo(
                                                                                      org.sunflow.system.UI.Module.
                                                                                        API,
                                                                                      "Reading julia fractal: %s ... ",
                                                                                      name);
                                                                                  if (p.
                                                                                        peekNextToken(
                                                                                          "q")) {
                                                                                      api.
                                                                                        parameter(
                                                                                          "cw",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                      api.
                                                                                        parameter(
                                                                                          "cx",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                      api.
                                                                                        parameter(
                                                                                          "cy",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                      api.
                                                                                        parameter(
                                                                                          "cz",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                  }
                                                                                  if (p.
                                                                                        peekNextToken(
                                                                                          "iterations"))
                                                                                      api.
                                                                                        parameter(
                                                                                          "iterations",
                                                                                          p.
                                                                                            getNextInt(
                                                                                              ));
                                                                                  if (p.
                                                                                        peekNextToken(
                                                                                          "epsilon"))
                                                                                      api.
                                                                                        parameter(
                                                                                          "epsilon",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                  api.
                                                                                    geometry(
                                                                                      name,
                                                                                      new org.sunflow.core.primitive.JuliaFractal(
                                                                                        ));
                                                                              }
                                                                              else
                                                                                  if (type.
                                                                                        equals(
                                                                                          "particles") ||
                                                                                        type.
                                                                                        equals(
                                                                                          "dlasurface")) {
                                                                                      if (type.
                                                                                            equals(
                                                                                              "dlasurface"))
                                                                                          org.sunflow.system.UI.
                                                                                            printWarning(
                                                                                              org.sunflow.system.UI.Module.
                                                                                                API,
                                                                                              ("Deprecated object type: \"dlasurface\" - please use \"partic" +
                                                                                               "les\" instead"));
                                                                                      p.
                                                                                        checkNextToken(
                                                                                          "filename");
                                                                                      java.lang.String filename =
                                                                                        p.
                                                                                        getNextToken(
                                                                                          );
                                                                                      boolean littleEndian =
                                                                                        false;
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "little_endian"))
                                                                                          littleEndian =
                                                                                            true;
                                                                                      org.sunflow.system.UI.
                                                                                        printInfo(
                                                                                          org.sunflow.system.UI.Module.
                                                                                            USER,
                                                                                          "Loading particle file: %s",
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
                                                                                      if (littleEndian)
                                                                                          map.
                                                                                            order(
                                                                                              java.nio.ByteOrder.
                                                                                                LITTLE_ENDIAN);
                                                                                      java.nio.FloatBuffer buffer =
                                                                                        map.
                                                                                        asFloatBuffer(
                                                                                          );
                                                                                      float[] data =
                                                                                        new float[buffer.
                                                                                                    capacity(
                                                                                                      )];
                                                                                      for (int i =
                                                                                             0;
                                                                                           i <
                                                                                             data.
                                                                                               length;
                                                                                           i++)
                                                                                          data[i] =
                                                                                            buffer.
                                                                                              get(
                                                                                                i);
                                                                                      stream.
                                                                                        close(
                                                                                          );
                                                                                      api.
                                                                                        parameter(
                                                                                          "particles",
                                                                                          "point",
                                                                                          "vertex",
                                                                                          data);
                                                                                      if (p.
                                                                                            peekNextToken(
                                                                                              "num"))
                                                                                          api.
                                                                                            parameter(
                                                                                              "num",
                                                                                              p.
                                                                                                getNextInt(
                                                                                                  ));
                                                                                      else
                                                                                          api.
                                                                                            parameter(
                                                                                              "num",
                                                                                              data.
                                                                                                length /
                                                                                                3);
                                                                                      p.
                                                                                        checkNextToken(
                                                                                          "radius");
                                                                                      api.
                                                                                        parameter(
                                                                                          "radius",
                                                                                          p.
                                                                                            getNextFloat(
                                                                                              ));
                                                                                      api.
                                                                                        geometry(
                                                                                          name,
                                                                                          new org.sunflow.core.primitive.ParticleSurface(
                                                                                            ));
                                                                                  }
                                                                                  else
                                                                                      if (type.
                                                                                            equals(
                                                                                              "file-mesh")) {
                                                                                          org.sunflow.system.UI.
                                                                                            printInfo(
                                                                                              org.sunflow.system.UI.Module.
                                                                                                API,
                                                                                              "Reading file mesh: %s ... ",
                                                                                              name);
                                                                                          p.
                                                                                            checkNextToken(
                                                                                              "filename");
                                                                                          api.
                                                                                            parameter(
                                                                                              "filename",
                                                                                              p.
                                                                                                getNextToken(
                                                                                                  ));
                                                                                          if (p.
                                                                                                peekNextToken(
                                                                                                  "smooth_normals"))
                                                                                              api.
                                                                                                parameter(
                                                                                                  "smooth_normals",
                                                                                                  p.
                                                                                                    getNextBoolean(
                                                                                                      ));
                                                                                          api.
                                                                                            geometry(
                                                                                              name,
                                                                                              new org.sunflow.core.tesselatable.FileMesh(
                                                                                                ));
                                                                                      }
                                                                                      else
                                                                                          if (type.
                                                                                                equals(
                                                                                                  "bezier-mesh")) {
                                                                                              org.sunflow.system.UI.
                                                                                                printInfo(
                                                                                                  org.sunflow.system.UI.Module.
                                                                                                    API,
                                                                                                  "Reading bezier mesh: %s ... ",
                                                                                                  name);
                                                                                              p.
                                                                                                checkNextToken(
                                                                                                  "n");
                                                                                              int nu;
                                                                                              int nv;
                                                                                              api.
                                                                                                parameter(
                                                                                                  "nu",
                                                                                                  nu =
                                                                                                    p.
                                                                                                      getNextInt(
                                                                                                        ));
                                                                                              api.
                                                                                                parameter(
                                                                                                  "nv",
                                                                                                  nv =
                                                                                                    p.
                                                                                                      getNextInt(
                                                                                                        ));
                                                                                              if (p.
                                                                                                    peekNextToken(
                                                                                                      "wrap")) {
                                                                                                  api.
                                                                                                    parameter(
                                                                                                      "uwrap",
                                                                                                      p.
                                                                                                        getNextBoolean(
                                                                                                          ));
                                                                                                  api.
                                                                                                    parameter(
                                                                                                      "vwrap",
                                                                                                      p.
                                                                                                        getNextBoolean(
                                                                                                          ));
                                                                                              }
                                                                                              p.
                                                                                                checkNextToken(
                                                                                                  "points");
                                                                                              float[] points =
                                                                                                new float[3 *
                                                                                                            nu *
                                                                                                            nv];
                                                                                              for (int i =
                                                                                                     0;
                                                                                                   i <
                                                                                                     points.
                                                                                                       length;
                                                                                                   i++)
                                                                                                  points[i] =
                                                                                                    p.
                                                                                                      getNextFloat(
                                                                                                        );
                                                                                              api.
                                                                                                parameter(
                                                                                                  "points",
                                                                                                  "point",
                                                                                                  "vertex",
                                                                                                  points);
                                                                                              if (p.
                                                                                                    peekNextToken(
                                                                                                      "subdivs"))
                                                                                                  api.
                                                                                                    parameter(
                                                                                                      "subdivs",
                                                                                                      p.
                                                                                                        getNextInt(
                                                                                                          ));
                                                                                              if (p.
                                                                                                    peekNextToken(
                                                                                                      "smooth"))
                                                                                                  api.
                                                                                                    parameter(
                                                                                                      "smooth",
                                                                                                      p.
                                                                                                        getNextBoolean(
                                                                                                          ));
                                                                                              api.
                                                                                                geometry(
                                                                                                  name,
                                                                                                  (org.sunflow.core.Tesselatable)
                                                                                                    new org.sunflow.core.tesselatable.BezierMesh(
                                                                                                    ));
                                                                                          }
                                                                                          else {
                                                                                              org.sunflow.system.UI.
                                                                                                printWarning(
                                                                                                  org.sunflow.system.UI.Module.
                                                                                                    API,
                                                                                                  "Unrecognized object type: %s",
                                                                                                  p.
                                                                                                    getNextToken(
                                                                                                      ));
                                                                                              noInstance =
                                                                                                true;
                                                                                          }
                              if (!noInstance) {
                                  api.
                                    parameter(
                                      "shaders",
                                      shaders);
                                  if (modifiers !=
                                        null)
                                      api.
                                        parameter(
                                          "modifiers",
                                          modifiers);
                                  if (transform !=
                                        null)
                                      api.
                                        parameter(
                                          "transform",
                                          transform);
                                  api.
                                    instance(
                                      name +
                                      ".instance",
                                      name);
                              }
                              p.checkNextToken(
                                  "}"); }
    private void parseInstanceBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "name");
                              java.lang.String name =
                                p.
                                getNextToken(
                                  );
                              org.sunflow.system.UI.
                                printInfo(
                                  org.sunflow.system.UI.Module.
                                    API,
                                  "Reading instance: %s ...",
                                  name);
                              p.checkNextToken(
                                  "geometry");
                              java.lang.String geoname =
                                p.
                                getNextToken(
                                  );
                              p.checkNextToken(
                                  "transform");
                              api.parameter(
                                    "transform",
                                    parseMatrix(
                                      ));
                              java.lang.String[] shaders;
                              if (p.peekNextToken(
                                      "shaders")) {
                                  int n =
                                    p.
                                    getNextInt(
                                      );
                                  shaders =
                                    (new java.lang.String[n]);
                                  for (int i =
                                         0;
                                       i <
                                         n;
                                       i++)
                                      shaders[i] =
                                        p.
                                          getNextToken(
                                            );
                              }
                              else {
                                  p.
                                    checkNextToken(
                                      "shader");
                                  shaders =
                                    (new java.lang.String[] { p.
                                       getNextToken(
                                         ) });
                              }
                              api.parameter(
                                    "shaders",
                                    shaders);
                              java.lang.String[] modifiers =
                                null;
                              if (p.peekNextToken(
                                      "modifiers")) {
                                  int n =
                                    p.
                                    getNextInt(
                                      );
                                  modifiers =
                                    (new java.lang.String[n]);
                                  for (int i =
                                         0;
                                       i <
                                         n;
                                       i++)
                                      modifiers[i] =
                                        p.
                                          getNextToken(
                                            );
                              }
                              else
                                  if (p.
                                        peekNextToken(
                                          "modifier"))
                                      modifiers =
                                        (new java.lang.String[] { p.
                                           getNextToken(
                                             ) });
                              if (modifiers !=
                                    null)
                                  api.
                                    parameter(
                                      "modifiers",
                                      modifiers);
                              api.instance(
                                    name,
                                    geoname);
                              p.checkNextToken(
                                  "}"); }
    private void parseLightBlock(org.sunflow.SunflowAPI api)
          throws org.sunflow.system.Parser.ParserException,
        java.io.IOException { p.checkNextToken(
                                  "{");
                              p.checkNextToken(
                                  "type");
                              if (p.peekNextToken(
                                      "mesh")) {
                                  org.sunflow.system.UI.
                                    printWarning(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Deprecated light type: mesh");
                                  p.
                                    checkNextToken(
                                      "name");
                                  java.lang.String name =
                                    p.
                                    getNextToken(
                                      );
                                  org.sunflow.system.UI.
                                    printInfo(
                                      org.sunflow.system.UI.Module.
                                        API,
                                      "Reading light mesh: %s ...",
                                      name);
                                  p.
                                    checkNextToken(
                                      "emit");
                                  api.
                                    parameter(
                                      "radiance",
                                      parseColor(
                                        ));
                                  int samples =
                                    numLightSamples;
                                  if (p.
                                        peekNextToken(
                                          "samples"))
                                      samples =
                                        p.
                                          getNextInt(
                                            );
                                  else
                                      org.sunflow.system.UI.
                                        printWarning(
                                          org.sunflow.system.UI.Module.
                                            API,
                                          "Samples keyword not found - defaulting to %d",
                                          samples);
                                  api.
                                    parameter(
                                      "samples",
                                      samples);
                                  int numVertices =
                                    p.
                                    getNextInt(
                                      );
                                  int numTriangles =
                                    p.
                                    getNextInt(
                                      );
                                  float[] points =
                                    new float[3 *
                                                numVertices];
                                  int[] triangles =
                                    new int[3 *
                                              numTriangles];
                                  for (int i =
                                         0;
                                       i <
                                         numVertices;
                                       i++) {
                                      p.
                                        checkNextToken(
                                          "v");
                                      points[3 *
                                               i +
                                               0] =
                                        p.
                                          getNextFloat(
                                            );
                                      points[3 *
                                               i +
                                               1] =
                                        p.
                                          getNextFloat(
                                            );
                                      points[3 *
                                               i +
                                               2] =
                                        p.
                                          getNextFloat(
                                            );
                                      p.
                                        getNextFloat(
                                          );
                                      p.
                                        getNextFloat(
                                          );
                                      p.
                                        getNextFloat(
                                          );
                                      p.
                                        getNextFloat(
                                          );
                                      p.
                                        getNextFloat(
                                          );
                                  }
                                  for (int i =
                                         0;
                                       i <
                                         numTriangles;
                                       i++) {
                                      p.
                                        checkNextToken(
                                          "t");
                                      triangles[3 *
                                                  i +
                                                  0] =
                                        p.
                                          getNextInt(
                                            );
                                      triangles[3 *
                                                  i +
                                                  1] =
                                        p.
                                          getNextInt(
                                            );
                                      triangles[3 *
                                                  i +
                                                  2] =
                                        p.
                                          getNextInt(
                                            );
                                  }
                                  api.
                                    parameter(
                                      "points",
                                      "point",
                                      "vertex",
                                      points);
                                  api.
                                    parameter(
                                      "triangles",
                                      triangles);
                                  org.sunflow.core.light.TriangleMeshLight mesh =
                                    new org.sunflow.core.light.TriangleMeshLight(
                                    );
                                  mesh.
                                    init(
                                      name,
                                      api);
                              }
                              else
                                  if (p.
                                        peekNextToken(
                                          "point")) {
                                      org.sunflow.system.UI.
                                        printInfo(
                                          org.sunflow.system.UI.Module.
                                            API,
                                          "Reading point light ...");
                                      org.sunflow.image.Color pow;
                                      if (p.
                                            peekNextToken(
                                              "color")) {
                                          pow =
                                            parseColor(
                                              );
                                          p.
                                            checkNextToken(
                                              "power");
                                          float po =
                                            p.
                                            getNextFloat(
                                              );
                                          pow.
                                            mul(
                                              po);
                                      }
                                      else {
                                          org.sunflow.system.UI.
                                            printWarning(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              ("Deprecated color specification - please use color and power " +
                                               "instead"));
                                          p.
                                            checkNextToken(
                                              "power");
                                          pow =
                                            parseColor(
                                              );
                                      }
                                      p.
                                        checkNextToken(
                                          "p");
                                      api.
                                        parameter(
                                          "center",
                                          parsePoint(
                                            ));
                                      api.
                                        parameter(
                                          "power",
                                          pow);
                                      api.
                                        light(
                                          api.
                                            getUniqueName(
                                              "pointlight"),
                                          new org.sunflow.core.light.PointLight(
                                            ));
                                  }
                                  else
                                      if (p.
                                            peekNextToken(
                                              "spherical")) {
                                          org.sunflow.system.UI.
                                            printInfo(
                                              org.sunflow.system.UI.Module.
                                                API,
                                              "Reading spherical light ...");
                                          p.
                                            checkNextToken(
                                              "color");
                                          org.sunflow.image.Color pow =
                                            parseColor(
                                              );
                                          p.
                                            checkNextToken(
                                              "radiance");
                                          pow.
                                            mul(
                                              p.
                                                getNextFloat(
                                                  ));
                                          api.
                                            parameter(
                                              "radiance",
                                              pow);
                                          p.
                                            checkNextToken(
                                              "center");
                                          api.
                                            parameter(
                                              "center",
                                              parsePoint(
                                                ));
                                          p.
                                            checkNextToken(
                                              "radius");
                                          api.
                                            parameter(
                                              "radius",
                                              p.
                                                getNextFloat(
                                                  ));
                                          p.
                                            checkNextToken(
                                              "samples");
                                          api.
                                            parameter(
                                              "samples",
                                              p.
                                                getNextInt(
                                                  ));
                                          org.sunflow.core.light.SphereLight light =
                                            new org.sunflow.core.light.SphereLight(
                                            );
                                          light.
                                            init(
                                              api.
                                                getUniqueName(
                                                  "spherelight"),
                                              api);
                                      }
                                      else
                                          if (p.
                                                peekNextToken(
                                                  "directional")) {
                                              org.sunflow.system.UI.
                                                printInfo(
                                                  org.sunflow.system.UI.Module.
                                                    API,
                                                  "Reading directional light ...");
                                              p.
                                                checkNextToken(
                                                  "source");
                                              org.sunflow.math.Point3 s =
                                                parsePoint(
                                                  );
                                              api.
                                                parameter(
                                                  "source",
                                                  s);
                                              p.
                                                checkNextToken(
                                                  "target");
                                              org.sunflow.math.Point3 t =
                                                parsePoint(
                                                  );
                                              api.
                                                parameter(
                                                  "dir",
                                                  org.sunflow.math.Point3.
                                                    sub(
                                                      t,
                                                      s,
                                                      new org.sunflow.math.Vector3(
                                                        )));
                                              p.
                                                checkNextToken(
                                                  "radius");
                                              api.
                                                parameter(
                                                  "radius",
                                                  p.
                                                    getNextFloat(
                                                      ));
                                              p.
                                                checkNextToken(
                                                  "emit");
                                              org.sunflow.image.Color e =
                                                parseColor(
                                                  );
                                              if (p.
                                                    peekNextToken(
                                                      "intensity")) {
                                                  float i =
                                                    p.
                                                    getNextFloat(
                                                      );
                                                  e.
                                                    mul(
                                                      i);
                                              }
                                              else
                                                  org.sunflow.system.UI.
                                                    printWarning(
                                                      org.sunflow.system.UI.Module.
                                                        API,
                                                      ("Deprecated color specification - please use emit and intensi" +
                                                       "ty instead"));
                                              api.
                                                parameter(
                                                  "radiance",
                                                  e);
                                              api.
                                                light(
                                                  api.
                                                    getUniqueName(
                                                      "dirlight"),
                                                  new org.sunflow.core.light.DirectionalSpotlight(
                                                    ));
                                          }
                                          else
                                              if (p.
                                                    peekNextToken(
                                                      "ibl")) {
                                                  org.sunflow.system.UI.
                                                    printInfo(
                                                      org.sunflow.system.UI.Module.
                                                        API,
                                                      "Reading image based light ...");
                                                  p.
                                                    checkNextToken(
                                                      "image");
                                                  api.
                                                    parameter(
                                                      "texture",
                                                      p.
                                                        getNextToken(
                                                          ));
                                                  p.
                                                    checkNextToken(
                                                      "center");
                                                  api.
                                                    parameter(
                                                      "center",
                                                      parseVector(
                                                        ));
                                                  p.
                                                    checkNextToken(
                                                      "up");
                                                  api.
                                                    parameter(
                                                      "up",
                                                      parseVector(
                                                        ));
                                                  p.
                                                    checkNextToken(
                                                      "lock");
                                                  api.
                                                    parameter(
                                                      "fixed",
                                                      p.
                                                        getNextBoolean(
                                                          ));
                                                  int samples =
                                                    numLightSamples;
                                                  if (p.
                                                        peekNextToken(
                                                          "samples"))
                                                      samples =
                                                        p.
                                                          getNextInt(
                                                            );
                                                  else
                                                      org.sunflow.system.UI.
                                                        printWarning(
                                                          org.sunflow.system.UI.Module.
                                                            API,
                                                          "Samples keyword not found - defaulting to %d",
                                                          samples);
                                                  api.
                                                    parameter(
                                                      "samples",
                                                      samples);
                                                  org.sunflow.core.light.ImageBasedLight ibl =
                                                    new org.sunflow.core.light.ImageBasedLight(
                                                    );
                                                  ibl.
                                                    init(
                                                      api.
                                                        getUniqueName(
                                                          "ibl"),
                                                      api);
                                              }
                                              else
                                                  if (p.
                                                        peekNextToken(
                                                          "meshlight")) {
                                                      p.
                                                        checkNextToken(
                                                          "name");
                                                      java.lang.String name =
                                                        p.
                                                        getNextToken(
                                                          );
                                                      org.sunflow.system.UI.
                                                        printInfo(
                                                          org.sunflow.system.UI.Module.
                                                            API,
                                                          "Reading meshlight: %s ...",
                                                          name);
                                                      p.
                                                        checkNextToken(
                                                          "emit");
                                                      org.sunflow.image.Color e =
                                                        parseColor(
                                                          );
                                                      if (p.
                                                            peekNextToken(
                                                              "radiance")) {
                                                          float r =
                                                            p.
                                                            getNextFloat(
                                                              );
                                                          e.
                                                            mul(
                                                              r);
                                                      }
                                                      else
                                                          org.sunflow.system.UI.
                                                            printWarning(
                                                              org.sunflow.system.UI.Module.
                                                                API,
                                                              ("Deprecated color specification - please use emit and radianc" +
                                                               "e instead"));
                                                      api.
                                                        parameter(
                                                          "radiance",
                                                          e);
                                                      int samples =
                                                        numLightSamples;
                                                      if (p.
                                                            peekNextToken(
                                                              "samples"))
                                                          samples =
                                                            p.
                                                              getNextInt(
                                                                );
                                                      else
                                                          org.sunflow.system.UI.
                                                            printWarning(
                                                              org.sunflow.system.UI.Module.
                                                                API,
                                                              "Samples keyword not found - defaulting to %d",
                                                              samples);
                                                      api.
                                                        parameter(
                                                          "samples",
                                                          samples);
                                                      p.
                                                        checkNextToken(
                                                          "points");
                                                      int np =
                                                        p.
                                                        getNextInt(
                                                          );
                                                      api.
                                                        parameter(
                                                          "points",
                                                          "point",
                                                          "vertex",
                                                          parseFloatArray(
                                                            np *
                                                              3));
                                                      p.
                                                        checkNextToken(
                                                          "triangles");
                                                      int nt =
                                                        p.
                                                        getNextInt(
                                                          );
                                                      api.
                                                        parameter(
                                                          "triangles",
                                                          parseIntArray(
                                                            nt *
                                                              3));
                                                      org.sunflow.core.light.TriangleMeshLight mesh =
                                                        new org.sunflow.core.light.TriangleMeshLight(
                                                        );
                                                      mesh.
                                                        init(
                                                          name,
                                                          api);
                                                  }
                                                  else
                                                      if (p.
                                                            peekNextToken(
                                                              "sunsky")) {
                                                          p.
                                                            checkNextToken(
                                                              "up");
                                                          api.
                                                            parameter(
                                                              "up",
                                                              parseVector(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "east");
                                                          api.
                                                            parameter(
                                                              "east",
                                                              parseVector(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "sundir");
                                                          api.
                                                            parameter(
                                                              "sundir",
                                                              parseVector(
                                                                ));
                                                          p.
                                                            checkNextToken(
                                                              "turbidity");
                                                          api.
                                                            parameter(
                                                              "turbidity",
                                                              p.
                                                                getNextFloat(
                                                                  ));
                                                          if (p.
                                                                peekNextToken(
                                                                  "samples"))
                                                              api.
                                                                parameter(
                                                                  "samples",
                                                                  p.
                                                                    getNextInt(
                                                                      ));
                                                          org.sunflow.core.light.SunSkyLight sunsky =
                                                            new org.sunflow.core.light.SunSkyLight(
                                                            );
                                                          sunsky.
                                                            init(
                                                              api.
                                                                getUniqueName(
                                                                  "sunsky"),
                                                              api);
                                                      }
                                                      else
                                                          org.sunflow.system.UI.
                                                            printWarning(
                                                              org.sunflow.system.UI.Module.
                                                                API,
                                                              "Unrecognized object type: %s",
                                                              p.
                                                                getNextToken(
                                                                  ));
                              p.checkNextToken(
                                  "}"); }
    private org.sunflow.image.Color parseColor()
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        if (p.
              peekNextToken(
                "{")) {
            java.lang.String space =
              p.
              getNextToken(
                );
            org.sunflow.image.Color c =
              null;
            if (space.
                  equals(
                    "sRGB nonlinear")) {
                float r =
                  p.
                  getNextFloat(
                    );
                float g =
                  p.
                  getNextFloat(
                    );
                float b =
                  p.
                  getNextFloat(
                    );
                c =
                  new org.sunflow.image.Color(
                    r,
                    g,
                    b);
                c.
                  toLinear(
                    );
            }
            else
                if (space.
                      equals(
                        "sRGB linear")) {
                    float r =
                      p.
                      getNextFloat(
                        );
                    float g =
                      p.
                      getNextFloat(
                        );
                    float b =
                      p.
                      getNextFloat(
                        );
                    c =
                      new org.sunflow.image.Color(
                        r,
                        g,
                        b);
                }
                else
                    org.sunflow.system.UI.
                      printWarning(
                        org.sunflow.system.UI.Module.
                          API,
                        "Unrecognized color space: %s",
                        space);
            p.
              checkNextToken(
                "}");
            return c;
        }
        else {
            float r =
              p.
              getNextFloat(
                );
            float g =
              p.
              getNextFloat(
                );
            float b =
              p.
              getNextFloat(
                );
            return new org.sunflow.image.Color(
              r,
              g,
              b);
        }
    }
    private org.sunflow.math.Point3 parsePoint()
          throws java.io.IOException { float x =
                                         p.
                                         getNextFloat(
                                           );
                                       float y =
                                         p.
                                         getNextFloat(
                                           );
                                       float z =
                                         p.
                                         getNextFloat(
                                           );
                                       return new org.sunflow.math.Point3(
                                         x,
                                         y,
                                         z);
    }
    private org.sunflow.math.Vector3 parseVector()
          throws java.io.IOException { float x =
                                         p.
                                         getNextFloat(
                                           );
                                       float y =
                                         p.
                                         getNextFloat(
                                           );
                                       float z =
                                         p.
                                         getNextFloat(
                                           );
                                       return new org.sunflow.math.Vector3(
                                         x,
                                         y,
                                         z);
    }
    private int[] parseIntArray(int size)
          throws java.io.IOException { int[] data =
                                         new int[size];
                                       for (int i =
                                              0;
                                            i <
                                              size;
                                            i++)
                                           data[i] =
                                             p.
                                               getNextInt(
                                                 );
                                       return data;
    }
    private float[] parseFloatArray(int size)
          throws java.io.IOException { float[] data =
                                         new float[size];
                                       for (int i =
                                              0;
                                            i <
                                              size;
                                            i++)
                                           data[i] =
                                             p.
                                               getNextFloat(
                                                 );
                                       return data;
    }
    private org.sunflow.math.Matrix4 parseMatrix()
          throws java.io.IOException,
        org.sunflow.system.Parser.ParserException {
        if (p.
              peekNextToken(
                "row")) {
            return new org.sunflow.math.Matrix4(
              parseFloatArray(
                16),
              true);
        }
        else
            if (p.
                  peekNextToken(
                    "col")) {
                return new org.sunflow.math.Matrix4(
                  parseFloatArray(
                    16),
                  false);
            }
            else {
                org.sunflow.math.Matrix4 m =
                  org.sunflow.math.Matrix4.
                    IDENTITY;
                p.
                  checkNextToken(
                    "{");
                while (!p.
                         peekNextToken(
                           "}")) {
                    org.sunflow.math.Matrix4 t =
                      null;
                    if (p.
                          peekNextToken(
                            "translate")) {
                        float x =
                          p.
                          getNextFloat(
                            );
                        float y =
                          p.
                          getNextFloat(
                            );
                        float z =
                          p.
                          getNextFloat(
                            );
                        t =
                          org.sunflow.math.Matrix4.
                            translation(
                              x,
                              y,
                              z);
                    }
                    else
                        if (p.
                              peekNextToken(
                                "scaleu")) {
                            float s =
                              p.
                              getNextFloat(
                                );
                            t =
                              org.sunflow.math.Matrix4.
                                scale(
                                  s);
                        }
                        else
                            if (p.
                                  peekNextToken(
                                    "scale")) {
                                float x =
                                  p.
                                  getNextFloat(
                                    );
                                float y =
                                  p.
                                  getNextFloat(
                                    );
                                float z =
                                  p.
                                  getNextFloat(
                                    );
                                t =
                                  org.sunflow.math.Matrix4.
                                    scale(
                                      x,
                                      y,
                                      z);
                            }
                            else
                                if (p.
                                      peekNextToken(
                                        "rotatex")) {
                                    float angle =
                                      p.
                                      getNextFloat(
                                        );
                                    t =
                                      org.sunflow.math.Matrix4.
                                        rotateX(
                                          (float)
                                            java.lang.Math.
                                            toRadians(
                                              angle));
                                }
                                else
                                    if (p.
                                          peekNextToken(
                                            "rotatey")) {
                                        float angle =
                                          p.
                                          getNextFloat(
                                            );
                                        t =
                                          org.sunflow.math.Matrix4.
                                            rotateY(
                                              (float)
                                                java.lang.Math.
                                                toRadians(
                                                  angle));
                                    }
                                    else
                                        if (p.
                                              peekNextToken(
                                                "rotatez")) {
                                            float angle =
                                              p.
                                              getNextFloat(
                                                );
                                            t =
                                              org.sunflow.math.Matrix4.
                                                rotateZ(
                                                  (float)
                                                    java.lang.Math.
                                                    toRadians(
                                                      angle));
                                        }
                                        else
                                            if (p.
                                                  peekNextToken(
                                                    "rotate")) {
                                                float x =
                                                  p.
                                                  getNextFloat(
                                                    );
                                                float y =
                                                  p.
                                                  getNextFloat(
                                                    );
                                                float z =
                                                  p.
                                                  getNextFloat(
                                                    );
                                                float angle =
                                                  p.
                                                  getNextFloat(
                                                    );
                                                t =
                                                  org.sunflow.math.Matrix4.
                                                    rotate(
                                                      x,
                                                      y,
                                                      z,
                                                      (float)
                                                        java.lang.Math.
                                                        toRadians(
                                                          angle));
                                            }
                                            else
                                                org.sunflow.system.UI.
                                                  printWarning(
                                                    org.sunflow.system.UI.Module.
                                                      API,
                                                    "Unrecognized transformation type: %s",
                                                    p.
                                                      getNextToken(
                                                        ));
                    if (t !=
                          null)
                        m =
                          t.
                            multiply(
                              m);
                }
                return m;
            }
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "17pzor0HQU2vuvKeAFF8enK8V/Tlt33n");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JdzPWG/4EXbAX36qn6er/Djxyd8a/rj6z8+VbjnaObrso5hLCz156X7RXaEe" +
       "J6HHXbJr9PAR+/MN6NJD4BIP2S+e3lM5HuCzN1R+cicgp7Y8zxUZzhUish+1" +
       "B0+OGru7d+lxUf6fXmXL9Ody8k/i0m3FRw1nrZHfofi+o8vesRy+47lWyE82" +
       "Urx466X7TBVwff6QJ5//UXmCnMmTg+MM7y4y/OLZTNvza7f7bPsXx1Q/VfXg" +
       "SJZA2iuvuL/2+O52VKJo6cM5+UBculCwcOzKpt5zfHV55obD2re1Y05+8Ho5" +
       "2QDX1w85+fWbxMlPXVn8PpKTXypyfSYnvxKX7i+40JPVpRn6iacVrMjT/vUx" +
       "7I9fL+z8O6RvHcL+1k2C/R+uCfYXc/K5uPS8AvbAduLdLuwJtJ+/XrQwuL5z" +
       "iPY7Nwntl66M9pcKyEWuL+fk2bh0b4GWtvzY984a4F+/XsivAZ27fVd2d78J" +
       "kL92TZC/npOvxKW7C8jD8Vlwf+d64TZBx4aHcIc3Ce4fXxPcb+fkm3HpgQJu" +
       "sYcPDN5aD8/C/Yc3wBEcbA5xb24S7j+/Jtzfzcmf7o04F8qqfhbi/3EDLNfB" +
       "2w8Rv/0mIf6La0L8Vzn5/t5yISCqCeVTaH9wA9zTwWcP0X725qA9OLgWtAdF" +
       "5P3Xe/e0QwtG2YvybwtPwf6b64X906CDXzyE/cUbA/sEKvYY+z3X4qMOLuTk" +
       "PJhlnMBOyHFop5cCP7jzOoDfn798OcDwu4fAf/cmjfeLr2m8fywn9++lm7Vk" +
       "beeX33eM9oHrRfsoaDbeld3dbwLaJ64J7U/k5JG4dE+B9vCrl9N4H70Bcci5" +
       "9xzifc9NwgtfE95aTl69j0N2n/+dYa4PXnO9kGtgzv4/d2V395sA+aevCfJr" +
       "c9KOS/ftZhmHE9KzQHdugFe+9fyu7O5+E0CPrwn0JCfo3isX0chZiPvXgfi+" +
       "/OVLAdKPHSL+2I1BfGKSfTC7JjMt5ISOS3ftzLTvHJ75ATPSF52ckdr5DPPi" +
       "cXrBgul1sKBYp3gYQH/2kAXP3ngWqFcWiN1Q5ysoB6/fo6d9+/BA12n0rhxb" +
       "F4vk2jH6p26A47r1y4fov3zj0a+eC32ecuDs3RWvHx34AvAfugz+Lv0Efvd6" +
       "FSDH/9VD/F+94SrPFhjf/FxMeGtOsr0XG3txcS4gCktPXHmdsMiy+xT4mX/z" +
       "2Fff/Mxj/634+v68HfFy2A3NMw6LnSjz/U9++7u/d8/Dny5OqNyqyNFuIe/0" +
       "KbvLD9FdcjauwH/3EUcLNt+xV6z9PS6N/q5Hm3qJutTj4iTB/pjUDaur6Dt7" +
       "elCK//mHrgc/e/jh98G7z5aAwooVS9pHq9m3O7pn7s6O5bHqwTuC9LTp28v2" +
       "C48/BEYc39Pz8yT7tPv3S3RHxydBYnpmT9+662nR2K6bOXniudTy56+S9gs5" +
       "eTou3abm/drBuEr2Dx8qWqGOb7xec/QYEKLfP1TH379J6vix51LHX87Jv9w7" +
       "34Hjy4cKmb9/+6UhA3g494Vdh3f3kx0usp5aCL3NyOu7sth9Yi92n7lGscvz" +
       "/tyRyH38cpHLX78vJ//sKjL0iQL5x3PygauM9r+7StoXcvK5nPziridXyfsf" +
       "T0rNv7oRTuyPDqXmj26M1Jzs7G9cUxTzpZz82t6T7aaZV/Zku/T6MRP+04/C" +
       "hDQund+fwsyPlD102dnt3Xlj9dPPXDj/omdmf7Az8/szwXfipfNG4jgnTwCd" +
       "eL49CHVjN0e+c3ceKCgQfvVURHLiTGh+Sq94KHTkd3b5vwbmKafzx6Vb89vJ" +
       "bN8APDuRLS7dcfh0MtMfxKVbQKb88ZtH54FOnKbYTYXSnUQ/dFJWipWN+56L" +
       "u0dFTh5UzJ1ucXh+v5GW7I7PP6V+5hmMfOMPmh/bHZRUHTnL8lrOA/+4O7N5" +
       "6B9PHrA5Xdu+rttHr/zh8z975xP7jcPn7zp8LLcn+vbys08l9t0gLs4RZl94" +
       "0ed+6pef+VZxnOT/A2mpe7XVQAAA");
}
