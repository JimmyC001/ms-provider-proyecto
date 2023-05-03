package co.com.cattleya.ms.provider.phone.presentation.controller;
import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.phone.aplication.dto.PhoneRequest;
import co.com.cattleya.ms.provider.phone.aplication.dto.PhoneResponse;
import co.com.cattleya.ms.provider.phone.domain.service.PhoneService;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("provider")
public class PostPhone {
    private final PhoneService service;
    private final ProviderService provider;
    @Autowired
    public PostPhone(PhoneService service, ProviderService provider) {
        this.service = service;
        this.provider = provider;
    }
    @PostMapping("{id}/phone")
    public ResponseEntity<PhoneResponse> create(@PathVariable("id") Long id , @RequestBody PhoneRequest request) {
        if (request == null)
            return ResponseEntity.badRequest().build();
        Provider prov = provider.findProvider(id);
        if(prov == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        Phone result = service.savePhone(Phone.builder()
                .extension(request.getExtension())
                .number(request.getNumber())
                .provider(prov)
                .build());
        return ResponseEntity.ok(new PhoneResponse(result.getExtension(), result.getNumber()));
    }
}
