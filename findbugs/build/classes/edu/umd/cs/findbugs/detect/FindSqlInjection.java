package edu.umd.cs.findbugs.detect;
public class FindSqlInjection implements edu.umd.cs.findbugs.Detector {
    private static final java.lang.String[] PREPARE_STATEMENT_SIGNATURES =
      new java.lang.String[] { "(Ljava/lang/String;)Ljava/sql/PreparedStatement;",
    "(Ljava/lang/String;I)Ljava/sql/PreparedStatement;",
    "(Ljava/lang/String;II)Ljava/sql/PreparedStatement;",
    "(Ljava/lang/String;III)Ljava/sql/PreparedStatement;",
    "(Ljava/lang/String;[I)Ljava/sql/PreparedStatement;",
    ("(Ljava/lang/String;[Ljava/lang/String;)Ljava/sql/PreparedSta" +
     "tement;") };
    private static final edu.umd.cs.findbugs.classfile.MethodDescriptor[]
      EXECUTE_METHODS =
      new edu.umd.cs.findbugs.classfile.MethodDescriptor[] { new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeQuery",
      "(Ljava/lang/String;)Ljava/sql/ResultSet;"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeUpdate",
      "(Ljava/lang/String;)I"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeUpdate",
      "(Ljava/lang/String;I)I"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeUpdate",
      "(Ljava/lang/String;[I)I"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeUpdate",
      "(Ljava/lang/String;[Ljava/lang/String;)I"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeLargeUpdate",
      "(Ljava/lang/String;)J"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeLargeUpdate",
      "(Ljava/lang/String;I)J"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeLargeUpdate",
      "(Ljava/lang/String;[I)J"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "executeLargeUpdate",
      "(Ljava/lang/String;[Ljava/lang/String;)J"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "execute",
      "(Ljava/lang/String;)Z"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "execute",
      "(Ljava/lang/String;I)Z"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "execute",
      "(Ljava/lang/String;[I)Z"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "execute",
      "(Ljava/lang/String;[Ljava/lang/String;)Z"),
    new edu.umd.cs.findbugs.classfile.MethodDescriptor(
      "java/sql/Statement",
      "addBatch",
      "(Ljava/lang/String;)V") };
    private static class StringAppendState {
        int sawOpenQuote = java.lang.Integer.MAX_VALUE;
        int sawCloseQuote = java.lang.Integer.MAX_VALUE;
        int sawComma = java.lang.Integer.MAX_VALUE;
        int sawAppend = java.lang.Integer.MAX_VALUE;
        int sawUnsafeAppend = java.lang.Integer.MAX_VALUE;
        int sawTaint = java.lang.Integer.MAX_VALUE;
        int sawSeriousTaint = java.lang.Integer.MAX_VALUE;
        public boolean getSawOpenQuote(org.apache.bcel.generic.InstructionHandle handle) {
            return sawOpenQuote <=
              handle.
              getPosition(
                );
        }
        public boolean getSawCloseQuote(org.apache.bcel.generic.InstructionHandle handle) {
            return sawCloseQuote <=
              handle.
              getPosition(
                );
        }
        public boolean getSawComma(org.apache.bcel.generic.InstructionHandle handle) {
            return sawComma <=
              handle.
              getPosition(
                );
        }
        public boolean getSawAppend(org.apache.bcel.generic.InstructionHandle handle) {
            return sawAppend <=
              handle.
              getPosition(
                );
        }
        public boolean getSawUnsafeAppend(org.apache.bcel.generic.InstructionHandle handle) {
            return sawUnsafeAppend <=
              handle.
              getPosition(
                );
        }
        public boolean getSawTaint(org.apache.bcel.generic.InstructionHandle handle) {
            return sawTaint <=
              handle.
              getPosition(
                );
        }
        public boolean getSawSeriousTaint(org.apache.bcel.generic.InstructionHandle handle) {
            return sawSeriousTaint <=
              handle.
              getPosition(
                );
        }
        public void setSawOpenQuote(org.apache.bcel.generic.InstructionHandle handle) {
            sawOpenQuote =
              java.lang.Math.
                min(
                  sawOpenQuote,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawCloseQuote(org.apache.bcel.generic.InstructionHandle handle) {
            sawCloseQuote =
              java.lang.Math.
                min(
                  sawCloseQuote,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawComma(org.apache.bcel.generic.InstructionHandle handle) {
            sawComma =
              java.lang.Math.
                min(
                  sawComma,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawAppend(org.apache.bcel.generic.InstructionHandle handle) {
            sawAppend =
              java.lang.Math.
                min(
                  sawAppend,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawUnsafeAppend(org.apache.bcel.generic.InstructionHandle handle) {
            sawUnsafeAppend =
              java.lang.Math.
                min(
                  sawUnsafeAppend,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawSeriousTaint(org.apache.bcel.generic.InstructionHandle handle) {
            sawSeriousTaint =
              java.lang.Math.
                min(
                  sawSeriousTaint,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawTaint(org.apache.bcel.generic.InstructionHandle handle) {
            sawTaint =
              java.lang.Math.
                min(
                  sawTaint,
                  handle.
                    getPosition(
                      ));
        }
        public void setSawInitialTaint() {
            sawTaint =
              0;
        }
        public StringAppendState() { super(
                                       );
        }
        public static final java.lang.String
          jlc$CompilerVersion$jl7 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl7 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl7 =
          ("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");
        public static final java.lang.String
          jlc$CompilerVersion$jl5 =
          "2.7.0";
        public static final long jlc$SourceLastModified$jl5 =
          1456688264000L;
        public static final java.lang.String
          jlc$ClassType$jl5 =
          ("H4sIAAAAAAAAAL17Ccwkx3Xe7PJYckVxl0tJZBiJksi1rOU4f8/Rc4WSwjm6" +
           "p7unr+lrZjqxqL6ne/qaPma6x6EiE7YkyAAjKJSiGDYROLJjCzRlCBaSwLBB" +
           "w3Bkw0oAJUZiB7BlBA5iRxEgIrAdRHac6pn5z71ELzc/UPVX1/Hqfa9evXp1" +
           "zKvfKd0XR6VyGLi55QbJgZElB47bOEjy0IgPCLLBKlFs6H1XiWMB5D2vPfVL" +
           "l/78e5+dXz5ful8uPar4fpAoiR34MWfEgbsydLJ06TgXcQ0vTkqXSUdZKVCa" +
           "2C5E2nHyLFl624mmSekqecgCBFiAAAvQlgWoe1wLNHq74adev2ih+Em8LH28" +
           "dI4s3R9qBXtJ6f2niYRKpHh7MuwWAaDwQPEtAVDbxllUet8R9h3m6wB/vgy9" +
           "/E8/evmr95QuyaVLts8X7GiAiQR0Ipce8gxPNaK4q+uGLpce8Q1D543IVlx7" +
           "s+VbLl2JbctXkjQyjoRUZKahEW37PJbcQ1qBLUq1JIiO4Jm24eqHX/eZrmIB" +
           "rO86xrpDiBb5AOBFGzAWmYpmHDa5d2H7elJ679kWRxivjkAF0PSCZyTz4Kir" +
           "e30FZJSu7MbOVXwL4pPI9i1Q9b4gBb0kpSduSrSQdahoC8Uynk9Kj5+tx+6K" +
           "QK0Ht4IomiSld56ttqUERumJM6N0Yny+Q3/opR/xMf/8lmfd0NyC/wdAoyfP" +
           "NOIM04gMXzN2DR96hvyC8q5f/fT5UglUfueZyrs6/+ofvvHcDz35+m/t6vzt" +
           "G9RhVMfQkue1L6kPf/Pd/Wudewo2HgiD2C4G/xTyrfqz+5JnsxDMvHcdUSwK" +
           "Dw4LX+f+7ewTXza+fb50ES/drwVu6gE9ekQLvNB2jWho+EakJIaOlx40fL2/" +
           "LcdLF0CatH1jl8uYZmwkeOled5t1f7D9BiIyAYlCRBdA2vbN4DAdKsl8m87C" +
           "Uqn0KAilx0GwS7u/7f+kpELzwDMgRVN82w8gNgoK/DFk+IkKZDuHTKBMamrF" +
           "UBxp0FZ1DD2FUk+HtPi4UDcS0AxCwTe/dHG/IAKAHxQNwv8vvWQF1svrc+fA" +
           "MLz7rBFwwfzBAlc3oue1l9Me8sZrz//O+aNJsZdSUvow6PQAdHqgxQeHnR7s" +
           "Oj042+nV3eTphiEYnMKIGKVz57a9v6NgZ6cAYPgWwBAAE/nQNf6HiY99+ql7" +
           "gOaF63uB7Iuq0M0tdf/YdOBbA6kB/S29/sX1j0r/qHK+dP60yS0ggKyLRXO2" +
           "MJRHBvHq2al2I7qXPvUnf/6VL7wQHE+6UzZ8bwuub1nM5afOCjsKNCDHyDgm" +
           "/8z7lK89/6svXD1fuhcYCGAUEwUoMbA3T57t49ScfvbQPhZY7gOAzSDyFLco" +
           "OjRqF5N5FKyPc7Za8PA2/QiQcbm0j05pfVH6aFjE79hpTTFoZ1Bs7e+H+fCn" +
           "f+/f/2l9K+5DU33pxOLHG8mzJ8xDQezS1hA8cqwDQmQYoN4ffJH9J5//zqf+" +
           "/lYBQI2nb9Th1SLuA7MAhhCI+cd/a/n73/rDL/3u+WOlScD6mKqurWU7kH8N" +
           "/s6B8H+LUIArMnZT+0p/b1/ed2RgwqLnDxzzBkyNu1Pn+Kroe4Fum7aiukah" +
           "sX956QeqX/ufL13e6YQLcg5V6oduT+A4/2/1Sp/4nY/+xZNbMue0Yqk7lt9x" +
           "tZ39fPSYcjeKlLzgI/vR//Cef/Z15aeBJQbWL7Y3xtaglbbyKG0HsLKVRXkb" +
           "Q2fKakX03vjkRDg91064JM9rn/3d775d+u6vvbHl9rRPc3LcKSV8dqdqRfS+" +
           "DJB/7Oysx5R4DurBr9P/4LL7+vcARRlQ1MBCHjMRsETZKS3Z177vwn/59d94" +
           "18e+eU/pPFq66AaKjirbCVd6EGi6Ec+BEcvCv/fcTpvXD4Do8hZq6TrwOwV5" +
           "fPt1ETB47ea2Bi1ckuPp+vj/YVz1xf/6v68TwtbK3GAlPtNehl79qSf6H/n2" +
           "tv3xdC9aP5ldb52B+3bctvZl78/OP3X/b54vXZBLl7W9bygpblpMIhn4Q/Gh" +
           "wwj8x1Plp32b3UL+7JE5e/dZU3Oi27OG5nhVAOmidpG+eMa2FLIv/R0Q3L1t" +
           "cc/alnOlbeK5bZP3b+OrRfSDJ9TzWlJ6KFbWDFhFxmmQGLceKDayPWBpVnuX" +
           "B3rhyrcWP/Unv7hzZ86OypnKxqdf/sxfH7z08vkTTuTT1/lxJ9vsHMktm2/f" +
           "8lro+ftv1cu2Bfrfv/LCr/z8C5/acXXltEuEAI//F//TX33j4It/9Ns3WIHv" +
           "Ae7uziQXcb2IujtFbt5U6Z89PSQHIPj7IfFvMiTMbYbk7WBI+m4QG9sxKTKx" +
           "M1yxb5KrayCEe67Cm3Al3YarBwquAs9TbsTQ5E0y9AwI0Z6h6CYM/fBtGHoQ" +
           "MLRzgG7E0UffJEeV7aq1+0tuwpF+G44uAY5EP1ZM4+Z8GX+DoVvt+VrdhK/F" +
           "9zF0grJX7rMMuX8DQWV7hrKbMBR9H4Iq9rVBGt+Ur/i2fO2swjngldxXO2gd" +
           "VIrv/MY931MkPwjcl3i74QYtgIetuIf8POa42tVDh0UCG/DCxXbc1pbMO5PS" +
           "5e1SWVj2g53jfYbXa983r8CGPXxMjAzABvgn/viz3/jHT38L2COidN+qWEuA" +
           "4TrRI50WZwKffPXz73nby3/0E1tvDLhi/DX1fz1XUP2xWyEuoheK6OOHUJ8o" +
           "oPJBGmkGqcQJtXWaDP0ILXICD54A1yu4A7TJI+/A4BjvHv6RVaU/7WoZN02m" +
           "kofJ2qJp9ol2HhNIkvjuADeoWTWZTYayO2rIGTJ3VT+sJ66mKD7nsx0kjIip" +
           "2kW17tyexbPZet0jxCmFcOYM7XpSOHBGfVns9vgxCovNLjoaj/ojrOuOOb4r" +
           "kuVWo6UzU9lPGsooWIbpZqrWW1ALgnQIgspN2ejAjivLRMMd0pxupVZ1ydFc" +
           "FLliThJOKOUqXhvraddEGbTD6onaLEMUki/LsS/imr9c8BNSt11RkJyOPGra" +
           "E3HDy8NlEm74HkpWvESxGriDolUoIgbUdCnMvSVupzFX6YwxsidTHlOQoCSG" +
           "CLlolfQ5Wx6uaSYIc6HZDyG9YlBVymvGWiyzSVxd0axk5bSwcYMJDtcyTB/h" +
           "KFLZcLP6EMWTqozkeZUeSNMZs9zYeGWd460qS8d9WkU3cToI2El5brWhld8M" +
           "FiK1FnS84k+xLMLrYiUROS+wud5SrzpiKFQXzXxeFZC8J0xniKrMEhcNWr0A" +
           "7ak0n6ZUN21FS1lmdCPUMELRl9pyvODRIeoHPsVzAp/4QgcbGbPZTJHjFWOL" +
           "mNIT3HAucw08acI0Fq1Dr0Z3qsZ47rf4YDjv5DhMCYPeLOy1u6GygGmlKtlj" +
           "ju4QlDeQBZ2rVFExFLNJh6VdZxTw/Jpugq2iFVRDqxG2hbEWVfosLi9lF2w+" +
           "Gm2Z1AImM13RlYYWJ8ubZd63vFbcqyAROulSAhVael0mCGaI8vVejq0hTmwN" +
           "kzixukRvEuaWWvFpEshpofQH9HrBiTyXUp0AC5UZtU5QHOtuxrIy9jSURGoE" +
           "5s6Gy/FAIYZlTa3Z/YpMNxZdq89TG4hiYWHUd9GwPJmyYUOF6jkkQdOqF84R" +
           "a2QgVW6yMNvheCCwXIvniKVLzLg2vo4CNxZZfoOb9fnY660Fum21JzO/DjkN" +
           "KnTbFbhNxoo28QbUfGUxo4jqlcV5u+nQGyaJVxHSrSnWRhfdQQOL/QaZplVj" +
           "E+Q935556kKOBYZvCXnWVnUzhfDAFHRKiRLCVfKoyQkzUWbicJ2hoaG40ojx" +
           "sqFte5XcmyxHQqduCIpvMyMukCIu5flZmqsOQTTEqsSs2jTSl+b9gA/QEJZI" +
           "xfX9dY0YmJjvIAjujRV0gys2wmIYtKF4Z90KR9xSkhFXoAd1RSkHwSoTUSej" +
           "MBU3bF7oewYWjW136WHMxBtnbKgMlpJNLSeVhmcNKNuemv2W2jSVyEAWOGYh" +
           "/dkGyvNAdrGpovQtRAkdR1/jyxZRrqbh0moEvTZFVpsbzXW6lfao26bpmcIi" +
           "OTVZK93xxNHmE4JMAq6/Vto8pBCOyo5iqttQukLAj0V4mbBcXUG6s0FzHiOc" +
           "1TdSpQypqddqrZLZKB5kjt4jLKdCqyw3DCsQMplwGoT3Oqto3lHLdCg7sEqE" +
           "vXnoevzEdccUNVpRY2kuYZFc16sVbRaKAjVX4LGlDhmXmY4FRegFImM0Zoo5" +
           "45Ua1cJ1WqNqs/5wstEUDIFH7UWHwXrNjrKi6pt1LsQDfQQTIwlm+uNVT+8Y" +
           "7SaWQF5n3EQbw2ajU26zzryuRk4IredEFawSucP1XAUy1fm8pnenEdE1vIEF" +
           "69UEY1UCpgy5x8bMlBm3oSww6A7P6cYi4NcV3KcF2h1xtpSpzsSRF80lzfQ3" +
           "pkYsM6/fS4YIhGf5iO1l0/pQ5aFOK6xuGIKU1zRm2at5x8UmsN+TmGoMdDak" +
           "nYWcULyHaUtYb6ktJ1tN0rqGMQgyi0fA+A51XoNHepfBMacKbxLTXNWqeLuM" +
           "YhzthXSwRkW7p+AzkoIqm3I36ZXH7UlnMJjhg4zWmmbSmqsLiKj1+LxT87os" +
           "G8KRLquSHgWIPlq4qL2MRbrT9QeKoXe0gdlxtJGprMYLZzKVFdHX6JCdiLXU" +
           "xEiVg1iY7iMy3mwPggFNpSwdbuI8ElBWmU+zReSHtVZcY3lV7826PV/tu47L" +
           "JtO1hcynOOtr/IZpsJPGKmptYiGitXna0LNyg1qOe2Uz8tmlY4IFyCE2Xr0+" +
           "F8jItIzcsMayzVe6eJyAtdJtm+aM6bBdA5gig3DcTpWLiEmME86qnrFBNExE" +
           "AWszOaT24wHlYYmGIK2Gn9UIvJNGZNOV2h3GZ1tUJi7qiLSUpOpIR9x21sCI" +
           "GROJQ4vEvM2wnKDkmpKCgcSzmFUez13a6E7CuTkhO5Foqc4QGPVMyU1S7UTQ" +
           "QEpdWJnBVY6ZgnVrzdC2IairFjtyzI0DldW0bNbmYqPLJmulRXMbs1XPVmKZ" +
           "hutQOPHRckvsp+Mlu4rKzUGtnvh8ahCmwHRgdKnHedlESJbkBgakctUBNIik" +
           "CdSX2aWZ4EGt42/khUvDbTWdwxsuX6riYoi2ylFd9ivzKuOThga3zLjlTTpm" +
           "XCVqrT4Ft4aN+tIcKCMv59yxRMdDSW3Tc2sOTSidQFdME1MS4KyscEGSBLkf" +
           "Dpt2FupdCoHzsq+LSifmpo5UbTfVBaJJKGkNK2bsslhcT+v5KlKN1dqp+tVR" +
           "d4znqjY1K0YjMessInZa6+pwuKjLolTLpCGe95tsPZhLPUyXEZXN2xyr181N" +
           "sz2qrgAluK2nY3Uz0HWo39zkZGuwXmKjLozaEJlrjkEzPQdO0WSmgjlVMaeT" +
           "tl5h61G9NYlRKd6Y6HRM+SmWmGWWD3MGgdgqYgXNcNzCKV1NwzGZluVWICl9" +
           "TCCSLDbSqNkIrKSvOkbIT1ajjSMkgj9PIj0cZdX6jIE1OoMacUUYrKkeoXTn" +
           "jR6HTmKyPVhSHjrJ11SnYktGDCfdyiTfVNZ4POnhEweV2FWCDEWB5gcVVV0a" +
           "waQhKaTDJZ06pZINcqbb3nAlr7k1U+XFWt5bct5yPNnUpIUVZMtQIJo9PAij" +
           "mjjU+sE0FDh8GAyBiaDtOG8jI33oybnBCz0ImbZji2a4IFwPRZGa9Srwqpqv" +
           "Q37GNjCzohFOz442Fr9moDRYgTrjWKh1hZ49l2ydgvzuQHbIhkjMWE7luAUd" +
           "zNUuHE9oP5r1y2qt2SfL8tpBQgfv+BRKuO1p7BAVMrNoibLmVCpVG/0KizED" +
           "NRjAYque080BDC9ovbGWkhU7jNojvpNMRKrSHggpS6j1CHZnZYEk182O1ldX" +
           "tbU6RetMk8PURijCWJlclbku7VoCRjvtyCnXO0o79VCRVfONhW9Weq9BQDmx" +
           "qdfBchvOVm7Xozsrm197rWqL4jvC3OGNKgFcahGihwtEbIRaoy/ztSHlzSJd" +
           "y1bhrIE25MXIx5tLB+M0XYoJupOHHK9WMK6W4xwNbWrKYipoGN7A5zngHgmN" +
           "ENgBJGiMba4VJVreslJJ5RE7ch22ts4RbJFVLX3uV3Ie9UymzvY7bjPGAzJh" +
           "E3MjlQddtKNXXXGp+JVpOxWmTmtUA8uG14f9BUQv1zWDTXrRJmTmLRLjvA6L" +
           "TCWrM6PbME7j/TXDsnUIkaFqiPBrc80EMxyu9Plap7tqs70GO0dmOj6SlXZS" +
           "o1s5NV7Y5GxK2PxoBvWWUS/z5JnH8AKXaNpgXRGn3djyRzSpU9WGRnEcGoyc" +
           "pUGuWbQV9ZoYcAi667VfI53c8PpWm+oP4c1cXaYrMuv38WSuaRFnDmCkqrJr" +
           "GBVhBmUtKQ9Wgz7n1RSI1KNy20UI3K6huZugIrbAlhs993JlmpKOZWCU7Rh8" +
           "l9SZXjtFcNyuoNmmPFqzyFxKId+heHMTuePypNsXh353FaRzjCRQpjoujxbD" +
           "BSF1ifmM4PqSZMG5MYM5Ba+TDbAtcBEpwxmB6DAoAjxOOrPzekiWhS66kJX+" +
           "UlngAs2slwFjqYyINaSeOwjpMSRyc80eipqUrtsmnvX5AqPXxkMrBrIW2/3y" +
           "hMjtFjyx5dEA7K/8UYvU2eRYdhIKD6zBsi3BumHRuQe3hbAdsFi/zNRq85a9" +
           "Np18wIv+XBO7PGu3us0elCcSbwVpFWnoOcExkyUQG9eWcALnm8M8tKylWxtV" +
           "qcAYketlQ5QW1YXSWnj9uhKbAPuWx2iIL+cxAOQ3KsForaLlIB3A3VBoqbKf" +
           "klmZAepjVyywqzQoIxl0fKxTU9ZzjiDHAu6u2ijec4fealRmjf5A3jB5gq9X" +
           "w34ubKhWa7II2zBPmcNaOfAEqVyerdp126mjYkN36PGi0oyW5sp3jCWcC0Qo" +
           "pl1ymY1iy1xpxtBTFoRsrbgl8NzbwbhmoziNKB7K9+Yx2eo0gV+3aKCKvBk7" +
           "M90XBmIi1jo1SkIGwJfJUSJ1kAzOubk65FZ1EklqY64tz2I8G+Vip9aEOV9y" +
           "UHyp63WYNAnNXWGrmopPJzU/44q9Lpa16+Zy5UMbGzMA1GY2mtUoOG+MZ0tO" +
           "MZFVj2hPiXhm9OKa6i2rkQyxYF+ZK7rbyrodLPNgw2CGPSE1V3Bn1VbrlSQJ" +
           "81arYbIR2V4oZl0SKiqxRBKiz/ecSF2sKhA1HHrChq7weR1C4+oiL+sr2FnJ" +
           "qr6szlx/AzlQTpPccDVnZoiTlcflWgdemmkZnnUmbascjGKkr+AK1CSzhdtS" +
           "uNxmvEa9zkkDbtoXNDxrD4fRpjW13U6LokegYhBDWSpPXNEMDXnJ8lUmNMWM" +
           "iqUQkaN1nTe8mdhp9uX1ZFKXZlMYleZ0R7GgCp1hAbWGGnzgjdS1YDarCyI1" +
           "+LheM6A1V980W367N4FrU4oOlt1u98PF8chn39yxzSPbE6qjRxaO2yoKPvEm" +
           "TmayG3d4PildCCN7pexOml/Ijk77tid2V0o3v748ccVTKg7n33OzdxXbg/kv" +
           "vfjyKzrzs9Xz+2NAIindv3/uckznEiDzzM1vIKjtm5Lj+5qvv/g/nhA+Mv/Y" +
           "m7iRfu8ZJs+S/AXq1d8efkD73PnSPUe3N9e9djnd6NnTdzYXIyNJI184dXPz" +
           "niOxPlaI6wMgbPZi3Zw9RD0e1OtG69xWPXZKceba8dz+Xn9/ZHktiKwDJVS0" +
           "uXGgaoZ7YBXXsLZ2gO/v0YGYMMXXXWNL7edvcYn5ahH9i6R0yTIS/uRt0Q3O" +
           "Cy+oQeAain+sk1+63Wnhye62Gf/8tKx+EISP72X18bdUVsXnL2wr/JtbwP+V" +
           "IvrlpHR5B//0zcxrx0C/dqdAnwLhxT3QF+8S0N+8BdCvF9HrSelte6CHlz0n" +
           "MP76nWJ8GoRP7jF+8i5h/OYtMP7HIvpGUnpoh/H4nuYEyH93pyCLO5vP7EF+" +
           "5i6B/INbgPxWEf1eUrqyA3n2SuoE1N9/K3T2pT3Ul+4S1D+9BdRvF9EfH+ns" +
           "0W3SCYz/7a0Yzs/tMX7uLmH8s1tg/Isi+u7RcJ69ODsB9Y07gHqpyPwwCF/Y" +
           "Q/3C3YF67tzNoZ7buj9/WVwQ3n6puXcV2Pox9r+6U+wfAeEn99h/8i5hv3wL" +
           "7FeK6G1gnYmvX2fO3XcE9NxDdwq0A8Ire6Cv3CWg774F0CeL6DEwZ+NT68xJ" +
           "jI/fKca/C8LP7DH+zF3C+MFbYHymiJ4untecXmdOgrx6pyCLdj+3B/lzdwkk" +
           "fAuQzSKCgGGKb7TOnIRaeSugfnkP9ct3");
        public static final java.lang.String
          jlc$ClassType$jl5$1 =
          ("Cepzt4DaK6Jnj6CescEnoX7orZier+2hvnaXoJK3gEoX0fBoet4II3anGD8I" +
           "wlf3GL/61mA8CWF6izK5iPijkcR9O7EV90YohTeDMgN79OseZW9rgc1Y+U08" +
           "7QY74Mev+xnJ7qcP2muvXHrgsVfE/7x9ynz084QHydIDZuq6J98NnkjfH0aG" +
           "aW9l9uDuFWG4FYSWlJ64OV9gd75LFBjOqbsmZlJ69AZNEtD/Pnmytp2ULh7X" +
           "TkrntVPFYGN9YV+clO4B8cnCAGSBwiIZhodiPPEoZvfAMtv5Eo+f1LStM3Dl" +
           "dkN34tji6VPnDdsf+hyeDaS7n/o8r33lFYL+kTeaP7t7i625ymZTUHmALF3Y" +
           "PQvfEi3OF95/U2qHtO7Hrn3v4V968AcOD0Ie3jF8rPUneHvvjR87I16YbJ8n" +
           "b/71Y7/8oX/5yh9uXwX9P1S8z2eBNQAA");
    }
    edu.umd.cs.findbugs.BugReporter bugReporter;
    edu.umd.cs.findbugs.BugAccumulator bugAccumulator;
    final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,int[]>
      preparedStatementMethods;
    final java.util.Map<edu.umd.cs.findbugs.classfile.MethodDescriptor,int[]>
      executeMethods;
    final java.util.Set<edu.umd.cs.findbugs.classfile.MethodDescriptor>
      allMethods =
      new java.util.HashSet<edu.umd.cs.findbugs.classfile.MethodDescriptor>(
      );
    private final boolean testingEnabled;
    public FindSqlInjection(edu.umd.cs.findbugs.BugReporter bugReporter) {
        super(
          );
        this.
          bugReporter =
          bugReporter;
        this.
          bugAccumulator =
          new edu.umd.cs.findbugs.BugAccumulator(
            bugReporter);
        testingEnabled =
          edu.umd.cs.findbugs.SystemProperties.
            getBoolean(
              "report_TESTING_pattern_in_standard_detectors");
        java.util.Set<edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter> baseExecuteMethods =
          new java.util.HashSet<edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter>(
          );
        for (edu.umd.cs.findbugs.classfile.MethodDescriptor executeMethod
              :
              EXECUTE_METHODS) {
            baseExecuteMethods.
              add(
                new edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter(
                  executeMethod,
                  0));
        }
        executeMethods =
          edu.umd.cs.findbugs.classfile.Global.
            getAnalysisCache(
              ).
            getDatabase(
              edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.StringPassthruDatabase.class).
            findLinkedMethods(
              baseExecuteMethods);
        java.util.Set<edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter> basePrepareMethods =
          new java.util.HashSet<edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter>(
          );
        for (java.lang.String signature
              :
              PREPARE_STATEMENT_SIGNATURES) {
            basePrepareMethods.
              add(
                new edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.MethodParameter(
                  new edu.umd.cs.findbugs.classfile.MethodDescriptor(
                    "java/sql/Connection",
                    "prepareStatement",
                    signature),
                  0));
        }
        preparedStatementMethods =
          edu.umd.cs.findbugs.classfile.Global.
            getAnalysisCache(
              ).
            getDatabase(
              edu.umd.cs.findbugs.detect.BuildStringPassthruGraph.StringPassthruDatabase.class).
            findLinkedMethods(
              basePrepareMethods);
        allMethods.
          addAll(
            executeMethods.
              keySet(
                ));
        allMethods.
          addAll(
            preparedStatementMethods.
              keySet(
                ));
    }
    @java.lang.Override
    public void visitClassContext(edu.umd.cs.findbugs.ba.ClassContext classContext) {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        if (!edu.umd.cs.findbugs.visitclass.PreorderVisitor.
              hasInterestingMethod(
                javaClass.
                  getConstantPool(
                    ),
                allMethods)) {
            return;
        }
        org.apache.bcel.classfile.Method[] methodList =
          javaClass.
          getMethods(
            );
        for (org.apache.bcel.classfile.Method method
              :
              methodList) {
            org.apache.bcel.generic.MethodGen methodGen =
              classContext.
              getMethodGen(
                method);
            if (methodGen ==
                  null) {
                continue;
            }
            try {
                analyzeMethod(
                  classContext,
                  method);
            }
            catch (edu.umd.cs.findbugs.ba.DataflowAnalysisException e) {
                bugReporter.
                  logError(
                    "FindSqlInjection caught exception while analyzing " +
                    classContext.
                      getFullyQualifiedMethodName(
                        method),
                    e);
            }
            catch (edu.umd.cs.findbugs.ba.CFGBuilderException e) {
                bugReporter.
                  logError(
                    "FindSqlInjection caught exception while analyzing " +
                    classContext.
                      getFullyQualifiedMethodName(
                        method),
                    e);
            }
            catch (java.lang.RuntimeException e) {
                bugReporter.
                  logError(
                    "FindSqlInjection caught exception while analyzing " +
                    classContext.
                      getFullyQualifiedMethodName(
                        method),
                    e);
            }
        }
    }
    private boolean isStringAppend(org.apache.bcel.generic.Instruction ins,
                                   org.apache.bcel.generic.ConstantPoolGen cpg) {
        if (ins instanceof org.apache.bcel.generic.INVOKEVIRTUAL) {
            org.apache.bcel.generic.INVOKEVIRTUAL invoke =
              (org.apache.bcel.generic.INVOKEVIRTUAL)
                ins;
            if ("append".
                  equals(
                    invoke.
                      getMethodName(
                        cpg)) &&
                  invoke.
                  getClassName(
                    cpg).
                  startsWith(
                    "java.lang.StringB")) {
                java.lang.String sig =
                  invoke.
                  getSignature(
                    cpg);
                char firstChar =
                  sig.
                  charAt(
                    1);
                return firstChar ==
                  '[' ||
                  firstChar ==
                  'L';
            }
        }
        return false;
    }
    private boolean isConstantStringLoad(edu.umd.cs.findbugs.ba.Location location,
                                         org.apache.bcel.generic.ConstantPoolGen cpg) {
        org.apache.bcel.generic.Instruction ins =
          location.
          getHandle(
            ).
          getInstruction(
            );
        if (ins instanceof org.apache.bcel.generic.LDC) {
            org.apache.bcel.generic.LDC load =
              (org.apache.bcel.generic.LDC)
                ins;
            java.lang.Object value =
              load.
              getValue(
                cpg);
            if (value instanceof java.lang.String) {
                return true;
            }
        }
        return false;
    }
    static final java.util.regex.Pattern openQuotePattern =
      java.util.regex.Pattern.
      compile(
        "((^\')|[^\\p{Alnum}]\')$");
    public static boolean isOpenQuote(java.lang.String s) {
        return openQuotePattern.
          matcher(
            s).
          find(
            );
    }
    static final java.util.regex.Pattern closeQuotePattern =
      java.util.regex.Pattern.
      compile(
        "^\'($|[^\\p{Alnum}])");
    public static boolean isCloseQuote(java.lang.String s) {
        return closeQuotePattern.
          matcher(
            s).
          find(
            );
    }
    private edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState updateStringAppendState(edu.umd.cs.findbugs.ba.Location location,
                                                                                                  org.apache.bcel.generic.ConstantPoolGen cpg,
                                                                                                  edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState stringAppendState) {
        org.apache.bcel.generic.InstructionHandle handle =
          location.
          getHandle(
            );
        org.apache.bcel.generic.Instruction ins =
          handle.
          getInstruction(
            );
        if (!isConstantStringLoad(
               location,
               cpg)) {
            throw new java.lang.IllegalArgumentException(
              "instruction must be LDC");
        }
        org.apache.bcel.generic.LDC load =
          (org.apache.bcel.generic.LDC)
            ins;
        java.lang.Object value =
          load.
          getValue(
            cpg);
        java.lang.String stringValue =
          ((java.lang.String)
             value).
          trim(
            );
        if (stringValue.
              startsWith(
                ",") ||
              stringValue.
              endsWith(
                ",")) {
            stringAppendState.
              setSawComma(
                handle);
        }
        if (isCloseQuote(
              stringValue) &&
              stringAppendState.
              getSawOpenQuote(
                handle)) {
            stringAppendState.
              setSawCloseQuote(
                handle);
        }
        if (isOpenQuote(
              stringValue)) {
            stringAppendState.
              setSawOpenQuote(
                handle);
        }
        return stringAppendState;
    }
    private edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState getStringAppendState(edu.umd.cs.findbugs.ba.CFG cfg,
                                                                                               org.apache.bcel.generic.ConstantPoolGen cpg)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException {
        edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState stringAppendState =
          new edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState(
          );
        java.lang.String sig =
          method.
          getSignature(
            );
        sig =
          sig.
            substring(
              0,
              sig.
                indexOf(
                  ')'));
        if (sig.
              indexOf(
                "java/lang/String") >=
              0) {
            stringAppendState.
              setSawInitialTaint(
                );
        }
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.InstructionHandle handle =
              location.
              getHandle(
                );
            org.apache.bcel.generic.Instruction ins =
              handle.
              getInstruction(
                );
            if (isConstantStringLoad(
                  location,
                  cpg)) {
                stringAppendState =
                  updateStringAppendState(
                    location,
                    cpg,
                    stringAppendState);
            }
            else
                if (isStringAppend(
                      ins,
                      cpg)) {
                    stringAppendState.
                      setSawAppend(
                        handle);
                    edu.umd.cs.findbugs.ba.Location prevLocation =
                      getPreviousLocation(
                        cfg,
                        location,
                        true);
                    if (prevLocation !=
                          null &&
                          !isSafeValue(
                             prevLocation,
                             cpg)) {
                        stringAppendState.
                          setSawUnsafeAppend(
                            handle);
                    }
                }
                else
                    if (ins instanceof org.apache.bcel.generic.InvokeInstruction) {
                        org.apache.bcel.generic.InvokeInstruction inv =
                          (org.apache.bcel.generic.InvokeInstruction)
                            ins;
                        java.lang.String sig1 =
                          inv.
                          getSignature(
                            cpg);
                        java.lang.String sig2 =
                          sig1.
                          substring(
                            sig1.
                              indexOf(
                                ')'));
                        if (sig2.
                              indexOf(
                                "java/lang/String") >=
                              0) {
                            java.lang.String methodName =
                              inv.
                              getMethodName(
                                cpg);
                            java.lang.String className =
                              inv.
                              getClassName(
                                cpg);
                            if ("valueOf".
                                  equals(
                                    methodName) &&
                                  "java.lang.String".
                                  equals(
                                    className) &&
                                  "(Ljava/lang/Object;)Ljava/lang/String;".
                                  equals(
                                    sig1)) {
                                try {
                                    edu.umd.cs.findbugs.ba.type.TypeDataflow typeDataflow =
                                      classContext.
                                      getTypeDataflow(
                                        method);
                                    edu.umd.cs.findbugs.ba.type.TypeFrame frame =
                                      typeDataflow.
                                      getFactAtLocation(
                                        location);
                                    if (!frame.
                                          isValid(
                                            )) {
                                        continue;
                                    }
                                    org.apache.bcel.generic.Type operandType =
                                      frame.
                                      getTopValue(
                                        );
                                    if (operandType.
                                          equals(
                                            edu.umd.cs.findbugs.ba.type.TopType.
                                              instance(
                                                ))) {
                                        continue;
                                    }
                                    java.lang.String sig3 =
                                      operandType.
                                      getSignature(
                                        );
                                    if (!"Ljava/lang/String;".
                                          equals(
                                            sig3)) {
                                        stringAppendState.
                                          setSawTaint(
                                            handle);
                                    }
                                }
                                catch (edu.umd.cs.findbugs.classfile.CheckedAnalysisException e) {
                                    stringAppendState.
                                      setSawTaint(
                                        handle);
                                }
                            }
                            else
                                if (className.
                                      startsWith(
                                        "java.lang.String") ||
                                      "java.lang.Long".
                                      equals(
                                        className) ||
                                      "java.lang.Integer".
                                      equals(
                                        className) ||
                                      "java.lang.Float".
                                      equals(
                                        className) ||
                                      "java.lang.Double".
                                      equals(
                                        className) ||
                                      "java.lang.Short".
                                      equals(
                                        className) ||
                                      "java.lang.Byte".
                                      equals(
                                        className) ||
                                      "java.lang.Character".
                                      equals(
                                        className)) {
                                    assert true;
                                }
                                else
                                    if (methodName.
                                          startsWith(
                                            "to") &&
                                          methodName.
                                          endsWith(
                                            "String") &&
                                          methodName.
                                          length(
                                            ) >
                                          8) {
                                        assert true;
                                    }
                                    else
                                        if (className.
                                              startsWith(
                                                "javax.servlet") &&
                                              methodName.
                                              startsWith(
                                                "get")) {
                                            stringAppendState.
                                              setSawTaint(
                                                handle);
                                            stringAppendState.
                                              setSawSeriousTaint(
                                                handle);
                                        }
                                        else {
                                            stringAppendState.
                                              setSawTaint(
                                                handle);
                                        }
                        }
                    }
                    else
                        if (ins instanceof org.apache.bcel.generic.GETFIELD) {
                            org.apache.bcel.generic.GETFIELD getfield =
                              (org.apache.bcel.generic.GETFIELD)
                                ins;
                            java.lang.String sig2 =
                              getfield.
                              getSignature(
                                cpg);
                            if (sig2.
                                  indexOf(
                                    "java/lang/String") >=
                                  0) {
                                stringAppendState.
                                  setSawTaint(
                                    handle);
                            }
                        }
        }
        return stringAppendState;
    }
    private boolean isSafeValue(edu.umd.cs.findbugs.ba.Location location,
                                org.apache.bcel.generic.ConstantPoolGen cpg)
          throws edu.umd.cs.findbugs.ba.CFGBuilderException {
        org.apache.bcel.generic.Instruction prevIns =
          location.
          getHandle(
            ).
          getInstruction(
            );
        if (prevIns instanceof org.apache.bcel.generic.LDC ||
              prevIns instanceof org.apache.bcel.generic.GETSTATIC) {
            return true;
        }
        if (prevIns instanceof org.apache.bcel.generic.InvokeInstruction) {
            java.lang.String methodName =
              ((org.apache.bcel.generic.InvokeInstruction)
                 prevIns).
              getMethodName(
                cpg);
            if (methodName.
                  startsWith(
                    "to") &&
                  methodName.
                  endsWith(
                    "String") &&
                  methodName.
                  length(
                    ) >
                  8) {
                return true;
            }
        }
        if (prevIns instanceof org.apache.bcel.generic.AALOAD) {
            edu.umd.cs.findbugs.ba.CFG cfg =
              classContext.
              getCFG(
                method);
            edu.umd.cs.findbugs.ba.Location prev =
              getPreviousLocation(
                cfg,
                location,
                true);
            if (prev !=
                  null) {
                edu.umd.cs.findbugs.ba.Location prev2 =
                  getPreviousLocation(
                    cfg,
                    prev,
                    true);
                if (prev2 !=
                      null &&
                      prev2.
                      getHandle(
                        ).
                      getInstruction(
                        ) instanceof org.apache.bcel.generic.GETSTATIC) {
                    org.apache.bcel.generic.GETSTATIC getStatic =
                      (org.apache.bcel.generic.GETSTATIC)
                        prev2.
                        getHandle(
                          ).
                        getInstruction(
                          );
                    if ("[Ljava/lang/String;".
                          equals(
                            getStatic.
                              getSignature(
                                cpg))) {
                        return true;
                    }
                }
            }
        }
        return false;
    }
    @javax.annotation.CheckForNull
    private org.apache.bcel.generic.InstructionHandle getPreviousInstruction(org.apache.bcel.generic.InstructionHandle handle,
                                                                             boolean skipNops) {
        while (handle.
                 getPrev(
                   ) !=
                 null) {
            handle =
              handle.
                getPrev(
                  );
            org.apache.bcel.generic.Instruction prevIns =
              handle.
              getInstruction(
                );
            if (!(prevIns instanceof org.apache.bcel.generic.NOP &&
                    skipNops)) {
                return handle;
            }
        }
        return null;
    }
    @javax.annotation.CheckForNull
    private edu.umd.cs.findbugs.ba.Location getPreviousLocation(edu.umd.cs.findbugs.ba.CFG cfg,
                                                                edu.umd.cs.findbugs.ba.Location startLocation,
                                                                boolean skipNops) {
        edu.umd.cs.findbugs.ba.Location loc =
          startLocation;
        org.apache.bcel.generic.InstructionHandle prev =
          getPreviousInstruction(
            loc.
              getHandle(
                ),
            skipNops);
        if (prev !=
              null) {
            return new edu.umd.cs.findbugs.ba.Location(
              prev,
              loc.
                getBasicBlock(
                  ));
        }
        edu.umd.cs.findbugs.ba.BasicBlock block =
          loc.
          getBasicBlock(
            );
        while (true) {
            block =
              cfg.
                getPredecessorWithEdgeType(
                  block,
                  edu.umd.cs.findbugs.ba.EdgeTypes.
                    FALL_THROUGH_EDGE);
            if (block ==
                  null) {
                return null;
            }
            org.apache.bcel.generic.InstructionHandle lastInstruction =
              block.
              getLastInstruction(
                );
            if (lastInstruction !=
                  null) {
                return new edu.umd.cs.findbugs.ba.Location(
                  lastInstruction,
                  block);
            }
        }
    }
    private edu.umd.cs.findbugs.BugInstance generateBugInstance(org.apache.bcel.classfile.JavaClass javaClass,
                                                                org.apache.bcel.generic.MethodGen methodGen,
                                                                org.apache.bcel.generic.InstructionHandle handle,
                                                                edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState stringAppendState,
                                                                boolean isExecute) {
        int priority =
          LOW_PRIORITY;
        boolean sawSeriousTaint =
          false;
        if (stringAppendState.
              getSawAppend(
                handle)) {
            if (stringAppendState.
                  getSawOpenQuote(
                    handle) &&
                  stringAppendState.
                  getSawCloseQuote(
                    handle)) {
                priority =
                  HIGH_PRIORITY;
            }
            else
                if (stringAppendState.
                      getSawComma(
                        handle)) {
                    priority =
                      NORMAL_PRIORITY;
                }
            if (!stringAppendState.
                  getSawUnsafeAppend(
                    handle)) {
                priority +=
                  2;
            }
            else
                if (stringAppendState.
                      getSawSeriousTaint(
                        handle)) {
                    priority--;
                    sawSeriousTaint =
                      true;
                }
                else
                    if (!stringAppendState.
                          getSawTaint(
                            handle)) {
                        priority++;
                    }
        }
        java.lang.String description =
          "TESTING";
        if (isExecute) {
            description =
              "SQL_NONCONSTANT_STRING_PASSED_TO_EXECUTE";
        }
        else {
            description =
              "SQL_PREPARED_STATEMENT_GENERATED_FROM_NONCONSTANT_STRING";
        }
        edu.umd.cs.findbugs.BugInstance bug =
          new edu.umd.cs.findbugs.BugInstance(
          this,
          description,
          priority);
        bug.
          addClassAndMethod(
            methodGen,
            javaClass.
              getSourceFileName(
                ));
        if ("TESTING".
              equals(
                description)) {
            bug.
              addString(
                "Incomplete report invoking non-constant SQL string");
        }
        if (sawSeriousTaint) {
            bug.
              addString(
                "non-constant SQL string involving HTTP taint");
        }
        return bug;
    }
    org.apache.bcel.classfile.Method method;
    edu.umd.cs.findbugs.ba.ClassContext classContext;
    private void analyzeMethod(edu.umd.cs.findbugs.ba.ClassContext classContext,
                               org.apache.bcel.classfile.Method method)
          throws edu.umd.cs.findbugs.ba.DataflowAnalysisException,
        edu.umd.cs.findbugs.ba.CFGBuilderException {
        org.apache.bcel.classfile.JavaClass javaClass =
          classContext.
          getJavaClass(
            );
        this.
          method =
          method;
        this.
          classContext =
          classContext;
        org.apache.bcel.generic.MethodGen methodGen =
          classContext.
          getMethodGen(
            method);
        if (methodGen ==
              null) {
            return;
        }
        org.apache.bcel.generic.ConstantPoolGen cpg =
          methodGen.
          getConstantPool(
            );
        edu.umd.cs.findbugs.ba.CFG cfg =
          classContext.
          getCFG(
            method);
        edu.umd.cs.findbugs.detect.FindSqlInjection.StringAppendState stringAppendState =
          getStringAppendState(
            cfg,
            cpg);
        edu.umd.cs.findbugs.ba.constant.ConstantDataflow dataflow =
          classContext.
          getConstantDataflow(
            method);
        for (java.util.Iterator<edu.umd.cs.findbugs.ba.Location> i =
               cfg.
               locationIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            edu.umd.cs.findbugs.ba.Location location =
              i.
              next(
                );
            org.apache.bcel.generic.Instruction ins =
              location.
              getHandle(
                ).
              getInstruction(
                );
            if (!(ins instanceof org.apache.bcel.generic.InvokeInstruction)) {
                continue;
            }
            org.apache.bcel.generic.InvokeInstruction invoke =
              (org.apache.bcel.generic.InvokeInstruction)
                ins;
            edu.umd.cs.findbugs.classfile.MethodDescriptor md =
              new edu.umd.cs.findbugs.classfile.MethodDescriptor(
              invoke,
              cpg);
            boolean executeMethod;
            int[] params =
              preparedStatementMethods.
              get(
                md);
            int paramNumber;
            if (params !=
                  null) {
                executeMethod =
                  false;
                paramNumber =
                  params[0];
            }
            else {
                params =
                  executeMethods.
                    get(
                      md);
                if (params !=
                      null) {
                    executeMethod =
                      true;
                    paramNumber =
                      params[0];
                }
                else {
                    continue;
                }
            }
            edu.umd.cs.findbugs.ba.constant.ConstantFrame frame =
              dataflow.
              getFactAtLocation(
                location);
            int numArguments =
              frame.
              getNumArguments(
                invoke,
                cpg);
            edu.umd.cs.findbugs.ba.constant.Constant value =
              frame.
              getStackValue(
                numArguments -
                  1 -
                  paramNumber);
            if (!value.
                  isConstantString(
                    )) {
                edu.umd.cs.findbugs.ba.Location prev =
                  getPreviousLocation(
                    cfg,
                    location,
                    true);
                if (prev ==
                      null ||
                      !isSafeValue(
                         prev,
                         cpg)) {
                    edu.umd.cs.findbugs.BugInstance bug =
                      generateBugInstance(
                        javaClass,
                        methodGen,
                        location.
                          getHandle(
                            ),
                        stringAppendState,
                        executeMethod);
                    if (!testingEnabled &&
                          "TESTING".
                          equals(
                            bug.
                              getType(
                                ))) {
                        continue;
                    }
                    bugAccumulator.
                      accumulateBug(
                        bug,
                        edu.umd.cs.findbugs.SourceLineAnnotation.
                          fromVisitedInstruction(
                            classContext,
                            methodGen,
                            javaClass.
                              getSourceFileName(
                                ),
                            location.
                              getHandle(
                                )));
                }
            }
        }
        bugAccumulator.
          reportAccumulatedBugs(
            );
    }
    @java.lang.Override
    public void report() {  }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "VZEyuNPuCqiSxauV6Br+iE8X/x/T828hrTsAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "35xc+FSNk1NPO77Neu63fv0vr37jjivPMn/xwGtf9Hy5P/j926r3JU99e0FK" +
       "x3Ps3cB7ifOcSena5Q/Pirp2tH7fiXdRuti7eOSMq7uz9lNz4gMnfitIziM/" +
       "eGaOuBiA6xrpXud/6g/eixZTwNWVBVZUhi7sn+WdXUGcrKqfOfN870KIrmuf" +
       "/ui3/eob/lR8pHhws0MjFwtZ73irubeU2wpL2U0slztDe4mKBc917Z98/9//" +
       "1mee/cSv3Va6EzBwTtu5AZAeYIbLnneeruApAdx1QSnA5Q/uSgMnoujUfec9" +
       "fBx7vKxOSm+7rO7CHzi3+s6fGDp+ZkQdP/X0vNonzk0caRCcTj3tZt26GXwd" +
       "WCq+BOiONd+PvNLDhbk/eDKT527B6UTgCjyC0W2evy5ILH5dbHNku0MX5P7B" +
       "3Ls9EC/wynaO/vocvxfj/iq47tnXf89OJekL80yq6D8j3j9APnrg9cWrvOgw" +
       "+XLX8yNHNPYTL9H1zAOxqDQPfuxGxyv/+e48UG/0pPLfxq7ZonQeWDdxEP7t" +
       "TdJ+Lg9+Og+8nSQ3yfuxPb1/KA8+XET98IlxUPntjxax2zOr39L63Pzx7bc4" +
       "f6Dg+tjejj52yfzxyy9l/njQWBtamhjDkyXP95yT7d/fomzvANcv7GX7hUtk" +
       "+/WXItu9iuMczWZ51HfdCj2AtfnNZgmQnEd+vEj652co+aBQ8MqxXX3oH9vs" +
       "sTV8vLAG/CVbw2+8dMQfzmNzr/GFPeIvXIL4H95kGOJnTSIx4gRwP+7lnLmz" +
       "iWmRthPrnUnpLtX3HUPxzsn9iZcud37lzykOru6y7v5fIPenbiL3Wf/6IT8w" +
       "vHG+2maVBDiZ3lG3n3oQFhlzY324Tz8n/advUXoBSP2qvfSvukT6z71k6V8B" +
       "VjaxcVr8POHPzsn4+Vt0koF5HHxqL+OnLpHxr1/ESb7z1OMQgOY1P5ofKoGi" +
       "LYxDVTOcG1Ye50T+m1sU+Qkg6mf2In/mYpEPSi8i8v2FTPvp6kjwJy/y6lVl" +
       "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" +
       "tptZUh+67hxpAl9O8EQrNUMYnRGN5mra");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("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" +
       "lZA3uFld6NgGJTFej+SRxFB0WG35gCUrKSVKUKg6a2jNxGackCuJ2+pJt2lM" +
       "1vZ8sxKWG7kNlkhkG88gI2q0KRXpyqNwJcejURenuIWcmAkd4dN2uTqZSKEw" +
       "a3C+047LUsgPFXo1rNvcSLfmEJb0Vti4GULzvjQa9HmYXrSzmjjMWrHheJpc" +
       "46Apwc8GzGSJs0arUpm3tsi0x0+0Cb3CUU1xRQ/l+tMyTdFin5o7W7y9Jk2V" +
       "k+bDJsa1y20p6jVhwzVZORR6nlYhwVJM8mKddITakG9Py7W4R5Tb0y5EL0mN" +
       "2CwgqupvyDkRwI2m0odRV8pQkNiypS7MzCqsuFqT9GZijlRs0YJUwdmCpWs4" +
       "buMzod+NOd7dcGJ9pfH9nkOUZ2WM3kp9sTqbWTbksUvZcWfDUWUzJvVlxYrc" +
       "1A7aQzCoMdUdjRrZFKogFrzxatt5MzTMWoVFxgGHR9aQw2ZceWb2GXSw4RjN" +
       "a6IITegtS2u1nISCERdCphEHNyJx1qh55LyhwiyGoKbtq4mBzpAYbeqzpg7h" +
       "whgs0rsOJM9Wuu6Wl45mMvM5YBhZ66LzOO1ssU3ALlKUs1ft1tjjlZpKbjmu" +
       "6dXb7WjeStIwW3FllZJMvgMn9GAWD7NaPRBlfJMybIqFFr9WUhHtRJCFN2fw" +
       "Ghaa1eYiEuJ2u/2Od+SvOx6/tdcdryje4hyffftHvL/ZJe32Sh6/Eiv+8s2I" +
       "Z85LnXolduo98vERhccvetPVLc4P+VG+efZ1l517KzbOfvg9H3hOH/1g5cr+" +
       "hdpXJ6V7Ej94m2OsDOdUew/stl0cy1qce3k7uH5vL+vvnX99d4LGxa/+37xD" +
       "89yGi4PjDAd35BkOKpfvyDio5cFbQX8Um7mw8+8Bz791WvmWfvK+721nu+f+" +
       "4+45hvbhU9t8VkYUWbpxkx698QzEOciK7eT5Tsa/2EP2F7cKGX4hZOf2Kj95" +
       "/p3tPN+kbmmH5P5w1dE+YpD3yy7Le3TKgfV9p2d4BdrYTXqCzIOvSEoPWvFu" +
       "n3o7CIzddq8/OYH8K1/sHd+LofdmAMSV/fviK18U9C488aMqh7SvKfsDWAdE" +
       "oTJ/EzhyyztgktIrT86L7GChfeU8KKOXAUp+OKH0JqDfnj52/18iKCe7sogX" +
       "GYolttBKuYnGWh4A8rjPikdHWzPOKfqul6volwJpHt0r+ugXU1H3JormZ10P" +
       "FknpftC1x7s4zmlqvQxNn8gjESDOa/eavvYLY+e3Hc9oB0JhxEcW/45bOID6" +
       "1OnBXexCLjDZ3ASvZ/MgSUqPpoEO8t9QQZ68PYEufbnQVQEKtT10tS8KRbzm" +
       "sr0lRO+EHd57sY0d1fGWy+vopFZ+aBhfa0aQY15U96158B5AKHMjeTEIv+nl" +
       "suzrgaDftIfwm76gEJ5YX6HV914++f+zIsMH8+A7C1bhFdMoDtqdG2vf9TK0" +
       "fXUe+VbQ4of22n7oi2IwT7+EGbmvePruTP2fFJr/y5sMqR/Kg+eS0quBMbCR" +
       "sbL8ND5VVZ764ROA/sWL+jmvK/b4Hp4cMzrEFoZmE37EpI7zclyeB/LIa6Cp" +
       "5/cAP/8FJ7P3HdnUHrifvAlw/yYPPpqUHjkF3OmJXThB7ccvRS1P/dGXA8pj" +
       "eSQEavrFPSi/+IUB5Y4iwx2X+oEne/cGoL8Lb/ko7xsus9DdLj/gARZGVRDN" +
       "CdS/dBOofyUPfr6AendEspPOjw4M3NTXOp+v6I2PvYxBfn8e2QfIfXYP92e/" +
       "4JR2Rx73d4Xe//nmVFC+hPe7SqKYjp+1PcXZxFZ8zP4nXPh7efDbSekBJc+z" +
       "NY43YB4gJ0D9p5cBVLGkA8Z55W27srv/twLUxUu602bxxzdJ+x958N+T0p1R" +
       "cXLsnGZ/eNMB+eW3NCDXSemh865N/qGAx274kM/u4zPaR567evejz03+6+54" +
       "8dEHYu6hS3ebgCFPn9c+dX9nEBmmVUByz+70drFN/OCzl7gQO58L6L+7yaU+" +
       "+NNdkf8FBtIFRRLQ/v72dO7PJ6V7T3InpSvameS/SEp37ZOT0m0gPJ341yAK" +
       "JOa3f1P0+o+ud/PEY6eNpni+8fCL2dpxkdPfojh/hGqY7j6sdF376HMD5ms/" +
       "j/7g7lsYgK22BdfcTZfu2n2Wo6g0P+v6hktrO6rrzv7Tf/vgj9/zpqPHGg/u" +
       "BD4x4FOyvf7iD0/gbpAUn4rY/syjP/n2H3ruE8Um2f8HtgqE8e9KAAA=");
}
