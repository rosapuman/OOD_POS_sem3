package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

public class CashRegister
{
    private double change;
    private Inventory inventory = new Inventory();
    private Sale currentSale;

    public CashRegister()
    {

    }

    public Sale startNewSale()
    {
        this.currentSale = new Sale();
        return currentSale;
    }

    public double getChange()
    {
        return change;
    }

    public void scanItem(int itemID)
    {
        boolean itemAvailable = inventory.checkItemID(itemID);

        if(itemAvailable)
        {
            ItemDTO item = inventory.getItem(itemID);
            currentSale.updateSale(item);
        }
        else {
            System.out.println("Item not found");
        }
    }

    public Sale payment()
    {
        currentSale.addPayment();
        return currentSale;
    }

    public String showSale()
    {
        return currentSale.toString();
    }

    public double showVAT()
    {
        return currentSale.getVatRate();
    }
}
