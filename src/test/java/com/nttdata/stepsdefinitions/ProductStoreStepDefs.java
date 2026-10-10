package com.nttdata.stepsdefinitions;

import com.nttdata.steps.*;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;

import static com.nttdata.core.DriverManager.getDriver;
import static com.nttdata.core.DriverManager.screenShot;

public class ProductStoreStepDefs {
    private WebDriver webDriver;
    private LoginSteps loginSteps;
    private HomeSteps homeSteps;
    private SubCategorySteps subCategorySteps;
    private ProductDetailSteps productDetailSteps;
    private ModalProductCarSteps modalProductCarSteps;
    private ShoppingCartSteps shoppingCartSteps;

    @Given("estoy en la página de la tienda")
    public void estoyEnLaPáginaDeLaTienda() {
        webDriver = getDriver();
        webDriver.get("https://qalab.bensg.com/store");
        screenShot();
    }

    @And("me logueo con mi usuario {string} y clave {string}")
    public void meLogueoConMiUsuarioYClave(String usuario, String clave) {
        loginSteps = new LoginSteps(webDriver);
        loginSteps.login(usuario, clave);
        homeSteps = new HomeSteps(webDriver);

        String textLoginCorrect = homeSteps.redirectedHome();
        Assertions.assertEquals(textLoginCorrect, "Lucia Lopez");
        screenShot();
    }

    @When("navego a la categoria {string} y subcategoria {string}")
    public void navegoALaCategoriaYSubcategoriaSubcategoria(String categoria, String subcategoria) {
        homeSteps = new HomeSteps(webDriver);
        subCategorySteps = new SubCategorySteps(webDriver);
        homeSteps.buttonCategoryClothes();
        subCategorySteps.SelectProduct();
        screenShot();
    }

    @And("agrego {int} unidades del primer producto al carrito")
    public void agregoUnidadesDelPrimerProductoAlCarrito(int arg0) {
        productDetailSteps = new ProductDetailSteps(webDriver);
        productDetailSteps.clicButtonAddCar();
        screenShot();
    }

    @Then("valido en el popup la confirmación del producto agregado")
    public void validoEnElPopupLaConfirmaciónDelProductoAgregado() {
        modalProductCarSteps = new ModalProductCarSteps(webDriver);
        String TextCheckAddProduct =  modalProductCarSteps.messajeAddCheckProduct();
        Assertions.assertEquals(TextCheckAddProduct, "Producto añadido correctamente a su carrito de compra");
        screenShot();
    }

    @And("valido en el popup que el monto total sea calculado correctamente")
    public void validoEnElPopupQueElMontoTotalSeaCalculadoCorrectamente() {
        modalProductCarSteps = new ModalProductCarSteps(webDriver);
        double unitPrice = modalProductCarSteps.getUnitPrice();
        int quantity = modalProductCarSteps.getQuantity();
        double actualTotal = modalProductCarSteps.getTotalPrice();

        double expectedTotal = unitPrice * quantity;
        Assertions.assertEquals(expectedTotal,
                actualTotal, 0.01,
                "El monto total calculado no coincide. Esperado: " + expectedTotal + " | Obtenido: " + actualTotal);
        screenShot();

    }

    @When("finalizo la compra")
    public void finalizoLaCompra() {
        modalProductCarSteps = new ModalProductCarSteps(webDriver);
        modalProductCarSteps.cLicButtonEndBuy();
        screenShot();
    }

    @Then("valido el titulo de la pagina del carrito")
    public void validoElTituloDeLaPaginaDelCarrito() {
        shoppingCartSteps = new ShoppingCartSteps(webDriver);
        String titleShoppingCart =  shoppingCartSteps.validateTitleShoppingCart();
        Assertions.assertEquals(titleShoppingCart, "CARRITO");
        screenShot();
    }

    @And("vuelvo a validar el calculo de precios en el carrito")
    public void vuelvoAValidarElCalculoDePreciosEnElCarrito() {

    }

    @Then("valido que se muestre el mensaje de error {string}")
    public void validoQueSeMuestreElMensajeDeError(String text) {
        loginSteps = new LoginSteps(webDriver);
        String textLoginIncorrect =  loginSteps.loginIncorret();
        Assertions.assertEquals(textLoginIncorrect, text);
    }


}
