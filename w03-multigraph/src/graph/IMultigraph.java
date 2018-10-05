package graph;

import java.util.List;
import java.util.Set;

public interface IMultigraph {

    void addEdge(int startNodeId, int endNodeId);

    void addEdge(int nodeOriginId, int nodeId, String nodeLabel, String edgeLabel);

    List<IEdge> findPath(INode originId, INode destinationId);

    int getNoEdges();

    int getNoNodes();

    Set<INode> getNodes();

    INode findNodeById(int id);

    Set<String> getEdgesLabels();

}
