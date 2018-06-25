package app.admin.form;


import lombok.Data;

import javax.validation.constraints.NotNull;

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
