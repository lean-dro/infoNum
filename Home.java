package infoNum;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.Iterator;
import java.util.regex.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.lang.Math;

public class Home extends JFrame {

	private JPanel contentPane;
	private JTextField tfNumero;
	private JTextField tfFatorial;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Home frame = new Home();
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
	public Home() {
		setTitle("InfoNum");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(346,553);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Panel info = new Panel();
		info.setBackground(Color.GRAY);
		info.setBounds(124, 0, 216, 301);
		contentPane.add(info);
		info.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Fatorial:");
		lblNewLabel.setBounds(10, 15, 46, 14);
		info.add(lblNewLabel);
		
		JLabel lblParOuImpar = new JLabel("Par ou Impar?");
		lblParOuImpar.setBounds(10, 44, 82, 14);
		info.add(lblParOuImpar);
		
		JLabel lblPrimo = new JLabel("Primo?");
		lblPrimo.setBounds(10, 73, 46, 14);
		info.add(lblPrimo);
		
		JLabel lblNewLabel_2_1 = new JLabel("Divisores:");
		lblNewLabel_2_1.setBounds(10, 102, 66, 14);
		info.add(lblNewLabel_2_1);
		
		tfFatorial = new JTextField();
		tfFatorial.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tfFatorial.setEditable(false);
		tfFatorial.setHorizontalAlignment(SwingConstants.CENTER);
		tfFatorial.setBounds(62, 12, 134, 20);
		info.add(tfFatorial);
		tfFatorial.setColumns(10);
		
		JLabel lblImparPar = new JLabel("");
		lblImparPar.setBounds(96, 44, 66, 14);
		info.add(lblImparPar);
		
		JLabel lblPrimoR = new JLabel("");
		lblPrimoR.setBounds(59, 73, 46, 14);
		info.add(lblPrimoR);
		
		JLabel lblMult = new JLabel("");
		lblMult.setVerticalAlignment(SwingConstants.TOP);
		lblMult.setBounds(10, 117, 186, 174);
		info.add(lblMult);
		
		JPanel numero = new JPanel();
		numero.setBounds(0, 0, 124, 301);
		contentPane.add(numero);
		numero.setLayout(null);
		
		tfNumero = new JTextField();
		tfNumero.setHorizontalAlignment(SwingConstants.CENTER);
		tfNumero.setBounds(32, 84, 56, 20);
		numero.add(tfNumero);
		tfNumero.setColumns(10);
		
		JLabel lblNumero = new JLabel("Insira seu n\u00FAmero:");
		lblNumero.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumero.setBounds(0, 59, 125, 14);
		numero.add(lblNumero);
		
		JLabel lblAviso = new JLabel("Bom uso :)");
		lblAviso.setHorizontalAlignment(SwingConstants.CENTER);
		lblAviso.setBounds(0, 177, 125, 14);
		numero.add(lblAviso);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(0, 299, 340, 225);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tabuada");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(132, 0, 75, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblTabu = new JLabel("");
		lblTabu.setHorizontalAlignment(SwingConstants.CENTER);
		lblTabu.setForeground(Color.LIGHT_GRAY);
		lblTabu.setVerticalAlignment(SwingConstants.TOP);
		lblTabu.setBounds(53, 29, 249, 185);
		panel.add(lblTabu);
		
		JButton btnNewButton = new JButton("Gerar Infos");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((tfNumero.getText().toString()).equals("")) {
					lblAviso.setText("Erro");
				}else {
					Pattern letras = Pattern.compile("[a-zA-z]");
					Matcher procurarLetras = letras.matcher(tfNumero.getText().toString());
					boolean temLetrasDuvida = procurarLetras.find();
					if(temLetrasDuvida) {
						lblAviso.setText("Só números :)");
					}
					else {
						double numero = Double.parseDouble(tfNumero.getText().toString());
						//Fatorial
						double gaveta=numero, i=1;
						if (numero == 0) {
							tfFatorial.setText("1");
						}
						else {
							while(i<numero) {;
									gaveta = gaveta * i;
								i++;
							}
							tfFatorial.setText(Double.toString(gaveta));
						}
						
						//Par ou Impar
						if(numero%2==0) {
							lblImparPar.setText("Par");
						}
						else {
							lblImparPar.setText("Impar");
						}
						
						//Primo
						gaveta = 0;
						for (int j = 0; j <= numero; j++) {
							if(numero%j==0) {
								gaveta=gaveta+1;
							}
						}
						if(gaveta==2) {
							lblPrimoR.setText("Sim");
						}
						else {
							lblPrimoR.setText("Não");
						}
						//Multiplos
						double[] multiplos = new double [(int) gaveta];
						int q=0;
						for (int k = 0; k <= numero; k++) {
							//Guardando
							if(numero%k==0) {
								multiplos[q]=k;
								q++;
							}
						}
							//Mostrando
						String multiplosTexto="";
						int c;
						for(c = 0; c<(int)gaveta; c++) {
							multiplosTexto = multiplosTexto +Double.toString(multiplos[c])+"<br>";
						}
						lblMult.setText("<html>"+multiplosTexto+"</html>");
						
						//Tabuada
						double produto;
						String tabuada="";
						for(c=10; c>=0;c--) {
							produto = numero*c;
							tabuada = "<p>"+Double.toString(numero)+" X "+Integer.toString(c)+" = "+Double.toString(produto)+"</p>"+tabuada;
						}
						lblTabu.setText("<html>"+tabuada+"</html>");
					}	
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnNewButton.setBounds(8, 124, 105, 23);
		numero.add(btnNewButton);
		
		JButton btLimpar = new JButton("Limpar");
		btLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblImparPar.setText("");
				lblPrimoR.setText("");
				lblMult.setText("");
				tfFatorial.setText("");
				tfNumero.setText("");
				tfNumero.requestFocus();
			
			}
		});
		btLimpar.setFont(new Font("Tahoma", Font.BOLD, 8));
		btLimpar.setBounds(26, 202, 70, 20);
		numero.add(btLimpar);
		

		

	}
}
