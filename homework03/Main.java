package homework03;

//Необходимо реализовать метод разворота связного списка ( двухсвязного или односвязного на выбор).

public class Main {
    public static void main(String[] args) {
        MyLinkedList mylist = new MyLinkedList();
        for (int index = 0; index < 6; index++) {
            mylist.addLast(index);
        }
        mylist.print();
        mylist.revert();
        mylist.print();
        mylist.revert();
        mylist.print();
        
    }

}
