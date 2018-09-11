package ru.website.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.website.data.model.Feedback;
import ru.website.data.model.repositories.FeedbackRepository;

/**
 * Created by libragimov on 15.03.2018.
 */
@Service
public class TrafficServiceImpl implements TrafficService {

    private final FeedbackRepository feedbackRepository;

    @Autowired
    public TrafficServiceImpl(FeedbackRepository feedbackRepository) {
        this.feedbackRepository = feedbackRepository;
    }

    @Transactional
    public void saveFeedback(Feedback feedback) {
        feedbackRepository.save(feedback);
    }
}
