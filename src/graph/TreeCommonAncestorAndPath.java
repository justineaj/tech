package graph;
/*
 *            8
 *           / \  
 *          /    \  
 *         7      10   
 *       /  \     / \    
 *      4    15  1   13
 *       \   /\ 
 *      23  27 33
 * */
public class TreeCommonAncestorAndPath {

    public static void main(String[] args) {
        Node n8=new Node(8);Node n7=new Node(7);
        Node n4=new Node(4);Node n15=new Node(15);
        Node n10=new Node(10);Node n1=new Node(1);
        Node n13=new Node(13);Node n23=new Node(23);
        Node n27=new Node(27);Node n33=new Node(33);
        n8.left=n7;n8.right=n10;
        n7.left=n4;n7.right=n15;
        n4.right=n23;n10.left=n1;
        n10.right=n13;
        n15.left=n27;n15.right=n33;

        traverse(4,23,n8);
    }
    public static  boolean traverse(int lo,int hi,Node n){
        if(n==null) return false;
        boolean foundlo=false;
        boolean foundhi=false;
        foundlo=(n.id==lo)||(traverse(lo,hi,n.left));
        foundhi=(n.id==hi)||(traverse(lo,hi,n.right));
        if(foundlo && foundhi){
            System.out.println("------>"+n.id);
        }
        return foundlo || foundhi ;
    }
}
class Node{
    public Node(int id){
       this.id=id;
    }
    int  id;
    Node left;
    Node right;
    @Override
    public String toString() {
        return ""+id;
    }
}