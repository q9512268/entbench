package org.apache.batik.anim.timing;
public abstract class EventLikeTimingSpecifier extends org.apache.batik.anim.timing.OffsetTimingSpecifier {
    public EventLikeTimingSpecifier(org.apache.batik.anim.timing.TimedElement owner,
                                    boolean isBegin,
                                    float offset) { super(owner, isBegin,
                                                          offset);
    }
    public boolean isEventCondition() { return true; }
    public abstract void resolve(org.w3c.dom.events.Event e);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAMVYe2wUxxmfO78Pg1/BUB4GjEGygbsCoSg1bQHHDiZn+2QT" +
                                                              "opo2x9zunL14b3fZnbMPJ5QQKYFEFY3ASWlV+Iv0EZEQVY1atQqiatUkSlME" +
                                                              "jdo81KRV/0j6QAr/hFa0Tb9v5vZ2b+98af7qSTs7N/PNN99rft83e/EGqXFs" +
                                                              "0mlRQ6VRfsRiTjSB/QS1Hab26dRx9sFoUnniT2eO3fptw/EwqR0niyapM6RQ" +
                                                              "hw1oTFedcbJSMxxODYU5w4ypuCJhM4fZ05RrpjFOFmvOYMbSNUXjQ6bKkGA/" +
                                                              "teOkhXJua6ksZ4N5BpysigtpYkKa2K4gQW+cNCqmdcRbsKxoQZ9vDmkz3n4O" +
                                                              "J83xQ3SaxrJc02NxzeG9OZtssEz9yIRu8ijL8eghfVveEHvj20rM0PlC00e3" +
                                                              "n5xsFmZoo4ZhcqGiM8ocU59mapw0eaP9Oss4h8nXSFWcLPARc9IVdzeNwaYx" +
                                                              "2NTV16MC6RcyI5vpM4U63OVUaykoECdriplY1KaZPJuEkBk41PO87mIxaLu6" +
                                                              "oK3r7oCKT22IzX3zgeYfVpGmcdKkGWMojgJCcNhkHAzKMilmO7tUlanjpMUA" +
                                                              "h48xW6O6Npv3dqujTRiUZyEEXLPgYNZittjTsxV4EnSzswo37YJ6aRFU+X81" +
                                                              "aZ1OgK7tnq5SwwEcBwUjGghmpynEXn5J9ZRmqCKOilcUdOy6FwhgaV2G8Umz" +
                                                              "sFW1QWGAtMoQ0akxERuD4DMmgLTGhBC0RazNwxRtbVFlik6wJCdLg3QJOQVU" +
                                                              "DcIQuISTxUEywQm8tCzgJZ9/bgzvOPWgsccIkxDIrDJFR/kXwKKOwKJRlmY2" +
                                                              "g3MgFzb2xJ+m7S+dDBMCxIsDxJLmxw/d3Lmx48orkmZ5GZqR1CGm8KRyIbXo" +
                                                              "2oq+7ruqUIx6y3Q0dH6R5uKUJfIzvTkLkKa9wBEno+7kldFfffnhZ9nfwiQy" +
                                                              "SGoVU89mII5aFDNjaTqz72EGsyln6iBpYIbaJ+YHSR3045rB5OhIOu0wPkiq" +
                                                              "dTFUa4r/YKI0sEATRaCvGWnT7VuUT4p+ziKENMNDFsOzksifeHMyHZs0MyxG" +
                                                              "FWpohhlL2Cbqjw4VmMMc6Kswa5mxFMT/1KbN0e0xx8zaEJAx056IUYiKSSYn" +
                                                              "Y8AEjqiWgaiK9U8zg8e1KbZP/B+zmKJB7NtRjD/r/7ZzDm3SNhMKgbtWBMFC" +
                                                              "h3O2x9RVZieVuezu/pvPJ1+TgYiHJ29NTrbB9lG5fVRsH8Xto3L76Hzbk1BI" +
                                                              "7HoHiiEDBNw7BUABSN3YPfbVvQdPdlZBZFoz1eAbJF1fkrn6PERx00BSuXht" +
                                                              "9NbV1yPPhkkYQCcFmctLH11F6UNmP9tUmAr4NV8iccE0Nn/qKCsHuXJ25vj+" +
                                                              "Y58VcvgzAjKsATDD5QnE8cIWXUEkKMe36cQHH116+qjpYUJRinEzY8lKhJrO" +
                                                              "oI+DyieVntX0xeRLR7vCpBrwCzCbUzhjAIcdwT2KIKfXhW/UpR4UTpt2huo4" +
                                                              "5WJuhE/a5ow3IoKvRfTvABcvwDO4Fp7O/KEUb5xtt7BdIoMVYyaghUgPXxiz" +
                                                              "zr35m79sFeZ2M0mTrwQYY7zXh17IrFXgVIsXgvtsxoDuD2cTZ566ceKAiD+g" +
                                                              "WFtuwy5s+wC1wIVg5kdfOfzWe+9eeCPsxSyH9J1NQSWUKyiJ4yRSQUmMc08e" +
                                                              "QD8dcACjpus+A6ISzg5N6QwPyb+a1m1+8e+nmmUc6DDihtHGT2bgjX9mN3n4" +
                                                              "tQdudQg2IQWzr2czj0xCepvHeZdt0yMoR+749ZXfepmeg+QAgOxos0xgbJWw" +
                                                              "QZXQfCkn3RVRAsCBqVhBAVg4eA58Jx2LyLFsyuEJG4i5Np1PcZfabx3+Zd3s" +
                                                              "3W76KrdEUt7rDF396Z73kyI06hERcBwFW+g767vsCV9cNkuXfQy/EDz/wQdd" +
                                                              "hQMyWbT25TPW6kLKsqwcSN9docYsViF2tPW9qe988JxUIZjSA8Ts5NwTH0dP" +
                                                              "zUl/y7pnbUnp4V8jax+pDjafR+nWVNpFrBh4/9LRn33/6AkpVWtxFu+HIvW5" +
                                                              "3/3719Gzf3y1TDKoS5mmzqgEua14CArw3R70kFSrdvO5fx577M0RwJtBUp81" +
                                                              "tMNZNqj6+ULx5mRTPpd5VZUY8CuI7uEk1IOewJHteb3xtcPX38kRI0zKg4Li" +
                                                              "34GcYHmnmIsVKIigIGJuGJsuxw/Zxc721fZJ5ck3Ply4/8PLN4XBii8HfoQa" +
                                                              "opb0Vgs269BbS4LpcQ91JoHuzivDX2nWr9wGjuPAUYEywBmxIVXnivAsT11T" +
                                                              "9/bPf9F+8FoVCQ+QCKitDlCRGkgDYDJzJiHL56wv7ZSQNFPvlkg5UqI8osCq" +
                                                              "8vjSn7G4QITZnyz50Y7vnX9XQKG09/L8cvFnvWi7sdkoxsPY3cRJPYUza4No" +
                                                              "HmCKX1OwVPMDZhF7m6ycr5oWsX3hkbnz6sgzm8N5P+7iYALT2qSzaab7WIXF" +
                                                              "SQnWG0PiDuHlyu3Xb1W9c3ppY2mpgZw65ikkeubHh+AGLz/y12X7vjh58FPU" +
                                                              "EKsC+gdZ/mDo4qv3rFdOh8U1SJYPJden4kW9xacxYjO47xnF56+z4LE2N49v" +
                                                              "yHtsQ/k8LiIBm57S7Djf0goncqrCXAabNCfNmiPqUaiO1EIRcJdYMoLNhIy7" +
                                                              "0f/tJODA/WI4VdBAhGw3PFvyGmypoHz5Y4DNgUDF0FaBY0BvF3DzeXcp5t2Z" +
                                                              "rUpUNTNRhso7siYXguQqGO0hbKDuq7PlFb4chlZPm5rq2c/59PbLgYjz3REQ" +
                                                              "a5aWfMKQ127l+fNN9UvO3/d7UacWrsaNkODTWV33has/dGstm6U1oV6jRFpL" +
                                                              "vB7jZEWlAgUqOdkRWjwqFz0Od/qyi8Au+PLTfh2CL0gLKUi8/XTf4CTi0cG2" +
                                                              "suMnOc1JFZBg94zlunlLxfJKXpcD1s2FSpFZeHHxJ3nRh7Zri7BMfJVycScr" +
                                                              "v0tBoXZ+7/CDNz/3jKzMFZ3OziKXBZDX5SWhgF1r5uXm8qrd03170QsN61z8" +
                                                              "bpECe4dquS+C74dzYGEQLQuUrU5XoXp968KOy6+frL0OifQACVFO2g74vgnJ" +
                                                              "DyBQ+2YBWA/Ey1UwgOyiou6N/Png1X+8HWoVWY/Imqej0oqkcubyO4m0ZX07" +
                                                              "TBoGSQ2kJ5YbJxHNufuIMcqUabuoIKpNmVmj8AFrEUY8xS9WwjJ5gy4sjOLN" +
                                                              "jpPO0vqw9LYLBcEMs3cj93yBVYT2WcvyzwrL9ksYQEtDNCbjQ5blFsYLhOUt" +
                                                              "Sxzv74py6r+FWDfBehYAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
