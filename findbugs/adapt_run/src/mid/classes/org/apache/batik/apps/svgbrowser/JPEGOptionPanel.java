package org.apache.batik.apps.svgbrowser;
public class JPEGOptionPanel extends org.apache.batik.apps.svgbrowser.OptionPanel {
    protected javax.swing.JSlider quality;
    public JPEGOptionPanel() { super(new java.awt.GridBagLayout());
                               org.apache.batik.util.gui.ExtendedGridBagConstraints constraints =
                                 new org.apache.batik.util.gui.ExtendedGridBagConstraints(
                                 );
                               constraints.insets = new java.awt.Insets(
                                                      5,
                                                      5,
                                                      5,
                                                      5);
                               constraints.weightx = 0;
                               constraints.weighty = 0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    NONE;
                               constraints.setGridBounds(
                                             0,
                                             0,
                                             1,
                                             1);
                               add(new javax.swing.JLabel(
                                     resources.
                                       getString(
                                         "JPEGOptionPanel.label")),
                                   constraints);
                               quality = new javax.swing.JSlider(
                                           );
                               quality.setMinimum(0);
                               quality.setMaximum(100);
                               quality.setMajorTickSpacing(
                                         10);
                               quality.setMinorTickSpacing(
                                         5);
                               quality.setPaintTicks(true);
                               quality.setPaintLabels(true);
                               quality.setBorder(javax.swing.BorderFactory.
                                                   createEmptyBorder(
                                                     0,
                                                     0,
                                                     10,
                                                     0));
                               java.util.Hashtable labels =
                                 new java.util.Hashtable(
                                 );
                               for (int i = 0; i < 100; i +=
                                                          10) {
                                   labels.
                                     put(
                                       new java.lang.Integer(
                                         i),
                                       new javax.swing.JLabel(
                                         "0." +
                                         i /
                                           10));
                               }
                               labels.put(new java.lang.Integer(
                                            100),
                                          new javax.swing.JLabel(
                                            "1"));
                               quality.setLabelTable(labels);
                               java.awt.Dimension dim = quality.
                                 getPreferredSize(
                                   );
                               quality.setPreferredSize(new java.awt.Dimension(
                                                          350,
                                                          dim.
                                                            height));
                               constraints.weightx = 1.0;
                               constraints.fill = java.awt.GridBagConstraints.
                                                    HORIZONTAL;
                               constraints.setGridBounds(
                                             1,
                                             0,
                                             1,
                                             1);
                               add(quality, constraints);
    }
    public float getQuality() { return quality.getValue() /
                                  100.0F; }
    public static float showDialog(java.awt.Component parent) {
        java.lang.String title =
          resources.
          getString(
            "JPEGOptionPanel.dialog.title");
        org.apache.batik.apps.svgbrowser.JPEGOptionPanel panel =
          new org.apache.batik.apps.svgbrowser.JPEGOptionPanel(
          );
        org.apache.batik.apps.svgbrowser.OptionPanel.Dialog dialog =
          new org.apache.batik.apps.svgbrowser.OptionPanel.Dialog(
          parent,
          title,
          panel);
        dialog.
          pack(
            );
        dialog.
          setVisible(
            true);
        return panel.
          getQuality(
            );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "bnnD4Hl9gb3y/wNVxcMnBBgAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVae8wrx1Xf+933bZJ7c9ukIW3et6WJ029fttcmLY3X9tq7" +
       "Xnttr9f2mra363173w/b6y2hDwkSUVQiSNOC2giJVECVPoSoQEJFQQjaqhVS" +
       "UcVLoq0QEoVSqfmDgihQZtff+94kRPyB9e14PXPmzDlnzvnNmZnvhe9DZ6MQ" +
       "KvievdFtL95Vk3h3YZd2442vRrsMW+pLYaQqdVuKohGouy4/+IXLP/zR08aV" +
       "HejcDHq95LpeLMWm50ZDNfLslaqw0OXD2qatOlEMXWEX0kqCl7Fpw6wZxY+x" +
       "0OuOdI2ha+y+CDAQAQYiwLkIcO2QCnS6VXWXTj3rIblxFEA/B51ioXO+nIkX" +
       "Qw8cZ+JLoeTssennGgAOF7LfY6BU3jkJofsPdN/qfIPCHyvAz3z8vVd+9zR0" +
       "eQZdNl0+E0cGQsRgkBl0i6M6czWMaoqiKjPodldVFV4NTck201zuGXQ1MnVX" +
       "ipehemCkrHLpq2E+5qHlbpEz3cKlHHvhgXqaqdrK/q+zmi3pQNc7D3Xdakhl" +
       "9UDBSyYQLNQkWd3vcsYyXSWG7jvZ40DHax1AALqed9TY8A6GOuNKoAK6up07" +
       "W3J1mI9D09UB6VlvCUaJobtflmlma1+SLUlXr8fQXSfp+tsmQHUxN0TWJYbu" +
       "OEmWcwKzdPeJWToyP9/vveOj73fb7k4us6LKdib/BdDp3hOdhqqmhqorq9uO" +
       "tzzCPivd+aWndiAIEN9xgnhL8/s/+9Ljj9774le2NG+6CQ03X6hyfF1+fn7b" +
       "N95cf7h6OhPjgu9FZjb5xzTP3b+/1/JY4oPIu/OAY9a4u9/44vDPxA9+Rv3e" +
       "DnSJhs7Jnr10gB/dLnuOb9pq2FJdNZRiVaGhi6qr1PN2GjoP3lnTVbe1nKZF" +
       "akxDZ+y86pyX/wYm0gCLzETnwbvpat7+uy/FRv6e+BAEnQcPdAt43gZtP/l3" +
       "DAWw4TkqLMmSa7oe3A+9TP9sQl1FgmM1Au8KaPU9eA7833o7ukvAkbcMgUPC" +
       "XqjDEvAKQ902gh9+BEcrfR5660gNYabfbHF+ZgLAT7V3M9fz/z8GTTJLXFmf" +
       "OgUm6c0nIcIG0dX2bEUNr8vPLMnmS5+7/rWdg5DZs2EMIWDk3e3Iu/nIu9nI" +
       "u4cj754YGTp1Kh/wDZkEW48A82kBZACYecvD/HuY9z314Gngiv76DJiMjBR+" +
       "eeiuH2IJnSOmDBwaevET6w+NP4DsQDvHMTiTGlRdyrr3M+Q8QMhrJ2PvZnwv" +
       "P/ndH37+2Se8wyg8Bup74HBjzyy4Hzxp39CTVQXA5SH7R+6Xvnj9S09c24HO" +
       "AMQAKBlLwKsBAN17coxjQf7YPmBmupwFCmte6Eh21rSPcpdiA0zGYU0+8bfl" +
       "77cDG78u8/q7wYPuhUH+nbW+3s/KN2wdJZu0E1rkgPxO3v/UX//5P+G5ufex" +
       "+/KR1ZBX48eO4EXG7HKODLcf+sAoVFVA93ef6P/qx77/5M/kDgAoHrrZgNey" +
       "sg5wAkwhMPPPfyX4m29/6/lv7hw6TQwWzOXcNuXkQMmsHrr0CkqC0d56KA/A" +
       "GxuEX+Y11wTX8RRTM6W5rWZe+p+X34J+8V8+emXrBzao2XejR1+dwWH9T5DQ" +
       "B7/23n+7N2dzSs7Wu0ObHZJtQfT1h5xrYShtMjmSD/3FPb/2ZelTAI4BBEZm" +
       "quaoBuU2gPJJg3P9H8nL3RNtaFbcFx11/uPxdSQvuS4//c0f3Dr+wR+9lEt7" +
       "PLE5OtddyX9s615ZcX8C2L/xZKS3pcgAdMUXe+++Yr/4I8BxBjjKAMciLgSA" +
       "kxzzjD3qs+f/9o//5M73feM0tENBl2xPUigpDzLoIvBuNTIAViX+ux7fTu76" +
       "Aiiu5KpCNyi/dYq78l9ngIAPvzy+UFlechiid/0HZ88//Pf/foMRcmS5yXJ8" +
       "ov8MfuGTd9d/+nt5/8MQz3rfm9wIwiCHO+yLfcb5150Hz/3pDnR+Bl2R9xLE" +
       "sWQvs8CZgaQo2s8aQRJ5rP14grNdzR87gLA3n4SXI8OeBJdD8AfvGXX2fukE" +
       "ntyWWfle8Dy6F2qPnsSTU1D+8q68ywN5eS0rfnI/fC/6oRcDKVVlL4J/DD6n" +
       "wPPf2ZOxyyq2q/XV+l7KcP9BzuCDlel8sAT5abzJ+98RbyMo2Y3WILvbZXjb" +
       "VLaGv5ITYFnx+Haw0st60U9lRSM5BSQ8i+0Su0j2u3NzLU5nr28DSBTlyTTo" +
       "oZmuZOe2asQgKmz52r7kY5BcAze6trCJfXGv5BGQTdjuNiM9IWvjfy0r8PDb" +
       "DpmxHkhuP/IPT3/9lx/6NnBDBjq7ylwEeN+REXvLLN//hRc+ds/rnvnOR3Jg" +
       "BdPSf7Z55fGM6/iVNM4KLiv6+6renanK55kKK0VxN8dCVcm1fcXo64emA5aM" +
       "1V4yCz9x9dvWJ7/72W2iejLUThCrTz3ziz/e/egzO0e2Bw/dkKEf7bPdIuRC" +
       "37pn4RB64JVGyXtQ//j5J/7wt594civV1ePJbhPs5T77l//19d1PfOerN8me" +
       "ztje/2Fi41uTdjGia/uf7lhUsbWQJI7GVVcuuRbheldExW5NHNNmqV5BGrEk" +
       "GiJZxDi1GzKWXu10NZmIk5I4qeKrUey6COLXeIvyh5Oe2uGthpaMvFCijY4R" +
       "oB1/3KGmEmO3JNpZCIxF9bCl1Peb2GBtFHpIlcbgycyZEgre93lYclw8WfS1" +
       "agWthFUYT8floj7xoiYuzCZML7GbRTGhPQdrmORIXNEaH2Ahh6ydEq3C8pLR" +
       "UQ4O04ow9JuWs5jUQ6HJTDB+NLBHMz6gKdOZDcOm28SsgE4bOs+ELZoTQX7s" +
       "xEyvqSak22kFlt5pK0N7rRuY2OC4yaJu+z7LCSmj18ukJ842GhPN+k00mjKc" +
       "2fOQGdPbiBXDK5rGgtBaQb+navGMakzb1QKdtLvxaCjiFCWuMMpKEL/cCpuo" +
       "PfZRivd6rWo5xDB6Pm8SGyQZVNV0NIQV1dlYziw2erGIuFN6HE7wJhILCR0p" +
       "QytVCYEXSlIyrDbGUwoZrLWuMFXkiTZqtdaSjiCKNkICro92veU41Ub+1EgD" +
       "nvbmzYY1GhYd2iAXsyQ1pFGxJbfq06mA+kiqExI7bSGKslaEfnvsEhyPK6kG" +
       "BzUPZcatkadjaREx1vVaMGe6LZ1hZMcPx5ztOfKwjkhceyM6NX9iC+4cK2MT" +
       "KxbWqdCludbMsHCn4bSTforOdV5p9NJmLPRQHO0uNh7RrwZdM+T0oBS7Qam+" +
       "RtCobQwjgSP1mT5rED0rQrVIGKmzZNxNjXK8qNJkrSZhGIeQbQUHW4l1Wicn" +
       "1oQOqAWbeKJRYAeR1Zt7TRp4HTH2jQYzb6ELySC61nBMEVa9aNhePXCNZT0a" +
       "1xAGWbQYsTXldEatrFw3iUU0gWchPAbM1Ea361OCsirO1r3BTOz5rW40sKya" +
       "Wo+mFAW323J1lQ67TabWrys1tmUUKvFk3oCHyNQtMUh3HQ5STsCtyHKAH/kT" +
       "RXGVAg73e2OCNFDDKfpp36acVTfiq3q4GggNqzPv2TLw/AphliYYXNDYRqni" +
       "EqIyWOv1Dh8uZ2mzKceWX0wpZiI6Rbs1am6YPt0ITH6OVzSBHNdWi2WHHnZH" +
       "S2EzNpuNgAxsoUop/SLs1PUG7ZtMy6lHEukqreFSXKzIZC3UaFTuNFrLdokl" +
       "GRhmVBNRTNo1uwnbonqINhTXMT+Do43RbnM0OenOxjpStb15ESeUzXg6RNMe" +
       "CyJlaI0aatodJMOuwDbpVbKYNKiQZSKsOm3Xkqo5Sbrz3mAtpjVZX0g+T7mr" +
       "NoyxoxrboIg+OagzFaQ/8AYdTJmsgpROhCrLwP2g1ytVmRXP1hflSXcucB3C" +
       "6ygexrqdXqW0cSVOXcTtWrpcCLSxUmsyoYs6XeHkwqAm1UrR3F6j8CxaKt44" +
       "mTS9BaU25JLud+MOb080ctPkiEC16qiKj8ZoKVapSosWyJnCDIIwKSNjVGAR" +
       "vtTFJ8ymRooICrw0RRdIVe0AnjUbKfTbVT+p1EuFhlthxBoT1lhEVIs0GRMx" +
       "paQNdFOxY27FqsNE1vplkqApUhBKCT/pAut0hLDcK+sV0/YTnq1MubBUq6LG" +
       "uIbVSJ7sdfnBuEhVXZmumAvORitM6Au63Jnhg9RAJ1iJJqNagpGTPumovQ1a" +
       "6TeVIkfPWM4qFynbnm3a8EyKY9Jd9alpuyOakk5KlfY0WWNpmBaWBKykMh7b" +
       "dNGZVhCNCUdTElW6k3rU9g1xRbLq3Kg1FBcpuiN/U5YnA3eRFvQJxSzXGIER" +
       "OifWDLXuDKslSeN7cbVSrqKhaKJWpzoKNANkiMV6yJRsqkHy45nbXrm1uTGi" +
       "AV6i7QHsNymhY4C1BJ3WreVIGwnxtK9pZDQRh+Qm7HKttiDjEYmvEhcNuPa0" +
       "alVR2aWM+nAyX2BzdTKorzGFsGJ1xvglvbTR5WU4182hlrQkvaV365OuZRWD" +
       "OrOsVXhF0eFpvzLXlLU2IRxuNY8iDe5OS6XJkhViZhHiSFGuqG0by9B5jo+n" +
       "Ja2BdRbj4mCqbpBY75ulgdTwk6pIIz00VdXlcraabthZXSRpi193dHRWY1VK" +
       "9Mx1WVoGUzy1NwWEmNuSIXfmAs0FIm6NSpbTKpvgbyTUBcpao4ui7jZilSxX" +
       "ndD0AmFGzGSMKo0wvNuajebKquPKeKFSWsUuXmBIRmI811u2TSRcW33Nmpo+" +
       "LPcxgoATs+wuUS+gV25ShmtuGsOJzyNFDS64LcYa2RtbtbDaKmUwWnDB6rnU" +
       "SjDYFTbqS0YWeCfq6p20XSDcdDktNJebDtwI+hLTCiZEv4ST6DxlG60R0u/N" +
       "Rna325+yQ9Vtw4wfjKeGbJbWmrEhlLjJbiqYPlsMI7zVXfeKPTEuRUNObS+W" +
       "Y7XIFCmBqUSMk7Jcf1VS03GxQjZWk3ZANUtMqUbW085atwNWQkYbBG/z9Qox" +
       "HFmzCRU0BK4xiZENUQ82XVaMUpeUVvOASuIKCHDLDMY2wU7r/cEcNtdDgl5U" +
       "B6rcoiftYux0SnGJx/Gl3HXTit8YlRHeUwwJr/lLg1lxCA4XU6yw8GG4Ivuu" +
       "6vlEkFjBeEG2xzEmi7GdyJZeb6w6K9xzXDSWnKBc0eYtJCZqvOTLJb+zwtjy" +
       "qGYvKxxrrHAlWuFVKy3LXkWPGoYedGCurRszGWdLHGfALjWsDVcbceI4HQfn" +
       "WoP5qEaDCUcJQSVB2lSKRb48JyuVJUZMiI2hSV27bdgB7IP4rK3GQ2Mxq6Y9" +
       "ROhNhA48q8l4sNYLMNHpk5V+KW4KI9/vNOqLkjPFkGVsYT048DHZ66Vz3m3T" +
       "pq7FNWkFd1IYH47w8RBhyVipryxSnGGzKiE4qdBHRoXaiqygMBZRXFqfUozE" +
       "Yel8E7B4Z9kR5/VmQNfx2nBskmio4SvNUpEKS4ms3jJrzhCpFAqWi2BNZ9jh" +
       "OoVleWRtlq7bnCqqNygRBI+v8Y6zrhc0scoRVC2F4bXYXIhK3OY2eoMfoiO0" +
       "2DXihEdJGVmmhj9TVEkjCbhQMBqIpXMeG1R8D7c2NCm3pTI2HsGrSpHChiul" +
       "jo4qaDSyKc+YUNOBXoqCQVgb2/4Gk4cgKUURkQgUdjol6WqUsGOFNjZ12qja" +
       "a2Y0LFOrqtD0Gomt+3yt6upYr9OqUnO1xZFJy5ka/iRuekBaY+NZCN+PegOb" +
       "ISmcLtREKsCDScqbaqTNYNXpjj222Zn2ULFYBfmGaTNgIQBA6s7HDQ0nmj24" +
       "1JPb1aRH0ZuhzASFAA7DoIXIXQsbCKHFLwKWbsGw5QzFeKkQlFUIQ1iuTwr0" +
       "zISHSkuOorUwnne1fgFNTD9oxGRjCfeUvrL2sUphUSMmrM6kdk8YTgYR1xwZ" +
       "yz7nxrG6wHGMFfmOVF6Fq4WDy6XCql2v+AMDpCAKyaREWhzoi4E6nbPoCsEJ" +
       "PO5MGcuihCrXNa2UrrsUIWPxRFy6tjqnzdVgtUqnIaYFdsMOELPWI4JRv0+V" +
       "7ZBW6B5liYquLZuoiqqdarEYF+Z8gMgLdN1wlYAeGGbJnWE2Pk4bG4Ei8SRa" +
       "kQ10iGjx1J9PDTctTfr4Gqxz5lwig5TjjbVflnm7XHS64nTtLjivLYC1k+bd" +
       "Ner2GwYr9fhWz2nOfApxfVVOK3bq0Mmi6uADrDjDyrUUH9tYSZK8IOETPq02" +
       "1n3UdMFS4EwH87a4DLRecQ13VnJkD2s+b/TGYEnzWs2ir3rU3HUbxbZd1ef4" +
       "Bl73xgnAFpLUwUbrne/MtmD6a9sF355v+A/uo8DmN2sYvobd37bpgax4y8Fh" +
       "S/45d/IO4+i55uFhF5TtaO95uWumfDf7/IefeU7hPo3u7B0SzmPoYuz5b7fV" +
       "lWofYbUDOD3y8jv3bn7Ldnh49eUP//Pdo5823vcajuTvOyHnSZa/033hq623" +
       "yr+yA50+OMq64f7veKfHjh9gXQrVeBm6o2PHWPccWDa37pvA8+49y7775sfi" +
       "Nz/Dyr1gO/evcAb7xCu0fSArkhi6pKvx4MhZ1nuO+ImUHSvZnhQfetDm1c4P" +
       "jo6TVywPVL4rq3wQPMqeysprUHnn0PFvqvepvQudvQOuq/lxk7SOd7NTMM9V" +
       "3Tjv9kuvYJKns+JJYJLI8NYNU7K9/PTkQ4faP/VatAfGvXzieio7a7/rhuvy" +
       "7RWv/LnnLl9443PCX+U3NAfXsBdZ6IK2tO2jR6NH3s/5oaqZufgXtwelfv71" +
       "8Ri6/9UuzzJND37k4j+77fzrMXTHTTvH0Jns6yjtp2Loykla4Db591G63wCj" +
       "HdLF0Lnty1GS34yh04Ake33e35/IR1/1CvCIfZNTx/HoYOKuvtrEHYGwh44B" +
       "T/4/EPsgsdz+F8R1+fPPMb33v1T+9PZWSralNM24XGCh89sLsgOgeeBlue3z" +
       "Otd++Ee3feHiW/ZB8batwIexcES2+25+BdR0/Di/tEn/4I2/947feu5b+aHq" +
       "/wBj8JHFnCIAAA==");
}
