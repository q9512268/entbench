package org.sunflow.core.renderer;
public class SimpleRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private int numBucketsX;
    private int numBucketsY;
    private int bucketCounter;
    private int numBuckets;
    public int ENT_attribute() { int batteryMode = org.sunflow.BatteryContext.
                                                     batteryMode;
                                 if (batteryMode == 2) { return org.sunflow.EntMode.
                                                                  HIGH_MODE;
                                 }
                                 else
                                     if (batteryMode ==
                                           1) {
                                         return org.sunflow.EntMode.
                                                  MID_MODE;
                                     }
                                     else {
                                         return org.sunflow.EntMode.
                                                  LOW_MODE;
                                     } }
    public boolean prepare(org.sunflow.core.Options options, org.sunflow.core.Scene scene,
                           int w,
                           int h) { this.scene = scene;
                                    imageWidth = w;
                                    imageHeight = h;
                                    numBucketsX = imageWidth +
                                                    31 >>>
                                                    5;
                                    numBucketsY = imageHeight +
                                                    31 >>>
                                                    5;
                                    numBuckets = numBucketsX *
                                                   numBucketsY;
                                    return true; }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            32);
        bucketCounter =
          0;
        org.sunflow.system.Timer timer =
          new org.sunflow.system.Timer(
          );
        timer.
          start(
            );
        java.lang.Thread[] renderThreads =
          new java.lang.Thread[scene.
                                 getThreads(
                                   )];
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            renderThreads[i] =
              new org.sunflow.core.renderer.SimpleRenderer.BucketThread(
                );
            renderThreads[i].
              start(
                );
        }
        for (int i =
               0;
             i <
               renderThreads.
                 length;
             i++) {
            try {
                renderThreads[i].
                  join(
                    );
            }
            catch (java.lang.InterruptedException e) {
                org.sunflow.system.UI.
                  printError(
                    org.sunflow.system.UI.Module.
                      BCKT,
                    "Bucket processing thread %d of %d was interrupted",
                    i +
                      1,
                    renderThreads.
                      length);
            }
        }
        timer.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              BCKT,
            "Render time: %s",
            timer.
              toString(
                ));
        display.
          imageEnd(
            );
    }
    private class BucketThread extends java.lang.Thread {
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) { int bx;
                                           int by;
                                           synchronized (SimpleRenderer.this)  {
                                               if (bucketCounter >=
                                                     numBuckets)
                                                   return;
                                               by =
                                                 bucketCounter /
                                                   numBucketsX;
                                               bx =
                                                 bucketCounter %
                                                   numBucketsX;
                                               bucketCounter++;
                                           }
                                           renderBucket(bx,
                                                        by,
                                                        istate);
                            } }
        public BucketThread() { super(); }
        public static final java.lang.String jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "R7588z9/gz7+LBQAAA==");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("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" +
           "b/utF75Z9KT+B+UIxgvOHgAA");
    }
    public void renderBucket(int bx, int by, org.sunflow.core.IntersectionState istate) {
        int x0 =
          bx *
          32;
        int y0 =
          by *
          32;
        int bw =
          java.lang.Math.
          min(
            32,
            imageWidth -
              x0);
        int bh =
          java.lang.Math.
          min(
            32,
            imageHeight -
              y0);
        org.sunflow.image.Color[] bucketRGB =
          new org.sunflow.image.Color[bw *
                                        bh];
        for (int y =
               0,
               i =
                 0;
             y <
               bh;
             y++) {
            for (int x =
                   0;
                 x <
                   bw;
                 x++,
                   i++) {
                org.sunflow.core.ShadingState state =
                  scene.
                  getRadiance(
                    istate,
                    x0 +
                      x,
                    imageHeight -
                      1 -
                      (y0 +
                         y),
                    0.0,
                    0.0,
                    0.0,
                    0);
                bucketRGB[i] =
                  state !=
                    null
                    ? state.
                    getResult(
                      )
                    : org.sunflow.image.Color.
                        BLACK;
            }
        }
        display.
          imageUpdate(
            x0,
            y0,
            bw,
            bh,
            bucketRGB);
    }
    public SimpleRenderer() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDYxUVxW+M/vLsrA/7PJXfpcFWUpnSi3WZrEFFhaWLuzK" +
       "ArajMrx5c2fnsW/ee7x3Z3d2EQWSFjSWIKUUY4vG0BQJLUTbWLU1NKilKTGp" +
       "RalNoEZNRCumaG1NUes5974372dmlmwim7y77917zz0/99zvnHPn1DVSYZlk" +
       "FtVYhA0b1Iqs1livZFo02aFKlrUJ+uLyE2XSP7Ze3XBvmFTGyMS0ZK2XJYt2" +
       "KlRNWjEyU9EsJmkytTZQmkSKXpNa1ByUmKJrMdKsWF0ZQ1Vkha3XkxQnbJHM" +
       "btIgMWYqiSyjXfYCjMzsBkmiXJLoiuBwezeplXVj2J0+1TO9wzOCMzMuL4uR" +
       "+u7t0qAUzTJFjXYrFmvPmeR2Q1eH+1WdRWiORbarS20TrOteWmCCljN1H9w4" +
       "mK7nJpgkaZrOuHrWRmrp6iBNdpM6t3e1SjPWDvJlUtZNxnsmM9La7TCNAtMo" +
       "MHW0dWeB9BOols106Fwd5qxUacgoECNz/YsYkill7GV6ucywQjWzdefEoO2c" +
       "vLZCywIVH789eviJrfXfLyN1MVKnaH0ojgxCMGASA4PSTIKa1opkkiZjpEGD" +
       "ze6jpiKpyoi9042W0q9JLAvb75gFO7MGNTlP11awj6CbmZWZbubVS3GHsr8q" +
       "UqrUD7pOdnUVGnZiPyhYo4BgZkoCv7NJygcULcnI7CBFXsfWB2ACkFZlKEvr" +
       "eVblmgQdpFG4iCpp/dE+cD2tH6ZW6OCAJiPTSy6KtjYkeUDqp3H0yMC8XjEE" +
       "s8ZxQyAJI83BaXwl2KXpgV3y7M+1DcsO7NTWamESApmTVFZR/vFANCtAtJGm" +
       "qEnhHAjC2kXdR6TJL+8PEwKTmwOTxZwffun68sWzzp4Xc24rMqcnsZ3KLC4f" +
       "T0x8Y0ZH271lKEa1oVsKbr5Pc37Keu2R9pwBCDM5vyIORpzBsxt/8dDuk/Td" +
       "MKnpIpWyrmYz4EcNsp4xFJWaa6hGTYnRZBcZR7VkBx/vIlXw3q1oVPT2pFIW" +
       "ZV2kXOVdlTr/BhOlYAk0UQ28K1pKd94NiaX5e84ghFTBQ+6Dp46IP/6fkU3R" +
       "tJ6hUUOJ9po6qm5FAWwSYNZ01MpqKVUfilqmHNXN/vy3rJs0CpZPgvnNaJ8C" +
       "sEc32p8R9C7jFq2bQ30mDYVCYOoZwYOuwhlZq6swOy4fzq5cff25+OvCidDx" +
       "bUswshA4RmyOEeQYcThG/BxJKMQZNSFnsZ+wGwNwrgFYa9v6vrhu2/6WMnAk" +
       "Y6gcTIlTW3wBpsM9/A5ix+XTjRNG5l5Zci5MyrtJoySzrKRivFhh9gMSyQP2" +
       "Ya1NQOhxI8AcTwTA0GXqMk0CAJWKBPYq1fogNbGfkSbPCk58wpMYLR0dispP" +
       "zh4d2rPlK3eGSdgP+siyAvAKyXsRqvOQ3Bo87MXWrdt39YPTR3bp7rH3RREn" +
       "+BVQog4tQVcImicuL5ojvRB/eVcrN/s4gGUmwTECxJsV5OFDlXYHoVGXalA4" +
       "pZsZScUhx8Y1LG3qQ24P99EGbJqFu6ILBQTk4P6ZPuOpt375509ySzpxoM4T" +
       "wPsoa/dgDy7WyFGmwfXITSalMO/y0d7HHr+27/PcHWHGvGIMW7HtAMyB3QEL" +
       "Pnx+x2/fuXL8Yth1YQbBN5uAHCbHdWn6GP5C8PwXH8QL7BC40dhhg9ecPHoZ" +
       "yHmBKxvgmAoHH52jdbMGbqikFCmhUjw//66bv+SFvx6oF9utQo/jLYtvvoDb" +
       "P20l2f361g9n8WVCMsZR137uNAHOk9yVV5imNIxy5Pb8auY3X5WeApgHaLWU" +
       "EcrRknB7EL6BS7kt7uTt3YGxe7CZb3l93H+MPPlOXD548b0JW9776XUurT9h" +
       "8u77esloF14kdgGYrSF240NvHJ1sYDslBzJMCQLVWslKw2J3n93whXr17A1g" +
       "GwO2MqQSVo8JGJfzuZI9u6Lq7VfOTd72RhkJd5IaVZeSnRI/cGQceDq10gCx" +
       "OeP+5UKOoWpo6rk9SIGFCjpwF2YX39/VGYPxHRl5ccrzy545doW7pSHWuI3T" +
       "VyPq+xCW5+buIT/55j2/fuYbR4ZEdG8rjWwBuqkf9aiJvb//V8G+cEwrknkE" +
       "6GPRU09O77jvXU7vggtSt+YKIxUAtEt718nMP8MtlT8Pk6oYqZftXHiLpGbx" +
       "XMcg/7OcBBnyZd+4P5cTiUt7HjxnBIHNwzYIa26EhHecje8TAj5Yi1s4x9lu" +
       "57/XB0OEv6zjJAt424bNYgddqgxTgXqJ5vKLcr8YP8qiDCo3GRCGU0yFA14Q" +
       "vvtwWCAttp/G5gHBYVlJN13lV2sGPA22BA0l1Nos1MJmfaH8pahB6aRiGao0" +
       "7GgwtUCDVWJCQIctY9RhITyTbCkmldBh66g6lKJm4IUZyO4/pyRZ2p/mYCrR" +
       "l01YkJIoGQhTg3YyflfvNnl/a+8fxVGcVoRAzGs+EX10y6XtF3gQrMakZ5Pj" +
       "fp6UBpIjT3CtxyaCiDfKEQ/IE93V+M7Ak1efFfIEz3NgMt1/+GsfRw4cFsFJ" +
       "lFvzCioeL40ouQLSzR2NC6fo/NPpXT85sWufkKrRXzyshtr42d/850Lk6O9e" +
       "K5LHlil2yYwAG8qnoE1+UwuFVn217qWDjWWdkP10keqspuzI0q6k/9xXWdmE" +
       "x/ZuGediga0aJgGMhBYBOgdcNn4LXJYnBtsYGc9dcC1V+tO8K3jks2Pk3QZP" +
       "k827qQTv4VGPSylqkBW2bmVWHqDMerCYrCO3QNbd2Oz08X6oGO89Y+S9CJ5m" +
       "m3dzCd4Pj2qnUtSMTEhwQTv0LF5yFJP2kVsg7dex2Qeg5lqqGOtHR2GdKxHi" +
       "8PUON7rxv0pSOm3zZDchJz7MLIgPXej5fRIWpyYCy8xStyccVI7vPXws2fP0" +
       "krCdow4wyNx04w6VDlLVw7AMV/KlU+v5fZGbm1yeeOgPP2rtXzmWWhX7Zt2k" +
       "GsXv2QB4i0rDd1CUV/f+Zfqm+9LbxlB2zg5YKbjk99afem3NAvlQmF+OiaSp" +
       "4FLNT9Tuh8wak7KsqflBcl5+9zmiTYdnvr3784MO6XocPzuH/GenZhTSQE1S" +
       "zne0vHSK0WPkrfXZvLNTLsDxUeqbE9h8myduFMpGkYXJdoTDfynP+3aYl9B1" +
       "lUpaMDDhp53L87P1nZsd69HLCOxYafD+b+VthlBDPgFP1LZZdOzmLkUaMJFH" +
       "qxhf9cVRbPhjbH4ApbW4ZypmtvJBXUm61nn+VlmnE56YrWJs7NYpRRpQvkzA" +
       "i+tmjlu2FCIb4r4lakC8iBceeX4Ua17A5hwjtcKaAr+x7yXXfj/7f9gvx8hE" +
       "/4UgVq9TC35eEFfi8nPH6qqnHNt8iWNl/tq6FlAvlVVVb33lea+EY5VSuF61" +
       "otoSKdVFRqaVvKZkpNp55bK/KWguMVIfpAHPwn/eaW9DhuCZxjDv42/eSZch" +
       "vYRJ+HrFcHavnhfuWGtGRK2ZC3miCfGc7uab2T9P4r2pwhjAf+Nx8DorfuWJ" +
       "y6ePrduw8/qnnhY3ZbIqjYzgKuMhaRX3cXnMn1tyNWetyrVtNyaeGTffiY6+" +
       "mzqvbNwL4MUfJQt+rYvLuVcW10W+O21hGONQoPoP1Nk1YGfwWUh3kjxgwDDG" +
       "w/xVYtYwvMOBApzLVQFPi30Op9zsCHOUMfIeXslVq+TfukAg+A6Dl6Qhqza8" +
       "/XjhBzn+/YYRmA1VfFlGSXKGfwuMERgDDfnY3/mE/Nv7OcOVw61WZhRWK5Aw" +
       "8Eu+uBx77K2uMwMfLue/mlRAZkNz/D5k1bC2kcqDpq+UmYhHTsKfs/hG2/4x" +
       "Id+Ld8KAQIVVXOFNeuEujXd7nL3y5QGBfQMCt8dTuPosFXrQ4DeNIdxZvnHc" +
       "bu9zv8PmIx40+Wfuf1peel7BHgAA");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.SimpleRenderer ENT_ld =
          new org.sunflow.core.renderer.SimpleRenderer(
          );
        ENT_ld.
          scene =
          this.
            scene;
        ENT_ld.
          display =
          this.
            display;
        ENT_ld.
          imageWidth =
          this.
            imageWidth;
        ENT_ld.
          imageHeight =
          this.
            imageHeight;
        ENT_ld.
          numBucketsX =
          this.
            numBucketsX;
        ENT_ld.
          numBucketsY =
          this.
            numBucketsY;
        ENT_ld.
          bucketCounter =
          this.
            bucketCounter;
        ENT_ld.
          numBuckets =
          this.
            numBuckets;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "61D09XXoBMqt7ebkgW4HB5n9xSP7K7duH3zi4NWsegHqFC+lHFk5+PAB6NZP" +
       "iNbitV3fbh+aW5qjQzbbuhN8dz50oKsHt05J+vABmjWx1ergpLe07WzlSdlK" +
       "6XTJzl1q1GrfOXjtAHSqcp4k5O1Iorqt04LemmUw4nYsH5sevHbbdZN9MF0U" +
       "Jac6IHv7D133Pvudv3yfd/8kK/5BAD1+qmvyBdF9PP/iW624nZSaV3z1GPTT" +
       "O6955Qj0K2cXbU/oe+6K7a1t8jmjxAM5wQMXbzWBb75dQBHHC7yv5rJ+7T4G" +
       "+XpW/Gq+Eae4oqectyp5beE4YBS19xb6Z+/CQo9mlT8ALvjIQvBfjIUu7QlG" +
       "OcE37qP272TFvw6gq9uTLOeuxUaOLu9V/jfvVmUCXMKRysJfjMpX9oPXq3sf" +
       "Bu7x8r1jRbYh4W9PGmTn97Y7rv/5Pib6/az4ZgA9tjXRdu8gq/vdvVG+9S6M" +
       "kufXl8+Gd3D5hbeXX8+ObXmF5LjpNs+ePpiUJ5+cwpRByrWV+OAcgluHh4e3" +
       "QWZVItG8tSU+yszZrjPgCzTd3z6cS3a0HbwjPHo8l3S/Ebuj3tdczLDdIzzF" +
       "sa06l+XE7t2O5UTVW7Dw97Lw57Kc2vHaMZ2qfIuW7m0oYzgaSE6w3HkXA8Z/" +
       "v++A8T/u8+5/ZsUfBdBDO/fKnn92HwHfficRkATQE6f9Ljvy8+w952+3Z0al" +
       "r75x/aH3vTH7d/mhseNznQ8PoIfU0DRPntA4cX8VJHJVz7E/vD2vsbXYdwPo" +
       "+y48xwf0293moP90y/NnAXTjLA9IjNnfCbJsS/DRE2RgwDi6O0n0QABdAUTZ" +
       "7YPuOTt929MqyaUTk8yjlJHb+am3svMxy8mDZdnEND8EvZtEhttj0Helr73R" +
       "G37iO9Wf2R5sk0xxs8mkPDSArm3P2B1PRF+6UNpO1tXO7e8+8QsPv7KbND+x" +
       "Bbz30xPY3n/+ybG25Qb5Wa/NP37fP/rBv/fGN/ONx/8PXssa/p0uAAA=");
}
