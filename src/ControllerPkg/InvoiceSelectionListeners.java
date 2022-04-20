/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerPkg;

import ModelPkg.InvoiceHeaderCl;
import ModelPkg.InvoiceLinesCl;
import ModelPkg.InvoiceLinesTable;
import ViewPkg.InvoiceDataFrame;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceSelectionListeners implements ListSelectionListener {

    private InvoiceDataFrame dataframe;
    private DateFormat dataFormat = new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceSelectionListeners(InvoiceDataFrame dataframe) {
        this.dataframe = dataframe;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("am running valuechange from invoiceselectionlistener");
        int selectedHeaderIndex = dataframe.getInvHTbl().getSelectedRow();
        
        InvoiceHeaderCl selectedHeader = dataframe.getHeadersArray().get(selectedHeaderIndex);
        ArrayList<InvoiceLinesCl> lines = selectedHeader.getLines();
        InvoiceLinesTable lineTableModel = new InvoiceLinesTable(lines);
            
        dataframe.setInvLinesArray(lines);
        dataframe.getInvLTbl().setModel(lineTableModel);
            
        dataframe.getCustNameText1().setText(selectedHeader.getCustName());
        dataframe.getInvDateText().setText(dataFormat.format(selectedHeader.getInvDate()));
        dataframe.getInvNumLabel().setText(String.valueOf(selectedHeader.getInvNumber()));
        dataframe.getInvTotalLabel().setText(String.valueOf(selectedHeader.getInvTotal()));
            
            
            
            
           
            
           
    }
    
    
    
}
