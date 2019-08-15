package io.github.aleknik.streetcamaggregator.repository.elasticsearch;

import io.github.aleknik.streetcamaggregator.model.elasticsearch.CameraIndexUnit;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface ESCameraRepository extends ElasticsearchRepository<CameraIndexUnit, String> {
}
