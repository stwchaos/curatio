package modelo;

import java.util.ArrayList;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTextField;


public class AutoComboBox extends JComboBox<Object> {

ArrayList<String> keyWord = new ArrayList<>();
Vector myVector = new Vector();

public AutoComboBox() {

    setModel(new DefaultComboBoxModel(myVector));
    setSelectedIndex(-1);
    setEditable(true);
    JTextField text = (JTextField) this.getEditor().getEditorComponent();
    text.setFocusable(true);
    text.setText("");
    text.addKeyListener(new ComboListener(this, myVector));
    setMyVector();
}

/**
 * set the item list of the AutoComboBox
 * @param pacientes an String array
 */
public void setKeyWord(ArrayList<String> pacientes) {
    this.keyWord = pacientes;
    setMyVectorInitial();
}

private void setMyVector() {
    int a;
    for (a = 0; a < keyWord.size(); a++) {
        myVector.add(keyWord.get(a));
    }
}

private void setMyVectorInitial() {
    myVector.clear();
    int a;
    for (a = 0; a < keyWord.size(); a++) {

        myVector.add(keyWord.get(a));
    }
}

}