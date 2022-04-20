/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelPkg;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceLinesTable extends AbstractTableModel {

    private List<InvoiceLinesCl> invLines;
    
    
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceLinesTable(List<InvoiceLinesCl> invLines)
    {
        this.invLines= invLines;
    }

    public List<InvoiceLinesCl> getInvLines() {
        return invLines;
    }

    public List<InvoiceLinesCl> getInvoicesList() 
    
  {
                return invLines;
    }
    
    
    @Override
    public int getRowCount() {
        //return invLines.size();
        return invLines == null ? 0:  invLines.size();
    }

    @Override
    public int getColumnCount() {
         return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex == 0)
            return "Item Name";
        else if (columnIndex == 1)
            return "Item Price";
        else if (columnIndex == 2)
            return "Item Count";
        else if (columnIndex == 3)
            return "Line Total";
        return "empty";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0)
            return String.class;
        else if (columnIndex == 1)
            return Double.class ;
        else if (columnIndex == 2)
            return Integer.class;
        else if (columnIndex == 3)
            return Double.class;
        return null;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        if(invLines == null)
        {
            return "empty";
        }
        else{ 
            InvoiceLinesCl row=invLines.get(rowIndex);
        
        if(columnIndex == 0)
            return row.getItemName();
        else if (columnIndex == 1)
            return row.getItemPrice();
        else if (columnIndex == 2)
            return row.getItemCount();
        else if (columnIndex == 3)
            return row.getInvLineTotalPrice();
        return "empty";
        }
    }

    
}
