package org.apache.batik.ext.awt.image.spi;
public class DefaultBrokenLinkProvider extends org.apache.batik.ext.awt.image.spi.BrokenLinkProvider {
    static org.apache.batik.ext.awt.image.renderable.Filter brokenLinkImg =
      null;
    static final java.lang.String MESSAGE_RSRC = "resources.Messages";
    static final java.awt.Color BROKEN_LINK_COLOR = new java.awt.Color(255,
                                                                       255,
                                                                       255,
                                                                       190);
    public static java.lang.String formatMessage(java.lang.Object base, java.lang.String code,
                                                 java.lang.Object[] params) {
        java.lang.ClassLoader cl =
          null;
        try {
            cl =
              org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class.
                getClassLoader(
                  );
            cl =
              base.
                getClass(
                  ).
                getClassLoader(
                  );
        }
        catch (java.lang.SecurityException se) {
            
        }
        org.apache.batik.i18n.LocalizableSupport ls;
        ls =
          new org.apache.batik.i18n.LocalizableSupport(
            MESSAGE_RSRC,
            base.
              getClass(
                ),
            cl);
        return ls.
          formatMessage(
            code,
            params);
    }
    public org.apache.batik.ext.awt.image.renderable.Filter getBrokenLinkImage(java.lang.Object base,
                                                                               java.lang.String code,
                                                                               java.lang.Object[] params) {
        synchronized (org.apache.batik.ext.awt.image.spi.DefaultBrokenLinkProvider.class)  {
            if (brokenLinkImg !=
                  null)
                return brokenLinkImg;
            java.awt.image.BufferedImage bi;
            bi =
              new java.awt.image.BufferedImage(
                100,
                100,
                java.awt.image.BufferedImage.
                  TYPE_INT_ARGB);
            java.util.Hashtable ht =
              new java.util.Hashtable(
              );
            ht.
              put(
                BROKEN_LINK_PROPERTY,
                formatMessage(
                  base,
                  code,
                  params));
            bi =
              new java.awt.image.BufferedImage(
                bi.
                  getColorModel(
                    ),
                bi.
                  getRaster(
                    ),
                bi.
                  isAlphaPremultiplied(
                    ),
                ht);
            java.awt.Graphics2D g2d =
              bi.
              createGraphics(
                );
            g2d.
              setColor(
                BROKEN_LINK_COLOR);
            g2d.
              fillRect(
                0,
                0,
                100,
                100);
            g2d.
              setColor(
                java.awt.Color.
                  black);
            g2d.
              drawRect(
                2,
                2,
                96,
                96);
            g2d.
              drawString(
                "Broken Image",
                6,
                50);
            g2d.
              dispose(
                );
            brokenLinkImg =
              new org.apache.batik.ext.awt.image.renderable.RedRable(
                org.apache.batik.ext.awt.image.GraphicsUtil.
                  wrap(
                    bi));
            return brokenLinkImg;
        }
    }
    public DefaultBrokenLinkProvider() { super(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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");
}
