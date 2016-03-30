package com.github.fingahoverit.jbq.magicbox.exceptionrule;

class TropBonException extends Exception {}
class DegueulasseException extends Exception {}
class FinException extends Exception {}

class Burger implements AutoCloseable {
	
	public Burger() throws Exception {
		log("Le burger est dispo.");
	}

	private static void log(String phrase) {
		System.out.println(phrase);
	}
	
	public boolean estAppetissant() {
		try { return true;} 
		catch (Exception e){ /* impossible */ }
		finally { return false;}
	}

	public void mange() throws Exception {

		if (estAppetissant()) {
			log("Je mange le burger.");
			throw new TropBonException();
		} else {
			log("Je jette le burger.");
			throw new DegueulasseException();
		}
	}

	public void close() throws Exception {
		log("Plus de burger");
		throw new FinException();
	}

	public static void main(String[] args) throws Exception {

		try (Burger burger = new Burger()) {
			burger.mange();
		} catch (Exception e) {
			log("Exception retournée : " + e.getClass());
			int suppressedCount = e.getSuppressed().length;
			for (int i = 0; i < suppressedCount; i++) {
				log("Exception Cachée : " + e.getSuppressed()[i]);
			}

		} finally {
			log("Je jette proprement le carton");
		}
	}
}
