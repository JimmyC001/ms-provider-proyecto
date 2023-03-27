package co.com.cattleya.ms.provider.provider.controller;

import co.com.cattleya.ms.provider.provider.Provider;
import co.com.cattleya.ms.provider.provider.dto.ProviderRequest;
import co.com.cattleya.ms.provider.provider.dto.ProviderResponse;
import co.com.cattleya.ms.provider.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public ResponseEntity<ProviderResponse> create(@RequestBody ProviderRequest request) {
        if (request == null)
            return ResponseEntity.noContent().build();
        Provider provider = service.saveProvider(Provider.builder()
                .name(request.getName())
                .description(request.getDescription())
                .photo(request.getPhoto())
                .web(request.getWeb())
                .build());
        if(provider == null)
            return ResponseEntity.badRequest().build();
        return ResponseEntity.ok(ProviderResponse.builder()
                .name(provider.getName())
                .description(provider.getDescription())
                .photo(provider.getPhoto())
                .web(provider.getWeb())
                .build());
    }
}
