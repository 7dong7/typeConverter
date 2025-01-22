package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ConverterTest {

    // 문자를 숫자로 변경하는 컨버터 테스트
    @Test
    public void stringToInteger() throws Exception{
        StringToIntegerConverter converter = new StringToIntegerConverter();
        Integer result = converter.convert("10");
        
        assertThat(result).isEqualTo(10);
    }
    
    // 숫자를 문자로 변경하는 컨버터
    @Test
    public void IntegerToString() throws Exception{
        IntegerToStringConverter converter = new IntegerToStringConverter();
        String result = converter.convert(10);

        assertThat(result).isEqualTo("10");
    }

    // IpPort type -> 문자 type 컨버터 테스트
    @Test
    public void ipPortToStringConverter() throws Exception{
        IpPortToStringConverter converter = new IpPortToStringConverter();
        IpPort source = new IpPort("127.0.0.1", 8080);
        String result = converter.convert(source);
        
        assertThat(result).isEqualTo("127.0.0.1:8080");
    }

    // 문자 type -> IpPort type 컨버터 테스트
    @Test
    public void stringToIpPortConverter() throws Exception{
        StringToIpPortConverter converter = new StringToIpPortConverter();
        String source = "127.0.0.1:8080";
        IpPort result = converter.convert(source);

        assertThat(result).isEqualTo(new IpPort("127.0.0.1", 8080)); // @EqualsAndHashCode 로 비교 가능
    }
}
