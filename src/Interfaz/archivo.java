package Interfaz;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class archivo {
    String aux[]={"ID Venta","Empleado","ID vendedor","Nombre","CI","ID vehiculo"};
    String recopilado;
    public void archivarDocument(String[] datos) {
        recopilado="";
        try {
            FileOutputStream archivo = null;
            
            archivo = new FileOutputStream("Ultima_Impresion.pdf");
            Document documento = new Document();
            PdfWriter.getInstance(documento, archivo);
            documento.open();
            documento.add(new Paragraph("                FACTURA DE VENTA DE VEHICULO AUTORIZADO\n\n"));
            recopilado=recopilado+ "                     FACTURA DE VENTA DE VEHICULO AUTORIZADO\n\n";
           documento.add(new Paragraph("DATOS DEL VENDEDOR\n\n"));
           recopilado=recopilado+"DATOS DEL VENDEDOR\n\n";
            for (int i = 0; i <datos.length; i++) {
                if(i==3){
                    documento.add(new Paragraph("---------------------------------------------------------------------------------------------\n"));
                    recopilado=recopilado+"--------------------------------------------------------------------------------------------------\n";
                    documento.add(new Paragraph("DATOS DEL CLIENTE\n\n"));
                    recopilado=recopilado+"DATOS DEL CLIENTE\n\n";
                }
                if(i==5){
                    documento.add(new Paragraph("--------------------------------------------------------------------------------------------\n"));
                    recopilado=recopilado+"--------------------------------------------------------------------------------------------------\n";
                    documento.add(new Paragraph("DATOS DEL VEHICULO\n\n"));
                    recopilado=recopilado+"DATOS DEL VEHICULO\n\n";
                }
                documento.add(new Paragraph(""+aux[i]+"    :    "+datos[i]+"\n"));
                recopilado=recopilado+" "+aux[i]+"    :    "+datos[i]+"\n";
            }
            documento.close();
            archivo.close();
        } catch (FileNotFoundException ex) {
        } catch (DocumentException ex) {
        } catch (IOException ex) {
        }
    }

    public String GetarchivoRecopilado() {
        return recopilado;
    }
    
}
