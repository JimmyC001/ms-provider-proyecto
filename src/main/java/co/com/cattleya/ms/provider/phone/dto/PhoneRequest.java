package co.com.cattleya.ms.provider.phone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneRequest {
    private Integer extension;
    private Long number;
    private Long providerId;
}
