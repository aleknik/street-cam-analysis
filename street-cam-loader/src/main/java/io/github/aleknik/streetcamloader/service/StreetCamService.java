package io.github.aleknik.streetcamloader.service;

import io.github.aleknik.streetcamloader.model.dto.TravelApiResponseWrapper;
import io.github.aleknik.streetcamloader.util.ImageDownloader;
import model.StreetCamInfo;
import org.springframework.beans.factory.annotation.Value;
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

//        airport (Airport)
//        area (Area)
//        bay (Bay)
//        beach (Beach)
//        building (Building)
//        camping (Camping)
//        city (City)
//        coast (Coast)
//        forest (Forest)
//        golf (Golfcourse)
//        harbor (Harbor)
//        resort (Holiday Resort)
//        island (Island)
//        lake (Lake/River)
//        marketplace (Marketplace)
//        mountain (Mountain/Canyon)
//        other (Other)
//        landscape (Outdoor)
//        park (Park)
//        pool (Pool)
//        indoor (Public Indoor)
//        meteo (Sky)
//        sportarea (Sport Area)
//        square (Square/Alley)
//        traffic (Street/Traffic)
//        underwater (Underwater)
//        water (Water)

@Service
public class StreetCamService {

    @Value("${camera-api-key}")
    private String cameraApiKey;

    private final RestTemplate restTemplate;

    public StreetCamService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<StreetCamInfo> getCameras(int limit, int offset) {

        String url = String.format("https://webcamstravel.p.rapidapi.com/webcams/list/orderby=popularity,desc/property=hd/limit=%d,%d", limit, offset);

        HttpHeaders headers = new HttpHeaders();
        headers.set("x-rapidapi-key", cameraApiKey);

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
                .filter(x -> !x.getImgBase64().isEmpty())
                .collect(Collectors.toList());
    }

    private String imageToBase64(String url) {
        final byte[] image = ImageDownloader.download(url);
        return Base64.getEncoder().encodeToString(image);
    }
}
