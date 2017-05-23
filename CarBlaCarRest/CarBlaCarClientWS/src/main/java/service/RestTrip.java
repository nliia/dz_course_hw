package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import service.beans.CbcTripInfo;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@Service
public class RestTrip {

    @Autowired
    RestTemplate restTemplate;

    public static final String API_URL = "http://localhost:8080/api/v1_0/trip/bydriver/";

    public CbcTripInfo getTripInfoById(long goodId) {
        try {
            ResponseEntity<CbcTripInfo> response = restTemplate.exchange(
                    API_URL, HttpMethod.GET, null, CbcTripInfo.class);
            return response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<CbcTripInfo> getTripsByDriver(Long id) throws URISyntaxException {
        try {
            ResponseEntity response = restTemplate.getForEntity(
                    API_URL + "{id}", CbcTripInfo.class, id);
            return (List<CbcTripInfo>) response.getBody();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
