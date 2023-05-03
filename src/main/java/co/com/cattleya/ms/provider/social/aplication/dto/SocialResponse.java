package co.com.cattleya.ms.provider.social.aplication.dto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SocialResponse {
    private String link;
    private String name;
    private String username;


}

