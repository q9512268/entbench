package org.apache.batik.swing.gvt;
public class AbstractImageZoomInteractor extends org.apache.batik.swing.gvt.InteractorAdapter {
    protected boolean finished = true;
    protected int xStart;
    protected int yStart;
    protected int xCurrent;
    protected int yCurrent;
    public boolean endInteraction() { return finished; }
    public void mousePressed(java.awt.event.MouseEvent e) { if (!finished) {
                                                                org.apache.batik.swing.gvt.JGVTComponent c =
                                                                  (org.apache.batik.swing.gvt.JGVTComponent)
                                                                    e.
                                                                    getSource(
                                                                      );
                                                                c.
                                                                  setPaintingTransform(
                                                                    null);
                                                                return;
                                                            }
                                                            finished =
                                                              false;
                                                            xStart =
                                                              e.
                                                                getX(
                                                                  );
                                                            yStart =
                                                              e.
                                                                getY(
                                                                  );
    }
    public void mouseReleased(java.awt.event.MouseEvent e) {
        finished =
          true;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        java.awt.geom.AffineTransform pt =
          c.
          getPaintingTransform(
            );
        if (pt !=
              null) {
            java.awt.geom.AffineTransform rt =
              (java.awt.geom.AffineTransform)
                c.
                getRenderingTransform(
                  ).
                clone(
                  );
            rt.
              preConcatenate(
                pt);
            c.
              setRenderingTransform(
                rt);
        }
    }
    public void mouseDragged(java.awt.event.MouseEvent e) {
        java.awt.geom.AffineTransform at;
        org.apache.batik.swing.gvt.JGVTComponent c =
          (org.apache.batik.swing.gvt.JGVTComponent)
            e.
            getSource(
              );
        xCurrent =
          e.
            getX(
              );
        yCurrent =
          e.
            getY(
              );
        at =
          java.awt.geom.AffineTransform.
            getTranslateInstance(
              xStart,
              yStart);
        int dy =
          yCurrent -
          yStart;
        double s;
        if (dy <
              0) {
            dy -=
              10;
            s =
              dy >
                -15
                ? 1.0
                : -15.0 /
                dy;
        }
        else {
            dy +=
              10;
            s =
              dy <
                15
                ? 1.0
                : dy /
                15.0;
        }
        at.
          scale(
            s,
            s);
        at.
          translate(
            -xStart,
            -yStart);
        c.
          setPaintingTransform(
            at);
    }
    public AbstractImageZoomInteractor() { super(
                                             ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "KzL6g1nfW3P6xFUOS9UcYy7XZ6X/PA/D8pre2eRnLt3zy9NfPTJsVgWtuZnN" +
       "pzf7n5ul6L7f/SNrXTinTVKx+PQjobPHGjvWXuf6Drkw7ZZ0dt4CgnZ07zyT" +
       "+lugueQnAVQaQbWCVUNvw5LB9nUE6kbdLqyhzva899aAZsHTliHPeX5ic03r" +
       "pzUnX8Izk2bPVT4MVrMlXGp97GcPBgsQf9jIVZbytpU1K2x2maZqCgUrSSyd" +
       "GZYjoyrPsBSVxUVZ1JMk5k2xLI31G5DA+zQxBRQ5ZBWQd/btFg609P3BhMGc" +
       "SRRMufqnQ1/edmXPa5yAy1jC3Wq77kqnkJhdxF7LmiDbbXng5bMnNFb37uCx" +
       "a8+Y9vix5BMmB8a/+GHw4LhJjOYRYXFWle7WMY8JPusW5ZuFa3T98fzYc0+P" +
       "7TetqvMWvJ1wnnvmrX+/Fjz624uTVFSlUUWRCJYzG7wgUwLN9IbbdGrDF2qe" +
       "P1RX2AXZtweVGbK41yA9MS/uSnUj6oq/c/xwsGi5x5IQRQXLgB3MBMvaT7Lm" +
       "QRNWa3Ky0wYvmufAZ7kFu+U50Bw10cya3mzQ5tKGTJqGek4zT8OfttaFfW11" +
       "PW+nqFC0TsyuMLKfu/y+CR/Bt5WWdStz+Cbn9S2XNvg2wn1jvxI+M5UpmjkX" +
       "PqutiVbnMNPIa2YubeCNdIehQS03qaFDH8HQ+6yp7sth6KN5Dc2lDYaO5DF0" +
       "LI+h6RxUyx7vcDiW/5Wg3OWDK8siRh/zc53rOXWc3Dd+Irb51KqAVQU9DMxO" +
       "FfUOiQwRyTVUERvJk7B7+U2Gk/3eqT78+x+2JNZP5TTE+ppuc95hvxcArS3L" +
       "TdJ+U17e917j1rXJ3VM42CzwRck/5Ld7z158YKlwOMCvbcy0nHXd41Vq85Ji" +
       "uUaoocleGlycWdcZ9lqus9Z1nR+YDpY4Kp/worI8j2qeqnc8z7sjrPkKRdVE" +
       "jtlnaevw0u9g+tDtNl/+MpJ1rFd5/5cyHlWwd8vg02151D31YORS9Tlspzv2" +
       "ezZFc3hJi4cBZUMM7r2KoZNO9sin/GaecJ1izTHK0Aw67CZaJ7HJ8kTRkCLG" +
       "nAAe/7gCyBLZdisK26cewFyqkweQ/fwWH/W7eWJ0gTXnKKriMdpCoPKAILHO" +
       "005Azn+ciJItr+SpBySX6u0CMpEnID9mzXM2aDZoOJHIisfz/4t4pCmam+eG" +
       "jB3nZmfd05t3y8K5EzVls048dIVTe+b+txJIOm5IkvvA4XouUTUSF7mTlebx" +
       "w6zxfkZRY+5bPKiioOVOXDTlX6eoYXJ5CsdI9u2W/gVFtX5pkOPfbrlLFJU7" +
       "clAGmQ9ukbfAFhBhj1dUmx9W5LmAdKLZHsMqPKcLvMk4s6L1t1tRV/5e7Ml7" +
       "/D8udo4yzP+5DAjnT2zc9MjNu0+Z90+ChEdH2SgVUIqbt1yZPLco52j2WCXd" +
       "rbeqn522xK4IPPdfbts4rgDo/K6o0Xcho7dk7mXePrnmxdcPlLwJh48dqABT" +
       "NGNH9lk3rRpQYOwIZx85oCbgN0Vtrd8YWbsi/pff8NsEZB5R5uWWHxAun955" +
       "6fDsk00BVNGDiqHYIWl+CN8wIm8hwpAWQVWi3pkGE2EUEUue80w1gzlm/4vh" +
       "cbHCWZXpZReTFDVnH+eyr3PLJWWYaOsVQ+Y7G05EFU6P519B1tYpN1TVp+D0" +
       "uE6wO828wlYDsDoQ7lVV+1avYoPKN/6u3AeS9/gja67/F05qvDGNHQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAL1ae+zrVn33vW3vvS2l97ZAWwr0xYXRmv1sJ3EelAGO83Li" +
       "JLYT27HZKH4ldvyMH7ET1g2QBmxIDG3lMQn6z0ADVB6bQNuEmIomBgiGxITG" +
       "xjRA06SxMST6x9g0trFj5/e+DyiwRfLJ8Tnfc873+TkvP/k96KYohODAdzYL" +
       "x4/3jCzeWzr4XrwJjGivT+OMEkaGTjpKFE1B2aPag5+4+IMfvtO8dBY6J0PP" +
       "UTzPj5XY8r2IMyLfWRs6DV08Km07hhvF0CV6qawVJIktB6GtKH6Ehp51rGkM" +
       "XaYPWEAACwhgASlYQIgjKtDo2YaXuGTeQvHiaAX9GnSGhs4FWs5eDD1wspNA" +
       "CRV3vxumkAD0cCF/F4BQReMshO4/lH0n8xUCvwtGHn/P6y790Q3QRRm6aHmT" +
       "nB0NMBGDQWToVtdwVSOMCF03dBm63TMMfWKEluJY24JvGbojshaeEiehcaik" +
       "vDAJjLAY80hzt2q5bGGixX54KN7cMhz94O2muaMsgKx3Hsm6k7CTlwMBb7EA" +
       "Y+Fc0YyDJjfalqfH0H2nWxzKeHkACEDT864Rm/7hUDd6CiiA7tjZzlG8BTKJ" +
       "Q8tbANKb/ASMEkP3XLPTXNeBotnKwng0hu4+TcfsqgDVzYUi8iYx9LzTZEVP" +
       "wEr3nLLSMft8b/TKd7zB63lnC551Q3Ny/i+ARveeasQZcyM0PM3YNbz1Yfrd" +
       "yp2fedtZCALEzztFvKP54199+jUvv/epL+xoXnAVmrG6NLT4Ue0D6m1ffSH5" +
       "UOOGnI0LgR9ZufFPSF64P7Nf80gWgMi787DHvHLvoPIp7i+kN37E+O5Z6BYK" +
       "Oqf5TuICP7pd893Acoywa3hGqMSGTkE3G55OFvUUdB7kacszdqXj+TwyYgq6" +
       "0SmKzvnFO1DRHHSRq+g8yFve3D/IB0psFvksgCDoPHigW8HzALT7Ff8xZCGm" +
       "7xqIoime5fkIE/q5/BFieLEKdGsiKvB6G4n8JAQuiPjhAlGAH5jGQUUKPAhZ" +
       "rGOEUIGrK1pMucARZN93qdxzldz393KXC/4/B8tyyS+lZ84Ao7zwNCQ4IJp6" +
       "vqMb4aPa40mz/fTHHv3S2cMQ2ddZDFXB+Hu78feK8feK8ffA+HvXGR86c6YY" +
       "9rk5Hzs/AFa0AR4ApLz1ocmv9F//tgdvAA4YpDcCE+SkyLUBmzxCEKrASQ24" +
       "MfTUe9M3Cb+OnoXOnkTenHdQdEvenMnx8hAXL5+OuKv1e/Gt3/nBx9/9mH8U" +
       "eyegfB8SrmyZh/SDp7Uc+pqhA5A86v7h+5VPPfqZxy6fhW4EOAGwMVaALwPY" +
       "uff0GCdC+5EDmMxluQkIPPdDV3HyqgNsuyU2Qz89KinMf1uRvx3omIT2kxPO" +
       "n9c+J8jT5+7cJTfaKSkKGP6lSfD+v/nKP5cLdR8g9sVjc+DEiB85hhJ5ZxcL" +
       "PLj9yAemoWEAur9/L/O77/reW19bOACgePHVBrycpyRAB2BCoObf+MLqb7/1" +
       "zQ987eyR08RgmkxUx9KynZA/Ar8z4Pmf/MmFywt2EX4HuQ8z9x/iTJCP/NIj" +
       "3gDiOCAQcw+6zHuur1tzS1EdI/fY/7r4EuxT//qOSzufcEDJgUu9/Md3cFT+" +
       "/Cb0xi+97t/vLbo5o+Uz3pH+jsh2MPqco56JMFQ2OR/Zm/7qRb/3eeX9AJAB" +
       "CEbW1ihwDSr0ARUGRAtdwEWKnKor5cl90fFAOBlrx1Ymj2rv/Nr3ny18/8+e" +
       "Lrg9ubQ5bvehEjyyc7U8uT8D3d91Oup7SmQCuspTo1++5Dz1Q9CjDHrUAL5F" +
       "4xBAUHbCS/apbzr/jc/++Z2v/+oN0NkOdIvjK3qnwBYwFQBPNyIToFcWvPo1" +
       "O29OL4DkUiEqdIXwOwe5u3i7ABh86NpY08lXJkfhevd/jh31zf/wH1cooUCZ" +
       "q0zIp9rLyJPvu4d81XeL9kfhnre+N7sSlsEq7qht6SPuv5198NznzkLnZeiS" +
       "tr9EFBQnyYNIBsui6GDdCJaRJ+pPLnF28/kjh3D2wtNQc2zY00BzNB2AfE6d" +
       "5285hS235Vp+6f5zkD+BLWegIvOaoskDRXo5T37hIJRvDkI/BlwaetH3QzF0" +
       "YW55VmQa+vUNxoSWCxBnvb8CQh6741v2+77z0d3q5rR1ThEbb3v8t360947H" +
       "zx5bU774imXd8Ta7dWXB4rMLPnN/f+B6oxQtOv/08cc+/aHH3rrj6o6TK6Q2" +
       "2AB89K//+8t77/32F68yBZ9Xfd8xFG8Hz3lazhNi59TVawbAIyfN83zwwPvm" +
       "ga9hHuYa5smzrQO7nMvAdiHcbVU6+zrI//oxdANYqJ9ik/0p2ET32USvwab8" +
       "E7G5KdjM3/hTPL32GfL0AvDg+zzh1+BJ+Ul4upCRSQjm9Ktypf4UXL1in6tX" +
       "XIMr8yfianMdrqwfy9XOBc6AGL6ptFfbQ/N3/+rj3pBnXwZsExUbTtACxLji" +
       "HDBy19LRLh/M1ALYgAKgvbx0akU3zwNb7mKOyCFtb7drO8XrQz8xryBobzvq" +
       "jPbBBvDt//jOL//2i78FArAP3bTOQRRE6rERR0m+J37Lk+960bMe//bbi2UI" +
       "UKTwm39Y+3be6/Z6EudJURMfiHpPLuqkWOPTShQPi9WCoR9KeyqwbnT8n0Ha" +
       "+LanepWIIg5+NCa3xJTPMt7wykjGpJI67LaILsm2EmmI9tvYkNJUKdJsedZO" +
       "2TEbuKqLJOq6Z9RCqqbgsJ60MXbgWiFv+zprxYSy4C2OnVjxyorr1rjMy2u2" +
       "3+GnStdUTIGLA73PYgNypQgzJXAbrl5qIFtvTvHCiB7VtDLcqA2NEgzDelWt" +
       "67a66ixnfHPMKTI5XrVZBuzg0VYpqlozgRJHRpmNYaLeYU0kSRIFXycthZyQ" +
       "g2AshdgsbYVB27d5dDPy19Yy7AwjEp1qXNsdKnMu5Kyp0l4pS6otsOvqEg0E" +
       "jurYc2k11Kh27Lbj5UBeTpZ8pjitiZRiBDpPU7FJW44/VRAFUdOVOeFHLMeV" +
       "N6VJbdtqSHI/CDa4TgWrtLxO20RFFvocKQldTxXtES1ogjJhzcGUo9DlpMJh" +
       "QWyKzaXRE0Syv5qHc2+BrTo2zSLNFrmlyWSWVIWECm2z1W/K3RGPrwOUm8BO" +
       "DRUFVuJMPpGkQEnXik3JC7TZZ5TyMphIPVSwJYw367Tuz2Wqr4REa9D37ZnG" +
       "dsSoIrPlaVYqddvaysen8azp1mdymGJrLdvUNc/x510wAQpwkLUErkOOBoy2" +
       "1VI2XUSU3WYX/oQX+0E470kWK7L6yBHHGQymJqltG7Gj1KaZNBmu2B6tVoyO" +
       "zvkrdG5p01W26Gnt8pYjwQZxplnlESGq8KCS9ceLQX20XMGuiZWiXpZGnXo7" +
       "paVKU8flAaoQfrYxlcpoTsGj5YYiLEJx3QE6mExcJaCymGxW7Q016Zhjk/Gb" +
       "hkeRHBUJxKDZ5UVmzApuJEzSYWXByhK1RDdzUQ7R5qq7qLf5atcvW0iXq/QF" +
       "ZT2JbTduqG6maAjBJUI09olBOualtqU7c4IPRsyKj/vtCkqs14QwyLTOskp2" +
       "sUql3SYocxw30pU6bGRww5jDAzCzz6Z9F7frZrRMKiZhouzUVsIyvpyhs2BN" +
       "TcfLaUdA7UkJzspjeIOsolEJCzqc5VLToWVkLjpD8Qg2vNYSR00sHftrwhBI" +
       "KrADotlDU94JJH+CcpXFMG6nfbVtjKgyFbE1eL0whNQbSQ7lycnWNrDUi1me" +
       "n9Q2AQd36xTPbboS2V6ZJZ1bWutSVAkCewl7gsSxg1nG9mepSM3HzBwb2mbQ" +
       "H1j+JF10BU6w+w03ousYyhDjTpdSpxTf1FnG9KYdlCBJEMS02WotqLYHbDgm" +
       "/E7TsihV8dMmRo9Io0MQpm9ZQc+XtS1NzOV+c4rg8DSQPW9YkWjSbXL42g5Y" +
       "idaxAUYNFWpEjpkuHFVVPJWNkdHrxv5CGFbCxFy7LXydNRkPZrcZ3IalEY7b" +
       "Wqc52yqulo7bqZFaPkM00RblKOXGeDtPmLipkUSTNyvxgpRNP9pomT61bGnK" +
       "NBY9Eg7dAEV1QaBTgeW5pZDybNdxLEPRtUnabZE+PesPqmM2CrbDSCeFsbAc" +
       "oNmkmVFkRXN5VsHZjSyZftiHLVepcDV629U9wtcxRcZ6FVSbTSt1sTQXM4cg" +
       "RHgjdYYiUa9njSnerXP2SkW606w7XWLJBmlEPZwqjQdsZhi17tDbTrIRbo+3" +
       "vWwJ14mU2mSqRabD9ZKepVG73hqvNCk266ksj5DWoq7GujfcemlAVOZLK1DJ" +
       "thc7Wc3S+kvBKY090+qXx67nT9dERjKLEc6vTX5dDuvCFkHQjV7pj8t13hgN" +
       "EKbUjkO7YqWYmDWcIPEZKuR8k2LmY1StrpmZs0TSypjDmxIzctu0so2JQZXE" +
       "pDY1X1eFtQgjBjKzcYloSWzQL1VMsiYz7jra1ttMZVBhhvOG266n22C4Xnlh" +
       "1DbXkqRiQkvd8pFWqrTqfYXqNn2YN7siwAKb1xx2qTIIvBJVepUGdQYLQprm" +
       "u8xSloQ4Q4iqDG97y3KpuqoiI6RjkouJOMfLlbFIuSutkXJubTZqbclae4GA" +
       "2awe1uDhEh1ViXYoZkKPFDk1M0gSXgxinO6om4ZVmyflWIpQriw1NrWlkGGo" +
       "30yrDF0T9LUxR9oAOWRVob3ZmjNCdaIMth2R2ExXLDYzJa+GxXzHrg1StLRl" +
       "qKkwnYv2tiXNuLHKOMNwqm9IZTJMQ5bkwy4iLlqzac8yZTQSnTVS4yZpqVbe" +
       "mO3FBOdpy65g0Sxo09SM6pf9yaSlxXSYzOPxuDLt+4pn1/mO0o6WoTSwNtK8" +
       "h9b4TegMtnR1gXlzscxUsw4/njR4TdrUZnJ1hjAE0qoHoVEyOI+Oy9tNYzRn" +
       "pv1IWIhxInujYDuveXjiVOnaHJmMwtnU8qYAAGGGXfoq0+su1+IsmVdboZ3W" +
       "ZBnV4wq58GS0tt1MYSdZJAbrEQKrsKpICvxoneJ0s+Hx7aqt6vRqY27XSr3R" +
       "UAg56k0dq8cYM9zS0HIYbHlvVqe2dkllhGllKIRDZ9YNGrWuxjQXETtvLClB" +
       "VjdxwGODUlZyFXlFLvhwMtnoXVla+puQiZoTIeMFGesPbdwuZTRVxrp4i4C3" +
       "bNbkWFxugikMUePOooo2mHLTHHa1CccNk/nKYzHE0N0Zo+AbYoMtybK4qtXs" +
       "lWf3TT3r1GjXaqnqzFvg6tAbddRyLSEzpQ5LjbWV4c2h26wrCNztpRXa7C/H" +
       "EifNOqJj1MShVO8zSSTictJRytNGfb6VNBRmalMjXq2H4roPENtbu+EMRjrL" +
       "bbVUSaZCZ+LwvMiRfWnbraULPqVHDUpV9W7Y6pRWBoNxsxIxk+PUELrqoIJt" +
       "iMZwgiQTj19W/RWiIWBi7Vp4hlMsx87oRbM8bA7XyhSIwXIjUSkPNmgqrd1k" +
       "Tsg1u5PAPI42UwzVNkrZ3bJ4POhO+6uuYVe20/p4HsdKZy5iGCPC3qoDllXR" +
       "JhnSg3mCbGCSQ5oxLor6JN7CpOo1JqXZaL0opR62XGcUPMT5wF3aM2YFtr2C" +
       "6g1HDKWUpEQ1yJFOGSY7QcsrpdPq1XssXN0EtSg2q4MR3tJKTktSxnirg9IU" +
       "bFa5jN9ktbXWskQEFxflsdga1COLM5GthpfD8UzUyi0dpkIVxwYr4IJ8ozXM" +
       "xp05P7bYlNtMBb7Nrft2rVmD+VLXRsrGalqrwxlc6o9kBp9O23AQJFoDN9eZ" +
       "RoSTMj3V+zCP1YwGVlti4axfBrNRidymnGYjOK3XthhelwZOOh6Sa1XboF5v" +
       "plcwYVXH+1bCK76vOUbX2WiirskNZ5VEDRnzOFhqBVJlECCpH1L1JbDnytPq" +
       "2xqIYsYecLrQXsaOpxjrFE0aCzhuxSMHgYdBHws7Oo7g2qbniKleXy/QEoZj" +
       "rTImjblJY+qAqWpdMrZyRyubfauiNWV+OKyFpYEvj8aNyPKQrmJofczaTnsD" +
       "lEirNVJW+rVev25POZukux5BGEhtQW6atKxb0aBU1Yy0s1nZqcEi81TsIWLN" +
       "EPvoYjrzBoPQGuoB6TMDgqJ7YxTFia0Ha1afikN4EjQ3k1k1Qclh0PaoVsPd" +
       "zoYlpSX7436PsqL5FqnElYB0FRc2ustm2ZPduY7icXlTH+DtreBEaKWuU8LU" +
       "gFU4zvrU2MUpG6zFKjM/4af8pFNzp46hZml1m81tmZNgXGUGluWPhfGsNXVm" +
       "VcOXZn2cjHSqkZREZCF04hke2GCpo4YO3enzNc0hui7bSGx1TnTMprnEdN7N" +
       "GiJOu4Q+oOVeNFwxA41eD+1KVKWxGIs5AcGN2tCpARRNdL+y2TIwQJilNy1t" +
       "tcZwOUpQWG6gMGm29V5pshB4aqXG2EZmaM3HS8uSSM70UAUmx0ulbFChGEaf" +
       "q3FUCRctHxlUfXSmmX5Nt2vuzGBCz810jXHotG8CdayI5nTUHfUajl0OObB0" +
       "GqeUnNVxn1QXI1SIQ70uiWpkIcF8Xh9FbbmJc3giir2MSLwGjlfnrchG0aYw" +
       "6rasVU+iRAcmR/WUcusmWD2IrCBa5cDutkttvs0nRh1NscXWcZHK2tRUMFfK" +
       "s0DmjGmnJXg92NiEZYbuiyKI0khgYanWRfF2h68yONZoYrEUjLCpEMAtNGlX" +
       "03G9VE8dqRW1fLbmCAKMKWsJOM8IqSZlwpg0kMVSqdaQDoqv1i0gJEsQ+Vb2" +
       "Lc9si317cZpweCEMdtZ5xfoZ7KJ3VQ/kyUsOz16K3zno2vcox86aofx08EXX" +
       "uuctTgY/8ObHn9DHH8TO7p/RD2Lo5tgPftEx1oZzrKsbQU8PX/sUdFhccx+d" +
       "HX/+zf9yz/RV5uufwe3Yfaf4PN3lh4dPfrH7Uu13zkI3HJ4kX3EBf7LRIyfP" +
       "j28JjTgJvemJU+QXHWr2OQfafPW+Zl99+lTryHZXP9J62c7217kCed916p7I" +
       "k/fE0G2Gpx9cZe7fZFFHDvPeH3fscrzbouDxQwmflRc+DJ7evoS9n4+EZ/Zv" +
       "UffPyZ5fnFopKfCTteHFe0M/iYx2ni1af+g6OngyT34/hm518zZMaESRoV/1" +
       "RGrtW/qRVj7ws2olP5Ke7Wtl9nPVSv764YLgT68j+Kfz5JMx9OxCcM5wDAVI" +
       "nhd+7EjKT/08bO/tS+n9H0n5uetI+fk8eerAvK1QWSyuEPKzz0TILIZecJ3v" +
       "APKLzLuv+Bpp9wWN9rEnLl646wn+68VV+OFXLjfT0IV54jjH752O5c+BDcvc" +
       "KoS5eXcLFRR/X4mhe679rUIM3QDSgvu/3NF/NYbuvDp9DN1U/B+n/loMXTpN" +
       "DeiK/+N0X4+hW47oYujcLnOc5BuAF0CSZ/8uOIjYl1/nM4sjbRK6EoB8dubk" +
       "FHNouTt+nOWOzUovPjGXFN+VHeB+svuy7FHt40/0R294uvrB3Z2/5ijbbd7L" +
       "BRo6v/v84HDueOCavR30da730A9v+8TNLzmY527bMXzk88d4u+/ql+ptN4iL" +
       "a/Dtn9z1yVf+wRPfLA7h/xdU+ATq8CcAAA==");
}
