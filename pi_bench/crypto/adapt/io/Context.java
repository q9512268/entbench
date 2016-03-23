package io;

public class Context {
  public static FileCache fileCache;

  static {
    fileCache = new FileCache();
  }
}
