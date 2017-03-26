package GUI;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.regex.PatternSyntaxException;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import Domain.Barbog;
import Domain.ClosedCellTableModel;
import Domain.Control;

/**
 * GUI objektet der styrer barbogen. Indeholder alle elementer for denne gui. Implementerer ActionListener, KeyListener og extender MainGUI.
 * @author DanR
 *
 */
public class BarBogGUI extends MainGUI implements ActionListener, KeyListener {
	private JTable table;
	
	//klik-knapper instantieres
	private JButton btnKoldsk�l = new JButton("Koldsk�l");
	private JButton btnKakaom�lk = new JButton("Kakaom�lk");
	private JButton btnIste = new JButton("Iste");
	private JButton btnJuice = new JButton("Juice");
	private JButton btnSaftevand = new JButton("Saftevand");
	private JButton btnSodavand = new JButton("Sodavand");
	private JButton btnYougurt = new JButton("Yogurt");
	private JButton btnParisertoast = new JButton("Parisertoast");
	private JButton btnPariserkalkun = new JButton("Pariser/kalkun");
	private JButton btnSm�rtoast= new JButton("Sm�rtoast");
	private JButton btnPastasalat = new JButton("Pastasalat");
	private JButton btnKrasser = new JButton("Krasser");
	private JButton btnFrugt = new JButton("Frugt");
	private JButton btnRiskiks = new JButton("Riskiks");
	private JButton btnIs = new JButton("Is");
	
	private JButton btnK�b = new JButton("K�b");
	private JButton btnAnnuler= new JButton("Annuler");
	private JButton btn_search;

	//tekst-fields instantieres
	private JTextField searchField = new JTextField();
	private JTextField beloebField = new JTextField();
	private JTextField idField = new JTextField();
	private JTextField navnField = new JTextField();
	private JTextField saldoField = new JTextField();
	private JTextField barbogField = new JTextField();
	private JTextField vigtigField = new JTextField();

	//labels instantieres
	private JLabel idLabel = new JLabel("ID");
	private JLabel navnLabel = new JLabel("Navn");
	private JLabel barbogLabel = new JLabel("Saldo");
	private JLabel vigtigLabel = new JLabel("Vigtignote");
	private JLabel k�bssum = new JLabel("K�bssum");

	private ClosedCellTableModel model = new ClosedCellTableModel();
	private TableRowSorter<TableModel> rowSorter;
	private int selectedRow;
	private int koeb = 0;
	private boolean isListenerActive = true;

