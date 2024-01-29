package br.com.menu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class CadastroCursoView extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void CadCurView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CadastroCursoView frame = new CadastroCursoView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
