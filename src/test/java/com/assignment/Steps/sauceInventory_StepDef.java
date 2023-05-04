package com.assignment.Steps;

import com.assignment.pages.SwagLabsPage;
import com.assignment.utilities.Driver;
import com.assignment.utilities.TestUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import static com.assignment.utilities.TestUtils.WAIT_5S;

public class sauceInventory_StepDef {
    TestUtils testUtils;
    WebDriver driver;

    SwagLabsPage getSwagLabsPage = new SwagLabsPage();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(), WAIT_5S);

    public sauceInventory_StepDef() {
        this.testUtils = new TestUtils();
        this.driver = Driver.getDriver();
    }

    @Given("user open shopping website")
    public void user_open_shopping_website() {
       Assert.assertTrue(driver.getCurrentUrl().contains("saucedemo"));
       System.out.println("User is on Swag Labs page");
       Assert.assertEquals("Swag Labs", driver.getTitle());
    }

    @When("user login with {string}, {string} on Swag Labs")
    public void user_login_with_on_swag_labs(String userName, String passWord) {
        try {
            testUtils.waitForVisibility(getSwagLabsPage.userNameInput);
            wait.until(ExpectedConditions.elementToBeClickable(getSwagLabsPage.userNameInput)).sendKeys(userName);
            Assert.assertEquals(getSwagLabsPage.userNameInput.getAttribute("value"), userName);
            testUtils.waitForVisibility(getSwagLabsPage.passwordInput);
            wait.until(ExpectedConditions.elementToBeClickable(getSwagLabsPage.passwordInput)).sendKeys(passWord);
            Assert.assertEquals(getSwagLabsPage.passwordInput.getAttribute("value"), passWord);
            testUtils.click(getSwagLabsPage.loginButton);
            wait.until(ExpectedConditions.urlContains("inventory"));
        }catch (Exception e){
            if(getSwagLabsPage.errorMsg.isDisplayed()){
                System.out.println(getSwagLabsPage.errorMsg.getText());
                Assert.fail(getSwagLabsPage.errorMsg.getText());
            }
            Assert.fail("Invalid Credentials entered or Login button isn't working");
        }
    }

    @When("user add {string} item to cart and verify it")
    public void user_add_to_cart_items(String productName) {

        //verifying products page and inventory are displayed
        testUtils.waitForVisibility(getSwagLabsPage.currentPage);
        Assert.assertEquals("Products", getSwagLabsPage.currentPage.getText());
        Assert.assertTrue(getSwagLabsPage.products.stream().allMatch(WebElement::isDisplayed));
        Assert.assertTrue(getSwagLabsPage.shoppingCart.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.sortContainer.isDisplayed());


        //Verifying displayed inventory images
        for (int i = 0; i < getSwagLabsPage.productsImages.size(); i++) {
            for (int k = 0; k < getSwagLabsPage.productsImages.size(); k++) {
                Assert.assertNotSame(getSwagLabsPage.productsImages.get(i).getAttribute("src"), getSwagLabsPage.productsImages.get(k).getAttribute("src"));
            }
        }

        //Verifying displayed inventory titles
        for (int i = 0; i < getSwagLabsPage.productNames.size(); i++) {
            for (int k = 0; k < getSwagLabsPage.productNames.size(); k++) {
                Assert.assertNotSame(getSwagLabsPage.productsImages.get(i).getText(), getSwagLabsPage.productsImages.get(k).getText());
            }
        }

        if(productName.equalsIgnoreCase("Sauce Labs Backpack")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(0).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(0));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(0).getText());

        }else if(productName.equalsIgnoreCase("Sauce Labs Bike Light")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(1).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(1));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(1).getText());

        }else if(productName.equalsIgnoreCase("Sauce Labs Bolt T-Shirt")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(2).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(2));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(2).getText());

        }else if(productName.equalsIgnoreCase("Sauce Labs Fleece Jacket")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(3).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(3));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(3).getText());

        }else if(productName.equalsIgnoreCase("Sauce Labs Onesie")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(4).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(4));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(4).getText());

        }else if(productName.equalsIgnoreCase("Test.allTheThings() T-Shirt (Red)")){
            Assert.assertTrue(getSwagLabsPage.productNames.get(5).getText().contains(productName));
            testUtils.click(getSwagLabsPage.productsAddToCartBtn.get(5));
            System.out.println("Selected Item Name : " + getSwagLabsPage.productNames.get(5).getText());
        }

        testUtils.waitForVisibility(getSwagLabsPage.shoppingCartBadge);
        Assert.assertEquals("1", getSwagLabsPage.shoppingCartBadge.getText());
        Assert.assertTrue(getSwagLabsPage.productsRemoveFromCartBtn.get(0).isDisplayed());
        //Moving to your cart
        testUtils.click(getSwagLabsPage.shoppingCart);
        Assert.assertTrue(driver.getCurrentUrl().contains("cart"));
        Assert.assertEquals("Your Cart", getSwagLabsPage.currentPage.getText());
        Assert.assertEquals(getSwagLabsPage.cartItemsNames_List.getText(), productName);
        Assert.assertEquals("1", getSwagLabsPage.shoppingCartBadge.getText());
        Assert.assertTrue(getSwagLabsPage.productsRemoveFromCartBtn.get(0).isDisplayed());


        }

    @When("user move to Checkout Your Information window and fill FirstName, LastName, {string}")
    public void user_move_to_checkout_your_information_window_and_fill_first_name_last_name_zipcode(String zip) {
        Assert.assertTrue(getSwagLabsPage.checkoutBtn.isDisplayed());
        testUtils.click(getSwagLabsPage.checkoutBtn);
        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-one"));
        Assert.assertEquals("Checkout: Your Information", getSwagLabsPage.currentPage.getText());

        testUtils.waitForVisibility(getSwagLabsPage.firstNameInput);
        wait.until(ExpectedConditions.elementToBeClickable(getSwagLabsPage.firstNameInput)).sendKeys("firstName");
        Assert.assertEquals(getSwagLabsPage.firstNameInput.getAttribute("value"), "firstName");
        System.out.println("First Name Entered successfully");

        testUtils.waitForVisibility(getSwagLabsPage.lastNameInput);
        wait.until(ExpectedConditions.elementToBeClickable(getSwagLabsPage.lastNameInput)).sendKeys("lastName");
        Assert.assertEquals(getSwagLabsPage.lastNameInput.getAttribute("value"), "lastName");
        System.out.println("Last Name Entered successfully");

        testUtils.waitForVisibility(getSwagLabsPage.zipcodeInput);
        wait.until(ExpectedConditions.elementToBeClickable(getSwagLabsPage.zipcodeInput)).sendKeys(zip);
        Assert.assertEquals(getSwagLabsPage.zipcodeInput.getAttribute("value"), zip);



    }

    @When("user click on Continue button and move to Checkout Overview window and verify it")
    public void user_click_on_continue_button_and_move_to_checkout_overview_window_and_verify_it() {
        Assert.assertTrue(getSwagLabsPage.continueButton.isDisplayed());
        testUtils.click(getSwagLabsPage.continueButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-step-two"));
        Assert.assertEquals("Checkout: Overview", getSwagLabsPage.currentPage.getText());
        Assert.assertTrue(getSwagLabsPage.cartItemsNames_List.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.cartItemPrice.isDisplayed());

        Assert.assertTrue(getSwagLabsPage.paymentInfo.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.paymentCardInfo.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.shippingInfo.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.shippingAddressInfo.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.priceInfo.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.taxLabel.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.cart_subTotal.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.totalAmount.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.cart_subTotal.getText().contains(getSwagLabsPage.cartItemPrice.getText()));



    }

    @Then("user click on Finish button and verify Checkout Complete window")
    public void user_click_on_finish_button_and_verify_checkout_complete_window() {
        Assert.assertTrue(getSwagLabsPage.finishButton.isDisplayed());
        testUtils.click(getSwagLabsPage.finishButton);

        Assert.assertTrue(driver.getCurrentUrl().contains("checkout-complete"));
        testUtils.waitForVisibility(getSwagLabsPage.confirmationOrder);
        Assert.assertEquals("Checkout: Complete!", getSwagLabsPage.currentPage.getText());
        Assert.assertTrue(getSwagLabsPage.confirmationOrder.isDisplayed());
        Assert.assertTrue(getSwagLabsPage.confirmationMessage.isDisplayed());
        Assert.assertEquals("Thank you for your order!", getSwagLabsPage.confirmationOrder.getText());
        Assert.assertEquals(
                "Your order has been dispatched, and will arrive just as fast as the pony can get there!",
                getSwagLabsPage.confirmationMessage.getText()
        );

        Assert.assertTrue(getSwagLabsPage.backHome_button.isDisplayed());

    }

}
