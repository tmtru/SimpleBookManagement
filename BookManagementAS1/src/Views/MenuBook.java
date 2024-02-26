/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.MainMenu;
import Manage.BookList;
import Manage.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MenuBook {
    private static Scanner sc=new Scanner(System.in);
    //Book List menu
    static BookList bl= MainMenu.blMain;
    private static String[] blist={
        "Load data from file",
        "Input & add to the end",
        "Display data",
        "Save book list to file",
        "Search by bcode",
        "Delete by bcode",
        "Sort by bcode",
        "Input & add to beginning",
        "Add after position  k",
        "Delete position k",
        "Delete Books have more pages than "
    };
    public static int getChoice(){
        
        return Validation.checkInt("Your option: ", 0, 11);
    }
    public static void display() throws IOException{
        int choice;
        System.out.println("======Books List======");
        for (int i=0; i<blist.length; i++){
            System.out.println((i+1)+". "+blist[i]);
        }
        System.out.println("Enter 0 to exit!!");
        do {
            choice = getChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    bl.loadFile();

                    break;
                case 2:
                    bl.addLast();

                    break;
                case 3:
                    bl.display();

                    break;
                case 4:
                    bl.saveFile();

                    break;
                case 5:
                    System.out.print("Please input the Bcode of the book to be searched: ");
                    String xCode = sc.nextLine();
                    bl.search(xCode);

                    break;
                case 6:
                    System.out.print("Please input the Bcode of the book to be deleted: ");
                    String d = sc.nextLine();
                    bl.dele(d);

                    break;
                case 7:
                    bl.sortList();
                    System.out.println("Sorted...");
                    break;
                case 8:
                    bl.addFirst();
                    break;
                case 9:
                    bl.addAfter();
                    break;
                case 10:
                    int d1 = Validation.checkInt("Please input the position of the book to be deleted: ", 0, bl.size() - 1);
                    bl.deleK(d1);
                    
                    break;
                case 11:
                    bl.delePage();
                    break;

            }
            System.out.println("");
        } while (choice != 0);


    }
}
