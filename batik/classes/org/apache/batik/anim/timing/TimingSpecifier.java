package org.apache.batik.anim.timing;
public abstract class TimingSpecifier {
    protected org.apache.batik.anim.timing.TimedElement owner;
    protected boolean isBegin;
    protected TimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                              boolean isBegin) { super();
                                                 this.owner = owner;
                                                 this.isBegin = isBegin; }
    public org.apache.batik.anim.timing.TimedElement getOwner() { return owner;
    }
    public boolean isBegin() { return isBegin; }
    public void initialize() {  }
    public void deinitialize() {  }
    public abstract boolean isEventCondition();
    float newInterval(org.apache.batik.anim.timing.Interval interval) { return java.lang.Float.
                                                                                 POSITIVE_INFINITY;
    }
    float removeInterval(org.apache.batik.anim.timing.Interval interval) {
        return java.lang.Float.
                 POSITIVE_INFINITY;
    }
    float handleTimebaseUpdate(org.apache.batik.anim.timing.InstanceTime instanceTime,
                               float newTime) { return java.lang.Float.
                                                         POSITIVE_INFINITY;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188908000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALVaC8zrVn33/dp7e1tK721LoSttaeGWrQ37nMR5UmA4Dydx" +
       "/IztJPYGF8ePxG/HdmwnWzdAY8CQGNtaYBJUmgbaxspjaAikDdSJbYBASEzs" +
       "waYBmzYNxtBA09gDGDt2vu/L9329vaUqi+Tjk/P4n//vf/6P43POY9+EzoYB" +
       "VPA9ez23vWhfS6N9067uR2tfC/dxosrIQaipbVsOQx6UXVZe+KEL3/nu2xYX" +
       "96BzEnSr7LpeJEeG54YjLfTsWFMJ6MKutGtrThhBFwlTjmV4FRk2TBhh9CAB" +
       "PetY1wi6RByyAAMWYMACnLMAo7tWoNOzNXfltLMeshuFS+jnoTMEdM5XMvYi" +
       "6N6TRHw5kJ0DMkyOAFA4n/0fA1B55zSA7jnCvsX8BMCPFOCH3/Hqix++Brog" +
       "QRcMl8vYUQATERhEgm50NGemBSGqqpoqQTe7mqZyWmDItrHJ+ZagW0Jj7srR" +
       "KtCOhJQVrnwtyMfcSe5GJcMWrJTIC47g6YZmq4f/zuq2PAdYn7vDukWIZeUA" +
       "4A0GYCzQZUU77HKtZbhqBL3gdI8jjJeGoAHoep2jRQvvaKhrXRkUQLds586W" +
       "3TnMRYHhzkHTs94KjBJBdzwp0UzWvqxY8ly7HEG3n27HbKtAq+tzQWRdIui2" +
       "081ySmCW7jg1S8fm55vUy976s27f3ct5VjXFzvg/DzrdfarTSNO1QHMVbdvx" +
       "xgeIt8vP/fib9iAINL7tVONtm4/+3Ldf+ZK7H//0ts3zr9CGnpmaEl1W3jO7" +
       "6Qt3tu9vXpOxcd73QiOb/BPIc/VnDmoeTH1gec89ophV7h9WPj76M/G179O+" +
       "sQfdMIDOKZ69coAe3ax4jm/YWtDTXC2QI00dQNdrrtrO6wfQdSBPGK62LaV1" +
       "PdSiAXStnRed8/L/QEQ6IJGJ6DqQN1zdO8z7crTI86kPQdBF8EC3gef50PaX" +
       "vyPoMrzwHA2WFdk1XA9mAi/DH8KaG82AbBfwDGi9BYfeKgAqCHvBHJaBHiy0" +
       "gwrQDRil4QA9gvn8xfmaYgAlD/YzRfP//4dIM5QXkzNnwATcedr8bWA5fc9W" +
       "teCy8vCq1f32By5/du/IHA7kE0EvAaPub0fdz0fdz0bd3466f2pU6MyZfLDn" +
       "ZKNvZxrMkwUsHvjCG+/nXoW/5k0vvAaomJ9cC4ScNYWf3CW3dz5ikHtCBSgq" +
       "9Pg7k9eNf6G4B+2d9K0Zx6Dohqw7k3nEI8936bRNXYnuhTd+7TsffPtD3s66" +
       "TjjrA6N/Ys/MaF94WraBp2gqcIM78g/cI3/k8scfurQHXQs8AfB+kQy0FTiW" +
       "u0+PccJ4Hzx0hBmWswCw7gWObGdVh97rhmgReMmuJJ/0m/L8zUDGN2XafBd4" +
       "HjhQ7/yd1d7qZ+lztkqSTdopFLmjfTnnv/uvP/91JBf3oU++cCzKcVr04DE/" +
       "kBG7kFv8zTsd4ANNA+3+7p3Mrz/yzTf+dK4AoMWLrjTgpSxtA/sHUwjE/IZP" +
       "L7/0lS+/54t7O6WJoOv9wIuApWhqeoQzq4KefRWcYMAX71gCrsQGFDLFuSS4" +
       "jqcC/ZVntpYp6vcu3Ff6yL++9eJWFWxQcqhJL3lqArvyH2tBr/3sq//z7pzM" +
       "GSULZTux7Zpt/eOtO8poEMjrjI/0dX9+1298Sn438LTAu4XGRssd1l4uhr0c" +
       "+W0RdP9TGaimZosT4FPAMPdfZQEUgB6RER8EDfihW75ivetr798GhNMR5lRj" +
       "7U0P//IP9t/68N6xMPyiJ0TC4322oTjXvWdv5/AH4HcGPP+bPdncZQVbV3xL" +
       "+yAe3HMUEHw/BXDuvRpb+RDYP3/woT/8nYfeuIVxy8ko1AWLrPf/5fc/t//O" +
       "r37mCq7vupnn2Zrs5lzCOZcP5Ol+xlY+C1Be9/IseUF43NOcFO+xxd1l5W1f" +
       "/Nazx9/6xLfzEU+uDo8bFin7W/nclCX3ZHCfd9qt9uVwAdpVHqd+5qL9+HcB" +
       "RQlQVECwCOkAePb0hBketD573d/88Sef+5ovXAPtYdANtiermJx7NOh64Eq0" +
       "cAGCQur/1Cu3ZpScP4yRKfQE8Fvzuz3/d/bq6oVli7udP7z9f2h79vp/+K8n" +
       "CCF341fQuFP9Jfixd93RfsU38v47f5r1vjt9YrQDC+Fd3/L7nP/Ye+G5P92D" +
       "rpOgi8rBKnss26vMS0lgZRkeLr3BSvxE/clV4nZJ9OBRvLjztMofG/a0J9+p" +
       "GshnrbP8DVdy3veC554Dp3bPaed9Bsozw7zLvXl6KUt+fOsrs+xP5ERrEVjL" +
       "JgciKm59fpa+IkuI7USiTzrp2EmW7gbPfQcs3fckLI1+GJauM8KWNjfysFE9" +
       "xRT3lEzlRNIzICKcLe/X93NU4pWHvSYCn0+rmW0AP3wuzL9sQC/dcGX7kJfn" +
       "mbZy6dDTjMGXDlDHS6ZdP3S0F3NLyiZ+f/t5cIrf2g/NL7CUm3bECA98abzl" +
       "H9/2uV950VeAOuPQ2ThTNaDFx0akVtnH1y899shdz3r4q2/JoyGQ5fjNv1//" +
       "akZVexLUWfZVWfLqLLl8CPWODCqXLysJOYzIPHpp6hHa8jE8jQjEQO8ZoI0u" +
       "pP1KOEAPf4QgzSaJkk6nq3rHoCsFuMspRr+yZulhu6+w7LIoDlELtyoK4Tk4" +
       "W2TVSmeI0HURQaJIVVd6qJTn3oDqWYGACqy1GK3xRo/lyHnU9qIxG1LegvWi" +
       "1pC1vcLQRGq+MPCHpZa4HFIdRHKlmGnUEEue1nwcmTmIG2+mUYysdGVeKPCy" +
       "WKXKvtsSkI0iWtWlq/TrS7qYROOVawYkVQ2IITKeFt2mVghhp40PLWkwQDol" +
       "yrGEgV6Su+nUZXtrrkMq/LyM0VIoCWnP3JRFOiwqfqmYmnNi5PMOrBXNMVap" +
       "RqTN9VHV8V0OjW2EktYtpVqbskOFID0UL7stbupTKmEFbMEbF9MASTQFS4iw" +
       "M0wMqQmra7rn0vXh0KQwZO74dVpG6/EwCiyejIW0ohatmipaslquaVp1GBki" +
       "LTfJlhDqsh4kVnPVdyrCULL7HZKw2E3THfYxUpcmyx7FOJsawk3UWsWkqu1l" +
       "B7cklJYtskBFjidRxXrbx2tFpqUmCDmk2fpGxmhqbY57pL9uoS7XwLtEL+Dj" +
       "7srhYZTEesvqsB6hLceqcxE+HCpRN6ZjssnU6kEZKbCjsd8zWpQT9Zh620Rb" +
       "A5VqWe0FgTfNKKB6Y8mqsZhH0nRakJxIKCFyHW8iS7lL9qqsUNGtRkRjTuK0" +
       "kXKzL2DVxFiX2QnmIBIed7GFQNdiWSRrfRaXqrCx5uZ2XWlVugFFo+R0xc6j" +
       "cnVICaazxNahaQwFaZg2EKC6FA8+ceT+RsUnJVbG2upgyQucm9rtWr+4YXoo" +
       "wcqcKHokgsMDvyuoymQszLwuuTJGwmxeWLEcSxZZw0IFPloa4mDAuRTRWLct" +
       "bLPSm5uRrqpBOU0Eg2sx7ZC0xn3YUdqCG3ZlLpxJHbHDVNuDJhduWgVDSWHF" +
       "brP9eTQ3kgXjpuNiU1stg2aBIDkp7HZJLFqvqmY7bCxHU5om2vVoOsXa2Iwa" +
       "yf6SWVRExcJK9Um1Vi1iXHlA9qkh1u+mVa6oIXBABM20YhPlKd6fNP2umDaF" +
       "gVYfLoBW0BPfpOoMT4s8b/NawyKlpamKQXnKD3TE7IkJPYtshWotYlwVauXh" +
       "Ml1wMCtMOiyKj8eoHjsm5mmrxqSqMEY8mY9YP1gMJkhCtDvrQb1SXctAznxK" +
       "CBVBdpyeUygnfHWqc90+tvaoeKGitVA3+MhBhRnfaUVli/LbrphsqARjUdot" +
       "Mfh8VLCjyjLWRc/rjZyaW6Ta4VItGAZG0D0rtCooOhlFJb3VgCWR9pZhnRnC" +
       "ISGrnKJvzErMs7GaqAKD16J5qcorFDcu81pvNZzZwTAYBBzHd6WASlXE5ZRu" +
       "xawwXVZZRdMmVtgomlbwx+O5GEkixc0lVtJ6glVA+qncmODVsRkI5TpWX1dN" +
       "m8EFu7QIRtxipHmmb1smX+ySgicparnCzFV8rTSovthX5l2XohYTh3WMpd2m" +
       "lGEwdYYElbo+I6Gsr1Wtgc6PdbqXMmu+UtH7ROQXmjrN+7hFt5C5HZFzy8Bq" +
       "/WSWCkFnZQ7klqHNy/Up4iZlst/0FwUWNW1s3Yhsp2d0uiuzumiN+ZIklYWu" +
       "vuFrBb9Eezordmfdeivh0Elk6UibnMwIo1n21uvSgGnPZU3zTWulmau4EvbK" +
       "dIFn2rwdd8EcJkZRKibdaRL02abgbszaIiHSussFUZ8e2MMB0m+lMTKNl/Vm" +
       "tZlEbWRckWU2sGCk3lslw0W74pQMozOu+HFE+WE678emSBVUtV6G1YqWTMSW" +
       "SEW9nssvymzDaA8StoTARKjKhWZTk0fdogvm1pFE1XJaBdWRg66Fr2ujxWJe" +
       "FRWG1yUR2KmNomzZbRS9Dt8aKeZKKi6CegmpzezqZlNrNleyz7nAAVFScenz" +
       "Xbjj8qWImLmbQtmD5ZbkdOeROx1XQwa3mBqBw+tetHIqjUW/IctTzEXc3tSL" +
       "cVQZrAe1slOxRCcdLTk0wKtIb12x2XQh2yIr9pEFS3ZpB4MHmoaSCemVijO1" +
       "RWi1WU1bB3Um3mzwqsuLrbk3CrR1q1mDpakaFOfEkJwkyZQelEhqPkFRkRvP" +
       "7RBZrzq1Pp8MtQ3caYmNAe5wC3nVLIWlMTYcV6Vxi6xOU4qbimyf00qB3jPd" +
       "4sYCGtyb18ykvdH1FVyYuksQKddBb0qFtXVYR01jTfh9w6M6GDJE8F5lOlf7" +
       "m1KZqutxgLpBmVs2paRlN/otze/EcFxcqHwrqhZmg16J3FQdZ7M0SGAzRqfK" +
       "GvBqkxQEY0HEUa/YaK5mNWQ5n3R4ruwRC1dS5/pkyco+G5kONqU7KNz3hzzK" +
       "Y0mDWeBEl9tYGOmudZEm4m6n1SdB8Cl3Rd3mzY6z8BqBgNuurUaMTrUTWCRd" +
       "fr4cJbVxkyRHoefPBDUJab9GF6pFaVOZz5YdlFFWioJMm+WwDze6Q7SCjlhh" +
       "Hc8YDNit0kEFC0MCuUlput4L6M1CCzhi2C/RljOerjyDLlmt+WhcnaedkdGU" +
       "p/Wq0PK5dLKE0aE0WFeU0CkOrSmfJqvSSoiIRdpolqkN8KQjWNR1DDhmy2Qn" +
       "K6pCjQTRc8SwV1Qa7qgEFyoOHMNA5ciJTZNKZZRIMdIYiU0VJnW4RDuK3y3g" +
       "cHvaZqpoIcQ6jXoYawI8LyAWGfIroioKoxI6KNRXS7Mwbbh2U2y4HM+3isam" +
       "YkpWuWZrCZ0kaLc8qCBjv0hwWCkkqYW81lZFv6o5fUFkmdnIpLwiqi01xdQG" +
       "RXvT5hN1ZhK+0Z5RrVY3HicrgUTQSrhJxmOFcIqoQ63GXn1ak/R+G+5XRr7f" +
       "8sNgEiFlEtejRjtFmiVbmwuhbYfRsNxqIVRPiXpNvCsEjSRZKnJSUxXaoskh" +
       "0q1wqVda1Gp1iyJL68GkhLWGeEetOxLSSWVuOEIMEJSmCDxozbuYPV7WizzK" +
       "TIkNHDJLO45pbrZcyBwidNR1cRMR0pAiO35vORJCc0x5Tg+YwoxKg7hAUQzw" +
       "gBN+KVlp4JaFlMcK/TClSWS4jiozSZtIDtwo683QTjahK+jFlenMfS7G605a" +
       "bcxixF8vSnhxViIW6yAohNRgOukiy4CUiOaiR/etcFhFAoZsYOMgdlemv/SD" +
       "qm+rNonacInD7SlWJEPcdNUuQZUHSRULyXCRBpqgUyTShDF+NRk3yLCNzySw" +
       "il2PJWnVl/X+fKX2JlUSxHEaS/XAk4bLTg8s+COnPhaVeFFPdawBPIuKtjdU" +
       "OuO6DUSueIjETFljKvS6FpMuN+q8Qav9Hox5A7NDb1xpUiqTbFURZmjRLcm0" +
       "48fBsMw3x+uwy8bN3lihGcsekzgliK1Ogwv7ynSxqm6EZSOddhoVtWGPUwn1" +
       "hTkntcchtllwMYPxveWwGzYH3mZuDeCuZVsp1qOLjSEtRoqaaAOOl8KSRDWC" +
       "LiOmsuxVOkjMN4cqyvUDozIn4qGtOUtuYuCj/ojvC6Q7COCppbViubucphvZ" +
       "jqemxHT9UqKEsWjyVQKtMkqH4MUeqVnzTkMIUX5QquAlqYprEpvChFOo0XGh" +
       "WqJtrZGWS5QgmWq32bEKk2U95Gohv0z9JtOuLePUMVN1lGrVJT+SXMdj+BSr" +
       "rNaxPigrTntJicxcVhSwrpmlveES67XwuhCIi+ma7kQG1u5UaDImeb+BVTSE" +
       "lqwmjwLvXFmIdbvkLyVuA2wKbjAwi1OswUtdQpwkfrU6bTY4HiawrsZEqUDD" +
       "emLLhcEgmBYXRbFp46tOa1xkKLPcaqYBIXm03CVaWmS1J4WOhzPjiYIue6y9" +
       "LrQLScMqBo2KLIVsmx/Y+ny8YCqE1xsIWCmd6uzMYAasW1eIdqSjTlsnfRwT" +
       "O/NaWZuo8IbyYqYnmV3baYyNQZQ0bbQW1MdcH5vMK7YnDFUdY7yxKmCFEbwY" +
       "u3aZ7lFOrQFrerXZCHGhqLkrRFjYkieRNqIhvoI3OGG87C/LcocLC/I0tVJ3" +
       "GIOl0KjDhIVwDcKfGs779sIbxKQ5rti0VLB7jZlgYhskrSHFElHsI7FHWsO2" +
       "tlF9DikJkwBtISPT2lQ3o0GR1IZ0WI4xRqOnQStopAUYS9nJiCp1iWGDcu0R" +
       "g0xhZt3XaTpq6/gGq6w7M28zXvBN2JmaqS07wAV2fLTHSSNMbLV9VvC4VTAK" +
       "Ro7hFhZrs1hZLjcezxGlQhmIrgxHXAxbNZymGpoYq8Cpt5ecLKLO2ofTXjBi" +
       "ZyU6CVCjzRRIDRcrTXLuLkB9UzLpGUGu6qU2q9pxx2+OGBdvzfmK05lWSnEA" +
       "Jx0GfNSXR1z2of3yfF9y+fS2Bm7Od0GOTkxNu55VyE/j6z+98oB7+YARdF6e" +
       "hVEgK9Fu7z7/XYBOHcEd37vfbTNC2UboXU92Sprv+b7n9Q8/qtLvLe0dbM82" +
       "I+j6yPN/0tZizT5G6jyg9MCT71iS+SHxbtvwU6//lzv4Vyxe8zROnl5wis/T" +
       "JH+XfOwzvRcrv7YHXXO0ifiE4+uTnR48uXV4Q6BFq8DlT2wg3nUk2dsPNw3L" +
       "B5Itn96t203slbfqXrVVjKvsfr/5KnVvyZJfBJM+1yL6aPdxp0dveKpdpOME" +
       "84LXHWG7NSu8AzwvPcD20h89tkeuUveOLHnbqT3MHbRffQbQnpUV3gme9gG0" +
       "9o8e2m9epe63suRdUXbHwojyGx7aFfcFY89Qd4jf/UwRZ9vK+AFi/EeP+ENX" +
       "qftwlvxeBN2oajvMWdl7d/geewb4ssmEXgIe9gAf+zTw7R356s1Tgvyjq9R9" +
       "Iks+GkEXjbAba27U9lz16NT2mOp+7BkAvSErzK5TTA+ATp8GUOiK8M4cXBbI" +
       "/t8WQfdd9cBzkN0Kig929T99FWF8Lks+GUHPcrXksNOVlPysbntytBPOnzxT" +
       "4WQ+WT4QjvyjEk729zN5gy9dBfPfZskXI+imQHO8WDuEnZV+fofwL54pwsyO" +
       "rQOE1jNG+LTOuw/DZHbuncPKSf7TVWTy9Sz5agQ9ZyG7qp13nMmhJviqHGmn" +
       "JPP3T0cyaQRdOHU/Jjvpv/0J9/C2d8eUDzx64fzzHhX+Kr8icnS/63oCOq+v" +
       "bPv4ceGx/Dk/0HQjB3L99vDQz1/fiqA7ryaoCDq3zeRs/9u2079H0G1X7ARc" +
       "ffY63vY7wI2cbguMJX8fb/ffIIrs2oFht5njTb4XQdeAJln2+/4VTtu2x6zp" +
       "mZOrwKNJueWpJuXYwvFFJ5Z7+cXJw6XZant18rLywUdx6me/XXvv9sqLYsub" +
       "TUblPAFdt719c7S8u/dJqR3SOte//7s3fej6+w6XojdtGd7ZwDHeXnDlyyVd" +
       "x4/y6yCbjz3vD172249+OT/8+z+k/bVt0SoAAA==");
}
