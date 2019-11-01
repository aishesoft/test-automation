package framework.webPages.DarkSky;
import framework.webPages.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.text.SimpleDateFormat;
import java.util.*;

public class DS_HomePage extends BasePage {

    private By darkSkyAPI = By.linkText("Dark Sky API");
    private By currentTemp = By.xpath("//span[@class='summary swap']");
    private By tempTimeLine = By.xpath("//div[@id='timeline']//div[@class='temps']");
    private By expandIcon = By.xpath("//body[@class='forecast']/div[@id='week']/a[1]/span[3]/span[1]/*[1]");
    private By minTemp = By.xpath("//a[1]//span[2]//span[1]");
    private By maxTemp = By.xpath("//span[@class='maxTemp']");
    private By compareToMinTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='temp']");
    private By compareToMaxTemp = By.xpath("//div[@class='dayDetails revealed']//span[@class='lowTemp swap']//span[1]");
    private By timeline = By.xpath("//div[@id='timeline']//div[@class='hours']/descendant::span//span");


    public void navigateToDarkSkyAPIPage() {
        clickOn(darkSkyAPI);
    }

    public int getCurrentTemperature() {
        String temp = webAction(currentTemp).getText().replaceAll("[^a-zA-Z0-9]", " ");
        String[] tempArr = temp.split(" ");
        return Integer.parseInt(tempArr[0]);
    }

    public int getMaxTemperatureFromTempLine(){
        return Arrays.stream(getTempFromTempLine()).max().getAsInt();
    }

    public int getMinTemperatureFromTempLine(){
        return Arrays.stream(getTempFromTempLine()).min().getAsInt();
    }

    private int[] getTempFromTempLine() {
        List<WebElement> element = webAction(tempTimeLine).findElements(tempTimeLine);
        String[] tempStrArr = new String[element.size()];
        for (WebElement ele : element) {
            for (int i=0; i < element.size(); i++) {
                tempStrArr[i] = ele.getText().replaceAll("[^0-9]", " ");
            }
        }
        String variable = tempStrArr[0];
        tempStrArr = variable.split("\\s+");
        int[] tempInt = new int[tempStrArr.length];
        for (int j = 0; j< tempStrArr.length; j++) {
            tempInt[j] = Integer.parseInt(tempStrArr[j]);
        }
        return tempInt;
    }

    public void scrollPage() {
        scrollByPixel(0, 900);
    }
    public void clickOnExpandIcon() {
        clickOn(expandIcon);
    }

    public int getMinTemperature() {
        return Integer.parseInt(webAction(minTemp).getText().replaceAll("[^a-zA-Z0-9]", ""));
    }

    public int getMaxTemperature() {
        return Integer.parseInt(webAction(maxTemp).getText().replaceAll("[^a-zA-Z0-9]", ""));
    }

    public int getCompareToMinTemperature() {
        return Integer.parseInt(webAction(compareToMinTemp).getText().replaceAll("[^a-zA-Z0-9]", ""));
    }

    public int getCompareToMaxTemperature() {
        return Integer.parseInt(webAction(compareToMaxTemp).getText().replaceAll("[^a-zA-Z0-9]", ""));
    }

    public ArrayList<String> getTodayHoursFromCalendar() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        ArrayList<String> timeArrayFromCalendar = new ArrayList<>();
        timeArrayFromCalendar.add(0, sdf.format(calendar.getTime()).toLowerCase());
        for (int i = 1; i < 12; i++) {
            calendar.add(Calendar.HOUR, 2);
            String time = sdf.format(calendar.getTime()).toLowerCase();
            timeArrayFromCalendar.add(time);
        }
        return timeArrayFromCalendar;
    }

    public ArrayList<String> getTimeFromTimeLineOnDarkSky() {
        List<WebElement> timeElement = webAction(timeline).findElements(timeline);
        ArrayList<String> timeArrFromDS = new ArrayList<>();
        for (WebElement e : timeElement) {
                timeArrFromDS.add(e.getText());
        }
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("ha");
        timeArrFromDS.set(0, sdf.format(calendar.getTime()).toLowerCase());
        return timeArrFromDS;
    }
}
