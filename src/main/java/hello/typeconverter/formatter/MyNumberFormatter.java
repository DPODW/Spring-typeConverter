package hello.typeconverter.formatter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.format.Formatter;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

@Slf4j
public class MyNumberFormatter implements Formatter<Number> {
    /**
     * Number 는 integer, long 등등 숫자와 관련된 객체들의 부모임
     * */

    @Override
    public Number parse(String text, Locale locale) throws ParseException {  //(큰 범위에서)문자 -> 객체
        log.info("text={},locale={}",text,locale);
        NumberFormat format = NumberFormat.getInstance(locale);
        return format.parse(text);
        /*
        * 1,000 과 같은 중간 쉼표를 적용하려면 NumberFormat 객체를 사용하면 된다.
        * 해당 객체는 locale (지역) 정보를 활용해서 나라에 맞는 숫자 포맷을 적용해준다.
        * 즉 -> format 에 text 가 들어오면, 그에 맞는 숫자 형식으로 출력해주는것이다.
        *
        * */
    }

    @Override
    public String print(Number object, Locale locale) { //(큰 범위에서)객체 -> 문자
        log.info("object={}, locale={}", object,locale);
        NumberFormat instance = NumberFormat.getInstance(locale);
        return NumberFormat.getInstance(locale).format(object);
    }

    /*
    * parse 와 반대 로 동작한다.
    * */

}
