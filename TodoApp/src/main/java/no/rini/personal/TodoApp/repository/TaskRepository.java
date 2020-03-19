package no.rini.personal.TodoApp.repositroy;

import no.rini.personal.TodoApp.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface TaskRepository extends JpaRepository<Task,Integer> {
}
