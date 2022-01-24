package com.spring.springboot.model;

import com.spring.springboot.entity.TodoEntity;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
@EqualsAndHashCode
public class FullTodo {
    private Long id;
    private String title;
    private Boolean completed;
    private String description;
    private String username;

    public static FullTodo toModel(TodoEntity entity) {
        FullTodo model = new FullTodo();
        model.setId(entity.getId());
        model.setCompleted(entity.getCompleted());
        model.setTitle(entity.getTitle());
        model.setDescription(entity.getDescription());
        model.setUsername(entity.getUser().getUsername());
        return model;
    }
}
