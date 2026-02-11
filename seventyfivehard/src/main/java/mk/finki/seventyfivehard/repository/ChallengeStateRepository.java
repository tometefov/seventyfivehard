package mk.finki.seventyfivehard.repository;
import mk.finki.seventyfivehard.model.ChallengeState;
import mk.finki.seventyfivehard.model.DailyTask;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ChallengeStateRepository extends JpaRepository<ChallengeState, Long> {

}