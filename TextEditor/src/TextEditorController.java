package TextEditor.src;

import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class TextEditorController {
    private TextEditorView view;
    private TextEditorModel model;

    public TextEditorController(TextEditorView view, TextEditorModel model) {
        this.view = view;
        this.model = model;
        initView();
    }

    private void initView() {
        view.addSaveButtonListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            int result = fileChooser.showSaveDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try {
                    model.setText(view.getText());
                    model.saveToFile(file);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Error saving file!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        view.addLoadButtonListener(e -> {
            JFileChooser fileChooser = new JFileChooser();
            
            int result = fileChooser.showOpenDialog(view);
            if (result == JFileChooser.APPROVE_OPTION) {
                File directory = fileChooser.getSelectedFile();
                File file = new File(directory, "text.txt");
                try {
                    model.loadFromFile(file);
                    view.setText(model.getText());
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(view, "Error loading file!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
