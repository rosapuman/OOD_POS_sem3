package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class CashRegister
{
    private double change;
    private Inventory inventory = new Inventory();
    private Sale currentSale;
    private float totalCashRegister;
    ArrayList<ObserverSale> saleObservers = new ArrayList<ObserverSale>();


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
    }

    public Sale payment()
    {
        currentSale.addPayment();
        return currentSale;
    }

    public SaleDTO endSale(Sale endSale)
    {

        informObserverSale();
        return currentSale.makeSaleComplete(currentSale);
    }

    public String showSale()
    {
        return currentSale.printSale();
    }

    public double showVAT()
    {
        return currentSale.getVatRate();
    }

    public void addNewObeserverSale(ObserverSale saleOB){saleObservers.add(saleOB);}

    public void informObserverSale(){
        for(ObserverSale saleOB : saleObservers){
            saleOB.endedSaleUpdate(totalCashRegister);
        }//HÄR ÄR JAG, KOLLA UPP AMOUNTNEEDED FÖR TOTALCASHREGISTER?????
    }
}
