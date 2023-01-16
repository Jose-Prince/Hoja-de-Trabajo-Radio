
/**
 * 
 */

/**
 * @author MrAndrewlol
 *
 */
public class Radio implements IRadio {

	boolean encendidoapagado;
	String freq;
	double FMActualStation;
	int AMActualStation;
	


	public Radio(){
		encendidoapagado = false;
		freq = "AM";
		FMActualStation = 87.9;
		AMActualStation = 530;
	}


	public Radio(String freq, boolean encendidoapagado, double FMActualStation, int AMActualStation){
		this.encendidoapagado = encendidoapagado;
		this.freq = freq;
		this.FMActualStation = FMActualStation;
		this.AMActualStation = AMActualStation;

	}
	
	
	
	public void on(){
		this.encendidoapagado = true;
		
	}
	

	public void off(){
		this.encendidoapagado = false;

		

	}
	
	/***
	 * Este metodo nos indica si la radio esta encendida o apagada
	 * @return true si la radio esta encendida y false cuando la radio este apagada
	 */
	public boolean isOn(){

		boolean estado;

		estado = this.encendidoapagado;
		
		
		
		
		return estado; 
		
	}
	
	/***
	 * Este metodo nos ayuda a establecer la frecuencia, recibe un parametro llamado freq que puede "AM" o "FM"
	 * @param freq La frecuencia la cual puede ser AM o FM, de lo contrario error.
	 */
	public void setFrequence(String freq) throws Exception{
		

		switch(freq){
			case "AM":{
				freq = "Se ha cambiado a frequencia AM Actualmente esta en la frecuencia 530";




			}

			case "FM":{
				freq = "FM";
				FMActualStation = 87.9;



			}

			default:{
				freq = "Error regresando a la frecuencia actual " + this.freq ;
			}

		


		}
		

		
	
		
	}


	
	public String getFrequence(){
		return null;
		
	}
	
	public void Forward(){
		
	}
	
	public void Backward(){}
	
	public double getFMActualStation(){
		return AMActualStation;}
	
	public int getAMActualStation(){
		return AMActualStation;}
	
	//Regresa el la estacion a FM
	public void setFMActualStation(double actualStation){

	}
	
	//Regresa la estacion a AM
	public void setAMActualStation(int actualStation){

	}

	
	
	public void saveFMStation(double actualStation, int slot){

	}
	
	public void saveAMStation(int actualStation, int slot){

	}
	
	public double getFMSlot(int slot){
		return slot;

	}
	
	public int getAMSlot(int slot){
		return slot;
		
	}
}


    
    

