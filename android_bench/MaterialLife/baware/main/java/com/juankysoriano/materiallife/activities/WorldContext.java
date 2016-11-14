package com.juankysoriano.materiallife.activities;

import com.juankysoriano.materiallife.world.World;

public class WorldContext@mode<?->X> {

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

  /*
  public mcase<int> frameRate = mcase<int> {
    saver:30;
    managed:45;
    full:60;
  };
  */

  public int frameRate = 60;

  public World@mode<X> newWorldInstance() {
    World@mode<X> world = World.@mode<X>newInstance();
    world.frameRate(frameRate);
    return world; 
  }
}
