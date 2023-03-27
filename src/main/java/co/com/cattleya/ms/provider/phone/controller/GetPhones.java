package co.com.cattleya.ms.provider.phone.controller;

import co.com.cattleya.ms.provider.phone.Phone;
import co.com.cattleya.ms.provider.phone.service.PhoneService;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("phone")
public class GetPhones {
    private final PhoneService service;
    @Autowired
    public GetPhones(PhoneService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Phone>> getAllPhones(@QueryParam("id") Long id){
        List<Phone> phones;
        if(id != null)
            phones = service.findByProviderId(id);
        else
            phones = service.findAll();
        if(phones.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(phones);
    }
}
