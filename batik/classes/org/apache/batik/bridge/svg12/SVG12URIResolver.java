package org.apache.batik.bridge.svg12;
public class SVG12URIResolver extends org.apache.batik.bridge.URIResolver {
    public SVG12URIResolver(org.w3c.dom.svg.SVGDocument doc, org.apache.batik.bridge.DocumentLoader dl) {
        super(
          doc,
          dl);
    }
    protected java.lang.String getRefererBaseURI(org.w3c.dom.Element ref) {
        org.apache.batik.dom.AbstractNode aref =
          (org.apache.batik.dom.AbstractNode)
            ref;
        if (aref.
              getXblBoundElement(
                ) !=
              null) {
            return null;
        }
        return aref.
          getBaseURI(
            );
    }
    protected org.w3c.dom.Node getNodeByFragment(java.lang.String frag,
                                                 org.w3c.dom.Element ref) {
        org.apache.batik.dom.xbl.NodeXBL refx =
          (org.apache.batik.dom.xbl.NodeXBL)
            ref;
        org.apache.batik.dom.xbl.NodeXBL boundElt =
          (org.apache.batik.dom.xbl.NodeXBL)
            refx.
            getXblBoundElement(
              );
        if (boundElt !=
              null) {
            org.apache.batik.dom.xbl.XBLShadowTreeElement shadow =
              (org.apache.batik.dom.xbl.XBLShadowTreeElement)
                boundElt.
                getXblShadowTree(
                  );
            org.w3c.dom.Node n =
              shadow.
              getElementById(
                frag);
            if (n !=
                  null) {
                return n;
            }
            org.w3c.dom.NodeList nl =
              refx.
              getXblDefinitions(
                );
            for (int i =
                   0;
                 i <
                   nl.
                   getLength(
                     );
                 i++) {
                n =
                  nl.
                    item(
                      i).
                    getOwnerDocument(
                      ).
                    getElementById(
                      frag);
                if (n !=
                      null) {
                    return n;
                }
            }
        }
        return super.
          getNodeByFragment(
            frag,
            ref);
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1471188907000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAAL1Ya2wcVxW+u347fju2Qxw7ieO4ipPu1k2DVDm0jR072XT9" +
                                                              "kJ1YYk2zuTt7d3fi2ZnJzF177RJIC6jhTxWFNA1F8S9XVVFpK0QFSLQyqkRb" +
                                                              "FZBaIqCgBiT+lEdEI6TyI7zOuTOzMzvrdVSEWGnuzN577jn3vL5zZl66RapM" +
                                                              "g/QylYf4ss7M0JjKp6lhsuSoQk3zJMzFpWcr6N9OfzT5YJBUx0hThpoTEjXZ" +
                                                              "uMyUpBkjPbJqcqpKzJxkLIk7pg1mMmORcllTY6RDNiNZXZElmU9oSYYEc9SI" +
                                                              "klbKuSEncpxFbAac9EThJGFxkvAR//JwlDRImr7skm/zkI96VpAy68oyOWmJ" +
                                                              "nqWLNJzjshKOyiYfzhtkv64py2lF4yGW56GzyiHbBCeih0pM0Pdq8yd3LmVa" +
                                                              "hAnaqapqXKhnzjBTUxZZMkqa3dkxhWXNc+RLpCJKtniIOemPOkLDIDQMQh1t" +
                                                              "XSo4fSNTc9lRTajDHU7VuoQH4mR3MROdGjRrs5kWZwYOtdzWXWwGbXcVtLW0" +
                                                              "LFHxmf3hK8+ebvluBWmOkWZZncXjSHAIDkJiYFCWTTDDPJJMsmSMtKrg7Flm" +
                                                              "yFSRV2xPt5lyWqU8B+53zIKTOZ0ZQqZrK/Aj6GbkJK4ZBfVSIqDsf1UphaZB" +
                                                              "105XV0vDcZwHBetlOJiRohB39pbKBVlNcrLTv6OgY/+jQABba7KMZ7SCqEqV" +
                                                              "wgRps0JEoWo6PAuhp6aBtEqDADQ42V6WKdpap9ICTbM4RqSPbtpaAqo6YQjc" +
                                                              "wkmHn0xwAi9t93nJ459bk4efflw9rgZJAM6cZJKC598Cm3p9m2ZYihkM8sDa" +
                                                              "2DAYvUo7X78YJASIO3zEFs33v3j7kQO9629bNN0b0EwlzjKJx6W1RNN7O0b3" +
                                                              "PViBx6jVNVNG5xdpLrJs2l4ZzuuAMJ0FjrgYchbXZ37y+QvfZn8OkvoIqZY0" +
                                                              "JZeFOGqVtKwuK8w4xlRmUM6SEVLH1OSoWI+QGniOyiqzZqdSKZPxCKlUxFS1" +
                                                              "Jv6DiVLAAk1UD8+ymtKcZ53yjHjO64SQGrhIA1z3EOsn7pzQcEbLsjCVqCqr" +
                                                              "Wnja0FB/MwyIkwDbZsIJiPqFsKnlDAjBsGakwxTiIMPshYQhJ9MsbC6mh+4P" +
                                                              "z84dG7r/1EzEzgAjhKGm/z+E5FHT9qVAAJywww8BCmTPcU1JMiMuXcmNjN1+" +
                                                              "Of6uFV6YEraNOAmB3JAlNyTkhiy5ISE35JdLAgEhbivKt/wN3lqAvAfgbdg3" +
                                                              "+9iJMxf7KiDQ9KVKMDWS9hUVoFEXHBxEj0uvtDWu7L459GaQVEZJG5V4jipY" +
                                                              "T44YaUAqacFO5oYElCa3QuzyVAgsbYYmsSQAVLlKYXOp1UAPnOdkq4eDU78w" +
                                                              "U8Plq8eG5yfr15aemPvyfUESLC4KKLIK8Ay3TyOUFyC73w8GG/FtfuqjT165" +
                                                              "el5zYaGoyjjFsWQn6tDnDwi/eeLS4C76Wvz18/3C7HUA25xCmgEi9vplFKHO" +
                                                              "sIPgqEstKJzSjCxVcMmxcT3PGNqSOyMitVU8b4Ww2IJp2A3XATsvxR1XO3Uc" +
                                                              "u6zIxjjzaSEqxOdm9eu//vkfDwpzO8Wk2dMFzDI+7AEwZNYmoKrVDduTBmNA" +
                                                              "9+G16W88c+upeRGzQLFnI4H9OI4CcIELwcxfe/vcB7+7uXYj6MY5hwqeS0Aj" +
                                                              "lC8oifOkfhMlQdqAex4AQAXwAaOm/5QK8SmnZJpQGCbWP5r3Dr32l6dbrDhQ" +
                                                              "YMYJowN3Z+DOf2aEXHj39N97BZuAhAXYtZlLZqF6u8v5iGHQZTxH/on3e775" +
                                                              "Fr0O9QEw2ZRXmIDZoLBBUGi+jZNuhJSlg1IoqWURRhBEjmpSLsvsfgdoBsrB" +
                                                              "jkMY1ShAl4iDQ2LTfWJ8AG0oxBGxNozDXtObT8Up6+m94tKlGx83zn38xm1h" +
                                                              "gOLmzRs+E1QftiIWh4E8sO/y491xamaA7oH1yS+0KOt3gGMMOEqA5OaUgScv" +
                                                              "CjabuqrmNz9+s/PMexUkOE7qFVBxnIq8JXWQMMzMAF7n9YcfseJlqRaGFqEq" +
                                                              "KVG+ZAJ9tnPjaBjL6lz4b+UHXd87/MLqTRG4usWj28vwHhz2F0JY/Kr99dMb" +
                                                              "wkUcDNJTrsUR7dnak1dWk1PPD1mNSFtx2zAGXfF3fvnPn4au/f6dDepUHdf0" +
                                                              "exW2yBSPzCCKLCovE6L7cyHuw6bLf/hhf3rk01QWnOu9S+3A/ztBicHylcJ/" +
                                                              "lLee/NP2kw9lznyKIrHTZ04/yxcnXnrn2IB0OShaXas+lLTIxZuGvYYFoQaD" +
                                                              "nl5FNXGmUYT9nkIAdKBjB+A6aAfAwY2BWsSOGAdxuNcBxTrd0DiEIUv6cLFx" +
                                                              "E56+dA/YnYSNHO1edMGXMfC/OEVsE5g4jcMsJ61pxq1aZoyAx6Gxcdi2iNTB" +
                                                              "F4SQ9YIgFg7jcNI6+8P/ZV7ixJgu5qcKRmjHtX64RmwjjGxiWBzmSu1XbqvP" +
                                                              "DjY6498zOMwL1gubWCuLQ8qy1iQE+8jyuEHTXvhu8ToBSVxrpf8X1sqDCH/r" +
                                                              "iQC3reRF13o5k15eba7tWj31K5HnhReoBsjYVE5RPAHvDf5q3WApWajcYOG9" +
                                                              "Lm5LnPRs2hZzUiXu4viL1qYVTrrKbILmwHrw0p+3reilB77i7qW7wEm9Swes" +
                                                              "rAcvyVc4qQASfPyq7rhoTzkNPCbNB0pLgHBix92c6MH8PUUQKD5YOHCVsz5Z" +
                                                              "QIO/emLy8duffd7q2CSFrqyIF1x4X7eaxwLk7S7LzeFVfXzfnaZX6/YG7Wht" +
                                                              "tQ7s5ku3J5THADl0jJztvnbG7C90NR+sHX7jZxer34eqM08CFCBm3vO5wHo3" +
                                                              "hp4oB7VmPupWG88HL9FnDe97bvmhA6m//lZUV2K9/OwoTx+Xbrzw2C8ub1uD" +
                                                              "fmxLhFRBgWT5GKmXzaPL6gyTFo0YaZTNsTwcEbjIVImQ2pwqn8uxSDJKmjDI" +
                                                              "KSKVsIttzsbCLPb7nPSVfLPY4C0JOpElAEQtpyZFEYDy5M4UfUlxqkZO130b" +
                                                              "3JmCK7eW6h6Xjn69+UeX2irGIVGL1PGyrzFziUJF8n5ccUtUiwWH/4ZfAK5/" +
                                                              "4YVOxwm8c9I2an9o2FX40gAtj7VWEY9O6LpDW31Rt7LmKg7X8jjPSWDQnvXU" +
                                                              "IPz7LSH/OfGIw/X/ALn+fRxoFQAA");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1471188907000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "F7+ZHxv+L9JVGev8IAAA");
}
