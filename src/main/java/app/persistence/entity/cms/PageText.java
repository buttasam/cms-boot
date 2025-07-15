package app.persistence.entity.cms;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Lob;
import lombok.Data;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
/**
 * @author Samuel Butta
 */

@Entity
@Data
public class PageText {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Lob
    @Column
    private String content;

    @Column(unique = true)
    private String identity;

    @ManyToOne
    private Page page;

    @Column
    @Enumerated(EnumType.STRING)
    private PageTextType type;

    public boolean isCKEditor() {
        return type != null && type.equals(PageTextType.CK_EDITOR);
    }

    public boolean isTextBox() {
        return type != null && type.equals(PageTextType.TEXT_BOX);
    }
}
