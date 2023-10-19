package msa.chapter05.controller;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import lombok.Getter;

@Getter
public class HotelRoomResponse {
    @JsonProperty("id")
    @JsonSerialize(using= ToStringSerializer.class)
    private final Long hotelRoomId;
    private final String roomNumber;

    private HotelRoomResponse(Long hotelRoomId, String roomNumber, Long hotelRoomId1, String roomNumber1){
        this.hotelRoomId = hotelRoomId1;

        this.roomNumber = roomNumber1;
    }
}
