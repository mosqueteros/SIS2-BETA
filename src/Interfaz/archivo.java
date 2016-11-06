package Interfaz;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
public class archivo {
    String aux[]={"ID empleado","cliente","carnet","ID vehiculo","fecha"};
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
           documento.add(new Paragraph(""+aux[0]+"    :    "+datos[0]+"\n"));
                recopilado=recopilado+" "+aux[0]+"    :    "+datos[0]+"\n";
                documento.add(new Paragraph("---------------------------------------------------------------------------------------------\n"));
                    recopilado=recopilado+"--------------------------------------------------------------------------------------------------\n";
                    documento.add(new Paragraph("DATOS DEL CLIENTE\n\n"));
                    recopilado=recopilado+"DATOS DEL CLIENTE\n\n";
                    documento.add(new Paragraph(""+aux[1]+"    :    "+datos[1]+"\n"));
                recopilado=recopilado+" "+aux[1]+"    :    "+datos[1]+"\n";
                documento.add(new Paragraph(""+aux[2]+"    :    "+datos[2]+"\n"));
                recopilado=recopilado+" "+aux[2]+"    :    "+datos[2]+"\n";
                documento.add(new Paragraph("--------------------------------------------------------------------------------------------\n"));
                    recopilado=recopilado+"--------------------------------------------------------------------------------------------------\n";
                    documento.add(new Paragraph("DATOS DEL VEHICULO\n\n"));
                    recopilado=recopilado+"DATOS DEL VEHICULO\n\n";
                documento.add(new Paragraph(""+aux[3]+"    :    "+datos[3]+"\n"));
                recopilado=recopilado+" "+aux[3]+"    :    "+datos[3]+"\n";
                documento.add(new Paragraph(""+aux[4]+"    :    "+datos[4]+"\n"));
                                recopilado=recopilado+" "+aux[4]+"    :    "+datos[4]+"\n";

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
