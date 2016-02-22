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
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "XjlzuDcnRaU7Itd7raUmqnWivQdATa++");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
