package org.apache.batik.anim.timing;
public class SyncbaseTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    protected java.lang.String syncbaseID;
    protected org.apache.batik.anim.timing.TimedElement syncbaseElement;
    protected boolean syncBegin;
    protected java.util.HashMap instances = new java.util.HashMap();
    public SyncbaseTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                   boolean isBegin,
                                   float offset,
                                   java.lang.String syncbaseID,
                                   boolean syncBegin) { super(owner,
                                                              isBegin,
                                                              offset);
                                                        this.syncbaseID =
                                                          syncbaseID;
                                                        this.syncBegin =
                                                          syncBegin;
                                                        this.syncbaseElement =
                                                          owner.
                                                            getTimedElementById(
                                                              syncbaseID);
                                                        syncbaseElement.
                                                          addDependent(
                                                            this,
                                                            syncBegin);
    }
    public java.lang.String toString() { return syncbaseID + "." +
                                         (syncBegin
                                            ? "begin"
                                            : "end") +
                                         (offset !=
                                            0
                                            ? super.
                                            toString(
                                              )
                                            : ""); }
    public void initialize() {  }
    public boolean isEventCondition() { return false; }
    float newInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          new org.apache.batik.anim.timing.InstanceTime(
          this,
          (syncBegin
             ? interval.
             getBegin(
               )
             : interval.
             getEnd(
               )) +
            offset,
          true);
        instances.
          put(
            interval,
            instance);
        interval.
          addDependent(
            instance,
            syncBegin);
        return owner.
          addInstanceTime(
            instance,
            isBegin);
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        if (owner.
              hasPropagated) {
            return java.lang.Float.
                     POSITIVE_INFINITY;
        }
        org.apache.batik.anim.timing.InstanceTime instance =
          (org.apache.batik.anim.timing.InstanceTime)
            instances.
            get(
              interval);
        interval.
          removeDependent(
            instance,
            syncBegin);
        return owner.
          removeInstanceTime(
            instance,
            isBegin);
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { if (owner.
                                                      hasPropagated) {
                                                    return java.lang.Float.
                                                             POSITIVE_INFINITY;
                                                }
                                                return owner.
                                                  instanceTimeChanged(
                                                    instanceTime,
                                                    isBegin);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL0ZC5AUxbVv78txfzhAhAOOAwV0Vw0a4dR4HBwcWY6DA8os" +
       "4jI723s33OzMMNN7t3eGBEmlJEmFMgaFJEClUhjQoFipWNEYDSnLX2mS8h81" +
       "fkpTpcZYSizNRxPzXvfMzmc/5KokWzW9s93vvX6/fu/12xPvkUrLJG1UY2E2" +
       "ZlArvEpj/ZJp0WS3KlnWJpiLywfKpQ+ve7tvWYhUxUjDkGStkyWL9ihUTVox" +
       "MlvRLCZpMrX6KE0iRr9JLWqOSEzRtRhpVazetKEqssLW6UmKAFskM0qaJcZM" +
       "JZFhtNcmwMjsKHAS4ZxEuoLLnVFSJ+vGmAs+wwPe7VlByLS7l8VIU3SHNCJF" +
       "MkxRI1HFYp1ZkywxdHVsUNVZmGZZeId6qa2CtdFL81TQfnfjx5/cNNTEVTBF" +
       "0jSdcfGsjdTS1RGajJJGd3aVStPWTvI1Uh4lkz3AjHREnU0jsGkENnWkdaGA" +
       "+3qqZdLdOheHOZSqDBkZYmSen4ghmVLaJtPPeQYKNcyWnSODtHNz0gop80S8" +
       "ZUlk/4Hrmn5eThpjpFHRBpAdGZhgsEkMFErTCWpaXckkTcZIswbGHqCmIqnK" +
       "uG3pFksZ1CSWAfM7asHJjEFNvqerK7AjyGZmZKabOfFS3KHsX5UpVRoEWae5" +
       "sgoJe3AeBKxVgDEzJYHf2SgVw4qWZGROECMnY8eXAQBQq9OUDem5rSo0CSZI" +
       "i3ARVdIGIwPgetoggFbq4IAmIzOLEkVdG5I8LA3SOHpkAK5fLAHUJK4IRGGk" +
       "NQjGKYGVZgas5LHPe31X7LteW6OFSBnwnKSyivxPBqS2ANJGmqImhXMgEOsW" +
       "R2+Vpj2wN0QIALcGgAXML796+uoL2k49JmDOLQCzPrGDyiwuH000PDWre9Gy" +
       "cmSjxtAtBY3vk5yfsn57pTNrQISZlqOIi2Fn8dTGR76y+w76bojU9pIqWVcz" +
       "afCjZllPG4pKzdVUo6bEaLKXTKJaspuv95JqeI8qGhWz61Mpi7JeUqHyqSqd" +
       "/wYVpYAEqqgW3hUtpTvvhsSG+HvWIIRUw0Pq4Gkj4sO/GRmMDOlpGpFkSVM0" +
       "PdJv6ii/FYGIkwDdDkUS4PXDEUvPmOCCEd0cjEjgB0PUXgA0OJRKWkF3GtPk" +
       "BITMTfzngEFlBZzdDKPDGf+/rbIo9ZTRsjIwyKxgOFDhJK3R1SQ14/L+zIpV" +
       "p++KPyFcDY+HrS9GlsLuYbF7mO8ext3DYvdwkd1JWRnfdCpyITwA7DcMkQBC" +
       "cd2igW1rt+9tLwfXM0YrQPkI2u5LSd1uuHBifFw+2VI/Pu/Vix8KkYooaZFk" +
       "lpFUzDBd5iDELnnYPt51yJCbM+Z6cgYmO1OXaRJCVrHcYVOp0UeoifOMTPVQ" +
       "cDIant1I8XxSkH9y6uDoDVu+flGIhPxpAreshAiH6P0Y3HNBvCMYHgrRbbzx" +
       "7Y9P3rpLdwOFL+846TIPE2VoD7pFUD1xefFc6Z74A7s6uNonQSBnEhw8iJFt" +
       "wT18cajTiekoSw0InNLNtKTikqPjWjZk6qPuDPfXZv4+FdxiMh7MdniW2SeV" +
       "f+PqNAPH6cK/0c8CUvCcceWAcfiPv3/nC1zdTnpp9NQFA5R1ekIaEmvhwavZ" +
       "ddtNJqUA98rB/u/f8t6NW7nPAsT8Qht24NgNoQxMCGr+5mM7X3zt1aPPhlw/" +
       "Z5DTMwkojbI5IXGe1JYQEnZb6PIDIVGFWIFe07FZA/+E8yYlVIoH69PGBRff" +
       "89d9TcIPVJhx3OiCMxNw589ZQXY/cd3f2ziZMhlTsqszF0zE+Sku5S7TlMaQ" +
       "j+wNT8/+waPSYcgYEKUtZZzywFvJdVDJJZ/ByKKSgQUCCk1iWQVHzx8d8AQO" +
       "ZBIWnGQAZcqInfUu6d8u7+3o/7PIaOcUQBBwrccj393ywo4nuVvU8OAF88hU" +
       "vScSQEzx+GSTMNdn8CmD5z/4oJlwQmSPlm47hc3N5TDDyALni0oUnX4BIrta" +
       "Xhs+9PadQoBgjg8A0737v/1ZeN9+YWtRCM3Pq0W8OKIYEuLg0InczSu1C8fo" +
       "eevkrvuP77pRcNXiT+uroGq98/l/Pxk++PrjBXJHdULXVSqJALcUD0Au3E/1" +
       "20cItfJbjb++qaW8ByJNL6nJaMrODO1NeqlCLWdlEh6DuUUWn/CKh8ZhpGwx" +
       "2gFnLrelxq8rPe9dDKODLrEgm/hzddbx1ybu6VgthkW1iPPL+YaXcpiLcviE" +
       "4xO+tgGHBZY3lPsdwXMRiMs3PftB/ZYPHjzNlem/SXgj1zrJEJZsxmEhWnJ6" +
       "MNWukawhgFt6qu/aJvXUJ0AxBhRlKCis9SZk/awvztnQldUv/fahadufKieh" +
       "HlILSkn2SDxlkEkQq6k1BAVD1vjS1SJUjdbA0MRFJXnC501guJhTOBCtShuM" +
       "h47xe6f/4opjR17lMdO227kcvwJrGF+NwO+jbpq645kvPnfse7eOCkctcewC" +
       "eDP+tV5N7HnjH3kq51m5wEkM4MciJw7N7L7qXY7vpkfE7sjm111QYri4l9yR" +
       "/ijUXvVwiFTHSJNs3/+2SGoGk04M7jyWcymEO6Jv3X9/EcV6Zy79zwqGAs+2" +
       "wcTsPV0VzHeS3FzcgCacC898O03ND+biMsJfZI5yHh8X43Chk/omGabOgEua" +
       "DGS/+hJkGam17BqzdyXO9Imcj+NGHGxim4v65Da/DEvgOd/e7PwiMqhCBhxS" +
       "+awWw4Yj6rBqJy6cvizAb3qC/KLOw/aO4SL8WiX5LYYNFkF+V9BBhdc+ywOc" +
       "sglyehE8S+29lhbhdLwkp8WwgdNczwnCwOwCuX2jNMqvznH52vOapnUs+7Dd" +
       "TqMFYD137H33/yoWO69JFsCFqozA3fr4sRr55fQjvMpA3pb5ddAKz0pbCv7N" +
       "yDWfx2WvCwbRadLAWtS5SJ412jyj+KKtq+CfDatd71/+0yuFzuYVCbQu/H0b" +
       "Xn/q8PjJE6JAwOPByJJibbH8XhzeUhaUuGm5xvxo9fJT77y5ZZtjmwYcvpFL" +
       "4PnZDhe+UzjrB87C9SXOQtb16SU5b+CfKhLoMnjLeje1EdT27GKNIF6FHd2z" +
       "/0hy/W0XO6KtgCPBdONClY5Q1UOqyn88wG7reOvLTTmvNNz85n0dgysmconG" +
       "ubYzXJPx9xww1eLipgqy8uiev8zcdNXQ9gnch+cEtBQkefu6E4+vXijfHOJ9" +
       "PpEL8/qDfqROfwasNSnLmJq/opyfs2sL2msmPGtsu64JRjrXcwIukbvpFUMt" +
       "UUX+uMTaT3D4ESM1THcL0z7Xdw+dKY6XrtpwYqvB5w/4r+az4Nlgy7Jh4moo" +
       "hlpC1DtLrJ3E4TjDPjHcYLBLTQuV+hUjupJ0lXP7WVDOFFzDQuYaW8JrJq6c" +
       "YqglFPBAibXf4HAvXGIUa9UI5f21ZK7psdxVx31nQR0oDk+McVumeAl1BOtG" +
       "EqgVK0rQCcjvXDbt8L+gZL+hF/9cGJFUzssTJTT5BxweZmSyRkcdJJzqdZX4" +
       "yNlS4gwur/jsPINPPZavt2KohfWGP5/kVF8qoY4/4fAcIw0mTUMqKKKR58+W" +
       "RjCr7rbF2j1xjRRDDQgc4oyE/rfOlZNXsIPF1cD5eKuEDt/F4Q1Gpg5JWlLl" +
       "iJh9NxtJidGAJt/8PDSZZWR6kc49XtJn5P1zKP7tku860lgz/cjmF3jtkPtH" +
       "qg6qgFRGVb3XSM97lWHSlMIFrROXSoN/fQi31FKKZKRKvHAp/iaQPmaktSAS" +
       "BHb88sL+E8JdEJaRSv7thfsUcoYLB9uKFy/IZ4yUAwi8wj3GcYNLSrqB+Jcq" +
       "oN1smb/sy5m19Uxm9VSK830VFv8z2KmGMv12zX3yyNq+609fdpvofcuqND6O" +
       "VCZHSbVow+cqqnlFqTm0qtYs+qTh7kkLnNqzWTDsnq5zPb68FSKHgU40M9AY" +
       "tjpy/eEXj17x4O/2Vj0NF4KtpExiZMrW/FZG1shAKbs1mt8nhOqTd6w7F/1w" +
       "7KoLUu+/zJtFRPQVZxWHj8vPHtv2zM0zjraFyOReUgllNc3yHsvKMW0jlUfM" +
       "GKmH/JgFFoEKlBC+JmQD+ruE9RXXi63O+tws/nPCSHt+Dzb//6ZaVR+l5go9" +
       "oyWRTD1Uv+6MU1n7itKMYQQQ3BnblDj24NCZRWuAx8aj6wzDaVGTvQY//auL" +
       "3nfKpvBXfJv6X4lFx/koIgAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
