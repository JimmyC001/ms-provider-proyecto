package co.com.cattleya.ms.provider.social.presentation;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import co.com.cattleya.ms.provider.social.domain.service.SocialMediaService;

import java.util.List;


@RestController
@RequestMapping ("provider")
public class GetSocial {

    private final ProviderService provider;
    private final SocialMediaService service;

    @Autowired

    public GetSocial(SocialMediaService service, ProviderService provider) {
        this.service = service;
        this.provider = provider;
    }

    @GetMapping("{id}/social")
    public ResponseEntity<List<SocialMedia>> create(@PathVariable("id") Long id) {

        List<SocialMedia> redes;
        if (id == null)
            return ResponseEntity.badRequest().build();
        Provider dbprovider = provider.findProvider(id);

        if (dbprovider == null)
            return ResponseEntity.notFound().build();
        redes = service.findByProvider(dbprovider);
        return ResponseEntity.ok(redes);
    }
}
