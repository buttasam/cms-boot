package app.admin.form;


import jakarta.validation.constraints.NotNull;
import lombok.Data;


/**
 * @author Samuel Butta
 */
@Data
public class ProductForm {

    private Long productId;

    private String title;

    @NotNull
    private Double price;


}
