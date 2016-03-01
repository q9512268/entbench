package org.apache.batik.apps.svgbrowser;
class WindowsAltFileSystemView extends javax.swing.filechooser.FileSystemView {
    public static final java.lang.String EXCEPTION_CONTAINING_DIR_NULL = "AltFileSystemView.exception.containing.dir.null";
    public static final java.lang.String EXCEPTION_DIRECTORY_ALREADY_EXISTS =
      "AltFileSystemView.exception.directory.already.exists";
    public static final java.lang.String NEW_FOLDER_NAME = " AltFileSystemView.new.folder.name";
    public static final java.lang.String FLOPPY_DRIVE = "AltFileSystemView.floppy.drive";
    public boolean isRoot(java.io.File f) { if (!f.isAbsolute()) { return false;
                                            }
                                            java.lang.String parentPath =
                                              f.
                                              getParent(
                                                );
                                            if (parentPath == null) { return true;
                                            }
                                            else {
                                                java.io.File parent =
                                                  new java.io.File(
                                                  parentPath);
                                                return parent.
                                                  equals(
                                                    f);
                                            } }
    public java.io.File createNewFolder(java.io.File containingDir)
          throws java.io.IOException { if (containingDir == null) {
                                           throw new java.io.IOException(
                                             org.apache.batik.apps.svgbrowser.Resources.
                                               getString(
                                                 EXCEPTION_CONTAINING_DIR_NULL));
                                       }
                                       java.io.File newFolder =
                                         null;
                                       newFolder =
                                         createFileObject(
                                           containingDir,
                                           org.apache.batik.apps.svgbrowser.Resources.
                                             getString(
                                               NEW_FOLDER_NAME));
                                       int i =
                                         2;
                                       while (newFolder.
                                                exists(
                                                  ) &&
                                                i <
                                                100) {
                                           newFolder =
                                             createFileObject(
                                               containingDir,
                                               org.apache.batik.apps.svgbrowser.Resources.
                                                 getString(
                                                   NEW_FOLDER_NAME) +
                                               " (" +
                                               i +
                                               ')');
                                           i++;
                                       }
                                       if (newFolder.
                                             exists(
                                               )) {
                                           throw new java.io.IOException(
                                             org.apache.batik.apps.svgbrowser.Resources.
                                               formatMessage(
                                                 EXCEPTION_DIRECTORY_ALREADY_EXISTS,
                                                 new java.lang.Object[] { newFolder.
                                                   getAbsolutePath(
                                                     ) }));
                                       }
                                       else {
                                           newFolder.
                                             mkdirs(
                                               );
                                       }
                                       return newFolder;
    }
    public boolean isHiddenFile(java.io.File f) {
        return false;
    }
    public java.io.File[] getRoots() { java.util.List rootsVector =
                                         new java.util.ArrayList(
                                         );
                                       org.apache.batik.apps.svgbrowser.WindowsAltFileSystemView.FileSystemRoot floppy =
                                         new org.apache.batik.apps.svgbrowser.WindowsAltFileSystemView.FileSystemRoot(
                                         org.apache.batik.apps.svgbrowser.Resources.
                                           getString(
                                             FLOPPY_DRIVE) +
                                         "\\");
                                       rootsVector.
                                         add(
                                           floppy);
                                       for (char c =
                                              'C';
                                            c <=
                                              'Z';
                                            c++) {
                                           char[] device =
                                             { c,
                                           ':',
                                           '\\' };
                                           java.lang.String deviceName =
                                             new java.lang.String(
                                             device);
                                           java.io.File deviceFile =
                                             new org.apache.batik.apps.svgbrowser.WindowsAltFileSystemView.FileSystemRoot(
                                             deviceName);
                                           if (deviceFile !=
                                                 null &&
                                                 deviceFile.
                                                 exists(
                                                   )) {
                                               rootsVector.
                                                 add(
                                                   deviceFile);
                                           }
                                       }
                                       java.io.File[] roots =
                                         new java.io.File[rootsVector.
                                                            size(
                                                              )];
                                       rootsVector.
                                         toArray(
                                           roots);
                                       return roots;
    }
    class FileSystemRoot extends java.io.File {
        public FileSystemRoot(java.io.File f) {
            super(
              f,
              "");
        }
        public FileSystemRoot(java.lang.String s) {
            super(
              s);
        }
        public boolean isDirectory() { return true;
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1445630120000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("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" +
           "fUx89Jq7fPTGMZGVj2bFm6/3tJuxnlj+E/a6lGuZJS3726Qln+mpW9gMz4or" +
           "eVc5K962Vab2f9J7S3t//nYaGOaJm4MtkaVzO7y6/z9ZS37vP/zHdcbPYfYG" +
           "WcwJ/hn88sceaL39Ozn/Du8y7oeS679UIPXd8aKfsv9t77Hb/mwPOjeDLinX" +
           "8mpesqIMRWYglwwOkm2Qex/rP54XbpOgK4d4/qaTWHtk2pNIu/tCgnpGndUv" +
           "HAXXH4LfKfD8T/Zky501bLORu1vXUqJHDnMiz0tOAeg6i+7X9osZP7N1r7y8" +
           "nBU/tTVTVv1pgHFBntADDt10JCufmA1BaFnK5YPReZDgA5tcXli1rBvbeW3u" +
           "KuxruQq1pco/2XfuPJN2QTL9wX/88Fc/9Pg3gf260Nl1trbAbEfcl4my/cWv" +
           "vvz8g6977lsfzOEZ+Pnghfalp7JRxVtplxXjrJgcqPVAptYoT4hoKQj7OaJq" +
           "aqbZrd124Js2+PCsryXP8DN3f3P5sW9/epsYn/TRE8TaB577tR/uP/vc3pHt" +
           "yOPX7QiO8my3JLnQr7+2wj706K1myTmIf/rsM3/0O8+8fyvV3ceT6zbYO376" +
           "r/77q/svfuvLN8jNzljAGj+2YcM7DLIcUNjBr8+L+jSeJMlUZxtrBy9vYKwb" +
           "tuQ+poxI2RV4ojVBx5JobPr4VK0HbmflRR0RrZRSWq3JgiA7Nbo/JooLfjiY" +
           "45xCDEfuGqZsV15yTX7Br5CWQ/OrpT3x5nMp1K3hEpEbVGFJTtZzJ+x1w4I9" +
           "sxul2bpWLxcLkuKU1FRLyXBdCvV6yYsayjzkpyN5xdCYXY5NlXHnvCkPHBYX" +
           "Q2qteShNo/E0abFr1AnqegTTMso1W0RiNfGOFeJtf0ati90Jynl4TfTsiZR0" +
           "E8ajzX5cLptSYuJ2dyV1fRE1CXGO2Dgx5Qh8tdyUhxzZb9o4zi9Gy6JlS/yy" +
           "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");
    }
    public WindowsAltFileSystemView() { super(
                                          );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAMVZe3BU1Rk/u3nHQEIiEFEChMCU125R8dFQMCYbsrhJtkmI" +
       "ElqWu3fPJlfu3nu592yyiaYITpXyB+MIWrSS6bRYLYPgVJ1aOyKdPpRBpKBj" +
       "RVut+odaZEb+qNja1n7nnHv3PnY3DNppd+aePXvPd875Xuf3fefbg+dQiaGj" +
       "Rk1QEkKAjGrYCERpPyroBk60yoJh9MHbmLjz3d1bL7xasc2PSgfQ1CHB6BQF" +
       "A7dLWE4YA2i2pBhEUERsdGGcoDOiOjawPiwQSVUG0HTJCKc0WRIl0qkmMCXo" +
       "F/QImiYQokvxNMFhcwGC5kQYN0HGTbDFS9AcQVWiqo3aE2a5JrQ6xihtyt7P" +
       "IKgmcrswLATTRJKDEckgzRkdLdFUeXRQVkkAZ0jgdnmFqYi1kRU5amh8svrT" +
       "z+8bqmFqqBMURSVMRKMHG6o8jBMRVG2/Dck4ZWxB30VFEXSZg5igpoi1aRA2" +
       "DcKmlrw2FXA/BSvpVKvKxCHWSqWaSBkiaJ57EU3QhZS5TJTxDCuUE1N2Nhmk" +
       "nZuV1jK3R8QHlgT3/GBjzc+LUPUAqpaUXsqOCEwQ2GQAFIpTcawbLYkETgyg" +
       "aQoYvBfrkiBLY6a1aw1pUBFIGlzAUgt9mdawzva0dQWWBNn0tEhUPStekjmV" +
       "+askKQuDIOsMW1YuYTt9DwJWSsCYnhTA98wpxZslJcH8yD0jK2PTLUAAU8tS" +
       "mAyp2a2KFQFeoFruIrKgDAZ7wfmUQSAtUcEFdeZrBRalutYEcbMwiGME1Xvp" +
       "onwIqCqYIugUgqZ7ydhKYKVZHis57HOua+WuO5QOxY98wHMCizLl/zKY1OCZ" +
       "1IOTWMdwDvjEqsWRB4UZz+/wIwTE0z3EnOYXd56/aWnD0Zc4zZV5aLrjt2OR" +
       "xMT98amnrmpddGMRZaNcUw2JGt8lOTtlUXOkOaMB0szIrkgHA9bg0Z7fr7/r" +
       "AD7rR5VhVCqqcjoFfjRNVFOaJGN9DVawLhCcCKMKrCRa2XgYlUE/IimYv+1O" +
       "Jg1MwqhYZq9KVfYbVJSEJaiKKqEvKUnV6msCGWL9jIbMTwk815p99k3QWHBI" +
       "TeGgIAqKpKjBqK5S+alBGeZgA/oJGNXUYBz8f/Oy5YHrg4aa1sEhg6o+GBTA" +
       "K4YwH4QfmhE0hgfjujoC+Bi8FTwRei0yaQcue0cNglP9Eh4JUB/U/q+7Z6hu" +
       "6kZ8PjDbVV7QkOG8dahyAusxcU/65tD5Q7Hj3CHpITK1StCNwEKAsxBgLAQo" +
       "CwGbhUAhFpDPx3a+nLLCnQVMvRlAA1C7alHvd9Zu2tFYBF6qjRSDnSjpwpwo" +
       "1mqjixUSYuLBUz0XTp6oPOBHfgCgOEQxO5Q0uUIJj4S6KuIEYFmhoGIBa7Bw" +
       "GMnLBzq6d2Rb/9avMz6c0YEuWALARqdHKaZnt2jyokK+davv/fDTww+OqzY+" +
       "uMKNFSVzZlLYafTa2St8TFw8V3gm9vx4kx8VA5YBfhMBzhtAY4N3Dxf8NFtQ" +
       "TmUpB4GTqp4SZDpk4W8lGQKnsN8wB5xGm+ncF6k7eBhkUeCbvdq+N1756Bqm" +
       "SStgVDsifS8mzQ6QoovVMjiaZntXn44x0P15b3T3A+fu3cBcCyjm59uwibat" +
       "AE5gHdDg917acuadt/e/5s+6I8owES7/Aj4+eP5NH/qevuC4UttqgtvcLLpp" +
       "dMOFNkuAczKcduoTTesU8DkpKQlxGdMj8M/qBcuf+XhXDbeyDG8sJ1l68QXs" +
       "91fcjO46vvFCA1vGJ9I4a6vNJuPgXWev3KLrwijlI7Pt9OyHXhT2QRgA6DWk" +
       "MczR1FQDZeoaposAa6/2jK2gTZPhdG336XHkQzHxvtc+mdL/yZHzjFt3QuU0" +
       "d6egNXPn4VaAza5DZuNCdzo6Q6PtzAzwMNOLNR2CMQSLXXu069s18tHPYdsB" +
       "2FYEbDW6dcC+jMuDTOqSsjd//ZsZm04VIX87qpRVIdEusHOGKsDBsTEEsJnR" +
       "Vt/E+Rgph6aG6QPlaIgqfU5+c4ZSGmEGGHt25tMrH5t4mzkfd7sr2fRigyZ7" +
       "XkhkGbt9mj9+64fvv3DhJ2U83i8qDGGeefX/6Jbj29/7LMcSDLzy5CKe+QPB" +
       "g4/Mal11ls23UYTOnp/JjTeAs/bcqw+k/uZvLP2dH5UNoBrRzI77BTlND/AA" +
       "ZISGlTJDBu0ad2d3PJVpzqLkVV4Ec2zrxS87zkGfUtP+FI/X1VMrrrTcDz4r" +
       "vF7n8xEUzI2/OCNijeozYKoGstBAQtIDSlpm6d4atscC1n6NNkuYzYsI3A7S" +
       "cbhoQcdgiTsBviVFkDNZrphvzbS4ycMVQbNDt7WGon3h7q5Ya3dXX0u4K9y1" +
       "JtYW7ol1rYtE2Er1cJlirklVGeCJMkdp2l5Hmw6+5zcK+nqLW1Mt8Nxo8nRD" +
       "Pk1dO5mmQD2YnrPRgCDrWEiMwhicD7bFugLqot0IbTpp05VHRzcU4IegRltH" +
       "oJhQa193z/pYS6Qn1NK2Pha6Ldzb10spv+VRSv8lKmWZ6UL005xPKY1zc7Wi" +
       "wJNk6VnA8tONX1oFzQV2B9DtCt0aa++OtIXAMVo6Q/nkjV2ivIvgWW3uuCqf" +
       "vA254iZlVdNGAwldGmayDn5pWVcV2JmgqvZIdzS6PtbWE+7PK+jQJILyoQW0" +
       "WZTdNPspFJMcYI5ofJpd6FLILrT7t++ZSHQ/upxDea37ohVS0qknXv/Xy4G9" +
       "fzmWJ0+vIKq2TMbDWPYEkHk5AaST3ZltNL7+9IWit+6vr8pNp+lKDQWS5cWF" +
       "I413gxe3/3VW36qhTZeQJ8/xKMq75M86Dx5bs1C838+u/Rz8c8oF7knNbsiv" +
       "1DFJ60qfC/gbs6atoya7Ap4207RtXk+2nSfHTX3MTT3OWTnJYp78ymfeiEyU" +
       "rmIoLakBemjYvtsnScjuoc2dED0ko0dVCcvMHC5Aq3e96bhBorqUgmR62Kwt" +
       "HJ5xYctvy8barLpBvimc8haj8+RzHR/EmDnLqb9klejwlRZ90HEJqKHNUnoE" +
       "JslQPBwFx2vf2fzIh09wjrzpiIcY79iz84vArj38aPD60fycEo5zDq8hebib" +
       "N9kubEb7B4fHf/X4+L1+U92EoLK4qspYUHLsR6slHj1ybkuX7/v71nve6IYr" +
       "WBiVpxVpSxqHE24HLTPScYdi7aKT7a4m3/RKQpBvsWZmjwzMxi+G2q40lb5Y" +
       "zV7bXsuI58CzzvTadZMcAdpszXX4QlPzOzz9eTdbdWLyE1FnnYhwd8hKH9i8" +
       "H9HmIYhrIiQQBHfhkXYWRNnKtnIe/srKqbOUkzYlTF+6cgpNvZhyDk5y+g/R" +
       "5jHADMnokBIJrLSbtbOdtvSPf2Xpa+nQLHjGTRHGL136QlMnEe7ZScaeo81T" +
       "BJUPYsJwz3t5yqIYu/nyc/jLuo+eOrap7AyHmPw46anBvnfH8R+rfzrrt87/" +
       "993nBTpFr3LB+DdByf9+BVAXIHPS4aquw1VZUqxa4/9oJwqUCwrDuEO/Ez+d" +
       "/8rWifnvsnt3uWRAAgFxIU913DHnk4PvnD09ZfYhVp4qpuHFRED33wq5/xq4" +
       "/gxgtqmmzQuZvHFU0zSU74jtcWDo05d+UDIE1ReqiNJiQH3Onzf8Dwfx0ER1" +
       "+cyJdX/kYlt/ClRBhE3CjdF5V3X0SzUdJyUmaxW/uWrs6wRBcy9WuCWo0v7B" +
       "pHmZT/4DQdPzTiaomH45aV+FO6SXFu6r7NtJ9zrsZtNBcsI7TpIzBBUBCe2+" +
       "qVkmY7W0TMAYoddn+jeAOKSqtOrs1mzG5860sxacfjELOpLz+S6XZv/FWViQ" +
       "5v/GQZY0sbbrjvPXPcoLlaIsjI3RVS4D7+Pl0GwGO6/gatZapR2LPp/6ZMUC" +
       "C0lchVInb8yxwD1ZdXGWp4RnNGUreWf2rzxyYkfpaThtG5BPgDC5IbdWktHS" +
       "kF5viORLTOB4supic+X7m05+9qavlpWkEE9lGiabERN3H3krmtS0h/2oIoxK" +
       "4ATgDCvktI0qPVgc1l15TmlcTSvZozyVertAyw9MM6ZCp2Tf0ho23JJzs7nc" +
       "un6lrI5g/Wa6uokarpw/rWnOUabZ3TyJ4lhdFIt0appZ4/WtZpoHpKDf5xg6" +
       "/Ac8Agf2cB8AAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9/8X20u7e3d4XP5k5czvfsdbZ44AKsU2y3P3O6Mvt1g+/7HXXtcnP1m7fHx0" +
       "sk0qjyZ+8AHHyAznDKsrkNP777+dNCqvKJxu6f/ax/7zs+KH1x99gEPLFy7I" +
       "eZHlPxm98eX+t2t//3LloTsb/Hddnjjf6Nb5bf3HIiNJI088t7n/3B3LPl1Y" +
       "7NvgQx1blrq4QXrqyLs8dKkMiUMgXDiZunR89Hu8G/94uRdo+UfFNmvZ4Efe" +
       "4ijrR4vkU0nlYSvmff+wSx6diaIsqTyy9H3HAN5phP3w2+1zne2lLPjkHSuU" +
       "ZC/ARzq2gvTXaoXi9bWS4PNvbaanT8zETuiTs4Oy3U8VyT9IKte1yACJMTa2" +
       "vXKbveR8aoN/+FewwdMnNkiPbZD+P7LBz76F53+uSL4A48WKGUvXDa93fEHk" +
       "x06V/OJfQcmnisJn4fPqsZKv/vUoeVaHX3mLujeL5J8mlWumkZShDRHmffdH" +
       "mPJs+LD//PpPvfxb3//6y/+hPF69ZsUyiIjIvMd1pDNtvv7GV776u+947ovl" +
       "dYQrSxAfIODiPa67r2mdu31VCv54UP69FgRB5dQV/+xBXLFLKs/c70pJcSb+" +
       "zF233w43trQvvn792rtfl/7woMbJrapHucq1Veo4Z48wz+QfDiJjZZVCP3o4" +
       "0Dxo8K+Syotvd/MlqTx2+lLq8eVD43+dVN55z8ZJ5Urxd5b2t5PKjYu0SeVq" +
       "+X+W7vdgb6d0EPQOmbMkf5BUHoIkRfYPgxOsKG837I7ibXGqWtyj0ta+X1zb" +
       "OW/Z3aXzc+Md3z31dr47M52+fC5Ey8uMJxNWerjOeFv70uuD8fd+A//Jwx0S" +
       "zQF5XnC5BqPpcJ3lzqT33vtyO+H1MPPKN5/4mUffdzJBP3EQ+HRsnpHthXtf" +
       "0qDdICmvVeS/+O6f++A/ev2PylOn/wOwynCIZSoAAA==");
}
