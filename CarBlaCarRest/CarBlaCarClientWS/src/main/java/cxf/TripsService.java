package cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 2.7.18
 * 2017-05-02T17:48:50.741+03:00
 * Generated source version: 2.7.18
 * 
 */
@WebService(targetNamespace = "http://service.itis.kpfu.ru/", name = "TripsService")
@XmlSeeAlso({ObjectFactory.class})
public interface TripsService {

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findByStatusOrderDate", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindByStatusOrderDate")
    @WebMethod
    @ResponseWrapper(localName = "findByStatusOrderDateResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindByStatusOrderDateResponse")
    public java.util.List<cxf.Trip> findByStatusOrderDate();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAllOrderDate", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindAllOrderDate")
    @WebMethod
    @ResponseWrapper(localName = "findAllOrderDateResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindAllOrderDateResponse")
    public java.util.List<cxf.Trip> findAllOrderDate();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findById", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindById")
    @WebMethod
    @ResponseWrapper(localName = "findByIdResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindByIdResponse")
    public cxf.Trip findById(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.Long arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "lastEndsTripsForMonth", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.LastEndsTripsForMonth")
    @WebMethod
    @ResponseWrapper(localName = "lastEndsTripsForMonthResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.LastEndsTripsForMonthResponse")
    public java.util.List<cxf.Trip> lastEndsTripsForMonth(
        @WebParam(name = "arg0", targetNamespace = "")
        cxf.User arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "addTrip", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.AddTrip")
    @WebMethod
    @ResponseWrapper(localName = "addTripResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.AddTripResponse")
    public cxf.Trip addTrip(
        @WebParam(name = "arg0", targetNamespace = "")
        cxf.Trip arg0
    );

    @RequestWrapper(localName = "update", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.Update")
    @WebMethod
    @ResponseWrapper(localName = "updateResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.UpdateResponse")
    public void update(
        @WebParam(name = "arg0", targetNamespace = "")
        cxf.Trip arg0
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "lastTrips", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.LastTrips")
    @WebMethod
    @ResponseWrapper(localName = "lastTripsResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.LastTripsResponse")
    public java.util.List<cxf.Trip> lastTrips();

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findBySearch", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindBySearch")
    @WebMethod
    @ResponseWrapper(localName = "findBySearchResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindBySearchResponse")
    public java.util.List<cxf.Trip> findBySearch(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0,
        @WebParam(name = "arg1", targetNamespace = "")
        java.lang.String arg1
    );

    @WebResult(name = "return", targetNamespace = "")
    @RequestWrapper(localName = "findAll", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindAll")
    @WebMethod
    @ResponseWrapper(localName = "findAllResponse", targetNamespace = "http://service.itis.kpfu.ru/", className = "cxf.FindAllResponse")
    public java.util.List<cxf.Trip> findAll();
}
