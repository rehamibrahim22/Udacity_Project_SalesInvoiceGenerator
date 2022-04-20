/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerPkg;

import ModelPkg.InvoiceHeaderCl;
import ModelPkg.InvoiceHeaderTable;
import ModelPkg.InvoiceLinesCl;
import ViewPkg.InvoiceDataFrame;
import ViewPkg.InvoiceHeaderDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.swing.JFrame;

/**
 *
 * @author reham.ibrahim
 */
public class ButtonsListeners extends JFrame implements ActionListener  {

    private InvoiceDataFrame dataframe;
    
    
    private List<InvoiceHeaderCl> invHeaders = new ArrayList<>();
    private List<InvoiceLinesCl> invLines = new ArrayList<>();
    private InvoiceHeaderTable HeaderTable;
    private InvoiceHeaderDialog headerDialog;
     private SimpleDateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");
   
    
    public ButtonsListeners (InvoiceDataFrame dataframe)
    {
            this.dataframe = dataframe;
                    }
    @Override
    public void actionPerformed(ActionEvent e) {
          /*switch (e.getActionCommand())
        {
            case "Create new Invoice":
                createNewInvoice();
                break;
            case "Delete Invoice":
                deleteInvoice();
                break;
                case "Save":
                    saveChanges();
                break;
                case "Cancel":
                    cancelChanges();
                break;
                
                case "createInvoiceOK":
                 
                createInvoiceOK();
                break;
                
                case "createInvoiceCancel":
                createInvoiceCancel();
                break;
        }*/
       
    }

    /*private void createNewInvoice() {
        
        headerDialog= new InvoiceHeaderDialog(this);
        headerDialog.setVisible(true);
        
    }*/
    
    /*private void createInvoiceCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
    }*/

    /*private void deleteInvoice() {
        
    }*/

    private void saveChanges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void cancelChanges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /*private void createInvoiceOK() {
        String customerName= headerDialog.getCustomerNameText().getText();
        String invoiceDatestr = headerDialog.getInvoiceDateText().getText();
        headerDialog.setVisible(false);
         headerDialog.dispose();
        headerDialog=null;
        
        try
        {
            Date invoiceDate= dataFormat.parse(invoiceDatestr);
            int invNum= incrementLastInvoiceNumb();
            InvoiceHeaderCl headerobj= new InvoiceHeaderCl(invNum, invoiceDate,customerName);
            invHeaders.add(headerobj);
            HeaderTable.fireTableDataChanged();
            
            
        }catch (ParseException ex) {
            ex.printStackTrace();
        }
        
    }*/
    
    /* int incrementLastInvoiceNumb()
    {
        int limit= 0;
        for (InvoiceHeaderCl header: invHeaders)
        {
            if(header.getInvNumber()> limit)
            {
                limit= header.getInvNumber();
            }
            
        }
        return limit+ 1;
    }*/

    }

    
