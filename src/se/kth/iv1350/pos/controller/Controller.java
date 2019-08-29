package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.Sale;

public class Controller
{
    private CashRegister cashRegister;

    public Controller()
    {
        cashRegister = new CashRegister();
    }

    public Sale startNewSale()
    {
        return cashRegister.startNewSale();
    }

    public void scanItem(int itemID)
    {
        cashRegister.scanItem(itemID);
    }

    public Sale endSale()
    {
        return cashRegister.payment();
    }

    public String showSale()
    {
        return cashRegister.showSale();
    }
}
