package mk.finki.seventyfivehard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class DailyTaskDto {

    private Long id;
    private String name;
    private boolean completed;
}
