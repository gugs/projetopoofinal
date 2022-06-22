package agenda2.application;

import javax.swing.SwingUtilities;

import agenda2.gui.TelaContato;

public class Programa {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				new TelaContato();
			}
		});
	}

}
