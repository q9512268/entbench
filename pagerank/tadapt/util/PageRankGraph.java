package util;

import java.io.FileReader;
import java.io.BufferedReader;
import java.util.Set;
import java.util.TreeSet;

import it.unimi.dsi.webgraph.ImmutableGraph;
import it.unimi.dsi.webgraph.Transform;

import jrapl.EnergyCheckUtils;

public class PageRankGraph {
  public ImmutableGraph g;
  public ImmutableGraph t;

  public PageRankGraph(ImmutableGraph g, ImmutableGraph t) {
    this.g = g;
    this.t = t;
  }
}
