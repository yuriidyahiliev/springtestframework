package ui;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import ui.utils.BrowserConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = BrowserConfig.class)
public class BaseTest {
}
