package br.com.menu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CadastroAlunoView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

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
	
}
