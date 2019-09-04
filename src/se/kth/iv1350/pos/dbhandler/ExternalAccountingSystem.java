package se.kth.iv1350.pos.dbhandler;

import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

import java.util.ArrayList;

public class ExternalAccountingSystem
{

    ArrayList<SaleDTO> logList;

    public ExternalAccountingSystem()
    {
        logList = new ArrayList<SaleDTO>();
    }

    public void logSale(SaleDTO completedSale)
    {
        logList.add(completedSale);
    }

    ArrayList<SaleDTO> retrieveLogs()
    {
        ArrayList<SaleDTO> copyOfLogs = new ArrayList<>();
        for (SaleDTO saleDTO : logList)
        {
            copyOfLogs.add(saleDTO);
        }
        return copyOfLogs;
    }
}
