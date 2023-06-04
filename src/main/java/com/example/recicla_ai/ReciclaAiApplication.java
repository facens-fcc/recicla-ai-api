package com.example.recicla_ai;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;

import org.hibernate.Hibernate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.recicla_ai.dtos.CategoryDTO;
import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;
import com.example.recicla_ai.services.CategoryService;
import com.example.recicla_ai.services.CompanyService;

@SpringBootApplication
public class ReciclaAiApplication {

	@Bean
	public CommandLineRunner init(
		@Autowired CompanyRepository companyRepository,
		@Autowired CategoryRepository categoryRepository,
		@Autowired CompanyService companyService,
		@Autowired CategoryService categoryService) {
		return args -> {
			if (categoryRepository.count() == 0) {
				List <CategoryDTO> categoryDTOs = createDefaultCategories();

				for (CategoryDTO categoryDTO: categoryDTOs) {
					categoryService.create(categoryDTO);
				}
			}

			if (companyRepository.count() == 0) {
				List<CompanyDTO> companyDTOs = createDefaultCompanies();

				for (CompanyDTO companyDTO: companyDTOs) {
					companyService.create(companyDTO);
				}
			}
		};
	}

	private List <CategoryDTO> createDefaultCategories() {
		List <CategoryDTO> categoryDTOs = new ArrayList<>();

		categoryDTOs.add(CategoryDTO.builder()
			.label("Pilhas e Baterias")
			.icon("/assets/icons/battery-charging-energy.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Celulares e Tablets")
			.icon("/assets/icons/iphone-mobile.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Eletrodomésticos Pequenos")
			.icon("/assets/icons/microwave-oven-kitchen-appliances.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Eletrodomésticos Grandes")
			.icon("/assets/icons/washing-machine.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Equipamentos de Informática")
			.icon("/assets/icons/mouse.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Computadores e Vídeos Games")
			.icon("/assets/icons/computer-desktop.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Carregadores")
			.icon("/assets/icons/apple-lightning-connect.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Cabos e Fios")
			.icon("/assets/icons/plug-power-electricity.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Antenas")
			.icon("/assets/icons/wi-fi-wlan-connect-internet_signal_antenna.svg")
			.build());

		categoryDTOs.add(CategoryDTO.builder()
			.label("Lâmpadas")
			.icon("/assets/icons/light-bulb-idea.svg")
			.build());

		return categoryDTOs;
	}


	private List <CompanyDTO> createDefaultCompanies() {
		List <CompanyDTO> companyDTOs = new ArrayList<>();

		companyDTOs.add(CompanyDTO.builder()
			.name("Metareciclagem")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("34173825")
			.addressStreet("Av. Armando Sales de Oliveira")
			.addressNumber("762")
			.addressNeighborhood("Trujilo")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18060370")
			.lat(-23.49231)
			.lng(-47.47388)
			.payment(false)
			.residentialCollection(true)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L)))
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Coreso")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("32276608")
			.addressStreet("R. Chile")
			.addressNumber("401")
			.addressNeighborhood("Vila Barcelona")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18025280")
			.lat(-23.51331)
			.lng(-47.43692)
			.payment(false)
			.residentialCollection(true)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L)))
			.build());

		return companyDTOs;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReciclaAiApplication.class, args);
	}

}