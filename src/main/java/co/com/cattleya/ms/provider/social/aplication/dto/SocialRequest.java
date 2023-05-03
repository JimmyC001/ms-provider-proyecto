package co.com.cattleya.ms.provider.social.aplication.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class SocialRequest {
    private int id;
    private String link;
    private String name;
    private String username;
    private Long provider_id;

}
