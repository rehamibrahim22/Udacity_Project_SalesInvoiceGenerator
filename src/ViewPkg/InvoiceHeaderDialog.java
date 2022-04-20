/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewPkg;

import ControllerPkg.ActionListeners;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import ViewPkg.InvoiceDataFrame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import ControllerPkg.ButtonsListeners;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceHeaderDialog extends JDialog {
    
       
    private JTextField CustomerNameText;
    private JTextField InvoiceDateText;
    private JLabel CustomerNameLabel;
    private JLabel invoiceDateLabel;
    private JButton OkbBtn;
    private JButton cancelBtn;
    InvoiceDataFrame dataFrame;

    ButtonsListeners buttonActionListeners;
    ActionListeners actionListeners;
    
    public InvoiceHeaderDialog(ActionListeners actionListeners) {
        
        
        CustomerNameLabel = new JLabel("Customer Name:");
        CustomerNameText = new JTextField(20);
        invoiceDateLabel = new JLabel("Invoice Date:");
        InvoiceDateText = new JTextField(20);
        OkbBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        OkbBtn.setActionCommand("createInvoiceOK");
        cancelBtn.setActionCommand("createInvoiceCancel");
        
        
        //OkbBtn.addActionListener(dataframe);
        //cancelBtn.addActionListener(dataframe);
        
        OkbBtn.addActionListener(actionListeners);
        cancelBtn.addActionListener(actionListeners);
        
        setLayout(new GridLayout(3, 2));
        
        add(invoiceDateLabel);
        add(InvoiceDateText);
        add(CustomerNameLabel);
        add(CustomerNameText);
        add(OkbBtn);
        add(cancelBtn);
        
        pack();
    }

    InvoiceHeaderDialog() {
                

        
    }

    public JTextField getCustomerNameText() {
        return CustomerNameText;
    }

    public JTextField getInvoiceDateText() {
        return InvoiceDateText;
    }

   
        
    }
    
    
     
        
    
    
    
    
    
    
    

