package org.sunflow.core.renderer;
public class ProgressiveRenderer implements org.sunflow.core.ImageSampler, ent.runtime.ENT_Attributable {
    private org.sunflow.core.Scene scene;
    private org.sunflow.core.Display display;
    private int imageWidth;
    private int imageHeight;
    private int[] sigma;
    private java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>
      smallBucketQueue;
    private int counter;
    private int counterMax;
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
    public ProgressiveRenderer() { super();
                                   imageWidth = 640;
                                   imageHeight = 480;
                                   sigma = null;
                                   smallBucketQueue = null;
    }
    public boolean prepare(org.sunflow.core.Options options,
                           org.sunflow.core.Scene scene,
                           int w,
                           int h) { this.scene = scene;
                                    imageWidth = w;
                                    imageHeight = h;
                                    sigma = org.sunflow.math.QMC.
                                              generateSigmaTable(
                                                1 <<
                                                  7);
                                    return true; }
    public void render(org.sunflow.core.Display display) {
        this.
          display =
          display;
        display.
          imageBegin(
            imageWidth,
            imageHeight,
            0);
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
          new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
          );
        b.
          x =
          (b.
             y =
             0);
        int s =
          java.lang.Math.
          max(
            imageWidth,
            imageHeight);
        b.
          size =
          1;
        while (b.
                 size <
                 s)
            b.
              size <<=
              1;
        smallBucketQueue =
          new java.util.concurrent.PriorityBlockingQueue<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket>(
            );
        smallBucketQueue.
          add(
            b);
        org.sunflow.system.UI.
          taskStart(
            "Progressive Render",
            0,
            imageWidth *
              imageHeight);
        org.sunflow.system.Timer t =
          new org.sunflow.system.Timer(
          );
        t.
          start(
            );
        counter =
          0;
        counterMax =
          imageWidth *
            imageHeight;
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
              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucketThread(
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
                      IPR,
                    "Thread %d of %d was interrupted",
                    i +
                      1,
                    renderThreads.
                      length);
            }
        }
        org.sunflow.system.UI.
          taskStop(
            );
        t.
          end(
            );
        org.sunflow.system.UI.
          printInfo(
            org.sunflow.system.UI.Module.
              IPR,
            "Rendering time: %s",
            t.
              toString(
                ));
        display.
          imageEnd(
            );
    }
    private class SmallBucketThread extends java.lang.Thread {
        public void run() { org.sunflow.core.IntersectionState istate =
                              new org.sunflow.core.IntersectionState(
                              );
                            while (true) {
                                int n =
                                  progressiveRenderNext(
                                    istate);
                                synchronized (ProgressiveRenderer.this)  {
                                    if (counter >=
                                          counterMax)
                                        return;
                                    counter +=
                                      n;
                                    org.sunflow.system.UI.
                                      taskUpdate(
                                        counter);
                                }
                                if (org.sunflow.system.UI.
                                      taskCanceled(
                                        ))
                                    return;
                            } }
        public SmallBucketThread() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "nxmeFNyeEI98eeq/LdXdskoUAAA=");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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");
    }
    private int progressiveRenderNext(org.sunflow.core.IntersectionState istate) {
        final int TASK_SIZE =
          16;
        org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket first =
          smallBucketQueue.
          poll(
            );
        if (first ==
              null)
            return 0;
        int ds =
          first.
            size /
          TASK_SIZE;
        boolean useMask =
          !smallBucketQueue.
          isEmpty(
            );
        int mask =
          2 *
          first.
            size /
          TASK_SIZE -
          1;
        int pixels =
          0;
        for (int i =
               0,
               y =
                 first.
                   y;
             i <
               TASK_SIZE &&
               y <
               imageHeight;
             i++,
               y +=
                 ds) {
            for (int j =
                   0,
                   x =
                     first.
                       x;
                 j <
                   TASK_SIZE &&
                   x <
                   imageWidth;
                 j++,
                   x +=
                     ds) {
                if (useMask &&
                      (x &
                         mask) ==
                      0 &&
                      (y &
                         mask) ==
                      0)
                    continue;
                int instance =
                  (x &
                     sigma.
                       length -
                     1) *
                  sigma.
                    length +
                  sigma[y &
                          sigma.
                            length -
                          1];
                double time =
                  org.sunflow.math.QMC.
                  halton(
                    1,
                    instance);
                double lensU =
                  org.sunflow.math.QMC.
                  halton(
                    2,
                    instance);
                double lensV =
                  org.sunflow.math.QMC.
                  halton(
                    3,
                    instance);
                org.sunflow.core.ShadingState state =
                  scene.
                  getRadiance(
                    istate,
                    x,
                    imageHeight -
                      1 -
                      y,
                    lensU,
                    lensV,
                    time,
                    instance);
                org.sunflow.image.Color c =
                  state !=
                  null
                  ? state.
                  getResult(
                    )
                  : org.sunflow.image.Color.
                      BLACK;
                pixels++;
                display.
                  imageFill(
                    x,
                    y,
                    java.lang.Math.
                      min(
                        ds,
                        imageWidth -
                          x),
                    java.lang.Math.
                      min(
                        ds,
                        imageHeight -
                          y),
                    c);
            }
        }
        if (first.
              size >=
              2 *
              TASK_SIZE) {
            int size =
              first.
                size >>>
              1;
            for (int i =
                   0;
                 i <
                   2;
                 i++) {
                if (first.
                      y +
                      i *
                      size <
                      imageHeight) {
                    for (int j =
                           0;
                         j <
                           2;
                         j++) {
                        if (first.
                              x +
                              j *
                              size <
                              imageWidth) {
                            org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket b =
                              new org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket(
                              );
                            b.
                              x =
                              first.
                                x +
                                j *
                                size;
                            b.
                              y =
                              first.
                                y +
                                i *
                                size;
                            b.
                              size =
                              size;
                            b.
                              constrast =
                              1.0F /
                                size;
                            smallBucketQueue.
                              put(
                                b);
                        }
                    }
                }
            }
        }
        return pixels;
    }
    private static class SmallBucket implements java.lang.Comparable<org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket> {
        int x;
        int y;
        int size;
        float constrast;
        public int compareTo(org.sunflow.core.renderer.ProgressiveRenderer.SmallBucket o) {
            if (constrast <
                  o.
                    constrast)
                return -1;
            if (constrast ==
                  o.
                    constrast)
                return 0;
            return 1;
        }
        public SmallBucket() { super(); }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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" +
           "4Tjr0ubt/wCVU2Lf6R0AAA==");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1457076400000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "QbTqkigAAA==");
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public ent.runtime.ENT_Attributable ENT_copy() {
        org.sunflow.core.renderer.ProgressiveRenderer ENT_ld =
          new org.sunflow.core.renderer.ProgressiveRenderer(
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
          sigma =
          this.
            sigma;
        ENT_ld.
          smallBucketQueue =
          this.
            smallBucketQueue;
        ENT_ld.
          counter =
          this.
            counter;
        ENT_ld.
          counterMax =
          this.
            counterMax;
        return ENT_ld;
    }
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1457076400000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7abDsaHVY3zcz771ZmPeYgdnMDHeGN3hmGq661a1e/Bgb" +
       "qVutXtSSelVLBh5q7btaS0vdeGyg7AyJY6DswSEpPL9wFtcYXImppOI4hSvl" +
       "AMF2lV2u2KQq4CxVYQkV+GGcConJJ3Xfrd+9j/dYbpV0pU/nnO+c853tW/q1" +
       "b+buCfxc3nOtlWq54YGchAeGhRyEK08ODrokwgh+IEsNSwiCMWi7IT7zO1e+" +
       "892Palcv5C7yuYcFx3FDIdRdJxjKgWstZYnMXTluxS3ZDsLcVdIQlgIUhboF" +
       "kXoQXidz959ADXPXyEMWIMACBFiAMhYg9BgKIL1OdiK7kWIIThgscj+f2yNz" +
       "Fz0xZS/MPX2aiCf4gr0lw2QSAAqX0/cpECpDTvzc/pHsG5lvEvhjeeiVf/Ce" +
       "q//8rtwVPndFd0YpOyJgIgSd8LkHbNmey36ASpIs8bnXO7IsjWRfFyx9nfHN" +
       "5x4KdNURwsiXj5SUNkae7Gd9HmvuATGVzY/E0PWPxFN02ZIO3+5RLEEFsj5y" +
       "LOtGwlbaDgS8TweM+Yogyocod5u6I4W5N+9iHMl4rQcAAOolWw4196irux0B" +
       "NOQe2oydJTgqNAp93VEB6D1uBHoJc0+cSzTVtSeIpqDKN8LcY7twzOYTgLo3" +
       "U0SKEubeuAuWUQKj9MTOKJ0Yn29S7/jw+5y2cyHjWZJFK+X/MkB6agdpKCuy" +
       "LzuivEF84AXy14VHfv9DF3I5APzGHeANzL/8uW+/821PffbzG5ifOAOGnhuy" +
       "GN4QPzl/8E/f1Hi+flfKxmXPDfR08E9Jnpk/s/1yPfGA5z1yRDH9eHD48bPD" +
       "f8+9/7fkb1zI3dfJXRRdK7KBHb1edG1Pt2SfkB3ZF0JZ6uTulR2pkX3v5C6B" +
       "Z1J35E0rrSiBHHZyd1tZ00U3ewcqUgCJVEWXwLPuKO7hsyeEWvaceLlc7hK4" +
       "cg1wPZTb/GX/wxwHaa4tQ54OMb6bih5AshPOgVo1KIgcxXJjKPBFyPXVo3fR" +
       "9WUIaF4C6vdTPBW4QqAv5eG27SA1Me/HSTxJJbsa7+0Bpb9p1+Ut4C1t1wLQ" +
       "N8RXIgz/9qdufPHCkQtsdRLm3g66Pdh2e5B2e3DY7cEZ3eb29rLe3pB2vxle" +
       "MDgmcHMQAB94fvTu7ns/9MxdwK68+G6g2RQUOj8ON44DQycLfyKwztxnPx5/" +
       "YPoLhQu5C6cDasoyaLovRWfSMHgU7q7tOtJZdK+8/NXvfPrXX3KPXepUhN56" +
       "+s2Yqac+s6tc3xVlCcS+Y/Iv7AufufH7L127kLsbuD8IeaEATBREk6d2+zjl" +
       "sdcPo18qyz1AYMX1bcFKPx2GrPtCzXfj45Zs1B/Mnl8PdHx/asJPgeu5rU1n" +
       "/9OvD3vp/Q0bK0kHbUeKLLq+OPJ+4y//5GulTN2HgfjKidQ2ksPrJ5w/JXYl" +
       "c/PXH9vA2JdlAPefP8782se++fLPZgYAIN5yVofX0nsDOD0YQqDmX/r84ktf" +
       "+fIn//zCsdGEIPtFc0sXkyMh0/bcfbcQEvT21mN+QPCwgKOlVnNt4tiupCu6" +
       "MLfk1Er/75Vni5/5nx++urEDC7QcmtHbvj+B4/bHsdz7v/iev3kqI7Mnpsnr" +
       "WGfHYJuI+PAxZdT3hVXKR/KBP3vyH35O+A0QW0E8C/S1nIWoXKaDXDZoUCb/" +
       "C9n9YOdbMb29OThp/Kf960SRcUP86J9/63XTb/3bb2fcnq5STo51X/Cub8wr" +
       "ve0ngPyju57eFgINwJU/S73rqvXZ7wKKPKAogtQc0D4IEskpy9hC33PpP/3B" +
       "v3vkvX96V+5CK3ef5QpSS8icLHcvsG450ECgSryfeedmcOPL4HY1EzV3k/Ab" +
       "o3gse7sfMPj8+fGllRYZxy762P+hrfkH/+v/vkkJWWQ5I7fu4PPQa594ovHT" +
       "38jwj108xX4quTkCg4LsGBf+LfuvLzxz8Q8v5C7xuavittqbClaUOg4PKpzg" +
       "sAQEFeGp76erlU1qvn4Uwt60G15OdLsbXI4jP3hOodPn+3biyQOplvfB9fDW" +
       "1R7ejSd7uezhZzKUp7P7tfT2k4fue8nz9SVI5Vv//R742wPX36ZXSixt2CTe" +
       "hxrb7L9/lP49kJTuCUTwmmG/EXjWTSlqlH7ehLX0Dqe3d256Q841op86LeKb" +
       "wPWGrYhvOEfE3jkipo+NTG9NIK2kB54lrA7ZfewmdpsbgB2GyTtkOA15j2wZ" +
       "fuQchse3w/B9ug2qVFaXQu3W/sP4ug2C/nJbW0IvPfQV8xNf/e1N3bjrLDvA" +
       "8ode+XvfO/jwKxdOVOtvualgPomzqdgzJl+XcZqGn6dv1UuG0fofn37p9/7p" +
       "Sy9vuHrodO2Jg6nVb//H//dHBx//qy+cUfzcBeYVO6My+TGMing7o3J/Nipt" +
       "WVe1jKd37TAm3SFjj4Hr0S1jj57DmHE7jN0DZnq2AMbi2fMtJctqm4F/9R+/" +
       "5U9+4dW3/JcsMVzWAxCPUF89Y7pzAudbr33lG3/2uic/lRVPd8+FYBOZdueJ" +
       "N08DT83uMoYfOF0zXNoNZGGu/YPW41gkmnKYJbnD2v5HRivj/V1HyW5vWz5n" +
       "45re/MMhW549ZBfSx+fAYCm6I1iHQ3fRkh11MwHKzGnhJUddXNjgHUatTYmS" +
       "phgwD3UdOa12Dr9tqn3dPThaAwAfk5uY9XMvnG8h/WygjhPi5z749SfGP629" +
       "9w7K/DfvGNAuyX/Wf+0LxFvFX72Qu+soPd60QHAa6frppHifL4eR74xPpcYn" +
       "N/rP9LdRfnp7NlPxLQq0l2/x7e+mt18EoyWmqt6MzC3A/36S2wkG5h0Gg3du" +
       "A8JhYDgrGHzkdoLB1QDMTqyN9Q4iOZJvPeqjaB6EJ9Y1fkV/9Y//w19f+cAm" +
       "WJ9OPdnS1hZ1F+9Lf3kXfH947SOZtRwFiMugvglSyDC3f/4yWUZrk1fuPy5I" +
       "cmcXJIXjYhgUYWLkg5lamOYp19fDFWa5Ikhlaib5QbZC521dCrjJC8dl7zHu" +
       "wZm4KcY/OpXezlbdDbFj3xh95ksvV7LsdWWpg1mYLI23632nZx3HM/Hrp9YA" +
       "z1TuDfGrn/6Vzz/99enD2eLORo8pW6VkY4qVrW3tZbZ1Yevh5+WALUfZJOmG" +
       "+HOf+Ns//tpLX/7CXbmLwKlSTxR8GThdmDs4b030JIFrY/DUBFjAPR/cYAPF" +
       "ZeawHfaHjlqPpuJh7u3n0c5KmZ0Ze7qqCKKx7GNu5Egp2ad2YkHkeSe/nswu" +
       "P2ID+nkw97wNvR6pZevI6eoVGOgHjyN3Wu6c/Agy1MMNEh2Nbow5Br8xRYcd" +
       "FCPxzPrSOnsPP7Tdq8dENjOMI6uu39EC0bXRcXw4NVXLJTsh7KN3GMKugevx" +
       "rWyPnxPC/sVt1esiGNNwM2/bLbJ+98fA1L++rZp8y1R/Wwns8PV735evjE6y" +
       "B2Zf98AH1YNC+v4HZ/d817ZWuBhkq/7p2+qQj0cNS7x2OCmbyn4AUvI1w6qe" +
       "YSebdfMdRpu3zWhwynJJ11Gv//J//+gffeQtXwGhrpu7Z5nOfYF5n+iRitJd" +
       "ib/z2seevP+Vv/rlbMUI6HH0zl9y359S/eKtxE1vf3hK1CdSUUdu5IsyKQRh" +
       "P1vkkaUjabkT8rw7zN0NUvUPLm340L9pl4MOevhHToUGHIvJ0JbpdQRz6zCf" +
       "zHB5bYR0p0EgaGGBrrChTsdIIptIf70YUY2qHdRrc8dQJJiqhuu1Phm0PWKh" +
       "4QuzhXbwlrDq1Sy+g6NkccDazUnbnmjxwurOB9YAqxUGXXw0nTSnE9qA1vm1" +
       "zETl4azJspIRV/sQ1Id60BKCFbjpIP2updr2pFBs2Xi1SXityJixXcRkxzPB" +
       "M+1ZcVAMG0uf6ucjxS7nQ1bDnRbaM+fWIpHZOekKLrsYsRG6bnUKesEWxr1i" +
       "0WoIQzfImy1j2u4KcxdWG7xrqXVhQk35zqxYMe0euuZ7vBsXRu6KX9kNojBE" +
       "qqjJ2wmLOpN5ZSzgchyti4RgzySYxmknz/GlaObFfMuTVjBpcnNualsTMJfi" +
       "XJM39GAmBCsOSerNaXtkTfmEEHieCCtOd44RobGCKLzP5JO8WWdKY1KM8UnM" +
       "Sp2CM2vDPlqaFMLp0HZXQxDaimxl6glJhBjeuDXqFJ1+gwr7rDLsNWJBm0yk" +
       "eVgcBkzYnfYjMyqN6aZD2QsDM0sYatSg1ZjodkBGKXr5pS5zHLfglwytc+15" +
       "NLYijJcQkkLyY2cMOXwwb+s1oz6gzVnY1iOswFNBSzUH+KCHF5hJyCxGDd4T" +
       "XbQgLJoB3ZxMR9MpDHteFHijSdfH+wuqNmysebtJ+CtqWuTVYQWj1n2jXy/1" +
       "g7GCN0Uvb68b5gh4cCjOrOmsUSbCCItZt0XZHD1isRJlOoje61gEb469vpHA" +
       "DEcRaMO0WKenLWfiJGIFDIXNEa93erbtCVjSHxeWWAE1K0Sv2V11VrpZ6QXN" +
       "iSmb005BHXI8QYkgRTUnw0a50yVa5shBOSe2C1SDVrtcPc9YSGk1R/ywORXs" +
       "zlBdF8zFompAhN4Q2qOmMOjI7kjEGYxoh2aoSpNgOZZrNB7TqKeKLX3dyS+Z" +
       "ubWqyLFBlsGsczAjfAwSRzbLmnRt7rfDkA8VvcWyZWPkNcNkOFm69XXVntYl" +
       "s14tqg1cEB1K7xaGHsR0tEiESwragUZaf+GEHU1Y+fZ4zE0EOvDiYsuT59a0" +
       "R9sJoa+0wspk/R5Zh+TBaGG0Wx24V1xOm4OEtxhhKCKTwpR2am18UMJaDV0X" +
       "FqoPe82oiMLdpkJVinoDn/a7zSjCvE7UYyBYMielITeu0647GVfHWJEPKx2U" +
       "cvtqMSJcSyKIabtYLTZJa0FUbDHKr+Zhxx01y92yIQ9JlY24hm1IHUZqmfi4" +
       "X6uaSMsx5wwJT1AdZwzGreleeZV4kibhXXmWtwNoabrikIy99QBjV3yf7PQt" +
       "t8StCnwMc/p63hujgT6YlBdBsQx1G0uhIeIzbB1TjpAohF+EqzxdrfWrfZ+b" +
       "qZVRIrTXikLYq9qkgdXQcS0i7NF46bTHyyU8Rj0Dwe0Ry/EjcRYXWMJGu4aJ" +
       "S2FJiEUN902ME8pOh0DNfonluyrB6OqEkBFuofAjAe4jnQAWiW5xpXEFgcTK" +
       "USO/ktpNewWJMlNEynwXxmpNsW920Va9U3KVjjNh3HDRXLaQRUkJoGQcQ0ow" +
       "CUsTEZ1Nuwln43KX6ccMbFIDBrWQ1XTtrcTxOKovynBDbIyMfneJuqjY5uPm" +
       "EOqEzQg15skEFalm5NnslE5WfGtNaWaxHtWXjeacHRaRJUYS/qACz5tidR5q" +
       "yxiq+xzH4uWp5hbhVtRoYOXRMikXq4ZfrcSSXI66JW4i17p5p92DjWJZ4/tF" +
       "kR0upD4MlyqDSeIX6y6dh+E1JNfgYhSsMX0g4C242gxQL260uB63hJhG6Csy" +
       "PZsrBNyerTUTr/ZjFWmW+HaX4cYLj+yjtk/OyBJa0h3UENTifCgtuFa9Z9I9" +
       "qqeNpN6aqSSyXM8PoLox6dDFhpaMCcMTZCUmYKVkgiRNOGu+yiBUA+fLlYLf" +
       "L8kcyrS71SCWPN0J43bRnJeSetEqMSNIQmkU7YTeSLJ6/UV53FFnhEPSCuTU" +
       "lr3GgKq32MaqsOzPl/VVnZl5o8G85BhJb0R1S0hiRhDrFDVEkgo+IZcaSxLj" +
       "rM7M8+I5JnBFsynS5Ua5EkQVD2NmnR6vrVCCnXW6i3WxG2FC0Rb5eqR2rVm9" +
       "jIQ2Swr5qalgi8mitJg4vWLShftjdOx7IRdzxJKNiJU1oatwT1cFuheYBmTX" +
       "MG0cO/3eolIozw00rCKFvM047a4KM+2oO+E5F2HHVr4l0iDp8BU5KlfrK6K2" +
       "zIdws1StG1FsxHo5MlgOi2Afmi3KdBWCVkum21q3G9FAQccuVum0q0h1KMlW" +
       "26HKrVZvGK3yQruHYpYFzWvDek/RaGkGNbx+T5U6Krxy4iSwKI6KaBX1XHpm" +
       "rrroKg/59Qq/7swkb602zXWDEGSeowaIyxMLmnJ9vNZzW2K4cNCI6VJhgpTF" +
       "Ya82KPMTeex0WBKR1ECMMb3gN6d0szME0WcypfSJKrSpxBp18XLSnMUlEq62" +
       "g2mAdhFuxlVbrE9hchFfVSEC+EJP4Utma43P5xVsGnIJQ5Zm5Viw8fLCWrR6" +
       "dBLTXjRNAtztNxgsRsYaMugmYTBThhN31F4UlqtJZyWoQ9buiG3I87pmDFUn" +
       "WEi3ZWI+UI0hPpowE2I+W9cUphoGWhWG/HzPShJZxRt9ttob1Ik5Va0gdXYi" +
       "FyqgwJCt0rqfHycm1kBQ222ypDOrdZVGt7ys9XGJi5k8VoXcwGP8aO4ExIIw" +
       "uw0OJzpGJDieg9BVw4hdQlXRAYGvS9UlFFlIq54vsCpuygVsZjvdRp6ie1xX" +
       "8htqRIaIN51rrd4SUhxjNomhENYpuCgPILE9bsqKPyxBkIOIOiYVa4HJEGxP" +
       "4RIiwRGrH45tCK7gg1UYLZw8UhULlgATrZ7dnhKTAj+NiLo+rg9aLY8fcPWV" +
       "02MUHSnDPRAXNbVLDnAJI5JaLbHj2iBmRXwVlsdCVdMXHseXS12U8o0ysq6y" +
       "TjwmZzPH8swqX7AgIeAotieapkdCFui5p8QMPnYRYSEgJcSDZKOelGf5BmRp" +
       "5da6VuhQ05oGjdclHErImVnqVRciRlM1cixEsDtdagw0K9dDzabDwgwZq5xu" +
       "Fqxqp+Wtx+WuzbWcos3NCKYeaGEVlLM+yDBhhNYdtTvtDef4IGhMUEcctj13" +
       "jNUhpMJMu0FcTbhCBxl4VFhRENJh4ioRQtMGIlWYoVCVxyyPlEmx2B+gcNmL" +
       "elqCxkWdUkm83+MXZi00VayiDRY8N9IgOGTpOCmRsU/SurhqUCu2FrMdC174" +
       "VqtvAkcX591pHTeipRpUgngWcx63RPNLyyd9b02FxRCqWh6oxNZLXBTmrbBu" +
       "m7SvqHkMGhU9Uq+oxRBRlnK7D7nLtlReGSHjOR20iPWkWsQoqo6IS9OuUbVV" +
       "UDRZxZqJM0SX/LrbssKJxyXUuN4nnSbFlWtkh5ZijBfLU2ilDqlancVilEVa" +
       "w4LYiUbqGuJmlYWhFiRNl/2wUEBnVbElKitBZElvpIVMexqHWm9WsmrjERcO" +
       "+gW1X7aESCJmNh7owYrCmURuBWhv5mjRbDnx4UUQKdLAodzhEqQYHmrkvVIZ" +
       "7rcxVs2vVSBcNDY7PWQ1BjWeWFrRpGUQjt4drHCZKk7gDkJPeVGbF4ykOVHK" +
       "7bnRYZl11ArXhJwP7WkUGApX1NcrVuwUtHKwJuHVogYt5vmk0CK6peps7uFE" +
       "JSxXWGcKNWG/2nZGbls3prHjY3GXQujWHC4hJbrr9ERaL8jrJhgoUczjvh3r" +
       "GMs2WzhULiR8m1RNhK6wkDxrhy251vMjQRpqcTcayZLehJCiVyblOT9hKh7X" +
       "0ChFqg3a1nCuYMnMiRaQVK8QmttHR7Vlu0lVa3G1RlMmZFKBh1JVJ2lNHUPr" +
       "zgVDI3VDI4ruXJklPJ1vzmDORECl1dOkKSTblBZP/UToyU5+LkRVkJM4SkqK" +
       "YKIIJjwMqs1M08Tsod5tMSFeRmDVH9YXizLa6/cSetLps1GzzY1sqBfKwMWG" +
       "Gj+1k8ixx86syLODiu7wC1kuzHSiqHHoupNoMhCXaRaMkiNII57PY3MH1K4d" +
       "A29VbLXgL0p0o6fP9RIO8stqCieGo9YK87znr6MkYKnmuCA5fjeaByohuWy1" +
       "jQ99cSQOESYS9V6NL87qBVZa43EFVKWdmaktRw2ZWWM0Q+SbfNWnaspAl5nK" +
       "3HQ02cB8er3uuE7Z8S0CpaG6y8O0PGfJmOaLSLU0rSbLEVGuU/hoBIv1yXhV" +
       "QhVkNhh0FG4cz2s91UN6Wn3qVQUZwiY4oowwLVmC6sOtGyzVTowlXC1CJOnk" +
       "oSUt0uikuyqMbKIWTmjTm67LXWtJghhTtPLNcb/pLPQ6zGoDdlEuo87aJt0G" +
       "aQ7mK7Pdy6sKqRdXjN/kK7DCTeadXsXoUpCgrdiVM6Q4qFNUhsU2OvdaRlPp" +
       "FkawGiGCzcSkhs2msudhU7gtiWbJyEsUL+Tb2ISfFtAh1F1irIKJc3y5Li9x" +
       "39U0D0zzZN+Ya36jNZp1OE3RVAQTRQad0K2kxeUXOphjrheKE7c9kem1ak2t" +
       "bK8rlIS66njdHsVhN/HbWH5p93W2ZeiMBgJioYE4mNdbkSivJx7haRqGtWrt" +
       "MqfMRROpuZIPaZC+wjtmT0OjmoXk2Xo9");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "V4/+7jv+yatfznbM/z+OnKVdHzkAAA==");
}
