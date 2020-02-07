package se.kth.iv1350.pos.controller;

import se.kth.iv1350.pos.dbhandler.ExternalAccountingSystem;
import se.kth.iv1350.pos.model.CashRegister;
import se.kth.iv1350.pos.model.ObserverSale;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

public class Controller
{
    private CashRegister cashRegister;
    private ExternalAccountingSystem eAS;

    public Controller()
    {
        cashRegister = new CashRegister();
        eAS = new ExternalAccountingSystem();
    }

    public Sale startNewSale()
    {
        return cashRegister.startNewSale();
    }

    public void scanItem(int itemID)
    {
        cashRegister.scanItem(itemID);
    }

    public Sale pay()
    {
        return cashRegister.payment();
    }

    public SaleDTO endSale(Sale sale)
    {
        SaleDTO endedSaleDTO = cashRegister.endSale(sale);
        eAS.logSale(endedSaleDTO);
        return endedSaleDTO;
    }

    public String showSale()
    {
        return cashRegister.showSale();
    }

    public void createNewObserver(ObserverSale saleOB)
    {
        cashRegister.addNewObeserverSale(saleOB);
    }
}
