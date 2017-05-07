package ParkingSystem;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JTable;
import javax.swing.table.TableModel;

public class ExportTable {
	public static void exportTable(JTable table, String file) throws IOException {
	      
		   TableModel model = table.getModel();
	       
		   BufferedWriter bWriter = new BufferedWriter(new FileWriter(file));
	      
		   for(int i=0; i < model.getColumnCount(); i++) //获取列数并把表头写入EXCEL
		   {
	          
			  bWriter.write(model.getColumnName(i));
	         
			  bWriter.write("\t");
	       }
	      
		   bWriter.newLine();
	       
		   for(int i=0; i< model.getRowCount(); i++) //获取行数
		   {
	         
			 for(int j=0; j < model.getColumnCount(); j++) 
			    {
	              
				    bWriter.write(model.getValueAt(i,j).toString());//把JTable中每一个单元格的值写入单元格中
	              
				    bWriter.write("\t");
	            }
	                bWriter.newLine();
	       }
	       bWriter.close();
	   }

}
