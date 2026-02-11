package mk.finki.seventyfivehard.controller;

import mk.finki.seventyfivehard.model.DailyTask;
import mk.finki.seventyfivehard.repository.DailyTaskRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:5173")
@RestController
@RequestMapping("/api/tasks")
public class DailyTaskController {

    private final DailyTaskRepository repository;

    public DailyTaskController(DailyTaskRepository repository) {
        this.repository = repository;
    }

//    // GET all tasks
//    @GetMapping
//    public List<DailyTask> getAll() {
//        return repository.findAll();
//    }

    // Toggle task completion
    @PutMapping("/{id}/toggle")
    public DailyTask toggle(@PathVariable Long id) {
        DailyTask task = repository.findById(id).orElseThrow();
        task.setCompleted(!task.isCompleted());
        return repository.save(task);
    }

    // Reset all tasks (NEW DAY)
//    @PostMapping("/reset")
//    public void reset() {
//        repository.findAll().forEach(task -> {
//            task.setCompleted(false);
//            repository.save(task);
//        });
//    }
}
