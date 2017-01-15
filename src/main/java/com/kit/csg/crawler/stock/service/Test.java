package com.kit.csg.crawler.stock.service;/**
 * Created by eric on 2017/1/15.
 */

import com.kit.csg.utils.HTTPUtils;
import javafx.application.Application;
import javafx.stage.Stage;

public class Test extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        String baseUrl = "http://api.k780.com:88/?app=finance.globalindex&appkey=19264&sign=627a9ccb533cc051bd341cbce1e1ee1f&format=json";
        String jsonStr = HTTPUtils.getHtml(baseUrl);
        System.out.println(jsonStr);

    }
}
