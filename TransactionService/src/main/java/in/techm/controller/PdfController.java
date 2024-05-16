package in.techm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Element;
import com.lowagie.text.Image;
import com.lowagie.text.PageSize;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Rectangle;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.lowagie.text.Font;

import in.techm.pojo.TransactionDetails;
import in.techm.service.TransactionService;

@RestController
@CrossOrigin()
class PdfController {

    @Autowired
    private TransactionService transactionService; // Inject TransactionService

    @GetMapping(value = "/transactions/pdf", produces = MediaType.APPLICATION_PDF_VALUE)
    public ResponseEntity<byte[]> downloadTransactionHistoryAsPdf() throws IOException {
        List<TransactionDetails> transactions = transactionService.getTransactions();
        ByteArrayInputStream bis = generatePdf(transactions);
        byte[] pdfBytes = toByteArray(bis);
        return ResponseEntity.ok()
                .header("Content-Disposition", "attachment; filename=transaction_history.pdf")
                .body(pdfBytes);
    }

    private ByteArrayInputStream generatePdf(List<TransactionDetails> transactions) throws IOException {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        Document document = new Document(PageSize.A4, 30, 30, 50, 50); // Adjust margins here
        try {
            PdfWriter.getInstance(document, out);
            document.open();
            
            // Add image at the header in the center
            Image headerImage = Image.getInstance(getClass().getClassLoader().getResource("images/image.png"));
            Image image = Image.getInstance(headerImage);
            image.setAlignment(Element.ALIGN_CENTER);
            document.add(image);
            
            // Add Transaction Details heading in bold with padding from bottom
            Font boldFont = new Font(Font.HELVETICA, 12, Font.BOLD); // Define bold font
            Paragraph heading = new Paragraph("Transaction Details", boldFont); // Apply bold font to heading
            heading.setAlignment(Element.ALIGN_CENTER);
            heading.setSpacingAfter(10f); // Add padding from bottom
            document.add(heading);
            
            // Create table with desired column sequence
            PdfPTable table = new PdfPTable(6); // 6 columns

            // Set custom widths for each column
            float[] columnWidths = {1f, 3f, 3f, 1.5f, 2.4f, 3f}; // Adjust the widths as needed
            table.setWidths(columnWidths);
            
            // Add table headers
            table.addCell("ID");
            table.addCell("From Account Number");
            table.addCell("To Account Number");
            table.addCell("Amount");
            table.addCell("Transaction Type");
            table.addCell("Transaction Date Time");
            
            // Add data to table
            for (TransactionDetails transaction : transactions) {
                table.addCell(String.valueOf(transaction.getId()));
                table.addCell(transaction.getFromAccountNumber());
                table.addCell(transaction.getToAccountNumber());
                table.addCell(String.valueOf(transaction.getAmount()));
                table.addCell(transaction.getTransactionType());
                table.addCell(transaction.getTransactionDateTime());
            }
            
            // Add table to document
            document.add(table);
            
            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }
        return new ByteArrayInputStream(out.toByteArray());
    }

    private byte[] toByteArray(ByteArrayInputStream bis) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int length;
        while ((length = bis.read(buffer)) != -1) {
            bos.write(buffer, 0, length);
        }
        bos.flush();
        bos.close();
        bis.close();
        return bos.toByteArray();
    }
}
