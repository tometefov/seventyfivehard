package mk.finki.seventyfivehard.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class DayStatusDto {

    private Long challengeId;
    private int currentDay;
    private List<DailyTaskDto> tasks;
}
