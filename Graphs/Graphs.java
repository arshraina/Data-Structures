//package Graphs;
//
//import java.util.Scanner;
//
//class Graphs {
//    int vertices[], adjacencyMatrix[][], visited[], out[];
//    Scanner sc = new Scanner(System.in);
//    void getVertices() {
//        System.out.print("Enter Number of Vertices: ");
//        int vertexCount = sc.nextInt();
//        vertices = new int[vertexCount];
//        adjacencyMatrix = new int[vertexCount][vertexCount];
//        visited = new int[vertexCount];
//        out = new int[vertexCount];
//        System.out.println("Enter Vertices: ");
//        for(int i = 0; i < vertexCount; i++) {
//            System.out.print("Vertex " + (i + 1) + ": ");
//            vertices[i] = sc.nextInt();
//            if(checkDuplicate(vertices[i], i)) {
//                System.out.println("\nDuplicate Vertex Not Allowed!!!\n");
//                i -= 1;
//            }
//        }
//    }
//    boolean checkDuplicate(int vertex,int l) {
//        for(int i = 0; i < l; i++) {
//            if(vertex == vertices[i]){
//                return true;
//            }
//        }
//        return false;
//    }
//    void getEdges() {
//        System.out.println("\n Enter Edges from and to: \n(Enter any character to quit)");
//        while(true) {
//            try {
//                System.out.print("\nFrom: ");
//                int from = sc.nextInt();
//                System.out.print("To: ");
//                int to = sc.nextInt();
//                updateAdjacencyMatrix(getIndex(from),getIndex(to));
//            }
//            catch(Exception e) {
//                System.out.println("Exception Generated");
//                sc.next();
//                break;
//            }
//        }
//    }
//    void updateAdjacencyMatrix(int from,int to) {
//        if(from!=-1 && to!=-1){
//            adjacencyMatrix[from][to] = 1;
//        }
//        else {
//            System.out.println("\nNot Possible");
//        }
//    }
//    int getIndex(int vertex) {
//        for(int i = 0; i < vertices.length; i++) {
//            if(vertices[i]==vertex) {
//                return i;
//            }
//        }
//        return -1;
//    }
//    void breadFirstSearch() {
//        System.out.print("\nEnter Vertex to Start Breadth First Search from: ");
//        int startVertex = sc.nextInt();
//        if(getIndex(startVertex)!=-1) {
//            out[0] = startVertex;
//            visited[getIndex(out[0])] = 1;
//            int count1 = 1, count2 = 0;
//            while(count1 < vertices.length) {
//                int index = getIndex(out[count2]);
//                for(int i = 0; i < vertices.length; i++) {
//                    if(adjacencyMatrix[index][i] == 1 && visited[i] == 0) {
//                        out[count1] = vertices[i];
//                        visited[i] = 1;
//                        count1 += 1;
//                    }
//                }
//                count2 += 1;
//            }
//            System.out.println("\nBreadth First Search:-");
//            for(int i = 0; i < out.length; i++){
//                System.out.print(out[i] + " ");
//            }
//            visited = new int[visited.length];
//        }
//        else {
//            System.out.println("\nNot Possible!!!\n");
//            breadFirstSearch();
//        }
//    }
//    void depthFirstSearch(int vertex, int index) {
//        for(int i = 0; i < vertices.length; i++){
//            if(adjacencyMatrix[index][i] == 1 && visited[i] == 0) {
//                visited[i] = 1;
//                System.out.print(vertices[i] + " ");
//                depthFirstSearch(vertices[i], i);
//            }
//        }
//    }
//    public static void main(String[] args) {
//        Graphs ob = new Graphs();
//        Scanner sc = new Scanner(System.in);
//        ob.getVertices();
//        ob.getEdges();
//        ob.breadFirstSearch();
//        boolean x = true;
//        while(x) {
//            System.out.print("\n\nEnter Vertex to Start Depth First Search from: ");
//            int vertex = sc.nextInt();
//            if(ob.getIndex(vertex)!=-1) {
//                x = false;
//                System.out.print(vertex+" ");
//                int index = ob.getIndex(vertex);
//                ob.visited[index] = 1;
//                ob.depthFirstSearch(vertex,index);
//            }
//            else {
//                System.out.print("\nNot Possible!!!\n");
//            }
//        }
//        sc.close();
//    }
//}
package Graphs;

