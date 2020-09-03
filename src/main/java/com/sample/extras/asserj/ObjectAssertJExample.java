package com.sample.extras.asserj;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;

class Dog {
	private String name;
	private double weight;

	public Dog(String name, double weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

}

@RunWith(JUnitPlatform.class)
public class ObjectAssertJExample {
	Dog fido = new Dog("Fido", 5.25);
	Dog fidosClone = new Dog("Fido", 5.25);

	@Test
	void test() {
		assertThat(fido).isEqualTo(fidosClone); // This will fail as isEqualTo() compares object references.
	}

	@Test
	void test2() {
		assertThat(fido).isEqualToComparingFieldByFieldRecursively(fidosClone);
		// Fido and fidosClone are equal when doing a recursive field by field
		// comparison because each field of one object is compared to the field in the
		// other object.
	}
}
