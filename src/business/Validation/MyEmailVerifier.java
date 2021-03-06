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
public class MyEmailVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent input) {
        String text = ((JTextField) input).getText();
        String pattern = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";

        if (text.length() == 0) {
            input.setBackground(Color.yellow);
            JOptionPane.showMessageDialog(input, "You cannot leave the box empty", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        } else if (text.length() > 0) {
            if (text.toLowerCase().startsWith(" ") || text.isEmpty() || text.length() == 0 || text.matches(pattern) != true) {
                input.setBackground(Color.CYAN);
                JOptionPane.showMessageDialog(input, "Please enter valid email address", "Error", JOptionPane.ERROR_MESSAGE);
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
