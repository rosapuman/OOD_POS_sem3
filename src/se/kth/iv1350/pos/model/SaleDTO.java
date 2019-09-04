package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;

public class SaleDTO
{
    private double vatRate;
    private double runningTotal;
    private ArrayList<ItemDTO> items;

    public SaleDTO (double vatRate, double runningTotal, ArrayList<ItemDTO> items)
    {
        this.vatRate = vatRate;
        this.runningTotal = runningTotal;
        for (ItemDTO item : items)
        {
            this.items.add(item);
        }
    }

    public SaleDTO (Sale completedSale)
    {
        this.vatRate = completedSale.getVatRate();
        this.runningTotal = completedSale.getRunningTotal();
        this.items = completedSale.getItems();
    }

    public double getVatRate()
    {
        return vatRate;
    }

    public ArrayList<ItemDTO> getItems()
    {
        return items;
    }

    public double getRunningTotal()
    {
        return runningTotal;
    }



}
