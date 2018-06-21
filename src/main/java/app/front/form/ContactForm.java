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
public class ContactForm {

    private String email;

    private String message;

}
