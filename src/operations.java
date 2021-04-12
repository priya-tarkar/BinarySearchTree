//Coding through iterative method

// 1 :Insertion operation
public class operations {
    Node root;
    public operations()
    {
        root=null;
    }
    void insertion(int data)
    {
        Node node=new Node(data);
        if(root==null)
        {
            root=node;

        }
        else
        {
            Node temp=root;
            Node parent=null;
            while(temp!=null)
            {
                parent=temp;
                if(data<temp.data)
                {
                    temp=temp.left;
                }
                else
                {
                    temp=temp.right;
                }
            }
            if(parent.data>data)
            {
                parent.left=node;
            }
            else
            {
                parent.right=node;
            }

        }
    }

    // 2: Searching operation
   public boolean SearchNode(int data)
    {
        boolean response=false;
        Node temp=root;
        while(temp!=null)
        {
            if(temp.data==data)
            {
                response=true;
                break;
            }
            else if(data<temp.data)
            {
                temp=temp.left;
            }
            else
            {
                temp=temp.right;
            }
        }
        return response;
    }

    // 3 : Deletion of Node
    void delete(int data)
    {
        if(SearchNode(data))
        {
            Node temp=root;
            Node parent=null;
            while(temp!=null && temp.data!=data)
            {
                parent=temp;
                if(temp.data==data)
                {
                    break;
                }
                else if(data<temp.data)
                {
                    temp=temp.left;
                }
                else
                {
                    temp=temp.right;
                }
            }
            if(temp!=null) {
                // Deletion of leaf node
                if (isleaf(temp)) {
                    if (parent.data > data) {
                        parent.left = null;
                    } else {
                        parent.right = null;
                    }
                }
                //deletion of node having single child
                else if (temp.left != null && temp.right == null) {
                    if (parent.data > data) {
                        parent.left = SingleChild(temp);
                    } else {
                        parent.right = SingleChild(temp);
                    }
                } else if (temp.right != null && temp.left == null) {
                    if (parent.data > data) {
                        parent.left = SingleChild(temp);
                    } else {
                        parent.right = SingleChild(temp);
                    }
                }

                //deletion of node having two children
                else {
                    Node successor = ChildSuccesor(temp);
                    delete(successor.data);
                    successor.left = temp.left;
                    successor.right = temp.right;

                    if (parent.data > temp.data) {
                        parent.left = successor;
                    } else {
                        parent.right = successor;
                    }
                }
            }
                else
                {
                    System.out.println("element not present");
                }
            }
        }


    private Node ChildSuccesor(Node temp) {
        Node response=null;
        temp=temp.right;
        while(temp!=null)
        {
            response=temp;
            temp=temp.left;
        }
        return response;
    }

    private boolean isleaf(Node temp) {
        if(temp.left==null && temp.right==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    private Node SingleChild(Node temp)
    {
        if(temp.left!=null && temp.right==null)
        {
            return temp.left;
        }
        else
        {
            return temp.right;
        }
    }


    void InOrder(Node node)
    {
        if(node==null)
        {
            return;
        }
        else
        {
            InOrder(node.left);
            System.out.print(node.data+" ");
            InOrder(node.right);
        }
    }
}
