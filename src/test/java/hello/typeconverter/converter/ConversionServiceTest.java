package hello.typeconverter.converter;

import hello.typeconverter.type.IpPort;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.convert.support.DefaultConversionService;

import static org.assertj.core.api.Assertions.*;


public class ConversionServiceTest {

    @Test
    void conversionService() {
        /**
         * 우리가 만든 컨버터를 DefaultConversionService 에 등록해서 사용하면,
         * DefaultConversionService 가 매개값을 보고 알아서 등록된 컨버터 중, 적용 가능한 컨버터를 잦아서 적용시킨다.
         * */

        //등록
        DefaultConversionService conversionService = new DefaultConversionService();
        conversionService.addConverter(new StringToInteger());
        conversionService.addConverter(new IntegerToStringConverter());
        conversionService.addConverter(new IpPortToStringConverter());
        conversionService.addConverter(new StringToIpPortConverter());


        assertThat(conversionService.convert("10",Integer.class)).isEqualTo(10);
        assertThat(conversionService.convert(10,String.class)).isEqualTo("10");

        IpPort result = conversionService.convert("127.0.0.1:8080",IpPort.class);
        assertThat(result).isEqualTo(new IpPort("127.0.0.1",8080));

        String ipPortString = conversionService.convert(new IpPort("127.0.0.1", 8080), String.class);
        assertThat(ipPortString).isEqualTo("127.0.0.1:8080");
    }

}
