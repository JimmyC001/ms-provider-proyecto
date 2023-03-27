package co.com.cattleya.ms.provider.phone.controller;

import co.com.cattleya.ms.provider.phone.Phone;
import co.com.cattleya.ms.provider.phone.dto.PhoneResponse;
import co.com.cattleya.ms.provider.phone.dto.PhoneRequest;
import co.com.cattleya.ms.provider.phone.service.PhoneService;
import co.com.cattleya.ms.provider.provider.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("phone")
public class PostPhone {
    private final PhoneService service;
    private final ProviderService provider;
    @Autowired
    public PostPhone(PhoneService service, ProviderService provider) {
        this.service = service;
        this.provider = provider;
    }
    @PostMapping
    public ResponseEntity<PhoneResponse> create(@RequestBody PhoneRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Phone result = service.savePhone(Phone.builder()
                .extension(request.getExtension())
                .number(request.getNumber())
                .provider(provider.findProvider(request.getProviderId()))
                .build());
        return ResponseEntity.ok(new PhoneResponse(result.getExtension(), result.getNumber()));
    }
}
