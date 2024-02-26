/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataStructure;

/**
 *
 * @author Admin
 */
public class Node {
    Node next;
    Object infor;
    public Node(){
        infor=null;
        next=null;
    }
    public Node(Object infor, Node next){
        this.infor=infor;
        this.next=next;
    }
    public Node(Object infor){
        this.infor=infor;
        this.next=null;
    }


    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setInfor(Object infor) {
        this.infor = infor;
    }

    public Object getInfor() {
        return infor;
    }

//
//    @Override
//    public String toString() {
//        return "infor=" + infor;
//    }
    
}
