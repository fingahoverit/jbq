package com.github.fingahoverit.jbq.maxixl.promotion;

import java.math.BigDecimal;

public class BurgerPromotion {

	static private double promoKetchup() {

		Double prixBurger = 5.03;
		Double promo = 0.42;

		return prixBurger - promo;
	}

	static private double promoMayo() {

		Double prixBurger = 5.03;
		Double promo = 0.39;

		return prixBurger - promo;
	}

	static private double promoSel() {

		BigDecimal prixBurger = new BigDecimal("5.03");
		BigDecimal promo = new BigDecimal("0.43");

		return prixBurger.subtract(promo).doubleValue();
	}

	static private double promoPoivre() {

		BigDecimal prixBurger = new BigDecimal(5.03);
		BigDecimal promo = new BigDecimal(0.43);

		return prixBurger.subtract(promo).doubleValue();
	}

	static private void promo100() {

		for (int i = 0; i < 100; i++) {
			System.out.println("Promo " + i + " : " + (5.03 - (i * 0.01)));
		}
	}

	public static void main(String[] args) {

		System.out.println("Promo Ketchup : " + promoKetchup());
		System.out.println("Promo Mayonnaise : " + promoMayo());
		System.out.println("Promo Sel : " + promoSel());
		System.out.println("Promo Poivre : " + promoPoivre());

		// promo100();
	}
}
