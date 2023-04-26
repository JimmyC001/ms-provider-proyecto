package co.com.cattleya.ms.provider.phone.presentation.controller;

import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.phone.domain.service.PhoneService;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class DeletePhone {
    private final PhoneService phoneservice;
    private final ProviderService providerService;
    @Autowired
    public DeletePhone(PhoneService phoneservice, ProviderService providerService){
        this.phoneservice = phoneservice;
        this.providerService = providerService;
    }
    @DeleteMapping("/{provider}/phone/{id}")
    public ResponseEntity<Phone> deletePhone(@PathVariable("provider")  Long provider , @PathVariable("id") Long id ){
        if(provider == null || id == null)
            return ResponseEntity.badRequest().build();
        Provider founded = providerService.findProvider(provider);
        if(founded == null)
            return ResponseEntity.notFound().build();
        Phone dbphone = phoneservice.deletePhone(providerService.deleteProviderPhone(founded, id));
        if(dbphone == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dbphone);
    }

}
