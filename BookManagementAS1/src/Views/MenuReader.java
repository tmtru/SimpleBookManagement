/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import Views.MainMenu;
import Manage.ReaderList;
import Manage.Validation;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class MenuReader {
    private static Scanner sc=new Scanner(System.in);
    //Book List menu
    static ReaderList rl=MainMenu.rlMain;
    private static String[] RList={
        "Load data from file",
        "Input & add to the end",
        "Display data",
        "Save reader list to file",
        "Search by rcode",
        "Delete by rcode"
    };
    public static int getChoice(){
        
        return Validation.checkInt("Your option: ", 0, 6);
    }
    public static void display() throws IOException{
        int choice;
        System.out.println("======Reader List======");
        for (int i=0; i<RList.length; i++){
            System.out.println((i+1)+". "+RList[i]);
        }
        System.out.println("Enter 0 to exit!!");
        do {
        choice=getChoice();
        switch (choice){
            case 0:
                break;
            case 1:
                rl.loadFile();

                break;
            case 2:
                rl.addLast();

                break;
            case 3:
                rl.display();

                break;
            case 4:
                rl.saveFile();

                break;
            case 5:
                System.out.print("Please input the Rcode of the reader to be searched: ");
                String xCode=sc.nextLine();
                rl.search(xCode);

                break;
            case 6:
                System.out.print("Please input the Rcode of the reader to be deleted: ");
                String d=sc.nextLine();
                rl.dele(d);
                System.out.println("");
                break;
    
        }
                        System.out.println("");
        } while (choice!=0);
    }
}
