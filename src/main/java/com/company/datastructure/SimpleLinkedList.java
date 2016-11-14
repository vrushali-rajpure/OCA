package com.company.datastructure;

/**
 * Created by rajpurev on 10/11/16.
 */
public class SimpleLinkedList {

    private Node headNode;
    static class Node {
        private int data;
        private Node next;

        Node( int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node : " + data;
        }
    }

    public static void main(String args[]) {
        SimpleLinkedList list = new SimpleLinkedList();

        list.headNode = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);

        list.headNode.next = second;
        second.next = third;
        list.print( );

        list.addFirst(4);
        System.out.println("Add First");
        list.print( );

        list.insertAfter(new Node(4), 5);
        System.out.println("After Insertion");
        list.print();

        list.addLast( 6);
        System.out.println("Add Last");
        list.print();

        list.deleteNode( 2);
        System.out.println("Node deletion :2 ");
        list.print();

        list.deleteNode( 4);
        System.out.println("Node deletion : 4");
        list.print();

        list.deleteNode( 6);
        System.out.println("Node deletion : 6");
        list.print();

        System.out.println("Count(Iterative)");
        System.out.println( list.getCountIterative());

        System.out.println("Count(Recursive)");
        System.out.println( list.getCountRecursive(list.headNode));

        list.addFirst(4);
        list.addLast( 6);

        System.out.println( "List before swap :");
        list.print();
        // 4 5 1 3 6
        System.out.println( "SwapNode (middle and last)");
        list.swapNodes(1,6);
        list.print();

        //4 5 6 3 1
        System.out.println( "SwapNode (first and middle)");
        list.swapNodes(4,3);
        list.print();

        //3 5 6 4 1
        System.out.println( "SwapNode (first and last)");
        list.swapNodes(3,1);
        list.print();

        //1 5 6 4 3
        System.out.println( "SwapNode (middle and middle)");
        list.swapNodes(5,4);
        list.print();

        //1 4 6 5 3
        System.out.println( "SwapNode Consecutive (middle and middle)");
        list.swapNodes(4,6);
//        list.swapNodesGeekForGeek( 4,6);
        list.print();

        //1 6 4 5 3
        System.out.println( "SwapNode (last  and first)");
        list.swapNodes(3,1);
        list.print();

        //Reverese List ( Could not do it)
        System.out.println("Reverse List (Iterative)");
        list.reverseListIterative();
        list.print();

        //Reverese List ( Could not do it)
        System.out.println("Reverse List (Recursive)");
        list.reverseListRecursive( list.headNode, null);
        list.print();

        // Merge sorted List

        System.out.println("Merge Sorted List (Iterative)");
        SimpleLinkedList mergedList = new SimpleLinkedList();
        mergedList.headNode = list.mergeSortedList(create(1, 4, 6, 8).headNode, create(2, 3, 5, 9).headNode);
        mergedList.print();


