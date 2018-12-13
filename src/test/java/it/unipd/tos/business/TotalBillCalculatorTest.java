package it.unipd.tos.business;

import it.unipd.tos.business.TotalBillCalculator;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TotalBillCalculatorTest {

    /*	Test #1
     *  Calcolo totale della somma
     * 
     */

    @Test
    public void SimpleTotalSumOfItems_Test() 
    {
        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();
        TotalBillCalculator testBill = new TotalBillCalculator();

        itemsOrdered.add(new MenuItem("Maccheroni alla Salernitana", MenuItem.items.PRIMO, 12.00));
        itemsOrdered.add(new MenuItem("Pizza Capricciosa", MenuItem.items.PIZZA, 6.50));

        try 
        {
            assertEquals(18.5, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (RestaurantBillException e) 
        {
            e.getMessage();
        }

    }
}