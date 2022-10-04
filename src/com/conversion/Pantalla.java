package com.conversion;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.awt.event.ActionEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.SwingConstants;

public class Pantalla extends JFrame {

	private JPanel contentPane;
	private JTextField textField_in;
	private JTextField textField_out;
	private Object[] opcionConv;
	private String opcionSelec = "Peso Dominicano a Dólar Estadounidense";
		
	private Object[] opcionMoneda = {"Peso Dominicano a Dólar Estadounidense",
			"Peso Dominicano a Euro","Peso Dominicano a Libra Esterlina",
			"Peso Dominicano a Yen","Peso Dominicano a Rupia India",
			"Dólar Estadounidense a Peso Dominicano","Euro a Peso Dominicano",
			"Libra Esterlina a Peso Dominicano",
			"Yen a Peso Dominicano","Rupia India a Peso Dominicano"};
	
	private Object[] opcionTemp = {"Celsius a Fahrenheit","Celsius a Kelvin",
			"Fahrenheit a Celsius","Fahrenheit a Kelvin",
			"Kelvin a Celsius","Kelvin a Fahrenheit"};

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pantalla frame = new Pantalla();
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
	public Pantalla() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 336, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JLabel lblTitulo = new JLabel("Conversión de Moneda");
		lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitulo.setFont(new Font("Dialog", Font.BOLD, 15));
		lblTitulo.setBounds(53, 32, 216, 16);
		contentPane.add(lblTitulo);
		
		JLabel lblConversion = new JLabel("Peso Dominicano a Dólar Estadounidense");
		lblConversion.setHorizontalAlignment(SwingConstants.CENTER);
		lblConversion.setBounds(36, 95, 255, 28);
		contentPane.add(lblConversion);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBounds(6, 6, 84, 22);
		JMenu menu = new JMenu("Calculadora");
		menu.setBorderPainted(false);
		menu.setBounds(0, 0, 124, 28);
		
		JMenuItem menuMoneda = new JMenuItem("Moneda");
		menuMoneda.setSelected(true);
		
		JMenuItem menuTemp = new JMenuItem("Temperatura");		
		menu.add(menuMoneda);
		menu.add(menuTemp);
		menuBar.add(menu);
		contentPane.add(menuBar);
		
		opcionConv = opcionMoneda;
		
		menuMoneda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblTitulo.setText("Conversión de Moneda");
		
				opcionConv = opcionMoneda;
				lblConversion.setText("Peso Dominicano a Dólar Estadounidense");
				opcionSelec = "Peso Dominicano a Dólar Estadounidense";
				
