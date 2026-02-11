package mk.finki.seventyfivehard.config;

import jakarta.annotation.PostConstruct;
import mk.finki.seventyfivehard.model.ChallengeState;
import mk.finki.seventyfivehard.model.DailyTask;
import mk.finki.seventyfivehard.repository.ChallengeStateRepository;
import mk.finki.seventyfivehard.repository.DailyTaskRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final DailyTaskRepository taskRepository;
    private final ChallengeStateRepository challengeStateRepository;

    public DataInitializer(DailyTaskRepository taskRepository, ChallengeStateRepository challengeStateRepository) {
        this.taskRepository = taskRepository;
        this.challengeStateRepository = challengeStateRepository;
    }

    @PostConstruct
    public void init() {

        if (taskRepository.count() == 0) {
            taskRepository.saveAll(List.of(
                    new DailyTask("Wake up before 8am"),
                    new DailyTask("Drink water with salt / electrolytes / lemon"),
                    new DailyTask("Get morning sunlight"),
                    new DailyTask("Exercise at least 90 minutes"),
                    new DailyTask("Follow diet / no junk food")
            ));
        }

        if (challengeStateRepository.count() == 0) {
            ChallengeState state = new ChallengeState();
            state.setCurrentDay(1);
            challengeStateRepository.save(state);
        }
    }

}
