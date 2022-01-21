package Ejemplos;

import java.math.BigDecimal;
import java.math.BigInteger;

import org.neodatis.odb.ODB;
import org.neodatis.odb.ODBFactory;
import org.neodatis.odb.OID;
import org.neodatis.odb.ObjectValues;
import org.neodatis.odb.Objects;
import org.neodatis.odb.Values;
import org.neodatis.odb.core.oid.OIDFactory;
import org.neodatis.odb.core.query.IQuery;
import org.neodatis.odb.core.query.criteria.And;
import org.neodatis.odb.core.query.criteria.ICriterion;
import org.neodatis.odb.core.query.criteria.Or;
import org.neodatis.odb.core.query.criteria.Where;
import org.neodatis.odb.impl.core.query.criteria.CriteriaQuery;
import org.neodatis.odb.impl.core.query.values.ValuesCriteriaQuery;

public class ConsultasJugador {

	public static void main(String[] args) {
		ODB odb = ODBFactory.open("equipos.db");
		
		//visualizar objetos jugadores
		Objects <Jugadores> obj = odb.getObjects(Jugadores.class);
		System.out.println("----- Consulta 1 -----");
		System.out.println(obj.size() + " jugadores\n");
		
		for (Jugadores j : obj) {
			System.out.println(j);
			System.out.println("--------------------");
		}
		
		System.out.println("----- Consulta 2 -----");
		OID id1 = odb.getObjectId(obj.getFirst());
		System.out.println("OID del primer jugador -> " + id1);
		
		System.out.println("----- Consulta 3 -----");
		OID id2 = OIDFactory.buildObjectOID(2);
		Jugadores j1 = (Jugadores) odb.getObjectFromId(id2);
		System.out.println(j1);
		
		System.out.println("----- Consulta 4 -----");
		IQuery consulta = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Sara"));
		consulta.orderByAsc("nombre,edad");
		Objects<Jugadores> obj1 = odb.getObjects(consulta);
		for (Jugadores j : obj1) {
			System.out.println(j);
			System.out.println("--------------------");
		}
		
		System.out.println("----- Consulta 5 -----");
		System.out.println("El primer jugador con el nombre Sara es:\n" + obj1.getFirst());

		
		System.out.println("----- Consulta 6 -----");
		IQuery consulta6 = new CriteriaQuery(Jugadores.class,Where.equal("deporte", "PelotaMano"));
		Objects<Jugadores> obj2 = odb.getObjects(consulta6);
		for (Jugadores j : obj2) {
			System.out.println(j);
			System.out.println("--------------------");

		}
		
		System.out.println("----- Consulta 7 -----");
		IQuery consulta7 = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Jaime"));
		Jugadores j7 = (Jugadores) odb.getObjects(consulta7).getFirst();
		j7.setDeporte("Fronton");
		odb.store(j7);
		System.out.println(j7);

		System.out.println("----- Consulta 8 -----");
		IQuery consulta8 = new CriteriaQuery(Jugadores.class, Where.equal("nombre", "Dani"));
		
		Objects<Jugadores> obj3 = odb.getObjects(consulta8);
		if (obj3.size() <= 0){
			System.out.println("No existe ese jugador");
		} else {
			Jugadores j8 = obj3.getFirst();
			odb.delete(j8);
			System.out.println("Borrado con exito");
		}

		
		System.out.println("----- Consulta 9 -----");
		IQuery consulta9 = new CriteriaQuery(Jugadores.class, Where.lt("edad", 25)); 
		Objects<Jugadores> obj4 = odb.getObjects(consulta9);
		if(obj4.size() <= 0) {
			System.out.println("No hay jugadores menores de 15 años");
		} else {
			for(Jugadores j : obj4) {
				System.out.println(j);
				System.out.println("--------------------");
			}
		}

		System.out.println("----- Consulta 10 -----");
		IQuery consulta10 = new CriteriaQuery(Jugadores.class, Where.like("nombre", "J%"));
		Objects<Jugadores> obj5 = odb.getObjects(consulta10);
		if(obj5.size() <= 0) {
			System.out.println("No hay ningun jugador que empieze con J");
		} else {
			for (Jugadores j : obj5) {
				System.out.println(j);
				System.out.println("--------------------");
			}
		}

		System.out.println("----- Consulta 11 -----");
		IQuery consulta11 = new CriteriaQuery(Jugadores.class, Where.not(Where.like("nombre", "J%")));
		Objects<Jugadores> obj6 = odb.getObjects(consulta11);
		if(obj5.size() <= 0) {
			System.out.println("No hay ningun jugador NO que empieze con J");
		} else {
			for (Jugadores j : obj6) {
				System.out.println(j);
				System.out.println("--------------------");
			}
		}

		System.out.println("----- Consulta 12 -----");
		ICriterion condicion12 = new And().add(Where.equal("pais", "Colombia")).add(Where.equal("edad", 20));
		CriteriaQuery consulta12 = new CriteriaQuery(Jugadores.class, condicion12);
		Objects<Jugadores> obj7 = odb.getObjects(consulta12);
		if (obj7.size() <= 0) {
			System.out.println("No hay jugadores de Colombia de 20 años");
		} else {
			for (Jugadores j : obj7) {
				System.out.println(j);
				System.out.println("--------------------");
			}
		}

		System.out.println("----- Consulta 13 -----");
		ICriterion condicion13 = new Or().add(Where.equal("pais", "Colombia")).add(Where.gt("edad", 20));
		CriteriaQuery consulta13 = new CriteriaQuery(Jugadores.class, condicion13);
		Objects<Jugadores> obj8 = odb.getObjects(consulta13);
		if (obj8.size() <= 0) {
			System.out.println("No hay jugadores de Colombia o que tengan mas de 20 años");
		} else {
			for (Jugadores j : obj8) {
				System.out.println(j);
				System.out.println("--------------------");
			}
		}
		
		
		System.out.println("----- Consultas Complejas -----");
		System.out.println("----- Consulta 14 -----");
		//																			  index 0         index 1
		Values valores = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).field("nombre").field("edad"));
		for (ObjectValues objectValues : valores) {
			System.out.println("Nombre: " + objectValues.getByAlias("nombre")
								+ "\nEdad: " + objectValues.getByIndex(1));
			System.out.println("--------------------");

		}

		
		System.out.println("----- Consulta 15 -----");
		Values suma = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).sum("edad"));
		ObjectValues ovSuma = suma.nextValues();
		//si no usas este valor para nada mas lo muestras
		System.out.println("La suma de las edades es: " + ovSuma.getByIndex(0));
		
		//si se van a hacer operaciones con el:
		
		BigDecimal valorSuma = (BigDecimal) ovSuma.getByIndex(0);
		System.out.println("La suma de las edades es: " + valorSuma.intValue());

		
		System.out.println("----- Consulta 16 -----");
		Values valores16 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).count("nombre"));
		ObjectValues numJug = valores16.nextValues();
		BigInteger numJugT = (BigInteger) numJug.getByIndex(0);
		
		System.out.println("El numero total de jugadores es: " + numJugT.intValue());
		
		System.out.println("----- Consulta 17 -----");
		System.out.println("La media de edad de los jugadores es: " + (valorSuma.doubleValue()/numJugT.doubleValue()));
		
		System.out.println("----- Consulta 18 -----");
		Values edadMaxMin = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).min("edad").max("edad"));
		ObjectValues edades = edadMaxMin.next();
		System.out.println("Las edades maxima: " + edades.getByIndex(0));
		System.out.println("Las edades minima: " + edades.getByIndex(1));
		
		System.out.println("----- Consulta 19 -----");
		Values valores19 = odb.getValues(new ValuesCriteriaQuery(Jugadores.class).count("ciudad").field("ciudad").groupBy("ciudad"));
		for (ObjectValues ov : valores19) {
			System.out.println("Numero Jugadores: " + ov.getByIndex(0));
			System.out.println("Ciudad: " + ov.getByIndex(1));
			System.out.println("--------------------");
		}
		
		System.out.println("----- Consulta 20 -----");
		ICriterion condicion20 = new And().add(Where.equal("ciudad", "Burgos")).add(Where.equal("edad", 23)); 
		CriteriaQuery consulta20 = new CriteriaQuery(Jugadores.class,condicion20);
		Objects<Jugadores> obj20 = odb.getObjects(consulta20);
		for (Jugadores j : obj20) {
			System.out.println(j);
			System.out.println("--------------------");
		}
		
		
		odb.close();
	}



}