import java.util.Scanner;

class Graphs {
    int adjacencyMatrix[][], visited[];
    String vertices[], out[];
    Scanner sc = new Scanner(System.in);
    void getVertices() {
        System.out.print("Enter Number of Vertices: ");
        int vertexCount = sc.nextInt();
        vertices = new String[vertexCount];
        adjacencyMatrix = new int[vertexCount][vertexCount];
        visited = new int[vertexCount];
        out = new String[vertexCount];
        System.out.println("Enter Vertices: ");
        for(int i = 0; i < vertexCount; i++) {
            System.out.print("Vertex " + (i + 1) + ": ");
            vertices[i] = sc.next();
            if(checkDuplicate(vertices[i], i)) {
                System.out.println("\nDuplicate Vertex Not Allowed!!!\n");
                i -= 1;
            }
        }
    }
    boolean checkDuplicate(String vertex,int l) {
        for(int i = 0; i < l; i++) {
            if(vertex == vertices[i]){
                return true;
            }
        }
        return false;
    }
    void getEdges() {
        System.out.println("\n Enter Edges from and to: \n(Enter any character to quit)");
        while(true) {
            try {
                System.out.print("\nFrom: ");
                String from = sc.next();
                System.out.print("To: ");
                String to = sc.next();
                updateAdjacencyMatrix(getIndex(from),getIndex(to));
            }
            catch(Exception e) {
                System.out.println("Exception Generated");
                sc.next();
                break;
            }
        }
    }
    void updateAdjacencyMatrix(int from,int to) {
        if(from!=-1 && to!=-1){
            adjacencyMatrix[from][to] = 1;
        }
        else {
            System.out.println("\nNot Possible");
        }
    }
    int getIndex(String vertex) {
        for(int i = 0; i < vertices.length; i++) {
            if(vertices[i]==vertex) {
                return i;
            }
        }
        return -1;
    }
    void breadFirstSearch() {
        System.out.print("\nEnter Vertex to Start Breadth First Search from: ");
        String startVertex = sc.next();
        if(getIndex(startVertex)!=-1) {
            out[0] = startVertex;
            visited[getIndex(out[0])] = 1;
            int count1 = 1, count2 = 0;
            while(count1 < vertices.length) {
                int index = getIndex(out[count2]);
                for(int i = 0; i < vertices.length; i++) {
                    if(adjacencyMatrix[index][i] == 1 && visited[i] == 0) {
                        out[count1] = vertices[i];
                        visited[i] = 1;
                        count1 += 1;
                    }
                }
                count2 += 1;
            }
            System.out.println("\nBreadth First Search:-");
            for(int i = 0; i < out.length; i++){
                System.out.print(out[i] + " ");
            }
            visited = new int[visited.length];
        }
        else {
            System.out.println("\nNot Possible!!!\n");
            breadFirstSearch();
        }
    }
    void depthFirstSearch(String vertex, int index) {
        for(int i = 0; i < vertices.length; i++){
            if(adjacencyMatrix[index][i] == 1 && visited[i] == 0) {
                visited[i] = 1;
                System.out.print(vertices[i] + " ");
                depthFirstSearch(vertices[i], i);
            }
        }
    }
    public static void main(String[] args) {
        Graphs ob = new Graphs();
        Scanner sc = new Scanner(System.in);
        ob.getVertices();
        ob.getEdges();
        ob.breadFirstSearch();
        boolean x = true;
        while(x) {
            System.out.print("\n\nEnter Vertex to Start Depth First Search from: ");
            String vertex = sc.next();
            if(ob.getIndex(vertex)!=-1) {
                x = false;
                System.out.print(vertex+" ");
                int index = ob.getIndex(vertex);
                ob.visited[index] = 1;
                ob.depthFirstSearch(vertex,index);
            }
            else {
                System.out.print("\nNot Possible!!!\n");
            }
        }
        sc.close();
    }
}