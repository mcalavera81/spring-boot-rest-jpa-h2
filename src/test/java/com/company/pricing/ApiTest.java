package com.company.pricing;

import java.time.LocalDateTime;

import org.apache.http.HttpStatus;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.Import;

import com.company.pricing.config.MyTestConfiguration;
import com.company.pricing.dto.PriceGetRequest;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@Import(MyTestConfiguration.class)
public class ApiTest {

  @LocalServerPort
  private int port;

  @BeforeEach
  public void setUp() {
    RestAssured.port = port;

  }

  final int productId = 35455;
  final String brand = "ZARA";

  //petición a las 10:00 del día 14 del producto 35455   para la brand 1 (ZARA)
  @Test
  public void scenario1() {
    ;
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-14T10:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("productId", CoreMatchers.is(productId))
        .body("brand", CoreMatchers.is(brand))
        .body("price", CoreMatchers.is("35.50"))
        .body("currency", CoreMatchers.is("EUR"))
        .body("priceList", CoreMatchers.is(1))
    ;

  }

  //petición a las 16:00 del día 14 del producto 35455   para la brand 1 (ZARA)
  @Test
  public void scenario2() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-14T16:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("productId", CoreMatchers.is(productId))
        .body("brand", CoreMatchers.is(brand))
        .body("price", CoreMatchers.is("25.45"))
        .body("currency", CoreMatchers.is("EUR"))
        .body("priceList", CoreMatchers.is(2))
    ;

  }

  // petición a las 21:00 del día 14 del producto 35455   para la brand 1 (ZARA)
  @Test
  public void scenario3() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-14T21:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("productId", CoreMatchers.is(productId))
        .body("brand", CoreMatchers.is(brand))
        .body("price", CoreMatchers.is("35.50"))
        .body("currency", CoreMatchers.is("EUR"))
        .body("priceList", CoreMatchers.is(1))
    ;

  }

  // petición a las 10:00 del día 15 del producto 35455   para la brand 1 (ZARA)
  @Test
  public void scenario4() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-15T10:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("productId", CoreMatchers.is(productId))
        .body("brand", CoreMatchers.is(brand))
        .body("price", CoreMatchers.is("30.50"))
        .body("currency", CoreMatchers.is("EUR"))
        .body("priceList", CoreMatchers.is(3))
    ;

  }

  // petición a las 21:00 del día 16 del producto 35455   para la brand 1 (ZARA)
  @Test
  public void scenario5() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-16T21:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("productId", CoreMatchers.is(productId))
        .body("brand", CoreMatchers.is(brand))
        .body("price", CoreMatchers.is("38.95"))
        .body("currency", CoreMatchers.is("EUR"))
        .body("priceList", CoreMatchers.is(4))
    ;

  }

  @Test
  public void scenarioBrandNotFound() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-16T21:00:00"), productId, "NO_BRAND");
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("message", CoreMatchers.is("Brand 'NO_BRAND' not found"))
        .body("path", CoreMatchers.is("/price"))
        .body("status", CoreMatchers.is(404))
        .body("error", CoreMatchers.is("Not Found"))
        ;
  }

  @Test
  public void scenarioProductNotFound() {
    Integer productNotFound = -1;
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-16T21:00:00"), productNotFound, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("message", CoreMatchers.is("Product '-1' not found"))
        .body("path", CoreMatchers.is("/price"))
        .body("status", CoreMatchers.is(404))
        .body("error", CoreMatchers.is("Not Found"))
    ;
  }

  @Test
  public void scenarioPriceNotFound() {
    PriceGetRequest request = new PriceGetRequest(LocalDateTime.parse("2020-06-13T21:00:00"), productId, brand);
    given().contentType(ContentType.JSON)
        .body(request)
        .post("price")
        .then()
        .statusCode(HttpStatus.SC_OK)
        .body("message", CoreMatchers.is("Price not found for brand 'ZARA' and product '35455'"))
        .body("path", CoreMatchers.is("/price"))
        .body("status", CoreMatchers.is(404))
        .body("error", CoreMatchers.is("Not Found"))
    ;
  }
}
