package mk.finki.seventyfivehard.controller;

import lombok.RequiredArgsConstructor;
import mk.finki.seventyfivehard.dto.DailyTaskDto;
import mk.finki.seventyfivehard.dto.DayStatusDto;
import mk.finki.seventyfivehard.model.ChallengeState;
import mk.finki.seventyfivehard.model.DailyTask;
import mk.finki.seventyfivehard.repository.ChallengeStateRepository;
import mk.finki.seventyfivehard.repository.DailyTaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/day")
@RequiredArgsConstructor
public class DayController {

    private final DailyTaskRepository taskRepository;
    private final ChallengeStateRepository stateRepository;

    @PostMapping("/next")
    public DayStatusDto nextDay() {

        List<DailyTask> tasks = taskRepository.findAll();
        ChallengeState state = stateRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow();

        boolean allCompleted = tasks.stream().allMatch(DailyTask::isCompleted);

        if (allCompleted) {
            state.setCurrentDay(state.getCurrentDay() + 1);
        } else {
            state.setCurrentDay(1);
        }

        tasks.forEach(t -> t.setCompleted(false));
        taskRepository.saveAll(tasks);
        stateRepository.save(state);

        List<DailyTaskDto> taskDtos = tasks.stream()
                .map(t -> new DailyTaskDto(
                        t.getId(),
                        t.getName(),
                        t.isCompleted()
                ))
                .toList();

        return new DayStatusDto(
                state.getId(),
                state.getCurrentDay(),
                taskDtos
        );
    }


    @GetMapping("/")
    public DayStatusDto getStatus() {

        ChallengeState state = stateRepository.findAll()
                .stream()
                .findFirst()
                .orElseThrow();

        List<DailyTaskDto> taskDtos = taskRepository.findAll()
                .stream()
                .map(t -> new DailyTaskDto(
                        t.getId(),
                        t.getName(),
                        t.isCompleted()
                ))
                .toList();

        return new DayStatusDto(
                state.getId(),
                state.getCurrentDay(),
                taskDtos
        );
    }


//    @GetMapping("/")
//    public

//    @GetMapping("/status")
//    public ChallengeState status() {
//        return stateRepository.findById(1L).orElseThrow();
//    }
}
