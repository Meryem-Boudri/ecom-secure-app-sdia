package ma.enset.inventoryservice;

import ma.enset.inventoryservice.entities.Product;
import ma.enset.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}

	@Bean
	CommandLineRunner commandLineRunner(ProductRepository productRepository){
		return args ->{
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer0").price(4300.0).quantity(12).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer1").price(2300.0).quantity(4).build());
			productRepository.save(Product.builder().id(UUID.randomUUID().toString()).name("Computer2").price(1300.0).quantity(2).build());
		};
	}

}
