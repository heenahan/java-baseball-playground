package study;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;

public class SetTest {
	
	private Set<Integer> numbers;
	
	@BeforeEach
	void setup() {
		numbers = new HashSet<>();
		numbers.add(1);
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
	}
	
	@Test
	void size() {
		assertThat(numbers.size()).isEqualTo(3);
	}
	
	@Test
	void contains() {
		for (int i = 1; i <= 3; i++) isTrue(numbers.contains(i));
	}
	
	@ParameterizedTest
	void isTrue(boolean input) {
		assertThat(input).isTrue();
	}
	
	@Test
	void contains2() {
		for (int i = 1; i <= 3; i++) isContains(numbers.contains(i), true);
		for (int i = 4; i <= 5; i++) isContains(numbers.contains(i), false);
	}
	
	@ParameterizedTest
	void isContains(boolean input, boolean expect) {
		assertThat(input).isEqualTo(expect);
	}
	
}
