package br.ufms.App;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.geom.RoundRectangle2D;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel painel;
	private JPanel acoes;
	private JPanel opcoes;
	private JPanel resultado;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App frame = new App();
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
	public App() {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 300);
		setBackground(Color.LIGHT_GRAY);
		setLocationRelativeTo(null);
		painel = new JPanel();
		setContentPane(painel);
		painel.setLayout(new BorderLayout(0, 0));
		acoes = new Exit();
		painel.add(acoes, BorderLayout.NORTH);
		opcoes = new Opcoes(this);
		painel.add(opcoes);
		
		resultado = new Resutados();
		resultado.setVisible(false);
		painel.add(resultado, BorderLayout.SOUTH);
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				setShape(new RoundRectangle2D.Float(0, 0, 0,
						0, 16.0f, 16.0f));

			}
		});
		setUndecorated(true);
	}

	public JPanel getResultado() {
		return resultado;
	}
	
	

}
