package com.danielkim.soundrecorder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.Context;
import android.content.BroadcastReceiver;
import android.media.MediaRecorder;

import java.io.IOException;
import android.os.SystemClock;

import com.danielkim.soundrecorder.activities.MainActivity;

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

  private int kb_bitrate = 160;
  private int kb_samplerate = 24;

  RecordingChunk@mode<saver<=*<=X> chunk;

  public EnergyAwareMediaRecorder() { }

  public void prepare(String filePath, RecordingChunk@mode<?> dchunk) throws IOException {
    this.recorder = new MediaRecorder();

    this.recorder.setAudioSource(MediaRecorder.AudioSource.MIC);
    this.recorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
    this.recorder.setOutputFile(filePath);
    this.recorder.setAudioEncoder(MediaRecorder.AudioEncoder.AAC);

    this.recorder.setAudioEncodingBitRate(kb_bitrate * 1000);
    this.recorder.setAudioSamplingRate(kb_samplerate * 1000); 

    try {
      chunk = snapshot dchunk ?mode[@mode<saver>,@mode<X>];
    } catch (Exception e) {
      System.err.format("ENT: Energy Throwning!\n");
      chunk = snapshotforce dchunk ?mode[@mode<saver>,@mode<X>];
      boolean recover = ((Boolean) ENT_Properties.getProperty("ENT_RECOVER"));
      if (recover) {
        System.err.format("ENT: Recovered!\n");
        this.recorder.setAudioSamplingRate(8000); 
      }
    }

    System.err.format("ENT: Using SampleRate:%d kHz BitRate:%d kb/s\n",kb_samplerate, kb_bitrate);

    this.recorder.prepare();
  }

  public void start(Context context) {
    AlarmManager manager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    Intent intent = new Intent(MainActivity.STOP_RECORD_INTENT);
    PendingIntent pintent = PendingIntent.getBroadcast(context, 0, intent, PendingIntent.FLAG_CANCEL_CURRENT);

    // Start alarm using notification time
    manager.setExact(AlarmManager.ELAPSED_REALTIME,
            SystemClock.elapsedRealtime() + this.chunk.getTime(),
            pintent);

    this.recorder.start();
  }

  public void stop() {
    this.recorder.stop();
  }

  public void release() {
    this.recorder.release();
  }

}

