package com.duckduckgo.mobile.android.activity;

import ent.runtime.*;

import java.util.List;
import java.util.ArrayList;

public class SizeContext@mode<?->X> {
  private List<String> searches = new ArrayList<>();
  
  attributor {
    int numSearches = searches.size();
    System.out.format("ENT: Search size: %d\n", numSearches);
    if (numSearches > 16) {
      System.out.format("ENT: Selecting full size\n");
      return @mode<full>;
    } else if (numSearches > 8) {
      System.out.format("ENT: Selecting managed size\n");
      return @mode<managed>;
    } else {
      System.out.format("ENT: Selecting saver size\n");
      return @mode<saver>;
    }
  }

  modesafe public void registerSearch(String search) {
    this.searches.add(search);
  }
}
