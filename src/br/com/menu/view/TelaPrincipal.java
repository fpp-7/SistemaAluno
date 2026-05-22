package br.com.menu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.MaskFormatter;

import br.com.menu.dao.AlunoDAO;
import br.com.menu.dao.NotasDAO;
import br.com.menu.model.Aluno;
import br.com.menu.model.Curso;
import br.com.menu.model.Notas;
import br.com.menu.util.ConnectionFactory;

public class TelaPrincipal extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTabbedPane tabbedPane;
	private JPanel jpDadosPessoais;
	private JPanel jpCurso;
	private JPanel jpNotaseFaltas;
	private JPanel jpBoletim;
	
	private JFormattedTextField txtDtaNascimento;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtEmail;
	private JFormattedTextField txtEnd;
	private JFormattedTextField txtMunicipio;
	private JComboBox<String> comboBoxUf;
	private JFormattedTextField txtCelular;
	
	private JLabel lblRgm;
	private JLabel lblDtaNascimento;
	private JLabel lblNome;
	private JLabel lblCpf;
	private JLabel lblEmail;
	private JLabel lblEnd;
	private JLabel lblMunicipio;
	private JLabel lblUf;
	private JLabel lblCelular;
	
	private JFormattedTextField txtNome;
	private JFormattedTextField txtRgm;
	
	private JMenuBar menuBar;
	private JMenu menualuno;
	private JMenu menunotafalta;
	private JMenu menuajuda;
	
	private JMenuItem mntmConsultar;
	private JMenuItem mntmSalvar;
	private JMenuItem mntmAlterar;
	private JMenuItem mntmExcluir;
	private JMenuItem mntmSair;
	private JMenuItem mntmNFSalvar;
	private JMenuItem mntmNFAlterar;
	private JMenuItem mntmNFExcluir;
	private JMenuItem mntmNFConsultar;
	private JMenuItem mntmSobre;
	
	private JLabel lblCurso;
	private JLabel lblCampus;
	private JLabel lblPeriodo;
	private JRadioButton rdbtnMatutino;
	private JRadioButton rdbtnVespertino;
	private JRadioButton rdbtnNoturno;
	
	private JLabel lblNFRgm;
	private JTextField txtNFRgm;
	private JTextField txtNFNome;
	private JLabel lblNFDisciplina;
	private JLabel lblNFSemestre;
	private JComboBox<String> comboBoxSemestre;
	private JComboBox<String> comboBoxDisciplina;
	private JComboBox<String> comboBoxNota;
	private JLabel lblNFNota;
	private JLabel lblNFFalta;
	private JTextField txtNFFalta;
	private JTextArea txtBoletim;
	private JTextField txtNFCurso;
	private final ButtonGroup grupoPeriodo = new ButtonGroup();
	private JComboBox<String> comboBoxCampus;
	private JComboBox<String> comboBoxCurso;
	
	private Aluno aluno;
	private Curso curso;
	private JLabel lblNewLabel;
	private JTextField txtBRgm;
	private JButton btBConsulta;
	private JButton btBLimpa;
	
	private JButton btDPSair;
	private JButton btDPconsultar;
	private JButton btDPSalvar;
	private JButton btDPAlterar;
	private JButton btDPExcluir;
	
	private JButton btCSair;
	private JButton btCConsultar;
	private JButton btCSalvar;
	private JButton btCAlterar;
	private JButton btCExcluir;
	
	private JButton btNSair;
	private JButton btNConsultar;
	private JButton btNSalvar;
	private JButton btNAlterar;
	private JButton btNExcluir;

	// Cores do Design System Premium
	private static final Color COLOR_BG = new Color(243, 244, 246); // Fundo cinza ultra-claro
	private static final Color COLOR_PANEL = new Color(249, 250, 251); // Fundo do painel
	private static final Color COLOR_PRIMARY = new Color(79, 70, 229); // Roxo moderno
	private static final Color COLOR_ACCENT = new Color(13, 148, 136); // Teal elegante
	private static final Color COLOR_DANGER = new Color(225, 29, 72); // Vermelho vibrante
	private static final Color COLOR_TEXT_MAIN = new Color(31, 41, 55); // Cinza grafite escuro
	private static final Color COLOR_TEXT_LABEL = new Color(75, 85, 99); // Cinza label

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipal frame = new TelaPrincipal();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaPrincipal() throws Exception {
		setType(Type.UTILITY);
		setTitle("Sistema de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 780, 540); // Espaço maior e mais harmonioso
		setLocationRelativeTo(null); // Centraliza na tela
		
		contentPane = new JPanel();
		contentPane.setBackground(COLOR_BG);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Menu Bar Estilizado
		menuBar = new JMenuBar();
		menuBar.setBackground(Color.WHITE);
		menuBar.setBorder(new LineBorder(new Color(229, 231, 235), 1));
		menuBar.setBounds(0, 0, 764, 30);
		contentPane.add(menuBar);

		menualuno = new JMenu("Aluno");
		menualuno.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(menualuno);

		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menualuno.add(mntmSalvar);
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDadosAluno();
			}
		});

		mntmAlterar = new JMenuItem("Alterar");
		mntmAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menualuno.add(mntmAlterar);
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarDadosAluno();
			}
		});

		mntmConsultar = new JMenuItem("Consultar");
		mntmConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menualuno.add(mntmConsultar);
		mntmConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAlunoPorRgm(txtRgm.getText());
			}
		});

		mntmExcluir = new JMenuItem("Excluir");
		mntmExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menualuno.add(mntmExcluir);
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAlunoPorRgm(txtRgm.getText());
			}
		});

		mntmSair = new JMenuItem("Sair");
		mntmSair.setFont(new Font("Segoe UI", Font.BOLD, 12));
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		menualuno.add(mntmSair);
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		menunotafalta = new JMenu("Notas e Faltas");
		menunotafalta.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(menunotafalta);

		mntmNFSalvar = new JMenuItem("Salvar");
		mntmNFSalvar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menunotafalta.add(mntmNFSalvar);
		mntmNFSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarNotasEFaltas();
			}
		});

		mntmNFAlterar = new JMenuItem("Alterar");
		mntmNFAlterar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		mntmNFAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		menunotafalta.add(mntmNFAlterar);
		mntmNFAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarNotasEFaltas();
			}
		});

		mntmNFExcluir = new JMenuItem("Excluir");
		mntmNFExcluir.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menunotafalta.add(mntmNFExcluir);
		mntmNFExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirNotasEFaltas();
			}
		});

		mntmNFConsultar = new JMenuItem("Consultar");
		mntmNFConsultar.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menunotafalta.add(mntmNFConsultar);
		mntmNFConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarNotasPorRgm(txtNFRgm.getText());
			}
		});

		menuajuda = new JMenu("Ajuda");
		menuajuda.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(menuajuda);

		mntmSobre = new JMenuItem("Sobre");
		mntmSobre.setFont(new Font("Segoe UI", Font.PLAIN, 12));
		menuajuda.add(mntmSobre);
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exibirInstrucoesSobre();
			}
		});

		// JTabbedPane Estilizado
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setFont(new Font("Segoe UI", Font.BOLD, 13));
		tabbedPane.setBounds(5, 38, 754, 455);
		contentPane.add(tabbedPane);

		// Formatadores de Campo
		MaskFormatter maskDtaNascimento = new MaskFormatter("##/##/####");
		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");
		MaskFormatter maskCelular = new MaskFormatter("(##)#########");
		maskDtaNascimento.setPlaceholderCharacter('_');
		maskCpf.setPlaceholderCharacter('_');
		maskCelular.setPlaceholderCharacter('_');

		// ----------------------------------------------------
		// 1ª ABA: DADOS PESSOAIS
		// ----------------------------------------------------
		jpDadosPessoais = new JPanel();
		jpDadosPessoais.setBackground(COLOR_PANEL);
		jpDadosPessoais.setLayout(null);
		tabbedPane.addTab("Dados Pessoais", null, jpDadosPessoais, null);

		// Labels & Inputs
		lblRgm = new JLabel("RGM");
		styleLabel(lblRgm);
		lblRgm.setBounds(20, 30, 60, 25);
		jpDadosPessoais.add(lblRgm);

		txtRgm = new JFormattedTextField();
		styleTextField(txtRgm);
		txtRgm.setBounds(80, 27, 120, 32);
		jpDadosPessoais.add(txtRgm);

		lblNome = new JLabel("Nome");
		styleLabel(lblNome);
		lblNome.setBounds(225, 30, 50, 25);
		jpDadosPessoais.add(lblNome);

		txtNome = new JFormattedTextField();
		styleTextField(txtNome);
		txtNome.setBounds(280, 27, 440, 32);
		jpDadosPessoais.add(txtNome);

		lblDtaNascimento = new JLabel("Nascimento");
		styleLabel(lblDtaNascimento);
		lblDtaNascimento.setBounds(20, 80, 100, 25);
		jpDadosPessoais.add(lblDtaNascimento);

		txtDtaNascimento = new JFormattedTextField(maskDtaNascimento);
		styleTextField(txtDtaNascimento);
		txtDtaNascimento.setBounds(110, 77, 130, 32);
		jpDadosPessoais.add(txtDtaNascimento);

		lblCpf = new JLabel("CPF");
		styleLabel(lblCpf);
		lblCpf.setBounds(270, 80, 40, 25);
		jpDadosPessoais.add(lblCpf);

		txtCpf = new JFormattedTextField(maskCpf);
		styleTextField(txtCpf);
		txtCpf.setBounds(315, 77, 190, 32);
		jpDadosPessoais.add(txtCpf);

		lblEmail = new JLabel("Email");
		styleLabel(lblEmail);
		lblEmail.setBounds(20, 130, 60, 25);
		jpDadosPessoais.add(lblEmail);

		txtEmail = new JFormattedTextField();
		styleTextField(txtEmail);
		txtEmail.setBounds(80, 127, 640, 32);
		jpDadosPessoais.add(txtEmail);

		lblEnd = new JLabel("End.");
		styleLabel(lblEnd);
		lblEnd.setBounds(20, 180, 60, 25);
		jpDadosPessoais.add(lblEnd);

		txtEnd = new JFormattedTextField();
		styleTextField(txtEnd);
		txtEnd.setBounds(80, 177, 640, 32);
		jpDadosPessoais.add(txtEnd);

		lblMunicipio = new JLabel("Município");
		styleLabel(lblMunicipio);
		lblMunicipio.setBounds(20, 230, 80, 25);
		jpDadosPessoais.add(lblMunicipio);

		txtMunicipio = new JFormattedTextField();
		styleTextField(txtMunicipio);
		txtMunicipio.setBounds(95, 227, 160, 32);
		jpDadosPessoais.add(txtMunicipio);

		lblUf = new JLabel("UF");
		styleLabel(lblUf);
		lblUf.setBounds(280, 230, 30, 25);
		jpDadosPessoais.add(lblUf);

		comboBoxUf = new JComboBox();
		comboBoxUf.setModel(new DefaultComboBoxModel(
				new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		styleComboBox(comboBoxUf);
		comboBoxUf.setBounds(315, 227, 70, 32);
		jpDadosPessoais.add(comboBoxUf);

		lblCelular = new JLabel("Celular");
		styleLabel(lblCelular);
		lblCelular.setBounds(415, 230, 60, 25);
		jpDadosPessoais.add(lblCelular);

		txtCelular = new JFormattedTextField(maskCelular);
		styleTextField(txtCelular);
		txtCelular.setBounds(475, 227, 245, 32);
		jpDadosPessoais.add(txtCelular);

		// Botões de Ação na 1ª Aba
		btDPSair = createActionButton("/br/com/menu/img/icons8-off-59.png", "Sair do Aplicativo");
		btDPSair.setBounds(155, 310, 72, 60);
		jpDadosPessoais.add(btDPSair);
		btDPSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btDPSalvar = createActionButton("/br/com/menu/img/icons8-save-all-60.png", "Salvar Aluno");
		btDPSalvar.setBounds(242, 310, 72, 60);
		jpDadosPessoais.add(btDPSalvar);
		btDPSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDadosAluno();
			}
		});

		btDPAlterar = createActionButton("/br/com/menu/img/icons8-edit-60.png", "Alterar Aluno");
		btDPAlterar.setBounds(329, 310, 72, 60);
		jpDadosPessoais.add(btDPAlterar);
		btDPAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarDadosAluno();
			}
		});

		btDPconsultar = createActionButton("/br/com/menu/img/icons8-search-60.png", "Consultar Aluno");
		btDPconsultar.setBounds(416, 310, 72, 60);
		jpDadosPessoais.add(btDPconsultar);
		btDPconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAlunoPorRgm(txtRgm.getText());
			}
		});

		btDPExcluir = createActionButton("/br/com/menu/img/icons8-delete-60.png", "Excluir Aluno");
		btDPExcluir.setBounds(503, 310, 72, 60);
		jpDadosPessoais.add(btDPExcluir);
		btDPExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAlunoPorRgm(txtRgm.getText());
			}
		});


		// ----------------------------------------------------
		// 2ª ABA: CURSO
		// ----------------------------------------------------
		jpCurso = new JPanel();
		jpCurso.setBackground(COLOR_PANEL);
		jpCurso.setLayout(null);
		tabbedPane.addTab("Curso", null, jpCurso, null);

		lblCurso = new JLabel("Curso");
		styleLabel(lblCurso);
		lblCurso.setBounds(30, 45, 80, 25);
		jpCurso.add(lblCurso);

		comboBoxCurso = new JComboBox();
		comboBoxCurso.setModel(
				new DefaultComboBoxModel(new String[] { "--", "Ciencia da Computação", "Medicina", "Direito" }));
		styleComboBox(comboBoxCurso);
		comboBoxCurso.setBounds(110, 41, 380, 32);
		jpCurso.add(comboBoxCurso);

		lblCampus = new JLabel("Campus");
		styleLabel(lblCampus);
		lblCampus.setBounds(30, 105, 80, 25);
		jpCurso.add(lblCampus);

		comboBoxCampus = new JComboBox();
		comboBoxCampus.setModel(
				new DefaultComboBoxModel(new String[] { "--", "Unicid - Carrão", "Unicid - Cid. Universitaria" }));
		styleComboBox(comboBoxCampus);
		comboBoxCampus.setBounds(110, 101, 380, 32);
		jpCurso.add(comboBoxCampus);

		lblPeriodo = new JLabel("Período");
		styleLabel(lblPeriodo);
		lblPeriodo.setBounds(30, 165, 80, 25);
		jpCurso.add(lblPeriodo);

		rdbtnMatutino = new JRadioButton("Matutino");
		rdbtnMatutino.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnMatutino.setBackground(COLOR_PANEL);
		rdbtnMatutino.setForeground(COLOR_TEXT_MAIN);
		grupoPeriodo.add(rdbtnMatutino);
		rdbtnMatutino.setBounds(110, 166, 100, 23);
		jpCurso.add(rdbtnMatutino);

		rdbtnVespertino = new JRadioButton("Vespertino");
		rdbtnVespertino.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnVespertino.setBackground(COLOR_PANEL);
		rdbtnVespertino.setForeground(COLOR_TEXT_MAIN);
		grupoPeriodo.add(rdbtnVespertino);
		rdbtnVespertino.setBounds(220, 166, 110, 23);
		jpCurso.add(rdbtnVespertino);

		rdbtnNoturno = new JRadioButton("Noturno");
		rdbtnNoturno.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		rdbtnNoturno.setBackground(COLOR_PANEL);
		rdbtnNoturno.setForeground(COLOR_TEXT_MAIN);
		grupoPeriodo.add(rdbtnNoturno);
		rdbtnNoturno.setBounds(340, 166, 100, 23);
		jpCurso.add(rdbtnNoturno);

		// Botões de Ação na 2ª Aba
		btCSair = createActionButton("/br/com/menu/img/icons8-off-59.png", "Sair do Aplicativo");
		btCSair.setBounds(155, 310, 72, 60);
		jpCurso.add(btCSair);
		btCSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btCSalvar = createActionButton("/br/com/menu/img/icons8-save-all-60.png", "Salvar Aluno");
		btCSalvar.setBounds(242, 310, 72, 60);
		jpCurso.add(btCSalvar);
		btCSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarDadosAluno();
			}
		});

		btCAlterar = createActionButton("/br/com/menu/img/icons8-edit-60.png", "Alterar Aluno");
		btCAlterar.setBounds(329, 310, 72, 60);
		jpCurso.add(btCAlterar);
		btCAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarDadosAluno();
			}
		});

		btCConsultar = createActionButton("/br/com/menu/img/icons8-search-60.png", "Consultar Aluno");
		btCConsultar.setBounds(416, 310, 72, 60);
		jpCurso.add(btCConsultar);
		btCConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarAlunoPorRgm(txtRgm.getText());
			}
		});

		btCExcluir = createActionButton("/br/com/menu/img/icons8-delete-60.png", "Excluir Aluno");
		btCExcluir.setBounds(503, 310, 72, 60);
		jpCurso.add(btCExcluir);
		btCExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirAlunoPorRgm(txtRgm.getText());
			}
		});


		// ----------------------------------------------------
		// 3ª ABA: NOTAS E FALTAS
		// ----------------------------------------------------
		jpNotaseFaltas = new JPanel();
		jpNotaseFaltas.setBackground(COLOR_PANEL);
		jpNotaseFaltas.setLayout(null);
		tabbedPane.addTab("Notas e Faltas", null, jpNotaseFaltas, null);

		lblNFRgm = new JLabel("RGM");
		styleLabel(lblNFRgm);
		lblNFRgm.setBounds(25, 30, 50, 25);
		jpNotaseFaltas.add(lblNFRgm);

		txtNFRgm = new JTextField();
		styleTextField(txtNFRgm);
		txtNFRgm.setBounds(85, 27, 110, 32);
		jpNotaseFaltas.add(txtNFRgm);

		txtNFNome = new JTextField();
		styleTextField(txtNFNome);
		txtNFNome.setEditable(false);
		txtNFNome.setBackground(new Color(237, 233, 254)); // Roxo claro diferenciando campo inativo
		txtNFNome.setBounds(210, 27, 455, 32);
		jpNotaseFaltas.add(txtNFNome);

		txtNFCurso = new JTextField();
		styleTextField(txtNFCurso);
		txtNFCurso.setEditable(false);
		txtNFCurso.setBackground(new Color(237, 233, 254));
		txtNFCurso.setBounds(85, 77, 580, 32);
		jpNotaseFaltas.add(txtNFCurso);

		lblNFDisciplina = new JLabel("Disciplina");
		styleLabel(lblNFDisciplina);
		lblNFDisciplina.setBounds(25, 130, 80, 25);
		jpNotaseFaltas.add(lblNFDisciplina);

		comboBoxDisciplina = new JComboBox();
		styleComboBox(comboBoxDisciplina);
		comboBoxDisciplina.setBounds(105, 127, 560, 32);
		jpNotaseFaltas.add(comboBoxDisciplina);

		lblNFSemestre = new JLabel("Semestre");
		styleLabel(lblNFSemestre);
		lblNFSemestre.setBounds(25, 180, 80, 25);
		jpNotaseFaltas.add(lblNFSemestre);

		comboBoxSemestre = new JComboBox();
		comboBoxSemestre.setModel(new DefaultComboBoxModel(new String[] { "--", "1.2022", "2.2022", "1.2023", "2.2023" }));
		styleComboBox(comboBoxSemestre);
		comboBoxSemestre.setBounds(105, 177, 110, 32);
		jpNotaseFaltas.add(comboBoxSemestre);

		lblNFNota = new JLabel("Nota");
		styleLabel(lblNFNota);
		lblNFNota.setBounds(240, 180, 45, 25);
		jpNotaseFaltas.add(lblNFNota);

		comboBoxNota = new JComboBox();
		comboBoxNota.setModel(new DefaultComboBoxModel(new String[] { "--", "0,0", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0",
				"3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10,0", "10" }));
		styleComboBox(comboBoxNota);
		comboBoxNota.setBounds(285, 177, 80, 32);
		jpNotaseFaltas.add(comboBoxNota);

		lblNFFalta = new JLabel("Faltas");
		styleLabel(lblNFFalta);
		lblNFFalta.setBounds(395, 180, 50, 25);
		jpNotaseFaltas.add(lblNFFalta);

		txtNFFalta = new JTextField();
		styleTextField(txtNFFalta);
		txtNFFalta.setBounds(450, 177, 80, 32);
		jpNotaseFaltas.add(txtNFFalta);

		// Botões de Ação na 3ª Aba
		btNSair = createActionButton("/br/com/menu/img/icons8-off-59.png", "Sair do Aplicativo");
		btNSair.setBounds(155, 310, 72, 60);
		jpNotaseFaltas.add(btNSair);
		btNSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});

		btNSalvar = createActionButton("/br/com/menu/img/icons8-save-all-60.png", "Salvar Notas");
		btNSalvar.setBounds(242, 310, 72, 60);
		jpNotaseFaltas.add(btNSalvar);
		btNSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salvarNotasEFaltas();
			}
		});

		btNAlterar = createActionButton("/br/com/menu/img/icons8-edit-60.png", "Alterar Notas");
		btNAlterar.setBounds(329, 310, 72, 60);
		jpNotaseFaltas.add(btNAlterar);
		btNAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterarNotasEFaltas();
			}
		});

		btNConsultar = createActionButton("/br/com/menu/img/icons8-search-60.png", "Consultar Notas");
		btNConsultar.setBounds(416, 310, 72, 60);
		jpNotaseFaltas.add(btNConsultar);
		btNConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				consultarNotasPorRgm(txtNFRgm.getText());
			}
		});

		btNExcluir = createActionButton("/br/com/menu/img/icons8-delete-60.png", "Excluir Notas");
		btNExcluir.setBounds(503, 310, 72, 60);
		jpNotaseFaltas.add(btNExcluir);
		btNExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				excluirNotasEFaltas();
			}
		});


		// ----------------------------------------------------
		// 4ª ABA: BOLETIM (RENOMEADO)
		// ----------------------------------------------------
		jpBoletim = new JPanel();
		jpBoletim.setBackground(COLOR_PANEL);
		jpBoletim.setLayout(null);
		tabbedPane.addTab("Boletim", null, jpBoletim, null); // Nome corrigido!

		lblNewLabel = new JLabel("Digite o RGM");
		styleLabel(lblNewLabel);
		lblNewLabel.setBounds(20, 20, 100, 25);
		jpBoletim.add(lblNewLabel);

		txtBRgm = new JTextField();
		styleTextField(txtBRgm);
		txtBRgm.setBounds(115, 17, 120, 32);
		jpBoletim.add(txtBRgm);

		// Botões estilizados do Boletim
		btBConsulta = new JButton("Consultar");
		btBConsulta.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btBConsulta.setForeground(Color.WHITE);
		btBConsulta.setBackground(COLOR_PRIMARY);
		btBConsulta.setFocusPainted(false);
		btBConsulta.setBorder(new EmptyBorder(5, 15, 5, 15));
		btBConsulta.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btBConsulta.setBounds(250, 17, 120, 32);
		jpBoletim.add(btBConsulta);
		btBConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gerarBoletimFormatado();
			}
		});

		btBLimpa = new JButton("Limpar");
		btBLimpa.setFont(new Font("Segoe UI", Font.BOLD, 13));
		btBLimpa.setForeground(new Color(75, 85, 99));
		btBLimpa.setBackground(new Color(229, 231, 235));
		btBLimpa.setFocusPainted(false);
		btBLimpa.setBorder(new EmptyBorder(5, 15, 5, 15));
		btBLimpa.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		btBLimpa.setBounds(380, 17, 100, 32);
		jpBoletim.add(btBLimpa);
		btBLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBoletim.setText("");
			}
		});

		// Text Area em Monospaced com ScrollPane
		txtBoletim = new JTextArea();
		txtBoletim.setFont(new Font("Consolas", Font.PLAIN, 13)); // Fonte perfeita para tabelas alinhadas
		txtBoletim.setEditable(false);
		txtBoletim.setBackground(Color.WHITE);
		txtBoletim.setForeground(new Color(31, 41, 55));
		txtBoletim.setBorder(new EmptyBorder(10, 10, 10, 10));

		JScrollPane scrollPane = new JScrollPane(txtBoletim);
		scrollPane.setBounds(20, 65, 710, 340);
		scrollPane.setBorder(new LineBorder(new Color(229, 231, 235), 1));
		jpBoletim.add(scrollPane);
	}

	// ----------------------------------------------------
	// MÉTODOS DE CONTROLE E RE-ESTILIZAÇÃO (DESIGN SYSTEM)
	// ----------------------------------------------------
	
	private void styleTextField(JTextField field) {
		field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
		field.setBorder(javax.swing.BorderFactory.createCompoundBorder(
			javax.swing.BorderFactory.createLineBorder(new Color(209, 213, 219), 1),
			javax.swing.BorderFactory.createEmptyBorder(4, 10, 4, 10)
		));
		field.setBackground(Color.WHITE);
		field.setForeground(COLOR_TEXT_MAIN);
	}

	private void styleLabel(JLabel label) {
		label.setFont(new Font("Segoe UI", Font.BOLD, 13));
		label.setForeground(COLOR_TEXT_LABEL);
	}

	private void styleComboBox(JComboBox<?> box) {
		box.setFont(new Font("Segoe UI", Font.PLAIN, 13));
		box.setBackground(Color.WHITE);
		box.setBorder(javax.swing.BorderFactory.createLineBorder(new Color(209, 213, 219), 1));
	}

	private JButton createActionButton(String iconPath, String tooltip) {
		JButton button = new JButton();
		try {
			java.net.URL imgUrl = TelaPrincipal.class.getResource(iconPath);
			if (imgUrl != null) {
				button.setIcon(new ImageIcon(imgUrl));
			}
		} catch (Exception e) {
			System.err.println("Icon missing: " + iconPath);
		}
		button.setToolTipText(tooltip);
		button.setFocusPainted(false);
		button.setBorderPainted(true);
		button.setContentAreaFilled(false);
		button.setOpaque(true);
		button.setBackground(Color.WHITE);
		button.setBorder(new LineBorder(new Color(229, 231, 235), 1));
		button.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
		
		// Efeito Hover
		button.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseEntered(java.awt.event.MouseEvent e) {
				button.setBackground(new Color(243, 244, 246));
				button.setBorder(new LineBorder(COLOR_PRIMARY, 1));
			}
			public void mouseExited(java.awt.event.MouseEvent e) {
				button.setBackground(Color.WHITE);
				button.setBorder(new LineBorder(new Color(229, 231, 235), 1));
			}
		});
		return button;
	}

	// ----------------------------------------------------
	// MÉTODOS DE SISTEMA & BANCO DE DADOS (COM VALIDAÇÃO)
	// ----------------------------------------------------

	private void salvarDadosAluno() {
		try {
			// Validação do RGM
			String rgmStr = txtRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o campo RGM.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
				txtRgm.requestFocus();
				return;
			}
			int rgm;
			try {
				rgm = Integer.parseInt(rgmStr);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "O RGM deve ser apenas números inteiros.", "Formato Inválido", JOptionPane.WARNING_MESSAGE);
				txtRgm.requestFocus();
				return;
			}

			// Validação do Nome
			String nome = txtNome.getText().trim();
			if (nome.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Por favor, preencha o campo Nome.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
				txtNome.requestFocus();
				return;
			}

			Aluno aluno = new Aluno();
			Curso curso = new Curso();
			Notas nota = new Notas();

			aluno.setRgm(rgm);
			curso.setRgm(rgm);
			aluno.setNome(nome);
			aluno.setEmail(txtEmail.getText().trim());
			aluno.setDtaNascimento(txtDtaNascimento.getText().trim());
			aluno.setEndereco(txtEnd.getText().trim());
			aluno.setCpf(txtCpf.getText().trim());
			aluno.setUF(comboBoxUf.getSelectedItem().toString());
			aluno.setMunicipio(txtMunicipio.getText().trim());
			aluno.setCelular(txtCelular.getText().trim());
			
			curso.setCampus(comboBoxCampus.getSelectedItem().toString());
			curso.setCurso(comboBoxCurso.getSelectedItem().toString());

			if (rdbtnMatutino.isSelected()) {
				curso.setPeriodo("Matutino");
			} else if (rdbtnVespertino.isSelected()) {
				curso.setPeriodo("Vespertino");
			} else if (rdbtnNoturno.isSelected()) {
				curso.setPeriodo("Noturno");
			} else {
				curso.setPeriodo("Não Definido");
			}

			AlunoDAO dao = new AlunoDAO();
			dao.salvar(aluno, curso, nota);
			JOptionPane.showMessageDialog(this, "Aluno e Curso cadastrados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (Exception e1) {
			e1.printStackTrace();
			JOptionPane.showMessageDialog(this, "Erro ao salvar aluno:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void alterarDadosAluno() {
		try {
			String rgmStr = txtRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM do aluno que deseja alterar.", "RGM Requerido", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			Aluno aluno = new Aluno();
			Curso curso = new Curso();

			aluno.setRgm(rgm);
			curso.setRgm(rgm);
			aluno.setNome(txtNome.getText().trim());
			aluno.setEmail(txtEmail.getText().trim());
			aluno.setDtaNascimento(txtDtaNascimento.getText().trim());
			aluno.setEndereco(txtEnd.getText().trim());
			aluno.setCpf(txtCpf.getText().trim());
			aluno.setUF(comboBoxUf.getSelectedItem().toString());
			aluno.setMunicipio(txtMunicipio.getText().trim());
			aluno.setCelular(txtCelular.getText().trim());

			curso.setCampus(comboBoxCampus.getSelectedItem().toString());
			curso.setCurso(comboBoxCurso.getSelectedItem().toString());

			if (rdbtnMatutino.isSelected()) {
				curso.setPeriodo("Matutino");
			} else if (rdbtnVespertino.isSelected()) {
				curso.setPeriodo("Vespertino");
			} else if (rdbtnNoturno.isSelected()) {
				curso.setPeriodo("Noturno");
			}

			AlunoDAO dao = new AlunoDAO();
			dao.atualizar(aluno, curso);
			JOptionPane.showMessageDialog(this, "Dados do aluno atualizados com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "O RGM informado é inválido.", "Erro", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao atualizar dados:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void consultarAlunoPorRgm(String rgmText) {
		try {
			String rgmStr = rgmText.trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM para fazer a busca.", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			AlunoDAO dao = new AlunoDAO();
			aluno = dao.consultarAluno(rgm);

			if (aluno == null) {
				JOptionPane.showMessageDialog(this, "Aluno com o RGM " + rgm + " não foi encontrado.", "Não Encontrado", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			txtNome.setText(aluno.getNome());
			txtCpf.setValue(aluno.getCpf());
			txtEnd.setText(aluno.getEndereco());
			txtDtaNascimento.setValue(aluno.getDtaNascimento());
			
			String ufSelect = aluno.getUF();
			for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
				if (comboBoxUf.getItemAt(i).equals(ufSelect)) {
					comboBoxUf.setSelectedIndex(i);
					break;
				}
			}

			txtMunicipio.setText(aluno.getMunicipio());
			txtCelular.setValue(aluno.getCelular());
			txtEmail.setText(aluno.getEmail());

			// Sincroniza também as informações na aba Curso
			dao = new AlunoDAO();
			curso = dao.consultarCurso(rgm);

			if (curso != null) {
				String cursoSelect = curso.getCurso();
				for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
					if (comboBoxCurso.getItemAt(i).equals(cursoSelect)) {
						comboBoxCurso.setSelectedIndex(i);
						break;
					}
				}

				String campusSelect = curso.getCampus();
				for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
					if (comboBoxCampus.getItemAt(i).equals(campusSelect)) {
						comboBoxCampus.setSelectedIndex(i);
						break;
					}
				}

				if ("Matutino".equals(curso.getPeriodo())) {
					grupoPeriodo.setSelected(rdbtnMatutino.getModel(), true);
				} else if ("Vespertino".equals(curso.getPeriodo())) {
					grupoPeriodo.setSelected(rdbtnVespertino.getModel(), true);
				} else if ("Noturno".equals(curso.getPeriodo())) {
					grupoPeriodo.setSelected(rdbtnNoturno.getModel(), true);
				} else {
					grupoPeriodo.clearSelection();
				}
			}
			
			// Se o RGM de Notas e Faltas estiver vazio, preenche ele automaticamente
			if (txtNFRgm.getText().trim().isEmpty()) {
				txtNFRgm.setText(rgmStr);
				consultarNotasPorRgm(rgmStr);
			}

		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "O RGM deve ser composto apenas por números.", "Erro de Digitação", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao realizar consulta:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void excluirAlunoPorRgm(String rgmText) {
		try {
			String rgmStr = rgmText.trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM do aluno a ser deletado.", "Campo Vazio", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			int confirm = JOptionPane.showConfirmDialog(this, 
				"Tem certeza de que deseja EXCLUIR o aluno de RGM " + rgm + " e todos os seus registros acadêmicos?",
				"Confirmação de Exclusão", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
			
			if (confirm == JOptionPane.YES_OPTION) {
				AlunoDAO dao = new AlunoDAO();
				dao.excluir(rgm);
				JOptionPane.showMessageDialog(this, "Aluno excluído com sucesso!", "Concluído", JOptionPane.INFORMATION_MESSAGE);
				limparFormularios();
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "RGM inválido.", "Erro", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao excluir aluno:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void salvarNotasEFaltas() {
		try {
			String rgmStr = txtNFRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM na aba Notas e Faltas.", "Campo Obrigatório", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			Notas notas = new Notas();
			notas.setRgm(rgm);
			notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
			notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
			notas.setFalta(Integer.parseInt(txtNFFalta.getText().trim()));
			notas.setNota(comboBoxNota.getSelectedItem().toString());

			NotasDAO dao = new NotasDAO();
			dao.salvarNotas(notas);
			JOptionPane.showMessageDialog(this, "Notas e Faltas cadastradas com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Certifique-se de que o RGM e as Faltas sejam números válidos.", "Entrada Inválida", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void alterarNotasEFaltas() {
		try {
			String rgmStr = txtNFRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM correspondente.", "Campo Requerido", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			Notas notas = new Notas();
			notas.setRgm(rgm);
			notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
			notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
			notas.setFalta(Integer.parseInt(txtNFFalta.getText().trim()));
			notas.setNota(comboBoxNota.getSelectedItem().toString());
			notas.setRgmSemestreDisciplina(notas.getRgm() + notas.getSemestre() + notas.getDisciplina());

			NotasDAO dao = new NotasDAO();
			dao.atualizar(notas);
			JOptionPane.showMessageDialog(this, "Registro de Notas atualizado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "Entradas de formato numérico inválidas.", "Erro", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void excluirNotasEFaltas() {
		try {
			String rgmStr = txtNFRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "RGM está vazio.", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}
			
			String semestre = comboBoxSemestre.getSelectedItem().toString();
			String disciplina = comboBoxDisciplina.getSelectedItem().toString();

			if ("--".equals(semestre) || "--".equals(disciplina)) {
				JOptionPane.showMessageDialog(this, "Selecione o Semestre e a Disciplina que deseja excluir.", "Selecione os Filtros", JOptionPane.WARNING_MESSAGE);
				return;
			}

			String compositeKey = rgmStr.trim() + semestre + disciplina;

			int confirm = JOptionPane.showConfirmDialog(this, 
				"Deseja excluir a nota do RGM " + rgmStr + " em " + disciplina + " (" + semestre + ")?",
				"Confirmar Exclusão de Nota", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);

			if (confirm == JOptionPane.YES_OPTION) {
				NotasDAO dao = new NotasDAO();
				dao.excluir(compositeKey);
				JOptionPane.showMessageDialog(this, "Registro excluído com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
			}
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao excluir registro:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void consultarNotasPorRgm(String rgmText) {
		try {
			String rgmStr = rgmText.trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Preencha o RGM para consultar.", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			NotasDAO dao = new NotasDAO();
			aluno = dao.consultarAluno(rgm);

			if (aluno == null) {
				JOptionPane.showMessageDialog(this, "Estudante com o RGM informado não encontrado.", "Alerta", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			txtNFNome.setText(aluno.getNome());

			dao = new NotasDAO();
			curso = dao.consultarCurso(rgm);
			
			if (curso != null) {
				txtNFCurso.setText(curso.getCurso());
				String cursoSelect = curso.getCurso();

				// Configura o combobox de disciplinas de acordo com o curso retornado
				if ("Ciencia da Computação".equalsIgnoreCase(cursoSelect)) {
					comboBoxDisciplina.setModel(new DefaultComboBoxModel(
							new String[] { "--", "Estrutura de dados", "Matematica Discreta" }));
				} else if ("Medicina".equalsIgnoreCase(cursoSelect)) {
					comboBoxDisciplina.setModel(
							new DefaultComboBoxModel(new String[] { "--", "Radiologia", "Fisiologia" }));
				} else if ("Direito".equalsIgnoreCase(cursoSelect)) {
					comboBoxDisciplina.setModel(new DefaultComboBoxModel(
							new String[] { "--", "Direito Civil", "Direito Trabalhista" }));
				} else {
					comboBoxDisciplina.setModel(new DefaultComboBoxModel(new String[] { "--" }));
				}
			} else {
				txtNFCurso.setText("Sem Curso Vinculado");
				comboBoxDisciplina.setModel(new DefaultComboBoxModel(new String[] { "--" }));
			}
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "O RGM informado é incorreto.", "Erro de Formato", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao consultar notas:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void gerarBoletimFormatado() {
		try {
			String rgmStr = txtBRgm.getText().trim();
			if (rgmStr.isEmpty()) {
				JOptionPane.showMessageDialog(this, "Digite o RGM do aluno para gerar o Boletim.", "Aviso", JOptionPane.WARNING_MESSAGE);
				return;
			}
			int rgm = Integer.parseInt(rgmStr);

			NotasDAO dao = new NotasDAO();
			aluno = dao.consultarAluno(rgm);
			if (aluno == null) {
				JOptionPane.showMessageDialog(this, "Nenhum aluno localizado com o RGM informado.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
				return;
			}

			dao = new NotasDAO();
			curso = dao.consultarCurso(rgm);
			String nomeCurso = (curso != null) ? curso.getCurso() : "Sem curso";

			dao = new NotasDAO();
			List<Notas> notasList = dao.boletim(rgm);

			// Geração da Tabela em ASCII Premium
			StringBuilder sb = new StringBuilder();
			sb.append("=========================================================================\n");
			sb.append("                        BOLETIM DE DESEMPENHO                            \n");
			sb.append("=========================================================================\n");
			sb.append(String.format(" RGM:   %-15d | Nome:  %s\n", rgm, aluno.getNome()));
			sb.append(String.format(" Curso: %-15s\n", nomeCurso));
			sb.append("-------------------------------------------------------------------------\n");
			sb.append(String.format(" %-10s | %-32s | %-8s | %-6s \n", "Semestre", "Disciplina", "Faltas", "Nota"));
			sb.append("-------------------------------------------------------------------------\n");

			if (notasList == null || notasList.isEmpty()) {
				sb.append("                 Nenhuma nota lançada para este aluno.                   \n");
			} else {
				for (Notas n : notasList) {
					sb.append(String.format(" %-10s | %-32s | %-8d | %-6s \n", 
							n.getSemestre(), n.getDisciplina(), n.getFalta(), n.getNota()));
				}
			}
			sb.append("=========================================================================\n");
			sb.append(" Status: Completo 🆗\n");

			txtBoletim.setText(sb.toString());
			JOptionPane.showMessageDialog(this, "Boletim gerado com sucesso!", "Sucesso", JOptionPane.INFORMATION_MESSAGE);
		} catch (NumberFormatException e) {
			JOptionPane.showMessageDialog(this, "O RGM informado é incorreto.", "Erro de Digitação", JOptionPane.WARNING_MESSAGE);
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(this, "Erro ao gerar o boletim:\n" + e1.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
		}
	}

	private void exibirInstrucoesSobre() {
		String[] instrucoes = { 
			"Passo 1:\nCadastre os dados pessoais do aluno na aba 'Dados Pessoais' e salve.",
			"Passo 2:\nInsira o RGM do aluno na aba 'Curso', selecione o curso, campus e período e salve.",
			"Passo 3:\nNa aba 'Notas e Faltas', informe o RGM do aluno e clique no botão de lupa (Consultar).\nIsso carregará o nome do aluno, curso e as disciplinas corretas automaticamente.",
			"Passo 4:\nSelecione a disciplina, o semestre, a nota e o número de faltas do aluno e clique em Salvar (Disquete).",
			"Passo 5:\nNa aba 'Boletim', digite o RGM do aluno e clique em 'Consultar' para ver o boletim completo em formato de tabela elegante!" 
		};
		int i = 0;
		int resposta = JOptionPane.YES_OPTION;
		while (i < instrucoes.length && resposta == JOptionPane.YES_OPTION) {
			resposta = JOptionPane.showOptionDialog(this, instrucoes[i], 
					"Guia de Uso Acadêmico (" + (i + 1) + "/5)",
					JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
					new String[] { "Próximo", "Sair do Guia" }, "Próximo");
			i++;
		}
	}

	private void limparFormularios() {
		txtRgm.setText("");
		txtNome.setText("");
		txtDtaNascimento.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtEnd.setText("");
		txtMunicipio.setText("");
		comboBoxUf.setSelectedIndex(0);
		txtCelular.setText("");
		
		comboBoxCurso.setSelectedIndex(0);
		comboBoxCampus.setSelectedIndex(0);
		grupoPeriodo.clearSelection();

		txtNFRgm.setText("");
		txtNFNome.setText("");
		txtNFCurso.setText("");
		comboBoxDisciplina.setModel(new DefaultComboBoxModel(new String[] { "--" }));
		comboBoxSemestre.setSelectedIndex(0);
		comboBoxNota.setSelectedIndex(0);
		txtNFFalta.setText("");
		
		txtBRgm.setText("");
		txtBoletim.setText("");
	}
}
