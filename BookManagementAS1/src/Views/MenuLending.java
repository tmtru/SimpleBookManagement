/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Manage.BookList;
import Manage.LendingList;
import Manage.ReaderList;
import Manage.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MenuLending {
    private static Scanner sc=new Scanner(System.in);
    //Book List menu
    static ReaderList rl=MainMenu.rlMain;
    static BookList bl=MainMenu.blMain;
    static LendingList ll=MainMenu.llMain;
    private static String[] LList={
        "Input data",
        "Display lending data",
        "Sort by bcode + rcode",       
        "Load lending data from file",
        "Save lending list to file"
    };
    public static int getChoice(){
        
        return Validation.checkInt("Your option: ", 0, 5);
    }
    public static void display() throws IOException{
        int choice;
        System.out.println("======Lending List======");
        for (int i=0; i<LList.length; i++){
            System.out.println((i+1)+". "+LList[i]);
        }
        System.out.println("Enter 0 to exit!!");
        do {
            choice = getChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    ll.inputData(bl, rl);
                    break;
                case 2:
                    ll.display();
                    break;
                case 3:
                    ll.sort();
                    break;
                case 4:
                    ll.loadFile();
                    break;
                case 5:
                    ll.saveFile();
                    break;
            }
            System.out.println("");
        } while (choice != 0);
    }
}
