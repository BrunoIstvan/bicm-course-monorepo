package br.com.bicmonteiro.bicmworker.repositories;

import br.com.bicmonteiro.bicmworker.entities.WorkerModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<WorkerModel, Long> {

}
