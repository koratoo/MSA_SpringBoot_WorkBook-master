package msa.chapter05.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.IdGenerator;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class HotelRoomController {

    /**
     * Get /hotels/{hotelId}/rooms/{roomNumber}?fromDate={yyyyMMdd}&toDate={yyyyMMdd}
     * hotelId : Long 타입 필수
     * roomNumber : String Type 필수
     * fromDate, toDate : String 타입이며 선택
     *
     * 응답
     * "id" : "1201928183",
     * "roomNumber" : "West-Wing-3928",
     * "numberOfBeds" : 2,
     * "roomType" : "deluxe",
     * "originalPrice" : "150.00",
     * "reservations" : [
     *  {
     *      "id" : "129171201928183"
     *      "reservedDate" : "{yyyy-MM-dd}"
     *  },{
     *      "id" : "129171201928183",
     *      "reservedDate" : "{yyyy-MM-dd}"
     *  }
     * ]
     */
    @GetMapping(path="/hotels/{hotelId}/rooms/{roomNumber}")
    public HotelRoomResponse getHotelRoomByPeriod(
            @PathVariable Long hotelId,
            @PathVariable String roomNumber,
            @RequestParam(value="fromDate",required = false)
            @DateTimeFormat(pattern = "yyyyMMdd")LocalDate fromDate,
            @RequestParam(value="toDate",required = false)
            @DateTimeFormat(pattern = "yyyyMMdd")LocalDate toDate
    ){
        return null;
    }
}

