package project.util;

import lombok.Getter;

import java.util.List;

@Getter
public class ModelWithTotalCount<T> {
    private List<T> models;
    private Long count;

    public ModelWithTotalCount(List<T> models, Long count) {
        this.models = models;
        this.count = count;
    }
}
