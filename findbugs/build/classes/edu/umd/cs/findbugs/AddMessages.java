package edu.umd.cs.findbugs;
public class AddMessages {
    private final edu.umd.cs.findbugs.BugCollection bugCollection;
    private final org.dom4j.Document document;
    public AddMessages(edu.umd.cs.findbugs.BugCollection bugCollection, org.dom4j.Document document) {
        super(
          );
        this.
          bugCollection =
          bugCollection;
        this.
          document =
          document;
    }
    public void execute() { java.util.Iterator<?> elementIter = edu.umd.cs.findbugs.xml.XMLUtil.
                              selectNodes(
                                document,
                                "/BugCollection/BugInstance").
                              iterator(
                                );
                            java.util.Iterator<edu.umd.cs.findbugs.BugInstance> bugInstanceIter =
                              bugCollection.
                              iterator(
                                );
                            java.util.Set<java.lang.String> bugTypeSet =
                              new java.util.HashSet<java.lang.String>(
                              );
                            java.util.Set<java.lang.String> bugCategorySet =
                              new java.util.HashSet<java.lang.String>(
                              );
                            java.util.Set<java.lang.String> bugCodeSet =
                              new java.util.HashSet<java.lang.String>(
                              );
                            while (elementIter.hasNext(
                                                 ) &&
                                     bugInstanceIter.
                                     hasNext(
                                       )) { org.dom4j.Element element =
                                              (org.dom4j.Element)
                                                elementIter.
                                                next(
                                                  );
                                            edu.umd.cs.findbugs.BugInstance bugInstance =
                                              bugInstanceIter.
                                              next(
                                                );
                                            java.lang.String bugType =
                                              bugInstance.
                                              getType(
                                                );
                                            bugTypeSet.
                                              add(
                                                bugType);
                                            edu.umd.cs.findbugs.BugPattern bugPattern =
                                              bugInstance.
                                              getBugPattern(
                                                );
                                            bugCategorySet.
                                              add(
                                                bugPattern.
                                                  getCategory(
                                                    ));
                                            bugCodeSet.
                                              add(
                                                bugPattern.
                                                  getAbbrev(
                                                    ));
                                            element.
                                              addElement(
                                                "ShortMessage").
                                              addText(
                                                bugPattern.
                                                  getShortDescription(
                                                    ));
                                            element.
                                              addElement(
                                                "LongMessage").
                                              addText(
                                                bugInstance.
                                                  getMessage(
                                                    ));
                                            java.util.Iterator<?> annElementIter =
                                              element.
                                              elements(
                                                ).
                                              iterator(
                                                );
                                            java.util.Iterator<edu.umd.cs.findbugs.BugAnnotation> annIter =
                                              bugInstance.
                                              annotationIterator(
                                                );
                                            while (annElementIter.
                                                     hasNext(
                                                       ) &&
                                                     annIter.
                                                     hasNext(
                                                       )) {
                                                org.dom4j.Element annElement =
                                                  (org.dom4j.Element)
                                                    annElementIter.
                                                    next(
                                                      );
                                                edu.umd.cs.findbugs.BugAnnotation ann =
                                                  annIter.
                                                  next(
                                                    );
                                                annElement.
                                                  addElement(
                                                    "Message").
                                                  addText(
                                                    ann.
                                                      toString(
                                                        ));
                                            }
                            }
                            addBugCategories(
                              bugCategorySet);
                            addBugPatterns(
                              bugTypeSet);
                            addBugCodes(bugCodeSet);
    }
    private void addBugCategories(java.util.Set<java.lang.String> bugCategorySet) {
        org.dom4j.Element root =
          document.
          getRootElement(
            );
        for (java.lang.String category
              :
              bugCategorySet) {
            org.dom4j.Element element =
              root.
              addElement(
                "BugCategory");
            element.
              addAttribute(
                "category",
                category);
            org.dom4j.Element description =
              element.
              addElement(
                "Description");
            description.
              setText(
                edu.umd.cs.findbugs.I18N.
                  instance(
                    ).
                  getBugCategoryDescription(
                    category));
            edu.umd.cs.findbugs.BugCategory bc =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
              instance(
                ).
              getBugCategory(
                category);
            if (bc !=
                  null) {
                java.lang.String s =
                  bc.
                  getAbbrev(
                    );
                if (s !=
                      null) {
                    org.dom4j.Element abbrev =
                      element.
                      addElement(
                        "Abbreviation");
                    abbrev.
                      setText(
                        s);
                }
                s =
                  bc.
                    getDetailText(
                      );
                if (s !=
                      null) {
                    org.dom4j.Element details =
                      element.
                      addElement(
                        "Details");
                    details.
                      setText(
                        s);
                }
            }
        }
    }
    private void addBugCodes(java.util.Set<java.lang.String> bugCodeSet) {
        org.dom4j.Element root =
          document.
          getRootElement(
            );
        for (java.lang.String bugCode
              :
              bugCodeSet) {
            org.dom4j.Element element =
              root.
              addElement(
                "BugCode");
            element.
              addAttribute(
                "abbrev",
                bugCode);
            org.dom4j.Element description =
              element.
              addElement(
                "Description");
            description.
              setText(
                edu.umd.cs.findbugs.I18N.
                  instance(
                    ).
                  getBugTypeDescription(
                    bugCode));
        }
    }
    private void addBugPatterns(java.util.Set<java.lang.String> bugTypeSet) {
        org.dom4j.Element root =
          document.
          getRootElement(
            );
        for (java.lang.String bugType
              :
              bugTypeSet) {
            edu.umd.cs.findbugs.BugPattern bugPattern =
              edu.umd.cs.findbugs.DetectorFactoryCollection.
              instance(
                ).
              lookupBugPattern(
                bugType);
            if (bugPattern ==
                  null) {
                continue;
            }
            org.dom4j.Element details =
              root.
              addElement(
                "BugPattern");
            details.
              addAttribute(
                "type",
                bugType).
              addAttribute(
                "abbrev",
                bugPattern.
                  getAbbrev(
                    )).
              addAttribute(
                "category",
                bugPattern.
                  getCategory(
                    ));
            details.
              addElement(
                "ShortDescription").
              addText(
                bugPattern.
                  getShortDescription(
                    ));
            details.
              addElement(
                "Details").
              addCDATA(
                bugPattern.
                  getDetailText(
                    ));
        }
    }
    @edu.umd.cs.findbugs.annotations.SuppressFBWarnings("DM_EXIT") 
    public static void main(java.lang.String[] args)
          throws java.lang.Exception { if (args.
                                             length !=
                                             2) {
                                           java.lang.System.
                                             err.
                                             println(
                                               "Usage: " +
                                               edu.umd.cs.findbugs.AddMessages.class.
                                                 getName(
                                                   ) +
                                               " <input collection> <output collection>");
                                           java.lang.System.
                                             exit(
                                               1);
                                       }
                                       edu.umd.cs.findbugs.DetectorFactoryCollection.
                                         instance(
                                           );
                                       java.lang.String inputFile =
                                         args[0];
                                       java.lang.String outputFile =
                                         args[1];
                                       edu.umd.cs.findbugs.Project project =
                                         new edu.umd.cs.findbugs.Project(
                                         );
                                       edu.umd.cs.findbugs.SortedBugCollection inputCollection =
                                         new edu.umd.cs.findbugs.SortedBugCollection(
                                         project);
                                       inputCollection.
                                         readXML(
                                           inputFile);
                                       org.dom4j.Document document =
                                         inputCollection.
                                         toDocument(
                                           );
                                       edu.umd.cs.findbugs.AddMessages addMessages =
                                         new edu.umd.cs.findbugs.AddMessages(
                                         inputCollection,
                                         document);
                                       addMessages.
                                         execute(
                                           );
                                       org.dom4j.io.XMLWriter writer =
                                         new org.dom4j.io.XMLWriter(
                                         new java.io.BufferedOutputStream(
                                           new java.io.FileOutputStream(
                                             outputFile)),
                                         org.dom4j.io.OutputFormat.
                                           createPrettyPrint(
                                             ));
                                       writer.
                                         write(
                                           document);
                                       writer.
                                         close(
                                           );
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("H4sIAAAAAAAAALV7a8zk1nXY7EralVaPXa1sWVEteWWt00hjf+QMOa/Idkxy" +
       "hhzOg+QMOS+6zmcOX8M3h48hh46cyEBjw0EctZUTJ3H0y0lqw7GDoEYCtAlU" +
       "JG3svNoERmOnqJ0WBeLENWqnSPpw6/SS873321VUNx/Au5z7OPecc8/r8pz9" +
       "9DdK94RBqex79la3vWhPTaM9067tRVtfDfd6gxonBaGqELYUhgLo25ff/MtX" +
       "//rbL66uXSxdEkuPSK7rRVJkeG44VkPP3qjKoHT1uLdjq04Yla4NTGkjQXFk" +
       "2NDACKPnBqX7TyyNSjcHhyhAAAUIoAAVKEDY8Syw6EHVjR0iXyG5Ubguvb90" +
       "YVC65Ms5elHpqdNAfCmQnAMwXEEBgHBv/nsKiCoWp0HpxhHtO5pvIfijZeil" +
       "n/rBa79yV+mqWLpquHyOjgyQiMAmYukBR3WWahBiiqIqYulhV1UVXg0MyTay" +
       "Am+xdD00dFeK4kA9YlLeGftqUOx5zLkH5Jy2IJYjLzgiTzNUWzn8dY9mSzqg" +
       "9dFjWncUknk/IPCKARALNElWD5fcbRmuEpXedHbFEY03+2ACWHrZUaOVd7TV" +
       "3a4EOkrXd2dnS64O8VFguDqYeo8Xg12i0uO3BZrz2pdkS9LV/aj02Nl53G4I" +
       "zLqvYES+JCq9/uy0AhI4pcfPnNKJ8/kG8/aPvM/tuhcLnBVVtnP87wWLnjyz" +
       "aKxqaqC6srpb+MCzg5+UHv31D10slcDk15+ZvJvzqz/0rXe99clXPr+b8/fO" +
       "mcMuTVWO9uVPLB/6wzcSz7TuytG41/dCIz/8U5QX4s8djDyX+kDzHj2CmA/u" +
       "HQ6+Mv7Xix/5lPr1i6UrdOmS7NmxA+ToYdlzfMNWA0p11UCKVIUu3ae6ClGM" +
       "06XL4H1guOqul9W0UI3o0t120XXJK34DFmkARM6iy+DdcDXv8N2XolXxnvql" +
       "UukyeEoPgOetpd1f8W9UmkIrz1EhSZZcw/UgLvBy+kNIdaMl4O0K0oAwLWM9" +
       "hMJAhgrRUZUYih0FksPjQaAuQzUMgQiEe/kk/+8McprTdC25cAGw+41nld0G" +
       "etL1bEUN9uWXYrzzrc/s/+7FI+E/4AbQHbDRHthoTw73DjfaO7FR6cKFAv7r" +
       "8g13RwkOwgIqDYzdA8/w7+m990NvvgvIkJ/cDbiYT4Vub3OJYyNAF6ZOBpJY" +
       "euVjyQvTH4Yvli6eNp45kqDrSr6cy03ekWm7eVZpzoN79YNf++vP/uTz3rH6" +
       "nLLGB1p968pcK998lp2BJwNOBeox+GdvSJ/b//Xnb14s3Q1UHZi3SALiCCzH" +
       "k2f3OKWdzx1aupyWewDBmhc4kp0PHZqnK9Eq8JLjnuKcHyreHwY8vj8X10fB" +
       "0zqQ3+LffPQRP29ft5OL/NDOUFFY0nfw/s996Q/+HCnYfWh0r55wY7waPXdC" +
       "0XNgVwuVfvhYBoRAVcG8//Ax7p989BsffHchAGDG0+dteDNvCaDg4AgBm//h" +
       "59df/upXPvHFi8dCEwFPFy9tQ06PiMz7S1fuQCTY7XuP8QGGwgYqlUvNzYnr" +
       "eIqhGdLSVnMp/d9X31L53H/5yLWdHNig51CM3vrqAI77vwcv/cjv/uB/f7IA" +
       "c0HOHdUxz46n7azfI8eQsSCQtjke6Qt/9MRP/7b0c8COAtsVGplamKOLBQ8u" +
       "FpS/Hrj68xQSj/UTCB7MvO4F+p7iOai51/bk2AHWpDh5qJjwbNHu5VwrNigV" +
       "Y7W8eVN4UoNOK+mJqGRffvGL33xw+s3f+FZB8umw5qTADCX/uZ2M5s2NFIB/" +
       "w1lz0ZXCFZiHvsL8g2v2K98GEEUAUQa+PGQDYKTSU+J1MPuey3/yL3/z0ff+" +
       "4V2li2Tpiu1JCikVmlq6D6iIGq6AfUv9H3jXTkKSe0FzrSC1dAvxO8l6rPiV" +
       "B4bP3N5IkXlUcqznj/0v1l5+4D/9j1uYUJinc5zxmfUi9OmPP0688+vF+mM7" +
       "ka9+Mr3VcIMI7nht9VPOX11886V/dbF0WSxdkw/Cw6lkx7n2iSAkCg9jRhBC" +
       "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" +
       "uqi0d7sKspMAbgrgrQ1WAfV8aLfacPXi");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("UA8O7/pR71ExQ1R62+1gF8mPMzUPeQ2W7SVqgHuxq+RgnzxjC2LfPzlaiMED" +
       "/69i8P6g9Na/BeuOKD+049cLcT+RccpzICcHfbAlMcB4fl9YcJ39KTamMXzQ" +
       "KQQszx9e6JyTA9tlUAuK3n0qm1xKi86P3sEI/UrevAjASYqSp/KlSNW9wNgZ" +
       "ow8fW55/9N1aHhQ8Lx5Q+uL/V8uT//zpYsK/uAOhv5E3vxoB57Qj1FNuofHX" +
       "vlsaG+D5mQMaf+bviMbP34HG38mb34xKD+1o5KQoUgP3LJm/9V2QWaScnwXP" +
       "pw7I/NRrILPIN+8ip1fxJLezS0D1i5qVnTN4+Ree/oMffvnp/1hUbNxrhEDZ" +
       "sEA/p3DxxJpvfvqrX/+jB5/4TFEadeRArpyt+Ly1oPNUneZJ6wFQfl3OhMdz" +
       "3A+4cmFnPfZvLQL4/hvrWAqNdexF6vftKotu7DLgN4rKghu7hPa733NjyLY7" +
       "+ww27PA33nHDVZODkfdJzvL5d+/t7b3nuWeAJSqU/hYO5r+LVOiXDksA/v2r" +
       "HclRHHvJVl09Wp0Xjdxl7AoD/vjAEeZbnqkReuTYLBG256q5GTwc2xXqGd7e" +
       "UakuGEzPRf79O+SLzU5ExedJzUkF+Podxr6RN1+LSvfIOV47Mu4w/Zvp7t8v" +
       "3kZIb6W3k8qqnwe9xbq/zJt/AyI4RzLcMxr4b09r4ANHGngEtnpeqdWJsBp4" +
       "fd8P1DAk8ZkUuEAuwtuBjA6qGIBaoa9aWZWXjqsHZTqF1uzLD9y/+Mvfev5/" +
       "lnYpegDqhAocF9k8lu/6FHg+eaACnzxrGPIavPOL2niAvq1GnpsHO8/+12eu" +
       "vf0Xf/aniu0uqzt8cghYUb3WeE0kHFYg7cvD0QutN374z/6kCBzvLcqRwIwC" +
       "7q2lQ3nznRRE5u3hfmdOC4WSpefWbgGHcqIkNcfwsVtq23f12PJnXr567xte" +
       "nvzxzvQc1kzfB9DRYts+Wcl04v0SOGXNKNC6b4dcofMXLgPRO0dGIgDs4DXH" +
       "9cKl3ewrUenK8eyodFE+NfxgfgnZDQMlB+3JwWugCwzmrw8XR/mZ9MLpO+eR" +
       "XF9/Nc9y4pr69G0D2mG8+48D+/JnX+4x7/tW/ed39aAg+MqyHAqIGC/vSlOP" +
       "LpNP3RbaIaxL3We+/dAv3/eWw4vvQzuEj93VCdzedL6cdhw/Ksols197wz97" +
       "+y++/JWi+Of/ApWla0PPMQAA");
}
