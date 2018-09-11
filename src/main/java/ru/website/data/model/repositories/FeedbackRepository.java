package ru.website.data.model.repositories;

import org.springframework.data.repository.CrudRepository;
import ru.website.data.model.Feedback;

/**
 * Created by FAMILY on 11.09.2018.
 */
public interface FeedbackRepository extends CrudRepository<Feedback, String> {
}