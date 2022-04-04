package gui.magazzino2;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import gui.magazzino2.classes.Articolo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PDFCreator<T> {
    public void createPDF(List<T> list, String imagepath) throws IOException, DocumentException, URISyntaxException {
        Document document = new Document();

        PdfWriter.getInstance(document, new FileOutputStream("src/gui/magazzino2/ordine.pdf"));

        document.open();

        if (imagepath != null) {

            Path path = Paths.get(ClassLoader.getSystemResource(imagepath).toURI());

            System.out.println("HI" + path.toAbsolutePath());
            Image img = Image.getInstance(path.toAbsolutePath().toString());
            document.add(img);
        }

        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);

        for (T item : list) {
            Paragraph chunk = new Paragraph(item.toString(), font);

            document.add(chunk);
        }

        document.close();
    }

    public static void main(String[] args) throws DocumentException, IOException, URISyntaxException {
        List<Articolo> articolos = new ArrayList<>();
        articolos.add(new Articolo("ciao", 12, 12));
        articolos.add(new Articolo("caao", 12, 12));
        articolos.add(new Articolo("cidaao", 12, 12));
        articolos.add(new Articolo("cdasiao", 12, 12));

        new PDFCreator<Articolo>().createPDF(articolos, "/Users/alessandro/IdeaProjects/informatica/src/gui/magazzino2/logo.png");
    }
}
