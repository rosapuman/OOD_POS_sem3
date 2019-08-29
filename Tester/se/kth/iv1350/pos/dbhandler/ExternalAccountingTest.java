package se.kth.iv1350.pos.dbhandler;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.controller.Controller;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

import java.util.ArrayList;

public class ExternalAccountingTest
{
    private Sale sale;
    private ExternalAccountingSystem eAS;
    @Before
    public void setUp()
    {
        Controller control = new Controller();
        sale = control.startNewSale();
        eAS = new ExternalAccountingSystem();
    }
    @After
    public void tearDown()
    {
        sale = null;
        eAS = null;
    }
    @Test
    public void logSale()
    {
        ArrayList<SaleDTO> oldLogs = eAS.retrieveLogs();
        eAS.logSale(sale);
        ArrayList<SaleDTO> newLogs = eAS.retrieveLogs();
        Assert.assertNotSame(oldLogs, newLogs);
    }
}