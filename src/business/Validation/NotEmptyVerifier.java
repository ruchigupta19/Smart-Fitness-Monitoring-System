package business.Validation;

import java.awt.Color;
import javax.swing.InputVerifier;
import javax.swing.JComponent;
import javax.swing.JTextField;
import javax.swing.JOptionPane;

/**
 *
 * @author ruchi
 */
public class NotEmptyVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        if (text.length() == 0) {
            if (text.isEmpty()) {
                input.setBackground(Color.yellow);
                JOptionPane.showMessageDialog(input, "You cannot leave the box empty", "Error", JOptionPane.ERROR_MESSAGE);
                return false;
            } else {
                input.setBackground(Color.white);
                return true;
            }
        } else {
            input.setBackground(Color.white);
            return true;
        }
    }
}
