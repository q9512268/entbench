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
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "nP3k71I/qf2Lc6WbjnaBLvv85dJCT1y6");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("93NHaMRJ6E0u2QF66Ij9+WZy6UFwTQ/ZPz29P3I8wGdvjrxiJyCnti/PFRnO" +
       "FSKyH7UHTo7aeHfvcHRR/p89y/bnL+Tkn8alW4oPFM5a775t5vuOoXrHcviO" +
       "51rtPtlI8eKtl+4ZVcD1+UOefP7H5Ql2Jk8OjjO8u8jwy2czbc+v3U6y7V+k" +
       "h0SmGcGRLIG0V15xr+yx3e2oRNHSh3Pygbh0oWAh7apzA3V8bXnm5kHq2/ox" +
       "Jz94rZysg+vrh5z8+g3i5KeuLH4fycmvFLk+k5Nfi0v3FVxAVW05D/3E0wtW" +
       "5Gn/5hj2x68Vdv7F0bcOYX/rBsH+j1cF+4s5+Vxcel4Bm7SdeLejegLt568V" +
       "LQyu7x6i/e4NQvulK6P9lQJykevLOXkmLt1doOUsP/a9swb4t64V8mtA527d" +
       "ld3dbwDkr10V5K/n5Ctx6c4CMkWfBff3rxVuA3SMOoRL3SC4f3ZVcL+dk2/G" +
       "pfsLuMV+PDB4qRGehftProMjOFgf4l7fINx/eVW4v5eTP98b8UmoasZZiP/H" +
       "dbBcB28/RPz2G4T4r64K8d/k5Ad7y4WBqCZUT6H94XVwTwefPUT72RuD9uDg" +
       "atAeFJH33+7d0w4tGGUvyr8TPAX7764V9mtBB794CPuL1wf2CVTjY+x3XY2P" +
       "OriQk/NglnECO6vGoZ1dCvzg9msAfl/+8mUAwx8cAv+DGzTeL7qq8f6JnNy3" +
       "l+6xpeo7v/y+Y7T3XyvaR0Cz8a7s7n4D0D5+VWh/KicPx6W7CrSHX7CcxvvI" +
       "dYhDzr3nEO97bhBe+KrwVnPy6n0csvuU7wxzffCaa4VcBXP2/7kru7vfAMiv" +
       "vSrIr8tJKy7ds5tlHE5IzwLdvg5e+ebzu7K7+w0ATV8V6F5O8L1XLqKRsxAT" +
       "14D4nvzlSwDSjx0i/tj1QXxikn0gXJWZlnLCxaU7dmbadw5P94AZ6QtPzkjt" +
       "fIZ58Ti9YMHoGlhQrFM8BKA/c8iCZ64/C7QrC8RuqPMVlIM37NFzvn14dOs0" +
       "eleNrYtFcvUY/ZPXwXHd/OVD9F++/uhXz4U+Tzlw9u5KNI6OdgH4D14Gf5d+" +
       "Ar97rQqQ4//qIf6vXneVHxcY3/JcTHhrTrZ7L0Z7cfGNfxSWHr/yOmGRZfdZ" +
       "79P/9tGvvuXpR/9b8SX9eTsS1bATzs84FnaizA8++e3v/eFdD326OG1y80yN" +
       "dgt5p8/TXX5c7pJTcAX+O484WrD5tr1i7e9xSbpOp5bQRFsacXFIYH8g6kZV" +
       "XSAbnx6y4nf+SevBzx9+4n3w7rPlo7BxxYL30Vr3rY7hzXdnyPJI9uAdQXba" +
       "MO4l/97jT34xx/eM/OTIPu2+/QLe0TFKkJid2dO37npaNLbrZk4efy6l/cVn" +
       "SfulnDwVl27R8n7tYDxL9g8fqmGhrG+6VmP1KBCxPzpU1j+6Qcr6sedS1l/N" +
       "yb/au2bS8dVDdc3fv/3SgAI8nPvCrsO7+8kOF1lPLZPeYub1XVnsPrEXu89c" +
       "pdjleX/hSOQ+frnI5a/fl5N//iwy9IkC+cdz8oFnGe1//yxpX8jJ53Lyy7ue" +
       "PEve/3RSav719XBxf3ooNX96faTmZGd/+6pinC/l5Df2fm43Cb2yn9ul146Z" +
       "8Js/DhOyuHR+f94yPzz24GVnuHfnjrVPP33h/AufFv545wT2Z4Nv75fOm4nj" +
       "nDzrc+L51iA0zN0M+vbdyZ+gQPjVU/HKidOf+Xm84qHQkd/f5f8amMWczh+X" +
       "bs5vJ7N9A/DsRLa4dNvh08lMfxyXbgKZ8sdvHp38OXFuYjdRynYS/eBJWSnW" +
       "Pe55Lu4eFTl5JDF3ycUh+v02W7I7Rv+k9pmnmcGbftj42O5IpOao221ey3ng" +
       "PXenMw+958mjNKdr29d1a/eVP3r+Z29/fL+t+Pxdh4/l9kTfXnb2+UPCDeLi" +
       "xOD2Cy/83E//6tPfKg6O/H+Ifas13UAAAA==");
}
