package co.com.cattleya.ms.provider.provider.presentation.controller;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("provider")
public class GetAllProviders {
    private final ProviderService service;
    @Autowired
    public GetAllProviders(ProviderService service){
        this.service = service;
    }
    @GetMapping
    public ResponseEntity<List<Provider>> getAllProviders(){
        List<Provider> providers = service.findAll();
        List<Provider> filteredProviders = providers.stream()
                .filter(Provider::getStatus)
                .collect(Collectors.toList());
        if(providers.isEmpty())
            return ResponseEntity.noContent().build();
        return ResponseEntity.ok(filteredProviders);
    }
}
