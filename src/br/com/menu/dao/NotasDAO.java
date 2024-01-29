package br.com.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.menu.model.Aluno;
import br.com.menu.model.Curso;
import br.com.menu.model.Notas;
import br.com.menu.util.ConnectionFactory;



public class NotasDAO {
	//Abre conexão
	private Connection conn; 
	//Permite Ações no DB
	private PreparedStatement ps;  
	//Cria tabela
	private ResultSet rs;  
	private Aluno alunoConsulta;
	private Curso cursoConsulta;
	private String unescape(String value) {
	    return value.replace("''", "'");
	}
	
	//throws Exeption para dizer ao programa que não se trata erros nessa classe
	public NotasDAO() throws Exception {    
		try {							
			// chama a classe ConnectionFactory e estabele uma conexão
			this.conn = ConnectionFactory.getConnection();
			
		} catch (Exception e) {
			//Caso o programa reporte algum erro na função anterior, manda a mensagem de erro
			throw new Exception("erro, verifique a conexão com o banco de dados \n");  
		}
	}
	
	//Método utilizado para realizar a consulta do nome do aluno
	public Aluno consultarAluno(int rgm) throws Exception {
		try {
			//Query utilizada para fazer a consulta do nome do aluno
			String SQL = ("SELECT nome FROM tbaluno WHERE rgm=?");
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			
			//Armazena o nome caso a consulta retornar algum valor
			if(rs.next()) {
				String nome = unescape(rs.getString("nome"));
				alunoConsulta = new Aluno(rgm, nome);
			} 
			
			//Retorna o objeto populado
			return alunoConsulta;
		}catch(Exception e) {
			throw new Exception("Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	//Método utilizado para realizar a consulta do curso
	public Curso consultarCurso(int rgm) throws Exception {
		try {
			//Query utilizada para fazer a consulta do nome do aluno
			String SQL1 = ("SELECT curso FROM tbcurso WHERE rgm=?");
			ps = conn.prepareStatement(SQL1);
			ps.setInt(1,  rgm);
			rs = ps.executeQuery();
			
			//Armazena o nome caso a consulta retornar algum valor
			if(rs.next()) {
				String curso = unescape(rs.getString("curso"));
				cursoConsulta = new Curso(rgm, curso);
			}
			//Retorna o objeto populado
			return cursoConsulta;
		} catch(Exception e ) {
			throw new Exception("Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// método de excluir
	public void excluir(String disciplina) throws Exception {		
		//caso o valor do item disciplina seja enviado como nulo, identifica como erro
		if (disciplina == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			//Query para excluir a nota correpondente ao Rgm, Semestre e a Disciplina
			String SQL = "DELETE FROM tbnota"
						+ " WHERE rgmSemestreDisciplina=?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, disciplina);
			ps.executeUpdate();
			
			} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados ");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// método de atualizar
	public void atualizar(Notas notas) throws Exception {  
		try {
			//Query para update de dados no bd 
			String SQL = "UPDATE "				
					+ "tbnota SET "
					+ "rgm=?, semestre=?, "
					+ "disciplina=?, falta=?, "
					+ "nota=? "
					+ "WHERE rgmSemestreDisciplina=?";
			ps = conn.prepareStatement(SQL);			
			ps.setInt(1, notas.getRgm());
			ps.setString(2, notas.getSemestre());
			ps.setString(3, notas.getDisciplina());
			ps.setInt(4, notas.getFalta());
			ps.setString(5, notas.getNota());
			ps.setString(6, notas.getRgmSemestreDisciplina());
			//Realiza o UPDATE no banco de dados
			ps.executeUpdate();			
			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
	//Lista com os itens do objeto Notas
	public List <Notas> boletim(int rgm) throws Exception {	 
		List <Notas> boletim = new ArrayList<>();
		try {	
			//Query para puxar os dados com o respectivo RGM informado
			String SQL = "SELECT semestre, "
					+ "disciplina, falta, nota "
					+ "FROM tbnota "
					+ "WHERE rgm = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			
			//enquanto ouver uma próxima linha populada, a o método armazena na lista
			while (rs.next()) {
				Notas notas = new Notas();
				notas.setSemestre(unescape(rs.getString("semestre")));
				notas.setDisciplina(unescape(rs.getString("disciplina")));
				notas.setFalta(rs.getInt("falta"));
				notas.setNota(rs.getString("nota"));
				//retorna a lista boletim populada
				boletim.add(notas);
				
			}
		} catch (Exception e1) {
			throw new Exception("Erro ao consultar dados");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
		return boletim;
	}
	
	public void salvarNotas(Notas notas) throws Exception {
		try {		
			//Caso algum dos parametros seja enviado como nulo, o programa identifica como erro.
			if (notas.getDisciplina() == "--" || notas.getSemestre() == "--" || notas.getRgm() == 0 || notas.getNota() == "--")
				throw new Exception("Verifique os valores inseridos");
			//Query para salvar as notas
			String SQL = "INSERT INTO tbnota "
					+ "(rgm, semestre, "
					+ "disciplina, falta, "
					+ "nota, rgmSemestreDisciplina) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, notas.getRgm());
			ps.setString(2, notas.getSemestre());
			ps.setString(3, notas.getDisciplina());
			ps.setInt(4, notas.getFalta());
			ps.setString(5, notas.getNota());
			ps.setString(6, notas.getRgm() + notas.getSemestre() + notas.getDisciplina());
			
			//Realiza o Salvar no banco de dados
			ps.executeUpdate();			
		} catch (SQLException sqle) {
			 //Mostra o erro identificado pelo bd
			throw new Exception("Erro ao inserir dados, verifique se este aluno já teve a sua nota inserida "); 
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
}
