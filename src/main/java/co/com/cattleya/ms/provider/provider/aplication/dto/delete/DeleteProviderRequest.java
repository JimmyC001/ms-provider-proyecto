package co.com.cattleya.ms.provider.provider.aplication.dto.delete;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class DeleteProviderRequest {
    private String name;

}
