package org.sunflow.core.filter;
public class LanczosFilter implements org.sunflow.core.Filter {
    public float getSize() { return 4.0F; }
    public float get(float x, float y) { return sinc1d(x * 0.5F) * sinc1d(
                                                                     y *
                                                                       0.5F);
    }
    private float sinc1d(float x) { x = java.lang.Math.abs(x);
                                    if (x < 1.0E-5F) return 1;
                                    if (x > 1.0F) return 0;
                                    x *= java.lang.Math.PI;
                                    float sinc = (float) java.lang.Math.sin(
                                                                          3 *
                                                                            x) /
                                      (3 *
                                         x);
                                    float lanczos = (float) java.lang.Math.
                                                      sin(
                                                        x) / x;
                                    return sinc * lanczos; }
    public LanczosFilter() { super(); }
    public static final java.lang.String jlc$CompilerVersion$jl7 = "2.7.0";
    public static final long jlc$SourceLastModified$jl7 = 1456093649000L;
    public static final java.lang.String jlc$ClassType$jl7 = ("H4sIAAAAAAAAALVYfWwUxxWfO39/4C+wTQiYL4NkAnehDW0j0xRw7GByBgsT" +
                                                              "1JqWY7w3d7d4b3fZnbXPJm4T1Aj6RREBQquGv4iaRElAVaO2ahO5itQkSlop" +
                                                              "UdQkrUIqtVLpB2pQpeQP2qbvzezefpxtRNWcdHN7M2/evPfmN7/3Zp+5Rqps" +
                                                              "i3QxnSf4lMnsRL/Oh6lls0yfRm17H/Sllccq6D8PXt19d5xUj5KmPLWHFGqz" +
                                                              "AZVpGXuUrFB1m1NdYfZuxjI4Y9hiNrMmKFcNfZS0q/ZgwdRUReVDRoahwH5q" +
                                                              "pUgr5dxSxxzOBl0FnKxIgSVJYUlye3S4N0UaFcOc8sWXBsT7AiMoWfDXsjlp" +
                                                              "SR2mEzTpcFVLplSb9xYtcodpaFM5zeAJVuSJw9oWNwS7UlvKQrDmcvOHN07l" +
                                                              "W0QIFlNdN7hwz97LbEObYJkUafZ7+zVWsI+Qr5KKFGkICHPSnfIWTcKiSVjU" +
                                                              "89aXAusXMd0p9BnCHe5pqjYVNIiT1WElJrVowVUzLGwGDbXc9V1MBm9XlbyV" +
                                                              "Xpa5ePaO5JnHDrb8qII0j5JmVR9BcxQwgsMioxBQVhhjlr09k2GZUdKqw2aP" +
                                                              "MEulmjrt7nSbreZ0yh3Yfi8s2OmYzBJr+rGCfQTfLEfhhlVyLysA5f6rymo0" +
                                                              "B752+L5KDwewHxysV8EwK0sBd+6UynFVz3CyMjqj5GP3/SAAU2sKjOeN0lKV" +
                                                              "OoUO0iYholE9lxwB6Ok5EK0yAIAWJ8vmVYqxNqkyTnMsjYiMyA3LIZCqE4HA" +
                                                              "KZy0R8WEJtilZZFdCuzPtd1bTx7Vd+pxEgObM0zR0P4GmNQVmbSXZZnF4BzI" +
                                                              "iY0bUudoxwsn4oSAcHtEWMr85MHr2zZ2zb4iZW6fQ2bP2GGm8LRycazpjeV9" +
                                                              "PXdXoBm1pmGruPkhz8UpG3ZHeosmMExHSSMOJrzB2b2/+tJDT7O/xUn9IKlW" +
                                                              "DM0pAI5aFaNgqhqz7mM6syhnmUFSx/RMnxgfJDXwnFJ1Jnv3ZLM244OkUhNd" +
                                                              "1Yb4DyHKggoMUT08q3rW8J5NyvPiuWgSQmrgSzbCt4rIj/jlZH8ybxRYkipU" +
                                                              "V3UjOWwZ6L+dBMYZg9jmk7ajZzVjMmlbStKwcqX/imGxJKwNuEmmgI2mDXtA" +
                                                              "/EsgvsxPTHMRfVo8GYtBuJdHD7sG52SnoWWYlVbOODv6rz+Xfk0CCcHvRoOT" +
                                                              "dbBcwl0ugcsl5HKJ0HIkFhOrLMFl5YbCdozDwQZmbewZ+cquQyfWVACSzMlK" +
                                                              "iCWKrgllmD7/9HuUnVYutS2aXn1l80txUpkibVThDtUwYWy3ckBFyrh7WhvH" +
                                                              "IPf4KWBVIAVg7rIMhWWAgeZLBa6WWmOCWdjPyZKABi9B4VFMzp8e5rSfzJ6f" +
                                                              "fHj/1+6Mk3iY9XHJKiAsnD6MXF3i5O7oaZ9Lb/Pxqx9eOjdj+Oc+lEa87Fc2" +
                                                              "E31YE8VBNDxpZcMq+nz6hZluEfY64GVO4RwB5XVF1wjRSq9H0ehLLTicNawC" +
                                                              "1XDIi3E9z1vGpN8jANqKTbvEKkIoYqBg98+PmI+/85u/fFpE0ksEzYEMPsJ4" +
                                                              "b4B8UFmboJlWH5H7LMZA7r3zw4+evXb8gIAjSKyda8FubPuAdGB3IIKPvHLk" +
                                                              "3fevXHwr7kOYQ/Z1xqCIKQpflnwMnxh8/4NfJAzskMTR1uey16oSfZm48nrf" +
                                                              "NiAyDY48gqP7AR1gqGZVOqYxPD//al63+fm/n2yR261Bj4eWjTdX4PfftoM8" +
                                                              "9NrBj7qEmpiCidSPny8m2Xmxr3m7ZdEptKP48JsrvvcyfRx4HrjVVqeZoEsi" +
                                                              "4kHEBm4RsbhTtHdFxj6LzTo7iPHwMQoUPGnl1FsfLNr/wYvXhbXhiim470PU" +
                                                              "7JUokrsAi20ibhOibxztMLHtLIINnVGi2kntPCi7a3b3l1u02Ruw7Cgsq0At" +
                                                              "Ye+xgCSLISi50lU1v/vlSx2H3qgg8QFSrxk0M0DFgSN1gHRm54Ffi+YXtkk7" +
                                                              "JmuhaRHxIGURKuvAXVg59/72F0wudmT6p50/3vrDC1cELE2p4/agwvWi7cFm" +
                                                              "o4QtPm4qloIlPtULBCugMyael3LSWZYTZBbAwK6Yr1wRpdbFY2cuZPY8sVkW" +
                                                              "FW3hEqAfKtxnf/vv1xPn//DqHJmojhvmJo1NMC1gUwUuGcokQ6KS89nsvabT" +
                                                              "f/xZd27HrSQR7Ou6SZrA/yvBiQ3zJ4WoKS8f++uyfffkD91CPlgZCWdU5VND" +
                                                              "z7x633rldFyUrTIVlJW74Um9wcDCohaD+lxHN7FnkThNa0sAaUU8LHVB4oEl" +
                                                              "dJokcQu0YdNfmipwWL/A1AXI4osLjI1iM8JJTY7xEWChcDGBezvijNmQ+NUC" +
                                                              "JIMJt+b91PAh5UT38J8k9G6bY4KUa38y+Z39bx9+XWxSLaKiFJoAIgA9gRTW" +
                                                              "gk0C4d+zwA0ybE9ypu398R9cfVbaEy3YI8LsxJlvfpw4eUYeC3mrWVt2sQjO" +
                                                              "kTebiHWrF1pFzBj486WZnz85czzuxvp+junWoLy0E7FSBbckHENp6b3faP7F" +
                                                              "qbaKAThug6TW0dUjDhvMhCFXYztjgaD61yAfgK7NmEM5iW3wyO1z2OyTz1v/" +
                                                              "R17Fjh2m6N8ThvkSF68ebm8R5vNNjUA5LgyJ49+DohGq7QUA72ADF6oKALyY" +
                                                              "4cfC+ARi0eYd+SbXoaYFYlGWYOBcmpY6AUVOMRyihgU0RpyP+blKRufYAtH5" +
                                                              "OjZHoRyzVV3ZnIkE6MH/R4CKHHAavO9gcl5a9vpEXvmV5y4013ZeeOBtkXFK" +
                                                              "1/JGYJOso2mBcxA8E9WmxbKqcKhRFjSm+Pn2XOlWXsE4viDBB2H2t6T8dzlp" +
                                                              "icpzUok/QbHTnDQExDieSfEUFDoLkAMhfDxnesm/RdQk+E4kIV8AFGPldYcI" +
                                                              "ffvNQl+aEizCkTfF+yuPWhz5Bguugxd27T56/TNPyEuAotHpadTSAIQirxql" +
                                                              "rLl6Xm2eruqdPTeaLtet83gudAkJ2iYAAFgUBfuySFVsd5eK43cvbn3x1yeq" +
                                                              "3wSGPkBilJPFBwJvj2SkoLR2oFw5kConTqgwRLne2/P9qXs2Zv/xe1HSuUS7" +
                                                              "fH75tDL66DuDl8c/2iZemFQBhbPiKKlX7Xun9L1MmbBCLNyEaKT4JkvEwQ3f" +
                                                              "olIv3gY5WVOeWcrv0FDuTjJrh+HoGZfHG/ye0Is0r9BwTDMywe8JJNOcpH6M" +
                                                              "PuAvnRoyTe8qZZjiQObnIoq8mPyUeMTm6f8CuZXVW8oWAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456093649000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "9628DPq/WOh6RzUhAAA=");
}
