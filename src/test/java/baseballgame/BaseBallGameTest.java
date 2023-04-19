package baseballgame;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class BaseBallGameTest {
	
	BaseBallGame baseBallGame;
	
	@BeforeEach
	void setUp() {
		baseBallGame = new BaseBallGame();
	}
	
	/**
	 * 놓친 것 : 리드미에 요구사항 작성. 각 자리 수가 서로 다르다. toString 테스트를 좀더 자세히 작성하자.
	 */
	
	// createRandomNumber 메서드 테스트
	@DisplayName("랜덤한 숫자의 길이는 3이다.")
	@Test
	void random1() {
		String random = baseBallGame.createRandomNumber();
		assertThat(random.length()).isEqualTo(3);
	}
	
	@DisplayName("랜덤한 숫자는 모두 숫자로 이루어져 있다.")
	@Test
	void random2() {
		String random = baseBallGame.createRandomNumber();
		for (char c : random.toCharArray()) isNumber(c);
	}
	
	@DisplayName("랜덤한 숫자는 서로 다른 수이다.")
	@Test
	void random3() {
		String random = baseBallGame.createRandomNumber();
		
		Set<Character> set = new HashSet<>();
		
		for (char c : random.toCharArray()) set.add(c);
		
		assertThat(set.size()).isEqualTo(3);
	}
	
	@ParameterizedTest
	void isNumber(char c) {
		assertThat(Character.isDigit(c)).isTrue();
	}
	
	// isValid 메서드 테스트
	
	@DisplayName("입력은 서로 다른 3자리의 숫자일 때 true이다.")
	@Test
	void validInput() {
		assertThat(baseBallGame.isValid("123")).isTrue();
	}
	
	@DisplayName("입력된 숫자의 길이가 3이 아니라면 false이다.")
	@Test
	void invalidInput1() {
		assertThat(baseBallGame.isValid("1234")).isFalse();
		assertThat(baseBallGame.isValid("12")).isFalse();
	}
	
	@DisplayName("입력이 숫자만으로 이루어져 있지 않다면 false이다.")
	@Test
	void invalidInput2() {
		assertThat(baseBallGame.isValid("1A3")).isFalse();
	}
	
	@DisplayName("입력된 숫자가 서로 다른 수가 아니라면 false이다")
	void invalidInput3() {
		assertThat(baseBallGame.isValid("113")).isFalse();
	}

	// countBall 메서드 테스트
	
	@DisplayName("같은 수가 있다면 볼이다.")
	@Test
	void ballCount() {
		int count = baseBallGame.countBall("123", "237");
		assertThat(count).isEqualTo(2);
	}
	
	@DisplayName("같은 수와 같은 자리라면 볼이 아니다.")
	@Test
	void notBallCount() {
		int count = baseBallGame.countBall("123", "724");
		assertThat(count).isEqualTo(0);
	}
	
	// strikeCount 메서드 테스트
	@DisplayName("같은 수와 같은 자리라면 스트라이크이다.")
	@Test
	void strikeCount() {
		int count = baseBallGame.countStrike("123", "124");
		assertThat(count).isEqualTo(2);
	}
	
	@DisplayName("같은 수이지만 같은 자리가 아니라면 스트라이크가 아니다.")
	@Test
	void notStrikeCount() {
		int count = baseBallGame.countStrike("123", "214");
		assertThat(count).isEqualTo(0);
	}
	
	// toString 메서드 테스트
	
	@DisplayName("0볼 0스트라이크라면 낫싱이다.")
	@Test
	void toStringTest1() {
		String s = baseBallGame.toString(0, 0);
		assertThat(s).isEqualTo("낫싱");
	}
	
	@DisplayName("2볼 0스트라이크라면 2볼이다.")
	@Test
	void toStringTest2() {
		String s = baseBallGame.toString(2, 0);
		assertThat(s).isEqualTo("2볼");
	}
	
	@DisplayName("0볼 2스트라이라면 2스트라이크이다.")
	void toStringTest3() {
		String s = baseBallGame.toString(0, 2);
		assertThat(s).isEqualTo("2스트라이크");
	}
	
	@DisplayName("1볼 2스트라이크라면 1볼 2스트라이크이다.")
	void toStringTest4() {
		String s = baseBallGame.toString(1, 2);
		assertThat(s).isEqualTo("1볼 2스트라이크");
	}
	
}