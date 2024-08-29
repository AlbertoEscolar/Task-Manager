
//Ejercicio: Sistema de Gestión de Tareas (To-Do List)
//
//Descripción:
//
//Crea un programa en Java que actúe como un sistema básico de gestión de tareas (To-Do List). El programa debe permitir al usuario realizar las siguientes acciones:
//
//    Agregar una tarea: El usuario puede ingresar una nueva tarea a la lista.
//    Mostrar todas las tareas: El programa muestra todas las tareas actuales, enumeradas por número.
//    Marcar una tarea como completada: El usuario puede indicar que ha completado una tarea específica. Las tareas completadas deben mantenerse en la lista, pero indicarse como completadas.
//    Eliminar una tarea: El usuario puede eliminar una tarea específica de la lista.
//    Salir: Terminar el programa.
//
//Detalles del Ejercicio:
//
//    Interfaz de Usuario:
//        Utiliza la consola para la interacción con el usuario.
//        Muestra un menú de opciones cada vez que se completa una acción.
//
//    Estructura del Programa:
//        Usa una clase Tarea con atributos como descripcion y completada.
//        Usa una clase ToDoList que contenga una lista de objetos Tarea y métodos para agregar, mostrar, marcar como completada y eliminar tareas.
//
//    Funciones Esperadas:
//        void agregarTarea(String descripcion): Añade una nueva tarea a la lista.
//        void mostrarTareas(): Muestra todas las tareas con su estado (completada o no).
//        void marcarTareaCompletada(int indice): Marca una tarea como completada.
//        void eliminarTarea(int indice): Elimina una tarea de la lista.
//        boolean salir(): Permite al usuario salir del programa.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskManager {
	
    public static void main(String[] args) {
    	
    	int intSelectOption = -1;

    	try {
    		
    		TaskControl oTask = new TaskControl();
    		    	
	    	while (intSelectOption != 5) {
	    		
	    		displayMenu();
	    			    		
	    		System.out.println("Escribe el numero de la accion que desee");
	    		
	    		Scanner scanIn = new Scanner(System.in);
	    		
	    		switch (scanIn.nextInt()) {
	    		
					case 1: {
						oTask.addTask(scanIn);
						break;
					}
					case 2: {
						oTask.showTasks();
						break;
					}
					case 3: {
						oTask.completeTask(scanIn);
						break;
					}
					case 4: {
						oTask.deleteTask(scanIn);
						break;
					}
					case 5: {
						System.out.print("Chao Pescao");
						scanIn.close();
			    		System.exit(1);
					}
					default:
						System.out.print("VALOR INCORRECTO");
				}
	    		System.out.println("");	    		
	    	}	    	
    	
    	} catch (Exception ex) {
    		System.out.print("Error: " + ex.getMessage());
    		System.exit(1);
    	}  	    	
    }

	private static void displayMenu() {
		System.out.println("------- MENU --------");
		System.out.println("1. Agregar nueva tarea");
		System.out.println("2. Mostrar todas las tareas");
		System.out.println("3. Marcar tarea como completada");
		System.out.println("4. Eliminar Tarea");
		System.out.println("5. Salir");
		System.out.println("");		
	}    
	
	
	public static class TaskControl {
		
		List<Task> tasks = new ArrayList<Task>();		
		
		public TaskControl() {
			
		}
		
		public void addTask(Scanner scanIn) {			
			System.out.println("Introduzca nombre de tarea: ");			
			
			String strTaskName = scanIn.next();
			Task oTask = new Task(strTaskName, false);			
			this.tasks.add(oTask);
		}
		
		public void showTasks() {
			
			int intCount = 0; 
			
			for (Task task : tasks) {
				intCount++;
				System.out.println(intCount + ". " + task.toString());	
			}
			
		}
		
		public void completeTask(Scanner scanIn) {	
			
			System.out.println("Introduzca nº de tarea a completar: ");			
			try {				
				int intNumSelect = scanIn.nextInt();						
				int intCount = 0; 
				
				for (Task task : tasks) {
					intCount++;
					
					if (intCount == intNumSelect) {
						task.setCompleted(true);
						System.out.println("La tarea " + intCount + " ha sido completada");
						return;
					}									
				}
				
				System.out.println("LA TAREA NO SE HA ENCONTRADO");
				
			} catch (Exception ex) {
				throw ex;
			}						
		}
		
		public void deleteTask(Scanner scanIn) {	
			
			System.out.println("Introduzca nº de tarea a eliminar: ");

			try {				
				int intNumSelect = scanIn.nextInt();						
				int intCount = 0; 
				
				for (Task task : tasks) {
					intCount++;
					
					if (intCount == intNumSelect) {
						tasks.remove(intCount - 1);
						System.out.println("La tarea " + intCount + " ha sido eliminada");						
						return;
					}									
				}
				
				System.out.println("LA TAREA NO SE HA ENCONTRADO");
				
			} catch (Exception ex) {
				throw ex;
			}						
		}
		
		
	}
	
	public static class Task {
				
		String taskName = "";
		boolean isCompleted = false;
		
		public Task(String _taskName, boolean _isCompleted) {
			this.taskName = _taskName;
			this.isCompleted = _isCompleted;
		}

		public String getTaskName() {
			return taskName;
		}

		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}

		public boolean isCompleted() {
			return isCompleted;
		}

		public void setCompleted(boolean isCompleted) {
			this.isCompleted = isCompleted;
		}

		@Override
		public String toString() {
			if (isCompleted) {
				return "Tarea - Nombre = " + taskName + " Completa = SI";				
			} else {
				return "Tarea - Nombre = " + taskName + " Completa = NO";
			}
		}									
		
	}

}



