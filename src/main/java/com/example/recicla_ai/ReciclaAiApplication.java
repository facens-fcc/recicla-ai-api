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
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
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
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Coreso")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("32276608")
			.addressStreet("R. José Henrique Dias")
			.addressNumber("215")
			.addressNeighborhood("Vitória Régia")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18078395")
			.lat(-23.42858)
			.lng(-47.45544)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Cooperativa de Col. Sel. Reviver")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("33261903")
			.addressStreet("R. Ourinhos")
			.addressNumber("241")
			.addressNeighborhood("Jd. Leocadia")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18085460")
			.lat(-23.47211)
			.lng(-47.43923)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Resotech Ambiental")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("997990984")
			.addressStreet("R. Estanislau Camargo Sampaio")
			.addressNumber("680")
			.addressNeighborhood("Jd. Luciana Maria")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18071325")
			.lat(-23.46715)
			.lng(-47.50880)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 5L, 6L, 7L, 8L, 9L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Império Sucatas")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("991953191")
			.addressStreet("R. Catalunha")
			.addressNumber("125")
			.addressNeighborhood("Vila Hortência")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18020242")
			.lat(-23.50824)
			.lng(-47.44222)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L)))
			.payment(true)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Recicla Sorocaba")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("996995301")
			.addressStreet("Av. Ipanema")
			.addressNumber("3345")
			.addressNeighborhood("Jd. Planalto")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18071801")
			.lat(-23.46832)
			.lng(-47.49347)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 5L, 6L, 7L, 8L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("INFOBOM")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("988109371")
			.addressStreet("Av. Edward Fru Fru Marciano da Silva")
			.addressNumber("1159")
			.addressNeighborhood("Jd. São Guilherme II")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18074621")
			.lat(-23.44618)
			.lng(-47.49176)
			.categoryIds(new HashSet<>(Arrays.asList(5L, 6L)))
			.payment(true)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Ecoponto - Vila Helena")
			.whatsapp(false)
			.phoneDdi("")
			.phoneDdd("")
			.phoneNumber("156")
			.addressStreet("R. Roque Sampaio")
			.addressNumber("100")
			.addressNeighborhood("Vila Helena")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18066220")
			.lat(-23.477486)
			.lng(-47.493161)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Coreso")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("997159789")
			.addressStreet("R. Encarnação Rando Castellucci")
			.addressNumber("70")
			.addressNeighborhood("Vila Colorau")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18020440")
			.lat(-23.51322)
			.lng(-47.43512)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Ecoponto - Vila Hortência")
			.whatsapp(false)
			.phoneDdi("")
			.phoneDdd("")
			.phoneNumber("156")
			.addressStreet("R. Lourenço Molinero")
			.addressNumber("85")
			.addressNeighborhood("Vila Hortência")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18015063")
			.lat(-23.502874)
			.lng(-47.439862)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Casas Bahia")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("33315200")
			.addressStreet("R. Dr. Álvaro Soares")
			.addressNumber("48")
			.addressNeighborhood("Centro")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18010190")
			.lat(-23.49834)
			.lng(-47.45884)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Coop")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("32392911")
			.addressStreet("Av. Itavuvu")
			.addressNumber("3799")
			.addressNeighborhood("Jd. Santa Cecilia")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18078005")
			.lat(-23.45267)
			.lng(-47.48289)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("TIM")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("40030941")
			.addressStreet("Praça Cel. Fernando Prestes")
			.addressNumber("46")
			.addressNeighborhood("Centro")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18010160")
			.lat(-23.49982)
			.lng(-47.45758)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 5L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Cooperativa de Votorantim - Coopervot")
			.whatsapp(true)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("997967641")
			.addressStreet("Av. Jaziel de Azeredo Ribeiro")
			.addressNumber("680")
			.addressNeighborhood("Jd. Antonio Cassillo")
			.city("Votorantim")
			.state("SP")
			.zipCode("18112180")
			.lat(-23.52723)
			.lng(-47.43377)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 4L, 5L, 6L, 10L, 7L, 8L, 9L)))
			.payment(false)
			.residentialCollection(true)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("SEMA - Secretaria do Meio Ambiente")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("32192280")
			.addressStreet("R. Santa Maria")
			.addressNumber("197")
			.addressNeighborhood("Vila Hortência")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18020216")
			.lat(-23.50540)
			.lng(-47.44882)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 5L, 6L, 7L, 8L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Fast Shop - Shopping Iguatemi Esplanada")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("34154058")
			.addressStreet("Av. Gisele Constantino")
			.addressNumber("1850")
			.addressNeighborhood("Parque Bela Vista")
			.city("Votorantim")
			.state("SP")
			.zipCode("18110650")
			.lat(-23.53530)
			.lng(-47.46230)
			.categoryIds(new HashSet<>(Arrays.asList(2L, 3L, 5L, 6L, 7L, 8L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Carrefour Sorocaba - Norte")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("33329675")
			.addressStreet("Av. Brasil")
			.addressNumber("376")
			.addressNeighborhood("Terra Vermelha")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18065100")
			.lat(-23.48649)
			.lng(-47.47119)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 6L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Dicico - Shopping Esplanada Sorocaba")
			.whatsapp(false)
			.phoneDdi("")
			.phoneDdd("")
			.phoneNumber("08007634622")
			.addressStreet("Av. Gisele Constantino")
			.addressNumber("401")
			.addressNeighborhood("Parque Bela Vista")
			.city("Votorantim")
			.state("SP")
			.zipCode("18047900")
			.lat(-23.53374)
			.lng(-47.46309)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 6L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Facens")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("32381188")
			.addressStreet("Rodovia Senador José Ermírio de Moraes")
			.addressNumber("1425")
			.addressNeighborhood("Alto da Boa Vista")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18087125")
			.lat(-23.46985)
			.lng(-47.42980)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Kalunga")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("11")
			.phoneNumber("33469966")
			.addressStreet("Av. Dom Aguirre")
			.addressNumber("2121")
			.addressNeighborhood("Jd. Santa Rosália")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18090002")
			.lat(-23.49220)
			.lng(-47.44516)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 6L)))
			.payment(false)
			.residentialCollection(false)
        	.build());	

		companyDTOs.add(CompanyDTO.builder()
			.name("Leroy Merlin")
			.whatsapp(false)
			.phoneDdi("")
			.phoneDdd("")
			.phoneNumber("08000205376")
			.addressStreet("Rodovia Raposo Tavares")
			.addressNumber("km 101")
			.addressNeighborhood("Parque Reserva Fazenda Imperial")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18052775")
			.lat(-23.53314)
			.lng(-47.47629)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 6L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Makro Zona Norte")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("33162720")
			.addressStreet("R. João Ribeiro de Barros")
			.addressNumber("1411")
			.addressNeighborhood("Vila Odim Antao")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18090602")
			.lat(-23.47065)
			.lng(-47.45487)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Sam's Club")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("21013700")
			.addressStreet("Av. Antônio Carlos Comitre")
			.addressNumber("80")
			.addressNeighborhood("Parque Campolim")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18047620")
			.lat(-23.51731)
			.lng(-47.46551)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 5L, 6L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Senac")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("34122500")
			.addressStreet("Av. Cel. Nogueira Padilha")
			.addressNumber("2392")
			.addressNeighborhood("Vila Hortênia")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18020003")
			.lat(-23.51277)
			.lng(-47.43180)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		companyDTOs.add(CompanyDTO.builder()
			.name("Sesc")
			.whatsapp(false)
			.phoneDdi("55")
			.phoneDdd("15")
			.phoneNumber("33329933")
			.addressStreet("R. Barão de Piratininga")
			.addressNumber("555")
			.addressNeighborhood("Jd. Faculdade")
			.city("Sorocaba")
			.state("SP")
			.zipCode("18030160")
			.lat(-23.51352)
			.lng(-47.46063)
			.categoryIds(new HashSet<>(Arrays.asList(1L, 2L, 3L, 4L, 5L, 6L, 7L, 8L, 9L, 10L)))
			.payment(false)
			.residentialCollection(false)
			.build());

		return companyDTOs;
	}

	public static void main(String[] args) {
		SpringApplication.run(ReciclaAiApplication.class, args);
	}

}