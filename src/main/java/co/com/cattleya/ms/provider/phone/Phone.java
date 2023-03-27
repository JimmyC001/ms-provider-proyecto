package co.com.cattleya.ms.provider.phone;

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
@Entity(name = "phone")
public class Phone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer extension;
    private Long number;
    @ManyToOne(cascade = CascadeType.ALL)
    private Provider provider;
}
