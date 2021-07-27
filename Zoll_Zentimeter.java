import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.Action;

public class Zoll_Zentimeter extends JFrame {

	private JPanel contentPane;
	private JTextField jTxtZoll;
	private JTextField jTxtZenti;
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Zoll_Zentimeter frame = new Zoll_Zentimeter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Zoll_Zentimeter() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 319, 146);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton jBtnUmrechnen = new JButton("Umrechnen");
		jBtnUmrechnen.setAction(action);
		jBtnUmrechnen.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				double tz, tze;
				tz = Double.parseDouble(jTxtZoll.getText());
				tze = tz * 2.54;
				DecimalFormat f = new DecimalFormat("#0.00");
				jTxtZenti.setText(f.format(tze));
				jTxtZenti.requestFocus();
				jTxtZenti.selectAll();
			}});
		
		jBtnUmrechnen.setBounds(10, 76, 89, 23);
		contentPane.add(jBtnUmrechnen);
		
		
		JButton jBtnEnde = new JButton("Ende");
		jBtnEnde.setBounds(204, 76, 89, 23);
		contentPane.add(jBtnEnde);
		jBtnEnde.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}});
		
		
		jTxtZoll = new JTextField();
		jTxtZoll.setBounds(10, 29, 86, 20);
		contentPane.add(jTxtZoll);
		jTxtZoll.setColumns(10);
				
		
		jTxtZenti = new JTextField();
		jTxtZenti.setEditable(false);
		jTxtZenti.setBounds(204, 29, 86, 20);
		contentPane.add(jTxtZenti);
		jTxtZenti.setColumns(10);
		
		JLabel jLblZoll = new JLabel("Zoll");
		jLblZoll.setBounds(10, 11, 46, 14);
		contentPane.add(jLblZoll);
		
		JLabel jLblZentimeter = new JLabel("Zentimeter");
		jLblZentimeter.setBounds(204, 11, 57, 14);
		contentPane.add(jLblZentimeter);
	}
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Umrechnen");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
