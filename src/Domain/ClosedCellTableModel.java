package Domain;

import javax.swing.table.DefaultTableModel;

/**
 * Bruges for at g�re alle celler i et JTable uskrivelige. Extender DefaultTableModel, s� ejer alle yderlige metoder herfra.
 * @author PeterRaasth�j
 *
 */
@SuppressWarnings("serial")
public class ClosedCellTableModel extends DefaultTableModel {
	@Override
    public boolean isCellEditable(int row, int column) {
       return false;
    }
}
