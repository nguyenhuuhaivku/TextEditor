package TextEditor.src;

import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class TextEditorView extends JFrame {
    private JTextArea textArea;
    private JButton saveButton;
    private JButton loadButton;

    public TextEditorView() {
        setTitle("Text Editor");
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        textArea = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane);

        saveButton = new JButton("Save");
        loadButton = new JButton("Load");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(saveButton);
        buttonPanel.add(loadButton);
        add(buttonPanel, "South");

        setVisible(true);
    }

    public String getText() {
        return textArea.getText();
    }

    public void setText(String text) {
        textArea.setText(text);
    }

    public void addSaveButtonListener(ActionListener listener) {
        saveButton.addActionListener(listener);
    }

    public void addLoadButtonListener(ActionListener listener) {
        loadButton.addActionListener(listener);
    }
}
