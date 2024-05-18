package Cour;
public class BST {
    Node root;
    //private int height;

    

    public class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }
    public BST(){
        root = null;
    }

    public boolean insert(int val){

        Node newNode = new Node(val);
        if(root == null){
            root = newNode;
            return true;
        }

        //1-Don't insert data(same value to root)
        Node temp = root;

        //while true
        while(temp !=null ){

            if(newNode.data == temp.data) return false;

            //2-insert the node at the left
            if(newNode.data < temp.data){

                //insert at left
                if(temp.left == null){
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            }else{
                //insert at right
                if(temp.right == null){
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
        return false;
        

    }
    public boolean contains(int val){
        Node temp = root;
        while(temp != null){
            if(val < temp.data){
                temp = temp.left;
            } else if(val >temp.data){
                temp = temp.right;
            }else{
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args) {
        BST tree = new BST();
        tree.insert(40);
        tree.insert(30);
        tree.insert(50);
        tree.insert(25);
        tree.insert(35);
        tree.insert(45);
        tree.insert(60);
        System.out.println(tree.root.left.left.data); 
        System.out.println(tree.root.left.right.data);  
        
        System.out.println(tree.root.right.left.data);   
        System.out.println(tree.root.right.right.data);
        System.out.println(tree.contains(12));
        System.out.println(tree.contains(45)); 

    }
}
