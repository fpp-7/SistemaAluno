package br.com.menu.view;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;

public class CadastroAlunoView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textNome;
	private JTextField textEmail;
	private JTextField textCelular;
	private JTextField textCidade;
	private JTextField textCpf;
	private JTextField textEnd;
	
	public void cadAluView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroAlunoView frame = new CadastroAlunoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public CadastroAlunoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setType(Type.UTILITY);
		setTitle("Sistema de Alunos");
		setBounds(100, 100, 670, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNome = new JLabel("Nome");
		lblNome.setBounds(10, 20, 68, 14);
		lblNome.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblNome);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 50, 68, 14);
		lblEmail.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblEmail);
		
		JLabel lblTelefone = new JLabel("Celular");
		lblTelefone.setBounds(10, 80, 68, 14);
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblTelefone);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setBounds(10, 110, 68, 14);
		lblCidade.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblCidade);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 140, 68, 14);
		lblCpf.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblCpf);
		
		JLabel lblEndereo = new JLabel("Endereço");
		lblEndereo.setBounds(10, 170, 68, 14);
		lblEndereo.setFont(new Font("Arial", Font.PLAIN, 13));
		getContentPane().add(lblEndereo);
		
		textNome = new JTextField();
		textNome.setBounds(65, 17, 579, 20);
		contentPane.add(textNome);
		textNome.setColumns(10);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(65, 47, 579, 20);
		contentPane.add(textEmail);
		
		textCelular = new JTextField();
		textCelular.setColumns(10);
		textCelular.setBounds(65, 77, 579, 20);
		contentPane.add(textCelular);
		
		textCidade = new JTextField();
		textCidade.setColumns(10);
		textCidade.setBounds(65, 107, 579, 20);
		contentPane.add(textCidade);
		
		textCpf = new JTextField();
		textCpf.setColumns(10);
		textCpf.setBounds(65, 137, 579, 20);
		contentPane.add(textCpf);
		
		textEnd = new JTextField();
		textEnd.setColumns(10);
		textEnd.setBounds(77, 167, 567, 20);
		contentPane.add(textEnd);
		
		JButton btnSave = new JButton("Salvar");
		btnSave.setBounds(217, 234, 89, 23);
		contentPane.add(btnSave);
		
		JButton btnClear = new JButton("Limpar");
		btnClear.setBounds(349, 234, 89, 23);
		contentPane.add(btnClear);
	}
}
