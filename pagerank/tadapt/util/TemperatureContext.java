package util;

public class TemperatureContext@mode<?->X> {
  private mcase<int> sleepTime = mcase<int>{ 
    low: 2000; 
    mid: 1000; 
    high: 0; 
  };

  attributor {
    float temp = ENT_Util.Temperature.getTempC();
    ENT_Util.writeModeFile(String.format("Temperature:%f\n",temp));
    if (temp >= 60.0) {
      return @mode<low>;
    } else if (temp >= 55.0) {
      return @mode<mid>;
    } else {
      return @mode<high>;
    }
  }

  private boolean tadapt;

  TemperatureContext(boolean tadapt) {
    this.tadapt = tadapt;
  }

  public void sleep() {
    if (tadapt && sleepTime > 0) {
      try {
        Thread.sleep(sleepTime);
      } catch (Exception e) {
      }
    }
  }
}
