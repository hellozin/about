package me.hellozin.about.service;

import java.util.List;
import me.hellozin.about.entity.Subscribe;
import me.hellozin.about.repository.SubscribeRepository;
import org.springframework.stereotype.Service;

@Service
public class SubscribeService {

    private final SubscribeRepository subscribeRepository;

    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }

    public Subscribe subscribe(long actorId, long producerId) {
        Subscribe subscribe = new Subscribe(producerId, actorId);
        return subscribeRepository.save(subscribe);
    }

    public void unSubscribe(long actorId, long producerId) {
        List<Subscribe> subscribes = subscribeRepository.findAllByConsumerId(actorId);

        for (Subscribe subscribe : subscribes) {
            if (subscribe.getProducerId() == producerId) {
                subscribeRepository.delete(subscribe);
                return;
            }
        }
    }

    public List<Subscribe> getAllSubscribesByConsumerId(long consumerId) {
        return subscribeRepository.findAllByConsumerId(consumerId);
    }
}
