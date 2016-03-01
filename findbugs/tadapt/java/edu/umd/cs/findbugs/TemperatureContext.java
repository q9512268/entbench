package edu.umd.cs.findbugs;

public class TemperatureContext@mode<?->X> {
  private mcase<int> sleepTime = mcase<int>{ 
    low: 1000; 
    mid: 250; 
    high: 0; 
  };

  attributor {
    float temp = ENT_Util.Temperature.getTempC();
    ENT_Util.writeModeFile(String.format("Temperature:%f\n",temp));
    if (temp >= 65.0) {
      return @mode<low>;
    } else if (temp >= 60.0) {
      return @mode<mid>;
    } else {
      return @mode<high>;
    }
  }

  boolean tadapt;

  TemperatureContext(boolean tadapt) {
    this.tadapt = tadapt;
  }

  public void sleep() {
    if (tadapt) { 
      if (sleepTime > 0) {
        try {
          Thread.sleep(sleepTime);
        } catch (Exception e) {
        }
      }
    }
  }
}
