/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelPkg;

import java.text.SimpleDateFormat;
import java.util.List;
import javax.swing.event.TableModelListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reham.ibrahim
 */
public class InvoiceHeaderTable extends AbstractTableModel {

    private List<InvoiceHeaderCl> invHeaders;
    //private List<InvoiceLinesCl>invLines;
    
    private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    
    public InvoiceHeaderTable(List<InvoiceHeaderCl> invHeaders)
    {
        this.invHeaders= invHeaders;
    }

    public List<InvoiceHeaderCl> getInvHeaders() {
        return invHeaders;
    }

    public List<InvoiceHeaderCl> getInvoicesList() 
    
  {
      System.out.println("am here");
      //if(invHeaders==null)
           //invHeaders= new ArrayList<>();
        
        return invHeaders;
    }
    
    
    
    @Override
    public int getRowCount() {
        return invHeaders.size();
    }

    @Override
    public int getColumnCount() {
         return 4;
    }

    @Override
    public String getColumnName(int columnIndex) {
        if(columnIndex == 0)
            return "Invoice Number";
        else if (columnIndex == 1)
            return "Invoice Date";
        else if (columnIndex == 2)
            return "Customer Name";
        else if (columnIndex == 3)
            return "Invoice Total";
        return "empty";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        if(columnIndex == 0)
            return Integer.class;
        else if (columnIndex == 1)
            return String.class ;
        else if (columnIndex == 2)
            return String.class;
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
        InvoiceHeaderCl row=invHeaders.get(rowIndex);
        
        if(columnIndex == 0)
            return row.getInvNumber();
        else if (columnIndex == 1)
            return df.format(row.getInvDate());
        else if (columnIndex == 2)
            return row.getCustName();
        else if (columnIndex == 3)
            return row.getInvTotal();
        return null;
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        
    }
    
}
