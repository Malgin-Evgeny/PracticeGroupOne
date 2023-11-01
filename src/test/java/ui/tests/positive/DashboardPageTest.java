package ui.tests.positive;

import org.testng.annotations.Test;
import ui.pages.DashBoardPanel;

public class DashboardPageTest extends DashBoardPanel {
    @Test
    public void brightnessTest (){
        changeColorToBlack();
    }
}
