package br.com.menu.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import br.com.menu.model.Aluno;
import br.com.menu.model.Curso;
import br.com.menu.model.Notas;
import br.com.menu.util.ConnectionFactory;

public class AlunoDAO {
	
	private Connection conn; //Abre conexão
	private PreparedStatement ps;  //Permite Ações no DB
	private ResultSet rs;  //Cria tabela
	private Aluno alunoConsulta;
	private Curso cursoConsulta;
	
	private String unescape(String value) {
	    return value.replace("''", "'");
	}


	//throws Exeption para dizer ao programa que não se trata erros nessa classe
	public AlunoDAO() throws Exception {    
			try {							
				// chama a classe ConnectionFactory e estabele uma conexão
				this.conn = ConnectionFactory.getConnection();
			} catch (Exception e) {
				throw new Exception("erro na conexão de dados \n");
			}
	}

	// método de salvar dados do aluno
	public void salvar(Aluno aluno, Curso curso, Notas notas) throws Exception {   		
		//Verifica se os dados de alunos estão vazios.
		if (aluno.getRgm() == 0)                                 
				throw new Exception("O valor passado nao pode ser nulo");
		try {		
			//Código para inserção de valores na tabela TBALUNO do bd
			//Cada interrogação corresponde a uma coluna da tabela
			//sendo ordenada de acordo com a sua posição
			String SQL = "INSERT INTO "					
					+ "tbaluno (rgm, "
					+ "nome, cpf, endereco, uf, "
					+ "municipio, celular,"
					+ "dtaNascimento, "
					+ "email) "										 
					+ "values (?, ?, ?, ?, ?, ?, ?, ?, ?)";			
			//Permite a execução do código SQL
			ps = conn.prepareStatement(SQL);						
			ps.setInt(1, aluno.getRgm());
			ps.setString(2, aluno.getNome());
			ps.setString(3, aluno.getCpf());
			ps.setString(4, aluno.getEndereco());
			ps.setString(5, aluno.getUF());
			ps.setString(6, aluno.getMunicipio());
			ps.setString(7, aluno.getCelular());
			ps.setString(8, aluno.getDtaNascimento());
			ps.setString(9, aluno.getEmail());		
			//Realiza o Salvar no banco de dados
			ps.executeUpdate();			
				
			//Faz uma nova inserção no SQL para 
			//inserir os dados na tabela TBCURSO
			String SQL2 = "INSERT INTO "			
					+ "tbcurso (rgm, curso, "		
					+ "campus, "
					+ "periodo)"               
					+ "values (?, ?, ?, ?)";
			ps = conn.prepareStatement(SQL2);
			ps.setInt(1, curso.getRgm());
			ps.setString(2, curso.getCurso());
			ps.setString(3, curso.getCampus());
			ps.setString(4, curso.getPeriodo());
			//Realiza o Salvar no banco de dados
			ps.executeUpdate();			
			
		} catch (SQLException sqle) {
			//Mostra o erro identificado pelo bd
			throw new Exception("Erro ao inserir dados ");  
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	// método de atualizar
	public void atualizar(Aluno aluno, Curso curso) throws Exception {  	
		if (aluno == null || curso == null)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			//Código para update de dados no bd 
			String SQL = "UPDATE "				
					+ "tbaluno SET "
					+ "nome=?, cpf=?, endereco=?, uf=?, "
					+ "municipio=?, celular=?,"
					+ "dtaNascimento=?, "
					+ "email=? "
					+ "WHERE rgm=?";
			ps = conn.prepareStatement(SQL);			
			ps.setString(1, aluno.getNome());
			ps.setString(2, aluno.getCpf());
			ps.setString(3, aluno.getEndereco());
			ps.setString(4, aluno.getUF());
			ps.setString(5, aluno.getMunicipio());
			ps.setString(6, aluno.getCelular());
			ps.setString(7, aluno.getDtaNascimento());
			ps.setString(8, aluno.getEmail());		
			ps.setInt(9, aluno.getRgm());
			//Realiza o UPDATE no banco de dados
			ps.executeUpdate();			
			
			//Faz uma nova inserção no SQL para
			//inserir os dados na tabela TBCURSO
			String SQL2 = "UPDATE "					 
					+ "tbcurso SET "
					+ "curso=?, "	
					+ "campus=?, "
					+ "periodo=? "   
					+ "WHERE rgm=?";  
			ps = conn.prepareStatement(SQL2);
			ps.setString(1, curso.getCurso());
			ps.setString(2, curso.getCampus());
			ps.setString(3, curso.getPeriodo());
			ps.setInt(4, curso.getRgm());
			//Realiza o UPDATE no banco de dados
			ps.executeUpdate();			
		} catch (SQLException sqle) {
			throw new Exception("Erro ao alterar dados");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	//Método para consultar aluno, usando o parametro rgm inserido pelo usuario
	public Aluno consultarAluno(int rgm) throws Exception {
		try {
			//Query para realizar a consulta da linha inteira que contem o parametro inserido
			String SQL = ("SELECT * FROM tbaluno WHERE rgm=?");
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			
			//Enquanto houver um valor na próxima coluna o programa armazena nas seguintes variaveis
			if(rs.next()) {
			
				String nome = unescape(rs.getString("nome"));
				String cpf = rs.getString("cpf");
				String endereco = unescape(rs.getString("endereco"));
				String uf = rs.getString("uf");
				String municipio = unescape(rs.getString("municipio"));
				String celular = rs.getString("celular");
				String dtaNascimento = rs.getString("dtaNascimento");
				String email = unescape(rs.getString("email"));

				alunoConsulta = new Aluno(rgm, nome, cpf, endereco, uf, municipio, celular, dtaNascimento, email);
			}
			//Retorna o construtor com os parametros populado
			return alunoConsulta;
		}catch(Exception e) {
			throw new Exception("Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	//Método para consultar aluno, usando o parametro rgm inserido pelo usuario
	public Curso consultarCurso(int rgm) throws Exception {
		try {
			//Query para realizar a consulta da linha inteira que contem o parametro inserido
			String Query = ("SELECT * FROM tbcurso WHERE rgm=?");
			ps = conn.prepareStatement(Query);
			ps.setInt(1, rgm);
			rs = ps.executeQuery();
			
			//Enquanto houver um valor na próxima coluna o programa armazena nas seguintes variaveis
			if(rs.next()) {
				String curso = unescape(rs.getString("curso"));
				String campus = unescape(rs.getString("campus"));
				String periodo = rs.getString("periodo");
				cursoConsulta = new Curso (rgm, curso, campus, periodo);
			} 
			//Retorna o construtor com os parametros populado
			return cursoConsulta;
		} catch (Exception e) {
			throw new Exception("Erro ao consultar");
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}	
	
	// método exclui os dados de todas as tabelas que contenham o mesmo rgm informado
	public void excluir(int rgm) throws Exception {		
		if (rgm == 0)
			throw new Exception("O valor passado nao pode ser nulo");
		try {
			//Query para excluir da tabela usando como parametro o rgm inserido
			String SQL = "DELETE FROM tbaluno"
						+ " WHERE rgm=?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
			String SQL2 = "DELETE FROM tbcurso"
						+ " WHERE rgm=?";
			ps = conn.prepareStatement(SQL2);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			
			String SQL3 = "DELETE FROM tbnota"
					+" WHERE rgm=?";
			ps = conn.prepareStatement(SQL3);
			ps.setInt(1, rgm);
			ps.executeUpdate();
			} catch (SQLException sqle) {
			throw new Exception("Erro ao excluir dados " );
		} finally {
			ConnectionFactory.closeConnection(conn, ps);
		}
	}
	
	
}
