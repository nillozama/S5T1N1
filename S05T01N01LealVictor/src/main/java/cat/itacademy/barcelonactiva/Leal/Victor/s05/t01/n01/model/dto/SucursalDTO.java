package cat.itacademy.barcelonactiva.Leal.Victor.s05.t01.n01.model.dto;

import java.util.Arrays;
import java.util.List;

public class SucursalDTO {

	private int pk_SucursalID;
	private String nomSucursal;
	private String paisSucursal;
	private String tipusSucursal;
	private List<String> europeanCountryList=Arrays.asList("ALEMANIA", "BELGICA", "CROACIA", "DINAMARCA", "ESPAÑA", "FRANCIA",
			"IRLANDA", "LETONIA", "LUXEBURGO", "PAISES BAJOS", "SUECIA",
			"BULGARIA", "ESLOVENIA", "ESTONIA", "GRECIA", "MALTA", "POLONIA", "REPUBLICA CHECA",
			"AUSTRIA", "CHIPRE", "ESLOVENIA", "FINLANDIA", "HUNGRIA", "ITALIA", "LITUANIA", "PORTUGAL", "RUMANIA");
	
	public SucursalDTO () {
		
	}
	
	public SucursalDTO(int pk_SucursalID, String nomSucursal, String paisSucursal) {
		super();
		this.pk_SucursalID = pk_SucursalID;
		this.nomSucursal = nomSucursal;
		this.paisSucursal = paisSucursal;
		tipusSucursal = getTipusSucursal();
	}

	public int getPk_SucursalID() {
		return pk_SucursalID;
	}
	public void setPk_SucursalID(int pk_SucursalID) {
		this.pk_SucursalID = pk_SucursalID;
	}
	public String getNomSucursal() {
		return nomSucursal;
	}
	public void setNomSucursal(String nomSucursal) {
		this.nomSucursal = nomSucursal;
	}
	public String getPaisSucursal() {
		return paisSucursal;
	}
	public void setPaisSucursal(String paisSucursal) {
		this.paisSucursal = paisSucursal;
	}
	public String getTipusSucursal() {

		return europeanCountryList.contains(paisSucursal.toUpperCase())?"EU":"Not EU";
	}
	
	
	@Override
	public String toString() {
		return "SucursalDTO [pk_SucursalID=" + pk_SucursalID + ", nomSucursal=" + nomSucursal + ", paisSucursal="
				+ paisSucursal + ", tipusSucursal=" + tipusSucursal + "]";
	}
}
