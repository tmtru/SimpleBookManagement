/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import DataStructure.LinkedList;
import DataStructure.Node;
import Entities.Reader;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class ReaderList {
    private final Scanner sc=new Scanner(System.in);
    public LinkedList RList;
    public ReaderList(){
        RList= new LinkedList();
    }
    
//With File
    public int size(){
        return RList.size();
    }
    public void loadFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile=sc.nextLine().trim();
        FileReader fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        String rcode, name;
        int byear;
        while (true) {
            String s = br.readLine();
            String[] a;
            if (s==null) break;
            a=s.split("\\|");
            rcode=a[0].trim();
            name=a[1].trim();
            byear=Integer.parseInt(a[2].trim());
            RList.addLast(new Reader(rcode,name,byear));
            
        }
       
        fr.close();
        br.close();
    }
    public void saveFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile=sc.nextLine().trim();
        FileWriter fr = new FileWriter(nameFile);
        PrintWriter pw=new PrintWriter(fr);
        Node p= RList.first();
        while (p!=null){
            Reader h= (Reader) p.getInfor();
            pw.printf("%-5s | %-15s | %-10d %n",h.getRcode(),h.getName(),h.getByear());
            p= p.getNext();
        }
        fr.close();
        pw.close();
    }
    
//
    public void addLast(){
        //check code exists or not
        String rcode;
        while (true){
            try {
                System.out.print("Rcode: ");
                rcode = sc.nextLine().trim();
                boolean check = Validation.isExistReader(rcode, RList);
                if (check) {
                    throw new Exception();
                } else break;
            } catch (Exception e) {
                System.err.println("The reader ID is already existed in the system!");
                System.err.println("Please try again!");

            }
        }        
        System.out.print("Name: ");
        String name=sc.nextLine().trim();
        int byear=Validation.checkInt("Enter the birth year of reader: ", 1900, 2010);
        RList.addLast(new Reader(rcode, name, byear));
    }
    
    public void display(){
        System.out.printf("%-5s | %-15s | %-10s ","Code","Name","Byear");
        System.out.println("");
        System.out.println("======================================");
        Node p= RList.first();
        while (p!=null){
            Reader h= (Reader) p.getInfor();
            System.out.printf("%-5s | %-15s | %-10d ",h.getRcode(),h.getName(),h.getByear());
            p= p.getNext();
            System.out.println("");
        }
    }
    public Node search(String xCode){
        if (!(Validation.isExistReader(xCode, RList))) {
            System.err.println("Not Found!");
            return null;
        }
        else {
            System.out.println("Founded!!");
            Node p = RList.first();
            while (p != null) {
                Reader h = (Reader) p.getInfor();
                if (h.getRcode().equals(xCode)) 
                    return p;
                p = p.getNext();
            }
        }
        return null;
    }
    public void dele(String xCode){
        if (!(Validation.isExistReader(xCode, RList))) {
            return;
        } else {
            Node previousNode = new Node();
            Node p = RList.first();
            while (p != null) {
                Reader h = (Reader) p.getInfor();
                if (h.getRcode().equals(xCode)) {
                    if (p==RList.first()){
                        RList.removeFirst();
                    } else previousNode.setNext(p.getNext());
                    
                }
                previousNode=p;
                p = p.getNext();
            }
        }
    }
}