        System.out.println("Merge Sorted List (Recursive)");
        mergedList = new SimpleLinkedList();
        mergedList.headNode = list.mergeSortedListRecursion(create(1, 4, 6, 8).headNode, create(2, 3, 5, 9).headNode);
        mergedList.print();
    }

    private static SimpleLinkedList create( int... var){
        SimpleLinkedList list = new SimpleLinkedList();
        list.headNode = new Node(var[0]);
        list.headNode.next = new Node(var[1]);
        list.headNode.next.next = new Node(var[2]);
        list.headNode.next.next.next = new Node(var[3]);
        return list;
    }

    private void print( ){
        Node temp = headNode;
        while ( temp != null) {
            System.out.println( temp.data );
            temp = temp.next;
        }
    }

    private void addFirst(int data) {

        if( headNode == null) {
            headNode = new Node(1);
        }
        else {
            Node node = new Node(data);
            node.next = headNode;
            headNode = node;
        }
    }

    private void insertAfter( Node previous, int data) {
        Node node = new Node(data);
        Node temp = headNode;

        while ( temp != null) {
            if( temp.data == previous.data) {
                node.next = temp.next;
                temp.next = node;
                break;
            }
            temp = temp.next;
        }
    }

    private void addLast( int data){
        Node node = new Node(data);
        Node temp = headNode;
        if( temp == null) {
            headNode = node;
        } else {
            while( temp.next != null) {
                temp = temp.next;
            }
            temp.next = node;
        }
    }

    private void deleteNode(int key){
        if( headNode == null) {
            System.out.println("List is empty");
        }

        Node temp = headNode;
        Node prev = null;

        while (temp != null) {
            if( temp.data == key) {
                if( temp == headNode) {
                    headNode = headNode.next;
                    return;
                }

                prev.next = temp.next;
                temp.next = null;
                return;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    private int getCountIterative(){
        Node temp = headNode;
        int count = 0;
        while ( temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    private int getCountRecursive(Node node) {
        if( node == null){
            return 0;
        }
        return 1+getCountRecursive(node.next);
    }

    private void swapNodes(int x,int y){

        Node temp = headNode;
        Node xNode = null , yNode = null;
        Node xPrev = null, yPrev= null;
        if( temp.data == x ){
            xNode = temp;
            xPrev = null;
        }
        if( temp.data == y) {
            yNode = temp;
            yPrev = null;
        }


        Node prev = null;
        while ( temp != null) {

            if( temp.data == x ){
                xNode = temp;
                xPrev = prev;
            }
            if( temp.data == y) {
                yNode = temp;
                yPrev = prev;
            }
            prev = temp;
            temp = temp.next;

        }

        if( xNode != null && yNode != null) {

            if( yPrev == null) {
               headNode = xNode;
            } else {
                yPrev.next = xNode;
            }

            if( xPrev == null) {
                headNode = yNode;
            } else {
                xPrev.next = yNode;

            }
            temp = xNode.next;
            xNode.next = yNode.next;
            yNode.next = temp;

        }
    }

    public void swapNodesGeekForGeek(int x, int y)
    {
        // Nothing to do if x and y are same
        if (x == y) return;

        // Search for x (keep track of prevX and CurrX)
        Node prevX = null, currX = headNode;
        while (currX != null && currX.data != x)
        {
            prevX = currX;
            currX = currX.next;
        }

        // Search for y (keep track of prevY and currY)
        Node prevY = null, currY = headNode;
        while (currY != null && currY.data != y)
        {
            prevY = currY;
            currY = currY.next;
        }

        // If either x or y is not present, nothing to do
        if (currX == null || currY == null)
            return;

        // If x is not head of linked list
        if (prevX != null)
            prevX.next = currY;
        else //make y the new head
            headNode = currY;

        // If y is not head of linked list
        if (prevY != null)
            prevY.next = currX;
        else // make x the new head
            headNode = currX;

        // Swap next pointers
        Node temp = currX.next;
        currX.next = currY.next;
        currY.next = temp;
    }

    private void reverseListIterative() {
        Node previous = null;
        Node current = headNode;
        Node next = null;

       while( current != null){
           next = current.next;
           current.next = previous;
           previous = current;
           current = next;
       }

       headNode = previous;
    }

    private Node reverseListRecursive(Node current,Node previous) {
        if( current.next == null){
            headNode = current;
            current.next = previous;
            return headNode;
        }

        Node next = current.next;
        current.next = previous;
        reverseListRecursive( next,current);

        return headNode;
    }

    private Node mergeSortedList( Node first, Node second) {
        Node merged = null , tempMergeHead = null;

        if( first == null && second == null) {
            return null;
        }
        if( first == null) {
            merged = second;
        }

        if( second == null) {
            merged = second;
        }

        while ( first != null && second != null) {
            Node temp = null;
            if( first.data < second.data) {
                temp = new Node( first.data);
                first = first.next;
            } else{
                temp = new Node( second.data);
                second = second.next;
            }

            if( merged == null) {
                merged = temp;
                tempMergeHead = merged;
            } else {
                merged.next = temp;
                merged = merged.next;
            }
        }

        while ( first != null) {
            merged.next = first;
            merged = merged.next;
            first = first.next;
        }

        while ( second != null) {
            merged.next = second;
            merged = merged.next;
            second = second.next;
        }
        return tempMergeHead;
    }

    private Node mergeSortedListRecursion( Node first, Node second) {
        Node result = null;
        if ( first == null){
            return first;
        }
        if( second == null) {
            return second;
        }

        if( first.data < second.data) {
            result = first;
            result.next = mergeSortedList( first.next,second);
        } else {
            result = second;
            result.next = mergeSortedList( first,second.next);
        }
        return result;
    }
}
