package com.self.practice.dataStructure.LinkedList;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LinkedList1 {
    class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public Node first = null;
    public Node last = null;


    public void addNodeAtEnd(int data) {  //insert at end
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }

    }

    public void addNodeAtBegining(int data) throws IOException {
        Node newNode = new Node(data);
        if (first == null) {
            first = newNode;
            last = newNode;
        } else {
            newNode.next = first;
            first = newNode;
        }
    }

    public void InsertAtAny(int pos, int data) {
        Node newNode = new Node(data);
        Node curr;
        Node prev = null;
        curr = first;
        int key = 1, count = 0;
        while (curr != null && key != pos) {

            prev = curr;
            if (key != pos) {
                key++;
            }
            curr = curr.next;
            if (curr == null) {
                System.out.println("Key not found ! Insertion Not Possible!!!");
            }
            // curr=curr.next;
        }
        prev.next = newNode;
        newNode.next = curr;

    }

    public void display() {
        Node current = first;
        if (first == null) {
            System.out.println("List is Empty");
        } else {
            System.out.println("Nodes of the linkedList are : ");
            while (current != null) {
                System.out.print(current.data + "\t");
                current = current.next;
            }
            System.out.println("\n");
        }
    }

    public void deleteEnd() {
        if (first == null) {
            System.out.println("List is Empty ! Deletion is not Possible!!!");
        } else {
            Node temp = first;
            while (temp.next != last) {
                temp = temp.next;
            }
            System.out.println(last.data + " is deleted.");
            temp.next = null;
            last = temp;
        }
    }

    public void deleteFrist() {
        if (first == null) {
            System.out.println("List is Empty ! Deletion is not Possible!!!");
        } else {
            System.out.println(first.data + " is deleted.");
            first = first.next;
        }
    }

    void deleteByIndex(int index) {
        if (first == null) {
            System.out.println("List is empty. Deletion not possible");
        } else {
            Node prev = null, curr = first;
            int key = 1;
            while (curr != null && key != index) {
                prev = curr;
                curr = curr.next;
                key++;
            }
            if (curr == null) {
                System.out.println("Index not found, Deletion not possible.!");
            } else {
                System.out.println(curr.data + " is deleted.");
                prev.next = curr.next;
                curr = null;
            }

        }
    }

//    boolean checkLoop() {
//        if (first == null)
//            System.out.println("List is empty.");
//        else {
//
//            while (true) {
//                Node ptr1, ptr2;
//                ptr1 = ptr2 = first;
//                ptr1 = ptr1.next;
//                if (ptr2.next != null)
//                    ptr2 = ptr2.next.next;
//                else
//                    return false;
//                if (ptr1 == null || ptr2 == null)
//                    return false;
//                if (ptr1 == ptr2) {
//                    System.out.println("Loop Present");
//                    return true;
//                }
//            }
//        }
//        return true;
//    }


    public static void main(String args[]) throws Exception {
        LinkedList1 list1 = new LinkedList1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int value = 0;
        int input;
        while (value != 20) {
            System.out.println("\n1.InsertAtFirst \n2.InsertAtEnd \n3.InsertAtAnyPosition \n4.DeleteFromFirst \n5.DeleteFromEnd" +
                    "\n6. DeleteFromIndex  \n10.Display \n20.Exit");
            System.out.println("Enter your choice : ");
            value = Integer.parseInt(br.readLine());

            switch (value) {
                case 1:
                    System.out.println("Enter the data value of the node to be insert : ");
                    input = Integer.parseInt(br.readLine());
                    list1.addNodeAtBegining(input);
                    break;
                case 2:
                    System.out.println("Enter the data value of the node to be insert : ");
                    input = Integer.parseInt(br.readLine());
                    list1.addNodeAtEnd(input);
                    break;

                case 3:
                    System.out.println("Enter the pos &  data value : ");
                    int key = Integer.parseInt(br.readLine());
                    input = Integer.parseInt(br.readLine());
                    list1.InsertAtAny(key, input);
                    break;
                case 4:
                    list1.deleteFrist();
                    break;
                case 5:
                    list1.deleteEnd();
                    break;
                case 6:
                    System.out.println("Enter the index you want to delete : ");
                    int index = Integer.parseInt(br.readLine());
                    list1.deleteByIndex(index);
                    break;
//                case 7:boolean b= list1.checkLoop();
//                    break;

                case 10:
                    list1.display();
                    break;
                case 20:
                    break;
                default:
                    System.out.println("Wrong Choice");
                    break;


            }

        }
    }

}
