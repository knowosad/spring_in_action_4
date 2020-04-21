package spittr.web;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.Spitter;
import spittr.Spittle;
import spittr.data.SpitterRepository;
import spittr.data.SpittleRepository;
import spittr.web.SpitterController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.Matchers.hasItems;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class SpitterControllerTest {

  @Test
  public void shouldShowRegistration() throws Exception {
    SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);

    SpitterController controller = new SpitterController(mockRepository);
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    mockMvc.perform(get("/spitter/register"))
        .andExpect(view().name("registerForm"));
  }

  @Test
  public void testSpitter() throws Exception {
    Spitter expectedSpitter = new Spitter("test", "test", "tst", "tst");
    SpitterRepository mockRepository = Mockito.mock(SpitterRepository.class);
    Mockito.when(mockRepository.findByUsername("tst")).thenReturn(expectedSpitter);

    SpitterController controller = new SpitterController(mockRepository);
    MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();

    mockMvc.perform(get("/spitter/tst"))
        .andExpect(view().name("profile"))
        .andExpect(model().attributeExists("spitter"))
        .andExpect(model().attribute("spitter", expectedSpitter));
  }

}
