package se.kth.iv1350.pos.model;

import se.kth.iv1350.pos.dbhandler.ItemDTO;

import java.util.ArrayList;
import java.util.Scanner;


public class Sale
{
    private double runningTotal;
    private double vat;
    private ArrayList<ItemDTO> items;
    private Scanner scanner = new Scanner(System.in);

    Sale()
    {
        items = new ArrayList<ItemDTO>();
    }

    ArrayList<ItemDTO> updateSale(ItemDTO item) throws RuntimeException
    {
        if (item.getIdentifier() == 0) {
            throw new java.util.NoSuchElementException("Item not found");
        }

        for (ItemDTO currentItem : items)
        {
            if(currentItem.getIdentifier() == item.getIdentifier())
            {
                item.setQuantity(currentItem.getQuantity() + 1);
                items.remove(currentItem);
                break;
            }
        }
        items.add(item);
        runningTotal = runningTotal + item.getPrice();
        return items;
    }

    double getRunningTotal()
    {
        return runningTotal;
    }

    ArrayList<ItemDTO> getItems()
    {
        return new ArrayList<ItemDTO>(items);
    }

    double getVatRate()
    {
        double totalVat = 0;
        for (ItemDTO item : items)
        {
            totalVat = totalVat + ((item.getQuantity() * item.getPrice()) * item.getVatRate());
        }
        vat = totalVat;
        return vat;
    }

    void addPayment()
    {
        while (true)
        {
            System.out.println("Running total: " + runningTotal);
            if(runningTotal == 0)
                break;
            System.out.print("Money: ");
            int amountOfMoney = scanner.nextInt();
            runningTotal = runningTotal - amountOfMoney;

            if(runningTotal <= 0)
                break;

        }

        if(runningTotal < 0)
        {
            System.out.println("Total change: " + Math.abs(runningTotal) + "kr ");
        }
        System.out.println("Moms: " + getVatRate() + "kr ");
    }

    public String toString()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("---\n");
        for (ItemDTO item : items)
        {
            sb.append("- " + item.getName() + " " + item.getQuantity() + "st " + item.getPrice() * item.getQuantity() + "kr\n");
        }
        sb.append("Total: " + runningTotal + "kr");
        sb.append("\n---\n");
        return sb.toString();
    }
}
