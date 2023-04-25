package co.com.cattleya.ms.provider.phone.presentation.controller;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.phone.domain.service.PhoneService;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("provider")
public class GetPhones {
    private final PhoneService  phoneservice;
    private final ProviderService providerService;

    @Autowired
    public GetPhones(PhoneService phoneservice, ProviderService providerService){
        this.phoneservice = phoneservice;
        this.providerService = providerService;
    }
    @GetMapping("/{provider}/phone")
    public ResponseEntity<List<Phone>> getAllPhones(@PathVariable("provider") Long provider){
        List<Phone> phones;
        if(provider == null)
            return ResponseEntity.badRequest().build();
        Provider dbprovider = providerService.findProvider(provider);

        if(dbprovider == null)
            return ResponseEntity.notFound().build();
        phones = phoneservice.findByProviderId(provider);
        return ResponseEntity.ok(phones);
    }
}
