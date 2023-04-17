package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class StringTest {
	
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }
	
	@Test
	void split() {
		String[] s1 = "1,2".split(",");
		String[] s2 = "1".split(",");
		
		assertThat(s1).containsExactly("1", "2");
		assertThat(s2).containsExactly("1");
	}
	
	@Test
	void substrig() {
		String s = "(1,2)";
		String sub = s.substring(1, s.length() - 1);
		
		assertThat(sub).isEqualTo("1,2");
	}
	
	@DisplayName("문자열에서 특정 위치의 문자 가져오기. 범위를 벗어나면 에러")
	@Test
	void charAt() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					char c = "abc".charAt(3);
				})
				.withMessageMatching("String index out of range: \\d+");
	}
	
}