	/**
	 * S�tter alle elementer op p� framen som vises.
	 * @Author DanRydeng 
	 */
	public BarBogGUI() {
		JPanel center3 = new JPanel();
		center3.setLayout(null);

		// Knappernes position/layout ops�ttes.
		btnKoldsk�l.setBounds(50, 100, 90, 60);
		btnKoldsk�l.addActionListener(this);

		btnKakaom�lk.setBounds(50, 200, 90, 60);
		btnKakaom�lk.addActionListener(this);

		btnIste.setBounds(150,100,90,60);
		btnIste.addActionListener(this);

		btn_search = new JButton("S�G");
		btn_search.setBounds(580, 20, 60, 30);

		btnJuice.setBounds(150,200,90,60);
		btnJuice.addActionListener(this);

		btnSaftevand.setBounds(250,100,90,60);
		btnSaftevand.addActionListener(this);

		btnSodavand.setBounds(250,200,90,60);
		btnSodavand.addActionListener(this);

		btnYougurt.setBounds(350,100,90,60);
		btnYougurt.addActionListener(this);

		btnParisertoast.setBounds(50,350,90,60);
		btnParisertoast.addActionListener(this);

		btnPariserkalkun.setBounds(150,350,90,60);
		btnPariserkalkun.addActionListener(this);

		btnSm�rtoast.setBounds(250,350,90,60);
		btnSm�rtoast.addActionListener(this);

		btnPastasalat.setBounds(350,350,90,60);
		btnPastasalat.addActionListener(this);

		btnKrasser.setBounds(50,450,90,60);
		btnKrasser.addActionListener(this);

		btnFrugt.setBounds(150,450,90,60);
		btnFrugt.addActionListener(this);

		btnRiskiks.setBounds(250,450,90,60);
		btnRiskiks.addActionListener(this);

		btnIs.setBounds(350,200,90,60);
		btnIs.addActionListener(this);

		btnK�b.setBounds(640, 515, 100, 50);
		btnK�b.addActionListener(this);
		btnK�b.setBackground(Color.GREEN);

		btnAnnuler.setBounds(750,515, 100,50);
		btnAnnuler.addActionListener(this);
		btnAnnuler.setBackground(Color.red);
		
		btn_search = new JButton("S�G");btn_search.setBounds(580, 20, 60, 30);
		btn_search.setCursor(new Cursor(Cursor.HAND_CURSOR));
		btn_search.addActionListener(this);

		// Redigerbare JTextFields ops�ttes
		searchField.setBounds(640, 20, 190, 30);
		searchField.addKeyListener(this);

		// Ikke redigerbare JTextFields ops�ttes
		idField.setBounds(50, 20, 25, 20);
		idField.setEditable(false);
		idField.setText("N/A");

		navnField.setBounds(85, 20, 80, 20);
		navnField.setEditable(false);
		navnField.setText("N/A");
		
		beloebField.setBounds(580, 530, 50, 20);
		beloebField.setEditable(false);
		beloebField.setText(String.valueOf(koeb));	

		barbogField.setBounds(170, 20, 50, 20);
		barbogField.setEditable(false);
		barbogField.setText("N/A");

		vigtigField.setBounds(50,60,500,20);
		vigtigField.setEditable(false);
		vigtigField.setText("Ingen info");

		// Labels ops�ttes
		idLabel.setBounds(50, 00, 20, 20);
		navnLabel.setBounds(110, 00, 50, 20);
		barbogLabel.setBounds(170, 00, 50, 20);
		vigtigLabel.setBounds(50,40,100,20);
		k�bssum.setBounds(580,500,100,20);

		// Inds�tter content til framen, til framen.
		center3.add(barbogLabel);
		center3.add(idLabel);
		center3.add(navnLabel);
		center3.add(vigtigLabel);
		center3.add(vigtigField);
		center3.add(barbogField);
		center3.add(navnField);
		center3.add(idField);
		center3.add(k�bssum);
		center3.add(beloebField);

		
		// Mad Knapper
		center3.add(btnKoldsk�l);
		center3.add(btnKakaom�lk);
		center3.add(btnIste);
		center3.add(btnJuice);
		center3.add(btnSaftevand);
		center3.add(btnSodavand);
		center3.add(btnYougurt);
		center3.add(btnParisertoast);
		center3.add(btnIs);
		center3.add(btnPariserkalkun);
		center3.add(btnSm�rtoast);
		center3.add(btnPastasalat);
		center3.add(btnKrasser);
		center3.add(btnFrugt);
		center3.add(btnRiskiks);
		center3.add(btnK�b);
		center3.add(btnAnnuler);
		center3.add(searchField);
		
		//S�gefelt
		center3.add(btn_search);

		// Jtable ops�ttes p� ScrollpPane
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(580, 50, 250, 350);
		table = new JTable();
		scrollPane.setViewportView(table);
		table.setRowHeight(20);
		table.setFillsViewportHeight(true);
		table.setModel(model);
		center3.add(scrollPane);
		rowSorter = new TableRowSorter<>((table.getModel()));
		table.setRowSorter(rowSorter);

		// tilf�jer alt content som er tilf�jet til panelet center3 til gui, samt 
		Panel_Content.add(center3);
		center3.setBackground(Color.WHITE);
		btn_saldo.setBackground(Color.GRAY);

		/*
		 * En List Selection Listener. Checker p� mouseinput, om selectedRow er
		 * selected.. Hvis en row bliver selected udf�rer den var.setText(var)
		 * p� felterne.
		 * 
		 * Bruges for at overf�rer data fra JTables til ikke redigerbare Fields 
		 */
		table.getSelectionModel().addListSelectionListener(

				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						if (isListenerActive) {
							try{
								int selectedRow;
								selectedRow = table.getSelectedRow();
								String id = String.valueOf((int) model.getValueAt(selectedRow, 0));
								String navn = (String) model.getValueAt(selectedRow, 1);
								String saldo = String.valueOf((int) model.getValueAt(selectedRow, 2));
								String vigtigNote = (String) model.getValueAt(selectedRow, 3);

								idField.setText(id);
								navnField.setText(navn);
								saldoField.setText(saldo);
								barbogField.setText(saldo);
								vigtigField.setText(vigtigNote);

							}catch(ArrayIndexOutOfBoundsException e1){

							}
						}
					}

				});
		updateJTable();
	}
	
	/**
	 * Opdaterer JTablet med ArrayListe af Barb�ger hentet fra, og opsat i databasen.
	 */
	public void updateJTable() {
		ArrayList<Barbog> barbogs = new Control().hentBarbog();

		model.setColumnIdentifiers(new String[] { "ID", "Navn", "Saldo","Vigtig Note" });
		for (int i = 0; i < model.getColumnCount(); i++){
			rowSorter.setSortable(i, false);}
		for (Barbog barbog : barbogs) {
			model.addRow(new Object[] { barbog.getId(), barbog.getNavn(),barbog.getSaldo(), barbog.getVigtig() });
		}
		barbogs.clear();
	}


	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if(e.getSource()==searchField){
			if(e.getKeyCode() == KeyEvent.VK_ENTER){
				String text = searchField.getText().toLowerCase();
				if (text.length() == 0) {
					rowSorter.setRowFilter(null);
				} else {
					/*
					 * kodestykket herunder er fundet fra siden
					 * https://community.oracle.com/thread/1354225
					 * fra bruger 843806 - regexFilter s�rger for at 
					 * der ikke tages h�jde for store/sm� bostaver n�r der s�ges.
					 */
					try{
						rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" +text));
					}catch(PatternSyntaxException e1){
					}
				}
			}
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// bruges ikke
	}


	public void actionPerformed(ActionEvent e) {

		if(e.getSource() == btn_search){
			String text = searchField.getText().toLowerCase();
			if (text.length() == 0) {
				rowSorter.setRowFilter(null);
			} else {
				rowSorter.setRowFilter(RowFilter.regexFilter("(?i)" + text));;
			}
		}
		
		if (e.getSource() == btnK�b){
			
			int saldo = 0;
			int id = 0;
			selectedRow = table.getSelectedRow();
			
			try {
				saldo = Integer.parseInt(saldoField.getText());
				id = (int) (model.getValueAt(selectedRow, 0));
				koeb = Integer.parseInt(beloebField.getText());

			
			} catch (NumberFormatException | ArrayIndexOutOfBoundsException e1) {
				JOptionPane.showMessageDialog(frame, "Intet medlem er valgt.");
			}
			if(selectedRow > -1){
			isListenerActive = false;
			model.setRowCount(0);
			new Control().traekBeloeb(saldo, koeb, id);
			updateJTable();
			model.fireTableDataChanged();
			isListenerActive = true;
			table.addRowSelectionInterval(selectedRow, selectedRow);
			JOptionPane.showMessageDialog(frame, "K�bet for " + koeb + " DDK er udf�rt");
			koeb = 0;
			beloebField.setText(String.valueOf(koeb));
			}
		}
		
		//nulstiller blot koeb og opdaterer koebsfield.
		if (e.getSource() == btnAnnuler){
			koeb = 0;
			beloebField.setText(String.valueOf(koeb));

		}	
		
		//funktionen til knapperne. varer-navnet i databasen skal matche String vare, for at det fungerer.
		if (e.getSource() == btnKoldsk�l){
			int pris = 0;
			String vare = "koldsk�l";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnIste){
			int pris = 0;
			String vare = "iste";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnKakaom�lk){
			int pris = 0;
			String vare = "kakaom�lk";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnJuice){
			int pris = 0;
			String vare = "juice";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnSaftevand){
			int pris = 0;
			String vare = "saftevand";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnSodavand){
			int pris = 0;
			String vare = "sodavand";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnParisertoast){
			int pris = 0;
			String vare = "parisertoast";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnYougurt){
			int pris = 0;
			String vare = "yogurt";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnPariserkalkun){
			int pris = 0;
			String vare = "pariserkalkun";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnIs){
			int pris = 0;
			String vare = "is";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnSm�rtoast){
			int pris = 0;
			String vare = "sm�rtoast";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnPastasalat){
			int pris = 0;
			String vare = "pastasalat";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnKrasser){
			int pris = 0;
			String vare = "krasser";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnFrugt){
			int pris = 0;
			String vare = "frugt";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}
		if (e.getSource() == btnRiskiks){
			int pris = 0;
			String vare = "riskiks";
			pris = new Control().hentVarePris(vare);
			selectedRow = table.getSelectedRow();
			koeb = koeb + pris;
			beloebField.setText(String.valueOf(koeb));	
		}

		//action for knapperne i top-pane.
		if (e.getSource() == btn_aktivitet) {

			new AktivitetGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_medlem )
		{
			new MedlemGUI();
			frame.dispose();
		}

		if(e.getSource() == btn_tilmeld)
		{
			new TilmeldAktivitetGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_saldo){
			new SaldoGUI();
			frame.dispose();
		}
		if(e.getSource() == btn_barbog )
		{
			new BarBogGUI();
			frame.dispose();
		}
	}
}




