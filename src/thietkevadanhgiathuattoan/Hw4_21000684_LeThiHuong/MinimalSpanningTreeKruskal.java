package thietkevadanhgiathuattoan.Hw4_21000684_LeThiHuong;

import java.util.*;

public class MinimalSpanningTreeKruskal {
    static class Graph {
        static class Edge implements Comparable<Edge> {
            int src, dest, weight;

            // Comparator for sorting edges based on their weight
            public int compareTo(Edge compareEdge) {
                return this.weight - compareEdge.weight;
            }
        }

        // Subclass to represent a subset for union-find
        static class subset {
            int parent, rank;
        }
        int V, E;
        Edge[] edge; // Collection of all edges

        // Constructor
        Graph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[E];
            for (int i = 0; i < e; ++i)
                edge[i] = new Edge();
        }

        // A utility function to find set of an element i
        int find(subset[] subsets, int i) {
            if (subsets[i].parent != i)
                subsets[i].parent = find(subsets, subsets[i].parent);
            return subsets[i].parent;
        }

        // A function that does union of two sets of x and y
        void Union(subset[] subsets, int x, int y) {
            int xRoot = find(subsets, x);
            int yRoot = find(subsets, y);

            // Attach smaller rank tree under root of high rank tree
            // (Union by Rank)
            if (subsets[xRoot].rank < subsets[yRoot].rank)
                subsets[xRoot].parent = yRoot;
            else if (subsets[xRoot].rank > subsets[yRoot].rank)
                subsets[yRoot].parent = xRoot;
            else {
                subsets[yRoot].parent = xRoot;
                subsets[xRoot].rank++;
            }
        }

        // The main function to construct MST using Kruskal's algorithm
        void KruskalMST() {
            Edge[] result = new Edge[V]; // This will store the resultant MST
            int e = 0; // An index variable, used for result[]
            int i = 0; // An index variable, used for sorted edges
            for (i = 0; i < V; ++i)
                result[i] = new Edge();
            // Step 1: Sort all the edges in non-decreasing order of their weight. If we are not allowed to change the given graph, we can create a copy of array of edges
            Arrays.sort(edge);

            // Allocate memory for creating V subsets
            subset[] subsets;
            subsets = new subset[V];
            for (i = 0; i < V; ++i)
                subsets[i] = new subset();

            // Create V subsets with single elements
            for (int v = 0; v < V; ++v) {
                subsets[v].parent = v;
                subsets[v].rank = 0;
            }

            i = 0; // Index used to pick next edge

            // Number of edges to be taken is equal to V-1
            while (e < V - 1) {
                // Step 2: Pick the smallest edge. And increment the index for next iteration
                Edge next_edge = new Edge();
                next_edge = edge[i++];

                int x = find(subsets, next_edge.src);
                int y = find(subsets, next_edge.dest);

                // If including this edge doesn't cause cycle, include it in result and increment the index of result for next edge
                if (x != y) {
                    result[e++] = next_edge;
                    Union(subsets, x, y);
                }
                // Else discard the next_edge
            }

            // print the contents of result[] to display the built MST
            System.out.println("Following are the edges in the constructed MST");
            for (i = 0; i < e; ++i)
                System.out.println(result[i].src + "-" + result[i].dest + " = " + result[i].weight);
        }

        public static void main(String[] args) {
            int V = 4; // Number of vertices in graph
            int E = 5; // Number of edges in graph
            Graph graph = new Graph(V, E);

            // add edge 0-1
            graph.edge[0].src = 0;
            graph.edge[0].dest = 1;
            graph.edge[0].weight = 10;

            // add edge 0-2
            graph.edge[1].src = 0;
            graph.edge[1].dest = 2;
            graph.edge[1].weight = 6;

            // add edge 0-3
            graph.edge[2].src = 0;
            graph.edge[2].dest = 3;
            graph.edge[2].weight = 5;

            // add edge 1-3
            graph.edge[3].src = 1;
            graph.edge[3].dest = 3;
            graph.edge[3].weight = 15;

            // add edge 2-3
            graph.edge[4].src = 2;
            graph.edge[4].dest = 3;
            graph.edge[4].weight = 4;

            graph.KruskalMST();
        }
    }
}