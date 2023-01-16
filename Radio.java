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
	int[] listasaveAM = new int[11];
	double[] listasaveFM = new double[11];
	


	public Radio(){
		encendidoapagado = false;
		freq = "AM";
		FMActualStation = 87.9;
		AMActualStation = 530;
		listasaveAM[0] = 1;
		listasaveFM[0] = 1;
		
		
	}


	public Radio(String freq, boolean encendidoapagado, double FMActualStation, int AMActualStation, int[] listasaveAM, double[] listasaveFM){
		this.encendidoapagado = encendidoapagado;
		this.freq = freq;
		this.FMActualStation = FMActualStation;
		this.AMActualStation = AMActualStation;
		this.listasaveAM = listasaveAM;
		this.listasaveFM = listasaveFM;


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
				freq = "AM";
				AMActualStation = 570;

				break;




			}

			case "FM":{
				freq = "FM";
				FMActualStation = 87.9;

				break;



			}

			default:{
				freq = this.freq ;
				break;
			}

		


		}
		

		
	
		
	}


	
	public String getFrequence(){
		return this.freq;
		
	}
	
	public void Forward(){
		switch(this.freq){
			case "AM":{
				if (AMActualStation < 1610){
					FMActualStation = FMActualStation + 10;

				}
				else{
					System.out.println("Hasta el fondo Mijin digo digo alcanzo al tope de frecuencia de radio");
				}

			}


			case "FM":{
				if (FMActualStation < 107.9){
					FMActualStation = FMActualStation + 0.2;

				}
				else{
					System.out.println("Hasta el fondo Mijin digo digo alcanzo al tope de frecuencia de radio");
				}

			}
		}
	}
	
	public void Backward(){
		switch(this.freq){
			case "AM":{
				if (AMActualStation > 530){
					FMActualStation = FMActualStation - 10;

				}
				else{
					System.out.println("Hasta el fondo Mijin digo digo alcanzo al tope de frecuencia de radio");
				}

			}


			case "FM":{
				if (FMActualStation > 87.9){
					FMActualStation = FMActualStation - 0.2;

				}
				else{
					System.out.println("Hasta el fondo Mijin digo digo alcanzo al tope de frecuencia de radio");
				}

			}
		}

	}
	
	public double getFMActualStation(){
		return this.FMActualStation;}
	
	public int getAMActualStation(){
		return this.AMActualStation;}
	
	//Regresa el la estacion a FM
	public void setFMActualStation(double actualStation){
		this.FMActualStation = actualStation;

	}
	
	//Regresa la estacion a AM con frecuencia
	public void setAMActualStation(int actualStation){
		this.AMActualStation = actualStation;

	}

	
	
	public void saveFMStation(double actualStation, int slot){
		listasaveFM[slot] = actualStation;
		
		

	}
	
	public void saveAMStation(int actualStation, int slot){
		listasaveAM[slot] = actualStation;

	}
	
	public double getFMSlot(int slot){
		try {
			System.out.println(listasaveFM[slot]);
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveFM[slot];

	}
	
	public int getAMSlot(int slot){
		try {
			System.out.println(listasaveAM[slot]);
			
		} catch (Exception e) {
			System.out.println("Espacio disponible.");
		}
		return listasaveAM[slot];

		
	}
}


    
