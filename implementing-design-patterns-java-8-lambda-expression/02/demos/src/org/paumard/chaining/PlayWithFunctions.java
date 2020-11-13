package org.paumard.chaining;

import org.paumard.chaining.function.Function;
import org.paumard.chaining.model.Meteo;

public class PlayWithFunctions {

	public static void main(String[] args) {

		Meteo meteo = new Meteo(10);

		Function<Meteo, Integer> readCelsius = m -> m.getTemperature();
		Function<Integer, Double> celsiusToFahrenheit = t -> t*9d/5d + 32d;

		Function<Meteo, Double> readFahrenheit = readCelsius.andThen(celsiusToFahrenheit);
		System.out.println("Meteo is F " + readFahrenheit.apply(meteo));

		readFahrenheit = celsiusToFahrenheit.compose(readCelsius);

		System.out.println("Meteo is F " + readFahrenheit.apply(meteo));
	}
}
