package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.TreeSet;

import it.unimi.dsi.webgraph.ImmutableGraph;
import it.unimi.dsi.webgraph.Transform;

import jrapl.EnergyCheckUtils;

public class PageRankGraph@mode<?->X> {
  public ImmutableGraph g;
  public ImmutableGraph t;

  attributor {
    int nnodes= g.numNodes();
    if (nnodes >= 1000000) {
      return @mode<high>;
    } else if (nnodes >= 500000) {
      return @mode<mid>;
    } else {
      return @mode<low>;
    }
  }

  public PageRankGraph(ImmutableGraph g, ImmutableGraph t) {
    this.g = g;
    this.t = t;
  }
}
