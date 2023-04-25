package co.com.cattleya.ms.provider.provider.presentation.controller;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.aplication.dto.update.UpdateProviderRequest;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("provider")
public class PutProvider {

    private final ProviderService service;

    @Autowired
    public PutProvider(ProviderService service) {
        this.service = service;
    }

    @PutMapping
    public ResponseEntity<Provider> update( @RequestBody UpdateProviderRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Provider provider = service.updateProvider(Provider.builder()
                .name(request.getName())
                .description(request.getDescription())
                .photo(request.getPhoto())
                .web(request.getWeb())
                .status(request.getStatus())
                .build());
        if (provider == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(provider);
    }
}
