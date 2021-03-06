

class GraphAdjacencyMatrix {

  final int N;
  final Integer[][] matrix;

  private int edgeCount = 0;

  // Creates an Graph with an adjacency matrix
  public GraphAdjacencyMatrix(int N) {
    if (N <= 0) throw new IllegalArgumentException();
    matrix = new Integer[N][N];
    this.N = N;
  }

  public int numNodes() { return N; }
  public int numEdges() { return edgeCount; }

  // O(1)
  public void addDirectedEdge(int from, int to, int weight) {
    if ( from < 0 || from >= N || to < 0 || to >= N)
      throw new IllegalArgumentException();
    if (matrix[from][to] == null) edgeCount++;
    matrix[from][to] = weight;
  }

  // O(1)
  public void addUndirectedEdge(int from, int to, int weight) {
    addDirectedEdge(from, to, weight);
    addDirectedEdge(to, from, weight);
  }

  // O(1)
  public void removeDirectedEdge(int from, int to) {
    if ( from < 0 || from >= N || to < 0 || to >= N)
      throw new IllegalArgumentException();
    if (matrix[from][to] != null) edgeCount--;
    matrix[from][to] = null;
  }

  // O(1)
  public void removeUndirectedEdge(int from, int to) {
    removeDirectedEdge(from, to);
    removeDirectedEdge(to, from);
  }

}

