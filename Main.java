package uni.assign2;
import javax.swing.JOptionPane;
interface Doc {
    void generate();
}
class PDFFile implements Doc {
    @Override
    public void generate() {
        JOptionPane.showMessageDialog(null, "PDF document created.");
    }
}
class WordFile implements Doc {
    @Override
    public void generate() {
        JOptionPane.showMessageDialog(null, "Word document created.");
    }
}
interface DocFactory {
    Doc createDocument();
}
class PDFFactory implements DocFactory {
    @Override
    public Doc createDocument() {
        return new PDFFile();
    }
}
class WordFactory implements DocFactory {
    @Override
    public Doc createDocument() {
        return new WordFile();
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {
        String[] options = {"PDF", "Word"};
        String selectedDoc = (String) JOptionPane.showInputDialog(
                null,
                "Select document type:",
                "Document creation",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]
        );

        DocFactory factory;
        if (selectedDoc.equals("PDF")) {
            factory = new PDFFactory();
        } else if (selectedDoc.equals("Word")) {
            factory = new WordFactory();
        } else {
            JOptionPane.showMessageDialog(null, "errorr");
            return;
        }
        Doc document = factory.createDocument();
        document.generate();
    }
}

