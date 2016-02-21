package org.sunflow.core.filter;
public class MitchellFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return mitchell(x) * mitchell(y);
    }
    private float mitchell(float x) { final float B = 1 / 3.0F;
                                      final float C = 1 / 3.0F;
                                      final float SIXTH = 1 / 6.0F;
                                      x = java.lang.Math.abs(x);
                                      float x2 = x * x;
                                      if (x > 1.0F) return ((-B - 6 * C) *
                                                              x *
                                                              x2 +
                                                              (6 *
                                                                 B +
                                                                 30 *
                                                                 C) *
                                                              x2 +
                                                              (-12 *
                                                                 B -
                                                                 48 *
                                                                 C) *
                                                              x +
                                                              (8 *
                                                                 B +
                                                                 24 *
                                                                 C)) * SIXTH;
                                      return ((12 - 9 * B - 6 * C) * x * x2 +
                                                (-18 +
                                                   12 *
                                                   B +
                                                   6 *
                                                   C) *
                                                x2 +
                                                (6 -
                                                   2 *
                                                   B)) * SIXTH; }
    public MitchellFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1447328137000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ye2wcRxmfO78f8TO20zRxEteJcB63LWmLikNJ4tq1w9kx" +
                                                              "dmqBU3IZ783ZG+/tbnbn7LOLS1qpjanUKIDbphX1X64oqG0qRAUStDJCoq1a" +
                                                              "kFoqSkG0ICERHhENSEUiQPm+mb3bx9lXIiROurm9mW/me/3mN9/sM5dJmWOT" +
                                                              "dmbwGJ+zmBPrNfgwtR2W7NGp4xyDvoT6WAn924lLQ7dFSfk4qZuizqBKHdan" +
                                                              "MT3pjJOtmuFwaqjMGWIsiTOGbeYwe4ZyzTTGSYvmDKQtXVM1PmgmGQqMUTtO" +
                                                              "GinntjaR4WzAXYCTrXGwRBGWKIfCw91xUqua1pwnvskn3uMbQcm0p8vhpCF+" +
                                                              "is5QJcM1XYlrDu/O2mSPZepzk7rJYyzLY6f0W9wQHInfUhCCjufrP7h6fqpB" +
                                                              "hKCZGobJhXvOCHNMfYYl46Te6+3VWdo5Te4lJXFS4xPmpDOeU6qAUgWU5rz1" +
                                                              "pMD6DczIpHtM4Q7PrVRuqWgQJzuCi1jUpml3mWFhM6xQyV3fxWTwdnveW+ll" +
                                                              "gYuP7FGWHjvR8O0SUj9O6jVjFM1RwQgOSsYhoCw9wWznUDLJkuOk0YBkjzJb" +
                                                              "o7o272a6ydEmDcozkP5cWLAzYzFb6PRiBXkE3+yMyk07715KAMr9V5bS6ST4" +
                                                              "2ur5Kj3sw35wsFoDw+wUBdy5U0qnNSPJybbwjLyPnZ8BAZhakWZ8ysyrKjUo" +
                                                              "dJAmCRGdGpPKKEDPmATRMhMAaHOyed1FMdYWVafpJEsgIkNyw3IIpKpEIHAK" +
                                                              "Jy1hMbESZGlzKEu+/FweOnDuHqPfiJII2Jxkqo7218Ck9tCkEZZiNoN9ICfW" +
                                                              "7o4/SltfXIwSAsItIWEp890vXjm4t331FSlz/RoyRydOMZUn1JWJuje29HTd" +
                                                              "VoJmVFqmo2HyA56LXTbsjnRnLWCY1vyKOBjLDa6O/PjzZ77F/hQl1QOkXDX1" +
                                                              "TBpw1KiaaUvTmX0nM5hNOUsOkCpmJHvE+ACpgOe4ZjDZezSVchgfIKW66Co3" +
                                                              "xX8IUQqWwBBVw7NmpMzcs0X5lHjOWoSQCviSffAtI/IjfjmhypSZZgpVqaEZ" +
                                                              "pjJsm+g/JtRIUoUzB56TMGqZipMxUro5qzi2qpj2ZP6/atpMASsAQcqgxtUp" +
                                                              "put94m8MoWb9P5Rk0dPm2UgEkrAlTAE67J5+U08yO6EuZQ73Xnku8ZqEF24J" +
                                                              "N0ac7AJ9MVdfDPXFpL5YUB+JRISajahX5hmyNA37HQi3tmv0C0dOLnaUAMCs" +
                                                              "2VIIMYp2BA6eHo8UckyeUP965Lf7+xc++bMoiQJvTMDB4/H/dh//48FlmypL" +
                                                              "Av2sdw7kuFBZn/nXtIGsXpi9b+xLNwob/ISOC5YBF+H0YaThvIrO8EZea936" +
                                                              "s5c+uPjogult6cAJkTvYCmYiU3SEkxl2PqHu3k5fSLy40BklpUA/QLmcwhYB" +
                                                              "NmsP6wgwRneOfdGXSnA4ZdppquNQjjKr+ZRtzno9AmWN2LRIwCEMQgYK4v7U" +
                                                              "qPXkL376h/0ikjmOr/cdzqOMd/t4BRdrEgzS6KHqmM0YyP36wvDXHrl89riA" +
                                                              "FEjcsJbCTmx7gE8gOxDBB145/c577668FfVgyOFgzUxAfZIVvmz8ED4R+P4b" +
                                                              "v8gF2CE5oanHJabteWayUPMuzzbgKB22MIKj8y4DwKelNDqhM9wD/6zfedML" +
                                                              "fz7XINOtQ08OLXs/egGv/7rD5MxrJ/7eLpaJqHhGevHzxCTxNnsrH7JtOod2" +
                                                              "ZO97c+vjL9MngcKBNh1tngkmJCIeRCTwZhELRbT7Q2O3YtPp+DEe3Ea+Wiah" +
                                                              "nn/r/Q1j7790RVgbLIb8eR+kVrdEkcwCKIsRtwkwM462Wti2ZcGGtjDZ9FNn" +
                                                              "Cha7eXXo7gZ99SqoHQe1KpQJzlEbmC4bgJIrXVbxyx/+qPXkGyUk2keqdZMm" +
                                                              "+6jYcKQKkM6cKSDJrPXpg9KO2UpoGkQ8SEGEMOjb1k5nb9riIgHz32v7zoFv" +
                                                              "LL8rUChhd707XfzZKdqPYbNHghQf92bzoRGf8iKh8a0ZEc+bOGkroHHJ2xjG" +
                                                              "revVHaJmWrl/aTl59KmbZHXQFDzLe6FUffbn/3o9duE3r65xeFRx09qnsxmm" +
                                                              "+2wqQZUB7h8UJZnHXdUP3tgc59lUIe3jKu3rEPvu9Yk9rODl+/+4+djtUyev" +
                                                              "gdO3hYIUXvKbg8+8eucu9atRUVVKOi+oRoOTuv3hAqU2g/LZQLewZ4PYER35" +
                                                              "tDdilje5qc9BILAjJPkKDGHTk58q0FVdZGqRDT9WZOxz2HyWk4pJxkeBSYKH" +
                                                              "Ol74RjMTDhzNWhoIfcYtST8+fFJd7Bz+nQTUdWtMkHItTysPj7196nWRpEpE" +
                                                              "QT40PgQcsid9x1ADNvsQ1F1FLnhBe5SFpvemv37pWWlPuJ4OCbPFpYc+jJ1b" +
                                                              "kmCXl44bCup+/xx58QhZt6OYFjGj7/cXF77/9MLZqBvrAY5Hpkl5PhORfCW1" +
                                                              "MRhDaekdX67/wfmmkj4oAAZIZcbQTmfYQDIIuQonM+ELqndL8QDo2oznICeR" +
                                                              "3ZZLWZ/AZkQ+d/933IgdB0X3YBDUG1105lB6jaBeb2oIuFFhRxT/3i0asbRV" +
                                                              "BN42NtOclAC8xQzPc/1/9rwJhzbDt841v66I5wVHAuw5y9ZmoAjJBgNSU2TF" +
                                                              "kKsR73SRsbi3SCzOYDPLSWXaLftDAclee0CynNQFLxF4fG4qeFUhr9fqc8v1" +
                                                              "lW3Ld70tCtr8FbgWqCGV0XUfqP0AL7dsltKEB7WywrDEz9m1TkR5seH4MgIf" +
                                                              "hNkPSvmHOGkIy3NSij9+sYc5qfGJcdxg4skvdB4QBUL4+BUrdz43iKoB3z/E" +
                                                              "5GU7GyksDUSkWz4q0vkp/qoYSVC8K8rxREa+LUqoF5ePDN1z5danZFWu6nR+" +
                                                              "HlepAXaQtX/+CNyx7mq5tcr7u67WPV+1M0dagVuB3zYBAACfqKA3h8pUpzNf" +
                                                              "rb6zcuClnyyWvwl0e5xEKCfNx31vamSkoNbNQEVxPF7IglAeiPq5u+uJudv3" +
                                                              "pv7yK1F0uay5ZX35hFr1j3PzO5xILEqqBkgZ8DHLjpNqzbljzhhh6owdoNTy" +
                                                              "CTNj5F8p1SE2Kb5DElFxg7kh34uXNU46Cg+NwgssVKOzzD6Mq7sUHSgYMpbl" +
                                                              "HxVRZZKvMcqAs0R80LJydxi57SxL/K5gk/oPz4UJ5gQWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1447328137000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "lg98JC+vZ8XPbLWeVV8PIjbMU0kwQjUcwcrneSwCHmNJ1/djdApSS6Di60sL" +
       "y6d5FUimc+/IhNnd5mNbrMpKZMtFXq++qDfc2OcVWP/y4WSUC1K7D/3jk1//" +
       "ldd8G5ioB51dZeoDljmy4iDOst1ffvajD7zsqe98KAcggD7sC+kfvz6btX8n" +
       "ibOilRXtfVHvz0Qdu3EgKZQQRnSOE4qcS3tHz2QDwwbQutpL5eAnrn3b/MR3" +
       "P7tN00664Qli5QNPffBHux9+audIcvyaW/LTo2O2CXLO9Mv3NBxAj9xplXwE" +
       "8U+ff+IPf/uJ92+5unY81WuDncxn/+q/v7779He+epvc4ozl/gSGje56vFsJ" +
       "ycb+jyotlPJaGiW2ymA1tTZhysV0lLQjpSc1qwg1synDHPQqkV9a181Etv0m" +
       "h5A8VkP4TgGOREd0MIqhxiXfWwoO1ydboqfPS/NqxfU7RX/U4MZRq4e7fkkw" +
       "Cdcfm50iibdHXb09GLc5Y8jaBVtExKRuzUljxMSBXbdnMMjwEHtQh0MalXv2" +
       "jJnItrju9Aqp3WSDgaqto1F5hg06XiXZtFbupDprOPVyxaKGmEyMVbPi87GR" +
       "+s1+VxYceoJ4yx4T2TGxFvwl3ZmRoTFhOqKyWCsVfpNOJp3xYmW3+sNoPqVL" +
       "rK3ZnaFPc5OI6RiOEy2FUWWWNuYLfBLMO+tRszPrkyq+rpcSzo+Fkrd2VqHp" +
       "IDEtDiW76NVWuocTBSNEhz2JLs0XVtCKYaZsj1le8VITC3qLTUotqmpxVl8P" +
       "u6SjcjqOL2M1YDG9qvpeU+/jfMcVe/p8xeDdAa0uFlalOlGqBWQ6k110olSs" +
       "3pwYVxLW9lqMwlX9BqfNODRISx7dqraklPS6EV0ZYmwwHcX+TBv20hg3SkvO" +
       "sy3EnhE6XU2GmymiJrPJWnZWyqxgWdoiZjGiM+suV6MaUxxzyzpTXU6XBF0a" +
       "rYcaMw4XugskX89Sh2tRPTNmzOKiaS7TnuhibhkrC9WN3LZbkpuaLCrNqEa6" +
       "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" +
       "e/NvPfOt/DTzfwG07uAkEyEAAA==");
}
