package co.com.cattleya.ms.provider.phone.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PhoneResponse {
    private String phone;
    public PhoneResponse(Integer ext, Long number){
        this.phone = "+" + ext + "-" + number;
    }
}
