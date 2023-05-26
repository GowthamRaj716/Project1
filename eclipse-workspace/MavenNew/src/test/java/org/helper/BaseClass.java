package org.helper;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver driver;
	public static Actions a;
	public static Robot r;
	public static Alert ac;
	public static JavascriptExecutor js;
	public static TakesScreenshot ts;
	public static Select s;

	public static void openChromeBrowser() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void openEdgeBrowser() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
	}

	public static void closeCurrentTab() {
		driver.close();
	}

	public static void closeBrowser() {
		driver.quit();
	}

	public static void maxWindow() {
		driver.manage().window().maximize();
	}

	public static void minWindow() {
		driver.manage().window().minimize();
		;
	}

	public static void launchUrl(String url) {
		driver.get(url);
	}

	public static String fetchTitle() {
		String title = driver.getTitle();
		return title;
	}

	public static String fetchUrl() {
		String url = driver.getCurrentUrl();
		return url;
	}

	public static void reload() {
		driver.navigate().refresh();
	}

	public static void prevPage() {
		driver.navigate().back();
	}

	public static void nextPage() {
		driver.navigate().forward();
	}

	public static void holdExecution(int milliSecond) throws InterruptedException {
		Thread.sleep(milliSecond);
	}

	public static void fillTextBox(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void toClickButton(WebElement element) {
		element.click();
	}

	public static void printTextValue(WebElement element) {
		String text = element.getText();
		System.out.println(text);
	}

	public static String fetchAttributeValue(WebElement element, String attributeName) {
		String attribute = element.getAttribute(attributeName);
		return attribute;
	}

	public static void moveToCursor(WebElement targetElement) {
		a = new Actions(driver);
		a.moveToElement(targetElement).perform();
	}

	public static void dragDrop(WebElement sourceElement, WebElement destinationElement) {
		a = new Actions(driver);
		a.dragAndDrop(sourceElement, destinationElement).perform();
	}

	public static void doubleClicking(WebElement targetElement) {
		a = new Actions(driver);
		a.doubleClick(targetElement).perform();
	}

	public static void rightClicking(WebElement targetElement) {
		a = new Actions(driver);
		a.contextClick(targetElement).perform();
	}

	public static void copy() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_C);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_C);
	}

	public static void paste() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_V);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_V);
	}

	public static void allSelect() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_CONTROL);
		r.keyPress(KeyEvent.VK_A);
		r.keyRelease(KeyEvent.VK_CONTROL);
		r.keyRelease(KeyEvent.VK_A);
	}

	public static void tabKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_TAB);
		r.keyRelease(KeyEvent.VK_TAB);
	}

	public static void smallToCaptial(WebElement targetElement, String name) {
		a = new Actions(driver);
		a.keyDown(Keys.SHIFT).sendKeys(targetElement, name).keyUp(Keys.SHIFT).perform();
	}

	public static void enterKey() throws AWTException {
		r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);
	}

	public static void handleSimpleAlert() {
		ac = driver.switchTo().alert();
		ac.accept();
	}

	public static void cancelConfirmDismissAlert() {
		ac = driver.switchTo().alert();
		ac.dismiss();
	}

	public static void textValueAlert() {
		ac = driver.switchTo().alert();
		String text2 = ac.getText();
		System.out.println(text2);
	}

	public static void promptAlertwithSendValues(String name) {
		ac = driver.switchTo().alert();
		ac.sendKeys(name);
		ac.accept();
	}

	public static void frametoSwitch(WebElement frameElement) {
		driver.switchTo().frame(frameElement);
	}

	public static void parentFrameToSwitch() {
		driver.switchTo().parentFrame();
	}

	public static void defaultFrameToSwitch() {
		driver.switchTo().defaultContent();
	}

	public static void javaScriptExeSendKeys(WebElement element, String input) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].setAttribute('value','" + input + "')", element);
	}

	public static void javaScriptExeClick(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click()", element);
	}

	public static void ScrollDown(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollntoView(true)", element);
	}

	public static void ScrollUp(WebElement element) {
		js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollntoView(false)", element);
	}

	public static void screenShot(String imgname) throws IOException {
		ts = (TakesScreenshot) driver;
		File sr = ts.getScreenshotAs(OutputType.FILE);
		File de = new File("C:\\Users\\LENOVO\\eclipse-workspace\\Maven\\Screenshot\\" + imgname + ".png");
		FileUtils.copyFile(sr, de);
	}

	public static void parentId() {
		String parentId = driver.getWindowHandle();
		System.out.println(parentId);
	}

	public static void selectIndex(WebElement element, int index) {
		s = new Select(element);
		s.selectByIndex(index);
	}

	public static void selectVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.selectByVisibleText(text);
	}

	public static void selectValue(WebElement element, String value) {
		s = new Select(element);
		s.selectByValue(value);
	}

	public static void deselectIndex(WebElement element, int index) {
		s = new Select(element);
		s.deselectByIndex(index);
	}

	public static void deselectVisibleText(WebElement element, String text) {
		s = new Select(element);
		s.deselectByVisibleText(text);
	}

	public static void deselectValue(WebElement element, String value) {
		s = new Select(element);
		s.deselectByValue(value);
	}

	public static void deselectAllValue(WebElement element) {
		s = new Select(element);
		s.deselectAll();
	}

	public static void multipleDropDown(WebElement element, int index) {
		s = new Select(element);
		if (s.isMultiple()) {
			System.out.println("More than One Drop Down is there");
		} else {
			System.out.println("Multiple DropDown");
		}
	}

	public static void getAllOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> options = s.getOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement allOptions = options.get(i);
			System.out.println(allOptions);
		}
	}

	public static void AllSelectedOptions(WebElement element) {
		s = new Select(element);
		List<WebElement> options = s.getAllSelectedOptions();
		for (int i = 0; i < options.size(); i++) {
			WebElement allSelectedOptions = options.get(i);
			System.out.println(allSelectedOptions);
		}
	}

	public static void firstSelectedOption(WebElement element) {
		s = new Select(element);
		WebElement firstSelectedOption = s.getFirstSelectedOption();
		System.out.println(firstSelectedOption);
	}

	public static void displayedOption(WebElement element) {
		if (element.isDisplayed()) {
			System.out.println("It is Displayed in Webpage");
		} else {
			System.out.println("It is not displayed in Webpage");
		}
	}

	public static void enabledOption(WebElement element) {
		if (element.isEnabled()) {
			System.out.println("It is Enabled in Webpage");
		} else {
			System.out.println("It is not enabled in Webpage");
		}
	}

	public static void selectedOption(WebElement element) {
		if (element.isSelected()) {
			System.out.println("It is Selected in Webpage");
		} else {
			System.out.println("It is not selected in Webpage");
		}
	}

	public static void childWindowSelect(int childWindowNumber) {
		Set<String> allWindowId = driver.getWindowHandles();
		List<String> allId = new ArrayList<String>(allWindowId);
		driver.switchTo().window(allId.get(childWindowNumber));
	}

	public static String readDataFromExcel(String sheetName, int rowNo, int cellNo) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\CucumberProject\\DataMaintance\\Hello.xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell c = r.getCell(cellNo);
		int type = c.getCellType();
		String input;
		if (type == 1) {
			input = c.getStringCellValue();
		} else if (DateUtil.isCellDateFormatted(c)) {
			Date da = c.getDateCellValue();
			SimpleDateFormat sim = new SimpleDateFormat("dd-MM-yyyy");
			input = sim.format(da);
		} else {
			double d = c.getNumericCellValue();
			long l = (long) d;
			input = String.valueOf(l);
		}
		return input;
	}

	public static String writeExistingFile(String xlSheetName, String sheetName, int rowNo, int cellNo,
			String cellValue) throws IOException {
		File f = new File("C:\\Users\\LENOVO\\eclipse-workspace\\Maven\\DataMaintance\\" + xlSheetName + ".xlsx");
		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);
		Sheet sh = book.getSheet(sheetName);
		Row r = sh.getRow(rowNo);
		Cell c = r.createCell(cellNo);
		c.setCellValue(cellValue);
		FileOutputStream fout = new FileOutputStream(f);
		book.write(fout);
		return sheetName;
	}

	public static void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	public static void getDateAndTime() {
		Date d = new Date();
		System.out.println(d);
	}

}
