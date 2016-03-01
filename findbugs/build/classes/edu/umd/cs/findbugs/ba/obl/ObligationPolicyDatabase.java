package edu.umd.cs.findbugs.ba.obl;
public class ObligationPolicyDatabase {
    public static final boolean DEBUG = edu.umd.cs.findbugs.SystemProperties.
      getBoolean(
        "oa.debug.db");
    private final edu.umd.cs.findbugs.ba.obl.ObligationFactory factory;
    private final java.util.LinkedList<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry>
      entryList;
    private final java.util.HashSet<edu.umd.cs.findbugs.ba.obl.Obligation>
      allObligations =
      new java.util.HashSet<edu.umd.cs.findbugs.ba.obl.Obligation>(
      );
    private boolean strictChecking;
    public ObligationPolicyDatabase() { super();
                                        this.factory = new edu.umd.cs.findbugs.ba.obl.ObligationFactory(
                                                         );
                                        this.entryList = new java.util.LinkedList<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry>(
                                                           );
    }
    public edu.umd.cs.findbugs.ba.obl.ObligationFactory getFactory() {
        return factory;
    }
    public java.util.Set<edu.umd.cs.findbugs.ba.obl.Obligation> getAllObligations() {
        return allObligations;
    }
    public void addEntry(edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Adding entry " +
                entry);
        }
        allObligations.
          addAll(
            entry.
              getAllObligations(
                ));
        entryList.
          add(
            entry);
    }
    public edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry addParameterDeletesObligationDatabaseEntry(edu.umd.cs.findbugs.ba.XMethod xmethod,
                                                                                                               edu.umd.cs.findbugs.ba.obl.Obligation obligation,
                                                                                                               edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntryType entryType) {
        edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry =
          new edu.umd.cs.findbugs.ba.obl.MatchMethodEntry(
          xmethod,
          edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseActionType.
            DEL,
          entryType,
          obligation);
        addEntry(
          entry);
        return entry;
    }
    public void setStrictChecking(boolean strictChecking) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Setting strict checking to " +
                strictChecking);
        }
        this.
          strictChecking =
          strictChecking;
    }
    public boolean isStrictChecking() { return strictChecking;
    }
    public void getActions(org.apache.bcel.generic.ReferenceType receiverType,
                           java.lang.String methodName,
                           java.lang.String signature,
                           boolean isStatic,
                           java.util.Collection<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseAction> actionList) {
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "Lookup for " +
                receiverType +
                "," +
                methodName +
                "," +
                signature +
                "," +
                isStatic +
                ": ");
        }
        for (edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry entry
              :
              entryList) {
            boolean matched =
              entry.
              getActions(
                receiverType,
                methodName,
                signature,
                isStatic,
                actionList);
            if (DEBUG) {
                if (matched) {
                    java.lang.System.
                      out.
                      println(
                        " Entry " +
                        entry +
                        "  ==> MATCH");
                }
            }
        }
        if (DEBUG) {
            java.lang.System.
              out.
              println(
                "  ** Resulting action list: " +
                actionList);
        }
    }
    public java.util.List<edu.umd.cs.findbugs.ba.obl.ObligationPolicyDatabaseEntry> getEntries() {
        return java.util.Collections.
          unmodifiableList(
            entryList);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "EZ++/1+gcRqvcCwAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "BLYubfCm5i7R3rYzHo426zXrxC3SGcsT");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("mgoFjsGxLlmThWYzpkRvOueSIHdbQ9Gko3WbiNtgQ1JvDpFImEZ9S8Q0Wm1B" +
       "K1/BIQfSIWW82ZJCVU9wSfezUcbtkE6CtEQswJCdvnChXQFO8GxkeJNJh8OH" +
       "Or/tz6obe6KzAbnKwPonZPXpitmxOQurreaQmmd1ru2PBj4tNzxtMGYJCx1h" +
       "ghd6tXXVNwS/Q+sUmu4oZtsjOulSb3aSHZ26ZquX4LQMQXANMtTpNlHbKUEQ" +
       "73538WrsH7y8V3aPlG8nT67tbWysqPjVl/FWbl/1TJG89eRVbvm5p3LhqteZ" +
       "V7nnXhmHQeWpy27jlYeyn/nwCy+uxp+tXTl6v8xGlfsjz3+nrSWafeGmwR3O" +
       "BNnyMuLpcf+XPvxnTwrvWb//ZVxieuMFOi8O+ffZz32l+6Pq375Suevk8P+W" +
       "a5LnOz134aQo0KI4cIVzB/9PnUj2qUJiPwaedx9J9t0XX5Kf6u72b8jfttf9" +
       "HW6tfOkOdV8pkn8ZVR4wtOjM+fD81Fh++we9wj07ZFnwz0+4+5FjWyGOuCNe" +
       "fe7+/R3q/kOR/D5wC8Ad8cMc9Tx27krWLcc8rzk95jk64vnaq3LEc8m0Rbfy" +
       "eOdrZ493ivTjF05tTtX3b1+B+h48Nkj6SH30q6O+g9MGHygbfOsOOvx2kfy3" +
       "qHKfslqVB4q3PXtIPHN1yvSfvAKmny0Ki6s48yOm568O03ftgfvYdJ6+5DBu" +
       "vkeTUqnHbd/1w569FqhTEvMXlwv4oOTtu1Hl7UDAJTpqkRZQmg2+wtPRz41b" +
       "au5U3N97pTbWAs/ySNzLV93GBiWbD9xBBA8VyVWAE6EW8becM/6PE04P7nkF" +
       "nD5WFBbnoeYRp+arw+lZRh6/Q90TRfJIVLluhrfyODjl8dFXqk0SPO4Rj86r" +
       "w+PVssHVk5NsLzAOFV9R19rhUtXsQ6O4vGaq5y/wF41/9SQZvETIf/J2N0rv" +
       "dHHntFUhvbe9KgvAnYk4XgcO3na7Y/7WD4EWhHqbo//Sat58B4tqFMlT++Bh" +
       "P0J4wV+efgW2BB8jw88d2dLPvfr+8p471BVH5getPXcF6pnaS40aXnv+v0y3" +
       "GM/DZ299lRerjm7gvFKzuWziE4OhLwYOH7gscDj48ZejuiyqPHGZbRV3sZ+4" +
       "5T9U+//9qL/x4rX7Xv+i+J/KG/wn/825f1i5T49t++zV2TP5e/xA082S/vv3" +
       "F2lLFg944DiXG39UuQukBekH0317Kao8fvv2UeXKUjnbdAGCsts0BWHJcfZs" +
       "6/cBqzltDQZTz1XfjCr3HlUDokB6tnIJikBlkVX9vaIOLontfiBSn9mRveXS" +
       "G39svP/v20318y8yow98B/3s/m8JwHh2u2KU+4aVe/f/kDjZNz1z6WjHY93T" +
       "e/b7D//m/W893uM9vCf41GXP0PbG2/8HgHb8qLwauvsnr/9H7/q7L369vNDy" +
       "/wBBt46ikjgAAA==");
}
