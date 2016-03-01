package edu.umd.cs.findbugs.detect;
public class StreamFrameModelingVisitor extends edu.umd.cs.findbugs.ba.ResourceValueFrameModelingVisitor {
    private final edu.umd.cs.findbugs.detect.StreamResourceTracker resourceTracker;
    private final edu.umd.cs.findbugs.detect.Stream stream;
    private edu.umd.cs.findbugs.ba.Location location;
    public StreamFrameModelingVisitor(org.apache.bcel.generic.ConstantPoolGen cpg,
                                      edu.umd.cs.findbugs.detect.StreamResourceTracker resourceTracker,
                                      edu.umd.cs.findbugs.detect.Stream stream) {
        super(
          cpg);
        this.
          resourceTracker =
          resourceTracker;
        this.
          stream =
          stream;
    }
    @java.lang.Override
    public void transferInstruction(org.apache.bcel.generic.InstructionHandle handle,
                                    edu.umd.cs.findbugs.ba.BasicBlock basicBlock)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException {
        this.
          location =
          new edu.umd.cs.findbugs.ba.Location(
            handle,
            basicBlock);
        final org.apache.bcel.generic.Instruction ins =
          handle.
          getInstruction(
            );
        final edu.umd.cs.findbugs.ba.ResourceValueFrame frame =
          getFrame(
            );
        int status =
          -1;
        boolean created =
          false;
        edu.umd.cs.findbugs.ba.Location creationPoint =
          stream.
          getLocation(
            );
        if (handle ==
              creationPoint.
              getHandle(
                ) &&
              basicBlock ==
              creationPoint.
              getBasicBlock(
                )) {
            if (stream.
                  isOpenOnCreation(
                    )) {
                status =
                  edu.umd.cs.findbugs.ba.ResourceValueFrame.
                    OPEN;
                stream.
                  setOpenLocation(
                    location);
                resourceTracker.
                  addStreamOpenLocation(
                    location,
                    stream);
            }
            else {
                status =
                  edu.umd.cs.findbugs.ba.ResourceValueFrame.
                    CREATED;
            }
            created =
              true;
        }
        else
            if (resourceTracker.
                  isResourceOpen(
                    basicBlock,
                    handle,
                    cpg,
                    stream,
                    frame)) {
                status =
                  edu.umd.cs.findbugs.ba.ResourceValueFrame.
                    OPEN;
                stream.
                  setOpenLocation(
                    location);
                resourceTracker.
                  addStreamOpenLocation(
                    location,
                    stream);
            }
            else
                if (resourceTracker.
                      isResourceClose(
                        basicBlock,
                        handle,
                        cpg,
                        stream,
                        frame)) {
                    status =
                      edu.umd.cs.findbugs.ba.ResourceValueFrame.
                        CLOSED;
                }
        analyzeInstruction(
          ins);
        if (status !=
              -1) {
            frame.
              setStatus(
                status);
            if (created) {
                frame.
                  setValue(
                    frame.
                      getNumSlots(
                        ) -
                      1,
                    edu.umd.cs.findbugs.ba.ResourceValue.
                      instance(
                        ));
            }
        }
    }
    @java.lang.Override
    protected boolean instanceEscapes(org.apache.bcel.generic.InvokeInstruction inv,
                                      int instanceArgNum) {
        org.apache.bcel.generic.ConstantPoolGen cpg =
          getCPG(
            );
        java.lang.String className =
          inv.
          getClassName(
            cpg);
        boolean escapes =
          inv.
          getOpcode(
            ) ==
          org.apache.bcel.Constants.
            INVOKESTATIC ||
          instanceArgNum !=
          0;
        java.lang.String methodName =
          inv.
          getMethodName(
            cpg);
        java.lang.String methodSig =
          inv.
          getSignature(
            cpg);
        if (inv.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKEVIRTUAL &&
              ("load".
                 equals(
                   methodName) ||
                 "loadFromXml".
                 equals(
                   methodName) ||
                 "store".
                 equals(
                   methodName) ||
                 "save".
                 equals(
                   methodName)) &&
              "java.util.Properties".
              equals(
                className)) {
            escapes =
              false;
        }
        if (inv.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKEVIRTUAL &&
              ("load".
                 equals(
                   methodName) ||
                 "store".
                 equals(
                   methodName)) &&
              "java.security.KeyStore".
              equals(
                className)) {
            escapes =
              false;
        }
        if (inv.
              getOpcode(
                ) ==
              org.apache.bcel.Constants.
                INVOKEVIRTUAL &&
              "getChannel".
              equals(
                methodName) &&
              "()Ljava/nio/channels/FileChannel;".
              equals(
                methodSig)) {
            escapes =
              true;
        }
        if (edu.umd.cs.findbugs.detect.FindOpenStream.
              DEBUG &&
              escapes) {
            java.lang.System.
              out.
              println(
                "ESCAPE at " +
                location +
                " at call to " +
                className +
                "." +
                methodName +
                ":" +
                methodSig);
        }
        if (stream.
              getOpenLocation(
                ) !=
              null) {
            resourceTracker.
              addStreamEscape(
                stream,
                location);
        }
        return escapes;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("H4sIAAAAAAAAAL1ZDWwUxxWeO/9iDP4BDOHH/BkIhtxBGrekJhQwNpge+IQJ" +
       "UkyLmdubsxfv7S67s/aZ1G1CVUFbBVFCgFYJUiWiACIBVY3atCWiQg2JklZK" +
       "mjZ/CqnaSqVNUYOqJlVpm743u3v7c3cmVFVP2rm9mTfvZ+a9772ZO3edVJgG" +
       "aWYqj/FRnZmxTpUnqWGydIdCTXM79PVLx8voX3dd23pvlFT2kcmD1NwiUZN1" +
       "yUxJm31kjqyanKoSM7cylsYZSYOZzBimXNbUPjJNNruzuiJLMt+ipRkS7KBG" +
       "gjRQzg05ZXHW7TDgZE4CNIkLTeLrwsPtCVIrafqoRz7DR97hG0HKrCfL5KQ+" +
       "sYcO07jFZSWekE3enjPIMl1TRgcUjcdYjsf2KG3OEmxOtBUswYILdR/ePDxY" +
       "L5ZgClVVjQvzzG3M1JRhlk6QOq+3U2FZcy/5MilLkIk+Yk5aEq7QOAiNg1DX" +
       "Wo8KtJ/EVCvboQlzuMupUpdQIU7mB5no1KBZh01S6Awcqrlju5gM1s7LW2tb" +
       "WWDiY8viR4/vqv9eGanrI3Wy2ovqSKAEByF9sKAsm2KGuS6dZuk+0qDCZvcy" +
       "Q6aKvM/Z6UZTHlApt2D73WXBTktnhpDprRXsI9hmWBLXjLx5GeFQzq+KjEIH" +
       "wNYmz1bbwi7sBwNrZFDMyFDwO2dK+ZCspjmZG56Rt7Hl80AAU6uyjA9qeVHl" +
       "KoUO0mi7iELVgXgvuJ46AKQVGjigwcnMkkxxrXUqDdEB1o8eGaJL2kNANUEs" +
       "BE7hZFqYTHCCXZoZ2iXf/lzfuvrQg+omNUoioHOaSQrqPxEmNYcmbWMZZjCI" +
       "A3tibWviGG26eDBKCBBPCxHbND/40o21y5svvWjTzCpC05PawyTeL51KTX51" +
       "dsfSe8tQjWpdM2Xc/IDlIsqSzkh7TgeEacpzxMGYO3hp2wsPPHSWvR8lNd2k" +
       "UtIUKwt+1CBpWV1WmLGRqcygnKW7yQSmpjvEeDepgveErDK7tyeTMRnvJuWK" +
       "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" +
       "vj9pHJ7/te8Pa0Ms6Fu+ozhCXa+VMnnIT+5O7pYOtiR/bzvVHUUm2HTTTscf" +
       "2fHGnlcEZlUjSOaRwgeQAKa+A2A9Nt+0TT/ge3+EkzLZuSj1hxkc/4LybdEb" +
       "vl73k8ONZV2A3N2k2lLlvRbrTgfRq8q0Uj6FvMs7D8scbdCHOYm0gruK7pPj" +
       "nBbOYXOc4/WqjZmdpkRBOUH83dLWVaXgxMOoGrYQf57JeY5+oqSjY/eR/4lL" +
       "5ziZWfp+B08BMwqumu3rUemZk3XV00/e/4ZImfkrzFrY/4ylKP461fdeqRss" +
       "I4vlq7WrVl18/Qj0KH1+g1rMfhFmPGdPuQigWWQKlD/uq5/6Eic1HjUnUSkw" +
       "fBm2xRkG94PWP/gCdMEgvl7R3VBbVQLu3dOpKPyLLWouEqyG8vs97VZFpa+A" +
       "WhjIC+JPAzcyLPtvg37p/MnNWx+88ekn7YsRSaH79iGXiRAP9h1Nvn6YX5Kb" +
       "y6ty09Kbky9MWOTCcoOtsAdws3yBsRFcVEffmRm6NTBb8pcHb51a/fzPD1a+" +
       "BhloJ4lQ2MudhUeknG5B4bYzURj3UGuJ64z2pd8ZXbM885d3xCHUwYnZpenh" +
       "CPjom90Xhj5aK26pK2DjWE6c3TaMqtuYNGwEQGQyujXFvw/EOjjLNynfi9do" +
       "nCwozJyFl49wQB9hxnrNUtMODE30egL/Xrgll6XroQlejw9HT9voYmfesv7E" +
       "Fl13MnHZRV2E+ZniSIPt2+IVm3f+AwBF75g/HAAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
