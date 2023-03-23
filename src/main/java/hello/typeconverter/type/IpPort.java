package hello.typeconverter.type;

import lombok.EqualsAndHashCode;
import lombok.Getter;

//"127
@Getter
@EqualsAndHashCode
/*
* equals :  두 객체의 내용이 같은지, 동등성(equality) 를 비교하는 연산자
* hashCode : 두 객체가 같은 객체인지, 동일성(identity) 를 비교하는 연산자
* 이 두개를 합친 기능의 어노테이션 -> @EqualsAndHashCode
* */
public class IpPort {
    private String ip;
    private int port;

    public IpPort(String ip, int port){
        this.ip = ip;
        this.port = port;
    }

}
