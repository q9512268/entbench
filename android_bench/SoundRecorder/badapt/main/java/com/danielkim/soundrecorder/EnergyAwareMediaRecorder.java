package com.danielkim.soundrecorder;

import android.media.MediaRecorder;

import java.io.IOException;

public class EnergyAwareMediaRecorder@mode<?->X> {
  attributor {
    if (ENT_Util.Battery.percentRemaining() >= 0.75) {
      System.out.format("ENT: Selected full\n");
      return @mode<full>;
    } else if (ENT_Util.Battery.percentRemaining() >= 0.50) {
      System.out.format("ENT: Selected managed\n");
      return @mode<managed>;
    } else {
      System.out.format("ENT: Selected saver\n");
      return @mode<saver>;
    }
  }

  private MediaRecorder recorder = null;

  private mcase<int> kb_bitrate = mcase<int> {
    saver: 160;
    managed: 160;
    full: 160;
  };

  private mcase<int> kb_samplerate = mcase<int> {
    saver: 8;
    managed: 24;
    full: 48;
  }; 

  public EnergyAwareMediaRecorder() { }

  public void prepare(String filePath) throws IOException {
    this.recorder = new MediaRecorder();

    this.recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    this.recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
    this.recorder.setOutputFile(filePath);
    this.recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

    this.recorder.setAudioEncodingBitRate(kb_bitrate * 1000);
    this.recorder.setAudioSamplingRate(kb_samplerate * 1000); 


    System.err.format("ENT: Using SampleRate:%d kHz BitRate:%d kb/s\n",kb_samplerate, kb_bitrate);

    this.recorder.prepare();
  }

  public void start() {
    this.recorder.start();
  }

  public void stop() {
    this.recorder.stop();
  }

  public void release() {
    this.recorder.release();
  }

}

