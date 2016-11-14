package com.danielkim.soundrecorder;

public class RecordingChunk@mode<?->X> {
  private int timems = 0;

  attributor {
    System.err.format("ENT: TimeMs:%s\n", this.timems);
    if (this.timems < 190000) {
      System.err.format("ENT: Data selected saver\n");
      return @mode<saver>;
    } else if (this.timems < 250000) {
      System.err.format("ENT: Data selected managed\n");
      return @mode<managed>;
    } else {
      System.err.format("ENT: Data selected full\n");
      return @mode<full>;
    }
  }

  public RecordingChunk(String timestr) {
    this.timems = Integer.parseInt(timestr) * (60 * 1000);
  }

  public int getTime() {
    return this.timems;
  }
}
