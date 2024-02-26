/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import Entities.Books;
import DataStructure.*;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class BookList {

    private final Scanner sc = new Scanner(System.in);
    public LinkedList BList;

    public BookList() {
        BList = new LinkedList();
    }

//With File
    public int size() {
        return BList.size();
    }

    public void loadFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile = sc.nextLine().trim();
        FileReader fr = new FileReader(nameFile);
        BufferedReader br = new BufferedReader(fr);
        String bcode, title;
        int quantity;
        Double price;
        int pages;
        while (true) {
            String s = br.readLine();
            String[] a;
            if (s == null) {
                break;
            }
            a = s.split("\\|");
            bcode = a[0].trim();
            title = a[1].trim();
            quantity = Integer.parseInt(a[2].trim());

            if (a.length == 5) {
                price = Double.parseDouble(a[3].trim());
                pages = Integer.parseInt(a[4].trim());
                BList.addLast(new Books(bcode, title, quantity, 0, price, pages));
            } else if (a.length == 6) {
                price = Double.parseDouble(a[4].trim());
                pages = Integer.parseInt(a[5].trim());
                int lended = Integer.parseInt(a[3].trim());
                BList.addLast(new Books(bcode, title, quantity, lended, price, pages));
            }
        }
        fr.close();
        br.close();
    }

    public void saveFile() throws IOException {
        System.out.print("Enter a file name: ");
        String nameFile = sc.nextLine().trim();
        FileWriter fr = new FileWriter(nameFile);
        PrintWriter pw = new PrintWriter(fr);
        Node p = BList.first();
        while (p != null) {
            Books h = (Books) p.getInfor();
            pw.printf("%-5s | %-15s | %-10d | %-10d | %-6.3f |%-10d %n", h.getBcode(), h.getTitle(), h.getQuantity(), h.getLended(), h.getPrice(), h.getPages());
            p = p.getNext();
        }
        fr.close();
        pw.close();
    }

//
    public void addLast() {
        //check code exists or not
        String bcode;
        while (true) {
            try {
                System.out.print("Bcode: ");
                bcode = sc.nextLine().trim();
                boolean check = Validation.isExistBook(bcode, BList);
                if (check) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("The book ID is already existed in the system!");
                System.err.println("Please try again!");

            }
        }
        System.out.print("Title: ");
        String title = sc.nextLine().trim();
        int quantity = Validation.checkInt("Quantity: ", 0, Integer.MAX_VALUE);
        Double price = Validation.checkDouble("Price: ");
        int lended = Validation.checkInt("Lended: ", 0, quantity);
        int pages = Validation.checkInt("Pages: ", 0, Integer.MAX_VALUE);
        BList.addLast(new Books(bcode, title, quantity, lended, price, pages));
    }

    public void display() {
        System.out.printf("%-5s | %-15s | %-10s | %-7s | %-6s |%-6s", "Code", "Title", "Quantity", "Lended", "Price", "Pages");
        System.out.println("");
        System.out.println("========================================================");
        Node p = BList.first();
        while (p != null) {
            Books h = (Books) p.getInfor();
            System.out.printf("%-5s | %-15s | %-10d | %-7d | %-6.3f | %-6d", h.getBcode(), h.getTitle(), h.getQuantity(), h.getLended(), h.getPrice(), h.getPages());
            p = p.getNext();
            System.out.println("");
        }
    }

    public Books search(String xCode) {
        if (!(Validation.isExistBook(xCode, BList))) {
            return null;
        } else {
            Node p = BList.first();
            while (p != null) {
                Books h = (Books) p.getInfor();
                if (h.getBcode().equals(xCode)) {
                    System.out.printf("%-5s | %-15s | %-10d | %-7d | %-6.3f | %-6d", h.getBcode(), h.getTitle(),
                            h.getQuantity(), h.getLended(), h.getPrice(), h.getPages());
                    System.out.println("");
                    return h;
                }
                p = p.getNext();
            }
        }
        return null;
    }

    public void dele(String xCode) {
        if (!(Validation.isExistBook(xCode, BList))) {
            return;
        } else {
            Node previousNode = new Node();
            Node p = BList.first();
            while (p != null) {
                Books h = (Books) p.getInfor();
                if (h.getBcode().equals(xCode)) {
                    if (p == BList.first()) {
                        BList.removeFirst();
                    } else {
                        previousNode.setNext(p.getNext());
                    }

                }
                previousNode = p;
                p = p.getNext();
            }
        }
    }

    public void sortList() {

        Node current = BList.first(), index = null;
        Books temp;
        if (current == null) {
            return;
        } else {
            while (current != null) {
                index = current.getNext();
                while (index != null) {
                    Books b = (Books) current.getInfor();
                    Books b1 = (Books) index.getInfor();

                    if (b.getBcode().compareTo(b1.getBcode()) > 0) {
                        temp = (Books) current.getInfor();
                        current.setInfor(index.getInfor());
                        index.setInfor(temp);
                    }

                    index = index.getNext();
                }
                current = current.getNext();
            }
        }
    }

    public void addFirst() {
        //check code exists or not
        String bcode;
        while (true) {
            try {
                System.out.print("Bcode: ");
                bcode = sc.nextLine().trim();
                boolean check = Validation.isExistBook(bcode, BList);
                if (check) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("The book ID is already existed in the system!");
                System.err.println("Please try again!");

            }
        }
        System.out.print("Title: ");
        String title = sc.nextLine().trim();
        int quantity = Validation.checkInt("Quantity: ", 0, Integer.MAX_VALUE);
        Double price = Validation.checkDouble("Price: ");
        int pages = Validation.checkInt("Pages: ", 0, Integer.MAX_VALUE);
        BList.addFirst(new Books(bcode, title, quantity, 0, price, pages));
    }

    public void addAfter() {
        //check code exists or not
        String bcode;
        while (true) {
            try {
                System.out.print("Bcode: ");
                bcode = sc.nextLine().trim();
                boolean check = Validation.isExistBook(bcode, BList);
                if (check) {
                    throw new Exception();
                } else {
                    break;
                }
            } catch (Exception e) {
                System.err.println("The book ID is already existed in the system!");
                System.err.println("Please try again!");

            }
        }
        int result = Validation.checkInt("Add after position: ", 0, BList.size());
        System.out.print("Title: ");
        String title = sc.nextLine().trim();
        int quantity = Validation.checkInt("Quantity: ", 0, Integer.MAX_VALUE);
        Double price = Validation.checkDouble("Price: ");
        int pages = Validation.checkInt("Pages: ", 0, Integer.MAX_VALUE);
        BList.addK(new Books(bcode, title, quantity, 0, price, pages), result);

    }

    public void deleK(int k) {
        BList.removeK(k);
        //sai0 va cuoi day

    }

    public void delePage() {
        int pages = Validation.checkInt("Pages: ", 0, Integer.MAX_VALUE);
        
        Node previousNode = new Node();
        Node p = BList.first();
        while (p != null) {
            int d = 0;
            Books h = (Books) p.getInfor();
            if (h.getPages() > pages) {

 
                    if (p == BList.first()) {
                        BList.removeFirst();
                        d=1;
                    } else {
                        previousNode.setNext(p.getNext());
                        d=2;
                    }
                }
            if (d==0) previousNode=p;

            p = p.getNext();
        }
    }
}