				textField_in.setText("0");
				calcular();
			}
	});
		
		menuTemp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				lblTitulo.setText("Conversión de Temperatura");
				
				opcionConv = opcionTemp;
				lblConversion.setText("Celsius a Fahrenheit");
				opcionSelec = "Celsius a Fahrenheit";
				
				textField_in.setText("0");
				calcular();
			}
	});
			
		textField_in = new JTextField();
		textField_in.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_in.setText("0");
		textField_in.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_in.setBounds(53, 60, 216, 37);
		contentPane.add(textField_in);
		textField_in.setColumns(10);
		textField_in.setCaretColor(Color.WHITE);
		
		textField_out = new JTextField();
		textField_out.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_out.setText("0");
		textField_out.setFont(new Font("Dialog", Font.PLAIN, 18));
		textField_out.setEditable(false);
		textField_out.setBounds(53, 123, 216, 37);
		contentPane.add(textField_out);
		textField_out.setColumns(10);
		textField_out.setCaretColor(Color.WHITE);
		
		JButton btn_siete = new JButton("7");
		btn_siete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teclado(btn_siete.getText());
			}
		});
		btn_siete.setForeground(Color.WHITE);
		btn_siete.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_siete.setBackground(Color.BLACK);
		btn_siete.setBounds(53, 217, 70, 42);
		contentPane.add(btn_siete);
		
		JButton btn_ocho = new JButton("8");
		btn_ocho.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_ocho.getText());
			}
		});
		btn_ocho.setForeground(Color.WHITE);
		btn_ocho.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_ocho.setBackground(Color.BLACK);
		btn_ocho.setBounds(126, 217, 70, 42);
		contentPane.add(btn_ocho);
		
		JButton btn_nueve = new JButton("9");
		btn_nueve.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_nueve.getText());
			}
		});
		btn_nueve.setForeground(Color.WHITE);
		btn_nueve.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_nueve.setBackground(Color.BLACK);
		btn_nueve.setBounds(199, 217, 70, 42);
		contentPane.add(btn_nueve);
		
		JButton btn_borrar = new JButton("<X");
		btn_borrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_borrar.getText());
			}
		});
		btn_borrar.setForeground(Color.WHITE);
		btn_borrar.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_borrar.setBackground(Color.BLACK);
		btn_borrar.setBounds(199, 171, 70, 42);
		contentPane.add(btn_borrar);
		
		JButton btn_ce = new JButton("CE");
		btn_ce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_ce.getText());
			}
		});
		btn_ce.setForeground(Color.WHITE);
		btn_ce.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_ce.setBackground(Color.BLACK);
		btn_ce.setBounds(126, 171, 70, 42);
		contentPane.add(btn_ce);
		
		JButton btn_cuatro = new JButton("4");
		btn_cuatro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_cuatro.getText());
			}
		});
		btn_cuatro.setForeground(Color.WHITE);
		btn_cuatro.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_cuatro.setBackground(Color.BLACK);
		btn_cuatro.setBounds(53, 260, 70, 42);
		contentPane.add(btn_cuatro);
		
		JButton btn_cinco = new JButton("5");
		btn_cinco.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_cinco.getText());
			}
		});
		btn_cinco.setForeground(Color.WHITE);
		btn_cinco.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_cinco.setBackground(Color.BLACK);
		btn_cinco.setBounds(126, 260, 70, 42);
		contentPane.add(btn_cinco);
		
		JButton btn_seis = new JButton("6");
		btn_seis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_seis.getText());
			}
		});
		btn_seis.setForeground(Color.WHITE);
		btn_seis.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_seis.setBackground(Color.BLACK);
		btn_seis.setBounds(199, 260, 70, 42);
		contentPane.add(btn_seis);
		
		JButton btn_tres = new JButton("3");
		btn_tres.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_tres.getText());
			}
		});
		btn_tres.setForeground(Color.WHITE);
		btn_tres.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_tres.setBackground(Color.BLACK);
		btn_tres.setBounds(199, 303, 70, 42);
		contentPane.add(btn_tres);
		
		JButton btn_dos = new JButton("2");
		btn_dos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_dos.getText());
			}
		});
		btn_dos.setForeground(Color.WHITE);
		btn_dos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_dos.setBackground(Color.BLACK);
		btn_dos.setBounds(126, 303, 70, 42);
		contentPane.add(btn_dos);
		
		JButton btn_cero = new JButton("0");
		btn_cero.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_cero.getText());
			}
		});
		btn_cero.setForeground(Color.WHITE);
		btn_cero.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_cero.setBackground(Color.BLACK);
		btn_cero.setBounds(126, 346, 70, 42);
		contentPane.add(btn_cero);
		
		JButton btn_punto = new JButton(".");
		btn_punto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_punto.getText());
			}
		});
		btn_punto.setForeground(Color.WHITE);
		btn_punto.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_punto.setBackground(Color.BLACK);
		btn_punto.setBounds(199, 346, 70, 42);
		contentPane.add(btn_punto);
		
		JButton btn_mas_menos = new JButton("+/-");
		btn_mas_menos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_mas_menos.getText());
			}
		});
		btn_mas_menos.setForeground(Color.WHITE);
		btn_mas_menos.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_mas_menos.setBackground(Color.BLACK);
		btn_mas_menos.setBounds(53, 346, 70, 42);
		contentPane.add(btn_mas_menos);
		
		JButton btn_uno = new JButton("1");
		btn_uno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				teclado(btn_uno.getText());
			}
		});
		btn_uno.setForeground(Color.WHITE);
		btn_uno.setFont(new Font("Tahoma", Font.BOLD, 18));
		btn_uno.setBackground(Color.BLACK);
		btn_uno.setBounds(53, 303, 70, 42);
		contentPane.add(btn_uno);
		
		JButton btn_config = new JButton("</>");
		btn_config.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String opcionElegida;
			
				opcionElegida = (String)JOptionPane.showInputDialog(
	                    null,
	                    "Elige un método de conversión:\n",
	                    "Customized Dialog",
	                    JOptionPane.PLAIN_MESSAGE,
	                    null,
	                    opcionConv,
	                    opcionSelec);
				if (opcionElegida == null) 
				{
					opcionElegida = opcionSelec;
					return;
				}
				
				lblConversion.setText(opcionElegida);
				opcionSelec = opcionElegida;
				 calcular();
				}
		});
		btn_config.setForeground(Color.WHITE);
		btn_config.setFont(new Font("SansSerif", Font.PLAIN, 18));
		btn_config.setBackground(Color.BLACK);
		btn_config.setBounds(53, 171, 70, 42);
		contentPane.add(btn_config);
		
		textField_in.addFocusListener(new FocusAdapter() {

			public void focusLost(FocusEvent e) 
			{
					textField_in.requestFocusInWindow();
			}
		});
		
		//teclado físico
		textField_in.addKeyListener(new KeyAdapter()
		{
		   public void keyTyped(KeyEvent e)
		   {
			   char caracter = e.getKeyChar();
			   if (textField_in.getText().length()>18) { e.consume();}
		      
		      else if (!Character.isDigit(caracter) ) {
		            
		    	  if (caracter =='.') 
		    	  {
		    		  	if (!textField_in.getText().contains("."))
		    		  	{
						textField_in.setText(textField_in.getText() + ".");
					
		    		  	}
		    	  }
		    	  e.consume();
		    	  
		    	  //al presionar backspace no dejar campo vacío en el borrado
		    	  if(textField_in.getText().isEmpty()) 
		    	  	{
			    		textField_in.setText("0");
			    	}
		      	}
		      
				 //si es numero se evalua lo siguiente:
		      else  {
		    	  if (!textField_in.getText().equals("0")) 
		    	  {
		  			textField_in.setText(textField_in.getText()+String.valueOf(caracter));				
		  		  }
		  		
		  		  else {textField_in.setText(String.valueOf(caracter));}	
		    		}
		      
		      e.consume();
		      calcular();
		   }
		   
		});
	}
	
 public void teclado(String tecla) {
	 
	 if (tecla=="<X") 
	 	{
		 if (textField_in.getText().length()>0 & !textField_in.getText().equals("0")) 
		 {
			 textField_in.setText(textField_in.getText().substring(0, textField_in.getText ().length() - 1));
	     }
		 if(textField_in.getText().isEmpty()) 
		 {
			 textField_in.setText("0");
	     }
		 }
	else if(tecla=="CE") 
		{
		textField_in.setText("0");
		}
	 
	else if (textField_in.getText().length()>18) 
		{
		return;
		}
	 
	else if (tecla ==".") {
		if (!textField_in.getText().contains("."))
		{
			textField_in.setText(textField_in.getText() + ".");
		}
		}	
	else if (tecla =="+/-"){
		if (textField_in.getText().substring(0,1).equals("-")) 
		{
			textField_in.setText(textField_in.getText().substring(1, textField_in.getText ().length()));
		}
		else if (!textField_in.getText().contentEquals("0"))
		{
			textField_in.setText("-" + textField_in.getText().substring(0, textField_in.getText ().length()));
		}
		}
	 
	 //si es numero se evalua lo siguiente:
	
	else  {
		if (!textField_in.getText().equals("0")) 
		{
			textField_in.setText(textField_in.getText()+tecla);				
		}
		
		else 
		{
			textField_in.setText(tecla);	
		}
		} 
    calcular();
 }
 
 public void calcular() {
	 
	     //Realizar cálculo:
		if (opcionConv.equals(opcionTemp))
			textField_out.setText(Temperatura.convertirTemp(textField_in.getText(),opcionSelec));
		else
			
				textField_out.setText(Moneda.conversionMoneda(textField_in.getText(),opcionSelec));
	
	
 		}
}
