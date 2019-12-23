package src;

import java.util.Scanner;

public class ejecutable {

	public static void main(String[] args) {
		
		/*---crea una clase ejecutable que haga lo siguiente:-----------------
		-----Pide por teclado el nombre, la edad, sexo, peso y altura-------*/
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Escribe tu nombre: ");
		String nombre = sc.next();
		System.out.println("Escribe tu edad: ");
		int edad = sc.nextInt();
		System.out.println("Escribe tu sexo con la letra correspondiente'M' Mujer o 'H' Hombre: ");
		char sexo = sc.next().toUpperCase().charAt(0);
		System.out.println("Escribe tu peso");
		float peso = sc.nextFloat();
		System.out.println("Escribe tu altura en metros");
		float altura = sc.nextFloat();
		
		sc.close();
		
		
		//---Crea 3 objetos de la clase anterior---------------------------------------------------------------------//

		//---El primer objeto obtendrá las anteriores variables pedidas por teclado----------------------------------//
		
        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
				
		
		//---El segundo objeto obtendrá todos los anteriores menos el peso y la altura-------------------------------//
		
        Persona persona2 = new Persona(nombre, edad, sexo);

        
		//---El último por defecto, para este último utiliza los métodos set para darle a los atributos un valor-----//
		
        Persona persona3 = new Persona();
        
        persona3.setNombre("Lupe");
        persona3.setEdad(24);
        persona3.setSexo('M');
        persona3.setPeso(19);
        persona3.setAltura(1);
        
        
        /*-- • Para cada objeto, deberá comprobar si está en su peso ideal,------------------------------------------- 
		-------tiene sobrepeso o por debajo de su peso ideal con un mensaje-----------------------------------------*/
        
        System.out.println("\nFalta de Peso: -1   Peso ideal: 0   Sobrepeso: 1");
		System.out.println("IMC Persona 1: "+persona1.calcularIMC());
		System.out.println("IMC Persona 2: "+persona2.calcularIMC());
		System.out.println("IMC Persona 3: "+persona3.calcularIMC());
		
		
		//---- • Indicar para cada objeto si es mayor de edad--------------------------------------------------------//
		
		System.out.println("\nMayor de edad Persona 1: "+persona1.esMayorDeEdad());
		System.out.println("Mayor de edad Persona 2: "+persona2.esMayorDeEdad());
		System.out.println("Mayor de edad Persona 3: "+persona3.esMayorDeEdad());
		
		//-- • Por último, mostrar la información de cada objeto----------------------------------------------------//
		
		System.out.println("\nPersona 1: \n"+persona1.toString());
		System.out.println("\nPersona 2: \n"+persona2.toString());
		System.out.println("\nPersona 3: \n"+persona3.toString());

	}

}
