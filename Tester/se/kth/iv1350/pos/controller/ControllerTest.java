package se.kth.iv1350.pos.controller;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import se.kth.iv1350.pos.model.Sale;
import se.kth.iv1350.pos.model.SaleDTO;

public class ControllerTest
{
    private Sale sale;
    private Controller control;
    @Before
    public void setUp()
    {
        control = new Controller();
    }
    @After
    public void tearDown()
    {
        control = null;
        sale = null;
    }
    @Test
    public void endSaleNotNull()
    {
        sale = control.startNewSale();
        SaleDTO saleDTO = control.endSale(sale);
        Assert.assertNotNull("SaleDTO är null!", saleDTO);
    }
}
