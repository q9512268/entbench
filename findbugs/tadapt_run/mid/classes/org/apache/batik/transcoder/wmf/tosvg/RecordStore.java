package org.apache.batik.transcoder.wmf.tosvg;
public class RecordStore {
    public RecordStore() { super();
                           reset(); }
    public void reset() { numRecords = 0;
                          vpX = 0;
                          vpY = 0;
                          vpW = 1000;
                          vpH = 1000;
                          numObjects = 0;
                          records = new java.util.Vector(20, 20);
                          objectVector = new java.util.Vector(); }
    synchronized void setReading(boolean state) { bReading = state; }
    synchronized boolean isReading() { return bReading; }
    public boolean read(java.io.DataInputStream is) throws java.io.IOException {
        setReading(
          true);
        reset(
          );
        int functionId =
          0;
        numRecords =
          0;
        numObjects =
          is.
            readShort(
              );
        objectVector.
          ensureCapacity(
            numObjects);
        for (int i =
               0;
             i <
               numObjects;
             i++) {
            objectVector.
              add(
                new org.apache.batik.transcoder.wmf.tosvg.GdiObject(
                  i,
                  false));
        }
        while (functionId !=
                 -1) {
            functionId =
              is.
                readShort(
                  );
            if (functionId ==
                  -1) {
                break;
            }
            org.apache.batik.transcoder.wmf.tosvg.MetaRecord mr;
            switch (functionId) {
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_TEXTOUT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_DRAWTEXT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_EXTTEXTOUT:
                case org.apache.batik.transcoder.wmf.WMFConstants.
                       META_CREATEFONTINDIRECT:
                    {
                        short len =
                          is.
                          readShort(
                            );
                        byte[] b =
                          new byte[len];
                        for (int i =
                               0;
                             i <
                               len;
                             i++) {
                            b[i] =
                              is.
                                readByte(
                                  );
                        }
                        java.lang.String str =
                          new java.lang.String(
                          b);
                        mr =
                          new org.apache.batik.transcoder.wmf.tosvg.MetaRecord.StringRecord(
                            str);
                    }
                    break;
                default:
                    mr =
                      new org.apache.batik.transcoder.wmf.tosvg.MetaRecord(
                        );
                    break;
            }
            int numPts =
              is.
              readShort(
                );
            mr.
              numPoints =
              numPts;
            mr.
              functionId =
              functionId;
            for (int j =
                   0;
                 j <
                   numPts;
                 j++) {
                mr.
                  AddElement(
                    new java.lang.Integer(
                      is.
                        readShort(
                          )));
            }
            records.
              add(
                mr);
            numRecords++;
        }
        setReading(
          false);
        return true;
    }
    public void addObject(int type, java.lang.Object obj) { for (int i =
                                                                   0;
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
    }
    public void addObjectAt(int type, java.lang.Object obj,
                            int idx) { if (idx ==
                                             0 ||
                                             idx >
                                             numObjects) {
                                           addObject(
                                             type,
                                             obj);
                                           return;
                                       }
                                       lastObjectIdx =
                                         idx;
                                       for (int i =
                                              0;
                                            i <
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
                                       } }
    public java.net.URL getUrl() { return url;
    }
    public void setUrl(java.net.URL newUrl) {
        url =
          newUrl;
    }
    public org.apache.batik.transcoder.wmf.tosvg.GdiObject getObject(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.GdiObject)
                 objectVector.
                 get(
                   idx);
    }
    public org.apache.batik.transcoder.wmf.tosvg.MetaRecord getRecord(int idx) {
        return (org.apache.batik.transcoder.wmf.tosvg.MetaRecord)
                 records.
                 get(
                   idx);
    }
    public int getNumRecords() { return numRecords;
    }
    public int getNumObjects() { return numObjects;
    }
    public int getVpX() { return vpX; }
    public int getVpY() { return vpY; }
    public int getVpW() { return vpW; }
    public int getVpH() { return vpH; }
    public void setVpX(int newValue) { vpX =
                                         newValue;
    }
    public void setVpY(int newValue) { vpY =
                                         newValue;
    }
    public void setVpW(int newValue) { vpW =
                                         newValue;
    }
    public void setVpH(int newValue) { vpH =
                                         newValue;
    }
    private transient java.net.URL url;
    protected transient int numRecords;
    protected transient int numObjects;
    public transient int lastObjectIdx;
    protected transient int vpX;
    protected transient int vpY;
    protected transient int vpW;
    protected transient int vpH;
    protected transient java.util.Vector records;
    protected transient java.util.Vector objectVector;
    protected transient boolean bReading =
      false;
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "jyzUNPM2VcEHTPOaRh0/wM5epf8D/wUDO6w0AAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "A1flZ07NNK2F7XHIXI1bG70twpvGuoq2");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("GLKmKQS0AdFSQxFGiiS5a3uuUj7ck+jIrNRpf9KKKsUYkzYoyvSVGlxpuwHe" +
       "pgicXVnpYDYfha4qwj1aolo9TrSqY3IToQvYABMxVyatao1ph0aPqwHjgQVs" +
       "pAw72maN+h1LKJUr2oAd99qUNnQXi0wMvbFcxENIcMGKwast/FHU6tQ6Sc2C" +
       "G81m0ampNi11DR5twWELS3hB9KjaaujX/Mlw6FcxokjoYh/h1+sZX2VldLWx" +
       "xva4rKAzSyZlwgr9RboZ9bguIqpNRuD68sAoQUkX1UGs2ICSUaNfTUo4jv9E" +
       "tsX3O9e29XhPvst6eINwYWFZwSevYXdxd96TJa863K/O/24tnLh1dmy/+tjd" +
       "hEJ2xvqK0y4G5uerH3vX089o/V+HD84ZxtmBueu9wdJj3TrWVHa75XWnn1x0" +
       "83uRR3cNfv9d/+sh4c3G26/hBtUjJ/g82eRvdp/9Iv1q9ZfOFW46vHlwxY3N" +
       "y4mevPy+wQVfDyPfES67dfCKy28xZWcM0E6y0NXOGy5d3Qr2civY6v6MKzNf" +
       "PaPsT7Lkj8LCLb4e6OFVt6dj19SObOfLL7QzfbyHPONLh2Dv2R17FN64A/vG" +
       "awEbFu4MUkc1fNcxN7p2Vdh7R3L5aF7hz87A/j+y5PmwcAEg3x2eZDlfPwL7" +
       "jesAmx/pPA6eN+/AvvlaNfunL6jZ755R9r+z5FtgZJnBMXAfPQL37esAd9+B" +
       "2bZ24Fo3xmx3+js4FNpewjLd/YYcyqzjReEw9HXZzmn//mza+w5o2X5zrepe" +
       "5gkyur2czb8Fhg1a0k7I5O+uQyZ3HFj3L+xk8gs3Ribnjo78Rlc5LdvensiR" +
       "3Xm6OexdypLbgDnImrYludzW985fL/Q3gedXd9B/9cZAv+lossvO7/fySzyj" +
       "HM9DZ2B9eZYAKd1xiBU/ifb+60Cb38nJLsN8Yof2EzcG7XEIrz6jLJv39x4L" +
       "C7fO9XDk5/fqmSNkj1+vHl8Jns/skH3mhg7rnNMcAnIGvEqWvCE7SD6Ed0xx" +
       "+9cBL7/A9DB4PreD97kbDm9rnG8+A152orxXBwMRaO/YvSxgrtCLu5ZOa+Yx" +
       "ulwob7wOoeQ3OR4Bz+d3Qvn8j0gonTOE0ssSeiuU3T3CnVBKL04oIAaTjxHm" +
       "UmGud4y/HDxf3Enlizd+jEtnlL01S0Zh4S4gkN7h3crV4RyQAxRvBMAv7wB+" +
       "+cYDnJ1Rln3TsicfAjx+Q/EIoHIjvPTXdgC/duMB+meUZTPOnr310uLuFuER" +
       "MudGIHt+h+z5G4/sZ84oe2eWpAfIpieQbW4Esj/fIfvzG4/sF88o+ydZ8vMH" +
       "yMYnkL37RiD79g7Zt288sg+dUfbhLPlnB8iYE8h+6Xpjhmw/4K92yP7qxiC7" +
       "Yv746BnwPpYlH9nGDLvBdixmeMF7bi8G3vd38L7/I4L3yTPgfTpLfvMA3vQE" +
       "vI/fAHh7e1va7e+PAN6/OwPev8+Szx7AG5+A969uBLzzO3jnf0Twfu8MeF/I" +
       "kt89gMecgPf5a4G3BouaY58lZt9YPXjFl9Lbr3vVTz5z8fwDz4y+ln+Zd/gF" +
       "7u2dwvlZZFnHP4k59n6r5+szM8d8+/YDGS/H8Edh4VUvKhILC7fkvxnre3+4" +
       "Jf7jsPDICxCHYK1nz44T/aew8GNnEIWFC0f/HKf7Olgdn6QDTOW/x+v9V9DC" +
       "UT2gne3L8SrPA65Alez1G5m57N213m4vPHjc2vKNg3tfSIvHNkdfedmWZv49" +
       "/MH2Y8Tt7nx/6plW76e/V/317eeJqiVvNlkr5zuF27ZfSuaNZluYj53a2kFb" +
       "tzKv/cHdn779VQfbrXdvGT6y/GO8PXL1bwGbthfmX+9t/s0Dn3nTbzzzfH5H" +
       "9v8BvrurN6hAAAA=");
}
