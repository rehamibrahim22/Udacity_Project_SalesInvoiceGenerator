/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ControllerPkg;

import ModelPkg.InvoiceHeaderCl;
import ModelPkg.InvoiceHeaderTable;
import ModelPkg.InvoiceLinesTable;
import ModelPkg.InvoiceLinesCl;
import ViewPkg.InvoiceDataFrame;
import ViewPkg.InvoiceHeaderDialog;
import ViewPkg.NewLineDialog;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;  
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import java.util.List;
import java.util.Date;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author reham.ibrahim
 */
public class ActionListeners extends JFrame implements ActionListener,ListSelectionListener {
    
     private InvoiceDataFrame dataframe;
     private SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private ArrayList<InvoiceHeaderCl> invHeaders = new ArrayList<>();
    private List<InvoiceLinesCl> invLines = new ArrayList<>();
    private InvoiceHeaderTable headerTableModel;
    private InvoiceLinesTable lineTableModel;
    private InvoiceHeaderDialog headerDialog;
    private NewLineDialog newLineDialog;
    

    
    public ActionListeners (InvoiceDataFrame dataframe)
    {
            this.dataframe = dataframe;
            
                    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand())
        {
            case "Open Files":
                openFiles();
                break;
            case "Save Files":
                saveFiles();
                break;
                
            case "Create new Invoice":
                showCreateNewInvoiceDialog();
                break;
                
                case "createInvoiceOK":
                    createInvoiceHeaderOK();
                break;
                
                case "createInvoiceCancel":
                    createInvoiceHeaderCancel();
                break;
                
            case "Delete Invoice":
                deleteHeader();
                break;
                
           
                                               
                case "Create New Line":
                    showNewLineDialog();
                        
                        break;
                
                
                case "NewLineOK":
                    creatNewLineOk();
                break;
                
                case "NewLineCancel":
                    createNewLineCancel();
                break;
                
                case "Delete Line":
                    deleteLine();
                    break;
                
                
        }
        }

    /*private void openFiles()  
    {
        JOptionPane.showMessageDialog(dataframe, "Please select Invoice Header file","Attention",JOptionPane.WARNING_MESSAGE);
        JFileChooser fs= new JFileChooser();
        fs.showOpenDialog(dataframe);
        try
        {
        int action= fs.showOpenDialog(dataframe);
       
        if(action == JFileChooser.APPROVE_OPTION)
        {
            File headerF = fs.getSelectedFile();
            Path headerPath= Paths.get(headerF.getAbsolutePath());
            List<String> headerLines = Files.readAllLines(headerPath);
            //ArrayList<InvoiceHeaderCl> invHeaders = new ArrayList<>();
            
           for (String headerLine : headerLines) //
           {
                String[] array = headerLine.split(",");
                int invNumb = Integer.parseInt(array[0]);
                Date invDate = df.parse(array[1]);
                String custname = array[2];
                
                InvoiceHeaderCl header = new InvoiceHeaderCl(invNumb,invDate,custname);
                    invHeaders.add(header);
                                               
                   }
           }
        }catch (IOException e){
            JOptionPane.showMessageDialog(dataframe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }catch (ParseException e) {
            JOptionPane.showMessageDialog(dataframe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        // start read second file (Invoice Lines)
         JOptionPane.showMessageDialog(dataframe, "Please select Invoice Lines  file","Attention",JOptionPane.WARNING_MESSAGE);
         fs.showOpenDialog(dataframe);
        try
        {
        int action= fs.showOpenDialog(dataframe);
       
        if(action == JFileChooser.APPROVE_OPTION)
        {   
            File invLineF = fs.getSelectedFile();
            Path invLinepath= Paths.get(invLineF.getAbsolutePath());
            List<String> invoiceLines = Files.readAllLines(invLinepath);
        }
            
            }catch(Exception e)
            {
            }
            }*/
    
        private void openFiles()
                
    {
        JOptionPane.showMessageDialog(dataframe, "Please select Invoice Header file","Attention",JOptionPane.WARNING_MESSAGE);
        JFileChooser fs= new JFileChooser();
         int action=fs.showOpenDialog(dataframe);
       
        //fs.showOpenDialog(dataframe);
       
        if(action == JFileChooser.APPROVE_OPTION)
        {
            File headerF = fs.getSelectedFile();
            try
            {
                FileReader headerFR= new FileReader(headerF);
            BufferedReader headerBR= new BufferedReader(headerFR);
            String headerLine = null;
            
            while ((headerLine = headerBR.readLine())!=null)
            {
                String[] headerSections= headerLine.split(",");
                int invno= Integer.parseInt(headerSections[0]);
                String datestr= headerSections[1];
                String custName= headerSections[2];
                
                Date invDate= df.parse(datestr);
                
                
                InvoiceHeaderCl header = new InvoiceHeaderCl(invno,invDate,custName);
                
                    invHeaders.add(header);
            }
            dataframe.setHeadersArray(invHeaders);
            
            JOptionPane.showMessageDialog(dataframe, "Please select Invoice Line file","Attention",JOptionPane.WARNING_MESSAGE);
            action= fs.showOpenDialog(dataframe);
       
        if(action == JFileChooser.APPROVE_OPTION)
        {
            File linesF= fs.getSelectedFile();
            FileReader linesFR= new FileReader(linesF);
            BufferedReader linesBR= new BufferedReader(linesFR);
            String linesLine= null;
            while((linesLine = linesBR.readLine())!= null)
                               {
                        String [] lineSections= linesLine.split(",");
                        int linesInvNum = Integer.parseInt(lineSections[0]);
                        String item = lineSections[1];
                        double itemPrice= Double.parseDouble(lineSections[2]);
                        int itemCount = Integer.parseInt(lineSections[3]);
                        
                        InvoiceHeaderCl headerobj= getRelatedInvoiceByInvNumb(linesInvNum);
                        InvoiceLinesCl line = new InvoiceLinesCl(headerobj, item, itemPrice, itemCount);
                        headerobj.getLines().add(line);
                        //String output= headerobj.toString();
                        //System.out.print(output);
                    }
                    
                  
                    
                    
                     headerTableModel = new InvoiceHeaderTable(invHeaders);
                dataframe.setInvoiceHeaderTableModel(headerTableModel);
                dataframe.getInvoiceHeaderTable().setModel(headerTableModel);
                System.out.println("open the Files Successfully");
                                      
                        }
       
            
        }catch (IOException e)
        {
        JOptionPane.showMessageDialog(dataframe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (ParseException e) {
            JOptionPane.showMessageDialog(dataframe, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        }
        
        showDataConsole();
        
    }
        
            private InvoiceHeaderCl getRelatedInvoiceByInvNumb(int invNumb)
            {
                InvoiceHeaderCl header= new InvoiceHeaderCl();
                
                for(InvoiceHeaderCl invh :invHeaders )
                    if(invNumb == invh.getInvNumber())
                    {
                        header= invh;
                        break;
                    }
                return header;
            }
    private void saveFiles() {
        
        String invoiceheaders = "";
        String lines = "";
        for (InvoiceHeaderCl header : dataframe.getHeadersArray()) {
            invoiceheaders += header.getDatainCSV();
            invoiceheaders += "\n";
            for (InvoiceLinesCl line : header.getLines()) {
                lines += line.getDataInFile();
                lines += "\n";
            }
        }
        JOptionPane.showMessageDialog(dataframe, "Please, select file to save header invoice records", "Warning", JOptionPane.WARNING_MESSAGE);
        JFileChooser fs = new JFileChooser();
        int result = fs.showSaveDialog(dataframe);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fs.getSelectedFile();
            try {
                FileWriter headerFW = new FileWriter(headerFile);
                headerFW.write(invoiceheaders);
                headerFW.flush();
                headerFW.close();

                JOptionPane.showMessageDialog(dataframe, "Please, select file to save lines data!", "Attension", JOptionPane.WARNING_MESSAGE);
                result = fs.showSaveDialog(dataframe);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fs.getSelectedFile();
                    FileWriter lineFW = new FileWriter(linesFile);
                    lineFW.write(lines);
                    lineFW.flush();
                    lineFW.close();
                }
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(dataframe, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        JOptionPane.showMessageDialog(dataframe, "Files saved successfully", "Success", JOptionPane.INFORMATION_MESSAGE);

        
    }
    
    
    private void showCreateNewInvoiceDialog() {
        
        headerDialog= new InvoiceHeaderDialog(this);
        headerDialog.setVisible(true);
        
    }
    private void createInvoiceHeaderCancel() {
        headerDialog.setVisible(false);
        headerDialog.dispose();
        headerDialog = null;
    }
    
    private void createInvoiceHeaderOK() {
        String customerName= headerDialog.getCustomerNameText().getText();
        String invoiceDatestr = headerDialog.getInvoiceDateText().getText();
        Date invoiceDate=new Date();
        
        headerDialog.setVisible(false);
         headerDialog.dispose();
        headerDialog=null;
        
        try
        {
            invoiceDate= df.parse(invoiceDatestr);
            int invNum= incrementLastInvoiceNumb();
            InvoiceHeaderCl headerobj= new InvoiceHeaderCl(invNum, invoiceDate,customerName);
            
            
            invHeaders.add(headerobj);
            headerTableModel = new InvoiceHeaderTable(invHeaders);
            dataframe.setInvoiceHeaderTableModel(headerTableModel);
            dataframe.getInvoiceHeaderTable().setModel(headerTableModel);
            
            headerTableModel.fireTableDataChanged();
            
  
        }catch (ParseException ex) {
             JOptionPane.showMessageDialog(dataframe, "invalid Date format,display today as default date ", "Invalid Date", JOptionPane.ERROR);
            ex.printStackTrace();
        }
        
    }

    private void deleteHeader() {
        int selectedrowindex= dataframe.getInvoiceHeaderTable().getSelectedRow();
        if(selectedrowindex >=0)
        {
            dataframe.getHeadersArray().remove(selectedrowindex);
            dataframe.getInvoiceHeaderTableModel().fireTableDataChanged();
            System.out.println("header row deleted");
           
            dataframe.getInvoiceLineTable().setModel(new InvoiceLinesTable(null));
            dataframe.setInvLinesArray(null);
            dataframe.getInvNumLabel().setText("");
            dataframe.getInvDateText().setText("");
            dataframe.getCustNameText1().setText("");
            dataframe.getInvTotalLabel().setText("");
            
            
        }
        
        
    }
    private void deleteHeader2() {
        int selectedrowindex= dataframe.getInvoiceHeaderTable().getSelectedRow();
        if(selectedrowindex >=0)
        {
            InvoiceHeaderCl header = dataframe.getInvoiceHeaderTableModel().getInvoicesList().get(selectedrowindex);
            dataframe.getInvoiceHeaderTableModel().getInvoicesList().remove(selectedrowindex);
             dataframe.getInvoiceHeaderTableModel().fireTableDataChanged();
             dataframe.setInvoiceLinesTableModel(new InvoiceLinesTable(new ArrayList<InvoiceLinesCl>()));
             dataframe.getInvoiceHeaderTable().setModel(dataframe.getInvoiceLineTableModel());
             dataframe.getInvoiceLineTableModel().fireTableDataChanged();
             
             dataframe.setInvLinesArray(null);
            dataframe.getInvNumLabel().setText("");
            dataframe.getInvDateText().setText("");
            dataframe.getCustNameText1().setText("");
            dataframe.getInvTotalLabel().setText("");
             
        }
    }

    
    
    private int incrementLastInvoiceNumb()
    {
        int last= 0;
        for (InvoiceHeaderCl header: invHeaders)
        {
            if(header.getInvNumber()> last)
            {
                last= header.getInvNumber();
            }
            
        }
        return last+1;
    }
private void showNewLineDialog() {
    
    newLineDialog=new NewLineDialog(this);
    
    newLineDialog.setVisible(true);
       
        
    }
    private void creatNewLineOk() {
        
         int itemCount = 1;
         double itemPrice=1;
         String itemName= newLineDialog.getItemNameText().getText();
         try
         {
         itemCount = Integer.parseInt(newLineDialog.getItemCountText().getText());
         itemPrice=Double.parseDouble(newLineDialog.getItemPriceText().getText());
         }catch (NumberFormatException e)
         {
             JOptionPane.showMessageDialog(dataframe, "Inserted numbers are invalid", "invalid Entry", JOptionPane.ERROR_MESSAGE);
         }
      
             
        int selectedHeaderRow = dataframe.getInvoiceHeaderTable().getSelectedRow();
        if(selectedHeaderRow>=0)
        {
         InvoiceHeaderCl invHeader =dataframe.getHeadersArray().get(selectedHeaderRow);
        InvoiceLinesCl invLine= new InvoiceLinesCl(invHeader, itemName, itemPrice, itemCount);
        
        //invHeader.addInvLine(invLine);
        
        dataframe.getInvLinesArray().add(invLine);
        InvoiceLinesTable LineTableModel=(InvoiceLinesTable)dataframe.getInvoiceLineTable().getModel();
        
       LineTableModel.fireTableDataChanged();   
       
       dataframe.getInvoiceHeaderTableModel().fireTableDataChanged();
        
        }
        dataframe.getInvoiceHeaderTable().setRowSelectionInterval(selectedHeaderRow, selectedHeaderRow);
        
         newLineDialog.setVisible(false);
         newLineDialog.dispose();
         newLineDialog= null;
       
         }

    private void createNewLineCancel() {
        newLineDialog.setVisible(false);
        newLineDialog.dispose();
        newLineDialog = null;
    }

    private void deleteLine() {
       /* int selectedlineIndex= dataframe.getInvoiceLineTable().getSelectedRow();
        int selectedHeaderIndex = dataframe.getInvoiceHeaderTable().getSelectedRow();
        if (selectedlineIndex>=0)
        {
            dataframe.getInvLinesArray().remove(selectedlineIndex);
            InvoiceLinesTable invLineTableModel= (InvoiceLinesTable)dataframe.getInvoiceLineTable().getModel();
            invLineTableModel.fireTableDataChanged();
            
           
           InvoiceLinesCl line = dataframe.getInvLinesArray().get(selectedHeaderIndex);
                  double lineTotalPrice=  line.getInvLineTotalPrice();
            
            dataframe.getInvTotalLabel().setText(""+lineTotalPrice);
            dataframe.getInvoiceHeaderTableModel().fireTableDataChanged();
            dataframe.getInvoiceLineTable().setRowSelectionInterval(selectedHeaderIndex, selectedHeaderIndex);
            
            
        }*/
      
        int selectedLineIndex = dataframe.getInvoiceLineTable().getSelectedRow();
        int selectedInvoiceIndex = dataframe.getInvoiceHeaderTable().getSelectedRow();
        if (selectedLineIndex != -1) {
            dataframe.getInvLinesArray().remove(selectedLineIndex);
            InvoiceLinesTable lineTableModel = (InvoiceLinesTable) dataframe.getInvoiceLineTable().getModel();
            lineTableModel.fireTableDataChanged();
            dataframe.getInvTotalLabel().setText(""+dataframe.getHeadersArray().get(selectedInvoiceIndex).getInvTotal());
            dataframe.getInvoiceHeaderTableModel().fireTableDataChanged();
            dataframe.getInvoiceHeaderTable().setRowSelectionInterval(selectedInvoiceIndex, selectedInvoiceIndex);
        }
    }

    private void showDataConsole() {
        
        System.out.println("***************************");
        
        for (InvoiceHeaderCl header : dataframe.getHeadersArray()) {
            System.out.println(header);
            for(int x=0;x<header.getLines().size();x++)
            {
                System.out.println(header.getLines().get(x));
            }
        }
        System.out.println("***************************");
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        
        int dataSelectedIndex = dataframe.getInvoiceHeaderTable().getSelectedRow();
       System.out.println("Selected Header Row index = "+ dataSelectedIndex);
       
       if(dataSelectedIndex>=0)
       {
          
           //InvoiceHeaderCl data= HeaderTable.getInvoicesList().get(dataSelectedIndex); //need to make sure 
           InvoiceHeaderCl data= dataframe.getHeadersArray().get(dataSelectedIndex);
           ArrayList<InvoiceLinesCl> lines= data.getLines();
           InvoiceLinesTable invLineTableModel= new InvoiceLinesTable(lines);
           dataframe.setInvLinesArray(lines);
           dataframe.getInvoiceLineTable().setModel(invLineTableModel);
           
           
          dataframe.getCustNameText1().setText(data.getCustName());
          dataframe.getInvDateText().setText(df.format(data.getInvDate()));
           dataframe.getInvNumLabel().setText(String.valueOf(data.getInvNumber()));
           dataframe.getInvTotalLabel().setText(String.valueOf(data.getInvTotal()));
           
           //ArrayList<InvoiceLinesCl> invLines= data.getLines();
           //setInvLinesArray(invLines); //need to check it again 
           //LinesTable= new InvoiceLinesTable(invLines);
           //invLinesjTable.setModel(LinesTable);
           //LinesTable.fireTableDataChanged();
          
          
    }
    }

   

    }
       
    

    


    

   
            
        
    
       
    

    

