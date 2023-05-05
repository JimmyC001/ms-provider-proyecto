package co.com.cattleya.ms.provider.social.presentation;
import co.com.cattleya.ms.provider.phone.domain.model.Phone;
import co.com.cattleya.ms.provider.provider.domain.model.Provider;
import co.com.cattleya.ms.provider.provider.domain.service.ProviderService;
import co.com.cattleya.ms.provider.social.domain.model.SocialMedia;
import co.com.cattleya.ms.provider.social.domain.service.SocialMediaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("provider")
public class DeleteSocial {
    

    private final ProviderService providerService;
    private  final SocialMediaService socialMediaService;
    @Autowired
    public DeleteSocial(ProviderService providerService, SocialMediaService socialMediaService) {
        this.providerService = providerService;
        this.socialMediaService = socialMediaService;
    }

    @DeleteMapping("/{provider}/SocialMedia/{id}")
    public ResponseEntity<SocialMedia> deletePhone(@PathVariable("provider")  Long provider , @PathVariable("id") Long id ){
        if(provider == null || id == null)
            return ResponseEntity.badRequest().build();
        Provider founded = providerService.findProvider(provider);
        if(founded == null)
            return ResponseEntity.notFound().build();
        SocialMedia dbSocial = socialMediaService.deleteSocialMedia(providerService.deleteProviderSocialMedia(founded, id));
        if(dbSocial == null)
            return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dbSocial);
    }


}

