package br.com.menu.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class ConsultaView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void consView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConsultaView frame = new ConsultaView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
