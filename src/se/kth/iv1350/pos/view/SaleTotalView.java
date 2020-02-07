package se.kth.iv1350.pos.view;


import se.kth.iv1350.pos.model.ObserverSale;

public class SaleTotalView implements ObserverSale
{

    @Override
    public void endedSaleUpdate(float endedSale) {
        displayTotalSale(endedSale);
    }

    public void displayTotalSale(float totalSale){

        System.out.println("ObserverSale: Total of all sales: " + totalSale);
    }
}
