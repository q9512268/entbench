package org.apache.batik.apps.svgbrowser;
public abstract class AbstractCompoundCommand extends org.apache.batik.apps.svgbrowser.AbstractUndoableCommand {
    protected java.util.ArrayList atomCommands;
    public AbstractCompoundCommand() { super();
                                       this.atomCommands = new java.util.ArrayList(
                                                             ); }
    public void addCommand(org.apache.batik.apps.svgbrowser.UndoableCommand command) {
        if (command.
              shouldExecute(
                )) {
            atomCommands.
              add(
                command);
        }
    }
    public void execute() { int n = atomCommands.size();
                            for (int i = 0; i < n; i++) {
                                org.apache.batik.apps.svgbrowser.UndoableCommand cmd =
                                  (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                    atomCommands.
                                    get(
                                      i);
                                cmd.
                                  execute(
                                    );
                            } }
    public void undo() { int size = atomCommands.
                           size(
                             );
                         for (int i = size -
                                1; i >= 0;
                              i--) { org.apache.batik.apps.svgbrowser.UndoableCommand command =
                                       (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                         atomCommands.
                                         get(
                                           i);
                                     command.
                                       undo(
                                         );
                         } }
    public void redo() { int n = atomCommands.
                           size(
                             );
                         for (int i = 0; i <
                                           n;
                              i++) { org.apache.batik.apps.svgbrowser.UndoableCommand cmd =
                                       (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                         atomCommands.
                                         get(
                                           i);
                                     cmd.
                                       redo(
                                         );
                         } }
    public boolean shouldExecute() { boolean shouldExecute =
                                       true;
                                     if (atomCommands.
                                           size(
                                             ) ==
                                           0) {
                                         shouldExecute =
                                           false;
                                     }
                                     int n =
                                       atomCommands.
                                       size(
                                         );
                                     for (int i =
                                            0;
                                          i <
                                            n &&
                                            shouldExecute;
                                          i++) {
                                         org.apache.batik.apps.svgbrowser.UndoableCommand command =
                                           (org.apache.batik.apps.svgbrowser.UndoableCommand)
                                             atomCommands.
                                             get(
                                               i);
                                         shouldExecute =
                                           command.
                                             shouldExecute(
                                               ) &&
                                             shouldExecute;
                                     }
                                     return shouldExecute;
    }
    public int getCommandNumber() { return atomCommands.
                                      size(
                                        );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "weVsEQD3JXV5f/0Snjxaavm9x5hygi0X8OQKVN18oOry7qq8VRbffhK+D4dR" +
       "kAAude04gv8a/K6A6/+WVzlcWXFYqR/vHqcLz5/mCyFYoR4B2OAdLzoxsPK7" +
       "72LluZxVWdZL6i/NvvLFzxSvv3aIa0UGaQRUu1vCfvs7Qwnz773HUnWWyv3F" +
       "4Dvf+NM/Xn7v1eNIfNtF1T11L9VVpE8kdwSEsok+YHVZImXxwUMP7K6R8Z1l" +
       "0cuvAK0/gBy1j+rl8/TOlrmvvP3bAF3j6uUA9DBsX3YrIXoJiHRXvXVijSV4" +
       "WQChcctx2yc836x4Lp3w6JBhX+K19zfmFdjz0bPB6AAk6z/yXz/xmz/6ni8D" +
       "442hB3al2wN7nJuRTcv3l3/02iefedsrX/mRarEArrb8x/8K/aty1O+5l8Rl" +
       "IZTF4kTUp0tR+Sobo+U4YSp817VK2nsiyjSyPbAM7o6Tc/jlx7+8+fSffO6Q" +
       "eF+Gj0vE+sde+eG/Pvr4K1fPve6857Y3jvN9Dq88FdNvP9bw+Ui4wyxVj/5/" +
       "e/3lX/6plz964Orxi8k7Bd5NP/ef/89vHn3qK79+h8zwfjf4Jgyb3MiHzXjU" +
       "OfnRDclYkYvGXIQRqTuzhtmcp7pUpzvs4Nwg3ZLzBO4E+YyzuguTZjRy2EMV" +
       "Dd3UDX2305rtNraxVXGrzIxWvuxObAux4FbHnK/68VBMk56FDiMkaDfretTY" +
       "BTlwm0ST5nkyQZBEN1SCaNUcGO0IVIJiSYPQazhGEFjRdjxYxdsaVavNuwlj" +
       "RovCXSiYICFyXawtiUaPlLab1AqjzbxmyhsRj0KL0PGd0eK7E5fZTANL3raE" +
       "LeOK+0U+9mabPd+QWMEVx54eS/y+P/TxPiMB0Wgv2ZqOQEsbYrBE5mMsTet9" +
       "iusWGj/a4N5CrbOcGBYNjmQzxo45rumNfXXWynBGU5ejSDZCzkH3Ladd0Gxz" +
       "shiIeLLBpoPacN2aeYzoYsv1qidhc2Jt8uicRQQvkHvFJHb2rdXST7cDMjGG" +
       "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" +
       "fuCiqr4VXO1jVbXfGlWdl+qT92j7ibL4RAI9qOe6miaVOX/4TLQf+2ZFexJc" +
       "HzgW7QNvvWj//B5t/6IsPg2slQIvuCTXZ94KuQbHcg3eerk+d4+218vip4Bc" +
       "kX6bXD/9Tcj1jrLyeXBxx3Jxb71cv3SPtl8ui19IoLfHVpC6GnVwyDvF34NK" +
       "ELi67J/J/flvQu5yCYCeA5d8LLf81sv9hXu0/cey+NUEumnqyTHoHI4Y7iT6" +
       "ffbxd1yV2P/uGxE7T6Cn7vItRXkw/M7bvus6fIuk/uyrNx566tXF71SfE5x+" +
       "L/QwDT1kpK57/hzv3P21MNINu5Lv4cOpXlj9fSmBnn8z2Ab4e/ZQifHbh86/" +
       "k0BP3LEzCIby7zzt7wGFXqZNoAeq//N0vw9mO6NLoGuHm/MkXwFqByTl7R+G" +
       "J4vP3/y7lcuL0JWLecWpMR9/M2OeS0XecyGBqD7cO1ns0+nxKeTrr47Z7/9a" +
       "6ycPn1OorlwU5SgP0dCDhy87ThOGd991tJOxrg3f9/VHf+7h954kN48eGD4L" +
       "jHO8PXfnbxcoL0yqw8XiXz/1C9/1L1/9g+rk7P8B0WKzg1EpAAA=");
}
