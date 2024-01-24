package br.com.menu.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;

public class InicialView extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InicialView frame = new InicialView();
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
	public InicialView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		setTitle("Sistema de Alunos");
		setBounds(100, 100, 670, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(133, 91, 130, 56);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Cadastrar/Pesquisar Aluno");
		lblNewLabel.setBounds(121, 65, 164, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Curso");
		lblNewLabel_1.setBounds(384, 70, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar notas");
		lblNewLabel_2.setBounds(143, 158, 130, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Boletim");
		lblNewLabel_3.setBounds(412, 158, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setBounds(371, 91, 130, 56);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("");
		btnNewButton_2.setBounds(133, 183, 130, 56);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.setBounds(371, 183, 130, 56);
		contentPane.add(btnNewButton_3);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 654, 22);
		contentPane.add(menuBar);
		
		JMenu menuajuda = new JMenu("Ajuda");
		menuBar.add(menuajuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		menuajuda.add(mntmSobre);
	}
}
