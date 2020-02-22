package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;
import se.kth.iv1350.pos.model.*;
import se.kth.iv1350.pos.view.SaleTotalView;
import se.kth.iv1350.pos.view.View;

import java.util.Scanner;

class Main
{
    public static void main(String[] args)
    {
        Controller contr             = new Controller();
        View view                    = new View(contr);
        ExternalAccountingSystem eAS = new ExternalAccountingSystem();
        Inventory inventory          = new Inventory();
        Scanner scanner              = new Scanner(System.in);
        SaleTotalView totalSaleV     = new SaleTotalView();

        contr.startNewSale();
        contr.createNewObserver(totalSaleV);
        int scannerID;
        while(true)
        {
            try{
                scannerID = scanner.nextInt();
                if (scannerID == 666)
                {
                    break;
                }

                contr.scanItem(scannerID);
                System.out.println(contr.showSale());
            }
            catch (DBFailureException dbException){
                System.out.println("MESSAGE TO USER:\n" + "Database error, contact the administration");
            }
            catch(Exception idException){
                System.out.println("MESSAGE TO USER:\n" + "The entered Item is invalid, please enter a valid identifier: ");
            }
        }
        Sale completedSale = contr.pay();
        contr.endSale(completedSale);
        System.out.println("KVITTO:\n" + completedSale.toString());
    }
}
