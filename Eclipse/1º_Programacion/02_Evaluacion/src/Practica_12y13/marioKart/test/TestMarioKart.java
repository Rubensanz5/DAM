package Practica_12y13.marioKart.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import Practica_12y13.marioKart.Competicion;
import Practica_12y13.marioKart.PilotoKart;

class TestMarioKart {
	
	public static Competicion juanDeColoniaRace = new Competicion("Senda Arco Iris", "img/rainbowroad_map.png", 250, 3);

	@BeforeEach
	public void prepararParticipantes() {
		
		PilotoKart mario = new PilotoKart("Mario", "img/mario.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart luigi = new PilotoKart("Luigi", "img/luigi.png", new int[] {3, 3, 3, 4, 3});
		PilotoKart peach = new PilotoKart("Peach", "img/peach.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart yoshi = new PilotoKart("Yoshi", "img/yoshi.png", new int[] {2, 3, 3, 3, 4});
		PilotoKart bowser = new PilotoKart("Bowser", "img/bowser.png", new int[] {5, 1, 5, 1, 3});
		PilotoKart donkeykong = new PilotoKart("Donkey Kong", "img/donkeykong.png", new int[] {4, 2, 4, 2, 2});
		PilotoKart toad = new PilotoKart("Toad", "img/toad.png", new int[] {1, 4, 1, 5, 4});
		PilotoKart koopa = new PilotoKart("Koopa", "img/koopa.png", new int[] {1, 5, 2, 4, 3});
		PilotoKart daisy = new PilotoKart("Daisy", "img/daisy.png", new int[] {2, 4, 2, 4, 3});
		PilotoKart wario = new PilotoKart("Wario", "img/wario.png", new int[] {5, 1, 5, 1, 2});
		
		PilotoKart[] pilotosJuanDeColoniaRace = { mario, luigi, peach, yoshi, bowser, donkeykong, toad, koopa, daisy, wario };
		juanDeColoniaRace.setParticipantes(pilotosJuanDeColoniaRace);
		
		
	}
	
	@DisplayName("AddKart primera posicion")
	@Test
	void testAddKart() {
		boolean result = juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), 1);
		assertEquals("shyguy", juanDeColoniaRace.getParticipantes()[0].getPiloto());
		assertTrue(result);
	}
	
	@DisplayName("AddKart ultima posicion")
	@Test
	void testAddKart1() {
		boolean result = juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), 11);
		assertEquals("shyguy", juanDeColoniaRace.getParticipantes()[10].getPiloto());
		assertTrue(result);
	}
	
	@DisplayName("AddKart posicion intermedia")
	@Test
	void testAddKart2() {
		boolean result = juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), 5);
		assertEquals("shyguy", juanDeColoniaRace.getParticipantes()[4].getPiloto());
		assertTrue(result);
	}
	
	@DisplayName("AddKart posicion fallida por debajo del limite")
	@Test
	void testAddKart3() {
		PilotoKart[] nParticipantes = juanDeColoniaRace.getParticipantes();
		boolean result = juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), -1);
		assertEquals(nParticipantes, juanDeColoniaRace.getParticipantes());
		assertFalse(result);
	}
	
	@DisplayName("AddKart posicion fallida por encima del limite")
	@Test
	void testAddKart4() {
		PilotoKart[] nParticipantes = juanDeColoniaRace.getParticipantes();
		boolean result = juanDeColoniaRace.addKart(new PilotoKart("shyguy", "img/shyguy.png", new int[] {4, 5, 1, 3, 2}), 12);
		assertEquals(nParticipantes, juanDeColoniaRace.getParticipantes());
		assertFalse(result);
	}
	
	@DisplayName("AddKart con piloto null")
	@Test
	void testAddKart5() {
		PilotoKart[] nParticipantes = juanDeColoniaRace.getParticipantes();
		boolean result = juanDeColoniaRace.addKart(null, 5);
		assertEquals(nParticipantes, juanDeColoniaRace.getParticipantes());
		assertFalse(result);
	}
	
	@DisplayName("RemoveKart nombre null")
	@Test
	void testRemoveKart() {
		PilotoKart[] nParticipantes = juanDeColoniaRace.getParticipantes();
		boolean result = juanDeColoniaRace.removeKart(null);
		assertEquals(nParticipantes, juanDeColoniaRace.getParticipantes());
		assertFalse(result);
	}
	
	@DisplayName("RemoveKart primer piloto")
	@Test
	void testRemoveKart1() {
		boolean result = juanDeColoniaRace.removeKart("Mario");
		assertEquals(9, juanDeColoniaRace.getParticipantes().length);
		assertTrue(result);
	}

	@DisplayName("RemoveKart piloto intermedio")
	@Test
	void testRemoveKart2() {
		boolean result = juanDeColoniaRace.removeKart("peach");
		assertEquals(9, juanDeColoniaRace.getParticipantes().length);
		assertTrue(result);
	}
	
	@DisplayName("RemoveKart piloto final")
	@Test
	void testRemoveKart3() {
		boolean result = juanDeColoniaRace.removeKart("wario");
		assertEquals(9, juanDeColoniaRace.getParticipantes().length);
		assertTrue(result);
	}
	
	@DisplayName("RemoveKart nombre no existente")
	@Test
	void testRemoveKart4() {
		PilotoKart[] nParticipantes = juanDeColoniaRace.getParticipantes();
		boolean result = juanDeColoniaRace.removeKart("Hola :)");
		assertTrue(Arrays.equals(nParticipantes, juanDeColoniaRace.getParticipantes()));
		assertFalse(result);
	}
	
}
