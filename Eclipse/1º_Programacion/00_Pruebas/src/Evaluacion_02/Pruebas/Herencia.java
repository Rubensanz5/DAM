package Evaluacion_02.Pruebas;


	class A {
		A(){
			System.out.println("En constructor A");
		}
		
		A(String mensaje){
			System.out.println(mensaje);
		}
		
		A(int numero){
			System.out.println(numero + 1);
		}
	}
	
	class B extends A {
		B(){
			System.out.println("En constructor B");
		}
		
		B(String mensaje){
			System.out.println(mensaje);
		}
		
		B(int numero){
			super(numero);
			System.out.println(numero + 2);
		}
	}
	
	class C extends B {
		C(){
			System.out.println("En constructor C");
		}
		
		C(String mensaje){
			super(mensaje);
			System.out.println(mensaje);
		}
		
		C(int numero){
			super(numero);
			System.out.println(numero + 3);
		}
	}
	public class Herencia {
		@SuppressWarnings("unused")
		public static void main (String[] args) {
			C obj1 = new C();
			System.out.println("-------------");
			C obj2 = new C("Mensaje");
			System.out.println("-------------");
			C obj3 = new C(1234);
			
		}
}
