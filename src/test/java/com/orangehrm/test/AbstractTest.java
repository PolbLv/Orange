package com.orangehrm.test;

import com.orangehrm.app.OrangeHRMPage;
import com.orangehrm.tools.App;
import com.orangehrm.tools.AppTest;

/**
 * Created by Serhiy on 7/8/17.
 */
public class AbstractTest implements AppTest {

    protected OrangeHRMPage orangeHRMPage = new OrangeHRMPage();

    @Override
    public App getTestedApp() {
        return this.orangeHRMPage;
    }
}
