package br.com.menu.view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

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
		
		JLabel lblNewLabel = new JLabel("Cadastrar Curso");
		lblNewLabel.setBounds(33, 65, 164, 25);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Cadastrar Aluno");
		lblNewLabel_1.setBounds(515, 70, 117, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Cadastrar Notas");
		lblNewLabel_2.setBounds(32, 158, 130, 25);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Boletim");
		lblNewLabel_3.setBounds(296, 91, 57, 14);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_1_1 = new JLabel("Consultar Aluno");
		lblNewLabel_1_1.setBounds(515, 162, 117, 14);
		contentPane.add(lblNewLabel_1_1);
		
		JButton btnCadCurso = new JButton("");
		btnCadCurso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					CadastroCursoView CadCurso = new CadastroCursoView();
					// Fecha a tela anterior
					JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
					frame.dispose();
					//Inicia a tela de Cadastro
					CadCurso.CadCurView();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnCadCurso.setBounds(22, 91, 130, 56);
		contentPane.add(btnCadCurso);
		
		JButton btnCadAluno = new JButton("");
		btnCadAluno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					CadastroAlunoView CadAluno = new CadastroAlunoView();
					// Fecha a tela anterior
					JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
					frame.dispose();
					//Inicia a tela de Cadastro
					CadAluno.cadAluView();
					
				} catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnCadAluno.setBounds(502, 91, 130, 56);
		contentPane.add(btnCadAluno);
		
		JButton btnCadNotas = new JButton("");
		btnCadNotas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					CadastroNotasView cadNotas = new CadastroNotasView();
					// Fecha a tela anterior
					JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
					frame.dispose();
					//Inicia a tela de Cadastro
					cadNotas.cadNotasView();
					
				} catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});
		btnCadNotas.setBounds(22, 183, 130, 56);
		contentPane.add(btnCadNotas);
		
		JButton btnBoletim = new JButton("");
		btnBoletim.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					BoletimView boletim = new BoletimView();
					// Fecha a tela anterior
					JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
					frame.dispose();
					//Chama a função da tela de boletim
					boletim.boletimView();;
					
				} catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});		
		btnBoletim.setBounds(251, 112, 130, 107);
		contentPane.add(btnBoletim);
		
		JButton btnConsulta = new JButton("");
		btnConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					ConsultaView consulta = new ConsultaView();
					// Fecha a tela anterior
					JFrame frame = (JFrame) SwingUtilities.getRoot((Component) e.getSource());
					frame.dispose();
					//Chama a função da tela de consulta
					consulta.consView();
					
				} catch (Exception e1) {
					 e1.printStackTrace();
				}
			}
		});			
		btnConsulta.setBounds(502, 183, 130, 56);
		contentPane.add(btnConsulta);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 654, 22);
		contentPane.add(menuBar);
		
		JMenu menuajuda = new JMenu("Ajuda");
		menuBar.add(menuajuda);
		
		JMenuItem mntmSobre = new JMenuItem("Sobre");
		menuajuda.add(mntmSobre);
		
	}
}
