package ru.kpfu.itis.model.jaxb;

import ru.kpfu.itis.model.Automobile;
import ru.kpfu.itis.model.Booking;
import ru.kpfu.itis.model.Driver;
import ru.kpfu.itis.model.Trip;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Liia
 */
public class TripConverter {

    public void convert() {
        Trip trip = new Trip();
        trip.setId(Long.valueOf(1));
        trip.setAuto(new Automobile());
        trip.setBookings(new ArrayList<Booking>());
        trip.setCount(3);
        trip.setDate(new Date());
        trip.setDestination("Africa");
        trip.setDeparture("");
        trip.setDriver(new Driver());
        try {

            File file = new File("C:\\file.xml");
            JAXBContext jaxbContext = JAXBContext.newInstance(Trip.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();

            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

            jaxbMarshaller.marshal(trip, file);
            jaxbMarshaller.marshal(trip, System.out);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }
}
