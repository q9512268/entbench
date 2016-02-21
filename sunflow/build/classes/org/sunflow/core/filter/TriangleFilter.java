package org.sunflow.core.filter;
public class TriangleFilter implements org.sunflow.core.Filter {
    private float s;
    private float inv;
    public TriangleFilter(float size) { super();
                                        s = size;
                                        inv = 1.0F / (s * 0.5F); }
    public float getSize() { return s; }
    public float get(float x, float y) { return (1.0F - java.lang.Math.abs(
                                                                         x *
                                                                           inv)) *
                                           (1.0F -
                                              java.lang.Math.
                                              abs(
                                                y *
                                                  inv)); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye4xUVxk/M7s7+2YfvF8LLAvJUjq3La20LtLCwrJLZ2HC" +
                                                              "UmIHZbhz58zuhTv3Xu49szu7dS0ltaCxBC0FNC1/0bQSWhpjo4m2wRhtm1aT" +
                                                              "PrRWY6vGRLQSi8Zqilq/75y5z5lZwj9OMmfunPOd871/33fuhSukzrZIF9VZ" +
                                                              "nE2a1I5v1VlStmya7ddk294Nc2nldI38932Xd9wVJbEUmTUm28OKbNMBlWpZ" +
                                                              "O0WWqrrNZF2h9g5Ks7gjaVGbWuMyUw09Reaq9lDe1FRFZcNGliLBHtlKkA6Z" +
                                                              "MUvNFBgdKh3AyNIESCJxSaRN4eW+BGlRDHPSI1/gI+/3rSBl3uNlM9KeOCCP" +
                                                              "y1KBqZqUUG3WV7TITaahTY5qBovTIosf0O4omWB74o4yE3Q/3/bRtRNj7dwE" +
                                                              "s2VdNxhXz95FbUMbp9kEafNmt2o0bx8iXyQ1CdLsI2akJ+EwlYCpBEwdbT0q" +
                                                              "kL6V6oV8v8HVYc5JMVNBgRhZETzElC05XzomyWWGExpYSXe+GbRd7mortCxT" +
                                                              "8fGbpJOn97V/u4a0pUibqo+gOAoIwYBJCgxK8xlq2ZuyWZpNkQ4dnD1CLVXW" +
                                                              "1KmSpzttdVSXWQHc75gFJwsmtThPz1bgR9DNKijMsFz1cjygSv/qcpo8CrrO" +
                                                              "83QVGg7gPCjYpIJgVk6GuCttqT2o6llGloV3uDr23AsEsLU+T9mY4bKq1WWY" +
                                                              "IJ0iRDRZH5VGIPT0USCtMyAALUYWVT0UbW3KykF5lKYxIkN0SbEEVI3cELiF" +
                                                              "kblhMn4SeGlRyEs+/1zZseH4A/qgHiURkDlLFQ3lb4ZNXaFNu2iOWhTyQGxs" +
                                                              "WZM4Jc978ViUECCeGyIWNN/9wtV71nZdekXQLK5AszNzgCosrZzLzHpjSX/v" +
                                                              "XTUoRoNp2Co6P6A5z7JkaaWvaALCzHNPxMW4s3hp10/uP3yefhAlTUMkphha" +
                                                              "IQ9x1KEYeVPVqLWN6tSSGc0OkUaqZ/v5+hCph+eEqlMxuzOXsykbIrUan4oZ" +
                                                              "/D+YKAdHoIma4FnVc4bzbMpsjD8XTUJIPXzJzfCtI+LDfxmRpTEjTyVZkXVV" +
                                                              "N6SkZaD+6FA9K0uM2vCchVXTkOyCntOMCcm2FMmwRt3/imFRCaSACJJ2Q6bo" +
                                                              "oxqgJv6NY6iZ/w8mRdR09kQkAk5YEoYADbJn0NCy1EorJwubt159Lv2aCC9M" +
                                                              "iZKNGFkN/OIlfnHkFxf84kF+JBLhbOYgX+Fn8NJByHcA3Jbekc9v33+suwYC" +
                                                              "zJyoBRMjaXeg8PR7oOAgeVr52/bfrRuc/vRbURIF3MhA4fHwf7kP/7FwWYZC" +
                                                              "swA/1eqAg4VSdeSvKAO5dGbioT0P3sJl8AM6HlgHWITbkwjDLouecCJXOrft" +
                                                              "6OWPLp6aNryUDlQIp7CV7USk6A47M6x8WlmzXH4h/eJ0T5TUAvwA5DIZUgTQ" +
                                                              "rCvMI4AYfQ76oi4NoHDOsPKyhksOZDaxMcuY8GZ4lHXw5zng2mZMoYXwbSjl" +
                                                              "FP/F1XkmjvNFVGKshLTg6P6ZEfPJX/7sT+u4uZ1C0Oar4COU9fnABw/r5DDT" +
                                                              "4YXebotSoPvNmeRjj185upfHHVCsrMSwB8d+AB1wIZj5S68cevf99869HfVi" +
                                                              "lUH1LWSgiSm6SuI8aZpBSeC22pMHwEuD3Mao6blPh6hUc6qc0Sgmx7/bVt36" +
                                                              "wl+Ot4s40GDGCaO11z/Am1+4mRx+bd8/u/gxEQWLp2czj0wg8mzv5E2WJU+i" +
                                                              "HMWH3lz6jZflJwHbAU9tdYpyiIxUylfs5UYKGRuyTs2DG8ZL1ea25H7lWE/y" +
                                                              "D6KSLKywQdDNfUZ6dM87B17nTm7AvMZ51LvVl7WbrFFfhLUL438Cnwh8/4tf" +
                                                              "NDpOCNTu7C+VjuVu7TDNIkjeO0OzF1RAmu58/+ATl58VCoRra4iYHjv5lU/i" +
                                                              "x08Kz4kGZGVZD+DfI5oQoQ4Od6J0K2biwncM/PHi9PefmT4qpOoMltOt0C0+" +
                                                              "+4v/vB4/89tXK+A3pJAhizZyXcCdc4LeESpt+XLbD0501gwAagyRhoKuHirQ" +
                                                              "oaz/TOig7ELG5y6vteETfuXQNYxE1oAX+PTtXAzJFYZwYQhf24ZDj+0Hz6Cz" +
                                                              "fE1yWjnx9oetez586SpXONhl+7FiWDaFtTtwWIXWnh8uUIOyPQZ0t1/a8bl2" +
                                                              "7dI1ODEFJyrQWto7LaiOxQCylKjr6n/1wx/N2/9GDYkOkCawcHZA5iBNGgEd" +
                                                              "qT0GhbVo3n2PAIcJRId2riopUx7zcVnlTN+aNxnPzanvzf/OhqfPvsdBSaDQ" +
                                                              "Yr49ipU9UEf5zcwrA+ffWv/zp792akKEzgyJENq34OOdWubI7/9VZmBe9Srk" +
                                                              "Rmh/SrrwxKL+jR/w/V75wd0ri+XdCBRob+9t5/P/iHbHfhwl9SnSrpRuQntk" +
                                                              "rYCgnoLu33auR3BbCqwHO3nRtva55XVJODl9bMOFzx/xtSwQ3V6ta3FqXaxU" +
                                                              "BmLhWhch/OGzfMtqPvbisNYpLfWmpcJtmYZqS/MMh0JKceL1opDiOIjD/eKM" +
                                                              "e6uG3a4bF1zGIcVIjaqPV+KZmYGnWFqNwxqXs8st0HL7K6cX3ULNBYzML2tC" +
                                                              "RdeJCb202q2JQ+e5IyfPZnc+dWu0BDN3M8hQw7xZo+NUCyXS0kAiDfN7oheV" +
                                                              "TY/cMjvBirnyXhRP6arSba6pnnFhBi8f+fOi3RvH9t9Ao7kspHv4yG8NX3h1" +
                                                              "22rl61F+1RVJUHZFDm7qC4Z+k0XhTq8H4b3b9WYHOm8BfFtL3myt3OxVCAS3" +
                                                              "haq2dYZiUZxhbQoHqAP1o5SNQBfDo9YLWHa9JAlgM04k+bQR1Nl9cH5vTOdq" +
                                                              "W0N6RUVsuom3nh/98AzaP4LDg5CvoH1I88M3rnmRkVnBex5WqwVlb5PEGxDl" +
                                                              "ubNtDfPP3vcOv3O4bylaoMXLFTTND6i+55hp0ZzKhW8R8Gryn0crpb24ezJ8" +
                                                              "X4QPXOyvCvoTjLSH6RmpxR8/2WOMNPvIGLYz/MlPdAoMCET4eNp0QKidF2ks" +
                                                              "LHFRWIoRH4CUYpJbeu71LO1u8d9JECD46zwnmQvihV5auXh2+44Hrn7qKXEn" +
                                                              "UjR5igd5M/Ri4nrmAsKKqqc5Z8UGe6/Ner5xlQOIHUJgL2QX+6IpCRhsossX" +
                                                              "hS4Mdo97b3j33IaXfnos9iZU+r0kIjMye295CS6aBcDXvYnynhPAkt9k+nq/" +
                                                              "Oblxbe6vv+Y9DhE96pLq9Gml8ePjUyvsSDxKGodIHWA9LfLeYMukvosq41ag" +
                                                              "gY1ljILuvvWbhbEp42s+bpWSMVvdWbxPM9Jd3suXv2OA5m+CWpvxdA6QIfgs" +
                                                              "mKZ/lVu1H4c7i2hliLN0Ytg0nUsMb5CSpsnT7zwOW/4HgpCoJacXAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "wvzqJf2De37vLb/13LfzM7r/BTv/x7o4IgAA");
}
