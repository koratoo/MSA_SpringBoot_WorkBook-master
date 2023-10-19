package msa.chapter05.controller;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.Arrays;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * enum 클래스에서 마셜링, 언마셜링이 사용되었다.
 */
public enum HotelRoomType {

    SINGLE("single"),
    DOUBLE("double"),
    TRIPLE("triple"),
    QUAD("quad");

    private static final Map<String,HotelRoomType> paramMap =
            Arrays.stream(HotelRoomType.values())
                    .collect(Collectors.toMap(
                            HotelRoomType::getParam,
                            Function.identity()
                    ));
    private final String param;     //param변수는 마셜링 후 사용되는 JSON값 저장
    HotelRoomType(String param){    //SINGLE -> single로 저장
        this.param = param;
    }

    @JsonCreator                    //언마셜링 과정에서 값 변환에 사용되는 메서드를 지정하는 어노테이션
    public static HotelRoomType fromParam(String param){
        return Optional.ofNullable(param)
                .map(paramMap::get)
                .orElseThrow(()->new IllegalArgumentException("param is not valid"));
    }
    @JsonValue                      //마셜링 과정에서 값 변환에 사용되는 메서드를 지정하는 어노테이션
    public String getParam(){
        return this.param;
    }
}
