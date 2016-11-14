package com.duckduckgo.mobile.android.activity;

import ent.runtime.*;

public class QualityContext@mode<?->X> {
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

  // LAST

  /*
  private mcase<Tuple> qos = mcase<Tuple> {
    saver:    new Tuple(false,false);
    managed:  new Tuple(false,true);
    full:     new Tuple(true,true);
  };

  private Tuple qos;

  public Tuple getQos() {
    return this.qos;
  }
  */

  private mcase<boolean> use_javascript = mcase<boolean> {
    saver: false;
    managed: true;
    full: true;
  };

  private mcase<boolean> use_autosearch = mcase<boolean> {
    saver: false;
    managed: false;
    full: true;
  };

  public boolean getUseJavascript() {
    return this.use_javascript;
  }

  public boolean getUseAutosearch() {
    return this.use_autosearch;
  }


}
