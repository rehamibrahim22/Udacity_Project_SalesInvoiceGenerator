/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelPkg;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceHeaderCl {
    private int invNumber;
    private Date invDate;
    private String custName;
    
    private ArrayList<InvoiceLinesCl>invLines;

    public InvoiceHeaderCl() {
        
    }

    public InvoiceHeaderCl(int invNumber, Date invDate, String custName,ArrayList<InvoiceLinesCl>invLines) {
        this.invNumber = invNumber;
        this.custName = custName;
        this.invDate = invDate;
        this.invLines= invLines;
    }
    
    public InvoiceHeaderCl(int invNumber,Date invDate, String custName) {
        this.invNumber = invNumber;
        this.custName = custName;
        this.invDate = invDate;
      
    }

    public int getInvNumber() {
        return invNumber;
    }

    public String getCustName() {
        return custName;
    }

    public Date getInvDate() {
        return invDate;
    }
    
    public ArrayList<InvoiceLinesCl> getLines()
    {
        if(invLines==null)
            invLines= new ArrayList<>();
        return invLines;
    }
    public void setLines(ArrayList<InvoiceLinesCl>lines)
    {
        this.invLines= lines;
    }
     public void setInvNumber(int invNumber) {
        this.invNumber = invNumber;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public void setInvLines(ArrayList<InvoiceLinesCl> invLines) {
        this.invLines = invLines;
    }
    
    public void addInvLine(InvoiceLinesCl line) {
        getLines().add(line);
    }
    
     public double getInvTotal()
    {
        double invtotal=0.00;
        for(int x=0;x<getLines().size();x++)
        {
            invtotal += getLines().get(x).getInvLineTotalPrice();
        }
        
        return invtotal;
        }

     public String getDatainCSV(){
         DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvNumber()+ "," + df.format(getInvDate()) + "," + getCustName();
         
     }
    @Override
    public String toString() {
        return "Invoice Header{" + "invoice Number= " + invNumber + ", invoice Date= " + invDate + ", customer Name= " + custName + '}';
        
    }
    }

    
   
            
            
    
    
    
