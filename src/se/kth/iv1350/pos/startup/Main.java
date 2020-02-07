package se.kth.iv1350.pos.startup;

import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;
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
        Sale completedSale = contr.pay();
        contr.endSale(completedSale);
        System.out.println("KVITTO:\n" + completedSale.toString());
    }
}
