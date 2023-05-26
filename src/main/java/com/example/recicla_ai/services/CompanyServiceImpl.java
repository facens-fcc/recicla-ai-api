package com.example.recicla_ai.services;

import org.springframework.stereotype.Service;

import com.example.recicla_ai.dtos.CompanyDTO;
import com.example.recicla_ai.dtos.SearchDataDTO;
import com.example.recicla_ai.exceptions.ApiErrors;
import com.example.recicla_ai.exceptions.BusinessRuleException;
import com.example.recicla_ai.models.Category;
import com.example.recicla_ai.models.Company;
import com.example.recicla_ai.repositories.CategoryRepository;
import com.example.recicla_ai.repositories.CompanyRepository;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import jakarta.transaction.Transactional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class CompanyServiceImpl implements CompanyService {
    private final CompanyRepository companyRepository;
    private final CategoryRepository categoryRepository;

    @Override
    @Transactional
    public Company create(CompanyDTO companyDTO) {

        Company company = new Company();
        company.setName(companyDTO.getName());
        company.setWhatsapp(companyDTO.isWhatsapp());
        company.setPhoneDdi(companyDTO.getPhoneDdi());
        company.setPhoneDdd(companyDTO.getPhoneDdd());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setAddressNeighborhood(companyDTO.getAddressNeighborhood());
        company.setAddressStreet(companyDTO.getAddressStreet());
        company.setAddressNumber(companyDTO.getAddressNumber());
        company.setState(companyDTO.getState());
        company.setCity(companyDTO.getCity());
        company.setZipCode(companyDTO.getZipCode());
        company.setLat(companyDTO.getLat());
        company.setLng(companyDTO.getLng());
        company.setPayment(companyDTO.isPayment());
        company.setResidentialCollection(companyDTO.isResidentialCollection());

        List<Category> categories = categoryRepository.findAllById(companyDTO.getCategoryIds());

        if (categories.isEmpty()) {
            throw new BusinessRuleException("Categoria não encontrada");
        }
        
        company.setCategories(categories);
        
        return companyRepository.save(company);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        companyRepository.deleteById(id);
    }

    @Override
    @Transactional
    public List<Company> getAll() {
        return companyRepository.findAll();
    }

    @Override
    @Transactional
    public void update(Long id, CompanyDTO companyDTO) {
        Company company = companyRepository.findById(id).orElseThrow(() -> new BusinessRuleException("Empresa não encontrada"));

        company.setName(companyDTO.getName());
        company.setWhatsapp(companyDTO.isWhatsapp());
        company.setPhoneDdi(companyDTO.getPhoneDdi());
        company.setPhoneDdd(companyDTO.getPhoneDdd());
        company.setPhoneNumber(companyDTO.getPhoneNumber());
        company.setAddressNeighborhood(companyDTO.getAddressNeighborhood());
        company.setAddressStreet(companyDTO.getAddressStreet());
        company.setAddressNumber(companyDTO.getAddressNumber());
        company.setState(companyDTO.getState());
        company.setCity(companyDTO.getCity());
        company.setZipCode(companyDTO.getZipCode());
        company.setLat(companyDTO.getLat());
        company.setLng(companyDTO.getLng());
        company.setPayment(companyDTO.isPayment());
        company.setResidentialCollection(companyDTO.isResidentialCollection());

        List<Category> categories = categoryRepository.findAllById(companyDTO.getCategoryIds());

        if (categories.isEmpty()) {
            throw new BusinessRuleException("Categoria não encontrada");
        }
        
        company.setCategories(categories);
        
        companyRepository.save(company);
    }

    public double toRad(double value) {
        return (value * Math.PI) / 180; // Converts numeric degrees to radians
    }

    private double calculateDistance(String destinationZipcode, String originZipcode) {
        // Retrieve the latitude and longitude coordinates for the given zip codes
        double[] destination = getCoordinatesForZipCode(destinationZipcode);
        double[] origin = getCoordinatesForZipCode(originZipcode);
    
        double R = 6371; // Radius of the earth in km
        double dLat = toRad(destination[0] - origin[0]);
        double dLon = toRad(destination[1] - origin[1]);
        double lat1 = toRad(origin[0]);
        double lat2 = toRad(destination[0]);
    
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.sin(dLon / 2) * Math.sin(dLon / 2) * Math.cos(lat1) * Math.cos(lat2);
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
        double d = R * c;
        return d;
    }

    private double[] getCoordinatesForZipCode(String zipcode) {
        try {
            String apiUrl = "https://maps.googleapis.com/maps/api/geocode/json";
            String encodedZipcode = URLEncoder.encode(zipcode, StandardCharsets.UTF_8);
            URI uri;
            try {
                uri = new URI(apiUrl + "?address=" + encodedZipcode + "&key=AIzaSyCDVRS2y-aVIXVmiyXnrCfg9ZiDBEiHQJM");
            } catch (URISyntaxException e) {
                throw new ApiErrors("Invalid URI syntax");
            }
    
            HttpURLConnection conn = (HttpURLConnection) uri.toURL().openConnection();
            conn.setRequestMethod("GET");
    
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                response.append(line);
            }
            reader.close();
    
            JsonObject json = JsonParser.parseString(response.toString()).getAsJsonObject();
            JsonObject location = json.getAsJsonArray("results").get(0).getAsJsonObject().getAsJsonObject("geometry").getAsJsonObject("location");
            double lat = location.get("lat").getAsDouble();
            double lng = location.get("lng").getAsDouble();
    
            return new double[]{lat, lng};
        } catch (IOException e) {
            throw new ApiErrors("Error occurred while making HTTP request");
        }
    }

//     public List<CompanyDTO> searchCompanies(SearchDataDTO searchData) {
//         String zipcode = searchData.getZipCode();
//         List<Long> categoryIds = searchData.getCategoryIds();
    
//         List<Company> companies = companyRepository.findAll();
    
//         List<CompanyDTO> filteredCompanies = companies.stream()
//                 .filter(company -> company.getCategories().stream()
//                         .anyMatch(category -> categoryIds.contains(category.getId())))
//                 .map(company -> {
//                     double distance = calculateDistance(zipcode, company.getZipCode());
//                     return new CompanyDTO(company.getId(), company.getName(), company.isWhatsapp(),
//                             company.getPhoneDdi(), company.getPhoneDdd(), company.getPhoneNumber(), company.getAddress(), company.getZipCode(),
//                             company.getLat(), company.getLng(), company.isPayment(),
//                             company.isResidentialCollection(), categoryIds, distance);
//                 })
//                 .collect(Collectors.toList());
    
//         filteredCompanies.sort(Comparator.comparingDouble(CompanyDTO::getDistance));
    
//         return filteredCompanies;
//     }
}
