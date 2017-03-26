package Domain;

import javax.swing.table.DefaultTableModel;

/**
 * Bruges istedet for DefaultTableModel for at g�rer f�rste kolonne i et JTable umuligt at skrive i<br>
 * Brugbart for at sikrer at id'et p� diverse objekter ikke kan �ndres. Extender DefaultTableModel, s� ejer alle yderlige metoder herfra.
 * @author PeterRaasth�j
 *
 */
@SuppressWarnings("serial")
public class ClosedColumnTableModel extends DefaultTableModel {
	@Override
	public boolean isCellEditable(int row, int col) {
		boolean editable = (col != 0);
		return editable;
	}
}
