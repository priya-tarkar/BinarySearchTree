public class MyMain {
    public static void main(String[] args) {
        operations o=new operations();
        o.insertion(10);
        o.insertion(8);
        o.insertion(15);
        o.insertion(7);
        o.insertion(16);
        o.insertion(6);
        o.insertion(9);
        o.insertion(14);
        System.out.println(o.SearchNode(15));
        o.InOrder(o.root);
        o.delete(7);
        System.out.println();
        o.InOrder(o.root);
    }
}
