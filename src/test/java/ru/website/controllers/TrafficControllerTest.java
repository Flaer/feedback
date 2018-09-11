package ru.website.controllers;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.website.data.AsyncSaver;
import ru.website.data.TrafficService;
import ru.website.data.model.Feedback;

/**
 * Created by libragimov on 16.03.2018.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(value = TrafficController.class, secure = false)
public class TrafficControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TrafficService trafficService;

    @MockBean
    private AsyncSaver saver;


    @Test
    public void FeedbackCorrectResponse() throws Exception {

        Mockito.doNothing().when(
                saver).saveFeedback(Mockito.any(Feedback.class));

        String exampleFeedback = "{\"id\":\"1\",\"positive\":\"qq\",\"negative\":\"mm\",\"wishes\":\"gl hf\"}";

        RequestBuilder requestBuilder = MockMvcRequestBuilders
                .post("/feedback")
                .accept(MediaType.APPLICATION_JSON).content(exampleFeedback)
                .contentType(MediaType.APPLICATION_JSON);

        MvcResult result = mockMvc.perform(requestBuilder).andReturn();
        // void result
        Assert.assertEquals("", result.getResponse().getContentAsString());

        Mockito.verify(saver).saveFeedback(Mockito.any(Feedback.class));
    }

}
