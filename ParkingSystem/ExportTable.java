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
	      
		   for(int i=0; i < model.getColumnCount(); i++) //��ȡ�������ѱ�ͷд��EXCEL
		   {
	          
			  bWriter.write(model.getColumnName(i));
	         
			  bWriter.write("\t");
	       }
	      
		   bWriter.newLine();
	       
		   for(int i=0; i< model.getRowCount(); i++) //��ȡ����
		   {
	         
			 for(int j=0; j < model.getColumnCount(); j++) 
			    {
	              
				    bWriter.write(model.getValueAt(i,j).toString());//��JTable��ÿһ����Ԫ���ֵд�뵥Ԫ����
	              
				    bWriter.write("\t");
	            }
	                bWriter.newLine();
	       }
	       bWriter.close();
	   }

}
