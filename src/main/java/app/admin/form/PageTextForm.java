package app.admin.form;

import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author Samuel Butta
 */
@Data
public class PageTextForm {

    @NotNull
    private String identity;

    @NotNull
    private String content;

    @NotNull
    private Long pageId;

}
