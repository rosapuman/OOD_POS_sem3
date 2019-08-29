package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;
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

        //Skapa metoder här, scanItem osv
        contr.startNewSale();
        int scannerID;
        while(true)
        {
            contr.scanItem(scannerID = scanner.nextInt());
            System.out.println(contr.showSale());
            if (scannerID == 666)
            {
                break;
            }
        }
        eAS.logSale(contr.endSale());
    }
}
