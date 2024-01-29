package br.com.menu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CadastroNotasView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void cadNotasView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroNotasView frame = new CadastroNotasView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
