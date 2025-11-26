package helpers;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.draw.VerticalPositionMark;
import dao.AccountDAO;
import dao.ImportDetailDAO;
import dao.ExportDetailDAO;
import dao.ComputerDAO;
import dao.SupplierDAO;
import dao.ImportDAO;
import dao.ExportDAO;
import java.awt.Desktop;
import java.awt.FileDialog;
import java.awt.Point;
import java.awt.Rectangle;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import entity.ReceiptDetail;
import entity.Computer;
import entity.ImportReceipt;
import entity.ExportReceipt;

public class WritePDF {

    DecimalFormat formatter = new DecimalFormat("###,###,###");
    SimpleDateFormat formatDate = new SimpleDateFormat("dd/MM/yyyy HH:mm");
    Document document = new Document();
    FileOutputStream file;
    JFrame jf = new JFrame();
    FileDialog fd = new FileDialog(jf, "Export pdf", FileDialog.SAVE);
    Font fontData;
    Font fontTitle;
    Font fontHeader;

    public WritePDF() {
        try {
            fontData = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
            fontTitle = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 25, Font.NORMAL);
            fontHeader = new Font(BaseFont.createFont("lib/Roboto/Roboto-Regular.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED), 11, Font.NORMAL);
        } catch (DocumentException | FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException ex) {
            Logger.getLogger(WritePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void chooseURL(String url) {
        try {
            document.close();
            document = new Document();
            file = new FileOutputStream(url);
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();
        } catch (FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "File path not found " + url);
        } catch (DocumentException ex) {
            JOptionPane.showMessageDialog(null, "Unable to create document !");
        }
    }

    public void setTitle(String title) {
        try {
            Paragraph pdfTitle = new Paragraph(new Phrase(title, fontTitle));
            pdfTitle.setAlignment(Element.ALIGN_CENTER);
            document.add(pdfTitle);
            document.add(Chunk.NEWLINE);
        } catch (DocumentException ex) {
            ex.printStackTrace();
        }
    }

    private String getFile(String name) {
        fd.pack();
        fd.setSize(800, 600);
        fd.validate();
        Rectangle rect = jf.getContentPane().getBounds();
        double width = fd.getBounds().getWidth();
        double height = fd.getBounds().getHeight();
        double x = rect.getCenterX() - (width / 2);
        double y = rect.getCenterY() - (height / 2);
        Point leftCorner = new Point();
        leftCorner.setLocation(x, y);
        fd.setLocation(leftCorner);
        fd.setFile(name + ".pdf");
        fd.setVisible(true);
        String url = fd.getDirectory() + fd.getFile();
        if (url.equals("null")) {
            return null;
        }
        return url;
    }

    public void writeReceipt(String mapn) {
        String url = "";
        try {
            fd.setTitle("Print Receipt");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("RECEIPT INFORMATION");

            ImportReceipt pn = ImportDAO.getInstance().selectById(mapn);

            Chunk glue = new Chunk(new VerticalPositionMark());// Khoang trong giua hang
            Paragraph para1 = new Paragraph();
            para1.setFont(fontData);
            para1.add("Receipt ID: " + pn.getReceiptID());
            para1.add("\nCreated Date: " + formatDate.format(pn.getCreatedDate()));
            para1.setIndentationLeft(40);
            Paragraph para2 = new Paragraph();
            para2.setPaddingTop(30);
            para2.setFont(fontData);
            para2.add(String.valueOf("Created By: " + AccountDAO.getInstance().selectById(pn.getCreatedBy()).getFullName()));
            para2.add(String.valueOf("\nSupplier: " + SupplierDAO.getInstance().selectById(pn.getSupplier()).getSupplierName() + "  -  " + pn.getSupplier()));
            para2.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(Chunk.NEWLINE);

            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;

            pdfTable.addCell(new PdfPCell(new Phrase("Product ID", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Product Name", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Unit Price", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Quantity", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Total Amount", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            for (ReceiptDetail ctpn : ImportDetailDAO.getInstance().selectAll(mapn)) {
                Computer mt = ComputerDAO.getInstance().selectById(ctpn.getProductId());
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getProductId(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(mt.getProductName(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(mt.getImportPrice()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getQuantity()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getQuantity() * mt.getImportPrice()) + "đ", fontData)));
            }

            document.add(pdfTable);
            document.add(Chunk.NEWLINE);

            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Total Payment: " + formatter.format(pn.getTotalAmount()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "File saved successfully " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save file " + url);
        }
    }

    private void openFile(String file) {
        try {
            File path = new File(file);
            Desktop.getDesktop().open(path);
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void writeDelivery(String mapn) {
        String url = "";
        try {
            fd.setTitle("Print Delivery");
            fd.setLocationRelativeTo(null);
            url = getFile(mapn);
            if (url == null) {
                return;
            }
            file = new FileOutputStream(url);
            document = new Document();
            PdfWriter writer = PdfWriter.getInstance(document, file);
            document.open();

            setTitle("DELIVERY INFORMATION");

            ExportReceipt pn = ExportDAO.getInstance().selectById(mapn);

            Paragraph para1 = new Paragraph(new Phrase("Receipt ID: " + mapn, fontData));
            Paragraph para2 = new Paragraph(new Phrase("Created Date: " + formatDate.format(pn.getCreatedDate()), fontData));
            Paragraph para3 = new Paragraph(new Phrase("Created By: " + AccountDAO.getInstance().selectById(pn.getCreatedBy()).getFullName(), fontData));
            para1.setIndentationLeft(40);
            para2.setIndentationLeft(40);
            para3.setIndentationLeft(40);
            document.add(para1);
            document.add(para2);
            document.add(para3);
            document.add(Chunk.NEWLINE);//add hang trong de tao khoang cach

            //Tao table cho cac chi tiet cua hoa don
            PdfPTable pdfTable = new PdfPTable(5);
            pdfTable.setWidths(new float[]{10f, 30f, 15f, 5f, 15f});
            PdfPCell cell;

            //Set headers cho table chi tiet
            pdfTable.addCell(new PdfPCell(new Phrase("Product ID", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Product Name", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Unit Price", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Quantity", fontHeader)));
            pdfTable.addCell(new PdfPCell(new Phrase("Total Amount", fontHeader)));

            for (int i = 0; i < 5; i++) {
                cell = new PdfPCell(new Phrase(""));
                pdfTable.addCell(cell);
            }

            //Truyen thong tin tung chi tiet vao table
            for (ReceiptDetail ctpn : ExportDetailDAO.getInstance().selectAll(mapn)) {
                Computer mt = ComputerDAO.getInstance().selectById(ctpn.getProductId());
                pdfTable.addCell(new PdfPCell(new Phrase(ctpn.getProductId(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(mt.getProductName(), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(mt.getExportPrice()) + "đ", fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(String.valueOf(ctpn.getQuantity()), fontData)));
                pdfTable.addCell(new PdfPCell(new Phrase(formatter.format(ctpn.getQuantity() * mt.getExportPrice()) + "đ", fontData)));
            }
            document.add(pdfTable);
            document.add(Chunk.NEWLINE);
            Paragraph paraTongThanhToan = new Paragraph(new Phrase("Total Payment: " + formatter.format(pn.getTotalAmount()) + "đ", fontData));
            paraTongThanhToan.setIndentationLeft(300);
            document.add(paraTongThanhToan);
            document.close();
            JOptionPane.showMessageDialog(null, "File saved successfully: " + url);
            openFile(url);

        } catch (DocumentException | FileNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "Failed to save file " + url);
        }

    }
}
