package timyates;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class DWMain extends Application<Config> {
    @Override
    public void run(Config configuration, Environment environment) throws Exception {
        environment.jersey().register(new Resource());
    }

    public static void main(String[] args) throws Exception {
        new DWMain().run("server");
    }
}
