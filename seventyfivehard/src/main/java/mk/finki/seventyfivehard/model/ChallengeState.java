package mk.finki.seventyfivehard.model;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
//@NoArgsConstructor
public class ChallengeState {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int currentDay;

    public ChallengeState() {
    }
}
