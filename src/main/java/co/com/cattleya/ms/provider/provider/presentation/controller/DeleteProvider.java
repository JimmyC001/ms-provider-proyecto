package co.com.cattleya.ms.provider.provider.presentation.controller;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.aplication.dto.delete.DeleteProviderRequest;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("provider")
public class DeleteProvider {
    private final ProviderService service;
    @Autowired
    public DeleteProvider(ProviderService service) {
        this.service = service;
    }
    @DeleteMapping
    public ResponseEntity<Provider> deleteProviders(@RequestBody DeleteProviderRequest request){
        if (request == null)
            return ResponseEntity.badRequest().build();
        Provider provider = service.deleteProvider(Provider.builder()
                        .name(request.getName())
                .build());
        if(provider == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(provider);
    }

}
