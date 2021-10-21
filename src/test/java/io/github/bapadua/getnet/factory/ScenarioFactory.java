package io.github.bapadua.getnet.factory;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.bapadua.getnet.domain.CustomerRequestDTO;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Objects;

public class ScenarioFactory {

    private static final String ROOT_RESOURCE_PATH = "/static/";
    private static final ObjectMapper mapper = new ObjectMapper();


    public static CustomerRequestDTO validCustomerRequest() throws IOException {
        return loadFile("200/create-customer.json", CustomerRequestDTO.class);
    }

    public static String validCustomerRequestJson() throws IOException, URISyntaxException {
        return loadJson("200/create-customer.json");
    }

    private static <T> T loadFile(final String path, final Class<T> valueType) throws IOException {
        final Resource resource = new ClassPathResource(ROOT_RESOURCE_PATH + path);
        return mapper.readValue(resource.getInputStream(), valueType);
    }

    private static String loadJson(String filePath) throws URISyntaxException, IOException {
        byte[] bytes = Files.readAllBytes(Paths.get(Objects.requireNonNull(ScenarioFactory.class.getClassLoader().getResource("static/" + filePath)).toURI()));
        return new String(bytes);
    }

}
