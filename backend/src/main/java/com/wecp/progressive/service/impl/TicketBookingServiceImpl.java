package com.wecp.progressive.service.impl;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wecp.progressive.entity.TicketBooking;
import com.wecp.progressive.repository.TicketBookingRepository;
import com.wecp.progressive.service.TicketBookingService;

@Service
public class TicketBookingServiceImpl implements TicketBookingService {

@Autowired
private TicketBookingRepository ticketBookingRepository;

public List<TicketBooking> getAllTicketBookings() throws SQLException
{
    return ticketBookingRepository.findAll();
}
public int createBooking(TicketBooking ticketBooking) throws SQLException
{
    return ticketBookingRepository.save(ticketBooking).getBookingId();
}
public void cancelBooking(int bookingId) throws SQLException
{
    if(ticketBookingRepository.existsById(bookingId))
    {
        ticketBookingRepository.deleteById(bookingId);
    }
}
public List<TicketBooking> getBookingsByUserEmail(String Email) throws SQLException
{
    return ticketBookingRepository.findByEmail(Email);
}
}