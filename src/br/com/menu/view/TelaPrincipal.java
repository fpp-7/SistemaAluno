package br.com.menu.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.TextArea;
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
import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import br.com.menu.dao.AlunoDAO;
import br.com.menu.dao.NotasDAO;
import br.com.menu.model.Aluno;
import br.com.menu.model.Curso;
import br.com.menu.model.Notas;

public class TelaPrincipal extends JFrame {

	/**
	 * 
	 */
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
	private JComboBox<?> comboBoxUf;
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
	private JComboBox<?> comboBoxSemestre;
	private JComboBox<?> comboBoxDisciplina;
	private JComboBox<?> comboBoxNota;
	private JLabel lblNFNota;
	private JLabel lblNFFalta;
	private JTextField txtNFFalta;
	private TextArea txtBoletim;
	private JTextField txtNFCurso;
	private final ButtonGroup grupoPeriodo = new ButtonGroup();
	private JComboBox<?> comboBoxCampus;
	private JComboBox<?> comboBoxCurso;
	@SuppressWarnings("unused")
	private Object objectUf;
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

	/**
	 * Launch the application.
	 */
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

	/**
	 * Create the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public TelaPrincipal() throws Exception {
		setType(Type.UTILITY);
		setTitle("Sistema de Alunos");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 680, 376);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(0, 33, 664, 304);
		contentPane.add(tabbedPane);

		MaskFormatter maskDtaNascimento = new MaskFormatter("##/##/####");

		MaskFormatter maskCpf = new MaskFormatter("###.###.###-##");

		MaskFormatter maskCelular = new MaskFormatter("(##)#########");

		jpDadosPessoais = new JPanel();
		tabbedPane.addTab("Dados Pessoais", null, jpDadosPessoais, null);
		jpDadosPessoais.setLayout(null);
		txtDtaNascimento = new JFormattedTextField(maskDtaNascimento);
		txtDtaNascimento.setBounds(163, 63, 126, 25);
		txtDtaNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtDtaNascimento);
		txtCpf = new JFormattedTextField(maskCpf);
		txtCpf.setBounds(424, 63, 205, 25);
		txtCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtCpf);

		txtEmail = new JFormattedTextField();
		txtEmail.setBounds(63, 93, 566, 25);
		txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtEmail);

		txtEnd = new JFormattedTextField();
		txtEnd.setBounds(63, 123, 566, 25);
		txtEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtEnd);

		txtMunicipio = new JFormattedTextField();
		txtMunicipio.setBounds(73, 153, 114, 25);
		txtMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtMunicipio);

		comboBoxUf = new JComboBox();
		comboBoxUf.setBounds(259, 153, 46, 25);
		comboBoxUf.setModel(new DefaultComboBoxModel(
				new String[] { "--", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB",
						"PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));
		comboBoxUf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(comboBoxUf);
		txtCelular = new JFormattedTextField(maskCelular);
		txtCelular.setBounds(371, 153, 258, 25);
		txtCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtCelular);

		lblRgm = new JLabel("RGM");
		lblRgm.setBounds(11, 33, 56, 25);
		lblRgm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblRgm);

		lblDtaNascimento = new JLabel("Data de Nascimento ");
		lblDtaNascimento.setBounds(11, 63, 155, 25);
		lblDtaNascimento.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblDtaNascimento);

		lblNome = new JLabel("Nome");
		lblNome.setBounds(230, 33, 46, 25);
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblNome);

		lblCpf = new JLabel("CPF");
		lblCpf.setBounds(368, 63, 46, 25);
		lblCpf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblCpf);

		lblEmail = new JLabel("Email");
		lblEmail.setBounds(11, 93, 46, 25);
		lblEmail.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblEmail);

		lblEnd = new JLabel("End");
		lblEnd.setBounds(11, 123, 35, 25);
		lblEnd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblEnd);

		lblMunicipio = new JLabel("Município");
		lblMunicipio.setBounds(10, 153, 67, 25);
		lblMunicipio.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblMunicipio);

		lblUf = new JLabel("UF");
		lblUf.setBounds(219, 153, 30, 25);
		lblUf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblUf);

		lblCelular = new JLabel("Celular");
		lblCelular.setBounds(315, 153, 46, 25);
		lblCelular.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(lblCelular);

		txtNome = new JFormattedTextField();
		txtNome.setBounds(286, 33, 343, 25);
		txtNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtNome);

		txtRgm = new JFormattedTextField();
		txtRgm.setBounds(65, 33, 114, 25);
		txtRgm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		jpDadosPessoais.add(txtRgm);

		btDPSair = new JButton("");
		btDPSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Fecha a janela quando o botão "SAIR" é clicado
				System.exit(0);
			}
		});
		btDPSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-off-59.png")));
		btDPSair.setBounds(123, 200, 70, 65);
		jpDadosPessoais.add(btDPSair);

		btDPconsultar = new JButton("");
		btDPconsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText());
					// Chama o método ConsultarAluno da classe DAO com o Parametro RGM
					aluno = dao.consultarAluno(rgm);
					txtNome.setText(aluno.getNome());
					txtCpf.setValue(maskCpf.valueToString(aluno.getCpf()));
					txtEnd.setText(aluno.getEndereco());
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					// Armazena o valor retornado pelo DB
					String ufSelect = aluno.getUF();
					// Laço for para verificar a posição do item retornado pelo DB
					for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
						Object item = comboBoxUf.getItemAt(i);
						// Quando o item retornado pelo DB for igual ao item do comboBox, o item é
						// selecionado
						if (item.toString().equals(ufSelect)) {
							comboBoxUf.setSelectedItem(item);
							break;
						}
					}

					txtMunicipio.setValue(aluno.getMunicipio());
					txtCelular.setValue(maskCelular.valueToString(aluno.getCelular()));
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					txtEmail.setValue(aluno.getEmail());

					dao = new AlunoDAO();
					curso = dao.consultarCurso(rgm);

					String cursoSelect = curso.getCurso(); // Armazena o valor retornado pelo DB
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) { // Laço for para verificar a posição do
																				// item retornado pelo DB
						Object item = comboBoxCurso.getItemAt(i);
						if (item.toString().equals(cursoSelect)) { // Quando o item retornado pelo DB for igual ao item
																	// do comboBox, o item é selecionado
							comboBoxCurso.setSelectedItem(item); // Se o item for encontrado, selecione-o
							break;
						}
					}

					String campusSelect = curso.getCampus();
					for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
						Object item = comboBoxCampus.getItemAt(i);
						if (item.toString().equals(campusSelect)) {
							comboBoxCampus.setSelectedItem(item);
							break;
						}
					}

					if (curso.getPeriodo().equals("Matutino")) {
						grupoPeriodo.setSelected(rdbtnMatutino.getModel(), true);
					} else if (curso.getPeriodo().equals("Vespertino")) {
						grupoPeriodo.setSelected(rdbtnVespertino.getModel(), true); // Condições para selecionar o Rádio
																					// correspondente ao BD
					} else if (curso.getPeriodo().equals("Noturno")) {
						grupoPeriodo.setSelected(rdbtnNoturno.getModel(), true);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar");
				}
			}
		});
		btDPconsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-search-60.png")));
		btDPconsultar.setBounds(363, 200, 70, 65);
		jpDadosPessoais.add(btDPconsultar);

		btDPSalvar = new JButton("");
		btDPSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					Notas nota = new Notas();
					// popular o meu objeto
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					// Salva o valor do periodo de acordo com a escolha
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}

					// abrir o BD
					AlunoDAO dao = new AlunoDAO();
					// salvar
					dao.salvar(aluno, curso, nota);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso1");
				} catch (Exception e1) {
					e1.printStackTrace();
					String errorMessage = "Erro na inserção de dados:\n" + e1.getMessage();
					JOptionPane.showMessageDialog(null, errorMessage, "Erro", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btDPSalvar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-save-all-60.png")));
		btDPSalvar.setBounds(203, 200, 70, 65);
		jpDadosPessoais.add(btDPSalvar);

		btDPAlterar = new JButton("");
		btDPAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText()); // popular o meu objeto
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}
					AlunoDAO dao = new AlunoDAO(); // abrir o BD
					dao.atualizar(aluno, curso);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar");
				}
			}
		});
		btDPAlterar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-edit-60.png")));
		btDPAlterar.setBounds(283, 200, 70, 65);
		jpDadosPessoais.add(btDPAlterar);

		btDPExcluir = new JButton("");
		btDPExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText()); // Remover dados dos campos
					dao.excluir(rgm); // Chama o método Excluir
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir");
				}
			}
		});
		btDPExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-delete-60.png")));
		btDPExcluir.setBounds(443, 200, 70, 65);
		jpDadosPessoais.add(btDPExcluir);

		jpCurso = new JPanel();
		tabbedPane.addTab("Curso", null, jpCurso, null);
		jpCurso.setLayout(null);

		lblCurso = new JLabel("Curso");
		lblCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCurso.setBounds(10, 37, 56, 25);
		jpCurso.add(lblCurso);

		lblCampus = new JLabel("Campus");
		lblCampus.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblCampus.setBounds(10, 77, 56, 25);
		jpCurso.add(lblCampus);

		lblPeriodo = new JLabel("Período");
		lblPeriodo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPeriodo.setBounds(10, 117, 56, 25);
		jpCurso.add(lblPeriodo);

		rdbtnMatutino = new JRadioButton("Matutino");
		grupoPeriodo.add(rdbtnMatutino); // Acrescenta o RADIO ao grupo para haver a interação com os outros RADIOS
		rdbtnMatutino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMatutino.setBounds(72, 120, 90, 23);
		jpCurso.add(rdbtnMatutino);

		rdbtnVespertino = new JRadioButton("Vespertino");
		grupoPeriodo.add(rdbtnVespertino); // Acrescenta o RADIO ao grupo para haver a interação com os outros RADIOS
		rdbtnVespertino.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnVespertino.setBounds(165, 120, 101, 23);
		jpCurso.add(rdbtnVespertino);

		rdbtnNoturno = new JRadioButton("Noturno");
		grupoPeriodo.add(rdbtnNoturno); // Acrescenta o RADIO ao grupo para haver a interação com os outros RADIOS
		rdbtnNoturno.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnNoturno.setBounds(275, 120, 90, 23);
		jpCurso.add(rdbtnNoturno);

		comboBoxCampus = new JComboBox();
		comboBoxCampus.setModel(
				new DefaultComboBoxModel(new String[] { "--", "Unicid - Carrão", "Unicid - Cid. Universitaria" }));
		comboBoxCampus.setBounds(76, 80, 323, 22);
		jpCurso.add(comboBoxCampus);

		comboBoxCurso = new JComboBox();
		comboBoxCurso.setModel(
				new DefaultComboBoxModel(new String[] { "--", "Ciencia da Computação", "Medicina", "Direito" }));
		comboBoxCurso.setBounds(76, 40, 323, 22);
		jpCurso.add(comboBoxCurso);

		btCSair = new JButton("");
		btCSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Fecha a janela quando o botão "SAIR" é clicado
			}
		});
		btCSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-off-59.png")));
		btCSair.setBounds(123, 200, 70, 65);
		jpCurso.add(btCSair);

		btCConsultar = new JButton("");
		btCConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText());
					// Chama o método ConsultarAluno da classe DAO com o Parametro RGM
					aluno = dao.consultarAluno(rgm);
					txtNome.setText(aluno.getNome());
					txtCpf.setValue(maskCpf.valueToString(aluno.getCpf()));
					txtEnd.setText(aluno.getEndereco());
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					// Armazena o valor retornado pelo DB
					String ufSelect = aluno.getUF();
					// Laço for para verificar a posição do item retornado pelo DB
					for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
						Object item = comboBoxUf.getItemAt(i);
						// Quando o item retornado pelo DB for igual ao item do comboBox, o item é
						// selecionado
						if (item.toString().equals(ufSelect)) {
							comboBoxUf.setSelectedItem(item);
							break;
						}
					}

					txtMunicipio.setValue(aluno.getMunicipio());
					txtCelular.setValue(maskCelular.valueToString(aluno.getCelular()));
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					txtEmail.setValue(aluno.getEmail());

					dao = new AlunoDAO();
					curso = dao.consultarCurso(rgm);

					String cursoSelect = curso.getCurso(); // Armazena o valor retornado pelo DB
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) { // Laço for para verificar a posição do
																				// item retornado pelo DB
						Object item = comboBoxCurso.getItemAt(i);
						if (item.toString().equals(cursoSelect)) { // Quando o item retornado pelo DB for igual ao item
																	// do comboBox, o item é selecionado
							comboBoxCurso.setSelectedItem(item); // Se o item for encontrado, selecione-o
							break;
						}
					}

					String campusSelect = curso.getCampus();
					for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
						Object item = comboBoxCampus.getItemAt(i);
						if (item.toString().equals(campusSelect)) {
							comboBoxCampus.setSelectedItem(item);
							break;
						}
					}

					if (curso.getPeriodo().equals("Matutino")) {
						grupoPeriodo.setSelected(rdbtnMatutino.getModel(), true);
					} else if (curso.getPeriodo().equals("Vespertino")) {
						grupoPeriodo.setSelected(rdbtnVespertino.getModel(), true); // Condições para selecionar o Rádio
																					// correspondente ao BD
					} else if (curso.getPeriodo().equals("Noturno")) {
						grupoPeriodo.setSelected(rdbtnNoturno.getModel(), true);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.getMessage());
				}
			}
		});
		btCConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-search-60.png")));
		btCConsultar.setBounds(363, 200, 70, 65);
		jpCurso.add(btCConsultar);

		btCSalvar = new JButton("");
		btCSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					Notas nota = new Notas();
					// popular o meu objeto
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					// Salva o valor do periodo de acordo com a escolha
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}

					// abrir o BD
					AlunoDAO dao = new AlunoDAO();
					// salvar
					dao.salvar(aluno, curso, nota);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro na inserção de dados, verifique os dados se estão preenchidos corretamente");
				}
			}
		});
		btCSalvar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-save-all-60.png")));
		btCSalvar.setBounds(203, 200, 70, 65);
		jpCurso.add(btCSalvar);

		btCAlterar = new JButton("");
		btCAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText()); // popular o meu objeto
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}
					AlunoDAO dao = new AlunoDAO(); // abrir o BD
					dao.atualizar(aluno, curso);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao atualizar, verifique se os dados estão inseridos corretamente ou verifique se o banco de dados esá conectado");
				}
			}
		});
		btCAlterar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-edit-60.png")));
		btCAlterar.setBounds(283, 200, 70, 65);
		jpCurso.add(btCAlterar);

		btCExcluir = new JButton("");
		btCExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText()); // Remover dados dos campos
					dao.excluir(rgm); // Chama o método Excluir
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao excluir, verifique se o banco de dados está conectado");
				}
			}
		});
		btCExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-delete-60.png")));
		btCExcluir.setBounds(443, 200, 70, 65);
		jpCurso.add(btCExcluir);

		jpNotaseFaltas = new JPanel();
		tabbedPane.addTab("Notas e Faltas", null, jpNotaseFaltas, null);
		jpNotaseFaltas.setLayout(null);

		lblNFRgm = new JLabel("RGM");
		lblNFRgm.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFRgm.setBounds(10, 31, 56, 20);
		jpNotaseFaltas.add(lblNFRgm);

		txtNFRgm = new JTextField();
		txtNFRgm.setBounds(53, 31, 96, 20);
		jpNotaseFaltas.add(txtNFRgm);
		txtNFRgm.setColumns(10);

		txtNFNome = new JTextField();
		txtNFNome.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNFNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNFNome.setEditable(false);
		txtNFNome.setBounds(174, 31, 225, 20);
		jpNotaseFaltas.add(txtNFNome);
		txtNFNome.setColumns(10);

		lblNFDisciplina = new JLabel("Disciplina");
		lblNFDisciplina.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFDisciplina.setBounds(10, 104, 68, 20);
		jpNotaseFaltas.add(lblNFDisciplina);

		lblNFSemestre = new JLabel("Semestre");
		lblNFSemestre.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFSemestre.setBounds(10, 135, 68, 20);
		jpNotaseFaltas.add(lblNFSemestre);

		comboBoxSemestre = new JComboBox();
		comboBoxSemestre
				.setModel(new DefaultComboBoxModel(new String[] { "--", "1.2022", "2.2022", "1.2023", "2.2023" }));
		comboBoxSemestre.setBounds(87, 135, 84, 22);
		jpNotaseFaltas.add(comboBoxSemestre);

		comboBoxDisciplina = new JComboBox();
		comboBoxDisciplina.setBounds(88, 104, 311, 22);
		jpNotaseFaltas.add(comboBoxDisciplina);

		comboBoxNota = new JComboBox();
		comboBoxNota.setModel(new DefaultComboBoxModel(new String[] { "--", "0,5", "1,0", "1,5", "2,0", "2,5", "3,0",
				"3,5", "4,0", "4,5", "5,0", "5,5", "6,0", "6,5", "7,0", "7,5", "8,0", "8,5", "9,0", "9,5", "10" }));
		comboBoxNota.setBounds(231, 136, 62, 22);
		jpNotaseFaltas.add(comboBoxNota);

		lblNFNota = new JLabel("Nota");
		lblNFNota.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFNota.setBounds(181, 137, 56, 20);
		jpNotaseFaltas.add(lblNFNota);

		lblNFFalta = new JLabel("Faltas");
		lblNFFalta.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNFFalta.setBounds(303, 137, 56, 20);
		jpNotaseFaltas.add(lblNFFalta);

		txtNFFalta = new JTextField();
		txtNFFalta.setBounds(350, 137, 49, 20);
		jpNotaseFaltas.add(txtNFFalta);
		txtNFFalta.setColumns(10);

		txtNFCurso = new JTextField();
		txtNFCurso.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtNFCurso.setEditable(false);
		txtNFCurso.setColumns(10);
		txtNFCurso.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		txtNFCurso.setBounds(10, 67, 389, 26);
		jpNotaseFaltas.add(txtNFCurso);

		btNSair = new JButton("");
		btNSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Fecha a janela quando o botão "SAIR" é clicado
			}
		});
		btNSair.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-off-59.png")));
		btNSair.setBounds(129, 200, 70, 65);
		jpNotaseFaltas.add(btNSair);

		btNConsultar = new JButton("");
		btNConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NotasDAO dao = new NotasDAO();
					int rgm = Integer.parseInt(txtNFRgm.getText());

					aluno = dao.consultarAluno(rgm);
					txtNFNome.setText(aluno.getNome());

					dao = new NotasDAO();
					curso = dao.consultarCurso(rgm);
					txtNFCurso.setText(curso.getCurso());

					String disciplinaMateria = curso.getCurso(); // Armazena o valor retornado pelo DB
					Object item = null;
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
						item = comboBoxCurso.getItemAt(i);
						System.out.println(item);
						if (disciplinaMateria.equals(item.toString())) {
							if (item.toString().equals("Ciencia da Computação")) {
								comboBoxDisciplina.setModel(new DefaultComboBoxModel(
										new String[] { "--", "Estrutura de dados", "Matematica Discreta" }));
							} else if (item.toString().equals("Medicina")) {
								comboBoxDisciplina.setModel(
										new DefaultComboBoxModel(new String[] { "--", "Radiologia", "Fisiologia" }));
							} else if (item.toString().equals("Direito")) {
								comboBoxDisciplina.setModel(new DefaultComboBoxModel(
										new String[] { "--", "Direito Civil", "Direito Trabalhista" }));
							}
							break;
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar");

				}
			}
		});
		btNConsultar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-search-60.png")));
		btNConsultar.setBounds(369, 200, 70, 65);
		jpNotaseFaltas.add(btNConsultar);

		btNSalvar = new JButton("");
		btNSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Notas notas = new Notas();
					notas.setRgm(Integer.parseInt(txtNFRgm.getText()));
					notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
					notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
					notas.setFalta(Integer.parseInt(txtNFFalta.getText()));
					notas.setNota(comboBoxNota.getSelectedItem().toString());
					NotasDAO dao = new NotasDAO();
					dao.salvarNotas(notas);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null,
							"Erro ao salvar, verifique se os dados estão corretos, ou verifique se o banco de dados está conectado");

				}
			}
		});
		btNSalvar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-save-all-60.png")));
		btNSalvar.setBounds(209, 200, 70, 65);
		jpNotaseFaltas.add(btNSalvar);

		btNAlterar = new JButton("");
		btNAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Notas notas = new Notas();
					notas.setRgm(Integer.parseInt(txtNFRgm.getText()));
					notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
					notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
					notas.setFalta(Integer.parseInt(txtNFFalta.getText()));
					notas.setNota(comboBoxNota.getSelectedItem().toString());
					notas.setRgmSemestreDisciplina(notas.getRgm() + notas.getSemestre() + notas.getDisciplina());

					NotasDAO dao = new NotasDAO();
					dao.atualizar(notas);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null,
							"Erro ao alterar, verifique se os dados estão corretos, ou verifique se o banco de dados está conectado");

				}
			}
		});
		btNAlterar.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-edit-60.png")));
		btNAlterar.setBounds(289, 200, 70, 65);
		jpNotaseFaltas.add(btNAlterar);

		btNExcluir = new JButton("");
		btNExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					NotasDAO dao = new NotasDAO();

					int rgm = Integer.parseInt(txtNFRgm.getText()); // Remover dados dos campos
					String disciplina = rgm + comboBoxSemestre.getSelectedItem().toString()
							+ comboBoxDisciplina.getSelectedItem().toString();

					dao.excluir(disciplina); // Chama o método Excluir
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null,
							"Erro ao excluir, verifique se o banco de dados está conectado");

				}
			}
		});
		btNExcluir.setIcon(new ImageIcon(TelaPrincipal.class.getResource("/br/com/menu/view/icons8-delete-60.png")));
		btNExcluir.setBounds(449, 200, 70, 65);
		jpNotaseFaltas.add(btNExcluir);

		jpBoletim = new JPanel();
		tabbedPane.addTab("Boletim", null, jpBoletim, null);
		jpBoletim.setLayout(null);

		txtBoletim = new TextArea();
		txtBoletim.setBounds(10, 74, 604, 192);
		txtBoletim.setEditable(false);
		jpBoletim.add(txtBoletim);

		lblNewLabel = new JLabel("Digite o RGM");
		lblNewLabel.setBounds(10, 11, 104, 14);
		jpBoletim.add(lblNewLabel);

		txtBRgm = new JTextField();
		txtBRgm.setBounds(109, 8, 125, 20);
		jpBoletim.add(txtBRgm);
		txtBRgm.setColumns(10);

		btBConsulta = new JButton("Consultar");
		btBConsulta.setBounds(10, 45, 89, 23);
		btBConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					// Lista para armazenar os dados referentes aos RGM inserido
					List<Notas> boletim = new ArrayList<Notas>();
					// Inicia a conexão com o banco de dados
					NotasDAO dao = new NotasDAO();
					// Variavel para armazenar o Rgm
					int rgm;
					rgm = (Integer.parseInt(txtBRgm.getText()));
					// Método para consultar o nome do aluno
					aluno = dao.consultarAluno(rgm);
					txtBoletim.append("Nome: " + aluno.getNome() + "\n");
					// Abre a conexão novamente
					dao = new NotasDAO();
					// método para consultar o curso
					curso = dao.consultarCurso(rgm);
					txtBoletim.append("Curso: " + curso.getCurso().toString() + "\n" + "----------------------" + "\n");

					dao = new NotasDAO();
					// Instancia o método dao.boletim com os parametros da lista boletim
					boletim = dao.boletim(rgm);
					for (Notas notas : boletim) {

						txtBoletim.append("Semestre: " + notas.getSemestre() + "\n");
						txtBoletim.append("Disciplina: " + notas.getDisciplina() + "\n");
						txtBoletim.append("Falta: " + notas.getFalta() + "\n");
						txtBoletim.append("Nota: " + notas.getNota() + "\n\n ----------------------------------\n");
					}
					JOptionPane.showMessageDialog(null, "As notas foram consultadas");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro na inserção de dados, " + "verifique os dados se estão preenchidos corretamente, "
									+ "ou se o banco de dados está conectado");
				}
			}
		});
		jpBoletim.add(btBConsulta);

		btBLimpa = new JButton("Limpar");
		btBLimpa.setBounds(145, 45, 89, 23);
		btBLimpa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtBoletim.setText(null);
				;
			}
		});
		jpBoletim.add(btBLimpa);

		menuBar = new JMenuBar();
		menuBar.setBounds(0, 0, 664, 22);
		contentPane.add(menuBar);

		menualuno = new JMenu("Aluno");
		menuBar.add(menualuno);

		mntmSalvar = new JMenuItem("Salvar");
		mntmSalvar.setForeground(Color.BLUE);
		mntmSalvar.setBackground(new Color(255, 255, 255));
		mntmSalvar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_DOWN_MASK));
		menualuno.add(mntmSalvar);
		mntmSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Ação ao pressionar o item do menu "Salvar"
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					Notas nota = new Notas();
					// popular o meu objeto
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText());
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					// Salva o valor do periodo de acordo com a escolha
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}

					// abrir o BD
					AlunoDAO dao = new AlunoDAO();
					// salvar
					dao.salvar(aluno, curso, nota);
					JOptionPane.showMessageDialog(null, "Salvo com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro na inserção de dados, verifique os dados se estão preenchidos corretamente, ou se o banco de dados está conectado");
				}
			}
		});

		mntmAlterar = new JMenuItem("Alterar");
		menualuno.add(mntmAlterar);
		mntmAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // Ação ao pressionar o item do menu "Alterar"
				try {
					Aluno aluno = new Aluno();
					Curso curso = new Curso();
					aluno.setRgm(Integer.parseInt(txtRgm.getText()));
					curso.setRgm(Integer.parseInt(txtRgm.getText()));
					aluno.setNome(txtNome.getText());
					aluno.setEmail(txtEmail.getText());
					aluno.setDtaNascimento(txtDtaNascimento.getText());
					aluno.setEndereco(txtEnd.getText()); // popular o meu objeto
					aluno.setCpf(txtCpf.getText());
					aluno.setUF(comboBoxUf.getSelectedItem().toString());
					aluno.setMunicipio(txtMunicipio.getText());
					aluno.setCelular(txtCelular.getText());
					curso.setCampus(comboBoxCampus.getSelectedItem().toString());
					curso.setCurso(comboBoxCurso.getSelectedItem().toString());
					if (rdbtnMatutino.isSelected()) {
						curso.setPeriodo("Matutino");
					} else if (rdbtnVespertino.isSelected()) {
						curso.setPeriodo("Vespertino");
					} else if (rdbtnNoturno.isSelected()) {
						curso.setPeriodo("Noturno");
					}
					AlunoDAO dao = new AlunoDAO(); // abrir o BD
					dao.atualizar(aluno, curso);
					JOptionPane.showMessageDialog(null, "Atualizado com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao atualizar, verifique se os dados estão inseridos corretamente, ou verifique a conexão com o banco de dados");
				}
			}
		});

		mntmConsultar = new JMenuItem("Consultar");
		menualuno.add(mntmConsultar);
		mntmConsultar.addActionListener(new ActionListener() {
			// Consultar aluno usando como parametro o RGM
			public void actionPerformed(ActionEvent e) {
				try {

					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText());
					// Chama o método ConsultarAluno da classe DAO com o Parametro RGM
					aluno = dao.consultarAluno(rgm);
					txtNome.setText(aluno.getNome());
					txtCpf.setValue(maskCpf.valueToString(aluno.getCpf()));
					txtEnd.setText(aluno.getEndereco());
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					// Armazena o valor retornado pelo DB
					String ufSelect = aluno.getUF();
					// Laço for para verificar a posição do item retornado pelo DB
					for (int i = 0; i < comboBoxUf.getItemCount(); i++) {
						Object item = comboBoxUf.getItemAt(i);
						// Quando o item retornado pelo DB for igual ao item do comboBox, o item é
						// selecionado
						if (item.toString().equals(ufSelect)) {
							comboBoxUf.setSelectedItem(item);
							break;
						}
					}

					txtMunicipio.setValue(aluno.getMunicipio());
					txtCelular.setValue(maskCelular.valueToString(aluno.getCelular()));
					txtDtaNascimento.setValue(maskDtaNascimento.valueToString(aluno.getDtaNascimento()));
					txtEmail.setValue(aluno.getEmail());

					dao = new AlunoDAO();
					curso = dao.consultarCurso(rgm);

					String cursoSelect = curso.getCurso(); // Armazena o valor retornado pelo DB
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) { // Laço for para verificar a posição do
																				// item retornado pelo DB
						Object item = comboBoxCurso.getItemAt(i);
						if (item.toString().equals(cursoSelect)) { // Quando o item retornado pelo DB for igual ao item
																	// do comboBox, o item é selecionado
							comboBoxCurso.setSelectedItem(item); // Se o item for encontrado, selecione-o
							break;
						}
					}

					String campusSelect = curso.getCampus();
					for (int i = 0; i < comboBoxCampus.getItemCount(); i++) {
						Object item = comboBoxCampus.getItemAt(i);
						if (item.toString().equals(campusSelect)) {
							comboBoxCampus.setSelectedItem(item);
							break;
						}
					}

					if (curso.getPeriodo().equals("Matutino")) {
						grupoPeriodo.setSelected(rdbtnMatutino.getModel(), true);
					} else if (curso.getPeriodo().equals("Vespertino")) {
						grupoPeriodo.setSelected(rdbtnVespertino.getModel(), true); // Condições para selecionar o Rádio
																					// correspondente ao BD
					} else if (curso.getPeriodo().equals("Noturno")) {
						grupoPeriodo.setSelected(rdbtnNoturno.getModel(), true);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao consultar");
					System.out.println(e1.getMessage());
				}
			}
		});

		mntmExcluir = new JMenuItem("Excluir");
		menualuno.add(mntmExcluir);
		mntmExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) { // excluir aluno
				try {
					AlunoDAO dao = new AlunoDAO();
					int rgm = Integer.parseInt(txtRgm.getText()); // Remover dados dos campos
					dao.excluir(rgm); // Chama o método Excluir
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso");
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, "Erro ao excluir");
				}
			}
		});

		mntmSair = new JMenuItem("Sair");
		mntmSair.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLUE, Color.BLUE, Color.BLUE, Color.BLUE));
		mntmSair.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R, InputEvent.CTRL_DOWN_MASK));
		menualuno.add(mntmSair);
		mntmSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				System.exit(0); // Fecha a janela quando o botão "SAIR" é clicado
			}
		});

		menunotafalta = new JMenu("Notas e Faltas");
		menuBar.add(menunotafalta);

		mntmNFSalvar = new JMenuItem("Salvar");
		menunotafalta.add(mntmNFSalvar);
		mntmNFSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Notas notas = new Notas();
					notas.setRgm(Integer.parseInt(txtNFRgm.getText()));
					notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
					notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
					notas.setFalta(Integer.parseInt(txtNFFalta.getText()));
					notas.setNota(comboBoxNota.getSelectedItem().toString());
					NotasDAO dao = new NotasDAO();
					dao.salvarNotas(notas);
					JOptionPane.showMessageDialog(null, "Salvo com sucesso!");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Erro ao salvar");

				}
			}
		});

		mntmNFAlterar = new JMenuItem("Alterar");
		mntmNFAlterar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_DOWN_MASK));
		menunotafalta.add(mntmNFAlterar);
		mntmNFAlterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					Notas notas = new Notas();
					notas.setRgm(Integer.parseInt(txtNFRgm.getText()));
					notas.setSemestre(comboBoxSemestre.getSelectedItem().toString());
					notas.setDisciplina(comboBoxDisciplina.getSelectedItem().toString());
					notas.setFalta(Integer.parseInt(txtNFFalta.getText()));
					notas.setNota(comboBoxNota.getSelectedItem().toString());
					notas.setRgmSemestreDisciplina(notas.getRgm() + notas.getSemestre() + notas.getDisciplina());

					NotasDAO dao = new NotasDAO();
					dao.atualizar(notas);
					JOptionPane.showMessageDialog(null, "Alterado com sucesso!");

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Erro ao alterar");

				}
			}
		});

		mntmNFExcluir = new JMenuItem("Excluir");
		menunotafalta.add(mntmNFExcluir);
		mntmNFExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					NotasDAO dao = new NotasDAO();

					int rgm = Integer.parseInt(txtNFRgm.getText()); // Remover dados dos campos
					String disciplina = rgm + comboBoxSemestre.getSelectedItem().toString()
							+ comboBoxDisciplina.getSelectedItem().toString();

					dao.excluir(disciplina); // Chama o método Excluir
					JOptionPane.showMessageDialog(null, "Excluido com Sucesso");

					txtNFRgm = null;
					txtNFNome = null;
					txtNFCurso = null;
//					comboBoxNFDisciplina.//

				} catch (Exception e1) {

					JOptionPane.showMessageDialog(null, "Erro ao excluir");

				}
			}
		});

		mntmNFConsultar = new JMenuItem("Consultar");
		menunotafalta.add(mntmNFConsultar);
		mntmNFConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					NotasDAO dao = new NotasDAO();
					int rgm = Integer.parseInt(txtNFRgm.getText());

					aluno = dao.consultarAluno(rgm);
					txtNFNome.setText(aluno.getNome());

					dao = new NotasDAO();
					curso = dao.consultarCurso(rgm);
					txtNFCurso.setText(curso.getCurso());

					String disciplinaMateria = curso.getCurso(); // Armazena o valor retornado pelo DB
					Object item = null;
					for (int i = 0; i < comboBoxCurso.getItemCount(); i++) {
						item = comboBoxCurso.getItemAt(i);
						if (disciplinaMateria.equals(item.toString())) {
							if (item.toString().equals("Ciencia da Computação")) {
								comboBoxDisciplina.setModel(new DefaultComboBoxModel(
										new String[] { "--", "Estrutura de dados", "Matemática Discreta" }));
							} else if (item.toString().equals("Medicina")) {
								comboBoxDisciplina.setModel(
										new DefaultComboBoxModel(new String[] { "--", "Radiologia", "Fisiologia" }));
							} else if (item.toString().equals("Direito")) {
								comboBoxDisciplina.setModel(new DefaultComboBoxModel(
										new String[] { "--", "Direito Civil", "Direito Trabalhista" }));
							}
							break;
						}
					}
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null,
							"Erro ao consultar, verifique se os dados estão corretos, ou verifique a conexão com o banco de dados");

				}
			}
		});

		menuajuda = new JMenu("Ajuda");
		menuBar.add(menuajuda);

		mntmSobre = new JMenuItem("Sobre");
		menuajuda.add(mntmSobre);
		mntmSobre.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] instrucoes = { "Passo 1: Cadastre os dados pessoais do aluno.",
						"Passo 2: Insira o rgm na aba Notas e faltas e Consulte.",
						"Passo 3: Selecione a disciplina, o semestre, a nota e a falta do aluno e salve em seguida.",
						"Passo 4: Na aba Boletim, é possivel verificar todas as notas cadastradas utilizando o rgm na pesquisa." };
				int i = 0;
				int resposta = JOptionPane.YES_OPTION;
				while (i < instrucoes.length && resposta == JOptionPane.YES_OPTION) {
					resposta = JOptionPane.showOptionDialog(null, instrucoes[i], "Instruções",
							JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null,
							new String[] { "Próximo", "Cancelar" }, "Próximo");
					i++;
				}
				if (resposta == JOptionPane.CANCEL_OPTION) {
					JOptionPane.showMessageDialog(null, "Operação cancelada pelo usuário.");
				}
			}
		});

	}
}
