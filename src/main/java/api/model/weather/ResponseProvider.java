package api.model.weather;

import lombok.Data;

public @Data
class ResponseProvider {

    private String[] data;

    public ResponseProvider(String[] providers) {
        this.data = providers;
    }
}
