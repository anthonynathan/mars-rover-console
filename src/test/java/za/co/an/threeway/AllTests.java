package za.co.an.threeway;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.SuiteDisplayName;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SuiteDisplayName("JUnit Platform Suite Demo")
@SelectClasses({
        TopCoordinateTests.class,
        ActiveRoverStartPositionTests.class,
        ActiveRoverMovementTests.class
})
class AllTests {
}
