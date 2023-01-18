import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author MrAndrewlol
 * @author José Prince
 */
public class Radio implements IRadio {


	boolean encendidoapagado;
	String Frequence;
	double FMActualStation;
	int AMActualStation;
	int[] listasaveAM = new int[12];
	double[] listasaveFM = new double[12];
	


	public Radio(){
		encendidoapagado = false;
		Frequence = "";
		FMActualStation = 87.9;
		AMActualStation = 530;
		listasaveAM[0] = 1;
		listasaveFM[0] = 1;
		
		
	}


	public Radio(String Frequence, boolean encendidoapagado, double FMActualStation, int AMActualStation, int[] listasaveAM, double[] listasaveFM){
		this.encendidoapagado = encendidoapagado;
		this.Frequence = Frequence;
		this.FMActualStation = FMActualStation;
		this.AMActualStation = AMActualStation;
		this.listasaveAM = listasaveAM;
		this.listasaveFM = listasaveFM;


	}


	
	/** 
	 * @return boolean
	 */
	public boolean isEncendidoapagado() {
		return this.encendidoapagado;
	}

	
	/** 
	 * @return boolean
	 */
	public boolean getEncendidoapagado() {
		return this.encendidoapagado;
	}

	
	/** 
	 * @param encendidoapagado encendidoapagado to set
	 */
	public void setEncendidoapagado(boolean encendidoapagado) {
		this.encendidoapagado = encendidoapagado;
	}

	
	/** 
	 * @return String
	 */
	public String getFrequence() {
		return this.Frequence;
	}

	
	/** 
	 * @return int[]
	 */
	public int[] getListasaveAM() {
		return this.listasaveAM;
	}

	
	/** 
	 * @param listasaveAM listasaveAM to set
	 */
	public void setListasaveAM(int[] listasaveAM) {
		this.listasaveAM = listasaveAM;
	}

	
	/** 
	 * @return double[]
	 */
	public double[] getListasaveFM() {
		return this.listasaveFM;
	}

	
	/** 
	 * @param listasaveFM listasaveFM to set
	 */
	public void setListasaveFM(double[] listasaveFM) {
		this.listasaveFM = listasaveFM;
	}

	
	
	/**
	 * Enciende la radio
	 */
	public void on(){
		setEncendidoapagado(true);
		
	}
	
	/**
	 * Apaga la radio
	 */
	public void off(){
		setEncendidoapagado(false);

		

	}
	
	/***
	 * Este metodo nos indica si la radio esta encendida o apagada
	 * @return true si la radio esta encendida y false cuando la radio este apagada
	 */
	public boolean isOn(){

		boolean estado;

		estado = getEncendidoapagado();

		return estado; 
		
	}
	
	/***
	 * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
	 * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
	 */
	public void setFrequence(String freq) throws Exception{

			switch(freq){
				case "AM":{
					this.Frequence = "AM";
					setAMActualStation(530);
					break;
				}
	
				case "FM":{
					this.Frequence = "FM";
					setFMActualStation(87.9);
					break;
				}
	
				default:{
					freq = getFrequence() ;
					break;
				}
			}
	}

	/**
	 * Cambia la emisora que se esta escuchando por la emisora siguiente
	 */
	public void Forward(){
		switch(getFrequence()){
			case "AM":{
				if (getAMActualStation() < 1610){
					AMActualStation = getAMActualStation() + 10;
					setAMActualStation(AMActualStation);
				}
				else{
					setAMActualStation(530);
				}

			}


			case "FM":{
				if (getFMActualStation() < 107.9){
					FMActualStation = getFMActualStation() + 0.2;
					BigDecimal bd = new BigDecimal(FMActualStation).setScale(2, RoundingMode.HALF_UP);
					double FMActualStation2 = bd.doubleValue();
					setFMActualStation(FMActualStation2);
				}
				else{
					setFMActualStation(87.9);
				}

			}
		}
	}
	
	/**
	 * Cambia la emisora que se esta escuchando por la emisora anterior
	 */
	public void Backward(){
		switch(getFrequence()){
			case "AM":{
				if (getAMActualStation() > 530){
					AMActualStation = getAMActualStation() - 10;
					setAMActualStation(AMActualStation);
				}
				else{
					setAMActualStation(1610);
				}
			}


			case "FM":{
				if (getFMActualStation() > 87.9){
					FMActualStation = getFMActualStation() - 0.2;
					BigDecimal bd = new BigDecimal(FMActualStation).setScale(2, RoundingMode.HALF_UP);
					double FMActualStation2 = bd.doubleValue();
					setFMActualStation(FMActualStation2);
				}
				else{
					setFMActualStation(107.9);
				}

			}
		}

	}
	
	
	/** 
	 * @return double
	 */
	public double getFMActualStation(){
		return this.FMActualStation;}
	
	
	/** 
	 * @return int
	 */
	public int getAMActualStation(){
		return this.AMActualStation;}
	
	
	/** 
	 * @param actualStation actualStation to set
	 */
	//Regresa el la estacion a FM
	public void setFMActualStation(double actualStation){
		this.FMActualStation = actualStation;

	}
	
	
	/** 
	 * @param actualStation actualStation to set
	 */
	//Regresa la estacion a AM con frecuencia
	public void setAMActualStation(int actualStation){
		this.AMActualStation = actualStation;

	}

	
	
	
	/** 
	 * @param actualStation
	 * @param slot
	 * Guarda la emisora FM indicada
	 */
	public void saveFMStation(double actualStation, int slot){
		listasaveFM[slot] = actualStation;
		
		

	}
	
	
	/** 
	 * @param actualStation
	 * @param slot
	 * Guarda la emisora AM indicada
	 */
	public void saveAMStation(int actualStation, int slot){
		listasaveAM[slot] = actualStation;

	}
	
	
	/** 
	 * @param slot
	 * @return double
	 * Obtiene la emisora guardada en el espacio seleccionado
	 */
	public double getFMSlot(int slot){
		try {
			if (listasaveFM[slot-1] < 87.9 || listasaveFM[slot-1] > 107.9){
				setFMActualStation(87.9);
			}
			setFMActualStation(listasaveFM[slot-1]);
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveFM[slot-1];

	}
	
	
	/** 
	 * @param slot
	 * @return int
	 * Obtiene la emisora guardada en el espacio seleccionado
	 */
	public int getAMSlot(int slot){
		try {
			if (listasaveAM[slot-1] < 530 || listasaveAM[slot-1] > 1610){
				setAMActualStation(530);
			} else{
				setAMActualStation(listasaveAM[slot-1]);
			}
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveAM[slot-1];
	}
}


    
