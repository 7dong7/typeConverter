package hello.typeconverter;

import hello.typeconverter.converter.IntegerToStringConverter;
import hello.typeconverter.converter.IpPortToStringConverter;
import hello.typeconverter.converter.StringToIntegerConverter;
import hello.typeconverter.converter.StringToIpPortConverter;
import hello.typeconverter.formatter.MyNumberFormatter;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    // addFormatters 를 사용해서 컨버터 등록
    @Override
    public void addFormatters(FormatterRegistry registry) {
        // 주석처리 우선순위
            // 컨버터 우선순위가 있어서 컨버터: 문자 -> 숫자, 숫자 -> 문자
                                // 포맷터: 문자 -> 숫자, 숫자 -> 문자 기능이 비슷하기 때문에 우선순위가 밀린다
//        registry.addConverter(new StringToIntegerConverter());
//        registry.addConverter(new IntegerToStringConverter());
        registry.addConverter(new StringToIpPortConverter());
        registry.addConverter(new IpPortToStringConverter());
        
        // 추가
        registry.addFormatter(new MyNumberFormatter());
    }
}
