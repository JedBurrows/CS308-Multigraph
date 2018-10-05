package graph;

public interface IEdge {

    INode getStart();

    void setStart(INode node);

    INode getFinish();

    void setFinish(INode node);
    
    String getLabel();
    
    void setLabel(String label);
}
