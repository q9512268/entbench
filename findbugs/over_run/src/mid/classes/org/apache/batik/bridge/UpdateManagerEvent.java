package org.apache.batik.bridge;
public class UpdateManagerEvent extends java.util.EventObject {
    protected java.awt.image.BufferedImage image;
    protected java.util.List dirtyAreas;
    protected boolean clearPaintingTransform;
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das) { super(source);
                                                    this.image = bi;
                                                    this.dirtyAreas =
                                                      das;
                                                    this.clearPaintingTransform =
                                                      false;
    }
    public UpdateManagerEvent(java.lang.Object source, java.awt.image.BufferedImage bi,
                              java.util.List das,
                              boolean cpt) { super(
                                               source);
                                             this.
                                               image =
                                               bi;
                                             this.
                                               dirtyAreas =
                                               das;
                                             this.
                                               clearPaintingTransform =
                                               cpt;
    }
    public java.awt.image.BufferedImage getImage() {
        return image;
    }
    public java.util.List getDirtyAreas() { return dirtyAreas;
    }
    public boolean getClearPaintingTransform() { return clearPaintingTransform;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "Fw136Lp1EA+0sJXXdRaKV2nT/m+6FzC+ih0AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "zfrCMJBKJd7qG7/TdUklRElZpn1mLY10d0QPzX6VseahI9NSviMRvpvPTURz" +
       "VxWCRYbNpTLRRCOsW7NR26EzQvCVQW2orITFMFyvaVkTXdbPnK0Fpo++Ozb9" +
       "Xt9NwjEfJ+4UZWZKh3Z7SkgPNNrNJvZq6tOTSbXqtKb1HUWRKKNt0ZbYSSY2" +
       "Bi/TeRZaJGbqlOWylKX2pmNJD+lRrclINFZNm+TGYhhaXjMWLojjwYQbYyvZ" +
       "iWmTF6iWJ/RajTihVJtbZJmfO2rbWiC6m/CVJMLbgxHt8HKfyGlth+JjVTIF" +
       "vCM1TCGVe+1Wpd+FrUnUVgfC0B20u3EbC1qt+ThTBXwzqcpqB2awqWDLU86l" +
       "O4kQCzXBmthqzZrarao6iUc87Y6qS1/h58lq7MZAaNwJGmkFdblVtaFzq8UU" +
       "T2DJt8MU62JRT+F1iZ8sY3JdWbSWLNVrW8naFuRVyEdSuOgtZ2OXp9ZzI66o" +
       "1V2Nr8l92snIWaKoXV3IM3WBYusIB2rdSfaAb3NCLZ4qEuYifDyR/Yke9wxu" +
       "vrUxjTc3VNbrK502Z5Mb28jlocTUY4HYjjZ8M+rmkUySg8xpSXk9MXmJV32y" +
       "p9psWl3aYRu3hh4JJxO9z+Or5XK52CV83qrLUbRMll6TJf2JwRE6RcNUh3cW" +
       "Ldpvod0VMuVHdLoTqDGRpubCyyPfoSpGqDYn5GDZ0hkhC2UO5rOOuJljIVdt" +
       "rkiaNLRY7QdIf5LVYqlNzgXSGAqcOx4RCIEvmkQ92FRaDIruRpNkpODVWoe2" +
       "plxe91MRD3VdIixZHUsYulUWUaOnWYpDT9M1q0pt1M8ZoS60J7NNlm0iszI0" +
       "vc6wakxYOQk7K8npTlrIwJpi1KAedanVWFbzPk8CPKW3ER0mi2E2djSqMe3M" +
       "8waMj3IUG+FOi8+icDA252CfumT76VJwNLYRjeYYjKEzodVsiPC67/NMVSIl" +
       "Qsp7SNyFW/B60JwuBz2q05kosjTkJ9sxviYqTpdmx2lHXzodvUXMSATZuLsl" +
       "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" +
       "r3TbX+jRmBuZjD5A7Nyo9+U6356uK5yOtMk+22hsiHY3IAie6NZ2qyot0yis" +
       "hSkF5jy/NXeW9KRnbOFt1cVz2ei26gQ8Dqs20cxHjD7zWEqq1MCiH8kmsyaC" +
       "YZmvOBt9k1ZpksinBjKDRWaVsJuIqYKZR1nKlTlYFLApHOWjnV6fDFdaJvBh" +
       "mFSUUGCRuTH0RRRuKypbmfMR3KiIYPWID8frbZetWV6j5+Is3RHVJeos2M1S" +
       "jyrAIaMRU9/VNSzIeBSO1uZ6s4NhRKt3trExyRru1Iz5xqQmOqTTHVZa9nbK" +
       "1gQTVoikh6p0jaDtKZwM9GmtPhzPm1gNGYw4CV7EmTCmiGShoawYZz6C2HDY" +
       "kuyZK+toMgJmROgeuUAA/BAN2UHrzWTV5RpM5G/EjpZJmgGPGX7W88Sx3oin" +
       "jWU62o3ClFTkrm7WsrXqwly4HlA2EjOSWeuJG5SfrBTCkOxeQ0/YZpvxev5k" +
       "zCMjeawF3eXEbllRTUfhjKzgYJuOS1EG2x252p95zX7IbRJ8kOZUM11qG3xB" +
       "oONo7vSb81oz3uZNT2osttV6psJbnpbm3ZAR+HhQWzXhMDA7+XRdC5JwZ48X" +
       "41RW0MTFe57dCdOY5bo0hsOJtQ5pBUvhTDS5OaK4w0ZqGJvqesNueoINk8uZ" +
       "3nEmS7rNhwKuOo4+EMlxbZElDpsyZBOnZElDXGyhNhHEU6ieGC/7s6obxUiP" +
       "5iXOWxCqbWzqejbwIxIb9LBZayDPu5FlSRjO5hWE1Nx+spo6zBipd0R+hkk+" +
       "hyxjZpp3osm2IqWbydIJt+08VDpVLms6OUlthuFMmI4qmcKoXtRwunjs4uhU" +
       "Se1BhrKdDKvUhwFGkzAaM7OZzqsDGfdExIXrnV0Lti0UbIzfXW6sP/LqtvIP" +
       "lKcWx1f9YAdfVLz/VezW81udZZe/K9C56+HzZ9mPHJ2hR9Bjt7vBL49qP/mB" +
       "F17U2Z/Fjq41hAS6N/GDdzjGxnBOkboEKD1z+0PSUfkBw8lJ5R984O8eFb/N" +
       "et+ruP988zk+z5P8xdFLX+x+i/ZjF6FLx+eWN31acbbTs2dPK69GRpJGnnjm" +
       "zPKxY82+sdDYk+CRDjUr3erE7vodDtLeurf9HQ6tf+4Odb9QJD+dQPcsjaR/" +
       "fNJ54io/82oOuMuCF49lK5sVlyfvPZTtvf/xsv3KHep+tUg+lUCvBbK1b3dk" +
       "Wt7wXHslJg+vVY7V8ul/h1peVxS+HTz64Yj6f7xaXr5D3e8UyecS6I1ALa3b" +
       "n72eCPubr+qSI4EevPnrh+Iq95Gbvr3afy+kffrFa/c8/KL0F+UHAMff9Nw7" +
       "hO4xU8c5ffJ/Kn8liAzTLgW6d38PEJR/X0ygh2/zVUYCXdlnSqa/sG//pQS6" +
       "fr59Al0u/0+3++MEunrSDpDaZ043+ZMEugSaFNk/DY7Oid9wcltZamJ/C5Jf" +
       "OIuYx7p+8JV0fQpk33IGGssP4I5gLOUOr6o/8yIz/u6v1392/5GC5qi7XUHl" +
       "niF09/57iWMofPK21I5oXem97Rv3//K9Tx/B9v17hk+89RRvb771FwG0GyTl" +
       "Hf7u1x/+1Xf9/It/XZ5d/3/C+n1cmSgAAA==");
}
