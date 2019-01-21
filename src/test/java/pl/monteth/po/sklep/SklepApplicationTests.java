package pl.monteth.po.sklep;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;
import pl.monteth.po.sklep.Models.Pupil;

import javax.servlet.ServletContext;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SklepApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testPupil() {
        String email = "pupil@email.com";

//        getEmailTest
        Pupil pupil = new Pupil(email);
        assertEquals(email, pupil.getEmail());

//        setEmailTest
        String email2 = "pupil@email.com";
        Pupil pupil2 = new Pupil();
        pupil2.setEmail(email2);
        assertEquals(email2, pupil2.getEmail());

    }

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;
    @Before
    public void setup() throws Exception {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).dispatchOptions(true).build();

    }

    @Test
    public void testWac(){
        ServletContext servletContext = wac.getServletContext();

        Assert.assertNotNull(servletContext);
        Assert.assertTrue(servletContext instanceof MockServletContext);
    }



//    REST check if status is OK and JSON type
    @Test
    public void testPatronControllerStatus() throws Exception {
        MvcResult mvcResult =this.mockMvc.perform(get("/patron/email1@gmail.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andReturn();
        Assert.assertEquals(
                "application/json;charset=UTF-8",
                mvcResult.getResponse().getContentType());
    }

//    REST check if values are properly defined
    @Test
    public void testPatronControllerResult() throws Exception {
        MvcResult  mvcResult =this.mockMvc.perform(get("/patron/email1@gmail.com"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.idPatron", is(0)))
                .andExpect(jsonPath("$.firstName", is("Jimmie")))
                .andExpect(jsonPath("$.lastName", is("Fisher")))
                .andReturn();
        Assert.assertEquals(
                "application/json;charset=UTF-8",
                mvcResult.getResponse().getContentType());
    }


}

