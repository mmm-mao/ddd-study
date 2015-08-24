package jp.co.biglobe.outsource.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"classpath:context.xml"})
public class BIGLOBEIDとBIGLOBEパスワードを発番するサービスTest {

    @Autowired
    private BIGLOBEIDとBIGLOBEパスワードを発番するサービス sut;

    @Test
    public void testBIGLOBEID発番() throws Exception {
        String actual = sut.BIGLOBEID発番();
        assertThat(actual, is("BIGLOBE0000000001"));
    }

    @Test
    public void testBIGLOBEパスワード発番() throws Exception {
        String actual = sut.BIGLOBEパスワード発番();
        assertThat(actual, is("!\"#$%&'()0=~|"));
    }
}