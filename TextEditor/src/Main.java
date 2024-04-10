package TextEditor.src;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TextEditorModel model = new TextEditorModel();
            TextEditorView view = new TextEditorView();
            TextEditorController controller = new TextEditorController(view, model);
        });
    }
}
