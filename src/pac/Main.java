package pac;
public class Main {
    public static void main(String[] args) {
        MyLinkedList<Integer> mll = new MyLinkedList<>();

        mll.addElement(1);
        mll.addElement(2);
        mll.addElement(3);
        mll.addElement(4);
        mll.addElement(5);

        System.out.println("Value of index 1: " + mll.getElement(1));
        System.out.println("Size of an list: " + mll.getSize());
        System.out.println("Vaule of index 0 before remove: " + mll.getElement(0));
        mll.remove(0);
        System.out.println("Vaule of index 0 after remove: " + mll.getElement(0));
        System.out.println("Size of an list: " + mll.getSize());
        System.out.println("Vaule of index 2 before remove: " + mll.getElement(2));
        mll.remove(2);
        System.out.println("Vaule of index 2 after remove: " + mll.getElement(2));
        System.out.println("Size of an list: " + mll.getSize());

        MyArrayList<Integer> mal = new MyArrayList<>();

        mal.addElement(0);
        mal.addElement(1);
        mal.addElement(2);
        mal.addElement(3);
        mal.addElement(4);


        System.out.println("Value of index 1: " + mal.getElement(1));
        System.out.println("Size of an list: " + mal.size());
        System.out.println("Vaule of index 0 before remove: " + mal.getElement(0));
        mal.remove(0);
        System.out.println("Vaule of index 0 after remove: " + mal.getElement(0));
        System.out.println("Size of an list: " + mal.size());
        System.out.println("Vaule of index 2 before remove: " + mal.getElement(2));
        mll.remove(2);
        System.out.println("Vaule of index 2 after remove: " + mal.getElement(2));
        System.out.println("Size of an list: " + mal.size());

    }
}