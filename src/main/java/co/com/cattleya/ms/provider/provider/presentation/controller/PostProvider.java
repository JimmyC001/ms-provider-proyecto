package co.com.cattleya.ms.provider.provider.presentation.controller;

import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.aplication.dto.create.CreateProviderRequest;
import co.com.cattleya.ms.provider.provider.aplication.dto.create.CreateProviderResponse;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("provider")
public class PostProvider {
    private final ProviderService service;

    @Autowired
    public PostProvider(ProviderService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<CreateProviderResponse> create(@RequestBody CreateProviderRequest request) {
        if (request == null)
            return ResponseEntity.noContent().build();
        Provider provider = service.saveProvider(Provider.builder()
                .name(request.getName())
                .description(request.getDescription())
                .photo(request.getPhoto())
                .web(request.getWeb())
                .status(true)
            .build());
        if(provider == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.status(HttpStatus.CREATED).body(CreateProviderResponse.builder()
                .name(provider.getName())
                .description(provider.getDescription())
                .photo(provider.getPhoto())
                .web(provider.getWeb())
                .build());
    }
}
