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
          1456094295000L;
        public static final java.lang.String jlc$ClassType$jl7 =
          ("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" +
           "2yPikS/f/A/DC6j8NhQAAA==");
        public static final java.lang.String jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456094295000L;
        public static final java.lang.String jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAALU5a6wkWVk1d3YeO7vszC7ssqzse0B2i9zq9yMDSFd1dXd1" +
           "16Oru6q6u0Rm69lV3fXoenVVF67CJsBGDBJdEBPYXxCVLI+oRBODWWMUCMSI" +
           "IYomssSYiCIJ+0M0roqnqu+9fe+dmUVivEmfe+qc7/vO967vfPXC96FzgQ/B" +
           "K9fazC033NeScH9hVffDzUoL9vtkdSj5gaZilhQEHFi7rjz2hcs/fOUjxpU9" +
           "6LwIvVZyHDeUQtN1gpEWuNZaU0no8m4VtzQ7CKEr5EJaS0gUmhZCmkF4jYTu" +
           "OIYaQlfJQxYQwAICWEByFpDWDgogvUZzIhvLMCQnDDzoF6AzJHR+pWTshdCj" +
           "J4msJF+yD8gMcwkAhYvZswCEypETH3rkSPatzDcI/FEYee7X333ld85Cl0Xo" +
           "sumMM3YUwEQIDhGhO23NljU/aKmqporQ3Y6mqWPNNyXLTHO+ReiewJw7Uhj5" +
           "2pGSssVopfn5mTvN3alksvmRErr+kXi6qVnq4dM53ZLmQNb7drJuJexk60DA" +
           "SyZgzNclRTtEuW1pOmoIPXwa40jGqwMAAFAv2FpouEdH3eZIYAG6Z2s7S3Lm" +
           "yDj0TWcOQM+5ETglhB64JdFM1ytJWUpz7XoI3X8abrjdAlC354rIUELo3tNg" +
           "OSVgpQdOWemYfb5Pv+3D73F6zl7Os6opVsb/RYD00CmkkaZrvuYo2hbxzifJ" +
           "j0n3fenZPQgCwPeeAt7C/P7Pv/zOtz704le2MD91ExhGXmhKeF35lHzXN96I" +
           "PdE8m7FxceUGZmb8E5Ln7j882LmWrEDk3XdEMdvcP9x8cfRns/d+RvveHnSJ" +
           "gM4rrhXZwI/uVlx7ZVqa39UczZdCTSWg2zVHxfJ9AroA5qTpaNtVRtcDLSSg" +
           "26x86bybPwMV6YBEpqILYG46uns4X0mhkc+TFQRBd4IfdDf4EdD2L/8fQjPE" +
           "cG0NkRTJMR0XGfpuJn+AaE4oA90aSBA5uuXGSOAriOvPj54V19cQoH4V2MBH" +
           "xqa9srTRweN+5mKr/0/iSSbZlfjMGaD0N54OeQtES8+1APR15bkIxV/+3PWv" +
           "7R2FwIFOQqgKTtw/OHE/O3H/8MT9kydeRSNlqYWc4WuSCp05k5/6uoyNrZmB" +
           "kZYg3EEivPOJ8c/1n3r2sbPAv1bxbUDDGShy63yM7RIEkadBBXgp9OLH4/cJ" +
           "v1jYg/ZOJtaMdbB0KUMfZunwKO1dPR1QN6N7+YPf/eHnP/a0uwutE5n6IOJv" +
           "xMwi9rHTSvZdRVNBDtyRf/IR6YvXv/T01T3oNpAGQOoLJeCqIKs8dPqME5F7" +
           "7TALZrKcAwLrrm9LVrZ1mLouhYbvxruV3Pp35fPMpfehg+GEb2e7r11l4+u2" +
           "3pIZ7ZQUeZZ9+3j1yW/9+T+Vc3UfJuTLx15xYy28diwJZMQu5+F+984HOF/T" +
           "ANzffXz4ax/9/gd/NncAAPH4zQ68mo0YCH5gQqDm93/F+5uXvv2pb+7tnCYE" +
           "b8FItkwl2Qr5I/B3Bvz+O/tlwmUL2wC+BzvIIo8cpZFVdvKbd7yBhGKBuMs8" +
           "6Crv2K5q6qYkW1rmsf95+U3FL/7Lh69sfcICK4cu9dYfT2C3/gYUeu/X3v1v" +
           "D+VkzijZC22nvx3YNku+dke55fvSJuMjed9fPvgbX5Y+CfItyHGBmWp52oJy" +
           "fUC5AQu5LuB8RE7tlbLh4eB4IJyMtWOFx3XlI9/8wWuEH/zRyzm3JyuX43an" +
           "pNW1ratlwyMJIP/601HfkwIDwFVepN91xXrxFUBRBBQV8LoOGB9kj+SElxxA" +
           "n7vwt3/8J/c99Y2z0F4HumS5ktqR8oCDbgeergUGSF7J6mfeufXm+CIYruSi" +
           "QjcIv3WQ+/Ons4DBJ26dazpZ4bEL1/v/g7HkZ/7+329QQp5lbvK+PYUvIi98" +
           "4gHsHd/L8XfhnmE/lNyYlUGRtsMtfcb+173Hzv/pHnRBhK4oBxWgIFlRFkQi" +
           "qHqCw7IQVIkn9k9WMNvX9bWjdPbG06nm2LGnE83ubQDmGXQ2v7Qz+BPJGRCI" +
           "50r79f1C9vzOHPHRfLyaDT+91Xo2fQuI2CCvJAGGbjqSldN5IgQeYylXD2NU" +
           "AJUlUPHVhVXPydwLauncOzJh9rfl2DZXZWN5y0U+r93SG64d8gqsf9eOGOmC" +
           "yu5D//CRr//K4y8BE/Whc+tMfcAyx06ko6zY/cALH33wjue+86E8AYHsMz73" +
           "yu9+K6M6eDWJs6GdDfihqA9koo7dyFc0UgpCKs8TmppL+6qeOfRNG6TW9UEl" +
           "hzx9z0vLT3z3s9sq7bQbngLWnn3ul360/+Hn9o7Vxo/fUJ4ex9nWxznTrznQ" +
           "sA89+mqn5Bidf/z803/4W09/cMvVPScrPRxcZD77V//19f2Pf+erNyk1brPc" +
           "/4Nhwzv+olcJiNbhHynM9EmsjJKJzpQRXLU3en3MMaMS5ShiTKzgbglnSwXF" +
           "NPtTOagqZYlyeLnQ8m1KhdVGF0ZC2RadusyQrlTk+1KR7ZBC1E3axWnNnnvd" +
           "gjlq8cTEsATXKwzGg4In4R16qZvtBtobYQOnSRTQKlWn61FddZiE7Y9TrUwj" +
           "a1uXEV2Dh47v4ZJR6zMzn1ja9Ul/mcRxCVRV7bBXa2txZVTC115aFQy9mVQi" +
           "EKLTDm8XerSmxZTXnBvz1E1oTGszDsfNVIM3ORozKXG46JAm3vZoe1ITu/II" +
           "VYtEp9REBYctyt0Ix5MUpd2iTHVp3pni4rg3Z7pMOJibY6LAs9XOFNFsXqK9" +
           "kkyhsDRjtSnitiUlQElCMSx/vEJaBcHa2N3CSlKLxnop9WVZiWYOxwaWOepY" +
           "i8SqD1WF6nPaFO5ifhD12yVYSesK0aml7ZW9TGZiJR0ZKWljotQ1J1iZ7bY7" +
           "/ZSrMZE7cMsTw52LtWW9zho867koW256LcwfrQlPlGukhjNK6gjdyJ9i3a66" +
           "YtOA63XQGUJ7dEtkaDZJy2LSHaTq1O9PJpZlVAymPJiHQ2eyqLIjYSB2UIxu" +
           "aFXGdN2YRwnUSAaYweCMqxQWk7lY7K6wgFL6QGNGWrZHsjMsjEdU2mmQ66gi" +
           "rKOFZLC2PB9U5osSLqqWYBfETpXp97mytxGdCm7HIVeKBcGtbIY6GrdmamdA" +
           "Vds9x+kBry8sS7Q7KY/wDS9H9QaB9tACN+vG6w4/FiZFs4SjIbXkKRmveJUq" +
           "WquaY7Zomey8PzbIcbCpyrVSwHmdfsGeiKUxLltjuOWtahXWgI0BTvMciWLS" +
           "oNAfDSy+t4kWo7ii1pvVErFZdBkzwNXpHPbgDlstjdgStRxtTJRZtXpdRFs6" +
           "DS4kqyWaiDm8uyHxZST2pvUQVrqIU7CjcXUlWhJRpRyM8DY1d9qv+nqZ9nWl" +
           "pAhCbciExkZF6wilWB3LbdbkskfQGE1rlcDQ++vSdFxikIiB0XqVQRKr08bC" +
           "iWdF+IQgmpIghfNaLBnNBON4akNYS7KY0Fwt0QN+Mh8OJbWwVNYqQUYKC/YE" +
           "IzS9UBmtlQ7OTHqtKa1gqRzNAqTpdEkM1sxUxDwUhz2UhwdjDknaaru5sape" +
           "ocX73T5Hb4qW1fEVfamgSX/ZKsMzIUmF1FhMFkxnJJDtlQh7RcnCFnN9XjTZ" +
           "vpD0ZGy46C2RZZp26sOG09gMyjJdpEjgeuXEDTWW8aoyarV6wmQ6bddRr4Ys" +
           "e8X2yqDWLaXhtJlCz+St4WzVJ7mhO17C/DhCQkWdebFbtgYBIZrUuFMcCmrb" +
           "MGyMbk2ttrOQS+0hXJS6nFiPPIJEAnvixxSmh4MoqCMsbsM4pgljuEgr5TAi" +
           "ybXFmR7nUSW/TUy79Q3dGwy4VqftWR29vRgN2eWM7AbtMt/tGT23Kg5oCrOs" +
           "kYcntSljmxJfT5nCMOBQuRg12P5EsBvSBvYYC0upYW+97spTnCfhRmfaZekY" +
           "nSPDwAUByvFlAacmRHVdCVKhvWk0mUmjI3Xak+lwo0163XGp2RLSWeRqddJz" +
           "onIl0RKy0SxjdX3SKs6BhVicVZeiZREd2gf33HJ/VqPahlNgiRKMrfUkLgRc" +
           "rSTOcGUpY6FOBwulOl7yvACYiPReXdJ1WJ/oww3VqMlabzQw14tkOOlWiGXq" +
           "JfQcb/rLfqc3GHdazWatU1A0PerJdoQDPdBm1aHQaL2etTt4pxAT1HBdlmtl" +
           "XVtPe3G957ExWwoDL2DmbMXH7CGvx8UGAELsXqWy0PGhORYiBC358rhm2Eqz" +
           "W2/BfKscb1otsaICOtKSUGtcoHBohHeaFIL7TmGNREXFrGzKLS6Eo2jTZGb0" +
           "XC9TuhZhNJ40i9hilli6Po0JHLVZLlTZnsNWOXMiVXsNpVtm/Hpx4FSkCtqY" +
           "F5s9x8TRUR/dYKMWV8aKiNIPZZmAG3BSVVVusehv4MClW6pV1Om13kQLdYKZ" +
           "+nEYbmJtpTBYL1ALfqFgdFszEGayxrvcCimV6qk6oUYqPZ+NJL8N0kY7aEbT" +
           "kV8fz8xUbZG4iA/WmMngijtDK4ncVxqe4RfXaVStwQWnvEmxgO/xM9qYTQqs" +
           "WVm1m2LbSwCdCiqHZLLhtSDlY5UwEQL3hp1xEktMLOtOpW2Mgr5JbJowQw/T" +
           "NC4rvE+YzXCjMROKGqqzqGxsijUxRNKk0JiMg5gLS9ZEEZQa57o1YWWwyUwo" +
           "NqRuZ8QgJDVcWGTYF8rIHJ/JfQRJ5SZsy2lsNLWpxJWK5RUrYsyo6XpMwMUb" +
           "sjYut7y1JvWQ9YKruw6cVvsmSGEOp65a6xSkP3SeNjy2V5xaxZkOB9HUneo2" +
           "58TtMCwIje5kWq0P0dRvwumkXAjIpShgOisQpXrVVWuxUMDdPodxdjOh1iDz" +
           "j23BGehuvxdO6QbqbNxFgydHfH/TiBzc5ShQNc5VQ1vijWZcJONBXJzGFSXy" +
           "19Q6rvIBJQi9qTHg3Ik2rY3WPNYk0JUco5NquNYcxGeKmmqxS8mpsvOEkddx" +
           "jdL7ShxsGG0izGy9I6ANmKg1BBak3bU5qppaMuNmboUCdfsYoRBErTds2XCm" +
           "rmfUbIu0mtqYQeabvlOsVXoI3vbrIzFRRGm+GUqzfoQXGB224d6wjdp8Y6ry" +
           "arVcRJUJXublDow0/bHZLKxKS3zmutVk1R209DYsGD5fJTlDKdG4L4YNbtop" +
           "MDPBmgzc1GnwndVmLMJtszAimq1yfTktdTeFeBO2wcu9jEhavGQpfh4R8ID2" +
           "4VLVw7UFSVaEfk1umj7aN+rV9mJTKJkdlmSdyaQ62NRjfW3XG3N3uIQRs0At" +
           "msUUqS/6SbnCuAi9UUB2QRFLoAWM75d8akFXi0I9YtRuA57WptNaZClFeaYW" +
           "8XSJimazsxzXOIRplixKa6tmrGpIOBVLvjYfu7VFtyu6Zb3HNgVH60y6hNLq" +
           "1hc1pd1s1Zutwpzq+4VmuVprSiUkqtcb01QJ23ANxGVJF1JmuF5h1aE+HbFl" +
           "1PBdIiGoGSWpjB5Npgzl0UNW1UKFT5FwuRpPRkGhQaRdZDMPEI2p+oOovIlF" +
           "zfAD3/P9OGK7jE7I3FBZFuk5tmhpdZRrrhp4ryyopUpFwXriwBVCXZqEk7Ue" +
           "jRIKYcIiT7MWeC+MaLsdLxs8TxYa7ca05S7KMW4yTnEqNkk0hOGhG9RFqtFm" +
           "xka3kXbo9aI+JXiTnXCxx2ClzdBcjhEdaSFtrLZo0AYLCvi3vz0r7d/1k92u" +
           "7s4vkkdNfnCpyja6P8GtIrn5geCSe2Hlm2sp1JKjnlreXbjjVXpqx/oOUHaB" +
           "evBWLf388vSpZ557XmU+Xdw76NdMwH354EvLjk52g33y1rdEKv+csWsifPmZ" +
           "f36Ae4fx1E/QJn34FJOnSf429cJXu29WfnUPOnvUUrjhQ8tJpGsnGwmXfC2M" +
           "fIc70U548EitlzN1vQH8+gdq7d+8VXlzQ+WesfWHV+mFha+yt84GN4TO+tFW" +
           "T6NjTiOAi+raNdWdN61+3B31RCsqhO483ik/7HC85X/bZwfmv/+Gz3fbT07K" +
           "556/fPH1z/N/nTeXjz4L3U5CF/XIso53co7Nz698TTdzwW/f9nVW+b9nQugN" +
           "t2QqhC4eTnMJ3rfFeX8IXTmNA/SV/TsO9mwI3XEMDITWwew40IeAAQBQNv3l" +
           "1U0aQVv9JWdOxtiRVe75cVY5FpaPn4in/Bvqoe9H26+o15XPP9+n3/Ny7dPb" +
           "BrhiSWmaUblIQhe2vfij+Hn0ltQOaZ3vPfHKXV+4/U2HgX7XluGdVx/j7eGb" +
           "d5hxexXmPeH0D17/e2/7zee/nfel/gdBx9Yi3B4AAA==");
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
      1456094295000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAALVZDYxUVxW+M/vLsrA/sPyV32VBltKZUou1WWyBhYWlC6ws" +
       "rGVUhjdv7uw89s17j/fu7M4uokDSgsYSpJRibNEYGpDQQrSNVVtDg1qaEpNa" +
       "lNoEatREtGKK1tYUtZ5z73vzfmZmySayybv73r333PNzz/3OOXdOXycVlklm" +
       "Uo1F2JBBrcgqjXVLpkWT7apkWZugLy4/WSb9Y+u19feHSWWMjE9L1jpZsmiH" +
       "QtWkFSMzFM1ikiZTaz2lSaToNqlFzQGJKboWI02K1ZkxVEVW2Do9SXFCr2R2" +
       "kQaJMVNJZBnttBdgZEYXSBLlkkSXB4fbukitrBtD7vQpnuntnhGcmXF5WYzU" +
       "d22XBqRolilqtEuxWFvOJHcaujrUp+osQnMssl1dYptgbdeSAhM0n6374ObB" +
       "dD03wQRJ03TG1bM2UktXB2iyi9S5vatUmrF2kC+Tsi4y1jOZkZYuh2kUmEaB" +
       "qaOtOwukH0e1bKZd5+owZ6VKQ0aBGJnjX8SQTCljL9PNZYYVqpmtOycGbWfn" +
       "tRVaFqj4xJ3Rw09urf9+GamLkTpF60FxZBCCAZMYGJRmEtS0lieTNBkjDRps" +
       "dg81FUlVhu2dbrSUPk1iWdh+xyzYmTWoyXm6toJ9BN3MrMx0M69eijuU/VWR" +
       "UqU+0HWSq6vQsAP7QcEaBQQzUxL4nU1S3q9oSUZmBSnyOrY8BBOAtCpDWVrP" +
       "syrXJOggjcJFVEnri/aA62l9MLVCBwc0GZlWclG0tSHJ/VIfjaNHBuZ1iyGY" +
       "NYYbAkkYaQpO4yvBLk0L7JJnf66vX3pgp7ZGC5MQyJyksoryjwWimQGijTRF" +
       "TQrnQBDWLuw6Ik16eX+YEJjcFJgs5vzwSzeWLZp57oKYc0eRORsS26nM4vLx" +
       "xPg3pre33l+GYlQbuqXg5vs056es2x5pyxmAMJPyK+JgxBk8t/EXW3afou+G" +
       "SU0nqZR1NZsBP2qQ9YyhqNRcTTVqSowmO8kYqiXb+XgnqYL3LkWjondDKmVR" +
       "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" +
       "BN84brf3ud9h8xEPmvwz9z9PzNW9yx4AAA==");
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
      1456094295000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "/w2Cb+D/ry4AAA==");
}
