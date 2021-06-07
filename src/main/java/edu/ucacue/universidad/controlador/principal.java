package edu.ucacue.universidad.controlador;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

 
import edu.ucacue.universidad.infraestructura.PersonaRepository;
import edu.ucacue.universidad.modelo.universidad;

import java.util.Scanner;
 

@Controller
public class principal {
	@Autowired
	PersonaRepository personaRepository;
	private Scanner lec;
	
	public void GUI() {
		@SuppressWarnings("resource")
		Scanner entradaEscaner = new Scanner(System.in);
		int entradaTeclado;
		do {
			System.out.println("**************MENÚ PRINCIPAL********************* ");
			System.out.println("*                                               * ");                                            
			System.out.println("*         1. Ingresar Estudiante                * ");                          
			System.out.println("*         2. Modificar Estudiante               * ");
			System.out.println("*         3. Eliminar Estudiante                * ");
			System.out.println("*         4. Listar Estudiante                  * ");
			System.out.println("*         5. Salir                              * ");
			System.out.println("************************************************* "); 
			entradaTeclado = entradaEscaner.nextInt();
			switch (entradaTeclado) {
			case 1:
				//Gererar el objeto Persona pidiendo los datos por teclado
				System.out.println("********************** "); 
				System.out.println("* Ingrese el nombre: *");
				System.out.println("********************** "); 
				String nombre= entradaEscaner.next();
				System.out.println("************************ "); 
				System.out.println("* Ingrese el apellido: * ");
				System.out.println("************************ "); 
				String apellido= entradaEscaner.next();
				System.out.println("********************** "); 
				System.out.println("* Ingrese la cédula: * ");
				System.out.println("********************** "); 
				String cedu= entradaEscaner.next();
				lec = new Scanner(System.in);
		        
			       
		        int c, suma=0, acum, resta=0;
		        
		        for (int i = 0; i < cedu.length()-1; i++) {
		            c=Integer.parseInt(cedu.charAt(i)+"");
		            if(i%2==0){
		                c=c*2;
		                if(c>9){
		                    c=c-9;
		                }
		            }
		            
		            suma=suma+c;
		        }
		        
		        if (suma%10 !=0) {
		            acum=((suma/10)+1)*10;
		            resta=acum-suma;
		        }
		        
		        int ultimo=Integer.parseInt(cedu.charAt(9)+"");
		        
		        if (ultimo==resta) {
		        	 
		            System.out.println("la cédula ingresa es correcta");
		        }else{
		            System.out.println("la cedula es incorrecta");
		        }
		        
		    
				System.out.println("************************ "); 
				System.out.println("* Ingrese el teléfono: * ");
				System.out.println("************************ "); 
				String telefono= entradaEscaner.next();
				
				 
				universidad p new universidad(id, nombre, descripcion, dieccion, telefono, numerodeestudiantes, correoelectronico);
				personaRepository.save(p );
				
				break;
			case 2:
				//1 Pedir al usuario que persona quiero modificar "Pedir la cédula"
				//2 ENcontrar a la persona por el número de la cédula
				//3 modificar y cambiar los datos
				try {
					System.out.println("*********************************************** "); 
					System.out.println("* Ingrese el nombre del estudiante a modificar  * ");
					System.out.println("*********************************************** "); 
					 String nombrelaBuscar = entradaEscaner.next();
					 universidad personaRecuperada = (universidad) personaRepository.findByNombreLike(nombrelaBuscar) ;
					 System.out.println("********************* "); 
					 System.out.println("* Ingrese el nombre * ");
					 System.out.println("********************* "); 
					 String nomb = entradaEscaner.next();
					 personaRecuperada.setNombre(nomb);
					 System.out.println("********************** "); 
					 System.out.println(" Ingrese la descripcion * ");
					 System.out.println("**********************"); 
					 String des = entradaEscaner.next();
					 personaRecuperada.setDescripcion(des);
					 System.out.println("*********************"); 
					 System.out.println("* Ingrese la direccion* ");
					 System.out.println("********************* "); 
					 String dire = entradaEscaner.next();
					 personaRecuperada.setDieccion(dire); 
					 System.out.println("*********************** ");  
					 System.out.println("* Ingrese el telefono * ");
					 
					 System.out.println("***********************"); 
					 
					 String tel = entradaEscaner.next();
					 personaRecuperada.setTelefono(tel);
					 personaRepository.save(personaRecuperada);
					}catch(Exception e) {System.out.println("   ");}
					break;
				
			case 3:
				try {
					System.out.println("Ingrese elnombre que desea eliminar: ");
					String nombreBuscar= entradaEscaner.next();
					
					universidad personaRecuperada= (universidad) personaRepository.findByNombreLike(nombreBuscar)  ;
					personaRepository.delete(personaRecuperada);
					//1 Pedir al usuario que persona quiero modificar "Pedir la cédula"
					//2 ENcontrar a la persona por el número de la cédula
					//3 Eliminar
					}catch(Exception e) {System.out.println("Existe un problema con la cédula ingresada ");}
					break;
			case 4:
					//Buscar todas las personas que están en la BD e imprimir os resultados
				String nombreBuscar= entradaEscaner.next();
				List<universidad> personas= personaRepository.findByNombreLike(nombreBuscar );
				System.out.println(  "Cédula|" +  "\t"  +   "|Nombre|"  +  "\t"  +  "|Apellido|");
				for (universidad persona : personas) {
					System.out.println(persona.getId()+" "+ persona.getNombre()+" " + persona.getDescripcion()" " + persona.getTelefono()" " + persona.getDireccion()" " + persona.getNumerodeestudiantes()" " + persona.getCorreoelectronico());
				}
				break;
			case 5:
				System.exit(0);	
				break;

			default:
				break;
			}
		} while (entradaTeclado != 5);

	}

	
}
