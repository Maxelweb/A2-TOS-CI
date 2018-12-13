package it.unipd.tos.business;

import it.unipd.tos.business.TotalBillCalculator;
import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import org.junit.rules.ExpectedException;
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
    
    /*  Test #2
     *  Numero degli elementi maggiore di quello permesso (20)
     * 
     */

    @org.junit.Rule
    public ExpectedException exception = ExpectedException.none();

    @Test
    public void NumberOfItemsExceeded20_Test() throws RestaurantBillException 
    {
        exception.expect(RestaurantBillException.class);
        exception.expectMessage("ERRORE: Non possono esserci più di 20 elementi.");

        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();

        for(int i = 1; i <= 25; i++)
            itemsOrdered.add(new MenuItem("item "+ i , MenuItem.items.PRIMO, 2.00 + i));

        TotalBillCalculator testBill = new TotalBillCalculator();
        testBill.getOrderPrice(itemsOrdered);
    }
    
    
    
    /*  Test #3
     *  Se il numero delle pizze è maggiore di 10, sconto la meno costosa.
     * 
     */

    @Test
    public void DiscountLessExpensivePizzaWith10PlusPizzaOrder_Test() throws RestaurantBillException 
    {

        List<MenuItem> itemsOrdered = new ArrayList<MenuItem>();

        for(int i = 1; i <= 9; i++)
            itemsOrdered.add(new MenuItem("Pizza Margherita "+ i , MenuItem.items.PIZZA, 5.00));
        itemsOrdered.add(new MenuItem("Bucatini al Pomodoro" , MenuItem.items.PRIMO, 8.50));
        itemsOrdered.add(new MenuItem("Spaghetti allo scoglio ", MenuItem.items.PRIMO, 9.50));
        itemsOrdered.add(new MenuItem("Pizza marinara" , MenuItem.items.PIZZA, 4.00));
        itemsOrdered.add(new MenuItem("Pizza ai Funghi" , MenuItem.items.PIZZA, 8.00));

        TotalBillCalculator testBill = new TotalBillCalculator();

        try 
        {
            assertEquals(71.0, testBill.getOrderPrice(itemsOrdered), 0.0);
        } 
        catch (RestaurantBillException e) 
        {
            e.getMessage();
        }
    }


}