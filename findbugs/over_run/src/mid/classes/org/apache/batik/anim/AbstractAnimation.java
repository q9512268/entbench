package org.apache.batik.anim;
public abstract class AbstractAnimation {
    public static final short CALC_MODE_DISCRETE = 0;
    public static final short CALC_MODE_LINEAR = 1;
    public static final short CALC_MODE_PACED = 2;
    public static final short CALC_MODE_SPLINE = 3;
    protected org.apache.batik.anim.timing.TimedElement timedElement;
    protected org.apache.batik.dom.anim.AnimatableElement animatableElement;
    protected org.apache.batik.anim.AbstractAnimation lowerAnimation;
    protected org.apache.batik.anim.AbstractAnimation higherAnimation;
    protected boolean isDirty;
    protected boolean isActive;
    protected boolean isFrozen;
    protected float beginTime;
    protected org.apache.batik.anim.values.AnimatableValue value;
    protected org.apache.batik.anim.values.AnimatableValue composedValue;
    protected boolean usesUnderlyingValue;
    protected boolean toAnimation;
    protected AbstractAnimation(org.apache.batik.anim.timing.TimedElement timedElement,
                                org.apache.batik.dom.anim.AnimatableElement animatableElement) {
        super(
          );
        this.
          timedElement =
          timedElement;
        this.
          animatableElement =
          animatableElement;
    }
    public org.apache.batik.anim.timing.TimedElement getTimedElement() {
        return timedElement;
    }
    public org.apache.batik.anim.values.AnimatableValue getValue() {
        if (!isActive &&
              !isFrozen) {
            return null;
        }
        return value;
    }
    public org.apache.batik.anim.values.AnimatableValue getComposedValue() {
        if (!isActive &&
              !isFrozen) {
            return null;
        }
        if (isDirty) {
            org.apache.batik.anim.values.AnimatableValue lowerValue =
              null;
            if (!willReplace(
                   )) {
                if (lowerAnimation ==
                      null) {
                    lowerValue =
                      animatableElement.
                        getUnderlyingValue(
                          );
                    usesUnderlyingValue =
                      true;
                }
                else {
                    lowerValue =
                      lowerAnimation.
                        getComposedValue(
                          );
                    usesUnderlyingValue =
                      false;
                }
            }
            composedValue =
              value.
                interpolate(
                  composedValue,
                  null,
                  0.0F,
                  lowerValue,
                  1);
            isDirty =
              false;
        }
        return composedValue;
    }
    public java.lang.String toString() { return timedElement.
                                           toString(
                                             ); }
    public boolean usesUnderlyingValue() { return usesUnderlyingValue ||
                                             toAnimation;
    }
    protected boolean willReplace() { return true; }
    protected void markDirty() { isDirty = true;
                                 if (higherAnimation != null &&
                                       !higherAnimation.
                                       willReplace(
                                         ) &&
                                       !higherAnimation.
                                          isDirty) { higherAnimation.
                                                       markDirty(
                                                         );
                                 } }
    protected void sampledLastValue(int repeatIteration) {
        
    }
    protected abstract void sampledAt(float simpleTime, float simpleDur,
                                      int repeatIteration);
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "NA0NMHQ3d4//AyFLxWkCKwAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "NCCE6dNwhaYwFlJqAACnvdyANhEihuHi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("cdH37+wx1oObx3JHrpZLq1kU/N4dPKlKTh9w864TD0vnxZ2H2bGfz+ZzsbTn" +
       "u3fi6eam5mM7J43AL73/Zu6Vm/fVX/70a68rw1+rHuzcWaZh6ULoej9jqWvV" +
       "OtHVhbynF2/+bp7aeJceu1l869P/4/HJhxcfvwMvtSf3cO53+Q+or36n/7z8" +
       "dw5Kdx05Xdzg93p9o5evd7W411fDyHcm1zlcvP/6t7vFG91wN7Ph/nPj44U9" +
       "/aExvhWMTdnp3kJ/fouyvyiiPw1LF3U1nOy/aT0Wpx+/1YPPk/1uMv7XEcWf" +
       "LjKfzcMndhQ/8a5TPHPuFmXni+hMLtc5xeN3EUfczhy8U27lPHxmx+0z7z63" +
       "y7coe28R3R+WLuXckBvetxxzfOAdcLxcZD6eh6/sOH7l3ef4xC3Kniqin8rX" +
       "L3SP3zP83jG3x98Bt4eKzMIB5Gs7bl9797m9eIuyl4rouVu8kTqm+fw7oPlI" +
       "kVno7Dd2NN+4U5offEuajVuUtYqoGpbeExuWNVK9wgN6jx74DugdvSf+5o7e" +
       "N999ep1blBUuPmd+Nj/EbNE3b+o7cPfaNZRjwh9+p4RbefjOjvB33h3CZ3Ye" +
       "4qegv8vY+qWeYW8xEVwRkbk6CkTbs1SleM92KMtnesfc3/I92i24P1pk/pU8" +
       "fHfH/d/dAfeNjfPBIvrBqRNw17Hp9Q8PozOjDbeP34K3VEQfzQVgxxsO9wh/" +
       "7E4IJ7mRd4OXf+Gv/NgNfy3a/h1G/s3XL55/9PXpH2wc3Y/+snKBLJ3XIss6" +
       "6fh5In3O81XN2EzDha0bqLchY4Slh091OMhFuPgq8J5ZbOvm5tCl/bph6ezm" +
       "+2Q9Nyzde1wvLJ3bJk5W8XMZy6sUycA75R3z1vc1OXO9qXk4w6XLbzXDJ6zT" +
       "Z6+zKTd/6zq0/6LtH7uuyV9/Hac/8aPGr2198GVLzLKil/Nk6Z7t3wGObMin" +
       "b9rbYV/nsBd+8sA3Ljx3aO8+sAV8LKcnsD15urc7anvhxj89+2eP/pMP/frr" +
       "f7jxoP1/ymKGjG83AAA=");
}
