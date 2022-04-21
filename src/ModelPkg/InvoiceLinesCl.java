/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelPkg;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceLinesCl {
    private InvoiceHeaderCl headerobj;
    private String itemName;
    private double itemPrice;
    private int itemCount;

    public InvoiceLinesCl(InvoiceHeaderCl headerobj, String itemName, double itemPrice, int itemCount) {
        this.headerobj = headerobj;
        this.itemName = itemName;
        this.itemPrice = itemPrice;
        this.itemCount = itemCount;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public InvoiceHeaderCl getHeaderobj() {
        return headerobj;
    }

    public void setHeaerobj(InvoiceHeaderCl headerobj) {
        this.headerobj = headerobj;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    
    public double getInvLineTotalPrice()
    {
        double total=0; 
        return total= itemPrice * itemCount;
        
    }
    
    public String getDataInFile() {
        return "" + getHeaderobj().getInvNumber()+ "," + getItemName() + "," + getItemPrice() + "," + getItemCount();
    }

    @Override
    public String toString() {
        return "        "+"InvoiceLines{"  +"item Name= " + itemName + ", item Price= " + itemPrice + ", item Count= " + itemCount + '}';
        //return "InvoiceLines{" + "headerobj= " + headerobj + ", itemName= " + itemName + ", itemPrice= " + itemPrice + ", itemCount= " + itemCount + '}';
    }

    
    }
    

