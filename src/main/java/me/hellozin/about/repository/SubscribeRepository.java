package me.hellozin.about.repository;

import java.util.List;
import me.hellozin.about.entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {

    List<Subscribe> findAllByProducerId(long producerId);

    List<Subscribe> findAllByConsumerId(long consumerId);

}
