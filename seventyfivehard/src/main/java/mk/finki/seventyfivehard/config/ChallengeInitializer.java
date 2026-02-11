package mk.finki.seventyfivehard.config;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import mk.finki.seventyfivehard.model.ChallengeState;
import mk.finki.seventyfivehard.repository.ChallengeStateRepository;
import org.springframework.stereotype.Component;
//
//@Component
//@RequiredArgsConstructor
//public class ChallengeInitializer {
//
//    private final ChallengeStateRepository repository;
//
//    @PostConstruct
//    public void init() {
//        repository.findById(1L).orElseGet(() -> {
//            ChallengeState state = new ChallengeState();
//            state.setCurrentDay(1);
//            return repository.save(state);
//        });
//    }
//}