package io.github.aleknik.streetcamloader.service;

import io.github.aleknik.streetcamloader.model.dto.TravelApiResponseWrapper;
import io.github.aleknik.streetcamloader.util.ImageDownloader;
import model.StreetCamInfo;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Base64;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StreetCamService {

    private final RestTemplate restTemplate;

    public StreetCamService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<StreetCamInfo> getCameras() {

        String url = "https://webcamstravel.p.rapidapi.com/webcams/list/category=traffic/orderby=popularity";

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", "0b89c7c422msh7784d5c4cfba68ep1b446cjsn77ba16461134");

        UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(url)
                .queryParam("lang", "en")
                .queryParam("show", "webcams:image,location");

        HttpEntity<?> entity = new HttpEntity<>(headers);

        HttpEntity<TravelApiResponseWrapper> response = restTemplate.exchange(
                builder.toUriString(),
                HttpMethod.GET,
                entity,
                TravelApiResponseWrapper.class);

        return response.getBody().getResult().getWebcams().stream()
                .map(x -> new StreetCamInfo(x.getId(),
                        x.getTitle(),
                        x.getImage().getCurrent().getPreview(),
                        imageToBase64(x.getImage().getCurrent().getPreview()),
                        x.getLocation().getLatitude(),
                        x.getLocation().getLongitude(),
                        new Date()))
                .collect(Collectors.toList());
    }

    private String imageToBase64(String url) {
        final byte[] image = ImageDownloader.download(url);
        return Base64.getEncoder().encodeToString(image);
    }
}
