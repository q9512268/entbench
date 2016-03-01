package org.apache.batik.gvt.renderer;
public abstract class ConcreteTextPainter extends org.apache.batik.gvt.renderer.BasicTextPainter {
    public void paint(java.text.AttributedCharacterIterator aci, java.awt.geom.Point2D location,
                      org.apache.batik.gvt.TextNode.Anchor anchor,
                      java.awt.Graphics2D g2d) { java.awt.font.TextLayout layout =
                                                   new java.awt.font.TextLayout(
                                                   aci,
                                                   fontRenderContext);
                                                 float advance =
                                                   layout.
                                                   getAdvance(
                                                     );
                                                 float tx =
                                                   0;
                                                 switch (anchor.
                                                           getType(
                                                             )) {
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_MIDDLE:
                                                         tx =
                                                           -advance /
                                                             2;
                                                         break;
                                                     case org.apache.batik.gvt.TextNode.Anchor.
                                                            ANCHOR_END:
                                                         tx =
                                                           -advance;
                                                 }
                                                 layout.
                                                   draw(
                                                     g2d,
                                                     (float)
                                                       (location.
                                                          getX(
                                                            ) +
                                                          tx),
                                                     (float)
                                                       location.
                                                       getY(
                                                         ));
    }
    public ConcreteTextPainter() { super(
                                     ); }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "kYgqpQIyviWM/qak5hQMRbZT+h9tg7eFhBQAAA==");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1445630120000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAAMVZa8zk1ln2fnvJ7jbNbpImDSH3bAvptJ/HHnsu2qbEc/N4" +
       "xjP2eOy5Ubr1+O7xbXwbj0ugrQSJqBQKbEqR2vxqBVTpRYgKJFQUhKCtWiEV" +
       "Vdwk2gohUSiVmh8URIFy7Pnu++1WFT8Yac6c8XnPe97r43Pe8+p3ofOBDxU8" +
       "19polhvuKkm4a1r4brjxlGC3S+Os6AeK3LDEIODBsxvSU5+78v0ffFi/ugNd" +
       "mEP3i47jhmJouE7AKYFrxYpMQ1cOn7YsxQ5C6CptirEIR6FhwbQRhNdp6A1H" +
       "pobQNXpfBBiIAAMR4FwEmDikApPeqDiR3chmiE4YrKBfgM7Q0AVPysQLoSeP" +
       "M/FEX7T32LC5BoDDxez/GCiVT0586IkD3bc636LwywX45m++5+rvnYWuzKEr" +
       "hjPKxJGAECFYZA7dbSv2QvEDQpYVeQ7d6yiKPFJ8Q7SMNJd7Dt0XGJojhpGv" +
       "HBgpexh5ip+veWi5u6VMNz+SQtc/UE81FEve/3detUQN6Prgoa5bDdvZc6Dg" +
       "ZQMI5quipOxPObc0HDmEHj8540DHaz1AAKbeZSuh7h4sdc4RwQPovq3vLNHR" +
       "4FHoG44GSM+7EVglhB6+LdPM1p4oLUVNuRFCD52kY7dDgOpSbohsSgg9cJIs" +
       "5wS89PAJLx3xz3cH73zpfU7H2clllhXJyuS/CCY9dmISp6iKrziSsp1499vo" +
       "j4gPfuHFHQgCxA+cIN7S/MHPv/7c2x977Utbmp88hYZZmIoU3pA+sbjna480" +
       "nqmdzcS46LmBkTn/mOZ5+LN7I9cTD2Tegwccs8Hd/cHXuD+fvf9Tynd2oMsU" +
       "dEFyrcgGcXSv5NqeYSk+qTiKL4aKTEGXFEdu5OMUdBfo04ajbJ8yqhooIQWd" +
       "s/JHF9z8PzCRClhkJroL9A1Hdff7nhjqeT/xIAi6Cr7QA+D7FLT95L8h5MO6" +
       "ayuwKImO4bgw67uZ/plDHVmEQyUAfRmMei68APG/fAeyW4EDN/JBQMKur8Ei" +
       "iApd2Q7CWhzCwCUy8IsPg5ySfCVUeJBYrJjH8W4We97/y6pJZour6zNngJse" +
       "OQkSFsivjmsBDjekm1G99fpnbnxl5yBp9qwYQghYene79G6+9C5Yend/6d1T" +
       "lobOnMlXfFMmwjYogEuXABwAbN79zOjnuu998amzIBq99Tngj4wUvj16Nw7h" +
       "hMpBUwIxDb320fUHxr9Y3IF2jsNwJjZ4dDmbzmbgeQCS106m32l8r7zw7e9/" +
       "9iPPu4eJeAzX9/Dh1plZfj910sC+KykyQMxD9m97Qvz8jS88f20HOgdAAwBl" +
       "CCyWYdBjJ9c4lufX9zEz0+U8UFh1fVu0sqF9oLsc6r67PnySe/6evH8vsHED" +
       "2muOZUI2er+XtW/aRkrmtBNa5Jj87Mj7+N/8xT+XcnPvw/eVIy/EkRJePwIZ" +
       "GbMrOTjcexgDvK8ogO7vP8r+xsvffeFn8wAAFE+ftuC1rG0AqAAuBGb+pS+t" +
       "/vab3/jE13cOgyYE78xoYRlSslXyh+BzBnz/J/tmymUPtul+X2MPc544AB0v" +
       "W/mth7IB+LFAMmYRdE1wbFc2VENcWEoWsf915S3I5//1pavbmLDAk/2QevuP" +
       "ZnD4/Cfq0Pu/8p5/fyxnc0bKXn+H9jsk22Lq/YecCd8XN5kcyQf+8tHf+qL4" +
       "cYDOABEDI1VykINye0C5A4u5LQp5C58YQ7Pm8eBoIhzPtSPblBvSh7/+vTeO" +
       "v/fHr+fSHt/nHPV7X/Sub0Mta55IAPs3n8z6jhjogA57bfDuq9ZrPwAc54Cj" +
       "BFAtYHwAIsmxKNmjPn/X3/3Jnz743q+dhXba0GXLFeW2mCccdAlEuhLoALgS" +
       "72ee20bz+uI+2ifQLcpvA+Sh/N9ZIOAzt8eadrZNOUzXh/6TsRYf/If/uMUI" +
       "Ocqc8nY+MX8Ov/qxhxvv+k4+/zDds9mPJbciMtjSHc5FP2X/285TF/5sB7pr" +
       "Dl2V9vaLY9GKsiSagz1SsL+JBHvKY+PH9zvbl/v1Azh75CTUHFn2JNAcvglA" +
       "P6PO+pcPHf5McgYk4nl0t7JbzP4/l098Mm+vZc1Pba2edX8aZGyQ7zvBDNVw" +
       "RCvn80wIIsaSru3n6BjsQ4GJr5lWJWfzANh559GRKbO73bxtsSprS1sp8n75" +
       "ttFwfV9W4P17DpnRLtgHfugfP/zVX336m8BFXeh8nJkPeObIioMo2xr/8qsv" +
       "P/qGm9/6UA5AAH3Yj7SuPpdx7d1J46xpZk1rX9WHM1VH+TudFoOwn+OEIufa" +
       "3jEyWd+wAbTGe/s++Pn7vrn82Lc/vd3TnQzDE8TKizd/5Ye7L93cObKTfvqW" +
       "zezROdvddC70G/cs7ENP3mmVfEb7nz77/B/9zvMvbKW67/i+sAWOPZ/+q//+" +
       "6u5Hv/XlU7YZ5yz3/+DY8O5HOlhAEfuf/nimoGuJS2yVSWvGFE+xpax1RaW/" +
       "TA3B8JFYGmMjaahTjqmXmJpNOstpQ8MrYM8pw6RSifgS71Qq9eZoTHVb1lAf" +
       "Y7hIGGytVx9znrBprZZtwqQ2vLjyhit3RhU4IjaaVdcU4gFLrFeW2mRSwKck" +
       "lxY6XSyXowU6X1QqJZjG41rgDcaMOltRoSFU+93Bkukui2aCJyO0I9IIGeqJ" +
       "GdSDiVMKzERmSjA+wPClu9JrzV6JnZHjUTKEveLMNhmyvYrtdaXpLVcSJVDF" +
       "2BhYLUydCbjpWaZNos7YoVrVwVSezt2ewPEOIaBFRzB0O60Jm/pySE4Job9Y" +
       "LqkFNzHMChHwtQbHLVGfI6dwM/KpQTxrIbwXl3B+2Q9HIxbb2EG7q0e9liPP" +
       "eKRNFlDNMlvpbKwFw5kbSPIGK5WmLUzha+1JxVX8Cr5OIxZHVi0SmevFymjW" +
       "H7Tm1Ay3+HorNOZ+DZ31yQ0fOMWBPOQ5KmwmRNpu1cpDXQAGrg9TpKw2fE4d" +
       "SkkjDqURbjZYIUXGkUD1FyPPGfrkoLopL6wBMWeawzVSEhNSTOUJTU8aJZVK" +
       "GnKp12FV1TctLp24CiApF2buuCi1u5xGkUOms3Q2JNrHCvyIFUnSRSilYSYD" +
       "MXGlQrk4wdMaseSDdW+pMdKEtWwtqc826rhW7/ZbaFQmNptNeW4l4y6ulv1N" +
       "4mGEnYZVEh2340Wi8MTacweGrM+bFd9aiIaMCMkAH9Nlc06y1UaRICa4ajWk" +
       "cN4dk0jXnXWRxpxP+k1bb1K9zURmCNKW6yPLNZBkoTec0kCarrpdTBNni4ke" +
       "WSNJs13SFcxCXSTRYLDU9EFLHBfdkdvBSvVUlODyEp3USGHIFRFXX0ksOl2X" +
       "F0yxN+OWhoBq0742SOchn5bbDIJV20WBMgbAFV3a7iKFWjiVHbxK08tIjHom" +
       "37QV4MSJg0j2wqotwkpYQlF9FXPDBtLBq604QDZS4I0qRYtZas2h3J3h1b7S" +
       "Cmk3rVaXEcu22EJ7OUmI8SieLGd6s+QIK8vDV3rcYpdcf2YPyJDoCKPWJhyX" +
       "16xLTtfOgBtQttIJELsTEG1BxAxPWcbVeiJb2nBcEoYbReYHviJVhQBPMNrq" +
       "tQQirAp8WI3wZtVoF8hFY+zgM7sxnqQrbzVZLqh4ka77qz4lYdVeWu/5E6HJ" +
       "8DDeq0QJWWkHQxft9jgD5fo9fZVSrYXt8q11Uhd6xnCcBFrD48Ph0uQKdc1b" +
       "NClszbOs6sHLsb+MLQ3pzCzCZjBGw4Z1vByrfbfenHhFv9KsYeWKUwQs6wWx" +
       "ncSSPhxgOjMatLoU79ZdnVHKreG4ONJGLa47lZLxUljWqe66JRFddBG6SAFX" +
       "m1gkYuKmNStPh3GC9bhFr+yNfaxqdOKRg4ziKYeWYdjyA3tk9IiwvnTbPt4d" +
       "DZSx2V0mi35oTQxiMgvGzXWNsKQpzY2FWrFPt8v8oMOXamS5TgaEl+idITEr" +
       "4RUDbRdHrWFBhW2valcLBbjQGXtFfM5qZcHiJjFpLQKcbY7aMzxGWaMYOUVT" +
       "NTo1bGVh7YHQmGttpr/WZnq1yQTUemMzTkJ140VRI8j5plgx12gBZ9qByYwD" +
       "sbZSWzNnunFl1J71qx2B6gEcgKUupygxO1Ur1lQZUH6zj9YNE+9NWlXCbBrp" +
       "QGtV/CmOdhatLrHw1WkxkRWWttFJ3whndUNKJ3WJr6CEptflfqM5BSCbtOM4" +
       "nsa4KRqqqW1W0qjVNAWEQ2m6PIP1FsaGMRwJxNqQlkuaRyLbQIMh51itWClH" +
       "AbkmF0RfUbutKUzpDM8Hqc+Q1EjVp1VkUbAKmAI7E3SENedmEthTp5uyazwt" +
       "IJ20tCkHTIlZTxZG36VXhSrsFDdGbbRSq2llkZgDySz05mQhgqtJr1CnNXbC" +
       "xG5Q5IluQheGjR5RW1tqj+xVBxUeJeqwwZvNzgarcS7R7q2wAlyVyJ6b1KRo" +
       "MynSSkHTnJaa0Fxn7pF9QjN9TsGH9UiuhjN2IwlFTm5rfN1DChVmRKDTIj1E" +
       "alGfW0TaQEtavaCxavrNgV2fBaPNeMqsyvMJDMN1ScZqsi/QQzYZrmmxhMw6" +
       "wIKNrsU49VSbe+2CuoKFWcWv99J5e8y09Eo8HCDSAO+3CvNGvwlePmpV6cMl" +
       "vFYdT0YmXzHwUgQbKQegFg/6TJ+DLTMN5mJAzNdEd+iPzc0y1op0gbSkeIZO" +
       "/NpsuumWV0HEpgHir4u10qZQ1v1FOulg3KQWOqoaj/ykL8Bxu2fJzeHGKGCb" +
       "TX2YgDc6XiILK40N68XFAhfoaSWJUFHG8RmKjLq1bsLjGwqLHSTpEFVaYRwu" +
       "LmOVqu9IBbZKYFzYMLVVCjMdzRpLzGI8UQ3KZ4Ryt8RJshivlk65SQ0b3qQ4" +
       "68YS3SynQ31D+FbXtWBmyA5NdTrBXRmbsVof7C2MJd8aOSaO2ZRaTUzBHc/L" +
       "fX7aMMoIFtdE3Rcpi1mU9CLvsSsVwc06y9kU22/QGiIOonaNw2xDsI3upNPR" +
       "W6I+DRilFycro0hWNgZJ9c1EFUWxithhz2+V5yQjFpGp42hso7Ia0MPBEOsg" +
       "VB8ZdxR3SZALKzY02/QVUUMEtEz782SloPBGAfHaA9gR1atsaz5IJaxWc5oa" +
       "3F0XmjHNBb6vleqsShlYOAxcgY0w31Aba51TUrcAs2MhhStr0U4FWSVUd77y" +
       "Nok8dRK0WiDpfjiswQlCVWd2jVPrkTUtM1QNZKgR2XFd9NJqsTQob+ZqQS+5" +
       "K8mdjlHRJTmngc24DYNoTijzNsoh7tTg653lSo0aUTCtdGW9P0xLgTCIeCvW" +
       "+31fLKNmuSWSFCP0B8LIc0fFFl2rR7ZNzkxMDgl+QwnaplHb1PVmQfHaONr1" +
       "FpEVyyaHSE3fQMhe0C6E6GbBGu0yMWyq0+6CxrxJXUeIdkGmNH9cltk0KYIk" +
       "a/LVoDBKp+tKb4PNgt5gMp2n3Tm/CBtayUTkGlyZVXp4LS4xtDW1bBX4ctCt" +
       "C5pZMLqIK4jNjayUTViJ/NRB7dgp2zCx4m2S0o1NtW1qawOPvVqj1iYaDXMz" +
       "aXojdo0tnSLXRBMWQ2HYLZQoFDWWtN/2HMbrgPf42gfvT8sCERK2zSHjNl1s" +
       "0puVdfDukuxmu2M03XZ3UdBnjOs0bI7QqvxgQkzSWmeud4VaKW1XnUa/gDUt" +
       "hLMjIWRaA9lSFLhquQ1WmhUDVU4rGo0PSxN9SFrrUNLj0ngSaKFenMK+U54U" +
       "qsww7QRCmlC0bPFGm++ZnbqVyIV0SuqjjogPFGdJ9cYRgsTwcqaB7Te1iY1J" +
       "H16JS1wfAoia8wW9FmoVpa3Xh+Aw8Oyz2THh3T/eSe3e/FB6cL0ADmjZAPlj" +
       "nFCS0xfc2TsMXxQXQeiLUpgcVOnyz5U7VOmOVDKg7Ej26O2uFPLj2Cc+ePMV" +
       "mfkksrNXAZqE0KXQ9d5hKbFiHWGVHYvfdvujZz+/UTmsTHzxg//yMP8u/b0/" +
       "Ru318RNynmT5u/1Xv0y+Vfr1HejsQZ3ilrue45OuH69OXPaVMPId/liN4tED" +
       "y74hs9iz4PuOPcu+/fT656keO5N7bBsYJwps53KCc/uVirfkdYPsUm2XCEPf" +
       "WEShIjd0MXOz4lOhklcz96kfyKnFdbirKa69y7qGE6LN/dFrp9bdszL7wJWV" +
       "a4Qj6Yes7j9gRfqipxtSgDZzgcM7VAR/IWvcEDrvZXX7nIQ7EtRjcCiPXUM+" +
       "jHbvR53Hj5XdgFSnXA5k1c2Hbrmv3N6xSZ955crFN78i/HVeHz+4B7tEQxfV" +
       "yLKOFqOO9C94vqIauUaXtqUpL/95MYQevePdBcjB/W4u/QvbeR8KoTedNi+E" +
       "zoL2KOVLIXT1JCUwZ/57lO7XQujyIV0IXdh2jpLcBNwBSdZ92dv36u6dr17q" +
       "YmBIR0ybnDmODwd+u+9H+e0IpDx9DAjy++f9pI22N9A3pM++0h287/XyJ7fX" +
       "AZIlpmnG5SIN3bW9mThI/Cdvy22f14XOMz+453OX3rIPUvdsBT5MxyOyPX56" +
       "vb1le2FeIU//8M2//87ffuUbeZXufwEbl3qYGCAAAA==");
}
