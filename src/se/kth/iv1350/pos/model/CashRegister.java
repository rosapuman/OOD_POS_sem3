package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.Inventory;
import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.*;
import java.util.logging.Logger;

public class CashRegister
{
    private double change;
    private Inventory inventory = new Inventory();
    private Sale currentSale;
    private float totalCashRegister;
    final static Logger log = Logger.getAnonymousLogger();
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

    public void scanItem(int itemID) throws Exception
    {
        boolean itemAvailable = inventory.checkItemID(itemID);

        try {
            if (itemAvailable) {
                ItemDTO item = inventory.getItem(itemID);
                currentSale.updateSale(item);
            }
        }
        catch(DBFailureException dbException){
            System.out.println("INTERNAL LOG:");
            log.log(Level.SEVERE, "EXCEPTION HAS BEEN THROWN", dbException);
            throw new DBFailureException();
        }
        catch(Exception idException){
            System.out.println("INTERNAL LOG:");
            log.log(Level.SEVERE, "EXCEPTION HAS BEEN THROWN", idException);
            throw new IdentifierInvalidException();
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
        }
    }
}
