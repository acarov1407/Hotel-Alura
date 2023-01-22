package com.alura.reservaciones.utilities;

import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;

import com.alura.reservaciones.model.Guest;

public class MyGUI {
	private JFrame frame;
	
	public MyGUI(JFrame frame) {
		this.frame = frame;
	}
	
	public boolean validateGuestForm(Guest guest) {

		boolean isValidName = MyRegex.match(guest.getName(), MyRegex.nameRegex);
		boolean isValidSurname = MyRegex.match(guest.getSurname(), MyRegex.nameRegex);

		Date today = new Date();
		boolean isValidBirthDay = MyDate.calculateYearsBetween(guest.getBirthDay(), today) >= 18
				&& MyDate.calculateYearsBetween(guest.getBirthDay(), today) <= 110;

		boolean isValidPhoneNumber = MyRegex.match(guest.getPhoneNumber(), MyRegex.phoneNumberRegex);

		if (!isValidName) {
			showMessage("Ingrese un nombre válido");
			return false;
		}

		if (!isValidSurname) {
			showMessage("Ingrese un apellido válido");
			return false;
		}

		if (!isValidBirthDay) {
			showMessage("Ingrese una fecha de nacimiento válida");
			return false;
		}

		if (!isValidPhoneNumber) {
			showMessage("Ingrese un numero de telefono válido");
			return false;
		}

		return true;
	}

	public int getSelectedRow(JTable table) {

		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {
			JOptionPane.showMessageDialog(this.frame, "Debe seleccionar una fila");
			throw new RuntimeException("Ninguna fila seleccionada");
		}

		return selectedRow;

	}
	
	public void showEditMessage(boolean isEdited) {
		
		if (isEdited) {
			showMessage("Se han guardado los cambios correctamente");
		}else {
			showMessage("No se han podido guardar los cambios");
		}
	}
	
	public void showDeleteBookingMessage(boolean isDeleted) {
		
		if (isDeleted) {
			showMessage("Reserva eliminada correctamente");
		}else {
			showMessage("Ha ocurrido un error al intentar eliminar esta reserva");
		}
	}

	public void showMessage(String msg) {
		JOptionPane.showMessageDialog(this.frame, msg);
	}

	public boolean showConfirmDialog(String msg) {
		int result = JOptionPane.showConfirmDialog(this.frame, msg, "Confirmar", JOptionPane.YES_NO_OPTION,
				JOptionPane.INFORMATION_MESSAGE);
		return result == 0;
	}
}
