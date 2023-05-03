package co.com.cattleya.ms.provider.social.presentation;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import co.com.cattleya.ms.provider.phone.aplication.dto.PhoneResponse;
import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import co.com.cattleya.ms.provider.social.aplication.dto.SocialRequest;
import co.com.cattleya.ms.provider.social.aplication.dto.SocialResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.cattleya.ms.provider.social.domain.service.SocialMediaService;


@RestController
@RequestMapping ("provider")
public class PostSocial {

    private final ProviderService provider;
    private final SocialMediaService service;
    @Autowired
    public PostSocial(ProviderService provider, SocialMediaService service) {
        this.provider = provider;
        this.service = service;
    }

    @PostMapping("{id}/social")
    public ResponseEntity<SocialResponse> create(@PathVariable("id") Long id , @RequestBody SocialRequest request){
        if (request == null)
            return ResponseEntity.badRequest().build();
        Provider prov = provider.findProvider(id);
        if(prov == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        SocialMedia red = service.saveSocial(SocialMedia.builder()
                        .link(request.getLink())
                        .name(request.getName())
                        .username(request.getUsername())
                        .provider(prov)
                .build());
        return ResponseEntity.ok(SocialResponse.builder()
                .link(request.getLink())
                .name(request.getName())
                .username(request.getUsername())

                .build());
    }
}
