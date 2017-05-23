import config.CoreConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import service.RestTrip;
import service.beans.CbcTripInfo;

import java.net.URISyntaxException;
import java.util.Arrays;
import java.util.List;

public class TestRestWS {

    public static void main(String[] args) throws URISyntaxException {
        AnnotationConfigApplicationContext configApplicationContext = new AnnotationConfigApplicationContext();
        configApplicationContext.register(CoreConfig.class);
        configApplicationContext.refresh();
        System.out.println(Arrays.toString(configApplicationContext.getBeanDefinitionNames()));
        RestTrip restTrip = (RestTrip) configApplicationContext.getBean("restTrip");
        List<CbcTripInfo> response = restTrip.getTripsByDriver(Long.valueOf(1));
        System.out.println(response.toString());
    }
}
