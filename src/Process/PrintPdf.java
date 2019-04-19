
package Process;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.LinkedList;

public class PrintPdf {
    private Document document;
    private int cols;
    
    public void print(String title, String docName, LinkedList listCriteria, LinkedList listPelamarId, LinkedList listPelamarNama, double[][]data) throws FileNotFoundException, DocumentException {
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("laporan/"+docName+".pdf"));
        cols = listCriteria.size();
        String date = "Tanggal : "+new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        
        try{
            document.open();
            Image image1 = Image.getInstance("src/Res/header print.png");
            image1.setAbsolutePosition(2f, 700f);
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.add(title);
            
            Paragraph paragraph1 = new Paragraph();
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            paragraph1.add(date);
            
            document.add(image1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            PdfPTable table = new PdfPTable(cols+2);
            table.addCell("Alternatif");
            table.addCell("Nama");
            for(int i=0; i<cols; i++){
                table.addCell((String)listCriteria.get(i));
            }
            
            for(int i=0; i<listPelamarId.size(); i++){
                table.addCell((String)listPelamarId.get(i));
                table.addCell((String)listPelamarNama.get(i));
                for(int j=0; j<cols; j++){
                    table.addCell(""+data[i][j]);
                }
            }
            document.add(table);
            document.close();
        }catch (Exception e) {
        }
    }
    
    public void print(String title, String docName, LinkedList listCriteria, LinkedList listPelamarId, LinkedList listPelamarNama, LinkedList listResult, double[][]data) throws FileNotFoundException, DocumentException {
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("laporan/"+docName+".pdf"));
        cols = listCriteria.size();
        String date = "Tanggal : "+new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        
        try{
            document.open();
            Image image1 = Image.getInstance("src/Res/header print.png");
            image1.setAbsolutePosition(2f, 700f);
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.add(title);
            
            Paragraph paragraph1 = new Paragraph();
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            paragraph1.add(date);
            
            document.add(image1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            PdfPTable table = new PdfPTable(cols+3);
            table.addCell("Alternatif");
            table.addCell("Nama");
            for(int i=0; i<cols; i++){
                table.addCell((String)listCriteria.get(i));
            }
            table.addCell("Hasil");
            
            for(int i=0; i<listPelamarId.size(); i++){
                table.addCell((String)listPelamarId.get(i));
                table.addCell((String)listPelamarNama.get(i));
                for(int j=0; j<cols; j++){
                    table.addCell(""+data[i][j]);
                }
                table.addCell(""+listResult.get(i));
            }
            document.add(table);
            document.close();
        }catch (Exception e) {
        }
    }
    
    public void print(String title, String docName, LinkedList listCriteria, LinkedList<ResultData> listResult) throws FileNotFoundException, DocumentException, BadElementException{
        document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream("laporan/"+docName+".pdf"));
        cols = listCriteria.size();
        String date = "Tanggal : "+new SimpleDateFormat("dd/MM/yyyy").format(Calendar.getInstance().getTime());
        
        try{
            document.open();
            Image image1 = Image.getInstance("src/Res/header print.png");
            image1.setAbsolutePosition(2f, 700f);
            Paragraph paragraph = new Paragraph();
            paragraph.setAlignment(Element.ALIGN_CENTER);
            paragraph.add(title);
            
            Paragraph paragraph1 = new Paragraph();
            paragraph1.setAlignment(Element.ALIGN_LEFT);
            paragraph1.add(date);
            
            document.add(image1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            document.add(paragraph1);
            document.add(new Paragraph(" "));
            document.add(new Paragraph(" "));
            
            PdfPTable table = new PdfPTable(cols+3);
            table.addCell("Alternatif");
            table.addCell("Nama");
            for(int i=0; i<cols; i++){
                table.addCell((String)listCriteria.get(i));
            }
            table.addCell("Hasil");
            
            for(ResultData i:listResult){
                table.addCell(""+i.getAlternatif());
                table.addCell(""+i.getNamaAlternatif());
                for(Double j:i.getListValue()){
                    table.addCell(""+j);
                }
                table.addCell(""+i.getResult());
            }
            
            document.add(table);
            document.close();
            
        }catch (Exception e) {
        }
    }
    
    public void removeDir(String path){
        File dir = new File(path);
        for (File i : dir.listFiles()) {
            i.delete();
        }
    }
}
