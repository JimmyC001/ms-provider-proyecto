package co.com.cattleya.ms.provider.social;

import co.com.cattleya.ms.provider.provider.Provider;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "social_media")
public class SocialMedia {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String link;
    private String name;
    private String username;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "provider_id", referencedColumnName = "id", nullable = false)
    private Provider provider;
}
