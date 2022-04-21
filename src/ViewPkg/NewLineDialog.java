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

/**
 *
 * @author reham.ibrahim
 */
public class NewLineDialog extends JDialog {
    
       
    private JTextField itemNameText;
    private JTextField itemCountText;
    private JTextField itemPriceText;
    private JLabel itemNameLabel;
    private JLabel itemCountLabel;
    private JLabel itemPriceLabel;
    private JButton OkbBtn;
    private JButton cancelBtn;
    InvoiceDataFrame dataFrame;

   
    ActionListeners actionListeners;
    
    public NewLineDialog(ActionListeners actionListeners) {
        
        
        itemNameLabel = new JLabel("Item Name:");
        itemNameText = new JTextField(20);
        itemCountLabel = new JLabel("Item Count:");
        itemCountText = new JTextField(20);
        itemPriceLabel = new JLabel("Item Price:");
        itemPriceText = new JTextField(20);
        
        OkbBtn = new JButton("OK");
        cancelBtn = new JButton("Cancel");
        
        OkbBtn.setActionCommand("NewLineOK");
        cancelBtn.setActionCommand("NewLineCancel");
        
        
        //OkbBtn.addActionListener(dataframe);
        //cancelBtn.addActionListener(dataframe);
        
        OkbBtn.addActionListener(actionListeners);
        cancelBtn.addActionListener(actionListeners);
        
        setLayout(new GridLayout(4, 2));
        
        add(itemNameLabel);
        add(itemNameText);
        add(itemCountLabel);
        add(itemCountText);
        add(itemPriceLabel);
        add(itemPriceText);
        add(OkbBtn);
        add(cancelBtn);
        
        pack();
    }

    public JTextField getItemNameText() {
        return itemNameText;
    }

    public JTextField getItemCountText() {
        return itemCountText;
    }

    public JTextField getItemPriceText() {
        return itemPriceText;
    }

    

   
    
}

