import java.util.*;

public class p23detectCycleInDirected_BFS {
    static class Edge{
        int src;
        int dest;

        public Edge(int s, int d){
            this.src = s;
            this.dest = d;
        }
    }

    public static void createGraph(ArrayList<Edge> graph []){
        for(int i = 0; i<graph.length; i++){
            graph[i] = new ArrayList<>();
        }

        // Remove comment to create cycle
        // graph[1].add(new Edge(1, 3));

        graph[2].add(new Edge(2,3));

        graph[3].add(new Edge(3,1));

        graph[4].add(new Edge(4,0));
        graph[4].add(new Edge(4,1));

        graph[5].add(new Edge(5,0));
        graph[5].add(new Edge(5,2));
    }

    public static void calcInDeg(ArrayList<Edge> graph[], int InDeg[]){
        for(int i = 0; i<graph.length; i++){
            int v = i; //vertex

            for(int j = 0; j<graph[v].size(); j++){
                Edge e = graph[v].get(j);
                InDeg[e.dest]++;
            }
        }
    }

    public static void topSort(ArrayList<Edge> graph[]){
        int inDeg[] = new int [graph.length];
        calcInDeg(graph,inDeg);

        Queue<Integer> q = new LinkedList<>();
        // here we are adding the elements whose inDeg is already zero
        for(int i = 0; i<inDeg.length; i++){
            if(inDeg[i] == 0){
                q.add(i);
            }
        }

        //bfs
        int count = 0;
        while(!q.isEmpty()){

            int curr = q.remove();
            count++; // update to check how many elements are added in topo sort

            for( int i = 0; i<graph[curr].size(); i++){ 
                Edge e = graph[curr].get(i);

                inDeg[e.dest]--;

                if(inDeg[e.dest] == 0){
                    q.add(e.dest);
                }

            }
        }
        
        if(count == graph.length){
            System.out.println("Cycle doesn't exist");
        } else {
            System.out.println("Cycle does exist");
        }
    }

    @SuppressWarnings("unchecked")
    public static void main(String args[]){
        int V = 6;

        ArrayList<Edge> graph[] = new ArrayList[V];
        createGraph(graph);

        topSort(graph);
    }
}