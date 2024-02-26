/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Manage;

import DataStructure.LinkedList;
import DataStructure.Node;
import Entities.Books;
import Entities.Reader;
import Entities.Lending;
import java.util.Scanner;

/**
 *
 * @author Admin
 */
public class Validation {
    private static Scanner s=new Scanner(System.in);
    public static int checkInt(String mess, int min, int max){
        while (true){
            try{
                System.out.print(mess);
                int check=Integer.parseInt(s.nextLine().trim());
                if (check>=min && check<=max) return check;
                throw new NumberFormatException();
            } catch (NumberFormatException e){
                System.err.println("Please enter a valid integer");
            }          
        }
        
    }
    public static Double checkDouble(String mess){
        while (true){
            try{
                System.out.print(mess);
                Double check=Double.parseDouble(s.nextLine().trim());
                if (check>=0) return check;
                throw new NumberFormatException();
            } catch (NumberFormatException e){
                System.err.println("Please enter a valid double");
            }          
        }
        
    }
    public static boolean checkYesNo(String mess){
        while (true){
            try{
                System.out.print(mess);
                String check=s.nextLine().trim();
                if (check.equalsIgnoreCase("Y")) return true;
                else if (check.equalsIgnoreCase("N")) return false;
                throw new NumberFormatException();
            } catch (NumberFormatException e){
                System.err.println("Please enter Y or N!");
            }          
        }
        
    }
    //Check availability of Code in LMS
    public static boolean isExistBook(String code, LinkedList l){
        Node p= l.first();
        while (p!=null){
            Books h= (Books) p.getInfor();
            if (h.getBcode().equals(code)) return true;
            p= p.getNext();
        }
        return false;
    }
    public static boolean isExistReader(String code, LinkedList l){
        Node p= l.first();
        while (p!=null){
            Reader h= (Reader) p.getInfor();
            if (h.getRcode().equals(code)) return true;
            p= p.getNext();
        }
        return false;
    }
    
    public static Lending getExistLending(String bcode,String rcode, LinkedList l){
        Node p= l.first();
        while (p!=null){
            Lending h= (Lending) p.getInfor();

            if (h.getBcode().equals(bcode) && h.getRcode().equals(rcode)
                    && h.getState()!=2) return h;
            p= p.getNext();
        }
        return null;
    }
}
