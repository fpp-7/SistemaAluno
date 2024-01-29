package br.com.menu.view;

import java.awt.EventQueue;
import javax.swing.JFrame;

public class BoletimView extends JFrame{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void boletimView() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BoletimView frame = new BoletimView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
}
