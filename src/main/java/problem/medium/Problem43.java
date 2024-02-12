package problem.medium;

import java.util.AbstractMap;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Problem43 {

    /**
     * 주어진 문자열 리스트와 정수 리스트를 결합하여,
     * 문자열의 길이가 해당 정수 이하인 문자열만 필터링하여 반환합니다.
     *
     * @param strings 문자열 리스트
     * @param lengths 정수 리스트 (각 문자열의 최대 길이를 나타냄)
     * @return 조건을 만족하는 문자열 리스트
     */
    public static List<String> filterStringsByLength(List<String> strings, List<Integer> lengths) {
        // 여기에 코드 작성
        return IntStream.iterate(0, i -> i + 1).limit(strings.size())
                .filter(i -> strings.get(i).length() <= lengths.get(i))
                .mapToObj(strings::get)
                .toList();
    }
}
