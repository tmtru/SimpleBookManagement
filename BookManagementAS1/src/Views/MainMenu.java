/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Views;

import DataStructure.LinkedList;
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
//thêm thuộc tính số trang, sủa các phần liên quan, thêm chức năng: nhập vào giá trị và xóa hai quyển đầu tiên có số trang> giá trị nhập vào
public class MainMenu {

    private static Scanner sc = new Scanner(System.in);
    public static ReaderList rlMain=new ReaderList();
    public static BookList blMain=new BookList();
    public static LendingList llMain=new LendingList();
    private static String[] List = {
        "Manage Book List",
        "Manage Reader List",
        "Manage Lending List"
    };

    public static int getChoice() {
        return Validation.checkInt("Your option: ", 0, 3);
    }

    public static void display() throws IOException {
        int choice;
        do {
            System.out.println("======Library Management System======");
        for (int i = 0; i < List.length; i++) {
            System.out.println((i + 1) + ". " + List[i]);
        }
        System.out.println("Enter 0 to exit!!");
            choice = getChoice();
            switch (choice) {
                case 0:
                    break;
                case 1:
                    System.out.println("");
                    MenuBook.display();
                    System.out.println("");
                    break;
                case 2:
                    System.out.println("");
                    MenuReader.display();
                    System.out.println("");
                    break;
                case 3:
                    System.out.println("");
                    MenuLending.display();
                    System.out.println("");
                    break;
            }
        } while (choice != 0);

    }
}
