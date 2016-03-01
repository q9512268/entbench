package edu.umd.cs.findbugs.graph;
public abstract class AbstractDepthFirstSearch<GraphType extends edu.umd.cs.findbugs.graph.Graph<EdgeType,VertexType>, EdgeType extends edu.umd.cs.findbugs.graph.GraphEdge<EdgeType,VertexType>, VertexType extends edu.umd.cs.findbugs.graph.GraphVertex<VertexType>> implements edu.umd.cs.findbugs.graph.DFSEdgeTypes {
    public static final boolean DEBUG = false;
    private final GraphType graph;
    private final int[] colorList;
    private final int[] discoveryTimeList;
    private final int[] finishTimeList;
    private final int[] dfsEdgeTypeList;
    private int timestamp;
    private final java.util.LinkedList<VertexType> topologicalSortList;
    private edu.umd.cs.findbugs.graph.VertexChooser<VertexType> vertexChooser;
    private edu.umd.cs.findbugs.graph.SearchTreeCallback<VertexType> searchTreeCallback;
    protected static final int WHITE = 0;
    protected static final int GRAY = 1;
    protected static final int BLACK = 2;
    public AbstractDepthFirstSearch(GraphType graph) { super();
                                                       this.graph = graph;
                                                       int numBlocks = graph.
                                                         getNumVertexLabels(
                                                           );
                                                       colorList = (new int[numBlocks]);
                                                       discoveryTimeList =
                                                         (new int[numBlocks]);
                                                       finishTimeList = (new int[numBlocks]);
                                                       int maxEdgeId = graph.
                                                         getNumEdgeLabels(
                                                           );
                                                       dfsEdgeTypeList = (new int[maxEdgeId]);
                                                       timestamp = 0;
                                                       topologicalSortList =
                                                         new java.util.LinkedList<VertexType>(
                                                           ); }
    protected abstract java.util.Iterator<EdgeType> outgoingEdgeIterator(GraphType graph,
                                                                         VertexType vertex);
    protected abstract VertexType getTarget(EdgeType edge);
    protected abstract VertexType getSource(EdgeType edge);
    protected VertexType getNextSearchTreeRoot() { for (java.util.Iterator<VertexType> i =
                                                          graph.
                                                          vertexIterator(
                                                            );
                                                        i.
                                                          hasNext(
                                                            );
                                                        ) {
                                                       VertexType vertex =
                                                         i.
                                                         next(
                                                           );
                                                       if (visitMe(
                                                             vertex)) {
                                                           return vertex;
                                                       }
                                                   }
                                                   return null;
    }
    public java.util.Collection<VertexType> unvisitedVertices() {
        java.util.LinkedList<VertexType> result =
          new java.util.LinkedList<VertexType>(
          );
        for (java.util.Iterator<VertexType> i =
               graph.
               vertexIterator(
                 );
             i.
               hasNext(
                 );
             ) {
            VertexType v =
              i.
              next(
                );
            if (getColor(
                  v) ==
                  WHITE) {
                result.
                  add(
                    v);
            }
        }
        return result;
    }
    public void setVertexChooser(edu.umd.cs.findbugs.graph.VertexChooser<VertexType> vertexChooser) {
        this.
          vertexChooser =
          vertexChooser;
    }
    public void setSearchTreeCallback(edu.umd.cs.findbugs.graph.SearchTreeCallback<VertexType> searchTreeCallback) {
        this.
          searchTreeCallback =
          searchTreeCallback;
    }
    public edu.umd.cs.findbugs.graph.AbstractDepthFirstSearch<GraphType,EdgeType,VertexType> search() {
        visitAll(
          );
        classifyUnknownEdges(
          );
        return this;
    }
    public boolean containsCycle() { for (java.util.Iterator<EdgeType> i =
                                            graph.
                                            edgeIterator(
                                              );
                                          i.
                                            hasNext(
                                              );
                                          ) {
                                         EdgeType edge =
                                           i.
                                           next(
                                             );
                                         if (getDFSEdgeType(
                                               edge) ==
                                               BACK_EDGE) {
                                             return true;
                                         }
                                     }
                                     return false;
    }
    public int getDFSEdgeType(EdgeType edge) {
        return dfsEdgeTypeList[edge.
                                 getLabel(
                                   )];
    }
    public int getDiscoveryTime(VertexType vertex) {
        return discoveryTimeList[vertex.
                                   getLabel(
                                     )];
    }
    public int getFinishTime(VertexType vertex) {
        return finishTimeList[vertex.
                                getLabel(
                                  )];
    }
    public int[] getFinishTimeList() { return finishTimeList;
    }
    public java.util.Iterator<VertexType> topologicalSortIterator() {
        return topologicalSortList.
          iterator(
            );
    }
    private void visitAll() { for (; ; ) {
                                  VertexType searchTreeRoot =
                                    getNextSearchTreeRoot(
                                      );
                                  if (searchTreeRoot ==
                                        null) {
                                      break;
                                  }
                                  if (searchTreeCallback !=
                                        null) {
                                      searchTreeCallback.
                                        startSearchTree(
                                          searchTreeRoot);
                                  }
                                  java.util.ArrayList<edu.umd.cs.findbugs.graph.AbstractDepthFirstSearchVisitor> stack =
                                    new java.util.ArrayList<edu.umd.cs.findbugs.graph.AbstractDepthFirstSearchVisitor>(
                                    graph.
                                      getNumVertexLabels(
                                        ));
                                  stack.
                                    add(
                                      new edu.umd.cs.findbugs.graph.AbstractDepthFirstSearchVisitor<GraphType,EdgeType,VertexType>(
                                        outgoingEdgeIterator(
                                          this.
                                            graph,
                                          searchTreeRoot),
                                        searchTreeRoot));
                                  setColor(
                                    searchTreeRoot,
                                    GRAY);
                                  setDiscoveryTime(
                                    searchTreeRoot,
                                    timestamp++);
                                  while (!stack.
                                           isEmpty(
                                             )) {
                                      edu.umd.cs.findbugs.graph.AbstractDepthFirstSearchVisitor<GraphType,EdgeType,VertexType> visit =
                                        stack.
                                        get(
                                          stack.
                                            size(
                                              ) -
                                            1);
                                      if (visit.
                                            hasNextEdge(
                                              )) {
                                          EdgeType edge =
                                            visit.
                                            getNextEdge(
                                              );
                                          VertexType succ =
                                            getTarget(
                                              edge);
                                          int succColor =
                                            getColor(
                                              succ);
                                          int dfsEdgeType =
                                            0;
                                          switch (succColor) {
                                              case WHITE:
                                                  dfsEdgeType =
                                                    TREE_EDGE;
                                                  break;
                                              case GRAY:
                                                  dfsEdgeType =
                                                    BACK_EDGE;
                                                  break;
                                              case BLACK:
                                                  dfsEdgeType =
                                                    UNKNOWN_EDGE;
                                                  break;
                                              default:
                                                  assert false;
                                          }
                                          setDFSEdgeType(
                                            edge,
                                            dfsEdgeType);
                                          if (visitMe(
                                                succ)) {
                                              if (searchTreeCallback !=
                                                    null) {
                                                  searchTreeCallback.
                                                    addToSearchTree(
                                                      getSource(
                                                        edge),
                                                      getTarget(
                                                        edge));
                                              }
                                              stack.
                                                add(
                                                  new edu.umd.cs.findbugs.graph.AbstractDepthFirstSearchVisitor<GraphType,EdgeType,VertexType>(
                                                    outgoingEdgeIterator(
                                                      this.
                                                        graph,
                                                      succ),
                                                    succ));
                                              setColor(
                                                succ,
                                                GRAY);
                                              setDiscoveryTime(
                                                succ,
                                                timestamp++);
                                          }
                                      }
                                      else {
                                          VertexType vertex =
                                            visit.
                                            getVertex(
                                              );
                                          setColor(
                                            vertex,
                                            BLACK);
                                          topologicalSortList.
                                            addFirst(
                                              vertex);
                                          setFinishTime(
                                            vertex,
                                            timestamp++);
                                          stack.
                                            remove(
                                              stack.
                                                size(
                                                  ) -
                                                1);
                                      }
                                  }
                              } }
    private void classifyUnknownEdges() {
        java.util.Iterator<EdgeType> edgeIter =
          graph.
          edgeIterator(
            );
        while (edgeIter.
                 hasNext(
                   )) {
            EdgeType edge =
              edgeIter.
              next(
                );
            int dfsEdgeType =
              getDFSEdgeType(
                edge);
            if (dfsEdgeType ==
                  UNKNOWN_EDGE) {
                int srcDiscoveryTime =
                  getDiscoveryTime(
                    getSource(
                      edge));
                int destDiscoveryTime =
                  getDiscoveryTime(
                    getTarget(
                      edge));
                if (srcDiscoveryTime <
                      destDiscoveryTime) {
                    dfsEdgeType =
                      FORWARD_EDGE;
                }
                else {
                    dfsEdgeType =
                      CROSS_EDGE;
                }
                setDFSEdgeType(
                  edge,
                  dfsEdgeType);
            }
        }
    }
    public void setColor(VertexType vertex,
                         int color) { colorList[vertex.
                                                  getLabel(
                                                    )] =
                                        color;
    }
    protected int getColor(VertexType vertex) {
        return colorList[vertex.
                           getLabel(
                             )];
    }
    protected boolean visitMe(VertexType vertex) {
        return getColor(
                 vertex) ==
          WHITE &&
          (vertexChooser ==
             null ||
             vertexChooser.
             isChosen(
               vertex));
    }
    private void setDiscoveryTime(VertexType vertex,
                                  int ts) {
        discoveryTimeList[vertex.
                            getLabel(
                              )] =
          ts;
    }
    private void setFinishTime(VertexType vertex,
                               int ts) { finishTimeList[vertex.
                                                          getLabel(
                                                            )] =
                                           ts;
    }
    private void setDFSEdgeType(EdgeType edge,
                                int dfsEdgeType) {
        dfsEdgeTypeList[edge.
                          getLabel(
                            )] =
          dfsEdgeType;
    }
    public static final java.lang.String jlc$CompilerVersion$jl7 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl7 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl7 =
      ("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" +
       "gfuiP/HXZ7d7728gLWJGbDvehf4fPhurJmhPAAA=");
    public static final java.lang.String jlc$CompilerVersion$jl5 =
      "2.7.0";
    public static final long jlc$SourceLastModified$jl5 =
      1456688264000L;
    public static final java.lang.String jlc$ClassType$jl5 =
      ("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" +
       "qGzS3dbGUaFzsUowgeWAcHe123qD3vHglxcf/eOf3Lrr+/Lfq6y994P/+p8v" +
       "f+8HD05sZj561X7iyTbbDc2cwfdkyUfSU/7pGaPkLYg/+vQ7fvYT73hyS9WD" +
       "p7fmskjmJ3/j//3S5Q///s+fsfdzx2wrjdwU5Zz87iz5wJar7z13in3PkQI8" +
       "mOW+GlzVnQJUr1KAQn7z8bPFegCI8ANrBcSSZX44h/8RIB7j0Euv7hH3774O" +
       "4uo74urnEPepc4jLbj95ii4wk20vyFz8C2JzoDp5gL/VhKc//ugvv+vpR/9X" +
       "rup3WiGYc0hgnLE9fKLNXzzz5a/+6j0v/1S+j3QU4d29v69+9bb5qd3wvQg6" +
       "2zkp3Aeuu3bsuGs7Q6Sb4z7lAaoW7p4xHPpmz13nWz346G6qZD8/GhVusXaP" +
       "WC4XjndRcq3Ikp8+FPjPXSDw150S+O225hrbLebPZcln/fSo/4Pk2LcH/tdD" +
       "x1YOsz1XyzYbDsu2W6WWd/noKQsoTK+i9MLtg34u2uNl4gvv+dOH+Teab7uO" +
       "PdJX7qncfpc/0X/m5zvfqHzgoHDL0aJx1SOY042e2NvFCbQoDlz+1ILx8i3z" +
       "c/5tOZ8lr8lZfIHT8aULyv5blvwCMBRKxuqtZC6o/qtpYc+OfPo67cjrwQXv" +
       "Jg58jh359Wu2Iw+oVqh4Ky1Y85aT70jmEPZo/I3rpDGLu1o7Glvn0Pg/r5nG" +
       "e8Hss0LzIgJ/9zoJfB24ntgR+MQ5BP7hNRN4n6qHh278eRR+5dopfH6W+zC4" +
       "3rCj8A3nUPinZ1OYe+KfPFopIsA3MEUc/8h2nCDrq9fJuIyUN+3IetM5ZH3t" +
       "mhn3UOSBOe0ZliLbnBdE+XqWlX3LsTtVONudevis7a7L+bNs3z+Klc98MpSV" +
       "/f21h8ZfNxFZ6zy6+vvM0buU79Naee5+3LMnlL+8Tl2pgQvZCQU5WyiXbr0W" +
       "XblnlUeAmOl5oRact6vymt1Qu83Zt97MXQ/xJAGHa/dzPMKRtrz2/J2VU60y" +
       "ft5zXXsrr8yKycLVuxeXnpdL5/lHynLpnpsYil964KzQ+2Ltu3TbdWrfG8GF" +
       "7WBh52jfS69F+x4M86e62eM7TLbtmawszlPB4m68l2xVULmZCsJdRcWhHv5L" +
       "DHOkjN90vjJe3TTj8WPXpZGPZcX9QxYe/mb9vDqX2KPHGvnYzdTI130dGvmy" +
       "a9fIfM/y8d1kO5x0F24EdIEnb2jBg3/wox/723c/2TzIHoDuNgKCk1uZgzg7" +
       "qfTdz/zAy5/3wd9/X/6A+JBjlXO2CsDi6wdeBHREyx8lfujU4nfbmOzy+BmL" +
       "8qXqdeLNvJnBDu/gDLxZn7WdFC694fx9jUutq6m8tcMi0llEvvHrEAq3I5K7" +
       "gMjMTbiEXx+Rt6E0gvXOopJ4VirzLgABoJfKZfhyKWvVP3/4bVh2evgXzW3l" +
       "scPtHTBPQhD8PDa34cOpfEKLtmfAThN5GDZeA5HhqefDtOcaT7zvK0/90vc9" +
       "+mWgt9Sh3mYQ6kDc3OOzv3pz9o94fXgezvBwXhwoGi2HUT8/cKCpR5D2Yt1b" +
       "QeTz9UOKXjoha2EXOfyjy0p7MhLE6bRYHdkUNhxNEG++Jqsswo+aXmyaxGiN" +
       "jGbj3thsGzhFcMtevcLBy4bTcCee1zUa09pEbUkKK3RUvOwKKstqhDudTIWx" +
       "2pnOS0Ejtmo1yIOMOTSvTIjSRJuExTkzn8eNFtwSIbE84YaaSw31caMZNWAY" +
       "rsJVfRXHxWJxOQ9qfdaZL8dcw+51B2obieRRlRZgVhXagl/2k9GgV+KbboAP" +
       "a0scarnJSF1Zfcz1KX/SMoJpj2hzPjuVuL5cmfHUgO+YIuctuTIndvs91Re5" +
       "KSMgEtnjlstZuW/L8qanLvDxNLApC7dnHh6NvCWLe6I20dqUKLdGkuewMrEQ" +
       "eInDqAEc050eulj1YhtdQp4whkRnnLhjnvBb8pQV2EaTQz22a4ZLiiP4sdwZ" +
       "jKmx5tgKazA9coRaNt1p1Hv0oGvGba7RQzSsImkBs2otxWqzbFQwbIF7Pqjl" +
       "BlOpRPG4kcq9xTr0VdfHuIozXdOc01u4ncra5wW2Vh52W6iPtr1yTIvLRDMC" +
       "nxg5FTlJ1OWcFRa2nCIE2w9XU47wR6bMa3w7nPVhdsS6E63DE8mwxSxsdzhN" +
       "irTWXw9gODJHkNy3hEgcLGNWQJM6aeLEqNEbzRBqzK2mveVAES1huZ6VeyxS" +
       "QStczwgpTQ7jhugP5ksFdwwy7cCoMbWkaCmnDLaOR10Ic6YLwHlsCuvC2mwx" +
       "UKeFjfEhgzTWWk9UWhZWVFAjHiVtAQrxUjtWfdLi3a4P6B8MJJ2S9NQWkAHN" +
       "+TgPE7NhUPNHSEfmxsuSiXF9YU7KaGPJmwIpDxFkuRR4RowImhhixa7T5eCy" +
       "h8uNRjDZdJdG2TY6KEXxQizHqb1Ae0K5zIWh69ZgiZ7Bi0bEd0WgFZJSSjh8" +
       "My8qAlKqCuPSOF7yIuI6CKcozKbViDdtf7pZtU28bQ9t1Z7Eqh7M7fpadPn5" +
       "Bm436puloOnr6jJcLHS524LEMbRaluquQ1tVRJqObWJRJmvtEJ7SndWES5cb" +
       "eYYki2YyDmdttNdeN4qxUy5vSgudHTl1ubJgiRHncLwnSBWPGgzWYDpPOMym" +
       "CNkQ5LU4B5oeOtNxdWH3avOm5wMbo1UjzeVmnEhgqiR6LgYZWre4RCizZyhw" +
       "LApuhVb8ZCJvio2NLFDdgZgu+nbCJqum3O8R+Hw1CjhuYVk41eMth1VtEYUC" +
       "oTumUi2hJahk6L0yFVNySgwIbtBXZVaifIpKrZ41NScdkSNVsuIu0XFpwtJ+" +
       "n4uYImEuQsEDXlaHgpBWz4bqa3U6JTeYGGFdtt2Txw1+0W1PIwL0g3FltrXm" +
       "x7OgWcf6rVWRX5r2AE9ra85U0SoC8Wq34w3YqDkIhs3OCq5TvT7XcLvmvNb2" +
       "EDxK8MjA+k3drJOiqsUu6cIYNVqtuLHkIfqyWa/QeDCwQzwJyDWj9ayKFMfg" +
       "v1jDfMbq9RxiNh9gSKRJ1FwYlhcrxcehpDmrJBPCCdLFZrb0SNqVl92EQpZF" +
       "uaRpVmSvPWwhzWs2XilFnU4ob6JGF6oF1nBSX7f6tahcVSOoKksmVaLRiVRH" +
       "nURZBNpc4/WBRldnI9Iqj+HJ3Gg2meqsPgiFNSEVhZQIE4WLWTOyQ7/KtEsW" +
       "M3CxhdrQAzlyQ7xILJI6MW4vjekYyBduS9JCbsvxcEWN0KRa6TnmiBt3WGOC" +
       "w7A4HtO2MixF0kzlE67c6aq8ktQVsehvbL1sNeRRyfeHdXU51OKZaSybU4LU" +
       "HHgCQSLcbJkKGtI8NRn0i9ZI7jGDZYeYR0raLIvmsgKsObCrsO7oMByUdLg8" +
       "J1V0utww5DJEYX46R50u3kOKclGr6Btg2PRY29hhg3cIka/yWLPOlp0R1yzZ" +
       "dYRiRpWiO9b6iEeF6NgbzISg5KB66LfCCJstSNSCwDJTRUQSiuOxvKyRmGKk" +
       "5aEVemycNBetKbeE4bokrfxg4Iysbrw2p444F+MGp0o0r/nLOdatNU0NavVK" +
       "cNrkYU8qI8V1iXKKojNcDJwJ0xL7qlJeK1qnNGaKTDptrkC0AFebXaIo11d+" +
       "v8/pg4EeF/WYrFZKtea4xPZGPTtBDGMZYL2Eb09qw3G7gsYeXBvXpkIXr4gk" +
       "tVQQXRqHm/GkjVSmy1qdWRv1SqMVtTCjFeBpfRQtrKUQizy27GzU2Qzm1sI0" +
       "onxt7fIw5/O8aq4jpS4FtVQvltc1Ihw12zTbn67ECocBi+rTFD4rmTi+cGSu" +
       "iFNjFFNAQ68xdJVKFW76jdiPxhGwivN1y1W4EmNW0HGNCNBpG2XauFWR116t" +
       "H6BIGM4WlfVqKSu6UixZRIoLUNWjUXEVA4sAFG7TMMaaNpmSvqhCYRFFmwFe" +
       "XXO67jd5d0ihyXAlktJcqTITWVSam2YZ68jJzOmWFTEyBbRsyrOZ7FXqYqfX" +
       "6PJG0XOGZZKP2So3qEf00GiPFdPolV1kbPITps/CCl51SnAgbqZlAm4j0+pq" +
       "VbTq2Lg4bsFQUu2oYrnKYNqojkXeiuXUcmkGp1pEIkowK4qcLEmUPGCSDS6X" +
       "w5FdnahkOvCX035vmfY4Ytzy/JAgE7XSlzq2FbVVjZu00UbaSdV6k63XIGhN" +
       "KnAvwPCkgRKzxaaksi0YeEuNjScK7f4ySXSa6bcaGk8yEZ9siKU63MwYglzi" +
       "fLOmMv1NuIFDJ0QUxeiPio1lhVsY1djWUluix23InnMR1EzFIT9YNRpWl52V" +
       "0IQKWRkdjtgF3dvgi0hiNg5S0XXc5nsdOvJ5f10eSqOJpS31lcf4/fGoqA0m" +
       "61RNxhuWM2YQbkhex7PW9VmnNu3Ba35mb+QeqW2WdrPtjpl4OZsj3bQu9tvj" +
       "WG6UpYDWynRYHxUNVXAYcS6tDVcW1VFziYxU0a6CKTgmPXvRxDtcIs2EkSzy" +
       "SqqqiwAb2Gir1NsU+7jcrozXqhW4nYiVguq83VSmYtXgFH+qlNJImy7T1B7C" +
       "ogE1VvR8tGmXvEY7csoeINyKam1WGuvjEfC0qG64UXqcXizB7doMg5qlZANt" +
       "2FmxF1P6Rp8ACy9IEj2xcQaVEIxR7KGguH2/OZzS5U2Hh1x8FZJRC69v6D6s" +
       "r9erBtxoyLDsmTNpTHNcuEh7VX/Njp3BMGoYAk2l0WQmg1Vt015ZJoRUm2ZM" +
       "wx2sqaEdMbVlf1XG+oN+v8mNeEdLXYoe6bRpw5M12dRoLEzFmdBVV40qXeqw" +
       "QwKrdqVSyIeIsC42kmkD627SarHcIMerUgduxxuOR+QNSzJNsi14RUyfzSms" +
       "xapAMmlt1AoivK0yPDVy+HWzQVaX/RpFBEx7NjXHVqnYhvSaTk36leJqojTw" +
       "YJYo3WKtURSZHuwVId2m6ou4liSyqveL/bXmeutFucICZ8PXIcWrVINlOiBX" +
       "NaoTL3FWmI5K8KRbppb2dFixcEOZWlPC4foQp7SZ0Xrqmit6qrilOhuhgV6c" +
       "Mr05sWkkUMLPUFmPioRo8P3AnNH4BrVWSXOAQi4D9ZBWEdaleAIVzSS205IA" +
       "1WuaTFfNlVZsIWw4xxW8LEx0kndqs0qwWXhNacVOktEwaAC1Vdpi0rCqM3PU" +
       "dJkkGNCQVe5zQURF8pxs0THOIrM2Nqgs");
    public static final java.lang.String jlc$ClassType$jl5$1 =
      ("JgO5PyKLgtie91zgtM/c0WwjtYeyVjesRnmmNuZg4mL0UhlI46gj9pQZPm6g" +
       "TGJMYk4xMa09GQ8DVBDYHrcgfdN3A7UHrYrFQatvK1K/NkBNvdZcmOX5fAqj" +
       "Jcaauv0SPqmNS22KE+RhZWj0CaNOcazSn7YpROijC2dC24361Ju4K2QQiUPO" +
       "5jUB1cUUBDEpWy0H2obkMI5uMouhn6gIHyxka7gO9FnE62FRI+a6V5zia3Yt" +
       "+tMyDMXyzLRXlWYfoZm6Ji2q/ZLU081pOmgWeYocrGOPKM3YZhC1K/VaLeyU" +
       "SLI8jvrN5bAIyeQEqvLNpAyM5zBkU6saURq9aUVeX1zRVgyj9TYy2QSVohoT" +
       "qFC1yg6IJwJ3UKpNK7xX0vAqv4kCtmx2CF+2R6ohKrM+Ca8Ez5KNqYjRMU2U" +
       "42abSGY4q9BoF65obDtRVkUXuFZNqN5WGytBWjqU3PFkbFSGN0jXapgpIYYQ" +
       "HC/caALVNmlzOoyqIUmW1Am2Ks8jY0WJWn9uFoNSkUy9jlxbd8Vlx9LQSXPE" +
       "+EtjMF9VqxvIFVur8qbqCJUlvhknqFFZTjoMvhFmG1khqxDs+ZLvz2GkFpn2" +
       "eEkiOqvJ2qDtDXHSVto+M4lpRC8VlRU0T824WgQeMTVlmvDAGdfq9JzmuUFj" +
       "GThrqC1iFXRZD4O2liyThU9oGjnBlETjoihiIU2KS1oix7pEuJu6BzzrOWLJ" +
       "FJ8mqT+V+TajyeRoXberpheN+xMsJHS0Vh9XIF1Oiqs5pwtp0Hc2MD4cbYrM" +
       "ul9DhoK2DvAZ42/kWGYhKa2R9HygFONB3AwJEa23VGXm18Z1Q6X0oT3UlG5l" +
       "4QoNJCgtTXqwxFyXdKQhsanwpK/AlKOskZFSW6yaM4GR6pSlo2zX8+RebYKo" +
       "E2gxXKmSIrXlaTjv0KwFkbHWcqXiZKgHRBw1yeoKbgnzMBCLc3vA41O8jKts" +
       "ENoUE6bIiJ64QtpcVLR5B61JAanVK9SKXXTtboXEgzLR64UdfG37EIJqZmm+" +
       "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");
}
