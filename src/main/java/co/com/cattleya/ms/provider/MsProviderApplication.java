package co.com.cattleya.ms.provider;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class MsProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(MsProviderApplication.class, args);
    }

}
