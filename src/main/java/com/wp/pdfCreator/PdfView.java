package com.wp.pdfCreator;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;

import java.time.LocalDate;

public class PdfView {
    protected void buildPdf() throws Exception {
        Document document = new Document();
        document.add(new Paragraph("Generated Users " + LocalDate.now()));
//
//        PdfPTable table = new PdfPTable(users.stream().findAny().get().getColumnCount());
//        table.setWidthPercentage(100.0f);
//        table.setSpacingBefore(10);
//
//        // define font for table header row
//        Font font = FontFactory.getFont(FontFactory.TIMES);
//        font.setColor(BaseColor.WHITE);
//
//        // define table header cell
//        PdfPCell cell = new PdfPCell();
//        cell.setBackgroundColor(BaseColor.DARK_GRAY);
//        cell.setPadding(5);
//
//        // write table header
//        cell.setPhrase(new Phrase("Name", font));
//        table.addCell(cell);
//
//        for(User user : users){
//            table.addCell(user.getName());
//
//        }
//
//        document.add(table);
    }
}
