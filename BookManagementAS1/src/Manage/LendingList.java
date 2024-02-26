/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import DataStructure.LinkedList;
import DataStructure.Node;
import Entities.Books;
import Entities.Lending;
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
public class LendingList {
    private final Scanner sc=new Scanner(System.in);
    private LinkedList LList;
    public LendingList(){
        LList= new LinkedList();
    }
    
    public int size(){
        return LList.size();
    }
    public void loadFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile=sc.nextLine().trim();
        FileReader fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        String bcode, rcode;
        int state;
        Double price;
        while (true) {
            String s = br.readLine();
            String[] a;
            if (s==null) break;
            a=s.split("\\|");
            bcode=a[0].trim();
            rcode=a[1].trim();
            state=Integer.parseInt(a[2].trim());
            LList.addLast(new Lending(bcode, rcode, state));
        }  
        fr.close();
        br.close();
    }
    public void saveFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile = sc.nextLine().trim();
        FileWriter fr = new FileWriter(nameFile);
        PrintWriter pw = new PrintWriter(fr);
        Node p = LList.first();
        while (p != null) {
            Lending h = (Lending) p.getInfor();
            pw.printf("%-5s | %-5s | %-5d %n", h.getBcode(), h.getRcode(), h.getState());
            
            p = p.getNext();
        }
        fr.close();
        pw.close();
    }

    public void inputData(BookList bList, ReaderList rList) {
        //check code exists or not
        String lCode;

        System.out.print("Enter book code: ");
        String bCode = sc.nextLine().trim();
        System.out.print("Enter reader code: ");
        String rCode = sc.nextLine().trim();

        boolean checkB = Validation.isExistBook(bCode, bList.BList);
        boolean checkR = Validation.isExistReader(rCode, rList.RList);
        Lending foundLending = Validation.getExistLending(bCode, rCode, LList);
        
        if (checkB && checkR) {
            Books book = bList.search(bCode);
            if (foundLending != null) {
                System.out.printf("Data has already existed in the system: %n %-5s | %-5s | %-5d ", foundLending.getBcode(), foundLending.getRcode(), foundLending.getState());
                System.out.println("");
                int state = Validation.checkInt("Enter state: ", 0, 2);
                if (state == foundLending.getState()) {
                    System.out.println("Duplicated data!");
                } else {

//                        foundLending.setState(state);
                    switch (state) {
                        case 0:
                            System.out.println("Error! Cannot change state from 1 to 0!");
                            break;
                        case 1:
                            if (Validation.checkYesNo("Do you want to update new state for the data?(Y/N)")) {
                                if (book.getLended() < book.getQuantity()) {
                                    foundLending.setState(state);
                                    book.setLended(book.getLended() + 1);
                                } else {
                                    System.out.println("Lending books is full! Cannot lend anymore!");
                                }
                            }
                            break;
                        case 2:
                            if (Validation.checkYesNo("Do you want to update new state for the data?(Y/N)")) {
                                if (foundLending.getState() == 1) {
                                    book.setLended(book.getLended() - 1);
                                }
                                foundLending.setState(state);
                            }
                            break;

                    }
                }
            } else {
                if (book.getLended() == book.getQuantity()) {
                    LList.addLast(new Lending(bCode, rCode, 0));
                } else if (book.getLended() < book.getQuantity()) {
                    LList.addLast(new Lending(bCode, rCode, 1));
                    book.setLended(book.getLended() + 1);
                }
            }
        } else {
            System.out.println("Error! Book code or Reader code is not exist in the system!");
            System.out.println("Add book code or reader code and then try again!");
        }
    }

    
    
    public void display(){
        System.out.printf("%-5s | %-5s | %-5s ","BCode","RCode","State");
        System.out.println("");
        System.out.println("=====================");
        Node p= LList.first();
        while (p!=null){
            Lending h= (Lending) p.getInfor();
            System.out.printf("%-5s | %-5s | %-5d ",h.getBcode(),h.getRcode(),h.getState());
            p= p.getNext();
            System.out.println("");
        }
    }
    
    public void sort() {
        Node current = LList.first();
        Node index = null;
        Lending temp;
        while (current != null) {
            index = current.getNext();
            while (index != null) {
                Lending l = (Lending) current.getInfor();
                Lending l1 = (Lending) index.getInfor();

                if (l.getBcode().compareToIgnoreCase(l1.getBcode()) > 0) {
                    temp = l;
                    current.setInfor(l1);
                    index.setInfor(temp);
                } else if (l.getBcode().compareToIgnoreCase(l1.getBcode()) == 0) {
                    if (l.getRcode().compareToIgnoreCase(l1.getRcode()) > 0) {
                        temp = l;
                        current.setInfor(l1);
                        index.setInfor(temp);
                    }
                }
                index=index.getNext();
            }
            current=current.getNext();
        }
    }
}