package edu.umd.cs.findbugs.filter;
public class LocalMatcher implements edu.umd.cs.findbugs.filter.Matcher {
    private final edu.umd.cs.findbugs.filter.NameMatch name;
    public LocalMatcher(java.lang.String name) { super();
                                                 this.name = new edu.umd.cs.findbugs.filter.NameMatch(
                                                               name);
    }
    public LocalMatcher(java.lang.String name, java.lang.String type) {
        super(
          );
        this.
          name =
          new edu.umd.cs.findbugs.filter.NameMatch(
            name);
    }
    @java.lang.Override
    public java.lang.String toString() { return "Local(name=" + name +
                                         ")"; }
    @java.lang.Override
    public boolean match(edu.umd.cs.findbugs.BugInstance bugInstance) {
        edu.umd.cs.findbugs.LocalVariableAnnotation localAnnotation =
          bugInstance.
          getPrimaryLocalVariableAnnotation(
            );
        if (localAnnotation ==
              null) {
            return false;
        }
        if (!name.
              match(
                localAnnotation.
                  getName(
                    ))) {
            return false;
        }
        return true;
    }
    @java.lang.Override
    public void writeXML(edu.umd.cs.findbugs.xml.XMLOutput xmlOutput,
                         boolean disabled) throws java.io.IOException {
        edu.umd.cs.findbugs.xml.XMLAttributeList attributes =
          new edu.umd.cs.findbugs.xml.XMLAttributeList(
          ).
          addAttribute(
            "name",
            name.
              getSpec(
                ));
        if (disabled) {
            attributes.
              addAttribute(
                "disabled",
                "true");
        }
        xmlOutput.
          openCloseTag(
            "Local",
            attributes);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1ZfWwUxxWfu8OfGPzBZww22BxEBnIX0pAKTAhg7GBy/hAm" +
                                                              "NDUtx9zenL14b3fZnbXPTt0mVBVu1SISCNCW8E+JkiAIqGrUjzSIKG0hSlop" +
                                                              "adokTUOqtlJpU9SgqklV2qZvZvZuP+6DpkqKtHPjmfdm5r157/feG05fRWWm" +
                                                              "gZqJSiN0XCdmpFOl/dgwSbJDwaa5Hcbi0tEQ/uuuK71rgqh8EM0cxmaPhE3S" +
                                                              "JRMlaQ6iJlk1KVYlYvYSkmQc/QYxiTGKqaypg2iObHandUWWZNqjJQkj2IGN" +
                                                              "GKrHlBpywqKk216AoqYYnCTKTxLd6J9uj6EaSdPHHfL5LvIO1wyjTDt7mRTV" +
                                                              "xfbgURy1qKxEY7JJ2zMGWqFryviQotEIydDIHmW1rYKtsdV5Kmg9V/ve9YPD" +
                                                              "dVwFs7CqapSLZ24jpqaMkmQM1TqjnQpJm3vR51Eohqa7iCkKx7KbRmHTKGya" +
                                                              "ldahgtPPIKqV7tC4ODS7UrkusQNR1OJdRMcGTtvL9PMzwwqV1JadM4O0i3PS" +
                                                              "CinzRHxkRfTw0V113w6h2kFUK6sD7DgSHILCJoOgUJJOEMPcmEyS5CCqV+Gy" +
                                                              "B4ghY0WesG+6wZSHVEwtuP6sWtigpROD7+noCu4RZDMsiWpGTrwUNyj7r7KU" +
                                                              "godA1rmOrELCLjYOAlbLcDAjhcHubJZpI7KapGiRnyMnY/geIADWijShw1pu" +
                                                              "q2kqhgHUIExEwepQdABMTx0C0jINDNCgqLHookzXOpZG8BCJM4v00fWLKaCq" +
                                                              "4opgLBTN8ZPxleCWGn235Lqfq73rDtyvblGDKABnThJJYeefDkzNPqZtJEUM" +
                                                              "An4gGGuWx47guc9OBREC4jk+YkHz3c9d27Cy+cIlQbOgAE1fYg+RaFw6mZj5" +
                                                              "8sKOtjUhdoxKXTNldvkeybmX9dsz7RkdEGZubkU2GclOXtj2k08/cIq8E0TV" +
                                                              "3ahc0hQrDXZUL2lpXVaIcTdRiYEpSXajKqImO/h8N6qAfkxWiRjtS6VMQrvR" +
                                                              "NIUPlWv8b1BRCpZgKqqGvqymtGxfx3SY9zM6QqgCPrQSviYk/vFfinZFh7U0" +
                                                              "iWIJq7KqRfsNjclvRgFxEqDb4WgKjClhDZlR05Ci3HRI0opa6WRUMp1JOAQY" +
                                                              "UDSmSVjpwVQaJkaEEesf+w4ZJuOssUAA1L/Q7/wK+M0WTUkSIy4dtjZ1Xnsq" +
                                                              "/qIwLOYMtnYouhk2jMCGEcmMZDeMiA0j7g1RIMD3mc02FlcMFzQCrg5YW9M2" +
                                                              "8Nmtu6daQ2Bb+tg00G4QSFs9MafDwYMsiMelsw0zJlour3o+iKbFUAOWqAUb" +
                                                              "AqxvNIYAnKQR239rEhCNnKCw2BUUWDQzNAmkMEix4GCvUqmNEoONUzTbtUI2" +
                                                              "ZDHnjBYPGAXPjy4cG3twxxduDaKgNw6wLcsAwhh7P0PvHEqH/f5faN3a/Vfe" +
                                                              "O3tkUnOQwBNYsvEwj5PJ0Oq3BL964tLyxfjp+LOTYa72KkBqisGzAASb/Xt4" +
                                                              "gKY9C9pMlkoQOKUZaaywqayOq+mwoY05I9xE63l/NpjFdOZ58+BbbLsi/2Wz" +
                                                              "c3XWzhMmzezMJwUPCncO6I++/rM/foKrOxs/al2Bf4DQdhdmscUaODrVO2a7" +
                                                              "3SAE6N461n/okav7d3KbBYolhTYMs7YDsAquENT8pUt733j78slXgzk7D1AI" +
                                                              "2lYCcp9MTkg2jqpLCAm7LXPOA5inACowqwnfq4J9yikZJxTCHOuftUtXPf3n" +
                                                              "A3XCDhQYyZrRyhsv4IzftAk98OKu95v5MgGJxVxHZw6ZAPJZzsobDQOPs3Nk" +
                                                              "Hnyl6esX8aMQEgCGTXmCcGQNCB1wyedDCsY5WXiNiPDKb3M1n76Vt7czTXAm" +
                                                              "xOfWsGap6fYKr+O5kqa4dPDVd2fsePf8NS6GN+tyG0EP1tuF3bFmWQaWn+dH" +
                                                              "rS3YHAa62y/0fqZOuXAdVhyEFSVINcw+AzAz4zEZm7qs4lfPPT9398shFOxC" +
                                                              "1YqGk12Yex+qArMn5jDAbUa/a4O49bFKaOq4qChP+LwBpvlFhe+0M61TfgsT" +
                                                              "35v3nXWPn7jMzU/nSzTlu1bYtrpwYddi7c2sWZFvsMVYfTcYFBDP/ryDN3zp" +
                                                              "7hL3fA9rNvOptazpFAq483/UFRvo0MXEAtsGIQR64g0vXhzIO/XzT/7i8YeO" +
                                                              "jIn0p604zvv45v+jT0ns++3f82yOI3yB1MzHPxg9fbyxY/07nN+BWsYdzuSH" +
                                                              "bQhXDu9tp9J/C7aW/ziIKgZRnWQXCzuwYjEAG4QE2cxWEFBQeOa9ya7I7Npz" +
                                                              "oWShH+Zd2/pB3kkXoM+oWX+GD9cb2L20wNdsW1Cz3/gCiHc+JeyPt8tZc4uw" +
                                                              "JYoqdEOGghJOXgZ5CFZ8eFpfYnEqDpmFoXCJlKYX6HhG4zgDN8j7ShhkppDP" +
                                                              "8H/lyJdU+n1mgRcgW0uczM6zGFo1FSsReHlzct/hE8m+x1YJS27wpt2dUFWe" +
                                                              "+eW/Xooc+80LBbK9KqrptyhklCiu44XYlh7f6eHVk2OIb818+HffDw9t+jBp" +
                                                              "GhtrvkEixv5eBEIsL+6O/qNc3Penxu3rh3d/iIxrkU+d/iWf7Dn9wt3LpIeD" +
                                                              "vFQUHpJXYnqZ2r1+UW0QqInV7R7vWOL1jkb42mxbaSsBzX7XCLBupEB2UWyx" +
                                                              "EjA8VmJunDV7KaqkmgjeHNkdDzG8HlKT85CcdTc44b8PLtiQk6SEU/33OM/H" +
                                                              "0zkFzGJz8+GL2AqIfBTaLLaYT2O+jGdRIYfeZA1l7YQfZaqE1r/Kmn2AeWnm" +
                                                              "/t6iiXnYgJUwocCR05DPjtrV/m39u6WpcP/vBQDcVIBB0M15Ivq1Ha/teYm7" +
                                                              "SiXzzZyBuvwSfNiVqtcJzXwA/wLw/Zt97LBsgP3CLXfYpfviXO2u6wy1SsRU" +
                                                              "nwDRyYa3R45fOSME8AdQHzGZOvyVDyIHDgs0Ew9AS/LeYNw84hFIiMOah9jp" +
                                                              "Wkrtwjm6/nB28pknJvcH7auRISYlNE0hWM27fqhPvGoXZ9385dofHmwIdQFO" +
                                                              "dqNKS5X3WqQ76cWKCtNKuO7BeTNykMM+NdM5RYHlup3pcDf8YlE3ZMOTH4fD" +
                                                              "8czyLvjW2j6y9qNwuGKLFc41sw7XUsjhMmklcl9PrM+iusULpIP8RE+W9l1R" +
                                                              "58hapLuvMyMRnUURzneGNd8CJBwzZEpgYc5xyDYl9nMUMo5RTU4613Ly/3At" +
                                                              "GYpq3E8yrGSYn/fmK94ppadO1FbOO3Hvazxk594SawAIUpaiuHM6V79cN0hK" +
                                                              "5kqoERmezn+eoaixeOpC2cMu6/CD/0CwnAcFF2ABrWa7burnKKp2qCkKSp7p" +
                                                              "H4Er2tMUhaB1T16EIZhk3Ut6gVJUJL+ZgCvjQS6HmnOjUiTH4n4jYBDHX+Wz" +
                                                              "GGCJd/m4dPbE1t77r93xmHijkBQ8McFWmQ6eL55LcnlJS9HVsmuVb2m7PvNc" +
                                                              "1dIsJNWLAzvutsAVSjrA2HRmE42+At4M5+r4N06uO//TqfJXAEx3ogCGO9qZ" +
                                                              "XyZkdAsSwp2xfISDHI6/LLS3fWN8/crUX97klSjKK7/89FAGHXq9+9zI+xv4" +
                                                              "M3AZWADJ8Ppl87i6jUijhgcuZzJzxSwH4Xqw1TcjN8petCCZzg8C+e+AUKWP" +
                                                              "EWOTZqlJG3CnOyOe/x6wXaDa0nUfgzPiCpTfFHAgYmIoHuvRdTtGhq7o3GGP" +
                                                              "+4GHD3LmN3mXNb/+D2y6ZdagGwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "y373dR995qv5Uf//AogPQOoCJgAA");
}
