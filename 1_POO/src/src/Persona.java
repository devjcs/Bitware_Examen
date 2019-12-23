package src;

public class Persona {
	
	//-----------------------Variables----------------------------------------------//
	
	private String nombre;
	private int edad;
	private String nss;
	private char sexo;
	private float peso;
	private float altura;
	
	
	//-----------------------Constante----------------------------------------------//
	
	private final static char SEXO_CONST = 'H';
	private final static int Sobrepeso = 1;
	private final static int Peso_normal = 0;
	private final static int Falta_de_peso = -1;
	
	
	//-----------------------Contructores-------------------------------------------//
	
    //----Constructor por defecto---------------------------------------------------//
	
    public Persona() {
        this("", 0, SEXO_CONST, 0, 0);
        generaNSS();
        comprobarSexo();
    }
	
    //----Constructor con el nombre, edad y sexo, el resto por defecto--------------//
    
    public Persona(String nombre, int edad, char sexo) {
    	this(nombre, edad, sexo, 0, 0);
    	generaNSS();
    	comprobarSexo();
    }
    
    //----Constructor con todos los atributos como parámetro------------------------//
	public Persona(String nombre, int edad,  char sexo, float peso, float altura) {
		this.nombre = nombre;
		this.edad = edad;
		this.sexo = sexo;
		comprobarSexo();
		generaNSS();
		this.peso = peso;
		this.altura = altura;
	}
	
	
	//-----------------------Metodo Calcular Peso Ideal------------------------------//
	/*------------------Peso ideal (peso en kg/(Estatura^2 en m))----------------------
	-------------------------Hombre-------Mujer----------------------------------------
	-------Flata de peso-----Menor a 20---Menor a 19-----------------------------------
	-------Peso normal-------20-25--------19-24----------------------------------------
	------ Sobrepeso---------Mayor a 25---Mayor a 24---------------------------------*/
	
	public int calcularIMC(){
		if (sexo=='M') {
			peso++;
		}
		double cal_peso = peso / Math.pow(altura, 2);
		if (cal_peso>=20 && cal_peso<=25) {
			return Peso_normal;
		}else if(25<cal_peso) {
			return Sobrepeso;
		}else {
			return Falta_de_peso;
		}
	}
	
	
	//----Metodo indica si es mayor de edad, devuelve un booleano---------------------//
	
	public boolean esMayorDeEdad(){
		if (edad>18) {
			return true;			
		}
		return false;
	}
	
	
	/*----Metodo Comprueba que el sexo introducido es correcto.-------------------------- 
	------Devolver el valor en booleano. No será visible al exterior-------------------*/
	
	 private boolean comprobarSexo() {
		 if (sexo != 'H' && sexo != 'M') {
			 return false;
		 }
		 return true;
	 }
	 
	 
	//----Metodo devuelve toda la información del objeto--------------------------------//
	
	 public String toString() {
		 return "Nombre: "+nombre+
				"\nEdad: "+edad+
				"\nSexo: "+sexo+
				"\nNSS: "+nss+
				"\nPeso: "+peso+
				"\nAltura: "+altura;
	 }
	 
	 
	/*----Metodo genera una expresión de 8 caracteres con números y letras al azar.-------
	------Este método será invocado cuando se construya el objeto.------------------------
	------Puedes dividir el método en partes para que te sea más fácil.-------------------
	------No será visible al exterior.--------------------------------------------------*/
	 
	 private void generaNSS(){
		 nss=" ";
		for (int i = 0; i < 8; i++) {                        //ciclo de 8 caracteres
			int rd = (int)(Math.random()*2);                 //numero aleatoreo 0-1
			if (rd==0) {                                     //numero 0 igual a numero de 1 a 9
				nss += (int)(Math.random()*9+1);             //se agrega ala cadena de texto a generar
			}else {                                          //numero diferente a 0 seran letras
				int num= (int)(Math.random()*(65-91+1)+91);  //numero aleatoreo 65-91
				nss += Character.toString((char) num);       //se transforma el numero acii a letra y se agrega ala cadena de texto
			}
		}
	 }
	 
	 
	//----Metodos Set-------------------------------------------------------------------//
	 
		public void setNombre(String nombre) {
			this.nombre = nombre;
		}

		public void setEdad(int edad) {
			this.edad = edad;
		}

		public void setSexo(char sexo) {
			this.sexo = sexo;
		}

		public void setPeso(float peso) {
			this.peso = peso;
		}

		public void setAltura(float altura) {
			this.altura = altura;
		}
	
	 
}