package tadapt_custom;
public class XalanBench {
    private boolean tadapt;
    public XalanBench() { super();
                          java.lang.String tadaptstr = java.lang.System.getenv(
                                                                          "PANDA_TADAPT");
                          if (tadaptstr != null && tadaptstr.equals("true")) {
                              this.
                                tadapt =
                                true;
                          }
                          else {
                              this.
                                tadapt =
                                false;
                          } }
    public void execute() { try { ent.runtime.ENT_Util.initModeFile();
                                  java.util.Properties props = java.lang.System.
                                    getProperties(
                                      );
                                  java.lang.String key = "javax.xml.transform.TransformerFactory";
                                  java.lang.String value = "org.apache.xalan.processor.TransformerFactoryImpl";
                                  props.put(key, value);
                                  java.lang.System.setProperties(props);
                                  javax.xml.transform.Source stylesheet =
                                    new javax.xml.transform.stream.StreamSource(
                                    new java.io.File(
                                      "xalan/xmlspec.xsl"));
                                  javax.xml.transform.TransformerFactory factory =
                                    javax.xml.transform.TransformerFactory.
                                    newInstance(
                                      );
                                  javax.xml.transform.Templates template =
                                    factory.
                                    newTemplates(
                                      stylesheet);
                                  java.lang.String[] names = new java.lang.String[] { "xalan/acks.xml",
                                  "xalan/binding.xml",
                                  "xalan/changes.xml",
                                  "xalan/concepts.xml",
                                  "xalan/controls.xml",
                                  "xalan/datatypes.xml",
                                  "xalan/expr.xml",
                                  "xalan/intro.xml",
                                  "xalan/model.xml",
                                  "xalan/prod-notes.xml",
                                  "xalan/references.xml",
                                  "xalan/rpm.xml",
                                  "xalan/schema.xml",
                                  "xalan/structure.xml",
                                  "xalan/template.xml",
                                  "xalan/terms.xml",
                                  "xalan/ui.xml" };
                                  for (int k = 0; k < 10;
                                       k++) { double[] before =
                                                jrapl.EnergyCheckUtils.
                                                getEnergyStats(
                                                  );
                                              for (int i =
                                                     0; i <
                                                          1000;
                                                   i++) {
                                                  for (int j =
                                                         0;
                                                       j <
                                                         names.
                                                           length;
                                                       j++) {
                                                      java.io.FileOutputStream outputStream =
                                                        new java.io.FileOutputStream(
                                                        new java.io.File(
                                                          "scratch",
                                                          "xalan.out." +
                                                          j));
                                                      javax.xml.transform.Result outFile =
                                                        new javax.xml.transform.stream.StreamResult(
                                                        outputStream);
                                                      javax.xml.transform.Transformer transformer =
                                                        template.
                                                        newTransformer(
                                                          );
                                                      java.io.FileInputStream inputStream =
                                                        new java.io.FileInputStream(
                                                        new java.io.File(
                                                          names[j]));
                                                      javax.xml.transform.Source inFile =
                                                        new javax.xml.transform.stream.StreamSource(
                                                        inputStream);
                                                      transformer.
                                                        transform(
                                                          inFile,
                                                          outFile);
                                                      inputStream.
                                                        close(
                                                          );
                                                      tadapt_custom.TemperatureContext d_tempContext =
                                                        (tadapt_custom.TemperatureContext)
                                                          ent.runtime.ENT_Runtime.
                                                          putObj(
                                                            new tadapt_custom.TemperatureContext(
                                                              this.
                                                                tadapt),
                                                            new java.lang.Integer[] { tadapt_custom.EntMode.
                                                                                        DYNAMIC_MODE });
                                                      tadapt_custom.TemperatureContext tempContext =
                                                        ent.runtime.ENT_Snapshot.
                                                        snapshot(
                                                          d_tempContext,
                                                          tadapt_custom.EntMode.
                                                            LOW_MODE,
                                                          tadapt_custom.EntMode.
                                                            HIGH_MODE,
                                                          true);
                                                      tempContext.
                                                        sleep(
                                                          );
                                                      tempContext =
                                                        null;
                                                      outputStream.
                                                        close(
                                                          );
                                                  }
                                              }
                                              double[] after =
                                                jrapl.EnergyCheckUtils.
                                                getEnergyStats(
                                                  );
                                              ent.runtime.ENT_Util.
                                                writeModeFile(
                                                  java.lang.String.
                                                    format(
                                                      "ERun %d: %f %f %f\n",
                                                      k,
                                                      after[0] -
                                                        before[0],
                                                      after[1] -
                                                        before[1],
                                                      after[2] -
                                                        before[2]));
                                  }
                                  ent.runtime.ENT_Util.
                                    closeModeFile(
                                      );
                                  jrapl.EnergyCheckUtils.
                                    DeallocProfile(
                                      ); }
                            catch (java.lang.Exception e) {
                                e.
                                  printStackTrace(
                                    );
                            } }
    public static void main(java.lang.String[] args) {
        new tadapt_custom.XalanBench(
          ).
          execute(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471197464000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAK1YC2wUxxmeO79fnG1exoAB25DyyF1IQ9PIlMZc7GB6BhcD" +
       "ao6EY25vzl6zt7vsztlnUvJAiiBViyglhFaJpSokUEQgoo3aqk1KFRUSJY0U" +
       "QpumUaCPqKWlqKCqaVXapv/M7N4+7nw0UizteG4e//zP7/9nTlxFFaaB2ohK" +
       "w3RcJ2a4R6UD2DBJKqpg09wIYwnpyTL8t62X190VRJVxNGUYm/0SNkmvTJSU" +
       "GUdzZdWkWJWIuY6QFNsxYBCTGKOYypoaR9Nlsy+jK7Ik034tRdiCzdiIoSZM" +
       "qSEns5T0WQQomhsDTiKck0i3f7orhuolTR93lre4lkddM2xlxjnLpKgxNoJH" +
       "cSRLZSUSk03alTPQUl1TxocUjYZJjoZHlBWWCtbGVhSooP2F0Ic39g83chVM" +
       "xaqqUS6euYGYmjJKUjEUckZ7FJIxd6CHUFkM1bkWU9QZsw+NwKERONSW1lkF" +
       "3DcQNZuJalwcalOq1CXGEEULvER0bOCMRWaA8wwUqqklO98M0s7PSyukLBDx" +
       "iaWRg09ubTxdhkJxFJLVQcaOBExQOCQOCiWZJDHM7lSKpOKoSQVjDxJDxoq8" +
       "07J0sykPqZhmwfy2WthgVicGP9PRFdgRZDOyEtWMvHhp7lDWr4q0godA1hmO" +
       "rELCXjYOAtbKwJiRxuB31pby7bKaomief0dexs4vwALYWpUhdFjLH1WuYhhA" +
       "zcJFFKwORQbB9dQhWFqhgQMaFLVOSpTpWsfSdjxEEswjfesGxBSsquGKYFso" +
       "mu5fximBlVp9VnLZ5+q6lfseVNeoQRQAnlNEUhj/dbCpzbdpA0kTg0AciI31" +
       "S2KH8IyX9gYRgsXTfYvFmu9/+frdy9rOvCrWzC6yZn1yhEg0IR1JTnlrTnTx" +
       "XWWMjWpdM2VmfI/kPMoGrJmunA4IMyNPkU2G7ckzG87e98hxciWIavtQpaQp" +
       "2Qz4UZOkZXRZIca9RCUGpiTVh2qImory+T5UBf2YrBIxuj6dNgntQ+UKH6rU" +
       "+G9QURpIMBXVQl9W05rd1zEd5v2cjhCqgg/VW5/dRxRFI8NahkSwhFVZ1SID" +
       "hsbkNyOAOEnQ7XAkh8FVIhSnsA5qyZpUy0S+xMZWs+kwcyb9kyGTY9xOHQsE" +
       "QJFz/GGsQASs0ZQUMRLSwezqnusnE68LF2FubckJ5vGcEHZOQIEAJzyNnSSs" +
       "A7rdDlEKMFm/ePCBtdv2tpeBW+hj5aAYtrTdky6iTijb+JuQTjU37Fxwcfkr" +
       "QVQeQ81YolmsMPTvNoYAV6TtVujVJyGROHg+34XnLBEZmkRSACeT4bpFpVob" +
       "JQYbp2iai4KdbVhcRSbH+qL8ozOHxx7d/PBtQRT0Qjg7sgLQh20fYMCbB9hO" +
       "f+gWoxvac/nDU4d2aU4Qe3KCncoKdjIZ2v2m96snIS2Zj19MvLSrk6u9BkCW" +
       "YggKwK82/xkejOiy8ZbJUg0CpzUjgxU2Zeu4lg4b2pgzwn2yifengVvUsKCZ" +
       "Cl/IiiL+n83O0Fk7U/gw8zOfFBzPPzeoP/2rN//0aa5uG/pDrpw9SGiXC24Y" +
       "sWYOLE2O2240CIF17x8e+MYTV/ds4T4LKzqKHdjJ2ijADJgQ1PzYqzvevXTx" +
       "yIWg4+cU8m02CWVLLi9kkMlUXUJIOG2Rww/AlQKxzrymc5MK/imnZZxUCAus" +
       "f4cWLn/xL/sahR8oMGK70bKbE3DGZ61Gj7y+9R9tnExAYunS0ZmzTGDwVIdy" +
       "t2HgccZH7tHzc795Dj8NaA4Iaso7CQdFxHWAuNFWcPlv4+0dvrk7WbPQdDu/" +
       "N75cZU1C2n/hWsPmay9f59x66yK3rfux3iXcizWLckB+ph+c1mBzGNbdcWbd" +
       "/Y3KmRtAMQ4UJSgGzPUGYGHO4xnW6oqqX//0lRnb3ipDwV5Uq2g41Yt5kKEa" +
       "8G5iDgOM5vTP3y2MO8Ys3chFRQXCFwwwBc8rbrqejE65snf+YOb3Vh6duMi9" +
       "TBc0ZudRdY4HVXl17QT28bfv/MXRrx8aE/l58eRo5tvX8q/1SnL37/5ZoHKO" +
       "Y0VqB9/+eOTEU63RVVf4fgdQ2O7OXGE2AlB29t5+PPP3YHvlz4KoKo4aJaua" +
       "3YyVLAvTOFRwpl3iQsXrmfdWY6L06MoD5hw/mLmO9UOZkwWhz1azfoMPvWqZ" +
       "CWfB12AFdoMfvQKId/r4llt4u4Q1t9pgUaUbMtx4iA8takoQBYQRSdmbUlna" +
       "GswmTUh/cgbQbtQq424f2Cbt7Rz4QLjArCIbxLrpxyJf2/zOyBscS6tZgt1o" +
       "i+1Kn5CIXUDeKLj+CP4C8P2XfYxbNiDKoeaoVZPNzxdlzIVL+qJPgMiu5kvb" +
       "n7r8vBDA73i+xWTvwa98FN53UACkqOw7Copr9x5R3QtxWDPIuFtQ6hS+o/eP" +
       "p3b96NiuPYKrZm+d2gPXsOd/+Z83wod/81qRoqoqqWkKwWoeDQL5aJ7mtY8Q" +
       "6p7HQz/e31zWC+m5D1VnVXlHlvSlvE5aZWaTLoM5twbHcS3xmHEoCiwBO4jk" +
       "ytrPsmat8MKuYlAmpm5hzdK8r/K/Sn8R7M5sDlYhpte5k91TuE6P7D44kVr/" +
       "7PKglSbiFBBW029VyChRXKSCjJIH9vr5zczBkPenHPj9DzuHVn+cOpKNtd2k" +
       "UmS/54G9l0zuvX5Wzu3+c+vGVcPbPkZJOM+nJT/J7/SfeO3eRdKBIL+GCnAr" +
       "uL56N3V5vaXWIHDfVr3+0eEty2bC12LZtaV4WVbEJfLFzmRbS5QFZom5LGvg" +
       "vlhFckSCyzVftMkKWPbvPorKRzU55bizVsKd/4/MzAa6dT4+khePb/8UfJol" +
       "nlZCM368D7JuGPDb5G8kPswPlaDqU4yDF21F8JxXaQI57q87+xPzmT+cFihV" +
       "LFv4Lv3HjlZL72XOfmCH4BfzPLYyluaXkhzYWTh5XLi4mniu482HJzp+y8uv" +
       "atmESIPALPKM4dpz7cSlK+cb5p7kEV3O4tZCOu/7T+HzjufVhssUYs3jQvst" +
       "FDXy8otVDGHxflOgZvY7KjZZCX1/aQNXpGUVK/ywQTC3QtQhOlzMY8uAXdb9" +
       "qu44YNDCOIu9qQ57UUVTCavk7Tlx+Za1cP5FDSZzRfkfEfzzw1xxy9kpEXbf" +
       "LjH3DGsmQFqJ8SXEKLH8uclCzBWNFsfsZyLHdz1WguJx1jwEcZ+B6pL1x5zg" +
       "f/iTCP4cRbXOkwer1VsKnkPFE550ciJUPXNi0zvCP+1ntnrIHemsorirSVe/" +
       "UjdIWuay1IvaUuTk0xQ1eB5e2OB39SIeK2rcXMCbaPNamH4zLbhyc4cndvnr" +
       "sA0WWfE+nJBOTaxd9+D1zzwrLtySgnfuZFTqIMzE3T+fwxZMSs2mVblm8Y0p" +
       "L9QstKGmSTDs4Odsl6m7wSt0ZoBW323U7MxfSt89svLln++tPA+wsgUFMITO" +
       "lsLbQE7PQvGwJVZYZwEK8Wty1+Jvja9alv7re/y+hQpuWf71CenC0QfePtBy" +
       "BK7TdX2oAgoZkuPXlHvG1Q1EGjXiqEE2e3LAIlCBOPUUcVOYr2CGO1wvljob" +
       "8qPsuYai9sIatvCRC+6mY8RYrWXVlAWOdc6I59naLgOyuu7b4Iy4EHOrQC1m" +
       "DcCsRKxf1+0SHzXoPFgSxWOYtWd5lzXn/gcawH7KORoAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471197464000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "ONuGJAAA");
}
