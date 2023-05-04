package com.assignment.pages;

import com.assignment.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SwagLabsPage {
    public SwagLabsPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='user-name']")
    public WebElement userNameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//input[@id='login-button']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@class='error-message-container error']")
    public WebElement errorMsg;

    @FindBy(xpath = "//span[@class='title']")
    public WebElement currentPage;

    @FindBy(xpath = "//a[@class='shopping_cart_link']")
    public WebElement shoppingCart;

    @FindBy(xpath = "//a[@class='shopping_cart_link']/span")
    public WebElement shoppingCartBadge;

    @FindBy(xpath = "//select[@class='product_sort_container']")
    public WebElement sortContainer;

    @FindBy(xpath = "//div[@class='inventory_item']")
    public List<WebElement> products;

    @FindBy(xpath = "//div[@class='inventory_item']/div[2]/div/a/div")
    public List<WebElement> productNames;

    @FindBy(xpath = "//div[@class='cart_item_label']/a/div")
    public WebElement cartItemsNames_List;

    @FindBy(xpath = "//button[contains(text(), 'Checkout')]")
    public WebElement checkoutBtn;

    @FindBy(xpath = "//button[contains(text(), 'Add to cart')]")
    public List<WebElement> productsAddToCartBtn;

    @FindBy(xpath = "//div[@class='inventory_item']/div/a/img")
    public List<WebElement> productsImages;

    @FindBy(xpath = "//button[contains(text(), 'Remove')]")
    public List<WebElement> productsRemoveFromCartBtn;

    @FindBy(xpath = "//div[@class='cart_item_label']/div[2]/div")
    public WebElement cartItemPrice;

    @FindBy(xpath = "//input[@id='first-name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@id='last-name']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@id='postal-code']")
    public WebElement zipcodeInput;

    @FindBy(xpath = "//input[@id='continue']")
    public WebElement continueButton;

    @FindBy(xpath = "//button[@id='cancel']")
    public WebElement cancelButton;

    @FindBy(xpath = "//div[@class='summary_subtotal_label']")
    public WebElement cart_subTotal;

    @FindBy(xpath = "//button[@id='finish']")
    public WebElement finishButton;

    @FindBy(xpath = "//div[@class='summary_info_label'][contains(text(),'Payment')]")
    public WebElement paymentInfo;

    @FindBy(xpath = "//div[@class='summary_value_label'][contains(text(),'SauceCard')]")
    public WebElement paymentCardInfo;

    @FindBy(xpath = "//div[@class='summary_info_label'][contains(text(),'Shipping')]")
    public WebElement shippingInfo;

    @FindBy(xpath = "//div[@class='summary_value_label'][contains(text(),'Delivery')]")
    public WebElement shippingAddressInfo;

    @FindBy(xpath = "//div[@class='summary_info_label'][contains(text(),'Price')]")
    public WebElement priceInfo;

    @FindBy(xpath = "//div[@class='summary_tax_label']")
    public WebElement taxLabel;

    @FindBy(xpath = "//div[@class='summary_info_label summary_total_label']")
    public WebElement totalAmount;

    @FindBy(xpath = "//h2[@class='complete-header']")
    public WebElement confirmationOrder;

    @FindBy(xpath = "//div[@class='complete-text']")
    public WebElement confirmationMessage;

    @FindBy(xpath = "//button[@id='back-to-products']")
    public WebElement backHome_button;




}
