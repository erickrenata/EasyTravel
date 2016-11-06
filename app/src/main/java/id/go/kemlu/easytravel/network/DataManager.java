package id.go.kemlu.easytravel.network;

import javax.inject.Inject;

/**
 * Created by Erick Renata on 05/11/2016.
 */

public class DataManager {

    private final ApiService apiService;

    @Inject
    public DataManager(ApiService apiService) {
        this.apiService = apiService;
    }
}
