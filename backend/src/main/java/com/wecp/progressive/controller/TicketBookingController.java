package com.wecp.progressive.controller;

import com.wecp.progressive.entity.TicketBooking;
import com.wecp.progressive.service.TicketBookingService;
import com.wecp.progressive.service.impl.TicketBookingServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;
@RestController
@RequestMapping("/ticket")
public class TicketBookingController {
    @Autowired
    TicketBookingServiceImpl ticketBookingService;
    @GetMapping
    public ResponseEntity<List<TicketBooking>> getAllTicketBookings() {
        try{
              List<TicketBooking> ticketBookings = ticketBookingService.getAllTicketBookings();
            return new ResponseEntity<>(ticketBookings, HttpStatus.OK);
        }catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }  
    @PostMapping
    public ResponseEntity<Integer> createBooking(@RequestBody TicketBooking ticketBooking) {
       try{ int bookingId = ticketBookingService.createBooking(ticketBooking);
        return new ResponseEntity<>(bookingId, HttpStatus.CREATED);
       }catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @DeleteMapping("/{bookingID}")
    public ResponseEntity<Void> cancelBooking(@PathVariable int bookingID) {
       try{ ticketBookingService.cancelBooking(bookingID);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
       }catch (SQLException e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<List<TicketBooking>> getBookingsByUserEmail(@PathVariable String email) {
     try{        List<TicketBooking> ticketBookings = ticketBookingService.getBookingsByUserEmail(email);
        return new ResponseEntity<>(ticketBookings, HttpStatus.OK); 
       
    }catch (SQLException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}