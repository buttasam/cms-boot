package app.front.form;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Samuel Butta
 */

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderForm {

    private String companyName;
    private String address;
    private String contactPerson;
    private String email;
    private String phone;
    private String ico;
    private String dic;
    private String subject; // products
    private String deliveryDate;

}
