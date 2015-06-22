package com.bs.hzexample;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.stereotype.Component;

@SpringBootApplication
@Component
public class Main {

    public static void main(String... args) {
        ConfigurableApplicationContext ctx = new SpringApplicationBuilder(Main.class)
                .showBanner(false)
                .run(args);
        Main bean = ctx.getBean(Main.class);
        bean.init();
    }

    private void init() {

    }
}
