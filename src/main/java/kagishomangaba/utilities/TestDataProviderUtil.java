package kagishomangaba.utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import static kagishomangaba.utilities.JsonReaderUtil.getJsonDataToMap;

public class TestDataProviderUtil {

    @DataProvider(name = "getData")
    public static Object[][] jsonData() throws IOException {

        List<HashMap<String, String>> data =
                getJsonDataToMap(System.getProperty("user.dir")
                        + "/src/test/resources/data/TestData.json");

        Object[][] result = new Object[data.size()][1];
        for (int i = 0; i < data.size(); i++) {
            result[i][0] = data.get(i);
        }
        return result;
    }
}
