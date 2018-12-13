////////////////////////////////////////////////////////////////////
// [Mariano] [Sciacco] [1142498]
////////////////////////////////////////////////////////////////////

package it.unipd.tos.business.exception;

public class RestaurantBillException extends Throwable {

    private String mex;

    public RestaurantBillException(String e) {
        this.mex = e;
    }

    public String getMessage() {
        return this.mex;
    }
}
