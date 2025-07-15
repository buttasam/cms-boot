package app.admin.form;

import lombok.Data;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @author Samuel Butta
 */
@Data
public class PageForm {

    @NotNull
    @Size(min=2, max=30)
    private String title;

    @NotNull
    private String url;

    private Long parentPageId;

}
