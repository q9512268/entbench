package edu.umd.cs.findbugs.graph;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList; 

public class AbstractDepthFirstSearchVisitor<GraphType extends Graph<EdgeType, VertexType>, EdgeType extends GraphEdge<EdgeType, VertexType>, VertexType extends GraphVertex<VertexType>>
 {
        private final VertexType vertex;

        private final Iterator<EdgeType> outgoingEdgeIterator;

        public AbstractDepthFirstSearchVisitor(Iterator<EdgeType> outgoingEdgeIterator, VertexType vertex) {
            if (vertex == null) {
                throw new IllegalStateException();
            }
            this.vertex = vertex;
            this.outgoingEdgeIterator = outgoingEdgeIterator;

            // Mark the vertex as visited, and set its timestamp
        }

        public VertexType getVertex() {
            return vertex;
        }

        public boolean hasNextEdge() {
            return outgoingEdgeIterator.hasNext();
        }

        public EdgeType getNextEdge() {
            return outgoingEdgeIterator.next();
        }
    }

