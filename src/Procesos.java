import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JOptionPane;

public class Procesos {
	HashMap<String, ArrayList<String>> paises;
	String countryName;
	String continuar;

	public Procesos() {
		paises = new HashMap<String, ArrayList<String>>();
		iniciar();
	}

	private void iniciar() {
		String menu = "1.Registrar Pais\n2.Registrar Ciudades De Un Pais\n3. Consultar ciudades de un pais\n4. Consultar ciudad\n5. Salir";
		int opc;
		do {
			try {
				opc = Integer.parseInt(JOptionPane.showInputDialog(menu));
			} catch (Exception e) {
				opc = 0;
			}
			Seleccionar(opc);
		} while (opc != 5);
	}

	private void Seleccionar(int opc) {

		switch (opc) {
		case 1:
			RegistrarPais();
			break;
		case 2:
			if (verificarHash(paises)) {
				RegistrarCiudades();
			} else {
				JOptionPane.showMessageDialog(null, "Aun no hay paises registrados");
			}
			break;
		case 3:
			if (verificarHash(paises)) {
				ConsultarPais();
			}else {
				JOptionPane.showMessageDialog(null, "Aun no hay paises registrados");
			}
			break;
		case 4:
			if (verificarHash(paises)) {
				BuscarCiudad();
			}else{
				JOptionPane.showMessageDialog(null, "Aun no hay paises registrados");	
			}
			break;
		case 5:
			JOptionPane.showMessageDialog(null, "Hasta la proxima");
			break;

		default:
			JOptionPane.showMessageDialog(null, "Ingresa un dato correcto");
			break;
		}
	}
boolean is = false;
	private void BuscarCiudad() {
		countryName = JOptionPane.showInputDialog("ingresa la ciudad a buscar");
		for (String a : paises.keySet()) {
			for (int i = 0; i < paises.get(a).size(); i++) {
				if(paises.get(a).get(i).equalsIgnoreCase(countryName)) {
					is = true;
					JOptionPane.showMessageDialog(null, "Ciudad encontrada " + countryName + " se encuentra en " + a);
				}
			}
		}
		if(!is) {
			JOptionPane.showMessageDialog(null, "No habia esta ciudad en ningun pais");
		}
		
	}

	private void ConsultarPais() {
		countryName = JOptionPane.showInputDialog("Ingrese el nombre del pais a buscar");
		if (countryName == null || !paises.containsKey(countryName)) {
			JOptionPane.showInternalMessageDialog(null, "No hay paises con este nombre");
		} else {

			for (String a : paises.keySet()) {
				if (a.equalsIgnoreCase(countryName)) {
					for (int i = 0; i < paises.get(a).size(); i++) {
						System.out.println(paises.get(a).get(i));
					}
				}
			}
		}
	}

	private void RegistrarCiudades() {
		countryName = JOptionPane.showInputDialog("Ingrese el nombre del pais para registrar sus ciudades");
		for (String a : paises.keySet()) {
			if (a.equalsIgnoreCase(countryName)) {
				do {
					paises.get(a)
							.add(JOptionPane.showInputDialog("ingrese el nombre de la ciudad para ingresar en " + a));
					continuar = JOptionPane.showInputDialog("Desea Registrar otra ciudad?");
				} while (continuar.equalsIgnoreCase("si"));
				break;
			}
		}

	}

	private void RegistrarPais() {
		countryName = JOptionPane.showInputDialog("Ingrese el nombre del pais");
		if (countryName == null || paises.containsKey(countryName)) {
			JOptionPane.showInternalMessageDialog(null, "NO SE PUDO HACER EL REGISTRO");
		} else {
			paises.put(countryName, new ArrayList<String>());
		}
	}

	private boolean verificarHash(HashMap<String, ArrayList<String>> a) {
		return !a.isEmpty();
	}
}
