////////////////////////////////////////////////////////////////////
// [Mariano] [Sciacco] [1142498]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business;

import java.util.List;

import it.unipd.tos.business.exception.RestaurantBillException;
import it.unipd.tos.model.MenuItem;

public class TotalBillCalculator implements RestaurantBill{

    public double getOrderPrice(List<MenuItem> itemsOrdered) throws RestaurantBillException {

        double totalBill = 0.0;
        int itemsNumber = itemsOrdered.size();


        for(MenuItem x : itemsOrdered)
        {
            totalBill += x.getPrice();
        }

        if(itemsNumber > 20)
        {
            throw new RestaurantBillException("ERRORE: Non possono esserci più di 20 elementi.");
        }
        
        return totalBill;

    }

}
