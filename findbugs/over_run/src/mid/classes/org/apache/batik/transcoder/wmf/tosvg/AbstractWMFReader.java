package org.apache.batik.transcoder.wmf.tosvg;
public abstract class AbstractWMFReader {
    public static final float PIXEL_PER_INCH = java.awt.Toolkit.getDefaultToolkit(
                                                                  ).
      getScreenResolution(
        );
    public static final float MM_PER_PIXEL = 25.4F / java.awt.Toolkit.
      getDefaultToolkit(
        ).
      getScreenResolution(
        );
    protected int left;
    protected int right;
    protected int top;
    protected int bottom;
    protected int width;
    protected int height;
    protected int inch;
    protected float scaleX;
    protected float scaleY;
    protected float scaleXY;
    protected int vpW;
    protected int vpH;
    protected int vpX;
    protected int vpY;
    protected int xSign = 1;
    protected int ySign = 1;
    protected volatile boolean bReading = false;
    protected boolean isAldus = false;
    protected boolean isotropic = true;
    protected int mtType;
    protected int mtHeaderSize;
    protected int mtVersion;
    protected int mtSize;
    protected int mtNoObjects;
    protected int mtMaxRecord;
    protected int mtNoParameters;
    protected int windowWidth;
    protected int windowHeight;
    protected int numObjects;
    protected java.util.List objectVector;
    public int lastObjectIdx;
    public AbstractWMFReader() { super();
                                 scaleX = 1;
                                 scaleY = 1;
                                 scaleXY = 1.0F;
                                 left = -1;
                                 top = -1;
                                 width = -1;
                                 height = -1;
                                 right = left + width;
                                 bottom = top + height;
                                 numObjects = 0;
                                 objectVector = new java.util.ArrayList(
                                                  ); }
    public AbstractWMFReader(int width, int height) { this();
                                                      this.width =
                                                        width;
                                                      this.height =
                                                        height; }
    protected short readShort(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[2];
        is.
          readFully(
            js);
        int iTemp =
          (255 &
             js[1]) <<
          8;
        short i =
          (short)
            (65535 &
               iTemp);
        i |=
          255 &
            js[0];
        return i;
    }
    protected int readInt(java.io.DataInputStream is) throws java.io.IOException {
        byte[] js =
          new byte[4];
        is.
          readFully(
            js);
        int i =
          (255 &
             js[3]) <<
          24;
        i |=
          (255 &
             js[2]) <<
            16;
        i |=
          (255 &
             js[1]) <<
            8;
        i |=
          255 &
            js[0];
        return i;
    }
    public float getViewportWidthUnits() { return vpW;
    }
    public float getViewportHeightUnits() { return vpH;
    }
    public float getViewportWidthInch() { return (float)
                                                   vpW /
                                            (float)
                                              inch;
    }
    public float getViewportHeightInch() { return (float)
                                                    vpH /
                                             (float)
                                               inch;
    }
    public float getPixelsPerUnit() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public int getVpW() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpW /
                                          (float)
                                            inch);
    }
    public int getVpH() { return (int) (PIXEL_PER_INCH *
                                          (float)
                                            vpH /
                                          (float)
                                            inch);
    }
    public int getLeftUnits() { return left; }
    public int getRightUnits() { return right; }
    public int getTopUnits() { return top; }
    public int getWidthUnits() { return width; }
    public int getHeightUnits() { return height; }
    public int getBottomUnits() { return bottom; }
    public int getMetaFileUnitsPerInch() { return inch;
    }
    public java.awt.Rectangle getRectangleUnits() {
        java.awt.Rectangle rec =
          new java.awt.Rectangle(
          left,
          top,
          width,
          height);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectanglePixel() {
        float _left =
          PIXEL_PER_INCH *
          (float)
            left /
          (float)
            inch;
        float _right =
          PIXEL_PER_INCH *
          (float)
            right /
          (float)
            inch;
        float _top =
          PIXEL_PER_INCH *
          (float)
            top /
          (float)
            inch;
        float _bottom =
          PIXEL_PER_INCH *
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public java.awt.geom.Rectangle2D getRectangleInch() {
        float _left =
          (float)
            left /
          (float)
            inch;
        float _right =
          (float)
            right /
          (float)
            inch;
        float _top =
          (float)
            top /
          (float)
            inch;
        float _bottom =
          (float)
            bottom /
          (float)
            inch;
        java.awt.geom.Rectangle2D.Float rec =
          new java.awt.geom.Rectangle2D.Float(
          _left,
          _top,
          _right -
            _left,
          _bottom -
            _top);
        return rec;
    }
    public int getWidthPixels() { return (int) (PIXEL_PER_INCH *
                                                  (float)
                                                    width /
                                                  (float)
                                                    inch);
    }
    public float getUnitsToPixels() { return PIXEL_PER_INCH /
                                        (float)
                                          inch; }
    public float getVpWFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      width /
                                    (float)
                                      inch /
                                    (float)
                                      vpW; }
    public float getVpHFactor() { return PIXEL_PER_INCH *
                                    (float)
                                      height /
                                    (float)
                                      inch /
                                    (float)
                                      vpH; }
    public int getHeightPixels() { return (int) (PIXEL_PER_INCH *
                                                   (float)
                                                     height /
                                                   (float)
                                                     inch);
    }
    public int getXSign() { return xSign; }
    public int getYSign() { return ySign; }
    protected synchronized void setReading(boolean state) {
        bReading =
          state;
    }
    public synchronized boolean isReading() { return bReading;
    }
    public abstract void reset();
    protected abstract boolean readRecords(java.io.DataInputStream is)
          throws java.io.IOException;
    public void read(java.io.DataInputStream is) throws java.io.IOException {
        reset(
          );
        setReading(
          true);
        int dwIsAldus =
          readInt(
            is);
        if (dwIsAldus ==
              org.apache.batik.transcoder.wmf.WMFConstants.
                META_ALDUS_APM) {
            int key =
              dwIsAldus;
            isAldus =
              true;
            readShort(
              is);
            left =
              readShort(
                is);
            top =
              readShort(
                is);
            right =
              readShort(
                is);
            bottom =
              readShort(
                is);
            inch =
              readShort(
                is);
            int reserved =
              readInt(
                is);
            short checksum =
              readShort(
                is);
            if (left >
                  right) {
                int _i =
                  right;
                right =
                  left;
                left =
                  _i;
                xSign =
                  -1;
            }
            if (top >
                  bottom) {
                int _i =
                  bottom;
                bottom =
                  top;
                top =
                  _i;
                ySign =
                  -1;
            }
            width =
              right -
                left;
            height =
              bottom -
                top;
            mtType =
              readShort(
                is);
            mtHeaderSize =
              readShort(
                is);
        }
        else {
            mtType =
              dwIsAldus <<
                16 >>
                16;
            mtHeaderSize =
              dwIsAldus >>
                16;
        }
        mtVersion =
          readShort(
            is);
        mtSize =
          readInt(
            is);
        mtNoObjects =
          readShort(
            is);
        mtMaxRecord =
          readInt(
            is);
        mtNoParameters =
          readShort(
            is);
        numObjects =
          mtNoObjects;
        java.util.List tempList =
          new java.util.ArrayList(
          numObjects);
        for (int i =
               0;
             i <
               numObjects;
             i++) {
            tempList.
              add(
                new org.apache.batik.transcoder.wmf.tosvg.GdiObject(
                  i,
                  false));
        }
        objectVector.
          addAll(
            tempList);
        boolean ret =
          readRecords(
            is);
        is.
          close(
            );
        if (!ret)
            throw new java.io.IOException(
              "Unhandled exception while reading records");
    }
    public int addObject(int type, java.lang.Object obj) {
        int startIdx =
          0;
        for (int i =
               startIdx;
             i <
               numObjects;
             i++) {
            org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
              (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                objectVector.
                get(
                  i);
            if (!gdi.
                   used) {
                gdi.
                  Setup(
                    type,
                    obj);
                lastObjectIdx =
                  i;
                break;
            }
        }
        return lastObjectIdx;
    }
    public int addObjectAt(int type, java.lang.Object obj,
                           int idx) { if (idx == 0 ||
                                            idx >
                                            numObjects) {
                                          addObject(
                                            type,
                                            obj);
                                          return lastObjectIdx;
                                      }
                                      lastObjectIdx =
                                        idx;
                                      for (int i =
                                             0; i <
                                                  numObjects;
                                           i++) {
                                          org.apache.batik.transcoder.wmf.tosvg.GdiObject gdi =
                                            (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                                              objectVector.
                                              get(
                                                i);
                                          if (i ==
                                                idx) {
                                              gdi.
                                                Setup(
                                                  type,
                                                  obj);
                                              break;
                                          }
                                      }
                                      return idx;
    }
    public org.apache.batik.transcoder.wmf.tosvg.GdiObject getObject(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                 objectVector.
                 get(
                   idx);
    }
    public int getNumObjects() { return numObjects;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVcC3QcxZWtGdmSLH9kyx/8wX8ZYmPPxOAPi0jAFrYlkGyt" +
       "ZYwRIXJrpiQ17ulud9dYY4Ehhs3icLIOBwxhF8PuGicBHwMJgbPAJtg5Yfkc" +
       "SACHE/MJnw0kIQF2IRAcQhb2veqa6Z6e7pIajXZ1Tte0uurVe/fVq1evPt2H" +
       "3yUjbYvMMxU9rSTYTpPaiTa8b1Msm6YbNcW2N8HTztR1/3njVSd+MWp3nFR2" +
       "kHG9it2aUmy6VqVa2u4gM1XdZoqeovZ6StNI0WZRm1o7FKYaegeZrNrNGVNT" +
       "UyprNdIUC2xWrBYyQWHMUruyjDaLChiZ3cKlSXJpkqv8BRpayJiUYe50CaYX" +
       "ETR68rBsxuVnMzK+5TJlh5LMMlVLtqg2a8hZ5DTT0Hb2aAZL0BxLXKYtF4o4" +
       "v2V5iRrmfb/2o0+u7x3P1TBR0XWDcYj2Rmob2g6abiG17tM1Gs3Y28mVpKKF" +
       "jPYUZqS+Jc80CUyTwDSP1y0F0o+lejbTaHA4LF9TpZlCgRiZW1yJqVhKRlTT" +
       "xmWGGqqZwM6JAe2cAtp8c/sg3nRact+3vzr+vgpS20FqVb0dxUmBEAyYdIBC" +
       "aaaLWvaqdJqmO8gEHRq8nVqqoqn9orXrbLVHV1gWTCCvFnyYNanFebq6gpYE" +
       "bFY2xQyrAK+bG5X4b2S3pvQA1ikuVgfhWnwOAGtUEMzqVsD2BMmIbaqe5nZU" +
       "TFHAWH8BFADSqgxlvUaB1QhdgQekzjERTdF7ku1gfHoPFB1pgAla3NZCKkVd" +
       "m0pqm9JDOxmZ6i/X5mRBqVFcEUjCyGR/MV4TtNJ0Xyt52ufd9WfvvVxv0uMk" +
       "BjKnaUpD+UcD0Swf0UbaTS0K/cAhHLOo5WZlyo/3xAmBwpN9hZ0y/3bF++cu" +
       "nnX0CafMjIAyG7ouoynWmTrYNe65kxsX/k0FilFtGraKjV+EnPeyNpHTkDPB" +
       "00wp1IiZiXzm0Y2PXfy1Q/TtOKlpJpUpQ8tmwI4mpIyMqWrUWkd1aimMppvJ" +
       "KKqnG3l+M6mC+xZVp87TDd3dNmXNZITGH1Ua/H9QUTdUgSqqgXtV7zby96bC" +
       "evl9ziSEjIeLTIarnjh//JeRXLLXyNCkklJ0VTeSbZaB+LFBuc+hNtynIdc0" +
       "kl1g/9uWLE2sTNpG1gKDTBpWT1IBq+ilTmaSWYpup8AlWcm+THeSGfaOnuSq" +
       "LugDSopd1Lp2I1UgL4EWaP4/8s6hXib2xWLQZCf7HYYGfa3J0KBsZ2pfdvWa" +
       "9+/pfMoxRuxAQqOMrAQBEo4ACS5AwhUgAQIkuACJEgFILMb5TkJBHDOBRt4G" +
       "7gL89ZiF7Zeev3XPvAqwT7NvBLRQHIqeUjJ+Nbp+JT8YdKYOP7fxxDM/qzkU" +
       "J3FwPV0wfrmDSH3RIOKMgZaRomnwYmHDSd6lJsMHkEA5yNFb+nZvvuqLXA7v" +
       "uIAVjgSXhuRt6M0LLOr9/iCo3tpr3/ro3pt3Ga5nKBpo8uNjCSU6nHn+VvaD" +
       "70wtmqM80PnjXfVxMgK8GHhupkBPA6c4y8+jyPE05J04YqkGwN2GlVE0zMp7" +
       "3hrWaxl97hNufhP4/SRo4tHYE0+G62zRNfkv5k4xMT3JMVe0GR8KPkh8qd28" +
       "7YWf//4Mru78eFLrCQTaKWvw+DCsrI57qwmuCW6yKIVyr9zSduNN7157Cbc/" +
       "KDE/iGE9po3gu6AJQc1ff2L7i6+9evD5eMFmYwwG8WwXxEO5Akh8TmokINHO" +
       "XXnAB2rgC9Bq6i/UwSrVblXp0ih2kr/WLlj6wDt7xzt2oMGTvBktHrgC9/m0" +
       "1eRrT331xCxeTSyFY7CrM7eY49gnujWvsixlJ8qR231s5j8+rtwGQwS4ZVvt" +
       "p9zTEq4DwhttGcef5OkZvrwVmNTbXuMv7l+eWKkzdf3z743d/N4j73Npi4Mt" +
       "b1u3KmaDY16YLMhB9Sf5HU2TYvdCuWVH139lvHb0E6ixA2pMgVO1N1jgoXJF" +
       "liFKj6x66Sc/nbL1uQoSX0tqNENJr1V4JyOjwLqp3QseM2eec67TuH3V+SEn" +
       "R0rAoz5nB7fUmozJuG77Hzzp/rO/d/ur3Kh4DTNL+8v5wpTOD+4vmJ6CyaJS" +
       "Kwwj9bVXvOCD670+GIP89ix49jZLzUCn2iFCkHunnNj+aFX/efnwIojEKXmB" +
       "3frMw02/6+Sdthp9NT5HtmM9XniV1ePxGOMdGJ/BXwyuT/FC8fGBM5jXNYqI" +
       "Yk4hpDBNtIGFkjlAMYTkrrrXtu1/624Hgj/k8hWme/Zd91li7z6nJzpx6fyS" +
       "0NBL48SmDhxMmlG6uTIunGLt7+7d9e937rrWkaquOMpaA5OIu3/5P08nbnn9" +
       "yYCBukIVcwts0JjjoHio5msdB1Ll0ts+vurvX9gAo0Azqc7q6vYsbU5764TA" +
       "2s52eZrLjXj5Ay84bBpGYougFfBBE0/XSJzCFkzO5VkrMVnleNCzBtex8ME5" +
       "DsUM/myujTMif/TAp7XuwPfOy7e+ceTEHVWOciWm4qOb+pcNWtfVv/5ziUvi" +
       "43yA9fjoO5KH909v/PLbnN4dcJF6fq40MIOQxKU9/VDmT/F5lf8RJ1UdZHxK" +
       "TCE3K1oWh7EOmDbZ+XklTDOL8ounQE6831AIKE72m6+HrX+o99rECFbU/u7o" +
       "PhWbRoHrVOFyTvV7qxjhNynHYfF0ISaLeRNW4O0SGFFtPlFlIIKqK5pvZD1J" +
       "woCRcW3NW9a0dLat2djZvL6xiZOuFd0Pfy7w3G9ADuDfS/oM/nuhx7Vy+0wP" +
       "ZJ+XFiuiB64vCDm/EKIIS6YITHow6Q3QQFjNjIxpbeXwuSLw2TYfEHvwQMbh" +
       "Uyy2ULBbGAKkPxgIhEejTMtgYHc07UMxVlItg2CHdvNgp8kn/eXDIP01mFwB" +
       "1mCpPb2BXP9uGLjuEVwrmGEG8fzGMPD8B8GzsstgzMgEsd07DGxvyCu4T007" +
       "U3U/1xuHgeu382B7aVi73jIMbPcLtiNUPRWI9baITBfDtUgwXRTC9F/dGHBX" +
       "aT8Lo0Zfm1I0uiXITxwYBjHvxOSOPNuLg9jeNQxs7xZsqxy0gXzvich3AVyn" +
       "Cb6nhfC9T9oqYdTgEnaYFwVZzg+HQcaHMLmf82wK4vnwMPB8xOW5JYjnkWHg" +
       "+VOX58VBPB+NyBOnZUsEzyUhPJ+Qtn8YNfjJXLvaowdJ+eTnkDIh+CRCpHxG" +
       "KmUYNUi5M0zKZwcvJQYz5Iviyt8HSfnL4BAjjrdXMlK9w9AgatSoL8yYIqka" +
       "qLpwqVLVewYKFKu6DEOjij6oUPF4xEY6Ba6lQsalIfDflDZSGDUIrtqrtHSW" +
       "k7zik/M3EeXEcPt0wen0EDnflsoZRg1xomobzDJMNRUk6TsRJV0H1zLBa1mI" +
       "pH+UShpGDWNXhuVnwH67/2AYxPwYkw8hrs+wJr6s3q72BzL/yzAw/1QwH5Vh" +
       "m6llizVVP+fPys85ViE4g7ZDAMdGDAPbasF2dIatN5wZsx3Ee1RE3ug9lwve" +
       "y0N4j5UaZBg1l7VVyW2kKcNKB8k6bhhknYRJLcy3UU98h4MyagWqavLnCOhW" +
       "CPYrQthPk6oqjBpU1afqaaPvopBpSGz6MMg6B5MZ0IEd3k1hk5HY3IjMZ8K1" +
       "UjBfGcJ8gVRRYdSM1OjZjMT8T4ko6hy4zhTMzgwRdbFU1DBq0KvB5dxM+dkD" +
       "i8wOXIzeqPTxrffO1DfnfX33qVXvr3AWAecElvbs0p9xYkXtnEN36k7x4MVx" +
       "3/78ry9/6oDxq7fjcbHUua5YGXVw3SXg8F9GLivr/jBUkkkyNQNxTXKTmqFp" +
       "PL5CdZbfjf4/5IaL3jNKlmXdxnjg4e+u3LN4ywFHu3NDVmTd8g/97evP3dZ/" +
       "72Fn9Rt3Exg5LewITum5H9wgXSDZ5HWb/U/rzjr6+zc2X5pvw3Foossds58K" +
       "fs+71cS35WJfGkxsGFsy+J4zOt/JzxLGclZIz1nt9pyADaAwakbGAlzm9PLm" +
       "dC6onzdKpM1JAvIlEFor4jyAG5Dzv1riO5nhEYmXnCHW+MFyZoYdnuFbJQev" +
       "3nd7esN3luabqA3iFGaYSzS6g2qequbzjRe/DbbyI0PuOvvKYycqXr5h6pjS" +
       "MwVY06yQEwOLwo3Jz+Dxq/8wfdOXe7dGOCww24ffX+VdrYefXHdK6oY4P/Xk" +
       "LOuXnJYqJmooXsyvsSjLWnrxls68QotNyptgu2ixdr8JugYT5rnDSHnJpL/T" +
       "5DuYs5erGonzFKY062aWtTOLKhlkGLtETjsxT9u8YU0uRU3UMqfrxGQzmAnU" +
       "lG7vNSw20LxvpF0oVdKz3W5yUfS9K3wc21jQFo4JZBpcnUJbndEVHUYarCzk" +
       "/xWuFTO8wFZeADeqYttgLolqa9ad4MVFrw0Z/QTMwlmwJiBoA6APcHNhpD5w" +
       "ni3I2BWSvCsx6WNkcg9lm1XaZ4IZ8LDxQl117GGbq4FceTSA82tbwLCjayCM" +
       "VIJyjyTvOkyuYWSKRwNO8BqkggF3SAanAlzJ6xc4+qOrIIxUAnOfJO9mTL7F" +
       "yCS/ETSLpX2PAq4vXy/YLVDsjq6AMFIJyH+R5B3A5NbiXuDYQIAG9pdHA3Ph" +
       "ulbAuDa6BsJIJSgPS/LuweR7jIwHDbSpOQgs2qiFHcAH/s4hg8fAiJ9b3SsQ" +
       "7I0OPoxUAvBBSd7DmPyQkUpsfrEl4UK+v3yQbxJy3xQdchipBNajkrzHMDmS" +
       "h9zkg3y0PJBnwLVfyL0/OuQwUgmsZyV5xzB5CibSALmFdrvu3QP86fIAx+2I" +
       "O4T0d0QHHkYqAfcrSd6rmByHeRAA31g0sHmQv1Ae5NPhOiTEPxQdeRipBN1b" +
       "krw/YPIGI6MB+SbDDML9Zvla/AdC+B9Exx1GKsH2oSTvI0z+22nx4mjOg/y9" +
       "8iDHadODQvwHoyMPIw1HFyeSPJyWxz5hZBwg90VxHuh/LR/0I0L+I9Ghh5FK" +
       "4I2R5OHSTbzKgb6an3sJgB6vLg90jN8eE/I/Fh16GKkE3lRJ3nRMJsJsGqC3" +
       "UqasVTXKwUMQk4/gPDqYNGQdTM7r4JgAciy6DsJIJTjrJXnIJj6bkQno5WmK" +
       "KXqPUAIvPpWROr5eoPSxRCHf1cmcIeuEb3HjQb0XBbAXo+skjFSC+3RJ3jJM" +
       "lvh04oS3QifTCjrpoUbGVczp57mqSZRHNTjt/a3A99voqgkjlcA/V5K3GpMG" +
       "J+AvoBZ9Jb7CBX92+VzlBwLBB9HBh5FKALZI8tZjss5xlXx8dG3C4yaayjfR" +
       "+1jI/3F06GGkEnhbJHkdmLQ77c69wybDBe9O9OKbygMe2/0zgeCz6ODDSCUA" +
       "05K8bkw6nSkATPScF158wLeWDXhspFOD8xsJeCipBJx/fdObhyDj2/LAmwKB" +
       "D319k/f0WSD1aCH96OjAw0gl4CTrm3Fc34z3MVJbiAcDu/rQVzY5dvDzsToB" +
       "oC469jBSCT7JymYcVzbj1zBSDdi3FM6wuaCHvpZZAD1NSD4tOugwUgkwyVpm" +
       "HNcy499yQF8cAHro65e4qkEaQOKZQvKZEtA8DTjHN8beCWOtZehqf8krA9Ml" +
       "dfuQezZqXuHwD0hUcxCTWxmpsXHId88D+vaCRuww1LSrsKEvd87BrIUg5nwB" +
       "an5UheFLIvF/Ln0/JLRGiRbuk+Tdj8lhfkpPKIhr1lXG3UNWBt9qBI3ExPn6" +
       "WMn5+sEoI3aBTxkTJTVKAB+R5P0Ek4fwdREKBoP/fNdVxIDHpQdUxGzMWkTw" +
       "gIMjdkvkbhSkiCmSGkM7j7NDGH86vADfIYz/HJPHGBmNO4TOSTTbZyGPD1kx" +
       "fOSDeVSMChhUopjtwU41jHQgDbwwkAZewuQX4CRQAz6beL4848lUYChWQGPR" +
       "F09DSX3I4q4dOaMDTAbH88kgvkWYcI6LcMhvSvrIW5i8Bg5DSacdErdCrpPX" +
       "y7asGvuRAPaj6DoJI/Uhq3Bfy8Mdgfhv+B0H+keJEj7E5F3oFQUlrPKr4b/K" +
       "s+KCseWzAsuz0dUQRho+qDrgPw0HX4H1xD8GC4B4w3OSEKwpObjviaxLqx46" +
       "rq0BjzgPek06dlxAPh5dW2GkEmVIlicrcHmyospZk15ffOqygLzic6xO5hiZ" +
       "UPJNFvwiwdSSD0c5HztK3XN7bfVJt194nH8XpPBBojEtpLo7q2neV4A995Wm" +
       "RbtVrrYxzgvB/A3wismMLBhUQ8NAyn8RRsUkhxisZPYAxAx6ZabbSzSDkRkS" +
       "Iojv3H+8dLPAwfnpQCj+6y03F2pwyzFS6dx4i9SDVFAEbxeY4d7TOalUOOiW" +
       "b2Uy4FFpz9m4+UUnz/gnw/KnxLJt4rTkvbefv/7y91d8x/lgSkpT+vuxltEt" +
       "pMr5dguvtKLk5KW3tnxdlU0LPxn3/VEL8qftJjgCu91lhmvT5BzoHiba2nTf" +
       "10Ts+sJHRV48ePYjP9tTeSxOYpeQmMLIxEtK31bPmVmLzL6kJegTBpsVi3/o" +
       "pKHmja3P/PmlWB3/hAZxPnowS0bRmbrxkZfbuk3zn+JkVDMZqeppmuOv0p+3" +
       "U4fwZYdV9EWEyi4jqxe+LjYOO4aCnxPjmhEKHVt4ih/cYWRe6cchSj9CVKMZ" +
       "fdRajbVjNWN9Z/OypunN5ZrdhElzDjUNttbZ0mqa4qsY1XxUOsc0sftXnIn/" +
       "XPi/kYi23RdQAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "tTI/C9gROViZBmiGO6zuJ2wzbCymcDgB");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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");
}
