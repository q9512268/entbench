package org.sunflow.core;
public class Geometry implements org.sunflow.core.RenderObject {
    private org.sunflow.core.Tesselatable tesselatable;
    private org.sunflow.core.PrimitiveList primitives;
    private org.sunflow.core.AccelerationStructure accel;
    private int builtAccel;
    private int builtTess;
    private java.lang.String acceltype;
    public Geometry(org.sunflow.core.Tesselatable tesselatable) { super();
                                                                  this.tesselatable =
                                                                    tesselatable;
                                                                  primitives =
                                                                    null;
                                                                  accel =
                                                                    null;
                                                                  builtAccel =
                                                                    0;
                                                                  builtTess =
                                                                    0;
                                                                  acceltype =
                                                                    null;
    }
    public Geometry(org.sunflow.core.PrimitiveList primitives) { super(
                                                                   );
                                                                 tesselatable =
                                                                   null;
                                                                 this.
                                                                   primitives =
                                                                   primitives;
                                                                 accel =
                                                                   null;
                                                                 builtAccel =
                                                                   0;
                                                                 builtTess =
                                                                   1;
    }
    public boolean update(org.sunflow.core.ParameterList pl, org.sunflow.SunflowAPI api) {
        acceltype =
          pl.
            getString(
              "accel",
              acceltype);
        if (tesselatable !=
              null) {
            primitives =
              null;
            builtTess =
              0;
        }
        accel =
          null;
        builtAccel =
          0;
        if (tesselatable !=
              null)
            return tesselatable.
              update(
                pl,
                api);
        return primitives.
          update(
            pl,
            api);
    }
    int getNumPrimitives() { return primitives == null ? 0
                               : primitives.
                               getNumPrimitives(
                                 ); }
    org.sunflow.math.BoundingBox getWorldBounds(org.sunflow.math.Matrix4 o2w) {
        if (primitives ==
              null) {
            org.sunflow.math.BoundingBox b =
              tesselatable.
              getWorldBounds(
                o2w);
            if (b !=
                  null)
                return b;
            if (builtTess ==
                  0)
                tesselate(
                  );
            if (primitives ==
                  null)
                return null;
        }
        return primitives.
          getWorldBounds(
            o2w);
    }
    void intersect(org.sunflow.core.Ray r, org.sunflow.core.IntersectionState state) {
        if (builtTess ==
              0)
            tesselate(
              );
        if (builtAccel ==
              0)
            build(
              );
        accel.
          intersect(
            r,
            state);
    }
    private synchronized void tesselate() { if (builtTess !=
                                                  0)
                                                return;
                                            if (tesselatable !=
                                                  null &&
                                                  primitives ==
                                                  null) {
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Tesselating geometry ...");
                                                primitives =
                                                  tesselatable.
                                                    tesselate(
                                                      );
                                                if (primitives ==
                                                      null)
                                                    org.sunflow.system.UI.
                                                      printError(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation failed - geometry will be discarded");
                                                else
                                                    org.sunflow.system.UI.
                                                      printDetailed(
                                                        org.sunflow.system.UI.Module.
                                                          GEOM,
                                                        "Tesselation produced %d primitives",
                                                        primitives.
                                                          getNumPrimitives(
                                                            ));
                                            }
                                            builtTess =
                                              1;
    }
    private synchronized void build() { if (builtAccel !=
                                              0)
                                            return;
                                        if (primitives !=
                                              null) {
                                            int n =
                                              primitives.
                                              getNumPrimitives(
                                                );
                                            if (n >=
                                                  1000)
                                                org.sunflow.system.UI.
                                                  printInfo(
                                                    org.sunflow.system.UI.Module.
                                                      GEOM,
                                                    "Building acceleration structure for %d primitives ...",
                                                    n);
                                            accel =
                                              org.sunflow.core.AccelerationStructureFactory.
                                                create(
                                                  acceltype,
                                                  n,
                                                  true);
                                            accel.
                                              build(
                                                primitives);
                                        }
                                        else {
                                            accel =
                                              new org.sunflow.core.accel.NullAccelerator(
                                                );
                                        }
                                        builtAccel =
                                          1;
    }
    void prepareShadingState(org.sunflow.core.ShadingState state) {
        primitives.
          prepareShadingState(
            state);
    }
    org.sunflow.core.PrimitiveList getBakingPrimitives() {
        if (builtTess ==
              0)
            tesselate(
              );
        if (primitives ==
              null)
            return null;
        return primitives.
          getBakingPrimitives(
            );
    }
    org.sunflow.core.PrimitiveList getPrimitiveList() {
        return primitives;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "HwE/JYf/IwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV6e8zk1nXf7LdarXYla1erh2XFkmx55VpmvJwXhxzITT2c" +
       "B4czQw6H5HCGbJsVh48hh+/XkDOp8nDg2qkL12nl1AUc/eWgbaDERpGgRYu0" +
       "aoPWMRKkSBs0bYHaQVugSV0DUYEkbd3GveR8z/l2V9puOsC93/3uPffe8zv3" +
       "nHMP771vfbd0KQpLkO/Zm6Xtxbe0LL61spFb8cbXoluDEcLIYaSpbVuOIh7U" +
       "3VZe+vq1P/reF43rB6WHpdKTsut6sRybnhuxWuTZa00dla6d1HZtzYni0vXR" +
       "Sl7LcBKbNjwyo/jVUenRU13j0s3REQswYAEGLMAFC3DrhAp0ep/mJk477yG7" +
       "cRSUfrR0YVR62Fdy9uLSh88O4suh7BwOwxQIwAiP5P8LAFTROQtLHzrGvsN8" +
       "DvCXIPiNv/nD1//exdI1qXTNdLmcHQUwEYNJpNJjjuYstDBqqaqmSqUnXE1T" +
       "OS00ZdvcFnxLpRuRuXTlOAm1YyHllYmvhcWcJ5J7TMmxhYkSe+ExPN3UbPXo" +
       "v0u6LS8B1mdOsO4Q9vJ6APCqCRgLdVnRjro8ZJmuGpde3O9xjPHmEBCArpcd" +
       "LTa846kecmVQUbqxWztbdpcwF4emuwSkl7wEzBKXnrvroLmsfVmx5KV2Oy49" +
       "u0/H7JoA1ZVCEHmXuPT0PlkxElil5/ZW6dT6fJf+5Bd+xO27BwXPqqbYOf+P" +
       "gE4v7HViNV0LNVfRdh0f+/joZ+RnfuVzB6USIH56j3hH8/f/0juf+sEX3v61" +
       "Hc0P3IFmvFhpSnxb+eri8d/6YPuV5sWcjUd8LzLzxT+DvFB/5rDl1cwHlvfM" +
       "8Yh5462jxrfZfyH++M9r3zkoXSVLDyuenThAj55QPMc3bS0kNFcL5VhTydIV" +
       "zVXbRTtZugzKI9PVdrVjXY+0mCw9ZBdVD3vF/0BEOhgiF9FlUDZd3Tsq+3Js" +
       "FOXML5VKl0EqfQKk66Xdr/gbl3jY8BwNlhXZNV0PZkIvx58vqKvKcKxFoKyC" +
       "Vt+Do8TVbS+Fo1CBvXB5/L/ihRpMaGCYONzcyrXL//80bpbjuZ5euABE/cF9" +
       "Q7eBjfQ9W9XC28obCd595xdv//rBseIfSiIufQBMcetwilv5FLeOpihduFCM" +
       "/FQ+1W4BgfgtYMjAxT32CvcXB6997qWLQHP89CEguwNACt/d07ZPTJ8sHJwC" +
       "9K/09pfTnxB+rHxQOjjrMnP2QNXVvDuTO7pjh3Zz31TuNO61z/7eH33tZ173" +
       "TozmjA8+tOXzPXNbfGlfkKGnaCrwbifDf/xD8i/f/pXXbx6UHgIGDpxaLAMl" +
       "BP7ihf05ztjkq0f+LcdyCQDWvdCR7bzpyCldjY3QS09qihV+vCg/AWT8aK6k" +
       "T4L0wqHWFn/z1if9PH9qpxH5ou2hKPznn+X8n/23v/n7tULcR6722qnNi9Pi" +
       "V0+Zdz7YtcKQnzjRAT7UNED3H77M/I0vffezf75QAEDxkTtNeDPP28CswRIC" +
       "MX/m14J/9+1vffW3D46V5kIM9rdkYZtKdgwyry9dvQdIMNtHT/gB7sEGppRr" +
       "zc2p63iqqZvywtZyLf3f116u/PJ/+8L1nR7YoOZIjX7w3Qc4qf8AXvrxX//h" +
       "P36hGOaCkm9PJzI7Idv5vCdPRm6FobzJ+ch+4l89/7e+If8s8J7AY0XmViuc" +
       "0IWdDArkT8el58+ZIq9FkWbLcc5OsbRwQfvxIr+Vi6UYoVS01fLsxei0iZy1" +
       "wlPBxm3li7/9B+8T/uAfv1NgOhutnNYISvZf3Slhnn0oA8O/f98f9OXIAHT1" +
       "t+m/cN1++3tgRAmMqIAtOhqHwP9kZ/TnkPrS5X//T3/1mdd+62LpoFe6anuy" +
       "2pMLUyxdATagRQZwXZn/5z61U4H0kSMXnZXOgS8qnjtvJJ841J9P3NlI8vzD" +
       "efbyedW7W9c98e8t4AvnFpAJTQeY0rrQxmLeT91jBTt59mrRVM+zT+6goe9J" +
       "CjvaZ4v/roBleuXuvriXh1wn7uzZ/zW2F5/+j//jnCoUXvgOkcZefwl+6yvP" +
       "tX/oO0X/E3eY934hO78zgfD0pG/1550/PHjp4X9+ULosla4rh7GvINtJ7mQk" +
       "EO9FRwExiI/PtJ+N3XaByqvH7v6D+6741LT7jvhkRwTlnDovX93zvY/lUv4o" +
       "SE8c6sYT+2p1oVQU6J1mFfnNPPszR67ush+aaxDYHPq674PfBZD+JE/5YHnF" +
       "Lgy50T6MhT50HAz5YLN+LD7lEPIxyieqXGjM+N00hjyL52WQbhziuXEXPPO7" +
       "4MmLbCEkLi5d9Y80vaBr7fEl3idfHzs04SNTvhNft98LX5dyP2QfGehHzxlo" +
       "K2/OBQz0nSuiAbDT7zH/2n0y/wMgPXXI/FN3Yd54T0JdJKYdFyze26CP3cwu" +
       "rIdfv/Ft6yu/9wu7sH7feveItc+98Ve+f+sLbxyc+pj6yLnvmdN9dh9UBZPv" +
       "KzjNd4UP32uWokfvv3zt9X/0d17/7I6rG2c/Dbrgy/cX/s3/+Y1bX/7db94h" +
       "Sr0IPvv2VsW8z1V5DqSnD1fl6busSvpeVuVKsSr51pxX+HtsZffJ1vMgPXPI" +
       "1jN3YetH3xNbhabHR6Ej0Pbrxaabe8dbuy/bPVZ/7F1Z3a3uBeC6LlVvobcK" +
       "b/PZOzNzMS9+DIRzUXGAAHropivbR9y9f2UrN4+cmqCFEbC3mysbzZt/co8v" +
       "7j3zBfTu8ROQIw98vH/+P3/xN/7aR74NdGhQurTO9wmgbKckQSf5ecZffutL" +
       "zz/6xu9+vohEgSSZ723/ycfyUb94L3R59vk8+6tHsJ7LYXFeEiraSI5iqgge" +
       "NTVHVgzhnMITxCAE9c6twntHG1+P+/WIbB39RoKsz1IlY2f6uIah/DoVxlhj" +
       "bm2NsUDqVmc9Yu1VYI8peTxCNvw0S9vjds1tqg1lrbga6ki17aqxcKzBxLHb" +
       "/nAxMXxc6MLcmOykPVwQCHjZkgRkykwEN51yNmHEg/mQbVBcsBy2p+tQQ8do" +
       "XIvR2Hcans9W1xIkNzUNpjW0iSyai5rLdQXDQuVAIc1FN1ixAcuIExunq2Yg" +
       "ZCIlZnp5oMwXG4+F5wxDNL11x+8PxS0ezVfdHksRJsyOZ1NquplxXojj3ZmV" +
       "udJwWjbZ8tDGmxMH52Rvw/c8i0QWrNR1ptVhW/ZWhhE3On1OZlpOu0FLhkPP" +
       "Jqk4Yz1QN1Asx2RUdInyid8VJGA0oYb4a63BuriT2e5IHE6Mta2J3eFAGkQu" +
       "mxBcivrZeBTjU23mU4LtdBHbsEJ0O6AiogoNRbNbm2AzBtbYrcbQtRZPt5Kh" +
       "txombkjwROBhE4HOpglcbkZWWYRSt4IQm/HAXTlRRkrNTKNbwYh1euysErs9" +
       "awnbm1Dih/CwMutW/bJPs2RXnAl9ksXpMjkbZ9y8LS2nVCWq8W427MRYuKn6" +
       "vtQbxkhjovPeQlXK8LBNVVoQr1mWNHF73S45wsmIXk4HnuQvQtYqh2ylg/sC" +
       "0d4ajWXSXpDlhVYpWxuCHk5Go3S9WEhRfxx2pco6kFbDptEvd2uMaW0FDArs" +
       "ZEpLemVmSbMupRKVitqZVlBKhaYjfNaK+uW4hUMSQkxRZDzttZnRGmeRPh+t" +
       "jdRuzfyZseht6VFllrRpHHesdG5NBHvU8bphoFGpOhn22GwiVTl2VBmXY04m" +
       "ofokcyyOaVLZyOlSaVAXFy3LEmW9N64j2dLOJESNnApT1aqLLbIJ+eHS6Fqk" +
       "1EXY6XSBICnOJnXVG5QrvDslFYdkKzI06hu01O94ymCpWLEbuY6LN5tNbWPL" +
       "zZhhqu54JmTm1kPZtcBanN63GqPMtWG2Ohc2hGizYWD2DcRQvW1ARaJYKSNb" +
       "tuXQIsZmG6pKjl11i0BNfV4rh3rH70jE0BKErbNorTK/R8v0gIpntak3D1rB" +
       "2CeGjsEFwXyFqWRvse0PxJm85tecLI43RNuZa4Jmb9YY0W3McFwKvF5ctwdy" +
       "TUaRsJWtbZQ3x12B6nUqUZ+fUKkO+wk7V3sZPR2vlubSs4IB0UWDIZSMiaFp" +
       "GZtgiaMbS6yonGcJcy5aeRI9n2RB4q+gRbMHvAwbsrxI9cvBMm7YsATXEbut" +
       "I5E9aXc3zQxfe1TEk8t24AaD+nRVlWvNQaVJMk65MeU9aCDaRM8iuTIXDbhh" +
       "naVYbemxbZehsTkVKpNOB2aWhjWhh40wINYLPEJqvS7hBjRte0ycrtoVD8K7" +
       "jfnMrIkLz2dWSRwrtQ6VYXXdStsTarmihoP6soMqhpbW644VbAZ0S0brrUVK" +
       "K3YP5tqY39raTZ0ZEjUBQi1qvWQd35q1usslNBlktI51/ZrWbtd6MYxOCAhS" +
       "xyt5NQ57coupVU1B6JpsZ1JXy3AIDwaKUtnU5b5FbseqKJDjpDUQN0s+1cW2" +
       "ryaYjAudyUKhgoZN0u1AFRiOIccEuxK58qLSFAZ+XUEFk4bdtLkYp+rKyxxN" +
       "NWMRIjBloc7S+azVINfBkE2jcbWCKeUErddkWK9RHXrB0dhai71+MIyq9Wmw" +
       "GW4G9bK2qtcCVO36Rs2AxgMU2TYQu6OhKz0VN4LPLqJsJM7LLa7aBXLDKLc5" +
       "QuFqI7LmqWvrHb5bF8LxyhrULMzyTaZh0VN8MJtBNbLVWFqTlFtVaqzmific" +
       "c+wBMZj6eKTBDVtVm3RHX604UTfxzgqqEDIG0+nY1hNSUGB4UkFRdUubXZYv" +
       "z/tSVC93q8Gir9SbiYlQHrtBCARZQHHZNTpRK251vc7MkZUkHTn8YumEKt60" +
       "Z93WKPFEAZfE9nJcawa0TjSmcbaejAZppz4b61ljwSukSoos11D8jaUx1AjF" +
       "tiqsNFYSao+NqcNVNxSBy7WF2h1EQjJrwRNy3WmVyWy1oqo1owEhygKhKb2l" +
       "qEa9bbQlpxOVW/2qspxDIlZNAiZsimjT68+d6orkUU6uRu3AhpaiYgZiV/Qo" +
       "sU4S0hhqDm1/GVNCHLmTen06FJuzeUVqMHC0IRIKpZjaCudhRae1gYC6wACQ" +
       "kdmgA1cT0kbZ7/cWchgJNo8OY8gfoE0syepakxgPahO/hXZrqVqdh2hUEalo" +
       "nVXFUR/1RKdS35qrBaxWF52V0eDFVX8dYPwqgDpWvTsjWrVtjVlDSK2JVDZo" +
       "b0CVaz5mqWinUlsY27VVntAwFHTIKr8a22XTYBi+U9bjZN5k0Y2aKLVlT/F7" +
       "DWkIfGp9amxkWtcd2HaTIbOxqz2OnqYy20782qZGzkQuE6eG1eHXvIFxsDhK" +
       "0yE/3UZjFFsuRt02LCfSojJBs20FIxtbbF5N8GYtVHrxLG3S3lgYrypps2OM" +
       "4Ii2q2xcqYnhaI7H3ZAfcCssaKk0kk5SSebGYBkJaCsicISqjcjfJsLMnJKq" +
       "gHVYabOdI40BXk4TNxCdfjPAHb+ipWRdmHT6dq8vmW4gNbaTeEMs7eHKn/R2" +
       "NJPWZooKhj5n+ZDhTarNS93U6DBsuzPCxsstbcXNXkRta8jAW3sYJActSI/Z" +
       "JRQT0aBDJeoMuFVdGU6aNqics5tGFlRMlciosWouIFEZESlOdpEQmieNjlpb" +
       "o3yNkBpzgaCCJIqA89bMqjxmEmlo4jaz4aGWi1MQjE2JQQTWaQJtqzNnTmFu" +
       "qnpVu75szZe2peGN7paX4TjRIRqapt0117ecMkb313BvgFAGSzWt1IQIgdVn" +
       "noOJkdmtVKKB3W0IYjdUSB9aNxtgZVwVw4DnEoKhuQUKyEbIuj5nanVHWW8Y" +
       "HpkBX+9ZjfKoo7M+nthmnW5IbbtZmcJwh+Zn86Y1XhBcX5hZuuTKXCa0CUlg" +
       "3cU0FuyxpZVb7nAqL5bpyuNnKZ7V9Up14dfr66W8ILCYmvezFOtB4VKnOapS" +
       "o5QMxYbjtghZRlXxG8KgPguqlZlbthiW9AIWq3BUyBqqY7dMnGphEI4NN0MH" +
       "V7x+4sA9Dm+GNltNa1hgykq1WRVrJgYJmdaw2g6HI2ti0A9REJ8MexqsD1pl" +
       "lfH7C0UT+uLGJZJWZSYFQZVviJOen8htWjF9smdJCK0Ot5GtQ/B05EBUZG8a" +
       "iTLojRIg8AQT9f4iHTH9/jKcztCRYenOdI4k0WaVILrNiEyNWQiVWF/F1AiT" +
       "qGxMe0ZSmQSjJPXMqMI5Cln2jU5/YTWRiT5N10Z1xscNTl7Pt75WR/QIAsYI" +
       "YoZUZSvGeCoPJFylJ5krUKpT8dFZw0+r0roWcRSHzpgJgWBtO+ItsumoArdk" +
       "gHmE9KQ3b9KJirhkj5IFYSa1PW/eYfoMUaPHZTpFIIST1RoGL7aiRRK1tNmz" +
       "nUaapElHc0kEocLVpsXX8Uw36mnTWFaZtF8nhnSkbWV+SJnrgZGNYIbDRkrX" +
       "FbdTPdpypKswtb6JzGoeVk5oPFC2scA6nZU17eJkZ1izZLiuknhF9xi6Xt9S" +
       "LShWAs3fyF4CeBwS27kx6M4oqJO0UXYuIGWWcRd8BMV4Qws2aWfeEdAq7LB4" +
       "pMcwMWj1GosoFRtmyhpQb9uhWsYGFqXlvNfAug5jVBa9etcZqFHZJvHZtmFw" +
       "ptv3TEiNy1MW71pzpj2ezaaS05VUQ8erRDVyxGnEZnOg3rIUbjLCX7TGWEtB" +
       "U55ixIR2YNOcmcIC365gaCMicoXJNpswGfHOFkYkJ50tqM2MqitKNhkTTAsD" +
       "XwKa1AxGVCqVYwTIH/czOuthg20ZH6Ei2TL09mi82k7EUPT5YNjLWnzX7pch" +
       "g3Ah1BhL5hRDyKgh8bza9h10NeECYoihEmdBQMQVJ6itWHSYyyRZivRInDib" +
       "xaS/wVEzbfeqvZWR77MNGsYa2grsfVhsG8PatofATJNs9QWFWA1rbT8uY+XW" +
       "Oulua0PglvXFMpKChQhzEFGRK2tWqNa2XGNbT0m30VhO3dA1B/pmBFI1XsIk" +
       "5EqC3axWxQZa5vodMVZERnDm6mrdE6lwIqjrdhfH0xE0WdmdHrLiPW9LKdPK" +
       "ajbYbmhYs5pCq5NuWKwmd6SWpgXuMN0MNC6gyVVIEhhiY7XNYIwwpG0MsD7G" +
       "RyMGChmHaVluViHtuNrAmlDTQrdTbOOZGcVvxvMxiCecCtTH/HkHOLCEDuDh" +
       "Um4wyKoiRliQuLhPL9kaPIPS9jZDW0RarSmDvqvV56yjNyNMHw22Igw13I6t" +
       "VLtc1aLbLYufuskILQ82M2M6iHh0W8eXRDBc1w1/AT6YK+N52K3BMCtA0BSl" +
       "iLpiw+sxL0bVPtuQ5sSwRzo03+Va06nB8/1R1Vs7lUF16vbaI9QcB/jWJlin" +
       "NkW21KQCcDKhLYQENeZ13UTgLUmU/bWv+HDESu0G0lEllCGlBHFXXhhU3QS4" +
       "I6HVNCgk7gzrhD6Ahm2nyqocgboCPSl3hirH6M1tvZ924YGow2TaKo5yv3J/" +
       "xyJPFKc9xw8w/h/OebI7Xc8Uv4dLe5f2pw7MTl2B3ONWjdVcVQt3Fwb50eXz" +
       "d3t9URxbfvXTb7ypjn+ucnB4SRPGpSux53/C1taHB8sndy4fv/sRLVU8Pjm5" +
       "+PjGp//rc/wPGa/dx9X3i3t87g/5d6m3vkl8VPnrB6WLx9cg557FnO306tnL" +
       "j6uhFiehy5+5Ann+WP7FSfwHQEIO5Y/sH1ierPCdTys/ttOQvTuwg8MHBIcr" +
       "dodrtFwOWqyF+TXaEdkzp8m43d8WQxYz/NI9btn+YZ59LS49nPiqHGt3Oqe7" +
       "vPA8W5PdE139+v1cxRUVbx2LLSctPQtS91Bs3fsQW+mOEjuN5xv3aPtmnv2z" +
       "uHR9qcV04jBnLmn8E3i/+gDwCrL8jp48hEc+MLy9e9VnT6+0I8fGLUqOQzOr" +
       "F53/9T3w/06e/WZcehzgn3mhreJe4qrR0cAfPDdw0W66S9zLTqTzLx9AOkVl" +
       "FaT5oXTmDyydPXN56ryDkzdHjS+dayTzB3TR7sVC/thv97DgP91DiL+fZ98C" +
       "bs886nrHs+21Z6onMvv2A8gsdzGlV0B67VBmr92HzA7yIhuXHos2rmKEnmtu" +
       "NfVdjeiP79H2P/PsndztH96+Fs7xOydY//uDYn25gLf7BfeNNc/+8N0QXrh4" +
       "j7ZLeeWfxKVL+dWWuofu+w+q/WWQPnOI7jN/2r7h/PbOGXJuwce6feHaPZA/" +
       "mWdXY8BOqPlyqJ3ufFYOFx59ADncOFrlnzqUw089sBxOo3j+Hm0v5tmzACFw" +
       "gbhsAXBnd4HWCcIPPCjCl0D66UOEP/2nivCVe7RBeXZzt8mdeXCzB+/l+3pO" +
       "E5ceOXoJmT/revbcQ+rd41/lF9+89sj7");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("35z+TvEY8PiB7pVR6RE9se3TL0tOlR8G6qabBeoru3cmfgGlClDsKzRwrfmf" +
       "nMMLlR0ZEpcePUUGApbD0mkiLC5dBER5sekfmcupm9DDAPjCqRi2dGrTu/Fu" +
       "0jrucvrxXx73Fi/Tj2LUZPc2/bbytTcH9I+80/i53eNDxZa323yUR0aly7t3" +
       "kMdx7ofvOtrRWA/3X/ne41+/8vJRTP74juETDTvF24t3funXdfy4eJu3/Qfv" +
       "/6VP/u03v1VcBf9fnAhlZjIwAAA=");
}
