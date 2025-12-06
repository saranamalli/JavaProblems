package learn.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TarjansAlgoCriticalConnectionsInNetwork1192 {

    private static class NodalMetadata {
        int visitIndex;   // Visiting Time in DFS Traversal
        int minConnectedParent;   // Minimum of visitIndex (all the already visited nodes) to which this node has connections to.
        public NodalMetadata(int visitIndex, int minConnectedParent) {
            this.visitIndex = visitIndex;
            this.minConnectedParent = minConnectedParent;
        }
    }

    public static List<List<Integer>> criticalConnections(int n, final List<List<Integer>> connections) {
        List<List<Integer>> adjList = initializeAdjList(n);
        // System.out.println("Initial adjList: "+adjList);
        buildAdjacencyList(connections, adjList); 
        // System.out.println("Adjacency List: "+adjList);
        List<List<Integer>> criticalConnections = new ArrayList<>();
        Map<Integer, NodalMetadata> nodalMetadata = new HashMap<>(n);
        Set<Integer> visitedNodes = new HashSet<>(n);
        Integer visitIndex = 0;
        traversal(0, nodalMetadata, visitedNodes, criticalConnections, adjList, -1, visitIndex);
        System.out.println(criticalConnections);
        return criticalConnections;
    }

    public static void traversal(int currIndex, Map<Integer,NodalMetadata> nodalMetadata, Set<Integer> visitedNodes, 
        List<List<Integer>> criticalConnections, final List<List<Integer>> adjList, int parentIndex, Integer visitIndex) {
        if(visitedNodes.contains(currIndex)) {
            return;     
        } else {
            visitIndex++;
            nodalMetadata.put(currIndex, new NodalMetadata(visitIndex, visitIndex));
            visitedNodes.add(currIndex);
        }
        NodalMetadata currentNodeMetadata = nodalMetadata.get(currIndex), nextNodeMetadata;
        for(int nextIndex: adjList.get(currIndex).stream().filter(ind -> ind != parentIndex).toList()) {
            traversal(nextIndex, nodalMetadata, visitedNodes, criticalConnections, adjList, currIndex, visitIndex);
            nextNodeMetadata = nodalMetadata.get(nextIndex);
            currentNodeMetadata.minConnectedParent = Math.min(nextNodeMetadata.minConnectedParent, currentNodeMetadata.minConnectedParent);
            if(currentNodeMetadata.visitIndex < nextNodeMetadata.minConnectedParent) {
                criticalConnections.add(List.of(currIndex, nextIndex));
            }
        }
        return;
    }

    public static List<List<Integer>> initializeAdjList(int size) {
        List<List<Integer>> adjList = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            adjList.add(new ArrayList<>());
        }
        return adjList;
    }

    public static List<List<Integer>> buildAdjacencyList(final List<List<Integer>> connections, List<List<Integer>> adjList) {
        int ind1, ind2;
        List<Integer> tempAdjacents;
        for(List<Integer> connection: connections) {
            ind1 = connection.get(0);
            ind2 = connection.get(1);
            tempAdjacents = getOrElseDefaultForArrList(adjList, ind1);
            tempAdjacents.add(ind2);
            tempAdjacents = getOrElseDefaultForArrList(adjList, ind2);
            tempAdjacents.add(ind1);
        }
        return adjList;
    }

    public static List<Integer> getOrElseDefaultForArrList(List<List<Integer>> source, int index) {
        if(source.get(index) == null) {
            source.set(index, new ArrayList<>());
        }
        return source.get(index);
    }

    public static void main(String[] args) {
        final List<List<Integer>> connections = List.of(
            List.of(0, 1),
            List.of(1, 2),
            List.of(2, 0),
            List.of(1, 3)
        );
        criticalConnections(4, connections);
    }
}
